package com.tencent.liteav.videodecoder;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

public class TXCVideoDecoder
  implements com.tencent.liteav.basic.b.b, g
{
  private static final boolean NEW_DECODER = true;
  private static final String TAG = "TXCVideoDecoder";
  private static long mDecodeFirstFrameTS;
  private JSONArray mDecFormat = null;
  private int mDecoderCacheNum;
  private TXCVideoDecoder.a mDecoderHandler;
  g mDecoderListener;
  private boolean mEnableDecoderChange = false;
  private boolean mEnableLimitDecCache = false;
  private boolean mEnableRestartDecoder = false;
  boolean mHWDec = true;
  boolean mHevc = false;
  private ArrayList<TXSNALPacket> mNALList = new ArrayList();
  private long mNativeContext;
  boolean mNeedSortFrame = true;
  private WeakReference<com.tencent.liteav.basic.b.b> mNotifyListener;
  private ByteBuffer mPps;
  boolean mRecvFirstFrame = false;
  private boolean mRestarting = false;
  private ByteBuffer mSps;
  private int mStreamType = 0;
  Surface mSurface;
  private String mUserId;
  b mVideoDecoder;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  
  static
  {
    com.tencent.liteav.basic.util.f.f();
  }
  
  public TXCVideoDecoder()
  {
    mDecodeFirstFrameTS = 0L;
  }
  
  private void addOneNalToDecoder(TXSNALPacket paramTXSNALPacket)
  {
    boolean bool;
    if (paramTXSNALPacket.nalType == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("iframe", bool);
    ((Bundle)localObject).putByteArray("nal", paramTXSNALPacket.nalData);
    ((Bundle)localObject).putLong("pts", paramTXSNALPacket.pts);
    ((Bundle)localObject).putLong("dts", paramTXSNALPacket.dts);
    ((Bundle)localObject).putInt("codecId", paramTXSNALPacket.codecId);
    paramTXSNALPacket = new Message();
    paramTXSNALPacket.what = 101;
    paramTXSNALPacket.setData((Bundle)localObject);
    localObject = this.mDecoderHandler;
    if (localObject != null) {
      ((Handler)localObject).sendMessage(paramTXSNALPacket);
    }
    this.mDecoderCacheNum += 1;
  }
  
  private void decNALByNewWay(TXSNALPacket paramTXSNALPacket)
  {
    if (this.mHWDec)
    {
      decodeFrame(paramTXSNALPacket.nalData, paramTXSNALPacket.pts, paramTXSNALPacket.dts, paramTXSNALPacket.rotation, paramTXSNALPacket.codecId, 0, 0, paramTXSNALPacket.nalType);
      return;
    }
    try
    {
      nativeDecodeFrame(this.mNativeContext, paramTXSNALPacket.nalData, paramTXSNALPacket.nalType, paramTXSNALPacket.pts, paramTXSNALPacket.dts, paramTXSNALPacket.rotation, paramTXSNALPacket.codecId);
      return;
    }
    finally {}
  }
  
  private void decNALByOldWay(TXSNALPacket paramTXSNALPacket)
  {
    for (;;)
    {
      try
      {
        if (paramTXSNALPacket.nalType != 0) {
          break label216;
        }
        i = 1;
        if ((!this.mRecvFirstFrame) && (i == 0))
        {
          TXCLog.i("TXCVideoDecoder", "play:decode: push nal ignore p frame when not got i frame");
          return;
        }
        if ((!this.mRecvFirstFrame) && (i != 0))
        {
          TXCLog.w("TXCVideoDecoder", "play:decode: push first i frame");
          this.mRecvFirstFrame = true;
        }
        if ((!this.mRestarting) && (paramTXSNALPacket.codecId == 1) && (!this.mHWDec))
        {
          TXCLog.w("TXCVideoDecoder", "play:decode: hevc decode error  ");
          com.tencent.liteav.basic.util.f.a(this.mNotifyListener, -2304, "h265 Decoding failed");
          this.mRestarting = true;
        }
        if (this.mDecoderHandler != null)
        {
          if (!this.mNALList.isEmpty())
          {
            Iterator localIterator = this.mNALList.iterator();
            if (localIterator.hasNext())
            {
              addOneNalToDecoder((TXSNALPacket)localIterator.next());
              continue;
            }
          }
          this.mNALList.clear();
          addOneNalToDecoder(paramTXSNALPacket);
          return;
        }
        if ((i != 0) && (!this.mNALList.isEmpty())) {
          this.mNALList.clear();
        }
        this.mNALList.add(paramTXSNALPacket);
        if (!this.mRestarting)
        {
          start();
          return;
        }
      }
      catch (Exception paramTXSNALPacket)
      {
        TXCLog.e("TXCVideoDecoder", "decode NAL By Old way failed.", paramTXSNALPacket);
      }
      return;
      label216:
      int i = 0;
    }
  }
  
  private void decodeFrame(byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    TXSNALPacket localTXSNALPacket = new TXSNALPacket();
    localTXSNALPacket.nalData = paramArrayOfByte;
    localTXSNALPacket.pts = paramLong1;
    localTXSNALPacket.dts = paramLong2;
    localTXSNALPacket.rotation = paramInt1;
    localTXSNALPacket.codecId = paramInt2;
    localTXSNALPacket.nalType = paramInt5;
    try
    {
      if ((this.mNativeContext != 0L) && (this.mVideoDecoder == null))
      {
        if (paramInt2 == 1) {
          this.mHevc = true;
        } else {
          this.mHevc = false;
        }
        paramArrayOfByte = new f();
        paramArrayOfByte.a(paramInt3, paramInt4);
        paramArrayOfByte.setListener(this);
        paramArrayOfByte.setNotifyListener(new WeakReference(this));
        paramArrayOfByte.a(this.mDecFormat);
        paramArrayOfByte.config(this.mSurface);
        paramArrayOfByte.enableLimitDecCache(this.mEnableLimitDecCache);
        paramArrayOfByte.start(this.mSps, this.mPps, this.mNeedSortFrame, this.mHevc);
        notifyDecoderStartEvent(true, this.mHevc);
        this.mVideoDecoder = paramArrayOfByte;
      }
      if (this.mVideoDecoder != null) {
        this.mVideoDecoder.decode(localTXSNALPacket);
      }
      return;
    }
    finally {}
  }
  
  private boolean hasSurface()
  {
    return this.mSurface != null;
  }
  
  private native long nativeCreateContext(boolean paramBoolean, Object paramObject);
  
  private native void nativeDecCache(long paramLong);
  
  private native void nativeDecodeFrame(long paramLong1, byte[] paramArrayOfByte, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3);
  
  private native void nativeDestroyContext(long paramLong);
  
  private native void nativeEnableDecodeChange(long paramLong, boolean paramBoolean);
  
  private native void nativeEnableRestartDecoder(long paramLong, boolean paramBoolean);
  
  private native void nativeNotifyHWDecoderError(long paramLong);
  
  private native void nativeNotifyPts(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native void nativeReStart(long paramLong, boolean paramBoolean);
  
  private native void nativeSetID(long paramLong, String paramString);
  
  private native void nativeSetStreamType(long paramLong, int paramInt);
  
  private void notifyDecoderStartEvent(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = this.mUserId;
    long l2 = 1L;
    long l1;
    if (paramBoolean1) {
      l1 = 1L;
    } else {
      l1 = 0L;
    }
    TXCEventRecorderProxy.a(str, 4005, l1, -1L, "", this.mStreamType);
    reportDecoderEvent(paramBoolean1, paramBoolean2);
    str = this.mUserId;
    if (paramBoolean1) {
      l1 = l2;
    } else {
      l1 = 2L;
    }
    TXCKeyPointReportProxy.a(str, 40026, l1, this.mStreamType);
  }
  
  private void onDecodeDone(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4)
  {
    if (mDecodeFirstFrameTS == 0L)
    {
      mDecodeFirstFrameTS = TXCTimeUtil.getTimeTick();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[FirstFramePath][Video][Decoder] TXCVideoDecoder: decode first frame success. instance:");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append(" isHWAcc:false isHEVC:");
      ((StringBuilder)localObject).append(this.mHevc);
      ((StringBuilder)localObject).append(" userId:");
      ((StringBuilder)localObject).append(this.mUserId);
      ((StringBuilder)localObject).append(" type:");
      ((StringBuilder)localObject).append(this.mStreamType);
      TXCLog.i("TXCVideoDecoder", ((StringBuilder)localObject).toString());
      TXCStatus.a(this.mUserId, 5005, this.mStreamType, Long.valueOf(mDecodeFirstFrameTS));
      int i;
      if (this.mHevc) {
        i = 2;
      } else {
        i = 0;
      }
      TXCStatus.a(this.mUserId, 5004, this.mStreamType, Integer.valueOf(i));
    }
    Object localObject = this.mDecoderListener;
    if (localObject != null)
    {
      paramTXSVideoFrame.width = paramInt1;
      paramTXSVideoFrame.height = paramInt2;
      paramTXSVideoFrame.rotation = paramInt3;
      paramTXSVideoFrame.pts = paramLong1;
      paramTXSVideoFrame.frameType = paramInt4;
      ((g)localObject).onDecodeFrame(paramTXSVideoFrame, paramInt1, paramInt2, paramLong1, paramLong2, paramInt3);
      if ((this.mVideoWidth != paramInt1) || (this.mVideoHeight != paramInt2))
      {
        this.mVideoWidth = paramInt1;
        this.mVideoHeight = paramInt2;
        ((g)localObject).onVideoSizeChange(this.mVideoWidth, this.mVideoHeight);
      }
    }
  }
  
  private void onStartDecoder(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mHevc = paramBoolean2;
    notifyDecoderStartEvent(paramBoolean1, this.mHevc);
  }
  
  private void reportDecoderEvent(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("EVT_ID", 2008);
    ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    StringBuilder localStringBuilder = new StringBuilder("Enables ");
    if (paramBoolean2) {
      localStringBuilder.append("HEVC ");
    } else {
      localStringBuilder.append("H264 ");
    }
    if (paramBoolean1) {
      localStringBuilder.append("hardware ");
    } else {
      localStringBuilder.append("software ");
    }
    localStringBuilder.append("decoding");
    ((Bundle)localObject).putCharSequence("EVT_MSG", localStringBuilder.toString());
    int i;
    if (paramBoolean1) {
      i = 1;
    } else {
      i = 2;
    }
    ((Bundle)localObject).putInt("EVT_PARAM1", i);
    com.tencent.liteav.basic.util.f.a(this.mNotifyListener, this.mUserId, 2008, (Bundle)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start video decoder:");
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    TXCLog.i("TXCVideoDecoder", ((StringBuilder)localObject).toString());
  }
  
  private int startDecodeThread()
  {
    try
    {
      if (this.mDecoderHandler != null)
      {
        TXCLog.e("TXCVideoDecoder", "play:decode: start decoder error when decoder is started");
        return -1;
      }
      this.mDecoderCacheNum = 0;
      this.mRestarting = false;
      Object localObject1 = new HandlerThread("VDecoder");
      ((HandlerThread)localObject1).start();
      if (this.mHWDec)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("VideoWDec");
        ((StringBuilder)localObject3).append(((HandlerThread)localObject1).getId());
        ((HandlerThread)localObject1).setName(((StringBuilder)localObject3).toString());
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("VideoSWDec");
        ((StringBuilder)localObject3).append(((HandlerThread)localObject1).getId());
        ((HandlerThread)localObject1).setName(((StringBuilder)localObject3).toString());
      }
      localObject1 = new TXCVideoDecoder.a(((HandlerThread)localObject1).getLooper());
      ((TXCVideoDecoder.a)localObject1).a(this.mHevc, this.mHWDec, this.mSurface, this.mSps, this.mPps, this, this);
      TXCLog.w("TXCVideoDecoder", "play:decode: start decode thread");
      Object localObject3 = Message.obtain();
      ((Message)localObject3).what = 100;
      ((Message)localObject3).obj = Boolean.valueOf(this.mNeedSortFrame);
      ((TXCVideoDecoder.a)localObject1).sendMessage((Message)localObject3);
      this.mDecoderHandler = ((TXCVideoDecoder.a)localObject1);
      return 0;
    }
    finally {}
  }
  
  private void stopDecodeThread()
  {
    try
    {
      if (this.mDecoderHandler != null) {
        this.mDecoderHandler.sendEmptyMessage(102);
      }
      this.mDecoderHandler = null;
      return;
    }
    finally {}
  }
  
  private void stopHWDecoder()
  {
    try
    {
      if (this.mVideoDecoder != null)
      {
        this.mVideoDecoder.stop();
        this.mVideoDecoder.setListener(null);
        this.mVideoDecoder.setNotifyListener(null);
        this.mVideoDecoder = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long GetDecodeFirstFrameTS()
  {
    return mDecodeFirstFrameTS;
  }
  
  public void config(JSONArray paramJSONArray)
  {
    this.mDecFormat = paramJSONArray;
  }
  
  public void enableChange(boolean paramBoolean)
  {
    this.mEnableDecoderChange = paramBoolean;
    try
    {
      nativeEnableDecodeChange(this.mNativeContext, this.mEnableDecoderChange);
      return;
    }
    finally {}
  }
  
  public void enableHWDec(boolean paramBoolean)
  {
    this.mHWDec = paramBoolean;
  }
  
  public void enableLimitDecCache(boolean paramBoolean)
  {
    this.mEnableLimitDecCache = paramBoolean;
    b localb = this.mVideoDecoder;
    if (localb != null) {
      localb.enableLimitDecCache(this.mEnableLimitDecCache);
    }
  }
  
  public void enableRestart(boolean paramBoolean)
  {
    this.mEnableRestartDecoder = paramBoolean;
  }
  
  public int getDecoderCacheNum()
  {
    return this.mDecoderCacheNum + this.mNALList.size();
  }
  
  public boolean isHardwareDecode()
  {
    return this.mVideoDecoder != null;
  }
  
  public boolean isHevc()
  {
    return this.mHevc;
  }
  
  public void onDecodeFailed(int paramInt)
  {
    TXCStatus.a(this.mUserId, 9007, this.mStreamType, Integer.valueOf(paramInt));
    g localg = this.mDecoderListener;
    if (localg != null) {
      localg.onDecodeFailed(paramInt);
    }
    try
    {
      nativeDecCache(this.mNativeContext);
      return;
    }
    finally {}
  }
  
  public void onDecodeFrame(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    if (mDecodeFirstFrameTS == 0L)
    {
      mDecodeFirstFrameTS = TXCTimeUtil.getTimeTick();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[FirstFramePath][Video][Decoder] TXCVideoDecoder: decode first frame success. instance:");
      ((StringBuilder)localObject).append(hashCode());
      ((StringBuilder)localObject).append(" isHWAcc:true isHEVC:");
      ((StringBuilder)localObject).append(this.mHevc);
      ((StringBuilder)localObject).append(" userId:");
      ((StringBuilder)localObject).append(this.mUserId);
      ((StringBuilder)localObject).append(" type:");
      ((StringBuilder)localObject).append(this.mStreamType);
      TXCLog.i("TXCVideoDecoder", ((StringBuilder)localObject).toString());
      TXCStatus.a(this.mUserId, 5005, this.mStreamType, Long.valueOf(mDecodeFirstFrameTS));
      int i;
      if (this.mHevc) {
        i = 3;
      } else {
        i = 1;
      }
      TXCStatus.a(this.mUserId, 5004, this.mStreamType, Integer.valueOf(i));
    }
    Object localObject = this.mDecoderListener;
    if (localObject != null) {
      ((g)localObject).onDecodeFrame(paramTXSVideoFrame, paramInt1, paramInt2, paramLong1, paramLong2, paramInt3);
    }
    paramInt3 = this.mDecoderCacheNum;
    if (paramInt3 > 0) {
      this.mDecoderCacheNum = (paramInt3 - 1);
    }
    if (paramTXSVideoFrame == null) {
      try
      {
        nativeNotifyPts(this.mNativeContext, paramLong1, paramInt1, paramInt2);
      }
      finally {}
    }
    paramInt1 = this.mVideoDecoder.GetDecodeCost();
    if (this.mHWDec)
    {
      TXCStatus.a(this.mUserId, 8004, this.mStreamType, Integer.valueOf(paramInt1));
      return;
    }
    TXCStatus.a(this.mUserId, 8003, this.mStreamType, Integer.valueOf(paramInt1));
  }
  
  public void onDecoderChange(String paramString, boolean paramBoolean)
  {
    this.mHevc = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDecoderChange ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" , isHevc = ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("TXCVideoDecoder", localStringBuilder.toString());
    reportDecoderEvent(this.mHWDec, paramBoolean);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    if (paramInt == -2304) {
      nativeNotifyHWDecoderError(this.mNativeContext);
    }
    com.tencent.liteav.basic.util.f.a(this.mNotifyListener, this.mUserId, paramInt, paramBundle);
  }
  
  public void onVideoSizeChange(int paramInt1, int paramInt2)
  {
    g localg = this.mDecoderListener;
    if ((localg != null) && ((this.mVideoWidth != paramInt1) || (this.mVideoHeight != paramInt2)))
    {
      this.mVideoWidth = paramInt1;
      this.mVideoHeight = paramInt2;
      localg.onVideoSizeChange(this.mVideoWidth, this.mVideoHeight);
    }
  }
  
  public void pushNAL(TXSNALPacket paramTXSNALPacket)
  {
    decNALByNewWay(paramTXSNALPacket);
  }
  
  public void restart(boolean paramBoolean)
  {
    try
    {
      this.mHWDec = paramBoolean;
      nativeReStart(this.mNativeContext, this.mHWDec);
      return;
    }
    finally {}
  }
  
  public void setListener(g paramg)
  {
    this.mDecoderListener = paramg;
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.b.b paramb)
  {
    this.mNotifyListener = new WeakReference(paramb);
  }
  
  public void setStreamType(int paramInt)
  {
    this.mStreamType = paramInt;
    try
    {
      nativeSetStreamType(this.mNativeContext, this.mStreamType);
      return;
    }
    finally {}
  }
  
  public void setUserId(String paramString)
  {
    this.mUserId = paramString;
    try
    {
      nativeSetID(this.mNativeContext, this.mUserId);
      return;
    }
    finally {}
  }
  
  public int setup(SurfaceTexture paramSurfaceTexture, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean)
  {
    try
    {
      if (this.mSurface != null)
      {
        this.mSurface.release();
        this.mSurface = null;
      }
      return setup(new Surface(paramSurfaceTexture), paramByteBuffer1, paramByteBuffer2, paramBoolean);
    }
    finally {}
  }
  
  public int setup(Surface paramSurface, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean)
  {
    try
    {
      this.mSurface = paramSurface;
      this.mSps = paramByteBuffer1;
      this.mPps = paramByteBuffer2;
      this.mNeedSortFrame = paramBoolean;
      return 0;
    }
    finally {}
  }
  
  public int start()
  {
    try
    {
      if ((this.mHWDec) && (this.mSurface == null))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("play:decode: start decoder error when not setup surface, id ");
        localStringBuilder.append(this.mUserId);
        localStringBuilder.append("_");
        localStringBuilder.append(this.mStreamType);
        TXCLog.i("TXCVideoDecoder", localStringBuilder.toString());
        return -1;
      }
      if (this.mNativeContext != 0L)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("play:decode: start decoder error when decoder is started, id ");
        localStringBuilder.append(this.mUserId);
        localStringBuilder.append("_");
        localStringBuilder.append(this.mStreamType);
        TXCLog.w("TXCVideoDecoder", localStringBuilder.toString());
        return -1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[FirstFramePath][Video][Decoder] TXCVideoDecoder: start decode. instance:");
      localStringBuilder.append(this);
      localStringBuilder.append(" userId:");
      localStringBuilder.append(this.mUserId);
      localStringBuilder.append(" type:");
      localStringBuilder.append(this.mStreamType);
      TXCLog.i("TXCVideoDecoder", localStringBuilder.toString());
      this.mNativeContext = nativeCreateContext(this.mHWDec, a.b());
      nativeSetID(this.mNativeContext, this.mUserId);
      nativeSetStreamType(this.mNativeContext, this.mStreamType);
      nativeEnableDecodeChange(this.mNativeContext, this.mEnableDecoderChange);
      nativeEnableRestartDecoder(this.mNativeContext, this.mEnableRestartDecoder);
      return 0;
    }
    finally {}
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 170	com/tencent/liteav/videodecoder/TXCVideoDecoder:mNativeContext	J
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +57 -> 65
    //   11: new 335	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: ldc_w 580
    //   23: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_1
    //   28: aload_0
    //   29: getfield 305	com/tencent/liteav/videodecoder/TXCVideoDecoder:mUserId	Ljava/lang/String;
    //   32: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_1
    //   37: ldc_w 561
    //   40: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 67	com/tencent/liteav/videodecoder/TXCVideoDecoder:mStreamType	I
    //   49: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 15
    //   55: aload_1
    //   56: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 190	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: new 335	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   72: astore_1
    //   73: aload_1
    //   74: ldc_w 582
    //   77: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_1
    //   82: aload_0
    //   83: getfield 305	com/tencent/liteav/videodecoder/TXCVideoDecoder:mUserId	Ljava/lang/String;
    //   86: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: ldc_w 561
    //   94: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_1
    //   99: aload_0
    //   100: getfield 67	com/tencent/liteav/videodecoder/TXCVideoDecoder:mStreamType	I
    //   103: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_1
    //   108: ldc_w 584
    //   111: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_1
    //   116: aload_0
    //   117: invokevirtual 345	java/lang/Object:hashCode	()I
    //   120: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: ldc 15
    //   126: aload_1
    //   127: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 190	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: aload_0
    //   135: getfield 170	com/tencent/liteav/videodecoder/TXCVideoDecoder:mNativeContext	J
    //   138: invokespecial 586	com/tencent/liteav/videodecoder/TXCVideoDecoder:nativeDestroyContext	(J)V
    //   141: aload_0
    //   142: lconst_0
    //   143: putfield 170	com/tencent/liteav/videodecoder/TXCVideoDecoder:mNativeContext	J
    //   146: aload_0
    //   147: getfield 84	com/tencent/liteav/videodecoder/TXCVideoDecoder:mNALList	Ljava/util/ArrayList;
    //   150: invokevirtual 221	java/util/ArrayList:clear	()V
    //   153: aload_0
    //   154: iconst_0
    //   155: putfield 92	com/tencent/liteav/videodecoder/TXCVideoDecoder:mRecvFirstFrame	Z
    //   158: aload_0
    //   159: iconst_0
    //   160: putfield 160	com/tencent/liteav/videodecoder/TXCVideoDecoder:mDecoderCacheNum	I
    //   163: lconst_0
    //   164: putstatic 94	com/tencent/liteav/videodecoder/TXCVideoDecoder:mDecodeFirstFrameTS	J
    //   167: aload_0
    //   168: monitorenter
    //   169: aload_0
    //   170: getfield 238	com/tencent/liteav/videodecoder/TXCVideoDecoder:mVideoDecoder	Lcom/tencent/liteav/videodecoder/b;
    //   173: ifnull +37 -> 210
    //   176: aload_0
    //   177: getfield 238	com/tencent/liteav/videodecoder/TXCVideoDecoder:mVideoDecoder	Lcom/tencent/liteav/videodecoder/b;
    //   180: invokeinterface 494 1 0
    //   185: aload_0
    //   186: getfield 238	com/tencent/liteav/videodecoder/TXCVideoDecoder:mVideoDecoder	Lcom/tencent/liteav/videodecoder/b;
    //   189: aconst_null
    //   190: invokeinterface 495 2 0
    //   195: aload_0
    //   196: getfield 238	com/tencent/liteav/videodecoder/TXCVideoDecoder:mVideoDecoder	Lcom/tencent/liteav/videodecoder/b;
    //   199: aconst_null
    //   200: invokeinterface 496 2 0
    //   205: aload_0
    //   206: aconst_null
    //   207: putfield 238	com/tencent/liteav/videodecoder/TXCVideoDecoder:mVideoDecoder	Lcom/tencent/liteav/videodecoder/b;
    //   210: aload_0
    //   211: getfield 262	com/tencent/liteav/videodecoder/TXCVideoDecoder:mSurface	Landroid/view/Surface;
    //   214: ifnull +15 -> 229
    //   217: aload_0
    //   218: getfield 262	com/tencent/liteav/videodecoder/TXCVideoDecoder:mSurface	Landroid/view/Surface;
    //   221: invokevirtual 551	android/view/Surface:release	()V
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 262	com/tencent/liteav/videodecoder/TXCVideoDecoder:mSurface	Landroid/view/Surface;
    //   229: aload_0
    //   230: monitorexit
    //   231: aload_0
    //   232: monitorexit
    //   233: return
    //   234: astore_1
    //   235: aload_0
    //   236: monitorexit
    //   237: aload_1
    //   238: athrow
    //   239: astore_1
    //   240: aload_0
    //   241: monitorexit
    //   242: aload_1
    //   243: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	TXCVideoDecoder
    //   18	109	1	localStringBuilder	StringBuilder
    //   234	4	1	localObject1	Object
    //   239	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   169	210	234	finally
    //   210	229	234	finally
    //   229	231	234	finally
    //   235	237	234	finally
    //   2	62	239	finally
    //   65	169	239	finally
    //   237	239	239	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.TXCVideoDecoder
 * JD-Core Version:    0.7.0.1
 */
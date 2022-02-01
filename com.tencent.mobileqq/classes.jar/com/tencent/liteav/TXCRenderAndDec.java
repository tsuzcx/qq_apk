package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.renderer.a.a;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.renderer.f;
import com.tencent.liteav.videodecoder.TXCVideoDecoder;
import com.tencent.liteav.videodecoder.g;
import java.lang.ref.WeakReference;

public class TXCRenderAndDec
  extends com.tencent.liteav.basic.module.a
  implements com.tencent.liteav.basic.c.b, a.a, f, g
{
  public static final String TAG = "TXCRenderAndDec";
  private h mConfig = null;
  private Context mContext = null;
  private int mCustomRenderFrameBufferId = -1;
  private TXCRenderAndDec.a mDecListener = null;
  private boolean mEnableDecoderChange = false;
  private boolean mEnableLimitHWDecCache = false;
  private boolean mEnableRestartDecoder = false;
  private boolean mFirstRender = false;
  private long mFrameDecErrCnt = 0L;
  private boolean mIsRendering = false;
  private long mLastRenderCalculateTS = 0L;
  private long mLastRenderFrameCount = 0L;
  private long mLastReqKeyFrameTS = 0L;
  private WeakReference<com.tencent.liteav.basic.c.b> mNotifyListener;
  private j mRGBA2YUVFilter = null;
  private boolean mRealTime = false;
  private WeakReference<TXCRenderAndDec.b> mRenderAndDecDelegate;
  private long mRenderFrameCount = 0L;
  private int mRenderMode = 0;
  private int mRenderRotation = 0;
  private int mStreamType = 0;
  private TXCVideoDecoder mVideoDecoder = null;
  private com.tencent.liteav.basic.b.b mVideoFrameFormat = com.tencent.liteav.basic.b.b.a;
  private o mVideoFrameListener;
  private e mVideoRender = null;
  
  public TXCRenderAndDec(Context paramContext)
  {
    this.mContext = paramContext;
    c.a().a(this.mContext);
  }
  
  private void notifyEvent(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", getID());
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    localBundle.putInt("EVT_STREAM_TYPE", this.mStreamType);
    com.tencent.liteav.basic.util.h.a(this.mNotifyListener, paramInt, localBundle);
  }
  
  private void requestKeyFrame()
  {
    long l = TXCTimeUtil.getTimeTick();
    if (l > this.mLastReqKeyFrameTS + 3000L)
    {
      this.mLastReqKeyFrameTS = l;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestKeyFrame: ");
      ((StringBuilder)localObject).append(getID());
      TXCLog.e("TXCRenderAndDec", ((StringBuilder)localObject).toString());
      localObject = this.mRenderAndDecDelegate;
      if (localObject != null)
      {
        localObject = (TXCRenderAndDec.b)((WeakReference)localObject).get();
        if (localObject != null) {
          ((TXCRenderAndDec.b)localObject).onRequestKeyFrame(getID(), this.mStreamType);
        }
      }
    }
  }
  
  private void startDecode()
  {
    Object localObject = this.mVideoRender;
    if (localObject != null) {
      localObject = ((e)localObject).a();
    } else {
      localObject = null;
    }
    startDecode((SurfaceTexture)localObject);
  }
  
  private void startDecode(SurfaceTexture paramSurfaceTexture)
  {
    TXCVideoDecoder localTXCVideoDecoder = this.mVideoDecoder;
    if (localTXCVideoDecoder != null)
    {
      localTXCVideoDecoder.stop();
      localTXCVideoDecoder.enableHWDec(this.mConfig.h);
      localTXCVideoDecoder.config(this.mConfig.r);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("trtc_ start decode ");
      localStringBuilder.append(paramSurfaceTexture);
      localStringBuilder.append(", hw: ");
      localStringBuilder.append(this.mConfig.h);
      localStringBuilder.append(", id ");
      localStringBuilder.append(getID());
      localStringBuilder.append("_");
      localStringBuilder.append(this.mStreamType);
      TXCLog.i("TXCRenderAndDec", localStringBuilder.toString());
      if (paramSurfaceTexture != null)
      {
        localTXCVideoDecoder.setup(paramSurfaceTexture, null, null, this.mRealTime ^ true);
        localTXCVideoDecoder.setUserId(getID());
        localTXCVideoDecoder.start();
        return;
      }
      if (!this.mConfig.h)
      {
        localTXCVideoDecoder.setup((Surface)null, null, null, this.mRealTime ^ true);
        localTXCVideoDecoder.setUserId(getID());
        localTXCVideoDecoder.start();
      }
    }
  }
  
  public void decVideo(TXSNALPacket paramTXSNALPacket) {}
  
  public void enableDecoderChange(boolean paramBoolean)
  {
    this.mEnableDecoderChange = paramBoolean;
  }
  
  public void enableLimitDecCache(boolean paramBoolean)
  {
    this.mEnableLimitHWDecCache = paramBoolean;
    TXCVideoDecoder localTXCVideoDecoder = this.mVideoDecoder;
    if (localTXCVideoDecoder != null) {
      localTXCVideoDecoder.enableLimitDecCache(paramBoolean);
    }
  }
  
  public void enableReport(boolean paramBoolean)
  {
    e locale = this.mVideoRender;
    if (locale != null) {
      locale.b(paramBoolean);
    }
  }
  
  public void enableRestartDecoder(boolean paramBoolean)
  {
    this.mEnableRestartDecoder = paramBoolean;
  }
  
  public long getAVNetRecvInterval()
  {
    return getLongValue(6108, 2);
  }
  
  public long getAVPlayInterval()
  {
    return getLongValue(6107, 2);
  }
  
  public h getConfig()
  {
    return this.mConfig;
  }
  
  public int getStreamType()
  {
    return this.mStreamType;
  }
  
  public long getVideoCacheDuration()
  {
    return getIntValue(6104, 2);
  }
  
  public long getVideoCacheFrameCount()
  {
    return getIntValue(6105, 2);
  }
  
  public int getVideoDecCacheFrameCount()
  {
    return getIntValue(6106, 2);
  }
  
  public int getVideoGop()
  {
    return getIntValue(7120);
  }
  
  public e getVideoRender()
  {
    return this.mVideoRender;
  }
  
  public boolean isRendering()
  {
    return this.mIsRendering;
  }
  
  public void onDecodeFailed(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("video decode failed ");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.e("TXCRenderAndDec", ((StringBuilder)localObject).toString());
    if (paramInt == -2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("use h265 softdecoder but not set h265 softdecoder to sdk, isH265SoftDecodeExist= ");
      ((StringBuilder)localObject).append(com.tencent.liteav.basic.a.a());
      TXCLog.w("TXCRenderAndDec", ((StringBuilder)localObject).toString());
      if (!com.tencent.liteav.basic.a.a())
      {
        localObject = this.mVideoDecoder;
        if ((localObject != null) && (((TXCVideoDecoder)localObject).isH265()))
        {
          this.mConfig.h = true;
          ((TXCVideoDecoder)localObject).restart(true);
        }
      }
    }
    else
    {
      if (-4 == paramInt)
      {
        notifyEvent(-2312, "h265 softdecoder start fail.");
        return;
      }
      requestKeyFrame();
      paramInt = this.mStreamType;
      long l = this.mFrameDecErrCnt + 1L;
      this.mFrameDecErrCnt = l;
      setStatusValue(17014, paramInt, Long.valueOf(l));
    }
  }
  
  public void onDecodeFrame(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    int i;
    if ((paramInt3 != 0) && (paramInt3 != 1) && (paramInt3 != 2))
    {
      i = paramInt3;
      if (paramInt3 != 3) {}
    }
    else
    {
      i = 360 - paramInt3 * 90;
    }
    o localo = this.mVideoFrameListener;
    if ((localo != null) && (paramTXSVideoFrame != null) && ((this.mVideoFrameFormat == com.tencent.liteav.basic.b.b.b) || (this.mVideoFrameFormat == com.tencent.liteav.basic.b.b.e)))
    {
      if (this.mVideoRender != null) {
        localObject = paramTXSVideoFrame.clone();
      } else {
        localObject = paramTXSVideoFrame;
      }
      ((TXSVideoFrame)localObject).rotation = ((this.mRenderRotation + i) % 360);
      if (this.mVideoFrameFormat == com.tencent.liteav.basic.b.b.e) {
        ((TXSVideoFrame)localObject).loadNV21BufferFromI420Buffer();
      }
      localo.onRenderVideoFrame(getID(), this.mStreamType, (TXSVideoFrame)localObject);
    }
    if (!this.mFirstRender)
    {
      this.mFirstRender = true;
      TXCEventRecorderProxy.a(getID(), 5007, -1L, -1L, "", this.mStreamType);
      if (this.mVideoRender == null) {
        TXCKeyPointReportProxy.a(getID(), 40022, 0L, this.mStreamType);
      }
      if (this.mVideoDecoder != null) {
        TXCKeyPointReportProxy.a(getID(), 40029, this.mVideoDecoder.GetDecodeFirstFrameTS(), this.mStreamType);
      }
      if (this.mStreamType == 2) {
        TXCKeyPointReportProxy.a(getID(), 32004);
      }
    }
    Object localObject = this.mVideoRender;
    if (localObject != null)
    {
      ((e)localObject).a(paramTXSVideoFrame, paramInt1, paramInt2, i);
      return;
    }
    if (this.mLastRenderCalculateTS == 0L)
    {
      this.mLastRenderCalculateTS = System.currentTimeMillis();
      this.mLastRenderFrameCount = 0L;
      this.mRenderFrameCount = 0L;
      return;
    }
    this.mRenderFrameCount += 1L;
  }
  
  public void onDecoderChange(String paramString, boolean paramBoolean) {}
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 2106)
    {
      h localh = this.mConfig;
      localh.h = false;
      TXCVideoDecoder localTXCVideoDecoder = this.mVideoDecoder;
      if (localTXCVideoDecoder != null) {
        localTXCVideoDecoder.restart(localh.h);
      }
    }
    else if (paramInt == -2304)
    {
      if (com.tencent.liteav.basic.a.a())
      {
        this.mConfig.h = false;
        paramBundle = this.mVideoDecoder;
        if (paramBundle != null) {
          paramBundle.restart(false);
        }
      }
    }
    else if (paramInt == 2020)
    {
      TXCLog.e("TXCRenderAndDec", "decoding too many frame(>40) without output! request key frame now.");
      requestKeyFrame();
      return;
    }
    paramBundle.putInt("EVT_STREAM_TYPE", this.mStreamType);
    com.tencent.liteav.basic.util.h.a(this.mNotifyListener, paramInt, paramBundle);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("play decode when surface texture create hw ");
    ((StringBuilder)localObject).append(this.mConfig.h);
    TXCLog.w("TXCRenderAndDec", ((StringBuilder)localObject).toString());
    localObject = this.mVideoDecoder;
    if (localObject != null) {
      ((TXCVideoDecoder)localObject).setup(paramSurfaceTexture, null, null, this.mRealTime ^ true);
    }
    if (this.mConfig.h) {
      startDecode(paramSurfaceTexture);
    }
    resetPeriodStatistics();
    enableReport(true);
  }
  
  public void onSurfaceTextureDestroy(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      TXCLog.w("TXCRenderAndDec", "play:stop decode when surface texture release");
      if ((this.mConfig.h) && (this.mVideoDecoder != null)) {
        this.mVideoDecoder.stop();
      }
      if (this.mCustomRenderFrameBufferId != -1)
      {
        TXCOpenGlUtils.b(this.mCustomRenderFrameBufferId);
        this.mCustomRenderFrameBufferId = -1;
      }
      if (this.mRGBA2YUVFilter != null)
      {
        this.mRGBA2YUVFilter.d();
        this.mRGBA2YUVFilter = null;
      }
      if (this.mDecListener != null) {
        this.mDecListener.a(paramSurfaceTexture);
      }
      resetPeriodStatistics();
      enableReport(false);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      TXCLog.e("TXCRenderAndDec", "onSurfaceTextureDestroy failed.", paramSurfaceTexture);
    }
  }
  
  public void onTextureProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    o localo = this.mVideoFrameListener;
    if (localo == null) {
      return;
    }
    TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
    localTXSVideoFrame.width = paramInt2;
    localTXSVideoFrame.height = paramInt3;
    localTXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
    localTXSVideoFrame.rotation = ((paramInt4 + this.mRenderRotation) % 360);
    if (this.mVideoFrameFormat == com.tencent.liteav.basic.b.b.f)
    {
      localTXSVideoFrame.textureId = paramInt1;
      localTXSVideoFrame.eglContext = TXCOpenGlUtils.e();
      if (this.mCustomRenderFrameBufferId == -1) {
        this.mCustomRenderFrameBufferId = TXCOpenGlUtils.d();
      }
      TXCOpenGlUtils.a(paramInt1, this.mCustomRenderFrameBufferId);
      GLES20.glBindFramebuffer(36160, this.mCustomRenderFrameBufferId);
      this.mVideoFrameListener.onRenderVideoFrame(getID(), this.mStreamType, localTXSVideoFrame);
      TXCOpenGlUtils.d(this.mCustomRenderFrameBufferId);
      return;
    }
    if (this.mVideoFrameFormat == com.tencent.liteav.basic.b.b.c)
    {
      localTXSVideoFrame.textureId = paramInt1;
      localObject = this.mVideoRender;
      if ((localObject instanceof com.tencent.liteav.renderer.a)) {
        localTXSVideoFrame.eglContext = ((com.tencent.liteav.renderer.a)localObject).b();
      }
      localo.onRenderVideoFrame(getID(), this.mStreamType, localTXSVideoFrame);
      return;
    }
    Object localObject = this.mVideoDecoder;
    if ((localObject != null) && (!((TXCVideoDecoder)localObject).isHardwareDecode())) {
      return;
    }
    if (this.mRGBA2YUVFilter == null)
    {
      if (this.mVideoFrameFormat == com.tencent.liteav.basic.b.b.e) {
        this.mRGBA2YUVFilter = new com.tencent.liteav.beauty.b.o(3);
      } else {
        this.mRGBA2YUVFilter = new com.tencent.liteav.beauty.b.o(1);
      }
      this.mRGBA2YUVFilter.a(true);
      if (this.mRGBA2YUVFilter.a())
      {
        this.mRGBA2YUVFilter.a(paramInt2, paramInt3);
      }
      else
      {
        TXCLog.i("TXCRenderAndDec", "throwVideoFrame->release mVideoFrameFilter");
        this.mRGBA2YUVFilter = null;
      }
    }
    if (this.mRGBA2YUVFilter != null)
    {
      GLES20.glViewport(0, 0, paramInt2, paramInt3);
      this.mRGBA2YUVFilter.a(paramInt2, paramInt3);
      this.mRGBA2YUVFilter.b(paramInt1);
      GLES20.glBindFramebuffer(36160, this.mRGBA2YUVFilter.m());
      localo.onRenderVideoFrame(getID(), this.mStreamType, localTXSVideoFrame);
      GLES20.glBindFramebuffer(36160, 0);
    }
  }
  
  public void onVideoSizeChange(int paramInt1, int paramInt2)
  {
    Object localObject = this.mVideoRender;
    if (localObject != null) {
      ((e)localObject).c(paramInt1, paramInt2);
    }
    localObject = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Resolution changed to");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt2);
    ((Bundle)localObject).putCharSequence("EVT_MSG", localStringBuilder.toString());
    ((Bundle)localObject).putInt("EVT_PARAM1", paramInt1);
    ((Bundle)localObject).putInt("EVT_PARAM2", paramInt2);
    ((Bundle)localObject).putString("EVT_USERID", getID());
    ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    ((Bundle)localObject).putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    onNotifyEvent(2009, (Bundle)localObject);
    setStatusValue(5003, this.mStreamType, Integer.valueOf(paramInt1 << 16 | paramInt2));
    localObject = getID();
    long l1 = paramInt1;
    long l2 = paramInt2;
    TXCEventRecorderProxy.a((String)localObject, 4003, l1, l2, "", this.mStreamType);
    TXCKeyPointReportProxy.a(getID(), 40002, l1, this.mStreamType);
    TXCKeyPointReportProxy.a(getID(), 40003, l2, this.mStreamType);
  }
  
  public void resetPeriodFeelingStatistics()
  {
    e locale = this.mVideoRender;
    if (locale != null) {
      locale.n();
    }
  }
  
  public void resetPeriodStatistics()
  {
    e locale = this.mVideoRender;
    if (locale != null) {
      locale.m();
    }
  }
  
  public void restartDecoder()
  {
    TXCVideoDecoder localTXCVideoDecoder = this.mVideoDecoder;
    if ((localTXCVideoDecoder != null) && (localTXCVideoDecoder.isH265())) {
      localTXCVideoDecoder.restart(true);
    }
  }
  
  public void setBlockInterval(int paramInt)
  {
    e locale = this.mVideoRender;
    if (locale != null) {
      locale.f(paramInt);
    }
  }
  
  public void setConfig(h paramh)
  {
    this.mConfig = paramh;
    paramh = this.mVideoRender;
    if (paramh != null) {
      paramh.b(this.mConfig.d);
    }
  }
  
  public void setDecListener(TXCRenderAndDec.a parama)
  {
    this.mDecListener = parama;
  }
  
  public void setID(String paramString)
  {
    super.setID(paramString);
    Object localObject = this.mVideoRender;
    if (localObject != null) {
      ((e)localObject).setID(getID());
    }
    localObject = this.mVideoDecoder;
    if (localObject != null) {
      ((TXCVideoDecoder)localObject).setUserId(paramString);
    }
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.c.b paramb)
  {
    this.mNotifyListener = new WeakReference(paramb);
  }
  
  public void setRenderAndDecDelegate(TXCRenderAndDec.b paramb)
  {
    this.mRenderAndDecDelegate = new WeakReference(paramb);
  }
  
  public void setRenderMirrorType(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setRenderMirrorType ");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.i("TXCRenderAndDec", ((StringBuilder)localObject).toString());
    localObject = this.mVideoRender;
    if (localObject != null) {
      ((e)localObject).d(paramInt);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mRenderMode = paramInt;
    e locale = this.mVideoRender;
    if (locale != null) {
      locale.c(paramInt);
    }
  }
  
  public void setRenderRotation(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("vrotation setRenderRotation ");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.i("TXCRenderAndDec", ((StringBuilder)localObject).toString());
    this.mRenderRotation = paramInt;
    localObject = this.mVideoRender;
    if (localObject != null) {
      ((e)localObject).e(paramInt);
    }
  }
  
  public void setStreamType(int paramInt)
  {
    this.mStreamType = paramInt;
    Object localObject = this.mVideoRender;
    if (localObject != null) {
      ((e)localObject).a(this.mStreamType);
    }
    localObject = this.mVideoDecoder;
    if (localObject != null) {
      ((TXCVideoDecoder)localObject).setStreamType(this.mStreamType);
    }
  }
  
  public void setVideoFrameListener(o paramo, com.tencent.liteav.basic.b.b paramb)
  {
    this.mVideoFrameListener = paramo;
    this.mVideoFrameFormat = paramb;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoFrameListener->enter listener: ");
    localStringBuilder.append(paramo);
    localStringBuilder.append(", format: ");
    localStringBuilder.append(paramb);
    TXCLog.i("TXCRenderAndDec", localStringBuilder.toString());
    paramb = this.mVideoRender;
    if ((paramb != null) && ((paramb instanceof com.tencent.liteav.renderer.a)))
    {
      if (paramo == null)
      {
        TXCLog.i("TXCRenderAndDec", "setCustomRenderListener-> clean listener.");
        ((com.tencent.liteav.renderer.a)this.mVideoRender).b(null);
        return;
      }
      TXCLog.i("TXCRenderAndDec", "setCustomRenderListener-> set listener.");
      ((com.tencent.liteav.renderer.a)this.mVideoRender).b(this);
    }
  }
  
  public void setVideoRender(e parame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set video render ");
    localStringBuilder.append(parame);
    localStringBuilder.append(" id ");
    localStringBuilder.append(getID());
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mStreamType);
    TXCLog.i("TXCRenderAndDec", localStringBuilder.toString());
    this.mVideoRender = parame;
    parame = this.mVideoRender;
    if (parame == null) {
      return;
    }
    parame.setID(getID());
    this.mVideoRender.a(this.mStreamType);
    this.mVideoRender.a(this);
    this.mVideoRender.c(this.mRenderMode);
    this.mVideoRender.e(this.mRenderRotation);
    if (this.mVideoFrameListener != null)
    {
      parame = this.mVideoRender;
      if ((parame instanceof com.tencent.liteav.renderer.a)) {
        ((com.tencent.liteav.renderer.a)parame).b(this);
      }
    }
    parame = this.mConfig;
    if (parame != null) {
      this.mVideoRender.b(parame.d);
    }
  }
  
  public void start(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start render dec ");
    ((StringBuilder)localObject).append(getID());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(this.mStreamType);
    TXCLog.i("TXCRenderAndDec", ((StringBuilder)localObject).toString());
    this.mRealTime = paramBoolean;
    this.mFrameDecErrCnt = 0L;
    this.mLastReqKeyFrameTS = 0L;
    localObject = this.mVideoRender;
    if (localObject != null)
    {
      ((e)localObject).a(this);
      this.mVideoRender.e();
      this.mVideoRender.setID(getID());
    }
    this.mVideoDecoder = new TXCVideoDecoder();
    this.mVideoDecoder.setUserId(getID());
    this.mVideoDecoder.setStreamType(this.mStreamType);
    this.mVideoDecoder.setListener(this);
    this.mVideoDecoder.setNotifyListener(this);
    this.mVideoDecoder.enableChange(this.mEnableDecoderChange);
    this.mVideoDecoder.enableLimitDecCache(this.mEnableLimitHWDecCache);
    this.mVideoDecoder.enableRestart(this.mEnableRestartDecoder);
    startDecode();
    this.mIsRendering = true;
  }
  
  public void startVideo()
  {
    stopVideo();
    this.mRealTime = true;
    this.mFrameDecErrCnt = 0L;
    this.mLastReqKeyFrameTS = 0L;
    Object localObject = this.mVideoRender;
    if (localObject != null)
    {
      ((e)localObject).a(this);
      this.mVideoRender.e();
      this.mVideoRender.setID(getID());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start video dec ");
    ((StringBuilder)localObject).append(getID());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(this.mStreamType);
    TXCLog.i("TXCRenderAndDec", ((StringBuilder)localObject).toString());
    this.mVideoDecoder = new TXCVideoDecoder();
    this.mVideoDecoder.setUserId(getID());
    this.mVideoDecoder.setStreamType(this.mStreamType);
    this.mVideoDecoder.setListener(this);
    this.mVideoDecoder.setNotifyListener(this);
    this.mVideoDecoder.enableChange(this.mEnableDecoderChange);
    this.mVideoDecoder.enableRestart(this.mEnableRestartDecoder);
    this.mVideoDecoder.enableLimitDecCache(this.mEnableLimitHWDecCache);
    startDecode();
    this.mIsRendering = true;
  }
  
  public void stop()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop video render dec ");
    ((StringBuilder)localObject).append(getID());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(this.mStreamType);
    TXCLog.i("TXCRenderAndDec", ((StringBuilder)localObject).toString());
    this.mIsRendering = false;
    this.mRealTime = false;
    localObject = this.mVideoDecoder;
    if (localObject != null)
    {
      ((TXCVideoDecoder)localObject).setListener(null);
      this.mVideoDecoder.setNotifyListener(null);
      this.mVideoDecoder.stop();
    }
    localObject = this.mVideoRender;
    if (localObject != null)
    {
      ((e)localObject).a(true);
      this.mVideoRender.a(null);
    }
  }
  
  public void stopVideo()
  {
    this.mIsRendering = false;
    if (this.mVideoDecoder != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stop video dec ");
      ((StringBuilder)localObject).append(getID());
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.mStreamType);
      TXCLog.i("TXCRenderAndDec", ((StringBuilder)localObject).toString());
      this.mVideoDecoder.setListener(null);
      this.mVideoDecoder.setNotifyListener(null);
      this.mVideoDecoder.stop();
    }
    Object localObject = this.mVideoRender;
    if (localObject != null)
    {
      ((e)localObject).a(false);
      this.mVideoRender.a(null);
    }
  }
  
  public void updateLoadInfo()
  {
    Object localObject = this.mVideoDecoder;
    if (localObject != null)
    {
      int i = this.mStreamType;
      if (((TXCVideoDecoder)localObject).isHardwareDecode() == true) {
        l1 = 1L;
      } else {
        l1 = 0L;
      }
      setStatusValue(5002, i, Long.valueOf(l1));
    }
    localObject = this.mVideoRender;
    if (localObject != null)
    {
      ((e)localObject).o();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.mLastRenderCalculateTS;
    if (l2 >= 1000L)
    {
      long l3 = this.mRenderFrameCount;
      double d1 = l3 - this.mLastRenderFrameCount;
      Double.isNaN(d1);
      double d2 = l2;
      Double.isNaN(d2);
      d1 = d1 * 1000.0D / d2;
      this.mLastRenderFrameCount = l3;
      this.mLastRenderCalculateTS = l1;
      setStatusValue(6002, this.mStreamType, Double.valueOf(d1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.TXCRenderAndDec
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import javax.net.ssl.SSLException;

public class TXCFLVDownloader
  extends TXIStreamDownloader
{
  private final int CONNECT_TIMEOUT = 8000;
  private final int FLV_HEAD_SIZE = 9;
  private final int MAX_FRAME_SIZE = 1048576;
  private final int MSG_CONNECT = 100;
  private final int MSG_DISCONNECT = 102;
  private final int MSG_QUIT = 106;
  private final int MSG_RECONNECT = 103;
  private final int MSG_RECV_DATA = 101;
  private final int MSG_RESUME = 105;
  private final int MSG_SEEK = 104;
  private final int READ_STREAM_SIZE = 1388;
  public final String TAG = "network.TXCFLVDownloader";
  private HttpURLConnection mConnection = null;
  private long mContentLength = 0L;
  private long mCurrentNalTs = 0L;
  private long mDownloadedSize = 0L;
  private long mFLVParser = 0L;
  private Handler mFlvHandler = null;
  private HandlerThread mFlvThread = null;
  private boolean mHandleDataInJava = false;
  private boolean mHasReceivedFirstAudio = false;
  private boolean mHasReceivedFirstVideo = false;
  private InputStream mInputStream = null;
  private long mLastIFramelTs = 0L;
  private byte[] mPacketBytes = null;
  private String mPlayUrl = "";
  private boolean mRecvData = false;
  private WeakReference<TXCFLVDownloader> mRefFLVDownloader = null;
  private TXCStreamDownloader.DownloadStats mStats = null;
  private boolean mStopJitter = true;
  
  public TXCFLVDownloader(Context paramContext)
  {
    super(paramContext);
    paramContext = this.mStats;
    paramContext.afterParseAudioBytes = 0L;
    paramContext.dnsTS = 0L;
    paramContext.startTS = TXCTimeUtil.getTimeTick();
    paramContext = new StringBuilder();
    paramContext.append("new flv download ");
    paramContext.append(this);
    TXCLog.i("network.TXCFLVDownloader", paramContext.toString());
  }
  
  public TXCFLVDownloader(Context paramContext, TXCFLVDownloader paramTXCFLVDownloader)
  {
    super(paramContext);
    paramContext = this.mStats;
    paramContext.afterParseAudioBytes = 0L;
    paramContext.dnsTS = 0L;
    paramContext.startTS = TXCTimeUtil.getTimeTick();
    this.mRefFLVDownloader = new WeakReference(paramTXCFLVDownloader);
    paramContext = new StringBuilder();
    paramContext.append("new multi flv download ");
    paramContext.append(this);
    TXCLog.i("network.TXCFLVDownloader", paramContext.toString());
  }
  
  private void connect()
  {
    Object localObject1 = this.mConnection;
    if (localObject1 != null)
    {
      ((HttpURLConnection)localObject1).disconnect();
      this.mConnection = null;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[FirstFramePath][Network] TXCFLVDownloader: start network connect. instance:");
    ((StringBuilder)localObject1).append(hashCode());
    ((StringBuilder)localObject1).append(" url:");
    ((StringBuilder)localObject1).append(this.mPlayUrl);
    TXCLog.i("network.TXCFLVDownloader", ((StringBuilder)localObject1).toString());
    long l1 = System.currentTimeMillis();
    this.mConnection = ((HttpURLConnection)new URL(this.mPlayUrl).openConnection());
    this.mStats.dnsTS = TXCTimeUtil.getTimeTick();
    this.mConnection.setConnectTimeout(8000);
    this.mConnection.setReadTimeout(8000);
    this.mConnection.setRequestProperty("Accept-Encoding", "identity");
    this.mConnection.setInstanceFollowRedirects(true);
    Object localObject2;
    if (this.mHeaders != null)
    {
      localObject1 = this.mHeaders.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        this.mConnection.setRequestProperty((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
      }
    }
    this.mConnection.connect();
    if (200 == this.mConnection.getResponseCode()) {
      this.mStats.connTS = TXCTimeUtil.getTimeTick();
    } else {
      this.mStats.errorCode = this.mConnection.getResponseCode();
    }
    this.mInputStream = this.mConnection.getInputStream();
    this.mPacketBytes = new byte[1388];
    this.mRecvData = false;
    this.mContentLength = this.mConnection.getContentLength();
    this.mDownloadedSize = 0L;
    this.mStats.serverIP = InetAddress.getByName(this.mConnection.getURL().getHost()).getHostAddress();
    long l2 = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[FirstFramePath][Network] TXCFLVDownloader: connect server success. instance:");
    ((StringBuilder)localObject1).append(hashCode());
    ((StringBuilder)localObject1).append(" ip:");
    ((StringBuilder)localObject1).append(this.mStats.serverIP);
    ((StringBuilder)localObject1).append(" cost:");
    ((StringBuilder)localObject1).append(l2 - l1);
    ((StringBuilder)localObject1).append(" rspCode:");
    ((StringBuilder)localObject1).append(this.mStats.errorCode);
    TXCLog.i("network.TXCFLVDownloader", ((StringBuilder)localObject1).toString());
    sendNotifyEvent(2001);
    localObject1 = this.mConnection.getHeaderField("X-Tlive-SpanId");
    this.mStats.flvSessionKey = ((String)localObject1);
    if (!TextUtils.isEmpty(this.mFlvSessionKey))
    {
      localObject1 = this.mConnection.getHeaderField(this.mFlvSessionKey);
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("receive flvSessionKey ");
        ((StringBuilder)localObject2).append((String)localObject1);
        TXCLog.i("network.TXCFLVDownloader", ((StringBuilder)localObject2).toString());
        sendNotifyEvent(2031, (String)localObject1);
      }
    }
  }
  
  private void disconnect()
  {
    TXCLog.i("network.TXCFLVDownloader", "[Network]FLVDownloader disconnect.");
    Object localObject = this.mConnection;
    if (localObject != null)
    {
      ((HttpURLConnection)localObject).disconnect();
      this.mConnection = null;
    }
    localObject = this.mInputStream;
    if (localObject != null)
    {
      ((InputStream)localObject).close();
      this.mInputStream = null;
    }
  }
  
  private native void nativeCleanData(long paramLong);
  
  private native int nativeGetAudioBytes(long paramLong);
  
  private native int nativeGetVideoBytes(long paramLong);
  
  private native int nativeGetVideoGop(long paramLong);
  
  private native long nativeInitFlvHander(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  private native long nativeInitFlvHanderByRef(long paramLong);
  
  private native int nativeParseData(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeUninitFlvhander(long paramLong, boolean paramBoolean);
  
  private void onRecvFirstAudioData()
  {
    if (!this.mHasReceivedFirstAudio)
    {
      this.mHasReceivedFirstAudio = true;
      this.mStats.firstAudioTS = TXCTimeUtil.getTimeTick();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[FirstFramePath][Network][Audio] TXCFlvDownloader: recv first audio frame. instance:");
      localStringBuilder.append(hashCode());
      TXCLog.i("network.TXCFLVDownloader", localStringBuilder.toString());
    }
  }
  
  private void onRecvFirstVideoData()
  {
    if (!this.mHasReceivedFirstVideo)
    {
      this.mHasReceivedFirstVideo = true;
      this.mStats.firstVideoTS = TXCTimeUtil.getTimeTick();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[FirstFramePath][Network][Video] TXCFlvDownloader: recv first video frame. instance:");
      localStringBuilder.append(hashCode());
      TXCLog.i("network.TXCFLVDownloader", localStringBuilder.toString());
    }
  }
  
  private void postConnectMsg()
  {
    this.mInputStream = null;
    Object localObject = this.mConnection;
    if (localObject != null)
    {
      ((HttpURLConnection)localObject).disconnect();
      this.mConnection = null;
    }
    localObject = new Message();
    ((Message)localObject).what = 100;
    ((Message)localObject).arg1 = 0;
    Handler localHandler = this.mFlvHandler;
    if (localHandler != null) {
      localHandler.sendMessage((Message)localObject);
    }
  }
  
  private void postDisconnectMsg()
  {
    Handler localHandler = this.mFlvHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(102);
    }
  }
  
  private void postReconnectMsg()
  {
    Handler localHandler = this.mFlvHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessageDelayed(103, this.connectRetryInterval * 1000);
    }
  }
  
  private void processMsgConnect()
  {
    try
    {
      connect();
      if (this.mFLVParser == 0L)
      {
        localObject = this.mRefFLVDownloader;
        long l;
        if (localObject != null)
        {
          localObject = (TXCFLVDownloader)((WeakReference)localObject).get();
          if (localObject != null)
          {
            StringBuilder localStringBuilder;
            if (((TXCFLVDownloader)localObject).mIsRunning)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[Network]init flv parser with old downloader:");
              localStringBuilder.append(localObject.hashCode());
              TXCLog.i("network.TXCFLVDownloader", localStringBuilder.toString());
              ((TXCFLVDownloader)localObject).mStopJitter = false;
              l = ((TXCFLVDownloader)localObject).mFLVParser;
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[Network]old downloader:");
              localStringBuilder.append(localObject.hashCode());
              localStringBuilder.append(" isn't running now. just create new parser.");
              TXCLog.e("network.TXCFLVDownloader", localStringBuilder.toString());
            }
          }
          else
          {
            l = 0L;
          }
          this.mRefFLVDownloader = null;
        }
        else
        {
          l = 0L;
        }
        if (l != 0L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[Network]init flv parser with reference parse:");
          ((StringBuilder)localObject).append(l);
          TXCLog.i("network.TXCFLVDownloader", ((StringBuilder)localObject).toString());
          this.mFLVParser = nativeInitFlvHanderByRef(l);
        }
        else
        {
          TXCLog.i("network.TXCFLVDownloader", "[Network]init flv parser.");
          this.mFLVParser = nativeInitFlvHander(this.mUserID, 0, this.mEnableMessage, this.mEnableMetaData);
        }
      }
      Object localObject = this.mFlvHandler;
      if (localObject != null) {
        ((Handler)localObject).sendEmptyMessage(101);
      }
      return;
    }
    catch (Error localError)
    {
      TXCLog.e("network.TXCFLVDownloader", "[Network]error, reconnect");
      localError.printStackTrace();
      postReconnectMsg();
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("network.TXCFLVDownloader", "[Network]exception, reconnect");
      localException.printStackTrace();
      postReconnectMsg();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      TXCLog.e("network.TXCFLVDownloader", "[Network]file not found, reconnect");
      localFileNotFoundException.printStackTrace();
      postReconnectMsg();
      return;
      TXCLog.e("network.TXCFLVDownloader", "[Network]socket timeout, reconnect");
      postReconnectMsg();
      return;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      label300:
      break label300;
    }
  }
  
  private void processMsgDisConnect()
  {
    try
    {
      disconnect();
    }
    catch (Exception localException)
    {
      TXCLog.e("network.TXCFLVDownloader", "disconnect failed.", localException);
    }
    long l = this.mFLVParser;
    if (l != 0L)
    {
      nativeUninitFlvhander(l, this.mStopJitter);
      this.mFLVParser = 0L;
    }
  }
  
  private void processMsgReconnect()
  {
    if (this.mStopJitter)
    {
      reconnect();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ignore processMsgReconnect when start multi stream switch");
    localStringBuilder.append(this);
    TXCLog.i("network.TXCFLVDownloader", localStringBuilder.toString());
    if (this.mRestartListener != null) {
      this.mRestartListener.onOldStreamStop();
    }
  }
  
  private void processMsgRecvData()
  {
    Object localObject = this.mInputStream;
    if (localObject != null) {}
    try
    {
      byte[] arrayOfByte = this.mPacketBytes;
      int i = 0;
      int j = ((InputStream)localObject).read(arrayOfByte, 0, 1388);
      if (j > 0)
      {
        long l1 = this.mDownloadedSize;
        long l2 = j;
        this.mDownloadedSize = (l1 + l2);
        if (!this.mRecvData)
        {
          this.mRecvData = true;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[FirstFramePath][Network] TXCFLVDownloader: recv first data packet. instance:");
          ((StringBuilder)localObject).append(hashCode());
          TXCLog.i("network.TXCFLVDownloader", ((StringBuilder)localObject).toString());
        }
        if (this.mFLVParser != 0L)
        {
          localObject = this.mStats;
          ((TXCStreamDownloader.DownloadStats)localObject).beforeParseVideoBytes += l2;
          i = nativeParseData(this.mFLVParser, this.mPacketBytes, j);
          this.mStats.afterParseVideoBytes = nativeGetVideoBytes(this.mFLVParser);
          this.mStats.afterParseAudioBytes = nativeGetAudioBytes(this.mFLVParser);
          this.mStats.videoGop = nativeGetVideoGop(this.mFLVParser);
        }
        if (i > 1048576)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[Network]flv play parse frame: ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" > ");
          ((StringBuilder)localObject).append(1048576);
          ((StringBuilder)localObject).append(",start reconnect");
          TXCLog.e("network.TXCFLVDownloader", ((StringBuilder)localObject).toString());
          postReconnectMsg();
        }
      }
      else if (j < 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Network]http read: ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" < 0, start reconnect");
        TXCLog.e("network.TXCFLVDownloader", ((StringBuilder)localObject).toString());
        postReconnectMsg();
        return;
      }
      if (this.mFlvHandler != null)
      {
        this.mFlvHandler.sendEmptyMessage(101);
        return;
      }
    }
    catch (Error localError)
    {
      TXCLog.e("network.TXCFLVDownloader", "[Network]error");
      localError.printStackTrace();
      this.mInputStream = null;
      this.mConnection = null;
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("network.TXCFLVDownloader", "[Network]exception");
      localException.printStackTrace();
      this.mInputStream = null;
      this.mConnection = null;
      return;
      TXCLog.e("network.TXCFLVDownloader", "[Network]eof exception start reconnect");
      postReconnectMsg();
      return;
      TXCLog.e("network.TXCFLVDownloader", "[Network]ssl exception start reconnect");
      postReconnectMsg();
      return;
      TXCLog.e("network.TXCFLVDownloader", "[Network]socket exception start reconnect");
      postReconnectMsg();
      return;
      TXCLog.e("network.TXCFLVDownloader", "[Network]socket timeout start reconnect");
      postReconnectMsg();
      return;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      break label426;
    }
    catch (SocketException localSocketException)
    {
      break label413;
    }
    catch (SSLException localSSLException)
    {
      break label400;
    }
    catch (EOFException localEOFException)
    {
      label387:
      label400:
      label413:
      label426:
      break label387;
    }
  }
  
  private void reconnect()
  {
    processMsgDisConnect();
    if (this.connectRetryTimes < this.connectRetryLimit)
    {
      this.connectRetryTimes += 1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Network] start reconnect, times:");
      localStringBuilder.append(this.connectRetryTimes);
      localStringBuilder.append(" limit:");
      localStringBuilder.append(this.connectRetryLimit);
      TXCLog.i("network.TXCFLVDownloader", localStringBuilder.toString());
      processMsgConnect();
      sendNotifyEvent(2103);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Network] reconnect fail. all times retried. limit:");
    localStringBuilder.append(this.connectRetryLimit);
    TXCLog.i("network.TXCFLVDownloader", localStringBuilder.toString());
    sendNotifyEvent(-2301);
  }
  
  private void startInternal()
  {
    if (this.mFlvThread == null)
    {
      this.mFlvThread = new HandlerThread("FlvThread");
      this.mFlvThread.start();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Network] flv downloader thread id:");
      localStringBuilder.append(this.mFlvThread.getId());
      localStringBuilder.append(" instance:");
      localStringBuilder.append(hashCode());
      TXCLog.i("network.TXCFLVDownloader", localStringBuilder.toString());
    }
    if (this.mFlvHandler == null) {
      this.mFlvHandler = new TXCFLVDownloader.1(this, this.mFlvThread.getLooper());
    }
    postConnectMsg();
  }
  
  public void PushAudioFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
  {
    nativePushAudioFrame(this.mFLVParser, paramArrayOfByte, paramInt1, paramLong, paramInt2);
  }
  
  public void PushVideoFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    nativePushVideoFrame(this.mFLVParser, paramArrayOfByte, paramInt1, paramLong1, paramLong2, paramInt2);
  }
  
  public long getCurrentTS()
  {
    return this.mCurrentNalTs;
  }
  
  public TXCStreamDownloader.DownloadStats getDownloadStats()
  {
    TXCStreamDownloader.DownloadStats localDownloadStats = new TXCStreamDownloader.DownloadStats();
    localDownloadStats.afterParseAudioBytes = this.mStats.afterParseAudioBytes;
    localDownloadStats.afterParseVideoBytes = this.mStats.afterParseVideoBytes;
    localDownloadStats.beforeParseVideoBytes = this.mStats.beforeParseVideoBytes;
    localDownloadStats.beforeParseAudioBytes = this.mStats.beforeParseAudioBytes;
    localDownloadStats.videoGop = this.mStats.videoGop;
    localDownloadStats.startTS = this.mStats.startTS;
    localDownloadStats.dnsTS = this.mStats.dnsTS;
    localDownloadStats.connTS = this.mStats.connTS;
    localDownloadStats.firstAudioTS = this.mStats.firstAudioTS;
    localDownloadStats.firstVideoTS = this.mStats.firstVideoTS;
    localDownloadStats.serverIP = this.mStats.serverIP;
    localDownloadStats.flvSessionKey = this.mStats.flvSessionKey;
    localDownloadStats.errorCode = this.mStats.errorCode;
    localDownloadStats.errorInfo = this.mStats.errorInfo;
    return localDownloadStats;
  }
  
  public long getLastIFrameTS()
  {
    return this.mLastIFramelTs;
  }
  
  public String getRealStreamUrl()
  {
    HttpURLConnection localHttpURLConnection = this.mConnection;
    if (localHttpURLConnection != null) {
      return localHttpURLConnection.getURL().toString();
    }
    return null;
  }
  
  public native void nativePushAudioFrame(long paramLong1, byte[] paramArrayOfByte, int paramInt1, long paramLong2, int paramInt2);
  
  public native void nativePushVideoFrame(long paramLong1, byte[] paramArrayOfByte, int paramInt1, long paramLong2, long paramLong3, int paramInt2);
  
  public void onRecvAudioData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mHasReceivedFirstAudio)
    {
      this.mHasReceivedFirstAudio = true;
      this.mStats.firstAudioTS = TXCTimeUtil.getTimeTick();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[FirstFramePath][Network][Audio] TXCFlvDownloader: recv first audio frame. instance:");
      ((StringBuilder)localObject).append(hashCode());
      TXCLog.i("network.TXCFLVDownloader", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mStats;
    ((TXCStreamDownloader.DownloadStats)localObject).afterParseAudioBytes += paramArrayOfByte.length;
    super.onRecvAudioData(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
  
  public void onRecvVideoData(byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (!this.mHasReceivedFirstVideo)
    {
      this.mHasReceivedFirstVideo = true;
      this.mStats.firstVideoTS = TXCTimeUtil.getTimeTick();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[FirstFramePath][Network][Video] TXCFlvDownloader: recv first video frame. instance:");
      ((StringBuilder)localObject).append(hashCode());
      TXCLog.i("network.TXCFLVDownloader", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mStats;
    ((TXCStreamDownloader.DownloadStats)localObject).afterParseVideoBytes += paramArrayOfByte.length;
    super.onRecvVideoData(paramArrayOfByte, paramInt1, paramLong1, paramLong2, paramInt2);
  }
  
  public void recvData(boolean paramBoolean)
  {
    this.mHandleDataInJava = paramBoolean;
  }
  
  public void startDownload(Vector<e> paramVector, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (this.mIsRunning) {
      return;
    }
    if (paramVector != null)
    {
      if (paramVector.isEmpty()) {
        return;
      }
      this.mEnableMessage = paramBoolean3;
      this.mEnableMetaData = paramBoolean4;
      this.mIsRunning = true;
      this.mPlayUrl = ((e)paramVector.get(0)).a;
      paramVector = new StringBuilder();
      paramVector.append("start pull with url ");
      paramVector.append(this.mPlayUrl);
      TXCLog.i("network.TXCFLVDownloader", paramVector.toString());
      startInternal();
    }
  }
  
  public void stopDownload()
  {
    if (!this.mIsRunning) {
      return;
    }
    this.mIsRunning = false;
    TXCLog.i("network.TXCFLVDownloader", "stop pull");
    try
    {
      if (this.mFlvHandler != null)
      {
        this.mFlvHandler.removeCallbacksAndMessages(null);
        this.mFlvHandler.sendEmptyMessage(102);
        this.mFlvHandler.sendEmptyMessage(106);
        this.mFlvHandler = null;
        return;
      }
    }
    catch (Exception localException)
    {
      TXCLog.e("network.TXCFLVDownloader", "stop download failed.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.network.TXCFLVDownloader
 * JD-Core Version:    0.7.0.1
 */
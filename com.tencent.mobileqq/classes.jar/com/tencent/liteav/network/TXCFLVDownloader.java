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
    apiLog(paramContext.toString());
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
    apiLog(paramContext.toString());
  }
  
  private void apiError(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append("TXCFLVDownloader(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.e("network.TXCFLVDownloader", paramString.toString());
  }
  
  private void apiError(String paramString, Throwable paramThrowable)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append("TXCFLVDownloader(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.e("network.TXCFLVDownloader", paramString.toString(), paramThrowable);
  }
  
  private void apiLog(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append("TXCFLVDownloader (");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.i("network.TXCFLVDownloader", paramString.toString());
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
    apiLog(((StringBuilder)localObject1).toString());
    long l1 = System.currentTimeMillis();
    this.mConnection = ((HttpURLConnection)new URL(this.mPlayUrl).openConnection());
    this.mStats.dnsTS = TXCTimeUtil.getTimeTick();
    this.mConnection.setConnectTimeout(8000);
    this.mConnection.setReadTimeout(8000);
    this.mConnection.setRequestProperty("Accept-Encoding", "identity");
    this.mConnection.setInstanceFollowRedirects(true);
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
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("connect server success,ServerIp:");
    ((StringBuilder)localObject1).append(this.mStats.serverIP);
    localObject1 = ((StringBuilder)localObject1).toString();
    apiLog((String)localObject1);
    long l2 = System.currentTimeMillis();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[FirstFramePath][Network] TXCFLVDownloader: connect server success. instance:");
    ((StringBuilder)localObject2).append(hashCode());
    ((StringBuilder)localObject2).append(" ip:");
    ((StringBuilder)localObject2).append(this.mStats.serverIP);
    ((StringBuilder)localObject2).append(" cost:");
    ((StringBuilder)localObject2).append(l2 - l1);
    ((StringBuilder)localObject2).append(" rspCode:");
    ((StringBuilder)localObject2).append(this.mStats.errorCode);
    apiLog(((StringBuilder)localObject2).toString());
    sendNotifyEvent(2001, (String)localObject1);
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
        apiLog(((StringBuilder)localObject2).toString());
        sendNotifyEvent(2031, (String)localObject1);
      }
    }
  }
  
  private void disconnect()
  {
    apiLog("[Network]FLVDownloader disconnect.");
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
      apiLog(localStringBuilder.toString());
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
      apiLog(localStringBuilder.toString());
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
        localObject1 = this.mRefFLVDownloader;
        long l;
        if (localObject1 != null)
        {
          localObject1 = (TXCFLVDownloader)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            if (((TXCFLVDownloader)localObject1).mIsRunning)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[Network]init flv parser with old downloader:");
              ((StringBuilder)localObject2).append(localObject1.hashCode());
              apiLog(((StringBuilder)localObject2).toString());
              ((TXCFLVDownloader)localObject1).mStopJitter = false;
              l = ((TXCFLVDownloader)localObject1).mFLVParser;
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[Network]old downloader:");
              ((StringBuilder)localObject2).append(localObject1.hashCode());
              ((StringBuilder)localObject2).append(" isn't running now. just create new parser.");
              apiError(((StringBuilder)localObject2).toString());
            }
          }
          else {
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
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[Network]init flv parser with reference parse:");
          ((StringBuilder)localObject1).append(l);
          apiLog(((StringBuilder)localObject1).toString());
          this.mFLVParser = nativeInitFlvHanderByRef(l);
        }
        else
        {
          apiLog("[Network]init flv parser.");
          this.mFLVParser = nativeInitFlvHander(this.mUserID, 0, this.mEnableMessage, this.mEnableMetaData);
        }
      }
      Object localObject1 = this.mFlvHandler;
      if (localObject1 != null) {
        ((Handler)localObject1).sendEmptyMessage(101);
      }
      return;
    }
    catch (Error localError)
    {
      apiError("[Network]error, reconnect");
      localObject2 = this.mStats;
      ((TXCStreamDownloader.DownloadStats)localObject2).errorCode = -1;
      ((TXCStreamDownloader.DownloadStats)localObject2).errorInfo = localError.toString();
      localError.printStackTrace();
      postReconnectMsg();
      return;
    }
    catch (Exception localException)
    {
      apiError("[Network]exception, reconnect");
      localObject2 = this.mStats;
      ((TXCStreamDownloader.DownloadStats)localObject2).errorCode = -1;
      ((TXCStreamDownloader.DownloadStats)localObject2).errorInfo = localException.toString();
      localException.printStackTrace();
      postReconnectMsg();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      apiError("[Network]file not found, reconnect");
      localObject2 = this.mStats;
      ((TXCStreamDownloader.DownloadStats)localObject2).errorCode = -1;
      ((TXCStreamDownloader.DownloadStats)localObject2).errorInfo = localFileNotFoundException.toString();
      localFileNotFoundException.printStackTrace();
      postReconnectMsg();
      return;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      apiError("[Network]socket timeout, reconnect");
      Object localObject2 = this.mStats;
      ((TXCStreamDownloader.DownloadStats)localObject2).errorCode = -1;
      ((TXCStreamDownloader.DownloadStats)localObject2).errorInfo = localSocketTimeoutException.toString();
      postReconnectMsg();
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
      apiError("disconnect failed.", localException);
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
    apiLog(localStringBuilder.toString());
    if (this.mRestartListener != null) {
      this.mRestartListener.onOldStreamStop();
    }
  }
  
  private void processMsgRecvData()
  {
    Object localObject1 = this.mInputStream;
    if (localObject1 != null) {
      try
      {
        localObject2 = this.mPacketBytes;
        int i = 0;
        int j = ((InputStream)localObject1).read((byte[])localObject2, 0, 1388);
        if (j > 0)
        {
          long l1 = this.mDownloadedSize;
          long l2 = j;
          this.mDownloadedSize = (l1 + l2);
          if (!this.mRecvData)
          {
            this.mRecvData = true;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[FirstFramePath][Network] TXCFLVDownloader: recv first data packet. instance:");
            ((StringBuilder)localObject1).append(hashCode());
            apiLog(((StringBuilder)localObject1).toString());
          }
          if (this.mFLVParser != 0L)
          {
            localObject1 = this.mStats;
            ((TXCStreamDownloader.DownloadStats)localObject1).beforeParseVideoBytes += l2;
            i = nativeParseData(this.mFLVParser, this.mPacketBytes, j);
            this.mStats.afterParseVideoBytes = nativeGetVideoBytes(this.mFLVParser);
            this.mStats.afterParseAudioBytes = nativeGetAudioBytes(this.mFLVParser);
            this.mStats.videoGop = nativeGetVideoGop(this.mFLVParser);
          }
          if (i > 1048576)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[Network]flv play parse frame: ");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(" > ");
            ((StringBuilder)localObject1).append(1048576);
            ((StringBuilder)localObject1).append(",start reconnect");
            apiError(((StringBuilder)localObject1).toString());
            postReconnectMsg();
          }
        }
        else if (j < 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[Network]http read: ");
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append(" < 0, start reconnect");
          apiError(((StringBuilder)localObject1).toString());
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
        apiError("[Network]error");
        localObject2 = this.mStats;
        ((TXCStreamDownloader.DownloadStats)localObject2).errorCode = -1;
        ((TXCStreamDownloader.DownloadStats)localObject2).errorInfo = localError.toString();
        localError.printStackTrace();
        this.mInputStream = null;
        this.mConnection = null;
        return;
      }
      catch (Exception localException)
      {
        apiError("[Network]exception");
        localObject2 = this.mStats;
        ((TXCStreamDownloader.DownloadStats)localObject2).errorCode = -1;
        ((TXCStreamDownloader.DownloadStats)localObject2).errorInfo = localException.toString();
        localException.printStackTrace();
        this.mInputStream = null;
        this.mConnection = null;
        return;
      }
      catch (EOFException localEOFException)
      {
        apiError("[Network]eof exception start reconnect");
        localObject2 = this.mStats;
        ((TXCStreamDownloader.DownloadStats)localObject2).errorCode = -1;
        ((TXCStreamDownloader.DownloadStats)localObject2).errorInfo = localEOFException.toString();
        postReconnectMsg();
        return;
      }
      catch (SSLException localSSLException)
      {
        apiError("[Network]ssl exception start reconnect");
        localObject2 = this.mStats;
        ((TXCStreamDownloader.DownloadStats)localObject2).errorCode = -1;
        ((TXCStreamDownloader.DownloadStats)localObject2).errorInfo = localSSLException.toString();
        postReconnectMsg();
        return;
      }
      catch (SocketException localSocketException)
      {
        apiError("[Network]socket exception start reconnect");
        localObject2 = this.mStats;
        ((TXCStreamDownloader.DownloadStats)localObject2).errorCode = -1;
        ((TXCStreamDownloader.DownloadStats)localObject2).errorInfo = localSocketException.toString();
        postReconnectMsg();
        return;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        apiError("[Network]socket timeout start reconnect");
        Object localObject2 = this.mStats;
        ((TXCStreamDownloader.DownloadStats)localObject2).errorCode = -1;
        ((TXCStreamDownloader.DownloadStats)localObject2).errorInfo = localSocketTimeoutException.toString();
        postReconnectMsg();
      }
    }
  }
  
  private void reconnect()
  {
    processMsgDisConnect();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ServerIp:");
    ((StringBuilder)localObject).append(this.mStats.serverIP);
    ((StringBuilder)localObject).append(",errCode:");
    ((StringBuilder)localObject).append(this.mStats.errorCode);
    ((StringBuilder)localObject).append(",errInfo:");
    ((StringBuilder)localObject).append(this.mStats.errorInfo);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reconnect:");
    localStringBuilder.append((String)localObject);
    apiLog(localStringBuilder.toString());
    if (this.connectRetryTimes < this.connectRetryLimit)
    {
      this.connectRetryTimes += 1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Network] start reconnect, times:");
      localStringBuilder.append(this.connectRetryTimes);
      localStringBuilder.append(" limit:");
      localStringBuilder.append(this.connectRetryLimit);
      apiLog(localStringBuilder.toString());
      processMsgConnect();
      sendNotifyEvent(2103, (String)localObject);
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Network] reconnect fail. all times retried. limit:");
    localStringBuilder.append(this.connectRetryLimit);
    apiLog(localStringBuilder.toString());
    sendNotifyEvent(-2301, (String)localObject);
  }
  
  private void startInternal()
  {
    if (this.mFlvHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("FlvThread");
      localHandlerThread.start();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Network] flv downloader thread id:");
      localStringBuilder.append(localHandlerThread.getId());
      localStringBuilder.append(" instance:");
      localStringBuilder.append(hashCode());
      apiLog(localStringBuilder.toString());
      this.mFlvHandler = new TXCFLVDownloader.1(this, localHandlerThread.getLooper());
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
  
  public boolean hasRecvAVData()
  {
    return (this.mHasReceivedFirstAudio) || (this.mHasReceivedFirstVideo);
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
      apiLog(((StringBuilder)localObject).toString());
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
      apiLog(((StringBuilder)localObject).toString());
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
      apiLog(paramVector.toString());
      startInternal();
    }
  }
  
  public void stopDownload()
  {
    if (!this.mIsRunning) {
      return;
    }
    this.mIsRunning = false;
    apiLog("stop pull");
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
      apiError("stop download failed.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.TXCFLVDownloader
 * JD-Core Version:    0.7.0.1
 */
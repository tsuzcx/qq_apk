package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.h;
import java.util.Vector;

public class TXCRTMPDownloader
  extends TXIStreamDownloader
{
  private final int MSG_EVENT = 102;
  private final int MSG_RECONNECT = 101;
  private final String TAG = "network.TXCRTMPDownloader";
  private int mConnectCountQuic = 0;
  private int mConnectCountTcp = 0;
  private TXCRTMPDownloader.a mCurrentThread = null;
  private boolean mEnableNearestIP = false;
  private Handler mHandler = null;
  private boolean mHasTcpPlayUrl;
  private boolean mIsPlayRtmpAccStream = false;
  private int mLastNetworkType = 0;
  private String mPlayUrl = "";
  private boolean mQuicChannel = false;
  private Object mRTMPThreadLock = null;
  private String mServerIp = "";
  private HandlerThread mThread = null;
  private Vector<e> mVecPlayUrls;
  
  public TXCRTMPDownloader(Context paramContext)
  {
    super(paramContext);
  }
  
  private void internalReconnect(boolean paramBoolean)
  {
    if (!this.mIsRunning) {
      return;
    }
    if ((this.mIsPlayRtmpAccStream) && (this.mLastNetworkType != h.e(this.mApplicationContext)))
    {
      this.mLastNetworkType = h.e(this.mApplicationContext);
      if (this.mRestartListener != null) {
        this.mRestartListener.onRestartDownloader();
      }
      return;
    }
    boolean bool = this.mQuicChannel;
    Object localObject;
    if (this.mIsPlayRtmpAccStream)
    {
      if (!this.mEnableNearestIP) {
        paramBoolean = false;
      }
      if (bool) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        localObject = this.mVecPlayUrls;
        if ((localObject != null) && (!((Vector)localObject).isEmpty()))
        {
          localObject = (e)this.mVecPlayUrls.get(0);
          this.mVecPlayUrls.remove(0);
          this.mPlayUrl = ((e)localObject).a;
          this.mQuicChannel = ((e)localObject).b;
        }
      }
    }
    if ((bool) && (this.mHasTcpPlayUrl))
    {
      sendNotifyEvent(2103);
      startInternal();
      return;
    }
    if (this.connectRetryTimes < this.connectRetryLimit)
    {
      this.connectRetryTimes += 1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reconnect retry count:");
      ((StringBuilder)localObject).append(this.connectRetryTimes);
      ((StringBuilder)localObject).append(" limit:");
      ((StringBuilder)localObject).append(this.connectRetryLimit);
      TXCLog.i("network.TXCRTMPDownloader", ((StringBuilder)localObject).toString());
      sendNotifyEvent(2103);
      startInternal();
      return;
    }
    TXCLog.e("network.TXCRTMPDownloader", "reconnect all times retried, send failed event ");
    sendNotifyEvent(-2301);
  }
  
  private native TXCStreamDownloader.DownloadStats nativeGetStats(long paramLong);
  
  private native long nativeInitRtmpHandler(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  private native void nativeRequestKeyFrame(long paramLong, String paramString);
  
  private native void nativeStart(long paramLong);
  
  private native void nativeStop(long paramLong);
  
  private native void nativeUninitRtmpHandler(long paramLong);
  
  private void postReconnectMsg()
  {
    Message localMessage = new Message();
    localMessage.what = 101;
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.sendMessageDelayed(localMessage, this.connectRetryInterval * 1000);
    }
  }
  
  private void reconnect(boolean paramBoolean)
  {
    synchronized (this.mRTMPThreadLock)
    {
      if (this.mCurrentThread != null)
      {
        this.mCurrentThread.a();
        this.mCurrentThread = null;
      }
      ??? = this.mHandler;
      if (??? != null) {
        ((Handler)???).postDelayed(new TXCRTMPDownloader.1(this, paramBoolean), this.connectRetryInterval * 1000);
      }
      return;
    }
  }
  
  private void startInternal()
  {
    if (this.mQuicChannel) {
      this.mConnectCountQuic += 1;
    } else {
      this.mConnectCountTcp += 1;
    }
    synchronized (this.mRTMPThreadLock)
    {
      this.mCurrentThread = new TXCRTMPDownloader.a(this, this.mPlayUrl, this.mQuicChannel);
      this.mCurrentThread.start();
      return;
    }
  }
  
  public int getConnectCountQuic()
  {
    return this.mConnectCountQuic;
  }
  
  public int getConnectCountTcp()
  {
    return this.mConnectCountTcp;
  }
  
  public String getCurrentStreamUrl()
  {
    return this.mPlayUrl;
  }
  
  public TXCStreamDownloader.DownloadStats getDownloadStats()
  {
    synchronized (this.mRTMPThreadLock)
    {
      if (this.mCurrentThread != null)
      {
        TXCStreamDownloader.DownloadStats localDownloadStats = this.mCurrentThread.b();
        return localDownloadStats;
      }
      return null;
    }
  }
  
  public boolean isQuicChannel()
  {
    return this.mQuicChannel;
  }
  
  public void requestKeyFrame(String paramString)
  {
    synchronized (this.mRTMPThreadLock)
    {
      if (this.mCurrentThread != null) {
        this.mCurrentThread.a(paramString);
      }
      return;
    }
  }
  
  public void sendNotifyEvent(int paramInt)
  {
    boolean bool = true;
    if ((paramInt != 0) && (paramInt != 1))
    {
      super.sendNotifyEvent(paramInt);
      return;
    }
    if (paramInt != 1) {
      bool = false;
    }
    reconnect(bool);
  }
  
  public void sendNotifyEvent(int paramInt, String paramString)
  {
    if (paramString.isEmpty())
    {
      sendNotifyEvent(paramInt);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_MSG", paramString);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    if (this.mNotifyListener != null) {
      this.mNotifyListener.onNotifyEvent(paramInt, localBundle);
    }
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
      this.mIsPlayRtmpAccStream = paramBoolean1;
      this.mEnableNearestIP = paramBoolean2;
      this.mVecPlayUrls = paramVector;
      this.mHasTcpPlayUrl = false;
      int i = 0;
      while (i < this.mVecPlayUrls.size())
      {
        if (!((e)this.mVecPlayUrls.elementAt(i)).b)
        {
          this.mHasTcpPlayUrl = true;
          break;
        }
        i += 1;
      }
      paramVector = (e)this.mVecPlayUrls.get(0);
      this.mVecPlayUrls.remove(0);
      this.mPlayUrl = paramVector.a;
      this.mQuicChannel = paramVector.b;
      this.mIsRunning = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start pull with url:");
      localStringBuilder.append(this.mPlayUrl);
      localStringBuilder.append(" quic:");
      if (this.mQuicChannel) {
        paramVector = "yes";
      } else {
        paramVector = "no";
      }
      localStringBuilder.append(paramVector);
      TXCLog.i("network.TXCRTMPDownloader", localStringBuilder.toString());
      this.mConnectCountQuic = 0;
      this.mConnectCountTcp = 0;
      this.connectRetryTimes = 0;
      if (this.mThread == null)
      {
        this.mThread = new HandlerThread("RTMP_PULL");
        this.mThread.start();
      }
      this.mHandler = new TXCRTMPDownloader.2(this, this.mThread.getLooper());
      startInternal();
    }
  }
  
  public void stopDownload()
  {
    if (!this.mIsRunning) {
      return;
    }
    this.mIsRunning = false;
    this.mVecPlayUrls.removeAllElements();
    this.mVecPlayUrls = null;
    this.mIsPlayRtmpAccStream = false;
    this.mEnableNearestIP = false;
    TXCLog.i("network.TXCRTMPDownloader", "stop pull");
    synchronized (this.mRTMPThreadLock)
    {
      if (this.mCurrentThread != null)
      {
        this.mCurrentThread.a();
        this.mCurrentThread = null;
      }
      ??? = this.mThread;
      if (??? != null)
      {
        ((HandlerThread)???).quit();
        this.mThread = null;
      }
      if (this.mHandler != null) {
        this.mHandler = null;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.TXCRTMPDownloader
 * JD-Core Version:    0.7.0.1
 */
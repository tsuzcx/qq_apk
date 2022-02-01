package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.h;
import java.util.Map;
import java.util.Vector;

public class TXCStreamDownloader
  extends com.tencent.liteav.basic.module.a
  implements b, TXIStreamDownloader.a, d.a, f
{
  public static final String TAG = "TXCStreamDownloader";
  private g mAccUrlFetcher;
  private Context mApplicationContext;
  private int mChannelType = 0;
  private int mConnectRetryInterval = 3;
  private int mConnectRetryLimit = 3;
  private long mCurrentNalTs = 0L;
  private int mDownloadFormat = 1;
  private TXIStreamDownloader mDownloader = null;
  private boolean mDownloaderRunning = false;
  private boolean mEnableMessage = false;
  private boolean mEnableMetaData = false;
  private boolean mEnableNearestIP = false;
  private String mFlvSessionKey = "";
  private Handler mHandler = null;
  protected Map<String, String> mHeaders;
  private TXCStreamDownloader.DownloadStats mLastDownloadStats = null;
  private long mLastIFramelTs = 0L;
  private long mLastTimeStamp = 0L;
  private f mListener = null;
  private byte[] mListenerLock = new byte[0];
  private b mNotifyListener = null;
  private String mOriginPlayUrl = "";
  private boolean mRecvFirstNal = false;
  private Runnable mReportNetStatusRunnalbe = new TXCStreamDownloader.3(this);
  private d mStreamSwitcher = null;
  private long mSwitchStartTime = 0L;
  
  static
  {
    h.f();
  }
  
  public TXCStreamDownloader(Context paramContext, int paramInt)
  {
    createDownloader(paramContext, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("new inner downloader. instance:");
    localStringBuilder.append(this.mDownloader.hashCode());
    apiLog(localStringBuilder.toString());
    this.mDownloadFormat = paramInt;
    this.mAccUrlFetcher = new g(paramContext);
    this.mApplicationContext = paramContext;
    paramContext = this.mApplicationContext;
    if (paramContext != null) {
      this.mHandler = new Handler(paramContext.getMainLooper());
    }
  }
  
  private void apiError(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append("TXCStreamDownloader(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.e("TXCStreamDownloader", paramString.toString());
  }
  
  private void apiLog(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append("TXCStreamDownloader(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.i("TXCStreamDownloader", paramString.toString());
  }
  
  private void apiWarn(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append("TXCStreamDownloader(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.w("TXCStreamDownloader", paramString.toString());
  }
  
  private void createDownloader(Context paramContext, int paramInt)
  {
    if (paramInt == 0)
    {
      this.mDownloader = new TXCFLVDownloader(paramContext);
      this.mDownloader.setFlvSessionKey(this.mFlvSessionKey);
    }
    else if ((paramInt == 1) || (paramInt == 4))
    {
      this.mDownloader = new TXCRTMPDownloader(paramContext);
    }
    paramContext = this.mDownloader;
    if (paramContext != null)
    {
      paramContext.setListener(this);
      this.mDownloader.setNotifyListener(this);
      this.mDownloader.setRestartListener(this);
      paramContext = this.mDownloader;
      paramContext.connectRetryLimit = this.mConnectRetryLimit;
      paramContext.connectRetryInterval = this.mConnectRetryInterval;
      paramContext.setHeaders(this.mHeaders);
      this.mDownloader.setUserID(getID());
    }
  }
  
  private TXCStreamDownloader.DownloadStats getDownloadStats()
  {
    TXIStreamDownloader localTXIStreamDownloader = this.mDownloader;
    if (localTXIStreamDownloader != null) {
      return localTXIStreamDownloader.getDownloadStats();
    }
    return null;
  }
  
  private TXCStreamDownloader.a getRealTimeStreamInfo()
  {
    Object localObject = this.mAccUrlFetcher;
    if ((localObject != null) && (!TextUtils.isEmpty(((g)localObject).a())))
    {
      localObject = new TXCStreamDownloader.a();
      ((TXCStreamDownloader.a)localObject).b = this.mAccUrlFetcher.a();
      ((TXCStreamDownloader.a)localObject).c = this.mAccUrlFetcher.b();
      ((TXCStreamDownloader.a)localObject).d = this.mAccUrlFetcher.c();
      ((TXCStreamDownloader.a)localObject).e = this.mAccUrlFetcher.d();
    }
    else
    {
      localObject = null;
    }
    TXIStreamDownloader localTXIStreamDownloader = this.mDownloader;
    if ((localTXIStreamDownloader != null) && (localObject != null))
    {
      ((TXCStreamDownloader.a)localObject).a = localTXIStreamDownloader.getCurrentStreamUrl();
      ((TXCStreamDownloader.a)localObject).f = this.mDownloader.isQuicChannel();
    }
    return localObject;
  }
  
  private Long getSpeed(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 <= paramLong2) {
      paramLong2 -= paramLong1;
    }
    paramLong1 = 0L;
    if (paramLong3 > 0L) {
      paramLong1 = paramLong2 * 8L * 1000L / (paramLong3 * 1024L);
    }
    return Long.valueOf(paramLong1);
  }
  
  private native String nativeGetRTMPProxyUserId();
  
  private void notifySwitchStreamResult(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notify switch stream result. result: ");
    ((StringBuilder)localObject).append(paramBoolean);
    apiLog(((StringBuilder)localObject).toString());
    localObject = this.mNotifyListener;
    if (localObject == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    if (paramBoolean)
    {
      localBundle.putInt("EVT_ID", 2015);
      localBundle.putCharSequence("EVT_MSG", "Switched resolution successfully");
      ((b)localObject).onNotifyEvent(2015, localBundle);
      return;
    }
    localBundle.putInt("EVT_ID", -2307);
    localBundle.putCharSequence("EVT_MSG", "Failed to switch resolution");
    ((b)localObject).onNotifyEvent(-2307, localBundle);
  }
  
  private void playStreamWithRawUrl(String paramString, boolean paramBoolean)
  {
    if (this.mDownloader != null)
    {
      if ((paramString != null) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) && (paramString.contains(".flv")))
      {
        createDownloader(this.mApplicationContext, 0);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("new downloader for play raw url. instance:");
        ((StringBuilder)localObject).append(this.mDownloader.hashCode());
        apiLog(((StringBuilder)localObject).toString());
      }
      setStatusValue(7112, Long.valueOf(1L));
      Object localObject = new Vector();
      ((Vector)localObject).add(new e(paramString, false));
      this.mDownloader.setOriginUrl(paramString);
      this.mDownloader.startDownload((Vector)localObject, false, false, paramBoolean, paramBoolean);
    }
  }
  
  private void reportNetStatus()
  {
    reportNetStatusInternal();
    this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000L);
  }
  
  private void reportNetStatusInternal()
  {
    long l3 = TXCTimeUtil.getTimeTick();
    long l1 = l3 - this.mLastTimeStamp;
    TXCStreamDownloader.DownloadStats localDownloadStats1 = getDownloadStats();
    Object localObject = getRealTimeStreamInfo();
    if (localDownloadStats1 != null)
    {
      TXCStreamDownloader.DownloadStats localDownloadStats2 = this.mLastDownloadStats;
      long l2;
      if (localDownloadStats2 != null)
      {
        l2 = getSpeed(localDownloadStats2.afterParseVideoBytes, localDownloadStats1.afterParseVideoBytes, l1).longValue();
        l1 = getSpeed(this.mLastDownloadStats.afterParseAudioBytes, localDownloadStats1.afterParseAudioBytes, l1).longValue();
      }
      else
      {
        l1 = 0L;
        l2 = l1;
      }
      if ((l2 > 0L) || (l1 > 0L)) {
        this.mDownloader.connectRetryTimes = 0;
      }
      setStatusValue(7101, Long.valueOf(l2));
      setStatusValue(7102, Long.valueOf(l1));
      setStatusValue(7103, Long.valueOf(localDownloadStats1.firstVideoTS));
      setStatusValue(7104, Long.valueOf(localDownloadStats1.firstAudioTS));
      setStatusValue(7120, Long.valueOf(localDownloadStats1.videoGop));
      l1 = 1L;
      if (localObject != null)
      {
        setStatusValue(7105, Long.valueOf(((TXCStreamDownloader.a)localObject).d));
        setStatusValue(7106, ((TXCStreamDownloader.a)localObject).e);
        if (((TXCStreamDownloader.a)localObject).f) {
          l1 = 2L;
        }
        setStatusValue(7111, Long.valueOf(l1));
        setStatusValue(7116, ((TXCStreamDownloader.a)localObject).a);
        setStatusValue(7117, ((TXCStreamDownloader.a)localObject).b);
        setStatusValue(7118, ((TXCStreamDownloader.a)localObject).c);
      }
      else
      {
        setStatusValue(7105, Long.valueOf(localDownloadStats1.errorCode));
        setStatusValue(7106, localDownloadStats1.errorInfo);
        setStatusValue(7111, Long.valueOf(1L));
      }
      setStatusValue(7107, Long.valueOf(localDownloadStats1.startTS));
      setStatusValue(7108, Long.valueOf(localDownloadStats1.dnsTS));
      setStatusValue(7109, Long.valueOf(localDownloadStats1.connTS));
      setStatusValue(7110, String.valueOf(localDownloadStats1.serverIP));
    }
    localObject = this.mDownloader;
    if (localObject != null)
    {
      int i = ((TXIStreamDownloader)localObject).getConnectCountQuic();
      int j = this.mDownloader.getConnectCountTcp();
      setStatusValue(7114, Long.valueOf(i + 1));
      setStatusValue(7115, Long.valueOf(j + 1));
      setStatusValue(7119, this.mDownloader.getRealStreamUrl());
      setStatusValue(7121, String.valueOf(this.mDownloader.getFlvSessionKey()));
    }
    this.mLastTimeStamp = l3;
    this.mLastDownloadStats = localDownloadStats1;
  }
  
  private void tryResetRetryCount()
  {
    TXIStreamDownloader localTXIStreamDownloader = this.mDownloader;
    if (localTXIStreamDownloader != null) {
      localTXIStreamDownloader.connectRetryTimes = 0;
    }
  }
  
  public String getRTMPProxyUserId()
  {
    return nativeGetRTMPProxyUserId();
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    b localb = this.mNotifyListener;
    if (localb != null)
    {
      Object localObject2 = new Bundle();
      Object localObject1;
      if (paramInt != -2308)
      {
        if (paramInt != 2012)
        {
          if ((paramInt != 2028) && (paramInt != 2031))
          {
            if (paramInt != 2103)
            {
              if (paramInt != 3010)
              {
                if (paramInt != -2302)
                {
                  if (paramInt != -2301)
                  {
                    if (paramInt != 2001)
                    {
                      if (paramInt != 2002)
                      {
                        if (paramInt != 3002)
                        {
                          if (paramInt != 3003)
                          {
                            if (paramInt != 3006)
                            {
                              if (paramInt != 3007)
                              {
                                localObject1 = new StringBuilder();
                                ((StringBuilder)localObject1).append("UNKNOWN event = ");
                                ((StringBuilder)localObject1).append(paramInt);
                                ((Bundle)localObject2).putString("EVT_MSG", ((StringBuilder)localObject1).toString());
                                localObject1 = localObject2;
                              }
                              else
                              {
                                ((Bundle)localObject2).putString("EVT_MSG", "Read data error");
                                localObject1 = localObject2;
                              }
                            }
                            else
                            {
                              ((Bundle)localObject2).putString("EVT_MSG", "Write data error");
                              localObject1 = localObject2;
                            }
                          }
                          else
                          {
                            ((Bundle)localObject2).putString("EVT_MSG", "RTMP handshake failed");
                            localObject1 = localObject2;
                          }
                        }
                        else
                        {
                          ((Bundle)localObject2).putString("EVT_MSG", "Failed to connect server");
                          localObject1 = localObject2;
                        }
                      }
                      else
                      {
                        ((Bundle)localObject2).putString("EVT_MSG", "begin receiving stream");
                        localObject1 = localObject2;
                      }
                    }
                    else
                    {
                      ((Bundle)localObject2).putString("EVT_MSG", "connection SUCCESS");
                      localObject1 = localObject2;
                    }
                  }
                  else
                  {
                    ((Bundle)localObject2).putString("EVT_MSG", "failed to connect server for several times, abort connection");
                    localObject1 = localObject2;
                  }
                }
                else
                {
                  ((Bundle)localObject2).putString("EVT_MSG", "Failed to get accelerated pull address");
                  localObject1 = localObject2;
                }
              }
              else
              {
                ((Bundle)localObject2).putString("EVT_MSG", "No video at this stream address");
                localObject1 = localObject2;
              }
            }
            else
            {
              ((Bundle)localObject2).putString("EVT_MSG", "retry connecting stream server");
              localObject1 = localObject2;
            }
          }
          else {
            localObject1 = paramBundle;
          }
        }
        else
        {
          byte[] arrayOfByte = paramBundle.getByteArray("EVT_GET_MSG");
          localObject1 = localObject2;
          if (arrayOfByte != null)
          {
            localObject1 = localObject2;
            if (arrayOfByte.length > 0)
            {
              ((Bundle)localObject2).putByteArray("EVT_GET_MSG", arrayOfByte);
              localObject1 = localObject2;
            }
          }
        }
      }
      else
      {
        ((Bundle)localObject2).putString("EVT_MSG", "The server rejected the connection request");
        localObject1 = localObject2;
      }
      localObject2 = "";
      if (paramBundle != null) {
        localObject2 = paramBundle.getString("EVT_MSG", "");
      }
      if ((localObject2 != null) && (!((String)localObject2).isEmpty())) {
        ((Bundle)localObject1).putString("EVT_MSG", (String)localObject2);
      }
      ((Bundle)localObject1).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      ((Bundle)localObject1).putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      localb.onNotifyEvent(paramInt, (Bundle)localObject1);
      if ((paramInt == 3001) || (paramInt == 3002) || (paramInt == 3003) || (paramInt == 3004) || (paramInt == 3005) || (paramInt == 3006) || (paramInt == 3007) || (paramInt == 3008) || (paramInt == 3009) || (paramInt == 3010) || (paramInt == 2101) || (paramInt == 2102) || (paramInt == 2109) || (paramInt == 2110) || (paramInt == -2301) || (paramInt == -2304) || (paramInt == -2308) || (paramInt == -2309))
      {
        setStatusValue(7105, Integer.valueOf(paramInt));
        if (localObject1 != null) {
          setStatusValue(7106, ((Bundle)localObject1).getString("EVT_MSG"));
        }
      }
    }
    if (paramInt == 2001) {
      reportNetStatusInternal();
    }
  }
  
  public void onOldStreamStop()
  {
    synchronized (this.mListenerLock)
    {
      if (this.mStreamSwitcher != null) {
        this.mStreamSwitcher.b();
      }
      return;
    }
  }
  
  public void onPullAudio(com.tencent.liteav.basic.structs.a parama)
  {
    tryResetRetryCount();
    synchronized (this.mListenerLock)
    {
      if (this.mListener != null) {
        this.mListener.onPullAudio(parama);
      }
      if (this.mDownloader != null) {
        this.mDownloader.PushAudioFrame(parama.f, parama.h, parama.e, parama.g);
      }
      return;
    }
  }
  
  public void onPullNAL(TXSNALPacket paramTXSNALPacket)
  {
    tryResetRetryCount();
    if (!this.mRecvFirstNal)
    {
      reportNetStatusInternal();
      this.mRecvFirstNal = true;
    }
    synchronized (this.mListenerLock)
    {
      this.mCurrentNalTs = paramTXSNALPacket.pts;
      if (paramTXSNALPacket.nalType == 0) {
        this.mLastIFramelTs = paramTXSNALPacket.pts;
      }
      if (this.mListener != null) {
        this.mListener.onPullNAL(paramTXSNALPacket);
      }
      if (this.mDownloader != null) {
        this.mDownloader.PushVideoFrame(paramTXSNALPacket.nalData, paramTXSNALPacket.nalType, paramTXSNALPacket.dts, paramTXSNALPacket.pts, paramTXSNALPacket.codecId);
      }
      return;
    }
  }
  
  public void onRestartDownloader()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.post(new TXCStreamDownloader.1(this));
    }
  }
  
  public void onSwitchFinish(TXIStreamDownloader paramTXIStreamDownloader, boolean paramBoolean)
  {
    synchronized (this.mListenerLock)
    {
      int i = (int)(System.currentTimeMillis() - this.mSwitchStartTime);
      this.mSwitchStartTime = 0L;
      if (paramBoolean)
      {
        this.mDownloader = paramTXIStreamDownloader;
        this.mDownloader.setListener(this);
        this.mDownloader.setNotifyListener(this);
        this.mDownloader.setRestartListener(this);
        TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.bx, i, "");
      }
      else
      {
        TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.by);
      }
      this.mStreamSwitcher = null;
      notifySwitchStreamResult(paramBoolean);
      return;
    }
  }
  
  public void requestKeyFrame(String paramString)
  {
    if ((this.mDownloaderRunning) && (paramString != null) && (paramString.startsWith("room")))
    {
      TXIStreamDownloader localTXIStreamDownloader = this.mDownloader;
      if (localTXIStreamDownloader != null) {
        localTXIStreamDownloader.requestKeyFrame(paramString);
      }
    }
  }
  
  public void setFlvSessionKey(String paramString)
  {
    this.mFlvSessionKey = paramString;
    TXIStreamDownloader localTXIStreamDownloader = this.mDownloader;
    if (localTXIStreamDownloader != null) {
      localTXIStreamDownloader.setFlvSessionKey(paramString);
    }
  }
  
  public void setHeaders(Map<String, String> paramMap)
  {
    this.mHeaders = paramMap;
    paramMap = this.mDownloader;
    if (paramMap != null) {
      paramMap.setHeaders(this.mHeaders);
    }
  }
  
  public void setID(String paramString)
  {
    super.setID(paramString);
    TXIStreamDownloader localTXIStreamDownloader = this.mDownloader;
    if (localTXIStreamDownloader != null) {
      localTXIStreamDownloader.setUserID(paramString);
    }
  }
  
  public void setListener(f paramf)
  {
    synchronized (this.mListenerLock)
    {
      this.mListener = paramf;
      return;
    }
  }
  
  public void setNotifyListener(b paramb)
  {
    synchronized (this.mListenerLock)
    {
      this.mNotifyListener = paramb;
      return;
    }
  }
  
  public void setRetryInterval(int paramInt)
  {
    this.mConnectRetryInterval = paramInt;
    TXIStreamDownloader localTXIStreamDownloader = this.mDownloader;
    if (localTXIStreamDownloader != null) {
      localTXIStreamDownloader.connectRetryInterval = paramInt;
    }
  }
  
  public void setRetryTimes(int paramInt)
  {
    this.mConnectRetryLimit = paramInt;
    TXIStreamDownloader localTXIStreamDownloader = this.mDownloader;
    if (localTXIStreamDownloader != null) {
      localTXIStreamDownloader.connectRetryLimit = paramInt;
    }
  }
  
  public int start(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start url:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" ,enableNearestIP:");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" ,channeyType:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" ,enableMessage:");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(" ,enableMetaData:");
    ((StringBuilder)localObject).append(paramBoolean3);
    apiLog(((StringBuilder)localObject).toString());
    boolean bool1 = true;
    this.mDownloaderRunning = true;
    this.mRecvFirstNal = false;
    this.mOriginPlayUrl = paramString;
    this.mEnableNearestIP = paramBoolean1;
    this.mChannelType = paramInt;
    this.mEnableMessage = paramBoolean2;
    this.mEnableMetaData = paramBoolean3;
    localObject = Long.valueOf(0L);
    setStatusValue(7113, localObject);
    setStatusValue(7114, localObject);
    setStatusValue(7115, localObject);
    boolean bool2 = paramString.startsWith("room");
    localObject = Long.valueOf(1L);
    if (bool2)
    {
      setStatusValue(7113, localObject);
      setStatusValue(7112, Long.valueOf(2L));
      setStatusValue(7116, paramString);
      if (this.mDownloader != null)
      {
        localObject = new Vector();
        ((Vector)localObject).add(new e(paramString, true));
        this.mDownloader.setOriginUrl(paramString);
        this.mDownloader.setUserID(getID());
        this.mDownloader.startDownload((Vector)localObject, false, false, paramBoolean2, paramBoolean3);
      }
      paramString = this.mHandler;
      if (paramString != null) {
        paramString.postDelayed(this.mReportNetStatusRunnalbe, 2000L);
      }
      return 0;
    }
    if ((paramBoolean1) && (this.mDownloadFormat == 4))
    {
      paramInt = this.mAccUrlFetcher.a(paramString, paramInt, new TXCStreamDownloader.2(this, paramString, paramBoolean2, paramBoolean3));
      if (paramInt != 0)
      {
        if (paramInt == -1) {
          TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.au, paramInt, "invalid playUrl");
        } else if (paramInt == -2) {
          TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.au, paramInt, "invalid streamID");
        } else if (paramInt == -3) {
          TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.au, paramInt, "invalid signature");
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getAccelerateStreamPlayUrl failed, result = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", play stream with raw url");
        apiError(((StringBuilder)localObject).toString());
        onNotifyEvent(-2302, null);
        playStreamWithRawUrl(paramString, paramBoolean2);
        paramString = this.mHandler;
        if (paramString != null) {
          paramString.postDelayed(this.mReportNetStatusRunnalbe, 2000L);
        }
      }
      return 0;
    }
    if (this.mDownloader != null)
    {
      setStatusValue(7112, localObject);
      localObject = new Vector();
      ((Vector)localObject).add(new e(paramString, false));
      this.mDownloader.setOriginUrl(paramString);
      paramString = this.mDownloader;
      if (this.mDownloadFormat != 4) {
        bool1 = false;
      }
      paramString.startDownload((Vector)localObject, bool1, paramBoolean1, paramBoolean2, paramBoolean3);
      paramString = this.mHandler;
      if (paramString != null) {
        paramString.postDelayed(this.mReportNetStatusRunnalbe, 2000L);
      }
    }
    return 0;
  }
  
  public void stop()
  {
    this.mDownloaderRunning = false;
    this.mRecvFirstNal = false;
    ??? = this.mDownloader;
    if (??? != null) {
      ((TXIStreamDownloader)???).stopDownload();
    }
    ??? = this.mHandler;
    if (??? != null) {
      ((Handler)???).removeCallbacks(this.mReportNetStatusRunnalbe);
    }
    synchronized (this.mListenerLock)
    {
      if (this.mStreamSwitcher != null)
      {
        this.mStreamSwitcher.a(null);
        this.mStreamSwitcher.a();
        this.mStreamSwitcher = null;
      }
      return;
    }
  }
  
  public boolean switchStream(String paramString)
  {
    for (;;)
    {
      synchronized (this.mListenerLock)
      {
        localObject = this.mDownloader;
        if ((this.mStreamSwitcher == null) && (localObject != null) && ((localObject instanceof TXCFLVDownloader)))
        {
          TXCFLVDownloader localTXCFLVDownloader1 = (TXCFLVDownloader)this.mDownloader;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[SwitchStream] prepare to switch stream. hasRecvData:");
          ((StringBuilder)localObject).append(localTXCFLVDownloader1.hasRecvAVData());
          apiLog(((StringBuilder)localObject).toString());
          if (!localTXCFLVDownloader1.hasRecvAVData())
          {
            apiError("[SwitchStream] force restart downloader when no av data.");
            localTXCFLVDownloader1.setListener(null);
            localTXCFLVDownloader1.setNotifyListener(null);
            localTXCFLVDownloader1.setRestartListener(null);
            stop();
            createDownloader(this.mApplicationContext, this.mDownloadFormat);
            start(paramString, this.mEnableNearestIP, this.mChannelType, this.mEnableMessage, this.mEnableMetaData);
            notifySwitchStreamResult(true);
          }
          else
          {
            TXCFLVDownloader localTXCFLVDownloader2 = new TXCFLVDownloader(this.mApplicationContext, localTXCFLVDownloader1);
            localTXCFLVDownloader2.connectRetryLimit = localTXCFLVDownloader1.connectRetryLimit;
            localTXCFLVDownloader2.connectRetryInterval = localTXCFLVDownloader1.connectRetryInterval;
            localTXCFLVDownloader2.setHeaders(this.mHeaders);
            localTXCFLVDownloader2.setUserID(getID());
            localTXCFLVDownloader2.setFlvSessionKey(this.mFlvSessionKey);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("switch stream. switcher instance:");
            localStringBuilder.append(this.mStreamSwitcher);
            localStringBuilder.append(" new downloader instance:");
            localStringBuilder.append(localTXCFLVDownloader2.hashCode());
            localStringBuilder.append(" old downloader instance:");
            if (this.mDownloader == null) {
              break label378;
            }
            localObject = Integer.valueOf(this.mDownloader.hashCode());
            localStringBuilder.append(localObject);
            apiLog(localStringBuilder.toString());
            this.mStreamSwitcher = new d(this);
            this.mStreamSwitcher.a(this);
            this.mStreamSwitcher.a(localTXCFLVDownloader1, localTXCFLVDownloader2, this.mCurrentNalTs, this.mLastIFramelTs, paramString);
            this.mSwitchStartTime = System.currentTimeMillis();
          }
          return true;
        }
        else
        {
          apiError("stream_switch stream is changing ignore this change");
          return false;
        }
      }
      label378:
      Object localObject = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamDownloader
 * JD-Core Version:    0.7.0.1
 */
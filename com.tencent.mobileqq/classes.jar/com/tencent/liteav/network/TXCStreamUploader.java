package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class TXCStreamUploader
  extends com.tencent.liteav.basic.module.a
  implements b
{
  public static final int RTMPSENDSTRATEGY_LIVE = 1;
  public static final int RTMPSENDSTRATEGY_REALTIME_QUIC = 3;
  public static final int RTMPSENDSTRATEGY_REALTIME_TCP = 2;
  static final String TAG = "TXCStreamUploader";
  public static final int TXE_UPLOAD_MODE_AUDIO_ONLY = 1;
  public static final int TXE_UPLOAD_MODE_LINK_MIC = 2;
  public static final int TXE_UPLOAD_MODE_REAL_TIME = 0;
  public static final int TXE_UPLOAD_PROTOCOL_AV = 1;
  public static final int TXE_UPLOAD_PROTOCOL_RTMP = 0;
  private final int MSG_EVENT = 102;
  private final int MSG_RECONNECT = 101;
  private final int MSG_REPORT_STATUS = 103;
  private final int MSG_RTMPPROXY_HEARTBEAT = 104;
  private boolean mAudioMuted = false;
  private int mChannelType = 0;
  private int mConnectCountQuic = 0;
  private int mConnectCountTcp = 0;
  private long mConnectSuccessTimeStamps = 0L;
  private Context mContext = null;
  private int mCurrentRecordIdx = 0;
  private boolean mEnableNearestIP = true;
  private long mGoodPushTime = 30000L;
  private Handler mHandler = null;
  private HandlerThread mHandlerThread = null;
  private c mIntelligentRoute = null;
  private ArrayList<a> mIpList = null;
  private boolean mIsPushing = false;
  private int mLastNetworkType = 0;
  private long mLastTimeStamp = 0L;
  private TXCStreamUploader.UploadStats mLastUploadStats = null;
  HashMap<String, String> mMetaData;
  private WeakReference<com.tencent.liteav.basic.c.b> mNotifyListener = null;
  private h mParam = null;
  private boolean mQuicChannel = false;
  private int mRetryCount = 0;
  private long mRtmpMsgRecvThreadInstance = 0L;
  private Object mRtmpMsgRecvThreadLock = new Object();
  private boolean mRtmpProxyEnable = false;
  private int mRtmpProxyIPIndex = 0;
  private Vector<String> mRtmpProxyIPList = new Vector();
  private long mRtmpProxyInstance = 0L;
  private Object mRtmpProxyLock = new Object();
  private TXCStreamUploader.a mRtmpProxyParam = new TXCStreamUploader.a(this);
  private String mRtmpUrl = "";
  private Thread mThread = null;
  private Object mThreadLock = null;
  private j mUploadQualityReport = null;
  private long mUploaderInstance = 0L;
  private Vector<TXSNALPacket> mVecPendingNAL = new Vector();
  
  static
  {
    com.tencent.liteav.basic.util.h.f();
  }
  
  public TXCStreamUploader(Context paramContext, h paramh)
  {
    this.mContext = paramContext;
    h localh = paramh;
    if (paramh == null)
    {
      localh = new h();
      localh.a = 0;
      localh.g = 3;
      localh.f = 3;
      localh.h = 40;
      localh.i = 1000;
      localh.j = true;
    }
    this.mParam = localh;
    this.mThreadLock = new Object();
    this.mIntelligentRoute = new c();
    this.mIntelligentRoute.a = this;
    this.mUploaderInstance = 0L;
    this.mRetryCount = 0;
    this.mCurrentRecordIdx = 0;
    this.mIpList = null;
    this.mIsPushing = false;
    this.mThread = null;
    this.mRtmpUrl = null;
    this.mLastNetworkType = 0;
    this.mHandlerThread = null;
    this.mUploadQualityReport = new j(paramContext);
    i.a().a(paramContext);
  }
  
  private String getAddressFromUrl(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.indexOf("://");
      if (i != -1)
      {
        paramString = paramString.substring(i + 3);
        i = paramString.indexOf("/");
        if (i != -1) {
          return paramString.substring(0, i);
        }
      }
    }
    return "";
  }
  
  private boolean getNextRtmpProxyIP()
  {
    Object localObject = this.mRtmpProxyParam;
    ((TXCStreamUploader.a)localObject).f = 234L;
    ((TXCStreamUploader.a)localObject).g = 80L;
    localObject = this.mRtmpProxyIPList;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Vector)localObject).size() > 0)
      {
        if (this.mRtmpProxyIPIndex >= this.mRtmpProxyIPList.size())
        {
          this.mRtmpProxyIPIndex = 0;
          return false;
        }
        localObject = this.mRtmpUrl.split("://");
        if (localObject.length < 2) {
          return false;
        }
        bool1 = true;
        localObject = localObject[1].substring(localObject[1].indexOf("/"));
        String str = (String)this.mRtmpProxyIPList.get(this.mRtmpProxyIPIndex);
        this.mRtmpProxyParam.h = str;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("room://");
        localStringBuilder.append(str);
        localStringBuilder.append((String)localObject);
        this.mRtmpUrl = localStringBuilder.toString();
        this.mQuicChannel = true;
        this.mRtmpProxyIPIndex += 1;
      }
    }
    return bool1;
  }
  
  private HashMap getParamsFromUrl(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("[?]");
    if ((paramString != null) && (paramString.length >= 2) && (paramString[1] != null))
    {
      if (paramString[1].length() == 0) {
        return localHashMap;
      }
      paramString = paramString[1].split("[&]");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i];
        if (arrayOfString.indexOf("=") != -1)
        {
          arrayOfString = arrayOfString.split("[=]");
          if (arrayOfString.length == 2) {
            localHashMap.put(arrayOfString[0], arrayOfString[1]);
          }
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  private TXCStreamUploader.b getRtmpRealConnectInfo()
  {
    if (!this.mEnableNearestIP) {
      return new TXCStreamUploader.b(this, this.mRtmpUrl, false);
    }
    Object localObject1 = this.mIpList;
    if (localObject1 == null) {
      return new TXCStreamUploader.b(this, this.mRtmpUrl, false);
    }
    if (this.mCurrentRecordIdx < ((ArrayList)localObject1).size())
    {
      int i = this.mCurrentRecordIdx;
      if (i >= 0)
      {
        localObject1 = (a)this.mIpList.get(i);
        String[] arrayOfString = this.mRtmpUrl.split("://");
        if (arrayOfString.length < 2) {
          return new TXCStreamUploader.b(this, this.mRtmpUrl, false);
        }
        i = 1;
        Object localObject2 = arrayOfString[1].split("/");
        if ((((a)localObject1).a.split(":").length > 1) && (!((a)localObject1).a.startsWith("[")))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(((a)localObject1).a);
          localStringBuilder.append("]:");
          localStringBuilder.append(((a)localObject1).b);
          localObject2[0] = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((a)localObject1).a);
          localStringBuilder.append(":");
          localStringBuilder.append(((a)localObject1).b);
          localObject2[0] = localStringBuilder.toString();
        }
        StringBuilder localStringBuilder = new StringBuilder(localObject2[0]);
        while (i < localObject2.length)
        {
          localStringBuilder.append("/");
          localStringBuilder.append(localObject2[i]);
          i += 1;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(arrayOfString[0]);
        ((StringBuilder)localObject2).append("://");
        ((StringBuilder)localObject2).append(localStringBuilder.toString());
        return new TXCStreamUploader.b(this, ((StringBuilder)localObject2).toString(), ((a)localObject1).c);
      }
    }
    return new TXCStreamUploader.b(this, this.mRtmpUrl, false);
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
  
  private void internalReconnect(boolean paramBoolean)
  {
    if (!this.mIsPushing) {
      return;
    }
    if (this.mRtmpProxyEnable)
    {
      if (this.mLastNetworkType != com.tencent.liteav.basic.util.h.e(this.mContext))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reconnect network switch from ");
        ((StringBuilder)localObject1).append(this.mLastNetworkType);
        ((StringBuilder)localObject1).append(" to ");
        ((StringBuilder)localObject1).append(com.tencent.liteav.basic.util.h.e(this.mContext));
        TXCLog.e("TXCStreamUploader", ((StringBuilder)localObject1).toString());
        this.mLastNetworkType = com.tencent.liteav.basic.util.h.e(this.mContext);
        this.mRetryCount = 0;
        Monitor.a(2, "WebrtcRoom: need enter again by user", "", 0);
        sendNotifyEvent(1021, String.format("Network type has changed. Need to re-enter the room", new Object[0]));
        return;
      }
      if (this.mRetryCount < this.mParam.f)
      {
        this.mRetryCount += 1;
        Monitor.a(2, String.format("Network: reconnecting to upload server with quic.[addr:%s][retryCount:%d][retryLimit:%d]", new Object[] { this.mRtmpProxyParam.h, Integer.valueOf(this.mRetryCount), Integer.valueOf(this.mParam.f) }), "", 0);
        localObject1 = this.mRtmpUrl;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reconnect rtmp-proxy server(econnect retry count:");
        ((StringBuilder)localObject2).append(this.mRetryCount);
        ((StringBuilder)localObject2).append(" retry limit:");
        ((StringBuilder)localObject2).append(this.mParam.f);
        ((StringBuilder)localObject2).append(")");
        TXCEventRecorderProxy.a((String)localObject1, 91003, -1L, -1L, ((StringBuilder)localObject2).toString(), 0);
        sendNotifyEvent(1102);
        startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
        return;
      }
      if (getNextRtmpProxyIP())
      {
        this.mRetryCount = 0;
        Monitor.a(2, String.format("Network: reconnecting to upload server with quic.[addr:%s][retryCount:%d][retryLimit:%d]", new Object[] { this.mRtmpProxyParam.h, Integer.valueOf(this.mRetryCount), Integer.valueOf(this.mParam.f) }), "", 0);
        sendNotifyEvent(1102);
        startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
        return;
      }
      TXCEventRecorderProxy.a(this.mRtmpUrl, 91002, -1L, -1L, "connect rtmp-proxy server failed(try all addresses)", 0);
      sendNotifyEvent(-1324);
      return;
    }
    this.mUploadQualityReport.c();
    if ((this.mEnableNearestIP) && (this.mLastNetworkType != com.tencent.liteav.basic.util.h.e(this.mContext)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reconnect network switch from ");
      ((StringBuilder)localObject1).append(this.mLastNetworkType);
      ((StringBuilder)localObject1).append(" to ");
      ((StringBuilder)localObject1).append(com.tencent.liteav.basic.util.h.e(this.mContext));
      TXCLog.e("TXCStreamUploader", ((StringBuilder)localObject1).toString());
      this.mLastNetworkType = com.tencent.liteav.basic.util.h.e(this.mContext);
      this.mIntelligentRoute.a(this.mRtmpUrl, this.mChannelType);
      this.mRetryCount = 0;
      return;
    }
    if (!this.mEnableNearestIP) {
      paramBoolean = false;
    }
    if (this.mQuicChannel == true) {
      paramBoolean = true;
    }
    if ((paramBoolean == true) && (!nextRecordIdx(true)))
    {
      TXCLog.e("TXCStreamUploader", "reconnect: try all addresses failed");
      TXCEventRecorderProxy.a(this.mRtmpUrl, 91002, -1L, -1L, "connect upload server failed(try all addresses failed)", 0);
    }
    Object localObject2 = getRtmpRealConnectInfo();
    Object localObject3 = getAddressFromUrl(((TXCStreamUploader.b)localObject2).a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reconnect change ip: ");
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append(" enableNearestIP: ");
    localStringBuilder.append(this.mEnableNearestIP);
    localStringBuilder.append(" last channel type: ");
    if (this.mQuicChannel) {
      localObject1 = "Q Channel";
    } else {
      localObject1 = "TCP";
    }
    localStringBuilder.append((String)localObject1);
    TXCLog.e("TXCStreamUploader", localStringBuilder.toString());
    if (this.mQuicChannel == true)
    {
      TXCLog.e("TXCStreamUploader", "reconnect last channel type is Q Channel，ignore retry limit");
      Monitor.a(2, String.format("Network: reconnecting to upload server with quic.[addr:%s]", new Object[] { localObject3 }), "", 0);
      startPushTask(((TXCStreamUploader.b)localObject2).a, ((TXCStreamUploader.b)localObject2).b, 0);
      sendNotifyEvent(1102);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("reconnect retry count:");
    ((StringBuilder)localObject1).append(this.mRetryCount);
    ((StringBuilder)localObject1).append(" retry limit:");
    ((StringBuilder)localObject1).append(this.mParam.f);
    TXCLog.e("TXCStreamUploader", ((StringBuilder)localObject1).toString());
    if (this.mRetryCount < this.mParam.f)
    {
      this.mRetryCount += 1;
      Monitor.a(2, String.format("Network: reconnecting to upload server with tcp.[addr:%s][retryCount:%d][retryLimit:%d]", new Object[] { localObject3, Integer.valueOf(this.mRetryCount), Integer.valueOf(this.mParam.f) }), "", 0);
      localObject1 = this.mRtmpUrl;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("reconnect upload server:(retry count:");
      ((StringBuilder)localObject3).append(this.mRetryCount);
      ((StringBuilder)localObject3).append(" retry limit:");
      ((StringBuilder)localObject3).append(this.mParam.f);
      ((StringBuilder)localObject3).append(")");
      TXCEventRecorderProxy.a((String)localObject1, 91003, -1L, -1L, ((StringBuilder)localObject3).toString(), 0);
      startPushTask(((TXCStreamUploader.b)localObject2).a, ((TXCStreamUploader.b)localObject2).b, 0);
      sendNotifyEvent(1102);
      return;
    }
    TXCLog.e("TXCStreamUploader", "reconnect: try all times failed");
    TXCEventRecorderProxy.a(this.mRtmpUrl, 91002, -1L, -1L, "connect upload server failed(try all times failed)", 0);
    sendNotifyEvent(-1324);
  }
  
  private boolean isQCloudStreamUrl(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      int i = paramString.indexOf("://");
      if (i != -1)
      {
        paramString = paramString.substring(i + 3);
        if ((paramString != null) && (paramString.startsWith("cloud.tencent.com"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private native void nativeCacheJNIParams();
  
  private native void nativeEnableDrop(long paramLong, boolean paramBoolean);
  
  private native TXCStreamUploader.UploadStats nativeGetStats(long paramLong);
  
  private native long nativeInitRtmpMsgRecvThreadInstance(long paramLong1, long paramLong2);
  
  private native long nativeInitRtmpProxyInstance(long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, long paramLong4, long paramLong5, String paramString3, boolean paramBoolean, String paramString4);
  
  private native long nativeInitUploader(String paramString1, String paramString2, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean2, int paramInt8, HashMap<String, String> paramHashMap);
  
  private native void nativeOnThreadRun(long paramLong);
  
  private native void nativePushAAC(long paramLong1, byte[] paramArrayOfByte, long paramLong2);
  
  private native void nativePushNAL(long paramLong1, byte[] paramArrayOfByte, int paramInt, long paramLong2, long paramLong3, long paramLong4);
  
  private native void nativeReleaseJNIParams();
  
  private native void nativeRtmpMsgRecvThreadStart(long paramLong);
  
  private native void nativeRtmpMsgRecvThreadStop(long paramLong);
  
  private native void nativeRtmpProxyEnterRoom(long paramLong);
  
  private native void nativeRtmpProxyLeaveRoom(long paramLong);
  
  private native void nativeRtmpProxySendHeartBeat(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11);
  
  private native void nativeSendRtmpProxyMsg(long paramLong, byte[] paramArrayOfByte);
  
  private native void nativeSetSendStrategy(long paramLong, int paramInt, boolean paramBoolean);
  
  private native void nativeSetVideoDropParams(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2);
  
  private native void nativeStopPush(long paramLong);
  
  private native void nativeUninitRtmpMsgRecvThreadInstance(long paramLong);
  
  private native void nativeUninitRtmpProxyInstance(long paramLong);
  
  private native void nativeUninitUploader(long paramLong);
  
  private boolean nextRecordIdx(boolean paramBoolean)
  {
    Object localObject = this.mIpList;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() == 0) {
        return false;
      }
      if (paramBoolean == true)
      {
        localObject = (a)this.mIpList.get(this.mCurrentRecordIdx);
        ((a)localObject).e += 1;
      }
      if (this.mCurrentRecordIdx + 1 < this.mIpList.size())
      {
        this.mCurrentRecordIdx += 1;
        return true;
      }
    }
    return false;
  }
  
  private void onRtmpProxyRoomEvent(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      sendNotifyEvent(1018, String.format("Already in room，[%d]", new Object[] { Integer.valueOf(paramInt2) }));
      return;
    }
    if (paramInt1 == 2) {
      sendNotifyEvent(1019, String.format("Not in the room，[%d]", new Object[] { Integer.valueOf(paramInt2) }));
    }
  }
  
  private void onRtmpProxyUserListPushed(TXCStreamUploader.RtmpProxyUserInfo[] paramArrayOfRtmpProxyUserInfo)
  {
    if (paramArrayOfRtmpProxyUserInfo == null) {
      return;
    }
    if (!this.mIsPushing) {
      return;
    }
    if (this.mRtmpProxyEnable) {
      if (this.mRtmpProxyParam == null) {
        return;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray1 = new JSONArray();
        JSONArray localJSONArray2 = new JSONArray();
        i = 0;
        if (i < paramArrayOfRtmpProxyUserInfo.length)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("userid", paramArrayOfRtmpProxyUserInfo[i].account);
          localJSONObject.put("playurl", paramArrayOfRtmpProxyUserInfo[i].playUrl);
          if (paramArrayOfRtmpProxyUserInfo[i].stmType == 0)
          {
            localJSONArray1.put(localJSONObject);
            break label172;
          }
          localJSONArray2.put(localJSONObject);
          break label172;
        }
        paramArrayOfRtmpProxyUserInfo = new JSONObject();
        paramArrayOfRtmpProxyUserInfo.put("userlist", localJSONArray1);
        paramArrayOfRtmpProxyUserInfo.put("userlist_aux", localJSONArray2);
        sendNotifyEvent(1020, paramArrayOfRtmpProxyUserInfo.toString());
        return;
      }
      catch (Exception paramArrayOfRtmpProxyUserInfo)
      {
        TXCLog.e("TXCStreamUploader", "build json object failed.", paramArrayOfRtmpProxyUserInfo);
      }
      return;
      label172:
      i += 1;
    }
  }
  
  private void onSendRtmpProxyMsg(byte[] paramArrayOfByte)
  {
    synchronized (this.mThreadLock)
    {
      if (this.mUploaderInstance != 0L) {
        nativeSendRtmpProxyMsg(this.mUploaderInstance, paramArrayOfByte);
      }
      return;
    }
  }
  
  private void parseProxyInfo(String paramString)
  {
    Object localObject1;
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (!paramString.startsWith("room")) {
        return;
      }
      this.mRtmpProxyParam.i = isQCloudStreamUrl(paramString);
      localObject1 = getParamsFromUrl(paramString);
      if (localObject1 == null) {
        return;
      }
      if (((HashMap)localObject1).containsKey("sdkappid")) {
        this.mRtmpProxyParam.a = Long.valueOf((String)((HashMap)localObject1).get("sdkappid")).longValue();
      }
      if ((((HashMap)localObject1).containsKey("roomid")) && (((HashMap)localObject1).containsKey("userid")))
      {
        if (!((HashMap)localObject1).containsKey("roomsig")) {
          return;
        }
        this.mRtmpProxyParam.d = Long.valueOf((String)((HashMap)localObject1).get("roomid")).longValue();
        this.mRtmpProxyParam.c = ((String)((HashMap)localObject1).get("userid"));
        if (((HashMap)localObject1).containsKey("bizbuf")) {
          try
          {
            String str = (String)((HashMap)localObject1).get("bizbuf");
            this.mRtmpProxyParam.j = URLDecoder.decode(str, "UTF-8");
          }
          catch (Exception localException)
          {
            TXCLog.e("TXCStreamUploader", "decode bizbuf failed.", localException);
          }
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = new JSONObject(URLDecoder.decode((String)((HashMap)localObject1).get("roomsig"), "UTF-8"));
        this.mRtmpProxyParam.b = 0L;
        if (!((JSONObject)localObject2).has("Key")) {
          return;
        }
        this.mRtmpProxyParam.e = ((JSONObject)localObject2).optString("Key");
        localObject1 = ((JSONObject)localObject2).optJSONObject("RtmpProxy");
        if (localObject1 != null)
        {
          if ((!((JSONObject)localObject1).has("Ip")) || (!((JSONObject)localObject1).has("Port"))) {
            break label748;
          }
          if (!((JSONObject)localObject1).has("Type")) {
            return;
          }
        }
        localObject2 = ((JSONObject)localObject2).optJSONArray("AccessList");
        Object localObject3;
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            Object localObject4 = ((JSONArray)localObject2).getJSONObject(i);
            if ((localObject4 == null) || (!((JSONObject)localObject4).has("Ip")) || (!((JSONObject)localObject4).has("Port")) || (!((JSONObject)localObject4).has("Type"))) {
              break label749;
            }
            localObject3 = ((JSONObject)localObject4).optString("Ip");
            long l = ((JSONObject)localObject4).optLong("Port");
            if (((JSONObject)localObject4).optLong("Type") != 2L) {
              break label749;
            }
            localObject4 = this.mRtmpProxyIPList;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject3);
            localStringBuilder.append(":");
            localStringBuilder.append(l);
            ((Vector)localObject4).add(localStringBuilder.toString());
            break label749;
          }
        }
        if (this.mRtmpProxyParam.i)
        {
          if (localObject1 == null) {
            return;
          }
          paramString = paramString.substring(0, paramString.indexOf("?"));
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.mRtmpProxyParam.a);
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append(this.mRtmpProxyParam.d);
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append(this.mRtmpProxyParam.c);
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramString);
          ((StringBuilder)localObject3).append("/webrtc/");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("?real_rtmp_ip=");
          ((StringBuilder)localObject3).append(((JSONObject)localObject1).optString("Ip"));
          ((StringBuilder)localObject3).append("&real_rtmp_port=");
          ((StringBuilder)localObject3).append(((JSONObject)localObject1).optLong("Port"));
          ((StringBuilder)localObject3).append("&tinyid=");
          ((StringBuilder)localObject3).append(this.mRtmpProxyParam.b);
          ((StringBuilder)localObject3).append("&srctinyid=0");
          this.mRtmpUrl = ((StringBuilder)localObject3).toString();
          getNextRtmpProxyIP();
        }
        else
        {
          this.mRtmpUrl = paramString;
          this.mQuicChannel = false;
        }
        this.mRtmpProxyEnable = true;
        return;
      }
      catch (Exception paramString)
      {
        TXCLog.e("TXCStreamUploader", "parse proxy info failed.", paramString);
      }
      return;
      label748:
      return;
      label749:
      i += 1;
    }
  }
  
  private void postReconnectMsg(String paramString, boolean paramBoolean, int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = 101;
    localMessage.obj = paramString;
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    localMessage.arg1 = i;
    paramString = this.mHandler;
    if (paramString != null) {
      paramString.sendMessageDelayed(localMessage, paramInt);
    }
  }
  
  private void reconnect(boolean paramBoolean)
  {
    stopPushTask();
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.postDelayed(new TXCStreamUploader.3(this, paramBoolean), this.mParam.g * 1000);
    }
  }
  
  private void reportNetStatus()
  {
    long l6 = TXCTimeUtil.getTimeTick();
    long l3 = l6 - this.mLastTimeStamp;
    Object localObject1 = getUploadStats();
    long l4 = 0L;
    Object localObject2 = Long.valueOf(0L);
    long l2;
    long l1;
    long l5;
    if (localObject1 != null)
    {
      localObject2 = this.mLastUploadStats;
      if (localObject2 != null)
      {
        l4 = getSpeed(((TXCStreamUploader.UploadStats)localObject2).inVideoBytes, ((TXCStreamUploader.UploadStats)localObject1).inVideoBytes, l3).longValue();
        l2 = getSpeed(this.mLastUploadStats.inAudioBytes, ((TXCStreamUploader.UploadStats)localObject1).inAudioBytes, l3).longValue();
        l1 = getSpeed(this.mLastUploadStats.outVideoBytes, ((TXCStreamUploader.UploadStats)localObject1).outVideoBytes, l3).longValue();
        l3 = getSpeed(this.mLastUploadStats.outAudioBytes, ((TXCStreamUploader.UploadStats)localObject1).outAudioBytes, l3).longValue();
      }
      else
      {
        l3 = 0L;
        l2 = l3;
        l1 = l2;
      }
      setStatusValue(7005, Long.valueOf(((TXCStreamUploader.UploadStats)localObject1).videoCacheLen));
      setStatusValue(7006, Long.valueOf(((TXCStreamUploader.UploadStats)localObject1).audioCacheLen));
      setStatusValue(7007, Long.valueOf(((TXCStreamUploader.UploadStats)localObject1).videoDropCount));
      setStatusValue(7008, Long.valueOf(((TXCStreamUploader.UploadStats)localObject1).audioDropCount));
      setStatusValue(7021, Long.valueOf(((TXCStreamUploader.UploadStats)localObject1).bandwidthEst));
      setStatusValue(7009, Long.valueOf(((TXCStreamUploader.UploadStats)localObject1).startTS));
      setStatusValue(7010, Long.valueOf(((TXCStreamUploader.UploadStats)localObject1).dnsTS));
      setStatusValue(7011, Long.valueOf(((TXCStreamUploader.UploadStats)localObject1).connTS));
      setStatusValue(7012, String.valueOf(((TXCStreamUploader.UploadStats)localObject1).serverIP));
      if (this.mQuicChannel) {
        l5 = 2L;
      } else {
        l5 = 1L;
      }
      setStatusValue(7013, Long.valueOf(l5));
      setStatusValue(7014, ((TXCStreamUploader.UploadStats)localObject1).connectionID);
      setStatusValue(7015, ((TXCStreamUploader.UploadStats)localObject1).connectionStats);
      this.mUploadQualityReport.a(((TXCStreamUploader.UploadStats)localObject1).videoDropCount, ((TXCStreamUploader.UploadStats)localObject1).audioDropCount);
      this.mUploadQualityReport.b(((TXCStreamUploader.UploadStats)localObject1).videoCacheLen, ((TXCStreamUploader.UploadStats)localObject1).audioCacheLen);
      l5 = l1;
    }
    else
    {
      setStatusValue(7005, localObject2);
      setStatusValue(7006, localObject2);
      setStatusValue(7007, localObject2);
      setStatusValue(7008, localObject2);
      l3 = 0L;
      l1 = l3;
      l5 = l1;
      l2 = l1;
    }
    setStatusValue(7001, Long.valueOf(l4));
    setStatusValue(7002, Long.valueOf(l2));
    setStatusValue(7003, Long.valueOf(l5));
    setStatusValue(7004, Long.valueOf(l3));
    this.mLastTimeStamp = l6;
    this.mLastUploadStats = ((TXCStreamUploader.UploadStats)localObject1);
    localObject1 = this.mHandler;
    if (localObject1 != null) {
      ((Handler)localObject1).sendEmptyMessageDelayed(103, 2000L);
    }
  }
  
  private void rtmpProxySendHeartBeat()
  {
    Object localObject1 = com.tencent.liteav.basic.util.h.a();
    long l1 = localObject1[0] / 10;
    long l2 = localObject1[1] / 10;
    long l3 = TXCStatus.c(getID(), 7004);
    long l4 = TXCStatus.c(getID(), 7003);
    long l5 = TXCStatus.c(getID(), 1001);
    long l6 = TXCStatus.c(getID(), 4001);
    long l7 = TXCStatus.c(getID(), 7006);
    long l8 = TXCStatus.c(getID(), 7005);
    long l9 = TXCStatus.c(getID(), 7008);
    long l10 = TXCStatus.c(getID(), 7007);
    synchronized (this.mRtmpProxyLock)
    {
      long l11 = this.mRtmpProxyInstance;
      localObject1 = ???;
      try
      {
        nativeRtmpProxySendHeartBeat(l11, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10);
        localObject1 = ???;
        return;
      }
      finally
      {
        for (;;)
        {
          Object localObject2;
          ??? = localObject1;
        }
      }
      localObject1 = ???;
      throw localObject2;
    }
  }
  
  private void sendNotifyEvent(int paramInt)
  {
    if (paramInt == 0)
    {
      reconnect(false);
      return;
    }
    if (paramInt == 1)
    {
      reconnect(true);
      return;
    }
    if (paramInt == 1001) {
      this.mConnectSuccessTimeStamps = TXCTimeUtil.getTimeTick();
    }
    if (paramInt == 1026)
    {
      if (this.mRtmpProxyEnable) {
        synchronized (this.mRtmpMsgRecvThreadLock)
        {
          nativeRtmpMsgRecvThreadStart(this.mRtmpMsgRecvThreadInstance);
          synchronized (this.mRtmpProxyLock)
          {
            nativeRtmpProxyEnterRoom(this.mRtmpProxyInstance);
            ??? = this.mHandler;
            if (??? != null)
            {
              ((Handler)???).sendEmptyMessageDelayed(104, 2000L);
              return;
            }
          }
        }
      }
      return;
    }
    if (this.mNotifyListener != null)
    {
      ??? = new Bundle();
      if (paramInt != -2308)
      {
        if (paramInt != -1307)
        {
          if (paramInt != 1026)
          {
            if (paramInt != 3003)
            {
              if (paramInt != -1325)
              {
                if (paramInt != -1324)
                {
                  if (paramInt != 1001)
                  {
                    if (paramInt != 1002)
                    {
                      if (paramInt != 1101)
                      {
                        if (paramInt != 1102)
                        {
                          if (paramInt != 3008)
                          {
                            if (paramInt != 3009) {
                              ((Bundle)???).putString("EVT_MSG", "UNKNOWN");
                            } else {
                              ((Bundle)???).putString("EVT_MSG", "Failed to connect server");
                            }
                          }
                          else {
                            ((Bundle)???).putString("EVT_MSG", "No data is sent for more than 30s. Actively disconnect");
                          }
                        }
                        else {
                          ((Bundle)???).putString("EVT_MSG", "Enables network reconnection");
                        }
                      }
                      else {
                        ((Bundle)???).putString("EVT_MSG", "Insufficient upstream bandwidth. Data transmission is not timely");
                      }
                    }
                    else {
                      ((Bundle)???).putString("EVT_MSG", "rtmp start push stream");
                    }
                  }
                  else {
                    ((Bundle)???).putString("EVT_MSG", "Already connected to rtmp server");
                  }
                }
                else {
                  ((Bundle)???).putString("EVT_MSG", "Failed to connect all IPs, abort connection.");
                }
              }
              else {
                ((Bundle)???).putString("EVT_MSG", "No internet. Please check if WiFi or mobile data is turned on");
              }
            }
            else {
              ((Bundle)???).putString("EVT_MSG", "RTMP servers handshake failed");
            }
          }
          else if (this.mRtmpProxyEnable) {
            synchronized (this.mRtmpMsgRecvThreadLock)
            {
              nativeRtmpMsgRecvThreadStart(this.mRtmpMsgRecvThreadInstance);
              synchronized (this.mRtmpProxyLock)
              {
                nativeRtmpProxyEnterRoom(this.mRtmpProxyInstance);
                ??? = this.mHandler;
                if (??? != null)
                {
                  ((Handler)???).sendEmptyMessageDelayed(104, 2000L);
                  return;
                }
              }
            }
          }
        }
        else {
          ((Bundle)???).putString("EVT_MSG", "failed to connect server for several times, abort connection");
        }
      }
      else {
        ((Bundle)???).putString("EVT_MSG", "The server rejects the connection request. It may be that the push URL has been occupied or expired, or the anti-leech link is wrong.");
      }
      ((Bundle)???).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      ((Bundle)???).putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      com.tencent.liteav.basic.util.h.a(this.mNotifyListener, paramInt, (Bundle)???);
    }
  }
  
  private void sendNotifyEvent(int paramInt, String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", paramString);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      com.tencent.liteav.basic.util.h.a(this.mNotifyListener, paramInt, localBundle);
    }
    else
    {
      sendNotifyEvent(paramInt);
    }
    if (paramInt == 1002)
    {
      paramString = getUploadStats();
      if (paramString != null) {
        this.mUploadQualityReport.a(paramString.dnsparseTimeCost, paramString.connectTimeCost, paramString.handshakeTimeCost);
      }
    }
    else if (paramInt == 1101)
    {
      this.mUploadQualityReport.d();
    }
  }
  
  private void startPushTask(String paramString, boolean paramBoolean, int paramInt)
  {
    TXCLog.i("TXCStreamUploader", "start push task");
    boolean bool = this.mQuicChannel;
    if ((bool != paramBoolean) && (bool == true)) {
      Monitor.a(2, String.format("Network: switch push channel from quic to tcp.[retryCount:%d][retryLimit:%d]", new Object[] { Integer.valueOf(this.mRetryCount), Integer.valueOf(this.mParam.f) }), "", 0);
    }
    if (paramBoolean)
    {
      paramInt = this.mConnectCountQuic + 1;
      this.mConnectCountQuic = paramInt;
      setStatusValue(7017, Long.valueOf(paramInt));
    }
    else
    {
      paramInt = this.mConnectCountTcp + 1;
      this.mConnectCountTcp = paramInt;
      setStatusValue(7018, Long.valueOf(paramInt));
    }
    this.mThread = new TXCStreamUploader.2(this, "RTMPUpload", paramBoolean, paramString);
    this.mThread.start();
  }
  
  private void stopPushTask()
  {
    TXCLog.i("TXCStreamUploader", "stop push task");
    synchronized (this.mThreadLock)
    {
      this.mVecPendingNAL.removeAllElements();
      nativeStopPush(this.mUploaderInstance);
      return;
    }
  }
  
  private void tryResetRetryCount()
  {
    if ((this.mConnectSuccessTimeStamps != 0L) && (TXCTimeUtil.getTimeTick() - this.mConnectSuccessTimeStamps > this.mParam.f * (this.mParam.g + 13) * 1000))
    {
      this.mRetryCount = 0;
      this.mConnectSuccessTimeStamps = 0L;
      TXCLog.i("TXCStreamUploader", "reset retry count");
    }
  }
  
  public String getConfusionIP(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      int i = paramString.indexOf(".");
      localObject = paramString;
      if (i != -1)
      {
        String str = paramString.substring(i + 1);
        i = str.indexOf(".");
        localObject = paramString;
        if (i != -1)
        {
          paramString = str.substring(i + 1);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("A.B.");
          ((StringBuilder)localObject).append(paramString);
          localObject = ((StringBuilder)localObject).toString();
        }
      }
    }
    return localObject;
  }
  
  public TXCStreamUploader.UploadStats getUploadStats()
  {
    for (;;)
    {
      synchronized (this.mThreadLock)
      {
        TXCStreamUploader.UploadStats localUploadStats = nativeGetStats(this.mUploaderInstance);
        if (localUploadStats != null)
        {
          if (this.mQuicChannel == true)
          {
            l = 2L;
            localUploadStats.channelType = l;
          }
        }
        else {
          return localUploadStats;
        }
      }
      long l = 1L;
    }
  }
  
  public int init()
  {
    return 0;
  }
  
  public void onFetchDone(int paramInt, ArrayList<a> paramArrayList)
  {
    if (!this.mIsPushing) {
      return;
    }
    Object localObject;
    if (paramArrayList != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFetchDone: code = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ip count = ");
      ((StringBuilder)localObject).append(paramArrayList.size());
      TXCLog.e("TXCStreamUploader", ((StringBuilder)localObject).toString());
      if (paramInt == 0)
      {
        this.mIpList = paramArrayList;
        paramInt = paramArrayList.size();
        this.mCurrentRecordIdx = 0;
        break label90;
      }
    }
    paramInt = 0;
    label90:
    if (paramInt > 0)
    {
      localObject = this.mIpList.iterator();
      paramArrayList = "";
      paramInt = 0;
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        int i = paramInt;
        if (locala != null)
        {
          i = paramInt;
          if (locala.c)
          {
            i = paramInt;
            if (locala.a != null)
            {
              i = paramInt;
              if (locala.a.length() > 0) {
                i = paramInt + 1;
              }
            }
          }
        }
        paramInt = i;
        if (locala != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramArrayList);
          localStringBuilder.append(" ");
          localStringBuilder.append(getConfusionIP(locala.a));
          localStringBuilder.append(":");
          localStringBuilder.append(locala.b);
          paramArrayList = localStringBuilder.toString();
          paramInt = i;
        }
      }
      setStatusValue(7016, Long.valueOf(paramInt));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{");
      ((StringBuilder)localObject).append(paramArrayList);
      ((StringBuilder)localObject).append(" }");
      setStatusValue(7019, ((StringBuilder)localObject).toString());
    }
    paramArrayList = getRtmpRealConnectInfo();
    postReconnectMsg(paramArrayList.a, paramArrayList.b, 0);
  }
  
  public void pushAAC(byte[] paramArrayOfByte, long paramLong)
  {
    tryResetRetryCount();
    synchronized (this.mThreadLock)
    {
      if ((!this.mAudioMuted) || (!this.mRtmpProxyEnable)) {
        nativePushAAC(this.mUploaderInstance, paramArrayOfByte, paramLong);
      }
      return;
    }
  }
  
  public void pushNAL(TXSNALPacket paramTXSNALPacket)
  {
    tryResetRetryCount();
    synchronized (this.mThreadLock)
    {
      if (this.mUploaderInstance != 0L)
      {
        if ((paramTXSNALPacket != null) && (paramTXSNALPacket.nalData != null) && (paramTXSNALPacket.nalData.length > 0)) {
          nativePushNAL(this.mUploaderInstance, paramTXSNALPacket.nalData, paramTXSNALPacket.nalType, paramTXSNALPacket.frameIndex, paramTXSNALPacket.pts, paramTXSNALPacket.dts);
        }
      }
      else
      {
        if (paramTXSNALPacket.nalType == 0) {
          this.mVecPendingNAL.removeAllElements();
        }
        this.mVecPendingNAL.add(paramTXSNALPacket);
      }
      return;
    }
  }
  
  public void setAudioInfo(int paramInt1, int paramInt2)
  {
    h localh = this.mParam;
    if (localh != null)
    {
      localh.d = paramInt2;
      localh.e = paramInt1;
    }
  }
  
  public void setAudioMute(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.mThreadLock)
      {
        this.mAudioMuted = paramBoolean;
        if ((this.mRtmpProxyEnable) && (this.mUploaderInstance != 0L))
        {
          if (!this.mParam.m) {
            break label75;
          }
          if (this.mQuicChannel)
          {
            i = 3;
            nativeSetSendStrategy(this.mUploaderInstance, i, false);
          }
        }
        else
        {
          return;
        }
      }
      int i = 2;
      continue;
      label75:
      i = 1;
    }
  }
  
  public void setDropEanble(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("drop enable ");
    if (paramBoolean) {
      ??? = "yes";
    } else {
      ??? = "no";
    }
    localStringBuilder.append((String)???);
    TXCLog.i("TXCStreamUploader", localStringBuilder.toString());
    synchronized (this.mThreadLock)
    {
      nativeEnableDrop(this.mUploaderInstance, paramBoolean);
      return;
    }
  }
  
  public void setMetaData(HashMap<String, String> paramHashMap)
  {
    this.mMetaData = paramHashMap;
  }
  
  public void setMode(int paramInt)
  {
    h localh = this.mParam;
    if (localh != null) {
      localh.a = paramInt;
    }
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.c.b paramb)
  {
    this.mNotifyListener = new WeakReference(paramb);
  }
  
  public void setRetryInterval(int paramInt)
  {
    h localh = this.mParam;
    if (localh != null) {
      localh.g = paramInt;
    }
  }
  
  public void setRetryTimes(int paramInt)
  {
    h localh = this.mParam;
    if (localh != null) {
      localh.f = paramInt;
    }
  }
  
  public void setSendStrategy(boolean paramBoolean1, boolean paramBoolean2)
  {
    ??? = this.mParam;
    ((h)???).m = paramBoolean1;
    ((h)???).n = paramBoolean2;
    this.mUploadQualityReport.a(paramBoolean1);
    int i;
    if (paramBoolean1)
    {
      if (this.mQuicChannel) {
        i = 3;
      } else {
        i = 2;
      }
    }
    else {
      i = 1;
    }
    int j = i;
    if (!this.mRtmpProxyEnable)
    {
      ??? = this.mIpList;
      if (??? != null)
      {
        j = i;
        if (((ArrayList)???).size() != 0) {}
      }
      else
      {
        j = 1;
      }
    }
    synchronized (this.mThreadLock)
    {
      if (this.mUploaderInstance != 0L) {
        nativeSetSendStrategy(this.mUploaderInstance, j, paramBoolean2);
      }
      setStatusValue(7020, Long.valueOf(j));
      return;
    }
  }
  
  public void setVideoDropParams(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("drop params wait i frame:");
    if (paramBoolean) {
      ??? = "yes";
    } else {
      ??? = "no";
    }
    localStringBuilder.append((String)???);
    localStringBuilder.append(" max video count:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" max video cache time: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" ms");
    TXCLog.i("TXCStreamUploader", localStringBuilder.toString());
    synchronized (this.mThreadLock)
    {
      this.mParam.j = paramBoolean;
      this.mParam.h = paramInt1;
      this.mParam.i = paramInt2;
      if (this.mUploaderInstance != 0L) {
        nativeSetVideoDropParams(this.mUploaderInstance, this.mParam.j, this.mParam.h, this.mParam.i);
      }
      return;
    }
  }
  
  public String start(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.mIsPushing == true) {
      return this.mRtmpUrl;
    }
    this.mIsPushing = true;
    this.mConnectSuccessTimeStamps = 0L;
    this.mRetryCount = 0;
    this.mRtmpUrl = paramString;
    this.mChannelType = paramInt;
    this.mConnectCountQuic = 0;
    this.mConnectCountTcp = 0;
    this.mRtmpProxyEnable = false;
    this.mRtmpProxyParam.a();
    this.mRtmpProxyIPList.clear();
    this.mRtmpProxyIPIndex = 0;
    this.mRtmpProxyInstance = 0L;
    this.mRtmpMsgRecvThreadInstance = 0L;
    setStatusValue(7016, Long.valueOf(0L));
    setStatusValue(7017, Long.valueOf(0L));
    setStatusValue(7018, Long.valueOf(0L));
    this.mUploadQualityReport.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start push with url:");
    localStringBuilder.append(this.mRtmpUrl);
    localStringBuilder.append(" enable nearest ip:");
    String str;
    if (paramBoolean) {
      str = "yes";
    } else {
      str = "no";
    }
    localStringBuilder.append(str);
    localStringBuilder.append("channel type:");
    localStringBuilder.append(paramInt);
    TXCLog.i("TXCStreamUploader", localStringBuilder.toString());
    if (com.tencent.liteav.basic.util.h.e(this.mContext) == 0)
    {
      sendNotifyEvent(-1325);
      return this.mRtmpUrl;
    }
    this.mEnableNearestIP = paramBoolean;
    if (this.mHandlerThread == null)
    {
      this.mHandlerThread = new HandlerThread("RTMP_PUSH");
      this.mHandlerThread.start();
    }
    this.mHandler = new TXCStreamUploader.1(this, this.mHandlerThread.getLooper());
    parseProxyInfo(paramString);
    if (this.mRtmpProxyEnable)
    {
      this.mLastNetworkType = com.tencent.liteav.basic.util.h.e(this.mContext);
      nativeCacheJNIParams();
      startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
    }
    else if ((this.mEnableNearestIP) && (this.mLastNetworkType != com.tencent.liteav.basic.util.h.e(this.mContext)))
    {
      TXCLog.i("TXCStreamUploader", "fetching nearest ip list");
      this.mLastNetworkType = com.tencent.liteav.basic.util.h.e(this.mContext);
      this.mIntelligentRoute.a(paramString, paramInt);
    }
    else
    {
      startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
    }
    this.mHandler.sendEmptyMessageDelayed(103, 2000L);
    return this.mRtmpUrl;
  }
  
  public void stop()
  {
    if (!this.mIsPushing) {
      return;
    }
    this.mIsPushing = false;
    TXCLog.i("TXCStreamUploader", "stop push");
    if (this.mRtmpProxyEnable) {
      synchronized (this.mRtmpProxyLock)
      {
        nativeRtmpProxyLeaveRoom(this.mRtmpProxyInstance);
      }
    }
    synchronized (this.mThreadLock)
    {
      nativeStopPush(this.mUploaderInstance);
      ??? = this.mHandlerThread;
      if (??? != null)
      {
        ((HandlerThread)???).getLooper().quit();
        this.mHandlerThread = null;
      }
      if (this.mHandler != null) {
        this.mHandler = null;
      }
      if (this.mRtmpProxyEnable) {
        nativeReleaseJNIParams();
      }
      this.mUploadQualityReport.c();
      this.mUploadQualityReport.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamUploader
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.C2BUserInfo;
import com.tencent.av.QavEngineAssistant;
import com.tencent.av.VideoConstants;
import com.tencent.av.app.QuaReportInfo;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.AudioDump;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.avcore.config.ConfigInfo;
import com.tencent.avcore.engine.dav.DavClosedReason;
import com.tencent.avcore.engine.dav.DavEventId;
import com.tencent.avcore.engine.dav.IDavAdapter;
import com.tencent.avcore.jni.data.SDKConfigInfo;
import com.tencent.avcore.jni.dav.DavEngineProxy;
import com.tencent.avcore.netchannel.IDavNetChannel;
import com.tencent.avcore.util.AVNativeEventProcessor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class VcControllerImpl
  extends DavEngineProxy
  implements DavClosedReason, DavEventId, IDavAdapter
{
  private static final String KEY_IS_SESSION_OFFLINE = "is_offline_session";
  private static final String KEY_NATIVE_QCLEAR_SWITCH = "native_qclear_switch";
  private static final String KEY_SOCKET_RECONNECT = "enable_reconnect";
  private static final String KEY_SOCKET_RECONNECT_TIMEOUT = "reconnect_timeout";
  private static final String TAG = "VcControllerImpl";
  public static boolean sIsSpecialDevice;
  private final Object lock1 = new Object();
  private final Object lock2 = new Object();
  private final String mAppId;
  private int mCloseReason = -1;
  private int mCloseResult = -1;
  private VcControllerImpl.CloseVideoTimeoutCallback mCloseVideoTimeoutCallback = null;
  private Runnable mCloseVideoTimeoutRunnable = new VcControllerImpl.1(this);
  private VcControllerImpl.NativeEventCallback mEngineEventCb;
  public IVideoEventListener mEventListener;
  private final JniSimpleInfoMng mJniSimpleInfo;
  private String mMcc = PhoneCodeUtils.a();
  private String mMnc = "";
  private final VcSystemInfo mSysInfo;
  private int setAudioInputMuteResult = -1;
  
  static
  {
    boolean bool;
    if ((!Build.MODEL.equalsIgnoreCase("vivo Y66")) && (!Build.MODEL.equalsIgnoreCase("vivo Y67")) && (!Build.MODEL.equalsIgnoreCase("vivo Y67A")) && (!Build.MODEL.equalsIgnoreCase("vivo Y67L")) && (!Build.MODEL.equalsIgnoreCase("vivo X9Plus")) && (!Build.MODEL.equalsIgnoreCase("vivo X9Plus L")) && (!Build.MODEL.equalsIgnoreCase("vivo X9s")) && (!Build.MODEL.equalsIgnoreCase("vivo X9s L")) && (!Build.MODEL.equalsIgnoreCase("vivo X9s Plus")) && (!Build.MODEL.equalsIgnoreCase("vivo X9s Plus L")) && (!Build.MODEL.equalsIgnoreCase("Redmi S2"))) {
      bool = false;
    } else {
      bool = true;
    }
    sIsSpecialDevice = bool;
  }
  
  public VcControllerImpl(Context paramContext, String paramString, IDavNetChannel paramIDavNetChannel, IVideoEventListener paramIVideoEventListener)
  {
    QavEngineAssistant.a();
    this.mJniSimpleInfo = new JniSimpleInfoMng(this);
    VcSystemInfo.getCpuInfo();
    this.mAppId = paramString;
    this.mSysInfo = new VcSystemInfo();
    this.mEventListener = paramIVideoEventListener;
    initEngine(this.mSysInfo, paramIDavNetChannel, this, this.mEventListener);
    initContext();
    paramContext = QQDeviceInfo.getIMSI("62ad83");
    if ((!TextUtils.isEmpty(paramContext)) && (paramContext.length() >= 5)) {
      this.mMnc = paramContext.substring(3, 5);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("VcControllerImpl, mMnc[");
      paramContext.append(this.mMnc);
      paramContext.append("], sdkVersion[");
      paramContext.append(getSdkVersion());
      paramContext.append("]");
      QLog.w("VcControllerImpl", 1, paramContext.toString());
    }
  }
  
  private int changeBusyType(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("change busy type error : busy type = ");
      localStringBuilder.append(paramInt);
      QLog.e("VcControllerImpl", 2, localStringBuilder.toString());
    }
    return 1;
  }
  
  private void handleFunChatMsg(long paramLong, byte[] paramArrayOfByte, String paramString)
  {
    int i = (int)paramLong;
    if ((i != 12) && (i != 13)) {
      switch (i)
      {
      default: 
        this.mEventListener.a(paramString, i, paramArrayOfByte);
        return;
      case 8: 
        this.mEventListener.a(paramString, new String(paramArrayOfByte));
        return;
      case 6: 
        this.mEventListener.e(new String(paramArrayOfByte));
        return;
      case 5: 
        this.mEventListener.f(new String(paramArrayOfByte));
        return;
      case 4: 
        this.mEventListener.d(new String(paramArrayOfByte));
        return;
      case 2: 
        this.mEventListener.a(paramArrayOfByte);
        return;
      case 1: 
      case 3: 
        this.mEventListener.c(i, new String(paramArrayOfByte));
        return;
      }
    }
    this.mEventListener.b(i, new String(paramArrayOfByte));
  }
  
  private boolean quaReport(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = SharedPreferencesProxyManager.getInstance().getProxy(VideoConstants.b, 4);
      localObject1 = paramString.getAll();
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("do qua report : found exception map, size = ");
          ((StringBuilder)localObject2).append(((Map)localObject1).size());
          QLog.e("VcControllerImpl", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = ((Map)localObject1).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          QuaReportInfo localQuaReportInfo = new QuaReportInfo();
          localQuaReportInfo.toObject((String)((Map)localObject1).get(str));
          if ((localQuaReportInfo.selfUin != null) && (localQuaReportInfo.peerUin != null))
          {
            paramInt1 = changeBusyType(localQuaReportInfo.busytype);
            doQuaReport(Long.valueOf(localQuaReportInfo.selfUin).longValue(), Long.valueOf(localQuaReportInfo.peerUin).longValue(), paramInt1, 0);
          }
        }
        bool = paramString.edit().clear().commit();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("do qua report : exception map commitResult = ");
          paramString.append(bool);
          QLog.e("VcControllerImpl", 2, paramString.toString());
        }
      }
      boolean bool = SharedPreferencesProxyManager.getInstance().getProxy(VideoConstants.jdField_a_of_type_JavaLangString, 4).edit().clear().commit();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("do qua report : common map commitResult = ");
        paramString.append(bool);
        QLog.e("VcControllerImpl", 2, paramString.toString());
      }
      return true;
    }
    catch (Exception paramString)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Do qua report error : ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("VcControllerImpl", 2, ((StringBuilder)localObject1).toString());
      }
    }
    return false;
  }
  
  private void setCarrierType(long paramLong)
  {
    setCarrierType(paramLong, this.mMcc, this.mMnc);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", mMcc = ");
      localStringBuilder.append(this.mMcc);
      localStringBuilder.append(", mMnc = ");
      localStringBuilder.append(this.mMnc);
      QLog.d("VcControllerImpl", 2, localStringBuilder.toString());
    }
  }
  
  public int acceptVideo(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      paramLong = CharacterUtil.a(paramString);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("acceptVideo friendUin = ");
        paramString.append(paramLong);
        QLog.d("VcControllerImpl", 2, paramString.toString());
      }
      setApType(paramInt1);
      paramInt1 = accept(paramLong, paramInt2, paramInt3);
      setCarrierType(paramLong);
      return paramInt1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public int acceptVideoMode(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return acceptVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public int cancelVideoMode(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return cancelVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public int closeVideo(String arg1, int paramInt, VcControllerImpl.CloseVideoTimeoutCallback paramCloseVideoTimeoutCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("closeVideo reason = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("VcControllerImpl", 1, ((StringBuilder)localObject).toString(), new Throwable());
    localObject = ???;
    if (TextUtils.isEmpty(???)) {
      localObject = "0";
    }
    ??? = (String)localObject;
    if (((String)localObject).startsWith("+")) {
      ??? = ((String)localObject).substring(1);
    }
    try
    {
      long l1 = CharacterUtil.a(???);
      if (AudioDump.a()) {
        AudioDump.a().c();
      }
      int i = 0;
      if ((paramCloseVideoTimeoutCallback != null) && (sIsSpecialDevice))
      {
        this.mCloseResult = -1;
        this.mCloseReason = paramInt;
        this.mCloseVideoTimeoutCallback = paramCloseVideoTimeoutCallback;
        ThreadManager.excute(new VcControllerImpl.2(this, l1, paramInt), 16, null, false);
        ??? = ThreadManager.getUIHandler();
        paramCloseVideoTimeoutCallback = this.mCloseVideoTimeoutRunnable;
        long l2 = 2000;
        ???.postDelayed(paramCloseVideoTimeoutCallback, l2);
        try
        {
          synchronized (this.lock1)
          {
            this.lock1.wait(l2);
          }
        }
        catch (InterruptedException paramCloseVideoTimeoutCallback)
        {
          paramCloseVideoTimeoutCallback.printStackTrace();
          QLog.d("VcControllerImpl", 1, "closeVideo end. continue.");
          paramInt = i;
        }
        throw paramCloseVideoTimeoutCallback;
      }
      else
      {
        paramInt = close(l1, paramInt);
        this.mJniSimpleInfo.a(l1);
      }
      setCarrierType(l1);
      return paramInt;
    }
    catch (NumberFormatException ???)
    {
      ???.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", ???.getMessage());
    }
    return -1;
  }
  
  public byte[] createTLVpackage(long paramLong, String paramString, byte paramByte, int paramInt)
  {
    try
    {
      paramString = paramString.getBytes("utf-8");
      i3 = paramString.length;
    }
    catch (Exception paramString)
    {
      int i3;
      label15:
      byte[] arrayOfByte;
      int i;
      int j;
      int k;
      int m;
      int n;
      int i1;
      int i2;
      break label15;
    }
    paramString = new byte[0];
    i3 = 0;
    arrayOfByte = new byte[i3 + 12 + 3 + 6 + 6];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = 1;
    arrayOfByte[2] = 1;
    arrayOfByte[3] = 2;
    arrayOfByte[4] = 1;
    arrayOfByte[5] = 1;
    arrayOfByte[6] = 3;
    arrayOfByte[7] = 8;
    i = (byte)(int)(paramLong & 0xFF);
    j = (byte)(int)(paramLong >> 8 & 0xFF);
    k = (byte)(int)(paramLong >> 16 & 0xFF);
    m = (byte)(int)(paramLong >> 24 & 0xFF);
    n = (byte)(int)(paramLong >> 32 & 0xFF);
    i1 = (byte)(int)(paramLong >> 40 & 0xFF);
    i2 = (byte)(int)(paramLong >> 48 & 0xFF);
    System.arraycopy(new byte[] { (byte)(int)(paramLong >> 56 & 0xFF), i2, i1, n, m, k, j, i }, 0, arrayOfByte, 8, 8);
    arrayOfByte[16] = 4;
    arrayOfByte[17] = ((byte)i3);
    if (i3 > 0) {
      System.arraycopy(paramString, 0, arrayOfByte, 18, 8);
    }
    i3 = 18 + i3;
    arrayOfByte[i3] = 5;
    i3 += 1;
    arrayOfByte[i3] = 1;
    i3 += 1;
    arrayOfByte[i3] = paramByte;
    i3 += 1;
    arrayOfByte[i3] = 6;
    i3 += 1;
    arrayOfByte[i3] = 4;
    paramByte = (byte)(paramInt & 0xFF);
    i = (byte)(paramInt >> 8 & 0xFF);
    j = (byte)(paramInt >> 16 & 0xFF);
    System.arraycopy(new byte[] { (byte)(paramInt >> 24 & 0xFF), j, i, paramByte }, 0, arrayOfByte, i3 + 1, 4);
    return arrayOfByte;
  }
  
  protected void finalize()
  {
    try
    {
      uninit();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public long getChatRoomId(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return getChatRoomID(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString.getMessage());
    }
    return -1L;
  }
  
  public Context getContext()
  {
    return BaseApplication.getContext();
  }
  
  public String getCustomInfo(long paramLong, String paramString)
  {
    Object localObject4 = "";
    Object localObject3 = localObject4;
    Object localObject2;
    try
    {
      Object localObject1;
      if ("enable_reconnect".equals(paramString))
      {
        localObject3 = localObject4;
        localObject1 = String.valueOf(QavRecordDpc.a().o);
      }
      else
      {
        localObject3 = localObject4;
        if ("reconnect_timeout".equals(paramString))
        {
          localObject3 = localObject4;
          localObject1 = String.valueOf(QavRecordDpc.a().p);
        }
        else
        {
          localObject3 = localObject4;
          if ("is_offline_session".equals(paramString))
          {
            localObject3 = localObject4;
            if (this.mEventListener == null) {
              break label333;
            }
            localObject3 = localObject4;
            if (this.mEventListener.isOfflineSession(String.valueOf(paramLong)) != 1) {
              break label333;
            }
            localObject1 = "true";
          }
          else
          {
            localObject3 = localObject4;
            if ("native_qclear_switch".equals(paramString))
            {
              localObject4 = "-1";
              localObject3 = localObject4;
              if (AudioHelper.a(23) == 1)
              {
                localObject1 = "1";
              }
              else
              {
                localObject1 = localObject4;
                localObject3 = localObject4;
                if (AudioHelper.a(23) == 0) {
                  localObject1 = "0";
                }
              }
              localObject3 = localObject1;
              localObject4 = new StringBuilder();
              localObject3 = localObject1;
              ((StringBuilder)localObject4).append("callbackGetCustomInfo KEY_NATIVE_QCLEAR_SWITCH, result = ");
              localObject3 = localObject1;
              ((StringBuilder)localObject4).append((String)localObject1);
              localObject3 = localObject1;
              QLog.d("VcControllerImpl", 1, ((StringBuilder)localObject4).toString());
            }
            else
            {
              localObject3 = localObject4;
              localObject1 = localObject4;
              if ("WatchTogetherFlag".equals(paramString))
              {
                localObject3 = localObject4;
                localObject1 = String.valueOf(this.mJniSimpleInfo.a(paramLong, true, false));
              }
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VcControllerImpl", 1, "callbackGetCustomInfo fail.", localThrowable);
      localObject2 = localObject3;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcControllerImpl", 2, String.format("callbackGetCustomInfo peerUin=%s key=%s result=%s", new Object[] { Long.valueOf(paramLong), paramString, localObject2 }));
      }
      return localObject2;
      label333:
      localObject2 = "false";
    }
  }
  
  public byte[] getInterestingString(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return getInterestingString(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString.getMessage());
    }
    return null;
  }
  
  public JniSimpleInfoMng getJniSimpleInfo()
  {
    return this.mJniSimpleInfo;
  }
  
  public AVNativeEventProcessor getNativeEventProcessor()
  {
    if (this.mEngineEventCb == null) {
      try
      {
        if (this.mEngineEventCb == null) {
          this.mEngineEventCb = new VcControllerImpl.NativeEventCallback(this);
        }
      }
      finally {}
    }
    return this.mEngineEventCb;
  }
  
  public int getPeerSdkVersion(String paramString)
  {
    return this.mJniSimpleInfo.b(paramString, false, true);
  }
  
  public int getPeerTerminalType(String paramString)
  {
    return this.mJniSimpleInfo.a(paramString, false, true);
  }
  
  public int ignoreVideo(String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      setApType(paramInt);
      paramInt = ignore(l);
      setCarrierType(l);
      return paramInt;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public void initClientLogReport()
  {
    try
    {
      i = Integer.parseInt(this.mAppId);
    }
    catch (Throwable localThrowable)
    {
      int i;
      label11:
      StringBuilder localStringBuilder;
      break label11;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initClientLogReport, app id invalid [");
      localStringBuilder.append(this.mAppId);
      localStringBuilder.append("]");
      QLog.i("VcControllerImpl", 2, localStringBuilder.toString());
    }
    i = 0;
    ClientLogReport.instance().init(getContext(), i);
  }
  
  public void initConfig()
  {
    ConfigInfo.instance(BaseApplication.getContext());
    setupDeviceInfos(SDKConfigInfo.getDeviceInfo(new AVSoProxyImpl(getContext())));
  }
  
  public void loadLibrary()
  {
    AVSoUtils.b();
  }
  
  public int notifyAnotherSelfIsRing(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return notifyAnotherSelfIsRing(l, paramBoolean);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public void onAudioData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeEventHandler", 2, "receive null audiodata");
      }
      return;
    }
    ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).sendBroadcastToSmartDevice(paramArrayOfByte);
  }
  
  public int pauseVideo(String paramString)
  {
    try
    {
      int i = stopVideoSend();
      return i;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      AVLog.printErrorLog("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public VcControllerImpl.DeviceCMDTLV receiveTransferMsg(String paramString, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" receiveTransferMsg : uin = ");
      localStringBuilder.append(paramString);
      QLog.d("VcControllerImpl", 2, localStringBuilder.toString());
    }
    paramString = unpackTLV(paramArrayOfByte);
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(" receiveTransferMsg : tlv = ");
      paramArrayOfByte.append(paramString.toString());
      QLog.d("VcControllerImpl", 2, paramArrayOfByte.toString());
    }
    return paramString;
  }
  
  public int rejectVideo(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("rejectVideo --> PeerUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ,apn = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ,rejectReason = ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("VcControllerImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "0";
    }
    paramString = (String)localObject;
    if (((String)localObject).startsWith("+")) {
      paramString = ((String)localObject).substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      setApType(paramInt1);
      paramInt1 = reject(l, paramInt2);
      setCarrierType(l);
      return paramInt1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public int rejectVideoMode(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return rejectVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public int requestFromUnQQ(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    quaReport(String.valueOf(paramLong), changeBusyType(paramInt1), 0);
    paramInt1 = requestUnQQ(paramLong, paramInt1, paramInt2, paramInt3);
    setCarrierType(paramLong);
    return paramInt1;
  }
  
  public int requestVideo(String paramString1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, String paramString2, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestVideo-->peerUin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" relationType=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" businessType");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" sign");
      localStringBuilder.append(paramArrayOfByte);
      localStringBuilder.append(" bindId");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" bindType");
      localStringBuilder.append(paramInt4);
      QLog.d("VcControllerImpl", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return -1;
    }
    try
    {
      long l = CharacterUtil.a(paramString1);
      setApType(paramInt1);
      if (paramInt3 == 1) {
        paramInt1 = 0;
      } else {
        paramInt1 = 22;
      }
      quaReport(paramString1, changeBusyType(paramInt2), paramInt1);
      paramInt1 = requestFromQQToUnQQ(l, paramInt2, paramInt3, paramArrayOfByte, paramString2, paramInt4);
      setCarrierType(l);
      return paramInt1;
    }
    catch (NumberFormatException paramString1) {}
    return -1;
  }
  
  public int requestVideo(String paramString1, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, String paramString6, long paramLong2, byte[] paramArrayOfByte, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, String paramString10)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    paramString10 = "0";
    if (bool) {
      paramString1 = "0";
    }
    if (TextUtils.isEmpty(paramString5)) {
      paramString5 = "0";
    }
    if (TextUtils.isEmpty(paramString6)) {
      paramString6 = paramString10;
    }
    bool = TextUtils.isEmpty(paramString7);
    paramString10 = "";
    if (bool) {
      paramString7 = "";
    }
    if (TextUtils.isEmpty(paramString8)) {
      paramString8 = paramString10;
    }
    if (QLog.isColorLevel())
    {
      paramString10 = new StringBuilder();
      paramString10.append("requestVideo1 funcall buffer:");
      paramString10.append(paramString7);
      QLog.d("VcControllerImpl", 2, paramString10.toString());
    }
    for (;;)
    {
      try
      {
        paramLong1 = CharacterUtil.a(paramString1);
        l1 = Long.parseLong(paramString5);
        l2 = Long.parseLong(paramString6);
        setApType(paramInt1);
        if (paramLong2 != 0L)
        {
          paramInt1 = requestSwitchTerminal(paramLong1, paramInt2, paramInt3, paramLong2);
          setCarrierType(paramLong1);
          return paramInt1;
        }
        if ((paramString4 != null) && (paramString4.length() != 0))
        {
          paramInt1 = changeBusyType(paramInt2);
          quaReport(String.valueOf(paramString4), paramInt1, paramInt4);
          paramInt1 = requestByMobileNo(paramLong1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramInt4, paramString7.getBytes(), paramString9, paramInt5, paramInt6);
          setCarrierType(paramLong1);
          return paramInt1;
        }
        if (4 == paramInt3) {
          if (29 != paramInt4) {}
        }
      }
      catch (NumberFormatException paramString1)
      {
        long l1;
        long l2;
        paramString1.printStackTrace();
        AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
        return -1;
      }
      try
      {
        paramInt5 = changeBusyType(paramInt2);
        paramInt1 = paramInt5;
        if (l1 == 0L)
        {
          paramInt1 = paramInt5;
          if (l2 == 9L)
          {
            paramInt1 = paramInt5;
            if (paramInt5 == 1) {
              paramInt1 = 5;
            }
          }
        }
        quaReport(String.valueOf(paramLong1), paramInt1, paramInt4);
        paramString1 = paramString7.getBytes();
        paramString2 = paramString8.getBytes("utf-8");
        try
        {
          paramInt1 = requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString1, paramString2, 1013, null, null, null);
          paramLong1 = paramInt1;
        }
        catch (Exception paramString1) {}catch (UnsupportedEncodingException paramString1)
        {
          continue;
        }
      }
      catch (Exception paramString1)
      {
        continue;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString2 = "VcControllerImpl";
        continue;
      }
      try
      {
        setCarrierType(paramLong1);
        return paramInt1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
        return -1;
      }
      catch (UnsupportedEncodingException paramString1) {}
    }
    paramString1 = this;
    paramInt5 = paramString1.changeBusyType(paramInt2);
    paramInt1 = paramInt5;
    if (l1 == 0L)
    {
      paramInt1 = paramInt5;
      if (l2 == 9L)
      {
        paramInt1 = paramInt5;
        if (paramInt5 == 1) {
          paramInt1 = 5;
        }
      }
    }
    paramString1.quaReport(String.valueOf(paramLong1), paramInt1, paramInt4);
    paramString1 = paramString7.getBytes();
    paramString2 = paramString8.getBytes("utf-8");
    paramInt1 = requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString1, paramString2, 0, null, null, null);
    try
    {
      setCarrierType(paramLong1);
      return paramInt1;
    }
    catch (Exception paramString1) {}catch (UnsupportedEncodingException paramString1) {}
    paramString2 = "VcControllerImpl";
    paramString1.printStackTrace();
    AVLog.printErrorLog(paramString2, paramString1.getMessage());
    return -1;
    try
    {
      quaReport(String.valueOf(paramLong1), changeBusyType(paramInt2), 0);
      paramInt1 = request(paramLong1, paramInt2, paramInt3, paramString7.getBytes(), paramString8.getBytes("utf-8"));
      setCarrierType(paramLong1);
      return paramInt1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
      return -1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
      return -1;
    }
  }
  
  public int requestVideo(String paramString1, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, String paramString6, long paramLong2, byte[] paramArrayOfByte, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, String paramString10, C2BUserInfo paramC2BUserInfo)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    paramString10 = "0";
    if (bool) {
      paramString1 = "0";
    }
    if (TextUtils.isEmpty(paramString5)) {
      paramString5 = "0";
    }
    if (TextUtils.isEmpty(paramString6)) {
      paramString6 = paramString10;
    }
    bool = TextUtils.isEmpty(paramString7);
    paramString10 = "";
    if (bool) {
      paramString7 = "";
    }
    if (TextUtils.isEmpty(paramString8)) {
      paramString8 = paramString10;
    }
    if (QLog.isColorLevel())
    {
      paramString10 = new StringBuilder();
      paramString10.append("requestVideo2 funcall buffer:");
      paramString10.append(paramString7);
      QLog.d("VcControllerImpl", 2, paramString10.toString());
    }
    try
    {
      paramLong1 = CharacterUtil.a(paramString1);
      long l1 = Long.parseLong(paramString5);
      long l2 = Long.parseLong(paramString6);
      setApType(paramInt1);
      if (paramLong2 != 0L)
      {
        paramInt1 = requestSwitchTerminal(paramLong1, paramInt2, paramInt3, paramLong2);
        setCarrierType(paramLong1);
        return paramInt1;
      }
      if ((paramString4 != null) && (paramString4.length() != 0))
      {
        paramInt1 = changeBusyType(paramInt2);
        quaReport(String.valueOf(paramString4), paramInt1, paramInt4);
        paramInt1 = requestByMobileNo(paramLong1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramInt4, paramString7.getBytes(), paramString9, paramInt5, paramInt6);
        setCarrierType(paramLong1);
        return paramInt1;
      }
      if (4 == paramInt3)
      {
        try
        {
          paramInt5 = changeBusyType(paramInt2);
          paramInt1 = paramInt5;
          if (l1 == 0L)
          {
            paramInt1 = paramInt5;
            if (l2 == 9L)
            {
              paramInt1 = paramInt5;
              if (paramInt5 == 1) {
                paramInt1 = 5;
              }
            }
          }
          quaReport(String.valueOf(paramLong1), paramInt1, paramInt4);
          paramString1 = paramString7.getBytes();
          paramString2 = paramString8.getBytes("utf-8");
          try
          {
            paramInt1 = requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString1, paramString2, 0, null, null, null);
            try
            {
              setCarrierType(paramLong1);
              return paramInt1;
            }
            catch (Exception paramString1) {}catch (UnsupportedEncodingException paramString1) {}
          }
          catch (Exception paramString1) {}catch (UnsupportedEncodingException paramString1) {}
          paramString1.printStackTrace();
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
          return -1;
        }
        catch (UnsupportedEncodingException paramString1) {}
        AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
        return -1;
      }
      try
      {
        quaReport(String.valueOf(paramLong1), changeBusyType(paramInt2), 0);
        paramInt1 = request(paramLong1, paramInt2, paramInt3, paramString7.getBytes(), paramString8.getBytes("utf-8"));
        setCarrierType(paramLong1);
        return paramInt1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
        return -1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
        return -1;
      }
      return -1;
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
    }
  }
  
  public int requestVideoMode(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return requestVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public int resumeVideo(String paramString)
  {
    return startVideoSend();
  }
  
  public int sendAVFunChatMsg(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendAVFunChatMsg, uin=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", type=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", data=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("VcControllerImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return -1;
    }
    Object localObject = paramString1;
    if (paramString1.startsWith("+")) {
      localObject = paramString1.substring(1);
    }
    try
    {
      long l = CharacterUtil.a((String)localObject);
      return sendAVFunChatMsg(l, paramInt, paramString2.getBytes());
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
    }
    return -1;
  }
  
  public int sendAVFunChatMsg(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return -1;
      }
      if (TextUtils.isEmpty(paramString))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("uin is ");
        paramArrayOfByte.append(paramString);
        AVLog.printErrorLog("VcControllerImpl", paramArrayOfByte.toString());
        return -1;
      }
      String str = paramString;
      if (paramString.startsWith("+")) {
        str = paramString.substring(1);
      }
      try
      {
        long l = Long.parseLong(str);
        return sendAVFunChatMsg(l, paramInt, paramArrayOfByte);
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
        paramString = new StringBuilder();
        paramString.append(" sendAVFunChatMsg| uin = ");
        paramString.append(str);
        QLog.e("VcControllerImpl", 1, paramString.toString());
      }
    }
    return -1;
  }
  
  public void sendTransferMsg(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      long l = Long.parseLong(paramString);
      sendTransferMsg(l, paramInt1, createTLVpackage(l, "", (byte)paramInt2, paramInt3));
      return;
    }
    catch (Exception localException)
    {
      label26:
      StringBuilder localStringBuilder;
      break label26;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" sendTransferMsg string parse long error : uin = ");
      localStringBuilder.append(paramString);
      QLog.d("VcControllerImpl", 2, localStringBuilder.toString());
    }
  }
  
  public int setAudioInputMute(String arg1, boolean paramBoolean)
  {
    this.setAudioInputMuteResult = -1;
    ThreadManager.excute(new VcControllerImpl.3(this, paramBoolean), 16, null, false);
    try
    {
      synchronized (this.lock2)
      {
        this.lock2.wait(2000);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return this.setAudioInputMuteResult;
    }
  }
  
  public int setAudioOutput(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return startAudioRecv();
    }
    return stopAudioRecv();
  }
  
  public int setAudioSpeakerVolume(int paramInt)
  {
    return 0;
  }
  
  public void setBackground(boolean paramBoolean) {}
  
  public int setGroundGlassSwitch(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString.startsWith("+")) {
      str = paramString.substring(1);
    }
    try
    {
      long l = Long.parseLong(str);
      return setGroundGlassSwitch(l, paramInt);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      paramString = new StringBuilder();
      paramString.append(" setGroundGlassSwitch| uin = ");
      paramString.append(str);
      QLog.e("VcControllerImpl", 1, paramString.toString());
    }
    return -1;
  }
  
  public int setNativeGatewayTestResult(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramInt1 = setGatewayTestResult(paramInt1, paramInt2, paramInt3);
      return paramInt1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      AVLog.printErrorLog("VcControllerImpl", localUnsatisfiedLinkError.getMessage());
    }
    return -1;
  }
  
  public void setScreenSize(int paramInt1, int paramInt2)
  {
    this.mSysInfo.setScreenSize(paramInt1, paramInt2);
  }
  
  public int switchAudio(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return switchAudio(l);
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcControllerImpl", 2, "switchAudio", paramString);
      }
    }
    return -1;
  }
  
  public int switchVideo(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return switchVideo(l);
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcControllerImpl", 2, "switchVideo", paramString);
      }
    }
    return -1;
  }
  
  public VcControllerImpl.DeviceCMDTLV unpackTLV(byte[] paramArrayOfByte)
  {
    Object localObject1 = new byte[8];
    System.arraycopy(paramArrayOfByte, 8, localObject1, 0, 8);
    long l1 = localObject1[0];
    long l2 = localObject1[1];
    long l3 = localObject1[2];
    long l4 = localObject1[3];
    long l5 = localObject1[4];
    long l6 = localObject1[5];
    long l7 = localObject1[6];
    long l8 = localObject1[7];
    int j = paramArrayOfByte[17];
    localObject1 = "";
    int i = 18;
    Object localObject2 = localObject1;
    if (j > 0)
    {
      localObject2 = new byte[j];
      System.arraycopy(paramArrayOfByte, 18, localObject2, 0, j);
    }
    try
    {
      localObject2 = new String((byte[])localObject2, "utf-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label128:
      int k;
      int m;
      int n;
      break label128;
    }
    i = 18 + j;
    localObject2 = localObject1;
    j = i + 2;
    i = paramArrayOfByte[j];
    localObject1 = new byte[4];
    System.arraycopy(paramArrayOfByte, j + 1 + 2, localObject1, 0, 4);
    j = localObject1[3];
    k = localObject1[2];
    m = localObject1[1];
    n = localObject1[0];
    paramArrayOfByte = new VcControllerImpl.DeviceCMDTLV(this);
    paramArrayOfByte.jdField_a_of_type_Long = ((l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | (0xFF & l8) << 0);
    paramArrayOfByte.jdField_a_of_type_JavaLangString = ((String)localObject2);
    paramArrayOfByte.jdField_a_of_type_Int = i;
    paramArrayOfByte.b = (j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16 | (n & 0xFF) << 24);
    return paramArrayOfByte;
  }
  
  public int updateSelfUin(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(paramString);
      return setSelfUin(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public void uploadSharpNode(int paramInt, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    if (str.startsWith("+")) {
      str.substring(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl
 * JD-Core Version:    0.7.0.1
 */
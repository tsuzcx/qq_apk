package com.tencent.av.core;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.C2BUserInfo;
import com.tencent.av.QavEngineAssistant;
import com.tencent.av.VideoConstants;
import com.tencent.av.app.QuaReportInfo;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
    if ((Build.MODEL.equalsIgnoreCase("vivo Y66")) || (Build.MODEL.equalsIgnoreCase("vivo Y67")) || (Build.MODEL.equalsIgnoreCase("vivo Y67A")) || (Build.MODEL.equalsIgnoreCase("vivo Y67L")) || (Build.MODEL.equalsIgnoreCase("vivo X9Plus")) || (Build.MODEL.equalsIgnoreCase("vivo X9Plus L")) || (Build.MODEL.equalsIgnoreCase("vivo X9s")) || (Build.MODEL.equalsIgnoreCase("vivo X9s L")) || (Build.MODEL.equalsIgnoreCase("vivo X9s Plus")) || (Build.MODEL.equalsIgnoreCase("vivo X9s Plus L")) || (Build.MODEL.equalsIgnoreCase("Redmi S2"))) {}
    for (boolean bool = true;; bool = false)
    {
      sIsSpecialDevice = bool;
      return;
    }
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
    if (QLog.isColorLevel()) {
      QLog.w("VcControllerImpl", 1, "VcControllerImpl, mMnc[" + this.mMnc + "], sdkVersion[" + getSdkVersion() + "]");
    }
  }
  
  private int changeBusyType(int paramInt)
  {
    if (paramInt == 0) {}
    do
    {
      return 1;
      if (paramInt == 1) {
        return 2;
      }
    } while (!QLog.isColorLevel());
    QLog.e("VcControllerImpl", 2, "change busy type error : busy type = " + paramInt);
    return 1;
  }
  
  public static void loadLibrary(Context paramContext)
  {
    long l = AudioHelper.b();
    try
    {
      QLog.w("VcControllerImpl", 1, "loadLibrary, seq[" + l + "]", new Throwable("打印调用栈"));
      SoLoadUtil.a(paramContext, "c++_shared", 0, false);
      SoLoadUtil.a(paramContext, "xplatform", 0, false);
      AVSoUtils.a(l, paramContext, "SDKCommon", true);
      AVSoUtils.a(l, paramContext, "VideoCtrl", true);
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      QLog.w("VcControllerImpl", 1, "loadLibrary, UnsatisfiedLinkError, seq[" + l + "]", paramContext);
      AVSoUtils.b();
    }
  }
  
  private boolean quaReport(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = SharedPreferencesProxyManager.getInstance().getProxy(VideoConstants.b, 4);
      Map localMap = paramString.getAll();
      if ((localMap == null) || (localMap.size() <= 0)) {
        break label284;
      }
      if (QLog.isColorLevel()) {
        QLog.e("VcControllerImpl", 2, "do qua report : found exception map, size = " + localMap.size());
      }
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        QuaReportInfo localQuaReportInfo = new QuaReportInfo();
        localQuaReportInfo.toObject((String)localMap.get(str));
        if ((localQuaReportInfo != null) && (localQuaReportInfo.selfUin != null) && (localQuaReportInfo.peerUin != null))
        {
          paramInt1 = changeBusyType(localQuaReportInfo.busytype);
          doQuaReport(Long.valueOf(localQuaReportInfo.selfUin).longValue(), Long.valueOf(localQuaReportInfo.peerUin).longValue(), paramInt1, 0);
        }
      }
      bool = paramString.edit().clear().commit();
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VcControllerImpl", 2, "Do qua report error : " + paramString);
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("VcControllerImpl", 2, "do qua report : exception map commitResult = " + bool);
    }
    label284:
    boolean bool = SharedPreferencesProxyManager.getInstance().getProxy(VideoConstants.jdField_a_of_type_JavaLangString, 4).edit().clear().commit();
    if (QLog.isColorLevel()) {
      QLog.e("VcControllerImpl", 2, "do qua report : common map commitResult = " + bool);
    }
    return true;
  }
  
  private void setCarrierType(long paramLong)
  {
    setCarrierType(paramLong, this.mMcc, this.mMnc);
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, "uin = " + paramLong + ", mMcc = " + this.mMcc + ", mMnc = " + this.mMnc);
    }
  }
  
  public int SetAudioInputMute(String arg1, boolean paramBoolean)
  {
    this.setAudioInputMuteResult = -1;
    ThreadManager.excute(new VcControllerImpl.3(this, paramBoolean), 16, null, false);
    synchronized (this.lock2)
    {
      try
      {
        this.lock2.wait(2000);
        return this.setAudioInputMuteResult;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  public int SetAudioOutput(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return startAudioRecv();
    }
    return stopAudioRecv();
  }
  
  public int UpdateSelfUin(String paramString)
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
      if (QLog.isColorLevel()) {
        QLog.d("VcControllerImpl", 2, "acceptVideo friendUin = " + paramLong);
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
  
  /* Error */
  public int closeVideo(String arg1, int paramInt, VcControllerImpl.CloseVideoTimeoutCallback paramCloseVideoTimeoutCallback)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 26
    //   5: iconst_1
    //   6: new 184	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 489
    //   16: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: iload_2
    //   20: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: new 250	java/lang/Throwable
    //   29: dup
    //   30: invokespecial 490	java/lang/Throwable:<init>	()V
    //   33: invokestatic 492	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   36: aload_1
    //   37: astore 7
    //   39: aload_1
    //   40: invokestatic 168	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifeq +8 -> 51
    //   46: ldc_w 439
    //   49: astore 7
    //   51: aload 7
    //   53: astore_1
    //   54: aload 7
    //   56: ldc_w 441
    //   59: invokevirtual 444	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   62: ifeq +10 -> 72
    //   65: aload 7
    //   67: iconst_1
    //   68: invokevirtual 447	java/lang/String:substring	(I)Ljava/lang/String;
    //   71: astore_1
    //   72: aload_1
    //   73: invokestatic 452	com/tencent/av/utils/CharacterUtil:a	(Ljava/lang/String;)J
    //   76: lstore 5
    //   78: invokestatic 496	com/tencent/av/utils/AudioDump:a	()Z
    //   81: ifeq +9 -> 90
    //   84: invokestatic 499	com/tencent/av/utils/AudioDump:a	()Lcom/tencent/av/utils/AudioDump;
    //   87: invokevirtual 502	com/tencent/av/utils/AudioDump:c	()V
    //   90: aload_3
    //   91: ifnull +126 -> 217
    //   94: getstatic 87	com/tencent/av/core/VcControllerImpl:sIsSpecialDevice	Z
    //   97: ifeq +120 -> 217
    //   100: aload_0
    //   101: iconst_m1
    //   102: putfield 94	com/tencent/av/core/VcControllerImpl:mCloseResult	I
    //   105: aload_0
    //   106: iload_2
    //   107: putfield 96	com/tencent/av/core/VcControllerImpl:mCloseReason	I
    //   110: aload_0
    //   111: aload_3
    //   112: putfield 98	com/tencent/av/core/VcControllerImpl:mCloseVideoTimeoutCallback	Lcom/tencent/av/core/VcControllerImpl$CloseVideoTimeoutCallback;
    //   115: new 504	com/tencent/av/core/VcControllerImpl$2
    //   118: dup
    //   119: aload_0
    //   120: lload 5
    //   122: iload_2
    //   123: invokespecial 507	com/tencent/av/core/VcControllerImpl$2:<init>	(Lcom/tencent/av/core/VcControllerImpl;JI)V
    //   126: bipush 16
    //   128: aconst_null
    //   129: iconst_0
    //   130: invokestatic 420	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   133: invokestatic 511	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   136: aload_0
    //   137: getfield 105	com/tencent/av/core/VcControllerImpl:mCloseVideoTimeoutRunnable	Ljava/lang/Runnable;
    //   140: sipush 2000
    //   143: i2l
    //   144: invokevirtual 517	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   147: pop
    //   148: aload_0
    //   149: getfield 122	com/tencent/av/core/VcControllerImpl:lock1	Ljava/lang/Object;
    //   152: astore_1
    //   153: aload_1
    //   154: monitorenter
    //   155: aload_0
    //   156: getfield 122	com/tencent/av/core/VcControllerImpl:lock1	Ljava/lang/Object;
    //   159: sipush 2000
    //   162: i2l
    //   163: invokevirtual 423	java/lang/Object:wait	(J)V
    //   166: aload_1
    //   167: monitorexit
    //   168: ldc 26
    //   170: iconst_1
    //   171: ldc_w 519
    //   174: invokestatic 405	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: iload 4
    //   179: istore_2
    //   180: aload_0
    //   181: lload 5
    //   183: invokespecial 479	com/tencent/av/core/VcControllerImpl:setCarrierType	(J)V
    //   186: iload_2
    //   187: ireturn
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 457	java/lang/NumberFormatException:printStackTrace	()V
    //   193: ldc 26
    //   195: aload_1
    //   196: invokevirtual 460	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   199: invokestatic 466	com/tencent/av/AVLog:printErrorLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: iconst_m1
    //   203: ireturn
    //   204: astore_3
    //   205: aload_3
    //   206: invokevirtual 426	java/lang/InterruptedException:printStackTrace	()V
    //   209: goto -43 -> 166
    //   212: astore_3
    //   213: aload_1
    //   214: monitorexit
    //   215: aload_3
    //   216: athrow
    //   217: aload_0
    //   218: lload 5
    //   220: iload_2
    //   221: invokevirtual 523	com/tencent/av/core/VcControllerImpl:close	(JI)I
    //   224: istore_2
    //   225: aload_0
    //   226: getfield 135	com/tencent/av/core/VcControllerImpl:mJniSimpleInfo	Lcom/tencent/av/core/JniSimpleInfoMng;
    //   229: lload 5
    //   231: invokevirtual 525	com/tencent/av/core/JniSimpleInfoMng:a	(J)V
    //   234: goto -54 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	VcControllerImpl
    //   0	237	2	paramInt	int
    //   0	237	3	paramCloseVideoTimeoutCallback	VcControllerImpl.CloseVideoTimeoutCallback
    //   1	177	4	i	int
    //   76	154	5	l	long
    //   37	29	7	str	String
    // Exception table:
    //   from	to	target	type
    //   72	78	188	java/lang/NumberFormatException
    //   155	166	204	java/lang/InterruptedException
    //   155	166	212	finally
    //   166	168	212	finally
    //   205	209	212	finally
    //   213	215	212	finally
  }
  
  public byte[] createTLVpackage(long paramLong, String paramString, byte paramByte, int paramInt)
  {
    int i3 = 0;
    try
    {
      paramString = paramString.getBytes("utf-8");
      int i4 = paramString.length;
      i3 = i4;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        int i;
        int j;
        int k;
        int m;
        int n;
        int i1;
        int i2;
        paramString = new byte[0];
      }
    }
    arrayOfByte = new byte[6 + (i3 + 12 + 3 + 6)];
    arrayOfByte[0] = 1;
    arrayOfByte[1] = 1;
    arrayOfByte[2] = 1;
    arrayOfByte[3] = 2;
    arrayOfByte[4] = 1;
    arrayOfByte[5] = 1;
    arrayOfByte[6] = 3;
    arrayOfByte[7] = 8;
    i = (byte)(int)(0xFF & paramLong);
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
    i3 += 18;
    arrayOfByte[i3] = 5;
    i3 += 1;
    arrayOfByte[i3] = 1;
    i3 += 1;
    arrayOfByte[i3] = paramByte;
    i3 += 1;
    arrayOfByte[i3] = 6;
    i3 += 1;
    arrayOfByte[i3] = 4;
    i3 += 1;
    paramByte = (byte)(paramInt & 0xFF);
    i = (byte)(paramInt >> 8 & 0xFF);
    j = (byte)(paramInt >> 16 & 0xFF);
    System.arraycopy(new byte[] { (byte)(paramInt >> 24 & 0xFF), j, i, paramByte }, 0, arrayOfByte, i3, 4);
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
    return BaseApplicationImpl.getContext();
  }
  
  public String getCustomInfo(long paramLong, String paramString)
  {
    String str = "";
    localObject2 = str;
    for (;;)
    {
      try
      {
        if (!"enable_reconnect".equals(paramString)) {
          continue;
        }
        localObject2 = str;
        i = QavRecordDpc.a().o;
        localObject1 = String.valueOf(i);
      }
      catch (Throwable localThrowable1)
      {
        Object localObject1 = localObject2;
        QLog.e("VcControllerImpl", 1, "callbackGetCustomInfo fail.", localThrowable1);
        continue;
        if (AudioHelper.a(23) != 0) {
          continue;
        }
        localObject1 = "0";
        continue;
        localObject1 = localThrowable1;
        localObject2 = localThrowable1;
        if (!"WatchTogetherFlag".equals(paramString)) {
          continue;
        }
        localObject2 = localThrowable1;
        int i = this.mJniSimpleInfo.a(paramLong, true, false);
        localObject1 = String.valueOf(i);
        continue;
        localObject1 = "false";
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VcControllerImpl", 2, String.format("callbackGetCustomInfo peerUin=%s key=%s result=%s", new Object[] { Long.valueOf(paramLong), paramString, localObject1 }));
      }
      return localObject1;
      localObject2 = str;
      if ("reconnect_timeout".equals(paramString))
      {
        localObject2 = str;
        localObject1 = String.valueOf(QavRecordDpc.a().p);
      }
      else
      {
        localObject2 = str;
        if ("is_offline_session".equals(paramString))
        {
          localObject2 = str;
          if (this.mEventListener == null) {
            continue;
          }
          localObject2 = str;
          if (this.mEventListener.isOfflineSession(String.valueOf(paramLong)) != 1) {
            continue;
          }
          localObject1 = "true";
        }
        else
        {
          localObject2 = str;
          if (!"native_qclear_switch".equals(paramString)) {
            continue;
          }
        }
      }
      try
      {
        if (AudioHelper.a(23) != 1) {
          continue;
        }
        localObject1 = "1";
      }
      catch (Throwable localThrowable2)
      {
        localObject1 = "-1";
        continue;
        localObject1 = "-1";
        continue;
      }
      localObject2 = localObject1;
      QLog.d("VcControllerImpl", 1, "callbackGetCustomInfo KEY_NATIVE_QCLEAR_SWITCH, result = " + (String)localObject1);
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
    if (this.mEngineEventCb == null) {}
    try
    {
      if (this.mEngineEventCb == null) {
        this.mEngineEventCb = new VcControllerImpl.NativeEventCallback(this);
      }
      return this.mEngineEventCb;
    }
    finally {}
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
    int j = 0;
    try
    {
      i = Integer.parseInt(this.mAppId);
      ClientLogReport.instance().init(getContext(), i);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("VcControllerImpl", 2, "initClientLogReport, app id invalid [" + this.mAppId + "]");
          i = j;
        }
      }
    }
  }
  
  public void initConfig()
  {
    ConfigInfo.instance(BaseApplicationImpl.getContext());
    setupDeviceInfos(SDKConfigInfo.getDeviceInfo(new AVSoProxyImpl(getContext())));
  }
  
  public void loadLibrary()
  {
    loadLibrary(getContext());
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
    Bundle localBundle = new Bundle();
    localBundle.putInt("NotifyDataLength", paramArrayOfByte.length);
    localBundle.putByteArray("NotifyDataValue", paramArrayOfByte);
    paramArrayOfByte = new Intent();
    paramArrayOfByte.putExtra("NotifyData", localBundle);
    paramArrayOfByte.setAction("SmartDevice_AudioData");
    BaseApplicationImpl.getApplication().sendBroadcast(paramArrayOfByte, "com.tencent.smartdevice.permission.broadcast");
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
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, " receiveTransferMsg : uin = " + paramString);
    }
    paramString = unpackTLV(paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, " receiveTransferMsg : tlv = " + paramString.toString());
    }
    return paramString;
  }
  
  public int rejectVideo(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, "rejectVideo --> PeerUin = " + paramString + " ,apn = " + paramInt1 + " ,rejectReason = " + paramInt2);
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, "requestVideo-->peerUin=" + paramString1 + " relationType=" + paramInt3 + " businessType" + paramInt2 + " sign" + paramArrayOfByte + " bindId" + paramString2 + " bindType" + paramInt4);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return -1;
    }
    for (;;)
    {
      try
      {
        long l = CharacterUtil.a(paramString1);
        setApType(paramInt1);
        if (paramInt3 == 1)
        {
          paramInt1 = 0;
          quaReport(paramString1, changeBusyType(paramInt2), paramInt1);
          paramInt1 = requestFromQQToUnQQ(l, paramInt2, paramInt3, paramArrayOfByte, paramString2, paramInt4);
          setCarrierType(l);
          return paramInt1;
        }
      }
      catch (NumberFormatException paramString1)
      {
        return -1;
      }
      paramInt1 = 22;
    }
  }
  
  public int requestVideo(String paramString1, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, String paramString6, long paramLong2, byte[] paramArrayOfByte, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, String paramString10)
  {
    paramString10 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString10 = "0";
    }
    paramString1 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      paramString1 = "0";
    }
    paramString5 = paramString6;
    if (TextUtils.isEmpty(paramString6)) {
      paramString5 = "0";
    }
    paramString6 = paramString7;
    if (TextUtils.isEmpty(paramString7)) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (TextUtils.isEmpty(paramString8)) {
      paramString7 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, "requestVideo1 funcall buffer:" + paramString6);
    }
    long l1;
    long l2;
    try
    {
      paramLong1 = CharacterUtil.a(paramString10);
      l1 = Long.parseLong(paramString1);
      l2 = Long.parseLong(paramString5);
      setApType(paramInt1);
      if (paramLong2 != 0L)
      {
        paramInt1 = requestSwitchTerminal(paramLong1, paramInt2, paramInt3, paramLong2);
        setCarrierType(paramLong1);
        return paramInt1;
      }
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
      return -1;
    }
    if ((paramString4 != null) && (paramString4.length() != 0))
    {
      paramInt1 = changeBusyType(paramInt2);
      quaReport(String.valueOf(paramString4), paramInt1, paramInt4);
      paramInt1 = requestByMobileNo(paramLong1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramInt4, paramString6.getBytes(), paramString9, paramInt5, paramInt6);
      setCarrierType(paramLong1);
      return paramInt1;
    }
    if (4 == paramInt3)
    {
      if (29 == paramInt4) {}
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
        paramInt1 = requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString6.getBytes(), paramString7.getBytes("utf-8"), 1013, null, null, null);
        setCarrierType(paramInt1);
        return paramInt1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
        return -1;
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
        paramInt1 = requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString6.getBytes(), paramString7.getBytes("utf-8"), 0, null, null, null);
        setCarrierType(paramLong1);
        return paramInt1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
        return -1;
      }
    }
    try
    {
      quaReport(String.valueOf(paramLong1), changeBusyType(paramInt2), 0);
      paramInt1 = request(paramLong1, paramInt2, paramInt3, paramString6.getBytes(), paramString7.getBytes("utf-8"));
      setCarrierType(paramLong1);
      return paramInt1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
      return -1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
    }
    return -1;
  }
  
  public int requestVideo(String paramString1, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, String paramString6, long paramLong2, byte[] paramArrayOfByte, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, String paramString10, C2BUserInfo paramC2BUserInfo)
  {
    paramString10 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString10 = "0";
    }
    paramString1 = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      paramString1 = "0";
    }
    paramString5 = paramString6;
    if (TextUtils.isEmpty(paramString6)) {
      paramString5 = "0";
    }
    paramString6 = paramString7;
    if (TextUtils.isEmpty(paramString7)) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (TextUtils.isEmpty(paramString8)) {
      paramString7 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, "requestVideo2 funcall buffer:" + paramString6);
    }
    long l1;
    long l2;
    try
    {
      paramLong1 = CharacterUtil.a(paramString10);
      l1 = Long.parseLong(paramString1);
      l2 = Long.parseLong(paramString5);
      setApType(paramInt1);
      if (paramLong2 != 0L)
      {
        paramInt1 = requestSwitchTerminal(paramLong1, paramInt2, paramInt3, paramLong2);
        setCarrierType(paramLong1);
        return paramInt1;
      }
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
      return -1;
    }
    if ((paramString4 != null) && (paramString4.length() != 0))
    {
      paramInt1 = changeBusyType(paramInt2);
      quaReport(String.valueOf(paramString4), paramInt1, paramInt4);
      paramInt1 = requestByMobileNo(paramLong1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramInt4, paramString6.getBytes(), paramString9, paramInt5, paramInt6);
      setCarrierType(paramLong1);
      return paramInt1;
    }
    if (4 == paramInt3) {
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
        paramInt1 = requestFromTempChat(paramLong1, paramInt2, paramInt3, paramInt4, l1, l2, paramArrayOfByte, paramString6.getBytes(), paramString7.getBytes("utf-8"), 0, null, null, null);
        setCarrierType(paramLong1);
        return paramInt1;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
        return -1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
        return -1;
      }
    }
    try
    {
      quaReport(String.valueOf(paramLong1), changeBusyType(paramInt2), 0);
      paramInt1 = request(paramLong1, paramInt2, paramInt3, paramString6.getBytes(), paramString7.getBytes("utf-8"));
      setCarrierType(paramLong1);
      return paramInt1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
      return -1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      AVLog.printErrorLog("VcControllerImpl", paramString1.getMessage());
    }
    return -1;
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
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, "sendAVFunChatMsg, uin=" + paramString1 + ", type=" + paramInt + ", data=" + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return -1;
    }
    String str = paramString1;
    if (paramString1.startsWith("+")) {
      str = paramString1.substring(1);
    }
    try
    {
      long l = CharacterUtil.a(str);
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
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return -1;
    }
    if (TextUtils.isEmpty(paramString))
    {
      AVLog.printErrorLog("VcControllerImpl", "uin is " + paramString);
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
      QLog.e("VcControllerImpl", 1, " sendAVFunChatMsg| uin = " + str);
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
      while (!QLog.isColorLevel()) {}
      QLog.d("VcControllerImpl", 2, " sendTransferMsg string parse long error : uin = " + paramString);
    }
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
      QLog.e("VcControllerImpl", 1, " setGroundGlassSwitch| uin = " + str);
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
    Object localObject = "";
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, 8, arrayOfByte, 0, 8);
    long l1 = arrayOfByte[0];
    long l2 = arrayOfByte[1];
    long l3 = arrayOfByte[2];
    long l4 = arrayOfByte[3];
    long l5 = arrayOfByte[4];
    long l6 = arrayOfByte[5];
    long l7 = arrayOfByte[6];
    long l8 = arrayOfByte[7];
    int j = paramArrayOfByte[17];
    int i = 18;
    if (j > 0)
    {
      localObject = new byte[j];
      System.arraycopy(paramArrayOfByte, 18, localObject, 0, j);
    }
    try
    {
      localObject = new String((byte[])localObject, "utf-8");
      i = j + 18;
      j = i + 2;
      i = paramArrayOfByte[j];
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, j + 1 + 2, arrayOfByte, 0, 4);
      j = arrayOfByte[3];
      int k = arrayOfByte[2];
      int m = arrayOfByte[1];
      int n = arrayOfByte[0];
      paramArrayOfByte = new VcControllerImpl.DeviceCMDTLV(this);
      paramArrayOfByte.jdField_a_of_type_Long = ((l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | (l8 & 0xFF) << 0);
      paramArrayOfByte.jdField_a_of_type_JavaLangString = ((String)localObject);
      paramArrayOfByte.jdField_a_of_type_Int = i;
      paramArrayOfByte.b = (j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16 | (n & 0xFF) << 24);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str = "";
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl
 * JD-Core Version:    0.7.0.1
 */
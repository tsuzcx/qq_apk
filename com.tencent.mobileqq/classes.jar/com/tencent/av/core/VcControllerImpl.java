package com.tencent.av.core;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import baee;
import befc;
import com.tencent.av.app.QuaReportInfo;
import com.tencent.av.business.handler.NetAddr;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import krx;
import ksa;
import kst;
import lbb;
import lbe;
import lbh;
import lbi;
import lbj;
import lbk;
import lef;
import lem;
import mcq;
import mfy;

public class VcControllerImpl
{
  public static final int EM_SDK_EVENT_ACCEPT_VIDEO_MODE = 106;
  public static final int EM_SDK_EVENT_CANCEL_VIDEO_MODE = 108;
  public static final int EM_SDK_EVENT_ID_AUDIO_PLAYBACK_FAILURE = 122;
  public static final int EM_SDK_EVENT_ID_AUDIO_RECORD = 117;
  public static final int EM_SDK_EVENT_ID_AUDIO_RECORD_FAILURE = 121;
  public static final int EM_SDK_EVENT_ID_CUSTOM_COMMAND = 119;
  public static final int EM_SDK_EVENT_ID_DETAIL_NET_STATE_CHECK = 100;
  public static final int EM_SDK_EVENT_ID_DEVICE_ATTR = 110;
  public static final int EM_SDK_EVENT_ID_GROUND_GLASS_SWITCH = 113;
  public static final int EM_SDK_EVENT_ID_GROUND_GLASS_WAIT_TIME = 114;
  public static final int EM_SDK_EVENT_ID_NETWORK_CHECK_REQ = 118;
  public static final int EM_SDK_EVENT_ID_PSTN_CALL = 95;
  public static final int EM_SDK_EVENT_ID_RECV_AVFUNCHATRMSG = 111;
  public static final int EM_SDK_EVENT_ID_REOPEN_CAMERA_NFPS = 116;
  public static final int EM_SDK_EVENT_ID_SMARTDEVICE_AUDIO_DATA = 96;
  public static final int EM_SDK_EVENT_ID_VIDEO_MODE_SELECTED = 120;
  public static final int EM_SDK_EVENT_REJECT_VIDEO_MODE = 107;
  public static final int EM_SDK_EVENT_REQUEST_VIDEO_MODE = 105;
  public static final int EM_VOIP_AUDIOENGINE_READY = 83;
  public static final int EM_VOIP_SEND_FIRST_AUDIO_DATA = 71;
  public static final int EV_M2MVIDEO_DEC_FRAME_DATA = 15;
  public static final int EV_VOIP_ANOTHERISRING = 25;
  public static final int EV_VOIP_ANOTHERRINGDISCONNECTED = 26;
  public static final int EV_VOIP_ANOTHER_HAVEDACCEPT = 13;
  public static final int EV_VOIP_ANOTHER_HAVEDREJECT = 14;
  public static final int EV_VOIP_AUDIO_REQUEST = 2;
  public static final int EV_VOIP_AUDIO_SWITCH = 50;
  public static final int EV_VOIP_CAN_RECV_AUDIO_DATA = 63;
  public static final int EV_VOIP_CLOSED = 4;
  public static final int EV_VOIP_CLOSED_SWITCH_GROUP = 69;
  public static final int EV_VOIP_CONFIGSYS_DEAL_DONE = 18;
  public static final int EV_VOIP_CONNFAIL = 24;
  public static final int EV_VOIP_FRIEND_ACCEPTED = 3;
  public static final int EV_VOIP_HAS_GETTED_SHARP_CONFIG_PAYLOAD = 93;
  public static final int EV_VOIP_HAS_RECV_FIRST_AUDIO_PACKET = 64;
  public static final int EV_VOIP_HAS_RECV_FIRST_VIDEOFRAME = 66;
  public static final int EV_VOIP_InviteReached = 68;
  public static final int EV_VOIP_LOCAL_AUDIO_LESS_DATA = 92;
  public static final int EV_VOIP_LOCAL_AUDIO_NO_DATA = 91;
  public static final int EV_VOIP_MEDIA_CAMERA_NOTIFY = 65;
  public static final int EV_VOIP_MOBILE_AUDIO_REQ = 60;
  public static final int EV_VOIP_MOBILE_VIDEO_REQ = 61;
  public static final int EV_VOIP_NETWORK_BAD = 11;
  public static final int EV_VOIP_NETWORK_GOOD = 12;
  public static final int EV_VOIP_NETWORK_MONITOR_INFO = 16;
  public static final int EV_VOIP_NOT_RECV_AUDIO_DATA = 62;
  public static final int EV_VOIP_OTHER_TER_CHATING_STAUTS = 72;
  public static final int EV_VOIP_PAUSEAUDIO = 7;
  public static final int EV_VOIP_PAUSEVIDEO = 8;
  public static final int EV_VOIP_PEER_NET_STATE_CHECK = 67;
  public static final int EV_VOIP_PEER_SWITCH_FAIL = 76;
  public static final int EV_VOIP_PEER_SWITCH_TERMINAL = 73;
  public static final int EV_VOIP_RECEIVER_RECEIVED_REQ = 17;
  public static final int EV_VOIP_RECEIVE_RELAYASVR_INFO = 5;
  public static final int EV_VOIP_RELAY_SVR_CONNECTED = 6;
  public static final int EV_VOIP_RESUMEAUDIO = 9;
  public static final int EV_VOIP_RESUMEVIDEO = 10;
  public static final int EV_VOIP_SWITCHAUDIO = 19;
  public static final int EV_VOIP_SWITCHVIDEO = 20;
  public static final int EV_VOIP_SWITCHVIDEOCANCEL = 22;
  public static final int EV_VOIP_SWITCHVIDEOCONFIRM = 21;
  public static final int EV_VOIP_SWITCH_TERMINAL_SUCCESS = 74;
  public static final int EV_VOIP_SYNC_OTHER_TERMINAL_CHAT_STATUS = 75;
  public static final int EV_VOIP_VIDEO_REQUEST = 1;
  private static final String KEY_IS_SESSION_OFFLINE = "is_offline_session";
  private static final String KEY_NATIVE_QCLEAR_SWITCH = "native_qclear_switch";
  private static final String KEY_SOCKET_RECONNECT = "enable_reconnect";
  private static final String KEY_SOCKET_RECONNECT_TIMEOUT = "reconnect_timeout";
  public static int NATIVE_ERR_NOT_INI = 0;
  public static int NATIVE_ERR_NO_ENV = 0;
  public static int NATIVE_ERR_NULL_PARA = 0;
  public static int NATIVE_ERR_OUT_MEM = -101;
  private static String SPDEFVALUE = "preview-size-values=320x240,640x480;";
  private static String SPKEY;
  private static String SPNAME;
  private static final String TAG = "VcControllerImpl";
  public static final int VOIP_REASON_CALL_TYPE_NOT_SUIT = 17;
  public static final int VOIP_REASON_CANCLE_BY_REQUESTER_BEFORECALLING = 18;
  public static final int VOIP_REASON_CAPA_EXCHANGE_FAILED = 15;
  public static final int VOIP_REASON_CLOSED_BY_FRIEND = 1;
  public static final int VOIP_REASON_CLOSED_BY_SELF = 0;
  public static final int VOIP_REASON_CLOSED_BY_SELF_IGNORE = 16;
  public static final int VOIP_REASON_CLOSED_BY_SWITCHTOGROUP = 20;
  public static final int VOIP_REASON_CONFLICT = 6;
  public static final int VOIP_REASON_FRIEND_CONFLICT = 7;
  public static final int VOIP_REASON_FRIEND_OFFLINE = 14;
  public static final int VOIP_REASON_FRIEND_VERSION_NOT_SUPPORT = 5;
  public static final int VOIP_REASON_FRIEND_WAIT_RELAYINFO_TIMEOUT = 10;
  public static final int VOIP_REASON_FRIEND_WAIT_RELAY_CONNECT_TIMEOUT = 11;
  public static final int VOIP_REASON_NETWORK_DISCONNECT = 13;
  public static final int VOIP_REASON_NETWORK_ERROR = 12;
  public static final int VOIP_REASON_OTHERS = 30;
  public static final int VOIP_REASON_REJECT_BY_FRIEND = 2;
  public static final int VOIP_REASON_REJECT_BY_SELF = 3;
  public static final int VOIP_REASON_SELF_OFFLINE = 19;
  public static final int VOIP_REASON_SELF_VERSION_NOT_SUPPORT = 4;
  public static final int VOIP_REASON_SELF_WAIT_RELAYINFO_TIMEOUT = 8;
  public static final int VOIP_REASON_SELF_WAIT_RELAY_CONNECT_TIMEOUT = 9;
  private static String mCameraParameters;
  public static boolean mDisableReOpen;
  lbi mEventHandler = null;
  public lbe mEventListener;
  lem mGlStringParser = null;
  private String mMcc = baee.a();
  private String mMnc = "";
  public lbb mNetChannel;
  lbk mSysInfo;
  public boolean mfAudio2VideoFlag = true;
  
  static
  {
    NATIVE_ERR_NOT_INI = -102;
    NATIVE_ERR_NO_ENV = -103;
    NATIVE_ERR_NULL_PARA = -104;
    SPNAME = "AV_CameraParameters";
    SPKEY = "CP";
  }
  
  public VcControllerImpl(Context paramContext, String paramString1, lbb paramlbb, lbe paramlbe, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    loadLibrary(paramContext);
    ConfigInfo.instance();
    paramInt3 = lef.a("VcControllerImpl", paramContext);
    init_deviceinfos(paramContext, paramInt1, paramInt2, paramInt3);
    setScreenSize(paramInt1, paramInt2);
    ClientLogReport.instance().init(paramContext, Integer.parseInt(paramString1));
    this.mNetChannel = paramlbb;
    this.mNetChannel.a(this);
    this.mEventListener = paramlbe;
    if (getSdkVersion() < 18)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VcControllerImpl", 2, "sdk version: " + getSdkVersion());
      }
      throw new UnsatisfiedLinkError();
    }
    cacheMethodIds();
    this.mSysInfo = new lbk();
    lbk.a();
    mCameraParameters = BaseApplicationImpl.getContext().getSharedPreferences(SPNAME, 0).getString(SPKEY, SPDEFVALUE);
    paramContext = befc.b("62ad83");
    if ((!TextUtils.isEmpty(paramContext)) && (paramContext.length() >= 5)) {
      this.mMnc = paramContext.substring(3, 5);
    }
    if (QLog.isColorLevel()) {
      QLog.w("VcControllerImpl", 1, "VcControllerImpl, supportMediaCodec[" + paramInt3 + "], mMnc[" + this.mMnc + "], CameraParameters[" + mCameraParameters + "], sdkVersion[" + getSdkVersion() + "]");
    }
  }
  
  private static native void cacheMethodIds();
  
  private void callbackDataTransfered(int paramInt, long paramLong)
  {
    if (this.mEventListener != null) {
      this.mEventListener.a(paramInt, paramLong);
    }
  }
  
  private int callbackGetAPAndGateWayIP()
  {
    if (this.mEventListener != null) {
      return this.mEventListener.d();
    }
    return -1;
  }
  
  private String callbackGetCustomInfo(long paramLong, String paramString)
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
        int i = mcq.a().o;
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
        localObject1 = String.valueOf(mcq.a().p);
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
          if (this.mEventListener.e(String.valueOf(paramLong)) != 1) {
            continue;
          }
          localObject1 = "true";
        }
        else
        {
          localObject1 = str;
          localObject2 = str;
          if (!"native_qclear_switch".equals(paramString)) {}
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
      QLog.d("VcControllerImpl", 1, "callbackGetCustomInfo KEY_NATIVE_QCLEAR_SWITCH ,result = " + (String)localObject1);
    }
  }
  
  private long callbackGetMSFInviteMessageTimeStamp(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, "callbackGetMSFInviteMessageTimeStamp from " + paramLong);
    }
    if (this.mEventListener != null) {
      return this.mEventListener.a(paramLong);
    }
    return 0L;
  }
  
  private int callbackIsOfflineSession(long paramLong)
  {
    if (this.mEventListener != null) {
      return this.mEventListener.e(String.valueOf(paramLong));
    }
    return 0;
  }
  
  private void callbackOnEvent(int paramInt1, byte[] paramArrayOfByte1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    if (this.mEventListener == null) {
      krx.e("VcControllerImpl", "mEventListener is null");
    }
    while (this.mEventHandler == null) {
      return;
    }
    if (paramInt1 == 117)
    {
      this.mEventListener.a(paramArrayOfByte1, paramInt2, paramInt3);
      return;
    }
    lbj locallbj = new lbj(this);
    locallbj.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    locallbj.jdField_a_of_type_Long = paramLong1;
    locallbj.jdField_b_of_type_Long = paramLong2;
    locallbj.c = paramLong3;
    locallbj.d = paramLong4;
    locallbj.jdField_a_of_type_JavaLangString = paramString;
    locallbj.jdField_a_of_type_Int = paramInt2;
    locallbj.jdField_b_of_type_Int = paramInt3;
    locallbj.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramArrayOfByte1 = this.mEventHandler.obtainMessage(paramInt1, 0, 0, locallbj);
    this.mEventHandler.sendMessage(paramArrayOfByte1);
  }
  
  private void callbackSendConfigReq(byte[] paramArrayOfByte)
  {
    if (this.mNetChannel != null) {
      this.mNetChannel.b(paramArrayOfByte);
    }
  }
  
  private void callbackTcpSendSharpCMD(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.mNetChannel != null)
    {
      this.mNetChannel.a(paramArrayOfByte, paramLong);
      return;
    }
    krx.e("VcControllerImpl", "mNetChannel == null");
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
  
  /* Error */
  private void changePreviewSize(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 241	com/tencent/av/core/VcControllerImpl:mGlStringParser	Llem;
    //   6: ifnonnull +18 -> 24
    //   9: aload_0
    //   10: new 539	lem
    //   13: dup
    //   14: bipush 61
    //   16: bipush 59
    //   18: invokespecial 542	lem:<init>	(CC)V
    //   21: putfield 241	com/tencent/av/core/VcControllerImpl:mGlStringParser	Llem;
    //   24: aload_0
    //   25: invokespecial 545	com/tencent/av/core/VcControllerImpl:queryCameraParameters	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_0
    //   30: getfield 241	com/tencent/av/core/VcControllerImpl:mGlStringParser	Llem;
    //   33: aload_3
    //   34: invokevirtual 548	lem:a	(Ljava/lang/String;)V
    //   37: aload_0
    //   38: getfield 241	com/tencent/av/core/VcControllerImpl:mGlStringParser	Llem;
    //   41: ldc_w 550
    //   44: invokevirtual 552	lem:a	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +34 -> 83
    //   52: aload_3
    //   53: new 300	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   60: iload_1
    //   61: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: ldc_w 554
    //   67: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload_2
    //   71: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokevirtual 557	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   80: ifne +54 -> 134
    //   83: invokestatic 559	com/tencent/mobileqq/utils/AudioHelper:e	()Z
    //   86: ifeq +45 -> 131
    //   89: ldc 157
    //   91: iconst_1
    //   92: new 300	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 561
    //   102: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: iload_1
    //   106: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: ldc_w 563
    //   112: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: iload_2
    //   116: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: ldc_w 383
    //   122: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 386	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_0
    //   132: monitorexit
    //   133: return
    //   134: aload_0
    //   135: getfield 239	com/tencent/av/core/VcControllerImpl:mEventHandler	Llbi;
    //   138: new 565	com/tencent/av/core/VcControllerImpl$1
    //   141: dup
    //   142: aload_0
    //   143: iload_1
    //   144: iload_2
    //   145: invokespecial 568	com/tencent/av/core/VcControllerImpl$1:<init>	(Lcom/tencent/av/core/VcControllerImpl;II)V
    //   148: invokevirtual 572	lbi:post	(Ljava/lang/Runnable;)Z
    //   151: pop
    //   152: goto -21 -> 131
    //   155: astore_3
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_3
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	VcControllerImpl
    //   0	160	1	paramInt1	int
    //   0	160	2	paramInt2	int
    //   28	25	3	str	String
    //   155	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	155	finally
    //   24	48	155	finally
    //   52	83	155	finally
    //   83	131	155	finally
    //   134	152	155	finally
  }
  
  public static void loadLibrary(Context paramContext)
  {
    long l = AudioHelper.b();
    try
    {
      QLog.w("VcControllerImpl", 1, "loadLibrary, seq[" + l + "]", new Throwable("打印调用栈"));
      SoLoadUtil.a(paramContext, "c++_shared", 0, false);
      SoLoadUtil.a(paramContext, "xplatform", 0, false);
      SoLoadUtil.a(paramContext, "stlport_shared", 0, false);
      UpdateAvSo.a(l, paramContext, "SDKCommon", true);
      UpdateAvSo.a(l, paramContext, "VideoCtrl", true);
      return;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      QLog.w("VcControllerImpl", 1, "loadLibrary, UnsatisfiedLinkError, seq[" + l + "]", paramContext);
      UpdateAvSo.b();
    }
  }
  
  private void onRecvRequest(int paramInt, lbj paramlbj)
  {
    byte[] arrayOfByte1 = paramlbj.jdField_a_of_type_ArrayOfByte;
    int i = (int)paramlbj.c;
    String str1 = paramlbj.jdField_a_of_type_JavaLangString;
    int j = paramlbj.jdField_a_of_type_Int;
    int k = paramlbj.jdField_b_of_type_Int;
    if (k == 3124) {
      i = 26;
    }
    String str2 = mfy.a(paramlbj.jdField_b_of_type_Long);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (i)
    {
    default: 
      localObject1 = localObject2;
    case 1: 
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    case 11: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 28: 
    case 0: 
    case 10: 
    case 12: 
    case 19: 
    case 27: 
    case 29: 
    case 4: 
    case 5: 
    case 24: 
    case 25: 
    case 26: 
      while ((paramInt == 2) || (paramInt == 60))
      {
        this.mEventListener.a(i, str2, (String)localObject1, paramlbj.jdField_b_of_type_ArrayOfByte, true, str1, j, k);
        label232:
        if (QLog.isColorLevel()) {
          QLog.d("onRecvRequest", 2, "uinType = " + i + ", extraUin = " + (String)localObject1 + ", longFronUin = " + paramlbj.jdField_b_of_type_Long);
        }
        return;
        localObject1 = null;
        continue;
        localObject1 = localObject2;
        if (arrayOfByte1 != null)
        {
          int m = arrayOfByte1[0];
          localObject1 = null;
          localObject2 = localObject1;
          if (arrayOfByte1.length > m + 1)
          {
            arrayOfByte2 = new byte[m];
            localObject2 = localObject1;
            if (arrayOfByte2 != null)
            {
              System.arraycopy(arrayOfByte1, 1, arrayOfByte2, 0, m);
              localObject2 = new String(arrayOfByte2);
            }
          }
          int n = arrayOfByte1[(m + 1)];
          if (arrayOfByte1.length <= m + n + 2) {
            break label559;
          }
          byte[] arrayOfByte2 = new byte[n];
          localObject1 = null;
          if (arrayOfByte2 != null)
          {
            System.arraycopy(arrayOfByte1, m + 2, arrayOfByte2, 0, n);
            localObject1 = new String(arrayOfByte2);
          }
          if ((localObject1 == null) || (localObject2 == null)) {
            break label556;
          }
          localObject1 = (String)localObject2 + (String)localObject1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("onRecvRequest", 2, "uinType = " + i + ", extraUin = " + (String)localObject1);
      }
      break;
      localObject1 = String.valueOf(paramlbj.d);
      break;
      if ((paramInt != 1) && (paramInt != 61)) {
        break label232;
      }
      this.mEventListener.a(i, str2, (String)localObject1, paramlbj.jdField_b_of_type_ArrayOfByte, false, str1, j, k);
      break label232;
      label556:
      continue;
      label559:
      localObject1 = null;
    }
  }
  
  private boolean quaReport(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = SharedPreferencesProxyManager.getInstance().getProxy(kst.b, 4);
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
    boolean bool = SharedPreferencesProxyManager.getInstance().getProxy(kst.jdField_a_of_type_JavaLangString, 4).edit().clear().commit();
    if (QLog.isColorLevel()) {
      QLog.e("VcControllerImpl", 2, "do qua report : common map commitResult = " + bool);
    }
    return true;
  }
  
  /* Error */
  private String queryCameraParameters()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 736	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5: ifeq +37 -> 42
    //   8: ldc 157
    //   10: iconst_1
    //   11: new 300	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 738
    //   21: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 350	com/tencent/av/core/VcControllerImpl:mCameraParameters	Ljava/lang/String;
    //   27: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 383
    //   33: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 386	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: getstatic 350	com/tencent/av/core/VcControllerImpl:mCameraParameters	Ljava/lang/String;
    //   45: ifnull +11 -> 56
    //   48: getstatic 350	com/tencent/av/core/VcControllerImpl:mCameraParameters	Ljava/lang/String;
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: areturn
    //   56: getstatic 218	com/tencent/av/core/VcControllerImpl:SPDEFVALUE	Ljava/lang/String;
    //   59: astore_1
    //   60: goto -8 -> 52
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	VcControllerImpl
    //   51	9	1	str	String
    //   63	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	63	finally
    //   42	52	63	finally
    //   56	60	63	finally
  }
  
  private native void sendTransferMsg(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  public static boolean setCameraParameters(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("VcControllerImpl", 1, "setCameraParameters, CameraParameters[" + mCameraParameters + "]->[" + paramString + "]");
    }
    mCameraParameters = paramString;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences(SPNAME, 0).edit();
    localEditor.putString(SPKEY, paramString);
    return localEditor.commit();
  }
  
  private void setCarrierType(long paramLong)
  {
    setCarrierType(paramLong, this.mMcc, this.mMnc);
    if (QLog.isColorLevel()) {
      QLog.d("VcControllerImpl", 2, "uin = " + paramLong + ", mMcc = " + this.mMcc + ", mMnc = " + this.mMnc);
    }
  }
  
  private native int setGatewayTestResult(int paramInt1, int paramInt2, int paramInt3);
  
  private native int setupDeviceInfos(String paramString);
  
  public String GetManufacture()
  {
    return Build.MANUFACTURER;
  }
  
  public String GetOsName()
  {
    return Build.VERSION.RELEASE;
  }
  
  public String GetRomInfo()
  {
    return Build.VERSION.INCREMENTAL;
  }
  
  public native int PauseVideo(long paramLong);
  
  public native boolean QuaReport(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4);
  
  public native int ResumeVideo(long paramLong);
  
  public native void SetAudioDataSendByDefault(boolean paramBoolean);
  
  public native void SetAudioDataSink(boolean paramBoolean);
  
  public int SetAudioInputMute(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return stopAudioSend();
    }
    return startAudioSend();
  }
  
  public int SetAudioOutput(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return startAudioRecv();
    }
    return stopAudioRecv();
  }
  
  public int SetNetIPAndPort(String paramString, int paramInt)
  {
    return setNetIpAndPort(paramString, paramInt);
  }
  
  public native int SetOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
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
      long l = mfy.a(paramString);
      return setSelfUin(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int accept(long paramLong, int paramInt1, int paramInt2);
  
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
      paramLong = mfy.a(paramString);
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
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int acceptVideoMode(long paramLong);
  
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
      long l = mfy.a(paramString);
      return acceptVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int cancelVideoMode(long paramLong);
  
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
      long l = mfy.a(paramString);
      return cancelVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int close(long paramLong, int paramInt);
  
  public int closeVideo(String paramString, int paramInt)
  {
    QLog.d("VcControllerImpl", 1, "closeVideo reason = " + paramInt, new Throwable());
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
      long l = mfy.a(paramString);
      paramInt = close(l, paramInt);
      setCarrierType(l);
      return paramInt;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
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
  
  native int doQuaReport(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public native boolean enableLoopback(boolean paramBoolean);
  
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
  
  native int getBusiTypeFromCmdPkg(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt);
  
  public int getCameraFacing()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.c();
    }
    return 0;
  }
  
  native long getChatRoomID(long paramLong);
  
  public long getChatRoomID(String paramString)
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
      long l = mfy.a(paramString);
      return getChatRoomID(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1L;
  }
  
  native int getCmdTypeFromCmdPkg(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt);
  
  public int getCpuArchitecture()
  {
    if (this.mSysInfo != null)
    {
      lbk locallbk = this.mSysInfo;
      return lbk.f();
    }
    return 0;
  }
  
  public int getCpuMaxFrequency()
  {
    return (int)lbk.jdField_a_of_type_Long;
  }
  
  public String getDeviceName()
  {
    return lbk.b();
  }
  
  public int getDispHeight()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.h;
    }
    return 0;
  }
  
  public int getDispWidth()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.g;
    }
    return 0;
  }
  
  public native int getEncodeFrameFunctionPtrFunPtr();
  
  native byte[] getInterestingString(long paramLong);
  
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
      long l = mfy.a(paramString);
      return getInterestingString(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return null;
  }
  
  public int getNumCores()
  {
    return lbk.jdField_b_of_type_Int;
  }
  
  public native int getOnPeerFrameRenderEndFunctionPtr();
  
  public int getOsType()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.d();
    }
    return 0;
  }
  
  native int getPeerSdkVersion(long paramLong);
  
  public int getPeerSdkVersion(String paramString)
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
      long l = mfy.a(paramString);
      return getPeerSdkVersion(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int getPeerTerminalType(long paramLong);
  
  public int getPeerTerminalType(String paramString)
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
      long l = mfy.a(paramString);
      return getPeerTerminalType(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public int getScreenHeight()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.f;
    }
    return 0;
  }
  
  public int getScreenWidth()
  {
    if (this.mSysInfo != null) {
      return this.mSysInfo.e;
    }
    return 0;
  }
  
  public native int getSdkVersion();
  
  native long getTrafficSize(long paramLong);
  
  public long getTrafficSize(String paramString)
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
      long l = mfy.a(paramString);
      return getTrafficSize(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1L;
  }
  
  public native int getVolume(boolean paramBoolean);
  
  public native int hasAVShiftAbility(long paramLong);
  
  native int ignore(long paramLong);
  
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
      long l = mfy.a(paramString);
      setApType(paramInt);
      paramInt = ignore(l);
      setCarrierType(l);
      return paramInt;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public int init(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt, String paramString12, SDKConfigInfo paramSDKConfigInfo)
  {
    return init(paramContext, paramLong, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramInt, paramString12, paramSDKConfigInfo, false, false);
  }
  
  public native int init(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt, String paramString12, SDKConfigInfo paramSDKConfigInfo, boolean paramBoolean1, boolean paramBoolean2);
  
  @TargetApi(9)
  public void init_deviceinfos(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "PRODUCT=" + Build.PRODUCT + ";";
    str = str + "CPU_ABI=" + Build.CPU_ABI + ";";
    str = str + "TAGS=" + Build.TAGS + ";";
    str = str + "VERSION_CODES_BASE=1;";
    str = str + "MODEL=" + Build.MODEL + ";";
    str = str + "SDK=" + Build.VERSION.SDK_INT + ";";
    str = str + "VERSION_RELEASE=" + Build.VERSION.RELEASE + ";";
    str = str + "DEVICE=" + Build.DEVICE + ";";
    str = str + "DISPLAY=" + Build.DISPLAY + ";";
    str = str + "BRAND=" + Build.BRAND + ";";
    str = str + "BOARD=" + Build.BOARD + ";";
    str = str + "FINGERPRINT=" + Build.FINGERPRINT + ";";
    str = str + "ID=" + Build.ID + ";";
    str = str + "MANUFACTURER=" + Build.MANUFACTURER + ";";
    str = str + "USER=" + Build.USER + ";";
    if (paramInt3 > 0) {
      if ((paramInt3 & 0x1) == 1)
      {
        str = str + "HWAVCDEC=1;";
        if ((paramInt3 & 0x2) != 2) {
          break label884;
        }
        str = str + "HWAVCENC=1;";
        label575:
        if ((paramInt3 & 0x4) != 4) {
          break label910;
        }
        str = str + "HWHEVCDEC=1;";
        label606:
        if ((paramInt3 & 0x8) != 8) {
          break label936;
        }
        str = str + "HWHEVCENC=1;";
        label639:
        paramContext = paramContext.getApplicationInfo();
        str = str + "DATADIR=" + paramContext.dataDir + ";";
        if (Build.VERSION.SDK_INT < 9) {
          break label1057;
        }
      }
    }
    label910:
    label1057:
    for (paramContext = str + "LIBDIR=" + paramContext.nativeLibraryDir + ";";; paramContext = str + "LIBDIR=" + paramContext.dataDir + "/lib;")
    {
      paramContext = paramContext + "W=" + paramInt1 + ";";
      paramContext = paramContext + "H=" + paramInt2 + ";";
      if (QLog.isColorLevel()) {
        QLog.i("VcControllerImpl", 2, "init_deviceinfos, info[" + paramContext + "]");
      }
      setupDeviceInfos(paramContext);
      if (this.mEventHandler == null)
      {
        paramContext = Looper.getMainLooper();
        if (paramContext == null) {
          break label1095;
        }
        this.mEventHandler = new lbi(this, paramContext);
      }
      return;
      str = str + "HWAVCDEC=0;";
      break;
      label884:
      str = str + "HWAVCENC=0;";
      break label575;
      str = str + "HWHEVCDEC=0;";
      break label606;
      label936:
      str = str + "HWHEVCENC=0;";
      break label639;
      str = str + "HWAVCENC=0;";
      str = str + "HWAVCDEC=0;";
      str = str + "HWHEVCENC=0;";
      str = str + "HWHEVCDEC=0;";
      break label639;
    }
    label1095:
    paramContext = Looper.myLooper();
    if (paramContext != null)
    {
      this.mEventHandler = new lbi(this, paramContext);
      return;
    }
    this.mEventHandler = null;
  }
  
  public native boolean isEnableLoopback();
  
  public native boolean isEngineActive();
  
  native int notifyAnotherSelfIsRing(long paramLong, boolean paramBoolean);
  
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
      long l = mfy.a(paramString);
      return notifyAnotherSelfIsRing(l, paramBoolean);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public native int notifyAnotherTerChatStatus(long paramLong, int paramInt);
  
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
  
  public native int onLogOutByKicked();
  
  public native void onProcessExit();
  
  public native int onRecvVideoCallBytesForSharp(byte[] paramArrayOfByte);
  
  public native int onRecvVideoCallBytesForSharpC2SACK(byte[] paramArrayOfByte);
  
  native int onRecvVideoCloudConfig(byte[] paramArrayOfByte);
  
  public int pauseVideo(String paramString)
  {
    try
    {
      int i = stopVideoSend();
      return i;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public native byte[] postData(long paramLong, byte[] paramArrayOfByte);
  
  public native AVPbInfo processQCallPush(byte[] paramArrayOfByte, AVPbInfo paramAVPbInfo);
  
  public lbh receiveTransferMsg(String paramString, byte[] paramArrayOfByte)
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
  
  public native int registerDAudioDataCallback(int paramInt, boolean paramBoolean);
  
  native int reject(long paramLong, int paramInt);
  
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
      long l = mfy.a(paramString);
      setApType(paramInt1);
      paramInt1 = reject(l, paramInt2);
      setCarrierType(l);
      return paramInt1;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int rejectVideoMode(long paramLong);
  
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
      long l = mfy.a(paramString);
      return rejectVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  native int request(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  native int requestByMobileNo(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3, byte[] paramArrayOfByte, String paramString4, int paramInt4, int paramInt5);
  
  native int requestFromQQToUnQQ(long paramLong, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString, int paramInt3);
  
  native int requestFromTempChat(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt4, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6);
  
  public int requestFromUnQQ(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    quaReport(String.valueOf(paramLong), changeBusyType(paramInt1), 0);
    paramInt1 = requestUnQQ(paramLong, paramInt1, paramInt2, paramInt3);
    setCarrierType(paramLong);
    return paramInt1;
  }
  
  native int requestReConnect(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  native int requestSharp(long paramLong, int paramInt1, int paramInt2);
  
  native int requestSwitchTerminal(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  native int requestUnQQ(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
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
        long l = mfy.a(paramString1);
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
      paramLong1 = mfy.a(paramString10);
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
      krx.e("VcControllerImpl", paramString1.getMessage());
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
        krx.e("VcControllerImpl", paramString1.getMessage());
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
        krx.e("VcControllerImpl", paramString1.getMessage());
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
      krx.e("VcControllerImpl", paramString1.getMessage());
      return -1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      krx.e("VcControllerImpl", paramString1.getMessage());
    }
    return -1;
  }
  
  public int requestVideo(String paramString1, long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, int paramInt4, String paramString5, String paramString6, long paramLong2, byte[] paramArrayOfByte, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, String paramString10, ksa paramksa)
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
      paramLong1 = mfy.a(paramString10);
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
      krx.e("VcControllerImpl", paramString1.getMessage());
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
        krx.e("VcControllerImpl", paramString1.getMessage());
        return -1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        krx.e("VcControllerImpl", paramString1.getMessage());
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
      krx.e("VcControllerImpl", paramString1.getMessage());
      return -1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      krx.e("VcControllerImpl", paramString1.getMessage());
    }
    return -1;
  }
  
  native int requestVideoMode(long paramLong);
  
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
      long l = mfy.a(paramString);
      return requestVideoMode(l);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      krx.e("VcControllerImpl", paramString.getMessage());
    }
    return -1;
  }
  
  public int resumeVideo(String paramString)
  {
    return startVideoSend();
  }
  
  native int sendAVFunChatMsg(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
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
      long l = mfy.a(str);
      return sendAVFunChatMsg(l, paramInt, paramString2.getBytes());
    }
    catch (NumberFormatException paramString1)
    {
      paramString1.printStackTrace();
      krx.e("VcControllerImpl", paramString1.getMessage());
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
      krx.e("VcControllerImpl", "uin is " + paramString);
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
  
  public native int sendAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public native int sendDTMFMessage(long paramLong, char paramChar);
  
  public native int sendQueryRoomInfoRequest(long paramLong1, long paramLong2);
  
  public native int sendRecordingRequest(long paramLong1, boolean paramBoolean, NetAddr[] paramArrayOfNetAddr, long paramLong2);
  
  public native int sendSelectVideoModeRequest(long paramLong, int paramInt);
  
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
  
  public native int setApType(int paramInt);
  
  public native void setAudioOpt(boolean paramBoolean);
  
  native int setAudioOutputMode(int paramInt);
  
  public int setAudioSpeakerVolume(int paramInt)
  {
    return 0;
  }
  
  public void setBackground(boolean paramBoolean) {}
  
  public native void setCarrierType(long paramLong, String paramString1, String paramString2);
  
  native int setGatewayIp(String paramString);
  
  native int setGroundGlassSwitch(long paramLong, int paramInt);
  
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
      krx.e("VcControllerImpl", localUnsatisfiedLinkError.getMessage());
    }
    return -1;
  }
  
  native int setNetIpAndPort(String paramString, int paramInt);
  
  public native void setProcessDecoderFrameFunctionptr(int paramInt);
  
  native int setProductId(int paramInt);
  
  public void setScreenSize(int paramInt1, int paramInt2)
  {
    if (this.mSysInfo != null) {
      this.mSysInfo.a(paramInt1, paramInt2);
    }
  }
  
  native int setSelfUin(long paramLong);
  
  public native void setVideoJitterLength(int paramInt);
  
  public native void setVideoReceiver(boolean paramBoolean);
  
  public native int setVoiceType(int paramInt);
  
  native int startAudioRecv();
  
  native int startAudioSend();
  
  native int startVideoSend();
  
  native int stopAudioRecv();
  
  native int stopAudioSend();
  
  native int stopVideoSend();
  
  native int switchAudio(long paramLong);
  
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
      long l = mfy.a(paramString);
      int i = switchAudio(l);
      if (i == -1) {
        this.mfAudio2VideoFlag = false;
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcControllerImpl", 2, "switchAudio", paramString);
      }
    }
    return -1;
  }
  
  native int switchVideo(long paramLong);
  
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
      long l = mfy.a(paramString);
      int i = switchVideo(l);
      if (i == -1) {
        this.mfAudio2VideoFlag = false;
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VcControllerImpl", 2, "switchVideo", paramString);
      }
    }
    return -1;
  }
  
  public native int uninit();
  
  public lbh unpackTLV(byte[] paramArrayOfByte)
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
      paramArrayOfByte = new lbh(this);
      paramArrayOfByte.jdField_a_of_type_Long = ((l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | (l8 & 0xFF) << 0);
      paramArrayOfByte.jdField_a_of_type_JavaLangString = ((String)localObject);
      paramArrayOfByte.jdField_a_of_type_Int = i;
      paramArrayOfByte.jdField_b_of_type_Int = (j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16 | (n & 0xFF) << 24);
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
  
  public native int unregisterDAudioDataCallback(int paramInt, boolean paramBoolean);
  
  public native int unregisterDAudioDataCallbackAll();
  
  public native int updateConfigInfo();
  
  public native int updateNetworkTestResult(long paramLong, int paramInt);
  
  public native int updateProcessInfo(long paramLong, String paramString1, String paramString2);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl
 * JD-Core Version:    0.7.0.1
 */
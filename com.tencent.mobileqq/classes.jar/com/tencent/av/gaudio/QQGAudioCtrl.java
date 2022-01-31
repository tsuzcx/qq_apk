package com.tencent.av.gaudio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.config.Common;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;
import jje;
import jjf;

public class QQGAudioCtrl
{
  static final int EM_SDK_EVENT_ID_ALL_CAN_GO_ON_STAGE = 103;
  static final int EM_SDK_EVENT_ID_ALL_MEM_UPDATE = 44;
  static final int EM_SDK_EVENT_ID_ALL_ONLINE_NOTICE = 16;
  static final int EM_SDK_EVENT_ID_CAMERAQOS_FPS_CHANGE = 171;
  static final int EM_SDK_EVENT_ID_CHANGE_MIC_ORDER = 151;
  static final int EM_SDK_EVENT_ID_CONN_TIMEOUT = 39;
  static final int EM_SDK_EVENT_ID_CREATE_FAIL = 31;
  static final int EM_SDK_EVENT_ID_CREATE_ROOM_FAILED = 138;
  static final int EM_SDK_EVENT_ID_CREATE_SUC = 30;
  static final int EM_SDK_EVENT_ID_CREATE_TIMEOUT = 32;
  static final int EM_SDK_EVENT_ID_DESTORY = 11;
  static final int EM_SDK_EVENT_ID_DETECT_USER_AUDIO_HOWLING = 153;
  static final int EM_SDK_EVENT_ID_DETECT_USER_AUDIO_NOISY = 145;
  static final int EM_SDK_EVENT_ID_ENTER_FAIL = 34;
  static final int EM_SDK_EVENT_ID_ENTER_ROOM_FAILED = 139;
  static final int EM_SDK_EVENT_ID_ENTER_SUC = 33;
  static final int EM_SDK_EVENT_ID_ENTER_TIMEOUT = 35;
  static final int EM_SDK_EVENT_ID_GET_MUL_ROOM_INFO = 9;
  static final int EM_SDK_EVENT_ID_GET_ROOM_INFO = 8;
  static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_FAIL = 94;
  static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_SUC = 93;
  static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_TIMEOUT = 95;
  static final int EM_SDK_EVENT_ID_GO_ON_STAGE_FAIL = 91;
  static final int EM_SDK_EVENT_ID_GO_ON_STAGE_SUC = 90;
  static final int EM_SDK_EVENT_ID_GO_ON_STAGE_TIMEOUT = 92;
  static final int EM_SDK_EVENT_ID_GROUP_VIDEO_MODE_FREE_MODE = 107;
  static final int EM_SDK_EVENT_ID_GROUP_VIDEO_MODE_MIC_ORDER_MODE = 108;
  static final int EM_SDK_EVENT_ID_GROUP_VIDEO_SRC_TYPE_CHANGE = 109;
  static final int EM_SDK_EVENT_ID_HAS_GETTED_SHARP_CONFIG_PAYLOAD = 123;
  static final int EM_SDK_EVENT_ID_INSUFFICIENT_FUNDS = 146;
  static final int EM_SDK_EVENT_ID_KickOut_FAIL = 22;
  static final int EM_SDK_EVENT_ID_KickOut_SUC = 21;
  static final int EM_SDK_EVENT_ID_MEETINGCONTROLMODE_CHANGE = 142;
  static final int EM_SDK_EVENT_ID_MEM_AUDIO_IN = 141;
  static final int EM_SDK_EVENT_ID_MEM_AUDIO_OUT = 140;
  static final int EM_SDK_EVENT_ID_MEM_BAN_AUDIO = 74;
  static final int EM_SDK_EVENT_ID_MEM_CANCEL_BAN_AUDIO = 75;
  static final int EM_SDK_EVENT_ID_MEM_GET_OUT = 71;
  static final int EM_SDK_EVENT_ID_MEM_KICKED_OUT = 45;
  static final int EM_SDK_EVENT_ID_MEM_POS_CHANGE = 80;
  static final int EM_SDK_EVENT_ID_MEM_PPT_IN = 76;
  static final int EM_SDK_EVENT_ID_MEM_PPT_OUT = 77;
  static final int EM_SDK_EVENT_ID_MEM_SCREEN_IN = 78;
  static final int EM_SDK_EVENT_ID_MEM_SCREEN_OUT = 79;
  static final int EM_SDK_EVENT_ID_MEM_VIDEO_IN = 72;
  static final int EM_SDK_EVENT_ID_MEM_VIDEO_OUT = 73;
  static final int EM_SDK_EVENT_ID_MICOFFBYSELF_NOTIFY = 157;
  static final int EM_SDK_EVENT_ID_MICONBYADMINFAIL_NOTIFY = 158;
  static final int EM_SDK_EVENT_ID_NEW_GET_IN = 70;
  static final int EM_SDK_EVENT_ID_NEW_SPEAKING = 42;
  static final int EM_SDK_EVENT_ID_OFFLINE_RECV_INVITE = 5;
  static final int EM_SDK_EVENT_ID_OLD_STOP_SPEAKING = 43;
  static final int EM_SDK_EVENT_ID_ONLINE_NOTICE = 13;
  static final int EM_SDK_EVENT_ID_ONLY_MANAGER_CAN_GO_ON_STAGE = 102;
  static final int EM_SDK_EVENT_ID_ONLY_MANAGER_STAGER_CAN_SPEAK = 104;
  static final int EM_SDK_EVENT_ID_OTHER_TERM_ENTER = 12;
  static final int EM_SDK_EVENT_ID_PBInvite_Rsp = 20;
  static final int EM_SDK_EVENT_ID_PBInvite_Rsp_CALL_BACK = 24;
  static final int EM_SDK_EVENT_ID_PBPstnStrategy_Rsp = 23;
  static final int EM_SDK_EVENT_ID_PLAY_MEDIA_FILE = 105;
  static final int EM_SDK_EVENT_ID_PPT_UPLOAD_STATE = 110;
  static final int EM_SDK_EVENT_ID_PROTOCOL_ERR = 7;
  static final int EM_SDK_EVENT_ID_PSTN_ACCOUNT_LIMIT_REACHED = 130;
  static final int EM_SDK_EVENT_ID_PSTN_BILL = 19;
  static final int EM_SDK_EVENT_ID_PSTN_INVITEES_AUTHORITY_FORBIDDEN = 136;
  static final int EM_SDK_EVENT_ID_PSTN_INVITEES_TIMES_LIMIT_REACHED = 137;
  static final int EM_SDK_EVENT_ID_PSTN_INVITER_AUTHORITY_FORBIDDEN = 131;
  static final int EM_SDK_EVENT_ID_PSTN_INVITER_LOCATION_LIMIT = 135;
  static final int EM_SDK_EVENT_ID_PSTN_INVITER_NOT_IN_GRAY = 129;
  static final int EM_SDK_EVENT_ID_PSTN_INVITER_P2M_TIMES_LIMIT_REACHED = 134;
  static final int EM_SDK_EVENT_ID_PSTN_INVITER_P2P_TIMES_LIMIT_REACHED = 133;
  static final int EM_SDK_EVENT_ID_PSTN_INVITER_TIME_UPPER_LIMIT = 132;
  static final int EM_SDK_EVENT_ID_PSTN_INVITE_FAILED = 149;
  static final int EM_SDK_EVENT_ID_PSTN_INVITE_INSUFFICIENT_FUNDS = 147;
  static final int EM_SDK_EVENT_ID_PSTN_INVITE_INSUFFICIENT_FUNDS_ALL = 148;
  static final int EM_SDK_EVENT_ID_QUIT_FAIL = 37;
  static final int EM_SDK_EVENT_ID_QUIT_SUC = 36;
  static final int EM_SDK_EVENT_ID_QUIT_TIMEOUT = 38;
  static final int EM_SDK_EVENT_ID_RECV_INVITE = 6;
  static final int EM_SDK_EVENT_ID_RECV_INVITE_SWITCH_FROM_P2PAV = 25;
  static final int EM_SDK_EVENT_ID_RECV_INVITE_SWITCH_FROM_P2PSHARE = 26;
  static final int EM_SDK_EVENT_ID_RECV_MEETING_TIME = 124;
  static final int EM_SDK_EVENT_ID_RECV_NET_TRAFFIC_DATA_SIZE = 50;
  static final int EM_SDK_EVENT_ID_REQUEST_MICDATA = 150;
  static final int EM_SDK_EVENT_ID_ROOM_INFO_CHANGE = 10;
  static final int EM_SDK_EVENT_ID_SEND_EMBED_CHNNEL = 152;
  static final int EM_SDK_EVENT_ID_SEND_NET_TRAFFIC_DATA_SIZE = 51;
  static final int EM_SDK_EVENT_ID_SERVER_REFUSED = 46;
  static final int EM_SDK_EVENT_ID_SETMICBYADMIN_NOTIFY = 143;
  static final int EM_SDK_EVENT_ID_SETMICFAIL_NOTIFY = 144;
  static final int EM_SDK_EVENT_ID_SPEAK_MODE_PRESS_SPEAK = 101;
  static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_FAIL = 97;
  static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_SUC = 96;
  static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_TIMEOUT = 98;
  static final int EM_SDK_EVENT_ID_STOP_PLAY_MEDIA_FILE = 106;
  static final int EM_SDK_EVENT_ID_TOTAL_NET_TRAFFIC_DATA_SIZE = 52;
  static final int EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA = 61;
  static final int EV_GA_SDK_DETECT_AUDIO_DATA_LESS = 122;
  static final int EV_GA_SDK_DETECT_AUDIO_DATA_NULL = 121;
  private static String SPDEFVALUE = "preview-size-values=320x240,640x480;";
  private static String SPKEY;
  private static String SPNAME = "AV_CameraParameters";
  static final String TAG = "QQGAudioCtrl";
  private static String mCameraParameters;
  static QQGAudioCtrl sQQGAudioCtrl;
  private int appid;
  jje mEventHandler = null;
  long mGroupId = 0L;
  public Vector mInviteGAudioUinList = new Vector();
  public boolean mIsSwitchGroup;
  private VcSystemInfo mSysInfo;
  public VideoController mVideoController = null;
  public int pstnLevel;
  public int pstnOriginal = 3;
  
  static
  {
    SPKEY = "CP";
  }
  
  public QQGAudioCtrl()
  {
    regCallbacks();
    int i = AndroidCodec.a(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.e("HWAVC", 2, "supportMediaCodec:" + i);
    }
    init_deviceinfos(BaseApplicationImpl.getContext(), i);
    Looper localLooper;
    if (this.mEventHandler == null)
    {
      localLooper = Looper.getMainLooper();
      if (localLooper == null) {
        break label126;
      }
      this.mEventHandler = new jje(this, localLooper);
    }
    for (;;)
    {
      this.mSysInfo = new VcSystemInfo();
      return;
      label126:
      localLooper = Looper.myLooper();
      if (localLooper != null) {
        this.mEventHandler = new jje(this, localLooper);
      } else {
        this.mEventHandler = null;
      }
    }
  }
  
  private ArrayList getAVInfoListFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "getAVInfoListFromByte--> buf is null");
      }
    }
    int i;
    ArrayList localArrayList;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return null;
          if (paramInt != 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("QQGAudioCtrl", 2, "getAVInfoListFromByte--> structLen is 0");
        return null;
        i = paramArrayOfByte.length;
        if (i % paramInt == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("QQGAudioCtrl", 2, "getAVInfoListFromByte--> buf len is incorrect");
      return null;
      int j = i / paramInt;
      localArrayList = new ArrayList();
      i = 0;
      if (i >= j) {
        break label173;
      }
      localObject = new byte[paramInt];
      System.arraycopy(paramArrayOfByte, i * paramInt, localObject, 0, paramInt);
      localObject = getAVInfoFromByte((byte[])localObject, paramInt);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQGAudioCtrl", 2, "Can not get AVUserInfo...Error");
    return null;
    if ((((AVUserInfo)localObject).jdField_a_of_type_Int == 1) && (((AVUserInfo)localObject).jdField_b_of_type_Int != 3)) {}
    for (;;)
    {
      i += 1;
      break;
      localArrayList.add(localObject);
    }
    label173:
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "getAVInfoListFromByte --> length = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  private ArrayList getAvPhoneUserInfoFromString(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "getAvPhoneUserInfoFromString --> info = " + paramString);
    }
    paramString = paramString.split("\\|");
    if (paramString.length % 2 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "getAvPhoneUserInfoFromString --> Length is not currect");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length / 2)
    {
      Object localObject1 = paramString[(i * 2 + 0)];
      Object localObject2 = paramString[(i * 2 + 1)];
      AVPhoneUserInfo localAVPhoneUserInfo = new AVPhoneUserInfo();
      localAVPhoneUserInfo.accountType = 3;
      localAVPhoneUserInfo.telInfo.mobile = localObject2;
      localAVPhoneUserInfo.telInfo.nation = localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "getAvPhoneUserInfoFromString --> InfoItem = " + localAVPhoneUserInfo.toString());
      }
      localArrayList.add(localAVPhoneUserInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  public static QQGAudioCtrl getGAudioCtrlInstance()
  {
    if (sQQGAudioCtrl == null)
    {
      if (!loadGAEngine()) {
        return null;
      }
      sQQGAudioCtrl = new QQGAudioCtrl();
      mCameraParameters = BaseApplicationImpl.getContext().getSharedPreferences(SPNAME, 0).getString(SPKEY, SPDEFVALUE);
    }
    return sQQGAudioCtrl;
  }
  
  private int getIntFromByte(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j |= (paramArrayOfByte[(3 - i)] & 0xFF) << (3 - i) * 4;
      i += 1;
    }
    return j;
  }
  
  private long[] getUinListFromBuf(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong2 = null;
    long[] arrayOfLong1 = arrayOfLong2;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length >= 8) {
        break label25;
      }
      arrayOfLong1 = arrayOfLong2;
    }
    label25:
    int i;
    do
    {
      return arrayOfLong1;
      i = paramArrayOfByte.length;
      arrayOfLong1 = arrayOfLong2;
    } while (i % 8 != 0);
    arrayOfLong2 = new long[i / 8];
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    for (;;)
    {
      arrayOfLong1 = arrayOfLong2;
      if (i < 8) {
        break;
      }
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, 8);
      long l = getLongFromByte(arrayOfByte);
      if (l == 0L)
      {
        arrayOfLong1 = arrayOfLong2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("QQGAudioCtrl", 2, "getUinListFromBuf-->get the wrong uin==0");
        return arrayOfLong2;
      }
      arrayOfLong2[(j / 8)] = l;
      j += 8;
      i -= 8;
    }
  }
  
  public static boolean loadGAEngine()
  {
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "xplatform", 0, false);
      return false;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      try
      {
        UpdateAvSo.a(BaseApplicationImpl.getContext(), "qav_gaudio_engine", true);
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        AVLog.e("QQGAudioCtrl", localUnsatisfiedLinkError2.getMessage());
      }
      localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
      localUnsatisfiedLinkError1.printStackTrace();
      return false;
    }
  }
  
  private native int onRecvGAudioCMD(int paramInt, byte[] paramArrayOfByte);
  
  /* Error */
  private String queryCameraParameters()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 445	com/tencent/av/gaudio/QQGAudioCtrl:mCameraParameters	Ljava/lang/String;
    //   5: ifnull +11 -> 16
    //   8: getstatic 445	com/tencent/av/gaudio/QQGAudioCtrl:mCameraParameters	Ljava/lang/String;
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: getstatic 242	com/tencent/av/gaudio/QQGAudioCtrl:SPDEFVALUE	Ljava/lang/String;
    //   19: astore_1
    //   20: goto -8 -> 12
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	QQGAudioCtrl
    //   11	9	1	str	String
    //   23	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	23	finally
    //   16	20	23	finally
  }
  
  public static native void regCallbacks();
  
  public static void setCameraParameters(String paramString, boolean paramBoolean)
  {
    mCameraParameters = paramString;
    if (paramBoolean)
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences(SPNAME, 0).edit();
      localEditor.putString(SPKEY, paramString);
      localEditor.commit();
    }
  }
  
  public static native void setandroidapppath(String paramString);
  
  private native int stopAudioSend(boolean paramBoolean);
  
  private native int stopVideoSend();
  
  private native int updateRoomInfo(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public byte[] GetConfigInfoFromFile()
  {
    return Common.a(BaseApplicationImpl.getContext(), "VideoConfigInfo");
  }
  
  native int GetInviteStrategy(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  public native int GetOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public String GetSharpConfigPayloadFromFile()
  {
    Object localObject = Common.a(BaseApplicationImpl.getContext(), "SharpConfigPayload");
    if (localObject != null)
    {
      String str = new String((byte[])localObject);
      int i = str.indexOf('|');
      localObject = str.substring(0, i);
      str = str.substring(i + 1);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "GetSharpConfigPayloadFromFile multi version: " + (String)localObject + ". payload: " + str);
      }
      return str;
    }
    return "";
  }
  
  public int GetSharpConfigVersionFromFile()
  {
    int i = 0;
    Object localObject = Common.a(BaseApplicationImpl.getContext(), "SharpConfigPayload");
    if (localObject != null)
    {
      String str = new String((byte[])localObject);
      i = str.indexOf('|');
      localObject = str.substring(0, i);
      str = str.substring(i + 1);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "GetSharpConfigPayloadFromFile multi version: " + (String)localObject + ". payload: " + str);
      }
      i = Integer.parseInt((String)localObject);
    }
    return i;
  }
  
  public native int Invite(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4);
  
  public native int InvitePstn(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  public native int KickOutPstnUsers();
  
  public native void LockVideoMaxQP(int paramInt);
  
  public native int ReadDataFromTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native void SetAudioDataSendByDefault(boolean paramBoolean);
  
  public native void SetAudioDataSink(boolean paramBoolean);
  
  public native int SetOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void SetVideoController(VideoController paramVideoController)
  {
    this.mVideoController = paramVideoController;
  }
  
  public native void SetVideoDataSendByDefault(boolean paramBoolean);
  
  public native void SetVideoDataSink(boolean paramBoolean);
  
  public native int WriteDataToTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  public int acceptGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long[] paramArrayOfLong, int paramInt4, long paramLong2, int paramInt5)
  {
    if ((paramLong1 == 0L) || (paramInt2 == -1) || (paramInt1 == -1) || (paramInt3 == -1)) {
      return -1;
    }
    this.mGroupId = paramLong1;
    if ((paramInt1 == 2) && (paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      if (this.mInviteGAudioUinList.size() > 0) {
        this.mInviteGAudioUinList.clear();
      }
      int i = paramArrayOfLong.length;
      paramInt4 = 0;
      while (paramInt4 < i)
      {
        if (paramArrayOfLong[paramInt4] != paramLong2) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[paramInt4]));
        }
        paramInt4 += 1;
      }
    }
    QLog.w("QQGAudioCtrl", 1, "acceptGAudio, emAVRelationType[" + paramInt1 + "], emMultiAVType[" + paramInt2 + "], emMultiAVSubType[" + paramInt3 + "], nConfID[" + paramInt5 + "], groupId[" + paramLong1 + "]");
    accept(paramInt1, paramLong1, paramInt2, paramInt3, paramInt5);
    return 0;
  }
  
  public native boolean enableLoopback(boolean paramBoolean);
  
  public native String getAVGQuality();
  
  public AVUserInfo getAVInfoFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = null;
    if (paramArrayOfByte == null) {}
    long l;
    int i;
    do
    {
      do
      {
        return localObject;
      } while (paramArrayOfByte.length != paramInt);
      localObject = new byte[8];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, 8);
      l = getLongFromByte((byte[])localObject);
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, 8, localObject, 0, 4);
      paramInt = getIntFromByte((byte[])localObject);
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, 12, localObject, 0, 4);
      i = getIntFromByte((byte[])localObject);
      paramArrayOfByte = new AVUserInfo();
      paramArrayOfByte.jdField_a_of_type_Long = l;
      paramArrayOfByte.jdField_a_of_type_Int = paramInt;
      paramArrayOfByte.jdField_b_of_type_Int = i;
      localObject = paramArrayOfByte;
    } while (!QLog.isColorLevel());
    QLog.d("QQGAudioCtrl", 2, "AVUserInfo-->Uin = " + l + " ,isPstn = " + paramInt + " ,pstnState = " + i);
    return paramArrayOfByte;
  }
  
  public String getAppId()
  {
    try
    {
      int i = this.appid;
      return String.valueOf(i);
    }
    catch (Exception localException) {}
    return "";
  }
  
  public String getDeviceName()
  {
    return VcSystemInfo.a();
  }
  
  public native int getEncodeFrameFunctionPtrFunPtr();
  
  public native long getEnterRoomTime();
  
  public int getInviteStrategy(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "getInviteStrategy --> QQAccountNum = " + paramInt1 + " , PhoneNum = " + paramInt2);
    }
    return GetInviteStrategy(paramArrayOfLong, paramInt1, paramArrayOfString, paramInt2);
  }
  
  public long getLongFromByte(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l |= (paramArrayOfByte[(7 - i)] & 0xFF) << (7 - i) * 8;
      i += 1;
    }
    return l;
  }
  
  public native int getNetLevel();
  
  public native int getNetState();
  
  public native long getNetTrafficSize(long paramLong);
  
  public String getRELEASEVERSION()
  {
    return Build.VERSION.RELEASE;
  }
  
  public native long getRoomId();
  
  public native int getVideoAbilityLevel();
  
  public native int getVolume();
  
  public native int ignore(int paramInt1, long paramLong, int paramInt2);
  
  public native void init(Context paramContext, long paramLong, int paramInt);
  
  @SuppressLint({"NewApi"})
  public void init_deviceinfos(Context paramContext, int paramInt)
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
    paramContext = paramContext.getApplicationInfo();
    str = str + "DATADIR=" + paramContext.dataDir + ";";
    if (Build.VERSION.SDK_INT >= 9)
    {
      paramContext = str + "LIBDIR=" + paramContext.nativeLibraryDir + ";";
      if (paramInt <= 0) {
        break label875;
      }
      if ((paramInt & 0x1) != 1) {
        break label779;
      }
      paramContext = paramContext + "HWAVCDEC=1;";
      label592:
      if ((paramInt & 0x2) != 2) {
        break label803;
      }
      paramContext = paramContext + "HWAVCENC=1;";
      label620:
      if ((paramInt & 0x4) != 4) {
        break label827;
      }
      paramContext = paramContext + "HWHEVCDEC=1;";
      label648:
      if ((paramInt & 0x8) != 8) {
        break label851;
      }
      paramContext = paramContext + "HWHEVCENC=1;";
      label678:
      if (VcSystemInfo.b()) {
        break label962;
      }
      paramContext = paramContext + "SHARP_VIDEO=0;";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "init_deviceinfos --> PhoneInfo = " + paramContext);
      }
      setandroidapppath(paramContext);
      return;
      paramContext = str + "LIBDIR=" + paramContext.dataDir + "/lib;";
      break;
      label779:
      paramContext = paramContext + "HWAVCDEC=0;";
      break label592;
      label803:
      paramContext = paramContext + "HWAVCENC=0;";
      break label620;
      label827:
      paramContext = paramContext + "HWHEVCDEC=0;";
      break label648;
      label851:
      paramContext = paramContext + "HWHEVCENC=0;";
      break label678;
      label875:
      paramContext = paramContext + "HWAVCENC=0;";
      paramContext = paramContext + "HWAVCDEC=0;";
      paramContext = paramContext + "HWHEVCENC=0;";
      paramContext = paramContext + "HWHEVCDEC=0;";
      break label678;
      label962:
      if (VcSystemInfo.f() > 2) {
        paramContext = paramContext + "SHARP_VIDEO=1;";
      } else {
        paramContext = paramContext + "SHARP_VIDEO=2;";
      }
    }
  }
  
  public native int invite(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3);
  
  public int inviteUser(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArrayOfLong != null)
    {
      int j = paramArrayOfLong.length;
      String str1 = "uinList";
      i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= j) {
          break;
        }
        long l = paramArrayOfLong[i];
        str1 = str1 + "[" + l + "]";
        i += 1;
      }
    }
    String str2 = "[null]";
    int i = invite(paramArrayOfLong, paramInt1, paramInt2, paramInt3);
    QLog.w("QQGAudioCtrl", 1, "inviteUser, " + str2 + ", nReason[" + paramInt1 + "], original[" + paramInt2 + "], pstnLevel[" + paramInt3 + "], ret[" + i + "]");
    return i;
  }
  
  public int inviteUser(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    int j;
    int i;
    if (paramArrayOfLong != null)
    {
      j = paramArrayOfLong.length;
      str1 = "uinList";
      i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= j) {
          break;
        }
        long l = paramArrayOfLong[i];
        str1 = str1 + "[" + l + "]";
        i += 1;
      }
    }
    String str2 = "uinList" + "[null]";
    String str1 = str2 + ", phoneList";
    if (paramArrayOfString != null)
    {
      j = paramArrayOfString.length;
      i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= j) {
          break;
        }
        str2 = paramArrayOfString[i];
        str1 = str1 + "[" + str2 + "]";
        i += 1;
      }
    }
    str2 = str1 + "[null]";
    paramInt1 = Invite(paramArrayOfLong, paramInt1, paramArrayOfString, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4);
    QLog.w("QQGAudioCtrl", 1, "inviteUser2, " + str2 + ", nReason[" + paramInt4 + "], roomFlag[" + paramInt3 + "], transSelf[" + paramBoolean2 + "], pstnLevel[" + this.pstnLevel + "], ret[" + paramInt1 + "]");
    return paramInt1;
  }
  
  public native boolean isEnableLoopback();
  
  public void lockVideoMaxQP(int paramInt, String paramString)
  {
    QLog.e("QQGAudioCtrl", 1, "LockVideoMaxQP nNewQP=" + paramInt + " , strDesc= " + paramString);
    LockVideoMaxQP(paramInt);
  }
  
  public native int modifyGroupAdmin(long paramLong, boolean paramBoolean);
  
  public int nativeStopAudioSend(boolean paramBoolean)
  {
    try
    {
      int i = stopAudioSend(paramBoolean);
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      AVLog.e("QQGAudioCtrl", localUnsatisfiedLinkError.getMessage());
    }
    return -1;
  }
  
  public int nativeStopVideoSend()
  {
    try
    {
      int i = stopVideoSend();
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      AVLog.e("QQGAudioCtrl", localUnsatisfiedLinkError.getMessage());
    }
    return -1;
  }
  
  public int nativeUpdateRoomInfo(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      paramInt1 = updateRoomInfo(paramInt1, paramLong, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3);
      return paramInt1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      AVLog.e("QQGAudioCtrl", localUnsatisfiedLinkError.getMessage());
    }
    return -1;
  }
  
  public void onGAudioNativeEvent(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5, long paramLong2)
  {
    if (this.mEventHandler != null)
    {
      localjjf = new jjf(this);
      localjjf.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      localjjf.jdField_a_of_type_Long = paramLong2;
      localjjf.jdField_b_of_type_Long = paramLong1;
      localjjf.c = paramInt2;
      localjjf.jdField_a_of_type_Int = paramInt3;
      localjjf.jdField_b_of_type_Int = paramInt4;
      if (paramArrayOfByte == null)
      {
        paramInt2 = 0;
        localjjf.d = paramInt2;
        paramArrayOfByte = this.mEventHandler.obtainMessage();
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.what = paramInt1;
          paramArrayOfByte.obj = localjjf;
          this.mEventHandler.sendMessage(paramArrayOfByte);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        jjf localjjf;
        return;
        paramInt2 = paramArrayOfByte.length;
      }
    }
    QLog.d("QQGAudioCtrl", 2, "mEventHandler == null");
  }
  
  public int onNativeRecvGAudioCMD(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      paramInt = onRecvGAudioCMD(paramInt, paramArrayOfByte);
      return paramInt;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      AVLog.e("QQGAudioCtrl", paramArrayOfByte.getMessage());
    }
    return -1;
  }
  
  public void onRecvDoubleVideoMeeting(int paramInt1, int paramInt2, long paramLong)
  {
    if (this.mVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "onRecvDoubleVideoMeeting-->mVideoController is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "onRecvDoubleVideoMeeting-->eventId=" + paramInt1 + " ,relationType=" + paramInt2 + " ,inviteUin=" + paramLong);
      }
      if (paramInt1 == 6)
      {
        this.mVideoController.b(paramLong);
        return;
      }
    } while ((paramInt1 == 44) || (paramInt1 != 5));
  }
  
  public void onRecvUserList(int paramInt1, int paramInt2, long paramLong1, ArrayList paramArrayList, long paramLong2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.mVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "onRecvUserList --> mVideoController is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "onRecvUserList-->EvtId =" + paramInt1 + " ,relationType = " + paramInt2 + " ,relationId = " + paramLong1 + " ,inviteUin = " + paramLong2 + " ,multiSubType = " + paramInt3 + " ,inviteUinSize = " + paramArrayList.size());
      }
      if (paramInt1 == 44)
      {
        this.mVideoController.a(paramLong1, paramArrayList, paramInt4, paramInt5);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQGAudioCtrl", 2, "onRecvUserList --> WRONG EVTID. evtId = " + paramInt1);
  }
  
  public void onRecvUserList(int paramInt1, int paramInt2, long paramLong1, long[] paramArrayOfLong, long paramLong2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.mVideoController == null) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioCtrl", 2, "onRecvUserList-->mVideoController is null");
      }
    }
    do
    {
      do
      {
        return;
        if ((paramArrayOfLong != null) || (paramInt2 != 2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("QQGAudioCtrl", 2, "onRecvUserList-->userList is null");
      return;
      int i = 0;
      if (paramArrayOfLong != null) {
        i = paramArrayOfLong.length;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "onRecvUserList-->EvtId=" + paramInt1 + " relationType" + paramInt2 + " relationId" + paramLong1 + " inviteUin=" + paramLong2 + " multiAVType=" + paramInt3 + " multiSubType=" + paramInt4 + " inviteUinSize=" + i);
      }
      if (paramInt1 == 44)
      {
        this.mVideoController.a(paramLong1, paramArrayOfLong, paramInt3, paramInt5);
        return;
      }
      if (paramInt1 == 6)
      {
        this.mVideoController.a(paramInt2, paramLong1, paramLong2, paramArrayOfLong, false, paramInt3, paramInt4);
        return;
      }
    } while (paramInt1 != 5);
    this.mVideoController.a(paramInt2, paramLong1, paramLong2, paramArrayOfLong, true, paramInt3, paramInt4);
  }
  
  public native int quit(int paramInt);
  
  public native int registerTRAE(int paramInt);
  
  public native int request(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native int requestCamera(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  public native int sendAudioData(byte[] paramArrayOfByte, int paramInt);
  
  public void sendGAudioCMD(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.mVideoController.a(paramLong1, paramLong2, paramArrayOfByte);
  }
  
  public native void sendTransferMsg(long[] paramArrayOfLong, byte[] paramArrayOfByte);
  
  public native int setApType(int paramInt);
  
  public void setAppid(int paramInt)
  {
    this.appid = paramInt;
  }
  
  public native boolean setAudioNoiseCtrlParam(int paramInt1, int paramInt2, int paramInt3);
  
  public native int setAudioOutputMode(int paramInt);
  
  public native int setHowlingDetectEnable(boolean paramBoolean);
  
  public void setInviteUserList(long paramLong, long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      if (this.mInviteGAudioUinList.size() > 0) {
        this.mInviteGAudioUinList.clear();
      }
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfLong[i] != paramLong) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[i]));
        }
        i += 1;
      }
    }
  }
  
  public native boolean setMicByAdmin(long paramLong, boolean paramBoolean);
  
  public native boolean setMicMode(int paramInt);
  
  public native int setNetIPAndPort(String paramString, int paramInt);
  
  public native void setProcessDecoderFrameFunctionptr(int paramInt);
  
  public void setPstnInviteInfo(int paramInt1, int paramInt2)
  {
    this.pstnOriginal = paramInt1;
    this.pstnLevel = paramInt2;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "setPstnInviteInfo --> Original = " + paramInt1 + " , pstnLevel = " + paramInt2);
    }
  }
  
  public native void setVideoJitterLength(int paramInt);
  
  public native int setVoiceType(int paramInt);
  
  public native int startAudioRecv();
  
  public int startAudioSend()
  {
    return startAudioSend(false);
  }
  
  public native int startAudioSend(boolean paramBoolean);
  
  public int startGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long[] paramArrayOfLong, int paramInt4, long paramLong2, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    if (paramInt1 == 2)
    {
      if (paramArrayOfLong == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioCtrl", 2, "startGAudio uinList == null");
        }
        return -1;
      }
      if (this.mInviteGAudioUinList.size() > 0) {
        this.mInviteGAudioUinList.clear();
      }
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfLong[i] != paramLong2) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[i]));
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("QQGAudioCtrl", 1, "startGAudio, emAVRelationType[" + paramInt1 + "], groupId[" + paramLong1 + "], emMultiAVType[" + paramInt2 + "], emMultiAVSubType[" + paramInt3 + "], isSwitchGroup[" + paramBoolean + "], apnType[" + paramInt4 + "], nConfigID[" + paramInt6 + "], llConfAppid[" + paramInt5 + "]");
    }
    try
    {
      paramInt1 = request(paramInt1, paramLong1, paramInt2, paramInt3, paramInt5, paramInt6);
      try
      {
        this.mGroupId = paramLong1;
        this.mIsSwitchGroup = paramBoolean;
        return paramInt1;
      }
      catch (UnsatisfiedLinkError paramArrayOfLong) {}
    }
    catch (UnsatisfiedLinkError paramArrayOfLong)
    {
      for (;;)
      {
        paramInt1 = -1;
      }
    }
    AVLog.e("QQGAudioCtrl", paramArrayOfLong.getMessage());
    return paramInt1;
  }
  
  public int startVideoRecv(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return 0;
    }
    int j = paramArrayList.size() * 3;
    long[] arrayOfLong = new long[j];
    String str = new String();
    int i = 0;
    if (i < paramArrayList.size())
    {
      arrayOfLong[(i * 3)] = ((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Long;
      str = str + "uin=" + arrayOfLong[(i * 3)] + " ,";
      arrayOfLong[(i * 3 + 1)] = ((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Int;
      str = str + "videoSrcType=" + arrayOfLong[(i * 3 + 1)] + " ,";
      if (((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Boolean) {
        arrayOfLong[(i * 3 + 2)] = 1L;
      }
      for (;;)
      {
        str = str + "isBig=" + arrayOfLong[(i * 3 + 2)] + " ,";
        i += 1;
        break;
        arrayOfLong[(i * 3 + 2)] = 0L;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "startVideoRecv-->info=" + str);
    }
    return startVideoRecv(arrayOfLong, j);
  }
  
  public native int startVideoRecv(long[] paramArrayOfLong, int paramInt);
  
  public native int startVideoSend();
  
  public native int stopAudioRecv();
  
  public native int stopVideoRecv();
  
  public native int switchToAudioMode();
  
  public native void uninit();
  
  public native int unregisterTRAE(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.gaudio.QQGAudioCtrl
 * JD-Core Version:    0.7.0.1
 */
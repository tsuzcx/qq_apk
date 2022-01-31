package com.tencent.av.gaudio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.config.Common;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import krx;
import kvq;
import lbk;
import ldd;
import ldw;
import ldx;
import ldy;
import ldz;
import leb;
import lef;
import mhr;
import tencent.im.groupvideo.memposinfo.memposinfo.AccountExtInfo;
import tencent.im.groupvideo.memposinfo.memposinfo.AccountExtInfoList;
import tencent.im.groupvideo.memposinfo.memposinfo.CommonInfo;

public class QQGAudioCtrl
{
  static final int EM_SDK_EVENT_ID_ALL_CAN_GO_ON_STAGE = 103;
  static final int EM_SDK_EVENT_ID_ALL_MEM_UPDATE = 44;
  static final int EM_SDK_EVENT_ID_ALL_ONLINE_NOTICE = 16;
  static final int EM_SDK_EVENT_ID_AUDIO_PLAYBACK_FAILURE = 175;
  static final int EM_SDK_EVENT_ID_AUDIO_RECORD_FAILURE = 174;
  static final int EM_SDK_EVENT_ID_AUTHORITY_CHANGED = 173;
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
  public static final int EM_SDK_EVENT_ID_KickOut_FAIL = 22;
  public static final int EM_SDK_EVENT_ID_KickOut_SUC = 21;
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
  static final int EM_SDK_EVENT_ID_PLAY_MEDIA_FILE = 105;
  static final int EM_SDK_EVENT_ID_PPT_UPLOAD_STATE = 110;
  static final int EM_SDK_EVENT_ID_PROTOCOL_ERR = 7;
  static final int EM_SDK_EVENT_ID_PSTN_BILL = 19;
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
  static final int EM_SDK_EVENT_ID_VIDEOCHANNEL_CTRL_CHANGE = 172;
  static final int EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA = 61;
  static final int EV_GA_SDK_DETECT_AUDIO_DATA_LESS = 122;
  static final int EV_GA_SDK_DETECT_AUDIO_DATA_NULL = 121;
  private static String SPDEFVALUE = "preview-size-values=320x240,640x480;";
  private static String SPKEY;
  private static String SPNAME;
  static final String TAG = "QQGAudioCtrl";
  private static String mCameraParameters;
  public static ldw mEventCountLog_EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA = new ldw(String.valueOf(61), 10000L);
  static QQGAudioCtrl sQQGAudioCtrl;
  private int appid;
  ldx mEventHandler = null;
  long mGroupId = 0L;
  public Vector<Long> mInviteGAudioUinList = new Vector();
  public boolean mIsSwitchGroup;
  private lbk mSysInfo;
  public ldz mVideoController = null;
  
  static
  {
    SPNAME = "AV_CameraParameters";
    SPKEY = "CP";
  }
  
  protected QQGAudioCtrl()
  {
    regCallbacks();
    int i = lef.a("QQGAudioCtrl", BaseApplicationImpl.getContext());
    init_deviceinfos(BaseApplicationImpl.getContext(), i);
    Looper localLooper;
    if (this.mEventHandler == null)
    {
      localLooper = Looper.getMainLooper();
      if (localLooper == null) {
        break label90;
      }
      this.mEventHandler = new ldx(this, localLooper);
    }
    for (;;)
    {
      this.mSysInfo = new lbk();
      return;
      label90:
      localLooper = Looper.myLooper();
      if (localLooper != null) {
        this.mEventHandler = new ldx(this, localLooper);
      } else {
        this.mEventHandler = null;
      }
    }
  }
  
  private native int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private native int commonRequest(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString, int paramInt7, byte[] paramArrayOfByte);
  
  private ArrayList<ldd> getAVInfoListFromByte(byte[] paramArrayOfByte, int paramInt)
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
    if ((((ldd)localObject).jdField_a_of_type_Int == 1) && (((ldd)localObject).jdField_b_of_type_Int != 3)) {}
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
  
  private ArrayList<ldd> getAVInfoListFromByte2(byte[] paramArrayOfByte, int paramInt)
  {
    Iterator localIterator = null;
    Object localObject4 = null;
    memposinfo.CommonInfo localCommonInfo = null;
    Object localObject2 = localObject4;
    Object localObject1;
    if (paramArrayOfByte != null)
    {
      localObject1 = localIterator;
      localObject2 = localObject4;
      try
      {
        if (paramArrayOfByte.length != paramInt) {
          break label214;
        }
        localObject1 = localIterator;
        localObject2 = new memposinfo.AccountExtInfoList();
        localObject1 = localIterator;
        ((memposinfo.AccountExtInfoList)localObject2).mergeFrom(paramArrayOfByte);
        localObject1 = localIterator;
        localIterator = ((memposinfo.AccountExtInfoList)localObject2).msg_account_ext_info.get().iterator();
        paramArrayOfByte = localCommonInfo;
      }
      catch (Exception localException1)
      {
        try
        {
          paramArrayOfByte.add(localObject2);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localObject1 = paramArrayOfByte;
          }
        }
        localException1 = localException1;
      }
      localObject1 = paramArrayOfByte;
      localObject2 = paramArrayOfByte;
      if (localIterator.hasNext())
      {
        localObject1 = paramArrayOfByte;
        localObject2 = (memposinfo.AccountExtInfo)localIterator.next();
        localObject1 = paramArrayOfByte;
        if (!((memposinfo.AccountExtInfo)localObject2).msg_common_info.has()) {
          break label227;
        }
        localObject1 = paramArrayOfByte;
        localCommonInfo = (memposinfo.CommonInfo)((memposinfo.AccountExtInfo)localObject2).msg_common_info.get();
        localObject1 = paramArrayOfByte;
        localObject2 = new ldd();
        localObject1 = paramArrayOfByte;
        ((ldd)localObject2).jdField_a_of_type_Long = localCommonInfo.uint64_account.get();
        localObject1 = paramArrayOfByte;
        ((ldd)localObject2).jdField_a_of_type_JavaLangString = localCommonInfo.bytes_account.get().toStringUtf8();
        if (paramArrayOfByte != null) {
          break label224;
        }
        localObject1 = paramArrayOfByte;
        paramArrayOfByte = new ArrayList();
      }
    }
    label214:
    label224:
    label227:
    for (;;)
    {
      QLog.e("QQGAudioCtrl", 1, "getAVInfoListFromByte2 fail.", localException1);
      Object localObject3 = localObject1;
      return localObject3;
    }
  }
  
  private ArrayList<AVPhoneUserInfo> getAvPhoneUserInfoFromString(String paramString)
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
  
  private Object[] getRoomParams(kvq paramkvq)
  {
    int i = 8;
    if (paramkvq == null) {
      return null;
    }
    long l1;
    int j;
    if (paramkvq.I)
    {
      l1 = Long.parseLong(paramkvq.d);
      j = 3;
    }
    for (;;)
    {
      return new Object[] { Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(i) };
      int k = paramkvq.C;
      long l2 = paramkvq.g;
      if (k == 2)
      {
        i = 1;
        j = k;
        l1 = l2;
      }
      else if (k == 1)
      {
        i = paramkvq.A;
        j = k;
        l1 = l2;
      }
      else
      {
        j = k;
        l1 = l2;
        if (k != 3)
        {
          i = 0;
          j = k;
          l1 = l2;
        }
      }
    }
  }
  
  private native int getRoomUserClientVersion(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
  
  private native int getRoomUserTerminalType(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
  
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
        QLog.e("QQGAudioCtrl", 1, "getUinListFromBuf-->get the wrong uin==0");
        return arrayOfLong2;
      }
      arrayOfLong2[(j / 8)] = l;
      j += 8;
      i -= 8;
    }
  }
  
  protected static boolean loadGAEngine()
  {
    try
    {
      UpdateAvSo.a(-1047L, BaseApplicationImpl.getContext(), "qav_gaudio_engine", true);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGAudioCtrl", 1, "loadGAEngine fail.", localThrowable);
    }
    return false;
  }
  
  private native int onRecvGAudioCMD(int paramInt, byte[] paramArrayOfByte);
  
  /* Error */
  private String queryCameraParameters()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 521	com/tencent/av/gaudio/QQGAudioCtrl:mCameraParameters	Ljava/lang/String;
    //   5: ifnull +11 -> 16
    //   8: getstatic 521	com/tencent/av/gaudio/QQGAudioCtrl:mCameraParameters	Ljava/lang/String;
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: getstatic 239	com/tencent/av/gaudio/QQGAudioCtrl:SPDEFVALUE	Ljava/lang/String;
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
  
  protected static native void regCallbacks();
  
  private native int request(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
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
  
  protected static native void setandroidapppath(String paramString);
  
  private native int stopVideoSend();
  
  private native int updateRoomInfo(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  private native int updateRoomUserTerminalInfo(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, int paramInt4);
  
  public byte[] GetConfigInfoFromFile()
  {
    return Common.a(BaseApplicationImpl.getContext(), "VideoConfigInfo");
  }
  
  native int GetInviteStrategy(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  public native int GetOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public String GetSharpConfigPayloadFromFile()
  {
    Object localObject1 = Common.a(BaseApplicationImpl.getContext(), Common.b);
    if (localObject1 != null)
    {
      String str2 = new String((byte[])localObject1);
      int i = str2.indexOf('|');
      Object localObject2 = "";
      String str1 = "";
      try
      {
        localObject1 = str2.substring(0, i);
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            localObject2 = str2.substring(i + 1);
            if (QLog.isColorLevel()) {
              QLog.d("QQGAudioCtrl", 2, "GetSharpConfigPayloadFromFile multi version: " + (String)localObject1 + ". payload: " + (String)localObject2);
            }
            return localObject2;
            localException2 = localException2;
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("QQGAudioCtrl", 2, "GetSharpConfigPayloadFromFile version e = " + localException2);
              localObject1 = localObject2;
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localObject2 = str1;
            if (QLog.isColorLevel())
            {
              QLog.d("QQGAudioCtrl", 2, "GetSharpConfigPayloadFromFile payload e = " + localException1);
              localObject2 = str1;
            }
          }
        }
      }
    }
    return "";
  }
  
  public int GetSharpConfigVersionFromFile()
  {
    try
    {
      Object localObject = Common.a(BaseApplicationImpl.getContext(), Common.b);
      if (localObject != null)
      {
        String str = new String((byte[])localObject);
        if (!TextUtils.isEmpty(str))
        {
          int i = str.indexOf('|');
          localObject = str.substring(0, i);
          str = str.substring(i + 1);
          if (QLog.isColorLevel()) {
            QLog.d("", 2, "GetSharpConfigPayloadFromFile multi version: " + (String)localObject + ". payload: " + str);
          }
          return Integer.parseInt((String)localObject);
        }
        QLog.w("QQGAudioCtrl", 1, "GetSharpConfigVersionFromFile, payloadBufTmp[" + str + "]");
        return 0;
      }
    }
    catch (Exception localException)
    {
      QLog.w("QQGAudioCtrl", 1, "GetSharpConfigVersionFromFile, Exception", localException);
    }
    return 0;
  }
  
  public native int Invite(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4);
  
  @Deprecated
  public native int InvitePstn(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2);
  
  public native int KickOutPstnUsers();
  
  public native void LockVideoMaxQP(int paramInt);
  
  public native int ReadDataFromTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native void SetAudioDataSendByDefault(boolean paramBoolean);
  
  public native void SetAudioDataSink(boolean paramBoolean);
  
  public native int SetOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public void SetVideoController(ldz paramldz)
  {
    this.mVideoController = paramldz;
  }
  
  public native void SetVideoDataSendByDefault(boolean paramBoolean);
  
  public native void SetVideoDataSink(boolean paramBoolean);
  
  public native int WriteDataToTRAE(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = mhr.a();
    if (i > 0) {}
    for (;;)
    {
      QLog.w("QQGAudioCtrl", 1, "accept, maxShowVideo[" + i + "]");
      return accept(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, i);
      i = 5;
    }
  }
  
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
    paramInt4 = mhr.a();
    if (paramInt4 > 0) {}
    for (;;)
    {
      QLog.w("QQGAudioCtrl", 1, "acceptGAudio, emAVRelationType[" + paramInt1 + "], emMultiAVType[" + paramInt2 + "], emMultiAVSubType[" + paramInt3 + "], nConfID[" + paramInt5 + "], groupId[" + paramLong1 + "], maxShowVideo[" + paramInt4 + "]");
      accept(paramInt1, paramLong1, paramInt2, paramInt3, paramInt5, paramInt4);
      return 0;
      paramInt4 = 5;
    }
  }
  
  public native boolean enableLoopback(boolean paramBoolean);
  
  public native String getAVGQuality();
  
  public ldd getAVInfoFromByte(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if ((paramArrayOfByte.length != paramInt) || (paramArrayOfByte.length < 16)) {
      return null;
    }
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 8);
    long l = getLongFromByte(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 8, arrayOfByte, 0, 4);
    int i = getIntFromByte(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 12, arrayOfByte, 0, 4);
    int j = getIntFromByte(arrayOfByte);
    paramInt = 2;
    if (paramArrayOfByte.length > 16)
    {
      arrayOfByte = new byte[1];
      System.arraycopy(paramArrayOfByte, 16, arrayOfByte, 0, 1);
      paramInt = arrayOfByte[0];
    }
    for (;;)
    {
      paramArrayOfByte = new ldd();
      paramArrayOfByte.jdField_a_of_type_Long = l;
      paramArrayOfByte.jdField_a_of_type_Int = i;
      paramArrayOfByte.jdField_b_of_type_Int = j;
      paramArrayOfByte.c = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "AVUserInfo-->Uin = " + l + " ,isPstn = " + i + " ,pstnState = " + j + " ,micOffByAdmin = " + paramInt);
      }
      return paramArrayOfByte;
      QLog.w("QQGAudioCtrl", 1, "getAVInfoFromByte", new Throwable("打印调用栈"));
    }
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
    return lbk.b();
  }
  
  public native int getEncodeFrameFunctionPtrFunPtr();
  
  public native long getEnterRoomTime();
  
  @Deprecated
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
  
  public int getOsType()
  {
    if (this.mSysInfo != null)
    {
      int j = this.mSysInfo.d();
      int i = j;
      if (j == 200)
      {
        if ((Build.VERSION.SDK_INT < 21) || (Build.VERSION.SDK_INT > 22)) {
          break label45;
        }
        i = 118;
      }
      label45:
      do
      {
        return i;
        if (Build.VERSION.SDK_INT == 23) {
          return 119;
        }
        if ((Build.VERSION.SDK_INT == 24) || (Build.VERSION.SDK_INT == 25)) {
          return 120;
        }
        if ((Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27)) {
          return 121;
        }
        i = j;
      } while (Build.VERSION.SDK_INT != 28);
      return 122;
    }
    return 0;
  }
  
  public String getRELEASEVERSION()
  {
    return Build.VERSION.RELEASE;
  }
  
  public native long getRoomId();
  
  public int getRoomUserSdkVersion(kvq paramkvq, String paramString)
  {
    try
    {
      l1 = Long.parseLong(paramString);
      paramkvq = getRoomParams(paramkvq);
      if ((paramkvq == null) || (l1 == 0L))
      {
        i = -1;
        return i;
      }
    }
    catch (Throwable paramString)
    {
      long l1;
      int k;
      long l2;
      int m;
      int j;
      do
      {
        for (;;)
        {
          l1 = 0L;
        }
        k = ((Integer)paramkvq[0]).intValue();
        l2 = ((Long)paramkvq[1]).longValue();
        m = ((Integer)paramkvq[2]).intValue();
        j = getRoomUserClientVersion(k, l2, m, l1);
        int i = j;
      } while (!QLog.isColorLevel());
      QLog.i("QQGAudioCtrl", 2, String.format("getRoomUserSdkVersion [%s, %s, %s, %s, %s]", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(j) }));
      return j;
    }
  }
  
  public int getRoomUserTerminalType(kvq paramkvq, String paramString)
  {
    try
    {
      l1 = Long.parseLong(paramString);
      paramkvq = getRoomParams(paramkvq);
      if ((paramkvq == null) || (l1 == 0L))
      {
        i = -1;
        return i;
      }
    }
    catch (Throwable paramString)
    {
      long l1;
      int k;
      long l2;
      int m;
      int j;
      do
      {
        for (;;)
        {
          l1 = 0L;
        }
        k = ((Integer)paramkvq[0]).intValue();
        l2 = ((Long)paramkvq[1]).longValue();
        m = ((Integer)paramkvq[2]).intValue();
        j = getRoomUserTerminalType(k, l2, m, l1);
        int i = j;
      } while (!QLog.isColorLevel());
      QLog.i("QQGAudioCtrl", 2, String.format("getRoomUserTerminalType [%s, %s, %s, %s, %s]", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(j) }));
      return j;
    }
  }
  
  public native int getVideoAbilityLevel();
  
  public native int getVolume();
  
  public native int ignore(int paramInt1, long paramLong, int paramInt2);
  
  public void init(Context paramContext, long paramLong, int paramInt)
  {
    init(paramContext, paramLong, paramInt, "8.2.6");
  }
  
  public native void init(Context paramContext, long paramLong, int paramInt, String paramString);
  
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
        break label876;
      }
      if ((paramInt & 0x1) != 1) {
        break label780;
      }
      paramContext = paramContext + "HWAVCDEC=1;";
      label592:
      if ((paramInt & 0x2) != 2) {
        break label804;
      }
      paramContext = paramContext + "HWAVCENC=1;";
      label620:
      if ((paramInt & 0x4) != 4) {
        break label828;
      }
      paramContext = paramContext + "HWHEVCDEC=1;";
      label648:
      if ((paramInt & 0x8) != 8) {
        break label852;
      }
      paramContext = paramContext + "HWHEVCENC=1;";
      label678:
      if (lbk.f() <= 2) {
        break label963;
      }
    }
    label780:
    label804:
    label828:
    label963:
    for (paramContext = paramContext + "SHARP_VIDEO=1;";; paramContext = paramContext + "SHARP_VIDEO=2;")
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "init_deviceinfos --> PhoneInfo = " + paramContext);
      }
      setandroidapppath(paramContext);
      return;
      paramContext = str + "LIBDIR=" + paramContext.dataDir + "/lib;";
      break;
      paramContext = paramContext + "HWAVCDEC=0;";
      break label592;
      paramContext = paramContext + "HWAVCENC=0;";
      break label620;
      paramContext = paramContext + "HWHEVCDEC=0;";
      break label648;
      label852:
      paramContext = paramContext + "HWHEVCENC=0;";
      break label678;
      label876:
      paramContext = paramContext + "HWAVCENC=0;";
      paramContext = paramContext + "HWAVCDEC=0;";
      paramContext = paramContext + "HWHEVCENC=0;";
      paramContext = paramContext + "HWHEVCDEC=0;";
      break label678;
    }
  }
  
  public native int invite(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3);
  
  public int inviteUser(long[] paramArrayOfLong, int paramInt)
  {
    String str1 = "uinList";
    if (paramArrayOfLong != null)
    {
      int j = paramArrayOfLong.length;
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
    int i = invite(paramArrayOfLong, paramInt, 0, 0);
    QLog.w("QQGAudioCtrl", 1, "inviteUser, " + str2 + ", nReason[" + paramInt + "], ret[" + i + "]");
    return i;
  }
  
  public int inviteUser(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3)
  {
    return invite(paramArrayOfLong, paramInt1, paramInt2, paramInt3);
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
    QLog.w("QQGAudioCtrl", 1, "inviteUser2, " + str2 + ", nReason[" + paramInt4 + "], roomFlag[" + paramInt3 + "], transSelf[" + paramBoolean2 + "], ret[" + paramInt1 + "]");
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
      krx.e("QQGAudioCtrl", localUnsatisfiedLinkError.getMessage());
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
      krx.e("QQGAudioCtrl", localUnsatisfiedLinkError.getMessage());
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
      krx.e("QQGAudioCtrl", localUnsatisfiedLinkError.getMessage());
    }
    return -1;
  }
  
  public void onGAudioNativeEvent(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, byte[] paramArrayOfByte, int paramInt5, long paramLong2)
  {
    if (this.mEventHandler != null)
    {
      localldy = new ldy(this);
      localldy.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      localldy.jdField_a_of_type_Long = paramLong2;
      localldy.jdField_b_of_type_Long = paramLong1;
      localldy.c = paramInt2;
      localldy.jdField_a_of_type_Int = paramInt3;
      localldy.jdField_b_of_type_Int = paramInt4;
      if (paramArrayOfByte == null)
      {
        paramInt2 = 0;
        localldy.d = paramInt2;
        paramArrayOfByte = this.mEventHandler.obtainMessage();
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.what = paramInt1;
          paramArrayOfByte.obj = localldy;
          this.mEventHandler.sendMessage(paramArrayOfByte);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        ldy localldy;
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
      krx.e("QQGAudioCtrl", paramArrayOfByte.getMessage());
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
        this.mVideoController.d(paramLong);
        return;
      }
    } while ((paramInt1 == 44) || (paramInt1 != 5));
  }
  
  public void onRecvUserList(int paramInt1, int paramInt2, long paramLong1, ArrayList<ldd> paramArrayList, long paramLong2, int paramInt3, int paramInt4, int paramInt5)
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
        QLog.w("QQGAudioCtrl", 1, "onRecvUserList.GET_ROOM_INFO, evtId[" + paramInt1 + "], relationType[" + paramInt2 + "], relationId[" + paramLong1 + "], inviteUin[" + paramLong2 + "], multiAVType[" + paramInt4 + "], multiSubType[" + paramInt3 + "], userCount[" + paramInt5 + "]");
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
    label194:
    label200:
    do
    {
      return;
      int i = 0;
      if (paramArrayOfLong != null) {
        i = paramArrayOfLong.length;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onRecvUserList, evtId[").append(paramInt1).append("], relationType[").append(paramInt2).append("], relationId[").append(paramLong1).append("], inviteUin[").append(paramLong2).append("], multiAVType[").append(paramInt3).append("], multiSubType[").append(paramInt4).append("], userListSize[").append(i).append("], userList[");
        if (paramArrayOfLong == null) {
          break label194;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        QLog.w("QQGAudioCtrl", 1, bool + "]");
        if ((paramArrayOfLong == null) && (paramInt2 == 2)) {
          break;
        }
        if (paramInt1 != 44) {
          break label200;
        }
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
  
  public void onRecvUserListFail(int paramInt, long paramLong1, long paramLong2)
  {
    QLog.w("QQGAudioCtrl", 1, "onRecvUserListFail, relationType[" + paramInt + "], relationId[" + paramLong1 + "], errCode[" + paramLong2 + "]");
    this.mVideoController.b(paramInt, paramLong1);
  }
  
  public native byte[] postData(long paramLong, byte[] paramArrayOfByte);
  
  public void processMicAuthAfterEnterRoom(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 8))
    {
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 4);
      if (getIntFromByte(arrayOfByte) != 1) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, 4, arrayOfByte, 0, 4);
      int i = getIntFromByte(arrayOfByte);
      this.mVideoController.a(0L, bool, true);
      this.mVideoController.a(0L, i);
      return;
    }
  }
  
  public native int quit(int paramInt);
  
  public native int registerTRAE(int paramInt);
  
  public int request(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = mhr.a();
    if (i > 0) {}
    for (;;)
    {
      QLog.w("QQGAudioCtrl", 1, "request, maxShowVideo[" + i + "]");
      return request(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt5, i);
      i = 5;
    }
  }
  
  public native int requestCamera(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
  
  public native int requestMemPosInfoList();
  
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
  
  public native void setVideoJitterLength(int paramInt);
  
  public native int setVoiceType(int paramInt);
  
  public native int startAudioRecv();
  
  public int startAudioSend()
  {
    return startAudioSend(false);
  }
  
  public native int startAudioSend(boolean paramBoolean);
  
  public int startCommonGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString, int paramInt4, byte[] paramArrayOfByte)
  {
    if ((paramInt1 != 11) || (paramInt2 != 14) || (paramInt3 != 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "startCommonGAudio type error!");
      }
      paramInt2 = -1;
      return paramInt2;
    }
    int i = mhr.a();
    label46:
    StringBuilder localStringBuilder;
    if (i > 0) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("startCommonGAudio emAVRelationType:").append(paramInt1).append(" emMultiAVType:").append(paramInt2).append(" emMultiAVSubType:").append(paramInt3).append(" roomId:").append(paramLong1).append(" selfUin:").append(paramLong2).append(" llAppid:").append(paramInt4).append(" nConfig:").append(0).append(" maxShowVideo:").append(i).append(" openId:").append(paramString).append(" sourceId:").append(paramInt4).append(" commonSig.length:");
        if (paramArrayOfByte == null) {
          break label277;
        }
      }
    }
    for (int j = paramArrayOfByte.length;; j = 0)
    {
      for (;;)
      {
        QLog.d("QQGAudioCtrl", 2, j);
        try
        {
          for (;;)
          {
            paramInt1 = commonRequest(paramInt1, paramLong1, paramInt2, paramInt3, paramInt4, 0, i, paramString, paramInt4, paramArrayOfByte);
            paramInt2 = paramInt1;
            try
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("QQGAudioCtrl", 2, "startCommonGAudio result:" + paramInt1);
              return paramInt1;
            }
            catch (Throwable paramString) {}
          }
        }
        catch (Throwable paramString)
        {
          for (;;)
          {
            label277:
            paramInt1 = -1;
          }
        }
      }
      QLog.e("QQGAudioCtrl", 1, "startCommonGAudio fail.", paramString);
      return paramInt1;
      i = 5;
      break label46;
    }
  }
  
  public int startGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long[] paramArrayOfLong, int paramInt4, long paramLong2, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    if (this.mInviteGAudioUinList.size() > 0) {
      this.mInviteGAudioUinList.clear();
    }
    if (paramArrayOfLong != null)
    {
      int j = paramArrayOfLong.length;
      i = 0;
      while (i < j)
      {
        if (paramArrayOfLong[i] != paramLong2) {
          this.mInviteGAudioUinList.add(Long.valueOf(paramArrayOfLong[i]));
        }
        i += 1;
      }
    }
    int i = mhr.a();
    if (i > 0) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQGAudioCtrl", 1, "startGAudio, emAVRelationType[" + paramInt1 + "], groupId[" + paramLong1 + "], emMultiAVType[" + paramInt2 + "], emMultiAVSubType[" + paramInt3 + "], isSwitchGroup[" + paramBoolean + "], apnType[" + paramInt4 + "], nConfigID[" + paramInt6 + "], llConfAppid[" + paramInt5 + "], maxShowVideo[" + i + "]");
      }
      try
      {
        paramInt1 = request(paramInt1, paramLong1, paramInt2, paramInt3, paramInt5, paramInt6, i);
      }
      catch (UnsatisfiedLinkError paramArrayOfLong)
      {
        paramInt1 = -1;
      }
      try
      {
        this.mGroupId = paramLong1;
        this.mIsSwitchGroup = paramBoolean;
        return paramInt1;
      }
      catch (UnsatisfiedLinkError paramArrayOfLong)
      {
        break;
      }
      i = 5;
    }
    krx.e("QQGAudioCtrl", paramArrayOfLong.getMessage());
    return paramInt1;
  }
  
  public int startVideoRecv(ArrayList<leb> paramArrayList)
  {
    return startVideoRecv(paramArrayList, false);
  }
  
  public int startVideoRecv(ArrayList<leb> paramArrayList, boolean paramBoolean)
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
      arrayOfLong[(i * 3)] = ((leb)paramArrayList.get(i)).jdField_a_of_type_Long;
      str = str + "uin=" + arrayOfLong[(i * 3)] + " ,";
      arrayOfLong[(i * 3 + 1)] = ((leb)paramArrayList.get(i)).jdField_a_of_type_Int;
      str = str + "videoSrcType=" + arrayOfLong[(i * 3 + 1)] + " ,";
      if (paramBoolean)
      {
        if (this.mVideoController == null) {
          return 0;
        }
        kvq localkvq = this.mVideoController.a();
        if (localkvq == null) {
          return 0;
        }
        if (localkvq.a(((leb)paramArrayList.get(i)).jdField_a_of_type_Long, i)) {
          arrayOfLong[(i * 3 + 2)] = 1L;
        }
      }
      for (;;)
      {
        str = str + "isBig=" + arrayOfLong[(i * 3 + 2)] + " ,";
        i += 1;
        break;
        arrayOfLong[(i * 3 + 2)] = 0L;
        continue;
        if (((leb)paramArrayList.get(i)).jdField_a_of_type_Boolean) {
          arrayOfLong[(i * 3 + 2)] = 1L;
        } else {
          arrayOfLong[(i * 3 + 2)] = 0L;
        }
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
  
  public native int stopAudioSend(boolean paramBoolean);
  
  public native int stopVideoRecv();
  
  public native int switchToAudioMode();
  
  public native void uninit();
  
  public native int unregisterTRAE(int paramInt);
  
  public void updateRoomUserTerminalInfo(kvq paramkvq, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      l1 = Long.parseLong(paramString);
      paramkvq = getRoomParams(paramkvq);
      if ((paramkvq == null) || (l1 == 0L)) {
        return;
      }
    }
    catch (Throwable paramString)
    {
      long l1;
      int i;
      long l2;
      int j;
      do
      {
        for (;;)
        {
          l1 = 0L;
        }
        i = ((Integer)paramkvq[0]).intValue();
        l2 = ((Long)paramkvq[1]).longValue();
        j = ((Integer)paramkvq[2]).intValue();
        updateRoomUserTerminalInfo(i, l2, j, l1, paramInt1, paramInt2);
      } while (!QLog.isColorLevel());
      QLog.i("QQGAudioCtrl", 2, String.format("updateRoomUserTerminalInfo [%s, %s, %s, %s, %s, %s]", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.gaudio.QQGAudioCtrl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.gaudio;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.QavEngineAssistant;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.core.AVSoProxyImpl;
import com.tencent.av.core.SDKConfigInfoBuilder;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.so.ResMgr;
import com.tencent.av.utils.AudioDump;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.avcore.config.Common;
import com.tencent.avcore.data.RecordParam;
import com.tencent.avcore.engine.mav.IMavAdapter;
import com.tencent.avcore.engine.mav.MavEventId;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avcore.jni.data.SDKConfigInfo;
import com.tencent.avcore.jni.mav.MavEngineProxy;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVNativeEventProcessor;
import com.tencent.avcore.util.MavJniUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import tencent.im.groupvideo.memposinfo.memposinfo.AccountExtInfo;
import tencent.im.groupvideo.memposinfo.memposinfo.AccountExtInfoList;
import tencent.im.groupvideo.memposinfo.memposinfo.CommonInfo;

public class QQGAudioCtrl
  extends MavEngineProxy
  implements IMavAdapter, MavEventId
{
  static final String TAG = "QQGAudioCtrl";
  static QQGAudioCtrl sQQGAudioCtrl = null;
  private AVNativeEventProcessor mEventCallback;
  protected long mGroupId = 0L;
  public Vector<Long> mInviteGAudioUinList = new Vector();
  public boolean mIsSwitchGroup = false;
  protected QQGAudioCtrlCallback mMavCallback = null;
  protected final VcSystemInfo mSysInfo;
  
  protected QQGAudioCtrl()
  {
    QavEngineAssistant.a();
    String str = SDKConfigInfo.getDeviceInfo(new AVSoProxyImpl(BaseApplicationImpl.getContext()));
    this.mSysInfo = new VcSystemInfo();
    initEngine(this.mSysInfo, this, str);
    if (AudioDump.a()) {
      AudioDump.a();
    }
  }
  
  public static ArrayList<AVUserInfo> getAVInfoListFromByte2(byte[] paramArrayOfByte, int paramInt)
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
          break label196;
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
          break label207;
        }
        localObject1 = paramArrayOfByte;
        localCommonInfo = (memposinfo.CommonInfo)((memposinfo.AccountExtInfo)localObject2).msg_common_info.get();
        localObject1 = paramArrayOfByte;
        localObject2 = new AVUserInfo();
        localObject1 = paramArrayOfByte;
        ((AVUserInfo)localObject2).account = localCommonInfo.uint64_account.get();
        localObject1 = paramArrayOfByte;
        ((AVUserInfo)localObject2).openId = localCommonInfo.bytes_account.get().toStringUtf8();
        if (paramArrayOfByte != null) {
          break label204;
        }
        localObject1 = paramArrayOfByte;
        paramArrayOfByte = new ArrayList();
      }
    }
    label196:
    label204:
    label207:
    for (;;)
    {
      AVCoreLog.e("QQGAudioCtrl", "getAVInfoListFromByte2 fail.", localException1);
      Object localObject3 = localObject1;
      return localObject3;
    }
  }
  
  public static QQGAudioCtrl getGAudioCtrlInstance()
  {
    if (sQQGAudioCtrl == null)
    {
      if (!loadGAEngine()) {
        return null;
      }
      sQQGAudioCtrl = new QQGAudioCtrl();
    }
    return sQQGAudioCtrl;
  }
  
  private Object[] getRoomParams(SessionInfo paramSessionInfo)
  {
    int i = 8;
    if (paramSessionInfo == null) {
      return null;
    }
    long l1;
    int j;
    if (paramSessionInfo.J)
    {
      l1 = Long.parseLong(paramSessionInfo.d);
      j = 3;
    }
    for (;;)
    {
      return new Object[] { Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(i) };
      int k = paramSessionInfo.F;
      long l2 = paramSessionInfo.g;
      if (k == 2)
      {
        i = 1;
        j = k;
        l1 = l2;
      }
      else if (k == 1)
      {
        i = paramSessionInfo.D;
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
  
  protected static boolean loadGAEngine()
  {
    try
    {
      AVSoUtils.a(-1047L, BaseApplicationImpl.getContext(), "qav_gaudio_engine", true);
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGAudioCtrl", 1, "loadGAEngine fail.", localThrowable);
    }
    return false;
  }
  
  public int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = QAVConfigUtils.a();
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
    paramInt4 = QAVConfigUtils.a();
    if (paramInt4 > 0) {}
    for (;;)
    {
      QLog.w("QQGAudioCtrl", 1, "acceptGAudio, emAVRelationType[" + paramInt1 + "], emMultiAVType[" + paramInt2 + "], emMultiAVSubType[" + paramInt3 + "], nConfID[" + paramInt5 + "], groupId[" + paramLong1 + "], maxShowVideo[" + paramInt4 + "]");
      accept(paramInt1, paramLong1, paramInt2, paramInt3, paramInt5, paramInt4);
      return 0;
      paramInt4 = 5;
    }
  }
  
  public byte[] getConfigInfoFromFile()
  {
    return Common.readFile(BaseApplicationImpl.getContext(), "VideoConfigInfo");
  }
  
  public Context getContext()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public AVNativeEventProcessor getNativeEventProcessor()
  {
    if (this.mEventCallback == null) {}
    try
    {
      if (this.mEventCallback == null) {
        this.mEventCallback = new QQGAudioCtrl.NativeEventCallback(this);
      }
      return this.mEventCallback;
    }
    finally {}
  }
  
  public int getRoomUserSdkVersion(SessionInfo paramSessionInfo, String paramString)
  {
    try
    {
      l1 = Long.parseLong(paramString);
      paramSessionInfo = getRoomParams(paramSessionInfo);
      if ((paramSessionInfo == null) || (l1 == 0L))
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
        k = ((Integer)paramSessionInfo[0]).intValue();
        l2 = ((Long)paramSessionInfo[1]).longValue();
        m = ((Integer)paramSessionInfo[2]).intValue();
        j = getRoomUserClientVersion(k, l2, m, l1);
        int i = j;
      } while (!QLog.isColorLevel());
      QLog.i("QQGAudioCtrl", 2, String.format("getRoomUserSdkVersion [%s, %s, %s, %s, %s]", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(j) }));
      return j;
    }
  }
  
  public int getRoomUserTerminalType(SessionInfo paramSessionInfo, String paramString)
  {
    try
    {
      l1 = Long.parseLong(paramString);
      paramSessionInfo = getRoomParams(paramSessionInfo);
      if ((paramSessionInfo == null) || (l1 == 0L))
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
        k = ((Integer)paramSessionInfo[0]).intValue();
        l2 = ((Long)paramSessionInfo[1]).longValue();
        m = ((Integer)paramSessionInfo[2]).intValue();
        j = getRoomUserTerminalType(k, l2, m, l1);
        int i = j;
      } while (!QLog.isColorLevel());
      QLog.i("QQGAudioCtrl", 2, String.format("getRoomUserTerminalType [%s, %s, %s, %s, %s]", new Object[] { Integer.valueOf(k), Long.valueOf(l2), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(j) }));
      return j;
    }
  }
  
  public String getSharpConfigPayloadFromFile()
  {
    Object localObject1 = Common.readFile(BaseApplicationImpl.getContext(), Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
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
  
  public int getSharpConfigVersionFromFile()
  {
    try
    {
      Object localObject = Common.readFile(BaseApplicationImpl.getContext(), Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
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
  
  public void init(Context paramContext, long paramLong, int paramInt)
  {
    init(paramContext, paramLong, paramInt, true);
  }
  
  public void init(Context paramContext, long paramLong, int paramInt, boolean paramBoolean)
  {
    String str2 = ResMgr.a();
    if (paramBoolean) {}
    for (String str1 = ResMgr.b();; str1 = null)
    {
      super.init(paramContext, paramLong, paramInt, "8.5.5", new SDKConfigInfoBuilder().a(), str2, str1);
      return;
    }
  }
  
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
    int j = invite(paramArrayOfLong, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel())
    {
      if (paramArrayOfLong != null)
      {
        int k = paramArrayOfLong.length;
        String str1 = "uinList";
        int i = 0;
        for (;;)
        {
          str2 = str1;
          if (i >= k) {
            break;
          }
          long l = paramArrayOfLong[i];
          str1 = str1 + "[" + l + "]";
          i += 1;
        }
      }
      String str2 = "[null]";
      QLog.i("QQGAudioCtrl", 2, "inviteUser, " + str2 + "], nReason[" + paramInt1 + "], original[" + paramInt2 + "], pstnLevel[" + paramInt3 + "], ret[" + j + "]");
    }
    return j;
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
    paramInt1 = inviteM(paramArrayOfLong, paramInt1, paramArrayOfString, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4);
    QLog.w("QQGAudioCtrl", 1, "inviteUser2, " + str2 + ", nReason[" + paramInt4 + "], roomFlag[" + paramInt3 + "], transSelf[" + paramBoolean2 + "], ret[" + paramInt1 + "]");
    return paramInt1;
  }
  
  public void lockVideoMaxQP(int paramInt, String paramString)
  {
    QLog.e("QQGAudioCtrl", 1, "LockVideoMaxQP nNewQP=" + paramInt + " , strDesc= " + paramString);
    lockVideoMaxQP(paramInt);
  }
  
  public int nativeStopAudioSend(boolean paramBoolean)
  {
    try
    {
      int i = stopAudioSend(paramBoolean);
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      AVLog.printErrorLog("QQGAudioCtrl", localUnsatisfiedLinkError.getMessage());
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
      AVLog.printErrorLog("QQGAudioCtrl", localUnsatisfiedLinkError.getMessage());
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
      AVLog.printErrorLog("QQGAudioCtrl", localUnsatisfiedLinkError.getMessage());
    }
    return -1;
  }
  
  public void onReceiveAudio(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mMavCallback != null)
    {
      this.mMavCallback.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
      if (AudioDump.a()) {
        AudioDump.a().a(paramArrayOfByte, paramInt4, paramArrayOfByte.length);
      }
    }
  }
  
  void processMicAuthAfterEnterRoom(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 8))
    {
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 4);
      if (MavJniUtil.getIntFromByte(arrayOfByte) != 1) {
        break label80;
      }
    }
    label80:
    for (boolean bool = true;; bool = false)
    {
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, 4, arrayOfByte, 0, 4);
      int i = MavJniUtil.getIntFromByte(arrayOfByte);
      this.mMavCallback.onGAudioMicSetByAdmin(0L, i);
      this.mMavCallback.onGAudioRoomMicModeChanged(0L, bool, true);
      return;
    }
  }
  
  public int quitRoom(int paramInt)
  {
    if (AudioDump.a()) {
      AudioDump.a().c();
    }
    return quit(paramInt);
  }
  
  public int request(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = QAVConfigUtils.a();
    if (i > 0) {}
    for (;;)
    {
      QLog.w("QQGAudioCtrl", 1, "request, maxShowVideo[" + i + "]");
      return request(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt5, i, 0);
      i = 5;
    }
  }
  
  public int sendShareFrame(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return sendShareFrame2NativeBmp(paramBitmap, paramInt1, paramInt2);
  }
  
  public int sendShareFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return sendShareFrame2Native(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setCallback(QQGAudioCtrlCallback paramQQGAudioCtrlCallback)
  {
    this.mMavCallback = paramQQGAudioCtrlCallback;
    setEventListener(paramQQGAudioCtrlCallback);
  }
  
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
  
  public void setShareEncParam(RecordParam paramRecordParam, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "setShareEncParam, param[" + paramRecordParam + "], maxW[" + paramInt1 + "], maxH[" + paramInt2 + "], activeNow[" + paramInt3 + "]");
    }
    setShareEncParam(1, paramRecordParam.width, paramRecordParam.height, paramRecordParam.fps, 4, paramInt1, paramInt2, paramInt3);
  }
  
  public int startAVGameVideoRecv(ArrayList<VideoViewInfo> paramArrayList)
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
      QLog.d("QQGAudioCtrl", 2, "startAVGameVideoRecv-->info=" + str);
    }
    return startVideoRecv(arrayOfLong, j);
  }
  
  public int startAudioSend()
  {
    return startAudioSend(false);
  }
  
  public int startCommonGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString, int paramInt4, byte[] paramArrayOfByte, int paramInt5)
  {
    if ((paramInt1 != 11) || (paramInt2 != 14) || (paramInt3 != 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioCtrl", 2, "startCommonGAudio type error!");
      }
      paramInt2 = -1;
      return paramInt2;
    }
    int i = QAVConfigUtils.a();
    label46:
    StringBuilder localStringBuilder;
    if (i > 0) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("startCommonGAudio emAVRelationType:").append(paramInt1).append(" emMultiAVType:").append(paramInt2).append(" emMultiAVSubType:").append(paramInt3).append(" roomId:").append(paramLong1).append(" selfUin:").append(paramLong2).append(" llAppid:").append(paramInt4).append(" nConfig:").append(0).append(" maxShowVideo:").append(i).append(" openId:").append(paramString).append(" sourceId:").append(paramInt4).append(" commonSig.length:");
        if (paramArrayOfByte == null) {
          break label290;
        }
      }
    }
    for (int j = paramArrayOfByte.length;; j = 0)
    {
      for (;;)
      {
        QLog.d("QQGAudioCtrl", 2, j + " svrRecogFlag:" + paramInt5);
        try
        {
          for (;;)
          {
            paramInt1 = commonRequest(paramInt1, paramLong1, paramInt2, paramInt3, paramInt4, 0, i, paramString, paramInt4, paramArrayOfByte, paramInt5);
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
            label290:
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
  
  public int startGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long[] paramArrayOfLong, int paramInt4, long paramLong2, boolean paramBoolean, int paramInt5, int paramInt6, int paramInt7)
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
    int i = QAVConfigUtils.a();
    if (i > 0) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQGAudioCtrl", 1, "startGAudio, emAVRelationType[" + paramInt1 + "], groupId[" + paramLong1 + "], emMultiAVType[" + paramInt2 + "], emMultiAVSubType[" + paramInt3 + "], isSwitchGroup[" + paramBoolean + "], apnType[" + paramInt4 + "], nConfigID[" + paramInt6 + "], llConfAppid[" + paramInt5 + "], maxShowVideo[" + i + "]");
      }
      try
      {
        paramInt1 = request(paramInt1, paramLong1, paramInt2, paramInt3, paramInt5, paramInt6, i, paramInt7);
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
    AVLog.printErrorLog("QQGAudioCtrl", paramArrayOfLong.getMessage());
    return paramInt1;
  }
  
  public boolean startOrStopShareSend(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = stopShareSend(paramInt);; i = startShareSend(paramInt))
    {
      QLog.i("QQGAudioCtrl", 1, "startOrStopShareSend, stop[" + paramBoolean + "], emShareType[" + paramInt + "], ret[" + i + "]");
      if (i != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public int startVideoRecv(ArrayList<VideoViewInfo> paramArrayList)
  {
    return startVideoRecv(paramArrayList, false);
  }
  
  public int startVideoRecv(ArrayList<VideoViewInfo> paramArrayList, boolean paramBoolean)
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
      if (paramBoolean)
      {
        if (this.mMavCallback == null) {
          return 0;
        }
        SessionInfo localSessionInfo = this.mMavCallback.a();
        if (localSessionInfo == null) {
          return 0;
        }
        if (localSessionInfo.a(((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Long, i)) {
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
        if (((VideoViewInfo)paramArrayList.get(i)).jdField_a_of_type_Boolean) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.QQGAudioCtrl
 * JD-Core Version:    0.7.0.1
 */
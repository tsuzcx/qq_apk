package com.tencent.av.gaudio;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.QavEngineAssistant;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.avsdkconfig.QavSdkConfigHelper;
import com.tencent.av.core.AVSoProxyImpl;
import com.tencent.av.core.SDKConfigInfoBuilder;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.so.ResMgr;
import com.tencent.av.utils.AVSoUtils;
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
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
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
  static QQGAudioCtrl sQQGAudioCtrl;
  private AVNativeEventProcessor mEventCallback;
  protected long mGroupId = 0L;
  public Vector<Long> mInviteGAudioUinList = new Vector();
  public boolean mIsSwitchGroup = false;
  protected QQGAudioCtrlCallback mMavCallback = null;
  protected final VcSystemInfo mSysInfo;
  
  protected QQGAudioCtrl()
  {
    QavEngineAssistant.a();
    String str = SDKConfigInfo.getDeviceInfo(new AVSoProxyImpl(BaseApplication.getContext()));
    this.mSysInfo = new VcSystemInfo();
    initEngine(this.mSysInfo, this, str);
    if (AudioDump.c()) {
      AudioDump.b();
    }
  }
  
  public static ArrayList<AVUserInfo> getAVInfoListFromByte2(byte[] paramArrayOfByte, int paramInt)
  {
    Iterator localIterator = null;
    Object localObject3 = null;
    AVUserInfo localAVUserInfo = null;
    localObject2 = localObject3;
    if (paramArrayOfByte != null)
    {
      Object localObject1 = localIterator;
      localObject2 = localObject3;
      try
      {
        if (paramArrayOfByte.length == paramInt)
        {
          localObject1 = localIterator;
          localObject2 = new memposinfo.AccountExtInfoList();
          localObject1 = localIterator;
          ((memposinfo.AccountExtInfoList)localObject2).mergeFrom(paramArrayOfByte);
          localObject1 = localIterator;
          localIterator = ((memposinfo.AccountExtInfoList)localObject2).msg_account_ext_info.get().iterator();
          paramArrayOfByte = localAVUserInfo;
          for (;;)
          {
            localObject1 = paramArrayOfByte;
            localObject2 = paramArrayOfByte;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = paramArrayOfByte;
            localObject2 = (memposinfo.AccountExtInfo)localIterator.next();
            localObject1 = paramArrayOfByte;
            if (((memposinfo.AccountExtInfo)localObject2).msg_common_info.has())
            {
              localObject1 = paramArrayOfByte;
              localObject2 = (memposinfo.CommonInfo)((memposinfo.AccountExtInfo)localObject2).msg_common_info.get();
              localObject1 = paramArrayOfByte;
              localAVUserInfo = new AVUserInfo();
              localObject1 = paramArrayOfByte;
              localAVUserInfo.account = ((memposinfo.CommonInfo)localObject2).uint64_account.get();
              localObject1 = paramArrayOfByte;
              localAVUserInfo.openId = ((memposinfo.CommonInfo)localObject2).bytes_account.get().toStringUtf8();
              localObject2 = paramArrayOfByte;
              if (paramArrayOfByte == null)
              {
                localObject1 = paramArrayOfByte;
                localObject2 = new ArrayList();
              }
              localObject1 = localObject2;
              ((ArrayList)localObject2).add(localAVUserInfo);
              paramArrayOfByte = (byte[])localObject2;
            }
          }
        }
        return localObject2;
      }
      catch (Exception paramArrayOfByte)
      {
        AVCoreLog.e("QQGAudioCtrl", "getAVInfoListFromByte2 fail.", paramArrayOfByte);
        localObject2 = localObject1;
      }
    }
  }
  
  public static QQGAudioCtrl getGAudioCtrlInstance()
  {
    if (sQQGAudioCtrl == null)
    {
      if (!AVSoUtils.m()) {
        return null;
      }
      sQQGAudioCtrl = new QQGAudioCtrl();
    }
    return sQQGAudioCtrl;
  }
  
  private Object[] getRoomParams(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return null;
    }
    boolean bool = paramSessionInfo.am;
    int i = 8;
    long l;
    int j;
    if (bool)
    {
      l = Long.parseLong(paramSessionInfo.s);
      j = 3;
    }
    else
    {
      j = paramSessionInfo.aQ;
      l = paramSessionInfo.aN;
      if (j == 2) {
        i = 1;
      } else if (j == 1) {
        i = paramSessionInfo.o;
      } else if (j != 3) {
        i = 0;
      }
    }
    return new Object[] { Integer.valueOf(j), Long.valueOf(l), Integer.valueOf(i) };
  }
  
  public int accept(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = QAVConfigUtils.b();
    if (i <= 0) {
      i = 5;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("accept, maxShowVideo[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    QLog.w("QQGAudioCtrl", 1, localStringBuilder.toString());
    return accept(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, i);
  }
  
  public int acceptGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long[] paramArrayOfLong, int paramInt4, long paramLong2, int paramInt5)
  {
    if ((paramLong1 != 0L) && (paramInt2 != -1) && (paramInt1 != -1))
    {
      if (paramInt3 == -1) {
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
      paramInt4 = QAVConfigUtils.b();
      if (paramInt4 <= 0) {
        paramInt4 = 5;
      }
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("acceptGAudio, emAVRelationType[");
      paramArrayOfLong.append(paramInt1);
      paramArrayOfLong.append("], emMultiAVType[");
      paramArrayOfLong.append(paramInt2);
      paramArrayOfLong.append("], emMultiAVSubType[");
      paramArrayOfLong.append(paramInt3);
      paramArrayOfLong.append("], nConfID[");
      paramArrayOfLong.append(paramInt5);
      paramArrayOfLong.append("], groupId[");
      paramArrayOfLong.append(paramLong1);
      paramArrayOfLong.append("], maxShowVideo[");
      paramArrayOfLong.append(paramInt4);
      paramArrayOfLong.append("]");
      QLog.w("QQGAudioCtrl", 1, paramArrayOfLong.toString());
      accept(paramInt1, paramLong1, paramInt2, paramInt3, paramInt5, paramInt4);
      return 0;
    }
    return -1;
  }
  
  public byte[] getConfigInfoFromFile()
  {
    return Common.readFile(BaseApplication.getContext(), "VideoConfigInfo");
  }
  
  public Context getContext()
  {
    return BaseApplication.getContext();
  }
  
  public AVNativeEventProcessor getNativeEventProcessor()
  {
    if (this.mEventCallback == null) {
      try
      {
        if (this.mEventCallback == null) {
          this.mEventCallback = new QQGAudioCtrl.NativeEventCallback(this);
        }
      }
      finally {}
    }
    return this.mEventCallback;
  }
  
  public int getRoomUserSdkVersion(SessionInfo paramSessionInfo, String paramString)
  {
    try
    {
      l1 = Long.parseLong(paramString);
    }
    catch (Throwable paramString)
    {
      long l1;
      label9:
      int i;
      long l2;
      int j;
      int k;
      break label9;
    }
    l1 = 0L;
    paramSessionInfo = getRoomParams(paramSessionInfo);
    if ((paramSessionInfo != null) && (l1 != 0L))
    {
      i = ((Integer)paramSessionInfo[0]).intValue();
      l2 = ((Long)paramSessionInfo[1]).longValue();
      j = ((Integer)paramSessionInfo[2]).intValue();
      k = getRoomUserClientVersion(i, l2, j, l1);
      if (QLog.isColorLevel()) {
        QLog.i("QQGAudioCtrl", 2, String.format("getRoomUserSdkVersion [%s, %s, %s, %s, %s]", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(k) }));
      }
      return k;
    }
    return -1;
  }
  
  public int getRoomUserTerminalType(SessionInfo paramSessionInfo, String paramString)
  {
    try
    {
      l1 = Long.parseLong(paramString);
    }
    catch (Throwable paramString)
    {
      long l1;
      label9:
      int i;
      long l2;
      int j;
      int k;
      break label9;
    }
    l1 = 0L;
    paramSessionInfo = getRoomParams(paramSessionInfo);
    if ((paramSessionInfo != null) && (l1 != 0L))
    {
      i = ((Integer)paramSessionInfo[0]).intValue();
      l2 = ((Long)paramSessionInfo[1]).longValue();
      j = ((Integer)paramSessionInfo[2]).intValue();
      k = getRoomUserTerminalType(i, l2, j, l1);
      if (QLog.isColorLevel()) {
        QLog.i("QQGAudioCtrl", 2, String.format("getRoomUserTerminalType [%s, %s, %s, %s, %s]", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(k) }));
      }
      return k;
    }
    return -1;
  }
  
  public String getSharpConfigPayloadFromFile()
  {
    Object localObject1 = Common.readFile(BaseApplication.getContext(), Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
    Object localObject2 = "";
    Object localObject3 = localObject2;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject1 = new String((byte[])localObject1);
      int i = ((String)localObject1).indexOf('|');
      String str2;
      try
      {
        String str1 = ((String)localObject1).substring(0, i);
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("GetSharpConfigPayloadFromFile version e = ");
          ((StringBuilder)localObject3).append(localException1);
          QLog.d("QQGAudioCtrl", 2, ((StringBuilder)localObject3).toString());
        }
        str2 = "";
      }
      try
      {
        localObject1 = ((String)localObject1).substring(i + 1);
      }
      catch (Exception localException2)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("GetSharpConfigPayloadFromFile payload e = ");
          ((StringBuilder)localObject1).append(localException2);
          QLog.d("QQGAudioCtrl", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      localObject4 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("GetSharpConfigPayloadFromFile multi version: ");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append(". payload: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("QQGAudioCtrl", 2, ((StringBuilder)localObject2).toString());
        localObject4 = localObject1;
      }
    }
    return localObject4;
  }
  
  public int getSharpConfigVersionFromFile()
  {
    try
    {
      Object localObject = Common.readFile(BaseApplication.getContext(), Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
      if (localObject != null)
      {
        String str = new String((byte[])localObject);
        if (!TextUtils.isEmpty(str))
        {
          int i = str.indexOf('|');
          localObject = str.substring(0, i);
          str = str.substring(i + 1);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("GetSharpConfigPayloadFromFile multi version: ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(". payload: ");
            localStringBuilder.append(str);
            QLog.d("", 2, localStringBuilder.toString());
          }
          return Integer.parseInt((String)localObject);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GetSharpConfigVersionFromFile, payloadBufTmp[");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("]");
        QLog.w("QQGAudioCtrl", 1, ((StringBuilder)localObject).toString());
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
    String str2 = ResMgr.c();
    String str1;
    if (paramBoolean) {
      str1 = ResMgr.e();
    } else {
      str1 = null;
    }
    String str3 = QavSdkConfigHelper.b();
    super.init(paramContext, paramLong, paramInt, "8.8.17", new SDKConfigInfoBuilder().a(), str2, str1, str3, QAVConfigUtils.o());
  }
  
  public int inviteUser(long[] paramArrayOfLong, int paramInt)
  {
    if (paramArrayOfLong != null)
    {
      int j = paramArrayOfLong.length;
      String str = "uinList";
      i = 0;
      for (;;)
      {
        localObject = str;
        if (i >= j) {
          break;
        }
        long l = paramArrayOfLong[i];
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("]");
        str = ((StringBuilder)localObject).toString();
        i += 1;
      }
    }
    Object localObject = "[null]";
    int i = invite(paramArrayOfLong, paramInt, 0, 0);
    paramArrayOfLong = new StringBuilder();
    paramArrayOfLong.append("inviteUser, ");
    paramArrayOfLong.append((String)localObject);
    paramArrayOfLong.append(", nReason[");
    paramArrayOfLong.append(paramInt);
    paramArrayOfLong.append("], ret[");
    paramArrayOfLong.append(i);
    paramArrayOfLong.append("]");
    QLog.w("QQGAudioCtrl", 1, paramArrayOfLong.toString());
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
        int i = 0;
        String str = "uinList";
        for (;;)
        {
          localObject = str;
          if (i >= k) {
            break;
          }
          long l = paramArrayOfLong[i];
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append("[");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append("]");
          str = ((StringBuilder)localObject).toString();
          i += 1;
        }
      }
      Object localObject = "[null]";
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("inviteUser, ");
      paramArrayOfLong.append((String)localObject);
      paramArrayOfLong.append("], nReason[");
      paramArrayOfLong.append(paramInt1);
      paramArrayOfLong.append("], original[");
      paramArrayOfLong.append(paramInt2);
      paramArrayOfLong.append("], pstnLevel[");
      paramArrayOfLong.append(paramInt3);
      paramArrayOfLong.append("], ret[");
      paramArrayOfLong.append(j);
      paramArrayOfLong.append("]");
      QLog.i("QQGAudioCtrl", 2, paramArrayOfLong.toString());
    }
    return j;
  }
  
  public int inviteUser(long[] paramArrayOfLong, int paramInt1, String[] paramArrayOfString, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    int j = 0;
    int k;
    int i;
    if (paramArrayOfLong != null)
    {
      k = paramArrayOfLong.length;
      localObject1 = "uinList";
      i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= k) {
          break;
        }
        long l = paramArrayOfLong[i];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("[");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append("]");
        localObject1 = ((StringBuilder)localObject2).toString();
        i += 1;
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uinList");
    ((StringBuilder)localObject1).append("[null]");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(", phoneList");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (paramArrayOfString != null)
    {
      k = paramArrayOfString.length;
      i = j;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= k) {
          break;
        }
        localObject2 = paramArrayOfString[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("[");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("]");
        localObject1 = localStringBuilder.toString();
        i += 1;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("[null]");
    localObject2 = ((StringBuilder)localObject2).toString();
    paramInt1 = inviteM(paramArrayOfLong, paramInt1, paramArrayOfString, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4);
    paramArrayOfLong = new StringBuilder();
    paramArrayOfLong.append("inviteUser2, ");
    paramArrayOfLong.append((String)localObject2);
    paramArrayOfLong.append(", nReason[");
    paramArrayOfLong.append(paramInt4);
    paramArrayOfLong.append("], roomFlag[");
    paramArrayOfLong.append(paramInt3);
    paramArrayOfLong.append("], transSelf[");
    paramArrayOfLong.append(paramBoolean2);
    paramArrayOfLong.append("], ret[");
    paramArrayOfLong.append(paramInt1);
    paramArrayOfLong.append("]");
    QLog.w("QQGAudioCtrl", 1, paramArrayOfLong.toString());
    return paramInt1;
  }
  
  public void lockVideoMaxQP(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LockVideoMaxQP nNewQP=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , strDesc= ");
    localStringBuilder.append(paramString);
    QLog.e("QQGAudioCtrl", 1, localStringBuilder.toString());
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
    QQGAudioCtrlCallback localQQGAudioCtrlCallback = this.mMavCallback;
    if (localQQGAudioCtrlCallback != null)
    {
      localQQGAudioCtrlCallback.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
      if (AudioDump.c()) {
        AudioDump.a().onReceiveAudioFrame(paramArrayOfByte, paramInt4, paramArrayOfByte.length);
      }
    }
  }
  
  void processMicAuthAfterEnterRoom(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 8))
    {
      byte[] arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 4);
      boolean bool;
      if (MavJniUtil.getIntFromByte(arrayOfByte) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, 4, arrayOfByte, 0, 4);
      int i = MavJniUtil.getIntFromByte(arrayOfByte);
      this.mMavCallback.onGAudioMicSetByAdmin(0L, i);
      this.mMavCallback.onGAudioRoomMicModeChanged(0L, bool, true);
    }
  }
  
  public int quitRoom(int paramInt)
  {
    if (AudioDump.c()) {
      AudioDump.a().e();
    }
    return super.quitRoom(paramInt);
  }
  
  public int request(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = QAVConfigUtils.b();
    if (i <= 0) {
      i = 5;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("request, maxShowVideo[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    QLog.w("QQGAudioCtrl", 1, localStringBuilder.toString());
    return request(paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt5, i, 0);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setShareEncParam, param[");
      localStringBuilder.append(paramRecordParam);
      localStringBuilder.append("], maxW[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], maxH[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], activeNow[");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("]");
      QLog.i("AVShare", 2, localStringBuilder.toString());
    }
    setShareEncParam(1, paramRecordParam.width, paramRecordParam.height, paramRecordParam.fps, 4, paramInt1, paramInt2, paramInt3);
  }
  
  public int startAVGameVideoRecv(ArrayList<VideoViewInfo> paramArrayList)
  {
    int i = 0;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return 0;
      }
      int j = paramArrayList.size() * 3;
      long[] arrayOfLong = new long[j];
      String str = new String();
      while (i < paramArrayList.size())
      {
        int k = i * 3;
        arrayOfLong[k] = ((VideoViewInfo)paramArrayList.get(i)).a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("uin=");
        localStringBuilder.append(arrayOfLong[k]);
        localStringBuilder.append(" ,");
        str = localStringBuilder.toString();
        int m = k + 1;
        arrayOfLong[m] = ((VideoViewInfo)paramArrayList.get(i)).b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("videoSrcType=");
        localStringBuilder.append(arrayOfLong[m]);
        localStringBuilder.append(" ,");
        str = localStringBuilder.toString();
        if (((VideoViewInfo)paramArrayList.get(i)).c) {
          arrayOfLong[(k + 2)] = 1L;
        } else {
          arrayOfLong[(k + 2)] = 0L;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("isBig=");
        localStringBuilder.append(arrayOfLong[(k + 2)]);
        localStringBuilder.append(" ,");
        str = localStringBuilder.toString();
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("startAVGameVideoRecv-->info=");
        paramArrayList.append(str);
        QLog.d("QQGAudioCtrl", 2, paramArrayList.toString());
      }
      return startVideoRecv(arrayOfLong, j);
    }
    return 0;
  }
  
  public int startAudioSend()
  {
    return startAudioSend(false);
  }
  
  public int startCommonGAudio(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString, int paramInt4, byte[] paramArrayOfByte, int paramInt5)
  {
    if ((paramInt1 == 11) && (paramInt2 == 14) && (paramInt3 == 1))
    {
      int i = QAVConfigUtils.b();
      if (i <= 0) {
        i = 5;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startCommonGAudio emAVRelationType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" emMultiAVType:");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" emMultiAVSubType:");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append(" roomId:");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(" selfUin:");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append(" llAppid:");
        localStringBuilder.append(paramInt4);
        localStringBuilder.append(" nConfig:");
        int j = 0;
        localStringBuilder.append(0);
        localStringBuilder.append(" maxShowVideo:");
        localStringBuilder.append(i);
        localStringBuilder.append(" openId:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" sourceId:");
        localStringBuilder.append(paramInt4);
        localStringBuilder.append(" commonSig.length:");
        if (paramArrayOfByte != null) {
          j = paramArrayOfByte.length;
        }
        localStringBuilder.append(j);
        localStringBuilder.append(" svrRecogFlag:");
        localStringBuilder.append(paramInt5);
        QLog.d("QQGAudioCtrl", 2, localStringBuilder.toString());
      }
      try
      {
        paramInt1 = commonRequest(paramInt1, paramLong1, paramInt2, paramInt3, paramInt4, 0, i, paramString, paramInt4, paramArrayOfByte, paramInt5);
        paramInt2 = paramInt1;
        try
        {
          if (!QLog.isColorLevel()) {
            break label369;
          }
          paramString = new StringBuilder();
          paramString.append("startCommonGAudio result:");
          paramString.append(paramInt1);
          QLog.d("QQGAudioCtrl", 2, paramString.toString());
          return paramInt1;
        }
        catch (Throwable paramString) {}
        QLog.e("QQGAudioCtrl", 1, "startCommonGAudio fail.", paramString);
      }
      catch (Throwable paramString)
      {
        paramInt1 = -1;
      }
      paramInt2 = paramInt1;
      label369:
      return paramInt2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioCtrl", 2, "startCommonGAudio type error!");
    }
    return -1;
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
    int i = QAVConfigUtils.b();
    if (i <= 0) {
      i = 5;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("startGAudio, emAVRelationType[");
      paramArrayOfLong.append(paramInt1);
      paramArrayOfLong.append("], groupId[");
      paramArrayOfLong.append(paramLong1);
      paramArrayOfLong.append("], emMultiAVType[");
      paramArrayOfLong.append(paramInt2);
      paramArrayOfLong.append("], emMultiAVSubType[");
      paramArrayOfLong.append(paramInt3);
      paramArrayOfLong.append("], isSwitchGroup[");
      paramArrayOfLong.append(paramBoolean);
      paramArrayOfLong.append("], apnType[");
      paramArrayOfLong.append(paramInt4);
      paramArrayOfLong.append("], nConfigID[");
      paramArrayOfLong.append(paramInt6);
      paramArrayOfLong.append("], llConfAppid[");
      paramArrayOfLong.append(paramInt5);
      paramArrayOfLong.append("], maxShowVideo[");
      paramArrayOfLong.append(i);
      paramArrayOfLong.append("]");
      QLog.w("QQGAudioCtrl", 1, paramArrayOfLong.toString());
    }
    try
    {
      paramInt1 = request(paramInt1, paramLong1, paramInt2, paramInt3, paramInt5, paramInt6, i, paramInt7);
      try
      {
        this.mGroupId = paramLong1;
        this.mIsSwitchGroup = paramBoolean;
        return paramInt1;
      }
      catch (UnsatisfiedLinkError paramArrayOfLong) {}
      AVLog.printErrorLog("QQGAudioCtrl", paramArrayOfLong.getMessage());
    }
    catch (UnsatisfiedLinkError paramArrayOfLong)
    {
      paramInt1 = -1;
    }
    return paramInt1;
  }
  
  public boolean startOrStopShareSend(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean) {
      i = stopShareSend(paramInt);
    } else {
      i = startShareSend(paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startOrStopShareSend, stop[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], emShareType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], ret[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    QLog.i("QQGAudioCtrl", 1, localStringBuilder.toString());
    return i == 1;
  }
  
  public int startVideoRecv(ArrayList<VideoViewInfo> paramArrayList)
  {
    return startVideoRecv(paramArrayList, false);
  }
  
  public int startVideoRecv(ArrayList<VideoViewInfo> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return 0;
      }
      int j = paramArrayList.size() * 3;
      long[] arrayOfLong = new long[j];
      String str = new String();
      int i = 0;
      while (i < paramArrayList.size())
      {
        int k = i * 3;
        arrayOfLong[k] = ((VideoViewInfo)paramArrayList.get(i)).a;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("uin=");
        ((StringBuilder)localObject).append(arrayOfLong[k]);
        ((StringBuilder)localObject).append(" ,");
        str = ((StringBuilder)localObject).toString();
        int m = k + 1;
        arrayOfLong[m] = ((VideoViewInfo)paramArrayList.get(i)).b;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("videoSrcType=");
        ((StringBuilder)localObject).append(arrayOfLong[m]);
        ((StringBuilder)localObject).append(" ,");
        str = ((StringBuilder)localObject).toString();
        if (paramBoolean)
        {
          localObject = this.mMavCallback;
          if (localObject == null) {
            return 0;
          }
          if (((QQGAudioCtrlCallback)localObject).b(((VideoViewInfo)paramArrayList.get(i)).a, i)) {
            arrayOfLong[(k + 2)] = 1L;
          } else {
            arrayOfLong[(k + 2)] = 0L;
          }
        }
        else if (((VideoViewInfo)paramArrayList.get(i)).c)
        {
          arrayOfLong[(k + 2)] = 1L;
        }
        else
        {
          arrayOfLong[(k + 2)] = 0L;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("isBig=");
        ((StringBuilder)localObject).append(arrayOfLong[(k + 2)]);
        ((StringBuilder)localObject).append(" ,");
        str = ((StringBuilder)localObject).toString();
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("startVideoRecv-->info=");
        paramArrayList.append(str);
        QLog.d("QQGAudioCtrl", 2, paramArrayList.toString());
      }
      return startVideoRecv(arrayOfLong, j);
    }
    return 0;
  }
  
  public void uninit()
  {
    super.uninit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.QQGAudioCtrl
 * JD-Core Version:    0.7.0.1
 */
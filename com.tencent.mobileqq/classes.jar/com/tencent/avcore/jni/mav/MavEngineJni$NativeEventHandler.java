package com.tencent.avcore.jni.mav;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.avcore.data.RecordParam;
import com.tencent.avcore.engine.mav.IMavEventListener;
import com.tencent.avcore.engine.mav.MavNativeEventParams;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVNativeEventProcessor;
import com.tencent.avcore.util.MavJniUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class MavEngineJni$NativeEventHandler
  extends Handler
{
  private static final String TAG = "MavEngineJni_NativeEvent";
  protected final WeakReference<AVNativeEventProcessor> mCallback;
  protected final WeakReference<IMavEventListener> mEventLisRef;
  final MavEngineJni.NativeEventHandler.EventCountLog mEventLogForFrameDec = new MavEngineJni.NativeEventHandler.EventCountLog(String.valueOf(61), 10000L);
  private final RecordParam mShareRecordParam = new RecordParam();
  
  MavEngineJni$NativeEventHandler(Looper paramLooper, IMavEventListener paramIMavEventListener, AVNativeEventProcessor paramAVNativeEventProcessor)
  {
    super(paramLooper);
    this.mEventLisRef = new WeakReference(paramIMavEventListener);
    this.mCallback = new WeakReference(paramAVNativeEventProcessor);
  }
  
  private void onChatMemberInfoChange(IMavEventListener paramIMavEventListener, int paramInt1, byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 8)) {}
    do
    {
      return;
      paramArrayOfByte = MavJniUtil.getUinListFromBuf(paramArrayOfByte);
      if (paramArrayOfByte != null) {
        break;
      }
    } while (!AVCoreLog.isColorLevel());
    AVCoreLog.e("MavEngineJni_NativeEvent", "handleMessage, fail, empty uinList");
    return;
    int j;
    if (AVCoreLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      j = paramArrayOfByte.length;
      i = 0;
      while (i < j)
      {
        long l = paramArrayOfByte[i];
        localStringBuilder.append("UserUin = ");
        localStringBuilder.append(l);
        localStringBuilder.append(", ");
        i += 1;
      }
      localStringBuilder.append("eventid = ");
      localStringBuilder.append(paramInt1);
      AVCoreLog.i("MavEngineJni_NativeEvent", localStringBuilder.toString());
    }
    int i = 0;
    if (paramInt1 == 42)
    {
      j = (int)paramLong1;
      if (j <= 100) {
        break label172;
      }
      i = 100;
    }
    for (;;)
    {
      paramIMavEventListener.onMultiVideoChatMembersInfoChange(paramLong2, paramArrayOfByte, paramInt1, paramInt3, paramLong1, paramInt2, i);
      return;
      label172:
      i = j;
      if (j < 0) {
        i = 0;
      }
    }
  }
  
  private void onRecPushEncParam(IMavEventListener paramIMavEventListener, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (AVCoreLog.isDevelopLevel()) {
      AVCoreLog.d("MavEngineJni_NativeEvent", "onRecPushEncParam, relationType[" + paramInt1 + "], relationId[" + paramLong1 + "], lValue[" + paramLong2 + "], flag[" + paramInt2 + "]");
    }
    int i = this.mShareRecordParam.width;
    int j = this.mShareRecordParam.height;
    int k = this.mShareRecordParam.fps;
    int m = (int)(paramLong2 & 0xFFFFFFFF);
    int n = (int)(paramLong2 >> 32 & 0xFFFFFFFF);
    this.mShareRecordParam.width = n;
    this.mShareRecordParam.height = m;
    this.mShareRecordParam.fps = paramInt2;
    paramIMavEventListener.onRecSharePushEncParam(paramInt1, paramLong1, this.mShareRecordParam);
    if ((AVCoreLog.isColorLevel()) && ((i != this.mShareRecordParam.width) || (j != this.mShareRecordParam.height) || (k != this.mShareRecordParam.fps))) {
      AVCoreLog.i("AVShare", "onRecPushEncParam, relationType[" + paramInt1 + "], groupId[" + paramLong1 + "], param[" + this.mShareRecordParam + "]");
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    Object localObject1;
    IMavEventListener localIMavEventListener;
    do
    {
      do
      {
        return;
        localObject1 = (MavNativeEventParams)paramMessage.obj;
        if (localObject1 != null) {
          break;
        }
      } while (!AVCoreLog.isColorLevel());
      AVCoreLog.e("MavEngineJni_NativeEvent", "handleMessage-->NativeEventParams is null");
      return;
      localIMavEventListener = (IMavEventListener)this.mEventLisRef.get();
      if (localIMavEventListener != null) {
        break;
      }
      localObject1 = (AVNativeEventProcessor)this.mCallback.get();
    } while (localObject1 == null);
    ((AVNativeEventProcessor)localObject1).handleMessage(paramMessage);
    return;
    int i1 = paramMessage.what;
    byte[] arrayOfByte1 = ((MavNativeEventParams)localObject1).detail;
    long l3 = ((MavNativeEventParams)localObject1).info;
    long l1 = ((MavNativeEventParams)localObject1).groupId;
    int j = ((MavNativeEventParams)localObject1).multiAVType;
    int n = ((MavNativeEventParams)localObject1).multiSubType;
    int k = ((MavNativeEventParams)localObject1).relationType;
    int i2 = ((MavNativeEventParams)localObject1).bufferLen;
    int m = ((MavNativeEventParams)localObject1).flag;
    label152:
    Object localObject2;
    boolean bool1;
    if (i1 == 61)
    {
      this.mEventLogForFrameDec.log();
      localObject2 = (AVNativeEventProcessor)this.mCallback.get();
      if (localObject2 == null) {
        break label2904;
      }
      bool1 = ((AVNativeEventProcessor)localObject2).isMsgNeedExtraDeal(i1);
      if (bool1) {
        ((MavNativeEventParams)localObject1).elapsedRealtime = SystemClock.elapsedRealtime();
      }
    }
    for (;;)
    {
      switch (i1)
      {
      case 9: 
      case 10: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 40: 
      case 41: 
      case 46: 
      case 47: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
      case 60: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
      case 68: 
      case 69: 
      case 80: 
      case 81: 
      case 82: 
      case 83: 
      case 99: 
      case 100: 
      case 105: 
      case 106: 
      case 111: 
      case 112: 
      case 113: 
      case 114: 
      case 115: 
      case 116: 
      case 117: 
      case 118: 
      case 119: 
      case 120: 
      case 123: 
      case 124: 
      case 125: 
      case 126: 
      case 127: 
      case 128: 
      case 129: 
      case 130: 
      case 131: 
      case 132: 
      case 133: 
      case 134: 
      case 135: 
      case 136: 
      case 137: 
      case 146: 
      case 147: 
      case 148: 
      case 149: 
      case 150: 
      case 151: 
      case 152: 
      case 154: 
      case 155: 
      case 156: 
      case 159: 
      case 160: 
      case 161: 
      case 162: 
      case 163: 
      case 164: 
      case 165: 
      case 166: 
      case 167: 
      case 168: 
      case 169: 
      case 170: 
      case 173: 
      case 174: 
      case 175: 
      default: 
        if (localObject2 != null) {
          ((AVNativeEventProcessor)localObject2).handleMessage(paramMessage);
        }
        break;
      }
      label918:
      while ((bool1) && (localObject2 != null))
      {
        ((AVNativeEventProcessor)localObject2).handleMessage(paramMessage);
        return;
        if ((i1 == 43) || (!AVCoreLog.isColorLevel())) {
          break label152;
        }
        localObject2 = new StringBuilder().append("handleMessage, groupId[").append(l1).append("], multiAVType[").append(j).append("], multiSubType[").append(n).append("], relationType[").append(k).append("], info[").append(l3).append("], detail[");
        if (arrayOfByte1 != null) {}
        for (int i = arrayOfByte1.length;; i = -1)
        {
          AVCoreLog.i("MavEngineJni_NativeEvent", i + "], eventId[" + i1 + "], buflen[" + i2 + "], flag[" + m + "]");
          break;
        }
        localObject1 = MavJniUtil.getUinListFromBuf(arrayOfByte1);
        if ((k == 2) || (k == 1))
        {
          if (localObject1 == null) {}
          for (i = 0;; i = localObject1.length)
          {
            onRecvUserList(localIMavEventListener, 6, k, l1, (long[])localObject1, l3, j, n, i, m);
            break;
          }
        }
        if (k == 3)
        {
          onRecvDoubleVideoMeeting(localIMavEventListener, i1, k, l3, j, n);
          continue;
          localObject1 = MavJniUtil.getUinListFromBuf(arrayOfByte1);
          if (localObject1 == null) {}
          for (i = 0;; i = localObject1.length)
          {
            onRecvUserList(localIMavEventListener, 44, k, l1, (long[])localObject1, 0L, j, 0, i, m);
            break;
          }
          m = (int)l3;
          if (m >= 0)
          {
            localObject1 = null;
            if (m > 0) {
              if (arrayOfByte1 == null) {
                break label1271;
              }
            }
            label1271:
            for (i = arrayOfByte1.length / m;; i = 0)
            {
              localObject1 = MavJniUtil.getAVInfoListFromByte(arrayOfByte1, i);
              if (localObject1 == null) {
                break label1276;
              }
              onRecvUserList(localIMavEventListener, 44, k, l1, (ArrayList)localObject1, 0L, 0, j, m);
              break;
            }
            label1276:
            onRecvUserListFail(localIMavEventListener, k, l1, -99L);
          }
          else
          {
            onRecvUserListFail(localIMavEventListener, k, l1, m);
            continue;
            if (arrayOfByte1 == null) {
              break;
            }
            localObject1 = MavJniUtil.getAVInfoFromByte(arrayOfByte1, i2);
            if (localObject1 == null)
            {
              if (!AVCoreLog.isColorLevel()) {
                break;
              }
              AVCoreLog.i("MavEngineJni_NativeEvent", "handleMessage, fail, empty userInfo");
              return;
            }
            if ((((AVUserInfo)localObject1).accountType == 0) || ((((AVUserInfo)localObject1).accountType == 1) && (((AVUserInfo)localObject1).pstnStatus == 3) && (i1 == 70)) || ((((AVUserInfo)localObject1).accountType == 1) && (i1 == 71)))
            {
              localIMavEventListener.onMAVMemberInOrOut((AVUserInfo)localObject1, l1, i1, k, l3, new int[] { j });
              continue;
              onChatMemberInfoChange(localIMavEventListener, i1, arrayOfByte1, l3, l1, j, k);
              continue;
              localIMavEventListener.onGroupChatModeChange(l1, k, i1);
              continue;
              if ((arrayOfByte1 == null) || (arrayOfByte1.length < 8)) {
                break;
              }
              if (k == 1)
              {
                long l2 = MavJniUtil.getLongFromByte(arrayOfByte1);
                if (j != 10)
                {
                  localIMavEventListener.onVideoSrcChange((int)l3, k, l2, l1);
                  continue;
                  if ((arrayOfByte1 == null) || (arrayOfByte1.length < 8)) {
                    break;
                  }
                  localIMavEventListener.onPPTInOrOut(l1, MavJniUtil.getLongFromByte(arrayOfByte1), k, (int)l3);
                  continue;
                  i = 0;
                  switch ((int)l3)
                  {
                  default: 
                    if ((l3 > 200L) && (l3 < 300L)) {
                      if (arrayOfByte1 == null)
                      {
                        localObject1 = "";
                        label1648:
                        localIMavEventListener.onGroupSecurityLimit(l1, l3, (String)localObject1);
                      }
                    }
                    break;
                  }
                  while (i != 0)
                  {
                    localIMavEventListener.onGroupVideoClosed(k, l1, i, j);
                    break;
                    if (k == 1)
                    {
                      i = 1;
                      continue;
                      i = 2;
                      continue;
                      i = 7;
                      continue;
                      i = 35;
                      continue;
                      i = 42;
                      continue;
                      i = 43;
                      continue;
                      i = 3;
                      continue;
                      localObject1 = new String(arrayOfByte1);
                      break label1648;
                      i = (int)l3;
                    }
                  }
                  if ((((MavNativeEventParams)localObject1).detail == null) || (((MavNativeEventParams)localObject1).detail.length < 16)) {
                    break;
                  }
                  localObject1 = MavJniUtil.getAVInfoFromByte(((MavNativeEventParams)localObject1).detail, ((MavNativeEventParams)localObject1).detail.length);
                  if (i1 == 140) {}
                  for (boolean bool2 = true; localObject1 != null; bool2 = false)
                  {
                    if (AVCoreLog.isColorLevel()) {
                      AVCoreLog.e("MavEngineJni_NativeEvent", "MemberAudioChange, uin[" + ((AVUserInfo)localObject1).account + "], accountType[" + ((AVUserInfo)localObject1).accountType + "], isMicOff[" + bool2 + "]");
                    }
                    localIMavEventListener.onGAudioMemberMicChanged(((AVUserInfo)localObject1).account, ((AVUserInfo)localObject1).accountType, ((AVUserInfo)localObject1).pstnStatus, bool2);
                    break;
                  }
                  l2 = 0L;
                  l1 = l2;
                  if (((MavNativeEventParams)localObject1).detail != null)
                  {
                    l1 = l2;
                    if (((MavNativeEventParams)localObject1).detail.length == 8) {
                      l1 = MavJniUtil.getLongFromByte(((MavNativeEventParams)localObject1).detail);
                    }
                  }
                  if (l3 != 0L) {}
                  for (bool2 = true;; bool2 = false)
                  {
                    localIMavEventListener.onGAudioRoomMicModeChanged(l1, bool2, false);
                    break;
                  }
                  l2 = 0L;
                  i = (int)l3;
                  l1 = l2;
                  if (((MavNativeEventParams)localObject1).detail != null)
                  {
                    l1 = l2;
                    if (((MavNativeEventParams)localObject1).detail.length == 8) {
                      l1 = MavJniUtil.getLongFromByte(((MavNativeEventParams)localObject1).detail);
                    }
                  }
                  if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.i("MavEngineJni_NativeEvent", "SetMicByAdmin : uin = " + l1 + ", micAuthByAdmin = " + i);
                  }
                  localIMavEventListener.onGAudioMicSetByAdmin(l1, i);
                  continue;
                  j = (int)l3;
                  if ((((MavNativeEventParams)localObject1).detail == null) || (j == 0)) {
                    break;
                  }
                  byte[] arrayOfByte2 = ((MavNativeEventParams)localObject1).detail;
                  if (((MavNativeEventParams)localObject1).detail != null) {}
                  for (i = arrayOfByte1.length / j;; i = 0)
                  {
                    localObject1 = MavJniUtil.getAVInfoListFromByte(arrayOfByte2, i);
                    if ((localObject1 == null) || (((ArrayList)localObject1).size() != j)) {
                      break;
                    }
                    localIMavEventListener.onGAudioSetMicFailed(j, (ArrayList)localObject1);
                    break label918;
                  }
                  if ((((MavNativeEventParams)localObject1).detail == null) || (((MavNativeEventParams)localObject1).detail.length != 16)) {
                    break;
                  }
                  l1 = MavJniUtil.getLongFromByte(((MavNativeEventParams)localObject1).detail);
                  arrayOfByte1 = new byte[4];
                  System.arraycopy(((MavNativeEventParams)localObject1).detail, 12, arrayOfByte1, 0, 4);
                  i = MavJniUtil.getIntFromByte(arrayOfByte1);
                  if (l3 == 1L) {}
                  for (bool2 = true;; bool2 = false)
                  {
                    if (AVCoreLog.isColorLevel()) {
                      AVCoreLog.i("MavEngineJni_NativeEvent", "onGAudioUserAudioSuspectNoisy : uin = " + l1 + ", isSuspectNoisy = " + bool2 + ",validDuration = " + i);
                    }
                    localIMavEventListener.onGAudioUserAudioSuspectNoisy(l1, bool2, i);
                    break;
                  }
                  localIMavEventListener.onCreateRoomSuc(k, l1, j);
                  continue;
                  localIMavEventListener.onEnterSuc(l1, k, j);
                  continue;
                  localIMavEventListener.onGAudioTerminalEnterRoom(k, l1, new int[] { j });
                  continue;
                  localIMavEventListener.onGAudioRoomDestroy(k, l1);
                  continue;
                  localIMavEventListener.onGAudioSDKError(k, l1, 17, (int)((MavNativeEventParams)localObject1).info);
                  continue;
                  localIMavEventListener.onGAudioSDKError(k, l1, 16, (int)((MavNativeEventParams)localObject1).info);
                  continue;
                  localIMavEventListener.onGAudioSDKError(k, l1, 15, (int)((MavNativeEventParams)localObject1).info);
                  continue;
                  localIMavEventListener.onGAudioKickOut(l1, k, j);
                  continue;
                  if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.i("MavEngineJni_NativeEvent", "EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA-->Uin=" + l3 + " ,VideoSrcType=" + k);
                  }
                  localIMavEventListener.onRemoteVideoDataComeIn(61, l3, k);
                  continue;
                  localIMavEventListener.onGaGoOnStageResult(i1, l3, l1, k);
                  continue;
                  localIMavEventListener.onGaGoOffStageResult(i1, l3, l1, k);
                  continue;
                  localIMavEventListener.onShareOpsCallback(84, (int)l3, k, l1, j, n);
                  continue;
                  localIMavEventListener.onShareOpsCallback(85, (int)l3, k, l1, j, n);
                  continue;
                  localIMavEventListener.onShareOpsCallback(86, (int)l3, k, l1, j, n);
                  continue;
                  localIMavEventListener.onShareOpsCallback(87, (int)l3, k, l1, j, n);
                  continue;
                  localIMavEventListener.onShareOpsCallback(88, (int)l3, k, l1, j, n);
                  continue;
                  localIMavEventListener.onShareOpsCallback(89, (int)l3, k, l1, j, n);
                  continue;
                  localIMavEventListener.onGaSwitchVideoResult(i1, l3, l1, k);
                  continue;
                  localIMavEventListener.onDetectAudioDataIssue(3);
                  continue;
                  localIMavEventListener.onDetectAudioDataIssue(4);
                  continue;
                  if (arrayOfByte1 == null) {}
                  for (localObject1 = "";; localObject1 = new String(arrayOfByte1))
                  {
                    localIMavEventListener.onKickOutSuc(l1, k, j, (int)l3, (String)localObject1);
                    break;
                  }
                  if (arrayOfByte1 == null) {}
                  for (localObject1 = "";; localObject1 = new String(arrayOfByte1))
                  {
                    localIMavEventListener.onKickOutFail(l1, k, j, (int)l3, (String)localObject1);
                    break;
                  }
                  localIMavEventListener.onHowling();
                  continue;
                  localIMavEventListener.onOpenMicFail();
                  continue;
                  if (arrayOfByte1 != null)
                  {
                    localIMavEventListener.onSetMicBySelf(MavJniUtil.getLongFromByte(arrayOfByte1));
                    continue;
                    if (l3 != 0L)
                    {
                      localIMavEventListener.onFpsChange((int)l3);
                      continue;
                      if (arrayOfByte1 != null)
                      {
                        localIMavEventListener.onGVideoDownloadChannelCtlChanged(arrayOfByte1);
                        continue;
                        localIMavEventListener.onSelfAudioVolumeChange(l3);
                        continue;
                        onRecPushEncParam(localIMavEventListener, k, l1, l3, m);
                        continue;
                        localIMavEventListener.onCheckScreenShareAvailable((int)l3, arrayOfByte1);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label2904:
      bool1 = false;
    }
  }
  
  void onRecvDoubleVideoMeeting(IMavEventListener paramIMavEventListener, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4)
  {
    if (paramIMavEventListener == null) {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("MavEngineJni_NativeEvent", "onRecvDoubleVideoMeeting-->mVideoController is null");
      }
    }
    do
    {
      return;
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("MavEngineJni_NativeEvent", "onRecvDoubleVideoMeeting-->eventId=" + paramInt1 + " ,relationType=" + paramInt2 + " ,inviteUin=" + paramLong + "], multiAVType[" + paramInt3 + "], multiSubType[" + paramInt4);
      }
      if (paramInt1 == 6)
      {
        paramIMavEventListener.onDoubleVideoMeetingInvite(paramLong, paramInt3, paramInt4);
        return;
      }
    } while ((paramInt1 == 44) || (paramInt1 != 5));
    paramIMavEventListener.onDoubleVideoMeetingInvite(paramLong, paramInt3, paramInt4);
  }
  
  void onRecvUserList(IMavEventListener paramIMavEventListener, int paramInt1, int paramInt2, long paramLong1, ArrayList<AVUserInfo> paramArrayList, long paramLong2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramIMavEventListener == null) {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("MavEngineJni_NativeEvent", "onRecvUserList --> mVideoController is null");
      }
    }
    do
    {
      return;
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("MavEngineJni_NativeEvent", "onRecvUserList.GET_ROOM_INFO, evtId[" + paramInt1 + "], relationType[" + paramInt2 + "], relationId[" + paramLong1 + "], inviteUin[" + paramLong2 + "], multiAVType[" + paramInt4 + "], multiSubType[" + paramInt3 + "], userCount[" + paramInt5 + "]");
      }
      if (paramInt1 == 44)
      {
        paramIMavEventListener.onGAudioMemAllUpdate(paramLong1, paramArrayList, paramInt4, paramInt5);
        return;
      }
    } while (!AVCoreLog.isColorLevel());
    AVCoreLog.e("MavEngineJni_NativeEvent", "onRecvUserList --> WRONG EVTID. evtId = " + paramInt1);
  }
  
  void onRecvUserList(IMavEventListener paramIMavEventListener, int paramInt1, int paramInt2, long paramLong1, long[] paramArrayOfLong, long paramLong2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramIMavEventListener == null) {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("MavEngineJni_NativeEvent", "onRecvUserList-->mVideoController is null");
      }
    }
    label193:
    label199:
    do
    {
      return;
      int i = 0;
      if (paramArrayOfLong != null) {
        i = paramArrayOfLong.length;
      }
      StringBuilder localStringBuilder;
      if (AVCoreLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onRecvUserList, evtId[").append(paramInt1).append("], relationType[").append(paramInt2).append("], relationId[").append(paramLong1).append("], inviteUin[").append(paramLong2).append("], multiAVType[").append(paramInt3).append("], multiSubType[").append(paramInt4).append("], userListSize[").append(i).append("], userList[");
        if (paramArrayOfLong == null) {
          break label193;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        AVCoreLog.i("MavEngineJni_NativeEvent", bool + "], flag[" + paramInt6 + "]");
        if ((paramArrayOfLong == null) && (paramInt2 == 2)) {
          break;
        }
        if (paramInt1 != 44) {
          break label199;
        }
        paramIMavEventListener.onGAudioMemAllUpdate(paramLong1, paramArrayOfLong, paramInt3, paramInt5);
        return;
      }
      if (paramInt1 == 6)
      {
        paramIMavEventListener.onGAudioInvite(paramInt2, paramLong1, paramLong2, paramArrayOfLong, false, paramInt3, paramInt4, paramInt6);
        return;
      }
    } while (paramInt1 != 5);
    paramIMavEventListener.onGAudioInvite(paramInt2, paramLong1, paramLong2, paramArrayOfLong, true, paramInt3, paramInt4, paramInt6);
  }
  
  void onRecvUserListFail(IMavEventListener paramIMavEventListener, int paramInt, long paramLong1, long paramLong2)
  {
    AVCoreLog.e("MavEngineJni_NativeEvent", "onRecvUserListFail, relationType[" + paramInt + "], relationId[" + paramLong1 + "], errCode[" + paramLong2 + "]");
    paramIMavEventListener.onGAudioRoomDestroy(paramInt, paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.mav.MavEngineJni.NativeEventHandler
 * JD-Core Version:    0.7.0.1
 */
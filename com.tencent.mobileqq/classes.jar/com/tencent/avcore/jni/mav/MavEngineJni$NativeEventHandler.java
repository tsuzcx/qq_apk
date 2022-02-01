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
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < 8) {
        return;
      }
      paramArrayOfByte = MavJniUtil.getUinListFromBuf(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        if (AVCoreLog.isColorLevel()) {
          AVCoreLog.e("MavEngineJni_NativeEvent", "handleMessage, fail, empty uinList");
        }
        return;
      }
      if (AVCoreLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int j = paramArrayOfByte.length;
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
      if (paramInt1 == 42)
      {
        i = (int)paramLong1;
        if (i > 100)
        {
          i = 100;
          break label167;
        }
        if (i >= 0) {
          break label167;
        }
      }
      int i = 0;
      label167:
      paramIMavEventListener.onMultiVideoChatMembersInfoChange(paramLong2, paramArrayOfByte, paramInt1, paramInt3, paramLong1, paramInt2, i);
    }
  }
  
  private void onRecPushEncParam(IMavEventListener paramIMavEventListener, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if (AVCoreLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRecPushEncParam, relationType[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], relationId[");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("], lValue[");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("], flag[");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("]");
      AVCoreLog.d("MavEngineJni_NativeEvent", ((StringBuilder)localObject).toString());
    }
    int i = this.mShareRecordParam.width;
    int j = this.mShareRecordParam.height;
    int k = this.mShareRecordParam.fps;
    int m = (int)(paramLong2 & 0xFFFFFFFF);
    int n = (int)(paramLong2 >> 32 & 0xFFFFFFFF);
    Object localObject = this.mShareRecordParam;
    ((RecordParam)localObject).width = n;
    ((RecordParam)localObject).height = m;
    ((RecordParam)localObject).fps = paramInt2;
    paramIMavEventListener.onRecSharePushEncParam(paramInt1, paramLong1, (RecordParam)localObject);
    if ((AVCoreLog.isColorLevel()) && ((i != this.mShareRecordParam.width) || (j != this.mShareRecordParam.height) || (k != this.mShareRecordParam.fps)))
    {
      paramIMavEventListener = new StringBuilder();
      paramIMavEventListener.append("onRecPushEncParam, relationType[");
      paramIMavEventListener.append(paramInt1);
      paramIMavEventListener.append("], groupId[");
      paramIMavEventListener.append(paramLong1);
      paramIMavEventListener.append("], param[");
      paramIMavEventListener.append(this.mShareRecordParam);
      paramIMavEventListener.append("]");
      AVCoreLog.i("AVShare", paramIMavEventListener.toString());
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    Object localObject1 = (MavNativeEventParams)paramMessage.obj;
    if (localObject1 == null)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("MavEngineJni_NativeEvent", "handleMessage-->NativeEventParams is null");
      }
      return;
    }
    IMavEventListener localIMavEventListener = (IMavEventListener)this.mEventLisRef.get();
    if (localIMavEventListener == null)
    {
      localObject1 = (AVNativeEventProcessor)this.mCallback.get();
      if (localObject1 != null) {
        ((AVNativeEventProcessor)localObject1).handleMessage(paramMessage);
      }
      return;
    }
    int i1 = paramMessage.what;
    Object localObject2 = ((MavNativeEventParams)localObject1).detail;
    long l3 = ((MavNativeEventParams)localObject1).info;
    long l1 = ((MavNativeEventParams)localObject1).groupId;
    int k = ((MavNativeEventParams)localObject1).multiAVType;
    int n = ((MavNativeEventParams)localObject1).multiSubType;
    int m = ((MavNativeEventParams)localObject1).relationType;
    int i2 = ((MavNativeEventParams)localObject1).bufferLen;
    int j = ((MavNativeEventParams)localObject1).flag;
    int i;
    if (i1 == 61)
    {
      this.mEventLogForFrameDec.log();
    }
    else if ((i1 != 43) && (AVCoreLog.isColorLevel()))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("handleMessage, groupId[");
      ((StringBuilder)localObject3).append(l1);
      ((StringBuilder)localObject3).append("], multiAVType[");
      ((StringBuilder)localObject3).append(k);
      ((StringBuilder)localObject3).append("], multiSubType[");
      ((StringBuilder)localObject3).append(n);
      ((StringBuilder)localObject3).append("], relationType[");
      ((StringBuilder)localObject3).append(m);
      ((StringBuilder)localObject3).append("], info[");
      ((StringBuilder)localObject3).append(l3);
      ((StringBuilder)localObject3).append("], detail[");
      if (localObject2 != null) {
        i = localObject2.length;
      } else {
        i = -1;
      }
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("], eventId[");
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append("], buflen[");
      ((StringBuilder)localObject3).append(i2);
      ((StringBuilder)localObject3).append("], flag[");
      ((StringBuilder)localObject3).append(j);
      ((StringBuilder)localObject3).append("]");
      AVCoreLog.i("MavEngineJni_NativeEvent", ((StringBuilder)localObject3).toString());
    }
    Object localObject3 = (AVNativeEventProcessor)this.mCallback.get();
    boolean bool1;
    if (localObject3 != null)
    {
      bool1 = ((AVNativeEventProcessor)localObject3).isMsgNeedExtraDeal(i1);
      if (bool1) {
        ((MavNativeEventParams)localObject1).elapsedRealtime = SystemClock.elapsedRealtime();
      }
    }
    else
    {
      bool1 = false;
    }
    if ((i1 != 5) && (i1 != 6))
    {
      if (i1 != 7) {
        if (i1 != 8)
        {
          if (i1 != 21)
          {
            if (i1 != 22)
            {
              if (i1 != 121)
              {
                if (i1 != 122) {
                  switch (i1)
                  {
                  default: 
                    switch (i1)
                    {
                    default: 
                      long l2 = 0L;
                      boolean bool2;
                      switch (i1)
                      {
                      default: 
                        switch (i1)
                        {
                        default: 
                          switch (i1)
                          {
                          default: 
                            switch (i1)
                            {
                            default: 
                              switch (i1)
                              {
                              default: 
                                if (localObject3 != null)
                                {
                                  ((AVNativeEventProcessor)localObject3).handleMessage(paramMessage);
                                  break;
                                }
                                break;
                              case 110: 
                                if (localObject2 != null)
                                {
                                  if (localObject2.length < 8) {
                                    return;
                                  }
                                  localIMavEventListener.onPPTInOrOut(l1, MavJniUtil.getLongFromByte((byte[])localObject2), m, (int)l3);
                                  break;
                                }
                                return;
                              case 109: 
                                if (localObject2 != null)
                                {
                                  if (localObject2.length < 8) {
                                    return;
                                  }
                                  if (m != 1) {
                                    break;
                                  }
                                  l2 = MavJniUtil.getLongFromByte((byte[])localObject2);
                                  if (k == 10) {
                                    break;
                                  }
                                  localIMavEventListener.onVideoSrcChange((int)l3, m, l2, l1);
                                  break;
                                }
                                return;
                              }
                              break;
                            case 101: 
                            case 102: 
                            case 103: 
                            case 104: 
                              localIMavEventListener.onGroupChatModeChange(l1, m, i1);
                            }
                            break;
                          case 72: 
                          case 73: 
                          case 74: 
                          case 75: 
                          case 76: 
                          case 77: 
                          case 78: 
                          case 79: 
                            break;
                          case 70: 
                          case 71: 
                            if (localObject2 == null) {
                              return;
                            }
                            localObject1 = MavJniUtil.getAVInfoFromByte((byte[])localObject2, i2);
                            if (localObject1 == null)
                            {
                              if (AVCoreLog.isColorLevel()) {
                                AVCoreLog.i("MavEngineJni_NativeEvent", "handleMessage, fail, empty userInfo");
                              }
                              return;
                            }
                            if ((((AVUserInfo)localObject1).accountType != 0) && ((((AVUserInfo)localObject1).accountType != 1) || (((AVUserInfo)localObject1).pstnStatus != 3) || (i1 != 70))) {
                              if ((((AVUserInfo)localObject1).accountType != 1) || (i1 != 71)) {
                                break label2916;
                              }
                            }
                            localIMavEventListener.onMAVMemberInOrOut((AVUserInfo)localObject1, l1, i1, m, l3, new int[] { k });
                          }
                          break;
                        case 45: 
                          localIMavEventListener.onGAudioKickOut(l1, m, k);
                          break;
                        case 44: 
                          localObject1 = MavJniUtil.getUinListFromBuf((byte[])localObject2);
                          if (localObject1 == null) {
                            i = 0;
                          } else {
                            i = localObject1.length;
                          }
                          onRecvUserList(localIMavEventListener, 44, m, l1, (long[])localObject1, 0L, k, 0, i, j);
                          break;
                        }
                        onChatMemberInfoChange(localIMavEventListener, i1, (byte[])localObject2, l3, l1, k, m);
                        break;
                      case 180: 
                        if ((int)l3 == 1) {
                          localIMavEventListener.onNotifyAIDenoiseTips(true);
                        } else {
                          localIMavEventListener.onNotifyAIDenoiseTips(false);
                        }
                        break;
                      case 178: 
                        localIMavEventListener.onCheckScreenShareAvailable((int)l3, (byte[])localObject2);
                        break;
                      case 177: 
                        onRecPushEncParam(localIMavEventListener, m, l1, l3, j);
                        break;
                      case 176: 
                        localIMavEventListener.onSelfAudioVolumeChange(l3);
                        break;
                      case 172: 
                        if (localObject2 == null) {
                          break;
                        }
                        localIMavEventListener.onGVideoDownloadChannelCtlChanged((byte[])localObject2);
                        break;
                      case 171: 
                        if (l3 == 0L) {
                          break;
                        }
                        localIMavEventListener.onFpsChange((int)l3);
                        break;
                      case 158: 
                        localIMavEventListener.onOpenMicFail();
                        break;
                      case 157: 
                        if (localObject2 == null) {
                          break;
                        }
                        localIMavEventListener.onSetMicBySelf(MavJniUtil.getLongFromByte((byte[])localObject2));
                        break;
                      case 153: 
                        localIMavEventListener.onHowling();
                        break;
                      case 145: 
                        if (((MavNativeEventParams)localObject1).detail != null)
                        {
                          if (((MavNativeEventParams)localObject1).detail.length != 16) {
                            return;
                          }
                          l1 = MavJniUtil.getLongFromByte(((MavNativeEventParams)localObject1).detail);
                          localObject2 = new byte[4];
                          System.arraycopy(((MavNativeEventParams)localObject1).detail, 12, localObject2, 0, 4);
                          i = MavJniUtil.getIntFromByte((byte[])localObject2);
                          if (l3 == 1L) {
                            bool2 = true;
                          } else {
                            bool2 = false;
                          }
                          if (AVCoreLog.isColorLevel())
                          {
                            localObject1 = new StringBuilder();
                            ((StringBuilder)localObject1).append("onGAudioUserAudioSuspectNoisy : uin = ");
                            ((StringBuilder)localObject1).append(l1);
                            ((StringBuilder)localObject1).append(", isSuspectNoisy = ");
                            ((StringBuilder)localObject1).append(bool2);
                            ((StringBuilder)localObject1).append(",validDuration = ");
                            ((StringBuilder)localObject1).append(i);
                            AVCoreLog.i("MavEngineJni_NativeEvent", ((StringBuilder)localObject1).toString());
                          }
                          localIMavEventListener.onGAudioUserAudioSuspectNoisy(l1, bool2, i);
                          break;
                        }
                        return;
                      case 144: 
                        j = (int)l3;
                        if (((MavNativeEventParams)localObject1).detail != null)
                        {
                          if (j == 0) {
                            return;
                          }
                          byte[] arrayOfByte = ((MavNativeEventParams)localObject1).detail;
                          if (((MavNativeEventParams)localObject1).detail != null) {
                            i = localObject2.length / j;
                          } else {
                            i = 0;
                          }
                          localObject1 = MavJniUtil.getAVInfoListFromByte(arrayOfByte, i);
                          if (localObject1 != null)
                          {
                            if (((ArrayList)localObject1).size() != j) {
                              return;
                            }
                            localIMavEventListener.onGAudioSetMicFailed(j, (ArrayList)localObject1);
                            break;
                          }
                        }
                        return;
                      case 143: 
                        i = (int)l3;
                        l1 = l2;
                        if (((MavNativeEventParams)localObject1).detail != null)
                        {
                          l1 = l2;
                          if (((MavNativeEventParams)localObject1).detail.length == 8) {
                            l1 = MavJniUtil.getLongFromByte(((MavNativeEventParams)localObject1).detail);
                          }
                        }
                        if (AVCoreLog.isColorLevel())
                        {
                          localObject1 = new StringBuilder();
                          ((StringBuilder)localObject1).append("SetMicByAdmin : uin = ");
                          ((StringBuilder)localObject1).append(l1);
                          ((StringBuilder)localObject1).append(", micAuthByAdmin = ");
                          ((StringBuilder)localObject1).append(i);
                          AVCoreLog.i("MavEngineJni_NativeEvent", ((StringBuilder)localObject1).toString());
                        }
                        localIMavEventListener.onGAudioMicSetByAdmin(l1, i);
                        break;
                      case 142: 
                        if ((((MavNativeEventParams)localObject1).detail != null) && (((MavNativeEventParams)localObject1).detail.length == 8)) {
                          l1 = MavJniUtil.getLongFromByte(((MavNativeEventParams)localObject1).detail);
                        } else {
                          l1 = 0L;
                        }
                        if (l3 != 0L) {
                          bool2 = true;
                        } else {
                          bool2 = false;
                        }
                        localIMavEventListener.onGAudioRoomMicModeChanged(l1, bool2, false);
                        break;
                      case 140: 
                      case 141: 
                        if (((MavNativeEventParams)localObject1).detail != null)
                        {
                          if (((MavNativeEventParams)localObject1).detail.length < 16) {
                            return;
                          }
                          localObject1 = MavJniUtil.getAVInfoFromByte(((MavNativeEventParams)localObject1).detail, ((MavNativeEventParams)localObject1).detail.length);
                          if (i1 == 140) {
                            bool2 = true;
                          } else {
                            bool2 = false;
                          }
                          if (localObject1 == null) {
                            break;
                          }
                          if (AVCoreLog.isColorLevel())
                          {
                            localObject2 = new StringBuilder();
                            ((StringBuilder)localObject2).append("MemberAudioChange, uin[");
                            ((StringBuilder)localObject2).append(((AVUserInfo)localObject1).account);
                            ((StringBuilder)localObject2).append("], accountType[");
                            ((StringBuilder)localObject2).append(((AVUserInfo)localObject1).accountType);
                            ((StringBuilder)localObject2).append("], isMicOff[");
                            ((StringBuilder)localObject2).append(bool2);
                            ((StringBuilder)localObject2).append("]");
                            AVCoreLog.e("MavEngineJni_NativeEvent", ((StringBuilder)localObject2).toString());
                          }
                          localIMavEventListener.onGAudioMemberMicChanged(((AVUserInfo)localObject1).account, ((AVUserInfo)localObject1).accountType, ((AVUserInfo)localObject1).pstnStatus, bool2);
                          break;
                        }
                        return;
                      case 138: 
                      case 139: 
                        i = (int)l3;
                        j = 35;
                        if ((i != 3) && (i != 15))
                        {
                          if (i != 32)
                          {
                            if (i != 35)
                            {
                              if (i != 7)
                              {
                                if (i != 8)
                                {
                                  if (i != 42)
                                  {
                                    if (i != 43)
                                    {
                                      if ((l3 > 200L) && (l3 < 300L))
                                      {
                                        if (localObject2 == null) {
                                          localObject1 = "";
                                        } else {
                                          localObject1 = new String((byte[])localObject2);
                                        }
                                        localIMavEventListener.onGroupSecurityLimit(l1, l3, (String)localObject1);
                                      }
                                      else
                                      {
                                        break label2199;
                                      }
                                    }
                                    else
                                    {
                                      i = 43;
                                      break label2199;
                                    }
                                  }
                                  else
                                  {
                                    i = 42;
                                    break label2199;
                                  }
                                }
                                else {
                                  if (m == 1) {
                                    break label2176;
                                  }
                                }
                                i = 0;
                                break label2199;
                                i = 1;
                              }
                              else
                              {
                                i = 2;
                              }
                            }
                            else {
                              i = j;
                            }
                          }
                          else {
                            i = 7;
                          }
                        }
                        else {
                          i = 3;
                        }
                        if (i == 0) {
                          break;
                        }
                        localIMavEventListener.onGroupVideoClosed(m, l1, i, k);
                        break;
                      case 96: 
                      case 97: 
                      case 98: 
                        localIMavEventListener.onGaSwitchVideoResult(i1, l3, l1, m);
                        break;
                      case 93: 
                      case 94: 
                      case 95: 
                        localIMavEventListener.onGaGoOffStageResult(i1, l3, l1, m);
                        break;
                      case 90: 
                      case 91: 
                      case 92: 
                        localIMavEventListener.onGaGoOnStageResult(i1, l3, l1, m);
                        break;
                      case 89: 
                        localIMavEventListener.onShareOpsCallback(89, (int)l3, m, l1, k, n);
                        break;
                      case 88: 
                        localIMavEventListener.onShareOpsCallback(88, (int)l3, m, l1, k, n);
                        break;
                      case 87: 
                        localIMavEventListener.onShareOpsCallback(87, (int)l3, m, l1, k, n);
                        break;
                      case 86: 
                        localIMavEventListener.onShareOpsCallback(86, (int)l3, m, l1, k, n);
                        break;
                      case 85: 
                        localIMavEventListener.onShareOpsCallback(85, (int)l3, m, l1, k, n);
                        break;
                      case 84: 
                        localIMavEventListener.onShareOpsCallback(84, (int)l3, m, l1, k, n);
                        break;
                      case 61: 
                        if (AVCoreLog.isColorLevel())
                        {
                          localObject1 = new StringBuilder();
                          ((StringBuilder)localObject1).append("EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA-->Uin=");
                          ((StringBuilder)localObject1).append(l3);
                          ((StringBuilder)localObject1).append(" ,VideoSrcType=");
                          ((StringBuilder)localObject1).append(m);
                          AVCoreLog.i("MavEngineJni_NativeEvent", ((StringBuilder)localObject1).toString());
                        }
                        localIMavEventListener.onRemoteVideoDataComeIn(61, l3, m);
                        break;
                      case 39: 
                        localIMavEventListener.onGAudioSDKError(m, l1, 15, (int)((MavNativeEventParams)localObject1).info);
                      }
                      break;
                    case 34: 
                    case 35: 
                      localIMavEventListener.onGAudioSDKError(m, l1, 16, (int)((MavNativeEventParams)localObject1).info);
                      break;
                    case 33: 
                      localIMavEventListener.onEnterSuc(l1, m, k);
                      break;
                    case 31: 
                    case 32: 
                      localIMavEventListener.onGAudioSDKError(m, l1, 17, (int)((MavNativeEventParams)localObject1).info);
                      break;
                    case 30: 
                      localIMavEventListener.onCreateRoomSuc(m, l1, k);
                    }
                    break;
                  case 13: 
                    break;
                  case 12: 
                    localIMavEventListener.onGAudioTerminalEnterRoom(m, l1, new int[] { k });
                    break;
                  case 11: 
                    label2176:
                    label2199:
                    localIMavEventListener.onGAudioRoomDestroy(m, l1);
                    break;
                  }
                } else {
                  localIMavEventListener.onDetectAudioDataIssue(4);
                }
              }
              else {
                localIMavEventListener.onDetectAudioDataIssue(3);
              }
            }
            else
            {
              if (localObject2 == null) {
                localObject1 = "";
              } else {
                localObject1 = new String((byte[])localObject2);
              }
              localIMavEventListener.onKickOutFail(l1, m, k, (int)l3, (String)localObject1);
            }
          }
          else
          {
            if (localObject2 == null) {
              localObject1 = "";
            } else {
              localObject1 = new String((byte[])localObject2);
            }
            localIMavEventListener.onKickOutSuc(l1, m, k, (int)l3, (String)localObject1);
          }
        }
        else
        {
          j = (int)l3;
          if (j >= 0)
          {
            localObject1 = null;
            if (j > 0)
            {
              if (localObject2 != null) {
                i = localObject2.length / j;
              } else {
                i = 0;
              }
              localObject1 = MavJniUtil.getAVInfoListFromByte((byte[])localObject2, i);
            }
            if (localObject1 != null) {
              onRecvUserList(localIMavEventListener, 44, m, l1, (ArrayList)localObject1, 0L, 0, k, j);
            } else {
              onRecvUserListFail(localIMavEventListener, m, l1, -99L);
            }
          }
          else
          {
            onRecvUserListFail(localIMavEventListener, m, l1, j);
          }
        }
      }
    }
    else
    {
      localObject1 = MavJniUtil.getUinListFromBuf((byte[])localObject2);
      if ((m != 2) && (m != 1))
      {
        if (m == 3) {
          onRecvDoubleVideoMeeting(localIMavEventListener, i1, m, l3, k, n);
        }
      }
      else
      {
        if (localObject1 == null) {
          i = 0;
        } else {
          i = localObject1.length;
        }
        onRecvUserList(localIMavEventListener, 6, m, l1, (long[])localObject1, l3, k, n, i, j);
      }
    }
    label2916:
    if ((bool1) && (localObject3 != null)) {
      ((AVNativeEventProcessor)localObject3).handleMessage(paramMessage);
    }
  }
  
  void onRecvDoubleVideoMeeting(IMavEventListener paramIMavEventListener, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4)
  {
    if (paramIMavEventListener == null)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("MavEngineJni_NativeEvent", "onRecvDoubleVideoMeeting-->mVideoController is null");
      }
      return;
    }
    if (AVCoreLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvDoubleVideoMeeting-->eventId=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" ,relationType=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" ,inviteUin=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], multiAVType[");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], multiSubType[");
      localStringBuilder.append(paramInt4);
      AVCoreLog.i("MavEngineJni_NativeEvent", localStringBuilder.toString());
    }
    if (paramInt1 == 6)
    {
      paramIMavEventListener.onDoubleVideoMeetingInvite(paramLong, paramInt3, paramInt4);
      return;
    }
    if (paramInt1 == 44) {
      return;
    }
    if (paramInt1 == 5) {
      paramIMavEventListener.onDoubleVideoMeetingInvite(paramLong, paramInt3, paramInt4);
    }
  }
  
  void onRecvUserList(IMavEventListener paramIMavEventListener, int paramInt1, int paramInt2, long paramLong1, ArrayList<AVUserInfo> paramArrayList, long paramLong2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramIMavEventListener == null)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("MavEngineJni_NativeEvent", "onRecvUserList --> mVideoController is null");
      }
      return;
    }
    if (AVCoreLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvUserList.GET_ROOM_INFO, evtId[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], relationId[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], inviteUin[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], multiAVType[");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("], multiSubType[");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], userCount[");
      localStringBuilder.append(paramInt5);
      localStringBuilder.append("]");
      AVCoreLog.i("MavEngineJni_NativeEvent", localStringBuilder.toString());
    }
    if (paramInt1 == 44)
    {
      paramIMavEventListener.onGAudioMemAllUpdate(paramLong1, paramArrayList, paramInt4, paramInt5);
      return;
    }
    if (AVCoreLog.isColorLevel())
    {
      paramIMavEventListener = new StringBuilder();
      paramIMavEventListener.append("onRecvUserList --> WRONG EVTID. evtId = ");
      paramIMavEventListener.append(paramInt1);
      AVCoreLog.e("MavEngineJni_NativeEvent", paramIMavEventListener.toString());
    }
  }
  
  void onRecvUserList(IMavEventListener paramIMavEventListener, int paramInt1, int paramInt2, long paramLong1, long[] paramArrayOfLong, long paramLong2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramIMavEventListener == null)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e("MavEngineJni_NativeEvent", "onRecvUserList-->mVideoController is null");
      }
      return;
    }
    boolean bool = false;
    int i;
    if (paramArrayOfLong != null) {
      i = paramArrayOfLong.length;
    } else {
      i = 0;
    }
    if (AVCoreLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvUserList, evtId[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], relationId[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], inviteUin[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], multiAVType[");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], multiSubType[");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append("], userListSize[");
      localStringBuilder.append(i);
      localStringBuilder.append("], userList[");
      if (paramArrayOfLong != null) {
        bool = true;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], flag[");
      localStringBuilder.append(paramInt6);
      localStringBuilder.append("]");
      AVCoreLog.i("MavEngineJni_NativeEvent", localStringBuilder.toString());
    }
    if ((paramArrayOfLong == null) && (paramInt2 == 2)) {
      return;
    }
    if (paramInt1 == 44)
    {
      paramIMavEventListener.onGAudioMemAllUpdate(paramLong1, paramArrayOfLong, paramInt3, paramInt5);
      return;
    }
    if (paramInt1 == 6)
    {
      paramIMavEventListener.onGAudioInvite(paramInt2, paramLong1, paramLong2, paramArrayOfLong, false, paramInt3, paramInt4, paramInt6);
      return;
    }
    if (paramInt1 == 5) {
      paramIMavEventListener.onGAudioInvite(paramInt2, paramLong1, paramLong2, paramArrayOfLong, true, paramInt3, paramInt4, paramInt6);
    }
  }
  
  void onRecvUserListFail(IMavEventListener paramIMavEventListener, int paramInt, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecvUserListFail, relationType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], relationId[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("], errCode[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("]");
    AVCoreLog.e("MavEngineJni_NativeEvent", localStringBuilder.toString());
    paramIMavEventListener.onGAudioRoomDestroy(paramInt, paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.mav.MavEngineJni.NativeEventHandler
 * JD-Core Version:    0.7.0.1
 */
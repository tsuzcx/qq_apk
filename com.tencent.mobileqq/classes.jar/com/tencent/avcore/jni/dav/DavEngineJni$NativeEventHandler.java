package com.tencent.avcore.jni.dav;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.avcore.engine.dav.DavNativeEventParams;
import com.tencent.avcore.engine.dav.IDavEventListener;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVCoreUtil;
import com.tencent.avcore.util.AVNativeEventProcessor;
import java.lang.ref.WeakReference;

class DavEngineJni$NativeEventHandler
  extends Handler
{
  private static final String TAG = "DAVEngineJni_NativeEvent";
  protected final WeakReference<AVNativeEventProcessor> mCallback;
  protected final WeakReference<IDavEventListener> mEventLisRef;
  
  DavEngineJni$NativeEventHandler(Looper paramLooper, IDavEventListener paramIDavEventListener, AVNativeEventProcessor paramAVNativeEventProcessor)
  {
    super(paramLooper);
    this.mEventLisRef = new WeakReference(paramIDavEventListener);
    this.mCallback = new WeakReference(paramAVNativeEventProcessor);
  }
  
  private void onReceiveRequest(int paramInt, DavNativeEventParams paramDavNativeEventParams, IDavEventListener paramIDavEventListener)
  {
    Object localObject1 = paramDavNativeEventParams.detail;
    int i = (int)paramDavNativeEventParams.extraParam0;
    String str1 = paramDavNativeEventParams.extraParam2;
    int j = paramDavNativeEventParams.extraParam3;
    int k = paramDavNativeEventParams.extraParam4;
    if (k == 3124) {
      i = 26;
    }
    String str2 = AVCoreUtil.asUnsignedDecimalString(paramDavNativeEventParams.fromUin);
    if ((i != 0) && (i != 12) && (i != 19) && (i != 29))
    {
      if ((i != 4) && (i != 5)) {}
      switch (i)
      {
      default: 
        switch (i)
        {
        }
        break;
      case 8: 
      case 9: 
        localObject1 = String.valueOf(paramDavNativeEventParams.extraParam1);
        break label400;
        if (localObject1 != null)
        {
          int m = localObject1[0];
          int n = localObject1.length;
          int i1 = m + 1;
          Object localObject2;
          if (n > i1)
          {
            localObject2 = new byte[m];
            System.arraycopy(localObject1, 1, localObject2, 0, m);
            localObject2 = new String((byte[])localObject2);
          }
          else
          {
            localObject2 = null;
          }
          n = localObject1[i1];
          if (localObject1.length > m + n + 2)
          {
            Object localObject3 = new byte[n];
            System.arraycopy(localObject1, m + 2, localObject3, 0, n);
            localObject3 = new String((byte[])localObject3);
            localObject1 = localObject3;
            if (localObject3 != null)
            {
              localObject1 = localObject3;
              if (localObject2 != null)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append((String)localObject2);
                ((StringBuilder)localObject1).append((String)localObject3);
                localObject1 = ((StringBuilder)localObject1).toString();
              }
            }
          }
          else
          {
            localObject1 = null;
          }
          if (AVCoreLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("uinType = ");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(", extraUin = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            AVCoreLog.i("onReceiveRequest", ((StringBuilder)localObject2).toString());
          }
        }
        break;
      }
    }
    localObject1 = null;
    label400:
    if ((paramInt != 2) && (paramInt != 60))
    {
      if ((paramInt == 1) || (paramInt == 61)) {
        paramIDavEventListener.onRequestVideo(i, str2, (String)localObject1, paramDavNativeEventParams.extraBuf, false, str1, j, k);
      }
    }
    else {
      paramIDavEventListener.onRequestVideo(i, str2, (String)localObject1, paramDavNativeEventParams.extraBuf, true, str1, j, k);
    }
    if (AVCoreLog.isColorLevel())
    {
      paramIDavEventListener = new StringBuilder();
      paramIDavEventListener.append("uinType = ");
      paramIDavEventListener.append(i);
      paramIDavEventListener.append(", extraUin = ");
      paramIDavEventListener.append((String)localObject1);
      paramIDavEventListener.append(", longFronUin = ");
      paramIDavEventListener.append(paramDavNativeEventParams.fromUin);
      AVCoreLog.i("onReceiveRequest", paramIDavEventListener.toString());
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    IDavEventListener localIDavEventListener = (IDavEventListener)this.mEventLisRef.get();
    if (localIDavEventListener == null) {
      return;
    }
    int i = paramMessage.what;
    DavNativeEventParams localDavNativeEventParams = (DavNativeEventParams)paramMessage.obj;
    if (localDavNativeEventParams == null)
    {
      AVCoreLog.printErrorLog("DAVEngineJni_NativeEvent", "p is null");
      return;
    }
    byte[] arrayOfByte1 = localDavNativeEventParams.detail;
    long l1 = localDavNativeEventParams.info;
    String str = AVCoreUtil.asUnsignedDecimalString(localDavNativeEventParams.fromUin);
    byte[] arrayOfByte2 = localDavNativeEventParams.extraBuf;
    Object localObject;
    if ((i != 16) && (i != 100) && (i != 117) && (i != 120) && (i != 124) && (i != 125))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage eventId[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], info[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("], fromUin[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("]");
      AVCoreLog.printAllUserLog("DAVEngineJni_NativeEvent", ((StringBuilder)localObject).toString());
    }
    AVNativeEventProcessor localAVNativeEventProcessor = (AVNativeEventProcessor)this.mCallback.get();
    int j;
    if ((localAVNativeEventProcessor != null) && (localAVNativeEventProcessor.isMsgNeedExtraDeal(i))) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      localDavNativeEventParams.elapsedRealtime = SystemClock.elapsedRealtime();
    }
    if ((i != 1) && (i != 2))
    {
      if (i == 3) {
        break label2045;
      }
      if (i == 4) {
        break label1808;
      }
      if (i == 13) {
        break label1796;
      }
      if (i == 14) {
        break label1784;
      }
      if (i == 91) {
        break label1773;
      }
      if (i == 92) {
        break label1762;
      }
      if (i == 113) {
        break label1680;
      }
      if (i != 114) {
        localObject = "";
      }
    }
    else
    {
      int k;
      switch (i)
      {
      default: 
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            switch (i)
            {
            default: 
              switch (i)
              {
              default: 
                switch (i)
                {
                default: 
                  if (localAVNativeEventProcessor == null) {
                    break;
                  }
                  localAVNativeEventProcessor.handleMessage(paramMessage);
                  break;
                case 108: 
                  localIDavEventListener.onCancelVideoMode(str);
                  break;
                case 107: 
                  localIDavEventListener.onRejectVideoMode(str);
                  break;
                case 106: 
                  localIDavEventListener.onAcceptVideoMode(str);
                  break;
                case 105: 
                  localIDavEventListener.onRequestVideoMode(str);
                }
                break;
              case 76: 
                localIDavEventListener.onPeerSwitchTerminalFail(str, (int)l1);
                break;
              case 75: 
                localIDavEventListener.onSyncOtherTerminalChatStatus(str, (int)l1);
                break;
              case 74: 
                i = (int)localDavNativeEventParams.extraParam0;
                k = (int)localDavNativeEventParams.extraParam1;
                long l2 = localDavNativeEventParams.extraParam5;
                if (localDavNativeEventParams.extraBuf != null) {
                  localObject = new String(localDavNativeEventParams.extraBuf);
                }
                localIDavEventListener.onSwitchTerminalSuccess(str, (int)l1, i, k, (String)localObject, l2);
                break;
              case 73: 
                localIDavEventListener.onPeerSwitchTerminal(str, (int)localDavNativeEventParams.extraParam0, (int)localDavNativeEventParams.extraParam1, localDavNativeEventParams.extraParam5);
                break;
              case 72: 
                i = (int)localDavNativeEventParams.extraParam0;
                if (i != 1)
                {
                  if (i != 2) {
                    i = 0;
                  } else {
                    i = 1;
                  }
                }
                else {
                  i = 2;
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("SdkEventId.EV_VOIP_OTHER_TER_CHATING_STAUTS, type[");
                ((StringBuilder)localObject).append(localDavNativeEventParams.extraParam0);
                ((StringBuilder)localObject).append("]");
                AVCoreLog.e("DAVEngineJni_NativeEvent", ((StringBuilder)localObject).toString());
                localIDavEventListener.onOtherTerminalChatingStatus(str, localDavNativeEventParams.extraParam1, i);
              }
              break;
            case 26: 
              localIDavEventListener.onAnotherIsRing(str, false);
              break;
            case 25: 
              localIDavEventListener.onAnotherIsRing(str, true);
              break;
            case 24: 
              localIDavEventListener.onCloseVideo(str, 12, 0L);
            }
            break;
          case 19: 
          case 20: 
          case 21: 
          case 22: 
            localIDavEventListener.onAVShiftEvent(i - 19, str);
            break;
          case 18: 
            localIDavEventListener.onConfigSysDealDone(str);
          }
          break;
        case 127: 
          if ((int)localDavNativeEventParams.extraParam0 == 1) {
            localIDavEventListener.onNotifyAIDenoiseTips(true);
          } else {
            localIDavEventListener.onNotifyAIDenoiseTips(false);
          }
          break;
        case 126: 
          localIDavEventListener.onSwitchMeeting(str, arrayOfByte1, l1);
          break;
        case 125: 
          localIDavEventListener.onAudioVolumeChange(localDavNativeEventParams.extraParam0, 0L, 100L);
          break;
        case 124: 
          localIDavEventListener.onNetworkQualityChanged((int)localDavNativeEventParams.extraParam0);
          break;
        case 123: 
          localIDavEventListener.onAvReqAutoAccept(str);
          break;
        case 119: 
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("EM_SDK_EVENT_ID_CUSTOM_COMMAND, peerUin[");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append("]");
          AVCoreLog.e("NativeEventHandler", ((StringBuilder)localObject).toString());
          localIDavEventListener.onSDKCustomCommand(str, localDavNativeEventParams.extraParam0, localDavNativeEventParams.extraParam1, localDavNativeEventParams.extraParam4);
          break;
        case 118: 
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("NETWORK_CHECK, peerUin[");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append("]");
          AVCoreLog.e("NativeEventHandler", ((StringBuilder)localObject).toString());
          localIDavEventListener.checkNetStatus();
          break;
        case 116: 
          localIDavEventListener.onFpsChange((int)l1);
          break;
        case 110: 
          localIDavEventListener.receiveTransferMsg(str, (int)l1, localDavNativeEventParams.detail);
          break;
        case 100: 
          localIDavEventListener.onNetLevel_S2C(str, l1, arrayOfByte1);
          break;
        case 95: 
          localIDavEventListener.onPstnCallConnected(str, (int)l1, localDavNativeEventParams.extraParam0, localDavNativeEventParams.detail);
          break;
        case 83: 
          localIDavEventListener.onSendC2CMsg(str);
          localIDavEventListener.onDetectAudioDataIssue(2048);
          break;
        case 69: 
          localIDavEventListener.onSwitchGroup(str, arrayOfByte1, l1);
          break;
        case 68: 
          localIDavEventListener.onInviteReached(str, (int)l1, localDavNativeEventParams.extraParam0, localDavNativeEventParams.detail);
          break;
        case 67: 
          localIDavEventListener.onNetworkInfo_S2C(str, arrayOfByte1, l1);
          break;
        case 66: 
          localIDavEventListener.onNeedShowPeerVideo(str);
          break;
        case 65: 
          localIDavEventListener.onMediaCameraNotify(arrayOfByte1, l1);
          break;
        case 64: 
          localIDavEventListener.onRecvFirstAudioData(true);
          break;
        case 63: 
          localIDavEventListener.onNotRecvAudioData(false);
          break;
        case 62: 
          localIDavEventListener.onNotRecvAudioData(true);
          break;
        case 60: 
        case 61: 
          break;
        case 16: 
          if (l1 == 1L) {
            localIDavEventListener.onNetworkMonitorInfo(str, arrayOfByte2, 1L);
          } else {
            localIDavEventListener.onNetworkMonitorInfo(str, arrayOfByte1, 0L);
          }
          break;
        }
        break;
      case 10: 
        localIDavEventListener.onResumeVideo(str);
        break;
      case 9: 
        localIDavEventListener.onResumeAudio(str);
        break;
      case 8: 
        localIDavEventListener.onPauseVideo(str);
        break;
      case 7: 
        localIDavEventListener.onPauseAudio(str);
        break;
      case 6: 
        i = (int)localDavNativeEventParams.extraParam0;
        k = (int)localDavNativeEventParams.extraParam1;
        l1 = localDavNativeEventParams.extraParam5;
        if (localDavNativeEventParams.extraBuf != null) {
          localObject = new String(localDavNativeEventParams.extraBuf);
        } else {
          localObject = "";
        }
        localIDavEventListener.onChannelReady(str, i, k, (String)localObject, l1);
        break;
      }
    }
    i = (int)l1;
    localIDavEventListener.onGroundGlassWaitTimeChange(str, i);
    if (AVCoreLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EM_SDK_EVENT_ID_GROUND_GLASS_WAIT_TIME, nTime[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], fromUin[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("]");
      AVCoreLog.i("NativeEventHandler", ((StringBuilder)localObject).toString());
      break label2066;
      label1680:
      i = (int)l1;
      localIDavEventListener.onGroundGlassSwitch(str, i);
      if (AVCoreLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("EM_SDK_EVENT_ID_GROUND_GLASS_SWITCH, nSwitch[");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("], fromUin[");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("]");
        AVCoreLog.i("NativeEventHandler", ((StringBuilder)localObject).toString());
        break label2066;
        label1762:
        localIDavEventListener.onDetectAudioDataIssue(4);
        break label2066;
        label1773:
        localIDavEventListener.onDetectAudioDataIssue(3);
        break label2066;
        label1784:
        localIDavEventListener.onAnotherHaveReject(str);
        break label2066;
        label1796:
        localIDavEventListener.onAnotherHaveAccept(str);
        break label2066;
        label1808:
        boolean bool = true;
        i = (int)l1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SdkEventId.EV_VOIP_CLOSED, Param0[");
        ((StringBuilder)localObject).append(localDavNativeEventParams.extraParam0);
        ((StringBuilder)localObject).append("], Param1[");
        ((StringBuilder)localObject).append(localDavNativeEventParams.extraParam1);
        ((StringBuilder)localObject).append("], Param2[");
        ((StringBuilder)localObject).append(localDavNativeEventParams.extraParam2);
        ((StringBuilder)localObject).append("], Param3[");
        ((StringBuilder)localObject).append(localDavNativeEventParams.extraParam3);
        ((StringBuilder)localObject).append("], Param4[");
        ((StringBuilder)localObject).append(localDavNativeEventParams.extraParam4);
        ((StringBuilder)localObject).append("], Param5[");
        ((StringBuilder)localObject).append(localDavNativeEventParams.extraParam5);
        ((StringBuilder)localObject).append("], extraBuf[");
        if (localDavNativeEventParams.extraBuf == null) {
          bool = false;
        }
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("], reason[");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("]");
        AVCoreLog.e("DAVEngineJni_NativeEvent", ((StringBuilder)localObject).toString());
        if (i != 13)
        {
          localIDavEventListener.onCloseVideo(str, i, localDavNativeEventParams.extraParam0);
        }
        else
        {
          localIDavEventListener.onNetworkDisconnect(str);
          break label2066;
          label2045:
          localIDavEventListener.onAcceptedVideo(str);
          break label2066;
          onReceiveRequest(i, localDavNativeEventParams, localIDavEventListener);
        }
      }
    }
    label2066:
    if (j != 0) {
      localAVNativeEventProcessor.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.dav.DavEngineJni.NativeEventHandler
 * JD-Core Version:    0.7.0.1
 */
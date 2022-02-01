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
    byte[] arrayOfByte1 = paramDavNativeEventParams.detail;
    int i = (int)paramDavNativeEventParams.extraParam0;
    String str1 = paramDavNativeEventParams.extraParam2;
    int j = paramDavNativeEventParams.extraParam3;
    int k = paramDavNativeEventParams.extraParam4;
    if (k == 3124) {
      i = 26;
    }
    String str2 = AVCoreUtil.asUnsignedDecimalString(paramDavNativeEventParams.fromUin);
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
        paramIDavEventListener.onRequestVideo(i, str2, (String)localObject1, paramDavNativeEventParams.extraBuf, true, str1, j, k);
        label234:
        if (AVCoreLog.isColorLevel()) {
          AVCoreLog.i("onReceiveRequest", "uinType = " + i + ", extraUin = " + (String)localObject1 + ", longFronUin = " + paramDavNativeEventParams.fromUin);
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
            break label552;
          }
          byte[] arrayOfByte2 = new byte[n];
          localObject1 = null;
          if (arrayOfByte2 != null)
          {
            System.arraycopy(arrayOfByte1, m + 2, arrayOfByte2, 0, n);
            localObject1 = new String(arrayOfByte2);
          }
          if ((localObject1 == null) || (localObject2 == null)) {
            break label549;
          }
          localObject1 = (String)localObject2 + (String)localObject1;
        }
      }
    }
    for (;;)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.i("onReceiveRequest", "uinType = " + i + ", extraUin = " + (String)localObject1);
      }
      break;
      localObject1 = String.valueOf(paramDavNativeEventParams.extraParam1);
      break;
      if ((paramInt != 1) && (paramInt != 61)) {
        break label234;
      }
      paramIDavEventListener.onRequestVideo(i, str2, (String)localObject1, paramDavNativeEventParams.extraBuf, false, str1, j, k);
      break label234;
      label549:
      continue;
      label552:
      localObject1 = null;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    IDavEventListener localIDavEventListener = (IDavEventListener)this.mEventLisRef.get();
    if (localIDavEventListener == null) {
      return;
    }
    int i = paramMessage.what;
    Object localObject1 = (DavNativeEventParams)paramMessage.obj;
    if (localObject1 == null)
    {
      AVCoreLog.printErrorLog("DAVEngineJni_NativeEvent", "p is null");
      return;
    }
    Object localObject2 = ((DavNativeEventParams)localObject1).detail;
    long l1 = ((DavNativeEventParams)localObject1).info;
    String str = AVCoreUtil.asUnsignedDecimalString(((DavNativeEventParams)localObject1).fromUin);
    byte[] arrayOfByte = ((DavNativeEventParams)localObject1).extraBuf;
    if ((i != 16) && (i != 100) && (i != 117) && (i != 120) && (i != 124) && (i != 125)) {
      AVCoreLog.printAllUserLog("DAVEngineJni_NativeEvent", "handleMessage eventId[" + i + "], info[" + l1 + "], fromUin[" + str + "]");
    }
    AVNativeEventProcessor localAVNativeEventProcessor = (AVNativeEventProcessor)this.mCallback.get();
    int j;
    if ((localAVNativeEventProcessor != null) && (localAVNativeEventProcessor.isMsgNeedExtraDeal(i)))
    {
      j = 1;
      label191:
      if (j != 0) {
        ((DavNativeEventParams)localObject1).elapsedRealtime = SystemClock.elapsedRealtime();
      }
      switch (i)
      {
      case 5: 
      case 11: 
      case 12: 
      case 15: 
      case 17: 
      case 23: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 44: 
      case 45: 
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
      case 70: 
      case 71: 
      case 77: 
      case 78: 
      case 79: 
      case 80: 
      case 81: 
      case 82: 
      case 84: 
      case 85: 
      case 86: 
      case 87: 
      case 88: 
      case 89: 
      case 90: 
      case 93: 
      case 94: 
      case 96: 
      case 97: 
      case 98: 
      case 99: 
      case 101: 
      case 102: 
      case 103: 
      case 104: 
      case 109: 
      case 111: 
      case 112: 
      case 115: 
      case 117: 
      case 120: 
      case 121: 
      case 122: 
      default: 
        if (localAVNativeEventProcessor != null) {
          localAVNativeEventProcessor.handleMessage(paramMessage);
        }
        break;
      }
    }
    label738:
    while (j != 0)
    {
      localAVNativeEventProcessor.handleMessage(paramMessage);
      return;
      j = 0;
      break label191;
      onReceiveRequest(i, (DavNativeEventParams)localObject1, localIDavEventListener);
      continue;
      localIDavEventListener.onAcceptedVideo(str);
      continue;
      i = (int)l1;
      localObject2 = new StringBuilder().append("SdkEventId.EV_VOIP_CLOSED, Param0[").append(((DavNativeEventParams)localObject1).extraParam0).append("], Param1[").append(((DavNativeEventParams)localObject1).extraParam1).append("], Param2[").append(((DavNativeEventParams)localObject1).extraParam2).append("], Param3[").append(((DavNativeEventParams)localObject1).extraParam3).append("], Param4[").append(((DavNativeEventParams)localObject1).extraParam4).append("], Param5[").append(((DavNativeEventParams)localObject1).extraParam5).append("], extraBuf[");
      if (((DavNativeEventParams)localObject1).extraBuf != null) {}
      for (boolean bool = true;; bool = false)
      {
        AVCoreLog.e("DAVEngineJni_NativeEvent", bool + "], reason[" + i + "]");
        switch (i)
        {
        default: 
          localIDavEventListener.onCloseVideo(str, i, ((DavNativeEventParams)localObject1).extraParam0);
          break label738;
        }
      }
      localIDavEventListener.onNetworkDisconnect(str);
      continue;
      i = (int)((DavNativeEventParams)localObject1).extraParam0;
      int k = (int)((DavNativeEventParams)localObject1).extraParam1;
      l1 = ((DavNativeEventParams)localObject1).extraParam5;
      if (((DavNativeEventParams)localObject1).extraBuf != null) {}
      for (localObject1 = new String(((DavNativeEventParams)localObject1).extraBuf);; localObject1 = "")
      {
        localIDavEventListener.onChannelReady(str, i, k, (String)localObject1, l1);
        break;
      }
      if (l1 == 1L)
      {
        localIDavEventListener.onNetworkMonitorInfo(str, arrayOfByte, 1L);
      }
      else
      {
        localIDavEventListener.onNetworkMonitorInfo(str, (byte[])localObject2, 0L);
        continue;
        localIDavEventListener.onAudioVolumeChange(((DavNativeEventParams)localObject1).extraParam0, 0L, 100L);
        continue;
        localIDavEventListener.onCloseVideo(str, 12, 0L);
        continue;
        localIDavEventListener.onPauseVideo(str);
        continue;
        localIDavEventListener.onResumeVideo(str);
        continue;
        localIDavEventListener.onPauseAudio(str);
        continue;
        localIDavEventListener.onResumeAudio(str);
        continue;
        localIDavEventListener.onAnotherHaveAccept(str);
        continue;
        localIDavEventListener.onAnotherHaveReject(str);
        continue;
        localIDavEventListener.onConfigSysDealDone(str);
        continue;
        localIDavEventListener.onAVShiftEvent(i - 19, str);
        continue;
        localIDavEventListener.onAnotherIsRing(str, true);
        continue;
        localIDavEventListener.onAnotherIsRing(str, false);
        continue;
        localIDavEventListener.onRequestVideoMode(str);
        continue;
        localIDavEventListener.onAcceptVideoMode(str);
        continue;
        localIDavEventListener.onRejectVideoMode(str);
        continue;
        localIDavEventListener.onCancelVideoMode(str);
        continue;
        localIDavEventListener.onNotRecvAudioData(true);
        continue;
        localIDavEventListener.onNotRecvAudioData(false);
        continue;
        localIDavEventListener.onMediaCameraNotify((byte[])localObject2, l1);
        continue;
        localIDavEventListener.onNeedShowPeerVideo(str);
        continue;
        localIDavEventListener.onPstnCallConnected(str, (int)l1, ((DavNativeEventParams)localObject1).extraParam0, ((DavNativeEventParams)localObject1).detail);
        continue;
        localIDavEventListener.onInviteReached(str, (int)l1, ((DavNativeEventParams)localObject1).extraParam0, ((DavNativeEventParams)localObject1).detail);
        continue;
        localIDavEventListener.onNetworkInfo_S2C(str, (byte[])localObject2, l1);
        continue;
        localIDavEventListener.onSwitchGroup(str, (byte[])localObject2, l1);
        continue;
        localIDavEventListener.onSwitchMeeting(str, (byte[])localObject2, l1);
        continue;
        switch ((int)((DavNativeEventParams)localObject1).extraParam0)
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          AVCoreLog.e("DAVEngineJni_NativeEvent", "SdkEventId.EV_VOIP_OTHER_TER_CHATING_STAUTS, type[" + ((DavNativeEventParams)localObject1).extraParam0 + "]");
          localIDavEventListener.onOtherTerminalChatingStatus(str, ((DavNativeEventParams)localObject1).extraParam1, i);
          break;
          i = 2;
          continue;
          i = 1;
        }
        localIDavEventListener.onPeerSwitchTerminal(str, (int)((DavNativeEventParams)localObject1).extraParam0, (int)((DavNativeEventParams)localObject1).extraParam1, ((DavNativeEventParams)localObject1).extraParam5);
        continue;
        localIDavEventListener.onSyncOtherTerminalChatStatus(str, (int)l1);
        continue;
        i = (int)((DavNativeEventParams)localObject1).extraParam0;
        k = (int)((DavNativeEventParams)localObject1).extraParam1;
        long l2 = ((DavNativeEventParams)localObject1).extraParam5;
        if (((DavNativeEventParams)localObject1).extraBuf != null) {}
        for (localObject1 = new String(((DavNativeEventParams)localObject1).extraBuf);; localObject1 = "")
        {
          localIDavEventListener.onSwitchTerminalSuccess(str, (int)l1, i, k, (String)localObject1, l2);
          break;
        }
        localIDavEventListener.onPeerSwitchTerminalFail(str, (int)l1);
        continue;
        localIDavEventListener.onSendC2CMsg(str);
        localIDavEventListener.onDetectAudioDataIssue(2048);
        continue;
        localIDavEventListener.onDetectAudioDataIssue(3);
        continue;
        localIDavEventListener.onDetectAudioDataIssue(4);
        continue;
        localIDavEventListener.onNetLevel_S2C(str, l1, (byte[])localObject2);
        continue;
        localIDavEventListener.receiveTransferMsg(str, (int)l1, ((DavNativeEventParams)localObject1).detail);
        continue;
        i = (int)l1;
        localIDavEventListener.onGroundGlassSwitch(str, i);
        if (AVCoreLog.isColorLevel())
        {
          AVCoreLog.i("NativeEventHandler", "EM_SDK_EVENT_ID_GROUND_GLASS_SWITCH, nSwitch[" + i + "], fromUin[" + str + "]");
          continue;
          i = (int)l1;
          localIDavEventListener.onGroundGlassWaitTimeChange(str, i);
          if (AVCoreLog.isColorLevel())
          {
            AVCoreLog.i("NativeEventHandler", "EM_SDK_EVENT_ID_GROUND_GLASS_WAIT_TIME, nTime[" + i + "], fromUin[" + str + "]");
            continue;
            localIDavEventListener.onFpsChange((int)l1);
            continue;
            AVCoreLog.e("NativeEventHandler", "EM_SDK_EVENT_ID_CUSTOM_COMMAND, peerUin[" + str + "]");
            localIDavEventListener.onSDKCustomCommand(str, ((DavNativeEventParams)localObject1).extraParam0, ((DavNativeEventParams)localObject1).extraParam1, ((DavNativeEventParams)localObject1).extraParam4);
            continue;
            AVCoreLog.e("NativeEventHandler", "NETWORK_CHECK, peerUin[" + str + "]");
            localIDavEventListener.checkNetStatus();
            continue;
            localIDavEventListener.onRecvFirstAudioData(true);
            continue;
            localIDavEventListener.onNetworkQualityChanged((int)((DavNativeEventParams)localObject1).extraParam0);
            continue;
            localIDavEventListener.onAvReqAutoAccept(str);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.dav.DavEngineJni.NativeEventHandler
 * JD-Core Version:    0.7.0.1
 */
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
    int k = paramMessage.what;
    DavNativeEventParams localDavNativeEventParams = (DavNativeEventParams)paramMessage.obj;
    if (localDavNativeEventParams == null)
    {
      AVCoreLog.printErrorLog("DAVEngineJni_NativeEvent", "p is null");
      return;
    }
    byte[] arrayOfByte = localDavNativeEventParams.detail;
    long l1 = localDavNativeEventParams.info;
    String str = AVCoreUtil.asUnsignedDecimalString(localDavNativeEventParams.fromUin);
    Object localObject = localDavNativeEventParams.extraBuf;
    if ((k != 16) && (k != 100) && (k != 117) && (k != 120) && (k != 124) && (k != 125))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage eventId[");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append("], info[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("], fromUin[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("]");
      AVCoreLog.printAllUserLog("DAVEngineJni_NativeEvent", ((StringBuilder)localObject).toString());
    }
    AVNativeEventProcessor localAVNativeEventProcessor = (AVNativeEventProcessor)this.mCallback.get();
    int i = 1;
    int j;
    if ((localAVNativeEventProcessor != null) && (localAVNativeEventProcessor.isMsgNeedExtraDeal(k))) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      localDavNativeEventParams.elapsedRealtime = SystemClock.elapsedRealtime();
    }
    if ((k != 1) && (k != 2))
    {
      if (k == 3) {
        break label2169;
      }
      if (k == 4) {
        break label1935;
      }
      if (k == 13) {
        break label1923;
      }
      if (k == 14) {
        break label1911;
      }
      if (k == 91) {
        break label1900;
      }
      if (k == 92) {
        break label1889;
      }
      if (k == 113) {
        break label1806;
      }
      if (k == 114) {
        break label1723;
      }
      localObject = "";
      switch (k)
      {
      default: 
        switch (k)
        {
        default: 
          switch (k)
          {
          default: 
            switch (k)
            {
            default: 
              switch (k)
              {
              default: 
                switch (k)
                {
                default: 
                  if (localAVNativeEventProcessor != null) {
                    localAVNativeEventProcessor.handleMessage(paramMessage);
                  }
                  break;
                }
                break;
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      break label2191;
      localIDavEventListener.onCancelVideoMode(str);
      continue;
      localIDavEventListener.onRejectVideoMode(str);
      continue;
      localIDavEventListener.onAcceptVideoMode(str);
      continue;
      localIDavEventListener.onRequestVideoMode(str);
      continue;
      localIDavEventListener.onPeerSwitchTerminalFail(str, (int)l1);
      continue;
      localIDavEventListener.onSyncOtherTerminalChatStatus(str, (int)l1);
      continue;
      i = (int)localDavNativeEventParams.extraParam0;
      k = (int)localDavNativeEventParams.extraParam1;
      long l2 = localDavNativeEventParams.extraParam5;
      if (localDavNativeEventParams.extraBuf != null) {
        localObject = new String(localDavNativeEventParams.extraBuf);
      }
      localIDavEventListener.onSwitchTerminalSuccess(str, (int)l1, i, k, (String)localObject, l2);
      continue;
      localIDavEventListener.onPeerSwitchTerminal(str, (int)localDavNativeEventParams.extraParam0, (int)localDavNativeEventParams.extraParam1, localDavNativeEventParams.extraParam5);
      continue;
      k = (int)localDavNativeEventParams.extraParam0;
      if (k != 1)
      {
        if (k != 2) {
          i = 0;
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
      continue;
      localIDavEventListener.onAnotherIsRing(str, false);
      continue;
      localIDavEventListener.onAnotherIsRing(str, true);
      continue;
      localIDavEventListener.onCloseVideo(str, 12, 0L);
      continue;
      localIDavEventListener.onAVShiftEvent(k - 19, str);
      continue;
      localIDavEventListener.onConfigSysDealDone(str);
      continue;
      i = (int)localDavNativeEventParams.extraParam0;
      k = (int)localDavNativeEventParams.extraParam1;
      int m = (int)localDavNativeEventParams.extraParam5;
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localIDavEventListener.onNotifyRecvAvatar2dSwitchPeer(str, bool, k, m, arrayOfByte);
      continue;
      localIDavEventListener.onResponseRecvAvatar2dSwitch(str, (int)localDavNativeEventParams.extraParam0, arrayOfByte);
      continue;
      localIDavEventListener.onNotifyRecvAvatar2d(str, arrayOfByte);
      continue;
      if ((int)localDavNativeEventParams.extraParam0 == 1)
      {
        localIDavEventListener.onNotifyAIDenoiseTips(true);
      }
      else
      {
        localIDavEventListener.onNotifyAIDenoiseTips(false);
        continue;
        localIDavEventListener.onSwitchMeeting(str, arrayOfByte, l1);
        continue;
        localIDavEventListener.onAudioVolumeChange(localDavNativeEventParams.extraParam0, 0L, 100L);
        continue;
        localIDavEventListener.onNetworkQualityChanged((int)localDavNativeEventParams.extraParam0);
        continue;
        localIDavEventListener.onAvReqAutoAccept(str);
        continue;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("EM_SDK_EVENT_ID_CUSTOM_COMMAND, peerUin[");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("]");
        AVCoreLog.e("NativeEventHandler", ((StringBuilder)localObject).toString());
        localIDavEventListener.onSDKCustomCommand(str, localDavNativeEventParams.extraParam0, localDavNativeEventParams.extraParam1, localDavNativeEventParams.extraParam4);
        continue;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("NETWORK_CHECK, peerUin[");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("]");
        AVCoreLog.e("NativeEventHandler", ((StringBuilder)localObject).toString());
        localIDavEventListener.checkNetStatus();
        continue;
        localIDavEventListener.onFpsChange((int)l1);
        continue;
        localIDavEventListener.receiveTransferMsg(str, (int)l1, localDavNativeEventParams.detail);
        continue;
        localIDavEventListener.onNetLevel_S2C(str, l1, arrayOfByte);
        continue;
        localIDavEventListener.onPstnCallConnected(str, (int)l1, localDavNativeEventParams.extraParam0, localDavNativeEventParams.detail);
        continue;
        localIDavEventListener.onSendC2CMsg(str);
        localIDavEventListener.onDetectAudioDataIssue(2048);
        localIDavEventListener.onInitAIDenoiseStatus();
        continue;
        localIDavEventListener.onSwitchGroup(str, arrayOfByte, l1);
        continue;
        localIDavEventListener.onInviteReached(str, (int)l1, localDavNativeEventParams.extraParam0, localDavNativeEventParams.detail);
        continue;
        localIDavEventListener.onNetworkInfo_S2C(str, arrayOfByte, l1);
        continue;
        localIDavEventListener.onNeedShowPeerVideo(str);
        continue;
        localIDavEventListener.onMediaCameraNotify(arrayOfByte, l1);
        continue;
        localIDavEventListener.onRecvFirstAudioData(true);
        continue;
        localIDavEventListener.onNotRecvAudioData(false);
        continue;
        localIDavEventListener.onNotRecvAudioData(true);
        continue;
        break;
        localIDavEventListener.onStateInfo(str, arrayOfByte);
        continue;
        localIDavEventListener.onResumeVideo(str);
        continue;
        localIDavEventListener.onResumeAudio(str);
        continue;
        localIDavEventListener.onPauseVideo(str);
        continue;
        localIDavEventListener.onPauseAudio(str);
        continue;
        i = (int)localDavNativeEventParams.extraParam0;
        k = (int)localDavNativeEventParams.extraParam1;
        l1 = localDavNativeEventParams.extraParam5;
        if (localDavNativeEventParams.extraBuf != null) {
          localObject = new String(localDavNativeEventParams.extraBuf);
        } else {
          localObject = "";
        }
        localIDavEventListener.onChannelReady(str, i, k, (String)localObject, l1);
        continue;
        label1723:
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
          continue;
          label1806:
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
            continue;
            label1889:
            localIDavEventListener.onDetectAudioDataIssue(4);
            continue;
            label1900:
            localIDavEventListener.onDetectAudioDataIssue(3);
            continue;
            label1911:
            localIDavEventListener.onAnotherHaveReject(str);
            continue;
            label1923:
            localIDavEventListener.onAnotherHaveAccept(str);
          }
        }
      }
    }
    label1935:
    boolean bool = false;
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
    if (localDavNativeEventParams.extraBuf != null) {
      bool = true;
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
      break label2191;
      label2169:
      localIDavEventListener.onAcceptedVideo(str);
      break label2191;
      onReceiveRequest(k, localDavNativeEventParams, localIDavEventListener);
    }
    label2191:
    if (j != 0) {
      localAVNativeEventProcessor.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.dav.DavEngineJni.NativeEventHandler
 * JD-Core Version:    0.7.0.1
 */
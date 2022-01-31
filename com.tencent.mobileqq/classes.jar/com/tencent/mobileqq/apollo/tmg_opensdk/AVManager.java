package com.tencent.mobileqq.apollo.tmg_opensdk;

import android.content.Context;
import android.util.Log;
import com.tencent.TMG.channel.AVAppChannel;
import com.tencent.TMG.channel.AVChannelManager;
import com.tencent.TMG.logger.AVLoggerChooser;
import com.tencent.TMG.sdk.AVAudioCtrl;
import com.tencent.TMG.sdk.AVAudioCtrl.EnableMicCompleteCallback;
import com.tencent.TMG.sdk.AVAudioCtrl.EnableSpeakerCompleteCallback;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.TMG.sdk.AVCustomSpearEngineCtrl;
import com.tencent.TMG.sdk.AVRoomMulti.EnterParam;
import com.tencent.TMG.sdk.AVRoomMulti.EnterParam.Builder;
import com.tencent.TMG.sdk.AVRoomMulti.EventListener;
import com.tencent.qphone.base.util.QLog;
import ysf;

public class AVManager
{
  private static AVManager jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager;
  private static String b = "LimixiuAVManager";
  private Context jdField_a_of_type_AndroidContentContext;
  public AVContext a;
  private AVRoomMulti.EventListener jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener = new ysf(this);
  AVManager.AppInfo jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$AppInfo = null;
  public AVManager.EnterRoomCallback a;
  public AVManager.RoomInfoListener a;
  String jdField_a_of_type_JavaLangString = null;
  
  private AVManager(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentTMGSdkAVContext = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$EnterRoomCallback = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$RoomInfoListener = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = "user";
  }
  
  private AVContext.StartParam a()
  {
    AVEngineStartParams localAVEngineStartParams = new AVEngineStartParams();
    localAVEngineStartParams.sdkAppId = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$AppInfo.jdField_a_of_type_JavaLangString);
    localAVEngineStartParams.accountType = this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$AppInfo.b;
    localAVEngineStartParams.appIdAt3rd = this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$AppInfo.jdField_a_of_type_JavaLangString;
    localAVEngineStartParams.identifier = this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$AppInfo.c;
    localAVEngineStartParams.engineCtrlType = 2;
    localAVEngineStartParams.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$AppInfo.f).intValue();
    localAVEngineStartParams.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$AppInfo.g).longValue();
    QLog.i("AVManager", 1, "getStartParams|param.sdkAppId=" + localAVEngineStartParams.sdkAppId + ", param.accountType=" + localAVEngineStartParams.accountType + ", param.appIdAt3rd=" + localAVEngineStartParams.appIdAt3rd + ", param.identifier=" + localAVEngineStartParams.identifier + ", param.engineCtrlType=" + localAVEngineStartParams.engineCtrlType + ", param.nGameID=" + localAVEngineStartParams.jdField_a_of_type_Int + ", param.lGameRoomID=" + localAVEngineStartParams.jdField_a_of_type_Long);
    return localAVEngineStartParams;
  }
  
  private AVRoomMulti.EnterParam a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    QLog.e("AVManager", 1, "getEnterRoomParam roomID=" + paramString + ", roomRoleValue=" + str + ", videoRecvMode=" + paramInt + ", screenRecMode=" + 0 + ", mic=" + paramBoolean1 + ", speaker=" + paramBoolean2);
    return new AVRoomMulti.EnterParam.Builder(Integer.parseInt(paramString)).avControlRole(str).autoCreateRoom(true).videoRecvMode(paramInt).screenRecvMode(0).isEnableMic(paramBoolean1).isEnableSpeaker(paramBoolean2).isEnableHwEnc(true).isEnableHwDec(true).build();
  }
  
  public static AVManager a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager == null) {
        jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager = new AVManager(paramContext);
      }
      return jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager;
    }
    finally {}
  }
  
  public int a()
  {
    int i = 1003;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      i = this.jdField_a_of_type_ComTencentTMGSdkAVContext.stop();
    }
    QLog.i("AVManager", 1, "stopContext|ret=" + i);
    return i;
  }
  
  public AVContext a()
  {
    return this.jdField_a_of_type_ComTencentTMGSdkAVContext;
  }
  
  public AVCustomSpearEngineCtrl a()
  {
    return a().getCustomSpearEngineCtrl();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.destroy();
    }
    this.jdField_a_of_type_ComTencentTMGSdkAVContext = null;
    QLog.e("AVManager", 1, "destroyContext");
  }
  
  public void a(long paramLong)
  {
    QLog.i("AVManager", 1, "setGameRoomID|lGameRoomID=" + paramLong);
    this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$AppInfo.g = String.valueOf(paramLong);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(AVCallback paramAVCallback)
  {
    int i = 0;
    AVChannelManager.setIMChannelType(2);
    com.tencent.TMG.utils.SoUtil.customLibPath = TMG_Downloader.a();
    AVLoggerChooser.setUseImsdk(false);
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null) {
      this.jdField_a_of_type_ComTencentTMGSdkAVContext = AVContext.createInstance(this.jdField_a_of_type_AndroidContentContext, false);
    }
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null) {
      if (AVContext.getSoExtractError() != 0) {
        i = AVContext.getSoExtractError();
      }
    }
    for (;;)
    {
      QLog.i("AVManager", 1, "startContext|ret=" + i);
      if (i != 0) {
        paramAVCallback.onComplete(i, "internal error.");
      }
      return;
      i = 1101;
      continue;
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.setAppVersion(this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$AppInfo.e);
      AVChannelManager.setAppChannel(new SSOChannel());
      AVChannelManager.getAppChannel().loginWithParam(a());
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.start(a(), null, paramAVCallback);
    }
  }
  
  public void a(AVManager.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$AppInfo = paramAppInfo;
  }
  
  public void a(AVManager.RoomInfoListener paramRoomInfoListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$RoomInfoListener = paramRoomInfoListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, AVManager.EnterRoomCallback paramEnterRoomCallback)
  {
    QLog.i("AVManager", 1, "enterRoom.");
    this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$EnterRoomCallback = paramEnterRoomCallback;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null)
    {
      Log.e("AVManager", "enterRoom| enter room faild, because of context not started.");
      if (this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$EnterRoomCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$EnterRoomCallback.a(1101, "context not started.");
      }
      return;
    }
    AVChannelManager.getAppChannel().loginWithParam(a());
    this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl().startTRAEService();
    QLog.e("AVManager", 1, "enterRoom| try enter room implement!!!!!!!!!");
    this.jdField_a_of_type_ComTencentTMGSdkAVContext.enterRoom(this.jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener, a(paramString, paramBoolean1, paramBoolean2, paramInt));
  }
  
  public void a(boolean paramBoolean, AVAudioCtrl.EnableMicCompleteCallback paramEnableMicCompleteCallback)
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {
      localAVAudioCtrl.enableMic(paramBoolean, paramEnableMicCompleteCallback);
    }
  }
  
  public void a(boolean paramBoolean, AVAudioCtrl.EnableSpeakerCompleteCallback paramEnableSpeakerCompleteCallback)
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {
      localAVAudioCtrl.enableSpeaker(paramBoolean, paramEnableSpeakerCompleteCallback);
    }
  }
  
  public int b()
  {
    int i = 1003;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      i = this.jdField_a_of_type_ComTencentTMGSdkAVContext.exitRoom();
    }
    QLog.i("AVManager", 1, "exitRoom|ret=" + i);
    return i;
  }
  
  public void b()
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null)
    {
      localAVAudioCtrl.PauseAudioByUser();
      localAVAudioCtrl.stopTRAEService();
    }
  }
  
  public void b(long paramLong)
  {
    QLog.i("AVManager", 1, "setGameID|lGameID=" + paramLong);
    this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVManager$AppInfo.f = String.valueOf(paramLong);
  }
  
  public void c()
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null)
    {
      localAVAudioCtrl.ResumeAudioByUser();
      localAVAudioCtrl.startTRAEService();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.tmg_opensdk.AVManager
 * JD-Core Version:    0.7.0.1
 */
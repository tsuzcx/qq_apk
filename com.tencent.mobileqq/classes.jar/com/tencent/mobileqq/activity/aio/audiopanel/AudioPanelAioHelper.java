package com.tencent.mobileqq.activity.aio.audiopanel;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevAudioMsgProcessor;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatDemoChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.ptt.IQQRecorder;
import com.tencent.mobileqq.ptt.IQQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.pttlogic.api.IPttSSCMPool;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceHelper;
import com.tencent.mobileqq.qqexpand.chat.IAioVoicePlayerManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PlayModeUtils;
import com.tencent.mobileqq.utils.PttUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.voicechange.IVoiceTuneUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class AudioPanelAioHelper
  implements Handler.Callback, View.OnClickListener, MediaPlayerManager.Listener, OnFinishListener, ILifeCycleHelper
{
  public static boolean a = false;
  protected int a;
  public long a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  public View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected IQQRecorder a;
  public ToastStyleDialog a;
  public String a;
  public int b;
  public ToastStyleDialog b;
  public boolean b;
  private int c = 0;
  
  public AudioPanelAioHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
    paramBaseChatPie.b().a().a(this);
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = PlayModeUtils.b(paramBoolean1, paramBoolean2, paramBoolean3);
    if (i > 0) {
      QQToast.a(paramContext, i, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
    }
  }
  
  private void j()
  {
    IQQRecorder localIQQRecorder = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    if (localIQQRecorder != null) {
      localIQQRecorder.a(null);
    }
  }
  
  private void k()
  {
    XPanelContainer localXPanelContainer = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    AudioPanel localAudioPanel = (AudioPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().b(2);
    this.jdField_b_of_type_Boolean = AudioDeviceHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localXPanelContainer != null) && (localXPanelContainer.a() == 2) && (localAudioPanel != null) && (localAudioPanel.getVisibility() == 0)) {
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  private void l()
  {
    ((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(2)).d();
    ((VoiceTextEditPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(36)).b();
  }
  
  private void m()
  {
    ((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(2)).c();
    ((VoiceTextEditPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(36)).a();
    this.c = 0;
    Object localObject1 = a();
    if (localObject1 != null)
    {
      ((MediaPlayerManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      ((MediaPlayerManager)localObject1).a(true);
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog;
    if ((localObject3 != null) && (((ToastStyleDialog)localObject3).isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
    }
    localObject3 = this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog;
    if ((localObject3 != null) && (((ToastStyleDialog)localObject3).isShowing()) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
    }
    localObject3 = this.jdField_a_of_type_AndroidViewView;
    if (localObject3 != null)
    {
      ((View)localObject3).setVisibility(4);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    if (localObject1 != null) {
      ((MediaPlayerManager)localObject1).f();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    if (localObject1 != null) {
      ((IQQRecorder)localObject1).a();
    }
    try
    {
      ((IPttSSCMPool)QRoute.api(IPttSSCMPool.class)).clear();
      return;
    }
    finally {}
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMusicItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  public int a()
  {
    return 0;
  }
  
  protected MediaPlayerManager a()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return null;
    }
    return (MediaPlayerManager)localQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
  }
  
  protected void a()
  {
    this.jdField_b_of_type_Boolean = AudioDeviceHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("open_chat_from_voice_changer_guide", false);
    AudioPanelProvider localAudioPanelProvider = (AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(2);
    localAudioPanelProvider.d = true;
    localAudioPanelProvider.a(bool);
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie instanceof HotChatDemoChatPie))
    {
      localAudioPanelProvider.c = true;
      return;
    }
    if ((localBaseChatPie instanceof NearbyChatPie)) {
      localAudioPanelProvider.c = ((NearbyChatPie)localBaseChatPie).t();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setVolumeControlStream(3);
    b(false, false);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    PttUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt1, paramInt2);
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie instanceof BusinessCmrTmpChatPie)) {
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008AAA", "C_Master_PTT", localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, AudioPanelProvider.a(paramInt1), paramInt2);
    }
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        if (paramString != null)
        {
          paramString = StreamDataManager.a(paramString);
          if ((paramString != null) && (paramString.exists())) {
            paramString.delete();
          }
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().hasMessages(16711688)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().sendEmptyMessageDelayed(16711688, 1000L);
        }
        if (paramLong != 0L)
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
          paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramString, paramInt, paramLong);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(true, false);
      }
    }
    else if ((paramString != null) && (paramLong != 0L))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("disPlayAudioRecord updatePttRecordMessage: ");
        localStringBuilder.append(paramString);
        QLog.i("QQRecorder", 2, localStringBuilder.toString());
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, -3, paramLong);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(true, true);
    }
  }
  
  public void a(IQQRecorder.OnQQRecorderListener paramOnQQRecorderListener, boolean paramBoolean, RecordParams.RecorderParam paramRecorderParam)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().hasMessages(16711688))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(16711688);
      a(0, null, -1L);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(16711688);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(16711686);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(16711687);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ag();
    Object localObject1 = a();
    if (localObject1 != null) {
      ((MediaPlayerManager)localObject1).a(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanelAioHelper", 2, "startRecord() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
    if (this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext);
    }
    if (((paramOnQQRecorderListener instanceof PressToSpeakPanel)) && (((PressToSpeakPanel)paramOnQQRecorderListener).b()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject1).append("ppt/");
      localObject1 = RmVFSUtils.getVFSPath(((StringBuilder)localObject1).toString(), true);
      Object localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdir();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("pcmforvad.pcm");
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a(paramRecorderParam);
    localObject1 = TransFileUtil.getTransferFilePath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, 2, null, false);
    paramRecorderParam = MessageForPtt.getLocalFilePath(paramRecorderParam.c, (String)localObject1);
    if (!((String)localObject1).equals(paramRecorderParam)) {
      new File((String)localObject1).deleteOnExit();
    } else {
      paramRecorderParam = (RecordParams.RecorderParam)localObject1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("path: ");
      ((StringBuilder)localObject1).append(paramRecorderParam);
      QLog.i("QQRecorder", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a(paramOnQQRecorderListener);
    if (QLog.isColorLevel())
    {
      paramOnQQRecorderListener = new StringBuilder();
      paramOnQQRecorderListener.append("QQRecorder start() is called,time is:");
      paramOnQQRecorderListener.append(System.currentTimeMillis());
      QLog.d("AudioPanelAioHelper", 2, paramOnQQRecorderListener.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a(paramRecorderParam, paramBoolean);
    int i = this.jdField_b_of_type_Int;
    if (i >= 0) {
      this.jdField_b_of_type_Int = (i + 1);
    }
  }
  
  public void a(String paramString)
  {
    a(2, paramString, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new AudioPanelAioHelper.4(this));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    ThreadManager.postImmediately(new AudioPanelAioHelper.6(this), null, false);
    if (!((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(118)).jdField_a_of_type_Boolean)
    {
      a(paramString, this.jdField_a_of_type_Long, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean, paramInt4);
      return;
    }
    ReceiptMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().runOnUiThread(new AudioPanelAioHelper.7(this));
  }
  
  public void a(String paramString, int paramInt, RecordParams.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(36, true);
    ((VoiceTextEditPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(36)).a(paramString, paramInt, paramRecorderParam);
  }
  
  public void a(String paramString1, int paramInt, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    Object localObject = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, localSessionInfo, -2, paramRecorderParam.c);
    if (localObject != null)
    {
      ((MessageForPtt)localObject).c2cViaOffline = true;
      long l = ((MessageRecord)localObject).uniseq;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo.jdField_a_of_type_Int, localSessionInfo.jdField_a_of_type_JavaLangString, paramString1, l, false, paramInt, paramRecorderParam.c, true, 0, 4, false, paramRecorderParam.d, (Bundle)localObject);
      a(0, paramString1, l);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B16", "0X8005B16", 0, 0, "", "", paramString2, "8.7.0");
      paramString1 = StatisticCollector.getInstance(BaseApplication.getContext());
      paramRecorderParam = new HashMap();
      paramRecorderParam.put("param_FailCode", String.valueOf(0));
      paramRecorderParam.put("inputname", paramString2);
      paramRecorderParam.put(BaseConstants.RDM_NoChangeFailCode, "");
      paramString1.collectPerformance("", "sendPttEventFromIME", false, 0L, 0L, paramRecorderParam, "");
    }
  }
  
  protected void a(String paramString, long paramLong, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject instanceof TroopChatPie))
    {
      b(paramString, paramLong, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean, paramInt4);
      return;
    }
    if ((localObject instanceof DeviceMsgChatPie))
    {
      c(paramString, paramLong, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean, paramInt4);
      return;
    }
    if ((paramInt1 != 2) && (paramInt1 != 1)) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool;
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendPttInner(),recordingUniseq is:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",path is:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    long l = SystemClock.uptimeMillis();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str1 = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
    if (i == 0)
    {
      localObject = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (SessionInfo)localObject, -2, paramRecorderParam.c);
      if (localObject == null) {
        return;
      }
      ((MessageForPtt)localObject).c2cViaOffline = bool;
      paramLong = ((MessageRecord)localObject).uniseq;
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(str1, 0, paramLong);
      if ((localObject instanceof MessageForPtt)) {
        ((MessageForPtt)localObject).voiceLength = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(paramInt2);
      }
    }
    if ((localObject instanceof MessageForPtt))
    {
      localObject = (MessageForPtt)localObject;
      ((MessageForPtt)localObject).waveformArray = PttAudioWaveView.a(paramRecorderParam.jdField_a_of_type_ArrayOfInt, paramRecorderParam.f);
      if (!StringUtil.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
        ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
      }
    }
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).putPttSendCostRecorder(paramString, Long.valueOf(l));
    if (!bool)
    {
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
    }
    else
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recordingUniseq is:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (jdField_a_of_type_Boolean) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", i, 0, "", "", "", "8.7.0");
    jdField_a_of_type_Boolean = true;
    int i = AudioPanelProvider.a(paramInt1);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
    ArrayList localArrayList = new ArrayList();
    String str2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, str1, paramString, paramLong, false, paramInt2, paramRecorderParam.c, bool, paramInt3, i, paramBoolean, paramRecorderParam.d, (Bundle)localObject, localArrayList, str2, false, paramInt4);
    a(paramInt1, paramInt2);
    a(0, paramString, paramLong);
  }
  
  protected void a(String paramString, long paramLong, boolean paramBoolean, RecordParams.RecorderParam paramRecorderParam)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelSendPttInner(),recordingUniseq is:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",path is:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    a(2, paramString, paramLong);
    int i;
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      StreamDataManager.a(paramString, true);
      StreamDataManager.a(paramString);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
      StreamDataManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong, true, 0, paramRecorderParam.c, paramRecorderParam.d, (Bundle)localObject);
      return;
    }
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(paramString);
  }
  
  public void a(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    int i = 1;
    localBaseChatPie.b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ah();
    g(0);
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanelAioHelper", 2, "recorderEnd() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    if (paramRecorderParam != null)
    {
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        i = 0;
      }
      if (i == 0)
      {
        StreamDataManager.a(paramString, false);
        StreamDataManager.a(paramString);
        return;
      }
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
    }
  }
  
  public void a(String paramString, boolean paramBoolean, RecordParams.RecorderParam paramRecorderParam)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof DeviceMsgChatPie))
    {
      b(paramString, paramBoolean, paramRecorderParam);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRecorderPerpare path = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQRecorder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    int i;
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.c, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
      StreamDataManager.a(paramString, (byte[])localObject, localObject.length, (short)0);
    }
    else
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, (byte[])localObject, localObject.length);
    }
    if (paramString != null)
    {
      if (!paramBoolean)
      {
        this.jdField_a_of_type_Long = 0L;
        AudioUtil.a(2131230749);
      }
      else
      {
        if (((ReceiptHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(118)).jdField_a_of_type_Boolean)
        {
          localObject = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.c);
          paramString = (String)localObject;
          if (localObject != null)
          {
            paramString = (MessageForPtt)localObject;
            paramString.msgVia = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c;
            ReceiptMsgManager.a().a = paramString;
            paramString = (String)localObject;
          }
        }
        else
        {
          paramString = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.c);
        }
        if (paramString == null) {
          return;
        }
        if (i == 0) {
          paramString.setPttStreamFlag(10001);
        }
        this.jdField_a_of_type_Long = paramString.uniseq;
        paramRecorderParam.d = paramString.vipSubBubbleId;
        paramRecorderParam.e = paramString.vipBubbleDiyTextId;
        AudioUtil.a(2131230737);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(true, false);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, RecordParams.RecorderParam paramRecorderParam)
  {
    a(paramString, this.jdField_a_of_type_Long, paramBoolean2, paramRecorderParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new AudioPanelAioHelper.5(this, paramBoolean1));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 == 0)
    {
      StreamDataManager.a(paramString, paramArrayOfByte, paramInt1, (short)0);
      return;
    }
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramArrayOfByte, paramInt1);
  }
  
  public void a(boolean paramBoolean)
  {
    IQQRecorder localIQQRecorder = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    if (localIQQRecorder != null) {
      localIQQRecorder.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.l())
    {
      if (paramBoolean1) {
        g();
      } else {
        h();
      }
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramBoolean2, false, false);
      b(true, paramBoolean2);
    }
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    MediaPlayerManager localMediaPlayerManager = a();
    if (localMediaPlayerManager == null) {
      return;
    }
    if (paramBoolean4)
    {
      a(paramBoolean1);
      if (!localMediaPlayerManager.a()) {
        return;
      }
    }
    this.jdField_b_of_type_Boolean = paramBoolean3;
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioDeviceHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      }
    }
    if (!localMediaPlayerManager.b()) {
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramBoolean3, paramBoolean1, paramBoolean4);
    }
    if (localMediaPlayerManager.a())
    {
      if ((!paramBoolean1) && (!paramBoolean4)) {
        paramBoolean2 = true;
      } else {
        paramBoolean2 = false;
      }
      b(paramBoolean2, paramBoolean3);
    }
    a(paramBoolean1);
  }
  
  public boolean a()
  {
    IQQRecorder localIQQRecorder = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    return (localIQQRecorder != null) && (!localIQQRecorder.b());
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setVolumeControlStream(paramInt);
  }
  
  public void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = PlayModeUtils.b(paramBoolean1, paramBoolean2, paramBoolean3);
    int j = PlayModeUtils.a(paramBoolean1, paramBoolean2, paramBoolean3);
    if ((i > 0) && (this.c != j))
    {
      this.c = j;
      QQToast.a(paramContext, i, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
    }
  }
  
  public void b(String paramString, int paramInt, RecordParams.RecorderParam paramRecorderParam)
  {
    int i;
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("DiyTextId", paramRecorderParam.e);
      StreamDataManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt, paramRecorderParam.c, paramRecorderParam.d, localBundle);
    }
  }
  
  protected void b(String paramString, long paramLong, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if ((paramInt1 != 2) && (paramInt1 != 1)) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool1;
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendPttInner(),recordingUniseq is:");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(",path is:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
    long l = SystemClock.uptimeMillis();
    int j = ((SessionInfo)localObject2).jdField_a_of_type_Int;
    Object localObject1 = ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString;
    if (i == 0)
    {
      localObject2 = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (SessionInfo)localObject2, -2, paramRecorderParam.c);
      if (localObject2 == null) {
        return;
      }
      localObject3 = (MessageForPtt)localObject2;
      ((MessageForPtt)localObject3).c2cViaOffline = bool1;
      if (!StringUtil.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
        ((MessageForPtt)localObject3).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
      }
      paramLong = ((MessageRecord)localObject2).uniseq;
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((String)localObject1, 0, paramLong);
      if (MessageForPtt.class.isInstance(localObject2))
      {
        localObject2 = (MessageForPtt)localObject2;
        ((MessageForPtt)localObject2).voiceLength = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(paramInt2);
        if (!StringUtil.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
          ((MessageForPtt)localObject2).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
        }
      }
    }
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).putPttSendCostRecorder(paramString, Long.valueOf(l));
    if (!bool1)
    {
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
    }
    else
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("recordingUniseq is:");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (jdField_a_of_type_Boolean) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8005B57", "0X8005B57", i, 0, "", "", "", "8.7.0");
    jdField_a_of_type_Boolean = true;
    int i = AudioPanelProvider.a(paramInt1);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("DiyTextId", paramRecorderParam.e);
    Object localObject3 = new ArrayList();
    String str = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject3);
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    Object localObject4 = new Bundle();
    Object localObject5 = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
    l = paramLong;
    if (((Bundle)localObject4).getBoolean("mIsShowRobotIcon"))
    {
      localObject4 = ((ArrayList)localObject3).iterator();
      for (;;)
      {
        l = paramLong;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject5 = (AtTroopMemberInfo)((Iterator)localObject4).next();
        if (localITroopRobotService.isRobotUin(((AtTroopMemberInfo)localObject5).uin))
        {
          bool2 = true;
          break label610;
        }
      }
    }
    boolean bool2 = false;
    paramLong = l;
    label610:
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, (String)localObject1, paramString, paramLong, false, paramInt2, paramRecorderParam.c, bool1, paramInt3, i, paramBoolean, paramRecorderParam.d, (Bundle)localObject2, (ArrayList)localObject3, str, bool2, paramInt4);
    a(paramInt1, paramInt2);
    a(0, paramString, paramLong);
  }
  
  public void b(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    g(0);
    if (paramRecorderParam != null)
    {
      int i;
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        StreamDataManager.a(paramString, false);
        return;
      }
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
    }
  }
  
  protected void b(String paramString, boolean paramBoolean, RecordParams.RecorderParam paramRecorderParam)
  {
    Object localObject1 = (DeviceMsgChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    Object localObject2 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject2).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    if (localDeviceInfo != null)
    {
      localObject2 = ((SmartDeviceProxyMgr)localObject2).a(localDeviceInfo.productId);
      if ((localObject2 != null) && (((ProductInfo)localObject2).isSupportMainMsgType(2)))
      {
        bool = true;
        break label84;
      }
    }
    boolean bool = false;
    label84:
    long l;
    int i;
    if (localDeviceInfo != null)
    {
      l = localDeviceInfo.din;
      i = localDeviceInfo.productId;
    }
    else
    {
      l = 0L;
      i = 0;
    }
    SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 1, 0, i);
    ((DeviceMsgChatPie)localObject1).m(bool);
    if (!bool)
    {
      paramString = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, "Usr_AIO_SendMsg", 7, 0, i);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onRecorderPerpare path = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("AudioPanelAioHelper", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.c, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
      StreamDataManager.a(paramString, (byte[])localObject1, localObject1.length, (short)0);
    }
    else
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, (byte[])localObject1, localObject1.length);
    }
    if (paramString != null)
    {
      if (!paramBoolean)
      {
        this.jdField_a_of_type_Long = 0L;
        AudioUtil.b(2131230749, false);
      }
      else
      {
        paramString = DevAudioMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, -2L);
        if (i == 0) {
          paramString.setPttStreamFlag(10001);
        }
        if (paramString != null) {
          this.jdField_a_of_type_Long = paramString.uniseq;
        }
        AudioUtil.b(2131230737, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(true, false);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramBoolean1) && (!DeviceInfoUtil.j()))
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131558579, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().findViewById(2131362489);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().findViewById(2131362490));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().findViewById(2131362488));
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c())) {
            ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131368875);
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a() == null) {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131368875);
        }
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF737373"));
      }
      if (paramBoolean2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689946);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850304);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689945);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850303);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        paramBoolean1 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
        paramBoolean2 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
        if (((paramBoolean1) || (paramBoolean2)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(this.jdField_b_of_type_Boolean ^ true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((((localObject instanceof BaseTroopChatPie)) || ((localObject instanceof RobotChatPie))) && (i != 0))
    {
      localObject = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(52);
      if ((localObject != null) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        ((AIOShortcutBarHelper)localObject).c(22);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie)) {
          ((AIOShortcutBarHelper)localObject).c(10);
        }
      }
    }
  }
  
  public boolean b()
  {
    IQQRecorder localIQQRecorder = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    return (localIQQRecorder != null) && (localIQQRecorder.a());
  }
  
  public int c()
  {
    int i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000;
    int j = VasUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getVipStatus().getPrivilegeFlags(null);
    if ((j & 0x4) != 0) {}
    for (i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SVIP_MaxPtt");; i = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "VIP_MaxPtt"))
    {
      i *= 1000;
      break;
      if ((j & 0x2) == 0) {
        break;
      }
    }
    i -= 200;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().sendEmptyMessageDelayed(16711687, i);
    return i + 200;
  }
  
  public void c()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext).isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPanelAioHelper", 2, "showAbnormalRecordDlg failed, mContext not valid");
      }
      return;
    }
    int j = 0;
    Object localObject = Build.MANUFACTURER;
    int i;
    if (((String)localObject).equalsIgnoreCase("meizu"))
    {
      i = 2131698592;
    }
    else if (((String)localObject).equalsIgnoreCase("xiaomi"))
    {
      i = 2131698594;
    }
    else if (((String)localObject).equalsIgnoreCase("vivo"))
    {
      i = 2131698593;
    }
    else
    {
      i = 2131698590;
      j = 1;
    }
    try
    {
      localObject = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(i));
      if (j != 0)
      {
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165601), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165606)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131701201), (CharSequence)localObject, 0, 2131719788, null, null, new AudioPanelAioHelper.2(this)).show();
        return;
      }
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 230, HardCodeUtil.a(2131701184), ((SpannableString)localObject).toString(), HardCodeUtil.a(2131701207), "", null, new AudioPanelAioHelper.3(this)).show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("show showAbnormalRecordDlg error : ");
        localStringBuilder.append(localException.getMessage());
        QLog.d("AudioPanelAioHelper", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void c(int paramInt)
  {
    ToastStyleDialog localToastStyleDialog;
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(25);
      localToastStyleDialog = this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog;
      if ((localToastStyleDialog == null) || (!localToastStyleDialog.isShowing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = new ToastStyleDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131698556));
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.show();
      }
    }
    else if (paramInt == 1)
    {
      localToastStyleDialog = this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog;
      if ((localToastStyleDialog != null) && (localToastStyleDialog.isShowing()) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
      }
    }
  }
  
  public void c(String paramString, int paramInt, RecordParams.RecorderParam paramRecorderParam)
  {
    boolean bool;
    if ((paramInt != 2) && (paramInt != 1)) {
      bool = false;
    } else {
      bool = true;
    }
    a(paramString, this.jdField_a_of_type_Long, bool, paramRecorderParam);
    h(paramInt);
  }
  
  protected void c(String paramString, long paramLong, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    Object localObject2 = (DeviceMsgChatPie)localObject1;
    SessionInfo localSessionInfo = ((BaseChatPie)localObject1).a();
    if (!((DeviceMsgChatPie)localObject2).t()) {
      return;
    }
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
    }
    else
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
    }
    if (!new File(paramString).exists())
    {
      paramRecorderParam = paramString;
      paramInt1 = 0;
      while (paramInt1 < IVoiceTuneUtil.MAX_TYPES)
      {
        paramRecorderParam = ((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).getChangedSoundFilePath(paramString, paramInt1);
        if (new File(paramRecorderParam).exists()) {
          break;
        }
        paramInt1 += 1;
      }
    }
    paramRecorderParam = paramString;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("sendPttInner(),recordingUniseq is:");
      paramString.append(paramLong);
      paramString.append(",path is:");
      paramString.append(paramRecorderParam);
      QLog.d("AIOAudioPanel", 2, paramString.toString());
    }
    localObject1 = null;
    paramString = (String)localObject1;
    if (!TextUtils.isEmpty(paramRecorderParam))
    {
      paramString = (String)localObject1;
      if (localSessionInfo != null) {
        if (paramLong != 0L) {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, paramLong);
        } else {
          paramString = DevAudioMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam, localSessionInfo.jdField_a_of_type_Int, localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.b, -2L);
        }
      }
    }
    if (paramString != null)
    {
      a(0, paramRecorderParam, paramString.uniseq);
      if ((DeviceMsgChatPie.H) && (((DeviceMsgChatPie)localObject2).G))
      {
        if ((!NetworkUtil.isNetSupport(BaseApplication.getContext())) && ((paramString instanceof MessageForDevPtt)))
        {
          paramString = (MessageForDevPtt)paramString;
          paramString.fileSize = -1L;
          paramString.extraflag = 32768;
          paramString.extStr = "device_groupchat";
          paramString.serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString.frienduin, paramString.istroop, paramString.uniseq, paramString.msgData);
          return;
        }
        localObject1 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
        paramLong = Long.parseLong(localSessionInfo.jdField_a_of_type_JavaLangString);
        localObject2 = (IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class);
        double d = paramInt2;
        paramInt1 = ((SmartDeviceProxyMgr)localObject1).a(paramLong, paramRecorderParam, ((IQQRecorderUtils)localObject2).msToSec(d));
        if ((paramString instanceof MessageForDevPtt)) {
          ((MessageForDevPtt)paramString).voiceLength = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(d);
        }
        DeviceMsgChatPie.a.put(Integer.valueOf(paramInt1), paramString);
        paramString = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(localSessionInfo.jdField_a_of_type_JavaLangString));
        if (paramString != null) {
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString.din, "Usr_AIO_SendGroupMsg", 1, 0, paramString.productId);
        }
      }
      else
      {
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(DeviceMsgHandle.f, paramRecorderParam, Long.parseLong(localSessionInfo.jdField_a_of_type_JavaLangString), paramString.uniseq, paramString.istroop, ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(paramInt2));
        paramLong = paramString.uniseq;
      }
    }
  }
  
  public int d()
  {
    return this.c;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof LimitChatPie)) {
      ((IAioVoicePlayerManager)QRoute.api(IAioVoicePlayerManager.class)).stopAll();
    }
    b(true, this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(128);
  }
  
  public void d(int paramInt)
  {
    ((VoiceTextEditPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(36)).a(paramInt);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setVolumeControlStream(3);
    b(false, false);
    h();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().sendEmptyMessageDelayed(25, 1000L);
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void f()
  {
    IQQRecorder localIQQRecorder = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    if (localIQQRecorder != null) {
      localIQQRecorder.a();
    }
  }
  
  public void f(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    if ((localObject != null) && (!((IQQRecorder)localObject).b()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().hasMessages(16711686)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(16711688);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(16711686);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(16711687);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("stopRecord() is called,time is:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("AudioPanelAioHelper", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Int = paramInt;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((localObject instanceof TroopChatPie))
      {
        localObject = (TroopChatPie)localObject;
        if (((TroopChatPie)localObject).w())
        {
          this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.c();
          QQAudioUtils.a(((TroopChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), false);
          ((TroopChatPie)localObject).b(true);
          return;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().obtainMessage(16711686);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().sendMessageDelayed((Message)localObject, 200L);
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131755340);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext);
      localImageView.setBackgroundResource(2130838027);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.1F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localImageView.startAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(localImageView, new ViewGroup.LayoutParams(-1, -1));
    }
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("AudioPanelAioHelper", 1, "showPttMaskDialog", localException);
    }
  }
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new AudioPanelAioHelper.1(this, paramInt));
  }
  
  @NonNull
  public String getTag()
  {
    return "AudioPanelAioHelper";
  }
  
  public void h()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AudioPanelAioHelper", 1, "dismissPttMaskDialog", localException);
      }
    }
  }
  
  protected void h(int paramInt)
  {
    PttUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 25)
    {
      if (i != 40) {
        switch (i)
        {
        default: 
          return false;
        case 16711688: 
          a(0, null, -1L);
          return false;
        case 16711687: 
          f(2);
          return false;
        case 16711686: 
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("QQRecorder stop() is called,time is:");
            paramMessage.append(System.currentTimeMillis());
            QLog.d("QQRecorder", 2, paramMessage.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.c();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ah();
          if (this.jdField_a_of_type_Long != 0L) {
            break;
          }
          AudioUtil.b(2131230748, false);
          return false;
        case 16711685: 
          n();
          return false;
        }
      } else {
        ((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(2)).a(paramMessage.arg1);
      }
      return false;
    }
    paramMessage = this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog;
    if ((paramMessage != null) && (paramMessage.isShowing()) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
    }
    return true;
  }
  
  public void i()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      localView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void i(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 2, 1, 6, 15, 11, 7, 10 };
  }
  
  public void j(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      ((RelativeLayout.LayoutParams)localView.getLayoutParams()).addRule(2, paramInt);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362489)
    {
      com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
      ((FastImageHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(83)).b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.o();
      AudioDeviceHelper.a(true ^ this.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      MediaPlayerManager localMediaPlayerManager = a();
      localMediaPlayerManager.c();
      ((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).reportSwitchSpeakerPhoneClick(localMediaPlayerManager.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_b_of_type_Boolean);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 15)
          {
            if (paramInt != 6)
            {
              if (paramInt != 7)
              {
                if (paramInt != 10)
                {
                  if (paramInt != 11) {
                    return;
                  }
                  l();
                  return;
                }
                ((AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(2)).b();
                return;
              }
              k();
              return;
            }
            this.jdField_b_of_type_Boolean = true;
            AudioPanelProvider localAudioPanelProvider = (AudioPanelProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().a(2);
            localAudioPanelProvider.d = false;
            localAudioPanelProvider.c = false;
            i();
            return;
          }
          m();
          return;
        }
        j();
        return;
      }
      a();
      return;
    }
    this.jdField_b_of_type_Boolean = AudioDeviceHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper
 * JD-Core Version:    0.7.0.1
 */
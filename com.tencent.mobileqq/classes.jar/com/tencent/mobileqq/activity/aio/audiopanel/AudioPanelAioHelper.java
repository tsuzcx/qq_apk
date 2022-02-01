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
import com.tencent.mobileqq.troop.navigatebar.AioTips;
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
  protected IQQRecorder b;
  public String c;
  protected int d = 0;
  public int e = -1;
  public long f;
  public ToastStyleDialog g;
  Dialog h;
  public boolean i = true;
  public View j;
  public TextView k;
  public ToastStyleDialog l;
  private BaseChatPie m;
  private QQAppInterface n;
  private int o = 0;
  private ImageView p;
  
  public AudioPanelAioHelper(BaseChatPie paramBaseChatPie)
  {
    this.m = paramBaseChatPie;
    this.n = paramBaseChatPie.i();
    paramBaseChatPie.bv().d().a(this);
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = PlayModeUtils.b(paramBoolean1, paramBoolean2, paramBoolean3);
    if (i1 > 0) {
      QQToast.makeText(paramContext, i1, 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
    }
  }
  
  private void q()
  {
    IQQRecorder localIQQRecorder = this.b;
    if (localIQQRecorder != null) {
      localIQQRecorder.a(null);
    }
  }
  
  private void r()
  {
    XPanelContainer localXPanelContainer = this.m.bm();
    AudioPanel localAudioPanel = (AudioPanel)this.m.bq().d(2);
    this.i = AudioDeviceHelper.a(this.n);
    if ((localXPanelContainer != null) && (localXPanelContainer.getCurrentPanel() == 2) && (localAudioPanel != null) && (localAudioPanel.getVisibility() == 0)) {
      this.e = 0;
    }
  }
  
  private void s()
  {
    ((AudioPanelProvider)this.m.bq().f(2)).i();
    ((VoiceTextEditPanelProvider)this.m.bq().f(36)).c();
  }
  
  private void t()
  {
    ((AudioPanelProvider)this.m.bq().f(2)).h();
    ((VoiceTextEditPanelProvider)this.m.bq().f(36)).b();
    this.o = 0;
    Object localObject1 = b();
    if (localObject1 != null)
    {
      ((MediaPlayerManager)localObject1).a(this.m.U);
      ((MediaPlayerManager)localObject1).a(true);
    }
    Object localObject3 = this.g;
    if ((localObject3 != null) && (((ToastStyleDialog)localObject3).isShowing()) && (this.g.getWindow() != null))
    {
      this.g.dismiss();
      this.g = null;
    }
    localObject3 = this.l;
    if ((localObject3 != null) && (((ToastStyleDialog)localObject3).isShowing()) && (this.l.getWindow() != null))
    {
      this.l.dismiss();
      this.l = null;
    }
    localObject3 = this.j;
    if (localObject3 != null)
    {
      ((View)localObject3).setVisibility(4);
      this.j = null;
    }
    if (localObject1 != null) {
      ((MediaPlayerManager)localObject1).i();
    }
    localObject1 = this.b;
    if (localObject1 != null) {
      ((IQQRecorder)localObject1).d();
    }
    try
    {
      ((IPttSSCMPool)QRoute.api(IPttSSCMPool.class)).clear();
      return;
    }
    finally {}
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMusicItem");
    }
    this.m.V.notifyDataSetChanged();
  }
  
  protected void a()
  {
    this.i = AudioDeviceHelper.a(this.n);
    boolean bool = this.m.f.getIntent().getBooleanExtra("open_chat_from_voice_changer_guide", false);
    AudioPanelProvider localAudioPanelProvider = (AudioPanelProvider)this.m.bq().f(2);
    localAudioPanelProvider.e = true;
    localAudioPanelProvider.a(bool);
    BaseChatPie localBaseChatPie = this.m;
    if ((localBaseChatPie instanceof HotChatDemoChatPie))
    {
      localAudioPanelProvider.d = true;
      return;
    }
    if ((localBaseChatPie instanceof NearbyChatPie)) {
      localAudioPanelProvider.d = ((NearbyChatPie)localBaseChatPie).a();
    }
  }
  
  public void a(int paramInt)
  {
    this.m.f.setVolumeControlStream(3);
    b(false, false);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    PttUtils.a(this.n, this.m.ah.a, paramInt1, paramInt2);
    BaseChatPie localBaseChatPie = this.m;
    if ((localBaseChatPie instanceof BusinessCmrTmpChatPie)) {
      AIOPanelUtiles.a(this.n, "0X8008AAA", "C_Master_PTT", localBaseChatPie.ah, AudioPanelProvider.b(paramInt1), paramInt2);
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
          paramString = StreamDataManager.b(paramString);
          if ((paramString != null) && (paramString.exists())) {
            paramString.delete();
          }
        }
        if (!this.m.j().hasMessages(16711688)) {
          this.m.j().sendEmptyMessageDelayed(16711688, 1000L);
        }
        if (paramLong != 0L)
        {
          paramInt = this.m.ah.a;
          paramString = this.m.ah.b;
          this.n.getMessageFacade().h(paramString, paramInt, paramLong);
        }
        this.m.a(true, false);
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
      ChatActivityFacade.a(this.n, this.m.ah, paramString, -3, paramLong);
      this.m.a(true, true);
    }
  }
  
  public void a(IQQRecorder.OnQQRecorderListener paramOnQQRecorderListener, boolean paramBoolean, RecordParams.RecorderParam paramRecorderParam)
  {
    if (this.m.j().hasMessages(16711688))
    {
      this.m.j().removeMessages(16711688);
      a(0, null, -1L);
    }
    this.m.j().removeMessages(16711688);
    this.m.j().removeMessages(16711686);
    this.m.j().removeMessages(16711687);
    this.m.d(false);
    this.m.bd();
    Object localObject1 = b();
    if (localObject1 != null) {
      ((MediaPlayerManager)localObject1).a(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanelAioHelper", 2, "startRecord() is called");
    }
    this.m.Y.setEnabled(false);
    if (this.b == null) {
      this.b = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder(this.m.e);
    }
    if (((paramOnQQRecorderListener instanceof PressToSpeakPanel)) && (((PressToSpeakPanel)paramOnQQRecorderListener).i()))
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
      this.c = ((StringBuilder)localObject2).toString();
      this.b.a(this.c);
    }
    this.b.a(paramRecorderParam);
    localObject1 = TransFileUtil.getTransferFilePath(this.n.getCurrentAccountUin(), null, 2, null, false);
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
    this.b.a(paramOnQQRecorderListener);
    if (QLog.isColorLevel())
    {
      paramOnQQRecorderListener = new StringBuilder();
      paramOnQQRecorderListener.append("QQRecorder start() is called,time is:");
      paramOnQQRecorderListener.append(System.currentTimeMillis());
      QLog.d("AudioPanelAioHelper", 2, paramOnQQRecorderListener.toString());
    }
    this.b.a(paramRecorderParam, paramBoolean);
    int i1 = this.e;
    if (i1 >= 0) {
      this.e = (i1 + 1);
    }
  }
  
  public void a(String paramString)
  {
    a(2, paramString, this.f);
    this.m.f.runOnUiThread(new AudioPanelAioHelper.4(this));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    ThreadManager.postImmediately(new AudioPanelAioHelper.6(this), null, false);
    if (!((ReceiptHelper)this.m.q(118)).a)
    {
      a(paramString, this.f, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean, paramInt4);
      return;
    }
    ReceiptMsgManager.a().a(this.n, this.m.ah, paramString, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean);
    this.m.aX().runOnUiThread(new AudioPanelAioHelper.7(this));
  }
  
  public void a(String paramString, int paramInt, RecordParams.RecorderParam paramRecorderParam)
  {
    this.m.bq().a(36, true);
    ((VoiceTextEditPanelProvider)this.m.bq().f(36)).a(paramString, paramInt, paramRecorderParam);
  }
  
  public void a(String paramString1, int paramInt, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    SessionInfo localSessionInfo = this.m.aE();
    Object localObject = ChatActivityFacade.a(this.n, paramString1, localSessionInfo, -2, paramRecorderParam.c);
    if (localObject != null)
    {
      ((MessageForPtt)localObject).c2cViaOffline = true;
      long l1 = ((MessageRecord)localObject).uniseq;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
      ChatActivityFacade.a(this.n, localSessionInfo.a, localSessionInfo.b, paramString1, l1, false, paramInt, paramRecorderParam.c, true, 0, 4, false, paramRecorderParam.d, (Bundle)localObject);
      a(0, paramString1, l1);
      ReportController.b(this.n, "CliOper", "", "", "0X8005B16", "0X8005B16", 0, 0, "", "", paramString2, "8.8.17");
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
    Object localObject = this.m;
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
      i1 = 0;
    } else {
      i1 = 1;
    }
    boolean bool;
    if (paramRecorderParam.f == null) {
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
    localObject = this.m.aE();
    long l1 = SystemClock.uptimeMillis();
    int i2 = this.m.ah.a;
    String str1 = ((SessionInfo)localObject).b;
    if (i1 == 0)
    {
      localObject = ChatActivityFacade.a(this.n, paramString, (SessionInfo)localObject, -2, paramRecorderParam.c);
      if (localObject == null) {
        return;
      }
      ((MessageForPtt)localObject).c2cViaOffline = bool;
      paramLong = ((MessageRecord)localObject).uniseq;
    }
    else
    {
      localObject = this.n.getMessageFacade().a(str1, 0, paramLong);
      if ((localObject instanceof MessageForPtt)) {
        ((MessageForPtt)localObject).voiceLength = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(paramInt2);
      }
    }
    if ((localObject instanceof MessageForPtt))
    {
      localObject = (MessageForPtt)localObject;
      ((MessageForPtt)localObject).waveformArray = PttAudioWaveView.a(paramRecorderParam.h, paramRecorderParam.g);
      if (!StringUtil.isEmpty(paramRecorderParam.i)) {
        ((MessageForPtt)localObject).sttText = paramRecorderParam.i;
      }
    }
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).putPttSendCostRecorder(paramString, Long.valueOf(l1));
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
    localObject = this.n;
    if (a) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", i1, 0, "", "", "", "8.8.17");
    a = true;
    int i1 = AudioPanelProvider.b(paramInt1);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
    ArrayList localArrayList = new ArrayList();
    String str2 = AtTroopMemberSpan.a(this.m.Y.getEditableText(), localArrayList);
    ChatActivityFacade.a(this.n, i2, str1, paramString, paramLong, false, paramInt2, paramRecorderParam.c, bool, paramInt3, i1, paramBoolean, paramRecorderParam.d, (Bundle)localObject, localArrayList, str2, false, paramInt4);
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
    int i1;
    if (paramRecorderParam.f == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      StreamDataManager.a(paramString, true);
      StreamDataManager.a(paramString);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
      StreamDataManager.a(paramString, this.n, this.m.ah.b, paramLong, true, 0, paramRecorderParam.c, paramRecorderParam.d, (Bundle)localObject);
      return;
    }
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(paramString);
  }
  
  public void a(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    BaseChatPie localBaseChatPie = this.m;
    int i1 = 1;
    localBaseChatPie.d(true);
    this.m.be();
    h(0);
    if (QLog.isColorLevel()) {
      QLog.d("AudioPanelAioHelper", 2, "recorderEnd() is called");
    }
    this.m.Y.setEnabled(true);
    if (paramRecorderParam != null)
    {
      if (paramRecorderParam.f != null) {
        i1 = 0;
      }
      if (i1 == 0)
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
    if ((this.m instanceof DeviceMsgChatPie))
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
    Object localObject = RecordParams.a(paramRecorderParam.c, paramRecorderParam.a);
    int i1;
    if (paramRecorderParam.f == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      StreamDataManager.a(this.n, paramRecorderParam.c, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
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
        this.f = 0L;
        AudioUtil.a(2131230817);
      }
      else
      {
        if (((ReceiptHelper)this.m.q(118)).a)
        {
          localObject = ChatActivityFacade.a(this.n, paramString, this.m.ah, -2, paramRecorderParam.c);
          paramString = (String)localObject;
          if (localObject != null)
          {
            paramString = (MessageForPtt)localObject;
            paramString.msgVia = this.m.ah.s;
            ReceiptMsgManager.a().a = paramString;
            paramString = (String)localObject;
          }
        }
        else
        {
          paramString = ChatActivityFacade.a(this.n, paramString, this.m.ah, -2, paramRecorderParam.c);
        }
        if (paramString == null) {
          return;
        }
        if (i1 == 0) {
          paramString.setPttStreamFlag(10001);
        }
        this.f = paramString.uniseq;
        paramRecorderParam.d = paramString.vipSubBubbleId;
        paramRecorderParam.e = paramString.vipBubbleDiyTextId;
        AudioUtil.a(2131230805);
      }
      this.m.a(true, false);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, RecordParams.RecorderParam paramRecorderParam)
  {
    a(paramString, this.f, paramBoolean2, paramRecorderParam);
    this.m.f.runOnUiThread(new AudioPanelAioHelper.5(this, paramBoolean1));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    if (paramRecorderParam.f == null) {
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
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.m.aY())
    {
      if (paramBoolean1) {
        n();
      } else {
        o();
      }
      b(this.n.getApp(), paramBoolean2, false, false);
      b(true, paramBoolean2);
    }
    this.i = paramBoolean2;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    MediaPlayerManager localMediaPlayerManager = b();
    if (localMediaPlayerManager == null) {
      return;
    }
    if (paramBoolean4)
    {
      b(paramBoolean1);
      if (!localMediaPlayerManager.g()) {
        return;
      }
    }
    this.i = paramBoolean3;
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioDeviceHelper.c(this.n.getApp());
      }
    }
    if (!localMediaPlayerManager.h()) {
      b(this.n.getApp(), paramBoolean3, paramBoolean1, paramBoolean4);
    }
    if (localMediaPlayerManager.g())
    {
      if ((!paramBoolean1) && (!paramBoolean4)) {
        paramBoolean2 = true;
      } else {
        paramBoolean2 = false;
      }
      b(paramBoolean2, paramBoolean3);
    }
    b(paramBoolean1);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  protected MediaPlayerManager b()
  {
    QQAppInterface localQQAppInterface = this.n;
    if (localQQAppInterface == null) {
      return null;
    }
    return (MediaPlayerManager)localQQAppInterface.getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
  }
  
  public void b(int paramInt)
  {
    this.m.f.setVolumeControlStream(paramInt);
  }
  
  public void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = PlayModeUtils.b(paramBoolean1, paramBoolean2, paramBoolean3);
    int i2 = PlayModeUtils.a(paramBoolean1, paramBoolean2, paramBoolean3);
    if ((i1 > 0) && (this.o != i2))
    {
      this.o = i2;
      QQToast.makeText(paramContext, i1, 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
    }
  }
  
  public void b(String paramString, int paramInt, RecordParams.RecorderParam paramRecorderParam)
  {
    int i1;
    if (paramRecorderParam.f == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("DiyTextId", paramRecorderParam.e);
      StreamDataManager.a(paramString, this.n, this.m.ah.b, this.f, paramInt, paramRecorderParam.c, paramRecorderParam.d, localBundle);
    }
  }
  
  protected void b(String paramString, long paramLong, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if ((paramInt1 != 2) && (paramInt1 != 1)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    boolean bool1;
    if (paramRecorderParam.f == null) {
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
    Object localObject2 = this.m.aE();
    long l1 = SystemClock.uptimeMillis();
    int i2 = ((SessionInfo)localObject2).a;
    Object localObject1 = ((SessionInfo)localObject2).b;
    if (i1 == 0)
    {
      localObject2 = ChatActivityFacade.a(this.n, paramString, (SessionInfo)localObject2, -2, paramRecorderParam.c);
      if (localObject2 == null) {
        return;
      }
      localObject3 = (MessageForPtt)localObject2;
      ((MessageForPtt)localObject3).c2cViaOffline = bool1;
      if (!StringUtil.isEmpty(paramRecorderParam.i)) {
        ((MessageForPtt)localObject3).sttText = paramRecorderParam.i;
      }
      paramLong = ((MessageRecord)localObject2).uniseq;
    }
    else
    {
      localObject2 = this.n.getMessageFacade().a((String)localObject1, 0, paramLong);
      if (MessageForPtt.class.isInstance(localObject2))
      {
        localObject2 = (MessageForPtt)localObject2;
        ((MessageForPtt)localObject2).voiceLength = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(paramInt2);
        if (!StringUtil.isEmpty(paramRecorderParam.i)) {
          ((MessageForPtt)localObject2).sttText = paramRecorderParam.i;
        }
      }
    }
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).putPttSendCostRecorder(paramString, Long.valueOf(l1));
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
    localObject2 = this.n;
    if (a) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8005B57", "0X8005B57", i1, 0, "", "", "", "8.8.17");
    a = true;
    int i1 = AudioPanelProvider.b(paramInt1);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("DiyTextId", paramRecorderParam.e);
    Object localObject3 = new ArrayList();
    String str = AtTroopMemberSpan.a(this.m.Y.getEditableText(), (ArrayList)localObject3);
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.n.getRuntimeService(ITroopRobotService.class, "all");
    Object localObject4 = new Bundle();
    Object localObject5 = (AIOShortcutBarHelper)this.m.q(52);
    l1 = paramLong;
    if (((Bundle)localObject4).getBoolean("mIsShowRobotIcon"))
    {
      localObject4 = ((ArrayList)localObject3).iterator();
      for (;;)
      {
        l1 = paramLong;
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
    paramLong = l1;
    label610:
    ChatActivityFacade.a(this.n, i2, (String)localObject1, paramString, paramLong, false, paramInt2, paramRecorderParam.c, bool1, paramInt3, i1, paramBoolean, paramRecorderParam.d, (Bundle)localObject2, (ArrayList)localObject3, str, bool2, paramInt4);
    a(paramInt1, paramInt2);
    a(0, paramString, paramLong);
  }
  
  public void b(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    h(0);
    if (paramRecorderParam != null)
    {
      int i1;
      if (paramRecorderParam.f == null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0)
      {
        StreamDataManager.a(paramString, false);
        return;
      }
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
    }
  }
  
  protected void b(String paramString, boolean paramBoolean, RecordParams.RecorderParam paramRecorderParam)
  {
    Object localObject1 = (DeviceMsgChatPie)this.m;
    Object localObject2 = (SmartDeviceProxyMgr)this.n.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)localObject2).g(Long.parseLong(this.m.ah.b));
    if (localDeviceInfo != null)
    {
      localObject2 = ((SmartDeviceProxyMgr)localObject2).b(localDeviceInfo.productId);
      if ((localObject2 != null) && (((ProductInfo)localObject2).isSupportMainMsgType(2)))
      {
        bool = true;
        break label84;
      }
    }
    boolean bool = false;
    label84:
    long l1;
    int i1;
    if (localDeviceInfo != null)
    {
      l1 = localDeviceInfo.din;
      i1 = localDeviceInfo.productId;
    }
    else
    {
      l1 = 0L;
      i1 = 0;
    }
    SmartDeviceReport.a(this.n, l1, "Usr_AIO_SendMsg", 1, 0, i1);
    ((DeviceMsgChatPie)localObject1).p(bool);
    if (!bool)
    {
      paramString = (DeviceMsgHandle)this.n.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      SmartDeviceReport.a(this.n, l1, "Usr_AIO_SendMsg", 7, 0, i1);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onRecorderPerpare path = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("AudioPanelAioHelper", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = RecordParams.a(paramRecorderParam.c, paramRecorderParam.a);
    if (paramRecorderParam.f == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      StreamDataManager.a(this.n, paramRecorderParam.c, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
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
        this.f = 0L;
        AudioUtil.b(2131230817, false);
      }
      else
      {
        paramString = DevAudioMsgProcessor.a(this.n, paramString, this.m.ah.a, this.m.ah.b, this.m.ah.c, -2L);
        if (i1 == 0) {
          paramString.setPttStreamFlag(10001);
        }
        if (paramString != null) {
          this.f = paramString.uniseq;
        }
        AudioUtil.b(2131230805, false);
      }
      this.m.a(true, false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    IQQRecorder localIQQRecorder = this.b;
    if (localIQQRecorder != null) {
      localIQQRecorder.a(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    if (this.j == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((paramBoolean1) && (!DeviceInfoUtil.W()))
    {
      if (this.j == null)
      {
        this.m.f.getLayoutInflater().inflate(2131624137, this.m.bl());
        this.j = this.m.bl().findViewById(2131428098);
        this.k = ((TextView)this.m.bl().findViewById(2131428099));
        this.p = ((ImageView)this.m.bl().findViewById(2131428097));
        this.j.setOnClickListener(this);
        if (this.m.ah.a == 1)
        {
          if ((this.m.au != null) && (!this.m.au.g())) {
            ((RelativeLayout.LayoutParams)this.j.getLayoutParams()).addRule(2, 2131435809);
          }
        }
        else if (this.m.ak() == null) {
          ((RelativeLayout.LayoutParams)this.j.getLayoutParams()).addRule(2, 2131435809);
        }
      }
      this.j.setVisibility(0);
      if (ThemeUtil.isNowThemeIsNight(this.n, false, null)) {
        this.k.setTextColor(Color.parseColor("#FF737373"));
      }
      if (paramBoolean2)
      {
        this.k.setText(2131886587);
        this.p.setBackgroundResource(2130852095);
        if (this.m.p != null) {
          this.m.p.a(false, this.m.ah.a);
        }
      }
      else
      {
        this.k.setText(2131886586);
        this.p.setBackgroundResource(2130852094);
        if (this.m.p != null) {
          this.m.p.a(true, this.m.ah.a);
        }
      }
    }
    else
    {
      localObject = this.j;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        paramBoolean1 = AudioDeviceHelper.a(BaseApplicationImpl.getContext());
        paramBoolean2 = AudioDeviceHelper.b(BaseApplicationImpl.getContext());
        if (((paramBoolean1) || (paramBoolean2)) && (this.m.p != null)) {
          this.m.p.a(this.i ^ true, this.m.ah.a);
        }
      }
    }
    Object localObject = this.m;
    if ((((localObject instanceof BaseTroopChatPie)) || ((localObject instanceof RobotChatPie))) && (i1 != 0))
    {
      localObject = (AIOShortcutBarHelper)this.m.q(52);
      if ((localObject != null) && (this.j != null))
      {
        ((AIOShortcutBarHelper)localObject).d(22);
        if ((this.m instanceof BaseTroopChatPie)) {
          ((AIOShortcutBarHelper)localObject).d(10);
        }
      }
    }
  }
  
  public int bM_()
  {
    return 0;
  }
  
  public void c(int paramInt)
  {
    ToastStyleDialog localToastStyleDialog;
    if (paramInt == 0)
    {
      ReportController.b(this.n, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
      this.m.j().removeMessages(25);
      localToastStyleDialog = this.l;
      if ((localToastStyleDialog == null) || (!localToastStyleDialog.isShowing()))
      {
        this.l = new ToastStyleDialog(this.m.e);
        this.l.a(this.m.e.getString(2131896502));
        this.l.show();
      }
    }
    else if (paramInt == 1)
    {
      localToastStyleDialog = this.l;
      if ((localToastStyleDialog != null) && (localToastStyleDialog.isShowing()) && (this.l.getWindow() != null)) {
        this.l.dismiss();
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
    a(paramString, this.f, bool, paramRecorderParam);
    i(paramInt);
  }
  
  protected void c(String paramString, long paramLong, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    Object localObject1 = this.m;
    Object localObject2 = (DeviceMsgChatPie)localObject1;
    SessionInfo localSessionInfo = ((BaseChatPie)localObject1).aE();
    if (!((DeviceMsgChatPie)localObject2).a()) {
      return;
    }
    if (paramRecorderParam.f == null) {
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
          paramString = this.n.getMessageFacade().a(localSessionInfo.b, localSessionInfo.a, paramLong);
        } else {
          paramString = DevAudioMsgProcessor.a(this.n, paramRecorderParam, localSessionInfo.a, localSessionInfo.b, localSessionInfo.c, -2L);
        }
      }
    }
    if (paramString != null)
    {
      a(0, paramRecorderParam, paramString.uniseq);
      if ((DeviceMsgChatPie.br) && (((DeviceMsgChatPie)localObject2).bq))
      {
        if ((!NetworkUtil.isNetSupport(BaseApplication.getContext())) && ((paramString instanceof MessageForDevPtt)))
        {
          paramString = (MessageForDevPtt)paramString;
          paramString.fileSize = -1L;
          paramString.extraflag = 32768;
          paramString.extStr = "device_groupchat";
          paramString.serial();
          this.n.getMessageFacade().a(paramString.frienduin, paramString.istroop, paramString.uniseq, paramString.msgData);
          return;
        }
        localObject1 = (SmartDeviceProxyMgr)this.n.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
        paramLong = Long.parseLong(localSessionInfo.b);
        localObject2 = (IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class);
        double d1 = paramInt2;
        paramInt1 = ((SmartDeviceProxyMgr)localObject1).a(paramLong, paramRecorderParam, ((IQQRecorderUtils)localObject2).msToSec(d1));
        if ((paramString instanceof MessageForDevPtt)) {
          ((MessageForDevPtt)paramString).voiceLength = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(d1);
        }
        DeviceMsgChatPie.bs.put(Integer.valueOf(paramInt1), paramString);
        paramString = ((SmartDeviceProxyMgr)localObject1).g(Long.parseLong(localSessionInfo.b));
        if (paramString != null) {
          SmartDeviceReport.a(this.n, paramString.din, "Usr_AIO_SendGroupMsg", 1, 0, paramString.productId);
        }
      }
      else
      {
        ((DeviceMsgHandle)this.n.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(DeviceMsgHandle.f, paramRecorderParam, Long.parseLong(localSessionInfo.b), paramString.uniseq, paramString.istroop, ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(paramInt2));
        paramLong = paramString.uniseq;
      }
    }
  }
  
  public boolean d()
  {
    IQQRecorder localIQQRecorder = this.b;
    return (localIQQRecorder != null) && (!localIQQRecorder.b());
  }
  
  public boolean d(int paramInt)
  {
    return false;
  }
  
  public void e()
  {
    if ((this.m instanceof LimitChatPie)) {
      ((IAioVoicePlayerManager)QRoute.api(IAioVoicePlayerManager.class)).stopAll();
    }
    b(true, this.i);
    this.m.f.getWindow().addFlags(128);
  }
  
  public void e(int paramInt)
  {
    ((VoiceTextEditPanelProvider)this.m.bq().f(36)).a(paramInt);
  }
  
  public void f()
  {
    this.m.f.setVolumeControlStream(3);
    b(false, false);
    o();
    this.m.f.getWindow().clearFlags(128);
    this.m.j().sendEmptyMessageDelayed(25, 1000L);
  }
  
  public void f(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void g(int paramInt)
  {
    Object localObject = this.b;
    if ((localObject != null) && (!((IQQRecorder)localObject).b()) && (!this.m.j().hasMessages(16711686)))
    {
      this.m.j().removeMessages(16711688);
      this.m.j().removeMessages(16711686);
      this.m.j().removeMessages(16711687);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("stopRecord() is called,time is:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("AudioPanelAioHelper", 2, ((StringBuilder)localObject).toString());
      }
      this.d = paramInt;
      localObject = this.m;
      if ((localObject instanceof TroopChatPie))
      {
        localObject = (TroopChatPie)localObject;
        if (((TroopChatPie)localObject).bM())
        {
          this.b.c();
          QQAudioUtils.a(((TroopChatPie)localObject).f.getApplicationContext(), false);
          ((TroopChatPie)localObject).r(true);
          return;
        }
      }
      if (this.b != null)
      {
        localObject = this.m.j().obtainMessage(16711686);
        this.m.j().sendMessageDelayed((Message)localObject, 200L);
      }
    }
  }
  
  public boolean g()
  {
    IQQRecorder localIQQRecorder = this.b;
    return (localIQQRecorder != null) && (localIQQRecorder.a());
  }
  
  @NonNull
  public String getTag()
  {
    return "AudioPanelAioHelper";
  }
  
  public int h()
  {
    return this.d;
  }
  
  public void h(int paramInt)
  {
    this.m.f.runOnUiThread(new AudioPanelAioHelper.1(this, paramInt));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 25)
    {
      if (i1 != 40) {
        switch (i1)
        {
        default: 
          return false;
        case 16711688: 
          a(0, null, -1L);
          return false;
        case 16711687: 
          g(2);
          return false;
        case 16711686: 
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("QQRecorder stop() is called,time is:");
            paramMessage.append(System.currentTimeMillis());
            QLog.d("QQRecorder", 2, paramMessage.toString());
          }
          this.b.c();
          this.m.be();
          if (this.f != 0L) {
            break;
          }
          AudioUtil.b(2131230816, false);
          return false;
        case 16711685: 
          u();
          return false;
        }
      } else {
        ((AudioPanelProvider)this.m.bq().f(2)).a(paramMessage.arg1);
      }
      return false;
    }
    paramMessage = this.l;
    if ((paramMessage != null) && (paramMessage.isShowing()) && (this.l.getWindow() != null))
    {
      this.l.dismiss();
      this.l = null;
    }
    return true;
  }
  
  public void i()
  {
    this.f = 0L;
  }
  
  protected void i(int paramInt)
  {
    PttUtils.a(this.n, paramInt);
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 2, 1, 6, 15, 11, 7, 10 };
  }
  
  public void j()
  {
    if (((this.m.e instanceof Activity)) && (((Activity)this.m.e).isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPanelAioHelper", 2, "showAbnormalRecordDlg failed, mContext not valid");
      }
      return;
    }
    int i2 = 0;
    Object localObject = Build.MANUFACTURER;
    int i1;
    if (((String)localObject).equalsIgnoreCase("meizu"))
    {
      i1 = 2131896539;
    }
    else if (((String)localObject).equalsIgnoreCase("xiaomi"))
    {
      i1 = 2131896541;
    }
    else if (((String)localObject).equalsIgnoreCase("vivo"))
    {
      i1 = 2131896540;
    }
    else
    {
      i1 = 2131896537;
      i2 = 1;
    }
    try
    {
      localObject = new SpannableString(this.m.e.getString(i1));
      if (i2 != 0)
      {
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.m.e.getResources().getColor(2131165990), this.m.e.getResources().getColor(2131165998)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        DialogUtil.a(this.m.e, HardCodeUtil.a(2131899213), (CharSequence)localObject, 0, 2131917392, null, null, new AudioPanelAioHelper.2(this)).show();
        return;
      }
      DialogUtil.a(this.m.e, 230, HardCodeUtil.a(2131899199), ((SpannableString)localObject).toString(), HardCodeUtil.a(2131899219), "", null, new AudioPanelAioHelper.3(this)).show();
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
  
  public void j(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void k()
  {
    IQQRecorder localIQQRecorder = this.b;
    if (localIQQRecorder != null) {
      localIQQRecorder.d();
    }
  }
  
  public void k(int paramInt)
  {
    View localView = this.j;
    if (localView != null) {
      ((RelativeLayout.LayoutParams)localView.getLayoutParams()).addRule(2, paramInt);
    }
  }
  
  public int l()
  {
    int i1 = PttItemBuilder.a(this.n, "Normal_MaxPtt") * 1000;
    int i2 = VasUtil.b(this.n).getVipStatus().getPrivilegeFlags(null);
    if ((i2 & 0x4) != 0) {}
    for (i1 = PttItemBuilder.a(this.n, "SVIP_MaxPtt");; i1 = PttItemBuilder.a(this.n, "VIP_MaxPtt"))
    {
      i1 *= 1000;
      break;
      if ((i2 & 0x2) == 0) {
        break;
      }
    }
    i1 -= 200;
    this.m.j().sendEmptyMessageDelayed(16711687, i1);
    return i1 + 200;
  }
  
  public int m()
  {
    return this.o;
  }
  
  public void n()
  {
    if (this.h == null)
    {
      this.h = new ReportDialog(this.m.e, 2131952034);
      ImageView localImageView = new ImageView(this.m.e);
      localImageView.setBackgroundResource(2130838069);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.1F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localImageView.startAnimation(localAlphaAnimation);
      this.h.setContentView(localImageView, new ViewGroup.LayoutParams(-1, -1));
    }
    try
    {
      if (!this.m.f.isFinishing())
      {
        this.h.show();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("AudioPanelAioHelper", 1, "showPttMaskDialog", localException);
    }
  }
  
  public void o()
  {
    Dialog localDialog = this.h;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.h.getWindow() != null)) {
      try
      {
        this.h.dismiss();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AudioPanelAioHelper", 1, "dismissPttMaskDialog", localException);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131428098)
    {
      com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
      ((FastImageHelper)this.m.q(83)).b(true);
      this.m.I();
      AudioDeviceHelper.a(true ^ this.i, this.n);
      MediaPlayerManager localMediaPlayerManager = b();
      localMediaPlayerManager.c();
      ((IEmoticonManagerService)this.n.getRuntimeService(IEmoticonManagerService.class)).reportSwitchSpeakerPhoneClick(localMediaPlayerManager.f(), this.m.ah, this.i);
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
                  s();
                  return;
                }
                ((AudioPanelProvider)this.m.bq().f(2)).c();
                return;
              }
              r();
              return;
            }
            this.i = true;
            AudioPanelProvider localAudioPanelProvider = (AudioPanelProvider)this.m.bq().f(2);
            localAudioPanelProvider.e = false;
            localAudioPanelProvider.d = false;
            p();
            return;
          }
          t();
          return;
        }
        q();
        return;
      }
      a();
      return;
    }
    this.i = AudioDeviceHelper.a(this.n);
  }
  
  public void p()
  {
    View localView = this.j;
    if (localView != null)
    {
      localView.setVisibility(4);
      this.j = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper
 * JD-Core Version:    0.7.0.1
 */
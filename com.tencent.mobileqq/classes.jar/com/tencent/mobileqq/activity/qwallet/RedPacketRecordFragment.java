package com.tencent.mobileqq.activity.qwallet;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView;
import com.tencent.mobileqq.activity.aio.qwallet.QQWalletHbItemUtils;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.FontConvert;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView.StatusListener;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.OnVoiceRedPacketListener;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import xgr;
import xgs;
import xgt;
import xgu;
import xgv;
import xgw;
import xgx;
import xgz;
import xha;

public class RedPacketRecordFragment
  extends PublicBaseFragment
  implements View.OnClickListener, RecordMicView.StatusListener, VoiceRedPacketHelper.OnVoiceRedPacketListener
{
  private int jdField_a_of_type_Int;
  public long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public View a;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  protected VolumeIndicateSquareView a;
  public RecordMicView a;
  VoiceRedPacketHelper jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper;
  public MessageForQQWalletMsg a;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  protected VolumeIndicateSquareView b;
  private boolean jdField_b_of_type_Boolean;
  public TextView c;
  TextView d;
  
  private void a(View paramView)
  {
    new ImmersionBar(getActivity(), 0, paramView.findViewById(2131362859));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372473);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372474);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364003));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131372481));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366117));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372476));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372477));
    this.c = ((TextView)paramView.findViewById(2131372479));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView = ((RecordMicView)paramView.findViewById(2131372480));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367396));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)paramView.findViewById(2131366434));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)paramView.findViewById(2131366436));
    this.d = ((TextView)paramView.findViewById(2131367845));
  }
  
  private void b(int paramInt)
  {
    paramInt /= 1180;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
  }
  
  private void b(String paramString)
  {
    Object localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("msgType=13").append("&isOffline=").append(this.jdField_b_of_type_Boolean);
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByVoice", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
    PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)getActivity().app.getManager(124);
    PasswdRedBagInfo localPasswdRedBagInfo = localPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
    localPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop);
    localObject = (QWalletConfigManager)getActivity().app.getManager(244);
    int i;
    SessionInfo localSessionInfo;
    if (localObject != null)
    {
      i = ((QWalletConfigManager)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
      localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (i != 1) {
        break label276;
      }
    }
    label276:
    for (localObject = paramString;; localObject = "")
    {
      localPasswdRedBagManager.a(localSessionInfo, localPasswdRedBagInfo, l, 65536, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList);
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localPasswdRedBagInfo.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localPasswdRedBagInfo.jdField_b_of_type_Boolean + ",isPasswdRedBagOverDue=" + localPasswdRedBagInfo.c + "|scoreSwitch:" + i + "|scoreId" + paramString);
      }
      return;
      i = 1;
      break;
    }
  }
  
  private boolean c()
  {
    if (((QWalletConfigManager)getActivity().app.getManager(244)).a("voice_pwd", 0, new String[] { "offline" }) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketRecordFragment", 2, "get isOffLine fromConfig:" + bool);
      }
      return bool;
    }
  }
  
  private void g()
  {
    if (!a()) {}
    for (QQAppInterface localQQAppInterface = getActivity().app;; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        ThreadManager.post(new xgr(this, new WeakReference(localQQAppInterface)), 5, null, true);
      }
      return;
    }
  }
  
  private void h()
  {
    try
    {
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130841175));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetImageView, getActivity().getResources().getString(2131432354), null);
      AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetImageButton, getActivity().getResources().getString(2131432354), null);
      if (QWalletRedPkgUtils.a(getActivity()))
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        label109:
        localBundle = getArguments();
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        Bundle localBundle;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)localBundle.getParcelable("session"));
        long l = localBundle.getLong("uniseq", 0L);
        this.jdField_b_of_type_Int = localBundle.getInt("fromHBList", 0);
        Object localObject1;
        if (this.jdField_b_of_type_Int == 1)
        {
          localObject1 = localBundle.getString("redPacketId");
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = ((MessageForQQWalletMsg)QQWalletHbItemUtils.a.get(localObject1));
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null) {
            break label291;
          }
          return;
          localThrowable = localThrowable;
          this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131493719));
          break;
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
          break label109;
          localObject1 = getActivity().app.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
          if ((localObject1 instanceof MessageForQQWalletMsg)) {
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = ((MessageForQQWalletMsg)localObject1);
          }
        }
      }
      catch (Exception localException)
      {
        label291:
        do
        {
          for (;;)
          {
            localException.printStackTrace();
          }
          Object localObject2 = FaceDrawable.a(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, (byte)3);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          localObject2 = ContactUtils.b(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, true);
          localObject2 = QWalletTools.a(getActivity(), (String)localObject2, 135.0F, this.jdField_a_of_type_AndroidWidgetTextView.getPaint());
          this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject2 + "的口令红包");
          this.jdField_b_of_type_AndroidWidgetTextView.setText("“" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + "”");
          this.c.setText(getResources().getString(2131432348));
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.setStatusListener(this);
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper = VoiceRedPacketHelper.a();
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.a(this);
          this.jdField_b_of_type_Boolean = c();
          this.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.soundRecordDuration * 1000);
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.setRecordTime(this.jdField_a_of_type_Int);
        } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend());
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidOsBundle = ((Bundle)localThrowable.getParcelable("detail_bundle"));
        this.d.setOnClickListener(new xgs(this));
      }
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewView.post(new xgt(this));
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
  }
  
  public int a()
  {
    return 30000;
  }
  
  public void a()
  {
    this.c.setText(getResources().getString(2131432349));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketRecordFragment", 2, "onBegin() is called");
    }
    if (AudioHelper.b(1)) {
      ChatActivityUtils.a(getActivity());
    }
    this.jdField_b_of_type_Boolean = c();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      this.jdField_a_of_type_JavaLangString = FontConvert.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Boolean);
      }
      ReportController.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.start", 0, 0, "", "", "", "");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt)
  {
    getActivity().runOnUiThread(new xgw(this, paramInt));
  }
  
  public void a(int paramInt, String paramString)
  {
    getActivity().runOnUiThread(new xgv(this, paramInt, paramString));
  }
  
  public void a(Context paramContext)
  {
    int j = 0;
    if (((paramContext instanceof Activity)) && ((paramContext == null) || (((Activity)paramContext).isFinishing())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketRecordFragment", 2, "showAbnormalRecordDlg failed, mContext not valid");
      }
      return;
    }
    Object localObject = Build.MANUFACTURER;
    int i;
    if (((String)localObject).equalsIgnoreCase("meizu")) {
      i = 2131433404;
    }
    for (;;)
    {
      try
      {
        localObject = new SpannableString(paramContext.getString(i));
        if (j == 0) {
          break label238;
        }
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramContext.getResources().getColor(2131493062), paramContext.getResources().getColor(2131493063)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        DialogUtil.a(paramContext, "权限提示", (CharSequence)localObject, 0, 2131435212, null, null, new xgz(this, paramContext)).show();
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RedPacketRecordFragment", 2, "show showAbnormalRecordDlg error : " + paramContext.getMessage());
      return;
      if (((String)localObject).equalsIgnoreCase("xiaomi"))
      {
        i = 2131433405;
      }
      else if (((String)localObject).equalsIgnoreCase("vivo"))
      {
        i = 2131433406;
      }
      else
      {
        i = 2131433403;
        j = 1;
      }
    }
    label238:
    DialogUtil.a(paramContext, 230, "权限提示", ((SpannableString)localObject).toString(), "我知道了", "", null, new xha(this)).show();
  }
  
  public void a(String paramString)
  {
    this.c.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    j();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.c();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    getActivity().runOnUiThread(new xgu(this, paramBoolean, paramString));
  }
  
  public boolean a()
  {
    return (getActivity() == null) || (getActivity().isFinishing());
  }
  
  public void b()
  {
    this.c.setText(getResources().getString(2131432351));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    j();
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.b();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long >= 75L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new xgx(this), 20000L);
  }
  
  public void d()
  {
    a(getResources().getString(2131432348));
    ReportController.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.cancel", 0, 0, "", "", "", "");
  }
  
  public void e()
  {
    a(getResources().getString(2131432350));
  }
  
  public void f()
  {
    if (getActivity() != null) {
      getActivity().finish();
    }
    VoiceRedPacketHelper.a().d();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity) {}
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean) {
      ReportController.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.keyback", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return super.onBackEvent();
      ReportController.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.back", 0, 0, "", "", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    getActivity().doOnBackPressed();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2130971006, paramViewGroup, false);
      return paramLayoutInflater;
    }
    catch (Throwable paramLayoutInflater)
    {
      paramLayoutInflater.printStackTrace();
      getActivity().finish();
    }
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    a(paramView);
    h();
    i();
    FontConvert.a().a();
    g();
    ReportController.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.show", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketRecordFragment
 * JD-Core Version:    0.7.0.1
 */
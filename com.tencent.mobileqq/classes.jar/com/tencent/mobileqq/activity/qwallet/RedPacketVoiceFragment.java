package com.tencent.mobileqq.activity.qwallet;

import aiuk;
import aiul;
import aiwi;
import aixs;
import ajeo;
import ajeu;
import ajfg;
import ajfi;
import ajfq;
import alud;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import azqs;
import bdgc;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class RedPacketVoiceFragment
  extends RedPacketPopFragment
  implements ajfg, ajfq
{
  private int jdField_a_of_type_Int;
  public long a;
  ajfi jdField_a_of_type_Ajfi;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private VolumeIndicateSquareView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  RecordMicView jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private VolumeIndicateSquareView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  TextView c;
  
  private void b(int paramInt)
  {
    paramInt /= 1180;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
  }
  
  private void b(String paramString)
  {
    Object localObject = new StringBuilder(50);
    ((StringBuilder)localObject).append("msgType=13").append("&isOffline=").append(this.jdField_a_of_type_Boolean);
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByVoice", ((StringBuilder)localObject).toString(), 0, null, SystemClock.uptimeMillis());
    aiul localaiul = (aiul)getActivity().app.getManager(125);
    aiuk localaiuk = localaiul.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId);
    localaiul.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop);
    localObject = (aixs)getActivity().app.getManager(245);
    int i;
    SessionInfo localSessionInfo;
    if (localObject != null)
    {
      i = ((aixs)localObject).a("voice_pwd", 1, new String[] { "scoreSwitch" });
      localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (i != 1) {
        break label304;
      }
    }
    label304:
    for (localObject = paramString;; localObject = "")
    {
      localaiul.a(localSessionInfo, localaiuk, l, 65536, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.skinId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.fromHBList, null);
      ajeu.a(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "click open passwdredbag, isPasswdRedBagOpen=" + localaiuk.jdField_a_of_type_Boolean + ",isPasswdRedBagFinish=" + localaiuk.b + ",isPasswdRedBagOverDue=" + localaiuk.c + "|scoreSwitch:" + i + "|scoreId" + paramString);
      }
      return;
      i = 1;
      break;
    }
  }
  
  private boolean e()
  {
    if (((aixs)getActivity().app.getManager(245)).a("voice_pwd", 0, new String[] { "offline" }) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketVoiceFragment", 2, "get isOffLine fromConfig:" + bool);
      }
      return bool;
    }
  }
  
  private void f()
  {
    if (!c()) {}
    for (QQAppInterface localQQAppInterface = getActivity().app;; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        ThreadManager.post(new RedPacketVoiceFragment.2(this, new WeakReference(localQQAppInterface)), 5, null, true);
      }
      return;
    }
  }
  
  private void g()
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
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131695802));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketVoiceFragment", 2, "onBegin() is called");
    }
    if (AudioHelper.b(1)) {
      ChatActivityUtils.a(getActivity());
    }
    this.jdField_a_of_type_Boolean = e();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      this.jdField_a_of_type_JavaLangString = ajeo.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title);
      if ((this.jdField_a_of_type_Ajfi != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg != null)) {
        this.jdField_a_of_type_Ajfi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
      }
      azqs.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.start", 0, 0, "", "", "", "");
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
    getActivity().runOnUiThread(new RedPacketVoiceFragment.5(this, paramInt));
  }
  
  public void a(int paramInt, String paramString)
  {
    getActivity().runOnUiThread(new RedPacketVoiceFragment.4(this, paramInt, paramString));
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    ((ViewStub)paramView.findViewById(2131377173)).inflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372526));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377924));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView = ((RecordMicView)paramView.findViewById(2131375506));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380066));
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131380082));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)paramView.findViewById(2131368228));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)paramView.findViewById(2131368229));
    this.c = ((TextView)paramView.findViewById(2131367474));
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    g();
    this.jdField_a_of_type_Ajfi.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.c();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    getActivity().runOnUiThread(new RedPacketVoiceFragment.3(this, paramBoolean, paramString));
  }
  
  protected boolean a()
  {
    if (!super.a()) {
      return false;
    }
    this.jdField_e_of_type_AndroidViewView.setBackgroundDrawable(getResources().getDrawable(2130842998));
    String str = bdgc.b(getActivity().app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin, true);
    str = ajeu.a(getActivity(), str, 135.0F, this.d.getPaint());
    this.d.setText(str + alud.a(2131713696));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("“" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title + "”");
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131695800));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.setStatusListener(this);
    this.jdField_a_of_type_Ajfi = ajfi.a();
    this.jdField_a_of_type_Ajfi.a(this);
    this.jdField_a_of_type_Boolean = e();
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.soundRecordDuration * 1000);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.setRecordTime(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend())
    {
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidOsBundle = ((Bundle)getArguments().getParcelable("detail_bundle"));
      this.c.setOnClickListener(new aiwi(this));
    }
    ajeo.a().a();
    f();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    azqs.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.show", 0, 0, "", "", "", "");
    return true;
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131695803));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    g();
    c();
    if (this.jdField_a_of_type_Ajfi != null) {
      this.jdField_a_of_type_Ajfi.b();
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
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RedPacketVoiceFragment.6(this), 20000L);
  }
  
  public boolean c()
  {
    return super.c();
  }
  
  public void d()
  {
    a(getResources().getString(2131695800));
    azqs.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.cancel", 0, 0, "", "", "", "");
  }
  
  public void e()
  {
    a(getResources().getString(2131695801));
  }
  
  public void i() {}
  
  public void j() {}
  
  public void o()
  {
    super.o();
    ajfi.a().d();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_e_of_type_Boolean) {
      azqs.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.keyback", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return super.onBackEvent();
      azqs.b(getActivity().app, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.back", 0, 0, "", "", "", "");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    b(this.jdField_a_of_type_AndroidWidgetImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketVoiceFragment
 * JD-Core Version:    0.7.0.1
 */
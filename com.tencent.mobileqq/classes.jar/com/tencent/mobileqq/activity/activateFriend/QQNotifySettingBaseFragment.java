package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.activateFriend.biz.INotifyMsg;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.qwallet.plugin.IFakeUrl;
import cooperation.qzone.mobilereport.MobileReportManager;
import mqq.app.AppRuntime;

public abstract class QQNotifySettingBaseFragment
  extends PublicBaseFragment
  implements View.OnClickListener, INotifyMsg
{
  public static final int a;
  private static final String b;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  protected View a;
  protected Button a;
  protected TextView a;
  private QQNotifyLoadingDialog jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifyLoadingDialog;
  private IQQReminderDataService jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService;
  private IFakeUrl jdField_a_of_type_CooperationQwalletPluginIFakeUrl;
  protected String a;
  protected boolean a;
  protected int b;
  protected TextView b;
  private String c;
  private String d;
  private String e;
  
  static
  {
    jdField_b_of_type_JavaLangString = QQNotifySettingBaseFragment.class.getSimpleName();
    jdField_a_of_type_Int = WebViewUtil.a("qw_mix") << 8;
  }
  
  public QQNotifySettingBaseFragment()
  {
    this.jdField_b_of_type_Int = 9;
    this.jdField_a_of_type_JavaLangString = "user cancel";
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void b()
  {
    IQQReminderService localIQQReminderService = (IQQReminderService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IQQReminderService.class, "");
    if (localIQQReminderService == null) {
      return;
    }
    localIQQReminderService.sendGetMsgs(this.c, this.e, new QQNotifySettingBaseFragment.1(this));
  }
  
  private void c()
  {
    IQQReminderService localIQQReminderService = (IQQReminderService)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IQQReminderService.class, "");
    if (localIQQReminderService == null) {
      return;
    }
    localIQQReminderService.sendSubscribeReminder(this.c, this.e, new QQNotifySettingBaseFragment.2(this));
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  protected void a(int paramInt, String paramString)
  {
    if (getActivity() != null)
    {
      c(paramInt, paramString);
      getActivity().finish();
    }
  }
  
  public void a(AcsGetMsgRsp paramAcsGetMsgRsp)
  {
    long l;
    if (paramAcsGetMsgRsp != null)
    {
      if (paramAcsGetMsgRsp.ret_code != 0) {
        break label74;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAcsGetMsgRsp.content);
      l = paramAcsGetMsgRsp.notice_time;
      if (l != 0L) {
        break label54;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131710547));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      label54:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(DateUtil.a(l * 1000L, "yyyy-MM-dd HH:mm:ss"));
    }
    label74:
    a();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifyLoadingDialog = new QQNotifyLoadingDialog(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifyLoadingDialog.show();
    this.jdField_a_of_type_CooperationQwalletPluginIFakeUrl = ((IFakeUrl)QRoute.api(IFakeUrl.class));
    this.jdField_a_of_type_CooperationQwalletPluginIFakeUrl.init(getActivity());
    b();
    MobileReportManager.getInstance().reportActionOfNotice("qqremind", "1", "1", 100, this.c, "15", 1);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = (String)paramView.getTag();
      if ("0".equals(str))
      {
        QQNotifyHelper.a(a(), "open_click", this.d, this.c, null, null);
        c();
      }
      else if ("1".equals(str))
      {
        a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
        continue;
        QQNotifyHelper.a(a(), "pending_click", this.d, this.c, null, null);
        a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = a(paramLayoutInflater, paramViewGroup);
    new ImmersionBar(getActivity(), 0, this.jdField_a_of_type_AndroidViewView.findViewById(2131378435));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380490));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380491));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364142));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c = getArguments().getString("key_msgid");
    this.d = getArguments().getString("key_busid");
    this.e = getArguments().getString("key_domain");
    this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService = ((IQQReminderDataService)a().getRuntimeService(IQQReminderDataService.class, ""));
    QQNotifyHelper.a(a(), "authorizepage_exp", this.d, this.c, null, null);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifyLoadingDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifyLoadingDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifyLoadingDialog.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment
 * JD-Core Version:    0.7.0.1
 */
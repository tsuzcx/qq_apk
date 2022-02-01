package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.activateFriend.biz.INotifyMsg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qwallet.plugin.FakeUrl;
import cooperation.qzone.mobilereport.MobileReportManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class QQNotifySettingBaseFragment
  extends PublicBaseFragment
  implements View.OnClickListener, INotifyMsg
{
  public static final int a;
  private static final String jdField_b_of_type_JavaLangString = "QQNotifySettingBaseFragment";
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  protected View a;
  protected Button a;
  protected CheckBox a;
  protected TextView a;
  private QQNotifyLoadingDialog jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifyLoadingDialog;
  private IQQReminderDataService jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService;
  private CalendarEntity jdField_a_of_type_ComTencentMobileqqReminderBizEntityCalendarEntity;
  private FakeUrl jdField_a_of_type_CooperationQwalletPluginFakeUrl;
  protected String a;
  protected boolean a;
  protected int b;
  protected TextView b;
  boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  private String e;
  
  static
  {
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
  
  private CalendarEntity a(AcsGetMsgRsp paramAcsGetMsgRsp)
  {
    CalendarEntity localCalendarEntity = new CalendarEntity();
    localCalendarEntity.content = "";
    localCalendarEntity.msg_id = this.c;
    localCalendarEntity.notice_time = paramAcsGetMsgRsp.notice_time;
    localCalendarEntity.title = paramAcsGetMsgRsp.title;
    localCalendarEntity.jump_url = paramAcsGetMsgRsp.jump_url;
    return localCalendarEntity;
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
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    IQQReminderService localIQQReminderService = (IQQReminderService)localQQAppInterface.getRuntimeService(IQQReminderService.class, "");
    if (localIQQReminderService == null) {
      return;
    }
    localIQQReminderService.sendSubscribeReminder(this.c, this.e, new QQNotifySettingBaseFragment.2(this, localQQAppInterface));
  }
  
  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  protected void a(int paramInt, String paramString)
  {
    if (getBaseActivity() != null)
    {
      c(paramInt, paramString);
      getBaseActivity().finish();
    }
  }
  
  public void a(AcsGetMsgRsp paramAcsGetMsgRsp)
  {
    if (paramAcsGetMsgRsp != null) {
      if (paramAcsGetMsgRsp.ret_code == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAcsGetMsgRsp.content);
        long l = paramAcsGetMsgRsp.notice_time;
        if (l == 0L) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131710526));
        } else {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(DateUtil.a(l * 1000L, "yyyy-MM-dd HH:mm:ss"));
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        int i;
        if (paramAcsGetMsgRsp.calendar == 1) {
          i = 1;
        } else {
          i = 0;
        }
        paramAcsGetMsgRsp = this.jdField_a_of_type_AndroidWidgetCheckBox;
        if ((paramAcsGetMsgRsp != null) && (i != 0) && (this.jdField_b_of_type_Boolean))
        {
          paramAcsGetMsgRsp.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        }
      }
      else
      {
        a();
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
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
    this.jdField_b_of_type_Boolean = ((IQQReminderCalendarService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQReminderCalendarService.class, "")).isCalendarOpen(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifyLoadingDialog = new QQNotifyLoadingDialog(getBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifyLoadingDialog.show();
    this.jdField_a_of_type_CooperationQwalletPluginFakeUrl = new FakeUrl();
    this.jdField_a_of_type_CooperationQwalletPluginFakeUrl.init(getBaseActivity());
    b();
    MobileReportManager.getInstance().reportActionOfNotice("qqremind", "1", "1", 100, this.c, "15", 1);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363890)
    {
      if (i == 2131364063)
      {
        String str = (String)paramView.getTag();
        if ("0".equals(str))
        {
          QQNotifyHelper.a(a(), "open_click", this.d, this.c, null, null);
          c();
        }
        else if ("1".equals(str))
        {
          a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    else
    {
      QQNotifyHelper.a(a(), "pending_click", this.d, this.c, null, null);
      a(this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = a(paramLayoutInflater, paramViewGroup);
    new ImmersionBar(getBaseActivity(), 0, this.jdField_a_of_type_AndroidViewView.findViewById(2131377849));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379791));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379792));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewView.findViewById(2131364597));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364063));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c = getArguments().getString("key_msgid");
    this.d = getArguments().getString("key_busid");
    this.e = getArguments().getString("key_domain");
    this.jdField_a_of_type_ComTencentMobileqqReminderApiIQQReminderDataService = ((IQQReminderDataService)a().getRuntimeService(IQQReminderDataService.class, ""));
    QQNotifyHelper.a(a(), "authorizepage_exp", this.d, this.c, null, null);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifyLoadingDialog;
    if ((localObject != null) && (((QQNotifyLoadingDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendQQNotifyLoadingDialog.dismiss();
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment
 * JD-Core Version:    0.7.0.1
 */
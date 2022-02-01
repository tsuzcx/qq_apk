package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean.UIElement;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;

@SuppressLint({"ViewConstructor"})
public class PhoneMatchView
  extends BaseActivityView
  implements Handler.Callback, View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver;
  
  public PhoneMatchView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(2131559216, true);
  }
  
  private void j()
  {
    if (!NetworkUtil.isNetSupport(getContext()))
    {
      b(2131694475);
      return;
    }
    PhoneMatchView.1 local1 = new PhoneMatchView.1(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new DenyRunnable.JumpSettingAction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    PermissionChecker.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, local1, localDenyRunnable);
  }
  
  protected void a()
  {
    super.a();
    this.b.setText(HardCodeUtil.a(2131708017));
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694817);
      return;
    }
    if (this.jdField_a_of_type_Int == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 != 0))
    {
      if (paramInt2 == 2)
      {
        paramIntent = new Intent(getContext(), BindNumberActivity.class);
        paramIntent.putExtra("kNeedUnbind", true);
        a(paramIntent);
        return;
      }
      a(new Intent(getContext(), PhoneLaunchActivity.class));
      return;
    }
    if (paramInt1 == 9999)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
      if ((((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true)) && ((getContext() instanceof Activity)))
      {
        paramIntent = (Activity)getContext();
        ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 2, null);
        paramIntent.setResult(-1);
        paramIntent.finish();
      }
    }
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    super.a(paramIntent, paramPhoneInnerFrame);
    paramPhoneInnerFrame = ((INewFriendApi)QRoute.api(INewFriendApi.class)).loadNewFriendContactGuideConfig();
    String str;
    if (PermissionChecker.a().b())
    {
      str = paramPhoneInnerFrame.b.a;
      paramIntent = paramPhoneInnerFrame.b.b;
      paramPhoneInnerFrame = paramPhoneInnerFrame.b.c;
    }
    else
    {
      str = paramPhoneInnerFrame.a.a;
      paramIntent = paramPhoneInnerFrame.a.b;
      paramPhoneInnerFrame = paramPhoneInnerFrame.a.c;
    }
    ((TextView)a(2131365112)).setText(str);
    ((TextView)a(2131365111)).setText(paramIntent);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131365109));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setText(paramPhoneInnerFrame);
    paramIntent = a(2131369736);
    if ((paramIntent != null) && ("1000".equals(ThemeUtil.curThemeId))) {
      paramIntent.setBackgroundResource(2130839393);
    } else if (paramIntent != null) {
      paramIntent.setBackgroundResource(2130838739);
    }
    PhoneContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getResources(), (ImageView)a(2131365110));
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    boolean bool = QLog.isColorLevel();
    int i = 1;
    if (bool) {
      QLog.i("PhoneMatchView", 2, String.format("onUploadResult [%s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = null;
    }
    g();
    if (paramBoolean) {
      a(new Intent(getContext(), ContactListView.class));
    }
    if (paramBoolean) {
      paramString = HardCodeUtil.a(2131708019);
    } else {
      paramString = HardCodeUtil.a(2131708020);
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    paramInt = i;
    if (paramBoolean) {
      paramInt = 2;
    }
    QQToast.a(localBaseApplication, paramInt, paramString, 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131299168));
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = null;
    }
    super.d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      int i = ((IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "")).getSelfBindState();
      if ((i != 2) && (i != 4) && (i != 9) && (i != 8))
      {
        a(false, -1, "MSG_TIME_OUT");
        return true;
      }
      a(true, 0, "MSG_TIME_OUT");
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      j();
    } else {
      a(new Intent(getContext(), SettingActivity2.class), 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchView
 * JD-Core Version:    0.7.0.1
 */
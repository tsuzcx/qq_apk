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
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.config.business.NewFriendContactGuideConfBean.UIElement;
import com.tencent.mobileqq.config.business.NewFriendContactGuideConfProcessor;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
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
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  
  public PhoneMatchView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(2131559339, true);
  }
  
  private void j()
  {
    if (!NetworkUtil.d(getContext()))
    {
      b(2131694510);
      return;
    }
    PhoneMatchView.1 local1 = new PhoneMatchView.1(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, new DenyRunnable.JumpSettingAction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    PermissionChecker.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, local1, localDenyRunnable);
  }
  
  protected void a()
  {
    super.a();
    this.b.setText(HardCodeUtil.a(2131707998));
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694831);
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
    if ((paramInt1 == 1) && (paramInt2 != 0)) {
      if (paramInt2 == 2)
      {
        paramIntent = new Intent(getContext(), BindNumberActivity.class);
        paramIntent.putExtra("kNeedUnbind", true);
        a(paramIntent);
      }
    }
    do
    {
      do
      {
        return;
        a(new Intent(getContext(), PhoneLaunchActivity.class));
        return;
      } while (paramInt1 != 99999);
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
    } while ((!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a(true)) || (!(getContext() instanceof Activity)));
    paramIntent = (Activity)getContext();
    ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 2, null);
    paramIntent.setResult(-1);
    paramIntent.finish();
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    super.a(paramIntent, paramPhoneInnerFrame);
    paramIntent = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    Object localObject = NewFriendContactGuideConfProcessor.a();
    if (paramIntent.k())
    {
      paramPhoneInnerFrame = ((NewFriendContactGuideConfBean)localObject).b.a;
      paramIntent = ((NewFriendContactGuideConfBean)localObject).b.b;
      localObject = ((NewFriendContactGuideConfBean)localObject).b.c;
      ((TextView)a(2131365235)).setText(paramPhoneInnerFrame);
      ((TextView)a(2131365234)).setText(paramIntent);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131365232));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      paramIntent = a(2131370057);
      if ((paramIntent == null) || (!"1000".equals(ThemeUtil.curThemeId))) {
        break label186;
      }
      paramIntent.setBackgroundResource(2130839537);
    }
    for (;;)
    {
      PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getResources(), (ImageView)a(2131365233));
      return;
      paramPhoneInnerFrame = ((NewFriendContactGuideConfBean)localObject).a.a;
      paramIntent = ((NewFriendContactGuideConfBean)localObject).a.b;
      localObject = ((NewFriendContactGuideConfBean)localObject).a.c;
      break;
      label186:
      if (paramIntent != null) {
        paramIntent.setBackgroundResource(2130838979);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("PhoneMatchView", 2, String.format("onUploadResult [%s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    g();
    if (paramBoolean) {
      a(new Intent(getContext(), ContactListView.class));
    }
    BaseApplication localBaseApplication;
    if (paramBoolean)
    {
      paramString = HardCodeUtil.a(2131708000);
      localBaseApplication = BaseApplicationImpl.getContext();
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (paramInt = i;; paramInt = 1)
    {
      QQToast.a(localBaseApplication, paramInt, paramString, 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131299166));
      return;
      paramString = HardCodeUtil.a(2131708001);
      break;
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    super.d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      int i = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).d();
      if ((i == 2) || (i == 4) || (i == 9) || (i == 8)) {
        a(true, 0, "MSG_TIME_OUT");
      }
    }
    else
    {
      return true;
    }
    a(false, -1, "MSG_TIME_OUT");
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      j();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(new Intent(getContext(), SettingActivity2.class), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchView
 * JD-Core Version:    0.7.0.1
 */
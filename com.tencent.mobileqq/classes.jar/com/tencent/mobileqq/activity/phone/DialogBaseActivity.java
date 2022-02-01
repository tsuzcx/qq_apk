package com.tencent.mobileqq.activity.phone;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  private View jdField_a_of_type_AndroidViewView;
  public PhoneContactManagerImp a;
  private DialogBaseActivity.UiHandler jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity$UiHandler;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
  public void a(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity$UiHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((DialogBaseActivity.UiHandler)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity$UiHandler.sendMessageDelayed((Message)localObject, paramLong);
      return;
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (!isFinishing()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if ((!isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new DialogBaseActivity.4(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      DialogUtil.a(this, 231, paramString1, paramString2, new DialogBaseActivity.1(this), null).show();
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity$UiHandler.hasMessages(1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity$UiHandler.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return true;
    }
    return bool;
  }
  
  void c(boolean paramBoolean)
  {
    String str3;
    String str1;
    if (!isFinishing())
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      str3 = getResources().getString(2131694763);
      if (!paramBoolean) {
        break label103;
      }
      str1 = HardCodeUtil.a(2131703276);
      if (!paramBoolean) {
        break label112;
      }
    }
    label103:
    label112:
    for (String str2 = HardCodeUtil.a(2131703279);; str2 = HardCodeUtil.a(2131703277))
    {
      DialogUtil.a(this, 230, str1, str3, HardCodeUtil.a(2131703278), str2, new DialogBaseActivity.2(this, paramBoolean), new DialogBaseActivity.3(this, paramBoolean)).show();
      return;
      str1 = HardCodeUtil.a(2131703275);
      break;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity$UiHandler = new DialogBaseActivity.UiHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(QQManagerFactory.CONTACT_MANAGER));
    return true;
  }
  
  public View findViewById(int paramInt)
  {
    View localView1 = null;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
    }
    View localView2 = localView1;
    if (localView1 == null) {
      localView2 = super.findViewById(paramInt);
    }
    return localView2;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = setContentViewB(paramInt);
  }
  
  public String setLastActivityName()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity
 * JD-Core Version:    0.7.0.1
 */
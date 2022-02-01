package com.tencent.mobileqq.activity.phone;

import Override;
import akdj;
import akdk;
import akdl;
import akdm;
import akdn;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import anni;
import bcst;
import bglp;
import bgpa;
import biau;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  private akdn jdField_a_of_type_Akdn;
  private View jdField_a_of_type_AndroidViewView;
  public biau a;
  public PhoneContactManagerImp a;
  
  public void a(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Akdn;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((akdn)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_Akdn.sendMessageDelayed((Message)localObject, paramLong);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isFinishing()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((!isFinishing()) && (this.jdField_a_of_type_Biau == null))
    {
      this.jdField_a_of_type_Biau = new biau(this, getTitleBarHeight());
      this.jdField_a_of_type_Biau.setOnDismissListener(new akdm(this));
      this.jdField_a_of_type_Biau.c(paramInt);
      this.jdField_a_of_type_Biau.setCancelable(paramBoolean);
      this.jdField_a_of_type_Biau.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Biau.show();
    }
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      bglp.a(this, 231, paramString1, paramString2, new akdj(this), null).show();
    }
  }
  
  void a(boolean paramBoolean)
  {
    String str3;
    String str1;
    if (!isFinishing())
    {
      bcst.b(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      str3 = getResources().getString(2131694204);
      if (!paramBoolean) {
        break label103;
      }
      str1 = anni.a(2131702035);
      if (!paramBoolean) {
        break label112;
      }
    }
    label103:
    label112:
    for (String str2 = anni.a(2131702038);; str2 = anni.a(2131702036))
    {
      bglp.a(this, 230, str1, str3, anni.a(2131702037), str2, new akdk(this, paramBoolean), new akdl(this, paramBoolean)).show();
      return;
      str1 = anni.a(2131702034);
      break;
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Akdn.hasMessages(1))
    {
      this.jdField_a_of_type_Akdn.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_Biau != null)
    {
      this.jdField_a_of_type_Biau.cancel();
      this.jdField_a_of_type_Biau.setOnDismissListener(null);
      this.jdField_a_of_type_Biau = null;
      return true;
    }
    return bool;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Akdn = new akdn(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(11));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity
 * JD-Core Version:    0.7.0.1
 */
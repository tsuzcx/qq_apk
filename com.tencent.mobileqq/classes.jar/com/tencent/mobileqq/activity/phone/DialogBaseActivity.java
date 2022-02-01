package com.tencent.mobileqq.activity.phone;

import Override;
import akih;
import akii;
import akij;
import akik;
import akil;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import anvx;
import bdla;
import bhdj;
import bisl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  private akil jdField_a_of_type_Akil;
  private View jdField_a_of_type_AndroidViewView;
  public bisl a;
  public PhoneContactManagerImp a;
  
  public void a(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Akil;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((akil)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_Akil.sendMessageDelayed((Message)localObject, paramLong);
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
    if ((!isFinishing()) && (this.jdField_a_of_type_Bisl == null))
    {
      this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
      this.jdField_a_of_type_Bisl.setOnDismissListener(new akik(this));
      this.jdField_a_of_type_Bisl.c(paramInt);
      this.jdField_a_of_type_Bisl.setCancelable(paramBoolean);
      this.jdField_a_of_type_Bisl.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      bhdj.a(this, 231, paramString1, paramString2, new akih(this), null).show();
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Akil.hasMessages(1))
    {
      this.jdField_a_of_type_Akil.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_Bisl != null)
    {
      this.jdField_a_of_type_Bisl.cancel();
      this.jdField_a_of_type_Bisl.setOnDismissListener(null);
      this.jdField_a_of_type_Bisl = null;
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
      bdla.b(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      str3 = getResources().getString(2131694544);
      if (!paramBoolean) {
        break label103;
      }
      str1 = anvx.a(2131702728);
      if (!paramBoolean) {
        break label112;
      }
    }
    label103:
    label112:
    for (String str2 = anvx.a(2131702731);; str2 = anvx.a(2131702729))
    {
      bhdj.a(this, 230, str1, str3, anvx.a(2131702730), str2, new akii(this, paramBoolean), new akij(this, paramBoolean)).show();
      return;
      str1 = anvx.a(2131702727);
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
    this.jdField_a_of_type_Akil = new akil(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity
 * JD-Core Version:    0.7.0.1
 */
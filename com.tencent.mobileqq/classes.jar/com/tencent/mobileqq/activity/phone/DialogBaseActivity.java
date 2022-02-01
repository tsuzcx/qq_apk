package com.tencent.mobileqq.activity.phone;

import Override;
import akou;
import akov;
import akow;
import akox;
import akoy;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import anzj;
import bdll;
import bhlq;
import bhpc;
import bjbs;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  private akoy jdField_a_of_type_Akoy;
  private View jdField_a_of_type_AndroidViewView;
  public bjbs a;
  public PhoneContactManagerImp a;
  
  public void a(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Akoy;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((akoy)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_Akoy.sendMessageDelayed((Message)localObject, paramLong);
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
    if ((!isFinishing()) && (this.jdField_a_of_type_Bjbs == null))
    {
      this.jdField_a_of_type_Bjbs = new bjbs(this, getTitleBarHeight());
      this.jdField_a_of_type_Bjbs.setOnDismissListener(new akox(this));
      this.jdField_a_of_type_Bjbs.c(paramInt);
      this.jdField_a_of_type_Bjbs.setCancelable(paramBoolean);
      this.jdField_a_of_type_Bjbs.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bjbs.show();
    }
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      bhlq.a(this, 231, paramString1, paramString2, new akou(this), null).show();
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Akoy.hasMessages(1))
    {
      this.jdField_a_of_type_Akoy.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_Bjbs != null)
    {
      this.jdField_a_of_type_Bjbs.cancel();
      this.jdField_a_of_type_Bjbs.setOnDismissListener(null);
      this.jdField_a_of_type_Bjbs = null;
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
      bdll.b(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      str3 = getResources().getString(2131694229);
      if (!paramBoolean) {
        break label103;
      }
      str1 = anzj.a(2131702142);
      if (!paramBoolean) {
        break label112;
      }
    }
    label103:
    label112:
    for (String str2 = anzj.a(2131702145);; str2 = anzj.a(2131702143))
    {
      bhlq.a(this, 230, str1, str3, anzj.a(2131702144), str2, new akov(this, paramBoolean), new akow(this, paramBoolean)).show();
      return;
      str1 = anzj.a(2131702141);
      break;
    }
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
    this.jdField_a_of_type_Akoy = new akoy(this);
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
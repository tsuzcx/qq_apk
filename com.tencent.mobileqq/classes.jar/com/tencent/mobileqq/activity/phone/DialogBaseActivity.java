package com.tencent.mobileqq.activity.phone;

import Override;
import ajmt;
import ajmu;
import ajmv;
import ajmw;
import ajmx;
import amtj;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import bcef;
import bfur;
import bhht;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  private ajmx jdField_a_of_type_Ajmx;
  private View jdField_a_of_type_AndroidViewView;
  public bhht a;
  public PhoneContactManagerImp a;
  
  public void a(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Ajmx;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((ajmx)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_Ajmx.sendMessageDelayed((Message)localObject, paramLong);
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
    if ((!isFinishing()) && (this.jdField_a_of_type_Bhht == null))
    {
      this.jdField_a_of_type_Bhht = new bhht(this, getTitleBarHeight());
      this.jdField_a_of_type_Bhht.setOnDismissListener(new ajmw(this));
      this.jdField_a_of_type_Bhht.c(paramInt);
      this.jdField_a_of_type_Bhht.setCancelable(paramBoolean);
      this.jdField_a_of_type_Bhht.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bhht.show();
    }
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      bfur.a(this, 231, paramString1, paramString2, new ajmt(this), null).show();
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Ajmx.hasMessages(1))
    {
      this.jdField_a_of_type_Ajmx.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_Bhht != null)
    {
      this.jdField_a_of_type_Bhht.cancel();
      this.jdField_a_of_type_Bhht.setOnDismissListener(null);
      this.jdField_a_of_type_Bhht = null;
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
      bcef.b(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      str3 = getResources().getString(2131694343);
      if (!paramBoolean) {
        break label103;
      }
      str1 = amtj.a(2131702377);
      if (!paramBoolean) {
        break label112;
      }
    }
    label103:
    label112:
    for (String str2 = amtj.a(2131702380);; str2 = amtj.a(2131702378))
    {
      bfur.a(this, 230, str1, str3, amtj.a(2131702379), str2, new ajmu(this, paramBoolean), new ajmv(this, paramBoolean)).show();
      return;
      str1 = amtj.a(2131702376);
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
    this.jdField_a_of_type_Ajmx = new ajmx(this);
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
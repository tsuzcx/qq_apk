package com.tencent.mobileqq.activity.phone;

import afya;
import afyb;
import afyc;
import afyd;
import afye;
import ajjy;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import awqx;
import babr;
import bafb;
import bbms;
import bbmy;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  private afye jdField_a_of_type_Afye;
  private View jdField_a_of_type_AndroidViewView;
  public bbms a;
  public PhoneContactManagerImp a;
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Afye;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((afye)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_Afye.sendMessageDelayed((Message)localObject, paramLong);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isFinishing()) {
      bbmy.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((!isFinishing()) && (this.jdField_a_of_type_Bbms == null))
    {
      this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
      this.jdField_a_of_type_Bbms.setOnDismissListener(new afyd(this));
      this.jdField_a_of_type_Bbms.c(paramInt);
      this.jdField_a_of_type_Bbms.setCancelable(paramBoolean);
      this.jdField_a_of_type_Bbms.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bbms.show();
    }
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      babr.a(this, 231, paramString1, paramString2, new afya(this), null).show();
    }
  }
  
  void a(boolean paramBoolean)
  {
    String str3;
    String str1;
    if (!isFinishing())
    {
      awqx.b(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      str3 = getResources().getString(2131629324);
      if (!paramBoolean) {
        break label103;
      }
      str1 = ajjy.a(2131637458);
      if (!paramBoolean) {
        break label112;
      }
    }
    label103:
    label112:
    for (String str2 = ajjy.a(2131637461);; str2 = ajjy.a(2131637459))
    {
      babr.a(this, 230, str1, str3, ajjy.a(2131637460), str2, new afyb(this, paramBoolean), new afyc(this, paramBoolean)).show();
      return;
      str1 = ajjy.a(2131637457);
      break;
    }
  }
  
  public void b(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Afye.hasMessages(1))
    {
      this.jdField_a_of_type_Afye.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_Bbms != null)
    {
      this.jdField_a_of_type_Bbms.cancel();
      this.jdField_a_of_type_Bbms.setOnDismissListener(null);
      this.jdField_a_of_type_Bbms = null;
      return true;
    }
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Afye = new afye(this);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(11));
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
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = setContentViewB(paramInt);
  }
  
  public String setLastActivityName()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.phone;

import agjy;
import agjz;
import agka;
import agkb;
import agkc;
import ajyc;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import axqw;
import bbcv;
import bbgg;
import bcpq;
import bcpw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  private agkc jdField_a_of_type_Agkc;
  private View jdField_a_of_type_AndroidViewView;
  public bcpq a;
  public PhoneContactManagerImp a;
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Agkc;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((agkc)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_Agkc.sendMessageDelayed((Message)localObject, paramLong);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isFinishing()) {
      bcpw.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((!isFinishing()) && (this.jdField_a_of_type_Bcpq == null))
    {
      this.jdField_a_of_type_Bcpq = new bcpq(this, getTitleBarHeight());
      this.jdField_a_of_type_Bcpq.setOnDismissListener(new agkb(this));
      this.jdField_a_of_type_Bcpq.c(paramInt);
      this.jdField_a_of_type_Bcpq.setCancelable(paramBoolean);
      this.jdField_a_of_type_Bcpq.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bcpq.show();
    }
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      bbcv.a(this, 231, paramString1, paramString2, new agjy(this), null).show();
    }
  }
  
  void a(boolean paramBoolean)
  {
    String str3;
    String str1;
    if (!isFinishing())
    {
      axqw.b(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      str3 = getResources().getString(2131695001);
      if (!paramBoolean) {
        break label103;
      }
      str1 = ajyc.a(2131703243);
      if (!paramBoolean) {
        break label112;
      }
    }
    label103:
    label112:
    for (String str2 = ajyc.a(2131703246);; str2 = ajyc.a(2131703244))
    {
      bbcv.a(this, 230, str1, str3, ajyc.a(2131703245), str2, new agjz(this, paramBoolean), new agka(this, paramBoolean)).show();
      return;
      str1 = ajyc.a(2131703242);
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
    if (this.jdField_a_of_type_Agkc.hasMessages(1))
    {
      this.jdField_a_of_type_Agkc.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_Bcpq != null)
    {
      this.jdField_a_of_type_Bcpq.cancel();
      this.jdField_a_of_type_Bcpq.setOnDismissListener(null);
      this.jdField_a_of_type_Bcpq = null;
      return true;
    }
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Agkc = new agkc(this);
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
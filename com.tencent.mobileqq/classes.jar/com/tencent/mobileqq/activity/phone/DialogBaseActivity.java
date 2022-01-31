package com.tencent.mobileqq.activity.phone;

import agjw;
import agjx;
import agjy;
import agjz;
import agka;
import ajya;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import axqy;
import bbdj;
import bbgu;
import bcqf;
import bcql;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  private agka jdField_a_of_type_Agka;
  private View jdField_a_of_type_AndroidViewView;
  public bcqf a;
  public PhoneContactManagerImp a;
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Agka;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((agka)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_Agka.sendMessageDelayed((Message)localObject, paramLong);
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isFinishing()) {
      bcql.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((!isFinishing()) && (this.jdField_a_of_type_Bcqf == null))
    {
      this.jdField_a_of_type_Bcqf = new bcqf(this, getTitleBarHeight());
      this.jdField_a_of_type_Bcqf.setOnDismissListener(new agjz(this));
      this.jdField_a_of_type_Bcqf.c(paramInt);
      this.jdField_a_of_type_Bcqf.setCancelable(paramBoolean);
      this.jdField_a_of_type_Bcqf.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bcqf.show();
    }
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      bbdj.a(this, 231, paramString1, paramString2, new agjw(this), null).show();
    }
  }
  
  void a(boolean paramBoolean)
  {
    String str3;
    String str1;
    if (!isFinishing())
    {
      axqy.b(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      str3 = getResources().getString(2131695002);
      if (!paramBoolean) {
        break label103;
      }
      str1 = ajya.a(2131703254);
      if (!paramBoolean) {
        break label112;
      }
    }
    label103:
    label112:
    for (String str2 = ajya.a(2131703257);; str2 = ajya.a(2131703255))
    {
      bbdj.a(this, 230, str1, str3, ajya.a(2131703256), str2, new agjx(this, paramBoolean), new agjy(this, paramBoolean)).show();
      return;
      str1 = ajya.a(2131703253);
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
    if (this.jdField_a_of_type_Agka.hasMessages(1))
    {
      this.jdField_a_of_type_Agka.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_Bcqf != null)
    {
      this.jdField_a_of_type_Bcqf.cancel();
      this.jdField_a_of_type_Bcqf.setOnDismissListener(null);
      this.jdField_a_of_type_Bcqf = null;
      return true;
    }
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Agka = new agka(this);
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
package com.tencent.mobileqq.activity.phone;

import aimp;
import aimq;
import aimr;
import aims;
import aimt;
import alud;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import azqs;
import bdgm;
import bdjz;
import bety;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  private aimt jdField_a_of_type_Aimt;
  private View jdField_a_of_type_AndroidViewView;
  public bety a;
  public PhoneContactManagerImp a;
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Aimt;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((aimt)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_Aimt.sendMessageDelayed((Message)localObject, paramLong);
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
    if ((!isFinishing()) && (this.jdField_a_of_type_Bety == null))
    {
      this.jdField_a_of_type_Bety = new bety(this, getTitleBarHeight());
      this.jdField_a_of_type_Bety.setOnDismissListener(new aims(this));
      this.jdField_a_of_type_Bety.c(paramInt);
      this.jdField_a_of_type_Bety.setCancelable(paramBoolean);
      this.jdField_a_of_type_Bety.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bety.show();
    }
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      bdgm.a(this, 231, paramString1, paramString2, new aimp(this), null).show();
    }
  }
  
  void a(boolean paramBoolean)
  {
    String str3;
    String str1;
    if (!isFinishing())
    {
      azqs.b(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      str3 = getResources().getString(2131695161);
      if (!paramBoolean) {
        break label103;
      }
      str1 = alud.a(2131703638);
      if (!paramBoolean) {
        break label112;
      }
    }
    label103:
    label112:
    for (String str2 = alud.a(2131703641);; str2 = alud.a(2131703639))
    {
      bdgm.a(this, 230, str1, str3, alud.a(2131703640), str2, new aimq(this, paramBoolean), new aimr(this, paramBoolean)).show();
      return;
      str1 = alud.a(2131703637);
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
    if (this.jdField_a_of_type_Aimt.hasMessages(1))
    {
      this.jdField_a_of_type_Aimt.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_Bety != null)
    {
      this.jdField_a_of_type_Bety.cancel();
      this.jdField_a_of_type_Bety.setOnDismissListener(null);
      this.jdField_a_of_type_Bety = null;
      return true;
    }
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Aimt = new aimt(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity
 * JD-Core Version:    0.7.0.1
 */
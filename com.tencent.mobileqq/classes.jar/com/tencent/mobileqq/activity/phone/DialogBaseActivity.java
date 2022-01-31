package com.tencent.mobileqq.activity.phone;

import aiia;
import aiib;
import aiic;
import aiid;
import aiie;
import alpo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import azmj;
import bdcd;
import bdfq;
import bepp;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class DialogBaseActivity
  extends IphoneTitleBarActivity
{
  private aiie jdField_a_of_type_Aiie;
  private View jdField_a_of_type_AndroidViewView;
  public bepp a;
  public PhoneContactManagerImp a;
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_Aiie;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localObject = ((aiie)localObject).obtainMessage(1, paramInt, i);
      this.jdField_a_of_type_Aiie.sendMessageDelayed((Message)localObject, paramLong);
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
    if ((!isFinishing()) && (this.jdField_a_of_type_Bepp == null))
    {
      this.jdField_a_of_type_Bepp = new bepp(this, getTitleBarHeight());
      this.jdField_a_of_type_Bepp.setOnDismissListener(new aiid(this));
      this.jdField_a_of_type_Bepp.c(paramInt);
      this.jdField_a_of_type_Bepp.setCancelable(paramBoolean);
      this.jdField_a_of_type_Bepp.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bepp.show();
    }
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!isFinishing()) {
      bdcd.a(this, 231, paramString1, paramString2, new aiia(this), null).show();
    }
  }
  
  void a(boolean paramBoolean)
  {
    String str3;
    String str1;
    if (!isFinishing())
    {
      azmj.b(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
      str3 = getResources().getString(2131695159);
      if (!paramBoolean) {
        break label103;
      }
      str1 = alpo.a(2131703626);
      if (!paramBoolean) {
        break label112;
      }
    }
    label103:
    label112:
    for (String str2 = alpo.a(2131703629);; str2 = alpo.a(2131703627))
    {
      bdcd.a(this, 230, str1, str3, alpo.a(2131703628), str2, new aiib(this, paramBoolean), new aiic(this, paramBoolean)).show();
      return;
      str1 = alpo.a(2131703625);
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
    if (this.jdField_a_of_type_Aiie.hasMessages(1))
    {
      this.jdField_a_of_type_Aiie.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_Bepp != null)
    {
      this.jdField_a_of_type_Bepp.cancel();
      this.jdField_a_of_type_Bepp.setOnDismissListener(null);
      this.jdField_a_of_type_Bepp = null;
      return true;
    }
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Aiie = new aiie(this);
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
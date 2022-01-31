package com.tencent.mobileqq.activity;

import acdr;
import acds;
import android.content.Intent;
import com.tencent.qphone.base.remote.SimpleAccount;

public class SubAccountBindActivity$3$1$1
  implements Runnable
{
  public SubAccountBindActivity$3$1$1(acds paramacds) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Acdr.a.c();
    this.a.jdField_a_of_type_Acdr.a.b(this.a.jdField_a_of_type_Acdr.a.getString(2131719915));
    Intent localIntent = new Intent(this.a.jdField_a_of_type_Acdr.a, SubLoginActivity.class);
    localIntent.putExtra("subuin", this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    localIntent.putExtra("fromWhere", this.a.jdField_a_of_type_Acdr.a.b);
    this.a.jdField_a_of_type_Acdr.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.3.1.1
 * JD-Core Version:    0.7.0.1
 */
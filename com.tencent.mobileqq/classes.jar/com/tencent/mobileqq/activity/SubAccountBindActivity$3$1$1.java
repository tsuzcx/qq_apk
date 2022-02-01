package com.tencent.mobileqq.activity;

import afpe;
import afpf;
import android.content.Intent;
import com.tencent.qphone.base.remote.SimpleAccount;

public class SubAccountBindActivity$3$1$1
  implements Runnable
{
  public SubAccountBindActivity$3$1$1(afpf paramafpf) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Afpe.a.e();
    this.a.jdField_a_of_type_Afpe.a.b(this.a.jdField_a_of_type_Afpe.a.getString(2131718449));
    Intent localIntent = new Intent(this.a.jdField_a_of_type_Afpe.a, SubLoginActivity.class);
    localIntent.putExtra("subuin", this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    localIntent.putExtra("fromWhere", this.a.jdField_a_of_type_Afpe.a.b);
    this.a.jdField_a_of_type_Afpe.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.3.1.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import aert;
import android.text.TextUtils;
import bftf;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;

class TroopTransferActivity$15
  implements Runnable
{
  TroopTransferActivity$15(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, aert paramaert) {}
  
  public void run()
  {
    label166:
    String str;
    label187:
    boolean bool;
    if (!bftf.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_Aert.j))
    {
      this.jdField_a_of_type_Aert.j = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aert.m))
      {
        this.jdField_a_of_type_Aert.k = ChnToSpell.a(this.jdField_a_of_type_Aert.m, 2);
        this.jdField_a_of_type_Aert.l = ChnToSpell.a(this.jdField_a_of_type_Aert.m, 1);
      }
    }
    else
    {
      if (!bftf.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_Aert.g))
      {
        this.jdField_a_of_type_Aert.g = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Aert.g)) {
          break label290;
        }
        this.jdField_a_of_type_Aert.h = ChnToSpell.a(this.jdField_a_of_type_Aert.g, 2);
        this.jdField_a_of_type_Aert.i = ChnToSpell.a(this.jdField_a_of_type_Aert.g, 1);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Aert.j)) {
        break label311;
      }
      str = this.jdField_a_of_type_Aert.j;
      if (bftf.a(str, this.jdField_a_of_type_Aert.b)) {
        break label412;
      }
      this.jdField_a_of_type_Aert.b = str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Aert.b)) {
        break label389;
      }
      this.jdField_a_of_type_Aert.c = ChnToSpell.a(this.jdField_a_of_type_Aert.b, 2);
      this.jdField_a_of_type_Aert.d = ChnToSpell.a(this.jdField_a_of_type_Aert.b, 1);
      bool = true;
    }
    for (;;)
    {
      this.this$0.a(bool);
      return;
      this.jdField_a_of_type_Aert.k = "";
      this.jdField_a_of_type_Aert.l = "";
      break;
      label290:
      this.jdField_a_of_type_Aert.h = "";
      this.jdField_a_of_type_Aert.i = "";
      break label166;
      label311:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aert.m))
      {
        str = this.jdField_a_of_type_Aert.m;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aert.g))
      {
        str = this.jdField_a_of_type_Aert.g;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aert.a))
      {
        str = this.jdField_a_of_type_Aert.a;
        break label187;
      }
      str = "";
      break label187;
      label389:
      this.jdField_a_of_type_Aert.c = "";
      this.jdField_a_of_type_Aert.d = "";
      bool = true;
      continue;
      label412:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.15
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import acdf;
import android.text.TextUtils;
import azzz;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;

class TroopTransferActivity$15
  implements Runnable
{
  TroopTransferActivity$15(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, acdf paramacdf) {}
  
  public void run()
  {
    label166:
    String str;
    label187:
    boolean bool;
    if (!azzz.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_Acdf.j))
    {
      this.jdField_a_of_type_Acdf.j = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Acdf.m))
      {
        this.jdField_a_of_type_Acdf.k = ChnToSpell.a(this.jdField_a_of_type_Acdf.m, 2);
        this.jdField_a_of_type_Acdf.l = ChnToSpell.a(this.jdField_a_of_type_Acdf.m, 1);
      }
    }
    else
    {
      if (!azzz.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_Acdf.g))
      {
        this.jdField_a_of_type_Acdf.g = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Acdf.g)) {
          break label290;
        }
        this.jdField_a_of_type_Acdf.h = ChnToSpell.a(this.jdField_a_of_type_Acdf.g, 2);
        this.jdField_a_of_type_Acdf.i = ChnToSpell.a(this.jdField_a_of_type_Acdf.g, 1);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Acdf.j)) {
        break label311;
      }
      str = this.jdField_a_of_type_Acdf.j;
      if (azzz.a(str, this.jdField_a_of_type_Acdf.b)) {
        break label412;
      }
      this.jdField_a_of_type_Acdf.b = str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Acdf.b)) {
        break label389;
      }
      this.jdField_a_of_type_Acdf.c = ChnToSpell.a(this.jdField_a_of_type_Acdf.b, 2);
      this.jdField_a_of_type_Acdf.d = ChnToSpell.a(this.jdField_a_of_type_Acdf.b, 1);
      bool = true;
    }
    for (;;)
    {
      this.this$0.a(bool);
      return;
      this.jdField_a_of_type_Acdf.k = "";
      this.jdField_a_of_type_Acdf.l = "";
      break;
      label290:
      this.jdField_a_of_type_Acdf.h = "";
      this.jdField_a_of_type_Acdf.i = "";
      break label166;
      label311:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Acdf.m))
      {
        str = this.jdField_a_of_type_Acdf.m;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Acdf.g))
      {
        str = this.jdField_a_of_type_Acdf.g;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Acdf.a))
      {
        str = this.jdField_a_of_type_Acdf.a;
        break label187;
      }
      str = "";
      break label187;
      label389:
      this.jdField_a_of_type_Acdf.c = "";
      this.jdField_a_of_type_Acdf.d = "";
      bool = true;
      continue;
      label412:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.15
 * JD-Core Version:    0.7.0.1
 */
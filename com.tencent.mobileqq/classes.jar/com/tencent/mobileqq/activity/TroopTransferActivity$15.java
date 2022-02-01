package com.tencent.mobileqq.activity;

import afyz;
import android.text.TextUtils;
import bhjx;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;

class TroopTransferActivity$15
  implements Runnable
{
  TroopTransferActivity$15(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, afyz paramafyz) {}
  
  public void run()
  {
    label166:
    String str;
    label187:
    boolean bool;
    if (!bhjx.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_Afyz.j))
    {
      this.jdField_a_of_type_Afyz.j = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Afyz.m))
      {
        this.jdField_a_of_type_Afyz.k = ChnToSpell.a(this.jdField_a_of_type_Afyz.m, 2);
        this.jdField_a_of_type_Afyz.l = ChnToSpell.a(this.jdField_a_of_type_Afyz.m, 1);
      }
    }
    else
    {
      if (!bhjx.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_Afyz.g))
      {
        this.jdField_a_of_type_Afyz.g = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Afyz.g)) {
          break label290;
        }
        this.jdField_a_of_type_Afyz.h = ChnToSpell.a(this.jdField_a_of_type_Afyz.g, 2);
        this.jdField_a_of_type_Afyz.i = ChnToSpell.a(this.jdField_a_of_type_Afyz.g, 1);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Afyz.j)) {
        break label311;
      }
      str = this.jdField_a_of_type_Afyz.j;
      if (bhjx.a(str, this.jdField_a_of_type_Afyz.b)) {
        break label412;
      }
      this.jdField_a_of_type_Afyz.b = str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Afyz.b)) {
        break label389;
      }
      this.jdField_a_of_type_Afyz.c = ChnToSpell.a(this.jdField_a_of_type_Afyz.b, 2);
      this.jdField_a_of_type_Afyz.d = ChnToSpell.a(this.jdField_a_of_type_Afyz.b, 1);
      bool = true;
    }
    for (;;)
    {
      this.this$0.a(bool);
      return;
      this.jdField_a_of_type_Afyz.k = "";
      this.jdField_a_of_type_Afyz.l = "";
      break;
      label290:
      this.jdField_a_of_type_Afyz.h = "";
      this.jdField_a_of_type_Afyz.i = "";
      break label166;
      label311:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Afyz.m))
      {
        str = this.jdField_a_of_type_Afyz.m;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Afyz.g))
      {
        str = this.jdField_a_of_type_Afyz.g;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Afyz.a))
      {
        str = this.jdField_a_of_type_Afyz.a;
        break label187;
      }
      str = "";
      break label187;
      label389:
      this.jdField_a_of_type_Afyz.c = "";
      this.jdField_a_of_type_Afyz.d = "";
      bool = true;
      continue;
      label412:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.15
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import acnu;
import android.text.TextUtils;
import bbbd;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;

class TroopTransferActivity$15
  implements Runnable
{
  TroopTransferActivity$15(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, acnu paramacnu) {}
  
  public void run()
  {
    label166:
    String str;
    label187:
    boolean bool;
    if (!bbbd.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_Acnu.j))
    {
      this.jdField_a_of_type_Acnu.j = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Acnu.m))
      {
        this.jdField_a_of_type_Acnu.k = ChnToSpell.a(this.jdField_a_of_type_Acnu.m, 2);
        this.jdField_a_of_type_Acnu.l = ChnToSpell.a(this.jdField_a_of_type_Acnu.m, 1);
      }
    }
    else
    {
      if (!bbbd.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_Acnu.g))
      {
        this.jdField_a_of_type_Acnu.g = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Acnu.g)) {
          break label290;
        }
        this.jdField_a_of_type_Acnu.h = ChnToSpell.a(this.jdField_a_of_type_Acnu.g, 2);
        this.jdField_a_of_type_Acnu.i = ChnToSpell.a(this.jdField_a_of_type_Acnu.g, 1);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Acnu.j)) {
        break label311;
      }
      str = this.jdField_a_of_type_Acnu.j;
      if (bbbd.a(str, this.jdField_a_of_type_Acnu.b)) {
        break label412;
      }
      this.jdField_a_of_type_Acnu.b = str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Acnu.b)) {
        break label389;
      }
      this.jdField_a_of_type_Acnu.c = ChnToSpell.a(this.jdField_a_of_type_Acnu.b, 2);
      this.jdField_a_of_type_Acnu.d = ChnToSpell.a(this.jdField_a_of_type_Acnu.b, 1);
      bool = true;
    }
    for (;;)
    {
      this.this$0.a(bool);
      return;
      this.jdField_a_of_type_Acnu.k = "";
      this.jdField_a_of_type_Acnu.l = "";
      break;
      label290:
      this.jdField_a_of_type_Acnu.h = "";
      this.jdField_a_of_type_Acnu.i = "";
      break label166;
      label311:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Acnu.m))
      {
        str = this.jdField_a_of_type_Acnu.m;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Acnu.g))
      {
        str = this.jdField_a_of_type_Acnu.g;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Acnu.a))
      {
        str = this.jdField_a_of_type_Acnu.a;
        break label187;
      }
      str = "";
      break label187;
      label389:
      this.jdField_a_of_type_Acnu.c = "";
      this.jdField_a_of_type_Acnu.d = "";
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
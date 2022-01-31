package com.tencent.mobileqq.activity;

import acnq;
import android.text.TextUtils;
import bbbr;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;

class TroopTransferActivity$15
  implements Runnable
{
  TroopTransferActivity$15(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, acnq paramacnq) {}
  
  public void run()
  {
    label166:
    String str;
    label187:
    boolean bool;
    if (!bbbr.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_Acnq.j))
    {
      this.jdField_a_of_type_Acnq.j = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Acnq.m))
      {
        this.jdField_a_of_type_Acnq.k = ChnToSpell.a(this.jdField_a_of_type_Acnq.m, 2);
        this.jdField_a_of_type_Acnq.l = ChnToSpell.a(this.jdField_a_of_type_Acnq.m, 1);
      }
    }
    else
    {
      if (!bbbr.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_Acnq.g))
      {
        this.jdField_a_of_type_Acnq.g = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Acnq.g)) {
          break label290;
        }
        this.jdField_a_of_type_Acnq.h = ChnToSpell.a(this.jdField_a_of_type_Acnq.g, 2);
        this.jdField_a_of_type_Acnq.i = ChnToSpell.a(this.jdField_a_of_type_Acnq.g, 1);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Acnq.j)) {
        break label311;
      }
      str = this.jdField_a_of_type_Acnq.j;
      if (bbbr.a(str, this.jdField_a_of_type_Acnq.b)) {
        break label412;
      }
      this.jdField_a_of_type_Acnq.b = str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Acnq.b)) {
        break label389;
      }
      this.jdField_a_of_type_Acnq.c = ChnToSpell.a(this.jdField_a_of_type_Acnq.b, 2);
      this.jdField_a_of_type_Acnq.d = ChnToSpell.a(this.jdField_a_of_type_Acnq.b, 1);
      bool = true;
    }
    for (;;)
    {
      this.this$0.a(bool);
      return;
      this.jdField_a_of_type_Acnq.k = "";
      this.jdField_a_of_type_Acnq.l = "";
      break;
      label290:
      this.jdField_a_of_type_Acnq.h = "";
      this.jdField_a_of_type_Acnq.i = "";
      break label166;
      label311:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Acnq.m))
      {
        str = this.jdField_a_of_type_Acnq.m;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Acnq.g))
      {
        str = this.jdField_a_of_type_Acnq.g;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Acnq.a))
      {
        str = this.jdField_a_of_type_Acnq.a;
        break label187;
      }
      str = "";
      break label187;
      label389:
      this.jdField_a_of_type_Acnq.c = "";
      this.jdField_a_of_type_Acnq.d = "";
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
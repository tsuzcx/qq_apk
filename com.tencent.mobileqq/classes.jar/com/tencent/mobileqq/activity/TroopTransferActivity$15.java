package com.tencent.mobileqq.activity;

import afje;
import android.text.TextUtils;
import bhbx;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;

class TroopTransferActivity$15
  implements Runnable
{
  TroopTransferActivity$15(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, afje paramafje) {}
  
  public void run()
  {
    label166:
    String str;
    label187:
    boolean bool;
    if (!bhbx.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_Afje.j))
    {
      this.jdField_a_of_type_Afje.j = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Afje.m))
      {
        this.jdField_a_of_type_Afje.k = ChnToSpell.a(this.jdField_a_of_type_Afje.m, 2);
        this.jdField_a_of_type_Afje.l = ChnToSpell.a(this.jdField_a_of_type_Afje.m, 1);
      }
    }
    else
    {
      if (!bhbx.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_Afje.g))
      {
        this.jdField_a_of_type_Afje.g = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Afje.g)) {
          break label290;
        }
        this.jdField_a_of_type_Afje.h = ChnToSpell.a(this.jdField_a_of_type_Afje.g, 2);
        this.jdField_a_of_type_Afje.i = ChnToSpell.a(this.jdField_a_of_type_Afje.g, 1);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Afje.j)) {
        break label311;
      }
      str = this.jdField_a_of_type_Afje.j;
      if (bhbx.a(str, this.jdField_a_of_type_Afje.b)) {
        break label412;
      }
      this.jdField_a_of_type_Afje.b = str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Afje.b)) {
        break label389;
      }
      this.jdField_a_of_type_Afje.c = ChnToSpell.a(this.jdField_a_of_type_Afje.b, 2);
      this.jdField_a_of_type_Afje.d = ChnToSpell.a(this.jdField_a_of_type_Afje.b, 1);
      bool = true;
    }
    for (;;)
    {
      this.this$0.a(bool);
      return;
      this.jdField_a_of_type_Afje.k = "";
      this.jdField_a_of_type_Afje.l = "";
      break;
      label290:
      this.jdField_a_of_type_Afje.h = "";
      this.jdField_a_of_type_Afje.i = "";
      break label166;
      label311:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Afje.m))
      {
        str = this.jdField_a_of_type_Afje.m;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Afje.g))
      {
        str = this.jdField_a_of_type_Afje.g;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Afje.a))
      {
        str = this.jdField_a_of_type_Afje.a;
        break label187;
      }
      str = "";
      break label187;
      label389:
      this.jdField_a_of_type_Afje.c = "";
      this.jdField_a_of_type_Afje.d = "";
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
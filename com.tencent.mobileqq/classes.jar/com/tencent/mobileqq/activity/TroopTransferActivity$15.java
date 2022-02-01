package com.tencent.mobileqq.activity;

import afpv;
import android.text.TextUtils;
import bgjw;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;

class TroopTransferActivity$15
  implements Runnable
{
  TroopTransferActivity$15(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, afpv paramafpv) {}
  
  public void run()
  {
    label166:
    String str;
    label187:
    boolean bool;
    if (!bgjw.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_Afpv.j))
    {
      this.jdField_a_of_type_Afpv.j = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Afpv.m))
      {
        this.jdField_a_of_type_Afpv.k = ChnToSpell.a(this.jdField_a_of_type_Afpv.m, 2);
        this.jdField_a_of_type_Afpv.l = ChnToSpell.a(this.jdField_a_of_type_Afpv.m, 1);
      }
    }
    else
    {
      if (!bgjw.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_Afpv.g))
      {
        this.jdField_a_of_type_Afpv.g = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Afpv.g)) {
          break label290;
        }
        this.jdField_a_of_type_Afpv.h = ChnToSpell.a(this.jdField_a_of_type_Afpv.g, 2);
        this.jdField_a_of_type_Afpv.i = ChnToSpell.a(this.jdField_a_of_type_Afpv.g, 1);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Afpv.j)) {
        break label311;
      }
      str = this.jdField_a_of_type_Afpv.j;
      if (bgjw.a(str, this.jdField_a_of_type_Afpv.b)) {
        break label412;
      }
      this.jdField_a_of_type_Afpv.b = str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Afpv.b)) {
        break label389;
      }
      this.jdField_a_of_type_Afpv.c = ChnToSpell.a(this.jdField_a_of_type_Afpv.b, 2);
      this.jdField_a_of_type_Afpv.d = ChnToSpell.a(this.jdField_a_of_type_Afpv.b, 1);
      bool = true;
    }
    for (;;)
    {
      this.this$0.a(bool);
      return;
      this.jdField_a_of_type_Afpv.k = "";
      this.jdField_a_of_type_Afpv.l = "";
      break;
      label290:
      this.jdField_a_of_type_Afpv.h = "";
      this.jdField_a_of_type_Afpv.i = "";
      break label166;
      label311:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Afpv.m))
      {
        str = this.jdField_a_of_type_Afpv.m;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Afpv.g))
      {
        str = this.jdField_a_of_type_Afpv.g;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Afpv.a))
      {
        str = this.jdField_a_of_type_Afpv.a;
        break label187;
      }
      str = "";
      break label187;
      label389:
      this.jdField_a_of_type_Afpv.c = "";
      this.jdField_a_of_type_Afpv.d = "";
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
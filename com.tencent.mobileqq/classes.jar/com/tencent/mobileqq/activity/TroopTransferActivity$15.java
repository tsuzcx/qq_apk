package com.tencent.mobileqq.activity;

import aejp;
import android.text.TextUtils;
import bdeu;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;

class TroopTransferActivity$15
  implements Runnable
{
  TroopTransferActivity$15(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, aejp paramaejp) {}
  
  public void run()
  {
    label166:
    String str;
    label187:
    boolean bool;
    if (!bdeu.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_Aejp.j))
    {
      this.jdField_a_of_type_Aejp.j = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aejp.m))
      {
        this.jdField_a_of_type_Aejp.k = ChnToSpell.a(this.jdField_a_of_type_Aejp.m, 2);
        this.jdField_a_of_type_Aejp.l = ChnToSpell.a(this.jdField_a_of_type_Aejp.m, 1);
      }
    }
    else
    {
      if (!bdeu.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_Aejp.g))
      {
        this.jdField_a_of_type_Aejp.g = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Aejp.g)) {
          break label290;
        }
        this.jdField_a_of_type_Aejp.h = ChnToSpell.a(this.jdField_a_of_type_Aejp.g, 2);
        this.jdField_a_of_type_Aejp.i = ChnToSpell.a(this.jdField_a_of_type_Aejp.g, 1);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Aejp.j)) {
        break label311;
      }
      str = this.jdField_a_of_type_Aejp.j;
      if (bdeu.a(str, this.jdField_a_of_type_Aejp.b)) {
        break label412;
      }
      this.jdField_a_of_type_Aejp.b = str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Aejp.b)) {
        break label389;
      }
      this.jdField_a_of_type_Aejp.c = ChnToSpell.a(this.jdField_a_of_type_Aejp.b, 2);
      this.jdField_a_of_type_Aejp.d = ChnToSpell.a(this.jdField_a_of_type_Aejp.b, 1);
      bool = true;
    }
    for (;;)
    {
      this.this$0.a(bool);
      return;
      this.jdField_a_of_type_Aejp.k = "";
      this.jdField_a_of_type_Aejp.l = "";
      break;
      label290:
      this.jdField_a_of_type_Aejp.h = "";
      this.jdField_a_of_type_Aejp.i = "";
      break label166;
      label311:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aejp.m))
      {
        str = this.jdField_a_of_type_Aejp.m;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aejp.g))
      {
        str = this.jdField_a_of_type_Aejp.g;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aejp.a))
      {
        str = this.jdField_a_of_type_Aejp.a;
        break label187;
      }
      str = "";
      break label187;
      label389:
      this.jdField_a_of_type_Aejp.c = "";
      this.jdField_a_of_type_Aejp.d = "";
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
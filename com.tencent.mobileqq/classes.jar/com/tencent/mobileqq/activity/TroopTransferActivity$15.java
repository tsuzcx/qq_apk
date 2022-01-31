package com.tencent.mobileqq.activity;

import aefa;
import android.text.TextUtils;
import bdal;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;

class TroopTransferActivity$15
  implements Runnable
{
  TroopTransferActivity$15(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, aefa paramaefa) {}
  
  public void run()
  {
    label166:
    String str;
    label187:
    boolean bool;
    if (!bdal.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_Aefa.j))
    {
      this.jdField_a_of_type_Aefa.j = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aefa.m))
      {
        this.jdField_a_of_type_Aefa.k = ChnToSpell.a(this.jdField_a_of_type_Aefa.m, 2);
        this.jdField_a_of_type_Aefa.l = ChnToSpell.a(this.jdField_a_of_type_Aefa.m, 1);
      }
    }
    else
    {
      if (!bdal.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_Aefa.g))
      {
        this.jdField_a_of_type_Aefa.g = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Aefa.g)) {
          break label290;
        }
        this.jdField_a_of_type_Aefa.h = ChnToSpell.a(this.jdField_a_of_type_Aefa.g, 2);
        this.jdField_a_of_type_Aefa.i = ChnToSpell.a(this.jdField_a_of_type_Aefa.g, 1);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Aefa.j)) {
        break label311;
      }
      str = this.jdField_a_of_type_Aefa.j;
      if (bdal.a(str, this.jdField_a_of_type_Aefa.b)) {
        break label412;
      }
      this.jdField_a_of_type_Aefa.b = str;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Aefa.b)) {
        break label389;
      }
      this.jdField_a_of_type_Aefa.c = ChnToSpell.a(this.jdField_a_of_type_Aefa.b, 2);
      this.jdField_a_of_type_Aefa.d = ChnToSpell.a(this.jdField_a_of_type_Aefa.b, 1);
      bool = true;
    }
    for (;;)
    {
      this.this$0.a(bool);
      return;
      this.jdField_a_of_type_Aefa.k = "";
      this.jdField_a_of_type_Aefa.l = "";
      break;
      label290:
      this.jdField_a_of_type_Aefa.h = "";
      this.jdField_a_of_type_Aefa.i = "";
      break label166;
      label311:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aefa.m))
      {
        str = this.jdField_a_of_type_Aefa.m;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aefa.g))
      {
        str = this.jdField_a_of_type_Aefa.g;
        break label187;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aefa.a))
      {
        str = this.jdField_a_of_type_Aefa.a;
        break label187;
      }
      str = "";
      break label187;
      label389:
      this.jdField_a_of_type_Aefa.c = "";
      this.jdField_a_of_type_Aefa.d = "";
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
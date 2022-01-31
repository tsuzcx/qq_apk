package com.tencent.mobileqq.activity;

import aefa;
import aefb;
import aloz;
import alzf;
import android.text.TextUtils;
import bdbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopTransferActivity$TroopMemberListAdapter$1
  implements Runnable
{
  public TroopTransferActivity$TroopMemberListAdapter$1(aefb paramaefb, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Aefb.jdField_a_of_type_JavaUtilArrayList.size();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Aefb.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(52);
    aloz localaloz = (aloz)this.jdField_a_of_type_Aefb.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(51);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      aefa localaefa = (aefa)this.jdField_a_of_type_Aefb.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(localaefa.a)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localaloz == null)
        {
          localObject = null;
          label108:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localaefa.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localaefa.j = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label455;
          }
          localObject = null;
          label161:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localaefa.a))) {
            break label479;
          }
          localObject = bdbx.a().a(this.jdField_a_of_type_Aefb.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_Aefb.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a), localaefa.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            localaefa.m = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localaefa.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label261:
          if (TextUtils.isEmpty(localaefa.j)) {
            break label488;
          }
          localaefa.b = localaefa.j;
          label282:
          if (TextUtils.isEmpty(localaefa.b)) {
            break label571;
          }
          localaefa.c = ChnToSpell.a(localaefa.b, 2);
          localaefa.d = ChnToSpell.a(localaefa.b, 1);
          label321:
          if (TextUtils.isEmpty(localaefa.g)) {
            break label588;
          }
          localaefa.h = ChnToSpell.a(localaefa.g, 2);
          localaefa.i = ChnToSpell.a(localaefa.g, 1);
          label360:
          if (TextUtils.isEmpty(localaefa.j)) {
            break label605;
          }
          localaefa.k = ChnToSpell.a(localaefa.j, 2);
        }
        for (localaefa.l = ChnToSpell.a(localaefa.j, 1);; localaefa.l = "")
        {
          if (TextUtils.isEmpty(localaefa.m)) {
            break label622;
          }
          localaefa.n = ChnToSpell.a(localaefa.m, 2);
          localaefa.o = ChnToSpell.a(localaefa.m, 1);
          break;
          localObject = localaloz.e(localaefa.a);
          break label108;
          label455:
          localObject = localTroopManager.a(this.jdField_a_of_type_Aefb.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, localaefa.a);
          break label161;
          label479:
          localaefa.m = ((String)localObject);
          break label261;
          label488:
          if (!TextUtils.isEmpty(localaefa.m))
          {
            localaefa.b = localaefa.m;
            break label282;
          }
          if (!TextUtils.isEmpty(localaefa.g))
          {
            localaefa.b = localaefa.g;
            break label282;
          }
          if (TextUtils.isEmpty(localaefa.a)) {
            break label282;
          }
          localaefa.b = localaefa.a;
          localArrayList.add(localaefa.a);
          break label282;
          label571:
          localaefa.c = "";
          localaefa.d = "";
          break label321;
          label588:
          localaefa.h = "";
          localaefa.i = "";
          break label360;
          label605:
          localaefa.k = "";
        }
        label622:
        localaefa.n = "";
        localaefa.o = "";
      }
    }
    Object localObject = (alzf)this.jdField_a_of_type_Aefb.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.a(20);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((alzf)localObject).a(this.jdField_a_of_type_Aefb.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, this.jdField_a_of_type_Aefb.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_Aefb.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_Aefb.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_Aefb.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopdisband.transfer", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter.1
 * JD-Core Version:    0.7.0.1
 */
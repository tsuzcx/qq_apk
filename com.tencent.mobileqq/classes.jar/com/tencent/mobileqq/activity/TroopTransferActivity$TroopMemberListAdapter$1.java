package com.tencent.mobileqq.activity;

import aert;
import aeru;
import amsw;
import anca;
import android.text.TextUtils;
import bfun;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopTransferActivity$TroopMemberListAdapter$1
  implements Runnable
{
  public TroopTransferActivity$TroopMemberListAdapter$1(aeru paramaeru, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Aeru.jdField_a_of_type_JavaUtilArrayList.size();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Aeru.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(52);
    amsw localamsw = (amsw)this.jdField_a_of_type_Aeru.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(51);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      aert localaert = (aert)this.jdField_a_of_type_Aeru.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(localaert.a)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localamsw == null)
        {
          localObject = null;
          label108:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localaert.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localaert.j = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label455;
          }
          localObject = null;
          label161:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localaert.a))) {
            break label479;
          }
          localObject = bfun.a().a(this.jdField_a_of_type_Aeru.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_Aeru.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a), localaert.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            localaert.m = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localaert.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label261:
          if (TextUtils.isEmpty(localaert.j)) {
            break label488;
          }
          localaert.b = localaert.j;
          label282:
          if (TextUtils.isEmpty(localaert.b)) {
            break label571;
          }
          localaert.c = ChnToSpell.a(localaert.b, 2);
          localaert.d = ChnToSpell.a(localaert.b, 1);
          label321:
          if (TextUtils.isEmpty(localaert.g)) {
            break label588;
          }
          localaert.h = ChnToSpell.a(localaert.g, 2);
          localaert.i = ChnToSpell.a(localaert.g, 1);
          label360:
          if (TextUtils.isEmpty(localaert.j)) {
            break label605;
          }
          localaert.k = ChnToSpell.a(localaert.j, 2);
        }
        for (localaert.l = ChnToSpell.a(localaert.j, 1);; localaert.l = "")
        {
          if (TextUtils.isEmpty(localaert.m)) {
            break label622;
          }
          localaert.n = ChnToSpell.a(localaert.m, 2);
          localaert.o = ChnToSpell.a(localaert.m, 1);
          break;
          localObject = localamsw.e(localaert.a);
          break label108;
          label455:
          localObject = localTroopManager.a(this.jdField_a_of_type_Aeru.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, localaert.a);
          break label161;
          label479:
          localaert.m = ((String)localObject);
          break label261;
          label488:
          if (!TextUtils.isEmpty(localaert.m))
          {
            localaert.b = localaert.m;
            break label282;
          }
          if (!TextUtils.isEmpty(localaert.g))
          {
            localaert.b = localaert.g;
            break label282;
          }
          if (TextUtils.isEmpty(localaert.a)) {
            break label282;
          }
          localaert.b = localaert.a;
          localArrayList.add(localaert.a);
          break label282;
          label571:
          localaert.c = "";
          localaert.d = "";
          break label321;
          label588:
          localaert.h = "";
          localaert.i = "";
          break label360;
          label605:
          localaert.k = "";
        }
        label622:
        localaert.n = "";
        localaert.o = "";
      }
    }
    Object localObject = (anca)this.jdField_a_of_type_Aeru.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getBusinessHandler(20);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((anca)localObject).a(this.jdField_a_of_type_Aeru.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, this.jdField_a_of_type_Aeru.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_Aeru.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_Aeru.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_Aeru.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
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
package com.tencent.mobileqq.activity;

import acnq;
import acnr;
import ajxl;
import akhp;
import android.text.TextUtils;
import bbdd;
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
  public TroopTransferActivity$TroopMemberListAdapter$1(acnr paramacnr, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Acnr.jdField_a_of_type_JavaUtilArrayList.size();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Acnr.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(52);
    ajxl localajxl = (ajxl)this.jdField_a_of_type_Acnr.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(51);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      acnq localacnq = (acnq)this.jdField_a_of_type_Acnr.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(localacnq.a)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localajxl == null)
        {
          localObject = null;
          label108:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localacnq.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localacnq.j = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label455;
          }
          localObject = null;
          label161:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localacnq.a))) {
            break label479;
          }
          localObject = bbdd.a().a(this.jdField_a_of_type_Acnr.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_Acnr.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a), localacnq.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            localacnq.m = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localacnq.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label261:
          if (TextUtils.isEmpty(localacnq.j)) {
            break label488;
          }
          localacnq.b = localacnq.j;
          label282:
          if (TextUtils.isEmpty(localacnq.b)) {
            break label571;
          }
          localacnq.c = ChnToSpell.a(localacnq.b, 2);
          localacnq.d = ChnToSpell.a(localacnq.b, 1);
          label321:
          if (TextUtils.isEmpty(localacnq.g)) {
            break label588;
          }
          localacnq.h = ChnToSpell.a(localacnq.g, 2);
          localacnq.i = ChnToSpell.a(localacnq.g, 1);
          label360:
          if (TextUtils.isEmpty(localacnq.j)) {
            break label605;
          }
          localacnq.k = ChnToSpell.a(localacnq.j, 2);
        }
        for (localacnq.l = ChnToSpell.a(localacnq.j, 1);; localacnq.l = "")
        {
          if (TextUtils.isEmpty(localacnq.m)) {
            break label622;
          }
          localacnq.n = ChnToSpell.a(localacnq.m, 2);
          localacnq.o = ChnToSpell.a(localacnq.m, 1);
          break;
          localObject = localajxl.e(localacnq.a);
          break label108;
          label455:
          localObject = localTroopManager.a(this.jdField_a_of_type_Acnr.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, localacnq.a);
          break label161;
          label479:
          localacnq.m = ((String)localObject);
          break label261;
          label488:
          if (!TextUtils.isEmpty(localacnq.m))
          {
            localacnq.b = localacnq.m;
            break label282;
          }
          if (!TextUtils.isEmpty(localacnq.g))
          {
            localacnq.b = localacnq.g;
            break label282;
          }
          if (TextUtils.isEmpty(localacnq.a)) {
            break label282;
          }
          localacnq.b = localacnq.a;
          localArrayList.add(localacnq.a);
          break label282;
          label571:
          localacnq.c = "";
          localacnq.d = "";
          break label321;
          label588:
          localacnq.h = "";
          localacnq.i = "";
          break label360;
          label605:
          localacnq.k = "";
        }
        label622:
        localacnq.n = "";
        localacnq.o = "";
      }
    }
    Object localObject = (akhp)this.jdField_a_of_type_Acnr.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.a(20);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((akhp)localObject).a(this.jdField_a_of_type_Acnr.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, this.jdField_a_of_type_Acnr.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_Acnr.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_Acnr.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_Acnr.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter.1
 * JD-Core Version:    0.7.0.1
 */
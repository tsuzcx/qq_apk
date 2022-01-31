package com.tencent.mobileqq.activity;

import acnu;
import acnv;
import ajxn;
import akhq;
import android.text.TextUtils;
import bbcp;
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
  public TroopTransferActivity$TroopMemberListAdapter$1(acnv paramacnv, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Acnv.jdField_a_of_type_JavaUtilArrayList.size();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Acnv.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(52);
    ajxn localajxn = (ajxn)this.jdField_a_of_type_Acnv.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(51);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      acnu localacnu = (acnu)this.jdField_a_of_type_Acnv.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(localacnu.a)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localajxn == null)
        {
          localObject = null;
          label108:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localacnu.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localacnu.j = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label455;
          }
          localObject = null;
          label161:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localacnu.a))) {
            break label479;
          }
          localObject = bbcp.a().a(this.jdField_a_of_type_Acnv.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_Acnv.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a), localacnu.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            localacnu.m = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localacnu.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label261:
          if (TextUtils.isEmpty(localacnu.j)) {
            break label488;
          }
          localacnu.b = localacnu.j;
          label282:
          if (TextUtils.isEmpty(localacnu.b)) {
            break label571;
          }
          localacnu.c = ChnToSpell.a(localacnu.b, 2);
          localacnu.d = ChnToSpell.a(localacnu.b, 1);
          label321:
          if (TextUtils.isEmpty(localacnu.g)) {
            break label588;
          }
          localacnu.h = ChnToSpell.a(localacnu.g, 2);
          localacnu.i = ChnToSpell.a(localacnu.g, 1);
          label360:
          if (TextUtils.isEmpty(localacnu.j)) {
            break label605;
          }
          localacnu.k = ChnToSpell.a(localacnu.j, 2);
        }
        for (localacnu.l = ChnToSpell.a(localacnu.j, 1);; localacnu.l = "")
        {
          if (TextUtils.isEmpty(localacnu.m)) {
            break label622;
          }
          localacnu.n = ChnToSpell.a(localacnu.m, 2);
          localacnu.o = ChnToSpell.a(localacnu.m, 1);
          break;
          localObject = localajxn.e(localacnu.a);
          break label108;
          label455:
          localObject = localTroopManager.a(this.jdField_a_of_type_Acnv.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, localacnu.a);
          break label161;
          label479:
          localacnu.m = ((String)localObject);
          break label261;
          label488:
          if (!TextUtils.isEmpty(localacnu.m))
          {
            localacnu.b = localacnu.m;
            break label282;
          }
          if (!TextUtils.isEmpty(localacnu.g))
          {
            localacnu.b = localacnu.g;
            break label282;
          }
          if (TextUtils.isEmpty(localacnu.a)) {
            break label282;
          }
          localacnu.b = localacnu.a;
          localArrayList.add(localacnu.a);
          break label282;
          label571:
          localacnu.c = "";
          localacnu.d = "";
          break label321;
          label588:
          localacnu.h = "";
          localacnu.i = "";
          break label360;
          label605:
          localacnu.k = "";
        }
        label622:
        localacnu.n = "";
        localacnu.o = "";
      }
    }
    Object localObject = (akhq)this.jdField_a_of_type_Acnv.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.a(20);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((akhq)localObject).a(this.jdField_a_of_type_Acnv.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, this.jdField_a_of_type_Acnv.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_Acnv.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_Acnv.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_Acnv.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
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
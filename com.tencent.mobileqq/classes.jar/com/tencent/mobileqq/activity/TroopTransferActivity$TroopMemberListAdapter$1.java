package com.tencent.mobileqq.activity;

import afyz;
import afza;
import android.text.TextUtils;
import anyw;
import aoip;
import bhlk;
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
  public TroopTransferActivity$TroopMemberListAdapter$1(afza paramafza, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Afza.jdField_a_of_type_JavaUtilArrayList.size();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Afza.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(52);
    anyw localanyw = (anyw)this.jdField_a_of_type_Afza.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(51);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      afyz localafyz = (afyz)this.jdField_a_of_type_Afza.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(localafyz.a)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localanyw == null)
        {
          localObject = null;
          label108:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localafyz.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localafyz.j = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label455;
          }
          localObject = null;
          label161:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localafyz.a))) {
            break label479;
          }
          localObject = bhlk.a().a(this.jdField_a_of_type_Afza.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_Afza.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a), localafyz.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            localafyz.m = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localafyz.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label261:
          if (TextUtils.isEmpty(localafyz.j)) {
            break label488;
          }
          localafyz.b = localafyz.j;
          label282:
          if (TextUtils.isEmpty(localafyz.b)) {
            break label571;
          }
          localafyz.c = ChnToSpell.a(localafyz.b, 2);
          localafyz.d = ChnToSpell.a(localafyz.b, 1);
          label321:
          if (TextUtils.isEmpty(localafyz.g)) {
            break label588;
          }
          localafyz.h = ChnToSpell.a(localafyz.g, 2);
          localafyz.i = ChnToSpell.a(localafyz.g, 1);
          label360:
          if (TextUtils.isEmpty(localafyz.j)) {
            break label605;
          }
          localafyz.k = ChnToSpell.a(localafyz.j, 2);
        }
        for (localafyz.l = ChnToSpell.a(localafyz.j, 1);; localafyz.l = "")
        {
          if (TextUtils.isEmpty(localafyz.m)) {
            break label622;
          }
          localafyz.n = ChnToSpell.a(localafyz.m, 2);
          localafyz.o = ChnToSpell.a(localafyz.m, 1);
          break;
          localObject = localanyw.e(localafyz.a);
          break label108;
          label455:
          localObject = localTroopManager.a(this.jdField_a_of_type_Afza.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, localafyz.a);
          break label161;
          label479:
          localafyz.m = ((String)localObject);
          break label261;
          label488:
          if (!TextUtils.isEmpty(localafyz.m))
          {
            localafyz.b = localafyz.m;
            break label282;
          }
          if (!TextUtils.isEmpty(localafyz.g))
          {
            localafyz.b = localafyz.g;
            break label282;
          }
          if (TextUtils.isEmpty(localafyz.a)) {
            break label282;
          }
          localafyz.b = localafyz.a;
          localArrayList.add(localafyz.a);
          break label282;
          label571:
          localafyz.c = "";
          localafyz.d = "";
          break label321;
          label588:
          localafyz.h = "";
          localafyz.i = "";
          break label360;
          label605:
          localafyz.k = "";
        }
        label622:
        localafyz.n = "";
        localafyz.o = "";
      }
    }
    Object localObject = (aoip)this.jdField_a_of_type_Afza.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.a(20);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((aoip)localObject).a(this.jdField_a_of_type_Afza.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, this.jdField_a_of_type_Afza.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_Afza.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_Afza.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_Afza.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import afpv;
import afpw;
import android.text.TextUtils;
import anmw;
import anwd;
import bglj;
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
  public TroopTransferActivity$TroopMemberListAdapter$1(afpw paramafpw, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Afpw.jdField_a_of_type_JavaUtilArrayList.size();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Afpw.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(52);
    anmw localanmw = (anmw)this.jdField_a_of_type_Afpw.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(51);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      afpv localafpv = (afpv)this.jdField_a_of_type_Afpw.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(localafpv.a)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localanmw == null)
        {
          localObject = null;
          label108:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localafpv.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localafpv.j = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label455;
          }
          localObject = null;
          label161:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localafpv.a))) {
            break label479;
          }
          localObject = bglj.a().a(this.jdField_a_of_type_Afpw.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_Afpw.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a), localafpv.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            localafpv.m = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localafpv.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label261:
          if (TextUtils.isEmpty(localafpv.j)) {
            break label488;
          }
          localafpv.b = localafpv.j;
          label282:
          if (TextUtils.isEmpty(localafpv.b)) {
            break label571;
          }
          localafpv.c = ChnToSpell.a(localafpv.b, 2);
          localafpv.d = ChnToSpell.a(localafpv.b, 1);
          label321:
          if (TextUtils.isEmpty(localafpv.g)) {
            break label588;
          }
          localafpv.h = ChnToSpell.a(localafpv.g, 2);
          localafpv.i = ChnToSpell.a(localafpv.g, 1);
          label360:
          if (TextUtils.isEmpty(localafpv.j)) {
            break label605;
          }
          localafpv.k = ChnToSpell.a(localafpv.j, 2);
        }
        for (localafpv.l = ChnToSpell.a(localafpv.j, 1);; localafpv.l = "")
        {
          if (TextUtils.isEmpty(localafpv.m)) {
            break label622;
          }
          localafpv.n = ChnToSpell.a(localafpv.m, 2);
          localafpv.o = ChnToSpell.a(localafpv.m, 1);
          break;
          localObject = localanmw.e(localafpv.a);
          break label108;
          label455:
          localObject = localTroopManager.a(this.jdField_a_of_type_Afpw.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, localafpv.a);
          break label161;
          label479:
          localafpv.m = ((String)localObject);
          break label261;
          label488:
          if (!TextUtils.isEmpty(localafpv.m))
          {
            localafpv.b = localafpv.m;
            break label282;
          }
          if (!TextUtils.isEmpty(localafpv.g))
          {
            localafpv.b = localafpv.g;
            break label282;
          }
          if (TextUtils.isEmpty(localafpv.a)) {
            break label282;
          }
          localafpv.b = localafpv.a;
          localArrayList.add(localafpv.a);
          break label282;
          label571:
          localafpv.c = "";
          localafpv.d = "";
          break label321;
          label588:
          localafpv.h = "";
          localafpv.i = "";
          break label360;
          label605:
          localafpv.k = "";
        }
        label622:
        localafpv.n = "";
        localafpv.o = "";
      }
    }
    Object localObject = (anwd)this.jdField_a_of_type_Afpw.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.a(20);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((anwd)localObject).a(this.jdField_a_of_type_Afpw.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, this.jdField_a_of_type_Afpw.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_Afpw.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_Afpw.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_Afpw.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
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
package com.tencent.mobileqq.activity;

import aejp;
import aejq;
import alto;
import amdu;
import android.text.TextUtils;
import bdgg;
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
  public TroopTransferActivity$TroopMemberListAdapter$1(aejq paramaejq, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Aejq.jdField_a_of_type_JavaUtilArrayList.size();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Aejq.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(52);
    alto localalto = (alto)this.jdField_a_of_type_Aejq.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(51);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      aejp localaejp = (aejp)this.jdField_a_of_type_Aejq.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(localaejp.a)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localalto == null)
        {
          localObject = null;
          label108:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localaejp.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localaejp.j = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label455;
          }
          localObject = null;
          label161:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localaejp.a))) {
            break label479;
          }
          localObject = bdgg.a().a(this.jdField_a_of_type_Aejq.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_Aejq.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a), localaejp.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            localaejp.m = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localaejp.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label261:
          if (TextUtils.isEmpty(localaejp.j)) {
            break label488;
          }
          localaejp.b = localaejp.j;
          label282:
          if (TextUtils.isEmpty(localaejp.b)) {
            break label571;
          }
          localaejp.c = ChnToSpell.a(localaejp.b, 2);
          localaejp.d = ChnToSpell.a(localaejp.b, 1);
          label321:
          if (TextUtils.isEmpty(localaejp.g)) {
            break label588;
          }
          localaejp.h = ChnToSpell.a(localaejp.g, 2);
          localaejp.i = ChnToSpell.a(localaejp.g, 1);
          label360:
          if (TextUtils.isEmpty(localaejp.j)) {
            break label605;
          }
          localaejp.k = ChnToSpell.a(localaejp.j, 2);
        }
        for (localaejp.l = ChnToSpell.a(localaejp.j, 1);; localaejp.l = "")
        {
          if (TextUtils.isEmpty(localaejp.m)) {
            break label622;
          }
          localaejp.n = ChnToSpell.a(localaejp.m, 2);
          localaejp.o = ChnToSpell.a(localaejp.m, 1);
          break;
          localObject = localalto.e(localaejp.a);
          break label108;
          label455:
          localObject = localTroopManager.a(this.jdField_a_of_type_Aejq.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, localaejp.a);
          break label161;
          label479:
          localaejp.m = ((String)localObject);
          break label261;
          label488:
          if (!TextUtils.isEmpty(localaejp.m))
          {
            localaejp.b = localaejp.m;
            break label282;
          }
          if (!TextUtils.isEmpty(localaejp.g))
          {
            localaejp.b = localaejp.g;
            break label282;
          }
          if (TextUtils.isEmpty(localaejp.a)) {
            break label282;
          }
          localaejp.b = localaejp.a;
          localArrayList.add(localaejp.a);
          break label282;
          label571:
          localaejp.c = "";
          localaejp.d = "";
          break label321;
          label588:
          localaejp.h = "";
          localaejp.i = "";
          break label360;
          label605:
          localaejp.k = "";
        }
        label622:
        localaejp.n = "";
        localaejp.o = "";
      }
    }
    Object localObject = (amdu)this.jdField_a_of_type_Aejq.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.a(20);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((amdu)localObject).a(this.jdField_a_of_type_Aejq.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, this.jdField_a_of_type_Aejq.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_Aejq.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_Aejq.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_Aejq.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
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
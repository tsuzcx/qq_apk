package com.tencent.mobileqq.activity;

import acdf;
import acdg;
import ajjj;
import ajtg;
import android.text.TextUtils;
import babl;
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
  public TroopTransferActivity$TroopMemberListAdapter$1(acdg paramacdg, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Acdg.jdField_a_of_type_JavaUtilArrayList.size();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Acdg.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(52);
    ajjj localajjj = (ajjj)this.jdField_a_of_type_Acdg.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(51);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      acdf localacdf = (acdf)this.jdField_a_of_type_Acdg.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(localacdf.a)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localajjj == null)
        {
          localObject = null;
          label108:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localacdf.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localacdf.j = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label455;
          }
          localObject = null;
          label161:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localacdf.a))) {
            break label479;
          }
          localObject = babl.a().a(this.jdField_a_of_type_Acdg.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_Acdg.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a), localacdf.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            localacdf.m = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localacdf.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label261:
          if (TextUtils.isEmpty(localacdf.j)) {
            break label488;
          }
          localacdf.b = localacdf.j;
          label282:
          if (TextUtils.isEmpty(localacdf.b)) {
            break label571;
          }
          localacdf.c = ChnToSpell.a(localacdf.b, 2);
          localacdf.d = ChnToSpell.a(localacdf.b, 1);
          label321:
          if (TextUtils.isEmpty(localacdf.g)) {
            break label588;
          }
          localacdf.h = ChnToSpell.a(localacdf.g, 2);
          localacdf.i = ChnToSpell.a(localacdf.g, 1);
          label360:
          if (TextUtils.isEmpty(localacdf.j)) {
            break label605;
          }
          localacdf.k = ChnToSpell.a(localacdf.j, 2);
        }
        for (localacdf.l = ChnToSpell.a(localacdf.j, 1);; localacdf.l = "")
        {
          if (TextUtils.isEmpty(localacdf.m)) {
            break label622;
          }
          localacdf.n = ChnToSpell.a(localacdf.m, 2);
          localacdf.o = ChnToSpell.a(localacdf.m, 1);
          break;
          localObject = localajjj.e(localacdf.a);
          break label108;
          label455:
          localObject = localTroopManager.a(this.jdField_a_of_type_Acdg.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, localacdf.a);
          break label161;
          label479:
          localacdf.m = ((String)localObject);
          break label261;
          label488:
          if (!TextUtils.isEmpty(localacdf.m))
          {
            localacdf.b = localacdf.m;
            break label282;
          }
          if (!TextUtils.isEmpty(localacdf.g))
          {
            localacdf.b = localacdf.g;
            break label282;
          }
          if (TextUtils.isEmpty(localacdf.a)) {
            break label282;
          }
          localacdf.b = localacdf.a;
          localArrayList.add(localacdf.a);
          break label282;
          label571:
          localacdf.c = "";
          localacdf.d = "";
          break label321;
          label588:
          localacdf.h = "";
          localacdf.i = "";
          break label360;
          label605:
          localacdf.k = "";
        }
        label622:
        localacdf.n = "";
        localacdf.o = "";
      }
    }
    Object localObject = (ajtg)this.jdField_a_of_type_Acdg.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.a(20);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((ajtg)localObject).a(this.jdField_a_of_type_Acdg.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, this.jdField_a_of_type_Acdg.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_Acdg.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_Acdg.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_Acdg.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
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
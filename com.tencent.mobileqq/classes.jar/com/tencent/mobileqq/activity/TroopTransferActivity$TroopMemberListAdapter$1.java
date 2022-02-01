package com.tencent.mobileqq.activity;

import afje;
import afjf;
import android.text.TextUtils;
import anvk;
import aoep;
import bhdf;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopTransferActivity$TroopMemberListAdapter$1
  implements Runnable
{
  public TroopTransferActivity$TroopMemberListAdapter$1(afjf paramafjf, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Afjf.jdField_a_of_type_JavaUtilArrayList.size();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_Afjf.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(QQManagerFactory.TROOP_MANAGER);
    anvk localanvk = (anvk)this.jdField_a_of_type_Afjf.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < j)
    {
      afje localafje = (afje)this.jdField_a_of_type_Afjf.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(localafje.a)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localanvk == null)
        {
          localObject = null;
          label110:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localafje.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localafje.j = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label457;
          }
          localObject = null;
          label163:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localafje.a))) {
            break label481;
          }
          localObject = bhdf.a().a(this.jdField_a_of_type_Afjf.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_Afjf.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a), localafje.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            localafje.m = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localafje.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label263:
          if (TextUtils.isEmpty(localafje.j)) {
            break label490;
          }
          localafje.b = localafje.j;
          label284:
          if (TextUtils.isEmpty(localafje.b)) {
            break label573;
          }
          localafje.c = ChnToSpell.a(localafje.b, 2);
          localafje.d = ChnToSpell.a(localafje.b, 1);
          label323:
          if (TextUtils.isEmpty(localafje.g)) {
            break label590;
          }
          localafje.h = ChnToSpell.a(localafje.g, 2);
          localafje.i = ChnToSpell.a(localafje.g, 1);
          label362:
          if (TextUtils.isEmpty(localafje.j)) {
            break label607;
          }
          localafje.k = ChnToSpell.a(localafje.j, 2);
        }
        for (localafje.l = ChnToSpell.a(localafje.j, 1);; localafje.l = "")
        {
          if (TextUtils.isEmpty(localafje.m)) {
            break label624;
          }
          localafje.n = ChnToSpell.a(localafje.m, 2);
          localafje.o = ChnToSpell.a(localafje.m, 1);
          break;
          localObject = localanvk.e(localafje.a);
          break label110;
          label457:
          localObject = localTroopManager.a(this.jdField_a_of_type_Afjf.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, localafje.a);
          break label163;
          label481:
          localafje.m = ((String)localObject);
          break label263;
          label490:
          if (!TextUtils.isEmpty(localafje.m))
          {
            localafje.b = localafje.m;
            break label284;
          }
          if (!TextUtils.isEmpty(localafje.g))
          {
            localafje.b = localafje.g;
            break label284;
          }
          if (TextUtils.isEmpty(localafje.a)) {
            break label284;
          }
          localafje.b = localafje.a;
          localArrayList.add(localafje.a);
          break label284;
          label573:
          localafje.c = "";
          localafje.d = "";
          break label323;
          label590:
          localafje.h = "";
          localafje.i = "";
          break label362;
          label607:
          localafje.k = "";
        }
        label624:
        localafje.n = "";
        localafje.o = "";
      }
    }
    Object localObject = (aoep)this.jdField_a_of_type_Afjf.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((aoep)localObject).a(this.jdField_a_of_type_Afjf.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, this.jdField_a_of_type_Afjf.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_Afjf.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_Afjf.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_Afjf.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
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
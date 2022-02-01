package com.tencent.biz.qqstory.model;

import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import wad;
import wka;
import wkb;
import wkc;

public class TroopNickNameManager$1$1
  implements Runnable
{
  public TroopNickNameManager$1$1(wkb paramwkb, ArrayList paramArrayList) {}
  
  public void run()
  {
    String str1 = ((TroopMemberCardInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).troopuin;
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localTroopMemberCardInfo = (TroopMemberCardInfo)((Iterator)localObject).next();
      str2 = wka.a(str1, localTroopMemberCardInfo.memberuin);
      if ((this.jdField_a_of_type_Wkb.a.a.remove(str2) == null) && (QLog.isColorLevel())) {
        QLog.d("TroopNickNameManager", 2, "loading not match, return");
      }
    }
    while (localArrayList.size() <= 0)
    {
      TroopMemberCardInfo localTroopMemberCardInfo;
      String str2;
      return;
      localArrayList.add(localTroopMemberCardInfo.memberuin);
      break;
    }
    localObject = new wkc();
    ((wkc)localObject).jdField_a_of_type_JavaUtilList = localArrayList;
    ((wkc)localObject).jdField_a_of_type_JavaLangString = str1;
    wad.a().dispatch((Dispatcher.Dispatchable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager.1.1
 * JD-Core Version:    0.7.0.1
 */
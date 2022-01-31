package com.tencent.biz.qqstory.takevideo.shareto;

import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;

public class ShareToGroupAdapter$TroopInfoSelector
{
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  boolean jdField_a_of_type_Boolean;
  
  public ShareToGroupAdapter$TroopInfoSelector(boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
  }
  
  public static ArrayList a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList1.size());
    int i = 0;
    while (i < paramArrayList1.size())
    {
      TroopInfo localTroopInfo = (TroopInfo)paramArrayList1.get(i);
      TroopInfoSelector localTroopInfoSelector = new TroopInfoSelector(false, localTroopInfo);
      if ((paramArrayList2 != null) && (paramArrayList2.contains(localTroopInfo.troopuin))) {
        localTroopInfoSelector.jdField_a_of_type_Boolean = true;
      }
      localArrayList.add(localTroopInfoSelector);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.shareto.ShareToGroupAdapter.TroopInfoSelector
 * JD-Core Version:    0.7.0.1
 */
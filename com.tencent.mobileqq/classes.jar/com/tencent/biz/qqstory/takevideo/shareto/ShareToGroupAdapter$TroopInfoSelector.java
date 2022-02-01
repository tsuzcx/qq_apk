package com.tencent.biz.qqstory.takevideo.shareto;

import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.ArrayList;

public class ShareToGroupAdapter$TroopInfoSelector
{
  TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  boolean jdField_a_of_type_Boolean;
  
  public ShareToGroupAdapter$TroopInfoSelector(boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
  }
  
  public static ArrayList<TroopInfoSelector> a(ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int i = 0;
    while (i < paramArrayList.size())
    {
      TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
      TroopInfoSelector localTroopInfoSelector = new TroopInfoSelector(false, localTroopInfo);
      if ((paramArrayList1 != null) && (paramArrayList1.contains(localTroopInfo.troopuin))) {
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
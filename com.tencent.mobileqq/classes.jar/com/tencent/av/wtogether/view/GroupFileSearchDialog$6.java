package com.tencent.av.wtogether.view;

import com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;

class GroupFileSearchDialog$6
  extends BizTroopObserver
{
  GroupFileSearchDialog$6(GroupFileSearchDialog paramGroupFileSearchDialog) {}
  
  public void onTroopFileStatusUpdate(Object paramObject)
  {
    paramObject = (TroopFileStatusInfo)paramObject;
    if (this.a.a != null)
    {
      TroopFileSearchItemData localTroopFileSearchItemData = this.a.a.a(paramObject.e);
      if ((localTroopFileSearchItemData != null) && (paramObject.b != null))
      {
        localTroopFileSearchItemData.a.j = paramObject.b;
        this.a.a.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.6
 * JD-Core Version:    0.7.0.1
 */
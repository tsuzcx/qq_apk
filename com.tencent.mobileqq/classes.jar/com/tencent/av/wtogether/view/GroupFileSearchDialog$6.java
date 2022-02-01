package com.tencent.av.wtogether.view;

import com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;

class GroupFileSearchDialog$6
  extends BizTroopObserver
{
  GroupFileSearchDialog$6(GroupFileSearchDialog paramGroupFileSearchDialog) {}
  
  protected void a(Object paramObject)
  {
    paramObject = (TroopFileStatusInfo)paramObject;
    if (this.a.k != null)
    {
      TroopFileSearchItemData localTroopFileSearchItemData = this.a.k.a(paramObject.r);
      if ((localTroopFileSearchItemData != null) && (paramObject.l != null))
      {
        localTroopFileSearchItemData.i.w = paramObject.l;
        this.a.k.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.6
 * JD-Core Version:    0.7.0.1
 */
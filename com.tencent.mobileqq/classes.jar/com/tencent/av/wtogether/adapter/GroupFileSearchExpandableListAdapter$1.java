package com.tencent.av.wtogether.adapter;

import com.tencent.mobileqq.search.util.BaseSearchUtil;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

class GroupFileSearchExpandableListAdapter$1
  implements Runnable
{
  GroupFileSearchExpandableListAdapter$1(GroupFileSearchExpandableListAdapter paramGroupFileSearchExpandableListAdapter, EllipsizingTextView paramEllipsizingTextView, TroopFileInfo paramTroopFileInfo, String paramString) {}
  
  public void run()
  {
    CharSequence localCharSequence = BaseSearchUtil.a(this.a, this.b.d, this.c, true);
    this.a.setText("");
    this.a.setText(localCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.GroupFileSearchExpandableListAdapter.1
 * JD-Core Version:    0.7.0.1
 */
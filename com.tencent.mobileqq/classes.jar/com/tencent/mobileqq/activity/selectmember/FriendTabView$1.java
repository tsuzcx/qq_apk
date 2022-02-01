package com.tencent.mobileqq.activity.selectmember;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import com.tencent.widget.PinnedFooterExpandableListView.FooterExpandListViewListener;

class FriendTabView$1
  implements PinnedFooterExpandableListView.FooterExpandListViewListener
{
  FriendTabView$1(FriendTabView paramFriendTabView) {}
  
  public void onClickHeader(PinnedFooterExpandableListView paramPinnedFooterExpandableListView, View paramView, int paramInt)
  {
    if (!this.a.a)
    {
      if (paramInt - 1 >= 0) {
        paramPinnedFooterExpandableListView.collapseGroup(paramInt - 1);
      }
      for (;;)
      {
        this.a.a = true;
        FriendTabView.a(this.a).setFooterEnable(false);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("FriendTabView", 2, "header group unusal: " + paramInt);
        }
      }
    }
    if (paramPinnedFooterExpandableListView.isGroupExpanded(paramInt))
    {
      paramPinnedFooterExpandableListView.collapseGroup(paramInt);
      return;
    }
    paramPinnedFooterExpandableListView.expandGroup(paramInt);
  }
  
  public void onHeaderDisable()
  {
    this.a.a = true;
    FriendTabView.a(this.a).setFooterEnable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTabView.1
 * JD-Core Version:    0.7.0.1
 */
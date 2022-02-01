package com.tencent.mobileqq.activity.contact.connections;

import android.os.Bundle;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class ConnectsExplorationFriendAdapter$8
  implements AbsListView.OnScrollListener
{
  ConnectsExplorationFriendAdapter$8(ConnectsExplorationFriendAdapter paramConnectsExplorationFriendAdapter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ConnectsExplorationFriendAdapter.a(this.a, paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    if (ConnectsExplorationFriendAdapter.k(this.a) >= this.a.getCount() - 2)
    {
      paramAbsListView = new Bundle();
      paramAbsListView.putString("from", "4");
      ConnectsExplorationFriendAdapter.d(this.a).b(4, ConnectsExplorationFriendAdapter.a(this.a), paramAbsListView);
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationFriendAdapter.8
 * JD-Core Version:    0.7.0.1
 */
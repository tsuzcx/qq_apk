package com.tencent.mobileqq.activity.contact.troop;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.IFaceDecoder;

class TroopWithCommonFriendsFragment$1
  extends RecyclerView.OnScrollListener
{
  TroopWithCommonFriendsFragment$1(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    this.a.c = paramInt;
    if (paramInt == 0)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager)) {
        ((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition();
      }
    }
    if (this.a.a != null)
    {
      if (paramInt != 0)
      {
        this.a.a.cancelPendingRequests();
        this.a.a.pause();
        return;
      }
      if (this.a.a.isPausing()) {
        this.a.a.resume();
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.1
 * JD-Core Version:    0.7.0.1
 */
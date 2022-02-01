package com.tencent.mobileqq.activity.contact.troop;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.IFaceDecoder;

class TroopNotifyAndRecommendView$25
  extends RecyclerView.OnScrollListener
{
  TroopNotifyAndRecommendView$25(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    this.a.b = paramInt;
    if (paramInt == 0)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (((paramRecyclerView instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition() + 1 == TroopNotifyAndRecommendView.a(this.a).getItemCount())) {
        TroopNotifyAndRecommendView.n(this.a);
      }
    }
    if (this.a.a != null)
    {
      if (paramInt == 0) {
        break label98;
      }
      this.a.a.cancelPendingRequests();
      this.a.a.pause();
    }
    label98:
    while (!this.a.a.isPausing()) {
      return;
    }
    this.a.a.resume();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.25
 * JD-Core Version:    0.7.0.1
 */
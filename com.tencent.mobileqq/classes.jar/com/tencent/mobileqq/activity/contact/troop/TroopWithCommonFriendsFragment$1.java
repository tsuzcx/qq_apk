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
    this.a.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager)) {
        ((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition();
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      if (paramInt != 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
        this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment.1
 * JD-Core Version:    0.7.0.1
 */
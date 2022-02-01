package com.tencent.mobileqq.activity.contact.troop;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.CommonAdapter;
import com.tencent.mobileqq.app.face.IFaceDecoder;

class TroopSuspiciousFragment$1
  extends RecyclerView.OnScrollListener
{
  TroopSuspiciousFragment$1(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    this.a.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (((paramRecyclerView instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition() + 1 == TroopSuspiciousFragment.a(this.a).getItemCount())) {
        TroopSuspiciousFragment.a(this.a);
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      if (paramInt == 0) {
        break label98;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
    }
    label98:
    while (!this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment.1
 * JD-Core Version:    0.7.0.1
 */
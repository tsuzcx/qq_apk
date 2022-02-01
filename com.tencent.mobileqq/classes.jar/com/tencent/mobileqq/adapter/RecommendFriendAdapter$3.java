package com.tencent.mobileqq.adapter;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

class RecommendFriendAdapter$3
  extends FriendListObserver
{
  RecommendFriendAdapter$3(RecommendFriendAdapter paramRecommendFriendAdapter) {}
  
  public void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onCancelMayKnowRecommend isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener instanceof MayKnowAdapter.OnRecommendsUpdateListener))) {
        ((MayKnowAdapter.OnRecommendsUpdateListener)this.a.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener).a(paramString);
      }
      RecommendFriendAdapter.a(this.a);
    }
  }
  
  public void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      RecommendFriendAdapter.a(this.a);
    }
  }
  
  public void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onMayKnowListPushAdd isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendAdapter.a(this.a);
    }
  }
  
  public void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onMayKnowListPushDel isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendAdapter.a(this.a);
    }
  }
  
  public void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendAdapter", 2, "onMayknowStateChanged isSuccess = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.a.notifyDataSetChanged();
      if (RecommendFriendAdapter.a(this.a) != null)
      {
        RecommendFriendAdapter.a(this.a).removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        RecommendFriendAdapter.a(this.a).postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1600L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RecommendFriendAdapter.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contacts.mayknow;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

class RecommendFriendFragment$1
  extends FriendListObserver
{
  RecommendFriendFragment$1(RecommendFriendFragment paramRecommendFriendFragment) {}
  
  public void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onCancelMayKnowRecommend isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.a);
    }
  }
  
  public void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onGetMayKnowRecommend isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.a);
    }
  }
  
  public void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onMayKnowListPushAdd isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.a);
    }
  }
  
  public void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onMayKnowListPushDel isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.a);
    }
  }
  
  public void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "onMayknowStateChanged isSuccess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsMayknowRecommendsAdapter.notifyDataSetChanged();
      }
      if (this.a.jdField_a_of_type_ComTencentWidgetXListView != null)
      {
        this.a.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        this.a.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1600L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment.1
 * JD-Core Version:    0.7.0.1
 */
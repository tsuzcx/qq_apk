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
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCancelMayKnowRecommend isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("RecommendFriendAdapter", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener instanceof MayKnowAdapter.OnRecommendsUpdateListener))) {
        ((MayKnowAdapter.OnRecommendsUpdateListener)this.a.jdField_a_of_type_ComTencentMobileqqAdapterMayKnowAdapter$OnRecommendsCanceledListener).a(paramString);
      }
      RecommendFriendAdapter.a(this.a);
    }
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      RecommendFriendAdapter.a(this.a);
    }
  }
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onMayKnowListPushAdd isSuccess = ");
      paramList.append(paramBoolean);
      QLog.d("RecommendFriendAdapter", 2, paramList.toString());
    }
    if (paramBoolean) {
      RecommendFriendAdapter.a(this.a);
    }
  }
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onMayKnowListPushDel isSuccess = ");
      paramList.append(paramBoolean);
      QLog.d("RecommendFriendAdapter", 2, paramList.toString());
    }
    if (paramBoolean) {
      RecommendFriendAdapter.a(this.a);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMayknowStateChanged isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("RecommendFriendAdapter", 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RecommendFriendAdapter.3
 * JD-Core Version:    0.7.0.1
 */
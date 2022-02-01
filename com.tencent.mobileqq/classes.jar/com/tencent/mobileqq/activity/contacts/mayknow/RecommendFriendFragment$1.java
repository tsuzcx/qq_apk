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
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onCancelMayKnowRecommend isSuccess:");
      paramString.append(paramBoolean);
      QLog.d("RecommendFriendFragment", 2, paramString.toString());
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.a);
    }
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetMayKnowRecommend isSuccess=");
      paramBundle.append(paramBoolean);
      QLog.d("RecommendFriendFragment", 2, paramBundle.toString());
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.a);
    }
  }
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onMayKnowListPushAdd isSuccess:");
      paramList.append(paramBoolean);
      QLog.d("RecommendFriendFragment", 2, paramList.toString());
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.a);
    }
  }
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onMayKnowListPushDel isSuccess:");
      paramList.append(paramBoolean);
      QLog.d("RecommendFriendFragment", 2, paramList.toString());
    }
    if (paramBoolean) {
      RecommendFriendFragment.a(this.a);
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onMayknowStateChanged isSuccess:");
      localStringBuilder.append(paramBoolean);
      QLog.d("RecommendFriendFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (this.a.d != null) {
        this.a.d.notifyDataSetChanged();
      }
      if (this.a.b != null)
      {
        this.a.b.removeCallbacks(this.a.h);
        this.a.b.postDelayed(this.a.h, 1600L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment.1
 * JD-Core Version:    0.7.0.1
 */
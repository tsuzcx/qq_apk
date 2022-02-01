package com.tencent.mobileqq.adapter;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import mqq.util.WeakReference;

final class MayKnowAdapter$MyFriendListObserver
  extends FriendListObserver
{
  WeakReference<MayKnowAdapter> a;
  
  MayKnowAdapter$MyFriendListObserver(MayKnowAdapter paramMayKnowAdapter)
  {
    this.a = new WeakReference(paramMayKnowAdapter);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      MayKnowAdapter localMayKnowAdapter = (MayKnowAdapter)this.a.get();
      if (localMayKnowAdapter != null)
      {
        paramString = MayKnowAdapter.a(localMayKnowAdapter, paramString);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onCancelMayKnowRecommend target：");
          localStringBuilder.append(paramString);
          QLog.d("MayKnowAdapter", 2, localStringBuilder.toString());
        }
        if (paramString != null)
        {
          MayKnowAdapter.a(localMayKnowAdapter, paramString);
          return;
        }
        MayKnowAdapter.a(localMayKnowAdapter);
        return;
      }
      QLog.d("MayKnowAdapter", 1, "onCancelMayKnowRecommend  adapter is null!");
    }
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = (MayKnowAdapter)this.a.get();
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MayKnowAdapter", 2, "onGetMayKnowRecommend ");
        }
        MayKnowAdapter.a(paramBundle);
        return;
      }
      QLog.d("MayKnowAdapter", 1, "onGetMayKnowRecommend adapter is null!");
    }
  }
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onMayKnowListPushAdd");
    }
    if (paramBoolean)
    {
      paramList = (MayKnowAdapter)this.a.get();
      if (paramList != null)
      {
        MayKnowAdapter.a(paramList);
        return;
      }
      QLog.d("MayKnowAdapter", 1, "onMayKnowListPushAdd adapter is null!");
    }
  }
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onMayKnowListPushDel");
    }
    if (paramBoolean)
    {
      paramList = (MayKnowAdapter)this.a.get();
      if (paramList != null)
      {
        MayKnowAdapter.a(paramList);
        return;
      }
      QLog.d("MayKnowAdapter", 1, "onMayKnowListPushDel adapter is null!");
    }
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      MayKnowAdapter localMayKnowAdapter = (MayKnowAdapter)this.a.get();
      if (localMayKnowAdapter != null)
      {
        if (MayKnowAdapter.c(localMayKnowAdapter) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayKnowAdapter", 2, "onMayknowStateChanged");
          }
          localMayKnowAdapter.notifyDataSetChanged();
          MayKnowAdapter.c(localMayKnowAdapter).postDelayed(localMayKnowAdapter.h, 1600L);
        }
      }
      else {
        QLog.d("MayKnowAdapter", 1, "onMayknowStateChanged adapter is null!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.MayKnowAdapter.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */
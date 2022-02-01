package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EmosmActivity$10
  implements QueryCallback<List<EmoticonPackage>>
{
  EmosmActivity$10(EmosmActivity paramEmosmActivity) {}
  
  public void a(List<EmoticonPackage> paramList)
  {
    this.a.mEPDatas.clear();
    if (this.a.mAdapter != null) {
      this.a.mAdapter.b();
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      EmoticonPackage localEmoticonPackage;
      if (this.a.mLaunchMode == 1)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)paramList.next();
          if ((3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
            this.a.mEPDatas.add(localEmoticonPackage);
          }
        }
      }
      if (this.a.mLaunchMode == 2)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localEmoticonPackage = (EmoticonPackage)paramList.next();
          if ((3 == localEmoticonPackage.jobType) || (5 == localEmoticonPackage.jobType)) {
            this.a.mEPDatas.add(localEmoticonPackage);
          }
        }
      }
    }
    if (this.a.mLaunchMode == 1)
    {
      if (this.a.mListView.findHeaderViewPosition(this.a.headerView) == -1) {
        this.a.mListView.addHeaderView(this.a.headerView);
      }
      this.a.headerView.setVisibility(0);
      this.a.changeMagicHeaderVisibility();
    }
    else if (this.a.mEPDatas.isEmpty())
    {
      this.a.headerView.setVisibility(8);
    }
    else
    {
      this.a.mListView.removeHeaderView(this.a.headerView);
    }
    if (this.a.mLaunchMode == 2) {
      this.a.setTitle(2131888884);
    } else {
      this.a.setTitle(2131889117);
    }
    if (this.a.mAdapter != null) {
      this.a.mAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.10
 * JD-Core Version:    0.7.0.1
 */
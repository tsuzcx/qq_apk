package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class TroopMemberListActivity$15
  implements View.OnClickListener
{
  TroopMemberListActivity$15(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    AssertUtils.checkNotNull(this.a.mAdapter);
    AssertUtils.checkNotNull(this.a.mListData);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.mListData.size())
    {
      localArrayList.add(((TroopMemberListActivity.ATroopMember)this.a.mListData.get(i)).a);
      i += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("extra_member_uin_list", localArrayList);
    this.a.setResult(-1, localIntent);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.15
 * JD-Core Version:    0.7.0.1
 */
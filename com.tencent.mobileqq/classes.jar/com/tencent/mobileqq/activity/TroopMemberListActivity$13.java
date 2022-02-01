package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$13
  implements View.OnClickListener
{
  TroopMemberListActivity$13(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.a;
    localTroopMemberListActivity.mIsInDeleteState = false;
    localTroopMemberListActivity.mSlideLeftUin = "";
    localTroopMemberListActivity.mRightManageBtn.setVisibility(8);
    this.a.mTitleRightImgBtn.setVisibility(0);
    if (this.a.mFrom != 22) {
      this.a.mTitleSortImgBtn.setVisibility(0);
    }
    if (this.a.mAdapter != null) {
      this.a.mAdapter.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.13
 * JD-Core Version:    0.7.0.1
 */
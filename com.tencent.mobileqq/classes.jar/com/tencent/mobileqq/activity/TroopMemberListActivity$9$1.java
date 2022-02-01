package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$9$1
  implements View.OnClickListener
{
  TroopMemberListActivity$9$1(TroopMemberListActivity.9 param9) {}
  
  public void onClick(View paramView)
  {
    this.a.a.mIsInMultiDeleteState = false;
    this.a.a.mRightManageBtn.setText(2131888824);
    this.a.a.mRightManageBtn.setVisibility(0);
    this.a.a.mRightManageBtn.setOnClickListener(this.a.a.mMultiDeleteListener);
    this.a.a.mRightManageBtn.setEnabled(true);
    this.a.a.mLeftBackBtn.setVisibility(8);
    this.a.a.mLeftBackBtn = ((TextView)this.a.a.findViewById(2131436180));
    this.a.a.mLeftBackBtn.setVisibility(0);
    this.a.a.mLeftBackBtn.setOnClickListener(this.a.a.mFinishListener);
    if (this.a.a.mAdapter != null) {
      this.a.a.mAdapter.c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.9.1
 * JD-Core Version:    0.7.0.1
 */
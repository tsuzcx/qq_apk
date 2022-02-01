package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$9
  implements View.OnClickListener
{
  TroopMemberListActivity$9(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.a;
    localTroopMemberListActivity.mIsInMultiDeleteState = true;
    localTroopMemberListActivity.mLeftBackBtn.setVisibility(8);
    localTroopMemberListActivity = this.a;
    localTroopMemberListActivity.mLeftBackBtn = ((TextView)localTroopMemberListActivity.findViewById(2131369204));
    this.a.mLeftBackBtn.setVisibility(0);
    this.a.mLeftBackBtn.setText(HardCodeUtil.a(2131715417));
    this.a.mLeftBackBtn.setOnClickListener(new TroopMemberListActivity.9.1(this));
    TroopMemberListActivity.access$200(this.a);
    if (this.a.mAdapter != null) {
      this.a.mAdapter.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.9
 * JD-Core Version:    0.7.0.1
 */
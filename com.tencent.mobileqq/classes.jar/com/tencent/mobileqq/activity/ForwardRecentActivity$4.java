package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.fragment.QQGuildForwardGuildListFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Map;

class ForwardRecentActivity$4
  implements View.OnClickListener
{
  ForwardRecentActivity$4(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    if (ForwardRecentActivity.access$400(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardEntranceActivity", 2, "recent QQ guild is onClicked! MultiSelectStatus!!!");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardEntranceActivity", 2, "recent QQ guild is onClicked!");
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("call_by_forward", true);
      if (this.a.dataUri != null) {
        localIntent.setData(this.a.dataUri);
      }
      Bundle localBundle = this.a.mForwardOption.al();
      if (localBundle.getBoolean("sendMultiple", false)) {
        localIntent.putStringArrayListExtra("foward_key_m_p_l", localBundle.getStringArrayList("foward_key_m_p_l"));
      } else {
        localIntent.putExtra("forward_filepath", localBundle.getString("forward_filepath"));
      }
      localIntent.putExtras(this.a.mForwardOption.al());
      if (this.a.getIntent().getBooleanExtra("isFromShare", false))
      {
        localIntent.putExtras(this.a.mForwardOption.al());
        localIntent.setAction(this.a.getIntent().getAction());
      }
      else
      {
        localIntent.putExtras(this.a.getIntent().getExtras());
      }
      ForwardRecentActivity.access$500(this.a, localIntent);
      localIntent.putExtra("is_multi_selection", ForwardRecentActivity.access$400(this.a));
      localIntent.putParcelableArrayListExtra("selected_target_list", new ArrayList(ForwardRecentActivity.access$600(this.a).values()));
      localIntent.putExtra("only_single_selection", this.a.mOnlySingleSelection);
      QPublicFragmentActivity.startForResult(this.a.getActivity(), localIntent, QQGuildForwardGuildListFragment.class, 20000);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity.4
 * JD-Core Version:    0.7.0.1
 */
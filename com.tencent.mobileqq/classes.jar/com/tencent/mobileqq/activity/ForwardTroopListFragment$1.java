package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Map;

class ForwardTroopListFragment$1
  implements View.OnClickListener
{
  ForwardTroopListFragment$1(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("selected_target_list", new ArrayList(ForwardTroopListFragment.a(this.a).values()));
    this.a.getActivity().setResult(0, localIntent);
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment.1
 * JD-Core Version:    0.7.0.1
 */
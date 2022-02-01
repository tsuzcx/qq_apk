package com.tencent.mobileqq.activity.contacts.friend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class BuddyListAdapter$ItemClickListener
  implements View.OnClickListener
{
  private WeakReference<BuddyListAdapter> a;
  
  public BuddyListAdapter$ItemClickListener(BuddyListAdapter paramBuddyListAdapter)
  {
    this.a = new WeakReference(paramBuddyListAdapter);
  }
  
  public void onClick(View paramView)
  {
    BuddyListAdapter localBuddyListAdapter = (BuddyListAdapter)this.a.get();
    if (localBuddyListAdapter != null) {
      localBuddyListAdapter.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.ItemClickListener
 * JD-Core Version:    0.7.0.1
 */
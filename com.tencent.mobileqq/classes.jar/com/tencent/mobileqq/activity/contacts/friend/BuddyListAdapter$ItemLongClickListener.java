package com.tencent.mobileqq.activity.contacts.friend;

import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class BuddyListAdapter$ItemLongClickListener
  implements View.OnLongClickListener
{
  private WeakReference<BuddyListAdapter> a;
  
  public BuddyListAdapter$ItemLongClickListener(BuddyListAdapter paramBuddyListAdapter)
  {
    this.a = new WeakReference(paramBuddyListAdapter);
  }
  
  public boolean onLongClick(View paramView)
  {
    BuddyListAdapter localBuddyListAdapter = (BuddyListAdapter)this.a.get();
    if (localBuddyListAdapter != null) {
      return localBuddyListAdapter.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.ItemLongClickListener
 * JD-Core Version:    0.7.0.1
 */
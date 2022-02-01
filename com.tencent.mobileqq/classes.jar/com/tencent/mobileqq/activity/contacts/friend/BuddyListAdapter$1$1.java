package com.tencent.mobileqq.activity.contacts.friend;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class BuddyListAdapter$1$1
  implements Runnable
{
  BuddyListAdapter$1$1(BuddyListAdapter.1 param1, ArrayList paramArrayList, SparseArray paramSparseArray, SparseIntArray paramSparseIntArray) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "notifyDataSetChanged out ThreadManager");
    }
    BuddyListAdapter.a(this.d.this$0, this.a);
    BuddyListAdapter.a(this.d.this$0, this.b);
    BuddyListAdapter.a(this.d.this$0, this.c);
    ((FPSPinnedHeaderExpandableListView)BuddyListAdapter.a(this.d.this$0)).hideCurShowingRightView();
    BuddyListAdapter.b(this.d.this$0);
    if (BuddyListAdapter.c(this.d.this$0))
    {
      BuddyListAdapter.a(this.d.this$0, false);
      BuddyListAdapter.d(this.d.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */
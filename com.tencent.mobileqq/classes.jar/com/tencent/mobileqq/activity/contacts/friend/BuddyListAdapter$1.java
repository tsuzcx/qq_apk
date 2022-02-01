package com.tencent.mobileqq.activity.contacts.friend;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class BuddyListAdapter$1
  implements Runnable
{
  BuddyListAdapter$1(BuddyListAdapter paramBuddyListAdapter) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    SparseArray localSparseArray = new SparseArray();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    try
    {
      BuddyListAdapter.a(this.this$0, localArrayList, localSparseArray, localSparseIntArray);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("BuddyListAdapter", 1, "notifyDataSetChanged error oom ", localOutOfMemoryError);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "notifyDataSetChanged in ThreadManager");
    }
    ThreadManager.getUIHandler().post(new BuddyListAdapter.1.1(this, localArrayList, localSparseArray, localSparseIntArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.1
 * JD-Core Version:    0.7.0.1
 */
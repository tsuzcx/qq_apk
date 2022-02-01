package com.tencent.mobileqq.activity.contacts.friend;

import ajuh;
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
    ajuh.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$1.this$0, this.jdField_a_of_type_JavaUtilArrayList);
    ajuh.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$1.this$0, this.jdField_a_of_type_AndroidUtilSparseArray);
    ajuh.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$1.this$0, this.jdField_a_of_type_AndroidUtilSparseIntArray);
    ((FPSPinnedHeaderExpandableListView)ajuh.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$1.this$0)).b();
    ajuh.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$1.this$0);
    if (ajuh.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$1.this$0))
    {
      ajuh.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$1.this$0, false);
      ajuh.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */
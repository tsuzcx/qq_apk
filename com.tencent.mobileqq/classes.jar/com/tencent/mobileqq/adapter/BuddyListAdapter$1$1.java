package com.tencent.mobileqq.adapter;

import ails;
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
    ails.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter$1.this$0, this.jdField_a_of_type_JavaUtilArrayList);
    ails.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter$1.this$0, this.jdField_a_of_type_AndroidUtilSparseArray);
    ails.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter$1.this$0, this.jdField_a_of_type_AndroidUtilSparseIntArray);
    ((FPSPinnedHeaderExpandableListView)this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter$1.this$0.a).b();
    ails.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter$1.this$0);
    if (ails.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter$1.this$0))
    {
      ails.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter$1.this$0, false);
      ails.b(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.BuddyListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */
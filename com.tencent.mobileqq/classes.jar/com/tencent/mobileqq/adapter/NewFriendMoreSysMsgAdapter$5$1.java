package com.tencent.mobileqq.adapter;

import aiod;
import android.view.View;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;

class NewFriendMoreSysMsgAdapter$5$1
  implements Runnable
{
  NewFriendMoreSysMsgAdapter$5$1(NewFriendMoreSysMsgAdapter.5 param5, ArrayList paramArrayList) {}
  
  public void run()
  {
    aiod.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter$5.this$0, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter$5.this$0.notifyDataSetChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter$5.this$0.getCount() > 0)
    {
      aiod.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter$5.this$0).setVisibility(0);
      aiod.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter$5.this$0).setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter$5.a) && (aiod.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter$5.this$0) < this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter$5.this$0.getCount())) {
        aiod.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter$5.this$0).setSelection(aiod.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter$5.this$0));
      }
      return;
    }
    aiod.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter$5.this$0).setVisibility(0);
    aiod.a(this.jdField_a_of_type_ComTencentMobileqqAdapterNewFriendMoreSysMsgAdapter$5.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.5.1
 * JD-Core Version:    0.7.0.1
 */
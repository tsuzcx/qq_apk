package com.tencent.av.wtogether.view;

import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;

class GroupFileSearchDialog$1
  implements Runnable
{
  GroupFileSearchDialog$1(GroupFileSearchDialog paramGroupFileSearchDialog) {}
  
  public void run()
  {
    TroopFileSearchManager localTroopFileSearchManager = TroopFileSearchManager.a();
    this.this$0.jdField_a_of_type_JavaUtilList = localTroopFileSearchManager.a(this.this$0.jdField_a_of_type_AndroidAppActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (this.this$0.b)
    {
      this.this$0.b = false;
      this.this$0.a(this.this$0.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.wtogether.view;

import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;

class GroupFileSearchDialog$1
  implements Runnable
{
  GroupFileSearchDialog$1(GroupFileSearchDialog paramGroupFileSearchDialog) {}
  
  public void run()
  {
    Object localObject = TroopFileSearchManager.a();
    GroupFileSearchDialog localGroupFileSearchDialog = this.this$0;
    localGroupFileSearchDialog.jdField_a_of_type_JavaUtilList = ((TroopFileSearchManager)localObject).a(localGroupFileSearchDialog.jdField_a_of_type_AndroidAppActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (this.this$0.b)
    {
      localObject = this.this$0;
      ((GroupFileSearchDialog)localObject).b = false;
      ((GroupFileSearchDialog)localObject).a(((GroupFileSearchDialog)localObject).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.1
 * JD-Core Version:    0.7.0.1
 */
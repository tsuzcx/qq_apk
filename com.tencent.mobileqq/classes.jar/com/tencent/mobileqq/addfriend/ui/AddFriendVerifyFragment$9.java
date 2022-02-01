package com.tencent.mobileqq.addfriend.ui;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class AddFriendVerifyFragment$9
  implements Runnable
{
  AddFriendVerifyFragment$9(AddFriendVerifyFragment paramAddFriendVerifyFragment, int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 3004)
    {
      int i = this.b;
      if ((i == 5) || (i == 6) || (i == 7) || (i == 8))
      {
        String str1;
        if (this.jdField_a_of_type_Boolean) {
          str1 = "multiMode_send";
        } else {
          str1 = "singleMode_send";
        }
        AppInterface localAppInterface = AddFriendVerifyFragment.a(this.this$0);
        String str3 = this.jdField_a_of_type_JavaLangString;
        String str2;
        if (this.jdField_a_of_type_Boolean) {
          str2 = "1";
        } else {
          str2 = String.valueOf(this.c);
        }
        ReportController.b(localAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", str1, 0, 0, str3, str2, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.9
 * JD-Core Version:    0.7.0.1
 */
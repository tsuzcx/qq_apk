package com.tencent.mobileqq.activity;

import axqy;
import com.tencent.mobileqq.app.QQAppInterface;

class AddFriendVerifyActivity$31
  implements Runnable
{
  AddFriendVerifyActivity$31(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3) {}
  
  public void run()
  {
    String str1;
    QQAppInterface localQQAppInterface;
    String str3;
    if ((this.jdField_a_of_type_Int == 3004) && ((this.b == 5) || (this.b == 6) || (this.b == 7) || (this.b == 8)))
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label102;
      }
      str1 = "multiMode_send";
      localQQAppInterface = this.this$0.app;
      str3 = this.jdField_a_of_type_JavaLangString;
      if (!this.jdField_a_of_type_Boolean) {
        break label108;
      }
    }
    label102:
    label108:
    for (String str2 = "1";; str2 = String.valueOf(this.c))
    {
      axqy.b(localQQAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", str1, 0, 0, str3, str2, "", "");
      return;
      str1 = "singleMode_send";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.31
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.model;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class UserOperationModule$1
  implements Runnable
{
  UserOperationModule$1(UserOperationModule paramUserOperationModule, String paramString1, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("UserOperationModule", 1, "avatarUrl is empty, request userInfo");
      ReadInJoyUserInfoModule localReadInJoyUserInfoModule = UserOperationModule.a();
      if (localReadInJoyUserInfoModule == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.b);
      localReadInJoyUserInfoModule.a(localArrayList, new UserOperationModule.1.1(this));
      return;
    }
    UserOperationModule.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, 2, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.1
 * JD-Core Version:    0.7.0.1
 */
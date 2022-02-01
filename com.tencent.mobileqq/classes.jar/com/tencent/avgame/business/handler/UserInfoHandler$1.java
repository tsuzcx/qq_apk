package com.tencent.avgame.business.handler;

import java.util.HashMap;
import java.util.List;

class UserInfoHandler$1
  implements Runnable
{
  UserInfoHandler$1(UserInfoHandler paramUserInfoHandler, HashMap paramHashMap, List paramList1, List paramList2) {}
  
  public void run()
  {
    UserInfoHandler.a(this.this$0, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_JavaUtilList, this.b);
    this.this$0.notifyUI(2, true, new Object[] { Integer.valueOf(0), this.jdField_a_of_type_JavaUtilHashMap });
    if (this.b.size() > 0) {
      UserInfoHandler.a(this.this$0, 0, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.business.handler.UserInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */
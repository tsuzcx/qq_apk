package com.tencent.avgame.business.handler;

import java.util.HashMap;
import java.util.List;
import mwp;

public class UserInfoHandler$1
  implements Runnable
{
  public UserInfoHandler$1(mwp parammwp, HashMap paramHashMap, List paramList1, List paramList2) {}
  
  public void run()
  {
    mwp.a(this.this$0, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_JavaUtilList, this.b);
    this.this$0.notifyUI(2, true, new Object[] { Integer.valueOf(0), this.jdField_a_of_type_JavaUtilHashMap });
    if (this.b.size() > 0) {
      mwp.a(this.this$0, 0, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.business.handler.UserInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */
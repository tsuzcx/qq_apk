package com.tencent.mobileqq.activity.aio.helper;

import afpr;
import afps;
import ahow;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;
import myb;

public class AVGameHelper$1$1
  implements Runnable
{
  public AVGameHelper$1$1(afps paramafps, myb parammyb) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Myb == null) || (this.jdField_a_of_type_Myb.jdField_a_of_type_JavaLangString == null) || (!afpr.a(this.jdField_a_of_type_Afps.a).curFriendUin.equals(this.jdField_a_of_type_Myb.jdField_a_of_type_JavaLangString)) || (afpr.a(this.jdField_a_of_type_Afps.a) == null)) {
      return;
    }
    if ((this.jdField_a_of_type_Myb.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Myb.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      afpr.a(this.jdField_a_of_type_Afps.a).a(this.jdField_a_of_type_Myb.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Myb.jdField_a_of_type_Int);
      return;
    }
    afpr.a(this.jdField_a_of_type_Afps.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.1
 * JD-Core Version:    0.7.0.1
 */
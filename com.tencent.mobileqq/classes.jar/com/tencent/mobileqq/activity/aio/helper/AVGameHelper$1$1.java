package com.tencent.mobileqq.activity.aio.helper;

import aggv;
import aggw;
import aijr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;
import ndn;

public class AVGameHelper$1$1
  implements Runnable
{
  public AVGameHelper$1$1(aggw paramaggw, ndn paramndn) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Ndn == null) || (this.jdField_a_of_type_Ndn.jdField_a_of_type_JavaLangString == null) || (!aggv.a(this.jdField_a_of_type_Aggw.a).curFriendUin.equals(this.jdField_a_of_type_Ndn.jdField_a_of_type_JavaLangString)) || (aggv.a(this.jdField_a_of_type_Aggw.a) == null)) {
      return;
    }
    if ((this.jdField_a_of_type_Ndn.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Ndn.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      aggv.a(this.jdField_a_of_type_Aggw.a).a(this.jdField_a_of_type_Ndn.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Ndn.jdField_a_of_type_Int);
      return;
    }
    aggv.a(this.jdField_a_of_type_Aggw.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.1
 * JD-Core Version:    0.7.0.1
 */
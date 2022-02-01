package com.tencent.mobileqq.activity.aio.helper;

import agkw;
import agkx;
import aiks;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;
import mwr;

public class AVGameHelper$1$1
  implements Runnable
{
  public AVGameHelper$1$1(agkx paramagkx, mwr parammwr) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Mwr == null) || (this.jdField_a_of_type_Mwr.jdField_a_of_type_JavaLangString == null) || (!agkw.a(this.jdField_a_of_type_Agkx.a).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Mwr.jdField_a_of_type_JavaLangString)) || (agkw.a(this.jdField_a_of_type_Agkx.a) == null)) {
      return;
    }
    if ((this.jdField_a_of_type_Mwr.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Mwr.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      agkw.a(this.jdField_a_of_type_Agkx.a).a(this.jdField_a_of_type_Mwr.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Mwr.jdField_a_of_type_Int);
      return;
    }
    agkw.a(this.jdField_a_of_type_Agkx.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.1
 * JD-Core Version:    0.7.0.1
 */
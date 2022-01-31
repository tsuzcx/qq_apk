package com.tencent.mobileqq.activity.qwallet;

import agxf;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class RedPacketEmojiFragment$3$1
  implements Runnable
{
  public RedPacketEmojiFragment$3$1(agxf paramagxf, int paramInt, HashMap paramHashMap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "doLoading result:" + this.jdField_a_of_type_Int + ",pathres=" + this.jdField_a_of_type_JavaUtilHashMap);
    }
    if ((this.jdField_a_of_type_Int == 0) && (agxf.a(this.jdField_a_of_type_Agxf, this.jdField_a_of_type_JavaUtilHashMap)))
    {
      this.jdField_a_of_type_Agxf.a.a();
      return;
    }
    this.jdField_a_of_type_Agxf.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.3.1
 * JD-Core Version:    0.7.0.1
 */
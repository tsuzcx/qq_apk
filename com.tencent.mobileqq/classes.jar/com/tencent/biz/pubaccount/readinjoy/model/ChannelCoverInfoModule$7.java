package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import oxb;
import pfg;

public class ChannelCoverInfoModule$7
  implements Runnable
{
  public ChannelCoverInfoModule$7(pfg parampfg, int paramInt, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "notifyUIToRefresh channelId=" + this.jdField_a_of_type_Int + " ;size = " + this.jdField_a_of_type_JavaUtilList.size());
    }
    if (this.jdField_a_of_type_Int == 0) {
      oxb.a().f(true, this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      oxb.a().a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_JavaUtilList);
      return;
      if (this.jdField_a_of_type_Int == 56) {
        oxb.a().g(true, this.jdField_a_of_type_JavaUtilList);
      } else if (this.jdField_a_of_type_Int == 41402) {
        oxb.a().h(true, this.jdField_a_of_type_JavaUtilList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.7
 * JD-Core Version:    0.7.0.1
 */
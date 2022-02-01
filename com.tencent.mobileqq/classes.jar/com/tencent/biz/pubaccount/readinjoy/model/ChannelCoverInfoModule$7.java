package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChannelCoverInfoModule$7
  implements Runnable
{
  ChannelCoverInfoModule$7(ChannelCoverInfoModule paramChannelCoverInfoModule, int paramInt, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "notifyUIToRefresh channelId=" + this.jdField_a_of_type_Int + " ;size = " + this.jdField_a_of_type_JavaUtilList.size());
    }
    if (this.jdField_a_of_type_Int == 0) {
      ReadInJoyLogicEngineEventDispatcher.a().f(true, this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_Int, true, this.jdField_a_of_type_JavaUtilList);
      return;
      if (this.jdField_a_of_type_Int == 56) {
        ReadInJoyLogicEngineEventDispatcher.a().g(true, this.jdField_a_of_type_JavaUtilList);
      } else if (this.jdField_a_of_type_Int == 41402) {
        ReadInJoyLogicEngineEventDispatcher.a().h(true, this.jdField_a_of_type_JavaUtilList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import osj;
import ozy;

public class ChannelCoverInfoModule$6
  implements Runnable
{
  public ChannelCoverInfoModule$6(ozy paramozy, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    QLog.d("ChannelCoverInfoModule", 2, new Object[] { "notifyIndependentTabUIToRefresh, success = ", Integer.valueOf(i) });
    osj.a().e(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.6
 * JD-Core Version:    0.7.0.1
 */
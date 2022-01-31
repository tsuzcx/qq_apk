package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import oxb;
import pfg;

public class ChannelCoverInfoModule$6
  implements Runnable
{
  public ChannelCoverInfoModule$6(pfg parampfg, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    }
    QLog.d("ChannelCoverInfoModule", 2, new Object[] { "notifyIndependentTabUIToRefresh, success = ", Integer.valueOf(i) });
    oxb.a().e(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.6
 * JD-Core Version:    0.7.0.1
 */
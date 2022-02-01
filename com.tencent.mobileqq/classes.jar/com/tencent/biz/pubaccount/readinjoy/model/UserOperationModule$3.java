package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import pmk;
import pwk;
import pyq;
import pys;
import pyt;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspFollowOperationResult;

public class UserOperationModule$3
  implements Runnable
{
  public UserOperationModule$3(pyq parampyq, ArrayList paramArrayList, oidb_cmd0x978.RspFollowOperationResult paramRspFollowOperationResult, pys parampys) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      pmk.a().b(((pwk)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long, ((pwk)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean);
      i += 1;
    }
    ThreadManager.post(new UserOperationModule.3.1(this), 5, null, true);
    ((pyt)this.jdField_a_of_type_Pys).a(true, this.jdField_a_of_type_JavaUtilArrayList, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.3
 * JD-Core Version:    0.7.0.1
 */
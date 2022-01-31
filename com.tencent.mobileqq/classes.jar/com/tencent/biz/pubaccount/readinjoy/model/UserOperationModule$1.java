package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import oxb;
import pff;
import phg;
import phh;
import phi;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspFollowOperationResult;

public class UserOperationModule$1
  implements Runnable
{
  public UserOperationModule$1(phg paramphg, ArrayList paramArrayList, oidb_cmd0x978.RspFollowOperationResult paramRspFollowOperationResult, phh paramphh) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      oxb.a().b(((pff)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long, ((pff)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean);
      i += 1;
    }
    ThreadManager.post(new UserOperationModule.1.1(this), 5, null, true);
    ((phi)this.jdField_a_of_type_Phh).a(true, this.jdField_a_of_type_JavaUtilArrayList, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.1
 * JD-Core Version:    0.7.0.1
 */
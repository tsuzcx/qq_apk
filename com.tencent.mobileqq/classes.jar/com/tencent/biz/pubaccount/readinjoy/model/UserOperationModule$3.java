package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import pvm;
import qey;
import qia;
import qic;
import qid;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspFollowOperationResult;

public class UserOperationModule$3
  implements Runnable
{
  public UserOperationModule$3(qia paramqia, ArrayList paramArrayList, oidb_cmd0x978.RspFollowOperationResult paramRspFollowOperationResult, qic paramqic) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      pvm.a().b(((qey)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long, ((qey)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean);
      i += 1;
    }
    ThreadManager.post(new UserOperationModule.3.1(this), 5, null, true);
    ((qid)this.jdField_a_of_type_Qic).a(true, this.jdField_a_of_type_JavaUtilArrayList, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.3
 * JD-Core Version:    0.7.0.1
 */
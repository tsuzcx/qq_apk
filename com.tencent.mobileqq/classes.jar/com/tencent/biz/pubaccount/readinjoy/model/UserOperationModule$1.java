package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import ohb;
import ooz;
import oqv;
import oqw;
import oqx;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspFollowOperationResult;

public class UserOperationModule$1
  implements Runnable
{
  public UserOperationModule$1(oqv paramoqv, ArrayList paramArrayList, oidb_cmd0x978.RspFollowOperationResult paramRspFollowOperationResult, oqw paramoqw) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ohb.a().b(((ooz)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long, ((ooz)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean);
      i += 1;
    }
    ThreadManager.post(new UserOperationModule.1.1(this), 5, null, true);
    ((oqx)this.jdField_a_of_type_Oqw).a(true, this.jdField_a_of_type_JavaUtilArrayList, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspFollowOperationResult;

class UserOperationModule$3
  implements Runnable
{
  UserOperationModule$3(UserOperationModule paramUserOperationModule, ArrayList paramArrayList, oidb_cmd0x978.RspFollowOperationResult paramRspFollowOperationResult, UserOperationModule.BaseOx978RespCallBack paramBaseOx978RespCallBack) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(((BatchFollowModel)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long, ((BatchFollowModel)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean);
      i += 1;
    }
    ThreadManager.post(new UserOperationModule.3.1(this), 5, null, true);
    ((UserOperationModule.BatchFollowCallBack)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelUserOperationModule$BaseOx978RespCallBack).a(true, this.jdField_a_of_type_JavaUtilArrayList, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.3
 * JD-Core Version:    0.7.0.1
 */
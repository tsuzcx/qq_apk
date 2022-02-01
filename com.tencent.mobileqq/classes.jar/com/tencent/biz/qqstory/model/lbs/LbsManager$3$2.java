package com.tencent.biz.qqstory.model.lbs;

import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;

class LbsManager$3$2
  implements Runnable
{
  LbsManager$3$2(LbsManager.3 param3, LbsManager.POIListRequestCallback paramPOIListRequestCallback, qqstory_service.RspGetPOIList paramRspGetPOIList, ArrayList paramArrayList) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestCallback.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetPOIList.result.error_code.get(), this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$3.a, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.3.2
 * JD-Core Version:    0.7.0.1
 */
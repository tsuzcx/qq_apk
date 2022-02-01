package com.tencent.biz.qqstory.model.lbs;

import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import wvc;
import wvf;

public class LbsManager$3$2
  implements Runnable
{
  public LbsManager$3$2(wvc paramwvc, wvf paramwvf, qqstory_service.RspGetPOIList paramRspGetPOIList, ArrayList paramArrayList) {}
  
  public void run()
  {
    this.jdField_a_of_type_Wvf.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspGetPOIList.result.error_code.get(), this.jdField_a_of_type_Wvc.a, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.3.2
 * JD-Core Version:    0.7.0.1
 */
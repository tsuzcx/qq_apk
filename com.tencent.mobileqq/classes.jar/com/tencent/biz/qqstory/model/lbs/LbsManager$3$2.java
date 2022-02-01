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
    this.a.a(this.b.result.error_code.get(), this.d.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.3.2
 * JD-Core Version:    0.7.0.1
 */
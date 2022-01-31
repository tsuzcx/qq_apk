package com.tencent.biz.videostory.network.observer;

import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import veg;
import xgr;
import xgt;
import xgw;

public class VSDispatchObserver$6
  implements Runnable
{
  public VSDispatchObserver$6(xgw paramxgw, VSBaseRequest paramVSBaseRequest, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getRequestKey();
      veg.b("VSNetworkHelper| Protocol Cache", this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCmdName() + " saveCache CacheKey:" + str);
      xgt.a().a(str, new ByteArrayInputStream(this.jdField_a_of_type_ArrayOfByte));
      veg.c("VSNetworkHelper| Protocol Cache", this.jdField_a_of_type_ComTencentBizVideostoryNetworkRequestVSBaseRequest.getCmdName() + " saveCache success");
      return;
    }
    catch (Exception localException)
    {
      QLog.w("VSNetworkHelper| Protocol Cache", 1, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.observer.VSDispatchObserver.6
 * JD-Core Version:    0.7.0.1
 */
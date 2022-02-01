package com.tencent.biz.richframework.network.observer;

import aaap;
import aaar;
import aaau;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import yuk;

public class VSDispatchObserver$6
  implements Runnable
{
  public VSDispatchObserver$6(aaau paramaaau, VSBaseRequest paramVSBaseRequest, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getRequestKey();
      yuk.b("VSNetworkHelper| Protocol Cache", this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCmdName() + " saveCache CacheKey:" + str);
      aaar.a().a(str, new ByteArrayInputStream(this.jdField_a_of_type_ArrayOfByte));
      yuk.c("VSNetworkHelper| Protocol Cache", this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCmdName() + " saveCache success");
      return;
    }
    catch (Exception localException)
    {
      QLog.w("VSNetworkHelper| Protocol Cache", 1, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.6
 * JD-Core Version:    0.7.0.1
 */
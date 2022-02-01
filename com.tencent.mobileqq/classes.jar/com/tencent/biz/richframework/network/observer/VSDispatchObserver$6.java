package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import yqp;
import zwu;
import zww;
import zwz;

public class VSDispatchObserver$6
  implements Runnable
{
  public VSDispatchObserver$6(zwz paramzwz, VSBaseRequest paramVSBaseRequest, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getRequestKey();
      yqp.b("VSNetworkHelper| Protocol Cache", this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCmdName() + " saveCache CacheKey:" + str);
      zww.a().a(str, new ByteArrayInputStream(this.jdField_a_of_type_ArrayOfByte));
      yqp.c("VSNetworkHelper| Protocol Cache", this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestVSBaseRequest.getCmdName() + " saveCache success");
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
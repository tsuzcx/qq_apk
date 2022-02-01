package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import ykq;

class VSDispatchObserver$6
  implements Runnable
{
  VSDispatchObserver$6(VSDispatchObserver paramVSDispatchObserver, VSBaseRequest paramVSBaseRequest, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      String str = this.val$request.getRequestKey();
      ykq.b("VSNetworkHelper| Protocol Cache", this.val$request.getCmdName() + " saveCache CacheKey:" + str);
      CacheHelper.fileCache().setStream(str, new ByteArrayInputStream(this.val$dataByteArray));
      ykq.c("VSNetworkHelper| Protocol Cache", this.val$request.getCmdName() + " saveCache success");
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
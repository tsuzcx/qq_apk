package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import java.io.ByteArrayInputStream;

class VSDispatchObserver$6
  implements Runnable
{
  VSDispatchObserver$6(VSDispatchObserver paramVSDispatchObserver, BaseRequest paramBaseRequest, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      String str = this.val$request.getRequestKey();
      RFLog.d("VSNetworkHelper| Protocol Cache", RFLog.USR, this.val$request.getCmdName() + " saveCache CacheKey:" + str);
      CacheHelper.fileCache().setStream(str, new ByteArrayInputStream(this.val$dataByteArray));
      RFLog.i("VSNetworkHelper| Protocol Cache", RFLog.USR, this.val$request.getCmdName() + " saveCache success");
      return;
    }
    catch (Exception localException)
    {
      RFLog.w("VSNetworkHelper| Protocol Cache", RFLog.USR, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.6
 * JD-Core Version:    0.7.0.1
 */
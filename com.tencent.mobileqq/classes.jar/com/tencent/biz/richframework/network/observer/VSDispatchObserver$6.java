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
      Object localObject = this.val$request.getRequestKey();
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.val$request.getCmdName());
      localStringBuilder.append(" saveCache CacheKey:");
      localStringBuilder.append((String)localObject);
      RFLog.d("VSNetworkHelper| Protocol Cache", i, localStringBuilder.toString());
      CacheHelper.fileCache().setStream((String)localObject, new ByteArrayInputStream(this.val$dataByteArray));
      i = RFLog.USR;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.val$request.getCmdName());
      ((StringBuilder)localObject).append(" saveCache success");
      RFLog.i("VSNetworkHelper| Protocol Cache", i, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      RFLog.w("VSNetworkHelper| Protocol Cache", RFLog.USR, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.6
 * JD-Core Version:    0.7.0.1
 */
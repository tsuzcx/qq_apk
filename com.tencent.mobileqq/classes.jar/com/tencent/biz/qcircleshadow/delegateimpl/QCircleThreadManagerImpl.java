package com.tencent.biz.qcircleshadow.delegateimpl;

import com.tencent.biz.richframework.delegate.IThreadManagerDelegate;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qroute.QRoute;

public class QCircleThreadManagerImpl
  implements IThreadManagerDelegate
{
  public void execute(Runnable paramRunnable, int paramInt)
  {
    ((IThreadManagerApi)QRoute.api(IThreadManagerApi.class)).execute(paramRunnable, paramInt, null, false);
  }
  
  public int getDBType()
  {
    return 32;
  }
  
  public int getFileType()
  {
    return 64;
  }
  
  public int getNetWorkType()
  {
    return 128;
  }
  
  public int getNormalType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.delegateimpl.QCircleThreadManagerImpl
 * JD-Core Version:    0.7.0.1
 */
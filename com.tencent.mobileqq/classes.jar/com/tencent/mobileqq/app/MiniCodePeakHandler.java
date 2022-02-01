package com.tencent.mobileqq.app;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class MiniCodePeakHandler
  extends BusinessHandler
{
  private static final Object a = new Object();
  
  protected MiniCodePeakHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(Context paramContext)
  {
    synchronized (a)
    {
      ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).init(paramContext, hashCode(), "MiniCodePeakHandler");
      return;
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("MiniCodePeakHandler", 2, "onDestroy");
    }
    synchronized (a)
    {
      ((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).unInit(hashCode(), "MiniCodePeakHandler");
      return;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MiniCodePeakHandler
 * JD-Core Version:    0.7.0.1
 */
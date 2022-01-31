package com.tencent.biz.videostory.network.observer;

import com.tencent.qphone.base.util.QLog;
import xgw;
import xgx;

public class VSDispatchObserver$5
  implements Runnable
{
  public VSDispatchObserver$5(xgw paramxgw, xgx paramxgx) {}
  
  public void run()
  {
    this.a.a(false, -1L, "FromMsg Parse Error", null);
    QLog.e("VSNetworkHelper", 1, "VSBaseRequest or FromServiceMsg is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.observer.VSDispatchObserver.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.armap;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class ArMapService
  extends MobileQQServiceBase
{
  ArMapInterface a;
  
  ArMapService(ArMapInterface paramArMapInterface)
  {
    this.a = paramArMapInterface;
  }
  
  public AppInterface a()
  {
    return this.a;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    super.b(paramToServiceMsg, null, ArMapServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapService
 * JD-Core Version:    0.7.0.1
 */
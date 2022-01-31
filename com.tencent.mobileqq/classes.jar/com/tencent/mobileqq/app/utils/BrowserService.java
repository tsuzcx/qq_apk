package com.tencent.mobileqq.app.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class BrowserService
  extends MobileQQServiceBase
{
  BrowserAppInterface a;
  
  public BrowserService(BrowserAppInterface paramBrowserAppInterface)
  {
    this.a = paramBrowserAppInterface;
  }
  
  public AppInterface a()
  {
    return this.a;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    super.b(paramToServiceMsg, null, WebSSOAgentServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.BrowserService
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import java.util.Map;
import mqq.app.MSFServlet;

public class BrowserService
  extends MobileQQServiceBase
{
  BrowserAppInterface a;
  
  public BrowserService(BrowserAppInterface paramBrowserAppInterface)
  {
    this.a = paramBrowserAppInterface;
  }
  
  public AppInterface getAppInterface()
  {
    return this.a;
  }
  
  protected Map<String, String[]> getCompatibleCmd2HandlerMap()
  {
    return Cmd2HandlerMap.a();
  }
  
  protected Class<? extends MSFServlet> getServlet()
  {
    return WebSSOAgentServlet.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.BrowserService
 * JD-Core Version:    0.7.0.1
 */
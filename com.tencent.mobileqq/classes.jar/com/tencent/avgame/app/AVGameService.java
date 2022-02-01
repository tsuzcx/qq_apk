package com.tencent.avgame.app;

import com.tencent.avgame.protocol.AVGameProtocolCoder;
import com.tencent.avgame.util.AVGameCmdUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;

public class AVGameService
  extends MobileQQServiceBase
{
  private BaseAVGameAppInterface a;
  private AVGameProtocolCoder b;
  
  AVGameService(BaseAVGameAppInterface paramBaseAVGameAppInterface)
  {
    this.a = paramBaseAVGameAppInterface;
    seq = Math.abs(new Random().nextInt());
  }
  
  public AppInterface getAppInterface()
  {
    return this.a;
  }
  
  protected Map<String, String[]> getCompatibleCmd2HandlerMap()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    AVGameCmdUtil.a(localConcurrentHashMap);
    return localConcurrentHashMap;
  }
  
  protected Class<? extends MSFServlet> getServlet()
  {
    return AVGameServlet.class;
  }
  
  protected void initCoders()
  {
    try
    {
      this.b = new AVGameProtocolCoder();
      super.addCoder(this.b);
      super.setCodersInit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.app.AVGameService
 * JD-Core Version:    0.7.0.1
 */
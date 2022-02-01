package com.tencent.avgame.app;

import com.tencent.avgame.protocol.AVGameProtocolCoder;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import java.util.Map;
import java.util.Random;
import mqq.app.MSFServlet;

public class AVGameService
  extends MobileQQServiceBase
{
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private AVGameProtocolCoder jdField_a_of_type_ComTencentAvgameProtocolAVGameProtocolCoder;
  
  AVGameService(AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    seq = Math.abs(new Random().nextInt());
  }
  
  public AppInterface getAppInterface()
  {
    return this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  }
  
  public Map<String, String[]> getCompatibleCmd2HandlerMap()
  {
    return Cmd2HandlerMap.a();
  }
  
  public Class<? extends MSFServlet> getServlet()
  {
    return AVGameServlet.class;
  }
  
  public void initCoders()
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvgameProtocolAVGameProtocolCoder = new AVGameProtocolCoder();
      super.addCoder(this.jdField_a_of_type_ComTencentAvgameProtocolAVGameProtocolCoder);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.app.AVGameService
 * JD-Core Version:    0.7.0.1
 */
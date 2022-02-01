package com.tencent.aelight.camera.aebase;

import com.tencent.aelight.camera.ae.config.CameraPeakDataService;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.service.PeakJceServiceBase;
import com.tencent.mobileqq.servlet.AudioTransServlet;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class PeakJceService
  extends PeakJceServiceBase
{
  PeakAppInterface a;
  
  public PeakJceService(PeakAppInterface paramPeakAppInterface)
  {
    this.a = paramPeakAppInterface;
  }
  
  public AppInterface a()
  {
    return this.a;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg, AudioTransServlet.class);
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    super.a(paramBoolean, paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  protected void b()
  {
    try
    {
      super.b();
      a(new CameraPeakDataService());
      super.c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.PeakJceService
 * JD-Core Version:    0.7.0.1
 */
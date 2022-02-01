package com.tencent.av;

import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;

public class AVNetEngine
{
  private static IHttpEngineService a;
  
  public static IHttpEngineService a()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          HttpCommunicator localHttpCommunicator = new HttpCommunicator(128);
          localHttpCommunicator.start();
          a = new HttpEngineServiceImpl(localHttpCommunicator, true);
        }
      }
      finally {}
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.AVNetEngine
 * JD-Core Version:    0.7.0.1
 */
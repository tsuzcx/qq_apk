package com.tencent.av.business.handler;

import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.MsfServletProxy;
import com.tencent.av.redpacket.AVRedPacketHandler;
import com.tencent.mobileqq.app.BusinessHandler;

public class BusinessHandlerFactory
{
  private BusinessHandler[] a = new BusinessHandler[4];
  
  private BusinessHandler b(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    }
    for (paramVideoAppInterface = localObject;; paramVideoAppInterface = new AVC2CDataHandler(paramVideoAppInterface))
    {
      AVLog.c("BusinessHandlerFactory", "createHandler unknown name");
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        AVLog.c("BusinessHandlerFactory", "createHandler,cost time:" + (l2 - l1));
        return paramVideoAppInterface;
        paramVideoAppInterface = new AudioTransClientInterfaceHandlerExtend(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new AudioTransClientInfoHandlerExtend(paramVideoAppInterface);
        continue;
        paramVideoAppInterface = new AVRedPacketHandler(paramVideoAppInterface);
      }
    }
  }
  
  public BusinessHandler a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    Object localObject = this.a[paramInt];
    if (localObject != null) {
      return localObject;
    }
    synchronized (this.a)
    {
      BusinessHandler localBusinessHandler = this.a[paramInt];
      localObject = localBusinessHandler;
      if (localBusinessHandler == null)
      {
        paramVideoAppInterface = b(paramVideoAppInterface, paramInt);
        localObject = paramVideoAppInterface;
        if (paramVideoAppInterface != null)
        {
          this.a[paramInt] = paramVideoAppInterface;
          localObject = paramVideoAppInterface;
        }
      }
      return localObject;
    }
  }
  
  public void a(MsfServletProxy paramMsfServletProxy)
  {
    paramMsfServletProxy.a("TransInfoCreate.CreateSession", new int[] { 1 });
    paramMsfServletProxy.a("TransInfo.JoinSession", new int[] { 0 });
    paramMsfServletProxy.a("TransInfo.ExitSession", new int[] { 0 });
    paramMsfServletProxy.a("TransInfo.ChangeSession", new int[] { 0 });
    paramMsfServletProxy.a("TransInfo.RawData", new int[] { 0 });
    paramMsfServletProxy.a("OidbSvc.0xa75", new int[] { 2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.handler.BusinessHandlerFactory
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.auto.engine.enter;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.auto.engine.enter.impl.IASEnter;
import com.tencent.mobileqq.auto.engine.enter.impl.flashshow.FSPluginEngineEnter;
import com.tencent.mobileqq.auto.engine.enter.impl.qcircle.QCirclePluginEngineEnter;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import java.util.concurrent.ConcurrentHashMap;

public class ASEngineEnter
{
  private static final Handler a;
  private static final ConcurrentHashMap<String, IASEnter> b = new ConcurrentHashMap();
  
  static
  {
    HandlerThread localHandlerThread = new HandlerThread("ASPluginEnter");
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(ASEnterBean paramASEnterBean)
  {
    a.post(new ASEngineEnter.1(paramASEnterBean));
  }
  
  private static IASEnter c(ASEnterBean paramASEnterBean)
  {
    String str = paramASEnterBean.getBusinessKey();
    int i = str.hashCode();
    if (i != -1538620274)
    {
      if ((i == 1990896341) && (str.equals("qcircle-app")))
      {
        i = 1;
        break label55;
      }
    }
    else if (str.equals("flash-show-app"))
    {
      i = 0;
      break label55;
    }
    i = -1;
    label55:
    if (i != 0)
    {
      if (i != 1) {
        return new ASEngineEnter.2();
      }
      return new QCirclePluginEngineEnter(ASDynamicEngineFactory.a(paramASEnterBean.getBusinessKey()).b());
    }
    return new FSPluginEngineEnter(ASDynamicEngineFactory.a(paramASEnterBean.getBusinessKey()).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.enter.ASEngineEnter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.auto.engine.main;

import android.text.TextUtils;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.auto.engine.main.impl.fs.FSAutoNativeMainFrame;
import com.tencent.mobileqq.auto.engine.main.impl.fs.FSAutoPluginMainFrame;
import com.tencent.mobileqq.auto.engine.main.impl.qcircle.QCirclePluginMainFrame;

public class ASFrameFactory
{
  private static IASBaseFrame a(ASPluginBean paramASPluginBean)
  {
    return new QCirclePluginMainFrame();
  }
  
  public static IASBaseFrame a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ASPluginBean localASPluginBean = ASDynamicEngineFactory.a(paramString).b();
    int i = -1;
    int j = paramString.hashCode();
    if (j != -1538620274)
    {
      if ((j == 1990896341) && (paramString.equals("qcircle-app"))) {
        i = 1;
      }
    }
    else if (paramString.equals("flash-show-app")) {
      i = 0;
    }
    if (i != 0)
    {
      if (i != 1) {
        return new IASBaseFrame();
      }
      return a(localASPluginBean);
    }
    return b(localASPluginBean);
  }
  
  private static IASBaseFrame b(ASPluginBean paramASPluginBean)
  {
    if ("TYPE_NATIVE".equals(paramASPluginBean.getType())) {
      return new FSAutoNativeMainFrame();
    }
    return new FSAutoPluginMainFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.main.ASFrameFactory
 * JD-Core Version:    0.7.0.1
 */
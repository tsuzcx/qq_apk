package com.tencent.mobileqq.auto.engine.lib.delegateimpl;

import com.tencent.mobileqq.auto.engine.enter.ASEngineEnter;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import java.util.HashMap;

public class ASEngineImpl
  implements IASEngineDelegate
{
  public boolean enter(String paramString1, String paramString2, HashMap<String, String> paramHashMap, HashMap<String, byte[]> paramHashMap1)
  {
    ASEngineEnter.a(new ASEnterBean(paramString1).setSchemeAction(paramString2).setAttrs(paramHashMap).setByteAttrs(paramHashMap1));
    return true;
  }
  
  public String getPluginVerSion(String paramString)
  {
    return String.valueOf(ASDynamicEngineFactory.a(paramString).b().getVersionCode());
  }
  
  public boolean isOnThirdTab(String paramString)
  {
    return ASDynamicEngineFactory.a(paramString).c();
  }
  
  public boolean setForceNative(String paramString, boolean paramBoolean)
  {
    return ASDynamicEngineFactory.a(paramString).b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.lib.delegateimpl.ASEngineImpl
 * JD-Core Version:    0.7.0.1
 */
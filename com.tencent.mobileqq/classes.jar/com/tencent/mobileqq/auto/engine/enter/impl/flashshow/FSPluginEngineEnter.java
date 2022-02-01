package com.tencent.mobileqq.auto.engine.enter.impl.flashshow;

import com.tencent.mobileqq.auto.engine.enter.ASBaseEnter;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.flashshow.api.IFlashShowServiceApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FSPluginEngineEnter
  extends ASBaseEnter
{
  public FSPluginEngineEnter(ASPluginBean paramASPluginBean)
  {
    super(paramASPluginBean);
  }
  
  protected String a(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mqqapi://qflash/");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("?");
    paramString = new StringBuilder(((StringBuilder)localObject).toString());
    if (paramHashMap != null)
    {
      localObject = paramHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = (String)paramHashMap.get(str1);
        paramString.append(str1);
        paramString.append("=");
        paramString.append(str2);
        paramString.append("&");
      }
    }
    return paramString.toString();
  }
  
  protected String b()
  {
    return "com.tencent.biz.qcircleshadow.local.fragment.flashshow.FSPluginLoadingFragment";
  }
  
  public void b(ASEnterBean paramASEnterBean)
  {
    if (paramASEnterBean == null) {
      return;
    }
    ((IFlashShowServiceApi)QRoute.api(IFlashShowServiceApi.class)).enterBySchemeAction(BaseApplication.getContext(), paramASEnterBean.getSchemeAction(), paramASEnterBean.getAttrs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.enter.impl.flashshow.FSPluginEngineEnter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.auto.engine.enter.impl.qcircle;

import android.os.Bundle;
import com.tencent.mobileqq.auto.engine.enter.ASBaseEnter;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class QCirclePluginEngineEnter
  extends ASBaseEnter
{
  public QCirclePluginEngineEnter(ASPluginBean paramASPluginBean)
  {
    super(paramASPluginBean);
  }
  
  protected String a(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mqqapi://qcircle/");
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
  
  public void a(ASEnterBean paramASEnterBean)
  {
    QCircleReportFirstLogin.recordFirstLoginSource(paramASEnterBean.getAttrs());
    super.a(paramASEnterBean);
  }
  
  protected String b()
  {
    return "com.tencent.biz.qcircleshadow.local.fragment.qcircle.QCirclePluginLoadingFragment";
  }
  
  public void b(ASEnterBean paramASEnterBean)
  {
    if (paramASEnterBean != null)
    {
      if (paramASEnterBean.getAttrs() == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("data", paramASEnterBean);
      ((IQCircleNativeFrameApi)QRoute.api(IQCircleNativeFrameApi.class)).enterNativePage(localBundle);
      QCircleReportFirstLogin.recordFirstLoginSource(paramASEnterBean.getAttrs());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.enter.impl.qcircle.QCirclePluginEngineEnter
 * JD-Core Version:    0.7.0.1
 */
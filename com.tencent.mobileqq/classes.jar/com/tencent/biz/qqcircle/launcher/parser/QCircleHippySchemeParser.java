package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.mobileqq.qcircle.api.data.QCircleHippyBean;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.net.URLDecoder;
import java.util.HashMap;

public class QCircleHippySchemeParser
  extends QCircleBaseSchemeParser
{
  private void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    Object localObject1 = paramContext;
    if (paramContext == null) {
      localObject1 = QCircleApplication.APP;
    }
    if ((paramHashMap != null) && (paramHashMap.containsKey("module"))) {
      try
      {
        paramContext = (String)paramHashMap.get("module");
        localObject2 = URLDecoder.decode((String)paramHashMap.get("url"));
        QCircleLauncher.a((Context)localObject1, new QCircleHippyBean().setModuleName(paramContext).setDefaultUrl((String)localObject2));
        return;
      }
      catch (Exception paramContext)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parseUrl:");
        ((StringBuilder)localObject2).append((String)paramHashMap.get("url"));
        ((StringBuilder)localObject2).append(" error:");
        ((StringBuilder)localObject2).append(paramContext.getMessage());
        QLog.e("QCircleBaseSchemeParser", 1, ((StringBuilder)localObject2).toString());
        paramContext.printStackTrace();
        paramContext = new QCircleSchemeBean();
        paramContext.setAttrs(paramHashMap);
        paramContext.setSchemeAction("openwebview");
        QCircleSchemeLauncher.b((Context)localObject1, paramContext);
        return;
      }
    }
    QLog.e("QCircleBaseSchemeParser", 1, "launchHippyPageByScheme error no module name!");
    paramContext = new QCircleSchemeBean();
    paramContext.setAttrs(paramHashMap);
    paramContext.setSchemeAction("openwebview");
    QCircleSchemeLauncher.b((Context)localObject1, paramContext);
  }
  
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    a(paramContext, paramQCircleSchemeBean.getAttrs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCircleHippySchemeParser
 * JD-Core Version:    0.7.0.1
 */
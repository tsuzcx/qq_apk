package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.HashMap;

public class QCirclePersonDetailSchemeParser
  extends QCircleBaseSchemeParser
{
  private boolean a(HashMap<String, String> paramHashMap, String paramString)
  {
    return (paramHashMap != null) && ("rank".equals(paramHashMap.get("frompage"))) && (QCirclePluginConfig.a().y() == 0) && (QCirclePluginUtil.d(paramString));
  }
  
  private void b(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    if (paramQCircleSchemeBean != null)
    {
      if (paramQCircleSchemeBean.getAttrs() == null) {
        return;
      }
      HashMap localHashMap = paramQCircleSchemeBean.getAttrs();
      QCircleInitBean localQCircleInitBean = new QCircleInitBean();
      a(paramQCircleSchemeBean, localQCircleInitBean);
      a(localQCircleInitBean, localHashMap);
      b(localQCircleInitBean, localHashMap);
      if (!localHashMap.containsKey("uin")) {
        return;
      }
      String str = (String)localHashMap.get("uin");
      if (a(localHashMap, str)) {
        QCirclePluginConfig.a().b(1);
      }
      paramQCircleSchemeBean = str;
      if (TextUtils.isEmpty(str)) {
        paramQCircleSchemeBean = HostDataTransUtils.getAccount();
      }
      localQCircleInitBean.setUin(paramQCircleSchemeBean);
      QCircleLauncher.b(paramContext, localQCircleInitBean);
    }
  }
  
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    b(paramContext, paramQCircleSchemeBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCirclePersonDetailSchemeParser
 * JD-Core Version:    0.7.0.1
 */
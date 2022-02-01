package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterLauncher;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.HashMap;

public class QCircleMessageBoxSchemeParser
  extends QCircleBaseSchemeParser
{
  private void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext != null)
    {
      if (paramHashMap == null) {
        return;
      }
      if (QCircleFlutterUtils.b())
      {
        QCircleFlutterLauncher.a(paramContext, paramHashMap, QCirclePluginUtil.a(paramContext));
        return;
      }
      QLog.e("QCircleBaseSchemeParser", 1, " flutter is not enable to launch message box page");
    }
  }
  
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    a(paramContext, paramQCircleSchemeBean.getAttrs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCircleMessageBoxSchemeParser
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterLauncher;
import com.tencent.biz.qqcircle.flutter.QCircleFlutterUtils;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.net.URLEncoder;
import java.util.HashMap;

public class QCircleSearchSchemeParser
  extends QCircleBaseSchemeParser
{
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    a(paramContext, paramQCircleSchemeBean.getAttrs());
  }
  
  public void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    String str;
    if ((paramHashMap != null) && (paramHashMap.containsKey("backbehavior"))) {
      str = (String)paramHashMap.get("backbehavior");
    } else {
      str = "1";
    }
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    a(localQCircleInitBean, paramHashMap);
    if (QCircleFlutterUtils.b())
    {
      QCircleFlutterLauncher.a(paramContext, paramHashMap, str, localQCircleInitBean);
      return;
    }
    if ((paramHashMap != null) && (paramHashMap.size() != 0) && (paramHashMap.containsKey("search_text")))
    {
      paramHashMap = (String)paramHashMap.get("search_text");
      if (TextUtils.isEmpty(paramHashMap))
      {
        QCircleLauncher.a(paramContext, QCircleJsUrlConfig.a, null, -1);
        return;
      }
      QCircleLauncher.a(paramContext, "https://h5.qzone.qq.com/v2/wezone/search?_wwv=8192&_wv=3&_proxy=1&show_right_cancel=1&move_web_view_top=1&search_text={search_text}&search_type=6".replace("{search_text}", URLEncoder.encode(paramHashMap)), null, -1);
      return;
    }
    QCircleLauncher.a(paramContext, QCircleJsUrlConfig.a, null, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCircleSearchSchemeParser
 * JD-Core Version:    0.7.0.1
 */
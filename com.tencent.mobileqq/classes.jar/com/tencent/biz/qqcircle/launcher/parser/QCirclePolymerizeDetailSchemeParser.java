package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.utils.QCircleABTestUtils;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.util.HashMap;

public class QCirclePolymerizeDetailSchemeParser
  extends QCircleBaseSchemeParser
{
  private void a(HashMap<String, String> paramHashMap, QCirclePolymerizeDetailBean paramQCirclePolymerizeDetailBean)
  {
    String str1 = (String)paramHashMap.get("transdata");
    String str2 = (String)paramHashMap.get("sourcetype");
    int k = 0;
    int i;
    if (str2 != null) {
      try
      {
        i = Integer.parseInt(str2);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      i = 0;
    }
    paramHashMap = (String)paramHashMap.get("pageid");
    int j = k;
    if (paramHashMap != null) {
      try
      {
        j = Integer.parseInt(paramHashMap);
      }
      catch (Exception paramHashMap)
      {
        paramHashMap.printStackTrace();
        j = k;
      }
    }
    paramQCirclePolymerizeDetailBean.setTransData(str1);
    paramQCirclePolymerizeDetailBean.setSourceType(i);
    paramQCirclePolymerizeDetailBean.setPageId(j);
  }
  
  private boolean a(QCirclePolymerizeDetailBean paramQCirclePolymerizeDetailBean)
  {
    int i = paramQCirclePolymerizeDetailBean.getPageId();
    return ((i == 69) || (i == 83) || (i == 85)) && (paramQCirclePolymerizeDetailBean.isNeedShowGoHomeButton());
  }
  
  private void b(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    if ((paramContext != null) && (paramQCircleSchemeBean != null))
    {
      if (paramQCircleSchemeBean.getAttrs() == null) {
        return;
      }
      QCirclePolymerizeDetailBean localQCirclePolymerizeDetailBean = new QCirclePolymerizeDetailBean();
      a(paramQCircleSchemeBean, localQCirclePolymerizeDetailBean);
      a(localQCirclePolymerizeDetailBean, paramQCircleSchemeBean.getAttrs());
      a(paramQCircleSchemeBean.getAttrs(), localQCirclePolymerizeDetailBean);
      if (a(localQCirclePolymerizeDetailBean))
      {
        if (QCircleABTestUtils.a("exp_wezone_externalpage_newrecommendationmodule1")) {
          QCircleLauncher.b(paramContext, localQCirclePolymerizeDetailBean);
        } else {
          QCircleLauncher.a(paramContext, localQCirclePolymerizeDetailBean);
        }
        if (localQCirclePolymerizeDetailBean.getPageId() != 69) {
          QCircleABTestUtils.b("exp_wezone_externalpage_newrecommendationmodule1");
        }
      }
      else
      {
        QCircleLauncher.a(paramContext, localQCirclePolymerizeDetailBean);
      }
    }
  }
  
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    b(paramContext, paramQCircleSchemeBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCirclePolymerizeDetailSchemeParser
 * JD-Core Version:    0.7.0.1
 */
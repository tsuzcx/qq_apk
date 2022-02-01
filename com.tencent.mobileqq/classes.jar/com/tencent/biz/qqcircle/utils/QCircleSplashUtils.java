package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;

public class QCircleSplashUtils
{
  public static boolean a()
  {
    return (QCircleConfigHelper.aA()) && (QCirclePluginGlobalInfo.k());
  }
  
  public static boolean a(QCircleInitBean paramQCircleInitBean)
  {
    boolean bool2 = false;
    if (paramQCircleInitBean == null) {
      return false;
    }
    if ((paramQCircleInitBean.getOpenPymk()) && (!QCircleABTestUtils.a("exp_wezone_reflow_entry_page1"))) {
      return true;
    }
    boolean bool1 = bool2;
    if (paramQCircleInitBean.isEnableSplash())
    {
      bool1 = bool2;
      if (QCirclePluginConfig.a().g()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleSplashUtils
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import cooperation.qqcircle.beans.QCircleSchemeBean;

public class QCirclePrivateSettingSchemeParser
  extends QCircleBaseSchemeParser
{
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    QCircleSettingBean localQCircleSettingBean = new QCircleSettingBean();
    a(paramQCircleSchemeBean, localQCircleSettingBean);
    QCircleLauncher.b(paramContext, localQCircleSettingBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCirclePrivateSettingSchemeParser
 * JD-Core Version:    0.7.0.1
 */
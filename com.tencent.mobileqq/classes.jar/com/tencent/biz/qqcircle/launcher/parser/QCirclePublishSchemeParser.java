package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import cooperation.qqcircle.beans.QCircleSchemeBean;

public class QCirclePublishSchemeParser
  extends QCircleBaseSchemeParser
{
  private void b(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    QCircleFolderBean localQCircleFolderBean = new QCircleFolderBean();
    a(paramQCircleSchemeBean, localQCircleFolderBean);
    localQCircleFolderBean.setPublish(true);
    localQCircleFolderBean.setLaunchFrom("8");
    QCircleLauncher.a(paramContext, localQCircleFolderBean);
  }
  
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    b(paramContext, paramQCircleSchemeBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCirclePublishSchemeParser
 * JD-Core Version:    0.7.0.1
 */
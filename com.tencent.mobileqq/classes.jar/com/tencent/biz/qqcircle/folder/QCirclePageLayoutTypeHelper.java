package com.tencent.biz.qqcircle.folder;

import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;

public class QCirclePageLayoutTypeHelper
{
  private static volatile QCirclePageLayoutTypeHelper a;
  private int b;
  
  public static QCirclePageLayoutTypeHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCirclePageLayoutTypeHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void d()
  {
    this.b = 0;
    QLog.i("QCirclePageLayoutTypeHelper", 1, "resetAllPushPageLayoutType  mAllPushPageLayoutType = 0");
  }
  
  public int b()
  {
    if (this.b == 0)
    {
      QLog.i("QCirclePageLayoutTypeHelper", 1, "getAllPushPageLayoutType  mAllPushPageLayoutType = 0 , need read wns");
      this.b = QCircleConfigHelper.aJ();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAllPushPageLayoutType  mAllPushPageLayoutType = ");
    localStringBuilder.append(this.b);
    QLog.i("QCirclePageLayoutTypeHelper", 1, localStringBuilder.toString());
    return this.b;
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkResetAllPushPageLayoutType  mAllPushPageLayoutType = ");
    localStringBuilder.append(this.b);
    QLog.i("QCirclePageLayoutTypeHelper", 1, localStringBuilder.toString());
    if (QCircleFolderCacheHelper.a().f())
    {
      d();
      QCircleFolderCacheHelper.a().g();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkResetAllPushPageLayoutType , reset and disableCache,  mAllPushPageLayoutType = ");
      localStringBuilder.append(this.b);
      QLog.i("QCirclePageLayoutTypeHelper", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.folder.QCirclePageLayoutTypeHelper
 * JD-Core Version:    0.7.0.1
 */
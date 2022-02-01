package com.tencent.biz.qqcircle.richframework.compat;

import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

class QCircleBaseActivity$SkinDownloadListener$1
  implements Runnable
{
  QCircleBaseActivity$SkinDownloadListener$1(QCircleBaseActivity.SkinDownloadListener paramSkinDownloadListener, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start update theme skinPath = ");
    localStringBuilder.append(this.a);
    QLog.d("ComponentBaseActivity", 1, localStringBuilder.toString());
    QCircleSkinHelper.getInstance().loadSkin(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.compat.QCircleBaseActivity.SkinDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */
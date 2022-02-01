package com.tencent.mobileqq.activity.recent;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.qboss.QbossReportManager;

class QbossADBannerManager$1
  implements URLDrawable.URLDrawableListener
{
  QbossADBannerManager$1(QbossADBannerManager paramQbossADBannerManager, QbossADBannerConfigInfo paramQbossADBannerConfigInfo, QbossADBannerConfigInfo.ResourceInfo paramResourceInfo) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.i("QbossADBannerManager", 1, "showQbossADBanner urlDrawable load failed.");
    paramURLDrawable = null;
    if (paramThrowable != null) {
      paramURLDrawable = paramThrowable.getMessage();
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo != null) {
        QbossReportManager.getInstance().sendErrorReport(2741, this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo.c, 100, "qboss load local photo fail throwable = " + paramURLDrawable + " url = " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo$ResourceInfo.a + " filePath = " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo$ResourceInfo.c);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.e();
      return;
    }
    catch (Exception paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.e("QbossADBannerManager", 1, "onLoadFailed Exception");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.i("QbossADBannerManager", 1, "showQbossADBanner urlDrawable load success");
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramURLDrawable != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.jdField_a_of_type_AndroidViewView.setVisibility(0);
        QbossADBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager, this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo);
        SetSplash.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.jdField_a_of_type_AndroidViewView);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.jdField_a_of_type_AndroidViewView != null)
      {
        QLog.w("QbossADBannerManager", 1, "showQbossADBanner and Animation failed, mUrlImageView :" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.jdField_a_of_type_ComTencentImageURLImageView + "urlDrawable :" + paramURLDrawable);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
    }
    catch (Exception paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.e("QbossADBannerManager", 1, "onLoadSuccessed Exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.QbossADBannerManager.1
 * JD-Core Version:    0.7.0.1
 */
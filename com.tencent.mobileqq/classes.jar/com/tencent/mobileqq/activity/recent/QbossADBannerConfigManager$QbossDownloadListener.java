package com.tencent.mobileqq.activity.recent;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.qboss.QbossReportManager;
import java.lang.ref.WeakReference;

class QbossADBannerConfigManager$QbossDownloadListener
  implements Downloader.DownloadListener
{
  private volatile int jdField_a_of_type_Int;
  private QbossADBannerConfigInfo jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile int b;
  private int c;
  
  public QbossADBannerConfigManager$QbossDownloadListener(QbossADBannerConfigManager paramQbossADBannerConfigManager, QQAppInterface paramQQAppInterface, QbossADBannerConfigInfo paramQbossADBannerConfigInfo, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo = paramQbossADBannerConfigInfo;
    this.c = paramInt;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
  
  public void onDownloadCanceled(String paramString) {}
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbossADBannerConfigManager", 2, "diy data download fail url = " + paramString);
    }
    this.b += 1;
    QbossADBannerConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigManager, this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo, paramString, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo != null) {
      QbossReportManager.getInstance().sendErrorReport(2741, this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo.c, 101, "qboss download resources fail mErrCode = " + paramDownloadResult.getStatus().httpStatus + " resUrl = " + paramString);
    }
    QLog.e("QbossADBannerConfigManager", 1, "onDownloadFailed mLoadSuccessTimes = " + this.jdField_a_of_type_Int + " mDownTotalSize = " + this.c);
    paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.b + this.jdField_a_of_type_Int == this.c) {
      QbossADBannerConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigManager, paramString);
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbossADBannerConfigManager", 2, "banner resources download success url = " + paramString);
    }
    this.jdField_a_of_type_Int += 1;
    QbossADBannerConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigManager, this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigInfo, paramString, true);
    paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    QLog.e("QbossADBannerConfigManager", 1, "onDownloadSucceed mLoadSuccessTimes = " + this.jdField_a_of_type_Int + " mDownTotalSize = " + this.c);
    if (this.jdField_a_of_type_Int == this.c) {
      QbossADBannerConfigManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerConfigManager, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.QbossADBannerConfigManager.QbossDownloadListener
 * JD-Core Version:    0.7.0.1
 */
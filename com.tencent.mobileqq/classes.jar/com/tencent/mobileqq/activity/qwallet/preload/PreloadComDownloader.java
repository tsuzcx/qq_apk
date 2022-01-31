package com.tencent.mobileqq.activity.qwallet.preload;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import xfi;
import xfj;
import xfk;

public class PreloadComDownloader
{
  private static volatile PreloadComDownloader jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadComDownloader;
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
  
  private PreloadComDownloader()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(null);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1);
    }
  }
  
  public static PreloadComDownloader a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadComDownloader == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadComDownloader == null) {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadComDownloader = new PreloadComDownloader();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadComDownloader;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2, Bundle paramBundle, DownloadListener paramDownloadListener)
  {
    ThreadManager.post(new xfk(this, paramString1, paramString2, paramDownloadListener, paramBundle), 8, null, true);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (localQQAppInterface == null);
    paramBundle = new xfj(this, localQQAppInterface, paramString1, paramString1, paramString2, paramBundle, new xfi(this, paramDownloadListener));
    ((PreDownloadController)localQQAppInterface.getManager(192)).a(10069, "qqpay", paramString1, 0, paramString1, paramString2, 2, 0, true, paramBundle);
    return;
    a(paramString1, paramString2, paramBundle, paramDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadComDownloader
 * JD-Core Version:    0.7.0.1
 */
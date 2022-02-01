package com.tencent.av.gameplay;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class QavGPDownloadManager
{
  private static volatile QavGPDownloadManager jdField_a_of_type_ComTencentAvGameplayQavGPDownloadManager;
  QavGPDownloadObserver jdField_a_of_type_ComTencentAvGameplayQavGPDownloadObserver = null;
  QavGPDownloader jdField_a_of_type_ComTencentAvGameplayQavGPDownloader = null;
  
  public static QavGPDownloadManager a()
  {
    if (jdField_a_of_type_ComTencentAvGameplayQavGPDownloadManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvGameplayQavGPDownloadManager == null)
      {
        QavGPDownloadManager localQavGPDownloadManager = new QavGPDownloadManager();
        localQavGPDownloadManager.b();
        jdField_a_of_type_ComTencentAvGameplayQavGPDownloadManager = localQavGPDownloadManager;
      }
      return jdField_a_of_type_ComTencentAvGameplayQavGPDownloadManager;
    }
    finally {}
  }
  
  public static void a()
  {
    QavGPDownloadManager localQavGPDownloadManager = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("onDownloadRequest, mStatusGameplay[%s]", new Object[] { Integer.valueOf(localQavGPDownloadManager.jdField_a_of_type_ComTencentAvGameplayQavGPDownloadObserver.a) }));
    }
    QavGPDownloader.a();
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_ComTencentAvGameplayQavGPDownloadManager != null;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloadObserver = new QavGPDownloadObserver();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloader = new QavGPDownloader();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloadObserver.a();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentAvGameplayQavGPDownloadObserver.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gameplay.QavGPDownloadManager
 * JD-Core Version:    0.7.0.1
 */
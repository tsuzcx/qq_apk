package com.tencent.mobileqq.activity.specialcare;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class QvipSpecialSoundManager$SyncDownloadRunnable
  implements Runnable
{
  public int a;
  private DownloadTask jdField_a_of_type_ComTencentMobileqqVipDownloadTask;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QvipSpecialSoundManager> jdField_a_of_type_MqqUtilWeakReference;
  
  public QvipSpecialSoundManager$SyncDownloadRunnable(DownloadTask paramDownloadTask, File paramFile, String paramString, QvipSpecialSoundManager paramQvipSpecialSoundManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask = paramDownloadTask;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQvipSpecialSoundManager);
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Int = DownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask, localQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("QvipSpecialSoundManager", 2, "[SyncDownloadRunnable]:resultCode=" + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      QvipSpecialSoundManager.a((QvipSpecialSoundManager)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.SyncDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */
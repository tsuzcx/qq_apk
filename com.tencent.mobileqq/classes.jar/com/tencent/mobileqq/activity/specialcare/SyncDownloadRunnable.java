package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class SyncDownloadRunnable
  implements Runnable
{
  public int a;
  private DownloadTask jdField_a_of_type_ComTencentMobileqqVipDownloadTask;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<IQvipSpecialSoundManager> jdField_a_of_type_MqqUtilWeakReference;
  
  public SyncDownloadRunnable(DownloadTask paramDownloadTask, File paramFile, String paramString, IQvipSpecialSoundManager paramIQvipSpecialSoundManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask = paramDownloadTask;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramIQvipSpecialSoundManager);
  }
  
  public void run()
  {
    this.jdField_a_of_type_Int = ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).specialSoundDownload(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[SyncDownloadRunnable]:resultCode=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("SyncDownloadRunnable", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      ((IQvipSpecialSoundManager)this.jdField_a_of_type_MqqUtilWeakReference.get()).onSpecialSoundConfigDownloaded(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SyncDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */
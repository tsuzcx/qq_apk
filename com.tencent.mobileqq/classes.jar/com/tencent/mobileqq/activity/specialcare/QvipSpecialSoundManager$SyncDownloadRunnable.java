package com.tencent.mobileqq.activity.specialcare;

import bdvv;
import bdvx;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QvipSpecialSoundManager$SyncDownloadRunnable
  implements Runnable
{
  public int a;
  private bdvv jdField_a_of_type_Bdvv;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  
  public QvipSpecialSoundManager$SyncDownloadRunnable(QvipSpecialSoundManager paramQvipSpecialSoundManager, bdvv parambdvv, AppInterface paramAppInterface, File paramFile, String paramString)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bdvv = parambdvv;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Int = bdvx.a(this.jdField_a_of_type_Bdvv, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("QvipSpecialSoundManager", 2, "[SyncDownloadRunnable]:resultCode=" + this.jdField_a_of_type_Int);
    }
    QvipSpecialSoundManager.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.SyncDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */
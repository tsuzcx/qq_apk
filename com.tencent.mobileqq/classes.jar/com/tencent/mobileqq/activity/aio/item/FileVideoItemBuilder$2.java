package com.tencent.mobileqq.activity.aio.item;

import adps;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import aoza;
import apuw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class FileVideoItemBuilder$2
  implements Runnable
{
  public FileVideoItemBuilder$2(adps paramadps, FileManagerEntity paramFileManagerEntity, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight > 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth > 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]download video thumb success， but entity has size(wh)[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth + ":" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight + "]");
      }
    }
    for (;;)
    {
      this.this$0.a.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.this$0.b.post(new FileVideoItemBuilder.2.1(this));
      return;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      apuw.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath, localOptions);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth = localOptions.outWidth;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight = localOptions.outHeight;
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]entity no size, get and use thumb size(wh)[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth + ":" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileVideoItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */
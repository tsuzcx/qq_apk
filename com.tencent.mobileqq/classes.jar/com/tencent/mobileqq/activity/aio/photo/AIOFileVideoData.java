package com.tencent.mobileqq.activity.aio.photo;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.io.File;

public class AIOFileVideoData
  extends AIORichMediaData
{
  public FileManagerEntity a;
  String a;
  
  public AIOFileVideoData() {}
  
  public AIOFileVideoData(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2))
    {
      if (!FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath)) {
        break label52;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath;
    }
    label52:
    do
    {
      return;
      if (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath;
        return;
      }
    } while (!FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath;
  }
  
  public File a(int paramInt)
  {
    if (!FileUtil.b(this.jdField_a_of_type_JavaLangString)) {
      return null;
    }
    return new File(this.jdField_a_of_type_JavaLangString);
  }
  
  public String a(int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return "";
    }
    if (!this.jdField_a_of_type_JavaLangString.startsWith("/")) {
      return "file:/" + this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_JavaLangString.startsWith("//")) {
      return "file:" + this.jdField_a_of_type_JavaLangString;
    }
    return "file:" + this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a(int paramInt)
  {
    return FileUtil.b(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EncodeVideoTask$VideoSaveAlumCallBack
  implements FFmpegExecuteResponseCallback
{
  long jdField_a_of_type_Long;
  EncodeVideoTask.EncodeProcessListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener;
  PublishVideoEntry jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public EncodeVideoTask$VideoSaveAlumCallBack(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, EncodeVideoTask.EncodeProcessListener paramEncodeProcessListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry = paramPublishVideoEntry;
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener = paramEncodeProcessListener;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener.a(-12);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate files|third step fail:");
      localStringBuilder.append(paramString);
      QLog.d("EncodeVideoTask", 2, localStringBuilder.toString());
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate files|third step cost:");
      double d = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      Double.isNaN(d);
      localStringBuilder.append(d / 1000.0D);
      localStringBuilder.append(", isSuccess:");
      localStringBuilder.append(paramBoolean);
      QLog.d("EncodeVideoTask", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener.b(this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry, this.b);
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart() {}
  
  public void onSuccess(String paramString)
  {
    com.tencent.biz.qqstory.utils.FileUtils.b(BaseApplication.getContext(), new File(this.b));
    com.tencent.mobileqq.utils.FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
    EncodeVideoTask.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.VideoSaveAlumCallBack
 * JD-Core Version:    0.7.0.1
 */
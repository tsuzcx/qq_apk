package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.qphone.base.util.QLog;

public class EncodeVideoTask$ResponseCallBack
  extends ExecuteBinResponseCallback
{
  long jdField_a_of_type_Long;
  EncodeVideoTask.EncodeProcessListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener;
  PublishVideoEntry jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public EncodeVideoTask$ResponseCallBack(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry = paramPublishVideoEntry;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(EncodeVideoTask.EncodeProcessListener paramEncodeProcessListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener = paramEncodeProcessListener;
  }
  
  public void onFailure(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener.a(-11);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate files|second step fail:");
      localStringBuilder.append(paramString);
      QLog.d("EncodeVideoTask", 2, localStringBuilder.toString());
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("generate files|second step cost:");
      double d = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      Double.isNaN(d);
      localStringBuilder.append(d / 1000.0D);
      localStringBuilder.append(", isSuccess:");
      localStringBuilder.append(paramBoolean);
      QLog.d("EncodeVideoTask", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener.a(this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry, this.b);
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onSuccess(String paramString)
  {
    FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
    EncodeVideoTask.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, 2);
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, "generate files|second step success!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResponseCallBack
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqstory.newshare.job;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.newshare.model.Job;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import java.util.Map;
import ngf;

public class UploadImageJob
  extends Job
{
  private String a;
  
  public UploadImageJob()
  {
    a(false, true);
  }
  
  public UploadImageJob(String paramString)
  {
    this();
    this.a = paramString;
  }
  
  public void a()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    TransFileController localTransFileController = localQQAppInterface.a();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new ngf(this);
    localTransferRequest.i = this.a;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_b_of_type_Int = 196610;
    localTransferRequest.jdField_b_of_type_JavaLangString = localQQAppInterface.c();
    localTransferRequest.c = "";
    localTransferRequest.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localTransFileController.a(localTransferRequest);
  }
  
  protected void a(Map paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("UploadImageJob_in_image_file_path"))) {
      this.a = ((String)a("UploadImageJob_in_image_file_path"));
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.UploadImageJob
 * JD-Core Version:    0.7.0.1
 */
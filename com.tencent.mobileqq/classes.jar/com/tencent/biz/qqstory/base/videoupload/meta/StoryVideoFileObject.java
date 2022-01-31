package com.tencent.biz.qqstory.base.videoupload.meta;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.UploadResult;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager.CompositeResult;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import mzp;

@TargetApi(14)
public class StoryVideoFileObject
  extends UploadObject
{
  public UploadResult a;
  public String a;
  public String b;
  
  public StoryVideoFileObject(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadUploadResult = new UploadResult();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private void c()
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new mzp(this);
    localTransferRequest.i = this.jdField_b_of_type_JavaLangString;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_b_of_type_Int = 196609;
    QQStoryContext.a();
    localTransferRequest.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localTransferRequest.c = "";
    localTransferRequest.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localTransferRequest);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!FileUtils.c(this.jdField_b_of_type_JavaLangString)))
    {
      VideoCompositeManager.CompositeResult localCompositeResult = ((VideoCompositeManager)SuperManager.a(14)).a(this.jdField_a_of_type_JavaLangString);
      if (localCompositeResult.a.isSuccess())
      {
        this.jdField_b_of_type_JavaLangString = localCompositeResult.jdField_b_of_type_JavaLangString;
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!FileUtils.c(this.jdField_b_of_type_JavaLangString)))
        {
          SLog.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString });
          super.notifyResult(new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString })));
        }
      }
      else
      {
        super.notifyResult(localCompositeResult.a);
        return;
      }
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.meta.StoryVideoFileObject
 * JD-Core Version:    0.7.0.1
 */
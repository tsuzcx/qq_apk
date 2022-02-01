package com.tencent.biz.qqstory.base.videoupload.meta;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager;
import com.tencent.biz.qqstory.base.videoupload.UploadResult;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager.CompositeResult;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;

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
    this.b = paramString2;
  }
  
  private void c()
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mUpCallBack = new StoryVideoFileObject.1(this);
    localTransferRequest.mLocalPath = this.b;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 196609;
    QQStoryContext.a();
    localTransferRequest.mSelfUin = QQStoryContext.a().getCurrentUin();
    localTransferRequest.mPeerUin = "";
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    ((ITransFileController)QQStoryContext.a().getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.b)) || (!FileUtils.c(this.b)))
    {
      Object localObject = ((VideoCompositeManager)SuperManager.a(14)).a(this.jdField_a_of_type_JavaLangString);
      if (((VideoCompositeManager.CompositeResult)localObject).a.isSuccess())
      {
        this.b = ((VideoCompositeManager.CompositeResult)localObject).b;
        if ((TextUtils.isEmpty(this.b)) || (!FileUtils.c(this.b)))
        {
          SLog.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "end composite success but file not exist:%s", new Object[] { this.b });
          localObject = new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.b }));
          ((ErrorMessage)localObject).extraMsg = "composite";
          super.notifyResult(localObject);
        }
      }
      else
      {
        ((VideoCompositeManager.CompositeResult)localObject).a.extraMsg = "composite";
        super.notifyResult(((VideoCompositeManager.CompositeResult)localObject).a);
        return;
      }
    }
    StoryVideoUploadProgressManager.a().b(this.jdField_a_of_type_JavaLangString);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.meta.StoryVideoFileObject
 * JD-Core Version:    0.7.0.1
 */
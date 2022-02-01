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
  public String a;
  public String b;
  public UploadResult c = new UploadResult();
  
  public StoryVideoFileObject(String paramString1, String paramString2)
  {
    this.a = paramString1;
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
    localTransferRequest.mSelfUin = QQStoryContext.j().getCurrentUin();
    localTransferRequest.mPeerUin = "";
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    ((ITransFileController)QQStoryContext.j().getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.b)) || (!FileUtils.d(this.b)))
    {
      localObject = ((VideoCompositeManager)SuperManager.a(14)).b(this.a);
      if (!((VideoCompositeManager.CompositeResult)localObject).g.isSuccess()) {
        break label148;
      }
      this.b = ((VideoCompositeManager.CompositeResult)localObject).b;
      if ((TextUtils.isEmpty(this.b)) || (!FileUtils.d(this.b))) {}
    }
    else
    {
      StoryVideoUploadProgressManager.a().b(this.a);
      c();
      return;
    }
    SLog.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "end composite success but file not exist:%s", new Object[] { this.b });
    Object localObject = new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.b }));
    ((ErrorMessage)localObject).extraMsg = "composite";
    super.notifyResult(localObject);
    return;
    label148:
    ((VideoCompositeManager.CompositeResult)localObject).g.extraMsg = "composite";
    super.notifyResult(((VideoCompositeManager.CompositeResult)localObject).g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.meta.StoryVideoFileObject
 * JD-Core Version:    0.7.0.1
 */
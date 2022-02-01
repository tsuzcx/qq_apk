package com.tencent.biz.qqstory.newshare.job;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.newshare.model.Job;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import java.util.Map;

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
    ITransFileController localITransFileController = (ITransFileController)localQQAppInterface.getRuntimeService(ITransFileController.class);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mUpCallBack = new UploadImageJob.1(this);
    localTransferRequest.mLocalPath = this.a;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 196610;
    localTransferRequest.mSelfUin = localQQAppInterface.getCurrentUin();
    localTransferRequest.mPeerUin = "";
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localITransFileController.transferAsync(localTransferRequest);
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("UploadImageJob_in_image_file_path"))) {
      this.a = ((String)a("UploadImageJob_in_image_file_path"));
    }
  }
  
  public boolean a()
  {
    return TextUtils.isEmpty(this.a) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.UploadImageJob
 * JD-Core Version:    0.7.0.1
 */
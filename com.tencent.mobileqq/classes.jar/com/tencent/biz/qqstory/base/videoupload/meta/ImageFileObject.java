package com.tencent.biz.qqstory.base.videoupload.meta;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import java.io.File;
import java.io.IOException;

@TargetApi(14)
public class ImageFileObject
  extends UploadObject
{
  public String a;
  public String b;
  private final ITransFileController c;
  private final boolean d;
  
  public ImageFileObject(boolean paramBoolean)
  {
    this.d = paramBoolean;
    QQStoryContext.a();
    this.c = ((ITransFileController)QQStoryContext.j().getRuntimeService(ITransFileController.class));
  }
  
  private void c()
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mUpCallBack = new ImageFileObject.1(this);
    localTransferRequest.mLocalPath = this.a;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 196610;
    QQStoryContext.a();
    localTransferRequest.mSelfUin = QQStoryContext.j().getCurrentUin();
    localTransferRequest.mPeerUin = "";
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    this.c.transferAsync(localTransferRequest);
  }
  
  protected void a()
  {
    File localFile2 = new File(this.a);
    if ((!localFile2.exists()) || (localFile2.length() == 0L)) {
      SLog.e("Q.qqstory.publish.upload:ImageFileObject", "file not exit %s", new Object[] { this.a });
    }
    if ((this.d) && (PngQuantUtils.a()))
    {
      Object localObject = null;
      try
      {
        File localFile1 = File.createTempFile("temp", "png", localFile2.getParentFile());
        localObject = localFile1;
      }
      catch (IOException localIOException)
      {
        SLog.b("Q.qqstory.publish.upload:ImageFileObject", "create file", localIOException);
      }
      if (PngQuantUtils.a(localFile2, localObject))
      {
        localFile2.delete();
        localObject.renameTo(localFile2);
      }
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject
 * JD-Core Version:    0.7.0.1
 */
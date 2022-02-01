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
  private final ITransFileController jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController;
  public String a;
  private final boolean jdField_a_of_type_Boolean;
  public String b;
  
  public ImageFileObject(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    QQStoryContext.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController = ((ITransFileController)QQStoryContext.a().getRuntimeService(ITransFileController.class));
  }
  
  private void c()
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mUpCallBack = new ImageFileObject.1(this);
    localTransferRequest.mLocalPath = this.jdField_a_of_type_JavaLangString;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mFileType = 196610;
    QQStoryContext.a();
    localTransferRequest.mSelfUin = QQStoryContext.a().getCurrentUin();
    localTransferRequest.mPeerUin = "";
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.transferAsync(localTransferRequest);
  }
  
  protected void a()
  {
    File localFile2 = new File(this.jdField_a_of_type_JavaLangString);
    if ((!localFile2.exists()) || (localFile2.length() == 0L)) {
      SLog.e("Q.qqstory.publish.upload:ImageFileObject", "file not exit %s", new Object[] { this.jdField_a_of_type_JavaLangString });
    }
    if ((this.jdField_a_of_type_Boolean) && (PngQuantUtils.a()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.meta.ImageFileObject
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.IBitmapCallback;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.qphone.base.util.QLog;

final class ReadInJoyCommentPBModule$12
  implements IBitmapCallback
{
  ReadInJoyCommentPBModule$12(String paramString) {}
  
  public void a(ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(ImageRequest paramImageRequest, CloseableBitmap paramCloseableBitmap)
  {
    QLog.d("ReadInJoyCommentPBModule", 2, "preload success " + this.a);
  }
  
  public void a(ImageRequest paramImageRequest, Throwable paramThrowable)
  {
    QLog.e("ReadInJoyCommentPBModule", 2, "preload failed " + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.12
 * JD-Core Version:    0.7.0.1
 */
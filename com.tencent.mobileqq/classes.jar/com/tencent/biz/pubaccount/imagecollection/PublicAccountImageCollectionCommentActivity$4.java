package com.tencent.biz.pubaccount.imagecollection;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class PublicAccountImageCollectionCommentActivity$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  PublicAccountImageCollectionCommentActivity$4(PublicAccountImageCollectionCommentActivity paramPublicAccountImageCollectionCommentActivity) {}
  
  public void onGlobalLayout()
  {
    int i = PublicAccountImageCollectionCommentActivity.b(this.a).getRootView().getHeight() - PublicAccountImageCollectionCommentActivity.b(this.a).getHeight();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("heightDiff:");
      localStringBuilder.append(i);
      QLog.d("ImageCollectionCommentActivity", 2, localStringBuilder.toString());
    }
    if (i > 150)
    {
      PublicAccountImageCollectionCommentActivity.a(this.a, true);
      return;
    }
    if (PublicAccountImageCollectionCommentActivity.c(this.a))
    {
      PublicAccountImageCollectionCommentActivity.a(this.a, false);
      PublicAccountImageCollectionCommentActivity.a(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionCommentActivity.4
 * JD-Core Version:    0.7.0.1
 */
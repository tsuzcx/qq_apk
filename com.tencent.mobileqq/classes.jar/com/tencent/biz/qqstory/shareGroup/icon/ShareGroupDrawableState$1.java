package com.tencent.biz.qqstory.shareGroup.icon;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.reactive.SimpleObserver;

class ShareGroupDrawableState$1
  extends SimpleObserver<Bitmap>
{
  ShareGroupDrawableState$1(ShareGroupDrawableState paramShareGroupDrawableState) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    IconLog.b(ShareGroupDrawableState.a(this.a), "onNext, oldResult=%s, newResult=%s", ShareGroupDrawableState.b(this.a), paramBitmap);
    ShareGroupDrawableState.a(this.a, paramBitmap);
    ShareGroupDrawableState.a(this.a, true);
  }
  
  public void onCancel()
  {
    super.onCancel();
    IconLog.a(ShareGroupDrawableState.a(this.a), "onCancel");
    onError(new ErrorMessage(-1, "onCancel"));
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    IconLog.c(ShareGroupDrawableState.a(this.a), "onError, oldError=%s, newError=%s", ShareGroupDrawableState.c(this.a), paramError);
    ShareGroupDrawableState.a(this.a, paramError);
    ShareGroupDrawableState.a(this.a, SystemClock.uptimeMillis());
    ShareGroupDrawableState.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupDrawableState.1
 * JD-Core Version:    0.7.0.1
 */
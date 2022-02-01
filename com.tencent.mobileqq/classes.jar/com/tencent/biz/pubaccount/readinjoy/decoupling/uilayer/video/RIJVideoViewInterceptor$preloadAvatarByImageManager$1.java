package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.IBitmapCallback;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJVideoViewInterceptor$preloadAvatarByImageManager$1", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/IBitmapCallback;", "onFail", "", "request", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageRequest;", "exception", "", "onProgress", "progress", "", "onSuccess", "bitmap", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/CloseableBitmap;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoViewInterceptor$preloadAvatarByImageManager$1
  implements IBitmapCallback
{
  RIJVideoViewInterceptor$preloadAvatarByImageManager$1(String paramString) {}
  
  public void a(@NotNull ImageRequest paramImageRequest, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramImageRequest, "request");
  }
  
  public void a(@NotNull ImageRequest paramImageRequest, @NotNull CloseableBitmap paramCloseableBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramImageRequest, "request");
    Intrinsics.checkParameterIsNotNull(paramCloseableBitmap, "bitmap");
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoViewInterceptor", 2, "preloadAvatarByImageManager ImageManager onSuccess, url:" + this.a);
    }
  }
  
  public void a(@NotNull ImageRequest paramImageRequest, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramImageRequest, "request");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    QLog.e("RIJVideoViewInterceptor", 1, "preloadAvatarByImageManager ImageManager onFail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJVideoViewInterceptor.preloadAvatarByImageManager.1
 * JD-Core Version:    0.7.0.1
 */
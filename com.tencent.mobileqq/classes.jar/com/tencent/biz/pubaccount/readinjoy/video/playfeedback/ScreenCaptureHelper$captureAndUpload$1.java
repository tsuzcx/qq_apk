package com.tencent.biz.pubaccount.readinjoy.video.playfeedback;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.ugc.upload.IImageUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/playfeedback/ScreenCaptureHelper$captureAndUpload$1", "Lcom/tencent/biz/pubaccount/readinjoy/video/playfeedback/ScreenCaptureHelper$CaptureViewCallback;", "onCaptureFailed", "", "onCaptureSuccess", "bitmap", "Landroid/graphics/Bitmap;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ScreenCaptureHelper$captureAndUpload$1
  implements ScreenCaptureHelper.CaptureViewCallback
{
  ScreenCaptureHelper$captureAndUpload$1(IImageUploadListener paramIImageUploadListener) {}
  
  public void a()
  {
    IImageUploadListener localIImageUploadListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadIImageUploadListener;
    if (localIImageUploadListener != null) {
      localIImageUploadListener.a(1, "");
    }
  }
  
  public void a(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    ScreenCaptureHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackScreenCaptureHelper, paramBitmap, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadIImageUploadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.playfeedback.ScreenCaptureHelper.captureAndUpload.1
 * JD-Core Version:    0.7.0.1
 */
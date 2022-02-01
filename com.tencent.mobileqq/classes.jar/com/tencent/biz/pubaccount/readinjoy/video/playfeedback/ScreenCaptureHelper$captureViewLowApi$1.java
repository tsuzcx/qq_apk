package com.tencent.biz.pubaccount.readinjoy.video.playfeedback;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import mqq.os.MqqHandler;
import shu;
import shv;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class ScreenCaptureHelper$captureViewLowApi$1
  implements Runnable
{
  public ScreenCaptureHelper$captureViewLowApi$1(shu paramshu, View paramView, float paramFloat, shv paramshv) {}
  
  public final void run()
  {
    Bitmap localBitmap = shu.a(this.this$0, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Float);
    ThreadManager.getUIHandler().post((Runnable)new ScreenCaptureHelper.captureViewLowApi.1.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.playfeedback.ScreenCaptureHelper.captureViewLowApi.1
 * JD-Core Version:    0.7.0.1
 */
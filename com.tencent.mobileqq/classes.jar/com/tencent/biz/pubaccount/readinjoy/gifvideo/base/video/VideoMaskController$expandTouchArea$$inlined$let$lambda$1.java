package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoMaskController$expandTouchArea$1$1"}, k=3, mv={1, 1, 16})
final class VideoMaskController$expandTouchArea$$inlined$let$lambda$1
  implements Runnable
{
  VideoMaskController$expandTouchArea$$inlined$let$lambda$1(ViewParent paramViewParent, VideoMaskController paramVideoMaskController, View paramView, float paramFloat1, float paramFloat2) {}
  
  public final void run()
  {
    try
    {
      Rect localRect = new Rect();
      this.jdField_a_of_type_AndroidViewView.setEnabled(true);
      this.jdField_a_of_type_AndroidViewView.getHitRect(localRect);
      localRect.top -= AIOUtils.a(this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidViewView.getResources());
      localRect.bottom += AIOUtils.a(this.b, this.jdField_a_of_type_AndroidViewView.getResources());
      ((View)this.jdField_a_of_type_AndroidViewViewParent).setTouchDelegate(new TouchDelegate(localRect, this.jdField_a_of_type_AndroidViewView));
      QLog.i(this.this$0.a(), 1, "[expandTouchArea] after, top = " + localRect.top + ", bottom = " + localRect.bottom);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.this$0.a(), 1, "[expandTouchArea] e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoMaskController.expandTouchArea..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */
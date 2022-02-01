package com.tencent.mobileqq.activity.richmedia;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class NewFlowCameraActivity$42
  implements Runnable
{
  NewFlowCameraActivity$42(NewFlowCameraActivity paramNewFlowCameraActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    int i = AIOUtils.a(47.0F, this.this$0.getResources());
    int j = AIOUtils.a(75.0F, this.this$0.getResources());
    Bitmap localBitmap1 = BitmapUtils.a(this.a, i, j, false);
    if (localBitmap1 == null) {
      SLog.e("PTV.NewFlowCameraActivity", "resizeThumb = null.");
    }
    Bitmap localBitmap2;
    do
    {
      return;
      localBitmap2 = new RoundedTransformation(AIOUtils.a(3.0F, this.this$0.getResources()), 0, j * 1.0F / i, null, null).a(localBitmap1);
      if (localBitmap2 == null)
      {
        SLog.e("PTV.NewFlowCameraActivity", "roundThumb = null.");
        return;
      }
      i = this.a.getWidth();
      j = this.a.getHeight();
      float f1 = ScreenUtil.SCREEN_WIDTH;
      float f2 = ScreenUtil.getInstantScreenHeight(this.this$0.getApplicationContext());
      if (i / j > f1 / f2) {}
      for (localBitmap1 = BitmapUtils.a(this.a, (int)(f1 / f2 * j), j, true); localBitmap1 == null; localBitmap1 = BitmapUtils.a(this.a, i, (int)(f2 / f1 * i), true))
      {
        SLog.e("PTV.NewFlowCameraActivity", "animBitmap = null.");
        return;
      }
    } while (this.this$0.a == null);
    this.this$0.a.post(new NewFlowCameraActivity.RunnableUpdateThumb(this.this$0, localBitmap1, localBitmap2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.42
 * JD-Core Version:    0.7.0.1
 */
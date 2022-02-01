package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.ProgressPieDrawable.OnProgressListener;
import com.tencent.qphone.base.util.QLog;

final class ScribbleItemBuilder$3
  implements ProgressPieDrawable.OnProgressListener
{
  ScribbleItemBuilder$3(Handler paramHandler) {}
  
  public void onProgressChanged(ProgressPieDrawable paramProgressPieDrawable, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(ProgressPieDrawable paramProgressPieDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onProgressCompleted] hide ProgressPieDrawable ,ppd = ");
      localStringBuilder.append(paramProgressPieDrawable);
      QLog.i("ScribbleItemBuilder", 2, localStringBuilder.toString());
    }
    this.a.postDelayed(new ScribbleItemBuilder.3.1(this, paramProgressPieDrawable), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qphone.base.util.QLog;

class ScribbleItemBuilder$3$1
  implements Runnable
{
  ScribbleItemBuilder$3$1(ScribbleItemBuilder.3 param3, ProgressPieDrawable paramProgressPieDrawable) {}
  
  public void run()
  {
    this.a.setVisible(false, true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onProgressCompleted] set ProgressPieDrawable invisible,ppd = ");
      localStringBuilder.append(this.a);
      QLog.i("ScribbleItemBuilder", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.3.1
 * JD-Core Version:    0.7.0.1
 */
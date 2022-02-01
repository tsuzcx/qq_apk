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
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleItemBuilder", 2, "[onProgressCompleted] set ProgressPieDrawable invisible,ppd = " + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.3.1
 * JD-Core Version:    0.7.0.1
 */
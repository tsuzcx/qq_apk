package com.tencent.mobileqq.activity.aio.item;

import ahfs;
import bisa;
import com.tencent.qphone.base.util.QLog;

public class ScribbleItemBuilder$3$1
  implements Runnable
{
  public ScribbleItemBuilder$3$1(ahfs paramahfs, bisa parambisa) {}
  
  public void run()
  {
    this.a.setVisible(false, true);
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleItemBuilder", 2, "[onProgressCompleted] set ProgressPieDrawable invisible,ppd = " + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.3.1
 * JD-Core Version:    0.7.0.1
 */
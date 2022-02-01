package com.tencent.mobileqq.activity.aio.photo;

import ahbu;
import ahbz;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3
  implements Runnable
{
  public PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3(ahbz paramahbz, ahbu paramahbu) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ahbz.c != null)
    {
      this.jdField_a_of_type_Ahbz.c.clearAnimation();
      this.jdField_a_of_type_Ahbz.c.removeAllViews();
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_Ahbz.b, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.GestureHandler.3
 * JD-Core Version:    0.7.0.1
 */
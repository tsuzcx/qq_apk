package com.tencent.mobileqq.activity.aio.photo;

import ahvq;
import ahvv;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3
  implements Runnable
{
  public PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3(ahvv paramahvv, ahvq paramahvq) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ahvv.c != null)
    {
      this.jdField_a_of_type_Ahvv.c.clearAnimation();
      this.jdField_a_of_type_Ahvv.c.removeAllViews();
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_Ahvv.b, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.GestureHandler.3
 * JD-Core Version:    0.7.0.1
 */
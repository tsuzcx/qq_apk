package com.tencent.mobileqq.activity.aio.photo;

import ahuu;
import ahuz;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3
  implements Runnable
{
  public PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3(ahuz paramahuz, ahuu paramahuu) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ahuz.c != null)
    {
      this.jdField_a_of_type_Ahuz.c.clearAnimation();
      this.jdField_a_of_type_Ahuz.c.removeAllViews();
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_Ahuz.b, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.GestureHandler.3
 * JD-Core Version:    0.7.0.1
 */
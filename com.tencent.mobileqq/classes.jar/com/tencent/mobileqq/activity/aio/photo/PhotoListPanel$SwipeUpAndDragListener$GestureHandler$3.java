package com.tencent.mobileqq.activity.aio.photo;

import agln;
import agls;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3
  implements Runnable
{
  public PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3(agls paramagls, agln paramagln) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Agls.c != null)
    {
      this.jdField_a_of_type_Agls.c.clearAnimation();
      this.jdField_a_of_type_Agls.c.removeAllViews();
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_Agls.b, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.GestureHandler.3
 * JD-Core Version:    0.7.0.1
 */
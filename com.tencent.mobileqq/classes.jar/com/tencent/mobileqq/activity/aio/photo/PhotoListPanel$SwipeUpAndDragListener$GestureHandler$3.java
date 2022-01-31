package com.tencent.mobileqq.activity.aio.photo;

import aekh;
import aekm;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3
  implements Runnable
{
  public PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3(aekm paramaekm, aekh paramaekh) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aekm.c != null)
    {
      this.jdField_a_of_type_Aekm.c.clearAnimation();
      this.jdField_a_of_type_Aekm.c.removeAllViews();
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_Aekm.b, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.GestureHandler.3
 * JD-Core Version:    0.7.0.1
 */
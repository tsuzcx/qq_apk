package com.tencent.mobileqq.activity.aio.photo;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3
  implements Runnable
{
  PhotoListPanel$SwipeUpAndDragListener$GestureHandler$3(PhotoListPanel.SwipeUpAndDragListener.GestureHandler paramGestureHandler, PhotoListPanel.SwipeUpAndDragListener paramSwipeUpAndDragListener) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.c != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.c.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.c.removeAllViews();
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.b, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.GestureHandler.3
 * JD-Core Version:    0.7.0.1
 */
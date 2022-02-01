package com.tencent.mobileqq.activity.aio.photo;

import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;

class PhotoListPanel$SwipeUpAndDragListener$3
  implements Runnable
{
  PhotoListPanel$SwipeUpAndDragListener$3(PhotoListPanel.SwipeUpAndDragListener paramSwipeUpAndDragListener) {}
  
  public void run()
  {
    PhotoListPanel.PhotoPanelAdapter.RecyclerHolder localRecyclerHolder;
    if ((this.this$0.b.get()) && (SystemClock.elapsedRealtime() - this.this$0.jdField_a_of_type_Long >= PhotoListPanel.SwipeUpAndDragListener.a()))
    {
      localRecyclerHolder = (PhotoListPanel.PhotoPanelAdapter.RecyclerHolder)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a.findViewHolderForAdapterPosition(this.this$0.jdField_c_of_type_Int);
      if (localRecyclerHolder != null) {
        break label61;
      }
    }
    label61:
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_Boolean);
      this.this$0.jdField_a_of_type_Boolean = true;
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler = this.this$0.jdField_c_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler;
    } while (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler == null);
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener$GestureHandler.a(localRecyclerHolder, this.this$0.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.photo;

import ahur;
import ahuu;
import ahuz;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;

public class PhotoListPanel$SwipeUpAndDragListener$3
  implements Runnable
{
  public PhotoListPanel$SwipeUpAndDragListener$3(ahuu paramahuu) {}
  
  public void run()
  {
    ahur localahur;
    if ((this.this$0.b.get()) && (SystemClock.elapsedRealtime() - this.this$0.jdField_a_of_type_Long >= ahuu.a()))
    {
      localahur = (ahur)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a.findViewHolderForAdapterPosition(this.this$0.jdField_c_of_type_Int);
      if (localahur != null) {
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
      this.this$0.jdField_a_of_type_Ahuz = this.this$0.jdField_c_of_type_Ahuz;
    } while (this.this$0.jdField_a_of_type_Ahuz == null);
    this.this$0.jdField_a_of_type_Ahuz.a(localahur, this.this$0.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.3
 * JD-Core Version:    0.7.0.1
 */
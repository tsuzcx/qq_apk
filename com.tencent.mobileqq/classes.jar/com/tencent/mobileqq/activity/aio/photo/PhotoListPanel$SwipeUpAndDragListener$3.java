package com.tencent.mobileqq.activity.aio.photo;

import aeke;
import aekh;
import aekm;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;

public class PhotoListPanel$SwipeUpAndDragListener$3
  implements Runnable
{
  public PhotoListPanel$SwipeUpAndDragListener$3(aekh paramaekh) {}
  
  public void run()
  {
    aeke localaeke;
    if ((this.this$0.b.get()) && (SystemClock.elapsedRealtime() - this.this$0.jdField_a_of_type_Long >= aekh.b()))
    {
      localaeke = (aeke)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a.findViewHolderForAdapterPosition(this.this$0.jdField_c_of_type_Int);
      if (localaeke != null) {
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
      this.this$0.jdField_a_of_type_Aekm = this.this$0.jdField_c_of_type_Aekm;
    } while (this.this$0.jdField_a_of_type_Aekm == null);
    this.this$0.jdField_a_of_type_Aekm.a(localaeke, this.this$0.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.3
 * JD-Core Version:    0.7.0.1
 */
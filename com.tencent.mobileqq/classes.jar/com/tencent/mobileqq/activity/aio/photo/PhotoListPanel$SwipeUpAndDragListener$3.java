package com.tencent.mobileqq.activity.aio.photo;

import aggv;
import aggy;
import aghd;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;

public class PhotoListPanel$SwipeUpAndDragListener$3
  implements Runnable
{
  public PhotoListPanel$SwipeUpAndDragListener$3(aggy paramaggy) {}
  
  public void run()
  {
    aggv localaggv;
    if ((this.this$0.b.get()) && (SystemClock.elapsedRealtime() - this.this$0.jdField_a_of_type_Long >= aggy.a()))
    {
      localaggv = (aggv)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a.findViewHolderForAdapterPosition(this.this$0.jdField_c_of_type_Int);
      if (localaggv != null) {
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
      this.this$0.jdField_a_of_type_Aghd = this.this$0.jdField_c_of_type_Aghd;
    } while (this.this$0.jdField_a_of_type_Aghd == null);
    this.this$0.jdField_a_of_type_Aghd.a(localaggv, this.this$0.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.3
 * JD-Core Version:    0.7.0.1
 */
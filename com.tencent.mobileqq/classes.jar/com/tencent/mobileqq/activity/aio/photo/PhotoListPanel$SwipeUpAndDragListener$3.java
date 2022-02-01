package com.tencent.mobileqq.activity.aio.photo;

import aifb;
import aife;
import aifj;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;

public class PhotoListPanel$SwipeUpAndDragListener$3
  implements Runnable
{
  public PhotoListPanel$SwipeUpAndDragListener$3(aife paramaife) {}
  
  public void run()
  {
    aifb localaifb;
    if ((this.this$0.b.get()) && (SystemClock.elapsedRealtime() - this.this$0.jdField_a_of_type_Long >= aife.a()))
    {
      localaifb = (aifb)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a.findViewHolderForAdapterPosition(this.this$0.jdField_c_of_type_Int);
      if (localaifb != null) {
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
      this.this$0.jdField_a_of_type_Aifj = this.this$0.jdField_c_of_type_Aifj;
    } while (this.this$0.jdField_a_of_type_Aifj == null);
    this.this$0.jdField_a_of_type_Aifj.a(localaifb, this.this$0.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.3
 * JD-Core Version:    0.7.0.1
 */
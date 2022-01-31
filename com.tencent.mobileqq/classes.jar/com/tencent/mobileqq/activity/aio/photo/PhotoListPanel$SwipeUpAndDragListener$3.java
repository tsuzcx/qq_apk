package com.tencent.mobileqq.activity.aio.photo;

import aekg;
import aekj;
import aeko;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;

public class PhotoListPanel$SwipeUpAndDragListener$3
  implements Runnable
{
  public PhotoListPanel$SwipeUpAndDragListener$3(aekj paramaekj) {}
  
  public void run()
  {
    aekg localaekg;
    if ((this.this$0.b.get()) && (SystemClock.elapsedRealtime() - this.this$0.jdField_a_of_type_Long >= aekj.b()))
    {
      localaekg = (aekg)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a.findViewHolderForAdapterPosition(this.this$0.jdField_c_of_type_Int);
      if (localaekg != null) {
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
      this.this$0.jdField_a_of_type_Aeko = this.this$0.jdField_c_of_type_Aeko;
    } while (this.this$0.jdField_a_of_type_Aeko == null);
    this.this$0.jdField_a_of_type_Aeko.a(localaekg, this.this$0.jdField_c_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.3
 * JD-Core Version:    0.7.0.1
 */
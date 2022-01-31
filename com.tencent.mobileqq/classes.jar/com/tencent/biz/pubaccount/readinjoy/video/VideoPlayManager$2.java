package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import qtr;
import qtu;
import qtv;
import qty;

public class VideoPlayManager$2
  implements Runnable
{
  public VideoPlayManager$2(qtr paramqtr, qtv paramqtv, qty paramqty, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if (qtr.a(this.this$0) != null)
    {
      Iterator localIterator = qtr.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        qtu localqtu = (qtu)localIterator.next();
        if (localqtu != null) {
          localqtu.a(this.jdField_a_of_type_Qtv, this.jdField_a_of_type_Qty, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangObject);
        }
      }
    }
    qtr.a(this.this$0, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.2
 * JD-Core Version:    0.7.0.1
 */
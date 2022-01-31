package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import qtu;
import qtx;
import qty;
import qub;

public class VideoPlayManager$2
  implements Runnable
{
  public VideoPlayManager$2(qtu paramqtu, qty paramqty, qub paramqub, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if (qtu.a(this.this$0) != null)
    {
      Iterator localIterator = qtu.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        qtx localqtx = (qtx)localIterator.next();
        if (localqtx != null) {
          localqtx.a(this.jdField_a_of_type_Qty, this.jdField_a_of_type_Qub, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangObject);
        }
      }
    }
    qtu.a(this.this$0, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.2
 * JD-Core Version:    0.7.0.1
 */
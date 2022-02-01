package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import seu;
import sew;
import sey;
import sfb;

public class VideoPlayManager$6
  implements Runnable
{
  public VideoPlayManager$6(seu paramseu, sey paramsey, sfb paramsfb, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if (seu.a(this.this$0) != null)
    {
      Iterator localIterator = seu.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        sew localsew = (sew)localIterator.next();
        if (localsew != null) {
          localsew.a(this.jdField_a_of_type_Sey, this.jdField_a_of_type_Sfb, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangObject);
        }
      }
    }
    seu.a(this.this$0, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.6
 * JD-Core Version:    0.7.0.1
 */
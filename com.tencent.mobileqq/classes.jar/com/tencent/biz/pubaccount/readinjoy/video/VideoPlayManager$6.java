package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import sdc;
import sde;
import sdg;
import sdj;

public class VideoPlayManager$6
  implements Runnable
{
  public VideoPlayManager$6(sdc paramsdc, sdg paramsdg, sdj paramsdj, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if (sdc.a(this.this$0) != null)
    {
      Iterator localIterator = sdc.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        sde localsde = (sde)localIterator.next();
        if (localsde != null) {
          localsde.a(this.jdField_a_of_type_Sdg, this.jdField_a_of_type_Sdj, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangObject);
        }
      }
    }
    sdc.a(this.this$0, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import spg;
import spi;
import spk;
import spn;

public class VideoPlayManager$6
  implements Runnable
{
  public VideoPlayManager$6(spg paramspg, spk paramspk, spn paramspn, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if (spg.a(this.this$0) != null)
    {
      Iterator localIterator = spg.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        spi localspi = (spi)localIterator.next();
        if (localspi != null) {
          localspi.a(this.jdField_a_of_type_Spk, this.jdField_a_of_type_Spn, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangObject);
        }
      }
    }
    spg.a(this.this$0, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.6
 * JD-Core Version:    0.7.0.1
 */
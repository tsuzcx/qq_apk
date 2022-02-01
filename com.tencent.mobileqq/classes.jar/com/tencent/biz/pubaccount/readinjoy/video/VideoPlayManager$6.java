package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import rvy;
import rwa;
import rwc;
import rwf;

public class VideoPlayManager$6
  implements Runnable
{
  public VideoPlayManager$6(rvy paramrvy, rwc paramrwc, rwf paramrwf, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if (rvy.a(this.this$0) != null)
    {
      Iterator localIterator = rvy.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        rwa localrwa = (rwa)localIterator.next();
        if (localrwa != null) {
          localrwa.a(this.jdField_a_of_type_Rwc, this.jdField_a_of_type_Rwf, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangObject);
        }
      }
    }
    rvy.a(this.this$0, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.6
 * JD-Core Version:    0.7.0.1
 */
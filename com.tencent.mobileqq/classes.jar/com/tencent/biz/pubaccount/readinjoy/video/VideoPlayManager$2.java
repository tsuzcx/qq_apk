package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import rjg;
import rjj;
import rjk;
import rjn;

public class VideoPlayManager$2
  implements Runnable
{
  public VideoPlayManager$2(rjg paramrjg, rjk paramrjk, rjn paramrjn, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if (rjg.a(this.this$0) != null)
    {
      Iterator localIterator = rjg.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        rjj localrjj = (rjj)localIterator.next();
        if (localrjj != null) {
          localrjj.a(this.jdField_a_of_type_Rjk, this.jdField_a_of_type_Rjn, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangObject);
        }
      }
    }
    rjg.a(this.this$0, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.2
 * JD-Core Version:    0.7.0.1
 */
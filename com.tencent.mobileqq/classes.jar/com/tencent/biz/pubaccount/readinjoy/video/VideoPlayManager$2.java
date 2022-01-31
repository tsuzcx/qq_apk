package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import qhp;
import qhs;
import qht;
import qhw;

public class VideoPlayManager$2
  implements Runnable
{
  public VideoPlayManager$2(qhp paramqhp, qht paramqht, qhw paramqhw, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if (qhp.a(this.this$0) != null)
    {
      Iterator localIterator = qhp.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        qhs localqhs = (qhs)localIterator.next();
        if (localqhs != null) {
          localqhs.a(this.jdField_a_of_type_Qht, this.jdField_a_of_type_Qhw, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangObject);
        }
      }
    }
    qhp.a(this.this$0, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.2
 * JD-Core Version:    0.7.0.1
 */
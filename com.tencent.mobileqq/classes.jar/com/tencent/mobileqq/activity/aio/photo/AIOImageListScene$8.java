package com.tencent.mobileqq.activity.aio.photo;

import ahrf;
import ahsn;
import ahso;
import ahtm;

public class AIOImageListScene$8
  implements Runnable
{
  public AIOImageListScene$8(ahso paramahso, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      ahtm localahtm = this.this$0.a.a();
      if (this.this$0.a.a(this.jdField_a_of_type_Long) != null) {
        this.this$0.e();
      }
      if ((this.jdField_a_of_type_Boolean) && (localahtm != null) && (this.jdField_a_of_type_Long == localahtm.a.f)) {
        ahrf.a(ahso.p(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.8
 * JD-Core Version:    0.7.0.1
 */
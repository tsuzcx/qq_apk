package com.tencent.mobileqq.activity.aio.photo;

import aibo;
import aicx;
import aicy;
import aidw;

public class AIOImageListScene$8
  implements Runnable
{
  public AIOImageListScene$8(aicy paramaicy, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      aidw localaidw = this.this$0.a.a();
      if (this.this$0.a.a(this.jdField_a_of_type_Long) != null) {
        this.this$0.e();
      }
      if ((this.jdField_a_of_type_Boolean) && (localaidw != null) && (this.jdField_a_of_type_Long == localaidw.a.f)) {
        aibo.a(aicy.p(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.8
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.photo;

import aibr;
import aicx;
import aidw;
import aksn;
import mqq.os.MqqHandler;

public class AIOGalleryScene$5
  implements Runnable
{
  public AIOGalleryScene$5(aibr paramaibr) {}
  
  public void run()
  {
    this.this$0.c(false);
    this.this$0.a(false);
    if ((this.this$0.jdField_a_of_type_Aicx.a() != null) && ((this.this$0.jdField_a_of_type_Aicx.a().a instanceof AIOShortVideoData))) {
      aibr.a(this.this$0, true);
    }
    if (this.this$0.jdField_a_of_type_Aksn.c())
    {
      this.this$0.u();
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.this$0.b);
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.this$0.b, 100L);
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.post(this.this$0.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.ui;

import mee;

class VideoLayerUI$10
  implements Runnable
{
  long jdField_a_of_type_Long = 0L;
  
  VideoLayerUI$10(VideoLayerUI paramVideoLayerUI, long paramLong, mee parammee, float paramFloat) {}
  
  public void run()
  {
    long l = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = (1L + l);
    if (l < this.b)
    {
      this.jdField_a_of_type_Mee.a(this.jdField_a_of_type_Float, VideoLayerUI.c(this.this$0), VideoLayerUI.d(this.this$0));
      this.jdField_a_of_type_Mee.a(this, 10L);
      return;
    }
    this.jdField_a_of_type_Mee.a(0, 0, true);
    VideoLayerUI.a(this.this$0, -1);
    VideoLayerUI.b(this.this$0, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.10
 * JD-Core Version:    0.7.0.1
 */
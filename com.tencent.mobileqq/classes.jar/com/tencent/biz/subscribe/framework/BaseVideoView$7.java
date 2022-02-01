package com.tencent.biz.subscribe.framework;

import android.widget.SeekBar;

class BaseVideoView$7
  implements Runnable
{
  BaseVideoView$7(BaseVideoView paramBaseVideoView, float paramFloat, double paramDouble) {}
  
  public void run()
  {
    if (this.this$0.a() != null)
    {
      if (this.jdField_a_of_type_Float == 0.0F)
      {
        this.this$0.a().setProgress(0);
        return;
      }
      SeekBar localSeekBar = this.this$0.a();
      double d1 = this.this$0.a().getMax();
      double d2 = this.jdField_a_of_type_Double;
      double d3 = this.jdField_a_of_type_Float;
      Double.isNaN(d3);
      d2 /= d3;
      Double.isNaN(d1);
      localSeekBar.setProgress((int)(d1 * d2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.framework.BaseVideoView.7
 * JD-Core Version:    0.7.0.1
 */
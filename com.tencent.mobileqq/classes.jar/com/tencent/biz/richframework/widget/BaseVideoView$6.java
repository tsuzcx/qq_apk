package com.tencent.biz.richframework.widget;

import android.widget.SeekBar;

class BaseVideoView$6
  implements Runnable
{
  BaseVideoView$6(BaseVideoView paramBaseVideoView, double paramDouble, float paramFloat) {}
  
  public void run()
  {
    if (this.this$0.a() != null) {
      this.this$0.a().setProgress((int)(this.this$0.a().getMax() * (this.jdField_a_of_type_Double / this.jdField_a_of_type_Float)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.widget.BaseVideoView.6
 * JD-Core Version:    0.7.0.1
 */
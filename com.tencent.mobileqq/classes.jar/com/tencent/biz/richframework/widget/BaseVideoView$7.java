package com.tencent.biz.richframework.widget;

import android.widget.SeekBar;

class BaseVideoView$7
  implements Runnable
{
  BaseVideoView$7(BaseVideoView paramBaseVideoView, float paramFloat, double paramDouble) {}
  
  public void run()
  {
    if (this.this$0.a() != null)
    {
      if (this.jdField_a_of_type_Float == 0.0F) {
        this.this$0.a().setProgress(0);
      }
    }
    else {
      return;
    }
    this.this$0.a().setProgress((int)(this.this$0.a().getMax() * (this.jdField_a_of_type_Double / this.jdField_a_of_type_Float)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.widget.BaseVideoView.7
 * JD-Core Version:    0.7.0.1
 */
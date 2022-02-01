package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.widget.ImageView;

class PickerContainer$4
  implements Runnable
{
  PickerContainer$4(PickerContainer paramPickerContainer, String paramString) {}
  
  public void run()
  {
    if ((PickerContainer.d(this.this$0) != null) && (PickerContainer.d(this.this$0).a(this.a)))
    {
      PickerContainer.d(this.this$0).stop();
      PickerContainer.d(this.this$0).a(PickerContainer.e(this.this$0) ^ true);
      PickerContainer.d(this.this$0).a(1);
      PickerContainer.d(this.this$0).start();
    }
    if (PickerContainer.f(this.this$0) != null) {
      PickerContainer.f(this.this$0).setVisibility(0);
    }
    if ((!PickerContainer.e(this.this$0)) && (PickerContainer.g(this.this$0) != null))
    {
      PickerContainer.g(this.this$0).stop();
      PickerContainer.g(this.this$0).a(true);
      PickerContainer.g(this.this$0).a(1);
      PickerContainer.g(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer.4
 * JD-Core Version:    0.7.0.1
 */
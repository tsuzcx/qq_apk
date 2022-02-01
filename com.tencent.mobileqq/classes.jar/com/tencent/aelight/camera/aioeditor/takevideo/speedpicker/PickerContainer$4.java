package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.widget.ImageView;

class PickerContainer$4
  implements Runnable
{
  PickerContainer$4(PickerContainer paramPickerContainer, String paramString) {}
  
  public void run()
  {
    if ((PickerContainer.a(this.this$0) != null) && (PickerContainer.a(this.this$0).a(this.a)))
    {
      PickerContainer.a(this.this$0).stop();
      PickerContainer.a(this.this$0).a(PickerContainer.b(this.this$0) ^ true);
      PickerContainer.a(this.this$0).a(1);
      PickerContainer.a(this.this$0).start();
    }
    if (PickerContainer.a(this.this$0) != null) {
      PickerContainer.a(this.this$0).setVisibility(0);
    }
    if ((!PickerContainer.b(this.this$0)) && (PickerContainer.a(this.this$0) != null))
    {
      PickerContainer.a(this.this$0).stop();
      PickerContainer.a(this.this$0).a(true);
      PickerContainer.a(this.this$0).a(1);
      PickerContainer.a(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer.4
 * JD-Core Version:    0.7.0.1
 */
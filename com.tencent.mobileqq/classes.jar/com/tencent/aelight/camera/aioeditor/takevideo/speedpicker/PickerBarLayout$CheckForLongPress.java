package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.view.ViewParent;

class PickerBarLayout$CheckForLongPress
  implements Runnable
{
  private int a;
  
  PickerBarLayout$CheckForLongPress(PickerBarLayout paramPickerBarLayout) {}
  
  public void a()
  {
    this.a = PickerBarLayout.c(this.this$0);
  }
  
  public void run()
  {
    if ((this.this$0.getParent() != null) && (this.a == PickerBarLayout.a(this.this$0)))
    {
      PickerBarLayout localPickerBarLayout = this.this$0;
      localPickerBarLayout.a = true;
      localPickerBarLayout.getParent().requestDisallowInterceptTouchEvent(true);
      this.this$0.sendAccessibilityEvent(2);
      localPickerBarLayout = this.this$0;
      localPickerBarLayout.a(PickerBarLayout.b(localPickerBarLayout));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerBarLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */
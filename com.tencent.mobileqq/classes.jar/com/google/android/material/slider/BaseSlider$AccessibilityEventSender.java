package com.google.android.material.slider;

class BaseSlider$AccessibilityEventSender
  implements Runnable
{
  int a = -1;
  
  private BaseSlider$AccessibilityEventSender(BaseSlider paramBaseSlider) {}
  
  void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    BaseSlider.b(this.this$0).sendEventForVirtualView(this.a, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.slider.BaseSlider.AccessibilityEventSender
 * JD-Core Version:    0.7.0.1
 */
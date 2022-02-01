package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.widget.ParticipleView;
import java.lang.ref.WeakReference;

final class TextPreviewActivity$CustomFlingHandler
  extends FlingGestureHandler
{
  private WeakReference<TextPreviewActivity> b;
  
  private TextPreviewActivity$CustomFlingHandler(TextPreviewActivity paramTextPreviewActivity)
  {
    super(paramTextPreviewActivity);
    this.b = new WeakReference(paramTextPreviewActivity);
  }
  
  public void flingLToR()
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.b.get();
    int i;
    if (localTextPreviewActivity != null) {
      if ((localTextPreviewActivity.a != null) && (localTextPreviewActivity.a.getVisibility() == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        super.flingLToR();
      }
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.CustomFlingHandler
 * JD-Core Version:    0.7.0.1
 */
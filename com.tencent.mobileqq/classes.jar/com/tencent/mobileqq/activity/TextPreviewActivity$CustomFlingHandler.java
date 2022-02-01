package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.widget.participle.ParticipleView;
import java.lang.ref.WeakReference;

final class TextPreviewActivity$CustomFlingHandler
  extends FlingGestureHandler
{
  private WeakReference<TextPreviewActivity> a;
  
  private TextPreviewActivity$CustomFlingHandler(TextPreviewActivity paramTextPreviewActivity)
  {
    super(paramTextPreviewActivity);
    this.a = new WeakReference(paramTextPreviewActivity);
  }
  
  public void flingLToR()
  {
    TextPreviewActivity localTextPreviewActivity = (TextPreviewActivity)this.a.get();
    int j = 0;
    int i = j;
    if (localTextPreviewActivity != null)
    {
      i = j;
      if (localTextPreviewActivity.T != null)
      {
        i = j;
        if (localTextPreviewActivity.T.getVisibility() == 0) {
          i = 1;
        }
      }
    }
    if (i == 0) {
      super.flingLToR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewActivity.CustomFlingHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout.OnDispatchListener;
import com.tencent.mobileqq.activity.selectable.TranslateSelectableMenu;
import java.lang.ref.WeakReference;

final class TextPreviewTranslateActivity$DispatchListener
  implements DispatchTouchEventRelativeLayout.OnDispatchListener
{
  private WeakReference<TranslateSelectableMenu> a;
  
  TextPreviewTranslateActivity$DispatchListener(TranslateSelectableMenu paramTranslateSelectableMenu)
  {
    this.a = new WeakReference(paramTranslateSelectableMenu);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    TranslateSelectableMenu localTranslateSelectableMenu = (TranslateSelectableMenu)this.a.get();
    if (localTranslateSelectableMenu != null) {
      localTranslateSelectableMenu.a(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity.DispatchListener
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.aelight.camera.aioeditor.takevideo;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.widget.ScaleGestureDetector;

class EditProviderPart$2
  implements View.OnTouchListener
{
  EditProviderPart$2(EditProviderPart paramEditProviderPart) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.u == null) {
      return false;
    }
    if (EditProviderPart.a(this.a) == null)
    {
      if (this.a.t.O == null) {
        return false;
      }
      paramView = this.a;
      EditProviderPart.a(paramView, paramView.t.O.b());
    }
    if (this.a.e) {
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      EditProviderPart.a(this.a, false);
      EditProviderPart.b(this.a, false);
    }
    if ((this.a.t != null) && (this.a.t.j()))
    {
      EditProviderPart.b(this.a).onTouchEvent(paramMotionEvent);
      if (EditProviderPart.b(this.a).isInProgress()) {
        EditProviderPart.b(this.a, true);
      }
    }
    boolean bool1;
    if ((!EditProviderPart.b(this.a).isInProgress()) && ((EditProviderPart.c(this.a)) || (!EditProviderPart.d(this.a).onTouchEvent(paramMotionEvent)))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2;
    if (!bool1)
    {
      bool1 = EditProviderPart.e(this.a).a(paramMotionEvent);
      bool2 = bool1;
      if (i == 0)
      {
        EditProviderPart.a(this.a, true);
        return bool1;
      }
    }
    else
    {
      bool2 = bool1;
      if (EditProviderPart.f(this.a))
      {
        paramView = MotionEvent.obtain(paramMotionEvent);
        paramView.setAction(3);
        EditProviderPart.e(this.a).a(paramView);
        paramView.recycle();
        EditProviderPart.a(this.a, false);
        bool2 = bool1;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.2
 * JD-Core Version:    0.7.0.1
 */
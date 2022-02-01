package com.tencent.mobileqq.activity.aio.tips;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.widget.QQBlurView;

class LocationShareTipsBar$3
  implements View.OnAttachStateChangeListener
{
  LocationShareTipsBar$3(LocationShareTipsBar paramLocationShareTipsBar) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (LocationShareTipsBar.a(this.a) != null) {
      LocationShareTipsBar.a(this.a).destory();
    }
    if (LocationShareTipsBar.a(this.a) != null)
    {
      LocationShareTipsBar.a(this.a).c();
      LocationShareTipsBar.a(this.a, null);
    }
    LocationShareTipsBar.a(this.a).removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.LocationShareTipsBar.3
 * JD-Core Version:    0.7.0.1
 */
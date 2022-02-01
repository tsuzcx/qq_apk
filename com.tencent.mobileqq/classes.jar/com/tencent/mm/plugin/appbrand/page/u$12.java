package com.tencent.mm.plugin.appbrand.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import kotlin.jvm.functions.Function0;

class u$12
  implements Function0<View>
{
  u$12(u paramu) {}
  
  public View a()
  {
    View localView = this.a.S().a(LayoutInflater.from(this.a.getContext()));
    if (localView == null) {
      return new FrameLayout(this.a.getContext());
    }
    Object localObject = localView;
    if (!(localView instanceof FrameLayout))
    {
      localObject = new FrameLayout(this.a.getContext());
      ((ViewGroup)localObject).addView(localView, new ViewGroup.LayoutParams(-1, -1));
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u.12
 * JD-Core Version:    0.7.0.1
 */
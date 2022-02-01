package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.arch.core.util.Function;

class d$6
  implements Function<i, Void>
{
  d$6(d paramd) {}
  
  public Void a(i parami)
  {
    if ((parami != null) && (parami.getContentView() != null))
    {
      parami = parami.getContentView();
      parami.animate().cancel();
      parami.clearAnimation();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.d.6
 * JD-Core Version:    0.7.0.1
 */
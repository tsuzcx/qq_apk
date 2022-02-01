package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.ui.i;
import com.tencent.mm.plugin.appbrand.widget.f;

public class a
  implements i
{
  protected static void a(@NonNull d paramd, @AnimRes int paramInt, Runnable paramRunnable)
  {
    if (!ViewCompat.isLaidOut(paramd.ai()))
    {
      paramd.ai().setWillNotDraw(true);
      paramd.ai().post(new a.1(paramd, paramInt, paramRunnable));
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(r.a(), paramInt);
    localAnimation.setAnimationListener(new a.2(paramRunnable, paramd));
    paramd.ai().startAnimation(localAnimation);
  }
  
  public void a(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130772043, 2130772044);
  }
  
  public void a(d paramd1, Runnable paramRunnable1, d paramd2, Runnable paramRunnable2)
  {
    if (paramd1 == null) {
      return;
    }
    a(paramd1, 2130772046, new a.3(this, paramd1, paramRunnable1));
    if (paramd2 != null) {
      a(paramd2, 2130772042, paramRunnable2);
    }
  }
  
  public void b(d paramd1, Runnable paramRunnable1, d paramd2, Runnable paramRunnable2)
  {
    if (paramd2 == null) {
      return;
    }
    a(paramd2, 2130772044, paramRunnable2);
    if (paramd1 != null) {
      a(paramd1, 2130772042, paramRunnable1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.pp;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

abstract class ai$a<Source extends View, Target extends View>
{
  private Target a;
  
  abstract boolean a(@NonNull View paramView);
  
  abstract Target c(@NonNull View paramView);
  
  final Target d(Source paramSource)
  {
    View localView = this.a;
    if ((localView != null) && (ViewCompat.isAttachedToWindow(localView))) {
      return this.a;
    }
    if (paramSource != null)
    {
      if (!ViewCompat.isAttachedToWindow(paramSource)) {
        return null;
      }
      paramSource = paramSource.getParent();
      while ((paramSource instanceof View))
      {
        localView = (View)paramSource;
        if (!a(localView))
        {
          paramSource = paramSource.getParent();
        }
        else
        {
          paramSource = c(localView);
          this.a = paramSource;
          return paramSource;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.ai.a
 * JD-Core Version:    0.7.0.1
 */
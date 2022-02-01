package com.tencent.luggage.wxa.fy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Space;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.lp.f;
import com.tencent.luggage.wxa.lp.g;
import com.tencent.luggage.wxa.qz.b;
import com.tencent.luggage.wxa.qz.o;

abstract class u$a
  extends LinearLayout
  implements g
{
  @NonNull
  private final Space a;
  @NonNull
  private final View c;
  @NonNull
  private final Space d;
  
  public u$a(u paramu, @NonNull Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setOrientation(0);
    Object localObject = new ColorDrawable(Color.argb(127, 0, 0, 0));
    if (!a(this, (Drawable)localObject)) {
      setBackground(new LayerDrawable(new Drawable[] { new ColorDrawable(Color.parseColor("#F7F7F7")), localObject }));
    }
    setGravity(16);
    this.a = a(paramContext);
    addView(this.a);
    this.c = b(paramContext);
    localObject = this.c;
    if (localObject == null) {
      o.c(paramu.a, "createVideoContainerView, audioPlayView is null");
    } else {
      addView((View)localObject);
    }
    this.d = a(paramContext);
    addView(this.d);
  }
  
  private boolean a(@NonNull ViewGroup paramViewGroup, @NonNull Drawable paramDrawable)
  {
    Object localObject = (k)u.a(this.b).a(k.class);
    if (localObject == null)
    {
      o.c(this.b.a, "setBackground4AudioPlayViewContainer, videoPlayerAddOnGetSnapshot is null");
      return false;
    }
    localObject = ((k)localObject).a();
    if (localObject == null)
    {
      o.c(this.b.a, "setBackground4AudioPlayViewContainer, bitmap is null");
      return false;
    }
    o.d(this.b.a, "setBackground4AudioPlayViewContainer, real set");
    localObject = b.a((Bitmap)localObject, 50);
    paramViewGroup.setBackground(new LayerDrawable(new Drawable[] { new BitmapDrawable(paramViewGroup.getResources(), (Bitmap)localObject), paramDrawable }));
    return true;
  }
  
  protected abstract Space a(@NonNull Context paramContext);
  
  public void a(@NonNull f paramf)
  {
    String str = this.b.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onModeConfirmed, mode: ");
    localStringBuilder.append(paramf);
    o.d(str, localStringBuilder.toString());
    if (f.b == paramf)
    {
      ((LinearLayout.LayoutParams)this.a.getLayoutParams()).weight = 75.0F;
      ((LinearLayout.LayoutParams)this.d.getLayoutParams()).weight = 75.0F;
      ((LinearLayout.LayoutParams)this.c.getLayoutParams()).weight = 48.0F;
    }
  }
  
  protected abstract View b(@NonNull Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.u.a
 * JD-Core Version:    0.7.0.1
 */
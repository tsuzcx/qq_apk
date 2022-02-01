package com.tencent.av.utils;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.View;
import java.io.InputStream;

public class TintStateDrawable
  extends BitmapDrawable
{
  private ColorStateList a;
  
  public TintStateDrawable(Resources paramResources, InputStream paramInputStream, int paramInt)
  {
    super(paramResources, paramInputStream);
    this.a = paramResources.getColorStateList(paramInt);
    onStateChange(getState());
  }
  
  public static TintStateDrawable a(Resources paramResources, int paramInt1, int paramInt2)
  {
    return new TintStateDrawable(paramResources, paramResources.openRawResource(paramInt1), paramInt2);
  }
  
  @TargetApi(16)
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    TintStateDrawable localTintStateDrawable = a(paramView.getResources(), paramInt1, paramInt2);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(localTintStateDrawable);
      return;
    }
    paramView.setBackgroundDrawable(localTintStateDrawable);
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.a.getColorForState(paramArrayOfInt, 0);
    if (i != 0) {
      setColorFilter(i, PorterDuff.Mode.MULTIPLY);
    } else {
      clearColorFilter();
    }
    invalidateSelf();
    return super.onStateChange(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TintStateDrawable
 * JD-Core Version:    0.7.0.1
 */
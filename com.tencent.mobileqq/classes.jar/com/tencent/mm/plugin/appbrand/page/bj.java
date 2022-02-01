package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

public class bj
{
  @UiThread
  public static Bitmap a(@NonNull View paramView)
  {
    if ((paramView.getWidth() > 0) && (paramView.getHeight() > 0))
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
      a(paramView, new Canvas(localBitmap));
      return localBitmap;
    }
    return null;
  }
  
  @UiThread
  public static void a(@NonNull View paramView, @NonNull Canvas paramCanvas)
  {
    if (b(paramView, paramCanvas)) {
      return;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        a(paramView.getChildAt(i), paramCanvas);
        i += 1;
      }
    }
  }
  
  private static boolean b(@NonNull View paramView, Canvas paramCanvas)
  {
    if (paramView.getVisibility() != 0) {
      return true;
    }
    if ((paramView instanceof bi)) {
      return ((bi)paramView).a(paramCanvas);
    }
    paramView.draw(paramCanvas);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bj
 * JD-Core Version:    0.7.0.1
 */
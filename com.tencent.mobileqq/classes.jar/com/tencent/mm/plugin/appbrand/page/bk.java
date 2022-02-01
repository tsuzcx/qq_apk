package com.tencent.mm.plugin.appbrand.page;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

@TargetApi(14)
public class bk
{
  public static void a(@NonNull Canvas paramCanvas, @NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView.getVisibility() != 0) {
      return;
    }
    if ((paramView instanceof TextureView))
    {
      paramView = ((TextureView)paramView).getBitmap(paramView.getWidth(), paramView.getHeight());
      if ((paramView != null) && (!paramView.isRecycled())) {
        paramCanvas.drawBitmap(paramView, paramFloat1, paramFloat2, null);
      }
      return;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        View localView = paramView.getChildAt(i);
        a(paramCanvas, localView, localView.getX() + paramFloat1, localView.getY() + paramFloat2);
        i += 1;
      }
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramView.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public static boolean a(@NonNull ViewGroup paramViewGroup)
  {
    int i = 0;
    if (paramViewGroup != null)
    {
      if (paramViewGroup.getChildCount() == 0) {
        return false;
      }
      int j = paramViewGroup.getChildCount();
      boolean bool = false;
      while (i < j)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof TextureView)) {
          bool = true;
        }
        if ((localView instanceof ViewGroup)) {
          bool = a((ViewGroup)localView);
        }
        if (bool) {
          return bool;
        }
        i += 1;
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bk
 * JD-Core Version:    0.7.0.1
 */
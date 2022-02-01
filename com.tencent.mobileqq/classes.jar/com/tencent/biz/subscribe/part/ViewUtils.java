package com.tencent.biz.subscribe.part;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;

public class ViewUtils
{
  public static Bitmap a(Resources paramResources, int paramInt, Integer paramInteger1, Integer paramInteger2)
  {
    Object localObject = paramResources.getDrawable(paramInt);
    if ((localObject instanceof BitmapDrawable)) {
      return ((BitmapDrawable)localObject).getBitmap();
    }
    if ((localObject instanceof GradientDrawable))
    {
      paramResources = (GradientDrawable)localObject;
      if (((Drawable)localObject).getIntrinsicWidth() > 0) {
        paramInt = ((Drawable)localObject).getIntrinsicWidth();
      } else {
        paramInt = paramInteger1.intValue();
      }
      int i;
      if (((Drawable)localObject).getIntrinsicHeight() > 0) {
        i = ((Drawable)localObject).getIntrinsicHeight();
      } else {
        i = paramInteger2.intValue();
      }
      paramInteger1 = Bitmap.createBitmap(paramInt, i, Bitmap.Config.ARGB_8888);
      paramInteger2 = new Canvas(paramInteger1);
      paramResources.setBounds(0, 0, paramInt, i);
      paramResources.setStroke(1, -16777216);
      paramResources.setFilterBitmap(true);
      paramResources.draw(paramInteger2);
      return paramInteger1;
    }
    if ((localObject instanceof ColorDrawable))
    {
      paramResources = (ColorDrawable)localObject;
      localObject = Bitmap.createBitmap(paramInteger1.intValue(), paramInteger2.intValue(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramResources.setBounds(0, 0, paramInteger1.intValue(), paramInteger2.intValue());
      paramResources.setFilterBitmap(true);
      paramResources.draw(localCanvas);
      return localObject;
    }
    return BitmapFactory.decodeResource(paramResources, paramInt).copy(Bitmap.Config.ARGB_8888, true);
  }
  
  public static TextView a(Context paramContext, float paramFloat, String paramString1, String paramString2)
  {
    paramContext = new TextView(paramContext);
    paramContext.setTextSize(1, paramFloat);
    paramContext.setTextColor(Color.parseColor(paramString1));
    paramContext.setText(paramString2);
    return paramContext;
  }
  
  public static boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    Rect localRect = new Rect();
    paramView.getLocalVisibleRect(localRect);
    return (paramFloat1 > localRect.left) && (paramFloat1 < localRect.right) && (paramFloat2 > localRect.top) && (paramFloat2 < localRect.bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.ViewUtils
 * JD-Core Version:    0.7.0.1
 */
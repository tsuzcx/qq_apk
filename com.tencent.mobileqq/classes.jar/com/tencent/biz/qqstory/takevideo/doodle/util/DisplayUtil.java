package com.tencent.biz.qqstory.takevideo.doodle.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;

@TargetApi(14)
public class DisplayUtil
{
  public static int a;
  public static int b;
  
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 < paramInt4) {
      return 1.0F;
    }
    return paramInt4 / paramInt2;
  }
  
  public static int a()
  {
    return a(BaseApplicationImpl.getApplication().getBaseContext(), 24.0F);
  }
  
  public static int a(Context paramContext)
  {
    if (a > 0) {
      return a;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (a = localPoint.x;; a = paramContext.getDefaultDisplay().getWidth()) {
      return a;
    }
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static void a(Canvas paramCanvas, GestureHelper paramGestureHelper, GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = a();
    paramCanvas.concat(paramGestureHelper.b(paramZoomItem));
    int i = (int)(paramZoomItem.n * paramZoomItem.j * paramZoomItem.p) + paramZoomItem.e * 2;
    int j = (int)(paramZoomItem.o * paramZoomItem.j * paramZoomItem.p) + paramZoomItem.e * 2;
    paramCanvas.translate(-i * 1.0F / 2.0F, -j * 1.0F / 2.0F);
    paramGestureHelper = new Paint();
    paramGestureHelper.setStyle(Paint.Style.STROKE);
    paramGestureHelper.setColor(BaseApplicationImpl.getApplication().getResources().getColor(2131492908));
    paramGestureHelper.setStrokeWidth(a(BaseApplicationImpl.getApplication().getBaseContext(), 1.0F));
    int k = a(BaseApplicationImpl.getApplication().getBaseContext(), 3.0F);
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, i, j), k, k, paramGestureHelper);
    paramCanvas.translate(-paramInt1 / 2, -paramInt1 / 2);
    paramCanvas.translate(i, j);
    paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt3);
    paramGestureHelper.setBounds(0, 0, paramInt1, paramInt1);
    paramGestureHelper.draw(paramCanvas);
    paramCanvas.translate(0.0F, -j);
    paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt2);
    paramGestureHelper.setBounds(0, 0, paramInt1, paramInt1);
    paramGestureHelper.draw(paramCanvas);
  }
  
  public static int b(Context paramContext)
  {
    if (b > 0) {
      return b;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (b = localPoint.y;; b = paramContext.getDefaultDisplay().getHeight()) {
      return b;
    }
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */
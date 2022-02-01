package com.tencent.aelight.camera.aioeditor.takevideo.doodle.util;

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
    return b(BaseApplicationImpl.getApplication().getBaseContext(), 30.0F);
  }
  
  public static int a(Context paramContext)
  {
    int i = a;
    if (i > 0) {
      return i;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (Build.VERSION.SDK_INT >= 13)
    {
      Point localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
      a = localPoint.x;
    }
    else
    {
      a = paramContext.getDefaultDisplay().getWidth();
    }
    return a;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static void a(Canvas paramCanvas, GestureHelper paramGestureHelper, GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = a() / paramZoomItem.a();
    paramCanvas.concat(paramGestureHelper.b(paramZoomItem));
    int i = (int)(paramZoomItem.n * paramZoomItem.j * paramZoomItem.p) + paramZoomItem.i * 2;
    int j = (int)(paramZoomItem.o * paramZoomItem.j * paramZoomItem.p) + paramZoomItem.i * 2;
    float f3 = -i * 1.0F / 2.0F;
    float f2 = -j;
    paramCanvas.translate(f3, f2 * 1.0F / 2.0F);
    paramGestureHelper = new Paint();
    paramGestureHelper.setStyle(Paint.Style.STROKE);
    paramGestureHelper.setColor(BaseApplicationImpl.getApplication().getResources().getColor(2131167408));
    paramGestureHelper.setStrokeWidth(b(BaseApplicationImpl.getApplication().getBaseContext(), 1.0F));
    int k = b(BaseApplicationImpl.getApplication().getBaseContext(), 3.0F);
    f3 = i;
    float f4 = j;
    paramZoomItem = new RectF(0.0F, 0.0F, f3, f4);
    float f5 = k;
    paramCanvas.drawRoundRect(paramZoomItem, f5, f5, paramGestureHelper);
    f5 = -f1 / 2.0F;
    paramCanvas.translate(f5, f5);
    if (paramInt1 > 0)
    {
      paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt1);
      paramInt1 = (int)f1;
      paramGestureHelper.setBounds(0, 0, paramInt1, paramInt1);
      paramGestureHelper.draw(paramCanvas);
    }
    paramCanvas.translate(f3, f4);
    if (paramInt3 > 0)
    {
      paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt3);
      paramInt1 = (int)f1;
      paramGestureHelper.setBounds(0, 0, paramInt1, paramInt1);
      paramGestureHelper.draw(paramCanvas);
    }
    paramCanvas.translate(0.0F, f2);
    if (paramInt2 > 0)
    {
      paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt2);
      paramInt1 = (int)f1;
      paramGestureHelper.setBounds(0, 0, paramInt1, paramInt1);
      paramGestureHelper.draw(paramCanvas);
    }
  }
  
  public static int b(Context paramContext)
  {
    int i = b;
    if (i > 0) {
      return i;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (Build.VERSION.SDK_INT >= 13)
    {
      Point localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
      b = localPoint.y;
    }
    else
    {
      b = paramContext.getDefaultDisplay().getHeight();
    }
    return b;
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */
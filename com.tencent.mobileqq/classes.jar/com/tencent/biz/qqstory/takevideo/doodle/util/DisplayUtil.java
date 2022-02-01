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
import ygv;
import ygw;

@TargetApi(14)
public class DisplayUtil
{
  public static final String TAG = "DisplayUtil";
  public static int sWindowHeight;
  public static int sWindowWidth;
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static void drawEditRect(Canvas paramCanvas, ygv paramygv, ygw paramygw, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = getStickerButtonSize();
    paramCanvas.concat(paramygv.b(paramygw));
    int i = (int)(paramygw.n * paramygw.j * paramygw.p) + paramygw.e * 2;
    int j = (int)(paramygw.o * paramygw.j * paramygw.p) + paramygw.e * 2;
    paramCanvas.translate(-i * 1.0F / 2.0F, -j * 1.0F / 2.0F);
    paramygv = new Paint();
    paramygv.setStyle(Paint.Style.STROKE);
    paramygv.setColor(BaseApplicationImpl.getApplication().getResources().getColor(2131167350));
    paramygv.setStrokeWidth(dip2px(BaseApplicationImpl.getApplication().getBaseContext(), 1.0F));
    int k = dip2px(BaseApplicationImpl.getApplication().getBaseContext(), 3.0F);
    paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, i, j), k, k, paramygv);
    paramCanvas.translate(-paramInt1 / 2, -paramInt1 / 2);
    paramCanvas.translate(i, j);
    paramygv = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt3);
    paramygv.setBounds(0, 0, paramInt1, paramInt1);
    paramygv.draw(paramCanvas);
    paramCanvas.translate(0.0F, -j);
    paramygv = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt2);
    paramygv.setBounds(0, 0, paramInt1, paramInt1);
    paramygv.draw(paramCanvas);
  }
  
  public static float getFitScaleValue(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 < paramInt4) {
      return 1.0F;
    }
    return paramInt4 / paramInt2;
  }
  
  public static int getStatusbarHeight(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    return paramContext.getResources().getDimensionPixelSize(i);
  }
  
  public static int getStickerButtonSize()
  {
    return dip2px(BaseApplicationImpl.getApplication().getBaseContext(), 24.0F);
  }
  
  public static int getWindowScreenHeight(Context paramContext)
  {
    if (sWindowHeight > 0) {
      return sWindowHeight;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (sWindowHeight = localPoint.y;; sWindowHeight = paramContext.getDefaultDisplay().getHeight()) {
      return sWindowHeight;
    }
  }
  
  public static int getWindowScreenWidth(Context paramContext)
  {
    if (sWindowWidth > 0) {
      return sWindowWidth;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Point localPoint;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
    }
    for (sWindowWidth = localPoint.x;; sWindowWidth = paramContext.getDefaultDisplay().getWidth()) {
      return sWindowWidth;
    }
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int px2sp(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static int sp2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */
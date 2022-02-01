package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class RandomTextDrawable
  extends InfoStickerDrawable
{
  PerLineFontBitmapsInfo a;
  PerLineFontBitmapsInfo b;
  int c = 0;
  private String d = "05:36";
  private String e = "2017 SEPTEMBER 30";
  private Paint n = new Paint();
  private TextPaint o = new TextPaint();
  
  public RandomTextDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    e();
  }
  
  private PerLineFontBitmapsInfo a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Typeface paramTypeface, AnimStateTypeEvaluator paramAnimStateTypeEvaluator, int paramInt7)
  {
    paramTypeface = new PerLineFontBitmapsInfo(paramInt1, paramInt2, paramTypeface, paramInt3, paramInt4, paramInt5, paramInt6);
    paramTypeface.a(paramCharSequence, paramAnimStateTypeEvaluator, paramInt7);
    return paramTypeface;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomTextDrawable", 2, paramString1, new Object[0]);
      }
      paramString1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RandomTextDrawable", 2, paramString1);
    }
    return paramString1;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    paramArrayList = this.a.g.iterator();
    FontBitmapInfo localFontBitmapInfo;
    Bitmap localBitmap;
    TextPaint localTextPaint;
    while (paramArrayList.hasNext())
    {
      localFontBitmapInfo = (FontBitmapInfo)paramArrayList.next();
      localBitmap = localFontBitmapInfo.a;
      localTextPaint = this.a.a;
      localTextPaint.setAlpha(((Integer)this.g.get(localFontBitmapInfo.c)).intValue());
      paramCanvas.drawBitmap(localBitmap, this.a.b + localFontBitmapInfo.b, this.a.c, localTextPaint);
    }
    this.n.setStrokeWidth(a(2.0F, this.h.getResources()));
    float f = a(55.0F, this.h.getResources());
    paramCanvas.drawLine(0.0F, f, ((Integer)this.g.get(this.c)).intValue(), f, this.n);
    paramArrayList = this.b.g.iterator();
    while (paramArrayList.hasNext())
    {
      localFontBitmapInfo = (FontBitmapInfo)paramArrayList.next();
      localBitmap = localFontBitmapInfo.a;
      localTextPaint = this.b.a;
      localTextPaint.setAlpha(((Integer)this.g.get(localFontBitmapInfo.c)).intValue());
      paramCanvas.drawBitmap(localBitmap, this.b.b + localFontBitmapInfo.b, this.b.c, localTextPaint);
    }
  }
  
  public String[] a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    if (paramString != null)
    {
      this.j = paramString.optInt("type", 0);
      this.d = paramString.optString("first_line", "");
      this.e = paramString.optString("second_line", "");
    }
    return new String[] { this.d, this.e };
  }
  
  protected void b()
  {
    this.n = new Paint();
    this.n.setAntiAlias(true);
    this.n.setDither(true);
    this.n.setColor(-1);
    this.o = new TextPaint();
    this.o.setAntiAlias(true);
    this.o.setDither(true);
    this.o.setColor(-1);
    Object localObject = this.h.getAssets();
    try
    {
      localTypeface = Typeface.createFromAsset((AssetManager)localObject, "info_sticker_typeface/roboto-medium.ttf");
    }
    catch (Exception localException1)
    {
      Typeface localTypeface;
      label88:
      break label88;
    }
    localTypeface = Typeface.DEFAULT;
    try
    {
      localObject = Typeface.createFromAsset((AssetManager)localObject, "info_sticker_typeface/roboto-regular.ttf");
    }
    catch (Exception localException2)
    {
      label102:
      break label102;
    }
    localObject = Typeface.DEFAULT;
    this.a = a(this.d, a(48.0F, this.h.getResources()), -1, 0, 0, 0, 600, localTypeface, this.f, 0);
    this.c = this.f.a("", 300L, 500L, 0, this.a.f, new LinearInterpolator());
    this.b = a(this.e, a(11.0F, this.h.getResources()), -1, 0, a(60.0F, this.h.getResources()), 500, 800, (Typeface)localObject, this.f, this.a.f - 10);
  }
  
  public int getIntrinsicHeight()
  {
    return a(75.0F, this.h.getResources());
  }
  
  public int getIntrinsicWidth()
  {
    return this.a.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.RandomTextDrawable
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class EaseInLocationStickerDrawable
  extends InfoStickerDrawable
{
  private String A = null;
  private String B = null;
  private Rect C;
  private RectF D;
  Bitmap a = null;
  Paint b = null;
  TextPaint c = null;
  private String d = HardCodeUtil.a(2064187678);
  private String e = "DEC 06 15:39";
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private int q = 0;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  private int x = 0;
  private Typeface y = null;
  private Typeface z = null;
  
  public EaseInLocationStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    e();
  }
  
  private int a(int paramInt)
  {
    return (this.o - paramInt) / 2;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      localJSONObject.put("icon_path", paramString3);
      localJSONObject.put("font_path", paramString4);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EaseInLocationStickerDrawable", 2, paramString1, new Object[0]);
      }
      paramString1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EaseInLocationStickerDrawable", 2, paramString1);
    }
    return paramString1;
  }
  
  public String a()
  {
    return this.B;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i = a(this.g, this.u, 255);
    this.b.setAlpha(i);
    int j = a((int)this.D.width());
    this.D.set(j, 0.0F, j + a(8.5F, this.h.getResources()), a(11.5F, this.h.getResources()));
    PerLineFontBitmapsInfo.a(i, this.b);
    paramCanvas.drawBitmap(this.a, this.C, this.D, this.b);
    i = this.a.getHeight() + a(6.0F, this.h.getResources());
    this.c.setTypeface(this.y);
    j = a(this.g, this.v, 255);
    this.c.setAlpha(j);
    this.c.setTextSize(a(16.0F, this.h.getResources()));
    float f1 = Math.abs(this.c.getFontMetrics().ascent);
    PerLineFontBitmapsInfo.a(j, this.c);
    paramCanvas.drawText(this.d, a(this.q), i + f1, this.c);
    int k = a(16.0F, this.h.getResources());
    j = a(this.g, this.x, 255);
    i = i + k + a(6.0F, this.h.getResources());
    this.b.setAlpha(j);
    PerLineFontBitmapsInfo.a(j, this.c);
    f1 = a(this.n);
    float f2 = i;
    paramCanvas.drawLine(f1, f2, a(this.n) + this.n, f2, this.b);
    j = a(this.g, this.w, 255);
    k = a(6.0F, this.h.getResources());
    this.c.setTypeface(this.z);
    this.c.setAlpha(j);
    this.c.setTextSize(a(9.0F, this.h.getResources()));
    f1 = Math.abs(this.c.getFontMetrics().ascent);
    PerLineFontBitmapsInfo.a(j, this.c);
    paramCanvas.drawText(this.e, a(this.s), i + k + f1, this.c);
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
      this.A = paramString.optString("font_path", "");
      this.B = paramString.optString("icon_path", "");
    }
    return new String[] { this.d, this.e, this.A, this.B };
  }
  
  protected void b()
  {
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setDither(true);
    this.b.setColor(-1);
    if (new File(this.B).exists()) {
      this.a = BitmapFactory.decodeFile(this.B);
    }
    if (this.a == null) {
      this.a = BitmapFactory.decodeResource(this.h.getResources(), 2130841164);
    }
    this.c = new TextPaint();
    this.c.setAntiAlias(true);
    this.c.setDither(true);
    this.c.setColor(-1);
    this.n = a(36.0F, this.h.getResources());
    this.c.setTextSize(a(16.0F, this.h.getResources()));
    TextPaint localTextPaint = this.c;
    String str = this.d;
    this.q = ((int)localTextPaint.measureText(str, 0, str.length()));
    this.r = a(36.0F, this.h.getResources());
    this.c.setTextSize(a(9.0F, this.h.getResources()));
    localTextPaint = this.c;
    str = this.e;
    this.s = ((int)localTextPaint.measureText(str, 0, str.length()));
    this.t = a(9.0F, this.h.getResources());
    this.C = new Rect(0, 0, this.a.getWidth(), this.a.getHeight());
    this.D = new RectF(0.0F, 0.0F, a(8.5F, this.h.getResources()), a(11.5F, this.h.getResources()));
    this.o = Math.max(Math.max(this.n, this.q), this.s);
    this.p = ((int)(this.D.height() + this.r + this.t + a(19.0F, this.h.getResources())));
    this.z = Typeface.createFromAsset(this.h.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    if (new File(this.A).exists()) {
      try
      {
        this.y = Typeface.createFromFile(this.A);
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.e("EaseInLocationStickerDrawable", 1, "createFromFile fail, ", localRuntimeException);
        this.y = Typeface.DEFAULT_BOLD;
      }
    } else {
      this.y = Typeface.DEFAULT_BOLD;
    }
    this.u = this.f.a("iconAlpha", 20L, 230L, 0, 255, new LinearInterpolator());
    this.v = this.f.a("firstLineAlpha", 120L, 230L, 0, 255, new LinearInterpolator());
    this.x = this.f.a("lineAlpha", 220L, 230L, 0, 255, new LinearInterpolator());
    this.w = this.f.a("secondLineAlpha", 330L, 230L, 0, 255, new LinearInterpolator());
  }
  
  public String c()
  {
    return this.A;
  }
  
  public int getIntrinsicHeight()
  {
    return this.p;
  }
  
  public int getIntrinsicWidth()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.EaseInLocationStickerDrawable
 * JD-Core Version:    0.7.0.1
 */
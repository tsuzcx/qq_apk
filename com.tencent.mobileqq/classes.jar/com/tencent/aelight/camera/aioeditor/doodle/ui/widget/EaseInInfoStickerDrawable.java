package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class EaseInInfoStickerDrawable
  extends InfoStickerDrawable
{
  private float A = 0.0F;
  private float B = 0.0F;
  private Paint a = new Paint();
  private TextPaint b = new TextPaint();
  private Rect c = new Rect();
  private int d = 0;
  private int e = 0;
  private PorterDuffXfermode n = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private Path o = new Path();
  private Typeface p = null;
  private Typeface q = null;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private String x = "27";
  private String y = "OCT";
  private String z = "2017";
  
  public EaseInInfoStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(this.i);
    b();
    e();
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      localJSONObject.put("third_line", paramString3);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EaseInInfoStickerDrawable", 2, paramString1, new Object[0]);
      }
      paramString1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EaseInInfoStickerDrawable", 2, paramString1);
    }
    return paramString1;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i = a(8.5F, this.h.getResources()) + 0;
    this.b.setTypeface(this.p);
    this.b.setTextSize(a(49.0F, this.h.getResources()));
    float f1 = Math.abs(this.b.getFontMetrics().ascent);
    if (Build.VERSION.SDK_INT >= 21) {
      this.b.setLetterSpacing(0.0F);
    }
    Object localObject = this.b;
    String str = this.x;
    this.B = ((TextPaint)localObject).measureText(str, 0, str.length());
    this.b.setAlpha(((Integer)paramArrayList.get(this.r)).intValue());
    PerLineFontBitmapsInfo.a(((Integer)paramArrayList.get(this.r)).intValue(), this.b);
    localObject = this.x;
    paramCanvas.drawText((String)localObject, 0, ((String)localObject).length(), (this.c.width() - this.B) / 2.0F, i + f1, this.b);
    i = i + a(49.0F, this.h.getResources()) + a(12.5F, this.h.getResources());
    this.a.setColor(-1);
    this.a.setStrokeWidth(a(2.0F, this.h.getResources()));
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    f1 = this.A;
    float f2 = i;
    paramCanvas.drawLine(f1, f2, f1 + ((Integer)paramArrayList.get(this.s)).intValue(), f2, this.a);
    if (Build.VERSION.SDK_INT >= 21) {
      if (((Integer)paramArrayList.get(this.s)).intValue() == (int)(this.c.width() - this.A * 2.0F)) {
        this.a.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      } else {
        this.a.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
      }
    }
    i += a(10.0F, this.h.getResources());
    this.b.setTextSize(a(19.0F, this.h.getResources()));
    f1 = Math.abs(this.b.getFontMetrics().ascent);
    if (Build.VERSION.SDK_INT >= 21) {
      this.b.setLetterSpacing(0.1F);
    }
    localObject = this.b;
    str = this.y;
    this.B = ((TextPaint)localObject).measureText(str, 0, str.length());
    this.b.setTypeface(this.q);
    this.b.setTextSize(a(19.0F, this.h.getResources()));
    this.b.setAlpha(((Integer)paramArrayList.get(this.t)).intValue());
    PerLineFontBitmapsInfo.a(((Integer)paramArrayList.get(this.t)).intValue(), this.b);
    localObject = this.y;
    paramCanvas.drawText((String)localObject, 0, ((String)localObject).length(), (this.c.width() - this.B) / 2.0F, i + f1, this.b);
    int j = a(10.0F, this.h.getResources());
    int k = a(9.0F, this.h.getResources());
    this.b.setTypeface(this.q);
    this.b.setTextSize(a(19.0F, this.h.getResources()));
    f1 = Math.abs(this.b.getFontMetrics().ascent);
    if (Build.VERSION.SDK_INT >= 21) {
      this.b.setLetterSpacing(0.0F);
    }
    localObject = this.b;
    str = this.z;
    this.B = ((TextPaint)localObject).measureText(str, 0, str.length());
    this.b.setAlpha(((Integer)paramArrayList.get(this.u)).intValue());
    PerLineFontBitmapsInfo.a(((Integer)paramArrayList.get(this.u)).intValue(), this.b);
    localObject = this.z;
    paramCanvas.drawText((String)localObject, 0, ((String)localObject).length(), (this.c.width() - this.B) / 2.0F, i + j + k + f1, this.b);
    i = paramCanvas.saveLayer(0.0F, 0.0F, this.c.width(), this.c.height(), this.a, 31);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(a(3.0F, this.h.getResources()));
    paramCanvas.drawRect(this.c, this.a);
    this.a.setXfermode(this.n);
    this.a.setColor(-65536);
    this.a.setStrokeWidth(a(3.0F, this.h.getResources()));
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.o.reset();
    this.o.moveTo(this.c.width(), this.c.height());
    this.o.lineTo(this.c.width(), ((Integer)paramArrayList.get(this.w)).intValue());
    this.o.lineTo(((Integer)paramArrayList.get(this.v)).intValue(), this.c.height());
    this.o.close();
    if (Build.VERSION.SDK_INT >= 21) {
      if ((this.c.width() == this.v) && (this.c.height() == this.w)) {
        this.a.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      } else {
        this.a.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
      }
    }
    paramCanvas.drawPath(this.o, this.a);
    this.a.setXfermode(null);
    paramCanvas.restoreToCount(i);
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
      this.x = paramString.optString("first_line", "");
      this.y = paramString.optString("second_line", "");
      this.z = paramString.optString("third_line", "");
    }
    return new String[] { this.x, this.y, this.z };
  }
  
  protected void b()
  {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setDither(true);
    this.a.setColor(-1);
    this.b = new TextPaint();
    this.b.setAntiAlias(true);
    this.b.setDither(true);
    this.b.setColor(-1);
    this.d = a(70.0F, this.h.getResources());
    this.e = a(130.0F, this.h.getResources());
    this.c = new Rect(0, 0, this.d, this.e);
    try
    {
      this.p = Typeface.createFromAsset(this.h.getResources().getAssets(), "info_sticker_typeface/roboto-medium.ttf");
    }
    catch (Exception localException1)
    {
      label148:
      label178:
      break label148;
    }
    this.p = Typeface.DEFAULT;
    try
    {
      this.q = Typeface.createFromAsset(this.h.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    }
    catch (Exception localException2)
    {
      break label178;
    }
    this.q = Typeface.DEFAULT;
    this.v = this.f.a("X", 0L, 700L, -this.c.width(), this.c.width(), new LinearInterpolator());
    this.w = this.f.a("Y", 0L, 700L, -this.c.height(), this.c.height(), new LinearInterpolator());
    this.r = this.f.a("firstFont", 500L, 200L, 0, 255, new LinearInterpolator());
    this.A = a(10.0F, this.h.getResources());
    this.s = this.f.a("secondLine", 600L, 400L, 0, (int)(this.c.width() - this.A * 2.0F), new LinearInterpolator());
    this.t = this.f.a("thirdFont", 800L, 500L, 0, 255, new LinearInterpolator());
    this.u = this.f.a("fourthFont", 900L, 500L, 0, 255, new LinearInterpolator());
  }
  
  public int getIntrinsicHeight()
  {
    return this.e;
  }
  
  public int getIntrinsicWidth()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.EaseInInfoStickerDrawable
 * JD-Core Version:    0.7.0.1
 */
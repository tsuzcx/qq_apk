package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class Left2RightInfoStickerDrawable
  extends InfoStickerDrawable
{
  int a = 0;
  int b = 0;
  int c = 0;
  int d = 0;
  int e = 0;
  int n = 0;
  int o = 0;
  int p = 0;
  private String q = "15:29";
  private String r = HardCodeUtil.a(2064187683);
  private Paint s = new Paint();
  private TextPaint t = new TextPaint();
  private Xfermode u = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private Typeface v = null;
  private Typeface w = null;
  private String x = null;
  
  public Left2RightInfoStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
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
      localJSONObject.put("font_path", paramString3);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Left2RightInfoStickerDrawable", 2, paramString1, new Object[0]);
      }
      paramString1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Left2RightInfoStickerDrawable", 2, paramString1);
    }
    return paramString1;
  }
  
  public String a()
  {
    return this.q;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int j = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicHeight(), this.s, 31);
    int k = a(2.0F, this.h.getResources());
    this.t.setColor(-1);
    this.t.setTextSize(a(30.0F, this.h.getResources()));
    this.t.setTypeface(this.v);
    float f1 = Math.abs(this.t.getFontMetrics().ascent);
    int i;
    if (this.g.size() > this.p) {
      i = ((Integer)this.g.get(this.p)).intValue();
    } else {
      i = 0;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      if (i == 0) {
        this.t.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      } else {
        this.t.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
      }
    }
    paramCanvas.drawText(this.q, a(7.0F, this.h.getResources()) + i, k + f1, this.t);
    int m = a(6.0F, this.h.getResources());
    this.t.setTypeface(this.w);
    this.t.setTextSize(a(12.0F, this.h.getResources()));
    float f2 = Math.abs(this.t.getFontMetrics().ascent);
    paramCanvas.drawText(this.r, a(7.0F, this.h.getResources()) + i, k + m + (f1 + f2), this.t);
    this.t.setXfermode(this.u);
    this.t.setColor(-1);
    this.t.setStyle(Paint.Style.FILL_AND_STROKE);
    paramCanvas.drawRect(i, 0.0F, a(5.0F, this.h.getResources()), this.b, this.t);
    this.t.setXfermode(null);
    this.s.setColor(-15322);
    paramCanvas.drawLine(a(2.0F, this.h.getResources()), a(8.0F, this.h.getResources()), a(2.0F, this.h.getResources()), ((Integer)this.g.get(this.o)).intValue(), this.s);
    paramCanvas.restoreToCount(j);
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
      this.q = paramString.optString("first_line", "");
      this.r = paramString.optString("second_line", "");
      this.x = paramString.optString("font_path", "");
    }
    return new String[] { this.q, this.r, this.x };
  }
  
  protected void b()
  {
    this.s = new Paint();
    this.s.setAntiAlias(true);
    this.s.setDither(true);
    this.s.setStrokeWidth(a(2.0F, this.h.getResources()));
    this.s.setStrokeCap(Paint.Cap.ROUND);
    this.s.setColor(-15322);
    this.t = new TextPaint();
    this.t.setAntiAlias(true);
    this.t.setDither(true);
    this.t.setColor(-1);
    this.w = Typeface.createFromAsset(this.h.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    if (new File(this.x).exists()) {}
    try
    {
      this.v = Typeface.createFromFile(this.x);
    }
    catch (Exception localException)
    {
      label152:
      Object localObject;
      String str;
      break label152;
    }
    this.v = Typeface.DEFAULT_BOLD;
    break label169;
    this.v = Typeface.DEFAULT_BOLD;
    label169:
    this.t.setTextSize(a(30.0F, this.h.getResources()));
    localObject = this.t.getFontMetrics();
    this.d = ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top));
    localObject = this.t;
    str = this.q;
    this.c = ((int)((TextPaint)localObject).measureText(str, 0, str.length()));
    this.t.setTextSize(a(12.0F, this.h.getResources()));
    localObject = this.t.getFontMetrics();
    this.n = ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top));
    localObject = this.t;
    str = this.r;
    this.n = ((int)((TextPaint)localObject).measureText(str, 0, str.length()));
    this.a = (Math.max(this.c, this.n) + a(7.0F, this.h.getResources()));
    this.b = (a(30.0F, this.h.getResources()) + a(12.0F, this.h.getResources()) + a(10.0F, this.h.getResources()));
    this.o = this.f.a("lineHeight", 20L, 200L, 0, this.b - a(5.0F, this.h.getResources()), new LinearInterpolator());
    this.p = this.f.a("offsetX", 180L, 330L, -this.a, 0, new LinearInterpolator());
  }
  
  public String c()
  {
    return this.x;
  }
  
  public int getIntrinsicHeight()
  {
    return this.b;
  }
  
  public int getIntrinsicWidth()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.Left2RightInfoStickerDrawable
 * JD-Core Version:    0.7.0.1
 */
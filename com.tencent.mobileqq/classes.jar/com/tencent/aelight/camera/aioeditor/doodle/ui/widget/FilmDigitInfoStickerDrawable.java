package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class FilmDigitInfoStickerDrawable
  extends InfoStickerDrawable
{
  int a = 0;
  int b = 0;
  int c = 0;
  int d = 0;
  int e;
  private String n = "15:29";
  private TextPaint o = new TextPaint();
  
  public FilmDigitInfoStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    e();
  }
  
  public static String a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString);
      paramString = localJSONObject.toString();
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FilmDigitInfoStickerDrawable", 2, paramString, new Object[0]);
      }
      paramString = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FilmDigitInfoStickerDrawable", 2, paramString);
    }
    return paramString;
  }
  
  public String a()
  {
    return this.n;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicWidth(), this.o, 31);
    int j = a(2.0F, this.h.getResources());
    float f1 = Math.abs(this.o.getFontMetrics().ascent);
    float f2 = ((Integer)paramArrayList.get(this.e)).intValue() % 100 * 1.0F / 99.0F;
    this.o.setShadowLayer(f2 * 20.0F, 0.0F, 0.0F, this.h.getResources().getColor(2063794250));
    paramCanvas.drawText(this.n, a(7.0F, this.h.getResources()), j + f1, this.o);
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
      String str = paramString.optString("first_line", "");
      paramString = str;
      if (str.contains("·")) {
        paramString = str.substring(0, str.indexOf("·"));
      }
      this.n = ChnToSpell.b(paramString, 1);
    }
    return new String[] { this.n };
  }
  
  protected void b()
  {
    this.o = new TextPaint();
    this.o.setAntiAlias(true);
    this.o.setDither(true);
    this.o.setColor(this.h.getResources().getColor(2063794249));
    Object localObject = Typeface.createFromAsset(this.h.getResources().getAssets(), "info_sticker_typeface/dov_digital.ttf");
    this.o.setTypeface((Typeface)localObject);
    this.o.setTextSize(a(30.0F, this.h.getResources()));
    localObject = this.o.getFontMetrics();
    this.d = ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top));
    localObject = this.o;
    String str = this.n;
    this.c = ((int)((TextPaint)localObject).measureText(str, 0, str.length()));
    this.a = (this.c + a(7.0F, this.h.getResources()));
    this.b = (a(30.0F, this.h.getResources()) + a(10.0F, this.h.getResources()));
    this.e = this.f.a("anim", 0L, 1000L, 0, 999, new LinearInterpolator());
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
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.FilmDigitInfoStickerDrawable
 * JD-Core Version:    0.7.0.1
 */
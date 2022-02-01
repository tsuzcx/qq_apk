package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.DecelerateInterpolator;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ExpandLocationStickerDrawable
  extends InfoStickerDrawable
{
  private static int s = 30;
  private static int t = 30;
  private Paint a = new Paint();
  private TextPaint b = new TextPaint();
  private Bitmap c;
  private int d = 0;
  private int e = 0;
  private Typeface n = null;
  private int o;
  private int p;
  private String q = "";
  private String r;
  private int u = 0;
  private int v = 0;
  private Rect w = new Rect(0, 0, 0, 0);
  private int x = 16;
  private int y = 16;
  
  public ExpandLocationStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(this.i);
    b();
    e();
  }
  
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("iconpath", paramString1);
      localJSONObject.put("locationString", paramString2);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExpandLocationStickerDrawable", 2, paramString1, new Object[0]);
      }
      paramString1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExpandLocationStickerDrawable", 2, paramString1);
    }
    return paramString1;
  }
  
  public String a()
  {
    return this.q;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int j = s;
    int i = 0;
    int m = j + 0;
    j = t;
    int i1 = ((Integer)paramArrayList.get(this.o)).intValue();
    j += (this.r.length() - 1) * (this.x - i1) / 2;
    int k = ((Integer)paramArrayList.get(this.p)).intValue();
    this.a.setAlpha(k);
    this.b.setAlpha(k);
    PerLineFontBitmapsInfo.a(k, this.b);
    paramArrayList = new Rect(j, a(1.0F, this.h.getResources()) + m, this.v + j, this.u + m + a(1.0F, this.h.getResources()));
    Bitmap localBitmap = this.c;
    if (localBitmap != null) {
      paramCanvas.drawBitmap(localBitmap, this.w, paramArrayList, this.a);
    }
    j = j + this.v + this.y;
    while (i < this.r.length())
    {
      paramArrayList = this.r;
      k = i + 1;
      paramArrayList = paramArrayList.substring(i, k);
      paramCanvas.drawText(paramArrayList, j, this.u + m, this.b);
      j = j + (int)this.b.measureText(paramArrayList) + i1;
      i = k;
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
      this.q = paramString.optString("iconpath", "");
      this.r = paramString.optString("locationString", "");
    }
    return new String[] { this.q, this.r };
  }
  
  protected void b()
  {
    this.a.setAntiAlias(true);
    this.a.setDither(true);
    s = a(15.0F, this.h.getResources());
    t = s;
    this.y = a(10.0F, this.h.getResources());
    this.b.setAntiAlias(true);
    this.b.setDither(true);
    this.b.setColor(-1);
    this.x = a(9.0F, this.h.getResources());
    this.r = InfoStickerUtils.a(this.r);
    Object localObject = this.r;
    if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      this.r = ChnToSpell.b(this.r, 1);
      this.r = this.r.toUpperCase();
    }
    else
    {
      this.r = "YOUR CITY";
    }
    this.n = Typeface.createFromAsset(this.h.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    this.b.setTypeface(this.n);
    this.b.setFakeBoldText(true);
    this.b.setTextSize(a(15.0F, this.h.getResources()));
    localObject = this.b.getFontMetrics();
    if (Build.VERSION.SDK_INT >= 21) {
      this.b.setLetterSpacing(0.0F);
    }
    this.o = this.f.a("X", 190L, 630L, 0, this.x, new DecelerateInterpolator());
    this.p = this.f.a("T", 190L, 2110L, 0, 255, new DecelerateInterpolator());
    if (FileUtils.fileExists(this.q)) {
      this.c = BitmapFactory.decodeFile(this.q);
    } else {
      QLog.e("ExpandLocationStickerDrawable", 2, "mIconPath not exist");
    }
    Bitmap localBitmap = this.c;
    int i;
    int j;
    if (localBitmap != null)
    {
      i = localBitmap.getWidth();
      j = this.c.getHeight();
    }
    else
    {
      i = 0;
      j = 0;
    }
    this.w = new Rect(0, 0, i, j);
    this.u = (-(int)((Paint.FontMetrics)localObject).ascent - (int)((Paint.FontMetrics)localObject).descent + a(3.0F, this.h.getResources()));
    if (j != 0) {
      this.v = (this.u * i / j);
    }
    this.e = (this.u + s * 2);
    float f = this.b.measureText(this.r);
    this.d = (this.v + t * 2 + this.y + (int)f + this.x * (this.r.length() - 1) + a(3.0F, this.h.getResources()));
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
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.ExpandLocationStickerDrawable
 * JD-Core Version:    0.7.0.1
 */
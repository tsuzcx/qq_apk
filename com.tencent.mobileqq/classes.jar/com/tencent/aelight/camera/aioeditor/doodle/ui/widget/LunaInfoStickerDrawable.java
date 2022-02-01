package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class LunaInfoStickerDrawable
  extends InfoStickerDrawable
{
  private String A = HardCodeUtil.a(2064187687);
  private String B = HardCodeUtil.a(2064187685);
  private String C = HardCodeUtil.a(2064187686);
  private int D = 0;
  private int E = 0;
  private int F = 0;
  private Typeface G = null;
  private String H = null;
  private String I = null;
  private String J = null;
  private PorterDuffXfermode K = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private PorterDuffXfermode L = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
  private float M = 0.0F;
  PerLineFontBitmapsInfo a;
  PerLineFontBitmapsInfo b;
  int c = 0;
  int d = 0;
  private int e;
  private int n;
  private Bitmap o;
  private Rect p = null;
  private RectF q = null;
  private Rect r = null;
  private Rect s = null;
  private RectF t = null;
  private Rect u = null;
  private Bitmap v;
  private Paint w = new Paint();
  private Paint x = new Paint();
  private TextPaint y = new TextPaint();
  private String z = HardCodeUtil.a(2064187684);
  
  public LunaInfoStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    e();
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      localJSONObject.put("third_line", paramString3);
      localJSONObject.put("fourth_line", paramString4);
      localJSONObject.put("font_file_name", paramString5);
      localJSONObject.put("out_side_border", paramString6);
      localJSONObject.put("in_side_border", paramString7);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LunaInfoStickerDrawable", 2, paramString1, new Object[0]);
      }
      paramString1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LunaInfoStickerDrawable", 2, paramString1);
    }
    return paramString1;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    try
    {
      int i = a(8.5F, this.h.getResources()) + 0;
      this.y.setTypeface(this.G);
      this.y.setTextSize(a(45.0F, this.h.getResources()));
      float f1 = Math.abs(this.y.getFontMetrics().ascent);
      this.M = this.y.measureText(this.z, 0, this.z.length());
      this.y.setAlpha(((Integer)paramArrayList.get(this.D)).intValue());
      PerLineFontBitmapsInfo.a(((Integer)paramArrayList.get(this.D)).intValue(), this.y);
      paramCanvas.drawText(this.z, 0, this.z.length(), (this.q.width() - this.M) / 2.0F, i + f1, this.y);
      i = i + a(45.0F, this.h.getResources()) + a(8.5F, this.h.getResources());
      this.y.setTypeface(this.G);
      this.y.setTextSize(a(45.0F, this.h.getResources()));
      if (Build.VERSION.SDK_INT >= 21) {
        this.y.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      }
      f1 = Math.abs(this.y.getFontMetrics().ascent);
      this.M = this.y.measureText(this.A, 0, this.A.length());
      this.y.setAlpha(((Integer)paramArrayList.get(this.E)).intValue());
      PerLineFontBitmapsInfo.a(((Integer)paramArrayList.get(this.E)).intValue(), this.y);
      paramCanvas.drawText(this.A, 0, this.A.length(), (this.q.width() - this.M) / 2.0F, i + f1, this.y);
      i = i + a(45.0F, this.h.getResources()) + a(8.5F, this.h.getResources());
      this.w.setColor(-1);
      this.w.setStrokeWidth(a(2.0F, this.h.getResources()));
      this.w.setStyle(Paint.Style.FILL_AND_STROKE);
      int j = (int)((this.q.width() - this.M) / 2.0F);
      PerLineFontBitmapsInfo.a(((Integer)paramArrayList.get(this.F)).intValue(), this.w);
      if (((Integer)paramArrayList.get(this.F)).intValue() == a(45.0F, this.h.getResources())) {
        this.w.setShadowLayer(1.0F, 1.0F, 1.0F, -1728053248);
      } else {
        this.w.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
      }
      f1 = j;
      float f2 = i;
      paramCanvas.drawLine(f1, f2, j + ((Integer)paramArrayList.get(this.F)).intValue(), f2, this.w);
      i += a(8.5F, this.h.getResources());
      localObject = this.a.g.iterator();
      FontBitmapInfo localFontBitmapInfo;
      Bitmap localBitmap;
      TextPaint localTextPaint;
      while (((Iterator)localObject).hasNext())
      {
        localFontBitmapInfo = (FontBitmapInfo)((Iterator)localObject).next();
        localBitmap = localFontBitmapInfo.a;
        localTextPaint = this.a.a;
        localTextPaint.setAlpha(((Integer)paramArrayList.get(localFontBitmapInfo.c)).intValue());
        this.M = localTextPaint.measureText(this.B, 0, this.B.length());
        paramCanvas.drawBitmap(localBitmap, (this.q.width() - this.M) / 2.0F + this.a.b + localFontBitmapInfo.b, this.a.c + i, localTextPaint);
      }
      j = a(14.0F, this.h.getResources());
      int k = a(8.5F, this.h.getResources());
      localObject = this.b.g.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localFontBitmapInfo = (FontBitmapInfo)((Iterator)localObject).next();
        localBitmap = localFontBitmapInfo.a;
        localTextPaint = this.b.a;
        localTextPaint.setAlpha(((Integer)paramArrayList.get(localFontBitmapInfo.c)).intValue());
        this.M = localTextPaint.measureText(this.C, 0, this.C.length());
        paramCanvas.drawBitmap(localBitmap, (this.q.width() - this.M) / 2.0F + this.b.b + localFontBitmapInfo.b, this.b.c + (i + j + k), localTextPaint);
      }
      if (paramArrayList != null)
      {
        i = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicHeight(), this.w, 31);
        if (this.o != null) {
          paramCanvas.drawBitmap(this.o, this.p, this.q, this.w);
        }
        this.w.setXfermode(this.K);
        this.w.setColor(-65536);
        this.w.setStyle(Paint.Style.FILL_AND_STROKE);
        this.r.set(0, ((Integer)paramArrayList.get(this.c)).intValue(), a(88.0F, this.h.getResources()), a(180.0F, this.h.getResources()));
        paramCanvas.drawRect(this.r, this.w);
        this.w.setXfermode(null);
        paramCanvas.restoreToCount(i);
        i = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicHeight(), this.x, 31);
        if (this.v != null) {
          paramCanvas.drawBitmap(this.v, this.s, this.t, this.x);
        }
        this.x.setXfermode(this.L);
        this.x.setColor(-65536);
        this.x.setStyle(Paint.Style.FILL_AND_STROKE);
        this.u.set(this.e, this.n, this.e + a(77.5F, this.h.getResources()), this.n + ((Integer)paramArrayList.get(this.d)).intValue());
        paramCanvas.drawRect(this.u, this.x);
        this.x.setXfermode(null);
        paramCanvas.restoreToCount(i);
        return;
      }
    }
    catch (Exception paramCanvas)
    {
      Object localObject = new StringBuilder(128);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ((StringBuilder)localObject).append((Integer)paramArrayList.next());
        ((StringBuilder)localObject).append(" ");
      }
      paramArrayList = new StringBuilder();
      paramArrayList.append("mFourthLineInfo draw fail, ");
      paramArrayList.append(((StringBuilder)localObject).toString());
      QLog.e("LunaInfoStickerDrawable", 1, paramArrayList.toString(), paramCanvas);
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
      this.z = paramString.optString("first_line", "");
      this.A = paramString.optString("second_line", "");
      this.B = paramString.optString("third_line", "");
      this.C = paramString.optString("fourth_line", "");
      this.H = paramString.optString("font_file_name", "");
      this.I = paramString.optString("out_side_border", "");
      this.J = paramString.optString("in_side_border", "");
    }
    return new String[] { this.z, this.A, this.B, this.C, this.H, this.I, this.J };
  }
  
  protected void b()
  {
    if (new File(this.I).exists()) {
      this.o = BitmapFactory.decodeFile(this.I);
    }
    Object localObject = this.o;
    if (localObject != null) {
      this.p = new Rect(0, 0, ((Bitmap)localObject).getWidth(), this.o.getHeight());
    }
    this.q = new RectF(0.0F, 0.0F, a(88.0F, this.h.getResources()), a(180.0F, this.h.getResources()));
    if (new File(this.J).exists()) {
      this.v = BitmapFactory.decodeFile(this.J);
    }
    localObject = this.v;
    if (localObject != null) {
      this.s = new Rect(0, 0, ((Bitmap)localObject).getWidth(), this.v.getHeight());
    }
    this.t = new RectF(0.0F, 0.0F, a(77.5F, this.h.getResources()), a(169.0F, this.h.getResources()));
    this.r = new Rect(0, 0, a(88.0F, this.h.getResources()), a(180.0F, this.h.getResources()));
    this.c = this.f.a("out", 0L, 500L, 0, a(180.0F, this.h.getResources()), new LinearInterpolator());
    this.e = ((int)((this.q.width() - this.t.width()) / 2.0F));
    this.n = ((int)((this.q.height() - this.t.height()) / 2.0F));
    int i = this.e;
    this.t = new RectF(i, this.n, i + a(77.5F, this.h.getResources()), this.n + a(169.0F, this.h.getResources()));
    i = this.e;
    this.u = new Rect(i, this.n, a(77.5F, this.h.getResources()) + i, this.n + a(169.0F, this.h.getResources()));
    this.d = this.f.a("in", 150L, 700L, a(180.0F, this.h.getResources()), 0, new LinearInterpolator());
    this.D = this.f.a("firstFont", 500L, 200L, 0, 255, new LinearInterpolator());
    this.E = this.f.a("SecondFont", 600L, 200L, 0, 255, new LinearInterpolator());
    this.F = this.f.a("thirdLine", 700L, 200L, 0, a(45.0F, this.h.getResources()), new LinearInterpolator());
    if (new File(this.H).exists()) {}
    try
    {
      this.G = Typeface.createFromFile(this.H);
      this.y.setTypeface(this.G);
      localObject = this.y.getFontMetrics();
      if ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) <= 0) {
        this.G = Typeface.DEFAULT;
      }
      this.y.setTypeface(Typeface.DEFAULT);
    }
    catch (Exception localException)
    {
      label663:
      break label663;
    }
    this.G = Typeface.DEFAULT;
    break label680;
    this.G = Typeface.DEFAULT;
    label680:
    this.a = PerLineFontBitmapsInfo.a(this.B, a(15.0F, this.h.getResources()), -1, 0, 0, 700, 500, this.G, this.f);
    this.b = PerLineFontBitmapsInfo.a(this.C, a(15.0F, this.h.getResources()), -1, 0, 0, 1100, 300, this.G, this.f);
    this.w = new Paint();
    this.w.setAntiAlias(true);
    this.w.setDither(true);
    this.w.setColor(-1);
    this.x = new Paint();
    this.x.setAntiAlias(true);
    this.x.setDither(true);
    this.x.setColor(-1);
    this.y = new TextPaint();
    this.y.setAntiAlias(true);
    this.y.setDither(true);
    this.y.setColor(-1);
  }
  
  public int getIntrinsicHeight()
  {
    return a(180.0F, this.h.getResources());
  }
  
  public int getIntrinsicWidth()
  {
    return a(88.0F, this.h.getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.LunaInfoStickerDrawable
 * JD-Core Version:    0.7.0.1
 */
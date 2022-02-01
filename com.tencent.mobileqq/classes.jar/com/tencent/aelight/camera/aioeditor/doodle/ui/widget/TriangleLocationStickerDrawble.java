package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class TriangleLocationStickerDrawble
  extends InfoStickerDrawable
{
  private static int C = 30;
  private static int D = 30;
  private String A = HardCodeUtil.a(2064187694);
  private String B = "SHENZHEN";
  private int E = 0;
  private int F = 0;
  private Rect G = new Rect(0, 0, 0, 0);
  private int H = 0;
  private int I = 8;
  private int J = 4;
  private int K = 0;
  private int L = 0;
  private int M = 0;
  private Bitmap N = null;
  private int O = 0;
  private Paint a = new Paint();
  private TextPaint b = new TextPaint();
  private TextPaint c = new TextPaint();
  private Bitmap d;
  private Bitmap e;
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private int q = 0;
  private Typeface r = null;
  private Typeface s = null;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private String y = "";
  private String z = "";
  
  public TriangleLocationStickerDrawble(Context paramContext, String paramString)
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
      localJSONObject.put("iconpath", paramString1);
      localJSONObject.put("ttfpath", paramString2);
      localJSONObject.put("locationString", paramString3);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TriangleLocationStickerDrawble", 2, paramString1, new Object[0]);
      }
      paramString1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TriangleLocationStickerDrawble", 2, paramString1);
    }
    return paramString1;
  }
  
  public String a()
  {
    return this.y;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i = ((Integer)paramArrayList.get(this.t)).intValue();
    this.a.setAlpha(i);
    int j = ((Integer)paramArrayList.get(this.w)).intValue();
    i = 0;
    if (j != 0)
    {
      k = this.q;
      double d1 = j * k;
      Double.isNaN(d1);
      i = (int)(d1 / 100.0D);
      localObject1 = new Rect((k - i) / 2, 0, (k + i) / 2, this.O);
      j = this.n;
      k = (j - i) / 2;
      m = C;
      localObject2 = new Rect(k, m, (j + i) / 2, this.O + m);
      paramCanvas.drawBitmap(this.N, (Rect)localObject1, (Rect)localObject2, this.a);
      i = ((Integer)paramArrayList.get(this.x)).intValue() + i / 2;
    }
    int k = ((Integer)paramArrayList.get(this.u)).intValue();
    j = k;
    if (k == this.L) {
      j = ((Integer)paramArrayList.get(this.v)).intValue();
    }
    j = this.p - j - this.E - a(1.0F, this.h.getResources());
    int i1 = this.n;
    int m = i1 / 2;
    k = this.F;
    m = m - k - i;
    i = i1 / 2 + i;
    i1 = C;
    Object localObject1 = new Rect(m, j + i1, k + m, this.E + j + i1);
    k = C;
    paramArrayList = new Rect(i, j + k, this.F + i, j + this.E + k);
    Object localObject2 = this.d;
    if (localObject2 != null) {
      paramCanvas.drawBitmap((Bitmap)localObject2, this.G, (Rect)localObject1, this.a);
    }
    localObject1 = this.e;
    if (localObject1 != null) {
      paramCanvas.drawBitmap((Bitmap)localObject1, this.G, paramArrayList, this.a);
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
      this.y = paramString.optString("iconpath", "");
      this.z = paramString.optString("ttfpath", "");
      this.A = paramString.optString("locationString", "");
    }
    return new String[] { this.y, this.z, this.A };
  }
  
  protected void b()
  {
    this.A = InfoStickerUtils.a(this.A);
    Object localObject1 = this.A;
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      this.B = ChnToSpell.b(this.A, 1);
      this.B = this.B.toUpperCase();
      localObject1 = this.A;
      if ((localObject1 != null) && (!((String)localObject1).contains(HardCodeUtil.a(2064187696))) && (!this.A.contains(HardCodeUtil.a(2064187695))) && (!this.A.endsWith(HardCodeUtil.a(2064187690))) && (!this.A.endsWith(HardCodeUtil.a(2064187691))))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.A);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2064187693));
        this.A = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      this.A = HardCodeUtil.a(2064187692);
      this.B = "YOUR CITY";
    }
    localObject1 = this.B;
    if ((localObject1 == null) || (TextUtils.isEmpty((CharSequence)localObject1))) {
      this.B = "YOUR CITY";
    }
    C = a(15.0F, this.h.getResources());
    D = C;
    this.r = Typeface.createFromAsset(this.h.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    if (FileUtils.fileExists(this.z)) {
      this.s = Typeface.createFromFile(this.z);
    } else {
      this.s = Typeface.DEFAULT_BOLD;
    }
    if (this.s == null) {
      this.s = Typeface.createFromAsset(this.h.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
    }
    this.H = a(24.0F, this.h.getResources());
    this.J = a(3.0F, this.h.getResources());
    this.I = a(4.5F, this.h.getResources());
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setDither(true);
    this.b.setAntiAlias(true);
    this.b.setDither(true);
    this.b.setColor(-1);
    this.b.setTypeface(this.s);
    this.b.setTextSize(a(28.0F, this.h.getResources()));
    this.c.setAntiAlias(true);
    this.c.setDither(true);
    this.c.setColor(-1);
    this.c.setTypeface(this.r);
    this.c.setFakeBoldText(true);
    this.c.setTextSize(a(9.0F, this.h.getResources()));
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.b.setShadowLayer(InfoStickerDrawable.m, 0.0F, 0.0F, 1711276032);
      this.c.setShadowLayer(InfoStickerDrawable.m, 0.0F, 0.0F, 1711276032);
    }
    else
    {
      this.b.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
      this.c.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.b.setLetterSpacing(0.0F);
      this.c.setLetterSpacing(0.0F);
    }
    if (FileUtils.fileExists(this.y)) {
      this.e = BitmapFactory.decodeFile(this.y);
    } else {
      QLog.e("TriangleLocationStickerDrawble", 2, "mIconPath not exist");
    }
    localObject1 = this.e;
    int k = 0;
    if (localObject1 != null)
    {
      i = ((Bitmap)localObject1).getWidth();
      j = this.e.getHeight();
      localObject1 = new Matrix();
      ((Matrix)localObject1).setRotate(180.0F, i / 2.0F, j / 2.0F);
      this.d = Bitmap.createBitmap(this.e, 0, 0, i, j, (Matrix)localObject1, true);
    }
    else
    {
      i = 0;
      j = 0;
    }
    this.G = new Rect(0, 0, i, j);
    this.E = a(20.5F, this.h.getResources());
    this.F = a(10.5F, this.h.getResources());
    localObject1 = this.G;
    ((Rect)localObject1).left = 0;
    ((Rect)localObject1).top = 0;
    ((Rect)localObject1).right = i;
    ((Rect)localObject1).bottom = j;
    int i = (int)this.b.measureText(this.A) + this.J * (this.A.length() - 1);
    int i1 = (int)this.c.measureText(this.B) + this.I * (this.B.length() - 1);
    if (i > i1) {
      this.q = i;
    } else {
      this.q = i1;
    }
    this.n = (this.q + (this.F + this.H) * 2 + D * 2);
    localObject1 = this.b.getFontMetrics();
    Object localObject2 = this.c.getFontMetrics();
    this.K = (-(int)((Paint.FontMetrics)localObject1).top);
    int j = -(int)((Paint.FontMetrics)localObject2).top;
    this.L = (a(33.0F, this.h.getResources()) + a(5.0F, this.h.getResources()));
    this.M = (this.L - a(5.0F, this.h.getResources()));
    this.O = (this.K + j + a(4.0F, this.h.getResources()));
    this.o = (this.K + j + a(3.0F, this.h.getResources()) + C * 2);
    this.p = (this.K + this.M + a(5.0F, this.h.getResources()));
    this.t = this.f.a("T", 0L, 165L, 0, 255, new LinearInterpolator());
    this.u = this.f.a("X", 0L, 330L, 0, this.L, new DecelerateInterpolator());
    this.v = this.f.a("X", 330L, 340L, this.L, this.M, new AccelerateInterpolator());
    this.w = this.f.a("X", 825L, 200L, 0, 100, new DecelerateInterpolator());
    this.x = this.f.a("X", 825L, 355L, a(10.0F, this.h.getResources()), a(20.0F, this.h.getResources()), new DecelerateInterpolator());
    if (this.N == null)
    {
      this.N = Bitmap.createBitmap(this.q, this.O, Bitmap.Config.ARGB_8888);
      localObject1 = new Canvas(this.N);
      j = (this.q - i) / 2;
      int m;
      for (i = 0; i < this.A.length(); i = m)
      {
        localObject2 = this.A;
        m = i + 1;
        localObject2 = ((String)localObject2).substring(i, m);
        ((Canvas)localObject1).drawText((String)localObject2, j, this.K, this.b);
        j = j + (int)this.b.measureText((String)localObject2) + this.J;
      }
      i = (this.q - i1) / 2;
      for (j = k; j < this.B.length(); j = k)
      {
        localObject2 = this.B;
        k = j + 1;
        localObject2 = ((String)localObject2).substring(j, k);
        ((Canvas)localObject1).drawText((String)localObject2, i, this.O, this.c);
        i = i + (int)this.c.measureText((String)localObject2) + this.I;
      }
    }
  }
  
  public String c()
  {
    return this.z;
  }
  
  public int getIntrinsicHeight()
  {
    return this.o;
  }
  
  public int getIntrinsicWidth()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.TriangleLocationStickerDrawble
 * JD-Core Version:    0.7.0.1
 */
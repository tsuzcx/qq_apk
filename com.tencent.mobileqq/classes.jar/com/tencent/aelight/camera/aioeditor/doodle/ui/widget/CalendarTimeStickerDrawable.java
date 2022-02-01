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
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class CalendarTimeStickerDrawable
  extends InfoStickerDrawable
{
  private static int e = 0;
  private static int n = 1;
  private static int o = 2;
  private static int p = 3;
  private static int q = 4;
  private static int r = 5;
  private Typeface A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H = 4;
  private int I = 1;
  private int J = 4;
  private int K = 22;
  private int L = 2;
  private int M = 73;
  private int N = 62;
  private int O = 0;
  private int P = 0;
  private int Q;
  private int R;
  private int[] S;
  private int[] T;
  private int[] U;
  private int V = 0;
  private int W;
  private int X = 4;
  private Bitmap Y;
  private Canvas Z;
  private Paint a = new Paint();
  private Bitmap aa;
  private Canvas ab;
  private Bitmap ac;
  private Canvas ad;
  private Bitmap ae;
  private Canvas af;
  private TextPaint b = new TextPaint();
  private int c = 0;
  private int d = 0;
  private String s;
  private String t;
  private String u;
  private String v;
  private Bitmap w;
  private Bitmap x;
  private Bitmap y;
  private Bitmap z;
  
  public CalendarTimeStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(this.i);
    b();
    e();
  }
  
  private Matrix a(int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    int j = this.M;
    arrayOfFloat[2] = j;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = j;
    int i = this.N;
    arrayOfFloat[5] = i;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = i;
    float f1;
    int m;
    int i3;
    int k;
    int i1;
    int i2;
    int i4;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    if (paramInt >= 0)
    {
      if (paramInt < 50)
      {
        f1 = paramInt / 50.0F;
        m = (int)((this.D - j) * f1) + j;
        i3 = this.B;
        paramInt = (i3 - m) / 2;
        k = i3 / 2;
        m /= 2;
        i1 = i3 / 2;
        i2 = j / 2;
        i3 /= 2;
        j /= 2;
        i4 = (int)((1.0F - f1) * i);
        f1 = paramInt;
        f2 = i - i4;
        f3 = k + m;
        f4 = i3 + j;
        f5 = i;
        f6 = i1 - i2;
        paramInt = arrayOfFloat.length / 2;
        localMatrix.setPolyToPoly(arrayOfFloat, 0, new float[] { f1, f2, f3, f2, f4, f5, f6, f5 }, 0, paramInt);
        return localMatrix;
      }
      i = paramInt;
      if (paramInt > 100) {
        i = 100;
      }
      f1 = (i - 50) / 50.0F;
      i1 = this.M;
      double d1 = this.D - i1;
      double d2 = f1;
      Double.isNaN(d2);
      Double.isNaN(d1);
      j = (int)(d1 * (1.0D - d2)) + i1;
      i2 = this.B;
      paramInt = (i2 - j) / 2;
      i = i2 / 2;
      j /= 2;
      k = i2 / 2;
      m = i1 / 2;
      i2 /= 2;
      i1 /= 2;
      i3 = (int)(f1 * this.N);
      f1 = k - m;
      f2 = 0;
      f3 = i2 + i1;
      f4 = i + j;
      f5 = i3;
      f6 = paramInt;
      paramInt = arrayOfFloat.length / 2;
      localMatrix.setPolyToPoly(arrayOfFloat, 0, new float[] { f1, f2, f3, f2, f4, f5, f6, f5 }, 0, paramInt);
      return localMatrix;
    }
    if (paramInt > -50)
    {
      f1 = (paramInt + 50) / 50.0F;
      paramInt = this.E;
      m = paramInt + (int)((j - paramInt) * f1);
      i3 = this.B;
      paramInt = (i3 - m) / 2;
      k = i3 / 2;
      m /= 2;
      i1 = i3 / 2;
      i2 = j / 2;
      i3 /= 2;
      j /= 2;
      i4 = (int)(f1 * i);
      f1 = paramInt;
      f2 = i - i4;
      f3 = k + m;
      f4 = i3 + j;
      f5 = i;
      f6 = i1 - i2;
      paramInt = arrayOfFloat.length / 2;
      localMatrix.setPolyToPoly(arrayOfFloat, 0, new float[] { f1, f2, f3, f2, f4, f5, f6, f5 }, 0, paramInt);
    }
    return localMatrix;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("upFilePath", paramString1);
      localJSONObject.put("downFilePath", paramString2);
      localJSONObject.put("nowHhmm", paramString3);
      localJSONObject.put("lastHhmm", paramString4);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CalendarTimeStickerDrawable", 2, paramString1, new Object[0]);
      }
    }
    return null;
  }
  
  private void a(String paramString, Canvas paramCanvas)
  {
    if (paramString.length() != 4) {
      return;
    }
    Object localObject1 = this.b.getFontMetrics();
    int m = (int)((Paint.FontMetrics)localObject1).descent;
    int i1 = (int)((Paint.FontMetrics)localObject1).top;
    int i2 = a(2.0F, this.h.getResources());
    int i = this.N;
    int k = 0;
    localObject1 = new Rect(0, 0, 0, i);
    i = this.N;
    int j = this.L;
    Rect localRect = new Rect(0, i + j, 0, i * 2 + j);
    Object localObject2 = this.y;
    if (localObject2 != null)
    {
      i = ((Bitmap)localObject2).getWidth();
      j = this.y.getHeight();
    }
    else
    {
      i = 0;
      j = 0;
    }
    localObject2 = new Rect(0, 0, i, j);
    for (i = k; i < 4; i = j)
    {
      j = i + 1;
      String str = paramString.substring(i, j);
      int i3 = (int)this.b.measureText(str);
      k = this.M;
      i3 = (k - i3) / 2;
      int i4 = (this.N + (m - i1 - i2)) / 2;
      ((Rect)localObject1).left = (i * k);
      ((Rect)localObject1).right = (((Rect)localObject1).left + this.M);
      Bitmap localBitmap = this.y;
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, (Rect)localObject2, (Rect)localObject1, this.a);
      }
      localRect.left = ((Rect)localObject1).left;
      localRect.right = ((Rect)localObject1).right;
      localBitmap = this.z;
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, (Rect)localObject2, localRect, this.a);
      }
      paramCanvas.drawText(str, i * k + i3, i4, this.b);
    }
  }
  
  public void a()
  {
    if (this.u.length() != 4) {
      this.u = "0000";
    }
    if (this.v.length() != 4) {
      this.v = "0000";
    }
    int i = 0;
    this.I = 0;
    while (i < 4)
    {
      String str = this.u;
      int j = i + 1;
      if (!str.substring(i, j).equals(this.v.substring(i, j))) {
        this.I += 1;
      }
      i = j;
    }
    if (this.I == 0) {
      this.I = 1;
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int m = ((Integer)paramArrayList.get(this.Q)).intValue();
    this.a.setAlpha(m);
    int i;
    int k;
    if (((Integer)paramArrayList.get(this.R)).intValue() >= 1000)
    {
      i = r;
    }
    else if (m < 255)
    {
      i = e;
    }
    else
    {
      k = 0;
      i = 1;
      while (k < this.I)
      {
        j = i;
        if (((Integer)paramArrayList.get(this.T[k])).intValue() == 100) {
          j = i + 1;
        }
        i = j;
        if (j == this.I + 1) {
          i = r;
        }
        k += 1;
      }
    }
    int j = 0;
    Rect localRect1;
    int i1;
    while (j < 4)
    {
      localRect1 = new Rect(0, 0, 0, 0);
      Rect localRect2 = new Rect(0, 0, 0, 0);
      Rect localRect3 = new Rect(0, 0, 0, this.N);
      k = this.N;
      i1 = this.L;
      Rect localRect4 = new Rect(0, k + i1, 0, k * 2 + i1);
      localRect1.top = (this.J + this.X);
      localRect1.bottom = (localRect1.top + this.N);
      if (j > 1) {
        k = this.K - this.J;
      } else {
        k = 0;
      }
      localRect1.left = ((this.M + this.J) * j + k + this.X);
      k = localRect1.left;
      i1 = this.M;
      localRect1.right = (k + i1);
      localRect3.left = (i1 * j);
      localRect3.right = (localRect3.left + this.M);
      localRect2.top = (this.J + this.N + this.L + this.X);
      localRect2.bottom = (localRect2.top + this.N);
      localRect2.left = localRect1.left;
      localRect2.right = localRect1.right;
      localRect4.left = localRect3.left;
      localRect4.right = localRect3.right;
      k = 3 - j;
      if (i == r)
      {
        paramCanvas.drawBitmap(this.w, localRect3, localRect1, this.a);
        paramCanvas.drawBitmap(this.w, localRect4, localRect2, this.a);
      }
      else if (i == e)
      {
        paramCanvas.drawBitmap(this.x, localRect3, localRect1, this.a);
        paramCanvas.drawBitmap(this.x, localRect4, localRect2, this.a);
      }
      else
      {
        i1 = i - 1;
        if (i1 < k)
        {
          paramCanvas.drawBitmap(this.x, localRect3, localRect1, this.a);
          paramCanvas.drawBitmap(this.x, localRect4, localRect2, this.a);
        }
        else if (i1 > k)
        {
          paramCanvas.drawBitmap(this.w, localRect3, localRect1, this.a);
          paramCanvas.drawBitmap(this.w, localRect4, localRect2, this.a);
        }
        else if (i1 == k)
        {
          k = ((Integer)paramArrayList.get(this.U[k])).intValue();
          if (k > 0)
          {
            this.a.setAlpha(k);
            paramCanvas.drawBitmap(this.x, localRect4, localRect2, this.a);
            this.a.setAlpha(m);
          }
        }
      }
      j += 1;
    }
    if ((i != e) && (i != r))
    {
      k = i - 1;
      j = 3 - k;
      i = ((Integer)paramArrayList.get(this.S[k])).intValue();
      k = ((Integer)paramArrayList.get(this.T[k])).intValue();
      if (i > -50)
      {
        paramArrayList = a(i);
        localRect1 = new Rect(0, 0, 0, this.N);
        localRect1.left = (this.M * j);
        localRect1.right = (localRect1.left + this.M);
        double d1 = i + 50;
        Double.isNaN(d1);
        i1 = (int)(d1 * 255.0D / 50.0D);
        this.Z.drawColor(0, PorterDuff.Mode.CLEAR);
        this.ab.drawColor(0, PorterDuff.Mode.CLEAR);
        this.Z.drawBitmap(this.w, localRect1, new Rect(0, 0, this.M, this.N), this.a);
        this.ab.drawBitmap(this.Y, paramArrayList, this.a);
        paramArrayList = new Rect(0, 0, 0, 0);
        paramArrayList.top = (this.J + this.X);
        paramArrayList.bottom = (paramArrayList.top + this.N);
        if (j > 1) {
          i = this.K - this.J;
        } else {
          i = 0;
        }
        paramArrayList.left = ((this.M + this.J) * j + i + this.X - this.H);
        paramArrayList.right = (paramArrayList.left + this.D);
        this.a.setAlpha(i1);
        paramCanvas.drawBitmap(this.aa, new Rect(0, 0, this.D, this.F), paramArrayList, this.a);
        this.a.setAlpha(m);
      }
      if (k < 50)
      {
        paramArrayList = a(k);
        localRect1 = new Rect(0, 0, 0, this.N);
        localRect1.left = (this.M * j);
        localRect1.right = (localRect1.left + this.M);
        this.ad.drawColor(0, PorterDuff.Mode.CLEAR);
        this.af.drawColor(0, PorterDuff.Mode.CLEAR);
        this.ad.drawBitmap(this.x, localRect1, new Rect(0, 0, this.M, this.N), this.a);
        this.af.drawBitmap(this.ac, paramArrayList, this.a);
        paramArrayList = new Rect(0, 0, 0, 0);
        paramArrayList.top = (this.J + this.X);
        paramArrayList.bottom = (paramArrayList.top + this.N);
        if (j > 1) {
          i = this.K - this.J;
        } else {
          i = 0;
        }
        paramArrayList.left = ((this.M + this.J) * j + i + this.X - this.H);
        i = paramArrayList.left;
        m = this.D;
        paramArrayList.right = (i + m);
        paramCanvas.drawBitmap(this.ae, new Rect(0, 0, m, this.F), paramArrayList, this.a);
      }
      if (k > 50)
      {
        paramArrayList = a(k);
        i = this.N;
        k = this.L;
        localRect1 = new Rect(0, i + k, 0, i * 2 + k);
        localRect1.left = (this.M * j);
        localRect1.right = (localRect1.left + this.M);
        this.ad.drawColor(0, PorterDuff.Mode.CLEAR);
        this.af.drawColor(0, PorterDuff.Mode.CLEAR);
        this.ad.drawBitmap(this.w, localRect1, new Rect(0, 0, this.M, this.N), this.a);
        this.af.drawBitmap(this.ac, paramArrayList, this.a);
        paramArrayList = new Rect(0, 0, 0, 0);
        paramArrayList.top = (this.J + this.N + this.L + this.X);
        paramArrayList.bottom = (paramArrayList.top + this.N);
        if (j > 1) {
          i = this.K - this.J;
        } else {
          i = 0;
        }
        paramArrayList.left = ((this.M + this.J) * j + i + this.X - this.H);
        i = paramArrayList.left;
        j = this.D;
        paramArrayList.right = (i + j);
        paramCanvas.drawBitmap(this.ae, new Rect(0, 0, j, this.F), paramArrayList, this.a);
      }
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
      this.s = paramString.optString("upFilePath", "");
      this.t = paramString.optString("downFilePath", "");
      this.u = paramString.optString("nowHhmm", "");
      this.v = paramString.optString("lastHhmm", "");
    }
    return new String[] { this.s, this.t, this.u };
  }
  
  protected void b()
  {
    a();
    Object localObject = this.f;
    int j = 500;
    long l1 = 500;
    this.Q = ((AnimStateTypeEvaluator)localObject).a("alpha", 165L, l1, 0, 255, new LinearInterpolator());
    int i = this.I;
    this.S = new int[i];
    this.T = new int[i];
    this.U = new int[i];
    i = 0;
    while (i < this.I)
    {
      localObject = this.S;
      AnimStateTypeEvaluator localAnimStateTypeEvaluator = this.f;
      long l2 = j;
      localObject[i] = localAnimStateTypeEvaluator.a("alpha", l2, l1, -40, 0, new LinearInterpolator());
      this.T[i] = this.f.a("frontFlip", l2, l1, 0, 100, new LinearInterpolator());
      this.U[i] = this.f.a("groundOldFlip", l2, l1, 255, 0, new LinearInterpolator());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("groundOldFlip[i]: ");
      ((StringBuilder)localObject).append(this.U[i]);
      QLog.e("CalendarTimeStickerDrawable", 2, ((StringBuilder)localObject).toString());
      j += 500;
      i += 1;
    }
    this.V = j;
    this.R = this.f.a("alpha", 0L, this.V, 0, 100, new LinearInterpolator());
    this.A = Typeface.createFromAsset(this.h.getResources().getAssets(), "info_sticker_typeface/roboto-medium.ttf");
    this.a.setAntiAlias(true);
    this.a.setDither(true);
    this.b.setTextSize(a(60.0F, this.h.getResources()));
    this.b.setAntiAlias(true);
    this.b.setDither(true);
    this.b.setColor(-1);
    this.b.setTypeface(this.A);
    this.b.setAlpha(255);
    if (Build.VERSION.SDK_INT >= 21) {
      this.b.setShadowLayer(InfoStickerDrawable.m, 0.0F, 0.0F, 1711276032);
    } else {
      this.b.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
    }
    this.X = a(2.0F, this.h.getResources());
    this.J = a(1.0F, this.h.getResources());
    this.K = a(11.0F, this.h.getResources());
    this.L = a(1.0F, this.h.getResources());
    this.M = a(36.5F, this.h.getResources());
    this.N = a(31.0F, this.h.getResources());
    this.H = a(2.0F, this.h.getResources());
    i = this.M;
    this.D = (this.H * 2 + i);
    double d1 = i;
    Double.isNaN(d1);
    this.E = ((int)(d1 * 2.0D / 3.0D));
    j = this.N;
    this.F = j;
    this.G = 0;
    int k = this.J;
    int m = this.K;
    int i1 = this.X;
    this.c = (k * 4 + m + i * 4 + i1 * 2);
    this.d = (k * 2 + this.L + j * 2 + i1 * 2);
    this.B = this.D;
    this.C = j;
    this.Y = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    this.Z = new Canvas(this.Y);
    this.aa = Bitmap.createBitmap(this.B, this.C, Bitmap.Config.ARGB_8888);
    this.ab = new Canvas(this.aa);
    this.ac = Bitmap.createBitmap(this.M, this.N, Bitmap.Config.ARGB_8888);
    this.ad = new Canvas(this.ac);
    this.ae = Bitmap.createBitmap(this.B, this.C, Bitmap.Config.ARGB_8888);
    this.af = new Canvas(this.ae);
    if (FileUtils.fileExists(this.s)) {
      this.y = BitmapFactory.decodeFile(this.s);
    } else {
      QLog.e("CalendarTimeStickerDrawable", 2, "mUpFilePath not exist");
    }
    if (FileUtils.fileExists(this.t)) {
      this.z = BitmapFactory.decodeFile(this.t);
    } else {
      QLog.e("CalendarTimeStickerDrawable", 2, "mUpFilePath not exist");
    }
    this.O = (this.M * 4);
    this.P = (this.N * 2 + this.L);
    this.w = Bitmap.createBitmap(this.O, this.P, Bitmap.Config.ARGB_8888);
    localObject = new Canvas(this.w);
    a(this.u, (Canvas)localObject);
    this.x = Bitmap.createBitmap(this.O, this.P, Bitmap.Config.ARGB_8888);
    localObject = new Canvas(this.x);
    a(this.v, (Canvas)localObject);
    this.W = this.f.a("X", 825L, 1000L, 0, 100, new DecelerateInterpolator());
  }
  
  public String c()
  {
    return this.s;
  }
  
  public String d()
  {
    return this.t;
  }
  
  public int getIntrinsicHeight()
  {
    return this.d;
  }
  
  public int getIntrinsicWidth()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.CalendarTimeStickerDrawable
 * JD-Core Version:    0.7.0.1
 */
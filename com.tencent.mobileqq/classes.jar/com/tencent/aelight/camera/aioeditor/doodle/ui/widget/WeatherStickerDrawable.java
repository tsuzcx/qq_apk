package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.tencent.aelight.camera.aioeditor.capture.paster.ApngDecodeWrapper;
import com.tencent.aelight.camera.util.EaseCubicInterpolator;
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherStickerDrawable
  extends InfoStickerDrawable
{
  private int A;
  private Rect B;
  private int C;
  private int D;
  private int E;
  private String F;
  private String G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  private Rect P = new Rect();
  private boolean Q;
  private int R;
  private boolean S;
  private String T;
  private Paint U;
  private int V;
  private int W;
  private float X;
  private int a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String n;
  private Paint o;
  private Paint p;
  private String[] q = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
  private WeatherStickerDrawable.ApngHandler r;
  private GifDecoder s;
  private long t;
  private Bitmap u;
  private Rect v;
  private Bitmap w;
  private Rect x;
  private Bitmap y;
  private int z;
  
  public WeatherStickerDrawable(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    a(paramString);
    b();
    e();
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt1);
      localJSONObject.put("temperature", paramInt2);
      localJSONObject.put("weather_icon_path", paramString1);
      localJSONObject.put("weather_desc", paramString2);
      localJSONObject.put("weather_symbol_icon_path", paramString3);
      localJSONObject.put("weather_font_path", paramString4);
      localJSONObject.put("weather_line_path", paramString5);
      localJSONObject.put("weather_line_path", paramString5);
      localJSONObject.put("dynamic", paramBoolean);
      paramString1 = localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WeatherStickerDrawable", 2, paramString1, new Object[0]);
      }
      paramString1 = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WeatherStickerDrawable", 2, paramString1);
    }
    return paramString1;
  }
  
  private void c()
  {
    if (this.Q) {
      return;
    }
    long l1 = System.currentTimeMillis();
    if (this.t == 0L) {
      this.t = l1;
    }
    long l2 = this.t;
    this.r.sendEmptyMessageDelayed(0, 40L);
    Bitmap localBitmap = null;
    GifDecoder localGifDecoder = this.s;
    if (localGifDecoder != null) {
      localBitmap = localGifDecoder.getNextGifFrame((l1 - l2) * 1000L * 1000L);
    }
    if (localBitmap != this.u)
    {
      this.u = localBitmap;
      invalidateSelf();
    }
  }
  
  public Bitmap a(long paramLong)
  {
    Bitmap localBitmap = i();
    Canvas localCanvas = new Canvas(localBitmap);
    ArrayList localArrayList = this.f.a(paramLong);
    GifDecoder localGifDecoder = this.s;
    if (localGifDecoder != null) {
      this.u = localGifDecoder.getNextGifFrame(paramLong * 1000L * 1000L);
    }
    a(localCanvas, localArrayList);
    return localBitmap;
  }
  
  public void a()
  {
    this.Q = true;
    WeatherStickerDrawable.ApngHandler localApngHandler = this.r;
    if (localApngHandler != null) {
      localApngHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int j = 255;
    int k;
    int m;
    int i;
    int i1;
    int i2;
    if (paramArrayList != null)
    {
      k = a(paramArrayList, this.J, 0);
      m = a(paramArrayList, this.K, 0);
      i = a(paramArrayList, this.L, 0);
      j = a(paramArrayList, this.M, 255);
      i1 = a(paramArrayList, this.N, 255);
      i2 = a(paramArrayList, this.O, 255);
    }
    else
    {
      i2 = 255;
      k = 0;
      m = 0;
      i = 0;
      i1 = 255;
    }
    paramArrayList = this.u;
    if (paramArrayList != null) {
      paramCanvas.drawBitmap(paramArrayList, null, this.v, null);
    }
    this.o.setAlpha(j);
    paramArrayList = this.T;
    if (paramArrayList != null) {
      paramCanvas.drawText(paramArrayList, this.z + k, this.X, this.o);
    }
    this.U.setAlpha(j);
    if (this.w != null)
    {
      this.P.set(this.x);
      this.P.offset(k, 0);
      paramCanvas.drawBitmap(this.w, null, this.P, this.U);
    }
    this.U.setAlpha(i1);
    if (this.y != null)
    {
      this.P.set(this.B);
      this.P.offset(m, 0);
      paramCanvas.drawBitmap(this.y, null, this.P, this.U);
    }
    this.p.setAlpha(i2);
    this.p.setTextSize(this.W);
    paramArrayList = this.F;
    if (paramArrayList != null) {
      paramCanvas.drawText(paramArrayList, this.A + i, this.C, this.p);
    }
    paramArrayList = this.G;
    if (paramArrayList != null) {
      paramCanvas.drawText(paramArrayList, this.H + i, this.C, this.p);
    }
    if (this.c != null)
    {
      j = this.V;
      if (j != 0) {
        this.p.setTextSize(j);
      }
      paramCanvas.drawText(this.c, this.I + i, this.C, this.p);
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
      this.a = paramString.optInt("temperature");
      this.b = paramString.optString("weather_icon_path", "");
      this.c = paramString.optString("weather_desc", "");
      this.d = paramString.optString("weather_symbol_icon_path", "");
      this.e = paramString.optString("weather_font_path", "");
      this.n = paramString.optString("weather_line_path", "");
      this.S = paramString.optBoolean("dynamic", true);
    }
    return new String[] { this.b, this.c, this.d, this.e, this.n };
  }
  
  protected void b()
  {
    this.r = new WeatherStickerDrawable.ApngHandler(new WeakReference(this));
    if (new File(this.e).exists()) {}
    try
    {
      localObject = Typeface.createFromFile(this.e);
    }
    catch (Exception localException)
    {
      Object localObject;
      label48:
      int i;
      Paint.FontMetrics localFontMetrics;
      int i1;
      Calendar localCalendar;
      int j;
      String[] arrayOfString;
      float f;
      int i2;
      int m;
      int i3;
      int i4;
      int k;
      int i5;
      int i7;
      int i6;
      int i8;
      int i9;
      double d1;
      double d2;
      break label48;
    }
    localObject = Typeface.DEFAULT;
    break label61;
    localObject = Typeface.DEFAULT;
    label61:
    i = this.a;
    if (i == -999) {
      this.T = "--";
    } else {
      this.T = String.format("%02d", new Object[] { Integer.valueOf(i) });
    }
    this.o = new Paint();
    this.o.setAntiAlias(true);
    this.o.setDither(true);
    this.o.setColor(-1);
    this.o.setTextSize(a(40.0F, this.h.getResources()));
    this.o.setFakeBoldText(true);
    this.o.setTypeface((Typeface)localObject);
    localFontMetrics = this.o.getFontMetrics();
    i1 = (int)(localFontMetrics.bottom - localFontMetrics.top);
    i = (int)this.o.measureText(this.T);
    this.p = new Paint();
    this.p.setAntiAlias(true);
    this.p.setDither(true);
    this.p.setColor(-1);
    this.p.setTypeface((Typeface)localObject);
    this.W = a(11.0F, this.h.getResources());
    localObject = this.c;
    if ((localObject != null) && (((String)localObject).length() > 2)) {
      this.V = a(9.5F, this.h.getResources());
    }
    this.p.setTextSize(this.W);
    this.p.setFakeBoldText(true);
    localObject = this.p.getFontMetrics();
    this.U = new Paint(1);
    localCalendar = Calendar.getInstance();
    j = localCalendar.get(2);
    arrayOfString = this.q;
    if (j < arrayOfString.length) {
      this.F = arrayOfString[j];
    } else {
      this.F = "";
    }
    this.G = String.format("%02d", new Object[] { Integer.valueOf(localCalendar.get(5)) });
    if (new File(this.d).exists())
    {
      this.s = new ApngDecodeWrapper(this.b);
      this.s.init();
    }
    if (new File(this.d).exists()) {
      this.w = BitmapFactory.decodeFile(this.d);
    }
    if (new File(this.n).exists()) {
      this.y = BitmapFactory.decodeFile(this.n);
    }
    this.R = a(90.0F, this.h.getResources());
    j = this.R;
    this.v = new Rect(0, 0, j, j);
    f = a(16.0F, this.h.getResources());
    this.X = (f - localFontMetrics.top);
    i2 = a(1.0F, this.h.getResources());
    m = a(1.0F, this.h.getResources());
    i3 = Math.round(m * 0.5F);
    i4 = m * 4;
    j = this.R;
    this.z = (j + m);
    this.A = (j + m * 3);
    k = a(55.5F, this.h.getResources());
    j = a(22.0F, this.h.getResources());
    i5 = this.z + i + i4;
    i7 = a(31.0F, this.h.getResources());
    i6 = a(23.5F, this.h.getResources());
    i8 = j + i5;
    i9 = this.z;
    j = m * 2;
    i = k;
    if (k < i8 - i9) {
      i = i8 - i9;
    }
    k = i7 + i6;
    this.x = new Rect(i5, i6, i8, k);
    k += i4;
    i4 = this.z + m;
    this.B = new Rect(i4, k, i4 + i, i2 + k);
    this.C = ((int)((int)(f + i1 + i3) - ((Paint.FontMetrics)localObject).top));
    k = (int)this.p.measureText(this.F);
    i1 = (int)this.p.measureText(this.G);
    i2 = this.V;
    if (i2 != 0) {
      this.p.setTextSize(i2);
    } else {
      j = m * 5;
    }
    this.H = (this.A + k + j);
    this.I = (this.H + i1 + j);
    d1 = this.R;
    d2 = i;
    Double.isNaN(d2);
    Double.isNaN(d1);
    this.E = ((int)(d1 + d2 * 1.2D));
    this.D = this.v.bottom;
    localObject = this.f;
    d1 = -i;
    Double.isNaN(d1);
    i = (int)(d1 * 0.3D);
    this.J = ((AnimStateTypeEvaluator)localObject).a("offsetX", 0L, 650L, i, 0, new SpringInterpolator());
    this.K = this.f.a("offsetX", 100L, 650L, i, 0, new SpringInterpolator());
    this.L = this.f.a("offsetX", 200L, 650L, i, 0, new SpringInterpolator());
    this.M = this.f.a("alpha", 0L, 370L, 0, 255, new EaseCubicInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    this.N = this.f.a("alpha", 100L, 370L, 0, 255, new EaseCubicInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
    this.O = this.f.a("alpha", 200L, 370L, 0, 255, new EaseCubicInterpolator(0.33F, 0.0F, 0.67F, 1.0F));
  }
  
  protected void e()
  {
    super.e();
    if ((this.s != null) && (this.S)) {
      this.r.sendEmptyMessage(0);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.D;
  }
  
  public int getIntrinsicWidth()
  {
    return this.E;
  }
  
  public Bitmap h()
  {
    Bitmap localBitmap = i();
    Canvas localCanvas = new Canvas(localBitmap);
    ArrayList localArrayList = this.f.a(this.f.c());
    if (this.b != null)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
      this.u = BitmapFactory.decodeFile(this.b.replace(".apng", ".bpng"), localOptions);
    }
    a(localCanvas, localArrayList);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.WeatherStickerDrawable
 * JD-Core Version:    0.7.0.1
 */
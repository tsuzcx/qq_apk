package com.tencent.biz.qqcircle.bizparts.danmaku.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import aoch;
import bmpg;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.CellTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vel;
import vep;
import veq;
import vex;
import vha;
import vhh;
import vtu;

public class PhotoDanmakuDrawer
{
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private static final TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private static LinkedHashMap<String, Paint> jdField_a_of_type_JavaUtilLinkedHashMap = new PhotoDanmakuDrawer.1();
  private static final Map<Float, Float> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final Rect c = new Rect();
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final vhh jdField_a_of_type_Vhh;
  private final Rect b = new Rect();
  
  public PhotoDanmakuDrawer(Context paramContext, vhh paramvhh)
  {
    this.jdField_a_of_type_Vhh = paramvhh;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private static float a(float paramFloat)
  {
    jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
    Float localFloat = (Float)jdField_a_of_type_JavaUtilMap.get(Float.valueOf(paramFloat));
    Object localObject = localFloat;
    if (localFloat == null)
    {
      localObject = jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      float f1 = ((Paint.FontMetrics)localObject).descent;
      float f2 = ((Paint.FontMetrics)localObject).ascent;
      localObject = Float.valueOf(((Paint.FontMetrics)localObject).leading + (f1 - f2));
      jdField_a_of_type_JavaUtilMap.put(Float.valueOf(paramFloat), localObject);
    }
    return ((Float)localObject).floatValue();
  }
  
  private static float a(TextPaint paramTextPaint)
  {
    float f1 = paramTextPaint.getTextSize();
    Float localFloat = (Float)jdField_a_of_type_JavaUtilMap.get(Float.valueOf(f1));
    paramTextPaint = localFloat;
    if (localFloat == null)
    {
      paramTextPaint = jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      float f2 = paramTextPaint.descent;
      float f3 = paramTextPaint.ascent;
      paramTextPaint = Float.valueOf(paramTextPaint.leading + (f2 - f3));
      jdField_a_of_type_JavaUtilMap.put(Float.valueOf(f1), paramTextPaint);
    }
    return paramTextPaint.floatValue();
  }
  
  public static float a(vel paramvel)
  {
    return a(paramvel.a) + paramvel.g * 2;
  }
  
  private int a(String paramString)
  {
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      if (paramString.substring(j, j + 1).matches("[一-龥]")) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f6;
    float f3;
    float f4;
    float f2;
    float f1;
    float f5;
    if (i <= j)
    {
      f6 = i / 2;
      f3 = i;
      f4 = i;
      f2 = i;
      f1 = i;
      j = i;
      f5 = 0.0F;
    }
    for (;;)
    {
      Bitmap localBitmap = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect((int)f5, (int)0.0F, (int)f4, (int)f3);
      Rect localRect2 = new Rect((int)0.0F, (int)0.0F, (int)f2, (int)f1);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localCanvas.drawRoundRect(localRectF, f6, f6, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
      f6 = j / 2;
      f5 = (i - j) / 2;
      f4 = i - f5;
      f3 = j;
      f2 = j;
      f1 = j;
      i = j;
    }
  }
  
  private static Paint a(vex paramvex, PhotoDanmakuDrawer.PaintType paramPaintType)
  {
    Object localObject = null;
    switch (ver.a[paramPaintType.ordinal()])
    {
    }
    for (;;)
    {
      localObject = (Paint)jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject == null) {
        break;
      }
      return localObject;
      localObject = a(paramvex, paramPaintType);
      continue;
      String str = paramvex.d();
      localObject = str;
      if (str == null)
      {
        localObject = a(paramvex, paramPaintType);
        paramvex.d((String)localObject);
        continue;
        str = paramvex.e();
        localObject = str;
        if (str == null)
        {
          localObject = a(paramvex, paramPaintType);
          paramvex.e((String)localObject);
        }
      }
    }
    if (paramPaintType == PhotoDanmakuDrawer.PaintType.Hint) {}
    for (localObject = new Paint(); paramPaintType == PhotoDanmakuDrawer.PaintType.Measure; localObject = new TextPaint())
    {
      ((Paint)localObject).setTextSize(paramvex.f());
      return localObject;
    }
    ((Paint)localObject).setTextSize(paramvex.f());
    ((Paint)localObject).setAlpha(paramvex.d());
    ((Paint)localObject).setAntiAlias(paramvex.e());
    switch (ver.a[paramPaintType.ordinal()])
    {
    default: 
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      ((Paint)localObject).setColor(paramvex.b());
      ((Paint)localObject).setTypeface(Typeface.DEFAULT_BOLD);
      ((Paint)localObject).clearShadowLayer();
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilLinkedHashMap.put(a(paramvex, paramPaintType), localObject);
      return localObject;
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      ((Paint)localObject).setStrokeWidth(paramvex.i());
      ((Paint)localObject).setColor(paramvex.e());
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return paramString;
      }
      Object localObject = Pattern.compile("@\\{uin:\\d+?,nick:(.+?),who:\\d+?\\}").matcher(paramString);
      StringBuilder localStringBuilder = new StringBuilder(paramString.length());
      for (int i = 0; ((Matcher)localObject).find(); i = ((Matcher)localObject).end())
      {
        localStringBuilder.append(paramString.substring(i, ((Matcher)localObject).start()));
        localStringBuilder.append("@" + ((Matcher)localObject).group(1));
      }
      localStringBuilder.append(paramString.substring(i));
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PhotoDanmakuDrawer", 1, "PhotoDanmaku - convertAtStruct", localThrowable);
    }
    return paramString;
  }
  
  private String a(String paramString, int paramInt)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < paramString.length())
      {
        if (paramString.substring(j, j + 1).matches("[一-龥]")) {
          i += 2;
        }
        for (;;)
        {
          if (i <= paramInt) {
            break label117;
          }
          paramInt = j - 1;
          while (paramInt < paramString.length())
          {
            i = paramInt;
            if (!a(paramString.charAt(paramInt))) {
              break label84;
            }
            paramInt += 1;
          }
          i += 1;
        }
        i = -1;
        label84:
        if (i != -1) {}
      }
      else
      {
        return paramString;
      }
      return paramString.substring(0, i) + "...";
      label117:
      j += 1;
    }
  }
  
  private static String a(vex paramvex, PhotoDanmakuDrawer.PaintType paramPaintType)
  {
    if ((paramvex == null) || (paramPaintType == null)) {
      return "";
    }
    if (paramPaintType == PhotoDanmakuDrawer.PaintType.Measure) {
      return String.valueOf(paramvex.f());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('n');
    localStringBuilder.append(paramvex.d());
    localStringBuilder.append(paramvex.e());
    switch (ver.a[paramPaintType.ordinal()])
    {
    default: 
      localStringBuilder.append(paramPaintType.ordinal());
      localStringBuilder.append(paramvex.f());
      localStringBuilder.append(paramvex.b());
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("b");
      localStringBuilder.append(paramvex.i());
      localStringBuilder.append(paramvex.e());
    }
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, vex paramvex, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramvex != null) && (paramvex.b() != null) && (!paramvex.b().isRecycled()) && (paramCanvas != null))
    {
      paramPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(paramvex.b(), paramFloat1, paramFloat2, paramPaint);
      return;
    }
    aoch.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, 1, String.valueOf(paramLong), 4, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840264), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840264), new vep(this, paramLong, paramvex, paramFloat3, paramFloat4, paramPaint));
  }
  
  private void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, boolean paramBoolean)
  {
    QLog.d("PhotoDanmakuDrawer", 1, new Object[] { "drawBg={left=%f,top=%f,width=%f,height=%f,clipPadding=%f}", Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4), Integer.valueOf(paramInt) });
    paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843906);
    if (paramString != null)
    {
      paramCanvas.save();
      c.set((int)paramFloat1, (int)paramFloat2, (int)(paramFloat1 + paramFloat3), (int)(paramFloat2 + paramFloat4));
      paramString.setBounds(c);
      paramString.draw(paramCanvas);
      QLog.i("PhotoDanmakuDrawer", 4, "drawBg");
    }
    try
    {
      paramCanvas.restore();
      if (paramInt > 0)
      {
        if (!paramBoolean) {
          break label266;
        }
        paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843907);
        if (paramString != null)
        {
          paramCanvas.save();
          int i = paramInt;
          if (paramInt > 10) {
            i = 10;
          }
          paramCanvas.clipRect((int)paramFloat1, (int)paramFloat2, (int)(paramFloat1 + paramFloat3) / 10 * i, (int)(paramFloat2 + paramFloat4));
          c.set((int)paramFloat1, (int)paramFloat2, (int)(paramFloat1 + paramFloat3), (int)(paramFloat2 + paramFloat4));
          paramString.setBounds(c);
          paramString.draw(paramCanvas);
          QLog.e("PhotoDanmakuDrawer", 1, "drawbg");
        }
      }
    }
    catch (IllegalStateException paramString)
    {
      for (;;)
      {
        try
        {
          paramCanvas.restore();
          return;
        }
        catch (IllegalStateException paramCanvas)
        {
          label266:
          QLog.e("PhotoDanmakuDrawer", 1, "drawText get an IllegalStateException: canvas.restore()");
        }
        paramString = paramString;
        QLog.e("PhotoDanmakuDrawer", 1, "drawText get an IllegalStateException: canvas.restore()");
        continue;
        paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843908);
      }
    }
  }
  
  private void a(Canvas paramCanvas, vex paramvex, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    System.currentTimeMillis();
    float f2 = paramvex.a().jdField_c_of_type_Float;
    TextPaint localTextPaint = (TextPaint)a(paramvex, PhotoDanmakuDrawer.PaintType.Normal);
    float f1 = paramvex.j() + paramFloat1;
    float f3 = vtu.b(5.0F);
    float f4 = vtu.b(2.0F);
    paramFloat3 = f1;
    if (paramvex.e() != -10L) {
      paramFloat3 = f1 + (paramvex.q() + paramFloat4) - vtu.a(50.0F);
    }
    paramFloat3 = paramvex.i() + paramFloat3;
    float f5 = paramvex.i();
    float f6 = paramvex.k();
    Object localObject = paramvex.b();
    f5 = paramvex.l() + (f5 + f6 + paramFloat2);
    if (localObject != null)
    {
      localTextPaint.setTypeface(Typeface.DEFAULT);
      if (paramvex.c() != -1) {
        break label606;
      }
      localTextPaint.setColor(paramvex.b());
      localTextPaint.setAlpha(178);
    }
    for (;;)
    {
      if (paramvex.a) {
        localTextPaint.setShadowLayer(paramvex.jdField_c_of_type_Int, paramvex.d, paramvex.e, paramvex.f);
      }
      paramCanvas.drawText(paramvex.c(), paramFloat3, f5, localTextPaint);
      paramCanvas.save();
      if (paramvex.e() == -10L)
      {
        paramCanvas.translate(localTextPaint.measureText(paramvex.c()) + paramFloat1, f5 - localTextPaint.getTextSize());
        localObject = new CellTextView(this.jdField_a_of_type_AndroidContentContext);
        ((CellTextView)localObject).setTextSize(localTextPaint.getTextSize());
        ((CellTextView)localObject).setTextGravity(17);
        ((CellTextView)localObject).setTextBold(true);
        ((CellTextView)localObject).a(paramvex.b());
        ((CellTextView)localObject).setTextColorLink(paramvex.b());
        ((CellTextView)localObject).setTextColor(paramvex.b());
        ((CellTextView)localObject).setOuterListener(new veq(this, paramvex));
        ((CellTextView)localObject).setMaxLine(1);
        ((CellTextView)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ((CellTextView)localObject).layout((int)paramFloat3, (int)f5, (int)paramvex.g(), (int)paramvex.h());
        ((CellTextView)localObject).draw(paramCanvas);
        if (paramvex.t > 10)
        {
          int j = paramvex.t;
          int i = j;
          if (j > 999) {
            i = 999;
          }
          paramCanvas.translate(((CellTextView)localObject).getMeasuredWidth(), -5.0F);
          localObject = new CellTextView(this.jdField_a_of_type_AndroidContentContext);
          ((CellTextView)localObject).setTextSize(localTextPaint.getTextSize() + 10.0F);
          localTextPaint.setStyle(Paint.Style.STROKE);
          ((CellTextView)localObject).setTextGravity(17);
          ((CellTextView)localObject).setTextBold(true);
          ((CellTextView)localObject).a(" x" + i);
          ((CellTextView)localObject).setTextColor(-1595942);
          ((CellTextView)localObject).setMaxLine(1);
          ((CellTextView)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          ((CellTextView)localObject).layout((int)paramFloat3, (int)f5, (int)paramvex.g(), (int)paramvex.h());
          ((CellTextView)localObject).draw(paramCanvas);
        }
      }
      try
      {
        paramCanvas.restore();
        if (paramvex.e() != -10L) {
          a(paramCanvas, localTextPaint, paramvex, paramvex.e(), f1 - f3, f2 + paramFloat2 + f4, vtu.b(22.0F), vtu.b(22.0F));
        }
        return;
        label606:
        localTextPaint.setColor(paramvex.c());
        continue;
        paramCanvas.translate(paramFloat1 + paramFloat4 + paramvex.q() + localTextPaint.measureText(paramvex.c()) - vtu.a(8.0F), f5 - localTextPaint.getTextSize());
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          QLog.e("PhotoDanmakuDrawer", 1, "drawText get an IllegalStateException: canvas.restore()");
        }
      }
    }
  }
  
  private void a(vex paramvex, float paramFloat1, float paramFloat2, aoch paramaoch)
  {
    if (paramvex != null)
    {
      paramaoch = a(Bitmap.createScaledBitmap(paramaoch.b(), (int)paramFloat1, (int)paramFloat2, false));
      if (paramaoch != null) {
        paramvex.b(paramaoch);
      }
    }
  }
  
  private void a(vex paramvex, Paint paramPaint, float paramFloat1, float paramFloat2)
  {
    if (paramvex != null)
    {
      paramPaint.setAntiAlias(true);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = a(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130840264), (int)paramFloat1, (int)paramFloat2, false));
      }
      paramvex.b(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  private void a(vex paramvex, TextPaint paramTextPaint)
  {
    QLog.d("PhotoDanmakuDrawer", 1, "calcPaintWH start at:" + System.currentTimeMillis() + "danmaku:" + paramvex.a());
    float f3 = a(paramTextPaint);
    float f1 = 2.0F * paramvex.i();
    float f2 = paramvex.j();
    f3 += 2.0F * paramvex.k() + f1;
    String str3 = paramvex.a().toString();
    String str2 = a(paramvex.c(), 16);
    String str1 = bmpg.a(str3, "");
    int i = bmpg.a(str3);
    Object localObject = vha.a(str1);
    str1 = a(str3);
    ArrayList localArrayList;
    int j;
    int m;
    if ((i > 0) && (a((String)localObject) + i * 2 > 30))
    {
      localObject = new ArrayList();
      localArrayList = new ArrayList();
      QLog.d("PhotoDanmakuDrawer", 1, "rawContentStr is too long");
      Matcher localMatcher = bmpg.a.matcher(str3);
      while (localMatcher.find())
      {
        ((ArrayList)localObject).add(Integer.valueOf(localMatcher.start()));
        localArrayList.add(Integer.valueOf(localMatcher.end() - 1));
      }
      j = 0;
      i = 0;
      m = 0;
    }
    for (;;)
    {
      try
      {
        if (i < str1.length())
        {
          if ((j < ((ArrayList)localObject).size()) && (i == ((Integer)((ArrayList)localObject).get(j)).intValue()))
          {
            m += 2;
            k = ((Integer)localArrayList.get(j)).intValue();
            i = j + 1;
            if (m < 30) {
              break label775;
            }
            str3 = str1.substring(0, k + 1) + "...";
            str1 = str3;
            if (str2.isEmpty()) {
              break label772;
            }
            str2 = str2 + "： ";
            float f4 = paramTextPaint.measureText(str2);
            i = bmpg.a(str1);
            f2 = f4 + paramTextPaint.measureText(vha.a(bmpg.a(str1, ""))) + i * (paramTextPaint.getTextSize() + paramTextPaint.measureText(".")) + (0.0F + (2.0F * f2 + f1));
            paramvex.c(str2);
            paramvex.b(str1);
            paramvex.h(-paramTextPaint.ascent());
            if (paramvex.e() == -10L) {
              break label769;
            }
            f2 += f3;
            f1 = f2;
            if (paramvex.t > 10) {
              f1 = f2 + vtu.a(8.0F);
            }
            f2 = f1;
            if (paramvex.t > 100) {
              f2 = f1 + vtu.a(8.0F);
            }
            f1 = f2 + paramvex.q();
            paramvex.j(f1);
            paramvex.i(f3);
            f2 = paramvex.g() * 2;
            f4 = paramvex.f() * 2;
            paramvex.b(f1 + f2);
            paramvex.c(f4 + f3);
            QLog.d("PhotoDanmakuDrawer", 1, "calcPaintWH end at:" + System.currentTimeMillis());
            return;
          }
          if (str3.substring(i, i + 1).matches("[一-龥]"))
          {
            k = m + 2;
            if (k >= 30)
            {
              str3 = str1.substring(0, i) + "...";
              str1 = str3;
            }
          }
          else
          {
            k = m + 1;
            continue;
          }
          m = j;
          j = k;
          int k = i;
          i = m;
          m = j;
          j = i;
          i = k + 1;
          continue;
        }
        continue;
      }
      catch (Exception localException)
      {
        QLog.e("PhotoDanmakuDrawer", 1, "danmaku clip get an Exception:" + localException.toString());
      }
      while (i != 0) {}
      str1 = a((String)localObject, 30);
      continue;
      label769:
      continue;
      label772:
      continue;
      label775:
      j = m;
    }
  }
  
  private boolean a(char paramChar)
  {
    return (paramChar != 0) && (paramChar != '\t') && (paramChar != '\n') && (paramChar != '\r') && ((paramChar < ' ') || (paramChar > 55295)) && ((paramChar < 57344) || (paramChar > 65533));
  }
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas = paramCanvas;
  }
  
  public void a(Canvas paramCanvas, vex paramvex, float paramFloat1, float paramFloat2)
  {
    float f1 = paramvex.n();
    float f2 = paramvex.m();
    paramvex.a();
    a(paramCanvas, paramvex.a(), paramFloat1 - vel.b, paramFloat2 - vel.jdField_c_of_type_Int, f1 + vel.b * 2, f2 + vel.jdField_c_of_type_Int * 2, paramvex.t, paramvex.h);
    a(paramCanvas, paramvex, paramFloat1, paramFloat2, f1, f2);
    LpReportInfo_pf00064.allReport(301, 30, 1, true);
  }
  
  public void a(vex paramvex)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_AndroidGraphicsCanvas != null)
    {
      if ((!paramvex.f()) || (!vel.a())) {
        break label289;
      }
      localObject2 = paramvex.a();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this.jdField_a_of_type_Vhh.a((int)paramvex.g(), (int)paramvex.h());
        paramvex.a((Bitmap)localObject1);
      }
      if (localObject1 == null) {
        break label285;
      }
      QLog.i("PhotoDanmakuDrawer", 4, "bitmap");
      localObject2 = localObject1;
      if (paramvex.g())
      {
        paramvex.f(false);
        if (((Bitmap)localObject1).getWidth() >= (int)paramvex.g())
        {
          localObject2 = localObject1;
          if (((Bitmap)localObject1).getHeight() >= (int)paramvex.h()) {}
        }
        else
        {
          this.jdField_a_of_type_Vhh.a((Bitmap)localObject1);
          localObject2 = this.jdField_a_of_type_Vhh.a((int)paramvex.g(), (int)paramvex.h());
          paramvex.a((Bitmap)localObject2);
        }
        localObject1 = paramvex.a();
        if (localObject1 != null) {
          break label276;
        }
        localObject1 = new Canvas((Bitmap)localObject2);
        paramvex.a((Canvas)localObject1);
      }
    }
    for (;;)
    {
      ((Bitmap)localObject2).eraseColor(0);
      a((Canvas)localObject1, paramvex, paramvex.g(), paramvex.f());
      i = this.jdField_a_of_type_AndroidGraphicsCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)paramvex.g(), (int)paramvex.h());
      this.b.set((int)paramvex.b(), (int)paramvex.c(), (int)paramvex.d(), (int)paramvex.e());
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap((Bitmap)localObject2, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsCanvas.restoreToCount(i);
      return;
      label276:
      ((Canvas)localObject1).setBitmap((Bitmap)localObject2);
    }
    label285:
    vel.a(false);
    label289:
    int i = this.jdField_a_of_type_AndroidGraphicsCanvas.save();
    a(this.jdField_a_of_type_AndroidGraphicsCanvas, paramvex, paramvex.o(), paramvex.p());
    this.jdField_a_of_type_AndroidGraphicsCanvas.restoreToCount(i);
  }
  
  public void b(vex paramvex)
  {
    if ((paramvex.a() instanceof SpannableString)) {}
    for (PhotoDanmakuDrawer.PaintType localPaintType = PhotoDanmakuDrawer.PaintType.StaticLayout;; localPaintType = PhotoDanmakuDrawer.PaintType.Measure)
    {
      a(paramvex, (TextPaint)a(paramvex, localPaintType));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer
 * JD-Core Version:    0.7.0.1
 */
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
import aoot;
import bnqj;
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
import vgp;
import vgt;
import vgu;
import vhb;
import vje;
import vjl;
import vwt;

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
  private final vjl jdField_a_of_type_Vjl;
  private final Rect b = new Rect();
  
  public PhotoDanmakuDrawer(Context paramContext, vjl paramvjl)
  {
    this.jdField_a_of_type_Vjl = paramvjl;
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
  
  public static float a(vgp paramvgp)
  {
    return a(paramvgp.a) + paramvgp.g * 2;
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
  
  private static Paint a(vhb paramvhb, PhotoDanmakuDrawer.PaintType paramPaintType)
  {
    Object localObject = null;
    switch (vgv.a[paramPaintType.ordinal()])
    {
    }
    for (;;)
    {
      localObject = (Paint)jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject == null) {
        break;
      }
      return localObject;
      localObject = a(paramvhb, paramPaintType);
      continue;
      String str = paramvhb.d();
      localObject = str;
      if (str == null)
      {
        localObject = a(paramvhb, paramPaintType);
        paramvhb.d((String)localObject);
        continue;
        str = paramvhb.e();
        localObject = str;
        if (str == null)
        {
          localObject = a(paramvhb, paramPaintType);
          paramvhb.e((String)localObject);
        }
      }
    }
    if (paramPaintType == PhotoDanmakuDrawer.PaintType.Hint) {}
    for (localObject = new Paint(); paramPaintType == PhotoDanmakuDrawer.PaintType.Measure; localObject = new TextPaint())
    {
      ((Paint)localObject).setTextSize(paramvhb.f());
      return localObject;
    }
    ((Paint)localObject).setTextSize(paramvhb.f());
    ((Paint)localObject).setAlpha(paramvhb.d());
    ((Paint)localObject).setAntiAlias(paramvhb.e());
    switch (vgv.a[paramPaintType.ordinal()])
    {
    default: 
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      ((Paint)localObject).setColor(paramvhb.b());
      ((Paint)localObject).setTypeface(Typeface.DEFAULT_BOLD);
      ((Paint)localObject).clearShadowLayer();
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilLinkedHashMap.put(a(paramvhb, paramPaintType), localObject);
      return localObject;
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      ((Paint)localObject).setStrokeWidth(paramvhb.i());
      ((Paint)localObject).setColor(paramvhb.e());
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
  
  private static String a(vhb paramvhb, PhotoDanmakuDrawer.PaintType paramPaintType)
  {
    if ((paramvhb == null) || (paramPaintType == null)) {
      return "";
    }
    if (paramPaintType == PhotoDanmakuDrawer.PaintType.Measure) {
      return String.valueOf(paramvhb.f());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('n');
    localStringBuilder.append(paramvhb.d());
    localStringBuilder.append(paramvhb.e());
    switch (vgv.a[paramPaintType.ordinal()])
    {
    default: 
      localStringBuilder.append(paramPaintType.ordinal());
      localStringBuilder.append(paramvhb.f());
      localStringBuilder.append(paramvhb.b());
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("b");
      localStringBuilder.append(paramvhb.i());
      localStringBuilder.append(paramvhb.e());
    }
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, vhb paramvhb, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramvhb != null) && (paramvhb.b() != null) && (!paramvhb.b().isRecycled()) && (paramCanvas != null))
    {
      paramPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(paramvhb.b(), paramFloat1, paramFloat2, paramPaint);
      return;
    }
    aoot.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, 1, String.valueOf(paramLong), 4, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840274), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840274), new vgt(this, paramLong, paramvhb, paramFloat3, paramFloat4, paramPaint));
  }
  
  private void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, boolean paramBoolean)
  {
    paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843928);
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
          break label209;
        }
        paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843929);
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
          label209:
          QLog.e("PhotoDanmakuDrawer", 1, "drawText get an IllegalStateException: canvas.restore()");
        }
        paramString = paramString;
        QLog.e("PhotoDanmakuDrawer", 1, "drawText get an IllegalStateException: canvas.restore()");
        continue;
        paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843930);
      }
    }
  }
  
  private void a(Canvas paramCanvas, vhb paramvhb, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    System.currentTimeMillis();
    float f3 = paramvhb.a().jdField_c_of_type_Float;
    TextPaint localTextPaint = (TextPaint)a(paramvhb, PhotoDanmakuDrawer.PaintType.Normal);
    float f2 = paramvhb.j() + paramFloat1;
    float f4 = vwt.b(5.0F);
    float f5 = vwt.b(2.0F);
    float f1 = f2;
    if (paramvhb.e() != -10L) {
      f1 = f2 + (paramvhb.q() + paramFloat4) - vwt.a(50.0F);
    }
    f1 += paramvhb.i();
    float f6 = paramvhb.i();
    float f7 = paramvhb.k();
    Object localObject = paramvhb.b();
    f6 = f6 + f7 + paramFloat2 + paramvhb.l();
    if (localObject != null)
    {
      localTextPaint.setTypeface(Typeface.DEFAULT);
      if (paramvhb.c() != -1) {
        break label432;
      }
      localTextPaint.setColor(paramvhb.b());
      localTextPaint.setAlpha(178);
    }
    for (;;)
    {
      if (paramvhb.a) {
        localTextPaint.setShadowLayer(paramvhb.jdField_c_of_type_Int, paramvhb.d, paramvhb.e, paramvhb.f);
      }
      paramCanvas.drawText(paramvhb.c(), f1, f6, localTextPaint);
      paramCanvas.save();
      if (paramvhb.e() == -10L)
      {
        paramCanvas.translate(localTextPaint.measureText(paramvhb.c()) + paramFloat1, f6 - localTextPaint.getTextSize());
        localObject = new CellTextView(this.jdField_a_of_type_AndroidContentContext);
        ((CellTextView)localObject).setTextSize(localTextPaint.getTextSize());
        ((CellTextView)localObject).setTextGravity(17);
        ((CellTextView)localObject).setTextBold(true);
        ((CellTextView)localObject).a(paramvhb.b());
        ((CellTextView)localObject).setTextColorLink(paramvhb.b());
        ((CellTextView)localObject).setTextColor(paramvhb.b());
        ((CellTextView)localObject).setOuterListener(new vgu(this, paramvhb));
        ((CellTextView)localObject).setMaxLine(1);
        ((CellTextView)localObject).measure(View.MeasureSpec.makeMeasureSpec((int)paramFloat3, 0), View.MeasureSpec.makeMeasureSpec((int)paramFloat4, 0));
        ((CellTextView)localObject).layout((int)f1, (int)f6, (int)paramFloat3, (int)paramvhb.h());
        ((CellTextView)localObject).draw(paramCanvas);
      }
      try
      {
        paramCanvas.restore();
        if (paramvhb.e() != -10L) {
          a(paramCanvas, localTextPaint, paramvhb, paramvhb.e(), f2 - f4, f3 + paramFloat2 + f5, vwt.b(22.0F), vwt.b(22.0F));
        }
        return;
        label432:
        localTextPaint.setColor(paramvhb.c());
        continue;
        paramCanvas.translate(paramFloat1 + paramFloat4 + paramvhb.q() + localTextPaint.measureText(paramvhb.c()) - vwt.a(8.0F), f6 - localTextPaint.getTextSize());
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
  
  private void a(vhb paramvhb, float paramFloat1, float paramFloat2, aoot paramaoot)
  {
    if (paramvhb != null)
    {
      paramaoot = a(Bitmap.createScaledBitmap(paramaoot.b(), (int)paramFloat1, (int)paramFloat2, false));
      if (paramaoot != null) {
        paramvhb.b(paramaoot);
      }
    }
  }
  
  private void a(vhb paramvhb, Paint paramPaint, float paramFloat1, float paramFloat2)
  {
    if (paramvhb != null)
    {
      paramPaint.setAntiAlias(true);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = a(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130840274), (int)paramFloat1, (int)paramFloat2, false));
      }
      paramvhb.b(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  private void a(vhb paramvhb, TextPaint paramTextPaint)
  {
    float f3 = a(paramTextPaint);
    float f1 = 2.0F * paramvhb.i();
    float f2 = paramvhb.j();
    f3 += 2.0F * paramvhb.k() + f1;
    String str3 = paramvhb.a().toString();
    String str2 = a(paramvhb.c(), 16);
    String str1 = bnqj.a(str3, "");
    int i = bnqj.a(str3);
    Object localObject = vje.a(str1);
    str1 = a(str3);
    ArrayList localArrayList;
    int j;
    int m;
    if ((i > 0) && (a((String)localObject) + i * 2 > 200))
    {
      localObject = new ArrayList();
      localArrayList = new ArrayList();
      QLog.d("PhotoDanmakuDrawer", 1, "rawContentStr is too long");
      Matcher localMatcher = bnqj.a.matcher(str3);
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
            if (m < 200) {
              break label708;
            }
            str3 = str1.substring(0, k + 1) + "...";
            str1 = str3;
            if (str2.isEmpty()) {
              break label705;
            }
            str2 = str2 + "： ";
            float f4 = paramTextPaint.measureText(str2);
            i = bnqj.a(str1);
            f2 = f4 + paramTextPaint.measureText(vje.a(bnqj.a(str1, ""))) + i * (paramTextPaint.getTextSize() + paramTextPaint.measureText(".")) + (0.0F + (2.0F * f2 + f1));
            paramvhb.c(str2);
            paramvhb.b(str1);
            paramvhb.h(-paramTextPaint.ascent());
            if (paramvhb.e() == -10L) {
              break label702;
            }
            f2 += f3;
            f1 = f2;
            if (paramvhb.t > 10) {
              f1 = f2 + vwt.a(8.0F);
            }
            f2 = f1;
            if (paramvhb.t > 100) {
              f2 = f1 + vwt.a(8.0F);
            }
            f1 = f2 + paramvhb.q();
            paramvhb.j(f1);
            paramvhb.i(f3);
            f2 = paramvhb.g() * 2;
            f4 = paramvhb.f() * 2;
            paramvhb.b(f1 + f2);
            paramvhb.c(f4 + f3);
            return;
          }
          if (str3.substring(i, i + 1).matches("[一-龥]"))
          {
            k = m + 2;
            if (k >= 200)
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
      str1 = a((String)localObject, 200);
      continue;
      label702:
      continue;
      label705:
      continue;
      label708:
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
  
  public void a(Canvas paramCanvas, vhb paramvhb, float paramFloat1, float paramFloat2)
  {
    float f1 = paramvhb.n();
    float f2 = paramvhb.m();
    a(paramCanvas, paramvhb.a(), paramFloat1 - vgp.b, paramFloat2 - vgp.jdField_c_of_type_Int, f1 + vgp.b * 2, f2 + vgp.jdField_c_of_type_Int * 2, paramvhb.t, paramvhb.h);
    a(paramCanvas, paramvhb, paramFloat1, paramFloat2, f1, f2);
    LpReportInfo_pf00064.allReport(301, 30, 1, true);
  }
  
  public void a(vhb paramvhb)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_AndroidGraphicsCanvas != null)
    {
      if ((!paramvhb.f()) || (!vgp.a())) {
        break label279;
      }
      localObject2 = paramvhb.a();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = this.jdField_a_of_type_Vjl.a((int)paramvhb.g(), (int)paramvhb.h());
        paramvhb.a((Bitmap)localObject1);
      }
      if (localObject1 == null) {
        break label275;
      }
      localObject2 = localObject1;
      if (paramvhb.g())
      {
        paramvhb.f(false);
        if (((Bitmap)localObject1).getWidth() >= (int)paramvhb.g())
        {
          localObject2 = localObject1;
          if (((Bitmap)localObject1).getHeight() >= (int)paramvhb.h()) {}
        }
        else
        {
          this.jdField_a_of_type_Vjl.a((Bitmap)localObject1);
          localObject2 = this.jdField_a_of_type_Vjl.a((int)paramvhb.g(), (int)paramvhb.h());
          paramvhb.a((Bitmap)localObject2);
        }
        localObject1 = paramvhb.a();
        if (localObject1 != null) {
          break label266;
        }
        localObject1 = new Canvas((Bitmap)localObject2);
        paramvhb.a((Canvas)localObject1);
      }
    }
    for (;;)
    {
      ((Bitmap)localObject2).eraseColor(0);
      a((Canvas)localObject1, paramvhb, paramvhb.g(), paramvhb.f());
      i = this.jdField_a_of_type_AndroidGraphicsCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)paramvhb.g(), (int)paramvhb.h());
      this.b.set((int)paramvhb.b(), (int)paramvhb.c(), (int)paramvhb.d(), (int)paramvhb.e());
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap((Bitmap)localObject2, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsCanvas.restoreToCount(i);
      return;
      label266:
      ((Canvas)localObject1).setBitmap((Bitmap)localObject2);
    }
    label275:
    vgp.a(false);
    label279:
    int i = this.jdField_a_of_type_AndroidGraphicsCanvas.save();
    a(this.jdField_a_of_type_AndroidGraphicsCanvas, paramvhb, paramvhb.o(), paramvhb.p());
    this.jdField_a_of_type_AndroidGraphicsCanvas.restoreToCount(i);
  }
  
  public void b(vhb paramvhb)
  {
    if ((paramvhb.a() instanceof SpannableString)) {}
    for (PhotoDanmakuDrawer.PaintType localPaintType = PhotoDanmakuDrawer.PaintType.StaticLayout;; localPaintType = PhotoDanmakuDrawer.PaintType.Measure)
    {
      a(paramvhb, (TextPaint)a(paramvhb, localPaintType));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer
 * JD-Core Version:    0.7.0.1
 */
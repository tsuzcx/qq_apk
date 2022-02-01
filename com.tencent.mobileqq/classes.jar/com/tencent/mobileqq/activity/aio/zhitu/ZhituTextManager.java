package com.tencent.mobileqq.activity.aio.zhitu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.List;

public class ZhituTextManager
{
  private boolean a = false;
  
  private ZhituTextManager()
  {
    a(BaseApplicationImpl.getContext());
  }
  
  @NonNull
  private Paint a(Paint paramPaint)
  {
    paramPaint = new Paint(paramPaint);
    paramPaint.setStyle(Paint.Style.STROKE);
    paramPaint.setColor(-1);
    paramPaint.setStrokeWidth(4.0F);
    return paramPaint;
  }
  
  public static ZhituTextManager a()
  {
    return ZhituTextManager.Holder.a();
  }
  
  @NonNull
  private Pair<String, String> a(String paramString, List<String> paramList)
  {
    int i = paramString.length();
    paramString = new StringBuilder(i);
    StringBuilder localStringBuilder = new StringBuilder(i);
    int j = (i + 1) / 2;
    i = 0;
    while (i < paramList.size())
    {
      if (paramString.length() <= j) {
        paramString.append((String)paramList.get(i));
      } else {
        localStringBuilder.append((String)paramList.get(i));
      }
      i += 1;
    }
    return new Pair(paramString.toString(), localStringBuilder.toString());
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint1, String paramString, Rect paramRect, float paramFloat, Paint paramPaint2)
  {
    paramCanvas.drawText(paramString, paramRect.exactCenterX(), paramFloat, paramPaint2);
    paramCanvas.drawText(paramString, paramRect.exactCenterX(), paramFloat, paramPaint1);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, String paramString, Rect paramRect, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 3))
    {
      int i = 1;
      if (paramInt == 1)
      {
        if (paramRect.exactCenterY() < paramCanvas.getHeight() / 2) {
          paramInt = i;
        } else {
          paramInt = 0;
        }
        if (paramInt != 0)
        {
          a(paramCanvas, paramPaint, paramString, paramRect, paramRect.top - paramPaint.ascent(), a(paramPaint));
          return;
        }
        a(paramCanvas, paramPaint, paramString, paramRect, paramRect.bottom - paramPaint.descent(), a(paramPaint));
      }
    }
    else
    {
      float f1 = paramRect.exactCenterY();
      float f2 = (paramPaint.descent() + paramPaint.ascent()) / 2.0F;
      paramCanvas.drawText(paramString, paramRect.exactCenterX(), f1 - f2, paramPaint);
    }
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, String paramString1, String paramString2, Rect paramRect, int paramInt)
  {
    Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
    float f1;
    if ((paramInt != 0) && (paramInt != 3))
    {
      int i = 1;
      if (paramInt == 1)
      {
        if (paramRect.exactCenterY() < paramCanvas.getHeight() / 2) {
          paramInt = i;
        } else {
          paramInt = 0;
        }
        if (paramInt != 0)
        {
          localPaint = a(paramPaint);
          f1 = paramRect.top - localFontMetrics.ascent;
          a(paramCanvas, paramPaint, paramString1, paramRect, f1, localPaint);
          a(paramCanvas, paramPaint, paramString2, paramRect, f1 + localFontMetrics.descent - localFontMetrics.ascent, localPaint);
          return;
        }
        Paint localPaint = a(paramPaint);
        f1 = paramRect.bottom - localFontMetrics.descent;
        a(paramCanvas, paramPaint, paramString2, paramRect, f1, localPaint);
        a(paramCanvas, paramPaint, paramString1, paramRect, f1 - localFontMetrics.descent + localFontMetrics.ascent, localPaint);
      }
    }
    else
    {
      f1 = paramRect.exactCenterY();
      float f2 = localFontMetrics.descent;
      paramCanvas.drawText(paramString1, paramRect.exactCenterX(), f1 - f2, paramPaint);
      f1 = paramRect.exactCenterY();
      f2 = localFontMetrics.ascent;
      paramCanvas.drawText(paramString2, paramRect.exactCenterX(), f1 - f2, paramPaint);
    }
  }
  
  private void a(String paramString, Rect paramRect, Paint paramPaint)
  {
    float f1 = 6.5F;
    float f2;
    do
    {
      paramPaint.setTextSize(paramRect.width() / f1);
      float f3 = paramPaint.measureText(paramString);
      Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
      float f4 = localFontMetrics.bottom;
      float f5 = localFontMetrics.top;
      f2 = f1 + 0.5F;
      if (a(f3, f4 - f5, paramRect)) {
        break;
      }
      f1 = f2;
    } while (f2 < 8.1F);
  }
  
  private void a(String paramString1, String paramString2, Rect paramRect, Paint paramPaint)
  {
    Rect localRect = new Rect(paramRect);
    localRect.bottom = (localRect.top + (localRect.bottom - localRect.top) / 2);
    float f1 = 6.5F;
    float f6;
    float f2;
    do
    {
      paramPaint.setTextSize(paramRect.width() / f1);
      f6 = paramPaint.measureText(paramString1);
      Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
      f2 = localFontMetrics.bottom;
      float f3 = localFontMetrics.top;
      float f7 = paramPaint.measureText(paramString2);
      localFontMetrics = paramPaint.getFontMetrics();
      float f4 = localFontMetrics.bottom;
      float f5 = localFontMetrics.top;
      f6 = Math.max(f6, f7);
      f2 = Math.max(f2 - f3, f4 - f5);
      f1 += 0.5F;
    } while (!a(f6, f2, localRect));
  }
  
  private boolean a(float paramFloat1, float paramFloat2, Rect paramRect)
  {
    double d1 = paramFloat1;
    double d2 = paramRect.width();
    Double.isNaN(d2);
    return (d1 < d2 * 0.9D) && (paramFloat2 < paramRect.height());
  }
  
  private boolean a(Context paramContext)
  {
    try
    {
      boolean bool = this.a;
      if (bool) {
        return true;
      }
      bool = SoLoadUtilNew.loadSoByName(paramContext, "zhitugif");
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("load library with res: ");
        paramContext.append(bool);
        QLog.d("ZhituManager", 2, paramContext.toString());
      }
      this.a = bool;
      return bool;
    }
    finally {}
  }
  
  private boolean a(String paramString, int paramInt, Paint paramPaint)
  {
    float f = paramInt;
    paramPaint.setTextSize(f / 8.0F);
    return paramPaint.measureText(paramString) <= f * 0.9F;
  }
  
  private float[] a(int paramInt1, Paint paramPaint, Rect paramRect, int paramInt2)
  {
    paramPaint = paramPaint.getFontMetrics();
    float[] arrayOfFloat = new float[2];
    if ((paramInt2 != 0) && (paramInt2 != 3))
    {
      if (paramInt2 == 1)
      {
        if (paramRect.exactCenterY() < paramInt1 / 2) {
          paramInt1 = 1;
        } else {
          paramInt1 = 0;
        }
        if (paramInt1 != 0)
        {
          f = paramRect.top - paramPaint.ascent;
          arrayOfFloat[0] = f;
          arrayOfFloat[1] = (f + paramPaint.descent - paramPaint.ascent);
          return arrayOfFloat;
        }
        float f = paramRect.bottom - paramPaint.descent;
        arrayOfFloat[1] = f;
        arrayOfFloat[0] = (f - paramPaint.descent + paramPaint.ascent);
        return arrayOfFloat;
      }
    }
    else
    {
      arrayOfFloat[0] = (paramRect.exactCenterY() - paramPaint.descent);
      arrayOfFloat[1] = (paramRect.exactCenterY() - paramPaint.ascent);
    }
    return arrayOfFloat;
  }
  
  private float[] b(int paramInt1, Paint paramPaint, Rect paramRect, int paramInt2)
  {
    if ((paramInt2 != 0) && (paramInt2 != 3))
    {
      if (paramInt2 == 1)
      {
        if (paramRect.exactCenterY() < paramInt1 / 2) {
          paramInt1 = 1;
        } else {
          paramInt1 = 0;
        }
        if (paramInt1 != 0) {
          return new float[] { paramRect.top - paramPaint.ascent() };
        }
        return new float[] { paramRect.bottom - paramPaint.descent() };
      }
      return new float[] { 0.0F };
    }
    return new float[] { paramRect.exactCenterY() - (paramPaint.descent() + paramPaint.ascent()) / 2.0F };
  }
  
  @Nullable
  public Bitmap a(Bitmap paramBitmap, String paramString1, List<String> paramList, String paramString2, Rect paramRect, int paramInt1, String paramString3, int paramInt2, @Nullable Typeface paramTypeface)
  {
    paramString3 = new Canvas();
    Bitmap localBitmap = ZhituManager.a(paramBitmap.getWidth(), paramBitmap.getHeight());
    if (localBitmap == null) {
      return null;
    }
    localBitmap.setDensity(paramBitmap.getDensity());
    paramString3.setBitmap(localBitmap);
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setSubpixelText(true);
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextAlign(Paint.Align.CENTER);
    localTextPaint.setColor(Color.parseColor(paramString2));
    if (paramTypeface != null) {
      localTextPaint.setTypeface(paramTypeface);
    }
    paramString3.drawBitmap(paramBitmap, 0.0F, 0.0F, localTextPaint);
    if (a(paramString1, paramBitmap.getWidth(), localTextPaint))
    {
      a(paramString1, paramRect, localTextPaint);
      a(paramString3, localTextPaint, paramString1, paramRect, paramInt1);
      return localBitmap;
    }
    paramBitmap = a(paramString1, paramList);
    a((String)paramBitmap.first, (String)paramBitmap.second, paramRect, localTextPaint);
    a(paramString3, localTextPaint, (String)paramBitmap.first, (String)paramBitmap.second, paramRect, paramInt1);
    return localBitmap;
  }
  
  @SuppressLint({"DefaultLocale"})
  @Nullable
  public Bitmap a(String paramString1, String paramString2, List<String> paramList, String paramString3, Rect paramRect, int paramInt1, String paramString4, int paramInt2, Typeface paramTypeface)
  {
    long l = System.currentTimeMillis();
    try
    {
      paramString1 = BitmapFactory.decodeFile(paramString1);
      if (paramString1 == null)
      {
        QLog.e("ZhituManager", 1, ZhituManager.a(paramString4, "generateZhitu", paramInt2, "decode bitmap fail"));
        return null;
      }
      paramString1 = a(paramString1, paramString2, paramList, paramString3, paramRect, paramInt1, paramString4, paramInt2, paramTypeface);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("take time ");
        paramString2.append(Long.toString(System.currentTimeMillis() - l));
        QLog.d("ZhituManager", 2, ZhituManager.a(paramString4, "generateZhitu", paramString2.toString()));
      }
      return paramString1;
    }
    catch (OutOfMemoryError paramString1)
    {
      label111:
      break label111;
    }
    QLog.e("ZhituManager", 1, "decode origin file but oom");
    return null;
  }
  
  public ZhituTextManager.DrawTextParam a(int paramInt1, int paramInt2, String paramString1, List<String> paramList, String paramString2, Rect paramRect, int paramInt3, String paramString3, int paramInt4, Typeface paramTypeface)
  {
    if (paramString1.length() <= 24)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get param: ");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(" / ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("ghostdebug", 2, ((StringBuilder)localObject).toString());
      long l = System.currentTimeMillis();
      localObject = new TextPaint();
      ((Paint)localObject).setSubpixelText(true);
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setTextAlign(Paint.Align.CENTER);
      ((Paint)localObject).setColor(Color.parseColor(paramString2));
      if (paramTypeface != null) {
        ((Paint)localObject).setTypeface(paramTypeface);
      }
      boolean bool = a(paramString1, paramInt1, (Paint)localObject);
      if (bool)
      {
        paramList = new String[1];
        paramList[0] = paramString1;
      }
      else
      {
        paramList = a(paramString1, paramList);
        paramList = new String[] { (String)paramList.first, (String)paramList.second };
      }
      if (bool)
      {
        a(paramString1, paramRect, (Paint)localObject);
        paramString1 = b(paramInt2, (Paint)localObject, paramRect, paramInt3);
      }
      else
      {
        a(paramList[0], paramList[1], paramRect, (Paint)localObject);
        paramString1 = a(paramInt2, (Paint)localObject, paramRect, paramInt3);
      }
      if (paramInt3 == 1) {
        paramString2 = a((Paint)localObject);
      } else {
        paramString2 = null;
      }
      if (QLog.isColorLevel())
      {
        paramRect = new StringBuilder();
        paramRect.append("take time: ");
        paramRect.append(Long.toString(System.currentTimeMillis() - l));
        QLog.d("ZhituManager", 2, ZhituManager.a(paramString3, "getParamToDrawText", paramInt4, paramRect.toString()));
      }
      return new ZhituTextManager.DrawTextParam(paramString1, paramList, (Paint)localObject, paramString2);
    }
    throw new IllegalArgumentException("length of the text to draw is over 24");
  }
  
  /* Error */
  @Nullable
  public String a(@NonNull String paramString1, @NonNull ZhituTextManager.DrawTextParam paramDrawTextParam, @NonNull String paramString2, int paramInt, @NonNull ZhituTextManager.ImgGenerateCallback paramImgGenerateCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager:a	Z
    //   4: ifne +14 -> 18
    //   7: ldc 205
    //   9: iconst_1
    //   10: ldc_w 372
    //   13: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aconst_null
    //   17: areturn
    //   18: invokestatic 305	java/lang/System:currentTimeMillis	()J
    //   21: lstore 8
    //   23: aload 5
    //   25: invokeinterface 377 1 0
    //   30: ifnonnull +14 -> 44
    //   33: ldc 205
    //   35: iconst_1
    //   36: ldc_w 379
    //   39: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aconst_null
    //   43: areturn
    //   44: new 381	java/io/File
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 382	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore 10
    //   54: aload 5
    //   56: aload_1
    //   57: invokeinterface 385 2 0
    //   62: astore 5
    //   64: aload 5
    //   66: invokevirtual 388	java/io/File:exists	()Z
    //   69: ifeq +9 -> 78
    //   72: aload 5
    //   74: invokevirtual 391	java/io/File:delete	()Z
    //   77: pop
    //   78: new 393	com/tencent/mobileqq/activity/aio/zhitu/GifEncoder
    //   81: dup
    //   82: invokespecial 394	com/tencent/mobileqq/activity/aio/zhitu/GifEncoder:<init>	()V
    //   85: astore_1
    //   86: new 396	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText
    //   89: dup
    //   90: aload 10
    //   92: iconst_0
    //   93: fconst_0
    //   94: invokespecial 399	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:<init>	(Ljava/io/File;ZF)V
    //   97: astore 10
    //   99: aload 10
    //   101: invokevirtual 400	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:getHeight	()I
    //   104: ifle +256 -> 360
    //   107: aload 10
    //   109: invokevirtual 401	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:getWidth	()I
    //   112: ifgt +6 -> 118
    //   115: goto +245 -> 360
    //   118: aload 10
    //   120: aload_2
    //   121: invokevirtual 404	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:a	(Lcom/tencent/mobileqq/activity/aio/zhitu/ZhituTextManager$DrawTextParam;)V
    //   124: aload 10
    //   126: invokevirtual 407	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:c	()I
    //   129: istore 6
    //   131: aload 10
    //   133: invokevirtual 409	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:b	()I
    //   136: istore 7
    //   138: iload 6
    //   140: iflt +50 -> 190
    //   143: iload 7
    //   145: iconst_1
    //   146: if_icmpge +6 -> 152
    //   149: goto +41 -> 190
    //   152: aload_1
    //   153: aload 10
    //   155: invokevirtual 401	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:getWidth	()I
    //   158: aload 10
    //   160: invokevirtual 400	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:getHeight	()I
    //   163: aload 5
    //   165: invokevirtual 412	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   168: iconst_0
    //   169: invokevirtual 415	com/tencent/mobileqq/activity/aio/zhitu/GifEncoder:a	(IILjava/lang/String;I)V
    //   172: aload 10
    //   174: invokevirtual 401	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:getWidth	()I
    //   177: aload 10
    //   179: invokevirtual 400	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:getHeight	()I
    //   182: invokestatic 228	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(II)Landroid/graphics/Bitmap;
    //   185: astore_2
    //   186: aload_2
    //   187: ifnonnull +9 -> 196
    //   190: aload_1
    //   191: invokevirtual 417	com/tencent/mobileqq/activity/aio/zhitu/GifEncoder:a	()V
    //   194: aconst_null
    //   195: areturn
    //   196: new 101	android/graphics/Canvas
    //   199: dup
    //   200: aload_2
    //   201: invokespecial 419	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   204: astore 11
    //   206: new 28	android/graphics/Paint
    //   209: dup
    //   210: invokespecial 420	android/graphics/Paint:<init>	()V
    //   213: astore 12
    //   215: iload 6
    //   217: iload 7
    //   219: if_icmpge +76 -> 295
    //   222: aload 11
    //   224: aload 10
    //   226: invokevirtual 423	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:d	()Landroid/graphics/Bitmap;
    //   229: fconst_0
    //   230: fconst_0
    //   231: aload 12
    //   233: invokevirtual 272	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   236: aload 10
    //   238: aload 11
    //   240: invokevirtual 426	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:a	(Landroid/graphics/Canvas;)V
    //   243: aload_1
    //   244: aload_2
    //   245: aload 10
    //   247: invokevirtual 428	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:a	()I
    //   250: invokevirtual 431	com/tencent/mobileqq/activity/aio/zhitu/GifEncoder:a	(Landroid/graphics/Bitmap;I)Z
    //   253: pop
    //   254: aload 11
    //   256: iconst_0
    //   257: iconst_0
    //   258: aload 11
    //   260: invokevirtual 432	android/graphics/Canvas:getWidth	()I
    //   263: aload 11
    //   265: invokevirtual 112	android/graphics/Canvas:getHeight	()I
    //   268: invokevirtual 436	android/graphics/Canvas:clipRect	(IIII)Z
    //   271: pop
    //   272: aload 10
    //   274: invokevirtual 438	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:e	()V
    //   277: aload 10
    //   279: invokevirtual 407	com/tencent/mobileqq/activity/aio/zhitu/GifImageWithText:c	()I
    //   282: istore 6
    //   284: iload 6
    //   286: ifne +6 -> 292
    //   289: goto +6 -> 295
    //   292: goto -77 -> 215
    //   295: aload_1
    //   296: invokevirtual 417	com/tencent/mobileqq/activity/aio/zhitu/GifEncoder:a	()V
    //   299: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +52 -> 354
    //   305: new 65	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   312: astore_1
    //   313: aload_1
    //   314: ldc_w 352
    //   317: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_1
    //   322: invokestatic 305	java/lang/System:currentTimeMillis	()J
    //   325: lload 8
    //   327: lsub
    //   328: invokestatic 330	java/lang/Long:toString	(J)Ljava/lang/String;
    //   331: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: ldc 205
    //   337: iconst_2
    //   338: aload_3
    //   339: ldc_w 440
    //   342: iload 4
    //   344: aload_1
    //   345: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 318	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   351: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload 5
    //   356: invokevirtual 412	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   359: areturn
    //   360: ldc 205
    //   362: iconst_1
    //   363: ldc_w 442
    //   366: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: goto -179 -> 190
    //   372: astore_2
    //   373: goto +63 -> 436
    //   376: astore_2
    //   377: aload_2
    //   378: ldc_w 444
    //   381: invokestatic 449	com/tencent/qqperf/monitor/crash/catchedexception/CaughtExceptionReport:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   384: goto -194 -> 190
    //   387: astore_2
    //   388: new 65	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   395: astore 5
    //   397: aload 5
    //   399: ldc_w 451
    //   402: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 5
    //   408: aload_2
    //   409: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: ldc 205
    //   415: iconst_1
    //   416: aload_3
    //   417: ldc_w 440
    //   420: iload 4
    //   422: aload 5
    //   424: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 318	com/tencent/mobileqq/activity/aio/zhitu/ZhituManager:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   430: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: goto -243 -> 190
    //   436: aload_1
    //   437: invokevirtual 417	com/tencent/mobileqq/activity/aio/zhitu/GifEncoder:a	()V
    //   440: goto +5 -> 445
    //   443: aload_2
    //   444: athrow
    //   445: goto -2 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	ZhituTextManager
    //   0	448	1	paramString1	String
    //   0	448	2	paramDrawTextParam	ZhituTextManager.DrawTextParam
    //   0	448	3	paramString2	String
    //   0	448	4	paramInt	int
    //   0	448	5	paramImgGenerateCallback	ZhituTextManager.ImgGenerateCallback
    //   129	156	6	i	int
    //   136	84	7	j	int
    //   21	305	8	l	long
    //   52	226	10	localObject	Object
    //   204	60	11	localCanvas	Canvas
    //   213	19	12	localPaint	Paint
    // Exception table:
    //   from	to	target	type
    //   86	115	372	finally
    //   118	138	372	finally
    //   152	186	372	finally
    //   196	215	372	finally
    //   222	284	372	finally
    //   360	369	372	finally
    //   377	384	372	finally
    //   388	433	372	finally
    //   86	115	376	java/lang/OutOfMemoryError
    //   118	138	376	java/lang/OutOfMemoryError
    //   152	186	376	java/lang/OutOfMemoryError
    //   196	215	376	java/lang/OutOfMemoryError
    //   222	284	376	java/lang/OutOfMemoryError
    //   360	369	376	java/lang/OutOfMemoryError
    //   86	115	387	java/io/IOException
    //   118	138	387	java/io/IOException
    //   152	186	387	java/io/IOException
    //   196	215	387	java/io/IOException
    //   222	284	387	java/io/IOException
    //   360	369	387	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituTextManager
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.qqcircle.bizparts.danmaku.config.PhotoDanmakuConfig;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.CellTextView;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellParser;
import com.tencent.biz.qqcircle.bizparts.danmaku.util.DrawCacheManager;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhotoDanmakuDrawer
{
  private static final RectF a = new RectF();
  private static final TextPaint b = new TextPaint();
  private static final Map<Float, Float> f = new HashMap();
  private static LinkedHashMap<String, Paint> g = new PhotoDanmakuDrawer.1();
  private static final Rect i = new Rect();
  private final Rect c = new Rect();
  private final Rect d = new Rect();
  private boolean e = false;
  private final DrawCacheManager h;
  private final Paint j = new Paint();
  private Canvas k;
  private Context l;
  private Bitmap m;
  
  public PhotoDanmakuDrawer(Context paramContext, DrawCacheManager paramDrawCacheManager)
  {
    this.h = paramDrawCacheManager;
    this.l = paramContext;
  }
  
  private static float a(float paramFloat)
  {
    b.setTextSize(paramFloat);
    Float localFloat = (Float)f.get(Float.valueOf(paramFloat));
    Object localObject = localFloat;
    if (localFloat == null)
    {
      localObject = b.getFontMetrics();
      localObject = Float.valueOf(((Paint.FontMetrics)localObject).descent - ((Paint.FontMetrics)localObject).ascent + ((Paint.FontMetrics)localObject).leading);
      f.put(Float.valueOf(paramFloat), localObject);
    }
    return ((Float)localObject).floatValue();
  }
  
  private static float a(TextPaint paramTextPaint)
  {
    float f1 = paramTextPaint.getTextSize();
    Float localFloat = (Float)f.get(Float.valueOf(f1));
    paramTextPaint = localFloat;
    if (localFloat == null)
    {
      paramTextPaint = b.getFontMetrics();
      paramTextPaint = Float.valueOf(paramTextPaint.descent - paramTextPaint.ascent + paramTextPaint.leading);
      f.put(Float.valueOf(f1), paramTextPaint);
    }
    return paramTextPaint.floatValue();
  }
  
  public static float a(PhotoDanmakuConfig paramPhotoDanmakuConfig)
  {
    return a(paramPhotoDanmakuConfig.j) + paramPhotoDanmakuConfig.g * 2;
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int n = paramBitmap.getWidth();
    int i1 = paramBitmap.getHeight();
    float f3;
    float f2;
    float f1;
    float f4;
    if (n <= i1)
    {
      f3 = n;
      f2 = f3 / 2.0F;
      f1 = f3;
      f4 = 0.0F;
    }
    else
    {
      f1 = i1;
      f2 = f1 / 2.0F;
      f4 = (n - i1) / 2.0F;
      f3 = n - f4;
      n = i1;
    }
    Bitmap localBitmap = Bitmap.createBitmap(n, n, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect1 = new Rect((int)f4, (int)0.0F, (int)f3, (int)f1);
    Rect localRect2 = new Rect((int)0.0F, (int)0.0F, (int)f1, (int)f1);
    RectF localRectF = new RectF(localRect2);
    localPaint.setAntiAlias(true);
    localCanvas.drawRoundRect(localRectF, f2, f2, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
    return localBitmap;
  }
  
  private static String a(AbsDanmaku paramAbsDanmaku, PhotoDanmakuDrawer.PaintType paramPaintType)
  {
    if ((paramAbsDanmaku != null) && (paramPaintType != null))
    {
      if (paramPaintType == PhotoDanmakuDrawer.PaintType.Measure) {
        return String.valueOf(paramAbsDanmaku.t());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('n');
      localStringBuilder.append(paramAbsDanmaku.z());
      localStringBuilder.append(paramAbsDanmaku.X());
      if (PhotoDanmakuDrawer.5.a[paramPaintType.ordinal()] != 1)
      {
        localStringBuilder.append(paramPaintType.ordinal());
        localStringBuilder.append(paramAbsDanmaku.t());
        localStringBuilder.append(paramAbsDanmaku.u());
      }
      else
      {
        localStringBuilder.append("b");
        localStringBuilder.append(paramAbsDanmaku.L());
        localStringBuilder.append(paramAbsDanmaku.A());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return paramString;
      }
      Object localObject = Pattern.compile("@\\{uin:\\d+?,nick:(.+?),who:\\d+?\\}").matcher(paramString);
      StringBuilder localStringBuilder1 = new StringBuilder(paramString.length());
      for (int n = 0; ((Matcher)localObject).find(); n = ((Matcher)localObject).end())
      {
        localStringBuilder1.append(paramString.substring(n, ((Matcher)localObject).start()));
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("@");
        localStringBuilder2.append(((Matcher)localObject).group(1));
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder1.append(paramString.substring(n));
      localObject = localStringBuilder1.toString();
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
    int i1 = 0;
    int n = 0;
    while (i1 < paramString.length())
    {
      int i2 = i1 + 1;
      if (paramString.substring(i1, i2).matches("[一-龥]")) {
        n += 2;
      } else {
        n += 1;
      }
      if (n > paramInt)
      {
        paramInt = i1 - 1;
        while (paramInt < paramString.length())
        {
          n = paramInt;
          if (!a(paramString.charAt(paramInt))) {
            break label89;
          }
          paramInt += 1;
        }
        n = -1;
        label89:
        if (n == -1) {
          return paramString;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.substring(0, n));
        localStringBuilder.append("...");
        return localStringBuilder.toString();
      }
      i1 = i2;
    }
    return paramString;
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, AbsDanmaku paramAbsDanmaku, FeedCloudMeta.StUser paramStUser, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramAbsDanmaku != null) && (paramAbsDanmaku.ac() != null) && (!paramAbsDanmaku.ac().isRecycled()) && (paramCanvas != null))
    {
      paramPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(paramAbsDanmaku.ac(), paramFloat1, paramFloat2, paramPaint);
      return;
    }
    paramCanvas = paramStUser.icon.iconUrl.get();
    if (!TextUtils.isEmpty(paramCanvas))
    {
      QCircleFeedPicLoader.g().loadImage(new Option().setUrl(paramCanvas).setFailDrawable(this.l.getResources().getDrawable(2130845204)).setLoadingDrawable(this.l.getResources().getDrawable(2130845204)), new PhotoDanmakuDrawer.2(this, paramAbsDanmaku, paramFloat3, paramFloat4, paramPaint));
      return;
    }
    HostFaceUtils.getFaceDrawable(1, String.valueOf(paramStUser.id.get()), 4, this.l.getResources().getDrawable(2130845204), this.l.getResources().getDrawable(2130845204), new PhotoDanmakuDrawer.3(this, paramAbsDanmaku, paramFloat3, paramFloat4, paramPaint));
  }
  
  private void a(Canvas paramCanvas, AbsDanmaku paramAbsDanmaku, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    System.currentTimeMillis();
    float f3 = paramAbsDanmaku.O().m;
    TextPaint localTextPaint = (TextPaint)b(paramAbsDanmaku, PhotoDanmakuDrawer.PaintType.Normal);
    float f2 = paramFloat1 + paramAbsDanmaku.M();
    float f4 = ViewUtils.a(5.0F);
    float f5 = ViewUtils.a(2.0F);
    float f1 = f2;
    if (paramAbsDanmaku.w() != -10L) {
      f1 = f2 + (paramAbsDanmaku.W() + paramFloat4) - ViewUtils.a(50.0F);
    }
    f1 += paramAbsDanmaku.L();
    float f6 = paramAbsDanmaku.L();
    float f7 = paramAbsDanmaku.N();
    Object localObject = paramAbsDanmaku.J();
    f6 = paramFloat2 + (f6 + f7) + paramAbsDanmaku.P();
    if (localObject != null)
    {
      localTextPaint.setTypeface(Typeface.DEFAULT);
      if (paramAbsDanmaku.v() == -1)
      {
        localTextPaint.setColor(paramAbsDanmaku.u());
        localTextPaint.setAlpha(178);
      }
      else
      {
        localTextPaint.setColor(paramAbsDanmaku.v());
      }
      if (paramAbsDanmaku.n) {
        localTextPaint.setShadowLayer(paramAbsDanmaku.o, paramAbsDanmaku.p, paramAbsDanmaku.q, paramAbsDanmaku.r);
      }
      paramCanvas.drawText(paramAbsDanmaku.K(), f1, f6, localTextPaint);
      paramCanvas.save();
      if (paramAbsDanmaku.w() == -10L) {
        paramCanvas.translate(paramFloat1 + localTextPaint.measureText(paramAbsDanmaku.K()), f6 - localTextPaint.getTextSize());
      } else {
        paramCanvas.translate(paramFloat1 + paramFloat4 + paramAbsDanmaku.W() + localTextPaint.measureText(paramAbsDanmaku.K()) - ViewUtils.a(8.0F), f6 - localTextPaint.getTextSize());
      }
      localObject = new CellTextView(this.l);
      ((CellTextView)localObject).setTextSize(localTextPaint.getTextSize());
      ((CellTextView)localObject).setTextGravity(17);
      ((CellTextView)localObject).setTextBold(true);
      ((CellTextView)localObject).a(paramAbsDanmaku.J());
      ((CellTextView)localObject).setTextColorLink(paramAbsDanmaku.u());
      ((CellTextView)localObject).setTextColor(paramAbsDanmaku.u());
      ((CellTextView)localObject).setOuterListener(new PhotoDanmakuDrawer.4(this, paramAbsDanmaku));
      ((CellTextView)localObject).setMaxLine(1);
      int n = (int)paramFloat3;
      ((CellTextView)localObject).measure(View.MeasureSpec.makeMeasureSpec(n, 0), View.MeasureSpec.makeMeasureSpec((int)paramFloat4, 0));
      ((CellTextView)localObject).layout((int)f1, (int)f6, n, (int)paramAbsDanmaku.G());
      ((CellTextView)localObject).draw(paramCanvas);
    }
    try
    {
      paramCanvas.restore();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label441:
      break label441;
    }
    QLog.e("PhotoDanmakuDrawer", 1, "drawText get an IllegalStateException: canvas.restore()");
    if (paramAbsDanmaku.w() != -10L) {
      a(paramCanvas, localTextPaint, paramAbsDanmaku, paramAbsDanmaku.x(), f2 - f4, f5 + (paramFloat2 + f3), ViewUtils.a(22.0F), ViewUtils.a(22.0F));
    }
  }
  
  private void a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, boolean paramBoolean)
  {
    paramString = this.l.getResources().getDrawable(2130845068);
    if (paramString != null)
    {
      paramCanvas.save();
      i.set((int)paramFloat1, (int)paramFloat2, (int)(paramFloat1 + paramFloat3), (int)(paramFloat2 + paramFloat4));
      paramString.setBounds(i);
      paramString.draw(paramCanvas);
      QLog.i("PhotoDanmakuDrawer", 4, "drawBg");
    }
    try
    {
      paramCanvas.restore();
    }
    catch (IllegalStateException paramString)
    {
      label74:
      int n;
      int i1;
      int i2;
      int i3;
      int i4;
      break label74;
    }
    QLog.e("PhotoDanmakuDrawer", 1, "drawText get an IllegalStateException: canvas.restore()");
    if (paramInt > 0)
    {
      if (paramBoolean) {
        paramString = this.l.getResources().getDrawable(2130845069);
      } else {
        paramString = this.l.getResources().getDrawable(2130845071);
      }
      if (paramString != null)
      {
        paramCanvas.save();
        n = 10;
        if (paramInt > 10) {
          paramInt = n;
        }
        n = (int)paramFloat1;
        i1 = (int)paramFloat2;
        i2 = (int)(paramFloat1 + paramFloat3);
        i3 = i2 / 10;
        i4 = (int)(paramFloat2 + paramFloat4);
        paramCanvas.clipRect(n, i1, i3 * paramInt, i4);
        i.set(n, i1, i2, i4);
        paramString.setBounds(i);
        paramString.draw(paramCanvas);
        QLog.e("PhotoDanmakuDrawer", 1, "drawbg");
      }
    }
    try
    {
      paramCanvas.restore();
      return;
    }
    catch (IllegalStateException paramCanvas)
    {
      label240:
      break label240;
    }
    QLog.e("PhotoDanmakuDrawer", 1, "drawText get an IllegalStateException: canvas.restore()");
  }
  
  private void a(AbsDanmaku paramAbsDanmaku, float paramFloat1, float paramFloat2, Bitmap paramBitmap)
  {
    if ((paramAbsDanmaku != null) && (paramBitmap != null))
    {
      paramBitmap = a(Bitmap.createScaledBitmap(paramBitmap, (int)paramFloat1, (int)paramFloat2, false));
      if (paramBitmap != null) {
        paramAbsDanmaku.b(paramBitmap);
      }
    }
  }
  
  private void a(AbsDanmaku paramAbsDanmaku, Paint paramPaint, float paramFloat1, float paramFloat2)
  {
    if (paramAbsDanmaku != null)
    {
      paramPaint.setAntiAlias(true);
      if (this.m == null) {
        this.m = a(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.l.getResources(), 2130845204), (int)paramFloat1, (int)paramFloat2, false));
      }
      paramAbsDanmaku.b(this.m);
    }
  }
  
  private void a(AbsDanmaku paramAbsDanmaku, TextPaint paramTextPaint)
  {
    float f1 = a(paramTextPaint);
    float f3 = paramAbsDanmaku.L() * 2.0F;
    float f4 = paramAbsDanmaku.M();
    f1 = f3 + paramAbsDanmaku.N() * 2.0F + f1;
    Object localObject5 = paramAbsDanmaku.s().toString();
    String str = a(paramAbsDanmaku.K(), 16);
    Object localObject1 = HostEmotionUtil.replaceEmoCode((String)localObject5, "");
    int n = HostEmotionUtil.getEmoCount((String)localObject5);
    Object localObject6 = TextCellParser.a((String)localObject1);
    Object localObject4 = a((String)localObject5);
    int i2;
    int i1;
    if ((n > 0) && (b((String)localObject6) + n * 2 > 200))
    {
      localObject1 = new ArrayList();
      localObject6 = new ArrayList();
      QLog.d("PhotoDanmakuDrawer", 1, "rawContentStr is too long");
      Matcher localMatcher = HostEmotionUtil.SMILEY_PATTERN().matcher((CharSequence)localObject5);
      while (localMatcher.find())
      {
        ((ArrayList)localObject1).add(Integer.valueOf(localMatcher.start()));
        ((ArrayList)localObject6).add(Integer.valueOf(localMatcher.end() - 1));
      }
      i2 = 0;
      n = 0;
      i1 = 0;
    }
    for (;;)
    {
      try
      {
        if (n < ((String)localObject4).length())
        {
          int i3 = ((ArrayList)localObject1).size();
          f2 = f1;
          if (i2 < i3) {}
          try
          {
            if (n == ((Integer)((ArrayList)localObject1).get(i2)).intValue())
            {
              i1 += 2;
              n = ((Integer)((ArrayList)localObject6).get(i2)).intValue();
              i2 += 1;
              if (i1 < 200) {
                break label762;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((String)localObject4).substring(0, n + 1));
              ((StringBuilder)localObject1).append("...");
              localObject1 = ((StringBuilder)localObject1).toString();
              f1 = f2;
              break label507;
            }
            if (!((String)localObject5).substring(n, n + 1).matches("[一-龥]")) {
              break label765;
            }
            i1 += 2;
            if (i1 >= 200)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((String)localObject4).substring(0, n));
              ((StringBuilder)localObject1).append("...");
              localObject1 = ((StringBuilder)localObject1).toString();
              f1 = f2;
              break label507;
            }
            n += 1;
            f1 = f2;
          }
          catch (Exception localException1)
          {
            continue;
          }
        }
        Object localObject2 = localObject4;
      }
      catch (Exception localException2)
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("danmaku clip get an Exception:");
        ((StringBuilder)localObject5).append(localException2.toString());
        QLog.e("PhotoDanmakuDrawer", 1, ((StringBuilder)localObject5).toString());
        localObject3 = localObject4;
      }
      float f2 = f1;
      Object localObject3 = localObject4;
      f1 = f2;
      if (n == 0)
      {
        localObject3 = a((String)localObject6, 200);
        f1 = f2;
      }
      label507:
      localObject4 = str;
      if (!str.isEmpty())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(str);
        ((StringBuilder)localObject4).append("： ");
        localObject4 = ((StringBuilder)localObject4).toString();
      }
      f2 = paramTextPaint.measureText((String)localObject4);
      n = HostEmotionUtil.getEmoCount((String)localObject3);
      f3 = f4 * 2.0F + f3 + 0.0F + (paramTextPaint.measureText(TextCellParser.a(HostEmotionUtil.replaceEmoCode((String)localObject3, ""))) + f2 + n * (paramTextPaint.getTextSize() + paramTextPaint.measureText(".")));
      paramAbsDanmaku.c((String)localObject4);
      paramAbsDanmaku.b((String)localObject3);
      paramAbsDanmaku.h(-paramTextPaint.ascent());
      f2 = f3;
      if (paramAbsDanmaku.w() != -10L) {
        f2 = f3 + f1;
      }
      f3 = f2;
      if (paramAbsDanmaku.af > 10) {
        f3 = f2 + ViewUtils.a(8.0F);
      }
      f2 = f3;
      if (paramAbsDanmaku.af > 100) {
        f2 = f3 + ViewUtils.a(8.0F);
      }
      f2 += paramAbsDanmaku.W();
      paramAbsDanmaku.j(f2);
      paramAbsDanmaku.i(f1);
      f3 = paramAbsDanmaku.C() * 2;
      f4 = paramAbsDanmaku.B() * 2;
      paramAbsDanmaku.b(f2 + f3);
      paramAbsDanmaku.c(f1 + f4);
      return;
      label762:
      continue;
      label765:
      i1 += 1;
    }
  }
  
  private boolean a(char paramChar)
  {
    return (paramChar != 0) && (paramChar != '\t') && (paramChar != '\n') && (paramChar != '\r') && ((paramChar < ' ') || (paramChar > 55295)) && ((paramChar < 57344) || (paramChar > 65533));
  }
  
  private int b(String paramString)
  {
    int i1 = 0;
    int n = 0;
    while (i1 < paramString.length())
    {
      int i2 = i1 + 1;
      if (paramString.substring(i1, i2).matches("[一-龥]")) {
        n += 2;
      } else {
        n += 1;
      }
      i1 = i2;
    }
    return n;
  }
  
  private static Paint b(AbsDanmaku paramAbsDanmaku, PhotoDanmakuDrawer.PaintType paramPaintType)
  {
    int n = PhotoDanmakuDrawer.5.a[paramPaintType.ordinal()];
    String str;
    if (n != 1)
    {
      if (n != 2)
      {
        if ((n != 3) && (n != 4))
        {
          localObject = null;
        }
        else
        {
          str = paramAbsDanmaku.Q();
          localObject = str;
          if (str == null)
          {
            localObject = a(paramAbsDanmaku, paramPaintType);
            paramAbsDanmaku.d((String)localObject);
          }
        }
      }
      else {
        localObject = a(paramAbsDanmaku, paramPaintType);
      }
    }
    else
    {
      str = paramAbsDanmaku.R();
      localObject = str;
      if (str == null)
      {
        localObject = a(paramAbsDanmaku, paramPaintType);
        paramAbsDanmaku.e((String)localObject);
      }
    }
    Object localObject = (Paint)g.get(localObject);
    if (localObject != null) {
      return localObject;
    }
    if (paramPaintType == PhotoDanmakuDrawer.PaintType.Hint) {
      localObject = new Paint();
    } else {
      localObject = new TextPaint();
    }
    if (paramPaintType == PhotoDanmakuDrawer.PaintType.Measure)
    {
      ((Paint)localObject).setTextSize(paramAbsDanmaku.t());
      return localObject;
    }
    ((Paint)localObject).setTextSize(paramAbsDanmaku.t());
    ((Paint)localObject).setAlpha(paramAbsDanmaku.z());
    ((Paint)localObject).setAntiAlias(paramAbsDanmaku.X());
    if (PhotoDanmakuDrawer.5.a[paramPaintType.ordinal()] != 1)
    {
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      ((Paint)localObject).setColor(paramAbsDanmaku.u());
      ((Paint)localObject).setTypeface(Typeface.DEFAULT_BOLD);
      ((Paint)localObject).clearShadowLayer();
    }
    else
    {
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      ((Paint)localObject).setStrokeWidth(paramAbsDanmaku.L());
      ((Paint)localObject).setColor(paramAbsDanmaku.A());
    }
    g.put(a(paramAbsDanmaku, paramPaintType), localObject);
    return localObject;
  }
  
  public void a(Canvas paramCanvas)
  {
    this.k = paramCanvas;
  }
  
  public void a(Canvas paramCanvas, AbsDanmaku paramAbsDanmaku, float paramFloat1, float paramFloat2)
  {
    float f1 = paramAbsDanmaku.T();
    float f2 = paramAbsDanmaku.S();
    a(paramCanvas, paramAbsDanmaku.y(), paramFloat1 - PhotoDanmakuConfig.b, paramFloat2 - PhotoDanmakuConfig.c, f1 + PhotoDanmakuConfig.b * 2, f2 + PhotoDanmakuConfig.c * 2, paramAbsDanmaku.af, paramAbsDanmaku.ag);
    a(paramCanvas, paramAbsDanmaku, paramFloat1, paramFloat2, f1, f2);
  }
  
  public void a(AbsDanmaku paramAbsDanmaku)
  {
    if (this.k != null)
    {
      if ((paramAbsDanmaku.Y()) && (PhotoDanmakuConfig.a()))
      {
        Object localObject2 = paramAbsDanmaku.Z();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = this.h.a((int)paramAbsDanmaku.F(), (int)paramAbsDanmaku.G());
          paramAbsDanmaku.a((Bitmap)localObject1);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (paramAbsDanmaku.aa())
          {
            paramAbsDanmaku.f(false);
            if (((Bitmap)localObject1).getWidth() >= (int)paramAbsDanmaku.F())
            {
              localObject2 = localObject1;
              if (((Bitmap)localObject1).getHeight() >= (int)paramAbsDanmaku.G()) {}
            }
            else
            {
              this.h.a((Bitmap)localObject1);
              localObject2 = this.h.a((int)paramAbsDanmaku.F(), (int)paramAbsDanmaku.G());
              paramAbsDanmaku.a((Bitmap)localObject2);
            }
            localObject1 = paramAbsDanmaku.ab();
            if (localObject1 == null)
            {
              localObject1 = new Canvas((Bitmap)localObject2);
              paramAbsDanmaku.a((Canvas)localObject1);
            }
            else
            {
              ((Canvas)localObject1).setBitmap((Bitmap)localObject2);
            }
            ((Bitmap)localObject2).eraseColor(0);
            a((Canvas)localObject1, paramAbsDanmaku, paramAbsDanmaku.C(), paramAbsDanmaku.B());
          }
          n = this.k.save();
          this.c.set(0, 0, (int)paramAbsDanmaku.F(), (int)paramAbsDanmaku.G());
          this.d.set((int)paramAbsDanmaku.l(), (int)paramAbsDanmaku.m(), (int)paramAbsDanmaku.n(), (int)paramAbsDanmaku.o());
          this.k.drawBitmap((Bitmap)localObject2, this.c, this.d, this.j);
          this.k.restoreToCount(n);
          return;
        }
        PhotoDanmakuConfig.a(false);
      }
      int n = this.k.save();
      a(this.k, paramAbsDanmaku, paramAbsDanmaku.U(), paramAbsDanmaku.V());
      this.k.restoreToCount(n);
    }
  }
  
  public void b(AbsDanmaku paramAbsDanmaku)
  {
    PhotoDanmakuDrawer.PaintType localPaintType;
    if ((paramAbsDanmaku.s() instanceof SpannableString)) {
      localPaintType = PhotoDanmakuDrawer.PaintType.StaticLayout;
    } else {
      localPaintType = PhotoDanmakuDrawer.PaintType.Measure;
    }
    a(paramAbsDanmaku, (TextPaint)b(paramAbsDanmaku, localPaintType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer
 * JD-Core Version:    0.7.0.1
 */
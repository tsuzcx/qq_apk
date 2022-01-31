package com.tencent.mobileqq.arcard.ARWordingBless;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;

public class RubberStamp
{
  private Context a;
  
  public RubberStamp(@NonNull Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a(@NonNull Bitmap paramBitmap, @NonNull RubberStampConfig paramRubberStampConfig, @NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setUnderlineText(false);
    int i = paramRubberStampConfig.e();
    if ((i >= 0) && (i <= 255)) {
      localPaint.setAlpha(i);
    }
    int j = paramRubberStampConfig.f();
    i = paramRubberStampConfig.g();
    int k = paramRubberStampConfig.d();
    if (k != 0)
    {
      Pair localPair = RubberStampConfig.a(k, paramInt1, paramInt2, paramBitmap.getWidth(), paramBitmap.getHeight());
      j = ((Integer)localPair.first).intValue();
      i = ((Integer)localPair.second).intValue() - paramBitmap.getHeight();
    }
    paramInt1 = j + paramRubberStampConfig.i();
    paramInt2 = i + paramRubberStampConfig.j();
    float f = paramRubberStampConfig.a();
    if (f != 0.0F) {
      paramCanvas.rotate(f, paramBitmap.getWidth() / 2 + paramInt1, paramBitmap.getHeight() / 2 + paramInt2);
    }
    if (k != 10)
    {
      paramCanvas.drawBitmap(paramBitmap, paramInt1, paramInt2, localPaint);
      return;
    }
    localPaint.setShader(new BitmapShader(paramBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
    paramCanvas.drawRect(paramCanvas.getClipBounds(), localPaint);
  }
  
  private void a(@NonNull RubberStampConfig paramRubberStampConfig, @NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Object localObject1 = new Rect();
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setUnderlineText(false);
    localPaint.setTextSize(paramRubberStampConfig.a());
    Object localObject2 = paramRubberStampConfig.a();
    float f1;
    int k;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localPaint.setTypeface(Typeface.createFromAsset(this.a.getAssets(), (String)localObject2));
      localObject2 = paramRubberStampConfig.a();
      if (localObject2 != null) {
        localPaint.setShader((Shader)localObject2);
      }
      if ((paramRubberStampConfig.c() != 0.0F) || (paramRubberStampConfig.d() != 0.0F) || (paramRubberStampConfig.b() != 0.0F)) {
        localPaint.setShadowLayer(paramRubberStampConfig.b(), paramRubberStampConfig.c(), paramRubberStampConfig.d(), paramRubberStampConfig.h());
      }
      localObject2 = paramRubberStampConfig.b();
      localPaint.getTextBounds((String)localObject2, 0, ((String)localObject2).length(), (Rect)localObject1);
      int m = ((Rect)localObject1).width();
      f1 = localPaint.measureText((String)localObject2);
      k = ((Rect)localObject1).height();
      int j = paramRubberStampConfig.f();
      int i = paramRubberStampConfig.g();
      Object localObject3;
      if (paramRubberStampConfig.d() != 0)
      {
        localObject3 = RubberStampConfig.a(paramRubberStampConfig.d(), paramInt1, paramInt2, m, k);
        j = ((Integer)((Pair)localObject3).first).intValue();
        i = ((Integer)((Pair)localObject3).second).intValue();
      }
      paramInt2 = j + paramRubberStampConfig.i();
      paramInt1 = i + paramRubberStampConfig.j();
      float f2 = paramRubberStampConfig.a();
      if (f2 != 0.0F) {
        paramCanvas.rotate(f2, paramInt2 + ((Rect)localObject1).exactCenterX(), paramInt1 - ((Rect)localObject1).exactCenterY());
      }
      localPaint.setColor(paramRubberStampConfig.b());
      i = paramRubberStampConfig.e();
      if ((i >= 0) && (i <= 255)) {
        localPaint.setAlpha(i);
      }
      if (paramRubberStampConfig.d() == 10) {
        break label503;
      }
      i = paramRubberStampConfig.c();
      if (i != 0)
      {
        localObject3 = new Paint();
        ((Paint)localObject3).setColor(i);
        paramCanvas.drawRect(paramInt2 - 10, paramInt1 - ((Rect)localObject1).height() - localPaint.getFontMetrics().descent - 10.0F, 10.0F + (paramInt2 + f1 + paramRubberStampConfig.c()), 10.0F + (paramInt1 + paramRubberStampConfig.d() + localPaint.getFontMetrics().descent), (Paint)localObject3);
      }
      i = (int)localPaint.getFontMetrics().descent;
      if ((paramRubberStampConfig.d() != 8) && (paramRubberStampConfig.d() != 7) && (paramRubberStampConfig.d() != 9)) {
        break label570;
      }
      paramInt1 -= i;
    }
    label570:
    for (;;)
    {
      paramCanvas.drawText((String)localObject2, paramInt2, paramInt1, localPaint);
      return;
      localPaint.setTypeface(paramRubberStampConfig.a());
      break;
      label503:
      localObject1 = Bitmap.createBitmap((int)f1, k, Bitmap.Config.ARGB_8888);
      new Canvas((Bitmap)localObject1).drawText(paramRubberStampConfig.b(), 0.0F, k, localPaint);
      localPaint.setShader(new BitmapShader((Bitmap)localObject1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
      paramCanvas.drawRect(paramCanvas.getClipBounds(), localPaint);
      return;
    }
  }
  
  public Bitmap a(Bitmap paramBitmap, RubberStampConfig[] paramArrayOfRubberStampConfig)
  {
    if ((paramArrayOfRubberStampConfig == null) || (paramBitmap == null)) {
      return paramBitmap;
    }
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    Canvas localCanvas = new Canvas(paramBitmap);
    int m = paramArrayOfRubberStampConfig.length;
    int i = 0;
    label38:
    RubberStampConfig localRubberStampConfig;
    if (i < m)
    {
      localRubberStampConfig = paramArrayOfRubberStampConfig[i];
      if (TextUtils.isEmpty(localRubberStampConfig.b())) {
        break label79;
      }
      a(localRubberStampConfig, localCanvas, j, k);
    }
    for (;;)
    {
      i += 1;
      break label38;
      break;
      label79:
      if (localRubberStampConfig.a() != null) {
        a(localRubberStampConfig.a(), localRubberStampConfig, localCanvas, j, k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARWordingBless.RubberStamp
 * JD-Core Version:    0.7.0.1
 */
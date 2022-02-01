package com.tencent.mobileqq.apollo.barrage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApolloBarrageUtil
{
  public static int a(Paint paramPaint)
  {
    return (int)(paramPaint.measureText(HardCodeUtil.a(2131898554)) + 1.0F);
  }
  
  public static void a(int paramInt1, int paramInt2, BarrageUI paramBarrageUI, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(null, paramInt1, paramInt2, paramBarrageUI, paramContext, paramString1, paramString2, paramBoolean);
  }
  
  public static void a(BarrageUI paramBarrageUI, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBarrageUI != null) {
      a(paramBarrageUI.getUIWidth(), paramBarrageUI.getUIHeight(), paramBarrageUI, paramContext, paramString1, paramString2, paramBoolean);
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, BarrageUI paramBarrageUI, Context paramContext, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramBarrageUI != null) && (paramContext != null))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      if (paramString3.length() > 12)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString3.substring(0, 11));
        ((StringBuilder)localObject1).append("...");
        paramString3 = ((StringBuilder)localObject1).toString();
      }
      if (paramInt1 == 0) {
        paramInt1 = paramBarrageUI.getUIWidth();
      }
      if (paramInt2 == 0) {
        paramInt2 = paramBarrageUI.getUIHeight();
      }
      long l = System.currentTimeMillis();
      Object localObject1 = new ArrayList();
      Object localObject2 = paramBarrageUI.getBarrageCache();
      float f1 = DeviceInfoUtil.A();
      float f2 = paramInt1;
      float f3 = paramInt2;
      Barrage localBarrage1 = new Barrage((AbsBarrageCache)localObject2, f1, f2, f3, paramString2, paramString3);
      localBarrage1.e = f2;
      localBarrage1.i = f2;
      localBarrage1.f = 0.0F;
      localBarrage1.j = 0.0F;
      f1 = -paramInt1;
      localBarrage1.g = (f1 / 4000.0F);
      localBarrage1.h = 0.0F;
      localBarrage1.u = 1.0F;
      localBarrage1.l = (paramContext.getResources().getDisplayMetrics().scaledDensity * 17.0F);
      localBarrage1.v = true;
      localBarrage1.x = paramString1;
      int[] arrayOfInt = new int[5];
      int[] tmp244_242 = arrayOfInt;
      tmp244_242[0] = 14;
      int[] tmp249_244 = tmp244_242;
      tmp249_244[1] = 14;
      int[] tmp254_249 = tmp249_244;
      tmp254_249[2] = 12;
      int[] tmp259_254 = tmp254_249;
      tmp259_254[3] = 12;
      int[] tmp264_259 = tmp259_254;
      tmp264_259[4] = 12;
      tmp264_259;
      localObject2 = new float[3];
      Object tmp277_275 = localObject2;
      tmp277_275[0] = 0.6F;
      Object tmp282_277 = tmp277_275;
      tmp282_277[1] = 0.8F;
      Object tmp287_282 = tmp282_277;
      tmp287_282[2] = 1.0F;
      tmp287_282;
      Random localRandom = new Random();
      paramInt2 = 0;
      while (paramInt2 < 5)
      {
        Barrage localBarrage2 = new Barrage(paramBarrageUI.getBarrageCache(), DeviceInfoUtil.A(), f2, f3, paramString2, paramString3);
        localBarrage2.g = (f1 / (3000.0F - paramInt2 * 500));
        localBarrage2.h = 0.0F;
        localBarrage2.p = ((int)(localObject2[localRandom.nextInt(3)] * 255.0F));
        localBarrage2.l = (arrayOfInt[paramInt2] * paramContext.getResources().getDisplayMetrics().scaledDensity);
        localBarrage2.u = AbsBarrageCache.a(localBarrage1, localBarrage2);
        float f4 = f2 * localRandom.nextFloat() + paramInt1 / 2;
        localBarrage2.e = f4;
        localBarrage2.i = f4;
        f4 = (f3 - (f3 * 0.28F + AbsBarrageCache.a(localBarrage2.l) + localBarrage2.t * 2)) * localRandom.nextFloat();
        localBarrage2.f = f4;
        localBarrage2.j = f4;
        localBarrage2.v = true;
        localBarrage2.x = paramString1;
        ((List)localObject1).add(localBarrage2);
        paramInt2 += 1;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("bulkApolloBarrages use:");
        paramString1.append(System.currentTimeMillis() - l);
        QLog.d("ApolloBarrageUtil", 2, paramString1.toString());
      }
      ((List)localObject1).add(localBarrage1);
      paramBarrageUI.a((List)localObject1, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil
 * JD-Core Version:    0.7.0.1
 */
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
    return (int)(1.0F + paramPaint.measureText(HardCodeUtil.a(2131700381)));
  }
  
  public static void a(int paramInt1, int paramInt2, BarrageUI paramBarrageUI, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(null, paramInt1, paramInt2, paramBarrageUI, paramContext, paramString1, paramString2, paramBoolean);
  }
  
  public static void a(BarrageUI paramBarrageUI, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBarrageUI != null) {
      a(paramBarrageUI.a(), paramBarrageUI.b(), paramBarrageUI, paramContext, paramString1, paramString2, paramBoolean);
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, BarrageUI paramBarrageUI, Context paramContext, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramBarrageUI == null) || (paramContext == null) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    if (paramString3.length() > 12) {
      paramString3 = paramString3.substring(0, 11) + "...";
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 == 0) {
        i = paramBarrageUI.a();
      }
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = paramBarrageUI.b();
      }
      long l = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      Barrage localBarrage1 = new Barrage(paramBarrageUI.a(), DeviceInfoUtil.a(), i, paramInt1, paramString2, paramString3);
      float f1 = i;
      localBarrage1.a = f1;
      localBarrage1.e = f1;
      localBarrage1.jdField_b_of_type_Float = 0.0F;
      localBarrage1.f = 0.0F;
      localBarrage1.c = (-i / 4000.0F);
      localBarrage1.jdField_d_of_type_Float = 0.0F;
      localBarrage1.jdField_h_of_type_Float = 1.0F;
      localBarrage1.g = (17.0F * paramContext.getResources().getDisplayMetrics().scaledDensity);
      localBarrage1.jdField_b_of_type_Boolean = true;
      localBarrage1.jdField_b_of_type_JavaLangString = paramString1;
      Random localRandom = new Random();
      paramInt2 = 0;
      while (paramInt2 < 5)
      {
        Barrage localBarrage2 = new Barrage(paramBarrageUI.a(), DeviceInfoUtil.a(), i, paramInt1, paramString2, paramString3);
        localBarrage2.c = (-i / (3000.0F - paramInt2 * 500));
        localBarrage2.jdField_d_of_type_Float = 0.0F;
        int j = localRandom.nextInt(3);
        localBarrage2.jdField_d_of_type_Int = ((int)(new float[] { 0.6F, 0.8F, 1.0F }[j] * 255.0F));
        localBarrage2.g = (new int[] { 14, 14, 12, 12, 12 }[paramInt2] * paramContext.getResources().getDisplayMetrics().scaledDensity);
        localBarrage2.jdField_h_of_type_Float = AbsBarrageCache.a(localBarrage1, localBarrage2);
        f1 = i * localRandom.nextFloat() + i / 2;
        localBarrage2.a = f1;
        localBarrage2.e = f1;
        f1 = paramInt1;
        float f2 = AbsBarrageCache.a(localBarrage2.g);
        float f3 = localBarrage2.jdField_h_of_type_Int * 2;
        f1 = (paramInt1 - (f1 * 0.28F + f2 + f3)) * localRandom.nextFloat();
        localBarrage2.jdField_b_of_type_Float = f1;
        localBarrage2.f = f1;
        localBarrage2.jdField_b_of_type_Boolean = true;
        localBarrage2.jdField_b_of_type_JavaLangString = paramString1;
        localArrayList.add(localBarrage2);
        paramInt2 += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBarrageUtil", 2, "bulkApolloBarrages use:" + (System.currentTimeMillis() - l));
      }
      localArrayList.add(localBarrage1);
      paramBarrageUI.a(localArrayList, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.ApolloBarrageUtil
 * JD-Core Version:    0.7.0.1
 */
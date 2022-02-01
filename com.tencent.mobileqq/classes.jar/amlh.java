import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class amlh
{
  public static int a(Paint paramPaint)
  {
    return (int)(1.0F + paramPaint.measureText(anni.a(2131699110)));
  }
  
  public static void a(int paramInt1, int paramInt2, amlj paramamlj, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(null, paramInt1, paramInt2, paramamlj, paramContext, paramString1, paramString2, paramBoolean);
  }
  
  public static void a(amlj paramamlj, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramamlj != null) {
      a(paramamlj.a(), paramamlj.b(), paramamlj, paramContext, paramString1, paramString2, paramBoolean);
    }
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, amlj paramamlj, Context paramContext, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((paramamlj == null) || (paramContext == null) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    if (paramString3.length() > 12) {
      paramString3 = paramString3.substring(0, 11) + "...";
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 == 0) {
        i = paramamlj.a();
      }
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = paramamlj.b();
      }
      long l = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      amli localamli1 = new amli(paramamlj.a(), bgln.a(), i, paramInt1, paramString2, paramString3);
      float f1 = i;
      localamli1.a = f1;
      localamli1.e = f1;
      localamli1.jdField_b_of_type_Float = 0.0F;
      localamli1.f = 0.0F;
      localamli1.c = (-i / 4000.0F);
      localamli1.jdField_d_of_type_Float = 0.0F;
      localamli1.jdField_h_of_type_Float = 1.0F;
      localamli1.g = (17.0F * paramContext.getResources().getDisplayMetrics().scaledDensity);
      localamli1.jdField_b_of_type_Boolean = true;
      localamli1.jdField_b_of_type_JavaLangString = paramString1;
      Random localRandom = new Random();
      paramInt2 = 0;
      while (paramInt2 < 5)
      {
        amli localamli2 = new amli(paramamlj.a(), bgln.a(), i, paramInt1, paramString2, paramString3);
        localamli2.c = (-i / (3000.0F - paramInt2 * 500));
        localamli2.jdField_d_of_type_Float = 0.0F;
        int j = localRandom.nextInt(3);
        localamli2.jdField_d_of_type_Int = ((int)(new float[] { 0.6F, 0.8F, 1.0F }[j] * 255.0F));
        localamli2.g = (new int[] { 14, 14, 12, 12, 12 }[paramInt2] * paramContext.getResources().getDisplayMetrics().scaledDensity);
        localamli2.jdField_h_of_type_Float = amle.a(localamli1, localamli2);
        f1 = i * localRandom.nextFloat() + i / 2;
        localamli2.a = f1;
        localamli2.e = f1;
        f1 = paramInt1;
        float f2 = amle.a(localamli2.g);
        float f3 = localamli2.jdField_h_of_type_Int * 2;
        f1 = (paramInt1 - (f1 * 0.28F + f2 + f3)) * localRandom.nextFloat();
        localamli2.jdField_b_of_type_Float = f1;
        localamli2.f = f1;
        localamli2.jdField_b_of_type_Boolean = true;
        localamli2.jdField_b_of_type_JavaLangString = paramString1;
        localArrayList.add(localamli2);
        paramInt2 += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBarrageUtil", 2, "bulkApolloBarrages use:" + (System.currentTimeMillis() - l));
      }
      localArrayList.add(localamli1);
      paramamlj.a(localArrayList, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlh
 * JD-Core Version:    0.7.0.1
 */
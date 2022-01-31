import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class apdq
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yy年M月d日 hh:mm:ss");
  private static final Date jdField_a_of_type_JavaUtilDate = new Date();
  private static final Formatter jdField_a_of_type_JavaUtilFormatter;
  
  static
  {
    jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    jdField_a_of_type_JavaUtilFormatter = new Formatter(jdField_a_of_type_JavaLangStringBuilder, Locale.getDefault());
  }
  
  public static int a(float paramFloat)
  {
    if (jdField_a_of_type_Float < 0.0F) {
      jdField_a_of_type_Float = apaz.a().a().a().getDisplayMetrics().density;
    }
    return (int)(jdField_a_of_type_Float * paramFloat + 0.5F);
  }
  
  public static int a(apbq paramapbq1, apbq paramapbq2)
  {
    int i = 0;
    if (paramapbq1 == paramapbq2) {}
    int j;
    do
    {
      do
      {
        return i;
        if (paramapbq1 == null) {
          return -1;
        }
        if (paramapbq2 == null) {
          return 1;
        }
      } while (paramapbq1.equals(paramapbq2));
      long l = paramapbq1.d() - paramapbq2.d();
      if (l > 0L) {
        return 1;
      }
      if (l < 0L) {
        return -1;
      }
      i = paramapbq1.b() - paramapbq2.b();
      if (i > 0) {
        return -1;
      }
      if (i < 0) {
        return 1;
      }
      i = paramapbq1.e() - paramapbq2.e();
      if (i > 0) {
        return 1;
      }
      if (i < 0) {
        return -1;
      }
      i = paramapbq1.c() - paramapbq2.c();
      if (i > 0) {
        return -1;
      }
      if (i < 0) {
        return 1;
      }
      l = paramapbq1.c() - paramapbq2.c();
      if (l > 0L) {
        return -1;
      }
      if (l < 0L) {
        return 1;
      }
      j = paramapbq1.a() - paramapbq2.a();
      if (j > 0) {
        return 1;
      }
      i = j;
    } while (j >= 0);
    return -1;
  }
  
  public static int a(apbq paramapbq1, apbq paramapbq2, long paramLong)
  {
    if ((paramapbq1.b(paramLong)) || (paramapbq2.b(paramLong))) {}
    float[] arrayOfFloat2;
    do
    {
      return -1;
      arrayOfFloat1 = paramapbq1.a(paramapbq1.e());
      arrayOfFloat2 = paramapbq2.a(paramapbq1.e());
    } while ((arrayOfFloat1 == null) || (arrayOfFloat2 == null));
    int i = (int)((arrayOfFloat2[0] - arrayOfFloat1[2]) / paramapbq2.a());
    float[] arrayOfFloat1 = paramapbq1.a(paramapbq1.b());
    return Math.max(i, (int)((paramapbq2.a(paramapbq1.b())[0] - arrayOfFloat1[2]) / paramapbq2.a()));
  }
  
  public static String a(long paramLong)
  {
    if (paramLong < 86400000L)
    {
      paramLong /= 1000L;
      long l1 = paramLong % 60L;
      long l2 = paramLong / 60L % 60L;
      long l3 = paramLong / 3600L;
      paramLong = l1;
      if (l1 < 0L) {
        paramLong = 0L;
      }
      l1 = l2;
      if (l2 < 0L) {
        l1 = 0L;
      }
      l2 = l3;
      if (l3 < 0L) {
        l2 = 0L;
      }
      jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      if (l2 > 0L) {
        return jdField_a_of_type_JavaUtilFormatter.format("%d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
      }
      return jdField_a_of_type_JavaUtilFormatter.format("%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    }
    jdField_a_of_type_JavaUtilDate.setTime(paramLong);
    return jdField_a_of_type_JavaTextSimpleDateFormat.format(jdField_a_of_type_JavaUtilDate);
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdq
 * JD-Core Version:    0.7.0.1
 */
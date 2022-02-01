import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

public final class bhku
{
  private static final ThreadLocal<double[]> a = new ThreadLocal();
  
  @FloatRange(from=0.0D, to=1.0D)
  public static double a(@ColorInt int paramInt)
  {
    double[] arrayOfDouble = a();
    a(paramInt, arrayOfDouble);
    return arrayOfDouble[1] / 100.0D;
  }
  
  public static double a(@ColorInt int paramInt1, @ColorInt int paramInt2)
  {
    if (Color.alpha(paramInt2) != 255) {
      throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(paramInt2));
    }
    int i = paramInt1;
    if (Color.alpha(paramInt1) < 255) {
      i = a(paramInt1, paramInt2);
    }
    double d1 = a(i) + 0.05D;
    double d2 = a(paramInt2) + 0.05D;
    return Math.max(d1, d2) / Math.min(d1, d2);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  public static int a(@ColorInt int paramInt1, @ColorInt int paramInt2)
  {
    int i = Color.alpha(paramInt2);
    int j = Color.alpha(paramInt1);
    int k = c(j, i);
    return Color.argb(k, a(Color.red(paramInt1), j, Color.red(paramInt2), i, k), a(Color.green(paramInt1), j, Color.green(paramInt2), i, k), a(Color.blue(paramInt1), j, Color.blue(paramInt2), i, k));
  }
  
  public static int a(@ColorInt int paramInt1, @ColorInt int paramInt2, float paramFloat)
  {
    int j = 0;
    int i = 255;
    if (Color.alpha(paramInt2) != 255) {
      throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(paramInt2));
    }
    if (a(b(paramInt1, 255), paramInt2) < paramFloat) {
      m = -1;
    }
    int k;
    do
    {
      do
      {
        return m;
        k = 0;
        m = i;
      } while (k > 10);
      m = i;
    } while (i - j <= 1);
    int m = (j + i) / 2;
    if (a(b(paramInt1, m), paramInt2) < paramFloat) {
      j = m;
    }
    for (;;)
    {
      k += 1;
      break;
      i = m;
    }
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      return 0;
    }
    return (paramInt1 * 255 * paramInt2 + paramInt3 * paramInt4 * (255 - paramInt2)) / (paramInt5 * 255);
  }
  
  public static void a(@IntRange(from=0L, to=255L) int paramInt1, @IntRange(from=0L, to=255L) int paramInt2, @IntRange(from=0L, to=255L) int paramInt3, @NonNull double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble.length != 3) {
      throw new IllegalArgumentException("outXyz must have a length of 3.");
    }
    double d1 = paramInt1 / 255.0D;
    double d2;
    label66:
    double d3;
    if (d1 < 0.04045D)
    {
      d1 /= 12.92D;
      d2 = paramInt2 / 255.0D;
      if (d2 >= 0.04045D) {
        break label194;
      }
      d2 /= 12.92D;
      d3 = paramInt3 / 255.0D;
      if (d3 >= 0.04045D) {
        break label215;
      }
    }
    label194:
    label215:
    for (d3 /= 12.92D;; d3 = Math.pow((d3 + 0.055D) / 1.055D, 2.4D))
    {
      paramArrayOfDouble[0] = (100.0D * (0.4124D * d1 + 0.3576D * d2 + 0.1805D * d3));
      paramArrayOfDouble[1] = (100.0D * (0.2126D * d1 + 0.7152D * d2 + 0.0722D * d3));
      paramArrayOfDouble[2] = ((d3 * 0.9505D + (d2 * 0.1192D + d1 * 0.0193D)) * 100.0D);
      return;
      d1 = Math.pow((d1 + 0.055D) / 1.055D, 2.4D);
      break;
      d2 = Math.pow((d2 + 0.055D) / 1.055D, 2.4D);
      break label66;
    }
  }
  
  public static void a(@IntRange(from=0L, to=255L) int paramInt1, @IntRange(from=0L, to=255L) int paramInt2, @IntRange(from=0L, to=255L) int paramInt3, @NonNull float[] paramArrayOfFloat)
  {
    float f1 = paramInt1 / 255.0F;
    float f3 = paramInt2 / 255.0F;
    float f5 = paramInt3 / 255.0F;
    float f6 = Math.max(f1, Math.max(f3, f5));
    float f7 = Math.min(f1, Math.min(f3, f5));
    float f2 = f6 - f7;
    float f4 = (f6 + f7) / 2.0F;
    if (f6 == f7)
    {
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = f2 * 60.0F % 360.0F;
      f2 = f3;
      if (f3 < 0.0F) {
        f2 = f3 + 360.0F;
      }
      paramArrayOfFloat[0] = a(f2, 0.0F, 360.0F);
      paramArrayOfFloat[1] = a(f1, 0.0F, 1.0F);
      paramArrayOfFloat[2] = a(f4, 0.0F, 1.0F);
      return;
    }
    if (f6 == f1) {
      f1 = (f3 - f5) / f2 % 6.0F;
    }
    for (;;)
    {
      f3 = f2 / (1.0F - Math.abs(2.0F * f4 - 1.0F));
      f2 = f1;
      f1 = f3;
      break;
      if (f6 == f3) {
        f1 = (f5 - f1) / f2 + 2.0F;
      } else {
        f1 = (f1 - f3) / f2 + 4.0F;
      }
    }
  }
  
  public static void a(@ColorInt int paramInt, @NonNull double[] paramArrayOfDouble)
  {
    a(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfDouble);
  }
  
  public static void a(@ColorInt int paramInt, @NonNull float[] paramArrayOfFloat)
  {
    a(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), paramArrayOfFloat);
  }
  
  private static double[] a()
  {
    double[] arrayOfDouble2 = (double[])a.get();
    double[] arrayOfDouble1 = arrayOfDouble2;
    if (arrayOfDouble2 == null)
    {
      arrayOfDouble1 = new double[3];
      a.set(arrayOfDouble1);
    }
    return arrayOfDouble1;
  }
  
  @ColorInt
  public static int b(@ColorInt int paramInt1, @IntRange(from=0L, to=255L) int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 > 255)) {
      throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
    return 0xFFFFFF & paramInt1 | paramInt2 << 24;
  }
  
  private static int c(int paramInt1, int paramInt2)
  {
    return 255 - (255 - paramInt2) * (255 - paramInt1) / 255;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhku
 * JD-Core Version:    0.7.0.1
 */
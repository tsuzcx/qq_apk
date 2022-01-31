import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;

public class bmfh
  implements TypeEvaluator
{
  private static final ArgbEvaluator a = new ArgbEvaluator();
  
  public static ArgbEvaluator a()
  {
    return a;
  }
  
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    int i = ((Integer)paramObject1).intValue();
    float f1 = (i >> 24 & 0xFF) / 255.0F;
    float f4 = (i >> 16 & 0xFF) / 255.0F;
    float f5 = (i >> 8 & 0xFF) / 255.0F;
    float f6 = (i & 0xFF) / 255.0F;
    i = ((Integer)paramObject2).intValue();
    float f2 = (i >> 24 & 0xFF) / 255.0F;
    float f8 = (i >> 16 & 0xFF) / 255.0F;
    float f7 = (i >> 8 & 0xFF) / 255.0F;
    float f3 = (i & 0xFF) / 255.0F;
    f4 = (float)Math.pow(f4, 2.2D);
    f5 = (float)Math.pow(f5, 2.2D);
    f6 = (float)Math.pow(f6, 2.2D);
    f8 = (float)Math.pow(f8, 2.2D);
    f7 = (float)Math.pow(f7, 2.2D);
    f3 = (float)Math.pow(f3, 2.2D);
    f4 = (float)Math.pow(f4 + (f8 - f4) * paramFloat, 0.4545454545454545D);
    f5 = (float)Math.pow(f5 + (f7 - f5) * paramFloat, 0.4545454545454545D);
    f3 = (float)Math.pow(f6 + (f3 - f6) * paramFloat, 0.4545454545454545D);
    i = Math.round((f1 + (f2 - f1) * paramFloat) * 255.0F);
    int j = Math.round(f4 * 255.0F);
    int k = Math.round(f5 * 255.0F);
    return Integer.valueOf(Math.round(f3 * 255.0F) | i << 24 | j << 16 | k << 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfh
 * JD-Core Version:    0.7.0.1
 */
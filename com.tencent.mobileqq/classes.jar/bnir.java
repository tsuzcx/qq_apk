import android.animation.TypeEvaluator;

public class bnir
  implements TypeEvaluator<bnip>
{
  private bnip a;
  
  public bnip a(float paramFloat, bnip parambnip1, bnip parambnip2)
  {
    float f1 = parambnip1.a + (parambnip2.a - parambnip1.a) * paramFloat;
    float f2 = parambnip1.b + (parambnip2.b - parambnip1.b) * paramFloat;
    float f3 = parambnip1.c + (parambnip2.c - parambnip1.c) * paramFloat;
    paramFloat = parambnip1.d + (parambnip2.d - parambnip1.d) * paramFloat;
    if (this.a == null) {
      this.a = new bnip(f1, f2, f3, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a(f1, f2, f3, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnir
 * JD-Core Version:    0.7.0.1
 */
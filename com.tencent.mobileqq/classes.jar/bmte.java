import android.animation.TypeEvaluator;

public class bmte
  implements TypeEvaluator<bmtc>
{
  private bmtc a;
  
  public bmtc a(float paramFloat, bmtc parambmtc1, bmtc parambmtc2)
  {
    float f1 = parambmtc1.a + (parambmtc2.a - parambmtc1.a) * paramFloat;
    float f2 = parambmtc1.b + (parambmtc2.b - parambmtc1.b) * paramFloat;
    float f3 = parambmtc1.c + (parambmtc2.c - parambmtc1.c) * paramFloat;
    paramFloat = parambmtc1.d + (parambmtc2.d - parambmtc1.d) * paramFloat;
    if (this.a == null) {
      this.a = new bmtc(f1, f2, f3, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a(f1, f2, f3, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmte
 * JD-Core Version:    0.7.0.1
 */
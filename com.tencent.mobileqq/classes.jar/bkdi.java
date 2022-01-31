import android.animation.TypeEvaluator;

public class bkdi
  implements TypeEvaluator<bkdg>
{
  private bkdg a;
  
  public bkdg a(float paramFloat, bkdg parambkdg1, bkdg parambkdg2)
  {
    float f1 = parambkdg1.a + (parambkdg2.a - parambkdg1.a) * paramFloat;
    float f2 = parambkdg1.b + (parambkdg2.b - parambkdg1.b) * paramFloat;
    float f3 = parambkdg1.c + (parambkdg2.c - parambkdg1.c) * paramFloat;
    paramFloat = parambkdg1.d + (parambkdg2.d - parambkdg1.d) * paramFloat;
    if (this.a == null) {
      this.a = new bkdg(f1, f2, f3, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a(f1, f2, f3, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkdi
 * JD-Core Version:    0.7.0.1
 */
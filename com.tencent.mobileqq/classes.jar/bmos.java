import android.animation.TypeEvaluator;

public class bmos
  implements TypeEvaluator<bmoq>
{
  private bmoq a;
  
  public bmoq a(float paramFloat, bmoq parambmoq1, bmoq parambmoq2)
  {
    float f1 = parambmoq1.a + (parambmoq2.a - parambmoq1.a) * paramFloat;
    float f2 = parambmoq1.b + (parambmoq2.b - parambmoq1.b) * paramFloat;
    float f3 = parambmoq1.c + (parambmoq2.c - parambmoq1.c) * paramFloat;
    paramFloat = parambmoq1.d + (parambmoq2.d - parambmoq1.d) * paramFloat;
    if (this.a == null) {
      this.a = new bmoq(f1, f2, f3, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a(f1, f2, f3, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmos
 * JD-Core Version:    0.7.0.1
 */
import android.animation.TypeEvaluator;

public class bqmf
  implements TypeEvaluator<bqmd>
{
  private bqmd a;
  
  public bqmd a(float paramFloat, bqmd parambqmd1, bqmd parambqmd2)
  {
    float f1 = parambqmd1.a + (parambqmd2.a - parambqmd1.a) * paramFloat;
    float f2 = parambqmd1.b + (parambqmd2.b - parambqmd1.b) * paramFloat;
    float f3 = parambqmd1.c + (parambqmd2.c - parambqmd1.c) * paramFloat;
    paramFloat = parambqmd1.d + (parambqmd2.d - parambqmd1.d) * paramFloat;
    if (this.a == null) {
      this.a = new bqmd(f1, f2, f3, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a(f1, f2, f3, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqmf
 * JD-Core Version:    0.7.0.1
 */
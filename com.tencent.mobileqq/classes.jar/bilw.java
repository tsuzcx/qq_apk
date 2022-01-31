import android.animation.TypeEvaluator;

public class bilw
  implements TypeEvaluator<bilu>
{
  private bilu a;
  
  public bilu a(float paramFloat, bilu parambilu1, bilu parambilu2)
  {
    float f1 = parambilu1.a + (parambilu2.a - parambilu1.a) * paramFloat;
    float f2 = parambilu1.b + (parambilu2.b - parambilu1.b) * paramFloat;
    float f3 = parambilu1.c + (parambilu2.c - parambilu1.c) * paramFloat;
    paramFloat = parambilu1.d + (parambilu2.d - parambilu1.d) * paramFloat;
    if (this.a == null) {
      this.a = new bilu(f1, f2, f3, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a(f1, f2, f3, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilw
 * JD-Core Version:    0.7.0.1
 */
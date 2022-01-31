import android.animation.TypeEvaluator;

public class bkcr
  implements TypeEvaluator<bkcp>
{
  private bkcp a;
  
  public bkcp a(float paramFloat, bkcp parambkcp1, bkcp parambkcp2)
  {
    float f1 = parambkcp1.a + (parambkcp2.a - parambkcp1.a) * paramFloat;
    float f2 = parambkcp1.b + (parambkcp2.b - parambkcp1.b) * paramFloat;
    float f3 = parambkcp1.c + (parambkcp2.c - parambkcp1.c) * paramFloat;
    paramFloat = parambkcp1.d + (parambkcp2.d - parambkcp1.d) * paramFloat;
    if (this.a == null) {
      this.a = new bkcp(f1, f2, f3, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a(f1, f2, f3, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkcr
 * JD-Core Version:    0.7.0.1
 */
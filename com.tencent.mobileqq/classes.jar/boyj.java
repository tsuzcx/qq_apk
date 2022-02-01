import android.animation.TypeEvaluator;

public class boyj
  implements TypeEvaluator<boyh>
{
  private boyh a;
  
  public boyh a(float paramFloat, boyh paramboyh1, boyh paramboyh2)
  {
    float f1 = paramboyh1.a + (paramboyh2.a - paramboyh1.a) * paramFloat;
    float f2 = paramboyh1.b + (paramboyh2.b - paramboyh1.b) * paramFloat;
    float f3 = paramboyh1.c + (paramboyh2.c - paramboyh1.c) * paramFloat;
    paramFloat = paramboyh1.d + (paramboyh2.d - paramboyh1.d) * paramFloat;
    if (this.a == null) {
      this.a = new boyh(f1, f2, f3, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a(f1, f2, f3, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boyj
 * JD-Core Version:    0.7.0.1
 */
import android.animation.TypeEvaluator;

public class bpkk
  implements TypeEvaluator<bpki>
{
  private bpki a;
  
  public bpki a(float paramFloat, bpki parambpki1, bpki parambpki2)
  {
    float f1 = parambpki1.a + (parambpki2.a - parambpki1.a) * paramFloat;
    float f2 = parambpki1.b + (parambpki2.b - parambpki1.b) * paramFloat;
    float f3 = parambpki1.c + (parambpki2.c - parambpki1.c) * paramFloat;
    paramFloat = parambpki1.d + (parambpki2.d - parambpki1.d) * paramFloat;
    if (this.a == null) {
      this.a = new bpki(f1, f2, f3, paramFloat);
    }
    for (;;)
    {
      return this.a;
      this.a.a(f1, f2, f3, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkk
 * JD-Core Version:    0.7.0.1
 */
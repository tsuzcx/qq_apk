public class bpki
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public bpki(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public static boolean a(bpki parambpki1, bpki parambpki2)
  {
    return Float.compare(parambpki1.d, parambpki2.d) != 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public void a(bpki parambpki)
  {
    this.c *= parambpki.c;
    this.a -= parambpki.a;
    this.b -= parambpki.b;
  }
  
  public String toString()
  {
    return "CropHomeing{x=" + this.a + ", y=" + this.b + ", scale=" + this.c + ", rotate=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpki
 * JD-Core Version:    0.7.0.1
 */
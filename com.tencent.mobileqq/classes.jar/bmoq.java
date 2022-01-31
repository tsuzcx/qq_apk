public class bmoq
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public bmoq(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public static boolean a(bmoq parambmoq1, bmoq parambmoq2)
  {
    return Float.compare(parambmoq1.d, parambmoq2.d) != 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public void a(bmoq parambmoq)
  {
    this.c *= parambmoq.c;
    this.a -= parambmoq.a;
    this.b -= parambmoq.b;
  }
  
  public String toString()
  {
    return "CropHomeing{x=" + this.a + ", y=" + this.b + ", scale=" + this.c + ", rotate=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmoq
 * JD-Core Version:    0.7.0.1
 */
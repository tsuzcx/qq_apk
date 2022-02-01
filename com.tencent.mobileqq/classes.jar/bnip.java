public class bnip
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public bnip(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public static boolean a(bnip parambnip1, bnip parambnip2)
  {
    return Float.compare(parambnip1.d, parambnip2.d) != 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public void a(bnip parambnip)
  {
    this.c *= parambnip.c;
    this.a -= parambnip.a;
    this.b -= parambnip.b;
  }
  
  public String toString()
  {
    return "CropHomeing{x=" + this.a + ", y=" + this.b + ", scale=" + this.c + ", rotate=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnip
 * JD-Core Version:    0.7.0.1
 */
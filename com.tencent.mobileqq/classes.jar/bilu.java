public class bilu
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public bilu(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public static boolean a(bilu parambilu1, bilu parambilu2)
  {
    return Float.compare(parambilu1.d, parambilu2.d) != 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public void a(bilu parambilu)
  {
    this.c *= parambilu.c;
    this.a -= parambilu.a;
    this.b -= parambilu.b;
  }
  
  public String toString()
  {
    return "CropHomeing{x=" + this.a + ", y=" + this.b + ", scale=" + this.c + ", rotate=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilu
 * JD-Core Version:    0.7.0.1
 */
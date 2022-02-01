public class bqmd
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public bqmd(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public static boolean a(bqmd parambqmd1, bqmd parambqmd2)
  {
    return Float.compare(parambqmd1.d, parambqmd2.d) != 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public void a(bqmd parambqmd)
  {
    this.c *= parambqmd.c;
    this.a -= parambqmd.a;
    this.b -= parambqmd.b;
  }
  
  public String toString()
  {
    return "CropHomeing{x=" + this.a + ", y=" + this.b + ", scale=" + this.c + ", rotate=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqmd
 * JD-Core Version:    0.7.0.1
 */
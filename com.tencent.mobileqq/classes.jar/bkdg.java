public class bkdg
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public bkdg(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public static boolean a(bkdg parambkdg1, bkdg parambkdg2)
  {
    return Float.compare(parambkdg1.d, parambkdg2.d) != 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public void a(bkdg parambkdg)
  {
    this.c *= parambkdg.c;
    this.a -= parambkdg.a;
    this.b -= parambkdg.b;
  }
  
  public String toString()
  {
    return "CropHomeing{x=" + this.a + ", y=" + this.b + ", scale=" + this.c + ", rotate=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkdg
 * JD-Core Version:    0.7.0.1
 */
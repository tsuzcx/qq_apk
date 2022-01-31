public class bmtc
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public bmtc(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public static boolean a(bmtc parambmtc1, bmtc parambmtc2)
  {
    return Float.compare(parambmtc1.d, parambmtc2.d) != 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public void a(bmtc parambmtc)
  {
    this.c *= parambmtc.c;
    this.a -= parambmtc.a;
    this.b -= parambmtc.b;
  }
  
  public String toString()
  {
    return "CropHomeing{x=" + this.a + ", y=" + this.b + ", scale=" + this.c + ", rotate=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtc
 * JD-Core Version:    0.7.0.1
 */
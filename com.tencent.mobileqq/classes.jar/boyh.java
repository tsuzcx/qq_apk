public class boyh
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public boyh(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public static boolean a(boyh paramboyh1, boyh paramboyh2)
  {
    return Float.compare(paramboyh1.d, paramboyh2.d) != 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  public void a(boyh paramboyh)
  {
    this.c *= paramboyh.c;
    this.a -= paramboyh.a;
    this.b -= paramboyh.b;
  }
  
  public String toString()
  {
    return "CropHomeing{x=" + this.a + ", y=" + this.b + ", scale=" + this.c + ", rotate=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boyh
 * JD-Core Version:    0.7.0.1
 */
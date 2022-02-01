package c.t.m.g;

public class ed
{
  private static ed g = null;
  float a = 0.0F;
  float b = 0.0F;
  float c = 100.0F;
  boolean d = false;
  boolean e = false;
  String f = "null";
  
  public static ed a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new ed();
      }
      return g;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.ed
 * JD-Core Version:    0.7.0.1
 */
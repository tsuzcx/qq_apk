package c.t.m.g;

public class ee
{
  private static ee g = null;
  float a = 0.0F;
  float b = 0.0F;
  float c = 100.0F;
  boolean d = false;
  boolean e = false;
  String f = "null";
  
  public static ee a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new ee();
      }
      return g;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.ee
 * JD-Core Version:    0.7.0.1
 */
package c.t.m.g;

public class ea
{
  private static ea g = null;
  float a = 0.0F;
  float b = 0.0F;
  float c = 100.0F;
  boolean d = false;
  boolean e = false;
  String f = "null";
  
  public static ea a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new ea();
      }
      return g;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.ea
 * JD-Core Version:    0.7.0.1
 */
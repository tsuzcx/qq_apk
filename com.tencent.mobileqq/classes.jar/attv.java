import java.math.BigDecimal;

public class attv
{
  public String a;
  public String b;
  public String c;
  
  public String a(int paramInt, float paramFloat)
  {
    String str = null;
    if (this.c != null)
    {
      str = this.c.replaceFirst("%param%", "" + paramInt);
      paramFloat = new BigDecimal(paramFloat).setScale(1, 4).floatValue();
      str = str.replaceFirst("%param%", "" + paramFloat);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attv
 * JD-Core Version:    0.7.0.1
 */
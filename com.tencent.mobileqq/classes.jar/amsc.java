import org.json.JSONObject;

public class amsc
{
  private int a;
  
  public static amsc a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      amsc localamsc = new amsc();
      localamsc.a = new JSONObject(paramString).optInt("open_don_disturb", 0);
      return localamsc;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String toString()
  {
    return super.toString() + " showDonDisturb=" + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amsc
 * JD-Core Version:    0.7.0.1
 */
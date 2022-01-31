import org.json.JSONObject;

public class amsd
{
  private int a;
  
  public static amsd a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      amsd localamsd = new amsd();
      localamsd.a = new JSONObject(paramString).optInt("open_don_disturb", 0);
      return localamsd;
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
 * Qualified Name:     amsd
 * JD-Core Version:    0.7.0.1
 */
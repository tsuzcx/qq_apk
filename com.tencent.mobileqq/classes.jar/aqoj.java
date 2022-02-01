import org.json.JSONObject;

public class aqoj
{
  private int a;
  
  public static aqoj a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      aqoj localaqoj = new aqoj();
      localaqoj.a = new JSONObject(paramString).optInt("open_don_disturb", 0);
      return localaqoj;
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
 * Qualified Name:     aqoj
 * JD-Core Version:    0.7.0.1
 */
import org.json.JSONObject;

public class ardr
{
  private int a;
  
  public static ardr a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      ardr localardr = new ardr();
      localardr.a = new JSONObject(paramString).optInt("open_don_disturb", 0);
      return localardr;
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
 * Qualified Name:     ardr
 * JD-Core Version:    0.7.0.1
 */
import org.json.JSONObject;

public class arak
{
  private int a;
  
  public static arak a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      arak localarak = new arak();
      localarak.a = new JSONObject(paramString).optInt("open_don_disturb", 0);
      return localarak;
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
 * Qualified Name:     arak
 * JD-Core Version:    0.7.0.1
 */
import org.json.JSONObject;

public class aonj
{
  private int a;
  
  public static aonj a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      aonj localaonj = new aonj();
      localaonj.a = new JSONObject(paramString).optInt("open_don_disturb", 0);
      return localaonj;
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
 * Qualified Name:     aonj
 * JD-Core Version:    0.7.0.1
 */
import org.json.JSONObject;

public class apxh
{
  private int a;
  
  public static apxh a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      apxh localapxh = new apxh();
      localapxh.a = new JSONObject(paramString).optInt("open_don_disturb", 0);
      return localapxh;
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
 * Qualified Name:     apxh
 * JD-Core Version:    0.7.0.1
 */
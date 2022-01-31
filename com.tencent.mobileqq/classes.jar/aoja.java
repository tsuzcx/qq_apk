import org.json.JSONObject;

public class aoja
{
  private int a;
  
  public static aoja a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      aoja localaoja = new aoja();
      localaoja.a = new JSONObject(paramString).optInt("open_don_disturb", 0);
      return localaoja;
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
 * Qualified Name:     aoja
 * JD-Core Version:    0.7.0.1
 */
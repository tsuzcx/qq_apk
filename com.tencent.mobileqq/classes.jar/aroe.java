import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aroe
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public static aroe a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    aroe localaroe = new aroe();
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].a);
      localaroe.a = paramArrayOfaqxa.getBoolean("fastload");
      localaroe.b = paramArrayOfaqxa.getBoolean("prefetch");
      localaroe.c = paramArrayOfaqxa.getBoolean("preloadWebView");
      QLog.v("TencentDocPreloadConfigBean", 0, "fastload = " + localaroe.a + ", prefetch = " + localaroe.b + ", preloadWebView = " + localaroe.c);
      return localaroe;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      QLog.e("TencentDocPreloadConfigBean", 1, paramArrayOfaqxa.getLocalizedMessage(), paramArrayOfaqxa);
    }
    return localaroe;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aroe
 * JD-Core Version:    0.7.0.1
 */
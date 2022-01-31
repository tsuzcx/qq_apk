import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoyg
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public static aoyg a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    aoyg localaoyg = new aoyg();
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko[0].a);
      localaoyg.a = paramArrayOfaoko.getBoolean("fastload");
      localaoyg.b = paramArrayOfaoko.getBoolean("prefetch");
      localaoyg.c = paramArrayOfaoko.getBoolean("preloadWebView");
      QLog.v("TencentDocPreloadConfigBean", 0, "fastload = " + localaoyg.a + ", prefetch = " + localaoyg.b + ", preloadWebView = " + localaoyg.c);
      return localaoyg;
    }
    catch (JSONException paramArrayOfaoko)
    {
      QLog.e("TencentDocPreloadConfigBean", 1, paramArrayOfaoko.getLocalizedMessage(), paramArrayOfaoko);
    }
    return localaoyg;
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
 * Qualified Name:     aoyg
 * JD-Core Version:    0.7.0.1
 */
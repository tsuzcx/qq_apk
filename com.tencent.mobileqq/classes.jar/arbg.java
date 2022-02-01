import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arbg
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public static arbg a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    arbg localarbg = new arbg();
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg[0].a);
      localarbg.a = paramArrayOfaqlg.getBoolean("fastload");
      localarbg.b = paramArrayOfaqlg.getBoolean("prefetch");
      localarbg.c = paramArrayOfaqlg.getBoolean("preloadWebView");
      QLog.v("TencentDocPreloadConfigBean", 0, "fastload = " + localarbg.a + ", prefetch = " + localarbg.b + ", preloadWebView = " + localarbg.c);
      return localarbg;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      QLog.e("TencentDocPreloadConfigBean", 1, paramArrayOfaqlg.getLocalizedMessage(), paramArrayOfaqlg);
    }
    return localarbg;
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
 * Qualified Name:     arbg
 * JD-Core Version:    0.7.0.1
 */
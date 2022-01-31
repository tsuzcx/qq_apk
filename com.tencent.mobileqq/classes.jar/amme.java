import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amme
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public static amme a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    amme localamme = new amme();
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs[0].a);
      localamme.a = paramArrayOfalzs.getBoolean("fastload");
      localamme.b = paramArrayOfalzs.getBoolean("prefetch");
      localamme.c = paramArrayOfalzs.getBoolean("preloadWebView");
      QLog.v("TencentDocPreloadConfigBean", 0, "fastload = " + localamme.a + ", prefetch = " + localamme.b + ", preloadWebView = " + localamme.c);
      return localamme;
    }
    catch (JSONException paramArrayOfalzs)
    {
      QLog.e("TencentDocPreloadConfigBean", 1, paramArrayOfalzs.getLocalizedMessage(), paramArrayOfalzs);
    }
    return localamme;
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
 * Qualified Name:     amme
 * JD-Core Version:    0.7.0.1
 */
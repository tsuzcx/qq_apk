import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arqv
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public static arqv a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    arqv localarqv = new arqv();
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].a);
      localarqv.a = paramArrayOfaraj.getBoolean("fastload");
      localarqv.b = paramArrayOfaraj.getBoolean("prefetch");
      localarqv.c = paramArrayOfaraj.getBoolean("preloadWebView");
      QLog.v("TencentDocPreloadConfigBean", 0, "fastload = " + localarqv.a + ", prefetch = " + localarqv.b + ", preloadWebView = " + localarqv.c);
      return localarqv;
    }
    catch (JSONException paramArrayOfaraj)
    {
      QLog.e("TencentDocPreloadConfigBean", 1, paramArrayOfaraj.getLocalizedMessage(), paramArrayOfaraj);
    }
    return localarqv;
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
 * Qualified Name:     arqv
 * JD-Core Version:    0.7.0.1
 */
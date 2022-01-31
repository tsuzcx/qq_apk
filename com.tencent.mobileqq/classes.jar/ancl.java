import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ancl
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public static ancl a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    ancl localancl = new ancl();
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi[0].a);
      localancl.a = paramArrayOfampi.getBoolean("fastload");
      localancl.b = paramArrayOfampi.getBoolean("prefetch");
      localancl.c = paramArrayOfampi.getBoolean("preloadWebView");
      QLog.v("TencentDocPreloadConfigBean", 0, "fastload = " + localancl.a + ", prefetch = " + localancl.b + ", preloadWebView = " + localancl.c);
      return localancl;
    }
    catch (JSONException paramArrayOfampi)
    {
      QLog.e("TencentDocPreloadConfigBean", 1, paramArrayOfampi.getLocalizedMessage(), paramArrayOfampi);
    }
    return localancl;
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
 * Qualified Name:     ancl
 * JD-Core Version:    0.7.0.1
 */
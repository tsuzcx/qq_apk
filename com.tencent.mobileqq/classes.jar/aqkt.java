import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqkt
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public static aqkt a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    aqkt localaqkt = new aqkt();
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].a);
      localaqkt.a = paramArrayOfaptx.getBoolean("fastload");
      localaqkt.b = paramArrayOfaptx.getBoolean("prefetch");
      localaqkt.c = paramArrayOfaptx.getBoolean("preloadWebView");
      QLog.v("TencentDocPreloadConfigBean", 0, "fastload = " + localaqkt.a + ", prefetch = " + localaqkt.b + ", preloadWebView = " + localaqkt.c);
      return localaqkt;
    }
    catch (JSONException paramArrayOfaptx)
    {
      QLog.e("TencentDocPreloadConfigBean", 1, paramArrayOfaptx.getLocalizedMessage(), paramArrayOfaptx);
    }
    return localaqkt;
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
 * Qualified Name:     aqkt
 * JD-Core Version:    0.7.0.1
 */
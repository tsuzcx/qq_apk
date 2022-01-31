import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ancq
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public static ancq a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    ancq localancq = new ancq();
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph[0].a);
      localancq.a = paramArrayOfamph.getBoolean("fastload");
      localancq.b = paramArrayOfamph.getBoolean("prefetch");
      localancq.c = paramArrayOfamph.getBoolean("preloadWebView");
      QLog.v("TencentDocPreloadConfigBean", 0, "fastload = " + localancq.a + ", prefetch = " + localancq.b + ", preloadWebView = " + localancq.c);
      return localancq;
    }
    catch (JSONException paramArrayOfamph)
    {
      QLog.e("TencentDocPreloadConfigBean", 1, paramArrayOfamph.getLocalizedMessage(), paramArrayOfamph);
    }
    return localancq;
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
 * Qualified Name:     ancq
 * JD-Core Version:    0.7.0.1
 */
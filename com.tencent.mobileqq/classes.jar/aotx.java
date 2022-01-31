import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aotx
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public static aotx a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    aotx localaotx = new aotx();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].a);
      localaotx.a = paramArrayOfaogf.getBoolean("fastload");
      localaotx.b = paramArrayOfaogf.getBoolean("prefetch");
      localaotx.c = paramArrayOfaogf.getBoolean("preloadWebView");
      QLog.v("TencentDocPreloadConfigBean", 0, "fastload = " + localaotx.a + ", prefetch = " + localaotx.b + ", preloadWebView = " + localaotx.c);
      return localaotx;
    }
    catch (JSONException paramArrayOfaogf)
    {
      QLog.e("TencentDocPreloadConfigBean", 1, paramArrayOfaogf.getLocalizedMessage(), paramArrayOfaogf);
    }
    return localaotx;
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
 * Qualified Name:     aotx
 * JD-Core Version:    0.7.0.1
 */
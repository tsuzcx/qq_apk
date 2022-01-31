import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzo
  extends amyi<amzn>
{
  public static amzn a()
  {
    return (amzn)ampm.a().a(413);
  }
  
  public int a()
  {
    return 413;
  }
  
  @NonNull
  public amzn a(@NonNull ampi[] paramArrayOfampi)
  {
    amzn localamzn = new amzn();
    paramArrayOfampi = paramArrayOfampi[0].a;
    if (paramArrayOfampi != null) {}
    try
    {
      if (!"".equals(paramArrayOfampi))
      {
        paramArrayOfampi = new JSONObject(paramArrayOfampi);
        localamzn.a(paramArrayOfampi.getString("url"));
        localamzn.a(paramArrayOfampi.getBoolean("isEnable"));
        localamzn.b(paramArrayOfampi.getBoolean("hideHotValue"));
      }
      return localamzn;
    }
    catch (JSONException paramArrayOfampi)
    {
      paramArrayOfampi.printStackTrace();
    }
    return localamzn;
  }
  
  public Class<amzn> a()
  {
    return amzn.class;
  }
  
  @NonNull
  public amzn b()
  {
    return new amzn();
  }
  
  @NonNull
  public amzn c()
  {
    return new amzn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzo
 * JD-Core Version:    0.7.0.1
 */
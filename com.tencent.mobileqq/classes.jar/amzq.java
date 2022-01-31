import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzq
  extends amyi<amzp>
{
  public static amzp a()
  {
    return (amzp)ampm.a().a(563);
  }
  
  public int a()
  {
    return 563;
  }
  
  @NonNull
  public amzp a(@NonNull ampi[] paramArrayOfampi)
  {
    amzp localamzp = new amzp();
    paramArrayOfampi = paramArrayOfampi[0].a;
    if (paramArrayOfampi != null) {}
    try
    {
      if (!"".equals(paramArrayOfampi))
      {
        paramArrayOfampi = new JSONObject(paramArrayOfampi);
        localamzp.a = paramArrayOfampi.getString("musicBoxUrl");
        localamzp.b = paramArrayOfampi.getString("playerUrl");
      }
      return localamzp;
    }
    catch (JSONException paramArrayOfampi)
    {
      paramArrayOfampi.printStackTrace();
    }
    return localamzp;
  }
  
  public Class<amzp> a()
  {
    return amzp.class;
  }
  
  @NonNull
  public amzp b()
  {
    return new amzp();
  }
  
  @NonNull
  public amzp c()
  {
    return new amzp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzq
 * JD-Core Version:    0.7.0.1
 */
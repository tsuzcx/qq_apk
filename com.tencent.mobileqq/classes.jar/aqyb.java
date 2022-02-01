import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqyb
  extends aqwr<aqya>
{
  public static aqya a()
  {
    return (aqya)aqlk.a().a(563);
  }
  
  @NonNull
  public aqya a(@NonNull aqlg[] paramArrayOfaqlg)
  {
    aqya localaqya = new aqya();
    paramArrayOfaqlg = paramArrayOfaqlg[0].a;
    if (paramArrayOfaqlg != null) {}
    try
    {
      if (!"".equals(paramArrayOfaqlg))
      {
        paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg);
        localaqya.a = paramArrayOfaqlg.getString("musicBoxUrl");
        localaqya.b = paramArrayOfaqlg.getString("playerUrl");
      }
      return localaqya;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      paramArrayOfaqlg.printStackTrace();
    }
    return localaqya;
  }
  
  @NonNull
  public aqya b()
  {
    return new aqya();
  }
  
  @NonNull
  public aqya c()
  {
    return new aqya();
  }
  
  public Class<aqya> clazz()
  {
    return aqya.class;
  }
  
  public int type()
  {
    return 563;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyb
 * JD-Core Version:    0.7.0.1
 */
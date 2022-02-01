import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arky
  extends arjj<arkx>
{
  public static arkx a()
  {
    return (arkx)aqxe.a().a(563);
  }
  
  @NonNull
  public arkx a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    arkx localarkx = new arkx();
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    if (paramArrayOfaqxa != null) {}
    try
    {
      if (!"".equals(paramArrayOfaqxa))
      {
        paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa);
        localarkx.a = paramArrayOfaqxa.getString("musicBoxUrl");
        localarkx.b = paramArrayOfaqxa.getString("playerUrl");
      }
      return localarkx;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      paramArrayOfaqxa.printStackTrace();
    }
    return localarkx;
  }
  
  @NonNull
  public arkx b()
  {
    return new arkx();
  }
  
  @NonNull
  public arkx c()
  {
    return new arkx();
  }
  
  public Class<arkx> clazz()
  {
    return arkx.class;
  }
  
  public int type()
  {
    return 563;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arky
 * JD-Core Version:    0.7.0.1
 */
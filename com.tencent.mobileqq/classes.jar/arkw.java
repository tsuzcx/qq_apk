import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arkw
  extends arjj<arkv>
{
  public static arkv a()
  {
    return (arkv)aqxe.a().a(413);
  }
  
  @NonNull
  public arkv a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    arkv localarkv = new arkv();
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    if (paramArrayOfaqxa != null) {}
    try
    {
      if (!"".equals(paramArrayOfaqxa))
      {
        paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa);
        localarkv.a(paramArrayOfaqxa.getString("url"));
        localarkv.a(paramArrayOfaqxa.getBoolean("isEnable"));
        localarkv.b(paramArrayOfaqxa.getBoolean("hideHotValue"));
      }
      return localarkv;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      paramArrayOfaqxa.printStackTrace();
    }
    return localarkv;
  }
  
  @NonNull
  public arkv b()
  {
    return new arkv();
  }
  
  @NonNull
  public arkv c()
  {
    return new arkv();
  }
  
  public Class<arkv> clazz()
  {
    return arkv.class;
  }
  
  public int type()
  {
    return 413;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkw
 * JD-Core Version:    0.7.0.1
 */
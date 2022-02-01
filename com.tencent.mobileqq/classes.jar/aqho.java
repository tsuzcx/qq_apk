import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqho
  extends aqgc<aqhn>
{
  public static aqhn a()
  {
    return (aqhn)apub.a().a(413);
  }
  
  @NonNull
  public aqhn a(@NonNull aptx[] paramArrayOfaptx)
  {
    aqhn localaqhn = new aqhn();
    paramArrayOfaptx = paramArrayOfaptx[0].a;
    if (paramArrayOfaptx != null) {}
    try
    {
      if (!"".equals(paramArrayOfaptx))
      {
        paramArrayOfaptx = new JSONObject(paramArrayOfaptx);
        localaqhn.a(paramArrayOfaptx.getString("url"));
        localaqhn.a(paramArrayOfaptx.getBoolean("isEnable"));
        localaqhn.b(paramArrayOfaptx.getBoolean("hideHotValue"));
      }
      return localaqhn;
    }
    catch (JSONException paramArrayOfaptx)
    {
      paramArrayOfaptx.printStackTrace();
    }
    return localaqhn;
  }
  
  @NonNull
  public aqhn b()
  {
    return new aqhn();
  }
  
  @NonNull
  public aqhn c()
  {
    return new aqhn();
  }
  
  public Class<aqhn> clazz()
  {
    return aqhn.class;
  }
  
  public int type()
  {
    return 413;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqho
 * JD-Core Version:    0.7.0.1
 */
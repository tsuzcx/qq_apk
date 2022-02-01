import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqhq
  extends aqgc<aqhp>
{
  public static aqhp a()
  {
    return (aqhp)apub.a().a(563);
  }
  
  @NonNull
  public aqhp a(@NonNull aptx[] paramArrayOfaptx)
  {
    aqhp localaqhp = new aqhp();
    paramArrayOfaptx = paramArrayOfaptx[0].a;
    if (paramArrayOfaptx != null) {}
    try
    {
      if (!"".equals(paramArrayOfaptx))
      {
        paramArrayOfaptx = new JSONObject(paramArrayOfaptx);
        localaqhp.a = paramArrayOfaptx.getString("musicBoxUrl");
        localaqhp.b = paramArrayOfaptx.getString("playerUrl");
      }
      return localaqhp;
    }
    catch (JSONException paramArrayOfaptx)
    {
      paramArrayOfaptx.printStackTrace();
    }
    return localaqhp;
  }
  
  @NonNull
  public aqhp b()
  {
    return new aqhp();
  }
  
  @NonNull
  public aqhp c()
  {
    return new aqhp();
  }
  
  public Class<aqhp> clazz()
  {
    return aqhp.class;
  }
  
  public int type()
  {
    return 563;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqhq
 * JD-Core Version:    0.7.0.1
 */
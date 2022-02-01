import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arns
  extends armf<arnr>
{
  public static arnr a()
  {
    return (arnr)aran.a().a(563);
  }
  
  @NonNull
  public arnr a(@NonNull araj[] paramArrayOfaraj)
  {
    arnr localarnr = new arnr();
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    if (paramArrayOfaraj != null) {}
    try
    {
      if (!"".equals(paramArrayOfaraj))
      {
        paramArrayOfaraj = new JSONObject(paramArrayOfaraj);
        localarnr.a = paramArrayOfaraj.getString("musicBoxUrl");
        localarnr.b = paramArrayOfaraj.getString("playerUrl");
      }
      return localarnr;
    }
    catch (JSONException paramArrayOfaraj)
    {
      paramArrayOfaraj.printStackTrace();
    }
    return localarnr;
  }
  
  @NonNull
  public arnr b()
  {
    return new arnr();
  }
  
  @NonNull
  public arnr c()
  {
    return new arnr();
  }
  
  public Class<arnr> clazz()
  {
    return arnr.class;
  }
  
  public int type()
  {
    return 563;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arns
 * JD-Core Version:    0.7.0.1
 */
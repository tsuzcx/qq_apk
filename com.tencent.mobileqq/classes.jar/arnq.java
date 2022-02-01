import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arnq
  extends armf<arnp>
{
  public static arnp a()
  {
    return (arnp)aran.a().a(413);
  }
  
  @NonNull
  public arnp a(@NonNull araj[] paramArrayOfaraj)
  {
    arnp localarnp = new arnp();
    paramArrayOfaraj = paramArrayOfaraj[0].a;
    if (paramArrayOfaraj != null) {}
    try
    {
      if (!"".equals(paramArrayOfaraj))
      {
        paramArrayOfaraj = new JSONObject(paramArrayOfaraj);
        localarnp.a(paramArrayOfaraj.getString("url"));
        localarnp.a(paramArrayOfaraj.getBoolean("isEnable"));
        localarnp.b(paramArrayOfaraj.getBoolean("hideHotValue"));
      }
      return localarnp;
    }
    catch (JSONException paramArrayOfaraj)
    {
      paramArrayOfaraj.printStackTrace();
    }
    return localarnp;
  }
  
  @NonNull
  public arnp b()
  {
    return new arnp();
  }
  
  @NonNull
  public arnp c()
  {
    return new arnp();
  }
  
  public Class<arnp> clazz()
  {
    return arnp.class;
  }
  
  public int type()
  {
    return 413;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arnq
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqxz
  extends aqwr<aqxy>
{
  public static aqxy a()
  {
    return (aqxy)aqlk.a().a(413);
  }
  
  @NonNull
  public aqxy a(@NonNull aqlg[] paramArrayOfaqlg)
  {
    aqxy localaqxy = new aqxy();
    paramArrayOfaqlg = paramArrayOfaqlg[0].a;
    if (paramArrayOfaqlg != null) {}
    try
    {
      if (!"".equals(paramArrayOfaqlg))
      {
        paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg);
        localaqxy.a(paramArrayOfaqlg.getString("url"));
        localaqxy.a(paramArrayOfaqlg.getBoolean("isEnable"));
        localaqxy.b(paramArrayOfaqlg.getBoolean("hideHotValue"));
      }
      return localaqxy;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      paramArrayOfaqlg.printStackTrace();
    }
    return localaqxy;
  }
  
  @NonNull
  public aqxy b()
  {
    return new aqxy();
  }
  
  @NonNull
  public aqxy c()
  {
    return new aqxy();
  }
  
  public Class<aqxy> clazz()
  {
    return aqxy.class;
  }
  
  public int type()
  {
    return 413;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqxz
 * JD-Core Version:    0.7.0.1
 */
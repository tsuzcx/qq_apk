import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amjm
  extends amie<amjl>
{
  public static amjl a()
  {
    return (amjl)alzw.a().a(563);
  }
  
  public int a()
  {
    return 563;
  }
  
  @NonNull
  public amjl a(@NonNull alzs[] paramArrayOfalzs)
  {
    amjl localamjl = new amjl();
    paramArrayOfalzs = paramArrayOfalzs[0].a;
    if (paramArrayOfalzs != null) {}
    try
    {
      if (!"".equals(paramArrayOfalzs))
      {
        paramArrayOfalzs = new JSONObject(paramArrayOfalzs);
        localamjl.a = paramArrayOfalzs.getString("musicBoxUrl");
        localamjl.b = paramArrayOfalzs.getString("playerUrl");
      }
      return localamjl;
    }
    catch (JSONException paramArrayOfalzs)
    {
      paramArrayOfalzs.printStackTrace();
    }
    return localamjl;
  }
  
  public Class<amjl> a()
  {
    return amjl.class;
  }
  
  @NonNull
  public amjl b()
  {
    return new amjl();
  }
  
  @NonNull
  public amjl c()
  {
    return new amjl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjm
 * JD-Core Version:    0.7.0.1
 */
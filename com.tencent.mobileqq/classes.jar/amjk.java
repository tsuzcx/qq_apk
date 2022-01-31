import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amjk
  extends amie<amjj>
{
  public static amjj a()
  {
    return (amjj)alzw.a().a(413);
  }
  
  public int a()
  {
    return 413;
  }
  
  @NonNull
  public amjj a(@NonNull alzs[] paramArrayOfalzs)
  {
    amjj localamjj = new amjj();
    paramArrayOfalzs = paramArrayOfalzs[0].a;
    if (paramArrayOfalzs != null) {}
    try
    {
      if (!"".equals(paramArrayOfalzs))
      {
        paramArrayOfalzs = new JSONObject(paramArrayOfalzs);
        localamjj.a(paramArrayOfalzs.getString("url"));
        localamjj.a(paramArrayOfalzs.getBoolean("isEnable"));
        localamjj.b(paramArrayOfalzs.getBoolean("hideHotValue"));
      }
      return localamjj;
    }
    catch (JSONException paramArrayOfalzs)
    {
      paramArrayOfalzs.printStackTrace();
    }
    return localamjj;
  }
  
  public Class<amjj> a()
  {
    return amjj.class;
  }
  
  @NonNull
  public amjj b()
  {
    return new amjj();
  }
  
  @NonNull
  public amjj c()
  {
    return new amjj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjk
 * JD-Core Version:    0.7.0.1
 */
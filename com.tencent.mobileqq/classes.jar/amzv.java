import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzv
  extends amyp<amzu>
{
  public static amzu a()
  {
    return (amzu)ampl.a().a(413);
  }
  
  public int a()
  {
    return 413;
  }
  
  @NonNull
  public amzu a(@NonNull amph[] paramArrayOfamph)
  {
    amzu localamzu = new amzu();
    paramArrayOfamph = paramArrayOfamph[0].a;
    if (paramArrayOfamph != null) {}
    try
    {
      if (!"".equals(paramArrayOfamph))
      {
        paramArrayOfamph = new JSONObject(paramArrayOfamph);
        localamzu.a(paramArrayOfamph.getString("url"));
        localamzu.a(paramArrayOfamph.getBoolean("isEnable"));
        localamzu.b(paramArrayOfamph.getBoolean("hideHotValue"));
      }
      return localamzu;
    }
    catch (JSONException paramArrayOfamph)
    {
      paramArrayOfamph.printStackTrace();
    }
    return localamzu;
  }
  
  public Class<amzu> a()
  {
    return amzu.class;
  }
  
  @NonNull
  public amzu b()
  {
    return new amzu();
  }
  
  @NonNull
  public amzu c()
  {
    return new amzu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzv
 * JD-Core Version:    0.7.0.1
 */
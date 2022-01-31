import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzx
  extends amyp<amzw>
{
  public static amzw a()
  {
    return (amzw)ampl.a().a(563);
  }
  
  public int a()
  {
    return 563;
  }
  
  @NonNull
  public amzw a(@NonNull amph[] paramArrayOfamph)
  {
    amzw localamzw = new amzw();
    paramArrayOfamph = paramArrayOfamph[0].a;
    if (paramArrayOfamph != null) {}
    try
    {
      if (!"".equals(paramArrayOfamph))
      {
        paramArrayOfamph = new JSONObject(paramArrayOfamph);
        localamzw.a = paramArrayOfamph.getString("musicBoxUrl");
        localamzw.b = paramArrayOfamph.getString("playerUrl");
      }
      return localamzw;
    }
    catch (JSONException paramArrayOfamph)
    {
      paramArrayOfamph.printStackTrace();
    }
    return localamzw;
  }
  
  public Class<amzw> a()
  {
    return amzw.class;
  }
  
  @NonNull
  public amzw b()
  {
    return new amzw();
  }
  
  @NonNull
  public amzw c()
  {
    return new amzw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzx
 * JD-Core Version:    0.7.0.1
 */
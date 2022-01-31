import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amyz
  extends amyi<amyy>
{
  public static amyy c()
  {
    return (amyy)ampm.a().a(412);
  }
  
  public int a()
  {
    return 412;
  }
  
  @NonNull
  public amyy a()
  {
    return new amyy();
  }
  
  @NonNull
  public amyy a(ampi[] paramArrayOfampi)
  {
    boolean bool = true;
    localamyy = new amyy();
    try
    {
      if (new JSONObject(paramArrayOfampi[0].a).optInt("allow_edit_color_nick", 1) == 1) {}
      for (;;)
      {
        localamyy.a = bool;
        return localamyy;
        bool = false;
      }
      return localamyy;
    }
    catch (JSONException paramArrayOfampi)
    {
      veg.e("QVipColorNickProcessor", "QVipColorNickProcessor onParsed exception :" + paramArrayOfampi.getMessage());
    }
  }
  
  public Class<amyy> a()
  {
    return amyy.class;
  }
  
  @NonNull
  public amyy b()
  {
    return new amyy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amyz
 * JD-Core Version:    0.7.0.1
 */
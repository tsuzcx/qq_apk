import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aouw
  extends aouf<aouv>
{
  public static aouv c()
  {
    return (aouv)aoks.a().a(412);
  }
  
  public int a()
  {
    return 412;
  }
  
  @NonNull
  public aouv a()
  {
    return new aouv();
  }
  
  @NonNull
  public aouv a(aoko[] paramArrayOfaoko)
  {
    boolean bool = true;
    localaouv = new aouv();
    try
    {
      if (new JSONObject(paramArrayOfaoko[0].a).optInt("allow_edit_color_nick", 1) == 1) {}
      for (;;)
      {
        localaouv.a = bool;
        return localaouv;
        bool = false;
      }
      return localaouv;
    }
    catch (JSONException paramArrayOfaoko)
    {
      wxe.e("QVipColorNickProcessor", "QVipColorNickProcessor onParsed exception :" + paramArrayOfaoko.getMessage());
    }
  }
  
  public Class<aouv> a()
  {
    return aouv.class;
  }
  
  @NonNull
  public aouv b()
  {
    return new aouv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aouw
 * JD-Core Version:    0.7.0.1
 */
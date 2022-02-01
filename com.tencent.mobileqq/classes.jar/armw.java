import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class armw
  extends armf<armv>
{
  public static armv c()
  {
    return (armv)aran.a().a(412);
  }
  
  @NonNull
  public armv a()
  {
    return new armv();
  }
  
  @NonNull
  public armv a(araj[] paramArrayOfaraj)
  {
    boolean bool = true;
    localarmv = new armv();
    try
    {
      if (new JSONObject(paramArrayOfaraj[0].a).optInt("allow_edit_color_nick", 1) == 1) {}
      for (;;)
      {
        localarmv.a = bool;
        return localarmv;
        bool = false;
      }
      return localarmv;
    }
    catch (JSONException paramArrayOfaraj)
    {
      yuk.e("QVipColorNickProcessor", "QVipColorNickProcessor onParsed exception :" + paramArrayOfaraj.getMessage());
    }
  }
  
  @NonNull
  public armv b()
  {
    return new armv();
  }
  
  public Class<armv> clazz()
  {
    return armv.class;
  }
  
  public int type()
  {
    return 412;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armw
 * JD-Core Version:    0.7.0.1
 */
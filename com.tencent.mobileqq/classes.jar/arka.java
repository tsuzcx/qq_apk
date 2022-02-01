import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arka
  extends arjj<arjz>
{
  public static arjz c()
  {
    return (arjz)aqxe.a().a(412);
  }
  
  @NonNull
  public arjz a()
  {
    return new arjz();
  }
  
  @NonNull
  public arjz a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool = true;
    localarjz = new arjz();
    try
    {
      if (new JSONObject(paramArrayOfaqxa[0].a).optInt("allow_edit_color_nick", 1) == 1) {}
      for (;;)
      {
        localarjz.a = bool;
        return localarjz;
        bool = false;
      }
      return localarjz;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      ykq.e("QVipColorNickProcessor", "QVipColorNickProcessor onParsed exception :" + paramArrayOfaqxa.getMessage());
    }
  }
  
  @NonNull
  public arjz b()
  {
    return new arjz();
  }
  
  public Class<arjz> clazz()
  {
    return arjz.class;
  }
  
  public int type()
  {
    return 412;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arka
 * JD-Core Version:    0.7.0.1
 */
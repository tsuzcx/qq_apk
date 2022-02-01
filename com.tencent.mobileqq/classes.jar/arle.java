import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arle
  extends arjj<arld>
{
  public static arld a = new arld();
  
  public static arld c()
  {
    arld localarld2 = (arld)aqxe.a().a(423);
    arld localarld1 = localarld2;
    if (localarld2 == null) {
      localarld1 = new arld();
    }
    return localarld1;
  }
  
  @NonNull
  public arld a()
  {
    return a;
  }
  
  @NonNull
  public arld a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool = true;
    localarld = new arld();
    paramArrayOfaqxa = paramArrayOfaqxa[0].a;
    try
    {
      if (new JSONObject(paramArrayOfaqxa).optInt("show_red_name_card", 0) == 1) {}
      for (;;)
      {
        localarld.a = bool;
        return localarld;
        bool = false;
      }
      return localarld;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      ykq.e("QVipRedNameCardProcessor", "QVipRedNameCardConfig onParsed exception :" + paramArrayOfaqxa.getMessage());
    }
  }
  
  @NonNull
  public arld b()
  {
    return a;
  }
  
  public Class<arld> clazz()
  {
    return arld.class;
  }
  
  public int type()
  {
    return 423;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arle
 * JD-Core Version:    0.7.0.1
 */
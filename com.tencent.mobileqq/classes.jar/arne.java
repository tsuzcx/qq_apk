import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arne
  extends armf<arnd>
{
  @NonNull
  public arnd a()
  {
    return new arnd();
  }
  
  @NonNull
  public arnd a(araj[] paramArrayOfaraj)
  {
    boolean bool = true;
    localarnd = new arnd();
    paramArrayOfaraj = paramArrayOfaraj[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj);
      if (paramArrayOfaraj.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localarnd.jdField_a_of_type_Boolean = bool;
        localarnd.jdField_a_of_type_JavaLangString = paramArrayOfaraj.optString("recover_text", localarnd.jdField_a_of_type_JavaLangString);
        localarnd.b = paramArrayOfaraj.optString("recover_url", localarnd.b);
        return localarnd;
        bool = false;
      }
      return localarnd;
    }
    catch (JSONException paramArrayOfaraj)
    {
      yuk.e("QVipFriendTagProcessor", "QVipFriendTagConfig onParsed exception :" + paramArrayOfaraj.getMessage());
    }
  }
  
  @NonNull
  public arnd b()
  {
    return new arnd();
  }
  
  public Class<arnd> clazz()
  {
    return arnd.class;
  }
  
  public int type()
  {
    return 409;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arne
 * JD-Core Version:    0.7.0.1
 */
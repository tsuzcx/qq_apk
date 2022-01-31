import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amjb
  extends amie<amja>
{
  public static amja c()
  {
    amja localamja2 = (amja)alzw.a().a(469);
    amja localamja1 = localamja2;
    if (localamja2 == null) {
      localamja1 = new amja();
    }
    return localamja1;
  }
  
  public int a()
  {
    return 469;
  }
  
  @NonNull
  public amja a()
  {
    return new amja();
  }
  
  @NonNull
  public amja a(alzs[] paramArrayOfalzs)
  {
    boolean bool = true;
    localamja = new amja();
    paramArrayOfalzs = paramArrayOfalzs[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs);
      if (paramArrayOfalzs.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localamja.jdField_a_of_type_Boolean = bool;
        localamja.jdField_a_of_type_JavaLangString = paramArrayOfalzs.optString("recover_text", localamja.jdField_a_of_type_JavaLangString);
        localamja.b = paramArrayOfalzs.optString("recover_url", localamja.b);
        localamja.c = paramArrayOfalzs.optString("recoveryHomePageUrl", localamja.c);
        return localamja;
        bool = false;
      }
      return localamja;
    }
    catch (JSONException paramArrayOfalzs)
    {
      urk.e("QVipFriendTag2Processor", "QVipFriendTag2Config onParsed exception :" + paramArrayOfalzs.getMessage());
    }
  }
  
  public Class<amja> a()
  {
    return amja.class;
  }
  
  @NonNull
  public amja b()
  {
    return new amja();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjb
 * JD-Core Version:    0.7.0.1
 */
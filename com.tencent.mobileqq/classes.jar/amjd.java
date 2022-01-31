import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amjd
  extends amie<amjc>
{
  public static amjc c()
  {
    return (amjc)alzw.a().a(409);
  }
  
  public int a()
  {
    return 409;
  }
  
  @NonNull
  public amjc a()
  {
    return new amjc();
  }
  
  @NonNull
  public amjc a(alzs[] paramArrayOfalzs)
  {
    boolean bool = true;
    localamjc = new amjc();
    paramArrayOfalzs = paramArrayOfalzs[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs);
      if (paramArrayOfalzs.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localamjc.jdField_a_of_type_Boolean = bool;
        localamjc.jdField_a_of_type_JavaLangString = paramArrayOfalzs.optString("recover_text", localamjc.jdField_a_of_type_JavaLangString);
        localamjc.b = paramArrayOfalzs.optString("recover_url", localamjc.b);
        return localamjc;
        bool = false;
      }
      return localamjc;
    }
    catch (JSONException paramArrayOfalzs)
    {
      urk.e("QVipFriendTagProcessor", "QVipFriendTagConfig onParsed exception :" + paramArrayOfalzs.getMessage());
    }
  }
  
  public Class<amjc> a()
  {
    return amjc.class;
  }
  
  @NonNull
  public amjc b()
  {
    return new amjc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjd
 * JD-Core Version:    0.7.0.1
 */
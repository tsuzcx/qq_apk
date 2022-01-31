import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aove
  extends aouf<aovd>
{
  public static aovd c()
  {
    return (aovd)aoks.a().a(409);
  }
  
  public int a()
  {
    return 409;
  }
  
  @NonNull
  public aovd a()
  {
    return new aovd();
  }
  
  @NonNull
  public aovd a(aoko[] paramArrayOfaoko)
  {
    boolean bool = true;
    localaovd = new aovd();
    paramArrayOfaoko = paramArrayOfaoko[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko);
      if (paramArrayOfaoko.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localaovd.jdField_a_of_type_Boolean = bool;
        localaovd.jdField_a_of_type_JavaLangString = paramArrayOfaoko.optString("recover_text", localaovd.jdField_a_of_type_JavaLangString);
        localaovd.b = paramArrayOfaoko.optString("recover_url", localaovd.b);
        return localaovd;
        bool = false;
      }
      return localaovd;
    }
    catch (JSONException paramArrayOfaoko)
    {
      wxe.e("QVipFriendTagProcessor", "QVipFriendTagConfig onParsed exception :" + paramArrayOfaoko.getMessage());
    }
  }
  
  public Class<aovd> a()
  {
    return aovd.class;
  }
  
  @NonNull
  public aovd b()
  {
    return new aovd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aove
 * JD-Core Version:    0.7.0.1
 */
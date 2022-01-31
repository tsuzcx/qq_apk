import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzo
  extends amyp<amzn>
{
  public static amzn c()
  {
    return (amzn)ampl.a().a(409);
  }
  
  public int a()
  {
    return 409;
  }
  
  @NonNull
  public amzn a()
  {
    return new amzn();
  }
  
  @NonNull
  public amzn a(amph[] paramArrayOfamph)
  {
    boolean bool = true;
    localamzn = new amzn();
    paramArrayOfamph = paramArrayOfamph[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph);
      if (paramArrayOfamph.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localamzn.jdField_a_of_type_Boolean = bool;
        localamzn.jdField_a_of_type_JavaLangString = paramArrayOfamph.optString("recover_text", localamzn.jdField_a_of_type_JavaLangString);
        localamzn.b = paramArrayOfamph.optString("recover_url", localamzn.b);
        return localamzn;
        bool = false;
      }
      return localamzn;
    }
    catch (JSONException paramArrayOfamph)
    {
      ved.e("QVipFriendTagProcessor", "QVipFriendTagConfig onParsed exception :" + paramArrayOfamph.getMessage());
    }
  }
  
  public Class<amzn> a()
  {
    return amzn.class;
  }
  
  @NonNull
  public amzn b()
  {
    return new amzn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzo
 * JD-Core Version:    0.7.0.1
 */
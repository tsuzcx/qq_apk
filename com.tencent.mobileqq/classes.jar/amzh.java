import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzh
  extends amyi<amzg>
{
  public static amzg c()
  {
    return (amzg)ampm.a().a(409);
  }
  
  public int a()
  {
    return 409;
  }
  
  @NonNull
  public amzg a()
  {
    return new amzg();
  }
  
  @NonNull
  public amzg a(ampi[] paramArrayOfampi)
  {
    boolean bool = true;
    localamzg = new amzg();
    paramArrayOfampi = paramArrayOfampi[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi);
      if (paramArrayOfampi.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localamzg.jdField_a_of_type_Boolean = bool;
        localamzg.jdField_a_of_type_JavaLangString = paramArrayOfampi.optString("recover_text", localamzg.jdField_a_of_type_JavaLangString);
        localamzg.b = paramArrayOfampi.optString("recover_url", localamzg.b);
        return localamzg;
        bool = false;
      }
      return localamzg;
    }
    catch (JSONException paramArrayOfampi)
    {
      veg.e("QVipFriendTagProcessor", "QVipFriendTagConfig onParsed exception :" + paramArrayOfampi.getMessage());
    }
  }
  
  public Class<amzg> a()
  {
    return amzg.class;
  }
  
  @NonNull
  public amzg b()
  {
    return new amzg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzh
 * JD-Core Version:    0.7.0.1
 */
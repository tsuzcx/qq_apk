import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzm
  extends amyp<amzl>
{
  public static amzl c()
  {
    amzl localamzl2 = (amzl)ampl.a().a(469);
    amzl localamzl1 = localamzl2;
    if (localamzl2 == null) {
      localamzl1 = new amzl();
    }
    return localamzl1;
  }
  
  public int a()
  {
    return 469;
  }
  
  @NonNull
  public amzl a()
  {
    return new amzl();
  }
  
  @NonNull
  public amzl a(amph[] paramArrayOfamph)
  {
    boolean bool = true;
    localamzl = new amzl();
    paramArrayOfamph = paramArrayOfamph[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph);
      if (paramArrayOfamph.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localamzl.jdField_a_of_type_Boolean = bool;
        localamzl.jdField_a_of_type_JavaLangString = paramArrayOfamph.optString("recover_text", localamzl.jdField_a_of_type_JavaLangString);
        localamzl.b = paramArrayOfamph.optString("recover_url", localamzl.b);
        localamzl.c = paramArrayOfamph.optString("recoveryHomePageUrl", localamzl.c);
        return localamzl;
        bool = false;
      }
      return localamzl;
    }
    catch (JSONException paramArrayOfamph)
    {
      ved.e("QVipFriendTag2Processor", "QVipFriendTag2Config onParsed exception :" + paramArrayOfamph.getMessage());
    }
  }
  
  public Class<amzl> a()
  {
    return amzl.class;
  }
  
  @NonNull
  public amzl b()
  {
    return new amzl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzm
 * JD-Core Version:    0.7.0.1
 */
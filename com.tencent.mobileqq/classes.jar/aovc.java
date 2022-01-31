import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aovc
  extends aouf<aovb>
{
  public static aovb c()
  {
    aovb localaovb2 = (aovb)aoks.a().a(469);
    aovb localaovb1 = localaovb2;
    if (localaovb2 == null) {
      localaovb1 = new aovb();
    }
    return localaovb1;
  }
  
  public int a()
  {
    return 469;
  }
  
  @NonNull
  public aovb a()
  {
    return new aovb();
  }
  
  @NonNull
  public aovb a(aoko[] paramArrayOfaoko)
  {
    boolean bool = true;
    localaovb = new aovb();
    paramArrayOfaoko = paramArrayOfaoko[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko);
      if (paramArrayOfaoko.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localaovb.jdField_a_of_type_Boolean = bool;
        localaovb.jdField_a_of_type_JavaLangString = paramArrayOfaoko.optString("recover_text", localaovb.jdField_a_of_type_JavaLangString);
        localaovb.b = paramArrayOfaoko.optString("recover_url", localaovb.b);
        localaovb.c = paramArrayOfaoko.optString("recoveryHomePageUrl", localaovb.c);
        return localaovb;
        bool = false;
      }
      return localaovb;
    }
    catch (JSONException paramArrayOfaoko)
    {
      wxe.e("QVipFriendTag2Processor", "QVipFriendTag2Config onParsed exception :" + paramArrayOfaoko.getMessage());
    }
  }
  
  public Class<aovb> a()
  {
    return aovb.class;
  }
  
  @NonNull
  public aovb b()
  {
    return new aovb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovc
 * JD-Core Version:    0.7.0.1
 */
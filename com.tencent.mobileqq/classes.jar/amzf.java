import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class amzf
  extends amyi<amze>
{
  public static amze c()
  {
    amze localamze2 = (amze)ampm.a().a(469);
    amze localamze1 = localamze2;
    if (localamze2 == null) {
      localamze1 = new amze();
    }
    return localamze1;
  }
  
  public int a()
  {
    return 469;
  }
  
  @NonNull
  public amze a()
  {
    return new amze();
  }
  
  @NonNull
  public amze a(ampi[] paramArrayOfampi)
  {
    boolean bool = true;
    localamze = new amze();
    paramArrayOfampi = paramArrayOfampi[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi);
      if (paramArrayOfampi.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localamze.jdField_a_of_type_Boolean = bool;
        localamze.jdField_a_of_type_JavaLangString = paramArrayOfampi.optString("recover_text", localamze.jdField_a_of_type_JavaLangString);
        localamze.b = paramArrayOfampi.optString("recover_url", localamze.b);
        localamze.c = paramArrayOfampi.optString("recoveryHomePageUrl", localamze.c);
        return localamze;
        bool = false;
      }
      return localamze;
    }
    catch (JSONException paramArrayOfampi)
    {
      veg.e("QVipFriendTag2Processor", "QVipFriendTag2Config onParsed exception :" + paramArrayOfampi.getMessage());
    }
  }
  
  public Class<amze> a()
  {
    return amze.class;
  }
  
  @NonNull
  public amze b()
  {
    return new amze();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzf
 * JD-Core Version:    0.7.0.1
 */
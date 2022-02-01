import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arnc
  extends armf<arnb>
{
  public static arnb c()
  {
    arnb localarnb2 = (arnb)aran.a().a(469);
    arnb localarnb1 = localarnb2;
    if (localarnb2 == null) {
      localarnb1 = new arnb();
    }
    return localarnb1;
  }
  
  @NonNull
  public arnb a()
  {
    return new arnb();
  }
  
  @NonNull
  public arnb a(araj[] paramArrayOfaraj)
  {
    boolean bool = true;
    localarnb = new arnb();
    paramArrayOfaraj = paramArrayOfaraj[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj);
      if (paramArrayOfaraj.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localarnb.jdField_a_of_type_Boolean = bool;
        localarnb.jdField_a_of_type_JavaLangString = paramArrayOfaraj.optString("recover_text", localarnb.jdField_a_of_type_JavaLangString);
        localarnb.b = paramArrayOfaraj.optString("recover_url", localarnb.b);
        localarnb.c = paramArrayOfaraj.optString("recoveryHomePageUrl", localarnb.c);
        return localarnb;
        bool = false;
      }
      return localarnb;
    }
    catch (JSONException paramArrayOfaraj)
    {
      yuk.e("QVipFriendTag2Processor", "QVipFriendTag2Config onParsed exception :" + paramArrayOfaraj.getMessage());
    }
  }
  
  @NonNull
  public arnb b()
  {
    return new arnb();
  }
  
  public Class<arnb> clazz()
  {
    return arnb.class;
  }
  
  public int type()
  {
    return 469;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arnc
 * JD-Core Version:    0.7.0.1
 */
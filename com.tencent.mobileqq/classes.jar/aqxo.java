import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqxo
  extends aqwr<aqxn>
{
  public static aqxn c()
  {
    aqxn localaqxn2 = (aqxn)aqlk.a().a(469);
    aqxn localaqxn1 = localaqxn2;
    if (localaqxn2 == null) {
      localaqxn1 = new aqxn();
    }
    return localaqxn1;
  }
  
  @NonNull
  public aqxn a()
  {
    return new aqxn();
  }
  
  @NonNull
  public aqxn a(aqlg[] paramArrayOfaqlg)
  {
    boolean bool = true;
    localaqxn = new aqxn();
    paramArrayOfaqlg = paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg);
      if (paramArrayOfaqlg.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localaqxn.jdField_a_of_type_Boolean = bool;
        localaqxn.jdField_a_of_type_JavaLangString = paramArrayOfaqlg.optString("recover_text", localaqxn.jdField_a_of_type_JavaLangString);
        localaqxn.b = paramArrayOfaqlg.optString("recover_url", localaqxn.b);
        localaqxn.c = paramArrayOfaqlg.optString("recoveryHomePageUrl", localaqxn.c);
        return localaqxn;
        bool = false;
      }
      return localaqxn;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      yqp.e("QVipFriendTag2Processor", "QVipFriendTag2Config onParsed exception :" + paramArrayOfaqlg.getMessage());
    }
  }
  
  @NonNull
  public aqxn b()
  {
    return new aqxn();
  }
  
  public Class<aqxn> clazz()
  {
    return aqxn.class;
  }
  
  public int type()
  {
    return 469;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqxo
 * JD-Core Version:    0.7.0.1
 */
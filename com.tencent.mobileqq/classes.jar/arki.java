import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arki
  extends arjj<arkh>
{
  public static arkh c()
  {
    arkh localarkh2 = (arkh)aqxe.a().a(469);
    arkh localarkh1 = localarkh2;
    if (localarkh2 == null) {
      localarkh1 = new arkh();
    }
    return localarkh1;
  }
  
  @NonNull
  public arkh a()
  {
    return new arkh();
  }
  
  @NonNull
  public arkh a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool = true;
    localarkh = new arkh();
    paramArrayOfaqxa = paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa);
      if (paramArrayOfaqxa.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localarkh.jdField_a_of_type_Boolean = bool;
        localarkh.jdField_a_of_type_JavaLangString = paramArrayOfaqxa.optString("recover_text", localarkh.jdField_a_of_type_JavaLangString);
        localarkh.b = paramArrayOfaqxa.optString("recover_url", localarkh.b);
        localarkh.c = paramArrayOfaqxa.optString("recoveryHomePageUrl", localarkh.c);
        return localarkh;
        bool = false;
      }
      return localarkh;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      ykq.e("QVipFriendTag2Processor", "QVipFriendTag2Config onParsed exception :" + paramArrayOfaqxa.getMessage());
    }
  }
  
  @NonNull
  public arkh b()
  {
    return new arkh();
  }
  
  public Class<arkh> clazz()
  {
    return arkh.class;
  }
  
  public int type()
  {
    return 469;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arki
 * JD-Core Version:    0.7.0.1
 */
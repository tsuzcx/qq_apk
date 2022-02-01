import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class arkk
  extends arjj<arkj>
{
  @NonNull
  public arkj a()
  {
    return new arkj();
  }
  
  @NonNull
  public arkj a(aqxa[] paramArrayOfaqxa)
  {
    boolean bool = true;
    localarkj = new arkj();
    paramArrayOfaqxa = paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa);
      if (paramArrayOfaqxa.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localarkj.jdField_a_of_type_Boolean = bool;
        localarkj.jdField_a_of_type_JavaLangString = paramArrayOfaqxa.optString("recover_text", localarkj.jdField_a_of_type_JavaLangString);
        localarkj.b = paramArrayOfaqxa.optString("recover_url", localarkj.b);
        return localarkj;
        bool = false;
      }
      return localarkj;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      ykq.e("QVipFriendTagProcessor", "QVipFriendTagConfig onParsed exception :" + paramArrayOfaqxa.getMessage());
    }
  }
  
  @NonNull
  public arkj b()
  {
    return new arkj();
  }
  
  public Class<arkj> clazz()
  {
    return arkj.class;
  }
  
  public int type()
  {
    return 409;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkk
 * JD-Core Version:    0.7.0.1
 */
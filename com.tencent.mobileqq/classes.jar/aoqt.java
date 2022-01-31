import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aoqt
  extends aopw<aoqs>
{
  public static aoqs c()
  {
    aoqs localaoqs2 = (aoqs)aogj.a().a(469);
    aoqs localaoqs1 = localaoqs2;
    if (localaoqs2 == null) {
      localaoqs1 = new aoqs();
    }
    return localaoqs1;
  }
  
  public int a()
  {
    return 469;
  }
  
  @NonNull
  public aoqs a()
  {
    return new aoqs();
  }
  
  @NonNull
  public aoqs a(aogf[] paramArrayOfaogf)
  {
    boolean bool = true;
    localaoqs = new aoqs();
    paramArrayOfaogf = paramArrayOfaogf[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf);
      if (paramArrayOfaogf.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localaoqs.jdField_a_of_type_Boolean = bool;
        localaoqs.jdField_a_of_type_JavaLangString = paramArrayOfaogf.optString("recover_text", localaoqs.jdField_a_of_type_JavaLangString);
        localaoqs.b = paramArrayOfaogf.optString("recover_url", localaoqs.b);
        localaoqs.c = paramArrayOfaogf.optString("recoveryHomePageUrl", localaoqs.c);
        return localaoqs;
        bool = false;
      }
      return localaoqs;
    }
    catch (JSONException paramArrayOfaogf)
    {
      wsv.e("QVipFriendTag2Processor", "QVipFriendTag2Config onParsed exception :" + paramArrayOfaogf.getMessage());
    }
  }
  
  public Class<aoqs> a()
  {
    return aoqs.class;
  }
  
  @NonNull
  public aoqs b()
  {
    return new aoqs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqt
 * JD-Core Version:    0.7.0.1
 */
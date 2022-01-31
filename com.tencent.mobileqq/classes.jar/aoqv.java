import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aoqv
  extends aopw<aoqu>
{
  public static aoqu c()
  {
    return (aoqu)aogj.a().a(409);
  }
  
  public int a()
  {
    return 409;
  }
  
  @NonNull
  public aoqu a()
  {
    return new aoqu();
  }
  
  @NonNull
  public aoqu a(aogf[] paramArrayOfaogf)
  {
    boolean bool = true;
    localaoqu = new aoqu();
    paramArrayOfaogf = paramArrayOfaogf[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf);
      if (paramArrayOfaogf.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localaoqu.jdField_a_of_type_Boolean = bool;
        localaoqu.jdField_a_of_type_JavaLangString = paramArrayOfaogf.optString("recover_text", localaoqu.jdField_a_of_type_JavaLangString);
        localaoqu.b = paramArrayOfaogf.optString("recover_url", localaoqu.b);
        return localaoqu;
        bool = false;
      }
      return localaoqu;
    }
    catch (JSONException paramArrayOfaogf)
    {
      wsv.e("QVipFriendTagProcessor", "QVipFriendTagConfig onParsed exception :" + paramArrayOfaogf.getMessage());
    }
  }
  
  public Class<aoqu> a()
  {
    return aoqu.class;
  }
  
  @NonNull
  public aoqu b()
  {
    return new aoqu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqv
 * JD-Core Version:    0.7.0.1
 */
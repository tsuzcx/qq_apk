import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqxq
  extends aqwr<aqxp>
{
  public static aqxp c()
  {
    return (aqxp)aqlk.a().a(409);
  }
  
  @NonNull
  public aqxp a()
  {
    return new aqxp();
  }
  
  @NonNull
  public aqxp a(aqlg[] paramArrayOfaqlg)
  {
    boolean bool = true;
    localaqxp = new aqxp();
    paramArrayOfaqlg = paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg);
      if (paramArrayOfaqlg.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localaqxp.jdField_a_of_type_Boolean = bool;
        localaqxp.jdField_a_of_type_JavaLangString = paramArrayOfaqlg.optString("recover_text", localaqxp.jdField_a_of_type_JavaLangString);
        localaqxp.b = paramArrayOfaqlg.optString("recover_url", localaqxp.b);
        return localaqxp;
        bool = false;
      }
      return localaqxp;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      yqp.e("QVipFriendTagProcessor", "QVipFriendTagConfig onParsed exception :" + paramArrayOfaqlg.getMessage());
    }
  }
  
  @NonNull
  public aqxp b()
  {
    return new aqxp();
  }
  
  public Class<aqxp> clazz()
  {
    return aqxp.class;
  }
  
  public int type()
  {
    return 409;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqxq
 * JD-Core Version:    0.7.0.1
 */
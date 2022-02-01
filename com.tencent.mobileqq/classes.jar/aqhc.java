import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqhc
  extends aqgc<aqhb>
{
  @NonNull
  public aqhb a()
  {
    return new aqhb();
  }
  
  @NonNull
  public aqhb a(aptx[] paramArrayOfaptx)
  {
    boolean bool = true;
    localaqhb = new aqhb();
    paramArrayOfaptx = paramArrayOfaptx[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx);
      if (paramArrayOfaptx.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localaqhb.jdField_a_of_type_Boolean = bool;
        localaqhb.jdField_a_of_type_JavaLangString = paramArrayOfaptx.optString("recover_text", localaqhb.jdField_a_of_type_JavaLangString);
        localaqhb.b = paramArrayOfaptx.optString("recover_url", localaqhb.b);
        return localaqhb;
        bool = false;
      }
      return localaqhb;
    }
    catch (JSONException paramArrayOfaptx)
    {
      xvv.e("QVipFriendTagProcessor", "QVipFriendTagConfig onParsed exception :" + paramArrayOfaptx.getMessage());
    }
  }
  
  @NonNull
  public aqhb b()
  {
    return new aqhb();
  }
  
  public Class<aqhb> clazz()
  {
    return aqhb.class;
  }
  
  public int type()
  {
    return 409;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqhc
 * JD-Core Version:    0.7.0.1
 */
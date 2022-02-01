import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqha
  extends aqgc<aqgz>
{
  public static aqgz c()
  {
    aqgz localaqgz2 = (aqgz)apub.a().a(469);
    aqgz localaqgz1 = localaqgz2;
    if (localaqgz2 == null) {
      localaqgz1 = new aqgz();
    }
    return localaqgz1;
  }
  
  @NonNull
  public aqgz a()
  {
    return new aqgz();
  }
  
  @NonNull
  public aqgz a(aptx[] paramArrayOfaptx)
  {
    boolean bool = true;
    localaqgz = new aqgz();
    paramArrayOfaptx = paramArrayOfaptx[0].jdField_a_of_type_JavaLangString;
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx);
      if (paramArrayOfaptx.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localaqgz.jdField_a_of_type_Boolean = bool;
        localaqgz.jdField_a_of_type_JavaLangString = paramArrayOfaptx.optString("recover_text", localaqgz.jdField_a_of_type_JavaLangString);
        localaqgz.b = paramArrayOfaptx.optString("recover_url", localaqgz.b);
        localaqgz.c = paramArrayOfaptx.optString("recoveryHomePageUrl", localaqgz.c);
        return localaqgz;
        bool = false;
      }
      return localaqgz;
    }
    catch (JSONException paramArrayOfaptx)
    {
      xvv.e("QVipFriendTag2Processor", "QVipFriendTag2Config onParsed exception :" + paramArrayOfaptx.getMessage());
    }
  }
  
  @NonNull
  public aqgz b()
  {
    return new aqgz();
  }
  
  public Class<aqgz> clazz()
  {
    return aqgz.class;
  }
  
  public int type()
  {
    return 469;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqha
 * JD-Core Version:    0.7.0.1
 */
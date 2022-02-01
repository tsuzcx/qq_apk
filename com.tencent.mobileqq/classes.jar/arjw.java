import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arjw
  extends arjj<arjv>
{
  public static arjv c()
  {
    arjv localarjv2 = (arjv)aqxe.a().a(498);
    arjv localarjv1 = localarjv2;
    if (localarjv2 == null) {
      localarjv1 = new arjv();
    }
    return localarjv1;
  }
  
  @NonNull
  public arjv a()
  {
    return new arjv();
  }
  
  @NonNull
  public arjv a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    arjv localarjv = new arjv();
    paramArrayOfaqxa = paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramArrayOfaqxa)) {}
    for (;;)
    {
      return localarjv;
      try
      {
        paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa);
        localarjv.jdField_a_of_type_Int = paramArrayOfaqxa.optInt("stage");
        localarjv.jdField_a_of_type_JavaLangString = paramArrayOfaqxa.optString("pay_url");
        if (QLog.isColorLevel())
        {
          QLog.d("vip_ptt.ConfigProcessor", 1, "json parse config.stage:" + localarjv.jdField_a_of_type_Int + " url=" + localarjv.jdField_a_of_type_JavaLangString);
          return localarjv;
        }
      }
      catch (JSONException paramArrayOfaqxa)
      {
        QLog.e("vip_ptt.ConfigProcessor", 1, "json parse error:" + paramArrayOfaqxa);
        localarjv.b = paramArrayOfaqxa.toString();
      }
    }
    return localarjv;
  }
  
  @NonNull
  public arjv b()
  {
    return new arjv();
  }
  
  public Class<arjv> clazz()
  {
    return arjv.class;
  }
  
  public int type()
  {
    return 498;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjw
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arms
  extends armf<armr>
{
  public static armr c()
  {
    armr localarmr2 = (armr)aran.a().a(498);
    armr localarmr1 = localarmr2;
    if (localarmr2 == null) {
      localarmr1 = new armr();
    }
    return localarmr1;
  }
  
  @NonNull
  public armr a()
  {
    return new armr();
  }
  
  @NonNull
  public armr a(@NonNull araj[] paramArrayOfaraj)
  {
    armr localarmr = new armr();
    paramArrayOfaraj = paramArrayOfaraj[0].jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramArrayOfaraj)) {}
    for (;;)
    {
      return localarmr;
      try
      {
        paramArrayOfaraj = new JSONObject(paramArrayOfaraj);
        localarmr.jdField_a_of_type_Int = paramArrayOfaraj.optInt("stage");
        localarmr.jdField_a_of_type_JavaLangString = paramArrayOfaraj.optString("pay_url");
        if (QLog.isColorLevel())
        {
          QLog.d("vip_ptt.ConfigProcessor", 1, "json parse config.stage:" + localarmr.jdField_a_of_type_Int + " url=" + localarmr.jdField_a_of_type_JavaLangString);
          return localarmr;
        }
      }
      catch (JSONException paramArrayOfaraj)
      {
        QLog.e("vip_ptt.ConfigProcessor", 1, "json parse error:" + paramArrayOfaraj);
        localarmr.b = paramArrayOfaraj.toString();
      }
    }
    return localarmr;
  }
  
  @NonNull
  public armr b()
  {
    return new armr();
  }
  
  public Class<armr> clazz()
  {
    return armr.class;
  }
  
  public int type()
  {
    return 498;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arms
 * JD-Core Version:    0.7.0.1
 */
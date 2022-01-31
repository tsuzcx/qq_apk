import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aous
  extends aouf<aour>
{
  public static aour c()
  {
    aour localaour2 = (aour)aoks.a().a(498);
    aour localaour1 = localaour2;
    if (localaour2 == null) {
      localaour1 = new aour();
    }
    return localaour1;
  }
  
  public int a()
  {
    return 498;
  }
  
  @NonNull
  public aour a()
  {
    return new aour();
  }
  
  @NonNull
  public aour a(@NonNull aoko[] paramArrayOfaoko)
  {
    aour localaour = new aour();
    paramArrayOfaoko = paramArrayOfaoko[0].jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramArrayOfaoko)) {}
    for (;;)
    {
      return localaour;
      try
      {
        paramArrayOfaoko = new JSONObject(paramArrayOfaoko);
        localaour.jdField_a_of_type_Int = paramArrayOfaoko.optInt("stage");
        localaour.jdField_a_of_type_JavaLangString = paramArrayOfaoko.optString("pay_url");
        if (QLog.isColorLevel())
        {
          QLog.d("vip_ptt.ConfigProcessor", 1, "json parse config.stage:" + localaour.jdField_a_of_type_Int + " url=" + localaour.jdField_a_of_type_JavaLangString);
          return localaour;
        }
      }
      catch (JSONException paramArrayOfaoko)
      {
        QLog.e("vip_ptt.ConfigProcessor", 1, "json parse error:" + paramArrayOfaoko);
        localaour.b = paramArrayOfaoko.toString();
      }
    }
    return localaour;
  }
  
  public Class<aour> a()
  {
    return aour.class;
  }
  
  @NonNull
  public aour b()
  {
    return new aour();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aous
 * JD-Core Version:    0.7.0.1
 */
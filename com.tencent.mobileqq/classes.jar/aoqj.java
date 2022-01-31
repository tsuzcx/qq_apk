import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoqj
  extends aopw<aoqi>
{
  public static aoqi c()
  {
    aoqi localaoqi2 = (aoqi)aogj.a().a(498);
    aoqi localaoqi1 = localaoqi2;
    if (localaoqi2 == null) {
      localaoqi1 = new aoqi();
    }
    return localaoqi1;
  }
  
  public int a()
  {
    return 498;
  }
  
  @NonNull
  public aoqi a()
  {
    return new aoqi();
  }
  
  @NonNull
  public aoqi a(@NonNull aogf[] paramArrayOfaogf)
  {
    aoqi localaoqi = new aoqi();
    paramArrayOfaogf = paramArrayOfaogf[0].jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramArrayOfaogf)) {}
    for (;;)
    {
      return localaoqi;
      try
      {
        paramArrayOfaogf = new JSONObject(paramArrayOfaogf);
        localaoqi.jdField_a_of_type_Int = paramArrayOfaogf.optInt("stage");
        localaoqi.jdField_a_of_type_JavaLangString = paramArrayOfaogf.optString("pay_url");
        if (QLog.isColorLevel())
        {
          QLog.d("vip_ptt.ConfigProcessor", 1, "json parse config.stage:" + localaoqi.jdField_a_of_type_Int + " url=" + localaoqi.jdField_a_of_type_JavaLangString);
          return localaoqi;
        }
      }
      catch (JSONException paramArrayOfaogf)
      {
        QLog.e("vip_ptt.ConfigProcessor", 1, "json parse error:" + paramArrayOfaogf);
        localaoqi.b = paramArrayOfaogf.toString();
      }
    }
    return localaoqi;
  }
  
  public Class<aoqi> a()
  {
    return aoqi.class;
  }
  
  @NonNull
  public aoqi b()
  {
    return new aoqi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqj
 * JD-Core Version:    0.7.0.1
 */
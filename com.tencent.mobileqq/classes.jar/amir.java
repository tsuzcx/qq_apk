import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amir
  extends amie<amiq>
{
  public static amiq c()
  {
    amiq localamiq2 = (amiq)alzw.a().a(498);
    amiq localamiq1 = localamiq2;
    if (localamiq2 == null) {
      localamiq1 = new amiq();
    }
    return localamiq1;
  }
  
  public int a()
  {
    return 498;
  }
  
  @NonNull
  public amiq a()
  {
    return new amiq();
  }
  
  @NonNull
  public amiq a(@NonNull alzs[] paramArrayOfalzs)
  {
    amiq localamiq = new amiq();
    paramArrayOfalzs = paramArrayOfalzs[0].jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramArrayOfalzs)) {}
    for (;;)
    {
      return localamiq;
      try
      {
        paramArrayOfalzs = new JSONObject(paramArrayOfalzs);
        localamiq.jdField_a_of_type_Int = paramArrayOfalzs.optInt("stage");
        localamiq.jdField_a_of_type_JavaLangString = paramArrayOfalzs.optString("pay_url");
        if (QLog.isColorLevel())
        {
          QLog.d("vip_ptt.ConfigProcessor", 1, "json parse config.stage:" + localamiq.jdField_a_of_type_Int + " url=" + localamiq.jdField_a_of_type_JavaLangString);
          return localamiq;
        }
      }
      catch (JSONException paramArrayOfalzs)
      {
        QLog.e("vip_ptt.ConfigProcessor", 1, "json parse error:" + paramArrayOfalzs);
        localamiq.b = paramArrayOfalzs.toString();
      }
    }
    return localamiq;
  }
  
  public Class<amiq> a()
  {
    return amiq.class;
  }
  
  @NonNull
  public amiq b()
  {
    return new amiq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amir
 * JD-Core Version:    0.7.0.1
 */
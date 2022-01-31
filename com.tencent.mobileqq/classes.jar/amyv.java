import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amyv
  extends amyi<amyu>
{
  public static amyu c()
  {
    amyu localamyu2 = (amyu)ampm.a().a(498);
    amyu localamyu1 = localamyu2;
    if (localamyu2 == null) {
      localamyu1 = new amyu();
    }
    return localamyu1;
  }
  
  public int a()
  {
    return 498;
  }
  
  @NonNull
  public amyu a()
  {
    return new amyu();
  }
  
  @NonNull
  public amyu a(@NonNull ampi[] paramArrayOfampi)
  {
    amyu localamyu = new amyu();
    paramArrayOfampi = paramArrayOfampi[0].jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramArrayOfampi)) {}
    for (;;)
    {
      return localamyu;
      try
      {
        paramArrayOfampi = new JSONObject(paramArrayOfampi);
        localamyu.jdField_a_of_type_Int = paramArrayOfampi.optInt("stage");
        localamyu.jdField_a_of_type_JavaLangString = paramArrayOfampi.optString("pay_url");
        if (QLog.isColorLevel())
        {
          QLog.d("vip_ptt.ConfigProcessor", 1, "json parse config.stage:" + localamyu.jdField_a_of_type_Int + " url=" + localamyu.jdField_a_of_type_JavaLangString);
          return localamyu;
        }
      }
      catch (JSONException paramArrayOfampi)
      {
        QLog.e("vip_ptt.ConfigProcessor", 1, "json parse error:" + paramArrayOfampi);
        localamyu.b = paramArrayOfampi.toString();
      }
    }
    return localamyu;
  }
  
  public Class<amyu> a()
  {
    return amyu.class;
  }
  
  @NonNull
  public amyu b()
  {
    return new amyu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amyv
 * JD-Core Version:    0.7.0.1
 */
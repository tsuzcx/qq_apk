import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amzc
  extends amyp<amzb>
{
  public static amzb c()
  {
    amzb localamzb2 = (amzb)ampl.a().a(498);
    amzb localamzb1 = localamzb2;
    if (localamzb2 == null) {
      localamzb1 = new amzb();
    }
    return localamzb1;
  }
  
  public int a()
  {
    return 498;
  }
  
  @NonNull
  public amzb a()
  {
    return new amzb();
  }
  
  @NonNull
  public amzb a(@NonNull amph[] paramArrayOfamph)
  {
    amzb localamzb = new amzb();
    paramArrayOfamph = paramArrayOfamph[0].jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramArrayOfamph)) {}
    for (;;)
    {
      return localamzb;
      try
      {
        paramArrayOfamph = new JSONObject(paramArrayOfamph);
        localamzb.jdField_a_of_type_Int = paramArrayOfamph.optInt("stage");
        localamzb.jdField_a_of_type_JavaLangString = paramArrayOfamph.optString("pay_url");
        if (QLog.isColorLevel())
        {
          QLog.d("vip_ptt.ConfigProcessor", 1, "json parse config.stage:" + localamzb.jdField_a_of_type_Int + " url=" + localamzb.jdField_a_of_type_JavaLangString);
          return localamzb;
        }
      }
      catch (JSONException paramArrayOfamph)
      {
        QLog.e("vip_ptt.ConfigProcessor", 1, "json parse error:" + paramArrayOfamph);
        localamzb.b = paramArrayOfamph.toString();
      }
    }
    return localamzb;
  }
  
  public Class<amzb> a()
  {
    return amzb.class;
  }
  
  @NonNull
  public amzb b()
  {
    return new amzb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzc
 * JD-Core Version:    0.7.0.1
 */
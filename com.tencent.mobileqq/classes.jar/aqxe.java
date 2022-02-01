import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqxe
  extends aqwr<aqxd>
{
  public static aqxd c()
  {
    aqxd localaqxd2 = (aqxd)aqlk.a().a(498);
    aqxd localaqxd1 = localaqxd2;
    if (localaqxd2 == null) {
      localaqxd1 = new aqxd();
    }
    return localaqxd1;
  }
  
  @NonNull
  public aqxd a()
  {
    return new aqxd();
  }
  
  @NonNull
  public aqxd a(@NonNull aqlg[] paramArrayOfaqlg)
  {
    aqxd localaqxd = new aqxd();
    paramArrayOfaqlg = paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramArrayOfaqlg)) {}
    for (;;)
    {
      return localaqxd;
      try
      {
        paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg);
        localaqxd.jdField_a_of_type_Int = paramArrayOfaqlg.optInt("stage");
        localaqxd.jdField_a_of_type_JavaLangString = paramArrayOfaqlg.optString("pay_url");
        if (QLog.isColorLevel())
        {
          QLog.d("vip_ptt.ConfigProcessor", 1, "json parse config.stage:" + localaqxd.jdField_a_of_type_Int + " url=" + localaqxd.jdField_a_of_type_JavaLangString);
          return localaqxd;
        }
      }
      catch (JSONException paramArrayOfaqlg)
      {
        QLog.e("vip_ptt.ConfigProcessor", 1, "json parse error:" + paramArrayOfaqlg);
        localaqxd.b = paramArrayOfaqlg.toString();
      }
    }
    return localaqxd;
  }
  
  @NonNull
  public aqxd b()
  {
    return new aqxd();
  }
  
  public Class<aqxd> clazz()
  {
    return aqxd.class;
  }
  
  public int type()
  {
    return 498;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqxe
 * JD-Core Version:    0.7.0.1
 */
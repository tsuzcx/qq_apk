import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqgp
  extends aqgc<aqgo>
{
  public static aqgo c()
  {
    aqgo localaqgo2 = (aqgo)apub.a().a(498);
    aqgo localaqgo1 = localaqgo2;
    if (localaqgo2 == null) {
      localaqgo1 = new aqgo();
    }
    return localaqgo1;
  }
  
  @NonNull
  public aqgo a()
  {
    return new aqgo();
  }
  
  @NonNull
  public aqgo a(@NonNull aptx[] paramArrayOfaptx)
  {
    aqgo localaqgo = new aqgo();
    paramArrayOfaptx = paramArrayOfaptx[0].jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramArrayOfaptx)) {}
    for (;;)
    {
      return localaqgo;
      try
      {
        paramArrayOfaptx = new JSONObject(paramArrayOfaptx);
        localaqgo.jdField_a_of_type_Int = paramArrayOfaptx.optInt("stage");
        localaqgo.jdField_a_of_type_JavaLangString = paramArrayOfaptx.optString("pay_url");
        if (QLog.isColorLevel())
        {
          QLog.d("vip_ptt.ConfigProcessor", 1, "json parse config.stage:" + localaqgo.jdField_a_of_type_Int + " url=" + localaqgo.jdField_a_of_type_JavaLangString);
          return localaqgo;
        }
      }
      catch (JSONException paramArrayOfaptx)
      {
        QLog.e("vip_ptt.ConfigProcessor", 1, "json parse error:" + paramArrayOfaptx);
        localaqgo.b = paramArrayOfaptx.toString();
      }
    }
    return localaqgo;
  }
  
  @NonNull
  public aqgo b()
  {
    return new aqgo();
  }
  
  public Class<aqgo> clazz()
  {
    return aqgo.class;
  }
  
  public int type()
  {
    return 498;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqgp
 * JD-Core Version:    0.7.0.1
 */
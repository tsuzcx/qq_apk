import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class aqbv
{
  public List<aqbx> a = new ArrayList();
  
  public static aqbv a(String paramString)
  {
    aqbv localaqbv = new aqbv();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("QRCodeList"))
      {
        paramString = paramString.optJSONArray("QRCodeList");
        Type localType = new aqbw().getClass().getGenericSuperclass();
        localaqbv.a.addAll(ausy.a(paramString, localType));
        if (localaqbv.a.size() > 0)
        {
          paramString = new aqbx();
          paramString.jdField_a_of_type_JavaLangString = "default_bg";
          paramString.c = 1;
          paramString.jdField_b_of_type_Int = 0;
          paramString.jdField_a_of_type_Int = 0;
          paramString.jdField_b_of_type_JavaLangString = "";
          localaqbv.a.add(paramString);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QrCodeDisplay.QrCodeConfBean", 2, "parse: " + localaqbv.a.size());
      }
      return localaqbv;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbv
 * JD-Core Version:    0.7.0.1
 */
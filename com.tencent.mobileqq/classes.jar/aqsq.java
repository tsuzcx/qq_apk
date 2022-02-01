import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class aqsq
{
  public List<aqss> a = new ArrayList();
  
  public static aqsq a(String paramString)
  {
    aqsq localaqsq = new aqsq();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("QRCodeList"))
      {
        paramString = paramString.optJSONArray("QRCodeList");
        Type localType = new aqsr().getClass().getGenericSuperclass();
        localaqsq.a.addAll(avnn.a(paramString, localType));
        if (localaqsq.a.size() > 0)
        {
          paramString = new aqss();
          paramString.jdField_a_of_type_JavaLangString = "default_bg";
          paramString.c = 1;
          paramString.jdField_b_of_type_Int = 0;
          paramString.jdField_a_of_type_Int = 0;
          paramString.jdField_b_of_type_JavaLangString = "";
          localaqsq.a.add(paramString);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QrCodeDisplay.QrCodeConfBean", 2, "parse: " + localaqsq.a.size());
      }
      return localaqsq;
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
 * Qualified Name:     aqsq
 * JD-Core Version:    0.7.0.1
 */
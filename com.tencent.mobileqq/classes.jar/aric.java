import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class aric
{
  public List<arie> a = new ArrayList();
  
  public static aric a(String paramString)
  {
    aric localaric = new aric();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("QRCodeList"))
      {
        paramString = paramString.optJSONArray("QRCodeList");
        Type localType = new arid().getClass().getGenericSuperclass();
        localaric.a.addAll(awfy.a(paramString, localType));
        if (localaric.a.size() > 0)
        {
          paramString = new arie();
          paramString.jdField_a_of_type_JavaLangString = "default_bg";
          paramString.c = 1;
          paramString.jdField_b_of_type_Int = 0;
          paramString.jdField_a_of_type_Int = 0;
          paramString.jdField_b_of_type_JavaLangString = "";
          localaric.a.add(paramString);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QrCodeDisplay.QrCodeConfBean", 2, "parse: " + localaric.a.size());
      }
      return localaric;
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
 * Qualified Name:     aric
 * JD-Core Version:    0.7.0.1
 */
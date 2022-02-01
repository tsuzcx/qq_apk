import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class arey
{
  public List<arfa> a = new ArrayList();
  
  public static arey a(String paramString)
  {
    arey localarey = new arey();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("QRCodeList"))
      {
        paramString = paramString.optJSONArray("QRCodeList");
        Type localType = new arez().getClass().getGenericSuperclass();
        localarey.a.addAll(avyx.a(paramString, localType));
        if (localarey.a.size() > 0)
        {
          paramString = new arfa();
          paramString.jdField_a_of_type_JavaLangString = "default_bg";
          paramString.c = 1;
          paramString.jdField_b_of_type_Int = 0;
          paramString.jdField_a_of_type_Int = 0;
          paramString.jdField_b_of_type_JavaLangString = "";
          localarey.a.add(paramString);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QrCodeDisplay.QrCodeConfBean", 2, "parse: " + localarey.a.size());
      }
      return localarey;
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
 * Qualified Name:     arey
 * JD-Core Version:    0.7.0.1
 */
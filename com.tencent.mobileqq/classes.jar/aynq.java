import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class aynq
{
  public static aynq a;
  public SparseArray<aynr> a;
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Aynq == null)
    {
      if (!aynt.a(paramQQAppInterface.getApplication(), "cardWZ.zip"))
      {
        aynt.a(paramQQAppInterface, null);
        return false;
      }
      return a(aynt.a(paramQQAppInterface.getApp()) + "xydata.json");
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VipWZRYTemplateConfig", 2, "configPath = " + paramString);
      }
      return false;
    }
    Object localObject = new File(paramString);
    try
    {
      localObject = FileUtils.readFileToString((File)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("VipWZRYTemplateConfig", 1, paramString + " content is empty.");
        return false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("VipWZRYTemplateConfig", 1, paramString.getMessage());
      return false;
    }
    paramString = new aynq();
    localObject = new JSONObject((String)localObject).optJSONArray("cardWZResourceGrade");
    int i;
    if ((localObject != null) && (((JSONArray)localObject).length() > 0))
    {
      paramString.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      i = 0;
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        if (localJSONObject != null)
        {
          aynr localaynr = new aynr();
          localaynr.jdField_a_of_type_Int = localJSONObject.optInt("wz_id");
          localaynr.jdField_a_of_type_JavaLangString = localJSONObject.optString("wz_name");
          localaynr.jdField_b_of_type_JavaLangString = localJSONObject.optString("wz_format");
          localaynr.jdField_b_of_type_Int = localJSONObject.optInt("position_type", 1);
          if (localJSONObject.has("wz_icon"))
          {
            ayns localayns = new ayns();
            localJSONObject = localJSONObject.getJSONObject("wz_icon");
            localayns.jdField_a_of_type_JavaLangString = localJSONObject.optString("src");
            localayns.jdField_a_of_type_Int = localJSONObject.optInt("size");
            localayns.jdField_b_of_type_JavaLangString = localJSONObject.optString("md5");
            localayns.jdField_b_of_type_Int = localJSONObject.optInt("width");
            localayns.jdField_c_of_type_Int = localJSONObject.optInt("height");
            localayns.jdField_c_of_type_JavaLangString = localJSONObject.optString("mainColor");
            localaynr.jdField_a_of_type_Ayns = localayns;
          }
          paramString.jdField_a_of_type_AndroidUtilSparseArray.put(localaynr.jdField_a_of_type_Int, localaynr);
        }
      }
      else
      {
        jdField_a_of_type_Aynq = paramString;
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynq
 * JD-Core Version:    0.7.0.1
 */
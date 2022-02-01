import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class azsl
{
  public static azsl a;
  public SparseArray<azsm> a;
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Azsl == null)
    {
      if (!azso.a(paramQQAppInterface.getApplication(), "cardWZ.zip"))
      {
        azso.a(paramQQAppInterface, null);
        return false;
      }
      return a(azso.a(paramQQAppInterface.getApp()) + "xydata.json");
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
    paramString = new azsl();
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
          azsm localazsm = new azsm();
          localazsm.jdField_a_of_type_Int = localJSONObject.optInt("wz_id");
          localazsm.jdField_a_of_type_JavaLangString = localJSONObject.optString("wz_name");
          localazsm.jdField_b_of_type_JavaLangString = localJSONObject.optString("wz_format");
          localazsm.jdField_b_of_type_Int = localJSONObject.optInt("position_type", 1);
          if (localJSONObject.has("wz_icon"))
          {
            azsn localazsn = new azsn();
            localJSONObject = localJSONObject.getJSONObject("wz_icon");
            localazsn.jdField_a_of_type_JavaLangString = localJSONObject.optString("src");
            localazsn.jdField_a_of_type_Int = localJSONObject.optInt("size");
            localazsn.jdField_b_of_type_JavaLangString = localJSONObject.optString("md5");
            localazsn.jdField_b_of_type_Int = localJSONObject.optInt("width");
            localazsn.jdField_c_of_type_Int = localJSONObject.optInt("height");
            localazsn.jdField_c_of_type_JavaLangString = localJSONObject.optString("mainColor");
            localazsm.jdField_a_of_type_Azsn = localazsn;
          }
          paramString.jdField_a_of_type_AndroidUtilSparseArray.put(localazsm.jdField_a_of_type_Int, localazsm);
        }
      }
      else
      {
        jdField_a_of_type_Azsl = paramString;
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azsl
 * JD-Core Version:    0.7.0.1
 */
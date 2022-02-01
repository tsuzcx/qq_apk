import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class azgp
{
  public static azgp a;
  public SparseArray<azgq> a;
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Azgp == null)
    {
      if (!azgs.a(paramQQAppInterface.getApplication(), "cardWZ.zip"))
      {
        azgs.a(paramQQAppInterface, null);
        return false;
      }
      return a(azgs.a(paramQQAppInterface.getApp()) + "xydata.json");
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
      localObject = bgmg.b((File)localObject);
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
    paramString = new azgp();
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
          azgq localazgq = new azgq();
          localazgq.jdField_a_of_type_Int = localJSONObject.optInt("wz_id");
          localazgq.jdField_a_of_type_JavaLangString = localJSONObject.optString("wz_name");
          localazgq.jdField_b_of_type_JavaLangString = localJSONObject.optString("wz_format");
          localazgq.jdField_b_of_type_Int = localJSONObject.optInt("position_type", 1);
          if (localJSONObject.has("wz_icon"))
          {
            azgr localazgr = new azgr();
            localJSONObject = localJSONObject.getJSONObject("wz_icon");
            localazgr.jdField_a_of_type_JavaLangString = localJSONObject.optString("src");
            localazgr.jdField_a_of_type_Int = localJSONObject.optInt("size");
            localazgr.jdField_b_of_type_JavaLangString = localJSONObject.optString("md5");
            localazgr.jdField_b_of_type_Int = localJSONObject.optInt("width");
            localazgr.jdField_c_of_type_Int = localJSONObject.optInt("height");
            localazgr.jdField_c_of_type_JavaLangString = localJSONObject.optString("mainColor");
            localazgq.jdField_a_of_type_Azgr = localazgr;
          }
          paramString.jdField_a_of_type_AndroidUtilSparseArray.put(localazgq.jdField_a_of_type_Int, localazgq);
        }
      }
      else
      {
        jdField_a_of_type_Azgp = paramString;
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgp
 * JD-Core Version:    0.7.0.1
 */
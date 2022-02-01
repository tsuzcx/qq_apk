import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class azzb
{
  public static azzb a;
  public SparseArray<azzc> a;
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Azzb == null)
    {
      if (!azze.a(paramQQAppInterface.getApplication(), "cardWZ.zip"))
      {
        azze.a(paramQQAppInterface, null);
        return false;
      }
      return a(azze.a(paramQQAppInterface.getApp()) + "xydata.json");
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
      localObject = bhmi.b((File)localObject);
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
    paramString = new azzb();
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
          azzc localazzc = new azzc();
          localazzc.jdField_a_of_type_Int = localJSONObject.optInt("wz_id");
          localazzc.jdField_a_of_type_JavaLangString = localJSONObject.optString("wz_name");
          localazzc.jdField_b_of_type_JavaLangString = localJSONObject.optString("wz_format");
          localazzc.jdField_b_of_type_Int = localJSONObject.optInt("position_type", 1);
          if (localJSONObject.has("wz_icon"))
          {
            azzd localazzd = new azzd();
            localJSONObject = localJSONObject.getJSONObject("wz_icon");
            localazzd.jdField_a_of_type_JavaLangString = localJSONObject.optString("src");
            localazzd.jdField_a_of_type_Int = localJSONObject.optInt("size");
            localazzd.jdField_b_of_type_JavaLangString = localJSONObject.optString("md5");
            localazzd.jdField_b_of_type_Int = localJSONObject.optInt("width");
            localazzd.jdField_c_of_type_Int = localJSONObject.optInt("height");
            localazzd.jdField_c_of_type_JavaLangString = localJSONObject.optString("mainColor");
            localazzc.jdField_a_of_type_Azzd = localazzd;
          }
          paramString.jdField_a_of_type_AndroidUtilSparseArray.put(localazzc.jdField_a_of_type_Int, localazzc);
        }
      }
      else
      {
        jdField_a_of_type_Azzb = paramString;
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzb
 * JD-Core Version:    0.7.0.1
 */
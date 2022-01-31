import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class atyl
{
  public static atyl a;
  public SparseArray<atym> a;
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Atyl == null) {
      return a(atyo.a(paramQQAppInterface.getApp()) + "xydata.json");
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
      localObject = bace.b((File)localObject);
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
    paramString = new atyl();
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
          atym localatym = new atym();
          localatym.jdField_a_of_type_Int = localJSONObject.optInt("wz_id");
          localatym.jdField_a_of_type_JavaLangString = localJSONObject.optString("wz_name");
          localatym.jdField_b_of_type_JavaLangString = localJSONObject.optString("wz_format");
          localatym.jdField_b_of_type_Int = localJSONObject.optInt("position_type", 1);
          if (localJSONObject.has("wz_icon"))
          {
            atyn localatyn = new atyn();
            localJSONObject = localJSONObject.getJSONObject("wz_icon");
            localatyn.jdField_a_of_type_JavaLangString = localJSONObject.optString("src");
            localatyn.jdField_a_of_type_Int = localJSONObject.optInt("size");
            localatyn.jdField_b_of_type_JavaLangString = localJSONObject.optString("md5");
            localatyn.jdField_b_of_type_Int = localJSONObject.optInt("width");
            localatyn.jdField_c_of_type_Int = localJSONObject.optInt("height");
            localatyn.jdField_c_of_type_JavaLangString = localJSONObject.optString("mainColor");
            localatym.jdField_a_of_type_Atyn = localatyn;
          }
          paramString.jdField_a_of_type_AndroidUtilSparseArray.put(localatym.jdField_a_of_type_Int, localatym);
        }
      }
      else
      {
        jdField_a_of_type_Atyl = paramString;
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyl
 * JD-Core Version:    0.7.0.1
 */
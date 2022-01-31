import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class auwm
{
  public static auwm a;
  public SparseArray<auwn> a;
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Auwm == null) {
      return a(auwp.a(paramQQAppInterface.getApp()) + "xydata.json");
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
      localObject = bbdx.b((File)localObject);
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
    paramString = new auwm();
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
          auwn localauwn = new auwn();
          localauwn.jdField_a_of_type_Int = localJSONObject.optInt("wz_id");
          localauwn.jdField_a_of_type_JavaLangString = localJSONObject.optString("wz_name");
          localauwn.jdField_b_of_type_JavaLangString = localJSONObject.optString("wz_format");
          localauwn.jdField_b_of_type_Int = localJSONObject.optInt("position_type", 1);
          if (localJSONObject.has("wz_icon"))
          {
            auwo localauwo = new auwo();
            localJSONObject = localJSONObject.getJSONObject("wz_icon");
            localauwo.jdField_a_of_type_JavaLangString = localJSONObject.optString("src");
            localauwo.jdField_a_of_type_Int = localJSONObject.optInt("size");
            localauwo.jdField_b_of_type_JavaLangString = localJSONObject.optString("md5");
            localauwo.jdField_b_of_type_Int = localJSONObject.optInt("width");
            localauwo.jdField_c_of_type_Int = localJSONObject.optInt("height");
            localauwo.jdField_c_of_type_JavaLangString = localJSONObject.optString("mainColor");
            localauwn.jdField_a_of_type_Auwo = localauwo;
          }
          paramString.jdField_a_of_type_AndroidUtilSparseArray.put(localauwn.jdField_a_of_type_Int, localauwn);
        }
      }
      else
      {
        jdField_a_of_type_Auwm = paramString;
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwm
 * JD-Core Version:    0.7.0.1
 */
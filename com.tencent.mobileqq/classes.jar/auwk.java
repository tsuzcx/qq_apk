import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class auwk
{
  public static auwk a;
  public SparseArray<auwl> a;
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Auwk == null) {
      return a(auwn.a(paramQQAppInterface.getApp()) + "xydata.json");
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
      localObject = bbdj.b((File)localObject);
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
    paramString = new auwk();
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
          auwl localauwl = new auwl();
          localauwl.jdField_a_of_type_Int = localJSONObject.optInt("wz_id");
          localauwl.jdField_a_of_type_JavaLangString = localJSONObject.optString("wz_name");
          localauwl.jdField_b_of_type_JavaLangString = localJSONObject.optString("wz_format");
          localauwl.jdField_b_of_type_Int = localJSONObject.optInt("position_type", 1);
          if (localJSONObject.has("wz_icon"))
          {
            auwm localauwm = new auwm();
            localJSONObject = localJSONObject.getJSONObject("wz_icon");
            localauwm.jdField_a_of_type_JavaLangString = localJSONObject.optString("src");
            localauwm.jdField_a_of_type_Int = localJSONObject.optInt("size");
            localauwm.jdField_b_of_type_JavaLangString = localJSONObject.optString("md5");
            localauwm.jdField_b_of_type_Int = localJSONObject.optInt("width");
            localauwm.jdField_c_of_type_Int = localJSONObject.optInt("height");
            localauwm.jdField_c_of_type_JavaLangString = localJSONObject.optString("mainColor");
            localauwl.jdField_a_of_type_Auwm = localauwm;
          }
          paramString.jdField_a_of_type_AndroidUtilSparseArray.put(localauwl.jdField_a_of_type_Int, localauwl);
        }
      }
      else
      {
        jdField_a_of_type_Auwk = paramString;
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwk
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class awny
{
  public static awny a;
  public SparseArray<awnz> a;
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Awny == null) {
      return a(awob.a(paramQQAppInterface.getApp()) + "xydata.json");
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
      localObject = bdcs.b((File)localObject);
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
    paramString = new awny();
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
          awnz localawnz = new awnz();
          localawnz.jdField_a_of_type_Int = localJSONObject.optInt("wz_id");
          localawnz.jdField_a_of_type_JavaLangString = localJSONObject.optString("wz_name");
          localawnz.jdField_b_of_type_JavaLangString = localJSONObject.optString("wz_format");
          localawnz.jdField_b_of_type_Int = localJSONObject.optInt("position_type", 1);
          if (localJSONObject.has("wz_icon"))
          {
            awoa localawoa = new awoa();
            localJSONObject = localJSONObject.getJSONObject("wz_icon");
            localawoa.jdField_a_of_type_JavaLangString = localJSONObject.optString("src");
            localawoa.jdField_a_of_type_Int = localJSONObject.optInt("size");
            localawoa.jdField_b_of_type_JavaLangString = localJSONObject.optString("md5");
            localawoa.jdField_b_of_type_Int = localJSONObject.optInt("width");
            localawoa.jdField_c_of_type_Int = localJSONObject.optInt("height");
            localawoa.jdField_c_of_type_JavaLangString = localJSONObject.optString("mainColor");
            localawnz.jdField_a_of_type_Awoa = localawoa;
          }
          paramString.jdField_a_of_type_AndroidUtilSparseArray.put(localawnz.jdField_a_of_type_Int, localawnz);
        }
      }
      else
      {
        jdField_a_of_type_Awny = paramString;
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awny
 * JD-Core Version:    0.7.0.1
 */
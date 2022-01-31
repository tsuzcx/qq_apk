import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class awsh
{
  public static awsh a;
  public SparseArray<awsi> a;
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Awsh == null) {
      return a(awsk.a(paramQQAppInterface.getApp()) + "xydata.json");
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
      localObject = bdhb.b((File)localObject);
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
    paramString = new awsh();
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
          awsi localawsi = new awsi();
          localawsi.jdField_a_of_type_Int = localJSONObject.optInt("wz_id");
          localawsi.jdField_a_of_type_JavaLangString = localJSONObject.optString("wz_name");
          localawsi.jdField_b_of_type_JavaLangString = localJSONObject.optString("wz_format");
          localawsi.jdField_b_of_type_Int = localJSONObject.optInt("position_type", 1);
          if (localJSONObject.has("wz_icon"))
          {
            awsj localawsj = new awsj();
            localJSONObject = localJSONObject.getJSONObject("wz_icon");
            localawsj.jdField_a_of_type_JavaLangString = localJSONObject.optString("src");
            localawsj.jdField_a_of_type_Int = localJSONObject.optInt("size");
            localawsj.jdField_b_of_type_JavaLangString = localJSONObject.optString("md5");
            localawsj.jdField_b_of_type_Int = localJSONObject.optInt("width");
            localawsj.jdField_c_of_type_Int = localJSONObject.optInt("height");
            localawsj.jdField_c_of_type_JavaLangString = localJSONObject.optString("mainColor");
            localawsi.jdField_a_of_type_Awsj = localawsj;
          }
          paramString.jdField_a_of_type_AndroidUtilSparseArray.put(localawsi.jdField_a_of_type_Int, localawsi);
        }
      }
      else
      {
        jdField_a_of_type_Awsh = paramString;
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awsh
 * JD-Core Version:    0.7.0.1
 */
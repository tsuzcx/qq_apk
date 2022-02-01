import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class avef
{
  public static avef a;
  private Set<String> a;
  
  static
  {
    jdField_a_of_type_Avef = new avef();
  }
  
  public avef()
  {
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  static avef a(String paramString)
  {
    localavef = new avef();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("appid_arr");
        int i = 0;
        while (i < paramString.length())
        {
          String str = paramString.optString(i);
          if (!TextUtils.isEmpty(str)) {
            localavef.jdField_a_of_type_JavaUtilSet.add(str);
          }
          i += 1;
        }
        return localavef;
      }
      catch (Throwable paramString)
      {
        QLog.e("GameShare.confBean", 1, paramString, new Object[0]);
      }
    }
  }
  
  boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public String toString()
  {
    return "NGConfBean{appidArr=" + this.jdField_a_of_type_JavaUtilSet + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avef
 * JD-Core Version:    0.7.0.1
 */
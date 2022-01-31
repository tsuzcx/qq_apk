import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class aosf
{
  public int a;
  public String a;
  public ArrayList<aosg> a;
  
  public aosf()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static aosf a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    aosf localaosf = new aosf();
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONArray("match");
        if (paramString == null) {
          break;
        }
        localaosf.jdField_a_of_type_Int = localJSONObject.optInt("switch");
        localaosf.jdField_a_of_type_JavaLangString = localJSONObject.optString("blackList");
        if (localaosf.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localaosf.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          a(localaosf);
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null) {
              break label235;
            }
            aosg localaosg = new aosg();
            localaosg.jdField_a_of_type_JavaLangString = localJSONObject.optString("key");
            localaosg.b = localJSONObject.optString("resUrl");
            localaosg.c = localJSONObject.optString("md5");
            localaosf.jdField_a_of_type_JavaUtilArrayList.add(localaosg);
            break label235;
          }
        }
        else
        {
          localaosf.jdField_a_of_type_JavaUtilArrayList.clear();
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label233;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VipARConfBean", 1, "parse content exception = " + paramString.getMessage());
        paramString.printStackTrace();
        return null;
      }
      QLog.i("VipARConfBean", 2, " parseSuccess data = " + localaosf.toString());
      label233:
      return localaosf;
      label235:
      i += 1;
    }
  }
  
  private static void a(aosf paramaosf)
  {
    if ((paramaosf == null) || (TextUtils.isEmpty(paramaosf.jdField_a_of_type_JavaLangString))) {
      QLog.i("VipARConfBean", 1, "checkIsInBlackList return empty");
    }
    if (bkey.a(paramaosf.jdField_a_of_type_JavaLangString)) {
      paramaosf.jdField_a_of_type_Int = 0;
    }
  }
  
  @NonNull
  public String toString()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(" switch = " + this.jdField_a_of_type_Int);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        aosg localaosg = (aosg)localIterator.next();
        if (localaosg != null) {
          localStringBuilder.append("\n " + localaosg.toString());
        }
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
        localStringBuilder.append(" config list = null");
      }
      return localStringBuilder.toString();
    }
    return " switch = " + this.jdField_a_of_type_Int + " list = null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aosf
 * JD-Core Version:    0.7.0.1
 */
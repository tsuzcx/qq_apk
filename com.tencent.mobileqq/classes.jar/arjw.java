import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class arjw
{
  public int a;
  public String a;
  public ArrayList<arjx> a;
  
  public arjw()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static arjw a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    arjw localarjw = new arjw();
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
        localarjw.jdField_a_of_type_Int = localJSONObject.optInt("switch");
        localarjw.jdField_a_of_type_JavaLangString = localJSONObject.optString("blackList");
        if (localarjw.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localarjw.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          a(localarjw);
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null) {
              break label235;
            }
            arjx localarjx = new arjx();
            localarjx.jdField_a_of_type_JavaLangString = localJSONObject.optString("key");
            localarjx.b = localJSONObject.optString("resUrl");
            localarjx.c = localJSONObject.optString("md5");
            localarjw.jdField_a_of_type_JavaUtilArrayList.add(localarjx);
            break label235;
          }
        }
        else
        {
          localarjw.jdField_a_of_type_JavaUtilArrayList.clear();
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
      QLog.i("VipARConfBean", 2, " parseSuccess data = " + localarjw.toString());
      label233:
      return localarjw;
      label235:
      i += 1;
    }
  }
  
  private static void a(arjw paramarjw)
  {
    if ((paramarjw == null) || (TextUtils.isEmpty(paramarjw.jdField_a_of_type_JavaLangString))) {
      QLog.i("VipARConfBean", 1, "checkIsInBlackList return empty");
    }
    if (bnuq.a(paramarjw.jdField_a_of_type_JavaLangString)) {
      paramarjw.jdField_a_of_type_Int = 0;
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
        arjx localarjx = (arjx)localIterator.next();
        if (localarjx != null) {
          localStringBuilder.append("\n " + localarjx.toString());
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
 * Qualified Name:     arjw
 * JD-Core Version:    0.7.0.1
 */
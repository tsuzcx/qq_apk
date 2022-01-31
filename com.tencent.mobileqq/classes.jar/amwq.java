import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class amwq
{
  public int a;
  public String a;
  public ArrayList<amwr> a;
  
  public amwq()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static amwq a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    amwq localamwq = new amwq();
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
        localamwq.jdField_a_of_type_Int = localJSONObject.optInt("switch");
        localamwq.jdField_a_of_type_JavaLangString = localJSONObject.optString("blackList");
        if (localamwq.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localamwq.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          a(localamwq);
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null) {
              break label235;
            }
            amwr localamwr = new amwr();
            localamwr.jdField_a_of_type_JavaLangString = localJSONObject.optString("key");
            localamwr.b = localJSONObject.optString("resUrl");
            localamwr.c = localJSONObject.optString("md5");
            localamwq.jdField_a_of_type_JavaUtilArrayList.add(localamwr);
            break label235;
          }
        }
        else
        {
          localamwq.jdField_a_of_type_JavaUtilArrayList.clear();
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
      QLog.i("VipARConfBean", 2, " parseSuccess data = " + localamwq.toString());
      label233:
      return localamwq;
      label235:
      i += 1;
    }
  }
  
  private static void a(amwq paramamwq)
  {
    if ((paramamwq == null) || (TextUtils.isEmpty(paramamwq.jdField_a_of_type_JavaLangString))) {
      QLog.i("VipARConfBean", 1, "checkIsInBlackList return empty");
    }
    if (bhye.a(paramamwq.jdField_a_of_type_JavaLangString)) {
      paramamwq.jdField_a_of_type_Int = 0;
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
        amwr localamwr = (amwr)localIterator.next();
        if (localamwr != null) {
          localStringBuilder.append("\n " + localamwr.toString());
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
 * Qualified Name:     amwq
 * JD-Core Version:    0.7.0.1
 */
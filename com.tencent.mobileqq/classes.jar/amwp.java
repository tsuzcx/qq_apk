import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class amwp
{
  public int a;
  public String a;
  public ArrayList<amwq> a;
  
  public amwp()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static amwp a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    amwp localamwp = new amwp();
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
        localamwp.jdField_a_of_type_Int = localJSONObject.optInt("switch");
        localamwp.jdField_a_of_type_JavaLangString = localJSONObject.optString("blackList");
        if (localamwp.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localamwp.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          a(localamwp);
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null) {
              break label235;
            }
            amwq localamwq = new amwq();
            localamwq.jdField_a_of_type_JavaLangString = localJSONObject.optString("key");
            localamwq.b = localJSONObject.optString("resUrl");
            localamwq.c = localJSONObject.optString("md5");
            localamwp.jdField_a_of_type_JavaUtilArrayList.add(localamwq);
            break label235;
          }
        }
        else
        {
          localamwp.jdField_a_of_type_JavaUtilArrayList.clear();
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
      QLog.i("VipARConfBean", 2, " parseSuccess data = " + localamwp.toString());
      label233:
      return localamwp;
      label235:
      i += 1;
    }
  }
  
  private static void a(amwp paramamwp)
  {
    if ((paramamwp == null) || (TextUtils.isEmpty(paramamwp.jdField_a_of_type_JavaLangString))) {
      QLog.i("VipARConfBean", 1, "checkIsInBlackList return empty");
    }
    if (bhyv.a(paramamwp.jdField_a_of_type_JavaLangString)) {
      paramamwp.jdField_a_of_type_Int = 0;
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
        amwq localamwq = (amwq)localIterator.next();
        if (localamwq != null) {
          localStringBuilder.append("\n " + localamwq.toString());
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
 * Qualified Name:     amwp
 * JD-Core Version:    0.7.0.1
 */
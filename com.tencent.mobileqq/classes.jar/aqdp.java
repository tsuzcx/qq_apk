import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqdp
{
  public int a;
  public String a;
  public ArrayList<aqdq> a;
  
  public aqdp()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static aqdp a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    aqdp localaqdp = new aqdp();
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
        localaqdp.jdField_a_of_type_Int = localJSONObject.optInt("switch");
        localaqdp.jdField_a_of_type_JavaLangString = localJSONObject.optString("blackList");
        if (localaqdp.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localaqdp.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          a(localaqdp);
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null) {
              break label235;
            }
            aqdq localaqdq = new aqdq();
            localaqdq.jdField_a_of_type_JavaLangString = localJSONObject.optString("key");
            localaqdq.b = localJSONObject.optString("resUrl");
            localaqdq.c = localJSONObject.optString("md5");
            localaqdp.jdField_a_of_type_JavaUtilArrayList.add(localaqdq);
            break label235;
          }
        }
        else
        {
          localaqdp.jdField_a_of_type_JavaUtilArrayList.clear();
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
      QLog.i("VipARConfBean", 2, " parseSuccess data = " + localaqdp.toString());
      label233:
      return localaqdp;
      label235:
      i += 1;
    }
  }
  
  private static void a(aqdp paramaqdp)
  {
    if ((paramaqdp == null) || (TextUtils.isEmpty(paramaqdp.jdField_a_of_type_JavaLangString))) {
      QLog.i("VipARConfBean", 1, "checkIsInBlackList return empty");
    }
    while (!bkzx.a(paramaqdp.jdField_a_of_type_JavaLangString)) {
      return;
    }
    paramaqdp.jdField_a_of_type_Int = 0;
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
        aqdq localaqdq = (aqdq)localIterator.next();
        if (localaqdq != null) {
          localStringBuilder.append("\n " + localaqdq.toString());
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
 * Qualified Name:     aqdp
 * JD-Core Version:    0.7.0.1
 */
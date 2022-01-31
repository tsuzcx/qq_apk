import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class aonw
{
  public int a;
  public String a;
  public ArrayList<aonx> a;
  
  public aonw()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static aonw a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    aonw localaonw = new aonw();
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
        localaonw.jdField_a_of_type_Int = localJSONObject.optInt("switch");
        localaonw.jdField_a_of_type_JavaLangString = localJSONObject.optString("blackList");
        if (localaonw.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localaonw.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          a(localaonw);
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null) {
              break label235;
            }
            aonx localaonx = new aonx();
            localaonx.jdField_a_of_type_JavaLangString = localJSONObject.optString("key");
            localaonx.b = localJSONObject.optString("resUrl");
            localaonx.c = localJSONObject.optString("md5");
            localaonw.jdField_a_of_type_JavaUtilArrayList.add(localaonx);
            break label235;
          }
        }
        else
        {
          localaonw.jdField_a_of_type_JavaUtilArrayList.clear();
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
      QLog.i("VipARConfBean", 2, " parseSuccess data = " + localaonw.toString());
      label233:
      return localaonw;
      label235:
      i += 1;
    }
  }
  
  private static void a(aonw paramaonw)
  {
    if ((paramaonw == null) || (TextUtils.isEmpty(paramaonw.jdField_a_of_type_JavaLangString))) {
      QLog.i("VipARConfBean", 1, "checkIsInBlackList return empty");
    }
    if (bkar.a(paramaonw.jdField_a_of_type_JavaLangString)) {
      paramaonw.jdField_a_of_type_Int = 0;
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
        aonx localaonx = (aonx)localIterator.next();
        if (localaonx != null) {
          localStringBuilder.append("\n " + localaonx.toString());
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
 * Qualified Name:     aonw
 * JD-Core Version:    0.7.0.1
 */
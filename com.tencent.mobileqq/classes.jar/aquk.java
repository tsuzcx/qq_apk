import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class aquk
{
  public int a;
  public String a;
  public ArrayList<aqul> a;
  
  public aquk()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static aquk a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    aquk localaquk = new aquk();
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
        localaquk.jdField_a_of_type_Int = localJSONObject.optInt("switch");
        localaquk.jdField_a_of_type_JavaLangString = localJSONObject.optString("blackList");
        if (localaquk.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localaquk.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          a(localaquk);
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null) {
              break label235;
            }
            aqul localaqul = new aqul();
            localaqul.jdField_a_of_type_JavaLangString = localJSONObject.optString("key");
            localaqul.b = localJSONObject.optString("resUrl");
            localaqul.c = localJSONObject.optString("md5");
            localaquk.jdField_a_of_type_JavaUtilArrayList.add(localaqul);
            break label235;
          }
        }
        else
        {
          localaquk.jdField_a_of_type_JavaUtilArrayList.clear();
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
      QLog.i("VipARConfBean", 2, " parseSuccess data = " + localaquk.toString());
      label233:
      return localaquk;
      label235:
      i += 1;
    }
  }
  
  private static void a(aquk paramaquk)
  {
    if ((paramaquk == null) || (TextUtils.isEmpty(paramaquk.jdField_a_of_type_JavaLangString))) {
      QLog.i("VipARConfBean", 1, "checkIsInBlackList return empty");
    }
    if (bmti.a(paramaquk.jdField_a_of_type_JavaLangString)) {
      paramaquk.jdField_a_of_type_Int = 0;
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
        aqul localaqul = (aqul)localIterator.next();
        if (localaqul != null) {
          localStringBuilder.append("\n " + localaqul.toString());
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
 * Qualified Name:     aquk
 * JD-Core Version:    0.7.0.1
 */
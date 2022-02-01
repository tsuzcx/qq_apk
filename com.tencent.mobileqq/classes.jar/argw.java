import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class argw
{
  public int a;
  public String a;
  public ArrayList<argx> a;
  
  public argw()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static argw a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    argw localargw = new argw();
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
        localargw.jdField_a_of_type_Int = localJSONObject.optInt("switch");
        localargw.jdField_a_of_type_JavaLangString = localJSONObject.optString("blackList");
        if (localargw.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localargw.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          a(localargw);
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null) {
              break label235;
            }
            argx localargx = new argx();
            localargx.jdField_a_of_type_JavaLangString = localJSONObject.optString("key");
            localargx.b = localJSONObject.optString("resUrl");
            localargx.c = localJSONObject.optString("md5");
            localargw.jdField_a_of_type_JavaUtilArrayList.add(localargx);
            break label235;
          }
        }
        else
        {
          localargw.jdField_a_of_type_JavaUtilArrayList.clear();
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
      QLog.i("VipARConfBean", 2, " parseSuccess data = " + localargw.toString());
      label233:
      return localargw;
      label235:
      i += 1;
    }
  }
  
  private static void a(argw paramargw)
  {
    if ((paramargw == null) || (TextUtils.isEmpty(paramargw.jdField_a_of_type_JavaLangString))) {
      QLog.i("VipARConfBean", 1, "checkIsInBlackList return empty");
    }
    while (!bmmb.a(paramargw.jdField_a_of_type_JavaLangString)) {
      return;
    }
    paramargw.jdField_a_of_type_Int = 0;
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
        argx localargx = (argx)localIterator.next();
        if (localargx != null) {
          localStringBuilder.append("\n " + localargx.toString());
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
 * Qualified Name:     argw
 * JD-Core Version:    0.7.0.1
 */
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class amgm
{
  public int a;
  public String a;
  public ArrayList<amgn> a;
  
  public amgm()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static amgm a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    amgm localamgm = new amgm();
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
        localamgm.jdField_a_of_type_Int = localJSONObject.optInt("switch");
        localamgm.jdField_a_of_type_JavaLangString = localJSONObject.optString("blackList");
        if (localamgm.jdField_a_of_type_JavaUtilArrayList == null)
        {
          localamgm.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          a(localamgm);
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject == null) {
              break label235;
            }
            amgn localamgn = new amgn();
            localamgn.jdField_a_of_type_JavaLangString = localJSONObject.optString("key");
            localamgn.b = localJSONObject.optString("resUrl");
            localamgn.c = localJSONObject.optString("md5");
            localamgm.jdField_a_of_type_JavaUtilArrayList.add(localamgn);
            break label235;
          }
        }
        else
        {
          localamgm.jdField_a_of_type_JavaUtilArrayList.clear();
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
      QLog.i("VipARConfBean", 2, " parseSuccess data = " + localamgm.toString());
      label233:
      return localamgm;
      label235:
      i += 1;
    }
  }
  
  private static void a(amgm paramamgm)
  {
    if ((paramamgm == null) || (TextUtils.isEmpty(paramamgm.jdField_a_of_type_JavaLangString))) {
      QLog.i("VipARConfBean", 1, "checkIsInBlackList return empty");
    }
    if (bgph.a(paramamgm.jdField_a_of_type_JavaLangString)) {
      paramamgm.jdField_a_of_type_Int = 0;
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
        amgn localamgn = (amgn)localIterator.next();
        if (localamgn != null) {
          localStringBuilder.append("\n " + localamgn.toString());
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
 * Qualified Name:     amgm
 * JD-Core Version:    0.7.0.1
 */
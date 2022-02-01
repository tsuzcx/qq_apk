import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class bcus
{
  int jdField_a_of_type_Int;
  public String a;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  int b;
  public int c;
  public int d;
  
  public void a()
  {
    JSONArray localJSONArray;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("reportId", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("switch_qzone", this.jdField_a_of_type_Int);
        localJSONObject.put("switch_qq", this.b);
        localJSONObject.put("report_count", this.c);
        localJSONObject.put("report_time", this.d);
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localJSONArray = new JSONArray();
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (!TextUtils.isEmpty(str))
            {
              localJSONArray.put(str);
              continue;
              return;
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("UndealCount.QZoneUnreadServletLogic", 1, localException, new Object[0]);
      }
    }
    do
    {
      do
      {
        localException.put("blacks", localJSONArray);
        LocalMultiProcConfig.putString4Uin("qzone_wmd_config", localException.toString(), BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      } while (!QLog.isColorLevel());
      QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "save wmd config:" + localException.toString());
      return;
      LocalMultiProcConfig.putString4Uin("qzone_wmd_config", "", BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    } while (!QLog.isColorLevel());
    QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "save wmd config:null");
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      Object localObject = LocalMultiProcConfig.getString4Uin("qzone_wmd_config", "", BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "load wmd config:" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("reportId");
        this.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("switch_qzone");
        this.b = ((JSONObject)localObject).optInt("switch_qq");
        this.c = ((JSONObject)localObject).optInt("report_count");
        this.d = ((JSONObject)localObject).optInt("report_time");
        localObject = ((JSONObject)localObject).optJSONArray("blacks");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            if (!TextUtils.isEmpty(((JSONArray)localObject).optString(i))) {
              this.jdField_a_of_type_JavaUtilArrayList.add(((JSONArray)localObject).optString(i));
            }
            i += 1;
          }
        }
        bool = true;
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcus
 * JD-Core Version:    0.7.0.1
 */
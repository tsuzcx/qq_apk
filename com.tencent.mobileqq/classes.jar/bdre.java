import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class bdre
{
  private static bdre jdField_a_of_type_Bdre;
  private final String jdField_a_of_type_JavaLangString = "VipLongMsgShareDomainHelper";
  private List<String> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private List<String> b = new CopyOnWriteArrayList();
  
  public bdre()
  {
    this.jdField_a_of_type_JavaUtilList.add("vip.qq.com");
  }
  
  public static bdre a()
  {
    if (jdField_a_of_type_Bdre == null) {}
    try
    {
      if (jdField_a_of_type_Bdre == null) {
        jdField_a_of_type_Bdre = new bdre();
      }
      return jdField_a_of_type_Bdre;
    }
    finally {}
  }
  
  public void a(JSONArray paramJSONArray)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipLongMsgShareDomainHelper", 2, "setConfigData data = " + paramJSONArray);
    }
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i >= paramJSONArray.length()) {
          return;
        }
        try
        {
          Object localObject = paramJSONArray.getJSONObject(i);
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optString("domain", "");
            this.b.add(localObject);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("VipLongMsgShareDomainHelper", 1, "setConfigData exception ", localException);
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject2 = this.b;
    Object localObject1 = localObject2;
    if (((List)localObject2).isEmpty()) {
      localObject1 = this.jdField_a_of_type_JavaUtilList;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (paramString.endsWith((String)localObject2))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdre
 * JD-Core Version:    0.7.0.1
 */
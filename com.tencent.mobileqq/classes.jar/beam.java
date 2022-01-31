import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.FilterManager.1;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class beam
  implements beay
{
  private static volatile beam jdField_a_of_type_Beam;
  private static String jdField_a_of_type_JavaLangString = "qp_fm_config";
  private static String b = "_last_time";
  private Map<String, beal> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private long a(String paramString, long paramLong)
  {
    long l = -1L;
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(paramString + b, paramLong);
    }
    return l;
  }
  
  public static beam a()
  {
    if (jdField_a_of_type_Beam == null) {}
    try
    {
      if (jdField_a_of_type_Beam == null) {
        jdField_a_of_type_Beam = new beam();
      }
      return jdField_a_of_type_Beam;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = new beat(paramString);
    bdzw.a().cloudDetect(paramString, true, false, null);
  }
  
  private boolean a(String paramString, long paramLong)
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().putLong(paramString + b, paramLong).commit();
      bool = true;
    }
    return bool;
  }
  
  public beal a(String paramString)
  {
    return (beal)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public beax a(String paramString)
  {
    beaz localbeaz = null;
    if (paramString.equalsIgnoreCase("App")) {
      localbeaz = new beaz(this);
    }
    return localbeaz;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      long l1 = a((String)localObject, -1L);
      if (l1 != -1L)
      {
        long l2 = new Date().getTime();
        beal localbeal = a((String)localObject);
        if ((localbeal != null) && (l2 - l1 < localbeal.a() * 1000L))
        {
          QLog.d("QSFM", 1, String.format("scan not start: %s:%d-%d=%d:%d", new Object[] { localObject, Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l2 - l1), Long.valueOf(localbeal.a() * 1000L) }));
          continue;
        }
      }
      localObject = a((String)localObject);
      if (localObject != null) {
        ThreadManager.post(new FilterManager.1(this, (beax)localObject), 5, null, true);
      }
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    a(paramString, new Date().getTime());
    QLog.d("QSFM", 1, String.format("scan started: %s", new Object[] { paramString }));
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      paramArrayOfByte = new JSONArray(new String(paramArrayOfByte));
      if (paramArrayOfByte != null)
      {
        int i = 0;
        while (i < paramArrayOfByte.length())
        {
          JSONObject localJSONObject = paramArrayOfByte.getJSONObject(i);
          if ((localJSONObject != null) && (localJSONObject.has("type"))) {
            this.jdField_a_of_type_JavaUtilMap.put(localJSONObject.getString("type"), new beal(localJSONObject));
          }
          i += 1;
        }
      }
      return true;
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public void b(String paramString, Object paramObject)
  {
    if (paramObject != null)
    {
      beal localbeal = a(paramString);
      if ((localbeal != null) && (localbeal.a(paramObject)))
      {
        a(beak.a(paramObject, "packageName").toString());
        if (localbeal.a() > 100000)
        {
          bdzp localbdzp = new bdzp();
          Iterator localIterator = localbeal.a().iterator();
          if (localIterator.hasNext())
          {
            paramString = beak.b(paramObject, (String)localIterator.next());
            if (paramString != null) {}
            for (paramString = paramString.toString();; paramString = "")
            {
              localbdzp.a(paramString);
              break;
            }
          }
          bdzm.a(localbdzp.toString(), localbeal.a());
        }
      }
    }
  }
  
  public void c(String paramString, Object paramObject)
  {
    QLog.d("QSFM", 1, String.format("scan completed: %s", new Object[] { paramString }));
    bdzw.a().flushRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beam
 * JD-Core Version:    0.7.0.1
 */
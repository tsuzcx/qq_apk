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

public class bfit
  implements bfjf
{
  private static volatile bfit jdField_a_of_type_Bfit;
  private static String jdField_a_of_type_JavaLangString = "qp_fm_config";
  private static String b = "_last_time";
  private Map<String, bfis> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private long a(String paramString, long paramLong)
  {
    long l = -1L;
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(paramString + b, paramLong);
    }
    return l;
  }
  
  public static bfit a()
  {
    if (jdField_a_of_type_Bfit == null) {}
    try
    {
      if (jdField_a_of_type_Bfit == null) {
        jdField_a_of_type_Bfit = new bfit();
      }
      return jdField_a_of_type_Bfit;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = new bfja(paramString);
    bfid.a().cloudDetect(paramString, true, false, null);
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
  
  public bfis a(String paramString)
  {
    return (bfis)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public bfje a(String paramString)
  {
    bfjg localbfjg = null;
    if (paramString.equalsIgnoreCase("App")) {
      localbfjg = new bfjg(this);
    }
    return localbfjg;
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
        bfis localbfis = a((String)localObject);
        if ((localbfis != null) && (l2 - l1 < localbfis.a() * 1000L))
        {
          QLog.d("QSFM", 1, String.format("scan not start: %s:%d-%d=%d:%d", new Object[] { localObject, Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l2 - l1), Long.valueOf(localbfis.a() * 1000L) }));
          continue;
        }
      }
      localObject = a((String)localObject);
      if (localObject != null) {
        ThreadManager.post(new FilterManager.1(this, (bfje)localObject), 5, null, true);
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
            this.jdField_a_of_type_JavaUtilMap.put(localJSONObject.getString("type"), new bfis(localJSONObject));
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
      bfis localbfis = a(paramString);
      if ((localbfis != null) && (localbfis.a(paramObject)))
      {
        a(bfir.a(paramObject, "packageName").toString());
        if (localbfis.a() > 100000)
        {
          bfhw localbfhw = new bfhw();
          Iterator localIterator = localbfis.a().iterator();
          if (localIterator.hasNext())
          {
            paramString = bfir.b(paramObject, (String)localIterator.next());
            if (paramString != null) {}
            for (paramString = paramString.toString();; paramString = "")
            {
              localbfhw.a(paramString);
              break;
            }
          }
          bfht.a(localbfhw.toString(), localbfis.a());
        }
      }
    }
  }
  
  public void c(String paramString, Object paramObject)
  {
    QLog.d("QSFM", 1, String.format("scan completed: %s", new Object[] { paramString }));
    bfid.a().flushRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfit
 * JD-Core Version:    0.7.0.1
 */
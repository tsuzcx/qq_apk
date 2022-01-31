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

public class bhjn
  implements bhjz
{
  private static volatile bhjn jdField_a_of_type_Bhjn;
  private static String jdField_a_of_type_JavaLangString = "qp_fm_config";
  private static String b = "_last_time";
  private Map<String, bhjm> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private long a(String paramString, long paramLong)
  {
    long l = -1L;
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(paramString + b, paramLong);
    }
    return l;
  }
  
  public static bhjn a()
  {
    if (jdField_a_of_type_Bhjn == null) {}
    try
    {
      if (jdField_a_of_type_Bhjn == null) {
        jdField_a_of_type_Bhjn = new bhjn();
      }
      return jdField_a_of_type_Bhjn;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = new bhju(paramString);
    bhix.a().cloudDetect(paramString, true, false, null);
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
  
  public bhjm a(String paramString)
  {
    return (bhjm)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public bhjy a(String paramString)
  {
    bhka localbhka = null;
    if (paramString.equalsIgnoreCase("App")) {
      localbhka = new bhka(this);
    }
    return localbhka;
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
        bhjm localbhjm = a((String)localObject);
        if ((localbhjm != null) && (l2 - l1 < localbhjm.a() * 1000L))
        {
          QLog.d("QSFM", 1, String.format("scan not start: %s:%d-%d=%d:%d", new Object[] { localObject, Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l2 - l1), Long.valueOf(localbhjm.a() * 1000L) }));
          continue;
        }
      }
      localObject = a((String)localObject);
      if (localObject != null) {
        ThreadManager.post(new FilterManager.1(this, (bhjy)localObject), 5, null, true);
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
            this.jdField_a_of_type_JavaUtilMap.put(localJSONObject.getString("type"), new bhjm(localJSONObject));
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
      bhjm localbhjm = a(paramString);
      if ((localbhjm != null) && (localbhjm.a(paramObject)))
      {
        a(bhjl.a(paramObject, "packageName").toString());
        if (localbhjm.a() > 100000)
        {
          bhiq localbhiq = new bhiq();
          Iterator localIterator = localbhjm.a().iterator();
          if (localIterator.hasNext())
          {
            paramString = bhjl.b(paramObject, (String)localIterator.next());
            if (paramString != null) {}
            for (paramString = paramString.toString();; paramString = "")
            {
              localbhiq.a(paramString);
              break;
            }
          }
          bhin.a(localbhiq.toString(), localbhjm.a());
        }
      }
    }
  }
  
  public void c(String paramString, Object paramObject)
  {
    QLog.d("QSFM", 1, String.format("scan completed: %s", new Object[] { paramString }));
    bhix.a().flushRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhjn
 * JD-Core Version:    0.7.0.1
 */
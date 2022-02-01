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

public class bktv
  implements bkuh
{
  private static volatile bktv jdField_a_of_type_Bktv;
  private static String jdField_a_of_type_JavaLangString = "qp_fm_config";
  private static String b = "_last_time";
  private Map<String, bktu> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private long a(String paramString, long paramLong)
  {
    long l = -1L;
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(paramString + b, paramLong);
    }
    return l;
  }
  
  public static bktv a()
  {
    if (jdField_a_of_type_Bktv == null) {}
    try
    {
      if (jdField_a_of_type_Bktv == null) {
        jdField_a_of_type_Bktv = new bktv();
      }
      return jdField_a_of_type_Bktv;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = new bkuc(paramString);
    bktf.a().cloudDetect(paramString, true, false, null);
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
  
  public bktu a(String paramString)
  {
    return (bktu)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public bkug a(String paramString)
  {
    bkui localbkui = null;
    if (paramString.equalsIgnoreCase("App")) {
      localbkui = new bkui(this);
    }
    return localbkui;
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
        bktu localbktu = a((String)localObject);
        if ((localbktu != null) && (l2 - l1 < localbktu.a() * 1000L))
        {
          QLog.d("QSFM", 1, String.format("scan not start: %s:%d-%d=%d:%d", new Object[] { localObject, Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l2 - l1), Long.valueOf(localbktu.a() * 1000L) }));
          continue;
        }
      }
      localObject = a((String)localObject);
      if (localObject != null) {
        ThreadManager.post(new FilterManager.1(this, (bkug)localObject), 5, null, true);
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
            this.jdField_a_of_type_JavaUtilMap.put(localJSONObject.getString("type"), new bktu(localJSONObject));
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
      bktu localbktu = a(paramString);
      if ((localbktu != null) && (localbktu.a(paramObject)))
      {
        a(bktt.a(paramObject, "packageName").toString());
        if (localbktu.a() > 100000)
        {
          bksy localbksy = new bksy();
          Iterator localIterator = localbktu.a().iterator();
          if (localIterator.hasNext())
          {
            paramString = bktt.b(paramObject, (String)localIterator.next());
            if (paramString != null) {}
            for (paramString = paramString.toString();; paramString = "")
            {
              localbksy.a(paramString);
              break;
            }
          }
          bksv.a(localbksy.toString(), localbktu.a());
        }
      }
    }
  }
  
  public void c(String paramString, Object paramObject)
  {
    QLog.d("QSFM", 1, String.format("scan completed: %s", new Object[] { paramString }));
    bktf.a().flushRequest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktv
 * JD-Core Version:    0.7.0.1
 */
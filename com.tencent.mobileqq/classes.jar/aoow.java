import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime.Status;
import org.json.JSONArray;
import org.json.JSONObject;

public class aoow
{
  private ArrayList<awev> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private HashMap<String, awev> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  
  public aoow()
  {
    int i = 0;
    while (i < awer.a.length)
    {
      AppRuntime.Status localStatus = awer.a[i];
      awev localawev = new awev(localStatus);
      this.jdField_a_of_type_JavaUtilArrayList.add(localawev);
      this.jdField_a_of_type_JavaUtilHashMap.put(awev.a(localStatus, localawev.jdField_a_of_type_Long), localawev);
      i += 1;
    }
  }
  
  public static aoow a(String paramString)
  {
    aoow localaoow = new aoow();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        if (paramString != null)
        {
          i = 0;
          if (i < paramString.length())
          {
            Object localObject2 = (JSONObject)paramString.get(i);
            if (localObject2 == null) {
              break label212;
            }
            long l = ((JSONObject)localObject2).optLong("id");
            Object localObject1 = ((JSONObject)localObject2).optString("title");
            localObject2 = ((JSONObject)localObject2).optString("icon");
            if ((l == 1000L) && (a()))
            {
              QLog.d("OnlineStatusConfProcessor", 1, "incompatible for battery status");
            }
            else
            {
              localObject1 = new awev(l, (String)localObject1, (String)localObject2);
              localaoow.jdField_a_of_type_JavaUtilHashMap.put(awev.a(AppRuntime.Status.online, ((awev)localObject1).jdField_a_of_type_Long), localObject1);
              localaoow.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OnlineStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return localaoow;
      }
      QLog.d("OnlineStatusConfProcessor", 2, "confBean = " + localaoow.toString());
      return localaoow;
      label212:
      i += 1;
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (aweo.a() <= 0) {
      bool = true;
    }
    return bool;
  }
  
  public awev a(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject = paramStatus;
    if (paramStatus == null)
    {
      QLog.d("OnlineStatus", 1, new Object[] { "getOnlineStatusItem with null, id:", Long.valueOf(paramLong) });
      localObject = AppRuntime.Status.online;
    }
    paramStatus = awev.a((AppRuntime.Status)localObject, paramLong);
    localObject = (awev)this.jdField_a_of_type_JavaUtilHashMap.get(paramStatus);
    paramStatus = (AppRuntime.Status)localObject;
    if (localObject == null) {
      paramStatus = new awev(AppRuntime.Status.online);
    }
    return paramStatus;
  }
  
  public ArrayList<awev> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      awev localawev = (awev)localIterator.next();
      localStringBuilder.append("id:").append(localawev.jdField_a_of_type_Long).append(" ");
      localStringBuilder.append("title:").append(localawev.jdField_a_of_type_JavaLangString).append(" ");
      localStringBuilder.append("icon:").append(localawev.b).append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoow
 * JD-Core Version:    0.7.0.1
 */
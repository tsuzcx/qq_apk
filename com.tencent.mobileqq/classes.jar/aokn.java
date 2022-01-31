import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime.Status;
import org.json.JSONArray;
import org.json.JSONObject;

public class aokn
{
  private ArrayList<awam> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private HashMap<String, awam> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  
  public aokn()
  {
    int i = 0;
    while (i < awai.a.length)
    {
      AppRuntime.Status localStatus = awai.a[i];
      awam localawam = new awam(localStatus);
      this.jdField_a_of_type_JavaUtilArrayList.add(localawam);
      this.jdField_a_of_type_JavaUtilHashMap.put(awam.a(localStatus, localawam.jdField_a_of_type_Long), localawam);
      i += 1;
    }
  }
  
  public static aokn a(String paramString)
  {
    aokn localaokn = new aokn();
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
              localObject1 = new awam(l, (String)localObject1, (String)localObject2);
              localaokn.jdField_a_of_type_JavaUtilHashMap.put(awam.a(AppRuntime.Status.online, ((awam)localObject1).jdField_a_of_type_Long), localObject1);
              localaokn.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OnlineStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return localaokn;
      }
      QLog.d("OnlineStatusConfProcessor", 2, "confBean = " + localaokn.toString());
      return localaokn;
      label212:
      i += 1;
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (awaf.a() <= 0) {
      bool = true;
    }
    return bool;
  }
  
  public awam a(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject = paramStatus;
    if (paramStatus == null)
    {
      QLog.d("OnlineStatus", 1, new Object[] { "getOnlineStatusItem with null, id:", Long.valueOf(paramLong) });
      localObject = AppRuntime.Status.online;
    }
    paramStatus = awam.a((AppRuntime.Status)localObject, paramLong);
    localObject = (awam)this.jdField_a_of_type_JavaUtilHashMap.get(paramStatus);
    paramStatus = (AppRuntime.Status)localObject;
    if (localObject == null) {
      paramStatus = new awam(AppRuntime.Status.online);
    }
    return paramStatus;
  }
  
  public ArrayList<awam> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      awam localawam = (awam)localIterator.next();
      localStringBuilder.append("id:").append(localawam.jdField_a_of_type_Long).append(" ");
      localStringBuilder.append("title:").append(localawam.jdField_a_of_type_JavaLangString).append(" ");
      localStringBuilder.append("icon:").append(localawam.b).append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aokn
 * JD-Core Version:    0.7.0.1
 */
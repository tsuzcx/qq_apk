import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime.Status;
import org.json.JSONArray;
import org.json.JSONObject;

public class arfr
{
  private ArrayList<azib> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private HashMap<String, azib> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  
  public arfr()
  {
    int i = 0;
    while (i < azhv.a.length)
    {
      AppRuntime.Status localStatus = azhv.a[i];
      azib localazib = new azib(localStatus);
      this.jdField_a_of_type_JavaUtilArrayList.add(localazib);
      this.jdField_a_of_type_JavaUtilHashMap.put(azib.a(localStatus, localazib.jdField_a_of_type_Long), localazib);
      i += 1;
    }
  }
  
  public static arfr a(String paramString)
  {
    arfr localarfr = new arfr();
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
              localObject1 = new azib(l, (String)localObject1, (String)localObject2);
              localarfr.jdField_a_of_type_JavaUtilHashMap.put(azib.a(AppRuntime.Status.online, ((azib)localObject1).jdField_a_of_type_Long), localObject1);
              localarfr.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OnlineStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return localarfr;
      }
      QLog.d("OnlineStatusConfProcessor", 1, "confBean = " + localarfr.toString());
      return localarfr;
      label212:
      i += 1;
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (azhq.a() <= 0) {
      bool = true;
    }
    return bool;
  }
  
  public azib a(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject = paramStatus;
    if (paramStatus == null)
    {
      QLog.d("OnlineStatus", 1, new Object[] { "getOnlineStatusItem with null, id:", Long.valueOf(paramLong) });
      localObject = AppRuntime.Status.online;
    }
    paramStatus = azib.a((AppRuntime.Status)localObject, paramLong);
    localObject = (azib)this.jdField_a_of_type_JavaUtilHashMap.get(paramStatus);
    paramStatus = (AppRuntime.Status)localObject;
    if (localObject == null) {
      paramStatus = new azib(AppRuntime.Status.online);
    }
    return paramStatus;
  }
  
  public ArrayList<azib> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      azib localazib = (azib)localIterator.next();
      localStringBuilder.append("id:").append(localazib.jdField_a_of_type_Long).append(" ");
      localStringBuilder.append("title:").append(localazib.jdField_a_of_type_JavaLangString).append(" ");
      localStringBuilder.append("icon:").append(localazib.b).append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfr
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime.Status;
import org.json.JSONArray;
import org.json.JSONObject;

public class amtm
{
  private ArrayList<aujh> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private HashMap<String, aujh> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  
  public amtm()
  {
    int i = 0;
    while (i < aujd.a.length)
    {
      AppRuntime.Status localStatus = aujd.a[i];
      aujh localaujh = new aujh(localStatus);
      this.jdField_a_of_type_JavaUtilArrayList.add(localaujh);
      this.jdField_a_of_type_JavaUtilHashMap.put(aujh.a(localStatus, localaujh.jdField_a_of_type_Long), localaujh);
      i += 1;
    }
  }
  
  public static amtm a(String paramString)
  {
    amtm localamtm = new amtm();
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
              localObject1 = new aujh(l, (String)localObject1, (String)localObject2);
              localamtm.jdField_a_of_type_JavaUtilHashMap.put(aujh.a(AppRuntime.Status.online, ((aujh)localObject1).jdField_a_of_type_Long), localObject1);
              localamtm.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OnlineStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return localamtm;
      }
      QLog.d("OnlineStatusConfProcessor", 2, "confBean = " + localamtm.toString());
      return localamtm;
      label212:
      i += 1;
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (auja.a() <= 0) {
      bool = true;
    }
    return bool;
  }
  
  public aujh a(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject = paramStatus;
    if (paramStatus == null)
    {
      QLog.d("OnlineStatus", 1, new Object[] { "getOnlineStatusItem with null, id:", Long.valueOf(paramLong) });
      localObject = AppRuntime.Status.online;
    }
    paramStatus = aujh.a((AppRuntime.Status)localObject, paramLong);
    localObject = (aujh)this.jdField_a_of_type_JavaUtilHashMap.get(paramStatus);
    paramStatus = (AppRuntime.Status)localObject;
    if (localObject == null) {
      paramStatus = new aujh(AppRuntime.Status.online);
    }
    return paramStatus;
  }
  
  public ArrayList<aujh> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aujh localaujh = (aujh)localIterator.next();
      localStringBuilder.append("id:").append(localaujh.jdField_a_of_type_Long).append(" ");
      localStringBuilder.append("title:").append(localaujh.jdField_a_of_type_JavaLangString).append(" ");
      localStringBuilder.append("icon:").append(localaujh.b).append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amtm
 * JD-Core Version:    0.7.0.1
 */
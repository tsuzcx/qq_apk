import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime.Status;
import org.json.JSONArray;
import org.json.JSONObject;

public class amtl
{
  private ArrayList<aujj> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private HashMap<String, aujj> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  
  public amtl()
  {
    int i = 0;
    while (i < aujf.a.length)
    {
      AppRuntime.Status localStatus = aujf.a[i];
      aujj localaujj = new aujj(localStatus);
      this.jdField_a_of_type_JavaUtilArrayList.add(localaujj);
      this.jdField_a_of_type_JavaUtilHashMap.put(aujj.a(localStatus, localaujj.jdField_a_of_type_Long), localaujj);
      i += 1;
    }
  }
  
  public static amtl a(String paramString)
  {
    amtl localamtl = new amtl();
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
              localObject1 = new aujj(l, (String)localObject1, (String)localObject2);
              localamtl.jdField_a_of_type_JavaUtilHashMap.put(aujj.a(AppRuntime.Status.online, ((aujj)localObject1).jdField_a_of_type_Long), localObject1);
              localamtl.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OnlineStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return localamtl;
      }
      QLog.d("OnlineStatusConfProcessor", 2, "confBean = " + localamtl.toString());
      return localamtl;
      label212:
      i += 1;
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (aujc.a() <= 0) {
      bool = true;
    }
    return bool;
  }
  
  public aujj a(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject = paramStatus;
    if (paramStatus == null)
    {
      QLog.d("OnlineStatus", 1, new Object[] { "getOnlineStatusItem with null, id:", Long.valueOf(paramLong) });
      localObject = AppRuntime.Status.online;
    }
    paramStatus = aujj.a((AppRuntime.Status)localObject, paramLong);
    localObject = (aujj)this.jdField_a_of_type_JavaUtilHashMap.get(paramStatus);
    paramStatus = (AppRuntime.Status)localObject;
    if (localObject == null) {
      paramStatus = new aujj(AppRuntime.Status.online);
    }
    return paramStatus;
  }
  
  public ArrayList<aujj> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aujj localaujj = (aujj)localIterator.next();
      localStringBuilder.append("id:").append(localaujj.jdField_a_of_type_Long).append(" ");
      localStringBuilder.append("title:").append(localaujj.jdField_a_of_type_JavaLangString).append(" ");
      localStringBuilder.append("icon:").append(localaujj.b).append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amtl
 * JD-Core Version:    0.7.0.1
 */
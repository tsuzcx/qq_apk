import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime.Status;
import org.json.JSONArray;
import org.json.JSONObject;

public class apzh
{
  private ArrayList<axvj> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private HashMap<String, axvj> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  
  public apzh()
  {
    int i = 0;
    while (i < axvd.a.length)
    {
      AppRuntime.Status localStatus = axvd.a[i];
      axvj localaxvj = new axvj(localStatus);
      this.jdField_a_of_type_JavaUtilArrayList.add(localaxvj);
      this.jdField_a_of_type_JavaUtilHashMap.put(axvj.a(localStatus, localaxvj.jdField_a_of_type_Long), localaxvj);
      i += 1;
    }
  }
  
  public static apzh a(String paramString)
  {
    apzh localapzh = new apzh();
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
              localObject1 = new axvj(l, (String)localObject1, (String)localObject2);
              localapzh.jdField_a_of_type_JavaUtilHashMap.put(axvj.a(AppRuntime.Status.online, ((axvj)localObject1).jdField_a_of_type_Long), localObject1);
              localapzh.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OnlineStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return localapzh;
      }
      QLog.d("OnlineStatusConfProcessor", 1, "confBean = " + localapzh.toString());
      return localapzh;
      label212:
      i += 1;
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (axuy.a() <= 0) {
      bool = true;
    }
    return bool;
  }
  
  public axvj a(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject = paramStatus;
    if (paramStatus == null)
    {
      QLog.d("OnlineStatus", 1, new Object[] { "getOnlineStatusItem with null, id:", Long.valueOf(paramLong) });
      localObject = AppRuntime.Status.online;
    }
    paramStatus = axvj.a((AppRuntime.Status)localObject, paramLong);
    localObject = (axvj)this.jdField_a_of_type_JavaUtilHashMap.get(paramStatus);
    paramStatus = (AppRuntime.Status)localObject;
    if (localObject == null) {
      paramStatus = new axvj(AppRuntime.Status.online);
    }
    return paramStatus;
  }
  
  public ArrayList<axvj> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      axvj localaxvj = (axvj)localIterator.next();
      localStringBuilder.append("id:").append(localaxvj.jdField_a_of_type_Long).append(" ");
      localStringBuilder.append("title:").append(localaxvj.jdField_a_of_type_JavaLangString).append(" ");
      localStringBuilder.append("icon:").append(localaxvj.b).append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apzh
 * JD-Core Version:    0.7.0.1
 */
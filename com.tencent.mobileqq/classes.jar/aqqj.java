import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime.Status;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqqj
{
  private ArrayList<aypi> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private HashMap<String, aypi> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  
  public aqqj()
  {
    int i = 0;
    while (i < aypc.a.length)
    {
      AppRuntime.Status localStatus = aypc.a[i];
      aypi localaypi = new aypi(localStatus);
      this.jdField_a_of_type_JavaUtilArrayList.add(localaypi);
      this.jdField_a_of_type_JavaUtilHashMap.put(aypi.a(localStatus, localaypi.jdField_a_of_type_Long), localaypi);
      i += 1;
    }
  }
  
  public static aqqj a(String paramString)
  {
    aqqj localaqqj = new aqqj();
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
              localObject1 = new aypi(l, (String)localObject1, (String)localObject2);
              localaqqj.jdField_a_of_type_JavaUtilHashMap.put(aypi.a(AppRuntime.Status.online, ((aypi)localObject1).jdField_a_of_type_Long), localObject1);
              localaqqj.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OnlineStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return localaqqj;
      }
      QLog.d("OnlineStatusConfProcessor", 1, "confBean = " + localaqqj.toString());
      return localaqqj;
      label212:
      i += 1;
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (ayox.a() <= 0) {
      bool = true;
    }
    return bool;
  }
  
  public aypi a(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject = paramStatus;
    if (paramStatus == null)
    {
      QLog.d("OnlineStatus", 1, new Object[] { "getOnlineStatusItem with null, id:", Long.valueOf(paramLong) });
      localObject = AppRuntime.Status.online;
    }
    paramStatus = aypi.a((AppRuntime.Status)localObject, paramLong);
    localObject = (aypi)this.jdField_a_of_type_JavaUtilHashMap.get(paramStatus);
    paramStatus = (AppRuntime.Status)localObject;
    if (localObject == null) {
      paramStatus = new aypi(AppRuntime.Status.online);
    }
    return paramStatus;
  }
  
  public ArrayList<aypi> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aypi localaypi = (aypi)localIterator.next();
      localStringBuilder.append("id:").append(localaypi.jdField_a_of_type_Long).append(" ");
      localStringBuilder.append("title:").append(localaypi.jdField_a_of_type_JavaLangString).append(" ");
      localStringBuilder.append("icon:").append(localaypi.b).append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqqj
 * JD-Core Version:    0.7.0.1
 */
import android.os.Build;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.OnlineStatusBean.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime.Status;
import org.json.JSONArray;
import org.json.JSONObject;

public class amdi
{
  private ArrayList<atlj> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private HashMap<String, atlj> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  
  public amdi()
  {
    int i = 0;
    while (i < atlf.a.length)
    {
      AppRuntime.Status localStatus = atlf.a[i];
      atlj localatlj = new atlj(localStatus);
      this.jdField_a_of_type_JavaUtilArrayList.add(localatlj);
      this.jdField_a_of_type_JavaUtilHashMap.put(atlj.a(localStatus, localatlj.jdField_a_of_type_Long), localatlj);
      i += 1;
    }
  }
  
  public static amdi a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      amdi localamdi;
      int i;
      try
      {
        localamdi = new amdi();
        paramString = new JSONArray(paramString);
        if (paramString != null)
        {
          i = 0;
          if (i < paramString.length())
          {
            Object localObject2 = (JSONObject)paramString.get(i);
            if (localObject2 == null) {
              break label227;
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
              localObject1 = new atlj(l, (String)localObject1, (String)localObject2);
              localamdi.jdField_a_of_type_JavaUtilHashMap.put(atlj.a(AppRuntime.Status.online, ((atlj)localObject1).jdField_a_of_type_Long), localObject1);
              localamdi.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OnlineStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return null;
      }
      QLog.d("OnlineStatusConfProcessor", 2, "confBean = " + localamdi.toString());
      ThreadManagerV2.executeOnSubThread(new OnlineStatusBean.1());
      return localamdi;
      label227:
      i += 1;
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if ("vivo Y67L".equalsIgnoreCase(Build.MODEL)) {
      bool = true;
    }
    return bool;
  }
  
  public atlj a(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject = paramStatus;
    if (paramStatus == null)
    {
      QLog.d("OnlineStatus", 1, new Object[] { "getOnlineStatusItem with null, id:", Long.valueOf(paramLong) });
      localObject = AppRuntime.Status.online;
    }
    paramStatus = atlj.a((AppRuntime.Status)localObject, paramLong);
    localObject = (atlj)this.jdField_a_of_type_JavaUtilHashMap.get(paramStatus);
    paramStatus = (AppRuntime.Status)localObject;
    if (localObject == null) {
      paramStatus = new atlj(AppRuntime.Status.online);
    }
    return paramStatus;
  }
  
  public ArrayList<atlj> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      atlj localatlj = (atlj)localIterator.next();
      localStringBuilder.append("id:").append(localatlj.jdField_a_of_type_Long).append(" ");
      localStringBuilder.append("title:").append(localatlj.jdField_a_of_type_JavaLangString).append(" ");
      localStringBuilder.append("icon:").append(localatlj.b).append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdi
 * JD-Core Version:    0.7.0.1
 */
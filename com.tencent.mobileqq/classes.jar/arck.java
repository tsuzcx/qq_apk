import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime.Status;
import org.json.JSONArray;
import org.json.JSONObject;

public class arck
{
  private ArrayList<azbu> jdField_a_of_type_JavaUtilArrayList = new ArrayList(20);
  private HashMap<String, azbu> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  
  public arck()
  {
    int i = 0;
    while (i < azbo.a.length)
    {
      AppRuntime.Status localStatus = azbo.a[i];
      azbu localazbu = new azbu(localStatus);
      this.jdField_a_of_type_JavaUtilArrayList.add(localazbu);
      this.jdField_a_of_type_JavaUtilHashMap.put(azbu.a(localStatus, localazbu.jdField_a_of_type_Long), localazbu);
      i += 1;
    }
  }
  
  public static arck a(String paramString)
  {
    arck localarck = new arck();
    for (;;)
    {
      int i;
      JSONObject localJSONObject;
      long l;
      String str;
      try
      {
        paramString = new JSONArray(paramString);
        if (paramString == null) {
          break label261;
        }
        i = 0;
        if (i >= paramString.length()) {
          break label261;
        }
        localJSONObject = (JSONObject)paramString.get(i);
        if (localJSONObject == null) {
          break label293;
        }
        l = localJSONObject.optLong("id");
        localObject = localJSONObject.optString("title");
        str = localJSONObject.optString("icon");
        if ((l == 0L) || (TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str))) {
          QLog.d("OnlineStatusConfProcessor", 1, new Object[] { "error pamas:id=", Long.valueOf(l), " title=", localObject, " icon=", str });
        } else if ((l == 1000L) && (a())) {
          QLog.d("OnlineStatusConfProcessor", 1, "incompatible for battery status");
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OnlineStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return localarck;
      }
      Object localObject = new azbu(l, (String)localObject, str);
      ((azbu)localObject).jdField_a_of_type_Boolean = localJSONObject.optBoolean("showInStudyMode", true);
      localarck.jdField_a_of_type_JavaUtilHashMap.put(azbu.a(AppRuntime.Status.online, ((azbu)localObject).jdField_a_of_type_Long), localObject);
      localarck.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      break label293;
      label261:
      QLog.d("OnlineStatusConfProcessor", 1, "confBean = " + localarck.toString());
      return localarck;
      label293:
      i += 1;
    }
  }
  
  public static ArrayList<azbu> a(List<? extends azbu> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool = bdvn.a();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      azbu localazbu = (azbu)paramList.next();
      if ((!bool) || (localazbu.jdField_a_of_type_Boolean)) {
        localArrayList.add(localazbu);
      }
    }
    return localArrayList;
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (azbj.a() <= 0) {
      bool = true;
    }
    return bool;
  }
  
  public azbu a(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject = paramStatus;
    if (paramStatus == null)
    {
      QLog.d("OnlineStatus", 1, new Object[] { "getOnlineStatusItem with null, id:", Long.valueOf(paramLong) });
      localObject = AppRuntime.Status.online;
    }
    paramStatus = azbu.a((AppRuntime.Status)localObject, paramLong);
    localObject = (azbu)this.jdField_a_of_type_JavaUtilHashMap.get(paramStatus);
    paramStatus = (AppRuntime.Status)localObject;
    if (localObject == null) {
      paramStatus = new azbu(AppRuntime.Status.online);
    }
    return paramStatus;
  }
  
  public ArrayList<azbu> a()
  {
    return a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      azbu localazbu = (azbu)localIterator.next();
      localStringBuilder.append("id:").append(localazbu.jdField_a_of_type_Long).append(" ");
      localStringBuilder.append("title:").append(localazbu.b).append(" ");
      localStringBuilder.append("icon:").append(localazbu.c).append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arck
 * JD-Core Version:    0.7.0.1
 */
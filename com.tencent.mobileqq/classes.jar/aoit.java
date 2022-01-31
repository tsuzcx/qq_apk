import android.support.v4.util.ArraySet;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aoit
{
  public ArraySet<String> a = new ArraySet();
  
  public static aoit a(String paramString)
  {
    localaoit = new aoit();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("white_list");
      int i = 0;
      while (i < paramString.length())
      {
        localaoit.a.add(paramString.optString(i, ""));
        i += 1;
      }
      return localaoit;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BroadcastConfProcessor", 2, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoit
 * JD-Core Version:    0.7.0.1
 */
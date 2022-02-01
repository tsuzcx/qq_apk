import android.support.v4.util.ArraySet;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ardh
{
  public ArraySet<String> a = new ArraySet();
  
  public static ardh a(String paramString)
  {
    localardh = new ardh();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("white_list");
      int i = 0;
      while (i < paramString.length())
      {
        localardh.a.add(paramString.optString(i, ""));
        i += 1;
      }
      return localardh;
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
 * Qualified Name:     ardh
 * JD-Core Version:    0.7.0.1
 */
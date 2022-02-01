import android.support.v4.util.ArraySet;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqoc
{
  public ArraySet<String> a = new ArraySet();
  
  public static aqoc a(String paramString)
  {
    localaqoc = new aqoc();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("white_list");
      int i = 0;
      while (i < paramString.length())
      {
        localaqoc.a.add(paramString.optString(i, ""));
        i += 1;
      }
      return localaqoc;
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
 * Qualified Name:     aqoc
 * JD-Core Version:    0.7.0.1
 */
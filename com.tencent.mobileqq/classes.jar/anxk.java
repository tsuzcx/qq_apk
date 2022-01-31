import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anxk
{
  int a = -1;
  
  public static anxk a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        anxk localanxk = new anxk();
        localanxk.a = new JSONObject(paramString).getInt("maxcount");
        anyf.a = localanxk.a;
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteConfigProcessor", 2, "ColorNoteConfigProcessor onParsed maxcount " + localanxk.a);
        }
        return localanxk;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ColorNoteConfigProcessor", 2, "ColorNoteConfigProcessor onParsed erro " + paramString.toString());
    return null;
  }
  
  public int a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxk
 * JD-Core Version:    0.7.0.1
 */
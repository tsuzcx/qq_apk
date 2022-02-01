import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqno
{
  int a = -1;
  
  public static aqno a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        aqno localaqno = new aqno();
        localaqno.a = new JSONObject(paramString).getInt("maxcount");
        aqol.a = localaqno.a;
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteConfigProcessor", 2, "ColorNoteConfigProcessor onParsed maxcount " + localaqno.a);
        }
        return localaqno;
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
 * Qualified Name:     aqno
 * JD-Core Version:    0.7.0.1
 */
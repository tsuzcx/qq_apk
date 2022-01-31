import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amgk
{
  int a = -1;
  
  public static amgk a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        amgk localamgk = new amgk();
        localamgk.a = new JSONObject(paramString).getInt("maxcount");
        amhe.a = localamgk.a;
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteConfigProcessor", 2, "ColorNoteConfigProcessor onParsed maxcount " + localamgk.a);
        }
        return localamgk;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgk
 * JD-Core Version:    0.7.0.1
 */
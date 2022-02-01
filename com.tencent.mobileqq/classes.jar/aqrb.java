import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqrb
{
  int a = -1;
  
  public static aqrb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        aqrb localaqrb = new aqrb();
        localaqrb.a = new JSONObject(paramString).getInt("maxcount");
        aqry.a = localaqrb.a;
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteConfigProcessor", 2, "ColorNoteConfigProcessor onParsed maxcount " + localaqrb.a);
        }
        return localaqrb;
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
 * Qualified Name:     aqrb
 * JD-Core Version:    0.7.0.1
 */
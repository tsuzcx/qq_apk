import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anyg
{
  private int a = 1;
  
  public static anyg a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteRecentConfBean", 2, String.format("parse content=%s", new Object[] { paramString }));
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      try
      {
        anyg localanyg = new anyg();
        localanyg.a = new JSONObject(paramString).getInt("ifrecent");
        return localanyg;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ColorNoteRecentConfBean", 2, "ColorNoteRecentConfBean parse err: ", paramString);
    return null;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyg
 * JD-Core Version:    0.7.0.1
 */
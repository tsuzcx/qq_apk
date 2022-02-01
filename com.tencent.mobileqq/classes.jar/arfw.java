import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arfw
{
  public boolean a = true;
  
  public static arfw a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScannerQQCodeConfBean", 2, "defaultBean");
    }
    return new arfw();
  }
  
  public static arfw a(String paramString)
  {
    localarfw = new arfw();
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("ScannerQQCodeConfBean", 2, "parse content: " + paramString);
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("useQBarAIModel")) {
        if (paramString.optInt("useQBarAIModel") != 1) {
          break label83;
        }
      }
      label83:
      for (boolean bool = true;; bool = false)
      {
        localarfw.a = bool;
        return localarfw;
      }
      return localarfw;
    }
    catch (JSONException paramString)
    {
      QLog.e("ScannerQQCodeConfBean", 1, "parse error->" + paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfw
 * JD-Core Version:    0.7.0.1
 */
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class aqjk
{
  public boolean a;
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      this.a = new JSONObject(paramString).optBoolean("input_status_gray_switch", false);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("InputStatusConfig", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqjk
 * JD-Core Version:    0.7.0.1
 */
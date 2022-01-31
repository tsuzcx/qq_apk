import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class ardr
{
  public boolean a;
  public boolean b = true;
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.optBoolean("input_status_gray_switch", false);
      this.b = paramString.optBoolean("expand_chat_input_status_switch", true);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("InputStatusConfig", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ardr
 * JD-Core Version:    0.7.0.1
 */
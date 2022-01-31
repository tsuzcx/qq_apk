import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class awqo
{
  public boolean a;
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgReporterSwitchConfigProcessor", 2, "MsgReporterSwitch configText : " + paramString);
      }
    }
    try
    {
      this.a = new JSONObject(paramString).optBoolean("MsgHopperUpload", false);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("MsgReporterSwitchConfigProcessor", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awqo
 * JD-Core Version:    0.7.0.1
 */
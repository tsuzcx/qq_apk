import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class atju
  implements IMiniMsgUnreadCallback
{
  public atju(UiApiPlugin paramUiApiPlugin) {}
  
  public void destroy() {}
  
  public void hide() {}
  
  public void hideUnread()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("unReadHide", true);
      this.a.a("UnRead", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("UiApiPlugin", 1, localException, new Object[0]);
    }
  }
  
  public boolean show(int paramInt)
  {
    return false;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle)
  {
    try
    {
      paramBundle = new JSONObject();
      this.a.a("backFromMiniAIO", paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.d("UiApiPlugin", 1, paramBundle, new Object[0]);
    }
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("unReadC", paramInt);
      localJSONObject.put("unReadHide", paramBoolean);
      this.a.a("updateUnreadCount", localJSONObject);
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "mini_msg uiApiPlugin undateUnreadCount = " + paramInt);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atju
 * JD-Core Version:    0.7.0.1
 */
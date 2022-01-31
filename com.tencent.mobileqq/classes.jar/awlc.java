import android.text.TextUtils;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class awlc
{
  final TroopAIOAppInfo a = new TroopAIOAppInfo();
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOPlusPanelAppInfoConfigProcessor", 2, "Config parse configText -> " + paramString);
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.a.appid = paramString.optInt("appid");
      this.a.name = paramString.optString("title");
      this.a.enName = paramString.optString("eng_title");
      this.a.iconUrl = paramString.optString("iconNormal");
      this.a.iconPress = paramString.optString("iconPress");
      this.a.simpleDayUrl = paramString.optString("iconConciseNormal");
      this.a.simpleDayPressUrl = paramString.optString("iconConcisePress");
      this.a.simpleNightUrl = paramString.optString("iconConciseNightNormal");
      this.a.simpleNightPressUrl = paramString.optString("iconConciseNightPress");
      this.a.redDotID = awmb.a(this.a.appid);
      this.a.actionType = paramString.optString("actionType");
      this.a.action = paramString.optString("action");
      this.a.enableC2C = paramString.optInt("enableC2C");
      this.a.enableGroup = paramString.optInt("enableGroup");
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("AIOPlusPanelAppInfoConfigProcessor", 1, paramString, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awlc
 * JD-Core Version:    0.7.0.1
 */
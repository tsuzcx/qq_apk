import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.share.QZoneShareActivity;
import cooperation.qzone.share.QZoneShareActivity.3.1;
import cooperation.qzone.share.QZoneShareActivity.3.2;
import eipc.EIPCClient;
import java.util.Map;
import org.json.JSONObject;

public class bgcv
  implements MiniAppCmdInterface
{
  public bgcv(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      String str = paramJSONObject.optString("jump_url");
      QZoneShareActivity.a(this.a, paramJSONObject.optBoolean("needShareCallBack"));
      if ((QZoneShareActivity.a(this.a) != null) && (QZoneShareActivity.a(this.a).a != null)) {
        QZoneShareActivity.a(this.a).a.put("xcxFakeLink", str);
      }
      if (!QZoneShareActivity.a(this.a)) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      QZoneShareActivity.b(this.a);
      this.a.runOnUiThread(new QZoneShareActivity.3.1(this));
      return;
    }
    long l = -1L;
    if (paramJSONObject != null)
    {
      QZoneShareActivity.a(this.a, paramJSONObject.optBoolean("needShareCallBack"));
      l = paramJSONObject.optLong("retCode");
    }
    for (paramJSONObject = paramJSONObject.optString("errMsg");; paramJSONObject = null)
    {
      if (!QZoneShareActivity.a(this.a)) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null, null);
      }
      this.a.runOnUiThread(new QZoneShareActivity.3.2(this, l, paramJSONObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgcv
 * JD-Core Version:    0.7.0.1
 */
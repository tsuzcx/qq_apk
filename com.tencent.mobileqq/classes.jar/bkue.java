import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

public class bkue
  extends BaseJsPlugin
{
  @JsEvent({"getGUID"})
  public void checkGameBuddyType(RequestEvent paramRequestEvent)
  {
    QLog.d("DeviceInfoPlugin", 1, "checkGameBuddyType getGUID");
    QIPCClientHelper.getInstance().callServer("DeviceProtectQIPCModule", "ACTION_GET_GUID_INFO", null, new bkuf(this, paramRequestEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkue
 * JD-Core Version:    0.7.0.1
 */
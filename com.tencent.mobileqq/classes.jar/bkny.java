import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

final class bkny
  implements MiniAppCmdInterface
{
  bkny(AsyncResult paramAsyncResult) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (this.a != null) {
      this.a.onReceiveResult(paramBoolean, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkny
 * JD-Core Version:    0.7.0.1
 */
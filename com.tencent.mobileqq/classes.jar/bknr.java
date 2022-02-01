import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class bknr
  implements MiniAppSSOCmdHelper.MiniAppCmdCallback<INTERFACE.StJudgeTimingRsp>
{
  bknr(bknl parambknl, AsyncResult paramAsyncResult) {}
  
  public void a(boolean paramBoolean, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp)
  {
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("response", paramStJudgeTimingRsp);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(paramBoolean, localJSONObject);
      return;
    }
    catch (Throwable paramStJudgeTimingRsp)
    {
      for (;;)
      {
        QLog.e("ChannelProxyImpl", 1, "tianshuRequestAdv", paramStJudgeTimingRsp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bknr
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class bkxy
  extends BroadcastReceiver
{
  bkxy(bkxx parambkxx, AsyncResult paramAsyncResult) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.tencent.mobileqq.mini.out.plugins.scanResultData");
    paramIntent = paramIntent.getStringExtra("com.tencent.mobileqq.mini.out.plugins.scanResultType");
    QLog.d("MiniAppProxyImpl", 2, "scanResult: " + str + "----scan_type: " + paramIntent);
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("result", str);
      localJSONObject2.put("scanType", paramIntent);
      localJSONObject2.put("rawData", bjty.a(str));
      localJSONObject2.put("charSet", "utf-8");
      localJSONObject1.put("detail", localJSONObject2);
      localJSONObject1.put("result", str);
      localJSONObject1.put("scanType", paramIntent);
      localJSONObject1.put("rawData", bjty.a(str));
      localJSONObject1.put("charSet", "utf-8");
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAsyncResult.onReceiveResult(true, localJSONObject1);
      paramContext.unregisterReceiver(bkxx.a(this.jdField_a_of_type_Bkxx));
      bkxx.a(this.jdField_a_of_type_Bkxx, null);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e("MiniAppProxyImpl", 1, "scan result error." + paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxy
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.qg.sdk.invoke.BaseJsModule;
import com.tencent.qg.sdk.invoke.InvokeCallback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bkan
  extends BaseJsModule
{
  public bkan(bkal parambkal) {}
  
  public String getModuleName()
  {
    return "VipQGModel";
  }
  
  public boolean handleJsRequest(String paramString, JSONObject paramJSONObject, InvokeCallback paramInvokeCallback)
  {
    if ("notifyJsInvokeFinish".equalsIgnoreCase(paramString))
    {
      QLog.i("VipQGModel", 1, "handleJsRequest: notifyJsInvokeFinish");
      this.a.a("getDeviceSize", new float[] { bdkf.a(), bdkf.b() });
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkan
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import org.json.JSONObject;

class bjxl
  implements MiniAppCmdInterface
{
  bjxl(bjxj parambjxj, String paramString, IJsService paramIJsService, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.i("MiniSDKClientQIPCModule", 2, "createUpdatableMsg receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("retCode");
      String str = paramJSONObject.optString("errMsg");
      paramJSONObject = new JSONObject();
      if (i == 0) {}
      try
      {
        paramJSONObject.put("retCode", i);
        paramJSONObject.put("errMsg", str);
        while (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIJsService != null)
        {
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIJsService.evaluateCallbackJs(this.jdField_a_of_type_Int, paramJSONObject.toString());
          return;
          paramJSONObject.put("retCode", 2);
          paramJSONObject.put("errMsg", this.jdField_a_of_type_JavaLangString + ":fail " + str + "(" + i + ")");
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
        QLog.d("MiniSDKClientQIPCModule", 1, "createUpdatableMsg error, null jsService");
        return;
      }
    }
    QLog.d("MiniSDKClientQIPCModule", 1, "createUpdatableMsg error, null ret");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxl
 * JD-Core Version:    0.7.0.1
 */
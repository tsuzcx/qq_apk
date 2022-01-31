import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

class arrk
  implements EIPCResultCallback
{
  arrk(arri paramarri) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i = 0;
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(arri.a(this.a))) {
      localJSONObject = new JSONObject();
    }
    try
    {
      if (paramEIPCResult.data.getBoolean("result")) {}
      for (;;)
      {
        localJSONObject.put("result", i);
        this.a.callJs(arri.a(this.a), new String[] { localJSONObject.toString() });
        return;
        i = 1;
      }
      return;
    }
    catch (JSONException paramEIPCResult)
    {
      paramEIPCResult.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrk
 * JD-Core Version:    0.7.0.1
 */
import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

class awmh
  implements EIPCResultCallback
{
  awmh(awmg paramawmg) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i = 0;
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(awmg.a(this.a))) {
      localJSONObject = new JSONObject();
    }
    try
    {
      if (paramEIPCResult.data.getBoolean("result")) {}
      for (;;)
      {
        localJSONObject.put("result", i);
        this.a.callJs(awmg.a(this.a), new String[] { localJSONObject.toString() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmh
 * JD-Core Version:    0.7.0.1
 */
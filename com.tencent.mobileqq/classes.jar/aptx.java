import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1;
import com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.2;
import com.tencent.mobileqq.ark.ArkAppCenter;
import org.json.JSONObject;

public class aptx
  implements aptt
{
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArkAppCenter.a().postToMainThread(new ArkAppSchemeCenter.TelSchemeHandler.1(this, paramString));
  }
  
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    ArkAppCenter.a().send(paramString3, new ArkAppSchemeCenter.TelSchemeHandler.2(this, paramString3, paramString1, paramLong, paramString2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptx
 * JD-Core Version:    0.7.0.1
 */
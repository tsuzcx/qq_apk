import android.text.TextUtils;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import org.json.JSONObject;

public class atjd
  implements spj
{
  public atjd(UiApiPlugin paramUiApiPlugin) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null)) {
      this.a.callJs(paramString, new String[] { paramJSONObject.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjd
 * JD-Core Version:    0.7.0.1
 */
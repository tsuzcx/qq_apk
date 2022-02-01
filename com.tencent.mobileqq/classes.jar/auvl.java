import android.text.TextUtils;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import org.json.JSONObject;

public class auvl
  implements tiu
{
  public auvl(UiApiPlugin paramUiApiPlugin) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null)) {
      this.a.callJs(paramString, new String[] { paramJSONObject.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvl
 * JD-Core Version:    0.7.0.1
 */
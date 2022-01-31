import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bjwm
  extends bjxz
{
  private boolean a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("categoryType");
      paramString = paramString.optString("categoryId");
      Activity localActivity = this.a.mRuntime.a();
      if (localActivity != null)
      {
        bjdt.a(localActivity, this.a.mRuntime.a().getCurrentAccountUin(), i, paramString, -1);
        return true;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("QZoneCategoryAlbumPlugin", 1, paramString.getMessage());
      return false;
    }
    return false;
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {}
    while ((!paramString3.equalsIgnoreCase("jumpCategoryAlbum")) || (paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return false;
    }
    return a(paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjwm
 * JD-Core Version:    0.7.0.1
 */
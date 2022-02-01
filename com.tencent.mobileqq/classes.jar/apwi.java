import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class apwi
  implements apts<String>
{
  public boolean a = true;
  public boolean b = true;
  
  public void a(String paramString)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("ark_app_manage_panel_disable", 1) != 0)
      {
        bool = true;
        this.a = bool;
        aoth.a = this.a;
        if (paramString.optInt("ark_download_by_yyb_disable", 1) == 0) {
          break label115;
        }
      }
      label115:
      for (boolean bool = true;; bool = false)
      {
        this.b = bool;
        aoth.f = this.b;
        QLog.i("ArkMsgAIDisableConfig", 1, "onParse " + ", ark_app_manage_panel_disable=" + this.a + ", ark_download_by_yyb_disable =" + this.b);
        return;
        bool = false;
        break;
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("ArkMsgAIDisableConfig", 1, "handleArkMsgAIDisableConfig parse config_content exception=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apwi
 * JD-Core Version:    0.7.0.1
 */
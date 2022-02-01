import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qflutter.utils.FLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.util.QZLog;
import cooperation.vip.AdvVideoFloat.AdvGerneralProxy;
import org.json.JSONObject;

public class bmkt
  extends bmmk
{
  public String a;
  
  public bmkt()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {}
    Object localObject;
    String str;
    do
    {
      int i;
      do
      {
        for (;;)
        {
          return;
          try
          {
            QZLog.i("AdvFloatVideoJsPlugin", "handleAdvLoadedNotify @advWebview");
            localObject = new JSONObject(paramArrayOfString[0]);
            i = ((JSONObject)localObject).getInt("status");
            paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
            if (paramArrayOfString != null)
            {
              str = (String)paramArrayOfString.getTag(AdvGerneralProxy.getInstance().getFirstKey());
              if (i == 0)
              {
                this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).getString("callback");
                if (QZLog.isColorLevel()) {
                  QZLog.i("AdvFloatVideoJsPlugin", "@advWebview onlykey =" + str);
                }
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { AdvGerneralProxy.getInstance().getCallBackData(str) });
                paramArrayOfString.setTag(AdvGerneralProxy.getInstance().getFourthKey(), this.jdField_a_of_type_JavaLangString);
                return;
              }
            }
          }
          catch (Exception paramArrayOfString)
          {
            QZLog.e("AdvFloatVideoJsPlugin", "handleAdvLoadedNotify eroo" + paramArrayOfString.toString());
            return;
          }
        }
      } while (i != 1);
      localObject = ((JSONObject)localObject).getString("id");
      paramArrayOfString.setTag(AdvGerneralProxy.getInstance().getSecondKey(), Integer.valueOf(1));
    } while (TextUtils.isEmpty((CharSequence)localObject));
    paramArrayOfString = str + "_" + (String)localObject;
    AdvGerneralProxy.getInstance().notifyH5PageReady(paramArrayOfString);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equals("Qzone")) || (paramString3 == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if ((paramString3.equals("AdvLoadedNotify")) && (paramVarArgs.length >= 1))
    {
      QZLog.i("AdvFloatVideoJsPlugin", "AdvLoadedNotify");
      a(paramVarArgs);
      return true;
    }
    if (paramString3.equals("AdvClickBlankArea"))
    {
      QZLog.i("AdvFloatVideoJsPlugin", "AdvClickBlankArea");
      b(paramVarArgs);
      return true;
    }
    if (paramString3.equals("AdvReportVas"))
    {
      QZLog.i("AdvFloatVideoJsPlugin", "AdvReportVas");
      c(paramVarArgs);
      return true;
    }
    return false;
  }
  
  public void b(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {
      return;
    }
    try
    {
      QZLog.i("AdvFloatVideoJsPlugin", "@advWebview handleAdvClickBlankArea");
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).optString("advid");
      AdvGerneralProxy.getInstance().notifyVideoBlankClick(paramArrayOfString);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      FLog.e("AdvFloatVideoJsPlugin", paramArrayOfString.toString());
    }
  }
  
  public void c(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {
      return;
    }
    try
    {
      QZLog.i("AdvFloatVideoJsPlugin", "handleAdvReportVas");
      int i = new JSONObject(paramArrayOfString[0]).optInt("area", -1);
      AdvGerneralProxy.getInstance().notifyOnlyReportClickArea(i);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      FLog.e("AdvFloatVideoJsPlugin", paramArrayOfString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkt
 * JD-Core Version:    0.7.0.1
 */
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.webviewplugin.QZoneGiftFullScreenJsPlugin.1;
import java.io.File;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class bnme
  extends bnnn
  implements bngj
{
  private bmuu jdField_a_of_type_Bmuu;
  private String jdField_a_of_type_JavaLangString = "";
  
  private void a(WebViewPlugin paramWebViewPlugin, bioy parambioy, String[] paramArrayOfString)
  {
    String str;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null)) {
      str = "";
    }
    do
    {
      for (;;)
      {
        try
        {
          parambioy = new JSONObject(paramArrayOfString[0]);
          paramWebViewPlugin = parambioy.getString("giftid");
          parambioy.printStackTrace();
        }
        catch (JSONException parambioy)
        {
          try
          {
            parambioy = parambioy.getString("callback");
            if ((!TextUtils.isEmpty(paramWebViewPlugin)) && (!TextUtils.isEmpty(parambioy))) {
              break;
            }
            return;
          }
          catch (JSONException parambioy)
          {
            for (;;)
            {
              continue;
              int i = 0;
            }
          }
          parambioy = parambioy;
          paramWebViewPlugin = "";
        }
        parambioy = str;
      }
      paramWebViewPlugin = new File(bmur.a(paramWebViewPlugin) + awyq.a());
      if ((!paramWebViewPlugin.exists()) || (!paramWebViewPlugin.isDirectory())) {
        break;
      }
      i = 1;
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null);
    paramWebViewPlugin = "window." + parambioy + "({checkGift:" + i + "})";
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramWebViewPlugin);
  }
  
  private void b(WebViewPlugin paramWebViewPlugin, bioy parambioy, String[] paramArrayOfString)
  {
    parambioy.a().getHandler(bnnh.class).post(new QZoneGiftFullScreenJsPlugin.1(this, paramArrayOfString));
  }
  
  private void c(WebViewPlugin paramWebViewPlugin, bioy parambioy, String[] paramArrayOfString)
  {
    Object localObject;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null)) {
      localObject = "";
    }
    label63:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            parambioy = new JSONObject(paramArrayOfString[0]);
            paramWebViewPlugin = parambioy.getString("giftid");
            parambioy.printStackTrace();
          }
          catch (JSONException parambioy)
          {
            try
            {
              parambioy = parambioy.getString("callback");
              if ((!TextUtils.isEmpty(paramWebViewPlugin)) && (!TextUtils.isEmpty(parambioy))) {
                break;
              }
              return;
            }
            catch (JSONException parambioy)
            {
              break label63;
            }
            parambioy = parambioy;
            paramWebViewPlugin = "";
          }
          parambioy = (bioy)localObject;
        }
        paramArrayOfString = bmur.a(paramWebViewPlugin);
        localObject = new File(paramArrayOfString);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      this.jdField_a_of_type_Bmuu = new bmuu(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a());
    } while (!bmuu.a());
    this.jdField_a_of_type_Bmuu.a(paramWebViewPlugin, paramArrayOfString, new bnmf(this, parambioy));
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.a(paramIntent, paramByte, paramInt);
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"Qzone".equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if ("checkGift".equalsIgnoreCase(paramString3))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("downloadGift".equalsIgnoreCase(paramString3))
    {
      bngf.a().a(this);
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("playGift".equalsIgnoreCase(paramString3))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934601L)
    {
      String str = QzoneConfig.getInstance().getConfig("H5Url", "GiftDetailPage", "https://h5.qzone.qq.com/gift/detail?_wv=2097155&_proxy=1&uin={uin}&ugcid={ugcid}");
      if (!TextUtils.isEmpty(str))
      {
        int i = str.indexOf("?");
        if (i != -1)
        {
          str = str.substring(0, i);
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(str)) && (this.jdField_a_of_type_Bmuu != null)) {
            this.jdField_a_of_type_Bmuu.b();
          }
        }
      }
    }
    return super.a(paramString, paramLong, paramMap);
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    for (;;)
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZoneGiftFullScreenJsPlugin", 2, "call js function,bundle is empty");
        }
      }
      else if ("cmd.downloadGift".equals(paramString))
      {
        int i = paramBundle.getInt("Gift_DownloadProgress_FullScreen");
        paramString = "-1";
        if (i > 0) {
          if (i >= 100) {
            break label155;
          }
        }
        label155:
        for (paramString = String.format("%.1f", new Object[] { Double.valueOf(i * 0.01D) }); (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)); paramString = "1")
        {
          paramString = "window." + this.jdField_a_of_type_JavaLangString + "({downloadGift:" + paramString + "})";
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnme
 * JD-Core Version:    0.7.0.1
 */
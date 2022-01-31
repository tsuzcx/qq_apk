import NS_QMALL_COVER.AlbumThemeSkin;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.webviewplugin.QZonePassivePraiseJsPlugin.1;
import java.io.File;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class bjsq
  extends bjts
  implements bjmq
{
  private bjbf jdField_a_of_type_Bjbf;
  private String jdField_a_of_type_JavaLangString = "";
  
  private void a(WebViewPlugin paramWebViewPlugin, becq parambecq, String[] paramArrayOfString)
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
          parambecq = new JSONObject(paramArrayOfString[0]);
          paramWebViewPlugin = parambecq.getString("zipUrl");
          parambecq.printStackTrace();
        }
        catch (JSONException parambecq)
        {
          try
          {
            parambecq = parambecq.getString("callback");
            if ((!TextUtils.isEmpty(paramWebViewPlugin)) && (!TextUtils.isEmpty(parambecq))) {
              break;
            }
            return;
          }
          catch (JSONException parambecq)
          {
            for (;;)
            {
              continue;
              int i = 0;
            }
          }
          parambecq = parambecq;
          paramWebViewPlugin = "";
        }
        parambecq = str;
      }
      paramWebViewPlugin = paramWebViewPlugin.replace("sbig", atug.a());
      paramWebViewPlugin = new File(bjbc.b(bfhi.d(paramWebViewPlugin)) + atug.a());
      if ((!paramWebViewPlugin.exists()) || (!paramWebViewPlugin.isDirectory())) {
        break;
      }
      i = 1;
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null);
    paramWebViewPlugin = "window." + parambecq + "({checked:" + i + "})";
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramWebViewPlugin);
  }
  
  private void b()
  {
    bjmn.a().a().u();
  }
  
  private void b(WebViewPlugin paramWebViewPlugin, becq parambecq, String[] paramArrayOfString)
  {
    parambecq.a().getHandler(bjtm.class).post(new QZonePassivePraiseJsPlugin.1(this, paramArrayOfString));
  }
  
  private void c(WebViewPlugin paramWebViewPlugin, becq parambecq, String[] paramArrayOfString)
  {
    Object localObject;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null)) {
      localObject = "";
    }
    label56:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            parambecq = new JSONObject(paramArrayOfString[0]);
            paramWebViewPlugin = parambecq.getString("zipUrl");
            parambecq.printStackTrace();
          }
          catch (JSONException parambecq)
          {
            try
            {
              parambecq = parambecq.getString("callback");
              if (!TextUtils.isEmpty(parambecq)) {
                break;
              }
              return;
            }
            catch (JSONException parambecq)
            {
              break label56;
            }
            parambecq = parambecq;
            paramWebViewPlugin = "";
          }
          parambecq = (becq)localObject;
        }
        paramArrayOfString = bjbc.b(bfhi.d(paramWebViewPlugin.replace("sbig", atug.a())));
        localObject = new File(paramArrayOfString);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      this.jdField_a_of_type_Bjbf = new bjbf(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a());
    } while (!bjbf.a());
    this.jdField_a_of_type_Bjbf.a(paramWebViewPlugin, paramArrayOfString, true, new bjsr(this, parambecq));
  }
  
  private void d(WebViewPlugin paramWebViewPlugin, becq parambecq, String[] paramArrayOfString)
  {
    AlbumThemeSkin localAlbumThemeSkin;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null))
    {
      parambecq = "";
      localAlbumThemeSkin = new AlbumThemeSkin();
      paramWebViewPlugin = parambecq;
    }
    for (;;)
    {
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        paramWebViewPlugin = parambecq;
        localAlbumThemeSkin.iItemId = paramArrayOfString.getInt("itemId");
        paramWebViewPlugin = parambecq;
        if (localAlbumThemeSkin.iItemId != -1) {
          continue;
        }
        paramWebViewPlugin = parambecq;
        bjmn.a().a().a(0L, localAlbumThemeSkin);
      }
      catch (JSONException parambecq)
      {
        parambecq.printStackTrace();
        parambecq = paramWebViewPlugin;
        continue;
      }
      if (TextUtils.isEmpty(parambecq)) {}
      return;
      paramWebViewPlugin = parambecq;
      localAlbumThemeSkin.strPicZipUrl = paramArrayOfString.getString("zipurl");
      paramWebViewPlugin = parambecq;
      localAlbumThemeSkin.iColor = paramArrayOfString.getInt("icolor");
      paramWebViewPlugin = parambecq;
      localAlbumThemeSkin.lTabBarSelectedFontColor = paramArrayOfString.getLong("tabBarFontColorSelected");
      paramWebViewPlugin = parambecq;
      localAlbumThemeSkin.lTabBarUnselectedFontColor = paramArrayOfString.getLong("tabBarFontColor");
      paramWebViewPlugin = parambecq;
      localAlbumThemeSkin.lVideoButonColor = paramArrayOfString.getLong("videoButonColor");
      paramWebViewPlugin = parambecq;
      localAlbumThemeSkin.lVideoButtonBgColor = paramArrayOfString.getLong("videoButtonBgColor");
      paramWebViewPlugin = parambecq;
      localAlbumThemeSkin.lTabbarUnderLineColor = paramArrayOfString.getLong("tabbarUnderLineColor");
      paramWebViewPlugin = parambecq;
      bjmn.a().a().a(0L, localAlbumThemeSkin);
      paramWebViewPlugin = parambecq;
      paramArrayOfString = paramArrayOfString.getString("callback");
      parambecq = paramArrayOfString;
      paramWebViewPlugin = paramArrayOfString;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)
      {
        paramWebViewPlugin = paramArrayOfString;
        parambecq = "window." + paramArrayOfString + "({})";
        paramWebViewPlugin = paramArrayOfString;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(parambecq);
        parambecq = paramArrayOfString;
      }
    }
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
    if ("checkAnimationRs".equalsIgnoreCase(paramString3))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("downloadAnimationRs".equalsIgnoreCase(paramString3))
    {
      bjmn.a().a(this);
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("playAnimation".equalsIgnoreCase(paramString3))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("SetAlbumListThemeSkin".equalsIgnoreCase(paramString3))
    {
      d(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
      return true;
    }
    if ("hasClickedHighFiveFromLikeList".equalsIgnoreCase(paramString3))
    {
      b();
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
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(str)) && (this.jdField_a_of_type_Bjbf != null)) {
            this.jdField_a_of_type_Bjbf.b();
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
      else if ("cmd.downloadPassivePraise".equals(paramString))
      {
        int i = paramBundle.getInt("Gift_DownloadProgress_FullScreen");
        paramString = "-1";
        if (i > 0) {
          if (i >= 100) {
            break label163;
          }
        }
        label163:
        for (paramString = String.format("%.1f", new Object[] { Double.valueOf(i * 0.01D) }); (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)); paramString = "1")
        {
          paramString = "window." + this.jdField_a_of_type_JavaLangString + "({download:" + paramString + "})";
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramString);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjsq
 * JD-Core Version:    0.7.0.1
 */
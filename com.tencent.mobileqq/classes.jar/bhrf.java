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

public class bhrf
  extends bhsh
  implements bhlf
{
  private bhac jdField_a_of_type_Bhac;
  private String jdField_a_of_type_JavaLangString = "";
  
  private void a(WebViewPlugin paramWebViewPlugin, bcdp parambcdp, String[] paramArrayOfString)
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
          parambcdp = new JSONObject(paramArrayOfString[0]);
          paramWebViewPlugin = parambcdp.getString("zipUrl");
          parambcdp.printStackTrace();
        }
        catch (JSONException parambcdp)
        {
          try
          {
            parambcdp = parambcdp.getString("callback");
            if ((!TextUtils.isEmpty(paramWebViewPlugin)) && (!TextUtils.isEmpty(parambcdp))) {
              break;
            }
            return;
          }
          catch (JSONException parambcdp)
          {
            for (;;)
            {
              continue;
              int i = 0;
            }
          }
          parambcdp = parambcdp;
          paramWebViewPlugin = "";
        }
        parambcdp = str;
      }
      paramWebViewPlugin = paramWebViewPlugin.replace("sbig", asdg.a());
      paramWebViewPlugin = new File(bgzz.b(bdik.d(paramWebViewPlugin)) + asdg.a());
      if ((!paramWebViewPlugin.exists()) || (!paramWebViewPlugin.isDirectory())) {
        break;
      }
      i = 1;
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null);
    paramWebViewPlugin = "window." + parambcdp + "({checked:" + i + "})";
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramWebViewPlugin);
  }
  
  private void b()
  {
    bhlc.a().a().u();
  }
  
  private void b(WebViewPlugin paramWebViewPlugin, bcdp parambcdp, String[] paramArrayOfString)
  {
    parambcdp.a().getHandler(bhsb.class).post(new QZonePassivePraiseJsPlugin.1(this, paramArrayOfString));
  }
  
  private void c(WebViewPlugin paramWebViewPlugin, bcdp parambcdp, String[] paramArrayOfString)
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
            parambcdp = new JSONObject(paramArrayOfString[0]);
            paramWebViewPlugin = parambcdp.getString("zipUrl");
            parambcdp.printStackTrace();
          }
          catch (JSONException parambcdp)
          {
            try
            {
              parambcdp = parambcdp.getString("callback");
              if (!TextUtils.isEmpty(parambcdp)) {
                break;
              }
              return;
            }
            catch (JSONException parambcdp)
            {
              break label56;
            }
            parambcdp = parambcdp;
            paramWebViewPlugin = "";
          }
          parambcdp = (bcdp)localObject;
        }
        paramArrayOfString = bgzz.b(bdik.d(paramWebViewPlugin.replace("sbig", asdg.a())));
        localObject = new File(paramArrayOfString);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      this.jdField_a_of_type_Bhac = new bhac(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a());
    } while (!bhac.a());
    this.jdField_a_of_type_Bhac.a(paramWebViewPlugin, paramArrayOfString, true, new bhrg(this, parambcdp));
  }
  
  private void d(WebViewPlugin paramWebViewPlugin, bcdp parambcdp, String[] paramArrayOfString)
  {
    AlbumThemeSkin localAlbumThemeSkin;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null))
    {
      parambcdp = "";
      localAlbumThemeSkin = new AlbumThemeSkin();
      paramWebViewPlugin = parambcdp;
    }
    for (;;)
    {
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        paramWebViewPlugin = parambcdp;
        localAlbumThemeSkin.iItemId = paramArrayOfString.getInt("itemId");
        paramWebViewPlugin = parambcdp;
        if (localAlbumThemeSkin.iItemId != -1) {
          continue;
        }
        paramWebViewPlugin = parambcdp;
        bhlc.a().a().a(0L, localAlbumThemeSkin);
      }
      catch (JSONException parambcdp)
      {
        parambcdp.printStackTrace();
        parambcdp = paramWebViewPlugin;
        continue;
      }
      if (TextUtils.isEmpty(parambcdp)) {}
      return;
      paramWebViewPlugin = parambcdp;
      localAlbumThemeSkin.strPicZipUrl = paramArrayOfString.getString("zipurl");
      paramWebViewPlugin = parambcdp;
      localAlbumThemeSkin.iColor = paramArrayOfString.getInt("icolor");
      paramWebViewPlugin = parambcdp;
      localAlbumThemeSkin.lTabBarSelectedFontColor = paramArrayOfString.getLong("tabBarFontColorSelected");
      paramWebViewPlugin = parambcdp;
      localAlbumThemeSkin.lTabBarUnselectedFontColor = paramArrayOfString.getLong("tabBarFontColor");
      paramWebViewPlugin = parambcdp;
      localAlbumThemeSkin.lVideoButonColor = paramArrayOfString.getLong("videoButonColor");
      paramWebViewPlugin = parambcdp;
      localAlbumThemeSkin.lVideoButtonBgColor = paramArrayOfString.getLong("videoButtonBgColor");
      paramWebViewPlugin = parambcdp;
      localAlbumThemeSkin.lTabbarUnderLineColor = paramArrayOfString.getLong("tabbarUnderLineColor");
      paramWebViewPlugin = parambcdp;
      bhlc.a().a().a(0L, localAlbumThemeSkin);
      paramWebViewPlugin = parambcdp;
      paramArrayOfString = paramArrayOfString.getString("callback");
      parambcdp = paramArrayOfString;
      paramWebViewPlugin = paramArrayOfString;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)
      {
        paramWebViewPlugin = paramArrayOfString;
        parambcdp = "window." + paramArrayOfString + "({})";
        paramWebViewPlugin = paramArrayOfString;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(parambcdp);
        parambcdp = paramArrayOfString;
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
      bhlc.a().a(this);
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
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(str)) && (this.jdField_a_of_type_Bhac != null)) {
            this.jdField_a_of_type_Bhac.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhrf
 * JD-Core Version:    0.7.0.1
 */
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

public class bjwx
  extends bjxz
  implements bjqx
{
  private bjfm jdField_a_of_type_Bjfm;
  private String jdField_a_of_type_JavaLangString = "";
  
  private void a(WebViewPlugin paramWebViewPlugin, begz parambegz, String[] paramArrayOfString)
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
          parambegz = new JSONObject(paramArrayOfString[0]);
          paramWebViewPlugin = parambegz.getString("zipUrl");
          parambegz.printStackTrace();
        }
        catch (JSONException parambegz)
        {
          try
          {
            parambegz = parambegz.getString("callback");
            if ((!TextUtils.isEmpty(paramWebViewPlugin)) && (!TextUtils.isEmpty(parambegz))) {
              break;
            }
            return;
          }
          catch (JSONException parambegz)
          {
            for (;;)
            {
              continue;
              int i = 0;
            }
          }
          parambegz = parambegz;
          paramWebViewPlugin = "";
        }
        parambegz = str;
      }
      paramWebViewPlugin = paramWebViewPlugin.replace("sbig", atyp.a());
      paramWebViewPlugin = new File(bjfj.b(bflr.d(paramWebViewPlugin)) + atyp.a());
      if ((!paramWebViewPlugin.exists()) || (!paramWebViewPlugin.isDirectory())) {
        break;
      }
      i = 1;
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null);
    paramWebViewPlugin = "window." + parambegz + "({checked:" + i + "})";
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramWebViewPlugin);
  }
  
  private void b()
  {
    bjqu.a().a().u();
  }
  
  private void b(WebViewPlugin paramWebViewPlugin, begz parambegz, String[] paramArrayOfString)
  {
    parambegz.a().getHandler(bjxt.class).post(new QZonePassivePraiseJsPlugin.1(this, paramArrayOfString));
  }
  
  private void c(WebViewPlugin paramWebViewPlugin, begz parambegz, String[] paramArrayOfString)
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
            parambegz = new JSONObject(paramArrayOfString[0]);
            paramWebViewPlugin = parambegz.getString("zipUrl");
            parambegz.printStackTrace();
          }
          catch (JSONException parambegz)
          {
            try
            {
              parambegz = parambegz.getString("callback");
              if (!TextUtils.isEmpty(parambegz)) {
                break;
              }
              return;
            }
            catch (JSONException parambegz)
            {
              break label56;
            }
            parambegz = parambegz;
            paramWebViewPlugin = "";
          }
          parambegz = (begz)localObject;
        }
        paramArrayOfString = bjfj.b(bflr.d(paramWebViewPlugin.replace("sbig", atyp.a())));
        localObject = new File(paramArrayOfString);
      } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
      this.jdField_a_of_type_Bjfm = new bjfm(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a());
    } while (!bjfm.a());
    this.jdField_a_of_type_Bjfm.a(paramWebViewPlugin, paramArrayOfString, true, new bjwy(this, parambegz));
  }
  
  private void d(WebViewPlugin paramWebViewPlugin, begz parambegz, String[] paramArrayOfString)
  {
    AlbumThemeSkin localAlbumThemeSkin;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0] != null))
    {
      parambegz = "";
      localAlbumThemeSkin = new AlbumThemeSkin();
      paramWebViewPlugin = parambegz;
    }
    for (;;)
    {
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        paramWebViewPlugin = parambegz;
        localAlbumThemeSkin.iItemId = paramArrayOfString.getInt("itemId");
        paramWebViewPlugin = parambegz;
        if (localAlbumThemeSkin.iItemId != -1) {
          continue;
        }
        paramWebViewPlugin = parambegz;
        bjqu.a().a().a(0L, localAlbumThemeSkin);
      }
      catch (JSONException parambegz)
      {
        parambegz.printStackTrace();
        parambegz = paramWebViewPlugin;
        continue;
      }
      if (TextUtils.isEmpty(parambegz)) {}
      return;
      paramWebViewPlugin = parambegz;
      localAlbumThemeSkin.strPicZipUrl = paramArrayOfString.getString("zipurl");
      paramWebViewPlugin = parambegz;
      localAlbumThemeSkin.iColor = paramArrayOfString.getInt("icolor");
      paramWebViewPlugin = parambegz;
      localAlbumThemeSkin.lTabBarSelectedFontColor = paramArrayOfString.getLong("tabBarFontColorSelected");
      paramWebViewPlugin = parambegz;
      localAlbumThemeSkin.lTabBarUnselectedFontColor = paramArrayOfString.getLong("tabBarFontColor");
      paramWebViewPlugin = parambegz;
      localAlbumThemeSkin.lVideoButonColor = paramArrayOfString.getLong("videoButonColor");
      paramWebViewPlugin = parambegz;
      localAlbumThemeSkin.lVideoButtonBgColor = paramArrayOfString.getLong("videoButtonBgColor");
      paramWebViewPlugin = parambegz;
      localAlbumThemeSkin.lTabbarUnderLineColor = paramArrayOfString.getLong("tabbarUnderLineColor");
      paramWebViewPlugin = parambegz;
      bjqu.a().a().a(0L, localAlbumThemeSkin);
      paramWebViewPlugin = parambegz;
      paramArrayOfString = paramArrayOfString.getString("callback");
      parambegz = paramArrayOfString;
      paramWebViewPlugin = paramArrayOfString;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin != null)
      {
        paramWebViewPlugin = paramArrayOfString;
        parambegz = "window." + paramArrayOfString + "({})";
        paramWebViewPlugin = paramArrayOfString;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(parambegz);
        parambegz = paramArrayOfString;
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
      bjqu.a().a(this);
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
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(str)) && (this.jdField_a_of_type_Bjfm != null)) {
            this.jdField_a_of_type_Bjfm.b();
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
 * Qualified Name:     bjwx
 * JD-Core Version:    0.7.0.1
 */
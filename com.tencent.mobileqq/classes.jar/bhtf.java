import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneHardwareRestriction;
import org.json.JSONException;
import org.json.JSONObject;

public class bhtf
  extends bhsh
{
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("qzone_detail_sp", 4);
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      if (paramInt != -1) {
        LpReportInfo_pf00064.allReport(593, 2, paramInt);
      }
      return;
      paramInt = 8;
      continue;
      paramInt = 7;
      continue;
      paramInt = 9;
    }
  }
  
  private void a(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i == 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { "handleSetInteractSoundMode: json error " + paramArrayOfString[0], paramWebViewPlugin });
        continue;
      }
      QLog.i("QzoneSettingJsPlugin", 4, "handleSetInteractSoundMode: " + bool);
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("qzone_sound_effect_enabled", bool).apply();
      return;
      bool = false;
    }
  }
  
  public static boolean a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      b = QzoneHardwareRestriction.meetHardwareRestriction(1, 1);
      jdField_a_of_type_Boolean = true;
    }
    return b;
  }
  
  private boolean a(JsBridgeListener paramJsBridgeListener, WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramJsBridgeListener = paramWebViewPlugin.mRuntime.a();
    } while ((paramJsBridgeListener == null) || (paramJsBridgeListener.isFinishing()));
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfString[0]);
      int i = localJSONObject.optInt("iconID");
      paramJsBridgeListener = localJSONObject.optString("title");
      paramArrayOfString = localJSONObject.optString("callback");
      boolean bool = localJSONObject.optBoolean("hidden");
      localJSONObject.optBoolean("disable");
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a(paramWebViewPlugin.mRuntime.a());
      if ((paramWebViewPlugin != null) && ((paramWebViewPlugin instanceof bcii))) {
        ((bcii)paramWebViewPlugin).a(paramArrayOfString, paramJsBridgeListener, null, bool, i + 1000, 0, null, null);
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      label133:
      break label133;
    }
    return true;
  }
  
  private boolean a(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_feed_custom_browser_deco_switch", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({enable:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---customBrowserInfoSwitch-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private void b(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    i = 1;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = paramWebViewPlugin.mRuntime.a();
      } while ((localObject == null) || (((Activity)localObject).isFinishing()));
      try
      {
        localObject = new JSONObject(paramArrayOfString[0]).getString("callback");
        paramArrayOfString = (String[])localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          boolean bool;
          QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { "handleGetInteractSoundMode: json error " + paramArrayOfString[0], localJSONException });
          paramArrayOfString = null;
          continue;
          i = 0;
        }
      }
    } while (paramArrayOfString == null);
    bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("qzone_sound_effect_enabled", false);
    if (bool)
    {
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "handleGetInteractSoundMode: " + bool);
      return;
    }
  }
  
  private boolean b(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("enable");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      bhlc.a().a().c(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---notifyCustomBrowserChanged-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private void c(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = paramWebViewPlugin.mRuntime.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    try
    {
      int i = new JSONObject(paramArrayOfString[0]).getInt("value");
      if (i != 0) {
        bool = true;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        long l;
        QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { "handleSetWaterMark: json error " + paramArrayOfString[0], localJSONException });
        bool = true;
      }
    }
    l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    QLog.i("QzoneSettingJsPlugin", 1, "handleSetWaterMark: " + bool + " uin:" + l);
    LocalMultiProcConfig.putBool("Qzone_multi_setting", "WaterMark_" + l, bool);
    LocalMultiProcConfig.putBool("QZ_setting", "WaterMark_" + l, bool);
  }
  
  private boolean c(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_barrage_effect_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowCommentBubbleGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private void d(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      do
      {
        return;
        localActivity = paramWebViewPlugin.mRuntime.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      Activity localActivity = null;
      try
      {
        String str = new JSONObject(paramArrayOfString[0]).getString("callback");
        paramArrayOfString = str;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          long l;
          QZLog.w("QzoneSettingJsPlugin", 4, new Object[] { "handleGetWaterMark: json error " + paramArrayOfString[0], localJSONException });
          paramArrayOfString = localActivity;
          continue;
          boolean bool = LocalMultiProcConfig.getBool("QZ_setting", "WaterMark_" + l, false);
        }
      }
    } while (paramArrayOfString == null);
    l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    if (LocalMultiProcConfig.containKey("Qzone_multi_setting", "WaterMark_" + l))
    {
      bool = LocalMultiProcConfig.getBool("Qzone_multi_setting", "WaterMark_" + l, false);
      QLog.i("QzoneSettingJsPlugin", 1, "use new key");
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 1, "handleGetWaterMark: " + bool + " uin:" + l);
      return;
    }
  }
  
  private boolean d(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      bhlc.a().a().b(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowCommentBubbleSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean e(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = paramWebViewPlugin.mRuntime.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    long l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        continue;
      }
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowQzoneRemindfeedSetting-:" + bool);
      LocalMultiProcConfig.putBooleanAsync(localActivity.getString(2131718858) + l, bool);
      return true;
      bool = true;
    }
  }
  
  private boolean f(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return false;
      localActivity = paramWebViewPlugin.mRuntime.a();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    long l = paramWebViewPlugin.mRuntime.a().getLongAccountUin();
    paramWebViewPlugin = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      paramWebViewPlugin = paramArrayOfString;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        boolean bool;
        paramArrayOfString.printStackTrace();
      }
    }
    bool = LocalMultiProcConfig.getBool(localActivity.getString(2131718858) + l, true);
    if (bool) {
      i = 1;
    }
    paramWebViewPlugin = "window." + paramWebViewPlugin + "({new_value:" + i + "})";
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramWebViewPlugin);
    QLog.i("QzoneSettingJsPlugin", 4, "---handleShowQzoneRemindfeedGet-:" + bool);
    return true;
  }
  
  private boolean g(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    try
    {
      int j = new JSONObject(paramArrayOfString[0]).getInt("new_value");
      i = j;
      a(j);
      i = j;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
    QLog.i("QzoneSettingJsPlugin", 4, "---handleVideoPlayModeSetting-:" + i);
    LocalMultiProcConfig.putInt("QZ_setting", "Qzone_playMode", i);
    paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.VideoPlaySetting"));
    return true;
  }
  
  private boolean h(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    Object localObject = paramWebViewPlugin.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return false;
    }
    localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      if (!LocalMultiProcConfig.getBool("QZ_setting", "Qzone_setVideoplay", true))
      {
        i = 2;
        LocalMultiProcConfig.putBool("QZ_setting", "Qzone_setVideoplay", true);
        paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
        QLog.i("QzoneSettingJsPlugin", 4, "---handleVideoPlayModeGet-:" + i);
        return true;
      }
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
        continue;
        int i = LocalMultiProcConfig.getInt("QZ_setting", "Qzone_playMode", 0);
      }
    }
  }
  
  @Deprecated
  private boolean i(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        bool = true;
        continue;
      }
      QLog.i("QzoneSettingJsPlugin", 4, "---handleGifPlayModeSetting-:" + bool);
      LocalMultiProcConfig.putBool("QZ_setting", "Qzone_playMode", bool);
      paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.GifPlaySetting"));
      return true;
      bool = true;
    }
  }
  
  private boolean j(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("QZ_setting", "Qzone_playMode", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleGifPlayModeGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean k(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    try
    {
      int j = new JSONObject(paramArrayOfString[0]).getInt("new_value");
      i = j;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
      }
    }
    paramWebViewPlugin.sendBroadcast(new Intent("com.tencent.qq.syncNoPhotoSetting"));
    QLog.i("QzoneSettingJsPlugin", 4, "---handlePictureModeSetting-:" + i);
    LocalMultiProcConfig.putInt(paramWebViewPlugin.getResources().getString(2131718871), i);
    return true;
  }
  
  private boolean l(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    Activity localActivity = paramWebViewPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return false;
    }
    String str = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      int i = LocalMultiProcConfig.getInt(localActivity.getResources().getString(2131718871), 0);
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handlePictureModeGet-:" + i);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = str;
      }
    }
  }
  
  private boolean m(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      bhlc.a().a().a(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowFontSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean n(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_font_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowFontGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean o(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("new_value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      bhlc.a().a().d(bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowSparkleFontSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean p(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_super_font_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({new_value:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowSparkleFontGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean q(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      if (a()) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({enable:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleIsSupportParticleEffect-:" + i);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean r(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_passive_praise_enabled", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({isOpen:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handlePassivePraiseGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean s(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      LocalMultiProcConfig.putBool("qzone_passive_praise_enabled", bool);
      QLog.i("QzoneSettingJsPlugin", 4, "---handleShowSparkleFontSetting-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean t(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramArrayOfString[0]).getInt("value");
        if (i != 0) {
          continue;
        }
      }
      catch (JSONException paramWebViewPlugin)
      {
        paramWebViewPlugin.printStackTrace();
        bool = true;
        continue;
      }
      LocalMultiProcConfig.putBool("qzone_feed_skin_enable", bool);
      bhlc.a().a().a();
      QLog.i("QzoneSettingJsPlugin", 4, "---handlefeedSkinEnable-:" + bool);
      return true;
      bool = true;
    }
  }
  
  private boolean u(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      localObject = paramWebViewPlugin.mRuntime.a();
    } while ((localObject == null) || (((Activity)localObject).isFinishing()));
    Object localObject = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).getString("callback");
      boolean bool = LocalMultiProcConfig.getBool("qzone_feed_skin_enable", true);
      if (bool) {
        i = 1;
      }
      paramWebViewPlugin.callJs("window." + paramArrayOfString + "({isOpen:" + i + "})");
      QLog.i("QzoneSettingJsPlugin", 4, "---handleFeedSkinGet-:" + bool);
      return true;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
      }
    }
  }
  
  private boolean v(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    bhlc.a().a().a(paramArrayOfString[0]);
    QLog.i("QzoneSettingJsPlugin", 4, "---handleUpdateCustomPraise-:" + paramArrayOfString[0]);
    return true;
  }
  
  private boolean w(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      return false;
      paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    } while ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing()));
    bhlc.a().a().b(paramArrayOfString[0]);
    QLog.i("QzoneSettingJsPlugin", 4, "---handleUpdatePloymorphicPraise-:" + paramArrayOfString[0]);
    return true;
  }
  
  private boolean x(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    paramWebViewPlugin = paramWebViewPlugin.mRuntime.a();
    if ((paramWebViewPlugin == null) || (paramWebViewPlugin.isFinishing())) {
      return false;
    }
    bhlc.a().a().b();
    QLog.i("QzoneSettingJsPlugin", 4, "---handleUpdateFontList-:");
    return true;
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("setShowRemindfeed"))
    {
      e(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setVideoPlayMode"))
    {
      g(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setGifPlayMode"))
    {
      i(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setPictureMode"))
    {
      k(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowFont"))
    {
      m(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getPictureMode"))
    {
      l(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowRemindfeed"))
    {
      f(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getVideoPlayMode"))
    {
      h(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getGifPlayMode"))
    {
      j(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowFont"))
    {
      n(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowSparkleFont"))
    {
      o(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowSparkleFont"))
    {
      p(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setShowCommentBubble"))
    {
      d(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getShowCommentBubble"))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setPassivePraiseSwitch"))
    {
      s(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getPassivePraiseSwitch"))
    {
      r(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("isSupportParticleEffect"))
    {
      q(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("updateCustomPraise"))
    {
      v(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setRightButton"))
    {
      a(paramJsBridgeListener, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setFeedSkinSwitch"))
    {
      t(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getFeedSkinSwitch"))
    {
      u(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("updatePloymorphicPraise"))
    {
      w(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("updateFontList"))
    {
      x(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getCustomBrowseInfoSwitch"))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("enableCustomBrowseInfo"))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setInteractSoundMode"))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getInteractSoundMode"))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("getWaterMark"))
    {
      d(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("setWaterMark"))
    {
      c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhtf
 * JD-Core Version:    0.7.0.1
 */
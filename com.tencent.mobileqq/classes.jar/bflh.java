import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import cooperation.qqreader.QRBridgeUtil;
import cooperation.qqreader.QRPluginProxyActivity;
import cooperation.qqreader.ui.ReaderContentPageActivity;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import mqq.app.AppRuntime;

public final class bflh
{
  public static Intent a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QRPluginProxyActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtras(paramActivity.getIntent());
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("readerDpcConfig", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|0|0|0|0|0"));
    return localIntent;
  }
  
  private static Intent a(Activity paramActivity, Intent paramIntent)
  {
    boolean bool = false;
    String str = paramIntent.getStringExtra("readtype");
    int j = -1;
    int i;
    if (paramIntent.hasExtra("key_params_qq"))
    {
      i = 502;
      label26:
      str = paramIntent.getStringExtra("stay");
      if (!TextUtils.isEmpty(str)) {
        break label240;
      }
      paramIntent.putExtra("is_from_splashactivity", false);
    }
    for (;;)
    {
      for (;;)
      {
        switch (i)
        {
        default: 
          paramActivity = new Intent(paramActivity, ReaderHomePageActivity.class);
          paramActivity.putExtras(c(paramIntent));
          paramActivity.putExtras(paramIntent);
          return paramActivity;
          if (paramIntent.getBooleanExtra("is_from_qreader_shortcut", false))
          {
            i = 501;
            break label26;
          }
          i = j;
          if (TextUtils.isEmpty(str)) {
            break label26;
          }
          try
          {
            i = Integer.valueOf(str).intValue();
          }
          catch (NumberFormatException localNumberFormatException)
          {
            bfne.d("QRJumpAction", localNumberFormatException.toString());
            i = j;
          }
        }
      }
      break;
      label240:
      if (!"1".equals(localNumberFormatException)) {
        bool = true;
      }
      paramIntent.putExtra("is_from_splashactivity", bool);
    }
    paramIntent.putExtra("openBookDetailByBid", paramIntent.getStringExtra("id"));
    paramIntent.putExtra("openBookDetailByNBid", paramIntent.getStringExtra("nbid"));
    paramIntent.putExtra("item_type", 2);
    paramActivity = new Intent(paramActivity, ReaderContentPageActivity.class);
    paramActivity.putExtras(paramIntent);
    return paramActivity;
    paramIntent.putExtra("tab_index", Integer.valueOf(paramIntent.getStringExtra("column")).intValue());
    paramActivity = new Intent(paramActivity, ReaderHomePageActivity.class);
    paramActivity.putExtras(c(paramIntent));
    paramActivity.putExtras(paramIntent);
    return paramActivity;
    paramIntent.putExtra("url", bfnj.b(a(paramIntent.getStringExtra("url"))));
    paramIntent.putExtra("item_type", 2);
    paramActivity = new Intent(paramActivity, ReaderContentPageActivity.class);
    paramActivity.putExtras(a(paramIntent));
    paramActivity.putExtras(paramIntent);
    return paramActivity;
    paramIntent.putExtra("item_type", 3);
    paramIntent.putExtra("webview_hide_progress", true);
    paramActivity = new Intent(paramActivity, ReaderContentPageActivity.class);
    paramActivity.putExtras(paramIntent);
    return paramActivity;
    paramIntent.putExtra("openMoreState", true);
    paramIntent.putExtra("item_type", 2);
    paramIntent.putExtra("com.qq.reader.WebContent.bookshelf", 100001);
    paramActivity = new Intent(paramActivity, ReaderContentPageActivity.class);
    paramActivity.putExtras(paramIntent);
    return paramActivity;
    paramIntent.putExtra("ChannelID", "100314");
    paramActivity = new Intent(paramActivity, ReaderHomePageActivity.class);
    paramActivity.putExtras(c(paramIntent));
    paramActivity.putExtra("key_is_from_splash_activity", true);
    paramActivity.putExtras(paramIntent);
    return paramActivity;
    paramActivity = new Intent(paramActivity, ReaderHomePageActivity.class);
    paramActivity.putExtras(c(paramIntent));
    paramActivity.putExtra("key_is_from_splash_activity", true);
    paramActivity.putExtras(paramIntent);
    return paramActivity;
  }
  
  @NonNull
  public static Intent a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    if ((paramActivity == null) || (paramIntent == null) || (TextUtils.isEmpty(paramString)))
    {
      bfne.d("QRJumpAction", "jumpAction args error");
      return new Intent();
    }
    return a(paramActivity, a(paramIntent, paramString));
  }
  
  public static Intent a(Intent paramIntent)
  {
    return a(paramIntent, 2);
  }
  
  private static Intent a(Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("item_type", paramInt);
    localIntent.putExtra("fragmentStyle", 4);
    localIntent.putExtra("tabBarStyle", 2);
    localIntent.putExtra("titleBarStyle", 3);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("isScreenOrientationPortrait", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    return localIntent;
  }
  
  private static Intent a(Intent paramIntent, String paramString)
  {
    int i = 0;
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramIntent.putExtra("launch_by_splash", true);
    paramIntent.putExtra("isFromSplashActivityToCloseQRbridge", true);
    if ((paramIntent.hasExtra("is_from_leba")) && (paramIntent.getBooleanExtra("is_from_leba", false))) {}
    for (;;)
    {
      paramIntent.putExtra("from_where", i);
      paramIntent.putExtra("params_remote_connect_at_launch", true);
      return paramIntent;
      if ((paramIntent.hasExtra("is_from_webview")) && (paramIntent.getBooleanExtra("is_from_webview", false))) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("/46")) {
        str = paramString.replaceAll("/46", "&");
      }
    }
    return str;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    if ((!QRBridgeUtil.isPluginReady()) || (paramActivity == null) || (paramIntent == null) || (TextUtils.isEmpty(paramString)))
    {
      bfne.d("QRJumpAction", "jumpToPlugin args error");
      return;
    }
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    bfdi localbfdi = new bfdi(1);
    localbfdi.b = "qqreaderplugin.apk";
    localbfdi.d = ajjy.a(2131645409);
    localbfdi.jdField_a_of_type_JavaLangString = str;
    localbfdi.e = paramString;
    localbfdi.jdField_a_of_type_JavaLangClass = QRPluginProxyActivity.a(paramString);
    paramIntent.putExtra("userQqResources", 2);
    localbfdi.jdField_a_of_type_AndroidContentIntent = paramIntent;
    paramIntent = beyp.a(1);
    if (paramIntent != null)
    {
      paramIntent.a();
      localbfdi.jdField_a_of_type_Aqdz = paramIntent.jdField_a_of_type_Aqdz;
    }
    try
    {
      bfcz.a(paramActivity, localbfdi);
      return;
    }
    catch (Exception paramActivity)
    {
      bfne.d("QRJumpAction", paramActivity.toString());
    }
  }
  
  public static Intent b(Intent paramIntent)
  {
    return a(paramIntent, 4);
  }
  
  public static Intent c(Intent paramIntent)
  {
    return a(paramIntent, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflh
 * JD-Core Version:    0.7.0.1
 */
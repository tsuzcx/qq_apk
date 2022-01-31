import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.6;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class bhsr
  extends bhsh
{
  private static String b = "";
  long jdField_a_of_type_Long = 0L;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bhss(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private bbgu jdField_a_of_type_Bbgu;
  private String jdField_a_of_type_JavaLangString;
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    } while (localCustomWebView == null);
    localCustomWebView.callJs("window.QZQunRedPointInterface.onReceive({data:" + paramInt + "});");
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (paramBoolean) {
      return;
    }
    if (paramInt2 > 0)
    {
      String str = "";
      if (paramInt1 > 0)
      {
        str = String.format(localActivity.getString(2131718153), new Object[] { Integer.valueOf(paramInt1) }) + "，";
        str = str + paramString + ajya.a(2131712293);
      }
      paramString = str + String.format(localActivity.getString(2131718146), new Object[] { Integer.valueOf(paramInt2) });
      bbdj.a(localActivity, 232).setMessage(paramString).setNegativeButton(2131718151, new bhsy(this)).show();
      return;
    }
    bdis.a().a(localActivity.getString(2131718154) + paramString + ajya.a(2131712292));
  }
  
  private void a(String paramString)
  {
    bhlc.a().a().d(paramString);
  }
  
  private void a(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunDetailDelete ");
    }
    try
    {
      paramVarArgs = new Intent("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().sendBroadcast(paramVarArgs);
      return;
    }
    catch (Exception paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunDetailDelete exception:" + paramVarArgs);
    }
  }
  
  private boolean a()
  {
    return SDCardMountMonitorReceiver.a().b();
  }
  
  private void b()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.qq.syncQunMsg");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("QzoneQunFeedJsPlugin", 1, "registerUnreadMsgReceiver----", localException);
    }
  }
  
  private void b(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunJumpDetail " + paramVarArgs[0]);
      }
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]).getString("url");
        Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), QQBrowserDelegationActivity.class);
        localIntent.putExtra("url", paramVarArgs);
        localIntent.putExtra("fromQZone", true);
        localIntent.putExtra("injectrecommend", true);
        if (bcds.a.containsKey("Qzone")) {
          localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
        }
        localIntent.putExtra("source_name", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getString(2131717954));
        localIntent.setData(Uri.parse(paramVarArgs));
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.startActivityForResult(localIntent, (byte)0);
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunJumpDetail,decode param error");
  }
  
  private void c(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, "handleStartQunRedPointNotify " + paramVarArgs[0]);
      }
      try
      {
        int i = new JSONObject(paramVarArgs[0]).getInt("groupCode");
        i = bbdd.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount(), "troop_photo_message", String.valueOf(i));
        if (QLog.isDevelopLevel()) {
          QLog.d("QzoneQunFeedJsPlugin", 4, "handleStartQunRedPointNotify data=" + i);
        }
        a(i);
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleStartQunRedPointNotify,decode param error");
  }
  
  private void d(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleEndQunRedPointNotify");
    }
  }
  
  private void e(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleHideTopicComment");
    }
  }
  
  private void f(String... paramVarArgs)
  {
    int i = 1;
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupUploadPhoto " + paramVarArgs[0]);
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      long l = ((JSONObject)localObject).getLong("groupCode");
      paramVarArgs = ((JSONObject)localObject).optString("albumid");
      localObject = ((JSONObject)localObject).optString("albumname");
      String str = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount();
      if (!TextUtils.isEmpty(paramVarArgs)) {
        i = 2;
      }
      bgyp.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), str, i, 1, l, "", paramVarArgs, (String)localObject, 7001, 43);
      return;
    }
    catch (Exception paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
    }
  }
  
  private void g(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupUploadPhoto " + paramVarArgs[0]);
    }
    try
    {
      Object localObject = new JSONObject(paramVarArgs[0]);
      int i = ((JSONObject)localObject).getInt("groupCode");
      paramVarArgs = ((JSONObject)localObject).optString("albumid");
      localObject = ((JSONObject)localObject).optString("albumname");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount();
      ChatHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), String.valueOf(i), paramVarArgs, (String)localObject);
      return;
    }
    catch (Exception paramVarArgs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleImportGroupAio,decode param error");
    }
  }
  
  private void h(String... paramVarArgs)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupUploadPhoto " + paramVarArgs[0]);
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 2000L) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleShowPhotoList too many return " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    do
    {
      return;
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        int i = ((JSONObject)localObject2).getInt("groupID");
        paramVarArgs = ((JSONObject)localObject2).optString("albumID");
        Object localObject5 = ((JSONObject)localObject2).optString("photoID");
        Object localObject4 = ((JSONObject)localObject2).optString("uin");
        Object localObject3 = ((JSONObject)localObject2).optString("bigurl");
        long l = ((JSONObject)localObject2).optLong("uin");
        int j = ((JSONObject)localObject2).optInt("isVideo");
        int k = ((JSONObject)localObject2).optInt("orgVideoSize");
        int m = ((JSONObject)localObject2).optInt("videoWidth");
        int n = ((JSONObject)localObject2).optInt("videoHeight");
        Object localObject1 = ((JSONObject)localObject2).optString("videoURL");
        String str = ((JSONObject)localObject2).optString("videoID");
        localObject2 = bgyw.a();
        ((bgyw)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject4);
        localObject4 = new Bundle();
        ArrayList localArrayList = new ArrayList();
        PhotoInfo localPhotoInfo = new PhotoInfo();
        localPhotoInfo.d = ((String)localObject3);
        localPhotoInfo.c = l;
        localPhotoInfo.b = paramVarArgs;
        localPhotoInfo.i = ((String)localObject5);
        localPhotoInfo.t = i;
        localPhotoInfo.q = j;
        localPhotoInfo.a = new VideoInfo();
        localPhotoInfo.a.jdField_a_of_type_JavaLangString = str;
        localObject5 = new PictureUrl();
        ((PictureUrl)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject3);
        localPhotoInfo.a.d = ((PictureUrl)localObject5);
        localObject3 = new VideoUrl();
        ((VideoUrl)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
        localPhotoInfo.a.jdField_a_of_type_Long = k;
        localPhotoInfo.a.jdField_a_of_type_JavaLangString = str;
        localPhotoInfo.a.b = ((String)localObject1);
        localPhotoInfo.a.jdField_a_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)localObject3);
        localPhotoInfo.a.g = m;
        localPhotoInfo.a.h = n;
        localPhotoInfo.a.f = 5;
        localArrayList.add(localPhotoInfo);
        localObject1 = new PhotoParam();
        ((PhotoParam)localObject1).b = paramVarArgs;
        ((PhotoParam)localObject1).g = paramVarArgs;
        ((Bundle)localObject4).putSerializable("picturelist", localArrayList);
        ((Bundle)localObject4).putInt("curindex", 0);
        ((Bundle)localObject4).putInt("mode", 13);
        ((Bundle)localObject4).putBoolean("need_clear_cache", true);
        bgyp.c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), (bgyw)localObject2, (Bundle)localObject4, 6);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
  }
  
  private void i(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunDownloadPhoto " + paramVarArgs[0]);
    }
    new Intent().putExtra("photos", paramVarArgs[0]);
    bhlc.a().a(new bhst(this, paramVarArgs));
    if (!a())
    {
      bdis.a().a(ajya.a(2131712291));
      return;
    }
    if (!NetworkState.isNetSupport())
    {
      bdis.a().a(ajya.a(2131712288));
      return;
    }
    if (!NetworkState.isWifiConn())
    {
      Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
      bbdj.a(localActivity, 230).setTitle(localActivity.getString(2131718150)).setMessage(localActivity.getString(2131718152)).setPositiveButton(localActivity.getString(2131718149), new bhsx(this, paramVarArgs)).setNegativeButton(localActivity.getString(2131718148), new bhsw(this)).show();
      return;
    }
    a(paramVarArgs[0]);
  }
  
  private void j(String... paramVarArgs)
  {
    int i = 4;
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneQunFeedJsPlugin", 4, "handleGroupQuote " + paramVarArgs[0]);
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramVarArgs[0]);
        int j = ((JSONObject)localObject).getInt("groupCode");
        paramVarArgs = ((JSONObject)localObject).optString("albumid");
        localObject = ((JSONObject)localObject).optString("albumname");
        String str = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount();
        if (TextUtils.isEmpty(paramVarArgs)) {
          break label155;
        }
        bgyp.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), str, i, 4, j, "", paramVarArgs, (String)localObject, 7001, 43);
        return;
      }
      catch (Exception paramVarArgs) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("QzoneQunFeedJsPlugin", 2, "handleGroupUploadPhoto,decode param error");
      return;
      label155:
      i = 3;
    }
  }
  
  private void k(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      for (;;)
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunDidPickAlbum " + paramVarArgs[0]);
        }
        try
        {
          Object localObject = new JSONObject(paramVarArgs[0]);
          paramVarArgs = ((JSONObject)localObject).getString("albumid");
          String str = ((JSONObject)localObject).optString("albumname");
          localObject = new Intent();
          Bundle localBundle = new Bundle();
          localBundle.putString("UploadPhoto.key_album_id", paramVarArgs);
          localBundle.putString("UploadPhoto.key_album_name", str);
          ((Intent)localObject).putExtras(localBundle);
          paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a();
          if ((paramVarArgs != null) && (!paramVarArgs.isFinishing()))
          {
            paramVarArgs.setResult(-1, (Intent)localObject);
            paramVarArgs.finish();
            return;
          }
        }
        catch (Exception paramVarArgs) {}
      }
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunDidPickAlbum,decode param error");
  }
  
  private void l(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, "handleQunPickQzoneAlbum " + paramVarArgs[0]);
      }
      try
      {
        b = new JSONObject(paramVarArgs[0]).getString("callback");
        paramVarArgs = new Bundle();
        paramVarArgs.putInt("key_personal_album_enter_model", 0);
        paramVarArgs.putBoolean("key_pass_result_by_bundle", true);
        bgyw localbgyw = bgyw.a();
        localbgyw.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getCurrentAccountUin();
        paramVarArgs.putBoolean("key_need_change_to_jpg", true);
        bgyp.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), localbgyw, paramVarArgs, bgyp.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, 6));
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.w("QzoneQunFeedJsPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      SDCardMountMonitorReceiver.a().b();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(b)) || (paramIntent == null));
      String str1 = paramIntent.getStringExtra("key_selected_albuminfo.id");
      String str2 = paramIntent.getStringExtra("key_selected_albuminfo.name");
      String str3 = paramIntent.getStringExtra("key_selected_albuminfo.cover");
      paramByte = paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
      paramIntent = new StringBuilder();
      paramIntent.append("{albumid:\"").append(str1).append("\",albumname:\"").append(str2).append("\",albumcover:\"").append(str3).append("\",albumpermission:").append(paramByte).append("}");
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneQunFeedJsPlugin", 4, paramIntent.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(b, new String[] { paramIntent.toString() });
      return;
    } while (paramInt != -1);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QzoneQunFeedJsPlugin.6(this), 2000L);
  }
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    super.a(paramWebViewPlugin);
    b();
    SDCardMountMonitorReceiver.a().a();
    if ((paramWebViewPlugin != null) && (paramWebViewPlugin.mRuntime != null) && (paramWebViewPlugin.mRuntime.a() != null)) {
      paramWebViewPlugin.mRuntime.a().setResult(50);
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("StartQunRedPointNotify"))
    {
      c(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("EndQunRedPointNotify"))
    {
      d(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("GroupUploadPhoto"))
    {
      f(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunDownloadPhoto"))
    {
      i(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("GroupQuote"))
    {
      j(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunDidPickAlbum"))
    {
      k(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunPickQzoneAlbum"))
    {
      l(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("HideTopicComment"))
    {
      e(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunJumpDetail"))
    {
      b(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("QunDetailDelete"))
    {
      a(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("ShowGroupPhotoBrowser"))
    {
      h(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("ImportGroupAIO"))
    {
      g(paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhsr
 * JD-Core Version:    0.7.0.1
 */
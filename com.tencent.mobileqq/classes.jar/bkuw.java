import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.cache.SDCardMountMonitorReceiver;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class bkuw
  extends BaseJsPlugin
{
  public static String a;
  private long jdField_a_of_type_Long;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bkux(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private bhpc jdField_a_of_type_Bhpc;
  private RequestEvent jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "famous";
  }
  
  private void a()
  {
    bmtk.a();
    bmtd.a(this.mMiniAppContext.getAttachedActivity(), null, 0);
  }
  
  private void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
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
        str = String.format(paramActivity.getString(2131716812), new Object[] { Integer.valueOf(paramInt1) }) + "，";
        str = str + paramString + anzj.a(2131713963);
      }
      paramString = str + String.format(paramActivity.getString(2131716805), new Object[] { Integer.valueOf(paramInt2) });
      bhlq.a(paramActivity, 232).setMessage(paramString).setNegativeButton(2131716810, new bkvd(this)).show();
      return;
    }
    bjuh.a().a(paramActivity.getString(2131716813) + paramString + anzj.a(2131713962));
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = this.mMiniAppContext.getAttachedActivity().getSharedPreferences("troop_album" + BaseApplicationImpl.sApplication.getRuntime().getAccount(), 0).getBoolean("is_exit_fail_misson", false);
      QLog.w("TroopAlbumPlugin", 2, "isExitFailMission:" + bool);
      if (bool)
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("count", 1);
        paramJSONObject.put("isFail", true);
        sendSubscribeEvent("groupAlbum_onGroupAlbumUpload", paramJSONObject.toString());
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopAlbumPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private void a(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
  {
    try
    {
      paramJSONObject.getJSONObject("data");
      paramJSONObject = new Bundle();
      paramJSONObject.putInt("key_personal_album_enter_model", 0);
      paramJSONObject.putBoolean("key_pass_result_by_bundle", true);
      bmtk localbmtk = bmtk.a();
      localbmtk.jdField_a_of_type_JavaLangString = BaseApplicationImpl.sApplication.getRuntime().getAccount();
      paramJSONObject.putBoolean("key_need_change_to_jpg", true);
      bmtd.a(this.mMiniAppContext.getAttachedActivity(), localbmtk, paramJSONObject, 100);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent = paramRequestEvent;
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("troop_select");
      this.mMiniAppContext.getAttachedActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopAlbumPlugin", 2, "handleQunPickQzoneAlbum,decode param error");
    }
  }
  
  private boolean a()
  {
    return SDCardMountMonitorReceiver.a().b();
  }
  
  private void b(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONObject("data");
    int i = paramJSONObject.optInt("categoryType");
    paramJSONObject = paramJSONObject.optString("categoryId");
    Activity localActivity = this.mMiniAppContext.getAttachedActivity();
    if (localActivity != null) {
      bmtd.a(localActivity, BaseApplicationImpl.sApplication.getRuntime().getAccount(), i, paramJSONObject, -1);
    }
  }
  
  private void b(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).optString("albumname");
    long l = ((JSONObject)localObject).getLong("groupCode");
    localObject = ((JSONObject)localObject).optString("albumid");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (int i = 2;; i = 1)
    {
      bmtd.b(this.mMiniAppContext.getAttachedActivity(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), i, 1, l, "", (String)localObject, paramJSONObject, 7001, 43);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent = paramRequestEvent;
      paramJSONObject = new IntentFilter();
      paramJSONObject.addAction("troop_upload");
      this.mMiniAppContext.getAttachedActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramJSONObject);
      return;
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.getJSONObject("data");
    long l = paramJSONObject.optLong("uin");
    paramJSONObject.optString("nick");
    paramJSONObject = new Intent();
    QzonePluginProxyActivity.a(paramJSONObject, "com.qzone.homepage.ui.activity.QZoneUserHomeActivity");
    paramJSONObject.putExtra("qqid", l);
    paramJSONObject.putExtra("refer", jdField_a_of_type_JavaLangString);
    paramJSONObject.setFlags(67108864);
    paramJSONObject.putExtra("autoShowTimeLine", false);
    QzonePluginProxyActivity.a(this.mMiniAppContext.getAttachedActivity(), BaseApplicationImpl.sApplication.getRuntime().getAccount(), paramJSONObject, 0);
  }
  
  private void c(JSONObject paramJSONObject, RequestEvent paramRequestEvent)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 2000L)
    {
      QLog.d("TroopAlbumPlugin", 4, "handleShowPhotoList too many return " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      return;
    }
    Object localObject1 = paramJSONObject.getJSONObject("data");
    int i = ((JSONObject)localObject1).getInt("groupID");
    paramJSONObject = ((JSONObject)localObject1).optString("albumID");
    Object localObject4 = ((JSONObject)localObject1).optString("photoID");
    Object localObject3 = ((JSONObject)localObject1).optString("uin");
    Object localObject2 = ((JSONObject)localObject1).optString("bigurl");
    long l = ((JSONObject)localObject1).optLong("uin");
    int j = ((JSONObject)localObject1).optInt("isVideo");
    int k = ((JSONObject)localObject1).optInt("orgVideoSize");
    int m = ((JSONObject)localObject1).optInt("videoWidth");
    int n = ((JSONObject)localObject1).optInt("videoHeight");
    paramRequestEvent = ((JSONObject)localObject1).optString("videoURL");
    String str = ((JSONObject)localObject1).optString("videoID");
    localObject1 = bmtk.a();
    ((bmtk)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
    localObject3 = new Bundle();
    ArrayList localArrayList = new ArrayList();
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.d = ((String)localObject2);
    localPhotoInfo.c = l;
    localPhotoInfo.b = paramJSONObject;
    localPhotoInfo.i = ((String)localObject4);
    localPhotoInfo.t = i;
    localPhotoInfo.q = j;
    localPhotoInfo.a = new VideoInfo();
    localPhotoInfo.a.jdField_a_of_type_JavaLangString = str;
    localObject4 = new PictureUrl();
    ((PictureUrl)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject2);
    localPhotoInfo.a.d = ((PictureUrl)localObject4);
    localObject2 = new VideoUrl();
    ((VideoUrl)localObject2).jdField_a_of_type_JavaLangString = paramRequestEvent;
    localPhotoInfo.a.jdField_a_of_type_Long = k;
    localPhotoInfo.a.jdField_a_of_type_JavaLangString = str;
    localPhotoInfo.a.b = paramRequestEvent;
    localPhotoInfo.a.jdField_a_of_type_CooperationQzoneModelVideoUrl = ((VideoUrl)localObject2);
    localPhotoInfo.a.g = m;
    localPhotoInfo.a.h = n;
    localPhotoInfo.a.f = 5;
    localArrayList.add(localPhotoInfo);
    paramRequestEvent = new PhotoParam();
    paramRequestEvent.b = paramJSONObject;
    paramRequestEvent.g = paramJSONObject;
    ((Bundle)localObject3).putSerializable("picturelist", localArrayList);
    ((Bundle)localObject3).putInt("curindex", 0);
    ((Bundle)localObject3).putInt("mode", 13);
    ((Bundle)localObject3).putBoolean("need_clear_cache", true);
    bmtd.c(this.mMiniAppContext.getAttachedActivity(), (bmtk)localObject1, (Bundle)localObject3, 6);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void d(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getJSONObject("data");
    paramJSONObject = ((JSONObject)localObject).optString("albumname");
    int i = ((JSONObject)localObject).getInt("groupCode");
    localObject = ((JSONObject)localObject).optString("albumid");
    ChatHistoryActivity.a(this.mMiniAppContext.getAttachedActivity(), String.valueOf(i), (String)localObject, paramJSONObject);
  }
  
  private void e(JSONObject paramJSONObject)
  {
    Object localObject = new Intent();
    paramJSONObject = paramJSONObject.getJSONObject("data").toString();
    ((Intent)localObject).putExtra("photos", paramJSONObject);
    bngf.a().a(new bkuy(this, paramJSONObject));
    if (!a())
    {
      bjuh.a().a(anzj.a(2131713958));
      return;
    }
    if (!NetworkState.isNetSupport())
    {
      bjuh.a().a(anzj.a(2131713957));
      return;
    }
    if (!NetworkState.isWifiConn())
    {
      localObject = this.mMiniAppContext.getAttachedActivity();
      bhlq.a((Context)localObject, 230).setTitle(((Context)localObject).getString(2131716809)).setMessage(((Context)localObject).getString(2131716811)).setPositiveButton(((Context)localObject).getString(2131716808), new bkvc(this, paramJSONObject)).setNegativeButton(((Context)localObject).getString(2131716807), new bkvb(this)).show();
      return;
    }
    bngf.a().a().d(paramJSONObject);
  }
  
  @JsEvent({"groupAlbum_downloadGroupAlbumPhoto"})
  public void groupAlbumDownloadGroupAlbumPhoto(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_downloadGroupAlbumPhoto succeed");
      e(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_downloadGroupAlbumPhoto failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_groupUploadPhoto"})
  public void groupAlbumGroupUploadPhoto(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_groupUploadPhoto succeed");
      b(new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent);
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbumGroupUploadPhoto failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_importGroupAIO"})
  public void groupAlbumImportGroupAIO(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_importGroupAIO succeed");
      d(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_importGroupAIO failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_jumpCategoryAlbum"})
  public void groupAlbumJumpCategoryAlbum(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_jumpCategoryAlbum succeed");
      b(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_jumpCategoryAlbum failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_jumpGroupAlbumSendBox"})
  public void groupAlbumJumpGroupAlbumSendBox(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_jumpGroupAlbumSendBox succeed");
      a();
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_jumpGroupAlbumSendBox failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_openUserQzoneHome"})
  public void groupAlbumOpenUserQzoneHome(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_openUserQzoneHome succeed");
      c(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_openUserQzoneHome failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_pickQzoneAlbum"})
  public void groupAlbumPickQzoneAlbum(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_pickQzoneAlbum succeed");
      a(new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent);
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_pickQzoneAlbum failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_showGroupPhotoBrowser"})
  public void groupAlbumShowGroupPhotoBrowser(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_showGroupPhotoBrowser succeed");
      c(new JSONObject(paramRequestEvent.jsonParams), paramRequestEvent);
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_showGroupPhotoBrowser failed, ", paramRequestEvent);
    }
  }
  
  @JsEvent({"groupAlbum_start"})
  public void groupAlbumStart(RequestEvent paramRequestEvent)
  {
    try
    {
      QLog.i("TroopAlbumPlugin", 2, "groupAlbum_start succeed");
      a(new JSONObject(paramRequestEvent.jsonParams));
      paramRequestEvent.ok();
      return;
    }
    catch (Throwable paramRequestEvent)
    {
      QLog.e("TroopAlbumPlugin", 1, "groupAlbum_start failed, ", paramRequestEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkuw
 * JD-Core Version:    0.7.0.1
 */
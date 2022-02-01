package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.pic.IPresendPicMgr;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class PlusPanelUtils
{
  public static String a;
  public static String b;
  
  private static int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000) {
          return 0;
        }
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public static int a(BaseSessionInfo paramBaseSessionInfo)
  {
    int i;
    if (AlbumUtil.a(paramBaseSessionInfo.jdField_a_of_type_Int)) {
      i = 5;
    } else {
      i = 6;
    }
    if (AnonymousChatHelper.a().a(paramBaseSessionInfo.jdField_a_of_type_JavaLangString)) {
      i = 1;
    }
    return i;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent, ActivityURIRequest paramActivityURIRequest)
  {
    Object localObject;
    if ((paramIntent == null) || (!paramIntent.hasExtra("showFlashPic")))
    {
      localObject = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      paramActivityURIRequest.extra().putBoolean("showFlashPic", ((IPicFlash)QRoute.api(IPicFlash.class)).showFlashPicOption(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.b));
    }
    paramActivityURIRequest.extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    boolean bool3 = paramActivity instanceof SplashActivity;
    if ((!bool3) && (!(paramActivity instanceof ChatActivity)) && (!(paramActivity instanceof LiteActivity)))
    {
      paramActivityURIRequest.extra().putAll(paramActivity.getIntent().getExtras());
    }
    else
    {
      paramActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      if (bool3) {
        paramActivityURIRequest = AIOUtils.a(paramActivityURIRequest, null);
      }
      paramActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramActivityURIRequest.extra().putString("key_activity_code", ChatActivityUtils.a(paramActivity));
      if (paramSessionInfo.jdField_a_of_type_Int == 9501)
      {
        paramActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
        paramActivityURIRequest.extra().putInt(AlbumConstants.h, 80);
        paramActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramActivityURIRequest.extra().putBoolean("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        paramActivityURIRequest.extra().putBoolean("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
        localObject = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
        if ((localObject != null) && (((SmartDeviceProxyMgr)localObject).a()))
        {
          long l1 = 0L;
          try
          {
            long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
            l1 = l2;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (((SmartDeviceProxyMgr)localObject).a(l1, 1)) {
            paramActivityURIRequest.extra().putBoolean("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
          }
        }
      }
      else
      {
        paramActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        paramActivityURIRequest.extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramActivityURIRequest.extra().putBoolean("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        paramActivityURIRequest.extra().putInt("key_confess_topicid", paramSessionInfo.jdField_e_of_type_Int);
      }
      paramActivityURIRequest.extra().putString("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
      paramActivityURIRequest.extra().putString("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    }
    paramActivityURIRequest.extra().putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    int i = 20;
    int j = -1;
    boolean bool1;
    boolean bool2;
    if (paramIntent != null)
    {
      j = paramIntent.getIntExtra("peakconstant.request_code", -1);
      i = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      paramActivityURIRequest.extra().putInt("PhotoConst.CURRENT_QUALITY_TYPE", i);
      i = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      bool1 = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      bool2 = paramIntent.getBooleanExtra("filter_photolist_troopalbum_toolbar", false);
      int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      if (k == 1039) {
        paramActivityURIRequest.extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", 1039);
      }
      if (k == 1040) {
        paramActivityURIRequest.extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      }
      paramActivityURIRequest.extra().putBoolean("PhotoConst.is_troop_send_mixed_msg", paramIntent.getBooleanExtra("PhotoConst.is_troop_send_mixed_msg", false));
      PhotoUtils.copyReportInfo(paramIntent, paramActivityURIRequest);
      paramActivityURIRequest.extra().putBoolean("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", paramIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", false));
      paramActivityURIRequest.extra().putBoolean("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", paramIntent.getBooleanExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", false));
      paramActivityURIRequest.extra().putBoolean("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", paramIntent.getBooleanExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false));
      paramActivityURIRequest.extra().putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false));
      paramActivityURIRequest.extra().putBoolean("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
      paramActivityURIRequest.extra().putBoolean("fromPhotoListPanel", paramIntent.getBooleanExtra("fromPhotoListPanel", false));
      paramActivityURIRequest.extra().putBoolean("KEY_IS_ANONYMOUS", paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false));
      paramActivityURIRequest.extra().putBoolean("PhotoConst.SEND_NO_PRESEND", paramIntent.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false));
    }
    else
    {
      bool1 = false;
      bool2 = false;
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).m(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      paramActivityURIRequest.extra().putBoolean("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", true);
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 9501) {
      paramActivityURIRequest.extra().putBoolean("isdevicesupportmultiupload", true);
    }
    paramActivityURIRequest.extra().putBoolean("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", bool1);
    paramActivityURIRequest.extra().putBoolean("filter_photolist_troopalbum_toolbar", bool2);
    paramActivityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", i);
    paramActivityURIRequest.extra().putString("extra_image_sender_tag", "sessionInfo.enterAlbum");
    paramActivityURIRequest.extra().putBoolean("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    paramActivityURIRequest.extra().putBoolean("album_enter_directly", true);
    paramActivityURIRequest.extra().putString("ALBUM_ID", AlbumUtil.a(paramActivity));
    paramActivityURIRequest.extra().putString("ALBUM_NAME", AlbumUtil.b(paramActivity));
    paramActivityURIRequest.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    paramActivityURIRequest.extra().putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramActivityURIRequest.extra().putInt("uintype", paramSessionInfo.jdField_a_of_type_Int);
    paramActivityURIRequest.extra().putString("troop_uin", paramSessionInfo.b);
    paramActivityURIRequest.extra().putString("uinname", paramSessionInfo.d);
    paramActivityURIRequest.extra().putInt("entrance", paramSessionInfo.jdField_c_of_type_Int);
    paramActivityURIRequest.extra().putBoolean("PhotoConst.IS_SHOW_CAMERA", false);
    if ((bool3) || ((paramActivity instanceof ChatActivity)))
    {
      paramActivity = (BaseActivity)paramActivity;
      if (paramActivity.getChatFragment() != null) {
        paramActivityURIRequest.extra().putBoolean("isBack2Root", paramActivity.getChatFragment().a().f);
      }
    }
    paramActivityURIRequest.extra().putBoolean("is_anonymous", AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
    paramActivityURIRequest.extra().putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", a(paramSessionInfo));
    paramActivityURIRequest.extra().remove("forward_type");
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false)))
    {
      paramActivityURIRequest.extra().putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      paramActivityURIRequest.extra().putBoolean("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
      paramActivityURIRequest.extra().putParcelable("session_info", paramSessionInfo);
      paramActivityURIRequest.extra().putBoolean("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
      paramActivityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", Math.min(ReceiptUtil.b(paramQQAppInterface), i));
    }
    paramActivityURIRequest.extra().putParcelable("session_info", paramSessionInfo);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      paramActivityURIRequest.extra().putStringArrayList("PhotoConst.PHOTO_PATHS", paramArrayList);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("enterAlbum() INIT_ACTIVITY_CLASS_NAME=");
      paramQQAppInterface.append(paramActivityURIRequest.extra().getString("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
      QLog.d("PEAK", 2, paramQQAppInterface.toString());
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("enterAlbum  maxNum = ");
      paramQQAppInterface.append(i);
      QLog.d("PlusPanelUtils", 2, paramQQAppInterface.toString());
    }
    return j;
  }
  
  public static String a()
  {
    return a(AppConstants.SDCARD_IMG_CAMERA);
  }
  
  public static String a(String paramString)
  {
    return a(paramString, false);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    Object localObject = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.append("IMG");
    int i = 1;
    localStringBuilder.append(((Calendar)localObject).get(1));
    int j = ((Calendar)localObject).get(2) + 1;
    if (j < 10)
    {
      paramString = new StringBuilder();
      paramString.append("0");
      paramString.append(j);
      paramString = paramString.toString();
    }
    else
    {
      paramString = Integer.valueOf(j);
    }
    localStringBuilder.append(paramString);
    j = ((Calendar)localObject).get(5);
    if (j < 10)
    {
      paramString = new StringBuilder();
      paramString.append("0");
      paramString.append(j);
      paramString = paramString.toString();
    }
    else
    {
      paramString = Integer.valueOf(j);
    }
    localStringBuilder.append(paramString);
    j = ((Calendar)localObject).get(11);
    if (j < 10)
    {
      paramString = new StringBuilder();
      paramString.append("0");
      paramString.append(j);
      paramString = paramString.toString();
    }
    else
    {
      paramString = Integer.valueOf(j);
    }
    localStringBuilder.append(paramString);
    j = ((Calendar)localObject).get(12);
    if (j < 10)
    {
      paramString = new StringBuilder();
      paramString.append("0");
      paramString.append(j);
      paramString = paramString.toString();
    }
    else
    {
      paramString = Integer.valueOf(j);
    }
    localStringBuilder.append(paramString);
    j = ((Calendar)localObject).get(13);
    if (j < 10)
    {
      paramString = new StringBuilder();
      paramString.append("0");
      paramString.append(j);
      paramString = paramString.toString();
    }
    else
    {
      paramString = Integer.valueOf(j);
    }
    localStringBuilder.append(paramString);
    if (paramBoolean) {
      paramString = ".mp4";
    } else {
      paramString = ".jpg";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    ((StringBuilder)localObject).append(paramString);
    if (!new File(((StringBuilder)localObject).toString()).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      ((StringBuilder)localObject).append(paramString);
      return ((StringBuilder)localObject).toString();
    }
    localObject = new StringBuilder(localStringBuilder);
    j = localStringBuilder.length();
    while (i < 2147483647)
    {
      ((StringBuilder)localObject).append('(');
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(')');
      ((StringBuilder)localObject).append(paramString);
      if (!new File(((StringBuilder)localObject).toString()).exists()) {
        break;
      }
      ((StringBuilder)localObject).delete(j, ((StringBuilder)localObject).length());
      i += 1;
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("enter_from", 1);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAIO.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("KEY_ALBUM_LIST_CLASS_NAME", AlbumListCustomizationAIO.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAIO.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent = AIOUtils.a(localIntent, null);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
    localIntent.putExtra("fromPhotoListPanel", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 20 - paramInt);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    localIntent.putExtra("filter_photolist_troopalbum_toolbar", true);
    localIntent.putExtra("ALBUM_ID", AlbumUtil.a(paramActivity));
    localIntent.putExtra("ALBUM_NAME", AlbumUtil.b(paramActivity));
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("input_full_screen_mode", true);
    paramActivity.startActivityForResult(localIntent, 10017);
    AlbumUtil.anim(paramActivity, false, true);
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (((QQAppInterface)paramAppInterface).isVideoChatting())) {
      return;
    }
    if (!Utils.a())
    {
      QQToast.a(paramActivity, paramActivity.getResources().getString(2131718574), 0).a();
      return;
    }
    paramAppInterface = AppConstants.SDCARD_IMG_CAMERA;
    boolean bool;
    if (paramInt2 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramAppInterface = a(paramAppInterface, bool);
    Object localObject = new File(AppConstants.SDCARD_IMG_CAMERA);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", paramAppInterface).commit();
    localObject = new Intent();
    if (paramInt2 == 0)
    {
      FileProvider7Helper.setSystemCapture(paramActivity, new File(paramAppInterface), (Intent)localObject);
    }
    else
    {
      ((Intent)localObject).setAction("android.media.action.VIDEO_CAPTURE");
      ((Intent)localObject).putExtra("output", Uri.fromFile(new File(paramAppInterface)));
      ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 100);
    }
    ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_camera");
    ((Intent)localObject).putExtra("android.intent.extra.quickCapture", true);
    ((Intent)localObject).setFlags(536870912);
    try
    {
      paramActivity.startActivityForResult((Intent)localObject, paramInt1);
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      QQToast.a(paramActivity, 2131690725, 0).a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("PlusPanelUtils", 2, "enter sys camera");
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    a(paramBaseActivity.app, paramBaseActivity, paramSessionInfo, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    try
    {
      BaseChatPie localBaseChatPie = ((BaseActivity)paramActivity).getChatFragment().a();
      localBaseChatPie.ae();
      Intent localIntent = new Intent(paramActivity, PoiMapActivity.class).putExtra("uin", paramQQAppInterface.getAccount());
      localIntent.putExtra("is_need_destroy_broadcast", false);
      localIntent.putExtra("sessionType", localBaseChatPie.a.jdField_a_of_type_Int);
      boolean bool = ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, true, null);
      localIntent.putExtra("int_unread_msgs_num", paramQQAppInterface.getMessageFacade().b());
      localIntent.putExtra("boolean_is_default_theme", bool);
      paramActivity.startActivityForResult(localIntent, 18);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("enterQQMap", 2, paramQQAppInterface, new Object[0]);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    long l2 = 0L;
    long l1;
    try
    {
      l1 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l1 = 0L;
    }
    int i;
    if ((paramSessionInfo.jdField_a_of_type_Int == 9501) && (paramQQAppInterface != null) && (paramQQAppInterface.a()))
    {
      i = paramQQAppInterface.a(l1);
      if (paramQQAppInterface.a(l1, 1)) {
        l2 = 52428800L;
      }
      ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openFileSelectorByDeviceMsg(paramActivity, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, i, l2);
    }
    else
    {
      if (paramSessionInfo.jdField_a_of_type_Int == 1000) {
        paramQQAppInterface = paramSessionInfo.b;
      }
      for (;;)
      {
        break;
        if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
          paramQQAppInterface = paramSessionInfo.jdField_e_of_type_JavaLangString;
        } else {
          paramQQAppInterface = paramSessionInfo.jdField_c_of_type_JavaLangString;
        }
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 0) {
        i = 1;
      } else if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
        i = 5;
      } else if (paramSessionInfo.jdField_a_of_type_Int == 1) {
        i = 3;
      } else {
        i = -1;
      }
      ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openFileSelectorByAIO(paramActivity, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface, i);
    }
    paramActivity.overridePendingTransition(2130771993, 2130771994);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean)
  {
    paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a()))
    {
      long l2 = 0L;
      long l1;
      try
      {
        l1 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        l1 = 0L;
      }
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = paramQQAppInterface.a(l1);
      }
      if (paramQQAppInterface.a(l1, 1)) {
        l2 = 52428800L;
      }
      ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).openFileSelectorByPulsPanel(paramActivity, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, i, paramInt, l2);
      paramActivity.overridePendingTransition(2130771993, 2130771994);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "Music_gene", "Music_gene_AIO", 0, 0, String.valueOf(a(paramSessionInfo.jdField_a_of_type_Int)), "", "", "");
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("https://y.qq.com/m/qzonemusic/mqzsearch.html");
      paramString.append("?touin=");
      paramString.append(paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramString.append("&uintype=");
      paramString.append(paramSessionInfo.jdField_a_of_type_Int);
      paramString.append("&_wv=1&entry=aio&_bid=203");
      paramQQAppInterface.putExtra("url", paramString.toString());
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is null");
      }
    }
    else
    {
      paramQQAppInterface.putExtra("url", paramString.replace("$FriendUin$", paramSessionInfo.jdField_a_of_type_JavaLangString).replace("$CurType$", String.valueOf(paramSessionInfo.jdField_a_of_type_Int)));
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is get from file");
      }
    }
    paramQQAppInterface.putExtra("hide_left_button", true);
    paramQQAppInterface.putExtra("show_right_close_button", true);
    paramQQAppInterface.putExtra("finish_animation_up_down", true);
    paramActivity.startActivity(paramQQAppInterface);
    paramActivity.overridePendingTransition(2130771993, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent)
  {
    a(paramQQAppInterface, paramActivity, paramSessionInfo, paramArrayList, paramIntent, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent, HashMap<LocalMediaInfo, LocalMediaInfo> paramHashMap)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramActivity, "/base/album/photolist");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
    localIntent.putExtra("PhotoConst.MY_UIN", paramSessionInfo.h);
    localIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
    localIntent.putExtra("KEY_IS_ANONYMOUS", AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
    localActivityURIRequest.extra().putInt("enter_from", 1);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAIO.jdField_a_of_type_JavaLangString);
    localActivityURIRequest.extra().putString("KEY_ALBUM_LIST_CLASS_NAME", AlbumListCustomizationAIO.jdField_a_of_type_JavaLangString);
    localActivityURIRequest.extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAIO.jdField_a_of_type_JavaLangString);
    int i = a(paramQQAppInterface, paramActivity, paramSessionInfo, paramArrayList, localIntent, localActivityURIRequest);
    if (i != -1)
    {
      paramQQAppInterface = ReplacePhotoDataUtil.a(paramHashMap);
      if (paramQQAppInterface != null) {
        localActivityURIRequest.extra().putSerializable("PhotoConst.editPathMap", paramQQAppInterface);
      }
      localActivityURIRequest.setRequestCode(i);
    }
    QRoute.startUri(localActivityURIRequest);
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "enterPhotoPicker");
    }
    AlbumUtil.anim(paramActivity, false, true);
    if (PeakUtils.a != null) {
      PeakUtils.a.b();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Uri paramUri, SessionInfo paramSessionInfo)
  {
    new PlusPanelUtils.6(paramSessionInfo, paramQQAppInterface, paramContext, ImageUtil.b(paramContext, paramUri)).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, BaseChatPie paramBaseChatPie)
  {
    if (VideoActionSheet.a()) {
      return;
    }
    VideoActionSheet localVideoActionSheet = VideoActionSheet.a(paramContext);
    int[] arrayOfInt = new int[5];
    int j = 0;
    localVideoActionSheet.setMainTitle(2131689542);
    int i;
    if ((paramSessionInfo.jdField_a_of_type_Int != 1025) && (paramSessionInfo.jdField_a_of_type_Int != 0) && (paramSessionInfo.jdField_a_of_type_Int != 1000))
    {
      i = j;
      if (paramSessionInfo.jdField_a_of_type_Int != 1004) {}
    }
    else
    {
      i = j;
      if (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).d(paramSessionInfo.jdField_a_of_type_JavaLangString))
      {
        arrayOfInt[0] = 5;
        localVideoActionSheet.addButton(2131698326);
        i = 1;
      }
    }
    arrayOfInt[i] = 1;
    localVideoActionSheet.addButton(2131719732);
    arrayOfInt[(i + 1)] = 2;
    localVideoActionSheet.addButton(2131719746);
    localVideoActionSheet.addCancelButton(2131690728);
    localVideoActionSheet.setOnDismissListener(new PlusPanelUtils.1(paramQQAppInterface));
    localVideoActionSheet.setOnButtonClickListener(new PlusPanelUtils.2(localVideoActionSheet, arrayOfInt, paramSessionInfo, paramQQAppInterface, paramBaseChatPie, paramContext, paramString));
    localVideoActionSheet.show();
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004D68", "0X8004D68", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map<String, String> paramMap)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    String str;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterVideo, onlyAudio[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], type[");
      str = null;
      if (paramSessionInfo == null) {
        localObject = null;
      } else {
        localObject = Integer.valueOf(paramSessionInfo.jdField_a_of_type_Int);
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append("], uin[");
      if (paramSessionInfo == null) {
        localObject = str;
      } else {
        localObject = paramSessionInfo.jdField_a_of_type_JavaLangString;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("PlusPanelUtils", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      i = 1;
    }
    if ((paramSessionInfo != null) && (paramQQAppInterface.getAVNotifyCenter().a(paramContext, i, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (paramBoolean) {
      str = "0X80049C5";
    } else {
      str = "0X80049C7";
    }
    if (paramSessionInfo == null) {
      return;
    }
    i = paramSessionInfo.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i == 1004) {
        break label354;
      }
      if (i == 1006) {
        break label346;
      }
      if (i == 1010) {
        break label338;
      }
      if (i == 1021) {
        break label330;
      }
      if (i == 1024) {
        break label322;
      }
      if (i == 1044) {
        break label314;
      }
      if (i != 10002)
      {
        if (i == 1000) {
          break label306;
        }
        if (i == 1001) {}
      }
    }
    else
    {
      localObject = "0";
      break label362;
    }
    Object localObject = "4";
    break label362;
    label306:
    localObject = "2";
    for (;;)
    {
      break;
      label314:
      localObject = "30";
      continue;
      label322:
      localObject = "6";
      continue;
      label330:
      localObject = "5";
      continue;
      label338:
      localObject = "7";
      continue;
      label346:
      localObject = "3";
      continue;
      label354:
      localObject = "1";
    }
    label362:
    ReportController.b(paramQQAppInterface, "CliOper", "", "", str, str, 0, 0, (String)localObject, "", "", "");
    b(paramQQAppInterface, paramContext, paramSessionInfo, paramBoolean, paramString, paramMap);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity, BaseSessionInfo paramBaseSessionInfo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PlusPanelUtils", 2, "enter Camera");
    }
    if (AudioUtil.a(0))
    {
      DialogUtil.a(paramContext, 230, paramContext.getString(2131698511), paramContext.getString(2131698512), new PlusPanelUtils.7(), null).show();
      return;
    }
    if (QQAudioHelper.a(0))
    {
      DialogUtil.a(paramContext, 230, paramContext.getString(2131698511), paramContext.getString(2131698513), new PlusPanelUtils.8(), null).show();
      return;
    }
    if (paramQQAppInterface.getApp().checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) != 0)
    {
      DialogUtil.a(paramContext, 230, paramContext.getString(2131698511), HardCodeUtil.a(2131708300), new PlusPanelUtils.9(), null).show();
      return;
    }
    int i;
    if (paramInt2 == 0) {
      i = 1;
    } else {
      i = 17000;
    }
    a(paramQQAppInterface, paramBaseActivity, i, paramInt2);
    NewFlowCameraReporter.c();
    paramBaseActivity.setCanLock(false);
    if (paramBaseSessionInfo.jdField_a_of_type_Int == 9501) {
      SmartDeviceReport.a(paramQQAppInterface, Long.parseLong(paramBaseSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 2, 0, paramInt1);
    }
  }
  
  public static void a(ActivityURIRequest paramActivityURIRequest, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (a(paramSessionInfo, paramQQAppInterface.isLBSFriendNewClient(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "prepareForPicPresend add binder!");
      }
      paramSessionInfo = new BinderWarpper(new PresendPicMgrService(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, paramQQAppInterface.getAccount(), paramSessionInfo.jdField_e_of_type_Int).asBinder());
      paramActivityURIRequest.extra().putParcelable("binder_presendService", paramSessionInfo);
    }
  }
  
  public static boolean a(SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    boolean bool4 = ((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpresend_whitelist.name());
    Object localObject = BaseApplication.getContext();
    int i = Build.VERSION.SDK_INT;
    boolean bool3 = false;
    if (i > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", i);
    boolean bool2 = ((SharedPreferences)localObject).getBoolean("key_presend_off_flag", false);
    boolean bool1 = bool2;
    if (bool2)
    {
      long l = ((SharedPreferences)localObject).getLong("key_presend_off_time", 0L);
      bool1 = bool2;
      if (System.currentTimeMillis() - l > 86400000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "isPresendAllowed,PicPresend off more than 24h ,enable PicPresend!");
        }
        ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", false).commit();
        bool1 = false;
      }
    }
    if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "isPresendAllowed ,is VIP User");
      }
      bool1 = false;
    }
    if (paramSessionInfo.jdField_a_of_type_Int != 1001)
    {
      bool2 = bool1;
      if (paramSessionInfo.jdField_a_of_type_Int != 10002) {}
    }
    else
    {
      bool2 = bool1;
      if (!paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "isPresendAllowed,old lbs protocol ,disable PicPresend!");
        }
        bool2 = true;
      }
    }
    if (paramSessionInfo.jdField_a_of_type_Int != 9500)
    {
      paramBoolean = bool2;
      if (paramSessionInfo.jdField_a_of_type_Int != 9501) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "curType is smart device ,disable PicPresend!");
      }
      paramBoolean = true;
    }
    paramSessionInfo = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.pic_presend.name(), "0|0|0|0|1|0|1|1|1048576|0|307200|307200|0|90|70|50");
    bool1 = paramBoolean;
    if (!paramBoolean)
    {
      bool1 = paramBoolean;
      if (paramSessionInfo != null)
      {
        bool1 = paramBoolean;
        if (paramSessionInfo.length() > 0)
        {
          paramSessionInfo = paramSessionInfo.split("\\|");
          bool1 = paramBoolean;
          if (paramSessionInfo.length >= 4)
          {
            bool2 = paramSessionInfo[0].equals("1");
            boolean bool5 = paramSessionInfo[1].equals("1");
            boolean bool6 = paramSessionInfo[2].equals("1");
            boolean bool7 = paramSessionInfo[3].equals("1");
            i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4) {
                    paramBoolean = bool7 ^ true;
                  }
                }
                else {
                  paramBoolean = bool6 ^ true;
                }
              }
              else {
                paramBoolean = bool5 ^ true;
              }
            }
            else {
              paramBoolean = bool2 ^ true;
            }
            bool1 = paramBoolean;
            if (QLog.isColorLevel())
            {
              paramSessionInfo = new StringBuilder();
              paramSessionInfo.append("isPresendAllowed netType = ");
              paramSessionInfo.append(i);
              paramSessionInfo.append(",enablePreCompress_WIFI:");
              paramSessionInfo.append(bool2);
              paramSessionInfo.append(", enablePreCompress_2G = ");
              paramSessionInfo.append(bool5);
              paramSessionInfo.append(", enablePreCompress_3G = ");
              paramSessionInfo.append(bool6);
              paramSessionInfo.append(", enablePreCompress_4G = ");
              paramSessionInfo.append(bool7);
              paramSessionInfo.append(", presendOFF  = ");
              paramSessionInfo.append(paramBoolean);
              QLog.d("PEAK", 2, paramSessionInfo.toString());
              bool1 = paramBoolean;
            }
          }
        }
      }
    }
    paramBoolean = bool3;
    if (!bool4)
    {
      paramBoolean = bool3;
      if (!bool1) {
        paramBoolean = true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramSessionInfo = new StringBuilder();
      paramSessionInfo.append("isPresendAllowed, isInDPCPicPresendWhiteList :");
      paramSessionInfo.append(bool4);
      paramSessionInfo.append(", presendOFF = ");
      paramSessionInfo.append(bool1);
      paramSessionInfo.append(", result  = ");
      paramSessionInfo.append(paramBoolean);
      QLog.d("PEAK", 2, paramSessionInfo.toString());
    }
    return paramBoolean;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("bEnterToSelect", true);
    localIntent.putExtra("paSessionInfo", paramSessionInfo);
    QfavHelper.a(paramActivity, paramQQAppInterface.getAccount(), localIntent, -1, false);
    QfavReport.b(paramQQAppInterface, 3, paramSessionInfo.jdField_a_of_type_Int);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map<String, String> paramMap)
  {
    Object localObject = (IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    String str;
    if (paramSessionInfo.jdField_a_of_type_Int == 1006)
    {
      str = ((IPhoneContactService)localObject).getUinByPhoneNum(paramSessionInfo.jdField_a_of_type_JavaLangString);
      localObject = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
    else
    {
      str = paramSessionInfo.jdField_a_of_type_JavaLangString;
      localObject = ((IPhoneContactService)localObject).getPhoneNumByUin(str);
    }
    if (paramString == null)
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.b, true, true, null, "from_internal", paramMap);
      return;
    }
    ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.b, true, true, null, paramString, paramMap);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    ((IQQFileSelector)QRoute.api(IQQFileSelector.class)).enterLocalFileBrowserByDevice(paramActivity, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    AlbumUtil.anim(paramActivity, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.QrcodeHbGuiderActivity;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.PanelData;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.jumplightalk.AIOJumpLightalkConfig;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pic.IPresendPicMgr;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnSwitchConfig;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.ActionSheet;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import umg;
import umh;
import umi;
import umj;
import umk;
import uml;
import umm;
import umn;
import umo;

public class PlusPanelUtils
{
  private static TroopObserver a;
  public static String a;
  public static String b;
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static int a(SessionInfo paramSessionInfo)
  {
    if (AlbumUtil.a(paramSessionInfo.jdField_a_of_type_Int)) {}
    for (int i = 0; AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString); i = 1) {
      return 1;
    }
    return i;
  }
  
  public static ActionSheet a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, Handler.Callback paramCallback, int paramInt2)
  {
    paramCallback = ActionSheet.a(paramActivity);
    int k = 0;
    int i = 0;
    int j = k;
    PstnManager localPstnManager;
    PstnCardInfo localPstnCardInfo;
    if (paramInt2 == 1)
    {
      paramCallback.a(2131438345);
      paramCallback.b(2131433828);
      localPstnManager = (PstnManager)paramQQAppInterface.getManager(142);
      localPstnCardInfo = localPstnManager.a(paramQQAppInterface.getCurrentAccountUin());
      if ((localPstnCardInfo == null) || (localPstnManager.a() != 1) || (localPstnManager.a().d != 1)) {
        break label429;
      }
      if (localPstnCardInfo.pstn_multi_call_time <= 0) {
        break label236;
      }
      paramCallback.a(paramQQAppInterface.getApplication().getBaseContext().getResources().getString(2131438343), paramQQAppInterface.getApplication().getBaseContext().getResources().getDrawable(2130840359), 0);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063FE", "0X80063FE", 1, 0, "", "", "", "");
      i = 1;
      j = 3;
    }
    for (;;)
    {
      if (i != 0)
      {
        paramCallback.c(2131433015);
        paramCallback.a(new umi(paramQQAppInterface));
        paramCallback.a(new umj(paramCallback, paramQQAppInterface, paramActivity, paramInt1, paramString, j));
        paramCallback.show();
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004D6C", "0X8004D6C", 0, 0, "", "", "", "");
        return paramCallback;
        label236:
        if ((localPstnManager.c() == 1) && (localPstnCardInfo.pstn_multi_try_status == 0))
        {
          paramCallback.a(paramQQAppInterface.getApplication().getBaseContext().getResources().getString(2131438343), paramQQAppInterface.getApplication().getBaseContext().getResources().getDrawable(2130840358), 0);
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063FE", "0X80063FE", 3, 0, "", "", "", "");
          i = 1;
          j = 4;
        }
        else
        {
          paramCallback.a(paramQQAppInterface.getApplication().getBaseContext().getResources().getString(2131438343), paramQQAppInterface.getApplication().getBaseContext().getResources().getDrawable(2130840357), 0);
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063FE", "0X80063FE", 2, 0, "", "", "", "");
          i = 1;
          j = 5;
        }
      }
      else
      {
        ChatActivityUtils.a(paramQQAppInterface, paramActivity, paramInt1, paramString, true, true, null, null);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004863", "0X8004863", 0, 0, "", "", "", "");
        return null;
        label429:
        i = 1;
        j = k;
      }
    }
  }
  
  public static String a()
  {
    return a(AppConstants.aV);
  }
  
  public static String a(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.append("IMG");
    localStringBuilder.append(localCalendar.get(1));
    int i = localCalendar.get(2) + 1;
    if (i < 10)
    {
      paramString = "0" + i;
      localStringBuilder.append(paramString);
      i = localCalendar.get(5);
      if (i >= 10) {
        break label298;
      }
      paramString = "0" + i;
      label106:
      localStringBuilder.append(paramString);
      i = localCalendar.get(11);
      if (i >= 10) {
        break label306;
      }
      paramString = "0" + i;
      label146:
      localStringBuilder.append(paramString);
      i = localCalendar.get(12);
      if (i >= 10) {
        break label314;
      }
      paramString = "0" + i;
      label186:
      localStringBuilder.append(paramString);
      i = localCalendar.get(13);
      if (i >= 10) {
        break label322;
      }
    }
    label298:
    label306:
    label314:
    label322:
    for (paramString = "0" + i;; paramString = Integer.valueOf(i))
    {
      localStringBuilder.append(paramString);
      if (new File(localStringBuilder.toString() + ".jpg").exists()) {
        break label330;
      }
      return localStringBuilder.toString() + ".jpg";
      paramString = Integer.valueOf(i);
      break;
      paramString = Integer.valueOf(i);
      break label106;
      paramString = Integer.valueOf(i);
      break label146;
      paramString = Integer.valueOf(i);
      break label186;
    }
    label330:
    paramString = new StringBuilder(localStringBuilder);
    int j = localStringBuilder.length();
    i = 1;
    for (;;)
    {
      if (i < 2147483647)
      {
        paramString.append('(');
        paramString.append(i);
        paramString.append(')');
        paramString.append(".jpg");
        if (new File(paramString.toString()).exists()) {}
      }
      else
      {
        return paramString.toString();
      }
      paramString.delete(j, paramString.length());
      i += 1;
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = paramString.indexOf(':');
        } while (i == -1);
        localObject = paramString.substring(0, i);
      } while (TextUtils.isEmpty((CharSequence)localObject));
      localObject = ((String)localObject).toLowerCase();
    } while ((((String)localObject).compareTo("http") != 0) && (((String)localObject).compareTo("https") != 0));
    Object localObject = new Intent(paramActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void a(Intent paramIntent, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if (a(paramSessionInfo, paramQQAppInterface.a(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "prepareForPicPresend add binder!");
      }
      paramIntent.putExtra("binder_presendService", new BinderWarpper(new PresendPicMgrService(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, paramQQAppInterface.getAccount(), paramSessionInfo.jdField_e_of_type_Int).asBinder()));
    }
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, int paramInt, SessionInfo paramSessionInfo)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return;
    }
    if (!Utils.a())
    {
      QQToast.a(paramActivity, paramActivity.getResources().getString(2131434770), 0).a();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = System.currentTimeMillis();
    paramAppInterface = a(AppConstants.aV);
    paramSessionInfo = new File(AppConstants.aV);
    if (!paramSessionInfo.exists()) {
      paramSessionInfo.mkdirs();
    }
    paramSessionInfo = Uri.fromFile(new File(paramAppInterface));
    PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", paramAppInterface).commit();
    paramAppInterface = new Intent("android.media.action.IMAGE_CAPTURE");
    paramAppInterface.putExtra("output", paramSessionInfo);
    paramAppInterface.putExtra("android.intent.extra.quickCapture", true);
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.enterCamera", 2, "[enterCamera] + ENTER sysCamera takeTime: " + (l2 - l1));
    }
    paramAppInterface.setFlags(536870912);
    paramAppInterface.putExtra("android.intent.extra.videoQuality", 100);
    try
    {
      paramActivity.startActivityForResult(paramAppInterface, paramInt);
      return;
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      QQToast.a(paramActivity, 2131434793, 0).a();
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
      BaseChatPie localBaseChatPie = ((FragmentActivity)paramActivity).getChatFragment().a();
      localBaseChatPie.az();
      Intent localIntent = new Intent(paramActivity, PoiMapActivity.class).putExtra("uin", paramQQAppInterface.getAccount());
      localIntent.putExtra("is_need_destroy_broadcast", false);
      localIntent.putExtra("sessionType", localBaseChatPie.a.jdField_a_of_type_Int);
      boolean bool = ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, true, null);
      localIntent.putExtra("int_unread_msgs_num", paramQQAppInterface.a().b());
      localIntent.putExtra("boolean_is_default_theme", bool);
      paramActivity.startActivityForResult(localIntent, 18);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      do
      {
        paramQQAppInterface.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("enterQQMap", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    localIntent = new Intent(paramActivity, FMActivity.class);
    paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.a(51);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        localIntent.putExtra("from_aio", true);
        localIntent.addFlags(536870912);
        localIntent.putExtra("selectMode", true);
        localIntent.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
        localIntent.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramSessionInfo.jdField_a_of_type_Int == 1000) {
          localIntent.putExtra("srcDiscGroup", paramSessionInfo.b);
        } else if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
          localIntent.putExtra("srcDiscGroup", paramSessionInfo.jdField_e_of_type_JavaLangString);
        } else {
          localIntent.putExtra("srcDiscGroup", paramSessionInfo.jdField_c_of_type_JavaLangString);
        }
      }
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 9501) && (paramQQAppInterface != null) && (paramQQAppInterface.a()))
    {
      localIntent.putExtra("category", 6);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("tab_tab_type", 5);
      localIntent.putExtra("smart_device_support_flag", paramQQAppInterface.a(l1));
      if (paramQQAppInterface.a(l1, 1)) {
        localIntent.putExtra("max_select_size", 52428800L);
      }
      paramActivity.startActivityForResult(localIntent, 5);
      paramActivity.overridePendingTransition(2131034123, 2131034124);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean)
  {
    paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.a(51);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a())) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Intent localIntent;
        localException.printStackTrace();
        continue;
        int i = paramQQAppInterface.a(l1);
      }
    }
    if (paramBoolean)
    {
      i = 2;
      localIntent = new Intent(paramActivity, FMActivity.class);
      localIntent.putExtra("category", 6);
      localIntent.putExtra("selectMode", true);
      localIntent.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("tab_tab_type", 5);
      localIntent.putExtra("smart_device_support_flag", i);
      localIntent.putExtra("smart_device_switch_tab_flag", paramInt);
      if (paramQQAppInterface.a(l1, 1)) {
        localIntent.putExtra("max_select_size", 52428800);
      }
      paramActivity.startActivityForResult(localIntent, 5);
      paramActivity.overridePendingTransition(2131034123, 2131034124);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, PanelData paramPanelData, int paramInt)
  {
    if (paramPanelData == null) {
      return;
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), SendHbActivity.class);
    localIntent.putExtra("come_from", 2);
    localIntent.putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#aio");
    Object localObject1;
    int j;
    int i;
    int k;
    Object localObject2;
    switch (paramPanelData.jdField_a_of_type_Int)
    {
    default: 
      paramPanelData = null;
      localObject1 = "1";
      j = 1;
      i = 0;
      k = 0;
      localObject2 = "";
      localObject3 = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
      if (localObject3 == null) {
        break;
      }
    }
    for (Object localObject3 = ((PasswdRedBagManager)localObject3).a();; localObject3 = null)
    {
      if (paramSessionInfo.jdField_a_of_type_Int == 0) {
        i = 1;
      }
      for (;;)
      {
        label141:
        Object localObject4;
        for (;;)
        {
          localIntent.putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + i, 0, null));
          localObject4 = new JSONObject();
          try
          {
            ((JSONObject)localObject4).put("recv_type", i);
            ((JSONObject)localObject4).put("recv_uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
            ((JSONObject)localObject4).put("channel", j);
            ((JSONObject)localObject4).put("bus_type", localObject1);
            if (k > 0) {
              ((JSONObject)localObject4).put("people_num", k);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((JSONObject)localObject4).put("session_token", localObject2);
            }
            if (localObject3 != null) {
              ((JSONObject)localObject4).put("placeholder", localObject3);
            }
            if (paramPanelData != null) {
              ((JSONObject)localObject4).put("extra_info", paramPanelData);
            }
          }
          catch (JSONException paramPanelData)
          {
            for (;;)
            {
              long l;
              paramPanelData.printStackTrace();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("PlusPanel", 2, "click HongBao:params=" + ((JSONObject)localObject4).toString());
          }
          localIntent.putExtra("extra_data", ((JSONObject)localObject4).toString());
          paramActivity.startActivity(localIntent);
          if (paramInt != 0) {
            break label1133;
          }
          AIOPanelUtiles.a(paramQQAppInterface, "0X8005CAF", paramSessionInfo.jdField_a_of_type_Int);
          return;
          paramPanelData = null;
          localObject1 = "1";
          j = 1;
          break;
          paramPanelData = null;
          localObject1 = "2";
          j = 1;
          break;
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("redgift_type", "3");
            if (paramPanelData.jdField_a_of_type_Int == 6) {}
            for (paramPanelData = "0";; paramPanelData = "1")
            {
              ((JSONObject)localObject1).put("redgift_subtype", paramPanelData);
              paramPanelData = (PanelData)localObject1;
              localObject1 = "1";
              j = 32;
              break;
            }
          }
          catch (JSONException paramPanelData)
          {
            paramPanelData.printStackTrace();
            paramPanelData = null;
            localObject1 = "1";
            j = 32;
          }
        }
        l = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
        paramSessionInfo = new Intent(paramActivity, QrcodeHbGuiderActivity.class);
        paramSessionInfo.putExtra("appInfo", "");
        paramSessionInfo.putExtra("vacreport_key_seq", l);
        paramActivity.startActivity(paramSessionInfo);
        ReportController.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "plus.hongbao.click", 0, 0, "", "", "", "");
        return;
        if (paramPanelData.jdField_a_of_type_OrgJsonJSONObject != null) {}
        for (paramPanelData = paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("theme_id", "");; paramPanelData = "")
        {
          localIntent.putExtra("theme_type", paramPanelData);
          localIntent.putExtra("theme", true);
          paramPanelData = null;
          localObject1 = "1";
          j = 1;
          break;
        }
        if (paramPanelData.jdField_a_of_type_OrgJsonJSONObject != null) {}
        for (paramQQAppInterface = paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("url", "");; paramQQAppInterface = "")
        {
          a(paramActivity, paramQQAppInterface);
          return;
        }
        if (paramSessionInfo.jdField_a_of_type_Int == 3000)
        {
          k = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
          i = 2;
        }
        else
        {
          if (paramSessionInfo.jdField_a_of_type_Int == 1)
          {
            localObject4 = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
            k = i;
            if (localObject4 != null)
            {
              k = ((TroopInfo)localObject4).wMemberNum;
              if (QLog.isColorLevel()) {
                QLog.d("PlusPanelUtils", 2, "troop uin：" + paramSessionInfo.jdField_a_of_type_JavaLangString + " people_num：" + k);
              }
            }
            if (QWalletHelper.isNeedUpdateTroopMemberNum(paramSessionInfo.jdField_a_of_type_JavaLangString)) {}
            try
            {
              l = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
              localObject4 = (TroopHandler)paramQQAppInterface.a(20);
              if (a == null) {
                a = new umo(paramSessionInfo);
              }
              paramQQAppInterface.addObserver(a);
              ((TroopHandler)localObject4).a(l, 32, 0);
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                if (QLog.isColorLevel())
                {
                  QLog.d("angelzhuang", 2, "群uin：" + paramSessionInfo.jdField_a_of_type_JavaLangString + " 解析失败");
                  continue;
                  i = 3;
                }
              }
            }
            localObject4 = (HotChatManager)paramQQAppInterface.getManager(59);
            if ((localObject4 != null) && (((HotChatManager)localObject4).b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
            {
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005B9C", "0X8005B9C", 0, 0, "", "", "", "");
              i = 6;
              continue;
            }
          }
          if (paramSessionInfo.jdField_a_of_type_Int == 1000)
          {
            localObject2 = paramSessionInfo.b;
            i = 4;
          }
          else if (paramSessionInfo.jdField_a_of_type_Int == 1004)
          {
            localObject2 = paramSessionInfo.b;
            i = 5;
          }
          else
          {
            if ((paramSessionInfo.jdField_a_of_type_Int == 1001) || (paramSessionInfo.jdField_a_of_type_Int == 10002) || (paramSessionInfo.jdField_a_of_type_Int == 10004))
            {
              if (paramSessionInfo.jdField_a_of_type_Int == 10004)
              {
                localObject2 = paramQQAppInterface.a().l(paramSessionInfo.jdField_a_of_type_JavaLangString);
                label1063:
                if (localObject2 == null) {
                  break label1151;
                }
              }
              label1133:
              label1151:
              for (localObject2 = Base64Util.encodeToString((byte[])localObject2, 2);; localObject2 = "")
              {
                ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005B9D", "0X8005B9D", 0, 0, "", "", "", "");
                i = 7;
                break label141;
                localObject2 = paramQQAppInterface.a().m(paramSessionInfo.jdField_a_of_type_JavaLangString);
                break label1063;
                if (paramInt != 1) {
                  break;
                }
                AIOPanelUtiles.a(paramQQAppInterface, "0X8005FC9", paramSessionInfo.jdField_a_of_type_Int);
                return;
              }
            }
            i = 0;
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "Music_gene", "Music_gene_AIO", 0, 0, String.valueOf(a(paramSessionInfo.jdField_a_of_type_Int)), "", "", "");
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface.putExtra("url", "https://y.qq.com/m/qzonemusic/mqzsearch.html" + "?touin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + "&uintype=" + paramSessionInfo.jdField_a_of_type_Int + "&_wv=1&entry=aio&_bid=203");
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is null");
      }
    }
    for (;;)
    {
      paramQQAppInterface.putExtra("hide_left_button", true);
      paramQQAppInterface.putExtra("show_right_close_button", true);
      paramQQAppInterface.putExtra("finish_animation_up_down", true);
      paramActivity.startActivity(paramQQAppInterface);
      paramActivity.overridePendingTransition(2131034123, 0);
      return;
      paramQQAppInterface.putExtra("url", paramString.replace("$FriendUin$", paramSessionInfo.jdField_a_of_type_JavaLangString).replace("$CurType$", String.valueOf(paramSessionInfo.jdField_a_of_type_Int)));
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is get from file");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList paramArrayList, Intent paramIntent)
  {
    Object localObject1 = new Intent(paramActivity, AlbumListActivity.class);
    Object localObject2;
    if ((paramIntent == null) || (!paramIntent.hasExtra("showFlashPic")))
    {
      localObject2 = (HotChatManager)paramQQAppInterface.getManager(59);
      ((Intent)localObject1).putExtra("showFlashPic", FlashPicHelper.a(paramSessionInfo.jdField_a_of_type_Int, (HotChatManager)localObject2, paramSessionInfo.b));
    }
    ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    int j;
    boolean bool2;
    int i;
    boolean bool1;
    if ((!SplashActivity.class.isInstance(paramActivity)) && (!ChatActivity.class.isInstance(paramActivity)) && (!LiteActivity.class.isInstance(paramActivity)))
    {
      ((Intent)localObject1).putExtras(paramActivity.getIntent());
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "enterAlbum() INIT_ACTIVITY_CLASS_NAME=" + ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
      }
      ((Intent)localObject1).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      j = 20;
      bool2 = false;
      if (paramIntent == null) {
        break label1224;
      }
      i = paramIntent.getIntExtra("peakconstant.request_code", -1);
      ((Intent)localObject1).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      j = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      bool2 = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      bool1 = paramIntent.getBooleanExtra("filter_photolist_troopalbum_toolbar", false);
      int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      if (k == 1039) {
        ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
      }
      if (k == 1040) {
        ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      }
      ((Intent)localObject1).putExtra("PhotoConst.is_troop_send_mixed_msg", paramIntent.getBooleanExtra("PhotoConst.is_troop_send_mixed_msg", false));
      PhotoUtils.a(paramIntent, (Intent)localObject1);
      ((Intent)localObject1).putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", paramIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", false));
    }
    for (;;)
    {
      if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString))) {
        ((Intent)localObject1).putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterAlbum  maxNum = " + j);
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 9501) {
        ((Intent)localObject1).putExtra("isdevicesupportmultiupload", true);
      }
      ((Intent)localObject1).putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", bool2);
      ((Intent)localObject1).putExtra("filter_photolist_troopalbum_toolbar", bool1);
      ((Intent)localObject1).putExtra("PhotoConst.MAXUM_SELECTED_NUM", j);
      ((Intent)localObject1).putExtra("extra_image_sender_tag", "sessionInfo.enterAlbum");
      ((Intent)localObject1).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      ((Intent)localObject1).putExtra("album_enter_directly", true);
      ((Intent)localObject1).putExtra("ALBUM_ID", AlbumUtil.a(paramActivity));
      ((Intent)localObject1).putExtra("ALBUM_NAME", AlbumUtil.b(paramActivity));
      ((Intent)localObject1).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Intent)localObject1).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      ((Intent)localObject1).putExtra("troop_uin", paramSessionInfo.b);
      ((Intent)localObject1).putExtra("uinname", paramSessionInfo.d);
      ((Intent)localObject1).putExtra("entrance", paramSessionInfo.jdField_c_of_type_Int);
      ((Intent)localObject1).putExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if ((((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))) && (((FragmentActivity)paramActivity).getChatFragment() != null)) {
        ((Intent)localObject1).putExtra("isBack2Root", ((FragmentActivity)paramActivity).getChatFragment().a().i);
      }
      ((Intent)localObject1).putExtra("is_anonymous", AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
      ((Intent)localObject1).putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", a(paramSessionInfo));
      ((Intent)localObject1).getExtras().remove("forward_type");
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false)))
      {
        ((Intent)localObject1).putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
        ((Intent)localObject1).putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
        ((Intent)localObject1).putExtra("session_info", paramSessionInfo);
        ((Intent)localObject1).putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
        ((Intent)localObject1).putExtra("PhotoConst.MAXUM_SELECTED_NUM", Math.min(ReceiptUtil.b(paramQQAppInterface), j));
      }
      if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
        ((Intent)localObject1).putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      }
      if (i == -1) {
        paramActivity.startActivity((Intent)localObject1);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "enterPhotoPicker");
        }
        AlbumUtil.a(paramActivity, false, true);
        if (PeakUtils.a != null) {
          PeakUtils.a.b();
        }
        return;
        label854:
        SmartDeviceProxyMgr localSmartDeviceProxyMgr;
        label919:
        long l1;
        if ((paramActivity instanceof SplashActivity))
        {
          ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
          localObject1 = AIOUtils.a((Intent)localObject1, null);
          ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          ((Intent)localObject1).putExtra("key_activity_code", ChatActivityUtils.a(paramActivity));
          if (paramSessionInfo.jdField_a_of_type_Int != 9501) {
            break label1156;
          }
          if (!(paramActivity instanceof SplashActivity)) {
            break label1128;
          }
          ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
          localObject1 = AIOUtils.a((Intent)localObject1, null);
          ((Intent)localObject1).putExtra(AlbumConstants.h, 80);
          ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          ((Intent)localObject1).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
          ((Intent)localObject1).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
          localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)paramQQAppInterface.a(51);
          localObject2 = localObject1;
          if (localSmartDeviceProxyMgr != null)
          {
            localObject2 = localObject1;
            if (localSmartDeviceProxyMgr.a()) {
              l1 = 0L;
            }
          }
        }
        try
        {
          long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
          l1 = l2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        localObject2 = localObject1;
        if (localSmartDeviceProxyMgr.a(l1, 1)) {
          ((Intent)localObject1).putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
        }
        label1128:
        Object localObject3;
        for (localObject2 = localObject1;; localObject3 = localObject1)
        {
          ((Intent)localObject2).putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
          ((Intent)localObject2).putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          localObject1 = localObject2;
          break;
          if ((paramActivity instanceof LiteActivity))
          {
            ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
            break label854;
          }
          ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
          break label854;
          ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
          break label919;
          label1156:
          ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
          ((Intent)localObject1).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
          ((Intent)localObject1).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
          ((Intent)localObject1).putExtra("key_confess_topicid", paramSessionInfo.jdField_e_of_type_Int);
        }
        paramActivity.startActivityForResult((Intent)localObject1, i);
      }
      label1224:
      bool1 = false;
      i = -1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Uri paramUri, SessionInfo paramSessionInfo)
  {
    new uml(paramSessionInfo, paramQQAppInterface, paramContext, ImageUtil.b(paramContext, paramUri)).execute(new Void[0]);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, BaseChatPie paramBaseChatPie)
  {
    if (VideoActionSheet.a()) {
      return;
    }
    VideoActionSheet localVideoActionSheet = VideoActionSheet.a(paramContext);
    int[] arrayOfInt = new int[5];
    localVideoActionSheet.a(2131438345);
    if (((paramSessionInfo.jdField_a_of_type_Int == 1025) || (paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1004)) && (((QidianManager)paramQQAppInterface.getManager(164)).d(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      arrayOfInt[0] = 5;
      localVideoActionSheet.b(2131427338);
    }
    for (int i = 1;; i = 0)
    {
      arrayOfInt[i] = 1;
      localVideoActionSheet.b(2131433828);
      int j = i + 1;
      Object localObject1 = (PstnManager)paramQQAppInterface.getManager(142);
      Object localObject2 = ((PstnManager)localObject1).a(paramQQAppInterface.getCurrentAccountUin());
      PstnSessionInfo localPstnSessionInfo = PstnUtils.a(paramQQAppInterface, new PstnSessionInfo(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      int k;
      if ((localPstnSessionInfo.b != null) && (localPstnSessionInfo.jdField_c_of_type_JavaLangString != null))
      {
        localPstnSessionInfo.d = paramSessionInfo.d;
        if ((localObject2 != null) && (((PstnManager)localObject1).a() == 1) && (((PstnManager)localObject1).a().jdField_a_of_type_Int == 1)) {
          if (((PstnCardInfo)localObject2).pstn_c2c_call_time > 0)
          {
            localVideoActionSheet.a(paramQQAppInterface.getApplication().getBaseContext().getResources().getString(2131438343), paramQQAppInterface.getApplication().getBaseContext().getResources().getDrawable(2130840359), 0);
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063FD", "0X80063FD", 1, 0, "", "", "", "");
            i = 1;
            arrayOfInt[j] = 4;
            k = j + 1;
            j = i;
            i = k;
          }
        }
      }
      for (;;)
      {
        arrayOfInt[i] = 2;
        localVideoActionSheet.b(2131433825);
        if ((paramBaseChatPie instanceof FriendChatPie))
        {
          localObject1 = ((FriendChatPie)paramBaseChatPie).a();
          if (localObject1 != null)
          {
            if ((!NetworkUtil.d(paramContext)) || (TextUtils.isEmpty(((AIOJumpLightalkConfig)localObject1).jdField_e_of_type_JavaLangString))) {
              break label656;
            }
            localObject2 = URLDrawable.getDrawable(((AIOJumpLightalkConfig)localObject1).jdField_e_of_type_JavaLangString, 0, 0, null, null, false);
            localVideoActionSheet.a(((AIOJumpLightalkConfig)localObject1).d, (Drawable)localObject2, 0);
          }
        }
        for (;;)
        {
          arrayOfInt[(i + 1)] = 3;
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005B01", "0X8005B01", 0, 0, "", "", "", "");
          localVideoActionSheet.c(2131433015);
          localVideoActionSheet.a(new umg(paramQQAppInterface, arrayOfInt));
          localVideoActionSheet.a(new umh(localVideoActionSheet, arrayOfInt, j, paramQQAppInterface, paramContext, localPstnSessionInfo, paramSessionInfo, paramBaseChatPie, paramString));
          localVideoActionSheet.show();
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004D68", "0X8004D68", 0, 0, "", "", "", "");
          return;
          if ((((PstnManager)localObject1).b() == 1) && (((PstnCardInfo)localObject2).pstn_c2c_try_status == 0))
          {
            localVideoActionSheet.a(paramQQAppInterface.getApplication().getBaseContext().getResources().getString(2131438343), paramQQAppInterface.getApplication().getBaseContext().getResources().getDrawable(2130840358), 0);
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063FD", "0X80063FD", 3, 0, "", "", "", "");
            i = 2;
            break;
          }
          localVideoActionSheet.a(paramQQAppInterface.getApplication().getBaseContext().getResources().getString(2131438343), paramQQAppInterface.getApplication().getBaseContext().getResources().getDrawable(2130840357), 0);
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80063FD", "0X80063FD", 2, 0, "", "", "", "");
          i = 5;
          break;
          label656:
          localVideoActionSheet.c(((AIOJumpLightalkConfig)localObject1).d);
        }
        k = 0;
        i = j;
        j = k;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map paramMap)
  {
    String str2;
    String str1;
    if (paramBoolean)
    {
      str2 = "0X80049C5";
      switch (paramSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        str1 = "0";
      }
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", str2, str2, 0, 0, str1, "", "", "");
      b(paramQQAppInterface, paramContext, paramSessionInfo, paramBoolean, paramString, paramMap);
      return;
      str2 = "0X80049C7";
      break;
      str1 = "0";
      continue;
      str1 = "1";
      continue;
      str1 = "2";
      continue;
      str1 = "3";
      continue;
      str1 = "4";
      continue;
      str1 = "5";
      continue;
      str1 = "6";
      continue;
      str1 = "7";
      continue;
      str1 = "4";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, int paramInt)
  {
    QLog.i("Q.aio.xxx", 2, "[enterCamera] + Enter");
    if (AudioHelper.b(0)) {
      DialogUtil.a(paramContext, 230, paramContext.getString(2131433411), paramContext.getString(2131433412), new umm(), null).show();
    }
    do
    {
      return;
      if (AudioHelper.a(0))
      {
        DialogUtil.a(paramContext, 230, paramContext.getString(2131433411), paramContext.getString(2131433413), new umn(), null).show();
        return;
      }
      paramQQAppInterface.a().b();
      a(paramQQAppInterface, paramBaseActivity, 1, paramSessionInfo);
      NewFlowCameraReporter.k();
      paramBaseActivity.setCanLock(false);
    } while (paramSessionInfo.jdField_a_of_type_Int != 9501);
    SmartDeviceReport.a(paramQQAppInterface, Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 2, 0, paramInt);
  }
  
  public static void a(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!new File(paramString + ".nomedia").exists()) {
      ThreadManager.post(new umk(paramString), 5, null, false);
    }
  }
  
  public static boolean a(SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool4 = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpresend_whitelist.name());
    Object localObject = BaseApplication.getContext();
    int i;
    boolean bool2;
    boolean bool1;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", i);
      bool2 = ((SharedPreferences)localObject).getBoolean("key_presend_off_flag", false);
      bool1 = bool2;
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
      if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()))
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
      paramSessionInfo = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pic_presend.name(), "0|0|0|0|1|0|1|1|1048576|0|307200|307200|0|90|70|50");
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
              bool5 = paramSessionInfo[1].equals("1");
              bool6 = paramSessionInfo[2].equals("1");
              bool7 = paramSessionInfo[3].equals("1");
              i = NetworkUtil.a(BaseApplicationImpl.getContext());
            }
          }
        }
      }
      switch (i)
      {
      default: 
        label392:
        bool1 = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d("PEAK", 2, "isPresendAllowed netType = " + i + ",enablePreCompress_WIFI:" + bool2 + ", enablePreCompress_2G = " + bool5 + ", enablePreCompress_3G = " + bool6 + ", enablePreCompress_4G = " + bool7 + ", presendOFF  = " + paramBoolean);
          bool1 = paramBoolean;
        }
        if ((bool4) || (bool1)) {
          break;
        }
      }
    }
    for (paramBoolean = bool3;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "isPresendAllowed, isInDPCPicPresendWhiteList :" + bool4 + ", presendOFF = " + bool1 + ", result  = " + paramBoolean);
      }
      return paramBoolean;
      i = 0;
      break;
      if (!bool2)
      {
        paramBoolean = true;
        break label392;
      }
      paramBoolean = false;
      break label392;
      if (!bool5)
      {
        paramBoolean = true;
        break label392;
      }
      paramBoolean = false;
      break label392;
      if (!bool6)
      {
        paramBoolean = true;
        break label392;
      }
      paramBoolean = false;
      break label392;
      if (!bool7)
      {
        paramBoolean = true;
        break label392;
      }
      paramBoolean = false;
      break label392;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Grp", "Up_sent_files\t", 0, 0, "", paramSessionInfo.jdField_a_of_type_JavaLangString, "", "");
    paramQQAppInterface = new Intent(paramActivity, FMActivity.class);
    paramQQAppInterface.putExtra("from_aio", true);
    paramQQAppInterface.addFlags(536870912);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("tab_tab_type", 5);
    paramQQAppInterface.putExtra("key_check_troop_privilege", true);
    paramActivity.startActivityForResult(paramQQAppInterface, 5);
    paramActivity.overridePendingTransition(2131034123, 2131034124);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map paramMap)
  {
    Object localObject = (PhoneContactManager)paramQQAppInterface.getManager(10);
    String str;
    if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
      str = ((PhoneContactManager)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (localObject = paramSessionInfo.jdField_a_of_type_JavaLangString; paramString == null; localObject = ((PhoneContactManager)localObject).b(str))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.b, true, true, null, "from_internal", paramMap);
      return;
      str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
    ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.b, true, true, null, paramString, paramMap);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("bEnterToSelect", true);
    localIntent.putExtra("paSessionInfo", paramSessionInfo);
    QfavHelper.a(paramActivity, paramQQAppInterface.getAccount(), localIntent, -1, false);
    QfavReport.b(paramQQAppInterface, 3, paramSessionInfo.jdField_a_of_type_Int);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = new Intent(paramActivity, FMLocalFileActivity.class);
    paramQQAppInterface.putExtra("category", 15);
    paramQQAppInterface.putExtra("busiType", 5);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("STRING_Show_Music_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Video_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Apk_Category", false);
    paramQQAppInterface.putExtra("STRING_Show_Pic_Category", false);
    paramQQAppInterface.putExtra("STRING_SingleSelect", false);
    paramQQAppInterface.putExtra("max_select_count", 5);
    paramQQAppInterface.putExtra(AlbumConstants.h, 84);
    paramQQAppInterface.putExtra("STRING_Show_Within_Suffixs", new String[] { "doc", "docx", "txt", "pdf", "ppt", "pptx", "xls", "xlsx", "bmp", "jpg", "gif", "png" });
    paramActivity.startActivityForResult(paramQQAppInterface, 84);
    AlbumUtil.a(paramActivity, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanelUtils
 * JD-Core Version:    0.7.0.1
 */
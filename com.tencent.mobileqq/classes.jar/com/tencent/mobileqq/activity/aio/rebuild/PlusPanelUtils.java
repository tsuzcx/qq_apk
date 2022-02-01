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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ReplacePhotoDataUtil;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.PanelData;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocSelectAddDocsBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocSelectAddDocsProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pic.IPresendPicMgr;
import com.tencent.mobileqq.pic.PresendPicMgrService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PlusPanelUtils
{
  static int jdField_a_of_type_Int;
  private static TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver;
  public static String a;
  static int b;
  public static String b;
  private static int c;
  
  static
  {
    jdField_c_of_type_Int = -1;
    jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = null;
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
  }
  
  public static int a()
  {
    return jdField_c_of_type_Int;
  }
  
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
    for (int i = 5;; i = 6)
    {
      if (AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
        i = 1;
      }
      return i;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent1, Intent paramIntent2)
  {
    int j = 20;
    int i = -1;
    Object localObject;
    if ((paramIntent1 == null) || (!paramIntent1.hasExtra("showFlashPic")))
    {
      localObject = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      paramIntent2.putExtra("showFlashPic", FlashPicHelper.a(paramSessionInfo.jdField_a_of_type_Int, (HotChatManager)localObject, paramSessionInfo.jdField_b_of_type_JavaLangString));
    }
    paramIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    boolean bool2;
    boolean bool1;
    if ((!(paramActivity instanceof SplashActivity)) && (!(paramActivity instanceof ChatActivity)) && (!(paramActivity instanceof LiteActivity)))
    {
      paramIntent2.putExtras(paramActivity.getIntent());
      paramIntent2.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      if (paramIntent1 == null) {
        break label1138;
      }
      i = paramIntent1.getIntExtra("peakconstant.request_code", -1);
      paramIntent2.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent1.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      j = paramIntent1.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      bool2 = paramIntent1.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      bool1 = paramIntent1.getBooleanExtra("filter_photolist_troopalbum_toolbar", false);
      int k = paramIntent1.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      if (k == 1039) {
        paramIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
      }
      if (k == 1040) {
        paramIntent2.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      }
      paramIntent2.putExtra("PhotoConst.is_troop_send_mixed_msg", paramIntent1.getBooleanExtra("PhotoConst.is_troop_send_mixed_msg", false));
      PhotoUtils.copyReportInfo(paramIntent1, paramIntent2);
      paramIntent2.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", paramIntent1.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", false));
      paramIntent2.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", paramIntent1.getBooleanExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", false));
      paramIntent2.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", paramIntent1.getBooleanExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", false));
      paramIntent2.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", paramIntent1.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false));
      paramIntent2.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", paramIntent1.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false));
      paramIntent2.putExtra("fromPhotoListPanel", paramIntent1.getBooleanExtra("fromPhotoListPanel", false));
      paramIntent2.putExtra("KEY_IS_ANONYMOUS", paramIntent1.getBooleanExtra("KEY_IS_ANONYMOUS", false));
      paramIntent2.putExtra("PhotoConst.SEND_NO_PRESEND", paramIntent1.getBooleanExtra("PhotoConst.SEND_NO_PRESEND", false));
    }
    for (;;)
    {
      if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
        paramIntent2.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", true);
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 9501) {
        paramIntent2.putExtra("isdevicesupportmultiupload", true);
      }
      paramIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", bool2);
      paramIntent2.putExtra("filter_photolist_troopalbum_toolbar", bool1);
      paramIntent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", j);
      paramIntent2.putExtra("extra_image_sender_tag", "sessionInfo.enterAlbum");
      paramIntent2.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      paramIntent2.putExtra("album_enter_directly", true);
      paramIntent2.putExtra("ALBUM_ID", AlbumUtil.a(paramActivity));
      paramIntent2.putExtra("ALBUM_NAME", AlbumUtil.b(paramActivity));
      paramIntent2.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      paramIntent2.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent2.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent2.putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
      paramIntent2.putExtra("uinname", paramSessionInfo.d);
      paramIntent2.putExtra("entrance", paramSessionInfo.jdField_c_of_type_Int);
      paramIntent2.putExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if ((((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))) && (((FragmentActivity)paramActivity).getChatFragment() != null)) {
        paramIntent2.putExtra("isBack2Root", ((FragmentActivity)paramActivity).getChatFragment().a().i);
      }
      paramIntent2.putExtra("is_anonymous", AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
      paramIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", a(paramSessionInfo));
      paramIntent2.getExtras().remove("forward_type");
      if ((paramIntent1 != null) && (paramIntent1.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false)))
      {
        paramIntent2.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
        paramIntent2.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", true);
        paramIntent2.putExtra("session_info", paramSessionInfo);
        paramIntent2.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", true);
        paramIntent2.putExtra("PhotoConst.MAXUM_SELECTED_NUM", Math.min(ReceiptUtil.b(paramQQAppInterface), j));
      }
      paramIntent2.putExtra("session_info", paramSessionInfo);
      if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
        paramIntent2.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PEAK", 2, "enterAlbum() INIT_ACTIVITY_CLASS_NAME=" + paramIntent2.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
        QLog.d("PlusPanelUtils", 2, "enterAlbum  maxNum = " + j);
      }
      return i;
      paramIntent2.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      localObject = paramIntent2;
      if ((paramActivity instanceof SplashActivity)) {
        localObject = AIOUtils.a(paramIntent2, null);
      }
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("key_activity_code", ChatActivityUtils.a(paramActivity));
      if (paramSessionInfo.jdField_a_of_type_Int == 9501)
      {
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
        ((Intent)localObject).putExtra(AlbumConstants.h, 80);
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        ((Intent)localObject).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
        paramIntent2 = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
        long l1;
        if ((paramIntent2 != null) && (paramIntent2.a())) {
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
            localException.printStackTrace();
          }
        }
        if (paramIntent2.a(l1, 1)) {
          ((Intent)localObject).putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
        }
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
        ((Intent)localObject).putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramIntent2 = (Intent)localObject;
        break;
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
        ((Intent)localObject).putExtra("key_confess_topicid", paramSessionInfo.jdField_e_of_type_Int);
      }
      label1138:
      bool1 = false;
      bool2 = false;
    }
  }
  
  private static PlusPanelUtils.SendHbParamOfPanel a(PanelData paramPanelData)
  {
    int i;
    String str;
    if (RedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(paramPanelData.jdField_a_of_type_Int)) == null)
    {
      i = 1;
      str = String.valueOf(2);
      switch (paramPanelData.jdField_a_of_type_Int)
      {
      case 4: 
      case 5: 
      default: 
        paramPanelData = "";
      }
    }
    for (;;)
    {
      PlusPanelUtils.SendHbParamOfPanel localSendHbParamOfPanel = new PlusPanelUtils.SendHbParamOfPanel(null);
      localSendHbParamOfPanel.jdField_a_of_type_JavaLangString = str;
      localSendHbParamOfPanel.jdField_a_of_type_Int = i;
      localSendHbParamOfPanel.jdField_b_of_type_JavaLangString = paramPanelData;
      return localSendHbParamOfPanel;
      i = ((Integer)RedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(paramPanelData.jdField_a_of_type_Int))).intValue();
      break;
      str = String.valueOf(1);
      paramPanelData = "13140";
      continue;
      str = String.valueOf(2);
      paramPanelData = "13141";
      continue;
      paramPanelData = "13142";
      continue;
      paramPanelData = "13146";
      continue;
      paramPanelData = "13147";
      continue;
      paramPanelData = "";
      i = 1;
    }
  }
  
  private static PlusPanelUtils.SendHbParamOfSession a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = 1;
    int j = 1;
    Object localObject2 = "";
    Object localObject1 = (PasswdRedBagManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    if (localObject1 != null) {}
    for (localObject1 = ((PasswdRedBagManager)localObject1).a();; localObject1 = "")
    {
      if (paramSessionInfo.jdField_a_of_type_Int == 0)
      {
        i = 1;
        paramQQAppInterface = "entrance.click.c2c";
        paramSessionInfo = (SessionInfo)localObject2;
      }
      for (;;)
      {
        localObject2 = new PlusPanelUtils.SendHbParamOfSession(null);
        ((PlusPanelUtils.SendHbParamOfSession)localObject2).jdField_b_of_type_JavaLangString = paramQQAppInterface;
        ((PlusPanelUtils.SendHbParamOfSession)localObject2).jdField_a_of_type_Int = j;
        ((PlusPanelUtils.SendHbParamOfSession)localObject2).jdField_b_of_type_Int = i;
        ((PlusPanelUtils.SendHbParamOfSession)localObject2).jdField_a_of_type_JavaLangString = paramSessionInfo;
        ((PlusPanelUtils.SendHbParamOfSession)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
        return localObject2;
        if (paramSessionInfo.jdField_a_of_type_Int == 3000)
        {
          j = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
          paramQQAppInterface = "entrance.click.group";
          i = 2;
          paramSessionInfo = (SessionInfo)localObject2;
        }
        else
        {
          if (paramSessionInfo.jdField_a_of_type_Int == 1)
          {
            Object localObject3 = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
            j = i;
            if (localObject3 != null)
            {
              j = ((TroopInfo)localObject3).wMemberNum;
              if (QLog.isColorLevel()) {
                QLog.d("PlusPanelUtils", 2, "troop uin：" + paramSessionInfo.jdField_a_of_type_JavaLangString + " people_num：" + j);
              }
            }
            if (QWalletHelperImpl.isNeedUpdateTroopMemberNum(paramSessionInfo.jdField_a_of_type_JavaLangString)) {}
            try
            {
              long l = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
              localObject3 = (TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
              if (jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver == null) {
                jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new PlusPanelUtils.10(paramSessionInfo);
              }
              paramQQAppInterface.addObserver(jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
              ((TroopHandler)localObject3).b(l, 32, 0);
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
            localObject3 = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
            if ((localObject3 != null) && (((HotChatManager)localObject3).b(paramSessionInfo.jdField_a_of_type_JavaLangString)))
            {
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005B9C", "0X8005B9C", 0, 0, "", "", "", "");
              i = 6;
              paramQQAppInterface = "entrance.click.chatgroup";
              paramSessionInfo = (SessionInfo)localObject2;
              continue;
            }
          }
          if (paramSessionInfo.jdField_a_of_type_Int == 1000)
          {
            i = 4;
            paramQQAppInterface = "entrance.click.c2c";
            paramSessionInfo = paramSessionInfo.jdField_b_of_type_JavaLangString;
          }
          else if (paramSessionInfo.jdField_a_of_type_Int == 1004)
          {
            i = 5;
            paramQQAppInterface = "entrance.click.c2c";
            paramSessionInfo = paramSessionInfo.jdField_b_of_type_JavaLangString;
          }
          else
          {
            if ((paramSessionInfo.jdField_a_of_type_Int == 1001) || (paramSessionInfo.jdField_a_of_type_Int == 10002) || (paramSessionInfo.jdField_a_of_type_Int == 10004))
            {
              if (paramSessionInfo.jdField_a_of_type_Int == 10004)
              {
                paramSessionInfo = paramQQAppInterface.getMsgCache().l(paramSessionInfo.jdField_a_of_type_JavaLangString);
                label511:
                if (paramSessionInfo == null) {
                  break label579;
                }
              }
              label579:
              for (paramSessionInfo = Base64Util.encodeToString(paramSessionInfo, 2);; paramSessionInfo = "")
              {
                ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005B9D", "0X8005B9D", 0, 0, "", "", "", "");
                paramQQAppInterface = "entrance.click.c2c";
                i = 7;
                break;
                paramSessionInfo = paramQQAppInterface.getMsgCache().m(paramSessionInfo.jdField_a_of_type_JavaLangString);
                break label511;
              }
            }
            paramQQAppInterface = "";
            i = 0;
            paramSessionInfo = (SessionInfo)localObject2;
          }
        }
      }
    }
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
    int i = 1;
    Object localObject = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.append("IMG");
    localStringBuilder.append(((Calendar)localObject).get(1));
    int j = ((Calendar)localObject).get(2) + 1;
    if (j < 10)
    {
      paramString = "0" + j;
      localStringBuilder.append(paramString);
      j = ((Calendar)localObject).get(5);
      if (j >= 10) {
        break label322;
      }
      paramString = "0" + j;
      label115:
      localStringBuilder.append(paramString);
      j = ((Calendar)localObject).get(11);
      if (j >= 10) {
        break label330;
      }
      paramString = "0" + j;
      label157:
      localStringBuilder.append(paramString);
      j = ((Calendar)localObject).get(12);
      if (j >= 10) {
        break label338;
      }
      paramString = "0" + j;
      label199:
      localStringBuilder.append(paramString);
      j = ((Calendar)localObject).get(13);
      if (j >= 10) {
        break label346;
      }
      paramString = "0" + j;
      label241:
      localStringBuilder.append(paramString);
      if (!paramBoolean) {
        break label354;
      }
    }
    label322:
    label330:
    label338:
    label346:
    label354:
    for (paramString = ".mp4";; paramString = ".jpg")
    {
      if (new File(localStringBuilder.toString() + paramString).exists()) {
        break label361;
      }
      return localStringBuilder.toString() + paramString;
      paramString = Integer.valueOf(j);
      break;
      paramString = Integer.valueOf(j);
      break label115;
      paramString = Integer.valueOf(j);
      break label157;
      paramString = Integer.valueOf(j);
      break label199;
      paramString = Integer.valueOf(j);
      break label241;
    }
    label361:
    localObject = new StringBuilder(localStringBuilder);
    j = localStringBuilder.length();
    for (;;)
    {
      if (i < 2147483647)
      {
        ((StringBuilder)localObject).append('(');
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(')');
        ((StringBuilder)localObject).append(paramString);
        if (new File(((StringBuilder)localObject).toString()).exists()) {}
      }
      else
      {
        return ((StringBuilder)localObject).toString();
      }
      ((StringBuilder)localObject).delete(j, ((StringBuilder)localObject).length());
      i += 1;
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_c_of_type_Int = paramInt;
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("enter_from", 1);
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
    paramActivity.startActivityForResult(localIntent, 100017);
    AlbumUtil.anim(paramActivity, false, true);
  }
  
  private static void a(Activity paramActivity, PanelData paramPanelData, PlusPanelUtils.SendHbParamOfSession paramSendHbParamOfSession, PlusPanelUtils.SendHbParamOfPanel paramSendHbParamOfPanel, SessionInfo paramSessionInfo)
  {
    if (paramActivity == null) {
      return;
    }
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramActivity, "/qwallet/redpacket/sendhb");
    localActivityURIRequest.extra().putInt("come_from", 2);
    localActivityURIRequest.extra().putString("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#aio");
    localActivityURIRequest.extra().putBoolean("isFromPanel", true);
    if ((paramPanelData != null) && (paramPanelData.jdField_a_of_type_Int == 3)) {
      if (paramPanelData.jdField_a_of_type_OrgJsonJSONObject == null) {
        break label350;
      }
    }
    label350:
    for (paramActivity = paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("theme_id", "");; paramActivity = "")
    {
      localActivityURIRequest.extra().putString("theme_type", paramActivity);
      localActivityURIRequest.extra().putBoolean("theme", true);
      long l = VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + paramSendHbParamOfSession.jdField_b_of_type_Int, 0, null);
      localActivityURIRequest.extra().putLong("vacreport_key_seq", l);
      paramActivity = new JSONObject();
      try
      {
        paramActivity.put("recv_type", paramSendHbParamOfSession.jdField_b_of_type_Int);
        paramActivity.put("recv_uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
        paramActivity.put("channel", paramSendHbParamOfPanel.jdField_a_of_type_Int);
        paramActivity.put("bus_type", paramSendHbParamOfPanel.jdField_a_of_type_JavaLangString);
        if (paramSendHbParamOfSession.jdField_a_of_type_Int > 0) {
          paramActivity.put("people_num", paramSendHbParamOfSession.jdField_a_of_type_Int);
        }
        if (!TextUtils.isEmpty(paramSendHbParamOfSession.jdField_a_of_type_JavaLangString)) {
          paramActivity.put("session_token", paramSendHbParamOfSession.jdField_a_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(paramSendHbParamOfSession.jdField_c_of_type_JavaLangString)) {
          paramActivity.put("placeholder", paramSendHbParamOfSession.jdField_c_of_type_JavaLangString);
        }
      }
      catch (JSONException paramPanelData)
      {
        for (;;)
        {
          paramPanelData.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "click HongBao:params=" + paramActivity.toString());
      }
      localActivityURIRequest.extra().putString("extra_data", paramActivity.toString());
      QRoute.startUri(localActivityURIRequest, new PlusPanelUtils.12());
      return;
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
    if (a(paramSessionInfo, paramQQAppInterface.isLBSFriendNewClient(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "prepareForPicPresend add binder!");
      }
      paramIntent.putExtra("binder_presendService", new BinderWarpper(new PresendPicMgrService(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramQQAppInterface.getAccount(), paramSessionInfo.jdField_e_of_type_Int).asBinder()));
    }
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (((QQAppInterface)paramAppInterface).isVideoChatting())) {}
    for (;;)
    {
      return;
      if (!Utils.a())
      {
        QQToast.a(paramActivity, paramActivity.getResources().getString(2131718859), 0).a();
        return;
      }
      paramAppInterface = AppConstants.SDCARD_IMG_CAMERA;
      boolean bool;
      label56:
      Object localObject;
      if (paramInt2 == 1)
      {
        bool = true;
        paramAppInterface = a(paramAppInterface, bool);
        localObject = new File(AppConstants.SDCARD_IMG_CAMERA);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", paramAppInterface).commit();
        localObject = new Intent();
        if (paramInt2 != 0) {
          break label202;
        }
        FileProvider7Helper.setSystemCapture(paramActivity, new File(paramAppInterface), (Intent)localObject);
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_camera");
        ((Intent)localObject).putExtra("android.intent.extra.quickCapture", true);
        ((Intent)localObject).setFlags(536870912);
      }
      try
      {
        paramActivity.startActivityForResult((Intent)localObject, paramInt1);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PlusPanelUtils", 2, "enter sys camera");
        return;
        bool = false;
        break label56;
        label202:
        ((Intent)localObject).setAction("android.media.action.VIDEO_CAPTURE");
        ((Intent)localObject).putExtra("output", Uri.fromFile(new File(paramAppInterface)));
        ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 100);
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          paramAppInterface.printStackTrace();
          QQToast.a(paramActivity, 2131690797, 0).a();
        }
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    a(paramBaseActivity.app, paramBaseActivity, paramSessionInfo, null, null);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, SessionInfo paramSessionInfo, PlusPanelUtils.SendHbParamOfSession paramSendHbParamOfSession, PlusPanelUtils.SendHbParamOfPanel paramSendHbParamOfPanel)
  {
    if (paramInt == 0)
    {
      AIOPanelUtiles.a(paramQQAppInterface, "0X8005CAF", paramSessionInfo.jdField_a_of_type_Int);
      if (jdField_c_of_type_Int != 0) {
        break label104;
      }
      paramSendHbParamOfSession.jdField_b_of_type_JavaLangString += ".plus";
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramSendHbParamOfSession.jdField_b_of_type_JavaLangString, 0, 0, paramSendHbParamOfPanel.jdField_b_of_type_JavaLangString, "", "", "");
      return;
      if (paramInt != 1) {
        break;
      }
      AIOPanelUtiles.a(paramQQAppInterface, "0X8005FC9", paramSessionInfo.jdField_a_of_type_Int);
      break;
      label104:
      if (jdField_c_of_type_Int == 1) {
        paramSendHbParamOfSession.jdField_b_of_type_JavaLangString += ".quick";
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    try
    {
      BaseChatPie localBaseChatPie = ((FragmentActivity)paramActivity).getChatFragment().a();
      localBaseChatPie.aG();
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
    paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
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
          localIntent.putExtra("srcDiscGroup", paramSessionInfo.jdField_b_of_type_JavaLangString);
        }
        for (;;)
        {
          if (paramSessionInfo.jdField_a_of_type_Int != 0) {
            break label359;
          }
          localIntent.putExtra("qfile_entrance_type_key", 1);
          break;
          if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
            localIntent.putExtra("srcDiscGroup", paramSessionInfo.jdField_e_of_type_JavaLangString);
          } else {
            localIntent.putExtra("srcDiscGroup", paramSessionInfo.jdField_c_of_type_JavaLangString);
          }
        }
        if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
          localIntent.putExtra("qfile_entrance_type_key", 5);
        } else if (paramSessionInfo.jdField_a_of_type_Int == 1) {
          localIntent.putExtra("qfile_entrance_type_key", 3);
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
      if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)) {
        localIntent.putExtra("select_file_support_send_docs_file", TencentDocSelectAddDocsProcessor.a().a());
      }
      paramActivity.startActivityForResult(localIntent, 5);
      paramActivity.overridePendingTransition(2130771981, 2130771982);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    QwUtils.a(paramQQAppInterface, "tenpay.com", new PlusPanelUtils.13(paramInt1, paramSessionInfo, paramQQAppInterface, paramInt2, paramString, paramActivity));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean)
  {
    paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
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
      paramActivity.overridePendingTransition(2130771981, 2130771982);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, PanelData paramPanelData, List<PanelData> paramList, int paramInt)
  {
    if (paramPanelData == null) {
      return;
    }
    a(paramList);
    paramList = a(paramQQAppInterface, paramSessionInfo);
    if (a(paramQQAppInterface, paramActivity, paramPanelData, paramSessionInfo, paramList))
    {
      QLog.i("PlusPanelUtils", 2, "---doSendHbJumpNoEnterSendHbActivity---");
      return;
    }
    PlusPanelUtils.SendHbParamOfPanel localSendHbParamOfPanel = a(paramPanelData);
    a(paramActivity, paramPanelData, paramList, localSendHbParamOfPanel, paramSessionInfo);
    a(paramQQAppInterface, paramInt, paramSessionInfo, paramList, localSendHbParamOfPanel);
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
      paramActivity.overridePendingTransition(2130771981, 0);
      return;
      paramQQAppInterface.putExtra("url", paramString.replace("$FriendUin$", paramSessionInfo.jdField_a_of_type_JavaLangString).replace("$CurType$", String.valueOf(paramSessionInfo.jdField_a_of_type_Int)));
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanelUtils", 2, "enterQQMusic url is get from file");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent)
  {
    a(paramQQAppInterface, paramActivity, paramSessionInfo, paramArrayList, paramIntent, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, ArrayList<String> paramArrayList, Intent paramIntent, HashMap<LocalMediaInfo, LocalMediaInfo> paramHashMap)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
      paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      paramIntent.putExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      paramIntent.putExtra("PhotoConst.MY_UIN", paramSessionInfo.h);
      paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
      paramIntent.putExtra("KEY_IS_ANONYMOUS", AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
      localIntent.putExtra("enter_from", 1);
      int i = a(paramQQAppInterface, paramActivity, paramSessionInfo, paramArrayList, paramIntent, localIntent);
      if (i == -1) {
        paramActivity.startActivity(localIntent);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "enterPhotoPicker");
        }
        AlbumUtil.anim(paramActivity, false, true);
        if (PeakUtils.a != null) {
          PeakUtils.a.b();
        }
        return;
        paramQQAppInterface = ReplacePhotoDataUtil.a(paramHashMap);
        if (paramQQAppInterface != null) {
          localIntent.putExtra("PhotoConst.editPathMap", paramQQAppInterface);
        }
        paramActivity.startActivityForResult(localIntent, i);
      }
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
    localVideoActionSheet.setMainTitle(2131689515);
    if (((paramSessionInfo.jdField_a_of_type_Int == 1025) || (paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1004)) && (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).d(paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      arrayOfInt[0] = 5;
      localVideoActionSheet.addButton(2131698261);
    }
    for (int i = 1;; i = 0)
    {
      arrayOfInt[i] = 1;
      localVideoActionSheet.addButton(2131720000);
      i += 1;
      arrayOfInt[i] = 2;
      localVideoActionSheet.addButton(2131720014);
      localVideoActionSheet.addCancelButton(2131690800);
      localVideoActionSheet.setOnDismissListener(new PlusPanelUtils.1(paramQQAppInterface));
      localVideoActionSheet.setOnButtonClickListener(new PlusPanelUtils.2(localVideoActionSheet, arrayOfInt, paramSessionInfo, paramQQAppInterface, paramBaseChatPie, paramContext, paramString));
      localVideoActionSheet.show();
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004D68", "0X8004D68", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, String paramString, Map<String, String> paramMap)
  {
    Object localObject2;
    Object localObject1;
    label60:
    int i;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("enterVideo, onlyAudio[").append(paramBoolean).append("], type[");
      if (paramSessionInfo == null)
      {
        localObject1 = null;
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append("], uin[");
        if (paramSessionInfo != null) {
          break label139;
        }
        localObject1 = null;
        QLog.i("PlusPanelUtils", 2, (String)localObject1 + "], from[" + paramString + "]");
      }
    }
    else
    {
      if (!paramBoolean) {
        break label148;
      }
      i = 1;
      label101:
      if ((paramSessionInfo == null) || (!paramQQAppInterface.getAVNotifyCenter().a(paramContext, i, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label154;
      }
    }
    label139:
    label148:
    label154:
    do
    {
      return;
      localObject1 = Integer.valueOf(paramSessionInfo.jdField_a_of_type_Int);
      break;
      localObject1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      break label60;
      i = 2;
      break label101;
      if (!paramBoolean) {
        break label307;
      }
      localObject2 = "0X80049C5";
    } while (paramSessionInfo == null);
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      localObject1 = "0";
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, (String)localObject1, "", "", "");
      b(paramQQAppInterface, paramContext, paramSessionInfo, paramBoolean, paramString, paramMap);
      return;
      label307:
      localObject2 = "0X80049C7";
      break;
      localObject1 = "0";
      continue;
      localObject1 = "1";
      continue;
      localObject1 = "2";
      continue;
      localObject1 = "3";
      continue;
      localObject1 = "4";
      continue;
      localObject1 = "5";
      continue;
      localObject1 = "6";
      continue;
      localObject1 = "7";
      continue;
      localObject1 = "30";
      continue;
      localObject1 = "4";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PlusPanelUtils", 2, "enter Camera");
    }
    if (AudioHelper.b(0))
    {
      DialogUtil.a(paramContext, 230, paramContext.getString(2131698445), paramContext.getString(2131698446), new PlusPanelUtils.7(), null).show();
      return;
    }
    if (AudioHelper.a(0))
    {
      DialogUtil.a(paramContext, 230, paramContext.getString(2131698445), paramContext.getString(2131698447), new PlusPanelUtils.8(), null).show();
      return;
    }
    if (paramQQAppInterface.getApp().checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) != 0)
    {
      DialogUtil.a(paramContext, 230, paramContext.getString(2131698445), HardCodeUtil.a(2131708291), new PlusPanelUtils.9(), null).show();
      return;
    }
    if (paramInt2 == 0) {}
    for (int i = 1;; i = 17000)
    {
      a(paramQQAppInterface, paramBaseActivity, i, paramInt2);
      NewFlowCameraReporter.k();
      paramBaseActivity.setCanLock(false);
      if (paramSessionInfo.jdField_a_of_type_Int != 9501) {
        break;
      }
      SmartDeviceReport.a(paramQQAppInterface, Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 2, 0, paramInt1);
      return;
    }
  }
  
  private static void a(List<PanelData> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      RedPacketManager.CURRENT_PANEL_DATA.clear();
      RedPacketManager.CURRENT_PANEL_DATA.addAll(paramList);
    }
  }
  
  public static boolean a(SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool4 = ((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpresend_whitelist.name());
    Object localObject = BaseApplication.getContext();
    int i;
    boolean bool1;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", i);
      bool1 = ((SharedPreferences)localObject).getBoolean("key_presend_off_flag", false);
      if (!bool1) {
        break label633;
      }
      long l = ((SharedPreferences)localObject).getLong("key_presend_off_time", 0L);
      if (System.currentTimeMillis() - l <= 86400000L) {
        break label633;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "isPresendAllowed,PicPresend off more than 24h ,enable PicPresend!");
      }
      ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", false).commit();
      bool1 = false;
    }
    label408:
    label633:
    for (;;)
    {
      if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCAccountNames.picpredownload_whitelist.name()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "isPresendAllowed ,is VIP User");
        }
        bool1 = false;
      }
      boolean bool2;
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
      boolean bool5;
      boolean bool6;
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
              bool1 = paramSessionInfo[0].equals("1");
              bool2 = paramSessionInfo[1].equals("1");
              bool5 = paramSessionInfo[2].equals("1");
              bool6 = paramSessionInfo[3].equals("1");
              i = NetworkUtil.a(BaseApplicationImpl.getContext());
            }
          }
        }
      }
      switch (i)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "isPresendAllowed netType = " + i + ",enablePreCompress_WIFI:" + bool1 + ", enablePreCompress_2G = " + bool2 + ", enablePreCompress_3G = " + bool5 + ", enablePreCompress_4G = " + bool6 + ", presendOFF  = " + paramBoolean);
        }
        bool1 = paramBoolean;
        if ((bool4) || (bool1)) {
          break;
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
        if (!bool1)
        {
          paramBoolean = true;
          break label408;
        }
        paramBoolean = false;
        break label408;
        if (!bool2)
        {
          paramBoolean = true;
          break label408;
        }
        paramBoolean = false;
        break label408;
        if (!bool5)
        {
          paramBoolean = true;
          break label408;
        }
        paramBoolean = false;
        break label408;
        if (!bool6)
        {
          paramBoolean = true;
          break label408;
        }
        paramBoolean = false;
        break label408;
      }
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, PanelData paramPanelData, SessionInfo paramSessionInfo, PlusPanelUtils.SendHbParamOfSession paramSendHbParamOfSession)
  {
    switch (paramPanelData.jdField_a_of_type_Int)
    {
    default: 
      return false;
    case 5: 
      long l = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "plus.hongbao.click", 0, 0, "", "", "", "");
      paramQQAppInterface = new ActivityURIRequest(paramActivity, "/qwallet/redpacket/QrcodeHbGuider");
      paramQQAppInterface.extra().putLong("vacreport_key_seq", l);
      paramQQAppInterface.extra().putString("appInfo", "");
      QRoute.startUri(paramQQAppInterface, new PlusPanelUtils.11());
      return true;
    case 4: 
      if (paramPanelData.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        localObject = paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("url", "");
        QLog.i("PlusPanelUtils", 2, (String)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return true;
        }
        paramQQAppInterface = (QQAppInterface)localObject;
        if (paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optInt("subtype", 0) == 1) {
          if (((String)localObject).indexOf("?") != -1) {
            break label272;
          }
        }
      }
      for (paramQQAppInterface = (String)localObject + "?recv_uin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + "&recv_type=" + paramSendHbParamOfSession.jdField_b_of_type_Int;; paramQQAppInterface = (String)localObject + "&recv_uin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + "&recv_type=" + paramSendHbParamOfSession.jdField_b_of_type_Int)
      {
        a(paramActivity, paramQQAppInterface);
        return true;
      }
    case 12: 
      label272:
      paramPanelData = paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("schema");
      QLog.i("PlusPanelUtils", 2, paramPanelData);
      if (TextUtils.isEmpty(paramPanelData)) {
        return true;
      }
      a(paramQQAppInterface, paramActivity, paramSessionInfo, paramSendHbParamOfSession.jdField_b_of_type_Int, paramSendHbParamOfSession.jdField_a_of_type_Int, paramPanelData);
      return true;
    }
    paramPanelData = paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("schema", "");
    QLog.i("PlusPanelUtils", 2, paramPanelData);
    if (TextUtils.isEmpty(paramPanelData)) {
      return true;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("recv_group_type", paramSendHbParamOfSession.jdField_b_of_type_Int + "");
    ((Map)localObject).put("recv_group_id", paramSessionInfo.jdField_a_of_type_JavaLangString);
    ((Map)localObject).put("send_uin", paramQQAppInterface.getCurrentUin());
    paramQQAppInterface = QwUtils.a(paramPanelData, (Map)localObject, true);
    if (QLog.isColorLevel()) {
      QLog.i("PlusPanelUtils", 2, "[go to miniapp] finalSchame: " + paramQQAppInterface);
    }
    QWalletRedPkgUtils.a(paramActivity, paramQQAppInterface);
    return true;
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
    Object localObject = (PhoneContactManager)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
    String str;
    if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
      str = ((PhoneContactManager)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (localObject = paramSessionInfo.jdField_a_of_type_JavaLangString; paramString == null; localObject = ((PhoneContactManager)localObject).b(str))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.jdField_b_of_type_JavaLangString, true, true, null, "from_internal", paramMap);
      return;
      str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
    ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_Int, str, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.jdField_b_of_type_JavaLangString, true, true, null, paramString, paramMap);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
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
    AlbumUtil.anim(paramActivity, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils
 * JD-Core Version:    0.7.0.1
 */
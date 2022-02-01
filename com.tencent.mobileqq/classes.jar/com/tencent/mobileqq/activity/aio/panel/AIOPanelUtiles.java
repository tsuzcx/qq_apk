package com.tencent.mobileqq.activity.aio.panel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.troop.troopphoto.api.ITroopPhotoHandler;
import com.tencent.mobileqq.widget.SwipeUpAndDragListener;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.manager.ServerConfigManager.ConfigType;

public class AIOPanelUtiles
{
  public static final int[] A = { 9, 2131896495, 2130838177, 2131442174, 0 };
  public static final int[] B = { 9, 2131896495, 2130846243, 2131442174, 0 };
  public static final int[] C = { 10, 2131896483, 2130838131, 2131442157, 0, 2130852016, 2130852017 };
  public static final int[] D = { 10, 2131896483, 2130846246, 2131442157, 0 };
  public static final int[] E = { 12, 2131896477, 2130838188, 2131442144, 0 };
  public static final int[] F = { 13, 2131896478, 2130838185, 2131442145, 0 };
  public static final int[] G = { 14, 2131896485, 2130838126, 2131442162, 0 };
  public static final int[] H = { 14, 2131896485, 2130846245, 2131442162, 0 };
  public static final int[] I = { 19, 2131896486, 2130838167, 2131442164, 0 };
  public static final int[] J = { 19, 2131896486, 2130846250, 2131442164, 0 };
  public static final int[] K = { 16, 2131896481, 2130838123, 2131442154, 0 };
  public static final int[] L = { 17, 2131896489, 2130838164, 2131442168, 0 };
  public static int[] M = { 23, 2131896491, 2130838176, 2131442173, 0, 2130852061, 2130852062 };
  public static final int[] N = { 26, 2131896501, 2130838176, 2131442188, 0 };
  public static final int[] O = { 24, 2131896484, 2130838132, 2131442158, 2130838057, 2130838152, 2130838154 };
  public static final int[] P = { 24, 2131896484, 2130846243, 2131442158, 0 };
  public static final int[] Q = { 31, 2131896490, 2130838168, 2131442169, 0 };
  public static final int[] R = { 32, 2131896482, 2130838130, 2131442156, 0 };
  public static final int[] S = { 24, 2131896484, 2130838134, 2131442159, 0 };
  public static final int[] T = { 24, 2131896484, 2130838133, 2131442159, 0 };
  public static final int[] U = { 29, 2131892386, 2130851981, 2131442140, 0 };
  public static final int[] V = { 29, 2131892386, 2130846242, 2131442140, 0 };
  public static final int[] W = { 21, 2131887429, 2130838414, 2131442139, 0 };
  public static final int[] X = { 21, 2131887429, 2130846240, 2131442139, 0 };
  public static final int[] Y = { 21, 2131887429, 2130838463, 2131442143, 0 };
  public static final int[] Z = { 40, 2131886472, 2130837958, 2131427940, 0 };
  public static boolean a = true;
  public static final int[] b = { 2, 2131896496, 2130838178, 2131442175, 2130838061, 2130852078, 2130852079 };
  public static final int[] c = { 2, 2131896496, 2130838182, 2131442176, 0 };
  public static final int[] d = { 2, 2131896496, 2130838180, 2131442176, 0 };
  public static final int[] e = { 2, 2131896496, 2130846253, 2131442175, 0 };
  public static final int[] f = { 3, 2131896479, 2130838114, 2131442147, 2130838055, 2130852006, 2130852007 };
  public static final int[] g = { 3, 2131896479, 2130838118, 2131442148, 0 };
  public static final int[] h = { 3, 2131896479, 2130838116, 2131442148, 0 };
  public static final int[] i = { 3, 2131896479, 2130846244, 2131442147, 0 };
  public static final int[] j = { 3, 2131896479, 2130838121, 2131442147, 2130838056, 2130852004, 2130852005 };
  public static final int[] k = { 3, 2131896479, 2130838119, 2131442148, 0 };
  public static final int[] l = { 3, 2131896479, 2130838117, 2131442148, 0 };
  public static final int[] m = { 4, 2131896487, 2130838156, 2131442165, 2130838058, 2130852035, 2130852036 };
  public static final int[] n = { 4, 2131896487, 2130838161, 2131442166, 0 };
  public static final int[] o = { 4, 2131896487, 2130838158, 2131442166, 0 };
  public static final int[] p = { 4, 2131896487, 2130846249, 2131442165, 0 };
  public static final int[] q = { 4, 2131896487, 2130838163, 2131442165, 2130838059, 2130852033, 2130852034 };
  public static final int[] r = { 4, 2131896487, 2130838162, 2131442166, 0 };
  public static final int[] s = { 4, 2131896487, 2130838159, 2131442166, 0 };
  public static final int[] t = { 5, 2131896476, 2130838107, 2131442141, 0, 2130851986, 2130851987 };
  public static final int[] u = { 5, 2131896476, 2130838111, 2131442142, 0 };
  public static final int[] v = { 5, 2131896476, 2130838109, 2131442142, 0 };
  public static final int[] w = { 6, 2131896497, 2130838185, 2131442178, 0, 2130852084, 2130852085 };
  public static final int[] x = { 8, 2131896492, 2130838171, 2131442170, 2130838060, 2130852055, 2130852056 };
  public static final int[] y = { 8, 2131896492, 2130838173, 2131442171, 0 };
  public static final int[] z = { 8, 2131896492, 2130846251, 2131442170, 0 };
  
  public static PhotoListPanel a(QQAppInterface paramQQAppInterface, AIOContext paramAIOContext, InputBarUI paramInputBarUI, PanelIconLinearLayout paramPanelIconLinearLayout, boolean paramBoolean, Intent paramIntent)
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)View.inflate(paramAIOContext.b(), 2131627284, null);
    if (!paramBoolean)
    {
      paramInputBarUI = paramIntent;
      if (paramIntent != null) {}
    }
    else
    {
      paramInputBarUI = new Intent();
    }
    paramIntent = paramQQAppInterface.getAccount();
    paramPanelIconLinearLayout = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramIntent);
    if (paramPanelIconLinearLayout != null) {
      paramPanelIconLinearLayout = paramPanelIconLinearLayout.name;
    } else {
      paramPanelIconLinearLayout = "";
    }
    String str = paramQQAppInterface.getCustomFaceFilePath(1, paramIntent, 0);
    boolean bool = paramQQAppInterface.isLBSFriendNewClient(paramAIOContext.O().b);
    paramInputBarUI.putExtra("key_my_uin", paramIntent);
    paramInputBarUI.putExtra("key_my_nick", paramPanelIconLinearLayout);
    paramInputBarUI.putExtra("key_my_head_dir", str);
    paramInputBarUI.putExtra("key_new_lbs_client", bool);
    paramInputBarUI.putExtra("custom_photolist_panel_editbtn_reportActionName", "0X8005E06");
    if ((paramAIOContext.O().a == 9500) || (paramAIOContext.O().a == 9501)) {
      paramInputBarUI.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    }
    if ((paramAIOContext.O().a == 1) && (((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramAIOContext.O().b))) {
      paramInputBarUI.putExtra("filter_photolist_troopalbum_toolbar", true);
    }
    paramInputBarUI.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", PlusPanelUtils.a(paramAIOContext.O()));
    if (paramBoolean)
    {
      paramInputBarUI.putExtra("key_disable_quality_cb", true);
      paramInputBarUI.putExtra("key_disable_edit_btn", true);
      paramInputBarUI.putExtra("key_disable_send_btn", true);
      paramInputBarUI.putExtra("key_disable_presend", true);
      paramInputBarUI.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
      paramInputBarUI.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      paramInputBarUI.putExtra("filter_photolist_troopalbum_toolbar", true);
      paramInputBarUI.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
      paramInputBarUI.putExtra("custom_photopreview_sendbtn_report", true);
      paramInputBarUI.putExtra("custom_photopreview_sendbtn_reportActionName", "0X8005978");
      paramInputBarUI.putExtra("custom_photopreview_sendbtn_album_reportReverse2", "1");
      paramPanelIconLinearLayout = (ITroopPhotoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_PHOTO_HANDLER);
      if ((!TextUtils.isEmpty(paramAIOContext.O().b)) && (paramAIOContext.O().a == 1))
      {
        paramPanelIconLinearLayout.a(paramAIOContext.O().b, true);
        paramInputBarUI.putExtra("showFlashPic", false);
      }
    }
    localPhotoListPanel.a(paramQQAppInterface, paramAIOContext.b(), paramAIOContext.O(), paramInputBarUI);
    localPhotoListPanel.setOnSwipeUpAndDragListener(new SwipeUpAndDragListener(paramAIOContext, null, localPhotoListPanel));
    return localPhotoListPanel;
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPanelUtiles", 2, "sendPhotoListPanelEditPhoto start");
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_presend_cancel_type", 1021);
    RichmediaService.d((Bundle)localObject1);
    Object localObject2 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    int i1 = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = new Intent(paramActivity, SendPhotoActivity.class);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052));
    ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
    ((Intent)localObject2).putExtra("PhotoConst.VIDEO_INFOS", paramIntent.getSerializableExtra("PhotoConst.VIDEO_INFOS"));
    ((Intent)localObject2).putExtra("uin", paramSessionInfo.b);
    ((Intent)localObject2).putExtra("uintype", paramSessionInfo.a);
    ((Intent)localObject2).putExtra("troop_uin", paramSessionInfo.c);
    ((Intent)localObject2).putExtra("key_confess_topicid", paramSessionInfo.v);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", i1);
    ((Intent)localObject2).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Intent)localObject2).putExtra("entrance", paramSessionInfo.s);
    if (((ArrayList)localObject1).size() == 1) {
      ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject1);
    }
    ((Intent)localObject2).addFlags(603979776);
    ((Intent)localObject2).putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
    ((Intent)localObject2).putExtra("session_info", paramSessionInfo);
    Object localObject3 = paramIntent.getStringExtra("widgetinfo");
    String str = paramIntent.getStringExtra("key_camera_material_name");
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      ((Intent)localObject2).putExtra("widgetinfo", (String)localObject3);
    }
    if (!TextUtils.isEmpty(str)) {
      ((Intent)localObject2).putExtra("key_camera_material_name", str);
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("sendPhotoListPanelEditPhoto selectedPhotoList = ");
      ((StringBuilder)localObject3).append(((ArrayList)localObject1).toString());
      QLog.d("AIOPanelUtiles", 2, ((StringBuilder)localObject3).toString());
    }
    if (paramActivity.getIntent().getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007) == 1040) {
      if (paramSessionInfo.a == 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
      }
      else if (paramSessionInfo.a == 3000)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
      }
      else if (paramSessionInfo.a == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A8", "0X80069A8", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699C", "0X800699C", 0, 0, "", "", "", "");
      }
    }
    paramIntent.removeExtra("PhotoConst.PHOTO_PATHS");
    paramIntent.removeExtra("PhotoConst.CURRENT_QUALITY_TYPE");
    paramIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
    paramActivity.startActivity((Intent)localObject2);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 1;
    } else if (paramInt == 3000) {
      paramInt = 2;
    } else if (paramInt == 1) {
      paramInt = 3;
    } else if ((paramInt != 6000) && (paramInt != 6001) && (paramInt != 6002) && (paramInt != 1008) && (paramInt != 9500)) {
      paramInt = 4;
    } else {
      paramInt = 5;
    }
    ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.common, "aio_pia");
        if ("0".equals(paramQQAppInterface)) {
          break label111;
        }
        bool = true;
        a = bool;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getAIOPanelConfig = ");
          localStringBuilder.append(paramQQAppInterface);
          localStringBuilder.append(" isShowQwalletHbEntry = ");
          localStringBuilder.append(a);
          QLog.d("AIO_Panel", 2, localStringBuilder.toString());
          return;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOPanelUtiles", 2, paramQQAppInterface, new Object[0]);
        }
      }
      return;
      label111:
      boolean bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt1, String paramString, int paramInt2)
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    paramString = localIRedTouchManager.getAppInfo(paramInt1, paramString);
    if (paramString != null)
    {
      paramInt1 = paramString.iNewFlag.get();
      int i3 = 1;
      if (paramInt1 == 1)
      {
        localIRedTouchManager.onRedTouchItemClick(paramString, "");
        return;
      }
      paramInt1 = paramSessionInfo.a;
      int i2 = 0;
      if ((paramInt1 != 0) && (!ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.b))) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      int i1;
      if (paramSessionInfo.a == 3000) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (paramSessionInfo.a == 1) {
        i2 = 1;
      }
      boolean bool = ChatActivityUtils.a(paramSessionInfo.a);
      if (paramInt1 != 0) {
        paramInt1 = i3;
      } else if (i1 != 0) {
        paramInt1 = 2;
      } else if (i2 != 0) {
        paramInt1 = 3;
      } else if (bool) {
        paramInt1 = 4;
      } else {
        paramInt1 = 5;
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A46A", "0X800A46A", paramInt2, paramString.iNewFlag.get(), String.valueOf(paramInt1), "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo) {}
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    PlusPanelUtils.a(paramQQAppInterface, paramBaseActivity);
    paramBaseActivity.setCanLock(false);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800407F", "0X800407F", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SessionInfo paramSessionInfo)
  {
    if (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).m(paramSessionInfo.b)) {
      ReportController.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.b, paramString1, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).m(paramSessionInfo.b))
    {
      paramSessionInfo = paramSessionInfo.b;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("");
      ReportController.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo, paramString1, paramString2, 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles
 * JD-Core Version:    0.7.0.1
 */
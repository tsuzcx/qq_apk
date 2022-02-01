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
  public static final int[] A = { 9, 2131698549, 2130844809, 2131374079, 0 };
  public static final int[] B = { 10, 2131698537, 2130838088, 2131374062, 0, 2130850225, 2130850226 };
  public static final int[] C = { 10, 2131698537, 2130844812, 2131374062, 0 };
  public static final int[] D = { 12, 2131698531, 2130838145, 2131374049, 0 };
  public static final int[] E = { 13, 2131698532, 2130838142, 2131374050, 0 };
  public static final int[] F = { 14, 2131698539, 2130838083, 2131374067, 0 };
  public static final int[] G = { 14, 2131698539, 2130844811, 2131374067, 0 };
  public static final int[] H = { 19, 2131698540, 2130838124, 2131374069, 0 };
  public static final int[] I = { 19, 2131698540, 2130844816, 2131374069, 0 };
  public static final int[] J = { 16, 2131698535, 2130838080, 2131374059, 0 };
  public static final int[] K = { 17, 2131698543, 2130838121, 2131374073, 0 };
  public static int[] L = { 23, 2131698545, 2130838133, 2131374078, 0, 2130850270, 2130850271 };
  public static final int[] M = { 26, 2131698555, 2130838133, 2131374093, 0 };
  public static final int[] N = { 24, 2131698538, 2130838089, 2131374063, 2130838015, 2130838109, 2130838111 };
  public static final int[] O = { 24, 2131698538, 2130844809, 2131374063, 0 };
  public static final int[] P = { 31, 2131698544, 2130838125, 2131374074, 0 };
  public static final int[] Q = { 32, 2131698536, 2130838087, 2131374061, 0 };
  public static final int[] R = { 24, 2131698538, 2130838091, 2131374064, 0 };
  public static final int[] S = { 24, 2131698538, 2130838090, 2131374064, 0 };
  public static final int[] T = { 29, 2131694694, 2130850190, 2131374045, 0 };
  public static final int[] U = { 29, 2131694694, 2130844808, 2131374045, 0 };
  public static final int[] V = { 21, 2131690518, 2130838361, 2131374044, 0 };
  public static final int[] W = { 21, 2131690518, 2130844806, 2131374044, 0 };
  public static final int[] X = { 21, 2131690518, 2130838405, 2131374048, 0 };
  public static final int[] Y = { 40, 2131689831, 2130837934, 2131362340, 0 };
  public static boolean a = true;
  public static final int[] a;
  public static final int[] b;
  public static final int[] c;
  public static final int[] d;
  public static final int[] e;
  public static final int[] f;
  public static final int[] g;
  public static final int[] h;
  public static final int[] i;
  public static final int[] j;
  public static final int[] k;
  public static final int[] l;
  public static final int[] m;
  public static final int[] n;
  public static final int[] o;
  public static final int[] p;
  public static final int[] q;
  public static final int[] r;
  public static final int[] s;
  public static final int[] t;
  public static final int[] u;
  public static final int[] v;
  public static final int[] w;
  public static final int[] x;
  public static final int[] y;
  public static final int[] z;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2, 2131698550, 2130838135, 2131374080, 2130838019, 2130850287, 2130850288 };
    b = new int[] { 2, 2131698550, 2130838139, 2131374081, 0 };
    c = new int[] { 2, 2131698550, 2130838137, 2131374081, 0 };
    d = new int[] { 2, 2131698550, 2130844819, 2131374080, 0 };
    e = new int[] { 3, 2131698533, 2130838071, 2131374052, 2130838013, 2130850215, 2130850216 };
    f = new int[] { 3, 2131698533, 2130838075, 2131374053, 0 };
    g = new int[] { 3, 2131698533, 2130838073, 2131374053, 0 };
    h = new int[] { 3, 2131698533, 2130844810, 2131374052, 0 };
    i = new int[] { 3, 2131698533, 2130838078, 2131374052, 2130838014, 2130850213, 2130850214 };
    j = new int[] { 3, 2131698533, 2130838076, 2131374053, 0 };
    k = new int[] { 3, 2131698533, 2130838074, 2131374053, 0 };
    l = new int[] { 4, 2131698541, 2130838113, 2131374070, 2130838016, 2130850244, 2130850245 };
    m = new int[] { 4, 2131698541, 2130838118, 2131374071, 0 };
    n = new int[] { 4, 2131698541, 2130838115, 2131374071, 0 };
    o = new int[] { 4, 2131698541, 2130844815, 2131374070, 0 };
    p = new int[] { 4, 2131698541, 2130838120, 2131374070, 2130838017, 2130850242, 2130850243 };
    q = new int[] { 4, 2131698541, 2130838119, 2131374071, 0 };
    r = new int[] { 4, 2131698541, 2130838116, 2131374071, 0 };
    s = new int[] { 5, 2131698530, 2130838065, 2131374046, 0, 2130850195, 2130850196 };
    t = new int[] { 5, 2131698530, 2130838069, 2131374047, 0 };
    u = new int[] { 5, 2131698530, 2130838067, 2131374047, 0 };
    v = new int[] { 6, 2131698551, 2130838142, 2131374083, 0, 2130850293, 2130850294 };
    w = new int[] { 8, 2131698546, 2130838128, 2131374075, 2130838018, 2130850264, 2130850265 };
    x = new int[] { 8, 2131698546, 2130838130, 2131374076, 0 };
    y = new int[] { 8, 2131698546, 2130844817, 2131374075, 0 };
    z = new int[] { 9, 2131698549, 2130838134, 2131374079, 0 };
  }
  
  public static PhotoListPanel a(QQAppInterface paramQQAppInterface, AIOContext paramAIOContext, InputBarUI paramInputBarUI, PanelIconLinearLayout paramPanelIconLinearLayout, boolean paramBoolean, Intent paramIntent)
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)View.inflate(paramAIOContext.a(), 2131560943, null);
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
    paramPanelIconLinearLayout = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramIntent);
    if (paramPanelIconLinearLayout != null) {
      paramPanelIconLinearLayout = paramPanelIconLinearLayout.name;
    } else {
      paramPanelIconLinearLayout = "";
    }
    String str = paramQQAppInterface.getCustomFaceFilePath(1, paramIntent, 0);
    boolean bool = paramQQAppInterface.isLBSFriendNewClient(paramAIOContext.a().jdField_a_of_type_JavaLangString);
    paramInputBarUI.putExtra("key_my_uin", paramIntent);
    paramInputBarUI.putExtra("key_my_nick", paramPanelIconLinearLayout);
    paramInputBarUI.putExtra("key_my_head_dir", str);
    paramInputBarUI.putExtra("key_new_lbs_client", bool);
    paramInputBarUI.putExtra("custom_photolist_panel_editbtn_reportActionName", "0X8005E06");
    if ((paramAIOContext.a().jdField_a_of_type_Int == 9500) || (paramAIOContext.a().jdField_a_of_type_Int == 9501)) {
      paramInputBarUI.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    }
    if ((paramAIOContext.a().jdField_a_of_type_Int == 1) && (((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramAIOContext.a().jdField_a_of_type_JavaLangString))) {
      paramInputBarUI.putExtra("filter_photolist_troopalbum_toolbar", true);
    }
    paramInputBarUI.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", PlusPanelUtils.a(paramAIOContext.a()));
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
      if ((!TextUtils.isEmpty(paramAIOContext.a().jdField_a_of_type_JavaLangString)) && (paramAIOContext.a().jdField_a_of_type_Int == 1))
      {
        paramPanelIconLinearLayout.a(paramAIOContext.a().jdField_a_of_type_JavaLangString, true);
        paramInputBarUI.putExtra("showFlashPic", false);
      }
    }
    localPhotoListPanel.a(paramQQAppInterface, paramAIOContext.a(), paramAIOContext.a(), paramInputBarUI);
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
    ((Intent)localObject2).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("troop_uin", paramSessionInfo.b);
    ((Intent)localObject2).putExtra("key_confess_topicid", paramSessionInfo.e);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", i1);
    ((Intent)localObject2).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Intent)localObject2).putExtra("entrance", paramSessionInfo.c);
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
      if (paramSessionInfo.jdField_a_of_type_Int == 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
      }
      else if (paramSessionInfo.jdField_a_of_type_Int == 3000)
      {
        ReportController.b(null, "dc00898", "", "", "0X80069A7", "0X80069A7", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800699B", "0X800699B", 0, 0, "", "", "", "");
      }
      else if (paramSessionInfo.jdField_a_of_type_Int == 1)
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
        jdField_a_of_type_Boolean = bool;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getAIOPanelConfig = ");
          localStringBuilder.append(paramQQAppInterface);
          localStringBuilder.append(" isShowQwalletHbEntry = ");
          localStringBuilder.append(jdField_a_of_type_Boolean);
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
      paramInt1 = paramSessionInfo.jdField_a_of_type_Int;
      int i2 = 0;
      if ((paramInt1 != 0) && (!ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString))) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
      int i1;
      if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1) {
        i2 = 1;
      }
      boolean bool = ChatActivityUtils.a(paramSessionInfo.jdField_a_of_type_Int);
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
    if (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      ReportController.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(paramSessionInfo.jdField_a_of_type_JavaLangString))
    {
      paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.panel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.manager.ServerConfigManager.ConfigType;

public class AIOPanelUtiles
{
  public static final int[] A = { 9, 2131698483, 2130844933, 2131374541, 0 };
  public static final int[] B = { 10, 2131698471, 2130838252, 2131374524, 0, 2130850298, 2130850299 };
  public static final int[] C = { 10, 2131698471, 2130844936, 2131374524, 0 };
  public static final int[] D = { 12, 2131698465, 2130838320, 2131374511, 0 };
  public static final int[] E = { 13, 2131698466, 2130838317, 2131374512, 0 };
  public static final int[] F = { 14, 2131698473, 2130838247, 2131374529, 0 };
  public static final int[] G = { 14, 2131698473, 2130844935, 2131374529, 0 };
  public static final int[] H = { 19, 2131698474, 2130838299, 2131374531, 0 };
  public static final int[] I = { 19, 2131698474, 2130844940, 2131374531, 0 };
  public static final int[] J = { 16, 2131698469, 2130838244, 2131374521, 0 };
  public static final int[] K = { 17, 2131698477, 2130838296, 2131374535, 0 };
  public static int[] L = { 23, 2131698479, 2130838308, 2131374540, 0, 2130850343, 2130850344 };
  public static final int[] M = { 26, 2131698489, 2130838308, 2131374555, 0 };
  public static final int[] N = { 24, 2131698472, 2130838253, 2131374525, 2130838174, 2130838284, 2130838286 };
  public static final int[] O = { 24, 2131698472, 2130844933, 2131374525, 0 };
  public static final int[] P = { 31, 2131698478, 2130838300, 2131374536, 0 };
  public static final int[] Q = { 32, 2131698470, 2130838251, 2131374523, 0 };
  public static final int[] R = { 24, 2131698472, 2130838255, 2131374526, 0 };
  public static final int[] S = { 24, 2131698472, 2130838254, 2131374526, 0 };
  public static final int[] T = { 29, 2131694716, 2130850263, 2131374507, 0 };
  public static final int[] U = { 29, 2131694716, 2130844932, 2131374507, 0 };
  public static final int[] V = { 21, 2131690590, 2130838513, 2131374506, 0 };
  public static final int[] W = { 21, 2131690590, 2130844930, 2131374506, 0 };
  public static final int[] X = { 21, 2131690590, 2130838563, 2131374510, 0 };
  public static final int[] Y = { 40, 2131689917, 2130838084, 2131362384, 0 };
  public static boolean a;
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
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_ArrayOfInt = new int[] { 2, 2131698484, 2130838310, 2131374542, 2130838178, 2130850360, 2130850361 };
    b = new int[] { 2, 2131698484, 2130838314, 2131374543, 0 };
    c = new int[] { 2, 2131698484, 2130838312, 2131374543, 0 };
    d = new int[] { 2, 2131698484, 2130844943, 2131374542, 0 };
    e = new int[] { 3, 2131698467, 2130838229, 2131374514, 2130838172, 2130850288, 2130850289 };
    f = new int[] { 3, 2131698467, 2130838233, 2131374515, 0 };
    g = new int[] { 3, 2131698467, 2130838231, 2131374515, 0 };
    h = new int[] { 3, 2131698467, 2130844934, 2131374514, 0 };
    i = new int[] { 3, 2131698467, 2130838242, 2131374514, 2130838173, 2130850286, 2130850287 };
    j = new int[] { 3, 2131698467, 2130838234, 2131374515, 0 };
    k = new int[] { 3, 2131698467, 2130838232, 2131374515, 0 };
    l = new int[] { 4, 2131698475, 2130838288, 2131374532, 2130838175, 2130850317, 2130850318 };
    m = new int[] { 4, 2131698475, 2130838293, 2131374533, 0 };
    n = new int[] { 4, 2131698475, 2130838290, 2131374533, 0 };
    o = new int[] { 4, 2131698475, 2130844939, 2131374532, 0 };
    p = new int[] { 4, 2131698475, 2130838295, 2131374532, 2130838176, 2130850315, 2130850316 };
    q = new int[] { 4, 2131698475, 2130838294, 2131374533, 0 };
    r = new int[] { 4, 2131698475, 2130838291, 2131374533, 0 };
    s = new int[] { 5, 2131698464, 2130838223, 2131374508, 0, 2130850268, 2130850269 };
    t = new int[] { 5, 2131698464, 2130838227, 2131374509, 0 };
    u = new int[] { 5, 2131698464, 2130838225, 2131374509, 0 };
    v = new int[] { 6, 2131698485, 2130838317, 2131374545, 0, 2130850366, 2130850367 };
    w = new int[] { 8, 2131698480, 2130838303, 2131374537, 2130838177, 2130850337, 2130850338 };
    x = new int[] { 8, 2131698480, 2130838305, 2131374538, 0 };
    y = new int[] { 8, 2131698480, 2130844941, 2131374537, 0 };
    z = new int[] { 9, 2131698483, 2130838309, 2131374541, 0 };
  }
  
  public static PhotoListPanel a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, LinearLayout paramLinearLayout, PanelIconLinearLayout paramPanelIconLinearLayout, boolean paramBoolean, Intent paramIntent)
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)View.inflate(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131561079, null);
    Intent localIntent;
    if (!paramBoolean)
    {
      localIntent = paramIntent;
      if (paramIntent != null) {}
    }
    else
    {
      localIntent = new Intent();
    }
    String str = paramQQAppInterface.getAccount();
    Object localObject = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str);
    paramIntent = "";
    if (localObject != null) {
      paramIntent = ((Friends)localObject).name;
    }
    localObject = paramQQAppInterface.getCustomFaceFilePath(1, str, 0);
    boolean bool = paramQQAppInterface.isLBSFriendNewClient(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_my_uin", str);
    localIntent.putExtra("key_my_nick", paramIntent);
    localIntent.putExtra("key_my_head_dir", (String)localObject);
    localIntent.putExtra("key_new_lbs_client", bool);
    localIntent.putExtra("custom_photolist_panel_editbtn_reportActionName", "0X8005E06");
    if ((paramBaseChatPie.b() == 9500) || (paramBaseChatPie.b() == 9501)) {
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    }
    if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      localIntent.putExtra("filter_photolist_troopalbum_toolbar", true);
    }
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", PlusPanelUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
    if (paramBoolean)
    {
      localIntent.putExtra("key_disable_quality_cb", true);
      localIntent.putExtra("key_disable_edit_btn", true);
      localIntent.putExtra("key_disable_send_btn", true);
      localIntent.putExtra("key_disable_presend", true);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("filter_photolist_troopalbum_toolbar", true);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
      localIntent.putExtra("custom_photopreview_sendbtn_report", true);
      localIntent.putExtra("custom_photopreview_sendbtn_reportActionName", "0X8005978");
      localIntent.putExtra("custom_photopreview_sendbtn_album_reportReverse2", "1");
      paramIntent = (TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if ((!TextUtils.isEmpty(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        paramIntent.d(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
        localIntent.putExtra("showFlashPic", false);
      }
    }
    localPhotoListPanel.a(paramQQAppInterface, paramBaseChatPie.a(), paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localIntent);
    paramQQAppInterface = new int[2];
    paramBaseChatPie.d.getLocationInWindow(paramQQAppInterface);
    paramQQAppInterface[0] += paramBaseChatPie.d.getWidth();
    paramQQAppInterface[1] -= paramLinearLayout.getHeight() + paramPanelIconLinearLayout.getHeight();
    localPhotoListPanel.setOnSwipeUpAndDragListener(new PhotoListPanel.SwipeUpAndDragListener(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramBaseChatPie.d, paramQQAppInterface, paramBaseChatPie.a(), null, localPhotoListPanel));
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
    ((Intent)localObject2).putExtra("video_sync_to_story", paramIntent.getBooleanExtra("video_sync_to_story", false));
    if (((ArrayList)localObject1).size() == 1) {
      ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject1);
    }
    ((Intent)localObject2).addFlags(603979776);
    ((Intent)localObject2).putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false));
    ((Intent)localObject2).putExtra("session_info", paramSessionInfo);
    String str1 = paramIntent.getStringExtra("widgetinfo");
    String str2 = paramIntent.getStringExtra("key_camera_material_name");
    if (!TextUtils.isEmpty(str1)) {
      ((Intent)localObject2).putExtra("widgetinfo", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      ((Intent)localObject2).putExtra("key_camera_material_name", str2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOPanelUtiles", 2, "sendPhotoListPanelEditPhoto selectedPhotoList = " + ((ArrayList)localObject1).toString());
    }
    if (paramActivity.getIntent().getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007) == 1040)
    {
      if (paramSessionInfo.jdField_a_of_type_Int != 0) {
        break label507;
      }
      ReportController.b(null, "dc00898", "", "", "0X80069A6", "0X80069A6", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800699A", "0X800699A", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      paramIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      paramIntent.removeExtra("PhotoConst.CURRENT_QUALITY_TYPE");
      paramIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      paramActivity.startActivity((Intent)localObject2);
      return;
      label507:
      if (paramSessionInfo.jdField_a_of_type_Int == 3000)
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
          break label98;
        }
        bool = true;
        jdField_a_of_type_Boolean = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AIO_Panel", 2, "getAIOPanelConfig = " + paramQQAppInterface + " isShowQwalletHbEntry = " + jdField_a_of_type_Boolean);
        return;
      }
      catch (Throwable paramQQAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("AIOPanelUtiles", 2, paramQQAppInterface, new Object[0]);
      return;
      label98:
      boolean bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    PlusPanelUtils.a(paramQQAppInterface, paramFragmentActivity);
    paramFragmentActivity.setCanLock(false);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800407F", "0X800407F", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt1, String paramString, int paramInt2)
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    paramString = localRedTouchManager.a(paramInt1, paramString);
    if (paramString != null)
    {
      if (paramString.iNewFlag.get() == 1) {
        localRedTouchManager.a(paramString, "");
      }
    }
    else {
      return;
    }
    int i1;
    label78:
    int i2;
    label89:
    boolean bool;
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramInt1 = 1;
      if (paramSessionInfo.jdField_a_of_type_Int != 3000) {
        break label151;
      }
      i1 = 1;
      if (paramSessionInfo.jdField_a_of_type_Int != 1) {
        break label157;
      }
      i2 = 1;
      bool = ChatActivityUtils.a(paramSessionInfo.jdField_a_of_type_Int);
      if (paramInt1 == 0) {
        break label163;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A46A", "0X800A46A", paramInt2, paramString.iNewFlag.get(), String.valueOf(paramInt1), "", "", "");
      return;
      paramInt1 = 0;
      break;
      label151:
      i1 = 0;
      break label78;
      label157:
      i2 = 0;
      break label89;
      label163:
      if (i1 != 0) {
        paramInt1 = 2;
      } else if (i2 != 0) {
        paramInt1 = 3;
      } else if (bool) {
        paramInt1 = 4;
      } else {
        paramInt1 = 5;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo) {}
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    int i1 = 1;
    if (paramInt == 0) {
      paramInt = i1;
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
      return;
      if (paramInt == 3000) {
        paramInt = 2;
      } else if (paramInt == 1) {
        paramInt = 3;
      } else if ((paramInt == 6000) || (paramInt == 6001) || (paramInt == 6002) || (paramInt == 1008) || (paramInt == 9500)) {
        paramInt = 5;
      } else {
        paramInt = 4;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SessionInfo paramSessionInfo)
  {
    if (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      ReportController.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (((QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      ReportController.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, 0, 0, paramInt1 + "", paramInt2 + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles
 * JD-Core Version:    0.7.0.1
 */
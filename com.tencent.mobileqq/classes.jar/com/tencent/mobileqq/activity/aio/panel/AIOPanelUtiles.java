package com.tencent.mobileqq.activity.aio.panel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.manager.ServerConfigManager.ConfigType;

public class AIOPanelUtiles
{
  public static final int[] A = { 26, 2131438140, 2130837691, 2131362261, 0 };
  public static final int[] B = { 24, 2131438141, 2130837657, 2131362263, 2130837610, 2130837675, 2130837676 };
  public static final int[] C = { 31, 2131438142, 2130837685, 2131362264, 0 };
  public static final int[] D = { 32, 2131438143, 2130837655, 2131362265, 0 };
  public static final int[] E = { 24, 2131438141, 2130837658, 2131362266, 0 };
  public static final int[] F = { 24, 2131438141, 2130844079, 2131362267, 0 };
  public static final int[] G = { 27, 2131433148, 2130845735, 2131362268, 2130837614 };
  public static final int[] H = { 27, 2131433148, 2130845748, 2131362268 };
  public static final int[] I = { 27, 2131433148, 2130844090, 2131362269 };
  public static final int[] J = { 29, 2131433365, 2130845647, 2131362271, 0 };
  public static final int[] K = { 21, 2131438172, 2130837982, 2131362272, 0 };
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
  public static int[] z;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2, 2131438120, 2130837693, 2131362231, 2130837613, 2130845731, 2130845732 };
    b = new int[] { 2, 2131438120, 2130837695, 2131362232, 0 };
    c = new int[] { 2, 2131438120, 2130844085, 2131362233, 0 };
    d = new int[] { 3, 2131438121, 2130837645, 2131362234, 2130837609, 2130845669, 2130845670 };
    e = new int[] { 3, 2131438121, 2130837647, 2131362235, 0 };
    f = new int[] { 3, 2131438121, 2130844160, 2131362236, 0 };
    g = new int[] { 4, 2131438122, 2130837678, 2131362237, 2130837611, 2130845692, 2130845693 };
    h = new int[] { 4, 2131438122, 2130837680, 2131362238, 0 };
    i = new int[] { 4, 2131438122, 2130844082, 2131362239, 0 };
    j = new int[] { 5, 2131438123, 2130837641, 2131362240, 0, 2130845652, 2130845653 };
    k = new int[] { 5, 2131438123, 2130837643, 2131362241, 0 };
    l = new int[] { 5, 2131438123, 2130844077, 2131362242, 0 };
    m = new int[] { 6, 2131438124, 2130837696, 2131362243, 0, 2130845733, 2130845734 };
    n = new int[] { 6, 2131438124, 2130844088, 2131362244, 0 };
    o = new int[] { 8, 2131438126, 2130837688, 2131362246, 2130837612, 2130845712, 2130845713 };
    p = new int[] { 8, 2131438126, 2130837690, 2131362247, 0 };
    q = new int[] { 8, 2131438126, 2130844084, 2131362248, 0 };
    r = new int[] { 9, 2131438127, 2130837692, 2131362249, 0 };
    s = new int[] { 10, 2131438128, 2130837656, 2131362250, 0, 2130845675, 2130845676 };
    t = new int[] { 12, 2131438130, 2130837699, 2131362252, 0 };
    u = new int[] { 13, 2131438131, 2130837696, 2131362253, 0 };
    v = new int[] { 14, 2131438132, 2130837651, 2131362254, 0 };
    w = new int[] { 19, 2131438133, 2130837684, 2131362255, 0 };
    x = new int[] { 16, 2131438135, 2130837648, 2131362257, 0 };
    y = new int[] { 17, 2131438136, 2130837681, 2131362258, 0 };
    z = new int[] { 23, 2131438138, 2130837691, 2131362260, 0, 2130845714, 2130845715 };
  }
  
  public static PhotoListPanel a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, LinearLayout paramLinearLayout, PanelIconLinearLayout paramPanelIconLinearLayout, boolean paramBoolean)
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)View.inflate(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, 2130970189, null);
    Intent localIntent = new Intent();
    String str = paramQQAppInterface.getAccount();
    Object localObject2 = ((FriendsManager)paramQQAppInterface.getManager(50)).c(str);
    Object localObject1 = "";
    if (localObject2 != null) {
      localObject1 = ((Friends)localObject2).name;
    }
    localObject2 = paramQQAppInterface.a(1, str, 0);
    boolean bool = paramQQAppInterface.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_my_uin", str);
    localIntent.putExtra("key_my_nick", (String)localObject1);
    localIntent.putExtra("key_my_head_dir", (String)localObject2);
    localIntent.putExtra("key_new_lbs_client", bool);
    localIntent.putExtra("custom_photolist_panel_editbtn_reportActionName", "0X8005E06");
    if ((paramBaseChatPie.b() == 9500) || (paramBaseChatPie.b() == 9501)) {
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    }
    if ((paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((HotChatManager)paramQQAppInterface.getManager(59)).b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
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
      localObject1 = (TroopHandler)paramQQAppInterface.a(20);
      if ((!TextUtils.isEmpty(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        ((TroopHandler)localObject1).e(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
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
    ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007));
    ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
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
    if (QLog.isColorLevel()) {
      QLog.d("AIOPanelUtiles", 2, "sendPhotoListPanelEditPhoto selectedPhotoList = " + ((ArrayList)localObject1).toString());
    }
    if (paramActivity.getIntent().getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007) == 1040)
    {
      if (paramSessionInfo.jdField_a_of_type_Int != 0) {
        break label435;
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
      label435:
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
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, "aio_pia");
      if ("1".equals(paramQQAppInterface)) {}
      for (jdField_a_of_type_Boolean = true; QLog.isColorLevel(); jdField_a_of_type_Boolean = false)
      {
        QLog.d("AIO_Panel", 2, "getAIOPanelConfig = " + paramQQAppInterface + " isPanelAdjust = " + jdField_a_of_type_Boolean);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity)
  {
    HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(59);
    PlusPanelUtils.a(paramQQAppInterface, paramFragmentActivity);
    paramFragmentActivity.setCanLock(false);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800407F", "0X800407F", 0, 0, "", "", "", "");
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
    if (((QidianManager)paramQQAppInterface.getManager(164)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      ReportController.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (((QidianManager)paramQQAppInterface.getManager(164)).f(paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      ReportController.b(paramQQAppInterface, "dc00899", "Qidian", paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, 0, 0, paramInt1 + "", paramInt2 + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles
 * JD-Core Version:    0.7.0.1
 */
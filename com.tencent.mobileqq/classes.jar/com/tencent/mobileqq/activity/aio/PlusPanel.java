package com.tencent.mobileqq.activity.aio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.UITools;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousInfo;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.biz.qqstory.utils.FeedUtils;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevVideoMsgProcessor;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.qwallet.GoldMsgSettingActivity;
import com.tencent.mobileqq.activity.qwallet.PriceSettingDialog.PriceTextWater;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgAioState;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgChatState;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgFriendSet;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgIcon;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.scribble.ScribbleDownloader;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.TroopGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.dingdong.DingdongPluginHelper;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import ulz;
import uma;
import umb;
import umc;
import umd;
import ume;
import umf;
import umw;

public class PlusPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private static final int[] A = { 2131433185, 2130840505, 1104864064 };
  private static final int[] B = { 2131433186, 2130840506, 1101678813 };
  private static final int[] C = { 2131432221, 2130838410 };
  private static final int[] D = { 2131437896, 2130838392, 1104864062 };
  private static final int[] E = { 2131430744, 2130846285 };
  private static final int[] F = { 2131430744, 2130846285, 1104874204 };
  private static final int[] G = { 2131430745, 2130846276 };
  private static final int[] H = { 2131431563, 2130841568, 1104639410 };
  private static final int[] I = { 2131429896, 2130840513 };
  private static final int[] J = { 2131429897, 2130840553, 1104536706 };
  private static final int[] K = { 2131436974, 2130838411 };
  private static final int[] L = { 2131438068, 2130840588 };
  private static final int[] M = { 2131427866, 2130838387, 1104823592 };
  private static final int[] N = { 2131427867, 2130838377, 1105298834 };
  private static final int[] O = { 2131434961, 2130838406, 1104788679 };
  private static final int[] P = { 2131437103, 2130838396 };
  private static final int[] Q = { 2131438076, 2130842783 };
  private static final int[] R = { 2131430734, 2130838409, 1105015724 };
  private static final int[] T = { 2131438172, 2130838009 };
  private static final int[] U = { 2131438173, 2130838007 };
  private static int[] V = { 2131438137, 2130838399 };
  private static final int[] W = { 2131438124, 2130838400 };
  private static final int[] X = { 2131438144, 2130837748, 1106189400 };
  private static final int[] Y = { 2131430797, 2130846286, 1106194086 };
  private static final int[] Z = { 2131433631, 2130840643 };
  private static ArrayMap jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  private static final int[] aa = { 2131438835, 2130838189 };
  private static final int[] ab = { 2131432281, 2130844102, 1106338673 };
  private static final int[] ac = { 2131432282, 2130844101 };
  private static final int[] ad = { 2131432283, 2130844099 };
  private static final int[] ae = { 2131432307, 2130844109 };
  private static final int[] af = { 2131432307, 2130844108 };
  private static final int[] ag = { 2131432319, 2130844107 };
  private static final int[] ah = { 0, 2130844074 };
  private static final int[] ai = { 2131430852, 2130840548, 1105981808 };
  private static final int[] aj = { 2131429898, 2130841287, 1106729451 };
  private static final int[] t = { 2131434909, 2130838395, 1104864070 };
  private static final int[] v = { 2131437055, 2130840431 };
  private static final int[] x = { 2131430453, 2130841256, 1101487426 };
  private static final int[] y = { 2131430454, 2130841256 };
  private static final int[] z = { 2131430455, 2130841263 };
  private final int[] S = { 2131439067, 2130837697, 1106114157 };
  public int a;
  long jdField_a_of_type_Long;
  public ViewPager.OnPageChangeListener a;
  public SparseArray a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ThridAppShareHelper jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper = null;
  public BaseChatPie a;
  public PanelAdapter a;
  public SessionInfo a;
  private GoldMsgChatHelper.GoldMsgIcon jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper$GoldMsgIcon;
  public QQAppInterface a;
  private EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131438120, 2130838402 };
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "chat_tool_hongbao", "chat_tool_qwallettransfer" };
  protected final int[][] a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private final int[] jdField_b_of_type_ArrayOfInt = { 2131433822, 2130838401, 1104864054 };
  private final int[][] jdField_b_of_type_Array2dOfInt = { this.k, this.l, this.j, x, ab, this.S, this.q, D, A, this.m, t, v, O, B, J, H, F };
  private final int[] jdField_c_of_type_ArrayOfInt = { 2131433823, 2130838384 };
  private final int[][] jdField_c_of_type_Array2dOfInt = { this.jdField_b_of_type_ArrayOfInt, this.e, this.k, this.l, this.S, this.j, D, A, x, this.q, R, this.m, t, v, O, B, J, H, F, this.w, M, N, Y, X, ab, ai, aj };
  private final int[] d = { 2131433835, 2130838407 };
  private final int[] e = { 2131433835, 2130838407, 1104788673 };
  private final int[] f = { 2131436974, 2130838411 };
  private final int[] g = { 2131427780, 2130838412 };
  private final int[] h = { 2131433828, 2130838378 };
  private final int[] i = { 2131433829, 2130838378 };
  private final int[] j = { 2131433832, 2130838379, 100719166 };
  private final int[] k = { 2131433830, 2130838378, 1104651886 };
  private final int[] l = { 2131433831, 2130838411, 1106658188 };
  private final int[] m = { 2131433839, 2130838393, 1104864068 };
  private final int[] n = { 2131433361, 2130838404 };
  private final int[] o = { 2131438106, 2130838408 };
  private final int[] p = { 2131433362, 2130838403 };
  private final int[] q = { 2131433363, 2130838404, 1104864066 };
  private final int[] r = { 2131433512, 2130838397 };
  private final int[] s = { 2131433364, 2130838405 };
  private final int[] u = { 2131432223, 2130838376 };
  private final int[] w = { 2131438041, 2130841361, 1104445552 };
  
  public PlusPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Array2dOfInt = new int[][] { this.q };
  }
  
  public PlusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Array2dOfInt = new int[][] { this.q };
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 2130838378: 
      return "0";
    case 2130838411: 
      return "1";
    case 2130838404: 
      return "3";
    case 2130841568: 
      return "4";
    case 2130838393: 
      return "5";
    case 2130838392: 
      return "6";
    }
    return "7";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 1) || (paramInt2 == 2))
    {
      if (ShortVideoUtils.f()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(V);
      }
      return;
    }
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(V);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(V);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (!str.equals("")) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str, "", "");
      }
      if ((paramBoolean) && (paramInt2 != 0)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_open", "", "my_app", "open_app", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(paramInt2), "", "");
      }
      return;
      str = "0";
      continue;
      str = "1";
      continue;
      str = "2";
      continue;
      str = "3";
      continue;
      str = "4";
      continue;
      str = "5";
      continue;
      str = "6";
      continue;
      str = "8";
      continue;
      str = "9";
      continue;
      str = "10";
      continue;
      str = "11";
      continue;
      str = "22";
      continue;
      str = "12";
      continue;
      str = "13";
      continue;
      str = "14";
      continue;
      str = "15";
      continue;
      str = "16";
      continue;
      str = "17";
      continue;
      str = "18";
      continue;
      str = "21";
    }
  }
  
  private void a(int paramInt, List paramList)
  {
    int i1 = 1;
    if ((paramList == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramList.add(ac);
    paramList.add(ad);
    if (1 == QWalletSetting.a(str, "goldmsg_recv_goldonly_", 0)) {
      label56:
      if ((i1 != 0) && (paramInt == 0))
      {
        if (GoldMsgChatHelper.GoldMsgFriendSet.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) {
          break label160;
        }
        paramList.add(af);
      }
    }
    for (;;)
    {
      paramList.add(ag);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper$GoldMsgIcon = GoldMsgChatHelper.a(str);
      long l1 = NetConnInfoCenter.getServerTime();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper$GoldMsgIcon == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper$GoldMsgIcon.jdField_a_of_type_Long >= l1) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper$GoldMsgIcon.jdField_b_of_type_Long <= l1)) {
        break;
      }
      paramList.add(ah);
      return;
      i1 = 0;
      break label56;
      label160:
      paramList.add(ae);
    }
  }
  
  private boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (paramString.equals("chat_tool_audio")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gaudio")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gaudio_new")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_poke")) {
      return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSharedPreferences);
    }
    if (paramString.equals("chat_tool_poke_emo")) {
      return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSharedPreferences);
    }
    if (paramString.equals("chat_tool_gold_msg")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gift_clicked")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    if (paramString.equals("chat_tool_gift_stranger_clicked")) {
      return localSharedPreferences.getBoolean(paramString, true);
    }
    return localSharedPreferences.getBoolean(paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
  }
  
  private void b(int paramInt, List paramList)
  {
    if (paramList == null) {}
    while (!QWalletSetting.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return;
    }
    paramList.add(ab);
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper == null)
    {
      this.jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper = ThridAppShareHelper.a();
      this.jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper.b();
    }
    if (this.jdField_a_of_type_ComTencentBizThridappshareThridAppShareHelper.a(paramString))
    {
      if (!"200002".equals(paramString)) {
        break label54;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(v);
    }
    label54:
    do
    {
      return;
      if ("0".equals(paramString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(I);
        return;
      }
    } while (!"1".equals(paramString));
    this.jdField_a_of_type_JavaUtilArrayList.add(J);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject1 = GoldMsgChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Context localContext = getContext();
    if ((localObject1 != null) && (!((GoldMsgChatHelper.GoldMsgChatState)localObject1).jdField_a_of_type_Boolean))
    {
      QQToast.a(localContext, 2131432314, 0).a();
      return;
    }
    localObject1 = localContext.getResources();
    long l2 = QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "money_max", 20000L);
    Object localObject3 = String.format(((Resources)localObject1).getString(2131432302), new Object[] { NumAnim.formatNumber(0.01D, false) });
    String str = String.format(((Resources)localObject1).getString(2131432301), new Object[] { NumAnim.formatNumber(l2 / 100.0D, false) });
    PriceSettingDialog.PriceTextWater localPriceTextWater = new PriceSettingDialog.PriceTextWater(localContext, 1L, l2, (String)localObject3, str);
    long l1 = 1L;
    Object localObject2 = GoldMsgChatHelper.GoldMsgFriendSet.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localObject2 != null) {
      l1 = ((GoldMsgChatHelper.GoldMsgFriendSet)localObject2).jdField_a_of_type_Long;
    }
    localObject2 = NumAnim.formatNumber(l1 / 100.0D, false);
    umd localumd = new umd(this);
    localObject3 = new ume(this, localContext, (String)localObject3, l2, str);
    str = ((Resources)localObject1).getString(2131432293);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      DialogUtil.a(localContext, 2131432307, 2131432312, str, paramBoolean, ((Resources)localObject1).getString(2131432312), (String)localObject2, localPriceTextWater, localumd, (DialogInterface.OnClickListener)localObject3);
      return;
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanel", 2, "[checkApolloGameGuide] sApolloGameGuideShown");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("PlusPanel", 1, "[checkApolloGameGuide] adapter/viewPager/sessionInfo/app should not be null");
    }
    int i1;
    String str;
    do
    {
      do
      {
        return;
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("PlusPanel", 2, new Object[] { "[checkApolloGameGuide] sessionType=", Integer.valueOf(i1) });
        }
      } while ((i1 != 0) && (i1 != 3000));
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!TextUtils.isEmpty(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("PlusPanel", 2, "[checkApolloGameGuide] uin null, abort");
    return;
    boolean bool1;
    boolean bool2;
    if (jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(str))
    {
      bool1 = ((Boolean)jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(str)).booleanValue();
      bool2 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, new Object[] { "[checkApolloGameGuide] isCurrentUinShown=", Boolean.valueOf(bool1), ", isGuideFlagLoaded=", Boolean.valueOf(bool2) });
      }
      if (bool1) {
        break;
      }
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a();
      if ((localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      int i3 = localArrayList.size();
      i1 = 0;
      int i2 = -1;
      label250:
      if (i1 < i3)
      {
        PlusPanel.PluginData localPluginData = (PlusPanel.PluginData)localArrayList.get(i1);
        if ((localPluginData == null) || (localPluginData.jdField_a_of_type_Int != 2130838007)) {
          break label654;
        }
        i2 = i1;
      }
      label642:
      label648:
      label654:
      for (;;)
      {
        i1 += 1;
        break label250;
        if (QLog.isColorLevel()) {
          QLog.d("PlusPanel", 2, new Object[] { "[checkApolloGameGuide] itemPosition=", Integer.valueOf(i2) });
        }
        if (i2 == -1) {
          break;
        }
        if (!bool2)
        {
          bool1 = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0).getBoolean("apollo_game_guide_shown" + str, false);
          if (QLog.isColorLevel()) {
            QLog.d("PlusPanel", 2, new Object[] { "[checkApolloGameGuide] load isCurrentUinShown=", Boolean.valueOf(bool1) });
          }
          jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(str, Boolean.valueOf(bool1));
        }
        if (bool1) {
          break;
        }
        i1 = i2 / (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a() * this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.b());
        if (i2 % this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a() == 0)
        {
          bool1 = true;
          if ((i2 + 1) % this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a() != 0) {
            break label642;
          }
          bool2 = true;
          label469:
          if (i2 % (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a() * this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.b()) >= this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a()) {
            break label648;
          }
        }
        for (boolean bool3 = true;; bool3 = false)
        {
          i2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
          if (QLog.isColorLevel()) {
            QLog.d("PlusPanel", 2, new Object[] { "[checkApolloGameGuide] itemPageIndex=", Integer.valueOf(i1), ", currentPageIndex=", Integer.valueOf(i2), ", isLeft=", Boolean.valueOf(bool1), ", isRight=", Boolean.valueOf(bool2), ", isFirstRow=", Boolean.valueOf(bool3) });
          }
          if (i2 != i1) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i1);
          }
          postDelayed(new ulz(this, i1, bool1, bool2, bool3, str), 300L);
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label469;
        }
      }
      bool2 = false;
      bool1 = false;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    if ((localObject1 != null) && (((HotChatManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (((HotChatManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(Q);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      }
      while (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(y);
        this.jdField_a_of_type_JavaUtilArrayList.add(G);
        this.jdField_a_of_type_JavaUtilArrayList.add(z);
        return;
        this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      }
      if (GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        a(1, this.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
      if (!TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localObject1 = this.jdField_a_of_type_Array2dOfInt;
      i2 = localObject1.length;
      i1 = 0;
      while (i1 < i2)
      {
        localObject2 = localObject1[i1];
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        i1 += 1;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    localObject1 = (TroopAppMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
    Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    label297:
    label307:
    long l1;
    if (((TroopInfo)localObject2).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      i1 = 1;
      if (!((TroopInfo)localObject2).isAdmin()) {
        break label555;
      }
      i2 = 1;
      l1 = (i1 & 0x1) << 2 | (i2 & 0x1) << 1 | 0x1;
      i1 = 0;
      if (((TroopInfo)localObject2).isHomeworkTroop()) {
        i1 = 32;
      }
      if (localObject1 != null) {
        break label560;
      }
      localObject1 = null;
      label344:
      localObject2 = localObject1;
      if (AudioHelper.d())
      {
        localObject2 = localObject1;
        if (AudioHelper.a(4) == 1)
        {
          AudioHelper.a("群应用使用本地配置");
          localObject2 = null;
        }
      }
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        break label759;
      }
      if (QLog.isDevelopLevel()) {
        QLog.w("PlusPanel", 1, "reloadTroop, server, troopAppInfos[" + ((List)localObject2).size() + "]");
      }
      localObject1 = ((List)localObject2).iterator();
    }
    label444:
    label743:
    label757:
    for (;;)
    {
      int[] arrayOfInt1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopAIOAppInfo)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((TroopAIOAppInfo)localObject2).minVersion)) && (AppSetting.a(((TroopAIOAppInfo)localObject2).minVersion) < 0)) {
          continue;
        }
        if ((((TroopAIOAppInfo)localObject2).identifyMask & l1) == 0L)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d(".troop.troop_appPlusPanel", 1, new Object[] { "reloadTroop, appInfo is filtered: info: ", String.valueOf(localObject2), " userIdentify: ", Long.toBinaryString(l1) });
          continue;
          i1 = 0;
          break label297;
          i2 = 0;
          break label307;
          localObject1 = ((TroopAppMgr)localObject1).a(false, i1);
          break label344;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(((TroopAIOAppInfo)localObject2).appid, localObject2);
        int[][] arrayOfInt = this.jdField_c_of_type_Array2dOfInt;
        int i4 = arrayOfInt.length;
        i1 = 0;
        i2 = 0;
        for (;;)
        {
          i3 = i1;
          if (i2 >= i4) {
            break label698;
          }
          arrayOfInt1 = arrayOfInt[i2];
          i3 = i1;
          if (arrayOfInt1.length >= 3)
          {
            i3 = i1;
            if (((TroopAIOAppInfo)localObject2).appid == arrayOfInt1[2])
            {
              i1 = 1;
              i3 = 1;
              if ((arrayOfInt1 != this.S) || (ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a())) {
                break;
              }
            }
          }
          i2 += 1;
          i1 = i3;
        }
        if (arrayOfInt1 != ab) {
          break label743;
        }
        b(1, this.jdField_a_of_type_JavaUtilArrayList);
      }
      for (int i3 = i1;; i3 = i1)
      {
        if (i3 != 0) {
          break label757;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(new int[] { -((TroopAIOAppInfo)localObject2).appid, -((TroopAIOAppInfo)localObject2).appid, ((TroopAIOAppInfo)localObject2).appid });
        break label444;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(arrayOfInt1);
      }
    }
    label555:
    label560:
    label698:
    label759:
    if (QLog.isDevelopLevel()) {
      QLog.w("PlusPanel", 1, "reloadTroop, local, troopAppInfos[" + this.jdField_b_of_type_Array2dOfInt.length + "]");
    }
    localObject1 = this.jdField_b_of_type_Array2dOfInt;
    int i2 = localObject1.length;
    int i1 = 0;
    label814:
    if (i1 < i2)
    {
      localObject2 = localObject1[i1];
      if (localObject2 != v) {
        break label847;
      }
      b("200002");
    }
    for (;;)
    {
      i1 += 1;
      break label814;
      break;
      label847:
      if ((localObject2 != this.S) || (ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a())) {
        if (localObject2 == ab) {
          b(1, this.jdField_a_of_type_JavaUtilArrayList);
        } else {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        }
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "[checkApolloGameGuide] remove apollo game guide");
      }
      removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
  }
  
  private void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), null);
    localActionSheet.a(2131430423, 5);
    boolean bool = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (bool) {}
    for (String str = BaseApplicationImpl.getContext().getResources().getString(2131430422);; str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getResources().getString(2131430421))
    {
      localActionSheet.a(str, 5);
      localActionSheet.c(2131433015);
      localActionSheet.a(new umf(this, bool, localActionSheet));
      if (!localActionSheet.isShowing()) {
        localActionSheet.show();
      }
      return;
    }
  }
  
  private void f()
  {
    int i2 = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reloadFriend app is null");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PlusPanel", 2, "reloadFriend() sessionInfo is null");
    return;
    if (BmqqSegmentUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
      this.jdField_a_of_type_JavaUtilArrayList.add(H);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.s);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
      this.jdField_a_of_type_JavaUtilArrayList.add(t);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
      this.jdField_a_of_type_JavaUtilArrayList.add(O);
      return;
    }
    if (GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      a(0, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    int i3 = PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    int i4 = PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
    b(0, this.jdField_a_of_type_JavaUtilArrayList);
    if (ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) {
      this.jdField_a_of_type_JavaUtilArrayList.add(this.S);
    }
    int i1;
    if (ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, super.getContext()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(U);
      i1 = 0;
      label293:
      this.jdField_a_of_type_JavaUtilArrayList.add(C);
      a(i3, i4);
      this.jdField_a_of_type_JavaUtilArrayList.add(E);
      this.jdField_a_of_type_JavaUtilArrayList.add(t);
      b("200002");
      this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
      this.jdField_a_of_type_JavaUtilArrayList.add(O);
      BusinessCardManager localBusinessCardManager = (BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(111);
      if ((localBusinessCardManager != null) && (localBusinessCardManager.a(3))) {
        this.jdField_a_of_type_JavaUtilArrayList.add(P);
      }
      if ((ApolloManager.a(getContext(), Boolean.valueOf(false))) && (ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "aio", null) > 0)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(T);
      }
      if (i1 == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(D);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(H);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
      if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        break label725;
      }
      i1 = i2;
      label522:
      if (i1 != 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.p);
        this.jdField_a_of_type_JavaUtilArrayList.remove(C);
        this.jdField_a_of_type_JavaUtilArrayList.remove(v);
        this.jdField_a_of_type_JavaUtilArrayList.remove(V);
        this.jdField_a_of_type_JavaUtilArrayList.remove(ab);
        b("200002");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label730;
      }
      this.jdField_a_of_type_JavaUtilArrayList.remove(C);
      this.jdField_a_of_type_JavaUtilArrayList.remove(v);
      this.jdField_a_of_type_JavaUtilArrayList.remove(V);
      this.jdField_a_of_type_JavaUtilArrayList.remove(ab);
      b("200002");
    }
    for (;;)
    {
      if (!ArkAiAppCenter.g) {
        this.jdField_a_of_type_JavaUtilArrayList.add(aa);
      }
      if ((i1 != 0) || (!ReceiptUtil.a())) {
        break;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(X);
      return;
      this.jdField_a_of_type_JavaUtilArrayList.add(D);
      i1 = 1;
      break label293;
      label725:
      i1 = 0;
      break label522;
      label730:
      if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
        this.jdField_a_of_type_JavaUtilArrayList.remove(ab);
      }
    }
  }
  
  public DeviceInfo a(long paramLong)
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    if (localSmartDeviceProxyMgr != null) {
      return localSmartDeviceProxyMgr.a(paramLong);
    }
    return null;
  }
  
  public void a()
  {
    boolean bool = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_hotchat_hongbao.name(), "1"));
    ShortVideoUtils.jdField_a_of_type_Boolean = ShortVideoUtils.b();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanel", 2, "reload(): showHongBao=" + bool + " type=" + i2);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("PlusPanel", 2, "reload(): iconList size[" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      if (i2 != 3000) {
        break label858;
      }
      if (!GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
        break label547;
      }
      a(i2, this.jdField_a_of_type_JavaUtilArrayList);
      label164:
      if ((!VcSystemInfo.c()) || (!VcSystemInfo.d()))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.f);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.h);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.i);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.j);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.k);
        this.jdField_a_of_type_JavaUtilArrayList.remove(this.l);
      }
      if ((i2 != 1) || (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label2807;
      }
    }
    label291:
    label858:
    label2288:
    label2422:
    label2807:
    for (int i1 = 1;; i1 = 0)
    {
      ArrayList localArrayList = new ArrayList();
      i2 = 0;
      Object localObject3;
      if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        int[] arrayOfInt = (int[])this.jdField_a_of_type_JavaUtilArrayList.get(i2);
        PlusPanel.PluginData localPluginData = new PlusPanel.PluginData();
        Object localObject4;
        Resources localResources;
        int i3;
        if ((i1 != 0) && (arrayOfInt.length >= 3) && (this.jdField_a_of_type_AndroidUtilSparseArray != null))
        {
          localObject4 = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(arrayOfInt[2]);
          if (localObject4 != null)
          {
            localResources = BaseApplicationImpl.getContext().getResources();
            for (;;)
            {
              for (;;)
              {
                try
                {
                  localObject1 = URLDrawable.URLDrawableOptions.obtain();
                  if ((arrayOfInt.length < 2) || (arrayOfInt[1] <= 0)) {
                    continue;
                  }
                  i3 = arrayOfInt[1];
                  ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localResources.getDrawable(i3);
                  ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localResources.getDrawable(i3);
                  localObject1 = URLDrawable.getDrawable(((TroopAIOAppInfo)localObject4).iconUrl, (URLDrawable.URLDrawableOptions)localObject1);
                }
                catch (Exception localException2)
                {
                  Object localObject1;
                  localObject2 = localResources.getDrawable(2130841266);
                  continue;
                }
                localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
                localPluginData.jdField_a_of_type_Int = arrayOfInt[1];
                localPluginData.jdField_b_of_type_Int = ((TroopAIOAppInfo)localObject4).appid;
                localPluginData.jdField_a_of_type_JavaLangString = ((TroopAIOAppInfo)localObject4).name;
                localPluginData.jdField_a_of_type_Boolean = ((TroopAIOAppInfo)localObject4).redPoint;
                localPluginData.jdField_b_of_type_JavaLangString = (localPluginData.jdField_a_of_type_JavaLangString + " 按钮");
                localArrayList.add(localPluginData);
                if (localPluginData.jdField_b_of_type_Int == 1104874204) {
                  this.jdField_a_of_type_Int = (i2 / 8);
                }
                i2 += 1;
                break label291;
                this.jdField_a_of_type_JavaUtilArrayList.clear();
                break;
                this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
                this.jdField_a_of_type_JavaUtilArrayList.add(K);
                this.jdField_a_of_type_JavaUtilArrayList.add(H);
                b(3000, this.jdField_a_of_type_JavaUtilArrayList);
                if (ScribbleResMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) {
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.S);
                }
                if (ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, super.getContext()))
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(U);
                  i1 = 0;
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.u);
                  this.jdField_a_of_type_JavaUtilArrayList.add(O);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                  localObject1 = (BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(111);
                  this.jdField_a_of_type_JavaUtilArrayList.add(t);
                  b("200002");
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                  if ((localObject1 != null) && (((BusinessCardManager)localObject1).a(3))) {
                    this.jdField_a_of_type_JavaUtilArrayList.add(P);
                  }
                  if ((ApolloManager.a(super.getContext())) && (ApolloManager.c("discuss") == 1)) {
                    this.jdField_a_of_type_JavaUtilArrayList.add(T);
                  }
                  if (i1 == 0) {
                    this.jdField_a_of_type_JavaUtilArrayList.add(D);
                  }
                  this.jdField_a_of_type_JavaUtilArrayList.add(E);
                  if (ReceiptUtil.a()) {
                    this.jdField_a_of_type_JavaUtilArrayList.add(X);
                  }
                  if (ArkAiAppCenter.g) {
                    break label164;
                  }
                  this.jdField_a_of_type_JavaUtilArrayList.add(aa);
                  break label164;
                }
                this.jdField_a_of_type_JavaUtilArrayList.add(D);
                i1 = 1;
                continue;
                if (i2 == 1)
                {
                  c(bool);
                  break label164;
                }
                if ((i2 == 1000) || (i2 == 1004))
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                  this.jdField_a_of_type_JavaUtilArrayList.add(H);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                  this.jdField_a_of_type_JavaUtilArrayList.add(O);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                  if (!BmqqSegmentUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                  {
                    this.jdField_a_of_type_JavaUtilArrayList.add(D);
                    this.jdField_a_of_type_JavaUtilArrayList.add(C);
                  }
                  this.jdField_a_of_type_JavaUtilArrayList.add(E);
                  break label164;
                }
                if (i2 == 10004)
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                  break label164;
                }
                if (i2 == 1006)
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                  this.jdField_a_of_type_JavaUtilArrayList.add(H);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                  this.jdField_a_of_type_JavaUtilArrayList.add(O);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                  break label164;
                }
                if (i2 == 1020) {
                  break label164;
                }
                if (i2 == 1025)
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                  this.jdField_a_of_type_JavaUtilArrayList.add(H);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                  break label164;
                }
                if ((i2 == 1008) || (i2 == 1024))
                {
                  localObject1 = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
                  if (((QidianManager)localObject1).f(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                  {
                    if (((QidianManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
                    {
                      this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
                      this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                    }
                    this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                    this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                    break label164;
                  }
                  if (CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
                    this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
                  }
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ArrayOfInt);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_ArrayOfInt);
                  if (i2 == 1008)
                  {
                    localObject1 = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    if ((localObject1 != null) && ((((PublicAccountInfo)localObject1).accountFlag & 0x20000000) != 0) && (ShortVideoUtils.jdField_a_of_type_Boolean) && (VideoEnvironment.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
                    {
                      this.jdField_a_of_type_Boolean = true;
                      this.jdField_a_of_type_JavaUtilArrayList.add(this.e);
                    }
                    if ((localObject1 != null) && ((((PublicAccountInfo)localObject1).accountFlag & 0x10000000) != 0)) {
                      this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_a_of_type_ArrayOfInt);
                    }
                  }
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                  break label164;
                }
                if ((i2 == 1005) || (i2 == 1003)) {
                  break label164;
                }
                if (i2 == 1001)
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                  this.jdField_a_of_type_JavaUtilArrayList.add(H);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                  this.jdField_a_of_type_JavaUtilArrayList.add(E);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                  break label164;
                }
                if (i2 == 10002)
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                  this.jdField_a_of_type_JavaUtilArrayList.add(H);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                  this.jdField_a_of_type_JavaUtilArrayList.add(E);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                  break label164;
                }
                if (i2 == 1010)
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                  this.jdField_a_of_type_JavaUtilArrayList.add(H);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                  this.jdField_a_of_type_JavaUtilArrayList.add(E);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                  break label164;
                }
                if (i2 == 1021)
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                  this.jdField_a_of_type_JavaUtilArrayList.add(H);
                  break label164;
                }
                if (i2 == 1029)
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(H);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
                  break label164;
                }
                if ((i2 == 1022) || (i2 == 1009) || (i2 == 1024) || (i2 == 1023)) {
                  break label164;
                }
                if (i2 == 6000)
                {
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
                  this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                  this.jdField_a_of_type_JavaUtilArrayList.add(H);
                  break label164;
                }
                if (i2 == 9501) {
                  try
                  {
                    l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                    localObject1 = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
                    if ((localObject1 == null) || (!((SmartDeviceProxyMgr)localObject1).c(l1))) {
                      break label164;
                    }
                    this.jdField_a_of_type_JavaUtilArrayList.add(this.n);
                  }
                  catch (Exception localException1)
                  {
                    localException1.printStackTrace();
                    long l1 = 0L;
                  }
                }
              }
              if ((i2 == 0) || (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
              {
                f();
                break label164;
              }
              this.jdField_a_of_type_JavaUtilArrayList.add(this.m);
              break label164;
              i3 = 2130841266;
            }
          }
        }
        Object localObject2;
        if ((ah == arrayOfInt) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper$GoldMsgIcon != null))
        {
          localObject4 = BaseApplicationImpl.getContext().getResources();
          for (;;)
          {
            try
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              if ((arrayOfInt.length < 2) || (arrayOfInt[1] <= 0)) {
                continue;
              }
              i3 = arrayOfInt[1];
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Resources)localObject4).getDrawable(i3);
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Resources)localObject4).getDrawable(i3);
              localObject2 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper$GoldMsgIcon.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
            }
            catch (Exception localException3)
            {
              localObject3 = ((Resources)localObject4).getDrawable(2130841266);
              continue;
            }
            localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject2);
            localPluginData.jdField_a_of_type_Int = arrayOfInt[1];
            localPluginData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper$GoldMsgIcon.jdField_a_of_type_JavaLangString;
            localPluginData.jdField_b_of_type_JavaLangString = (localPluginData.jdField_a_of_type_JavaLangString + " 按钮");
            localArrayList.add(localPluginData);
            break;
            i3 = 2130841266;
          }
        }
        localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(arrayOfInt[1]);
        localPluginData.jdField_a_of_type_Int = arrayOfInt[1];
        localPluginData.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]);
        localObject3 = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        if (localObject3 != null)
        {
          if (((GameCenterManagerImp)localObject3).a("999999.100004") != -1) {
            bool = true;
          }
        }
        else
        {
          if (this.jdField_b_of_type_Int != 7) {
            break label2422;
          }
          localObject3 = "chat_tool_gift_stranger_clicked";
          label2302:
          if ((arrayOfInt != I) || (!a("chat_tool_dingyue"))) {
            break label2430;
          }
          localPluginData.jdField_a_of_type_Boolean = true;
          localPluginData.jdField_b_of_type_JavaLangString = (BaseApplicationImpl.getContext().getResources().getString(arrayOfInt[0]) + "按钮");
          if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            if (arrayOfInt != this.jdField_b_of_type_ArrayOfInt) {
              break label2627;
            }
            localPluginData.jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(2131430457);
          }
        }
        for (;;)
        {
          localArrayList.add(localPluginData);
          break;
          bool = false;
          break label2288;
          localObject3 = "chat_tool_gift_clicked";
          break label2302;
          label2430:
          if ((arrayOfInt == C) && (a("chat_tool_qwallettransfer")))
          {
            localPluginData.jdField_a_of_type_Boolean = true;
            break label2326;
          }
          if ((arrayOfInt == H) && (a("chat_tool_qfav")))
          {
            localPluginData.jdField_a_of_type_Boolean = true;
            break label2326;
          }
          if ((arrayOfInt == T) && (a("chat_tool_apollo")))
          {
            localPluginData.jdField_a_of_type_Boolean = true;
            break label2326;
          }
          if ((arrayOfInt == U) && (a("chat_tool_apollo_game")))
          {
            localPluginData.jdField_a_of_type_Boolean = true;
            break label2326;
          }
          if ((arrayOfInt == V) && (a("chat_tool_poke")))
          {
            localPluginData.jdField_a_of_type_Boolean = true;
            break label2326;
          }
          if ((arrayOfInt == ab) && (a("chat_tool_gold_msg")))
          {
            localPluginData.jdField_a_of_type_Boolean = true;
            break label2326;
          }
          if ((arrayOfInt == E) && (a((String)localObject3)))
          {
            localPluginData.jdField_a_of_type_Boolean = true;
            break label2326;
          }
          localPluginData.jdField_a_of_type_Boolean = false;
          break label2326;
          if (arrayOfInt == this.jdField_c_of_type_ArrayOfInt) {
            localPluginData.jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(2131430456);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(null);
      if (i1 != 0)
      {
        localObject3 = (TroopAppMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
        if (localObject3 != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(((TroopAppMgr)localObject3).a());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(localArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount() > 1) {}
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount(), false);
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
          post(new uma(this));
          return;
        }
        catch (Exception localException4)
        {
          QLog.d("PlusPanel", 2, "e=" + localException4);
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlusPanel", 2, new Object[] { "onPlusPanelPageExpose", "Page ", Integer.valueOf(paramInt), " Stack: ", FeedUtils.a(5) });
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(paramInt).iterator();
    while (localIterator.hasNext())
    {
      String str;
      switch (((PlusPanel.PluginData)localIterator.next()).jdField_b_of_type_Int)
      {
      default: 
        break;
      case 1106717414: 
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "Grp_chain", "ChainEntry_Show");
        break;
      case 1106729451: 
        str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "MassMessage", "grpapp_Show");
      }
    }
  }
  
  protected void a(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setPagerChangedListener(paramOnPageChangeListener);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131363035));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131363036));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter = new PanelAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter);
    a(this);
    paramBaseChatPie = getResources().getDrawable(2130845947);
    if ((paramBaseChatPie instanceof BitmapDrawable)) {
      paramBaseChatPie = ((BitmapDrawable)paramBaseChatPie).getBitmap();
    }
    for (;;)
    {
      paramBaseChatPie = new BitmapDrawable(paramBaseChatPie);
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paramBaseChatPie.setDither(true);
        setBackgroundDrawable(paramBaseChatPie);
        label154:
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
          break label211;
        }
        this.jdField_b_of_type_Int = 1;
      }
      for (;;)
      {
        a();
        return;
        if (!(paramBaseChatPie instanceof SkinnableBitmapDrawable)) {
          break label267;
        }
        paramBaseChatPie = ((SkinnableBitmapDrawable)paramBaseChatPie).getBitmap();
        break;
        if (!QLog.isColorLevel()) {
          break label154;
        }
        QLog.d("AIOAudioPanel", 2, "PlusPanle background is null:");
        break label154;
        label211:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof FriendChatPie)) {
          this.jdField_b_of_type_Int = 2;
        } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof DiscussChatPie)) {
          this.jdField_b_of_type_Int = 6;
        } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof StrangerChatPie)) {
          this.jdField_b_of_type_Int = 7;
        }
      }
      label267:
      paramBaseChatPie = null;
    }
  }
  
  void a(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (paramString.equals("chat_tool_audio")) {
      localSharedPreferences.edit().putBoolean(paramString, false).commit();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
      return;
      if (paramString.equals("chat_tool_gaudio")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_gaudio_new")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_poke")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_gold_msg")) {
        localSharedPreferences.edit().putBoolean(paramString, false).apply();
      } else if (paramString.equals("chat_tool_gift_clicked")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else if (paramString.equals("chat_tool_gift_stranger_clicked")) {
        localSharedPreferences.edit().putBoolean(paramString, false).commit();
      } else {
        localSharedPreferences.edit().putBoolean(paramString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    QAVGroupConfig.Report.b(paramBoolean);
    VideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 10, paramBoolean, -1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ai();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i1 = PokeItemHelper.b(paramQQAppInterface, 0);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = paramSharedPreferences.getBoolean("chat_tool_poke_clicked", false);; bool1 = false)
    {
      boolean bool2 = bool3;
      if (i1 == 2)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(PokeItemHelper.jdField_a_of_type_JavaLangString, 2, "plus getPokeNeedRed isPokeNeedRed=" + bool2 + " getPokeMsgFoldSwitch=" + i1 + " hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  public void b()
  {
    a();
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 1106717414)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "Grp_chain", "ChainEntry_Clk");
    }
    while (paramInt != 1106729451) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "MassMessage", "grpapp_Clk");
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    Object localObject1 = (PanelAdapter.ViewHolder)paramView.getTag();
    int i3 = ((PanelAdapter.ViewHolder)localObject1).jdField_a_of_type_Int;
    int i1 = ((PanelAdapter.ViewHolder)localObject1).jdField_b_of_type_Int;
    i1 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {}
    for (;;)
    {
      label563:
      Object localObject2;
      boolean bool1;
      try
      {
        paramView = a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        if (paramView != null) {
          i1 = paramView.productId;
        }
      }
      catch (Exception paramView)
      {
        i1 = 0;
        continue;
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
        if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          continue;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        continue;
        if (VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          continue;
        }
        DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131433016, new umb(this)).show();
        continue;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.r()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.r(2);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ao();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) {
          break label1140;
        }
      }
      d();
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aW();
      paramView = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
      switch (i3)
      {
      default: 
        umw.a(this, (PanelAdapter.ViewHolder)localObject1);
      case 2130838387: 
      case 2130840643: 
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          if (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
              break;
            }
            paramView = null;
            localObject2 = (TroopAppMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
            if ((paramView != null) && (paramView.redPoint)) {
              ThreadManager.post(new umc(this, (TroopAppMgr)localObject2, paramView), 8, null, false);
            }
            if ((paramView == null) || (!paramView.canRemove)) {
              break label7906;
            }
            bool1 = true;
            a(i3, ((PanelAdapter.ViewHolder)localObject1).jdField_b_of_type_Int, bool1);
            if (localObject2 != null) {
              ((TroopAppMgr)localObject2).a(((PanelAdapter.ViewHolder)localObject1).jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            }
          }
          return;
        }
        break;
      case 2130838384: 
      case 2130838407: 
      case 2130838398: 
      case 2130838401: 
        label620:
        paramView = new Intent();
        label656:
        if (paramView != null) {
          if (DeviceMsgChatPie.S) {
            break label1134;
          }
        }
        label955:
        label1134:
        for (bool1 = true;; bool1 = false)
        {
          paramView.putExtra("isdevicesupportmultiupload", bool1);
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramView);
          SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 3, 0, i1);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
          {
            paramView = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
              paramView.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          }
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004079", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 3, 0, i1);
          }
          if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          break;
        }
        label1140:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          paramView = new Intent();
          paramView.putExtra("filter_photolist_troopalbum_toolbar", true);
        }
        break;
      }
      for (;;)
      {
        PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        break label955;
        if (QLog.isColorLevel()) {
          QLog.i("testing", 2, "deliver flowers!");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.k(true);
        long l1 = System.currentTimeMillis();
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
        long l2;
        if (paramView != null)
        {
          l2 = paramView.jdField_a_of_type_Long;
          if ((!paramView.jdField_a_of_type_Boolean) || (l1 < paramView.jdField_a_of_type_Long) || (l1 > l2 + 2592000000L) || (((TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a())) {}
        }
        for (bool1 = true;; bool1 = false)
        {
          for (;;)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof NearbyChatPie))
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)
              {
                paramView = "3";
                label1351:
                NearbyFlowerManager.a("gift_aio", "clk_icon", (String)localObject2, paramView, "", "");
                label1369:
                if (this.jdField_b_of_type_Int != 7) {
                  break label1704;
                }
              }
            }
            label1704:
            for (paramView = "chat_tool_gift_stranger_clicked";; paramView = "chat_tool_gift_clicked")
            {
              a(paramView);
              b();
              break;
              paramView = "0";
              break label1351;
              if (this.jdField_b_of_type_Int == 2)
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "gift_clk", 0, 0, "", "", "", "");
                break label1369;
              }
              if (this.jdField_b_of_type_Int == 6)
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "gift_clk", 0, 0, "", "", "", "");
                break label1369;
              }
              if (this.jdField_b_of_type_Int == 7)
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "gift_clk", 0, 0, "", "", "", "");
                break label1369;
              }
              if (this.jdField_b_of_type_Int != 1) {
                break label1369;
              }
              if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
              {
                ReportController.b(null, "dc00899", "Grp_anon", "", "aio_plus", "clk_send", 1, 0, "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
                break label1369;
              }
              ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_plus", 0, 0, "" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + bool1, "", "");
              break label1369;
            }
            paramView = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (!paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
              e();
            }
            for (;;)
            {
              AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407F", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              break;
              PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
              if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
            {
              a(true);
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
            {
              a("chat_tool_gaudio");
              paramView = new Bundle();
              paramView.putBoolean("isVideo", true);
              ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, paramView);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ai();
              b();
              if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
              }
              l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b() == l1) {
                break;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005676", "0X8005676", 0, 0, "", "", "", "");
              break;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005153", "0X8005153", 0, 0, "", "", "", "");
              if (!LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(BaseApplicationImpl.getContext().getString(2131437411));
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
                for (paramView = "0";; paramView = "1")
                {
                  ReportController.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramView, "1", "", "");
                  break;
                }
              }
            }
            else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && (!DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(BaseApplicationImpl.getContext().getString(2131437411));
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ao();
            PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, null, null);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ai();
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
            }
            AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004086", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break;
            if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof PublicAccountChatPie)) {
              break;
            }
            ((PublicAccountChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).p.performClick();
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
            {
              a(false);
              break;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
            {
              a("chat_tool_gaudio");
              PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, true, null, 0);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ai();
              b();
              if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
              }
              l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b() == l1) {
                break;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004085", "0X8004085", 0, 0, "", "", "", "");
              break;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005152", "0X8005152", 0, 0, "", "", "", "");
              if (!LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(BaseApplicationImpl.getContext().getString(2131437410));
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
                for (paramView = "0";; paramView = "1")
                {
                  ReportController.b((QQAppInterface)localObject2, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramView, "0", "", "");
                  break;
                }
              }
            }
            else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && (!DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d(BaseApplicationImpl.getContext().getString(2131437410));
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
              break;
            }
            a("chat_tool_audio");
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ai();
            b();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024)
            {
              if (((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
              {
                PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, null);
                break;
              }
              if (CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
              {
                CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "IvrAIOBottomButtonEngineFalse");
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004651", "0X8004651", 0, 0, "", "", "", "");
              }
            }
            for (;;)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
              }
              AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407B", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              break;
              QQToast.a(BaseApplicationImpl.getContext(), 2131429075, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
              if (QLog.isColorLevel())
              {
                QLog.d("AIOAudioPanel", 2, "Don't support ivr");
                continue;
                PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, null);
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
              break;
            }
            try
            {
              l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              i1 = UITools.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i1, l1);
              paramView = (TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47);
              bool1 = paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              boolean bool2 = paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              boolean bool3 = paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              paramView = paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              if ((l1 == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (paramView != null) && (paramView.jdField_a_of_type_Long > 0L)))) {
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, "禁言中，无法开启视频", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
              }
            }
            catch (NumberFormatException paramView)
            {
              for (;;)
              {
                l1 = 0L;
              }
              a("chat_tool_gaudio");
              paramView = new HashMap();
              paramView.put("MultiAVType", String.valueOf(2));
              paramView.put("from", "Panel");
              ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramView);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ai();
              b();
              if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
              }
              l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(1, l1)) {
                ReportController.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "1", "");
              }
              AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB5", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            }
          }
          break;
          Environment.getExternalStorageState();
          l1 = 0L;
          try
          {
            l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            l1 = l2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) && (paramView != null) && (paramView.c(l1)))
              {
                PlusPanelUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              }
              else
              {
                AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407C", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                paramView = new FileManagerReporter.fileAssistantReportData();
                paramView.jdField_b_of_type_JavaLangString = "send_file";
                paramView.jdField_a_of_type_Int = 1;
                FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramView);
                PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              }
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407E", "0X800407E", 0, 0, "", "", "", "");
            PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
            break;
          }
          a("chat_tool_qlink_file");
          b();
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800407D", "0X800407D", 0, 0, "", "", "", "");
          break;
          i1 = 1;
          if (this.jdField_b_of_type_Long == -1L)
          {
            label3843:
            if (i1 == 0) {
              break label3912;
            }
            ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            this.jdField_b_of_type_Long = System.currentTimeMillis();
          }
          for (;;)
          {
            AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004081", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break;
            if (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 10000L) {
              break label3843;
            }
            i1 = 0;
            break label3843;
            label3912:
            QQToast.a(BaseApplicationImpl.getContext(), "歇一会再发送窗口抖动吧", 0).a();
          }
          paramView = new Bundle();
          paramView.putInt("forward_type", 23);
          paramView.putInt("curent_aio_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramView.putString("curent_aio_uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          paramView.putString("curent_aio_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramView.putString("curent_aio_troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
          Object localObject3 = new Intent();
          ((Intent)localObject3).putExtras(paramView);
          ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (Intent)localObject3, 21);
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80056B3", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8007010", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          paramView = new Bundle();
          paramView.putInt("forward_type", 23);
          paramView.putInt("curent_aio_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramView.putString("curent_aio_uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          paramView.putString("curent_aio_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramView.putString("curent_aio_troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
          localObject3 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), BusinessCardListActivity.class);
          ((Intent)localObject3).putExtras(paramView);
          ((Intent)localObject3).putExtra("Extra_Entrance", 3);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivityForResult((Intent)localObject3, 21);
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X80064F3", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
            break label656;
          }
          paramView = AuthorizeConfig.a().a("aio_qqMusicShare", "");
          PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004083", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          ThridAppShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "200002", "http://m.dianping.com/qq/aiodwonload", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          ThridAppShareHelper.a("200002", "click_app", "", "", "");
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB2", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0");
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB6", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          paramView = new Bundle();
          paramView.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramView.putBoolean("hide_operation_bar", true);
          paramView.putBoolean("hide_more_button", true);
          paramView.putBoolean("isScreenOrientationPortrait", true);
          TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramView);
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB8", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          break;
          if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            a("chat_tool_anonymous");
            b();
            if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
              break label656;
            }
            ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).a(2, "");
            ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_anon", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
            AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB4", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break;
          }
          if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
            break label656;
          }
          ((TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).p(false);
          ReportController.a(null, "P_CliOper", "Grp_anon", "", "norm_aio", "Clk_quit", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "", "", "");
          break;
          if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localObject3 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if ((localObject3 != null) && (!TextUtils.isEmpty(paramView))) {
            if ((((TroopInfo)localObject3).Administrator != null) && (((TroopInfo)localObject3).Administrator.contains(paramView))) {
              i1 = 3;
            }
          }
          for (;;)
          {
            label4765:
            paramView = AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject3 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
            Object localObject4 = new StringBuilder().append("http://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).append("&avatar=").append(AnonymousChatHelper.a(paramView.jdField_a_of_type_Int)).append("&nick=");
            if (TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString)) {}
            for (paramView = "";; paramView = URLEncoder.encode(paramView.jdField_a_of_type_JavaLangString))
            {
              ((Intent)localObject3).putExtra("url", paramView + "&role=" + String.valueOf(i1) + "&self=1");
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject3);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "aio_plus", "clk_change", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(i1), "", "");
              break;
              if (paramView.equals(((TroopInfo)localObject3).troopowneruin))
              {
                i1 = 2;
                break label4765;
              }
              i1 = 1;
              break label4765;
            }
            a("chat_tool_qwallettransfer");
            b();
            localObject3 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), TransactionActivity.class);
            ((Intent)localObject3).putExtra("come_from", 2);
            int i2 = 0;
            i1 = 0;
            paramView = null;
            switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
            {
            }
            for (;;)
            {
              localObject4 = new JSONObject();
              try
              {
                ((JSONObject)localObject4).put("targetUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                ((JSONObject)localObject4).put("targetNickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
                ((JSONObject)localObject4).put("sign", "");
                if (i2 != 0) {
                  ((JSONObject)localObject4).put("source", i2);
                }
                ((JSONObject)localObject4).put("group_type", i1);
                if (!TextUtils.isEmpty(paramView)) {
                  ((JSONObject)localObject4).put("group_uin", paramView);
                }
              }
              catch (JSONException paramView)
              {
                for (;;)
                {
                  paramView.printStackTrace();
                }
              }
              ((Intent)localObject3).putExtra("extra_data", ((JSONObject)localObject4).toString());
              ((Intent)localObject3).putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#aio");
              ((Intent)localObject3).putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "transfer", "click", "sessionType=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 0, null));
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject3);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOclick", 0, 0, "", "", "", "");
              AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB0", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              break;
              i2 = 5;
              i1 = 3;
              paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
              continue;
              i2 = 5;
              i1 = 4;
              paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
            }
            DevVideoMsgProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
              break;
            }
            SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), "Usr_AIO_SendMsg", 4, 0, i1);
            break;
            l1 = System.currentTimeMillis();
            if (Math.abs(l1 - this.jdField_a_of_type_Long) < 1000L) {
              break label656;
            }
            this.jdField_a_of_type_Long = l1;
            b();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aq();
            break;
            a("chat_tool_qfav");
            b();
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
              break;
            }
            PlusPanelUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setCanLock(false);
            AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break;
            a("chat_tool_dingyue");
            b();
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
            paramView.putExtra("url", "https://buluo.qq.com/cgi-bin/bar/group_subscribe/entrance?gid=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_sub", 0, 0, "", "", "", "");
            break;
            a("chat_tool_toupiao");
            b();
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
            paramView.putExtra("selfSet_leftViewText", "返回");
            paramView.putExtra("url", "https://client.qun.qq.com/qqweb/m/qun/vote/index.html?_wv=1031&_bid=2035&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "&src=3");
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "add_page", "Clk_vote", 0, 0, "", "", "", "");
            AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CB9", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break;
            paramView = new Intent();
            if (1 == this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
            {
              paramView.putExtra("ApprovalOpenParams.opentype", 1);
              paramView.putExtra("ApprovalOpenParams.fromuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            }
            DingdongPluginHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "com.dingdong.business.approval.activity.ApprovalSessionsActivity", paramView, -1);
            break;
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
            paramView.putExtra("url", "https://mqq.tenpay.com/v2/hybrid/www/mobile_qq/aareceive/index.shtml" + "?_wv=1793&f=6&uintype=3000&touin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            paramView.putExtra("app_info", "appid#20000002|bargainor_id#1000026801|channel#aio");
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "shoukuan_AIOclick", 0, 0, "", "", "", "");
            AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CBB", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break;
            if ((this.jdField_a_of_type_AndroidUtilSparseArray == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.indexOfKey(((PanelAdapter.ViewHolder)localObject1).jdField_b_of_type_Int) < 0)) {
              break;
            }
            paramView = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(((PanelAdapter.ViewHolder)localObject1).jdField_b_of_type_Int);
            localObject3 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
            if ((paramView == null) || (paramView.url == null)) {
              break;
            }
            ((Intent)localObject3).putExtra("url", paramView.url.replace("$GCODE$", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject3);
            AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CBA", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            break;
            paramView = (TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97);
            if (paramView == null) {
              break;
            }
            TroopBarUtils.a.clear();
            paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_talk", "", "Grp_plus", "Clk_app", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
            break;
            if (paramView == null) {
              break;
            }
            localObject3 = a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
            if (localObject3 == null) {
              break;
            }
            paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), (DeviceInfo)localObject3, false);
            break;
            bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
            a("chat_tool_apollo");
            if (bool1) {
              b();
            }
            for (i1 = 1;; i1 = 0)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.o(0);
              }
              paramView = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
              i2 = paramView.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
              String str = "" + i1;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {}
              for (paramView = "0";; paramView = "2")
              {
                VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "panel_enter_clk", (String)localObject4, i2, 0, new String[] { str, paramView, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                break;
              }
              bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getBoolean("chat_tool_apollo_game_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
              a("chat_tool_apollo_game");
              if (bool1) {
                b();
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.o(1);
              }
              paramView = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
              localObject3 = ((ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).h();
              if ((localObject3 != null) && (((List)localObject3).size() > 0)) {}
              for (i1 = ((List)localObject3).size();; i1 = 0)
              {
                VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clk_game_entrance", ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), paramView.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), new String[] { "" + i1 });
                break;
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aR();
                break;
                paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
                if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView))
                {
                  a("chat_tool_poke");
                  if (Build.VERSION.SDK_INT <= 8) {
                    break label6796;
                  }
                  paramView.edit().putBoolean("chat_tool_poke_clicked", true).apply();
                }
                for (;;)
                {
                  b();
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.at();
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X8007F21");
                  if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof BusinessCmrTmpChatPie)) {
                    break;
                  }
                  AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008AAA", "C_Master_PTT", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                  break;
                  label6796:
                  paramView.edit().putBoolean("chat_tool_poke_clicked", true).commit();
                }
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h(false);
                break;
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.au();
                break;
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aP();
                break;
                if (SharedPreUtils.s(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                  TroopPicEffectsEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
                }
                for (;;)
                {
                  TroopPicEffectsController.a("app_entry", "page_clk");
                  break;
                  SharedPreUtils.E(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                  paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), TroopPicEffectGuidePicActivity.class);
                  paramView.putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  paramView.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
                }
                if (!GoldMsgChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
                  break;
                }
                a();
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
                {
                  paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
                  if ((paramView.e != null) && (paramView.e.getVisibility() == 0))
                  {
                    paramView.e.setVisibility(8);
                    paramView.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
                    paramView.K = false;
                  }
                  paramView.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.a(paramView, true, false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                }
                a("chat_tool_gold_msg");
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "goldmsg.singleaio.enter", 0, 0, "", "", "", "");
                  break;
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
                  break;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "goldmsg.groupaio.enter", 0, 0, "", "", "", "");
                break;
                if (!GoldMsgChatHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
                  break;
                }
                a();
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, false, false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.a();
                  this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.b();
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "goldmsg.singleaio.quit", 0, 0, "", "", "", "");
                  break;
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
                  break;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "goldmsg.groupaio.quit", 0, 0, "", "", "", "");
                break;
                b(true);
                break;
                b(false);
                break;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
                  break;
                }
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.a();
                GoldMsgChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                paramView = new Intent(getContext(), GoldMsgSettingActivity.class);
                paramView.putExtra("goldmsg_frienduin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                paramView.putExtra("goldmsg_setting_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(paramView);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "goldmsg.singleaio.showsettings", 0, 0, "", "", "", "");
                  break;
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
                  break;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "goldmsg.groupaio.showsettings", 0, 0, "", "", "", "");
                break;
                if ((getContext() == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                  break;
                }
                GoldMsgChatHelper.a().a(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "goldmsg.singleaio.showrecord", 0, 0, "", "", "", "");
                  break;
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
                  break;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "goldmsg.groupaio.showrecord", 0, 0, "", "", "", "");
                break;
                if ((getContext() == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper$GoldMsgIcon == null)) {
                  break;
                }
                GoldMsgChatHelper.a().b(getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgChatHelper$GoldMsgIcon.c);
                break;
                paramView = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(((PanelAdapter.ViewHolder)localObject1).jdField_b_of_type_Int);
                if (paramView == null) {
                  break;
                }
                paramView = TroopStoryUtil.a(null, paramView.url, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                localObject3 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), JumpActivity.class);
                ((Intent)localObject3).setData(Uri.parse(paramView));
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject3);
                StoryReportor.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
                break;
                paramView = (TroopAIOAppInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(((PanelAdapter.ViewHolder)localObject1).jdField_b_of_type_Int);
                break label563;
                label7906:
                bool1 = false;
                break label620;
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10002)) {
                  break label656;
                }
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
                for (paramView = "0";; paramView = "1")
                {
                  ReportController.b((QQAppInterface)localObject1, "dc00899", "grp_lbs", "", "c2c_tmp", "clk_plus", 0, 0, paramView, a(i3), "", "");
                  return;
                }
              }
            }
            i1 = 0;
          }
        }
        paramView = null;
      }
      i1 = 0;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      d();
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i1 == 1) || (i1 == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount() - 1)
    {
      if (this.jdField_b_of_type_Int != 2) {
        break label80;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "C2C", "gift_exp", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      a(paramInt);
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageSelected(paramInt);
      }
      return;
      label80:
      if (this.jdField_b_of_type_Int == 6) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "discuss_grp", "gift_exp", 0, 0, "", "", "", "");
      } else if (this.jdField_b_of_type_Int == 7) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "temp_c2c", "gift_exp", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void setPagerChangedListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != super.getVisibility()) {}
    for (int i1 = 1;; i1 = 0)
    {
      super.setVisibility(paramInt);
      if (paramInt != 0) {
        break;
      }
      c();
      if (i1 != 0) {
        a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
      }
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanel
 * JD-Core Version:    0.7.0.1
 */
import QQWalletPay.ReqCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.dataline.activities.LiteActivity;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.av.VideoController;
import com.tencent.av.share.ShareChat;
import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.playvideo.entrance.DiscoverBannerPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qrcode.activity.QRJumpActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceScanner;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.activity.SearchMightKnowFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TranslucentTRansferFragment;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingFragment;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.qwallet.WXMiniProgramHelper;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.config.business.QQComicConfBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.JumpAction.1;
import com.tencent.mobileqq.utils.JumpAction.11;
import com.tencent.mobileqq.utils.JumpAction.12;
import com.tencent.mobileqq.utils.JumpAction.14;
import com.tencent.mobileqq.utils.JumpAction.16;
import com.tencent.mobileqq.utils.JumpAction.17;
import com.tencent.mobileqq.utils.JumpAction.18;
import com.tencent.mobileqq.utils.JumpAction.2;
import com.tencent.mobileqq.utils.JumpAction.20;
import com.tencent.mobileqq.utils.JumpAction.4;
import com.tencent.mobileqq.utils.JumpAction.5;
import com.tencent.mobileqq.utils.JumpAction.6;
import com.tencent.mobileqq.utils.JumpAction.7;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AgentActivity;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.agent.BindTroopPreVerificationFragment;
import com.tencent.open.agent.JoinTroopPreVerificationFragment;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qidian.QidianWebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.QQDeviceInfo;
import com.tencent.util.VersionUtils;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.comic.VipComicJumpActivity;
import cooperation.hce.HcePluginInstallActivity;
import cooperation.plugin.PluginInfo;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.util.QzoneAuthorizeConfig;
import cooperation.troop.NearbyVideoChatProxyActivity;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageProxyActivity;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bheh
{
  public static int a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.mobileqq" };
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public adnm a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public Context a;
  protected Handler a;
  private aobw jdField_a_of_type_Aobw;
  public bheu a;
  private bhev jdField_a_of_type_Bhev;
  public bisl a;
  bjyh jdField_a_of_type_Bjyh = new bhei(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public final QQAppInterface a;
  public BusinessInfoCheckUpdate.AppInfo a;
  public String a;
  public HashMap<String, String> a;
  public Hashtable<String, Long> a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public String f;
  public boolean f;
  public String g;
  public boolean g;
  public String h;
  public boolean h;
  public String i;
  public boolean i;
  public String j;
  public boolean j;
  public String k;
  private boolean k;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public bheh(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bheu = new bheu(this, this);
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_Adnm = new bhen(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private boolean C()
  {
    try
    {
      i1 = Integer.parseInt(this.jdField_c_of_type_JavaLangString);
      switch (i1)
      {
      default: 
        return true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("JumpAction", 1, "handleQfavHelperAction error:" + localNumberFormatException.getMessage());
        int i1 = -1;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690676));
      return bmaf.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, -1, false);
    }
  }
  
  private boolean D()
  {
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    if ((TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))))
    {
      QLog.e("JumpAction", 1, "identification with illegal params");
      return true;
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"), "");
    avpw.a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean E()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("mini_appid")) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("fakeUrl"))) {}
    for (int i1 = 1; i1 != 0; i1 = 0) {
      return com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    return com.tencent.mobileqq.mini.sdk.MiniAppLauncher.launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, 2016, null, null);
  }
  
  private boolean F()
  {
    String str2 = null;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("app")) {}
    for (String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app");; str1 = null)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("type")) {
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
      }
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        ((alcz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, str1, str2);
      }
      return true;
    }
  }
  
  private boolean G()
  {
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("entry")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("entry");
    }
    for (;;)
    {
      String str2;
      label56:
      long l2;
      long l1;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("seq"))
      {
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("seq");
        l2 = 0L;
        l1 = l2;
        if (TextUtils.isEmpty(str2)) {}
      }
      try
      {
        l1 = Long.valueOf(str2).longValue();
      }
      catch (Exception localException1)
      {
        try
        {
          VACDReportUtil.a(l1, "", "jumpParse", null, 0, null);
          for (;;)
          {
            label89:
            str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
            if (("1".equals(str2)) || ("2".equals(str2)) || ("3".equals(str2)) || ("4".equals(str2)) || ("5".equals(str2)) || ("6".equals(str2)) || ("7".equals(str2)) || ("9".equals(str2)) || ("10".equals(str2)) || ("11".equals(str2)))
            {
              Bundle localBundle = new Bundle();
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tokenid")) {
                localBundle.putString("tokenid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("tokenid"));
              }
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("data")) {
                localBundle.putString("data", (String)this.jdField_a_of_type_JavaUtilHashMap.get("data"));
              }
              return a(str2, str1, l1, localBundle);
              str1 = null;
              break;
              str2 = null;
              break label56;
            }
            if ("8".equals(str2)) {
              return a(str2, str1, l1);
            }
            return false;
            localException1 = localException1;
            l1 = l2;
          }
        }
        catch (Exception localException2)
        {
          break label89;
        }
      }
    }
  }
  
  private boolean H()
  {
    if (this.jdField_c_of_type_JavaLangString.equals("publish")) {
      return bj();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("writemood")) {
      return bn();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("to_publish_queue")) {
      return bo();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("open_homepage")) {
      return bp();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("groupalbum")) {
      return be();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("to_friend_feeds")) {
      return h();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("to_qzone_dialog")) {
      return bf();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("to_redpocket_share")) {
      return bk();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("open_redpocket")) {
      return bl();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("qzone_schema")) {
      return bg();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("shareLogToQQ")) {
      return bm();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("qzone_publicaccount")) {
      return bh();
    }
    return false;
  }
  
  private boolean I()
  {
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))) {
      l = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    }
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))) {
      m = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
    }
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openkey"))) {
      o = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openkey");
    }
    if ("true".equals(this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"))) {
      return aR();
    }
    return aV();
  }
  
  private boolean J()
  {
    if (this.jdField_c_of_type_JavaLangString.equals("emoji")) {
      EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 7);
    }
    do
    {
      return true;
      if (this.jdField_c_of_type_JavaLangString.equals("emoji_detail"))
      {
        EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4, b("detailid"));
        return true;
      }
      if (this.jdField_c_of_type_JavaLangString.equals("emoji_author"))
      {
        EmojiHomeUiPlugin.openEmojiAuthorPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 5, b("authorid"));
        return true;
      }
      if (this.jdField_c_of_type_JavaLangString.equals("bubble"))
      {
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, bhnp.a(this.jdField_a_of_type_AndroidContentContext, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, null, false, -1);
        return true;
      }
      if (this.jdField_c_of_type_JavaLangString.equals("theme"))
      {
        if ((!BaseApplicationImpl.IS_SUPPORT_THEME) || (!bhbx.a())) {
          break label632;
        }
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, bhnp.a(this.jdField_a_of_type_AndroidContentContext, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, null, false, -1);
        return true;
      }
      if (this.jdField_c_of_type_JavaLangString.equals("font"))
      {
        if ((!((gb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).c()) || (!bhbx.a())) {
          break label632;
        }
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, bhnp.a(this.jdField_a_of_type_AndroidContentContext, "font", ""), 4096L, null, false, -1);
        return true;
      }
      if (!this.jdField_c_of_type_JavaLangString.equals("pendant")) {
        break;
      }
    } while (!bhbx.a());
    bhcs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    return true;
    if (this.jdField_c_of_type_JavaLangString.equals("individuation"))
    {
      VasWebviewUtil.openIndividuationIndex(this.jdField_a_of_type_AndroidContentContext);
      return true;
    }
    Intent localIntent;
    Object localObject1;
    int i1;
    int i2;
    if (this.jdField_c_of_type_JavaLangString.equals("apollo_store"))
    {
      localIntent = new Intent();
      localObject1 = this.jdField_a_of_type_JavaLangString.split("\\?");
      if (localObject1.length < 2) {
        break label634;
      }
      localIntent.putExtra("extra_key_url_append", localObject1[1]);
      if (localObject1[1] == null) {
        break label634;
      }
      if (localObject1[1].contains("tab=game_center"))
      {
        i1 = 0;
        i2 = 1;
        localObject1 = null;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, new Object[] { "apollo_store url:", localObject1 });
      }
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = anka.u;
      }
      if (i2 != 0) {
        ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label630;
        }
        localObject1 = (amme)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_clk", ((amme)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()), 0, new String[] { "0" });
        return true;
        if (localObject1[1].contains("tab=other_url&url="))
        {
          localObject1 = URLDecoder.decode(localObject1[1].substring(localObject1[1].indexOf("tab=other_url&url=") + "tab=other_url&url=".length()));
          i2 = 0;
          i1 = 1;
          break;
        }
        localObject2 = new HashMap();
        wyt.a(localObject1[1], (HashMap)localObject2);
        localObject1 = amme.b((String)((HashMap)localObject2).get("tab"), true);
        i2 = 0;
        i1 = 0;
        break;
        if (i1 != 0) {
          ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2);
        } else {
          ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext, localIntent, null, (String)localObject2, null);
        }
      }
      label630:
      break;
      label632:
      return false;
      label634:
      i1 = 0;
      i2 = 0;
      localObject1 = null;
    }
  }
  
  private boolean K()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "enter jiankang");
    }
    ThreadManager.post(new JumpAction.2(this), 5, null, true);
    if ((Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor")).getDefaultSensor(19) != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
      ((bhwz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SPORT_MANAGER)).a("jump action");
    }
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if ((localObject2 == null) || ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://"))) || ((!nwo.b((String)localObject2).equalsIgnoreCase("qq.com")) && (!nwo.b((String)localObject2).equalsIgnoreCase("myun.tenpay.com")) && (!nwo.b((String)localObject2).equalsIgnoreCase("tenpay.com")) && (!nwo.b((String)localObject2).equalsIgnoreCase("wanggou.com")))) {
      return false;
    }
    Object localObject1 = localObject2;
    if (((String)localObject2).indexOf("?") <= 0) {
      localObject1 = (String)localObject2 + "?";
    }
    localObject2 = new StringBuilder((String)localObject1);
    StringBuilder localStringBuilder = ((StringBuilder)localObject2).append("&client=androidQQ").append("&uin=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("&version=").append("8.4.10.4875").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&density=").append(ThemeUtil.getThemeDensity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())).append("&platformId=2").append("&_lv=0").append("&hasRedDot=");
    if (this.jdField_d_of_type_Boolean) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      localStringBuilder.append((String)localObject1).append("&adtag=mvip.gongneng.anroid.health.nativet");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      ((StringBuilder)localObject2).append("&lati=").append(((SharedPreferences)localObject1).getFloat("search_lbs_latitude", 0.0F));
      ((StringBuilder)localObject2).append("&logi=").append(((SharedPreferences)localObject1).getFloat("search_lbs_logitude", 0.0F));
      int i1 = NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      ((StringBuilder)localObject2).append("&netType=" + i1);
      localObject1 = DeviceInfoUtil.getDeviceModel();
      ((StringBuilder)localObject2).append("&model=" + (String)localObject1);
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString());
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
  }
  
  private boolean L()
  {
    boolean bool = false;
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sourceUrl");
    Object localObject;
    if (this.jdField_c_of_type_JavaLangString.equals("web")) {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
    }
    try
    {
      localObject = URLDecoder.decode((String)localObject);
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class).putExtra("url", (String)localObject);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hideRightButton", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      if ((str1 != null) && (str2 != null)) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_tribe", "", "url", "visit", 0, 1, 0, str1, nwo.b(str2, new String[0]), "", "");
      }
      bool = true;
    }
    catch (Exception localException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e("JumpAction", 4, "URLDecoder.decode error");
    }
    return bool;
    return false;
  }
  
  private boolean M()
  {
    if (this.jdField_c_of_type_JavaLangString.equals("open")) {
      return t();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("report")) {
      return u();
    }
    if (this.jdField_c_of_type_JavaLangString.equals("reportrealtime")) {
      return v();
    }
    Object localObject1;
    int i1;
    Object localObject2;
    if (this.jdField_c_of_type_JavaLangString.equals("apenalbum"))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("articleid");
      i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin_type"));
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountImageCollectionMainActivity.class);
        ((Intent)localObject2).putExtra("source_for_report", i1);
        vuq.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, (String)localObject1);
      }
    }
    for (;;)
    {
      return false;
      if (this.jdField_c_of_type_JavaLangString.equals("multivideo")) {
        return w();
      }
      if (this.jdField_c_of_type_JavaLangString.equals("openatlas"))
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("rowkey")) {}
        for (localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rowkey"); TextUtils.isEmpty((CharSequence)localObject1); localObject1 = "")
        {
          if (QLog.isColorLevel()) {
            QLog.e("JumpAction", 2, "rowKey is Empty");
          }
          return false;
        }
        label263:
        String str1;
        label291:
        String str2;
        label319:
        String str3;
        label347:
        label375:
        String str4;
        label403:
        String str5;
        label431:
        label459:
        String str6;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("picindex"))
        {
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("picindex");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("source")) {
            break label627;
          }
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("enteranimationstyle")) {
            break label635;
          }
          str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enteranimationstyle");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("hideTopic")) {
            break label643;
          }
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hideTopic");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("commentId")) {
            break label646;
          }
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("commentId");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("subCommentId")) {
            break label653;
          }
          str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("subCommentId");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("albumStyle")) {
            break label660;
          }
          str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("albumStyle");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("jumpCommentType")) {
            break label663;
          }
          str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jumpCommentType");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("isAwesome")) {
            break label670;
          }
          str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isAwesome");
        }
        for (;;)
        {
          for (;;)
          {
            int i2;
            label643:
            label646:
            label653:
            label660:
            label663:
            label670:
            try
            {
              Integer.valueOf((String)localObject2).intValue();
              i1 = Integer.valueOf(str1).intValue();
            }
            catch (Exception localException1)
            {
              label627:
              label635:
              i1 = 0;
            }
            try
            {
              Integer.valueOf(str2).intValue();
              i2 = i1;
              if (!Boolean.valueOf(bmhv.v(pkh.a())).booleanValue()) {
                break label703;
              }
              localObject1 = "https://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&rowkey=" + (String)localObject1 + "&album_source=" + i2 + "&isAwesome=" + str6 + "&commentId=" + str3 + "&subCommentId=" + str4 + "&jumpCommentType=" + str5;
              tto.a(this.jdField_a_of_type_AndroidContentContext, null, (String)localObject1, null);
            }
            catch (Exception localException2)
            {
              label681:
              break label681;
            }
          }
          localObject2 = "0";
          break label263;
          str1 = "0";
          break label291;
          str2 = "0";
          break label319;
          break label347;
          str3 = "";
          break label375;
          str4 = "";
          break label403;
          break label431;
          str5 = "";
          break label459;
          str6 = "";
          continue;
          i2 = i1;
          if (QLog.isColorLevel())
          {
            QLog.e("JumpAction", 2, "Parameter error");
            i2 = i1;
          }
        }
        label703:
        if (QLog.isColorLevel()) {
          QLog.e("JumpAction", 2, "jumpToGallery failed: atlas has undercarriage");
        }
      }
      else
      {
        if (this.jdField_c_of_type_JavaLangString.equals("selfpage"))
        {
          osg.a(this.jdField_a_of_type_AndroidContentContext, false);
          return true;
        }
        if ("showugceditor".equals(this.jdField_c_of_type_JavaLangString))
        {
          k();
        }
        else if ("openarticle".equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject1 = osg.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
          if ((this.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)) {
            ((FastWebActivity)this.jdField_a_of_type_AndroidContentContext).a((Intent)localObject1);
          } else {
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          }
        }
      }
    }
  }
  
  private boolean N()
  {
    Object localObject1;
    Object localObject2;
    if ("opendetail".equals(this.jdField_c_of_type_JavaLangString))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("key_launch_time", System.currentTimeMillis());
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      if ((localObject2 == null) || ("".equals(localObject2)) || (((String)localObject2).length() < 5)) {
        return false;
      }
    }
    try
    {
      ((Bundle)localObject1).putLong("key_current_feeduin", Long.valueOf((String)localObject2).longValue());
      ((Bundle)localObject1).putString("key_current_feed_cellid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("cellid"));
      ((Bundle)localObject1).putInt("key_request_from", 3);
      ((Bundle)localObject1).putInt("key_weishi_entrance_type", 19);
      ((Bundle)localObject1).putInt("key_request_business_type", 8);
      a((Bundle)localObject1);
      for (;;)
      {
        return true;
        if (!"takevideo".equals(this.jdField_c_of_type_JavaLangString)) {
          continue;
        }
        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("widgetid");
        String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("activity_id");
        String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shareto");
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cmode");
        String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("widgetinfo");
        Bundle localBundle = new Bundle();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localBundle.putString("KEY_CURRENT_SELECT_ID", (String)localObject2);
        }
        localBundle = bpnk.a(localBundle, str4);
        bnrh.b("JumpAction", "【widgetid】:" + (String)localObject2 + "【" + "from" + "】:" + str1 + "【" + "activity_id" + "】:" + str2 + "【" + "shareto" + "】:" + str3 + "【" + "cmode" + "】:" + (String)localObject1 + "【" + "widgetinfo" + "】:" + str4);
        try
        {
          i1 = bnlb.a(str1).a();
          a(localBundle, i1);
          if (bnlb.d(i1)) {
            localObject1 = "cameraAndPlay";
          }
        }
        catch (Exception localException1)
        {
          try
          {
            int i1;
            localBundle.putInt("VIDEO_STORY_FROM_TYPE", i1);
            localObject2 = localObject1;
            label446:
            if (TextUtils.isEmpty(str2)) {}
          }
          catch (Exception localException5)
          {
            label464:
            label483:
            label502:
            break label502;
          }
          try
          {
            localBundle.putString("VIDEO_STORY_ACTIVITY_ID", str2);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {}
          }
          catch (Exception localException1)
          {
            try
            {
              localBundle.putInt("AECAMERA_MODE", bnlb.a((String)localObject2));
              bnlf.a((Activity)this.jdField_a_of_type_AndroidContentContext, 120, localBundle);
              continue;
              localException4 = localException4;
              localObject2 = localObject1;
              if (!QLog.isColorLevel()) {
                break label446;
              }
              QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_FROM_TYPE format: " + localException4.getMessage());
              localObject2 = localObject1;
              break label446;
              localException1 = localException1;
              if (!QLog.isColorLevel()) {
                break label464;
              }
              QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_ACTIVITY_ID format: " + localException1.getMessage());
            }
            catch (Exception localException2)
            {
              if (!QLog.isColorLevel()) {
                break label483;
              }
              QLog.e("JumpAction", 2, "Invalid AECAMERA_MODE format: " + localException2.getMessage());
              break label483;
            }
          }
        }
      }
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
  }
  
  private boolean O()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HcePluginInstallActivity.class);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean P()
  {
    WXMiniProgramHelper.a().a(this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  private boolean Q()
  {
    int i1 = 0;
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694256, 1).a();
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("params")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");
    }
    try
    {
      String str2;
      long[] arrayOfLong;
      for (;;)
      {
        localObject = new JSONObject(new String(bhcu.decode(str1, 0)));
        str2 = ((JSONObject)localObject).optString("keyword");
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("groupmask");
        arrayOfLong = new long[localJSONArray.length()];
        while (i1 < localJSONArray.length())
        {
          arrayOfLong[i1] = localJSONArray.optLong(i1);
          i1 += 1;
        }
        str1 = "";
      }
      Object localObject = ((JSONObject)localObject).optString("groupname");
      ActiveEntitySearchActivity.a(this.jdField_a_of_type_AndroidContentContext, str2, (String)localObject, arrayOfLong);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("JumpActionQ.uniteSearch.", 2, "参数解析成json错误.  params=" + str1);
      }
    }
    return true;
  }
  
  private boolean R()
  {
    int i2 = 0;
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694256, 1).a();
      return false;
    }
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("invitorId");
    int i1 = 10;
    for (;;)
    {
      try
      {
        i3 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("roomNum"));
        i1 = i3;
      }
      catch (Exception localException3)
      {
        int i3;
        long l1;
        long l2;
        label111:
        continue;
      }
      try
      {
        i3 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("zoneId"));
        i2 = i3;
      }
      catch (Exception localException2) {}
    }
    l1 = -1L;
    try
    {
      l2 = Long.parseLong((String)this.jdField_a_of_type_JavaUtilHashMap.get("gc"));
      l1 = l2;
    }
    catch (Exception localException1)
    {
      break label111;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, GameRoomTransActivity.class);
      ((Intent)localObject).putExtra("roomNum", i1);
      ((Intent)localObject).putExtra("action", 3);
      ((Intent)localObject).putExtra("zoneId", i2);
      ((Intent)localObject).putExtra("gc", l1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
    for (;;)
    {
      return true;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, GameRoomTransActivity.class);
      localIntent.putExtra("inviteId", (String)localObject);
      localIntent.putExtra("roomNum", i1);
      localIntent.putExtra("zoneId", i2);
      localIntent.putExtra("action", 2);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  private boolean S()
  {
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694256, 1).a();
      return false;
    }
    int i1 = 10;
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("roomNum"));
        i1 = i2;
      }
      catch (Exception localException2)
      {
        int i2;
        Intent localIntent;
        continue;
      }
      try
      {
        i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("zoneId"));
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, GameRoomTransActivity.class);
        localIntent.putExtra("roomNum", i1);
        localIntent.putExtra("zoneId", i2);
        localIntent.putExtra("action", 1);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return true;
      }
      catch (Exception localException1)
      {
        i2 = 0;
      }
    }
  }
  
  private boolean T()
  {
    boolean bool = ((Boolean)((wjl)wjs.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("token");
    if (!TextUtils.isEmpty(str)) {
      wyt.a(this.jdField_a_of_type_AndroidContentContext, str, new bher(this), null);
    }
    for (;;)
    {
      return true;
      if (TextUtils.equals(this.jdField_c_of_type_JavaLangString, "publish"))
      {
        U();
      }
      else
      {
        if (bool)
        {
          this.jdField_c_of_type_JavaLangString = "open";
          wyt.a(this.jdField_a_of_type_JavaUtilHashMap);
        }
        U();
      }
    }
  }
  
  private boolean U()
  {
    if ((QzoneConfig.getInstance().getConfig("qqstoryvideo", "jump_hyws_scheme_enable", 0) == 0) && (BaseApplicationImpl.getContext() != null))
    {
      ThreadManager.getUIHandler().post(new JumpAction.4(this));
      return false;
    }
    if ((((wms)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).jdField_a_of_type_Boolean) && (!"open".equals(this.jdField_c_of_type_JavaLangString)) && (!"openTag".equals(this.jdField_c_of_type_JavaLangString)) && (!"openSquare".equals(this.jdField_c_of_type_JavaLangString)) && (!"publish".equals(this.jdField_c_of_type_JavaLangString))) {
      return bI();
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page");
    String str1 = str2;
    if (String.valueOf(2).equals(str2))
    {
      wms localwms = (wms)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER);
      str1 = str2;
      if (localwms != null)
      {
        str1 = str2;
        if (!localwms.jdField_a_of_type_Boolean)
        {
          str1 = String.valueOf(0);
          this.jdField_a_of_type_JavaUtilHashMap.put("one_page", str1);
        }
      }
    }
    if ("0".equals(str1)) {
      return bL();
    }
    if ("open".equals(this.jdField_c_of_type_JavaLangString)) {
      return bL();
    }
    return bI();
  }
  
  private boolean V()
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      if (TextUtils.isEmpty(arng.a().h())) {}
      for (String str = "https://docs.qq.com/desktop/m/index.html?_from=1";; str = arng.a().h())
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent.putExtra("url", str));
        break;
      }
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean W()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    localIntent.putExtra("fragment_id", 1);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
    localIntent.putExtra("from", str);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if ("10003".equals(str)) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077F6", "0X80077F6", 0, 0, "", "", "", "");
    }
    do
    {
      return true;
      if ("10004".equals(str))
      {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077F7", "0X80077F7", 0, 0, "", "", "", "");
        return true;
      }
    } while (!"10009".equals(str));
    QLog.i("JumpAction", 1, "jumpaction from gotoConversaton e = ");
    return true;
  }
  
  private boolean X()
  {
    long l4 = System.currentTimeMillis();
    boolean bool2 = apbb.a().a();
    apbf localapbf = (apbf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AR_CLOBAL_CONFIG_MANAGER);
    Object localObject1;
    if (localapbf != null)
    {
      localObject1 = localapbf.a();
      QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is config info is " + localObject1);
      if (!localapbf.b()) {}
    }
    label134:
    label1163:
    label1171:
    label1176:
    for (boolean bool1 = true;; bool1 = false)
    {
      String str;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      }
      label800:
      label1196:
      for (;;)
      {
        Object localObject2;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("args"))
        {
          localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("args");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("disablecloud")) {
            break label513;
          }
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("disablecloud");
        }
        label586:
        label848:
        try
        {
          for (;;)
          {
            i1 = Integer.parseInt((String)localObject2);
            if ((i1 == 1) || (i1 == 0)) {
              break label1392;
            }
            i1 = 1;
            QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is " + bool2 + ",effectinfo is " + bool1 + ",from url is " + str + ",args is" + (String)localObject1 + ",cloudSwitch is " + i1);
            if ((!bool2) || (!bool1)) {
              break label1196;
            }
            localIntent = new Intent();
            localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, ScannerActivity.class);
            localIntent.putExtra("from", "web-ar");
            localIntent.addFlags(67108864);
            localIntent.addFlags(268435456);
            localIntent.addFlags(65536);
            localIntent.addFlags(536870912);
            localIntent.putExtra("click_time", System.currentTimeMillis());
            localIntent.putExtra("web_url_switch", i1);
            localIntent.putExtra("jump_from_web", true);
            if (!QLog.isDevelopLevel()) {
              break label619;
            }
            localObject2 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
            for (localObject1 = "";; localObject1 = (String)localObject1 + (String)((Map.Entry)localObject4).getKey() + "[" + ((String)((Map.Entry)localObject4).getValue()).substring(0, 20) + "]\n")
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label586;
              }
              localObject4 = (Map.Entry)((Iterator)localObject2).next();
              if ((((Map.Entry)localObject4).getValue() == null) || (((String)((Map.Entry)localObject4).getValue()).length() <= 20)) {
                break;
              }
            }
            str = "";
            break;
            localObject1 = "";
            break label134;
            localObject2 = "0";
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label619:
          label876:
          label1392:
          for (;;)
          {
            Intent localIntent;
            int i1 = 0;
            continue;
            localObject1 = (String)localObject1 + (String)((Map.Entry)localObject4).getKey() + "[" + (String)((Map.Entry)localObject4).getValue() + "]\n";
            continue;
            QLog.w("JumpAction", 1, "gotoScannerActivity, \n" + (String)localObject1 + "]");
            Object localObject4 = new Bundle();
            localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionType");
            long l2 = 1L;
            long l1 = l2;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
            try
            {
              l1 = Long.valueOf((String)localObject1).longValue();
              long l3 = 0L;
              localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("RecoglizeMask");
              l2 = l3;
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
              try
              {
                l2 = Long.valueOf((String)localObject1).longValue();
                Object localObject3;
                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("H5Source"))
                {
                  localObject1 = "";
                  bool1 = true;
                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("enableQR")) {
                    break label1143;
                  }
                  localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enableQR");
                }
                label754:
                label1143:
                try
                {
                  l3 = Long.valueOf((String)localObject3).longValue();
                  if (l3 != 0L) {
                    break label1151;
                  }
                  bool1 = true;
                }
                catch (Exception localException3)
                {
                  label1016:
                  label1151:
                  break label774;
                }
                ((Bundle)localObject4).putLong("PromotionType", l1);
                ((Bundle)localObject4).putLong("RecoglizeMask", l2);
                if (i1 != 0)
                {
                  bool2 = true;
                  ((Bundle)localObject4).putBoolean("disablecloud", bool2);
                  ((Bundle)localObject4).putString("H5Source", (String)localObject1);
                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("version")) {
                    break label1163;
                  }
                  localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
                  ((Bundle)localObject4).putString("version", (String)localObject1);
                  ((Bundle)localObject4).putBoolean("enableQR", bool1);
                  if (l1 == 0L) {
                    break label1171;
                  }
                  i1 = 1;
                  if ((i1 != 0) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("PromotionDescription"))) {
                    ((Bundle)localObject4).putString("PromotionDescription", (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionDescription"));
                  }
                  ((Bundle)localObject4).putBoolean("is_from_h5_entry", true);
                  localIntent.putExtra("web_invoke_params", (Bundle)localObject4);
                  AudioHelper.a("JumpAction", (Bundle)localObject4);
                  QLog.w("JumpAction", 1, "PromotionInfo test , \n" + ((Bundle)localObject4).toString() + "]");
                  if (localapbf != null)
                  {
                    if ((localapbf.a() != null) && (!TextUtils.isEmpty(localapbf.a().jdField_e_of_type_JavaLangString))) {
                      break label1176;
                    }
                    localIntent.putExtra("icon_text", "QQ-AR");
                    if ((localapbf.a() != null) && (localapbf.a().jdField_c_of_type_JavaLangString != null)) {
                      localIntent.putExtra("icon_url", localapbf.a().jdField_c_of_type_JavaLangString);
                    }
                  }
                  this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
                  bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "0", str, "", "");
                }
                for (;;)
                {
                  QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity cost time is " + (System.currentTimeMillis() - l4));
                  return true;
                  localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("H5Source");
                  break;
                  localObject3 = "0";
                  break label754;
                  bool1 = false;
                  break label774;
                  bool2 = false;
                  break label800;
                  localObject1 = "0";
                  break label848;
                  i1 = 0;
                  break label876;
                  localIntent.putExtra("icon_text", localapbf.a().jdField_e_of_type_JavaLangString);
                  break label1016;
                  localObject3 = new StringBuilder("https://ti.qq.com/ar/help/error.html?_wv=3");
                  ((StringBuilder)localObject3).append("&from=");
                  ((StringBuilder)localObject3).append(str);
                  ((StringBuilder)localObject3).append("&args=");
                  new StringBuffer();
                  ((StringBuilder)localObject3).append(agtf.a((String)localObject1));
                  QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity QQBrowserActivity cost time is " + ((StringBuilder)localObject3).toString());
                  localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                  ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
                  ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject3).toString());
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                  bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "1", str, "", "");
                }
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  l2 = l3;
                }
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                l1 = l2;
              }
            }
          }
        }
      }
    }
  }
  
  private boolean Y()
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("kSrouce")) {
          continue;
        }
        localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        i1 = Integer.parseInt((String)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.i("JumpAction", 1, "gotoBindNumberActivity from value format wrong");
        int i1 = 22;
        continue;
      }
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, BindNumberActivity.class);
      ((Intent)localObject).putExtra("kSrouce", i1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
      localObject = "22";
    }
  }
  
  private boolean Z()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("interest_type")) {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "ChooseInterestTagActivity->type = null");
      }
    }
    do
    {
      for (;;)
      {
        return false;
        Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("interest_type");
        String str;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from"))
        {
          str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "ChooseInterestTagActivity->type = " + (String)localObject);
          }
        }
        try
        {
          i1 = Integer.valueOf((String)localObject).intValue();
          if ("interesttag_selector".equals(this.jdField_c_of_type_JavaLangString))
          {
            try
            {
              localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, ChooseInterestTagActivity.class);
              ((Intent)localObject).putExtra("is_from_judge", true);
              ((Intent)localObject).putExtra("interest_tag_type", i1);
              ((Intent)localObject).putExtra("from_where", "web_to_choose_tag");
              if ("10002".equals(str)) {
                ((Intent)localObject).addFlags(268435456);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return true;
            }
            catch (Exception localException1) {}
            str = "";
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i1 = 0;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpAction", 2, "", localException1);
    return false;
  }
  
  private int a()
  {
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("env"))) {
      return Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("env")).intValue();
    }
    return 0;
  }
  
  private Intent a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtra("thridparty_prepare_mini_app", true);
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    localIntent.putExtra("fragment_id", 1);
    return localIntent;
  }
  
  private Class a()
  {
    int i1 = BaseApplicationImpl.getApplication().appActivities.size() - 1;
    while (i1 >= 0)
    {
      Object localObject = (WeakReference)BaseApplicationImpl.getApplication().appActivities.get(i1);
      if (localObject != null) {
        localObject = (AppActivity)((WeakReference)localObject).get();
      }
      while (localObject != null)
      {
        localObject = ((Activity)localObject).getLocalClassName();
        if ("activity.RegisterPersonalInfoActivity".equals(localObject))
        {
          return RegisterPersonalInfoActivity.class;
          localObject = null;
        }
        else
        {
          if ("activity.RegisterVerifyCodeActivity".equals(localObject)) {
            return RegisterVerifyCodeActivity.class;
          }
          if ("activity.RegisterByNicknameAndPwdActivity".equals(localObject)) {
            return RegisterByNicknameAndPwdActivity.class;
          }
          if ("activity.RegisterSendUpSms".equals(localObject)) {
            return RegisterSendUpSms.class;
          }
          if ("activity.RegisterPhoneNumActivity".equals(localObject)) {
            return RegisterPhoneNumActivity.class;
          }
        }
      }
      i1 -= 1;
    }
    return RegisterPhoneNumActivity.class;
  }
  
  private String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("i="))) {
      return null;
    }
    int i3 = paramString.indexOf("i=");
    int i2 = paramString.substring(i3).indexOf('&');
    int i1 = i2;
    if (i2 <= 0) {
      i1 = paramString.length() - i3;
    }
    return paramString.substring("i=".length() + i3, i1 + i3);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return paramString1;
    }
    try
    {
      String str = URLEncoder.encode(paramString3, "UTF-8");
      paramString3 = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    if (paramString1.contains(paramString2)) {
      return paramString1.replace(paramString2, paramString3);
    }
    return paramString1.replace(paramString2.toUpperCase(), paramString3);
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setData(Uri.parse("midas://open_modify_status?status=" + paramInt));
    if (this.jdField_a_of_type_AndroidContentContext.getPackageManager().queryIntentActivities(localIntent, 0).size() > 0) {
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).finish();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("qidian")) {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("qidian");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        i1 = Integer.valueOf(str1).intValue();
        if (i1 == 1)
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("jsondata"))
          {
            str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jsondata");
            ((bjyi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(str1, paramInt1, paramInt2);
          }
        }
        else
        {
          return;
          str1 = "";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i1 = 0;
          continue;
          String str2 = "";
        }
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "wrapper Intent failed intent is null or redTouchInfo is Empty");
      }
      return;
    }
    paramIntent.putExtra("redTouch", this.jdField_h_of_type_JavaLangString);
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "wpaParamsParse---Start");
    }
    int i1;
    if (this.jdField_a_of_type_JavaUtilHashMap.get("paramencrypted_type") == null)
    {
      i1 = 0;
      paramIntent.putExtra("from3rdApp", true);
      if (i1 != 1) {
        break label237;
      }
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "params must be decrypted");
        }
        paramString = bhcu.decode(new Cryptor().decrypt(HexUtil.hexStr2Bytes(paramString), "Hf7K(s*js12LiskW".getBytes()), 0);
        if (paramString == null) {
          break label290;
        }
        paramString = new JSONObject(new String(paramString));
        boolean bool1 = bool2;
        if (paramString.has("layout"))
        {
          bool1 = bool2;
          if (paramString.getString("layout") != null) {
            bool1 = true;
          }
        }
        paramIntent.putExtra("showFirstStructMsg", bool1);
        if (paramString != null)
        {
          paramString = ChatActivityUtils.a(paramString);
          paramIntent.putExtra("stuctmsg_bytes", paramString);
          if ((paramString != null) && (i1 == 1)) {
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), "0X8004B50", "0X8004B50", 0, 0, "", "", "", "");
          }
        }
        return;
      }
      catch (JSONException paramIntent)
      {
        label237:
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.e("JumpAction", 4, "wpaParamsParse---JSONException");
        return;
      }
      i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("paramencrypted_type"));
      break;
      paramIntent.putExtra("fromSencondhandCommunity", true);
      paramString = new JSONObject(paramString);
      paramIntent.putExtra("gid", paramString.getString("gid"));
      continue;
      label290:
      paramString = null;
    }
  }
  
  @Deprecated
  public static void a(Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("key_launch_time");
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("plugin_tag", 1, "call jumpToVideoStoryLayer timedelay=" + (l2 - l1));
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
    localIntent.setFlags(268435456);
    localIntent.putExtras(paramBundle);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    HashSet localHashSet1 = new HashSet();
    localHashSet1.add(Integer.valueOf(bnlb.a.a()));
    localHashSet1.add(Integer.valueOf(bnlb.n.a()));
    localHashSet1.add(Integer.valueOf(bnlb.t.a()));
    localHashSet1.add(Integer.valueOf(bnlb.w.a()));
    localHashSet1.add(Integer.valueOf(bnlb.b.a()));
    localHashSet1.add(Integer.valueOf(bnlb.u.a()));
    localHashSet1.add(Integer.valueOf(bnlb.c.a()));
    HashSet localHashSet2 = new HashSet();
    localHashSet2.add(Integer.valueOf(bnlb.g.a()));
    localHashSet2.add(Integer.valueOf(bnlb.q.a()));
    localHashSet2.add(Integer.valueOf(bnlb.r.a()));
    localHashSet2.add(Integer.valueOf(bnlb.o.a()));
    localHashSet2.add(Integer.valueOf(bnlb.s.a()));
    localHashSet2.add(Integer.valueOf(bnlb.v.a()));
    if (localHashSet1.contains(Integer.valueOf(paramInt)))
    {
      paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
      return;
    }
    if (localHashSet2.contains(Integer.valueOf(paramInt)))
    {
      paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 2);
      return;
    }
    paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
  }
  
  private void a(String paramString)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    if ("app".equals(str)) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if ("web".equals(str))
      {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
        return;
      }
    } while (!"scan".equals(str));
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Intent paramIntent)
  {
    paramIntent.putExtra("url", paramString1);
    paramIntent.setClassName(paramString2, paramString3);
    paramIntent.addCategory("android.intent.category.LAUNCHER");
    paramIntent.addFlags(268435456);
    paramIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramIntent);
  }
  
  /* Error */
  private boolean a(Intent paramIntent, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ldc_w 1717
    //   7: invokevirtual 1720	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   10: ifne +14 -> 24
    //   13: aload_1
    //   14: ldc_w 1717
    //   17: invokestatic 738	java/lang/System:currentTimeMillis	()J
    //   20: invokevirtual 741	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   23: pop
    //   24: ldc_w 1722
    //   27: aload_0
    //   28: getfield 1724	bheh:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   31: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +467 -> 501
    //   37: iconst_1
    //   38: istore 8
    //   40: aload_1
    //   41: ldc_w 1726
    //   44: iload 8
    //   46: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   49: pop
    //   50: aload_0
    //   51: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   54: ifnull +346 -> 400
    //   57: aload_0
    //   58: getfield 683	bheh:jdField_d_of_type_Boolean	Z
    //   61: ifeq +339 -> 400
    //   64: aload_0
    //   65: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   68: getfield 1734	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   71: invokevirtual 1738	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   74: sipush 769
    //   77: if_icmpne +323 -> 400
    //   80: aload_0
    //   81: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   84: getfield 1741	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   87: invokevirtual 1738	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   90: istore 6
    //   92: aload_0
    //   93: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   96: ldc_w 1743
    //   99: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 45	java/lang/String
    //   105: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: istore 4
    //   110: aload_0
    //   111: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: invokevirtual 689	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   117: ldc_w 1745
    //   120: iconst_0
    //   121: invokevirtual 695	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   124: astore 9
    //   126: aload 9
    //   128: new 113	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 1747
    //   138: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   148: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: iconst_0
    //   155: invokeinterface 1751 3 0
    //   160: istore 7
    //   162: aload 9
    //   164: invokeinterface 1755 1 0
    //   169: new 113	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 1747
    //   179: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   186: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   189: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: iconst_0
    //   196: invokeinterface 1760 3 0
    //   201: invokeinterface 1763 1 0
    //   206: pop
    //   207: aload_0
    //   208: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   211: getfield 1767	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   214: invokevirtual 1771	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   217: ifeq +310 -> 527
    //   220: new 1029	org/json/JSONObject
    //   223: dup
    //   224: aload_0
    //   225: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   228: getfield 1767	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   231: invokevirtual 1773	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   234: invokespecial 1038	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   237: astore 9
    //   239: aload_0
    //   240: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   243: getfield 1777	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   246: invokevirtual 1780	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   249: ifeq +278 -> 527
    //   252: aload_0
    //   253: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   256: getfield 1777	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   259: invokevirtual 1782	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   262: ifne +265 -> 527
    //   265: ldc_w 531
    //   268: aload 9
    //   270: ldc_w 1784
    //   273: invokevirtual 1788	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   276: aload_0
    //   277: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   280: getfield 1777	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   283: iconst_0
    //   284: invokevirtual 1789	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   287: checkcast 45	java/lang/String
    //   290: invokevirtual 1788	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   293: ldc_w 1791
    //   296: invokevirtual 1603	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   299: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: istore 8
    //   304: iload 8
    //   306: ifeq +221 -> 527
    //   309: aload_1
    //   310: ldc_w 1793
    //   313: iload 5
    //   315: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   318: pop
    //   319: aload_1
    //   320: ldc_w 1795
    //   323: iload 6
    //   325: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   328: pop
    //   329: aload_1
    //   330: ldc_w 1797
    //   333: iload 7
    //   335: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   338: pop
    //   339: aload_1
    //   340: ldc_w 1799
    //   343: iload 4
    //   345: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   348: pop
    //   349: aload_0
    //   350: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   353: getfield 1777	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   356: invokevirtual 1780	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   359: ifeq +41 -> 400
    //   362: aload_0
    //   363: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   366: getfield 1777	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   369: invokevirtual 1782	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   372: ifne +28 -> 400
    //   375: aload_1
    //   376: ldc_w 1801
    //   379: new 1436	java/util/ArrayList
    //   382: dup
    //   383: aload_0
    //   384: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   387: getfield 1777	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   390: invokevirtual 1804	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   393: invokespecial 1807	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   396: invokevirtual 1811	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   399: pop
    //   400: aload_1
    //   401: ldc_w 1813
    //   404: aload_0
    //   405: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   408: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   411: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   414: pop
    //   415: aload_1
    //   416: ldc_w 1815
    //   419: iconst_1
    //   420: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   423: pop
    //   424: aload_1
    //   425: ldc_w 1817
    //   428: iconst_1
    //   429: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   432: pop
    //   433: aload_1
    //   434: ldc_w 1819
    //   437: aload_0
    //   438: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   441: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   444: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   447: pop
    //   448: aload_1
    //   449: ldc_w 1821
    //   452: ldc_w 1823
    //   455: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   458: pop
    //   459: aload_0
    //   460: aload_1
    //   461: invokespecial 1824	bheh:a	(Landroid/content/Intent;)V
    //   464: aload_1
    //   465: aload_0
    //   466: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   469: aload_2
    //   470: invokevirtual 1827	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   473: pop
    //   474: aload_0
    //   475: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   478: aload_1
    //   479: invokevirtual 216	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   482: ldc_w 1829
    //   485: aload_3
    //   486: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   489: ifne +44 -> 533
    //   492: aload_0
    //   493: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   496: invokestatic 1835	cooperation/qwallet/plugin/QWalletHelper:preloadQWallet	(Lcom/tencent/common/app/AppInterface;)V
    //   499: iconst_1
    //   500: ireturn
    //   501: iconst_0
    //   502: istore 8
    //   504: goto -464 -> 40
    //   507: astore 9
    //   509: aload 9
    //   511: invokevirtual 1188	java/lang/Exception:printStackTrace	()V
    //   514: iconst_0
    //   515: istore 4
    //   517: goto -407 -> 110
    //   520: astore 9
    //   522: aload 9
    //   524: invokevirtual 1188	java/lang/Exception:printStackTrace	()V
    //   527: iconst_1
    //   528: istore 5
    //   530: goto -221 -> 309
    //   533: new 1837	com/tencent/mobileqq/utils/JumpAction$24
    //   536: dup
    //   537: aload_0
    //   538: invokespecial 1838	com/tencent/mobileqq/utils/JumpAction$24:<init>	(Lbheh;)V
    //   541: iconst_5
    //   542: aconst_null
    //   543: iconst_1
    //   544: invokestatic 583	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   547: iconst_1
    //   548: ireturn
    //   549: astore_1
    //   550: iconst_1
    //   551: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	bheh
    //   0	552	1	paramIntent	Intent
    //   0	552	2	paramString1	String
    //   0	552	3	paramString2	String
    //   108	408	4	i1	int
    //   1	528	5	i2	int
    //   90	234	6	i3	int
    //   160	174	7	i4	int
    //   38	465	8	bool	boolean
    //   124	145	9	localObject	Object
    //   507	3	9	localException1	Exception
    //   520	3	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   92	110	507	java/lang/Exception
    //   220	304	520	java/lang/Exception
    //   474	499	549	java/lang/Exception
    //   533	547	549	java/lang/Exception
  }
  
  private boolean a(Runnable paramRunnable, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_f_of_type_Boolean = false;
    ThreadManagerV2.executeOnSubThread(new JumpAction.7(this, paramString1, System.currentTimeMillis(), paramString2, paramString3, paramRunnable));
    return true;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 13);
    localBundle.putString("viewParam", paramString1);
    if (paramString2 != null) {
      localBundle.putString("entry", paramString2);
    }
    paramString1 = new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class);
    paramString1.putExtra("srvBundle", localBundle);
    if (paramLong != 0L) {
      paramString1.putExtra("vacreport_key_seq", paramLong);
    }
    paramString1.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=10&entry=" + paramString2 + "&seq=" + paramLong));
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramString1);
    return true;
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 13);
    localBundle.putString("viewParam", paramString1);
    if (paramString2 != null) {
      localBundle.putString("entry", paramString2);
    }
    if (paramLong != 0L) {
      localBundle.putLong("vacreport_key_seq", paramLong);
    }
    if (paramBundle != null) {
      localBundle.putBundle("extra_pay_data", paramBundle);
    }
    VACDReportUtil.a(paramLong, null, "loadPluginStart", null, 0, null);
    QWalletPayBridge.launchForeground((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle);
    return true;
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    String str10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_program_appid"));
    String str11 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_program_path"));
    if (this.jdField_a_of_type_JavaUtilHashMap.get("mini_program_type") != null) {}
    for (int i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_program_type"))).intValue();; i1 = 3)
    {
      int i3 = 0;
      long l1;
      int i4;
      try
      {
        l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
        if (l1 <= 0L) {
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          l1 = 0L;
        }
        i4 = 1;
      }
      try
      {
        i2 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          for (;;)
          {
            i3 = Integer.valueOf((String)localObject2).intValue();
            if (localObject1 != null) {
              break label1073;
            }
            localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
            localObject2 = new ArrayList();
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            localObject1 = ((String)localObject1).split(";");
            i4 = 0;
            while (i4 < localObject1.length)
            {
              ((ArrayList)localObject2).add(URLDecoder.decode(localObject1[i4]));
              i4 += 1;
            }
            localNumberFormatException2 = localNumberFormatException2;
            i2 = i3;
            if (QLog.isColorLevel())
            {
              QLog.d("QzoneShare", 2, "NumberFormatException extFlags = 0");
              i2 = i3;
            }
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          label1073:
          for (;;)
          {
            int i2;
            i3 = i4;
            if (QLog.isColorLevel())
            {
              QLog.d("QzoneShare", 2, "NumberFormatException req_type = 1");
              i3 = i4;
              continue;
              if ((localNumberFormatException1 != null) && (localNumberFormatException1.size() > 0)) {}
              for (localObject1 = (String)localNumberFormatException1.get(0);; localObject1 = "")
              {
                Bundle localBundle = new Bundle();
                localBundle.putString("title", str2);
                localBundle.putString("desc", str3);
                localBundle.putString("app_name", str5);
                localBundle.putLong("req_share_id", l1);
                localBundle.putString("detail_url", str4);
                localBundle.putStringArrayList("image_url", localNumberFormatException1);
                localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
                localBundle.putString("open_id", str1);
                localBundle.putString("share_uin", str7);
                localBundle.putString("jfrom", str8);
                localBundle.putString("share_qq_ext_str", str9);
                localBundle.putInt("cflag", i2);
                localBundle.putString("share_action", paramString);
                localBundle.putInt("iUrlInfoFrm", 4);
                localBundle.putBoolean("thirdPartShare", true);
                if ((!TextUtils.isEmpty(str10)) && (!TextUtils.isEmpty(str11)))
                {
                  localBundle.putBoolean("is_share_mini_app_msg", true);
                  localBundle.putString("share_mini_app_id", str10);
                  localBundle.putString("share_mini_app_path", str11);
                  localBundle.putInt("share_mini_ver_type", i1);
                  localBundle.putString("share_mini_image_url", (String)localObject1);
                }
                if (i3 == 2) {
                  localBundle.putString("audio_url", str6);
                }
                localBundle.putInt("req_type", i3);
                com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
                paramString = new bhem(this);
                localBundle.putBoolean("key_require_storage_permission", paramBoolean);
                if ((i3 == 5) && ((i2 & 0x1) != 0)) {
                  QZoneShareManager.jumpToQzoneShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localBundle, paramString, 23);
                }
                for (;;)
                {
                  if (i3 == 1) {
                    paramString = "1";
                  }
                  try
                  {
                    for (;;)
                    {
                      bjgx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str1, String.valueOf(l1), "11", "12", "0", paramString, "0", "0", false, true);
                      label858:
                      paramString = new QZoneClickReport.ReportInfo();
                      paramString.actionType = "1";
                      paramString.subactionType = "0";
                      paramString.tabletype = 4;
                      paramString.sourceType = "5";
                      paramString.sourceFrom = "thirdApp";
                      paramString.sourceTo = "activefeed";
                      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString);
                      paramString = new HashMap();
                      paramString.put("source_type", "5");
                      paramString.put("source_from", "thirdApp");
                      paramString.put("source_to", "activefeed");
                      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramString, null);
                      if ((!this.jdField_f_of_type_Boolean) && ((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
                        ((JumpActivity)this.jdField_a_of_type_AndroidContentContext).finish();
                      }
                      return true;
                      QZoneShareManager.jumpToQzoneShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localBundle, paramString);
                      break;
                      if (i3 == 2) {
                        paramString = "3";
                      } else if (i3 == 5) {
                        paramString = "2";
                      } else {
                        paramString = "4";
                      }
                    }
                  }
                  catch (Exception paramString)
                  {
                    break label858;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean a(Map<String, String> paramMap, boolean paramBoolean)
  {
    String str1 = (String)paramMap.get("userid");
    String str2 = (String)paramMap.get("usertype");
    String str3 = (String)paramMap.get("unionid");
    String str4 = (String)paramMap.get("storyid");
    String str5 = (String)paramMap.get("showinfocard");
    b(paramMap);
    if (((str5 == null) || (!str5.equals("0"))) || (TextUtils.isEmpty(str4)))
    {
      if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
        return false;
      }
      try
      {
        int i1 = Integer.parseInt(str2);
        if (i1 == 1)
        {
          if (TextUtils.isEmpty(str1)) {
            return false;
          }
          weg.a(this.jdField_a_of_type_AndroidContentContext, 23, str3);
        }
        for (;;)
        {
          return true;
          if (i1 != 5) {}
        }
        return true;
      }
      catch (NumberFormatException paramMap)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, userId:" + str1 + ", userType:" + str2);
        }
        return false;
      }
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject1 = new Bundle();
    long l1;
    int i2;
    try
    {
      l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
      if (l1 <= 0L) {
        return false;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        l1 = 0L;
      }
      str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qzone_ext_str"));
      ((Bundle)localObject1).putString("open_id", str);
      ((Bundle)localObject1).putString("share_uin", (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((Bundle)localObject1).putString("share_ext_string", (String)localObject3);
      }
      i2 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"))).intValue();
      if (i2 != 3) {
        break label625;
      }
    }
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    Object localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    Object localObject2 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = ((String)localObject3).split(";");
      int i1 = 0;
      while (i1 < localObject3.length)
      {
        ((ArrayList)localObject2).add(URLDecoder.decode(localObject3[i1]));
        i1 += 1;
      }
    }
    ((Bundle)localObject1).putStringArrayList("images", (ArrayList)localObject2);
    ((Bundle)localObject1).putString("summary", str);
    for (str = "7";; str = "") {
      for (;;)
      {
        ((Bundle)localObject1).putString("app_name", c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")));
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          ((Bundle)localObject1).putString("hulian_appid", String.valueOf(l1));
        }
        ((Bundle)localObject1).putInt("req_type", i2);
        ((Bundle)localObject1).putLong("req_share_id", l1);
        ((Bundle)localObject1).putString("pkg_name", this.jdField_e_of_type_JavaLangString);
        ((Bundle)localObject1).putBoolean("key_need_save_draft", false);
        ((Bundle)localObject1).putBoolean("key_require_storage_permission", paramBoolean);
        com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
        localObject2 = new bhel(this);
        QZoneShareManager.publishToQzone(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, (DialogInterface.OnDismissListener)localObject2);
        localObject2 = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject2).actionType = "1";
        ((QZoneClickReport.ReportInfo)localObject2).subactionType = "0";
        ((QZoneClickReport.ReportInfo)localObject2).tabletype = 4;
        ((QZoneClickReport.ReportInfo)localObject2).sourceType = "5";
        ((QZoneClickReport.ReportInfo)localObject2).sourceFrom = "thirdApp";
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("source_type", "5");
        ((HashMap)localObject3).put("source_from", "thirdApp");
        localObject1 = ((Bundle)localObject1).getStringArrayList("images");
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 9))
        {
          ((QZoneClickReport.ReportInfo)localObject2).sourceTo = "QZoneUploadPhotosActivity";
          ((HashMap)localObject3).put("source_to", "QZoneUploadPhotosActivity");
          QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject2);
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject3, null);
          bjgx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", l1 + "", "11", "12", "0", str, "", "4", false);
          return true;
          label625:
          if (i2 == 4) {
            str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoPath"));
          }
        }
        else
        {
          try
          {
            ((Bundle)localObject1).putLong("file_send_duration", Long.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoDuration"))).longValue());
            try
            {
              label678:
              ((Bundle)localObject1).putLong("PhotoConst.VIDEO_SIZE", Long.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoSize"))).longValue());
              label708:
              localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
              ((Bundle)localObject1).putBoolean("PhotoConst.IS_VIDEO_SELECTED", true);
              ((Bundle)localObject1).putInt("PhotoConst.VIDEO_TYPE", 1);
              ((Bundle)localObject1).putString("file_send_path", str);
              ((Bundle)localObject1).putBoolean("need_process", false);
              ((Bundle)localObject1).putString("defaultText", (String)localObject2);
              str = "8";
              continue;
              ((QZoneClickReport.ReportInfo)localObject2).sourceTo = "QZonePublishMoodActivity";
              ((HashMap)localObject3).put("source_to", "QZonePublishMoodActivity");
            }
            catch (Exception localException2)
            {
              break label708;
            }
          }
          catch (Exception localException3)
          {
            break label678;
          }
        }
      }
    }
  }
  
  private boolean aA()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request");
    if ((str1 == null) || (!str1.equals("videochat"))) {
      return false;
    }
    str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str4)))
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.qidian.openactionsheet");
      Bundle localBundle = new Bundle();
      localBundle.putString("request_type", str4);
      localBundle.putString("nickname", str3);
      localBundle.putString("uin", str1);
      localBundle.putString("sigt", str2);
      localIntent.putExtras(localBundle);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return true;
    }
    return false;
  }
  
  private boolean aB()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || (str.length() < 6)) {
      return false;
    }
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null) {
      return false;
    }
    localObject = ((TroopManager)localObject).b(str);
    if (localObject != null)
    {
      localObject = ((TroopInfo)localObject).getTroopName();
      Intent localIntent = new Intent();
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      localIntent = AIOUtils.setOpenAIOIntent(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", 1);
      if (localObject != null) {
        localIntent.putExtra("uinname", (String)localObject);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    return aQ();
  }
  
  private boolean aC()
  {
    if (QLog.isColorLevel()) {
      axql.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lon");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("lat");
    if ((str != null) && (localObject != null)) {}
    for (;;)
    {
      try
      {
        i2 = Integer.parseInt(str.trim());
        i1 = Integer.parseInt(((String)localObject).trim());
        str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class);
        ((Intent)localObject).putExtra("ENTER_TIME", System.currentTimeMillis());
        ((Intent)localObject).putExtra("lat", i1);
        ((Intent)localObject).putExtra("lon", i2);
        ((Intent)localObject).putExtra("filter", 0);
        if (str != null) {
          ((Intent)localObject).putExtra("title", str);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        return true;
      }
      catch (Exception localException)
      {
        return false;
      }
      int i1 = 0;
      int i2 = 0;
    }
  }
  
  private boolean aD()
  {
    bffn.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private boolean aE()
  {
    if ((String)this.jdField_a_of_type_JavaUtilHashMap.get("back_title") == null) {
      anvx.a(2131705390);
    }
    bfgz localbfgz = (bfgz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_TROOP_CREATE);
    if (localbfgz != null) {
      localbfgz.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 0);
    }
    return true;
  }
  
  /* Error */
  private boolean aF()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 2175
    //   7: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 45	java/lang/String
    //   13: astore 6
    //   15: aload_0
    //   16: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: ldc_w 2177
    //   22: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 45	java/lang/String
    //   28: astore 7
    //   30: aload 6
    //   32: ifnull +139 -> 171
    //   35: aload 7
    //   37: ifnull +134 -> 171
    //   40: aload 6
    //   42: invokevirtual 2180	java/lang/String:trim	()Ljava/lang/String;
    //   45: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   48: i2d
    //   49: ldc2_w 2212
    //   52: ddiv
    //   53: dstore_1
    //   54: aload 7
    //   56: invokevirtual 2180	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: istore 5
    //   64: iload 5
    //   66: i2d
    //   67: ldc2_w 2212
    //   70: ddiv
    //   71: dstore_3
    //   72: aload_0
    //   73: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   76: ldc_w 1888
    //   79: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 45	java/lang/String
    //   85: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   88: pop
    //   89: new 113	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 2215
    //   99: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: dload_3
    //   103: invokevirtual 2218	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   106: ldc_w 2220
    //   109: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: dload_1
    //   113: invokevirtual 2218	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   116: ldc_w 2222
    //   119: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 6
    //   127: new 134	android/content/Intent
    //   130: dup
    //   131: ldc_w 1501
    //   134: aload 6
    //   136: invokestatic 1518	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   139: invokespecial 2225	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   142: astore 7
    //   144: aload 7
    //   146: ldc_w 2227
    //   149: ldc_w 2229
    //   152: invokevirtual 1712	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: aload_0
    //   157: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   160: aload 7
    //   162: invokevirtual 216	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   165: iconst_1
    //   166: ireturn
    //   167: astore 6
    //   169: iconst_0
    //   170: ireturn
    //   171: iconst_0
    //   172: ireturn
    //   173: astore 7
    //   175: aload_0
    //   176: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   179: new 134	android/content/Intent
    //   182: dup
    //   183: ldc_w 1501
    //   186: aload 6
    //   188: invokestatic 1518	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   191: invokespecial 2225	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   194: invokevirtual 216	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   197: goto -32 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	bheh
    //   53	60	1	d1	double
    //   71	32	3	d2	double
    //   62	3	5	i1	int
    //   13	122	6	str	String
    //   167	20	6	localException	Exception
    //   28	133	7	localObject	Object
    //   173	1	7	localActivityNotFoundException	android.content.ActivityNotFoundException
    // Exception table:
    //   from	to	target	type
    //   40	64	167	java/lang/Exception
    //   156	165	173	android/content/ActivityNotFoundException
  }
  
  private boolean aG()
  {
    if ("webview".equals(this.jdField_d_of_type_JavaLangString))
    {
      c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "select_location").putExtra("doCallBack", true).putExtra("src_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type")).putExtra("callback_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type")).putExtra("callback_name", (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name")));
    }
    return true;
  }
  
  private boolean aH()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("card_type");
    if (QSecFramework.a().a(1003).booleanValue())
    {
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      bizc.a().a(5, str1, 0, str2);
      bizc.a().a();
    }
    if ((str1 != null) && ("group".equals(str1)))
    {
      a(10010, a());
      return aQ();
    }
    if ("groupsearchsetting".equalsIgnoreCase(str1)) {
      return aO();
    }
    if ("groupmanager".equalsIgnoreCase(str1)) {
      return aP();
    }
    if ("public_account".equals(str1))
    {
      a(10003, a());
      return aJ();
    }
    if ("troopmember".equals(str1)) {
      return aS();
    }
    if ("crm".equals(str1)) {
      return aK();
    }
    if ("nearby".equals(str1)) {
      return aI();
    }
    if ("allpeoplevote".equals(str1)) {
      return aL();
    }
    if ("troopmemberfromhb".equals(str1)) {
      return aU();
    }
    if ("groupsetting".equals(str1)) {
      return aT();
    }
    a(10002, a());
    return aM();
  }
  
  /* Error */
  private boolean aI()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 2314
    //   7: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +329 -> 339
    //   13: aload_0
    //   14: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   17: ldc_w 2314
    //   20: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 45	java/lang/String
    //   26: astore 12
    //   28: aload_0
    //   29: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   32: ldc_w 2316
    //   35: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   38: ifeq +308 -> 346
    //   41: aload_0
    //   42: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   45: ldc_w 2316
    //   48: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 45	java/lang/String
    //   54: astore 11
    //   56: lconst_0
    //   57: lstore 5
    //   59: aload_0
    //   60: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   63: ldc_w 2318
    //   66: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   69: ifeq +1264 -> 1333
    //   72: ldc_w 283
    //   75: aload_0
    //   76: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   79: ldc_w 2318
    //   82: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq +1245 -> 1333
    //   91: iconst_1
    //   92: istore 9
    //   94: lload 5
    //   96: lstore 7
    //   98: aload_0
    //   99: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   102: ldc_w 2320
    //   105: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   108: ifeq +24 -> 132
    //   111: aload_0
    //   112: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   115: ldc_w 2320
    //   118: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: checkcast 45	java/lang/String
    //   124: invokestatic 268	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   127: invokevirtual 272	java/lang/Long:longValue	()J
    //   130: lstore 7
    //   132: aload_0
    //   133: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   136: ldc_w 2322
    //   139: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   142: ifeq +240 -> 382
    //   145: aload_0
    //   146: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   149: ldc_w 2322
    //   152: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: checkcast 45	java/lang/String
    //   158: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   161: invokevirtual 844	java/lang/Integer:intValue	()I
    //   164: istore_1
    //   165: aload_0
    //   166: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   169: ldc_w 2324
    //   172: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   175: ifeq +212 -> 387
    //   178: aload_0
    //   179: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   182: ldc_w 2324
    //   185: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   188: checkcast 45	java/lang/String
    //   191: astore 13
    //   193: aload 13
    //   195: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: istore 10
    //   200: iload 10
    //   202: ifeq +192 -> 394
    //   205: lconst_0
    //   206: lstore 5
    //   208: aload_0
    //   209: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   212: ldc_w 937
    //   215: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   218: ifeq +197 -> 415
    //   221: aload_0
    //   222: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   225: ldc_w 937
    //   228: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   231: checkcast 45	java/lang/String
    //   234: astore 13
    //   236: aload 13
    //   238: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   241: istore_2
    //   242: aload_0
    //   243: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   246: ldc_w 2326
    //   249: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   252: ifeq +177 -> 429
    //   255: aload_0
    //   256: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   259: ldc_w 2326
    //   262: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   265: checkcast 45	java/lang/String
    //   268: astore 13
    //   270: aload 13
    //   272: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   275: invokevirtual 844	java/lang/Integer:intValue	()I
    //   278: istore_3
    //   279: aload_0
    //   280: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   283: ldc_w 2328
    //   286: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   289: ifeq +154 -> 443
    //   292: aload_0
    //   293: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   296: ldc_w 2328
    //   299: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   302: checkcast 45	java/lang/String
    //   305: astore 13
    //   307: aload 13
    //   309: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   312: invokevirtual 844	java/lang/Integer:intValue	()I
    //   315: istore 4
    //   317: iload_3
    //   318: iconst_1
    //   319: if_icmpeq +140 -> 459
    //   322: iload_3
    //   323: iconst_2
    //   324: if_icmpeq +135 -> 459
    //   327: iload_3
    //   328: iconst_3
    //   329: if_icmpeq +130 -> 459
    //   332: iload_3
    //   333: iconst_4
    //   334: if_icmpeq +125 -> 459
    //   337: iconst_0
    //   338: ireturn
    //   339: ldc 56
    //   341: astore 12
    //   343: goto -315 -> 28
    //   346: ldc 56
    //   348: astore 11
    //   350: goto -294 -> 56
    //   353: astore 13
    //   355: ldc 111
    //   357: iconst_1
    //   358: ldc_w 2330
    //   361: invokestatic 574	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: lload 5
    //   366: lstore 7
    //   368: goto -236 -> 132
    //   371: astore 13
    //   373: ldc 111
    //   375: iconst_1
    //   376: ldc_w 2332
    //   379: invokestatic 574	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: iconst_0
    //   383: istore_1
    //   384: goto -219 -> 165
    //   387: ldc 56
    //   389: astore 13
    //   391: goto -198 -> 193
    //   394: aload 13
    //   396: invokestatic 268	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   399: invokevirtual 272	java/lang/Long:longValue	()J
    //   402: lstore 5
    //   404: goto -196 -> 208
    //   407: astore 13
    //   409: lconst_0
    //   410: lstore 5
    //   412: goto -204 -> 208
    //   415: ldc 56
    //   417: astore 13
    //   419: goto -183 -> 236
    //   422: astore 13
    //   424: iconst_0
    //   425: istore_2
    //   426: goto -184 -> 242
    //   429: ldc 56
    //   431: astore 13
    //   433: goto -163 -> 270
    //   436: astore 13
    //   438: iconst_m1
    //   439: istore_3
    //   440: goto -161 -> 279
    //   443: ldc_w 531
    //   446: astore 13
    //   448: goto -141 -> 307
    //   451: astore 13
    //   453: iconst_0
    //   454: istore 4
    //   456: goto -139 -> 317
    //   459: new 134	android/content/Intent
    //   462: dup
    //   463: aload_0
    //   464: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   467: ldc_w 2334
    //   470: invokespecial 212	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   473: astore 15
    //   475: aload 15
    //   477: ldc_w 2336
    //   480: iload 4
    //   482: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   485: pop
    //   486: aload 15
    //   488: ldc_w 2338
    //   491: iload 9
    //   493: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   496: pop
    //   497: aload 15
    //   499: ldc_w 2320
    //   502: lload 7
    //   504: invokevirtual 741	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   507: pop
    //   508: aload 15
    //   510: ldc_w 2340
    //   513: iload_1
    //   514: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   517: pop
    //   518: iload_3
    //   519: tableswitch	default:+29 -> 548, 1:+31->550, 2:+31->550, 3:+434->953, 4:+693->1212
    //   549: ireturn
    //   550: aload_0
    //   551: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   554: ifnull +106 -> 660
    //   557: aload_0
    //   558: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   561: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   564: astore 11
    //   566: aload 12
    //   568: ldc_w 2342
    //   571: invokestatic 2345	bhbx:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   574: ifeq +360 -> 934
    //   577: aload_0
    //   578: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   581: ldc_w 2347
    //   584: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   587: ifeq +92 -> 679
    //   590: aload_0
    //   591: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   594: ldc_w 2347
    //   597: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   600: checkcast 45	java/lang/String
    //   603: astore 13
    //   605: aload_0
    //   606: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   609: ldc_w 2349
    //   612: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   615: ifeq +71 -> 686
    //   618: aload_0
    //   619: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   622: ldc_w 2349
    //   625: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   628: checkcast 45	java/lang/String
    //   631: astore 14
    //   633: aload 13
    //   635: aload 11
    //   637: invokestatic 2345	bhbx:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   640: ifne +53 -> 693
    //   643: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq +12 -> 658
    //   649: ldc 111
    //   651: iconst_2
    //   652: ldc_w 2351
    //   655: invokestatic 574	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: iconst_1
    //   659: ireturn
    //   660: aload_0
    //   661: getfield 2353	bheh:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   664: ifnull +662 -> 1326
    //   667: aload_0
    //   668: getfield 2353	bheh:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   671: invokevirtual 2356	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   674: astore 11
    //   676: goto -110 -> 566
    //   679: ldc 56
    //   681: astore 13
    //   683: goto -78 -> 605
    //   686: ldc 56
    //   688: astore 14
    //   690: goto -57 -> 633
    //   693: aload 15
    //   695: ldc_w 2349
    //   698: aload 14
    //   700: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   703: pop
    //   704: aload 15
    //   706: ldc_w 2358
    //   709: iconst_m1
    //   710: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   713: pop
    //   714: aload 15
    //   716: ldc_w 1196
    //   719: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   722: pop
    //   723: new 2360	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   726: dup
    //   727: aload 11
    //   729: iconst_0
    //   730: invokespecial 2362	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   733: astore 11
    //   735: iload_2
    //   736: iconst_1
    //   737: if_icmpne +30 -> 767
    //   740: aload 15
    //   742: ldc_w 2358
    //   745: bipush 12
    //   747: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   750: pop
    //   751: aload 11
    //   753: bipush 86
    //   755: putfield 2363	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   758: aload 15
    //   760: ldc_w 1269
    //   763: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   766: pop
    //   767: iload_2
    //   768: iconst_2
    //   769: if_icmpne +19 -> 788
    //   772: aload 11
    //   774: bipush 87
    //   776: putfield 2363	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   779: aload 15
    //   781: ldc_w 1269
    //   784: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   787: pop
    //   788: iload_2
    //   789: iconst_3
    //   790: if_icmpne +19 -> 809
    //   793: aload 11
    //   795: bipush 88
    //   797: putfield 2363	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   800: aload 15
    //   802: ldc_w 1269
    //   805: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   808: pop
    //   809: iload_2
    //   810: bipush 7
    //   812: if_icmplt +29 -> 841
    //   815: aload 15
    //   817: ldc_w 2358
    //   820: iload_2
    //   821: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   824: pop
    //   825: aload 11
    //   827: bipush 86
    //   829: putfield 2363	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   832: aload 15
    //   834: ldc_w 1269
    //   837: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   840: pop
    //   841: aload 15
    //   843: ldc_w 2365
    //   846: iload_3
    //   847: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   850: pop
    //   851: aload 15
    //   853: ldc_w 2367
    //   856: aload 11
    //   858: invokevirtual 2370	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   861: pop
    //   862: aload 12
    //   864: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   867: ifne +80 -> 947
    //   870: aload 12
    //   872: ldc_w 2372
    //   875: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   878: ifeq +69 -> 947
    //   881: iconst_1
    //   882: istore 9
    //   884: aload 15
    //   886: ldc_w 2374
    //   889: iload 9
    //   891: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   894: pop
    //   895: sipush 10002
    //   898: iload_2
    //   899: if_icmpne +12 -> 911
    //   902: aload 15
    //   904: ldc_w 1269
    //   907: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   910: pop
    //   911: aload 15
    //   913: ldc_w 2376
    //   916: lload 5
    //   918: invokevirtual 741	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   921: pop
    //   922: aload_0
    //   923: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   926: aload 15
    //   928: invokevirtual 216	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   931: goto -383 -> 548
    //   934: aload 15
    //   936: ldc_w 2378
    //   939: iconst_1
    //   940: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   943: pop
    //   944: goto -221 -> 723
    //   947: iconst_0
    //   948: istore 9
    //   950: goto -66 -> 884
    //   953: aload_0
    //   954: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   957: ldc_w 752
    //   960: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   963: ifeq +42 -> 1005
    //   966: aload_0
    //   967: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   970: ldc_w 752
    //   973: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   976: checkcast 45	java/lang/String
    //   979: astore 12
    //   981: lload 5
    //   983: lconst_0
    //   984: lcmp
    //   985: ifne +27 -> 1012
    //   988: aload 12
    //   990: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   993: ifeq +19 -> 1012
    //   996: lload 7
    //   998: lconst_0
    //   999: lcmp
    //   1000: ifne +12 -> 1012
    //   1003: iconst_0
    //   1004: ireturn
    //   1005: ldc 56
    //   1007: astore 12
    //   1009: goto -28 -> 981
    //   1012: aload 15
    //   1014: ldc_w 2365
    //   1017: iconst_3
    //   1018: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1021: pop
    //   1022: aload 15
    //   1024: ldc_w 2376
    //   1027: lload 5
    //   1029: invokevirtual 741	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1032: pop
    //   1033: sipush 10002
    //   1036: iload_2
    //   1037: if_icmpne +12 -> 1049
    //   1040: aload 15
    //   1042: ldc_w 1269
    //   1045: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1048: pop
    //   1049: aload 15
    //   1051: ldc_w 2378
    //   1054: iconst_1
    //   1055: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1058: pop
    //   1059: aload 15
    //   1061: ldc_w 2380
    //   1064: aload 11
    //   1066: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1069: pop
    //   1070: new 2360	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   1073: dup
    //   1074: aload 12
    //   1076: bipush 19
    //   1078: invokespecial 2362	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   1081: astore 11
    //   1083: iload_2
    //   1084: iconst_1
    //   1085: if_icmpne +30 -> 1115
    //   1088: aload 15
    //   1090: ldc_w 2358
    //   1093: bipush 12
    //   1095: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1098: pop
    //   1099: aload 11
    //   1101: bipush 86
    //   1103: putfield 2363	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1106: aload 15
    //   1108: ldc_w 1269
    //   1111: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1114: pop
    //   1115: iload_2
    //   1116: iconst_2
    //   1117: if_icmpne +19 -> 1136
    //   1120: aload 11
    //   1122: bipush 87
    //   1124: putfield 2363	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1127: aload 15
    //   1129: ldc_w 1269
    //   1132: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1135: pop
    //   1136: iload_2
    //   1137: iconst_3
    //   1138: if_icmpne +19 -> 1157
    //   1141: aload 11
    //   1143: bipush 88
    //   1145: putfield 2363	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1148: aload 15
    //   1150: ldc_w 1269
    //   1153: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1156: pop
    //   1157: iload_2
    //   1158: bipush 7
    //   1160: if_icmplt +29 -> 1189
    //   1163: aload 15
    //   1165: ldc_w 2358
    //   1168: iload_2
    //   1169: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1172: pop
    //   1173: aload 11
    //   1175: bipush 86
    //   1177: putfield 2363	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1180: aload 15
    //   1182: ldc_w 1269
    //   1185: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1188: pop
    //   1189: aload 15
    //   1191: ldc_w 2367
    //   1194: aload 11
    //   1196: invokevirtual 2370	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1199: pop
    //   1200: aload_0
    //   1201: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1204: aload 15
    //   1206: invokevirtual 216	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1209: goto -661 -> 548
    //   1212: ldc 56
    //   1214: astore 11
    //   1216: aload_0
    //   1217: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1220: ifnull +87 -> 1307
    //   1223: aload_0
    //   1224: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1227: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1230: astore 11
    //   1232: new 2360	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   1235: dup
    //   1236: aload 11
    //   1238: iconst_0
    //   1239: invokespecial 2362	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   1242: astore 11
    //   1244: aload 15
    //   1246: ldc_w 2378
    //   1249: iconst_1
    //   1250: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1253: pop
    //   1254: aload 15
    //   1256: ldc_w 2365
    //   1259: iload_3
    //   1260: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1263: pop
    //   1264: aload 15
    //   1266: ldc_w 2367
    //   1269: aload 11
    //   1271: invokevirtual 2370	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1274: pop
    //   1275: aload 15
    //   1277: ldc_w 1269
    //   1280: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1283: pop
    //   1284: aload 15
    //   1286: ldc_w 2376
    //   1289: lload 5
    //   1291: invokevirtual 741	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1294: pop
    //   1295: aload_0
    //   1296: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1299: aload 15
    //   1301: invokevirtual 216	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1304: goto -756 -> 548
    //   1307: aload_0
    //   1308: getfield 2353	bheh:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1311: ifnull -79 -> 1232
    //   1314: aload_0
    //   1315: getfield 2353	bheh:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1318: invokevirtual 2356	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1321: astore 11
    //   1323: goto -91 -> 1232
    //   1326: ldc 56
    //   1328: astore 11
    //   1330: goto -764 -> 566
    //   1333: iconst_0
    //   1334: istore 9
    //   1336: goto -1242 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1339	0	this	bheh
    //   164	350	1	i1	int
    //   241	928	2	i2	int
    //   278	982	3	i3	int
    //   315	166	4	i4	int
    //   57	1233	5	l1	long
    //   96	901	7	l2	long
    //   92	1243	9	bool1	boolean
    //   198	3	10	bool2	boolean
    //   54	1275	11	localObject	Object
    //   26	1049	12	str1	String
    //   191	117	13	str2	String
    //   353	1	13	localException1	Exception
    //   371	1	13	localException2	Exception
    //   389	6	13	str3	String
    //   407	1	13	localException3	Exception
    //   417	1	13	str4	String
    //   422	1	13	localException4	Exception
    //   431	1	13	str5	String
    //   436	1	13	localException5	Exception
    //   446	1	13	str6	String
    //   451	1	13	localException6	Exception
    //   603	79	13	str7	String
    //   631	68	14	str8	String
    //   473	827	15	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   111	132	353	java/lang/Exception
    //   145	165	371	java/lang/Exception
    //   165	193	407	java/lang/Exception
    //   193	200	407	java/lang/Exception
    //   394	404	407	java/lang/Exception
    //   208	236	422	java/lang/Exception
    //   236	242	422	java/lang/Exception
    //   242	270	436	java/lang/Exception
    //   270	279	436	java/lang/Exception
    //   279	307	451	java/lang/Exception
    //   307	317	451	java/lang/Exception
  }
  
  private boolean aJ()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_flag");
    int i1 = -1;
    try
    {
      int i2 = Integer.parseInt((String)localObject2);
      i1 = i2;
    }
    catch (Exception localException)
    {
      label39:
      break label39;
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoShowPublicAccountCard uin: " + (String)localObject1 + " | accountFlag: " + i1 + " | current uin: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    if ((localObject1 == null) || ("".equals(localObject1)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject1))) {
      return false;
    }
    if (((String)localObject1).length() < 5) {
      return false;
    }
    if (m())
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        localObject1 = new usn();
        ((usn)localObject1).a(new ProfileParams.CurLoginUsr((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"), (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"))).d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")).c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).a(i1).b((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
        uuc.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((usn)localObject1).a());
        return false;
      }
    }
    else
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("source", 117);
      uuc.a((Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, i1);
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
    }
    return true;
  }
  
  private boolean aK()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoShowCrmCard uin: " + str + " | current uin: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    if ((str == null) || ("".equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(str))) {
      return false;
    }
    if (str.length() < 5) {
      return false;
    }
    uuc.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str, -7);
    return true;
  }
  
  private boolean aL()
  {
    try
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      long l1 = Long.parseLong(str1);
      if (l1 < 10000L)
      {
        if (!QLog.isColorLevel()) {
          break label300;
        }
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard invalid uin uin: %d", new Object[] { Long.valueOf(l1) }));
        return false;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("name");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
      localFriends = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(str1);
      if (!bhbx.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label234;
      }
      localAllInOne1 = new ProfileActivity.AllInOne(str1, 0);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2;
        String str3;
        Friends localFriends;
        ProfileActivity.AllInOne localAllInOne1;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard exception : %s", new Object[] { localException.toString() }));
        return false;
        label234:
        ProfileActivity.AllInOne localAllInOne2;
        if ((localFriends != null) && (localFriends.isFriend()))
        {
          localAllInOne2 = new ProfileActivity.AllInOne(str1, 1);
          localAllInOne2.jdField_h_of_type_JavaLangString = localFriends.name;
          localAllInOne2.jdField_i_of_type_JavaLangString = localFriends.remark;
        }
        else
        {
          localAllInOne2 = new ProfileActivity.AllInOne(str1, 95);
          localAllInOne2.jdField_h_of_type_JavaLangString = str2;
        }
      }
    }
    ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, localAllInOne1);
    if (QLog.isDevelopLevel())
    {
      QLog.i("JumpAction", 4, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard uin: %s  name: %s source: %s", new Object[] { bhbx.b(str1), bhbx.b(str2), str3 }));
      return false;
    }
    label300:
    return false;
  }
  
  private boolean aM()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (Boolean.parseBoolean((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_add_friend"))) {
      return c((String)localObject1);
    }
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpa");
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    boolean bool1 = "1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("track_back"));
    boolean bool2 = "1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("singleTop"));
    boolean bool3 = "1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("group_video_open"));
    if ("internal_phone".equals(localObject3))
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007014", "0X8007014", 0, 0, "", "", "", "");
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 53);
      ((ProfileActivity.AllInOne)localObject1).jdField_k_of_type_JavaLangString = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname"));
      ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 105;
      localObject2 = new Bundle();
      localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!b((String)localObject3))) {
        break label720;
      }
    }
    label720:
    for (int i1 = Integer.valueOf((String)localObject3).intValue();; i1 = 0)
    {
      if ((i1 > 0) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msg_uniseq")))
      {
        localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("msg_uniseq");
        if ((i1 == 100) && (bhbx.b((String)localObject3)))
        {
          ((Bundle)localObject2).putBoolean("from_babyq", true);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007241", "0X8007241", 0, 0, "", "", "", "");
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("colorScreen")) {
        ((ProfileActivity.AllInOne)localObject1).f = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("colorScreen"));
      }
      ((Bundle)localObject2).putBoolean("key_need_track_back", bool1);
      ((Bundle)localObject2).putBoolean("single_top", bool2);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, String.format("gotoShowPSLCard [%d %b %b]", new Object[] { Integer.valueOf(i1), Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, (Bundle)localObject2);
      return true;
      if ((localObject1 == null) || ("".equals(localObject1)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject1)))
      {
        localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        break;
      }
      if (((String)localObject1).length() < 5) {
        return false;
      }
      localObject3 = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e((String)localObject1);
      if ((localObject3 != null) && (((Friends)localObject3).isFriend()))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
        ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = ((Friends)localObject3).name;
        ((ProfileActivity.AllInOne)localObject1).jdField_i_of_type_JavaLangString = ((Friends)localObject3).remark;
        break;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 3);
        if ("1".equals(localObject2)) {}
        for (i1 = 1;; i1 = 0)
        {
          ((ProfileActivity.AllInOne)localObject1).d = i1;
          ((ProfileActivity.AllInOne)localObject1).l = 11;
          break;
        }
      }
      if (bool3)
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 116);
        break;
      }
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 78);
      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("referee");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("flc_recommend_uin", (String)localObject2);
        ((ProfileActivity.AllInOne)localObject1).b.putBundle("flc_extra_param", (Bundle)localObject3);
      }
      break;
    }
  }
  
  private boolean aN()
  {
    boolean bool = false;
    int i2 = 0;
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    int i1 = i2;
    if (str != null)
    {
      i1 = i2;
      if (!"".equals(str))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(str)) {
          break label180;
        }
        i1 = i2;
      }
    }
    for (;;)
    {
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(str, i1);
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PersonalityLabelGalleryActivity.class);
      localIntent.putExtra("personality_label_allinone", localAllInOne);
      localIntent.putExtra("fromType", 1);
      localIntent.putExtra("uin", str);
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoShowPersonalityLabel. uin:" + str);
      }
      bool = true;
      label180:
      do
      {
        return bool;
      } while (str.length() < 5);
      if (((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str)) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
  
  private boolean aO()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject1 == null) {
        break label270;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label270;
      }
    }
    label270:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "gotoGroupSearchSetting not admin " + str);
        }
        return false;
      }
      Object localObject2 = TroopInfoActivity.a(str, 3);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      localObject2 = new bmiu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      if (localPluginCommunicationHandler != null) {
        localPluginCommunicationHandler.register((RemoteCommand)localObject2);
      }
      localObject2 = TroopBaseProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, (Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopSearchWayActivity", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupSearchSetting " + str);
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupSearchSetting context not activity");
      }
      return false;
    }
  }
  
  private boolean aP()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject1 == null) {
        break label307;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label307;
      }
    }
    label307:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "gotoGroupManager not admin " + str);
        }
        return false;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("troop_uin", str);
      ((Intent)localObject1).putExtra("key_is_update_before_805", TroopUtils.isUpdateBeforeSomeVersion(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new bmiu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      if (localPluginCommunicationHandler != null) {
        localPluginCommunicationHandler.register((RemoteCommand)localObject2);
      }
      localObject2 = TroopBaseProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, (Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopManageActivity", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager " + str);
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager context not activity");
      }
      return false;
    }
  }
  
  private boolean aQ()
  {
    boolean bool2 = false;
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wSourceSubID");
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("isPrivate")) {}
    do
    {
      do
      {
        do
        {
          try
          {
            if (Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("isPrivate")).intValue() == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bjyh);
              ((bjyi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(str2);
              bool1 = true;
              return bool1;
            }
          }
          catch (Exception localException1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, new Object[] { "gotoShowGroupCard throw Exception ", localException1.toString() });
            }
          }
          bool1 = bool2;
        } while (str2 == null);
        bool1 = bool2;
      } while ("".equals(str2));
      boolean bool1 = bool2;
    } while (str2.length() < 5);
    Object localObject1;
    if ("QRJumpActivity".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from"))) {
      localObject1 = TroopInfoActivity.a(str2, 14);
    }
    for (;;)
    {
      if ("d2g".equals(this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
      {
        localObject1 = TroopInfoActivity.a(str2, 16);
        ((Bundle)localObject1).putInt("D2GType", 2);
      }
      Object localObject3 = localObject1;
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from_group_search"))) {}
      try
      {
        localObject1 = TroopInfoActivity.a(str2, Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from_group_search")));
        if ("h5".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
        {
          localObject1 = TroopInfoActivity.a(str2, 22);
          if ("webapi".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
          {
            if (!"3_40002".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("source_id"))) {
              break label805;
            }
            ((Bundle)localObject1).putInt("troop_info_from_ex", 40002);
          }
        }
        try
        {
          i2 = Integer.parseInt(str1);
          i1 = i2;
          if (i2 == 43) {
            i1 = 10002;
          }
          localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sourceext");
          str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isexactsearch");
          if ((localObject3 == null) || (str2 == null) || (((String)localObject3).isEmpty()) || (str2.isEmpty())) {
            break label1092;
          }
          i3 = Integer.parseInt((String)localObject3);
          if (Integer.parseInt(str2) != 1) {
            break label819;
          }
          i2 = 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int i2;
            int i1;
            int i3;
            Object localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("JumpAction", 2, "cast source sub id from web error, sourceSubId = " + str1);
              continue;
              if (i1 == 37)
              {
                ((Bundle)localObject2).putInt("troop_info_from", 30);
              }
              else if (i1 == 10008)
              {
                ((Bundle)localObject2).putInt("troop_info_from", 102);
              }
              else if (i1 == 10013)
              {
                ((Bundle)localObject2).putInt("troop_info_from", 106);
              }
              else if ((i1 >= 30006) && (i1 <= 30020))
              {
                ((Bundle)localObject2).putInt("troop_info_from", i1);
                continue;
                switch (i3)
                {
                }
              }
            }
          }
        }
        ((Bundle)localObject1).putInt("troop_info_from_ex", i1);
        if (i1 == 33)
        {
          ((Bundle)localObject1).putInt("troop_info_from", 24);
          if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"))) && (Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type")) == 100))
          {
            ((Bundle)localObject1).putBoolean("from_babyq", true);
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007245", "0X8007245", 0, 0, "", "", "", "");
          }
          ((Bundle)localObject1).putString("authKey", (String)this.jdField_a_of_type_JavaUtilHashMap.get("authKey"));
          ((Bundle)localObject1).putString("authSig", (String)this.jdField_a_of_type_JavaUtilHashMap.get("authSig"));
          if (QLog.isColorLevel()) {
            QLog.i("JumpAction", 2, String.format("gotoShowGroupCard troop_authSig=%s", new Object[] { this.jdField_a_of_type_JavaUtilHashMap.get("authSig") }));
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
            ((Bundle)localObject1).putString("appid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) {
            ((Bundle)localObject1).putString("openid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid"));
          }
          TroopUtils.openTroopInfoActivity(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, 2);
          return true;
          localObject1 = TroopInfoActivity.a(str2, 5);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          localObject2 = localObject3;
          continue;
          if ("groupprofile".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from")))
          {
            localObject2 = TroopInfoActivity.a(str2, 22);
            ((Bundle)localObject2).putBoolean("troop_info_from_troopsetting", true);
          }
          continue;
          label805:
          ((Bundle)localObject2).putInt("troop_info_from_ex", 40001);
          continue;
          label819:
          i2 = 0;
          break label1056;
          if (i2 != 0)
          {
            i1 = 30004;
          }
          else
          {
            i1 = 30006;
            continue;
            if (i2 != 0)
            {
              i1 = 30004;
            }
            else
            {
              i1 = 30008;
              continue;
              if (i2 != 0)
              {
                i1 = 30010;
              }
              else
              {
                i1 = 30012;
                continue;
                if (i2 != 0)
                {
                  i1 = 30014;
                }
                else
                {
                  i1 = 30016;
                  continue;
                  if (i2 != 0)
                  {
                    i1 = 30018;
                  }
                  else
                  {
                    i1 = 30020;
                    continue;
                    if (i1 != 43) {
                      break;
                    }
                    ((Bundle)localObject2).putInt("troop_info_from", 27);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean aR()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((localObject == null) || ("".equals(localObject)) || (((String)localObject).length() < 5)) {
      return false;
    }
    localObject = TroopInfoActivity.a((String)localObject, 14);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
      ((Bundle)localObject).putString("appid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) {
      ((Bundle)localObject).putString("openid", c(m));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("openkey")) {
      ((Bundle)localObject).putString("openkey", (String)this.jdField_a_of_type_JavaUtilHashMap.get("openkey"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("is_from_game")) {
      ((Bundle)localObject).putString("is_from_game", (String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("guild_id")) {
      ((Bundle)localObject).putString("guild_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("guild_id"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("zone_id")) {
      ((Bundle)localObject).putString("zone_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("zone_id"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("role_id")) {
      ((Bundle)localObject).putString("role_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("role_id"));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("gc")) {
      ((Bundle)localObject).putString("gc", (String)this.jdField_a_of_type_JavaUtilHashMap.get("gc"));
    }
    TroopUtils.openTroopInfoActivity(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject, 2);
    return true;
  }
  
  /* Error */
  private boolean aS()
  {
    // Byte code:
    //   0: ldc 56
    //   2: astore 14
    //   4: ldc 56
    //   6: astore 19
    //   8: ldc 56
    //   10: astore 17
    //   12: ldc 56
    //   14: astore 10
    //   16: ldc 56
    //   18: astore 18
    //   20: aload_0
    //   21: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: ldc_w 1698
    //   27: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 45	java/lang/String
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   38: ldc_w 2690
    //   41: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 45	java/lang/String
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   52: ldc_w 752
    //   55: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: checkcast 45	java/lang/String
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   66: ldc_w 2692
    //   69: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 45	java/lang/String
    //   75: astore 4
    //   77: aload 18
    //   79: astore 12
    //   81: aload 10
    //   83: astore 7
    //   85: aload 17
    //   87: astore 5
    //   89: aload 19
    //   91: astore 15
    //   93: aload 14
    //   95: astore 11
    //   97: aload 18
    //   99: astore 13
    //   101: aload 10
    //   103: astore 8
    //   105: aload 17
    //   107: astore 6
    //   109: aload 19
    //   111: astore 16
    //   113: aload_0
    //   114: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   117: ldc_w 2694
    //   120: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast 45	java/lang/String
    //   126: ldc_w 2696
    //   129: invokestatic 2698	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: astore 9
    //   134: aload 18
    //   136: astore 12
    //   138: aload 10
    //   140: astore 7
    //   142: aload 17
    //   144: astore 5
    //   146: aload 19
    //   148: astore 15
    //   150: aload 9
    //   152: astore 11
    //   154: aload 18
    //   156: astore 13
    //   158: aload 10
    //   160: astore 8
    //   162: aload 17
    //   164: astore 6
    //   166: aload 19
    //   168: astore 16
    //   170: aload 9
    //   172: astore 14
    //   174: aload_0
    //   175: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   178: ldc_w 2700
    //   181: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: checkcast 45	java/lang/String
    //   187: ldc_w 2696
    //   190: invokestatic 2698	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   193: astore 19
    //   195: aload 18
    //   197: astore 12
    //   199: aload 10
    //   201: astore 7
    //   203: aload 17
    //   205: astore 5
    //   207: aload 19
    //   209: astore 15
    //   211: aload 9
    //   213: astore 11
    //   215: aload 18
    //   217: astore 13
    //   219: aload 10
    //   221: astore 8
    //   223: aload 17
    //   225: astore 6
    //   227: aload 19
    //   229: astore 16
    //   231: aload 9
    //   233: astore 14
    //   235: aload_0
    //   236: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   239: ldc_w 2702
    //   242: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   245: checkcast 45	java/lang/String
    //   248: ldc_w 2696
    //   251: invokestatic 2698	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   254: astore 17
    //   256: aload 18
    //   258: astore 12
    //   260: aload 10
    //   262: astore 7
    //   264: aload 17
    //   266: astore 5
    //   268: aload 19
    //   270: astore 15
    //   272: aload 9
    //   274: astore 11
    //   276: aload 18
    //   278: astore 13
    //   280: aload 10
    //   282: astore 8
    //   284: aload 17
    //   286: astore 6
    //   288: aload 19
    //   290: astore 16
    //   292: aload 9
    //   294: astore 14
    //   296: aload_0
    //   297: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   300: ldc_w 2704
    //   303: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast 45	java/lang/String
    //   309: ldc_w 2696
    //   312: invokestatic 2698	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   315: astore 10
    //   317: aload 18
    //   319: astore 12
    //   321: aload 10
    //   323: astore 7
    //   325: aload 17
    //   327: astore 5
    //   329: aload 19
    //   331: astore 15
    //   333: aload 9
    //   335: astore 11
    //   337: aload 18
    //   339: astore 13
    //   341: aload 10
    //   343: astore 8
    //   345: aload 17
    //   347: astore 6
    //   349: aload 19
    //   351: astore 16
    //   353: aload 9
    //   355: astore 14
    //   357: aload_0
    //   358: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   361: ldc_w 2706
    //   364: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   367: checkcast 45	java/lang/String
    //   370: ldc_w 2696
    //   373: invokestatic 2698	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   376: astore 18
    //   378: aload 18
    //   380: astore 12
    //   382: aload 10
    //   384: astore 7
    //   386: aload 17
    //   388: astore 5
    //   390: aload 19
    //   392: astore 15
    //   394: aload 9
    //   396: astore 11
    //   398: aload 18
    //   400: astore 13
    //   402: aload 10
    //   404: astore 8
    //   406: aload 17
    //   408: astore 6
    //   410: aload 19
    //   412: astore 16
    //   414: aload 9
    //   416: astore 14
    //   418: aload_0
    //   419: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   422: ldc_w 2708
    //   425: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   428: checkcast 45	java/lang/String
    //   431: ldc_w 2696
    //   434: invokestatic 2698	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   437: astore 20
    //   439: aload_1
    //   440: astore 7
    //   442: aload 20
    //   444: astore_1
    //   445: aload 17
    //   447: astore 8
    //   449: aload_2
    //   450: astore 6
    //   452: aload 18
    //   454: astore_2
    //   455: aload 10
    //   457: astore 5
    //   459: aload 9
    //   461: astore 11
    //   463: aload 19
    //   465: astore 9
    //   467: aload_3
    //   468: astore 10
    //   470: aload 6
    //   472: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifne +11 -> 486
    //   478: aload 7
    //   480: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifeq +129 -> 612
    //   486: iconst_0
    //   487: ireturn
    //   488: astore 9
    //   490: ldc 56
    //   492: astore 10
    //   494: ldc 56
    //   496: astore_1
    //   497: ldc 56
    //   499: astore_3
    //   500: ldc 56
    //   502: astore 6
    //   504: ldc 56
    //   506: astore 5
    //   508: ldc 56
    //   510: astore 4
    //   512: ldc 56
    //   514: astore 8
    //   516: ldc 56
    //   518: astore 7
    //   520: ldc 56
    //   522: astore_2
    //   523: aload 9
    //   525: invokevirtual 1495	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   528: aload 8
    //   530: astore 9
    //   532: aload 5
    //   534: astore 8
    //   536: aload_2
    //   537: astore 5
    //   539: aload_1
    //   540: astore_2
    //   541: ldc 56
    //   543: astore_1
    //   544: aload_3
    //   545: astore 11
    //   547: goto -77 -> 470
    //   550: astore 9
    //   552: ldc 56
    //   554: astore 10
    //   556: ldc 56
    //   558: astore_1
    //   559: ldc 56
    //   561: astore_3
    //   562: ldc 56
    //   564: astore 6
    //   566: ldc 56
    //   568: astore 5
    //   570: ldc 56
    //   572: astore 4
    //   574: ldc 56
    //   576: astore 8
    //   578: ldc 56
    //   580: astore 7
    //   582: ldc 56
    //   584: astore_2
    //   585: aload 9
    //   587: invokevirtual 2709	java/lang/NullPointerException:printStackTrace	()V
    //   590: aload 8
    //   592: astore 9
    //   594: aload 5
    //   596: astore 8
    //   598: aload_2
    //   599: astore 5
    //   601: aload_1
    //   602: astore_2
    //   603: ldc 56
    //   605: astore_1
    //   606: aload_3
    //   607: astore 11
    //   609: goto -139 -> 470
    //   612: aload_0
    //   613: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   616: ifnull +171 -> 787
    //   619: new 134	android/content/Intent
    //   622: dup
    //   623: aload_0
    //   624: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   627: ldc_w 2711
    //   630: invokespecial 212	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   633: astore_3
    //   634: aload_3
    //   635: ldc_w 2713
    //   638: aload 7
    //   640: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   643: pop
    //   644: aload_3
    //   645: ldc_w 2715
    //   648: new 113	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   655: ldc 56
    //   657: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload 6
    //   662: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   671: pop
    //   672: ldc_w 748
    //   675: aload 10
    //   677: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   680: ifeq +139 -> 819
    //   683: aload_3
    //   684: ldc_w 2717
    //   687: iconst_0
    //   688: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   691: pop
    //   692: new 306	android/os/Bundle
    //   695: dup
    //   696: invokespecial 307	android/os/Bundle:<init>	()V
    //   699: astore 6
    //   701: aload 6
    //   703: ldc_w 2690
    //   706: aload 4
    //   708: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: aload 6
    //   713: ldc_w 2694
    //   716: aload 11
    //   718: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   721: aload 6
    //   723: ldc_w 2700
    //   726: aload 9
    //   728: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   731: aload 6
    //   733: ldc_w 2702
    //   736: aload 8
    //   738: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: aload 6
    //   743: ldc_w 2704
    //   746: aload 5
    //   748: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload 6
    //   753: ldc_w 2706
    //   756: aload_2
    //   757: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload 6
    //   762: ldc_w 2708
    //   765: aload_1
    //   766: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   769: aload_3
    //   770: ldc_w 1027
    //   773: aload 6
    //   775: invokevirtual 1340	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   778: pop
    //   779: aload_0
    //   780: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   783: aload_3
    //   784: invokevirtual 216	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   787: aload_0
    //   788: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   791: ldc_w 1617
    //   794: ldc 56
    //   796: ldc 56
    //   798: ldc_w 2719
    //   801: ldc_w 2719
    //   804: iconst_0
    //   805: iconst_0
    //   806: ldc 56
    //   808: ldc 56
    //   810: ldc 56
    //   812: ldc 56
    //   814: invokestatic 203	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   817: iconst_1
    //   818: ireturn
    //   819: aload_3
    //   820: ldc_w 2717
    //   823: bipush 6
    //   825: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   828: pop
    //   829: goto -137 -> 692
    //   832: astore 9
    //   834: ldc 56
    //   836: astore_1
    //   837: ldc 56
    //   839: astore 4
    //   841: ldc 56
    //   843: astore 6
    //   845: ldc 56
    //   847: astore 5
    //   849: ldc 56
    //   851: astore 11
    //   853: ldc 56
    //   855: astore 8
    //   857: ldc 56
    //   859: astore 7
    //   861: ldc 56
    //   863: astore_2
    //   864: aload_3
    //   865: astore 10
    //   867: aload 4
    //   869: astore_3
    //   870: aload 11
    //   872: astore 4
    //   874: goto -289 -> 585
    //   877: astore 9
    //   879: ldc 56
    //   881: astore_2
    //   882: ldc 56
    //   884: astore 4
    //   886: ldc 56
    //   888: astore 8
    //   890: aload_1
    //   891: astore 7
    //   893: ldc 56
    //   895: astore_1
    //   896: ldc 56
    //   898: astore 11
    //   900: ldc 56
    //   902: astore 5
    //   904: ldc 56
    //   906: astore 6
    //   908: aload_3
    //   909: astore 10
    //   911: aload 11
    //   913: astore_3
    //   914: goto -329 -> 585
    //   917: astore 9
    //   919: ldc 56
    //   921: astore 5
    //   923: aload_2
    //   924: astore 6
    //   926: ldc 56
    //   928: astore_2
    //   929: ldc 56
    //   931: astore 4
    //   933: ldc 56
    //   935: astore 8
    //   937: aload_1
    //   938: astore 7
    //   940: ldc 56
    //   942: astore_1
    //   943: ldc 56
    //   945: astore 11
    //   947: aload_3
    //   948: astore 10
    //   950: aload 11
    //   952: astore_3
    //   953: goto -368 -> 585
    //   956: astore 10
    //   958: aload 15
    //   960: astore 8
    //   962: aload_1
    //   963: astore 9
    //   965: aload 12
    //   967: astore_1
    //   968: aload 11
    //   970: astore 6
    //   972: aload 10
    //   974: astore 11
    //   976: aload_2
    //   977: astore 12
    //   979: aload 7
    //   981: astore_2
    //   982: aload_3
    //   983: astore 10
    //   985: aload 6
    //   987: astore_3
    //   988: aload 12
    //   990: astore 6
    //   992: aload 9
    //   994: astore 7
    //   996: aload 11
    //   998: astore 9
    //   1000: goto -415 -> 585
    //   1003: astore 9
    //   1005: ldc 56
    //   1007: astore_1
    //   1008: ldc 56
    //   1010: astore 4
    //   1012: ldc 56
    //   1014: astore 6
    //   1016: ldc 56
    //   1018: astore 5
    //   1020: ldc 56
    //   1022: astore 11
    //   1024: ldc 56
    //   1026: astore 8
    //   1028: ldc 56
    //   1030: astore 7
    //   1032: ldc 56
    //   1034: astore_2
    //   1035: aload_3
    //   1036: astore 10
    //   1038: aload 4
    //   1040: astore_3
    //   1041: aload 11
    //   1043: astore 4
    //   1045: goto -522 -> 523
    //   1048: astore 9
    //   1050: ldc 56
    //   1052: astore_2
    //   1053: ldc 56
    //   1055: astore 4
    //   1057: ldc 56
    //   1059: astore 8
    //   1061: aload_1
    //   1062: astore 7
    //   1064: ldc 56
    //   1066: astore_1
    //   1067: ldc 56
    //   1069: astore 11
    //   1071: ldc 56
    //   1073: astore 5
    //   1075: ldc 56
    //   1077: astore 6
    //   1079: aload_3
    //   1080: astore 10
    //   1082: aload 11
    //   1084: astore_3
    //   1085: goto -562 -> 523
    //   1088: astore 9
    //   1090: ldc 56
    //   1092: astore 5
    //   1094: aload_2
    //   1095: astore 6
    //   1097: ldc 56
    //   1099: astore_2
    //   1100: ldc 56
    //   1102: astore 4
    //   1104: ldc 56
    //   1106: astore 8
    //   1108: aload_1
    //   1109: astore 7
    //   1111: ldc 56
    //   1113: astore_1
    //   1114: ldc 56
    //   1116: astore 11
    //   1118: aload_3
    //   1119: astore 10
    //   1121: aload 11
    //   1123: astore_3
    //   1124: goto -601 -> 523
    //   1127: astore 9
    //   1129: aload_1
    //   1130: astore 7
    //   1132: aload 13
    //   1134: astore_1
    //   1135: aload_2
    //   1136: astore 11
    //   1138: aload 8
    //   1140: astore_2
    //   1141: aload 6
    //   1143: astore 5
    //   1145: aload_3
    //   1146: astore 10
    //   1148: aload 16
    //   1150: astore 8
    //   1152: aload 14
    //   1154: astore_3
    //   1155: aload 11
    //   1157: astore 6
    //   1159: goto -636 -> 523
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1162	0	this	bheh
    //   47	1088	1	localObject1	Object
    //   61	1080	2	localObject2	Object
    //   33	1122	3	localObject3	Object
    //   75	1028	4	localObject4	Object
    //   87	1057	5	localObject5	Object
    //   107	1051	6	localObject6	Object
    //   83	1048	7	localObject7	Object
    //   103	1048	8	localObject8	Object
    //   132	334	9	str1	String
    //   488	36	9	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   530	1	9	localObject9	Object
    //   550	36	9	localNullPointerException1	java.lang.NullPointerException
    //   592	135	9	localObject10	Object
    //   832	1	9	localNullPointerException2	java.lang.NullPointerException
    //   877	1	9	localNullPointerException3	java.lang.NullPointerException
    //   917	1	9	localNullPointerException4	java.lang.NullPointerException
    //   963	36	9	localObject11	Object
    //   1003	1	9	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   1048	1	9	localUnsupportedEncodingException3	UnsupportedEncodingException
    //   1088	1	9	localUnsupportedEncodingException4	UnsupportedEncodingException
    //   1127	1	9	localUnsupportedEncodingException5	UnsupportedEncodingException
    //   14	935	10	localObject12	Object
    //   956	17	10	localNullPointerException5	java.lang.NullPointerException
    //   983	164	10	localObject13	Object
    //   95	1061	11	localObject14	Object
    //   79	910	12	localObject15	Object
    //   99	1034	13	str2	String
    //   2	1151	14	localObject16	Object
    //   91	868	15	str3	String
    //   111	1038	16	str4	String
    //   10	436	17	str5	String
    //   18	435	18	str6	String
    //   6	458	19	str7	String
    //   437	6	20	str8	String
    // Exception table:
    //   from	to	target	type
    //   20	34	488	java/io/UnsupportedEncodingException
    //   20	34	550	java/lang/NullPointerException
    //   34	48	832	java/lang/NullPointerException
    //   48	62	877	java/lang/NullPointerException
    //   62	77	917	java/lang/NullPointerException
    //   113	134	956	java/lang/NullPointerException
    //   174	195	956	java/lang/NullPointerException
    //   235	256	956	java/lang/NullPointerException
    //   296	317	956	java/lang/NullPointerException
    //   357	378	956	java/lang/NullPointerException
    //   418	439	956	java/lang/NullPointerException
    //   34	48	1003	java/io/UnsupportedEncodingException
    //   48	62	1048	java/io/UnsupportedEncodingException
    //   62	77	1088	java/io/UnsupportedEncodingException
    //   113	134	1127	java/io/UnsupportedEncodingException
    //   174	195	1127	java/io/UnsupportedEncodingException
    //   235	256	1127	java/io/UnsupportedEncodingException
    //   296	317	1127	java/io/UnsupportedEncodingException
    //   357	378	1127	java/io/UnsupportedEncodingException
    //   418	439	1127	java/io/UnsupportedEncodingException
  }
  
  private boolean aT()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("focus_item");
    TroopUtils.openTroopSetting(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str1, str2);
    return true;
  }
  
  private boolean aU()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("troopuin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      return false;
    }
    azry.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str1, str2, 9, -1);
    return true;
  }
  
  private boolean aV()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QRJumpActivity.class);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_JavaLangString;
    }
    localIntent.putExtra("url", (String)localObject);
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("attr_original_url");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localIntent.putExtra("attr_original_url", (String)localObject);
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if ((localObject != null) && (((Intent)localObject).hasExtra("fromQrcode"))) {
        localIntent.putExtra("fromQrcode", ((Intent)localObject).getBooleanExtra("fromQrcode", false));
      }
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean aW()
  {
    if ("webview".equals(this.jdField_d_of_type_JavaLangString))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bus_type");
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "photo").putExtra("doCallBack", true).putExtra("src_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type")).putExtra("callback_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type")).putExtra("callback_name", (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name")));
    }
    return true;
  }
  
  private boolean aX()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label110:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label110;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    localBundle.putString("pkg_sig", this.jdField_f_of_type_JavaLangString);
    localBundle.putInt("action", 3);
    localIntent.putExtra("key_params", localBundle);
    aeow.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
    return true;
  }
  
  private boolean aY()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label110:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label110;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    localBundle.putString("pkg_sig", this.jdField_f_of_type_JavaLangString);
    localBundle.putInt("action", 1);
    localIntent.putExtra("key_params", localBundle);
    aeow.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
    return true;
  }
  
  private boolean aZ()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BindGroupActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("skey", ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label163:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label163;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("key_params", localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean aa()
  {
    if (QLog.isColorLevel()) {
      axql.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyActivity.class);
    localIntent.putExtra("TAB_TYPE", 1);
    String str2;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("src_type")) {
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    }
    for (;;)
    {
      String str4;
      label107:
      String str5;
      label135:
      String str1;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("web_url"))
      {
        str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("web_url");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
          break label758;
        }
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
          break label765;
        }
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
        label163:
        localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
        localIntent.putExtra("fromWhere", str2);
        localIntent.putExtra("webUrl", str4);
        localIntent.putExtra("fromType", str1);
        localIntent.putExtra("FROM_WHERE", 1);
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("neighbor_list_source")) {}
      }
      try
      {
        i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("neighbor_list_source"));
        localIntent.putExtra("neighbor_list_source", i1);
        if ("10002".equals(str5))
        {
          localIntent.putExtra("abp_flag", true);
          localIntent.addFlags(268435456);
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter"))
        {
          str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter");
          if ("1".equals(str2))
          {
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_gender")) {
              break label791;
            }
            str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time")) {
              break label798;
            }
            str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
              break label805;
            }
            str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_xingzuo")) {
              break label812;
            }
            str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_xingzuo");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_interest")) {
              break label819;
            }
            str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_interest");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
              break label826;
            }
            str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
              break label833;
            }
            str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_location");
          }
        }
      }
      catch (Exception localException6)
      {
        try
        {
          i1 = Integer.valueOf(str4).intValue();
        }
        catch (Exception localException6)
        {
          try
          {
            i2 = Integer.valueOf(str5).intValue();
          }
          catch (Exception localException6)
          {
            try
            {
              i3 = Integer.valueOf(str6).intValue();
            }
            catch (Exception localException6)
            {
              try
              {
                i4 = Integer.valueOf(str7).intValue();
              }
              catch (Exception localException6)
              {
                try
                {
                  i5 = Integer.valueOf(str9).intValue();
                }
                catch (Exception localException6)
                {
                  try
                  {
                    for (;;)
                    {
                      i6 = Integer.valueOf(str8).intValue();
                      localIntent.putExtra("filter", str2);
                      localIntent.putExtra("filterGender", i1);
                      localIntent.putExtra("filter_time", i2);
                      localIntent.putExtra("filter_age", i3);
                      localIntent.putExtra("filter_xingzuo", i4);
                      localIntent.putExtra("filter_interest", i6);
                      localIntent.putExtra("filter_career", i5);
                      localIntent.putExtra("filter_location", str10);
                      localIntent.addFlags(67108864);
                      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
                        localIntent.addFlags(268435456);
                      }
                      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
                      if ("100".equals(str1)) {
                        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007244", "0X8007244", 0, 0, "", "", "", "");
                      }
                      return true;
                      str2 = "";
                      break;
                      str4 = "";
                      break label107;
                      label758:
                      str5 = "";
                      break label135;
                      label765:
                      str1 = "";
                      break label163;
                      localException1 = localException1;
                      localException1.printStackTrace();
                      int i1 = 0;
                      continue;
                      String str3 = "";
                      continue;
                      label791:
                      str4 = "";
                      continue;
                      label798:
                      str5 = "";
                      continue;
                      label805:
                      String str6 = "";
                      continue;
                      label812:
                      String str7 = "";
                      continue;
                      label819:
                      String str8 = "";
                      continue;
                      label826:
                      String str9 = "";
                      continue;
                      label833:
                      String str10 = "";
                      continue;
                      localException2 = localException2;
                      i1 = 0;
                      continue;
                      localException3 = localException3;
                      int i2 = 3;
                      continue;
                      localException4 = localException4;
                      int i3 = 0;
                      continue;
                      localException5 = localException5;
                      int i4 = 0;
                      continue;
                      localException6 = localException6;
                      int i5 = 0;
                    }
                  }
                  catch (Exception localException7)
                  {
                    for (;;)
                    {
                      int i6 = 0;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean ab()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("groupCode"))
        {
          String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupCode");
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("groupMemberUin"))
          {
            str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupMemberUin");
            Intent localIntent = new Intent();
            localIntent.putExtra("troop_uin", str1);
            localIntent.putExtra("member_uin", str3);
            PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, TroopMemberHistoryFragment.class);
            return true;
          }
          String str3 = "";
          continue;
        }
        String str2 = "";
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, localException.toString());
        }
        return false;
      }
    }
  }
  
  private boolean ac()
  {
    HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, false);
    return true;
  }
  
  private boolean ad()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hotnamecode")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hotnamecode"); TextUtils.isEmpty(str); str = "")
    {
      QQToast.a(BaseApplicationImpl.getContext(), anvx.a(2131705379), 1).a();
      return false;
    }
    NearbyTransitActivity.a(this.jdField_a_of_type_AndroidContentContext, str, 1, this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  /* Error */
  private boolean ae()
  {
    // Byte code:
    //   0: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +18 -> 21
    //   6: ldc 111
    //   8: iconst_1
    //   9: anewarray 4	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: ldc_w 2847
    //   17: aastore
    //   18: invokestatic 2173	axql:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aload_0
    //   22: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   25: ldc_w 2849
    //   28: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   31: ifeq +224 -> 255
    //   34: aload_0
    //   35: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   38: ldc_w 2849
    //   41: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 45	java/lang/String
    //   47: invokestatic 2488	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   55: ldc_w 937
    //   58: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   61: ifeq +189 -> 250
    //   64: aload_0
    //   65: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   68: ldc_w 937
    //   71: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: checkcast 45	java/lang/String
    //   77: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   80: istore_1
    //   81: new 134	android/content/Intent
    //   84: dup
    //   85: aload_0
    //   86: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   89: ldc_w 1191
    //   92: invokespecial 212	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   95: astore_3
    //   96: aload_3
    //   97: ldc_w 1208
    //   100: iconst_1
    //   101: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   104: pop
    //   105: aload_3
    //   106: ldc_w 1202
    //   109: getstatic 1206	com/tencent/mobileqq/activity/home/MainFragment:jdField_b_of_type_Int	I
    //   112: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   115: pop
    //   116: aload_3
    //   117: ldc_w 1196
    //   120: invokevirtual 1200	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   123: pop
    //   124: aload_0
    //   125: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   128: ldc_w 937
    //   131: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   134: ifeq +12 -> 146
    //   137: aload_3
    //   138: ldc_w 937
    //   141: iload_1
    //   142: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   145: pop
    //   146: aload_0
    //   147: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   150: ldc_w 2849
    //   153: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   156: ifeq +12 -> 168
    //   159: aload_3
    //   160: ldc_w 2849
    //   163: iload_2
    //   164: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   167: pop
    //   168: aload_0
    //   169: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   172: instanceof 1191
    //   175: ifeq +41 -> 216
    //   178: aload_0
    //   179: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   182: checkcast 1191	com/tencent/mobileqq/activity/SplashActivity
    //   185: astore 4
    //   187: aload_3
    //   188: ldc_w 2851
    //   191: iconst_1
    //   192: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   195: pop
    //   196: aload 4
    //   198: aload_3
    //   199: invokevirtual 2853	com/tencent/mobileqq/activity/SplashActivity:b	(Landroid/content/Intent;)V
    //   202: iconst_1
    //   203: ireturn
    //   204: astore_3
    //   205: iconst_0
    //   206: istore_2
    //   207: aload_3
    //   208: invokevirtual 1188	java/lang/Exception:printStackTrace	()V
    //   211: iconst_0
    //   212: istore_1
    //   213: goto -132 -> 81
    //   216: aload_0
    //   217: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   220: aload_3
    //   221: invokevirtual 216	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   224: aload_0
    //   225: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   228: instanceof 160
    //   231: ifeq -29 -> 202
    //   234: aload_0
    //   235: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   238: checkcast 160	android/app/Activity
    //   241: invokevirtual 2854	android/app/Activity:finish	()V
    //   244: iconst_1
    //   245: ireturn
    //   246: astore_3
    //   247: goto -40 -> 207
    //   250: iconst_0
    //   251: istore_1
    //   252: goto -171 -> 81
    //   255: iconst_0
    //   256: istore_2
    //   257: goto -206 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	bheh
    //   80	172	1	i1	int
    //   50	207	2	bool	boolean
    //   95	104	3	localIntent	Intent
    //   204	17	3	localException1	Exception
    //   246	1	3	localException2	Exception
    //   185	12	4	localSplashActivity	SplashActivity
    // Exception table:
    //   from	to	target	type
    //   21	51	204	java/lang/Exception
    //   51	81	246	java/lang/Exception
  }
  
  private boolean af()
  {
    return true;
  }
  
  private boolean ag()
  {
    return true;
  }
  
  private boolean ah()
  {
    return true;
  }
  
  private boolean ai()
  {
    Intent localIntent2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
    String str = localIntent2.getStringExtra("uin");
    Intent localIntent1;
    long l2;
    long l1;
    if (bhbx.b(str))
    {
      localIntent1 = new Intent();
      localIntent1.putExtra("uin", str);
      localIntent1.putExtra("uintype", localIntent2.getIntExtra("uintype", -1));
      l2 = 0L;
      l1 = l2;
    }
    try
    {
      if (!TextUtils.isEmpty(b("msg_uniseq"))) {
        l1 = Long.valueOf(b("msg_uniseq")).longValue();
      }
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastC2CPicMsgPath(str, "chatimg", l1);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoSetAvator path:" + str + "msg uniseq:" + l1);
      }
      int i1 = Math.min(482, bhaa.a((Activity)this.jdField_a_of_type_AndroidContentContext));
      localIntent1.putExtra("Business_Origin", 100);
      localIntent1.putExtra("open_chatfragment", true);
      localIntent1.putExtra("open_chat_from_avator", true);
      PhotoUtils.startPhotoEdit(localIntent1, (Activity)this.jdField_a_of_type_AndroidContentContext, SplashActivity.class.getName(), i1, i1, 1080, 1080, str, aoks.a());
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800723E", "0X800723E", 0, 0, "", "", "", "");
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("JumpAction", 1, "NumberFormatException uniseq:" + b("msg_uniseq"));
        l1 = l2;
      }
    }
  }
  
  private boolean aj()
  {
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("set_uri_list"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    ArrayList localArrayList = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getParcelableArrayListExtra("android.intent.extra.STREAM");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, FavEmosmManageActivity.class);
    localIntent.addFlags(335544320);
    localIntent.putExtra("key_from_sdk_set_emotion", true);
    localIntent.putParcelableArrayListExtra("key_from_sdk_set_emotion_uri", localArrayList);
    localIntent.putExtra("pkg_name", this.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(str1)) {
      localIntent.putExtra("key_from_sdk_set_emotion_appname", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      localIntent.putExtra("key_from_sdk_set_emotion_share_id", str2);
    }
    if (!TextUtils.isEmpty(str3)) {
      localIntent.putExtra("key_from_sdk_set_emotion_open_id", str3);
    }
    if (!TextUtils.isEmpty(str4)) {
      localIntent.putExtra("key_from_sdk_set_emotion_uri_list", str4);
    }
    if (!TextUtils.isEmpty(str5)) {
      localIntent.putExtra("sdk_version", str5);
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoSDKSetEmotion:sdk appName=" + str1 + " shareId=" + str2 + ", openId =" + str3 + ", setPathList =" + str4);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean ak()
  {
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("set_uri"));
    QLog.d("JumpAction", 1, new Object[] { "-->gotoSDKSetAvator setUri=", str1 });
    if (!TextUtils.isEmpty(str1)) {
      return a(new JumpAction.5(this), str1, "set_uri", "set_path");
    }
    str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("set_path"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("key_request_code", 0);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_from_sdk_set_avatar", true);
    localBundle.putString("key_from_sdk_set_avatar_path", str4);
    localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(str1)) {
      localBundle.putString("key_from_sdk_set_avatar_appname", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      localBundle.putString("key_from_sdk_set_avatar_share_id", str2);
    }
    if (!TextUtils.isEmpty(str3)) {
      localBundle.putString("key_from_sdk_set_avatar_open_id", str3);
    }
    if (!TextUtils.isEmpty(str5)) {
      localBundle.putString("sdk_version", str5);
    }
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoSDKSetAvator:sdk appName=" + str1 + " shareId=" + str2 + ", openId =" + str3 + ", setPath =" + str4 + ", sdkVersion =" + str5);
    }
    ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, localAllInOne, localBundle);
    return true;
  }
  
  private boolean al()
  {
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_uri"));
    QLog.d("JumpAction", 1, new Object[] { "-->gotoSDKSetDynamicAvatar videoUri=", str1 });
    if (!TextUtils.isEmpty(str1)) {
      return a(new JumpAction.6(this), str1, "video_uri", "video_path");
    }
    str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_path"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, new Object[] { "[gotoSDKSetDynamicAvatar] appName=", str1 });
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DF9", "0X8009DF9", 0, 0, str2, "", "", "");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SelectCoverActivity.class);
    localIntent.putExtra("param_source", 3);
    localIntent.putExtra("param_from_newer_guide", false);
    localIntent.putExtra("key_video_file_path", str4);
    localIntent.putExtra("pkg_name", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("app_name", str1);
    localIntent.putExtra("share_id", str2);
    localIntent.putExtra("open_id", str3);
    localIntent.putExtra("sdk_version", str5);
    localIntent.addFlags(335544320);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean am()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, RecommendFriendActivity.class);
    localIntent.putExtra("EntranceId", 7);
    localIntent.putExtra("from_babyq", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007243", "0X8007243", 0, 0, "", "", "", "");
    return true;
  }
  
  private boolean an()
  {
    Intent localIntent = new Intent();
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, SearchMightKnowFragment.class);
    return true;
  }
  
  private boolean ao()
  {
    Intent localIntent = new Intent();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
    if ((!TextUtils.isEmpty(str)) && (b(str))) {}
    for (int i1 = Integer.valueOf(str).intValue();; i1 = 0)
    {
      localIntent.putExtra("jumpFromType", i1);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoShowNewFriends " + i1);
      }
      NewFriendActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, 9);
      return true;
    }
  }
  
  private boolean ap()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (b((String)localObject))) {}
    for (int i1 = Integer.valueOf((String)localObject).intValue();; i1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoShowContactsTab " + i1);
      }
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      ((Intent)localObject).setFlags(67108864);
      ((Intent)localObject).putExtra("jumpFromType", i1);
      ((Intent)localObject).putExtra("tab_index", MainFragment.d);
      ((Intent)localObject).putExtra("fragment_id", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
    }
  }
  
  private boolean aq()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ContactBindedActivity.class);
    localIntent.putExtra("from_babyq", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean ar()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"); !str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()); str = "")
    {
      m();
      return false;
    }
    n();
    return false;
  }
  
  private boolean as()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("leftBackText", anvx.a(2131705391));
    ((Bundle)localObject).putBoolean("isBack2Root", true);
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.putExtras((Bundle)localObject);
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("txt");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      localIntent.putExtra("JumpAction.Text", c((String)localObject));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean at()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    QWalletHelper.launchQWalletAct((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false);
    return true;
  }
  
  private boolean au()
  {
    try
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
      int i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"));
      if (str == null) {
        return false;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      localIntent.setFlags(335544320);
      localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      localIntent.putExtra("openid", str);
      localIntent.putExtra("appid", i1);
      localIntent.putExtra("source", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "Receive error appid number format");
      }
    }
    return false;
  }
  
  private boolean av()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_id");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_id");
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_path"));
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_type"));
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A519", "0X800A519", 0, 0, "", "", str4, str2);
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A51B", "0X800A51B", 0, 0, "", "", str4, str2);
      QLog.e("JumpAction", 1, "connectMiniApp fail: packageName is empty");
      return true;
    }
    if ("mini_program_or_game".equals(localObject))
    {
      if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131698957, 1).a();
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).addFlags(268435456);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        return true;
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JumpAction.11(this), 20000L);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JumpAction.12(this), 500L);
      try
      {
        this.jdField_i_of_type_Boolean = true;
        boolean bool;
        MessageHandler localMessageHandler;
        if (!TextUtils.isEmpty(str1))
        {
          bool = true;
          auuv.a("KEY_STAGE_2_CONNECT_MINI_D55");
          localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
          if (str1 != null) {
            break label441;
          }
        }
        label441:
        for (localObject = "";; localObject = str1)
        {
          localMessageHandler.a(bool, (String)localObject, true, Long.valueOf(str2).longValue(), Long.valueOf(str4).longValue(), 1, Integer.valueOf(str3).intValue(), this.jdField_e_of_type_JavaLangString, false, 0L, new bhej(this, str4, str2, str5, str6, str1, str7));
          return false;
          bool = false;
          break;
        }
        return true;
      }
      catch (Exception localException)
      {
        if (this.jdField_i_of_type_Boolean)
        {
          this.jdField_i_of_type_Boolean = false;
          c();
        }
        QLog.e("JumpAction", 1, "checkAppSignAndOpenidDiff exception: " + localException.getMessage());
        return true;
      }
    }
  }
  
  private boolean aw()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    Object localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    String str9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id"));
    String str11 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_pkg_name"));
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("reply_content");
    String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("reply_time");
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, String.format("gotoChat [uin,type,replyContent,replyTime]=[%s,%s,%s,%s]", new Object[] { str2, localObject3, str6, str7 }));
    }
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("panel");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("params");
    if ((str4 != null) && (QLog.isDevelopLevel())) {
      QLog.d("JumpAction", 4, str4 + "");
    }
    localObject1 = null;
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject1 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    }
    boolean bool1;
    int i1;
    if ("c2c".equals(localObject3))
    {
      if ((str2 == null) || (str2.length() < 5))
      {
        bool1 = false;
        return bool1;
      }
      if (((anvk)localObject1).b(str2))
      {
        localObject3 = ContactUtils.getFriendNick(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
        if ("chat".equals(str8))
        {
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
          ((Intent)localObject1).putExtra("uin", str2);
          ((Intent)localObject1).putExtra("uintype", 0);
          if (localObject3 != null) {
            ((Intent)localObject1).putExtra("uinname", (String)localObject3);
          }
          if (!TextUtils.isEmpty(str6))
          {
            ((Intent)localObject1).putExtra("key_aio_reply_content", str6);
            ((Intent)localObject1).putExtra("key_aio_reply_time", str7);
          }
          ((Intent)localObject1).addFlags(67108864);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007191", "0X8007191", 0, 0, "", "", "", "");
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    else if ("discuss".equals(localObject3))
    {
      if ((str2 == null) || (str2.length() < 6)) {
        return false;
      }
      localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("discuss_info");
      i1 = 3000;
      localObject2 = null;
      localObject1 = null;
    }
    for (;;)
    {
      localObject4 = AIOUtils.setOpenAIOIntent(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
      ((Intent)localObject4).putExtra("uin", str2);
      ((Intent)localObject4).putExtra("uintype", i1);
      if (localObject3 != null) {
        ((Intent)localObject4).putExtra("uinname", (String)localObject3);
      }
      if (str5 != null) {
        ((Intent)localObject4).putExtra("input_text", str5);
      }
      if (!TextUtils.isEmpty(str6))
      {
        ((Intent)localObject4).putExtra("key_aio_reply_content", str6);
        ((Intent)localObject4).putExtra("key_aio_reply_time", str7);
      }
      if ((localObject1 != null) && (localObject1.length > 0)) {
        ((Intent)localObject4).putExtra((String)localObject2, (byte[])localObject1);
      }
      if ((str4 != null) && (!"".equals(str4))) {
        if ((str2 == null) || ("".equals(str2)))
        {
          return false;
          if ("group".equals(localObject3))
          {
            if ((str2 == null) || (str2.length() < 6)) {
              return false;
            }
            localObject1 = ((TroopManager)localObject2).b(str2);
            if (localObject1 != null)
            {
              localObject3 = ((TroopInfo)localObject1).getTroopName();
              i1 = 1;
              localObject2 = null;
              localObject1 = null;
              continue;
            }
            return false;
          }
          if ("robot".equals(localObject3))
          {
            if ((str2 == null) || ("".equals(str2))) {
              return false;
            }
            localObject3 = ContactUtils.getFriendNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            i1 = 1001;
            localObject2 = null;
            localObject1 = null;
            continue;
          }
          if ("wpa".equals(localObject3))
          {
            if ((str2 == null) || (str2.length() < 5) || (str2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              return false;
            }
            if (((anvk)localObject1).b(str2)) {
              i1 = 0;
            }
            for (localObject1 = ContactUtils.getFriendNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);; localObject1 = null)
            {
              a(str2);
              localObject3 = localObject1;
              localObject2 = null;
              localObject1 = null;
              break;
              i1 = 1005;
            }
          }
          if ("crm".equals(localObject3))
          {
            boolean bool2 = aA();
            bool1 = bool2;
            if (!bool2) {
              bool1 = ax();
            }
            bool2 = bool1;
            if (!bool1) {
              bool2 = ay();
            }
            bool1 = bool2;
            if (bool2) {
              break;
            }
            return az();
          }
          if (("lbs".equals(localObject3)) || ("date".equals(localObject3)))
          {
            if ((str2 == null) || (str2.length() < 5) || (str2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              return false;
            }
            if (((anvk)localObject1).b(str2))
            {
              i1 = 0;
              localObject3 = ContactUtils.getFriendNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
              localObject2 = null;
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject2 != null) && (localObject4 != null))
        {
          localObject1 = HexUtil.hexStr2Bytes((String)localObject4);
          break;
          if ("lbs".equals(localObject3))
          {
            i1 = 1001;
            localObject3 = ContactUtils.getDateNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            localObject2 = "rich_accost_sig";
          }
          else
          {
            i1 = 1010;
            localObject3 = ContactUtils.getDateNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            localObject2 = "rich_date_sig";
            continue;
            if ("public_account".equals(localObject3))
            {
              if ((str2 == null) || (str2.length() < 6)) {
                return false;
              }
              localObject1 = uuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
              olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", str2, "0X800589E", "0X800589E", 0, 0, str2, "", "", "", false);
              localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
              ((Intent)localObject2).putExtra("uin", str2);
              ((Intent)localObject2).putExtra("uintype", 1008);
              if (localObject1 != null) {
                ((Intent)localObject2).putExtra("uinname", (String)localObject1);
              }
              if (("2747277822".equals(str2)) && (aveq.a())) {
                aves.a(this.jdField_a_of_type_AndroidContentContext);
              }
              for (;;)
              {
                return true;
                if (MiniGamePublicAccountHelper.shouldOpenWebFragment(str2)) {
                  MiniGamePublicAccountHelper.launchMiniGamePublicAccount(this.jdField_a_of_type_AndroidContentContext);
                } else if ("3046055438".equals(str2)) {
                  oph.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
                } else if (ayoq.jdField_a_of_type_JavaLangString.equals(str2))
                {
                  if (!ayos.a(this.jdField_a_of_type_AndroidContentContext, str2, 3)) {
                    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
                  }
                }
                else if ((AppConstants.QQ_VIP_UIN.equals(str2)) && (bhsf.b(this.jdField_a_of_type_AndroidContentContext))) {
                  bhsf.b(this.jdField_a_of_type_AndroidContentContext);
                } else if ((ahcf.a(str2)) && (amfb.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
                  QLog.i("JumpAction", 1, "gotoChat startNewWeatherWebPageActivity");
                } else if (!QQComicConfBean.a().a(str2, this.jdField_a_of_type_AndroidContentContext, 1005, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
                }
              }
            }
            if ("qd_account".equals(localObject3))
            {
              if ((str2 == null) || (str2.length() < 6)) {
                return false;
              }
              localObject1 = AIOUtils.setOpenAIOIntent(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
              ((Intent)localObject1).putExtra("uin", str2);
              ((Intent)localObject1).putExtra("uintype", 1008);
              localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("key");
              localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("kfuin");
              str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assign_type");
              str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assign_key");
              str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("ext");
              str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rkey");
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "QD_ACCOUNT_TYPE " + (String)localObject3 + " " + str2 + " " + str3 + " " + str4 + " " + str5);
              }
              if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
                return false;
              }
              ((Intent)localObject1).putExtra("qd_wpa_key", (String)localObject2);
              ((Intent)localObject1).putExtra("qd_kfuin", (String)localObject3);
              if (!TextUtils.isEmpty(str2)) {
                ((Intent)localObject1).putExtra("assign_type", str2);
              }
              if (!TextUtils.isEmpty(str3)) {
                ((Intent)localObject1).putExtra("assign_key", str3);
              }
              if (!TextUtils.isEmpty(str4)) {
                ((Intent)localObject1).putExtra("assign_ext", str4);
              }
              if (!TextUtils.isEmpty(str5)) {
                ((Intent)localObject1).putExtra("rkey", str5);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
              return true;
            }
            if (("thirdparty2c".equals(localObject3)) || ("audio_chat".equals(localObject3)) || ("video_chat".equals(localObject3)))
            {
              if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131698952, 1).a();
                localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).addFlags(268435456);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                return true;
              }
              if (!TextUtils.isEmpty(str9))
              {
                this.jdField_a_of_type_AndroidOsHandler = new Handler();
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JumpAction.14(this), 20000L);
                try
                {
                  if ("thirdparty2c".equals(localObject3)) {
                    i1 = 18;
                  }
                  for (;;)
                  {
                    auuv.a("KEY_STAGE_2_GO_TO_CHAT_D55");
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(true, str9, false, 0L, Long.valueOf(str10).longValue(), 1, i1, str11, false, 0L, new bhek(this, str9, str10, (String)localObject3));
                    return false;
                    if ("audio_chat".equals(localObject3))
                    {
                      i1 = 19;
                    }
                    else
                    {
                      bool1 = "video_chat".equals(localObject3);
                      if (bool1) {
                        i1 = 19;
                      } else {
                        i1 = 10000;
                      }
                    }
                  }
                  return true;
                }
                catch (Exception localException)
                {
                  return true;
                }
              }
            }
            return false;
            str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type");
            localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("thirdAppDisplayName"));
            localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
            if ((str1 != null) && (!"".equals(str1))) {
              ((Intent)localObject4).putExtra("callback_type", str1);
            }
            if ((localObject2 != null) && (!"".equals(localObject2))) {
              ((Intent)localObject4).putExtra("thirdAppDisplayName", (String)localObject2);
            }
            if ((localObject3 != null) && (!"".equals(localObject3))) {
              ((Intent)localObject4).putExtra("appid", (String)localObject3);
            }
            a((Intent)localObject4, str4);
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B4B", "0X8004B4B", 0, 0, "", "", "", "");
            if ("webview".equals(this.jdField_d_of_type_JavaLangString))
            {
              ((Intent)localObject4).putExtra("from", this.jdField_d_of_type_JavaLangString);
              if (jdField_a_of_type_Int > 3)
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131705374), 1).a();
                return true;
              }
              jdField_a_of_type_Int += 1;
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B5A", "0X8004B5A", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              if (str3 != null) {
                ((Intent)localObject4).putExtra("panel", str3);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
              return true;
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B58", "0X8004B58", 0, 0, "", "", "", "");
            }
          }
        }
      }
      String str1 = null;
      continue;
      localObject2 = null;
      i1 = 0;
      str1 = null;
    }
  }
  
  private boolean ax()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpaType");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assignId");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("QidianSigT");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("QidianKfUin");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rkey");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shouldReturnToRoot");
    Intent localIntent;
    String str6;
    String str7;
    boolean bool1;
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null))
    {
      try
      {
        if (!str1.equals("2")) {
          break label533;
        }
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleQidianExtWPA wpaType = 2");
        }
        localIntent = new Intent();
        if ((TextUtils.isEmpty(str5)) || (str5.equals("NO"))) {
          localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class));
        }
        for (;;)
        {
          localIntent.addFlags(67108864);
          str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
          str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
          if (str7 == null) {
            break label397;
          }
          if (str7.length() < 5) {
            break label573;
          }
          if (!str7.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            break;
          }
          return false;
          localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class));
          localIntent.putExtra("open_chatfragment", true);
        }
        bool2 = bool1;
      }
      catch (Exception localException1)
      {
        bool1 = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, localException1.getMessage());
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      return bool2;
      if (str6 != null) {
        localIntent.putExtra("sigt", HexUtil.hexStr2Bytes(str6));
      }
      if (((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str7))
      {
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("uinname", ContactUtils.getFriendNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str7));
        label377:
        localIntent.putExtra("uin", str7);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          label397:
          ((bjyi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(str4, localException1, str3, str2, (String)localObject, str5, this.jdField_a_of_type_Bjyh.jdField_a_of_type_Int);
          try
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("wpaType: ").append(localException1).append("assignId: ").append(str2).append("qidianSigt: ").append(str3).append("qidianUin: ").append(str4);
              QLog.d("JumpAction", 2, ((StringBuilder)localObject).toString());
            }
            bool2 = true;
          }
          catch (Exception localException2)
          {
            label533:
            bool1 = true;
          }
        }
        localIntent.putExtra("uintype", 1025);
        localIntent.putExtra("from_wpa_for_crm", true);
        break label377;
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleQidianExtWPA wpaType != 2");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bjyh);
      }
      break;
    }
    label573:
    return false;
  }
  
  private boolean ay()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpaType");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("assignId");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("QidianKfUin");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shouldReturnToRoot");
    if ((str1 != null) && (str2 != null) && (str3 != null) && (str4 != null) && (str5 != null)) {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bjyh);
          ((bjyi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(str5, str2, str1, str3, str4, str6);
          bool3 = true;
          bool1 = true;
          boolean bool2 = bool1;
          bool2 = bool1;
        }
        catch (Exception localException1)
        {
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.d("JumpAction", 2, "handleQidianCorpWPA");
              bool2 = bool1;
            }
            return bool2;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              boolean bool3;
              boolean bool1 = bool3;
            }
          }
          localException1 = localException1;
          bool1 = false;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("JumpAction", 2, localException1.getMessage());
          return bool1;
        }
      }
    }
    return false;
  }
  
  private boolean az()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str1 == null) || (str1.length() < 5) || (str1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      return false;
    }
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shouldReturnToRoot");
    Intent localIntent = new Intent();
    int i1;
    if ((TextUtils.isEmpty(str4)) || (str4.equals("NO")))
    {
      localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class));
      localIntent.addFlags(67108864);
      i1 = nwu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "handleLegacyCrmWPA " + i1);
      }
      localIntent.putExtra("from_wpa_for_crm", true);
      localIntent.putExtra("uin", str1);
      localIntent.putExtra("uintype", i1);
      if (i1 != 0) {
        break label403;
      }
      str4 = ContactUtils.getFriendNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      if (str4 != null) {
        localIntent.putExtra("uinname", str4);
      }
    }
    for (;;)
    {
      if (localObject != null) {
        localIntent.putExtra("input_text", (String)localObject);
      }
      if ((str3 != null) && (str1 != null))
      {
        localObject = HexUtil.hexStr2Bytes(str3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(str1, (byte[])localObject);
      }
      if (str2 != null) {
        localIntent.putExtra("sigt", HexUtil.hexStr2Bytes(str2));
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Bqq_Crm", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str1, "", "");
      return true;
      localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class));
      localIntent.putExtra("open_chatfragment", true);
      break;
      label403:
      if (i1 == 1024) {
        localIntent.putExtra("chat_subType", 1);
      }
    }
  }
  
  public static int b(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("sharefromtype");
    if (paramMap != null) {}
    try
    {
      int i1 = Integer.parseInt(paramMap);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (!QLog.isColorLevel()) {
        break label59;
      }
      QLog.e("JumpAction", 2, "makeStoryContentPageIntent, NumberFormatException, shareFromStr:" + paramMap);
    }
    return 0;
    label59:
    return 0;
  }
  
  public static int b(Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i1 = paramInt;
    if (paramMap != null) {}
    try
    {
      i1 = Integer.parseInt(paramMap);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      do
      {
        i1 = paramInt;
      } while (!QLog.isColorLevel());
      QLog.e("JumpAction", 2, "getIntAttribute, NumberFormatException, key:" + paramString + " strVal:" + paramMap);
    }
    return paramInt;
  }
  
  private Intent b()
  {
    ((wjg)wjs.a(18)).a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  private String b()
  {
    return "mqqapi://" + this.jdField_b_of_type_JavaLangString + "/" + this.jdField_c_of_type_JavaLangString + "?src_type=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
  }
  
  public static void b(Bundle paramBundle)
  {
    long l1 = paramBundle.getLong("key_launch_time");
    if (l1 > 0L)
    {
      long l2 = System.currentTimeMillis();
      QLog.d("plugin_tag", 1, "call jumpToQZoneVideoLayer timedelay=" + (l2 - l1));
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
    localIntent.setFlags(268435456);
    localIntent.putExtras(paramBundle);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public static boolean b(String paramString)
  {
    return Pattern.compile("[0-9]+").matcher(paramString).matches();
  }
  
  private boolean bA()
  {
    return true;
  }
  
  private boolean bB()
  {
    return true;
  }
  
  private boolean bC()
  {
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {}
    Object localObject2;
    for (Object localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; localObject2 = null)
    {
      Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
      String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
      try
      {
        str1 = URLDecoder.decode(str1, "UTF-8");
        str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("troopbar_id"));
      }
      catch (Exception localException3)
      {
        try
        {
          l1 = Long.parseLong((String)localObject3);
          localObject3 = new JSONObject();
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              String str5;
              ((JSONObject)localObject3).put("share_from_app", true);
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("share_img_list", str1);
              localJSONObject.put("share_title", str3);
              localJSONObject.put("share_content", str4);
              localJSONObject.put("share_app_name", localObject1);
              localJSONObject.put("share_app_id", l1);
              ((JSONObject)localObject3).put("share_info", localJSONObject);
              ((JSONObject)localObject3).put("bid", str5);
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopBarPublishActivity.class);
              ((Intent)localObject1).addFlags(268435456);
              ((Intent)localObject1).putExtra("options", ((JSONObject)localObject3).toString());
              ((Intent)localObject1).putExtra("pkg_name", this.jdField_e_of_type_JavaLangString);
              com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
              return true;
              localException2 = localException2;
              String str2 = "";
            }
            localException3 = localException3;
            long l1 = 0L;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "gotoTroopBarShareMsg Exception:" + localException1.toString());
              }
            }
          }
        }
      }
    }
  }
  
  private boolean bD()
  {
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if (TextUtils.isEmpty(str)) {
      str = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      absy.a().a(1);
      absy.a().jdField_a_of_type_JavaLangString = "";
      absy.a().jdField_a_of_type_Int = 0;
      absy.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 2);
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        DeviceScanner.openDeviceQCodeUrl((Activity)this.jdField_a_of_type_AndroidContentContext, null, str);
      }
      return true;
    }
  }
  
  private boolean bE()
  {
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      try
      {
        localObject1 = bkyp.a((String)localObject1);
        if (((Map)localObject1).get("public_device") != null)
        {
          i1 = 1;
          localObject2 = bkyp.b((String)((Map)localObject1).get("args"));
          localObject1 = (String)((Map)localObject2).get("sn");
          localObject2 = (String)((Map)localObject2).get("pid");
          if ((i1 != 0) && ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))))
          {
            bjkv.a().a(this.jdField_a_of_type_AndroidContentContext.getString(2131719903));
            return true;
          }
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, DevicePluginDownloadActivity.class);
          localIntent.putExtra("DevicePID", (String)localObject2);
          localIntent.putExtra("DeviceSN", (String)localObject1);
          localIntent.putExtra("DeviceToken", "");
          localIntent.putExtra("public_device", i1);
          localIntent.putExtra("from", "share");
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
          return true;
        }
      }
      catch (Exception localException)
      {
        return false;
      }
      int i1 = 0;
    }
  }
  
  private boolean bF()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.send_hong_bao", 2, "JumpAction.gotoSendHongBao(). hong_bao_id=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_id") + ", send_uin=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("send_uin") + ", hong_bao_type=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_type") + ", hong_bao_summary=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_summary"));
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("hb_id", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_id"));
    localIntent.putExtra("send_uin", (String)this.jdField_a_of_type_JavaUtilHashMap.get("send_uin"));
    localIntent.putExtra("hb_type", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_type"));
    localIntent.putExtra("forward_text", (String)this.jdField_a_of_type_JavaUtilHashMap.get("hb_summary"));
    localIntent.putExtra("forward_type", 17);
    aupt.a(this.jdField_a_of_type_AndroidContentContext, localIntent);
    return true;
  }
  
  private boolean bG()
  {
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("friendUin"));
    localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, "", 3001, 11, "", "", null, "", "");
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean bH()
  {
    Object localObject1 = new StringBuilder((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    ((StringBuilder)localObject1).append("?a=1");
    Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str1 = (String)((Iterator)localObject2).next();
      if (!"url".equals(str1))
      {
        try
        {
          String str2 = URLEncoder.encode((String)this.jdField_a_of_type_JavaUtilHashMap.get(str1), "UTF-8");
          ((StringBuilder)localObject1).append("&");
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append("=");
          ((StringBuilder)localObject1).append(str2);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
        if (QLog.isColorLevel()) {
          QLog.e("JumpAction", 1, localUnsupportedEncodingException, new Object[0]);
        }
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    if (QLog.isDevelopLevel()) {
      QLog.e("JumpAction", 4, "gotoHuayang url==" + (String)localObject1);
    }
    localObject2 = this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent((Context)localObject2, QQBrowserActivity.class);
    localIntent.setFlags(536870912);
    localIntent.putExtra("url", (String)localObject1);
    ((Context)localObject2).startActivity(localIntent);
    return true;
  }
  
  private boolean bI()
  {
    if ("open".equals(this.jdField_c_of_type_JavaLangString))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 8855);
      return true;
    }
    if ("openVideo".equalsIgnoreCase(this.jdField_c_of_type_JavaLangString))
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        return c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, null);
      }
      return false;
    }
    if ("opencontent".equals(this.jdField_c_of_type_JavaLangString)) {
      return a(this.jdField_a_of_type_JavaUtilHashMap, false);
    }
    if ("opendiscovery".equals(this.jdField_c_of_type_JavaLangString)) {
      return bK();
    }
    if ("opentopic".equals(this.jdField_c_of_type_JavaLangString)) {
      return bJ();
    }
    if ("infoCard".equals(this.jdField_c_of_type_JavaLangString)) {
      return c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    if ("sharegroupcard".equals(this.jdField_c_of_type_JavaLangString)) {
      return d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    Object localObject = new xuf((Activity)this.jdField_a_of_type_AndroidContentContext, new bheo(this));
    Intent localIntent = e(new Intent());
    if (localIntent != null)
    {
      int i1 = localIntent.getIntExtra("action", 0);
      localIntent.putExtra("action", 0);
      return ((xuf)localObject).a(i1, localIntent);
    }
    return false;
  }
  
  private boolean bJ()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname");
    d((String)this.jdField_a_of_type_JavaUtilHashMap.get("sharefromtype"));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
      return true;
    }
    return false;
  }
  
  private boolean bK()
  {
    if (!TextUtils.isEmpty(d((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api")))) {
      ykv.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      if ("1".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"))) {}
      return true;
    }
    return false;
  }
  
  private boolean bL()
  {
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().jdField_a_of_type_Boolean)
    {
      ykq.b("JumpAction", "startStoryMainActivity, isNowTabShow==true");
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.g);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.setFlags(335544320);
      localIntent = e(localIntent);
      if ((localIntent != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return true;
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ykq.e("JumpAction", "Error: context is not instanceof Activity, context is: " + String.valueOf(this.jdField_a_of_type_AndroidContentContext));
      }
      if (localIntent == null) {
        ykq.e("JumpAction", "Error: jumpIntent is null");
      }
      return false;
    }
    ykq.b("JumpAction", "startStoryMainActivity, isNowTabShow==false");
    if (((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity)) && (!BaseApplicationImpl.appMainActivityHasLanuch))
    {
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      localIntent.setFlags(335544320);
      localIntent.putExtra("jump_to_story", true);
    }
    for (;;)
    {
      localIntent = e(localIntent);
      if ((localIntent == null) || ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseApplicationImpl)))) {
        break;
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
      localIntent = b();
    }
  }
  
  private boolean bM()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity)) && ((((JumpActivity)this.jdField_a_of_type_AndroidContentContext).getIntent().getFlags() & 0x100000) != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, String.format("gotoRegisterByInvite bLaunchFromRecent=%b", new Object[] { Boolean.valueOf(bool) }));
      }
      String str;
      Intent localIntent;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("code"))
      {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("code");
        Object localObject = a();
        localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
        if (RegisterPhoneNumActivity.class != localObject) {
          break label280;
        }
        localIntent.putExtra("key_report_extra_from", 5);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localIntent.putExtra("invite_code", (String)localObject);
      }
      label280:
      for (int i1 = 1;; i1 = 0)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) && (i1 != 0) && (!bool))
        {
          localIntent.putExtra("action", 4097);
          aeow.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, TranslucentTRansferFragment.class);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096FF", "0X80096FF", 0, 0, "", "", "", "");
          return true;
          str = "";
          break;
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096FE", "0X80096FE", 0, 0, "", "", "", "");
        return true;
      }
    }
  }
  
  private boolean bN()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80077DE", "0X80077DE", 0, 0, (String)localObject, "", "", "");
    localObject = a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
    if (RegisterPhoneNumActivity.class == localObject) {
      localIntent.putExtra("key_report_extra_from", 5);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean bO()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("troopUin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("evilUin");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("selfUin");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("scene");
    int i2 = 20008;
    int i1 = i2;
    if (str4 != null) {}
    try
    {
      i1 = Integer.parseInt(str4);
      aaqo.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, str2, str1, str3, i1, null);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
  }
  
  private boolean bP()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (StringUtil.isEmpty(str)) {
      str = "0";
    }
    for (;;)
    {
      axoe localaxoe = (axoe)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppInterface().getManager(QQManagerFactory.FACE_SCORE_MANAGER);
      long l1 = Long.parseLong(str);
      localaxoe.a(l1, new bhep(this, l1));
      return true;
    }
  }
  
  private boolean bQ()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomcode");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isgroupcode");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("backtype");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extra");
    avsv localavsv = (avsv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
    try
    {
      i1 = Integer.parseInt(str3);
      QLog.i("JumpAction", 1, "[goToGroupVideoPlugin], roomId:" + str1 + ",fromId:" + str2 + " isGroupCode:" + str3);
      localavsv.a(this.jdField_a_of_type_AndroidContentContext, str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), i1, "download", str2, str4, str5, str6);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1 = 1;
      }
    }
  }
  
  private boolean bR()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    localObject = (avsv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER);
    QLog.i("JumpAction", 1, "[goToPreLoadGroupVideoPlugin]");
    ((avsv)localObject).a(null, 10L);
    return true;
  }
  
  private boolean bS()
  {
    ((bdvz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  private boolean bT()
  {
    i1 = 0;
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("guin");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!TroopInfo.isTroopMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("JumpAction", 2, new Object[] { "illegal goToTroopProfileApp jumpAction. troopUin=", localObject });
      }
      return false;
    }
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
    if ("group_file".equals(str)) {
      TroopUtils.startTroopFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject);
    }
    for (;;)
    {
      return true;
      if ("group_album".equals(str)) {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gname");
      }
      try
      {
        i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("unreadnum"));
        i1 = i2;
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        int i2;
        label154:
        break label154;
      }
      TroopUtils.gotoQZoneQun(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject, str, i1);
      continue;
      if ("group_story".equals(str)) {
        for (;;)
        {
          for (;;)
          {
            int i3;
            int i4;
            try
            {
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("troopStoryMemoriesFrom")) {
                i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("troopStoryMemoriesFrom"));
              }
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              i1 = 0;
              i2 = 0;
            }
            try
            {
              i3 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("playVideoFrom"));
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              for (;;)
              {
                label304:
                Bundle localBundle;
                i3 = 0;
                i2 = i1;
                i1 = i3;
              }
            }
            try
            {
              i4 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("lastOpenFrom"));
              i2 = i1;
              localObject = QQStoryShareGroupProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, null, (String)localObject, i2, i3);
              ((Intent)localObject).putExtra("extra_last_open_from", i4);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              i2 = i1;
              i1 = i3;
              break label304;
            }
          }
          i1 = 8;
          continue;
          i4 = 0;
          i3 = i1;
        }
      }
      if (!"bulk_send_message".equals(localNumberFormatException1)) {
        break;
      }
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gc");
      localBundle = new Bundle();
      localBundle.putString("extra.GROUP_UIN", (String)localObject);
      localBundle.putString("selfSet_leftViewText", anvx.a(2131705373));
      BulkSendMessageFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, localBundle);
    }
  }
  
  private boolean bU()
  {
    bisl localbisl = new bisl(this.jdField_a_of_type_AndroidContentContext, 0, 2131558714, 17);
    localbisl.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690190));
    localbisl.getWindow().setDimAmount(0.0F);
    localbisl.show();
    localbisl.setCanceledOnTouchOutside(true);
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app");
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.e("JumpAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen jumpAction. appName=null");
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("meta");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
    ArkAppMgr.getInstance().getAppPathByName(str1, str3, "0.0.0.1", "", new bheq(this, localbisl, str3, str2, str1));
    return true;
  }
  
  private boolean bV()
  {
    avxv localavxv = (avxv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WATCH_LIVE_TOGETHER);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if (localObject1 == null) {}
    }
    for (Object localObject1 = ((Intent)localObject1).getDataString();; localObject1 = "")
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = this.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("room_type"))
        {
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("room_type");
          localNewTogetherRoomMessageData.jdField_a_of_type_Int = Integer.parseInt(str1);
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("group_uin")) {
            break label313;
          }
          str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("group_uin");
          label128:
          localNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString = str1;
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("group_owner_uin")) {
            break label320;
          }
        }
        label313:
        label320:
        for (String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("group_owner_uin");; str1 = "0")
        {
          localNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString = str1;
          localNewTogetherRoomMessageData.jdField_e_of_type_JavaLangString = ((String)localObject1);
          localNewTogetherRoomMessageData.jdField_f_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("cover_url"));
          Object localObject2 = Uri.parse((String)localObject1);
          localObject1 = ((Uri)localObject2).getQueryParameter("roomid");
          str1 = ((Uri)localObject2).getQueryParameter("room_show_number");
          String str2 = ((Uri)localObject2).getQueryParameter("fromid");
          localObject2 = ((Uri)localObject2).getQueryParameter("room_group_code");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localNewTogetherRoomMessageData.jdField_a_of_type_Long = Integer.parseInt((String)localObject1);
          }
          if (!TextUtils.isEmpty(str1)) {
            localNewTogetherRoomMessageData.jdField_b_of_type_Int = Integer.parseInt(str1);
          }
          if (!TextUtils.isEmpty(str2)) {
            localNewTogetherRoomMessageData.g = str2;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localNewTogetherRoomMessageData.jdField_c_of_type_JavaLangString = ((String)localObject2);
          }
          localavxv.a(localNewTogetherRoomMessageData);
          return true;
          str1 = "0";
          break;
          str1 = "0";
          break label128;
        }
      }
    }
  }
  
  private boolean bW()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject1 == null) {
        break label316;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label316;
      }
    }
    label316:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("JumpAction", 2, "gotoGroupManager not admin " + str);
        }
        return false;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("troop_uin", str);
      ((Intent)localObject1).putExtra("key_is_update_before_805", TroopUtils.isUpdateBeforeSomeVersion(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
      ((Intent)localObject1).putExtra("troop_manage_from_jump_action", true);
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new bmiu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      if (localPluginCommunicationHandler != null) {
        localPluginCommunicationHandler.register((RemoteCommand)localObject2);
      }
      localObject2 = TroopBaseProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext);
      TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, (Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, (Dialog)localObject2, "com.tencent.mobileqq.activity.TroopManageActivity", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager " + str);
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "gotoGroupManager context not activity");
      }
      return false;
    }
  }
  
  private boolean ba()
  {
    System.currentTimeMillis();
    Object localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if ((localObject3 == null) || ((!((String)localObject3).startsWith("http://")) && (!((String)localObject3).startsWith("https://"))) || ((!nwo.b((String)localObject3).equalsIgnoreCase("qq.com")) && (!nwo.b((String)localObject3).equalsIgnoreCase("myun.tenpay.com")) && (!nwo.b((String)localObject3).equalsIgnoreCase("tenpay.com")) && (!nwo.b((String)localObject3).equalsIgnoreCase("wanggou.com")) && (!nwo.b((String)localObject3).equalsIgnoreCase("tencent.com")) && (!nwo.b((String)localObject3).equalsIgnoreCase("jd.com")) && (!nwo.b((String)localObject3).equalsIgnoreCase("qcloud.com")) && (!nwo.b((String)localObject3).equalsIgnoreCase("webank.com")) && (!nwo.b((String)localObject3).equalsIgnoreCase("qqumall.com")))) {
      return false;
    }
    if ((((String)localObject3).startsWith("https://jiazhang.qq.com/wap/com/")) || (((String)localObject3).startsWith("https://test.jiazhang.qq.com/wap/com/")))
    {
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))))
      {
        QLog.e("JumpAction", 1, "empty params");
        return false;
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"), "");
    }
    if (amfb.a((String)localObject3))
    {
      amfb.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, (String)localObject3);
      return true;
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("style");
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_auth");
    localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_nld");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_dev");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_usr");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("plg_vkey");
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((String)localObject3);
    if (localStringBuffer.indexOf("?") < 0)
    {
      localStringBuffer.append("?");
      localObject3 = new Cryptor();
      if (!"1".equals(str2)) {
        break label2279;
      }
      localStringBuffer.append("plg_auth=1");
      localStringBuffer.append("&");
    }
    label2136:
    label2279:
    for (int i1 = 1;; i1 = 0)
    {
      if ("1".equals(str3))
      {
        localStringBuffer.append("plg_dev=1");
        localStringBuffer.append("&");
        localStringBuffer.append("MOBINFO=");
        localStringBuffer.append(HexUtil.bytes2HexStr(((Cryptor)localObject3).encrypt(c().getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      if ("1".equals(str4))
      {
        localStringBuffer.append("plg_usr=1");
        localStringBuffer.append("&");
        localStringBuffer.append("USER=");
        localStringBuffer.append(HexUtil.bytes2HexStr(((Cryptor)localObject3).encrypt(anvx.a(2131705389).getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      int i2 = i1;
      if ("1".equals(str5))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getvKeyStr();
        i2 = i1;
        if (localObject3 != null)
        {
          localStringBuffer.append("plg_vkey=1").append("&mqqvkey=").append((String)localObject3).append("&");
          i2 = 1;
        }
      }
      if ((this.g != null) && (this.g.length() > 0)) {
        localStringBuffer.append(this.g + "&");
      }
      str2 = b("download_sourceid");
      if ("1".equals(localObject1))
      {
        localStringBuffer.append("plg_nld=1");
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class).putExtra("url", localStringBuffer.toString());
        ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
        if ((str1 != null) && (!str1.equals(""))) {
          ((Intent)localObject1).putExtra("title", str1);
        }
        ((Intent)localObject1).putExtra("reportNldFormPlugin", true);
        ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return true;
        if (localStringBuffer.indexOf("?") >= localStringBuffer.length() - 1) {
          break;
        }
        if (localStringBuffer.indexOf("&") < 0)
        {
          localStringBuffer.append("&");
          break;
        }
        if (localStringBuffer.lastIndexOf("&") >= localStringBuffer.length() - 1) {
          break;
        }
        localStringBuffer.append("&");
        break;
      }
      if (i2 != 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.lastIndexOf("&"));
      }
      localObject1 = localStringBuffer.toString();
      if (((String)localObject1).startsWith("http://story.now.qq.com/mobile/transfer_q.html"))
      {
        localObject1 = bkyp.b(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
        if (!TextUtils.isEmpty((String)((Map)localObject1).get("storysharefrom")))
        {
          this.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject1);
          if (this.jdField_a_of_type_JavaUtilHashMap.get("type") == null) {
            this.jdField_c_of_type_JavaLangString = "opencontent";
          }
          for (;;)
          {
            return T();
            switch (Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("type")))
            {
            default: 
              return true;
            case 0: 
              this.jdField_c_of_type_JavaLangString = "opencontent";
              break;
            case 1: 
              this.jdField_c_of_type_JavaLangString = "openVideo";
              break;
            case 2: 
              this.jdField_c_of_type_JavaLangString = "opentopic";
            }
          }
        }
      }
      else if (((String)localObject1).startsWith("http://story.now.qq.com/mobile/transfer_q2.html"))
      {
        localObject1 = bkyp.b(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
        this.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject1);
        localObject1 = (String)((Map)localObject1).get("contentType");
        if ((localObject1 == null) || (((String)localObject1).equals("0")))
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.get("actionnamekey") != null) {}
          for (i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("actionnamekey"));; i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("type"))) {
            switch (i1)
            {
            default: 
              return true;
            }
          }
          this.jdField_c_of_type_JavaLangString = "opencontent";
          for (;;)
          {
            return T();
            this.jdField_c_of_type_JavaLangString = "openVideo";
            continue;
            this.jdField_c_of_type_JavaLangString = "opentopic";
            continue;
            this.jdField_c_of_type_JavaLangString = "infoCard";
          }
        }
      }
      else
      {
        if (((String)localObject1).contains("lbs.qidian.qq.com/authorize/voiceShow"))
        {
          localObject3 = localStringBuffer.toString();
          localObject1 = localObject3;
          if (((String)localObject3).endsWith("&")) {
            localObject1 = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
          }
          localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("url", (String)localObject1);
          ((Intent)localObject3).putExtra("fragment_class", QidianWebViewFragment.class.getCanonicalName());
          ((Intent)localObject3).putExtra("key_isReadModeEnabled", true);
          ((Intent)localObject3).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if ((str1 != null) && (!str1.equals(""))) {
            ((Intent)localObject3).putExtra("title", str1);
          }
          ((Intent)localObject3).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((Intent)localObject3).putExtra("plugin_start_time", System.nanoTime());
          ((Intent)localObject3).putExtra("click_start_time", System.currentTimeMillis());
          ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
          try
          {
            ((Intent)localObject3).putExtra("leba_resid", Long.parseLong(b("leba_resid")));
            ((Intent)localObject3).putExtra("has_red_dot", this.jdField_d_of_type_Boolean);
            ((Intent)localObject3).putExtra("is_from_leba", true);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
            return true;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
            }
          }
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if (awyd.a((Activity)this.jdField_a_of_type_AndroidContentContext, localException1, (Bundle)localObject3)) {
            return true;
          }
        }
      }
      Object localObject2;
      if ((this.jdField_e_of_type_JavaLangString == null) || (!this.jdField_e_of_type_JavaLangString.trim().equalsIgnoreCase("com.tx.android.txnews.new"))) {
        if ((this.jdField_e_of_type_JavaLangString != null) && (this.jdField_e_of_type_JavaLangString.trim().equalsIgnoreCase("com.qq.yijianfankui")))
        {
          localStringBuffer.append("&version=8.4.10.4875");
          localStringBuffer.append("&appid=" + AppSetting.a());
          localStringBuffer.append("&QUA=" + QUA.getQUA3());
          localStringBuffer.append("&adtag=4875");
          localObject2 = Build.MODEL;
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            i1 = StatisticCollector.getQzonePatchTag();
            localObject3 = localObject2;
            if (i1 > 0) {
              localObject3 = (String)localObject2 + "_qzpatch" + i1;
            }
            localObject2 = Build.MANUFACTURER;
            if (localObject2 == null) {
              break label2136;
            }
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            localStringBuffer.append("&model=").append((String)localObject3).append("&manufacture=").append((String)localObject2).append("&cpunum=").append(DeviceInfoUtil.getCpuNumber()).append("&cpurate=").append(DeviceInfoUtil.getCpuFrequency()).append("&mem=").append(DeviceInfoUtil.getSystemTotalMemory() / 1024L / 1024L).append("&w=").append(DeviceInfoUtil.getDispalyWidth()).append("&h=").append(DeviceInfoUtil.getDispalyHeight());
          }
        }
        else
        {
          localObject3 = localStringBuffer.toString();
          localObject2 = localObject3;
          if (((String)localObject3).endsWith("&")) {
            localObject2 = ((String)localObject3).substring(0, ((String)localObject3).length() - 1);
          }
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class).putExtra("url", (String)localObject2);
          ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
          ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if ((str1 != null) && (!str1.equals(""))) {
            ((Intent)localObject2).putExtra("title", str1);
          }
          ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((Intent)localObject2).putExtra("plugin_start_time", System.nanoTime());
          ((Intent)localObject2).putExtra("click_start_time", System.currentTimeMillis());
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        }
      }
      for (;;)
      {
        try
        {
          ((Intent)localObject2).putExtra("leba_resid", Long.parseLong(b("leba_resid")));
          ((Intent)localObject2).putExtra("has_red_dot", this.jdField_d_of_type_Boolean);
          ((Intent)localObject2).putExtra("is_from_leba", true);
          if (!TextUtils.isEmpty(str2)) {
            ((Intent)localObject2).putExtra("big_brother_source_key", str2);
          }
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
          return true;
          localObject2 = "";
          break;
          localObject2 = "";
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class).putExtra("url", localStringBuffer.toString());
        ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
        ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((str1 != null) && (!str1.equals(""))) {
          ((Intent)localObject2).putExtra("title", str1);
        }
        ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((Intent)localObject2).putExtra("param_force_internal_browser", false);
        ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
        ((Intent)localObject2).putExtra("injectrecommend", true);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      }
    }
  }
  
  private boolean bb()
  {
    auuv.a();
    auuv.a("KEY_STAGE_1_TOTAL");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_uri"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("third_sd"));
    long l1 = ForwardUtils.parseLong((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
    int i1 = ForwardUtils.parseInt(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag")));
    boolean bool = ForwardUtils.hasSDPermission(this.jdField_a_of_type_AndroidContentContext);
    QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck appID:", Long.valueOf(l1), ",file_type:", str1, ",reqType=", str2, ",third_sd=", str4, ",qq_sd=", Boolean.valueOf(bool), ",file_data=", localObject, ",file_uri=", str3 });
    if (i1 == 1)
    {
      d("shareToQQ");
      return true;
    }
    if (l1 <= 0L)
    {
      QLog.d("JumpAction", 1, new Object[] { "gotoShareMsgCheck appid = ", Long.valueOf(l1) });
      return false;
    }
    localObject = new HashMap(4);
    ((HashMap)localObject).put("KEY_SHARE_TYPE", str2);
    ((HashMap)localObject).put("KEY_FILE_TYPE", str1);
    ((HashMap)localObject).put("KEY_THIRD_SD", str4);
    ((HashMap)localObject).put("KEY_QQ_SD", String.valueOf(bool));
    if (!TextUtils.isEmpty(str3))
    {
      this.jdField_f_of_type_Boolean = false;
      ThreadManagerV2.executeOnSubThread(new JumpAction.16(this, str3, System.currentTimeMillis(), (HashMap)localObject));
      return false;
    }
    auuv.a("KEY_STAGE_1_SAVE_IMAGE", 0L, (HashMap)localObject, false);
    return bc();
  }
  
  private boolean bc()
  {
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_to_qq_ark_info"));
    String str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chSrc");
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {}
    for (String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; str2 = null)
    {
      String str11 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
      String str12 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
      int i2;
      String str13;
      String str14;
      String str15;
      int i3;
      try
      {
        i2 = Integer.valueOf(str1).intValue();
        str13 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
        str14 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
        str15 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
        i3 = ForwardUtils.parseInt(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag")));
        if (i3 == 1)
        {
          d("shareToQQ");
          return true;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.d("QQShare", 1, "NumberFormatException req_type = 1");
          i2 = 148;
        }
      }
      Object localObject1;
      long l1;
      Object localObject2;
      Intent localIntent;
      Bundle localBundle;
      int i1;
      if (i2 == 1)
      {
        localObject1 = "1";
        l1 = ForwardUtils.parseLong((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
        bjgx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str12, String.valueOf(l1), "102", "80", "0", (String)localObject1, "0", "0", false, true);
        localObject2 = null;
        localIntent = null;
        localBundle = new Bundle();
        localBundle.putBoolean("is_ark_display_share", false);
        i1 = 0;
        if (!TextUtils.isEmpty(str9)) {
          localObject1 = localObject2;
        }
      }
      else
      {
        try
        {
          Object localObject3 = new JSONObject(str9);
          localObject1 = localObject2;
          String str16 = ((JSONObject)localObject3).optString("app");
          localObject1 = localObject2;
          String str17 = ((JSONObject)localObject3).optString("view");
          localObject1 = localObject2;
          String str18 = ((JSONObject)localObject3).optString("meta");
          localObject1 = localObject2;
          localObject3 = ((JSONObject)localObject3).optString("config");
          localObject1 = localObject2;
          if (TextUtils.isEmpty(str16)) {
            break label707;
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty(str17)) {
            break label707;
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty(str18)) {
            break label707;
          }
          localObject1 = localObject2;
          localBundle.putBoolean("is_ark_display_share", true);
          localObject1 = localObject2;
          localIntent = ArkFullScreenAppActivity.a(this.jdField_a_of_type_AndroidContentContext, str17, str16, str18, (String)localObject3, String.valueOf(l1), this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity);
          localObject1 = localIntent;
          ArkAppCenter.c("JumpAction", "gotoShareArkMsg, ark appInfo is parse success");
          localObject1 = localIntent;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            label608:
            ArkAppCenter.c("JumpAction", String.format("gotoShareArkMsg, parse json failed, err=%s", new Object[] { localJSONException.getMessage() }));
            i1 = 1;
          }
        }
        if (i1 == 0) {
          break label1317;
        }
        localObject1 = new Intent();
        localBundle.putBoolean("is_ark_display_share", true);
        localBundle.putBoolean("forward_ark_from_sdk", true);
      }
      label1281:
      label1287:
      label1308:
      label1310:
      label1317:
      for (;;)
      {
        if (l1 <= 0L)
        {
          QLog.d("StructMsg", 1, new Object[] { "gotoShareMsg appid = ", Long.valueOf(l1) });
          return false;
          if (i2 == 5)
          {
            localObject1 = "2";
            break;
          }
          if (i2 == 2)
          {
            localObject1 = "3";
            break;
          }
          localObject1 = "4";
          break;
          label707:
          i1 = 1;
          localObject1 = localObject2;
          ArkAppCenter.c("JumpAction", "gotoShareArkMsg, appName or appView or appMeta is empty");
          localObject1 = localIntent;
          break label608;
          ArkAppCenter.c("JumpAction", "gotoShareArkMsg, appInfo is empty");
          localObject1 = null;
          i1 = 1;
          break label608;
        }
        if (("news".equals(str3)) || ("audio".equals(str3)))
        {
          localBundle.putString("title", str5);
          localBundle.putString("desc", str6);
          localBundle.putString("image_url", str4);
          localBundle.putString("detail_url", str7);
          localBundle.putString("chSrc", str10);
          localBundle.putInt("forward_type", 11);
          localBundle.putLong("req_share_id", l1);
          localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
          localBundle.putString("image_url_remote", str8);
          localBundle.putString("app_name", str2);
          localBundle.putString("open_id", str12);
          localBundle.putString("shareArkInfo", str9);
          localBundle.putString("chSrc", str10);
          if (str5 == null) {
            if (TextUtils.isEmpty(str2)) {
              break label1310;
            }
          }
        }
        for (;;)
        {
          localBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131696132, new Object[] { str2 }));
          localBundle.putString("share_uin", str13);
          localBundle.putString("jfrom", str14);
          localBundle.putString("share_qq_ext_str", str15);
          localBundle.putInt("cflag", i3);
          localBundle.putInt("emoInputType", 2);
          if ((i2 == 5) && (auui.a()))
          {
            localBundle.putBoolean("is_ark_display_share", true);
            localBundle.putBoolean("forward_ark_from_sdk", true);
          }
          if (i2 == 2) {
            localBundle.putString("audio_url", str11);
          }
          localBundle.putInt("req_type", i2);
          localBundle.putBoolean("k_dataline", false);
          localBundle.putBoolean("k_favorites", true);
          localBundle.putBoolean("k_cancel_button", true);
          if (((i3 & 0x2) == 0) && (!"com.qzone".equals(this.jdField_e_of_type_JavaLangString)))
          {
            bool = true;
            label1118:
            localBundle.putBoolean("k_qzone", bool);
            if ((!bool) || ((i3 & 0x1) == 0)) {
              break label1281;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localBundle.putBoolean("k_send", bool);
            localBundle.putInt("iUrlInfoFrm", 4);
            bool = arcp.a();
            localBundle.putBoolean("enable_d55", bool);
            if (bool) {
              ((auuc)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.SDK_SHARE)).a().a(str12, l1, this.jdField_e_of_type_JavaLangString);
            }
            if (localObject1 == null) {
              break label1308;
            }
            if (!MiniProgramOpenSdkUtil.isSharingMiniProgram(this.jdField_a_of_type_JavaUtilHashMap)) {
              break label1287;
            }
            MiniProgramOpenSdkUtil.forwardShareWithTryCatch(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, localBundle, (Intent)localObject1);
            return true;
            localBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131696132, new Object[] { str5 }));
            break;
            bool = false;
            break label1118;
          }
          ((Intent)localObject1).putExtras(localBundle);
          com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
          aupt.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1);
          return true;
          str2 = "";
        }
      }
    }
  }
  
  private boolean bd()
  {
    Object localObject = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("fopen_id"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("friend_label"));
    String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("add_msg"));
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
    long l1;
    try
    {
      l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id")).longValue();
      if (l1 <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "gotoMakeFriend appid = " + l1);
        }
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = 0L;
      }
      AddFriendLogicActivity.jdField_a_of_type_JavaLangString = (String)localObject;
      if (!"true".equals(str5)) {}
    }
    for (localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, str1, "" + l1, 3090, 0, str2, str3, null, "", str4);; localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, str1, "" + l1, 3016, 0, str2, str3, null, "", str4))
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
    }
  }
  
  private boolean be()
  {
    Object localObject;
    String str2;
    QZoneHelper.UserInfo localUserInfo;
    String str1;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)))
    {
      localObject = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("page_id");
      if (str2 != null)
      {
        localUserInfo = QZoneHelper.UserInfo.getInstance();
        localUserInfo.qzone_uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localUserInfo.nickname = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
        SessionInfo localSessionInfo = ((FragmentActivity)localObject).getChatFragment().a().getSessionInfo();
        if ((localSessionInfo != null) && (!TextUtils.isEmpty(localSessionInfo.curFriendUin))) {
          ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).e(localSessionInfo.curFriendUin, true);
        }
        if (!str2.equalsIgnoreCase("11")) {
          break label166;
        }
        QZoneHelper.forwardToQunAlbumDetail((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, str1, "mqqChat.QzoneCard", -1);
      }
    }
    for (;;)
    {
      return false;
      label166:
      if (str2.equalsIgnoreCase("12"))
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a().getCurFriendUin();
        str2 = a(str1);
        if (TextUtils.isEmpty(str2)) {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, "缺少相册id", 1).a();
        } else {
          QZoneHelper.forwardToTroopAlbumViewPhoto((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, (String)localObject, str2, str1, "mqqChat.QzoneCard", -1);
        }
      }
    }
  }
  
  private boolean bf()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.common.activities.QzoneDialogActivity");
    localIntent.addFlags(805306368);
    QZoneHelper.launchQZone((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localIntent, -1);
    return true;
  }
  
  private boolean bg()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (!QzoneAuthorizeConfig.getInstance().hasSchemeRight(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("JumpAction", 1, "has no right to handle this schema");
        return false;
      }
      String str;
      if (this.jdField_a_of_type_JavaLangString.startsWith("mqqzone"))
      {
        str = "mqzone" + this.jdField_a_of_type_JavaLangString.substring("mqqzone".length());
        if (TextUtils.isEmpty(str)) {
          break label207;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("cmd", "Schema");
        localIntent.putExtra("schema", str);
        vnd.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_d_of_type_Boolean);
        uyt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          return true;
          str = (String)bkyp.a(this.jdField_a_of_type_JavaLangString).get("schema");
          if (!TextUtils.isEmpty(str)) {
            try
            {
              str = new String(Base64.decode(str, 0), "utf-8");
            }
            catch (Exception localException)
            {
              QLog.e("JumpAction", 1, localException, new Object[0]);
            }
          }
        }
        Object localObject = null;
        break;
        label207:
        QLog.e("JumpAction", 1, "gotoQzoneHandleSchema,schema=null");
      }
    }
    return false;
  }
  
  private boolean bh()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return false;
    }
    long l1 = QZoneConfigHelper.enableQZoneContentBoxMiniProgram();
    if (l1 != 0L) {
      QZoneMsgActivity.launchContentBoxMiniProgram(l1, this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      return true;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneMsgActivity.class);
      localIntent.addFlags(67108864);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  private boolean bi()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    Object localObject9 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    Object localObject10 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {}
    for (localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; localObject1 = null)
    {
      String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
      String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
      String str6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
      String str8 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
      for (;;)
      {
        try
        {
          i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
        }
        catch (Exception localException2)
        {
          try
          {
            l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
            localObject8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            i2 = (int)l1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              String str1 = "";
              if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
                continue;
              }
              localObject6 = "";
              bman.a((AppRuntime)localObject8, "User_SdkShare", i2, 0, 0, 0, str1, (String)localObject6);
              localObject8 = new Bundle();
              ((Bundle)localObject8).putString("title", (String)localObject5);
              ((Bundle)localObject8).putString("desc", (String)localObject7);
              ((Bundle)localObject8).putString("image_url", (String)localObject9);
              ((Bundle)localObject8).putString("detail_url", (String)localObject10);
              ((Bundle)localObject8).putLong("req_share_id", l1);
              ((Bundle)localObject8).putString("pkg_name", this.jdField_e_of_type_JavaLangString);
              ((Bundle)localObject8).putString("image_url_remote", str2);
              ((Bundle)localObject8).putString("app_name", (String)localObject1);
              ((Bundle)localObject8).putString("open_id", str5);
              ((Bundle)localObject8).putString("share_uin", str6);
              ((Bundle)localObject8).putString("jfrom", str7);
              ((Bundle)localObject8).putString("share_qq_ext_str", str8);
              ((Bundle)localObject8).putInt("cflag", i1);
              ((Bundle)localObject8).putInt("forward_type", 11);
              i3 = 1;
            }
          }
          catch (Exception localException2)
          {
            try
            {
              int i1;
              long l1;
              i2 = Integer.valueOf(str4).intValue();
              ((Bundle)localObject8).putInt("req_type", i2);
              if (2 == i2)
              {
                ((Bundle)localObject8).putString("audio_url", str3);
                if ((TextUtils.isEmpty((CharSequence)localObject5)) && (TextUtils.isEmpty((CharSequence)localObject7)))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    ((Bundle)localObject8).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697880), new Object[] { localObject1 }));
                  }
                }
                else
                {
                  com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
                  localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
                  ((Intent)localObject1).putExtra("toUin", AppConstants.FAVORITES_UIN);
                  ((Intent)localObject1).putExtra("uinType", 0);
                  if (1 != i1) {
                    break label1691;
                  }
                  ((Intent)localObject1).putExtra("qqfav_extra_from_system_share", true);
                  ((Intent)localObject1).putExtras((Bundle)localObject8);
                  aupt.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, DirectForwardActivity.class);
                  return true;
                  localException1 = localException1;
                  if (QLog.isColorLevel()) {
                    QLog.e("qqfav", 2, "gotoQfavShareMsg|parse extflags exp: extflag=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"));
                  }
                  i1 = 0;
                  continue;
                  localException2 = localException2;
                  if (QLog.isColorLevel()) {
                    QLog.e("qqfav", 2, "gotoQfavShareMsg|parse appid exp: appid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
                  }
                  l1 = 0L;
                  continue;
                  Object localObject2 = localObject1;
                  continue;
                  localObject6 = this.jdField_e_of_type_JavaLangString;
                }
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              Object localObject8;
              Object localObject6;
              int i3;
              int i2 = i3;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("qqfav", 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + str4);
              i2 = i3;
              continue;
              ((Bundle)localObject8).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131697881));
              continue;
              Object localObject3;
              if (6 == i2)
              {
                ((Bundle)localObject8).putBoolean("key_sdk_share_pure_text", true);
                localObject1 = "";
                if (!TextUtils.isEmpty((CharSequence)localObject5)) {
                  localObject1 = localObject5;
                }
                localObject3 = localObject1;
                if (!TextUtils.isEmpty((CharSequence)localObject7))
                {
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    localObject3 = localObject7;
                  }
                }
                else
                {
                  ((Bundle)localObject8).putString("forward_text", (String)localObject3);
                  ((Bundle)localObject8).putString("qqfav_extra_richmedia_title", (String)localObject5);
                  ((Bundle)localObject8).putString("qqfav_extra_mixed_msg", (String)localObject7);
                  continue;
                }
                localObject3 = (String)localObject1 + "\n" + (String)localObject7;
                continue;
              }
              if (5 == i2)
              {
                ((Bundle)localObject8).putBoolean("qqfav_extra_pic_share", true);
                ((Bundle)localObject8).putBoolean("qqfav_extra_only_pic", TextUtils.isEmpty((CharSequence)localObject7));
                ((Bundle)localObject8).putString("qqfav_extra_richmedia_title", (String)localObject5);
                ((Bundle)localObject8).putString("qqfav_extra_mixed_msg", (String)localObject7);
                ((Bundle)localObject8).putString("desc", "");
                localObject6 = localObject5;
                if (TextUtils.isEmpty((CharSequence)localObject5))
                {
                  localObject6 = localObject5;
                  if (!TextUtils.isEmpty((CharSequence)localObject7))
                  {
                    localObject6 = ((String)localObject7).replace("\024", "");
                    ((Bundle)localObject8).putString("title", (String)localObject6);
                  }
                }
                localObject3 = null;
                localObject1 = null;
                localObject10 = new ArrayList();
                Object localObject4;
                if (!TextUtils.isEmpty((CharSequence)localObject9))
                {
                  localObject9 = ((String)localObject9).split(";");
                  i2 = 0;
                  localObject5 = null;
                  localObject7 = localObject5;
                  localObject3 = localObject1;
                  if (i2 < localObject9.length)
                  {
                    localObject7 = "";
                    try
                    {
                      localObject3 = URLDecoder.decode(localObject9[i2], "UTF-8");
                      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                        if ((((String)localObject3).startsWith("/")) && (new File((String)localObject3).exists()))
                        {
                          ((ArrayList)localObject10).add(localObject3);
                          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                            continue;
                          }
                          i2 += 1;
                          localObject1 = localObject3;
                        }
                      }
                    }
                    catch (UnsupportedEncodingException localUnsupportedEncodingException)
                    {
                      localObject4 = localObject7;
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.e("qqfav", 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + localObject9[i2]);
                      localObject4 = localObject7;
                      continue;
                      if (localObject4.startsWith("http"))
                      {
                        ((ArrayList)localObject10).add(localObject4);
                        if (TextUtils.isEmpty((CharSequence)localObject5))
                        {
                          localObject5 = localObject4;
                          localObject4 = localObject1;
                          continue;
                          if (QLog.isColorLevel()) {
                            QLog.e("qqfav", 2, "gotoQfavShareMsg|file path invalid. path=" + localObject4);
                          }
                        }
                      }
                      localObject4 = localObject1;
                      continue;
                    }
                  }
                }
                else
                {
                  localObject7 = null;
                }
                if (((ArrayList)localObject10).isEmpty())
                {
                  bmar.a(this.jdField_a_of_type_AndroidContentContext, 2131697878, 1);
                  if (QLog.isColorLevel()) {
                    QLog.e("qqfav", 2, "gotoQfavShareMsg|image type.no image path");
                  }
                  return false;
                }
                ((Bundle)localObject8).putString("image_url", localObject4);
                ((Bundle)localObject8).putString("image_url_remote", (String)localObject7);
                ((Bundle)localObject8).putStringArrayList("qqfav_extra_multi_pic_path_list", (ArrayList)localObject10);
                if (1 == ((ArrayList)localObject10).size())
                {
                  if (TextUtils.isEmpty((CharSequence)localObject6))
                  {
                    ((Bundle)localObject8).putInt("req_type", 5);
                    if ((!TextUtils.isEmpty(localObject4)) || (TextUtils.isEmpty((CharSequence)localObject7))) {
                      continue;
                    }
                    ((Bundle)localObject8).putString("image_url", (String)localObject7);
                    continue;
                  }
                  ((Bundle)localObject8).putInt("req_type", 1);
                  continue;
                }
                if (TextUtils.isEmpty((CharSequence)localObject6)) {
                  ((Bundle)localObject8).putString("title", ((ArrayList)localObject10).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131694371));
                }
                ((Bundle)localObject8).putBoolean("qqfav_extra_multi_pic", true);
                ((Bundle)localObject8).putInt("req_type", 1);
                continue;
              }
              if (1 == i2)
              {
                if ((TextUtils.isEmpty((CharSequence)localObject5)) && (TextUtils.isEmpty((CharSequence)localObject7)))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    ((Bundle)localObject8).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697880), new Object[] { localObject1 }));
                  }
                }
                else
                {
                  if ((!TextUtils.isEmpty((CharSequence)localObject10)) || (!QLog.isColorLevel())) {
                    continue;
                  }
                  QLog.i("qqfav", 2, "gotoQfavShareMsg|link type. no detail url");
                  continue;
                }
                ((Bundle)localObject8).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131697881));
                continue;
              }
              bmar.a(this.jdField_a_of_type_AndroidContentContext, 2131697878, 1);
              if (QLog.isColorLevel()) {
                QLog.e("qqfav", 2, "gotoQfavShareMsg|unknown reqType. reqType=" + i2);
              }
              return false;
            }
          }
        }
        label1691:
        ((Intent)localObject1).putExtra("qqfav_extra_from_sdk_share", true);
      }
    }
  }
  
  private boolean bj()
  {
    int i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"))).intValue();
    if (i1 == 3)
    {
      str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_uri"));
      if (!TextUtils.isEmpty(str)) {
        ThreadManagerV2.executeOnSubThread(new JumpAction.17(this, str));
      }
    }
    while (i1 != 4)
    {
      return true;
      a(true);
      return true;
    }
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoUri"));
    if (!TextUtils.isEmpty(str))
    {
      ThreadManagerV2.executeOnSubThread(new JumpAction.18(this, str));
      return true;
    }
    a(true);
    return true;
  }
  
  private boolean bk()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    String str3 = QUA.getQUA3();
    QZoneShareManager.shareToQZoneForRedPocket(this.jdField_a_of_type_AndroidContentContext, str1, null, 0, str2, str3);
    return true;
  }
  
  private boolean bl()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_uin");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(str))
    {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extinfo");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (str = "mqzone://arouse/homepage?redpocket=1&uin=" + str;; str = "mqzone://arouse/homepage?redpocket=1&uin=" + str + "&extinfo=" + (String)localObject)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("cmd", "Schema");
        ((Intent)localObject).putExtra("schema", str);
        QZoneHelper.forwardToQzoneTransluentActivity((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.getInstance(), (Intent)localObject);
        return true;
      }
    }
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    if ((!TextUtils.isEmpty(str)) && (str.equals("login")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131705376), 1).a();
      return true;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131705386), 1).a();
    str = this.jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder().append(str);
    if (str.indexOf("?") > -1) {}
    for (str = "&";; str = "?")
    {
      str = str;
      str = str + "jfrom=login";
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, LoginActivity.class);
      ((Intent)localObject).putExtra("scheme_content", str);
      ((Intent)localObject).putExtra("pkg_name", "com.tencent.mobileqq");
      ((Intent)localObject).putExtras((Intent)localObject);
      ((Intent)localObject).setFlags(268435456);
      if (VersionUtils.isHoneycomb()) {
        ((Intent)localObject).addFlags(32768);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
    }
  }
  
  private boolean bm()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, anvx.a(2131705378), 1).a();
    return false;
  }
  
  private boolean bn()
  {
    return true;
  }
  
  private boolean bo()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localUserInfo.nickname = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      QZoneHelper.forwardToPublishQueue((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, -1);
      return true;
    }
    return false;
  }
  
  private boolean bp()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(str))
        {
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          QZoneHelper.forwardToUserHome((Activity)this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.getInstance(), str, 0, 0, 0);
          return true;
        }
      }
      catch (Exception localException)
      {
        QLog.e("JumpAction", 1, localException, new Object[0]);
        return true;
      }
    }
  }
  
  private boolean bq()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, JoinDiscussionActivity.class);
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    localIntent.putExtra("sig", str);
    if (TextUtils.isEmpty(str)) {
      localIntent.putExtra("innerSig", (String)this.jdField_a_of_type_JavaUtilHashMap.get("k"));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean br()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AgentActivity.class);
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBundle.putString(str, (String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
    }
    localIntent.putExtra("key_params", localBundle);
    localIntent.putExtra("key_action", "action_ptlogin_login");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean bs()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoMultiVoiceChat");
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("relation_id");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("actid");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mp_ext_params");
    HashMap localHashMap = new HashMap();
    if ((str4 != null) && (str4.equals("video"))) {
      localHashMap.put("isVideo", "true");
    }
    if (str6 != null)
    {
      localHashMap.put("mp_ext_params", str6);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoMultiVoiceChat mp_ext_params : " + str6);
      }
    }
    if ((str5 != null) && (str4 != null))
    {
      localHashMap.put("actid", str5);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoMultiVoiceChat actId : " + str5);
      }
    }
    if ((str1 != null) && (str1.equals("web")) && (str2 != null) && (str2.equals("1")) && (localObject != null) && (str3 != null))
    {
      if (str3.equals("discussgroup")) {
        if (((String)localObject).equals("0"))
        {
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SelectMemberActivity.class);
          ((Intent)localObject).putExtra("param_type", 3000);
          ((Intent)localObject).putExtra("param_subtype", 0);
          ((Intent)localObject).putExtra("param_from", 1003);
          ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131691244));
          ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131691565));
          ((Intent)localObject).putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131691566));
          ((Intent)localObject).putExtra("param_max", 99);
          ((Intent)localObject).setFlags(603979776);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 1);
        }
      }
      do
      {
        return true;
        return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 3000, (String)localObject, true, true, this.jdField_a_of_type_Adnm, localHashMap);
        if (str3.equals("single"))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("forward_type", 13);
          ((Intent)localObject).putExtra("fromWebXman", true);
          aupt.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 2);
          return true;
        }
        if (!str3.equals("group")) {
          break;
        }
      } while (((String)localObject).equals("0"));
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from");
      if ((!"gvideo".equals(str1)) && (!"gvideo_h5".equals(str1))) {
        break label621;
      }
    }
    label621:
    for (boolean bool = false;; bool = true)
    {
      return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, true, bool, this.jdField_a_of_type_Adnm, this.jdField_a_of_type_JavaUtilHashMap);
      return false;
    }
  }
  
  private boolean bt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoVideoChat");
    }
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    if ((localObject2 != null) && ("forward_to_tab".equals(localObject2)))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      ((Intent)localObject1).putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      ((Intent)localObject1).putExtra("conversation_index", 1);
      ((Intent)localObject1).setFlags(335544320);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return true;
    }
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uinType");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    Object localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("phone");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extraUin");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("actid");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mp_ext_params");
    if ((str4 != null) && (localObject2 != null) && (((String)localObject2).equals("audio")) && (QLog.isColorLevel())) {
      QLog.d("JumpAction", 2, "gotoVideoChat actId : " + str4);
    }
    if ((str5 != null) && (QLog.isColorLevel())) {
      QLog.d("JumpAction", 2, "gotoVideoChat mp_ext_params : " + str5);
    }
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(str3);
        if ((localObject3 == null) || (!((String)localObject3).equals("web")) || (i1 <= 0)) {}
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i1;
        int i2;
        try
        {
          i1 = Integer.valueOf(str2).intValue();
          i1 = VideoController.a(i1, false, 1);
          if ((localObject2 == null) || (!((String)localObject2).equals("audio"))) {
            break label763;
          }
          bool1 = true;
          if (i1 == 1006)
          {
            localObject2 = localObject5;
            if (!((String)localObject5).startsWith("+")) {
              localObject2 = "+" + (String)localObject5;
            }
            localObject3 = ((awyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).c((String)localObject2);
            if (localObject3 != null)
            {
              localObject3 = ((PhoneContact)localObject3).name;
              localObject5 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject5 = localObject2;
              }
              bool2 = true;
              localObject1 = localObject3;
              localObject3 = localObject2;
              localObject2 = localObject5;
              return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, (String)localObject2, (String)localObject1, (String)localObject3, bool1, str1, bool2, true, this.jdField_a_of_type_Adnm, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
              localNumberFormatException = localNumberFormatException;
              i1 = 0;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoVideoChat", localException);
          }
          i1 = 0;
          continue;
          localObject4 = localObject2;
          continue;
          if (i1 == 1011)
          {
            localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickName");
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              localObject2 = localObject4;
              if (!((String)localObject1).equals(localObject4)) {}
            }
            else
            {
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695489);
            }
            bool1 = true;
            bool2 = false;
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            continue;
          }
          i2 = ContactUtils.getEntry(i1);
          if (i2 != -1) {
            continue;
          }
        }
        localObject4 = ContactUtils.getNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, i1);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = localObject4;
          if (!((String)localObject1).equals(localObject4)) {}
        }
        else
        {
          localObject2 = ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label741;
        }
        bool2 = true;
        localObject2 = localObject1;
        localObject4 = localObject5;
        continue;
        localObject4 = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, str1, i2, 0);
        continue;
      }
      return false;
      label741:
      boolean bool2 = true;
      Object localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject5;
      continue;
      label763:
      boolean bool1 = false;
    }
  }
  
  private boolean bu()
  {
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoRandomVideoChat");
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("session_name"));
    this.jdField_a_of_type_JavaUtilHashMap.put("session_name", str4);
    boolean bool1;
    if ((str2 != null) && (str2.equals("audio"))) {
      bool1 = true;
    }
    try
    {
      for (;;)
      {
        i1 = Integer.parseInt(str3);
        boolean bool2 = bool3;
        if (str1 != null)
        {
          bool2 = bool3;
          if (str1.equals("web"))
          {
            bool2 = bool3;
            if (i1 > 0) {
              bool2 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1011, null, null, null, bool1, null, false, true, this.jdField_a_of_type_Adnm, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
            }
          }
        }
        return bool2;
        bool1 = false;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i1 = 0;
      }
    }
  }
  
  private boolean bv()
  {
    if (this.jdField_c_of_type_JavaLangString.equals("jump"))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("options");
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, VipComicJumpActivity.class);
      localIntent.putExtra("options", str);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  /* Error */
  private boolean bw()
  {
    // Byte code:
    //   0: new 134	android/content/Intent
    //   3: dup
    //   4: ldc_w 4716
    //   7: invokespecial 2130	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   10: astore 14
    //   12: aload_0
    //   13: aload 14
    //   15: invokespecial 1824	bheh:a	(Landroid/content/Intent;)V
    //   18: aconst_null
    //   19: astore 9
    //   21: aconst_null
    //   22: astore 8
    //   24: aconst_null
    //   25: astore 10
    //   27: aload_0
    //   28: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   31: invokevirtual 1281	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   34: astore 12
    //   36: iconst_0
    //   37: istore_1
    //   38: ldc 56
    //   40: astore 11
    //   42: aload_0
    //   43: ldc_w 3999
    //   46: invokevirtual 416	bheh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 13
    //   51: aload 13
    //   53: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +14 -> 70
    //   59: aload 14
    //   61: ldc_w 4129
    //   64: aload 13
    //   66: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   69: pop
    //   70: aload_0
    //   71: ldc_w 4718
    //   74: invokevirtual 416	bheh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +62 -> 142
    //   83: aload 14
    //   85: ldc_w 4043
    //   88: invokestatic 4046	java/lang/System:nanoTime	()J
    //   91: invokevirtual 741	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   94: pop
    //   95: aload 14
    //   97: ldc_w 1717
    //   100: invokestatic 738	java/lang/System:currentTimeMillis	()J
    //   103: invokevirtual 741	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   106: pop
    //   107: aload 14
    //   109: ldc_w 733
    //   112: invokestatic 738	java/lang/System:currentTimeMillis	()J
    //   115: invokevirtual 741	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   118: pop
    //   119: aload 14
    //   121: ldc_w 4052
    //   124: iconst_1
    //   125: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   128: pop
    //   129: aload 14
    //   131: ldc_w 4050
    //   134: aload_0
    //   135: getfield 683	bheh:jdField_d_of_type_Boolean	Z
    //   138: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   141: pop
    //   142: aload 12
    //   144: invokeinterface 1287 1 0
    //   149: astore 15
    //   151: aload 15
    //   153: invokeinterface 1292 1 0
    //   158: ifeq +631 -> 789
    //   161: aload 15
    //   163: invokeinterface 1296 1 0
    //   168: checkcast 1298	java/util/Map$Entry
    //   171: astore 12
    //   173: aload 12
    //   175: invokeinterface 1304 1 0
    //   180: checkcast 45	java/lang/String
    //   183: astore 13
    //   185: aload 12
    //   187: invokeinterface 1301 1 0
    //   192: checkcast 45	java/lang/String
    //   195: astore 12
    //   197: aload 13
    //   199: ifnull -48 -> 151
    //   202: aload 12
    //   204: ifnull -53 -> 151
    //   207: ldc_w 4720
    //   210: aload 13
    //   212: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifeq +26 -> 241
    //   218: aload 8
    //   220: astore 13
    //   222: aload 11
    //   224: astore 8
    //   226: aload 10
    //   228: astore 9
    //   230: aload 13
    //   232: astore 10
    //   234: aload 12
    //   236: astore 11
    //   238: goto +2910 -> 3148
    //   241: ldc_w 4722
    //   244: aload 13
    //   246: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq +22 -> 271
    //   252: aload 11
    //   254: astore 8
    //   256: aload 9
    //   258: astore 11
    //   260: aload 10
    //   262: astore 9
    //   264: aload 12
    //   266: astore 10
    //   268: goto +2880 -> 3148
    //   271: ldc_w 4724
    //   274: aload 13
    //   276: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   279: ifeq +57 -> 336
    //   282: ldc_w 283
    //   285: aload 12
    //   287: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   290: ifeq +2885 -> 3175
    //   293: aload 14
    //   295: ldc_w 4726
    //   298: aload_0
    //   299: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   302: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   305: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   308: pop
    //   309: aload 8
    //   311: astore 12
    //   313: aload 9
    //   315: astore 13
    //   317: aload 11
    //   319: astore 8
    //   321: aload 10
    //   323: astore 9
    //   325: aload 12
    //   327: astore 10
    //   329: aload 13
    //   331: astore 11
    //   333: goto +2815 -> 3148
    //   336: ldc_w 4728
    //   339: aload 13
    //   341: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   344: ifeq +89 -> 433
    //   347: ldc_w 283
    //   350: aload 12
    //   352: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   355: ifeq +2820 -> 3175
    //   358: aload_0
    //   359: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   362: invokevirtual 4333	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   365: astore 13
    //   367: aload 13
    //   369: astore 12
    //   371: aload 13
    //   373: invokestatic 3717	com/tencent/mobileqq/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   376: ifeq +19 -> 395
    //   379: aload_0
    //   380: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   383: aload_0
    //   384: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   387: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   390: invokestatic 4731	com/tencent/mobileqq/utils/ContactUtils:getAccountNickName	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   393: astore 12
    //   395: aload 14
    //   397: ldc_w 2125
    //   400: aload 12
    //   402: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   405: pop
    //   406: aload 8
    //   408: astore 12
    //   410: aload 9
    //   412: astore 13
    //   414: aload 11
    //   416: astore 8
    //   418: aload 10
    //   420: astore 9
    //   422: aload 12
    //   424: astore 10
    //   426: aload 13
    //   428: astore 11
    //   430: goto +2718 -> 3148
    //   433: ldc_w 3963
    //   436: aload 13
    //   438: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   441: ifeq +57 -> 498
    //   444: ldc_w 283
    //   447: aload 12
    //   449: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   452: ifeq +2723 -> 3175
    //   455: aload 14
    //   457: ldc_w 4733
    //   460: aload_0
    //   461: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   464: invokevirtual 3992	com/tencent/mobileqq/app/QQAppInterface:getvKeyStr	()Ljava/lang/String;
    //   467: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   470: pop
    //   471: aload 8
    //   473: astore 12
    //   475: aload 9
    //   477: astore 13
    //   479: aload 11
    //   481: astore 8
    //   483: aload 10
    //   485: astore 9
    //   487: aload 12
    //   489: astore 10
    //   491: aload 13
    //   493: astore 11
    //   495: goto +2653 -> 3148
    //   498: ldc_w 4735
    //   501: aload 13
    //   503: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   506: ifeq +53 -> 559
    //   509: ldc_w 283
    //   512: aload 12
    //   514: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   517: ifeq +2658 -> 3175
    //   520: aload 14
    //   522: ldc_w 4737
    //   525: invokestatic 738	java/lang/System:currentTimeMillis	()J
    //   528: invokevirtual 741	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   531: pop
    //   532: aload 8
    //   534: astore 12
    //   536: aload 9
    //   538: astore 13
    //   540: aload 11
    //   542: astore 8
    //   544: aload 10
    //   546: astore 9
    //   548: aload 12
    //   550: astore 10
    //   552: aload 13
    //   554: astore 11
    //   556: goto +2592 -> 3148
    //   559: ldc_w 4739
    //   562: aload 13
    //   564: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   567: ifeq +90 -> 657
    //   570: ldc_w 283
    //   573: aload 12
    //   575: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   578: ifeq +2597 -> 3175
    //   581: aload 14
    //   583: ldc_w 4741
    //   586: aload_0
    //   587: getfield 4743	bheh:jdField_c_of_type_Boolean	Z
    //   590: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   593: pop
    //   594: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +2578 -> 3175
    //   600: ldc_w 4745
    //   603: iconst_2
    //   604: new 113	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 4747
    //   614: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_0
    //   618: getfield 4743	bheh:jdField_c_of_type_Boolean	Z
    //   621: invokevirtual 1253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   624: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 1396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: aload 8
    //   632: astore 12
    //   634: aload 9
    //   636: astore 13
    //   638: aload 11
    //   640: astore 8
    //   642: aload 10
    //   644: astore 9
    //   646: aload 12
    //   648: astore 10
    //   650: aload 13
    //   652: astore 11
    //   654: goto +2494 -> 3148
    //   657: ldc_w 4749
    //   660: aload 13
    //   662: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   665: ifeq +39 -> 704
    //   668: ldc_w 283
    //   671: aload 12
    //   673: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   676: ifeq +2499 -> 3175
    //   679: iconst_1
    //   680: istore_1
    //   681: aload 8
    //   683: astore 12
    //   685: aload 11
    //   687: astore 8
    //   689: aload 9
    //   691: astore 11
    //   693: aload 10
    //   695: astore 9
    //   697: aload 12
    //   699: astore 10
    //   701: goto +2447 -> 3148
    //   704: ldc_w 4751
    //   707: aload 13
    //   709: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   712: ifeq +30 -> 742
    //   715: aload 8
    //   717: astore 11
    //   719: aload 9
    //   721: astore 13
    //   723: aload 12
    //   725: astore 8
    //   727: aload 10
    //   729: astore 9
    //   731: aload 11
    //   733: astore 10
    //   735: aload 13
    //   737: astore 11
    //   739: goto +2409 -> 3148
    //   742: ldc_w 1698
    //   745: aload 13
    //   747: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   750: ifeq +26 -> 776
    //   753: aload 9
    //   755: astore 13
    //   757: aload 8
    //   759: astore 10
    //   761: aload 11
    //   763: astore 8
    //   765: aload 12
    //   767: astore 9
    //   769: aload 13
    //   771: astore 11
    //   773: goto +2375 -> 3148
    //   776: aload 14
    //   778: aload 13
    //   780: aload 12
    //   782: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   785: pop
    //   786: goto +2389 -> 3175
    //   789: aload 9
    //   791: ifnull +2411 -> 3202
    //   794: aload 8
    //   796: ifnull +2406 -> 3202
    //   799: ldc 56
    //   801: aload 9
    //   803: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   806: ifne +2396 -> 3202
    //   809: ldc 56
    //   811: aload 8
    //   813: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   816: ifeq +6 -> 822
    //   819: goto +2383 -> 3202
    //   822: aload_0
    //   823: getfield 4752	bheh:jdField_a_of_type_Boolean	Z
    //   826: ifeq +22 -> 848
    //   829: invokestatic 4757	bhew:a	()Lbhew;
    //   832: aload_0
    //   833: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   836: aload 9
    //   838: aload 8
    //   840: invokevirtual 4760	bhew:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   843: ifeq +5 -> 848
    //   846: iconst_0
    //   847: ireturn
    //   848: iconst_0
    //   849: istore 4
    //   851: iload 4
    //   853: istore_3
    //   854: aload 9
    //   856: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   859: ifne +38 -> 897
    //   862: getstatic 49	bheh:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   865: astore 12
    //   867: aload 12
    //   869: arraylength
    //   870: istore 5
    //   872: iconst_0
    //   873: istore_2
    //   874: iload 4
    //   876: istore_3
    //   877: iload_2
    //   878: iload 5
    //   880: if_icmpge +17 -> 897
    //   883: aload 9
    //   885: aload 12
    //   887: iload_2
    //   888: aaload
    //   889: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   892: ifeq +234 -> 1126
    //   895: iconst_1
    //   896: istore_3
    //   897: iload_3
    //   898: ifne +55 -> 953
    //   901: aload 14
    //   903: ldc_w 4733
    //   906: aconst_null
    //   907: checkcast 45	java/lang/String
    //   910: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   913: pop
    //   914: aload 14
    //   916: ldc_w 4762
    //   919: aconst_null
    //   920: checkcast 45	java/lang/String
    //   923: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   926: pop
    //   927: aload 14
    //   929: ldc_w 2125
    //   932: aconst_null
    //   933: checkcast 45	java/lang/String
    //   936: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   939: pop
    //   940: aload 14
    //   942: ldc_w 4726
    //   945: aconst_null
    //   946: checkcast 45	java/lang/String
    //   949: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   952: pop
    //   953: aload 8
    //   955: ldc_w 4276
    //   958: invokevirtual 618	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   961: ifeq +112 -> 1073
    //   964: aload 14
    //   966: ldc_w 4764
    //   969: ldc_w 4766
    //   972: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   975: pop
    //   976: aload_0
    //   977: getfield 58	bheh:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   980: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   983: ifne +16 -> 999
    //   986: aload 14
    //   988: ldc_w 4768
    //   991: aload_0
    //   992: getfield 58	bheh:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   995: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   998: pop
    //   999: aload_0
    //   1000: getfield 60	bheh:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1003: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1006: ifne +16 -> 1022
    //   1009: aload 14
    //   1011: ldc_w 4770
    //   1014: aload_0
    //   1015: getfield 60	bheh:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1018: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1021: pop
    //   1022: aload_0
    //   1023: getfield 62	bheh:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1026: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1029: ifne +16 -> 1045
    //   1032: aload 14
    //   1034: ldc_w 4772
    //   1037: aload_0
    //   1038: getfield 62	bheh:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1041: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1044: pop
    //   1045: aload 14
    //   1047: ldc_w 4774
    //   1050: aload_0
    //   1051: getfield 4776	bheh:jdField_e_of_type_Boolean	Z
    //   1054: invokevirtual 757	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1057: pop
    //   1058: aload 14
    //   1060: aload 8
    //   1062: invokestatic 4782	cooperation/qzone/report/lp/QZoneLoginReportHelper:needAddLoginFromLebaTab	(Landroid/content/Intent;Ljava/lang/String;)Z
    //   1065: ifeq +8 -> 1073
    //   1068: aload 14
    //   1070: invokestatic 4785	cooperation/qzone/report/lp/QZoneLoginReportHelper:setLoginFromLebaTab	(Landroid/content/Intent;)V
    //   1073: iload_1
    //   1074: ifne +2030 -> 3104
    //   1077: aload 8
    //   1079: ldc_w 4276
    //   1082: invokevirtual 618	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1085: ifeq +104 -> 1189
    //   1088: aload 14
    //   1090: aload 8
    //   1092: invokestatic 4387	cooperation/qzone/QzonePluginProxyActivity:setActivityNameToIntent	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1095: aload 14
    //   1097: ldc_w 1271
    //   1100: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1103: pop
    //   1104: aload_0
    //   1105: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1108: checkcast 160	android/app/Activity
    //   1111: aload_0
    //   1112: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1115: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1118: aload 14
    //   1120: iconst_m1
    //   1121: invokestatic 4789	cooperation/qzone/QzonePluginProxyActivity:launchPluingActivityForResult	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;I)V
    //   1124: iconst_1
    //   1125: ireturn
    //   1126: iload_2
    //   1127: iconst_1
    //   1128: iadd
    //   1129: istore_2
    //   1130: goto -256 -> 874
    //   1133: astore 8
    //   1135: new 134	android/content/Intent
    //   1138: dup
    //   1139: aload_0
    //   1140: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1143: ldc_w 4791
    //   1146: invokespecial 212	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1149: astore 8
    //   1151: aload 8
    //   1153: ldc_w 1269
    //   1156: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1159: pop
    //   1160: aload 8
    //   1162: aload 14
    //   1164: invokevirtual 4560	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   1167: pop
    //   1168: aload_0
    //   1169: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1172: aload 8
    //   1174: invokevirtual 216	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1177: goto -53 -> 1124
    //   1180: astore 8
    //   1182: aload 8
    //   1184: invokevirtual 4792	android/content/ActivityNotFoundException:printStackTrace	()V
    //   1187: iconst_0
    //   1188: ireturn
    //   1189: aload 8
    //   1191: ldc_w 4794
    //   1194: invokevirtual 4034	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1197: ifeq +60 -> 1257
    //   1200: aload_0
    //   1201: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1204: aload_0
    //   1205: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1208: invokestatic 2192	bffn:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)V
    //   1211: aload_0
    //   1212: getfield 683	bheh:jdField_d_of_type_Boolean	Z
    //   1215: ifeq +1989 -> 3204
    //   1218: ldc_w 531
    //   1221: astore 8
    //   1223: aload_0
    //   1224: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1227: ldc_w 761
    //   1230: ldc_w 4796
    //   1233: ldc 56
    //   1235: ldc_w 4798
    //   1238: ldc_w 4800
    //   1241: iconst_0
    //   1242: iconst_0
    //   1243: ldc 56
    //   1245: ldc 56
    //   1247: ldc 56
    //   1249: aload 8
    //   1251: invokestatic 203	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1254: goto -130 -> 1124
    //   1257: aload 8
    //   1259: ldc_w 4802
    //   1262: invokevirtual 4034	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1265: istore 6
    //   1267: iload 6
    //   1269: ifeq +233 -> 1502
    //   1272: aload_0
    //   1273: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1276: checkcast 4320	android/support/v4/app/FragmentActivity
    //   1279: invokevirtual 4339	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   1282: astore 9
    //   1284: aload 9
    //   1286: ifnull -162 -> 1124
    //   1289: aload 9
    //   1291: invokevirtual 4344	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   1294: ifnull -170 -> 1124
    //   1297: aload 9
    //   1299: invokevirtual 4344	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   1302: invokevirtual 4805	com/tencent/mobileqq/activity/aio/core/BaseChatPie:createQQMapActivityProxy	()V
    //   1305: aload 9
    //   1307: invokevirtual 4344	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;
    //   1310: getfield 4809	com/tencent/mobileqq/activity/aio/core/BaseChatPie:sessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1313: getfield 4812	com/tencent/mobileqq/activity/aio/SessionInfo:curType	I
    //   1316: istore_1
    //   1317: aload 14
    //   1319: ldc_w 752
    //   1322: aload_0
    //   1323: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1326: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1329: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1332: pop
    //   1333: aload 14
    //   1335: ldc_w 4814
    //   1338: iload_1
    //   1339: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1342: pop
    //   1343: aload 14
    //   1345: ldc_w 2177
    //   1348: invokevirtual 2861	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1351: astore 11
    //   1353: aload 14
    //   1355: ldc_w 2175
    //   1358: invokevirtual 2861	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1361: astore 10
    //   1363: aload 14
    //   1365: ldc_w 4816
    //   1368: invokevirtual 2861	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1371: astore 9
    //   1373: aload 11
    //   1375: ifnull +79 -> 1454
    //   1378: aload 10
    //   1380: ifnull +74 -> 1454
    //   1383: aload 11
    //   1385: invokestatic 4821	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1388: astore 11
    //   1390: aload 10
    //   1392: invokestatic 4821	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1395: astore 10
    //   1397: aload 14
    //   1399: ldc 173
    //   1401: new 113	java/lang/StringBuilder
    //   1404: dup
    //   1405: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1408: ldc_w 4823
    //   1411: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: aload 11
    //   1416: invokevirtual 1242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1419: ldc_w 2220
    //   1422: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: aload 10
    //   1427: invokevirtual 1242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1430: ldc_w 4825
    //   1433: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: aload 9
    //   1438: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: ldc_w 4827
    //   1444: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1450: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1453: pop
    //   1454: aload 14
    //   1456: aload_0
    //   1457: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1460: invokevirtual 4830	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1463: aload 8
    //   1465: invokevirtual 1712	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1468: pop
    //   1469: aload_0
    //   1470: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1473: checkcast 1537	com/tencent/mobileqq/app/BaseActivity
    //   1476: aload 14
    //   1478: bipush 18
    //   1480: invokevirtual 4632	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1483: ldc_w 4832
    //   1486: invokestatic 4835	aato:a	(Ljava/lang/String;)V
    //   1489: goto -365 -> 1124
    //   1492: astore 8
    //   1494: aload 8
    //   1496: invokevirtual 1188	java/lang/Exception:printStackTrace	()V
    //   1499: goto -375 -> 1124
    //   1502: aload 8
    //   1504: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1507: ifne +286 -> 1793
    //   1510: aload 9
    //   1512: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1515: ifne +278 -> 1793
    //   1518: aload 8
    //   1520: ldc_w 4837
    //   1523: invokevirtual 628	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1526: ifeq +267 -> 1793
    //   1529: aload 9
    //   1531: ldc 47
    //   1533: invokevirtual 628	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1536: ifeq +257 -> 1793
    //   1539: new 1374	java/lang/StringBuffer
    //   1542: dup
    //   1543: invokespecial 1375	java/lang/StringBuffer:<init>	()V
    //   1546: astore 12
    //   1548: aload_0
    //   1549: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1552: ifnull +229 -> 1781
    //   1555: aload_0
    //   1556: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1559: getfield 4839	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1562: invokevirtual 1738	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1565: ifle +216 -> 1781
    //   1568: aload_0
    //   1569: getfield 4743	bheh:jdField_c_of_type_Boolean	Z
    //   1572: ifeq +209 -> 1781
    //   1575: aload 12
    //   1577: ldc_w 4841
    //   1580: invokevirtual 3966	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1583: pop
    //   1584: aload_0
    //   1585: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1588: getfield 4839	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1591: invokevirtual 4842	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1594: ifeq +38 -> 1632
    //   1597: aload 12
    //   1599: new 113	java/lang/StringBuilder
    //   1602: dup
    //   1603: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1606: ldc_w 4844
    //   1609: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: aload_0
    //   1613: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1616: getfield 4839	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1619: invokevirtual 1738	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1622: invokevirtual 724	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1625: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1628: invokevirtual 3966	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1631: pop
    //   1632: aload_0
    //   1633: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1636: getfield 1767	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1639: invokevirtual 1771	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1642: istore 6
    //   1644: iload 6
    //   1646: ifeq +48 -> 1694
    //   1649: aload_0
    //   1650: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1653: getfield 1767	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1656: invokevirtual 1773	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1659: ldc_w 1484
    //   1662: invokestatic 1490	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1665: astore 10
    //   1667: aload 12
    //   1669: new 113	java/lang/StringBuilder
    //   1672: dup
    //   1673: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1676: ldc_w 4846
    //   1679: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: aload 10
    //   1684: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1690: invokevirtual 3966	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1693: pop
    //   1694: aload_0
    //   1695: ldc 173
    //   1697: invokevirtual 416	bheh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1700: astore 11
    //   1702: aload 11
    //   1704: astore 10
    //   1706: aload 11
    //   1708: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1711: ifne +27 -> 1738
    //   1714: aload 11
    //   1716: astore 10
    //   1718: aload 11
    //   1720: invokestatic 4850	znl:g	(Ljava/lang/String;)Z
    //   1723: ifeq +15 -> 1738
    //   1726: aload 11
    //   1728: aload 12
    //   1730: invokevirtual 4002	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1733: invokestatic 4854	nuz:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1736: astore 10
    //   1738: aload_0
    //   1739: aload 10
    //   1741: aload 9
    //   1743: aload 8
    //   1745: aload 14
    //   1747: invokespecial 4856	bheh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1750: aload_0
    //   1751: aload 8
    //   1753: invokespecial 4858	bheh:g	(Ljava/lang/String;)V
    //   1756: goto -632 -> 1124
    //   1759: astore 10
    //   1761: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1764: ifeq +1448 -> 3212
    //   1767: ldc 111
    //   1769: iconst_2
    //   1770: aload 10
    //   1772: invokevirtual 4859	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   1775: invokestatic 1396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1778: goto +1434 -> 3212
    //   1781: aload 12
    //   1783: ldc_w 4861
    //   1786: invokevirtual 3966	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1789: pop
    //   1790: goto -96 -> 1694
    //   1793: aload 8
    //   1795: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1798: ifne +606 -> 2404
    //   1801: aload 9
    //   1803: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1806: ifne +598 -> 2404
    //   1809: aload 8
    //   1811: ldc_w 4863
    //   1814: invokevirtual 628	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1817: ifeq +587 -> 2404
    //   1820: aload 9
    //   1822: ldc 47
    //   1824: invokevirtual 628	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1827: ifeq +577 -> 2404
    //   1830: aload_0
    //   1831: ldc 173
    //   1833: invokevirtual 416	bheh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1836: astore 10
    //   1838: aload 10
    //   1840: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1843: ifeq +515 -> 2358
    //   1846: ldc_w 4865
    //   1849: astore 10
    //   1851: new 113	java/lang/StringBuilder
    //   1854: dup
    //   1855: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1858: ldc_w 4867
    //   1861: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1864: invokestatic 738	java/lang/System:currentTimeMillis	()J
    //   1867: invokevirtual 1366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1870: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1873: astore 12
    //   1875: aload 12
    //   1877: astore 11
    //   1879: aload_0
    //   1880: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1883: ifnull +51 -> 1934
    //   1886: aload 12
    //   1888: astore 11
    //   1890: invokestatic 4872	nro:a	()Lnro;
    //   1893: aload 10
    //   1895: invokevirtual 4874	nro:i	(Ljava/lang/String;)Z
    //   1898: ifeq +36 -> 1934
    //   1901: new 113	java/lang/StringBuilder
    //   1904: dup
    //   1905: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1908: aload 12
    //   1910: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1913: ldc_w 642
    //   1916: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: aload_0
    //   1920: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1923: invokevirtual 645	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1926: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1932: astore 11
    //   1934: aload 11
    //   1936: astore 12
    //   1938: aload_0
    //   1939: getfield 1561	bheh:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1942: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1945: ifne +33 -> 1978
    //   1948: new 113	java/lang/StringBuilder
    //   1951: dup
    //   1952: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1955: aload 11
    //   1957: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1960: ldc_w 3564
    //   1963: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: aload_0
    //   1967: getfield 1561	bheh:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1970: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1973: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1976: astore 12
    //   1978: aload 12
    //   1980: astore 11
    //   1982: aload 10
    //   1984: ldc_w 636
    //   1987: invokevirtual 541	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1990: ifge +26 -> 2016
    //   1993: new 113	java/lang/StringBuilder
    //   1996: dup
    //   1997: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   2000: aload 12
    //   2002: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2005: ldc_w 4876
    //   2008: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2014: astore 11
    //   2016: aload 10
    //   2018: aload 11
    //   2020: invokestatic 4854	nuz:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2023: astore 10
    //   2025: aload_0
    //   2026: ldc_w 4718
    //   2029: invokevirtual 416	bheh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2032: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2035: ifne +1183 -> 3218
    //   2038: iconst_1
    //   2039: istore 6
    //   2041: iload 6
    //   2043: ifeq +1102 -> 3145
    //   2046: aload_0
    //   2047: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2050: ifnull +1095 -> 3145
    //   2053: aload_0
    //   2054: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2057: getstatic 4879	com/tencent/mobileqq/app/QQManagerFactory:GAMECENTER_MANAGER	I
    //   2060: invokevirtual 250	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2063: checkcast 4881	bcvc
    //   2066: astore 11
    //   2068: iconst_0
    //   2069: istore_1
    //   2070: aload_0
    //   2071: getfield 683	bheh:jdField_d_of_type_Boolean	Z
    //   2074: ifeq +12 -> 2086
    //   2077: aload_0
    //   2078: getfield 1728	bheh:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   2081: iconst_1
    //   2082: invokestatic 4886	avce:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;Z)I
    //   2085: istore_1
    //   2086: aload 11
    //   2088: invokevirtual 4889	bcvc:a	()Lavce;
    //   2091: iload_1
    //   2092: invokevirtual 4892	avce:a	(I)Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;
    //   2095: astore 11
    //   2097: aload 11
    //   2099: ifnull +1046 -> 3145
    //   2102: ldc 111
    //   2104: iconst_2
    //   2105: iconst_2
    //   2106: anewarray 4	java/lang/Object
    //   2109: dup
    //   2110: iconst_0
    //   2111: ldc_w 4894
    //   2114: aastore
    //   2115: dup
    //   2116: iconst_1
    //   2117: aload 11
    //   2119: aastore
    //   2120: invokestatic 504	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2123: aload 10
    //   2125: ldc_w 4896
    //   2128: invokestatic 4854	nuz:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2131: astore 10
    //   2133: aload 11
    //   2135: aload 14
    //   2137: invokestatic 4899	avce:a	(Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;Landroid/content/Intent;)Landroid/content/Intent;
    //   2140: pop
    //   2141: invokestatic 4901	aves:b	()I
    //   2144: istore_1
    //   2145: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2148: ifeq +40 -> 2188
    //   2151: ldc 111
    //   2153: iconst_2
    //   2154: new 113	java/lang/StringBuilder
    //   2157: dup
    //   2158: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   2161: ldc_w 4903
    //   2164: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2167: iload_1
    //   2168: invokevirtual 724	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2171: ldc_w 4905
    //   2174: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2177: iload 6
    //   2179: invokevirtual 1253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2182: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2185: invokestatic 574	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2188: iload_1
    //   2189: ifne +194 -> 2383
    //   2192: iload 6
    //   2194: ifeq +189 -> 2383
    //   2197: new 306	android/os/Bundle
    //   2200: dup
    //   2201: invokespecial 307	android/os/Bundle:<init>	()V
    //   2204: astore 8
    //   2206: aload 8
    //   2208: ldc_w 4907
    //   2211: iconst_1
    //   2212: invokevirtual 1329	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2215: aload 8
    //   2217: ldc_w 4909
    //   2220: iconst_1
    //   2221: invokevirtual 1329	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2224: aload 8
    //   2226: ldc_w 4911
    //   2229: iconst_0
    //   2230: invokevirtual 1329	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2233: aload 8
    //   2235: ldc_w 4913
    //   2238: ldc_w 4915
    //   2241: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2244: aload 8
    //   2246: ldc 173
    //   2248: aload 10
    //   2250: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2253: aload 8
    //   2255: ldc_w 4917
    //   2258: aload 10
    //   2260: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2263: aload_0
    //   2264: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2267: aload 8
    //   2269: invokestatic 4923	com/tencent/hippy/qq/utils/HippyAccessHelper:openHippyPage	(Landroid/content/Context;Landroid/os/Bundle;)Z
    //   2272: pop
    //   2273: iload 6
    //   2275: ifeq +10 -> 2285
    //   2278: invokestatic 4928	com/tencent/hippy/qq/utils/HippyReporter:getInstance	()Lcom/tencent/hippy/qq/utils/HippyReporter;
    //   2281: iload_1
    //   2282: invokevirtual 4931	com/tencent/hippy/qq/utils/HippyReporter:reportGameCenterHippy	(I)V
    //   2285: aload_0
    //   2286: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2289: ifnull +37 -> 2326
    //   2292: aload_0
    //   2293: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2296: ldc_w 4933
    //   2299: invokevirtual 4937	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   2302: astore 8
    //   2304: aload 8
    //   2306: ifnull +20 -> 2326
    //   2309: aload 8
    //   2311: aload 8
    //   2313: ldc_w 4938
    //   2316: invokevirtual 4942	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   2319: ldc2_w 4943
    //   2322: invokevirtual 4948	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   2325: pop
    //   2326: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2329: ifeq +12 -> 2341
    //   2332: ldc 111
    //   2334: iconst_2
    //   2335: ldc_w 4950
    //   2338: invokestatic 574	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2341: new 4952	com/tencent/mobileqq/utils/JumpAction$23
    //   2344: dup
    //   2345: aload_0
    //   2346: invokespecial 4953	com/tencent/mobileqq/utils/JumpAction$23:<init>	(Lbheh;)V
    //   2349: iconst_5
    //   2350: aconst_null
    //   2351: iconst_1
    //   2352: invokestatic 583	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2355: goto -1231 -> 1124
    //   2358: aload 10
    //   2360: invokestatic 553	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   2363: astore 10
    //   2365: goto -514 -> 1851
    //   2368: astore 10
    //   2370: aload 10
    //   2372: invokevirtual 1188	java/lang/Exception:printStackTrace	()V
    //   2375: ldc_w 4865
    //   2378: astore 10
    //   2380: goto -529 -> 1851
    //   2383: aload_0
    //   2384: aload 10
    //   2386: aload 9
    //   2388: aload 8
    //   2390: aload 14
    //   2392: invokespecial 4856	bheh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2395: aload_0
    //   2396: aload 8
    //   2398: invokespecial 4858	bheh:g	(Ljava/lang/String;)V
    //   2401: goto -128 -> 2273
    //   2404: aload 8
    //   2406: ldc_w 4955
    //   2409: invokevirtual 4034	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2412: ifeq +171 -> 2583
    //   2415: aload_0
    //   2416: ldc_w 937
    //   2419: invokevirtual 416	bheh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2422: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2425: ifne +52 -> 2477
    //   2428: aload 14
    //   2430: ldc_w 4957
    //   2433: iconst_4
    //   2434: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2437: pop
    //   2438: aload 14
    //   2440: ldc_w 4959
    //   2443: aload 14
    //   2445: ldc_w 4959
    //   2448: iconst_1
    //   2449: invokevirtual 2864	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2452: iconst_4
    //   2453: ior
    //   2454: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2457: pop
    //   2458: aload_0
    //   2459: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2462: aload_0
    //   2463: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2466: checkcast 160	android/app/Activity
    //   2469: aload 14
    //   2471: invokestatic 4962	bmhv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2474: goto -1350 -> 1124
    //   2477: aload_0
    //   2478: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2481: ldc_w 1617
    //   2484: ldc 56
    //   2486: ldc 56
    //   2488: ldc_w 4964
    //   2491: ldc_w 4964
    //   2494: iconst_0
    //   2495: iconst_0
    //   2496: ldc 56
    //   2498: ldc 56
    //   2500: ldc 56
    //   2502: ldc 56
    //   2504: iconst_0
    //   2505: invokestatic 3207	olh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2508: invokestatic 4969	sqp:a	()Lsqp;
    //   2511: invokestatic 4969	sqp:a	()Lsqp;
    //   2514: invokevirtual 4970	sqp:b	()Z
    //   2517: ldc_w 4972
    //   2520: iconst_1
    //   2521: invokevirtual 4975	sqp:a	(ZLjava/lang/String;I)V
    //   2524: aload 14
    //   2526: ldc_w 4957
    //   2529: iconst_1
    //   2530: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2533: pop
    //   2534: aload 14
    //   2536: ldc_w 4977
    //   2539: invokestatic 738	java/lang/System:currentTimeMillis	()J
    //   2542: invokevirtual 741	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2545: pop
    //   2546: aload_0
    //   2547: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2550: getstatic 4980	com/tencent/mobileqq/app/QQManagerFactory:READINJOY_MANAGER	I
    //   2553: invokevirtual 250	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2556: checkcast 4982	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager
    //   2559: aload 14
    //   2561: invokevirtual 4983	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager:a	(Landroid/content/Intent;)V
    //   2564: aload_0
    //   2565: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2568: aload_0
    //   2569: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2572: checkcast 160	android/app/Activity
    //   2575: aload 14
    //   2577: invokestatic 4962	bmhv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2580: goto -1456 -> 1124
    //   2583: aload 8
    //   2585: ldc_w 4794
    //   2588: invokevirtual 4034	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2591: ifeq +14 -> 2605
    //   2594: aload 14
    //   2596: ldc_w 937
    //   2599: bipush 15
    //   2601: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2604: pop
    //   2605: aload 8
    //   2607: ldc_w 4985
    //   2610: invokevirtual 4034	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2613: ifeq +16 -> 2629
    //   2616: aload 14
    //   2618: ldc_w 4987
    //   2621: aload_0
    //   2622: getfield 483	bheh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2625: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2628: pop
    //   2629: aload 8
    //   2631: getstatic 4988	cooperation/comic/VipComicJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2634: invokevirtual 4034	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2637: ifeq +39 -> 2676
    //   2640: aload 14
    //   2642: invokestatic 4991	cooperation/comic/VipComicJumpActivity:a	(Landroid/content/Intent;)Lblqv;
    //   2645: astore 11
    //   2647: aload_0
    //   2648: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2651: aload_0
    //   2652: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2655: checkcast 160	android/app/Activity
    //   2658: aload 11
    //   2660: invokestatic 4994	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lblqv;)Z
    //   2663: ifeq +13 -> 2676
    //   2666: aload_0
    //   2667: getfield 92	bheh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2670: iconst_1
    //   2671: invokestatic 4997	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Z)V
    //   2674: iconst_1
    //   2675: ireturn
    //   2676: aload 9
    //   2678: ifnull -1554 -> 1124
    //   2681: aload 9
    //   2683: invokestatic 1136	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2686: invokevirtual 4998	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   2689: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2692: istore 6
    //   2694: iload 6
    //   2696: ifeq +368 -> 3064
    //   2699: iconst_0
    //   2700: istore 6
    //   2702: ldc_w 5000
    //   2705: invokestatic 1136	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2708: invokevirtual 5004	com/tencent/qphone/base/util/BaseApplication:getClassLoader	()Ljava/lang/ClassLoader;
    //   2711: aload 8
    //   2713: invokevirtual 5010	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   2716: invokevirtual 5014	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   2719: istore 7
    //   2721: iload 7
    //   2723: istore 6
    //   2725: iload 6
    //   2727: ifeq +5 -> 2732
    //   2730: iconst_0
    //   2731: ireturn
    //   2732: aload 14
    //   2734: ldc_w 5016
    //   2737: invokevirtual 2861	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2740: astore 11
    //   2742: aload 11
    //   2744: ifnull +396 -> 3140
    //   2747: aload 11
    //   2749: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2752: istore_1
    //   2753: aload 8
    //   2755: ldc_w 5018
    //   2758: invokevirtual 628	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2761: ifeq +186 -> 2947
    //   2764: ldc_w 5020
    //   2767: astore 8
    //   2769: ldc_w 5022
    //   2772: aload 8
    //   2774: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2777: ifeq +202 -> 2979
    //   2780: aload 14
    //   2782: ldc_w 5024
    //   2785: invokevirtual 2861	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2788: astore 12
    //   2790: aload 8
    //   2792: astore 11
    //   2794: aload 12
    //   2796: ifnull +38 -> 2834
    //   2799: aload 8
    //   2801: astore 11
    //   2803: aload 12
    //   2805: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2808: iconst_2
    //   2809: if_icmpne +25 -> 2834
    //   2812: iload_1
    //   2813: invokestatic 5028	bjxa:b	(I)Z
    //   2816: ifeq +415 -> 3231
    //   2819: ldc_w 5030
    //   2822: astore 11
    //   2824: aload 14
    //   2826: ldc_w 5016
    //   2829: iload_1
    //   2830: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2833: pop
    //   2834: aload 10
    //   2836: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2839: ifne +127 -> 2966
    //   2842: aload 10
    //   2844: invokevirtual 5033	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2847: ldc 239
    //   2849: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2852: ifeq +114 -> 2966
    //   2855: aload 14
    //   2857: ldc_w 824
    //   2860: bipush 117
    //   2862: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2865: pop
    //   2866: aload 14
    //   2868: ldc_w 1196
    //   2871: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2874: pop
    //   2875: aload 11
    //   2877: astore 8
    //   2879: ldc_w 5035
    //   2882: aload 8
    //   2884: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2887: ifeq +149 -> 3036
    //   2890: aload 14
    //   2892: ldc 173
    //   2894: invokevirtual 2861	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2897: astore 10
    //   2899: aload 10
    //   2901: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2904: ifne +132 -> 3036
    //   2907: aload 10
    //   2909: ldc_w 4498
    //   2912: invokevirtual 618	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2915: ifne +121 -> 3036
    //   2918: ldc 111
    //   2920: iconst_1
    //   2921: new 113	java/lang/StringBuilder
    //   2924: dup
    //   2925: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   2928: ldc_w 5037
    //   2931: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2934: aload 10
    //   2936: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2939: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2942: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2945: iconst_0
    //   2946: ireturn
    //   2947: aload 8
    //   2949: ldc_w 5039
    //   2952: invokevirtual 628	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2955: ifeq +182 -> 3137
    //   2958: ldc_w 5022
    //   2961: astore 8
    //   2963: goto -194 -> 2769
    //   2966: aload 14
    //   2968: ldc_w 824
    //   2971: iconst_2
    //   2972: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2975: pop
    //   2976: goto -110 -> 2866
    //   2979: ldc_w 5020
    //   2982: aload 8
    //   2984: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2987: ifeq +28 -> 3015
    //   2990: iload_1
    //   2991: invokestatic 5028	bjxa:b	(I)Z
    //   2994: ifeq -115 -> 2879
    //   2997: ldc_w 5030
    //   3000: astore 8
    //   3002: aload 14
    //   3004: ldc_w 5016
    //   3007: iload_1
    //   3008: invokevirtual 804	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3011: pop
    //   3012: goto -133 -> 2879
    //   3015: aload 14
    //   3017: ldc_w 1714
    //   3020: invokevirtual 1510	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   3023: pop
    //   3024: aload 14
    //   3026: ldc_w 1269
    //   3029: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   3032: pop
    //   3033: goto -154 -> 2879
    //   3036: aload 14
    //   3038: aload 9
    //   3040: aload 8
    //   3042: invokevirtual 1712	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3045: pop
    //   3046: aload_0
    //   3047: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3050: aload 14
    //   3052: invokevirtual 216	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   3055: aload_0
    //   3056: aload 8
    //   3058: invokespecial 4858	bheh:g	(Ljava/lang/String;)V
    //   3061: goto -1937 -> 1124
    //   3064: aload 14
    //   3066: aload 9
    //   3068: aload 8
    //   3070: invokevirtual 1712	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3073: pop
    //   3074: aload 14
    //   3076: ldc_w 1714
    //   3079: invokevirtual 1510	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   3082: pop
    //   3083: aload 14
    //   3085: ldc_w 1269
    //   3088: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   3091: pop
    //   3092: aload_0
    //   3093: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3096: aload 14
    //   3098: invokevirtual 216	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   3101: goto -1977 -> 1124
    //   3104: iload_1
    //   3105: iconst_1
    //   3106: if_icmpne -1982 -> 1124
    //   3109: aload 11
    //   3111: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3114: ifne -1990 -> 1124
    //   3117: aload_0
    //   3118: aload 14
    //   3120: aload 8
    //   3122: aload 11
    //   3124: invokespecial 5041	bheh:a	(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Z
    //   3127: istore 6
    //   3129: iload 6
    //   3131: ireturn
    //   3132: astore 11
    //   3134: goto -409 -> 2725
    //   3137: goto -368 -> 2769
    //   3140: iconst_0
    //   3141: istore_1
    //   3142: goto -389 -> 2753
    //   3145: goto -1004 -> 2141
    //   3148: aload 10
    //   3150: astore 12
    //   3152: aload 11
    //   3154: astore 13
    //   3156: aload 8
    //   3158: astore 11
    //   3160: aload 9
    //   3162: astore 10
    //   3164: aload 12
    //   3166: astore 8
    //   3168: aload 13
    //   3170: astore 9
    //   3172: goto -3021 -> 151
    //   3175: aload 8
    //   3177: astore 12
    //   3179: aload 9
    //   3181: astore 13
    //   3183: aload 11
    //   3185: astore 8
    //   3187: aload 10
    //   3189: astore 9
    //   3191: aload 12
    //   3193: astore 10
    //   3195: aload 13
    //   3197: astore 11
    //   3199: goto -51 -> 3148
    //   3202: iconst_0
    //   3203: ireturn
    //   3204: ldc_w 283
    //   3207: astore 8
    //   3209: goto -1986 -> 1223
    //   3212: aconst_null
    //   3213: astore 10
    //   3215: goto -1548 -> 1667
    //   3218: iconst_0
    //   3219: istore 6
    //   3221: goto -1180 -> 2041
    //   3224: astore 11
    //   3226: iconst_0
    //   3227: istore_1
    //   3228: goto -475 -> 2753
    //   3231: ldc_w 5020
    //   3234: astore 11
    //   3236: goto -402 -> 2834
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3239	0	this	bheh
    //   37	3191	1	i1	int
    //   873	257	2	i2	int
    //   853	45	3	i3	int
    //   849	26	4	i4	int
    //   870	11	5	i5	int
    //   1265	1955	6	bool1	boolean
    //   2719	3	7	bool2	boolean
    //   22	1069	8	localObject1	Object
    //   1133	1	8	localException1	Exception
    //   1149	24	8	localIntent1	Intent
    //   1180	10	8	localActivityNotFoundException	android.content.ActivityNotFoundException
    //   1221	243	8	str1	String
    //   1492	318	8	localException2	Exception
    //   2204	1004	8	localObject2	Object
    //   19	3171	9	localObject3	Object
    //   25	1715	10	localObject4	Object
    //   1759	12	10	localUnsupportedEncodingException	UnsupportedEncodingException
    //   1836	528	10	str2	String
    //   2368	3	10	localException3	Exception
    //   2378	836	10	localObject5	Object
    //   40	3083	11	localObject6	Object
    //   3132	21	11	localException4	Exception
    //   3158	40	11	localObject7	Object
    //   3224	1	11	localException5	Exception
    //   3234	1	11	str3	String
    //   34	3158	12	localObject8	Object
    //   49	3147	13	localObject9	Object
    //   10	3109	14	localIntent2	Intent
    //   149	13	15	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   1104	1124	1133	java/lang/Exception
    //   0	18	1180	android/content/ActivityNotFoundException
    //   27	36	1180	android/content/ActivityNotFoundException
    //   42	70	1180	android/content/ActivityNotFoundException
    //   70	142	1180	android/content/ActivityNotFoundException
    //   142	151	1180	android/content/ActivityNotFoundException
    //   151	197	1180	android/content/ActivityNotFoundException
    //   207	218	1180	android/content/ActivityNotFoundException
    //   241	252	1180	android/content/ActivityNotFoundException
    //   271	309	1180	android/content/ActivityNotFoundException
    //   336	367	1180	android/content/ActivityNotFoundException
    //   371	395	1180	android/content/ActivityNotFoundException
    //   395	406	1180	android/content/ActivityNotFoundException
    //   433	471	1180	android/content/ActivityNotFoundException
    //   498	532	1180	android/content/ActivityNotFoundException
    //   559	630	1180	android/content/ActivityNotFoundException
    //   657	679	1180	android/content/ActivityNotFoundException
    //   704	715	1180	android/content/ActivityNotFoundException
    //   742	753	1180	android/content/ActivityNotFoundException
    //   776	786	1180	android/content/ActivityNotFoundException
    //   799	819	1180	android/content/ActivityNotFoundException
    //   822	846	1180	android/content/ActivityNotFoundException
    //   854	872	1180	android/content/ActivityNotFoundException
    //   883	895	1180	android/content/ActivityNotFoundException
    //   901	953	1180	android/content/ActivityNotFoundException
    //   953	999	1180	android/content/ActivityNotFoundException
    //   999	1022	1180	android/content/ActivityNotFoundException
    //   1022	1045	1180	android/content/ActivityNotFoundException
    //   1045	1073	1180	android/content/ActivityNotFoundException
    //   1077	1104	1180	android/content/ActivityNotFoundException
    //   1104	1124	1180	android/content/ActivityNotFoundException
    //   1135	1177	1180	android/content/ActivityNotFoundException
    //   1189	1218	1180	android/content/ActivityNotFoundException
    //   1223	1254	1180	android/content/ActivityNotFoundException
    //   1257	1267	1180	android/content/ActivityNotFoundException
    //   1272	1284	1180	android/content/ActivityNotFoundException
    //   1289	1373	1180	android/content/ActivityNotFoundException
    //   1383	1454	1180	android/content/ActivityNotFoundException
    //   1454	1489	1180	android/content/ActivityNotFoundException
    //   1494	1499	1180	android/content/ActivityNotFoundException
    //   1502	1632	1180	android/content/ActivityNotFoundException
    //   1632	1644	1180	android/content/ActivityNotFoundException
    //   1649	1667	1180	android/content/ActivityNotFoundException
    //   1667	1694	1180	android/content/ActivityNotFoundException
    //   1694	1702	1180	android/content/ActivityNotFoundException
    //   1706	1714	1180	android/content/ActivityNotFoundException
    //   1718	1738	1180	android/content/ActivityNotFoundException
    //   1738	1756	1180	android/content/ActivityNotFoundException
    //   1761	1778	1180	android/content/ActivityNotFoundException
    //   1781	1790	1180	android/content/ActivityNotFoundException
    //   1793	1846	1180	android/content/ActivityNotFoundException
    //   1851	1875	1180	android/content/ActivityNotFoundException
    //   1879	1886	1180	android/content/ActivityNotFoundException
    //   1890	1934	1180	android/content/ActivityNotFoundException
    //   1938	1978	1180	android/content/ActivityNotFoundException
    //   1982	2016	1180	android/content/ActivityNotFoundException
    //   2016	2038	1180	android/content/ActivityNotFoundException
    //   2046	2068	1180	android/content/ActivityNotFoundException
    //   2070	2086	1180	android/content/ActivityNotFoundException
    //   2086	2097	1180	android/content/ActivityNotFoundException
    //   2102	2141	1180	android/content/ActivityNotFoundException
    //   2141	2188	1180	android/content/ActivityNotFoundException
    //   2197	2273	1180	android/content/ActivityNotFoundException
    //   2278	2285	1180	android/content/ActivityNotFoundException
    //   2285	2304	1180	android/content/ActivityNotFoundException
    //   2309	2326	1180	android/content/ActivityNotFoundException
    //   2326	2341	1180	android/content/ActivityNotFoundException
    //   2341	2355	1180	android/content/ActivityNotFoundException
    //   2358	2365	1180	android/content/ActivityNotFoundException
    //   2370	2375	1180	android/content/ActivityNotFoundException
    //   2383	2401	1180	android/content/ActivityNotFoundException
    //   2404	2474	1180	android/content/ActivityNotFoundException
    //   2477	2580	1180	android/content/ActivityNotFoundException
    //   2583	2605	1180	android/content/ActivityNotFoundException
    //   2605	2629	1180	android/content/ActivityNotFoundException
    //   2629	2674	1180	android/content/ActivityNotFoundException
    //   2681	2694	1180	android/content/ActivityNotFoundException
    //   2702	2721	1180	android/content/ActivityNotFoundException
    //   2732	2742	1180	android/content/ActivityNotFoundException
    //   2747	2753	1180	android/content/ActivityNotFoundException
    //   2753	2764	1180	android/content/ActivityNotFoundException
    //   2769	2790	1180	android/content/ActivityNotFoundException
    //   2803	2819	1180	android/content/ActivityNotFoundException
    //   2824	2834	1180	android/content/ActivityNotFoundException
    //   2834	2866	1180	android/content/ActivityNotFoundException
    //   2866	2875	1180	android/content/ActivityNotFoundException
    //   2879	2945	1180	android/content/ActivityNotFoundException
    //   2947	2958	1180	android/content/ActivityNotFoundException
    //   2966	2976	1180	android/content/ActivityNotFoundException
    //   2979	2990	1180	android/content/ActivityNotFoundException
    //   2990	2997	1180	android/content/ActivityNotFoundException
    //   3002	3012	1180	android/content/ActivityNotFoundException
    //   3015	3033	1180	android/content/ActivityNotFoundException
    //   3036	3061	1180	android/content/ActivityNotFoundException
    //   3064	3101	1180	android/content/ActivityNotFoundException
    //   3109	3129	1180	android/content/ActivityNotFoundException
    //   1272	1284	1492	java/lang/Exception
    //   1289	1373	1492	java/lang/Exception
    //   1383	1454	1492	java/lang/Exception
    //   1454	1489	1492	java/lang/Exception
    //   1649	1667	1759	java/io/UnsupportedEncodingException
    //   2358	2365	2368	java/lang/Exception
    //   2702	2721	3132	java/lang/Exception
    //   2747	2753	3224	java/lang/Exception
  }
  
  private boolean bx()
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492C", "0X800492C", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.e("qqdataline", 2, "shareFromMigSdk|report send from sdk:0X800492C.");
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject2 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    String str1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    Object localObject6 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {}
    for (localObject1 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; localObject1 = null)
    {
      Object localObject7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
      String str4 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      String str3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
      String str5 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
      String str7 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
      int i2 = 0;
      try
      {
        i1 = Integer.valueOf(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
        l2 = 0L;
      }
      catch (Exception localException2)
      {
        try
        {
          l1 = Long.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).longValue();
          localBundle = new Bundle();
          localBundle.putString("title", (String)localObject2);
          localBundle.putString("desc", (String)localObject4);
          localBundle.putString("image_url", str2);
          localBundle.putString("detail_url", str1);
          localBundle.putLong("req_share_id", l1);
          localBundle.putString("pkg_name", this.jdField_e_of_type_JavaLangString);
          localBundle.putString("image_url_remote", (String)localObject6);
          localBundle.putString("app_name", (String)localObject1);
          localBundle.putString("open_id", str4);
          localBundle.putString("share_uin", str5);
          localBundle.putString("jfrom", str6);
          localBundle.putString("share_qq_ext_str", str7);
          localBundle.putInt("cflag", i1);
          localBundle.putInt("forward_type", 11);
          i2 = 1;
        }
        catch (Exception localException2)
        {
          try
          {
            long l2;
            do
            {
              for (;;)
              {
                Bundle localBundle;
                i1 = Integer.valueOf(str3).intValue();
                localBundle.putInt("req_type", i1);
                if (2 != i1) {
                  break label817;
                }
                localBundle.putString("audio_url", (String)localObject7);
                if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject4)))
                {
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break;
                  }
                  localBundle.putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697880), new Object[] { localObject1 }));
                }
                com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
                localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
                localBundle.putBoolean("MigSdkShareNotDone", true);
                ((Intent)localObject1).putExtras(localBundle);
                ((Intent)localObject1).addFlags(268435456);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                return true;
                localException1 = localException1;
                i1 = i2;
                if (QLog.isColorLevel())
                {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|parse extflags exp: extflag=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"));
                  i1 = i2;
                }
              }
              localException2 = localException2;
              l1 = l2;
            } while (!QLog.isColorLevel());
            QLog.e("qqfav", 2, "gotoQfavShareMsg|parse appid exp: appid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
            l1 = l2;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            int i1;
            label817:
            label894:
            do
            {
              for (;;)
              {
                long l1;
                i1 = i2;
                if (QLog.isColorLevel())
                {
                  QLog.e("qqfav", 2, "gotoQfavShareMsg|parse reqtype exp: reqType=" + str3);
                  i1 = i2;
                  continue;
                  localException2.putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131697881));
                  continue;
                  if (6 == i1)
                  {
                    localObject1 = "";
                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                      localObject1 = localObject2;
                    }
                    localObject2 = localObject1;
                    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                        break label894;
                      }
                    }
                    for (localObject2 = localObject4;; localObject2 = (String)localObject1 + "\n" + (String)localObject4)
                    {
                      localException2.putString("forward_text", (String)localObject2);
                      localException2.putBoolean("isFromShare", true);
                      localException2.putBoolean("key_sdk_share_pure_text", true);
                      break;
                    }
                  }
                  if (5 != i1) {
                    break;
                  }
                  localObject2 = null;
                  localObject1 = null;
                  localObject6 = new ArrayList();
                  Object localObject3;
                  if (!TextUtils.isEmpty(str2))
                  {
                    localObject7 = str2.split(";");
                    i1 = 0;
                    localObject4 = null;
                    for (;;)
                    {
                      localObject5 = localObject4;
                      localObject2 = localObject1;
                      if (i1 >= localObject7.length) {
                        break label1191;
                      }
                      localObject5 = "";
                      try
                      {
                        localObject2 = URLDecoder.decode(localObject7[i1], "UTF-8");
                        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                          if ((((String)localObject2).startsWith("/")) && (new File((String)localObject2).exists()))
                          {
                            ((ArrayList)localObject6).add(localObject2);
                            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                              break label1181;
                            }
                            i1 += 1;
                            localObject1 = localObject2;
                          }
                        }
                      }
                      catch (UnsupportedEncodingException localUnsupportedEncodingException)
                      {
                        for (;;)
                        {
                          localObject3 = localObject5;
                          if (QLog.isColorLevel())
                          {
                            QLog.e("qqfav", 2, "gotoQfavShareMsg|decode exp. imageUrls[i]=" + localObject7[i1]);
                            localObject3 = localObject5;
                            continue;
                            if (localObject3.startsWith("http"))
                            {
                              ((ArrayList)localObject6).add(localObject3);
                              if (TextUtils.isEmpty((CharSequence)localObject4))
                              {
                                localObject4 = localObject3;
                                localObject3 = localObject1;
                                continue;
                                if (QLog.isColorLevel()) {
                                  QLog.e("qqfav", 2, "gotoQfavShareMsg|file path invalid. path=" + localObject3);
                                }
                              }
                            }
                            localObject3 = localObject1;
                          }
                        }
                      }
                    }
                  }
                  Object localObject5 = null;
                  localException2.putString("image_url", localObject3);
                  localException2.putString("image_url_remote", (String)localObject5);
                  localException2.putString("title", null);
                  localException2.putString("desc", null);
                  if (1 == ((ArrayList)localObject6).size())
                  {
                    localObject1 = localObject3;
                    if (TextUtils.isEmpty(localObject3))
                    {
                      localObject1 = localObject3;
                      if (!TextUtils.isEmpty((CharSequence)localObject5))
                      {
                        localException2.putString("image_url", (String)localObject5);
                        localObject1 = localObject5;
                      }
                    }
                    if (auea.a((String)localObject1) == 0)
                    {
                      localException2.putInt("req_type", 5);
                    }
                    else
                    {
                      localException2.putString("forward_text", anvx.a(2131705380) + auea.a((String)localObject1) + anvx.a(2131705381) + FileUtil.filesizeToString(FileUtil.getFileSize((String)localObject1)) + "。");
                      localException2.putBoolean("qdshare_file", true);
                      localException2.putBoolean("isFromShare", true);
                      localException2.putBoolean("key_sdk_share_pure_text", true);
                      localException2.putInt("req_type", 6);
                    }
                  }
                  else if (auea.a(localObject3) == 0)
                  {
                    localException2.putString("title", ((ArrayList)localObject6).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131694371));
                    localException2.putString("qqfav_extra_multi_pic_path_list", str2);
                    localException2.putBoolean("qqfav_extra_multi_pic", true);
                    localException2.putInt("req_type", 1);
                  }
                  else
                  {
                    localObject1 = ((ArrayList)localObject6).iterator();
                    for (l1 = 0L; ((Iterator)localObject1).hasNext(); l1 = FileUtil.getFileSize((String)((Iterator)localObject1).next()) + l1) {}
                    localException2.putString("forward_text", anvx.a(2131705387) + auea.a(localObject3) + anvx.a(2131705375) + ((ArrayList)localObject6).size() + anvx.a(2131705388) + FileUtil.filesizeToString(l1));
                    localException2.putString("qqfav_extra_multi_pic_path_list", str2);
                    localException2.putBoolean("qdshare_file", true);
                    localException2.putBoolean("isFromShare", true);
                    localException2.putBoolean("key_sdk_share_pure_text", true);
                    localException2.putInt("req_type", 6);
                  }
                }
              }
            } while (1 == i1);
            label1181:
            label1191:
            return false;
          }
        }
      }
    }
  }
  
  private boolean by()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, " source:" + this.jdField_a_of_type_JavaLangString + "  serverName:" + this.jdField_b_of_type_JavaLangString + "  hostName:" + this.jdField_c_of_type_JavaLangString);
    }
    Object localObject1;
    if (this.jdField_c_of_type_JavaLangString.equals("index"))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
      ((Intent)localObject1).putExtra("goto_type", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              if (!this.jdField_c_of_type_JavaLangString.equals("detail")) {
                break;
              }
            } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
            localObject1 = bjht.g() + File.separator + "qapp_center_detail.htm";
            if (new File((String)localObject1).exists()) {}
            for (localObject1 = "file:///" + (String)localObject1;; localObject1 = bjht.m() + File.separator + "qapp_center_detail.htm")
            {
              localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
              localObject3 = new Bundle();
              localObject4 = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("param");
              ((Bundle)localObject3).putString("APP_URL", (String)localObject1);
              ((Bundle)localObject3).putString("APP_PARAMS", "&" + (String)localObject4);
              ((Bundle)localObject3).putInt("goto_type", 2);
              ((Intent)localObject2).putExtras((Bundle)localObject3);
              ((Intent)localObject2).putExtra("adapter_action", "action_app_detail");
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
              return true;
            }
            if (!this.jdField_c_of_type_JavaLangString.equals("webview")) {
              break;
            }
          } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("APP_URL", Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("url"));
          ((Bundle)localObject2).putInt("goto_type", 3);
          ((Intent)localObject1).putExtras((Bundle)localObject2);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          return true;
        } while ((!this.jdField_c_of_type_JavaLangString.equals("local")) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
        localObject2 = Uri.parse(this.jdField_a_of_type_JavaLangString);
        localObject1 = ((Uri)localObject2).getQueryParameter("title");
        localObject3 = bjht.a(((Uri)localObject2).getQueryParameter("url"));
      } while (localObject3.length <= 1);
      localObject2 = localObject3[0];
    } while ((!((String)localObject2).startsWith("file://")) || ((!((String)localObject2).contains(bjht.g())) && (!((String)localObject2).contains("android_asset/Page/system/"))));
    Object localObject3 = localObject3[1];
    Object localObject4 = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneAppListActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("APP_URL", (String)localObject2);
    Object localObject2 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((ArrayList)localObject2).add(localObject1);
    }
    localBundle.putStringArrayList("titleName", (ArrayList)localObject2);
    if ((localObject3 != null) && (((String)localObject3).length() > 0)) {
      localBundle.putString("APP_PARAMS", (String)localObject3);
    }
    localBundle.putInt("goto_type", 4);
    ((Intent)localObject4).putExtras(localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
    return true;
  }
  
  private boolean bz()
  {
    blyb.a(this.jdField_a_of_type_AndroidContentContext, 9, null);
    return true;
  }
  
  private String c()
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.MODEL;
    String str3 = QQDeviceInfo.getIMEI("0db4c4");
    String str4 = QQDeviceInfo.getIMSI("0db4c4");
    Object localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay();
    int i1 = ((Display)localObject).getHeight();
    int i2 = ((Display)localObject).getWidth();
    localObject = i2 + "*" + i1;
    i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid();
    return str1 + "|" + str2 + "|" + str3 + "|" + (String)localObject + "|" + str4 + "|" + i1 + "|";
  }
  
  public static String c(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(bhcu.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void c(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("thridparty_pull_main", true);
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    paramQQAppInterface = (String)paramHashMap.get("uin");
    String str1 = (String)paramHashMap.get("usertype");
    String str2 = (String)paramHashMap.get("unionid");
    paramHashMap = (String)paramHashMap.get("fromId");
    if ((TextUtils.isEmpty(str1)) || ((TextUtils.isEmpty(paramQQAppInterface)) && (TextUtils.isEmpty(str2))) || (TextUtils.isEmpty(paramHashMap))) {
      return false;
    }
    try
    {
      if (!TextUtils.isEmpty(str2)) {
        weg.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), str2);
      } else {
        weg.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), Long.valueOf(paramQQAppInterface).longValue());
      }
    }
    catch (Exception paramQQAppInterface)
    {
      return false;
    }
    return true;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str5 = (String)paramHashMap.get("videoOwnerUin");
    String str6 = (String)paramHashMap.get("unionid");
    String str4 = (String)paramHashMap.get("fromId");
    String str2 = (String)paramHashMap.get("videoId");
    String str1 = (String)paramHashMap.get("type");
    str1 = (String)paramHashMap.get("videoList");
    int i1 = b(paramHashMap);
    str1 = (String)paramHashMap.get("feedid");
    int i3 = b(paramHashMap, "ptype", 0);
    int i2;
    if ("0".equals(paramHashMap.get("identify")))
    {
      i2 = 0;
      if (str2 != null) {
        break label799;
      }
      str2 = (String)paramHashMap.get("videoid");
    }
    label799:
    for (;;)
    {
      String str3 = str4;
      if (str4 == null) {
        str3 = (String)paramHashMap.get("fromid");
      }
      if ((!TextUtils.isEmpty(paramString)) && (i3 == 0)) {
        i3 = 7;
      }
      for (;;)
      {
        switch (i3)
        {
        default: 
          paramQQAppInterface = str1;
          if (str1 == null) {
            paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
          }
          i2 = i1;
          if (i1 == 0) {
            i2 = 7;
          }
          xbp.b(paramActivity, str2, paramQQAppInterface, i2);
          return true;
          i2 = 1;
          break;
        case 1: 
          if ("17".equals(str3)) {
            ykv.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = str1;
          if (str1 == null) {
            paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
          }
          i2 = i1;
          if (i1 == 0) {
            i2 = 7;
          }
          xbp.b(paramActivity, str2, paramQQAppInterface, i2);
          return true;
        case 2: 
          if ("17".equals(str3)) {
            ykv.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = (String)paramHashMap.get("et");
          paramQQAppInterface = (String)paramHashMap.get("time_zone");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            Integer.valueOf(paramQQAppInterface).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            xbp.a(paramActivity, str6, str1, 1, 109, 1, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            xbp.a(paramActivity, str5, str1, 1, 109, 1, null);
          }
          return false;
        case 3: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 30;
          }
          xbp.a(paramActivity, str2, str1, i2);
          return true;
        case 4: 
          paramQQAppInterface = (String)paramHashMap.get("collection_id");
          paramHashMap = (String)paramHashMap.get("time_zone");
          i3 = -1;
          if (!TextUtils.isEmpty(paramHashMap)) {
            i3 = Integer.valueOf(paramHashMap).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            xbp.a(paramActivity, str6, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str6), i3, i1, str1, i2, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            xbp.a(paramActivity, str5, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str5), i3, i1, str1, i2, null);
          }
          return false;
        case 7: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 19;
          }
          xbp.b(paramActivity, str2, str1, i2);
          return true;
        case 6: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 57;
          }
          xbp.b(paramActivity, str2, str1, i2);
          return true;
        case 5: 
          xbp.a(paramActivity, str6, str1, i2, i1, 0, null);
          return true;
        case 8: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 90;
          }
          xbp.b(paramActivity, str2, str1, i2);
          return true;
        case 9: 
          b(paramHashMap, "time_zone", -1);
          i2 = i1;
          if (i1 == 0) {
            i2 = 96;
          }
          xbp.a(paramActivity, str1, i2);
          return true;
        case 10: 
          paramQQAppInterface = (String)paramHashMap.get("bannerID");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            xbp.a(paramActivity, new OpenPlayerBuilder(new DiscoverBannerPlayInfo(paramQQAppInterface), 102).a());
          }
          return true;
        case 0: 
          return d(paramQQAppInterface, paramActivity, paramHashMap, paramString);
        }
      }
    }
  }
  
  private boolean c(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString))) {
      return false;
    }
    if (paramString.length() < 5) {
      return false;
    }
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("visitid");
    if (TextUtils.isEmpty(str4)) {
      return false;
    }
    Object localObject;
    String str1;
    label119:
    String str2;
    label159:
    String str3;
    if (this.jdField_a_of_type_JavaUtilHashMap.get("kfuin") != null)
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("kfuin");
      if (this.jdField_a_of_type_JavaUtilHashMap.get("extuin") == null) {
        break label344;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extuin");
      if (this.jdField_a_of_type_JavaUtilHashMap.get("name") == null) {
        break label351;
      }
      str2 = c(((String)this.jdField_a_of_type_JavaUtilHashMap.get("name")).replace(" ", "+"));
      bjyi localbjyi = (bjyi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
      boolean bool = false;
      if (this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag") == null) {
        break label358;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag");
      label204:
      if (!TextUtils.isEmpty(str3)) {
        bool = bjxa.b(Integer.valueOf(str3).intValue());
      }
      localbjyi.a(str4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, str1, paramString, bool);
      localObject = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject == null) || (!((anvk)localObject).b(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label365;
      }
      localObject = new azrb();
      ((azrb)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramString, 1);
      ((azrb)localObject).jdField_a_of_type_ArrayOfJavaLangString = new String[8];
      ((azrb)localObject).jdField_a_of_type_ArrayOfJavaLangString[4] = str2;
      FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (azrb)localObject);
    }
    for (;;)
    {
      return true;
      localObject = "";
      break;
      label344:
      str1 = "";
      break label119;
      label351:
      str2 = "";
      break label159;
      label358:
      str3 = "";
      break label204;
      label365:
      paramString = AddFriendLogicActivity.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, paramString, null, 3999, 0, str2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131690676), null);
      paramString.putExtra("webImVisitId", str4);
      paramString.putExtra("webim_qd_ext", true);
      if (BaseActivity.sTopActivity == null) {
        paramString.putExtra("need_jumpto_splash", true);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
    }
  }
  
  public static String d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      int i1 = Integer.valueOf(paramString).intValue();
      switch (i1)
      {
      default: 
        return paramString;
      case 21: 
        return "2";
      case 20: 
        return "3";
      case 15: 
        return "4";
      case 3001: 
        return "5";
      case 22: 
        return "6";
      }
      return "7";
    }
    catch (NumberFormatException localNumberFormatException) {}
    return paramString;
  }
  
  private void d()
  {
    String str1 = b("payurl");
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = new String(Base64.decode(str1, 0));
      if (!TextUtils.isEmpty(str2))
      {
        QLog.e("JumpAction", 1, "payurl is call to launch");
        bhoy.a(this.jdField_a_of_type_AndroidContentContext, str2);
        return;
      }
      QLog.e("JumpAction", 1, "payurl cant not decode to base64 =" + str1);
      return;
    }
    QLog.e("JumpAction", 1, "payurl is null");
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    String str = (String)paramHashMap.get("unionid");
    paramQQAppInterface = (String)paramHashMap.get("fromuid");
    int i1 = -1;
    try
    {
      int i2 = Integer.valueOf((String)paramHashMap.get("fromId")).intValue();
      i1 = i2;
    }
    catch (NumberFormatException paramHashMap)
    {
      for (;;)
      {
        QLog.e("JumpAction", 2, "gotoStoryShareGroupCard from id is error:" + paramHashMap);
      }
    }
    paramHashMap = QQStoryShareGroupProfileActivity.a(paramActivity, 2, str, null, i1, 0);
    paramHashMap.putExtra("extra_share_from_user_uid", paramQQAppInterface);
    paramActivity.startActivity(paramHashMap);
    return true;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str3 = (String)paramHashMap.get("videoOwnerUin");
    String str4 = (String)paramHashMap.get("unionid");
    String str1 = (String)paramHashMap.get("fromId");
    paramQQAppInterface = (String)paramHashMap.get("videoId");
    String str5 = (String)paramHashMap.get("type");
    String str2 = (String)paramHashMap.get("videoList");
    int i1 = b(paramHashMap);
    str2 = (String)paramHashMap.get("feedid");
    b(paramHashMap, "ptype", 0);
    label129:
    int i2;
    label148:
    int i4;
    label167:
    int i3;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = (String)paramHashMap.get("videoid");
      if (str1 == null)
      {
        str1 = (String)paramHashMap.get("fromid");
        if ((str5 == null) || (!str5.equals("mylist"))) {
          break label705;
        }
        i2 = 1;
        if ((str5 == null) || (!str5.equals("myonedaylist"))) {
          break label711;
        }
        i4 = 1;
        if (!"0".equals(paramHashMap.get("identify"))) {
          break label717;
        }
        i3 = 0;
        try
        {
          label186:
          if ("17".equals(str1))
          {
            if (i2 == 0) {
              break label284;
            }
            ykv.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
          for (;;)
          {
            if (i4 == 0) {
              break label466;
            }
            paramString = (String)paramHashMap.get("collection_id");
            if (!TextUtils.isEmpty(paramString)) {
              break;
            }
            i2 = i1;
            if (i1 == 0) {
              i2 = 30;
            }
            xbp.a(paramActivity, paramQQAppInterface, str2, i2);
            break label703;
            label284:
            ykv.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
          paramQQAppInterface = (String)paramHashMap.get("time_zone");
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "gotoStoryPlayVideoPage, NumberFormatException, videoOwnerUin:" + str3 + ",e:" + QLog.getStackTraceString(paramQQAppInterface));
          }
          return false;
        }
        i2 = -1;
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          i2 = Integer.valueOf(paramQQAppInterface).intValue();
        }
        if (!TextUtils.isEmpty(str4))
        {
          xbp.a(paramActivity, str4, VideoCollectionEntry.getCollectionKey(1, paramString, str4), i2, i1, str2, i3, null);
          break label703;
        }
        if (TextUtils.isEmpty(str3)) {
          break label723;
        }
        xbp.a(paramActivity, str3, VideoCollectionEntry.getCollectionKey(1, paramString, str3), i2, i1, str2, i3, null);
        break label703;
        label466:
        if ("17".equals(str1))
        {
          if (i2 != 0)
          {
            paramQQAppInterface = (String)paramHashMap.get("et");
            paramQQAppInterface = (String)paramHashMap.get("time_zone");
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              Integer.valueOf(paramQQAppInterface).intValue();
            }
            if (!TextUtils.isEmpty(str4))
            {
              xbp.a(paramActivity, str4, str2, i3, i1, 0, null);
              break label725;
            }
            if (TextUtils.isEmpty(str3)) {
              break label727;
            }
            xbp.a(paramActivity, str3, str2, i3, i1, 0, null);
            break label725;
          }
          if ((!TextUtils.isEmpty(str5)) && (str5.equals(String.valueOf(1))))
          {
            i2 = i1;
            if (i1 == 0) {
              i2 = 57;
            }
            xbp.b(paramActivity, paramQQAppInterface, str2, i2);
            break label725;
          }
          if (!"onedaylist".equals(str5)) {
            break label729;
          }
          xbp.a(paramActivity, str4, str2, i3, i1, 0, null);
          break label725;
          xbp.b(paramActivity, paramQQAppInterface, str2, i2);
          break label725;
        }
        label642:
        if (TextUtils.isEmpty(paramString)) {
          break label745;
        }
        i2 = i1;
        if (i1 == 0) {
          i2 = 19;
        }
        xbp.b(paramActivity, paramQQAppInterface, str2, i2);
        break label725;
      }
    }
    for (;;)
    {
      xbp.b(paramActivity, paramQQAppInterface, paramHashMap, i2);
      break label725;
      break label129;
      break;
      label703:
      return true;
      label705:
      i2 = 0;
      break label148;
      label711:
      i4 = 0;
      break label167;
      label717:
      i3 = 1;
      break label186;
      label723:
      return false;
      label725:
      return true;
      label727:
      return false;
      label729:
      i2 = i1;
      if (i1 != 0) {
        break label642;
      }
      i2 = 17;
      break label642;
      label745:
      paramHashMap = str2;
      if (str2 == null) {
        paramHashMap = "JUMP_ACTION_EMPTY_FEED_ID";
      }
      i2 = i1;
      if (i1 == 0) {
        i2 = 7;
      }
    }
  }
  
  private boolean d(String paramString)
  {
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_uri"));
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_f_of_type_Boolean = false;
      ThreadManagerV2.executeOnSubThread(new JumpAction.20(this, str, paramString));
      return false;
    }
    return a(paramString, true);
  }
  
  private Intent e(Intent paramIntent)
  {
    if (!TextUtils.isEmpty((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"))) {}
    for (boolean bool = true;; bool = false)
    {
      ykq.a("JumpAction", "makeStoryJumpActivity() action=%s isFromApi=%s", this.jdField_c_of_type_JavaLangString, Boolean.valueOf(bool));
      ykq.a("JumpAction", "makeStoryJumpActivity() attr=%s", String.valueOf(this.jdField_a_of_type_JavaUtilHashMap));
      if (!"open".equals(this.jdField_c_of_type_JavaLangString)) {
        break;
      }
      paramIntent.putExtra("redid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("redid"));
      paramIntent.putExtra("lebaVersion", (String)this.jdField_a_of_type_JavaUtilHashMap.get("lebaVersion"));
      if (bool) {
        ykv.a("basic", "use_api", 0, 0, new String[] { "1", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
      }
      return paramIntent;
    }
    String str1;
    if (("openVideo".equals(this.jdField_c_of_type_JavaLangString)) || ("openvideo".equals(this.jdField_c_of_type_JavaLangString)))
    {
      if (bool)
      {
        str1 = "userId=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoOwnerUin") + "&vid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoId");
        ykv.a("basic", "use_api", 0, 0, new String[] { "6", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
      }
      return a(paramIntent);
    }
    String str2;
    String str4;
    String str5;
    if ("opencontent".equals(this.jdField_c_of_type_JavaLangString))
    {
      if (bool)
      {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
        str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
        if (!TextUtils.isEmpty(str4)) {
          break label471;
        }
      }
      label471:
      for (str1 = "unionId=" + str5 + "&userId=" + str1 + "&userType=" + str2;; str1 = "storyId=" + str4)
      {
        ykv.a("basic", "use_api", 0, 0, new String[] { "4", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
        return d(paramIntent);
      }
    }
    if ("opentopic".equals(this.jdField_c_of_type_JavaLangString))
    {
      if (bool)
      {
        str1 = "topicId=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
        ykv.a("basic", "use_api", 0, 0, new String[] { "5", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
      }
      return b(paramIntent);
    }
    if ("opendiscovery".equals(this.jdField_c_of_type_JavaLangString))
    {
      if (bool) {
        ykv.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
      }
      return c(paramIntent);
    }
    if ("publish".equals(this.jdField_c_of_type_JavaLangString))
    {
      if (bool) {
        ykv.a("basic", "use_api", 0, 0, new String[] { "2", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
      }
      paramIntent.putExtra("story_default_label", (String)this.jdField_a_of_type_JavaUtilHashMap.get("default_label"));
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("capture_mode");
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tab_id");
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("category_id");
      String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("item_id");
      String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("album_id");
      String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page");
      String str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("dispatch_event");
      paramIntent.putExtra("cameraDirection", 2);
      paramIntent.putExtra("story_game_id", str4);
      paramIntent.putExtra("story_capture_album_id", str7);
      if (!TextUtils.isEmpty(str9)) {
        paramIntent.putExtra("web_dispatch_event", str9);
      }
      try
      {
        if (!TextUtils.isEmpty(str8)) {
          paramIntent.putExtra("key_finish_jump_to_page", Integer.valueOf(str8));
        }
        if (!TextUtils.isEmpty(str2)) {
          paramIntent.putExtra("capture_intent_mode", Integer.valueOf(str2));
        }
        if (!TextUtils.isEmpty(str4)) {
          paramIntent.putExtra("firsttab", Integer.valueOf(str4));
        }
        if (!TextUtils.isEmpty(str5)) {
          paramIntent.putExtra("secondtab", Integer.valueOf(str5));
        }
        paramIntent.putExtra("itemid", str6);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("Q.qqstory.publish.JumpAction", 2, "start story publish, NumberFormatException, attrs=" + this.jdField_a_of_type_JavaUtilHashMap.toString() + "\n" + localNumberFormatException);
        }
      }
      paramIntent.putExtra("from_type", str1);
      paramIntent.putExtra("action", 1);
      return paramIntent;
    }
    String str3;
    if ("infoCard".equals(this.jdField_c_of_type_JavaLangString))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromId");
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
      if ((TextUtils.isEmpty(str3)) || ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str5))) || (TextUtils.isEmpty(str4))) {
        return null;
      }
      try
      {
        paramIntent.putExtra("union_id", str5);
        paramIntent.putExtra("qq_number", Long.valueOf(str1));
        paramIntent.putExtra("source", Integer.valueOf(str4));
        paramIntent.putExtra("action", 11);
        return paramIntent;
      }
      catch (NumberFormatException paramIntent)
      {
        return null;
      }
    }
    if ("sharegroupcard".equals(this.jdField_c_of_type_JavaLangString))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromId");
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromuid");
      try
      {
        paramIntent.putExtra("union_id", str1);
        paramIntent.putExtra("extra_share_from_uid", str4);
        paramIntent.putExtra("source", Integer.valueOf(str3));
        paramIntent.putExtra("action", 13);
        return paramIntent;
      }
      catch (NumberFormatException paramIntent)
      {
        return null;
      }
    }
    if ("openTag".equals(this.jdField_c_of_type_JavaLangString))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag_id");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag_type");
      paramIntent.putExtra("action", 14);
      paramIntent.putExtra("tag_id", str1);
      paramIntent.putExtra("tag_type", str3);
      return paramIntent;
    }
    if ("openSquare".equals(this.jdField_c_of_type_JavaLangString))
    {
      paramIntent.putExtra("action", 15);
      return paramIntent;
    }
    return null;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("params")) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("params")));
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "urlParamObj: " + localJSONObject);
      }
      if (localJSONObject.optInt("view_type", 0) == 0)
      {
        localJSONObject = localJSONObject.optJSONObject("params");
        if (localJSONObject != null) {
          ReminderListFragment.a(this.jdField_a_of_type_AndroidContentContext, localJSONObject.optString("notice_time"));
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("JumpAction", 2, "JumpAction parse url throw an exception: " + localException);
    }
  }
  
  private boolean e(String paramString)
  {
    int i3 = 0;
    int i2 = 0;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return true;
      paramString = paramString.split("\\?");
    } while ((paramString == null) || (paramString.length < 2));
    long l1 = 0L;
    paramString = paramString[1];
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(URLDecoder.decode(paramString.substring(paramString.indexOf('=') + 1), "UTF-8"));
        int i1 = ((JSONObject)localObject).optInt("gameId");
        i2 = i3;
        long l2;
        paramString.printStackTrace();
      }
      catch (Exception paramString)
      {
        try
        {
          l2 = ((JSONObject)localObject).optLong("roomId");
          l1 = l2;
          i2 = i3;
          paramString = ((JSONObject)localObject).optString("gameName");
          l1 = l2;
          i2 = i3;
          i3 = ((JSONObject)localObject).optInt("gameMode");
          l1 = l2;
          i2 = i3;
          localObject = ((JSONObject)localObject).optString("extendInfo");
          l1 = l2;
          i2 = i3;
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l2, i3, (String)localObject, 204, paramString);
          i2 = i3;
          l1 = l2;
          QLog.i("JumpAction", 1, "[gotoCmShowGame], gameId:" + i1 + ",roomId:" + l1 + ",gameMode:" + i2);
          return true;
        }
        catch (Exception paramString)
        {
          break label222;
        }
        paramString = paramString;
        i1 = 0;
      }
      label222:
      QLog.w("JumpAction", 1, "[gotoCmShowGame], errInfo->" + paramString.getMessage());
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("scheme")) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msgid")) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("busiid")))
    {
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("msgid");
      String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("busiid");
      String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("scheme");
      String str1 = "";
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("domain")) {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("domain");
      }
      QQNotifySettingFragment.a(this.jdField_a_of_type_AndroidContentContext, str2, str3, str4, str1);
    }
  }
  
  private void g()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), 111);
    if ("1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("source"))) {
      localAllInOne.jdField_h_of_type_Int = 118;
    }
    for (;;)
    {
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, localAllInOne);
      return;
      if ("2".equals(this.jdField_a_of_type_JavaUtilHashMap.get("source"))) {
        localAllInOne.jdField_h_of_type_Int = 121;
      }
    }
  }
  
  private void g(String paramString)
  {
    if ((paramString.equals(GameCenterActivity.class.getName())) || (paramString.equals(PublicAccountBrowser.class.getName())) || (paramString.equals(CouponActivity.class.getName()))) {
      QWalletHelper.preloadQWallet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void h()
  {
    String str = b("buddyuin");
    if (!str.isEmpty())
    {
      long l1 = Long.parseLong(str);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "grayTip,openTroopWithCommonFriendsFragment:" + l1);
      }
      TroopWithCommonFriendsFragment.a(str);
      TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_AndroidContentContext, 1);
      bdla.b(null, "dc00898", "", "", "0X800AD20", "0X800AD20", 0, 0, "0", "0", "", "");
    }
  }
  
  private void i()
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("fromTranslucent", 1);
    try
    {
      long l1 = Long.parseLong(b("uin"));
      int i1 = Integer.parseInt(b("appid"));
      Object localObject2 = b("cellid");
      Object localObject3 = b("subid");
      long l2 = Long.parseLong(b("time"));
      ((Bundle)localObject1).putLong("targetuin", Long.valueOf(l1).longValue());
      ((Bundle)localObject1).putInt("appid", i1);
      ((Bundle)localObject1).putString("cellid", (String)localObject2);
      ((Bundle)localObject1).putString("subid", (String)localObject3);
      ((Bundle)localObject1).putLong("feedtime", l2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject2, "com.qzone.detail.ui.activity.StickyNoteDetailActivity");
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
      {
        localObject3 = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
        localObject1 = null;
        if (((BaseActivity)localObject3).app != null) {
          localObject1 = ((BaseActivity)localObject3).app.getCurrentUin();
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QLog.e("JumpAction", 1, "action_open_sticky_note_feed_detail  error! get currentUin failed! " + ((BaseActivity)localObject3).app);
          return;
        }
        QzonePluginProxyActivity.launchPluingActivityForResult((Activity)localObject3, (String)localObject1, (Intent)localObject2, 7, true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpAction", 1, "action_open_sticky_note_feed_detail  error!", localThrowable);
    }
  }
  
  private void j()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_weishi_feeds_plugin.apk");
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  private void k()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ReadInJoyDeliverUGCActivity.class);
    localObject2 = "";
    Object localObject4 = "";
    str = "";
    localObject1 = localObject2;
    localObject3 = localObject2;
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("topicid"))
      {
        localObject1 = localObject2;
        localObject3 = localObject2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get("topicid") != null)
        {
          localObject3 = localObject2;
          localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
        }
      }
      localObject2 = localObject4;
      localObject3 = localObject1;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("topicname"))
      {
        localObject2 = localObject4;
        localObject3 = localObject1;
        if (this.jdField_a_of_type_JavaUtilHashMap.get("topicname") != null)
        {
          localObject3 = localObject1;
          localObject2 = new String(bhcu.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname"), 0));
        }
      }
      localObject3 = str;
      localObject4 = str;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label265:
        str = "";
        localObject2 = "";
        localObject1 = localObject3;
        localObject3 = str;
        localException1.printStackTrace();
        i1 = 0;
      }
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("cookie"))
      {
        localObject3 = str;
        localObject4 = str;
        if (this.jdField_a_of_type_JavaUtilHashMap.get("cookie") != null)
        {
          localObject4 = str;
          localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cookie");
        }
      }
      localObject4 = localObject3;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("adtag")) {
        break label375;
      }
      localObject4 = localObject3;
      if (this.jdField_a_of_type_JavaUtilHashMap.get("adtag") == null) {
        break label375;
      }
      localObject4 = localObject3;
      i1 = Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("adtag")).intValue();
    }
    catch (Exception localException2)
    {
      localObject3 = localException1;
      Object localObject5 = localException2;
      break label352;
      i1 = 0;
      break label265;
    }
    localIntent.putExtra("arg_topic_id", (String)localObject1);
    localIntent.putExtra("support_topic", true);
    localIntent.putExtra("support_linkify", true);
    localIntent.putExtra("arg_topic_name", (String)localObject2);
    localIntent.putExtra("arg_ad_tag", i1);
    localIntent.putExtra("arg_ugc_edit_cookie", (String)localObject3);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private void l()
  {
    if ((this.jdField_c_of_type_JavaLangString == null) || ((!this.jdField_c_of_type_JavaLangString.equals("forward_msg_list")) && (!this.jdField_c_of_type_JavaLangString.equals("open_conversation"))))
    {
      QLog.e("JumpAction", 1, "action_name doesnt match: " + this.jdField_c_of_type_JavaLangString);
      return;
    }
    int i1 = MainFragment.jdField_b_of_type_Int;
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("third_open_conversation_sceneid");
    try
    {
      long l1 = Long.parseLong((String)localObject);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5AF", "0X800A5AF", 0, 0, l1 + "", "", "", "");
      localObject = new Intent();
      ((Intent)localObject).setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      ((Intent)localObject).setFlags(335544320);
      ((Intent)localObject).putExtra("tab_index", i1);
      ((Intent)localObject).putExtra("fragment_id", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("JumpAction", 1, "sceneid must be a numeric string, errorMsg: " + localException.toString());
      }
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this.jdField_a_of_type_AndroidContentContext, 2131692703, this.jdField_a_of_type_AndroidContentContext.getString(2131692690), 2131692692, 2131692691, new bhes(this), new bhet(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void n()
  {
    Object localObject;
    String str1;
    label54:
    String str2;
    label79:
    String str3;
    label107:
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("packageName"))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("packageName");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("signareMode")) {
        break label328;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("signareMode");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
        break label334;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("timeStamp")) {
        break label340;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("timeStamp");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("resetWordMode")) {
        break label347;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("resetWordMode");
      label135:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("offerid")) {
        break label354;
      }
    }
    label328:
    label334:
    label340:
    label347:
    label354:
    for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("offerid");; str5 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "packageName : " + (String)localObject + " signatureMode :" + str1 + " appid : " + str2 + " timestamp : " + str3 + " resetWordMode : " + str4 + " offerId : " + str5);
      }
      localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
      ((aobv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QWALLET_AUTH_HANDLER)).a((ReqCheckChangePwdAuth)localObject);
      this.jdField_a_of_type_Bhev = new bhev(this, null);
      this.jdField_a_of_type_Aobw = new aobw(this.jdField_a_of_type_Bhev);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aobw);
      return;
      localObject = "";
      break;
      str1 = "";
      break label54;
      str2 = "";
      break label79;
      str3 = "";
      break label107;
      str4 = "";
      break label135;
    }
  }
  
  private void o()
  {
    com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localJSONObject.put("viewTag", "pswManage");
      if (!PayBridgeActivity.tenpay((Activity)this.jdField_a_of_type_AndroidContentContext, localJSONObject.toString(), 5, "")) {}
      for (int i1 = 1;; i1 = 0)
      {
        a(i1);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(1);
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
      ((JumpActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
  
  private void q()
  {
    try
    {
      if ("head".equals(this.jdField_c_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_Bheu == null) {
          this.jdField_a_of_type_Bheu = new bheu(this, this);
        }
        if (this.jdField_a_of_type_JavaUtilHashtable == null) {
          this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bheu);
        long l1 = System.currentTimeMillis();
        String[] arrayOfString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).split(",");
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        int i1 = 0;
        while (i1 < arrayOfString.length)
        {
          String str = arrayOfString[i1];
          localFriendListHandler.getCustomHead(str);
          this.jdField_a_of_type_JavaUtilHashtable.put(str, Long.valueOf(l1));
          i1 += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("JumpAction", 2, "handleMQQService error " + localException.toString());
      }
    }
  }
  
  public boolean A()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ConferenceFlyTicketActivity.class);
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("confid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("subject");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("confidshort");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("ticket");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("discid");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("confphone");
    String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("businesstype");
    String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("stask");
    String str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("user");
    String str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("ticket_f");
    localIntent.putExtra("confid", str1);
    localIntent.putExtra("subject", str2);
    localIntent.putExtra("ticket", str4);
    localIntent.putExtra("confidshort", str3);
    localIntent.putExtra("discid", str5);
    localIntent.putExtra("confphone", str6);
    localIntent.putExtra("businesstype", str7);
    localIntent.putExtra("user", str9);
    localIntent.putExtra("stask", str8);
    localIntent.putExtra("ticket_f", str10);
    AudioHelper.b("start_ConferenceFlyTicketActivity");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  protected boolean B()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(str1);
    if (localObject != null)
    {
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((((TroopInfo)localObject).isTroopOwner(str2)) || (((TroopInfo)localObject).isTroopAdmin(str2))) {}
      for (boolean bool = true; (!((TroopInfo)localObject).mMemberInvitingFlag) && (!bool); bool = false)
      {
        QLog.e("JumpAction", 1, "cannot invite join group");
        return true;
      }
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SelectMemberActivity.class);
      ((Intent)localObject).putExtra("param_groupcode", str1);
      ((Intent)localObject).putExtra("param_type", 1);
      ((Intent)localObject).putExtra("param_subtype", 1);
      ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131697033));
      ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131695798));
      ((Intent)localObject).putExtra("param_is_troop_admin", bool);
      ((Intent)localObject).putExtra("param_donot_need_contacts", true);
      ((Intent)localObject).putExtra("param_max", 100);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
    }
    QLog.e("JumpAction", 1, "troopInfo not found");
    return true;
  }
  
  public Intent a(Intent paramIntent)
  {
    paramIntent.putExtra("action", 5);
    paramIntent.putExtra("extra_jump_attrs", this.jdField_a_of_type_JavaUtilHashMap);
    return paramIntent;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_b_of_type_JavaLangString.equals("card")) && (this.jdField_c_of_type_JavaLangString.equals("show_pslcard")) && (QSecFramework.a().a(1003).booleanValue())) {
      bizc.a().a(paramActivity, null);
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.putAll(paramHashMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, "setNewFlag.newflag=" + this.jdField_c_of_type_Boolean);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    label731:
    Object localObject1;
    Object localObject2;
    try
    {
      if ("com.qqfav".equals(this.jdField_b_of_type_JavaLangString)) {
        return C();
      }
      if (("urlopen".equals(this.jdField_b_of_type_JavaLangString)) && ("pay".equals(this.jdField_c_of_type_JavaLangString))) {
        d();
      }
      if (("qqidentifier".equals(this.jdField_b_of_type_JavaLangString)) && ("web".equals(this.jdField_c_of_type_JavaLangString))) {
        return D();
      }
      if ("qsubscribe".equals(this.jdField_b_of_type_JavaLangString))
      {
        zqm.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap);
        return true;
      }
      if ("qcircle".equals(this.jdField_b_of_type_JavaLangString))
      {
        vvh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap);
        return true;
      }
      if ("videostory".equals(this.jdField_b_of_type_JavaLangString)) {
        return N();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("manage_troop")) && (this.jdField_c_of_type_JavaLangString.equals("main_page"))) {
        return bW();
      }
      if (("microapp".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString))) {
        return E();
      }
      if (("miniapp".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString))) {
        return com.tencent.mobileqq.mini.sdk.MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 2016, null);
      }
      if (("miniapp".equals(this.jdField_b_of_type_JavaLangString)) && ("notifyclose".equals(this.jdField_c_of_type_JavaLangString))) {
        return F();
      }
      if (("wallet".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString)) && ("0".equals(this.jdField_a_of_type_JavaUtilHashMap.get("viewtype"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"))) && ((this.jdField_a_of_type_JavaUtilHashMap.get("view") == null) || ("0".equals(this.jdField_a_of_type_JavaUtilHashMap.get("view"))))) {
        return at();
      }
      if (("wallet".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString)) && ("0".equals(this.jdField_a_of_type_JavaUtilHashMap.get("viewtype"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("src_type")))) {
        return G();
      }
      if (("buscard".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) && (!StringUtil.isEmpty((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"))) && ("2".equals(this.jdField_a_of_type_JavaUtilHashMap.get("from_type")))) {
        return O();
      }
      if (("wxminiapp".equals(this.jdField_b_of_type_JavaLangString)) && ("launch".equals(this.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("user_name")) && (!StringUtil.isEmpty((String)this.jdField_a_of_type_JavaUtilHashMap.get("user_name")))) {
        return P();
      }
      if ("qqnotify".equals(this.jdField_b_of_type_JavaLangString))
      {
        if (!"open".equals(this.jdField_c_of_type_JavaLangString)) {
          break label731;
        }
        e();
      }
      for (;;)
      {
        if (("qqnotify".equals(this.jdField_b_of_type_JavaLangString)) && ("birth".equals(this.jdField_c_of_type_JavaLangString)))
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ActivateFriendActivity.class);
          localIntent.putExtra("af_key_from", 2);
          this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        }
        if (!this.jdField_b_of_type_JavaLangString.equals("ftssearch")) {
          break label939;
        }
        if (!this.jdField_c_of_type_JavaLangString.equals("tab")) {
          break;
        }
        return Q();
        if ("subscribe".equals(this.jdField_c_of_type_JavaLangString)) {
          f();
        }
      }
      if (!this.jdField_c_of_type_JavaLangString.equals("openmixweb")) {
        break label939;
      }
    }
    catch (Exception localException)
    {
      QLog.e("JumpAction", 1, "doAction error:" + localException.getMessage());
      localObject1 = new HashMap(1);
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = "";
      }
      if (this.jdField_b_of_type_JavaLangString == null) {
        this.jdField_b_of_type_JavaLangString = "";
      }
      if (this.jdField_c_of_type_JavaLangString == null) {
        this.jdField_c_of_type_JavaLangString = "";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("JumpAction").append("source:").append(this.jdField_a_of_type_JavaLangString).append("server_name:").append(this.jdField_b_of_type_JavaLangString).append("action_name:").append(this.jdField_c_of_type_JavaLangString);
      ((HashMap)localObject1).put("keyJumpParserUtilDoActionErrorInfo", ((StringBuilder)localObject2).toString());
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance("", "keyJumpParserUtil", true, 0L, 0L, (HashMap)localObject1, "", false);
      return false;
    }
    return d();
    label939:
    if ((this.jdField_b_of_type_JavaLangString.equals("wpa")) && (this.jdField_c_of_type_JavaLangString.equals("openid_to_uin"))) {
      return au();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.jdField_c_of_type_JavaLangString.equals("chat"))) {
      return aw();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("wsgzh")) && (this.jdField_c_of_type_JavaLangString.equals("waterfall")))
    {
      uyt.a(this.jdField_a_of_type_AndroidContentContext, "from_search_rzh_ws", 2, false);
      return true;
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("wsgzh")) && (this.jdField_c_of_type_JavaLangString.equals("miniapp_player")) && ("openPlayer".equals(this.jdField_a_of_type_JavaUtilHashMap.get("action")))) {
      return vfa.a().a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("asyncmsg")) && (this.jdField_c_of_type_JavaLangString.equals("open_async_detail"))) {
      return bA();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("connect_miniapp")) && (this.jdField_c_of_type_JavaLangString.equals("launch"))) {
      return av();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.jdField_c_of_type_JavaLangString.equals("aioorprofile"))) {
      return aB();
    }
    if (this.jdField_b_of_type_JavaLangString.equals("qapp")) {
      return by();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.jdField_c_of_type_JavaLangString.equals("show_nearby_fri"))) {
      return aC();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.jdField_c_of_type_JavaLangString.equals("show_location"))) {
      return aF();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.jdField_c_of_type_JavaLangString.equals("select_location"))) {
      return aG();
    }
    if (("card".equals(this.jdField_b_of_type_JavaLangString)) && ("show_pslcard".equals(this.jdField_c_of_type_JavaLangString))) {
      return aH();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("personal_tag")) && (this.jdField_c_of_type_JavaLangString.equals("tag_list"))) {
      return aN();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("upload")) && (this.jdField_c_of_type_JavaLangString.equals("photo"))) {
      return aW();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("forward")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
      return ba();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("forward")) && (this.jdField_c_of_type_JavaLangString.equals("invite_register"))) {
      return bM();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("gamesdk")) && (this.jdField_c_of_type_JavaLangString.equals("bind_group"))) {
      return aZ();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("opensdk")) && (this.jdField_c_of_type_JavaLangString.equals("join_group"))) {
      return aX();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("opensdk")) && (this.jdField_c_of_type_JavaLangString.equals("bind_group"))) {
      return aY();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_fri"))) {
      return bb();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_qqdataline"))) {
      return bx();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("gamesdk")) && (this.jdField_c_of_type_JavaLangString.equals("add_friend")))
    {
      if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"))) {
        n = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
      }
      return bd();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_qqfav"))) {
      return bi();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_qzone"))) {
      return d("shareToQzone");
    }
    if (this.jdField_b_of_type_JavaLangString.equals("qzone")) {
      return H();
    }
    if (this.jdField_b_of_type_JavaLangString.equals("mqq"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "handleMQQService");
      }
      q();
    }
    boolean bool1;
    while ((this.jdField_b_of_type_JavaLangString.equals("schedule")) && (this.jdField_c_of_type_JavaLangString.equals("showDetail")))
    {
      return bB();
      if ((this.jdField_b_of_type_JavaLangString.equals("groupopenapp")) && (this.jdField_c_of_type_JavaLangString.equals("openapp"))) {
        return bT();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("lightapp")) && (this.jdField_c_of_type_JavaLangString.equals("open"))) {
        return bU();
      }
      if (this.jdField_b_of_type_JavaLangString.endsWith("app"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleAppForward");
        }
        return bw();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("qm")) && (this.jdField_c_of_type_JavaLangString.equals("qr"))) {
        return I();
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("dc")) && (this.jdField_c_of_type_JavaLangString.equals("ft"))) {
        return bq();
      }
      if ("group".equals(this.jdField_b_of_type_JavaLangString))
      {
        if (this.jdField_c_of_type_JavaLangString.equals("nearby")) {
          return aD();
        }
        if (this.jdField_c_of_type_JavaLangString.equals("create")) {
          return aE();
        }
        if (this.jdField_c_of_type_JavaLangString.equals("report")) {
          return bO();
        }
      }
      else
      {
        if (this.jdField_b_of_type_JavaLangString.equals("shop")) {
          return J();
        }
        if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.jdField_c_of_type_JavaLangString.equals("game_invite")))
        {
          QLog.i("JumpAction", 1, "[cmshow.game_invite], source:" + this.jdField_a_of_type_JavaLangString);
          return e(this.jdField_a_of_type_JavaLangString);
        }
        if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("avatar_edit".equals(this.jdField_c_of_type_JavaLangString))) {
          return ai();
        }
        if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_avatar_edit".equals(this.jdField_c_of_type_JavaLangString))) {
          return ak();
        }
        if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_dynamic_avatar_edit".equals(this.jdField_c_of_type_JavaLangString))) {
          return al();
        }
        if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_face_collection".equals(this.jdField_c_of_type_JavaLangString))) {
          return aj();
        }
        if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("more_info_edit".equals(this.jdField_c_of_type_JavaLangString)))
        {
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, FriendProfileMoreInfoActivity.class);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        }
        else if (("userprofile".equals(this.jdField_b_of_type_JavaLangString)) && ("friend_profile_card".equals(this.jdField_c_of_type_JavaLangString)))
        {
          g();
        }
        else
        {
          if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("might_know".equals(this.jdField_c_of_type_JavaLangString))) {
            return am();
          }
          if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("search_might_know".equals(this.jdField_c_of_type_JavaLangString))) {
            return an();
          }
          if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("new_friends".equals(this.jdField_c_of_type_JavaLangString))) {
            return ao();
          }
          if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("contacts_tab".equals(this.jdField_c_of_type_JavaLangString))) {
            return ap();
          }
          if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("phone_recommend".equals(this.jdField_c_of_type_JavaLangString))) {
            return aq();
          }
          if ((this.jdField_b_of_type_JavaLangString.equals("healthcenter")) && (this.jdField_c_of_type_JavaLangString.equals("open"))) {
            return K();
          }
          if ((this.jdField_b_of_type_JavaLangString.equals("ptlogin")) && (this.jdField_c_of_type_JavaLangString.equals("qlogin"))) {
            return br();
          }
          if ((this.jdField_b_of_type_JavaLangString.equals("gav")) && (this.jdField_c_of_type_JavaLangString.equals("request"))) {
            return bs();
          }
          if (("videochat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.jdField_c_of_type_JavaLangString))) {
            return bt();
          }
          if (("randomavchat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.jdField_c_of_type_JavaLangString))) {
            return bu();
          }
          if (this.jdField_b_of_type_JavaLangString.equals("tribe")) {
            return L();
          }
          if ((this.jdField_b_of_type_JavaLangString.equals("qqdataline")) && (this.jdField_c_of_type_JavaLangString.equals("openqqdataline"))) {
            return as();
          }
          if ((this.jdField_b_of_type_JavaLangString.equals("wallet")) && (this.jdField_c_of_type_JavaLangString.equals("modify_pass"))) {
            return ar();
          }
          if (this.jdField_b_of_type_JavaLangString.equals("dating"))
          {
            if (this.jdField_c_of_type_JavaLangString.equals("detail")) {
              return ah();
            }
            if (this.jdField_c_of_type_JavaLangString.equals("publish")) {
              return ag();
            }
            if (this.jdField_c_of_type_JavaLangString.equals("feed")) {
              return af();
            }
          }
          else if (this.jdField_b_of_type_JavaLangString.equals("nearby_entry"))
          {
            if (this.jdField_c_of_type_JavaLangString.equals("nearby_feed")) {
              return aa();
            }
            if (this.jdField_c_of_type_JavaLangString.equals("nearby_profile")) {
              return aI();
            }
            if (this.jdField_c_of_type_JavaLangString.equals("hotchat_list")) {
              return ac();
            }
            if (this.jdField_c_of_type_JavaLangString.equals("hotchat_room")) {
              return ad();
            }
            if (this.jdField_c_of_type_JavaLangString.equals("visitor_list")) {
              return z();
            }
          }
          else if (this.jdField_b_of_type_JavaLangString.equals("nearby"))
          {
            if (this.jdField_c_of_type_JavaLangString.equals("reportFriend")) {
              return bP();
            }
          }
          else if (this.jdField_b_of_type_JavaLangString.equals("hotchat"))
          {
            if (this.jdField_c_of_type_JavaLangString.equals("newyear_scene")) {
              return ae();
            }
          }
          else
          {
            bool1 = bool2;
            if (this.jdField_b_of_type_JavaLangString.equals("freshnews_entry")) {
              break label5024;
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qlink")) && (this.jdField_c_of_type_JavaLangString.equals("openqlink"))) {
              return bz();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_troopbar"))) {
              return bC();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qqconnect")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
              return bD();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("publicdevice")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
              return bE();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("openLightApp")) && (this.jdField_c_of_type_JavaLangString.equals("url"))) {
              return p();
            }
            if (("tenpay".equals(this.jdField_b_of_type_JavaLangString)) && ("sendHongBao".equals(this.jdField_c_of_type_JavaLangString))) {
              return bF();
            }
            if (("massbless".endsWith(this.jdField_b_of_type_JavaLangString)) && ("mainpage".equals(this.jdField_c_of_type_JavaLangString))) {
              return q();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("interesttag")) {
              return Z();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("qqcomic")) {
              return bv();
            }
            if (("leba_plugin".equals(this.jdField_b_of_type_JavaLangString)) && ("set".equals(this.jdField_c_of_type_JavaLangString))) {
              return r();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("pa_relationship")) {
              return s();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("od")) {
              return e();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("odAddFriend")) {
              return bG();
            }
            if ("huayang".equals(this.jdField_b_of_type_JavaLangString)) {
              return bH();
            }
            if ("qboss".equals(this.jdField_b_of_type_JavaLangString)) {
              return baoe.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
            }
            if (this.jdField_b_of_type_JavaLangString.equals("readinjoy")) {
              return M();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.jdField_c_of_type_JavaLangString.equals("apollo_action")))
            {
              if (amme.a(this.jdField_a_of_type_AndroidContentContext)) {
                return y();
              }
            }
            else
            {
              if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.jdField_c_of_type_JavaLangString.equals("open_game"))) {
                return a(this.jdField_a_of_type_JavaUtilHashMap);
              }
              if ("favorites".equals(this.jdField_b_of_type_JavaLangString))
              {
                if ("forward_favorites".equals(this.jdField_c_of_type_JavaLangString))
                {
                  localObject1 = new Intent();
                  ((Intent)localObject1).putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690676));
                  return bmaf.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, -1, false);
                }
              }
              else if ("hongbao_share".equals(this.jdField_b_of_type_JavaLangString))
              {
                if ("hongbao_brush".equals(this.jdField_c_of_type_JavaLangString)) {
                  return W();
                }
              }
              else if ("general_ar".equals(this.jdField_b_of_type_JavaLangString))
              {
                if ("gotoScannerTorchActivity".equals(this.jdField_c_of_type_JavaLangString)) {
                  return X();
                }
              }
              else
              {
                if ("mqqavshare://".equals(this.jdField_b_of_type_JavaLangString))
                {
                  this.jdField_j_of_type_Boolean = true;
                  return ShareChat.a(this);
                }
                if ("setting".equals(this.jdField_b_of_type_JavaLangString))
                {
                  if ("general".equals(this.jdField_c_of_type_JavaLangString)) {
                    return x();
                  }
                  if ("deviceLock".equals(this.jdField_c_of_type_JavaLangString))
                  {
                    localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, AuthDevActivity.class);
                    ((Intent)localObject1).putExtra("from", (String)this.jdField_a_of_type_JavaUtilHashMap.get("from"));
                    ((Intent)localObject1).setFlags(67108864);
                    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                    return true;
                  }
                }
                else if ("assistant_setting".equals(this.jdField_b_of_type_JavaLangString))
                {
                  if ("ASSISTANT_SETTING".equals(this.jdField_c_of_type_JavaLangString)) {
                    return f_();
                  }
                }
                else if ((this.jdField_b_of_type_JavaLangString.equals("conf")) || (this.jdField_b_of_type_JavaLangString.equals("confpstn")) || (this.jdField_b_of_type_JavaLangString.equals("confhr")))
                {
                  if (this.jdField_c_of_type_JavaLangString.equals("ft")) {
                    return A();
                  }
                }
                else if ("teamwork".equals(this.jdField_b_of_type_JavaLangString))
                {
                  if ("opendoclist".equals(this.jdField_c_of_type_JavaLangString)) {
                    return V();
                  }
                }
                else
                {
                  if ("qstory".equals(this.jdField_b_of_type_JavaLangString))
                  {
                    if ("openNow".equals(this.jdField_c_of_type_JavaLangString)) {
                      return g();
                    }
                    return T();
                  }
                  if ("now".equals(this.jdField_b_of_type_JavaLangString))
                  {
                    if ("openroom".equals(this.jdField_c_of_type_JavaLangString)) {
                      return g();
                    }
                    if ("playmedia".equals(this.jdField_c_of_type_JavaLangString)) {
                      return i();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("contact")) && (this.jdField_c_of_type_JavaLangString.equals("add"))) {
      return g_();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("profile")) && (this.jdField_c_of_type_JavaLangString.equals("setting"))) {
      return f();
    }
    if (this.jdField_b_of_type_JavaLangString.equals("qqreg")) {
      return bN();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("troop_member_card")) && (this.jdField_c_of_type_JavaLangString.equals("open_member_recent_chat_view"))) {
      return ab();
    }
    if (this.jdField_b_of_type_JavaLangString.equals("qwerewolf"))
    {
      if (this.jdField_c_of_type_JavaLangString.equals("openInvitationRoom")) {
        return R();
      }
      bool1 = bool2;
      if (this.jdField_c_of_type_JavaLangString.equals("enterGameRoom")) {
        return S();
      }
    }
    else if (this.jdField_b_of_type_JavaLangString.equals("groupvideo"))
    {
      if (this.jdField_c_of_type_JavaLangString.equals("openroom")) {
        return bQ();
      }
      bool1 = bool2;
      if (this.jdField_c_of_type_JavaLangString.equals("preload")) {
        return bR();
      }
    }
    else
    {
      if (this.jdField_b_of_type_JavaLangString.equals("studyroom")) {
        return bS();
      }
      if (this.jdField_b_of_type_JavaLangString.equals("invite_join_group"))
      {
        bool1 = bool2;
        if (this.jdField_c_of_type_JavaLangString.equals("open")) {
          return B();
        }
      }
      else
      {
        if (("troop_homework".equals(this.jdField_b_of_type_JavaLangString)) && ("publish".equals(this.jdField_c_of_type_JavaLangString))) {
          return a(b("gc"));
        }
        if ((this.jdField_b_of_type_JavaLangString.equals("nearby_videochat")) && (this.jdField_c_of_type_JavaLangString.equals("open_plugin")))
        {
          if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
          {
            localObject1 = (bghm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
            NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, null, ((bghm)localObject1).a(), null, 123987);
            return true;
          }
          QLog.i("JumpAction", 1, "openNearbyVideoChatActivity, context is not a activity");
          return false;
        }
        if ("weishitab".equals(this.jdField_b_of_type_JavaLangString))
        {
          bool1 = bool2;
          if ("open".equals(this.jdField_c_of_type_JavaLangString))
          {
            j();
            return false;
          }
        }
        else
        {
          if ("page_router".equals(this.jdField_b_of_type_JavaLangString))
          {
            l();
            return true;
          }
          if ("msg_list".equals(this.jdField_b_of_type_JavaLangString))
          {
            l();
            return true;
          }
          if ("watchtogether".equals(this.jdField_b_of_type_JavaLangString))
          {
            bool1 = bool2;
            if (this.jdField_c_of_type_JavaLangString.equals("openroom")) {
              return bV();
            }
          }
          else
          {
            if ("share_group".equals(this.jdField_b_of_type_JavaLangString))
            {
              if (!this.jdField_c_of_type_JavaLangString.equals("open")) {
                break label5026;
              }
              localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
              if (localObject1 == null) {
                break label5026;
              }
              TroopUtils.shareGroup(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1);
              break label5026;
            }
            if ("edit_group".equals(this.jdField_b_of_type_JavaLangString))
            {
              if (!this.jdField_c_of_type_JavaLangString.equals("open")) {
                break label5028;
              }
              localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
              if (localObject1 == null) {
                break label5028;
              }
              TroopUtils.openTroopInfoActivityFromAIO(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1);
              break label5028;
            }
            if ("weishiforqassistant".equals(this.jdField_b_of_type_JavaLangString))
            {
              uyt.a(this.jdField_a_of_type_AndroidContentContext, "from_audio_assistant", 1, true);
              return true;
            }
            if ("nearbyforqassistant".equals(this.jdField_b_of_type_JavaLangString)) {
              return aa();
            }
            if ("qechatforqassistant".equals(this.jdField_b_of_type_JavaLangString))
            {
              ExtendFriendPublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext);
              return true;
            }
            if ("searchforqassistant".equals(this.jdField_b_of_type_JavaLangString))
            {
              localObject1 = b("searchkey");
              UniteSearchActivity.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, 10004);
              return true;
            }
            if ("settingsforqassistant".equals(this.jdField_b_of_type_JavaLangString))
            {
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQSettingSettingActivity.class);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
              return true;
            }
            if ("confiessmsgforqassistant".equals(this.jdField_b_of_type_JavaLangString))
            {
              aquz localaquz = ((aqvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
              localObject2 = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
              localObject1 = localObject2;
              if (localaquz != null)
              {
                localObject1 = localObject2;
                if (!TextUtils.isEmpty(localaquz.l)) {
                  localObject1 = localaquz.l;
                }
              }
              localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
              ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              ((Intent)localObject2).putExtra("url", (String)localObject1);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
              return true;
            }
            if ("qzoneforqassistant".equals(this.jdField_b_of_type_JavaLangString)) {
              return h();
            }
            if ("weqzoneforqassistant".equals(this.jdField_b_of_type_JavaLangString))
            {
              localObject1 = new HashMap();
              ((HashMap)localObject1).put("key_enable_splash", "0");
              vvh.a(this.jdField_a_of_type_AndroidContentContext, "openfolder", (HashMap)localObject1);
              return true;
            }
            if ("scanforqassistant".equals(this.jdField_b_of_type_JavaLangString))
            {
              if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
                break label5030;
              }
              alhp.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 0L, 0L, 0);
              break label5030;
            }
            if ("bind_number".equals(this.jdField_b_of_type_JavaLangString))
            {
              bool1 = bool2;
              if ("bind".equals(this.jdField_c_of_type_JavaLangString))
              {
                Y();
                return true;
              }
            }
            else if ("stickynote".equals(this.jdField_b_of_type_JavaLangString))
            {
              bool1 = bool2;
              if ("feeddetail".equals(this.jdField_c_of_type_JavaLangString))
              {
                i();
                return true;
              }
            }
            else if ("commonBuddyGroup".equals(this.jdField_b_of_type_JavaLangString))
            {
              bool1 = bool2;
              if ("open".equals(this.jdField_c_of_type_JavaLangString))
              {
                h();
                return true;
              }
            }
            else
            {
              bool1 = bool2;
              if ("hippy".equals(this.jdField_b_of_type_JavaLangString))
              {
                bool1 = bool2;
                if ("open".equals(this.jdField_c_of_type_JavaLangString)) {
                  bool1 = HippyAccessHelper.startHippyPage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
                }
              }
            }
          }
        }
      }
    }
    label5024:
    return bool1;
    label5026:
    return true;
    label5028:
    return true;
    label5030:
    return true;
  }
  
  protected boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      PublishHomeWorkFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, null, paramString);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772299, 2130771990);
    }
    return true;
  }
  
  public boolean a(Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      QLog.e("JumpAction", 1, "[gotoApolloGame] attrs null");
      return false;
    }
    Object localObject = (String)paramMap.get("gameid");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = (String)paramMap.get("gameId");
    }
    for (;;)
    {
      String str = (String)paramMap.get("gamename");
      if (TextUtils.isEmpty(str)) {
        str = (String)paramMap.get("gameName");
      }
      for (;;)
      {
        QLog.d("JumpAction", 1, new Object[] { "[gotoApolloGame] game id=", localObject });
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            int i3 = Integer.parseInt((String)localObject);
            int i2 = 221;
            int i1 = i2;
            if (paramMap.containsKey("src")) {
              localObject = (String)paramMap.get("src");
            }
            try
            {
              i1 = Integer.parseInt((String)localObject);
              QLog.d("JumpAction", 1, new Object[] { "[gotoApolloGame] src=", Integer.valueOf(i1) });
              CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(i3, true, "launch", 0L, 9, 8, 0, 0, "", i1, str);
              str = (String)paramMap.get("gameParam");
              localObject = str;
              if (TextUtils.isEmpty(str)) {
                localObject = (String)paramMap.get("gameparam");
              }
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                localStartCheckParam.extendJson = ((String)localObject);
                QLog.d("JumpAction", 1, new Object[] { "[gotoApolloGame] gameParam=", localObject });
              }
              ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentContext, localStartCheckParam);
              return true;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                QLog.e("JumpAction", 1, "open apollo game, parse src failed, e=", localException);
                i1 = i2;
              }
            }
            QLog.e("JumpAction", 1, "open apollo game failed, no game id");
          }
          catch (Exception paramMap)
          {
            QLog.e("JumpAction", 1, "open apollo game, parse game id failed, e=", paramMap);
            return false;
          }
        }
        return false;
      }
    }
  }
  
  public Intent b(Intent paramIntent)
  {
    paramIntent.putExtra("action", 4);
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storysharefrom");
    String str1 = str2;
    try
    {
      if (TextUtils.equals(str4, "qzone")) {
        str1 = URLDecoder.decode(str2, "utf-8");
      }
      paramIntent.putExtra("extra_topic_id", Long.parseLong(str3));
      paramIntent.putExtra("extra_topic_name", str1);
      paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
      paramIntent.putExtra("extra_share_from_type", b(this.jdField_a_of_type_JavaUtilHashMap));
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public String b(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bisl == null) {
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
    }
    this.jdField_a_of_type_Bisl.c(paramInt);
    if ((!((JumpActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) && (!this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public Intent c(Intent paramIntent)
  {
    paramIntent.putExtra("action", 12);
    try
    {
      paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
      paramIntent.putExtra("extra_share_from_type", b(this.jdField_a_of_type_JavaUtilHashMap));
      paramIntent.putExtra("to_new_version", (String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"));
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public Intent d(Intent paramIntent)
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("showinfocard");
    int i1 = b(this.jdField_a_of_type_JavaUtilHashMap);
    if ((str5 != null) && (str5.equals("0"))) {}
    for (boolean bool = false;; bool = true)
    {
      if (TextUtils.isEmpty(str4))
      {
        if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3))) {
          return null;
        }
        int i2;
        try
        {
          i2 = Integer.parseInt(str2);
          if (i2 == 1)
          {
            if (TextUtils.isEmpty(str1)) {
              return null;
            }
            paramIntent.putExtra("action", 7);
            paramIntent.putExtra("EXTRA_USER_UIN", str1);
            paramIntent.putExtra("EXTRA_USER_UNION_ID", str3);
            paramIntent.putExtra("extra_is_show_info_card", bool);
            paramIntent.putExtra("extra_share_from_type", i1);
            paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
            return paramIntent;
          }
        }
        catch (NumberFormatException paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "makeStoryPlayVideoPageIntent, NumberFormatException, userId:" + str1 + ", userType:" + str2);
          }
          return null;
        }
        if (i2 == 5)
        {
          paramIntent.putExtra("action", 4);
          paramIntent.putExtra("extra_topic_id", Long.parseLong(str1));
          paramIntent.putExtra("extra_topic_name", (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname"));
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topiccolor");
          if (!TextUtils.isEmpty(str3)) {
            paramIntent.putExtra("extra_topic_color", Integer.parseInt(str3));
          }
          paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
          paramIntent.putExtra("extra_share_from_type", i1);
          return paramIntent;
        }
        paramIntent.putExtra("action", 6);
        paramIntent.putExtra("user_type", Integer.parseInt(str2));
        paramIntent.putExtra("user_unionid", str3);
        paramIntent.putExtra("come_from", i1);
        paramIntent.putExtra("showTitleBar", false);
        paramIntent.putExtra("showInfoCard", bool);
        return paramIntent;
      }
      paramIntent.putExtra("action", 6);
      paramIntent.putExtra("story_id", str4);
      paramIntent.putExtra("come_from", i1);
      paramIntent.putExtra("showTitleBar", false);
      paramIntent.putExtra("showInfoCard", false);
      return paramIntent;
    }
  }
  
  public void d(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public boolean d()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("url")) {
      this.jdField_a_of_type_JavaUtilHashMap.remove("url");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localIntent.putExtra((String)localEntry.getKey(), Uri.decode((String)localEntry.getValue()));
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("weburl")) {}
    for (localObject = Uri.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("weburl")); (((String)localObject).startsWith("https://sou.qq.com/")) || (((String)localObject).startsWith("https://sou.html5.qq.com/")); localObject = "")
    {
      localIntent.putExtra("url", (String)localObject);
      localIntent.putExtra("fragment_class", "com.tencent.mobileqq.search.activity.MixSearchWebFragment");
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!"1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("openanimtype")))) {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(0, 0);
      }
      return true;
    }
    return false;
  }
  
  public void e(String paramString)
  {
    this.g = paramString;
  }
  
  public boolean e()
  {
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"))) {}
    try
    {
      localObject1 = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"), "utf-8");
      str1 = "";
      localObject3 = str1;
      if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("userdata"))) {}
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      try
      {
        localObject3 = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"), "utf-8");
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(str3);
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          for (;;)
          {
            int i1;
            localNumberFormatException1.printStackTrace();
          }
        }
        i1 = 0;
        try
        {
          int i2 = Integer.parseInt(str2);
          i1 = i2;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject4;
            localNumberFormatException2.printStackTrace();
          }
        }
        ((avwp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ODPROXY_MGR)).a(this.jdField_a_of_type_AndroidContentContext, l1, "launcher", (String)localObject1, (String)localObject3, i1);
        return true;
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
        localUnsupportedEncodingException1.printStackTrace();
        localObject2 = localObject3;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          String str1;
          localUnsupportedEncodingException2.printStackTrace();
          localObject4 = str1;
        }
      }
    }
  }
  
  public void f(String paramString)
  {
    this.jdField_h_of_type_JavaLangString = paramString;
  }
  
  public boolean f()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, InterestSwitchEditActivity.class);
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean f_()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, AssistantSettingActivity.class);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean g()
  {
    Object localObject1;
    String str2;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
      if (localObject1 != null)
      {
        str2 = ((Intent)localObject1).getStringExtra("big_brother_source_key");
        localObject1 = ((Intent)localObject1).getDataString();
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = this.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("roomid")) {}
        for (String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");; str3 = "0")
        {
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("fromid")) {}
          for (String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");; str4 = "")
          {
            if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("roomtype")) {}
            for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomtype");; str5 = "")
            {
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("list_name")) {}
              for (String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("list_name");; str6 = "")
              {
                if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("first_jump_mode")) {}
                for (String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("first_jump_mode");; str7 = "h5")
                {
                  if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("need_record")) {}
                  for (String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("need_record");; str8 = "1")
                  {
                    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("is_record")) {}
                    for (String str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("is_record");; str9 = "0")
                    {
                      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("enter_record_if_finish")) {}
                      for (String str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enter_record_if_finish");; str10 = "1")
                      {
                        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("nowapp_ext")) {}
                        for (String str11 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nowapp_ext");; str11 = "")
                        {
                          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("nowplugin_ext")) {}
                          for (String str12 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nowplugin_ext");; str12 = "")
                          {
                            if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("h5_ext")) {}
                            for (String str13 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("h5_ext");; str13 = "")
                            {
                              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("shakespearetime")) {}
                              for (String str14 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shakespearetime");; str14 = "")
                              {
                                if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msgurl")) {}
                                for (String str15 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("msgurl"));; str15 = "")
                                {
                                  if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hostloading_percent")) {}
                                  for (String str16 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hostloading_percent");; str16 = "0")
                                  {
                                    String str17 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("coverurl");
                                    String str18 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extras");
                                    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
                                    localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("first");
                                    localObject2 = new Bundle();
                                    ((Bundle)localObject2).putString("coverurl", str17);
                                    ((Bundle)localObject2).putString("roomid", str3);
                                    ((Bundle)localObject2).putString("roomtype", str5);
                                    ((Bundle)localObject2).putString("extras_from_js", str18);
                                    ((Bundle)localObject2).putBoolean("can_use_h5_first", true);
                                    ((Bundle)localObject2).putString("first_jump_mode", str7);
                                    ((Bundle)localObject2).putString("is_record", str9);
                                    ((Bundle)localObject2).putString("enter_record_if_finish", str10);
                                    ((Bundle)localObject2).putString("nowapp_ext", str11);
                                    ((Bundle)localObject2).putString("nowplugin_ext", str12);
                                    ((Bundle)localObject2).putString("h5_ext", str13);
                                    ((Bundle)localObject2).putString("shakespearetime", str14);
                                    ((Bundle)localObject2).putString("fromid", str4);
                                    ((Bundle)localObject2).putString("url", str15);
                                    ((Bundle)localObject2).putString("listname", str6);
                                    ((Bundle)localObject2).putString("mqqScheme", (String)localObject1);
                                    if (!TextUtils.isEmpty(str2)) {
                                      ((Bundle)localObject2).putString("big_brother_source_key", str2);
                                    }
                                    boolean bool2 = true;
                                    boolean bool1 = bool2;
                                    if (!TextUtils.isEmpty(str8))
                                    {
                                      bool1 = bool2;
                                      if ("0".equals(str8)) {
                                        bool1 = false;
                                      }
                                    }
                                    ((Bundle)localObject2).putBoolean("need_record", bool1);
                                    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("topic")) {
                                      ((Bundle)localObject2).putString("topic", (String)this.jdField_a_of_type_JavaUtilHashMap.get("topic"));
                                    }
                                    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("story_ext")) {
                                      ((Bundle)localObject2).putString("story_ext", (String)this.jdField_a_of_type_JavaUtilHashMap.get("story_ext"));
                                    }
                                    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("startsrc")) {
                                      ((Bundle)localObject2).putString("startsrc", (String)this.jdField_a_of_type_JavaUtilHashMap.get("startsrc"));
                                    }
                                    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hostloading_percent")) {
                                      ((Bundle)localObject2).putInt("hostloading_percent", Integer.valueOf(str16).intValue());
                                    }
                                    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication()))
                                    {
                                      QQToast.a(BaseApplicationImpl.getApplication(), 1, "无网络连接请稍后再试", 1).a();
                                      return false;
                                    }
                                    try
                                    {
                                      ((avux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a((Bundle)localObject2);
                                      QLog.i("JumpAction", 1, "enter now plugin use shadow");
                                      return true;
                                    }
                                    catch (Exception localException)
                                    {
                                      if (QLog.isColorLevel()) {
                                        QLog.e("JumpAction", 2, localException.toString());
                                      }
                                      return false;
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      String str1 = "";
      str2 = null;
    }
  }
  
  public boolean g_()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddContactsActivity.class);
    localIntent.setFlags(67108864);
    int i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("des_type"));
    int i1 = i2;
    if (i2 != 0)
    {
      i1 = i2;
      if (i2 != 1)
      {
        i1 = i2;
        if (i2 != 2) {
          i1 = 0;
        }
      }
    }
    localIntent.putExtra("tab_index_key", i1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Object localObject = (bcvr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    if ((localObject != null) && ((((bcvr)localObject).a(2) > 0) || (((bcvr)localObject).a(1) > 0))) {}
    for (boolean bool = true;; bool = false)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("newflag", bool);
      localIntent.putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      localIntent.addFlags(805306368);
      if (this.jdField_a_of_type_JavaLangString != null) {}
      for (localObject = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("push_trans_channel");; localObject = null)
      {
        QZoneHelper.forwardToFriendFeed((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localIntent, (String)localObject, -1);
        LpReportInfo_dc02880.report(this.jdField_a_of_type_JavaLangString);
        return true;
      }
    }
  }
  
  public boolean i()
  {
    SmallVideoFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    return true;
  }
  
  public boolean j()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  public boolean k()
  {
    new JumpAction.1(this).start();
    return a();
  }
  
  public boolean l()
  {
    if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.jdField_c_of_type_JavaLangString.equals("aioorprofile"))) {}
    while (((this.jdField_b_of_type_JavaLangString.equals("group")) && (this.jdField_c_of_type_JavaLangString.equals("creategroup"))) || ((this.jdField_b_of_type_JavaLangString.equals("qstory")) && (this.jdField_c_of_type_JavaLangString.equals("publish")))) {
      return true;
    }
    return false;
  }
  
  public boolean m()
  {
    return (this.jdField_b_of_type_JavaLangString.equals("card")) && (this.jdField_c_of_type_JavaLangString.equals("show_pslcard")) && ("public_account".equals(this.jdField_a_of_type_JavaUtilHashMap.get("card_type"))) && ("app".equals(this.jdField_a_of_type_JavaUtilHashMap.get("src_type"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")));
  }
  
  public boolean n()
  {
    return (this.jdField_b_of_type_JavaLangString.equals("share")) && (this.jdField_c_of_type_JavaLangString.equals("to_fri"));
  }
  
  public boolean o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    String str = a(a(a(a(a(a(QzoneConfig.getInstance().getConfig("H5Url", "PersonalQzoneVisitor", "https://h5.qzone.qq.com/visitor/qzone/personal?uin={uin}&qua={qua}&clicktime={clicktime}&_bid=329&_wv=3&_proxy=true"), "{hostUin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "{clicktime}", String.valueOf(System.currentTimeMillis())), "{from}", "androidQQ"), "{qua}", QUA.getQUA3()), "{uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "{UIN}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.putExtra("articalChannelId", 5);
    if (bifz.jdField_a_of_type_JavaUtilHashMap.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717211));
    localIntent.setData(Uri.parse(str));
    localIntent.addFlags(268435456);
    localIntent.putExtra("needSkey", "true");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean p()
  {
    Object localObject = b("param_meta_data");
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localBundle.putString("param_meta_data", (String)localObject);
    }
    String str = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_JavaLangString;
    }
    absz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, (String)localObject, localBundle);
    return true;
  }
  
  public boolean q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "gotoSendBless");
    }
    aipw localaipw = (aipw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
    if (localaipw.a()) {
      localaipw.a(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      return true;
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, anvx.a(2131705384), 0).a();
    }
  }
  
  public boolean r()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("id");
    if (str == null) {
      return false;
    }
    try
    {
      l1 = Long.parseLong(str);
      if (l1 == -1L) {
        return false;
      }
    }
    catch (Exception localException)
    {
      long l1;
      for (;;)
      {
        l1 = -1L;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LebaSearchPluginManagerActivity.class);
      localIntent.putExtra("id", l1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    return true;
  }
  
  public boolean s()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_type");
    if ((localObject != null) && ("public_account".equals(localObject)))
    {
      int i1 = uuc.a(Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("account_flag")));
      if ((i1 == -3) || (i1 == -4)) {
        ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), 0L, 1);
      }
    }
    do
    {
      do
      {
        return true;
      } while ((localObject == null) || (!"crm".equals(localObject)));
      localObject = (antw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
    } while (localObject == null);
    ((antw)localObject).a(SystemClock.uptimeMillis());
    return true;
  }
  
  public boolean t()
  {
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("channelid");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("channelname");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("target");
    int i2;
    int i1;
    if ("1".equals(str5))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      if ("qzone".equals(localObject1)) {
        olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067C6", "0X80067C6", 0, 0, "", "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", false);
      }
      if ("webview".equals(this.jdField_d_of_type_JavaLangString)) {
        aady.a().a((String)localObject1, this.jdField_a_of_type_JavaUtilHashMap);
      }
      for (;;)
      {
        return true;
        i2 = 12;
        i1 = i2;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          i1 = i2;
          if (TextUtils.isDigitsOnly((CharSequence)localObject1)) {
            i1 = Integer.valueOf((String)localObject1).intValue();
          }
        }
        if (bmhv.h())
        {
          try
          {
            localObject1 = osg.a(this.jdField_a_of_type_AndroidContentContext, i1);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          }
          catch (Exception localException1) {}
          if (QLog.isColorLevel()) {
            QLog.e("JumpAction", 1, "jump activity error1 ", localException1);
          }
        }
        else if (bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          osg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 2, 0);
        }
        else
        {
          osg.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, 2);
        }
      }
    }
    int i3;
    Object localObject2;
    if ("2".equals(str5))
    {
      if (str3 == null) {
        return false;
      }
      try
      {
        i2 = Integer.parseInt(str3);
      }
      catch (Exception localException8)
      {
        try
        {
          for (;;)
          {
            i3 = Integer.parseInt(str1);
            if (i2 != -1) {
              break;
            }
            return false;
            localException8 = localException8;
            if (QLog.isDevelopLevel()) {
              QLog.e("JumpAction", 4, "gotoReadInJoy channelId error");
            }
            i2 = -1;
          }
        }
        catch (Exception localException5)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("JumpAction", 4, "gotoReadInJoy channelType error");
            }
            i3 = 0;
          }
        }
      }
      if (!TextUtils.isEmpty(localException1)) {
        break label1521;
      }
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131699145);
    }
    label923:
    label1458:
    label1521:
    for (;;)
    {
      for (;;)
      {
        String str4;
        for (;;)
        {
          for (;;)
          {
            boolean bool = "1".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("ispush"));
            if ((!bool) && (i2 == 70))
            {
              if ("webview".equals(this.jdField_d_of_type_JavaLangString)) {
                aady.a().k();
              }
              for (;;)
              {
                return true;
                KandianSubscribeManager.a(this.jdField_a_of_type_AndroidContentContext, 3, 4);
              }
            }
            if (i3 == 3)
            {
              if (i2 == 56)
              {
                if (bmhv.n())
                {
                  osg.a(this.jdField_a_of_type_AndroidContentContext, i2, (String)localObject2, i3, 4);
                  break;
                }
                osg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 4, 1);
                break;
              }
              osg.b(this.jdField_a_of_type_AndroidContentContext, i2, (String)localObject2, i3, 4);
              break;
            }
            String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("changeChannelOrder");
            i1 = 0;
            str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("moveChannelFromSource");
            try
            {
              i4 = Integer.valueOf(str2).intValue();
              i1 = i4;
              int i5 = Integer.valueOf(str4).intValue();
              i1 = i5;
            }
            catch (Exception localException6)
            {
              int i4;
              for (;;)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.e("JumpAction", 4, "gotoReadInJoy channelOrder error," + localException6.toString());
                }
                i4 = i1;
                i1 = 0;
              }
              Bundle localBundle = new Bundle();
              localBundle.putInt("key_native_channel_id", i2);
              localBundle.putInt("key_native_channel_change_order", i4);
              localBundle.putString("key_native_channel_name", (String)localObject2);
              localBundle.putInt("key_native_channel_type", i3);
              localBundle.putBoolean("key_native_channel_is_push", bool);
              localBundle.putInt("key_channel_source_from", i1);
              localBundle.putString("key_channel_jump_scheme", this.jdField_a_of_type_JavaLangString);
              QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_native_channel_jump", localBundle, null);
            }
            ReadInJoyBaseFragment.a(i2, 3);
            if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("v_url")) || (this.jdField_a_of_type_JavaUtilHashMap.containsKey("v_url_base64")))
            {
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("key_viola_fragment_jump_url", this.jdField_a_of_type_JavaLangString);
              ((Bundle)localObject2).putInt("key_native_channel_change_order", i4);
              ((Bundle)localObject2).putInt("key_native_channel_id", i2);
              QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_viola_fragment_jump", (Bundle)localObject2, null);
              break;
            }
            break;
            if (!"2001".equals(str5)) {
              break label923;
            }
            i1 = Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("from")).intValue();
            if (!bmhv.l()) {
              break label882;
            }
            try
            {
              localObject2 = osg.a(this.jdField_a_of_type_AndroidContentContext, i1);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            }
            catch (Exception localException2) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("JumpAction", 1, "jump activity error1 ", localException2);
          break;
          label882:
          if (bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            osg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, 0);
            break;
          }
          osg.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, i1);
          break;
          Object localObject3;
          if ("3".equals(str5))
          {
            localObject3 = osg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
            if ((this.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity))
            {
              ((FastWebActivity)this.jdField_a_of_type_AndroidContentContext).a((Intent)localObject3);
              break;
            }
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
            break;
          }
          if ("4".equals(str5))
          {
            localObject3 = this.jdField_a_of_type_AndroidContentContext;
            if (BaseActivity.sTopActivity != null) {
              localObject3 = BaseActivity.sTopActivity;
            }
            osg.a((Context)localObject3, this.jdField_a_of_type_JavaUtilHashMap);
            break;
          }
          if ("5".equals(str5))
          {
            osg.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
            break;
          }
          if (!"6".equals(str5)) {
            break label1154;
          }
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("v_url_base64")) {
            break;
          }
          try
          {
            localObject3 = c((String)this.jdField_a_of_type_JavaUtilHashMap.get("v_url_base64"));
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break;
            }
            tto.a(this.jdField_a_of_type_AndroidContentContext, "", (String)localObject3, null);
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            QLog.w("JumpAction", 1, "[gotoReadInJoyFromSourceTarget] openViolaPage, v_url error->" + localException3.getMessage());
          }
        }
        break;
        if ("7".equals(str5))
        {
          osg.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
          break;
        }
        if ("8".equals(str5))
        {
          if ("webview".equals(this.jdField_d_of_type_JavaLangString))
          {
            aady.a().f(this.jdField_d_of_type_JavaLangString);
            break;
          }
          KandianDailyManager.a(this.jdField_a_of_type_AndroidContentContext);
          break;
        }
        if ("9".equals(str5))
        {
          bmic.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
          break;
        }
        Intent localIntent1;
        if ("10".equals(str5))
        {
          if ("1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("bizType")))
          {
            localIntent1 = new Intent(this.jdField_a_of_type_AndroidContentContext, ReadInJoySettingActivity.class);
            this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
            break;
          }
          if (!"2".equals(this.jdField_a_of_type_JavaUtilHashMap.get("bizType"))) {
            break;
          }
          PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, ReadInJoyDraftboxFragment.class);
          break;
        }
        if (str4 == null) {
          return false;
        }
        try
        {
          i1 = Integer.parseInt(str4);
          if (i1 == -1) {
            return false;
          }
        }
        catch (Exception localException7)
        {
          Object localObject4;
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("JumpAction", 4, "gotoReadInJoy channelId error");
            }
            i1 = -1;
            continue;
            localObject4 = localIntent1;
            if (TextUtils.isEmpty(localIntent1)) {
              localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131699145);
            }
            if (!bmhv.n()) {
              break label1458;
            }
            try
            {
              localIntent1 = osg.a(this.jdField_a_of_type_AndroidContentContext, 12);
              this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
            }
            catch (Exception localException4) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("JumpAction", 1, "jump activity error1 ", localException4);
          break;
          Intent localIntent2 = new Intent("android.intent.action.MAIN");
          localIntent2.putExtra("channel_id", i1);
          localIntent2.putExtra("channel_name", (String)localObject4);
          localIntent2.putExtra("readinjoy_launch_source", 7);
          bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localIntent2);
        }
      }
      break;
    }
  }
  
  public boolean u()
  {
    int i3 = 0;
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("sub_action"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sub_action");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("action_name")) {
        break label133;
      }
    }
    label133:
    for (String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("action_name");; str2 = "")
    {
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        break label140;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "subAction[" + str1 + "] or actionName[" + str2 + "] null");
      }
      return true;
      str1 = "";
      break;
    }
    label140:
    String str3;
    label168:
    String str4;
    label196:
    String str5;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tag"))
    {
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("main_action")) {
        break label574;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("main_action");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("to_uin")) {
        break label581;
      }
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("to_uin");
      label224:
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("from_type")))) {
        break label630;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "webReportT get from_type: " + (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"));
      }
    }
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"));
        i2 = i3;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("result"))
        {
          i2 = i3;
          if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("result"))) {
            if (QLog.isColorLevel()) {
              QLog.d("JumpAction", 2, "webReportT get result: " + (String)this.jdField_a_of_type_JavaUtilHashMap.get("result"));
            }
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("result"));
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("r2"))
          {
            String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("r2");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("r3")) {
              continue;
            }
            str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("r3");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("r4")) {
              continue;
            }
            str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("r4");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("r5")) {
              continue;
            }
            str10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("r5");
            bdla.b(null, str3, str4, str5, str1, str2, i1, i2, str6, str8, str9, str10);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("JumpAction", 2, "webReportT ");
            return true;
            str3 = "";
            break label168;
            label574:
            str4 = "";
            break label196;
            label581:
            str5 = "";
            break label224;
            localException1 = localException1;
            i1 = 0;
            continue;
          }
          String str7 = "";
          continue;
          String str8 = "";
          continue;
          String str9 = "";
          continue;
          String str10 = "";
          continue;
        }
        catch (Exception localException2)
        {
          int i2 = i3;
          continue;
        }
      }
      label630:
      int i1 = 0;
    }
  }
  
  public boolean v()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("source")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("source"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("source_article_id")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("source_article_id"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("operation")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("operation"))) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("op_source")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("op_source")))) {}
    try
    {
      int i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("source"));
      long l1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("source_article_id"));
      int i2 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("operation"));
      int i3 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("op_source"));
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "webReportArticleRealTime get source[ " + (String)this.jdField_a_of_type_JavaUtilHashMap.get("source") + "] source_article_id[" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("source_article_id") + "] operation[" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("operation") + "] op_source[" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("op_source") + "]");
      }
      bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, i2, i3);
    }
    catch (Exception localException)
    {
      label326:
      break label326;
    }
    return true;
  }
  
  /* Error */
  public boolean w()
  {
    // Byte code:
    //   0: new 306	android/os/Bundle
    //   3: dup
    //   4: invokespecial 307	android/os/Bundle:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc_w 6895
    //   14: aload_0
    //   15: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   18: ldc_w 1888
    //   21: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 45	java/lang/String
    //   27: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload 5
    //   35: ldc_w 6897
    //   38: aload_0
    //   39: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   42: ldc_w 2074
    //   45: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast 45	java/lang/String
    //   51: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   54: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 5
    //   59: ldc_w 6899
    //   62: aload_0
    //   63: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   66: ldc_w 6901
    //   69: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 45	java/lang/String
    //   75: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 5
    //   80: ldc_w 6903
    //   83: aload_0
    //   84: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   87: ldc_w 6905
    //   90: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast 45	java/lang/String
    //   96: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 5
    //   101: ldc_w 6907
    //   104: aload_0
    //   105: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   108: ldc_w 6909
    //   111: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: checkcast 45	java/lang/String
    //   117: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 5
    //   122: ldc_w 6911
    //   125: aload_0
    //   126: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   129: ldc_w 6913
    //   132: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 45	java/lang/String
    //   138: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 5
    //   143: ldc_w 6915
    //   146: aload_0
    //   147: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   150: ldc_w 6917
    //   153: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: checkcast 45	java/lang/String
    //   159: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload 5
    //   164: ldc_w 6919
    //   167: iconst_0
    //   168: invokevirtual 1329	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   171: aload 5
    //   173: ldc_w 6921
    //   176: ldc_w 283
    //   179: aload_0
    //   180: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   183: ldc_w 6923
    //   186: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   189: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   192: invokevirtual 1329	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   195: aload 5
    //   197: ldc_w 6925
    //   200: aload_0
    //   201: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   204: ldc_w 6927
    //   207: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: checkcast 45	java/lang/String
    //   213: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   216: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   223: ldc_w 6929
    //   226: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   229: checkcast 184	java/lang/CharSequence
    //   232: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne +40 -> 275
    //   238: aload 5
    //   240: ldc_w 6931
    //   243: new 6933	java/math/BigInteger
    //   246: dup
    //   247: aload_0
    //   248: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   251: ldc_w 6929
    //   254: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   257: checkcast 45	java/lang/String
    //   260: invokespecial 6934	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   263: invokevirtual 6935	java/math/BigInteger:longValue	()J
    //   266: invokestatic 2168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: invokevirtual 272	java/lang/Long:longValue	()J
    //   272: invokevirtual 912	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   275: aload_0
    //   276: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   279: ldc_w 6937
    //   282: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   285: checkcast 184	java/lang/CharSequence
    //   288: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   291: ifne +30 -> 321
    //   294: aload 5
    //   296: ldc_w 6939
    //   299: aload_0
    //   300: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   303: ldc_w 6937
    //   306: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   309: checkcast 45	java/lang/String
    //   312: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   315: invokevirtual 844	java/lang/Integer:intValue	()I
    //   318: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   321: aload_0
    //   322: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   325: ldc_w 6941
    //   328: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   331: checkcast 184	java/lang/CharSequence
    //   334: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   337: ifne +24 -> 361
    //   340: aload 5
    //   342: ldc_w 6943
    //   345: aload_0
    //   346: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   349: ldc_w 6941
    //   352: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   355: checkcast 45	java/lang/String
    //   358: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload_0
    //   362: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   365: ldc_w 6945
    //   368: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: checkcast 45	java/lang/String
    //   374: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   377: ifne +1431 -> 1808
    //   380: aload 5
    //   382: ldc_w 6947
    //   385: aload_0
    //   386: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   389: ldc_w 6945
    //   392: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   395: checkcast 45	java/lang/String
    //   398: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   401: invokevirtual 844	java/lang/Integer:intValue	()I
    //   404: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   407: aload_0
    //   408: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   411: ldc_w 6949
    //   414: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   417: checkcast 45	java/lang/String
    //   420: astore 4
    //   422: aload 4
    //   424: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   427: ifne +19 -> 446
    //   430: aload 5
    //   432: ldc_w 6951
    //   435: aload 4
    //   437: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   440: invokevirtual 844	java/lang/Integer:intValue	()I
    //   443: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   446: aload 5
    //   448: ldc_w 6953
    //   451: aload_0
    //   452: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   455: ldc_w 6955
    //   458: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   461: checkcast 45	java/lang/String
    //   464: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload 5
    //   472: ldc_w 6957
    //   475: aload_0
    //   476: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   479: ldc_w 6959
    //   482: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   485: checkcast 45	java/lang/String
    //   488: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   491: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload_0
    //   495: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   498: ldc_w 6961
    //   501: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   504: checkcast 45	java/lang/String
    //   507: astore 4
    //   509: aload 4
    //   511: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   514: ifne +19 -> 533
    //   517: aload 5
    //   519: ldc_w 6961
    //   522: aload 4
    //   524: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   527: invokevirtual 844	java/lang/Integer:intValue	()I
    //   530: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   533: aload_0
    //   534: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   537: ldc_w 6963
    //   540: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   543: checkcast 45	java/lang/String
    //   546: astore 4
    //   548: aload 4
    //   550: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   553: ifne +19 -> 572
    //   556: aload 5
    //   558: ldc_w 6963
    //   561: aload 4
    //   563: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   566: invokevirtual 844	java/lang/Integer:intValue	()I
    //   569: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   572: aload_0
    //   573: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   576: ldc_w 6965
    //   579: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   582: checkcast 45	java/lang/String
    //   585: astore 4
    //   587: aload 4
    //   589: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   592: ifne +19 -> 611
    //   595: aload 5
    //   597: ldc_w 6965
    //   600: aload 4
    //   602: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   605: invokevirtual 844	java/lang/Integer:intValue	()I
    //   608: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   611: aload_0
    //   612: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   615: ldc_w 6967
    //   618: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   621: checkcast 45	java/lang/String
    //   624: astore 4
    //   626: aload 4
    //   628: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   631: ifne +19 -> 650
    //   634: aload 5
    //   636: ldc_w 6967
    //   639: aload 4
    //   641: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   644: invokevirtual 844	java/lang/Integer:intValue	()I
    //   647: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   650: aload_0
    //   651: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   654: ldc_w 830
    //   657: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   660: checkcast 45	java/lang/String
    //   663: astore 4
    //   665: aload 4
    //   667: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   670: ifne +116 -> 786
    //   673: aload_0
    //   674: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   677: ldc_w 832
    //   680: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   683: checkcast 45	java/lang/String
    //   686: astore 6
    //   688: aload_0
    //   689: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   692: ldc_w 836
    //   695: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   698: checkcast 45	java/lang/String
    //   701: astore 7
    //   703: aload_0
    //   704: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   707: ldc_w 838
    //   710: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   713: checkcast 45	java/lang/String
    //   716: astore 8
    //   718: new 6969	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData
    //   721: dup
    //   722: invokespecial 6970	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:<init>	()V
    //   725: astore 9
    //   727: aload 9
    //   729: aload 4
    //   731: putfield 6971	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   734: aload 9
    //   736: aload 6
    //   738: putfield 6972	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   741: aload 9
    //   743: ldc_w 531
    //   746: aload 7
    //   748: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   751: putfield 6973	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_b_of_type_Boolean	Z
    //   754: aload 9
    //   756: ldc_w 283
    //   759: aload 8
    //   761: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   764: putfield 6974	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_a_of_type_Boolean	Z
    //   767: aload 5
    //   769: ldc_w 6976
    //   772: iconst_1
    //   773: invokevirtual 1329	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   776: aload 5
    //   778: ldc_w 6978
    //   781: aload 9
    //   783: invokevirtual 6982	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   786: aload 5
    //   788: ldc_w 6984
    //   791: aload_0
    //   792: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   795: ldc_w 6986
    //   798: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   801: checkcast 45	java/lang/String
    //   804: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   807: aload 5
    //   809: ldc_w 6988
    //   812: aload_0
    //   813: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   816: ldc_w 6990
    //   819: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   822: checkcast 45	java/lang/String
    //   825: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   828: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   831: ldc_w 283
    //   834: aload_0
    //   835: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   838: ldc_w 6992
    //   841: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   844: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   847: ifeq +1086 -> 1933
    //   850: iconst_1
    //   851: istore_1
    //   852: aload 5
    //   854: ldc_w 6994
    //   857: iload_1
    //   858: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   861: iload_1
    //   862: ifne +802 -> 1664
    //   865: aload_0
    //   866: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   869: ldc_w 6923
    //   872: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   875: checkcast 45	java/lang/String
    //   878: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   881: invokevirtual 844	java/lang/Integer:intValue	()I
    //   884: istore_2
    //   885: aload 5
    //   887: ldc_w 6996
    //   890: iload_2
    //   891: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   894: aload_0
    //   895: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   898: ldc_w 6998
    //   901: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   904: checkcast 45	java/lang/String
    //   907: invokestatic 268	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   910: invokevirtual 272	java/lang/Long:longValue	()J
    //   913: iconst_1
    //   914: invokestatic 7002	pkg:a	(JZ)Ljava/lang/String;
    //   917: astore 4
    //   919: aload 5
    //   921: ldc_w 7004
    //   924: aload 4
    //   926: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: aload 5
    //   931: ldc_w 7006
    //   934: aload_0
    //   935: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   938: ldc_w 7008
    //   941: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   944: checkcast 45	java/lang/String
    //   947: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   950: aload 5
    //   952: ldc_w 7010
    //   955: aload_0
    //   956: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   959: ldc_w 7012
    //   962: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   965: checkcast 45	java/lang/String
    //   968: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   971: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   974: aload 5
    //   976: ldc_w 7014
    //   979: aload_0
    //   980: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   983: ldc_w 7016
    //   986: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   989: checkcast 45	java/lang/String
    //   992: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   995: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   998: aload 5
    //   1000: ldc_w 7018
    //   1003: aload_0
    //   1004: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1007: ldc_w 7020
    //   1010: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1013: checkcast 45	java/lang/String
    //   1016: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1019: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1022: aload_0
    //   1023: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1026: ldc_w 7022
    //   1029: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1032: ifeq +46 -> 1078
    //   1035: aload_0
    //   1036: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1039: ldc_w 7022
    //   1042: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1045: checkcast 184	java/lang/CharSequence
    //   1048: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1051: ifne +27 -> 1078
    //   1054: aload 5
    //   1056: ldc_w 7024
    //   1059: aload_0
    //   1060: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1063: ldc_w 7022
    //   1066: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1069: checkcast 45	java/lang/String
    //   1072: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1075: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1078: aload_0
    //   1079: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1082: ldc_w 6913
    //   1085: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1088: checkcast 45	java/lang/String
    //   1091: invokestatic 7029	swx:a	(Ljava/lang/String;)Lsxc;
    //   1094: astore 4
    //   1096: aload 4
    //   1098: ifnull +29 -> 1127
    //   1101: aload 5
    //   1103: ldc_w 7031
    //   1106: aload 4
    //   1108: getfield 7034	sxc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1111: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1114: aload 5
    //   1116: ldc_w 7036
    //   1119: aload 4
    //   1121: getfield 7038	sxc:b	J
    //   1124: invokevirtual 912	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1127: new 306	android/os/Bundle
    //   1130: dup
    //   1131: invokespecial 307	android/os/Bundle:<init>	()V
    //   1134: astore 4
    //   1136: aload 4
    //   1138: ldc_w 7040
    //   1141: aload_0
    //   1142: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1145: ldc_w 6913
    //   1148: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1151: checkcast 45	java/lang/String
    //   1154: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1157: aload 4
    //   1159: ldc_w 7042
    //   1162: aload_0
    //   1163: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1166: ldc_w 6913
    //   1169: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1172: checkcast 45	java/lang/String
    //   1175: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1178: aload 4
    //   1180: ldc_w 7044
    //   1183: aload_0
    //   1184: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1187: ldc_w 6901
    //   1190: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1193: checkcast 45	java/lang/String
    //   1196: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1199: invokevirtual 844	java/lang/Integer:intValue	()I
    //   1202: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1205: aload 4
    //   1207: ldc_w 7046
    //   1210: aload_0
    //   1211: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1214: ldc_w 6905
    //   1217: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1220: checkcast 45	java/lang/String
    //   1223: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1226: invokevirtual 844	java/lang/Integer:intValue	()I
    //   1229: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1232: aload 4
    //   1234: ldc_w 7048
    //   1237: aload_0
    //   1238: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1241: ldc_w 6909
    //   1244: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1247: checkcast 45	java/lang/String
    //   1250: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1253: invokevirtual 844	java/lang/Integer:intValue	()I
    //   1256: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1259: aload 4
    //   1261: ldc_w 7050
    //   1264: aload_0
    //   1265: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1268: ldc_w 6901
    //   1271: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1274: checkcast 45	java/lang/String
    //   1277: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1280: invokevirtual 844	java/lang/Integer:intValue	()I
    //   1283: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1286: aload_0
    //   1287: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1290: ldc_w 6923
    //   1293: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1296: checkcast 45	java/lang/String
    //   1299: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1302: invokevirtual 844	java/lang/Integer:intValue	()I
    //   1305: iconst_1
    //   1306: if_icmpne +813 -> 2119
    //   1309: aload 4
    //   1311: ldc_w 7052
    //   1314: aload_0
    //   1315: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1318: ldc_w 7008
    //   1321: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1324: checkcast 45	java/lang/String
    //   1327: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1330: aload 4
    //   1332: ldc_w 7054
    //   1335: aload_0
    //   1336: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1339: ldc_w 7012
    //   1342: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1345: checkcast 45	java/lang/String
    //   1348: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1351: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1354: aload 4
    //   1356: ldc_w 7056
    //   1359: aload_0
    //   1360: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1363: ldc_w 7008
    //   1366: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1369: checkcast 45	java/lang/String
    //   1372: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1375: aload 4
    //   1377: ldc_w 7058
    //   1380: aload_0
    //   1381: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1384: ldc_w 6923
    //   1387: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1390: checkcast 45	java/lang/String
    //   1393: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1396: invokevirtual 844	java/lang/Integer:intValue	()I
    //   1399: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1402: aload 4
    //   1404: ldc_w 7060
    //   1407: aload_0
    //   1408: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1411: ldc_w 6917
    //   1414: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1417: checkcast 45	java/lang/String
    //   1420: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1423: aload 4
    //   1425: ldc_w 7062
    //   1428: iconst_5
    //   1429: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1432: aload 4
    //   1434: ldc_w 7064
    //   1437: iconst_0
    //   1438: invokevirtual 1329	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1441: aload 4
    //   1443: ldc_w 4255
    //   1446: aload_0
    //   1447: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1450: ldc_w 6959
    //   1453: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1456: checkcast 45	java/lang/String
    //   1459: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1462: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1465: aload 4
    //   1467: ldc_w 1934
    //   1470: aload_0
    //   1471: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1474: ldc_w 6955
    //   1477: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1480: checkcast 45	java/lang/String
    //   1483: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1486: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1489: aload 4
    //   1491: ldc_w 6927
    //   1494: aload_0
    //   1495: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1498: ldc_w 6913
    //   1501: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1504: checkcast 45	java/lang/String
    //   1507: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1510: aload 4
    //   1512: ldc_w 1888
    //   1515: aload_0
    //   1516: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1519: ldc_w 1888
    //   1522: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1525: checkcast 45	java/lang/String
    //   1528: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1531: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1534: aload 4
    //   1536: ldc_w 7066
    //   1539: aload_0
    //   1540: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1543: ldc_w 6998
    //   1546: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1549: checkcast 45	java/lang/String
    //   1552: invokestatic 268	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1555: invokevirtual 272	java/lang/Long:longValue	()J
    //   1558: invokestatic 7068	pkg:a	(J)Ljava/lang/String;
    //   1561: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1564: aload 4
    //   1566: ldc_w 4259
    //   1569: aload_0
    //   1570: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1573: ldc_w 1888
    //   1576: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1579: checkcast 45	java/lang/String
    //   1582: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1585: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1588: aload 4
    //   1590: ldc_w 1904
    //   1593: sipush 140
    //   1596: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1599: aload 5
    //   1601: ldc_w 7070
    //   1604: aload 4
    //   1606: invokestatic 7075	bdof:a	(Landroid/os/Bundle;)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1609: checkcast 7077	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   1612: invokevirtual 7078	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getBytes	()[B
    //   1615: invokevirtual 7081	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1618: iload_2
    //   1619: bipush 6
    //   1621: if_icmpne +43 -> 1664
    //   1624: aload_0
    //   1625: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1628: ldc_w 7083
    //   1631: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1634: ifeq +30 -> 1664
    //   1637: aload 5
    //   1639: ldc_w 7085
    //   1642: aload_0
    //   1643: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1646: ldc_w 7083
    //   1649: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1652: checkcast 45	java/lang/String
    //   1655: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1658: invokestatic 7088	pkh:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   1661: invokevirtual 6982	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1664: aload 5
    //   1666: ldc_w 7090
    //   1669: iconst_5
    //   1670: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1673: iload_1
    //   1674: iconst_1
    //   1675: if_icmpne +565 -> 2240
    //   1678: aload 5
    //   1680: ldc_w 6947
    //   1683: iconst_m1
    //   1684: invokevirtual 7091	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1687: invokestatic 7095	plw:a	(I)Z
    //   1690: istore_3
    //   1691: iload_3
    //   1692: ifeq +613 -> 2305
    //   1695: new 134	android/content/Intent
    //   1698: dup
    //   1699: invokespecial 135	android/content/Intent:<init>	()V
    //   1702: astore 4
    //   1704: aload 4
    //   1706: aload 5
    //   1708: invokevirtual 1643	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1711: pop
    //   1712: aload_0
    //   1713: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1716: aload 4
    //   1718: invokestatic 7098	ssn:a	(Landroid/content/Context;Landroid/content/Intent;)V
    //   1721: iconst_1
    //   1722: ireturn
    //   1723: astore 4
    //   1725: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1728: ifeq -1407 -> 321
    //   1731: ldc 111
    //   1733: iconst_2
    //   1734: new 113	java/lang/StringBuilder
    //   1737: dup
    //   1738: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1741: ldc_w 7100
    //   1744: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1747: aload_0
    //   1748: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1751: ldc_w 6929
    //   1754: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1757: checkcast 45	java/lang/String
    //   1760: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: ldc_w 7102
    //   1766: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: aload_0
    //   1770: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1773: ldc_w 6937
    //   1776: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1779: checkcast 45	java/lang/String
    //   1782: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1785: ldc_w 7104
    //   1788: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1791: aload 4
    //   1793: invokevirtual 993	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1796: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1802: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1805: goto -1484 -> 321
    //   1808: aload 5
    //   1810: ldc_w 6947
    //   1813: bipush 100
    //   1815: invokevirtual 924	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1818: goto -1411 -> 407
    //   1821: astore 4
    //   1823: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1826: ifeq -105 -> 1721
    //   1829: ldc 111
    //   1831: iconst_2
    //   1832: new 113	java/lang/StringBuilder
    //   1835: dup
    //   1836: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1839: ldc_w 7106
    //   1842: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: aload_0
    //   1846: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1849: ldc_w 6955
    //   1852: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1855: checkcast 45	java/lang/String
    //   1858: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1861: ldc_w 7108
    //   1864: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1867: aload_0
    //   1868: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1871: ldc_w 6955
    //   1874: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1877: checkcast 45	java/lang/String
    //   1880: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1883: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1886: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1889: iconst_1
    //   1890: ireturn
    //   1891: astore 4
    //   1893: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1896: ifeq -1246 -> 650
    //   1899: ldc 111
    //   1901: iconst_2
    //   1902: ldc_w 7110
    //   1905: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1908: goto -1258 -> 650
    //   1911: astore 4
    //   1913: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1916: ifeq -1085 -> 831
    //   1919: ldc 111
    //   1921: iconst_2
    //   1922: ldc_w 7112
    //   1925: aload 4
    //   1927: invokestatic 5500	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1930: goto -1099 -> 831
    //   1933: iconst_0
    //   1934: istore_1
    //   1935: goto -1083 -> 852
    //   1938: astore 4
    //   1940: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1943: ifeq +406 -> 2349
    //   1946: ldc 111
    //   1948: iconst_2
    //   1949: new 113	java/lang/StringBuilder
    //   1952: dup
    //   1953: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1956: ldc_w 7114
    //   1959: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1962: aload 4
    //   1964: invokevirtual 993	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1967: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1970: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1973: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1976: goto +373 -> 2349
    //   1979: astore 4
    //   1981: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1984: ifeq -263 -> 1721
    //   1987: ldc 111
    //   1989: iconst_2
    //   1990: new 113	java/lang/StringBuilder
    //   1993: dup
    //   1994: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1997: ldc_w 7116
    //   2000: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2003: aload_0
    //   2004: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2007: ldc_w 7020
    //   2010: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2013: checkcast 45	java/lang/String
    //   2016: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2019: ldc_w 7118
    //   2022: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2025: aload_0
    //   2026: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2029: ldc_w 7022
    //   2032: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2035: checkcast 45	java/lang/String
    //   2038: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2041: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2044: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2047: iconst_1
    //   2048: ireturn
    //   2049: astore 4
    //   2051: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2054: ifeq -333 -> 1721
    //   2057: ldc 111
    //   2059: iconst_2
    //   2060: new 113	java/lang/StringBuilder
    //   2063: dup
    //   2064: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   2067: ldc_w 7120
    //   2070: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2073: aload_0
    //   2074: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2077: ldc_w 6923
    //   2080: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2083: checkcast 45	java/lang/String
    //   2086: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: ldc_w 7122
    //   2092: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2095: aload_0
    //   2096: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2099: ldc_w 6998
    //   2102: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2105: checkcast 45	java/lang/String
    //   2108: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2111: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2114: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2117: iconst_1
    //   2118: ireturn
    //   2119: aload_0
    //   2120: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2123: ldc_w 7124
    //   2126: invokevirtual 223	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2129: ifeq +43 -> 2172
    //   2132: aload_0
    //   2133: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2136: ldc_w 7124
    //   2139: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2142: checkcast 184	java/lang/CharSequence
    //   2145: invokestatic 190	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2148: ifne +24 -> 2172
    //   2151: aload 4
    //   2153: ldc_w 7052
    //   2156: aload_0
    //   2157: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2160: ldc_w 7124
    //   2163: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2166: checkcast 45	java/lang/String
    //   2169: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2172: aload 4
    //   2174: ldc_w 7054
    //   2177: aload_0
    //   2178: getfield 97	bheh:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2181: ldc_w 7016
    //   2184: invokevirtual 177	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2187: checkcast 45	java/lang/String
    //   2190: invokestatic 180	bheh:c	(Ljava/lang/String;)Ljava/lang/String;
    //   2193: invokevirtual 313	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2196: goto -821 -> 1375
    //   2199: astore 6
    //   2201: invokestatic 499	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2204: ifeq -640 -> 1564
    //   2207: ldc 111
    //   2209: iconst_2
    //   2210: new 113	java/lang/StringBuilder
    //   2213: dup
    //   2214: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   2217: ldc_w 7126
    //   2220: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2223: aload 6
    //   2225: invokevirtual 993	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2228: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2231: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2234: invokestatic 132	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2237: goto -673 -> 1564
    //   2240: aload 5
    //   2242: ldc_w 6947
    //   2245: iconst_m1
    //   2246: invokevirtual 7091	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   2249: aload 5
    //   2251: ldc_w 6903
    //   2254: invokevirtual 7127	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2257: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2260: invokevirtual 844	java/lang/Integer:intValue	()I
    //   2263: aload 5
    //   2265: ldc_w 6907
    //   2268: invokevirtual 7127	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2271: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2274: invokevirtual 844	java/lang/Integer:intValue	()I
    //   2277: aload 5
    //   2279: ldc_w 6899
    //   2282: invokevirtual 7127	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2285: invokestatic 841	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2288: invokevirtual 844	java/lang/Integer:intValue	()I
    //   2291: invokestatic 7130	plw:a	(IIII)Z
    //   2294: istore_3
    //   2295: goto -604 -> 1691
    //   2298: astore 4
    //   2300: iconst_0
    //   2301: istore_3
    //   2302: goto -611 -> 1691
    //   2305: new 134	android/content/Intent
    //   2308: dup
    //   2309: aload_0
    //   2310: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2313: ldc_w 7132
    //   2316: invokespecial 212	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2319: astore 4
    //   2321: aload 4
    //   2323: ldc_w 1271
    //   2326: invokevirtual 1268	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2329: pop
    //   2330: aload 4
    //   2332: aload 5
    //   2334: invokevirtual 1643	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   2337: pop
    //   2338: aload_0
    //   2339: getfield 90	bheh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2342: aload 4
    //   2344: invokevirtual 216	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2347: iconst_1
    //   2348: ireturn
    //   2349: aconst_null
    //   2350: astore 4
    //   2352: goto -1433 -> 919
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2355	0	this	bheh
    //   851	1084	1	i1	int
    //   884	738	2	i2	int
    //   1690	612	3	bool	boolean
    //   420	1297	4	localObject	Object
    //   1723	69	4	localException1	Exception
    //   1821	1	4	localException2	Exception
    //   1891	1	4	localException3	Exception
    //   1911	15	4	localException4	Exception
    //   1938	25	4	localException5	Exception
    //   1979	1	4	localException6	Exception
    //   2049	124	4	localException7	Exception
    //   2298	1	4	localException8	Exception
    //   2319	32	4	localIntent	Intent
    //   7	2326	5	localBundle	Bundle
    //   686	51	6	str1	String
    //   2199	25	6	localException9	Exception
    //   701	46	7	str2	String
    //   716	44	8	str3	String
    //   725	57	9	localAnchorData	com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData
    // Exception table:
    //   from	to	target	type
    //   219	275	1723	java/lang/Exception
    //   275	321	1723	java/lang/Exception
    //   446	494	1821	java/lang/Exception
    //   494	533	1891	java/lang/Exception
    //   533	572	1891	java/lang/Exception
    //   572	611	1891	java/lang/Exception
    //   611	650	1891	java/lang/Exception
    //   807	831	1911	java/lang/Exception
    //   894	919	1938	java/lang/Exception
    //   998	1078	1979	java/lang/Exception
    //   865	894	2049	java/lang/Exception
    //   919	998	2049	java/lang/Exception
    //   1078	1096	2049	java/lang/Exception
    //   1101	1127	2049	java/lang/Exception
    //   1127	1375	2049	java/lang/Exception
    //   1375	1534	2049	java/lang/Exception
    //   1564	1618	2049	java/lang/Exception
    //   1624	1664	2049	java/lang/Exception
    //   1940	1976	2049	java/lang/Exception
    //   1981	2047	2049	java/lang/Exception
    //   2119	2172	2049	java/lang/Exception
    //   2172	2196	2049	java/lang/Exception
    //   2201	2237	2049	java/lang/Exception
    //   1534	1564	2199	java/lang/Exception
    //   1678	1691	2298	java/lang/Exception
    //   2240	2295	2298	java/lang/Exception
  }
  
  public boolean x()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, GeneralSettingActivity.class);
    localIntent.addFlags(603979776);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean y()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
    Intent localIntent = new Intent((Activity)this.jdField_a_of_type_AndroidContentContext, ApolloGuestsStateActivity.class);
    localIntent.putExtra("extra_guest_nick", str1);
    localIntent.putExtra("extra_guest_uin", str2);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivity(localIntent);
    return true;
  }
  
  public boolean z()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bheh
 * JD-Core Version:    0.7.0.1
 */
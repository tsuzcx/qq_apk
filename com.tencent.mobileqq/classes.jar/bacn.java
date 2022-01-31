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
import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
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
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.InterestSwitchEditActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.MainFragment;
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
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;
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
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.JumpAction.1;
import com.tencent.mobileqq.utils.JumpAction.11;
import com.tencent.mobileqq.utils.JumpAction.2;
import com.tencent.mobileqq.utils.JumpAction.4;
import com.tencent.mobileqq.utils.JumpAction.8;
import com.tencent.mobileqq.utils.JumpAction.9;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
import common.config.service.QzoneConfig;
import cooperation.comic.VipComicJumpActivity;
import cooperation.hce.HcePluginInstallActivity;
import cooperation.plugin.PluginInfo;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.troop.NearbyVideoChatProxyActivity;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageProxyActivity;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
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

public class bacn
{
  public static int a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.mobileqq" };
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public aagm a;
  private ajql jdField_a_of_type_Ajql;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public final Context a;
  protected Handler a;
  private bada jdField_a_of_type_Bada = new bada(this, this);
  private badb jdField_a_of_type_Badb;
  protected bbms a;
  bcqu jdField_a_of_type_Bcqu = new bacz(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  public String a;
  public final HashMap<String, String> a;
  private Hashtable<String, Long> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
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
  private boolean f;
  public String g;
  private boolean g;
  public String h;
  private boolean h;
  private boolean i;
  private boolean j;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r = "";
  private String s = "";
  private String t = "";
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public bacn(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Aagm = new bacs(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private boolean B()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HcePluginInstallActivity.class);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean C()
  {
    int i1 = 0;
    if (!badq.g(BaseApplicationImpl.getApplication()))
    {
      bbmy.a(BaseApplicationImpl.getApplication(), 1, 2131628949, 1).a();
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
        localObject = new JSONObject(new String(baaw.decode(str1, 0)));
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
  
  private boolean D()
  {
    int i2 = 0;
    if (!badq.g(BaseApplicationImpl.getApplication()))
    {
      bbmy.a(BaseApplicationImpl.getApplication(), 1, 2131628949, 1).a();
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
        label106:
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
      break label106;
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
  
  private boolean E()
  {
    if (!badq.g(BaseApplicationImpl.getApplication()))
    {
      bbmy.a(BaseApplicationImpl.getApplication(), 1, 2131628949, 1).a();
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
  
  private boolean F()
  {
    boolean bool = ((Boolean)((spz)sqg.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("token");
    if (!TextUtils.isEmpty(str)) {
      tfh.a(this.jdField_a_of_type_AndroidContentContext, str, new bacw(this), null);
    }
    for (;;)
    {
      return true;
      if (TextUtils.equals(this.c, "publish"))
      {
        G();
      }
      else
      {
        if (bool)
        {
          this.c = "open";
          tfh.a(this.jdField_a_of_type_JavaUtilHashMap);
        }
        G();
      }
    }
  }
  
  private boolean G()
  {
    if ((QzoneConfig.getInstance().getConfig("qqstoryvideo", "jump_hyws_scheme_enable", 0) == 0) && (BaseApplicationImpl.getContext() != null))
    {
      ThreadManager.getUIHandler().post(new JumpAction.4(this));
      return false;
    }
    if ((((stg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean) && (!"open".equals(this.c)) && (!"openTag".equals(this.c)) && (!"openSquare".equals(this.c)) && (!"publish".equals(this.c))) {
      return bu();
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page");
    String str1 = str2;
    if (String.valueOf(2).equals(str2))
    {
      stg localstg = (stg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252);
      str1 = str2;
      if (localstg != null)
      {
        str1 = str2;
        if (!localstg.jdField_a_of_type_Boolean)
        {
          str1 = String.valueOf(0);
          this.jdField_a_of_type_JavaUtilHashMap.put("one_page", str1);
        }
      }
    }
    if ("0".equals(str1)) {
      return bx();
    }
    if ("open".equals(this.c)) {
      return bx();
    }
    return bu();
  }
  
  private boolean H()
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      if (TextUtils.isEmpty(amlh.a().h())) {}
      for (String str = "https://docs.qq.com/desktop/m/index.html?_from=1";; str = amlh.a().h())
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
  
  private boolean I()
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077F6", "0X80077F6", 0, 0, "", "", "", "");
    }
    do
    {
      return true;
      if ("10004".equals(str))
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077F7", "0X80077F7", 0, 0, "", "", "", "");
        return true;
      }
    } while (!"10009".equals(str));
    QLog.i("JumpAction", 1, "jumpaction from gotoConversaton e = ");
    return true;
  }
  
  private boolean J()
  {
    i2 = 0;
    if (this.c == null) {}
    do
    {
      return true;
      int i1 = MainFragment.jdField_a_of_type_Int;
      Object localObject;
      if (this.c.equals("open_conversation"))
      {
        i1 = MainFragment.jdField_b_of_type_Int;
        localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("third_open_conversation_sceneid");
      }
      try
      {
        long l1 = Long.parseLong((String)localObject);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5AF", "0X800A5AF", 0, 0, l1 + "", "", "", "");
        i2 = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("JumpAction", 1, "sceneid must be a numeric string");
          i2 = 1;
        }
      }
    } while (i2 == 0);
    localObject = new Intent();
    ((Intent)localObject).setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    ((Intent)localObject).setFlags(67108864);
    ((Intent)localObject).putExtra("tab_index", i1);
    ((Intent)localObject).putExtra("fragment_id", i2);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean K()
  {
    i2 = 0;
    if (this.c == null) {}
    do
    {
      return true;
      int i1 = MainFragment.jdField_a_of_type_Int;
      Object localObject;
      if (this.c.equals("forward_msg_list"))
      {
        i1 = MainFragment.jdField_b_of_type_Int;
        localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("third_open_conversation_sceneid");
      }
      try
      {
        long l1 = Long.parseLong((String)localObject);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5AF", "0X800A5AF", 0, 0, l1 + "", "", "", "");
        i2 = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("JumpAction", 1, "sceneid must be a numeric string");
          i2 = 1;
        }
      }
    } while (i2 == 0);
    localObject = new Intent();
    ((Intent)localObject).setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    ((Intent)localObject).setFlags(67108864);
    ((Intent)localObject).putExtra("tab_index", i1);
    ((Intent)localObject).putExtra("fragment_id", i2);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean L()
  {
    long l4 = System.currentTimeMillis();
    boolean bool2 = akiq.a().a();
    akiu localakiu = (akiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(220);
    Object localObject1;
    if (localakiu != null)
    {
      localObject1 = localakiu.a();
      QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is config info is " + localObject1);
      if (!localakiu.b()) {}
    }
    label135:
    label777:
    label803:
    label1202:
    for (boolean bool1 = true;; bool1 = false)
    {
      String str;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      }
      label588:
      label851:
      for (;;)
      {
        Object localObject2;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("args"))
        {
          localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("args");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("disablecloud")) {
            break label515;
          }
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("disablecloud");
        }
        label622:
        label879:
        try
        {
          for (;;)
          {
            i1 = Integer.parseInt((String)localObject2);
            if ((i1 == 1) || (i1 == 0)) {
              break label1401;
            }
            i1 = 1;
            QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is " + bool2 + ",effectinfo is " + bool1 + ",from url is " + str + ",args is" + (String)localObject1 + ",cloudSwitch is " + i1);
            if ((!bool2) || (!bool1)) {
              break label1202;
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
              break label622;
            }
            localObject2 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
            for (localObject1 = "";; localObject1 = (String)localObject1 + (String)((Map.Entry)localObject4).getKey() + "[" + ((String)((Map.Entry)localObject4).getValue()).substring(0, 20) + "]\n")
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label588;
              }
              localObject4 = (Map.Entry)((Iterator)localObject2).next();
              if ((((Map.Entry)localObject4).getValue() == null) || (((String)((Map.Entry)localObject4).getValue()).length() <= 20)) {
                break;
              }
            }
            str = "";
            break;
            localObject1 = "";
            break label135;
            localObject2 = "0";
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label757:
          label1401:
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
                    break label1149;
                  }
                  localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enableQR");
                }
                label1149:
                try
                {
                  l3 = Long.valueOf((String)localObject3).longValue();
                  if (l3 != 0L) {
                    break label1157;
                  }
                  bool1 = true;
                }
                catch (Exception localException3)
                {
                  label1021:
                  break label777;
                }
                ((Bundle)localObject4).putLong("PromotionType", l1);
                ((Bundle)localObject4).putLong("RecoglizeMask", l2);
                if (i1 != 0)
                {
                  bool2 = true;
                  ((Bundle)localObject4).putBoolean("disablecloud", bool2);
                  ((Bundle)localObject4).putString("H5Source", (String)localObject1);
                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("version")) {
                    break label1169;
                  }
                  localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
                  ((Bundle)localObject4).putString("version", (String)localObject1);
                  ((Bundle)localObject4).putBoolean("enableQR", bool1);
                  if (l1 == 0L) {
                    break label1177;
                  }
                  i1 = 1;
                  if ((i1 != 0) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("PromotionDescription"))) {
                    ((Bundle)localObject4).putString("PromotionDescription", (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionDescription"));
                  }
                  ((Bundle)localObject4).putBoolean("is_from_h5_entry", true);
                  localIntent.putExtra("web_invoke_params", (Bundle)localObject4);
                  AudioHelper.a("JumpAction", (Bundle)localObject4);
                  QLog.w("JumpAction", 1, "PromotionInfo test , \n" + ((Bundle)localObject4).toString() + "]");
                  if (localakiu != null)
                  {
                    if ((localakiu.a() != null) && (!TextUtils.isEmpty(localakiu.a().jdField_e_of_type_JavaLangString))) {
                      break label1182;
                    }
                    localIntent.putExtra("icon_text", "QQ-AR");
                    if ((localakiu.a() != null) && (localakiu.a().c != null)) {
                      localIntent.putExtra("icon_url", localakiu.a().c);
                    }
                  }
                  this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
                  awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "0", str, "", "");
                }
                for (;;)
                {
                  QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity cost time is " + (System.currentTimeMillis() - l4));
                  return true;
                  localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("H5Source");
                  break;
                  localObject3 = "0";
                  break label757;
                  bool1 = false;
                  break label777;
                  bool2 = false;
                  break label803;
                  localObject1 = "0";
                  break label851;
                  i1 = 0;
                  break label879;
                  localIntent.putExtra("icon_text", localakiu.a().jdField_e_of_type_JavaLangString);
                  break label1021;
                  localObject3 = new StringBuilder("https://ti.qq.com/ar/help/error.html?_wv=3");
                  ((StringBuilder)localObject3).append("&from=");
                  ((StringBuilder)localObject3).append(str);
                  ((StringBuilder)localObject3).append("&args=");
                  new StringBuffer();
                  ((StringBuilder)localObject3).append(adfw.a((String)localObject1));
                  QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity QQBrowserActivity cost time is " + ((StringBuilder)localObject3).toString());
                  localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                  ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
                  ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject3).toString());
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                  awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "1", str, "", "");
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
  
  private boolean M()
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
          if ("interesttag_selector".equals(this.c))
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
  
  private boolean N()
  {
    if (QLog.isColorLevel()) {
      asfl.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
          break label759;
        }
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
          break label766;
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
              break label792;
            }
            str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time")) {
              break label799;
            }
            str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
              break label806;
            }
            str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_xingzuo")) {
              break label813;
            }
            str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_xingzuo");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_interest")) {
              break label820;
            }
            str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_interest");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
              break label827;
            }
            str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
              break label834;
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
                        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007244", "0X8007244", 0, 0, "", "", "", "");
                      }
                      return true;
                      str2 = "";
                      break;
                      str4 = "";
                      break label107;
                      label759:
                      str5 = "";
                      break label135;
                      label766:
                      str1 = "";
                      break label163;
                      localException1 = localException1;
                      localException1.printStackTrace();
                      int i1 = 0;
                      continue;
                      String str3 = "";
                      continue;
                      label792:
                      str4 = "";
                      continue;
                      label799:
                      str5 = "";
                      continue;
                      label806:
                      String str6 = "";
                      continue;
                      label813:
                      String str7 = "";
                      continue;
                      label820:
                      String str8 = "";
                      continue;
                      label827:
                      String str9 = "";
                      continue;
                      label834:
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
  
  private boolean O()
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
  
  private boolean P()
  {
    HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, false);
    return true;
  }
  
  private boolean Q()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hotnamecode")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hotnamecode"); TextUtils.isEmpty(str); str = "")
    {
      bbmy.a(BaseApplicationImpl.getContext(), ajjy.a(2131640110), 1).a();
      return false;
    }
    NearbyTransitActivity.a(this.jdField_a_of_type_AndroidContentContext, str, 1, this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  /* Error */
  private boolean R()
  {
    // Byte code:
    //   0: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +19 -> 22
    //   6: ldc_w 435
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 791
    //   18: aastore
    //   19: invokestatic 701	asfl:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   26: ldc_w 793
    //   29: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +224 -> 256
    //   35: aload_0
    //   36: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   39: ldc_w 793
    //   42: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 50	java/lang/String
    //   48: invokestatic 797	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   51: istore_2
    //   52: aload_0
    //   53: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   56: ldc_w 416
    //   59: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   62: ifeq +189 -> 251
    //   65: aload_0
    //   66: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   69: ldc_w 416
    //   72: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast 50	java/lang/String
    //   78: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   81: istore_1
    //   82: new 106	android/content/Intent
    //   85: dup
    //   86: aload_0
    //   87: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   90: ldc_w 397
    //   93: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   96: astore_3
    //   97: aload_3
    //   98: ldc_w 414
    //   101: iconst_1
    //   102: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   105: pop
    //   106: aload_3
    //   107: ldc_w 408
    //   110: getstatic 412	com/tencent/mobileqq/activity/MainFragment:jdField_b_of_type_Int	I
    //   113: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   116: pop
    //   117: aload_3
    //   118: ldc_w 402
    //   121: invokevirtual 406	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   124: pop
    //   125: aload_0
    //   126: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   129: ldc_w 416
    //   132: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   135: ifeq +12 -> 147
    //   138: aload_3
    //   139: ldc_w 416
    //   142: iload_1
    //   143: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   146: pop
    //   147: aload_0
    //   148: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   151: ldc_w 793
    //   154: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   157: ifeq +12 -> 169
    //   160: aload_3
    //   161: ldc_w 793
    //   164: iload_2
    //   165: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   168: pop
    //   169: aload_0
    //   170: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   173: instanceof 397
    //   176: ifeq +41 -> 217
    //   179: aload_0
    //   180: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   183: checkcast 397	com/tencent/mobileqq/activity/SplashActivity
    //   186: astore 4
    //   188: aload_3
    //   189: ldc_w 799
    //   192: iconst_1
    //   193: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   196: pop
    //   197: aload 4
    //   199: aload_3
    //   200: invokevirtual 801	com/tencent/mobileqq/activity/SplashActivity:b	(Landroid/content/Intent;)V
    //   203: iconst_1
    //   204: ireturn
    //   205: astore_3
    //   206: iconst_0
    //   207: istore_2
    //   208: aload_3
    //   209: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   212: iconst_0
    //   213: istore_1
    //   214: goto -132 -> 82
    //   217: aload_0
    //   218: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   221: aload_3
    //   222: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   225: aload_0
    //   226: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   229: instanceof 745
    //   232: ifeq -29 -> 203
    //   235: aload_0
    //   236: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   239: checkcast 745	android/app/Activity
    //   242: invokevirtual 804	android/app/Activity:finish	()V
    //   245: iconst_1
    //   246: ireturn
    //   247: astore_3
    //   248: goto -40 -> 208
    //   251: iconst_0
    //   252: istore_1
    //   253: goto -171 -> 82
    //   256: iconst_0
    //   257: istore_2
    //   258: goto -206 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	bacn
    //   81	172	1	i1	int
    //   51	207	2	bool	boolean
    //   96	104	3	localIntent	Intent
    //   205	17	3	localException1	Exception
    //   247	1	3	localException2	Exception
    //   186	12	4	localSplashActivity	SplashActivity
    // Exception table:
    //   from	to	target	type
    //   22	52	205	java/lang/Exception
    //   52	82	247	java/lang/Exception
  }
  
  private boolean S()
  {
    return true;
  }
  
  private boolean T()
  {
    return true;
  }
  
  private boolean U()
  {
    return true;
  }
  
  private boolean V()
  {
    Intent localIntent2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
    String str = localIntent2.getStringExtra("uin");
    Intent localIntent1;
    long l2;
    long l1;
    if (azzz.b(str))
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
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, "chatimg", l1);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "gotoSetAvator path:" + str + "msg uniseq:" + l1);
      }
      int i1 = Math.min(482, azyk.a((Activity)this.jdField_a_of_type_AndroidContentContext));
      localIntent1.putExtra("Business_Origin", 100);
      localIntent1.putExtra("open_chatfragment", true);
      localIntent1.putExtra("open_chat_from_avator", true);
      PhotoUtils.a(localIntent1, (Activity)this.jdField_a_of_type_AndroidContentContext, SplashActivity.class.getName(), i1, i1, 1080, 1080, str, azyk.a());
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800723E", "0X800723E", 0, 0, "", "", "", "");
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
  
  private boolean W()
  {
    String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    String str3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("set_uri_list"));
    String str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    ArrayList localArrayList = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getParcelableArrayListExtra("android.intent.extra.STREAM");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, FavEmosmManageActivity.class);
    localIntent.addFlags(335544320);
    localIntent.putExtra("key_from_sdk_set_emotion", true);
    localIntent.putParcelableArrayListExtra("key_from_sdk_set_emotion_uri", localArrayList);
    localIntent.putExtra("pkg_name", this.n);
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
  
  private boolean X()
  {
    String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    String str3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("set_path"));
    String str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("key_request_code", 0);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_from_sdk_set_avatar", true);
    localBundle.putString("key_from_sdk_set_avatar_path", str4);
    localBundle.putString("pkg_name", this.n);
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
  
  private boolean Y()
  {
    String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    String str3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_path"));
    String str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, new Object[] { "[gotoSDKSetDynamicAvatar] appName=", str1 });
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DF9", "0X8009DF9", 0, 0, str2, "", "", "");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SelectCoverActivity.class);
    localIntent.putExtra("param_source", 3);
    localIntent.putExtra("param_from_newer_guide", false);
    localIntent.putExtra("key_video_file_path", str4);
    localIntent.putExtra("pkg_name", this.n);
    localIntent.putExtra("app_name", str1);
    localIntent.putExtra("share_id", str2);
    localIntent.putExtra("open_id", str3);
    localIntent.putExtra("sdk_version", str5);
    localIntent.addFlags(335544320);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean Z()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, RecommendFriendActivity.class);
    localIntent.putExtra("EntranceId", 7);
    localIntent.putExtra("from_babyq", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007243", "0X8007243", 0, 0, "", "", "", "");
    return true;
  }
  
  private int a()
  {
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("env"))) {
      return Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("env")).intValue();
    }
    return 0;
  }
  
  public static int a(Map<String, String> paramMap)
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
        break label60;
      }
      QLog.e("JumpAction", 2, "makeStoryContentPageIntent, NumberFormatException, shareFromStr:" + paramMap);
    }
    return 0;
    label60:
    return 0;
  }
  
  public static int a(Map<String, String> paramMap, String paramString, int paramInt)
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
          if ("activity.RegisterChooseLoginActivity".equals(localObject)) {
            return RegisterChooseLoginActivity.class;
          }
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
  
  public static String a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(baaw.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
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
            ((bcqv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str1, paramInt1, paramInt2);
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
    if ((paramIntent == null) || (TextUtils.isEmpty(this.q)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("JumpAction", 2, "wrapper Intent failed intent is null or redTouchInfo is Empty");
      }
      return;
    }
    paramIntent.putExtra("redTouch", this.q);
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
        break label239;
      }
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "params must be decrypted");
        }
        paramString = baaw.decode(new Cryptor().decrypt(bach.a(paramString), "Hf7K(s*js12LiskW".getBytes()), 0);
        if (paramString == null) {
          break label293;
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
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), "0X8004B50", "0X8004B50", 0, 0, "", "", "", "");
          }
        }
        return;
      }
      catch (JSONException paramIntent)
      {
        label239:
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
      label293:
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
  
  private void a(String paramString, long paramLong, Bundle paramBundle)
  {
    if (((aply)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a().a(paramLong))
    {
      QLog.d("JumpAction", 1, "checkAppInfo use cache");
      paramBundle.putBoolean("use_d55_cache", true);
      return;
    }
    apih.a(paramString, paramLong, this.n);
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
  
  public static boolean a(Context paramContext, String paramString, Long paramLong)
  {
    paramContext = amay.b(250).a();
    if ((paramContext != null) && (paramContext.a() != null))
    {
      paramContext = paramContext.a().jdField_a_of_type_JavaUtilHashMap;
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        if ((paramContext.containsKey(paramLong.toString())) && (paramContext.containsValue(paramString))) {
          return (!TextUtils.isEmpty(paramLong.toString())) && (((String)paramContext.get(paramLong.toString())).equals(paramString));
        }
        return false;
      }
      ArkAppCenter.c("JumpAction", "getArkShareConfig,ark_ai_keyword_sdk_share_app_info is empty");
      return false;
    }
    ArkAppCenter.c("JumpAction", String.format("getArkShareConfig, confBean.getConfig is null", new Object[0]));
    return false;
  }
  
  /* Error */
  private boolean a(Intent paramIntent, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ldc_w 1272
    //   7: invokevirtual 1275	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   10: ifne +14 -> 24
    //   13: aload_1
    //   14: ldc_w 1272
    //   17: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   20: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   23: pop
    //   24: ldc_w 1277
    //   27: aload_0
    //   28: getfield 1279	bacn:m	Ljava/lang/String;
    //   31: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +467 -> 501
    //   37: iconst_1
    //   38: istore 8
    //   40: aload_1
    //   41: ldc_w 1281
    //   44: iload 8
    //   46: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   49: pop
    //   50: aload_0
    //   51: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   54: ifnull +346 -> 400
    //   57: aload_0
    //   58: getfield 1285	bacn:jdField_h_of_type_Boolean	Z
    //   61: ifeq +339 -> 400
    //   64: aload_0
    //   65: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   68: getfield 1291	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   71: invokevirtual 1295	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   74: sipush 769
    //   77: if_icmpne +323 -> 400
    //   80: aload_0
    //   81: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   84: getfield 1298	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   87: invokevirtual 1295	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   90: istore 6
    //   92: aload_0
    //   93: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   96: ldc_w 1300
    //   99: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 50	java/lang/String
    //   105: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: istore 4
    //   110: aload_0
    //   111: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: invokevirtual 1303	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   117: ldc_w 1305
    //   120: iconst_0
    //   121: invokevirtual 1309	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   124: astore 9
    //   126: aload 9
    //   128: new 197	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 1311
    //   138: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   148: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: iconst_0
    //   155: invokeinterface 1316 3 0
    //   160: istore 7
    //   162: aload 9
    //   164: invokeinterface 1320 1 0
    //   169: new 197	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 1311
    //   179: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   186: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   189: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: iconst_0
    //   196: invokeinterface 1326 3 0
    //   201: invokeinterface 1329 1 0
    //   206: pop
    //   207: aload_0
    //   208: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   211: getfield 1333	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   214: invokevirtual 1337	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   217: ifeq +310 -> 527
    //   220: new 152	org/json/JSONObject
    //   223: dup
    //   224: aload_0
    //   225: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   228: getfield 1333	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   231: invokevirtual 1339	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   234: invokespecial 164	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   237: astore 9
    //   239: aload_0
    //   240: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   243: getfield 1343	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   246: invokevirtual 1346	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   249: ifeq +278 -> 527
    //   252: aload_0
    //   253: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   256: getfield 1343	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   259: invokevirtual 1347	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   262: ifne +265 -> 527
    //   265: ldc_w 372
    //   268: aload 9
    //   270: ldc_w 1349
    //   273: invokevirtual 1353	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   276: aload_0
    //   277: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   280: getfield 1343	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   283: iconst_0
    //   284: invokevirtual 1354	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   287: checkcast 50	java/lang/String
    //   290: invokevirtual 1353	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   293: ldc_w 1356
    //   296: invokevirtual 1146	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   299: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: istore 8
    //   304: iload 8
    //   306: ifeq +221 -> 527
    //   309: aload_1
    //   310: ldc_w 1358
    //   313: iload 5
    //   315: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   318: pop
    //   319: aload_1
    //   320: ldc_w 1360
    //   323: iload 6
    //   325: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   328: pop
    //   329: aload_1
    //   330: ldc_w 1362
    //   333: iload 7
    //   335: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   338: pop
    //   339: aload_1
    //   340: ldc_w 1364
    //   343: iload 4
    //   345: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   348: pop
    //   349: aload_0
    //   350: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   353: getfield 1343	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   356: invokevirtual 1346	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   359: ifeq +41 -> 400
    //   362: aload_0
    //   363: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   366: getfield 1343	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   369: invokevirtual 1347	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   372: ifne +28 -> 400
    //   375: aload_1
    //   376: ldc_w 1366
    //   379: new 1025	java/util/ArrayList
    //   382: dup
    //   383: aload_0
    //   384: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   387: getfield 1343	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   390: invokevirtual 1369	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   393: invokespecial 1372	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   396: invokevirtual 1375	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   399: pop
    //   400: aload_1
    //   401: ldc_w 1377
    //   404: aload_0
    //   405: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   408: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   411: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   414: pop
    //   415: aload_1
    //   416: ldc_w 1379
    //   419: iconst_1
    //   420: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   423: pop
    //   424: aload_1
    //   425: ldc_w 1381
    //   428: iconst_1
    //   429: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   432: pop
    //   433: aload_1
    //   434: ldc_w 1383
    //   437: aload_0
    //   438: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   441: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   444: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   447: pop
    //   448: aload_1
    //   449: ldc_w 1385
    //   452: ldc_w 1387
    //   455: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   458: pop
    //   459: aload_0
    //   460: aload_1
    //   461: invokespecial 1389	bacn:a	(Landroid/content/Intent;)V
    //   464: aload_1
    //   465: aload_0
    //   466: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   469: aload_2
    //   470: invokevirtual 1392	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   473: pop
    //   474: aload_0
    //   475: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   478: aload_1
    //   479: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   482: ldc_w 1394
    //   485: aload_3
    //   486: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   489: ifne +44 -> 533
    //   492: aload_0
    //   493: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   496: invokestatic 1400	cooperation/qwallet/plugin/QWalletHelper:preloadQWallet	(Lcom/tencent/common/app/AppInterface;)V
    //   499: iconst_1
    //   500: ireturn
    //   501: iconst_0
    //   502: istore 8
    //   504: goto -464 -> 40
    //   507: astore 9
    //   509: aload 9
    //   511: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   514: iconst_0
    //   515: istore 4
    //   517: goto -407 -> 110
    //   520: astore 9
    //   522: aload 9
    //   524: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   527: iconst_1
    //   528: istore 5
    //   530: goto -221 -> 309
    //   533: new 1402	com/tencent/mobileqq/utils/JumpAction$17
    //   536: dup
    //   537: aload_0
    //   538: invokespecial 1403	com/tencent/mobileqq/utils/JumpAction$17:<init>	(Lbacn;)V
    //   541: iconst_5
    //   542: aconst_null
    //   543: iconst_1
    //   544: invokestatic 1406	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   547: iconst_1
    //   548: ireturn
    //   549: astore_1
    //   550: iconst_1
    //   551: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	bacn
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
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
        skt.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), str2);
      } else {
        skt.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), Long.valueOf(paramQQAppInterface).longValue());
      }
    }
    catch (Exception paramQQAppInterface)
    {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str5 = (String)paramHashMap.get("videoOwnerUin");
    String str6 = (String)paramHashMap.get("unionid");
    String str4 = (String)paramHashMap.get("fromId");
    String str2 = (String)paramHashMap.get("videoId");
    String str1 = (String)paramHashMap.get("type");
    str1 = (String)paramHashMap.get("videoList");
    int i1 = a(paramHashMap);
    str1 = (String)paramHashMap.get("feedid");
    int i3 = a(paramHashMap, "ptype", 0);
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
          tij.b(paramActivity, str2, paramQQAppInterface, i2);
          return true;
          i2 = 1;
          break;
        case 1: 
          if ("17".equals(str3)) {
            urp.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = str1;
          if (str1 == null) {
            paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
          }
          i2 = i1;
          if (i1 == 0) {
            i2 = 7;
          }
          tij.b(paramActivity, str2, paramQQAppInterface, i2);
          return true;
        case 2: 
          if ("17".equals(str3)) {
            urp.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = (String)paramHashMap.get("et");
          paramQQAppInterface = (String)paramHashMap.get("time_zone");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            Integer.valueOf(paramQQAppInterface).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            tij.a(paramActivity, str6, str1, 1, 109, 1, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            tij.a(paramActivity, str5, str1, 1, 109, 1, null);
          }
          return false;
        case 3: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 30;
          }
          tij.a(paramActivity, str2, str1, i2);
          return true;
        case 4: 
          paramQQAppInterface = (String)paramHashMap.get("collection_id");
          paramHashMap = (String)paramHashMap.get("time_zone");
          i3 = -1;
          if (!TextUtils.isEmpty(paramHashMap)) {
            i3 = Integer.valueOf(paramHashMap).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            tij.a(paramActivity, str6, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str6), i3, i1, str1, i2, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            tij.a(paramActivity, str5, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str5), i3, i1, str1, i2, null);
          }
          return false;
        case 7: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 19;
          }
          tij.b(paramActivity, str2, str1, i2);
          return true;
        case 6: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 57;
          }
          tij.b(paramActivity, str2, str1, i2);
          return true;
        case 5: 
          tij.a(paramActivity, str6, str1, i2, i1, 0, null);
          return true;
        case 8: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 90;
          }
          tij.b(paramActivity, str2, str1, i2);
          return true;
        case 9: 
          a(paramHashMap, "time_zone", -1);
          i2 = i1;
          if (i1 == 0) {
            i2 = 96;
          }
          tij.a(paramActivity, str1, i2);
          return true;
        case 10: 
          paramQQAppInterface = (String)paramHashMap.get("bannerID");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            tij.a(paramActivity, new OpenPlayerBuilder(new DiscoverBannerPlayInfo(paramQQAppInterface), 102).a());
          }
          return true;
        case 0: 
          return b(paramQQAppInterface, paramActivity, paramHashMap, paramString);
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("[0-9]+").matcher(paramString).matches();
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
  
  private boolean a(Map<String, String> paramMap, boolean paramBoolean)
  {
    String str1 = (String)paramMap.get("userid");
    String str2 = (String)paramMap.get("usertype");
    String str3 = (String)paramMap.get("unionid");
    String str4 = (String)paramMap.get("storyid");
    String str5 = (String)paramMap.get("showinfocard");
    a(paramMap);
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
          skt.a(this.jdField_a_of_type_AndroidContentContext, 23, str3);
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
  
  private boolean aA()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (Boolean.parseBoolean((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_add_friend"))) {
      return c((String)localObject1);
    }
    Object localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("wpa");
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    boolean bool1 = "1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("track_back"));
    boolean bool2 = "1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("singleTop"));
    if ("internal_phone".equals(localObject3))
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007014", "0X8007014", 0, 0, "", "", "", "");
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 53);
      ((ProfileActivity.AllInOne)localObject1).k = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname"));
      ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 105;
      localObject2 = new Bundle();
      localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!a((String)localObject3))) {
        break label682;
      }
    }
    label682:
    for (int i1 = Integer.valueOf((String)localObject3).intValue();; i1 = 0)
    {
      if ((i1 > 0) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msg_uniseq")))
      {
        localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("msg_uniseq");
        if ((i1 == 100) && (azzz.b((String)localObject3)))
        {
          ((Bundle)localObject2).putBoolean("from_babyq", true);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007241", "0X8007241", 0, 0, "", "", "", "");
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
      localObject3 = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e((String)localObject1);
      if ((localObject3 != null) && (((Friends)localObject3).isFriend()))
      {
        localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
        ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = ((Friends)localObject3).name;
        ((ProfileActivity.AllInOne)localObject1).jdField_i_of_type_JavaLangString = ((Friends)localObject3).remark;
        break;
      }
      if (this.jdField_f_of_type_Boolean)
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
  
  private boolean aB()
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
          break label181;
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
      label181:
      do
      {
        return bool;
      } while (str.length() < 5);
      if (((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(str)) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
  
  private boolean aC()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject1 == null) {
        break label272;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label272;
      }
    }
    label272:
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
      localObject2 = new bgno(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
  
  private boolean aD()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject1 == null) {
        break label309;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label309;
      }
    }
    label309:
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
      ((Intent)localObject1).putExtra("key_is_update_before_805", azlj.a(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new bgno(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
  
  private boolean aE()
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
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bcqu);
              ((bcqv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str2);
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
        if ("h5".equalsIgnoreCase((String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from"))) {
          localObject1 = TroopInfoActivity.a(str2, 22);
        }
        try
        {
          int i2 = Integer.parseInt(str1);
          i1 = i2;
          if (i2 == 43) {
            i1 = 10002;
          }
          ((Bundle)localObject1).putInt("troop_info_from_ex", i1);
          if (i1 != 33) {
            break label677;
          }
          ((Bundle)localObject1).putInt("troop_info_from", 24);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int i1;
            Object localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("JumpAction", 2, "cast source sub id from web error, sourceSubId = " + str1);
              continue;
              if (i1 == 37) {
                ((Bundle)localObject2).putInt("troop_info_from", 30);
              } else if (i1 == 10008) {
                ((Bundle)localObject2).putInt("troop_info_from", 102);
              } else if (i1 == 10013) {
                ((Bundle)localObject2).putInt("troop_info_from", 106);
              }
            }
          }
        }
        if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"))) && (Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type")) == 100))
        {
          ((Bundle)localObject1).putBoolean("from_babyq", true);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007245", "0X8007245", 0, 0, "", "", "", "");
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
        azlj.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, 2);
        return true;
        localObject1 = TroopInfoActivity.a(str2, 5);
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
          label677:
          if (i1 != 43) {
            break;
          }
          ((Bundle)localObject2).putInt("troop_info_from", 27);
        }
      }
    }
  }
  
  private boolean aF()
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
      ((Bundle)localObject).putString("openid", a(jdField_j_of_type_JavaLangString));
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
    azlj.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject, 2);
    return true;
  }
  
  /* Error */
  private boolean aG()
  {
    // Byte code:
    //   0: ldc 61
    //   2: astore 14
    //   4: ldc 61
    //   6: astore 19
    //   8: ldc 61
    //   10: astore 17
    //   12: ldc 61
    //   14: astore 10
    //   16: ldc 61
    //   18: astore 18
    //   20: aload_0
    //   21: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: ldc_w 707
    //   27: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 50	java/lang/String
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   38: ldc_w 1819
    //   41: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 50	java/lang/String
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   52: ldc_w 653
    //   55: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: checkcast 50	java/lang/String
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   66: ldc_w 1821
    //   69: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 50	java/lang/String
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
    //   114: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   117: ldc_w 1823
    //   120: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast 50	java/lang/String
    //   126: ldc_w 1825
    //   129: invokestatic 1827	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   175: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   178: ldc_w 1829
    //   181: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: checkcast 50	java/lang/String
    //   187: ldc_w 1825
    //   190: invokestatic 1827	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   236: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   239: ldc_w 1831
    //   242: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   245: checkcast 50	java/lang/String
    //   248: ldc_w 1825
    //   251: invokestatic 1827	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   297: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   300: ldc_w 1833
    //   303: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast 50	java/lang/String
    //   309: ldc_w 1825
    //   312: invokestatic 1827	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   358: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   361: ldc_w 1835
    //   364: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   367: checkcast 50	java/lang/String
    //   370: ldc_w 1825
    //   373: invokestatic 1827	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   419: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   422: ldc_w 1837
    //   425: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   428: checkcast 50	java/lang/String
    //   431: ldc_w 1825
    //   434: invokestatic 1827	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   472: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   475: ifne +11 -> 486
    //   478: aload 7
    //   480: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifeq +129 -> 612
    //   486: iconst_0
    //   487: ireturn
    //   488: astore 9
    //   490: ldc 61
    //   492: astore 10
    //   494: ldc 61
    //   496: astore_1
    //   497: ldc 61
    //   499: astore_3
    //   500: ldc 61
    //   502: astore 6
    //   504: ldc 61
    //   506: astore 5
    //   508: ldc 61
    //   510: astore 4
    //   512: ldc 61
    //   514: astore 8
    //   516: ldc 61
    //   518: astore 7
    //   520: ldc 61
    //   522: astore_2
    //   523: aload 9
    //   525: invokevirtual 1085	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   528: aload 8
    //   530: astore 9
    //   532: aload 5
    //   534: astore 8
    //   536: aload_2
    //   537: astore 5
    //   539: aload_1
    //   540: astore_2
    //   541: ldc 61
    //   543: astore_1
    //   544: aload_3
    //   545: astore 11
    //   547: goto -77 -> 470
    //   550: astore 9
    //   552: ldc 61
    //   554: astore 10
    //   556: ldc 61
    //   558: astore_1
    //   559: ldc 61
    //   561: astore_3
    //   562: ldc 61
    //   564: astore 6
    //   566: ldc 61
    //   568: astore 5
    //   570: ldc 61
    //   572: astore 4
    //   574: ldc 61
    //   576: astore 8
    //   578: ldc 61
    //   580: astore 7
    //   582: ldc 61
    //   584: astore_2
    //   585: aload 9
    //   587: invokevirtual 1838	java/lang/NullPointerException:printStackTrace	()V
    //   590: aload 8
    //   592: astore 9
    //   594: aload 5
    //   596: astore 8
    //   598: aload_2
    //   599: astore 5
    //   601: aload_1
    //   602: astore_2
    //   603: ldc 61
    //   605: astore_1
    //   606: aload_3
    //   607: astore 11
    //   609: goto -139 -> 470
    //   612: aload_0
    //   613: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   616: ifnull +170 -> 786
    //   619: new 106	android/content/Intent
    //   622: dup
    //   623: aload_0
    //   624: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   627: ldc_w 1840
    //   630: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   633: astore_3
    //   634: aload_3
    //   635: ldc_w 1842
    //   638: aload 7
    //   640: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   643: pop
    //   644: aload_3
    //   645: ldc_w 1844
    //   648: new 197	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   655: ldc 61
    //   657: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload 6
    //   662: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   671: pop
    //   672: ldc_w 1846
    //   675: aload 10
    //   677: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   680: ifeq +138 -> 818
    //   683: aload_3
    //   684: ldc_w 1848
    //   687: iconst_0
    //   688: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   691: pop
    //   692: new 574	android/os/Bundle
    //   695: dup
    //   696: invokespecial 575	android/os/Bundle:<init>	()V
    //   699: astore 6
    //   701: aload 6
    //   703: ldc_w 1819
    //   706: aload 4
    //   708: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: aload 6
    //   713: ldc_w 1823
    //   716: aload 11
    //   718: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   721: aload 6
    //   723: ldc_w 1829
    //   726: aload 9
    //   728: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   731: aload 6
    //   733: ldc_w 1831
    //   736: aload 8
    //   738: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: aload 6
    //   743: ldc_w 1833
    //   746: aload 5
    //   748: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload 6
    //   753: ldc_w 1835
    //   756: aload_2
    //   757: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload 6
    //   762: ldc_w 1837
    //   765: aload_1
    //   766: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   769: aload_3
    //   770: ldc 142
    //   772: aload 6
    //   774: invokevirtual 612	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   777: pop
    //   778: aload_0
    //   779: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   782: aload_3
    //   783: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   786: aload_0
    //   787: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   790: ldc_w 1160
    //   793: ldc 61
    //   795: ldc 61
    //   797: ldc_w 1850
    //   800: ldc_w 1850
    //   803: iconst_0
    //   804: iconst_0
    //   805: ldc 61
    //   807: ldc 61
    //   809: ldc 61
    //   811: ldc 61
    //   813: invokestatic 427	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   816: iconst_1
    //   817: ireturn
    //   818: aload_3
    //   819: ldc_w 1848
    //   822: bipush 6
    //   824: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   827: pop
    //   828: goto -136 -> 692
    //   831: astore 9
    //   833: ldc 61
    //   835: astore_1
    //   836: ldc 61
    //   838: astore 4
    //   840: ldc 61
    //   842: astore 6
    //   844: ldc 61
    //   846: astore 5
    //   848: ldc 61
    //   850: astore 11
    //   852: ldc 61
    //   854: astore 8
    //   856: ldc 61
    //   858: astore 7
    //   860: ldc 61
    //   862: astore_2
    //   863: aload_3
    //   864: astore 10
    //   866: aload 4
    //   868: astore_3
    //   869: aload 11
    //   871: astore 4
    //   873: goto -288 -> 585
    //   876: astore 9
    //   878: ldc 61
    //   880: astore_2
    //   881: ldc 61
    //   883: astore 4
    //   885: ldc 61
    //   887: astore 8
    //   889: aload_1
    //   890: astore 7
    //   892: ldc 61
    //   894: astore_1
    //   895: ldc 61
    //   897: astore 11
    //   899: ldc 61
    //   901: astore 5
    //   903: ldc 61
    //   905: astore 6
    //   907: aload_3
    //   908: astore 10
    //   910: aload 11
    //   912: astore_3
    //   913: goto -328 -> 585
    //   916: astore 9
    //   918: ldc 61
    //   920: astore 5
    //   922: aload_2
    //   923: astore 6
    //   925: ldc 61
    //   927: astore_2
    //   928: ldc 61
    //   930: astore 4
    //   932: ldc 61
    //   934: astore 8
    //   936: aload_1
    //   937: astore 7
    //   939: ldc 61
    //   941: astore_1
    //   942: ldc 61
    //   944: astore 11
    //   946: aload_3
    //   947: astore 10
    //   949: aload 11
    //   951: astore_3
    //   952: goto -367 -> 585
    //   955: astore 10
    //   957: aload 15
    //   959: astore 8
    //   961: aload_1
    //   962: astore 9
    //   964: aload 12
    //   966: astore_1
    //   967: aload 11
    //   969: astore 6
    //   971: aload 10
    //   973: astore 11
    //   975: aload_2
    //   976: astore 12
    //   978: aload 7
    //   980: astore_2
    //   981: aload_3
    //   982: astore 10
    //   984: aload 6
    //   986: astore_3
    //   987: aload 12
    //   989: astore 6
    //   991: aload 9
    //   993: astore 7
    //   995: aload 11
    //   997: astore 9
    //   999: goto -414 -> 585
    //   1002: astore 9
    //   1004: ldc 61
    //   1006: astore_1
    //   1007: ldc 61
    //   1009: astore 4
    //   1011: ldc 61
    //   1013: astore 6
    //   1015: ldc 61
    //   1017: astore 5
    //   1019: ldc 61
    //   1021: astore 11
    //   1023: ldc 61
    //   1025: astore 8
    //   1027: ldc 61
    //   1029: astore 7
    //   1031: ldc 61
    //   1033: astore_2
    //   1034: aload_3
    //   1035: astore 10
    //   1037: aload 4
    //   1039: astore_3
    //   1040: aload 11
    //   1042: astore 4
    //   1044: goto -521 -> 523
    //   1047: astore 9
    //   1049: ldc 61
    //   1051: astore_2
    //   1052: ldc 61
    //   1054: astore 4
    //   1056: ldc 61
    //   1058: astore 8
    //   1060: aload_1
    //   1061: astore 7
    //   1063: ldc 61
    //   1065: astore_1
    //   1066: ldc 61
    //   1068: astore 11
    //   1070: ldc 61
    //   1072: astore 5
    //   1074: ldc 61
    //   1076: astore 6
    //   1078: aload_3
    //   1079: astore 10
    //   1081: aload 11
    //   1083: astore_3
    //   1084: goto -561 -> 523
    //   1087: astore 9
    //   1089: ldc 61
    //   1091: astore 5
    //   1093: aload_2
    //   1094: astore 6
    //   1096: ldc 61
    //   1098: astore_2
    //   1099: ldc 61
    //   1101: astore 4
    //   1103: ldc 61
    //   1105: astore 8
    //   1107: aload_1
    //   1108: astore 7
    //   1110: ldc 61
    //   1112: astore_1
    //   1113: ldc 61
    //   1115: astore 11
    //   1117: aload_3
    //   1118: astore 10
    //   1120: aload 11
    //   1122: astore_3
    //   1123: goto -600 -> 523
    //   1126: astore 9
    //   1128: aload_1
    //   1129: astore 7
    //   1131: aload 13
    //   1133: astore_1
    //   1134: aload_2
    //   1135: astore 11
    //   1137: aload 8
    //   1139: astore_2
    //   1140: aload 6
    //   1142: astore 5
    //   1144: aload_3
    //   1145: astore 10
    //   1147: aload 16
    //   1149: astore 8
    //   1151: aload 14
    //   1153: astore_3
    //   1154: aload 11
    //   1156: astore 6
    //   1158: goto -635 -> 523
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1161	0	this	bacn
    //   47	1087	1	localObject1	Object
    //   61	1079	2	localObject2	Object
    //   33	1121	3	localObject3	Object
    //   75	1027	4	localObject4	Object
    //   87	1056	5	localObject5	Object
    //   107	1050	6	localObject6	Object
    //   83	1047	7	localObject7	Object
    //   103	1047	8	localObject8	Object
    //   132	334	9	str1	String
    //   488	36	9	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   530	1	9	localObject9	Object
    //   550	36	9	localNullPointerException1	java.lang.NullPointerException
    //   592	135	9	localObject10	Object
    //   831	1	9	localNullPointerException2	java.lang.NullPointerException
    //   876	1	9	localNullPointerException3	java.lang.NullPointerException
    //   916	1	9	localNullPointerException4	java.lang.NullPointerException
    //   962	36	9	localObject11	Object
    //   1002	1	9	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   1047	1	9	localUnsupportedEncodingException3	UnsupportedEncodingException
    //   1087	1	9	localUnsupportedEncodingException4	UnsupportedEncodingException
    //   1126	1	9	localUnsupportedEncodingException5	UnsupportedEncodingException
    //   14	934	10	localObject12	Object
    //   955	17	10	localNullPointerException5	java.lang.NullPointerException
    //   982	164	10	localObject13	Object
    //   95	1060	11	localObject14	Object
    //   79	909	12	localObject15	Object
    //   99	1033	13	str2	String
    //   2	1150	14	localObject16	Object
    //   91	867	15	str3	String
    //   111	1037	16	str4	String
    //   10	436	17	str5	String
    //   18	435	18	str6	String
    //   6	458	19	str7	String
    //   437	6	20	str8	String
    // Exception table:
    //   from	to	target	type
    //   20	34	488	java/io/UnsupportedEncodingException
    //   20	34	550	java/lang/NullPointerException
    //   34	48	831	java/lang/NullPointerException
    //   48	62	876	java/lang/NullPointerException
    //   62	77	916	java/lang/NullPointerException
    //   113	134	955	java/lang/NullPointerException
    //   174	195	955	java/lang/NullPointerException
    //   235	256	955	java/lang/NullPointerException
    //   296	317	955	java/lang/NullPointerException
    //   357	378	955	java/lang/NullPointerException
    //   418	439	955	java/lang/NullPointerException
    //   34	48	1002	java/io/UnsupportedEncodingException
    //   48	62	1047	java/io/UnsupportedEncodingException
    //   62	77	1087	java/io/UnsupportedEncodingException
    //   113	134	1126	java/io/UnsupportedEncodingException
    //   174	195	1126	java/io/UnsupportedEncodingException
    //   235	256	1126	java/io/UnsupportedEncodingException
    //   296	317	1126	java/io/UnsupportedEncodingException
    //   357	378	1126	java/io/UnsupportedEncodingException
    //   418	439	1126	java/io/UnsupportedEncodingException
  }
  
  private boolean aH()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("troopuin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      return false;
    }
    atxx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str1, str2, 9, -1);
    return true;
  }
  
  private boolean aI()
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
  
  private boolean aJ()
  {
    if ("webview".equals(this.m))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bus_type");
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "photo").putExtra("doCallBack", true).putExtra("src_type", this.jdField_f_of_type_JavaLangString).putExtra("callback_type", this.jdField_g_of_type_JavaLangString).putExtra("callback_name", this.jdField_h_of_type_JavaLangString));
    }
    return true;
  }
  
  private boolean aK()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label110:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label110;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localBundle.putString("pkg_name", this.n);
    localBundle.putString("pkg_sig", this.o);
    localBundle.putInt("action", 3);
    localIntent.putExtra("key_params", localBundle);
    abju.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
    return true;
  }
  
  private boolean aL()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label110:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label110;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localBundle.putString("pkg_name", this.n);
    localBundle.putString("pkg_sig", this.o);
    localBundle.putInt("action", 1);
    localIntent.putExtra("key_params", localBundle);
    abju.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
    return true;
  }
  
  private boolean aM()
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
      for (String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label163;
        }
        localBundle.putString(str2, str1);
        break;
      }
    }
    localBundle.putString("pkg_name", this.n);
    localIntent.putExtra("key_params", localBundle);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean aN()
  {
    System.currentTimeMillis();
    Object localObject3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if ((localObject3 == null) || ((!((String)localObject3).startsWith("http://")) && (!((String)localObject3).startsWith("https://"))) || ((!mpw.b((String)localObject3).equalsIgnoreCase("qq.com")) && (!mpw.b((String)localObject3).equalsIgnoreCase("myun.tenpay.com")) && (!mpw.b((String)localObject3).equalsIgnoreCase("tenpay.com")) && (!mpw.b((String)localObject3).equalsIgnoreCase("wanggou.com")) && (!mpw.b((String)localObject3).equalsIgnoreCase("tencent.com")) && (!mpw.b((String)localObject3).equalsIgnoreCase("jd.com")) && (!mpw.b((String)localObject3).equalsIgnoreCase("qcloud.com")) && (!mpw.b((String)localObject3).equalsIgnoreCase("webank.com")) && (!mpw.b((String)localObject3).equalsIgnoreCase("qqumall.com")))) {
      return false;
    }
    if ((((String)localObject3).startsWith("https://jiazhang.qq.com/wap/com/")) || (((String)localObject3).startsWith("https://test.jiazhang.qq.com/wap/com/")))
    {
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))))
      {
        QLog.e("JumpAction", 1, "empty params");
        return false;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"), "");
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("style");
    String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
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
        break label2273;
      }
      localStringBuffer.append("plg_auth=1");
      localStringBuffer.append("&");
    }
    label2129:
    label2273:
    for (int i1 = 1;; i1 = 0)
    {
      if ("1".equals(str3))
      {
        localStringBuffer.append("plg_dev=1");
        localStringBuffer.append("&");
        localStringBuffer.append("MOBINFO=");
        localStringBuffer.append(bach.a(((Cryptor)localObject3).encrypt(b().getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      if ("1".equals(str4))
      {
        localStringBuffer.append("plg_usr=1");
        localStringBuffer.append("&");
        localStringBuffer.append("USER=");
        localStringBuffer.append(bach.a(((Cryptor)localObject3).encrypt(ajjy.a(2131640120).getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      int i2 = i1;
      if ("1".equals(str5))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        i2 = i1;
        if (localObject3 != null)
        {
          localStringBuffer.append("plg_vkey=1").append("&mqqvkey=").append((String)localObject3).append("&");
          i2 = 1;
        }
      }
      if ((this.p != null) && (this.p.length() > 0)) {
        localStringBuffer.append(this.p + "&");
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
        localObject1 = befm.b(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
        if (!TextUtils.isEmpty((String)((Map)localObject1).get("storysharefrom")))
        {
          this.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject1);
          if (this.jdField_a_of_type_JavaUtilHashMap.get("type") == null) {
            this.c = "opencontent";
          }
          for (;;)
          {
            return F();
            switch (Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("type")))
            {
            default: 
              return true;
            case 0: 
              this.c = "opencontent";
              break;
            case 1: 
              this.c = "openVideo";
              break;
            case 2: 
              this.c = "opentopic";
            }
          }
        }
      }
      else if (((String)localObject1).startsWith("http://story.now.qq.com/mobile/transfer_q2.html"))
      {
        localObject1 = befm.b(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
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
          this.c = "opencontent";
          for (;;)
          {
            return F();
            this.c = "openVideo";
            continue;
            this.c = "opentopic";
            continue;
            this.c = "infoCard";
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
            ((Intent)localObject3).putExtra("has_red_dot", this.jdField_h_of_type_Boolean);
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
          if (arnf.a((Activity)this.jdField_a_of_type_AndroidContentContext, localException1, (Bundle)localObject3)) {
            return true;
          }
        }
      }
      Object localObject2;
      if ((this.n == null) || (!this.n.trim().equalsIgnoreCase("com.tx.android.txnews.new"))) {
        if ((this.n != null) && (this.n.trim().equalsIgnoreCase("com.qq.yijianfankui")))
        {
          localStringBuffer.append("&version=8.2.6.4370");
          localStringBuffer.append("&appid=" + AppSetting.a());
          localStringBuffer.append("&QUA=" + bfpk.a());
          localStringBuffer.append("&adtag=4370");
          localObject2 = Build.MODEL;
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            i1 = awrn.a();
            localObject3 = localObject2;
            if (i1 > 0) {
              localObject3 = (String)localObject2 + "_qzpatch" + i1;
            }
            localObject2 = Build.MANUFACTURER;
            if (localObject2 == null) {
              break label2129;
            }
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            localStringBuffer.append("&model=").append((String)localObject3).append("&manufacture=").append((String)localObject2).append("&cpunum=").append(babp.b()).append("&cpurate=").append(babp.a()).append("&mem=").append(babp.d() / 1024L / 1024L).append("&w=").append(babp.g()).append("&h=").append(babp.h());
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
          ((Intent)localObject2).putExtra("has_red_dot", this.jdField_h_of_type_Boolean);
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
  
  private boolean aO()
  {
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str7 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str8 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str9 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str10 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str11 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str12 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_to_qq_ark_info"));
    String str13 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chSrc");
    if (!TextUtils.isEmpty(this.n)) {}
    label698:
    label1213:
    label1219:
    label1240:
    String str2;
    label1254:
    for (String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; str2 = null)
    {
      String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
      String str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      String str14 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
      String str15 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      String str16 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
      String str17 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
      int i3 = ForwardUtils.a(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag")));
      if (i3 == 1)
      {
        d("shareToQQ");
        return true;
      }
      long l1 = ForwardUtils.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
      boolean bool = apmf.a();
      Object localObject2 = null;
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("share_msg_by_server_enable_entry", bool);
      localBundle.putBoolean("is_ark_display_share", false);
      if (!TextUtils.isEmpty(str12)) {}
      Object localObject1;
      int i1;
      for (;;)
      {
        try
        {
          Object localObject3 = new JSONObject(str12);
          localObject1 = ((JSONObject)localObject3).optString("app");
          String str3 = ((JSONObject)localObject3).optString("view");
          String str18 = ((JSONObject)localObject3).optString("meta");
          localObject3 = ((JSONObject)localObject3).optString("config");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str18))) {
            if ((bool) || (a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, Long.valueOf(l1))))
            {
              localBundle.putBoolean("is_ark_display_share", true);
              localObject1 = ArkFullScreenAppActivity.a(this.jdField_a_of_type_AndroidContentContext, str3, (String)localObject1, str18, (String)localObject3, String.valueOf(l1), this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity);
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          localObject1 = localObject2;
          localObject2 = localJSONException2;
        }
        try
        {
          ArkAppCenter.c("JumpAction", "gotoShareArkMsg, ark appInfo is parse success");
          i1 = 0;
          if (i1 == 0) {
            break label1254;
          }
          localObject1 = new Intent();
          if (!bool) {
            break label698;
          }
          localBundle.putBoolean("is_ark_display_share", true);
          localBundle.putBoolean("forward_ark_from_sdk", true);
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            continue;
            str2 = "";
          }
          continue;
        }
        if (l1 > 0L) {
          break;
        }
        QLog.d("StructMsg", 1, new Object[] { "gotoShareMsg appid = ", Long.valueOf(l1) });
        return false;
        i1 = 1;
        ArkAppCenter.c("JumpAction", "gotoShareArkMsg, appInfo is not exist in white list and appID is " + l1);
        localObject1 = null;
        continue;
        i1 = 1;
        ArkAppCenter.c("JumpAction", "gotoShareArkMsg, appName or appView or appMeta is empty");
        localObject1 = null;
        continue;
        i1 = 1;
        ArkAppCenter.c("JumpAction", String.format("gotoShareArkMsg, parse json failed, err=%s", new Object[] { localObject2.getMessage() }));
        continue;
        ArkAppCenter.c("JumpAction", "gotoShareArkMsg, appInfo is empty");
        i1 = 1;
        localObject1 = null;
        continue;
        localBundle.putBoolean("forward_ark_from_sdk", false);
      }
      if (("news".equals(str6)) || ("audio".equals(str6)))
      {
        localBundle.putString("title", str8);
        localBundle.putString("desc", str9);
        localBundle.putString("image_url", str7);
        localBundle.putString("detail_url", str10);
        localBundle.putString("chSrc", str13);
        localBundle.putInt("forward_type", 11);
        localBundle.putLong("req_share_id", l1);
        localBundle.putString("pkg_name", this.n);
        localBundle.putString("image_url_remote", str11);
        localBundle.putString("app_name", str1);
        localBundle.putString("open_id", str5);
        localBundle.putString("shareArkInfo", str12);
        localBundle.putString("chSrc", str13);
        if (str8 == null)
        {
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131630985, new Object[] { str1 }));
          }
        }
        else {
          for (;;)
          {
            localBundle.putString("share_uin", str15);
            localBundle.putString("jfrom", str16);
            localBundle.putString("share_qq_ext_str", str17);
            localBundle.putInt("cflag", i3);
            localBundle.putInt("emoInputType", 2);
            int i2 = 148;
            try
            {
              i1 = Integer.valueOf(str14).intValue();
              if ((i1 == 5) && (apmf.b()))
              {
                localBundle.putBoolean("is_ark_display_share", true);
                localBundle.putBoolean("forward_ark_from_sdk", true);
              }
              if (i1 == 2) {
                localBundle.putString("audio_url", str4);
              }
              localBundle.putInt("req_type", i1);
              localBundle.putBoolean("k_dataline", false);
              localBundle.putBoolean("k_favorites", true);
              localBundle.putBoolean("k_cancel_button", true);
              if (((i3 & 0x2) == 0) && (!"com.qzone".equals(this.n)))
              {
                bool = true;
                localBundle.putBoolean("k_qzone", bool);
                if ((!bool) || ((i3 & 0x1) == 0)) {
                  break label1213;
                }
                bool = true;
                localBundle.putBoolean("k_send", bool);
                localBundle.putInt("iUrlInfoFrm", 4);
                a(str5, l1, localBundle);
                if (localObject1 == null) {
                  break label1240;
                }
                if (!MiniProgramOpenSdkUtil.isSharingMiniProgram(this.jdField_a_of_type_JavaUtilHashMap)) {
                  break label1219;
                }
                MiniProgramOpenSdkUtil.forwardShareWithTryCatch(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, localBundle, (Intent)localObject1);
                return true;
                localBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131630985, new Object[] { str8 }));
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                i1 = i2;
                if (QLog.isColorLevel())
                {
                  QLog.d("QQShare", 2, "NumberFormatException req_type = 1");
                  i1 = i2;
                  continue;
                  bool = false;
                  continue;
                  bool = false;
                }
              }
              ((Intent)localObject1).putExtras(localBundle);
              com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
              aphp.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1);
            }
          }
        }
      }
      else
      {
        return true;
      }
    }
  }
  
  private boolean aP()
  {
    Object localObject = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("fopen_id"));
    String str2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("friend_label"));
    String str3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("add_msg"));
    String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
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
  
  private boolean aQ()
  {
    Object localObject;
    String str2;
    bfpy localbfpy;
    String str1;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)))
    {
      localObject = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("page_id");
      if (str2 != null)
      {
        localbfpy = bfpy.a();
        localbfpy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localbfpy.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
        SessionInfo localSessionInfo = ((FragmentActivity)localObject).getChatFragment().a().a();
        if ((localSessionInfo != null) && (!TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString))) {
          ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).e(localSessionInfo.jdField_a_of_type_JavaLangString, true);
        }
        if (!str2.equalsIgnoreCase("11")) {
          break label166;
        }
        bfpr.b((Activity)this.jdField_a_of_type_AndroidContentContext, localbfpy, str1, "mqqChat.QzoneCard", -1);
      }
    }
    for (;;)
    {
      return false;
      label166:
      if (str2.equalsIgnoreCase("12"))
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a().a();
        str2 = d(str1);
        if (TextUtils.isEmpty(str2)) {
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, "缺少相册id", 1).a();
        } else {
          bfpr.a((Activity)this.jdField_a_of_type_AndroidContentContext, localbfpy, (String)localObject, str2, str1, "mqqChat.QzoneCard", -1);
        }
      }
    }
  }
  
  private boolean aR()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.common.activities.QzoneDialogActivity");
    localIntent.addFlags(805306368);
    bfpr.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localIntent, -1);
    return true;
  }
  
  private boolean aS()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (!bgga.a().b(this.n, this.jdField_a_of_type_JavaLangString))
      {
        QLog.e("JumpAction", 1, "has no right to handle this schema");
        return false;
      }
      String str;
      if (this.jdField_a_of_type_JavaLangString.startsWith("mqqzone"))
      {
        str = "mqzone" + this.jdField_a_of_type_JavaLangString.substring("mqqzone".length());
        if (TextUtils.isEmpty(str)) {
          break label209;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("cmd", "Schema");
        localIntent.putExtra("schema", str);
        sam.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_h_of_type_Boolean);
        rww.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_h_of_type_Boolean, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          return true;
          str = (String)befm.a(this.jdField_a_of_type_JavaLangString).get("schema");
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
        label209:
        QLog.e("JumpAction", 1, "gotoQzoneHandleSchema,schema=null");
      }
    }
    return false;
  }
  
  private boolean aT()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return false;
    }
    long l1 = bexy.a();
    if (l1 != 0L) {
      QZoneMsgActivity.a(l1, this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      return true;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QZoneMsgActivity.class);
      localIntent.addFlags(67108864);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  private boolean aU()
  {
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    Object localObject9 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject7 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    a((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    Object localObject10 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    if (!TextUtils.isEmpty(this.n)) {}
    for (localObject1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; localObject1 = null)
    {
      String str3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
      String str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
      String str6 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
      String str8 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
      for (;;)
      {
        try
        {
          i1 = Integer.valueOf(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
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
              if (!TextUtils.isEmpty(this.n)) {
                continue;
              }
              localObject6 = "";
              bfhz.a((AppRuntime)localObject8, "User_SdkShare", i2, 0, 0, 0, str1, (String)localObject6);
              localObject8 = new Bundle();
              ((Bundle)localObject8).putString("title", (String)localObject5);
              ((Bundle)localObject8).putString("desc", (String)localObject7);
              ((Bundle)localObject8).putString("image_url", (String)localObject9);
              ((Bundle)localObject8).putString("detail_url", (String)localObject10);
              ((Bundle)localObject8).putLong("req_share_id", l1);
              ((Bundle)localObject8).putString("pkg_name", this.n);
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
                    ((Bundle)localObject8).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131632442), new Object[] { localObject1 }));
                  }
                }
                else
                {
                  com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
                  localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
                  ((Intent)localObject1).putExtra("toUin", ajed.L);
                  ((Intent)localObject1).putExtra("uinType", 0);
                  if (1 != i1) {
                    break label1692;
                  }
                  ((Intent)localObject1).putExtra("qqfav_extra_from_system_share", true);
                  ((Intent)localObject1).putExtras((Bundle)localObject8);
                  aphp.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, DirectForwardActivity.class);
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
                  localObject6 = this.n;
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
              ((Bundle)localObject8).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131632443));
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
                  bfid.a(this.jdField_a_of_type_AndroidContentContext, 2131632440, 1);
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
                  ((Bundle)localObject8).putString("title", ((ArrayList)localObject10).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131629087));
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
                    ((Bundle)localObject8).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131632442), new Object[] { localObject1 }));
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
                ((Bundle)localObject8).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131632443));
                continue;
              }
              bfid.a(this.jdField_a_of_type_AndroidContentContext, 2131632440, 1);
              if (QLog.isColorLevel()) {
                QLog.e("qqfav", 2, "gotoQfavShareMsg|unknown reqType. reqType=" + i2);
              }
              return false;
            }
          }
        }
        label1692:
        ((Intent)localObject1).putExtra("qqfav_extra_from_sdk_share", true);
      }
    }
  }
  
  private boolean aV()
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
      str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      localObject2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      localObject3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qzone_ext_str"));
      ((Bundle)localObject1).putString("open_id", str);
      ((Bundle)localObject1).putString("share_uin", (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((Bundle)localObject1).putString("share_ext_string", (String)localObject3);
      }
      i2 = Integer.valueOf(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"))).intValue();
      str = "";
      if (i2 != 3) {
        break label614;
      }
    }
    String str = "7";
    Object localObject2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    Object localObject4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    Object localObject3 = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      localObject4 = ((String)localObject4).split(";");
      int i1 = 0;
      while (i1 < localObject4.length)
      {
        ((ArrayList)localObject3).add(URLDecoder.decode(localObject4[i1]));
        i1 += 1;
      }
    }
    ((Bundle)localObject1).putStringArrayList("images", (ArrayList)localObject3);
    ((Bundle)localObject1).putString("summary", (String)localObject2);
    for (;;)
    {
      ((Bundle)localObject1).putString("app_name", a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")));
      if (!TextUtils.isEmpty(this.n)) {
        ((Bundle)localObject1).putString("hulian_appid", String.valueOf(l1));
      }
      ((Bundle)localObject1).putInt("req_type", i2);
      ((Bundle)localObject1).putLong("req_share_id", l1);
      ((Bundle)localObject1).putString("pkg_name", this.n);
      ((Bundle)localObject1).putBoolean("key_need_save_draft", false);
      com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
      localObject2 = new bacq(this);
      bfqn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, (DialogInterface.OnDismissListener)localObject2);
      localObject2 = new bfpl();
      ((bfpl)localObject2).c = "1";
      ((bfpl)localObject2).jdField_d_of_type_JavaLangString = "0";
      ((bfpl)localObject2).jdField_b_of_type_Int = 4;
      ((bfpl)localObject2).l = "5";
      ((bfpl)localObject2).m = "thirdApp";
      localObject3 = new HashMap();
      ((HashMap)localObject3).put("source_type", "5");
      ((HashMap)localObject3).put("source_from", "thirdApp");
      localObject1 = ((Bundle)localObject1).getStringArrayList("images");
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 9))
      {
        ((bfpl)localObject2).n = "QZoneUploadPhotosActivity";
        ((HashMap)localObject3).put("source_to", "QZoneUploadPhotosActivity");
        QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (bfpl)localObject2);
        awrn.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject3, null);
        bcad.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", l1 + "", "11", "12", "0", str, "", "4", false);
        return true;
        label614:
        if (i2 != 4) {
          continue;
        }
        str = "8";
        localObject2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoPath"));
      }
      try
      {
        ((Bundle)localObject1).putLong("file_send_duration", Long.valueOf(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoDuration"))).longValue());
        try
        {
          label672:
          ((Bundle)localObject1).putLong("PhotoConst.VIDEO_SIZE", Long.valueOf(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoSize"))).longValue());
          label702:
          localObject3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
          ((Bundle)localObject1).putBoolean("PhotoConst.IS_VIDEO_SELECTED", true);
          ((Bundle)localObject1).putInt("PhotoConst.VIDEO_TYPE", 1);
          ((Bundle)localObject1).putString("file_send_path", (String)localObject2);
          ((Bundle)localObject1).putBoolean("need_process", false);
          ((Bundle)localObject1).putString("defaultText", (String)localObject3);
          continue;
          ((bfpl)localObject2).n = "QZonePublishMoodActivity";
          ((HashMap)localObject3).put("source_to", "QZonePublishMoodActivity");
        }
        catch (Exception localException2)
        {
          break label702;
        }
      }
      catch (Exception localException3)
      {
        break label672;
      }
    }
  }
  
  private boolean aW()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    String str3 = bfpk.a();
    bfqn.a(this.jdField_a_of_type_AndroidContentContext, str1, null, 0, str2, str3);
    return true;
  }
  
  private boolean aX()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_uin");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(str))
    {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extinfo");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (str = "mqzone://arouse/homepage?redpocket=1&uin=" + str;; str = "mqzone://arouse/homepage?redpocket=1&uin=" + str + "&extinfo=" + (String)localObject)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("cmd", "Schema");
        ((Intent)localObject).putExtra("schema", str);
        bfpr.a((Activity)this.jdField_a_of_type_AndroidContentContext, bfpy.a(), (Intent)localObject);
        return true;
      }
    }
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    if ((!TextUtils.isEmpty(str)) && (str.equals("login")))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, ajjy.a(2131640107), 1).a();
      return true;
    }
    bbmy.a(this.jdField_a_of_type_AndroidContentContext, ajjy.a(2131640117), 1).a();
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
      if (befo.e()) {
        ((Intent)localObject).addFlags(32768);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
    }
  }
  
  private boolean aY()
  {
    bbmy.a(this.jdField_a_of_type_AndroidContentContext, ajjy.a(2131640109), 1).a();
    return false;
  }
  
  private boolean aZ()
  {
    return true;
  }
  
  private boolean aa()
  {
    Intent localIntent = new Intent();
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, SearchMightKnowFragment.class);
    return true;
  }
  
  private boolean ab()
  {
    Intent localIntent = new Intent();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
    if ((!TextUtils.isEmpty(str)) && (a(str))) {}
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
  
  private boolean ac()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (a((String)localObject))) {}
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
  
  private boolean ad()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ContactBindedActivity.class);
    localIntent.putExtra("from_babyq", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean ae()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"); !str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()); str = "")
    {
      f();
      return false;
    }
    g();
    return false;
  }
  
  private boolean af()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("leftBackText", ajjy.a(2131640122));
    ((Bundle)localObject).putBoolean("isBack2Root", true);
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.putExtras((Bundle)localObject);
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("txt");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      localIntent.putExtra("JumpAction.Text", a((String)localObject));
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean ag()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    QWalletHelper.launchQWalletAct((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false);
    return true;
  }
  
  private boolean ah()
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
  
  private boolean ai()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_id");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_id");
    String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id"));
    String str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_path"));
    String str6 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_type"));
    String str7 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A519", "0X800A519", 0, 0, "", "", str4, str2);
    if (TextUtils.isEmpty(this.n))
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A51B", "0X800A51B", 0, 0, "", "", str4, str2);
      QLog.e("JumpAction", 1, "connectMiniApp fail: packageName is empty");
      return true;
    }
    if ("mini_program_or_game".equals(localObject))
    {
      if (!badq.d(this.jdField_a_of_type_AndroidContentContext))
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131633780, 1).a();
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).addFlags(268435456);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        return true;
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JumpAction.8(this), 20000L);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JumpAction.9(this), 500L);
      try
      {
        this.jdField_d_of_type_Boolean = true;
        boolean bool;
        MessageHandler localMessageHandler;
        if (!TextUtils.isEmpty(str1))
        {
          bool = true;
          apmt.a("KEY_STAGE_2_CONNECT_MINI_D55");
          localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (str1 != null) {
            break label442;
          }
        }
        label442:
        for (localObject = "";; localObject = str1)
        {
          localMessageHandler.a(bool, (String)localObject, true, Long.valueOf(str2).longValue(), Long.valueOf(str4).longValue(), 1, Integer.valueOf(str3).intValue(), this.n, false, 0L, new baco(this, str4, str2, str5, str6, str1, str7));
          return false;
          bool = false;
          break;
        }
        return true;
      }
      catch (Exception localException)
      {
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = false;
          c();
        }
        QLog.e("JumpAction", 1, "checkAppSignAndOpenidDiff exception: " + localException.getMessage());
        return true;
      }
    }
  }
  
  private boolean aj()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
    Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    Object localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    String str9 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str10 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id"));
    String str11 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_pkg_name"));
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
      localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
      if (((ajjj)localObject1).b(str2))
      {
        localObject3 = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
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
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007191", "0X8007191", 0, 0, "", "", "", "");
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
      localObject4 = aciy.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
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
            localObject3 = babh.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
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
            if (((ajjj)localObject1).b(str2)) {
              i1 = 0;
            }
            for (localObject1 = babh.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);; localObject1 = null)
            {
              f(str2);
              localObject3 = localObject1;
              localObject2 = null;
              localObject1 = null;
              break;
              i1 = 1005;
            }
          }
          if ("crm".equals(localObject3))
          {
            boolean bool2 = an();
            bool1 = bool2;
            if (!bool2) {
              bool1 = ak();
            }
            bool2 = bool1;
            if (!bool1) {
              bool2 = al();
            }
            bool1 = bool2;
            if (bool2) {
              break;
            }
            return am();
          }
          if (("lbs".equals(localObject3)) || ("date".equals(localObject3)))
          {
            if ((str2 == null) || (str2.length() < 5) || (str2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              return false;
            }
            if (((ajjj)localObject1).b(str2))
            {
              i1 = 0;
              localObject3 = babh.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
              localObject2 = null;
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject2 != null) && (localObject4 != null))
        {
          localObject1 = bach.a((String)localObject4);
          break;
          if ("lbs".equals(localObject3))
          {
            i1 = 1001;
            localObject3 = babh.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            localObject2 = "rich_accost_sig";
          }
          else
          {
            i1 = 1010;
            localObject3 = babh.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            localObject2 = "rich_date_sig";
            continue;
            if ("public_account".equals(localObject3))
            {
              if ((str2 == null) || (str2.length() < 6)) {
                return false;
              }
              localObject1 = rtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
              ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", str2, "0X800589E", "0X800589E", 0, 0, str2, "", "", "", false);
              localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class);
              ((Intent)localObject2).putExtra("uin", str2);
              ((Intent)localObject2).putExtra("uintype", 1008);
              if (localObject1 != null) {
                ((Intent)localObject2).putExtra("uinname", (String)localObject1);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
              return true;
            }
            if ("qd_account".equals(localObject3))
            {
              if ((str2 == null) || (str2.length() < 6)) {
                return false;
              }
              localObject1 = aciy.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
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
              if (!badq.d(this.jdField_a_of_type_AndroidContentContext))
              {
                bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131633767, 1).a();
                localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).addFlags(268435456);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                return true;
              }
              if (!TextUtils.isEmpty(str9))
              {
                this.jdField_a_of_type_AndroidOsHandler = new Handler();
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new JumpAction.11(this), 20000L);
                try
                {
                  if ("thirdparty2c".equals(localObject3)) {
                    i1 = 18;
                  }
                  for (;;)
                  {
                    apmt.a("KEY_STAGE_2_GO_TO_CHAT_D55");
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, str9, false, 0L, Long.valueOf(str10).longValue(), 1, i1, str11, false, 0L, new bacp(this, str9, str10, (String)localObject3));
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
            localObject2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("thirdAppDisplayName"));
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
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B4B", "0X8004B4B", 0, 0, "", "", "", "");
            if ("webview".equals(this.m))
            {
              ((Intent)localObject4).putExtra("from", this.m);
              if (jdField_a_of_type_Int > 3)
              {
                bbmy.a(this.jdField_a_of_type_AndroidContentContext, ajjy.a(2131640105), 1).a();
                return true;
              }
              jdField_a_of_type_Int += 1;
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B5A", "0X8004B5A", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              if (str3 != null) {
                ((Intent)localObject4).putExtra("panel", str3);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
              return true;
              awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B58", "0X8004B58", 0, 0, "", "", "", "");
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
  
  private boolean ak()
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
          break label534;
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
            break label398;
          }
          if (str7.length() < 5) {
            break label575;
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
        localIntent.putExtra("sigt", bach.a(str6));
      }
      if (((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(str7))
      {
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("uinname", babh.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str7));
        label378:
        localIntent.putExtra("uin", str7);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          label398:
          ((bcqv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str4, localException1, str3, str2, (String)localObject, str5, this.jdField_a_of_type_Bcqu.jdField_a_of_type_Int);
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
            label534:
            bool1 = true;
          }
        }
        localIntent.putExtra("uintype", 1025);
        localIntent.putExtra("from_wpa_for_crm", true);
        break label378;
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleQidianExtWPA wpaType != 2");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bcqu);
      }
      break;
    }
    label575:
    return false;
  }
  
  private boolean al()
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bcqu);
          ((bcqv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str5, str2, str1, str3, str4, str6);
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
  
  private boolean am()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str1 == null) || (str1.length() < 5) || (str1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      return false;
    }
    Object localObject = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("attach_content"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sigt");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sig");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shouldReturnToRoot");
    Intent localIntent = new Intent();
    int i1;
    if ((TextUtils.isEmpty(str4)) || (str4.equals("NO")))
    {
      localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, ChatActivity.class));
      localIntent.addFlags(67108864);
      i1 = mqb.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "handleLegacyCrmWPA " + i1);
      }
      localIntent.putExtra("from_wpa_for_crm", true);
      localIntent.putExtra("uin", str1);
      localIntent.putExtra("uintype", i1);
      if (i1 != 0) {
        break label404;
      }
      str4 = babh.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
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
        localObject = bach.a(str3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str1, (byte[])localObject);
      }
      if (str2 != null) {
        localIntent.putExtra("sigt", bach.a(str2));
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Bqq_Crm", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str1, "", "");
      return true;
      localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class));
      localIntent.putExtra("open_chatfragment", true);
      break;
      label404:
      if (i1 == 1024) {
        localIntent.putExtra("chat_subType", 1);
      }
    }
  }
  
  private boolean an()
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
  
  private boolean ao()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((str == null) || (str.length() < 6)) {
      return false;
    }
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject == null) {
      return false;
    }
    localObject = ((TroopManager)localObject).b(str);
    if (localObject != null)
    {
      localObject = ((TroopInfo)localObject).getTroopName();
      Intent localIntent = new Intent();
      localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
      localIntent = aciy.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", 1);
      if (localObject != null) {
        localIntent.putExtra("uinname", (String)localObject);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    return aE();
  }
  
  private boolean ap()
  {
    if (QLog.isColorLevel()) {
      asfl.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
        str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
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
  
  private boolean aq()
  {
    aylv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private boolean ar()
  {
    if ((String)this.jdField_a_of_type_JavaUtilHashMap.get("back_title") == null) {
      ajjy.a(2131640121);
    }
    aynk localaynk = (aynk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if (localaynk != null) {
      localaynk.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 0);
    }
    return true;
  }
  
  private boolean as()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.putExtra("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = babh.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    localIntent.putExtra("nickname", (String)localObject);
    localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      if ((!str.equals("version")) && (!str.equals("src_type"))) {
        localIntent.putExtra(str, (String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
      }
    }
    return a(localIntent, "cooperation.qqreader.QRBridgeActivity", "qqreaderplugin.apk");
  }
  
  /* Error */
  private boolean at()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 3055
    //   7: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 50	java/lang/String
    //   13: astore 6
    //   15: aload_0
    //   16: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: ldc_w 3057
    //   22: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 50	java/lang/String
    //   28: astore 7
    //   30: aload 6
    //   32: ifnull +139 -> 171
    //   35: aload 7
    //   37: ifnull +134 -> 171
    //   40: aload 6
    //   42: invokevirtual 2088	java/lang/String:trim	()Ljava/lang/String;
    //   45: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   48: i2d
    //   49: ldc2_w 3087
    //   52: ddiv
    //   53: dstore_1
    //   54: aload 7
    //   56: invokevirtual 2088	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: istore 5
    //   64: iload 5
    //   66: i2d
    //   67: ldc2_w 3087
    //   70: ddiv
    //   71: dstore_3
    //   72: aload_0
    //   73: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   76: ldc_w 1960
    //   79: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 50	java/lang/String
    //   85: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   88: pop
    //   89: new 197	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 3090
    //   99: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: dload_3
    //   103: invokevirtual 3093	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   106: ldc_w 3095
    //   109: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: dload_1
    //   113: invokevirtual 3093	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   116: ldc_w 3097
    //   119: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 6
    //   127: new 106	android/content/Intent
    //   130: dup
    //   131: ldc_w 3099
    //   134: aload 6
    //   136: invokestatic 1550	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   139: invokespecial 3102	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   142: astore 7
    //   144: aload 7
    //   146: ldc_w 3104
    //   149: ldc_w 3106
    //   152: invokevirtual 1224	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: aload_0
    //   157: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   160: aload 7
    //   162: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   165: iconst_1
    //   166: ireturn
    //   167: astore 6
    //   169: iconst_0
    //   170: ireturn
    //   171: iconst_0
    //   172: ireturn
    //   173: astore 7
    //   175: aload_0
    //   176: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   179: new 106	android/content/Intent
    //   182: dup
    //   183: ldc_w 3099
    //   186: aload 6
    //   188: invokestatic 1550	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   191: invokespecial 3102	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   194: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   197: goto -32 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	bacn
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
  
  private boolean au()
  {
    if ("webview".equals(this.m))
    {
      a((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "select_location").putExtra("doCallBack", true).putExtra("src_type", this.jdField_f_of_type_JavaLangString).putExtra("callback_type", this.jdField_g_of_type_JavaLangString).putExtra("callback_name", this.jdField_h_of_type_JavaLangString));
    }
    return true;
  }
  
  private boolean av()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("card_type");
    if (QSecFramework.a().a(1003).booleanValue())
    {
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      bbsv.a().a(5, str1, 0, str2);
      bbsv.a().a();
    }
    if ((str1 != null) && ("group".equals(str1)))
    {
      a(10010, a());
      return aE();
    }
    if ("groupsearchsetting".equalsIgnoreCase(str1)) {
      return aC();
    }
    if ("groupmanager".equalsIgnoreCase(str1)) {
      return aD();
    }
    if ("public_account".equals(str1))
    {
      a(10003, a());
      return ax();
    }
    if ("troopmember".equals(str1)) {
      return aG();
    }
    if ("crm".equals(str1)) {
      return ay();
    }
    if ("nearby".equals(str1)) {
      return aw();
    }
    if ("allpeoplevote".equals(str1)) {
      return az();
    }
    if ("troopmemberfromhb".equals(str1)) {
      return aH();
    }
    a(10002, a());
    return aA();
  }
  
  /* Error */
  private boolean aw()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 3169
    //   7: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +329 -> 339
    //   13: aload_0
    //   14: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   17: ldc_w 3169
    //   20: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 50	java/lang/String
    //   26: astore 12
    //   28: aload_0
    //   29: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   32: ldc_w 3171
    //   35: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   38: ifeq +308 -> 346
    //   41: aload_0
    //   42: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   45: ldc_w 3171
    //   48: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 50	java/lang/String
    //   54: astore 11
    //   56: lconst_0
    //   57: lstore 5
    //   59: aload_0
    //   60: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   63: ldc_w 3173
    //   66: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   69: ifeq +1269 -> 1338
    //   72: ldc_w 657
    //   75: aload_0
    //   76: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   79: ldc_w 3173
    //   82: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq +1250 -> 1338
    //   91: iconst_1
    //   92: istore 9
    //   94: lload 5
    //   96: lstore 7
    //   98: aload_0
    //   99: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   102: ldc_w 3175
    //   105: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   108: ifeq +24 -> 132
    //   111: aload_0
    //   112: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   115: ldc_w 3175
    //   118: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: checkcast 50	java/lang/String
    //   124: invokestatic 580	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   127: invokevirtual 583	java/lang/Long:longValue	()J
    //   130: lstore 7
    //   132: aload_0
    //   133: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   136: ldc_w 3177
    //   139: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   142: ifeq +242 -> 384
    //   145: aload_0
    //   146: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   149: ldc_w 3177
    //   152: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: checkcast 50	java/lang/String
    //   158: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   161: invokevirtual 673	java/lang/Integer:intValue	()I
    //   164: istore_1
    //   165: aload_0
    //   166: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   169: ldc_w 3179
    //   172: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   175: ifeq +214 -> 389
    //   178: aload_0
    //   179: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   182: ldc_w 3179
    //   185: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   188: checkcast 50	java/lang/String
    //   191: astore 13
    //   193: aload 13
    //   195: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: istore 10
    //   200: iload 10
    //   202: ifeq +194 -> 396
    //   205: lconst_0
    //   206: lstore 5
    //   208: aload_0
    //   209: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   212: ldc_w 416
    //   215: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   218: ifeq +199 -> 417
    //   221: aload_0
    //   222: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   225: ldc_w 416
    //   228: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   231: checkcast 50	java/lang/String
    //   234: astore 13
    //   236: aload 13
    //   238: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   241: istore_2
    //   242: aload_0
    //   243: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   246: ldc_w 3181
    //   249: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   252: ifeq +179 -> 431
    //   255: aload_0
    //   256: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   259: ldc_w 3181
    //   262: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   265: checkcast 50	java/lang/String
    //   268: astore 13
    //   270: aload 13
    //   272: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   275: invokevirtual 673	java/lang/Integer:intValue	()I
    //   278: istore_3
    //   279: aload_0
    //   280: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   283: ldc_w 3183
    //   286: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   289: ifeq +156 -> 445
    //   292: aload_0
    //   293: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   296: ldc_w 3183
    //   299: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   302: checkcast 50	java/lang/String
    //   305: astore 13
    //   307: aload 13
    //   309: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   312: invokevirtual 673	java/lang/Integer:intValue	()I
    //   315: istore 4
    //   317: iload_3
    //   318: iconst_1
    //   319: if_icmpeq +142 -> 461
    //   322: iload_3
    //   323: iconst_2
    //   324: if_icmpeq +137 -> 461
    //   327: iload_3
    //   328: iconst_3
    //   329: if_icmpeq +132 -> 461
    //   332: iload_3
    //   333: iconst_4
    //   334: if_icmpeq +127 -> 461
    //   337: iconst_0
    //   338: ireturn
    //   339: ldc 61
    //   341: astore 12
    //   343: goto -315 -> 28
    //   346: ldc 61
    //   348: astore 11
    //   350: goto -294 -> 56
    //   353: astore 13
    //   355: ldc_w 435
    //   358: iconst_1
    //   359: ldc_w 3185
    //   362: invokestatic 439	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: lload 5
    //   367: lstore 7
    //   369: goto -237 -> 132
    //   372: astore 13
    //   374: ldc_w 435
    //   377: iconst_1
    //   378: ldc_w 3187
    //   381: invokestatic 439	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: iconst_0
    //   385: istore_1
    //   386: goto -221 -> 165
    //   389: ldc 61
    //   391: astore 13
    //   393: goto -200 -> 193
    //   396: aload 13
    //   398: invokestatic 580	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   401: invokevirtual 583	java/lang/Long:longValue	()J
    //   404: lstore 5
    //   406: goto -198 -> 208
    //   409: astore 13
    //   411: lconst_0
    //   412: lstore 5
    //   414: goto -206 -> 208
    //   417: ldc 61
    //   419: astore 13
    //   421: goto -185 -> 236
    //   424: astore 13
    //   426: iconst_0
    //   427: istore_2
    //   428: goto -186 -> 242
    //   431: ldc 61
    //   433: astore 13
    //   435: goto -165 -> 270
    //   438: astore 13
    //   440: iconst_m1
    //   441: istore_3
    //   442: goto -163 -> 279
    //   445: ldc_w 372
    //   448: astore 13
    //   450: goto -143 -> 307
    //   453: astore 13
    //   455: iconst_0
    //   456: istore 4
    //   458: goto -141 -> 317
    //   461: new 106	android/content/Intent
    //   464: dup
    //   465: aload_0
    //   466: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   469: ldc_w 3189
    //   472: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   475: astore 15
    //   477: aload 15
    //   479: ldc_w 3191
    //   482: iload 4
    //   484: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   487: pop
    //   488: aload 15
    //   490: ldc_w 3193
    //   493: iload 9
    //   495: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   498: pop
    //   499: aload 15
    //   501: ldc_w 3175
    //   504: lload 7
    //   506: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   509: pop
    //   510: aload 15
    //   512: ldc_w 3195
    //   515: iload_1
    //   516: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   519: pop
    //   520: iload_3
    //   521: tableswitch	default:+31 -> 552, 1:+33->554, 2:+33->554, 3:+437->958, 4:+696->1217
    //   553: ireturn
    //   554: aload_0
    //   555: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   558: ifnull +107 -> 665
    //   561: aload_0
    //   562: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   565: invokevirtual 2619	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   568: astore 11
    //   570: aload 12
    //   572: ldc_w 3197
    //   575: invokestatic 3200	azzz:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   578: ifeq +361 -> 939
    //   581: aload_0
    //   582: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   585: ldc_w 3202
    //   588: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   591: ifeq +93 -> 684
    //   594: aload_0
    //   595: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   598: ldc_w 3202
    //   601: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   604: checkcast 50	java/lang/String
    //   607: astore 13
    //   609: aload_0
    //   610: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   613: ldc_w 3204
    //   616: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   619: ifeq +72 -> 691
    //   622: aload_0
    //   623: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   626: ldc_w 3204
    //   629: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   632: checkcast 50	java/lang/String
    //   635: astore 14
    //   637: aload 13
    //   639: aload 11
    //   641: invokestatic 3200	azzz:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   644: ifne +54 -> 698
    //   647: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +13 -> 663
    //   653: ldc_w 435
    //   656: iconst_2
    //   657: ldc_w 3206
    //   660: invokestatic 439	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: iconst_1
    //   664: ireturn
    //   665: aload_0
    //   666: getfield 3208	bacn:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   669: ifnull +662 -> 1331
    //   672: aload_0
    //   673: getfield 3208	bacn:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   676: invokevirtual 3211	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   679: astore 11
    //   681: goto -111 -> 570
    //   684: ldc 61
    //   686: astore 13
    //   688: goto -79 -> 609
    //   691: ldc 61
    //   693: astore 14
    //   695: goto -58 -> 637
    //   698: aload 15
    //   700: ldc_w 3204
    //   703: aload 14
    //   705: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   708: pop
    //   709: aload 15
    //   711: ldc_w 3213
    //   714: iconst_m1
    //   715: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   718: pop
    //   719: aload 15
    //   721: ldc_w 402
    //   724: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   727: pop
    //   728: new 932	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   731: dup
    //   732: aload 11
    //   734: iconst_0
    //   735: invokespecial 938	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   738: astore 11
    //   740: iload_2
    //   741: iconst_1
    //   742: if_icmpne +30 -> 772
    //   745: aload 15
    //   747: ldc_w 3213
    //   750: bipush 12
    //   752: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   755: pop
    //   756: aload 11
    //   758: bipush 86
    //   760: putfield 3214	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   763: aload 15
    //   765: ldc_w 515
    //   768: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   771: pop
    //   772: iload_2
    //   773: iconst_2
    //   774: if_icmpne +19 -> 793
    //   777: aload 11
    //   779: bipush 87
    //   781: putfield 3214	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   784: aload 15
    //   786: ldc_w 515
    //   789: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   792: pop
    //   793: iload_2
    //   794: iconst_3
    //   795: if_icmpne +19 -> 814
    //   798: aload 11
    //   800: bipush 88
    //   802: putfield 3214	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   805: aload 15
    //   807: ldc_w 515
    //   810: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   813: pop
    //   814: iload_2
    //   815: bipush 7
    //   817: if_icmplt +29 -> 846
    //   820: aload 15
    //   822: ldc_w 3213
    //   825: iload_2
    //   826: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   829: pop
    //   830: aload 11
    //   832: bipush 86
    //   834: putfield 3214	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   837: aload 15
    //   839: ldc_w 515
    //   842: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   845: pop
    //   846: aload 15
    //   848: ldc_w 3216
    //   851: iload_3
    //   852: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   855: pop
    //   856: aload 15
    //   858: ldc_w 3218
    //   861: aload 11
    //   863: invokevirtual 1672	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   866: pop
    //   867: aload 12
    //   869: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   872: ifne +80 -> 952
    //   875: aload 12
    //   877: ldc_w 3220
    //   880: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   883: ifeq +69 -> 952
    //   886: iconst_1
    //   887: istore 9
    //   889: aload 15
    //   891: ldc_w 3222
    //   894: iload 9
    //   896: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   899: pop
    //   900: sipush 10002
    //   903: iload_2
    //   904: if_icmpne +12 -> 916
    //   907: aload 15
    //   909: ldc_w 515
    //   912: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   915: pop
    //   916: aload 15
    //   918: ldc_w 3224
    //   921: lload 5
    //   923: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   926: pop
    //   927: aload_0
    //   928: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   931: aload 15
    //   933: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   936: goto -384 -> 552
    //   939: aload 15
    //   941: ldc_w 3226
    //   944: iconst_1
    //   945: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   948: pop
    //   949: goto -221 -> 728
    //   952: iconst_0
    //   953: istore 9
    //   955: goto -66 -> 889
    //   958: aload_0
    //   959: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   962: ldc_w 653
    //   965: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   968: ifeq +42 -> 1010
    //   971: aload_0
    //   972: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   975: ldc_w 653
    //   978: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   981: checkcast 50	java/lang/String
    //   984: astore 12
    //   986: lload 5
    //   988: lconst_0
    //   989: lcmp
    //   990: ifne +27 -> 1017
    //   993: aload 12
    //   995: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   998: ifeq +19 -> 1017
    //   1001: lload 7
    //   1003: lconst_0
    //   1004: lcmp
    //   1005: ifne +12 -> 1017
    //   1008: iconst_0
    //   1009: ireturn
    //   1010: ldc 61
    //   1012: astore 12
    //   1014: goto -28 -> 986
    //   1017: aload 15
    //   1019: ldc_w 3216
    //   1022: iconst_3
    //   1023: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1026: pop
    //   1027: aload 15
    //   1029: ldc_w 3224
    //   1032: lload 5
    //   1034: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1037: pop
    //   1038: sipush 10002
    //   1041: iload_2
    //   1042: if_icmpne +12 -> 1054
    //   1045: aload 15
    //   1047: ldc_w 515
    //   1050: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1053: pop
    //   1054: aload 15
    //   1056: ldc_w 3226
    //   1059: iconst_1
    //   1060: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1063: pop
    //   1064: aload 15
    //   1066: ldc_w 3228
    //   1069: aload 11
    //   1071: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1074: pop
    //   1075: new 932	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   1078: dup
    //   1079: aload 12
    //   1081: bipush 19
    //   1083: invokespecial 938	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   1086: astore 11
    //   1088: iload_2
    //   1089: iconst_1
    //   1090: if_icmpne +30 -> 1120
    //   1093: aload 15
    //   1095: ldc_w 3213
    //   1098: bipush 12
    //   1100: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1103: pop
    //   1104: aload 11
    //   1106: bipush 86
    //   1108: putfield 3214	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1111: aload 15
    //   1113: ldc_w 515
    //   1116: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1119: pop
    //   1120: iload_2
    //   1121: iconst_2
    //   1122: if_icmpne +19 -> 1141
    //   1125: aload 11
    //   1127: bipush 87
    //   1129: putfield 3214	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1132: aload 15
    //   1134: ldc_w 515
    //   1137: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1140: pop
    //   1141: iload_2
    //   1142: iconst_3
    //   1143: if_icmpne +19 -> 1162
    //   1146: aload 11
    //   1148: bipush 88
    //   1150: putfield 3214	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1153: aload 15
    //   1155: ldc_w 515
    //   1158: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1161: pop
    //   1162: iload_2
    //   1163: bipush 7
    //   1165: if_icmplt +29 -> 1194
    //   1168: aload 15
    //   1170: ldc_w 3213
    //   1173: iload_2
    //   1174: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1177: pop
    //   1178: aload 11
    //   1180: bipush 86
    //   1182: putfield 3214	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1185: aload 15
    //   1187: ldc_w 515
    //   1190: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1193: pop
    //   1194: aload 15
    //   1196: ldc_w 3218
    //   1199: aload 11
    //   1201: invokevirtual 1672	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1204: pop
    //   1205: aload_0
    //   1206: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1209: aload 15
    //   1211: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1214: goto -662 -> 552
    //   1217: ldc 61
    //   1219: astore 11
    //   1221: aload_0
    //   1222: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1225: ifnull +87 -> 1312
    //   1228: aload_0
    //   1229: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1232: invokevirtual 2619	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1235: astore 11
    //   1237: new 932	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   1240: dup
    //   1241: aload 11
    //   1243: iconst_0
    //   1244: invokespecial 938	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   1247: astore 11
    //   1249: aload 15
    //   1251: ldc_w 3226
    //   1254: iconst_1
    //   1255: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1258: pop
    //   1259: aload 15
    //   1261: ldc_w 3216
    //   1264: iload_3
    //   1265: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1268: pop
    //   1269: aload 15
    //   1271: ldc_w 3218
    //   1274: aload 11
    //   1276: invokevirtual 1672	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1279: pop
    //   1280: aload 15
    //   1282: ldc_w 515
    //   1285: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1288: pop
    //   1289: aload 15
    //   1291: ldc_w 3224
    //   1294: lload 5
    //   1296: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1299: pop
    //   1300: aload_0
    //   1301: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1304: aload 15
    //   1306: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1309: goto -757 -> 552
    //   1312: aload_0
    //   1313: getfield 3208	bacn:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1316: ifnull -79 -> 1237
    //   1319: aload_0
    //   1320: getfield 3208	bacn:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1323: invokevirtual 3211	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1326: astore 11
    //   1328: goto -91 -> 1237
    //   1331: ldc 61
    //   1333: astore 11
    //   1335: goto -765 -> 570
    //   1338: iconst_0
    //   1339: istore 9
    //   1341: goto -1247 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1344	0	this	bacn
    //   164	352	1	i1	int
    //   241	933	2	i2	int
    //   278	987	3	i3	int
    //   315	168	4	i4	int
    //   57	1238	5	l1	long
    //   96	906	7	l2	long
    //   92	1248	9	bool1	boolean
    //   198	3	10	bool2	boolean
    //   54	1280	11	localObject	Object
    //   26	1054	12	str1	String
    //   191	117	13	str2	String
    //   353	1	13	localException1	Exception
    //   372	1	13	localException2	Exception
    //   391	6	13	str3	String
    //   409	1	13	localException3	Exception
    //   419	1	13	str4	String
    //   424	1	13	localException4	Exception
    //   433	1	13	str5	String
    //   438	1	13	localException5	Exception
    //   448	1	13	str6	String
    //   453	1	13	localException6	Exception
    //   607	80	13	str7	String
    //   635	69	14	str8	String
    //   475	830	15	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   111	132	353	java/lang/Exception
    //   145	165	372	java/lang/Exception
    //   165	193	409	java/lang/Exception
    //   193	200	409	java/lang/Exception
    //   396	406	409	java/lang/Exception
    //   208	236	424	java/lang/Exception
    //   236	242	424	java/lang/Exception
    //   242	270	438	java/lang/Exception
    //   270	279	438	java/lang/Exception
    //   279	307	453	java/lang/Exception
    //   307	317	453	java/lang/Exception
  }
  
  private boolean ax()
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
    if (g())
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        localObject1 = new rsi();
        ((rsi)localObject1).a(new ProfileParams.CurLoginUsr((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"), (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"))).d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")).c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).a(i1).b((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
        rtr.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((rsi)localObject1).a());
        return false;
      }
    }
    else
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("source", 117);
      rtr.a((Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, i1);
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
    }
    return true;
  }
  
  private boolean ay()
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
    rtr.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str, -7);
    return true;
  }
  
  private boolean az()
  {
    try
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      long l1 = Long.parseLong(str1);
      if (l1 < 10000L)
      {
        if (!QLog.isColorLevel()) {
          break label302;
        }
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard invalid uin uin: %d", new Object[] { Long.valueOf(l1) }));
        return false;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("name");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
      localFriends = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(str1);
      if (!azzz.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label236;
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
        label236:
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
      QLog.i("JumpAction", 4, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard uin: %s  name: %s source: %s", new Object[] { azzz.b(str1), azzz.b(str2), str3 }));
      return false;
    }
    label302:
    return false;
  }
  
  private Intent b()
  {
    ((spu)sqg.a(18)).a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  private String b()
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.MODEL;
    String str3 = befc.a("0db4c4");
    String str4 = befc.b("0db4c4");
    Object localObject = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindowManager().getDefaultDisplay();
    int i1 = ((Display)localObject).getHeight();
    int i2 = ((Display)localObject).getWidth();
    localObject = i2 + "*" + i1;
    i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid();
    return str1 + "|" + str2 + "|" + str3 + "|" + (String)localObject + "|" + str4 + "|" + i1 + "|";
  }
  
  private void b(int paramInt)
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
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap)
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
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, HashMap<String, String> paramHashMap, String paramString)
  {
    String str3 = (String)paramHashMap.get("videoOwnerUin");
    String str4 = (String)paramHashMap.get("unionid");
    String str1 = (String)paramHashMap.get("fromId");
    paramQQAppInterface = (String)paramHashMap.get("videoId");
    String str5 = (String)paramHashMap.get("type");
    String str2 = (String)paramHashMap.get("videoList");
    int i1 = a(paramHashMap);
    str2 = (String)paramHashMap.get("feedid");
    a(paramHashMap, "ptype", 0);
    label130:
    int i2;
    label149:
    int i4;
    label168:
    int i3;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = (String)paramHashMap.get("videoid");
      if (str1 == null)
      {
        str1 = (String)paramHashMap.get("fromid");
        if ((str5 == null) || (!str5.equals("mylist"))) {
          break label707;
        }
        i2 = 1;
        if ((str5 == null) || (!str5.equals("myonedaylist"))) {
          break label713;
        }
        i4 = 1;
        if (!"0".equals(paramHashMap.get("identify"))) {
          break label719;
        }
        i3 = 0;
        try
        {
          label187:
          if ("17".equals(str1))
          {
            if (i2 == 0) {
              break label285;
            }
            urp.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
          for (;;)
          {
            if (i4 == 0) {
              break label468;
            }
            paramString = (String)paramHashMap.get("collection_id");
            if (!TextUtils.isEmpty(paramString)) {
              break;
            }
            i2 = i1;
            if (i1 == 0) {
              i2 = 30;
            }
            tij.a(paramActivity, paramQQAppInterface, str2, i2);
            break label705;
            label285:
            urp.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", paramQQAppInterface });
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
          tij.a(paramActivity, str4, VideoCollectionEntry.getCollectionKey(1, paramString, str4), i2, i1, str2, i3, null);
          break label705;
        }
        if (TextUtils.isEmpty(str3)) {
          break label725;
        }
        tij.a(paramActivity, str3, VideoCollectionEntry.getCollectionKey(1, paramString, str3), i2, i1, str2, i3, null);
        break label705;
        label468:
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
              tij.a(paramActivity, str4, str2, i3, i1, 0, null);
              break label727;
            }
            if (TextUtils.isEmpty(str3)) {
              break label729;
            }
            tij.a(paramActivity, str3, str2, i3, i1, 0, null);
            break label727;
          }
          if ((!TextUtils.isEmpty(str5)) && (str5.equals(String.valueOf(1))))
          {
            i2 = i1;
            if (i1 == 0) {
              i2 = 57;
            }
            tij.b(paramActivity, paramQQAppInterface, str2, i2);
            break label727;
          }
          if (!"onedaylist".equals(str5)) {
            break label731;
          }
          tij.a(paramActivity, str4, str2, i3, i1, 0, null);
          break label727;
          tij.b(paramActivity, paramQQAppInterface, str2, i2);
          break label727;
        }
        label644:
        if (TextUtils.isEmpty(paramString)) {
          break label747;
        }
        i2 = i1;
        if (i1 == 0) {
          i2 = 19;
        }
        tij.b(paramActivity, paramQQAppInterface, str2, i2);
        break label727;
      }
    }
    for (;;)
    {
      tij.b(paramActivity, paramQQAppInterface, paramHashMap, i2);
      break label727;
      break label130;
      break;
      label705:
      return true;
      label707:
      i2 = 0;
      break label149;
      label713:
      i4 = 0;
      break label168;
      label719:
      i3 = 1;
      break label187;
      label725:
      return false;
      label727:
      return true;
      label729:
      return false;
      label731:
      i2 = i1;
      if (i1 != 0) {
        break label644;
      }
      i2 = 17;
      break label644;
      label747:
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
  
  private boolean bA()
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
      xbq.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, str2, str1, str3, i1, null);
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
  
  private boolean bB()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (baip.a(str)) {
      str = "0";
    }
    for (;;)
    {
      asdf localasdf = (asdf)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppInterface().getManager(204);
      long l1 = Long.parseLong(str);
      localasdf.a(l1, new bacu(this, l1));
      return true;
    }
  }
  
  private boolean bC()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomcode");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isgroupcode");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("backtype");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extra");
    aqkz localaqkz = (aqkz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
    try
    {
      i1 = Integer.parseInt(str3);
      QLog.i("JumpAction", 1, "[goToGroupVideoPlugin], roomId:" + str1 + ",fromId:" + str2 + " isGroupCode:" + str3);
      localaqkz.a(this.jdField_a_of_type_AndroidContentContext, str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), i1, "download", str2, str4, str5, str6);
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
  
  private boolean bD()
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
      azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject);
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
        label156:
        break label156;
      }
      azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject, str, i1);
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
                label306:
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
              break label306;
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
      localBundle.putString("selfSet_leftViewText", ajjy.a(2131640104));
      BulkSendMessageFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, localBundle);
    }
  }
  
  private boolean bE()
  {
    bbms localbbms = new bbms(this.jdField_a_of_type_AndroidContentContext, 0, 2131493080, 17);
    localbbms.a(this.jdField_a_of_type_AndroidContentContext.getString(2131624687));
    localbbms.getWindow().setDimAmount(0.0F);
    localbbms.show();
    localbbms.setCanceledOnTouchOutside(true);
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app");
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.e("JumpAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen jumpAction. appName=null");
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("meta");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(121);
    ArkAppMgr.getInstance().getAppPathByName(str1, str3, "0.0.0.1", "", new bacv(this, localbbms, str3, str2, str1));
    return true;
  }
  
  private boolean bF()
  {
    aqqi localaqqi = (aqqi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(338);
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
            localNewTogetherRoomMessageData.jdField_g_of_type_JavaLangString = str2;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localNewTogetherRoomMessageData.c = ((String)localObject2);
          }
          localaqqi.a(localNewTogetherRoomMessageData);
          return true;
          str1 = "0";
          break;
          str1 = "0";
          break label128;
        }
      }
    }
  }
  
  private boolean bG()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
    if ((str == null) || ("".equals(str)) || (str.length() < 5)) {
      return false;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject1 == null) {
        break label318;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label318;
      }
    }
    label318:
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
      ((Intent)localObject1).putExtra("key_is_update_before_805", azlj.a(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
      ((Intent)localObject1).putExtra("troop_manage_from_jump_action", true);
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new bgno(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      bfpy localbfpy = bfpy.a();
      localbfpy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localbfpy.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      bfpr.a((Activity)this.jdField_a_of_type_AndroidContentContext, localbfpy, -1);
      return true;
    }
    return false;
  }
  
  private boolean bb()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(str))
        {
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          bfpr.a((Activity)this.jdField_a_of_type_AndroidContentContext, bfpy.a(), str, 0, 0, 0);
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
  
  private boolean bc()
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
  
  private boolean bd()
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
  
  private boolean be()
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
          ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131625699));
          ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131626068));
          ((Intent)localObject).putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131626069));
          ((Intent)localObject).putExtra("param_max", 99);
          ((Intent)localObject).setFlags(603979776);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 1);
        }
      }
      do
      {
        return true;
        return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 3000, (String)localObject, true, true, this.jdField_a_of_type_Aagm, localHashMap);
        if (str3.equals("single"))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("forward_type", 13);
          ((Intent)localObject).putExtra("fromWebXman", true);
          aphp.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 2);
          return true;
        }
        if (!str3.equals("group")) {
          break;
        }
      } while (((String)localObject).equals("0"));
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jump_from");
      if ((!"gvideo".equals(str1)) && (!"gvideo_h5".equals(str1))) {
        break label624;
      }
    }
    label624:
    for (boolean bool = false;; bool = true)
    {
      return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, true, bool, this.jdField_a_of_type_Aagm, this.jdField_a_of_type_JavaUtilHashMap);
      return false;
    }
  }
  
  private boolean bf()
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
            break label766;
          }
          bool1 = true;
          if (i1 == 1006)
          {
            localObject2 = localObject5;
            if (!((String)localObject5).startsWith("+")) {
              localObject2 = "+" + (String)localObject5;
            }
            localObject3 = ((aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c((String)localObject2);
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
              return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, (String)localObject2, (String)localObject1, (String)localObject3, bool1, str1, bool2, true, this.jdField_a_of_type_Aagm, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
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
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131630348);
            }
            bool1 = true;
            bool2 = false;
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            continue;
          }
          i2 = babh.a(i1);
          if (i2 != -1) {
            continue;
          }
        }
        localObject4 = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, i1);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = localObject4;
          if (!((String)localObject1).equals(localObject4)) {}
        }
        else
        {
          localObject2 = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label744;
        }
        bool2 = true;
        localObject2 = localObject1;
        localObject4 = localObject5;
        continue;
        localObject4 = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, str1, i2, 0);
        continue;
      }
      return false;
      label744:
      boolean bool2 = true;
      Object localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject5;
      continue;
      label766:
      boolean bool1 = false;
    }
  }
  
  private boolean bg()
  {
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, "gotoRandomVideoChat");
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("chat_type");
    str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("request_type");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
    String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("session_name"));
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
              bool2 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1011, null, null, null, bool1, null, false, true, this.jdField_a_of_type_Aagm, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
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
  
  private boolean bh()
  {
    if (this.c.equals("jump"))
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
  private boolean bi()
  {
    // Byte code:
    //   0: new 106	android/content/Intent
    //   3: dup
    //   4: ldc_w 3075
    //   7: invokespecial 3044	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   10: astore 14
    //   12: aload_0
    //   13: aload 14
    //   15: invokespecial 1389	bacn:a	(Landroid/content/Intent;)V
    //   18: aconst_null
    //   19: astore 9
    //   21: aconst_null
    //   22: astore 8
    //   24: aconst_null
    //   25: astore 10
    //   27: aload_0
    //   28: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   31: invokevirtual 533	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   34: astore 12
    //   36: iconst_0
    //   37: istore_1
    //   38: ldc 61
    //   40: astore 11
    //   42: aload_0
    //   43: ldc_w 2010
    //   46: invokevirtual 829	bacn:b	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 13
    //   51: aload 13
    //   53: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +14 -> 70
    //   59: aload 14
    //   61: ldc_w 2162
    //   64: aload 13
    //   66: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   69: pop
    //   70: aload_0
    //   71: ldc_w 3734
    //   74: invokevirtual 829	bacn:b	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +62 -> 142
    //   83: aload 14
    //   85: ldc_w 2071
    //   88: invokestatic 2074	java/lang/System:nanoTime	()J
    //   91: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   94: pop
    //   95: aload 14
    //   97: ldc_w 1272
    //   100: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   103: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   106: pop
    //   107: aload 14
    //   109: ldc_w 1232
    //   112: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   115: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   118: pop
    //   119: aload 14
    //   121: ldc_w 2080
    //   124: iconst_1
    //   125: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   128: pop
    //   129: aload 14
    //   131: ldc_w 2078
    //   134: aload_0
    //   135: getfield 1285	bacn:jdField_h_of_type_Boolean	Z
    //   138: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   141: pop
    //   142: aload 12
    //   144: invokeinterface 539 1 0
    //   149: astore 15
    //   151: aload 15
    //   153: invokeinterface 544 1 0
    //   158: ifeq +631 -> 789
    //   161: aload 15
    //   163: invokeinterface 548 1 0
    //   168: checkcast 550	java/util/Map$Entry
    //   171: astore 12
    //   173: aload 12
    //   175: invokeinterface 557 1 0
    //   180: checkcast 50	java/lang/String
    //   183: astore 13
    //   185: aload 12
    //   187: invokeinterface 553 1 0
    //   192: checkcast 50	java/lang/String
    //   195: astore 12
    //   197: aload 13
    //   199: ifnull -48 -> 151
    //   202: aload 12
    //   204: ifnull -53 -> 151
    //   207: ldc_w 3736
    //   210: aload 13
    //   212: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   238: goto +2762 -> 3000
    //   241: ldc_w 3738
    //   244: aload 13
    //   246: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq +22 -> 271
    //   252: aload 11
    //   254: astore 8
    //   256: aload 9
    //   258: astore 11
    //   260: aload 10
    //   262: astore 9
    //   264: aload 12
    //   266: astore 10
    //   268: goto +2732 -> 3000
    //   271: ldc_w 3740
    //   274: aload 13
    //   276: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   279: ifeq +57 -> 336
    //   282: ldc_w 657
    //   285: aload 12
    //   287: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   290: ifeq +2737 -> 3027
    //   293: aload 14
    //   295: ldc_w 3077
    //   298: aload_0
    //   299: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   302: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   305: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
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
    //   333: goto +2667 -> 3000
    //   336: ldc_w 3742
    //   339: aload 13
    //   341: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   344: ifeq +89 -> 433
    //   347: ldc_w 657
    //   350: aload 12
    //   352: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   355: ifeq +2672 -> 3027
    //   358: aload_0
    //   359: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   362: invokevirtual 2362	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   365: astore 13
    //   367: aload 13
    //   369: astore 12
    //   371: aload 13
    //   373: invokestatic 3410	baip:a	(Ljava/lang/String;)Z
    //   376: ifeq +19 -> 395
    //   379: aload_0
    //   380: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   383: aload_0
    //   384: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   387: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   390: invokestatic 3079	babh:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   393: astore 12
    //   395: aload 14
    //   397: ldc_w 1602
    //   400: aload 12
    //   402: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
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
    //   430: goto +2570 -> 3000
    //   433: ldc_w 1970
    //   436: aload 13
    //   438: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   441: ifeq +57 -> 498
    //   444: ldc_w 657
    //   447: aload 12
    //   449: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   452: ifeq +2575 -> 3027
    //   455: aload 14
    //   457: ldc_w 3744
    //   460: aload_0
    //   461: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   464: invokevirtual 2002	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   467: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
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
    //   495: goto +2505 -> 3000
    //   498: ldc_w 3746
    //   501: aload 13
    //   503: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   506: ifeq +53 -> 559
    //   509: ldc_w 657
    //   512: aload 12
    //   514: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   517: ifeq +2510 -> 3027
    //   520: aload 14
    //   522: ldc_w 3748
    //   525: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   528: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
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
    //   556: goto +2444 -> 3000
    //   559: ldc_w 3750
    //   562: aload 13
    //   564: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   567: ifeq +90 -> 657
    //   570: ldc_w 657
    //   573: aload 12
    //   575: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   578: ifeq +2449 -> 3027
    //   581: aload 14
    //   583: ldc_w 3752
    //   586: aload_0
    //   587: getfield 3754	bacn:jdField_g_of_type_Boolean	Z
    //   590: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   593: pop
    //   594: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +2430 -> 3027
    //   600: ldc_w 3756
    //   603: iconst_2
    //   604: new 197	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 3758
    //   614: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_0
    //   618: getfield 3754	bacn:jdField_g_of_type_Boolean	Z
    //   621: invokevirtual 496	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   624: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 456	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   654: goto +2346 -> 3000
    //   657: ldc_w 3760
    //   660: aload 13
    //   662: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   665: ifeq +39 -> 704
    //   668: ldc_w 657
    //   671: aload 12
    //   673: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   676: ifeq +2351 -> 3027
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
    //   701: goto +2299 -> 3000
    //   704: ldc_w 3762
    //   707: aload 13
    //   709: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   739: goto +2261 -> 3000
    //   742: ldc_w 707
    //   745: aload 13
    //   747: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   773: goto +2227 -> 3000
    //   776: aload 14
    //   778: aload 13
    //   780: aload 12
    //   782: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   785: pop
    //   786: goto +2241 -> 3027
    //   789: aload 9
    //   791: ifnull +2263 -> 3054
    //   794: aload 8
    //   796: ifnull +2258 -> 3054
    //   799: ldc 61
    //   801: aload 9
    //   803: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   806: ifne +2248 -> 3054
    //   809: ldc 61
    //   811: aload 8
    //   813: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   816: ifeq +6 -> 822
    //   819: goto +2235 -> 3054
    //   822: aload_0
    //   823: getfield 3763	bacn:jdField_a_of_type_Boolean	Z
    //   826: ifeq +22 -> 848
    //   829: invokestatic 3768	badc:a	()Lbadc;
    //   832: aload_0
    //   833: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   836: aload 9
    //   838: aload 8
    //   840: invokevirtual 3771	badc:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   843: ifeq +5 -> 848
    //   846: iconst_0
    //   847: ireturn
    //   848: iconst_0
    //   849: istore 4
    //   851: iload 4
    //   853: istore_3
    //   854: aload 9
    //   856: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   859: ifne +38 -> 897
    //   862: getstatic 54	bacn:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
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
    //   889: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   892: ifeq +234 -> 1126
    //   895: iconst_1
    //   896: istore_3
    //   897: iload_3
    //   898: ifne +55 -> 953
    //   901: aload 14
    //   903: ldc_w 3744
    //   906: aconst_null
    //   907: checkcast 50	java/lang/String
    //   910: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   913: pop
    //   914: aload 14
    //   916: ldc_w 3773
    //   919: aconst_null
    //   920: checkcast 50	java/lang/String
    //   923: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   926: pop
    //   927: aload 14
    //   929: ldc_w 1602
    //   932: aconst_null
    //   933: checkcast 50	java/lang/String
    //   936: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   939: pop
    //   940: aload 14
    //   942: ldc_w 3077
    //   945: aconst_null
    //   946: checkcast 50	java/lang/String
    //   949: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   952: pop
    //   953: aload 8
    //   955: ldc_w 2297
    //   958: invokevirtual 1925	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   961: ifeq +112 -> 1073
    //   964: aload 14
    //   966: ldc_w 3775
    //   969: ldc_w 3777
    //   972: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   975: pop
    //   976: aload_0
    //   977: getfield 63	bacn:r	Ljava/lang/String;
    //   980: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   983: ifne +16 -> 999
    //   986: aload 14
    //   988: ldc_w 3779
    //   991: aload_0
    //   992: getfield 63	bacn:r	Ljava/lang/String;
    //   995: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   998: pop
    //   999: aload_0
    //   1000: getfield 65	bacn:s	Ljava/lang/String;
    //   1003: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1006: ifne +16 -> 1022
    //   1009: aload 14
    //   1011: ldc_w 3781
    //   1014: aload_0
    //   1015: getfield 65	bacn:s	Ljava/lang/String;
    //   1018: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1021: pop
    //   1022: aload_0
    //   1023: getfield 67	bacn:t	Ljava/lang/String;
    //   1026: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1029: ifne +16 -> 1045
    //   1032: aload 14
    //   1034: ldc_w 3783
    //   1037: aload_0
    //   1038: getfield 67	bacn:t	Ljava/lang/String;
    //   1041: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1044: pop
    //   1045: aload 14
    //   1047: ldc_w 3785
    //   1050: aload_0
    //   1051: getfield 3787	bacn:jdField_i_of_type_Boolean	Z
    //   1054: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1057: pop
    //   1058: aload 14
    //   1060: aload 8
    //   1062: invokestatic 3793	cooperation/qzone/report/lp/QZoneLoginReportHelper:needAddLoginFromLebaTab	(Landroid/content/Intent;Ljava/lang/String;)Z
    //   1065: ifeq +8 -> 1073
    //   1068: aload 14
    //   1070: invokestatic 3796	cooperation/qzone/report/lp/QZoneLoginReportHelper:setLoginFromLebaTab	(Landroid/content/Intent;)V
    //   1073: iload_1
    //   1074: ifne +1882 -> 2956
    //   1077: aload 8
    //   1079: ldc_w 2297
    //   1082: invokevirtual 1925	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1085: ifeq +104 -> 1189
    //   1088: aload 14
    //   1090: aload 8
    //   1092: invokestatic 2411	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1095: aload 14
    //   1097: ldc_w 517
    //   1100: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1103: pop
    //   1104: aload_0
    //   1105: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1108: checkcast 745	android/app/Activity
    //   1111: aload_0
    //   1112: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1115: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1118: aload 14
    //   1120: iconst_m1
    //   1121: invokestatic 3798	bfpr:c	(Landroid/app/Activity;Ljava/lang/String;Landroid/content/Intent;I)V
    //   1124: iconst_1
    //   1125: ireturn
    //   1126: iload_2
    //   1127: iconst_1
    //   1128: iadd
    //   1129: istore_2
    //   1130: goto -256 -> 874
    //   1133: astore 8
    //   1135: new 106	android/content/Intent
    //   1138: dup
    //   1139: aload_0
    //   1140: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1143: ldc_w 3800
    //   1146: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1149: astore 8
    //   1151: aload 8
    //   1153: ldc_w 515
    //   1156: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1159: pop
    //   1160: aload 8
    //   1162: aload 14
    //   1164: invokevirtual 2696	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   1167: pop
    //   1168: aload_0
    //   1169: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1172: aload 8
    //   1174: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1177: goto -53 -> 1124
    //   1180: astore 8
    //   1182: aload 8
    //   1184: invokevirtual 3801	android/content/ActivityNotFoundException:printStackTrace	()V
    //   1187: iconst_0
    //   1188: ireturn
    //   1189: aload 8
    //   1191: ldc_w 3803
    //   1194: invokevirtual 2062	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1197: ifeq +60 -> 1257
    //   1200: aload_0
    //   1201: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1204: aload_0
    //   1205: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1208: invokestatic 3063	aylv:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)V
    //   1211: aload_0
    //   1212: getfield 1285	bacn:jdField_h_of_type_Boolean	Z
    //   1215: ifeq +1841 -> 3056
    //   1218: ldc_w 372
    //   1221: astore 8
    //   1223: aload_0
    //   1224: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1227: ldc_w 2910
    //   1230: ldc_w 3805
    //   1233: ldc 61
    //   1235: ldc_w 3807
    //   1238: ldc_w 3809
    //   1241: iconst_0
    //   1242: iconst_0
    //   1243: ldc 61
    //   1245: ldc 61
    //   1247: ldc 61
    //   1249: aload 8
    //   1251: invokestatic 427	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1254: goto -130 -> 1124
    //   1257: aload 8
    //   1259: ldc_w 3811
    //   1262: invokevirtual 2062	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1265: istore 6
    //   1267: iload 6
    //   1269: ifeq +234 -> 1503
    //   1272: aload_0
    //   1273: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1276: checkcast 2351	android/support/v4/app/FragmentActivity
    //   1279: invokevirtual 2368	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   1282: astore 9
    //   1284: aload 9
    //   1286: ifnull -162 -> 1124
    //   1289: aload 9
    //   1291: invokevirtual 2373	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1294: ifnull -170 -> 1124
    //   1297: aload 9
    //   1299: invokevirtual 2373	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1302: invokevirtual 3813	com/tencent/mobileqq/activity/BaseChatPie:aJ	()V
    //   1305: aload 9
    //   1307: invokevirtual 2373	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1310: getfield 3816	com/tencent/mobileqq/activity/BaseChatPie:a	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1313: getfield 3817	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   1316: istore_1
    //   1317: aload 14
    //   1319: ldc_w 653
    //   1322: aload_0
    //   1323: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1326: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1329: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1332: pop
    //   1333: aload 14
    //   1335: ldc_w 3819
    //   1338: iload_1
    //   1339: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1342: pop
    //   1343: aload 14
    //   1345: ldc_w 3057
    //   1348: invokevirtual 815	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1351: astore 11
    //   1353: aload 14
    //   1355: ldc_w 3055
    //   1358: invokevirtual 815	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1361: astore 10
    //   1363: aload 14
    //   1365: ldc_w 3821
    //   1368: invokevirtual 815	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1371: astore 9
    //   1373: aload 11
    //   1375: ifnull +80 -> 1455
    //   1378: aload 10
    //   1380: ifnull +75 -> 1455
    //   1383: aload 11
    //   1385: invokestatic 3826	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1388: astore 11
    //   1390: aload 10
    //   1392: invokestatic 3826	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1395: astore 10
    //   1397: aload 14
    //   1399: ldc_w 391
    //   1402: new 197	java/lang/StringBuilder
    //   1405: dup
    //   1406: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1409: ldc_w 3090
    //   1412: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: aload 11
    //   1417: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1420: ldc_w 3095
    //   1423: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: aload 10
    //   1428: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1431: ldc_w 3828
    //   1434: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: aload 9
    //   1439: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1442: ldc_w 3830
    //   1445: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1451: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1454: pop
    //   1455: aload 14
    //   1457: aload_0
    //   1458: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1461: invokevirtual 3833	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1464: aload 8
    //   1466: invokevirtual 1224	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1469: pop
    //   1470: aload_0
    //   1471: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1474: checkcast 2727	com/tencent/mobileqq/app/BaseActivity
    //   1477: aload 14
    //   1479: bipush 18
    //   1481: invokevirtual 3654	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1484: ldc_w 3835
    //   1487: invokestatic 3838	xeq:a	(Ljava/lang/String;)V
    //   1490: goto -366 -> 1124
    //   1493: astore 8
    //   1495: aload 8
    //   1497: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   1500: goto -376 -> 1124
    //   1503: aload 8
    //   1505: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1508: ifne +288 -> 1796
    //   1511: aload 9
    //   1513: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1516: ifne +280 -> 1796
    //   1519: aload 8
    //   1521: ldc_w 3840
    //   1524: invokevirtual 1769	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1527: ifeq +269 -> 1796
    //   1530: aload 9
    //   1532: ldc 52
    //   1534: invokevirtual 1769	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1537: ifeq +259 -> 1796
    //   1540: new 644	java/lang/StringBuffer
    //   1543: dup
    //   1544: invokespecial 645	java/lang/StringBuffer:<init>	()V
    //   1547: astore 12
    //   1549: aload_0
    //   1550: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1553: ifnull +231 -> 1784
    //   1556: aload_0
    //   1557: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1560: getfield 3842	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1563: invokevirtual 1295	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1566: ifle +218 -> 1784
    //   1569: aload_0
    //   1570: getfield 3754	bacn:jdField_g_of_type_Boolean	Z
    //   1573: ifeq +211 -> 1784
    //   1576: aload 12
    //   1578: ldc_w 3844
    //   1581: invokevirtual 1973	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1584: pop
    //   1585: aload_0
    //   1586: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1589: getfield 3842	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1592: invokevirtual 3845	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1595: ifeq +38 -> 1633
    //   1598: aload 12
    //   1600: new 197	java/lang/StringBuilder
    //   1603: dup
    //   1604: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1607: ldc_w 3847
    //   1610: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: aload_0
    //   1614: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1617: getfield 3842	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1620: invokevirtual 1295	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1623: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1626: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1629: invokevirtual 1973	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1632: pop
    //   1633: aload_0
    //   1634: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1637: getfield 1333	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1640: invokevirtual 1337	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1643: istore 6
    //   1645: iload 6
    //   1647: ifeq +48 -> 1695
    //   1650: aload_0
    //   1651: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1654: getfield 1333	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1657: invokevirtual 1339	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1660: ldc_w 1071
    //   1663: invokestatic 1077	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1666: astore 10
    //   1668: aload 12
    //   1670: new 197	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1677: ldc_w 3849
    //   1680: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: aload 10
    //   1685: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1691: invokevirtual 1973	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1694: pop
    //   1695: aload_0
    //   1696: ldc_w 391
    //   1699: invokevirtual 829	bacn:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1702: astore 11
    //   1704: aload 11
    //   1706: astore 10
    //   1708: aload 11
    //   1710: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1713: ifne +27 -> 1740
    //   1716: aload 11
    //   1718: astore 10
    //   1720: aload 11
    //   1722: invokestatic 3853	vvp:g	(Ljava/lang/String;)Z
    //   1725: ifeq +15 -> 1740
    //   1728: aload 11
    //   1730: aload 12
    //   1732: invokevirtual 2013	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1735: invokestatic 3857	mof:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1738: astore 10
    //   1740: aload_0
    //   1741: aload 10
    //   1743: aload 9
    //   1745: aload 8
    //   1747: aload 14
    //   1749: invokespecial 3859	bacn:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1752: aload_0
    //   1753: aload 8
    //   1755: invokespecial 3861	bacn:g	(Ljava/lang/String;)V
    //   1758: goto -634 -> 1124
    //   1761: astore 10
    //   1763: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1766: ifeq +1298 -> 3064
    //   1769: ldc_w 435
    //   1772: iconst_2
    //   1773: aload 10
    //   1775: invokevirtual 3862	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   1778: invokestatic 456	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1781: goto +1283 -> 3064
    //   1784: aload 12
    //   1786: ldc_w 3864
    //   1789: invokevirtual 1973	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1792: pop
    //   1793: goto -98 -> 1695
    //   1796: aload 8
    //   1798: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1801: ifne +453 -> 2254
    //   1804: aload 9
    //   1806: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1809: ifne +445 -> 2254
    //   1812: aload 8
    //   1814: ldc_w 3866
    //   1817: invokevirtual 1769	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1820: ifeq +434 -> 2254
    //   1823: aload 9
    //   1825: ldc 52
    //   1827: invokevirtual 1769	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1830: ifeq +424 -> 2254
    //   1833: aload_0
    //   1834: ldc_w 391
    //   1837: invokevirtual 829	bacn:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1840: astore 10
    //   1842: aload 10
    //   1844: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1847: ifeq +382 -> 2229
    //   1850: ldc_w 3868
    //   1853: astore 10
    //   1855: new 197	java/lang/StringBuilder
    //   1858: dup
    //   1859: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1862: ldc_w 3870
    //   1865: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1868: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   1871: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1874: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1877: astore 12
    //   1879: aload 12
    //   1881: astore 11
    //   1883: aload_0
    //   1884: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1887: ifnull +51 -> 1938
    //   1890: aload 12
    //   1892: astore 11
    //   1894: invokestatic 3875	mkw:a	()Lmkw;
    //   1897: aload 10
    //   1899: invokevirtual 3877	mkw:i	(Ljava/lang/String;)Z
    //   1902: ifeq +36 -> 1938
    //   1905: new 197	java/lang/StringBuilder
    //   1908: dup
    //   1909: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1912: aload 12
    //   1914: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1917: ldc_w 3879
    //   1920: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: aload_0
    //   1924: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1927: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1930: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1933: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1936: astore 11
    //   1938: aload 11
    //   1940: astore 12
    //   1942: aload_0
    //   1943: getfield 1104	bacn:q	Ljava/lang/String;
    //   1946: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1949: ifne +33 -> 1982
    //   1952: new 197	java/lang/StringBuilder
    //   1955: dup
    //   1956: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1959: aload 11
    //   1961: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1964: ldc_w 1982
    //   1967: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1970: aload_0
    //   1971: getfield 1104	bacn:q	Ljava/lang/String;
    //   1974: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1977: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1980: astore 12
    //   1982: aload 12
    //   1984: astore 11
    //   1986: aload 10
    //   1988: ldc_w 1975
    //   1991: invokevirtual 2028	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1994: ifge +26 -> 2020
    //   1997: new 197	java/lang/StringBuilder
    //   2000: dup
    //   2001: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   2004: aload 12
    //   2006: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2009: ldc_w 3881
    //   2012: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2015: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2018: astore 11
    //   2020: aload 10
    //   2022: aload 11
    //   2024: invokestatic 3857	mof:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2027: astore 10
    //   2029: aload_0
    //   2030: ldc_w 3734
    //   2033: invokevirtual 829	bacn:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2036: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2039: ifne +958 -> 2997
    //   2042: aload_0
    //   2043: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2046: ifnull +951 -> 2997
    //   2049: aload_0
    //   2050: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2053: bipush 12
    //   2055: invokevirtual 348	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2058: checkcast 3883	awcl
    //   2061: astore 11
    //   2063: iconst_0
    //   2064: istore_1
    //   2065: aload_0
    //   2066: getfield 1285	bacn:jdField_h_of_type_Boolean	Z
    //   2069: ifeq +12 -> 2081
    //   2072: aload_0
    //   2073: getfield 1283	bacn:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   2076: iconst_1
    //   2077: invokestatic 3888	apxk:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;Z)I
    //   2080: istore_1
    //   2081: aload 11
    //   2083: invokevirtual 3891	awcl:a	()Lapxk;
    //   2086: iload_1
    //   2087: invokevirtual 3894	apxk:a	(I)Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;
    //   2090: astore 11
    //   2092: aload 11
    //   2094: ifnull +903 -> 2997
    //   2097: ldc_w 435
    //   2100: iconst_2
    //   2101: iconst_2
    //   2102: anewarray 4	java/lang/Object
    //   2105: dup
    //   2106: iconst_0
    //   2107: ldc_w 3896
    //   2110: aastore
    //   2111: dup
    //   2112: iconst_1
    //   2113: aload 11
    //   2115: aastore
    //   2116: invokestatic 967	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2119: aload 10
    //   2121: ldc_w 3898
    //   2124: invokestatic 3857	mof:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2127: astore 10
    //   2129: aload 11
    //   2131: aload 14
    //   2133: invokestatic 3901	apxk:a	(Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;Landroid/content/Intent;)Landroid/content/Intent;
    //   2136: pop
    //   2137: aload_0
    //   2138: aload 10
    //   2140: aload 9
    //   2142: aload 8
    //   2144: aload 14
    //   2146: invokespecial 3859	bacn:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2149: aload_0
    //   2150: aload 8
    //   2152: invokespecial 3861	bacn:g	(Ljava/lang/String;)V
    //   2155: aload_0
    //   2156: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2159: ifnull +37 -> 2196
    //   2162: aload_0
    //   2163: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2166: ldc_w 3903
    //   2169: invokevirtual 3907	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   2172: astore 8
    //   2174: aload 8
    //   2176: ifnull +20 -> 2196
    //   2179: aload 8
    //   2181: aload 8
    //   2183: ldc_w 3908
    //   2186: invokevirtual 3912	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   2189: ldc2_w 3913
    //   2192: invokevirtual 3918	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   2195: pop
    //   2196: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2199: ifeq +13 -> 2212
    //   2202: ldc_w 435
    //   2205: iconst_2
    //   2206: ldc_w 3920
    //   2209: invokestatic 439	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2212: new 3922	com/tencent/mobileqq/utils/JumpAction$16
    //   2215: dup
    //   2216: aload_0
    //   2217: invokespecial 3923	com/tencent/mobileqq/utils/JumpAction$16:<init>	(Lbacn;)V
    //   2220: iconst_5
    //   2221: aconst_null
    //   2222: iconst_1
    //   2223: invokestatic 1406	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2226: goto -1102 -> 1124
    //   2229: aload 10
    //   2231: invokestatic 1606	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   2234: astore 10
    //   2236: goto -381 -> 1855
    //   2239: astore 10
    //   2241: aload 10
    //   2243: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   2246: ldc_w 3868
    //   2249: astore 10
    //   2251: goto -396 -> 1855
    //   2254: aload 8
    //   2256: ldc_w 3925
    //   2259: invokevirtual 2062	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2262: ifeq +170 -> 2432
    //   2265: aload_0
    //   2266: ldc_w 416
    //   2269: invokevirtual 829	bacn:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2272: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2275: ifne +52 -> 2327
    //   2278: aload 14
    //   2280: ldc_w 3927
    //   2283: iconst_4
    //   2284: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2287: pop
    //   2288: aload 14
    //   2290: ldc_w 3929
    //   2293: aload 14
    //   2295: ldc_w 3929
    //   2298: iconst_1
    //   2299: invokevirtual 825	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2302: iconst_4
    //   2303: ior
    //   2304: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2307: pop
    //   2308: aload_0
    //   2309: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2312: aload_0
    //   2313: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2316: checkcast 745	android/app/Activity
    //   2319: aload 14
    //   2321: invokestatic 3934	bgmq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2324: goto -1200 -> 1124
    //   2327: aload_0
    //   2328: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2331: ldc_w 1160
    //   2334: ldc 61
    //   2336: ldc 61
    //   2338: ldc_w 3936
    //   2341: ldc_w 3936
    //   2344: iconst_0
    //   2345: iconst_0
    //   2346: ldc 61
    //   2348: ldc 61
    //   2350: ldc 61
    //   2352: ldc 61
    //   2354: iconst_0
    //   2355: invokestatic 2919	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2358: invokestatic 3941	qji:a	()Lqji;
    //   2361: invokestatic 3941	qji:a	()Lqji;
    //   2364: invokevirtual 3942	qji:b	()Z
    //   2367: ldc_w 3944
    //   2370: iconst_1
    //   2371: invokevirtual 3947	qji:a	(ZLjava/lang/String;I)V
    //   2374: aload 14
    //   2376: ldc_w 3927
    //   2379: iconst_1
    //   2380: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2383: pop
    //   2384: aload 14
    //   2386: ldc_w 3949
    //   2389: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   2392: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2395: pop
    //   2396: aload_0
    //   2397: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2400: bipush 96
    //   2402: invokevirtual 348	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2405: checkcast 3951	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager
    //   2408: aload 14
    //   2410: invokevirtual 3952	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager:a	(Landroid/content/Intent;)V
    //   2413: aload_0
    //   2414: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2417: aload_0
    //   2418: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2421: checkcast 745	android/app/Activity
    //   2424: aload 14
    //   2426: invokestatic 3934	bgmq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2429: goto -1305 -> 1124
    //   2432: aload 8
    //   2434: ldc_w 3803
    //   2437: invokevirtual 2062	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2440: ifeq +14 -> 2454
    //   2443: aload 14
    //   2445: ldc_w 416
    //   2448: bipush 15
    //   2450: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2453: pop
    //   2454: aload 8
    //   2456: ldc_w 3954
    //   2459: invokevirtual 2062	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2462: ifeq +16 -> 2478
    //   2465: aload 14
    //   2467: ldc_w 3956
    //   2470: aload_0
    //   2471: getfield 1861	bacn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2474: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2477: pop
    //   2478: aload 8
    //   2480: getstatic 3957	cooperation/comic/VipComicJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2483: invokevirtual 2062	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2486: ifeq +39 -> 2525
    //   2489: aload 14
    //   2491: invokestatic 3960	cooperation/comic/VipComicJumpActivity:a	(Landroid/content/Intent;)Lbezj;
    //   2494: astore 11
    //   2496: aload_0
    //   2497: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2500: aload_0
    //   2501: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2504: checkcast 745	android/app/Activity
    //   2507: aload 11
    //   2509: invokestatic 3963	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lbezj;)Z
    //   2512: ifeq +13 -> 2525
    //   2515: aload_0
    //   2516: getfield 97	bacn:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2519: iconst_1
    //   2520: invokestatic 3966	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Z)V
    //   2523: iconst_1
    //   2524: ireturn
    //   2525: aload 9
    //   2527: ifnull -1403 -> 1124
    //   2530: aload 9
    //   2532: invokestatic 327	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2535: invokevirtual 3967	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   2538: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2541: istore 6
    //   2543: iload 6
    //   2545: ifeq +371 -> 2916
    //   2548: iconst_0
    //   2549: istore 6
    //   2551: ldc_w 3969
    //   2554: invokestatic 327	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2557: invokevirtual 3973	com/tencent/qphone/base/util/BaseApplication:getClassLoader	()Ljava/lang/ClassLoader;
    //   2560: aload 8
    //   2562: invokevirtual 3979	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   2565: invokevirtual 3983	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   2568: istore 7
    //   2570: iload 7
    //   2572: istore 6
    //   2574: iload 6
    //   2576: ifeq +5 -> 2581
    //   2579: iconst_0
    //   2580: ireturn
    //   2581: aload 14
    //   2583: ldc_w 3985
    //   2586: invokevirtual 815	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2589: astore 11
    //   2591: aload 11
    //   2593: ifnull +399 -> 2992
    //   2596: aload 11
    //   2598: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2601: istore_1
    //   2602: aload 8
    //   2604: ldc_w 3987
    //   2607: invokevirtual 1769	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2610: ifeq +189 -> 2799
    //   2613: ldc_w 3989
    //   2616: astore 8
    //   2618: ldc_w 3991
    //   2621: aload 8
    //   2623: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2626: ifeq +205 -> 2831
    //   2629: aload 14
    //   2631: ldc_w 3993
    //   2634: invokevirtual 815	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2637: astore 12
    //   2639: aload 8
    //   2641: astore 11
    //   2643: aload 12
    //   2645: ifnull +38 -> 2683
    //   2648: aload 8
    //   2650: astore 11
    //   2652: aload 12
    //   2654: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2657: iconst_2
    //   2658: if_icmpne +25 -> 2683
    //   2661: iload_1
    //   2662: invokestatic 3998	bcpn:b	(I)Z
    //   2665: ifeq +412 -> 3077
    //   2668: ldc_w 4000
    //   2671: astore 11
    //   2673: aload 14
    //   2675: ldc_w 3985
    //   2678: iload_1
    //   2679: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2682: pop
    //   2683: aload 10
    //   2685: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2688: ifne +130 -> 2818
    //   2691: aload 10
    //   2693: invokevirtual 4003	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2696: ldc_w 2212
    //   2699: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2702: ifeq +116 -> 2818
    //   2705: aload 14
    //   2707: ldc_w 2749
    //   2710: bipush 117
    //   2712: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2715: pop
    //   2716: aload 14
    //   2718: ldc_w 402
    //   2721: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2724: pop
    //   2725: aload 11
    //   2727: astore 8
    //   2729: ldc_w 4005
    //   2732: aload 8
    //   2734: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2737: ifeq +151 -> 2888
    //   2740: aload 14
    //   2742: ldc_w 391
    //   2745: invokevirtual 815	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2748: astore 10
    //   2750: aload 10
    //   2752: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2755: ifne +133 -> 2888
    //   2758: aload 10
    //   2760: ldc_w 2541
    //   2763: invokevirtual 1925	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2766: ifne +122 -> 2888
    //   2769: ldc_w 435
    //   2772: iconst_1
    //   2773: new 197	java/lang/StringBuilder
    //   2776: dup
    //   2777: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   2780: ldc_w 4007
    //   2783: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2786: aload 10
    //   2788: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2791: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2794: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2797: iconst_0
    //   2798: ireturn
    //   2799: aload 8
    //   2801: ldc_w 4009
    //   2804: invokevirtual 1769	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2807: ifeq +182 -> 2989
    //   2810: ldc_w 3991
    //   2813: astore 8
    //   2815: goto -197 -> 2618
    //   2818: aload 14
    //   2820: ldc_w 2749
    //   2823: iconst_2
    //   2824: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2827: pop
    //   2828: goto -112 -> 2716
    //   2831: ldc_w 3989
    //   2834: aload 8
    //   2836: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2839: ifeq +28 -> 2867
    //   2842: iload_1
    //   2843: invokestatic 3998	bcpn:b	(I)Z
    //   2846: ifeq -117 -> 2729
    //   2849: ldc_w 4000
    //   2852: astore 8
    //   2854: aload 14
    //   2856: ldc_w 3985
    //   2859: iload_1
    //   2860: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2863: pop
    //   2864: goto -135 -> 2729
    //   2867: aload 14
    //   2869: ldc_w 1226
    //   2872: invokevirtual 1230	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   2875: pop
    //   2876: aload 14
    //   2878: ldc_w 515
    //   2881: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2884: pop
    //   2885: goto -156 -> 2729
    //   2888: aload 14
    //   2890: aload 9
    //   2892: aload 8
    //   2894: invokevirtual 1224	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2897: pop
    //   2898: aload_0
    //   2899: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2902: aload 14
    //   2904: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2907: aload_0
    //   2908: aload 8
    //   2910: invokespecial 3861	bacn:g	(Ljava/lang/String;)V
    //   2913: goto -1789 -> 1124
    //   2916: aload 14
    //   2918: aload 9
    //   2920: aload 8
    //   2922: invokevirtual 1224	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2925: pop
    //   2926: aload 14
    //   2928: ldc_w 1226
    //   2931: invokevirtual 1230	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   2934: pop
    //   2935: aload 14
    //   2937: ldc_w 515
    //   2940: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2943: pop
    //   2944: aload_0
    //   2945: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2948: aload 14
    //   2950: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2953: goto -1829 -> 1124
    //   2956: iload_1
    //   2957: iconst_1
    //   2958: if_icmpne -1834 -> 1124
    //   2961: aload 11
    //   2963: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2966: ifne -1842 -> 1124
    //   2969: aload_0
    //   2970: aload 14
    //   2972: aload 8
    //   2974: aload 11
    //   2976: invokespecial 3083	bacn:a	(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Z
    //   2979: istore 6
    //   2981: iload 6
    //   2983: ireturn
    //   2984: astore 11
    //   2986: goto -412 -> 2574
    //   2989: goto -371 -> 2618
    //   2992: iconst_0
    //   2993: istore_1
    //   2994: goto -392 -> 2602
    //   2997: goto -860 -> 2137
    //   3000: aload 10
    //   3002: astore 12
    //   3004: aload 11
    //   3006: astore 13
    //   3008: aload 8
    //   3010: astore 11
    //   3012: aload 9
    //   3014: astore 10
    //   3016: aload 12
    //   3018: astore 8
    //   3020: aload 13
    //   3022: astore 9
    //   3024: goto -2873 -> 151
    //   3027: aload 8
    //   3029: astore 12
    //   3031: aload 9
    //   3033: astore 13
    //   3035: aload 11
    //   3037: astore 8
    //   3039: aload 10
    //   3041: astore 9
    //   3043: aload 12
    //   3045: astore 10
    //   3047: aload 13
    //   3049: astore 11
    //   3051: goto -51 -> 3000
    //   3054: iconst_0
    //   3055: ireturn
    //   3056: ldc_w 657
    //   3059: astore 8
    //   3061: goto -1838 -> 1223
    //   3064: aconst_null
    //   3065: astore 10
    //   3067: goto -1399 -> 1668
    //   3070: astore 11
    //   3072: iconst_0
    //   3073: istore_1
    //   3074: goto -472 -> 2602
    //   3077: ldc_w 3989
    //   3080: astore 11
    //   3082: goto -399 -> 2683
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3085	0	this	bacn
    //   37	3037	1	i1	int
    //   873	257	2	i2	int
    //   853	45	3	i3	int
    //   849	26	4	i4	int
    //   870	11	5	i5	int
    //   1265	1717	6	bool1	boolean
    //   2568	3	7	bool2	boolean
    //   22	1069	8	localObject1	Object
    //   1133	1	8	localException1	Exception
    //   1149	24	8	localIntent1	Intent
    //   1180	10	8	localActivityNotFoundException	android.content.ActivityNotFoundException
    //   1221	244	8	str1	String
    //   1493	658	8	localException2	Exception
    //   2172	888	8	localObject2	Object
    //   19	3023	9	localObject3	Object
    //   25	1717	10	localObject4	Object
    //   1761	13	10	localUnsupportedEncodingException	UnsupportedEncodingException
    //   1840	395	10	str2	String
    //   2239	3	10	localException3	Exception
    //   2249	817	10	localObject5	Object
    //   40	2935	11	localObject6	Object
    //   2984	21	11	localException4	Exception
    //   3010	40	11	localObject7	Object
    //   3070	1	11	localException5	Exception
    //   3080	1	11	str3	String
    //   34	3010	12	localObject8	Object
    //   49	2999	13	localObject9	Object
    //   10	2961	14	localIntent2	Intent
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
    //   1383	1455	1180	android/content/ActivityNotFoundException
    //   1455	1490	1180	android/content/ActivityNotFoundException
    //   1495	1500	1180	android/content/ActivityNotFoundException
    //   1503	1633	1180	android/content/ActivityNotFoundException
    //   1633	1645	1180	android/content/ActivityNotFoundException
    //   1650	1668	1180	android/content/ActivityNotFoundException
    //   1668	1695	1180	android/content/ActivityNotFoundException
    //   1695	1704	1180	android/content/ActivityNotFoundException
    //   1708	1716	1180	android/content/ActivityNotFoundException
    //   1720	1740	1180	android/content/ActivityNotFoundException
    //   1740	1758	1180	android/content/ActivityNotFoundException
    //   1763	1781	1180	android/content/ActivityNotFoundException
    //   1784	1793	1180	android/content/ActivityNotFoundException
    //   1796	1850	1180	android/content/ActivityNotFoundException
    //   1855	1879	1180	android/content/ActivityNotFoundException
    //   1883	1890	1180	android/content/ActivityNotFoundException
    //   1894	1938	1180	android/content/ActivityNotFoundException
    //   1942	1982	1180	android/content/ActivityNotFoundException
    //   1986	2020	1180	android/content/ActivityNotFoundException
    //   2020	2063	1180	android/content/ActivityNotFoundException
    //   2065	2081	1180	android/content/ActivityNotFoundException
    //   2081	2092	1180	android/content/ActivityNotFoundException
    //   2097	2137	1180	android/content/ActivityNotFoundException
    //   2137	2174	1180	android/content/ActivityNotFoundException
    //   2179	2196	1180	android/content/ActivityNotFoundException
    //   2196	2212	1180	android/content/ActivityNotFoundException
    //   2212	2226	1180	android/content/ActivityNotFoundException
    //   2229	2236	1180	android/content/ActivityNotFoundException
    //   2241	2246	1180	android/content/ActivityNotFoundException
    //   2254	2324	1180	android/content/ActivityNotFoundException
    //   2327	2429	1180	android/content/ActivityNotFoundException
    //   2432	2454	1180	android/content/ActivityNotFoundException
    //   2454	2478	1180	android/content/ActivityNotFoundException
    //   2478	2523	1180	android/content/ActivityNotFoundException
    //   2530	2543	1180	android/content/ActivityNotFoundException
    //   2551	2570	1180	android/content/ActivityNotFoundException
    //   2581	2591	1180	android/content/ActivityNotFoundException
    //   2596	2602	1180	android/content/ActivityNotFoundException
    //   2602	2613	1180	android/content/ActivityNotFoundException
    //   2618	2639	1180	android/content/ActivityNotFoundException
    //   2652	2668	1180	android/content/ActivityNotFoundException
    //   2673	2683	1180	android/content/ActivityNotFoundException
    //   2683	2716	1180	android/content/ActivityNotFoundException
    //   2716	2725	1180	android/content/ActivityNotFoundException
    //   2729	2797	1180	android/content/ActivityNotFoundException
    //   2799	2810	1180	android/content/ActivityNotFoundException
    //   2818	2828	1180	android/content/ActivityNotFoundException
    //   2831	2842	1180	android/content/ActivityNotFoundException
    //   2842	2849	1180	android/content/ActivityNotFoundException
    //   2854	2864	1180	android/content/ActivityNotFoundException
    //   2867	2885	1180	android/content/ActivityNotFoundException
    //   2888	2913	1180	android/content/ActivityNotFoundException
    //   2916	2953	1180	android/content/ActivityNotFoundException
    //   2961	2981	1180	android/content/ActivityNotFoundException
    //   1272	1284	1493	java/lang/Exception
    //   1289	1373	1493	java/lang/Exception
    //   1383	1455	1493	java/lang/Exception
    //   1455	1490	1493	java/lang/Exception
    //   1650	1668	1761	java/io/UnsupportedEncodingException
    //   2229	2236	2239	java/lang/Exception
    //   2551	2570	2984	java/lang/Exception
    //   2596	2602	3070	java/lang/Exception
  }
  
  private boolean bj()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492C", "0X800492C", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.e("qqdataline", 2, "shareFromMigSdk|report send from sdk:0X800492C.");
    }
    Object localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    String str2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    Object localObject2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    Object localObject4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    a((String)this.jdField_a_of_type_JavaUtilHashMap.get("previewimagedata"));
    String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    Object localObject6 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    if (!TextUtils.isEmpty(this.n)) {}
    for (localObject1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; localObject1 = null)
    {
      Object localObject7 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
      String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      String str3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
      String str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
      String str7 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
      int i2 = 0;
      try
      {
        i1 = Integer.valueOf(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
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
          localBundle.putString("pkg_name", this.n);
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
                  break label818;
                }
                localBundle.putString("audio_url", (String)localObject7);
                if ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject4)))
                {
                  if (TextUtils.isEmpty((CharSequence)localObject1)) {
                    break;
                  }
                  localBundle.putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131632442), new Object[] { localObject1 }));
                }
                com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
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
            label818:
            label895:
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
                  localException2.putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131632443));
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
                        break label895;
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
                        break label1192;
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
                              break label1182;
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
                    if (apck.a((String)localObject1) == 0)
                    {
                      localException2.putInt("req_type", 5);
                    }
                    else
                    {
                      localException2.putString("forward_text", ajjy.a(2131640111) + apck.a((String)localObject1) + ajjy.a(2131640112) + apdh.a(apdh.a((String)localObject1)) + "。");
                      localException2.putBoolean("qdshare_file", true);
                      localException2.putBoolean("isFromShare", true);
                      localException2.putBoolean("key_sdk_share_pure_text", true);
                      localException2.putInt("req_type", 6);
                    }
                  }
                  else if (apck.a(localObject3) == 0)
                  {
                    localException2.putString("title", ((ArrayList)localObject6).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131629087));
                    localException2.putString("qqfav_extra_multi_pic_path_list", str2);
                    localException2.putBoolean("qqfav_extra_multi_pic", true);
                    localException2.putInt("req_type", 1);
                  }
                  else
                  {
                    localObject1 = ((ArrayList)localObject6).iterator();
                    for (l1 = 0L; ((Iterator)localObject1).hasNext(); l1 = apdh.a((String)((Iterator)localObject1).next()) + l1) {}
                    localException2.putString("forward_text", ajjy.a(2131640118) + apck.a(localObject3) + ajjy.a(2131640106) + ((ArrayList)localObject6).size() + ajjy.a(2131640119) + apdh.a(l1));
                    localException2.putString("qqfav_extra_multi_pic_path_list", str2);
                    localException2.putBoolean("qdshare_file", true);
                    localException2.putBoolean("isFromShare", true);
                    localException2.putBoolean("key_sdk_share_pure_text", true);
                    localException2.putInt("req_type", 6);
                  }
                }
              }
            } while (1 == i1);
            label1182:
            label1192:
            return false;
          }
        }
      }
    }
  }
  
  private boolean bk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, " source:" + this.jdField_a_of_type_JavaLangString + "  serverName:" + this.jdField_b_of_type_JavaLangString + "  hostName:" + this.c);
    }
    Object localObject1;
    if (this.c.equals("index"))
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
              if (!this.c.equals("detail")) {
                break;
              }
            } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
            localObject1 = bcax.f() + File.separator + "qapp_center_detail.htm";
            if (new File((String)localObject1).exists()) {}
            for (localObject1 = "file:///" + (String)localObject1;; localObject1 = bcax.l() + File.separator + "qapp_center_detail.htm")
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
            if (!this.c.equals("webview")) {
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
        } while ((!this.c.equals("local")) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
        localObject2 = Uri.parse(this.jdField_a_of_type_JavaLangString);
        localObject1 = ((Uri)localObject2).getQueryParameter("title");
        localObject3 = bcax.a(((Uri)localObject2).getQueryParameter("url"));
      } while (localObject3.length <= 1);
      localObject2 = localObject3[0];
    } while ((!((String)localObject2).startsWith("file://")) || ((!((String)localObject2).contains(bcax.f())) && (!((String)localObject2).contains("android_asset/Page/system/"))));
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
  
  private boolean bl()
  {
    bffc.a(this.jdField_a_of_type_AndroidContentContext, 9, null);
    return true;
  }
  
  private boolean bm()
  {
    return true;
  }
  
  private boolean bn()
  {
    return true;
  }
  
  private boolean bo()
  {
    String str3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    if (!TextUtils.isEmpty(this.n)) {}
    Object localObject2;
    for (Object localObject1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));; localObject2 = null)
    {
      Object localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
      String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
      try
      {
        str1 = URLDecoder.decode(str1, "UTF-8");
        str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("troopbar_id"));
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
              ((Intent)localObject1).putExtra("pkg_name", this.n);
              com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
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
  
  private boolean bp()
  {
    String str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if (TextUtils.isEmpty(str)) {
      str = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      yds.a().a(1);
      yds.a().jdField_a_of_type_JavaLangString = "";
      yds.a().jdField_a_of_type_Int = 0;
      yds.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 2);
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        DeviceScanner.openDeviceQCodeUrl((Activity)this.jdField_a_of_type_AndroidContentContext, null, str);
      }
      return true;
    }
  }
  
  private boolean bq()
  {
    Object localObject2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      try
      {
        localObject1 = befm.a((String)localObject1);
        if (((Map)localObject1).get("public_device") != null)
        {
          i1 = 1;
          localObject2 = befm.b((String)((Map)localObject1).get("args"));
          localObject1 = (String)((Map)localObject2).get("sn");
          localObject2 = (String)((Map)localObject2).get("pid");
          if ((i1 != 0) && ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))))
          {
            bcec.a().a(this.jdField_a_of_type_AndroidContentContext.getString(2131654817));
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
  
  private boolean br()
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
    aphp.a(this.jdField_a_of_type_AndroidContentContext, localIntent);
    return true;
  }
  
  private boolean bs()
  {
    Object localObject = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("friendUin"));
    localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, "", 3001, 11, "", "", null, "", "");
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean bt()
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
  
  private boolean bu()
  {
    if ("open".equals(this.c))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 8855);
      return true;
    }
    if ("openVideo".equalsIgnoreCase(this.c))
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, null);
      }
      return false;
    }
    if ("opencontent".equals(this.c)) {
      return a(this.jdField_a_of_type_JavaUtilHashMap, false);
    }
    if ("opendiscovery".equals(this.c)) {
      return bw();
    }
    if ("opentopic".equals(this.c)) {
      return bv();
    }
    if ("infoCard".equals(this.c)) {
      return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    if ("sharegroupcard".equals(this.c)) {
      return b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    Object localObject = new uaz((Activity)this.jdField_a_of_type_AndroidContentContext, new bact(this));
    Intent localIntent = e(new Intent());
    if (localIntent != null)
    {
      int i1 = localIntent.getIntExtra("action", 0);
      localIntent.putExtra("action", 0);
      return ((uaz)localObject).a(i1, localIntent);
    }
    return false;
  }
  
  private boolean bv()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname");
    c((String)this.jdField_a_of_type_JavaUtilHashMap.get("sharefromtype"));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
      return true;
    }
    return false;
  }
  
  private boolean bw()
  {
    if (!TextUtils.isEmpty(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api")))) {
      urp.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      if ("1".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"))) {}
      return true;
    }
    return false;
  }
  
  private boolean bx()
  {
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean)
    {
      urk.b("JumpAction", "startStoryMainActivity, isNowTabShow==true");
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
        urk.e("JumpAction", "Error: context is not instanceof Activity, context is: " + String.valueOf(this.jdField_a_of_type_AndroidContentContext));
      }
      if (localIntent == null) {
        urk.e("JumpAction", "Error: jumpIntent is null");
      }
      return false;
    }
    urk.b("JumpAction", "startStoryMainActivity, isNowTabShow==false");
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
  
  private boolean by()
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
          break label282;
        }
        localIntent.putExtra("key_report_extra_from", 5);
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localIntent.putExtra("invite_code", (String)localObject);
      }
      label282:
      for (int i1 = 1;; i1 = 0)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) && (i1 != 0) && (!bool))
        {
          localIntent.putExtra("action", 4097);
          abju.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, TranslucentTRansferFragment.class);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096FF", "0X80096FF", 0, 0, "", "", "", "");
          return true;
          str = "";
          break;
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096FE", "0X80096FE", 0, 0, "", "", "", "");
        return true;
      }
    }
  }
  
  private boolean bz()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80077DE", "0X80077DE", 0, 0, (String)localObject, "", "", "");
    localObject = a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
    if (RegisterPhoneNumActivity.class == localObject) {
      localIntent.putExtra("key_report_extra_from", 5);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private String c()
  {
    return "mqqapi://" + this.jdField_b_of_type_JavaLangString + "/" + this.c + "?src_type=" + this.jdField_f_of_type_JavaLangString;
  }
  
  public static String c(String paramString)
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
  
  private void c(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("thridparty_pull_main", true);
    localIntent.addFlags(67108864);
    localIntent.addFlags(268435456);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
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
        break label342;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extuin");
      if (this.jdField_a_of_type_JavaUtilHashMap.get("name") == null) {
        break label349;
      }
      str2 = a(((String)this.jdField_a_of_type_JavaUtilHashMap.get("name")).replace(" ", "+"));
      bcqv localbcqv = (bcqv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
      boolean bool = false;
      if (this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag") == null) {
        break label356;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag");
      label203:
      if (!TextUtils.isEmpty(str3)) {
        bool = bcpn.b(Integer.valueOf(str3).intValue());
      }
      localbcqv.a(str4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, str1, paramString, bool);
      localObject = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject == null) || (!((ajjj)localObject).b(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label363;
      }
      localObject = new atwx();
      ((atwx)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramString, 1);
      ((atwx)localObject).jdField_a_of_type_ArrayOfJavaLangString = new String[7];
      ((atwx)localObject).jdField_a_of_type_ArrayOfJavaLangString[4] = str2;
      FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (atwx)localObject);
    }
    for (;;)
    {
      return true;
      localObject = "";
      break;
      label342:
      str1 = "";
      break label119;
      label349:
      str2 = "";
      break label159;
      label356:
      str3 = "";
      break label203;
      label363:
      paramString = AddFriendLogicActivity.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, paramString, null, 3999, 0, str2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131625011), null);
      paramString.putExtra("webImVisitId", str4);
      paramString.putExtra("webim_qd_ext", true);
      if (BaseActivity.sTopActivity == null) {
        paramString.putExtra("need_jumpto_splash", true);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
    }
  }
  
  private String d(String paramString)
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
  
  private void d()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_weishi_feeds_plugin.apk");
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  private boolean d(String paramString)
  {
    String str2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
    String str3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
    String str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    Object localObject1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
    String str6 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("audioUrl"));
    String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str7 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
    String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    Object localObject2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str9 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qq_ext_str"));
    String str10 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_program_appid"));
    String str11 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_program_path"));
    if (this.jdField_a_of_type_JavaUtilHashMap.get("mini_program_type") != null) {}
    for (int i1 = Integer.valueOf(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_program_type"))).intValue();; i1 = 3)
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
        i2 = Integer.valueOf(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag"))).intValue();
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          for (;;)
          {
            i3 = Integer.valueOf((String)localObject2).intValue();
            if (localObject1 != null) {
              break label1032;
            }
            localObject1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
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
          label1032:
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
                localBundle.putString("pkg_name", this.n);
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
                com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
                paramString = new bacr(this);
                if ((i3 == 5) && ((i2 & 0x1) != 0)) {
                  bfqn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localBundle, paramString, 23);
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
                      bcad.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str1, String.valueOf(l1), "11", "12", "0", paramString, "0", "0", false);
                      label844:
                      paramString = new bfpl();
                      paramString.c = "1";
                      paramString.jdField_d_of_type_JavaLangString = "0";
                      paramString.jdField_b_of_type_Int = 4;
                      paramString.l = "5";
                      paramString.m = "thirdApp";
                      paramString.n = "activefeed";
                      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString);
                      paramString = new HashMap();
                      paramString.put("source_type", "5");
                      paramString.put("source_from", "thirdApp");
                      paramString.put("source_to", "activefeed");
                      awrn.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramString, null);
                      return true;
                      bfqn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localBundle, paramString);
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
                    break label844;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private Intent e(Intent paramIntent)
  {
    if (!TextUtils.isEmpty((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"))) {}
    for (boolean bool = true;; bool = false)
    {
      urk.a("JumpAction", "makeStoryJumpActivity() action=%s isFromApi=%s", this.c, Boolean.valueOf(bool));
      urk.a("JumpAction", "makeStoryJumpActivity() attr=%s", String.valueOf(this.jdField_a_of_type_JavaUtilHashMap));
      if (!"open".equals(this.c)) {
        break;
      }
      paramIntent.putExtra("redid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("redid"));
      paramIntent.putExtra("lebaVersion", (String)this.jdField_a_of_type_JavaUtilHashMap.get("lebaVersion"));
      if (bool) {
        urp.a("basic", "use_api", 0, 0, new String[] { "1", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
      }
      return paramIntent;
    }
    String str1;
    if (("openVideo".equals(this.c)) || ("openvideo".equals(this.c)))
    {
      if (bool)
      {
        str1 = "userId=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoOwnerUin") + "&vid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoId");
        urp.a("basic", "use_api", 0, 0, new String[] { "6", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
      }
      return a(paramIntent);
    }
    String str2;
    String str4;
    String str5;
    if ("opencontent".equals(this.c))
    {
      if (bool)
      {
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
        str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
        if (!TextUtils.isEmpty(str4)) {
          break label473;
        }
      }
      label473:
      for (str1 = "unionId=" + str5 + "&userId=" + str1 + "&userType=" + str2;; str1 = "storyId=" + str4)
      {
        urp.a("basic", "use_api", 0, 0, new String[] { "4", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
        return d(paramIntent);
      }
    }
    if ("opentopic".equals(this.c))
    {
      if (bool)
      {
        str1 = "topicId=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
        urp.a("basic", "use_api", 0, 0, new String[] { "5", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
      }
      return b(paramIntent);
    }
    if ("opendiscovery".equals(this.c))
    {
      if (bool) {
        urp.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
      }
      return c(paramIntent);
    }
    if ("publish".equals(this.c))
    {
      if (bool) {
        urp.a("basic", "use_api", 0, 0, new String[] { "2", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
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
    if ("infoCard".equals(this.c))
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
    if ("sharegroupcard".equals(this.c))
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
    if ("openTag".equals(this.c))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag_id");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag_type");
      paramIntent.putExtra("action", 14);
      paramIntent.putExtra("tag_id", str1);
      paramIntent.putExtra("tag_type", str3);
      return paramIntent;
    }
    if ("openSquare".equals(this.c))
    {
      paramIntent.putExtra("action", 15);
      return paramIntent;
    }
    return null;
  }
  
  private void e()
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
          localObject2 = new String(baaw.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname"), 0));
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
          break label223;
        }
        paramString = paramString;
        i1 = 0;
      }
      label223:
      QLog.w("JumpAction", 1, "[gotoCmShowGame], errInfo->" + paramString.getMessage());
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidAppDialog = babr.a(this.jdField_a_of_type_AndroidContentContext, 2131627291, this.jdField_a_of_type_AndroidContentContext.getString(2131627285), 2131627287, 2131627286, new bacx(this), new bacy(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void f(String paramString)
  {
    if ("app".equals(this.jdField_f_of_type_JavaLangString)) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if ("web".equals(this.jdField_f_of_type_JavaLangString))
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
        return;
      }
    } while (!"scan".equals(this.jdField_f_of_type_JavaLangString));
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
  }
  
  private void g()
  {
    Object localObject;
    String str1;
    label54:
    String str2;
    label81:
    String str3;
    label109:
    String str4;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("packageName"))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("packageName");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("signareMode")) {
        break label330;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("signareMode");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
        break label336;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("timeStamp")) {
        break label342;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("timeStamp");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("resetWordMode")) {
        break label349;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("resetWordMode");
      label137:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("offerid")) {
        break label356;
      }
    }
    label330:
    label336:
    label342:
    label349:
    label356:
    for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("offerid");; str5 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "packageName : " + (String)localObject + " signatureMode :" + str1 + " appid : " + str2 + " timestamp : " + str3 + " resetWordMode : " + str4 + " offerId : " + str5);
      }
      localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
      ((ajqk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(42)).a((ReqCheckChangePwdAuth)localObject);
      this.jdField_a_of_type_Badb = new badb(this, null);
      this.jdField_a_of_type_Ajql = new ajql(this.jdField_a_of_type_Badb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajql);
      return;
      localObject = "";
      break;
      str1 = "";
      break label54;
      str2 = "";
      break label81;
      str3 = "";
      break label109;
      str4 = "";
      break label137;
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
    com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localJSONObject.put("viewTag", "pswManage");
      if (!PayBridgeActivity.tenpay((Activity)this.jdField_a_of_type_AndroidContentContext, localJSONObject.toString(), 5, "")) {}
      for (int i1 = 1;; i1 = 0)
      {
        b(i1);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      b(1);
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
      ((JumpActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
  
  private void j()
  {
    try
    {
      if ("head".equals(this.c))
      {
        if (this.jdField_a_of_type_Bada == null) {
          this.jdField_a_of_type_Bada = new bada(this, this);
        }
        if (this.jdField_a_of_type_JavaUtilHashtable == null) {
          this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bada);
        long l1 = System.currentTimeMillis();
        String[] arrayOfString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).split(",");
        FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        int i1 = 0;
        while (i1 < arrayOfString.length)
        {
          String str = arrayOfString[i1];
          localFriendListHandler.c(str);
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
  
  protected boolean A()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str1);
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
      ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131631842));
      ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131630660));
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
    this.jdField_j_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
    }
    this.jdField_a_of_type_Bbms.c(paramInt);
    if ((!((JumpActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) && (!this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.show();
    }
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_b_of_type_JavaLangString.equals("card")) && (this.c.equals("show_pslcard")) && (QSecFramework.a().a(1003).booleanValue())) {
      bbsv.a().a(paramActivity, null);
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
  
  public void a(String paramString)
  {
    this.m = paramString;
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
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("Jumpaction", 2, "setNewFlag.newflag=" + this.jdField_g_of_type_Boolean);
    }
  }
  
  public boolean a()
  {
    return this.jdField_j_of_type_Boolean;
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
      paramIntent.putExtra("extra_share_from_type", a(this.jdField_a_of_type_JavaUtilHashMap));
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
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void b(String paramString)
  {
    this.n = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    new JumpAction.1(this).start();
    return c();
  }
  
  protected boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      PublishHomeWorkFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, null, paramString);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772277, 2130771990);
    }
    return true;
  }
  
  public Intent c(Intent paramIntent)
  {
    paramIntent.putExtra("action", 12);
    try
    {
      paramIntent.putExtra("extra_partner_api", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"));
      paramIntent.putExtra("extra_share_from_type", a(this.jdField_a_of_type_JavaUtilHashMap));
      paramIntent.putExtra("to_new_version", (String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"));
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
  }
  
  public void c(String paramString)
  {
    this.o = paramString;
  }
  
  public boolean c()
  {
    AudioHelper.b("JumpAction.doAction");
    if ("com.qqfav".equals(this.jdField_b_of_type_JavaLangString)) {
      i1 = -1;
    }
    try
    {
      i2 = Integer.parseInt(this.c);
      i1 = i2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Object localObject1;
        String str2;
        Object localObject7;
        Object localObject12;
        continue;
        i1 = 0;
        int i2 = 0;
        Object localObject6 = null;
        continue;
        String str1 = "";
        localObject6 = localObject11;
        Object localObject11 = localObject12;
      }
    }
    switch (i1)
    {
    default: 
      return true;
    }
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131625011));
    return bfhn.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, -1, false);
    this.jdField_d_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("version"));
    this.jdField_e_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("channel_id"));
    this.jdField_f_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
    this.jdField_g_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type"));
    this.jdField_h_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name"));
    localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("viewtype");
    str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
    if (("urlopen".equals(this.jdField_b_of_type_JavaLangString)) && ("pay".equals(this.c)))
    {
      localObject7 = b("payurl");
      if (TextUtils.isEmpty((CharSequence)localObject7)) {
        break label431;
      }
      localObject11 = new String(Base64.decode((String)localObject7, 0));
      if (TextUtils.isEmpty((CharSequence)localObject11)) {
        break label400;
      }
      QLog.e("JumpAction", 1, "payurl is call to launch");
      baoz.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject11);
    }
    while (("qqidentifier".equals(this.jdField_b_of_type_JavaLangString)) && ("web".equals(this.c)))
    {
      localObject1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
      if ((TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))))
      {
        QLog.e("JumpAction", 1, "identification with illegal params");
        return true;
        label400:
        QLog.e("JumpAction", 1, "payurl cant not decode to base64 =" + (String)localObject7);
        continue;
        label431:
        QLog.e("JumpAction", 1, "payurl is null");
      }
      else
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"), "");
        aqid.a();
        localObject7 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject7).putExtra("url", (String)localObject1);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject7);
        return true;
      }
    }
    if ("qsubscribe".equals(this.jdField_b_of_type_JavaLangString))
    {
      vvy.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.c, this.jdField_a_of_type_JavaUtilHashMap);
      return true;
    }
    if ("videostory".equals(this.jdField_b_of_type_JavaLangString)) {
      if ("opendetail".equals(this.c))
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putLong("key_launch_time", System.currentTimeMillis());
        localObject7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
        if ((localObject7 == null) || ("".equals(localObject7)) || (((String)localObject7).length() < 5)) {
          return false;
        }
      }
    }
    try
    {
      ((Bundle)localObject1).putLong("key_current_feeduin", Long.valueOf((String)localObject7).longValue());
      label663:
      ((Bundle)localObject1).putString("key_current_feed_cellid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("cellid"));
      ((Bundle)localObject1).putInt("key_request_from", 3);
      ((Bundle)localObject1).putInt("key_weishi_entrance_type", 19);
      ((Bundle)localObject1).putInt("key_request_business_type", 8);
      a((Bundle)localObject1);
      String str4;
      String str3;
      Object localObject13;
      for (;;)
      {
        return true;
        if ("takevideo".equals(this.c))
        {
          localObject7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("widgetid");
          str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
          str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("activity_id");
          String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shareto");
          str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cmode");
          String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("widgetinfo");
          localObject1 = "";
          localObject13 = new Bundle();
          localObject12 = localObject7;
          localObject11 = localObject1;
          if (TextUtils.isEmpty(str6)) {
            break label9763;
          }
          String[] arrayOfString = str6.split("\\^");
          if (arrayOfString.length > 0) {
            localObject1 = arrayOfString[0];
          }
          if (arrayOfString.length == 1) {
            localObject7 = arrayOfString[0];
          }
          if (arrayOfString.length > 1) {
            localObject7 = arrayOfString[1];
          }
          localObject12 = localObject7;
          localObject11 = localObject1;
          if (arrayOfString.length <= 2) {
            break label9763;
          }
          localObject12 = arrayOfString[2];
          localObject11 = localObject7;
          localObject7 = localObject12;
          if (!TextUtils.isEmpty((CharSequence)localObject11))
          {
            if (!TextUtils.isEmpty((CharSequence)localObject7))
            {
              ((Bundle)localObject13).putString("KEY_CURRENT_TYPE", (String)localObject7);
              label955:
              ((Bundle)localObject13).putString("KEY_CURRENT_TAB", bgww.a((String)localObject1));
            }
          }
          else
          {
            bhcs.a("JumpAction", 1, "【widgetid】:" + (String)localObject11 + "【" + "from" + "】:" + str4 + "【" + "activity_id" + "】:" + str3 + "【" + "shareto" + "】:" + str5 + "【" + "cmode" + "】:" + str2 + "【" + "widgetinfo" + "】:" + str6 + "【" + "widgetinfo" + "】:" + str6);
            if (!TextUtils.isEmpty((CharSequence)localObject11)) {
              ((Bundle)localObject13).putString("KEY_CURRENT_SELECT_ID", (String)localObject11);
            }
            if (TextUtils.isEmpty(str5)) {}
          }
          try
          {
            i1 = Integer.valueOf(str5).intValue();
            ((Bundle)localObject13).putInt("VIDEO_STORY_JUMP_TO_TYPE", i1);
            if (2 == i1)
            {
              ((Bundle)localObject13).putInt("VIDEO_STORY_FROM_TYPE", bgww.l.a());
              localObject1 = str2;
              if (!TextUtils.isEmpty(str4)) {
                localObject7 = str2;
              }
            }
          }
          catch (Exception localException5)
          {
            try
            {
              i1 = bgww.a(str4).a();
              localObject7 = str2;
              if (i1 != bgww.a.a())
              {
                localObject7 = str2;
                if (i1 != bgww.m.a())
                {
                  localObject7 = str2;
                  if (i1 != bgww.t.a()) {
                    break label1439;
                  }
                }
              }
              localObject7 = str2;
              ((Bundle)localObject13).putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
              localObject1 = str2;
              localObject7 = str2;
              if (bjeg.a(i1)) {
                localObject1 = "all";
              }
              localObject7 = localObject1;
              ((Bundle)localObject13).putInt("VIDEO_STORY_FROM_TYPE", i1);
              if (TextUtils.isEmpty(str3)) {}
            }
            catch (Exception localException5)
            {
              try
              {
                ((Bundle)localObject13).putString("VIDEO_STORY_ACTIVITY_ID", str3);
                if (TextUtils.isEmpty((CharSequence)localObject1)) {}
              }
              catch (Exception localException5)
              {
                try
                {
                  label1439:
                  do
                  {
                    for (;;)
                    {
                      ((Bundle)localObject13).putInt("AECAMERA_MODE", bgww.a((String)localObject1));
                      bgxa.a((Activity)this.jdField_a_of_type_AndroidContentContext, 120, (Bundle)localObject13);
                      break;
                      ((Bundle)localObject13).putString("KEY_CURRENT_TYPE", " ");
                      break label955;
                      ((Bundle)localObject13).putInt("VIDEO_STORY_FROM_TYPE", bgww.b.a());
                      continue;
                      localException1 = localException1;
                      if (QLog.isColorLevel())
                      {
                        QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_JUMP_TO_TYPE format: " + localException1.getMessage());
                        continue;
                        localObject7 = str2;
                        if (i1 != bgww.f.a())
                        {
                          localObject7 = str2;
                          if (i1 != bgww.p.a())
                          {
                            localObject7 = str2;
                            if (i1 != bgww.q.a())
                            {
                              localObject7 = str2;
                              if (i1 != bgww.n.a())
                              {
                                localObject7 = str2;
                                if (i1 != bgww.r.a()) {
                                  continue;
                                }
                              }
                            }
                          }
                        }
                        localObject7 = str2;
                        ((Bundle)localObject13).putInt("VIDEO_STORY_JUMP_TO_TYPE", 2);
                        continue;
                        localException11 = localException11;
                        Object localObject2 = localObject7;
                        if (QLog.isColorLevel())
                        {
                          QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_FROM_TYPE format: " + localException11.getMessage());
                          localObject2 = localObject7;
                        }
                      }
                    }
                    localException5 = localException5;
                  } while (!QLog.isColorLevel());
                  QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_ACTIVITY_ID format: " + localException5.getMessage());
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.e("JumpAction", 2, "Invalid AECAMERA_MODE format: " + localException2.getMessage());
                    }
                  }
                }
              }
            }
          }
        }
      }
      if ((this.jdField_b_of_type_JavaLangString.equals("manage_troop")) && (this.c.equals("main_page"))) {
        return bG();
      }
      if (("microapp".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.c)))
      {
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("mini_appid")) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("fakeUrl"))) {}
        for (i1 = 1; i1 != 0; i1 = 0) {
          return com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
        }
        return com.tencent.mobileqq.mini.sdk.MiniAppLauncher.launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, 2016, null, null);
      }
      if (("miniapp".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.c))) {
        return com.tencent.mobileqq.mini.sdk.MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 2016, null);
      }
      Object localObject3;
      Object localObject8;
      if (("miniapp".equals(this.jdField_b_of_type_JavaLangString)) && ("notifyclose".equals(this.c)))
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("app"))
        {
          localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("type")) {
            break label1961;
          }
        }
        label1961:
        for (localObject8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");; localObject8 = null)
        {
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject8))) {
            ((agxk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(315)).a(this.jdField_a_of_type_AndroidContentContext, (String)localObject3, (String)localObject8);
          }
          return true;
          localObject3 = null;
          break;
        }
      }
      if (("wallet".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.c)) && ("0".equals(localObject3)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && ((localException11 == null) || ("0".equals(localException11)))) {
        return ag();
      }
      if (("wallet".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.c)) && ("0".equals(localObject3)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))) {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("entry")) {
          localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("entry");
        }
      }
      for (;;)
      {
        label2138:
        long l2;
        long l1;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("seq"))
        {
          localObject8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("seq");
          l2 = 0L;
          l1 = l2;
          if (TextUtils.isEmpty((CharSequence)localObject8)) {}
        }
        try
        {
          l1 = Long.valueOf((String)localObject8).longValue();
        }
        catch (Exception localException8)
        {
          try
          {
            VACDReportUtil.a(l1, "", "jumpParse", null, 0, null);
            for (;;)
            {
              label2173:
              if (("1".equals(localException11)) || ("2".equals(localException11)) || ("3".equals(localException11)) || ("4".equals(localException11)) || ("5".equals(localException11)) || ("6".equals(localException11)) || ("7".equals(localException11)) || ("9".equals(localException11)) || ("10".equals(localException11)) || ("11".equals(localException11)))
              {
                localObject8 = new Bundle();
                if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tokenid")) {
                  ((Bundle)localObject8).putString("tokenid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("tokenid"));
                }
                if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("data")) {
                  ((Bundle)localObject8).putString("data", (String)this.jdField_a_of_type_JavaUtilHashMap.get("data"));
                }
                return a(localException11, (String)localObject3, l1, (Bundle)localObject8);
                localObject3 = null;
                break;
                localObject8 = null;
                break label2138;
              }
              if ("8".equals(localException11)) {
                return a(localException11, (String)localObject3, l1);
              }
              if (("buscard".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.c)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) && (!baip.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"))) && ("2".equals(this.jdField_a_of_type_JavaUtilHashMap.get("from_type")))) {
                return B();
              }
              if ("qqnotify".equals(this.jdField_b_of_type_JavaLangString))
              {
                if (!"open".equals(this.c)) {
                  break label2755;
                }
                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("params")) {}
              }
              label2755:
              Object localObject10;
              Object localObject4;
              for (;;)
              {
                try
                {
                  localObject3 = new JSONObject(URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("params")));
                  if (QLog.isColorLevel()) {
                    QLog.i("JumpAction", 2, "urlParamObj: " + localObject3);
                  }
                  if (((JSONObject)localObject3).optInt("view_type", 0) == 0)
                  {
                    localObject3 = ((JSONObject)localObject3).optJSONObject("params");
                    if (localObject3 != null) {
                      ReminderListFragment.a(this.jdField_a_of_type_AndroidContentContext, ((JSONObject)localObject3).optString("notice_time"));
                    }
                  }
                }
                catch (Exception localException3)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("JumpAction", 2, "JumpAction parse url throw an exception: " + localException3);
                  continue;
                }
                if (("qqnotify".equals(this.jdField_b_of_type_JavaLangString)) && ("birth".equals(this.c)))
                {
                  localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, ActivateFriendActivity.class);
                  ((Intent)localObject3).putExtra("af_key_from", 2);
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
                }
                if (!this.jdField_b_of_type_JavaLangString.equals("ftssearch")) {
                  break label2920;
                }
                if (!this.c.equals("tab")) {
                  break;
                }
                return C();
                if (("subscribe".equals(this.c)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("scheme")) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msgid")) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("busiid")))
                {
                  localObject8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("msgid");
                  localObject10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("busiid");
                  localObject11 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("scheme");
                  localObject4 = "";
                  if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("domain")) {
                    localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("domain");
                  }
                  QQNotifySettingFragment.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject8, (String)localObject10, (String)localObject11, (String)localObject4);
                }
              }
              if (this.c.equals("openmixweb")) {
                return e();
              }
              label2920:
              if ((this.jdField_b_of_type_JavaLangString.equals("wpa")) && (this.c.equals("openid_to_uin"))) {
                return ah();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.c.equals("chat"))) {
                return aj();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("wsgzh")) && (this.c.equals("waterfall")))
              {
                rww.a(this.jdField_a_of_type_AndroidContentContext, "from_search_rzh_ws", 2, false);
                return true;
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("asyncmsg")) && (this.c.equals("open_async_detail"))) {
                return bm();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("connect_miniapp")) && (this.c.equals("launch"))) {
                return ai();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.c.equals("aioorprofile"))) {
                return ao();
              }
              if (this.jdField_b_of_type_JavaLangString.equals("qapp")) {
                return bk();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.c.equals("show_nearby_fri"))) {
                return ap();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.c.equals("show_location"))) {
                return at();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.c.equals("select_location"))) {
                return au();
              }
              if (("card".equals(this.jdField_b_of_type_JavaLangString)) && ("show_pslcard".equals(this.c))) {
                return av();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("personal_tag")) && (this.c.equals("tag_list"))) {
                return aB();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("upload")) && (this.c.equals("photo"))) {
                return aJ();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("forward")) && (this.c.equals("url"))) {
                return aN();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("forward")) && (this.c.equals("invite_register"))) {
                return by();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("gamesdk")) && (this.c.equals("bind_group"))) {
                return aM();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("opensdk")) && (this.c.equals("join_group"))) {
                return aK();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("opensdk")) && (this.c.equals("bind_group"))) {
                return aL();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.c.equals("to_fri"))) {
                return aO();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.c.equals("to_qqdataline"))) {
                return bj();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("gamesdk")) && (this.c.equals("add_friend")))
              {
                if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"))) {
                  k = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
                }
                return aP();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.c.equals("to_qqfav"))) {
                return aU();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.c.equals("to_qzone"))) {
                return d("shareToQzone");
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("publish"))) {
                return aV();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("writemood"))) {
                return aZ();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("to_publish_queue"))) {
                return ba();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("open_homepage"))) {
                return bb();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("groupalbum"))) {
                return aQ();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("to_friend_feeds"))) {
                return i();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("to_qzone_dialog"))) {
                return aR();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("to_redpocket_share"))) {
                return aW();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("open_redpocket"))) {
                return aX();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("qzone_schema"))) {
                return aS();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("shareLogToQQ"))) {
                return aY();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("qzone_publicaccount"))) {
                return aT();
              }
              if (this.jdField_b_of_type_JavaLangString.equals("mqq"))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("JumpAction", 2, "handleMQQService");
                }
                j();
              }
              label5194:
              Object localObject5;
              while ((this.jdField_b_of_type_JavaLangString.equals("schedule")) && (this.c.equals("showDetail")))
              {
                return bn();
                if ((this.jdField_b_of_type_JavaLangString.equals("groupopenapp")) && (this.c.equals("openapp"))) {
                  return bD();
                }
                if ((this.jdField_b_of_type_JavaLangString.equals("lightapp")) && (this.c.equals("open"))) {
                  return bE();
                }
                if (this.jdField_b_of_type_JavaLangString.endsWith("app"))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("JumpAction", 2, "handleAppForward");
                  }
                  return bi();
                }
                if ((this.jdField_b_of_type_JavaLangString.equals("qm")) && (this.c.equals("qr")))
                {
                  if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))) {
                    jdField_i_of_type_JavaLangString = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
                  }
                  if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))) {
                    jdField_j_of_type_JavaLangString = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
                  }
                  if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openkey"))) {
                    l = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openkey");
                  }
                  if ("true".equals(this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"))) {
                    return aF();
                  }
                  return aI();
                }
                if ((this.jdField_b_of_type_JavaLangString.equals("dc")) && (this.c.equals("ft"))) {
                  return bc();
                }
                if ("group".equals(this.jdField_b_of_type_JavaLangString))
                {
                  if (this.c.equals("nearby")) {
                    return aq();
                  }
                  if (this.c.equals("create")) {
                    return ar();
                  }
                  if (this.c.equals("report")) {
                    return bA();
                  }
                }
                else
                {
                  if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.c.equals("emoji")))
                  {
                    EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 7);
                    return true;
                  }
                  if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.c.equals("emoji_detail")))
                  {
                    EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4, b("detailid"));
                    return true;
                  }
                  if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.c.equals("emoji_author")))
                  {
                    EmojiHomeUiPlugin.openEmojiAuthorPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 5, b("authorid"));
                    return true;
                  }
                  if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.c.equals("bubble")))
                  {
                    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, bant.a(this.jdField_a_of_type_AndroidContentContext, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, null, false, -1);
                    return true;
                  }
                  if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.c.equals("theme")))
                  {
                    if ((BaseApplicationImpl.IS_SUPPORT_THEME) && (azzz.b()))
                    {
                      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, bant.a(this.jdField_a_of_type_AndroidContentContext, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, null, false, -1);
                      return true;
                    }
                  }
                  else if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.c.equals("font")))
                  {
                    if ((((fv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).c()) && (azzz.b()))
                    {
                      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, bant.a(this.jdField_a_of_type_AndroidContentContext, "font", ""), 4096L, null, false, -1);
                      return true;
                    }
                  }
                  else
                  {
                    if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.c.equals("pendant")))
                    {
                      if (azzz.b()) {
                        baau.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
                      }
                      return true;
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.c.equals("individuation")))
                    {
                      VasWebviewUtil.openIndividuationIndex(this.jdField_a_of_type_AndroidContentContext);
                      return true;
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.c.equals("apollo_store")))
                    {
                      localObject10 = new Intent();
                      localObject4 = this.jdField_a_of_type_JavaLangString.split("\\?");
                      if (localObject4.length < 2) {
                        break label9753;
                      }
                      ((Intent)localObject10).putExtra("extra_key_url_append", localObject4[1]);
                      if (localObject4[1] == null) {
                        break label9753;
                      }
                      if (localObject4[1].contains("tab=game_center"))
                      {
                        localObject4 = null;
                        i1 = 0;
                        i2 = 1;
                        if (QLog.isColorLevel()) {
                          QLog.d("JumpAction", 2, new Object[] { "apollo_store url:", localObject4 });
                        }
                        localObject8 = localObject4;
                        if (TextUtils.isEmpty((CharSequence)localObject4)) {
                          localObject8 = aiys.ah;
                        }
                        if (i2 == 0) {
                          break label5194;
                        }
                        ApolloUtil.b(this.jdField_a_of_type_AndroidContentContext);
                      }
                      for (;;)
                      {
                        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
                        {
                          localObject4 = (aifg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
                          bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_clk", ((aifg)localObject4).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), 0, new String[] { "0" });
                        }
                        return true;
                        if (localObject4[1].contains("tab=other_url&url="))
                        {
                          localObject4 = URLDecoder.decode(localObject4[1].substring(localObject4[1].indexOf("tab=other_url&url=") + "tab=other_url&url=".length()));
                          i1 = 1;
                          i2 = 0;
                          break;
                        }
                        localObject8 = new HashMap();
                        tfh.a(localObject4[1], (HashMap)localObject8);
                        localObject4 = aifg.b((String)((HashMap)localObject8).get("tab"), true);
                        i2 = 0;
                        i1 = 0;
                        break;
                        if (i1 != 0) {
                          ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject8);
                        } else {
                          ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject10, null, (String)localObject8, null);
                        }
                      }
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.c.equals("game_invite")))
                    {
                      QLog.i("JumpAction", 1, "[cmshow.game_invite], source:" + this.jdField_a_of_type_JavaLangString);
                      return e(this.jdField_a_of_type_JavaLangString);
                    }
                    if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("avatar_edit".equals(this.c))) {
                      return V();
                    }
                    if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_avatar_edit".equals(this.c))) {
                      return X();
                    }
                    if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_dynamic_avatar_edit".equals(this.c))) {
                      return Y();
                    }
                    if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_face_collection".equals(this.c))) {
                      return W();
                    }
                    if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("more_info_edit".equals(this.c)))
                    {
                      localObject4 = new Intent(this.jdField_a_of_type_AndroidContentContext, FriendProfileMoreInfoActivity.class);
                      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
                    }
                    else
                    {
                      if (("userprofile".equals(this.jdField_b_of_type_JavaLangString)) && ("friend_profile_card".equals(this.c)))
                      {
                        localObject4 = new ProfileActivity.AllInOne((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), 111);
                        if ("1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("source"))) {
                          ((ProfileActivity.AllInOne)localObject4).jdField_h_of_type_Int = 118;
                        }
                        for (;;)
                        {
                          ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject4);
                          break;
                          if ("2".equals(this.jdField_a_of_type_JavaUtilHashMap.get("source"))) {
                            ((ProfileActivity.AllInOne)localObject4).jdField_h_of_type_Int = 121;
                          }
                        }
                      }
                      if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("might_know".equals(this.c))) {
                        return Z();
                      }
                      if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("search_might_know".equals(this.c))) {
                        return aa();
                      }
                      if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("new_friends".equals(this.c))) {
                        return ab();
                      }
                      if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("contacts_tab".equals(this.c))) {
                        return ac();
                      }
                      if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("phone_recommend".equals(this.c))) {
                        return ad();
                      }
                      if (((this.jdField_b_of_type_JavaLangString.equals("readingcenter")) || (this.jdField_b_of_type_JavaLangString.equals("qqreader"))) && (this.c.equals("open"))) {
                        return as();
                      }
                      if ((this.jdField_b_of_type_JavaLangString.equals("healthcenter")) && (this.c.equals("open")))
                      {
                        if (QLog.isColorLevel()) {
                          QLog.i("JumpAction", 2, "enter jiankang");
                        }
                        ThreadManager.post(new JumpAction.2(this), 5, null, true);
                        if ((Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor")).getDefaultSensor(19) != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
                          ((basg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260)).a("jump action");
                        }
                        localObject8 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
                        if ((localObject8 == null) || ((!((String)localObject8).startsWith("http://")) && (!((String)localObject8).startsWith("https://"))) || ((!mpw.b((String)localObject8).equalsIgnoreCase("qq.com")) && (!mpw.b((String)localObject8).equalsIgnoreCase("myun.tenpay.com")) && (!mpw.b((String)localObject8).equalsIgnoreCase("tenpay.com")) && (!mpw.b((String)localObject8).equalsIgnoreCase("wanggou.com")))) {
                          return false;
                        }
                        localObject4 = localObject8;
                        if (((String)localObject8).indexOf("?") <= 0) {
                          localObject4 = (String)localObject8 + "?";
                        }
                        localObject8 = new StringBuilder((String)localObject4);
                        localObject10 = ((StringBuilder)localObject8).append("&client=androidQQ").append("&uin=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("&version=").append("8.2.6.4370").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&density=").append(ThemeUtil.getThemeDensity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())).append("&platformId=2").append("&_lv=0").append("&hasRedDot=");
                        if (this.jdField_h_of_type_Boolean) {}
                        for (localObject4 = "1";; localObject4 = "0")
                        {
                          ((StringBuilder)localObject10).append((String)localObject4).append("&adtag=mvip.gongneng.anroid.health.nativet");
                          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
                          ((StringBuilder)localObject8).append("&lati=").append(((SharedPreferences)localObject4).getFloat("search_lbs_latitude", 0.0F));
                          ((StringBuilder)localObject8).append("&logi=").append(((SharedPreferences)localObject4).getFloat("search_lbs_logitude", 0.0F));
                          i1 = badq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
                          ((StringBuilder)localObject8).append("&netType=" + i1);
                          localObject4 = babp.d();
                          ((StringBuilder)localObject8).append("&model=" + (String)localObject4);
                          localObject4 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                          ((Intent)localObject4).putExtra("url", ((StringBuilder)localObject8).toString());
                          ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
                          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
                          return true;
                        }
                      }
                      if ((this.jdField_b_of_type_JavaLangString.equals("ptlogin")) && (this.c.equals("qlogin"))) {
                        return bd();
                      }
                      if ((this.jdField_b_of_type_JavaLangString.equals("gav")) && (this.c.equals("request"))) {
                        return be();
                      }
                      if (("videochat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.c))) {
                        return bf();
                      }
                      if (("randomavchat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.c))) {
                        return bg();
                      }
                      if (this.jdField_b_of_type_JavaLangString.equals("tribe"))
                      {
                        localObject4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
                        localObject8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sourceUrl");
                        if (this.c.equals("web")) {
                          localObject10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
                        }
                        try
                        {
                          localObject10 = URLDecoder.decode((String)localObject10);
                          localObject10 = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class).putExtra("url", (String)localObject10);
                          ((Intent)localObject10).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                          ((Intent)localObject10).putExtra("hide_operation_bar", true);
                          ((Intent)localObject10).putExtra("hideRightButton", true);
                          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject10);
                          if ((localObject4 != null) && (localObject8 != null)) {
                            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_tribe", "", "url", "visit", 0, 1, 0, (String)localObject4, mpw.b((String)localObject8, new String[0]), "", "");
                          }
                          return true;
                        }
                        catch (Exception localException4)
                        {
                          if (QLog.isDevelopLevel()) {
                            QLog.e("JumpAction", 4, "URLDecoder.decode error");
                          }
                          return false;
                        }
                      }
                      if ((this.jdField_b_of_type_JavaLangString.equals("qqdataline")) && (this.c.equals("openqqdataline"))) {
                        return af();
                      }
                      if ((this.jdField_b_of_type_JavaLangString.equals("wallet")) && (this.c.equals("modify_pass"))) {
                        return ae();
                      }
                      if (this.jdField_b_of_type_JavaLangString.equals("dating"))
                      {
                        if (this.c.equals("detail")) {
                          return U();
                        }
                        if (this.c.equals("publish")) {
                          return T();
                        }
                        if (this.c.equals("feed")) {
                          return S();
                        }
                      }
                      else if (this.jdField_b_of_type_JavaLangString.equals("nearby_entry"))
                      {
                        if (this.c.equals("nearby_feed")) {
                          return N();
                        }
                        if (this.c.equals("nearby_profile")) {
                          return aw();
                        }
                        if (this.c.equals("hotchat_list")) {
                          return P();
                        }
                        if (this.c.equals("hotchat_room")) {
                          return Q();
                        }
                        if (this.c.equals("visitor_list")) {
                          return v();
                        }
                      }
                      else if (this.jdField_b_of_type_JavaLangString.equals("nearby"))
                      {
                        if (this.c.equals("reportFriend")) {
                          return bB();
                        }
                      }
                      else if (this.jdField_b_of_type_JavaLangString.equals("hotchat"))
                      {
                        if (this.c.equals("newyear_scene")) {
                          return R();
                        }
                      }
                      else if (this.jdField_b_of_type_JavaLangString.equals("freshnews_entry"))
                      {
                        if ((this.c.equals("feed")) || (this.c.equals("detail")) || (this.c.equals("topic")) || (!this.c.equals("public"))) {
                          break;
                        }
                      }
                      else
                      {
                        if ((this.jdField_b_of_type_JavaLangString.equals("qlink")) && (this.c.equals("openqlink"))) {
                          return bl();
                        }
                        if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.c.equals("to_troopbar"))) {
                          return bo();
                        }
                        if ((this.jdField_b_of_type_JavaLangString.equals("qqconnect")) && (this.c.equals("url"))) {
                          return bp();
                        }
                        if ((this.jdField_b_of_type_JavaLangString.equals("publicdevice")) && (this.c.equals("url"))) {
                          return bq();
                        }
                        if ((this.jdField_b_of_type_JavaLangString.equals("openLightApp")) && (this.c.equals("url"))) {
                          return k();
                        }
                        if (("tenpay".equals(this.jdField_b_of_type_JavaLangString)) && ("sendHongBao".equals(this.c))) {
                          return br();
                        }
                        if (("massbless".endsWith(this.jdField_b_of_type_JavaLangString)) && ("mainpage".equals(this.c))) {
                          return l();
                        }
                        if (!this.jdField_b_of_type_JavaLangString.equals("rankinglist"))
                        {
                          if (this.jdField_b_of_type_JavaLangString.equals("interesttag")) {
                            return M();
                          }
                          if (this.jdField_b_of_type_JavaLangString.equals("qqcomic")) {
                            return bh();
                          }
                          if (("leba_plugin".equals(this.jdField_b_of_type_JavaLangString)) && ("set".equals(this.c))) {
                            return m();
                          }
                          if (this.jdField_b_of_type_JavaLangString.equals("pa_relationship")) {
                            return n();
                          }
                          if (this.jdField_b_of_type_JavaLangString.equals("od")) {
                            return o();
                          }
                          if (this.jdField_b_of_type_JavaLangString.equals("odAddFriend")) {
                            return bs();
                          }
                          if ("huayang".equals(this.jdField_b_of_type_JavaLangString)) {
                            return bt();
                          }
                          if ("qboss".equals(this.jdField_b_of_type_JavaLangString)) {
                            return auef.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
                          }
                          if (this.jdField_b_of_type_JavaLangString.equals("readinjoy"))
                          {
                            if (this.c.equals("open")) {
                              return p();
                            }
                            if (this.c.equals("report")) {
                              return q();
                            }
                            if (this.c.equals("reportrealtime")) {
                              return r();
                            }
                            if (this.c.equals("apenalbum"))
                            {
                              localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("articleid");
                              i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin_type"));
                              if (!TextUtils.isEmpty((CharSequence)localObject5))
                              {
                                localObject8 = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountImageCollectionMainActivity.class);
                                ((Intent)localObject8).putExtra("source_for_report", i1);
                                scb.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject8, (String)localObject5);
                              }
                            }
                            else
                            {
                              if (this.c.equals("multivideo")) {
                                return s();
                              }
                              if (this.c.equals("openatlas"))
                              {
                                if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("rowkey")) {}
                                for (localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rowkey"); TextUtils.isEmpty((CharSequence)localObject5); localObject5 = "")
                                {
                                  if (QLog.isColorLevel()) {
                                    QLog.e("JumpAction", 2, "rowKey is Empty");
                                  }
                                  return false;
                                }
                                if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("picindex"))
                                {
                                  localObject8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("picindex");
                                  label7757:
                                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("source")) {
                                    break label8124;
                                  }
                                  localObject10 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
                                  label7785:
                                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("enteranimationstyle")) {
                                    break label8132;
                                  }
                                  localObject11 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enteranimationstyle");
                                  label7813:
                                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("hideTopic")) {
                                    break label8140;
                                  }
                                  localObject12 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hideTopic");
                                  label7841:
                                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("commentId")) {
                                    break label8143;
                                  }
                                  localObject12 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("commentId");
                                  label7869:
                                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("subCommentId")) {
                                    break label8150;
                                  }
                                  localObject13 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("subCommentId");
                                  label7897:
                                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("albumStyle")) {
                                    break label8157;
                                  }
                                  str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("albumStyle");
                                  label7925:
                                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("jumpCommentType")) {
                                    break label8160;
                                  }
                                  str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jumpCommentType");
                                  label7953:
                                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("isAwesome")) {
                                    break label8167;
                                  }
                                  str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isAwesome");
                                }
                                for (;;)
                                {
                                  for (;;)
                                  {
                                    try
                                    {
                                      Integer.valueOf((String)localObject8).intValue();
                                      i1 = Integer.valueOf((String)localObject10).intValue();
                                    }
                                    catch (Exception localException6)
                                    {
                                      label8124:
                                      label8132:
                                      label8140:
                                      label8143:
                                      label8150:
                                      label8157:
                                      label8160:
                                      label8167:
                                      i1 = 0;
                                    }
                                    try
                                    {
                                      Integer.valueOf((String)localObject11).intValue();
                                      i2 = i1;
                                      if (!Boolean.valueOf(bgmq.r(obz.a())).booleanValue()) {
                                        break label8201;
                                      }
                                      localObject5 = "http://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&rowkey=" + (String)localObject5 + "&album_source=" + i2 + "&isAwesome=" + str4 + "&commentId=" + (String)localObject12 + "&subCommentId=" + (String)localObject13 + "&jumpCommentType=" + str3;
                                      rjb.a(this.jdField_a_of_type_AndroidContentContext, null, (String)localObject5, null);
                                    }
                                    catch (Exception localException7)
                                    {
                                      label8178:
                                      break label8178;
                                    }
                                  }
                                  localObject8 = "0";
                                  break label7757;
                                  localObject10 = "0";
                                  break label7785;
                                  localObject11 = "0";
                                  break label7813;
                                  break label7841;
                                  localObject12 = "";
                                  break label7869;
                                  localObject13 = "";
                                  break label7897;
                                  break label7925;
                                  str3 = "";
                                  break label7953;
                                  str4 = "";
                                  continue;
                                  i2 = i1;
                                  if (QLog.isColorLevel())
                                  {
                                    QLog.e("JumpAction", 2, "Parameter error");
                                    i2 = i1;
                                  }
                                }
                                label8201:
                                if (QLog.isColorLevel()) {
                                  QLog.e("JumpAction", 2, "jumpToGallery failed: atlas has undercarriage");
                                }
                              }
                              else
                              {
                                if (this.c.equals("selfpage"))
                                {
                                  nji.a(this.jdField_a_of_type_AndroidContentContext, false);
                                  return true;
                                }
                                if ("showugceditor".equals(this.c))
                                {
                                  e();
                                }
                                else if ("openarticle".equals(this.c))
                                {
                                  localObject5 = nji.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
                                  if ((this.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)) {
                                    ((FastWebActivity)this.jdField_a_of_type_AndroidContentContext).a((Intent)localObject5);
                                  } else {
                                    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject5);
                                  }
                                }
                              }
                            }
                          }
                          else if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.c.equals("apollo_action")))
                          {
                            if (aifg.a(this.jdField_a_of_type_AndroidContentContext)) {
                              return u();
                            }
                          }
                          else
                          {
                            if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.c.equals("open_game"))) {
                              return a(this.jdField_a_of_type_JavaUtilHashMap);
                            }
                            if ("favorites".equals(this.jdField_b_of_type_JavaLangString))
                            {
                              if ("forward_favorites".equals(this.c))
                              {
                                localObject5 = new Intent();
                                ((Intent)localObject5).putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131625011));
                                return bfhn.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject5, -1, false);
                              }
                            }
                            else if ("hongbao_share".equals(this.jdField_b_of_type_JavaLangString))
                            {
                              if ("hongbao_brush".equals(this.c)) {
                                return I();
                              }
                            }
                            else if ("general_ar".equals(this.jdField_b_of_type_JavaLangString))
                            {
                              if ("gotoScannerTorchActivity".equals(this.c)) {
                                return L();
                              }
                            }
                            else
                            {
                              if ("mqqavshare://".equals(this.jdField_b_of_type_JavaLangString))
                              {
                                this.jdField_e_of_type_Boolean = true;
                                return lnv.a(this);
                              }
                              if ("assistant_setting".equals(this.jdField_b_of_type_JavaLangString))
                              {
                                if ("ASSISTANT_SETTING".equals(this.c)) {
                                  return t();
                                }
                              }
                              else if ((this.jdField_b_of_type_JavaLangString.equals("conf")) || (this.jdField_b_of_type_JavaLangString.equals("confpstn")) || (this.jdField_b_of_type_JavaLangString.equals("confhr")))
                              {
                                if (this.c.equals("ft")) {
                                  return w();
                                }
                              }
                              else if (!"olympic_entry".equals(this.jdField_b_of_type_JavaLangString)) {
                                if ("teamwork".equals(this.jdField_b_of_type_JavaLangString))
                                {
                                  if ("opendoclist".equals(this.c)) {
                                    return H();
                                  }
                                }
                                else
                                {
                                  if ("qstory".equals(this.jdField_b_of_type_JavaLangString))
                                  {
                                    if ("openNow".equals(this.c)) {
                                      return x();
                                    }
                                    return F();
                                  }
                                  if ("now".equals(this.jdField_b_of_type_JavaLangString))
                                  {
                                    if ("openroom".equals(this.c)) {
                                      return x();
                                    }
                                    if ("playmedia".equals(this.c)) {
                                      return d();
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
              if ((this.jdField_b_of_type_JavaLangString.equals("contact")) && (this.c.equals("add"))) {
                return y();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("profile")) && (this.c.equals("setting"))) {
                return z();
              }
              if (this.jdField_b_of_type_JavaLangString.equals("qqreg")) {
                return bz();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("troop_member_card")) && (this.c.equals("open_member_recent_chat_view"))) {
                return O();
              }
              if (this.jdField_b_of_type_JavaLangString.equals("qwerewolf"))
              {
                if (this.c.equals("openInvitationRoom")) {
                  return D();
                }
                if (this.c.equals("enterGameRoom")) {
                  return E();
                }
              }
              else if (this.jdField_b_of_type_JavaLangString.equals("groupvideo"))
              {
                if (this.c.equals("openroom")) {
                  return bC();
                }
              }
              else if (this.jdField_b_of_type_JavaLangString.equals("invite_join_group"))
              {
                if (this.c.equals("open")) {
                  return A();
                }
              }
              else
              {
                if (("troop_homework".equals(this.jdField_b_of_type_JavaLangString)) && ("publish".equals(this.c))) {
                  return b(b("gc"));
                }
                if ((this.jdField_b_of_type_JavaLangString.equals("nearby_videochat")) && (this.c.equals("open_plugin")))
                {
                  if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
                  {
                    localObject5 = (azgp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(224);
                    NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, null, ((azgp)localObject5).a(), null, 123987);
                    return true;
                  }
                  QLog.i("JumpAction", 1, "openNearbyVideoChatActivity, context is not a activity");
                  return false;
                }
                if (!"weishitab".equals(this.jdField_b_of_type_JavaLangString)) {
                  break label9162;
                }
                if ("open".equals(this.c)) {
                  d();
                }
              }
              label9162:
              do
              {
                do
                {
                  return false;
                  if ("page_router".equals(this.jdField_b_of_type_JavaLangString))
                  {
                    J();
                    return true;
                  }
                  if ("msg_list".equals(this.jdField_b_of_type_JavaLangString))
                  {
                    K();
                    return true;
                  }
                  if (!"watchtogether".equals(this.jdField_b_of_type_JavaLangString)) {
                    break;
                  }
                } while (!this.c.equals("openroom"));
                return bF();
                if ("share_group".equals(this.jdField_b_of_type_JavaLangString))
                {
                  if (this.c.equals("open"))
                  {
                    localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
                    if (localObject5 != null) {
                      azlj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject5);
                    }
                  }
                  return true;
                }
                if ("edit_group".equals(this.jdField_b_of_type_JavaLangString))
                {
                  if (this.c.equals("open"))
                  {
                    localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
                    if (localObject5 != null) {
                      azlj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject5);
                    }
                  }
                  return true;
                }
                if ("weishiforqassistant".equals(this.jdField_b_of_type_JavaLangString))
                {
                  rww.a(this.jdField_a_of_type_AndroidContentContext, "from_audio_assistant", 1, true);
                  return true;
                }
                if ("nearbyforqassistant".equals(this.jdField_b_of_type_JavaLangString))
                {
                  localObject5 = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyGuideActivity.class);
                  ((Intent)localObject5).putExtra("ENTER_TIME", System.currentTimeMillis());
                  ((Intent)localObject5).putExtra("IS_HAS_REDTOUCH", false);
                  ((Intent)localObject5).putExtra("FROM_WHERE", 1);
                  ((Intent)localObject5).putExtra("RANK_BANNER_PUSH", "");
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject5);
                  return true;
                }
                if ("qechatforqassistant".equals(this.jdField_b_of_type_JavaLangString))
                {
                  PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, ExtendFriendFragment.class);
                  return true;
                }
                if ("searchforqassistant".equals(this.jdField_b_of_type_JavaLangString))
                {
                  localObject5 = b("searchkey");
                  UniteSearchActivity.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject5, 10004);
                  return true;
                }
                if ("settingsforqassistant".equals(this.jdField_b_of_type_JavaLangString))
                {
                  localObject5 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQSettingSettingActivity.class);
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject5);
                  return true;
                }
                if ("confiessmsgforqassistant".equals(this.jdField_b_of_type_JavaLangString))
                {
                  localObject10 = ((alxy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
                  Object localObject9 = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
                  localObject5 = localObject9;
                  if (localObject10 != null)
                  {
                    localObject5 = localObject9;
                    if (!TextUtils.isEmpty(((alxu)localObject10).l)) {
                      localObject5 = ((alxu)localObject10).l;
                    }
                  }
                  localObject9 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                  ((Intent)localObject9).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                  ((Intent)localObject9).putExtra("url", (String)localObject5);
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject9);
                  return true;
                }
              } while (!"scanforqassistant".equals(this.jdField_b_of_type_JavaLangString));
              if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
                ahbv.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 0L, 0L, 0);
              }
              return true;
              localException8 = localException8;
              l1 = l2;
            }
          }
          catch (Exception localException9)
          {
            break label2173;
          }
        }
      }
    }
    catch (Exception localException10)
    {
      break label663;
    }
  }
  
  public Intent d(Intent paramIntent)
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("userid");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("usertype");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("unionid");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("storyid");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("showinfocard");
    int i1 = a(this.jdField_a_of_type_JavaUtilHashMap);
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
    this.p = paramString;
  }
  
  public boolean d()
  {
    SmallVideoFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    return true;
  }
  
  public void e(String paramString)
  {
    this.q = paramString;
  }
  
  public boolean e()
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
  
  public boolean f()
  {
    if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.c.equals("aioorprofile"))) {}
    while (((this.jdField_b_of_type_JavaLangString.equals("group")) && (this.c.equals("creategroup"))) || ((this.jdField_b_of_type_JavaLangString.equals("qstory")) && (this.c.equals("publish")))) {
      return true;
    }
    return false;
  }
  
  public boolean g()
  {
    return (this.jdField_b_of_type_JavaLangString.equals("card")) && (this.c.equals("show_pslcard")) && ("public_account".equals(this.jdField_a_of_type_JavaUtilHashMap.get("card_type"))) && ("app".equals(this.jdField_a_of_type_JavaUtilHashMap.get("src_type"))) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")));
  }
  
  public boolean h()
  {
    return (this.jdField_b_of_type_JavaLangString.equals("share")) && (this.c.equals("to_fri"));
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Object localObject = (awcz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if ((localObject != null) && ((((awcz)localObject).a(2) > 0) || (((awcz)localObject).a(1) > 0))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("newflag", bool);
      ((Intent)localObject).putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.a((Intent)localObject, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      ((Intent)localObject).addFlags(805306368);
      String str = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("push_trans_channel");
      bfpr.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (Intent)localObject, str, -1);
      LpReportInfo_dc02880.report(this.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    String str = a(a(a(a(a(a(QzoneConfig.getInstance().getConfig("H5Url", "PersonalQzoneVisitor", "https://h5.qzone.qq.com/visitor/qzone/personal?uin={uin}&qua={qua}&clicktime={clicktime}&_bid=329&_wv=3&_proxy=true"), "{hostUin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "{clicktime}", String.valueOf(System.currentTimeMillis())), "{from}", "androidQQ"), "{qua}", bfpk.a()), "{uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "{UIN}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.putExtra("articalChannelId", 5);
    if (bbaf.jdField_a_of_type_JavaUtilHashMap.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131652127));
    localIntent.setData(Uri.parse(str));
    localIntent.addFlags(268435456);
    localIntent.putExtra("needSkey", "true");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean k()
  {
    Object localObject = b("param_meta_data");
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localBundle.putString("param_meta_data", (String)localObject);
    }
    String str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.jdField_a_of_type_JavaLangString;
    }
    ydt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, (String)localObject, localBundle);
    return true;
  }
  
  public boolean l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "gotoSendBless");
    }
    aeqd localaeqd = (aeqd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(138);
    if (localaeqd.a()) {
      localaeqd.a(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      return true;
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 0, ajjy.a(2131640115), 0).a();
    }
  }
  
  public boolean m()
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
  
  public boolean n()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("account_type");
    if ((localObject != null) && ("public_account".equals(localObject)))
    {
      int i1 = rtr.a(Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("account_flag")));
      if ((i1 == -3) || (i1 == -4)) {
        ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), 0L, 1);
      }
    }
    do
    {
      do
      {
        return true;
      } while ((localObject == null) || (!"crm".equals(localObject)));
      localObject = (ajho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    } while (localObject == null);
    ((ajho)localObject).a(SystemClock.uptimeMillis());
    return true;
  }
  
  public boolean o()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");
    Object localObject6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"))) {}
    try
    {
      localObject1 = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("vasname"), "utf-8");
      localObject5 = "";
      localObject3 = localObject5;
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
          long l2 = Long.parseLong(str);
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
          int i2 = Integer.parseInt((String)localObject6);
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
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        ((aqpp)((QQAppInterface)localObject5).getManager(108)).a(this.jdField_a_of_type_AndroidContentContext, l1, "launcher", (String)localObject1, (String)localObject3, i1);
        return true;
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
        localUnsupportedEncodingException1.printStackTrace();
        localObject2 = localObject3;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          Object localObject5;
          localUnsupportedEncodingException2.printStackTrace();
          localObject4 = localObject5;
        }
      }
    }
  }
  
  public boolean p()
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
        ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067C6", "0X80067C6", 0, 0, "", "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", false);
      }
      if ("webview".equals(this.m)) {
        wis.a().e((String)localObject1);
      }
      for (;;)
      {
        return true;
        if (bgmq.k())
        {
          i2 = 12;
          i1 = i2;
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              i1 = i2;
              if (TextUtils.isDigitsOnly((CharSequence)localObject1)) {
                i1 = Integer.valueOf((String)localObject1).intValue();
              }
            }
            localObject1 = nji.a(this.jdField_a_of_type_AndroidContentContext, i1);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          }
          catch (Exception localException1) {}
          if (QLog.isColorLevel()) {
            QLog.e("JumpAction", 1, "jump activity error1 ", localException1);
          }
        }
        else if (bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          nji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 2, 0);
        }
        else
        {
          nji.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, 2);
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
        break label1399;
      }
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131633855);
    }
    label872:
    label1399:
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
              if ("webview".equals(this.m)) {
                wis.a().k();
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
                if (bgmq.k())
                {
                  nji.a(this.jdField_a_of_type_AndroidContentContext, i2, (String)localObject2, i3, 4);
                  break;
                }
                nji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 4, 1);
                break;
              }
              nji.b(this.jdField_a_of_type_AndroidContentContext, i2, (String)localObject2, i3, 4);
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
              break label913;
            }
            i1 = Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("from")).intValue();
            if (!bgmq.i()) {
              break label872;
            }
            try
            {
              localObject2 = nji.a(this.jdField_a_of_type_AndroidContentContext, i1);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            }
            catch (Exception localException2) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("JumpAction", 1, "jump activity error1 ", localException2);
          break;
          if (bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            nji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, 0);
            break;
          }
          nji.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, i1);
          break;
          Object localObject3;
          if ("3".equals(str5))
          {
            localObject3 = nji.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
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
            nji.a((Context)localObject3, this.jdField_a_of_type_JavaUtilHashMap);
            break;
          }
          if ("5".equals(str5))
          {
            nji.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
            break;
          }
          if (!"6".equals(str5)) {
            break label1145;
          }
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("v_url_base64")) {
            break;
          }
          try
          {
            localObject3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("v_url_base64"));
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break;
            }
            rjb.a(this.jdField_a_of_type_AndroidContentContext, "", (String)localObject3, null);
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            QLog.w("JumpAction", 1, "[gotoReadInJoyFromSourceTarget] openViolaPage, v_url error->" + localException3.getMessage());
          }
        }
        break;
        label1145:
        if ("7".equals(str5))
        {
          nji.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
          break;
        }
        if ("8".equals(str5))
        {
          if ("webview".equals(this.m))
          {
            wis.a().f(this.m);
            break;
          }
          KandianDailyManager.a(this.jdField_a_of_type_AndroidContentContext);
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
            localObject4 = localException3;
            if (TextUtils.isEmpty(localException3)) {
              localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131633855);
            }
            if (!bgmq.k()) {
              break label1336;
            }
            try
            {
              Intent localIntent1 = nji.a(this.jdField_a_of_type_AndroidContentContext, 12);
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
          bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localIntent2);
        }
      }
      break;
    }
  }
  
  public boolean q()
  {
    int i3 = 0;
    String str1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("sub_action"))
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sub_action");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("action_name")) {
        break label134;
      }
    }
    label134:
    for (String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("action_name");; str2 = "")
    {
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        break label141;
      }
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "subAction[" + str1 + "] or actionName[" + str2 + "] null");
      }
      return true;
      str1 = "";
      break;
    }
    label141:
    String str3;
    label169:
    String str4;
    label197:
    String str5;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tag"))
    {
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("tag");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("main_action")) {
        break label578;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("main_action");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("to_uin")) {
        break label585;
      }
      str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("to_uin");
      label225:
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("from_type")))) {
        break label634;
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
            awqx.b(null, str3, str4, str5, str1, str2, i1, i2, str6, str8, str9, str10);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("JumpAction", 2, "webReportT ");
            return true;
            str3 = "";
            break label169;
            label578:
            str4 = "";
            break label197;
            label585:
            str5 = "";
            break label225;
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
      label634:
      int i1 = 0;
    }
  }
  
  public boolean r()
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
      bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, i2, i3);
    }
    catch (Exception localException)
    {
      label327:
      break label327;
    }
    return true;
  }
  
  /* Error */
  public boolean s()
  {
    // Byte code:
    //   0: new 574	android/os/Bundle
    //   3: dup
    //   4: invokespecial 575	android/os/Bundle:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc_w 6256
    //   14: aload_0
    //   15: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   18: ldc_w 1960
    //   21: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 50	java/lang/String
    //   27: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload 5
    //   35: ldc_w 6258
    //   38: aload_0
    //   39: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   42: ldc_w 2578
    //   45: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast 50	java/lang/String
    //   51: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   54: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 5
    //   59: ldc_w 6260
    //   62: aload_0
    //   63: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   66: ldc_w 6262
    //   69: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 50	java/lang/String
    //   75: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 5
    //   80: ldc_w 6264
    //   83: aload_0
    //   84: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   87: ldc_w 6266
    //   90: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast 50	java/lang/String
    //   96: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 5
    //   101: ldc_w 6268
    //   104: aload_0
    //   105: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   108: ldc_w 6270
    //   111: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: checkcast 50	java/lang/String
    //   117: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 5
    //   122: ldc_w 6272
    //   125: aload_0
    //   126: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   129: ldc_w 6274
    //   132: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 50	java/lang/String
    //   138: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 5
    //   143: ldc_w 6276
    //   146: aload_0
    //   147: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   150: ldc_w 6278
    //   153: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: checkcast 50	java/lang/String
    //   159: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload 5
    //   164: ldc_w 6280
    //   167: iconst_0
    //   168: invokevirtual 597	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   171: aload 5
    //   173: ldc_w 6282
    //   176: ldc_w 657
    //   179: aload_0
    //   180: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   183: ldc_w 6284
    //   186: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   189: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   192: invokevirtual 597	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   195: aload 5
    //   197: ldc_w 6286
    //   200: aload_0
    //   201: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   204: ldc_w 6288
    //   207: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: checkcast 50	java/lang/String
    //   213: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   216: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   223: ldc_w 6290
    //   226: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   229: checkcast 989	java/lang/CharSequence
    //   232: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne +40 -> 275
    //   238: aload 5
    //   240: ldc_w 6292
    //   243: new 6294	java/math/BigInteger
    //   246: dup
    //   247: aload_0
    //   248: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   251: ldc_w 6290
    //   254: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   257: checkcast 50	java/lang/String
    //   260: invokespecial 6295	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   263: invokevirtual 6296	java/math/BigInteger:longValue	()J
    //   266: invokestatic 696	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: invokevirtual 583	java/lang/Long:longValue	()J
    //   272: invokevirtual 593	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   275: aload_0
    //   276: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   279: ldc_w 6298
    //   282: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   285: checkcast 989	java/lang/CharSequence
    //   288: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   291: ifne +30 -> 321
    //   294: aload 5
    //   296: ldc_w 6300
    //   299: aload_0
    //   300: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   303: ldc_w 6298
    //   306: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   309: checkcast 50	java/lang/String
    //   312: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   315: invokevirtual 673	java/lang/Integer:intValue	()I
    //   318: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   321: aload_0
    //   322: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   325: ldc_w 6302
    //   328: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   331: checkcast 989	java/lang/CharSequence
    //   334: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   337: ifne +24 -> 361
    //   340: aload 5
    //   342: ldc_w 6304
    //   345: aload_0
    //   346: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   349: ldc_w 6302
    //   352: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   355: checkcast 50	java/lang/String
    //   358: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload_0
    //   362: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   365: ldc_w 6306
    //   368: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: checkcast 50	java/lang/String
    //   374: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   377: ifne +1387 -> 1764
    //   380: aload 5
    //   382: ldc_w 6308
    //   385: aload_0
    //   386: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   389: ldc_w 6306
    //   392: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   395: checkcast 50	java/lang/String
    //   398: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   401: invokevirtual 673	java/lang/Integer:intValue	()I
    //   404: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   407: aload_0
    //   408: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   411: ldc_w 6310
    //   414: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   417: checkcast 50	java/lang/String
    //   420: astore 4
    //   422: aload 4
    //   424: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   427: ifne +19 -> 446
    //   430: aload 5
    //   432: ldc_w 6312
    //   435: aload 4
    //   437: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   440: invokevirtual 673	java/lang/Integer:intValue	()I
    //   443: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   446: aload 5
    //   448: ldc_w 6314
    //   451: aload_0
    //   452: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   455: ldc_w 6316
    //   458: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   461: checkcast 50	java/lang/String
    //   464: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload 5
    //   472: ldc_w 6318
    //   475: aload_0
    //   476: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   479: ldc_w 6320
    //   482: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   485: checkcast 50	java/lang/String
    //   488: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   491: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload_0
    //   495: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   498: ldc_w 6322
    //   501: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   504: checkcast 50	java/lang/String
    //   507: astore 4
    //   509: aload 4
    //   511: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   514: ifne +19 -> 533
    //   517: aload 5
    //   519: ldc_w 6322
    //   522: aload 4
    //   524: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   527: invokevirtual 673	java/lang/Integer:intValue	()I
    //   530: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   533: aload_0
    //   534: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   537: ldc_w 6324
    //   540: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   543: checkcast 50	java/lang/String
    //   546: astore 4
    //   548: aload 4
    //   550: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   553: ifne +19 -> 572
    //   556: aload 5
    //   558: ldc_w 6324
    //   561: aload 4
    //   563: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   566: invokevirtual 673	java/lang/Integer:intValue	()I
    //   569: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   572: aload_0
    //   573: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   576: ldc_w 6326
    //   579: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   582: checkcast 50	java/lang/String
    //   585: astore 4
    //   587: aload 4
    //   589: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   592: ifne +19 -> 611
    //   595: aload 5
    //   597: ldc_w 6326
    //   600: aload 4
    //   602: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   605: invokevirtual 673	java/lang/Integer:intValue	()I
    //   608: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   611: aload_0
    //   612: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   615: ldc_w 6328
    //   618: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   621: checkcast 50	java/lang/String
    //   624: astore 4
    //   626: aload 4
    //   628: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   631: ifne +19 -> 650
    //   634: aload 5
    //   636: ldc_w 6328
    //   639: aload 4
    //   641: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   644: invokevirtual 673	java/lang/Integer:intValue	()I
    //   647: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   650: aload_0
    //   651: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   654: ldc_w 5686
    //   657: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   660: checkcast 50	java/lang/String
    //   663: astore 4
    //   665: aload 4
    //   667: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   670: ifne +116 -> 786
    //   673: aload_0
    //   674: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   677: ldc_w 5688
    //   680: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   683: checkcast 50	java/lang/String
    //   686: astore 6
    //   688: aload_0
    //   689: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   692: ldc_w 5692
    //   695: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   698: checkcast 50	java/lang/String
    //   701: astore 7
    //   703: aload_0
    //   704: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   707: ldc_w 5694
    //   710: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   713: checkcast 50	java/lang/String
    //   716: astore 8
    //   718: new 6330	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData
    //   721: dup
    //   722: invokespecial 6331	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:<init>	()V
    //   725: astore 9
    //   727: aload 9
    //   729: aload 4
    //   731: putfield 6332	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   734: aload 9
    //   736: aload 6
    //   738: putfield 6333	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   741: aload 9
    //   743: ldc_w 372
    //   746: aload 7
    //   748: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   751: putfield 6334	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_b_of_type_Boolean	Z
    //   754: aload 9
    //   756: ldc_w 657
    //   759: aload 8
    //   761: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   764: putfield 6335	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_a_of_type_Boolean	Z
    //   767: aload 5
    //   769: ldc_w 6337
    //   772: iconst_1
    //   773: invokevirtual 597	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   776: aload 5
    //   778: ldc_w 6339
    //   781: aload 9
    //   783: invokevirtual 6343	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   786: ldc_w 657
    //   789: aload_0
    //   790: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   793: ldc_w 6345
    //   796: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   799: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   802: ifeq +1067 -> 1869
    //   805: iconst_1
    //   806: istore_1
    //   807: aload 5
    //   809: ldc_w 6347
    //   812: iload_1
    //   813: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   816: iload_1
    //   817: ifne +802 -> 1619
    //   820: aload_0
    //   821: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   824: ldc_w 6284
    //   827: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   830: checkcast 50	java/lang/String
    //   833: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   836: invokevirtual 673	java/lang/Integer:intValue	()I
    //   839: istore_2
    //   840: aload 5
    //   842: ldc_w 6349
    //   845: iload_2
    //   846: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   849: aload_0
    //   850: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   853: ldc_w 6351
    //   856: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   859: checkcast 50	java/lang/String
    //   862: invokestatic 580	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   865: invokevirtual 583	java/lang/Long:longValue	()J
    //   868: iconst_1
    //   869: invokestatic 6356	oby:a	(JZ)Ljava/lang/String;
    //   872: astore 4
    //   874: aload 5
    //   876: ldc_w 6358
    //   879: aload 4
    //   881: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   884: aload 5
    //   886: ldc_w 6360
    //   889: aload_0
    //   890: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   893: ldc_w 6362
    //   896: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   899: checkcast 50	java/lang/String
    //   902: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   905: aload 5
    //   907: ldc_w 6364
    //   910: aload_0
    //   911: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   914: ldc_w 6366
    //   917: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   920: checkcast 50	java/lang/String
    //   923: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   926: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: aload 5
    //   931: ldc_w 6368
    //   934: aload_0
    //   935: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   938: ldc_w 6370
    //   941: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   944: checkcast 50	java/lang/String
    //   947: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   950: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   953: aload 5
    //   955: ldc_w 6372
    //   958: aload_0
    //   959: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   962: ldc_w 6374
    //   965: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   968: checkcast 50	java/lang/String
    //   971: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   974: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   977: aload_0
    //   978: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   981: ldc_w 6376
    //   984: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   987: ifeq +46 -> 1033
    //   990: aload_0
    //   991: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   994: ldc_w 6376
    //   997: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1000: checkcast 989	java/lang/CharSequence
    //   1003: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1006: ifne +27 -> 1033
    //   1009: aload 5
    //   1011: ldc_w 6378
    //   1014: aload_0
    //   1015: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1018: ldc_w 6376
    //   1021: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1024: checkcast 50	java/lang/String
    //   1027: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1030: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: aload_0
    //   1034: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1037: ldc_w 6274
    //   1040: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1043: checkcast 50	java/lang/String
    //   1046: invokestatic 6383	ocm:a	(Ljava/lang/String;)Locs;
    //   1049: astore 4
    //   1051: aload 4
    //   1053: ifnull +29 -> 1082
    //   1056: aload 5
    //   1058: ldc_w 6385
    //   1061: aload 4
    //   1063: getfield 6388	ocs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1066: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1069: aload 5
    //   1071: ldc_w 6390
    //   1074: aload 4
    //   1076: getfield 6391	ocs:jdField_a_of_type_Long	J
    //   1079: invokevirtual 593	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1082: new 574	android/os/Bundle
    //   1085: dup
    //   1086: invokespecial 575	android/os/Bundle:<init>	()V
    //   1089: astore 4
    //   1091: aload 4
    //   1093: ldc_w 6393
    //   1096: aload_0
    //   1097: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1100: ldc_w 6274
    //   1103: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1106: checkcast 50	java/lang/String
    //   1109: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1112: aload 4
    //   1114: ldc_w 6395
    //   1117: aload_0
    //   1118: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1121: ldc_w 6274
    //   1124: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1127: checkcast 50	java/lang/String
    //   1130: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1133: aload 4
    //   1135: ldc_w 6397
    //   1138: aload_0
    //   1139: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1142: ldc_w 6262
    //   1145: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1148: checkcast 50	java/lang/String
    //   1151: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1154: invokevirtual 673	java/lang/Integer:intValue	()I
    //   1157: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1160: aload 4
    //   1162: ldc_w 6399
    //   1165: aload_0
    //   1166: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1169: ldc_w 6266
    //   1172: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1175: checkcast 50	java/lang/String
    //   1178: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1181: invokevirtual 673	java/lang/Integer:intValue	()I
    //   1184: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1187: aload 4
    //   1189: ldc_w 6401
    //   1192: aload_0
    //   1193: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1196: ldc_w 6270
    //   1199: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1202: checkcast 50	java/lang/String
    //   1205: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1208: invokevirtual 673	java/lang/Integer:intValue	()I
    //   1211: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1214: aload 4
    //   1216: ldc_w 6403
    //   1219: aload_0
    //   1220: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1223: ldc_w 6262
    //   1226: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1229: checkcast 50	java/lang/String
    //   1232: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1235: invokevirtual 673	java/lang/Integer:intValue	()I
    //   1238: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1241: aload_0
    //   1242: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1245: ldc_w 6284
    //   1248: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1251: checkcast 50	java/lang/String
    //   1254: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1257: invokevirtual 673	java/lang/Integer:intValue	()I
    //   1260: iconst_1
    //   1261: if_icmpne +797 -> 2058
    //   1264: aload 4
    //   1266: ldc_w 6405
    //   1269: aload_0
    //   1270: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1273: ldc_w 6362
    //   1276: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1279: checkcast 50	java/lang/String
    //   1282: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1285: aload 4
    //   1287: ldc_w 6407
    //   1290: aload_0
    //   1291: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1294: ldc_w 6366
    //   1297: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1300: checkcast 50	java/lang/String
    //   1303: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1306: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1309: aload 4
    //   1311: ldc_w 6409
    //   1314: aload_0
    //   1315: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1318: ldc_w 6362
    //   1321: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1324: checkcast 50	java/lang/String
    //   1327: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1330: aload 4
    //   1332: ldc_w 6411
    //   1335: aload_0
    //   1336: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1339: ldc_w 6284
    //   1342: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1345: checkcast 50	java/lang/String
    //   1348: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1351: invokevirtual 673	java/lang/Integer:intValue	()I
    //   1354: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1357: aload 4
    //   1359: ldc_w 6413
    //   1362: aload_0
    //   1363: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1366: ldc_w 6278
    //   1369: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1372: checkcast 50	java/lang/String
    //   1375: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1378: aload 4
    //   1380: ldc_w 6415
    //   1383: iconst_5
    //   1384: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1387: aload 4
    //   1389: ldc_w 6417
    //   1392: iconst_0
    //   1393: invokevirtual 597	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1396: aload 4
    //   1398: ldc_w 2276
    //   1401: aload_0
    //   1402: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1405: ldc_w 6320
    //   1408: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1411: checkcast 50	java/lang/String
    //   1414: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1417: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1420: aload 4
    //   1422: ldc_w 2270
    //   1425: aload_0
    //   1426: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1429: ldc_w 6316
    //   1432: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1435: checkcast 50	java/lang/String
    //   1438: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1441: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1444: aload 4
    //   1446: ldc_w 6288
    //   1449: aload_0
    //   1450: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1453: ldc_w 6274
    //   1456: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1459: checkcast 50	java/lang/String
    //   1462: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1465: aload 4
    //   1467: ldc_w 1960
    //   1470: aload_0
    //   1471: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1474: ldc_w 1960
    //   1477: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1480: checkcast 50	java/lang/String
    //   1483: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1486: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1489: aload 4
    //   1491: ldc_w 6419
    //   1494: aload_0
    //   1495: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1498: ldc_w 6351
    //   1501: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1504: checkcast 50	java/lang/String
    //   1507: invokestatic 580	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1510: invokevirtual 583	java/lang/Long:longValue	()J
    //   1513: invokestatic 6420	oby:a	(J)Ljava/lang/String;
    //   1516: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1519: aload 4
    //   1521: ldc_w 2280
    //   1524: aload_0
    //   1525: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1528: ldc_w 1960
    //   1531: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1534: checkcast 50	java/lang/String
    //   1537: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1540: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1543: aload 4
    //   1545: ldc_w 2185
    //   1548: sipush 140
    //   1551: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1554: aload 5
    //   1556: ldc_w 6422
    //   1559: aload 4
    //   1561: invokestatic 6427	awuw:a	(Landroid/os/Bundle;)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1564: checkcast 6429	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   1567: invokevirtual 6430	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getBytes	()[B
    //   1570: invokevirtual 6433	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1573: iload_2
    //   1574: bipush 6
    //   1576: if_icmpne +43 -> 1619
    //   1579: aload_0
    //   1580: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1583: ldc_w 6435
    //   1586: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1589: ifeq +30 -> 1619
    //   1592: aload 5
    //   1594: ldc_w 6437
    //   1597: aload_0
    //   1598: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1601: ldc_w 6435
    //   1604: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1607: checkcast 50	java/lang/String
    //   1610: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1613: invokestatic 6440	obz:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   1616: invokevirtual 6343	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1619: aload 5
    //   1621: ldc_w 6442
    //   1624: iconst_5
    //   1625: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1628: iload_1
    //   1629: iconst_1
    //   1630: if_icmpne +550 -> 2180
    //   1633: aload 5
    //   1635: ldc_w 6308
    //   1638: iconst_m1
    //   1639: invokevirtual 6443	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1642: invokestatic 6446	odw:a	(I)Z
    //   1645: istore_3
    //   1646: iload_3
    //   1647: ifeq +598 -> 2245
    //   1650: new 106	android/content/Intent
    //   1653: dup
    //   1654: invokespecial 395	android/content/Intent:<init>	()V
    //   1657: astore 4
    //   1659: aload 4
    //   1661: aload 5
    //   1663: invokevirtual 1189	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1666: pop
    //   1667: aload_0
    //   1668: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1671: aload 4
    //   1673: invokestatic 6449	com/tencent/biz/pubaccount/readinjoy/video/multivideo/MultiVideoFragment:a	(Landroid/content/Context;Landroid/content/Intent;)V
    //   1676: iconst_1
    //   1677: ireturn
    //   1678: astore 4
    //   1680: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1683: ifeq -1362 -> 321
    //   1686: ldc_w 435
    //   1689: iconst_2
    //   1690: new 197	java/lang/StringBuilder
    //   1693: dup
    //   1694: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1697: ldc_w 6451
    //   1700: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: aload_0
    //   1704: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1707: ldc_w 6290
    //   1710: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1713: checkcast 50	java/lang/String
    //   1716: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: ldc_w 6453
    //   1722: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: aload_0
    //   1726: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1729: ldc_w 6298
    //   1732: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1735: checkcast 50	java/lang/String
    //   1738: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1741: ldc_w 6455
    //   1744: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1747: aload 4
    //   1749: invokevirtual 2819	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1752: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1755: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1758: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1761: goto -1440 -> 321
    //   1764: aload 5
    //   1766: ldc_w 6308
    //   1769: bipush 100
    //   1771: invokevirtual 1530	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1774: goto -1367 -> 407
    //   1777: astore 4
    //   1779: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1782: ifeq -106 -> 1676
    //   1785: ldc_w 435
    //   1788: iconst_2
    //   1789: new 197	java/lang/StringBuilder
    //   1792: dup
    //   1793: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1796: ldc_w 6457
    //   1799: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1802: aload_0
    //   1803: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1806: ldc_w 6316
    //   1809: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1812: checkcast 50	java/lang/String
    //   1815: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: ldc_w 6459
    //   1821: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: aload_0
    //   1825: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1828: ldc_w 6316
    //   1831: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1834: checkcast 50	java/lang/String
    //   1837: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1840: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1843: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1846: iconst_1
    //   1847: ireturn
    //   1848: astore 4
    //   1850: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1853: ifeq -1203 -> 650
    //   1856: ldc_w 435
    //   1859: iconst_2
    //   1860: ldc_w 6461
    //   1863: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1866: goto -1216 -> 650
    //   1869: iconst_0
    //   1870: istore_1
    //   1871: goto -1064 -> 807
    //   1874: astore 4
    //   1876: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1879: ifeq +410 -> 2289
    //   1882: ldc_w 435
    //   1885: iconst_2
    //   1886: new 197	java/lang/StringBuilder
    //   1889: dup
    //   1890: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1893: ldc_w 6463
    //   1896: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1899: aload 4
    //   1901: invokevirtual 2819	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1904: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1910: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1913: goto +376 -> 2289
    //   1916: astore 4
    //   1918: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1921: ifeq -245 -> 1676
    //   1924: ldc_w 435
    //   1927: iconst_2
    //   1928: new 197	java/lang/StringBuilder
    //   1931: dup
    //   1932: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1935: ldc_w 6465
    //   1938: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: aload_0
    //   1942: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1945: ldc_w 6374
    //   1948: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1951: checkcast 50	java/lang/String
    //   1954: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1957: ldc_w 6467
    //   1960: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1963: aload_0
    //   1964: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1967: ldc_w 6376
    //   1970: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1973: checkcast 50	java/lang/String
    //   1976: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1979: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1982: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1985: iconst_1
    //   1986: ireturn
    //   1987: astore 4
    //   1989: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1992: ifeq -316 -> 1676
    //   1995: ldc_w 435
    //   1998: iconst_2
    //   1999: new 197	java/lang/StringBuilder
    //   2002: dup
    //   2003: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   2006: ldc_w 6469
    //   2009: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2012: aload_0
    //   2013: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2016: ldc_w 6284
    //   2019: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2022: checkcast 50	java/lang/String
    //   2025: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2028: ldc_w 6471
    //   2031: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: aload_0
    //   2035: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2038: ldc_w 6351
    //   2041: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2044: checkcast 50	java/lang/String
    //   2047: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2050: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2053: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2056: iconst_1
    //   2057: ireturn
    //   2058: aload_0
    //   2059: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2062: ldc_w 6473
    //   2065: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2068: ifeq +43 -> 2111
    //   2071: aload_0
    //   2072: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2075: ldc_w 6473
    //   2078: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2081: checkcast 989	java/lang/CharSequence
    //   2084: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2087: ifne +24 -> 2111
    //   2090: aload 4
    //   2092: ldc_w 6405
    //   2095: aload_0
    //   2096: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2099: ldc_w 6473
    //   2102: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2105: checkcast 50	java/lang/String
    //   2108: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2111: aload 4
    //   2113: ldc_w 6407
    //   2116: aload_0
    //   2117: getfield 102	bacn:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2120: ldc_w 6370
    //   2123: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2126: checkcast 50	java/lang/String
    //   2129: invokestatic 880	bacn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2132: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2135: goto -805 -> 1330
    //   2138: astore 6
    //   2140: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2143: ifeq -624 -> 1519
    //   2146: ldc_w 435
    //   2149: iconst_2
    //   2150: new 197	java/lang/StringBuilder
    //   2153: dup
    //   2154: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   2157: ldc_w 6475
    //   2160: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2163: aload 6
    //   2165: invokevirtual 2819	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2168: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2171: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2174: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2177: goto -658 -> 1519
    //   2180: aload 5
    //   2182: ldc_w 6308
    //   2185: iconst_m1
    //   2186: invokevirtual 6443	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   2189: aload 5
    //   2191: ldc_w 6264
    //   2194: invokevirtual 6476	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2197: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2200: invokevirtual 673	java/lang/Integer:intValue	()I
    //   2203: aload 5
    //   2205: ldc_w 6268
    //   2208: invokevirtual 6476	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2211: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2214: invokevirtual 673	java/lang/Integer:intValue	()I
    //   2217: aload 5
    //   2219: ldc_w 6260
    //   2222: invokevirtual 6476	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2225: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2228: invokevirtual 673	java/lang/Integer:intValue	()I
    //   2231: invokestatic 6479	odw:a	(IIII)Z
    //   2234: istore_3
    //   2235: goto -589 -> 1646
    //   2238: astore 4
    //   2240: iconst_0
    //   2241: istore_3
    //   2242: goto -596 -> 1646
    //   2245: new 106	android/content/Intent
    //   2248: dup
    //   2249: aload_0
    //   2250: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2253: ldc_w 6481
    //   2256: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2259: astore 4
    //   2261: aload 4
    //   2263: ldc_w 517
    //   2266: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2269: pop
    //   2270: aload 4
    //   2272: aload 5
    //   2274: invokevirtual 1189	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   2277: pop
    //   2278: aload_0
    //   2279: getfield 95	bacn:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2282: aload 4
    //   2284: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2287: iconst_1
    //   2288: ireturn
    //   2289: aconst_null
    //   2290: astore 4
    //   2292: goto -1418 -> 874
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2295	0	this	bacn
    //   806	1065	1	i1	int
    //   839	738	2	i2	int
    //   1645	597	3	bool	boolean
    //   420	1252	4	localObject	Object
    //   1678	70	4	localException1	Exception
    //   1777	1	4	localException2	Exception
    //   1848	1	4	localException3	Exception
    //   1874	26	4	localException4	Exception
    //   1916	1	4	localException5	Exception
    //   1987	125	4	localException6	Exception
    //   2238	1	4	localException7	Exception
    //   2259	32	4	localIntent	Intent
    //   7	2266	5	localBundle	Bundle
    //   686	51	6	str1	String
    //   2138	26	6	localException8	Exception
    //   701	46	7	str2	String
    //   716	44	8	str3	String
    //   725	57	9	localAnchorData	com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData
    // Exception table:
    //   from	to	target	type
    //   219	275	1678	java/lang/Exception
    //   275	321	1678	java/lang/Exception
    //   446	494	1777	java/lang/Exception
    //   494	533	1848	java/lang/Exception
    //   533	572	1848	java/lang/Exception
    //   572	611	1848	java/lang/Exception
    //   611	650	1848	java/lang/Exception
    //   849	874	1874	java/lang/Exception
    //   953	1033	1916	java/lang/Exception
    //   820	849	1987	java/lang/Exception
    //   874	953	1987	java/lang/Exception
    //   1033	1051	1987	java/lang/Exception
    //   1056	1082	1987	java/lang/Exception
    //   1082	1330	1987	java/lang/Exception
    //   1330	1489	1987	java/lang/Exception
    //   1519	1573	1987	java/lang/Exception
    //   1579	1619	1987	java/lang/Exception
    //   1876	1913	1987	java/lang/Exception
    //   1918	1985	1987	java/lang/Exception
    //   2058	2111	1987	java/lang/Exception
    //   2111	2135	1987	java/lang/Exception
    //   2140	2177	1987	java/lang/Exception
    //   1489	1519	2138	java/lang/Exception
    //   1633	1646	2238	java/lang/Exception
    //   2180	2235	2238	java/lang/Exception
  }
  
  public boolean t()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, AssistantSettingActivity.class);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean u()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
    Intent localIntent = new Intent((Activity)this.jdField_a_of_type_AndroidContentContext, ApolloGuestsStateActivity.class);
    localIntent.putExtra("extra_guest_nick", str1);
    localIntent.putExtra("extra_guest_uin", str2);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivity(localIntent);
    return true;
  }
  
  public boolean v()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean w()
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
  
  public boolean x()
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
                                for (String str15 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("msgurl"));; str15 = "")
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
                                    try
                                    {
                                      ((aqod)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(306)).a((Bundle)localObject2);
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
  
  public boolean y()
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
  
  public boolean z()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, InterestSwitchEditActivity.class);
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bacn
 * JD-Core Version:    0.7.0.1
 */
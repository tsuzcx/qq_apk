import QQWalletPay.ReqCheckChangePwdAuth;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.JumpAction.1;
import com.tencent.mobileqq.utils.JumpAction.11;
import com.tencent.mobileqq.utils.JumpAction.13;
import com.tencent.mobileqq.utils.JumpAction.14;
import com.tencent.mobileqq.utils.JumpAction.15;
import com.tencent.mobileqq.utils.JumpAction.17;
import com.tencent.mobileqq.utils.JumpAction.4;
import com.tencent.mobileqq.utils.JumpAction.8;
import com.tencent.mobileqq.utils.JumpAction.9;
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
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bbds
{
  public static int a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.mobileqq" };
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public aaqe a;
  private akev jdField_a_of_type_Akev;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public final Context a;
  protected Handler a;
  private bbef jdField_a_of_type_Bbef = new bbef(this, this);
  private bbeg jdField_a_of_type_Bbeg;
  protected bcpq a;
  bduv jdField_a_of_type_Bduv = new bbee(this);
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
  
  public bbds(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Aaqe = new bbdx(this);
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
    if (!bbev.g(BaseApplicationImpl.getApplication()))
    {
      bcpw.a(BaseApplicationImpl.getApplication(), 1, 2131694610, 1).a();
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
        localObject = new JSONObject(new String(bbca.decode(str1, 0)));
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
    if (!bbev.g(BaseApplicationImpl.getApplication()))
    {
      bcpw.a(BaseApplicationImpl.getApplication(), 1, 2131694610, 1).a();
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
    if (!bbev.g(BaseApplicationImpl.getApplication()))
    {
      bcpw.a(BaseApplicationImpl.getApplication(), 1, 2131694610, 1).a();
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
    boolean bool = ((Boolean)((tcv)tdc.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("token");
    if (!TextUtils.isEmpty(str)) {
      tsd.a(this.jdField_a_of_type_AndroidContentContext, str, new bbeb(this), null);
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
          tsd.a(this.jdField_a_of_type_JavaUtilHashMap);
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
    if ((((tgc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean) && (!"open".equals(this.c)) && (!"openTag".equals(this.c)) && (!"openSquare".equals(this.c)) && (!"publish".equals(this.c))) {
      return bv();
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page");
    String str1 = str2;
    if (String.valueOf(2).equals(str2))
    {
      tgc localtgc = (tgc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252);
      str1 = str2;
      if (localtgc != null)
      {
        str1 = str2;
        if (!localtgc.jdField_a_of_type_Boolean)
        {
          str1 = String.valueOf(0);
          this.jdField_a_of_type_JavaUtilHashMap.put("one_page", str1);
        }
      }
    }
    if ("0".equals(str1)) {
      return by();
    }
    if ("open".equals(this.c)) {
      return by();
    }
    return bv();
  }
  
  private boolean H()
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      if (TextUtils.isEmpty(anbl.a().h())) {}
      for (String str = "https://docs.qq.com/desktop/m/index.html?_from=1";; str = anbl.a().h())
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
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077F6", "0X80077F6", 0, 0, "", "", "", "");
    }
    do
    {
      return true;
      if ("10004".equals(str))
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077F7", "0X80077F7", 0, 0, "", "", "", "");
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
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5AF", "0X800A5AF", 0, 0, l1 + "", "", "", "");
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
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5AF", "0X800A5AF", 0, 0, l1 + "", "", "", "");
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
    boolean bool2 = akxc.a().a();
    akxg localakxg = (akxg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(220);
    Object localObject1;
    if (localakxg != null)
    {
      localObject1 = localakxg.a();
      QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is config info is " + localObject1);
      if (!localakxg.b()) {}
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
                  if (localakxg != null)
                  {
                    if ((localakxg.a() != null) && (!TextUtils.isEmpty(localakxg.a().jdField_e_of_type_JavaLangString))) {
                      break label1182;
                    }
                    localIntent.putExtra("icon_text", "QQ-AR");
                    if ((localakxg.a() != null) && (localakxg.a().c != null)) {
                      localIntent.putExtra("icon_url", localakxg.a().c);
                    }
                  }
                  this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
                  axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "0", str, "", "");
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
                  localIntent.putExtra("icon_text", localakxg.a().jdField_e_of_type_JavaLangString);
                  break label1021;
                  localObject3 = new StringBuilder("https://ti.qq.com/ar/help/error.html?_wv=3");
                  ((StringBuilder)localObject3).append("&from=");
                  ((StringBuilder)localObject3).append(str);
                  ((StringBuilder)localObject3).append("&args=");
                  new StringBuffer();
                  ((StringBuilder)localObject3).append(adqy.a((String)localObject1));
                  QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity QQBrowserActivity cost time is " + ((StringBuilder)localObject3).toString());
                  localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                  ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
                  ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject3).toString());
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                  axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "1", str, "", "");
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
      atbp.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
                        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007244", "0X8007244", 0, 0, "", "", "", "");
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
      bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131705895), 1).a();
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
    //   19: invokestatic 701	atbp:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   26: ldc_w 793
    //   29: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +224 -> 256
    //   35: aload_0
    //   36: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   39: ldc_w 793
    //   42: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 50	java/lang/String
    //   48: invokestatic 797	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   51: istore_2
    //   52: aload_0
    //   53: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   56: ldc_w 416
    //   59: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   62: ifeq +189 -> 251
    //   65: aload_0
    //   66: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   69: ldc_w 416
    //   72: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast 50	java/lang/String
    //   78: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   81: istore_1
    //   82: new 106	android/content/Intent
    //   85: dup
    //   86: aload_0
    //   87: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
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
    //   126: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   129: ldc_w 416
    //   132: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   135: ifeq +12 -> 147
    //   138: aload_3
    //   139: ldc_w 416
    //   142: iload_1
    //   143: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   146: pop
    //   147: aload_0
    //   148: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   151: ldc_w 793
    //   154: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   157: ifeq +12 -> 169
    //   160: aload_3
    //   161: ldc_w 793
    //   164: iload_2
    //   165: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   168: pop
    //   169: aload_0
    //   170: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   173: instanceof 397
    //   176: ifeq +41 -> 217
    //   179: aload_0
    //   180: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
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
    //   218: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   221: aload_3
    //   222: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   225: aload_0
    //   226: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   229: instanceof 745
    //   232: ifeq -29 -> 203
    //   235: aload_0
    //   236: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
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
    //   0	261	0	this	bbds
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
    if (bbbd.b(str))
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
      int i1 = Math.min(482, bazo.a((Activity)this.jdField_a_of_type_AndroidContentContext));
      localIntent1.putExtra("Business_Origin", 100);
      localIntent1.putExtra("open_chatfragment", true);
      localIntent1.putExtra("open_chat_from_avator", true);
      PhotoUtils.a(localIntent1, (Activity)this.jdField_a_of_type_AndroidContentContext, SplashActivity.class.getName(), i1, i1, 1080, 1080, str, bazo.a());
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800723E", "0X800723E", 0, 0, "", "", "", "");
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
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DF9", "0X8009DF9", 0, 0, str2, "", "", "");
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
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007243", "0X8007243", 0, 0, "", "", "", "");
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
      paramString = new String(bbca.decode(paramString, 0));
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
            ((bduw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str1, paramInt1, paramInt2);
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
        paramString = bbca.decode(new Cryptor().decrypt(bbdm.a(paramString), "Hf7K(s*js12LiskW".getBytes()), 0);
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
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), "0X8004B50", "0X8004B50", 0, 0, "", "", "", "");
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
    paramContext = amqr.b(250).a();
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
    //   4: ldc_w 1254
    //   7: invokevirtual 1257	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   10: ifne +14 -> 24
    //   13: aload_1
    //   14: ldc_w 1254
    //   17: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   20: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   23: pop
    //   24: ldc_w 1259
    //   27: aload_0
    //   28: getfield 1261	bbds:m	Ljava/lang/String;
    //   31: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +467 -> 501
    //   37: iconst_1
    //   38: istore 8
    //   40: aload_1
    //   41: ldc_w 1263
    //   44: iload 8
    //   46: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   49: pop
    //   50: aload_0
    //   51: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   54: ifnull +346 -> 400
    //   57: aload_0
    //   58: getfield 1267	bbds:jdField_h_of_type_Boolean	Z
    //   61: ifeq +339 -> 400
    //   64: aload_0
    //   65: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   68: getfield 1273	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   71: invokevirtual 1277	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   74: sipush 769
    //   77: if_icmpne +323 -> 400
    //   80: aload_0
    //   81: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   84: getfield 1280	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   87: invokevirtual 1277	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   90: istore 6
    //   92: aload_0
    //   93: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   96: ldc_w 1282
    //   99: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 50	java/lang/String
    //   105: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: istore 4
    //   110: aload_0
    //   111: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: invokevirtual 1285	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   117: ldc_w 1287
    //   120: iconst_0
    //   121: invokevirtual 1291	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   124: astore 9
    //   126: aload 9
    //   128: new 197	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 1293
    //   138: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   148: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: iconst_0
    //   155: invokeinterface 1298 3 0
    //   160: istore 7
    //   162: aload 9
    //   164: invokeinterface 1302 1 0
    //   169: new 197	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 1293
    //   179: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   186: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   189: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: iconst_0
    //   196: invokeinterface 1308 3 0
    //   201: invokeinterface 1311 1 0
    //   206: pop
    //   207: aload_0
    //   208: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   211: getfield 1315	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   214: invokevirtual 1319	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   217: ifeq +310 -> 527
    //   220: new 152	org/json/JSONObject
    //   223: dup
    //   224: aload_0
    //   225: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   228: getfield 1315	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   231: invokevirtual 1321	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   234: invokespecial 164	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   237: astore 9
    //   239: aload_0
    //   240: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   243: getfield 1325	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   246: invokevirtual 1328	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   249: ifeq +278 -> 527
    //   252: aload_0
    //   253: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   256: getfield 1325	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   259: invokevirtual 1329	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   262: ifne +265 -> 527
    //   265: ldc_w 372
    //   268: aload 9
    //   270: ldc_w 1331
    //   273: invokevirtual 1335	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   276: aload_0
    //   277: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   280: getfield 1325	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   283: iconst_0
    //   284: invokevirtual 1336	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   287: checkcast 50	java/lang/String
    //   290: invokevirtual 1335	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   293: ldc_w 1338
    //   296: invokevirtual 1146	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   299: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: istore 8
    //   304: iload 8
    //   306: ifeq +221 -> 527
    //   309: aload_1
    //   310: ldc_w 1340
    //   313: iload 5
    //   315: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   318: pop
    //   319: aload_1
    //   320: ldc_w 1342
    //   323: iload 6
    //   325: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   328: pop
    //   329: aload_1
    //   330: ldc_w 1344
    //   333: iload 7
    //   335: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   338: pop
    //   339: aload_1
    //   340: ldc_w 1346
    //   343: iload 4
    //   345: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   348: pop
    //   349: aload_0
    //   350: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   353: getfield 1325	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   356: invokevirtual 1328	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   359: ifeq +41 -> 400
    //   362: aload_0
    //   363: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   366: getfield 1325	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   369: invokevirtual 1329	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   372: ifne +28 -> 400
    //   375: aload_1
    //   376: ldc_w 1348
    //   379: new 1025	java/util/ArrayList
    //   382: dup
    //   383: aload_0
    //   384: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   387: getfield 1325	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   390: invokevirtual 1351	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   393: invokespecial 1354	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   396: invokevirtual 1357	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   399: pop
    //   400: aload_1
    //   401: ldc_w 1359
    //   404: aload_0
    //   405: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   408: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   411: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   414: pop
    //   415: aload_1
    //   416: ldc_w 1361
    //   419: iconst_1
    //   420: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   423: pop
    //   424: aload_1
    //   425: ldc_w 1363
    //   428: iconst_1
    //   429: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   432: pop
    //   433: aload_1
    //   434: ldc_w 1365
    //   437: aload_0
    //   438: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   441: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   444: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   447: pop
    //   448: aload_1
    //   449: ldc_w 1367
    //   452: ldc_w 1369
    //   455: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   458: pop
    //   459: aload_0
    //   460: aload_1
    //   461: invokespecial 1371	bbds:a	(Landroid/content/Intent;)V
    //   464: aload_1
    //   465: aload_0
    //   466: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   469: aload_2
    //   470: invokevirtual 1374	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   473: pop
    //   474: aload_0
    //   475: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   478: aload_1
    //   479: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   482: ldc_w 1376
    //   485: aload_3
    //   486: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   489: ifne +44 -> 533
    //   492: aload_0
    //   493: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   496: invokestatic 1382	cooperation/qwallet/plugin/QWalletHelper:preloadQWallet	(Lcom/tencent/common/app/AppInterface;)V
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
    //   533: new 1384	com/tencent/mobileqq/utils/JumpAction$21
    //   536: dup
    //   537: aload_0
    //   538: invokespecial 1385	com/tencent/mobileqq/utils/JumpAction$21:<init>	(Lbbds;)V
    //   541: iconst_5
    //   542: aconst_null
    //   543: iconst_1
    //   544: invokestatic 1388	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   547: iconst_1
    //   548: ireturn
    //   549: astore_1
    //   550: iconst_1
    //   551: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	bbds
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
        sxp.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), str2);
      } else {
        sxp.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), Long.valueOf(paramQQAppInterface).longValue());
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
          tvf.b(paramActivity, str2, paramQQAppInterface, i2);
          return true;
          i2 = 1;
          break;
        case 1: 
          if ("17".equals(str3)) {
            vel.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = str1;
          if (str1 == null) {
            paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
          }
          i2 = i1;
          if (i1 == 0) {
            i2 = 7;
          }
          tvf.b(paramActivity, str2, paramQQAppInterface, i2);
          return true;
        case 2: 
          if ("17".equals(str3)) {
            vel.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = (String)paramHashMap.get("et");
          paramQQAppInterface = (String)paramHashMap.get("time_zone");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            Integer.valueOf(paramQQAppInterface).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            tvf.a(paramActivity, str6, str1, 1, 109, 1, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            tvf.a(paramActivity, str5, str1, 1, 109, 1, null);
          }
          return false;
        case 3: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 30;
          }
          tvf.a(paramActivity, str2, str1, i2);
          return true;
        case 4: 
          paramQQAppInterface = (String)paramHashMap.get("collection_id");
          paramHashMap = (String)paramHashMap.get("time_zone");
          i3 = -1;
          if (!TextUtils.isEmpty(paramHashMap)) {
            i3 = Integer.valueOf(paramHashMap).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            tvf.a(paramActivity, str6, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str6), i3, i1, str1, i2, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            tvf.a(paramActivity, str5, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str5), i3, i1, str1, i2, null);
          }
          return false;
        case 7: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 19;
          }
          tvf.b(paramActivity, str2, str1, i2);
          return true;
        case 6: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 57;
          }
          tvf.b(paramActivity, str2, str1, i2);
          return true;
        case 5: 
          tvf.a(paramActivity, str6, str1, i2, i1, 0, null);
          return true;
        case 8: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 90;
          }
          tvf.b(paramActivity, str2, str1, i2);
          return true;
        case 9: 
          a(paramHashMap, "time_zone", -1);
          i2 = i1;
          if (i1 == 0) {
            i2 = 96;
          }
          tvf.a(paramActivity, str1, i2);
          return true;
        case 10: 
          paramQQAppInterface = (String)paramHashMap.get("bannerID");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            tvf.a(paramActivity, new OpenPlayerBuilder(new DiscoverBannerPlayInfo(paramQQAppInterface), 102).a());
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
  
  private boolean a(String paramString, boolean paramBoolean)
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
              break label1073;
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
                paramString = new bbdw(this);
                localBundle.putBoolean("key_require_storage_permission", paramBoolean);
                if ((i3 == 5) && ((i2 & 0x1) != 0)) {
                  bgyu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localBundle, paramString, 23);
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
                      bded.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str1, String.valueOf(l1), "11", "12", "0", paramString, "0", "0", false);
                      label858:
                      paramString = new bgxs();
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
                      axrl.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramString, null);
                      if ((!this.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
                        ((JumpActivity)this.jdField_a_of_type_AndroidContentContext).finish();
                      }
                      return true;
                      bgyu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localBundle, paramString);
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
          sxp.a(this.jdField_a_of_type_AndroidContentContext, 23, str3);
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
      str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
      localObject2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"));
      localObject3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_qzone_ext_str"));
      ((Bundle)localObject1).putString("open_id", str);
      ((Bundle)localObject1).putString("share_uin", (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((Bundle)localObject1).putString("share_ext_string", (String)localObject3);
      }
      i2 = Integer.valueOf(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"))).intValue();
      if (i2 != 3) {
        break label625;
      }
    }
    String str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
    Object localObject3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_url"));
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
        ((Bundle)localObject1).putString("app_name", a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")));
        if (!TextUtils.isEmpty(this.n)) {
          ((Bundle)localObject1).putString("hulian_appid", String.valueOf(l1));
        }
        ((Bundle)localObject1).putInt("req_type", i2);
        ((Bundle)localObject1).putLong("req_share_id", l1);
        ((Bundle)localObject1).putString("pkg_name", this.n);
        ((Bundle)localObject1).putBoolean("key_need_save_draft", false);
        ((Bundle)localObject1).putBoolean("key_require_storage_permission", paramBoolean);
        com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
        localObject2 = new bbdv(this);
        bgyu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, (DialogInterface.OnDismissListener)localObject2);
        localObject2 = new bgxs();
        ((bgxs)localObject2).c = "1";
        ((bgxs)localObject2).jdField_d_of_type_JavaLangString = "0";
        ((bgxs)localObject2).jdField_b_of_type_Int = 4;
        ((bgxs)localObject2).l = "5";
        ((bgxs)localObject2).m = "thirdApp";
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("source_type", "5");
        ((HashMap)localObject3).put("source_from", "thirdApp");
        localObject1 = ((Bundle)localObject1).getStringArrayList("images");
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 9))
        {
          ((bgxs)localObject2).n = "QZoneUploadPhotosActivity";
          ((HashMap)localObject3).put("source_to", "QZoneUploadPhotosActivity");
          QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (bgxs)localObject2);
          axrl.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject3, null);
          bded.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", l1 + "", "11", "12", "0", str, "", "4", false);
          return true;
          label625:
          if (i2 == 4) {
            str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoPath"));
          }
        }
        else
        {
          try
          {
            ((Bundle)localObject1).putLong("file_send_duration", Long.valueOf(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoDuration"))).longValue());
            try
            {
              label678:
              ((Bundle)localObject1).putLong("PhotoConst.VIDEO_SIZE", Long.valueOf(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoSize"))).longValue());
              label708:
              localObject2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("description"));
              ((Bundle)localObject1).putBoolean("PhotoConst.IS_VIDEO_SELECTED", true);
              ((Bundle)localObject1).putInt("PhotoConst.VIDEO_TYPE", 1);
              ((Bundle)localObject1).putString("file_send_path", str);
              ((Bundle)localObject1).putBoolean("need_process", false);
              ((Bundle)localObject1).putString("defaultText", (String)localObject2);
              str = "8";
              continue;
              ((bgxs)localObject2).n = "QZonePublishMoodActivity";
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
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007014", "0X8007014", 0, 0, "", "", "", "");
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
        if ((i1 == 100) && (bbbd.b((String)localObject3)))
        {
          ((Bundle)localObject2).putBoolean("from_babyq", true);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007241", "0X8007241", 0, 0, "", "", "", "");
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
      localObject3 = ((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e((String)localObject1);
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
      if (((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(str)) {
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
      localObject2 = new bhwg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      ((Intent)localObject1).putExtra("key_is_update_before_805", bamn.a(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new bhwg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bduv);
              ((bduw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str2);
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
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007245", "0X8007245", 0, 0, "", "", "", "");
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
        bamn.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, 2);
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
    bamn.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject, 2);
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
    //   21: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: ldc_w 707
    //   27: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 50	java/lang/String
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   38: ldc_w 2008
    //   41: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 50	java/lang/String
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   52: ldc_w 653
    //   55: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: checkcast 50	java/lang/String
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   66: ldc_w 2010
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
    //   114: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   117: ldc_w 2012
    //   120: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast 50	java/lang/String
    //   126: ldc_w 2014
    //   129: invokestatic 2016	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   175: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   178: ldc_w 2018
    //   181: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   184: checkcast 50	java/lang/String
    //   187: ldc_w 2014
    //   190: invokestatic 2016	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   236: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   239: ldc_w 2020
    //   242: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   245: checkcast 50	java/lang/String
    //   248: ldc_w 2014
    //   251: invokestatic 2016	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   297: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   300: ldc_w 2022
    //   303: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast 50	java/lang/String
    //   309: ldc_w 2014
    //   312: invokestatic 2016	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   358: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   361: ldc_w 2024
    //   364: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   367: checkcast 50	java/lang/String
    //   370: ldc_w 2014
    //   373: invokestatic 2016	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   419: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   422: ldc_w 2026
    //   425: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   428: checkcast 50	java/lang/String
    //   431: ldc_w 2014
    //   434: invokestatic 2016	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   587: invokevirtual 2027	java/lang/NullPointerException:printStackTrace	()V
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
    //   613: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   616: ifnull +170 -> 786
    //   619: new 106	android/content/Intent
    //   622: dup
    //   623: aload_0
    //   624: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   627: ldc_w 2029
    //   630: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   633: astore_3
    //   634: aload_3
    //   635: ldc_w 2031
    //   638: aload 7
    //   640: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   643: pop
    //   644: aload_3
    //   645: ldc_w 2033
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
    //   672: ldc_w 2035
    //   675: aload 10
    //   677: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   680: ifeq +138 -> 818
    //   683: aload_3
    //   684: ldc_w 2037
    //   687: iconst_0
    //   688: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   691: pop
    //   692: new 574	android/os/Bundle
    //   695: dup
    //   696: invokespecial 575	android/os/Bundle:<init>	()V
    //   699: astore 6
    //   701: aload 6
    //   703: ldc_w 2008
    //   706: aload 4
    //   708: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: aload 6
    //   713: ldc_w 2012
    //   716: aload 11
    //   718: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   721: aload 6
    //   723: ldc_w 2018
    //   726: aload 9
    //   728: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   731: aload 6
    //   733: ldc_w 2020
    //   736: aload 8
    //   738: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: aload 6
    //   743: ldc_w 2022
    //   746: aload 5
    //   748: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   751: aload 6
    //   753: ldc_w 2024
    //   756: aload_2
    //   757: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload 6
    //   762: ldc_w 2026
    //   765: aload_1
    //   766: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   769: aload_3
    //   770: ldc 142
    //   772: aload 6
    //   774: invokevirtual 612	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   777: pop
    //   778: aload_0
    //   779: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   782: aload_3
    //   783: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   786: aload_0
    //   787: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   790: ldc_w 1160
    //   793: ldc 61
    //   795: ldc 61
    //   797: ldc_w 2039
    //   800: ldc_w 2039
    //   803: iconst_0
    //   804: iconst_0
    //   805: ldc 61
    //   807: ldc 61
    //   809: ldc 61
    //   811: ldc 61
    //   813: invokestatic 427	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   816: iconst_1
    //   817: ireturn
    //   818: aload_3
    //   819: ldc_w 2037
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
    //   0	1161	0	this	bbds
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
    auvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str1, str2, 9, -1);
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
    abtu.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
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
    abtu.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
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
    if ((localObject3 == null) || ((!((String)localObject3).startsWith("http://")) && (!((String)localObject3).startsWith("https://"))) || ((!nax.b((String)localObject3).equalsIgnoreCase("qq.com")) && (!nax.b((String)localObject3).equalsIgnoreCase("myun.tenpay.com")) && (!nax.b((String)localObject3).equalsIgnoreCase("tenpay.com")) && (!nax.b((String)localObject3).equalsIgnoreCase("wanggou.com")) && (!nax.b((String)localObject3).equalsIgnoreCase("tencent.com")) && (!nax.b((String)localObject3).equalsIgnoreCase("jd.com")) && (!nax.b((String)localObject3).equalsIgnoreCase("qcloud.com")) && (!nax.b((String)localObject3).equalsIgnoreCase("webank.com")) && (!nax.b((String)localObject3).equalsIgnoreCase("qqumall.com")))) {
      return false;
    }
    if ((((String)localObject3).startsWith("https://jiazhang.qq.com/wap/com/")) || (((String)localObject3).startsWith("https://test.jiazhang.qq.com/wap/com/")))
    {
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))))
      {
        QLog.e("JumpAction", 1, "empty params");
        return false;
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"), "");
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
        localStringBuffer.append(bbdm.a(((Cryptor)localObject3).encrypt(b().getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      if ("1".equals(str4))
      {
        localStringBuffer.append("plg_usr=1");
        localStringBuffer.append("&");
        localStringBuffer.append("USER=");
        localStringBuffer.append(bbdm.a(((Cryptor)localObject3).encrypt(ajyc.a(2131705905).getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
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
        localObject1 = bfng.b(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
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
        localObject1 = bfng.b(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
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
          if (asji.a((Activity)this.jdField_a_of_type_AndroidContentContext, localException1, (Bundle)localObject3)) {
            return true;
          }
        }
      }
      Object localObject2;
      if ((this.n == null) || (!this.n.trim().equalsIgnoreCase("com.tx.android.txnews.new"))) {
        if ((this.n != null) && (this.n.trim().equalsIgnoreCase("com.qq.yijianfankui")))
        {
          localStringBuffer.append("&version=8.2.8.4440");
          localStringBuffer.append("&appid=" + AppSetting.a());
          localStringBuffer.append("&QUA=" + bgxr.a());
          localStringBuffer.append("&adtag=4440");
          localObject2 = Build.MODEL;
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            i1 = axrl.a();
            localObject3 = localObject2;
            if (i1 > 0) {
              localObject3 = (String)localObject2 + "_qzpatch" + i1;
            }
            localObject2 = Build.MANUFACTURER;
            if (localObject2 == null) {
              break label2129;
            }
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            localStringBuffer.append("&model=").append((String)localObject3).append("&manufacture=").append((String)localObject2).append("&cpunum=").append(bbct.b()).append("&cpurate=").append(bbct.a()).append("&mem=").append(bbct.d() / 1024L / 1024L).append("&w=").append(bbct.g()).append("&h=").append(bbct.h());
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
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("file_type");
    Object localObject = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_data"));
    String str2 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"));
    String str3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("file_uri"));
    String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("third_sd"));
    long l1 = ForwardUtils.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id"));
    int i1 = ForwardUtils.a(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("cflag")));
    boolean bool = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext);
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
      this.jdField_b_of_type_Boolean = false;
      ThreadManagerV2.executeOnSubThread(new JumpAction.13(this, str3, System.currentTimeMillis(), (HashMap)localObject));
      return false;
    }
    aqgh.a("KEY_STAGE_1_SAVE_IMAGE", 0L, (HashMap)localObject, false);
    return aP();
  }
  
  private boolean aP()
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
    label1235:
    label1241:
    label1262:
    String str2;
    label1276:
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
      boolean bool = aqft.a();
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
            break label1276;
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
            localBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131696697, new Object[] { str1 }));
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
              if ((i1 == 5) && (aqft.b()))
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
                  break label1235;
                }
                bool = true;
                localBundle.putBoolean("k_send", bool);
                localBundle.putInt("iUrlInfoFrm", 4);
                ((aqfm)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(350)).a().a(str5, l1, this.n);
                if (localObject1 == null) {
                  break label1262;
                }
                if (!MiniProgramOpenSdkUtil.isSharingMiniProgram(this.jdField_a_of_type_JavaUtilHashMap)) {
                  break label1241;
                }
                MiniProgramOpenSdkUtil.forwardShareWithTryCatch(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, localBundle, (Intent)localObject1);
                return true;
                localBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131696697, new Object[] { str8 }));
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
              aqbc.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1);
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
  
  private boolean aQ()
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
  
  private boolean aR()
  {
    Object localObject;
    String str2;
    bgyf localbgyf;
    String str1;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)))
    {
      localObject = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("page_id");
      if (str2 != null)
      {
        localbgyf = bgyf.a();
        localbgyf.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localbgyf.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
        SessionInfo localSessionInfo = ((FragmentActivity)localObject).getChatFragment().a().a();
        if ((localSessionInfo != null) && (!TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString))) {
          ((akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).e(localSessionInfo.jdField_a_of_type_JavaLangString, true);
        }
        if (!str2.equalsIgnoreCase("11")) {
          break label166;
        }
        bgxy.b((Activity)this.jdField_a_of_type_AndroidContentContext, localbgyf, str1, "mqqChat.QzoneCard", -1);
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
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, "缺少相册id", 1).a();
        } else {
          bgxy.a((Activity)this.jdField_a_of_type_AndroidContentContext, localbgyf, (String)localObject, str2, str1, "mqqChat.QzoneCard", -1);
        }
      }
    }
  }
  
  private boolean aS()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.common.activities.QzoneDialogActivity");
    localIntent.addFlags(805306368);
    bgxy.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localIntent, -1);
    return true;
  }
  
  private boolean aT()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (!bhou.a().b(this.n, this.jdField_a_of_type_JavaLangString))
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
        sni.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_h_of_type_Boolean);
        sjs.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_h_of_type_Boolean, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          return true;
          str = (String)bfng.a(this.jdField_a_of_type_JavaLangString).get("schema");
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
  
  private boolean aU()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return false;
    }
    long l1 = bgfp.a();
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
  
  private boolean aV()
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
              bgpr.a((AppRuntime)localObject8, "User_SdkShare", i2, 0, 0, 0, str1, (String)localObject6);
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
                    ((Bundle)localObject8).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131698170), new Object[] { localObject1 }));
                  }
                }
                else
                {
                  com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
                  localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
                  ((Intent)localObject1).putExtra("toUin", ajsf.L);
                  ((Intent)localObject1).putExtra("uinType", 0);
                  if (1 != i1) {
                    break label1692;
                  }
                  ((Intent)localObject1).putExtra("qqfav_extra_from_system_share", true);
                  ((Intent)localObject1).putExtras((Bundle)localObject8);
                  aqbc.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, DirectForwardActivity.class);
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
              ((Bundle)localObject8).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131698171));
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
                  bgpv.a(this.jdField_a_of_type_AndroidContentContext, 2131698168, 1);
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
                  ((Bundle)localObject8).putString("title", ((ArrayList)localObject10).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131694752));
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
                    ((Bundle)localObject8).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131698170), new Object[] { localObject1 }));
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
                ((Bundle)localObject8).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131698171));
                continue;
              }
              bgpv.a(this.jdField_a_of_type_AndroidContentContext, 2131698168, 1);
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
  
  private boolean aW()
  {
    int i1 = Integer.valueOf(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"))).intValue();
    if (i1 == 3)
    {
      str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_uri"));
      if (!TextUtils.isEmpty(str)) {
        ThreadManagerV2.executeOnSubThread(new JumpAction.14(this, str));
      }
    }
    while (i1 != 4)
    {
      return true;
      a(true);
      return true;
    }
    String str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoUri"));
    if (!TextUtils.isEmpty(str))
    {
      ThreadManagerV2.executeOnSubThread(new JumpAction.15(this, str));
      return true;
    }
    a(true);
    return true;
  }
  
  private boolean aX()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    String str3 = bgxr.a();
    bgyu.a(this.jdField_a_of_type_AndroidContentContext, str1, null, 0, str2, str3);
    return true;
  }
  
  private boolean aY()
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
        bgxy.a((Activity)this.jdField_a_of_type_AndroidContentContext, bgyf.a(), (Intent)localObject);
        return true;
      }
    }
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    if ((!TextUtils.isEmpty(str)) && (str.equals("login")))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, ajyc.a(2131705892), 1).a();
      return true;
    }
    bcpw.a(this.jdField_a_of_type_AndroidContentContext, ajyc.a(2131705902), 1).a();
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
      if (bfni.e()) {
        ((Intent)localObject).addFlags(32768);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
    }
  }
  
  private boolean aZ()
  {
    bcpw.a(this.jdField_a_of_type_AndroidContentContext, ajyc.a(2131705894), 1).a();
    return false;
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
      g();
      return false;
    }
    h();
    return false;
  }
  
  private boolean af()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("leftBackText", ajyc.a(2131705907));
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
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A519", "0X800A519", 0, 0, "", "", str4, str2);
    if (TextUtils.isEmpty(this.n))
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A51B", "0X800A51B", 0, 0, "", "", str4, str2);
      QLog.e("JumpAction", 1, "connectMiniApp fail: packageName is empty");
      return true;
    }
    if ("mini_program_or_game".equals(localObject))
    {
      if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
      {
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131699562, 1).a();
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
          aqgh.a("KEY_STAGE_2_CONNECT_MINI_D55");
          localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (str1 != null) {
            break label442;
          }
        }
        label442:
        for (localObject = "";; localObject = str1)
        {
          localMessageHandler.a(bool, (String)localObject, true, Long.valueOf(str2).longValue(), Long.valueOf(str4).longValue(), 1, Integer.valueOf(str3).intValue(), this.n, false, 0L, new bbdt(this, str4, str2, str5, str6, str1, str7));
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
      localObject1 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
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
      if (((ajxn)localObject1).b(str2))
      {
        localObject3 = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
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
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007191", "0X8007191", 0, 0, "", "", "", "");
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
      localObject4 = actn.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
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
            localObject3 = bbcl.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
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
            if (((ajxn)localObject1).b(str2)) {
              i1 = 0;
            }
            for (localObject1 = bbcl.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);; localObject1 = null)
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
            if (((ajxn)localObject1).b(str2))
            {
              i1 = 0;
              localObject3 = bbcl.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
              localObject2 = null;
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject2 != null) && (localObject4 != null))
        {
          localObject1 = bbdm.a((String)localObject4);
          break;
          if ("lbs".equals(localObject3))
          {
            i1 = 1001;
            localObject3 = bbcl.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            localObject2 = "rich_accost_sig";
          }
          else
          {
            i1 = 1010;
            localObject3 = bbcl.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            localObject2 = "rich_date_sig";
            continue;
            if ("public_account".equals(localObject3))
            {
              if ((str2 == null) || (str2.length() < 6)) {
                return false;
              }
              localObject1 = sgj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
              noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", str2, "0X800589E", "0X800589E", 0, 0, str2, "", "", "", false);
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
              localObject1 = actn.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
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
              if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
              {
                bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131699549, 1).a();
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
                    aqgh.a("KEY_STAGE_2_GO_TO_CHAT_D55");
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, str9, false, 0L, Long.valueOf(str10).longValue(), 1, i1, str11, false, 0L, new bbdu(this, str9, str10, (String)localObject3));
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
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B4B", "0X8004B4B", 0, 0, "", "", "", "");
            if ("webview".equals(this.m))
            {
              ((Intent)localObject4).putExtra("from", this.m);
              if (jdField_a_of_type_Int > 3)
              {
                bcpw.a(this.jdField_a_of_type_AndroidContentContext, ajyc.a(2131705890), 1).a();
                return true;
              }
              jdField_a_of_type_Int += 1;
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B5A", "0X8004B5A", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              if (str3 != null) {
                ((Intent)localObject4).putExtra("panel", str3);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
              return true;
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B58", "0X8004B58", 0, 0, "", "", "", "");
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
        localIntent.putExtra("sigt", bbdm.a(str6));
      }
      if (((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(str7))
      {
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("uinname", bbcl.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str7));
        label378:
        localIntent.putExtra("uin", str7);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          label398:
          ((bduw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str4, localException1, str3, str2, (String)localObject, str5, this.jdField_a_of_type_Bduv.jdField_a_of_type_Int);
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bduv);
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bduv);
          ((bduw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str5, str2, str1, str3, str4, str6);
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
      i1 = nbc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "handleLegacyCrmWPA " + i1);
      }
      localIntent.putExtra("from_wpa_for_crm", true);
      localIntent.putExtra("uin", str1);
      localIntent.putExtra("uintype", i1);
      if (i1 != 0) {
        break label404;
      }
      str4 = bbcl.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
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
        localObject = bbdm.a(str3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str1, (byte[])localObject);
      }
      if (str2 != null) {
        localIntent.putExtra("sigt", bbdm.a(str2));
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Bqq_Crm", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str1, "", "");
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
      localIntent = actn.a(localIntent, new int[] { 2 });
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
      atbp.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
    azml.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private boolean ar()
  {
    if ((String)this.jdField_a_of_type_JavaUtilHashMap.get("back_title") == null) {
      ajyc.a(2131705906);
    }
    azoa localazoa = (azoa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if (localazoa != null) {
      localazoa.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 0);
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
      localObject = bbcl.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
    //   1: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 3161
    //   7: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 50	java/lang/String
    //   13: astore 6
    //   15: aload_0
    //   16: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: ldc_w 3163
    //   22: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 50	java/lang/String
    //   28: astore 7
    //   30: aload 6
    //   32: ifnull +139 -> 171
    //   35: aload 7
    //   37: ifnull +134 -> 171
    //   40: aload 6
    //   42: invokevirtual 2274	java/lang/String:trim	()Ljava/lang/String;
    //   45: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   48: i2d
    //   49: ldc2_w 3193
    //   52: ddiv
    //   53: dstore_1
    //   54: aload 7
    //   56: invokevirtual 2274	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: istore 5
    //   64: iload 5
    //   66: i2d
    //   67: ldc2_w 3193
    //   70: ddiv
    //   71: dstore_3
    //   72: aload_0
    //   73: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   76: ldc_w 1565
    //   79: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 50	java/lang/String
    //   85: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   88: pop
    //   89: new 197	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 3196
    //   99: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: dload_3
    //   103: invokevirtual 3199	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   106: ldc_w 3201
    //   109: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: dload_1
    //   113: invokevirtual 3199	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   116: ldc_w 3203
    //   119: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 6
    //   127: new 106	android/content/Intent
    //   130: dup
    //   131: ldc_w 3205
    //   134: aload 6
    //   136: invokestatic 1540	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   139: invokespecial 3208	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   142: astore 7
    //   144: aload 7
    //   146: ldc_w 3210
    //   149: ldc_w 3212
    //   152: invokevirtual 1206	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: aload_0
    //   157: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
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
    //   176: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   179: new 106	android/content/Intent
    //   182: dup
    //   183: ldc_w 3205
    //   186: aload 6
    //   188: invokestatic 1540	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   191: invokespecial 3208	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   194: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   197: goto -32 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	bbds
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
      bcwv.a().a(5, str1, 0, str2);
      bcwv.a().a();
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
    //   1: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 3275
    //   7: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +329 -> 339
    //   13: aload_0
    //   14: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   17: ldc_w 3275
    //   20: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 50	java/lang/String
    //   26: astore 12
    //   28: aload_0
    //   29: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   32: ldc_w 3277
    //   35: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   38: ifeq +308 -> 346
    //   41: aload_0
    //   42: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   45: ldc_w 3277
    //   48: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 50	java/lang/String
    //   54: astore 11
    //   56: lconst_0
    //   57: lstore 5
    //   59: aload_0
    //   60: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   63: ldc_w 3279
    //   66: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   69: ifeq +1269 -> 1338
    //   72: ldc_w 657
    //   75: aload_0
    //   76: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   79: ldc_w 3279
    //   82: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq +1250 -> 1338
    //   91: iconst_1
    //   92: istore 9
    //   94: lload 5
    //   96: lstore 7
    //   98: aload_0
    //   99: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   102: ldc_w 3281
    //   105: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   108: ifeq +24 -> 132
    //   111: aload_0
    //   112: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   115: ldc_w 3281
    //   118: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: checkcast 50	java/lang/String
    //   124: invokestatic 580	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   127: invokevirtual 583	java/lang/Long:longValue	()J
    //   130: lstore 7
    //   132: aload_0
    //   133: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   136: ldc_w 3283
    //   139: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   142: ifeq +242 -> 384
    //   145: aload_0
    //   146: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   149: ldc_w 3283
    //   152: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: checkcast 50	java/lang/String
    //   158: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   161: invokevirtual 673	java/lang/Integer:intValue	()I
    //   164: istore_1
    //   165: aload_0
    //   166: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   169: ldc_w 3285
    //   172: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   175: ifeq +214 -> 389
    //   178: aload_0
    //   179: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   182: ldc_w 3285
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
    //   209: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   212: ldc_w 416
    //   215: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   218: ifeq +199 -> 417
    //   221: aload_0
    //   222: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   225: ldc_w 416
    //   228: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   231: checkcast 50	java/lang/String
    //   234: astore 13
    //   236: aload 13
    //   238: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   241: istore_2
    //   242: aload_0
    //   243: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   246: ldc_w 3287
    //   249: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   252: ifeq +179 -> 431
    //   255: aload_0
    //   256: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   259: ldc_w 3287
    //   262: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   265: checkcast 50	java/lang/String
    //   268: astore 13
    //   270: aload 13
    //   272: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   275: invokevirtual 673	java/lang/Integer:intValue	()I
    //   278: istore_3
    //   279: aload_0
    //   280: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   283: ldc_w 3289
    //   286: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   289: ifeq +156 -> 445
    //   292: aload_0
    //   293: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   296: ldc_w 3289
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
    //   359: ldc_w 3291
    //   362: invokestatic 439	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: lload 5
    //   367: lstore 7
    //   369: goto -237 -> 132
    //   372: astore 13
    //   374: ldc_w 435
    //   377: iconst_1
    //   378: ldc_w 3293
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
    //   466: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   469: ldc_w 3295
    //   472: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   475: astore 15
    //   477: aload 15
    //   479: ldc_w 3297
    //   482: iload 4
    //   484: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   487: pop
    //   488: aload 15
    //   490: ldc_w 3299
    //   493: iload 9
    //   495: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   498: pop
    //   499: aload 15
    //   501: ldc_w 3281
    //   504: lload 7
    //   506: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   509: pop
    //   510: aload 15
    //   512: ldc_w 3301
    //   515: iload_1
    //   516: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   519: pop
    //   520: iload_3
    //   521: tableswitch	default:+31 -> 552, 1:+33->554, 2:+33->554, 3:+437->958, 4:+696->1217
    //   553: ireturn
    //   554: aload_0
    //   555: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   558: ifnull +107 -> 665
    //   561: aload_0
    //   562: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   565: invokevirtual 1659	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   568: astore 11
    //   570: aload 12
    //   572: ldc_w 3303
    //   575: invokestatic 3306	bbbd:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   578: ifeq +361 -> 939
    //   581: aload_0
    //   582: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   585: ldc_w 3308
    //   588: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   591: ifeq +93 -> 684
    //   594: aload_0
    //   595: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   598: ldc_w 3308
    //   601: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   604: checkcast 50	java/lang/String
    //   607: astore 13
    //   609: aload_0
    //   610: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   613: ldc_w 3310
    //   616: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   619: ifeq +72 -> 691
    //   622: aload_0
    //   623: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   626: ldc_w 3310
    //   629: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   632: checkcast 50	java/lang/String
    //   635: astore 14
    //   637: aload 13
    //   639: aload 11
    //   641: invokestatic 3306	bbbd:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   644: ifne +54 -> 698
    //   647: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +13 -> 663
    //   653: ldc_w 435
    //   656: iconst_2
    //   657: ldc_w 3312
    //   660: invokestatic 439	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: iconst_1
    //   664: ireturn
    //   665: aload_0
    //   666: getfield 3314	bbds:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   669: ifnull +662 -> 1331
    //   672: aload_0
    //   673: getfield 3314	bbds:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   676: invokevirtual 3317	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   679: astore 11
    //   681: goto -111 -> 570
    //   684: ldc 61
    //   686: astore 13
    //   688: goto -79 -> 609
    //   691: ldc 61
    //   693: astore 14
    //   695: goto -58 -> 637
    //   698: aload 15
    //   700: ldc_w 3310
    //   703: aload 14
    //   705: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   708: pop
    //   709: aload 15
    //   711: ldc_w 3319
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
    //   747: ldc_w 3319
    //   750: bipush 12
    //   752: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   755: pop
    //   756: aload 11
    //   758: bipush 86
    //   760: putfield 3320	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   763: aload 15
    //   765: ldc_w 515
    //   768: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   771: pop
    //   772: iload_2
    //   773: iconst_2
    //   774: if_icmpne +19 -> 793
    //   777: aload 11
    //   779: bipush 87
    //   781: putfield 3320	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   784: aload 15
    //   786: ldc_w 515
    //   789: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   792: pop
    //   793: iload_2
    //   794: iconst_3
    //   795: if_icmpne +19 -> 814
    //   798: aload 11
    //   800: bipush 88
    //   802: putfield 3320	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   805: aload 15
    //   807: ldc_w 515
    //   810: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   813: pop
    //   814: iload_2
    //   815: bipush 7
    //   817: if_icmplt +29 -> 846
    //   820: aload 15
    //   822: ldc_w 3319
    //   825: iload_2
    //   826: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   829: pop
    //   830: aload 11
    //   832: bipush 86
    //   834: putfield 3320	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   837: aload 15
    //   839: ldc_w 515
    //   842: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   845: pop
    //   846: aload 15
    //   848: ldc_w 3322
    //   851: iload_3
    //   852: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   855: pop
    //   856: aload 15
    //   858: ldc_w 3324
    //   861: aload 11
    //   863: invokevirtual 1861	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   866: pop
    //   867: aload 12
    //   869: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   872: ifne +80 -> 952
    //   875: aload 12
    //   877: ldc_w 3326
    //   880: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   883: ifeq +69 -> 952
    //   886: iconst_1
    //   887: istore 9
    //   889: aload 15
    //   891: ldc_w 3328
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
    //   918: ldc_w 3330
    //   921: lload 5
    //   923: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   926: pop
    //   927: aload_0
    //   928: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   931: aload 15
    //   933: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   936: goto -384 -> 552
    //   939: aload 15
    //   941: ldc_w 3332
    //   944: iconst_1
    //   945: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   948: pop
    //   949: goto -221 -> 728
    //   952: iconst_0
    //   953: istore 9
    //   955: goto -66 -> 889
    //   958: aload_0
    //   959: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   962: ldc_w 653
    //   965: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   968: ifeq +42 -> 1010
    //   971: aload_0
    //   972: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
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
    //   1019: ldc_w 3322
    //   1022: iconst_3
    //   1023: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1026: pop
    //   1027: aload 15
    //   1029: ldc_w 3330
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
    //   1056: ldc_w 3332
    //   1059: iconst_1
    //   1060: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1063: pop
    //   1064: aload 15
    //   1066: ldc_w 3334
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
    //   1095: ldc_w 3319
    //   1098: bipush 12
    //   1100: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1103: pop
    //   1104: aload 11
    //   1106: bipush 86
    //   1108: putfield 3320	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1111: aload 15
    //   1113: ldc_w 515
    //   1116: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1119: pop
    //   1120: iload_2
    //   1121: iconst_2
    //   1122: if_icmpne +19 -> 1141
    //   1125: aload 11
    //   1127: bipush 87
    //   1129: putfield 3320	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1132: aload 15
    //   1134: ldc_w 515
    //   1137: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1140: pop
    //   1141: iload_2
    //   1142: iconst_3
    //   1143: if_icmpne +19 -> 1162
    //   1146: aload 11
    //   1148: bipush 88
    //   1150: putfield 3320	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1153: aload 15
    //   1155: ldc_w 515
    //   1158: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1161: pop
    //   1162: iload_2
    //   1163: bipush 7
    //   1165: if_icmplt +29 -> 1194
    //   1168: aload 15
    //   1170: ldc_w 3319
    //   1173: iload_2
    //   1174: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1177: pop
    //   1178: aload 11
    //   1180: bipush 86
    //   1182: putfield 3320	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1185: aload 15
    //   1187: ldc_w 515
    //   1190: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1193: pop
    //   1194: aload 15
    //   1196: ldc_w 3324
    //   1199: aload 11
    //   1201: invokevirtual 1861	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1204: pop
    //   1205: aload_0
    //   1206: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1209: aload 15
    //   1211: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1214: goto -662 -> 552
    //   1217: ldc 61
    //   1219: astore 11
    //   1221: aload_0
    //   1222: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1225: ifnull +87 -> 1312
    //   1228: aload_0
    //   1229: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1232: invokevirtual 1659	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1235: astore 11
    //   1237: new 932	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   1240: dup
    //   1241: aload 11
    //   1243: iconst_0
    //   1244: invokespecial 938	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   1247: astore 11
    //   1249: aload 15
    //   1251: ldc_w 3332
    //   1254: iconst_1
    //   1255: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1258: pop
    //   1259: aload 15
    //   1261: ldc_w 3322
    //   1264: iload_3
    //   1265: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1268: pop
    //   1269: aload 15
    //   1271: ldc_w 3324
    //   1274: aload 11
    //   1276: invokevirtual 1861	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1279: pop
    //   1280: aload 15
    //   1282: ldc_w 515
    //   1285: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1288: pop
    //   1289: aload 15
    //   1291: ldc_w 3330
    //   1294: lload 5
    //   1296: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1299: pop
    //   1300: aload_0
    //   1301: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1304: aload 15
    //   1306: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1309: goto -757 -> 552
    //   1312: aload_0
    //   1313: getfield 3314	bbds:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1316: ifnull -79 -> 1237
    //   1319: aload_0
    //   1320: getfield 3314	bbds:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1323: invokevirtual 3317	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
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
    //   0	1344	0	this	bbds
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
        localObject1 = new sfa();
        ((sfa)localObject1).a(new ProfileParams.CurLoginUsr((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"), (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"))).d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")).c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).a(i1).b((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
        sgj.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((sfa)localObject1).a());
        return false;
      }
    }
    else
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("source", 117);
      sgj.a((Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, i1);
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
    sgj.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str, -7);
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
      localFriends = ((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(str1);
      if (!bbbd.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
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
      QLog.i("JumpAction", 4, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard uin: %s  name: %s source: %s", new Object[] { bbbd.b(str1), bbbd.b(str2), str3 }));
      return false;
    }
    label302:
    return false;
  }
  
  private Intent b()
  {
    ((tcq)tdc.a(18)).a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  private String b()
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.MODEL;
    String str3 = bfmw.a("0db4c4");
    String str4 = bfmw.b("0db4c4");
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
            vel.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", paramQQAppInterface });
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
            tvf.a(paramActivity, paramQQAppInterface, str2, i2);
            break label705;
            label285:
            vel.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", paramQQAppInterface });
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
          tvf.a(paramActivity, str4, VideoCollectionEntry.getCollectionKey(1, paramString, str4), i2, i1, str2, i3, null);
          break label705;
        }
        if (TextUtils.isEmpty(str3)) {
          break label725;
        }
        tvf.a(paramActivity, str3, VideoCollectionEntry.getCollectionKey(1, paramString, str3), i2, i1, str2, i3, null);
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
              tvf.a(paramActivity, str4, str2, i3, i1, 0, null);
              break label727;
            }
            if (TextUtils.isEmpty(str3)) {
              break label729;
            }
            tvf.a(paramActivity, str3, str2, i3, i1, 0, null);
            break label727;
          }
          if ((!TextUtils.isEmpty(str5)) && (str5.equals(String.valueOf(1))))
          {
            i2 = i1;
            if (i1 == 0) {
              i2 = 57;
            }
            tvf.b(paramActivity, paramQQAppInterface, str2, i2);
            break label727;
          }
          if (!"onedaylist".equals(str5)) {
            break label731;
          }
          tvf.a(paramActivity, str4, str2, i3, i1, 0, null);
          break label727;
          tvf.b(paramActivity, paramQQAppInterface, str2, i2);
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
        tvf.b(paramActivity, paramQQAppInterface, str2, i2);
        break label727;
      }
    }
    for (;;)
    {
      tvf.b(paramActivity, paramQQAppInterface, paramHashMap, i2);
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
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80077DE", "0X80077DE", 0, 0, (String)localObject, "", "", "");
    localObject = a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
    if (RegisterPhoneNumActivity.class == localObject) {
      localIntent.putExtra("key_report_extra_from", 5);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean bB()
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
      xkq.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, str2, str1, str3, i1, null);
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
  
  private boolean bC()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (bbjw.a(str)) {
      str = "0";
    }
    for (;;)
    {
      aszj localaszj = (aszj)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppInterface().getManager(204);
      long l1 = Long.parseLong(str);
      localaszj.a(l1, new bbdz(this, l1));
      return true;
    }
  }
  
  private boolean bD()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomcode");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isgroupcode");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("backtype");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extra");
    arfe localarfe = (arfe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
    try
    {
      i1 = Integer.parseInt(str3);
      QLog.i("JumpAction", 1, "[goToGroupVideoPlugin], roomId:" + str1 + ",fromId:" + str2 + " isGroupCode:" + str3);
      localarfe.a(this.jdField_a_of_type_AndroidContentContext, str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), i1, "download", str2, str4, str5, str6);
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
  
  private boolean bE()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    localObject = (arfe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
    QLog.i("JumpAction", 1, "[goToPreLoadGroupVideoPlugin]");
    ((arfe)localObject).a(null, 10L);
    return true;
  }
  
  private boolean bF()
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
      bamn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject);
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
      bamn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject, str, i1);
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
      localBundle.putString("selfSet_leftViewText", ajyc.a(2131705889));
      BulkSendMessageFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, localBundle);
    }
  }
  
  private boolean bG()
  {
    bcpq localbcpq = new bcpq(this.jdField_a_of_type_AndroidContentContext, 0, 2131558632, 17);
    localbcpq.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690241));
    localbcpq.getWindow().setDimAmount(0.0F);
    localbcpq.show();
    localbcpq.setCanceledOnTouchOutside(true);
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app");
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.e("JumpAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen jumpAction. appName=null");
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("meta");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(121);
    ArkAppMgr.getInstance().getAppPathByName(str1, str3, "0.0.0.1", "", new bbea(this, localbcpq, str3, str2, str1));
    return true;
  }
  
  private boolean bH()
  {
    arla localarla = (arla)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(338);
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
          localarla.a(localNewTogetherRoomMessageData);
          return true;
          str1 = "0";
          break;
          str1 = "0";
          break label128;
        }
      }
    }
  }
  
  private boolean bI()
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
      ((Intent)localObject1).putExtra("key_is_update_before_805", bamn.a(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
      ((Intent)localObject1).putExtra("troop_manage_from_jump_action", true);
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new bhwg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    return true;
  }
  
  private boolean bb()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      bgyf localbgyf = bgyf.a();
      localbgyf.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localbgyf.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      bgxy.a((Activity)this.jdField_a_of_type_AndroidContentContext, localbgyf, -1);
      return true;
    }
    return false;
  }
  
  private boolean bc()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(str))
        {
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          bgxy.a((Activity)this.jdField_a_of_type_AndroidContentContext, bgyf.a(), str, 0, 0, 0);
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
  
  private boolean bd()
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
  
  private boolean be()
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
  
  private boolean bf()
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
          ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131691275));
          ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131691644));
          ((Intent)localObject).putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131691645));
          ((Intent)localObject).putExtra("param_max", 99);
          ((Intent)localObject).setFlags(603979776);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 1);
        }
      }
      do
      {
        return true;
        return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 3000, (String)localObject, true, true, this.jdField_a_of_type_Aaqe, localHashMap);
        if (str3.equals("single"))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("forward_type", 13);
          ((Intent)localObject).putExtra("fromWebXman", true);
          aqbc.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 2);
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
      return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, true, bool, this.jdField_a_of_type_Aaqe, this.jdField_a_of_type_JavaUtilHashMap);
      return false;
    }
  }
  
  private boolean bg()
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
            localObject3 = ((askl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c((String)localObject2);
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
              return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, (String)localObject2, (String)localObject1, (String)localObject3, bool1, str1, bool2, true, this.jdField_a_of_type_Aaqe, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
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
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696045);
            }
            bool1 = true;
            bool2 = false;
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            continue;
          }
          i2 = bbcl.a(i1);
          if (i2 != -1) {
            continue;
          }
        }
        localObject4 = bbcl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, i1);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = localObject4;
          if (!((String)localObject1).equals(localObject4)) {}
        }
        else
        {
          localObject2 = bbcl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label744;
        }
        bool2 = true;
        localObject2 = localObject1;
        localObject4 = localObject5;
        continue;
        localObject4 = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, str1, i2, 0);
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
  
  private boolean bh()
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
              bool2 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1011, null, null, null, bool1, null, false, true, this.jdField_a_of_type_Aaqe, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
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
  
  private boolean bi()
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
  private boolean bj()
  {
    // Byte code:
    //   0: new 106	android/content/Intent
    //   3: dup
    //   4: ldc_w 3181
    //   7: invokespecial 3150	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   10: astore 14
    //   12: aload_0
    //   13: aload 14
    //   15: invokespecial 1371	bbds:a	(Landroid/content/Intent;)V
    //   18: aconst_null
    //   19: astore 9
    //   21: aconst_null
    //   22: astore 8
    //   24: aconst_null
    //   25: astore 10
    //   27: aload_0
    //   28: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   31: invokevirtual 533	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   34: astore 12
    //   36: iconst_0
    //   37: istore_1
    //   38: ldc 61
    //   40: astore 11
    //   42: aload_0
    //   43: ldc_w 2196
    //   46: invokevirtual 829	bbds:b	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 13
    //   51: aload 13
    //   53: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +14 -> 70
    //   59: aload 14
    //   61: ldc_w 2346
    //   64: aload 13
    //   66: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   69: pop
    //   70: aload_0
    //   71: ldc_w 3852
    //   74: invokevirtual 829	bbds:b	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +62 -> 142
    //   83: aload 14
    //   85: ldc_w 2257
    //   88: invokestatic 2260	java/lang/System:nanoTime	()J
    //   91: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   94: pop
    //   95: aload 14
    //   97: ldc_w 1254
    //   100: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   103: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   106: pop
    //   107: aload 14
    //   109: ldc_w 1214
    //   112: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   115: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   118: pop
    //   119: aload 14
    //   121: ldc_w 2266
    //   124: iconst_1
    //   125: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   128: pop
    //   129: aload 14
    //   131: ldc_w 2264
    //   134: aload_0
    //   135: getfield 1267	bbds:jdField_h_of_type_Boolean	Z
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
    //   207: ldc_w 3854
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
    //   241: ldc_w 3856
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
    //   271: ldc_w 3858
    //   274: aload 13
    //   276: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   279: ifeq +57 -> 336
    //   282: ldc_w 657
    //   285: aload 12
    //   287: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   290: ifeq +2737 -> 3027
    //   293: aload 14
    //   295: ldc_w 3183
    //   298: aload_0
    //   299: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
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
    //   336: ldc_w 3860
    //   339: aload 13
    //   341: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   344: ifeq +89 -> 433
    //   347: ldc_w 657
    //   350: aload 12
    //   352: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   355: ifeq +2672 -> 3027
    //   358: aload_0
    //   359: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   362: invokevirtual 2578	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   365: astore 13
    //   367: aload 13
    //   369: astore 12
    //   371: aload 13
    //   373: invokestatic 3523	bbjw:a	(Ljava/lang/String;)Z
    //   376: ifeq +19 -> 395
    //   379: aload_0
    //   380: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   383: aload_0
    //   384: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   387: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   390: invokestatic 3185	bbcl:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   393: astore 12
    //   395: aload 14
    //   397: ldc_w 1796
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
    //   433: ldc_w 2156
    //   436: aload 13
    //   438: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   441: ifeq +57 -> 498
    //   444: ldc_w 657
    //   447: aload 12
    //   449: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   452: ifeq +2575 -> 3027
    //   455: aload 14
    //   457: ldc_w 3862
    //   460: aload_0
    //   461: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   464: invokevirtual 2188	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
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
    //   498: ldc_w 3864
    //   501: aload 13
    //   503: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   506: ifeq +53 -> 559
    //   509: ldc_w 657
    //   512: aload 12
    //   514: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   517: ifeq +2510 -> 3027
    //   520: aload 14
    //   522: ldc_w 3866
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
    //   559: ldc_w 3868
    //   562: aload 13
    //   564: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   567: ifeq +90 -> 657
    //   570: ldc_w 657
    //   573: aload 12
    //   575: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   578: ifeq +2449 -> 3027
    //   581: aload 14
    //   583: ldc_w 3870
    //   586: aload_0
    //   587: getfield 3872	bbds:jdField_g_of_type_Boolean	Z
    //   590: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   593: pop
    //   594: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +2430 -> 3027
    //   600: ldc_w 3874
    //   603: iconst_2
    //   604: new 197	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 3876
    //   614: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_0
    //   618: getfield 3872	bbds:jdField_g_of_type_Boolean	Z
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
    //   657: ldc_w 3878
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
    //   704: ldc_w 3880
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
    //   823: getfield 3881	bbds:jdField_a_of_type_Boolean	Z
    //   826: ifeq +22 -> 848
    //   829: invokestatic 3886	bbeh:a	()Lbbeh;
    //   832: aload_0
    //   833: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   836: aload 9
    //   838: aload 8
    //   840: invokevirtual 3889	bbeh:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
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
    //   862: getstatic 54	bbds:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
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
    //   903: ldc_w 3862
    //   906: aconst_null
    //   907: checkcast 50	java/lang/String
    //   910: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   913: pop
    //   914: aload 14
    //   916: ldc_w 3891
    //   919: aconst_null
    //   920: checkcast 50	java/lang/String
    //   923: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   926: pop
    //   927: aload 14
    //   929: ldc_w 1796
    //   932: aconst_null
    //   933: checkcast 50	java/lang/String
    //   936: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   939: pop
    //   940: aload 14
    //   942: ldc_w 3183
    //   945: aconst_null
    //   946: checkcast 50	java/lang/String
    //   949: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   952: pop
    //   953: aload 8
    //   955: ldc_w 2508
    //   958: invokevirtual 2113	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   961: ifeq +112 -> 1073
    //   964: aload 14
    //   966: ldc_w 3893
    //   969: ldc_w 3895
    //   972: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   975: pop
    //   976: aload_0
    //   977: getfield 63	bbds:r	Ljava/lang/String;
    //   980: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   983: ifne +16 -> 999
    //   986: aload 14
    //   988: ldc_w 3897
    //   991: aload_0
    //   992: getfield 63	bbds:r	Ljava/lang/String;
    //   995: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   998: pop
    //   999: aload_0
    //   1000: getfield 65	bbds:s	Ljava/lang/String;
    //   1003: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1006: ifne +16 -> 1022
    //   1009: aload 14
    //   1011: ldc_w 3899
    //   1014: aload_0
    //   1015: getfield 65	bbds:s	Ljava/lang/String;
    //   1018: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1021: pop
    //   1022: aload_0
    //   1023: getfield 67	bbds:t	Ljava/lang/String;
    //   1026: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1029: ifne +16 -> 1045
    //   1032: aload 14
    //   1034: ldc_w 3901
    //   1037: aload_0
    //   1038: getfield 67	bbds:t	Ljava/lang/String;
    //   1041: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1044: pop
    //   1045: aload 14
    //   1047: ldc_w 3903
    //   1050: aload_0
    //   1051: getfield 3905	bbds:jdField_i_of_type_Boolean	Z
    //   1054: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1057: pop
    //   1058: aload 14
    //   1060: aload 8
    //   1062: invokestatic 3911	cooperation/qzone/report/lp/QZoneLoginReportHelper:needAddLoginFromLebaTab	(Landroid/content/Intent;Ljava/lang/String;)Z
    //   1065: ifeq +8 -> 1073
    //   1068: aload 14
    //   1070: invokestatic 3914	cooperation/qzone/report/lp/QZoneLoginReportHelper:setLoginFromLebaTab	(Landroid/content/Intent;)V
    //   1073: iload_1
    //   1074: ifne +1882 -> 2956
    //   1077: aload 8
    //   1079: ldc_w 2508
    //   1082: invokevirtual 2113	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1085: ifeq +104 -> 1189
    //   1088: aload 14
    //   1090: aload 8
    //   1092: invokestatic 2623	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1095: aload 14
    //   1097: ldc_w 517
    //   1100: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1103: pop
    //   1104: aload_0
    //   1105: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1108: checkcast 745	android/app/Activity
    //   1111: aload_0
    //   1112: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1115: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1118: aload 14
    //   1120: iconst_m1
    //   1121: invokestatic 3916	bgxy:c	(Landroid/app/Activity;Ljava/lang/String;Landroid/content/Intent;I)V
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
    //   1140: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1143: ldc_w 3918
    //   1146: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1149: astore 8
    //   1151: aload 8
    //   1153: ldc_w 515
    //   1156: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1159: pop
    //   1160: aload 8
    //   1162: aload 14
    //   1164: invokevirtual 2807	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   1167: pop
    //   1168: aload_0
    //   1169: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1172: aload 8
    //   1174: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1177: goto -53 -> 1124
    //   1180: astore 8
    //   1182: aload 8
    //   1184: invokevirtual 3919	android/content/ActivityNotFoundException:printStackTrace	()V
    //   1187: iconst_0
    //   1188: ireturn
    //   1189: aload 8
    //   1191: ldc_w 3921
    //   1194: invokevirtual 2248	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1197: ifeq +60 -> 1257
    //   1200: aload_0
    //   1201: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1204: aload_0
    //   1205: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1208: invokestatic 3169	azml:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)V
    //   1211: aload_0
    //   1212: getfield 1267	bbds:jdField_h_of_type_Boolean	Z
    //   1215: ifeq +1841 -> 3056
    //   1218: ldc_w 372
    //   1221: astore 8
    //   1223: aload_0
    //   1224: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1227: ldc_w 3018
    //   1230: ldc_w 3923
    //   1233: ldc 61
    //   1235: ldc_w 3925
    //   1238: ldc_w 3927
    //   1241: iconst_0
    //   1242: iconst_0
    //   1243: ldc 61
    //   1245: ldc 61
    //   1247: ldc 61
    //   1249: aload 8
    //   1251: invokestatic 427	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1254: goto -130 -> 1124
    //   1257: aload 8
    //   1259: ldc_w 3929
    //   1262: invokevirtual 2248	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1265: istore 6
    //   1267: iload 6
    //   1269: ifeq +234 -> 1503
    //   1272: aload_0
    //   1273: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1276: checkcast 2567	android/support/v4/app/FragmentActivity
    //   1279: invokevirtual 2584	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   1282: astore 9
    //   1284: aload 9
    //   1286: ifnull -162 -> 1124
    //   1289: aload 9
    //   1291: invokevirtual 2589	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1294: ifnull -170 -> 1124
    //   1297: aload 9
    //   1299: invokevirtual 2589	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1302: invokevirtual 3931	com/tencent/mobileqq/activity/BaseChatPie:aL	()V
    //   1305: aload 9
    //   1307: invokevirtual 2589	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1310: getfield 3934	com/tencent/mobileqq/activity/BaseChatPie:a	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1313: getfield 3935	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   1316: istore_1
    //   1317: aload 14
    //   1319: ldc_w 653
    //   1322: aload_0
    //   1323: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1326: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1329: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1332: pop
    //   1333: aload 14
    //   1335: ldc_w 3937
    //   1338: iload_1
    //   1339: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1342: pop
    //   1343: aload 14
    //   1345: ldc_w 3163
    //   1348: invokevirtual 815	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1351: astore 11
    //   1353: aload 14
    //   1355: ldc_w 3161
    //   1358: invokevirtual 815	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1361: astore 10
    //   1363: aload 14
    //   1365: ldc_w 3939
    //   1368: invokevirtual 815	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1371: astore 9
    //   1373: aload 11
    //   1375: ifnull +80 -> 1455
    //   1378: aload 10
    //   1380: ifnull +75 -> 1455
    //   1383: aload 11
    //   1385: invokestatic 3944	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1388: astore 11
    //   1390: aload 10
    //   1392: invokestatic 3944	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1395: astore 10
    //   1397: aload 14
    //   1399: ldc_w 391
    //   1402: new 197	java/lang/StringBuilder
    //   1405: dup
    //   1406: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1409: ldc_w 3196
    //   1412: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: aload 11
    //   1417: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1420: ldc_w 3201
    //   1423: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: aload 10
    //   1428: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1431: ldc_w 3946
    //   1434: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: aload 9
    //   1439: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1442: ldc_w 3948
    //   1445: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1451: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1454: pop
    //   1455: aload 14
    //   1457: aload_0
    //   1458: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1461: invokevirtual 3951	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1464: aload 8
    //   1466: invokevirtual 1206	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1469: pop
    //   1470: aload_0
    //   1471: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1474: checkcast 2837	com/tencent/mobileqq/app/BaseActivity
    //   1477: aload 14
    //   1479: bipush 18
    //   1481: invokevirtual 3772	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1484: ldc_w 3953
    //   1487: invokestatic 3956	xnq:a	(Ljava/lang/String;)V
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
    //   1521: ldc_w 3958
    //   1524: invokevirtual 1958	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1527: ifeq +269 -> 1796
    //   1530: aload 9
    //   1532: ldc 52
    //   1534: invokevirtual 1958	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1537: ifeq +259 -> 1796
    //   1540: new 644	java/lang/StringBuffer
    //   1543: dup
    //   1544: invokespecial 645	java/lang/StringBuffer:<init>	()V
    //   1547: astore 12
    //   1549: aload_0
    //   1550: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1553: ifnull +231 -> 1784
    //   1556: aload_0
    //   1557: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1560: getfield 3960	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1563: invokevirtual 1277	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1566: ifle +218 -> 1784
    //   1569: aload_0
    //   1570: getfield 3872	bbds:jdField_g_of_type_Boolean	Z
    //   1573: ifeq +211 -> 1784
    //   1576: aload 12
    //   1578: ldc_w 3962
    //   1581: invokevirtual 2159	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1584: pop
    //   1585: aload_0
    //   1586: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1589: getfield 3960	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1592: invokevirtual 3963	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1595: ifeq +38 -> 1633
    //   1598: aload 12
    //   1600: new 197	java/lang/StringBuilder
    //   1603: dup
    //   1604: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1607: ldc_w 3965
    //   1610: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: aload_0
    //   1614: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1617: getfield 3960	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1620: invokevirtual 1277	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1623: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1626: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1629: invokevirtual 2159	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1632: pop
    //   1633: aload_0
    //   1634: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1637: getfield 1315	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1640: invokevirtual 1319	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1643: istore 6
    //   1645: iload 6
    //   1647: ifeq +48 -> 1695
    //   1650: aload_0
    //   1651: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1654: getfield 1315	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1657: invokevirtual 1321	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1660: ldc_w 1071
    //   1663: invokestatic 1077	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1666: astore 10
    //   1668: aload 12
    //   1670: new 197	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1677: ldc_w 3967
    //   1680: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: aload 10
    //   1685: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1691: invokevirtual 2159	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1694: pop
    //   1695: aload_0
    //   1696: ldc_w 391
    //   1699: invokevirtual 829	bbds:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1702: astore 11
    //   1704: aload 11
    //   1706: astore 10
    //   1708: aload 11
    //   1710: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1713: ifne +27 -> 1740
    //   1716: aload 11
    //   1718: astore 10
    //   1720: aload 11
    //   1722: invokestatic 3971	wim:g	(Ljava/lang/String;)Z
    //   1725: ifeq +15 -> 1740
    //   1728: aload 11
    //   1730: aload 12
    //   1732: invokevirtual 2199	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1735: invokestatic 3975	mze:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1738: astore 10
    //   1740: aload_0
    //   1741: aload 10
    //   1743: aload 9
    //   1745: aload 8
    //   1747: aload 14
    //   1749: invokespecial 3977	bbds:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1752: aload_0
    //   1753: aload 8
    //   1755: invokespecial 3979	bbds:g	(Ljava/lang/String;)V
    //   1758: goto -634 -> 1124
    //   1761: astore 10
    //   1763: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1766: ifeq +1298 -> 3064
    //   1769: ldc_w 435
    //   1772: iconst_2
    //   1773: aload 10
    //   1775: invokevirtual 3980	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   1778: invokestatic 456	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1781: goto +1283 -> 3064
    //   1784: aload 12
    //   1786: ldc_w 3982
    //   1789: invokevirtual 2159	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1792: pop
    //   1793: goto -98 -> 1695
    //   1796: aload 8
    //   1798: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1801: ifne +453 -> 2254
    //   1804: aload 9
    //   1806: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1809: ifne +445 -> 2254
    //   1812: aload 8
    //   1814: ldc_w 3984
    //   1817: invokevirtual 1958	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1820: ifeq +434 -> 2254
    //   1823: aload 9
    //   1825: ldc 52
    //   1827: invokevirtual 1958	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1830: ifeq +424 -> 2254
    //   1833: aload_0
    //   1834: ldc_w 391
    //   1837: invokevirtual 829	bbds:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1840: astore 10
    //   1842: aload 10
    //   1844: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1847: ifeq +382 -> 2229
    //   1850: ldc_w 3986
    //   1853: astore 10
    //   1855: new 197	java/lang/StringBuilder
    //   1858: dup
    //   1859: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1862: ldc_w 3988
    //   1865: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1868: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   1871: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1874: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1877: astore 12
    //   1879: aload 12
    //   1881: astore 11
    //   1883: aload_0
    //   1884: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1887: ifnull +51 -> 1938
    //   1890: aload 12
    //   1892: astore 11
    //   1894: invokestatic 3993	mvv:a	()Lmvv;
    //   1897: aload 10
    //   1899: invokevirtual 3995	mvv:i	(Ljava/lang/String;)Z
    //   1902: ifeq +36 -> 1938
    //   1905: new 197	java/lang/StringBuilder
    //   1908: dup
    //   1909: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1912: aload 12
    //   1914: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1917: ldc_w 3997
    //   1920: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: aload_0
    //   1924: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1927: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1930: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1933: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1936: astore 11
    //   1938: aload 11
    //   1940: astore 12
    //   1942: aload_0
    //   1943: getfield 1104	bbds:q	Ljava/lang/String;
    //   1946: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1949: ifne +33 -> 1982
    //   1952: new 197	java/lang/StringBuilder
    //   1955: dup
    //   1956: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1959: aload 11
    //   1961: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1964: ldc_w 2168
    //   1967: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1970: aload_0
    //   1971: getfield 1104	bbds:q	Ljava/lang/String;
    //   1974: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1977: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1980: astore 12
    //   1982: aload 12
    //   1984: astore 11
    //   1986: aload 10
    //   1988: ldc_w 2161
    //   1991: invokevirtual 2214	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1994: ifge +26 -> 2020
    //   1997: new 197	java/lang/StringBuilder
    //   2000: dup
    //   2001: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   2004: aload 12
    //   2006: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2009: ldc_w 3999
    //   2012: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2015: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2018: astore 11
    //   2020: aload 10
    //   2022: aload 11
    //   2024: invokestatic 3975	mze:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2027: astore 10
    //   2029: aload_0
    //   2030: ldc_w 3852
    //   2033: invokevirtual 829	bbds:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2036: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2039: ifne +958 -> 2997
    //   2042: aload_0
    //   2043: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2046: ifnull +951 -> 2997
    //   2049: aload_0
    //   2050: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2053: bipush 12
    //   2055: invokevirtual 348	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2058: checkcast 4001	axbt
    //   2061: astore 11
    //   2063: iconst_0
    //   2064: istore_1
    //   2065: aload_0
    //   2066: getfield 1267	bbds:jdField_h_of_type_Boolean	Z
    //   2069: ifeq +12 -> 2081
    //   2072: aload_0
    //   2073: getfield 1265	bbds:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   2076: iconst_1
    //   2077: invokestatic 4006	aqrm:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;Z)I
    //   2080: istore_1
    //   2081: aload 11
    //   2083: invokevirtual 4009	axbt:a	()Laqrm;
    //   2086: iload_1
    //   2087: invokevirtual 4012	aqrm:a	(I)Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;
    //   2090: astore 11
    //   2092: aload 11
    //   2094: ifnull +903 -> 2997
    //   2097: ldc_w 435
    //   2100: iconst_2
    //   2101: iconst_2
    //   2102: anewarray 4	java/lang/Object
    //   2105: dup
    //   2106: iconst_0
    //   2107: ldc_w 4014
    //   2110: aastore
    //   2111: dup
    //   2112: iconst_1
    //   2113: aload 11
    //   2115: aastore
    //   2116: invokestatic 967	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2119: aload 10
    //   2121: ldc_w 4016
    //   2124: invokestatic 3975	mze:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2127: astore 10
    //   2129: aload 11
    //   2131: aload 14
    //   2133: invokestatic 4019	aqrm:a	(Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;Landroid/content/Intent;)Landroid/content/Intent;
    //   2136: pop
    //   2137: aload_0
    //   2138: aload 10
    //   2140: aload 9
    //   2142: aload 8
    //   2144: aload 14
    //   2146: invokespecial 3977	bbds:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2149: aload_0
    //   2150: aload 8
    //   2152: invokespecial 3979	bbds:g	(Ljava/lang/String;)V
    //   2155: aload_0
    //   2156: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2159: ifnull +37 -> 2196
    //   2162: aload_0
    //   2163: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2166: ldc_w 4021
    //   2169: invokevirtual 4025	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   2172: astore 8
    //   2174: aload 8
    //   2176: ifnull +20 -> 2196
    //   2179: aload 8
    //   2181: aload 8
    //   2183: ldc_w 4026
    //   2186: invokevirtual 4030	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   2189: ldc2_w 4031
    //   2192: invokevirtual 4036	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   2195: pop
    //   2196: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2199: ifeq +13 -> 2212
    //   2202: ldc_w 435
    //   2205: iconst_2
    //   2206: ldc_w 4038
    //   2209: invokestatic 439	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2212: new 4040	com/tencent/mobileqq/utils/JumpAction$20
    //   2215: dup
    //   2216: aload_0
    //   2217: invokespecial 4041	com/tencent/mobileqq/utils/JumpAction$20:<init>	(Lbbds;)V
    //   2220: iconst_5
    //   2221: aconst_null
    //   2222: iconst_1
    //   2223: invokestatic 1388	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2226: goto -1102 -> 1124
    //   2229: aload 10
    //   2231: invokestatic 1600	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   2234: astore 10
    //   2236: goto -381 -> 1855
    //   2239: astore 10
    //   2241: aload 10
    //   2243: invokevirtual 394	java/lang/Exception:printStackTrace	()V
    //   2246: ldc_w 3986
    //   2249: astore 10
    //   2251: goto -396 -> 1855
    //   2254: aload 8
    //   2256: ldc_w 4043
    //   2259: invokevirtual 2248	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2262: ifeq +170 -> 2432
    //   2265: aload_0
    //   2266: ldc_w 416
    //   2269: invokevirtual 829	bbds:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2272: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2275: ifne +52 -> 2327
    //   2278: aload 14
    //   2280: ldc_w 4045
    //   2283: iconst_4
    //   2284: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2287: pop
    //   2288: aload 14
    //   2290: ldc_w 4047
    //   2293: aload 14
    //   2295: ldc_w 4047
    //   2298: iconst_1
    //   2299: invokevirtual 825	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2302: iconst_4
    //   2303: ior
    //   2304: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2307: pop
    //   2308: aload_0
    //   2309: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2312: aload_0
    //   2313: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2316: checkcast 745	android/app/Activity
    //   2319: aload 14
    //   2321: invokestatic 4052	bhvh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2324: goto -1200 -> 1124
    //   2327: aload_0
    //   2328: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2331: ldc_w 1160
    //   2334: ldc 61
    //   2336: ldc 61
    //   2338: ldc_w 4054
    //   2341: ldc_w 4054
    //   2344: iconst_0
    //   2345: iconst_0
    //   2346: ldc 61
    //   2348: ldc 61
    //   2350: ldc 61
    //   2352: ldc 61
    //   2354: iconst_0
    //   2355: invokestatic 3027	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2358: invokestatic 4059	qvn:a	()Lqvn;
    //   2361: invokestatic 4059	qvn:a	()Lqvn;
    //   2364: invokevirtual 4060	qvn:b	()Z
    //   2367: ldc_w 4062
    //   2370: iconst_1
    //   2371: invokevirtual 4065	qvn:a	(ZLjava/lang/String;I)V
    //   2374: aload 14
    //   2376: ldc_w 4045
    //   2379: iconst_1
    //   2380: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2383: pop
    //   2384: aload 14
    //   2386: ldc_w 4067
    //   2389: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   2392: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2395: pop
    //   2396: aload_0
    //   2397: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2400: bipush 96
    //   2402: invokevirtual 348	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2405: checkcast 4069	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager
    //   2408: aload 14
    //   2410: invokevirtual 4070	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager:a	(Landroid/content/Intent;)V
    //   2413: aload_0
    //   2414: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2417: aload_0
    //   2418: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2421: checkcast 745	android/app/Activity
    //   2424: aload 14
    //   2426: invokestatic 4052	bhvh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2429: goto -1305 -> 1124
    //   2432: aload 8
    //   2434: ldc_w 3921
    //   2437: invokevirtual 2248	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2440: ifeq +14 -> 2454
    //   2443: aload 14
    //   2445: ldc_w 416
    //   2448: bipush 15
    //   2450: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2453: pop
    //   2454: aload 8
    //   2456: ldc_w 4072
    //   2459: invokevirtual 2248	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2462: ifeq +16 -> 2478
    //   2465: aload 14
    //   2467: ldc_w 4074
    //   2470: aload_0
    //   2471: getfield 2050	bbds:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2474: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2477: pop
    //   2478: aload 8
    //   2480: getstatic 4075	cooperation/comic/VipComicJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2483: invokevirtual 2248	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2486: ifeq +39 -> 2525
    //   2489: aload 14
    //   2491: invokestatic 4078	cooperation/comic/VipComicJumpActivity:a	(Landroid/content/Intent;)Lbgha;
    //   2494: astore 11
    //   2496: aload_0
    //   2497: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2500: aload_0
    //   2501: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2504: checkcast 745	android/app/Activity
    //   2507: aload 11
    //   2509: invokestatic 4081	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lbgha;)Z
    //   2512: ifeq +13 -> 2525
    //   2515: aload_0
    //   2516: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2519: iconst_1
    //   2520: invokestatic 4084	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Z)V
    //   2523: iconst_1
    //   2524: ireturn
    //   2525: aload 9
    //   2527: ifnull -1403 -> 1124
    //   2530: aload 9
    //   2532: invokestatic 327	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2535: invokevirtual 4085	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   2538: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2541: istore 6
    //   2543: iload 6
    //   2545: ifeq +371 -> 2916
    //   2548: iconst_0
    //   2549: istore 6
    //   2551: ldc_w 4087
    //   2554: invokestatic 327	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2557: invokevirtual 4091	com/tencent/qphone/base/util/BaseApplication:getClassLoader	()Ljava/lang/ClassLoader;
    //   2560: aload 8
    //   2562: invokevirtual 4097	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   2565: invokevirtual 4101	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   2568: istore 7
    //   2570: iload 7
    //   2572: istore 6
    //   2574: iload 6
    //   2576: ifeq +5 -> 2581
    //   2579: iconst_0
    //   2580: ireturn
    //   2581: aload 14
    //   2583: ldc_w 4103
    //   2586: invokevirtual 815	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2589: astore 11
    //   2591: aload 11
    //   2593: ifnull +399 -> 2992
    //   2596: aload 11
    //   2598: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2601: istore_1
    //   2602: aload 8
    //   2604: ldc_w 4105
    //   2607: invokevirtual 1958	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2610: ifeq +189 -> 2799
    //   2613: ldc_w 4107
    //   2616: astore 8
    //   2618: ldc_w 4109
    //   2621: aload 8
    //   2623: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2626: ifeq +205 -> 2831
    //   2629: aload 14
    //   2631: ldc_w 4111
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
    //   2662: invokestatic 4116	bdto:b	(I)Z
    //   2665: ifeq +412 -> 3077
    //   2668: ldc_w 4118
    //   2671: astore 11
    //   2673: aload 14
    //   2675: ldc_w 4103
    //   2678: iload_1
    //   2679: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2682: pop
    //   2683: aload 10
    //   2685: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2688: ifne +130 -> 2818
    //   2691: aload 10
    //   2693: invokevirtual 4121	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2696: ldc_w 2434
    //   2699: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2702: ifeq +116 -> 2818
    //   2705: aload 14
    //   2707: ldc_w 2859
    //   2710: bipush 117
    //   2712: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2715: pop
    //   2716: aload 14
    //   2718: ldc_w 402
    //   2721: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2724: pop
    //   2725: aload 11
    //   2727: astore 8
    //   2729: ldc_w 4123
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
    //   2760: ldc_w 2743
    //   2763: invokevirtual 2113	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2766: ifne +122 -> 2888
    //   2769: ldc_w 435
    //   2772: iconst_1
    //   2773: new 197	java/lang/StringBuilder
    //   2776: dup
    //   2777: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   2780: ldc_w 4125
    //   2783: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2786: aload 10
    //   2788: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2791: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2794: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2797: iconst_0
    //   2798: ireturn
    //   2799: aload 8
    //   2801: ldc_w 4127
    //   2804: invokevirtual 1958	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2807: ifeq +182 -> 2989
    //   2810: ldc_w 4109
    //   2813: astore 8
    //   2815: goto -197 -> 2618
    //   2818: aload 14
    //   2820: ldc_w 2859
    //   2823: iconst_2
    //   2824: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2827: pop
    //   2828: goto -112 -> 2716
    //   2831: ldc_w 4107
    //   2834: aload 8
    //   2836: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2839: ifeq +28 -> 2867
    //   2842: iload_1
    //   2843: invokestatic 4116	bdto:b	(I)Z
    //   2846: ifeq -117 -> 2729
    //   2849: ldc_w 4118
    //   2852: astore 8
    //   2854: aload 14
    //   2856: ldc_w 4103
    //   2859: iload_1
    //   2860: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2863: pop
    //   2864: goto -135 -> 2729
    //   2867: aload 14
    //   2869: ldc_w 1208
    //   2872: invokevirtual 1212	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   2875: pop
    //   2876: aload 14
    //   2878: ldc_w 515
    //   2881: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2884: pop
    //   2885: goto -156 -> 2729
    //   2888: aload 14
    //   2890: aload 9
    //   2892: aload 8
    //   2894: invokevirtual 1206	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2897: pop
    //   2898: aload_0
    //   2899: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2902: aload 14
    //   2904: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2907: aload_0
    //   2908: aload 8
    //   2910: invokespecial 3979	bbds:g	(Ljava/lang/String;)V
    //   2913: goto -1789 -> 1124
    //   2916: aload 14
    //   2918: aload 9
    //   2920: aload 8
    //   2922: invokevirtual 1206	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2925: pop
    //   2926: aload 14
    //   2928: ldc_w 1208
    //   2931: invokevirtual 1212	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   2934: pop
    //   2935: aload 14
    //   2937: ldc_w 515
    //   2940: invokevirtual 514	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2943: pop
    //   2944: aload_0
    //   2945: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
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
    //   2976: invokespecial 3189	bbds:a	(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Z
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
    //   3077: ldc_w 4107
    //   3080: astore 11
    //   3082: goto -399 -> 2683
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3085	0	this	bbds
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
  
  private boolean bk()
  {
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492C", "0X800492C", 0, 0, "", "", "", "");
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
                  localBundle.putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131698170), new Object[] { localObject1 }));
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
                  localException2.putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131698171));
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
                    if (apue.a((String)localObject1) == 0)
                    {
                      localException2.putInt("req_type", 5);
                    }
                    else
                    {
                      localException2.putString("forward_text", ajyc.a(2131705896) + apue.a((String)localObject1) + ajyc.a(2131705897) + apvb.a(apvb.a((String)localObject1)) + "。");
                      localException2.putBoolean("qdshare_file", true);
                      localException2.putBoolean("isFromShare", true);
                      localException2.putBoolean("key_sdk_share_pure_text", true);
                      localException2.putInt("req_type", 6);
                    }
                  }
                  else if (apue.a(localObject3) == 0)
                  {
                    localException2.putString("title", ((ArrayList)localObject6).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131694752));
                    localException2.putString("qqfav_extra_multi_pic_path_list", str2);
                    localException2.putBoolean("qqfav_extra_multi_pic", true);
                    localException2.putInt("req_type", 1);
                  }
                  else
                  {
                    localObject1 = ((ArrayList)localObject6).iterator();
                    for (l1 = 0L; ((Iterator)localObject1).hasNext(); l1 = apvb.a((String)((Iterator)localObject1).next()) + l1) {}
                    localException2.putString("forward_text", ajyc.a(2131705903) + apue.a(localObject3) + ajyc.a(2131705891) + ((ArrayList)localObject6).size() + ajyc.a(2131705904) + apvb.a(l1));
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
  
  private boolean bl()
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
            localObject1 = bdey.g() + File.separator + "qapp_center_detail.htm";
            if (new File((String)localObject1).exists()) {}
            for (localObject1 = "file:///" + (String)localObject1;; localObject1 = bdey.m() + File.separator + "qapp_center_detail.htm")
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
        localObject3 = bdey.a(((Uri)localObject2).getQueryParameter("url"));
      } while (localObject3.length <= 1);
      localObject2 = localObject3[0];
    } while ((!((String)localObject2).startsWith("file://")) || ((!((String)localObject2).contains(bdey.g())) && (!((String)localObject2).contains("android_asset/Page/system/"))));
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
  
  private boolean bm()
  {
    bgmt.a(this.jdField_a_of_type_AndroidContentContext, 9, null);
    return true;
  }
  
  private boolean bn()
  {
    return true;
  }
  
  private boolean bo()
  {
    return true;
  }
  
  private boolean bp()
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
  
  private boolean bq()
  {
    String str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if (TextUtils.isEmpty(str)) {
      str = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      ymw.a().a(1);
      ymw.a().jdField_a_of_type_JavaLangString = "";
      ymw.a().jdField_a_of_type_Int = 0;
      ymw.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 2);
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        DeviceScanner.openDeviceQCodeUrl((Activity)this.jdField_a_of_type_AndroidContentContext, null, str);
      }
      return true;
    }
  }
  
  private boolean br()
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
        localObject1 = bfng.a((String)localObject1);
        if (((Map)localObject1).get("public_device") != null)
        {
          i1 = 1;
          localObject2 = bfng.b((String)((Map)localObject1).get("args"));
          localObject1 = (String)((Map)localObject2).get("sn");
          localObject2 = (String)((Map)localObject2).get("pid");
          if ((i1 != 0) && ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))))
          {
            bdid.a().a(this.jdField_a_of_type_AndroidContentContext.getString(2131720715));
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
  
  private boolean bs()
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
    aqbc.a(this.jdField_a_of_type_AndroidContentContext, localIntent);
    return true;
  }
  
  private boolean bt()
  {
    Object localObject = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("friendUin"));
    localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, "", 3001, 11, "", "", null, "", "");
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean bu()
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
  
  private boolean bv()
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
      return bx();
    }
    if ("opentopic".equals(this.c)) {
      return bw();
    }
    if ("infoCard".equals(this.c)) {
      return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    if ("sharegroupcard".equals(this.c)) {
      return b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    Object localObject = new unv((Activity)this.jdField_a_of_type_AndroidContentContext, new bbdy(this));
    Intent localIntent = e(new Intent());
    if (localIntent != null)
    {
      int i1 = localIntent.getIntExtra("action", 0);
      localIntent.putExtra("action", 0);
      return ((unv)localObject).a(i1, localIntent);
    }
    return false;
  }
  
  private boolean bw()
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
  
  private boolean bx()
  {
    if (!TextUtils.isEmpty(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api")))) {
      vel.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      if ("1".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"))) {}
      return true;
    }
    return false;
  }
  
  private boolean by()
  {
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean)
    {
      veg.b("JumpAction", "startStoryMainActivity, isNowTabShow==true");
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
        veg.e("JumpAction", "Error: context is not instanceof Activity, context is: " + String.valueOf(this.jdField_a_of_type_AndroidContentContext));
      }
      if (localIntent == null) {
        veg.e("JumpAction", "Error: jumpIntent is null");
      }
      return false;
    }
    veg.b("JumpAction", "startStoryMainActivity, isNowTabShow==false");
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
  
  private boolean bz()
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
          abtu.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, TranslucentTRansferFragment.class);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096FF", "0X80096FF", 0, 0, "", "", "", "");
          return true;
          str = "";
          break;
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096FE", "0X80096FE", 0, 0, "", "", "", "");
        return true;
      }
    }
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
      bduw localbduw = (bduw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
      boolean bool = false;
      if (this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag") == null) {
        break label356;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag");
      label203:
      if (!TextUtils.isEmpty(str3)) {
        bool = bdto.b(Integer.valueOf(str3).intValue());
      }
      localbduw.a(str4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, str1, paramString, bool);
      localObject = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject == null) || (!((ajxn)localObject).b(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label363;
      }
      localObject = new auuw();
      ((auuw)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramString, 1);
      ((auuw)localObject).jdField_a_of_type_ArrayOfJavaLangString = new String[7];
      ((auuw)localObject).jdField_a_of_type_ArrayOfJavaLangString[4] = str2;
      FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (auuw)localObject);
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
      paramString = AddFriendLogicActivity.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, paramString, null, 3999, 0, str2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131690572), null);
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
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromTranslucent", 1);
    try
    {
      String str1 = b("uin");
      long l1 = Long.parseLong(str1);
      int i1 = Integer.parseInt(b("appid"));
      Object localObject = b("cellid");
      String str2 = b("subid");
      long l2 = Long.parseLong(b("time"));
      localBundle.putLong("targetuin", Long.valueOf(l1).longValue());
      localBundle.putInt("appid", i1);
      localBundle.putString("cellid", (String)localObject);
      localBundle.putString("subid", str2);
      localBundle.putLong("feedtime", l2);
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      QzonePluginProxyActivity.a((Intent)localObject, "com.qzone.detail.ui.activity.StickyNoteDetailActivity");
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
        QzonePluginProxyActivity.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, str1, (Intent)localObject, 7, true);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpAction", 1, "action_open_sticky_note_feed_detail  error!", localThrowable);
    }
  }
  
  private boolean d(String paramString)
  {
    String str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_uri"));
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_b_of_type_Boolean = false;
      ThreadManagerV2.executeOnSubThread(new JumpAction.17(this, str, paramString));
      return false;
    }
    return a(paramString, true);
  }
  
  private Intent e(Intent paramIntent)
  {
    if (!TextUtils.isEmpty((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"))) {}
    for (boolean bool = true;; bool = false)
    {
      veg.a("JumpAction", "makeStoryJumpActivity() action=%s isFromApi=%s", this.c, Boolean.valueOf(bool));
      veg.a("JumpAction", "makeStoryJumpActivity() attr=%s", String.valueOf(this.jdField_a_of_type_JavaUtilHashMap));
      if (!"open".equals(this.c)) {
        break;
      }
      paramIntent.putExtra("redid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("redid"));
      paramIntent.putExtra("lebaVersion", (String)this.jdField_a_of_type_JavaUtilHashMap.get("lebaVersion"));
      if (bool) {
        vel.a("basic", "use_api", 0, 0, new String[] { "1", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
      }
      return paramIntent;
    }
    String str1;
    if (("openVideo".equals(this.c)) || ("openvideo".equals(this.c)))
    {
      if (bool)
      {
        str1 = "userId=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoOwnerUin") + "&vid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoId");
        vel.a("basic", "use_api", 0, 0, new String[] { "6", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
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
        vel.a("basic", "use_api", 0, 0, new String[] { "4", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
        return d(paramIntent);
      }
    }
    if ("opentopic".equals(this.c))
    {
      if (bool)
      {
        str1 = "topicId=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
        vel.a("basic", "use_api", 0, 0, new String[] { "5", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
      }
      return b(paramIntent);
    }
    if ("opendiscovery".equals(this.c))
    {
      if (bool) {
        vel.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
      }
      return c(paramIntent);
    }
    if ("publish".equals(this.c))
    {
      if (bool) {
        vel.a("basic", "use_api", 0, 0, new String[] { "2", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
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
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_weishi_feeds_plugin.apk");
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
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
          localObject2 = new String(bbca.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname"), 0));
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
  
  private void f(String paramString)
  {
    if ("app".equals(this.jdField_f_of_type_JavaLangString)) {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if ("web".equals(this.jdField_f_of_type_JavaLangString))
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
        return;
      }
    } while (!"scan".equals(this.jdField_f_of_type_JavaLangString));
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidAppDialog = bbcv.a(this.jdField_a_of_type_AndroidContentContext, 2131692929, this.jdField_a_of_type_AndroidContentContext.getString(2131692923), 2131692925, 2131692924, new bbec(this), new bbed(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void g(String paramString)
  {
    if ((paramString.equals(GameCenterActivity.class.getName())) || (paramString.equals(PublicAccountBrowser.class.getName())) || (paramString.equals(CouponActivity.class.getName()))) {
      QWalletHelper.preloadQWallet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void h()
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
      ((akeu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(42)).a((ReqCheckChangePwdAuth)localObject);
      this.jdField_a_of_type_Bbeg = new bbeg(this, null);
      this.jdField_a_of_type_Akev = new akev(this.jdField_a_of_type_Bbeg);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akev);
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
  
  private void i()
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
  
  private void j()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
      ((JumpActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
  
  private void k()
  {
    try
    {
      if ("head".equals(this.c))
      {
        if (this.jdField_a_of_type_Bbef == null) {
          this.jdField_a_of_type_Bbef = new bbef(this, this);
        }
        if (this.jdField_a_of_type_JavaUtilHashtable == null) {
          this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bbef);
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
      ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131697556));
      ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131696363));
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
    if (this.jdField_a_of_type_Bcpq == null) {
      this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
    }
    this.jdField_a_of_type_Bcpq.c(paramInt);
    if ((!((JumpActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) && (!this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.show();
    }
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_b_of_type_JavaLangString.equals("card")) && (this.c.equals("show_pslcard")) && (QSecFramework.a().a(1003).booleanValue())) {
      bcwv.a().a(paramActivity, null);
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
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772278, 2130771990);
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
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
  }
  
  public void c(String paramString)
  {
    this.o = paramString;
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: ldc_w 4862
    //   3: invokestatic 4864	com/tencent/mobileqq/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   6: ldc_w 4866
    //   9: aload_0
    //   10: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   13: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16: ifeq +90 -> 106
    //   19: iconst_m1
    //   20: istore_1
    //   21: aload_0
    //   22: getfield 295	bbds:c	Ljava/lang/String;
    //   25: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   28: istore_2
    //   29: iload_2
    //   30: istore_1
    //   31: iload_1
    //   32: tableswitch	default:+20 -> 52, 2:+22->54
    //   53: ireturn
    //   54: new 106	android/content/Intent
    //   57: dup
    //   58: invokespecial 395	android/content/Intent:<init>	()V
    //   61: astore 7
    //   63: aload 7
    //   65: ldc_w 3609
    //   68: invokestatic 126	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   71: invokevirtual 4870	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   74: ldc_w 4451
    //   77: invokevirtual 2693	android/content/Context:getString	(I)Ljava/lang/String;
    //   80: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   83: pop
    //   84: aload_0
    //   85: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   88: checkcast 745	android/app/Activity
    //   91: aload_0
    //   92: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: invokevirtual 1659	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   98: aload 7
    //   100: iconst_m1
    //   101: iconst_0
    //   102: invokestatic 4875	bgpf:a	(Landroid/app/Activity;Ljava/lang/String;Landroid/content/Intent;IZ)Z
    //   105: ireturn
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   111: ldc_w 603
    //   114: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: checkcast 50	java/lang/String
    //   120: putfield 4876	bbds:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   128: ldc_w 4878
    //   131: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast 50	java/lang/String
    //   137: putfield 4879	bbds:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   145: ldc_w 707
    //   148: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: checkcast 50	java/lang/String
    //   154: putfield 2066	bbds:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   157: aload_0
    //   158: aload_0
    //   159: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   162: ldc_w 2068
    //   165: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   168: checkcast 50	java/lang/String
    //   171: putfield 2070	bbds:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   174: aload_0
    //   175: aload_0
    //   176: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   179: ldc_w 2072
    //   182: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   185: checkcast 50	java/lang/String
    //   188: putfield 2073	bbds:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   191: aload_0
    //   192: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   195: ldc_w 4881
    //   198: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   201: checkcast 50	java/lang/String
    //   204: astore 7
    //   206: aload_0
    //   207: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   210: ldc_w 2436
    //   213: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   216: checkcast 50	java/lang/String
    //   219: astore 9
    //   221: ldc_w 4883
    //   224: aload_0
    //   225: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   228: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +75 -> 306
    //   234: ldc_w 4885
    //   237: aload_0
    //   238: getfield 295	bbds:c	Ljava/lang/String;
    //   241: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifeq +62 -> 306
    //   247: aload_0
    //   248: ldc_w 4887
    //   251: invokevirtual 829	bbds:b	(Ljava/lang/String;)Ljava/lang/String;
    //   254: astore 8
    //   256: aload 8
    //   258: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   261: ifne +170 -> 431
    //   264: new 50	java/lang/String
    //   267: dup
    //   268: aload 8
    //   270: iconst_0
    //   271: invokestatic 2663	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   274: invokespecial 161	java/lang/String:<init>	([B)V
    //   277: astore 10
    //   279: aload 10
    //   281: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   284: ifne +116 -> 400
    //   287: ldc_w 435
    //   290: iconst_1
    //   291: ldc_w 4889
    //   294: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload_0
    //   298: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   301: aload 10
    //   303: invokestatic 4894	bbqw:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   306: ldc_w 4896
    //   309: aload_0
    //   310: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   313: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   316: ifeq +211 -> 527
    //   319: ldc_w 2035
    //   322: aload_0
    //   323: getfield 295	bbds:c	Ljava/lang/String;
    //   326: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   329: ifeq +198 -> 527
    //   332: aload_0
    //   333: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   336: ldc_w 391
    //   339: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   342: checkcast 50	java/lang/String
    //   345: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   348: astore 7
    //   350: aload_0
    //   351: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   354: ldc_w 1980
    //   357: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   360: checkcast 989	java/lang/CharSequence
    //   363: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   366: ifne +22 -> 388
    //   369: aload_0
    //   370: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   373: ldc_w 1982
    //   376: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   379: checkcast 989	java/lang/CharSequence
    //   382: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   385: ifeq +59 -> 444
    //   388: ldc_w 435
    //   391: iconst_1
    //   392: ldc_w 4898
    //   395: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: iconst_1
    //   399: ireturn
    //   400: ldc_w 435
    //   403: iconst_1
    //   404: new 197	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 4900
    //   414: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 8
    //   419: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: goto -122 -> 306
    //   431: ldc_w 435
    //   434: iconst_1
    //   435: ldc_w 4902
    //   438: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: goto -135 -> 306
    //   444: aload_0
    //   445: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   448: ldc_w 447
    //   451: ldc 61
    //   453: ldc 61
    //   455: ldc_w 2144
    //   458: ldc_w 2144
    //   461: iconst_0
    //   462: iconst_0
    //   463: ldc 61
    //   465: ldc 61
    //   467: aload_0
    //   468: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   471: ldc_w 1980
    //   474: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   477: checkcast 50	java/lang/String
    //   480: ldc 61
    //   482: invokestatic 427	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   485: invokestatic 4905	arcm:a	()Z
    //   488: pop
    //   489: new 106	android/content/Intent
    //   492: dup
    //   493: aload_0
    //   494: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   497: ldc_w 378
    //   500: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   503: astore 8
    //   505: aload 8
    //   507: ldc_w 391
    //   510: aload 7
    //   512: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   515: pop
    //   516: aload_0
    //   517: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   520: aload 8
    //   522: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   525: iconst_1
    //   526: ireturn
    //   527: ldc_w 4907
    //   530: aload_0
    //   531: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   534: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   537: ifeq +23 -> 560
    //   540: aload_0
    //   541: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   544: checkcast 745	android/app/Activity
    //   547: aload_0
    //   548: getfield 295	bbds:c	Ljava/lang/String;
    //   551: aload_0
    //   552: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   555: invokestatic 4912	wiv:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/util/HashMap;)V
    //   558: iconst_1
    //   559: ireturn
    //   560: ldc_w 4914
    //   563: aload_0
    //   564: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   567: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   570: ifeq +953 -> 1523
    //   573: ldc_w 4916
    //   576: aload_0
    //   577: getfield 295	bbds:c	Ljava/lang/String;
    //   580: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   583: ifeq +137 -> 720
    //   586: new 574	android/os/Bundle
    //   589: dup
    //   590: invokespecial 575	android/os/Bundle:<init>	()V
    //   593: astore 7
    //   595: aload 7
    //   597: ldc_w 1172
    //   600: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   603: invokevirtual 593	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   606: aload_0
    //   607: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   610: ldc_w 653
    //   613: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   616: checkcast 50	java/lang/String
    //   619: astore 8
    //   621: aload 8
    //   623: ifnull +22 -> 645
    //   626: ldc 61
    //   628: aload 8
    //   630: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   633: ifne +12 -> 645
    //   636: aload 8
    //   638: invokevirtual 554	java/lang/String:length	()I
    //   641: iconst_5
    //   642: if_icmpge +5 -> 647
    //   645: iconst_0
    //   646: ireturn
    //   647: aload 7
    //   649: ldc_w 4918
    //   652: aload 8
    //   654: invokestatic 580	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   657: invokevirtual 583	java/lang/Long:longValue	()J
    //   660: invokevirtual 593	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   663: aload 7
    //   665: ldc_w 4920
    //   668: aload_0
    //   669: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   672: ldc_w 4471
    //   675: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   678: checkcast 50	java/lang/String
    //   681: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   684: aload 7
    //   686: ldc_w 4922
    //   689: iconst_3
    //   690: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   693: aload 7
    //   695: ldc_w 4924
    //   698: bipush 19
    //   700: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   703: aload 7
    //   705: ldc_w 4926
    //   708: bipush 8
    //   710: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   713: aload 7
    //   715: invokestatic 4928	bbds:a	(Landroid/os/Bundle;)V
    //   718: iconst_1
    //   719: ireturn
    //   720: ldc_w 4930
    //   723: aload_0
    //   724: getfield 295	bbds:c	Ljava/lang/String;
    //   727: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   730: ifeq -12 -> 718
    //   733: aload_0
    //   734: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   737: ldc_w 4932
    //   740: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   743: checkcast 50	java/lang/String
    //   746: astore 8
    //   748: aload_0
    //   749: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   752: ldc_w 416
    //   755: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   758: checkcast 50	java/lang/String
    //   761: astore 14
    //   763: aload_0
    //   764: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   767: ldc_w 4934
    //   770: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   773: checkcast 50	java/lang/String
    //   776: astore 13
    //   778: aload_0
    //   779: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   782: ldc_w 4936
    //   785: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   788: checkcast 50	java/lang/String
    //   791: astore 15
    //   793: aload_0
    //   794: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   797: ldc_w 4938
    //   800: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   803: checkcast 50	java/lang/String
    //   806: astore 11
    //   808: aload_0
    //   809: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   812: ldc_w 4940
    //   815: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   818: checkcast 50	java/lang/String
    //   821: astore 16
    //   823: ldc 61
    //   825: astore 7
    //   827: new 574	android/os/Bundle
    //   830: dup
    //   831: invokespecial 575	android/os/Bundle:<init>	()V
    //   834: astore 12
    //   836: aload 8
    //   838: astore 10
    //   840: aload 7
    //   842: astore 9
    //   844: aload 16
    //   846: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   849: ifne +8842 -> 9691
    //   852: aload 16
    //   854: ldc_w 4942
    //   857: invokevirtual 1596	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   860: astore 17
    //   862: aload 17
    //   864: arraylength
    //   865: ifle +9 -> 874
    //   868: aload 17
    //   870: iconst_0
    //   871: aaload
    //   872: astore 7
    //   874: aload 17
    //   876: arraylength
    //   877: iconst_1
    //   878: if_icmpne +9 -> 887
    //   881: aload 17
    //   883: iconst_0
    //   884: aaload
    //   885: astore 8
    //   887: aload 17
    //   889: arraylength
    //   890: iconst_1
    //   891: if_icmple +9 -> 900
    //   894: aload 17
    //   896: iconst_1
    //   897: aaload
    //   898: astore 8
    //   900: aload 8
    //   902: astore 10
    //   904: aload 7
    //   906: astore 9
    //   908: aload 17
    //   910: arraylength
    //   911: iconst_2
    //   912: if_icmple +8779 -> 9691
    //   915: aload 17
    //   917: iconst_2
    //   918: aaload
    //   919: astore 10
    //   921: aload 8
    //   923: astore 9
    //   925: aload 10
    //   927: astore 8
    //   929: aload 9
    //   931: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   934: ifne +34 -> 968
    //   937: aload 8
    //   939: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   942: ifne +345 -> 1287
    //   945: aload 12
    //   947: ldc_w 4944
    //   950: aload 8
    //   952: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   955: aload 12
    //   957: ldc_w 4946
    //   960: aload 7
    //   962: invokestatic 4949	birc:a	(Ljava/lang/String;)Ljava/lang/String;
    //   965: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   968: ldc_w 435
    //   971: new 197	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   978: ldc_w 4951
    //   981: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: aload 9
    //   986: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: ldc_w 4953
    //   992: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: ldc_w 416
    //   998: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: ldc_w 4955
    //   1004: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: aload 14
    //   1009: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: ldc_w 4953
    //   1015: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: ldc_w 4934
    //   1021: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: ldc_w 4955
    //   1027: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: aload 13
    //   1032: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: ldc_w 4953
    //   1038: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: ldc_w 4936
    //   1044: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: ldc_w 4955
    //   1050: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: aload 15
    //   1055: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: ldc_w 4953
    //   1061: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: ldc_w 4938
    //   1067: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: ldc_w 4955
    //   1073: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: aload 11
    //   1078: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: ldc_w 4953
    //   1084: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: ldc_w 4940
    //   1090: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: ldc_w 4955
    //   1096: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: aload 16
    //   1101: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1107: invokestatic 4958	bizq:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1110: aload 9
    //   1112: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1115: ifne +13 -> 1128
    //   1118: aload 12
    //   1120: ldc_w 4960
    //   1123: aload 9
    //   1125: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1128: aload 14
    //   1130: invokestatic 4963	birc:a	(Ljava/lang/String;)Lbirc;
    //   1133: invokevirtual 4964	birc:a	()I
    //   1136: istore_1
    //   1137: iload_1
    //   1138: getstatic 4967	birc:a	Lbirc;
    //   1141: invokevirtual 4964	birc:a	()I
    //   1144: if_icmpeq +53 -> 1197
    //   1147: iload_1
    //   1148: getstatic 4969	birc:n	Lbirc;
    //   1151: invokevirtual 4964	birc:a	()I
    //   1154: if_icmpeq +43 -> 1197
    //   1157: iload_1
    //   1158: getstatic 4971	birc:t	Lbirc;
    //   1161: invokevirtual 4964	birc:a	()I
    //   1164: if_icmpeq +33 -> 1197
    //   1167: iload_1
    //   1168: getstatic 4973	birc:b	Lbirc;
    //   1171: invokevirtual 4964	birc:a	()I
    //   1174: if_icmpeq +23 -> 1197
    //   1177: iload_1
    //   1178: getstatic 4976	birc:u	Lbirc;
    //   1181: invokevirtual 4964	birc:a	()I
    //   1184: if_icmpeq +13 -> 1197
    //   1187: iload_1
    //   1188: getstatic 4978	birc:c	Lbirc;
    //   1191: invokevirtual 4964	birc:a	()I
    //   1194: if_icmpne +107 -> 1301
    //   1197: aload 12
    //   1199: ldc_w 4980
    //   1202: iconst_1
    //   1203: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1206: iload_1
    //   1207: invokestatic 4982	birc:d	(I)Z
    //   1210: ifeq +8474 -> 9684
    //   1213: ldc_w 4984
    //   1216: astore 7
    //   1218: aload 12
    //   1220: ldc_w 4986
    //   1223: iload_1
    //   1224: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1227: aload 7
    //   1229: astore 8
    //   1231: aload 13
    //   1233: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1236: ifne +13 -> 1249
    //   1239: aload 12
    //   1241: ldc_w 4988
    //   1244: aload 13
    //   1246: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1249: aload 8
    //   1251: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1254: ifne +16 -> 1270
    //   1257: aload 12
    //   1259: ldc_w 4990
    //   1262: aload 8
    //   1264: invokestatic 4991	birc:a	(Ljava/lang/String;)I
    //   1267: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1270: aload_0
    //   1271: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1274: checkcast 745	android/app/Activity
    //   1277: bipush 120
    //   1279: aload 12
    //   1281: invokestatic 4996	birg:a	(Landroid/app/Activity;ILandroid/os/Bundle;)V
    //   1284: goto -566 -> 718
    //   1287: aload 12
    //   1289: ldc_w 4944
    //   1292: ldc_w 2300
    //   1295: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1298: goto -343 -> 955
    //   1301: iload_1
    //   1302: getstatic 4998	birc:g	Lbirc;
    //   1305: invokevirtual 4964	birc:a	()I
    //   1308: if_icmpeq +53 -> 1361
    //   1311: iload_1
    //   1312: getstatic 5000	birc:q	Lbirc;
    //   1315: invokevirtual 4964	birc:a	()I
    //   1318: if_icmpeq +43 -> 1361
    //   1321: iload_1
    //   1322: getstatic 5002	birc:r	Lbirc;
    //   1325: invokevirtual 4964	birc:a	()I
    //   1328: if_icmpeq +33 -> 1361
    //   1331: iload_1
    //   1332: getstatic 5004	birc:o	Lbirc;
    //   1335: invokevirtual 4964	birc:a	()I
    //   1338: if_icmpeq +23 -> 1361
    //   1341: iload_1
    //   1342: getstatic 5006	birc:s	Lbirc;
    //   1345: invokevirtual 4964	birc:a	()I
    //   1348: if_icmpeq +13 -> 1361
    //   1351: iload_1
    //   1352: getstatic 5009	birc:v	Lbirc;
    //   1355: invokevirtual 4964	birc:a	()I
    //   1358: if_icmpne +69 -> 1427
    //   1361: aload 12
    //   1363: ldc_w 4980
    //   1366: iconst_2
    //   1367: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1370: goto -164 -> 1206
    //   1373: astore 9
    //   1375: aload 11
    //   1377: astore 7
    //   1379: aload 7
    //   1381: astore 8
    //   1383: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1386: ifeq -155 -> 1231
    //   1389: ldc_w 435
    //   1392: iconst_2
    //   1393: new 197	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1400: ldc_w 5011
    //   1403: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: aload 9
    //   1408: invokevirtual 2927	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1411: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1417: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1420: aload 7
    //   1422: astore 8
    //   1424: goto -193 -> 1231
    //   1427: aload 12
    //   1429: ldc_w 4980
    //   1432: iconst_1
    //   1433: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1436: goto -230 -> 1206
    //   1439: astore 7
    //   1441: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1444: ifeq -195 -> 1249
    //   1447: ldc_w 435
    //   1450: iconst_2
    //   1451: new 197	java/lang/StringBuilder
    //   1454: dup
    //   1455: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1458: ldc_w 5013
    //   1461: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: aload 7
    //   1466: invokevirtual 2927	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1469: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1475: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1478: goto -229 -> 1249
    //   1481: astore 7
    //   1483: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1486: ifeq -216 -> 1270
    //   1489: ldc_w 435
    //   1492: iconst_2
    //   1493: new 197	java/lang/StringBuilder
    //   1496: dup
    //   1497: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1500: ldc_w 5015
    //   1503: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: aload 7
    //   1508: invokevirtual 2927	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1511: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1517: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1520: goto -250 -> 1270
    //   1523: aload_0
    //   1524: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1527: ldc_w 5017
    //   1530: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1533: ifeq +21 -> 1554
    //   1536: aload_0
    //   1537: getfield 295	bbds:c	Ljava/lang/String;
    //   1540: ldc_w 5019
    //   1543: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1546: ifeq +8 -> 1554
    //   1549: aload_0
    //   1550: invokespecial 5021	bbds:bI	()Z
    //   1553: ireturn
    //   1554: ldc_w 5023
    //   1557: aload_0
    //   1558: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1561: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1564: ifeq +89 -> 1653
    //   1567: ldc_w 306
    //   1570: aload_0
    //   1571: getfield 295	bbds:c	Ljava/lang/String;
    //   1574: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1577: ifeq +76 -> 1653
    //   1580: aload_0
    //   1581: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1584: ifnull +47 -> 1631
    //   1587: aload_0
    //   1588: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1591: ldc_w 5025
    //   1594: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1597: ifeq +34 -> 1631
    //   1600: aload_0
    //   1601: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1604: ldc_w 5027
    //   1607: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1610: ifne +21 -> 1631
    //   1613: iconst_1
    //   1614: istore_1
    //   1615: iload_1
    //   1616: ifeq +20 -> 1636
    //   1619: aload_0
    //   1620: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1623: aload_0
    //   1624: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1627: invokestatic 5033	com/tencent/mobileqq/microapp/sdk/MiniAppLauncher:launchMiniAppByScheme	(Landroid/content/Context;Ljava/util/HashMap;)Z
    //   1630: ireturn
    //   1631: iconst_0
    //   1632: istore_1
    //   1633: goto -18 -> 1615
    //   1636: aload_0
    //   1637: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1640: aload_0
    //   1641: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1644: sipush 2016
    //   1647: aconst_null
    //   1648: aconst_null
    //   1649: invokestatic 5038	com/tencent/mobileqq/mini/sdk/MiniAppLauncher:launchMiniAppByScheme	(Landroid/content/Context;Ljava/util/HashMap;ILcom/tencent/mobileqq/mini/sdk/EntryModel;Lcom/tencent/mobileqq/mini/sdk/MiniAppLauncher$MiniAppLaunchListener;)Z
    //   1652: ireturn
    //   1653: ldc_w 5040
    //   1656: aload_0
    //   1657: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1660: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1663: ifeq +32 -> 1695
    //   1666: ldc_w 306
    //   1669: aload_0
    //   1670: getfield 295	bbds:c	Ljava/lang/String;
    //   1673: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1676: ifeq +19 -> 1695
    //   1679: aload_0
    //   1680: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1683: aload_0
    //   1684: getfield 2050	bbds:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1687: sipush 2016
    //   1690: aconst_null
    //   1691: invokestatic 5044	com/tencent/mobileqq/mini/sdk/MiniAppLauncher:startMiniApp	(Landroid/content/Context;Ljava/lang/String;ILcom/tencent/mobileqq/mini/sdk/MiniAppLauncher$MiniAppLaunchListener;)Z
    //   1694: ireturn
    //   1695: ldc_w 5040
    //   1698: aload_0
    //   1699: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1702: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1705: ifeq +126 -> 1831
    //   1708: ldc_w 5046
    //   1711: aload_0
    //   1712: getfield 295	bbds:c	Ljava/lang/String;
    //   1715: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1718: ifeq +113 -> 1831
    //   1721: aload_0
    //   1722: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1725: ldc_w 2434
    //   1728: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1731: ifeq +88 -> 1819
    //   1734: aload_0
    //   1735: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1738: ldc_w 2434
    //   1741: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1744: checkcast 50	java/lang/String
    //   1747: astore 7
    //   1749: aload_0
    //   1750: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1753: ldc_w 1420
    //   1756: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1759: ifeq +66 -> 1825
    //   1762: aload_0
    //   1763: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1766: ldc_w 1420
    //   1769: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1772: checkcast 50	java/lang/String
    //   1775: astore 8
    //   1777: aload 7
    //   1779: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1782: ifne +35 -> 1817
    //   1785: aload 8
    //   1787: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1790: ifne +27 -> 1817
    //   1793: aload_0
    //   1794: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1797: sipush 315
    //   1800: invokevirtual 348	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1803: checkcast 5048	ahjz
    //   1806: aload_0
    //   1807: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1810: aload 7
    //   1812: aload 8
    //   1814: invokevirtual 5051	ahjz:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1817: iconst_1
    //   1818: ireturn
    //   1819: aconst_null
    //   1820: astore 7
    //   1822: goto -73 -> 1749
    //   1825: aconst_null
    //   1826: astore 8
    //   1828: goto -51 -> 1777
    //   1831: ldc_w 5053
    //   1834: aload_0
    //   1835: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1838: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1841: ifeq +58 -> 1899
    //   1844: ldc_w 306
    //   1847: aload_0
    //   1848: getfield 295	bbds:c	Ljava/lang/String;
    //   1851: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1854: ifeq +45 -> 1899
    //   1857: ldc_w 372
    //   1860: aload 7
    //   1862: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1865: ifeq +34 -> 1899
    //   1868: aload_0
    //   1869: getfield 2066	bbds:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1872: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1875: ifne +24 -> 1899
    //   1878: aload 9
    //   1880: ifnull +14 -> 1894
    //   1883: ldc_w 372
    //   1886: aload 9
    //   1888: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1891: ifeq +8 -> 1899
    //   1894: aload_0
    //   1895: invokespecial 5055	bbds:ag	()Z
    //   1898: ireturn
    //   1899: ldc_w 5053
    //   1902: aload_0
    //   1903: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1906: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1909: ifeq +360 -> 2269
    //   1912: ldc_w 306
    //   1915: aload_0
    //   1916: getfield 295	bbds:c	Ljava/lang/String;
    //   1919: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1922: ifeq +347 -> 2269
    //   1925: ldc_w 372
    //   1928: aload 7
    //   1930: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1933: ifeq +336 -> 2269
    //   1936: aload_0
    //   1937: getfield 2066	bbds:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1940: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1943: ifne +326 -> 2269
    //   1946: aload_0
    //   1947: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1950: ldc_w 1524
    //   1953: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1956: ifeq +280 -> 2236
    //   1959: aload_0
    //   1960: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1963: ldc_w 1524
    //   1966: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1969: checkcast 50	java/lang/String
    //   1972: astore 7
    //   1974: aload_0
    //   1975: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1978: ldc_w 5057
    //   1981: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1984: ifeq +258 -> 2242
    //   1987: aload_0
    //   1988: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1991: ldc_w 5057
    //   1994: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1997: checkcast 50	java/lang/String
    //   2000: astore 8
    //   2002: lconst_0
    //   2003: lstore 5
    //   2005: lload 5
    //   2007: lstore_3
    //   2008: aload 8
    //   2010: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2013: ifne +24 -> 2037
    //   2016: aload 8
    //   2018: invokestatic 580	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   2021: invokevirtual 583	java/lang/Long:longValue	()J
    //   2024: lstore_3
    //   2025: lload_3
    //   2026: ldc 61
    //   2028: ldc_w 5059
    //   2031: aconst_null
    //   2032: iconst_0
    //   2033: aconst_null
    //   2034: invokestatic 1557	com/tencent/mobileqq/activity/qwallet/report/VACDReportUtil:a	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   2037: ldc_w 657
    //   2040: aload 9
    //   2042: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2045: ifne +102 -> 2147
    //   2048: ldc_w 1716
    //   2051: aload 9
    //   2053: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2056: ifne +91 -> 2147
    //   2059: ldc_w 1714
    //   2062: aload 9
    //   2064: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2067: ifne +80 -> 2147
    //   2070: ldc_w 1718
    //   2073: aload 9
    //   2075: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2078: ifne +69 -> 2147
    //   2081: ldc_w 1678
    //   2084: aload 9
    //   2086: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2089: ifne +58 -> 2147
    //   2092: ldc_w 4429
    //   2095: aload 9
    //   2097: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2100: ifne +47 -> 2147
    //   2103: ldc_w 1740
    //   2106: aload 9
    //   2108: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2111: ifne +36 -> 2147
    //   2114: ldc_w 5061
    //   2117: aload 9
    //   2119: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2122: ifne +25 -> 2147
    //   2125: ldc_w 5063
    //   2128: aload 9
    //   2130: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2133: ifne +14 -> 2147
    //   2136: ldc_w 1664
    //   2139: aload 9
    //   2141: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2144: ifeq +104 -> 2248
    //   2147: new 574	android/os/Bundle
    //   2150: dup
    //   2151: invokespecial 575	android/os/Bundle:<init>	()V
    //   2154: astore 8
    //   2156: aload_0
    //   2157: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2160: ldc_w 5065
    //   2163: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2166: ifeq +24 -> 2190
    //   2169: aload 8
    //   2171: ldc_w 5065
    //   2174: aload_0
    //   2175: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2178: ldc_w 5065
    //   2181: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2184: checkcast 50	java/lang/String
    //   2187: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2190: aload_0
    //   2191: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2194: ldc_w 5067
    //   2197: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2200: ifeq +24 -> 2224
    //   2203: aload 8
    //   2205: ldc_w 5067
    //   2208: aload_0
    //   2209: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2212: ldc_w 5067
    //   2215: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2218: checkcast 50	java/lang/String
    //   2221: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2224: aload_0
    //   2225: aload 9
    //   2227: aload 7
    //   2229: lload_3
    //   2230: aload 8
    //   2232: invokespecial 5069	bbds:a	(Ljava/lang/String;Ljava/lang/String;JLandroid/os/Bundle;)Z
    //   2235: ireturn
    //   2236: aconst_null
    //   2237: astore 7
    //   2239: goto -265 -> 1974
    //   2242: aconst_null
    //   2243: astore 8
    //   2245: goto -243 -> 2002
    //   2248: ldc_w 1777
    //   2251: aload 9
    //   2253: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2256: ifeq +13 -> 2269
    //   2259: aload_0
    //   2260: aload 9
    //   2262: aload 7
    //   2264: lload_3
    //   2265: invokespecial 5071	bbds:a	(Ljava/lang/String;Ljava/lang/String;J)Z
    //   2268: ireturn
    //   2269: ldc_w 5073
    //   2272: aload_0
    //   2273: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2276: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2279: ifeq +72 -> 2351
    //   2282: ldc_w 306
    //   2285: aload_0
    //   2286: getfield 295	bbds:c	Ljava/lang/String;
    //   2289: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2292: ifeq +59 -> 2351
    //   2295: aload_0
    //   2296: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2299: ldc_w 711
    //   2302: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2305: ifeq +46 -> 2351
    //   2308: aload_0
    //   2309: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2312: ldc_w 711
    //   2315: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2318: checkcast 50	java/lang/String
    //   2321: invokestatic 3523	bbjw:a	(Ljava/lang/String;)Z
    //   2324: ifne +27 -> 2351
    //   2327: ldc_w 1716
    //   2330: aload_0
    //   2331: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2334: ldc_w 711
    //   2337: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2340: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2343: ifeq +8 -> 2351
    //   2346: aload_0
    //   2347: invokespecial 5075	bbds:B	()Z
    //   2350: ireturn
    //   2351: ldc_w 5077
    //   2354: aload_0
    //   2355: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2358: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2361: ifeq +127 -> 2488
    //   2364: ldc_w 306
    //   2367: aload_0
    //   2368: getfield 295	bbds:c	Ljava/lang/String;
    //   2371: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2374: ifeq +245 -> 2619
    //   2377: aload_0
    //   2378: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2381: ldc 142
    //   2383: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2386: ifeq +102 -> 2488
    //   2389: new 152	org/json/JSONObject
    //   2392: dup
    //   2393: aload_0
    //   2394: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2397: ldc 142
    //   2399: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2402: checkcast 50	java/lang/String
    //   2405: invokestatic 1600	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   2408: invokespecial 164	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2411: astore 7
    //   2413: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2416: ifeq +31 -> 2447
    //   2419: ldc_w 435
    //   2422: iconst_2
    //   2423: new 197	java/lang/StringBuilder
    //   2426: dup
    //   2427: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   2430: ldc_w 5079
    //   2433: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2436: aload 7
    //   2438: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2441: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2444: invokestatic 439	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2447: aload 7
    //   2449: ldc_w 5081
    //   2452: iconst_0
    //   2453: invokevirtual 5083	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2456: ifne +32 -> 2488
    //   2459: aload 7
    //   2461: ldc 142
    //   2463: invokevirtual 5086	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2466: astore 7
    //   2468: aload 7
    //   2470: ifnull +18 -> 2488
    //   2473: aload_0
    //   2474: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2477: aload 7
    //   2479: ldc_w 5088
    //   2482: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2485: invokestatic 5091	com/tencent/mobileqq/activity/activateFriend/ReminderListFragment:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   2488: ldc_w 5077
    //   2491: aload_0
    //   2492: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2495: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2498: ifeq +51 -> 2549
    //   2501: ldc_w 5093
    //   2504: aload_0
    //   2505: getfield 295	bbds:c	Ljava/lang/String;
    //   2508: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2511: ifeq +38 -> 2549
    //   2514: new 106	android/content/Intent
    //   2517: dup
    //   2518: aload_0
    //   2519: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2522: ldc_w 5095
    //   2525: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2528: astore 7
    //   2530: aload 7
    //   2532: ldc_w 5097
    //   2535: iconst_2
    //   2536: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2539: pop
    //   2540: aload_0
    //   2541: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2544: aload 7
    //   2546: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2549: aload_0
    //   2550: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2553: ldc_w 5099
    //   2556: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2559: ifeq +225 -> 2784
    //   2562: aload_0
    //   2563: getfield 295	bbds:c	Ljava/lang/String;
    //   2566: ldc_w 5101
    //   2569: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2572: ifeq +194 -> 2766
    //   2575: aload_0
    //   2576: invokespecial 5103	bbds:C	()Z
    //   2579: ireturn
    //   2580: astore 7
    //   2582: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2585: ifeq -97 -> 2488
    //   2588: ldc_w 435
    //   2591: iconst_2
    //   2592: new 197	java/lang/StringBuilder
    //   2595: dup
    //   2596: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   2599: ldc_w 5105
    //   2602: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2605: aload 7
    //   2607: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2610: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2613: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2616: goto -128 -> 2488
    //   2619: ldc_w 5107
    //   2622: aload_0
    //   2623: getfield 295	bbds:c	Ljava/lang/String;
    //   2626: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2629: ifeq -141 -> 2488
    //   2632: aload_0
    //   2633: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2636: ldc_w 5109
    //   2639: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2642: ifeq -154 -> 2488
    //   2645: aload_0
    //   2646: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2649: ldc_w 5111
    //   2652: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2655: ifeq -167 -> 2488
    //   2658: aload_0
    //   2659: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2662: ldc_w 5113
    //   2665: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2668: ifeq -180 -> 2488
    //   2671: aload_0
    //   2672: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2675: ldc_w 5111
    //   2678: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2681: checkcast 50	java/lang/String
    //   2684: astore 8
    //   2686: aload_0
    //   2687: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2690: ldc_w 5113
    //   2693: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2696: checkcast 50	java/lang/String
    //   2699: astore 9
    //   2701: aload_0
    //   2702: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2705: ldc_w 5109
    //   2708: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2711: checkcast 50	java/lang/String
    //   2714: astore 10
    //   2716: ldc 61
    //   2718: astore 7
    //   2720: aload_0
    //   2721: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2724: ldc_w 5115
    //   2727: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2730: ifeq +18 -> 2748
    //   2733: aload_0
    //   2734: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2737: ldc_w 5115
    //   2740: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2743: checkcast 50	java/lang/String
    //   2746: astore 7
    //   2748: aload_0
    //   2749: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2752: aload 8
    //   2754: aload 9
    //   2756: aload 10
    //   2758: aload 7
    //   2760: invokestatic 5120	com/tencent/mobileqq/activity/activateFriend/QQNotifySettingFragment:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2763: goto -275 -> 2488
    //   2766: aload_0
    //   2767: getfield 295	bbds:c	Ljava/lang/String;
    //   2770: ldc_w 5122
    //   2773: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2776: ifeq +8 -> 2784
    //   2779: aload_0
    //   2780: invokevirtual 5123	bbds:e	()Z
    //   2783: ireturn
    //   2784: aload_0
    //   2785: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2788: ldc_w 1786
    //   2791: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2794: ifeq +21 -> 2815
    //   2797: aload_0
    //   2798: getfield 295	bbds:c	Ljava/lang/String;
    //   2801: ldc_w 5125
    //   2804: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2807: ifeq +8 -> 2815
    //   2810: aload_0
    //   2811: invokespecial 5127	bbds:ah	()Z
    //   2814: ireturn
    //   2815: aload_0
    //   2816: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2819: ldc_w 5129
    //   2822: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2825: ifeq +21 -> 2846
    //   2828: aload_0
    //   2829: getfield 295	bbds:c	Ljava/lang/String;
    //   2832: ldc_w 2957
    //   2835: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2838: ifeq +8 -> 2846
    //   2841: aload_0
    //   2842: invokespecial 5131	bbds:aj	()Z
    //   2845: ireturn
    //   2846: aload_0
    //   2847: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2850: ldc_w 5133
    //   2853: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2856: ifeq +30 -> 2886
    //   2859: aload_0
    //   2860: getfield 295	bbds:c	Ljava/lang/String;
    //   2863: ldc_w 5135
    //   2866: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2869: ifeq +17 -> 2886
    //   2872: aload_0
    //   2873: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2876: ldc_w 5137
    //   2879: iconst_2
    //   2880: iconst_0
    //   2881: invokestatic 5140	sjs:a	(Landroid/content/Context;Ljava/lang/String;IZ)V
    //   2884: iconst_1
    //   2885: ireturn
    //   2886: aload_0
    //   2887: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2890: ldc_w 5142
    //   2893: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2896: ifeq +21 -> 2917
    //   2899: aload_0
    //   2900: getfield 295	bbds:c	Ljava/lang/String;
    //   2903: ldc_w 5144
    //   2906: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2909: ifeq +8 -> 2917
    //   2912: aload_0
    //   2913: invokespecial 5146	bbds:bn	()Z
    //   2916: ireturn
    //   2917: aload_0
    //   2918: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2921: ldc_w 5148
    //   2924: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2927: ifeq +21 -> 2948
    //   2930: aload_0
    //   2931: getfield 295	bbds:c	Ljava/lang/String;
    //   2934: ldc_w 4807
    //   2937: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2940: ifeq +8 -> 2948
    //   2943: aload_0
    //   2944: invokespecial 5150	bbds:ai	()Z
    //   2947: ireturn
    //   2948: aload_0
    //   2949: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2952: ldc_w 5129
    //   2955: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2958: ifeq +21 -> 2979
    //   2961: aload_0
    //   2962: getfield 295	bbds:c	Ljava/lang/String;
    //   2965: ldc_w 5152
    //   2968: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2971: ifeq +8 -> 2979
    //   2974: aload_0
    //   2975: invokespecial 5154	bbds:ao	()Z
    //   2978: ireturn
    //   2979: aload_0
    //   2980: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2983: ldc_w 5156
    //   2986: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2989: ifeq +8 -> 2997
    //   2992: aload_0
    //   2993: invokespecial 5158	bbds:bl	()Z
    //   2996: ireturn
    //   2997: aload_0
    //   2998: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3001: ldc_w 3003
    //   3004: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3007: ifeq +21 -> 3028
    //   3010: aload_0
    //   3011: getfield 295	bbds:c	Ljava/lang/String;
    //   3014: ldc_w 5160
    //   3017: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3020: ifeq +8 -> 3028
    //   3023: aload_0
    //   3024: invokespecial 5162	bbds:ap	()Z
    //   3027: ireturn
    //   3028: aload_0
    //   3029: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3032: ldc_w 3003
    //   3035: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3038: ifeq +21 -> 3059
    //   3041: aload_0
    //   3042: getfield 295	bbds:c	Ljava/lang/String;
    //   3045: ldc_w 5164
    //   3048: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3051: ifeq +8 -> 3059
    //   3054: aload_0
    //   3055: invokespecial 5166	bbds:at	()Z
    //   3058: ireturn
    //   3059: aload_0
    //   3060: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3063: ldc_w 3003
    //   3066: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3069: ifeq +21 -> 3090
    //   3072: aload_0
    //   3073: getfield 295	bbds:c	Ljava/lang/String;
    //   3076: ldc_w 3215
    //   3079: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3082: ifeq +8 -> 3090
    //   3085: aload_0
    //   3086: invokespecial 5168	bbds:au	()Z
    //   3089: ireturn
    //   3090: ldc_w 4780
    //   3093: aload_0
    //   3094: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3097: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3100: ifeq +21 -> 3121
    //   3103: ldc_w 4782
    //   3106: aload_0
    //   3107: getfield 295	bbds:c	Ljava/lang/String;
    //   3110: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3113: ifeq +8 -> 3121
    //   3116: aload_0
    //   3117: invokespecial 5170	bbds:av	()Z
    //   3120: ireturn
    //   3121: aload_0
    //   3122: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3125: ldc_w 5172
    //   3128: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3131: ifeq +21 -> 3152
    //   3134: aload_0
    //   3135: getfield 295	bbds:c	Ljava/lang/String;
    //   3138: ldc_w 5174
    //   3141: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3144: ifeq +8 -> 3152
    //   3147: aload_0
    //   3148: invokespecial 5176	bbds:aB	()Z
    //   3151: ireturn
    //   3152: aload_0
    //   3153: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3156: ldc_w 5178
    //   3159: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3162: ifeq +21 -> 3183
    //   3165: aload_0
    //   3166: getfield 295	bbds:c	Ljava/lang/String;
    //   3169: ldc_w 2062
    //   3172: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3175: ifeq +8 -> 3183
    //   3178: aload_0
    //   3179: invokespecial 5180	bbds:aJ	()Z
    //   3182: ireturn
    //   3183: aload_0
    //   3184: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3187: ldc_w 5182
    //   3190: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3193: ifeq +21 -> 3214
    //   3196: aload_0
    //   3197: getfield 295	bbds:c	Ljava/lang/String;
    //   3200: ldc_w 391
    //   3203: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3206: ifeq +8 -> 3214
    //   3209: aload_0
    //   3210: invokespecial 5184	bbds:aN	()Z
    //   3213: ireturn
    //   3214: aload_0
    //   3215: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3218: ldc_w 5182
    //   3221: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3224: ifeq +21 -> 3245
    //   3227: aload_0
    //   3228: getfield 295	bbds:c	Ljava/lang/String;
    //   3231: ldc_w 5186
    //   3234: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3237: ifeq +8 -> 3245
    //   3240: aload_0
    //   3241: invokespecial 5188	bbds:bz	()Z
    //   3244: ireturn
    //   3245: aload_0
    //   3246: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3249: ldc_w 5190
    //   3252: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3255: ifeq +21 -> 3276
    //   3258: aload_0
    //   3259: getfield 295	bbds:c	Ljava/lang/String;
    //   3262: ldc_w 5192
    //   3265: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3268: ifeq +8 -> 3276
    //   3271: aload_0
    //   3272: invokespecial 5194	bbds:aM	()Z
    //   3275: ireturn
    //   3276: aload_0
    //   3277: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3280: ldc_w 5196
    //   3283: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3286: ifeq +21 -> 3307
    //   3289: aload_0
    //   3290: getfield 295	bbds:c	Ljava/lang/String;
    //   3293: ldc_w 5198
    //   3296: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3299: ifeq +8 -> 3307
    //   3302: aload_0
    //   3303: invokespecial 5200	bbds:aK	()Z
    //   3306: ireturn
    //   3307: aload_0
    //   3308: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3311: ldc_w 5196
    //   3314: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3317: ifeq +21 -> 3338
    //   3320: aload_0
    //   3321: getfield 295	bbds:c	Ljava/lang/String;
    //   3324: ldc_w 5192
    //   3327: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3330: ifeq +8 -> 3338
    //   3333: aload_0
    //   3334: invokespecial 5202	bbds:aL	()Z
    //   3337: ireturn
    //   3338: aload_0
    //   3339: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3342: ldc_w 4291
    //   3345: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3348: ifeq +21 -> 3369
    //   3351: aload_0
    //   3352: getfield 295	bbds:c	Ljava/lang/String;
    //   3355: ldc_w 5204
    //   3358: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3361: ifeq +8 -> 3369
    //   3364: aload_0
    //   3365: invokespecial 5206	bbds:aO	()Z
    //   3368: ireturn
    //   3369: aload_0
    //   3370: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3373: ldc_w 4291
    //   3376: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3379: ifeq +21 -> 3400
    //   3382: aload_0
    //   3383: getfield 295	bbds:c	Ljava/lang/String;
    //   3386: ldc_w 5208
    //   3389: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3392: ifeq +8 -> 3400
    //   3395: aload_0
    //   3396: invokespecial 5210	bbds:bk	()Z
    //   3399: ireturn
    //   3400: aload_0
    //   3401: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3404: ldc_w 5190
    //   3407: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3410: ifeq +59 -> 3469
    //   3413: aload_0
    //   3414: getfield 295	bbds:c	Ljava/lang/String;
    //   3417: ldc_w 5212
    //   3420: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3423: ifeq +46 -> 3469
    //   3426: aload_0
    //   3427: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   3430: ldc_w 1997
    //   3433: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3436: checkcast 989	java/lang/CharSequence
    //   3439: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3442: ifne +22 -> 3464
    //   3445: aload_0
    //   3446: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   3449: ldc_w 1997
    //   3452: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3455: checkcast 50	java/lang/String
    //   3458: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3461: putstatic 5213	bbds:k	Ljava/lang/String;
    //   3464: aload_0
    //   3465: invokespecial 5215	bbds:aQ	()Z
    //   3468: ireturn
    //   3469: aload_0
    //   3470: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3473: ldc_w 4291
    //   3476: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3479: ifeq +21 -> 3500
    //   3482: aload_0
    //   3483: getfield 295	bbds:c	Ljava/lang/String;
    //   3486: ldc_w 5217
    //   3489: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3492: ifeq +8 -> 3500
    //   3495: aload_0
    //   3496: invokespecial 5219	bbds:aV	()Z
    //   3499: ireturn
    //   3500: aload_0
    //   3501: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3504: ldc_w 4291
    //   3507: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3510: ifeq +24 -> 3534
    //   3513: aload_0
    //   3514: getfield 295	bbds:c	Ljava/lang/String;
    //   3517: ldc_w 5221
    //   3520: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3523: ifeq +11 -> 3534
    //   3526: aload_0
    //   3527: ldc_w 5223
    //   3530: invokespecial 2385	bbds:d	(Ljava/lang/String;)Z
    //   3533: ireturn
    //   3534: aload_0
    //   3535: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3538: ldc_w 4831
    //   3541: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3544: ifeq +21 -> 3565
    //   3547: aload_0
    //   3548: getfield 295	bbds:c	Ljava/lang/String;
    //   3551: ldc_w 297
    //   3554: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3557: ifeq +8 -> 3565
    //   3560: aload_0
    //   3561: invokespecial 5225	bbds:aW	()Z
    //   3564: ireturn
    //   3565: aload_0
    //   3566: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3569: ldc_w 4831
    //   3572: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3575: ifeq +21 -> 3596
    //   3578: aload_0
    //   3579: getfield 295	bbds:c	Ljava/lang/String;
    //   3582: ldc_w 5227
    //   3585: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3588: ifeq +8 -> 3596
    //   3591: aload_0
    //   3592: invokespecial 5229	bbds:ba	()Z
    //   3595: ireturn
    //   3596: aload_0
    //   3597: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3600: ldc_w 4831
    //   3603: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3606: ifeq +21 -> 3627
    //   3609: aload_0
    //   3610: getfield 295	bbds:c	Ljava/lang/String;
    //   3613: ldc_w 5231
    //   3616: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3619: ifeq +8 -> 3627
    //   3622: aload_0
    //   3623: invokespecial 5233	bbds:bb	()Z
    //   3626: ireturn
    //   3627: aload_0
    //   3628: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3631: ldc_w 4831
    //   3634: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3637: ifeq +21 -> 3658
    //   3640: aload_0
    //   3641: getfield 295	bbds:c	Ljava/lang/String;
    //   3644: ldc_w 5235
    //   3647: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3650: ifeq +8 -> 3658
    //   3653: aload_0
    //   3654: invokespecial 5237	bbds:bc	()Z
    //   3657: ireturn
    //   3658: aload_0
    //   3659: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3662: ldc_w 4831
    //   3665: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3668: ifeq +21 -> 3689
    //   3671: aload_0
    //   3672: getfield 295	bbds:c	Ljava/lang/String;
    //   3675: ldc_w 5239
    //   3678: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3681: ifeq +8 -> 3689
    //   3684: aload_0
    //   3685: invokespecial 5241	bbds:aR	()Z
    //   3688: ireturn
    //   3689: aload_0
    //   3690: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3693: ldc_w 4831
    //   3696: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3699: ifeq +21 -> 3720
    //   3702: aload_0
    //   3703: getfield 295	bbds:c	Ljava/lang/String;
    //   3706: ldc_w 5243
    //   3709: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3712: ifeq +8 -> 3720
    //   3715: aload_0
    //   3716: invokevirtual 5245	bbds:i	()Z
    //   3719: ireturn
    //   3720: aload_0
    //   3721: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3724: ldc_w 4831
    //   3727: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3730: ifeq +21 -> 3751
    //   3733: aload_0
    //   3734: getfield 295	bbds:c	Ljava/lang/String;
    //   3737: ldc_w 5247
    //   3740: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3743: ifeq +8 -> 3751
    //   3746: aload_0
    //   3747: invokespecial 5249	bbds:aS	()Z
    //   3750: ireturn
    //   3751: aload_0
    //   3752: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3755: ldc_w 4831
    //   3758: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3761: ifeq +21 -> 3782
    //   3764: aload_0
    //   3765: getfield 295	bbds:c	Ljava/lang/String;
    //   3768: ldc_w 5251
    //   3771: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3774: ifeq +8 -> 3782
    //   3777: aload_0
    //   3778: invokespecial 5253	bbds:aX	()Z
    //   3781: ireturn
    //   3782: aload_0
    //   3783: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3786: ldc_w 4831
    //   3789: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3792: ifeq +21 -> 3813
    //   3795: aload_0
    //   3796: getfield 295	bbds:c	Ljava/lang/String;
    //   3799: ldc_w 5255
    //   3802: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3805: ifeq +8 -> 3813
    //   3808: aload_0
    //   3809: invokespecial 5257	bbds:aY	()Z
    //   3812: ireturn
    //   3813: aload_0
    //   3814: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3817: ldc_w 4831
    //   3820: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3823: ifeq +21 -> 3844
    //   3826: aload_0
    //   3827: getfield 295	bbds:c	Ljava/lang/String;
    //   3830: ldc_w 5259
    //   3833: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3836: ifeq +8 -> 3844
    //   3839: aload_0
    //   3840: invokespecial 5261	bbds:aT	()Z
    //   3843: ireturn
    //   3844: aload_0
    //   3845: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3848: ldc_w 4831
    //   3851: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3854: ifeq +21 -> 3875
    //   3857: aload_0
    //   3858: getfield 295	bbds:c	Ljava/lang/String;
    //   3861: ldc_w 5263
    //   3864: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3867: ifeq +8 -> 3875
    //   3870: aload_0
    //   3871: invokespecial 5265	bbds:aZ	()Z
    //   3874: ireturn
    //   3875: aload_0
    //   3876: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3879: ldc_w 4831
    //   3882: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3885: ifeq +21 -> 3906
    //   3888: aload_0
    //   3889: getfield 295	bbds:c	Ljava/lang/String;
    //   3892: ldc_w 5267
    //   3895: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3898: ifeq +8 -> 3906
    //   3901: aload_0
    //   3902: invokespecial 5269	bbds:aU	()Z
    //   3905: ireturn
    //   3906: aload_0
    //   3907: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3910: ldc_w 5271
    //   3913: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3916: ifeq +54 -> 3970
    //   3919: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3922: ifeq +13 -> 3935
    //   3925: ldc_w 435
    //   3928: iconst_2
    //   3929: ldc_w 5273
    //   3932: invokestatic 456	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3935: aload_0
    //   3936: invokespecial 5275	bbds:k	()V
    //   3939: aload_0
    //   3940: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3943: ldc_w 5277
    //   3946: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3949: ifeq +4697 -> 8646
    //   3952: aload_0
    //   3953: getfield 295	bbds:c	Ljava/lang/String;
    //   3956: ldc_w 5279
    //   3959: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3962: ifeq +4684 -> 8646
    //   3965: aload_0
    //   3966: invokespecial 5281	bbds:bo	()Z
    //   3969: ireturn
    //   3970: aload_0
    //   3971: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3974: ldc_w 5283
    //   3977: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3980: ifeq +21 -> 4001
    //   3983: aload_0
    //   3984: getfield 295	bbds:c	Ljava/lang/String;
    //   3987: ldc_w 5285
    //   3990: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3993: ifeq +8 -> 4001
    //   3996: aload_0
    //   3997: invokespecial 5287	bbds:bF	()Z
    //   4000: ireturn
    //   4001: aload_0
    //   4002: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4005: ldc_w 5289
    //   4008: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4011: ifeq +21 -> 4032
    //   4014: aload_0
    //   4015: getfield 295	bbds:c	Ljava/lang/String;
    //   4018: ldc_w 306
    //   4021: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4024: ifeq +8 -> 4032
    //   4027: aload_0
    //   4028: invokespecial 5291	bbds:bG	()Z
    //   4031: ireturn
    //   4032: aload_0
    //   4033: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4036: ldc_w 2434
    //   4039: invokevirtual 2248	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4042: ifeq +24 -> 4066
    //   4045: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4048: ifeq +13 -> 4061
    //   4051: ldc_w 435
    //   4054: iconst_2
    //   4055: ldc_w 5293
    //   4058: invokestatic 456	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4061: aload_0
    //   4062: invokespecial 5295	bbds:bj	()Z
    //   4065: ireturn
    //   4066: aload_0
    //   4067: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4070: ldc_w 5297
    //   4073: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4076: ifeq +150 -> 4226
    //   4079: aload_0
    //   4080: getfield 295	bbds:c	Ljava/lang/String;
    //   4083: ldc_w 5299
    //   4086: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4089: ifeq +137 -> 4226
    //   4092: aload_0
    //   4093: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4096: ldc_w 1980
    //   4099: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4102: checkcast 989	java/lang/CharSequence
    //   4105: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4108: ifne +19 -> 4127
    //   4111: aload_0
    //   4112: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4115: ldc_w 1980
    //   4118: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4121: checkcast 50	java/lang/String
    //   4124: putstatic 5300	bbds:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   4127: aload_0
    //   4128: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4131: ldc_w 1982
    //   4134: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4137: checkcast 989	java/lang/CharSequence
    //   4140: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4143: ifne +19 -> 4162
    //   4146: aload_0
    //   4147: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4150: ldc_w 1982
    //   4153: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4156: checkcast 50	java/lang/String
    //   4159: putstatic 1993	bbds:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   4162: aload_0
    //   4163: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4166: ldc_w 1995
    //   4169: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4172: checkcast 989	java/lang/CharSequence
    //   4175: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4178: ifne +19 -> 4197
    //   4181: aload_0
    //   4182: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4185: ldc_w 1995
    //   4188: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4191: checkcast 50	java/lang/String
    //   4194: putstatic 5301	bbds:l	Ljava/lang/String;
    //   4197: ldc_w 2559
    //   4200: aload_0
    //   4201: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4204: ldc_w 1997
    //   4207: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4210: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4213: ifeq +8 -> 4221
    //   4216: aload_0
    //   4217: invokespecial 5303	bbds:aF	()Z
    //   4220: ireturn
    //   4221: aload_0
    //   4222: invokespecial 5305	bbds:aI	()Z
    //   4225: ireturn
    //   4226: aload_0
    //   4227: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4230: ldc_w 5307
    //   4233: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4236: ifeq +21 -> 4257
    //   4239: aload_0
    //   4240: getfield 295	bbds:c	Ljava/lang/String;
    //   4243: ldc_w 5309
    //   4246: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4249: ifeq +8 -> 4257
    //   4252: aload_0
    //   4253: invokespecial 5311	bbds:bd	()Z
    //   4256: ireturn
    //   4257: ldc_w 2978
    //   4260: aload_0
    //   4261: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4264: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4267: ifeq +57 -> 4324
    //   4270: aload_0
    //   4271: getfield 295	bbds:c	Ljava/lang/String;
    //   4274: ldc_w 3259
    //   4277: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4280: ifeq +8 -> 4288
    //   4283: aload_0
    //   4284: invokespecial 5313	bbds:aq	()Z
    //   4287: ireturn
    //   4288: aload_0
    //   4289: getfield 295	bbds:c	Ljava/lang/String;
    //   4292: ldc_w 5315
    //   4295: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4298: ifeq +8 -> 4306
    //   4301: aload_0
    //   4302: invokespecial 5317	bbds:ar	()Z
    //   4305: ireturn
    //   4306: aload_0
    //   4307: getfield 295	bbds:c	Ljava/lang/String;
    //   4310: ldc_w 5319
    //   4313: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4316: ifeq -377 -> 3939
    //   4319: aload_0
    //   4320: invokespecial 5321	bbds:bB	()Z
    //   4323: ireturn
    //   4324: aload_0
    //   4325: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4328: ldc_w 5323
    //   4331: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4334: ifeq +37 -> 4371
    //   4337: aload_0
    //   4338: getfield 295	bbds:c	Ljava/lang/String;
    //   4341: ldc_w 5325
    //   4344: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4347: ifeq +24 -> 4371
    //   4350: aload_0
    //   4351: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4354: checkcast 745	android/app/Activity
    //   4357: aload_0
    //   4358: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4361: invokevirtual 1659	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   4364: bipush 7
    //   4366: invokestatic 5330	com/tencent/mobileqq/vaswebviewplugin/EmojiHomeUiPlugin:openEmojiHomePage	(Landroid/app/Activity;Ljava/lang/String;I)V
    //   4369: iconst_1
    //   4370: ireturn
    //   4371: aload_0
    //   4372: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4375: ldc_w 5323
    //   4378: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4381: ifeq +43 -> 4424
    //   4384: aload_0
    //   4385: getfield 295	bbds:c	Ljava/lang/String;
    //   4388: ldc_w 5332
    //   4391: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4394: ifeq +30 -> 4424
    //   4397: aload_0
    //   4398: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4401: checkcast 745	android/app/Activity
    //   4404: aload_0
    //   4405: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4408: invokevirtual 1659	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   4411: iconst_4
    //   4412: aload_0
    //   4413: ldc_w 5334
    //   4416: invokevirtual 829	bbds:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4419: invokestatic 5338	com/tencent/mobileqq/vaswebviewplugin/EmojiHomeUiPlugin:openEmojiDetailPage	(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;)V
    //   4422: iconst_1
    //   4423: ireturn
    //   4424: aload_0
    //   4425: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4428: ldc_w 5323
    //   4431: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4434: ifeq +43 -> 4477
    //   4437: aload_0
    //   4438: getfield 295	bbds:c	Ljava/lang/String;
    //   4441: ldc_w 5340
    //   4444: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4447: ifeq +30 -> 4477
    //   4450: aload_0
    //   4451: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4454: checkcast 745	android/app/Activity
    //   4457: aload_0
    //   4458: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4461: invokevirtual 1659	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   4464: iconst_5
    //   4465: aload_0
    //   4466: ldc_w 5342
    //   4469: invokevirtual 829	bbds:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4472: invokestatic 5345	com/tencent/mobileqq/vaswebviewplugin/EmojiHomeUiPlugin:openEmojiAuthorPage	(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;)V
    //   4475: iconst_1
    //   4476: ireturn
    //   4477: aload_0
    //   4478: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4481: ldc_w 5323
    //   4484: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4487: ifeq +44 -> 4531
    //   4490: aload_0
    //   4491: getfield 295	bbds:c	Ljava/lang/String;
    //   4494: ldc_w 5347
    //   4497: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4500: ifeq +31 -> 4531
    //   4503: aload_0
    //   4504: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4507: aload_0
    //   4508: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4511: ldc_w 5347
    //   4514: ldc_w 5349
    //   4517: invokestatic 5354	bbpp:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4520: ldc2_w 5355
    //   4523: aconst_null
    //   4524: iconst_0
    //   4525: iconst_m1
    //   4526: invokestatic 5362	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUtil:openQQBrowserWithoutAD	(Landroid/content/Context;Ljava/lang/String;JLandroid/content/Intent;ZI)V
    //   4529: iconst_1
    //   4530: ireturn
    //   4531: aload_0
    //   4532: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4535: ldc_w 5323
    //   4538: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4541: ifeq +56 -> 4597
    //   4544: aload_0
    //   4545: getfield 295	bbds:c	Ljava/lang/String;
    //   4548: ldc_w 5364
    //   4551: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4554: ifeq +43 -> 4597
    //   4557: getstatic 5367	com/tencent/common/app/BaseApplicationImpl:IS_SUPPORT_THEME	Z
    //   4560: ifeq -621 -> 3939
    //   4563: invokestatic 5368	bbbd:a	()Z
    //   4566: ifeq -627 -> 3939
    //   4569: aload_0
    //   4570: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4573: aload_0
    //   4574: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4577: ldc_w 5364
    //   4580: ldc_w 5370
    //   4583: invokestatic 5354	bbpp:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4586: ldc2_w 5371
    //   4589: aconst_null
    //   4590: iconst_0
    //   4591: iconst_m1
    //   4592: invokestatic 5362	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUtil:openQQBrowserWithoutAD	(Landroid/content/Context;Ljava/lang/String;JLandroid/content/Intent;ZI)V
    //   4595: iconst_1
    //   4596: ireturn
    //   4597: aload_0
    //   4598: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4601: ldc_w 5323
    //   4604: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4607: ifeq +67 -> 4674
    //   4610: aload_0
    //   4611: getfield 295	bbds:c	Ljava/lang/String;
    //   4614: ldc_w 5374
    //   4617: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4620: ifeq +54 -> 4674
    //   4623: aload_0
    //   4624: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4627: bipush 42
    //   4629: invokevirtual 348	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4632: checkcast 5376	ho
    //   4635: invokevirtual 5377	ho:c	()Z
    //   4638: ifeq -699 -> 3939
    //   4641: invokestatic 5368	bbbd:a	()Z
    //   4644: ifeq -705 -> 3939
    //   4647: aload_0
    //   4648: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4651: aload_0
    //   4652: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4655: ldc_w 5374
    //   4658: ldc 61
    //   4660: invokestatic 5354	bbpp:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4663: ldc2_w 5378
    //   4666: aconst_null
    //   4667: iconst_0
    //   4668: iconst_m1
    //   4669: invokestatic 5362	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUtil:openQQBrowserWithoutAD	(Landroid/content/Context;Ljava/lang/String;JLandroid/content/Intent;ZI)V
    //   4672: iconst_1
    //   4673: ireturn
    //   4674: aload_0
    //   4675: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4678: ldc_w 5323
    //   4681: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4684: ifeq +35 -> 4719
    //   4687: aload_0
    //   4688: getfield 295	bbds:c	Ljava/lang/String;
    //   4691: ldc_w 5381
    //   4694: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4697: ifeq +22 -> 4719
    //   4700: invokestatic 5368	bbbd:a	()Z
    //   4703: ifeq +14 -> 4717
    //   4706: aload_0
    //   4707: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4710: aload_0
    //   4711: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4714: invokestatic 5385	bbby:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)V
    //   4717: iconst_1
    //   4718: ireturn
    //   4719: aload_0
    //   4720: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4723: ldc_w 5323
    //   4726: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4729: ifeq +25 -> 4754
    //   4732: aload_0
    //   4733: getfield 295	bbds:c	Ljava/lang/String;
    //   4736: ldc_w 5387
    //   4739: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4742: ifeq +12 -> 4754
    //   4745: aload_0
    //   4746: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4749: invokestatic 5391	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUtil:openIndividuationIndex	(Landroid/content/Context;)V
    //   4752: iconst_1
    //   4753: ireturn
    //   4754: aload_0
    //   4755: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4758: ldc_w 5323
    //   4761: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4764: ifeq +326 -> 5090
    //   4767: aload_0
    //   4768: getfield 295	bbds:c	Ljava/lang/String;
    //   4771: ldc_w 5393
    //   4774: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4777: ifeq +313 -> 5090
    //   4780: new 106	android/content/Intent
    //   4783: dup
    //   4784: invokespecial 395	android/content/Intent:<init>	()V
    //   4787: astore 9
    //   4789: aload_0
    //   4790: getfield 2050	bbds:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4793: ldc_w 4589
    //   4796: invokevirtual 1596	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4799: astore 7
    //   4801: aload 7
    //   4803: arraylength
    //   4804: iconst_2
    //   4805: if_icmplt +4869 -> 9674
    //   4808: aload 9
    //   4810: ldc_w 5395
    //   4813: aload 7
    //   4815: iconst_1
    //   4816: aaload
    //   4817: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4820: pop
    //   4821: aload 7
    //   4823: iconst_1
    //   4824: aaload
    //   4825: ifnull +4849 -> 9674
    //   4828: aload 7
    //   4830: iconst_1
    //   4831: aaload
    //   4832: ldc_w 5397
    //   4835: invokevirtual 1080	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4838: ifeq +129 -> 4967
    //   4841: aconst_null
    //   4842: astore 7
    //   4844: iconst_0
    //   4845: istore_1
    //   4846: iconst_1
    //   4847: istore_2
    //   4848: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4851: ifeq +25 -> 4876
    //   4854: ldc_w 435
    //   4857: iconst_2
    //   4858: iconst_2
    //   4859: anewarray 4	java/lang/Object
    //   4862: dup
    //   4863: iconst_0
    //   4864: ldc_w 5399
    //   4867: aastore
    //   4868: dup
    //   4869: iconst_1
    //   4870: aload 7
    //   4872: aastore
    //   4873: invokestatic 967	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   4876: aload 7
    //   4878: astore 8
    //   4880: aload 7
    //   4882: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4885: ifeq +8 -> 4893
    //   4888: getstatic 5403	ajmu:ah	Ljava/lang/String;
    //   4891: astore 8
    //   4893: iload_2
    //   4894: ifeq +164 -> 5058
    //   4897: aload_0
    //   4898: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4901: invokestatic 5407	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Landroid/content/Context;)V
    //   4904: aload_0
    //   4905: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4908: ifnull +57 -> 4965
    //   4911: aload_0
    //   4912: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4915: sipush 153
    //   4918: invokevirtual 348	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4921: checkcast 5409	airz
    //   4924: astore 7
    //   4926: aload_0
    //   4927: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4930: ldc_w 5411
    //   4933: ldc_w 5413
    //   4936: ldc_w 5415
    //   4939: aload 7
    //   4941: aload_0
    //   4942: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4945: invokevirtual 655	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4948: invokevirtual 5417	airz:b	(Ljava/lang/String;)I
    //   4951: iconst_0
    //   4952: iconst_1
    //   4953: anewarray 50	java/lang/String
    //   4956: dup
    //   4957: iconst_0
    //   4958: ldc_w 372
    //   4961: aastore
    //   4962: invokestatic 5422	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   4965: iconst_1
    //   4966: ireturn
    //   4967: aload 7
    //   4969: iconst_1
    //   4970: aaload
    //   4971: ldc_w 5424
    //   4974: invokevirtual 1080	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4977: ifeq +39 -> 5016
    //   4980: aload 7
    //   4982: iconst_1
    //   4983: aaload
    //   4984: aload 7
    //   4986: iconst_1
    //   4987: aaload
    //   4988: ldc_w 5424
    //   4991: invokevirtual 2214	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4994: ldc_w 5424
    //   4997: invokevirtual 554	java/lang/String:length	()I
    //   5000: iadd
    //   5001: invokevirtual 2216	java/lang/String:substring	(I)Ljava/lang/String;
    //   5004: invokestatic 1600	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   5007: astore 7
    //   5009: iconst_1
    //   5010: istore_1
    //   5011: iconst_0
    //   5012: istore_2
    //   5013: goto -165 -> 4848
    //   5016: new 99	java/util/HashMap
    //   5019: dup
    //   5020: invokespecial 100	java/util/HashMap:<init>	()V
    //   5023: astore 8
    //   5025: aload 7
    //   5027: iconst_1
    //   5028: aaload
    //   5029: aload 8
    //   5031: invokestatic 5427	tsd:a	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   5034: aload 8
    //   5036: ldc_w 5101
    //   5039: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   5042: checkcast 50	java/lang/String
    //   5045: iconst_1
    //   5046: invokestatic 5430	airz:b	(Ljava/lang/String;Z)Ljava/lang/String;
    //   5049: astore 7
    //   5051: iconst_0
    //   5052: istore_2
    //   5053: iconst_0
    //   5054: istore_1
    //   5055: goto -207 -> 4848
    //   5058: iload_1
    //   5059: ifeq +15 -> 5074
    //   5062: aload_0
    //   5063: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5066: aload 8
    //   5068: invokestatic 5431	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   5071: goto -167 -> 4904
    //   5074: aload_0
    //   5075: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5078: aload 9
    //   5080: aconst_null
    //   5081: aload 8
    //   5083: aconst_null
    //   5084: invokestatic 5434	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/common/app/AppInterface;)V
    //   5087: goto -183 -> 4904
    //   5090: aload_0
    //   5091: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5094: ldc_w 5411
    //   5097: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5100: ifeq +55 -> 5155
    //   5103: aload_0
    //   5104: getfield 295	bbds:c	Ljava/lang/String;
    //   5107: ldc_w 5436
    //   5110: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5113: ifeq +42 -> 5155
    //   5116: ldc_w 435
    //   5119: iconst_1
    //   5120: new 197	java/lang/StringBuilder
    //   5123: dup
    //   5124: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   5127: ldc_w 5438
    //   5130: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5133: aload_0
    //   5134: getfield 2050	bbds:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5137: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5140: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5143: invokestatic 439	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5146: aload_0
    //   5147: aload_0
    //   5148: getfield 2050	bbds:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5151: invokespecial 5440	bbds:e	(Ljava/lang/String;)Z
    //   5154: ireturn
    //   5155: ldc_w 5442
    //   5158: aload_0
    //   5159: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5162: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5165: ifeq +21 -> 5186
    //   5168: ldc_w 5444
    //   5171: aload_0
    //   5172: getfield 295	bbds:c	Ljava/lang/String;
    //   5175: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5178: ifeq +8 -> 5186
    //   5181: aload_0
    //   5182: invokespecial 5446	bbds:V	()Z
    //   5185: ireturn
    //   5186: ldc_w 5442
    //   5189: aload_0
    //   5190: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5193: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5196: ifeq +21 -> 5217
    //   5199: ldc_w 5448
    //   5202: aload_0
    //   5203: getfield 295	bbds:c	Ljava/lang/String;
    //   5206: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5209: ifeq +8 -> 5217
    //   5212: aload_0
    //   5213: invokespecial 5450	bbds:X	()Z
    //   5216: ireturn
    //   5217: ldc_w 5442
    //   5220: aload_0
    //   5221: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5224: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5227: ifeq +21 -> 5248
    //   5230: ldc_w 5452
    //   5233: aload_0
    //   5234: getfield 295	bbds:c	Ljava/lang/String;
    //   5237: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5240: ifeq +8 -> 5248
    //   5243: aload_0
    //   5244: invokespecial 5454	bbds:Y	()Z
    //   5247: ireturn
    //   5248: ldc_w 5442
    //   5251: aload_0
    //   5252: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5255: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5258: ifeq +21 -> 5279
    //   5261: ldc_w 5456
    //   5264: aload_0
    //   5265: getfield 295	bbds:c	Ljava/lang/String;
    //   5268: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5271: ifeq +8 -> 5279
    //   5274: aload_0
    //   5275: invokespecial 5458	bbds:W	()Z
    //   5278: ireturn
    //   5279: ldc_w 5442
    //   5282: aload_0
    //   5283: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5286: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5289: ifeq +44 -> 5333
    //   5292: ldc_w 5460
    //   5295: aload_0
    //   5296: getfield 295	bbds:c	Ljava/lang/String;
    //   5299: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5302: ifeq +31 -> 5333
    //   5305: new 106	android/content/Intent
    //   5308: dup
    //   5309: aload_0
    //   5310: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5313: ldc_w 5462
    //   5316: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   5319: astore 7
    //   5321: aload_0
    //   5322: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5325: aload 7
    //   5327: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   5330: goto -1391 -> 3939
    //   5333: ldc_w 5464
    //   5336: aload_0
    //   5337: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5340: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5343: ifeq +107 -> 5450
    //   5346: ldc_w 5466
    //   5349: aload_0
    //   5350: getfield 295	bbds:c	Ljava/lang/String;
    //   5353: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5356: ifeq +94 -> 5450
    //   5359: new 932	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   5362: dup
    //   5363: aload_0
    //   5364: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   5367: ldc_w 653
    //   5370: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   5373: checkcast 50	java/lang/String
    //   5376: bipush 111
    //   5378: invokespecial 938	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   5381: astore 7
    //   5383: ldc_w 657
    //   5386: aload_0
    //   5387: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   5390: ldc_w 2859
    //   5393: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   5396: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5399: ifeq +22 -> 5421
    //   5402: aload 7
    //   5404: bipush 118
    //   5406: putfield 1800	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   5409: aload_0
    //   5410: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5413: aload 7
    //   5415: invokestatic 3403	com/tencent/mobileqq/activity/ProfileActivity:b	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)V
    //   5418: goto -1479 -> 3939
    //   5421: ldc_w 1716
    //   5424: aload_0
    //   5425: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   5428: ldc_w 2859
    //   5431: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   5434: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5437: ifeq -28 -> 5409
    //   5440: aload 7
    //   5442: bipush 121
    //   5444: putfield 1800	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   5447: goto -38 -> 5409
    //   5450: ldc_w 5468
    //   5453: aload_0
    //   5454: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5457: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5460: ifeq +21 -> 5481
    //   5463: ldc_w 5470
    //   5466: aload_0
    //   5467: getfield 295	bbds:c	Ljava/lang/String;
    //   5470: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5473: ifeq +8 -> 5481
    //   5476: aload_0
    //   5477: invokespecial 5472	bbds:Z	()Z
    //   5480: ireturn
    //   5481: ldc_w 5468
    //   5484: aload_0
    //   5485: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5488: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5491: ifeq +21 -> 5512
    //   5494: ldc_w 5474
    //   5497: aload_0
    //   5498: getfield 295	bbds:c	Ljava/lang/String;
    //   5501: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5504: ifeq +8 -> 5512
    //   5507: aload_0
    //   5508: invokespecial 5476	bbds:aa	()Z
    //   5511: ireturn
    //   5512: ldc_w 5468
    //   5515: aload_0
    //   5516: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5519: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5522: ifeq +21 -> 5543
    //   5525: ldc_w 5478
    //   5528: aload_0
    //   5529: getfield 295	bbds:c	Ljava/lang/String;
    //   5532: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5535: ifeq +8 -> 5543
    //   5538: aload_0
    //   5539: invokespecial 5480	bbds:ab	()Z
    //   5542: ireturn
    //   5543: ldc_w 5468
    //   5546: aload_0
    //   5547: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5550: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5553: ifeq +21 -> 5574
    //   5556: ldc_w 5482
    //   5559: aload_0
    //   5560: getfield 295	bbds:c	Ljava/lang/String;
    //   5563: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5566: ifeq +8 -> 5574
    //   5569: aload_0
    //   5570: invokespecial 5484	bbds:ac	()Z
    //   5573: ireturn
    //   5574: ldc_w 5468
    //   5577: aload_0
    //   5578: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5581: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5584: ifeq +21 -> 5605
    //   5587: ldc_w 5486
    //   5590: aload_0
    //   5591: getfield 295	bbds:c	Ljava/lang/String;
    //   5594: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5597: ifeq +8 -> 5605
    //   5600: aload_0
    //   5601: invokespecial 5488	bbds:ad	()Z
    //   5604: ireturn
    //   5605: aload_0
    //   5606: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5609: ldc_w 5490
    //   5612: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5615: ifne +16 -> 5631
    //   5618: aload_0
    //   5619: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5622: ldc_w 5492
    //   5625: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5628: ifeq +21 -> 5649
    //   5631: aload_0
    //   5632: getfield 295	bbds:c	Ljava/lang/String;
    //   5635: ldc_w 306
    //   5638: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5641: ifeq +8 -> 5649
    //   5644: aload_0
    //   5645: invokespecial 5494	bbds:as	()Z
    //   5648: ireturn
    //   5649: aload_0
    //   5650: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   5653: ldc_w 5496
    //   5656: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5659: ifeq +580 -> 6239
    //   5662: aload_0
    //   5663: getfield 295	bbds:c	Ljava/lang/String;
    //   5666: ldc_w 306
    //   5669: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5672: ifeq +567 -> 6239
    //   5675: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5678: ifeq +13 -> 5691
    //   5681: ldc_w 435
    //   5684: iconst_2
    //   5685: ldc_w 5498
    //   5688: invokestatic 439	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5691: new 5500	com/tencent/mobileqq/utils/JumpAction$2
    //   5694: dup
    //   5695: aload_0
    //   5696: invokespecial 5501	com/tencent/mobileqq/utils/JumpAction$2:<init>	(Lbbds;)V
    //   5699: iconst_5
    //   5700: aconst_null
    //   5701: iconst_1
    //   5702: invokestatic 1388	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   5705: getstatic 5504	android/os/Build$VERSION:SDK_INT	I
    //   5708: bipush 19
    //   5710: if_icmplt +50 -> 5760
    //   5713: aload_0
    //   5714: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5717: ldc_w 5506
    //   5720: invokevirtual 5510	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   5723: checkcast 5512	android/hardware/SensorManager
    //   5726: bipush 19
    //   5728: invokevirtual 5516	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   5731: ifnull +29 -> 5760
    //   5734: aload_0
    //   5735: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5738: ifnull +22 -> 5760
    //   5741: aload_0
    //   5742: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5745: sipush 260
    //   5748: invokevirtual 348	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5751: checkcast 5518	bbui
    //   5754: ldc_w 5520
    //   5757: invokevirtual 5521	bbui:a	(Ljava/lang/String;)V
    //   5760: aload_0
    //   5761: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   5764: ldc_w 2108
    //   5767: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   5770: checkcast 50	java/lang/String
    //   5773: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   5776: astore 8
    //   5778: aload 8
    //   5780: ifnull +81 -> 5861
    //   5783: aload 8
    //   5785: ldc_w 2110
    //   5788: invokevirtual 2113	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5791: ifne +14 -> 5805
    //   5794: aload 8
    //   5796: ldc_w 2115
    //   5799: invokevirtual 2113	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5802: ifeq +59 -> 5861
    //   5805: aload 8
    //   5807: invokestatic 2118	nax:b	(Ljava/lang/String;)Ljava/lang/String;
    //   5810: ldc_w 2120
    //   5813: invokevirtual 1958	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   5816: ifne +47 -> 5863
    //   5819: aload 8
    //   5821: invokestatic 2118	nax:b	(Ljava/lang/String;)Ljava/lang/String;
    //   5824: ldc_w 2122
    //   5827: invokevirtual 1958	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   5830: ifne +33 -> 5863
    //   5833: aload 8
    //   5835: invokestatic 2118	nax:b	(Ljava/lang/String;)Ljava/lang/String;
    //   5838: ldc_w 2124
    //   5841: invokevirtual 1958	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   5844: ifne +19 -> 5863
    //   5847: aload 8
    //   5849: invokestatic 2118	nax:b	(Ljava/lang/String;)Ljava/lang/String;
    //   5852: ldc_w 2126
    //   5855: invokevirtual 1958	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   5858: ifne +5 -> 5863
    //   5861: iconst_0
    //   5862: ireturn
    //   5863: aload 8
    //   5865: astore 7
    //   5867: aload 8
    //   5869: ldc_w 2161
    //   5872: invokevirtual 2214	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   5875: ifgt +26 -> 5901
    //   5878: new 197	java/lang/StringBuilder
    //   5881: dup
    //   5882: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   5885: aload 8
    //   5887: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5890: ldc_w 2161
    //   5893: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5896: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5899: astore 7
    //   5901: new 197	java/lang/StringBuilder
    //   5904: dup
    //   5905: aload 7
    //   5907: invokespecial 638	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5910: astore 8
    //   5912: aload 8
    //   5914: ldc_w 5523
    //   5917: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5920: ldc_w 3997
    //   5923: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5926: aload_0
    //   5927: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5930: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5933: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5936: ldc_w 5525
    //   5939: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5942: ldc_w 5527
    //   5945: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5948: ldc_w 5529
    //   5951: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5954: getstatic 3418	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   5957: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5960: ldc_w 5531
    //   5963: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5966: getstatic 5534	android/os/Build:DEVICE	Ljava/lang/String;
    //   5969: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5972: ldc_w 5536
    //   5975: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5978: aload_0
    //   5979: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5982: invokevirtual 5539	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   5985: invokevirtual 5542	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   5988: invokestatic 5548	com/tencent/mobileqq/theme/ThemeUtil:getThemeDensity	(Landroid/content/Context;)Ljava/lang/String;
    //   5991: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5994: ldc_w 5550
    //   5997: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6000: ldc_w 5552
    //   6003: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6006: ldc_w 5554
    //   6009: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6012: astore 9
    //   6014: aload_0
    //   6015: getfield 1267	bbds:jdField_h_of_type_Boolean	Z
    //   6018: ifeq +213 -> 6231
    //   6021: ldc_w 657
    //   6024: astore 7
    //   6026: aload 9
    //   6028: aload 7
    //   6030: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6033: ldc_w 5556
    //   6036: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6039: pop
    //   6040: aload_0
    //   6041: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6044: invokevirtual 1285	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6047: aload_0
    //   6048: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6051: invokevirtual 1659	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   6054: iconst_0
    //   6055: invokevirtual 1291	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   6058: astore 7
    //   6060: aload 8
    //   6062: ldc_w 5558
    //   6065: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6068: aload 7
    //   6070: ldc_w 5560
    //   6073: fconst_0
    //   6074: invokeinterface 5564 3 0
    //   6079: invokevirtual 5567	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   6082: pop
    //   6083: aload 8
    //   6085: ldc_w 5569
    //   6088: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6091: aload 7
    //   6093: ldc_w 5571
    //   6096: fconst_0
    //   6097: invokeinterface 5564 3 0
    //   6102: invokevirtual 5567	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   6105: pop
    //   6106: aload_0
    //   6107: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6110: invokevirtual 1285	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6113: invokevirtual 5572	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   6116: invokestatic 5575	bbev:a	(Landroid/content/Context;)I
    //   6119: istore_1
    //   6120: aload 8
    //   6122: new 197	java/lang/StringBuilder
    //   6125: dup
    //   6126: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   6129: ldc_w 5577
    //   6132: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6135: iload_1
    //   6136: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6139: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6142: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6145: pop
    //   6146: invokestatic 5579	bbct:d	()Ljava/lang/String;
    //   6149: astore 7
    //   6151: aload 8
    //   6153: new 197	java/lang/StringBuilder
    //   6156: dup
    //   6157: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   6160: ldc_w 2313
    //   6163: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6166: aload 7
    //   6168: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6171: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6174: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6177: pop
    //   6178: new 106	android/content/Intent
    //   6181: dup
    //   6182: aload_0
    //   6183: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6186: ldc_w 378
    //   6189: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6192: astore 7
    //   6194: aload 7
    //   6196: ldc_w 391
    //   6199: aload 8
    //   6201: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6204: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6207: pop
    //   6208: aload 7
    //   6210: ldc_w 1214
    //   6213: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   6216: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   6219: pop
    //   6220: aload_0
    //   6221: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6224: aload 7
    //   6226: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   6229: iconst_1
    //   6230: ireturn
    //   6231: ldc_w 372
    //   6234: astore 7
    //   6236: goto -210 -> 6026
    //   6239: aload_0
    //   6240: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6243: ldc_w 5581
    //   6246: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6249: ifeq +21 -> 6270
    //   6252: aload_0
    //   6253: getfield 295	bbds:c	Ljava/lang/String;
    //   6256: ldc_w 5583
    //   6259: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6262: ifeq +8 -> 6270
    //   6265: aload_0
    //   6266: invokespecial 5585	bbds:be	()Z
    //   6269: ireturn
    //   6270: aload_0
    //   6271: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6274: ldc_w 5587
    //   6277: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6280: ifeq +21 -> 6301
    //   6283: aload_0
    //   6284: getfield 295	bbds:c	Ljava/lang/String;
    //   6287: ldc_w 3143
    //   6290: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6293: ifeq +8 -> 6301
    //   6296: aload_0
    //   6297: invokespecial 5589	bbds:bf	()Z
    //   6300: ireturn
    //   6301: ldc_w 3145
    //   6304: aload_0
    //   6305: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6308: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6311: ifeq +21 -> 6332
    //   6314: ldc_w 3143
    //   6317: aload_0
    //   6318: getfield 295	bbds:c	Ljava/lang/String;
    //   6321: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6324: ifeq +8 -> 6332
    //   6327: aload_0
    //   6328: invokespecial 5591	bbds:bg	()Z
    //   6331: ireturn
    //   6332: ldc_w 5593
    //   6335: aload_0
    //   6336: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6339: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6342: ifeq +21 -> 6363
    //   6345: ldc_w 3143
    //   6348: aload_0
    //   6349: getfield 295	bbds:c	Ljava/lang/String;
    //   6352: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6355: ifeq +8 -> 6363
    //   6358: aload_0
    //   6359: invokespecial 5595	bbds:bh	()Z
    //   6362: ireturn
    //   6363: aload_0
    //   6364: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6367: ldc_w 5597
    //   6370: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6373: ifeq +208 -> 6581
    //   6376: aload_0
    //   6377: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6380: ldc_w 4241
    //   6383: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6386: checkcast 50	java/lang/String
    //   6389: astore 7
    //   6391: aload_0
    //   6392: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6395: ldc_w 5599
    //   6398: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6401: checkcast 50	java/lang/String
    //   6404: astore 8
    //   6406: aload_0
    //   6407: getfield 295	bbds:c	Ljava/lang/String;
    //   6410: ldc_w 2035
    //   6413: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6416: ifeq +94 -> 6510
    //   6419: aload_0
    //   6420: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6423: ldc_w 391
    //   6426: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6429: checkcast 50	java/lang/String
    //   6432: astore 9
    //   6434: aload 9
    //   6436: invokestatic 1600	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   6439: astore 9
    //   6441: new 106	android/content/Intent
    //   6444: dup
    //   6445: aload_0
    //   6446: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6449: ldc_w 4667
    //   6452: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   6455: ldc_w 391
    //   6458: aload 9
    //   6460: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6463: astore 9
    //   6465: aload 9
    //   6467: ldc_w 653
    //   6470: aload_0
    //   6471: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6474: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6477: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   6480: pop
    //   6481: aload 9
    //   6483: ldc_w 5601
    //   6486: iconst_1
    //   6487: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6490: pop
    //   6491: aload 9
    //   6493: ldc_w 5603
    //   6496: iconst_1
    //   6497: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   6500: pop
    //   6501: aload_0
    //   6502: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6505: aload 9
    //   6507: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   6510: aload 7
    //   6512: ifnull +47 -> 6559
    //   6515: aload 8
    //   6517: ifnull +42 -> 6559
    //   6520: aload_0
    //   6521: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6524: ldc_w 3018
    //   6527: ldc_w 5605
    //   6530: ldc 61
    //   6532: ldc_w 391
    //   6535: ldc_w 5607
    //   6538: iconst_0
    //   6539: iconst_1
    //   6540: iconst_0
    //   6541: aload 7
    //   6543: aload 8
    //   6545: iconst_0
    //   6546: anewarray 50	java/lang/String
    //   6549: invokestatic 5610	nax:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   6552: ldc 61
    //   6554: ldc 61
    //   6556: invokestatic 5613	axqw:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   6559: iconst_1
    //   6560: ireturn
    //   6561: astore 7
    //   6563: invokestatic 529	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6566: ifeq +13 -> 6579
    //   6569: ldc_w 435
    //   6572: iconst_4
    //   6573: ldc_w 5615
    //   6576: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6579: iconst_0
    //   6580: ireturn
    //   6581: aload_0
    //   6582: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6585: ldc_w 4132
    //   6588: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6591: ifeq +21 -> 6612
    //   6594: aload_0
    //   6595: getfield 295	bbds:c	Ljava/lang/String;
    //   6598: ldc_w 5617
    //   6601: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6604: ifeq +8 -> 6612
    //   6607: aload_0
    //   6608: invokespecial 5619	bbds:af	()Z
    //   6611: ireturn
    //   6612: aload_0
    //   6613: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6616: ldc_w 5053
    //   6619: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6622: ifeq +21 -> 6643
    //   6625: aload_0
    //   6626: getfield 295	bbds:c	Ljava/lang/String;
    //   6629: ldc_w 5621
    //   6632: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6635: ifeq +8 -> 6643
    //   6638: aload_0
    //   6639: invokespecial 5623	bbds:ae	()Z
    //   6642: ireturn
    //   6643: aload_0
    //   6644: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6647: ldc_w 5625
    //   6650: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6653: ifeq +57 -> 6710
    //   6656: aload_0
    //   6657: getfield 295	bbds:c	Ljava/lang/String;
    //   6660: ldc_w 4173
    //   6663: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6666: ifeq +8 -> 6674
    //   6669: aload_0
    //   6670: invokespecial 5627	bbds:U	()Z
    //   6673: ireturn
    //   6674: aload_0
    //   6675: getfield 295	bbds:c	Ljava/lang/String;
    //   6678: ldc_w 297
    //   6681: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6684: ifeq +8 -> 6692
    //   6687: aload_0
    //   6688: invokespecial 5629	bbds:T	()Z
    //   6691: ireturn
    //   6692: aload_0
    //   6693: getfield 295	bbds:c	Ljava/lang/String;
    //   6696: ldc_w 5631
    //   6699: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6702: ifeq -2763 -> 3939
    //   6705: aload_0
    //   6706: invokespecial 5633	bbds:S	()Z
    //   6709: ireturn
    //   6710: aload_0
    //   6711: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6714: ldc_w 5635
    //   6717: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6720: ifeq +93 -> 6813
    //   6723: aload_0
    //   6724: getfield 295	bbds:c	Ljava/lang/String;
    //   6727: ldc_w 5637
    //   6730: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6733: ifeq +8 -> 6741
    //   6736: aload_0
    //   6737: invokespecial 5639	bbds:N	()Z
    //   6740: ireturn
    //   6741: aload_0
    //   6742: getfield 295	bbds:c	Ljava/lang/String;
    //   6745: ldc_w 5641
    //   6748: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6751: ifeq +8 -> 6759
    //   6754: aload_0
    //   6755: invokespecial 3262	bbds:aw	()Z
    //   6758: ireturn
    //   6759: aload_0
    //   6760: getfield 295	bbds:c	Ljava/lang/String;
    //   6763: ldc_w 5643
    //   6766: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6769: ifeq +8 -> 6777
    //   6772: aload_0
    //   6773: invokespecial 5645	bbds:P	()Z
    //   6776: ireturn
    //   6777: aload_0
    //   6778: getfield 295	bbds:c	Ljava/lang/String;
    //   6781: ldc_w 5647
    //   6784: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6787: ifeq +8 -> 6795
    //   6790: aload_0
    //   6791: invokespecial 5649	bbds:Q	()Z
    //   6794: ireturn
    //   6795: aload_0
    //   6796: getfield 295	bbds:c	Ljava/lang/String;
    //   6799: ldc_w 5651
    //   6802: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6805: ifeq -2866 -> 3939
    //   6808: aload_0
    //   6809: invokevirtual 5653	bbds:v	()Z
    //   6812: ireturn
    //   6813: aload_0
    //   6814: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6817: ldc_w 3259
    //   6820: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6823: ifeq +21 -> 6844
    //   6826: aload_0
    //   6827: getfield 295	bbds:c	Ljava/lang/String;
    //   6830: ldc_w 5655
    //   6833: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6836: ifeq -2897 -> 3939
    //   6839: aload_0
    //   6840: invokespecial 5657	bbds:bC	()Z
    //   6843: ireturn
    //   6844: aload_0
    //   6845: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6848: ldc_w 5659
    //   6851: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6854: ifeq +21 -> 6875
    //   6857: aload_0
    //   6858: getfield 295	bbds:c	Ljava/lang/String;
    //   6861: ldc_w 5661
    //   6864: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6867: ifeq -2928 -> 3939
    //   6870: aload_0
    //   6871: invokespecial 5663	bbds:R	()Z
    //   6874: ireturn
    //   6875: aload_0
    //   6876: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6879: ldc_w 5665
    //   6882: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6885: ifeq +58 -> 6943
    //   6888: aload_0
    //   6889: getfield 295	bbds:c	Ljava/lang/String;
    //   6892: ldc_w 5631
    //   6895: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6898: ifne -2959 -> 3939
    //   6901: aload_0
    //   6902: getfield 295	bbds:c	Ljava/lang/String;
    //   6905: ldc_w 4173
    //   6908: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6911: ifne -2972 -> 3939
    //   6914: aload_0
    //   6915: getfield 295	bbds:c	Ljava/lang/String;
    //   6918: ldc_w 5667
    //   6921: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6924: ifne -2985 -> 3939
    //   6927: aload_0
    //   6928: getfield 295	bbds:c	Ljava/lang/String;
    //   6931: ldc_w 5669
    //   6934: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6937: ifeq -2998 -> 3939
    //   6940: goto -3001 -> 3939
    //   6943: aload_0
    //   6944: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6947: ldc_w 5671
    //   6950: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6953: ifeq +21 -> 6974
    //   6956: aload_0
    //   6957: getfield 295	bbds:c	Ljava/lang/String;
    //   6960: ldc_w 5673
    //   6963: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6966: ifeq +8 -> 6974
    //   6969: aload_0
    //   6970: invokespecial 5675	bbds:bm	()Z
    //   6973: ireturn
    //   6974: aload_0
    //   6975: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6978: ldc_w 4291
    //   6981: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6984: ifeq +21 -> 7005
    //   6987: aload_0
    //   6988: getfield 295	bbds:c	Ljava/lang/String;
    //   6991: ldc_w 5677
    //   6994: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6997: ifeq +8 -> 7005
    //   7000: aload_0
    //   7001: invokespecial 5679	bbds:bp	()Z
    //   7004: ireturn
    //   7005: aload_0
    //   7006: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7009: ldc_w 5681
    //   7012: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7015: ifeq +21 -> 7036
    //   7018: aload_0
    //   7019: getfield 295	bbds:c	Ljava/lang/String;
    //   7022: ldc_w 391
    //   7025: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7028: ifeq +8 -> 7036
    //   7031: aload_0
    //   7032: invokespecial 5683	bbds:bq	()Z
    //   7035: ireturn
    //   7036: aload_0
    //   7037: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7040: ldc_w 5685
    //   7043: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7046: ifeq +21 -> 7067
    //   7049: aload_0
    //   7050: getfield 295	bbds:c	Ljava/lang/String;
    //   7053: ldc_w 391
    //   7056: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7059: ifeq +8 -> 7067
    //   7062: aload_0
    //   7063: invokespecial 5687	bbds:br	()Z
    //   7066: ireturn
    //   7067: aload_0
    //   7068: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7071: ldc_w 5689
    //   7074: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7077: ifeq +21 -> 7098
    //   7080: aload_0
    //   7081: getfield 295	bbds:c	Ljava/lang/String;
    //   7084: ldc_w 391
    //   7087: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7090: ifeq +8 -> 7098
    //   7093: aload_0
    //   7094: invokevirtual 5691	bbds:k	()Z
    //   7097: ireturn
    //   7098: ldc_w 5692
    //   7101: aload_0
    //   7102: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7105: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7108: ifeq +21 -> 7129
    //   7111: ldc_w 5694
    //   7114: aload_0
    //   7115: getfield 295	bbds:c	Ljava/lang/String;
    //   7118: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7121: ifeq +8 -> 7129
    //   7124: aload_0
    //   7125: invokespecial 5696	bbds:bs	()Z
    //   7128: ireturn
    //   7129: ldc_w 5698
    //   7132: aload_0
    //   7133: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7136: invokevirtual 2248	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   7139: ifeq +21 -> 7160
    //   7142: ldc_w 5700
    //   7145: aload_0
    //   7146: getfield 295	bbds:c	Ljava/lang/String;
    //   7149: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7152: ifeq +8 -> 7160
    //   7155: aload_0
    //   7156: invokevirtual 5702	bbds:l	()Z
    //   7159: ireturn
    //   7160: aload_0
    //   7161: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7164: ldc_w 5704
    //   7167: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7170: ifne -3231 -> 3939
    //   7173: aload_0
    //   7174: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7177: ldc_w 5706
    //   7180: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7183: ifeq +8 -> 7191
    //   7186: aload_0
    //   7187: invokespecial 5708	bbds:M	()Z
    //   7190: ireturn
    //   7191: aload_0
    //   7192: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7195: ldc_w 5710
    //   7198: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7201: ifeq +8 -> 7209
    //   7204: aload_0
    //   7205: invokespecial 5712	bbds:bi	()Z
    //   7208: ireturn
    //   7209: ldc_w 5714
    //   7212: aload_0
    //   7213: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7216: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7219: ifeq +21 -> 7240
    //   7222: ldc_w 5716
    //   7225: aload_0
    //   7226: getfield 295	bbds:c	Ljava/lang/String;
    //   7229: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7232: ifeq +8 -> 7240
    //   7235: aload_0
    //   7236: invokevirtual 5718	bbds:m	()Z
    //   7239: ireturn
    //   7240: aload_0
    //   7241: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7244: ldc_w 5720
    //   7247: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7250: ifeq +8 -> 7258
    //   7253: aload_0
    //   7254: invokevirtual 5722	bbds:n	()Z
    //   7257: ireturn
    //   7258: aload_0
    //   7259: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7262: ldc_w 5724
    //   7265: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7268: ifeq +8 -> 7276
    //   7271: aload_0
    //   7272: invokevirtual 5726	bbds:o	()Z
    //   7275: ireturn
    //   7276: aload_0
    //   7277: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7280: ldc_w 5728
    //   7283: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7286: ifeq +8 -> 7294
    //   7289: aload_0
    //   7290: invokespecial 5730	bbds:bt	()Z
    //   7293: ireturn
    //   7294: ldc_w 5732
    //   7297: aload_0
    //   7298: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7301: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7304: ifeq +8 -> 7312
    //   7307: aload_0
    //   7308: invokespecial 5734	bbds:bu	()Z
    //   7311: ireturn
    //   7312: ldc_w 5736
    //   7315: aload_0
    //   7316: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7319: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7322: ifeq +15 -> 7337
    //   7325: aload_0
    //   7326: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   7329: aload_0
    //   7330: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7333: invokestatic 5740	avdl:a	(Landroid/content/Context;Ljava/util/HashMap;)Z
    //   7336: ireturn
    //   7337: aload_0
    //   7338: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7341: ldc_w 5742
    //   7344: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7347: ifeq +843 -> 8190
    //   7350: aload_0
    //   7351: getfield 295	bbds:c	Ljava/lang/String;
    //   7354: ldc_w 306
    //   7357: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7360: ifeq +8 -> 7368
    //   7363: aload_0
    //   7364: invokevirtual 5744	bbds:p	()Z
    //   7367: ireturn
    //   7368: aload_0
    //   7369: getfield 295	bbds:c	Ljava/lang/String;
    //   7372: ldc_w 5319
    //   7375: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7378: ifeq +8 -> 7386
    //   7381: aload_0
    //   7382: invokevirtual 5746	bbds:q	()Z
    //   7385: ireturn
    //   7386: aload_0
    //   7387: getfield 295	bbds:c	Ljava/lang/String;
    //   7390: ldc_w 5748
    //   7393: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7396: ifeq +8 -> 7404
    //   7399: aload_0
    //   7400: invokevirtual 5750	bbds:r	()Z
    //   7403: ireturn
    //   7404: aload_0
    //   7405: getfield 295	bbds:c	Ljava/lang/String;
    //   7408: ldc_w 5752
    //   7411: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7414: ifeq +87 -> 7501
    //   7417: aload_0
    //   7418: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7421: ldc_w 5754
    //   7424: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7427: checkcast 50	java/lang/String
    //   7430: astore 7
    //   7432: aload_0
    //   7433: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7436: ldc_w 5756
    //   7439: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7442: checkcast 50	java/lang/String
    //   7445: invokestatic 226	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   7448: istore_1
    //   7449: aload 7
    //   7451: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7454: ifne -3515 -> 3939
    //   7457: new 106	android/content/Intent
    //   7460: dup
    //   7461: aload_0
    //   7462: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   7465: ldc_w 5758
    //   7468: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7471: astore 8
    //   7473: aload 8
    //   7475: ldc_w 5760
    //   7478: iload_1
    //   7479: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7482: pop
    //   7483: aload_0
    //   7484: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   7487: checkcast 745	android/app/Activity
    //   7490: aload 8
    //   7492: aload 7
    //   7494: invokestatic 5765	sox:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)Z
    //   7497: pop
    //   7498: goto -3559 -> 3939
    //   7501: aload_0
    //   7502: getfield 295	bbds:c	Ljava/lang/String;
    //   7505: ldc_w 5767
    //   7508: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7511: ifeq +8 -> 7519
    //   7514: aload_0
    //   7515: invokevirtual 5769	bbds:s	()Z
    //   7518: ireturn
    //   7519: aload_0
    //   7520: getfield 295	bbds:c	Ljava/lang/String;
    //   7523: ldc_w 5771
    //   7526: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7529: ifeq +555 -> 8084
    //   7532: aload_0
    //   7533: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7536: ldc_w 5773
    //   7539: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7542: ifeq +44 -> 7586
    //   7545: aload_0
    //   7546: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7549: ldc_w 5773
    //   7552: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7555: checkcast 50	java/lang/String
    //   7558: astore 7
    //   7560: aload 7
    //   7562: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7565: ifeq +28 -> 7593
    //   7568: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7571: ifeq +13 -> 7584
    //   7574: ldc_w 435
    //   7577: iconst_2
    //   7578: ldc_w 5775
    //   7581: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7584: iconst_0
    //   7585: ireturn
    //   7586: ldc 61
    //   7588: astore 7
    //   7590: goto -30 -> 7560
    //   7593: aload_0
    //   7594: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7597: ldc_w 5777
    //   7600: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7603: ifeq +377 -> 7980
    //   7606: aload_0
    //   7607: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7610: ldc_w 5777
    //   7613: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7616: checkcast 50	java/lang/String
    //   7619: astore 8
    //   7621: aload_0
    //   7622: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7625: ldc_w 2859
    //   7628: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7631: ifeq +357 -> 7988
    //   7634: aload_0
    //   7635: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7638: ldc_w 2859
    //   7641: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7644: checkcast 50	java/lang/String
    //   7647: astore 9
    //   7649: aload_0
    //   7650: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7653: ldc_w 5779
    //   7656: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7659: ifeq +337 -> 7996
    //   7662: aload_0
    //   7663: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7666: ldc_w 5779
    //   7669: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7672: checkcast 50	java/lang/String
    //   7675: astore 10
    //   7677: aload_0
    //   7678: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7681: ldc_w 5781
    //   7684: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7687: ifeq +317 -> 8004
    //   7690: aload_0
    //   7691: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7694: ldc_w 5781
    //   7697: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7700: checkcast 50	java/lang/String
    //   7703: astore 11
    //   7705: aload_0
    //   7706: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7709: ldc_w 5783
    //   7712: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7715: ifeq +292 -> 8007
    //   7718: aload_0
    //   7719: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7722: ldc_w 5783
    //   7725: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7728: checkcast 50	java/lang/String
    //   7731: astore 11
    //   7733: aload_0
    //   7734: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7737: ldc_w 5785
    //   7740: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7743: ifeq +271 -> 8014
    //   7746: aload_0
    //   7747: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7750: ldc_w 5785
    //   7753: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7756: checkcast 50	java/lang/String
    //   7759: astore 12
    //   7761: aload_0
    //   7762: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7765: ldc_w 5787
    //   7768: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7771: ifeq +250 -> 8021
    //   7774: aload_0
    //   7775: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7778: ldc_w 5787
    //   7781: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7784: checkcast 50	java/lang/String
    //   7787: astore 13
    //   7789: aload_0
    //   7790: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7793: ldc_w 5789
    //   7796: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7799: ifeq +225 -> 8024
    //   7802: aload_0
    //   7803: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7806: ldc_w 5789
    //   7809: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7812: checkcast 50	java/lang/String
    //   7815: astore 13
    //   7817: aload_0
    //   7818: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7821: ldc_w 5791
    //   7824: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7827: ifeq +204 -> 8031
    //   7830: aload_0
    //   7831: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   7834: ldc_w 5791
    //   7837: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7840: checkcast 50	java/lang/String
    //   7843: astore 14
    //   7845: aload 8
    //   7847: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   7850: invokevirtual 673	java/lang/Integer:intValue	()I
    //   7853: pop
    //   7854: aload 9
    //   7856: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   7859: invokevirtual 673	java/lang/Integer:intValue	()I
    //   7862: istore_1
    //   7863: aload 10
    //   7865: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   7868: invokevirtual 673	java/lang/Integer:intValue	()I
    //   7871: pop
    //   7872: iload_1
    //   7873: istore_2
    //   7874: invokestatic 5795	onk:a	()Lmqq/app/AppRuntime;
    //   7877: invokestatic 5798	bhvh:s	(Lmqq/app/AppRuntime;)Z
    //   7880: invokestatic 277	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   7883: invokevirtual 283	java/lang/Boolean:booleanValue	()Z
    //   7886: ifeq +179 -> 8065
    //   7889: new 197	java/lang/StringBuilder
    //   7892: dup
    //   7893: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   7896: ldc_w 5800
    //   7899: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7902: aload 7
    //   7904: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7907: ldc_w 5802
    //   7910: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7913: iload_2
    //   7914: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7917: ldc_w 5804
    //   7920: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7923: aload 14
    //   7925: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7928: ldc_w 5806
    //   7931: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7934: aload 11
    //   7936: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7939: ldc_w 5808
    //   7942: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7945: aload 12
    //   7947: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7950: ldc_w 5810
    //   7953: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7956: aload 13
    //   7958: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7961: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7964: astore 7
    //   7966: aload_0
    //   7967: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   7970: aconst_null
    //   7971: aload 7
    //   7973: aconst_null
    //   7974: invokestatic 5815	rwa:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   7977: goto -4038 -> 3939
    //   7980: ldc_w 372
    //   7983: astore 8
    //   7985: goto -364 -> 7621
    //   7988: ldc_w 372
    //   7991: astore 9
    //   7993: goto -344 -> 7649
    //   7996: ldc_w 372
    //   7999: astore 10
    //   8001: goto -324 -> 7677
    //   8004: goto -299 -> 7705
    //   8007: ldc 61
    //   8009: astore 11
    //   8011: goto -278 -> 7733
    //   8014: ldc 61
    //   8016: astore 12
    //   8018: goto -257 -> 7761
    //   8021: goto -232 -> 7789
    //   8024: ldc 61
    //   8026: astore 13
    //   8028: goto -211 -> 7817
    //   8031: ldc 61
    //   8033: astore 14
    //   8035: goto -190 -> 7845
    //   8038: astore 8
    //   8040: iconst_0
    //   8041: istore_1
    //   8042: iload_1
    //   8043: istore_2
    //   8044: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8047: ifeq -173 -> 7874
    //   8050: ldc_w 435
    //   8053: iconst_2
    //   8054: ldc_w 5817
    //   8057: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8060: iload_1
    //   8061: istore_2
    //   8062: goto -188 -> 7874
    //   8065: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8068: ifeq -4129 -> 3939
    //   8071: ldc_w 435
    //   8074: iconst_2
    //   8075: ldc_w 5819
    //   8078: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8081: goto -4142 -> 3939
    //   8084: aload_0
    //   8085: getfield 295	bbds:c	Ljava/lang/String;
    //   8088: ldc_w 5821
    //   8091: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8094: ifeq +13 -> 8107
    //   8097: aload_0
    //   8098: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8101: iconst_0
    //   8102: invokestatic 5824	nut:a	(Landroid/content/Context;Z)V
    //   8105: iconst_1
    //   8106: ireturn
    //   8107: ldc_w 5826
    //   8110: aload_0
    //   8111: getfield 295	bbds:c	Ljava/lang/String;
    //   8114: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8117: ifeq +10 -> 8127
    //   8120: aload_0
    //   8121: invokespecial 5828	bbds:f	()V
    //   8124: goto -4185 -> 3939
    //   8127: ldc_w 5830
    //   8130: aload_0
    //   8131: getfield 295	bbds:c	Ljava/lang/String;
    //   8134: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8137: ifeq -4198 -> 3939
    //   8140: aload_0
    //   8141: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8144: aload_0
    //   8145: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   8148: invokestatic 5833	nut:b	(Landroid/content/Context;Ljava/util/HashMap;)Landroid/content/Intent;
    //   8151: astore 7
    //   8153: aload_0
    //   8154: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8157: instanceof 5835
    //   8160: ifeq +18 -> 8178
    //   8163: aload_0
    //   8164: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8167: checkcast 5835	com/tencent/biz/pubaccount/readinjoy/view/fastweb/FastWebActivity
    //   8170: aload 7
    //   8172: invokevirtual 5836	com/tencent/biz/pubaccount/readinjoy/view/fastweb/FastWebActivity:a	(Landroid/content/Intent;)V
    //   8175: goto -4236 -> 3939
    //   8178: aload_0
    //   8179: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8182: aload 7
    //   8184: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   8187: goto -4248 -> 3939
    //   8190: aload_0
    //   8191: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8194: ldc_w 5411
    //   8197: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8200: ifeq +31 -> 8231
    //   8203: aload_0
    //   8204: getfield 295	bbds:c	Ljava/lang/String;
    //   8207: ldc_w 5838
    //   8210: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8213: ifeq +18 -> 8231
    //   8216: aload_0
    //   8217: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8220: invokestatic 5839	airz:a	(Landroid/content/Context;)Z
    //   8223: ifeq -4284 -> 3939
    //   8226: aload_0
    //   8227: invokevirtual 5841	bbds:u	()Z
    //   8230: ireturn
    //   8231: aload_0
    //   8232: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8235: ldc_w 5411
    //   8238: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8241: ifeq +25 -> 8266
    //   8244: aload_0
    //   8245: getfield 295	bbds:c	Ljava/lang/String;
    //   8248: ldc_w 5843
    //   8251: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8254: ifeq +12 -> 8266
    //   8257: aload_0
    //   8258: aload_0
    //   8259: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   8262: invokevirtual 5845	bbds:a	(Ljava/util/Map;)Z
    //   8265: ireturn
    //   8266: ldc_w 5847
    //   8269: aload_0
    //   8270: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8273: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8276: ifeq +68 -> 8344
    //   8279: ldc_w 5849
    //   8282: aload_0
    //   8283: getfield 295	bbds:c	Ljava/lang/String;
    //   8286: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8289: ifeq -4350 -> 3939
    //   8292: new 106	android/content/Intent
    //   8295: dup
    //   8296: invokespecial 395	android/content/Intent:<init>	()V
    //   8299: astore 7
    //   8301: aload 7
    //   8303: ldc_w 3609
    //   8306: invokestatic 126	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   8309: invokevirtual 4870	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   8312: ldc_w 4451
    //   8315: invokevirtual 2693	android/content/Context:getString	(I)Ljava/lang/String;
    //   8318: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8321: pop
    //   8322: aload_0
    //   8323: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8326: checkcast 745	android/app/Activity
    //   8329: aload_0
    //   8330: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8333: invokevirtual 1659	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   8336: aload 7
    //   8338: iconst_m1
    //   8339: iconst_0
    //   8340: invokestatic 4875	bgpf:a	(Landroid/app/Activity;Ljava/lang/String;Landroid/content/Intent;IZ)Z
    //   8343: ireturn
    //   8344: ldc_w 5851
    //   8347: aload_0
    //   8348: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8351: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8354: ifeq +21 -> 8375
    //   8357: ldc_w 5853
    //   8360: aload_0
    //   8361: getfield 295	bbds:c	Ljava/lang/String;
    //   8364: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8367: ifeq -4428 -> 3939
    //   8370: aload_0
    //   8371: invokespecial 5855	bbds:I	()Z
    //   8374: ireturn
    //   8375: ldc_w 5857
    //   8378: aload_0
    //   8379: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8382: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8385: ifeq +21 -> 8406
    //   8388: ldc_w 5859
    //   8391: aload_0
    //   8392: getfield 295	bbds:c	Ljava/lang/String;
    //   8395: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8398: ifeq -4459 -> 3939
    //   8401: aload_0
    //   8402: invokespecial 5861	bbds:L	()Z
    //   8405: ireturn
    //   8406: ldc_w 5863
    //   8409: aload_0
    //   8410: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8413: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8416: ifeq +13 -> 8429
    //   8419: aload_0
    //   8420: iconst_1
    //   8421: putfield 5865	bbds:jdField_e_of_type_Boolean	Z
    //   8424: aload_0
    //   8425: invokestatic 5869	lyn:a	(Lbbds;)Z
    //   8428: ireturn
    //   8429: ldc_w 5871
    //   8432: aload_0
    //   8433: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8436: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8439: ifeq +21 -> 8460
    //   8442: ldc_w 5873
    //   8445: aload_0
    //   8446: getfield 295	bbds:c	Ljava/lang/String;
    //   8449: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8452: ifeq -4513 -> 3939
    //   8455: aload_0
    //   8456: invokevirtual 5875	bbds:t	()Z
    //   8459: ireturn
    //   8460: aload_0
    //   8461: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8464: ldc_w 5877
    //   8467: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8470: ifne +29 -> 8499
    //   8473: aload_0
    //   8474: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8477: ldc_w 5879
    //   8480: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8483: ifne +16 -> 8499
    //   8486: aload_0
    //   8487: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8490: ldc_w 5881
    //   8493: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8496: ifeq +21 -> 8517
    //   8499: aload_0
    //   8500: getfield 295	bbds:c	Ljava/lang/String;
    //   8503: ldc_w 5309
    //   8506: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8509: ifeq -4570 -> 3939
    //   8512: aload_0
    //   8513: invokevirtual 5883	bbds:w	()Z
    //   8516: ireturn
    //   8517: ldc_w 5885
    //   8520: aload_0
    //   8521: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8524: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8527: ifne -4588 -> 3939
    //   8530: ldc_w 5887
    //   8533: aload_0
    //   8534: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8537: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8540: ifeq +21 -> 8561
    //   8543: ldc_w 5889
    //   8546: aload_0
    //   8547: getfield 295	bbds:c	Ljava/lang/String;
    //   8550: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8553: ifeq -4614 -> 3939
    //   8556: aload_0
    //   8557: invokespecial 5891	bbds:H	()Z
    //   8560: ireturn
    //   8561: ldc_w 5893
    //   8564: aload_0
    //   8565: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8568: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8571: ifeq +26 -> 8597
    //   8574: ldc_w 5895
    //   8577: aload_0
    //   8578: getfield 295	bbds:c	Ljava/lang/String;
    //   8581: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8584: ifeq +8 -> 8592
    //   8587: aload_0
    //   8588: invokevirtual 5898	bbds:x	()Z
    //   8591: ireturn
    //   8592: aload_0
    //   8593: invokespecial 2231	bbds:F	()Z
    //   8596: ireturn
    //   8597: ldc_w 5900
    //   8600: aload_0
    //   8601: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8604: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8607: ifeq -4668 -> 3939
    //   8610: ldc_w 5902
    //   8613: aload_0
    //   8614: getfield 295	bbds:c	Ljava/lang/String;
    //   8617: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8620: ifeq +8 -> 8628
    //   8623: aload_0
    //   8624: invokevirtual 5898	bbds:x	()Z
    //   8627: ireturn
    //   8628: ldc_w 5904
    //   8631: aload_0
    //   8632: getfield 295	bbds:c	Ljava/lang/String;
    //   8635: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8638: ifeq -4699 -> 3939
    //   8641: aload_0
    //   8642: invokevirtual 5906	bbds:d	()Z
    //   8645: ireturn
    //   8646: aload_0
    //   8647: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8650: ldc_w 5468
    //   8653: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8656: ifeq +21 -> 8677
    //   8659: aload_0
    //   8660: getfield 295	bbds:c	Ljava/lang/String;
    //   8663: ldc_w 5907
    //   8666: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8669: ifeq +8 -> 8677
    //   8672: aload_0
    //   8673: invokevirtual 5910	bbds:y	()Z
    //   8676: ireturn
    //   8677: aload_0
    //   8678: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8681: ldc_w 5442
    //   8684: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8687: ifeq +21 -> 8708
    //   8690: aload_0
    //   8691: getfield 295	bbds:c	Ljava/lang/String;
    //   8694: ldc_w 5912
    //   8697: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8700: ifeq +8 -> 8708
    //   8703: aload_0
    //   8704: invokevirtual 5915	bbds:z	()Z
    //   8707: ireturn
    //   8708: aload_0
    //   8709: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8712: ldc_w 5917
    //   8715: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8718: ifeq +8 -> 8726
    //   8721: aload_0
    //   8722: invokespecial 5919	bbds:bA	()Z
    //   8725: ireturn
    //   8726: aload_0
    //   8727: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8730: ldc_w 5921
    //   8733: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8736: ifeq +21 -> 8757
    //   8739: aload_0
    //   8740: getfield 295	bbds:c	Ljava/lang/String;
    //   8743: ldc_w 5923
    //   8746: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8749: ifeq +8 -> 8757
    //   8752: aload_0
    //   8753: invokespecial 5925	bbds:O	()Z
    //   8756: ireturn
    //   8757: aload_0
    //   8758: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8761: ldc_w 5927
    //   8764: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8767: ifeq +39 -> 8806
    //   8770: aload_0
    //   8771: getfield 295	bbds:c	Ljava/lang/String;
    //   8774: ldc_w 5929
    //   8777: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8780: ifeq +8 -> 8788
    //   8783: aload_0
    //   8784: invokespecial 5931	bbds:D	()Z
    //   8787: ireturn
    //   8788: aload_0
    //   8789: getfield 295	bbds:c	Ljava/lang/String;
    //   8792: ldc_w 5933
    //   8795: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8798: ifeq +244 -> 9042
    //   8801: aload_0
    //   8802: invokespecial 5935	bbds:E	()Z
    //   8805: ireturn
    //   8806: aload_0
    //   8807: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8810: ldc_w 5937
    //   8813: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8816: ifeq +39 -> 8855
    //   8819: aload_0
    //   8820: getfield 295	bbds:c	Ljava/lang/String;
    //   8823: ldc_w 5902
    //   8826: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8829: ifeq +8 -> 8837
    //   8832: aload_0
    //   8833: invokespecial 5939	bbds:bD	()Z
    //   8836: ireturn
    //   8837: aload_0
    //   8838: getfield 295	bbds:c	Ljava/lang/String;
    //   8841: ldc_w 5941
    //   8844: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8847: ifeq +195 -> 9042
    //   8850: aload_0
    //   8851: invokespecial 5943	bbds:bE	()Z
    //   8854: ireturn
    //   8855: aload_0
    //   8856: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8859: ldc_w 5945
    //   8862: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8865: ifeq +21 -> 8886
    //   8868: aload_0
    //   8869: getfield 295	bbds:c	Ljava/lang/String;
    //   8872: ldc_w 306
    //   8875: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8878: ifeq +164 -> 9042
    //   8881: aload_0
    //   8882: invokevirtual 5947	bbds:A	()Z
    //   8885: ireturn
    //   8886: ldc_w 5949
    //   8889: aload_0
    //   8890: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8893: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8896: ifeq +27 -> 8923
    //   8899: ldc_w 297
    //   8902: aload_0
    //   8903: getfield 295	bbds:c	Ljava/lang/String;
    //   8906: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8909: ifeq +14 -> 8923
    //   8912: aload_0
    //   8913: aload_0
    //   8914: ldc 232
    //   8916: invokevirtual 829	bbds:b	(Ljava/lang/String;)Ljava/lang/String;
    //   8919: invokevirtual 5950	bbds:b	(Ljava/lang/String;)Z
    //   8922: ireturn
    //   8923: aload_0
    //   8924: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   8927: ldc_w 5952
    //   8930: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8933: ifeq +79 -> 9012
    //   8936: aload_0
    //   8937: getfield 295	bbds:c	Ljava/lang/String;
    //   8940: ldc_w 5954
    //   8943: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8946: ifeq +66 -> 9012
    //   8949: aload_0
    //   8950: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8953: instanceof 745
    //   8956: ifeq +44 -> 9000
    //   8959: aload_0
    //   8960: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8963: sipush 224
    //   8966: invokevirtual 348	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   8969: checkcast 5956	bahs
    //   8972: astore 7
    //   8974: aload_0
    //   8975: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8978: aload_0
    //   8979: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8982: checkcast 745	android/app/Activity
    //   8985: aconst_null
    //   8986: aload 7
    //   8988: invokevirtual 5957	bahs:a	()Ljava/lang/String;
    //   8991: aconst_null
    //   8992: ldc_w 5958
    //   8995: invokestatic 5963	cooperation/troop/NearbyVideoChatProxyActivity:a	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;Ltencent/im/oidb/cmd0x8dd/oidb_0x8dd$SelfInfo;I)V
    //   8998: iconst_1
    //   8999: ireturn
    //   9000: ldc_w 435
    //   9003: iconst_1
    //   9004: ldc_w 5965
    //   9007: invokestatic 439	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9010: iconst_0
    //   9011: ireturn
    //   9012: ldc_w 5967
    //   9015: aload_0
    //   9016: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9019: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9022: ifeq +22 -> 9044
    //   9025: ldc_w 306
    //   9028: aload_0
    //   9029: getfield 295	bbds:c	Ljava/lang/String;
    //   9032: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9035: ifeq +7 -> 9042
    //   9038: aload_0
    //   9039: invokespecial 5969	bbds:e	()V
    //   9042: iconst_0
    //   9043: ireturn
    //   9044: ldc_w 5971
    //   9047: aload_0
    //   9048: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9051: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9054: ifeq +10 -> 9064
    //   9057: aload_0
    //   9058: invokespecial 5973	bbds:J	()Z
    //   9061: pop
    //   9062: iconst_1
    //   9063: ireturn
    //   9064: ldc_w 5975
    //   9067: aload_0
    //   9068: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9071: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9074: ifeq +10 -> 9084
    //   9077: aload_0
    //   9078: invokespecial 5977	bbds:K	()Z
    //   9081: pop
    //   9082: iconst_1
    //   9083: ireturn
    //   9084: ldc_w 5979
    //   9087: aload_0
    //   9088: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9091: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9094: ifeq +21 -> 9115
    //   9097: aload_0
    //   9098: getfield 295	bbds:c	Ljava/lang/String;
    //   9101: ldc_w 5902
    //   9104: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9107: ifeq -65 -> 9042
    //   9110: aload_0
    //   9111: invokespecial 5981	bbds:bH	()Z
    //   9114: ireturn
    //   9115: ldc_w 5983
    //   9118: aload_0
    //   9119: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9122: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9125: ifeq +51 -> 9176
    //   9128: aload_0
    //   9129: getfield 295	bbds:c	Ljava/lang/String;
    //   9132: ldc_w 306
    //   9135: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9138: ifeq +36 -> 9174
    //   9141: aload_0
    //   9142: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   9145: ldc_w 3701
    //   9148: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9151: checkcast 50	java/lang/String
    //   9154: astore 7
    //   9156: aload 7
    //   9158: ifnull +16 -> 9174
    //   9161: aload_0
    //   9162: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9165: aload_0
    //   9166: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9169: aload 7
    //   9171: invokestatic 5986	bamn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)V
    //   9174: iconst_1
    //   9175: ireturn
    //   9176: ldc_w 5988
    //   9179: aload_0
    //   9180: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9183: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9186: ifeq +51 -> 9237
    //   9189: aload_0
    //   9190: getfield 295	bbds:c	Ljava/lang/String;
    //   9193: ldc_w 306
    //   9196: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9199: ifeq +36 -> 9235
    //   9202: aload_0
    //   9203: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   9206: ldc_w 3701
    //   9209: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9212: checkcast 50	java/lang/String
    //   9215: astore 7
    //   9217: aload 7
    //   9219: ifnull +16 -> 9235
    //   9222: aload_0
    //   9223: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9226: aload_0
    //   9227: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9230: aload 7
    //   9232: invokestatic 5990	bamn:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/lang/String;)V
    //   9235: iconst_1
    //   9236: ireturn
    //   9237: ldc_w 5992
    //   9240: aload_0
    //   9241: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9244: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9247: ifeq +17 -> 9264
    //   9250: aload_0
    //   9251: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9254: ldc_w 5994
    //   9257: iconst_1
    //   9258: iconst_1
    //   9259: invokestatic 5140	sjs:a	(Landroid/content/Context;Ljava/lang/String;IZ)V
    //   9262: iconst_1
    //   9263: ireturn
    //   9264: ldc_w 5996
    //   9267: aload_0
    //   9268: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9271: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9274: ifeq +73 -> 9347
    //   9277: new 106	android/content/Intent
    //   9280: dup
    //   9281: aload_0
    //   9282: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9285: ldc_w 5998
    //   9288: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   9291: astore 7
    //   9293: aload 7
    //   9295: ldc_w 713
    //   9298: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   9301: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   9304: pop
    //   9305: aload 7
    //   9307: ldc_w 6000
    //   9310: iconst_0
    //   9311: invokevirtual 526	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   9314: pop
    //   9315: aload 7
    //   9317: ldc_w 721
    //   9320: iconst_1
    //   9321: invokevirtual 250	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9324: pop
    //   9325: aload 7
    //   9327: ldc_w 6002
    //   9330: ldc 61
    //   9332: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9335: pop
    //   9336: aload_0
    //   9337: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9340: aload 7
    //   9342: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   9345: iconst_1
    //   9346: ireturn
    //   9347: ldc_w 6004
    //   9350: aload_0
    //   9351: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9354: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9357: ifeq +15 -> 9372
    //   9360: aload_0
    //   9361: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9364: ldc_w 6006
    //   9367: invokestatic 6008	com/tencent/mobileqq/activity/PublicFragmentActivity:a	(Landroid/content/Context;Ljava/lang/Class;)V
    //   9370: iconst_1
    //   9371: ireturn
    //   9372: ldc_w 6010
    //   9375: aload_0
    //   9376: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9379: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9382: ifeq +26 -> 9408
    //   9385: aload_0
    //   9386: ldc_w 6012
    //   9389: invokevirtual 829	bbds:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9392: astore 7
    //   9394: aload_0
    //   9395: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9398: aload 7
    //   9400: sipush 10004
    //   9403: invokestatic 6017	com/tencent/mobileqq/search/activity/UniteSearchActivity:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   9406: iconst_1
    //   9407: ireturn
    //   9408: ldc_w 6019
    //   9411: aload_0
    //   9412: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9415: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9418: ifeq +30 -> 9448
    //   9421: new 106	android/content/Intent
    //   9424: dup
    //   9425: aload_0
    //   9426: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9429: ldc_w 6021
    //   9432: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   9435: astore 7
    //   9437: aload_0
    //   9438: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9441: aload 7
    //   9443: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   9446: iconst_1
    //   9447: ireturn
    //   9448: ldc_w 6023
    //   9451: aload_0
    //   9452: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9455: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9458: ifeq +111 -> 9569
    //   9461: aload_0
    //   9462: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9465: sipush 269
    //   9468: invokevirtual 348	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9471: checkcast 6025	amno
    //   9474: invokevirtual 6028	amno:b	()Lamnk;
    //   9477: astore 9
    //   9479: ldc_w 6030
    //   9482: astore 8
    //   9484: aload 8
    //   9486: astore 7
    //   9488: aload 9
    //   9490: ifnull +25 -> 9515
    //   9493: aload 8
    //   9495: astore 7
    //   9497: aload 9
    //   9499: getfield 6033	amnk:l	Ljava/lang/String;
    //   9502: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9505: ifne +10 -> 9515
    //   9508: aload 9
    //   9510: getfield 6033	amnk:l	Ljava/lang/String;
    //   9513: astore 7
    //   9515: new 106	android/content/Intent
    //   9518: dup
    //   9519: aload_0
    //   9520: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9523: ldc_w 378
    //   9526: invokespecial 111	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   9529: astore 8
    //   9531: aload 8
    //   9533: ldc_w 653
    //   9536: aload_0
    //   9537: getfield 97	bbds:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9540: invokevirtual 935	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   9543: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9546: pop
    //   9547: aload 8
    //   9549: ldc_w 391
    //   9552: aload 7
    //   9554: invokevirtual 260	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9557: pop
    //   9558: aload_0
    //   9559: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9562: aload 8
    //   9564: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   9567: iconst_1
    //   9568: ireturn
    //   9569: ldc_w 6035
    //   9572: aload_0
    //   9573: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9576: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9579: ifeq +28 -> 9607
    //   9582: aload_0
    //   9583: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9586: instanceof 2837
    //   9589: ifeq +16 -> 9605
    //   9592: aload_0
    //   9593: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9596: checkcast 2837	com/tencent/mobileqq/app/BaseActivity
    //   9599: lconst_0
    //   9600: lconst_0
    //   9601: iconst_0
    //   9602: invokestatic 6040	ahok:a	(Lcom/tencent/mobileqq/app/BaseActivity;JJI)V
    //   9605: iconst_1
    //   9606: ireturn
    //   9607: ldc_w 6042
    //   9610: aload_0
    //   9611: getfield 4163	bbds:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9614: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9617: ifeq -575 -> 9042
    //   9620: ldc_w 6044
    //   9623: aload_0
    //   9624: getfield 295	bbds:c	Ljava/lang/String;
    //   9627: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9630: ifeq +9 -> 9639
    //   9633: aload_0
    //   9634: invokespecial 6046	bbds:d	()V
    //   9637: iconst_1
    //   9638: ireturn
    //   9639: iconst_0
    //   9640: ireturn
    //   9641: astore 8
    //   9643: goto -1601 -> 8042
    //   9646: astore 8
    //   9648: lload 5
    //   9650: lstore_3
    //   9651: goto -7614 -> 2037
    //   9654: astore 8
    //   9656: goto -7619 -> 2037
    //   9659: astore 9
    //   9661: goto -8282 -> 1379
    //   9664: astore 8
    //   9666: goto -9003 -> 663
    //   9669: astore 7
    //   9671: goto -9640 -> 31
    //   9674: iconst_0
    //   9675: istore_1
    //   9676: iconst_0
    //   9677: istore_2
    //   9678: aconst_null
    //   9679: astore 7
    //   9681: goto -4833 -> 4848
    //   9684: aload 11
    //   9686: astore 7
    //   9688: goto -8470 -> 1218
    //   9691: ldc 61
    //   9693: astore 8
    //   9695: aload 9
    //   9697: astore 7
    //   9699: aload 10
    //   9701: astore 9
    //   9703: goto -8774 -> 929
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	9706	0	this	bbds
    //   20	9656	1	i1	int
    //   28	9650	2	i2	int
    //   2007	7644	3	l1	long
    //   2003	7646	5	l2	long
    //   61	1360	7	localObject1	Object
    //   1439	26	7	localException1	Exception
    //   1481	26	7	localException2	Exception
    //   1747	798	7	localObject2	Object
    //   2580	26	7	localException3	Exception
    //   2718	3824	7	localObject3	Object
    //   6561	1	7	localException4	Exception
    //   7430	2123	7	localObject4	Object
    //   9669	1	7	localNumberFormatException	NumberFormatException
    //   9679	19	7	localObject5	Object
    //   254	7730	8	localObject6	Object
    //   8038	1	8	localException5	Exception
    //   9482	81	8	localObject7	Object
    //   9641	1	8	localException6	Exception
    //   9646	1	8	localException7	Exception
    //   9654	1	8	localException8	Exception
    //   9664	1	8	localException9	Exception
    //   9693	1	8	str1	String
    //   219	905	9	localObject8	Object
    //   1373	888	9	localException10	Exception
    //   2699	6810	9	localObject9	Object
    //   9659	37	9	localException11	Exception
    //   9701	1	9	localObject10	Object
    //   277	9423	10	localObject11	Object
    //   806	8879	11	str2	String
    //   834	7183	12	localObject12	Object
    //   776	7251	13	str3	String
    //   761	7273	14	str4	String
    //   791	263	15	str5	String
    //   821	279	16	str6	String
    //   860	56	17	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   1128	1197	1373	java/lang/Exception
    //   1197	1206	1373	java/lang/Exception
    //   1206	1213	1373	java/lang/Exception
    //   1301	1361	1373	java/lang/Exception
    //   1361	1370	1373	java/lang/Exception
    //   1427	1436	1373	java/lang/Exception
    //   1239	1249	1439	java/lang/Exception
    //   1257	1270	1481	java/lang/Exception
    //   2389	2447	2580	java/lang/Exception
    //   2447	2468	2580	java/lang/Exception
    //   2473	2488	2580	java/lang/Exception
    //   6434	6510	6561	java/lang/Exception
    //   7845	7863	8038	java/lang/Exception
    //   7863	7872	9641	java/lang/Exception
    //   2016	2025	9646	java/lang/Exception
    //   2025	2037	9654	java/lang/Exception
    //   1218	1227	9659	java/lang/Exception
    //   647	663	9664	java/lang/Exception
    //   21	29	9669	java/lang/NumberFormatException
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
    Object localObject = (axch)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if ((localObject != null) && ((((axch)localObject).a(2) > 0) || (((axch)localObject).a(1) > 0))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("newflag", bool);
      ((Intent)localObject).putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.a((Intent)localObject, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      ((Intent)localObject).addFlags(805306368);
      String str = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("push_trans_channel");
      bgxy.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (Intent)localObject, str, -1);
      LpReportInfo_dc02880.report(this.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    String str = a(a(a(a(a(a(QzoneConfig.getInstance().getConfig("H5Url", "PersonalQzoneVisitor", "https://h5.qzone.qq.com/visitor/qzone/personal?uin={uin}&qua={qua}&clicktime={clicktime}&_bid=329&_wv=3&_proxy=true"), "{hostUin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "{clicktime}", String.valueOf(System.currentTimeMillis())), "{from}", "androidQQ"), "{qua}", bgxr.a()), "{uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "{UIN}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.putExtra("articalChannelId", 5);
    if (bcde.jdField_a_of_type_JavaUtilHashMap.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131717943));
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
    ymx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, (String)localObject, localBundle);
    return true;
  }
  
  public boolean l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "gotoSendBless");
    }
    afaz localafaz = (afaz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(138);
    if (localafaz.a()) {
      localafaz.a(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      return true;
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 0, ajyc.a(2131705900), 0).a();
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
      int i1 = sgj.a(Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("account_flag")));
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
      localObject = (ajvr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    } while (localObject == null);
    ((ajvr)localObject).a(SystemClock.uptimeMillis());
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
        ((arju)((QQAppInterface)localObject5).getManager(108)).a(this.jdField_a_of_type_AndroidContentContext, l1, "launcher", (String)localObject1, (String)localObject3, i1);
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
        noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067C6", "0X80067C6", 0, 0, "", "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", false);
      }
      if ("webview".equals(this.m)) {
        wxu.a().f((String)localObject1);
      }
      for (;;)
      {
        return true;
        if (bhvh.k())
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
            localObject1 = nut.a(this.jdField_a_of_type_AndroidContentContext, i1);
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          }
          catch (Exception localException1) {}
          if (QLog.isColorLevel()) {
            QLog.e("JumpAction", 1, "jump activity error1 ", localException1);
          }
        }
        else if (bhvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          nut.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 2, 0);
        }
        else
        {
          nut.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, 2);
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
        break label1411;
      }
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131699643);
    }
    label1411:
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
                wxu.a().k();
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
                if (bhvh.k())
                {
                  nut.a(this.jdField_a_of_type_AndroidContentContext, i2, (String)localObject2, i3, 4);
                  break;
                }
                nut.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 4, 1);
                break;
              }
              nut.b(this.jdField_a_of_type_AndroidContentContext, i2, (String)localObject2, i3, 4);
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
              break label925;
            }
            i1 = Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("from")).intValue();
            if (!bhvh.i()) {
              break label884;
            }
            try
            {
              localObject2 = nut.a(this.jdField_a_of_type_AndroidContentContext, i1);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            }
            catch (Exception localException2) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("JumpAction", 1, "jump activity error1 ", localException2);
          break;
          label884:
          if (bhvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            nut.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, 0);
            break;
          }
          nut.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, i1);
          break;
          label925:
          Object localObject3;
          if ("3".equals(str5))
          {
            localObject3 = nut.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
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
            nut.a((Context)localObject3, this.jdField_a_of_type_JavaUtilHashMap);
            break;
          }
          if ("5".equals(str5))
          {
            nut.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
            break;
          }
          if (!"6".equals(str5)) {
            break label1157;
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
            rwa.a(this.jdField_a_of_type_AndroidContentContext, "", (String)localObject3, null);
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            QLog.w("JumpAction", 1, "[gotoReadInJoyFromSourceTarget] openViolaPage, v_url error->" + localException3.getMessage());
          }
        }
        break;
        label1157:
        if ("7".equals(str5))
        {
          nut.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
          break;
        }
        if ("8".equals(str5))
        {
          if ("webview".equals(this.m))
          {
            wxu.a().g(this.m);
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
              localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131699643);
            }
            if (!bhvh.k()) {
              break label1348;
            }
            try
            {
              Intent localIntent1 = nut.a(this.jdField_a_of_type_AndroidContentContext, 12);
              this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
            }
            catch (Exception localException4) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("JumpAction", 1, "jump activity error1 ", localException4);
          break;
          label1348:
          Intent localIntent2 = new Intent("android.intent.action.MAIN");
          localIntent2.putExtra("channel_id", i1);
          localIntent2.putExtra("channel_name", (String)localObject4);
          localIntent2.putExtra("readinjoy_launch_source", 7);
          bhvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localIntent2);
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
            axqw.b(null, str3, str4, str5, str1, str2, i1, i2, str6, str8, str9, str10);
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
      bhvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, i2, i3);
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
    //   11: ldc_w 6360
    //   14: aload_0
    //   15: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   18: ldc_w 1565
    //   21: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 50	java/lang/String
    //   27: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload 5
    //   35: ldc_w 6362
    //   38: aload_0
    //   39: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   42: ldc_w 1738
    //   45: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast 50	java/lang/String
    //   51: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   54: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 5
    //   59: ldc_w 6364
    //   62: aload_0
    //   63: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   66: ldc_w 6366
    //   69: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 50	java/lang/String
    //   75: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 5
    //   80: ldc_w 6368
    //   83: aload_0
    //   84: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   87: ldc_w 6370
    //   90: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast 50	java/lang/String
    //   96: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 5
    //   101: ldc_w 6372
    //   104: aload_0
    //   105: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   108: ldc_w 6374
    //   111: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: checkcast 50	java/lang/String
    //   117: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 5
    //   122: ldc_w 6376
    //   125: aload_0
    //   126: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   129: ldc_w 6378
    //   132: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 50	java/lang/String
    //   138: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 5
    //   143: ldc_w 6380
    //   146: aload_0
    //   147: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   150: ldc_w 6382
    //   153: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: checkcast 50	java/lang/String
    //   159: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload 5
    //   164: ldc_w 6384
    //   167: iconst_0
    //   168: invokevirtual 597	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   171: aload 5
    //   173: ldc_w 6386
    //   176: ldc_w 657
    //   179: aload_0
    //   180: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   183: ldc_w 6388
    //   186: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   189: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   192: invokevirtual 597	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   195: aload 5
    //   197: ldc_w 6390
    //   200: aload_0
    //   201: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   204: ldc_w 6392
    //   207: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: checkcast 50	java/lang/String
    //   213: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   216: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   223: ldc_w 6394
    //   226: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   229: checkcast 989	java/lang/CharSequence
    //   232: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne +40 -> 275
    //   238: aload 5
    //   240: ldc_w 6396
    //   243: new 6398	java/math/BigInteger
    //   246: dup
    //   247: aload_0
    //   248: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   251: ldc_w 6394
    //   254: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   257: checkcast 50	java/lang/String
    //   260: invokespecial 6399	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   263: invokevirtual 6400	java/math/BigInteger:longValue	()J
    //   266: invokestatic 696	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: invokevirtual 583	java/lang/Long:longValue	()J
    //   272: invokevirtual 593	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   275: aload_0
    //   276: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   279: ldc_w 6402
    //   282: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   285: checkcast 989	java/lang/CharSequence
    //   288: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   291: ifne +30 -> 321
    //   294: aload 5
    //   296: ldc_w 6404
    //   299: aload_0
    //   300: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   303: ldc_w 6402
    //   306: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   309: checkcast 50	java/lang/String
    //   312: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   315: invokevirtual 673	java/lang/Integer:intValue	()I
    //   318: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   321: aload_0
    //   322: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   325: ldc_w 6406
    //   328: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   331: checkcast 989	java/lang/CharSequence
    //   334: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   337: ifne +24 -> 361
    //   340: aload 5
    //   342: ldc_w 6408
    //   345: aload_0
    //   346: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   349: ldc_w 6406
    //   352: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   355: checkcast 50	java/lang/String
    //   358: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload_0
    //   362: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   365: ldc_w 6410
    //   368: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: checkcast 50	java/lang/String
    //   374: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   377: ifne +1387 -> 1764
    //   380: aload 5
    //   382: ldc_w 6412
    //   385: aload_0
    //   386: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   389: ldc_w 6410
    //   392: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   395: checkcast 50	java/lang/String
    //   398: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   401: invokevirtual 673	java/lang/Integer:intValue	()I
    //   404: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   407: aload_0
    //   408: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   411: ldc_w 6414
    //   414: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   417: checkcast 50	java/lang/String
    //   420: astore 4
    //   422: aload 4
    //   424: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   427: ifne +19 -> 446
    //   430: aload 5
    //   432: ldc_w 6416
    //   435: aload 4
    //   437: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   440: invokevirtual 673	java/lang/Integer:intValue	()I
    //   443: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   446: aload 5
    //   448: ldc_w 6418
    //   451: aload_0
    //   452: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   455: ldc_w 6420
    //   458: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   461: checkcast 50	java/lang/String
    //   464: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload 5
    //   472: ldc_w 6422
    //   475: aload_0
    //   476: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   479: ldc_w 6424
    //   482: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   485: checkcast 50	java/lang/String
    //   488: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   491: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload_0
    //   495: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   498: ldc_w 6426
    //   501: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   504: checkcast 50	java/lang/String
    //   507: astore 4
    //   509: aload 4
    //   511: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   514: ifne +19 -> 533
    //   517: aload 5
    //   519: ldc_w 6426
    //   522: aload 4
    //   524: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   527: invokevirtual 673	java/lang/Integer:intValue	()I
    //   530: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   533: aload_0
    //   534: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   537: ldc_w 6428
    //   540: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   543: checkcast 50	java/lang/String
    //   546: astore 4
    //   548: aload 4
    //   550: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   553: ifne +19 -> 572
    //   556: aload 5
    //   558: ldc_w 6428
    //   561: aload 4
    //   563: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   566: invokevirtual 673	java/lang/Integer:intValue	()I
    //   569: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   572: aload_0
    //   573: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   576: ldc_w 6430
    //   579: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   582: checkcast 50	java/lang/String
    //   585: astore 4
    //   587: aload 4
    //   589: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   592: ifne +19 -> 611
    //   595: aload 5
    //   597: ldc_w 6430
    //   600: aload 4
    //   602: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   605: invokevirtual 673	java/lang/Integer:intValue	()I
    //   608: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   611: aload_0
    //   612: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   615: ldc_w 6432
    //   618: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   621: checkcast 50	java/lang/String
    //   624: astore 4
    //   626: aload 4
    //   628: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   631: ifne +19 -> 650
    //   634: aload 5
    //   636: ldc_w 6432
    //   639: aload 4
    //   641: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   644: invokevirtual 673	java/lang/Integer:intValue	()I
    //   647: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   650: aload_0
    //   651: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   654: ldc_w 5783
    //   657: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   660: checkcast 50	java/lang/String
    //   663: astore 4
    //   665: aload 4
    //   667: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   670: ifne +116 -> 786
    //   673: aload_0
    //   674: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   677: ldc_w 5785
    //   680: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   683: checkcast 50	java/lang/String
    //   686: astore 6
    //   688: aload_0
    //   689: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   692: ldc_w 5789
    //   695: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   698: checkcast 50	java/lang/String
    //   701: astore 7
    //   703: aload_0
    //   704: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   707: ldc_w 5791
    //   710: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   713: checkcast 50	java/lang/String
    //   716: astore 8
    //   718: new 6434	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData
    //   721: dup
    //   722: invokespecial 6435	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:<init>	()V
    //   725: astore 9
    //   727: aload 9
    //   729: aload 4
    //   731: putfield 6436	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   734: aload 9
    //   736: aload 6
    //   738: putfield 6437	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   741: aload 9
    //   743: ldc_w 372
    //   746: aload 7
    //   748: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   751: putfield 6438	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_b_of_type_Boolean	Z
    //   754: aload 9
    //   756: ldc_w 657
    //   759: aload 8
    //   761: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   764: putfield 6439	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_a_of_type_Boolean	Z
    //   767: aload 5
    //   769: ldc_w 6441
    //   772: iconst_1
    //   773: invokevirtual 597	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   776: aload 5
    //   778: ldc_w 6443
    //   781: aload 9
    //   783: invokevirtual 6447	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   786: ldc_w 657
    //   789: aload_0
    //   790: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   793: ldc_w 6449
    //   796: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   799: invokevirtual 354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   802: ifeq +1067 -> 1869
    //   805: iconst_1
    //   806: istore_1
    //   807: aload 5
    //   809: ldc_w 6451
    //   812: iload_1
    //   813: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   816: iload_1
    //   817: ifne +802 -> 1619
    //   820: aload_0
    //   821: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   824: ldc_w 6388
    //   827: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   830: checkcast 50	java/lang/String
    //   833: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   836: invokevirtual 673	java/lang/Integer:intValue	()I
    //   839: istore_2
    //   840: aload 5
    //   842: ldc_w 6453
    //   845: iload_2
    //   846: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   849: aload_0
    //   850: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   853: ldc_w 6455
    //   856: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   859: checkcast 50	java/lang/String
    //   862: invokestatic 580	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   865: invokevirtual 583	java/lang/Long:longValue	()J
    //   868: iconst_1
    //   869: invokestatic 6460	onj:a	(JZ)Ljava/lang/String;
    //   872: astore 4
    //   874: aload 5
    //   876: ldc_w 6462
    //   879: aload 4
    //   881: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   884: aload 5
    //   886: ldc_w 6464
    //   889: aload_0
    //   890: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   893: ldc_w 6466
    //   896: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   899: checkcast 50	java/lang/String
    //   902: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   905: aload 5
    //   907: ldc_w 6468
    //   910: aload_0
    //   911: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   914: ldc_w 6470
    //   917: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   920: checkcast 50	java/lang/String
    //   923: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   926: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: aload 5
    //   931: ldc_w 6472
    //   934: aload_0
    //   935: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   938: ldc_w 6474
    //   941: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   944: checkcast 50	java/lang/String
    //   947: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   950: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   953: aload 5
    //   955: ldc_w 6476
    //   958: aload_0
    //   959: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   962: ldc_w 6478
    //   965: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   968: checkcast 50	java/lang/String
    //   971: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   974: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   977: aload_0
    //   978: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   981: ldc_w 6480
    //   984: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   987: ifeq +46 -> 1033
    //   990: aload_0
    //   991: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   994: ldc_w 6480
    //   997: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1000: checkcast 989	java/lang/CharSequence
    //   1003: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1006: ifne +27 -> 1033
    //   1009: aload 5
    //   1011: ldc_w 6482
    //   1014: aload_0
    //   1015: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1018: ldc_w 6480
    //   1021: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1024: checkcast 50	java/lang/String
    //   1027: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1030: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: aload_0
    //   1034: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1037: ldc_w 6378
    //   1040: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1043: checkcast 50	java/lang/String
    //   1046: invokestatic 6487	onx:a	(Ljava/lang/String;)Lood;
    //   1049: astore 4
    //   1051: aload 4
    //   1053: ifnull +29 -> 1082
    //   1056: aload 5
    //   1058: ldc_w 6489
    //   1061: aload 4
    //   1063: getfield 6492	ood:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1066: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1069: aload 5
    //   1071: ldc_w 6494
    //   1074: aload 4
    //   1076: getfield 6495	ood:jdField_a_of_type_Long	J
    //   1079: invokevirtual 593	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1082: new 574	android/os/Bundle
    //   1085: dup
    //   1086: invokespecial 575	android/os/Bundle:<init>	()V
    //   1089: astore 4
    //   1091: aload 4
    //   1093: ldc_w 6497
    //   1096: aload_0
    //   1097: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1100: ldc_w 6378
    //   1103: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1106: checkcast 50	java/lang/String
    //   1109: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1112: aload 4
    //   1114: ldc_w 6499
    //   1117: aload_0
    //   1118: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1121: ldc_w 6378
    //   1124: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1127: checkcast 50	java/lang/String
    //   1130: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1133: aload 4
    //   1135: ldc_w 6501
    //   1138: aload_0
    //   1139: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1142: ldc_w 6366
    //   1145: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1148: checkcast 50	java/lang/String
    //   1151: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1154: invokevirtual 673	java/lang/Integer:intValue	()I
    //   1157: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1160: aload 4
    //   1162: ldc_w 6503
    //   1165: aload_0
    //   1166: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1169: ldc_w 6370
    //   1172: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1175: checkcast 50	java/lang/String
    //   1178: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1181: invokevirtual 673	java/lang/Integer:intValue	()I
    //   1184: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1187: aload 4
    //   1189: ldc_w 6505
    //   1192: aload_0
    //   1193: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1196: ldc_w 6374
    //   1199: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1202: checkcast 50	java/lang/String
    //   1205: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1208: invokevirtual 673	java/lang/Integer:intValue	()I
    //   1211: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1214: aload 4
    //   1216: ldc_w 6507
    //   1219: aload_0
    //   1220: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1223: ldc_w 6366
    //   1226: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1229: checkcast 50	java/lang/String
    //   1232: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1235: invokevirtual 673	java/lang/Integer:intValue	()I
    //   1238: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1241: aload_0
    //   1242: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1245: ldc_w 6388
    //   1248: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1251: checkcast 50	java/lang/String
    //   1254: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1257: invokevirtual 673	java/lang/Integer:intValue	()I
    //   1260: iconst_1
    //   1261: if_icmpne +797 -> 2058
    //   1264: aload 4
    //   1266: ldc_w 6509
    //   1269: aload_0
    //   1270: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1273: ldc_w 6466
    //   1276: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1279: checkcast 50	java/lang/String
    //   1282: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1285: aload 4
    //   1287: ldc_w 6511
    //   1290: aload_0
    //   1291: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1294: ldc_w 6470
    //   1297: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1300: checkcast 50	java/lang/String
    //   1303: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1306: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1309: aload 4
    //   1311: ldc_w 6513
    //   1314: aload_0
    //   1315: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1318: ldc_w 6466
    //   1321: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1324: checkcast 50	java/lang/String
    //   1327: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1330: aload 4
    //   1332: ldc_w 6515
    //   1335: aload_0
    //   1336: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1339: ldc_w 6388
    //   1342: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1345: checkcast 50	java/lang/String
    //   1348: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1351: invokevirtual 673	java/lang/Integer:intValue	()I
    //   1354: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1357: aload 4
    //   1359: ldc_w 6517
    //   1362: aload_0
    //   1363: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1366: ldc_w 6382
    //   1369: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1372: checkcast 50	java/lang/String
    //   1375: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1378: aload 4
    //   1380: ldc_w 6519
    //   1383: iconst_5
    //   1384: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1387: aload 4
    //   1389: ldc_w 6521
    //   1392: iconst_0
    //   1393: invokevirtual 597	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1396: aload 4
    //   1398: ldc_w 2489
    //   1401: aload_0
    //   1402: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1405: ldc_w 6424
    //   1408: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1411: checkcast 50	java/lang/String
    //   1414: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1417: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1420: aload 4
    //   1422: ldc_w 1615
    //   1425: aload_0
    //   1426: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1429: ldc_w 6420
    //   1432: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1435: checkcast 50	java/lang/String
    //   1438: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1441: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1444: aload 4
    //   1446: ldc_w 6392
    //   1449: aload_0
    //   1450: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1453: ldc_w 6378
    //   1456: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1459: checkcast 50	java/lang/String
    //   1462: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1465: aload 4
    //   1467: ldc_w 1565
    //   1470: aload_0
    //   1471: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1474: ldc_w 1565
    //   1477: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1480: checkcast 50	java/lang/String
    //   1483: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1486: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1489: aload 4
    //   1491: ldc_w 6523
    //   1494: aload_0
    //   1495: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1498: ldc_w 6455
    //   1501: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1504: checkcast 50	java/lang/String
    //   1507: invokestatic 580	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1510: invokevirtual 583	java/lang/Long:longValue	()J
    //   1513: invokestatic 6524	onj:a	(J)Ljava/lang/String;
    //   1516: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1519: aload 4
    //   1521: ldc_w 2493
    //   1524: aload_0
    //   1525: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1528: ldc_w 1565
    //   1531: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1534: checkcast 50	java/lang/String
    //   1537: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1540: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1543: aload 4
    //   1545: ldc_w 1577
    //   1548: sipush 140
    //   1551: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1554: aload 5
    //   1556: ldc_w 6526
    //   1559: aload 4
    //   1561: invokestatic 6531	axuy:a	(Landroid/os/Bundle;)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1564: checkcast 6533	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   1567: invokevirtual 6534	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getBytes	()[B
    //   1570: invokevirtual 6537	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1573: iload_2
    //   1574: bipush 6
    //   1576: if_icmpne +43 -> 1619
    //   1579: aload_0
    //   1580: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1583: ldc_w 6539
    //   1586: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1589: ifeq +30 -> 1619
    //   1592: aload 5
    //   1594: ldc_w 6541
    //   1597: aload_0
    //   1598: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1601: ldc_w 6539
    //   1604: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1607: checkcast 50	java/lang/String
    //   1610: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1613: invokestatic 6544	onk:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   1616: invokevirtual 6447	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1619: aload 5
    //   1621: ldc_w 6546
    //   1624: iconst_5
    //   1625: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1628: iload_1
    //   1629: iconst_1
    //   1630: if_icmpne +550 -> 2180
    //   1633: aload 5
    //   1635: ldc_w 6412
    //   1638: iconst_m1
    //   1639: invokevirtual 6547	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1642: invokestatic 6551	oph:a	(I)Z
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
    //   1668: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1671: aload 4
    //   1673: invokestatic 6554	com/tencent/biz/pubaccount/readinjoy/video/multivideo/MultiVideoFragment:a	(Landroid/content/Context;Landroid/content/Intent;)V
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
    //   1697: ldc_w 6556
    //   1700: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: aload_0
    //   1704: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1707: ldc_w 6394
    //   1710: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1713: checkcast 50	java/lang/String
    //   1716: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: ldc_w 6558
    //   1722: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: aload_0
    //   1726: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1729: ldc_w 6402
    //   1732: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1735: checkcast 50	java/lang/String
    //   1738: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1741: ldc_w 6560
    //   1744: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1747: aload 4
    //   1749: invokevirtual 2927	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1752: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1755: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1758: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1761: goto -1440 -> 321
    //   1764: aload 5
    //   1766: ldc_w 6412
    //   1769: bipush 100
    //   1771: invokevirtual 1520	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1774: goto -1367 -> 407
    //   1777: astore 4
    //   1779: invokestatic 663	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1782: ifeq -106 -> 1676
    //   1785: ldc_w 435
    //   1788: iconst_2
    //   1789: new 197	java/lang/StringBuilder
    //   1792: dup
    //   1793: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1796: ldc_w 6562
    //   1799: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1802: aload_0
    //   1803: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1806: ldc_w 6420
    //   1809: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1812: checkcast 50	java/lang/String
    //   1815: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1818: ldc_w 6564
    //   1821: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: aload_0
    //   1825: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1828: ldc_w 6420
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
    //   1860: ldc_w 6566
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
    //   1893: ldc_w 6568
    //   1896: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1899: aload 4
    //   1901: invokevirtual 2927	java/lang/Exception:getMessage	()Ljava/lang/String;
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
    //   1935: ldc_w 6570
    //   1938: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: aload_0
    //   1942: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1945: ldc_w 6478
    //   1948: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1951: checkcast 50	java/lang/String
    //   1954: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1957: ldc_w 6572
    //   1960: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1963: aload_0
    //   1964: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1967: ldc_w 6480
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
    //   2006: ldc_w 6574
    //   2009: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2012: aload_0
    //   2013: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2016: ldc_w 6388
    //   2019: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2022: checkcast 50	java/lang/String
    //   2025: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2028: ldc_w 6576
    //   2031: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: aload_0
    //   2035: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2038: ldc_w 6455
    //   2041: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2044: checkcast 50	java/lang/String
    //   2047: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2050: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2053: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2056: iconst_1
    //   2057: ireturn
    //   2058: aload_0
    //   2059: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2062: ldc_w 6578
    //   2065: invokevirtual 146	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2068: ifeq +43 -> 2111
    //   2071: aload_0
    //   2072: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2075: ldc_w 6578
    //   2078: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2081: checkcast 989	java/lang/CharSequence
    //   2084: invokestatic 244	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2087: ifne +24 -> 2111
    //   2090: aload 4
    //   2092: ldc_w 6509
    //   2095: aload_0
    //   2096: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2099: ldc_w 6578
    //   2102: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2105: checkcast 50	java/lang/String
    //   2108: invokevirtual 601	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2111: aload 4
    //   2113: ldc_w 6511
    //   2116: aload_0
    //   2117: getfield 102	bbds:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2120: ldc_w 6474
    //   2123: invokevirtual 150	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2126: checkcast 50	java/lang/String
    //   2129: invokestatic 880	bbds:a	(Ljava/lang/String;)Ljava/lang/String;
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
    //   2157: ldc_w 6580
    //   2160: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2163: aload 6
    //   2165: invokevirtual 2927	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2168: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2171: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2174: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2177: goto -658 -> 1519
    //   2180: aload 5
    //   2182: ldc_w 6412
    //   2185: iconst_m1
    //   2186: invokevirtual 6547	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   2189: aload 5
    //   2191: ldc_w 6368
    //   2194: invokevirtual 6581	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2197: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2200: invokevirtual 673	java/lang/Integer:intValue	()I
    //   2203: aload 5
    //   2205: ldc_w 6372
    //   2208: invokevirtual 6581	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2211: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2214: invokevirtual 673	java/lang/Integer:intValue	()I
    //   2217: aload 5
    //   2219: ldc_w 6364
    //   2222: invokevirtual 6581	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2225: invokestatic 670	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2228: invokevirtual 673	java/lang/Integer:intValue	()I
    //   2231: invokestatic 6584	oph:a	(IIII)Z
    //   2234: istore_3
    //   2235: goto -589 -> 1646
    //   2238: astore 4
    //   2240: iconst_0
    //   2241: istore_3
    //   2242: goto -596 -> 1646
    //   2245: new 106	android/content/Intent
    //   2248: dup
    //   2249: aload_0
    //   2250: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2253: ldc_w 6586
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
    //   2279: getfield 95	bbds:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2282: aload 4
    //   2284: invokevirtual 117	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2287: iconst_1
    //   2288: ireturn
    //   2289: aconst_null
    //   2290: astore 4
    //   2292: goto -1418 -> 874
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2295	0	this	bbds
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
                                      ((arii)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(306)).a((Bundle)localObject2);
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
 * Qualified Name:     bbds
 * JD-Core Version:    0.7.0.1
 */
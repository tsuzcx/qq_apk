import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.intervideo.nowproxy.InitData;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.QQKandianInterface;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.intervideo.nowproxy.common.login.LoginType;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedChannel;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDns;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDownloader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoading;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedRecord;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedWebView;
import com.tencent.intervideo.nowproxy.qqshare.CustomizedShareForQQ;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.intervideo.now.NowQQConnectFragment;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.manager.TicketManager;

public class asyy
  implements atat, Manager
{
  public static int a;
  static anrf jdField_a_of_type_Anrf = new aszf();
  private final long jdField_a_of_type_Long = 1800000L;
  private absi jdField_a_of_type_Absi;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aszk(this);
  public aszs a;
  aszv jdField_a_of_type_Aszv;
  ataw jdField_a_of_type_Ataw = new aszg(this);
  protected QQKandianInterface a;
  private LoginType jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginType = LoginType.QQConnect;
  protected CustomizedChannel a;
  protected CustomizedDns a;
  protected CustomizedDownloader a;
  protected CustomizedLoading a;
  protected CustomizedLog a;
  protected CustomizedRecord a;
  protected CustomizedReport a;
  protected CustomizedWebView a;
  protected CustomizedShareForQQ a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(System.currentTimeMillis() - 1800000L);
  public String b;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public asyy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedLog = new aszl(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedChannel = new aszm(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedLoading = new aszn(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedReport = new aszo(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedDownloader = new aszp(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedRecord = new asza(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyQqshareCustomizedShareForQQ = new aszb(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyQQKandianInterface = new aszc(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedWebView = new aszd(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedDns = new asze(this);
    try
    {
      QLog.i("XProxy|NowProxy", 1, "DynamicNowManager create app = " + paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      asvg.a();
      aszx.a().a(paramQQAppInterface);
      e();
      f();
      this.jdField_a_of_type_Aszs = new aszs(paramQQAppInterface);
      paramQQAppInterface = new IntentFilter();
      paramQQAppInterface.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      paramQQAppInterface.addAction("mqq.intent.action.ACCOUNT_KICKED");
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("XProxy|NowProxy", 1, "initNowSdk exception ", paramQQAppInterface);
    }
  }
  
  public static int a(String paramString)
  {
    int i = 2;
    if ((paramString.equals("1")) || (paramString.equals("2"))) {
      i = 1;
    }
    return i;
  }
  
  private Bundle a(Bundle paramBundle, NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    paramBundle.putString("KEY_GROUP_UIN", paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString);
    paramBundle.putString("KEY_GROUP_OWNER_UIN", paramNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString);
    paramBundle.putInt("KEY_ROOM_TYPE", paramNewTogetherRoomMessageData.jdField_a_of_type_Int);
    paramBundle.putLong("KEY_ROOM_ID", paramNewTogetherRoomMessageData.jdField_a_of_type_Long);
    paramBundle.putInt("KEY_OLD_ROOM_TYPE", paramNewTogetherRoomMessageData.c);
    paramBundle.putLong("KEY_OLD_ROOM_ID", paramNewTogetherRoomMessageData.jdField_b_of_type_Long);
    paramBundle.putString("KEY_ROOM_NAME", paramNewTogetherRoomMessageData.d);
    paramBundle.putString("KEY_JUMP_SCHEME", paramNewTogetherRoomMessageData.e);
    paramBundle.putString("KEY_ROOM_COVER", paramNewTogetherRoomMessageData.f);
    paramBundle.putString("KEY_FROM_ID", paramNewTogetherRoomMessageData.g);
    return paramBundle;
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new InvalidParameterException("can't get AppInterface");
  }
  
  private static void a(long paramLong, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      if (paramLong != 0L) {
        break label195;
      }
    }
    label195:
    for (str = "https://now.qq.com/qq/play.html?_bid=2374&_wv=16778245&from=50320";; str = "https://now.qq.com/h5/index.html?_bid=2336&_wv=16778245&from=50320&roomid=" + paramLong)
    {
      long l = System.currentTimeMillis();
      paramString1 = str + "&_t=" + l;
      aszx.a().a().a("", String.valueOf(paramLong), paramString2, paramString1);
      paramString2 = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
      paramString2.putExtra("hide_operation_bar", true);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("op_type", "now_live");
      paramString2.putExtra("key_isReadModeEnabled", true);
      paramString2.setFlags(268435456);
      paramString2.putExtra("insertPluginsArray", new String[] { "nowlive" });
      QLog.i("XProxy|NowProxy", 1, "跳转web页面 URL = " + paramString1 + " time = " + l);
      aeif.a(BaseApplicationImpl.getContext(), paramString2, paramString1);
      return;
    }
  }
  
  public static boolean a()
  {
    return bdem.a(BaseApplicationImpl.getContext(), "com.tencent.now");
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("XProxy|NowProxy", 1, "isTroopOwner  troopUin is null");
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramString);
      if (paramString != null)
      {
        boolean bool = paramString.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        QLog.i("XProxy|NowProxy", 1, "isTroopOwner  selfuin is " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + ";isOwner=" + bool);
        return bool;
      }
    }
    return false;
  }
  
  public static void b(Bundle paramBundle)
  {
    if (a())
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tnow://openpage/startlive?from=1"));
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      localIntent.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      return;
    }
    a(0L, "http://a.app.qq.com/o/simple.jsp?pkgname=com.tencent.now&ckey=CK1339000284644", "beginLive");
  }
  
  public static void d()
  {
    jdField_a_of_type_Int = anrt.a().a(jdField_a_of_type_Anrf);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Aszv = new aszv();
    InitData localInitData = new InitData();
    localInitData.mAppID = "2";
    localInitData.mSourceVersion = String.valueOf(aowf.a(BaseApplicationImpl.getContext()));
    localInitData.mSourceUid = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localInitData.mIsCpu64bit = false;
    NowLive.setShadowImp(this.jdField_a_of_type_Aszv);
    NowLive.start(BaseApplicationImpl.getContext(), localInitData);
  }
  
  private void f()
  {
    NowLive.setCustomizedLog(this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedLog);
    NowLive.setCustomChannel(this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedChannel);
    NowLive.setCustomizedLoading(this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedLoading);
    NowLive.setCustomizeReport(this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedReport);
    NowLive.setCustomizedDownloader(this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedDownloader);
    NowLive.setCustomizedRecord(this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedRecord);
    NowLive.setCustomizedShareForQQ(this.jdField_a_of_type_ComTencentIntervideoNowproxyQqshareCustomizedShareForQQ);
    NowLive.setQQKandianInterface(this.jdField_a_of_type_ComTencentIntervideoNowproxyQQKandianInterface);
    NowLive.setCustomizedWebView(this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedWebView);
    NowLive.setCustomizedDns(this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedDns);
  }
  
  private void g()
  {
    LoginData localLoginData;
    if (System.currentTimeMillis() - this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() > 1800000L)
    {
      localLoginData = new LoginData();
      TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localTicketManager.getA2(str);
      localLoginData.setLoginType(this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginType);
      localLoginData.setLoginAppid(16L);
      localLoginData.setSkey(localTicketManager.getSkey(str).getBytes());
      localLoginData.setST(localTicketManager.getSt(str, 16));
      localLoginData.setSTKey(localTicketManager.getStkey(str, 16));
      localLoginData.setUserId(str);
      if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        NowLive.login(localLoginData);
      }
    }
    else
    {
      return;
    }
    localLoginData.setKey(this.jdField_b_of_type_JavaLangString.getBytes());
    localLoginData.setAuthAppId("101490787");
    localLoginData.setOriginalId(this.jdField_a_of_type_JavaLangString);
    NowLive.login(localLoginData);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(System.currentTimeMillis());
  }
  
  public ataw a()
  {
    return this.jdField_a_of_type_Ataw;
  }
  
  public void a()
  {
    g();
    this.jdField_a_of_type_Aszs.a();
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null))
    {
      QLog.e("XProxy|NowProxy", 1, "activity or bundle is null");
      return;
    }
    paramBundle.putBoolean("is_cpu_64bit", false);
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)aush.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "key_nearby_now_qq_connect_auth_time", Long.valueOf(0L))).longValue();
    QLog.d("XProxy|NowProxy", 1, "now qq connect auth time diff = " + (l1 - l2) / 1000L);
    if ((this.jdField_a_of_type_Absi == null) || (l1 - l2 > 1728000000L))
    {
      aush.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "key_nearby_now_qq_connect_auth_time", Long.valueOf(l1));
      absn.a();
      this.jdField_a_of_type_Absi = absn.a(paramActivity, 6, "101490787");
    }
    paramActivity = new WeakReference(paramActivity);
    this.jdField_a_of_type_Absi.a("loginSilent", null, new aszj(this, paramActivity, paramBundle));
  }
  
  public void a(Bundle paramBundle)
  {
    QLog.i("XProxy|NowProxy", 1, "enter login_type = " + this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginType.ordinal());
    a(paramBundle, null);
  }
  
  public void a(Bundle paramBundle, aszq paramaszq)
  {
    paramBundle.putInt("jumpCallbackId", jdField_a_of_type_Int);
    paramaszq = new Intent();
    paramaszq.putExtras(paramBundle);
    adky.a(paramaszq, PublicTransFragmentActivity.class, NowQQConnectFragment.class);
  }
  
  public void a(ConfigurationService.Config paramConfig) {}
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    a();
  }
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, atav paramatav)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("mqqScheme", paramNewTogetherRoomMessageData.e);
    localBundle.putBoolean("fromWatchTogether", true);
    localBundle.putString("group_uin", paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString);
    localBundle.putString("group_owner_uin", paramNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString);
    localBundle.putString("group_name", bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString, false));
    localBundle.putBoolean("is_group_owner", a(paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString));
    localBundle.putString("roomid", String.valueOf(paramNewTogetherRoomMessageData.jdField_a_of_type_Long));
    localBundle.putString("fromid", String.valueOf(paramNewTogetherRoomMessageData.g));
    a(localBundle, new asyz(this, paramatav));
  }
  
  public void b()
  {
    BaseApplicationImpl.getContext().sendBroadcast(new Intent("room.close.audio"));
  }
  
  public void b(Bundle paramBundle, aszq paramaszq)
  {
    paramBundle.putInt("ctrl_cmd", 1);
    NowLive.closeRoom(paramBundle, new aszh(this, paramaszq));
  }
  
  public void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, atav paramatav)
  {
    b(a(paramBundle, paramNewTogetherRoomMessageData), new aszi(this, paramatav));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      asyo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    }
  }
  
  public void onDestroy()
  {
    QLog.i("XProxy|NowProxy", 1, "DynamicNowManager onDestroy mApp = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    NowLive.killPluginProcess();
    aszx.a();
    ((atbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(338)).a(1);
    this.jdField_a_of_type_Aszs.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Absi = null;
    NowLive.setCustomizedLog(null);
    NowLive.setCustomChannel(null);
    NowLive.setCustomizedLoading(null);
    NowLive.setCustomizeReport(null);
    NowLive.setCustomizedDownloader(null);
    NowLive.setCustomizedRecord(null);
    NowLive.setCustomizedShareForQQ(null);
    NowLive.setQQKandianInterface(null);
    NowLive.setCustomizedWebView(null);
    NowLive.setCustomizedDns(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyy
 * JD-Core Version:    0.7.0.1
 */
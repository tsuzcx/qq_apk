import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.now.NowQQConnectFragment;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

public class avux
  implements avwy, Manager
{
  public static int a;
  static aqfy jdField_a_of_type_Aqfy = new avvg();
  private final long jdField_a_of_type_Long = 1800000L;
  private adad jdField_a_of_type_Adad;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new avvl(this);
  public avvu a;
  avvx jdField_a_of_type_Avvx;
  avxb jdField_a_of_type_Avxb = new avvh(this);
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
  
  public avux(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedLog = new avvo(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedChannel = new avvp(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedLoading = new avvq(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedReport = new avuz(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedDownloader = new avva(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedRecord = new avvb(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyQqshareCustomizedShareForQQ = new avvc(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyQQKandianInterface = new avvd(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedWebView = new avve(this);
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceCustomizedDns = new avvf(this);
    try
    {
      QLog.i("XProxy|NowProxy", 1, "DynamicNowManager create app = " + paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      avsg.a();
      avvz.a().a(paramQQAppInterface);
      e();
      f();
      this.jdField_a_of_type_Avvu = new avvu(paramQQAppInterface);
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
      avvz.a().a().a("", String.valueOf(paramLong), paramString2, paramString1);
      paramString2 = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
      paramString2.putExtra("hide_operation_bar", true);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("op_type", "now_live");
      paramString2.putExtra("key_isReadModeEnabled", true);
      paramString2.setFlags(268435456);
      paramString2.putExtra("insertPluginsArray", new String[] { "nowlive" });
      QLog.i("XProxy|NowProxy", 1, "跳转web页面 URL = " + paramString1 + " time = " + l);
      aflm.a(BaseApplicationImpl.getContext(), paramString2, paramString1);
      return;
    }
  }
  
  public static boolean a()
  {
    return bhfn.a(BaseApplicationImpl.getContext(), "com.tencent.now");
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
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
      paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
      if (paramString != null)
      {
        boolean bool = paramString.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        QLog.i("XProxy|NowProxy", 1, "isTroopOwner  selfuin is " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + ";isOwner=" + bool);
        return bool;
      }
    }
    return false;
  }
  
  public static void c(Bundle paramBundle)
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
    a(0L, "https://a.app.qq.com/o/simple.jsp?pkgname=com.tencent.now&ckey=CK1339000284644", "beginLive");
  }
  
  public static void d()
  {
    jdField_a_of_type_Int = aqgm.a().a(jdField_a_of_type_Aqfy);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Avvx = new avvx();
    InitData localInitData = new InitData();
    localInitData.mAppID = "2";
    localInitData.mSourceVersion = String.valueOf(arqj.a(BaseApplicationImpl.getContext()));
    localInitData.mSourceUid = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localInitData.mIsCpu64bit = false;
    NowLive.setShadowImp(this.jdField_a_of_type_Avvx);
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
    long l = System.currentTimeMillis() - this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
    QLog.i("XProxy|NowProxy", 1, "login timeDiff: " + l);
    if (l >= 1800000L)
    {
      LoginData localLoginData = new LoginData();
      TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localTicketManager.getA2(str);
      localLoginData.setLoginType(this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginType);
      localLoginData.setLoginAppid(16L);
      a(str, new avvm(this, localLoginData, localTicketManager, str));
    }
  }
  
  public avxb a()
  {
    return this.jdField_a_of_type_Avxb;
  }
  
  public void a()
  {
    b(null);
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
    long l2 = ((Long)axqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "key_nearby_now_qq_connect_auth_time", Long.valueOf(0L))).longValue();
    QLog.d("XProxy|NowProxy", 1, "now qq connect auth time diff = " + (l1 - l2) / 1000L);
    if ((this.jdField_a_of_type_Adad == null) || (l1 - l2 > 1728000000L))
    {
      axqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "key_nearby_now_qq_connect_auth_time", Long.valueOf(l1));
      adai.a();
      this.jdField_a_of_type_Adad = adai.a(paramActivity, 6, "101490787");
    }
    paramActivity = new WeakReference(paramActivity);
    this.jdField_a_of_type_Adad.a("loginSilent", null, new avvk(this, paramActivity, paramBundle));
  }
  
  public void a(Bundle paramBundle)
  {
    QLog.i("XProxy|NowProxy", 1, "enter login_type = " + this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginType.ordinal());
    a(paramBundle, null);
  }
  
  public void a(Bundle paramBundle, avvs paramavvs)
  {
    paramBundle.putInt("jumpCallbackId", jdField_a_of_type_Int);
    paramavvs = new Intent();
    paramavvs.putExtras(paramBundle);
    paramavvs.putExtra("public_fragment_window_feature", 1);
    aeow.a(paramavvs, PublicTransFragmentActivity.class, NowQQConnectFragment.class);
  }
  
  public void a(ConfigurationService.Config paramConfig) {}
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    a();
  }
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, avxa paramavxa)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("mqqScheme", paramNewTogetherRoomMessageData.e);
    localBundle.putBoolean("fromWatchTogether", true);
    localBundle.putString("group_uin", paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString);
    localBundle.putString("group_owner_uin", paramNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString);
    localBundle.putString("group_name", ContactUtils.getTroopName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString, false));
    localBundle.putBoolean("is_group_owner", a(paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString));
    localBundle.putString("roomid", String.valueOf(paramNewTogetherRoomMessageData.jdField_a_of_type_Long));
    localBundle.putString("fromid", String.valueOf(paramNewTogetherRoomMessageData.g));
    a(localBundle, new avuy(this, paramavxa));
  }
  
  public void a(String paramString, @NonNull avvr paramavvr)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      paramavvr.a(2, null);
    }
    do
    {
      return;
      TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      if (localTicketManager == null)
      {
        paramavvr.a(2, null);
        return;
      }
      paramString = localTicketManager.getSkey(paramString, 16L, new avvn(this, paramavvr));
    } while ((paramString == null) || (paramString._sig == null) || (paramString._sig.length == 0));
    paramavvr.a(0, new String(paramString._sig));
  }
  
  public void b()
  {
    BaseApplicationImpl.getContext().sendBroadcast(new Intent("room.close.audio"));
  }
  
  public void b(Bundle paramBundle)
  {
    QLog.i("XProxy|NowProxy", 1, "invoke preload");
    g();
    this.jdField_a_of_type_Avvu.a(paramBundle);
  }
  
  public void b(Bundle paramBundle, avvs paramavvs)
  {
    paramBundle.putInt("ctrl_cmd", 1);
    NowLive.closeRoom(paramBundle, new avvi(this, paramavvs));
  }
  
  public void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, avxa paramavxa)
  {
    b(a(paramBundle, paramNewTogetherRoomMessageData), new avvj(this, paramavxa));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      avun.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
  }
  
  public void onDestroy()
  {
    QLog.i("XProxy|NowProxy", 1, "DynamicNowManager onDestroy mApp = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    NowLive.killPluginProcess();
    ((avxv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WATCH_LIVE_TOGETHER)).a(1);
    this.jdField_a_of_type_Avvu.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Adad = null;
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
    avvz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avux
 * JD-Core Version:    0.7.0.1
 */
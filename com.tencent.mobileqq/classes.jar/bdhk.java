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
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
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
import com.tencent.imcore.message.QQMessageFacade;
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
import com.tencent.mobileqq.activity.GeneralSettingActivity;
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
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.qwallet.WXMiniProgramHelper;
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
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity;
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
import dov.com.qq.im.ae.mode.AECaptureMode;
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

public class bdhk
{
  public static int a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.mobileqq" };
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public acln a;
  private amaz jdField_a_of_type_Amaz;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public final Context a;
  protected Handler a;
  private bdhx jdField_a_of_type_Bdhx = new bdhx(this, this);
  private bdhy jdField_a_of_type_Bdhy;
  protected bety a;
  bfzo jdField_a_of_type_Bfzo = new bdhl(this);
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
  
  public bdhk(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Acln = new bdhq(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private boolean C()
  {
    Object localObject1;
    Object localObject3;
    if ("opendetail".equals(this.c))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLong("key_launch_time", System.currentTimeMillis());
      localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      if ((localObject3 == null) || ("".equals(localObject3)) || (((String)localObject3).length() < 5)) {
        return false;
      }
    }
    try
    {
      ((Bundle)localObject1).putLong("key_current_feeduin", Long.valueOf((String)localObject3).longValue());
      ((Bundle)localObject1).putString("key_current_feed_cellid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("cellid"));
      ((Bundle)localObject1).putInt("key_request_from", 3);
      ((Bundle)localObject1).putInt("key_weishi_entrance_type", 19);
      ((Bundle)localObject1).putInt("key_request_business_type", 8);
      a((Bundle)localObject1);
      for (;;)
      {
        return true;
        if (!"takevideo".equals(this.c)) {
          continue;
        }
        localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("widgetid");
        String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("activity_id");
        String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("shareto");
        str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cmode");
        String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("widgetinfo");
        localObject1 = "";
        Bundle localBundle = new Bundle();
        localObject6 = localObject3;
        Object localObject4 = localObject1;
        if (!TextUtils.isEmpty(str6))
        {
          String[] arrayOfString = str6.split("\\^");
          if (arrayOfString.length > 0) {
            localObject1 = arrayOfString[0];
          }
          if (arrayOfString.length == 1)
          {
            localObject3 = arrayOfString[0];
            localObject1 = AECaptureMode.NORMAL.name;
          }
          if (arrayOfString.length > 1) {
            localObject3 = arrayOfString[1];
          }
          localObject6 = localObject3;
          localObject4 = localObject1;
          if (arrayOfString.length > 2)
          {
            localObject6 = arrayOfString[2];
            localObject4 = localObject3;
            localObject3 = localObject6;
            if (!TextUtils.isEmpty(localObject4))
            {
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                localBundle.putString("KEY_CURRENT_TYPE", (String)localObject3);
                label345:
                localBundle.putString("KEY_CURRENT_TAB", blat.a((String)localObject1));
              }
            }
            else
            {
              bljn.b("JumpAction", "【widgetid】:" + localObject4 + "【" + "from" + "】:" + str4 + "【" + "activity_id" + "】:" + str3 + "【" + "shareto" + "】:" + str5 + "【" + "cmode" + "】:" + str2 + "【" + "widgetinfo" + "】:" + str6);
              if (!TextUtils.isEmpty(localObject4)) {
                localBundle.putString("KEY_CURRENT_SELECT_ID", localObject4);
              }
            }
            try
            {
              i1 = blat.a(str4).a();
              a(localBundle, i1);
              if (blat.d(i1)) {
                localObject1 = "cameraAndPlay";
              }
            }
            catch (Exception localException1)
            {
              try
              {
                int i1;
                localBundle.putInt("VIDEO_STORY_FROM_TYPE", i1);
                localObject3 = localObject1;
                label534:
                if (TextUtils.isEmpty(str3)) {}
              }
              catch (Exception localException5)
              {
                label552:
                label571:
                label606:
                break label606;
              }
              try
              {
                localBundle.putString("VIDEO_STORY_ACTIVITY_ID", str3);
                if (TextUtils.isEmpty((CharSequence)localObject3)) {}
              }
              catch (Exception localException1)
              {
                try
                {
                  localBundle.putInt("AECAMERA_MODE", blat.a((String)localObject3));
                  blax.a((Activity)this.jdField_a_of_type_AndroidContentContext, 120, localBundle);
                  continue;
                  localBundle.putString("KEY_CURRENT_TYPE", " ");
                  break label345;
                  localException4 = localException4;
                  localObject1 = str2;
                  localObject3 = localObject1;
                  if (!QLog.isColorLevel()) {
                    break label534;
                  }
                  QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_FROM_TYPE format: " + localException4.getMessage());
                  localObject3 = localObject1;
                  break label534;
                  localException1 = localException1;
                  if (!QLog.isColorLevel()) {
                    break label552;
                  }
                  QLog.e("JumpAction", 2, "Invalid VIDEO_STORY_ACTIVITY_ID format: " + localException1.getMessage());
                }
                catch (Exception localException2)
                {
                  if (!QLog.isColorLevel()) {
                    break label571;
                  }
                  QLog.e("JumpAction", 2, "Invalid AECAMERA_MODE format: " + localException2.getMessage());
                  break label571;
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        String str2;
        Object localObject6;
        continue;
        Object localObject2 = str2;
        continue;
        String str1 = "";
        localObject2 = localException5;
        Object localObject5 = localObject6;
      }
    }
  }
  
  private boolean D()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HcePluginInstallActivity.class);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean E()
  {
    WXMiniProgramHelper.a().a(this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  private boolean F()
  {
    int i1 = 0;
    if (!bdin.g(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694769, 1).a();
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
        localObject = new JSONObject(new String(bdfr.decode(str1, 0)));
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
  
  private boolean G()
  {
    int i2 = 0;
    if (!bdin.g(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694769, 1).a();
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
  
  private boolean H()
  {
    if (!bdin.g(BaseApplicationImpl.getApplication()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131694769, 1).a();
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
  
  private boolean I()
  {
    boolean bool = ((Boolean)((uvt)uwa.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("token");
    if (!TextUtils.isEmpty(str)) {
      vlb.a(this.jdField_a_of_type_AndroidContentContext, str, new bdhu(this), null);
    }
    for (;;)
    {
      return true;
      if (TextUtils.equals(this.c, "publish"))
      {
        J();
      }
      else
      {
        if (bool)
        {
          this.c = "open";
          vlb.a(this.jdField_a_of_type_JavaUtilHashMap);
        }
        J();
      }
    }
  }
  
  private boolean J()
  {
    if ((QzoneConfig.getInstance().getConfig("qqstoryvideo", "jump_hyws_scheme_enable", 0) == 0) && (BaseApplicationImpl.getContext() != null))
    {
      ThreadManager.getUIHandler().post(new JumpAction.4(this));
      return false;
    }
    if ((((uza)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252)).jdField_a_of_type_Boolean) && (!"open".equals(this.c)) && (!"openTag".equals(this.c)) && (!"openSquare".equals(this.c)) && (!"publish".equals(this.c))) {
      return bz();
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("one_page");
    String str1 = str2;
    if (String.valueOf(2).equals(str2))
    {
      uza localuza = (uza)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252);
      str1 = str2;
      if (localuza != null)
      {
        str1 = str2;
        if (!localuza.jdField_a_of_type_Boolean)
        {
          str1 = String.valueOf(0);
          this.jdField_a_of_type_JavaUtilHashMap.put("one_page", str1);
        }
      }
    }
    if ("0".equals(str1)) {
      return bC();
    }
    if ("open".equals(this.c)) {
      return bC();
    }
    return bz();
  }
  
  private boolean K()
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      if (TextUtils.isEmpty(aoxg.a().h())) {}
      for (String str = "https://docs.qq.com/desktop/m/index.html?_from=1";; str = aoxg.a().h())
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
  
  private boolean L()
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
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077F6", "0X80077F6", 0, 0, "", "", "", "");
    }
    do
    {
      return true;
      if ("10004".equals(str))
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X80077F7", "0X80077F7", 0, 0, "", "", "", "");
        return true;
      }
    } while (!"10009".equals(str));
    QLog.i("JumpAction", 1, "jumpaction from gotoConversaton e = ");
    return true;
  }
  
  private boolean M()
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
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5AF", "0X800A5AF", 0, 0, l1 + "", "", "", "");
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
  
  private boolean N()
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
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5AF", "0X800A5AF", 0, 0, l1 + "", "", "", "");
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
  
  private boolean O()
  {
    long l4 = System.currentTimeMillis();
    boolean bool2 = amsg.a().a();
    amsk localamsk = (amsk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(220);
    Object localObject1;
    if (localamsk != null)
    {
      localObject1 = localamsk.a();
      QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is config info is " + localObject1);
      if (!localamsk.b()) {}
    }
    label132:
    label1160:
    label1168:
    label1173:
    for (boolean bool1 = true;; bool1 = false)
    {
      String str;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      }
      label797:
      label1193:
      for (;;)
      {
        Object localObject2;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("args"))
        {
          localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("args");
          if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("disablecloud")) {
            break label510;
          }
          localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("disablecloud");
        }
        label583:
        label845:
        try
        {
          for (;;)
          {
            i1 = Integer.parseInt((String)localObject2);
            if ((i1 == 1) || (i1 == 0)) {
              break label1390;
            }
            i1 = 1;
            QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity device support is " + bool2 + ",effectinfo is " + bool1 + ",from url is " + str + ",args is" + (String)localObject1 + ",cloudSwitch is " + i1);
            if ((!bool2) || (!bool1)) {
              break label1193;
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
              break label616;
            }
            localObject2 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
            for (localObject1 = "";; localObject1 = (String)localObject1 + (String)((Map.Entry)localObject4).getKey() + "[" + ((String)((Map.Entry)localObject4).getValue()).substring(0, 20) + "]\n")
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label583;
              }
              localObject4 = (Map.Entry)((Iterator)localObject2).next();
              if ((((Map.Entry)localObject4).getValue() == null) || (((String)((Map.Entry)localObject4).getValue()).length() <= 20)) {
                break;
              }
            }
            str = "";
            break;
            localObject1 = "";
            break label132;
            label510:
            localObject2 = "0";
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label616:
          label873:
          label1390:
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
                    break label1140;
                  }
                  localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enableQR");
                }
                label751:
                label1140:
                try
                {
                  l3 = Long.valueOf((String)localObject3).longValue();
                  if (l3 != 0L) {
                    break label1148;
                  }
                  bool1 = true;
                }
                catch (Exception localException3)
                {
                  label1013:
                  label1148:
                  break label771;
                }
                ((Bundle)localObject4).putLong("PromotionType", l1);
                ((Bundle)localObject4).putLong("RecoglizeMask", l2);
                if (i1 != 0)
                {
                  bool2 = true;
                  ((Bundle)localObject4).putBoolean("disablecloud", bool2);
                  ((Bundle)localObject4).putString("H5Source", (String)localObject1);
                  if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("version")) {
                    break label1160;
                  }
                  localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("version");
                  ((Bundle)localObject4).putString("version", (String)localObject1);
                  ((Bundle)localObject4).putBoolean("enableQR", bool1);
                  if (l1 == 0L) {
                    break label1168;
                  }
                  i1 = 1;
                  if ((i1 != 0) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("PromotionDescription"))) {
                    ((Bundle)localObject4).putString("PromotionDescription", (String)this.jdField_a_of_type_JavaUtilHashMap.get("PromotionDescription"));
                  }
                  ((Bundle)localObject4).putBoolean("is_from_h5_entry", true);
                  localIntent.putExtra("web_invoke_params", (Bundle)localObject4);
                  AudioHelper.a("JumpAction", (Bundle)localObject4);
                  QLog.w("JumpAction", 1, "PromotionInfo test , \n" + ((Bundle)localObject4).toString() + "]");
                  if (localamsk != null)
                  {
                    if ((localamsk.a() != null) && (!TextUtils.isEmpty(localamsk.a().jdField_e_of_type_JavaLangString))) {
                      break label1173;
                    }
                    localIntent.putExtra("icon_text", "QQ-AR");
                    if ((localamsk.a() != null) && (localamsk.a().c != null)) {
                      localIntent.putExtra("icon_url", localamsk.a().c);
                    }
                  }
                  this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
                  azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "0", str, "", "");
                }
                for (;;)
                {
                  QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity cost time is " + (System.currentTimeMillis() - l4));
                  return true;
                  localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("H5Source");
                  break;
                  localObject3 = "0";
                  break label751;
                  bool1 = false;
                  break label771;
                  bool2 = false;
                  break label797;
                  localObject1 = "0";
                  break label845;
                  i1 = 0;
                  break label873;
                  localIntent.putExtra("icon_text", localamsk.a().jdField_e_of_type_JavaLangString);
                  break label1013;
                  localObject3 = new StringBuilder("https://ti.qq.com/ar/help/error.html?_wv=3");
                  ((StringBuilder)localObject3).append("&from=");
                  ((StringBuilder)localObject3).append(str);
                  ((StringBuilder)localObject3).append("&args=");
                  new StringBuffer();
                  ((StringBuilder)localObject3).append(afnq.a((String)localObject1));
                  QLog.i("JumpAction", 1, "jumpaction from gotoScannerActivity QQBrowserActivity cost time is " + ((StringBuilder)localObject3).toString());
                  localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                  ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
                  ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject3).toString());
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
                  azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01440", "", "", "0X8007BB9", "0X8007BB9", 0, 0, "1", str, "", "");
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
  
  private boolean P()
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
  
  private boolean Q()
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
  
  private boolean R()
  {
    if (QLog.isColorLevel()) {
      auwz.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
      label133:
      String str1;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("web_url"))
      {
        str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("web_url");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from")) {
          break label757;
        }
        str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) {
          break label764;
        }
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
        label161:
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
              break label790;
            }
            str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_gender");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_time")) {
              break label797;
            }
            str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_time");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_age")) {
              break label804;
            }
            str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_age");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_xingzuo")) {
              break label811;
            }
            str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_xingzuo");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_interest")) {
              break label818;
            }
            str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_interest");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_career")) {
              break label825;
            }
            str9 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filter_career");
            if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("filter_location")) {
              break label832;
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
                        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007244", "0X8007244", 0, 0, "", "", "", "");
                      }
                      return true;
                      str2 = "";
                      break;
                      str4 = "";
                      break label107;
                      label757:
                      str5 = "";
                      break label133;
                      label764:
                      str1 = "";
                      break label161;
                      localException1 = localException1;
                      localException1.printStackTrace();
                      int i1 = 0;
                      continue;
                      String str3 = "";
                      continue;
                      label790:
                      str4 = "";
                      continue;
                      label797:
                      str5 = "";
                      continue;
                      label804:
                      String str6 = "";
                      continue;
                      label811:
                      String str7 = "";
                      continue;
                      label818:
                      String str8 = "";
                      continue;
                      label825:
                      String str9 = "";
                      continue;
                      label832:
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
  
  private boolean S()
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
  
  private boolean T()
  {
    HotChatManager.a(this.jdField_a_of_type_AndroidContentContext, false);
    return true;
  }
  
  private boolean U()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("hotnamecode")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hotnamecode"); TextUtils.isEmpty(str); str = "")
    {
      QQToast.a(BaseApplicationImpl.getContext(), alud.a(2131706290), 1).a();
      return false;
    }
    NearbyTransitActivity.a(this.jdField_a_of_type_AndroidContentContext, str, 1, this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  /* Error */
  private boolean V()
  {
    // Byte code:
    //   0: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +18 -> 21
    //   6: ldc 217
    //   8: iconst_1
    //   9: anewarray 4	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: ldc_w 916
    //   17: aastore
    //   18: invokestatic 828	auwz:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aload_0
    //   22: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   25: ldc_w 918
    //   28: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   31: ifeq +220 -> 251
    //   34: aload_0
    //   35: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   38: ldc_w 918
    //   41: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 50	java/lang/String
    //   47: invokestatic 922	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   55: ldc 177
    //   57: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   60: ifeq +186 -> 246
    //   63: aload_0
    //   64: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   67: ldc 177
    //   69: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 50	java/lang/String
    //   75: invokestatic 392	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   78: istore_1
    //   79: new 291	android/content/Intent
    //   82: dup
    //   83: aload_0
    //   84: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   87: ldc_w 549
    //   90: invokespecial 296	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   93: astore_3
    //   94: aload_3
    //   95: ldc_w 566
    //   98: iconst_1
    //   99: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   102: pop
    //   103: aload_3
    //   104: ldc_w 560
    //   107: getstatic 564	com/tencent/mobileqq/activity/MainFragment:jdField_b_of_type_Int	I
    //   110: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   113: pop
    //   114: aload_3
    //   115: ldc_w 554
    //   118: invokevirtual 558	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   121: pop
    //   122: aload_0
    //   123: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   126: ldc 177
    //   128: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   131: ifeq +11 -> 142
    //   134: aload_3
    //   135: ldc 177
    //   137: iload_1
    //   138: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   141: pop
    //   142: aload_0
    //   143: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   146: ldc_w 918
    //   149: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   152: ifeq +12 -> 164
    //   155: aload_3
    //   156: ldc_w 918
    //   159: iload_2
    //   160: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   163: pop
    //   164: aload_0
    //   165: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   168: instanceof 549
    //   171: ifeq +41 -> 212
    //   174: aload_0
    //   175: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   178: checkcast 549	com/tencent/mobileqq/activity/SplashActivity
    //   181: astore 4
    //   183: aload_3
    //   184: ldc_w 924
    //   187: iconst_1
    //   188: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   191: pop
    //   192: aload 4
    //   194: aload_3
    //   195: invokevirtual 926	com/tencent/mobileqq/activity/SplashActivity:b	(Landroid/content/Intent;)V
    //   198: iconst_1
    //   199: ireturn
    //   200: astore_3
    //   201: iconst_0
    //   202: istore_2
    //   203: aload_3
    //   204: invokevirtual 545	java/lang/Exception:printStackTrace	()V
    //   207: iconst_0
    //   208: istore_1
    //   209: goto -130 -> 79
    //   212: aload_0
    //   213: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   216: aload_3
    //   217: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   220: aload_0
    //   221: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   224: instanceof 264
    //   227: ifeq -29 -> 198
    //   230: aload_0
    //   231: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   234: checkcast 264	android/app/Activity
    //   237: invokevirtual 929	android/app/Activity:finish	()V
    //   240: iconst_1
    //   241: ireturn
    //   242: astore_3
    //   243: goto -40 -> 203
    //   246: iconst_0
    //   247: istore_1
    //   248: goto -169 -> 79
    //   251: iconst_0
    //   252: istore_2
    //   253: goto -202 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	bdhk
    //   78	170	1	i1	int
    //   50	203	2	bool	boolean
    //   93	102	3	localIntent	Intent
    //   200	17	3	localException1	Exception
    //   242	1	3	localException2	Exception
    //   181	12	4	localSplashActivity	SplashActivity
    // Exception table:
    //   from	to	target	type
    //   21	51	200	java/lang/Exception
    //   51	79	242	java/lang/Exception
  }
  
  private boolean W()
  {
    return true;
  }
  
  private boolean X()
  {
    return true;
  }
  
  private boolean Y()
  {
    return true;
  }
  
  private boolean Z()
  {
    Intent localIntent2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
    String str = localIntent2.getStringExtra("uin");
    Intent localIntent1;
    long l2;
    long l1;
    if (bdeu.b(str))
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
      int i1 = Math.min(482, bddf.a((Activity)this.jdField_a_of_type_AndroidContentContext));
      localIntent1.putExtra("Business_Origin", 100);
      localIntent1.putExtra("open_chatfragment", true);
      localIntent1.putExtra("open_chat_from_avator", true);
      PhotoUtils.a(localIntent1, (Activity)this.jdField_a_of_type_AndroidContentContext, SplashActivity.class.getName(), i1, i1, 1080, 1080, str, bddf.a());
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800723E", "0X800723E", 0, 0, "", "", "", "");
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
        break label59;
      }
      QLog.e("JumpAction", 2, "makeStoryContentPageIntent, NumberFormatException, shareFromStr:" + paramMap);
    }
    return 0;
    label59:
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
      paramString = new String(bdfr.decode(paramString, 0));
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
            ((bfzp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str1, paramInt1, paramInt2);
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
        break label236;
      }
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "params must be decrypted");
        }
        paramString = bdfr.decode(new Cryptor().decrypt(bdhe.a(paramString), "Hf7K(s*js12LiskW".getBytes()), 0);
        if (paramString == null) {
          break label289;
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
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), "0X8004B50", "0X8004B50", 0, 0, "", "", "", "");
          }
        }
        return;
      }
      catch (JSONException paramIntent)
      {
        label236:
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
      label289:
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
    localHashSet1.add(Integer.valueOf(blat.a.a()));
    localHashSet1.add(Integer.valueOf(blat.n.a()));
    localHashSet1.add(Integer.valueOf(blat.t.a()));
    localHashSet1.add(Integer.valueOf(blat.w.a()));
    localHashSet1.add(Integer.valueOf(blat.b.a()));
    localHashSet1.add(Integer.valueOf(blat.u.a()));
    localHashSet1.add(Integer.valueOf(blat.c.a()));
    HashSet localHashSet2 = new HashSet();
    localHashSet2.add(Integer.valueOf(blat.g.a()));
    localHashSet2.add(Integer.valueOf(blat.q.a()));
    localHashSet2.add(Integer.valueOf(blat.r.a()));
    localHashSet2.add(Integer.valueOf(blat.o.a()));
    localHashSet2.add(Integer.valueOf(blat.s.a()));
    localHashSet2.add(Integer.valueOf(blat.v.a()));
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
    paramContext = aolx.b(250).a();
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
    //   4: ldc_w 1308
    //   7: invokevirtual 1311	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   10: ifne +14 -> 24
    //   13: aload_1
    //   14: ldc_w 1308
    //   17: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   20: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   23: pop
    //   24: ldc_w 1313
    //   27: aload_0
    //   28: getfield 1315	bdhk:m	Ljava/lang/String;
    //   31: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +467 -> 501
    //   37: iconst_1
    //   38: istore 8
    //   40: aload_1
    //   41: ldc_w 1317
    //   44: iload 8
    //   46: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   49: pop
    //   50: aload_0
    //   51: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   54: ifnull +346 -> 400
    //   57: aload_0
    //   58: getfield 1321	bdhk:jdField_h_of_type_Boolean	Z
    //   61: ifeq +339 -> 400
    //   64: aload_0
    //   65: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   68: getfield 1327	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   71: invokevirtual 1331	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   74: sipush 769
    //   77: if_icmpne +323 -> 400
    //   80: aload_0
    //   81: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   84: getfield 1334	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   87: invokevirtual 1331	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   90: istore 6
    //   92: aload_0
    //   93: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   96: ldc_w 1336
    //   99: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast 50	java/lang/String
    //   105: invokestatic 392	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: istore 4
    //   110: aload_0
    //   111: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: invokevirtual 1339	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   117: ldc_w 1341
    //   120: iconst_0
    //   121: invokevirtual 1345	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   124: astore 9
    //   126: aload 9
    //   128: new 219	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 1347
    //   138: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: invokevirtual 1350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   148: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: iconst_0
    //   155: invokeinterface 1355 3 0
    //   160: istore 7
    //   162: aload 9
    //   164: invokeinterface 1359 1 0
    //   169: new 219	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 1347
    //   179: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_0
    //   183: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   186: invokevirtual 1350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   189: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: iconst_0
    //   196: invokeinterface 1364 3 0
    //   201: invokeinterface 1367 1 0
    //   206: pop
    //   207: aload_0
    //   208: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   211: getfield 1371	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   214: invokevirtual 1375	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   217: ifeq +310 -> 527
    //   220: new 341	org/json/JSONObject
    //   223: dup
    //   224: aload_0
    //   225: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   228: getfield 1371	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   231: invokevirtual 1377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   234: invokespecial 353	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   237: astore 9
    //   239: aload_0
    //   240: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   243: getfield 1381	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   246: invokevirtual 1384	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   249: ifeq +278 -> 527
    //   252: aload_0
    //   253: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   256: getfield 1381	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   259: invokevirtual 1385	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   262: ifne +265 -> 527
    //   265: ldc_w 523
    //   268: aload 9
    //   270: ldc_w 1387
    //   273: invokevirtual 1391	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   276: aload_0
    //   277: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   280: getfield 1381	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   283: iconst_0
    //   284: invokevirtual 1392	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   287: checkcast 50	java/lang/String
    //   290: invokevirtual 1391	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   293: ldc_w 1394
    //   296: invokevirtual 1161	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   299: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: istore 8
    //   304: iload 8
    //   306: ifeq +221 -> 527
    //   309: aload_1
    //   310: ldc_w 1396
    //   313: iload 5
    //   315: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   318: pop
    //   319: aload_1
    //   320: ldc_w 1398
    //   323: iload 6
    //   325: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   328: pop
    //   329: aload_1
    //   330: ldc_w 1400
    //   333: iload 7
    //   335: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   338: pop
    //   339: aload_1
    //   340: ldc_w 1402
    //   343: iload 4
    //   345: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   348: pop
    //   349: aload_0
    //   350: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   353: getfield 1381	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   356: invokevirtual 1384	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   359: ifeq +41 -> 400
    //   362: aload_0
    //   363: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   366: getfield 1381	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   369: invokevirtual 1385	com/tencent/mobileqq/pb/PBRepeatField:isEmpty	()Z
    //   372: ifne +28 -> 400
    //   375: aload_1
    //   376: ldc_w 1404
    //   379: new 1040	java/util/ArrayList
    //   382: dup
    //   383: aload_0
    //   384: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   387: getfield 1381	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   390: invokevirtual 1407	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   393: invokespecial 1410	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   396: invokevirtual 1414	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   399: pop
    //   400: aload_1
    //   401: ldc_w 1416
    //   404: aload_0
    //   405: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   408: invokevirtual 1350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   411: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   414: pop
    //   415: aload_1
    //   416: ldc_w 1418
    //   419: iconst_1
    //   420: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   423: pop
    //   424: aload_1
    //   425: ldc_w 1420
    //   428: iconst_1
    //   429: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   432: pop
    //   433: aload_1
    //   434: ldc_w 1422
    //   437: aload_0
    //   438: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   441: invokevirtual 1350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   444: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   447: pop
    //   448: aload_1
    //   449: ldc_w 1424
    //   452: ldc_w 1426
    //   455: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   458: pop
    //   459: aload_0
    //   460: aload_1
    //   461: invokespecial 1428	bdhk:a	(Landroid/content/Intent;)V
    //   464: aload_1
    //   465: aload_0
    //   466: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   469: aload_2
    //   470: invokevirtual 1431	android/content/Intent:setClassName	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    //   473: pop
    //   474: aload_0
    //   475: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   478: aload_1
    //   479: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   482: ldc_w 1433
    //   485: aload_3
    //   486: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   489: ifne +44 -> 533
    //   492: aload_0
    //   493: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   496: invokestatic 1439	cooperation/qwallet/plugin/QWalletHelper:preloadQWallet	(Lcom/tencent/common/app/AppInterface;)V
    //   499: iconst_1
    //   500: ireturn
    //   501: iconst_0
    //   502: istore 8
    //   504: goto -464 -> 40
    //   507: astore 9
    //   509: aload 9
    //   511: invokevirtual 545	java/lang/Exception:printStackTrace	()V
    //   514: iconst_0
    //   515: istore 4
    //   517: goto -407 -> 110
    //   520: astore 9
    //   522: aload 9
    //   524: invokevirtual 545	java/lang/Exception:printStackTrace	()V
    //   527: iconst_1
    //   528: istore 5
    //   530: goto -221 -> 309
    //   533: new 1441	com/tencent/mobileqq/utils/JumpAction$24
    //   536: dup
    //   537: aload_0
    //   538: invokespecial 1442	com/tencent/mobileqq/utils/JumpAction$24:<init>	(Lbdhk;)V
    //   541: iconst_5
    //   542: aconst_null
    //   543: iconst_1
    //   544: invokestatic 1445	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   547: iconst_1
    //   548: ireturn
    //   549: astore_1
    //   550: iconst_1
    //   551: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	bdhk
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
        uqn.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), str2);
      } else {
        uqn.a(paramActivity, Integer.valueOf(paramHashMap).intValue(), Long.valueOf(paramQQAppInterface).longValue());
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
          vod.b(paramActivity, str2, paramQQAppInterface, i2);
          return true;
          i2 = 1;
          break;
        case 1: 
          if ("17".equals(str3)) {
            wxj.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = str1;
          if (str1 == null) {
            paramQQAppInterface = "JUMP_ACTION_EMPTY_FEED_ID";
          }
          i2 = i1;
          if (i1 == 0) {
            i2 = 7;
          }
          vod.b(paramActivity, str2, paramQQAppInterface, i2);
          return true;
        case 2: 
          if ("17".equals(str3)) {
            wxj.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", str2 });
          }
          paramQQAppInterface = (String)paramHashMap.get("et");
          paramQQAppInterface = (String)paramHashMap.get("time_zone");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            Integer.valueOf(paramQQAppInterface).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            vod.a(paramActivity, str6, str1, 1, 109, 1, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            vod.a(paramActivity, str5, str1, 1, 109, 1, null);
          }
          return false;
        case 3: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 30;
          }
          vod.a(paramActivity, str2, str1, i2);
          return true;
        case 4: 
          paramQQAppInterface = (String)paramHashMap.get("collection_id");
          paramHashMap = (String)paramHashMap.get("time_zone");
          i3 = -1;
          if (!TextUtils.isEmpty(paramHashMap)) {
            i3 = Integer.valueOf(paramHashMap).intValue();
          }
          if (!TextUtils.isEmpty(str6)) {
            vod.a(paramActivity, str6, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str6), i3, i1, str1, i2, null);
          }
          for (;;)
          {
            return true;
            if (TextUtils.isEmpty(str5)) {
              break;
            }
            vod.a(paramActivity, str5, VideoCollectionEntry.getCollectionKey(1, paramQQAppInterface, str5), i3, i1, str1, i2, null);
          }
          return false;
        case 7: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 19;
          }
          vod.b(paramActivity, str2, str1, i2);
          return true;
        case 6: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 57;
          }
          vod.b(paramActivity, str2, str1, i2);
          return true;
        case 5: 
          vod.a(paramActivity, str6, str1, i2, i1, 0, null);
          return true;
        case 8: 
          i2 = i1;
          if (i1 == 0) {
            i2 = 90;
          }
          vod.b(paramActivity, str2, str1, i2);
          return true;
        case 9: 
          a(paramHashMap, "time_zone", -1);
          i2 = i1;
          if (i1 == 0) {
            i2 = 96;
          }
          vod.a(paramActivity, str1, i2);
          return true;
        case 10: 
          paramQQAppInterface = (String)paramHashMap.get("bannerID");
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            vod.a(paramActivity, new OpenPlayerBuilder(new DiscoverBannerPlayInfo(paramQQAppInterface), 102).a());
          }
          return true;
        case 0: 
          return b(paramQQAppInterface, paramActivity, paramHashMap, paramString);
        }
      }
    }
  }
  
  private boolean a(Runnable paramRunnable, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_Boolean = false;
    ThreadManagerV2.executeOnSubThread(new JumpAction.7(this, paramString1, System.currentTimeMillis(), paramString2, paramString3, paramRunnable));
    return true;
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
                paramString = new bdhp(this);
                localBundle.putBoolean("key_require_storage_permission", paramBoolean);
                if ((i3 == 5) && ((i2 & 0x1) != 0)) {
                  bjev.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localBundle, paramString, 23);
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
                      bfhz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str1, String.valueOf(l1), "11", "12", "0", paramString, "0", "0", false);
                      label858:
                      paramString = new bjdn();
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
                      azri.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramString, null);
                      if ((!this.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
                        ((JumpActivity)this.jdField_a_of_type_AndroidContentContext).finish();
                      }
                      return true;
                      bjev.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localBundle, paramString);
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
          uqn.a(this.jdField_a_of_type_AndroidContentContext, 23, str3);
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
        localObject2 = new bdho(this);
        bjev.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, (DialogInterface.OnDismissListener)localObject2);
        localObject2 = new bjdn();
        ((bjdn)localObject2).c = "1";
        ((bjdn)localObject2).jdField_d_of_type_JavaLangString = "0";
        ((bjdn)localObject2).jdField_b_of_type_Int = 4;
        ((bjdn)localObject2).l = "5";
        ((bjdn)localObject2).m = "thirdApp";
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("source_type", "5");
        ((HashMap)localObject3).put("source_from", "thirdApp");
        localObject1 = ((Bundle)localObject1).getStringArrayList("images");
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 9))
        {
          ((bjdn)localObject2).n = "QZoneUploadPhotosActivity";
          ((HashMap)localObject3).put("source_to", "QZoneUploadPhotosActivity");
          QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (bjdn)localObject2);
          azri.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject3, null);
          bfhz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", l1 + "", "11", "12", "0", str, "", "4", false);
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
              ((bjdn)localObject2).n = "QZonePublishMoodActivity";
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
  
  /* Error */
  private boolean aA()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 1855
    //   7: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +327 -> 337
    //   13: aload_0
    //   14: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   17: ldc_w 1855
    //   20: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 50	java/lang/String
    //   26: astore 12
    //   28: aload_0
    //   29: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   32: ldc_w 1857
    //   35: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   38: ifeq +306 -> 344
    //   41: aload_0
    //   42: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   45: ldc_w 1857
    //   48: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 50	java/lang/String
    //   54: astore 11
    //   56: lconst_0
    //   57: lstore 5
    //   59: aload_0
    //   60: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   63: ldc_w 1859
    //   66: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   69: ifeq +1262 -> 1331
    //   72: ldc_w 778
    //   75: aload_0
    //   76: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   79: ldc_w 1859
    //   82: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq +1243 -> 1331
    //   91: iconst_1
    //   92: istore 9
    //   94: lload 5
    //   96: lstore 7
    //   98: aload_0
    //   99: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   102: ldc_w 1861
    //   105: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   108: ifeq +24 -> 132
    //   111: aload_0
    //   112: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   115: ldc_w 1861
    //   118: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: checkcast 50	java/lang/String
    //   124: invokestatic 147	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   127: invokevirtual 150	java/lang/Long:longValue	()J
    //   130: lstore 7
    //   132: aload_0
    //   133: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   136: ldc_w 1863
    //   139: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   142: ifeq +238 -> 380
    //   145: aload_0
    //   146: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   149: ldc_w 1863
    //   152: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: checkcast 50	java/lang/String
    //   158: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   161: invokevirtual 800	java/lang/Integer:intValue	()I
    //   164: istore_1
    //   165: aload_0
    //   166: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   169: ldc_w 1865
    //   172: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   175: ifeq +210 -> 385
    //   178: aload_0
    //   179: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   182: ldc_w 1865
    //   185: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   188: checkcast 50	java/lang/String
    //   191: astore 13
    //   193: aload 13
    //   195: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: istore 10
    //   200: iload 10
    //   202: ifeq +190 -> 392
    //   205: lconst_0
    //   206: lstore 5
    //   208: aload_0
    //   209: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   212: ldc 177
    //   214: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   217: ifeq +196 -> 413
    //   220: aload_0
    //   221: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   224: ldc 177
    //   226: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   229: checkcast 50	java/lang/String
    //   232: astore 13
    //   234: aload 13
    //   236: invokestatic 392	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   239: istore_2
    //   240: aload_0
    //   241: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   244: ldc_w 1867
    //   247: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   250: ifeq +177 -> 427
    //   253: aload_0
    //   254: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   257: ldc_w 1867
    //   260: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   263: checkcast 50	java/lang/String
    //   266: astore 13
    //   268: aload 13
    //   270: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   273: invokevirtual 800	java/lang/Integer:intValue	()I
    //   276: istore_3
    //   277: aload_0
    //   278: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   281: ldc_w 1869
    //   284: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   287: ifeq +154 -> 441
    //   290: aload_0
    //   291: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   294: ldc_w 1869
    //   297: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   300: checkcast 50	java/lang/String
    //   303: astore 13
    //   305: aload 13
    //   307: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   310: invokevirtual 800	java/lang/Integer:intValue	()I
    //   313: istore 4
    //   315: iload_3
    //   316: iconst_1
    //   317: if_icmpeq +140 -> 457
    //   320: iload_3
    //   321: iconst_2
    //   322: if_icmpeq +135 -> 457
    //   325: iload_3
    //   326: iconst_3
    //   327: if_icmpeq +130 -> 457
    //   330: iload_3
    //   331: iconst_4
    //   332: if_icmpeq +125 -> 457
    //   335: iconst_0
    //   336: ireturn
    //   337: ldc 61
    //   339: astore 12
    //   341: goto -313 -> 28
    //   344: ldc 61
    //   346: astore 11
    //   348: goto -292 -> 56
    //   351: astore 13
    //   353: ldc 217
    //   355: iconst_1
    //   356: ldc_w 1871
    //   359: invokestatic 587	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: lload 5
    //   364: lstore 7
    //   366: goto -234 -> 132
    //   369: astore 13
    //   371: ldc 217
    //   373: iconst_1
    //   374: ldc_w 1873
    //   377: invokestatic 587	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: iconst_0
    //   381: istore_1
    //   382: goto -217 -> 165
    //   385: ldc 61
    //   387: astore 13
    //   389: goto -196 -> 193
    //   392: aload 13
    //   394: invokestatic 147	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   397: invokevirtual 150	java/lang/Long:longValue	()J
    //   400: lstore 5
    //   402: goto -194 -> 208
    //   405: astore 13
    //   407: lconst_0
    //   408: lstore 5
    //   410: goto -202 -> 208
    //   413: ldc 61
    //   415: astore 13
    //   417: goto -183 -> 234
    //   420: astore 13
    //   422: iconst_0
    //   423: istore_2
    //   424: goto -184 -> 240
    //   427: ldc 61
    //   429: astore 13
    //   431: goto -163 -> 268
    //   434: astore 13
    //   436: iconst_m1
    //   437: istore_3
    //   438: goto -161 -> 277
    //   441: ldc_w 523
    //   444: astore 13
    //   446: goto -141 -> 305
    //   449: astore 13
    //   451: iconst_0
    //   452: istore 4
    //   454: goto -139 -> 315
    //   457: new 291	android/content/Intent
    //   460: dup
    //   461: aload_0
    //   462: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   465: ldc_w 1875
    //   468: invokespecial 296	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   471: astore 15
    //   473: aload 15
    //   475: ldc_w 1877
    //   478: iload 4
    //   480: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   483: pop
    //   484: aload 15
    //   486: ldc_w 1879
    //   489: iload 9
    //   491: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   494: pop
    //   495: aload 15
    //   497: ldc_w 1861
    //   500: lload 7
    //   502: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   505: pop
    //   506: aload 15
    //   508: ldc_w 1881
    //   511: iload_1
    //   512: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   515: pop
    //   516: iload_3
    //   517: tableswitch	default:+31 -> 548, 1:+33->550, 2:+33->550, 3:+436->953, 4:+693->1210
    //   549: ireturn
    //   550: aload_0
    //   551: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   554: ifnull +106 -> 660
    //   557: aload_0
    //   558: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   561: invokevirtual 1731	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   564: astore 11
    //   566: aload 12
    //   568: ldc_w 1883
    //   571: invokestatic 1886	bdeu:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   574: ifeq +360 -> 934
    //   577: aload_0
    //   578: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   581: ldc_w 1888
    //   584: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   587: ifeq +92 -> 679
    //   590: aload_0
    //   591: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   594: ldc_w 1888
    //   597: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   600: checkcast 50	java/lang/String
    //   603: astore 13
    //   605: aload_0
    //   606: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   609: ldc_w 1890
    //   612: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   615: ifeq +71 -> 686
    //   618: aload_0
    //   619: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   622: ldc_w 1890
    //   625: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   628: checkcast 50	java/lang/String
    //   631: astore 14
    //   633: aload 13
    //   635: aload 11
    //   637: invokestatic 1886	bdeu:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   640: ifne +53 -> 693
    //   643: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq +12 -> 658
    //   649: ldc 217
    //   651: iconst_2
    //   652: ldc_w 1892
    //   655: invokestatic 587	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: iconst_1
    //   659: ireturn
    //   660: aload_0
    //   661: getfield 1894	bdhk:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   664: ifnull +660 -> 1324
    //   667: aload_0
    //   668: getfield 1894	bdhk:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   671: invokevirtual 1897	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   674: astore 11
    //   676: goto -110 -> 566
    //   679: ldc 61
    //   681: astore 13
    //   683: goto -78 -> 605
    //   686: ldc 61
    //   688: astore 14
    //   690: goto -57 -> 633
    //   693: aload 15
    //   695: ldc_w 1890
    //   698: aload 14
    //   700: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   703: pop
    //   704: aload 15
    //   706: ldc_w 1899
    //   709: iconst_m1
    //   710: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   713: pop
    //   714: aload 15
    //   716: ldc_w 554
    //   719: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   722: pop
    //   723: new 1901	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   726: dup
    //   727: aload 11
    //   729: iconst_0
    //   730: invokespecial 1903	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   733: astore 11
    //   735: iload_2
    //   736: iconst_1
    //   737: if_icmpne +30 -> 767
    //   740: aload 15
    //   742: ldc_w 1899
    //   745: bipush 12
    //   747: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   750: pop
    //   751: aload 11
    //   753: bipush 86
    //   755: putfield 1904	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   758: aload 15
    //   760: ldc_w 657
    //   763: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   766: pop
    //   767: iload_2
    //   768: iconst_2
    //   769: if_icmpne +19 -> 788
    //   772: aload 11
    //   774: bipush 87
    //   776: putfield 1904	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   779: aload 15
    //   781: ldc_w 657
    //   784: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   787: pop
    //   788: iload_2
    //   789: iconst_3
    //   790: if_icmpne +19 -> 809
    //   793: aload 11
    //   795: bipush 88
    //   797: putfield 1904	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   800: aload 15
    //   802: ldc_w 657
    //   805: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   808: pop
    //   809: iload_2
    //   810: bipush 7
    //   812: if_icmplt +29 -> 841
    //   815: aload 15
    //   817: ldc_w 1899
    //   820: iload_2
    //   821: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   824: pop
    //   825: aload 11
    //   827: bipush 86
    //   829: putfield 1904	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   832: aload 15
    //   834: ldc_w 657
    //   837: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   840: pop
    //   841: aload 15
    //   843: ldc_w 1906
    //   846: iload_3
    //   847: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   850: pop
    //   851: aload 15
    //   853: ldc_w 1908
    //   856: aload 11
    //   858: invokevirtual 1911	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   861: pop
    //   862: aload 12
    //   864: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   867: ifne +80 -> 947
    //   870: aload 12
    //   872: ldc_w 1913
    //   875: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   878: ifeq +69 -> 947
    //   881: iconst_1
    //   882: istore 9
    //   884: aload 15
    //   886: ldc_w 1915
    //   889: iload 9
    //   891: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   894: pop
    //   895: sipush 10002
    //   898: iload_2
    //   899: if_icmpne +12 -> 911
    //   902: aload 15
    //   904: ldc_w 657
    //   907: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   910: pop
    //   911: aload 15
    //   913: ldc_w 1917
    //   916: lload 5
    //   918: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   921: pop
    //   922: aload_0
    //   923: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   926: aload 15
    //   928: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   931: goto -383 -> 548
    //   934: aload 15
    //   936: ldc_w 1919
    //   939: iconst_1
    //   940: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   943: pop
    //   944: goto -221 -> 723
    //   947: iconst_0
    //   948: istore 9
    //   950: goto -66 -> 884
    //   953: aload_0
    //   954: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   957: ldc 131
    //   959: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   962: ifeq +41 -> 1003
    //   965: aload_0
    //   966: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   969: ldc 131
    //   971: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   974: checkcast 50	java/lang/String
    //   977: astore 12
    //   979: lload 5
    //   981: lconst_0
    //   982: lcmp
    //   983: ifne +27 -> 1010
    //   986: aload 12
    //   988: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   991: ifeq +19 -> 1010
    //   994: lload 7
    //   996: lconst_0
    //   997: lcmp
    //   998: ifne +12 -> 1010
    //   1001: iconst_0
    //   1002: ireturn
    //   1003: ldc 61
    //   1005: astore 12
    //   1007: goto -28 -> 979
    //   1010: aload 15
    //   1012: ldc_w 1906
    //   1015: iconst_3
    //   1016: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1019: pop
    //   1020: aload 15
    //   1022: ldc_w 1917
    //   1025: lload 5
    //   1027: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1030: pop
    //   1031: sipush 10002
    //   1034: iload_2
    //   1035: if_icmpne +12 -> 1047
    //   1038: aload 15
    //   1040: ldc_w 657
    //   1043: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1046: pop
    //   1047: aload 15
    //   1049: ldc_w 1919
    //   1052: iconst_1
    //   1053: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1056: pop
    //   1057: aload 15
    //   1059: ldc_w 1921
    //   1062: aload 11
    //   1064: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1067: pop
    //   1068: new 1901	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   1071: dup
    //   1072: aload 12
    //   1074: bipush 19
    //   1076: invokespecial 1903	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   1079: astore 11
    //   1081: iload_2
    //   1082: iconst_1
    //   1083: if_icmpne +30 -> 1113
    //   1086: aload 15
    //   1088: ldc_w 1899
    //   1091: bipush 12
    //   1093: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1096: pop
    //   1097: aload 11
    //   1099: bipush 86
    //   1101: putfield 1904	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1104: aload 15
    //   1106: ldc_w 657
    //   1109: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1112: pop
    //   1113: iload_2
    //   1114: iconst_2
    //   1115: if_icmpne +19 -> 1134
    //   1118: aload 11
    //   1120: bipush 87
    //   1122: putfield 1904	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1125: aload 15
    //   1127: ldc_w 657
    //   1130: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1133: pop
    //   1134: iload_2
    //   1135: iconst_3
    //   1136: if_icmpne +19 -> 1155
    //   1139: aload 11
    //   1141: bipush 88
    //   1143: putfield 1904	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1146: aload 15
    //   1148: ldc_w 657
    //   1151: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1154: pop
    //   1155: iload_2
    //   1156: bipush 7
    //   1158: if_icmplt +29 -> 1187
    //   1161: aload 15
    //   1163: ldc_w 1899
    //   1166: iload_2
    //   1167: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1170: pop
    //   1171: aload 11
    //   1173: bipush 86
    //   1175: putfield 1904	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1178: aload 15
    //   1180: ldc_w 657
    //   1183: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1186: pop
    //   1187: aload 15
    //   1189: ldc_w 1908
    //   1192: aload 11
    //   1194: invokevirtual 1911	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1197: pop
    //   1198: aload_0
    //   1199: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1202: aload 15
    //   1204: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1207: goto -659 -> 548
    //   1210: ldc 61
    //   1212: astore 11
    //   1214: aload_0
    //   1215: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1218: ifnull +87 -> 1305
    //   1221: aload_0
    //   1222: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1225: invokevirtual 1731	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1228: astore 11
    //   1230: new 1901	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   1233: dup
    //   1234: aload 11
    //   1236: iconst_0
    //   1237: invokespecial 1903	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   1240: astore 11
    //   1242: aload 15
    //   1244: ldc_w 1919
    //   1247: iconst_1
    //   1248: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1251: pop
    //   1252: aload 15
    //   1254: ldc_w 1906
    //   1257: iload_3
    //   1258: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1261: pop
    //   1262: aload 15
    //   1264: ldc_w 1908
    //   1267: aload 11
    //   1269: invokevirtual 1911	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1272: pop
    //   1273: aload 15
    //   1275: ldc_w 657
    //   1278: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1281: pop
    //   1282: aload 15
    //   1284: ldc_w 1917
    //   1287: lload 5
    //   1289: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1292: pop
    //   1293: aload_0
    //   1294: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1297: aload 15
    //   1299: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1302: goto -754 -> 548
    //   1305: aload_0
    //   1306: getfield 1894	bdhk:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1309: ifnull -79 -> 1230
    //   1312: aload_0
    //   1313: getfield 1894	bdhk:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1316: invokevirtual 1897	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1319: astore 11
    //   1321: goto -91 -> 1230
    //   1324: ldc 61
    //   1326: astore 11
    //   1328: goto -762 -> 566
    //   1331: iconst_0
    //   1332: istore 9
    //   1334: goto -1240 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1337	0	this	bdhk
    //   164	348	1	i1	int
    //   239	928	2	i2	int
    //   276	982	3	i3	int
    //   313	166	4	i4	int
    //   57	1231	5	l1	long
    //   96	899	7	l2	long
    //   92	1241	9	bool1	boolean
    //   198	3	10	bool2	boolean
    //   54	1273	11	localObject	Object
    //   26	1047	12	str1	String
    //   191	115	13	str2	String
    //   351	1	13	localException1	Exception
    //   369	1	13	localException2	Exception
    //   387	6	13	str3	String
    //   405	1	13	localException3	Exception
    //   415	1	13	str4	String
    //   420	1	13	localException4	Exception
    //   429	1	13	str5	String
    //   434	1	13	localException5	Exception
    //   444	1	13	str6	String
    //   449	1	13	localException6	Exception
    //   603	79	13	str7	String
    //   631	68	14	str8	String
    //   471	827	15	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   111	132	351	java/lang/Exception
    //   145	165	369	java/lang/Exception
    //   165	193	405	java/lang/Exception
    //   193	200	405	java/lang/Exception
    //   392	402	405	java/lang/Exception
    //   208	234	420	java/lang/Exception
    //   234	240	420	java/lang/Exception
    //   240	268	434	java/lang/Exception
    //   268	277	434	java/lang/Exception
    //   277	305	449	java/lang/Exception
    //   305	315	449	java/lang/Exception
  }
  
  private boolean aB()
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
      label38:
      break label38;
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
        localObject1 = new swr();
        ((swr)localObject1).a(new ProfileParams.CurLoginUsr((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"), (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_uin"))).d((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name")).c((String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id")).a((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin")).a(i1).b((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
        syb.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((swr)localObject1).a());
        return false;
      }
    }
    else
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("source", 117);
      syb.a((Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, i1);
      PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_5", "addpage_hot");
    }
    return true;
  }
  
  private boolean aC()
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
    syb.a(null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str, -7);
    return true;
  }
  
  private boolean aD()
  {
    try
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      long l1 = Long.parseLong(str1);
      if (l1 < 10000L)
      {
        if (!QLog.isColorLevel()) {
          break label298;
        }
        QLog.i("JumpAction", 2, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard invalid uin uin: %d", new Object[] { Long.valueOf(l1) }));
        return false;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("name");
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
      localFriends = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(str1);
      if (!bdeu.a(str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label232;
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
        label232:
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
      QLog.i("JumpAction", 4, String.format(Locale.getDefault(), "gotoAllPeopleVoteCard uin: %s  name: %s source: %s", new Object[] { bdeu.b(str1), bdeu.b(str2), str3 }));
      return false;
    }
    label298:
    return false;
  }
  
  private boolean aE()
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
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007014", "0X8007014", 0, 0, "", "", "", "");
      localObject1 = new ProfileActivity.AllInOne((String)localObject1, 53);
      ((ProfileActivity.AllInOne)localObject1).k = URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname"));
      ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 105;
      localObject2 = new Bundle();
      localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type");
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!a((String)localObject3))) {
        break label680;
      }
    }
    label680:
    for (int i1 = Integer.valueOf((String)localObject3).intValue();; i1 = 0)
    {
      if ((i1 > 0) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msg_uniseq")))
      {
        localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("msg_uniseq");
        if ((i1 == 100) && (bdeu.b((String)localObject3)))
        {
          ((Bundle)localObject2).putBoolean("from_babyq", true);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007241", "0X8007241", 0, 0, "", "", "", "");
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
      localObject3 = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e((String)localObject1);
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
  
  private boolean aF()
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
          break label178;
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
      label178:
      do
      {
        return bool;
      } while (str.length() < 5);
      if (((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(str)) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
  
  private boolean aG()
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
        break label268;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label268;
      }
    }
    label268:
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
      localObject2 = new bkcp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
  
  private boolean aH()
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
        break label304;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label304;
      }
    }
    label304:
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
      ((Intent)localObject1).putExtra("key_is_update_before_805", bcpx.a(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new bkcp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
  
  private boolean aI()
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
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bfzo);
              ((bfzp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str2);
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
            break label674;
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
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007245", "0X8007245", 0, 0, "", "", "", "");
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
        bcpx.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject1, 2);
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
          label674:
          if (i1 != 43) {
            break;
          }
          ((Bundle)localObject2).putInt("troop_info_from", 27);
        }
      }
    }
  }
  
  private boolean aJ()
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
    bcpx.a(this.jdField_a_of_type_AndroidContentContext, (Bundle)localObject, 2);
    return true;
  }
  
  /* Error */
  private boolean aK()
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
    //   21: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   24: ldc_w 834
    //   27: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 50	java/lang/String
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   38: ldc_w 2233
    //   41: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 50	java/lang/String
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   52: ldc 131
    //   54: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 50	java/lang/String
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   65: ldc_w 2235
    //   68: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 50	java/lang/String
    //   74: astore 4
    //   76: aload 18
    //   78: astore 12
    //   80: aload 10
    //   82: astore 7
    //   84: aload 17
    //   86: astore 5
    //   88: aload 19
    //   90: astore 15
    //   92: aload 14
    //   94: astore 11
    //   96: aload 18
    //   98: astore 13
    //   100: aload 10
    //   102: astore 8
    //   104: aload 17
    //   106: astore 6
    //   108: aload 19
    //   110: astore 16
    //   112: aload_0
    //   113: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   116: ldc_w 2237
    //   119: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   122: checkcast 50	java/lang/String
    //   125: ldc_w 2239
    //   128: invokestatic 2241	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 9
    //   133: aload 18
    //   135: astore 12
    //   137: aload 10
    //   139: astore 7
    //   141: aload 17
    //   143: astore 5
    //   145: aload 19
    //   147: astore 15
    //   149: aload 9
    //   151: astore 11
    //   153: aload 18
    //   155: astore 13
    //   157: aload 10
    //   159: astore 8
    //   161: aload 17
    //   163: astore 6
    //   165: aload 19
    //   167: astore 16
    //   169: aload 9
    //   171: astore 14
    //   173: aload_0
    //   174: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   177: ldc_w 2243
    //   180: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   183: checkcast 50	java/lang/String
    //   186: ldc_w 2239
    //   189: invokestatic 2241	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   192: astore 19
    //   194: aload 18
    //   196: astore 12
    //   198: aload 10
    //   200: astore 7
    //   202: aload 17
    //   204: astore 5
    //   206: aload 19
    //   208: astore 15
    //   210: aload 9
    //   212: astore 11
    //   214: aload 18
    //   216: astore 13
    //   218: aload 10
    //   220: astore 8
    //   222: aload 17
    //   224: astore 6
    //   226: aload 19
    //   228: astore 16
    //   230: aload 9
    //   232: astore 14
    //   234: aload_0
    //   235: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   238: ldc_w 2245
    //   241: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   244: checkcast 50	java/lang/String
    //   247: ldc_w 2239
    //   250: invokestatic 2241	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   253: astore 17
    //   255: aload 18
    //   257: astore 12
    //   259: aload 10
    //   261: astore 7
    //   263: aload 17
    //   265: astore 5
    //   267: aload 19
    //   269: astore 15
    //   271: aload 9
    //   273: astore 11
    //   275: aload 18
    //   277: astore 13
    //   279: aload 10
    //   281: astore 8
    //   283: aload 17
    //   285: astore 6
    //   287: aload 19
    //   289: astore 16
    //   291: aload 9
    //   293: astore 14
    //   295: aload_0
    //   296: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   299: ldc_w 2247
    //   302: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   305: checkcast 50	java/lang/String
    //   308: ldc_w 2239
    //   311: invokestatic 2241	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   314: astore 10
    //   316: aload 18
    //   318: astore 12
    //   320: aload 10
    //   322: astore 7
    //   324: aload 17
    //   326: astore 5
    //   328: aload 19
    //   330: astore 15
    //   332: aload 9
    //   334: astore 11
    //   336: aload 18
    //   338: astore 13
    //   340: aload 10
    //   342: astore 8
    //   344: aload 17
    //   346: astore 6
    //   348: aload 19
    //   350: astore 16
    //   352: aload 9
    //   354: astore 14
    //   356: aload_0
    //   357: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   360: ldc_w 2249
    //   363: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   366: checkcast 50	java/lang/String
    //   369: ldc_w 2239
    //   372: invokestatic 2241	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   375: astore 18
    //   377: aload 18
    //   379: astore 12
    //   381: aload 10
    //   383: astore 7
    //   385: aload 17
    //   387: astore 5
    //   389: aload 19
    //   391: astore 15
    //   393: aload 9
    //   395: astore 11
    //   397: aload 18
    //   399: astore 13
    //   401: aload 10
    //   403: astore 8
    //   405: aload 17
    //   407: astore 6
    //   409: aload 19
    //   411: astore 16
    //   413: aload 9
    //   415: astore 14
    //   417: aload_0
    //   418: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   421: ldc_w 2251
    //   424: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   427: checkcast 50	java/lang/String
    //   430: ldc_w 2239
    //   433: invokestatic 2241	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   436: astore 20
    //   438: aload_1
    //   439: astore 7
    //   441: aload 20
    //   443: astore_1
    //   444: aload 17
    //   446: astore 8
    //   448: aload_2
    //   449: astore 6
    //   451: aload 18
    //   453: astore_2
    //   454: aload 10
    //   456: astore 5
    //   458: aload 9
    //   460: astore 11
    //   462: aload 19
    //   464: astore 9
    //   466: aload_3
    //   467: astore 10
    //   469: aload 6
    //   471: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   474: ifne +11 -> 485
    //   477: aload 7
    //   479: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   482: ifeq +129 -> 611
    //   485: iconst_0
    //   486: ireturn
    //   487: astore 9
    //   489: ldc 61
    //   491: astore 10
    //   493: ldc 61
    //   495: astore_1
    //   496: ldc 61
    //   498: astore_3
    //   499: ldc 61
    //   501: astore 6
    //   503: ldc 61
    //   505: astore 5
    //   507: ldc 61
    //   509: astore 4
    //   511: ldc 61
    //   513: astore 8
    //   515: ldc 61
    //   517: astore 7
    //   519: ldc 61
    //   521: astore_2
    //   522: aload 9
    //   524: invokevirtual 1100	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   527: aload 8
    //   529: astore 9
    //   531: aload 5
    //   533: astore 8
    //   535: aload_2
    //   536: astore 5
    //   538: aload_1
    //   539: astore_2
    //   540: ldc 61
    //   542: astore_1
    //   543: aload_3
    //   544: astore 11
    //   546: goto -77 -> 469
    //   549: astore 9
    //   551: ldc 61
    //   553: astore 10
    //   555: ldc 61
    //   557: astore_1
    //   558: ldc 61
    //   560: astore_3
    //   561: ldc 61
    //   563: astore 6
    //   565: ldc 61
    //   567: astore 5
    //   569: ldc 61
    //   571: astore 4
    //   573: ldc 61
    //   575: astore 8
    //   577: ldc 61
    //   579: astore 7
    //   581: ldc 61
    //   583: astore_2
    //   584: aload 9
    //   586: invokevirtual 2252	java/lang/NullPointerException:printStackTrace	()V
    //   589: aload 8
    //   591: astore 9
    //   593: aload 5
    //   595: astore 8
    //   597: aload_2
    //   598: astore 5
    //   600: aload_1
    //   601: astore_2
    //   602: ldc 61
    //   604: astore_1
    //   605: aload_3
    //   606: astore 11
    //   608: goto -139 -> 469
    //   611: aload_0
    //   612: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   615: ifnull +171 -> 786
    //   618: new 291	android/content/Intent
    //   621: dup
    //   622: aload_0
    //   623: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   626: ldc_w 2254
    //   629: invokespecial 296	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   632: astore_3
    //   633: aload_3
    //   634: ldc_w 2256
    //   637: aload 7
    //   639: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   642: pop
    //   643: aload_3
    //   644: ldc_w 2258
    //   647: new 219	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   654: ldc 61
    //   656: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 6
    //   661: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   670: pop
    //   671: ldc_w 2260
    //   674: aload 10
    //   676: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   679: ifeq +139 -> 818
    //   682: aload_3
    //   683: ldc_w 2262
    //   686: iconst_0
    //   687: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   690: pop
    //   691: new 116	android/os/Bundle
    //   694: dup
    //   695: invokespecial 117	android/os/Bundle:<init>	()V
    //   698: astore 6
    //   700: aload 6
    //   702: ldc_w 2233
    //   705: aload 4
    //   707: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   710: aload 6
    //   712: ldc_w 2237
    //   715: aload 11
    //   717: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: aload 6
    //   722: ldc_w 2243
    //   725: aload 9
    //   727: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: aload 6
    //   732: ldc_w 2245
    //   735: aload 8
    //   737: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   740: aload 6
    //   742: ldc_w 2247
    //   745: aload 5
    //   747: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   750: aload 6
    //   752: ldc_w 2249
    //   755: aload_2
    //   756: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   759: aload 6
    //   761: ldc_w 2251
    //   764: aload_1
    //   765: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   768: aload_3
    //   769: ldc_w 336
    //   772: aload 6
    //   774: invokevirtual 736	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
    //   777: pop
    //   778: aload_0
    //   779: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   782: aload_3
    //   783: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   786: aload_0
    //   787: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   790: ldc_w 1175
    //   793: ldc 61
    //   795: ldc 61
    //   797: ldc_w 2264
    //   800: ldc_w 2264
    //   803: iconst_0
    //   804: iconst_0
    //   805: ldc 61
    //   807: ldc 61
    //   809: ldc 61
    //   811: ldc 61
    //   813: invokestatic 577	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   816: iconst_1
    //   817: ireturn
    //   818: aload_3
    //   819: ldc_w 2262
    //   822: bipush 6
    //   824: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   827: pop
    //   828: goto -137 -> 691
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
    //   873: goto -289 -> 584
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
    //   913: goto -329 -> 584
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
    //   952: goto -368 -> 584
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
    //   999: goto -415 -> 584
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
    //   1044: goto -522 -> 522
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
    //   1084: goto -562 -> 522
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
    //   1123: goto -601 -> 522
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
    //   1158: goto -636 -> 522
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1161	0	this	bdhk
    //   47	1087	1	localObject1	Object
    //   60	1080	2	localObject2	Object
    //   33	1121	3	localObject3	Object
    //   74	1028	4	localObject4	Object
    //   86	1057	5	localObject5	Object
    //   106	1051	6	localObject6	Object
    //   82	1048	7	localObject7	Object
    //   102	1048	8	localObject8	Object
    //   131	334	9	str1	String
    //   487	36	9	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   529	1	9	localObject9	Object
    //   549	36	9	localNullPointerException1	java.lang.NullPointerException
    //   591	135	9	localObject10	Object
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
    //   94	1061	11	localObject14	Object
    //   78	910	12	localObject15	Object
    //   98	1034	13	str2	String
    //   2	1150	14	localObject16	Object
    //   90	868	15	str3	String
    //   110	1038	16	str4	String
    //   10	435	17	str5	String
    //   18	434	18	str6	String
    //   6	457	19	str7	String
    //   436	6	20	str8	String
    // Exception table:
    //   from	to	target	type
    //   20	34	487	java/io/UnsupportedEncodingException
    //   20	34	549	java/lang/NullPointerException
    //   34	48	831	java/lang/NullPointerException
    //   48	61	876	java/lang/NullPointerException
    //   61	76	916	java/lang/NullPointerException
    //   112	133	955	java/lang/NullPointerException
    //   173	194	955	java/lang/NullPointerException
    //   234	255	955	java/lang/NullPointerException
    //   295	316	955	java/lang/NullPointerException
    //   356	377	955	java/lang/NullPointerException
    //   417	438	955	java/lang/NullPointerException
    //   34	48	1002	java/io/UnsupportedEncodingException
    //   48	61	1047	java/io/UnsupportedEncodingException
    //   61	76	1087	java/io/UnsupportedEncodingException
    //   112	133	1126	java/io/UnsupportedEncodingException
    //   173	194	1126	java/io/UnsupportedEncodingException
    //   234	255	1126	java/io/UnsupportedEncodingException
    //   295	316	1126	java/io/UnsupportedEncodingException
    //   356	377	1126	java/io/UnsupportedEncodingException
    //   417	438	1126	java/io/UnsupportedEncodingException
  }
  
  private boolean aL()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("troopuin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      return false;
    }
    awrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str1, str2, 9, -1);
    return true;
  }
  
  private boolean aM()
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
  
  private boolean aN()
  {
    if ("webview".equals(this.m))
    {
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bus_type");
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "photo").putExtra("doCallBack", true).putExtra("src_type", this.jdField_f_of_type_JavaLangString).putExtra("callback_type", this.jdField_g_of_type_JavaLangString).putExtra("callback_name", this.jdField_h_of_type_JavaLangString));
    }
    return true;
  }
  
  private boolean aO()
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
    adpn.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
    return true;
  }
  
  private boolean aP()
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
    adpn.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
    return true;
  }
  
  private boolean aQ()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BindGroupActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("skey", ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label162:
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (!str2.equals("src_type")) {}
      for (String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get(str2));; str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2))
      {
        if (TextUtils.isEmpty(str1)) {
          break label162;
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
  
  private boolean aR()
  {
    System.currentTimeMillis();
    Object localObject3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if ((localObject3 == null) || ((!((String)localObject3).startsWith("http://")) && (!((String)localObject3).startsWith("https://"))) || ((!ndq.b((String)localObject3).equalsIgnoreCase("qq.com")) && (!ndq.b((String)localObject3).equalsIgnoreCase("myun.tenpay.com")) && (!ndq.b((String)localObject3).equalsIgnoreCase("tenpay.com")) && (!ndq.b((String)localObject3).equalsIgnoreCase("wanggou.com")) && (!ndq.b((String)localObject3).equalsIgnoreCase("tencent.com")) && (!ndq.b((String)localObject3).equalsIgnoreCase("jd.com")) && (!ndq.b((String)localObject3).equalsIgnoreCase("qcloud.com")) && (!ndq.b((String)localObject3).equalsIgnoreCase("webank.com")) && (!ndq.b((String)localObject3).equalsIgnoreCase("qqumall.com")))) {
      return false;
    }
    if ((((String)localObject3).startsWith("https://jiazhang.qq.com/wap/com/")) || (((String)localObject3).startsWith("https://test.jiazhang.qq.com/wap/com/")))
    {
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey("openid")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))))
      {
        QLog.e("JumpAction", 1, "empty params");
        return false;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"), "");
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
        break label2266;
      }
      localStringBuffer.append("plg_auth=1");
      localStringBuffer.append("&");
    }
    label2124:
    label2266:
    for (int i1 = 1;; i1 = 0)
    {
      if ("1".equals(str3))
      {
        localStringBuffer.append("plg_dev=1");
        localStringBuffer.append("&");
        localStringBuffer.append("MOBINFO=");
        localStringBuffer.append(bdhe.a(((Cryptor)localObject3).encrypt(b().getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
        localStringBuffer.append("&");
        i1 = 1;
      }
      if ("1".equals(str4))
      {
        localStringBuffer.append("plg_usr=1");
        localStringBuffer.append("&");
        localStringBuffer.append("USER=");
        localStringBuffer.append(bdhe.a(((Cryptor)localObject3).encrypt(alud.a(2131706300).getBytes(), "4eY#X@~g.+U)2%$<".getBytes())));
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
        localObject1 = bhsz.b(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
        if (!TextUtils.isEmpty((String)((Map)localObject1).get("storysharefrom")))
        {
          this.jdField_a_of_type_JavaUtilHashMap.putAll((Map)localObject1);
          if (this.jdField_a_of_type_JavaUtilHashMap.get("type") == null) {
            this.c = "opencontent";
          }
          for (;;)
          {
            return I();
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
        localObject1 = bhsz.b(((String)localObject1).substring(((String)localObject1).indexOf("?") + 1));
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
            return I();
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
          if (auet.a((Activity)this.jdField_a_of_type_AndroidContentContext, localException1, (Bundle)localObject3)) {
            return true;
          }
        }
      }
      Object localObject2;
      if ((this.n == null) || (!this.n.trim().equalsIgnoreCase("com.tx.android.txnews.new"))) {
        if ((this.n != null) && (this.n.trim().equalsIgnoreCase("com.qq.yijianfankui")))
        {
          localStringBuffer.append("&version=8.3.5.4555");
          localStringBuffer.append("&appid=" + AppSetting.a());
          localStringBuffer.append("&QUA=" + bjdm.a());
          localStringBuffer.append("&adtag=4555");
          localObject2 = Build.MODEL;
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            i1 = azri.a();
            localObject3 = localObject2;
            if (i1 > 0) {
              localObject3 = (String)localObject2 + "_qzpatch" + i1;
            }
            localObject2 = Build.MANUFACTURER;
            if (localObject2 == null) {
              break label2124;
            }
            localObject2 = ((String)localObject2).replaceAll(" ", "_");
            localStringBuffer.append("&model=").append((String)localObject3).append("&manufacture=").append((String)localObject2).append("&cpunum=").append(bdgk.b()).append("&cpurate=").append(bdgk.a()).append("&mem=").append(bdgk.d() / 1024L / 1024L).append("&w=").append(bdgk.g()).append("&h=").append(bdgk.h());
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
  
  private boolean aS()
  {
    aseh.a();
    aseh.a("KEY_STAGE_1_TOTAL");
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
      ThreadManagerV2.executeOnSubThread(new JumpAction.16(this, str3, System.currentTimeMillis(), (HashMap)localObject));
      return false;
    }
    aseh.a("KEY_STAGE_1_SAVE_IMAGE", 0L, (HashMap)localObject, false);
    return aT();
  }
  
  private boolean aT()
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
    label693:
    label1236:
    label1242:
    label1263:
    String str2;
    label1277:
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
      boolean bool = asdt.a();
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
            break label1277;
          }
          localObject1 = new Intent();
          if (!bool) {
            break label693;
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
            localBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131696875, new Object[] { str1 }));
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
              if ((i1 == 5) && (asdt.b()))
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
                  break label1236;
                }
                bool = true;
                localBundle.putBoolean("k_send", bool);
                localBundle.putInt("iUrlInfoFrm", 4);
                if (aopb.e()) {
                  ((asdm)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(350)).a().a(str5, l1, this.n);
                }
                if (localObject1 == null) {
                  break label1263;
                }
                if (!MiniProgramOpenSdkUtil.isSharingMiniProgram(this.jdField_a_of_type_JavaUtilHashMap)) {
                  break label1242;
                }
                MiniProgramOpenSdkUtil.forwardShareWithTryCatch(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, localBundle, (Intent)localObject1);
                return true;
                localBundle.putString("brief_key", this.jdField_a_of_type_AndroidContentContext.getString(2131696875, new Object[] { str8 }));
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
              aryv.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1);
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
  
  private boolean aU()
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
  
  private boolean aV()
  {
    Object localObject;
    String str2;
    bjea localbjea;
    String str1;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)))
    {
      localObject = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("page_id");
      if (str2 != null)
      {
        localbjea = bjea.a();
        localbjea.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localbjea.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
        str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
        SessionInfo localSessionInfo = ((FragmentActivity)localObject).getChatFragment().a().a();
        if ((localSessionInfo != null) && (!TextUtils.isEmpty(localSessionInfo.jdField_a_of_type_JavaLangString))) {
          ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).e(localSessionInfo.jdField_a_of_type_JavaLangString, true);
        }
        if (!str2.equalsIgnoreCase("11")) {
          break label166;
        }
        bjdt.b((Activity)this.jdField_a_of_type_AndroidContentContext, localbjea, str1, "mqqChat.QzoneCard", -1);
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
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, "缺少相册id", 1).a();
        } else {
          bjdt.a((Activity)this.jdField_a_of_type_AndroidContentContext, localbjea, (String)localObject, str2, str1, "mqqChat.QzoneCard", -1);
        }
      }
    }
  }
  
  private boolean aW()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.a(localIntent, "com.qzone.common.activities.QzoneDialogActivity");
    localIntent.addFlags(805306368);
    bjdt.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localIntent, -1);
    return true;
  }
  
  private boolean aX()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      if (!bjvd.a().b(this.n, this.jdField_a_of_type_JavaLangString))
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
        tlv.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_h_of_type_Boolean);
        tch.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_h_of_type_Boolean, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          return true;
          str = (String)bhsz.a(this.jdField_a_of_type_JavaLangString).get("schema");
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
  
  private boolean aY()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return false;
    }
    long l1 = bill.a();
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
  
  private boolean aZ()
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
              bivo.a((AppRuntime)localObject8, "User_SdkShare", i2, 0, 0, 0, str1, (String)localObject6);
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
                    ((Bundle)localObject8).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131698482), new Object[] { localObject1 }));
                  }
                }
                else
                {
                  com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_f_of_type_Boolean = true;
                  localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, DirectForwardActivity.class);
                  ((Intent)localObject1).putExtra("toUin", alof.L);
                  ((Intent)localObject1).putExtra("uinType", 0);
                  if (1 != i1) {
                    break label1692;
                  }
                  ((Intent)localObject1).putExtra("qqfav_extra_from_system_share", true);
                  ((Intent)localObject1).putExtras((Bundle)localObject8);
                  aryv.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, DirectForwardActivity.class);
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
              ((Bundle)localObject8).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131698483));
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
                  bivs.a(this.jdField_a_of_type_AndroidContentContext, 2131698480, 1);
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
                  ((Bundle)localObject8).putString("title", ((ArrayList)localObject10).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131694912));
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
                    ((Bundle)localObject8).putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131698482), new Object[] { localObject1 }));
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
                ((Bundle)localObject8).putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131698483));
                continue;
              }
              bivs.a(this.jdField_a_of_type_AndroidContentContext, 2131698480, 1);
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
  
  private boolean aa()
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
  
  private boolean ab()
  {
    String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("set_uri"));
    QLog.d("JumpAction", 1, new Object[] { "-->gotoSDKSetAvator setUri=", str1 });
    if (!TextUtils.isEmpty(str1)) {
      return a(new JumpAction.5(this), str1, "set_uri", "set_path");
    }
    str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
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
  
  private boolean ac()
  {
    String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_uri"));
    QLog.d("JumpAction", 1, new Object[] { "-->gotoSDKSetDynamicAvatar videoUri=", str1 });
    if (!TextUtils.isEmpty(str1)) {
      return a(new JumpAction.6(this), str1, "video_uri", "video_path");
    }
    str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("share_id");
    String str3 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("video_path"));
    String str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("sdk_version"));
    if (QLog.isColorLevel()) {
      QLog.d("JumpAction", 2, new Object[] { "[gotoSDKSetDynamicAvatar] appName=", str1 });
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DF9", "0X8009DF9", 0, 0, str2, "", "", "");
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
  
  private boolean ad()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, RecommendFriendActivity.class);
    localIntent.putExtra("EntranceId", 7);
    localIntent.putExtra("from_babyq", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007243", "0X8007243", 0, 0, "", "", "", "");
    return true;
  }
  
  private boolean ae()
  {
    Intent localIntent = new Intent();
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, SearchMightKnowFragment.class);
    return true;
  }
  
  private boolean af()
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
  
  private boolean ag()
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
  
  private boolean ah()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ContactBindedActivity.class);
    localIntent.putExtra("from_babyq", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean ai()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("uin")) {}
    for (String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"); !str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()); str = "")
    {
      h();
      return false;
    }
    i();
    return false;
  }
  
  private boolean aj()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("leftBackText", alud.a(2131706302));
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
  
  private boolean ak()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      return false;
    }
    QWalletHelper.launchQWalletAct((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false);
    return true;
  }
  
  private boolean al()
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
  
  private boolean am()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app_type");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_id");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("src_id");
    String str4 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_id"));
    String str5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_path"));
    String str6 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("mini_app_type"));
    String str7 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("app_name"));
    String str1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("open_id"));
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A519", "0X800A519", 0, 0, "", "", str4, str2);
    if (TextUtils.isEmpty(this.n))
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc01160", "", "", "0X800A51B", "0X800A51B", 0, 0, "", "", str4, str2);
      QLog.e("JumpAction", 1, "connectMiniApp fail: packageName is empty");
      return true;
    }
    if ("mini_program_or_game".equals(localObject))
    {
      if (!bdin.d(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131699940, 1).a();
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
        this.jdField_d_of_type_Boolean = true;
        boolean bool;
        MessageHandler localMessageHandler;
        if (!TextUtils.isEmpty(str1))
        {
          bool = true;
          aseh.a("KEY_STAGE_2_CONNECT_MINI_D55");
          localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (str1 != null) {
            break label441;
          }
        }
        label441:
        for (localObject = "";; localObject = str1)
        {
          localMessageHandler.a(bool, (String)localObject, true, Long.valueOf(str2).longValue(), Long.valueOf(str4).longValue(), 1, Integer.valueOf(str3).intValue(), this.n, false, 0L, new bdhm(this, str4, str2, str5, str6, str1, str7));
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
  
  private boolean an()
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
      localObject1 = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
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
      if (((alto)localObject1).b(str2))
      {
        localObject3 = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
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
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007191", "0X8007191", 0, 0, "", "", "", "");
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
      localObject4 = aepi.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
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
            localObject3 = bdgc.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
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
            if (((alto)localObject1).b(str2)) {
              i1 = 0;
            }
            for (localObject1 = bdgc.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);; localObject1 = null)
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
            boolean bool2 = ar();
            bool1 = bool2;
            if (!bool2) {
              bool1 = ao();
            }
            bool2 = bool1;
            if (!bool1) {
              bool2 = ap();
            }
            bool1 = bool2;
            if (bool2) {
              break;
            }
            return aq();
          }
          if (("lbs".equals(localObject3)) || ("date".equals(localObject3)))
          {
            if ((str2 == null) || (str2.length() < 5) || (str2.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              return false;
            }
            if (((alto)localObject1).b(str2))
            {
              i1 = 0;
              localObject3 = bdgc.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
              localObject2 = null;
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject2 != null) && (localObject4 != null))
        {
          localObject1 = bdhe.a((String)localObject4);
          break;
          if ("lbs".equals(localObject3))
          {
            i1 = 1001;
            localObject3 = bdgc.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            localObject2 = "rich_accost_sig";
          }
          else
          {
            i1 = 1010;
            localObject3 = bdgc.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
            localObject2 = "rich_date_sig";
            continue;
            if ("public_account".equals(localObject3))
            {
              if ((str2 == null) || (str2.length() < 6)) {
                return false;
              }
              localObject1 = syb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2);
              nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", str2, "0X800589E", "0X800589E", 0, 0, str2, "", "", "", false);
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
              localObject1 = aepi.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
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
              if (!bdin.d(this.jdField_a_of_type_AndroidContentContext))
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131699927, 1).a();
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
                    aseh.a("KEY_STAGE_2_GO_TO_CHAT_D55");
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, str9, false, 0L, Long.valueOf(str10).longValue(), 1, i1, str11, false, 0L, new bdhn(this, str9, str10, (String)localObject3));
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
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B4B", "0X8004B4B", 0, 0, "", "", "", "");
            if ("webview".equals(this.m))
            {
              ((Intent)localObject4).putExtra("from", this.m);
              if (jdField_a_of_type_Int > 3)
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, alud.a(2131706285), 1).a();
                return true;
              }
              jdField_a_of_type_Int += 1;
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B5A", "0X8004B5A", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              if (str3 != null) {
                ((Intent)localObject4).putExtra("panel", str3);
              }
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject4);
              return true;
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", str2, "0X8004B58", "0X8004B58", 0, 0, "", "", "", "");
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
  
  private boolean ao()
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
          break label529;
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
            break label394;
          }
          if (str7.length() < 5) {
            break label569;
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
        localIntent.putExtra("sigt", bdhe.a(str6));
      }
      if (((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(str7))
      {
        localIntent.putExtra("uintype", 0);
        localIntent.putExtra("uinname", bdgc.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str7));
        label375:
        localIntent.putExtra("uin", str7);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
      for (;;)
      {
        for (;;)
        {
          label394:
          ((bfzp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str4, localException1, str3, str2, (String)localObject, str5, this.jdField_a_of_type_Bfzo.jdField_a_of_type_Int);
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
            label529:
            bool1 = true;
          }
        }
        localIntent.putExtra("uintype", 1025);
        localIntent.putExtra("from_wpa_for_crm", true);
        break label375;
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "handleQidianExtWPA wpaType != 2");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bfzo);
      }
      break;
    }
    label569:
    return false;
  }
  
  private boolean ap()
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bfzo);
          ((bfzp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85)).a(str5, str2, str1, str3, str4, str6);
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
  
  private boolean aq()
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
      i1 = ndv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "handleLegacyCrmWPA " + i1);
      }
      localIntent.putExtra("from_wpa_for_crm", true);
      localIntent.putExtra("uin", str1);
      localIntent.putExtra("uintype", i1);
      if (i1 != 0) {
        break label401;
      }
      str4 = bdgc.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
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
        localObject = bdhe.a(str3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str1, (byte[])localObject);
      }
      if (str2 != null) {
        localIntent.putExtra("sigt", bdhe.a(str2));
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Bqq_Crm", "", "Bqq_Crm", "Bqq_wpaaio_create", 0, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str1, "", "");
      return true;
      localIntent.setComponent(new ComponentName(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class));
      localIntent.putExtra("open_chatfragment", true);
      break;
      label401:
      if (i1 == 1024) {
        localIntent.putExtra("chat_subType", 1);
      }
    }
  }
  
  private boolean ar()
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
  
  private boolean as()
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
      localIntent = aepi.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", 1);
      if (localObject != null) {
        localIntent.putExtra("uinname", (String)localObject);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    return aI();
  }
  
  private boolean at()
  {
    if (QLog.isColorLevel()) {
      auwz.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
  
  private boolean au()
  {
    bbpf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return true;
  }
  
  private boolean av()
  {
    if ((String)this.jdField_a_of_type_JavaUtilHashMap.get("back_title") == null) {
      alud.a(2131706301);
    }
    bbqu localbbqu = (bbqu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if (localbbqu != null) {
      localbbqu.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 0);
    }
    return true;
  }
  
  private boolean aw()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.putExtra("account", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = bdgc.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
  private boolean ax()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   4: ldc_w 3422
    //   7: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 50	java/lang/String
    //   13: astore 6
    //   15: aload_0
    //   16: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: ldc_w 3424
    //   22: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 50	java/lang/String
    //   28: astore 7
    //   30: aload 6
    //   32: ifnull +139 -> 171
    //   35: aload 7
    //   37: ifnull +134 -> 171
    //   40: aload 6
    //   42: invokevirtual 2498	java/lang/String:trim	()Ljava/lang/String;
    //   45: invokestatic 392	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   48: i2d
    //   49: ldc2_w 3454
    //   52: ddiv
    //   53: dstore_1
    //   54: aload 7
    //   56: invokevirtual 2498	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 392	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: istore 5
    //   64: iload 5
    //   66: i2d
    //   67: ldc2_w 3454
    //   70: ddiv
    //   71: dstore_3
    //   72: aload_0
    //   73: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   76: ldc_w 1632
    //   79: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 50	java/lang/String
    //   85: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   88: pop
    //   89: new 219	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 3457
    //   99: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: dload_3
    //   103: invokevirtual 3460	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   106: ldc_w 3462
    //   109: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: dload_1
    //   113: invokevirtual 3460	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   116: ldc_w 3464
    //   119: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore 6
    //   127: new 291	android/content/Intent
    //   130: dup
    //   131: ldc_w 3466
    //   134: aload 6
    //   136: invokestatic 1607	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   139: invokespecial 3469	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   142: astore 7
    //   144: aload 7
    //   146: ldc_w 3471
    //   149: ldc_w 3473
    //   152: invokevirtual 1260	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: aload_0
    //   157: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   160: aload 7
    //   162: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   165: iconst_1
    //   166: ireturn
    //   167: astore 6
    //   169: iconst_0
    //   170: ireturn
    //   171: iconst_0
    //   172: ireturn
    //   173: astore 7
    //   175: aload_0
    //   176: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   179: new 291	android/content/Intent
    //   182: dup
    //   183: ldc_w 3466
    //   186: aload 6
    //   188: invokestatic 1607	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   191: invokespecial 3469	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   194: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   197: goto -32 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	bdhk
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
  
  private boolean ay()
  {
    if ("webview".equals(this.m))
    {
      a((String)this.jdField_a_of_type_JavaUtilHashMap.get("title"));
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).putExtra("action", "select_location").putExtra("doCallBack", true).putExtra("src_type", this.jdField_f_of_type_JavaLangString).putExtra("callback_type", this.jdField_g_of_type_JavaLangString).putExtra("callback_name", this.jdField_h_of_type_JavaLangString));
    }
    return true;
  }
  
  private boolean az()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("card_type");
    if (QSecFramework.a().a(1003).booleanValue())
    {
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
      bfav.a().a(5, str1, 0, str2);
      bfav.a().a();
    }
    if ((str1 != null) && ("group".equals(str1)))
    {
      a(10010, a());
      return aI();
    }
    if ("groupsearchsetting".equalsIgnoreCase(str1)) {
      return aG();
    }
    if ("groupmanager".equalsIgnoreCase(str1)) {
      return aH();
    }
    if ("public_account".equals(str1))
    {
      a(10003, a());
      return aB();
    }
    if ("troopmember".equals(str1)) {
      return aK();
    }
    if ("crm".equals(str1)) {
      return aC();
    }
    if ("nearby".equals(str1)) {
      return aA();
    }
    if ("allpeoplevote".equals(str1)) {
      return aD();
    }
    if ("troopmemberfromhb".equals(str1)) {
      return aL();
    }
    a(10002, a());
    return aE();
  }
  
  private Intent b()
  {
    ((uvo)uwa.a(18)).a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    return localIntent;
  }
  
  private String b()
  {
    String str1 = Build.VERSION.RELEASE;
    String str2 = Build.MODEL;
    String str3 = bhsp.a("0db4c4");
    String str4 = bhsp.b("0db4c4");
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
          break label706;
        }
        i2 = 1;
        if ((str5 == null) || (!str5.equals("myonedaylist"))) {
          break label712;
        }
        i4 = 1;
        if (!"0".equals(paramHashMap.get("identify"))) {
          break label718;
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
            wxj.a("mystory", "clk_obj_myday", 0, 0, new String[] { "", "", "", paramQQAppInterface });
          }
          for (;;)
          {
            if (i4 == 0) {
              break label467;
            }
            paramString = (String)paramHashMap.get("collection_id");
            if (!TextUtils.isEmpty(paramString)) {
              break;
            }
            i2 = i1;
            if (i1 == 0) {
              i2 = 30;
            }
            vod.a(paramActivity, paramQQAppInterface, str2, i2);
            break label704;
            label285:
            wxj.a("mystory", "clk_obj", 0, 0, new String[] { "", "", "", paramQQAppInterface });
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
          vod.a(paramActivity, str4, VideoCollectionEntry.getCollectionKey(1, paramString, str4), i2, i1, str2, i3, null);
          break label704;
        }
        if (TextUtils.isEmpty(str3)) {
          break label724;
        }
        vod.a(paramActivity, str3, VideoCollectionEntry.getCollectionKey(1, paramString, str3), i2, i1, str2, i3, null);
        break label704;
        label467:
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
              vod.a(paramActivity, str4, str2, i3, i1, 0, null);
              break label726;
            }
            if (TextUtils.isEmpty(str3)) {
              break label728;
            }
            vod.a(paramActivity, str3, str2, i3, i1, 0, null);
            break label726;
          }
          if ((!TextUtils.isEmpty(str5)) && (str5.equals(String.valueOf(1))))
          {
            i2 = i1;
            if (i1 == 0) {
              i2 = 57;
            }
            vod.b(paramActivity, paramQQAppInterface, str2, i2);
            break label726;
          }
          if (!"onedaylist".equals(str5)) {
            break label730;
          }
          vod.a(paramActivity, str4, str2, i3, i1, 0, null);
          break label726;
          vod.b(paramActivity, paramQQAppInterface, str2, i2);
          break label726;
        }
        label643:
        if (TextUtils.isEmpty(paramString)) {
          break label746;
        }
        i2 = i1;
        if (i1 == 0) {
          i2 = 19;
        }
        vod.b(paramActivity, paramQQAppInterface, str2, i2);
        break label726;
      }
    }
    for (;;)
    {
      vod.b(paramActivity, paramQQAppInterface, paramHashMap, i2);
      break label726;
      break label130;
      break;
      label704:
      return true;
      label706:
      i2 = 0;
      break label149;
      label712:
      i4 = 0;
      break label168;
      label718:
      i3 = 1;
      break label187;
      label724:
      return false;
      label726:
      return true;
      label728:
      return false;
      label730:
      i2 = i1;
      if (i1 != 0) {
        break label643;
      }
      i2 = 17;
      break label643;
      label746:
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
  
  private boolean bB()
  {
    if (!TextUtils.isEmpty(c((String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api")))) {
      wxj.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      if ("1".equals((String)this.jdField_a_of_type_JavaUtilHashMap.get("to_new_version"))) {}
      return true;
    }
    return false;
  }
  
  private boolean bC()
  {
    Intent localIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_Boolean)
    {
      wxe.b("JumpAction", "startStoryMainActivity, isNowTabShow==true");
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
        wxe.e("JumpAction", "Error: context is not instanceof Activity, context is: " + String.valueOf(this.jdField_a_of_type_AndroidContentContext));
      }
      if (localIntent == null) {
        wxe.e("JumpAction", "Error: jumpIntent is null");
      }
      return false;
    }
    wxe.b("JumpAction", "startStoryMainActivity, isNowTabShow==false");
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
  
  private boolean bD()
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
          adpn.a(this.jdField_a_of_type_AndroidContentContext, localIntent, PublicTransFragmentActivity.class, TranslucentTRansferFragment.class);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096FF", "0X80096FF", 0, 0, "", "", "", "");
          return true;
          str = "";
          break;
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096FE", "0X80096FE", 0, 0, "", "", "", "");
        return true;
      }
    }
  }
  
  private boolean bE()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80077DE", "0X80077DE", 0, 0, (String)localObject, "", "", "");
    localObject = a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
    if (RegisterPhoneNumActivity.class == localObject) {
      localIntent.putExtra("key_report_extra_from", 5);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  private boolean bF()
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
      zdv.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, str2, str1, str3, i1, null);
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
  
  private boolean bG()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    if (bdnn.a(str)) {
      str = "0";
    }
    for (;;)
    {
      auur localauur = (auur)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppInterface().getManager(204);
      long l1 = Long.parseLong(str);
      localauur.a(l1, new bdhs(this, l1));
      return true;
    }
  }
  
  private boolean bH()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomcode");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isgroupcode");
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("backtype");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("open_type");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("extra");
    atad localatad = (atad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
    try
    {
      i1 = Integer.parseInt(str3);
      QLog.i("JumpAction", 1, "[goToGroupVideoPlugin], roomId:" + str1 + ",fromId:" + str2 + " isGroupCode:" + str3);
      localatad.a(this.jdField_a_of_type_AndroidContentContext, str1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), i1, "download", str2, str4, str5, str6);
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
  
  private boolean bI()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromid");
    localObject = (atad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
    QLog.i("JumpAction", 1, "[goToPreLoadGroupVideoPlugin]");
    ((atad)localObject).a(null, 10L);
    return true;
  }
  
  private boolean bJ()
  {
    ((babo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(362)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    return true;
  }
  
  private boolean bK()
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
      bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject);
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
        label155:
        break label155;
      }
      bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (String)localObject, str, i1);
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
                label305:
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
              break label305;
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
      localBundle.putString("selfSet_leftViewText", alud.a(2131706284));
      BulkSendMessageFragment.a((Activity)this.jdField_a_of_type_AndroidContentContext, localBundle);
    }
  }
  
  private boolean bL()
  {
    bety localbety = new bety(this.jdField_a_of_type_AndroidContentContext, 0, 2131558667, 17);
    localbety.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690291));
    localbety.getWindow().setDimAmount(0.0F);
    localbety.show();
    localbety.setCanceledOnTouchOutside(true);
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app");
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.e("JumpAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen jumpAction. appName=null");
    }
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("meta");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
    ArkAppCenter localArkAppCenter = (ArkAppCenter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(121);
    ArkAppMgr.getInstance().getAppPathByName(str1, str3, "0.0.0.1", "", new bdht(this, localbety, str3, str2, str1));
    return true;
  }
  
  private boolean bM()
  {
    atfz localatfz = (atfz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(338);
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
          localatfz.a(localNewTogetherRoomMessageData);
          return true;
          str1 = "0";
          break;
          str1 = "0";
          break label128;
        }
      }
    }
  }
  
  private boolean bN()
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
        break label314;
      }
      localObject1 = ((TroopManager)localObject1).b(str);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isAdmin())) {
        break label314;
      }
    }
    label314:
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
      ((Intent)localObject1).putExtra("key_is_update_before_805", bcpx.a(this.jdField_a_of_type_AndroidContentContext, "8.0.5"));
      ((Intent)localObject1).putExtra("troop_manage_from_jump_action", true);
      ((Intent)localObject1).putExtra("key_is_need_update_Group_info", true);
      Object localObject2 = new bkcp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    int i1 = Integer.valueOf(a((String)this.jdField_a_of_type_JavaUtilHashMap.get("req_type"))).intValue();
    if (i1 == 3)
    {
      str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_uri"));
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
    String str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("videoUri"));
    if (!TextUtils.isEmpty(str))
    {
      ThreadManagerV2.executeOnSubThread(new JumpAction.18(this, str));
      return true;
    }
    a(true);
    return true;
  }
  
  private boolean bb()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    String str3 = bjdm.a();
    bjev.a(this.jdField_a_of_type_AndroidContentContext, str1, null, 0, str2, str3);
    return true;
  }
  
  private boolean bc()
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
        bjdt.a((Activity)this.jdField_a_of_type_AndroidContentContext, bjea.a(), (Intent)localObject);
        return true;
      }
    }
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jfrom");
    if ((!TextUtils.isEmpty(str)) && (str.equals("login")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, alud.a(2131706287), 1).a();
      return true;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, alud.a(2131706297), 1).a();
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
      if (bhtb.e()) {
        ((Intent)localObject).addFlags(32768);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return true;
    }
  }
  
  private boolean bd()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, alud.a(2131706289), 1).a();
    return false;
  }
  
  private boolean be()
  {
    return true;
  }
  
  private boolean bf()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      bjea localbjea = bjea.a();
      localbjea.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localbjea.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      bjdt.a((Activity)this.jdField_a_of_type_AndroidContentContext, localbjea, -1);
      return true;
    }
    return false;
  }
  
  private boolean bg()
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(str))
        {
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          bjdt.a((Activity)this.jdField_a_of_type_AndroidContentContext, bjea.a(), str, 0, 0, 0);
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
  
  private boolean bh()
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
  
  private boolean bi()
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
  
  private boolean bj()
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
          ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131691329));
          ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131691700));
          ((Intent)localObject).putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131691701));
          ((Intent)localObject).putExtra("param_max", 99);
          ((Intent)localObject).setFlags(603979776);
          ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 1);
        }
      }
      do
      {
        return true;
        return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 3000, (String)localObject, true, true, this.jdField_a_of_type_Acln, localHashMap);
        if (str3.equals("single"))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("forward_type", 13);
          ((Intent)localObject).putExtra("fromWebXman", true);
          aryv.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 2);
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
      return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, true, bool, this.jdField_a_of_type_Acln, this.jdField_a_of_type_JavaUtilHashMap);
      return false;
    }
  }
  
  private boolean bk()
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
            break label761;
          }
          bool1 = true;
          if (i1 == 1006)
          {
            localObject2 = localObject5;
            if (!((String)localObject5).startsWith("+")) {
              localObject2 = "+" + (String)localObject5;
            }
            localObject3 = ((aufv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c((String)localObject2);
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
              return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, (String)localObject2, (String)localObject1, (String)localObject3, bool1, str1, bool2, true, this.jdField_a_of_type_Acln, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
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
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696210);
            }
            bool1 = true;
            bool2 = false;
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject5;
            continue;
          }
          i2 = bdgc.a(i1);
          if (i2 != -1) {
            continue;
          }
        }
        localObject4 = bdgc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, i1);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = localObject4;
          if (!((String)localObject1).equals(localObject4)) {}
        }
        else
        {
          localObject2 = bdgc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label739;
        }
        bool2 = true;
        localObject2 = localObject1;
        localObject4 = localObject5;
        continue;
        localObject4 = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, str1, i2, 0);
        continue;
      }
      return false;
      label739:
      boolean bool2 = true;
      Object localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject5;
      continue;
      label761:
      boolean bool1 = false;
    }
  }
  
  private boolean bl()
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
              bool2 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 1011, null, null, null, bool1, null, false, true, this.jdField_a_of_type_Acln, "from_internal", this.jdField_a_of_type_JavaUtilHashMap);
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
  
  private boolean bm()
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
  private boolean bn()
  {
    // Byte code:
    //   0: new 291	android/content/Intent
    //   3: dup
    //   4: ldc_w 3442
    //   7: invokespecial 3411	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   10: astore 14
    //   12: aload_0
    //   13: aload 14
    //   15: invokespecial 1428	bdhk:a	(Landroid/content/Intent;)V
    //   18: aconst_null
    //   19: astore 9
    //   21: aconst_null
    //   22: astore 8
    //   24: aconst_null
    //   25: astore 10
    //   27: aload_0
    //   28: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   31: invokevirtual 675	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   34: astore 12
    //   36: iconst_0
    //   37: istore_1
    //   38: ldc 61
    //   40: astore 11
    //   42: aload_0
    //   43: ldc_w 2421
    //   46: invokevirtual 953	bdhk:b	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 13
    //   51: aload 13
    //   53: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +14 -> 70
    //   59: aload 14
    //   61: ldc_w 2567
    //   64: aload 13
    //   66: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   69: pop
    //   70: aload_0
    //   71: ldc_w 4103
    //   74: invokevirtual 953	bdhk:b	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +62 -> 142
    //   83: aload 14
    //   85: ldc_w 2481
    //   88: invokestatic 2484	java/lang/System:nanoTime	()J
    //   91: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   94: pop
    //   95: aload 14
    //   97: ldc_w 1308
    //   100: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   103: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   106: pop
    //   107: aload 14
    //   109: ldc_w 1268
    //   112: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   115: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   118: pop
    //   119: aload 14
    //   121: ldc_w 2490
    //   124: iconst_1
    //   125: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   128: pop
    //   129: aload 14
    //   131: ldc_w 2488
    //   134: aload_0
    //   135: getfield 1321	bdhk:jdField_h_of_type_Boolean	Z
    //   138: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   141: pop
    //   142: aload 12
    //   144: invokeinterface 681 1 0
    //   149: astore 15
    //   151: aload 15
    //   153: invokeinterface 686 1 0
    //   158: ifeq +631 -> 789
    //   161: aload 15
    //   163: invokeinterface 690 1 0
    //   168: checkcast 692	java/util/Map$Entry
    //   171: astore 12
    //   173: aload 12
    //   175: invokeinterface 698 1 0
    //   180: checkcast 50	java/lang/String
    //   183: astore 13
    //   185: aload 12
    //   187: invokeinterface 695 1 0
    //   192: checkcast 50	java/lang/String
    //   195: astore 12
    //   197: aload 13
    //   199: ifnull -48 -> 151
    //   202: aload 12
    //   204: ifnull -53 -> 151
    //   207: ldc_w 4105
    //   210: aload 13
    //   212: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   238: goto +2755 -> 2993
    //   241: ldc_w 4107
    //   244: aload 13
    //   246: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq +22 -> 271
    //   252: aload 11
    //   254: astore 8
    //   256: aload 9
    //   258: astore 11
    //   260: aload 10
    //   262: astore 9
    //   264: aload 12
    //   266: astore 10
    //   268: goto +2725 -> 2993
    //   271: ldc_w 4109
    //   274: aload 13
    //   276: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   279: ifeq +57 -> 336
    //   282: ldc_w 778
    //   285: aload 12
    //   287: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   290: ifeq +2730 -> 3020
    //   293: aload 14
    //   295: ldc_w 3444
    //   298: aload_0
    //   299: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   302: invokevirtual 1350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   305: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
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
    //   333: goto +2660 -> 2993
    //   336: ldc_w 4111
    //   339: aload 13
    //   341: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   344: ifeq +89 -> 433
    //   347: ldc_w 778
    //   350: aload 12
    //   352: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   355: ifeq +2665 -> 3020
    //   358: aload_0
    //   359: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   362: invokevirtual 2799	com/tencent/mobileqq/app/QQAppInterface:getCurrentNickname	()Ljava/lang/String;
    //   365: astore 13
    //   367: aload 13
    //   369: astore 12
    //   371: aload 13
    //   373: invokestatic 3721	bdnn:a	(Ljava/lang/String;)Z
    //   376: ifeq +19 -> 395
    //   379: aload_0
    //   380: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   383: aload_0
    //   384: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   387: invokevirtual 1350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   390: invokestatic 3446	bdgc:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   393: astore 12
    //   395: aload 14
    //   397: ldc_w 2041
    //   400: aload 12
    //   402: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
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
    //   430: goto +2563 -> 2993
    //   433: ldc_w 2381
    //   436: aload 13
    //   438: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   441: ifeq +57 -> 498
    //   444: ldc_w 778
    //   447: aload 12
    //   449: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   452: ifeq +2568 -> 3020
    //   455: aload 14
    //   457: ldc_w 4113
    //   460: aload_0
    //   461: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   464: invokevirtual 2413	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   467: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
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
    //   495: goto +2498 -> 2993
    //   498: ldc_w 4115
    //   501: aload 13
    //   503: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   506: ifeq +53 -> 559
    //   509: ldc_w 778
    //   512: aload 12
    //   514: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   517: ifeq +2503 -> 3020
    //   520: aload 14
    //   522: ldc_w 4117
    //   525: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   528: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
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
    //   556: goto +2437 -> 2993
    //   559: ldc_w 4119
    //   562: aload 13
    //   564: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   567: ifeq +90 -> 657
    //   570: ldc_w 778
    //   573: aload 12
    //   575: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   578: ifeq +2442 -> 3020
    //   581: aload 14
    //   583: ldc_w 4121
    //   586: aload_0
    //   587: getfield 4123	bdhk:jdField_g_of_type_Boolean	Z
    //   590: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   593: pop
    //   594: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +2423 -> 3020
    //   600: ldc_w 4125
    //   603: iconst_2
    //   604: new 219	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 4127
    //   614: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_0
    //   618: getfield 4123	bdhk:jdField_g_of_type_Boolean	Z
    //   621: invokevirtual 638	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   624: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 604	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   654: goto +2339 -> 2993
    //   657: ldc_w 4129
    //   660: aload 13
    //   662: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   665: ifeq +39 -> 704
    //   668: ldc_w 778
    //   671: aload 12
    //   673: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   676: ifeq +2344 -> 3020
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
    //   701: goto +2292 -> 2993
    //   704: ldc_w 4131
    //   707: aload 13
    //   709: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   739: goto +2254 -> 2993
    //   742: ldc_w 834
    //   745: aload 13
    //   747: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   773: goto +2220 -> 2993
    //   776: aload 14
    //   778: aload 13
    //   780: aload 12
    //   782: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   785: pop
    //   786: goto +2234 -> 3020
    //   789: aload 9
    //   791: ifnull +2256 -> 3047
    //   794: aload 8
    //   796: ifnull +2251 -> 3047
    //   799: ldc 61
    //   801: aload 9
    //   803: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   806: ifne +2241 -> 3047
    //   809: ldc 61
    //   811: aload 8
    //   813: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   816: ifeq +6 -> 822
    //   819: goto +2228 -> 3047
    //   822: aload_0
    //   823: getfield 4132	bdhk:jdField_a_of_type_Boolean	Z
    //   826: ifeq +22 -> 848
    //   829: invokestatic 4137	bdhz:a	()Lbdhz;
    //   832: aload_0
    //   833: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   836: aload 9
    //   838: aload 8
    //   840: invokevirtual 4140	bdhz:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   843: ifeq +5 -> 848
    //   846: iconst_0
    //   847: ireturn
    //   848: iconst_0
    //   849: istore 4
    //   851: iload 4
    //   853: istore_3
    //   854: aload 9
    //   856: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   859: ifne +38 -> 897
    //   862: getstatic 54	bdhk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
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
    //   889: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   892: ifeq +234 -> 1126
    //   895: iconst_1
    //   896: istore_3
    //   897: iload_3
    //   898: ifne +55 -> 953
    //   901: aload 14
    //   903: ldc_w 4113
    //   906: aconst_null
    //   907: checkcast 50	java/lang/String
    //   910: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   913: pop
    //   914: aload 14
    //   916: ldc_w 4142
    //   919: aconst_null
    //   920: checkcast 50	java/lang/String
    //   923: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   926: pop
    //   927: aload 14
    //   929: ldc_w 2041
    //   932: aconst_null
    //   933: checkcast 50	java/lang/String
    //   936: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   939: pop
    //   940: aload 14
    //   942: ldc_w 3444
    //   945: aconst_null
    //   946: checkcast 50	java/lang/String
    //   949: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   952: pop
    //   953: aload 8
    //   955: ldc_w 2725
    //   958: invokevirtual 2338	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   961: ifeq +112 -> 1073
    //   964: aload 14
    //   966: ldc_w 4144
    //   969: ldc_w 4146
    //   972: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   975: pop
    //   976: aload_0
    //   977: getfield 63	bdhk:r	Ljava/lang/String;
    //   980: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   983: ifne +16 -> 999
    //   986: aload 14
    //   988: ldc_w 4148
    //   991: aload_0
    //   992: getfield 63	bdhk:r	Ljava/lang/String;
    //   995: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   998: pop
    //   999: aload_0
    //   1000: getfield 65	bdhk:s	Ljava/lang/String;
    //   1003: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1006: ifne +16 -> 1022
    //   1009: aload 14
    //   1011: ldc_w 4150
    //   1014: aload_0
    //   1015: getfield 65	bdhk:s	Ljava/lang/String;
    //   1018: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1021: pop
    //   1022: aload_0
    //   1023: getfield 67	bdhk:t	Ljava/lang/String;
    //   1026: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1029: ifne +16 -> 1045
    //   1032: aload 14
    //   1034: ldc_w 4152
    //   1037: aload_0
    //   1038: getfield 67	bdhk:t	Ljava/lang/String;
    //   1041: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1044: pop
    //   1045: aload 14
    //   1047: ldc_w 4154
    //   1050: aload_0
    //   1051: getfield 4156	bdhk:jdField_i_of_type_Boolean	Z
    //   1054: invokevirtual 668	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1057: pop
    //   1058: aload 14
    //   1060: aload 8
    //   1062: invokestatic 4162	cooperation/qzone/report/lp/QZoneLoginReportHelper:needAddLoginFromLebaTab	(Landroid/content/Intent;Ljava/lang/String;)Z
    //   1065: ifeq +8 -> 1073
    //   1068: aload 14
    //   1070: invokestatic 4165	cooperation/qzone/report/lp/QZoneLoginReportHelper:setLoginFromLebaTab	(Landroid/content/Intent;)V
    //   1073: iload_1
    //   1074: ifne +1875 -> 2949
    //   1077: aload 8
    //   1079: ldc_w 2725
    //   1082: invokevirtual 2338	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1085: ifeq +104 -> 1189
    //   1088: aload 14
    //   1090: aload 8
    //   1092: invokestatic 2844	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1095: aload 14
    //   1097: ldc_w 659
    //   1100: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1103: pop
    //   1104: aload_0
    //   1105: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1108: checkcast 264	android/app/Activity
    //   1111: aload_0
    //   1112: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1115: invokevirtual 1350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1118: aload 14
    //   1120: iconst_m1
    //   1121: invokestatic 4168	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;I)V
    //   1124: iconst_1
    //   1125: ireturn
    //   1126: iload_2
    //   1127: iconst_1
    //   1128: iadd
    //   1129: istore_2
    //   1130: goto -256 -> 874
    //   1133: astore 8
    //   1135: new 291	android/content/Intent
    //   1138: dup
    //   1139: aload_0
    //   1140: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1143: ldc_w 4170
    //   1146: invokespecial 296	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1149: astore 8
    //   1151: aload 8
    //   1153: ldc_w 657
    //   1156: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1159: pop
    //   1160: aload 8
    //   1162: aload 14
    //   1164: invokevirtual 3948	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   1167: pop
    //   1168: aload_0
    //   1169: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1172: aload 8
    //   1174: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1177: goto -53 -> 1124
    //   1180: astore 8
    //   1182: aload 8
    //   1184: invokevirtual 4171	android/content/ActivityNotFoundException:printStackTrace	()V
    //   1187: iconst_0
    //   1188: ireturn
    //   1189: aload 8
    //   1191: ldc_w 4173
    //   1194: invokevirtual 2472	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1197: ifeq +60 -> 1257
    //   1200: aload_0
    //   1201: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1204: aload_0
    //   1205: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1208: invokestatic 3430	bbpf:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)V
    //   1211: aload_0
    //   1212: getfield 1321	bdhk:jdField_h_of_type_Boolean	Z
    //   1215: ifeq +1834 -> 3049
    //   1218: ldc_w 523
    //   1221: astore 8
    //   1223: aload_0
    //   1224: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1227: ldc_w 3281
    //   1230: ldc_w 4175
    //   1233: ldc 61
    //   1235: ldc_w 4177
    //   1238: ldc_w 4179
    //   1241: iconst_0
    //   1242: iconst_0
    //   1243: ldc 61
    //   1245: ldc 61
    //   1247: ldc 61
    //   1249: aload 8
    //   1251: invokestatic 577	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1254: goto -130 -> 1124
    //   1257: aload 8
    //   1259: ldc_w 4181
    //   1262: invokevirtual 2472	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1265: istore 6
    //   1267: iload 6
    //   1269: ifeq +233 -> 1502
    //   1272: aload_0
    //   1273: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1276: checkcast 2788	android/support/v4/app/FragmentActivity
    //   1279: invokevirtual 2805	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   1282: astore 9
    //   1284: aload 9
    //   1286: ifnull -162 -> 1124
    //   1289: aload 9
    //   1291: invokevirtual 2810	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1294: ifnull -170 -> 1124
    //   1297: aload 9
    //   1299: invokevirtual 2810	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1302: invokevirtual 4183	com/tencent/mobileqq/activity/BaseChatPie:aN	()V
    //   1305: aload 9
    //   1307: invokevirtual 2810	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   1310: getfield 4186	com/tencent/mobileqq/activity/BaseChatPie:a	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1313: getfield 4187	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   1316: istore_1
    //   1317: aload 14
    //   1319: ldc 131
    //   1321: aload_0
    //   1322: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1325: invokevirtual 1350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1328: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1331: pop
    //   1332: aload 14
    //   1334: ldc_w 4189
    //   1337: iload_1
    //   1338: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1341: pop
    //   1342: aload 14
    //   1344: ldc_w 3424
    //   1347: invokevirtual 939	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1350: astore 11
    //   1352: aload 14
    //   1354: ldc_w 3422
    //   1357: invokevirtual 939	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1360: astore 10
    //   1362: aload 14
    //   1364: ldc_w 4191
    //   1367: invokevirtual 939	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1370: astore 9
    //   1372: aload 11
    //   1374: ifnull +80 -> 1454
    //   1377: aload 10
    //   1379: ifnull +75 -> 1454
    //   1382: aload 11
    //   1384: invokestatic 4196	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1387: astore 11
    //   1389: aload 10
    //   1391: invokestatic 4196	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   1394: astore 10
    //   1396: aload 14
    //   1398: ldc_w 542
    //   1401: new 219	java/lang/StringBuilder
    //   1404: dup
    //   1405: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1408: ldc_w 3457
    //   1411: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: aload 11
    //   1416: invokevirtual 627	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1419: ldc_w 3462
    //   1422: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: aload 10
    //   1427: invokevirtual 627	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1430: ldc_w 4198
    //   1433: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: aload 9
    //   1438: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: ldc_w 4200
    //   1444: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1450: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1453: pop
    //   1454: aload 14
    //   1456: aload_0
    //   1457: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1460: invokevirtual 4203	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1463: aload 8
    //   1465: invokevirtual 1260	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1468: pop
    //   1469: aload_0
    //   1470: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1473: checkcast 3106	com/tencent/mobileqq/app/BaseActivity
    //   1476: aload 14
    //   1478: bipush 18
    //   1480: invokevirtual 4023	com/tencent/mobileqq/app/BaseActivity:startActivityForResult	(Landroid/content/Intent;I)V
    //   1483: ldc_w 4205
    //   1486: invokestatic 4208	zgv:a	(Ljava/lang/String;)V
    //   1489: goto -365 -> 1124
    //   1492: astore 8
    //   1494: aload 8
    //   1496: invokevirtual 545	java/lang/Exception:printStackTrace	()V
    //   1499: goto -375 -> 1124
    //   1502: aload 8
    //   1504: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1507: ifne +287 -> 1794
    //   1510: aload 9
    //   1512: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1515: ifne +279 -> 1794
    //   1518: aload 8
    //   1520: ldc_w 4210
    //   1523: invokevirtual 2183	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1526: ifeq +268 -> 1794
    //   1529: aload 9
    //   1531: ldc 52
    //   1533: invokevirtual 2183	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1536: ifeq +258 -> 1794
    //   1539: new 768	java/lang/StringBuffer
    //   1542: dup
    //   1543: invokespecial 769	java/lang/StringBuffer:<init>	()V
    //   1546: astore 12
    //   1548: aload_0
    //   1549: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1552: ifnull +230 -> 1782
    //   1555: aload_0
    //   1556: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1559: getfield 4212	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1562: invokevirtual 1331	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1565: ifle +217 -> 1782
    //   1568: aload_0
    //   1569: getfield 4123	bdhk:jdField_g_of_type_Boolean	Z
    //   1572: ifeq +210 -> 1782
    //   1575: aload 12
    //   1577: ldc_w 4214
    //   1580: invokevirtual 2384	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1583: pop
    //   1584: aload_0
    //   1585: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1588: getfield 4212	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1591: invokevirtual 4215	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1594: ifeq +38 -> 1632
    //   1597: aload 12
    //   1599: new 219	java/lang/StringBuilder
    //   1602: dup
    //   1603: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1606: ldc_w 4217
    //   1609: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: aload_0
    //   1613: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1616: getfield 4212	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1619: invokevirtual 1331	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1622: invokevirtual 649	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1625: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1628: invokevirtual 2384	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1631: pop
    //   1632: aload_0
    //   1633: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1636: getfield 1371	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1639: invokevirtual 1375	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1642: istore 6
    //   1644: iload 6
    //   1646: ifeq +48 -> 1694
    //   1649: aload_0
    //   1650: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   1653: getfield 1371	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1656: invokevirtual 1377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1659: ldc_w 1086
    //   1662: invokestatic 1092	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1665: astore 10
    //   1667: aload 12
    //   1669: new 219	java/lang/StringBuilder
    //   1672: dup
    //   1673: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1676: ldc_w 4219
    //   1679: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: aload 10
    //   1684: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1690: invokevirtual 2384	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1693: pop
    //   1694: aload_0
    //   1695: ldc_w 542
    //   1698: invokevirtual 953	bdhk:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1701: astore 11
    //   1703: aload 11
    //   1705: astore 10
    //   1707: aload 11
    //   1709: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1712: ifne +27 -> 1739
    //   1715: aload 11
    //   1717: astore 10
    //   1719: aload 11
    //   1721: invokestatic 4223	ybk:g	(Ljava/lang/String;)Z
    //   1724: ifeq +15 -> 1739
    //   1727: aload 11
    //   1729: aload 12
    //   1731: invokevirtual 2424	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1734: invokestatic 4227	nbv:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1737: astore 10
    //   1739: aload_0
    //   1740: aload 10
    //   1742: aload 9
    //   1744: aload 8
    //   1746: aload 14
    //   1748: invokespecial 4229	bdhk:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   1751: aload_0
    //   1752: aload 8
    //   1754: invokespecial 4231	bdhk:g	(Ljava/lang/String;)V
    //   1757: goto -633 -> 1124
    //   1760: astore 10
    //   1762: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1765: ifeq +1292 -> 3057
    //   1768: ldc 217
    //   1770: iconst_2
    //   1771: aload 10
    //   1773: invokevirtual 4232	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   1776: invokestatic 604	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1779: goto +1278 -> 3057
    //   1782: aload 12
    //   1784: ldc_w 4234
    //   1787: invokevirtual 2384	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1790: pop
    //   1791: goto -97 -> 1694
    //   1794: aload 8
    //   1796: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1799: ifne +451 -> 2250
    //   1802: aload 9
    //   1804: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1807: ifne +443 -> 2250
    //   1810: aload 8
    //   1812: ldc_w 4236
    //   1815: invokevirtual 2183	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1818: ifeq +432 -> 2250
    //   1821: aload 9
    //   1823: ldc 52
    //   1825: invokevirtual 2183	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1828: ifeq +422 -> 2250
    //   1831: aload_0
    //   1832: ldc_w 542
    //   1835: invokevirtual 953	bdhk:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1838: astore 10
    //   1840: aload 10
    //   1842: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1845: ifeq +380 -> 2225
    //   1848: ldc_w 4238
    //   1851: astore 10
    //   1853: new 219	java/lang/StringBuilder
    //   1856: dup
    //   1857: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1860: ldc_w 4240
    //   1863: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   1869: invokevirtual 600	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1872: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1875: astore 12
    //   1877: aload 12
    //   1879: astore 11
    //   1881: aload_0
    //   1882: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1885: ifnull +51 -> 1936
    //   1888: aload 12
    //   1890: astore 11
    //   1892: invokestatic 4245	myl:a	()Lmyl;
    //   1895: aload 10
    //   1897: invokevirtual 4247	myl:i	(Ljava/lang/String;)Z
    //   1900: ifeq +36 -> 1936
    //   1903: new 219	java/lang/StringBuilder
    //   1906: dup
    //   1907: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1910: aload 12
    //   1912: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: ldc_w 4249
    //   1918: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: aload_0
    //   1922: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1925: invokevirtual 1350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1928: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1931: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1934: astore 11
    //   1936: aload 11
    //   1938: astore 12
    //   1940: aload_0
    //   1941: getfield 1119	bdhk:q	Ljava/lang/String;
    //   1944: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1947: ifne +33 -> 1980
    //   1950: new 219	java/lang/StringBuilder
    //   1953: dup
    //   1954: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1957: aload 11
    //   1959: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1962: ldc_w 2393
    //   1965: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1968: aload_0
    //   1969: getfield 1119	bdhk:q	Ljava/lang/String;
    //   1972: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1975: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1978: astore 12
    //   1980: aload 12
    //   1982: astore 11
    //   1984: aload 10
    //   1986: ldc_w 2386
    //   1989: invokevirtual 2439	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1992: ifge +26 -> 2018
    //   1995: new 219	java/lang/StringBuilder
    //   1998: dup
    //   1999: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   2002: aload 12
    //   2004: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2007: ldc_w 4251
    //   2010: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2013: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2016: astore 11
    //   2018: aload 10
    //   2020: aload 11
    //   2022: invokestatic 4227	nbv:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2025: astore 10
    //   2027: aload_0
    //   2028: ldc_w 4103
    //   2031: invokevirtual 953	bdhk:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2034: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2037: ifne +953 -> 2990
    //   2040: aload_0
    //   2041: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2044: ifnull +946 -> 2990
    //   2047: aload_0
    //   2048: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2051: bipush 12
    //   2053: invokevirtual 501	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2056: checkcast 4253	azbi
    //   2059: astore 11
    //   2061: iconst_0
    //   2062: istore_1
    //   2063: aload_0
    //   2064: getfield 1321	bdhk:jdField_h_of_type_Boolean	Z
    //   2067: ifeq +12 -> 2079
    //   2070: aload_0
    //   2071: getfield 1319	bdhk:jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   2074: iconst_1
    //   2075: invokestatic 4258	aslq:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;Z)I
    //   2078: istore_1
    //   2079: aload 11
    //   2081: invokevirtual 4261	azbi:a	()Laslq;
    //   2084: iload_1
    //   2085: invokevirtual 4264	aslq:a	(I)Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;
    //   2088: astore 11
    //   2090: aload 11
    //   2092: ifnull +898 -> 2990
    //   2095: ldc 217
    //   2097: iconst_2
    //   2098: iconst_2
    //   2099: anewarray 4	java/lang/Object
    //   2102: dup
    //   2103: iconst_0
    //   2104: ldc_w 4266
    //   2107: aastore
    //   2108: dup
    //   2109: iconst_1
    //   2110: aload 11
    //   2112: aastore
    //   2113: invokestatic 2176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2116: aload 10
    //   2118: ldc_w 4268
    //   2121: invokestatic 4227	nbv:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2124: astore 10
    //   2126: aload 11
    //   2128: aload 14
    //   2130: invokestatic 4271	aslq:a	(Lcom/tencent/mobileqq/gamecenter/data/PadFaceAd;Landroid/content/Intent;)Landroid/content/Intent;
    //   2133: pop
    //   2134: aload_0
    //   2135: aload 10
    //   2137: aload 9
    //   2139: aload 8
    //   2141: aload 14
    //   2143: invokespecial 4229	bdhk:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2146: aload_0
    //   2147: aload 8
    //   2149: invokespecial 4231	bdhk:g	(Ljava/lang/String;)V
    //   2152: aload_0
    //   2153: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2156: ifnull +37 -> 2193
    //   2159: aload_0
    //   2160: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2163: ldc_w 4273
    //   2166: invokevirtual 4277	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   2169: astore 8
    //   2171: aload 8
    //   2173: ifnull +20 -> 2193
    //   2176: aload 8
    //   2178: aload 8
    //   2180: ldc_w 4278
    //   2183: invokevirtual 4282	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   2186: ldc2_w 4283
    //   2189: invokevirtual 4288	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   2192: pop
    //   2193: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2196: ifeq +12 -> 2208
    //   2199: ldc 217
    //   2201: iconst_2
    //   2202: ldc_w 4290
    //   2205: invokestatic 587	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2208: new 4292	com/tencent/mobileqq/utils/JumpAction$23
    //   2211: dup
    //   2212: aload_0
    //   2213: invokespecial 4293	com/tencent/mobileqq/utils/JumpAction$23:<init>	(Lbdhk;)V
    //   2216: iconst_5
    //   2217: aconst_null
    //   2218: iconst_1
    //   2219: invokestatic 1445	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2222: goto -1098 -> 1124
    //   2225: aload 10
    //   2227: invokestatic 1670	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   2230: astore 10
    //   2232: goto -379 -> 1853
    //   2235: astore 10
    //   2237: aload 10
    //   2239: invokevirtual 545	java/lang/Exception:printStackTrace	()V
    //   2242: ldc_w 4238
    //   2245: astore 10
    //   2247: goto -394 -> 1853
    //   2250: aload 8
    //   2252: ldc_w 4295
    //   2255: invokevirtual 2472	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2258: ifeq +169 -> 2427
    //   2261: aload_0
    //   2262: ldc 177
    //   2264: invokevirtual 953	bdhk:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2267: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2270: ifne +52 -> 2322
    //   2273: aload 14
    //   2275: ldc_w 4297
    //   2278: iconst_4
    //   2279: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2282: pop
    //   2283: aload 14
    //   2285: ldc_w 4299
    //   2288: aload 14
    //   2290: ldc_w 4299
    //   2293: iconst_1
    //   2294: invokevirtual 949	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2297: iconst_4
    //   2298: ior
    //   2299: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2302: pop
    //   2303: aload_0
    //   2304: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2307: aload_0
    //   2308: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2311: checkcast 264	android/app/Activity
    //   2314: aload 14
    //   2316: invokestatic 4304	bkbq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2319: goto -1195 -> 1124
    //   2322: aload_0
    //   2323: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2326: ldc_w 1175
    //   2329: ldc 61
    //   2331: ldc 61
    //   2333: ldc_w 4306
    //   2336: ldc_w 4306
    //   2339: iconst_0
    //   2340: iconst_0
    //   2341: ldc 61
    //   2343: ldc 61
    //   2345: ldc 61
    //   2347: ldc 61
    //   2349: iconst_0
    //   2350: invokestatic 3288	nrt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2353: invokestatic 4311	rlb:a	()Lrlb;
    //   2356: invokestatic 4311	rlb:a	()Lrlb;
    //   2359: invokevirtual 4312	rlb:b	()Z
    //   2362: ldc_w 4314
    //   2365: iconst_1
    //   2366: invokevirtual 4317	rlb:a	(ZLjava/lang/String;I)V
    //   2369: aload 14
    //   2371: ldc_w 4297
    //   2374: iconst_1
    //   2375: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2378: pop
    //   2379: aload 14
    //   2381: ldc_w 4319
    //   2384: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   2387: invokevirtual 413	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2390: pop
    //   2391: aload_0
    //   2392: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2395: bipush 96
    //   2397: invokevirtual 501	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2400: checkcast 4321	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager
    //   2403: aload 14
    //   2405: invokevirtual 4322	com/tencent/mobileqq/app/readinjoy/ReadInJoyManager:a	(Landroid/content/Intent;)V
    //   2408: aload_0
    //   2409: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2412: aload_0
    //   2413: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2416: checkcast 264	android/app/Activity
    //   2419: aload 14
    //   2421: invokestatic 4304	bkbq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Intent;)V
    //   2424: goto -1300 -> 1124
    //   2427: aload 8
    //   2429: ldc_w 4173
    //   2432: invokevirtual 2472	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2435: ifeq +13 -> 2448
    //   2438: aload 14
    //   2440: ldc 177
    //   2442: bipush 15
    //   2444: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2447: pop
    //   2448: aload 8
    //   2450: ldc_w 4324
    //   2453: invokevirtual 2472	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2456: ifeq +16 -> 2472
    //   2459: aload 14
    //   2461: ldc_w 4326
    //   2464: aload_0
    //   2465: getfield 2275	bdhk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2468: invokevirtual 418	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2471: pop
    //   2472: aload 8
    //   2474: getstatic 4327	cooperation/comic/VipComicJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2477: invokevirtual 2472	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2480: ifeq +39 -> 2519
    //   2483: aload 14
    //   2485: invokestatic 4330	cooperation/comic/VipComicJumpActivity:a	(Landroid/content/Intent;)Lbimw;
    //   2488: astore 11
    //   2490: aload_0
    //   2491: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2494: aload_0
    //   2495: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2498: checkcast 264	android/app/Activity
    //   2501: aload 11
    //   2503: invokestatic 4333	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lbimw;)Z
    //   2506: ifeq +13 -> 2519
    //   2509: aload_0
    //   2510: getfield 97	bdhk:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2513: iconst_1
    //   2514: invokestatic 4336	cooperation/comic/VipComicJumpActivity:a	(Lcom/tencent/common/app/AppInterface;Z)V
    //   2517: iconst_1
    //   2518: ireturn
    //   2519: aload 9
    //   2521: ifnull -1397 -> 1124
    //   2524: aload 9
    //   2526: invokestatic 480	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2529: invokevirtual 4337	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   2532: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2535: istore 6
    //   2537: iload 6
    //   2539: ifeq +370 -> 2909
    //   2542: iconst_0
    //   2543: istore 6
    //   2545: ldc_w 4339
    //   2548: invokestatic 480	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2551: invokevirtual 4343	com/tencent/qphone/base/util/BaseApplication:getClassLoader	()Ljava/lang/ClassLoader;
    //   2554: aload 8
    //   2556: invokevirtual 4349	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   2559: invokevirtual 4353	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   2562: istore 7
    //   2564: iload 7
    //   2566: istore 6
    //   2568: iload 6
    //   2570: ifeq +5 -> 2575
    //   2573: iconst_0
    //   2574: ireturn
    //   2575: aload 14
    //   2577: ldc_w 4355
    //   2580: invokevirtual 939	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2583: astore 11
    //   2585: aload 11
    //   2587: ifnull +398 -> 2985
    //   2590: aload 11
    //   2592: invokestatic 392	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2595: istore_1
    //   2596: aload 8
    //   2598: ldc_w 4357
    //   2601: invokevirtual 2183	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2604: ifeq +188 -> 2792
    //   2607: ldc_w 4359
    //   2610: astore 8
    //   2612: ldc_w 4361
    //   2615: aload 8
    //   2617: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2620: ifeq +204 -> 2824
    //   2623: aload 14
    //   2625: ldc_w 4363
    //   2628: invokevirtual 939	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2631: astore 12
    //   2633: aload 8
    //   2635: astore 11
    //   2637: aload 12
    //   2639: ifnull +38 -> 2677
    //   2642: aload 8
    //   2644: astore 11
    //   2646: aload 12
    //   2648: invokestatic 392	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2651: iconst_2
    //   2652: if_icmpne +25 -> 2677
    //   2655: iload_1
    //   2656: invokestatic 4367	bfyh:b	(I)Z
    //   2659: ifeq +411 -> 3070
    //   2662: ldc_w 4369
    //   2665: astore 11
    //   2667: aload 14
    //   2669: ldc_w 4355
    //   2672: iload_1
    //   2673: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2676: pop
    //   2677: aload 10
    //   2679: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2682: ifne +129 -> 2811
    //   2685: aload 10
    //   2687: invokevirtual 4372	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2690: ldc_w 2653
    //   2693: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2696: ifeq +115 -> 2811
    //   2699: aload 14
    //   2701: ldc_w 1964
    //   2704: bipush 117
    //   2706: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2709: pop
    //   2710: aload 14
    //   2712: ldc_w 554
    //   2715: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2718: pop
    //   2719: aload 11
    //   2721: astore 8
    //   2723: ldc_w 4374
    //   2726: aload 8
    //   2728: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2731: ifeq +150 -> 2881
    //   2734: aload 14
    //   2736: ldc_w 542
    //   2739: invokevirtual 939	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2742: astore 10
    //   2744: aload 10
    //   2746: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2749: ifne +132 -> 2881
    //   2752: aload 10
    //   2754: ldc_w 2964
    //   2757: invokevirtual 2338	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2760: ifne +121 -> 2881
    //   2763: ldc 217
    //   2765: iconst_1
    //   2766: new 219	java/lang/StringBuilder
    //   2769: dup
    //   2770: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   2773: ldc_w 4376
    //   2776: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2779: aload 10
    //   2781: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2784: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2787: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2790: iconst_0
    //   2791: ireturn
    //   2792: aload 8
    //   2794: ldc_w 4378
    //   2797: invokevirtual 2183	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2800: ifeq +182 -> 2982
    //   2803: ldc_w 4361
    //   2806: astore 8
    //   2808: goto -196 -> 2612
    //   2811: aload 14
    //   2813: ldc_w 1964
    //   2816: iconst_2
    //   2817: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2820: pop
    //   2821: goto -111 -> 2710
    //   2824: ldc_w 4359
    //   2827: aload 8
    //   2829: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2832: ifeq +28 -> 2860
    //   2835: iload_1
    //   2836: invokestatic 4367	bfyh:b	(I)Z
    //   2839: ifeq -116 -> 2723
    //   2842: ldc_w 4369
    //   2845: astore 8
    //   2847: aload 14
    //   2849: ldc_w 4355
    //   2852: iload_1
    //   2853: invokevirtual 408	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2856: pop
    //   2857: goto -134 -> 2723
    //   2860: aload 14
    //   2862: ldc_w 1262
    //   2865: invokevirtual 1266	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   2868: pop
    //   2869: aload 14
    //   2871: ldc_w 657
    //   2874: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2877: pop
    //   2878: goto -155 -> 2723
    //   2881: aload 14
    //   2883: aload 9
    //   2885: aload 8
    //   2887: invokevirtual 1260	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2890: pop
    //   2891: aload_0
    //   2892: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2895: aload 14
    //   2897: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2900: aload_0
    //   2901: aload 8
    //   2903: invokespecial 4231	bdhk:g	(Ljava/lang/String;)V
    //   2906: goto -1782 -> 1124
    //   2909: aload 14
    //   2911: aload 9
    //   2913: aload 8
    //   2915: invokevirtual 1260	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2918: pop
    //   2919: aload 14
    //   2921: ldc_w 1262
    //   2924: invokevirtual 1266	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   2927: pop
    //   2928: aload 14
    //   2930: ldc_w 657
    //   2933: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2936: pop
    //   2937: aload_0
    //   2938: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2941: aload 14
    //   2943: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2946: goto -1822 -> 1124
    //   2949: iload_1
    //   2950: iconst_1
    //   2951: if_icmpne -1827 -> 1124
    //   2954: aload 11
    //   2956: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2959: ifne -1835 -> 1124
    //   2962: aload_0
    //   2963: aload 14
    //   2965: aload 8
    //   2967: aload 11
    //   2969: invokespecial 3450	bdhk:a	(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)Z
    //   2972: istore 6
    //   2974: iload 6
    //   2976: ireturn
    //   2977: astore 11
    //   2979: goto -411 -> 2568
    //   2982: goto -370 -> 2612
    //   2985: iconst_0
    //   2986: istore_1
    //   2987: goto -391 -> 2596
    //   2990: goto -856 -> 2134
    //   2993: aload 10
    //   2995: astore 12
    //   2997: aload 11
    //   2999: astore 13
    //   3001: aload 8
    //   3003: astore 11
    //   3005: aload 9
    //   3007: astore 10
    //   3009: aload 12
    //   3011: astore 8
    //   3013: aload 13
    //   3015: astore 9
    //   3017: goto -2866 -> 151
    //   3020: aload 8
    //   3022: astore 12
    //   3024: aload 9
    //   3026: astore 13
    //   3028: aload 11
    //   3030: astore 8
    //   3032: aload 10
    //   3034: astore 9
    //   3036: aload 12
    //   3038: astore 10
    //   3040: aload 13
    //   3042: astore 11
    //   3044: goto -51 -> 2993
    //   3047: iconst_0
    //   3048: ireturn
    //   3049: ldc_w 778
    //   3052: astore 8
    //   3054: goto -1831 -> 1223
    //   3057: aconst_null
    //   3058: astore 10
    //   3060: goto -1393 -> 1667
    //   3063: astore 11
    //   3065: iconst_0
    //   3066: istore_1
    //   3067: goto -471 -> 2596
    //   3070: ldc_w 4359
    //   3073: astore 11
    //   3075: goto -398 -> 2677
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3078	0	this	bdhk
    //   37	3030	1	i1	int
    //   873	257	2	i2	int
    //   853	45	3	i3	int
    //   849	26	4	i4	int
    //   870	11	5	i5	int
    //   1265	1710	6	bool1	boolean
    //   2562	3	7	bool2	boolean
    //   22	1069	8	localObject1	Object
    //   1133	1	8	localException1	Exception
    //   1149	24	8	localIntent1	Intent
    //   1180	10	8	localActivityNotFoundException	android.content.ActivityNotFoundException
    //   1221	243	8	str1	String
    //   1492	656	8	localException2	Exception
    //   2169	884	8	localObject2	Object
    //   19	3016	9	localObject3	Object
    //   25	1716	10	localObject4	Object
    //   1760	12	10	localUnsupportedEncodingException	UnsupportedEncodingException
    //   1838	393	10	str2	String
    //   2235	3	10	localException3	Exception
    //   2245	814	10	localObject5	Object
    //   40	2928	11	localObject6	Object
    //   2977	21	11	localException4	Exception
    //   3003	40	11	localObject7	Object
    //   3063	1	11	localException5	Exception
    //   3073	1	11	str3	String
    //   34	3003	12	localObject8	Object
    //   49	2992	13	localObject9	Object
    //   10	2954	14	localIntent2	Intent
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
    //   1289	1372	1180	android/content/ActivityNotFoundException
    //   1382	1454	1180	android/content/ActivityNotFoundException
    //   1454	1489	1180	android/content/ActivityNotFoundException
    //   1494	1499	1180	android/content/ActivityNotFoundException
    //   1502	1632	1180	android/content/ActivityNotFoundException
    //   1632	1644	1180	android/content/ActivityNotFoundException
    //   1649	1667	1180	android/content/ActivityNotFoundException
    //   1667	1694	1180	android/content/ActivityNotFoundException
    //   1694	1703	1180	android/content/ActivityNotFoundException
    //   1707	1715	1180	android/content/ActivityNotFoundException
    //   1719	1739	1180	android/content/ActivityNotFoundException
    //   1739	1757	1180	android/content/ActivityNotFoundException
    //   1762	1779	1180	android/content/ActivityNotFoundException
    //   1782	1791	1180	android/content/ActivityNotFoundException
    //   1794	1848	1180	android/content/ActivityNotFoundException
    //   1853	1877	1180	android/content/ActivityNotFoundException
    //   1881	1888	1180	android/content/ActivityNotFoundException
    //   1892	1936	1180	android/content/ActivityNotFoundException
    //   1940	1980	1180	android/content/ActivityNotFoundException
    //   1984	2018	1180	android/content/ActivityNotFoundException
    //   2018	2061	1180	android/content/ActivityNotFoundException
    //   2063	2079	1180	android/content/ActivityNotFoundException
    //   2079	2090	1180	android/content/ActivityNotFoundException
    //   2095	2134	1180	android/content/ActivityNotFoundException
    //   2134	2171	1180	android/content/ActivityNotFoundException
    //   2176	2193	1180	android/content/ActivityNotFoundException
    //   2193	2208	1180	android/content/ActivityNotFoundException
    //   2208	2222	1180	android/content/ActivityNotFoundException
    //   2225	2232	1180	android/content/ActivityNotFoundException
    //   2237	2242	1180	android/content/ActivityNotFoundException
    //   2250	2319	1180	android/content/ActivityNotFoundException
    //   2322	2424	1180	android/content/ActivityNotFoundException
    //   2427	2448	1180	android/content/ActivityNotFoundException
    //   2448	2472	1180	android/content/ActivityNotFoundException
    //   2472	2517	1180	android/content/ActivityNotFoundException
    //   2524	2537	1180	android/content/ActivityNotFoundException
    //   2545	2564	1180	android/content/ActivityNotFoundException
    //   2575	2585	1180	android/content/ActivityNotFoundException
    //   2590	2596	1180	android/content/ActivityNotFoundException
    //   2596	2607	1180	android/content/ActivityNotFoundException
    //   2612	2633	1180	android/content/ActivityNotFoundException
    //   2646	2662	1180	android/content/ActivityNotFoundException
    //   2667	2677	1180	android/content/ActivityNotFoundException
    //   2677	2710	1180	android/content/ActivityNotFoundException
    //   2710	2719	1180	android/content/ActivityNotFoundException
    //   2723	2790	1180	android/content/ActivityNotFoundException
    //   2792	2803	1180	android/content/ActivityNotFoundException
    //   2811	2821	1180	android/content/ActivityNotFoundException
    //   2824	2835	1180	android/content/ActivityNotFoundException
    //   2835	2842	1180	android/content/ActivityNotFoundException
    //   2847	2857	1180	android/content/ActivityNotFoundException
    //   2860	2878	1180	android/content/ActivityNotFoundException
    //   2881	2906	1180	android/content/ActivityNotFoundException
    //   2909	2946	1180	android/content/ActivityNotFoundException
    //   2954	2974	1180	android/content/ActivityNotFoundException
    //   1272	1284	1492	java/lang/Exception
    //   1289	1372	1492	java/lang/Exception
    //   1382	1454	1492	java/lang/Exception
    //   1454	1489	1492	java/lang/Exception
    //   1649	1667	1760	java/io/UnsupportedEncodingException
    //   2225	2232	2235	java/lang/Exception
    //   2545	2564	2977	java/lang/Exception
    //   2590	2596	3063	java/lang/Exception
  }
  
  private boolean bo()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800492C", "0X800492C", 0, 0, "", "", "", "");
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
                  localBundle.putString("title", String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131698482), new Object[] { localObject1 }));
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
                  localException2.putString("title", this.jdField_a_of_type_AndroidContentContext.getString(2131698483));
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
                    if (arrr.a((String)localObject1) == 0)
                    {
                      localException2.putInt("req_type", 5);
                    }
                    else
                    {
                      localException2.putString("forward_text", alud.a(2131706291) + arrr.a((String)localObject1) + alud.a(2131706292) + arso.a(arso.a((String)localObject1)) + "。");
                      localException2.putBoolean("qdshare_file", true);
                      localException2.putBoolean("isFromShare", true);
                      localException2.putBoolean("key_sdk_share_pure_text", true);
                      localException2.putInt("req_type", 6);
                    }
                  }
                  else if (arrr.a(localObject3) == 0)
                  {
                    localException2.putString("title", ((ArrayList)localObject6).size() + this.jdField_a_of_type_AndroidContentContext.getString(2131694912));
                    localException2.putString("qqfav_extra_multi_pic_path_list", str2);
                    localException2.putBoolean("qqfav_extra_multi_pic", true);
                    localException2.putInt("req_type", 1);
                  }
                  else
                  {
                    localObject1 = ((ArrayList)localObject6).iterator();
                    for (l1 = 0L; ((Iterator)localObject1).hasNext(); l1 = arso.a((String)((Iterator)localObject1).next()) + l1) {}
                    localException2.putString("forward_text", alud.a(2131706298) + arrr.a(localObject3) + alud.a(2131706286) + ((ArrayList)localObject6).size() + alud.a(2131706299) + arso.a(l1));
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
  
  private boolean bp()
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
            localObject1 = bfiu.g() + File.separator + "qapp_center_detail.htm";
            if (new File((String)localObject1).exists()) {}
            for (localObject1 = "file:///" + (String)localObject1;; localObject1 = bfiu.m() + File.separator + "qapp_center_detail.htm")
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
        localObject3 = bfiu.a(((Uri)localObject2).getQueryParameter("url"));
      } while (localObject3.length <= 1);
      localObject2 = localObject3[0];
    } while ((!((String)localObject2).startsWith("file://")) || ((!((String)localObject2).contains(bfiu.g())) && (!((String)localObject2).contains("android_asset/Page/system/"))));
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
  
  private boolean bq()
  {
    bisq.a(this.jdField_a_of_type_AndroidContentContext, 9, null);
    return true;
  }
  
  private boolean br()
  {
    return true;
  }
  
  private boolean bs()
  {
    return true;
  }
  
  private boolean bt()
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
  
  private boolean bu()
  {
    String str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
    if (TextUtils.isEmpty(str)) {
      str = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      aagb.a().a(1);
      aagb.a().jdField_a_of_type_JavaLangString = "";
      aagb.a().jdField_a_of_type_Int = 0;
      aagb.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 2);
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        DeviceScanner.openDeviceQCodeUrl((Activity)this.jdField_a_of_type_AndroidContentContext, null, str);
      }
      return true;
    }
  }
  
  private boolean bv()
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
        localObject1 = bhsz.a((String)localObject1);
        if (((Map)localObject1).get("public_device") != null)
        {
          i1 = 1;
          localObject2 = bhsz.b((String)((Map)localObject1).get("args"));
          localObject1 = (String)((Map)localObject2).get("sn");
          localObject2 = (String)((Map)localObject2).get("pid");
          if ((i1 != 0) && ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))))
          {
            bflz.a().a(this.jdField_a_of_type_AndroidContentContext.getString(2131721279));
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
  
  private boolean bw()
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
    aryv.a(this.jdField_a_of_type_AndroidContentContext, localIntent);
    return true;
  }
  
  private boolean bx()
  {
    Object localObject = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("friendUin"));
    localObject = AddFriendLogicActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, 1, (String)localObject, "", 3001, 11, "", "", null, "", "");
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    return true;
  }
  
  private boolean by()
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
  
  private boolean bz()
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
      return bB();
    }
    if ("opentopic".equals(this.c)) {
      return bA();
    }
    if ("infoCard".equals(this.c)) {
      return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    if ("sharegroupcard".equals(this.c)) {
      return b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
    }
    Object localObject = new wgt((Activity)this.jdField_a_of_type_AndroidContentContext, new bdhr(this));
    Intent localIntent = e(new Intent());
    if (localIntent != null)
    {
      int i1 = localIntent.getIntExtra("action", 0);
      localIntent.putExtra("action", 0);
      return ((wgt)localObject).a(i1, localIntent);
    }
    return false;
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
      bfzp localbfzp = (bfzp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
      boolean bool = false;
      if (this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag") == null) {
        break label356;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("cspecialflag");
      label203:
      if (!TextUtils.isEmpty(str3)) {
        bool = bfyh.b(Integer.valueOf(str3).intValue());
      }
      localbfzp.a(str4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject, str1, paramString, bool);
      localObject = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject == null) || (!((alto)localObject).b(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label363;
      }
      localObject = new awqt();
      ((awqt)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramString, 1);
      ((awqt)localObject).jdField_a_of_type_ArrayOfJavaLangString = new String[7];
      ((awqt)localObject).jdField_a_of_type_ArrayOfJavaLangString[4] = str2;
      FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (awqt)localObject);
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
      paramString = AddFriendLogicActivity.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 1, paramString, null, 3999, 0, str2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131690623), null);
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
    String str = b("buddyuin");
    if (!str.isEmpty())
    {
      long l1 = Long.parseLong(str);
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "grayTip,openTroopWithCommonFriendsFragment:" + l1);
      }
      TroopWithCommonFriendsFragment.a(str);
      TroopWithCommonFriendsFragment.a(this.jdField_a_of_type_AndroidContentContext, 1);
      azqs.b(null, "dc00898", "", "", "0X800AD20", "0X800AD20", 0, 0, "0", "0", "", "");
    }
  }
  
  private boolean d(String paramString)
  {
    String str = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("image_uri"));
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_b_of_type_Boolean = false;
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
      wxe.a("JumpAction", "makeStoryJumpActivity() action=%s isFromApi=%s", this.c, Boolean.valueOf(bool));
      wxe.a("JumpAction", "makeStoryJumpActivity() attr=%s", String.valueOf(this.jdField_a_of_type_JavaUtilHashMap));
      if (!"open".equals(this.c)) {
        break;
      }
      paramIntent.putExtra("redid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("redid"));
      paramIntent.putExtra("lebaVersion", (String)this.jdField_a_of_type_JavaUtilHashMap.get("lebaVersion"));
      if (bool) {
        wxj.a("basic", "use_api", 0, 0, new String[] { "1", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
      }
      return paramIntent;
    }
    String str1;
    if (("openVideo".equals(this.c)) || ("openvideo".equals(this.c)))
    {
      if (bool)
      {
        str1 = "userId=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoOwnerUin") + "&vid=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("videoId");
        wxj.a("basic", "use_api", 0, 0, new String[] { "6", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
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
          break label471;
        }
      }
      label471:
      for (str1 = "unionId=" + str5 + "&userId=" + str1 + "&userType=" + str2;; str1 = "storyId=" + str4)
      {
        wxj.a("basic", "use_api", 0, 0, new String[] { "4", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
        return d(paramIntent);
      }
    }
    if ("opentopic".equals(this.c))
    {
      if (bool)
      {
        str1 = "topicId=" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("topicid");
        wxj.a("basic", "use_api", 0, 0, new String[] { "5", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api"), "", str1 });
      }
      return b(paramIntent);
    }
    if ("opendiscovery".equals(this.c))
    {
      if (bool) {
        wxj.a("content_flow", "use_api", 0, 0, new String[] { "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
      }
      return c(paramIntent);
    }
    if ("publish".equals(this.c))
    {
      if (bool) {
        wxj.a("basic", "use_api", 0, 0, new String[] { "2", (String)this.jdField_a_of_type_JavaUtilHashMap.get("parter_api") });
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
      QzonePluginProxyActivity.a((Intent)localObject2, "com.qzone.detail.ui.activity.StickyNoteDetailActivity");
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
      {
        localObject3 = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
        localObject1 = null;
        if (((BaseActivity)localObject3).app != null) {
          localObject1 = ((BaseActivity)localObject3).app.c();
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          QLog.e("JumpAction", 1, "action_open_sticky_note_feed_detail  error! get currentUin failed! " + ((BaseActivity)localObject3).app);
          return;
        }
        QzonePluginProxyActivity.a((Activity)localObject3, (String)localObject1, (Intent)localObject2, 7, true);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpAction", 1, "action_open_sticky_note_feed_detail  error!", localThrowable);
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
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
    localIntent.putExtra("key_plugin_id", "qzone_weishi_feeds_plugin.apk");
    localIntent.setFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  private void f(String paramString)
  {
    if ("app".equals(this.jdField_f_of_type_JavaLangString)) {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_app", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if ("web".equals(this.jdField_f_of_type_JavaLangString))
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_website", 0, 0, "", "", "", "");
        return;
      }
    } while (!"scan".equals(this.jdField_f_of_type_JavaLangString));
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", paramString, "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
  }
  
  private void g()
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
          localObject2 = new String(bdfr.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("topicname"), 0));
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
  
  private void g(String paramString)
  {
    if ((paramString.equals(GameCenterActivity.class.getName())) || (paramString.equals(PublicAccountBrowser.class.getName())) || (paramString.equals(CouponActivity.class.getName()))) {
      QWalletHelper.preloadQWallet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidAppDialog = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 2131693026, this.jdField_a_of_type_AndroidContentContext.getString(2131693010), 2131693012, 2131693011, new bdhv(this), new bdhw(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void i()
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
        break label329;
      }
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("signareMode");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("appid")) {
        break label335;
      }
      str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("timeStamp")) {
        break label341;
      }
      str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("timeStamp");
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("resetWordMode")) {
        break label348;
      }
      str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("resetWordMode");
      label137:
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("offerid")) {
        break label355;
      }
    }
    label329:
    label335:
    label341:
    label348:
    label355:
    for (String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("offerid");; str5 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "packageName : " + (String)localObject + " signatureMode :" + str1 + " appid : " + str2 + " timestamp : " + str3 + " resetWordMode : " + str4 + " offerId : " + str5);
      }
      localObject = new ReqCheckChangePwdAuth((String)localObject, str1, str2, str3, str4, str5);
      ((amay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(42)).a((ReqCheckChangePwdAuth)localObject);
      this.jdField_a_of_type_Bdhy = new bdhy(this, null);
      this.jdField_a_of_type_Amaz = new amaz(this.jdField_a_of_type_Bdhy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amaz);
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
  
  private void j()
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
  
  private void k()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof JumpActivity))) {
      ((JumpActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
  
  private void l()
  {
    try
    {
      if ("head".equals(this.c))
      {
        if (this.jdField_a_of_type_Bdhx == null) {
          this.jdField_a_of_type_Bdhx = new bdhx(this, this);
        }
        if (this.jdField_a_of_type_JavaUtilHashtable == null) {
          this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdhx);
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
  
  public boolean A()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, InterestSwitchEditActivity.class);
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  protected boolean B()
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
      ((Intent)localObject).putExtra("param_done_button_wording", this.jdField_a_of_type_AndroidContentContext.getString(2131697734));
      ((Intent)localObject).putExtra("param_title", this.jdField_a_of_type_AndroidContentContext.getString(2131696538));
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
    if (this.jdField_a_of_type_Bety == null) {
      this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
    }
    this.jdField_a_of_type_Bety.c(paramInt);
    if ((!((JumpActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing()) && (!this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.show();
    }
  }
  
  public void a(Activity paramActivity)
  {
    if ((this.jdField_b_of_type_JavaLangString.equals("card")) && (this.c.equals("show_pslcard")) && (QSecFramework.a().a(1003).booleanValue())) {
      bfav.a().a(paramActivity, null);
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
      ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(2130772293, 2130771990);
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
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
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
        Object localObject7;
        Object localObject5;
        String str1;
        continue;
        i1 = 0;
        int i2 = 0;
        Object localObject4 = null;
      }
    }
    switch (i1)
    {
    default: 
      return true;
    }
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690623));
    return bivc.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject1, -1, false);
    this.jdField_d_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("version"));
    this.jdField_e_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("channel_id"));
    this.jdField_f_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("src_type"));
    this.jdField_g_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_type"));
    this.jdField_h_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilHashMap.get("callback_name"));
    localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("viewtype");
    localObject7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("view");
    if (("urlopen".equals(this.jdField_b_of_type_JavaLangString)) && ("pay".equals(this.c)))
    {
      localObject5 = b("payurl");
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        break label428;
      }
      str1 = new String(Base64.decode((String)localObject5, 0));
      if (TextUtils.isEmpty(str1)) {
        break label398;
      }
      QLog.e("JumpAction", 1, "payurl is call to launch");
      bdun.a(this.jdField_a_of_type_AndroidContentContext, str1);
    }
    while (("qqidentifier".equals(this.jdField_b_of_type_JavaLangString)) && ("web".equals(this.c)))
    {
      localObject1 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url"));
      if ((TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("appid"))) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("openid"))))
      {
        QLog.e("JumpAction", 1, "identification with illegal params");
        return true;
        label398:
        QLog.e("JumpAction", 1, "payurl cant not decode to base64 =" + (String)localObject5);
        continue;
        label428:
        QLog.e("JumpAction", 1, "payurl is null");
      }
      else
      {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80097E8", "0X80097E8", 0, 0, "", "", (String)this.jdField_a_of_type_JavaUtilHashMap.get("appid"), "");
        asxl.a();
        localObject5 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject5).putExtra("url", (String)localObject1);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject5);
        return true;
      }
    }
    if ("qsubscribe".equals(this.jdField_b_of_type_JavaLangString))
    {
      ybt.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.c, this.jdField_a_of_type_JavaUtilHashMap);
      return true;
    }
    if ("qcircle".equals(this.jdField_b_of_type_JavaLangString))
    {
      tqs.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.c, this.jdField_a_of_type_JavaUtilHashMap);
      return true;
    }
    if ("videostory".equals(this.jdField_b_of_type_JavaLangString)) {
      return C();
    }
    if ((this.jdField_b_of_type_JavaLangString.equals("manage_troop")) && (this.c.equals("main_page"))) {
      return bN();
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
    if (("miniapp".equals(this.jdField_b_of_type_JavaLangString)) && ("notifyclose".equals(this.c)))
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("app"))
      {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("app");
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("type")) {
          break label909;
        }
      }
      label909:
      for (localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("type");; localObject5 = null)
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject5))) {
          ((ajfv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(315)).a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, (String)localObject5);
        }
        return true;
        localObject1 = null;
        break;
      }
    }
    if (("wallet".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.c)) && ("0".equals(localObject1)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && ((localObject7 == null) || ("0".equals(localObject7)))) {
      return ak();
    }
    if (("wallet".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.c)) && ("0".equals(localObject1)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))) {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("entry")) {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("entry");
      }
    }
    for (;;)
    {
      label1086:
      long l2;
      long l1;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("seq"))
      {
        localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("seq");
        l2 = 0L;
        l1 = l2;
        if (TextUtils.isEmpty((CharSequence)localObject5)) {}
      }
      try
      {
        l1 = Long.valueOf((String)localObject5).longValue();
      }
      catch (Exception localException5)
      {
        try
        {
          VACDReportUtil.a(l1, "", "jumpParse", null, 0, null);
          for (;;)
          {
            label1121:
            if (("1".equals(localObject7)) || ("2".equals(localObject7)) || ("3".equals(localObject7)) || ("4".equals(localObject7)) || ("5".equals(localObject7)) || ("6".equals(localObject7)) || ("7".equals(localObject7)) || ("9".equals(localObject7)) || ("10".equals(localObject7)) || ("11".equals(localObject7)))
            {
              localObject5 = new Bundle();
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("tokenid")) {
                ((Bundle)localObject5).putString("tokenid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("tokenid"));
              }
              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("data")) {
                ((Bundle)localObject5).putString("data", (String)this.jdField_a_of_type_JavaUtilHashMap.get("data"));
              }
              return a((String)localObject7, (String)localObject1, l1, (Bundle)localObject5);
              localObject1 = null;
              break;
              localObject5 = null;
              break label1086;
            }
            if ("8".equals(localObject7)) {
              return a((String)localObject7, (String)localObject1, l1);
            }
            if (("buscard".equals(this.jdField_b_of_type_JavaLangString)) && ("open".equals(this.c)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("from_type")) && (!bdnn.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("from_type"))) && ("2".equals(this.jdField_a_of_type_JavaUtilHashMap.get("from_type")))) {
              return D();
            }
            if (("wxminiapp".equals(this.jdField_b_of_type_JavaLangString)) && ("launch".equals(this.c)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("user_name")) && (!bdnn.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("user_name")))) {
              return E();
            }
            if ("qqnotify".equals(this.jdField_b_of_type_JavaLangString))
            {
              if (!"open".equals(this.c)) {
                break label1767;
              }
              if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("params")) {}
            }
            label1767:
            Object localObject2;
            for (;;)
            {
              try
              {
                localObject1 = new JSONObject(URLDecoder.decode((String)this.jdField_a_of_type_JavaUtilHashMap.get("params")));
                if (QLog.isColorLevel()) {
                  QLog.i("JumpAction", 2, "urlParamObj: " + localObject1);
                }
                if (((JSONObject)localObject1).optInt("view_type", 0) == 0)
                {
                  localObject1 = ((JSONObject)localObject1).optJSONObject("params");
                  if (localObject1 != null) {
                    ReminderListFragment.a(this.jdField_a_of_type_AndroidContentContext, ((JSONObject)localObject1).optString("notice_time"));
                  }
                }
              }
              catch (Exception localException1)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("JumpAction", 2, "JumpAction parse url throw an exception: " + localException1);
                continue;
              }
              if (("qqnotify".equals(this.jdField_b_of_type_JavaLangString)) && ("birth".equals(this.c)))
              {
                localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, ActivateFriendActivity.class);
                ((Intent)localObject1).putExtra("af_key_from", 2);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
              }
              if (!this.jdField_b_of_type_JavaLangString.equals("ftssearch")) {
                break label1932;
              }
              if (!this.c.equals("tab")) {
                break;
              }
              return F();
              if (("subscribe".equals(this.c)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("scheme")) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("msgid")) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey("busiid")))
              {
                localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("msgid");
                localObject7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("busiid");
                str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("scheme");
                localObject2 = "";
                if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("domain")) {
                  localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("domain");
                }
                QQNotifySettingFragment.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject5, (String)localObject7, str1, (String)localObject2);
              }
            }
            if (this.c.equals("openmixweb")) {
              return e();
            }
            label1932:
            if ((this.jdField_b_of_type_JavaLangString.equals("wpa")) && (this.c.equals("openid_to_uin"))) {
              return al();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.c.equals("chat"))) {
              return an();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("wsgzh")) && (this.c.equals("waterfall")))
            {
              tch.a(this.jdField_a_of_type_AndroidContentContext, "from_search_rzh_ws", 2, false);
              return true;
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("wsgzh")) && (this.c.equals("miniapp_player")) && ("openPlayer".equals(this.jdField_a_of_type_JavaUtilHashMap.get("action")))) {
              return tgn.a().a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("asyncmsg")) && (this.c.equals("open_async_detail"))) {
              return br();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("connect_miniapp")) && (this.c.equals("launch"))) {
              return am();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("im")) && (this.c.equals("aioorprofile"))) {
              return as();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("qapp")) {
              return bp();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.c.equals("show_nearby_fri"))) {
              return at();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.c.equals("show_location"))) {
              return ax();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("lbs")) && (this.c.equals("select_location"))) {
              return ay();
            }
            if (("card".equals(this.jdField_b_of_type_JavaLangString)) && ("show_pslcard".equals(this.c))) {
              return az();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("personal_tag")) && (this.c.equals("tag_list"))) {
              return aF();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("upload")) && (this.c.equals("photo"))) {
              return aN();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("forward")) && (this.c.equals("url"))) {
              return aR();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("forward")) && (this.c.equals("invite_register"))) {
              return bD();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("gamesdk")) && (this.c.equals("bind_group"))) {
              return aQ();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("opensdk")) && (this.c.equals("join_group"))) {
              return aO();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("opensdk")) && (this.c.equals("bind_group"))) {
              return aP();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.c.equals("to_fri"))) {
              return aS();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.c.equals("to_qqdataline"))) {
              return bo();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("gamesdk")) && (this.c.equals("add_friend")))
            {
              if (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"))) {
                k = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("is_from_game"));
              }
              return aU();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.c.equals("to_qqfav"))) {
              return aZ();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.c.equals("to_qzone"))) {
              return d("shareToQzone");
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("publish"))) {
              return ba();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("writemood"))) {
              return be();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("to_publish_queue"))) {
              return bf();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("open_homepage"))) {
              return bg();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("groupalbum"))) {
              return aV();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("to_friend_feeds"))) {
              return i();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("to_qzone_dialog"))) {
              return aW();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("to_redpocket_share"))) {
              return bb();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("open_redpocket"))) {
              return bc();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("qzone_schema"))) {
              return aX();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("shareLogToQQ"))) {
              return bd();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("qzone")) && (this.c.equals("qzone_publicaccount"))) {
              return aY();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("mqq"))
            {
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "handleMQQService");
              }
              l();
            }
            label4263:
            Object localObject3;
            while ((this.jdField_b_of_type_JavaLangString.equals("schedule")) && (this.c.equals("showDetail")))
            {
              return bs();
              if ((this.jdField_b_of_type_JavaLangString.equals("groupopenapp")) && (this.c.equals("openapp"))) {
                return bK();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("lightapp")) && (this.c.equals("open"))) {
                return bL();
              }
              if (this.jdField_b_of_type_JavaLangString.endsWith("app"))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("JumpAction", 2, "handleAppForward");
                }
                return bn();
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
                  return aJ();
                }
                return aM();
              }
              if ((this.jdField_b_of_type_JavaLangString.equals("dc")) && (this.c.equals("ft"))) {
                return bh();
              }
              if ("group".equals(this.jdField_b_of_type_JavaLangString))
              {
                if (this.c.equals("nearby")) {
                  return au();
                }
                if (this.c.equals("create")) {
                  return av();
                }
                if (this.c.equals("report")) {
                  return bF();
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
                  VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, bdtg.a(this.jdField_a_of_type_AndroidContentContext, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, null, false, -1);
                  return true;
                }
                if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.c.equals("theme")))
                {
                  if ((BaseApplicationImpl.IS_SUPPORT_THEME) && (bdeu.a()))
                  {
                    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, bdtg.a(this.jdField_a_of_type_AndroidContentContext, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, null, false, -1);
                    return true;
                  }
                }
                else if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.c.equals("font")))
                {
                  if ((((fx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).c()) && (bdeu.a()))
                  {
                    VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, bdtg.a(this.jdField_a_of_type_AndroidContentContext, "font", ""), 4096L, null, false, -1);
                    return true;
                  }
                }
                else
                {
                  if ((this.jdField_b_of_type_JavaLangString.equals("shop")) && (this.c.equals("pendant")))
                  {
                    if (bdeu.a()) {
                      bdfp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
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
                    localObject7 = new Intent();
                    localObject2 = this.jdField_a_of_type_JavaLangString.split("\\?");
                    if (localObject2.length < 2) {
                      break label8988;
                    }
                    ((Intent)localObject7).putExtra("extra_key_url_append", localObject2[1]);
                    if (localObject2[1] == null) {
                      break label8988;
                    }
                    if (localObject2[1].contains("tab=game_center"))
                    {
                      localObject2 = null;
                      i1 = 0;
                      i2 = 1;
                      if (QLog.isColorLevel()) {
                        QLog.d("JumpAction", 2, new Object[] { "apollo_store url:", localObject2 });
                      }
                      localObject5 = localObject2;
                      if (TextUtils.isEmpty((CharSequence)localObject2)) {
                        localObject5 = aliu.ah;
                      }
                      if (i2 == 0) {
                        break label4263;
                      }
                      ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext);
                    }
                    for (;;)
                    {
                      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
                      {
                        localObject2 = (aknx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
                        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_clk", ((aknx)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), 0, new String[] { "0" });
                      }
                      return true;
                      if (localObject2[1].contains("tab=other_url&url="))
                      {
                        localObject2 = URLDecoder.decode(localObject2[1].substring(localObject2[1].indexOf("tab=other_url&url=") + "tab=other_url&url=".length()));
                        i1 = 1;
                        i2 = 0;
                        break;
                      }
                      localObject5 = new HashMap();
                      vlb.a(localObject2[1], (HashMap)localObject5);
                      localObject2 = aknx.b((String)((HashMap)localObject5).get("tab"), true);
                      i2 = 0;
                      i1 = 0;
                      break;
                      if (i1 != 0) {
                        ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject5);
                      } else {
                        ApolloUtil.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject7, null, (String)localObject5, null);
                      }
                    }
                  }
                  if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.c.equals("game_invite")))
                  {
                    QLog.i("JumpAction", 1, "[cmshow.game_invite], source:" + this.jdField_a_of_type_JavaLangString);
                    return e(this.jdField_a_of_type_JavaLangString);
                  }
                  if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("avatar_edit".equals(this.c))) {
                    return Z();
                  }
                  if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_avatar_edit".equals(this.c))) {
                    return ab();
                  }
                  if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_dynamic_avatar_edit".equals(this.c))) {
                    return ac();
                  }
                  if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("sdk_face_collection".equals(this.c))) {
                    return aa();
                  }
                  if (("profile".equals(this.jdField_b_of_type_JavaLangString)) && ("more_info_edit".equals(this.c)))
                  {
                    localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, FriendProfileMoreInfoActivity.class);
                    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
                  }
                  else
                  {
                    if (("userprofile".equals(this.jdField_b_of_type_JavaLangString)) && ("friend_profile_card".equals(this.c)))
                    {
                      localObject2 = new ProfileActivity.AllInOne((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin"), 111);
                      if ("1".equals(this.jdField_a_of_type_JavaUtilHashMap.get("source"))) {
                        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 118;
                      }
                      for (;;)
                      {
                        ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject2);
                        break;
                        if ("2".equals(this.jdField_a_of_type_JavaUtilHashMap.get("source"))) {
                          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 121;
                        }
                      }
                    }
                    if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("might_know".equals(this.c))) {
                      return ad();
                    }
                    if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("search_might_know".equals(this.c))) {
                      return ae();
                    }
                    if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("new_friends".equals(this.c))) {
                      return af();
                    }
                    if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("contacts_tab".equals(this.c))) {
                      return ag();
                    }
                    if (("contact".equals(this.jdField_b_of_type_JavaLangString)) && ("phone_recommend".equals(this.c))) {
                      return ah();
                    }
                    if (((this.jdField_b_of_type_JavaLangString.equals("readingcenter")) || (this.jdField_b_of_type_JavaLangString.equals("qqreader"))) && (this.c.equals("open"))) {
                      return aw();
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("healthcenter")) && (this.c.equals("open")))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.i("JumpAction", 2, "enter jiankang");
                      }
                      ThreadManager.post(new JumpAction.2(this), 5, null, true);
                      if ((Build.VERSION.SDK_INT >= 19) && (((SensorManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("sensor")).getDefaultSensor(19) != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
                        ((bdys)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260)).a("jump action");
                      }
                      localObject5 = a((String)this.jdField_a_of_type_JavaUtilHashMap.get("url_prefix"));
                      if ((localObject5 == null) || ((!((String)localObject5).startsWith("http://")) && (!((String)localObject5).startsWith("https://"))) || ((!ndq.b((String)localObject5).equalsIgnoreCase("qq.com")) && (!ndq.b((String)localObject5).equalsIgnoreCase("myun.tenpay.com")) && (!ndq.b((String)localObject5).equalsIgnoreCase("tenpay.com")) && (!ndq.b((String)localObject5).equalsIgnoreCase("wanggou.com")))) {
                        return false;
                      }
                      localObject2 = localObject5;
                      if (((String)localObject5).indexOf("?") <= 0) {
                        localObject2 = (String)localObject5 + "?";
                      }
                      localObject5 = new StringBuilder((String)localObject2);
                      localObject7 = ((StringBuilder)localObject5).append("&client=androidQQ").append("&uin=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("&version=").append("8.3.5.4555").append("&system=").append(Build.VERSION.RELEASE).append("&device=").append(Build.DEVICE).append("&density=").append(ThemeUtil.getThemeDensity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())).append("&platformId=2").append("&_lv=0").append("&hasRedDot=");
                      if (this.jdField_h_of_type_Boolean) {}
                      for (localObject2 = "1";; localObject2 = "0")
                      {
                        ((StringBuilder)localObject7).append((String)localObject2).append("&adtag=mvip.gongneng.anroid.health.nativet");
                        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
                        ((StringBuilder)localObject5).append("&lati=").append(((SharedPreferences)localObject2).getFloat("search_lbs_latitude", 0.0F));
                        ((StringBuilder)localObject5).append("&logi=").append(((SharedPreferences)localObject2).getFloat("search_lbs_logitude", 0.0F));
                        i1 = bdin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
                        ((StringBuilder)localObject5).append("&netType=" + i1);
                        localObject2 = bdgk.d();
                        ((StringBuilder)localObject5).append("&model=" + (String)localObject2);
                        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                        ((Intent)localObject2).putExtra("url", ((StringBuilder)localObject5).toString());
                        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
                        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
                        return true;
                      }
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("ptlogin")) && (this.c.equals("qlogin"))) {
                      return bi();
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("gav")) && (this.c.equals("request"))) {
                      return bj();
                    }
                    if (("videochat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.c))) {
                      return bk();
                    }
                    if (("randomavchat".equals(this.jdField_b_of_type_JavaLangString)) && ("request".equals(this.c))) {
                      return bl();
                    }
                    if (this.jdField_b_of_type_JavaLangString.equals("tribe"))
                    {
                      localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("bid");
                      localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("sourceUrl");
                      if (this.c.equals("web")) {
                        localObject7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("url");
                      }
                      try
                      {
                        localObject7 = URLDecoder.decode((String)localObject7);
                        localObject7 = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class).putExtra("url", (String)localObject7);
                        ((Intent)localObject7).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                        ((Intent)localObject7).putExtra("hide_operation_bar", true);
                        ((Intent)localObject7).putExtra("hideRightButton", true);
                        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject7);
                        if ((localObject2 != null) && (localObject5 != null)) {
                          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_tribe", "", "url", "visit", 0, 1, 0, (String)localObject2, ndq.b((String)localObject5, new String[0]), "", "");
                        }
                        return true;
                      }
                      catch (Exception localException2)
                      {
                        if (QLog.isDevelopLevel()) {
                          QLog.e("JumpAction", 4, "URLDecoder.decode error");
                        }
                        return false;
                      }
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("qqdataline")) && (this.c.equals("openqqdataline"))) {
                      return aj();
                    }
                    if ((this.jdField_b_of_type_JavaLangString.equals("wallet")) && (this.c.equals("modify_pass"))) {
                      return ai();
                    }
                    if (this.jdField_b_of_type_JavaLangString.equals("dating"))
                    {
                      if (this.c.equals("detail")) {
                        return Y();
                      }
                      if (this.c.equals("publish")) {
                        return X();
                      }
                      if (this.c.equals("feed")) {
                        return W();
                      }
                    }
                    else if (this.jdField_b_of_type_JavaLangString.equals("nearby_entry"))
                    {
                      if (this.c.equals("nearby_feed")) {
                        return R();
                      }
                      if (this.c.equals("nearby_profile")) {
                        return aA();
                      }
                      if (this.c.equals("hotchat_list")) {
                        return T();
                      }
                      if (this.c.equals("hotchat_room")) {
                        return U();
                      }
                      if (this.c.equals("visitor_list")) {
                        return w();
                      }
                    }
                    else if (this.jdField_b_of_type_JavaLangString.equals("nearby"))
                    {
                      if (this.c.equals("reportFriend")) {
                        return bG();
                      }
                    }
                    else if (this.jdField_b_of_type_JavaLangString.equals("hotchat"))
                    {
                      if (this.c.equals("newyear_scene")) {
                        return V();
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
                        return bq();
                      }
                      if ((this.jdField_b_of_type_JavaLangString.equals("share")) && (this.c.equals("to_troopbar"))) {
                        return bt();
                      }
                      if ((this.jdField_b_of_type_JavaLangString.equals("qqconnect")) && (this.c.equals("url"))) {
                        return bu();
                      }
                      if ((this.jdField_b_of_type_JavaLangString.equals("publicdevice")) && (this.c.equals("url"))) {
                        return bv();
                      }
                      if ((this.jdField_b_of_type_JavaLangString.equals("openLightApp")) && (this.c.equals("url"))) {
                        return k();
                      }
                      if (("tenpay".equals(this.jdField_b_of_type_JavaLangString)) && ("sendHongBao".equals(this.c))) {
                        return bw();
                      }
                      if (("massbless".endsWith(this.jdField_b_of_type_JavaLangString)) && ("mainpage".equals(this.c))) {
                        return l();
                      }
                      if (!this.jdField_b_of_type_JavaLangString.equals("rankinglist"))
                      {
                        if (this.jdField_b_of_type_JavaLangString.equals("interesttag")) {
                          return Q();
                        }
                        if (this.jdField_b_of_type_JavaLangString.equals("qqcomic")) {
                          return bm();
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
                          return bx();
                        }
                        if ("huayang".equals(this.jdField_b_of_type_JavaLangString)) {
                          return by();
                        }
                        if ("qboss".equals(this.jdField_b_of_type_JavaLangString)) {
                          return awzj.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
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
                            localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("articleid");
                            i1 = Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("uin_type"));
                            if (!TextUtils.isEmpty((CharSequence)localObject3))
                            {
                              localObject5 = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountImageCollectionMainActivity.class);
                              ((Intent)localObject5).putExtra("source_for_report", i1);
                              tpp.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject5, (String)localObject3);
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
                              for (localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rowkey"); TextUtils.isEmpty((CharSequence)localObject3); localObject3 = "")
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.e("JumpAction", 2, "rowKey is Empty");
                                }
                                return false;
                              }
                              label6820:
                              label6848:
                              label6876:
                              String str2;
                              label6904:
                              String str3;
                              label6932:
                              label6960:
                              String str4;
                              label6988:
                              label7016:
                              String str5;
                              if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("picindex"))
                              {
                                localObject5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("picindex");
                                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("source")) {
                                  break label7187;
                                }
                                localObject7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
                                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("enteranimationstyle")) {
                                  break label7195;
                                }
                                str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("enteranimationstyle");
                                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("hideTopic")) {
                                  break label7203;
                                }
                                str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("hideTopic");
                                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("commentId")) {
                                  break label7206;
                                }
                                str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("commentId");
                                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("subCommentId")) {
                                  break label7213;
                                }
                                str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("subCommentId");
                                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("albumStyle")) {
                                  break label7220;
                                }
                                str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("albumStyle");
                                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("jumpCommentType")) {
                                  break label7223;
                                }
                                str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jumpCommentType");
                                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("isAwesome")) {
                                  break label7230;
                                }
                                str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("isAwesome");
                              }
                              for (;;)
                              {
                                for (;;)
                                {
                                  try
                                  {
                                    Integer.valueOf((String)localObject5).intValue();
                                    i1 = Integer.valueOf((String)localObject7).intValue();
                                  }
                                  catch (Exception localException3)
                                  {
                                    label7187:
                                    label7195:
                                    label7203:
                                    label7206:
                                    label7213:
                                    label7220:
                                    label7223:
                                    label7230:
                                    i1 = 0;
                                  }
                                  try
                                  {
                                    Integer.valueOf(str1).intValue();
                                    i2 = i1;
                                    if (!Boolean.valueOf(bkbq.t(ors.a())).booleanValue()) {
                                      break label7263;
                                    }
                                    localObject3 = "http://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&rowkey=" + (String)localObject3 + "&album_source=" + i2 + "&isAwesome=" + str5 + "&commentId=" + str2 + "&subCommentId=" + str3 + "&jumpCommentType=" + str4;
                                    smk.a(this.jdField_a_of_type_AndroidContentContext, null, (String)localObject3, null);
                                  }
                                  catch (Exception localException4)
                                  {
                                    label7241:
                                    break label7241;
                                  }
                                }
                                localObject5 = "0";
                                break label6820;
                                localObject7 = "0";
                                break label6848;
                                str1 = "0";
                                break label6876;
                                break label6904;
                                str2 = "";
                                break label6932;
                                str3 = "";
                                break label6960;
                                break label6988;
                                str4 = "";
                                break label7016;
                                str5 = "";
                                continue;
                                i2 = i1;
                                if (QLog.isColorLevel())
                                {
                                  QLog.e("JumpAction", 2, "Parameter error");
                                  i2 = i1;
                                }
                              }
                              label7263:
                              if (QLog.isColorLevel()) {
                                QLog.e("JumpAction", 2, "jumpToGallery failed: atlas has undercarriage");
                              }
                            }
                            else
                            {
                              if (this.c.equals("selfpage"))
                              {
                                nxu.a(this.jdField_a_of_type_AndroidContentContext, false);
                                return true;
                              }
                              if ("showugceditor".equals(this.c))
                              {
                                g();
                              }
                              else if ("openarticle".equals(this.c))
                              {
                                localObject3 = nxu.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
                                if ((this.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)) {
                                  ((FastWebActivity)this.jdField_a_of_type_AndroidContentContext).a((Intent)localObject3);
                                } else {
                                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
                                }
                              }
                            }
                          }
                        }
                        else if ((this.jdField_b_of_type_JavaLangString.equals("cmshow")) && (this.c.equals("apollo_action")))
                        {
                          if (aknx.a(this.jdField_a_of_type_AndroidContentContext)) {
                            return v();
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
                              localObject3 = new Intent();
                              ((Intent)localObject3).putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690623));
                              return bivc.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject3, -1, false);
                            }
                          }
                          else if ("hongbao_share".equals(this.jdField_b_of_type_JavaLangString))
                          {
                            if ("hongbao_brush".equals(this.c)) {
                              return L();
                            }
                          }
                          else if ("general_ar".equals(this.jdField_b_of_type_JavaLangString))
                          {
                            if ("gotoScannerTorchActivity".equals(this.c)) {
                              return O();
                            }
                          }
                          else
                          {
                            if ("mqqavshare://".equals(this.jdField_b_of_type_JavaLangString))
                            {
                              this.jdField_e_of_type_Boolean = true;
                              return max.a(this);
                            }
                            if ("setting".equals(this.jdField_b_of_type_JavaLangString))
                            {
                              if ("general".equals(this.c)) {
                                return t();
                              }
                            }
                            else if ("assistant_setting".equals(this.jdField_b_of_type_JavaLangString))
                            {
                              if ("ASSISTANT_SETTING".equals(this.c)) {
                                return u();
                              }
                            }
                            else if ((this.jdField_b_of_type_JavaLangString.equals("conf")) || (this.jdField_b_of_type_JavaLangString.equals("confpstn")) || (this.jdField_b_of_type_JavaLangString.equals("confhr")))
                            {
                              if (this.c.equals("ft")) {
                                return x();
                              }
                            }
                            else if (!"olympic_entry".equals(this.jdField_b_of_type_JavaLangString)) {
                              if ("teamwork".equals(this.jdField_b_of_type_JavaLangString))
                              {
                                if ("opendoclist".equals(this.c)) {
                                  return K();
                                }
                              }
                              else
                              {
                                if ("qstory".equals(this.jdField_b_of_type_JavaLangString))
                                {
                                  if ("openNow".equals(this.c)) {
                                    return y();
                                  }
                                  return I();
                                }
                                if ("now".equals(this.jdField_b_of_type_JavaLangString))
                                {
                                  if ("openroom".equals(this.c)) {
                                    return y();
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
              return z();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("profile")) && (this.c.equals("setting"))) {
              return A();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("qqreg")) {
              return bE();
            }
            if ((this.jdField_b_of_type_JavaLangString.equals("troop_member_card")) && (this.c.equals("open_member_recent_chat_view"))) {
              return S();
            }
            if (this.jdField_b_of_type_JavaLangString.equals("qwerewolf"))
            {
              if (this.c.equals("openInvitationRoom")) {
                return G();
              }
              if (this.c.equals("enterGameRoom")) {
                return H();
              }
            }
            else if (this.jdField_b_of_type_JavaLangString.equals("groupvideo"))
            {
              if (this.c.equals("openroom")) {
                return bH();
              }
              if (this.c.equals("preload")) {
                return bI();
              }
            }
            else if (this.jdField_b_of_type_JavaLangString.equals("studyroom"))
            {
              if (this.c.equals("enter")) {
                return bJ();
              }
            }
            else if (this.jdField_b_of_type_JavaLangString.equals("invite_join_group"))
            {
              if (this.c.equals("open")) {
                return B();
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
                  localObject3 = (bclb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(224);
                  NearbyVideoChatProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, null, ((bclb)localObject3).a(), null, 123987);
                  return true;
                }
                QLog.i("JumpAction", 1, "openNearbyVideoChatActivity, context is not a activity");
                return false;
              }
              if (!"weishitab".equals(this.jdField_b_of_type_JavaLangString)) {
                break label8303;
              }
              if ("open".equals(this.c)) {
                f();
              }
            }
            label8303:
            do
            {
              do
              {
                return false;
                if ("page_router".equals(this.jdField_b_of_type_JavaLangString))
                {
                  M();
                  return true;
                }
                if ("msg_list".equals(this.jdField_b_of_type_JavaLangString))
                {
                  N();
                  return true;
                }
                if (!"watchtogether".equals(this.jdField_b_of_type_JavaLangString)) {
                  break;
                }
              } while (!this.c.equals("openroom"));
              return bM();
              if ("share_group".equals(this.jdField_b_of_type_JavaLangString))
              {
                if (this.c.equals("open"))
                {
                  localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
                  if (localObject3 != null) {
                    bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject3);
                  }
                }
                return true;
              }
              if ("edit_group".equals(this.jdField_b_of_type_JavaLangString))
              {
                if (this.c.equals("open"))
                {
                  localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("groupcode");
                  if (localObject3 != null) {
                    bcpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject3);
                  }
                }
                return true;
              }
              if ("weishiforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                tch.a(this.jdField_a_of_type_AndroidContentContext, "from_audio_assistant", 1, true);
                return true;
              }
              if ("nearbyforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyGuideActivity.class);
                ((Intent)localObject3).putExtra("ENTER_TIME", System.currentTimeMillis());
                ((Intent)localObject3).putExtra("IS_HAS_REDTOUCH", false);
                ((Intent)localObject3).putExtra("FROM_WHERE", 1);
                ((Intent)localObject3).putExtra("RANK_BANNER_PUSH", "");
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
                return true;
              }
              if ("qechatforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                ExtendFriendPublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext);
                return true;
              }
              if ("searchforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                localObject3 = b("searchkey");
                UniteSearchActivity.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject3, 10004);
                return true;
              }
              if ("settingsforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQSettingSettingActivity.class);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject3);
                return true;
              }
              if ("confiessmsgforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                localObject7 = ((aoiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
                Object localObject6 = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
                localObject3 = localObject6;
                if (localObject7 != null)
                {
                  localObject3 = localObject6;
                  if (!TextUtils.isEmpty(((aoiq)localObject7).l)) {
                    localObject3 = ((aoiq)localObject7).l;
                  }
                }
                localObject6 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
                ((Intent)localObject6).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                ((Intent)localObject6).putExtra("url", (String)localObject3);
                this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject6);
                return true;
              }
              if ("scanforqassistant".equals(this.jdField_b_of_type_JavaLangString))
              {
                if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
                  ajkg.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, 0L, 0L, 0);
                }
                return true;
              }
              if ("bind_number".equals(this.jdField_b_of_type_JavaLangString))
              {
                if ("bind".equals(this.c))
                {
                  P();
                  return true;
                }
                return false;
              }
              if ("stickynote".equals(this.jdField_b_of_type_JavaLangString))
              {
                if ("feeddetail".equals(this.c))
                {
                  e();
                  return true;
                }
                return false;
              }
            } while (!"commonBuddyGroup".equals(this.jdField_b_of_type_JavaLangString));
            if ("open".equals(this.c))
            {
              d();
              return true;
            }
            return false;
            localException5 = localException5;
            l1 = l2;
          }
        }
        catch (Exception localException6)
        {
          break label1121;
        }
      }
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
    Object localObject = (azbw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if ((localObject != null) && ((((azbw)localObject).a(2) > 0) || (((azbw)localObject).a(1) > 0))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("newflag", bool);
      ((Intent)localObject).putExtra("refer", "schemeActiveFeeds");
      QzonePluginProxyActivity.a((Intent)localObject, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
      ((Intent)localObject).addFlags(805306368);
      String str = Uri.parse(this.jdField_a_of_type_JavaLangString).getQueryParameter("push_trans_channel");
      bjdt.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (Intent)localObject, str, -1);
      LpReportInfo_dc02880.report(this.jdField_a_of_type_JavaLangString);
      return true;
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    String str = a(a(a(a(a(a(QzoneConfig.getInstance().getConfig("H5Url", "PersonalQzoneVisitor", "https://h5.qzone.qq.com/visitor/qzone/personal?uin={uin}&qua={qua}&clicktime={clicktime}&_bid=329&_wv=3&_proxy=true"), "{hostUin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "{clicktime}", String.valueOf(System.currentTimeMillis())), "{from}", "androidQQ"), "{qua}", bjdm.a()), "{uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "{UIN}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("fromQZone", true);
    localIntent.putExtra("injectrecommend", true);
    localIntent.putExtra("articalChannelId", 5);
    if (behc.jdField_a_of_type_JavaUtilHashMap.containsKey("Qzone")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "Qzone" });
    }
    localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131718341));
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
    aagc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, (String)localObject, localBundle);
    return true;
  }
  
  public boolean l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JumpAction", 2, "gotoSendBless");
    }
    ahcr localahcr = (ahcr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(138);
    if (localahcr.a()) {
      localahcr.a(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      return true;
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, alud.a(2131706295), 0).a();
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
      int i1 = syb.a(Integer.parseInt((String)this.jdField_a_of_type_JavaUtilHashMap.get("account_flag")));
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
      localObject = (alrr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
    } while (localObject == null);
    ((alrr)localObject).a(SystemClock.uptimeMillis());
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
        ((atet)((QQAppInterface)localObject5).getManager(108)).a(this.jdField_a_of_type_AndroidContentContext, l1, "launcher", (String)localObject1, (String)localObject3, i1);
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
        nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067C6", "0X80067C6", 0, 0, "", "1", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", false);
      }
      if ("webview".equals(this.m)) {
        yqz.a().a((String)localObject1, this.jdField_a_of_type_JavaUtilHashMap);
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
        if (bkbq.g())
        {
          try
          {
            localObject1 = nxu.a(this.jdField_a_of_type_AndroidContentContext, i1);
            if (i1 == 16)
            {
              ((Intent)localObject1).putExtra("redpackid", (String)this.jdField_a_of_type_JavaUtilHashMap.get("redpackid"));
              ((Intent)localObject1).putExtra("redpack_type", 3);
              ((Intent)localObject1).putExtra("plat_source", bhsn.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("plat_source")));
            }
            this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
          }
          catch (Exception localException1) {}
          if (QLog.isColorLevel()) {
            QLog.e("JumpAction", 1, "jump activity error1 ", localException1);
          }
        }
        else if (i1 == 16)
        {
          i1 = bhsn.a((String)this.jdField_a_of_type_JavaUtilHashMap.get("plat_source"));
          RIJRedPacketManager.a().a(BaseActivity.sTopActivity, (String)this.jdField_a_of_type_JavaUtilHashMap.get("redpackid"), 3, i1, false, null);
        }
        else if (bkbq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          nxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 2, 0);
        }
        else
        {
          nxu.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, 2);
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
        break label1545;
      }
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131700034);
    }
    label1545:
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
                yqz.a().l();
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
                if (bkbq.k())
                {
                  nxu.a(this.jdField_a_of_type_AndroidContentContext, i2, (String)localObject2, i3, 4);
                  break;
                }
                nxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 4, 1);
                break;
              }
              nxu.b(this.jdField_a_of_type_AndroidContentContext, i2, (String)localObject2, i3, 4);
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
              break label1037;
            }
            i1 = Integer.valueOf((String)this.jdField_a_of_type_JavaUtilHashMap.get("from")).intValue();
            if (!bkbq.i()) {
              break label996;
            }
            try
            {
              localObject2 = nxu.a(this.jdField_a_of_type_AndroidContentContext, i1);
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
            }
            catch (Exception localException2) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("JumpAction", 1, "jump activity error1 ", localException2);
          break;
          label996:
          if (bkbq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            nxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, i1, 0);
            break;
          }
          nxu.a(this.jdField_a_of_type_AndroidContentContext, null, -1L, i1);
          break;
          label1037:
          Object localObject3;
          if ("3".equals(str5))
          {
            localObject3 = nxu.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
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
            nxu.a((Context)localObject3, this.jdField_a_of_type_JavaUtilHashMap);
            break;
          }
          if ("5".equals(str5))
          {
            nxu.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
            break;
          }
          if (!"6".equals(str5)) {
            break label1268;
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
            smk.a(this.jdField_a_of_type_AndroidContentContext, "", (String)localObject3, null);
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            QLog.w("JumpAction", 1, "[gotoReadInJoyFromSourceTarget] openViolaPage, v_url error->" + localException3.getMessage());
          }
        }
        break;
        label1268:
        if ("7".equals(str5))
        {
          nxu.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
          break;
        }
        if ("8".equals(str5))
        {
          if ("webview".equals(this.m))
          {
            yqz.a().f(this.m);
            break;
          }
          KandianDailyManager.a(this.jdField_a_of_type_AndroidContentContext);
          break;
        }
        if ("9".equals(str5))
        {
          bkbx.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
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
              localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131700034);
            }
            if (!bkbq.k()) {
              break label1482;
            }
            try
            {
              Intent localIntent1 = nxu.a(this.jdField_a_of_type_AndroidContentContext, 12);
              this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
            }
            catch (Exception localException4) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("JumpAction", 1, "jump activity error1 ", localException4);
          break;
          label1482:
          Intent localIntent2 = new Intent("android.intent.action.MAIN");
          localIntent2.putExtra("channel_id", i1);
          localIntent2.putExtra("channel_name", (String)localObject4);
          localIntent2.putExtra("readinjoy_launch_source", 7);
          bkbq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localIntent2);
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
            azqs.b(null, str3, str4, str5, str1, str2, i1, i2, str6, str8, str9, str10);
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
      bkbq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, l1, i2, i3);
    }
    catch (Exception localException)
    {
      label326:
      break label326;
    }
    return true;
  }
  
  /* Error */
  public boolean s()
  {
    // Byte code:
    //   0: new 116	android/os/Bundle
    //   3: dup
    //   4: invokespecial 117	android/os/Bundle:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc_w 6511
    //   14: aload_0
    //   15: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   18: ldc_w 1632
    //   21: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 50	java/lang/String
    //   27: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload 5
    //   35: ldc_w 6513
    //   38: aload_0
    //   39: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   42: ldc_w 1810
    //   45: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast 50	java/lang/String
    //   51: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   54: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 5
    //   59: ldc_w 6515
    //   62: aload_0
    //   63: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   66: ldc_w 6517
    //   69: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 50	java/lang/String
    //   75: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 5
    //   80: ldc_w 6519
    //   83: aload_0
    //   84: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   87: ldc_w 6521
    //   90: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast 50	java/lang/String
    //   96: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload 5
    //   101: ldc_w 6523
    //   104: aload_0
    //   105: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   108: ldc_w 6525
    //   111: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: checkcast 50	java/lang/String
    //   117: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 5
    //   122: ldc_w 6527
    //   125: aload_0
    //   126: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   129: ldc_w 6529
    //   132: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 50	java/lang/String
    //   138: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 5
    //   143: ldc_w 6531
    //   146: aload_0
    //   147: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   150: ldc_w 6533
    //   153: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   156: checkcast 50	java/lang/String
    //   159: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload 5
    //   164: ldc_w 6535
    //   167: iconst_0
    //   168: invokevirtual 725	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   171: aload 5
    //   173: ldc_w 6537
    //   176: ldc_w 778
    //   179: aload_0
    //   180: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   183: ldc_w 6539
    //   186: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   189: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   192: invokevirtual 725	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   195: aload 5
    //   197: ldc_w 6541
    //   200: aload_0
    //   201: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   204: ldc_w 6543
    //   207: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: checkcast 50	java/lang/String
    //   213: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   216: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   223: ldc_w 6545
    //   226: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   229: checkcast 1004	java/lang/CharSequence
    //   232: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne +40 -> 275
    //   238: aload 5
    //   240: ldc_w 6547
    //   243: new 6549	java/math/BigInteger
    //   246: dup
    //   247: aload_0
    //   248: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   251: ldc_w 6545
    //   254: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   257: checkcast 50	java/lang/String
    //   260: invokespecial 6550	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   263: invokevirtual 6551	java/math/BigInteger:longValue	()J
    //   266: invokestatic 823	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: invokevirtual 150	java/lang/Long:longValue	()J
    //   272: invokevirtual 129	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   275: aload_0
    //   276: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   279: ldc_w 6553
    //   282: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   285: checkcast 1004	java/lang/CharSequence
    //   288: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   291: ifne +30 -> 321
    //   294: aload 5
    //   296: ldc_w 6555
    //   299: aload_0
    //   300: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   303: ldc_w 6553
    //   306: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   309: checkcast 50	java/lang/String
    //   312: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   315: invokevirtual 800	java/lang/Integer:intValue	()I
    //   318: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   321: aload_0
    //   322: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   325: ldc_w 6557
    //   328: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   331: checkcast 1004	java/lang/CharSequence
    //   334: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   337: ifne +24 -> 361
    //   340: aload 5
    //   342: ldc_w 6559
    //   345: aload_0
    //   346: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   349: ldc_w 6557
    //   352: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   355: checkcast 50	java/lang/String
    //   358: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload_0
    //   362: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   365: ldc_w 6561
    //   368: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: checkcast 50	java/lang/String
    //   374: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   377: ifne +1407 -> 1784
    //   380: aload 5
    //   382: ldc_w 6563
    //   385: aload_0
    //   386: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   389: ldc_w 6561
    //   392: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   395: checkcast 50	java/lang/String
    //   398: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   401: invokevirtual 800	java/lang/Integer:intValue	()I
    //   404: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   407: aload_0
    //   408: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   411: ldc_w 6565
    //   414: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   417: checkcast 50	java/lang/String
    //   420: astore 4
    //   422: aload 4
    //   424: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   427: ifne +19 -> 446
    //   430: aload 5
    //   432: ldc_w 6567
    //   435: aload 4
    //   437: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   440: invokevirtual 800	java/lang/Integer:intValue	()I
    //   443: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   446: aload 5
    //   448: ldc_w 6569
    //   451: aload_0
    //   452: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   455: ldc_w 6571
    //   458: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   461: checkcast 50	java/lang/String
    //   464: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload 5
    //   472: ldc_w 6573
    //   475: aload_0
    //   476: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   479: ldc_w 6575
    //   482: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   485: checkcast 50	java/lang/String
    //   488: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   491: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload_0
    //   495: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   498: ldc_w 6577
    //   501: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   504: checkcast 50	java/lang/String
    //   507: astore 4
    //   509: aload 4
    //   511: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   514: ifne +19 -> 533
    //   517: aload 5
    //   519: ldc_w 6577
    //   522: aload 4
    //   524: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   527: invokevirtual 800	java/lang/Integer:intValue	()I
    //   530: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   533: aload_0
    //   534: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   537: ldc_w 6579
    //   540: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   543: checkcast 50	java/lang/String
    //   546: astore 4
    //   548: aload 4
    //   550: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   553: ifne +19 -> 572
    //   556: aload 5
    //   558: ldc_w 6579
    //   561: aload 4
    //   563: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   566: invokevirtual 800	java/lang/Integer:intValue	()I
    //   569: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   572: aload_0
    //   573: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   576: ldc_w 6581
    //   579: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   582: checkcast 50	java/lang/String
    //   585: astore 4
    //   587: aload 4
    //   589: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   592: ifne +19 -> 611
    //   595: aload 5
    //   597: ldc_w 6581
    //   600: aload 4
    //   602: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   605: invokevirtual 800	java/lang/Integer:intValue	()I
    //   608: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   611: aload_0
    //   612: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   615: ldc_w 6583
    //   618: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   621: checkcast 50	java/lang/String
    //   624: astore 4
    //   626: aload 4
    //   628: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   631: ifne +19 -> 650
    //   634: aload 5
    //   636: ldc_w 6583
    //   639: aload 4
    //   641: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   644: invokevirtual 800	java/lang/Integer:intValue	()I
    //   647: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   650: aload_0
    //   651: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   654: ldc_w 5896
    //   657: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   660: checkcast 50	java/lang/String
    //   663: astore 4
    //   665: aload 4
    //   667: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   670: ifne +116 -> 786
    //   673: aload_0
    //   674: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   677: ldc_w 5898
    //   680: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   683: checkcast 50	java/lang/String
    //   686: astore 6
    //   688: aload_0
    //   689: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   692: ldc_w 5902
    //   695: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   698: checkcast 50	java/lang/String
    //   701: astore 7
    //   703: aload_0
    //   704: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   707: ldc_w 5904
    //   710: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   713: checkcast 50	java/lang/String
    //   716: astore 8
    //   718: new 6585	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData
    //   721: dup
    //   722: invokespecial 6586	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:<init>	()V
    //   725: astore 9
    //   727: aload 9
    //   729: aload 4
    //   731: putfield 6587	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   734: aload 9
    //   736: aload 6
    //   738: putfield 6588	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   741: aload 9
    //   743: ldc_w 523
    //   746: aload 7
    //   748: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   751: putfield 6589	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_b_of_type_Boolean	Z
    //   754: aload 9
    //   756: ldc_w 778
    //   759: aload 8
    //   761: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   764: putfield 6590	com/tencent/biz/pubaccount/readinjoy/comment/data/AnchorData:jdField_a_of_type_Boolean	Z
    //   767: aload 5
    //   769: ldc_w 6592
    //   772: iconst_1
    //   773: invokevirtual 725	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   776: aload 5
    //   778: ldc_w 6594
    //   781: aload 9
    //   783: invokevirtual 6598	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   786: aload 5
    //   788: ldc_w 6600
    //   791: aload_0
    //   792: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   795: ldc_w 6352
    //   798: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   801: checkcast 50	java/lang/String
    //   804: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   807: ldc_w 778
    //   810: aload_0
    //   811: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   814: ldc_w 6602
    //   817: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   820: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   823: ifeq +1064 -> 1887
    //   826: iconst_1
    //   827: istore_1
    //   828: aload 5
    //   830: ldc_w 6604
    //   833: iload_1
    //   834: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   837: iload_1
    //   838: ifne +802 -> 1640
    //   841: aload_0
    //   842: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   845: ldc_w 6539
    //   848: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   851: checkcast 50	java/lang/String
    //   854: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   857: invokevirtual 800	java/lang/Integer:intValue	()I
    //   860: istore_2
    //   861: aload 5
    //   863: ldc_w 6606
    //   866: iload_2
    //   867: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   870: aload_0
    //   871: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   874: ldc_w 6608
    //   877: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   880: checkcast 50	java/lang/String
    //   883: invokestatic 147	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   886: invokevirtual 150	java/lang/Long:longValue	()J
    //   889: iconst_1
    //   890: invokestatic 6613	orr:a	(JZ)Ljava/lang/String;
    //   893: astore 4
    //   895: aload 5
    //   897: ldc_w 6615
    //   900: aload 4
    //   902: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   905: aload 5
    //   907: ldc_w 6617
    //   910: aload_0
    //   911: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   914: ldc_w 6619
    //   917: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   920: checkcast 50	java/lang/String
    //   923: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   926: aload 5
    //   928: ldc_w 6621
    //   931: aload_0
    //   932: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   935: ldc_w 6623
    //   938: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   941: checkcast 50	java/lang/String
    //   944: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   947: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   950: aload 5
    //   952: ldc_w 6625
    //   955: aload_0
    //   956: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   959: ldc_w 6627
    //   962: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   965: checkcast 50	java/lang/String
    //   968: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   971: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   974: aload 5
    //   976: ldc_w 6629
    //   979: aload_0
    //   980: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   983: ldc_w 6631
    //   986: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   989: checkcast 50	java/lang/String
    //   992: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   995: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   998: aload_0
    //   999: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1002: ldc_w 6633
    //   1005: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1008: ifeq +46 -> 1054
    //   1011: aload_0
    //   1012: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1015: ldc_w 6633
    //   1018: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1021: checkcast 1004	java/lang/CharSequence
    //   1024: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1027: ifne +27 -> 1054
    //   1030: aload 5
    //   1032: ldc_w 6635
    //   1035: aload_0
    //   1036: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1039: ldc_w 6633
    //   1042: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1045: checkcast 50	java/lang/String
    //   1048: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1051: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1054: aload_0
    //   1055: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1058: ldc_w 6529
    //   1061: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1064: checkcast 50	java/lang/String
    //   1067: invokestatic 6640	osf:a	(Ljava/lang/String;)Losl;
    //   1070: astore 4
    //   1072: aload 4
    //   1074: ifnull +29 -> 1103
    //   1077: aload 5
    //   1079: ldc_w 6642
    //   1082: aload 4
    //   1084: getfield 6645	osl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1087: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1090: aload 5
    //   1092: ldc_w 6647
    //   1095: aload 4
    //   1097: getfield 6648	osl:jdField_a_of_type_Long	J
    //   1100: invokevirtual 129	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1103: new 116	android/os/Bundle
    //   1106: dup
    //   1107: invokespecial 117	android/os/Bundle:<init>	()V
    //   1110: astore 4
    //   1112: aload 4
    //   1114: ldc_w 6650
    //   1117: aload_0
    //   1118: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1121: ldc_w 6529
    //   1124: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1127: checkcast 50	java/lang/String
    //   1130: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1133: aload 4
    //   1135: ldc_w 6652
    //   1138: aload_0
    //   1139: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1142: ldc_w 6529
    //   1145: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1148: checkcast 50	java/lang/String
    //   1151: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1154: aload 4
    //   1156: ldc_w 6654
    //   1159: aload_0
    //   1160: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1163: ldc_w 6517
    //   1166: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1169: checkcast 50	java/lang/String
    //   1172: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1175: invokevirtual 800	java/lang/Integer:intValue	()I
    //   1178: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1181: aload 4
    //   1183: ldc_w 6656
    //   1186: aload_0
    //   1187: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1190: ldc_w 6521
    //   1193: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1196: checkcast 50	java/lang/String
    //   1199: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1202: invokevirtual 800	java/lang/Integer:intValue	()I
    //   1205: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1208: aload 4
    //   1210: ldc_w 6658
    //   1213: aload_0
    //   1214: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1217: ldc_w 6525
    //   1220: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1223: checkcast 50	java/lang/String
    //   1226: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1229: invokevirtual 800	java/lang/Integer:intValue	()I
    //   1232: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1235: aload 4
    //   1237: ldc_w 6660
    //   1240: aload_0
    //   1241: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1244: ldc_w 6517
    //   1247: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1250: checkcast 50	java/lang/String
    //   1253: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1256: invokevirtual 800	java/lang/Integer:intValue	()I
    //   1259: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1262: aload_0
    //   1263: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1266: ldc_w 6539
    //   1269: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1272: checkcast 50	java/lang/String
    //   1275: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1278: invokevirtual 800	java/lang/Integer:intValue	()I
    //   1281: iconst_1
    //   1282: if_icmpne +791 -> 2073
    //   1285: aload 4
    //   1287: ldc_w 6662
    //   1290: aload_0
    //   1291: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1294: ldc_w 6619
    //   1297: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1300: checkcast 50	java/lang/String
    //   1303: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1306: aload 4
    //   1308: ldc_w 6664
    //   1311: aload_0
    //   1312: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1315: ldc_w 6623
    //   1318: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1321: checkcast 50	java/lang/String
    //   1324: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1327: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1330: aload 4
    //   1332: ldc_w 6666
    //   1335: aload_0
    //   1336: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1339: ldc_w 6619
    //   1342: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1345: checkcast 50	java/lang/String
    //   1348: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1351: aload 4
    //   1353: ldc_w 6668
    //   1356: aload_0
    //   1357: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1360: ldc_w 6539
    //   1363: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1366: checkcast 50	java/lang/String
    //   1369: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1372: invokevirtual 800	java/lang/Integer:intValue	()I
    //   1375: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1378: aload 4
    //   1380: ldc_w 6670
    //   1383: aload_0
    //   1384: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1387: ldc_w 6533
    //   1390: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1393: checkcast 50	java/lang/String
    //   1396: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1399: aload 4
    //   1401: ldc_w 6672
    //   1404: iconst_5
    //   1405: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1408: aload 4
    //   1410: ldc_w 6674
    //   1413: iconst_0
    //   1414: invokevirtual 725	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1417: aload 4
    //   1419: ldc_w 2706
    //   1422: aload_0
    //   1423: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1426: ldc_w 6575
    //   1429: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1432: checkcast 50	java/lang/String
    //   1435: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1438: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1441: aload 4
    //   1443: ldc_w 1683
    //   1446: aload_0
    //   1447: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1450: ldc_w 6571
    //   1453: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1456: checkcast 50	java/lang/String
    //   1459: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1462: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1465: aload 4
    //   1467: ldc_w 6543
    //   1470: aload_0
    //   1471: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1474: ldc_w 6529
    //   1477: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1480: checkcast 50	java/lang/String
    //   1483: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1486: aload 4
    //   1488: ldc_w 1632
    //   1491: aload_0
    //   1492: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1495: ldc_w 1632
    //   1498: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1501: checkcast 50	java/lang/String
    //   1504: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1507: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1510: aload 4
    //   1512: ldc_w 6676
    //   1515: aload_0
    //   1516: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1519: ldc_w 6608
    //   1522: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1525: checkcast 50	java/lang/String
    //   1528: invokestatic 147	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1531: invokevirtual 150	java/lang/Long:longValue	()J
    //   1534: invokestatic 6677	orr:a	(J)Ljava/lang/String;
    //   1537: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1540: aload 4
    //   1542: ldc_w 2710
    //   1545: aload_0
    //   1546: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1549: ldc_w 1632
    //   1552: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1555: checkcast 50	java/lang/String
    //   1558: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1561: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1564: aload 4
    //   1566: ldc_w 1649
    //   1569: sipush 140
    //   1572: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1575: aload 5
    //   1577: ldc_w 6679
    //   1580: aload 4
    //   1582: invokestatic 6684	azvd:a	(Landroid/os/Bundle;)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1585: checkcast 6686	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   1588: invokevirtual 6687	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getBytes	()[B
    //   1591: invokevirtual 6690	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1594: iload_2
    //   1595: bipush 6
    //   1597: if_icmpne +43 -> 1640
    //   1600: aload_0
    //   1601: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1604: ldc_w 6692
    //   1607: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1610: ifeq +30 -> 1640
    //   1613: aload 5
    //   1615: ldc_w 6694
    //   1618: aload_0
    //   1619: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1622: ldc_w 6692
    //   1625: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1628: checkcast 50	java/lang/String
    //   1631: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1634: invokestatic 6697	ors:a	(Ljava/lang/String;)Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   1637: invokevirtual 6598	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1640: aload 5
    //   1642: ldc_w 6699
    //   1645: iconst_5
    //   1646: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1649: iload_1
    //   1650: iconst_1
    //   1651: if_icmpne +543 -> 2194
    //   1654: aload 5
    //   1656: ldc_w 6563
    //   1659: iconst_m1
    //   1660: invokevirtual 6700	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1663: invokestatic 6704	otp:a	(I)Z
    //   1666: istore_3
    //   1667: iload_3
    //   1668: ifeq +591 -> 2259
    //   1671: new 291	android/content/Intent
    //   1674: dup
    //   1675: invokespecial 547	android/content/Intent:<init>	()V
    //   1678: astore 4
    //   1680: aload 4
    //   1682: aload 5
    //   1684: invokevirtual 1201	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1687: pop
    //   1688: aload_0
    //   1689: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1692: aload 4
    //   1694: invokestatic 6707	com/tencent/biz/pubaccount/readinjoy/video/multivideo/MultiVideoFragment:a	(Landroid/content/Context;Landroid/content/Intent;)V
    //   1697: iconst_1
    //   1698: ireturn
    //   1699: astore 4
    //   1701: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1704: ifeq -1383 -> 321
    //   1707: ldc 217
    //   1709: iconst_2
    //   1710: new 219	java/lang/StringBuilder
    //   1713: dup
    //   1714: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1717: ldc_w 6709
    //   1720: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1723: aload_0
    //   1724: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1727: ldc_w 6545
    //   1730: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1733: checkcast 50	java/lang/String
    //   1736: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: ldc_w 6711
    //   1742: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1745: aload_0
    //   1746: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1749: ldc_w 6553
    //   1752: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1755: checkcast 50	java/lang/String
    //   1758: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1761: ldc_w 6713
    //   1764: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1767: aload 4
    //   1769: invokevirtual 281	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1772: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1778: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1781: goto -1460 -> 321
    //   1784: aload 5
    //   1786: ldc_w 6563
    //   1789: bipush 100
    //   1791: invokevirtual 164	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1794: goto -1387 -> 407
    //   1797: astore 4
    //   1799: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1802: ifeq -105 -> 1697
    //   1805: ldc 217
    //   1807: iconst_2
    //   1808: new 219	java/lang/StringBuilder
    //   1811: dup
    //   1812: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1815: ldc_w 6715
    //   1818: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1821: aload_0
    //   1822: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1825: ldc_w 6571
    //   1828: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1831: checkcast 50	java/lang/String
    //   1834: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1837: ldc_w 6717
    //   1840: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: aload_0
    //   1844: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1847: ldc_w 6571
    //   1850: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1853: checkcast 50	java/lang/String
    //   1856: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1859: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1862: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1865: iconst_1
    //   1866: ireturn
    //   1867: astore 4
    //   1869: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1872: ifeq -1222 -> 650
    //   1875: ldc 217
    //   1877: iconst_2
    //   1878: ldc_w 6719
    //   1881: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1884: goto -1234 -> 650
    //   1887: iconst_0
    //   1888: istore_1
    //   1889: goto -1061 -> 828
    //   1892: astore 4
    //   1894: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1897: ifeq +406 -> 2303
    //   1900: ldc 217
    //   1902: iconst_2
    //   1903: new 219	java/lang/StringBuilder
    //   1906: dup
    //   1907: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1910: ldc_w 6721
    //   1913: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: aload 4
    //   1918: invokevirtual 281	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1921: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1924: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1927: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1930: goto +373 -> 2303
    //   1933: astore 4
    //   1935: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1938: ifeq -241 -> 1697
    //   1941: ldc 217
    //   1943: iconst_2
    //   1944: new 219	java/lang/StringBuilder
    //   1947: dup
    //   1948: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1951: ldc_w 6723
    //   1954: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1957: aload_0
    //   1958: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1961: ldc_w 6631
    //   1964: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1967: checkcast 50	java/lang/String
    //   1970: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1973: ldc_w 6725
    //   1976: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1979: aload_0
    //   1980: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1983: ldc_w 6633
    //   1986: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1989: checkcast 50	java/lang/String
    //   1992: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1995: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1998: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2001: iconst_1
    //   2002: ireturn
    //   2003: astore 4
    //   2005: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2008: ifeq -311 -> 1697
    //   2011: ldc 217
    //   2013: iconst_2
    //   2014: new 219	java/lang/StringBuilder
    //   2017: dup
    //   2018: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   2021: ldc_w 6727
    //   2024: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: aload_0
    //   2028: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2031: ldc_w 6539
    //   2034: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2037: checkcast 50	java/lang/String
    //   2040: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2043: ldc_w 6729
    //   2046: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2049: aload_0
    //   2050: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2053: ldc_w 6608
    //   2056: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2059: checkcast 50	java/lang/String
    //   2062: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2068: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2071: iconst_1
    //   2072: ireturn
    //   2073: aload_0
    //   2074: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2077: ldc_w 6731
    //   2080: invokevirtual 339	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2083: ifeq +43 -> 2126
    //   2086: aload_0
    //   2087: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2090: ldc_w 6731
    //   2093: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2096: checkcast 1004	java/lang/CharSequence
    //   2099: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2102: ifne +24 -> 2126
    //   2105: aload 4
    //   2107: ldc_w 6662
    //   2110: aload_0
    //   2111: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2114: ldc_w 6731
    //   2117: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2120: checkcast 50	java/lang/String
    //   2123: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2126: aload 4
    //   2128: ldc_w 6664
    //   2131: aload_0
    //   2132: getfield 102	bdhk:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   2135: ldc_w 6627
    //   2138: invokevirtual 135	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2141: checkcast 50	java/lang/String
    //   2144: invokestatic 1633	bdhk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2147: invokevirtual 158	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2150: goto -799 -> 1351
    //   2153: astore 6
    //   2155: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2158: ifeq -618 -> 1540
    //   2161: ldc 217
    //   2163: iconst_2
    //   2164: new 219	java/lang/StringBuilder
    //   2167: dup
    //   2168: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   2171: ldc_w 6733
    //   2174: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2177: aload 6
    //   2179: invokevirtual 281	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2182: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2188: invokestatic 284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2191: goto -651 -> 1540
    //   2194: aload 5
    //   2196: ldc_w 6563
    //   2199: iconst_m1
    //   2200: invokevirtual 6700	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   2203: aload 5
    //   2205: ldc_w 6519
    //   2208: invokevirtual 6734	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2211: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2214: invokevirtual 800	java/lang/Integer:intValue	()I
    //   2217: aload 5
    //   2219: ldc_w 6523
    //   2222: invokevirtual 6734	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2225: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2228: invokevirtual 800	java/lang/Integer:intValue	()I
    //   2231: aload 5
    //   2233: ldc_w 6515
    //   2236: invokevirtual 6734	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2239: invokestatic 797	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2242: invokevirtual 800	java/lang/Integer:intValue	()I
    //   2245: invokestatic 6737	otp:a	(IIII)Z
    //   2248: istore_3
    //   2249: goto -582 -> 1667
    //   2252: astore 4
    //   2254: iconst_0
    //   2255: istore_3
    //   2256: goto -589 -> 1667
    //   2259: new 291	android/content/Intent
    //   2262: dup
    //   2263: aload_0
    //   2264: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2267: ldc_w 6739
    //   2270: invokespecial 296	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2273: astore 4
    //   2275: aload 4
    //   2277: ldc_w 659
    //   2280: invokevirtual 656	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2283: pop
    //   2284: aload 4
    //   2286: aload 5
    //   2288: invokevirtual 1201	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   2291: pop
    //   2292: aload_0
    //   2293: getfield 95	bdhk:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2296: aload 4
    //   2298: invokevirtual 302	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   2301: iconst_1
    //   2302: ireturn
    //   2303: aconst_null
    //   2304: astore 4
    //   2306: goto -1411 -> 895
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2309	0	this	bdhk
    //   827	1062	1	i1	int
    //   860	738	2	i2	int
    //   1666	590	3	bool	boolean
    //   420	1273	4	localObject	Object
    //   1699	69	4	localException1	Exception
    //   1797	1	4	localException2	Exception
    //   1867	1	4	localException3	Exception
    //   1892	25	4	localException4	Exception
    //   1933	1	4	localException5	Exception
    //   2003	124	4	localException6	Exception
    //   2252	1	4	localException7	Exception
    //   2273	32	4	localIntent	Intent
    //   7	2280	5	localBundle	Bundle
    //   686	51	6	str1	String
    //   2153	25	6	localException8	Exception
    //   701	46	7	str2	String
    //   716	44	8	str3	String
    //   725	57	9	localAnchorData	com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData
    // Exception table:
    //   from	to	target	type
    //   219	275	1699	java/lang/Exception
    //   275	321	1699	java/lang/Exception
    //   446	494	1797	java/lang/Exception
    //   494	533	1867	java/lang/Exception
    //   533	572	1867	java/lang/Exception
    //   572	611	1867	java/lang/Exception
    //   611	650	1867	java/lang/Exception
    //   870	895	1892	java/lang/Exception
    //   974	1054	1933	java/lang/Exception
    //   841	870	2003	java/lang/Exception
    //   895	974	2003	java/lang/Exception
    //   1054	1072	2003	java/lang/Exception
    //   1077	1103	2003	java/lang/Exception
    //   1103	1351	2003	java/lang/Exception
    //   1351	1510	2003	java/lang/Exception
    //   1540	1594	2003	java/lang/Exception
    //   1600	1640	2003	java/lang/Exception
    //   1894	1930	2003	java/lang/Exception
    //   1935	2001	2003	java/lang/Exception
    //   2073	2126	2003	java/lang/Exception
    //   2126	2150	2003	java/lang/Exception
    //   2155	2191	2003	java/lang/Exception
    //   1510	1540	2153	java/lang/Exception
    //   1654	1667	2252	java/lang/Exception
    //   2194	2249	2252	java/lang/Exception
  }
  
  public boolean t()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, GeneralSettingActivity.class);
    localIntent.addFlags(603979776);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean u()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidContentContext, AssistantSettingActivity.class);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean v()
  {
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("nickname");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("openid");
    Intent localIntent = new Intent((Activity)this.jdField_a_of_type_AndroidContentContext, ApolloGuestsStateActivity.class);
    localIntent.putExtra("extra_guest_nick", str1);
    localIntent.putExtra("extra_guest_uin", str2);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivity(localIntent);
    return true;
  }
  
  public boolean w()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean x()
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
  
  public boolean y()
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
                                    if (!bdin.g(BaseApplicationImpl.getApplication()))
                                    {
                                      QQToast.a(BaseApplicationImpl.getApplication(), 1, "无网络连接请稍后再试", 1).a();
                                      return false;
                                    }
                                    try
                                    {
                                      ((atdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(306)).a((Bundle)localObject2);
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
  
  public boolean z()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhk
 * JD-Core Version:    0.7.0.1
 */
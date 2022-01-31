package com.tencent.mobileqq.activity;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.cache.MemoryClearManagerNew;
import com.tencent.common.cache.MemoryClearManagerNew.IClearMemoryListener;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.weather.WeatherManager;
import com.tencent.mobileqq.activity.weather.WeatherManager.WeatherUpdaterListener;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloManager.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.ApolloManager.IDrawerGameBoxStatus;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerStatus;
import com.tencent.mobileqq.apollo.drawer.CardDrawerStatus;
import com.tencent.mobileqq.apollo.drawer.FirstDrawerStatus;
import com.tencent.mobileqq.apollo.drawer.FirstGameDrawerStatus;
import com.tencent.mobileqq.apollo.drawer.GameBoxDrawerStatus;
import com.tencent.mobileqq.apollo.drawer.HireDrawerStatus;
import com.tencent.mobileqq.apollo.drawer.PushDrawerStatus;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.Util;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.VipGrayConfigHelper.VipGrayConfigListener;
import com.tencent.mobileqq.vashealth.StepCounterServlert;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BitmapUtil;
import com.tencent.widget.UpSideDownDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.dingdong.DingdongCalendarSyncUtil;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.dingdong.data.OfficeCenterSharedPref;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;
import cooperation.qqindividuality.QQIndividualityProxyActivity;
import cooperation.qqindividuality.QQIndividualityUtils;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;
import tpk;
import tpl;
import tpm;
import tpn;
import tpo;
import tpp;
import tpr;
import tps;
import tpu;
import tpv;
import tpw;
import tpx;
import tpy;
import tpz;
import tqa;
import tqb;
import tqc;
import tqe;
import tqf;
import tqh;
import tqi;
import tqn;
import tqr;
import tqt;
import tqu;
import tqv;
import tqw;
import tqx;
import tqy;
import tra;
import trb;
import trc;
import tre;
import trg;
import trh;
import tri;
import trj;

public class QQSettingMe
  implements View.OnClickListener
{
  public static int a;
  private static List jdField_a_of_type_JavaUtilList;
  private static List jdField_b_of_type_JavaUtilList;
  protected float a;
  protected long a;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new trh(this);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Handler a;
  public View a;
  public ViewGroup a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public MemoryClearManagerNew.IClearMemoryListener a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private WeatherManager.WeatherUpdaterListener jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener = new tre(this);
  private WeatherManager jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager;
  private ApolloManager.IDrawerGameBoxStatus jdField_a_of_type_ComTencentMobileqqApolloApolloManager$IDrawerGameBoxStatus;
  public ApolloTextureView a;
  public ApolloDrawerContext a;
  private ISpriteDrawerInfoCallback jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteDrawerInfoCallback = new trc(this);
  private SpriteDrawerInfoManager jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager;
  public ApolloBoxEnterView a;
  private ApolloDrawerInfoViewListener jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  protected FrameGifView a;
  public BaseActivity a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new tqi(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new tqh(this);
  private FrameHelperActivity jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tqn(this);
  public QQAppInterface a;
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new tqu(this);
  private VipInfoObserver jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver = new tqf(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private DingdongPluginBizObserver jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver = new tqw(this);
  public DynamicAvatarView a;
  public Card a;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("QQSetting_me", "com.tencent.mobileqq:tool");
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new tqe(this);
  protected RedTouch a;
  private IActionListener jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener;
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  NightModeLogic.NightModeCallback jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback = new tqt(this);
  private NightModeLogic jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic;
  VasExtensionObserver jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new tra(this);
  private VipGrayConfigHelper.VipGrayConfigListener jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper$VipGrayConfigListener = new tqv(this);
  protected RedDotTextView a;
  public BusinessInfoCheckUpdate.AppInfo a;
  private BusinessInfoCheckUpdate.RedTypeInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo;
  private String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new tqr(this);
  private tri jdField_a_of_type_Tri = new tri(this);
  protected boolean a;
  protected int[] a;
  protected View[] a;
  protected RedTouch[] a;
  protected RedTouchTextView[] a;
  protected float b;
  int jdField_b_of_type_Int;
  public View b;
  protected ImageView b;
  public LinearLayout b;
  public TextView b;
  protected RedTouch b;
  public BusinessInfoCheckUpdate.AppInfo b;
  private String jdField_b_of_type_JavaLangString = "http://h5.vip.qq.com/p/mc/vipcenterv5?_bid=193&_wvSb=1&asyncMode=3&phpsonic=1";
  protected boolean b;
  public int c;
  protected View c;
  protected ImageView c;
  private LinearLayout c;
  public TextView c;
  protected RedTouch c;
  public BusinessInfoCheckUpdate.AppInfo c;
  public boolean c;
  public int d;
  protected View d;
  private ImageView d;
  protected TextView d;
  protected RedTouch d;
  public BusinessInfoCheckUpdate.AppInfo d;
  public boolean d;
  int e;
  protected View e;
  public TextView e;
  protected RedTouch e;
  public BusinessInfoCheckUpdate.AppInfo e;
  protected boolean e;
  private int jdField_f_of_type_Int = 0;
  protected TextView f;
  public BusinessInfoCheckUpdate.AppInfo f;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  public TextView g;
  public BusinessInfoCheckUpdate.AppInfo g;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  public TextView h;
  public BusinessInfoCheckUpdate.AppInfo h;
  private boolean jdField_h_of_type_Boolean;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  BusinessInfoCheckUpdate.AppInfo jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
  private boolean jdField_i_of_type_Boolean;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  public BusinessInfoCheckUpdate.AppInfo j;
  private boolean jdField_j_of_type_Boolean = true;
  public BusinessInfoCheckUpdate.AppInfo k;
  private boolean k;
  public BusinessInfoCheckUpdate.AppInfo l;
  private boolean l;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaUtilList.add("h5.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("mc.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("m.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("proxy.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("red.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("r.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("cgi.vip.qq.com");
    jdField_a_of_type_JavaUtilList.add("iyouxi.vip.qq.com");
    jdField_b_of_type_JavaUtilList.add("zb.vip.qq.com");
    jdField_b_of_type_JavaUtilList.add("gxh.vip.qq.com");
    jdField_b_of_type_JavaUtilList.add("g.vip.qq.com");
    jdField_b_of_type_JavaUtilList.add("imgcache.gtimg.cn");
    jdField_b_of_type_JavaUtilList.add("i.gtimg.cn");
    jdField_b_of_type_JavaUtilList.add("imgcache.qq.com");
    jdField_b_of_type_JavaUtilList.add("logic.content.qq.com");
  }
  
  @TargetApi(11)
  public QQSettingMe(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, FrameHelperActivity paramFrameHelperActivity)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_j_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
    this.jdField_a_of_type_ComTencentCommonCacheMemoryClearManagerNew$IClearMemoryListener = new tpk(this);
    this.jdField_a_of_type_AndroidOsHandler = new tpl(this, Looper.getMainLooper());
    this.jdField_e_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->QQSettingMe construct!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = paramFrameHelperActivity;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130970621, null));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364082);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setContentDescription("进入我的资料卡");
    }
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363068));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371315);
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
    int m;
    Object localObject4;
    boolean bool;
    label1295:
    label1323:
    Object localObject2;
    int i1;
    int n;
    if ((localObject1 == null) || (((String)localObject1).length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130839147);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131371314).setOnClickListener(this);
      m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131558887);
      this.jdField_g_of_type_Int = (ScreenUtil.jdField_a_of_type_Int - ScreenUtil.a(40.0F) - m - ScreenUtil.a(40.0F));
      this.jdField_h_of_type_Int = (ScreenUtil.jdField_a_of_type_Int - ScreenUtil.a(40.0F) - m - ScreenUtil.a(15.0F));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362899));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_g_of_type_Int);
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + (String)localObject1);
      if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim()))) {
        this.jdField_a_of_type_JavaLangString = ((String)localObject1);
      }
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.jdField_b_of_type_AndroidViewView).a(53).a();
      this.jdField_b_of_type_AndroidViewView.setVisibility(VasFaceManager.a((String)localObject1, paramQQAppInterface));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363069));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371316));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371318));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371317));
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        paramBaseActivity.topMargin = (ScreenUtil.a(35.0F) - ImmersiveUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramBaseActivity);
      }
      if (ThemeUtil.isNowThemeIsDefault(paramFrameHelperActivity.getActivity().app, false, null))
      {
        paramBaseActivity = a(2130843331, true);
        paramBaseActivity.setBounds(0, 0, this.jdField_d_of_type_AndroidWidgetImageView.getWidth(), this.jdField_d_of_type_AndroidWidgetImageView.getHeight());
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(paramBaseActivity);
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371319));
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBaseActivity.topMargin = (ScreenUtil.a(35.0F) - ImmersiveUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBaseActivity);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new tpx(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371320)).a(53).a();
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371309);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_AndroidViewView).b(10).a(19).a();
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      m = (int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131558893);
      paramBaseActivity = this.jdField_a_of_type_AndroidViewViewGroup.getResources();
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[12];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch = new RedTouch[12];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView = new RedTouchTextView[12];
      paramFrameHelperActivity = new int[12];
      FrameHelperActivity tmp1081_1080 = paramFrameHelperActivity;
      tmp1081_1080[0] = 2131371325;
      FrameHelperActivity tmp1087_1081 = tmp1081_1080;
      tmp1087_1081[1] = 2131371326;
      FrameHelperActivity tmp1093_1087 = tmp1087_1081;
      tmp1093_1087[2] = 2131371329;
      FrameHelperActivity tmp1099_1093 = tmp1093_1087;
      tmp1099_1093[3] = 2131371331;
      FrameHelperActivity tmp1105_1099 = tmp1099_1093;
      tmp1105_1099[4] = 2131371330;
      FrameHelperActivity tmp1111_1105 = tmp1105_1099;
      tmp1111_1105[5] = 2131371328;
      FrameHelperActivity tmp1117_1111 = tmp1111_1105;
      tmp1117_1111[6] = 2131371327;
      FrameHelperActivity tmp1124_1117 = tmp1117_1111;
      tmp1124_1117[7] = 2131371332;
      FrameHelperActivity tmp1131_1124 = tmp1124_1117;
      tmp1131_1124[8] = 2131371333;
      FrameHelperActivity tmp1138_1131 = tmp1131_1124;
      tmp1138_1131[9] = 2131371334;
      FrameHelperActivity tmp1145_1138 = tmp1138_1131;
      tmp1145_1138[10] = 2131371335;
      FrameHelperActivity tmp1152_1145 = tmp1145_1138;
      tmp1152_1145[11] = 2131371336;
      tmp1152_1145;
      localObject1 = new int[12];
      Object tmp1168_1166 = localObject1;
      tmp1168_1166[0] = 2131436804;
      Object tmp1174_1168 = tmp1168_1166;
      tmp1174_1168[1] = 2131436801;
      Object tmp1180_1174 = tmp1174_1168;
      tmp1180_1174[2] = 2131436802;
      Object tmp1186_1180 = tmp1180_1174;
      tmp1186_1180[3] = 2131436808;
      Object tmp1192_1186 = tmp1186_1180;
      tmp1192_1186[4] = 2131436798;
      Object tmp1198_1192 = tmp1192_1186;
      tmp1198_1192[5] = 2131436799;
      Object tmp1204_1198 = tmp1198_1192;
      tmp1204_1198[6] = 2131437142;
      Object tmp1211_1204 = tmp1204_1198;
      tmp1211_1204[7] = 2131436812;
      Object tmp1218_1211 = tmp1211_1204;
      tmp1218_1211[8] = 2131437090;
      Object tmp1225_1218 = tmp1218_1211;
      tmp1225_1218[9] = 2131438730;
      Object tmp1232_1225 = tmp1225_1218;
      tmp1232_1225[10] = 2131436813;
      Object tmp1239_1232 = tmp1232_1225;
      tmp1239_1232[11] = 2131436800;
      tmp1239_1232;
      Object localObject3 = ThemeUtil.getCurrentThemeInfo();
      localObject4 = ((Bundle)localObject3).getString("themeId");
      if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!"1000".equals(localObject4)) && (!"1103".equals(localObject4))) {
        break label1881;
      }
      bool = true;
      this.jdField_j_of_type_Boolean = bool;
      if (!this.jdField_j_of_type_Boolean) {
        break label1887;
      }
      m = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131494162);
      localObject2 = a(this.jdField_j_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe_init, color=" + m + ",themeid = " + (String)localObject4 + ", enginePath=" + ((Bundle)localObject3).getString("themePath"));
      }
      i1 = ScreenUtil.a(2.0F);
      localObject3 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371323);
      n = 0;
      label1416:
      if (n >= 12) {
        break label1919;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[n] = ((View)localObject3).findViewById(paramFrameHelperActivity[n]);
      this.jdField_a_of_type_ArrayOfAndroidViewView[n].setFocusable(true);
      if (paramFrameHelperActivity[n] != 2131371327) {
        break label1905;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[n].setVisibility(8);
    }
    for (;;)
    {
      if ((n == 7) && (this.jdField_a_of_type_ArrayOfAndroidViewView[n] != null))
      {
        a(false);
        if (c()) {
          a(true);
        }
      }
      if (paramFrameHelperActivity[n] == 2131371333) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[n].setVisibility(8);
      }
      if (paramFrameHelperActivity[n] == 2131371334) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[n].setVisibility(8);
      }
      if (paramFrameHelperActivity[n] == 2131371335) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[n].setVisibility(8);
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[n].setOnClickListener(this);
      ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[n].findViewById(2131371362)).setImageResource(localObject2[n]);
      localObject4 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[n].findViewById(2131371363);
      ((TextView)localObject4).setText(localObject1[n]);
      if (!this.jdField_j_of_type_Boolean) {
        ((TextView)localObject4).setTextColor(m);
      }
      ((TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[n].findViewById(2131368538)).setVisibility(8);
      AccessibilityUtil.a(this.jdField_a_of_type_ArrayOfAndroidViewView[n], paramBaseActivity.getString(localObject1[n]), Button.class.getName());
      localObject4 = this.jdField_a_of_type_ArrayOfAndroidViewView[n].findViewById(2131371362);
      ((View)localObject4).setPadding(i1, i1, i1, i1);
      Object localObject5 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject5).leftMargin -= i1;
      localObject5 = (RedTouchTextView)this.jdField_a_of_type_ArrayOfAndroidViewView[n].findViewById(2131371363);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((RedTouchTextView)localObject5).getLayoutParams();
      localLayoutParams.leftMargin -= i1;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[n] = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject4).a(53).a();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[n] = localObject5;
      n += 1;
      break label1416;
      localObject2 = paramQQAppInterface.a(paramQQAppInterface.a(1, (String)localObject1, (byte)3, 0, 100, true));
      if (localObject2 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageBitmap((Bitmap)localObject2);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130839147);
      break;
      label1881:
      bool = false;
      break label1295;
      label1887:
      m = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131494163);
      break label1323;
      label1905:
      this.jdField_a_of_type_ArrayOfAndroidViewView[n].setVisibility(0);
    }
    label1919:
    Z();
    C();
    P();
    paramBaseActivity = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371337);
    paramBaseActivity.setOnClickListener(this);
    AccessibilityUtil.a(paramBaseActivity, "设置", Button.class.getName());
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371340));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371338));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371339));
    this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView).a();
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371341);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    AccessibilityUtil.a(this.jdField_d_of_type_AndroidViewView, "夜间模式", Button.class.getName());
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371343));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371342));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[5].findViewById(2131371364));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371344));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371346));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371345));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371347));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371348));
    this.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_f_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_g_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    if (ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, false, null))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-10591367);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-10591367);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-10591367);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView = ((ApolloBoxEnterView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371353));
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131438208));
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = ((FrameGifView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371352));
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371349);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371354));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371355));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371356));
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371357));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371359));
      this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(this);
      this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext = new ApolloDrawerContext();
      if (!this.jdField_j_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(m);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(m);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843345);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843328);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(m);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(m);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(m);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(m);
        this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(m);
      }
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131494162));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131494162));
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131494162));
    }
  }
  
  private void P()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[11];
    if (localView != null)
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4);
      if (!((SharedPreferences)localObject).getBoolean("drawerEnable", false)) {
        break label126;
      }
      String str = ((SharedPreferences)localObject).getString("drawerText", "");
      localObject = ((SharedPreferences)localObject).getString("drawerUrl", "");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        localView.setVisibility(0);
        ((TextView)localView.findViewById(2131371363)).setText(str);
      }
    }
    else
    {
      return;
    }
    localView.setVisibility(8);
    return;
    label126:
    localView.setVisibility(8);
  }
  
  private void Q()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    if (localView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("call_tim_config_pre" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
      if (((SharedPreferences)localObject).getBoolean("call_tim_config_switch", false))
      {
        localObject = ((SharedPreferences)localObject).getString("call_tim_config_title", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131436813));
        localView.setVisibility(0);
        ((TextView)localView.findViewById(2131371363)).setText((CharSequence)localObject);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800887D", "0X800887D", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    localView.setVisibility(8);
  }
  
  private void R()
  {
    this.jdField_f_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_f_of_type_Int = ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).c();
    QLog.d("QQSettingRedesign", 1, new Object[] { "initApolloDrawerStatus:", Integer.valueOf(this.jdField_f_of_type_Int) });
  }
  
  private void S()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "destroyApollo");
    }
    if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof SettingMeRelativeLayout)) {
      ((SettingMeRelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup).setSurfaceView(null, null, 1.0F, 0.0F);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.c();
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.b();
    }
    this.jdField_l_of_type_Boolean = true;
  }
  
  private void T()
  {
    S();
    if (this.jdField_k_of_type_Boolean) {
      ae();
    }
    b();
  }
  
  private void U()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "preloadSonicSession");
    }
    if (!SonicPreloader.a()) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      Object localObject2 = SonicPreloader.a(this.jdField_k_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, 0);
      SparseArray localSparseArray = SonicPreloader.a(this.jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, 1000);
      Object localObject1 = SonicPreloader.a(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, 1001);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      if ((localObject2 != null) && (((SparseArray)localObject2).size() > 0))
      {
        int m = 0;
        if (m < ((SparseArray)localObject2).size())
        {
          SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject2).valueAt(m);
          if (1000 == localSonicPreloadData.jdField_a_of_type_Int)
          {
            localSonicPreloadData.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
            localArrayList1.add(localSonicPreloadData);
          }
          for (;;)
          {
            m += 1;
            break;
            if (1001 == localSonicPreloadData.jdField_a_of_type_Int)
            {
              localSonicPreloadData.jdField_a_of_type_JavaLangString = IndividuationUrlHelper.a("personalIndex");
              localArrayList1.add(localSonicPreloadData);
            }
          }
        }
      }
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        localObject2 = (SonicPreloadData)localSparseArray.valueAt(0);
        ((SonicPreloadData)localObject2).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        localArrayList2.add(localObject2);
      }
      if ((localObject1 != null) && (((SparseArray)localObject1).size() > 0))
      {
        localObject1 = (SonicPreloadData)((SparseArray)localObject1).valueAt(0);
        ((SonicPreloadData)localObject1).jdField_a_of_type_JavaLangString = IndividuationUrlHelper.a("personalIndex");
        localArrayList3.add(localObject1);
      }
      localObject1 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
      if (((WebProcessManager)localObject1).a(localArrayList1)) {
        ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf("200010.200012"));
      }
      if (((WebProcessManager)localObject1).a(localArrayList2)) {
        this.jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.preload_ts.set(System.currentTimeMillis());
      }
      if (((WebProcessManager)localObject1).a(localArrayList3)) {
        this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.preload_ts.set(System.currentTimeMillis());
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQSettingRedesign", 2, "preloadSonicSession parse cost: " + (System.currentTimeMillis() - l1));
  }
  
  private void V()
  {
    a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_f_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_l_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
  
  private void W()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    int m = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
    String str;
    if (!this.jdField_b_of_type_JavaLangString.contains("?"))
    {
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString + "?platform=1&type=20001&networkInfo=" + m);
      str = ((StringBuilder)localObject).toString();
      localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf(100400));
      str = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(str, (BusinessInfoCheckUpdate.AppInfo)localObject);
      if ((localObject == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0) || (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() != 0)) {
        break label345;
      }
    }
    label345:
    for (boolean bool = true;; bool = false)
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
      ((Intent)localObject).putExtra("startOpenPageTime", l1);
      ((Intent)localObject).putExtra("portraitOnly", true);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("has_red_dot", bool);
      ((Intent)localObject).putExtra("leftBtnText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131433212));
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str, 256L, (Intent)localObject, false, -1);
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100400));
      return;
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString + "&platform=1&type=20001&networkInfo=" + m);
      break;
    }
  }
  
  private void X()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo != null) {
        this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo);
      }
      for (;;)
      {
        boolean bool = this.jdField_i_of_type_Boolean;
        this.jdField_i_of_type_Boolean = this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a();
        if (QLog.isColorLevel()) {
          QLog.i("LocalRedTouchManager", 2, "updateHeadIcon, old:" + bool + " new:" + this.jdField_i_of_type_Boolean);
        }
        if (bool != this.jdField_i_of_type_Boolean) {
          A();
        }
        return;
        this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_j_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void Y()
  {
    try
    {
      a(11, this.jdField_l_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void Z()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vipTitleSpFile", 0).getString("vipTitleSpKey_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateVipText sp vipText = " + str);
      }
      if (!TextUtils.isEmpty(str))
      {
        TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131371363);
        if (localTextView != null) {
          localTextView.setText(str);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QQSettingRedesign", 1, "updateVipText exception, e = ", localException);
    }
  }
  
  private StateListDrawable a(int paramInt, boolean paramBoolean)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
    {
      Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      if (localResources != null) {
        try
        {
          localObject2 = BitmapFactory.decodeResource(localResources, paramInt);
          localObject1 = localObject2;
          if (paramBoolean)
          {
            localObject1 = localObject2;
            if (localObject2 != null) {
              localObject1 = BitmapUtil.a((Bitmap)localObject2);
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          try
          {
            Object localObject1;
            Object localObject2 = BitmapFactory.decodeResource(localResources, paramInt);
            if ((localObject1 != null) && (localObject2 == null))
            {
              localObject4 = localObject1;
              localObject1 = new BitmapDrawable(localResources, (Bitmap)localObject1);
              localObject2 = new BitmapDrawable(localResources, localObject4);
              ((BitmapDrawable)localObject2).setAlpha(127);
              localStateListDrawable.addState(new int[] { 16842919, 16842910 }, (Drawable)localObject2);
              localStateListDrawable.addState(new int[] { 16842908 }, (Drawable)localObject1);
              localStateListDrawable.addState(new int[0], (Drawable)localObject1);
              return localStateListDrawable;
              localOutOfMemoryError1 = localOutOfMemoryError1;
              if (QLog.isColorLevel()) {
                QLog.d("QQSettingRedesign", 2, localOutOfMemoryError1, new Object[0]);
              }
              localObject2 = null;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            Object localObject3;
            do
            {
              do
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("QQSettingRedesign", 2, localOutOfMemoryError2, new Object[0]);
                  }
                  localObject3 = null;
                }
                localObject4 = localObject3;
              } while (localOutOfMemoryError1 != null);
              Object localObject4 = localObject3;
            } while (localObject3 != null);
            return null;
          }
        }
      }
      return null;
    }
    return null;
  }
  
  private void a(int paramInt, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject1 = null;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (paramAppInfo != null)
    {
      localObject1 = new BusinessInfoCheckUpdate.AppInfo();
      localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
      ((BusinessInfoCheckUpdate.AppInfo)localObject1).set(paramAppInfo);
      localAppInfo.set(paramAppInfo);
      if ((localAppInfo.iNewFlag.get() != 0) && (localAppInfo.red_display_info.get() != null) && (localAppInfo.red_display_info.red_type_info.get() != null))
      {
        Object localObject2 = new ArrayList(localAppInfo.red_display_info.red_type_info.get());
        int n = ((ArrayList)localObject2).size() - 1;
        int m = 0;
        if (n >= 0)
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((ArrayList)localObject2).get(n);
          int i1 = localRedTypeInfo.red_type.get();
          if (i1 == 0) {
            ((ArrayList)localObject2).remove(n);
          }
          for (m = 1;; m = 1)
          {
            n -= 1;
            break;
            if ((i1 != 3) || (!RedTouchTextView.a(localRedTypeInfo, localAppInfo))) {
              break label283;
            }
            RedTouchTextView.setImageRedNotShowRedPoint(localRedTypeInfo, paramAppInfo);
          }
        }
        if (((ArrayList)localObject2).size() < 2) {
          ((ArrayList)localObject2).clear();
        }
        localAppInfo.red_display_info.red_type_info.set((List)localObject2);
        paramAppInfo = new ArrayList();
        if (m != 0)
        {
          localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
          paramAppInfo.add(localObject2);
        }
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).red_display_info.red_type_info.set(paramAppInfo);
      }
      paramAppInfo = localAppInfo;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[paramInt].a((BusinessInfoCheckUpdate.AppInfo)localObject1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[paramInt].setAppInfo(paramAppInfo);
      return;
      label283:
      break;
      localAppInfo = null;
      paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject1;
      localObject1 = localAppInfo;
    }
  }
  
  @TargetApi(14)
  private void a(ApolloManager.CheckApolloInfoResult paramCheckApolloInfoResult)
  {
    if ((paramCheckApolloInfoResult == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null)) {
      return;
    }
    ((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("window")).getDefaultDisplay().getWidth();
    long l1 = System.currentTimeMillis();
    Object localObject = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int n = this.jdField_d_of_type_Int;
    if (((ApolloManager)localObject).jdField_d_of_type_Boolean) {}
    for (int m = 0;; m = 1)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_show", n, 0, new String[] { "", String.valueOf(m) });
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, new Object[] { "roleId->" + paramCheckApolloInfoResult.jdField_a_of_type_Int + " apolloStatus->" + this.jdField_d_of_type_Int + " needStatic->" + paramCheckApolloInfoResult.jdField_a_of_type_Boolean, ",mApolloDrawerStatus->", Integer.valueOf(this.jdField_f_of_type_Int) });
      }
      if (!this.jdField_f_of_type_Boolean) {
        break;
      }
      QLog.i("QQSettingRedesign", 1, "checkApolloUI on DrawerClosed!");
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.c();
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageBitmap(null);
    float f2;
    float f1;
    if ((this.jdField_f_of_type_Int == 1) || (this.jdField_f_of_type_Int == 3))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
        break label942;
      }
      this.jdField_c_of_type_Int = paramCheckApolloInfoResult.jdField_a_of_type_Int;
      this.jdField_a_of_type_ArrayOfInt = paramCheckApolloInfoResult.jdField_a_of_type_ArrayOfInt;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.mIsDrawerView = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager = new SpriteDrawerInfoManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener = new ApolloDrawerInfoViewListener(this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager, 1);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteDrawerInfoCallback);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager$IDrawerGameBoxStatus = new trb(this);
      ((ApolloManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloManager$IDrawerGameBoxStatus);
      long l2 = DeviceInfoUtil.k();
      long l3 = DeviceInfoUtil.j();
      paramCheckApolloInfoResult = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a == null) {
        break label889;
      }
      f2 = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.a();
      f1 = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.b();
      label480:
      m = (int)((float)l3 * 0.7F);
      localObject = new RelativeLayout.LayoutParams(m, (int)l2 >> 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)((float)l3 - f2 / 2.0F));
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)(l3 - ((RelativeLayout.LayoutParams)localObject).rightMargin - m));
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject);
      f2 = (((RelativeLayout.LayoutParams)localObject).rightMargin - f1 - f2 / 2.0F) / f2;
      if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof SettingMeRelativeLayout)) {
        ((SettingMeRelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup).setSurfaceView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView, f2, ((RelativeLayout.LayoutParams)localObject).rightMargin - f1);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.bringToFront();
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      float f3 = FontSettingManager.a() / 16.0F;
      f2 = f3;
      if (f3 == 0.0F) {
        f2 = 1.0F;
      }
      f2 = DeviceInfoUtil.a() / f2;
      localObject = new RelativeLayout.LayoutParams((int)(45.0F * f2), (int)(45.0F * f2));
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(f1 + 66.0F * f2 + AIOUtils.a(8.0F, paramCheckApolloInfoResult)));
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(f2 * 5.0F));
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.jdField_f_of_type_Int != 1) {
        break label919;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
      label789:
      b(m);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
      }
      if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof SettingMeRelativeLayout)) {
        ((SettingMeRelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup).a();
      }
      if (this.jdField_f_of_type_Int == 3) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQSettingRedesign", 2, "refresh ApolloSettingMe->" + (System.currentTimeMillis() - l1));
      return;
      label889:
      f2 = (float)(paramCheckApolloInfoResult.getDisplayMetrics().density * 100.0F + 0.5D);
      f1 = paramCheckApolloInfoResult.getDimensionPixelSize(2131558887);
      break label480;
      label919:
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.bringChildToFront(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      break label789;
      label942:
      if (this.jdField_f_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
      }
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(paramAppInfo);
  }
  
  private void a(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new tqx(this, paramInt, paramString));
  }
  
  private boolean a()
  {
    LocalRedTouchManager localLocalRedTouchManager = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    localLocalRedTouchManager.a(100601, false);
    localLocalRedTouchManager.a(10016, false);
    localLocalRedTouchManager.a(10015, false);
    localLocalRedTouchManager.a(10012, false);
    RedTouchItem localRedTouchItem = localLocalRedTouchManager.a(100500);
    if (localLocalRedTouchManager.a(localRedTouchItem, true)) {}
    try
    {
      af();
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_type.set(0);
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_content.set("");
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_desc.set("");
      label119:
      if (QLog.isColorLevel())
      {
        QLog.d("QQSettingRedesign", 2, "update head icon red point: " + localRedTouchItem.redtouchType);
        return true;
        this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo = null;
        return false;
      }
    }
    catch (Exception localException)
    {
      break label119;
    }
    return true;
  }
  
  private boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "initApolloDrawerStatusView:", Integer.valueOf(paramInt) });
    }
    switch (paramInt)
    {
    default: 
      return true;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return false;
    case 1: 
    case 4: 
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return true;
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      K();
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
    K();
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    boolean bool = OfficeCenterSharedPref.a().a("officecenter_always_show_flag", false);
    if (bool != paramBoolean) {
      OfficeCenterSharedPref.a().b("officecenter_always_show_flag", paramBoolean);
    }
    return bool;
  }
  
  private void aa()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
    String str1 = localSharedPreferences.getString("cur_temp", null);
    String str2 = localSharedPreferences.getString("cur_city", null);
    String str3 = localSharedPreferences.getString("cur_code", null);
    boolean bool = localSharedPreferences.getBoolean("show_flag", false);
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateWeatherView cur_temp:" + str1 + ",cur_city" + str2 + ",o_wea_code" + str3 + ",show_flag:" + bool);
    }
    if (!bool)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    while ((str1 == null) || (str2 == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_h_of_type_AndroidWidgetTextView.setText(str2);
    this.jdField_g_of_type_AndroidWidgetTextView.setText("o");
    d(str1);
    e(str3);
  }
  
  private void ab()
  {
    ImageView localImageView;
    if (this.jdField_h_of_type_Boolean)
    {
      this.jdField_h_of_type_Boolean = false;
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[7] != null)
      {
        localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131371362);
        if (!this.jdField_j_of_type_Boolean) {
          break label56;
        }
      }
    }
    label56:
    for (int m = 2130843340;; m = 2130843341)
    {
      localImageView.setImageResource(m);
      return;
    }
  }
  
  private void ac()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a();
    if ((localObject != null) && ((localObject instanceof GameBoxDrawerStatus)) && (((GameBoxDrawerStatus)localObject).a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Int);
      localObject = ((GameBoxDrawerStatus)localObject).a();
      a(((DrawerPushItem)localObject).content, ((DrawerPushItem)localObject).bubble_res_id);
    }
    J();
  }
  
  private void ad()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("apollo_sp", 0).getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "apollo_settingme_first_enter", true))
    {
      FirstDrawerStatus localFirstDrawerStatus = new FirstDrawerStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a(localFirstDrawerStatus);
    }
  }
  
  private void ae()
  {
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAlpha(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleY(1.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void af()
  {
    Object localObject = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
    RedTouchItem localRedTouchItem1 = ((LocalRedTouchManager)localObject).a(10015);
    RedTouchItem localRedTouchItem2 = ((LocalRedTouchManager)localObject).a(10016);
    int m;
    if ((Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && ((((LocalRedTouchManager)localObject).a(localRedTouchItem1, false)) || (((LocalRedTouchManager)localObject).a(localRedTouchItem2, false))))
    {
      m = 1;
      if (m != 0)
      {
        m = ((LocalRedTouchManager)localObject).a();
        localObject = null;
        switch (m)
        {
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      }
      return;
      m = 0;
      break;
      localObject = "0X8007392";
      continue;
      localObject = "0X8007397";
      continue;
      localObject = "0X80073B8";
    }
  }
  
  private void b(int paramInt)
  {
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    long l1 = Math.max(DeviceInfoUtil.i(), DeviceInfoUtil.h());
    this.jdField_a_of_type_Float = ((paramInt - AIOUtils.a(66.0F, localResources)) / DeviceInfoUtil.a());
    float f2 = FontSettingManager.a() / 16.0F;
    float f1;
    if (f2 != 0.0F)
    {
      if (f2 <= 1.0F) {
        break label170;
      }
      f1 = 1.05F;
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = (f1 * this.jdField_a_of_type_Float);
      this.jdField_b_of_type_Float = 15.0F;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.mManHeight = ((float)(l1 >> 2));
      f1 = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.mManHeight / 368.0F;
      if (l1 != DeviceInfoUtil.k()) {
        QLog.e("QQSettingRedesign", 1, "DeviceInfoUtil.getPortraitHeight():" + DeviceInfoUtil.k() + " height:" + l1);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a(f1, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      return;
      label170:
      f1 = f2;
      if (f2 < 1.0F) {
        f1 = 0.95F;
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    ThreadManager.post(new tpm(this), 5, null, false);
  }
  
  private boolean b()
  {
    if (!this.jdField_d_of_type_Boolean) {}
    long l1;
    int m;
    do
    {
      return true;
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      l1 = localSharedPreferences.getLong("sp_vip_info_request_time", 0L);
      m = localSharedPreferences.getInt("sp_vip_info_update_freq", 10);
    } while (NetConnInfoCenter.getServerTime() - l1 > m * 60);
    return false;
  }
  
  private void c(String paramString)
  {
    int n;
    Intent localIntent;
    String str1;
    ApolloDrawerStatus localApolloDrawerStatus;
    ApolloManager localApolloManager;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0)
    {
      n = 1;
      localIntent = new Intent();
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localIntent.putExtra("extra_key_box_uin", str1);
      localIntent.putExtra("extra_key_open_box", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
      if (n != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setApolloHadStolen();
        localIntent.putExtra("key_box_type", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
      }
      localIntent.putExtra("extra_key_box_from", "drawer");
      localApolloDrawerStatus = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a();
      localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      localObject2 = localApolloManager.i;
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, new Object[] { "[onNotifyStatusChanged] lastTab=", localObject2 });
      }
      localObject1 = localObject2;
      if (localApolloDrawerStatus != null)
      {
        localObject1 = localObject2;
        if ((localApolloDrawerStatus instanceof PushDrawerStatus))
        {
          PushDrawerStatus localPushDrawerStatus = (PushDrawerStatus)localApolloDrawerStatus;
          localObject1 = localObject2;
          if (localPushDrawerStatus.jdField_b_of_type_Boolean)
          {
            localObject1 = localObject2;
            if (localPushDrawerStatus.a != null)
            {
              String str2 = localPushDrawerStatus.a.scheme;
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(str2))
              {
                localObject2 = str2.trim();
                localPushDrawerStatus.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                localObject1 = localObject2;
                if (QLog.isColorLevel())
                {
                  QLog.d("QQSettingRedesign", 2, new Object[] { "[onNotifyStatusChanged] scheme from bubble=", localObject2 });
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
      if (!"mall".equals(localObject1)) {
        break label518;
      }
      localObject1 = ApolloConstant.X;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = ApolloConstant.Y;
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(ApolloConstant.Y))) {
        localIntent.putExtra("extra_key_url_append", "&tab=interactive&suin=" + str1);
      }
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, "drawer", (String)localObject2, null);
      localObject1 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("pet"))) {
        break label580;
      }
      VipUtils.a(null, "cmshow", "Apollo", "drawerpetclick", 0, 0, new String[] { ((ApolloManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) });
      if (n != 0)
      {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "0X80065C0", 0, 0, new String[] { "0" });
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
      if ((localApolloDrawerStatus instanceof HireDrawerStatus)) {
        ((HireDrawerStatus)localApolloDrawerStatus).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return;
      n = 0;
      break;
      label518:
      if ("interact".equals(localObject1)) {
        localObject1 = ApolloConstant.Y;
      } else if ("game_city".equals(localObject1)) {
        localObject1 = ApolloConstant.ac;
      } else if (localApolloManager.jdField_d_of_type_Boolean) {
        localObject1 = ApolloConstant.ac;
      } else {
        localObject1 = ApolloConstant.Y;
      }
    }
    label580:
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i1 = this.jdField_d_of_type_Int;
    label600:
    int m;
    if (n != 0)
    {
      paramString = "0";
      if ((localApolloDrawerStatus == null) || (!localApolloDrawerStatus.jdField_b_of_type_Boolean)) {
        break label657;
      }
      m = 2;
    }
    for (;;)
    {
      VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "drawer_clk", i1, 0, new String[] { paramString, String.valueOf(m) });
      break;
      paramString = "1";
      break label600;
      label657:
      if (((ApolloManager)localObject1).jdField_d_of_type_Boolean) {
        m = 0;
      } else {
        m = 1;
      }
    }
  }
  
  private boolean c()
  {
    return false;
  }
  
  private void d(String paramString)
  {
    if ((this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_h_of_type_AndroidWidgetTextView == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    int m;
    if (paramString.charAt(0) == '-')
    {
      paramString = paramString.substring(1, paramString.length());
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.measure(0, 0);
      m = this.jdField_f_of_type_AndroidWidgetTextView.getMeasuredWidth();
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.measure(0, 0);
      this.jdField_h_of_type_AndroidWidgetTextView.measure(0, 0);
      int n = this.jdField_h_of_type_AndroidWidgetTextView.getMeasuredWidth();
      int i1 = this.jdField_e_of_type_AndroidWidgetTextView.getMeasuredWidth();
      if (n / 2 > i1 / 2 + m)
      {
        paramString = new RelativeLayout.LayoutParams(-2, -2);
        paramString.leftMargin = (n / 2 - i1 / 2 - m);
        if (m == 0)
        {
          this.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(paramString);
          return;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setLayoutParams(paramString);
        return;
      }
      if (n / 2 >= i1 / 2 + m) {
        break;
      }
      paramString = new LinearLayout.LayoutParams(-2, -2);
      paramString.leftMargin = (m + i1 / 2 - n / 2);
      paramString.topMargin = AIOUtils.a(4.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
      paramString.gravity = 80;
      this.jdField_h_of_type_AndroidWidgetTextView.setLayoutParams(paramString);
      return;
      m = 0;
    }
  }
  
  private void e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null)
    {
      localStringBuilder.append("地点：").append(this.jdField_h_of_type_AndroidWidgetTextView.getText()).append("，天气：");
      if (!paramString.equals("201")) {
        break label100;
      }
      localStringBuilder.append("晴");
    }
    for (;;)
    {
      localStringBuilder.append("，温度：").append(this.jdField_e_of_type_AndroidWidgetTextView.getText()).append("摄氏度");
      if ((AppSetting.jdField_b_of_type_Boolean) && (localStringBuilder != null)) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setContentDescription(localStringBuilder.toString());
      }
      return;
      label100:
      if (paramString.equals("202")) {
        localStringBuilder.append("多云");
      } else if (paramString.equals("203")) {
        localStringBuilder.append("阴");
      } else if (paramString.equals("204")) {
        localStringBuilder.append("雨");
      } else if (paramString.equals("205")) {
        localStringBuilder.append("雪");
      } else if (paramString.equals("206")) {
        localStringBuilder.append("雾");
      } else if (paramString.equals("207")) {
        localStringBuilder.append("沙尘");
      } else if (paramString.equals("208")) {
        localStringBuilder.append("霾");
      } else {
        localStringBuilder.append("未知");
      }
    }
  }
  
  private void f(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Date localDate = new Date();
    if (!(localDate.getYear() + ":" + localDate.getMonth() + localDate.getDay()).equals(localSharedPreferences.getString("sign_in_report" + paramString, ""))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
  }
  
  public void A()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    Object localObject;
    if ((!this.jdField_i_of_type_Boolean) && (localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
    {
      localObject = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
      ((AvatarPendantManager)localObject).b();
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      localObject = ((AvatarPendantManager)localObject).a(localExtensionInfo.pendantId);
      if (AvatarPendantUtil.a(localExtensionInfo.pendantId))
      {
        ((PendantInfo)localObject).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.jdField_h_of_type_Int, localExtensionInfo.uin, localExtensionInfo.pendantDiyId);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarPendant", "choutishow", 0, 0, "", "", "", "");
      }
    }
    for (int m = 1;; m = 0)
    {
      if ((m == 1) && (m == this.jdField_i_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X8006728");
      }
      return;
      ((PendantInfo)localObject).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.jdField_h_of_type_Int, localExtensionInfo.uin, localExtensionInfo.pendantDiyId);
      break;
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  public void B()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14));
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (this.jdField_c_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new tpz(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new tqa(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener = new tqb(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    }
    RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(false);
    if ((localRichStatus == null) || (localRichStatus.isEmpty()))
    {
      ThreadManager.getFileThreadHandler().post(new tqc(this));
      return;
    }
    a(localRichStatus);
  }
  
  void C()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) {
      QLog.e("QQSettingRedesign", 1, "preLoadSignature, mStatusManager == null");
    }
    label525:
    for (;;)
    {
      return;
      Object localObject1 = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131371311);
      TextView localTextView = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131371312);
      ImageView localImageView = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131371313);
      StringBuilder localStringBuilder = new StringBuilder(100);
      if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null))
      {
        localTextView.setShadowLayer(ScreenUtil.a(1.0F), 0.0F, 0.0F, 2130706432);
        localTextView.setMaxWidth(this.jdField_h_of_type_Int);
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qqsettingme_signature" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
        String str1 = ((SharedPreferences)localObject2).getString("actionText", "");
        int m = ((SharedPreferences)localObject2).getInt("actionId", 0);
        String str2 = ((SharedPreferences)localObject2).getString("dataText", "");
        localObject2 = ((SharedPreferences)localObject2).getString("plainText", "");
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "preLoadSignature, actionText = " + str1 + " actionId = " + m + " dataText = " + str2 + " plainText = " + (String)localObject2);
        }
        if (TextUtils.isEmpty(str1)) {
          break label445;
        }
        ((ImageView)localObject1).setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(m, 200));
        ((ImageView)localObject1).setVisibility(0);
        localStringBuilder.append(str1);
        if (!TextUtils.isEmpty(str2)) {
          localStringBuilder.append(str2);
        }
        localStringBuilder.append(' ');
        label346:
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localStringBuilder.append((String)localObject2);
        }
        localObject1 = localStringBuilder.toString();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label478;
        }
        localTextView.setText("编辑个性签名");
        localImageView.setVisibility(0);
      }
      for (;;)
      {
        if (!AppSetting.jdField_b_of_type_Boolean) {
          break label525;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
        this.jdField_a_of_type_JavaLangStringBuilder.append("个性签名").append((String)localObject1);
        this.jdField_c_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
        return;
        localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break;
        label445:
        ((ImageView)localObject1).setBackgroundResource(0);
        ((ImageView)localObject1).setPadding(0, 0, 0, 0);
        ((ImageView)localObject1).setImageResource(2130843333);
        ((ImageView)localObject1).setVisibility(8);
        break label346;
        label478:
        localImageView.setVisibility(8);
        if (DeviceInfoUtil.b()) {
          localTextView.setText((String)localObject1 + " ");
        } else {
          localTextView.setText((CharSequence)localObject1);
        }
      }
    }
  }
  
  protected void D()
  {
    try
    {
      a(3, this.jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void E()
  {
    if (((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).b())
    {
      G();
      this.jdField_b_of_type_Boolean = false;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_duty", "", "locker", "exp", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "TaskEntry updateDailySignInItemView mDayliSignMode = " + this.jdField_b_of_type_Boolean);
      }
      return;
      F();
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  protected void F()
  {
    String str = null;
    Object localObject4 = null;
    int i6 = 0;
    int i5 = 0;
    int i4 = 0;
    int i3 = 0;
    int i7 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131558887);
    int i8 = ScreenUtil.jdField_a_of_type_Int;
    int i9 = ScreenUtil.a(65.0F);
    int i10 = ScreenUtil.a(15.0F);
    int i11 = this.jdField_d_of_type_AndroidWidgetImageView.getWidth();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    long l1 = ((SharedPreferences)localObject1).getLong("sign_in_time_stamp", 0L);
    Object localObject5 = ((SharedPreferences)localObject1).getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_info", "");
    int m = i3;
    int n = i4;
    int i2 = i5;
    int i1 = i6;
    Object localObject2 = localObject4;
    localObject1 = str;
    try
    {
      localObject5 = new JSONObject((String)localObject5);
      m = i3;
      n = i4;
      i2 = i5;
      i1 = i6;
      localObject2 = localObject4;
      localObject1 = str;
      i5 = ((JSONObject)localObject5).optInt("type");
      m = i3;
      n = i4;
      i2 = i5;
      i1 = i6;
      localObject2 = localObject4;
      localObject1 = str;
      i4 = ((JSONObject)localObject5).optInt("redpoint");
      m = i3;
      n = i4;
      i2 = i5;
      i1 = i6;
      localObject2 = localObject4;
      localObject1 = str;
      i3 = ((JSONObject)localObject5).optInt("openfunc");
      m = i3;
      n = i4;
      i2 = i5;
      i1 = i6;
      localObject2 = localObject4;
      localObject1 = str;
      str = ((JSONObject)localObject5).optString("iconUrl");
      m = i3;
      n = i4;
      i2 = i5;
      i1 = i6;
      localObject2 = localObject4;
      localObject1 = str;
      localObject4 = ((JSONObject)localObject5).optString("wording");
      m = i3;
      n = i4;
      i2 = i5;
      i1 = i6;
      localObject2 = localObject4;
      localObject1 = str;
      i6 = ((JSONObject)localObject5).optInt("day");
      m = i3;
      n = i4;
      i2 = i5;
      i1 = i6;
      localObject2 = localObject4;
      localObject1 = str;
      if (QLog.isColorLevel())
      {
        m = i3;
        n = i4;
        i2 = i5;
        i1 = i6;
        localObject2 = localObject4;
        localObject1 = str;
        QLog.i("DailySignIn", 2, "doUpdateDailySignInItemView type=" + i5 + " redpoint=" + i4 + " openfunc=" + i3 + " iconUrl=" + str + " wording=" + (String)localObject4 + " day=" + i6);
      }
      localObject2 = localObject4;
      n = i5;
      localObject1 = str;
      i1 = i6;
      m = i4;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        i3 = m;
        m = n;
        n = i2;
      }
      f("0X8007CAB");
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130843348);
      localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371321);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1044;
      }
    }
    if (i3 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DailySignIn", 2, "0x922 kill enter");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    URLImageView localURLImageView;
    Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject5);
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject5);
    ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = 56;
    ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = 56;
    localObject4 = "https://hbd.url.cn/myapp/qq_desk/signin/" + (String)localObject1;
    localObject1 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject3);
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "use custom icon=" + (String)localObject4);
    }
    f("0X8007CB1");
    for (;;)
    {
      localURLImageView.setImageDrawable((Drawable)localObject1);
      localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371322);
      ((TextView)localObject1).setMaxWidth(i8 - i7 - i9 - (i10 + i11));
      ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131494165));
      if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null))
      {
        ((TextView)localObject1).setShadowLayer(ScreenUtil.a(1.0F), 0.0F, 0.0F, 2130706432);
        label786:
        if (n != 4) {
          break label1207;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "use signed wording:" + (String)localObject2);
        }
        f("0X8007CAF");
        localObject3 = String.valueOf(i1);
        if (((String)localObject2).indexOf((String)localObject3) < 0) {
          break label1197;
        }
        localObject2 = "已打卡" + ((String)localObject2).replace((CharSequence)localObject3, new StringBuilder().append((String)localObject3).append(" ").toString());
        i1 = ((String)localObject2).indexOf((String)localObject3);
        localObject2 = new SpannableString((CharSequence)localObject2);
        ((SpannableString)localObject2).setSpan(new AbsoluteSizeSpan(4, true), ((String)localObject3).length() + i1, ((String)localObject3).length() + i1 + 1, 33);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        label955:
        i1 = 0;
        if (MessageCache.a() - l1 > 86400L) {
          break label1256;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "sign info is fresh");
        }
        if ((n == 4) || (m != 1)) {
          break label1233;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "unsigned and need redpoint in 0x922,show redpoint");
        }
        m = 1;
      }
      for (;;)
      {
        if (m == 0) {
          break label1279;
        }
        localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
        f("0X8007CAD");
        return;
        label1044:
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "use default icon");
        }
        if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
          break label1292;
        }
        localObject1 = null;
        for (;;)
        {
          for (;;)
          {
            try
            {
              if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
              {
                localObject3 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130843348);
                localObject1 = localObject3;
              }
            }
            catch (OutOfMemoryError localOutOfMemoryError1) {}
            try
            {
              this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              localObject4 = localObject1;
              if (localObject4 == null) {
                break label1292;
              }
              localObject1 = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), BitmapUtil.a((Bitmap)localObject4));
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              label1155:
              break label1155;
            }
          }
          localObject3 = this.jdField_a_of_type_AndroidGraphicsBitmap;
          localObject1 = localObject3;
          continue;
          localObject4 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("QQSettingRedesign", 2, localOutOfMemoryError1, new Object[0]);
            localObject4 = localObject1;
          }
        }
        ((TextView)localObject1).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break label786;
        label1197:
        ((TextView)localObject1).setText((CharSequence)localObject2);
        break label955;
        label1207:
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "use unsigned wording");
        }
        ((TextView)localObject1).setText((CharSequence)localObject2);
        break label955;
        label1233:
        m = i1;
        if (QLog.isColorLevel())
        {
          QLog.i("DailySignIn", 2, "signed or 0x922 kill redpoint,do not show redpoint");
          m = i1;
          continue;
          label1256:
          m = i1;
          if (QLog.isColorLevel())
          {
            QLog.i("DailySignIn", 2, "sign info is old");
            m = i1;
          }
        }
      }
      label1279:
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      return;
      label1292:
      localObject1 = localObject5;
    }
  }
  
  protected void G()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("task_entry_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    boolean bool = ((SharedPreferences)localObject3).getBoolean("open", false);
    Object localObject1 = ((SharedPreferences)localObject3).getString("icon_url", "");
    Object localObject2 = ((SharedPreferences)localObject3).getString("night_icon_url", "");
    String str = ((SharedPreferences)localObject3).getString("word", "");
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DailySignIn", 2, "0x922 kill enter");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130843348);
    URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371321);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null))
    {
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label391;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = 56;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = 56;
      localObject2 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("DailySignIn", 2, "use custom icon=" + (String)localObject1);
      }
    }
    label391:
    label529:
    for (localObject1 = localObject2;; localObject1 = localDrawable)
    {
      localURLImageView.setImageDrawable((Drawable)localObject1);
      localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371322);
      ((TextView)localObject1).setMaxWidth(ScreenUtil.jdField_a_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131558887) - ScreenUtil.a(65.0F) - (ScreenUtil.a(15.0F) + this.jdField_d_of_type_AndroidWidgetImageView.getWidth()));
      ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131494165));
      if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
        ((TextView)localObject1).setShadowLayer(ScreenUtil.a(1.0F), 0.0F, 0.0F, 2130706432);
      }
      for (;;)
      {
        ((TextView)localObject1).setText(str);
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "use unsigned wording");
        }
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
        return;
        break;
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "use default icon");
        }
        if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
          break label529;
        }
        for (;;)
        {
          for (;;)
          {
            try
            {
              if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
                localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130843348);
              }
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              localObject1 = null;
            }
            try
            {
              this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              localObject3 = localObject1;
              if (localObject3 == null) {
                break label529;
              }
              localObject1 = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), BitmapUtil.a((Bitmap)localObject3));
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              label487:
              break label487;
            }
          }
          localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
          continue;
          localObject3 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("QQSettingRedesign", 2, localOutOfMemoryError1, new Object[0]);
            localObject3 = localObject1;
          }
        }
        ((TextView)localObject1).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
    }
  }
  
  protected void H()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_info", "");
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).optInt("redpoint") != 0) {
          f("0X8007CAE");
        }
        if (((JSONObject)localObject).optInt("type") != 4) {
          continue;
        }
        f("0X8007CB0");
        ((JSONObject)localObject).put("redpoint", 0);
        localSharedPreferences.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_info", ((JSONObject)localObject).toString()).commit();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      n();
      return;
      if (!TextUtils.isEmpty(((JSONObject)localObject).optString("iconUrl"))) {
        f("0X8007CB2");
      }
    }
  }
  
  public void I()
  {
    int m = 1;
    if (c())
    {
      ab();
      a(true);
    }
    for (;;)
    {
      boolean bool;
      try
      {
        bool = OfficeCenterSharedPref.a().a("officecenter_red_point_flag_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
        if (OfficeCenterSharedPref.a().a("officecenter_red_point_first_show", false)) {
          break label367;
        }
        OfficeCenterSharedPref.a().b("officecenter_red_point_first_show", true);
        OfficeCenterSharedPref.a().b("officecenter_red_point_flag_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
        if (bool) {
          break label367;
        }
        if (this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null)
        {
          this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = new BusinessInfoCheckUpdate.AppInfo();
          this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.path.set("");
          this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.num.set(0);
          this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.set(0);
          this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.uiAppId.set(-1);
          this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.type.set(0);
          this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.appset.set(1);
          this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.mission_level.set(0);
        }
        this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.red_display_info.red_type_info.clear();
        if (m != 0)
        {
          BusinessInfoCheckUpdate.RedDisplayInfo localRedDisplayInfo = new BusinessInfoCheckUpdate.RedDisplayInfo();
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
          localRedTypeInfo.red_type.set(9);
          localRedTypeInfo.red_content.set("-1");
          localRedTypeInfo.red_desc.set("");
          localRedDisplayInfo.red_type_info.add(localRedTypeInfo);
          localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
          localRedTypeInfo.red_type.set(0);
          localRedDisplayInfo.tab_display_info.set(localRedTypeInfo);
          localRedDisplayInfo.red_type_info.add(localRedTypeInfo);
          this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.red_display_info.set(localRedDisplayInfo);
          this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.set(1);
        }
        a(7, this.jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      a(false);
      return;
      label367:
      m = bool;
    }
  }
  
  public void J()
  {
    ApolloDrawerStatus localApolloDrawerStatus = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a();
    if ((localApolloDrawerStatus != null) && ((localApolloDrawerStatus instanceof FirstGameDrawerStatus)) && (((FirstGameDrawerStatus)localApolloDrawerStatus).a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Int);
      a("好玩的轻游戏，了解一下~", 33);
    }
  }
  
  public void K()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, ApolloConstant.ad);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "drawer_gamebox_show", 0, 0, new String[0]);
  }
  
  public void L()
  {
    ThreadManager.getUIHandler().post(new tqy(this));
  }
  
  public void M()
  {
    this.jdField_f_of_type_Boolean = true;
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_Tri, 16);
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, null, "Bubble");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "set apollodrawer status 9999");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a();
    }
  }
  
  public void N()
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
  }
  
  public void O()
  {
    ThreadManager.getSubThreadHandler().post(new trj(this));
  }
  
  public UpSideDownDrawable a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (UpSideDownDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected String a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_info", "");
    try
    {
      str = new JSONObject(str).optString("url");
      return str;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onResume!");
    }
    if (!this.jdField_d_of_type_Boolean) {
      j();
    }
    AbstractGifImage.resumeAll();
    AbstractVideoImage.resumeAll();
    B();
    p();
    z();
    R();
    Object localObject1;
    if (((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("window")).getDefaultDisplay().getWidth() > 480)
    {
      aa();
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager.a();
      k();
      b(true);
      af();
      r();
      I();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((localObject1 != null) && (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t();
      }
      l();
      b();
      this.jdField_c_of_type_Boolean = true;
      Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800433C", "0X800433C", 0, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        long l1 = WebProcessManager.a((String)localObject1, "key_individuation_click_time");
        if ((l1 == -1L) || (System.currentTimeMillis() - l1 < 259200000L)) {
          WebProcessManager.a(jdField_b_of_type_JavaUtilList, "key_individuation_dns_parse");
        }
        l1 = WebProcessManager.b((String)localObject1);
        if (System.currentTimeMillis() - l1 < 604800000L) {
          WebProcessManager.a(jdField_a_of_type_JavaUtilList, "key_vip_dns_parse");
        }
      }
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[8];
      if (localObject1 != null)
      {
        localObject2 = (BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(111);
        if ((localObject2 == null) || (!((BusinessCardManager)localObject2).a(0))) {
          break label413;
        }
        ((View)localObject1).setVisibility(0);
      }
      label325:
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
      if (localObject1 != null)
      {
        localObject2 = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180);
        if ((localObject2 == null) || (!((QQStoryManager)localObject2).f())) {
          break label422;
        }
        ((View)localObject1).setVisibility(0);
      }
    }
    for (;;)
    {
      P();
      Q();
      return;
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if (this.jdField_h_of_type_AndroidWidgetTextView == null) {
        break;
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
      label413:
      ((View)localObject1).setVisibility(8);
      break label325;
      label422:
      ((View)localObject1).setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramInt, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation != this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = paramConfiguration.orientation;
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from onConfigurationChanged");
      }
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "fillData, " + this.jdField_d_of_type_Boolean);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      h();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      i();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a(paramQQAppInterface);
      p();
      B();
      S();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(Card paramCard)
  {
    int n = 1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int m;
    label31:
    float f3;
    float f1;
    if (paramCard.bSuperVipOpen == 1)
    {
      m = 1;
      if (paramCard.bQQVipOpen != 1) {
        break label369;
      }
      paramCard = ((Resources)localObject).getDisplayMetrics();
      f3 = ((Resources)localObject).getDimension(2131558555);
      if (n == 0) {
        break label393;
      }
      if (m == 0) {
        break label375;
      }
      f1 = paramCard.density * 46.0F;
    }
    for (;;)
    {
      label66:
      float f2 = ((Resources)localObject).getDimension(2131558905);
      float f4 = ((Resources)localObject).getDimension(2131558896);
      float f5 = ((Resources)localObject).getDimension(2131558901);
      float f6 = ((Resources)localObject).getDimension(2131558906);
      float f7 = ((Resources)localObject).getDimension(2131558887);
      f4 = paramCard.widthPixels - (f2 + f4 + f5 + f6 + f7);
      f2 = f4;
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        f2 = f4;
        if (this.jdField_b_of_type_AndroidWidgetTextView.getWidth() > 0) {
          f2 = Math.min(f4, this.jdField_b_of_type_AndroidWidgetTextView.getWidth());
        }
      }
      f4 = f2 - f1;
      if (f3 <= 1.0F) {}
      for (f2 = 1.0F;; f2 = f3)
      {
        QQSettingUtil.jdField_a_of_type_Int = (int)Math.floor(f4 / f2);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("resizeQQLevelIconSize width=" + paramCard.widthPixels);
          ((StringBuilder)localObject).append(",iconSize=" + f2);
          ((StringBuilder)localObject).append(",vipSize=" + f1);
          ((StringBuilder)localObject).append(",space=" + f4);
          ((StringBuilder)localObject).append(",maxIconSize=" + QQSettingUtil.jdField_a_of_type_Int);
          QLog.i("QQSettingRedesign", 4, ((StringBuilder)localObject).toString());
        }
        return;
        m = 0;
        break;
        label369:
        n = 0;
        break label31;
        label375:
        f1 = paramCard.density * 42.0F;
        break label66;
      }
      label393:
      f1 = 0.0F;
    }
  }
  
  @TargetApi(9)
  public void a(RichStatus paramRichStatus)
  {
    ImageView localImageView2 = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131371311);
    TextView localTextView = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131371312);
    ImageView localImageView1 = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131371313);
    StringBuilder localStringBuilder = new StringBuilder(100);
    SharedPreferences.Editor localEditor;
    if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null))
    {
      localTextView.setShadowLayer(ScreenUtil.a(1.0F), 0.0F, 0.0F, 2130706432);
      localTextView.setMaxWidth(this.jdField_h_of_type_Int);
      localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qqsettingme_signature" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
      if ((paramRichStatus == null) || (TextUtils.isEmpty(paramRichStatus.actionText))) {
        break label408;
      }
      localImageView2.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramRichStatus.actionId, 200));
      localImageView2.setVisibility(0);
      localStringBuilder.append(paramRichStatus.actionText);
      if (!TextUtils.isEmpty(paramRichStatus.dataText)) {
        localStringBuilder.append(paramRichStatus.dataText);
      }
      localStringBuilder.append(' ');
      localEditor.putInt("actionId", paramRichStatus.actionId);
      localEditor.putString("actionText", paramRichStatus.actionText);
      localEditor.putString("dataText", paramRichStatus.dataText);
      label254:
      if ((paramRichStatus != null) && (paramRichStatus.plainText != null))
      {
        if (paramRichStatus.plainText.size() <= 0) {
          break label441;
        }
        paramRichStatus = (String)paramRichStatus.plainText.get(0);
        if (!TextUtils.isEmpty(paramRichStatus))
        {
          localStringBuilder.append(paramRichStatus);
          localEditor.putString("plainText", paramRichStatus);
        }
      }
      label287:
      if (Build.VERSION.SDK_INT <= 8) {
        break label446;
      }
      localEditor.apply();
      label328:
      paramRichStatus = localStringBuilder.toString();
      if (!TextUtils.isEmpty(paramRichStatus)) {
        break label457;
      }
      localTextView.setText("编辑个性签名");
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
        this.jdField_a_of_type_JavaLangStringBuilder.append("个性签名").append(paramRichStatus);
        this.jdField_c_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break;
      label408:
      localImageView2.setBackgroundResource(0);
      localImageView2.setPadding(0, 0, 0, 0);
      localImageView2.setImageResource(2130843333);
      localImageView2.setVisibility(8);
      break label254;
      label441:
      paramRichStatus = null;
      break label287;
      label446:
      localEditor.commit();
      break label328;
      label457:
      localImageView1.setVisibility(8);
      if (DeviceInfoUtil.b()) {
        localTextView.setText(paramRichStatus + " ");
      } else {
        localTextView.setText(paramRichStatus);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new tpr(this, paramString));
  }
  
  public void a(String paramString, UpSideDownDrawable paramUpSideDownDrawable)
  {
    if (paramUpSideDownDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "[storeDynamicDrawable] drawable to be stored is null");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramUpSideDownDrawable);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[7];
    if (paramBoolean) {}
    for (int m = 0;; m = 8)
    {
      localView.setVisibility(m);
      if (paramBoolean) {
        DingdongPluginHelper.a("0X800779A", 1);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQSettingRedesign", 2, "updateMyVipInfo svip= " + paramBoolean1 + ",vip=" + paramBoolean2 + ",viplevel=" + paramInt);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131371363);
    localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131371362);
    localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    localObject1 = localResources.getString(2131436804);
    try
    {
      if (!this.jdField_j_of_type_Boolean) {
        break label327;
      }
      m = 2130843349;
    }
    catch (Exception localException2)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vipTitleSpFile", 0).edit().putString("vipTitleSpKey_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject2).commit();
          if (QLog.isColorLevel()) {
            QLog.d("QQSettingRedesign", 2, "vipText = " + (String)localObject2);
          }
          this.jdField_a_of_type_ArrayOfAndroidViewView[0].setVisibility(0);
          if (AppSetting.jdField_b_of_type_Boolean) {
            AccessibilityUtil.a(this.jdField_a_of_type_ArrayOfAndroidViewView[0], (CharSequence)localObject2, Button.class.getName());
          }
          return;
          int m = 2130843350;
          continue;
          localObject2 = localResources.getString(2131436806);
          localObject1 = localObject2;
          continue;
          if (paramBoolean2)
          {
            localImageView.setImageResource(m);
            if (!TextUtils.isEmpty(VipGrayConfigHelper.a().jdField_b_of_type_JavaLangString))
            {
              localObject2 = VipGrayConfigHelper.a().jdField_b_of_type_JavaLangString;
              localObject1 = localObject2;
            }
            else
            {
              localObject2 = localResources.getString(2131436805);
              localObject1 = localObject2;
            }
          }
          else
          {
            localImageView.setImageResource(m);
            m = ((SharedPreferences)localObject2).getInt("key_selfvip_growthvalue", 0);
            if ((paramInt > 0) || (m > 0))
            {
              if (!TextUtils.isEmpty(VipGrayConfigHelper.a().c))
              {
                localObject2 = VipGrayConfigHelper.a().c;
                localObject1 = localObject2;
              }
              else
              {
                localObject2 = localResources.getString(2131436807);
                localObject1 = localObject2;
              }
            }
            else if (!TextUtils.isEmpty(VipGrayConfigHelper.a().jdField_a_of_type_JavaLangString))
            {
              localObject2 = VipGrayConfigHelper.a().jdField_a_of_type_JavaLangString;
              localObject1 = localObject2;
            }
            else
            {
              localObject2 = localResources.getString(2131436804);
              localObject1 = localObject2;
            }
          }
        }
        localException2 = localException2;
        localException2.printStackTrace();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          QLog.e("QQSettingRedesign", 1, "updateMyVipInfo, exception e = ", localException1);
        }
      }
    }
    if (paramBoolean1)
    {
      localImageView.setImageResource(m);
      if (!TextUtils.isEmpty(VipGrayConfigHelper.a().d))
      {
        localObject2 = VipGrayConfigHelper.a().d;
        localObject1 = localObject2;
        localObject2 = localObject1;
        if (((String)localObject1).length() > 8) {
          localObject2 = ((String)localObject1).substring(0, 8);
        }
        localTextView.setText((CharSequence)localObject2);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
    }
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    try
    {
      localObject = new JSONObject(paramString2);
      paramString2 = ((JSONObject)localObject).optString("_show_mission");
      localObject = ((JSONObject)localObject).optJSONObject("msg");
      if (localObject != null)
      {
        JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject(paramString2);
        if (localJSONObject == null) {
          break label416;
        }
        int m = localJSONObject.optInt("time");
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
          return false;
        }
        if (m == this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("apollo_sp", 0).getInt(paramString1, 0)) {
          return false;
        }
        paramString1 = localJSONObject.optString("content");
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject = new JSONObject(paramString1);
          paramString1 = new DrawerPushItem();
          paramString1.msg_type = paramInt;
          paramString1.is_reddot = 1;
          paramString1.msg_id = paramString2;
          if (!((JSONObject)localObject).has("mainPriority")) {
            return false;
          }
          paramString1.act_id = ((JSONObject)localObject).optString("id");
          paramString1.priority = ((JSONObject)localObject).optInt("mainPriority");
          paramString1.sub_priority = ((JSONObject)localObject).optInt("subPriority");
          paramString1.start_ts = ((JSONObject)localObject).optInt("showTime");
          paramString1.end_ts = ((JSONObject)localObject).optInt("expireTime");
          paramString1.send_time = m;
          paramString1.action_id = ((JSONObject)localObject).optInt("actionId");
          paramString1.color = ((JSONObject)localObject).optInt("fontColor");
          paramString1.content = ((JSONObject)localObject).optString("bubbleText");
          paramString1.bubble_res_id = ((JSONObject)localObject).optInt("bubbleID");
          paramInt = ((JSONObject)localObject).optInt("type");
          paramString1.scheme = ((JSONObject)localObject).optString("scheme");
          if (paramInt == 0) {}
          for (;;)
          {
            paramString1.show_counts = ((JSONObject)localObject).optInt("showCounts");
            localObject = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
            if (!paramBoolean) {
              break label407;
            }
            ((ApolloManager)localObject).c(paramString1);
            break label470;
            if (paramInt != 1) {
              break;
            }
            paramString1.ext_url = ApolloConstant.J;
          }
        }
      }
      return false;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "parseRedInfo error :" + paramString1.toString());
      }
    }
    while (paramInt == 2)
    {
      paramString1.ext_url = ((JSONObject)localObject).optString("url");
      break;
      label407:
      ((ApolloManager)localObject).b(paramString2);
      break label470;
      label416:
      if ((!paramBoolean) && ((this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a() instanceof PushDrawerStatus)) && (((JSONObject)localObject).has(String.valueOf(PushDrawerStatus.d)))) {
        ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(PushDrawerStatus.d);
      }
    }
    label470:
    return true;
  }
  
  int[] a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new int[] { 2130843349, 2130843336, 2130843346, 2130843351, 2130843353, 2130843355, 2130843307, 2130843340, 2130843309, 2130843334, 2130843338, 2130843312 };
    }
    return new int[] { 2130843350, 2130843337, 2130843347, 2130843352, 2130843354, 2130843356, 2130843308, 2130843341, 2130843310, 2130843335, 2130843339, 2130843313 };
  }
  
  @TargetApi(14)
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "refreshApolloView isResume:", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
    }
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_l_of_type_Boolean))
    {
      this.jdField_l_of_type_Boolean = false;
      boolean bool = a(this.jdField_f_of_type_Int);
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a != null)) {
        break label113;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, new Object[] { "refreshApolloView not show apollo,needShowApollo:", Boolean.valueOf(bool) });
      }
    }
    return;
    label113:
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.b();
    }
    ThreadManagerV2.removeJobFromThreadPool(this.jdField_a_of_type_Tri, 16);
    ThreadManagerV2.excute(this.jdField_a_of_type_Tri, 16, null, true);
  }
  
  public void b(String paramString)
  {
    ThreadManager.post(new tps(this, paramString), 5, null, false);
  }
  
  public void c()
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (Build.VERSION.SDK_INT < 14)) {}
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
          if (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            localObject2 = new ArrayList();
            int m = 0;
            while (m < ApolloConstant.b.length)
            {
              localObject3 = ((RedTouchManager)localObject1).a(ApolloConstant.b[m]);
              if ((localObject3 != null) && (!TextUtils.isEmpty(((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.get()))) {
                ((List)localObject2).add(localObject3);
              }
              m += 1;
            }
            if ((localObject2 != null) && (((List)localObject2).size() > 0))
            {
              m = 0;
              if (m < ((List)localObject2).size())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QQSettingRedesign", 2, "buffer = " + ((BusinessInfoCheckUpdate.AppInfo)((List)localObject2).get(m)).buffer.get());
                }
                localObject3 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject2).get(m)).path.get();
                String str = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject2).get(m)).buffer.get();
                if (((BusinessInfoCheckUpdate.AppInfo)((List)localObject2).get(m)).iNewFlag.get() == 1) {}
                for (bool1 = true;; bool1 = false)
                {
                  a(0, (String)localObject3, str, bool1);
                  m += 1;
                  break;
                }
              }
            }
          }
        } while (!((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).jdField_e_of_type_Boolean);
        localObject1 = ((RedTouchManager)localObject1).a("103100.103200.103240.103247");
      } while (localObject1 == null);
      localObject2 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, new Object[] { "[parseApolloRedTouch] game box redpoint buffer=", localObject2 });
      }
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    Object localObject2 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).path.get();
    Object localObject3 = ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get();
    if (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() == 1) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a(8, (String)localObject2, (String)localObject3, bool1);
      return;
    }
  }
  
  public void d()
  {
    if (ApolloConfigUtils.c == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "apllo step don't in writelist");
      }
    }
    int m;
    do
    {
      Object localObject2;
      do
      {
        boolean bool;
        do
        {
          return;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("apollo_sp", 0);
          localObject1 = Calendar.getInstance();
          bool = (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + ((Calendar)localObject1).get(6)).equals(((SharedPreferences)localObject2).getString("sp_key_apollo_step_flag", ""));
        } while ((Build.VERSION.SDK_INT < 19) || (bool));
        localObject2 = ((SensorManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("sensor")).getDefaultSensor(19);
        m = ((Calendar)localObject1).get(11);
      } while ((localObject2 == null) || (m < 17));
      Object localObject1 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), StepCounterServlert.class);
      ((NewIntent)localObject1).putExtra("msf_cmd_type", "cmd_refresh_steps");
      ((NewIntent)localObject1).setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
    } while (!QLog.isColorLevel());
    QLog.d("QQSettingRedesign", 2, "getStepTatal time = " + m);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject2;
    do
    {
      return;
      localObject1 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
      if (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject2 = ((ApolloManager)localObject1).a(0);
        if (localObject2 != null)
        {
          localObject2 = new PushDrawerStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DrawerPushItem)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a((ApolloDrawerStatus)localObject2);
        }
        long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getLong("hire_end", 0L);
        if (NetConnInfoCenter.getServerTime() < l1)
        {
          localObject2 = new HireDrawerStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a((ApolloDrawerStatus)localObject2);
        }
        ad();
      }
    } while (!((ApolloManager)localObject1).jdField_e_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("apollo_sp", 0).getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "apollo_game_box_settingme_first_enter", true))
    {
      localObject2 = new FirstGameDrawerStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a((ApolloDrawerStatus)localObject2);
    }
    Object localObject1 = ((ApolloManager)localObject1).a(8);
    if ((localObject1 != null) && ((this.jdField_f_of_type_Int == 3) || (this.jdField_f_of_type_Int == 2)))
    {
      localObject1 = new GameBoxDrawerStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DrawerPushItem)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a((ApolloDrawerStatus)localObject1);
    }
    ac();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onPause!");
    }
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
    }
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager);
    }
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
    }
    if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a();
    }
    if (this.jdField_k_of_type_Boolean) {
      ae();
    }
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onDestroy!");
    }
    if (this.jdField_d_of_type_Boolean)
    {
      h();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.b();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
        if (localAvatarPendantManager != null) {
          localAvatarPendantManager.c();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.c();
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageBitmap(null);
      }
      S();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQSettingRedesign", 2, localException.toString());
        }
      }
    }
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager.a(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a(this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback, false, true);
    }
    VipGrayConfigHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper$VipGrayConfigListener);
    MemoryClearManagerNew.a().b(this.jdField_a_of_type_ComTencentCommonCacheMemoryClearManagerNew$IClearMemoryListener);
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a(this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback, true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager = ((WeatherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(113));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener);
      }
      VipGrayConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper$VipGrayConfigListener);
      MemoryClearManagerNew.a().a(this.jdField_a_of_type_ComTencentCommonCacheMemoryClearManagerNew$IClearMemoryListener);
    }
  }
  
  public void j()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "init, " + this.jdField_d_of_type_Boolean);
    }
    if (true == this.jdField_d_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic = new NightModeLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      i();
      p();
      B();
      z();
      k();
      r();
      R();
      l();
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.opencenter.vipInfo"));
        if (!TextUtils.isEmpty(VipGrayConfigHelper.a().jdField_b_of_type_JavaLangString)) {
          continue;
        }
        ThreadManager.post(new trg(this), 5, null, true);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQSettingRedesign", 2, "initUpdateVipInfoReceiver:" + localException.toString());
          }
        }
      }
    }
  }
  
  public void k()
  {
    ThreadManager.post(new tpn(this), 5, null, false);
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ThreadManager.post(new tpo(this), 5, null, true);
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext != null)
    {
      CardDrawerStatus localCardDrawerStatus = new CardDrawerStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a(localCardDrawerStatus);
    }
  }
  
  public void n()
  {
    X();
    s();
    t();
    x();
    y();
    D();
    u();
    o();
    v();
    w();
    I();
    E();
    Y();
    V();
  }
  
  protected void o()
  {
    try
    {
      a(4, this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      ((QzoneAlbumRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103)).a(this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (!this.jdField_d_of_type_Boolean)) {}
    long l1;
    label2137:
    do
    {
      do
      {
        do
        {
          Object localObject2;
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
                    do
                    {
                      return;
                      switch (paramView.getId())
                      {
                      default: 
                        return;
                      case 2131364082: 
                        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
                        paramView.jdField_g_of_type_Int = 1;
                        paramView.jdField_h_of_type_Int = 8;
                        ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 1009);
                        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D7");
                        DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
                      }
                    } while (!this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a());
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X8006726");
                    return;
                    if (this.jdField_b_of_type_Boolean)
                    {
                      paramView = "https://ti.qq.com/signin/public/index.html" + a();
                      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
                      ((Intent)localObject1).putExtra("portraitOnly", true);
                      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                      ((Intent)localObject1).putExtra("hide_operation_bar", true);
                      ((Intent)localObject1).putExtra("hide_more_button", true);
                      ((Intent)localObject1).putExtra("url", paramView);
                      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
                      H();
                      f("0X8007CAC");
                    }
                    while (QLog.isColorLevel())
                    {
                      QLog.i("DailySignIn", 2, "mydaily onClick mDayliSignMode = " + this.jdField_b_of_type_Boolean);
                      return;
                      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("task_entry_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getString("jump_url", "");
                      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
                      ((Intent)localObject1).putExtra("portraitOnly", true);
                      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                      ((Intent)localObject1).putExtra("hide_operation_bar", true);
                      ((Intent)localObject1).putExtra("hide_more_button", true);
                      ((Intent)localObject1).putExtra("url", paramView);
                      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_duty", "", "locker", "clk", 0, 0, "", "", "", "");
                    }
                    paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
                    paramView.jdField_g_of_type_Int = 1;
                    paramView.jdField_h_of_type_Int = 8;
                    ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 1009);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D6");
                    return;
                    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
                    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                    paramView.putExtra("title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131430002));
                    paramView.putExtra("nick", ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1));
                    paramView.putExtra("uin", (String)localObject1);
                    paramView.putExtra("type", 1);
                    paramView.putExtra("reportFlag", 1);
                    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055BB", "0X80055BB", 0, 0, "", "", "", "");
                    return;
                    l1 = System.currentTimeMillis();
                  } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l1));
                  this.jdField_a_of_type_Long = l1;
                } while (!QWalletHelper.isValidToLaunchQWallet(l1));
                QWalletHelper.launchQWalletAct(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_wallet", "Clk_wallet", 0, 0, "", "", "", "");
                QQSettingUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100007));
                if (jdField_a_of_type_Int > 0)
                {
                  DrawerFrame.jdField_a_of_type_Int = 2;
                  return;
                }
                DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
                return;
                if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()) {}
                for (boolean bool = true;; bool = false)
                {
                  QfavHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, -1, bool);
                  QfavReport.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0);
                  QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                  DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
                  ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(103000));
                  return;
                }
                paramView = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
                bool = false;
                localObject1 = new QZoneClickReport.ReportInfo();
                ((QZoneClickReport.ReportInfo)localObject1).a("443");
                ((QZoneClickReport.ReportInfo)localObject1).b("3");
                ((QZoneClickReport.ReportInfo)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
                if ((this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1))
                {
                  bool = true;
                  ((QZoneClickReport.ReportInfo)localObject1).c("1");
                }
                for (;;)
                {
                  QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (QZoneClickReport.ReportInfo)localObject1);
                  paramView.b(String.valueOf(100180));
                  try
                  {
                    l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
                    localObject2 = QZoneHelper.UserInfo.a();
                    ((QZoneHelper.UserInfo)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l1);
                    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
                    paramView = (View)localObject1;
                    if (TextUtils.isEmpty((CharSequence)localObject1)) {
                      paramView = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                    }
                    ((QZoneHelper.UserInfo)localObject2).jdField_b_of_type_JavaLangString = paramView;
                    QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (QZoneHelper.UserInfo)localObject2, Long.valueOf(l1), 0, bool, -1);
                    paramView = new QZoneClickReport.ReportInfo();
                    paramView.c = "1";
                    paramView.d = "0";
                    paramView.jdField_b_of_type_Int = 4;
                    paramView.k = "3";
                    paramView.l = "drawerAlbumList";
                    paramView.m = "QZonePhotoListActivity";
                    QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView);
                    paramView = new HashMap();
                    paramView.put("source_type", "3");
                    paramView.put("source_from", "drawerAlbumList");
                    paramView.put("source_to", "QZonePhotoListActivity");
                    StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramView, null);
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
                    DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
                    return;
                    ((QZoneClickReport.ReportInfo)localObject1).c("2");
                  }
                  catch (Exception paramView)
                  {
                    for (;;)
                    {
                      paramView.printStackTrace();
                      l1 = 0L;
                    }
                  }
                }
                ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100005));
                VasWebviewUtil.openIndividuationIndex(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
                ThreadManager.post(new tpu(this), 5, null, true);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Personality_setting", 0, 0, "", "", "", "");
                DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
                return;
                paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQSettingSettingActivity.class);
                this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
                if (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004DB0", "0X8004DB0", 0, 0, "", "", UpgradeController.a(), "");
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0)) {
                  ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iNewTimeStamp);
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
                ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100190));
                DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
                return;
                this.jdField_d_of_type_AndroidViewView.setOnClickListener(null);
                this.jdField_d_of_type_AndroidViewView.setClickable(false);
                this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
                DrawerFrame.jdField_a_of_type_Int = 0;
              } while (!AppSetting.jdField_b_of_type_Boolean);
              if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
              for (paramView = "关闭夜间模式";; paramView = "夜间模式 ")
              {
                AccessibilityUtil.a(this.jdField_d_of_type_AndroidViewView, paramView, Button.class.getName());
                return;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005BE4", "0X8005BE4", 0, 0, "", "", "", "");
              localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
              localObject1 = "https://weather.mp.qq.com/?_wv=5127&asyncMode=1";
              paramView = (View)localObject1;
              if (this.jdField_h_of_type_AndroidWidgetTextView.getText() != null)
              {
                paramView = (View)localObject1;
                if (this.jdField_h_of_type_AndroidWidgetTextView.getText().length() <= 0) {}
              }
              try
              {
                paramView = "https://weather.mp.qq.com/?_wv=5127&asyncMode=1&city=" + URLEncoder.encode(this.jdField_h_of_type_AndroidWidgetTextView.getText().toString(), "utf-8");
                ((Intent)localObject2).putExtra("url", paramView);
                this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
                ((Intent)localObject2).putExtra("url", paramView);
                return;
              }
              catch (UnsupportedEncodingException paramView)
              {
                for (;;)
                {
                  paramView = "https://weather.mp.qq.com/?_wv=5127&asyncMode=1&city=" + this.jdField_h_of_type_AndroidWidgetTextView.getText();
                }
              }
              paramView = "";
              localObject1 = paramView;
              RedTouchManager localRedTouchManager;
              BusinessInfoCheckUpdate.AppInfo localAppInfo;
              if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null)
              {
                localObject1 = paramView;
                if (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a())
                {
                  localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
                  localAppInfo = localRedTouchManager.a(String.valueOf(100450));
                  localObject1 = IndividuationUrlHelper.a("signatureH5Url");
                  if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).startsWith("http"))) {
                    break label2137;
                  }
                  VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject1, -1L, null, false, -1);
                }
              }
              for (;;)
              {
                localRedTouchManager.b(String.valueOf(100450));
                DrawerFrame.jdField_a_of_type_Int = 0;
                localObject1 = paramView;
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "set_enter", 0, 0, "", "", (String)localObject1, "");
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D8");
                return;
                if (QIPCServerHelper.getInstance().isModuleRunning("qqindividuality_plugin.apk"))
                {
                  localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQIndividualityProxyActivity.class);
                  ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
                }
                for (;;)
                {
                  ((Intent)localObject2).putExtra("k_source", 0);
                  ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
                  ((Intent)localObject2).putExtra(QQIndividualityUtils.l, 1);
                  ((Intent)localObject2).putExtra(QQIndividualityUtils.e, "path");
                  ((Intent)localObject2).putExtra(QQIndividualityUtils.f, "name");
                  localObject1 = paramView;
                  if (localAppInfo != null)
                  {
                    localObject1 = paramView;
                    if (localAppInfo.iNewFlag != null)
                    {
                      localObject1 = paramView;
                      if (localAppInfo.iNewFlag.get() != 0)
                      {
                        localObject1 = paramView;
                        if (localAppInfo.missions.has())
                        {
                          localObject1 = (String)localAppInfo.missions.get().get(0);
                          ((Intent)localObject2).putExtra("k_taskId", (String)localObject1);
                        }
                      }
                    }
                  }
                  if (!QIPCServerHelper.getInstance().isModuleRunning("qqindividuality_plugin.apk")) {
                    break label2372;
                  }
                  QQIndividualityProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "com.qqindividuality.activity.QQIndividualitySignatureActivity", QQIndividualityProxyActivity.class, null, -1);
                  paramView = (View)localObject1;
                  break;
                  localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQIndividualityBridgeActivity.class);
                }
                this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
                paramView = (View)localObject1;
              }
              l1 = System.currentTimeMillis();
            } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l1));
            this.jdField_a_of_type_Long = l1;
            if (QLog.isColorLevel()) {
              QLog.i("QQSettingRedesign", 2, "enter vip");
            }
            ThreadManager.post(new tpv(this), 5, null, true);
            W();
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
            if (jdField_a_of_type_Int > 0)
            {
              DrawerFrame.jdField_a_of_type_Int = 2;
              return;
            }
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            return;
            paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QfileFileAssistantActivity.class);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            paramView = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
            localObject1 = paramView.a(String.valueOf(100160));
          } while ((localObject1 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() == 0));
          paramView.b(String.valueOf(100160));
          try
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("service_type", 2);
            ((JSONObject)localObject2).put("act_id", 1002);
            paramView.b((BusinessInfoCheckUpdate.AppInfo)localObject1, ((JSONObject)localObject2).toString());
            return;
          }
          catch (JSONException paramView)
          {
            paramView.printStackTrace();
            return;
          }
          if ((((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("window")).getDefaultDisplay().getWidth() <= 480) && (this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch.a()))
          {
            this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch.b();
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("apollo_sp", 0).edit().putBoolean("apollo_480_static", true).commit();
          }
          Object localObject1 = new Intent();
          if (paramView.getId() == 2131371353)
          {
            ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((Intent)localObject1).putExtra("extra_key_box_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((Intent)localObject1).putExtra("extra_key_open_box", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
            if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setApolloHadStolen();
              ((Intent)localObject1).putExtra("key_box_type", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
            }
            ((Intent)localObject1).putExtra("extra_key_box_from", "drawer");
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "0X80065C0", 0, 0, new String[] { "0" });
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject1, "drawer", ApolloConstant.Y, null);
            if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() != 0) {
              break label3008;
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "drawer_clk", this.jdField_d_of_type_Int, 0, new String[] { "1", "" });
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
            return;
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject1, "drawer", ApolloConstant.X, null);
            break;
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "drawer_clk", this.jdField_d_of_type_Int, 0, new String[] { "0", "" });
          }
          if (jdField_a_of_type_Int > 0) {}
          for (DrawerFrame.jdField_a_of_type_Int = 2;; DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int)
          {
            ThreadManager.post(new tpw(this), 5, null, true);
            DingdongCalendarSyncUtil.a();
            paramView = new Intent();
            localObject1 = (DingdongPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(114);
            paramView.putExtra("schedule_unread_count", ((DingdongPluginManager)localObject1).a());
            DingdongPluginHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "com.dingdong.business.Schedule.Activity.ScheduleListActivity", paramView, -1);
            ((DingdongPluginManager)localObject1).a(0);
            DingdongPluginHelper.a("0X800651A", 1);
            return;
          }
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf(100500));
          paramView = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).getString("drawerUrl", "");
          if (TextUtils.isEmpty(paramView)) {
            QLog.e("QQSettingRedesign", 1, "cuKingCard url = null");
          }
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
          return;
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, BusinessCardListActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064D7", "0X80064D7", 0, 0, "", "", "", "");
          return;
          QQStoryMemoriesActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, QQStoryContext.a().b(), true);
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          return;
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("call_tim_config_pre" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("call_tim_config_url", "https://docs.qq.com/desktop/m/index.html");
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800887E", "0X800887E", 0, 0, "", "", "", "");
          return;
          l1 = System.currentTimeMillis();
        } while (!ApolloUtil.a(this.jdField_a_of_type_Long, l1));
        this.jdField_a_of_type_Long = l1;
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "game_bubble_tv click");
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a();
      } while ((paramView == null) || ((!(paramView instanceof GameBoxDrawerStatus)) && (!(paramView instanceof FirstGameDrawerStatus))));
      this.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      l1 = System.currentTimeMillis();
    } while (!ApolloUtil.a(this.jdField_a_of_type_Long, l1));
    label2372:
    this.jdField_a_of_type_Long = l1;
    label3008:
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "game click:", Integer.valueOf(paramView.getId()) });
    }
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "drawer_gamebox_click", 0, 0, new String[0]);
    ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void p()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable(ImageUtil.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    a(str);
    if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(ScreenUtil.a(1.0F), 0.0F, 0.0F, 2130706432);
    }
    for (;;)
    {
      ThreadManager.postImmediately(new tpp(this, str), null, true);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from updateAccountInfo");
      }
      b(str);
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      if (!AppSetting.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
  }
  
  public void q()
  {
    int n = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "ThemeDebugKeyLog:onPostThemeChanged, refresh pendant after theme changed.");
    }
    A();
    this.jdField_h_of_type_Boolean = true;
    Object localObject1 = ThemeUtil.getCurrentThemeInfo();
    Object localObject2 = ((Bundle)localObject1).getString("themeId");
    boolean bool;
    int m;
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || ("1000".equals(localObject2)) || ("1103".equals(localObject2)))
    {
      bool = true;
      this.jdField_j_of_type_Boolean = bool;
      if (!this.jdField_j_of_type_Boolean) {
        break label421;
      }
      m = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131494162);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843343);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843329);
      label134:
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onPostThemeChanged, color=" + m + ",themeid = " + (String)localObject2 + ", enginePath=" + ((Bundle)localObject1).getString("themePath"));
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(m);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(m);
      T();
      localObject1 = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131371313);
      if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
        break label458;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-10591367);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-10591367);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-10591367);
      localObject1 = a(2130843331, true);
      ((StateListDrawable)localObject1).setBounds(0, 0, this.jdField_d_of_type_AndroidWidgetImageView.getWidth(), this.jdField_d_of_type_AndroidWidgetImageView.getHeight());
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      label312:
      E();
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(m);
      this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(m);
      localObject1 = a(this.jdField_j_of_type_Boolean);
      label342:
      if (n >= 12) {
        return;
      }
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[n] != null)
      {
        ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[n].findViewById(2131371362)).setImageResource(localObject1[n]);
        localObject2 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[n].findViewById(2131371363);
        if (this.jdField_j_of_type_Boolean) {
          break label530;
        }
        ((TextView)localObject2).setTextColor(m);
      }
    }
    for (;;)
    {
      n += 1;
      break label342;
      bool = false;
      break;
      label421:
      m = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131494163);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843345);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843328);
      break label134;
      label458:
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(m);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(m);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(m);
      localObject1 = a(2130843331, false);
      if (localObject1 == null) {
        break label312;
      }
      ((StateListDrawable)localObject1).setBounds(0, 0, this.jdField_d_of_type_AndroidWidgetImageView.getWidth(), this.jdField_d_of_type_AndroidWidgetImageView.getHeight());
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break label312;
      label530:
      ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131494161));
    }
  }
  
  public void r()
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int m = this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a();
    String str;
    if (m == 1) {
      if (this.jdField_j_of_type_Boolean)
      {
        localObject1 = ((Resources)localObject2).getDrawable(2130843329);
        str = ((Resources)localObject2).getString(2131436811);
        localObject2 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      if (localObject2 != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      }
      if (localObject1 != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      }
      return;
      localObject1 = ((Resources)localObject2).getDrawable(2130843328);
      break;
      if (m == 2)
      {
        if (this.jdField_j_of_type_Boolean) {}
        for (localObject1 = ((Resources)localObject2).getDrawable(2130843323);; localObject1 = ((Resources)localObject2).getDrawable(2130843328))
        {
          str = ((Resources)localObject2).getString(2131436811);
          localObject2 = localObject1;
          localObject1 = str;
          break;
        }
      }
      localObject2 = null;
    }
  }
  
  public void s()
  {
    boolean bool = UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.a(bool);
    }
    if (!bool) {
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_plate_of_king", 0).getBoolean("plate_of_king_red_dot_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false)) && (this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.a(true);
    }
  }
  
  protected void t()
  {
    try
    {
      a(1, this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void u()
  {
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_f_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void v()
  {
    try
    {
      a(2, this.jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void w()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(String.valueOf(1000017));
      if (!((BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(111)).a())
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo1.red_type.set(9);
        localRedTypeInfo1.red_content.set("-1");
        localRedTypeInfo1.red_desc.set("");
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo2.red_type.set(0);
        localAppInfo.iNewFlag.set(1);
        localAppInfo.red_display_info.red_type_info.clear();
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo1);
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo2);
      }
      for (;;)
      {
        a(8, localAppInfo);
        return;
        localAppInfo.iNewFlag.set(0);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void x()
  {
    try
    {
      a(5, this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1))
      {
        WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
        if (localWebProcessManager != null) {
          localWebProcessManager.e();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void y()
  {
    try
    {
      a(0, this.jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1))
      {
        WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12);
        if (localWebProcessManager != null) {
          localWebProcessManager.e();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void z()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).getString("VIPCenter_url_key", "http://h5.vip.qq.com/p/mc/vipcenterv5?_bid=193&_wvSb=1&asyncMode=3&phpsonic=1");
    ThreadManager.getSubThreadHandler().post(new tpy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe
 * JD-Core Version:    0.7.0.1
 */
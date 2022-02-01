package com.tencent.mobileqq.activity;

import MQQ.MenumItem;
import MQQ.PayRuleCfg;
import QQService.EVIPSPEC;
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
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.annotation.RequiresApi;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.av.utils.UITools;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.activity.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.activity.weather.WeatherManager;
import com.tencent.mobileqq.activity.weather.WeatherManager.WeatherUpdaterListener;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt;
import com.tencent.mobileqq.apollo.api.ISettingMeApolloViewController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.LoveZoneDynamicRedPointPathInterface;
import com.tencent.mobileqq.app.LoveZoneInfoObserver;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.VipInfoObserver;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocUserConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocUserConfigProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.doc.TencentDocUtils;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.loverzone.LoveZoneTabRedDotView;
import com.tencent.mobileqq.loverzone.LoverZoneUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.redtouch.DefaultRedPointPrePostHandler;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg;
import com.tencent.mobileqq.nearby.redtouch.Util;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.manager.AnonymousRedPointUtils;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils.NamePlateVipTpye;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils.VipIconTouchListener;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.VipGrayConfigHelper.VipGrayConfigListener;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.qqvaluecard.QQValueInfoManage;
import com.tencent.mobileqq.vas.qqvaluecard.bean.QQValueInfoItem;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.vas.quickupdate.QQLevelIconCallback;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.QQSettingConfigManager;
import com.tencent.mobileqq.vip.QVipConfigManager;
import com.tencent.mobileqq.webview.api.ISonicPreloaderService;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.data.SonicParserInfo;
import com.tencent.mobileqq.webview.data.SonicPreloadData;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.FixedBounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QVipMedalView;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager.IClearMemoryListener;
import com.tencent.qqperf.tools.SceneTracker;
import com.tencent.util.BitmapUtil;
import com.tencent.util.DrawerCoverUtil;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.UpSideDownDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.ilive.manager.IliveDbManager;
import cooperation.ilive.manager.IliveRedManager;
import cooperation.ilive.share.IliveShareHelper;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import cooperation.vip.tianshu.TianShuManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.libpag.PAGView;
import protocol.KQQConfig.UpgradeInfo;
import tencent.im.oidb.redInfo.RedInfo;

public class QQSettingMe
  implements View.OnClickListener, View.OnTouchListener
{
  public static int a;
  private static List<String> jdField_a_of_type_JavaUtilList;
  private static List<String> jdField_b_of_type_JavaUtilList;
  protected long a;
  private PayRuleCfg jdField_a_of_type_MQQPayRuleCfg;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QQSettingMe.10(this);
  Handler jdField_a_of_type_AndroidOsHandler = new QQSettingMe.5(this, Looper.getMainLooper());
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new QQSettingMe.24(this);
  protected View a;
  public ViewGroup a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private WeatherManager.WeatherUpdaterListener jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener;
  private WeatherManager jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager;
  private ISettingMeApolloViewController jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController;
  protected BaseActivity a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new QQSettingMe.35(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new QQSettingMe.34(this);
  private FrameHelperActivity jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new QQSettingMe.38(this);
  private LoveZoneInfoObserver jdField_a_of_type_ComTencentMobileqqAppLoveZoneInfoObserver = new QQSettingMe.40(this);
  protected QQAppInterface a;
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new QQSettingMe.41(this);
  private VipInfoObserver jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver = new QQSettingMe.31(this);
  protected DynamicAvatarView a;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new QQSettingMe.37(this);
  public Card a;
  private MedalList jdField_a_of_type_ComTencentMobileqqDataMedalList;
  private PreloadProcHitSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("QQSetting_me", "com.tencent.mobileqq:tool");
  private LoveZoneTabRedDotView jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new QQSettingMe.30(this);
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new QQSettingMe.36(this);
  private IActionListener jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener;
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  NightModeLogic.NightModeCallback jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback = new QQSettingMe.39(this);
  private NightModeLogic jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic;
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  private BusinessInfoCheckUpdate.RedTypeInfo jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo;
  protected RedTouch a;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  private VipGrayConfigHelper.VipGrayConfigListener jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper$VipGrayConfigListener = new QQSettingMe.42(this);
  protected AvatarLayout a;
  protected QQValuePagView a;
  private final QQSettingConfigManager jdField_a_of_type_ComTencentMobileqqVipQQSettingConfigManager = QQSettingConfigManager.a();
  protected AnimationTextView a;
  protected FixedBounceScrollView a;
  protected QVipMedalView a;
  protected RedDotTextView a;
  public MemoryClearManager.IClearMemoryListener a;
  private String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private ConcurrentHashMap<String, UpSideDownDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private redInfo.RedInfo jdField_a_of_type_TencentImOidbRedInfo$RedInfo;
  protected boolean a;
  int[] jdField_a_of_type_ArrayOfInt = { 2131699160, 2131699141, 2131699138, 2131699170, 2131699139, 2131699189, 2131699119, 2131699128, 2131699165, 2131699130, 2131699140, 2131699111, 2131699127, 2131699112, 2131699136 };
  protected View[] a;
  protected RedTouchTextView[] a;
  protected RedTouch[] a;
  protected int b;
  long jdField_b_of_type_Long = 0L;
  Handler jdField_b_of_type_AndroidOsHandler = new QQSettingMe.11(this, Looper.getMainLooper());
  protected View b;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  protected ImageView b;
  protected LinearLayout b;
  protected TextView b;
  BusinessInfoCheckUpdate.AppInfo jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  protected RedTouch b;
  private String jdField_b_of_type_JavaLangString;
  protected boolean b;
  int jdField_c_of_type_Int;
  protected View c;
  protected ImageView c;
  protected LinearLayout c;
  protected TextView c;
  BusinessInfoCheckUpdate.AppInfo jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  protected RedTouch c;
  private String jdField_c_of_type_JavaLangString = "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1";
  protected boolean c;
  private final int jdField_d_of_type_Int = 4;
  protected View d;
  protected ImageView d;
  protected TextView d;
  BusinessInfoCheckUpdate.AppInfo jdField_d_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  protected RedTouch d;
  private String jdField_d_of_type_JavaLangString = null;
  public boolean d;
  private final int jdField_e_of_type_Int = 1;
  protected View e;
  protected ImageView e;
  protected TextView e;
  BusinessInfoCheckUpdate.AppInfo jdField_e_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  protected RedTouch e;
  private String jdField_e_of_type_JavaLangString = "";
  protected boolean e;
  private int jdField_f_of_type_Int;
  protected View f;
  protected ImageView f;
  protected TextView f;
  BusinessInfoCheckUpdate.AppInfo jdField_f_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  protected RedTouch f;
  private final String jdField_f_of_type_JavaLangString = "data_item_id";
  protected boolean f;
  private int jdField_g_of_type_Int;
  protected View g;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  protected TextView g;
  BusinessInfoCheckUpdate.AppInfo jdField_g_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  protected RedTouch g;
  private final String jdField_g_of_type_JavaLangString = "data_enter_title";
  protected boolean g;
  private int jdField_h_of_type_Int = -1;
  protected View h;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  protected TextView h;
  BusinessInfoCheckUpdate.AppInfo jdField_h_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  protected RedTouch h;
  private final String jdField_h_of_type_JavaLangString = "data_enter_icon";
  private boolean jdField_h_of_type_Boolean;
  private final int jdField_i_of_type_Int = 0;
  protected View i;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  BusinessInfoCheckUpdate.AppInfo jdField_i_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = null;
  protected RedTouch i;
  private boolean jdField_i_of_type_Boolean;
  private final int jdField_j_of_type_Int = 1;
  protected View j;
  BusinessInfoCheckUpdate.AppInfo jdField_j_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = null;
  protected RedTouch j;
  private boolean jdField_j_of_type_Boolean = false;
  private final int jdField_k_of_type_Int = 2;
  private View jdField_k_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_k_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  private boolean jdField_k_of_type_Boolean = false;
  private final int jdField_l_of_type_Int = 3;
  private View jdField_l_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_l_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  private boolean jdField_l_of_type_Boolean = true;
  private View jdField_m_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_m_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  private boolean jdField_m_of_type_Boolean;
  private View jdField_n_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_n_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  private View jdField_o_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_o_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  BusinessInfoCheckUpdate.AppInfo p;
  BusinessInfoCheckUpdate.AppInfo q;
  BusinessInfoCheckUpdate.AppInfo r;
  
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
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager$IClearMemoryListener = new QQSettingMe.ClearDynamicDrawable(this);
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->QQSettingMe construct!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = paramFrameHelperActivity;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561609, null));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368315);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131710731));
    }
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368281));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363511));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368329);
    this.jdField_m_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378200);
    paramFrameHelperActivity = paramQQAppInterface.getCurrentAccountUin();
    int i1;
    Object localObject1;
    boolean bool;
    label1893:
    int[] arrayOfInt;
    label1921:
    int i3;
    int i2;
    if ((paramFrameHelperActivity == null) || (paramFrameHelperActivity.length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130840452);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131372289).setOnClickListener(this);
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298524);
      this.jdField_f_of_type_Int = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0F) - i1 - ScreenUtil.dip2px(45.0F));
      this.jdField_g_of_type_Int = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0F) - i1 - ScreenUtil.dip2px(20.0F));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372288));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_f_of_type_Int);
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramFrameHelperActivity);
      if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim()))) {
        this.jdField_a_of_type_JavaLangString = paramFrameHelperActivity;
      }
      this.jdField_g_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramBaseActivity, this.jdField_m_of_type_AndroidViewView).b(53).a();
      this.jdField_f_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramBaseActivity, this.jdField_b_of_type_AndroidViewView).b(53).a();
      U();
      this.jdField_b_of_type_AndroidViewView.setVisibility(VasFaceManager.a(paramFrameHelperActivity, paramQQAppInterface));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372856));
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView = ((QVipMedalView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374838));
      this.jdField_i_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView).b(53).a(12).e(1).d(1).a();
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374724);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374725);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373453));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381702));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381710));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374887));
      this.jdField_h_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView).b(53).a(12).e(0).d(1).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText("");
      this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363413));
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363411));
      this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375127));
      this.jdField_d_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramBaseActivity, this.jdField_g_of_type_AndroidWidgetImageView).b(53).a(20).e(1).d(1).a();
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367456));
      this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView = ((QQValuePagView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372696));
      this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.setOnClickListener(this);
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        paramBaseActivity.topMargin = (ScreenUtil.dip2px(29.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "Change mBackWrapper topMargin=" + paramBaseActivity.topMargin);
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramBaseActivity);
      }
      this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_h_of_type_AndroidWidgetImageView.setOnTouchListener(this);
      this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetImageView.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372100));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378171));
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBaseActivity.topMargin = (ScreenUtil.dip2px(35.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBaseActivity);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378170)).b(53).a();
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378164);
      this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_e_of_type_AndroidViewView).c(10).b(19).a();
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView.setOnTouchListener(UITools.a);
      this.jdField_l_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373542);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView = ((FixedBounceScrollView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371396));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setDamping(2.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setBounceDelay(600L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setmCustomTopFadingEdgeScale(0.675F);
      i1 = (int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131298517);
      paramBaseActivity = this.jdField_a_of_type_AndroidViewViewGroup.getResources();
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[15];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch = new RedTouch[15];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView = new RedTouchTextView[15];
      paramFrameHelperActivity = new int[15];
      FrameHelperActivity tmp1745_1744 = paramFrameHelperActivity;
      tmp1745_1744[0] = 2131374844;
      FrameHelperActivity tmp1751_1745 = tmp1745_1744;
      tmp1751_1745[1] = 2131372114;
      FrameHelperActivity tmp1757_1751 = tmp1751_1745;
      tmp1757_1751[2] = 2131372111;
      FrameHelperActivity tmp1763_1757 = tmp1757_1751;
      tmp1763_1757[3] = 2131372102;
      FrameHelperActivity tmp1769_1763 = tmp1763_1757;
      tmp1769_1763[4] = 2131372105;
      FrameHelperActivity tmp1775_1769 = tmp1769_1763;
      tmp1775_1769[5] = 2131372110;
      FrameHelperActivity tmp1781_1775 = tmp1775_1769;
      tmp1781_1775[6] = 2131372079;
      FrameHelperActivity tmp1788_1781 = tmp1781_1775;
      tmp1788_1781[7] = 2131372106;
      FrameHelperActivity tmp1795_1788 = tmp1788_1781;
      tmp1795_1788[8] = 2131372112;
      FrameHelperActivity tmp1802_1795 = tmp1795_1788;
      tmp1802_1795[9] = 2131372113;
      FrameHelperActivity tmp1809_1802 = tmp1802_1795;
      tmp1809_1802[10] = 2131372107;
      FrameHelperActivity tmp1816_1809 = tmp1809_1802;
      tmp1816_1809[11] = 2131364328;
      FrameHelperActivity tmp1823_1816 = tmp1816_1809;
      tmp1823_1816[12] = 2131372080;
      FrameHelperActivity tmp1830_1823 = tmp1823_1816;
      tmp1830_1823[13] = 2131365492;
      FrameHelperActivity tmp1837_1830 = tmp1830_1823;
      tmp1837_1830[14] = 2131372078;
      tmp1837_1830;
      Object localObject2 = ThemeUtil.getCurrentThemeInfo();
      localObject1 = ((Bundle)localObject2).getString("themeId");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"1000".equals(localObject1)) && (!"1103".equals(localObject1))) {
        break label2655;
      }
      bool = true;
      this.jdField_l_of_type_Boolean = bool;
      if (!this.jdField_l_of_type_Boolean) {
        break label2661;
      }
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166477);
      arrayOfInt = a(this.jdField_l_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe_init, color=" + i1 + ",themeid = " + (String)localObject1 + ", enginePath=" + ((Bundle)localObject2).getString("themePath"));
      }
      i3 = ScreenUtil.dip2px(2.0F);
      localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371396);
      this.jdField_k_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.findViewById(2131371397);
      i2 = 0;
      label2028:
      if (i2 >= 15) {
        break label2694;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2] = ((View)localObject2).findViewById(paramFrameHelperActivity[i2]);
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setFocusable(true);
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(0);
      if (paramFrameHelperActivity[i2] == 2131372112) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      if (paramFrameHelperActivity[i2] == 2131372113) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      if (paramFrameHelperActivity[i2] == 2131364328) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      if (paramFrameHelperActivity[i2] == 2131374844)
      {
        QzoneConfig.getInstance();
        if (!QzoneConfig.isQQCircleShowDrawTabEntrance()) {
          break label2679;
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramFrameHelperActivity[i2] == 2131372106)
      {
        this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView = ((LoveZoneTabRedDotView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369373));
        if (this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView != null) {
          this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.setVisibility(8);
        }
      }
      if (paramFrameHelperActivity[i2] == 2131372078)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ArrayOfAndroidViewView[i2]);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setOnClickListener(this);
      Object localObject3 = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369364);
      ((ImageView)localObject3).setImageResource(arrayOfInt[i2]);
      Object localObject4 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369437);
      ((TextView)localObject4).setText(this.jdField_a_of_type_ArrayOfInt[i2]);
      if (!this.jdField_l_of_type_Boolean) {
        ((TextView)localObject4).setTextColor(i1);
      }
      if (paramFrameHelperActivity[i2] == 2131372107) {
        a((ImageView)localObject3, (TextView)localObject4);
      }
      if ((SimpleUIUtil.a()) && ("2920".equals(ThemeUtil.getCurrentThemeId()))) {
        ((TextView)localObject4).setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166476));
      }
      localObject3 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369416);
      ((ThemeLabelTextView)localObject3).setSupportMaskView(true);
      ((TextView)localObject3).setVisibility(0);
      AccessibilityUtil.a(this.jdField_a_of_type_ArrayOfAndroidViewView[i2], paramBaseActivity.getString(this.jdField_a_of_type_ArrayOfInt[i2]), Button.class.getName());
      localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369364);
      ((View)localObject3).setPadding(i3, i3, i3, i3);
      localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject4).leftMargin -= i3;
      localObject4 = (RedTouchTextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369437);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((RedTouchTextView)localObject4).getLayoutParams();
      localLayoutParams.leftMargin -= i3;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[i2] = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject3).b(53).a();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[i2] = localObject4;
      if (paramFrameHelperActivity[i2] == 2131372078) {
        this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch = this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[i2];
      }
      i2 += 1;
      break label2028;
      localObject1 = paramQQAppInterface.getBitmapFromCache(paramQQAppInterface.getFaceBitmapCacheKey(1, paramFrameHelperActivity, (byte)3, 0, 100, true));
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageBitmap((Bitmap)localObject1);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130840452);
      break;
      label2655:
      bool = false;
      break label1893;
      label2661:
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166478);
      break label1921;
      label2679:
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
    }
    label2694:
    ak();
    z();
    ac();
    ae();
    I();
    af();
    ag();
    b(false);
    this.jdField_i_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369628);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || ("1000".equals(localObject1)))
    {
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363801);
      this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377918);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this);
      AccessibilityUtil.a(this.jdField_g_of_type_AndroidViewView, HardCodeUtil.a(2131710725), Button.class.getName());
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377920));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374786));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377919));
      this.jdField_j_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView).a();
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372303);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this);
      AccessibilityUtil.a(this.jdField_f_of_type_AndroidViewView, HardCodeUtil.a(2131710708), Button.class.getName());
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372305));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372304));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131369352));
      this.jdField_n_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370682);
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380637));
      this.jdField_n_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_n_of_type_AndroidViewView.setOnTouchListener(this);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131381835));
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379018));
      this.jdField_j_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379002);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379020));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379019));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131381830));
      if (!SimpleUIUtil.a())
      {
        this.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        this.jdField_f_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        this.jdField_g_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      if (!ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, false, null)) {
        break label3385;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-6709582);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController = ((ISettingMeApolloViewController)QRoute.api(ISettingMeApolloViewController.class));
      this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.init(this, this.jdField_a_of_type_AndroidViewViewGroup);
      if (!this.jdField_l_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130846397);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846372);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i1);
      }
      return;
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      break;
      label3385:
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166477));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166477));
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166477));
    }
  }
  
  private void H()
  {
    if (this.jdField_m_of_type_Boolean) {
      return;
    }
    this.jdField_k_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new QQSettingMe.3(this));
  }
  
  private void I()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    if (localView != null)
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4);
      if (!((SharedPreferences)localObject).getBoolean("drawerEnable", false)) {
        break label211;
      }
      String str = ((SharedPreferences)localObject).getString("drawerText", "");
      this.jdField_e_of_type_JavaLangString = ((SharedPreferences)localObject).getString("drawerTextID", "");
      localObject = ((SharedPreferences)localObject).getString("drawerUrl", "");
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break label198;
      }
      localView.setVisibility(0);
      if (LocaleManager.a())
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqVipQQSettingConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 32))
        {
          localObject = (TextView)localView.findViewById(2131369437);
          ((TextView)localObject).setText(str);
          ((TextView)localObject).setContentDescription(str);
          localObject = a(this.jdField_l_of_type_Boolean);
          ((ImageView)localView.findViewById(2131369364)).setImageResource(localObject[13]);
        }
        AccessibilityUtil.a(localView, str, Button.class.getName());
      }
    }
    return;
    label198:
    localView.setVisibility(8);
    this.jdField_e_of_type_JavaLangString = "";
    return;
    label211:
    localView.setVisibility(8);
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void J()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[11];
    if (localView != null)
    {
      if (TencentDocUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("call_tim_config_pre" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("call_tim_config_title", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131699111));
        localView.setVisibility(0);
        ((TextView)localView.findViewById(2131369437)).setText(str);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800887D", "0X800887D", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  private void K()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.recoverApollo();
    }
  }
  
  private void L()
  {
    Object localObject1;
    int i2;
    int i1;
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch.length > 0))
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch;
      i2 = localObject1.length;
      i1 = 0;
      while (i1 < i2)
      {
        localObject1[i1].d();
        i1 += 1;
      }
    }
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView.length > 0))
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView;
      i2 = localObject1.length;
      i1 = 0;
      while (i1 < i2)
      {
        Object localObject2 = localObject1[i1];
        BusinessInfoCheckUpdate.AppInfo localAppInfo = localObject2.a();
        if ((localAppInfo != null) && (localAppInfo.exposure_max.get() <= 0))
        {
          localAppInfo.iNewFlag.set(0);
          localObject2.setAppInfo(localAppInfo);
        }
        i1 += 1;
      }
    }
  }
  
  private void M()
  {
    this.jdField_f_of_type_AndroidWidgetImageView.post(new QQSettingMe.9(this));
  }
  
  private void N()
  {
    Object localObject4 = null;
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "preloadSonicSession");
    }
    if (!((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).enablePreloadSonic()) {
      return;
    }
    long l1 = System.currentTimeMillis();
    if ((this.jdField_k_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_k_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0)) {}
    for (Object localObject1 = new SonicParserInfo(this.jdField_k_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.buffer.get(), 0L, 0);; localObject1 = null)
    {
      if ((this.jdField_d_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_d_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0)) {}
      for (Object localObject2 = new SonicParserInfo(this.jdField_d_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.buffer.get(), this.jdField_d_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.preload_ts.get(), 1000);; localObject2 = null)
      {
        Object localObject3 = localObject4;
        if (this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo != null)
        {
          localObject3 = localObject4;
          if (this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0) {
            localObject3 = new SonicParserInfo(this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.buffer.get(), this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.preload_ts.get(), 1001);
          }
        }
        localObject4 = ((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).getSonicPreloadDataList((SonicParserInfo)localObject1);
        SparseArray localSparseArray1 = ((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).getSonicPreloadDataList((SonicParserInfo)localObject2);
        SparseArray localSparseArray2 = ((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).getSonicPreloadDataList((SonicParserInfo)localObject3);
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        if ((localObject4 != null) && (((SparseArray)localObject4).size() > 0))
        {
          int i1 = 0;
          if (i1 < ((SparseArray)localObject4).size())
          {
            SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject4).valueAt(i1);
            if (1000 == localSonicPreloadData.jdField_a_of_type_Int)
            {
              localSonicPreloadData.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
              ((ArrayList)localObject1).add(localSonicPreloadData);
            }
            for (;;)
            {
              i1 += 1;
              break;
              if (1001 == localSonicPreloadData.jdField_a_of_type_Int)
              {
                localSonicPreloadData.jdField_a_of_type_JavaLangString = IndividuationUrlHelper.a("personalIndex");
                ((ArrayList)localObject1).add(localSonicPreloadData);
              }
            }
          }
        }
        if ((localSparseArray1 != null) && (localSparseArray1.size() > 0))
        {
          localObject4 = (SonicPreloadData)localSparseArray1.valueAt(0);
          ((SonicPreloadData)localObject4).jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          ((ArrayList)localObject2).add(localObject4);
        }
        if ((localSparseArray2 != null) && (localSparseArray2.size() > 0))
        {
          localObject4 = (SonicPreloadData)localSparseArray2.valueAt(0);
          ((SonicPreloadData)localObject4).jdField_a_of_type_JavaLangString = IndividuationUrlHelper.a("personalIndex");
          ((ArrayList)localObject3).add(localObject4);
        }
        localObject4 = (IWebProcessManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
        if (((IWebProcessManagerService)localObject4).preloadSonicSession((ArrayList)localObject1)) {
          ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(String.valueOf("200010.200012"));
        }
        if (((IWebProcessManagerService)localObject4).preloadSonicSession((ArrayList)localObject2)) {
          this.jdField_d_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.preload_ts.set(System.currentTimeMillis());
        }
        if (((IWebProcessManagerService)localObject4).preloadSonicSession((ArrayList)localObject3)) {
          this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.preload_ts.set(System.currentTimeMillis());
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQSettingRedesign", 2, "preloadSonicSession parse cost: " + (System.currentTimeMillis() - l1));
        return;
      }
    }
  }
  
  private void O()
  {
    if (this.r != null) {
      this.jdField_d_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.r);
    }
  }
  
  private void P()
  {
    if (this.p != null) {
      this.jdField_h_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.p);
    }
  }
  
  private void Q()
  {
    if (this.jdField_i_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
      this.jdField_i_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.q);
    }
  }
  
  private void R()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
      try
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[12] != null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[12].setIsNeedRedImageAutoFix(true);
        }
        a(12, this.jdField_o_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (RedTouch.a(this.jdField_o_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo)) {}
        for (localObject = "1";; localObject = "2")
        {
          ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800B1F6", "0X800B1F6", 0, 0, (String)localObject, "", "", "");
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("QQSettingRedesign", 1, "updateShoppingRedTouch error: " + localException.getMessage());
        localException.printStackTrace();
      }
    }
  }
  
  private void S()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_d_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_e_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_f_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_g_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_h_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_l_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_m_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_n_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_o_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    a(this.p);
    a(this.q);
    a(this.r);
  }
  
  private void T()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_i_of_type_AndroidWidgetTextView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateTalent error");
      }
      return;
    }
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard.allowPeopleSee) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays < 10000L) {
        str1 = String.format(HardCodeUtil.a(2131699145), new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
    }
    for (String str2 = String.format(HardCodeUtil.a(2131699187), new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });; str2 = HardCodeUtil.a(2131699146))
    {
      this.jdField_i_of_type_AndroidWidgetTextView.setText(str1);
      AccessibilityUtil.a(this.jdField_n_of_type_AndroidViewView, str2, Button.class.getName());
      return;
      str1 = "9999+";
      break;
      str1 = HardCodeUtil.a(2131699186);
    }
  }
  
  private void U()
  {
    if (SimpleUIUtil.a())
    {
      this.jdField_m_of_type_AndroidViewView.setVisibility(0);
      this.jdField_g_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(0);
      this.jdField_f_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(4);
      this.jdField_e_of_type_ComTencentMobileqqTianshuUiRedTouch = this.jdField_g_of_type_ComTencentMobileqqTianshuUiRedTouch;
      return;
    }
    this.jdField_m_of_type_AndroidViewView.setVisibility(8);
    this.jdField_g_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(4);
    this.jdField_f_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(0);
    this.jdField_e_of_type_ComTencentMobileqqTianshuUiRedTouch = this.jdField_f_of_type_ComTencentMobileqqTianshuUiRedTouch;
  }
  
  private void V()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "jumpToProfile");
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    localAllInOne.jdField_g_of_type_Int = 1;
    localAllInOne.jdField_h_of_type_Int = 8;
    ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localAllInOne, 1009);
    AnonymousRedPointUtils.checkToCleanSettingMeRedPointGuide(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void W()
  {
    Object localObject2 = IliveRedManager.parseShopRedBuffer(this.jdField_o_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    String str = IliveDbManager.getIliveDrawerData("drawer_shop_jump_scheme");
    Object localObject1 = IliveRedManager.getDrawerLiveReportStr2(this.jdField_o_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    IliveRedManager.sRedShoppingStr2 = (String)localObject1;
    IliveShareHelper.reportAction("qq_live", "chouti_page", "zhibo", "zhibo_button", "4", 102, IliveShareHelper.getFollowInfo("", (String)localObject1, "", "", ""));
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (RedTouch.a(this.jdField_o_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo))
    {
      localObject1 = "1";
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800B1F7", "0X800B1F7", 0, 0, (String)localObject1, "", "", "");
      if ((this.jdField_o_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_o_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0)) {
        ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo(101100, 31);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQSettingRedesign", 2, "Ilive start jump shop , url = " + str);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label251;
      }
    }
    label251:
    for (localObject1 = str;; localObject1 = localObject2)
    {
      if (!URLUtil.isNetworkUrl((String)localObject1)) {
        break label256;
      }
      localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_vip");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
      return;
      localObject1 = "2";
      break;
    }
    label256:
    localObject1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject1);
    if (localObject1 != null)
    {
      ((JumpAction)localObject1).a();
      return;
    }
    ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, IliveDbManager.getILiveEnterInfo(1));
  }
  
  private void X()
  {
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_f_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    DrawerFrame.jdField_a_of_type_Int = 0;
    if (AppSetting.jdField_d_of_type_Boolean) {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label77;
      }
    }
    label77:
    for (String str = "关闭夜间模式";; str = "夜间模式 ")
    {
      AccessibilityUtil.a(this.jdField_f_of_type_AndroidViewView, str, Button.class.getName());
      QCircleUtils.a().downloadSkinPackage("https://downv6.qq.com/video_story/qcircle/skin/darkmode-v85501.skin");
      return;
    }
  }
  
  private void Y()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo != null) {
        this.jdField_e_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo);
      }
      for (;;)
      {
        boolean bool = this.jdField_k_of_type_Boolean;
        this.jdField_k_of_type_Boolean = this.jdField_e_of_type_ComTencentMobileqqTianshuUiRedTouch.c();
        if (QLog.isColorLevel()) {
          QLog.i("LocalRedTouchManager", 2, "updateHeadIcon, old:" + bool + " new:" + this.jdField_k_of_type_Boolean + ",profileRedTypeInfo = " + this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo + ",profileAppinfo = " + this.jdField_j_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
        }
        if (bool != this.jdField_k_of_type_Boolean) {
          x();
        }
        return;
        this.jdField_e_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.jdField_j_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
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
  
  private void Z()
  {
    Object localObject2 = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    Object localObject1 = ((LocalRedTouchManager)localObject2).a(-4);
    if ((((LocalRedTouchManager)localObject2).a((RedTouchItem)localObject1, true)) && (((RedTouchItem)localObject1).count > 0) && (this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo != null))
    {
      QLog.d("QQSettingRedesign", 1, new Object[] { "updateProfileBubbleMsgView ", Integer.valueOf(((RedTouchItem)localObject1).count) });
      long l1;
      ImageView localImageView;
      TextView localTextView;
      View localView;
      if (this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.has())
      {
        l1 = this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.get();
        localObject2 = this.jdField_l_of_type_AndroidViewView.findViewById(2131372712);
        localImageView = (ImageView)this.jdField_l_of_type_AndroidViewView.findViewById(2131368281);
        localTextView = (TextView)this.jdField_l_of_type_AndroidViewView.findViewById(2131371908);
        localView = this.jdField_l_of_type_AndroidViewView.findViewById(2131369415);
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label309;
        }
        ((View)localObject2).setBackgroundResource(2130846376);
      }
      for (;;)
      {
        a(l1, localImageView);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131699129, new Object[] { Integer.valueOf(((RedTouchItem)localObject1).count) });
        if (!((String)localObject1).equalsIgnoreCase(localTextView.getText().toString())) {
          localTextView.setText((CharSequence)localObject1);
        }
        ((View)localObject2).setContentDescription((CharSequence)localObject1);
        ((View)localObject2).setOnTouchListener(new QQSettingMe.20(this, localImageView, localTextView, localView));
        ((View)localObject2).setOnClickListener(this);
        this.jdField_l_of_type_AndroidViewView.setVisibility(0);
        aa();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97E", "0X800A97E", 0, 0, "0", "0", "", "");
        return;
        l1 = 0L;
        break;
        label309:
        ((View)localObject2).setBackgroundResource(2130846375);
      }
    }
    this.jdField_l_of_type_AndroidViewView.setVisibility(8);
    ((ImageView)this.jdField_l_of_type_AndroidViewView.findViewById(2131368281)).setImageDrawable(null);
  }
  
  private String a(String paramString, int paramInt, RedTouch paramRedTouch)
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    if ((paramRedTouch != null) && (paramRedTouch.c())) {
      return MobileReportManager.getNewReportInfo(paramString, localIRedTouchManager.getAppInfoByPath(String.valueOf(paramInt)));
    }
    return MobileReportManager.getNewDefaultReportInfo(paramString, "outside", "1");
  }
  
  private String a(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    paramString = new StringBuffer(paramString);
    if ((paramAppInfo != null) && (paramAppInfo.buffer != null))
    {
      paramAppInfo = paramAppInfo.buffer.get();
      if (TextUtils.isEmpty(paramAppInfo)) {}
    }
    try
    {
      paramAppInfo = new JSONObject(paramAppInfo);
      String str = paramAppInfo.getString("trace_id");
      int i1 = paramAppInfo.getInt("trace_num");
      int i2 = paramAppInfo.getInt("ad_id");
      paramString.append("&").append("trace_id=").append(str);
      paramString.append("&").append("trace_num=").append(i1);
      paramString.append("&").append("trace_detail=").append(URLEncoder.encode("trace_detail_ad_id=" + i2, "UTF-8"));
      return paramString.toString();
    }
    catch (Exception paramAppInfo)
    {
      for (;;)
      {
        QLog.d("QQSettingRedesign", 1, "getMyMiniGameJumpUrl failed", paramAppInfo);
      }
    }
  }
  
  private void a(int paramInt, MenumItem paramMenumItem)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    Bundle localBundle = new Bundle();
    if ((paramMenumItem == null) || ((TextUtils.isEmpty(paramMenumItem.title)) && (TextUtils.isEmpty(paramMenumItem.icon))))
    {
      localBundle.putString("data_enter_title", null);
      localBundle.putString("data_enter_icon", null);
    }
    for (;;)
    {
      localBundle.putInt("data_item_id", paramInt);
      localMessage.setData(localBundle);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
      localBundle.putString("data_enter_title", paramMenumItem.title);
      localBundle.putString("data_enter_icon", paramMenumItem.icon);
    }
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
        int i2 = ((ArrayList)localObject2).size() - 1;
        int i1 = 0;
        if (i2 >= 0)
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((ArrayList)localObject2).get(i2);
          int i3 = localRedTypeInfo.red_type.get();
          if (i3 == 0)
          {
            ((ArrayList)localObject2).remove(i2);
            i1 = 1;
          }
          for (;;)
          {
            i2 -= 1;
            break;
            if ((i3 == 3) && (RedTouchTextView.a(localRedTypeInfo, localAppInfo)))
            {
              RedTouchTextView.setImageRedNotShowRedPoint(localRedTypeInfo, paramAppInfo);
              i1 = 1;
            }
            else
            {
              if ((i3 != 15) || (!RedTouchTextView.b(localRedTypeInfo, localAppInfo))) {
                break label311;
              }
              RedTouchTextView.setDiffImageRedNotShowRedPoint(localRedTypeInfo, paramAppInfo);
              i1 = 1;
            }
          }
        }
        if (((ArrayList)localObject2).size() < 2) {
          ((ArrayList)localObject2).clear();
        }
        localAppInfo.red_display_info.red_type_info.set((List)localObject2);
        paramAppInfo = new ArrayList();
        if (i1 != 0)
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
      this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[paramInt].a((BusinessInfoCheckUpdate.AppInfo)localObject1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[paramInt].setAppInfo(paramAppInfo);
      return;
      label311:
      break;
      localAppInfo = null;
      paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject1;
      localObject1 = localAppInfo;
    }
  }
  
  private void a(long paramLong, ImageView paramImageView)
  {
    if (paramLong == 111L)
    {
      paramImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846041));
      return;
    }
    Object localObject = ImageUtil.a(true);
    localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramLong + "", 4, (Drawable)localObject, (Drawable)localObject);
    Drawable localDrawable = paramImageView.getDrawable();
    if ((localDrawable != null) && (localDrawable != localObject) && ((localDrawable instanceof FaceDrawable))) {
      ((FaceDrawable)localDrawable).cancel();
    }
    paramImageView.setImageDrawable((Drawable)localObject);
  }
  
  private void a(@Nonnull Context paramContext)
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getString("sp_vip_medal_lvl_jump_url", null);
    if (a(str2)) {
      return;
    }
    String str3 = a(str2, 101400, this.jdField_h_of_type_ComTencentMobileqqTianshuUiRedTouch);
    String str1 = str2;
    if (!TextUtils.isEmpty(str3)) {
      str1 = str2 + str3;
    }
    VipUtils.a(0, "mvip.pingtai.mobileqq.androidziliaoka.fromdrawer", "geren", str1, paramContext);
    ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo(101400, 31);
    int i1 = VipInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B179", "0X800B179", 0, 0, String.valueOf(i1), "", "", "");
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = paramMessage.getData();
    if (paramMessage == null) {}
    Object localObject1;
    do
    {
      return;
      i2 = paramMessage.getInt("data_item_id");
      localObject1 = paramMessage.getString("data_enter_title");
      paramMessage = paramMessage.getString("data_enter_icon");
      localObject3 = a(this.jdField_l_of_type_Boolean);
    } while ((i2 < 0) || (i2 >= this.jdField_a_of_type_ArrayOfAndroidViewView.length) || (i2 >= localObject3.length) || (i2 >= this.jdField_a_of_type_ArrayOfInt.length));
    Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[i2];
    int i1 = localObject3[i2];
    int i2 = this.jdField_a_of_type_ArrayOfInt[i2];
    Object localObject3 = (TextView)((View)localObject2).findViewById(2131369437);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((TextView)localObject3).setText(ChatRoomUtil.a((String)localObject1, 16));
    }
    for (;;)
    {
      localObject1 = (ImageView)((View)localObject2).findViewById(2131369364);
      if (!TextUtils.isEmpty(paramMessage)) {
        break;
      }
      ((ImageView)localObject1).setImageResource(i1);
      return;
      ((TextView)localObject3).setText(i2);
    }
    if ((!TextUtils.isEmpty(paramMessage)) && (!QQTheme.e()))
    {
      localObject2 = URLDrawableHelper.TRANSPARENT;
      paramMessage = VasApngUtil.getApngURLDrawable(paramMessage, new int[] { 1 }, (Drawable)localObject2, null, null);
      if (paramMessage != null)
      {
        ((ImageView)localObject1).setImageDrawable(paramMessage);
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          ((ImageView)localObject1).setColorFilter(1996488704);
        }
      }
      else
      {
        ((ImageView)localObject1).setImageResource(i1);
      }
    }
    ((ImageView)localObject1).setColorFilter(0);
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof QQValuePagView)) {
      ((QQValuePagView)paramView).a("setting", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
  }
  
  private void a(ImageView paramImageView, TextView paramTextView)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    try
    {
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameIconUrl", "");
      if ((!TextUtils.isEmpty(str)) && (ThemeUtil.isDefaultTheme())) {
        paramImageView.setImageDrawable(URLDrawable.getDrawable(new URL(str), localURLDrawableOptions));
      }
      paramImageView = QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameNameText", "");
      if (!TextUtils.isEmpty(paramImageView)) {
        paramTextView.setText(paramImageView);
      }
      return;
    }
    catch (Exception paramImageView)
    {
      QLog.e("QQSettingRedesign", 1, "set URL Drawable failed ", paramImageView);
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0))
    {
      int i1 = paramAppInfo.uiAppId.get();
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(i1)))
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(i1));
        ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo(i1, 30);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, "", "", "");
  }
  
  private void a(List<BusinessInfoCheckUpdate.AppInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i1 = 0;
      if (i1 < paramList.size())
      {
        Object localObject = (BusinessInfoCheckUpdate.AppInfo)paramList.get(i1);
        if ((localObject == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject).red_display_info == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject).red_display_info.red_type_info == null)) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject = ((BusinessInfoCheckUpdate.AppInfo)localObject).red_display_info.red_type_info.get();
          int i2 = ((List)localObject).size() - 1;
          while (i2 >= 0)
          {
            BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject).get(i2);
            if (localRedTypeInfo.red_type.get() == 15) {
              VasApngUtil.getApngURLDrawable(localRedTypeInfo.red_content.get(), VasApngUtil.VIP_APNG_TAGS, URLDrawableHelper.TRANSPARENT);
            }
            i2 -= 1;
          }
        }
      }
      paramList.clear();
    }
  }
  
  public static boolean a(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(new Date(System.currentTimeMillis()));
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(new Date(paramLong));
    return (localCalendar2.get(1) == localCalendar1.get(1)) && (localCalendar2.get(6) - localCalendar1.get(6) == 0);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      V();
      QLog.e("QVipSettingMe.", 1, "medal list have no jump url ,so use the default");
      return true;
    }
    return false;
  }
  
  private void aa()
  {
    RedTouchItem localRedTouchItem = ((LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(10028);
    if ((localRedTouchItem != null) && (localRedTouchItem.count > 0) && (localRedTouchItem.unReadFlag))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "checkAndReportAnonymousAnswerMsgExpose");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B47F", "0X800B47F", 0, 0, "", "", "", "");
    }
  }
  
  private void ab()
  {
    RedTouchItem localRedTouchItem = ((LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(10028);
    if ((localRedTouchItem != null) && (localRedTouchItem.count > 0) && (localRedTouchItem.unReadFlag))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "checkAndReportAnonymousAnswerMsgClick");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B480", "0X800B480", 0, 0, "", "", "", "");
    }
  }
  
  private void ac()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[7];
    String str = QzoneConfig.getInstance().getConfig("sweet_miniapp", "entrance", "0");
    if (localObject != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(str)) || ("0".equals(str))) {
        break label116;
      }
      ((View)localObject).setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      if (localObject != null)
      {
        if (((SharedPreferences)localObject).getInt("love_state_for_current_uin" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0) != 1) {
          break label111;
        }
        ao();
      }
    }
    return;
    label111:
    ap();
    return;
    label116:
    ((View)localObject).setVisibility(8);
    ap();
  }
  
  private void ad()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[7];
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      localObject = LoverZoneUtils.a(this.jdField_m_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      int i1 = LoverZoneUtils.a((String)localObject);
      LoverZoneUtils.a("10", i1 + "", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.setRedDotData(this.jdField_m_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        a("0x800AAFA", "1");
      }
    }
    else
    {
      return;
    }
    a("0x800AAFA", "2");
    a(7, this.jdField_m_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
  }
  
  private void ae()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameEnable", 1) == 0) {
        localView.setVisibility(8);
      }
    }
    else {
      return;
    }
    localView.setVisibility(0);
  }
  
  private void af()
  {
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.21(this));
  }
  
  private void ag()
  {
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.22(this));
  }
  
  private void ah()
  {
    int i1 = 0;
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {}
    try
    {
      a(10, this.jdField_n_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (RedTouch.a(this.jdField_n_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo)) {
        i1 = 1;
      }
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800ACDC", "0X800ACDC", 0, i1, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void ai()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_MQQPayRuleCfg.iconText)) || (TextUtils.isEmpty(this.jdField_a_of_type_MQQPayRuleCfg.iconUrl))) {
      QLog.e("QQSettingRedesign", 1, "showPayButton: iconText or iconUrl is empty");
    }
    Object localObject1;
    do
    {
      return;
      TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131369416);
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      QQSettingMe.23 local23 = new QQSettingMe.23(this, localTextView);
      try
      {
        localObject1 = new URL(this.jdField_a_of_type_MQQPayRuleCfg.iconUrl);
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("key_density", 320);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mUseApngImage = true;
        localURLDrawableOptions.mExtraInfo = localObject2;
        localObject2 = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
        localObject1 = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions);
        localTextView.setBackgroundDrawable((Drawable)localObject1);
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          local23.onLoadSuccessed((URLDrawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler showPayButton: ", localMalformedURLException);
        return;
      }
      localMalformedURLException.setText("");
      ((URLDrawable)localObject1).setURLDrawableListener(local23);
    } while (((URLDrawable)localObject1).getStatus() != 2);
    ((URLDrawable)localObject1).restartDownload();
  }
  
  private void aj()
  {
    try
    {
      a(13, this.jdField_l_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void ak()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipQQSettingConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4)) {}
    for (;;)
    {
      return;
      try
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vipTitleSpFile", 0).getString("vipTitleSpKey_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + LocaleManager.a(), "");
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "updateVipText sp vipText = " + str);
        }
        if (!TextUtils.isEmpty(str))
        {
          TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131369437);
          if (localTextView != null)
          {
            localTextView.setText(str);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("QQSettingRedesign", 1, "updateVipText exception, e = ", localException);
      }
    }
  }
  
  private void al()
  {
    ThreadManager.getUIHandler().post(new QQSettingMe.32(this));
  }
  
  private void am()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.post(new QQSettingMe.33(this));
  }
  
  private void an()
  {
    Object localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
    String str1 = ((SharedPreferences)localObject1).getString("drawer_cur_temp", null);
    Object localObject3 = ((SharedPreferences)localObject1).getString("drawer_cur_city", null);
    int i1 = ((SharedPreferences)localObject1).getInt("drawer_cur_adcode", 0);
    String str2 = ((SharedPreferences)localObject1).getString("drawer_cur_code", null);
    boolean bool = ((SharedPreferences)localObject1).getBoolean("drawer_show_flag", false);
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateWeatherView cur_temp:" + str1 + ",cur_areainfo" + (String)localObject3 + ",cur_adcode:" + i1 + ",o_wea_code" + str2 + ",show_flag:" + bool);
    }
    if (!bool)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(str1);
    localObject1 = ((String)localObject3).split("-");
    TextView localTextView = this.jdField_h_of_type_AndroidWidgetTextView;
    if (localObject1.length == 2) {
      localObject1 = localObject1[1];
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject1);
      try
      {
        localObject1 = URLEncoder.encode((String)localObject3, "utf-8").toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("&city=").append((String)localObject1).append("&adcode=").append(i1);
        this.jdField_h_of_type_AndroidWidgetTextView.setTag(((StringBuilder)localObject3).toString());
        this.jdField_g_of_type_AndroidWidgetTextView.setText("o");
        d(str1);
        e(str2);
        return;
        localObject1 = localObject1[0];
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = localObject3;
        }
      }
    }
  }
  
  private void ao()
  {
    Object localObject = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    if (localObject != null)
    {
      localObject = ((IRedTouchManager)localObject).getRegisterInterfaces().iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface localDynamicRedPointPathInterface = (BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)((Iterator)localObject).next();
        if ((localDynamicRedPointPathInterface instanceof LoveZoneDynamicRedPointPathInterface)) {
          ((LoveZoneDynamicRedPointPathInterface)localDynamicRedPointPathInterface).a();
        }
      }
    }
  }
  
  private void ap()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Iterator localIterator = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getRegisterInterfaces().iterator();
      while (localIterator.hasNext())
      {
        BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface localDynamicRedPointPathInterface = (BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)localIterator.next();
        if ((localDynamicRedPointPathInterface instanceof LoveZoneDynamicRedPointPathInterface)) {
          ((LoveZoneDynamicRedPointPathInterface)localDynamicRedPointPathInterface).b();
        }
      }
    }
  }
  
  private void aq()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    if ((localView != null) && (localView.getVisibility() == 0)) {
      ThreadManager.getSubThreadHandler().post(new QQSettingMe.43(this));
    }
  }
  
  private void ar()
  {
    Object localObject = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem1 = ((LocalRedTouchManager)localObject).a(10015);
    RedTouchItem localRedTouchItem2 = ((LocalRedTouchManager)localObject).a(10016);
    int i1;
    if ((Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && ((((LocalRedTouchManager)localObject).a(localRedTouchItem1, false)) || (((LocalRedTouchManager)localObject).a(localRedTouchItem2, false))))
    {
      i1 = 1;
      if (i1 != 0)
      {
        i1 = ((LocalRedTouchManager)localObject).a();
        localObject = null;
        switch (i1)
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
      i1 = 0;
      break;
      localObject = "0X8007392";
      continue;
      localObject = "0X8007397";
      continue;
      localObject = "0X80073B8";
    }
  }
  
  private void as()
  {
    TencentDocUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void b(Message paramMessage)
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    Object localObject2 = paramMessage.getData();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = ((Bundle)localObject2).getString("enter_title");
    paramMessage = ((Bundle)localObject2).getString("enter_icon");
    if (!((Bundle)localObject2).getBoolean("is_visible", false))
    {
      localView.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipQQSettingConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2))
    {
      localView.setVisibility(0);
      return;
    }
    localObject2 = (TextView)localView.findViewById(2131369437);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject1 = (ImageView)localView.findViewById(2131369364);
      if (TextUtils.isEmpty(paramMessage)) {
        break label187;
      }
      localObject2 = URLDrawableHelper.TRANSPARENT;
      paramMessage = VasApngUtil.getApngURLDrawable(paramMessage, new int[] { 1 }, (Drawable)localObject2, null, null);
      if (paramMessage == null) {
        break label177;
      }
      ((ImageView)localObject1).post(new QQSettingMe.6(this, (ImageView)localObject1, paramMessage));
    }
    for (;;)
    {
      localView.setVisibility(0);
      return;
      ((TextView)localObject2).setText(2131699127);
      break;
      label177:
      ((ImageView)localObject1).setImageResource(2130846398);
      continue;
      label187:
      ((ImageView)localObject1).setImageResource(2130846398);
    }
  }
  
  private void b(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMedalList == null) {}
    for (Object localObject1 = null; a((String)localObject1); localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMedalList.jumpUrl) {
      return;
    }
    String str = a((String)localObject1, 101500, this.jdField_i_of_type_ComTencentMobileqqTianshuUiRedTouch);
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty(str)) {
      localObject2 = (String)localObject1 + str;
    }
    localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", (String)localObject2);
    ((Intent)localObject1).putExtra("hide_operation_bar", true);
    ((Intent)localObject1).putExtra("hide_more_button", true);
    ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
    ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo(101500, 31);
    int i1 = VipInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
    if ((paramView instanceof QVipMedalView))
    {
      if (!AnimatorHandler.playing) {
        break label235;
      }
      ((QVipMedalView)paramView).a("0X800B2B5", i1);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X800A127", 0, 0, String.valueOf(i1), "", "", "");
      return;
      label235:
      ((QVipMedalView)paramView).a("0X800B2B4", i1);
    }
  }
  
  private boolean b()
  {
    int i1 = 0;
    if (this.jdField_k_of_type_AndroidViewView.getHeight() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "tryAdjustCuKingCard() mMenuPanel.getHeight() == 0");
      }
      return false;
    }
    View localView = this.jdField_k_of_type_AndroidViewView.findViewById(2131365492);
    Object localObject1 = new int[2];
    localView.getLocationOnScreen((int[])localObject1);
    localObject1 = new Rect(localObject1[0], localObject1[1], localObject1[0] + localView.getWidth(), localObject1[1] + localView.getHeight());
    Object localObject2 = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.getLocationOnScreen((int[])localObject2);
    localObject2 = new Rect(localObject2[0], localObject2[1], localObject2[0] + this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.getWidth(), localObject2[1] + this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.getHeight());
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "tryAdjustCuKingCard() containerBounds = " + localObject2 + ", cardBounds = " + localObject1);
    }
    if ((!((Rect)localObject2).contains((Rect)localObject1)) || (localView.getHeight() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "tryAdjustCuKingCard() should adjust cuKingCard position");
      }
      localObject1 = (ViewGroup)localView.getParent();
      if (i1 >= ((ViewGroup)localObject1).getChildCount()) {
        break label278;
      }
      if (((ViewGroup)localObject1).getChildAt(i1).getId() != 2131372106) {
        break label271;
      }
    }
    for (;;)
    {
      if (i1 + 1 <= ((ViewGroup)localObject1).getChildCount())
      {
        ((ViewGroup)localObject1).removeView(localView);
        ((ViewGroup)localObject1).addView(localView, i1 + 1);
      }
      this.jdField_m_of_type_Boolean = true;
      return true;
      label271:
      i1 += 1;
      break;
      label278:
      i1 = -1;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    ThreadManager.post(new QQSettingMe.12(this), 5, null, false);
  }
  
  private boolean c()
  {
    LocalRedTouchManager localLocalRedTouchManager = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    localLocalRedTouchManager.a(100601, false);
    localLocalRedTouchManager.a(10016, false);
    localLocalRedTouchManager.a(10015, false);
    if ((localLocalRedTouchManager.a(localLocalRedTouchManager.a(-7), true)) || (AnonymousRedPointUtils.showSettingMeRedPointGuide(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {}
    for (;;)
    {
      try
      {
        ar();
        this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo.red_type.set(0);
        this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo.red_content.set("");
        this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo.red_desc.set("");
        bool = true;
      }
      catch (Exception localException)
      {
        bool = true;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateProfileRedPoint needShow = " + bool);
      }
      return bool;
      this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo = null;
      boolean bool = false;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Int != 1) {}
    while ((this.jdField_h_of_type_Int == -1) || (this.jdField_d_of_type_JavaLangString == null)) {
      return;
    }
    TianShuReportData localTianShuReportData = new TianShuReportData();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localTianShuReportData.jdField_b_of_type_JavaLangString = (str + "_" + l1);
    localTianShuReportData.jdField_a_of_type_Int = 1;
    if (paramBoolean) {}
    for (int i1 = 102;; i1 = 101)
    {
      localTianShuReportData.jdField_d_of_type_Int = i1;
      localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.103";
      localTianShuReportData.jdField_f_of_type_JavaLangString = "tianshu.103";
      localTianShuReportData.jdField_g_of_type_JavaLangString = String.valueOf(this.jdField_h_of_type_Int);
      localTianShuReportData.jdField_e_of_type_Int = 1;
      localTianShuReportData.l = this.jdField_d_of_type_JavaLangString;
      localTianShuReportData.jdField_a_of_type_Long = l1;
      TianShuManager.getInstance().report(localTianShuReportData);
      return;
    }
  }
  
  private boolean d()
  {
    ProfileCardUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = ((LocalRedTouchManager)localObject).a(-4);
    if ((((LocalRedTouchManager)localObject).a(localRedTouchItem, true)) && (localRedTouchItem.count > 0))
    {
      try
      {
        localObject = FileUtils.a(DefaultRedPointPrePostHandler.a(-4));
        if ((localObject instanceof RedTouchItemExtMsg))
        {
          localObject = (RedTouchItemExtMsg)localObject;
          this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo = new redInfo.RedInfo();
          this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.mergeFrom(((RedTouchItemExtMsg)localObject).bytesData);
        }
        if (!QLog.isColorLevel()) {
          break label155;
        }
        QLog.d("QQSettingRedesign", 2, "updateProfileBubbleMsgInfo red point: " + localRedTouchItem.redtouchType);
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQSettingRedesign", 2, localException.getMessage(), localException);
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo = null;
      return false;
    }
    label155:
    return true;
  }
  
  private boolean e()
  {
    if (!this.jdField_d_of_type_Boolean) {
      return true;
    }
    long l1 = QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_last_request_success_time", 0L);
    int i1 = QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_vip_sync_freq", 0);
    if (NetConnInfoCenter.getServerTime() - l1 <= i1)
    {
      QLog.e("QVipSettingMe.QQSettingRedesign", 1, "ignore the vip info request because current time=" + NetConnInfoCenter.getServerTime() + " requestTimestamp=" + l1 + " and updateFrequency=" + i1);
      return false;
    }
    QLog.e("QVipSettingMe.QQSettingRedesign", 1, "need the vip info request because current time=" + NetConnInfoCenter.getServerTime() + " requestTimestamp=" + l1 + " and updateFrequency=" + i1);
    return true;
  }
  
  private void f(String paramString)
  {
    Object localObject1;
    if (this.jdField_b_of_type_AndroidViewViewGroup == null)
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.jdField_k_of_type_AndroidViewView.getLayoutParams();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.removeView(this.jdField_k_of_type_AndroidViewView);
      FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      Object localObject2 = new ViewGroup.MarginLayoutParams(-1, -2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject2);
      localFrameLayout.addView(this.jdField_k_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject1);
      localObject2 = new FrameLayout(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      localFrameLayout.addView((View)localObject2, new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams)localObject1));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localObject2);
    }
    if (this.jdField_o_of_type_AndroidViewView == null)
    {
      localObject1 = new TextView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      ((TextView)localObject1).setText(paramString);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(1, 12.0F);
      ((TextView)localObject1).setGravity(17);
      ((TextView)localObject1).setBackgroundResource(2130844828);
      paramString = new FrameLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1, paramString);
      this.jdField_o_of_type_AndroidViewView = ((View)localObject1);
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private boolean f()
  {
    return 1 == QzoneConfig.getInstance().getConfig("tianshu_feature", "red_touch_dismiss", 1);
  }
  
  private void g(String paramString)
  {
    boolean bool1;
    boolean bool2;
    label91:
    int i2;
    label104:
    long l1;
    int i4;
    boolean bool3;
    Object localObject;
    int i1;
    String str;
    int i3;
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView == null))
      {
        if (!QLog.isColorLevel()) {
          break label1672;
        }
        QLog.d("QQSettingRedesign", 2, "updateQQLevelVipView card == null");
        return;
      }
      localSpannableStringBuilder = new SpannableStringBuilder();
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bSuperVipOpen != 1) {
        break label1049;
      }
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bQQVipOpen != 1) {
        break label1055;
      }
      bool2 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bBigClubVipOpen != 1) {
        break label1061;
      }
      i2 = 1;
      l1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.uCurMulType;
      i4 = this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQVipLevel;
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + i4 + ",QQLevel=" + this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel + ",curMulType =" + this.jdField_a_of_type_ComTencentMobileqqDataCard.uCurMulType);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      bool3 = VipUtils.VipIconUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType);
      localObject = null;
      i1 = 0;
      if (!bool3) {
        break label1673;
      }
      str = VipUtils.VipIconUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, VipUtils.VipIconUtils.NamePlateVipTpye.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType), VipUtils.VipIconUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataCard.grayNameplateFlag));
      i3 = VipUtils.VipIconUtils.a(VipUtils.VipIconUtils.NamePlateVipTpye.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType));
      i1 = i3;
      localObject = str;
      if (!VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType)) {
        break label1673;
      }
      VipUtils.VipIconUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateExtId, 1);
      i1 = i3;
      localObject = str;
    }
    catch (Throwable paramString)
    {
      SpannableStringBuilder localSpannableStringBuilder;
      Resources localResources;
      paramString.printStackTrace();
      return;
    }
    if (bool2)
    {
      i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_QQVIP);
      paramString = VipUtils.VipIconUtils.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
      i1 = 2130847430;
      i2 = 1;
      localObject = null;
    }
    for (;;)
    {
      label407:
      i3 = i1;
      str = paramString;
      if (!bool3)
      {
        i3 = i1;
        str = paramString;
        if (i2 == 0)
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label1463;
          }
          QLog.e("QQSettingRedesign", 1, (String)localObject);
          label445:
          if (!bool1) {
            break label1494;
          }
          i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_SUPERVIP);
          str = VipUtils.VipIconUtils.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
          i3 = 2130847431;
        }
      }
      label499:
      if ((str != null) && (i3 != 0))
      {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), this.jdField_b_of_type_AndroidWidgetImageView, str, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(i3));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131716636));
        this.jdField_b_of_type_AndroidWidgetImageView.setFocusableInTouchMode(true);
        paramString = VipUtils.VipIconUtils.VipIconTouchListener.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, "VIA_SETTINGME");
        paramString.a();
        this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(paramString);
        am();
        if (VipGrayConfigHelper.a().a(bool1, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingLoginTime)) {
          localSpannableStringBuilder.append(QQSettingUtil.a(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView, localResources, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDanDisplatSwitch));
        }
        i2 = 0;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMedalList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() <= 0)) {
          break label1591;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setData(this.jdField_a_of_type_ComTencentMobileqqDataMedalList);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
          break label1568;
        }
        this.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#7bffffff"));
        i2 = this.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() * UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 21.0F) - UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 6.0F);
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.", 1, "width =" + i2 + "update medal:" + this.jdField_a_of_type_ComTencentMobileqqDataMedalList.convert());
        }
        i1 = i2;
        if (!this.jdField_e_of_type_Boolean)
        {
          this.jdField_e_of_type_Boolean = true;
          i1 = VipInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X800A126", 0, 0, String.valueOf(i1), "", "", "");
          i1 = i2;
        }
        localSpannableStringBuilder.append(QQSettingUtil.a(localResources, this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType, this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel, a(i1)));
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setContentDescription("等级：" + this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
        a(bool1, bool2, i4);
        if (!AppSetting.jdField_d_of_type_Boolean) {
          break label1672;
        }
        paramString = new StringBuilder();
        paramString.append(this.jdField_a_of_type_JavaLangString);
        if (!bool1) {
          break label1641;
        }
        paramString.append("你是尊贵的超级会员");
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel > 0) {
          paramString.append(" 等级").append(this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
        }
        this.jdField_a_of_type_AndroidViewView.setContentDescription(paramString.toString());
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label91;
        i2 = 0;
        break label104;
        str = "occur error: curMulType=" + l1 + " but bQQVipOpen is false";
        i2 = 0;
        paramString = (String)localObject;
        localObject = str;
        continue;
      }
      label1049:
      label1055:
      label1061:
      label1591:
      for (;;)
      {
        label596:
        label736:
        label882:
        if (bool1)
        {
          i2 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_SUPERVIP);
          if ((i2 & 0xF) != 1) {
            break label1726;
          }
          i1 = 1;
          label1140:
          paramString = VipUtils.VipIconUtils.a((i2 & 0xF) << 8 | i2 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
          if (i1 == 0) {
            break label1731;
          }
          i1 = 2130847431;
          break label1718;
        }
        label1003:
        str = "occur error: curMulType=" + l1 + " but bSuperVipOpen is false";
        label1107:
        i2 = 0;
        paramString = (String)localObject;
        localObject = str;
        break label407;
        label1463:
        label1494:
        label1641:
        do
        {
          if (l1 == 6L)
          {
            if (i2 != 0)
            {
              i2 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, false);
              if (i2 >> 8 == 3)
              {
                if ((i2 & 0xF) == 1)
                {
                  i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
                  localObject = VipUtils.VipIconUtils.a((i1 & 0xF) << 8 | i1 >> 8, this.jdField_a_of_type_ComTencentMobileqqDataCard.iBigClubVipLevel, this.jdField_a_of_type_ComTencentMobileqqDataCard.lBigClubTemplateId);
                }
                for (i2 = 2130847431;; i2 = 2130847429)
                {
                  VipUtils.VipIconUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateExtId, 1);
                  i1 = 1;
                  paramString = null;
                  break;
                  i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
                  localObject = VipUtils.VipIconUtils.a((i1 & 0xF) << 8 | i1 >> 8, this.jdField_a_of_type_ComTencentMobileqqDataCard.iBigClubVipLevel, this.jdField_a_of_type_ComTencentMobileqqDataCard.lBigClubTemplateId);
                }
              }
              paramString = "occur error: curMulType=" + l1 + " but bBigClubVipOpen userStatus=" + i2;
              i3 = 0;
              i2 = i1;
              i1 = i3;
              break label1738;
            }
            str = "occur error: curMulType=" + l1 + " but bBigClubVipOpen is false";
            i2 = 0;
            paramString = (String)localObject;
            localObject = str;
            break label407;
            QLog.e("QQSettingRedesign", 1, "it have not handle curMulType=" + l1);
            break label445;
            i3 = i1;
            str = paramString;
            if (!bool2) {
              break label499;
            }
            i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_QQVIP);
            str = VipUtils.VipIconUtils.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
            i3 = 2130847430;
            break label499;
            this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(null);
            break label596;
            this.jdField_c_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166481));
            break label736;
            this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setVisibility(8);
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            i1 = i2;
            if (!QLog.isColorLevel()) {
              break label882;
            }
            QLog.d("QVipSettingMe.", 1, "medal list is null");
            i1 = i2;
            break label882;
            if (!bool2) {
              break label1003;
            }
            paramString.append("你是尊贵的会员");
            break label1003;
          }
          do
          {
            i2 = 0;
            str = null;
            paramString = (String)localObject;
            localObject = str;
            break;
            return;
          } while (bool3);
          if ((l1 == 1L) || (l1 == 2L)) {
            break;
          }
          if (l1 == 3L) {
            break label1107;
          }
        } while (l1 != 4L);
      }
      for (;;)
      {
        label1568:
        label1718:
        i2 = 1;
        label1672:
        label1673:
        localObject = null;
        break;
        label1726:
        i1 = 0;
        break label1140;
        label1731:
        i1 = 2130847429;
      }
      label1738:
      str = paramString;
      paramString = (String)localObject;
      i3 = i1;
      i1 = i2;
      localObject = str;
      i2 = i3;
    }
  }
  
  private void h(String paramString)
  {
    long l1 = System.currentTimeMillis();
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath(String.valueOf(100400));
    Object localObject1;
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.exposure_max.get() >= 0)) {
      localObject1 = localAppInfo.buffer.get();
    }
    for (;;)
    {
      Object localObject2;
      int i2;
      try
      {
        localObject1 = new JSONObject((String)localObject1).optString("_jump_url");
        localObject2 = new StringBuilder();
        i2 = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label479;
        }
        localObject1 = this.jdField_c_of_type_JavaLangString;
        i1 = 1;
        if (((String)localObject1).contains("?")) {
          break label439;
        }
        ((StringBuilder)localObject2).append((String)localObject1 + "?platform=1&type=20001&networkInfo=" + i2);
        localObject2 = localIRedTouchManager.wrapperRedTouchUrl(((StringBuilder)localObject2).toString(), localAppInfo);
        if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() == 0) || (localAppInfo.type.get() != 0)) {
          break label473;
        }
        bool = true;
        localObject1 = localObject2;
        if (paramString != null)
        {
          localObject1 = localObject2;
          if (i1 != 0) {
            localObject1 = (String)localObject2 + paramString;
          }
        }
        paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        paramString.putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
        paramString.putExtra("startOpenPageTime", l1);
        paramString.putExtra("portraitOnly", true);
        paramString.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramString.putExtra("hide_operation_bar", true);
        paramString.putExtra("hide_more_button", true);
        paramString.putExtra("has_red_dot", bool);
        paramString.putExtra("leftBtnText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131689502));
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject1, 256L, paramString, false, -1);
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler gotoOpenCenterBrowser");
        localIRedTouchManager.reportLevelOneRedInfo(100400, 31);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("QQSettingRedesign", 2, "parse json exception " + localException);
      }
      String str = "";
      continue;
      label439:
      ((StringBuilder)localObject2).append(str + "&platform=1&type=20001&networkInfo=" + i2);
      continue;
      label473:
      boolean bool = false;
      continue;
      label479:
      int i1 = 0;
    }
  }
  
  private void i(String paramString)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  protected void A()
  {
    try
    {
      a(4, this.jdField_e_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void B()
  {
    C();
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void C()
  {
    localObject8 = null;
    Object localObject14 = null;
    String str1 = null;
    localObject13 = null;
    Object localObject15 = null;
    Object localObject16 = null;
    localObject1 = HardCodeUtil.a(2131710735);
    i1 = 0;
    int i3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298524);
    int i4 = ScreenUtil.SCREEN_WIDTH;
    int i5 = ScreenUtil.dip2px(65.0F);
    int i6 = ScreenUtil.dip2px(15.0F);
    int i7 = this.jdField_g_of_type_AndroidWidgetImageView.getWidth();
    localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    l1 = localSharedPreferences.getLong("sign_in_time_stamp", 0L);
    str2 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_info", "");
    try
    {
      localObject2 = new JSONObject(str2);
      this.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("type");
      i2 = ((JSONObject)localObject2).optInt("day");
      i1 = i2;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject10;
        label739:
        label1017:
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "doUpdateDailySignInItemView JSONException, json = " + str2);
        }
        localJSONException1.printStackTrace();
        continue;
        localObject3 = null;
        i1 = 0;
        Object localObject5 = localObject1;
        localObject9 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_operation" + "10", "");
        localObject5 = localObject1;
        Object localObject7 = localObject1;
        Object localObject4;
        if (!TextUtils.isEmpty((CharSequence)localObject9))
        {
          localObject5 = localObject1;
          localObject3 = new JSONObject((String)localObject9);
          i1 = 0;
          continue;
          localObject3 = null;
          i1 = 0;
          localObject5 = localObject1;
          localObject9 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_operation" + "10", "");
          localObject5 = localObject1;
          localObject7 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject9))
          {
            localObject5 = localObject1;
            localObject3 = new JSONObject((String)localObject9);
            i1 = 0;
            continue;
            localObject5 = localObject1;
            localObject1 = HardCodeUtil.a(2131710728);
            localObject5 = localObject1;
            localObject3 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_operation" + "41", "");
            localObject5 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject5 = localObject1;
              localObject3 = new JSONObject((String)localObject3);
              localObject5 = localObject1;
              l1 = ((JSONObject)localObject3).optInt("start_time");
              localObject5 = localObject1;
              l2 = ((JSONObject)localObject3).optInt("end_time");
              i1 = 1;
              localObject5 = localObject1;
              if (System.currentTimeMillis() > l1 * 1000L)
              {
                localObject5 = localObject1;
                localObject7 = localObject1;
                if (System.currentTimeMillis() < l2 * 1000L) {}
              }
              else
              {
                localObject3 = null;
                i1 = 0;
                localObject5 = localObject1;
                localObject9 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_operation" + "40", "");
                localObject5 = localObject1;
                localObject7 = localObject1;
                if (!TextUtils.isEmpty((CharSequence)localObject9))
                {
                  localObject5 = localObject1;
                  localObject3 = new JSONObject((String)localObject9);
                  i1 = 0;
                }
              }
            }
            else
            {
              localObject3 = null;
              i1 = 0;
              localObject5 = localObject1;
              localObject9 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_operation" + "40", "");
              localObject5 = localObject1;
              localObject7 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject9))
              {
                localObject5 = localObject1;
                localObject3 = new JSONObject((String)localObject9);
                i1 = 0;
                continue;
                localObject1 = "";
                localObject3 = "";
                continue;
                if (QLog.isColorLevel()) {
                  QLog.i("DailySignIn", 2, "doUpdateDailySignInItemView JSONException, json = " + str2);
                }
                ((JSONException)localObject5).printStackTrace();
                localObject5 = localObject8;
                continue;
                if (this.jdField_b_of_type_Int == 1)
                {
                  localObject1 = HardCodeUtil.a(2131710735);
                  localObject5 = null;
                  localObject4 = null;
                  continue;
                }
                if (this.jdField_b_of_type_Int == 4)
                {
                  localObject1 = HardCodeUtil.a(2131710728);
                  localObject5 = null;
                  localObject4 = null;
                  continue;
                  localObject5 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject10);
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.i("DailySignIn", 2, "use default icon");
                  }
                  if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null))
                  {
                    localObject5 = null;
                    try
                    {
                      localObject4 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130846402);
                      if (localObject4 == null) {
                        break label2085;
                      }
                      localObject7 = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), BitmapUtil.a((Bitmap)localObject4));
                    }
                    catch (OutOfMemoryError localOutOfMemoryError)
                    {
                      for (;;)
                      {
                        localObject4 = localObject5;
                        if (QLog.isColorLevel())
                        {
                          QLog.d("QQSettingRedesign", 2, localOutOfMemoryError, new Object[0]);
                          localObject4 = localObject5;
                        }
                      }
                    }
                    i("0X800ACFB");
                    if (QLog.isColorLevel()) {
                      QLog.i("DailySignIn", 2, "use unsigned wording");
                    }
                    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
                    ((TextView)localObject5).setText((CharSequence)localObject1);
                    continue;
                    QLog.e("QQSettingRedesign", 1, "mSignInWord===null");
                    continue;
                  }
                }
              }
            }
          }
        }
        continue;
        int i2 = i1;
      }
    }
    if (!a(l1 * 1000L))
    {
      this.jdField_b_of_type_Int = 1;
      i2 = 0;
      if (LocaleManager.a() != 1033)
      {
        localObject5 = localObject1;
        try
        {
          this.jdField_h_of_type_Int = -1;
          localObject5 = localObject1;
          this.jdField_d_of_type_JavaLangString = null;
          localObject5 = localObject1;
          if (this.jdField_b_of_type_Int == 1)
          {
            localObject5 = localObject1;
            localObject2 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_operation" + "11", "");
            localObject5 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject5 = localObject1;
              localObject2 = new JSONObject((String)localObject2);
              localObject5 = localObject1;
              l1 = ((JSONObject)localObject2).optInt("start_time");
              localObject5 = localObject1;
              l2 = ((JSONObject)localObject2).optInt("end_time");
              localObject5 = localObject1;
              if (System.currentTimeMillis() > l1 * 1000L)
              {
                localObject5 = localObject1;
                if (System.currentTimeMillis() < l2 * 1000L)
                {
                  localObject5 = localObject1;
                  this.jdField_h_of_type_Int = ((JSONObject)localObject2).optInt("id", -1);
                  localObject5 = localObject1;
                  this.jdField_d_of_type_JavaLangString = ((JSONObject)localObject2).optString("trace_info", null);
                  i1 = 1;
                  localObject9 = localObject1;
                  localObject12 = localObject16;
                  localObject11 = str1;
                  if (localObject2 != null)
                  {
                    localObject10 = localObject1;
                    localObject8 = localObject15;
                    localObject7 = localObject14;
                  }
                }
              }
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          long l2;
          Object localObject9;
          Object localObject12;
          Object localObject11;
          Object localObject3;
          localObject1 = localObject5;
          localObject5 = localJSONException2;
          localObject4 = localObject8;
          localObject8 = localObject13;
        }
      }
      try
      {
        l1 = ((JSONObject)localObject2).optInt("start_time");
        localObject10 = localObject1;
        localObject8 = localObject15;
        localObject7 = localObject14;
        l2 = ((JSONObject)localObject2).optInt("end_time");
        localObject9 = localObject1;
        localObject12 = localObject16;
        localObject11 = str1;
        localObject10 = localObject1;
        localObject8 = localObject15;
        localObject7 = localObject14;
        if (System.currentTimeMillis() > l1 * 1000L)
        {
          localObject9 = localObject1;
          localObject12 = localObject16;
          localObject11 = str1;
          localObject10 = localObject1;
          localObject8 = localObject15;
          localObject7 = localObject14;
          if (System.currentTimeMillis() < l2 * 1000L)
          {
            localObject10 = localObject1;
            localObject8 = localObject15;
            localObject7 = localObject14;
            localObject5 = ((JSONObject)localObject2).optString("template_text");
            localObject10 = localObject5;
            localObject8 = localObject15;
            localObject7 = localObject14;
            str1 = ((JSONObject)localObject2).optString("bytes_url");
            if (i1 == 0) {
              break label1752;
            }
            localObject10 = localObject5;
            localObject8 = localObject15;
            localObject7 = localObject14;
            localObject1 = ((JSONObject)localObject2).optString("bytes_icon_url");
          }
        }
      }
      catch (JSONException localJSONException3)
      {
        for (;;)
        {
          localObject1 = localOutOfMemoryError;
          localObject4 = localObject7;
        }
      }
      try
      {
        localObject7 = ((JSONObject)localObject2).optString("bytes_icon_custom_url");
        localObject2 = localObject1;
        localObject1 = localObject7;
        localObject9 = localObject5;
        localObject12 = localObject1;
        localObject11 = localObject2;
        localObject10 = localObject5;
        localObject8 = localObject1;
        localObject7 = localObject2;
        if (!TextUtils.isEmpty(str1))
        {
          localObject10 = localObject5;
          localObject8 = localObject1;
          localObject7 = localObject2;
          localSharedPreferences.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_jump_url", str1).commit();
          localObject11 = localObject2;
          localObject12 = localObject1;
          localObject9 = localObject5;
        }
        localObject5 = localObject12;
        localObject2 = localObject11;
        localObject1 = localObject9;
      }
      catch (JSONException localJSONException4)
      {
        localObject4 = localObject1;
        localObject1 = localJSONException3;
        localObject8 = localObject13;
        Object localObject6 = localJSONException4;
        break label1781;
        break label1017;
        localObject4 = null;
        localObject6 = null;
        break label739;
        localObject1 = localJSONException4;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DailySignIn", 2, "doUpdateDailySignInItemView type=" + this.jdField_b_of_type_Int + " iconUrl=" + (String)localObject2 + " wording=" + (String)localObject1 + " day=" + i2 + "covericonUrl" + (String)localObject5);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846402);
      localObject8 = (URLImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378169);
      localObject9 = (ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131369364);
      if (!QQTheme.e()) {
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
        {
          localObject10 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject10).mFailedDrawable = ((Drawable)localObject7);
          ((URLDrawable.URLDrawableOptions)localObject10).mLoadingDrawable = ((Drawable)localObject7);
          ((URLDrawable.URLDrawableOptions)localObject10).mRequestHeight = 56;
          ((URLDrawable.URLDrawableOptions)localObject10).mRequestWidth = 56;
          if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((DrawerCoverUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) || (!this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())))
          {
            localObject5 = URLDrawable.getDrawable((String)localObject5, (URLDrawable.URLDrawableOptions)localObject10);
            localObject7 = localObject5;
            if (QLog.isColorLevel())
            {
              QLog.i("DailySignIn", 2, "use custom icon=" + (String)localObject2);
              localObject7 = localObject5;
            }
            ThemeUtil.getCurrentThemeInfo().getString("themeId");
            ((URLImageView)localObject8).setImageDrawable((Drawable)localObject7);
            ((ImageView)localObject9).setImageDrawable((Drawable)localObject7);
            localObject5 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131369437);
            if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
              break label2038;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i4 - i3 - i5 - (i6 + i7));
            this.jdField_b_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            if (this.jdField_b_of_type_Int != 4) {
              break label1996;
            }
            if (QLog.isColorLevel()) {
              QLog.i("DailySignIn", 2, "use signed wording:" + (String)localObject1);
            }
            i("0X800ACFC");
            localObject2 = localObject1;
            if (i2 > 0) {
              localObject2 = String.format((String)localObject1, new Object[] { Integer.valueOf(i2) });
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            ((TextView)localObject5).setText((CharSequence)localObject2);
            this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
            this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
            return;
          }
        }
      }
    }
  }
  
  public void D()
  {
    this.jdField_i_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.onDrawerClosed();
    }
    if ((this.jdField_o_of_type_AndroidViewView != null) && (this.jdField_o_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      BaseApplication.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "qqsettingme_f2f_guide", 0).edit().putBoolean("qqsettingme_f2f_guide_flag", true).apply();
    }
    a(null);
    if ((this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView != null) && ((this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.a() instanceof PAGView))) {
      ((PAGView)this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.a()).stop();
    }
  }
  
  public void E()
  {
    this.jdField_i_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.onDrawerOpened();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSignInInfo(0);
    a(null);
    WeatherDCReportHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer_weather_expose");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A42B", "0X800A42B", 0, 0, "", "", "", "");
    int i1 = VipInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B178", "0X800B178", 0, 0, String.valueOf(i1), "", "", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (QQLevelIconCallback.isQQLevelIconExists(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType))) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType != 0) {
        break label234;
      }
    }
    label234:
    for (i1 = 99999;; i1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType)
    {
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A778", i1, 0, "", "", "", "");
      aq();
      if ((this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView != null) && ((this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.a() instanceof PAGView))) {
        ((PAGView)this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.a()).play();
      }
      return;
    }
  }
  
  void F()
  {
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.WebPreloadTask(this));
  }
  
  public void G()
  {
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      int i1 = 0;
      if (localIterator.hasNext())
      {
        Bitmap localBitmap = ((UpSideDownDrawable)localIterator.next()).a();
        if (localBitmap == null) {
          break label70;
        }
        i1 = Utils.a(localBitmap) + i1;
      }
      label70:
      for (;;)
      {
        break;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        return i1;
      }
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    float f2 = ((Resources)localObject).getDimension(2131298521);
    float f3 = ((Resources)localObject).getDimension(2131298505) + ((Resources)localObject).getDimension(2131298509) + ((Resources)localObject).getDimension(2131298513) + ((Resources)localObject).getDimension(2131298516) + ((Resources)localObject).getDimension(2131298524);
    QQValueInfoItem localQQValueInfoItem = QQValueInfoManage.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    float f1 = f3;
    if (localQQValueInfoItem != null)
    {
      f1 = f3;
      if (localQQValueInfoItem.jdField_d_of_type_Int == 0) {
        f1 = f3 + AIOUtils.a(QQValuePagView.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) + ((Resources)localObject).getDimension(2131298523);
      }
    }
    f3 = localDisplayMetrics.widthPixels - f1 - paramInt;
    if (f2 <= 1.0F) {}
    for (f1 = 1.0F;; f1 = f2)
    {
      int i1 = (int)Math.floor(f3 / f1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resizeQQLevelIconSize width=" + localDisplayMetrics.widthPixels);
        ((StringBuilder)localObject).append(",iconSize=" + f1);
        ((StringBuilder)localObject).append(",vipSize=" + paramInt);
        ((StringBuilder)localObject).append(",space=" + f3);
        ((StringBuilder)localObject).append(",maxIconSize=" + i1);
        QLog.i("QQSettingRedesign", 4, ((StringBuilder)localObject).toString());
      }
      return i1;
    }
  }
  
  public DrawerFrame a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a;
    }
    return null;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_jump_url", "https://ti.qq.com/signin/public/index.html?_wv=1090528161&_wwv=13");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onResume!");
    }
    this.jdField_h_of_type_Boolean = false;
    u();
    SceneTracker.a().a("QQSettingMe");
    if (!this.jdField_d_of_type_Boolean) {
      h();
    }
    this.jdField_k_of_type_AndroidViewView.setPadding(this.jdField_k_of_type_AndroidViewView.getPaddingLeft(), ScreenUtil.dip2px(14.0F), this.jdField_k_of_type_AndroidViewView.getPaddingRight(), this.jdField_k_of_type_AndroidViewView.getPaddingBottom());
    AbstractGifImage.resumeAll();
    AbstractVideoImage.resumeAll();
    ApngImage.playByTag(1);
    y();
    k();
    w();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.initApolloDrawerStatus();
    }
    try
    {
      if (((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("window")).getDefaultDisplay().getWidth() >= 480)
      {
        an();
        this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      for (;;)
      {
        m();
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if ((localObject1 != null) && (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString))) {
          ThreadManagerV2.executeOnSubThread(new QQSettingMe.4(this));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.updateCmshowStatus();
          this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.refreshApolloView();
        }
        this.jdField_c_of_type_Boolean = true;
        b(true);
        ar();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = (IWebProcessPreload)QRoute.api(IWebProcessPreload.class);
          if (localObject3 != null)
          {
            long l1 = ((IWebProcessPreload)localObject3).getBusinessClickTimeMills((String)localObject1, "individuation");
            if ((l1 == -1L) || (System.currentTimeMillis() - l1 < 259200000L)) {
              ((IWebProcessPreload)localObject3).preParseDns(jdField_b_of_type_JavaUtilList, "key_individuation_dns_parse");
            }
            l1 = ((IWebProcessPreload)localObject3).getBusinessClickTimeMills((String)localObject1, "vip");
            if (System.currentTimeMillis() - l1 < 604800000L) {
              ((IWebProcessPreload)localObject3).preParseDns(jdField_a_of_type_JavaUtilList, "key_vip_dns_parse");
            }
          }
        }
        localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
        if (localObject3 != null)
        {
          localObject4 = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
          if ((localObject4 == null) || (!((QQStoryManager)localObject4).e())) {
            break;
          }
          ((View)localObject3).setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.a((String)localObject1, "setting", ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        I();
        J();
        b();
        ac();
        ae();
        H();
        af();
        ag();
        if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.couldSetStatusTextColor()) && (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (SimpleUIUtil.a())) {
          ImmersiveUtils.setStatusTextColor(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        }
        TianShuManager.setLastClickAdTraceInfo("", "");
        localObject4 = new int[15];
        Object tmp509_507 = localObject4;
        tmp509_507[0] = 2131374844;
        Object tmp515_509 = tmp509_507;
        tmp515_509[1] = 2131372114;
        Object tmp521_515 = tmp515_509;
        tmp521_515[2] = 2131372111;
        Object tmp527_521 = tmp521_515;
        tmp527_521[3] = 2131372102;
        Object tmp533_527 = tmp527_521;
        tmp533_527[4] = 2131372105;
        Object tmp539_533 = tmp533_527;
        tmp539_533[5] = 2131372110;
        Object tmp545_539 = tmp539_533;
        tmp545_539[6] = 2131372079;
        Object tmp552_545 = tmp545_539;
        tmp552_545[7] = 2131372106;
        Object tmp559_552 = tmp552_545;
        tmp559_552[8] = 2131372112;
        Object tmp566_559 = tmp559_552;
        tmp566_559[9] = 2131372113;
        Object tmp573_566 = tmp566_559;
        tmp573_566[10] = 2131372107;
        Object tmp580_573 = tmp573_566;
        tmp580_573[11] = 2131364328;
        Object tmp587_580 = tmp580_573;
        tmp587_580[12] = 2131372080;
        Object tmp594_587 = tmp587_580;
        tmp594_587[13] = 2131365492;
        Object tmp601_594 = tmp594_587;
        tmp601_594[14] = 2131372078;
        tmp601_594;
        i2 = VipInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
        i1 = 0;
        for (;;)
        {
          if (i1 >= 15) {
            break label1151;
          }
          if ((localObject4[i1] != 2131372114) || (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() != 0)) {
            break;
          }
          localObject1 = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(100400));
          int i3 = VipInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), RedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C3", "0X800A8C3", i3, 0, String.valueOf(i3), "", "", "");
          MobileReportManager.getInstance().qqSetingMeReport(1, 101, String.valueOf(i3));
          i1 += 1;
        }
        if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.jdField_h_of_type_AndroidWidgetTextView != null) {
          this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        int i2;
        int i1;
        QLog.e("QQSettingRedesign", 1, localThrowable, new Object[0]);
        continue;
        ((View)localObject3).setVisibility(8);
        continue;
        Object localObject2;
        if ((localObject4[i1] == 2131372111) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() == 0))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C4", "0X800A8C4", i2, 0, String.valueOf(i2), "", "", "");
          RedTouch localRedTouch = this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[2];
          localObject3 = "2";
          localObject2 = localObject3;
          if (localRedTouch != null)
          {
            localObject2 = localObject3;
            if (localRedTouch.c()) {
              localObject2 = "1";
            }
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "wallet", "wallet.entrance.show", 0, 0, (String)localObject2, NetConnInfoCenter.getServerTimeMillis() + "", "", "8.5.5");
        }
        else if ((localObject4[i1] == 2131365492) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() == 0))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C5", "0X800A8C5", i2, 0, String.valueOf(i2), this.jdField_e_of_type_JavaLangString, "", "");
        }
        else if (localObject4[i1] == 2131374844)
        {
          QzoneConfig.getInstance();
          if (QzoneConfig.isQQCircleShowDrawTabEntrance()) {
            this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(0);
          } else {
            this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(8);
          }
        }
        else if (localObject4[i1] == 2131372079)
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqVipQQSettingConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "key_svip_item_makup_");
          localObject2 = "0";
          if (localObject3 != null) {
            localObject2 = ((MenumItem)localObject3).user_group + "";
          }
          MobileReportManager.getInstance().qqSetingMeReport(6, 101, (String)localObject2);
        }
      }
      label1151:
      d(false);
    }
  }
  
  void a(int paramInt)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramInt, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation != this.jdField_c_of_type_Int)
    {
      this.jdField_c_of_type_Int = paramConfiguration.orientation;
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from onConfigurationChanged");
      }
      c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "fillData, " + this.jdField_d_of_type_Boolean);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      e();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      f();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a(paramQQAppInterface);
      k();
      y();
      Z();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.destroyApollo();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  @TargetApi(9)
  void a(RichStatus paramRichStatus)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    ImageView localImageView1 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131377043);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131377044);
    ImageView localImageView2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368620);
    localImageView2.setColorFilter(localTextView.getCurrentTextColor());
    StringBuilder localStringBuilder = new StringBuilder(100);
    SharedPreferences.Editor localEditor;
    label272:
    Object localObject1;
    if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null))
    {
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      localTextView.setMaxWidth(this.jdField_g_of_type_Int);
      localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qqsettingme_signature" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
      if ((paramRichStatus == null) || (TextUtils.isEmpty(paramRichStatus.actionText))) {
        break label515;
      }
      localImageView1.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramRichStatus.actionId, 200));
      localImageView1.setVisibility(0);
      localStringBuilder.append(paramRichStatus.actionText);
      if (!TextUtils.isEmpty(paramRichStatus.dataText)) {
        localStringBuilder.append(paramRichStatus.dataText);
      }
      localStringBuilder.append(' ');
      localEditor.putInt("actionId", paramRichStatus.actionId);
      localEditor.putString("actionText", paramRichStatus.actionText);
      localEditor.putString("dataText", paramRichStatus.dataText);
      if (paramRichStatus != null)
      {
        if (!paramRichStatus.hasTopic()) {
          break label548;
        }
        if (paramRichStatus.shouldShowAtHead())
        {
          localObject1 = paramRichStatus.topicToPlainText();
          localStringBuilder.append((String)localObject1);
          localEditor.putString("topics", (String)localObject1);
          localObject1 = localObject2;
          if (paramRichStatus.plainText != null)
          {
            localObject1 = localObject2;
            if (paramRichStatus.plainText.size() > 0) {
              localObject1 = (String)paramRichStatus.plainText.get(0);
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localStringBuilder.append((String)localObject1);
          }
          localEditor.putString("plainText", (String)localObject1);
        }
        if (paramRichStatus.shouldShowMixing())
        {
          paramRichStatus = paramRichStatus.getPlainText();
          localStringBuilder.append(paramRichStatus);
          localEditor.putString("plainMixTopic", paramRichStatus);
        }
      }
      label404:
      if (Build.VERSION.SDK_INT <= 8) {
        break label612;
      }
      localEditor.apply();
      label419:
      paramRichStatus = localStringBuilder.toString();
      if (!TextUtils.isEmpty(paramRichStatus)) {
        break label623;
      }
      localTextView.setText(2131699117);
      localImageView2.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
        this.jdField_a_of_type_JavaLangStringBuilder.append("个性签名").append(paramRichStatus);
        this.jdField_e_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
      if (SimpleUIUtil.a()) {
        localImageView1.setVisibility(8);
      }
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break;
      label515:
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130846380);
      localImageView1.setVisibility(8);
      break label272;
      label548:
      localObject1 = localObject3;
      if (paramRichStatus.plainText != null)
      {
        localObject1 = localObject3;
        if (paramRichStatus.plainText.size() > 0) {
          localObject1 = (String)paramRichStatus.plainText.get(0);
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localStringBuilder.append((String)localObject1);
      }
      localEditor.putString("plainText", (String)localObject1);
      break label404;
      label612:
      localEditor.commit();
      break label419;
      label623:
      localImageView2.setVisibility(0);
      if (DeviceInfoUtil.b()) {
        localTextView.setText(new QQText(paramRichStatus + " ", 1, 16));
      } else {
        localTextView.setText(new QQText(paramRichStatus, 1, 16));
      }
    }
  }
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (ImmersiveUtils.isSupporImmersive() == 0) {
      return;
    }
    if (this.jdField_i_of_type_Boolean)
    {
      if ((SimpleUIUtil.a()) && (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (ImmersiveUtils.isSupporImmersive() != 0))
      {
        paramBoolean = ThemeUtil.getCurrentThemeId();
        if ((QQTheme.c(paramBoolean)) && (!QQTheme.a(paramBoolean)))
        {
          ImmersiveUtils.setStatusTextColor(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
          return;
        }
        ImmersiveUtils.setStatusTextColor(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        return;
      }
      ThemeUtil.adjustThemeStatusBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    Boolean localBoolean = paramBoolean;
    if (paramBoolean == null)
    {
      localBoolean = paramBoolean;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
        if ((!DrawerCoverUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())) {
          break label170;
        }
      }
    }
    label170:
    for (boolean bool = true;; bool = false)
    {
      localBoolean = Boolean.valueOf(bool);
      if ((localBoolean == null) || (!ThemeUtil.isDefaultTheme())) {
        break label188;
      }
      if (!localBoolean.booleanValue()) {
        break;
      }
      ImmersiveUtils.setStatusTextColor(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    ImmersiveUtils.setStatusTextColor(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
    return;
    label188:
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null))
    {
      ImmersiveUtils.setStatusTextColor(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    if (ThemeUtil.isGoldenTheme())
    {
      ImmersiveUtils.setStatusTextColor(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    ImmersiveUtils.setStatusTextColor(ThemeUtil.isDartStatusBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "[showExploreBox] url:" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.showExploreBox(paramString);
    }
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
    if ((paramBoolean) || (!ThemeUtil.isDefaultTheme()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.1(this, paramBoolean));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.2(this));
  }
  
  /* Error */
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 351	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc_w 353
    //   9: iconst_2
    //   10: new 366	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 3392
    //   20: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 1471	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: ldc_w 3394
    //   30: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 1471	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   37: ldc_w 3396
    //   40: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_3
    //   44: invokevirtual 666	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 514	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 1383	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 362	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokevirtual 1965	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   60: astore 6
    //   62: aload_0
    //   63: getfield 735	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   66: iconst_1
    //   67: aaload
    //   68: ldc_w 820
    //   71: invokevirtual 416	android/view/View:findViewById	(I)Landroid/view/View;
    //   74: checkcast 491	android/widget/TextView
    //   77: astore 7
    //   79: aload_0
    //   80: getfield 735	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   83: iconst_1
    //   84: aaload
    //   85: ldc_w 818
    //   88: invokevirtual 416	android/view/View:findViewById	(I)Landroid/view/View;
    //   91: checkcast 594	android/widget/ImageView
    //   94: astore 8
    //   96: aload_0
    //   97: getfield 360	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   100: invokevirtual 727	com/tencent/mobileqq/app/BaseActivity:getResources	()Landroid/content/res/Resources;
    //   103: astore 9
    //   105: aload 9
    //   107: ldc 199
    //   109: invokevirtual 847	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   112: astore 5
    //   114: invokestatic 1045	com/tencent/mobileqq/app/LocaleManager:a	()Z
    //   117: ifeq +414 -> 531
    //   120: iload_1
    //   121: ifeq +253 -> 374
    //   124: invokestatic 2563	com/tencent/mobileqq/vas/VipGrayConfigHelper:a	()Lcom/tencent/mobileqq/vas/VipGrayConfigHelper;
    //   127: getfield 3397	com/tencent/mobileqq/vas/VipGrayConfigHelper:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   130: invokestatic 773	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne +224 -> 357
    //   136: invokestatic 2563	com/tencent/mobileqq/vas/VipGrayConfigHelper:a	()Lcom/tencent/mobileqq/vas/VipGrayConfigHelper;
    //   139: getfield 3397	com/tencent/mobileqq/vas/VipGrayConfigHelper:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   142: astore 6
    //   144: aload 6
    //   146: astore 5
    //   148: aload 5
    //   150: astore 6
    //   152: aload 5
    //   154: invokevirtual 447	java/lang/String:length	()I
    //   157: bipush 8
    //   159: if_icmple +13 -> 172
    //   162: aload 5
    //   164: iconst_0
    //   165: bipush 8
    //   167: invokevirtual 3401	java/lang/String:substring	(II)Ljava/lang/String;
    //   170: astore 6
    //   172: aload_0
    //   173: getfield 197	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqVipQQSettingConfigManager	Lcom/tencent/mobileqq/vip/QQSettingConfigManager;
    //   176: aload_0
    //   177: getfield 362	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   180: iconst_4
    //   181: invokevirtual 1048	com/tencent/mobileqq/vip/QQSettingConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)Z
    //   184: ifne +27 -> 211
    //   187: aload 7
    //   189: aload 6
    //   191: invokevirtual 557	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   194: aload_0
    //   195: getfield 180	com/tencent/mobileqq/activity/QQSettingMe:jdField_l_of_type_Boolean	Z
    //   198: ifeq +435 -> 633
    //   201: ldc_w 3402
    //   204: istore_3
    //   205: aload 8
    //   207: iload_3
    //   208: invokevirtual 819	android/widget/ImageView:setImageResource	(I)V
    //   211: aload 6
    //   213: invokestatic 773	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   216: ifne +107 -> 323
    //   219: aload_0
    //   220: getfield 362	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   223: invokevirtual 500	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   226: ldc_w 2075
    //   229: iconst_0
    //   230: invokevirtual 1774	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   233: invokeinterface 2792 1 0
    //   238: new 366	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 2077
    //   248: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_0
    //   252: getfield 362	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   255: invokevirtual 441	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   258: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 2079
    //   264: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokestatic 2081	com/tencent/mobileqq/app/LocaleManager:a	()I
    //   270: invokevirtual 666	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: invokevirtual 514	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: aload 6
    //   278: invokeinterface 2799 3 0
    //   283: invokeinterface 2802 1 0
    //   288: pop
    //   289: invokestatic 351	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +31 -> 323
    //   295: ldc_w 353
    //   298: iconst_2
    //   299: new 366	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   306: ldc_w 3404
    //   309: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload 6
    //   314: invokevirtual 513	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 514	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 668	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_0
    //   324: getfield 735	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   327: iconst_1
    //   328: aaload
    //   329: iconst_0
    //   330: invokevirtual 554	android/view/View:setVisibility	(I)V
    //   333: getstatic 400	com/tencent/common/config/AppSetting:jdField_d_of_type_Boolean	Z
    //   336: ifeq +20 -> 356
    //   339: aload_0
    //   340: getfield 735	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   343: iconst_1
    //   344: aaload
    //   345: aload 6
    //   347: ldc_w 849
    //   350: invokevirtual 854	java/lang/Class:getName	()Ljava/lang/String;
    //   353: invokestatic 859	com/tencent/mobileqq/util/AccessibilityUtil:a	(Landroid/view/View;Ljava/lang/CharSequence;Ljava/lang/String;)V
    //   356: return
    //   357: aload 9
    //   359: ldc_w 3405
    //   362: invokevirtual 847	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   365: astore 6
    //   367: aload 6
    //   369: astore 5
    //   371: goto -223 -> 148
    //   374: iload_2
    //   375: ifeq +47 -> 422
    //   378: invokestatic 2563	com/tencent/mobileqq/vas/VipGrayConfigHelper:a	()Lcom/tencent/mobileqq/vas/VipGrayConfigHelper;
    //   381: getfield 3406	com/tencent/mobileqq/vas/VipGrayConfigHelper:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   384: invokestatic 773	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifne +18 -> 405
    //   390: invokestatic 2563	com/tencent/mobileqq/vas/VipGrayConfigHelper:a	()Lcom/tencent/mobileqq/vas/VipGrayConfigHelper;
    //   393: getfield 3406	com/tencent/mobileqq/vas/VipGrayConfigHelper:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   396: astore 6
    //   398: aload 6
    //   400: astore 5
    //   402: goto -254 -> 148
    //   405: aload 9
    //   407: ldc_w 3407
    //   410: invokevirtual 847	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   413: astore 6
    //   415: aload 6
    //   417: astore 5
    //   419: goto -271 -> 148
    //   422: aload 6
    //   424: ldc_w 3409
    //   427: iconst_0
    //   428: invokeinterface 1970 3 0
    //   433: istore 4
    //   435: iload_3
    //   436: ifgt +8 -> 444
    //   439: iload 4
    //   441: ifle +47 -> 488
    //   444: invokestatic 2563	com/tencent/mobileqq/vas/VipGrayConfigHelper:a	()Lcom/tencent/mobileqq/vas/VipGrayConfigHelper;
    //   447: getfield 3410	com/tencent/mobileqq/vas/VipGrayConfigHelper:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   450: invokestatic 773	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   453: ifne +18 -> 471
    //   456: invokestatic 2563	com/tencent/mobileqq/vas/VipGrayConfigHelper:a	()Lcom/tencent/mobileqq/vas/VipGrayConfigHelper;
    //   459: getfield 3410	com/tencent/mobileqq/vas/VipGrayConfigHelper:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   462: astore 6
    //   464: aload 6
    //   466: astore 5
    //   468: goto -320 -> 148
    //   471: aload 9
    //   473: ldc_w 3411
    //   476: invokevirtual 847	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   479: astore 6
    //   481: aload 6
    //   483: astore 5
    //   485: goto -337 -> 148
    //   488: invokestatic 2563	com/tencent/mobileqq/vas/VipGrayConfigHelper:a	()Lcom/tencent/mobileqq/vas/VipGrayConfigHelper;
    //   491: getfield 3412	com/tencent/mobileqq/vas/VipGrayConfigHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   494: invokestatic 773	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   497: ifne +18 -> 515
    //   500: invokestatic 2563	com/tencent/mobileqq/vas/VipGrayConfigHelper:a	()Lcom/tencent/mobileqq/vas/VipGrayConfigHelper;
    //   503: getfield 3412	com/tencent/mobileqq/vas/VipGrayConfigHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   506: astore 6
    //   508: aload 6
    //   510: astore 5
    //   512: goto -364 -> 148
    //   515: aload 9
    //   517: ldc 199
    //   519: invokevirtual 847	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   522: astore 6
    //   524: aload 6
    //   526: astore 5
    //   528: goto -380 -> 148
    //   531: iload_1
    //   532: ifeq +16 -> 548
    //   535: aload 9
    //   537: ldc_w 3405
    //   540: invokevirtual 847	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   543: astore 6
    //   545: goto -373 -> 172
    //   548: iload_2
    //   549: ifeq +16 -> 565
    //   552: aload 9
    //   554: ldc_w 3407
    //   557: invokevirtual 847	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   560: astore 6
    //   562: goto -390 -> 172
    //   565: aload 6
    //   567: ldc_w 3409
    //   570: iconst_0
    //   571: invokeinterface 1970 3 0
    //   576: istore 4
    //   578: iload_3
    //   579: ifgt +8 -> 587
    //   582: iload 4
    //   584: ifle +16 -> 600
    //   587: aload 9
    //   589: ldc_w 3411
    //   592: invokevirtual 847	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   595: astore 6
    //   597: goto -425 -> 172
    //   600: aload 9
    //   602: ldc 199
    //   604: invokevirtual 847	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   607: astore 6
    //   609: goto -437 -> 172
    //   612: astore 6
    //   614: ldc_w 353
    //   617: iconst_1
    //   618: ldc_w 3414
    //   621: aload 6
    //   623: invokestatic 1882	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   626: aload 5
    //   628: astore 6
    //   630: goto -458 -> 172
    //   633: ldc_w 3415
    //   636: istore_3
    //   637: goto -432 -> 205
    //   640: astore 5
    //   642: ldc_w 353
    //   645: iconst_1
    //   646: ldc_w 3417
    //   649: aload 5
    //   651: invokestatic 1882	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   654: goto -331 -> 323
    //   657: astore 6
    //   659: goto -45 -> 614
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	QQSettingMe
    //   0	662	1	paramBoolean1	boolean
    //   0	662	2	paramBoolean2	boolean
    //   0	662	3	paramInt	int
    //   433	150	4	i1	int
    //   112	515	5	localObject1	Object
    //   640	10	5	localException1	Exception
    //   60	548	6	localObject2	Object
    //   612	10	6	localException2	Exception
    //   628	1	6	localObject3	Object
    //   657	1	6	localException3	Exception
    //   77	111	7	localTextView	TextView
    //   94	112	8	localImageView	ImageView
    //   103	498	9	localResources	Resources
    // Exception table:
    //   from	to	target	type
    //   114	120	612	java/lang/Exception
    //   124	144	612	java/lang/Exception
    //   357	367	612	java/lang/Exception
    //   378	398	612	java/lang/Exception
    //   405	415	612	java/lang/Exception
    //   422	435	612	java/lang/Exception
    //   444	464	612	java/lang/Exception
    //   471	481	612	java/lang/Exception
    //   488	508	612	java/lang/Exception
    //   515	524	612	java/lang/Exception
    //   535	545	612	java/lang/Exception
    //   552	562	612	java/lang/Exception
    //   565	578	612	java/lang/Exception
    //   587	597	612	java/lang/Exception
    //   600	609	612	java/lang/Exception
    //   219	323	640	java/lang/Exception
    //   152	172	657	java/lang/Exception
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  int[] a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new int[] { 2130846388, 2130846404, 2130846386, 2130846400, 2130846406, 2130846408, 2130846410, 2130846359, 2130846391, 2130846384, 2130846382, 2130846389, 2130846398, 2130846355, 2130846402 };
    }
    return new int[] { 2130846388, 2130846405, 2130846387, 2130846401, 2130846407, 2130846409, 2130846411, 2130846359, 2130846392, 2130846385, 2130846382, 2130846390, 2130846398, 2130846356, 2130846402 };
  }
  
  void b()
  {
    int i1 = 1;
    if (this.jdField_a_of_type_ArrayOfAndroidViewView[4] == null) {}
    String str;
    do
    {
      return;
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "qqsettingme_f2f_guide", 0);
      int i2 = localSharedPreferences.getInt("qqsettingme_f2f_guide_switch", 0);
      str = localSharedPreferences.getString("qqsettingme_f2f_guide_tip", HardCodeUtil.a(2131710724));
      boolean bool = localSharedPreferences.getBoolean("qqsettingme_f2f_guide_flag", false);
      if (QLog.isColorLevel()) {
        QLog.i("QQSettingRedesign", 2, String.format("updateFace2FaceGuide switch_hasShowed = %d_%b", new Object[] { Integer.valueOf(i2), Boolean.valueOf(bool) }));
      }
      if ((i2 == 1) && (!bool)) {}
      while ((i1 == 0) && (this.jdField_o_of_type_AndroidViewView != null))
      {
        this.jdField_o_of_type_AndroidViewView.setVisibility(8);
        return;
        i1 = 0;
      }
    } while ((i1 == 0) || ((this.jdField_o_of_type_AndroidViewView != null) && (this.jdField_o_of_type_AndroidViewView.getVisibility() == 0)));
    f(str);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 50L);
  }
  
  protected void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.15(this, paramString));
  }
  
  public void b(boolean paramBoolean)
  {
    QQSettingMe.13 local13 = new QQSettingMe.13(this);
    if (paramBoolean)
    {
      ThreadManager.post(local13, 5, null, false);
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(local13, 5000L);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onPause!");
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.onPause();
    }
    if (f()) {
      L();
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    SceneTracker.a().b("QQSettingMe");
  }
  
  public void c(String paramString)
  {
    ThreadManager.post(new QQSettingMe.16(this, paramString), 5, null, false);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onDestroy!");
    }
    if (this.jdField_d_of_type_Boolean)
    {
      e();
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
        if (localAvatarPendantManager != null) {
          localAvatarPendantManager.c();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.onDestroy();
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      QQValueInfoManage.a().a("setting");
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
  
  public void d(String paramString)
  {
    if ((this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_h_of_type_AndroidWidgetTextView == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_g_of_type_AndroidWidgetTextView == null) || (this.jdField_c_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_j_of_type_AndroidViewView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    int i1;
    if (paramString.charAt(0) == '-')
    {
      paramString = paramString.substring(1, paramString.length());
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setText("-");
      this.jdField_f_of_type_AndroidWidgetTextView.measure(0, 0);
      i1 = this.jdField_f_of_type_AndroidWidgetTextView.getMeasuredWidth();
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.measure(0, 0);
      this.jdField_h_of_type_AndroidWidgetTextView.measure(0, 0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.measure(0, 0);
      this.jdField_g_of_type_AndroidWidgetTextView.measure(0, 0);
      int i4 = this.jdField_e_of_type_AndroidWidgetTextView.getMeasuredWidth();
      int i3 = this.jdField_c_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
      int i2 = (i3 - i4 - i1 - this.jdField_g_of_type_AndroidWidgetTextView.getMeasuredWidth()) / 2;
      i4 /= 2;
      i3 /= 2;
      paramString = (LinearLayout.LayoutParams)this.jdField_j_of_type_AndroidViewView.getLayoutParams();
      paramString.leftMargin = (i3 - (i1 + i2 + i4));
      this.jdField_j_of_type_AndroidViewView.setLayoutParams(paramString);
      return;
      i1 = 0;
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.getObserver());
      }
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLoveZoneInfoObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a(this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback, false);
    }
    VipGrayConfigHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper$VipGrayConfigListener);
    MemoryClearManager.a().b(this.jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager$IClearMemoryListener);
  }
  
  public void e(String paramString)
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
      if ((AppSetting.jdField_d_of_type_Boolean) && (localStringBuilder != null)) {
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setContentDescription(localStringBuilder.toString());
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
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLoveZoneInfoObserver, true);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.getObserver());
      }
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a(this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager = ((WeatherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WEATHER_MANAGER));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener = new QQSettingMeWeatherListener(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWeatherManager$WeatherUpdaterListener);
      }
      VipGrayConfigHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqVasVipGrayConfigHelper$VipGrayConfigListener);
      MemoryClearManager.a().a(this.jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager$IClearMemoryListener);
    }
  }
  
  public void g()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new QQSettingMe.7(this, 0, true, true, 60000L, true, false, "QQSettingRedesign"));
  }
  
  public void h()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("QQSettingRedesign", 4, "init, " + this.jdField_d_of_type_Boolean);
    }
    if (true == this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic = new NightModeLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    f();
    k();
    y();
    w();
    b(true);
    m();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.initApolloDrawerStatus();
      this.jdField_a_of_type_ComTencentMobileqqApolloApiISettingMeApolloViewController.updateCmshowStatus();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.opencenter.vipInfo"));
      if (TextUtils.isEmpty(VipGrayConfigHelper.a().jdField_b_of_type_JavaLangString)) {
        ThreadManager.post(new QQSettingMe.8(this), 5, null, true);
      }
      M();
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
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateAllRedView");
    }
    S();
    Y();
    Z();
    n();
    o();
    s();
    t();
    A();
    p();
    j();
    q();
    r();
    ad();
    ah();
    R();
    B();
    aj();
    as();
    P();
    Q();
    O();
  }
  
  protected void j()
  {
    try
    {
      a(5, this.jdField_g_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      ((QzoneAlbumRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_ALBUM_RED_TOUCH)).a(this.jdField_g_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void k()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable(ImageUtil.c());
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    b(str);
    if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    for (;;)
    {
      ThreadManager.postImmediately(new QQSettingMe.14(this, str), null, true);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from updateAccountInfo");
      }
      c(str);
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      if (!AppSetting.jdField_d_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
  }
  
  @RequiresApi(api=23)
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.b();
    }
    Object localObject2;
    boolean bool;
    label129:
    int i1;
    label180:
    label216:
    label362:
    int i2;
    label389:
    label440:
    TextView localTextView;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.setForeground(new ColorDrawable(1996488704));
      }
    }
    else
    {
      U();
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "ThemeDebugKeyLog:onPostThemeChanged, refresh pendant after theme changed.");
      }
      x();
      Z();
      this.jdField_j_of_type_Boolean = true;
      localObject2 = ThemeUtil.getCurrentThemeInfo();
      Object localObject1 = ((Bundle)localObject2).getString("themeId");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"1000".equals(localObject1)) && (!"1103".equals(localObject1))) {
        break label579;
      }
      bool = true;
      this.jdField_l_of_type_Boolean = bool;
      a(null);
      if (!this.jdField_l_of_type_Boolean) {
        break label584;
      }
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166477);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130846393);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846373);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((!DrawerCoverUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) {
        break label621;
      }
      a(true);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onPostThemeChanged, color=" + i1 + ",themeid = " + (String)localObject1 + ", enginePath=" + ((Bundle)localObject2).getString("themePath"));
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(i1);
      K();
      localObject2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368620);
      if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
        break label629;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"1000".equals(localObject1))) {
        break label656;
      }
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      af();
      al();
      ag();
      B();
      g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      T();
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i1);
      localObject1 = a(this.jdField_l_of_type_Boolean);
      i2 = 0;
      if (i2 >= 15) {
        break label689;
      }
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[i2] != null)
      {
        localObject2 = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369364);
        ((ImageView)localObject2).setImageResource(localObject1[i2]);
        localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369437);
        if (this.jdField_l_of_type_Boolean) {
          break label668;
        }
        localTextView.setTextColor(i1);
      }
    }
    for (;;)
    {
      if ((SimpleUIUtil.a()) && ("2920".equals(ThemeUtil.getCurrentThemeId()))) {
        localTextView.setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166476));
      }
      if (i2 == 10) {
        a((ImageView)localObject2, localTextView);
      }
      i2 += 1;
      break label440;
      this.jdField_a_of_type_ComTencentMobileqqVasQqvaluecardViewQQValuePagView.setForeground(null);
      break;
      label579:
      bool = false;
      break label129;
      label584:
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166478);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130846397);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130846372);
      break label180;
      label621:
      a(false);
      break label216;
      label629:
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i1);
      break label362;
      label656:
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      break label389;
      label668:
      localTextView.setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166476));
    }
    label689:
    ((DynamicAvatarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe onPostThemeChanged refresh because simple theme switch!");
      }
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    ((IRedTouchServer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyUI(4, true, null);
  }
  
  protected void m()
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a();
    String str;
    if (i1 == 1) {
      if (this.jdField_l_of_type_Boolean)
      {
        localObject1 = ((Resources)localObject2).getDrawable(2130846373);
        str = ((Resources)localObject2).getString(2131699147);
        localObject2 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      if (localObject2 != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      }
      if (localObject1 != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      }
      return;
      localObject1 = ((Resources)localObject2).getDrawable(2130846372);
      break;
      if (i1 == 2)
      {
        if (this.jdField_l_of_type_Boolean) {}
        for (localObject1 = ((Resources)localObject2).getDrawable(2130846373);; localObject1 = ((Resources)localObject2).getDrawable(2130846372))
        {
          str = ((Resources)localObject2).getString(2131699147);
          localObject2 = localObject1;
          localObject1 = str;
          break;
        }
      }
      localObject2 = null;
    }
  }
  
  protected void n()
  {
    boolean bool2 = true;
    boolean bool1 = UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.a(bool1);
    }
    if ((!bool1) && (PrivacyPolicyHelper.a(1)))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.a(true);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if (!bool1) {
        this.jdField_j_of_type_ComTencentMobileqqTianshuUiRedTouch.c(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      }
      return;
    }
  }
  
  protected void o()
  {
    try
    {
      a(2, this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_b_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < 500L))
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      else
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        Object localObject5 = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
        Object localObject1;
        Object localObject4;
        label511:
        long l1;
        int i1;
        label1267:
        boolean bool;
        Object localObject2;
        label2824:
        Object localObject3;
        switch (paramView.getId())
        {
        case 2131369628: 
        default: 
          break;
        case 2131363413: 
          if (FrameHelperActivity.b())
          {
            FrameHelperActivity.c(true);
            FrameHelperActivity.w();
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009C4E", "0X8009C4E", 0, 0, "", "", "", "");
          }
          break;
        case 2131372078: 
        case 2131372100: 
          if (this.jdField_b_of_type_Boolean)
          {
            localObject1 = a();
            localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("portraitOnly", true);
            ((Intent)localObject4).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((Intent)localObject4).putExtra("hide_operation_bar", true);
            ((Intent)localObject4).putExtra("hide_more_button", true);
            ((Intent)localObject4).putExtra("big_brother_source_key", "biz_src_ad_daka");
            ((Intent)localObject4).putExtra("url", (String)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
            if (this.jdField_b_of_type_Int == 1)
            {
              i("0X800ACFD");
              d(true);
            }
          }
          while (QLog.isColorLevel())
          {
            QLog.i("DailySignIn", 2, "mydaily onClick mDayliSignMode = " + this.jdField_b_of_type_Boolean);
            break;
            if (this.jdField_b_of_type_Int != 4) {
              break label511;
            }
            i("0X800ACFE");
            break label511;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("task_entry_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getString("jump_url", "");
            localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("portraitOnly", true);
            ((Intent)localObject4).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((Intent)localObject4).putExtra("hide_operation_bar", true);
            ((Intent)localObject4).putExtra("hide_more_button", true);
            ((Intent)localObject4).putExtra("big_brother_source_key", "biz_src_ad_daka");
            ((Intent)localObject4).putExtra("url", (String)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_duty", "", "locker", "clk", 0, 0, "", "", "", "");
          }
        case 2131372289: 
          V();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80072D6", "0X80072D6", 0, 0, "", "", "", "");
          break;
        case 2131368315: 
          V();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80072D7", "0X80072D7", 0, 0, "", "", "", "");
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          if (this.jdField_e_of_type_ComTencentMobileqqTianshuUiRedTouch.c()) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006726", "0X8006726", 0, 0, "", "", "", "");
          }
          break;
        case 2131375127: 
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          ((Intent)localObject1).putExtra("title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131717061));
          ((Intent)localObject1).putExtra("nick", ContactUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4));
          ((Intent)localObject1).putExtra("uin", (String)localObject4);
          ((Intent)localObject1).putExtra("type", 1);
          ((Intent)localObject1).putExtra("reportFlag", 1);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055BB", "0X80055BB", 0, 0, "", "", "", "");
          ((IRedTouchManager)localObject5).reportLevelOneRedInfo(101600, 31);
          break;
        case 2131372111: 
          l1 = System.currentTimeMillis();
          if (ProfileActivity.a(this.jdField_a_of_type_Long, l1))
          {
            this.jdField_a_of_type_Long = l1;
            if (QWalletHelperImpl.isValidToLaunchQWallet(l1))
            {
              QWalletHelperImpl.launchQWalletAct(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true);
              QQSettingUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              ((IRedTouchManager)localObject5).reportLevelOneRedInfo(100007, 31);
              localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[2];
              i1 = VipInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), ((RedTouch)localObject1).c());
              localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
              if (((RedTouch)localObject1).c()) {}
              for (localObject1 = "1";; localObject1 = "2")
              {
                ReportController.b((AppRuntime)localObject4, "P_CliOper", "Vip_pay_mywallet", (String)localObject5, "wallet", "wallet.entrance.click", 0, 0, (String)localObject1, NetConnInfoCenter.getServerTimeMillis() + "", "", "8.5.5");
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8BF", "0X800A8BF", i1, 0, String.valueOf(i1), "", "", "");
                if (jdField_a_of_type_Int <= 0) {
                  break label1267;
                }
                DrawerFrame.jdField_a_of_type_Int = 2;
                break;
              }
              DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            }
          }
          break;
        case 2131372102: 
          if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()) {}
          for (bool = true;; bool = false)
          {
            QfavHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, -1, bool);
            QfavReport.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0);
            QfavUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            ((IRedTouchManager)localObject5).reportLevelOneRedInfo(103000, 31);
            break;
          }
        case 2131372110: 
          bool = false;
          localObject1 = new QZoneClickReport.ReportInfo();
          ((QZoneClickReport.ReportInfo)localObject1).setActionType("443");
          ((QZoneClickReport.ReportInfo)localObject1).setSubactionType("3");
          ((QZoneClickReport.ReportInfo)localObject1).setToUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
          if ((this.jdField_g_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_g_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1))
          {
            bool = true;
            ((QZoneClickReport.ReportInfo)localObject1).setReserves("1");
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (QZoneClickReport.ReportInfo)localObject1);
            ((IRedTouchManager)localObject5).reportLevelOneRedInfo(100180, 31);
          }
          try
          {
            l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
            localObject5 = QZoneHelper.UserInfo.getInstance();
            ((QZoneHelper.UserInfo)localObject5).qzone_uin = String.valueOf(l1);
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = ContactUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            ((QZoneHelper.UserInfo)localObject5).nickname = ((String)localObject1);
            QZoneHelper.forwardFromQQSettingToPersonalAlbum(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (QZoneHelper.UserInfo)localObject5, Long.valueOf(l1), 0, bool, -1);
            localObject1 = new QZoneClickReport.ReportInfo();
            ((QZoneClickReport.ReportInfo)localObject1).actionType = "1";
            ((QZoneClickReport.ReportInfo)localObject1).subactionType = "0";
            ((QZoneClickReport.ReportInfo)localObject1).tabletype = 4;
            ((QZoneClickReport.ReportInfo)localObject1).sourceType = "3";
            ((QZoneClickReport.ReportInfo)localObject1).sourceFrom = "drawerAlbumList";
            ((QZoneClickReport.ReportInfo)localObject1).sourceTo = "QZonePhotoListActivity";
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject1);
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("source_type", "3");
            ((HashMap)localObject1).put("source_from", "drawerAlbumList");
            ((HashMap)localObject1).put("source_to", "QZonePhotoListActivity");
            StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            continue;
            ((QZoneClickReport.ReportInfo)localObject1).setReserves("2");
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              l1 = 0L;
            }
          }
        case 2131372079: 
          ((IRedTouchManager)localObject5).reportLevelOneRedInfo(100005, 31);
          if (((RedTouch)((ViewGroup)paramView).getChildAt(0)).c()) {}
          for (localObject2 = MobileReportManager.getNewReportInfo(((IRedTouchManager)localObject5).getAppInfoByPath(String.valueOf(100005)));; localObject2 = MobileReportManager.getNewDefaultReportInfo("outside", "3"))
          {
            VasWebviewUtil.openIndividuationIndex(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject2);
            ThreadManager.post(new QQSettingMe.17(this), 5, null, true);
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqVipQQSettingConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "key_svip_item_makup_");
            localObject2 = "0";
            if (localObject4 != null) {
              localObject2 = ((MenumItem)localObject4).user_group + "";
            }
            MobileReportManager.getInstance().qqSetingMeReport(6, 102, (String)localObject2);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Personality_setting", 0, 0, "", "", "", "");
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            break;
          }
        case 2131377918: 
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQSettingSettingActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          if (UpgradeController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004DB0", "0X8004DB0", 0, 0, "", "", UpgradeController.a(), "");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0)) {
            ConfigHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iNewTimeStamp);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
          ((IRedTouchManager)localObject5).reportLevelOneRedInfo(100190, 31);
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          break;
        case 2131372303: 
          if (!DarkModeManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "", new QQSettingMe.18(this))) {
            X();
          }
          break;
        case 2131370682: 
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((Intent)localObject2).putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=draw");
          ((Intent)localObject2).putExtra("hide_more_button", true);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A9C3", "0X800A9C3", 0, 0, "", "", "", "");
          break;
        case 2131381835: 
          i1 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getInt("cur_adcode", 0);
          WeatherWebPageHelperKt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, "", true, String.valueOf(i1));
          QLog.i("QQSettingRedesign", 1, "startNewWeatherWeb adCode = " + i1);
          WeatherDCReportHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer_weather_click");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A42C", "0X800A42C", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005BE4", "0X8005BE4", 0, 0, "", "", "", "");
          break;
        case 2131378164: 
          if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) && (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a()))
          {
            ((IRedTouchManager)localObject5).reportLevelOneRedInfo(100450, 31);
            if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
            {
              localObject2 = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131377044);
              if ((localObject2 != null) && (((TextView)localObject2).getText() != null))
              {
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt("from_type", 3);
                SignTextEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, "", (Bundle)localObject2, -1);
              }
            }
            DrawerFrame.jdField_a_of_type_Int = 0;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "set_enter", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80072D8", "0X80072D8", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A669", "0X800A669", 0, 0, "", "", "", "");
          break;
        case 2131374844: 
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          ((HashMap)localObject2).put("key_jump_from", "9");
          QCircleUtils.a().enterBySchemeAction(BaseApplicationImpl.context, "openmainpage", (HashMap)localObject2);
          break;
        case 2131372114: 
          l1 = System.currentTimeMillis();
          if (ProfileActivity.a(this.jdField_a_of_type_Long, l1))
          {
            this.jdField_a_of_type_Long = l1;
            if (QLog.isColorLevel()) {
              QLog.i("QQSettingRedesign", 2, "enter vip");
            }
            ThreadManager.post(new QQSettingMe.19(this), 5, null, true);
            localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[1];
            i1 = VipInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), ((RedTouch)localObject2).c());
            if (((RedTouch)localObject2).c()) {}
            for (localObject2 = MobileReportManager.getNewReportInfo(((IRedTouchManager)localObject5).getAppInfoByPath(String.valueOf(100400)));; localObject2 = MobileReportManager.getNewDefaultReportInfo("outside", "1"))
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8BE", "0X800A8BE", i1, 0, String.valueOf(i1), "", "", "");
              h((String)localObject2);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
              MobileReportManager.getInstance().qqSetingMeReport(1, 102, String.valueOf(i1));
              if (jdField_a_of_type_Int <= 0) {
                break label2824;
              }
              DrawerFrame.jdField_a_of_type_Int = 2;
              break;
            }
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          }
          break;
        case 2131372105: 
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, FileAssistantActivity.class);
          ((Intent)localObject2).putExtra("from", "FileAssistant");
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          localObject2 = ((IRedTouchManager)localObject5).getAppInfoByPath(String.valueOf(100160));
          if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 0)) {
            ((IRedTouchManager)localObject5).reportLevelOneRedInfo(100160, 31);
          }
          try
          {
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("service_type", 2);
            ((JSONObject)localObject4).put("act_id", 1002);
            ((IRedTouchManager)localObject5).onReportBusinessRedTouch((BusinessInfoCheckUpdate.AppInfo)localObject2, ((JSONObject)localObject4).toString());
            if ((this.jdField_o_of_type_AndroidViewView != null) && (this.jdField_o_of_type_AndroidViewView.getVisibility() == 0))
            {
              this.jdField_o_of_type_AndroidViewView.setVisibility(8);
              BaseApplication.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "qqsettingme_f2f_guide", 0).edit().putBoolean("qqsettingme_f2f_guide_flag", true).apply();
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        case 2131372112: 
          if (jdField_a_of_type_Int > 0) {
            DrawerFrame.jdField_a_of_type_Int = 2;
          } else {
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          }
          break;
        case 2131365492: 
          localObject4 = "";
          BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject5).getAppInfoByPath(String.valueOf(100500));
          localObject3 = localObject4;
          if (localAppInfo != null)
          {
            localObject3 = localObject4;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              localObject3 = MobileReportManager.getStringReport2H5(localAppInfo);
              ((IRedTouchManager)localObject5).reportLevelOneRedInfo(100500, 31);
            }
          }
          localObject4 = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).getString("drawerUrl", "");
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            QLog.e("QQSettingRedesign", 1, "cuKingCard url = null");
          }
          localObject3 = (String)localObject4 + (String)localObject3;
          localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject4).putExtra("url", (String)localObject3);
          ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
          localObject3 = this.jdField_a_of_type_ArrayOfComTencentMobileqqTianshuUiRedTouch[13];
          i1 = VipInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), ((RedTouch)localObject3).c());
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C0", "0X800A8C0", i1, 0, String.valueOf(i1), this.jdField_e_of_type_JavaLangString, "", "");
          break;
        case 2131372113: 
          QQStoryMemoriesActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, QQStoryContext.a().b(), true);
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          break;
        case 2131372107: 
          localObject3 = QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameJumpUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1108291530&_mvid=&_path=pages%2Fgame-list%2Fgame-list.html%3Fmode%3Dchouti&_vt=3&via=2066&_sig=676003338");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl((String)localObject3)) {
              ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a((String)localObject3, this.jdField_n_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo), 2066, null);
            }
          }
          else
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (!RedTouch.a(this.jdField_n_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo)) {
              break label3577;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            ReportController.b((AppRuntime)localObject3, "dc00898", "", "", "0X800ACDD", "0X800ACDD", 0, i1, "", "", "", "");
            ((IRedTouchManager)localObject5).reportLevelOneRedInfo(100077, 31);
            break;
            localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("url", (String)localObject3);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
            break label3477;
          }
        case 2131364328: 
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
          localObject4 = ((Context)localObject3).getSharedPreferences("call_tim_config_pre" + (String)localObject4, 0).getString("call_tim_config_url", null);
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = TencentDocUserConfigProcessor.a().a();
          }
          localObject4 = localObject3;
          if (localObject3 == null) {
            localObject4 = "https://docs.qq.com/desktop/m/index.html";
          }
          localObject3 = TeamWorkUtils.b((String)localObject4, "s_qq_drawer");
          localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject4).putExtra("url", (String)localObject3);
          ((Intent)localObject4).putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
          ((Intent)localObject4).putExtra("tdsourcetag", "s_qq_drawer");
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800887E", "0X800887E", 0, 0, "", "", "", "");
          break;
        case 2131374838: 
          b(paramView);
          break;
        case 2131374887: 
          a(paramView.getContext());
          break;
        case 2131372696: 
          a(paramView);
          break;
        case 2131372712: 
          ab();
          ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97F", "0X800A97F", 0, 0, "0", "0", "", "");
          break;
        case 2131372106: 
          i1 = LoverZoneUtils.a(LoverZoneUtils.a(this.jdField_m_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo));
          localObject3 = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
          localObject4 = ((IRedTouchManager)localObject3).getAppInfoByPath(String.valueOf(100066));
          if ((localObject4 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() != 0))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView == null) || (this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.getVisibility() != 0)) {
              break label3985;
            }
            a("0x800AAFB", "1");
          }
          for (;;)
          {
            ((IRedTouchManager)localObject3).reportLevelOneRedInfo(100066, 31);
            LoverZoneUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2066, "10", i1 + "");
            break;
            a("0x800AAFB", "2");
          }
        case 2131372080: 
          W();
          break;
        case 2131381710: 
          label3477:
          label3577:
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateExtId);
          label3985:
          VipUtils.a("0X800B923", this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateExtId);
        }
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {}
    do
    {
      return false;
      switch (paramView.getId())
      {
      default: 
        return false;
      }
      if (paramMotionEvent.getAction() == 0)
      {
        paramView.setAlpha(0.5F);
        paramView.invalidate();
        return false;
      }
    } while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3));
    paramView.setAlpha(1.0F);
    paramView.invalidate();
    return false;
  }
  
  protected void p()
  {
    try
    {
      this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.jdField_f_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void q()
  {
    try
    {
      a(3, this.jdField_h_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void r()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(1000017));
      if (!((BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a())
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
        return;
      }
      localAppInfo.iNewFlag.set(0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void s()
  {
    try
    {
      a(6, this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1))
      {
        IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
        if (localIWebProcessManagerService != null) {
          localIWebProcessManagerService.startWebProcess(-1, null);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void t()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
        this.jdField_a_of_type_MQQPayRuleCfg = VipInfoHandler.a(this.jdField_b_of_type_JavaLangString);
        bool = VipInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MQQPayRuleCfg, this.jdField_h_of_type_Boolean);
        if (this.jdField_a_of_type_MQQPayRuleCfg == null)
        {
          QLog.e("QQSettingRedesign", 1, "VipInfoHandler getPayRule is null");
          if (!bool) {
            break label415;
          }
          if (!this.jdField_h_of_type_Boolean)
          {
            this.jdField_h_of_type_Boolean = true;
            ReportController.b(null, "dc00898", "", "", "", "0X800A632", VipInfoHandler.a(this.jdField_a_of_type_MQQPayRuleCfg), 1, 0, "1", this.jdField_a_of_type_MQQPayRuleCfg.advId, "", "");
            VipInfoHandler.a(101, this.jdField_a_of_type_MQQPayRuleCfg.advId);
          }
          ai();
          if (QLog.isColorLevel())
          {
            localObject = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
            QLog.d("QQSettingRedesign", 2, "VipInfoHandler vipAppinfo: " + ((IRedTouchManager)localObject).appToString(this.jdField_d_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo));
          }
          localObject = new BusinessInfoCheckUpdate.AppInfo();
          ((BusinessInfoCheckUpdate.AppInfo)localObject).set(this.jdField_d_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
          if ((bool) && (RedTouchTextView.a((BusinessInfoCheckUpdate.AppInfo)localObject) != null))
          {
            ArrayList localArrayList = new ArrayList();
            BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            localRedTypeInfo.red_type.set(0);
            localArrayList.add(localRedTypeInfo);
            ((BusinessInfoCheckUpdate.AppInfo)localObject).red_display_info.red_type_info.set(localArrayList);
          }
          a(1, (BusinessInfoCheckUpdate.AppInfo)localObject);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            if ((this.jdField_d_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo == null) || (this.jdField_d_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 1)) {
              break label435;
            }
            QLog.e("QQSettingRedesign", 1, "VipInfoHandler PreloadWebService updateVipItemView");
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, PreloadWebService.class);
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e("QQSettingRedesign", 1, "updateVipItemView: ", localException);
        return;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startService((Intent)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQSettingRedesign", 2, "PreloadWebService", localThrowable);
        return;
      }
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler getPayRule " + this.jdField_a_of_type_MQQPayRuleCfg.iconText + " needShowPayButton=" + bool + " url=" + this.jdField_a_of_type_MQQPayRuleCfg.iconUrl + " exposed:" + this.jdField_h_of_type_Boolean);
      continue;
      label415:
      v();
      continue;
      label435:
      if (!bool) {}
    }
  }
  
  public void u()
  {
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler payRuleUin changed");
      v();
    }
  }
  
  public void v()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131369416);
    localTextView.setText("");
    localTextView.setBackgroundDrawable(null);
  }
  
  public void w()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.25(this));
  }
  
  public void x()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (SimpleUIUtil.a())
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    label253:
    for (;;)
    {
      return;
      Object localObject;
      if ((!this.jdField_k_of_type_Boolean) && (localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
      {
        localObject = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
        ((AvatarPendantManager)localObject).b();
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        localObject = ((AvatarPendantManager)localObject).a(localExtensionInfo.pendantId);
        if (AvatarPendantUtil.a(localExtensionInfo.pendantId))
        {
          ((PendantInfo)localObject).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.jdField_h_of_type_Int, localExtensionInfo.uin, localExtensionInfo.pendantDiyId);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarPendant", "choutishow", 0, 0, "", "", "", "");
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if ((i1 != 1) || (i1 != this.jdField_k_of_type_Boolean)) {
          break label253;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006728", "0X8006728", 0, 0, "", "", "", "");
        return;
        ((PendantInfo)localObject).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.jdField_h_of_type_Int, localExtensionInfo.uin, localExtensionInfo.pendantDiyId);
        break;
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  protected void y()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (this.jdField_e_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new QQSettingMe.26(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new QQSettingMe.27(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener = new QQSettingMe.28(this);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    }
    RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(false);
    if ((localRichStatus == null) || (localRichStatus.isEmpty()))
    {
      ThreadManager.getFileThreadHandler().post(new QQSettingMe.29(this));
      return;
    }
    a(localRichStatus);
  }
  
  void z()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null)
    {
      QLog.e("QQSettingRedesign", 1, "preLoadSignature, mStatusManager == null");
      return;
    }
    ImageView localImageView1 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131377043);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131377044);
    ImageView localImageView2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368620);
    localImageView2.setColorFilter(localTextView.getCurrentTextColor());
    Object localObject1 = new StringBuilder(100);
    label118:
    Object localObject2;
    if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null))
    {
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      localTextView.setMaxWidth(this.jdField_g_of_type_Int);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qqsettingme_signature" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      String str1 = ((SharedPreferences)localObject2).getString("actionText", "");
      int i1 = ((SharedPreferences)localObject2).getInt("actionId", 0);
      String str2 = ((SharedPreferences)localObject2).getString("dataText", "");
      String str3 = ((SharedPreferences)localObject2).getString("plainText", "");
      String str4 = ((SharedPreferences)localObject2).getString("topics", "");
      localObject2 = ((SharedPreferences)localObject2).getString("plainMixTopic", "");
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "preLoadSignature, actionText = " + str1 + " actionId = " + i1 + " dataText = " + str2 + " plainText = " + str3);
      }
      if (TextUtils.isEmpty(str1)) {
        break label509;
      }
      localImageView1.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(i1, 200));
      localImageView1.setVisibility(0);
      ((StringBuilder)localObject1).append(str1);
      if (!TextUtils.isEmpty(str2)) {
        ((StringBuilder)localObject1).append(str2);
      }
      ((StringBuilder)localObject1).append(' ');
      label373:
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label538;
      }
      if (!TextUtils.isEmpty(str4)) {
        ((StringBuilder)localObject1).append(str4);
      }
      if (!TextUtils.isEmpty(str3)) {
        ((StringBuilder)localObject1).append(str3);
      }
      label413:
      localObject1 = ((StringBuilder)localObject1).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label549;
      }
      localTextView.setText(2131699117);
      localImageView2.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
        this.jdField_a_of_type_JavaLangStringBuilder.append("个性签名").append((String)localObject1);
        this.jdField_e_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
      if (!SimpleUIUtil.a()) {
        break;
      }
      localImageView1.setVisibility(8);
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label118;
      label509:
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130846380);
      localImageView1.setVisibility(8);
      break label373;
      label538:
      ((StringBuilder)localObject1).append((String)localObject2);
      break label413;
      label549:
      localImageView2.setVisibility(0);
      if (DeviceInfoUtil.b()) {
        localTextView.setText((String)localObject1 + " ");
      } else {
        localTextView.setText((CharSequence)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe
 * JD-Core Version:    0.7.0.1
 */
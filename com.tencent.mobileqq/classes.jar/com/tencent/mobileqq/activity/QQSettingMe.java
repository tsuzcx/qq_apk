package com.tencent.mobileqq.activity;

import MQQ.PayRuleCfg;
import QQService.EVIPSPEC;
import abjg;
import abjh;
import afhq;
import afhr;
import afhs;
import afht;
import afhu;
import afhv;
import afhw;
import afhx;
import afhy;
import afhz;
import afia;
import afib;
import afid;
import afie;
import afif;
import afig;
import afih;
import afii;
import afij;
import afik;
import afil;
import afim;
import afio;
import amll;
import amlm;
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
import anug;
import anuh;
import anuw;
import anvl;
import anvn;
import anyu;
import anyw;
import anzj;
import aobf;
import aobi;
import aobk;
import aodp;
import aogf;
import aogx;
import aokv;
import aokw;
import aoot;
import aqib;
import aqmx;
import arrj;
import arrk;
import asbw;
import avsm;
import awwi;
import aysp;
import aysq;
import aytb;
import ayxl;
import bagf;
import bapy;
import bbav;
import bbsr;
import bbst;
import bbsw;
import bbvd;
import bdep;
import bdgb;
import bdll;
import bdlx;
import bdmc;
import becb;
import begp;
import behm;
import beih;
import beik;
import beyq;
import beyr;
import bhdu;
import bhga;
import bhhz;
import bhih;
import bhjx;
import bhkt;
import bhlg;
import bhlo;
import bhmi;
import bhmq;
import bhmr;
import bhni;
import bhnv;
import bhty;
import bhtz;
import bhua;
import bhyk;
import bias;
import biau;
import bico;
import biik;
import blgs;
import blgu;
import blqp;
import bmfq;
import bmfs;
import bmkq;
import bmky;
import bmlc;
import bmsx;
import bmtd;
import bmtk;
import bmzn;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.apollo.SettingMeApolloViewController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.loverzone.LoveZoneTabRedDotView;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.FixedBounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QVipMedalView;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.ilive.share.IliveShareHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
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
import javax.annotation.Nullable;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mvd;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;
import tencent.im.oidb.redInfo.RedInfo;
import uyx;
import wjb;
import zps;

public class QQSettingMe
  implements View.OnClickListener, View.OnTouchListener
{
  public static int a;
  private static List<String> jdField_a_of_type_JavaUtilList;
  private static List<String> jdField_b_of_type_JavaUtilList;
  protected long a;
  private PayRuleCfg jdField_a_of_type_MQQPayRuleCfg;
  public abjh a;
  private amll jdField_a_of_type_Amll;
  private amlm jdField_a_of_type_Amlm;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new afhq(this);
  Handler jdField_a_of_type_AndroidOsHandler = new afik(this, Looper.getMainLooper());
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afhv(this);
  protected View a;
  public ViewGroup a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  anuw jdField_a_of_type_Anuw = new afie(this);
  private anvn jdField_a_of_type_Anvn = new afid(this);
  private anyu jdField_a_of_type_Anyu = new afif(this);
  private aobk jdField_a_of_type_Aobk = new afih(this);
  private aogx jdField_a_of_type_Aogx = new afii(this);
  private aokw jdField_a_of_type_Aokw = new afib(this);
  private avsm jdField_a_of_type_Avsm = new avsm("QQSetting_me", "com.tencent.mobileqq:tool");
  private ayxl jdField_a_of_type_Ayxl = new afhz(this);
  private bbsr jdField_a_of_type_Bbsr;
  private bbst jdField_a_of_type_Bbst;
  private bbsw jdField_a_of_type_Bbsw;
  private bbvd jdField_a_of_type_Bbvd;
  private beih jdField_a_of_type_Beih;
  beik jdField_a_of_type_Beik = new afig(this);
  private biau jdField_a_of_type_Biau = new afij(this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private SettingMeApolloViewController jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController;
  public BaseActivity a;
  private FrameHelperActivity jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
  public QQAppInterface a;
  protected DynamicAvatarView a;
  public Card a;
  private MedalList jdField_a_of_type_ComTencentMobileqqDataMedalList;
  private LoveZoneTabRedDotView jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView;
  protected RedTouch a;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper;
  protected AvatarLayout a;
  protected AnimationTextView a;
  public FixedBounceScrollView a;
  protected QVipMedalView a;
  protected RedDotTextView a;
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private BusinessInfoCheckUpdate.RedTypeInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo;
  private String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private ConcurrentHashMap<String, blqp> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private redInfo.RedInfo jdField_a_of_type_TencentImOidbRedInfo$RedInfo;
  protected boolean a;
  public View[] a;
  protected RedTouch[] a;
  protected RedTouchTextView[] a;
  protected int b;
  long jdField_b_of_type_Long = 0L;
  public Handler b;
  protected View b;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  protected ImageView b;
  protected LinearLayout b;
  protected TextView b;
  protected RedTouch b;
  BusinessInfoCheckUpdate.AppInfo jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private String jdField_b_of_type_JavaLangString;
  protected boolean b;
  int jdField_c_of_type_Int;
  protected View c;
  public ImageView c;
  public LinearLayout c;
  public TextView c;
  protected RedTouch c;
  BusinessInfoCheckUpdate.AppInfo jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private String jdField_c_of_type_JavaLangString = "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1";
  public boolean c;
  private final int jdField_d_of_type_Int = 4;
  protected View d;
  protected ImageView d;
  protected TextView d;
  protected RedTouch d;
  BusinessInfoCheckUpdate.AppInfo jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private String jdField_d_of_type_JavaLangString = "";
  public boolean d;
  private final int jdField_e_of_type_Int = 1;
  protected View e;
  protected ImageView e;
  public TextView e;
  protected RedTouch e;
  BusinessInfoCheckUpdate.AppInfo jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  protected boolean e;
  private int jdField_f_of_type_Int;
  protected View f;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  protected TextView f;
  BusinessInfoCheckUpdate.AppInfo jdField_f_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  protected View g;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  public TextView g;
  BusinessInfoCheckUpdate.AppInfo jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private boolean jdField_g_of_type_Boolean;
  private final int jdField_h_of_type_Int = 0;
  protected View h;
  public TextView h;
  BusinessInfoCheckUpdate.AppInfo jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private boolean jdField_h_of_type_Boolean;
  private final int jdField_i_of_type_Int = 1;
  protected View i;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  BusinessInfoCheckUpdate.AppInfo jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
  private boolean jdField_i_of_type_Boolean;
  private final int jdField_j_of_type_Int = 2;
  protected View j;
  BusinessInfoCheckUpdate.AppInfo jdField_j_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
  private boolean jdField_j_of_type_Boolean = true;
  private View jdField_k_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_k_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private boolean jdField_k_of_type_Boolean;
  private View jdField_l_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_l_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private View jdField_m_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private View jdField_n_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_n_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private View jdField_o_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  
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
    this.jdField_a_of_type_Abjh = new afim(this);
    this.jdField_b_of_type_AndroidOsHandler = new afhr(this, Looper.getMainLooper());
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->QQSettingMe construct!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = paramFrameHelperActivity;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561558, null));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367926);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(anzj.a(2131709636));
    }
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367895));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363327));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367940);
    this.jdField_m_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377748);
    paramFrameHelperActivity = paramQQAppInterface.getCurrentAccountUin();
    int i1;
    label709:
    Object localObject1;
    String str;
    boolean bool;
    label1640:
    int[] arrayOfInt;
    label1668:
    int i3;
    int i2;
    if ((paramFrameHelperActivity == null) || (paramFrameHelperActivity.length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130840274);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131371828).setOnClickListener(this);
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298369);
      this.jdField_f_of_type_Int = (bdep.jdField_a_of_type_Int - bdep.a(94.0F) - i1 - bdep.a(45.0F));
      this.jdField_g_of_type_Int = (bdep.jdField_a_of_type_Int - bdep.a(94.0F) - i1 - bdep.a(20.0F));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371827));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_f_of_type_Int);
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramFrameHelperActivity);
      if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim()))) {
        this.jdField_a_of_type_JavaLangString = paramFrameHelperActivity;
      }
      if (!bdgb.b()) {
        break label2398;
      }
      this.jdField_m_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.jdField_m_of_type_AndroidViewView).a(53).a();
      this.jdField_b_of_type_AndroidViewView.setVisibility(VasFaceManager.a(paramFrameHelperActivity, paramQQAppInterface));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372389));
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView = ((QVipMedalView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374473));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374380);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374381);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372947));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381170));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374511));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText("");
      this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363238));
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363236));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374750));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367135));
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        paramBaseActivity.topMargin = (bdep.a(29.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "Change mBackWrapper topMargin=" + paramBaseActivity.topMargin);
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramBaseActivity);
      }
      this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetImageView.setOnTouchListener(this);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371632));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377719));
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBaseActivity.topMargin = (bdep.a(35.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBaseActivity);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377718)).a(53).a();
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377712);
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_e_of_type_AndroidViewView).b(10).a(19).a();
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView.setOnTouchListener(mvd.a);
      this.jdField_l_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373036);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView = ((FixedBounceScrollView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370965));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setDamping(2.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setBounceDelay(600L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setmCustomTopFadingEdgeScale(0.675F);
      i1 = (int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131298363);
      paramBaseActivity = this.jdField_a_of_type_AndroidViewViewGroup.getResources();
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[15];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch = new RedTouch[15];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView = new RedTouchTextView[15];
      paramFrameHelperActivity = new int[15];
      FrameHelperActivity tmp1384_1383 = paramFrameHelperActivity;
      tmp1384_1383[0] = 2131374479;
      FrameHelperActivity tmp1390_1384 = tmp1384_1383;
      tmp1390_1384[1] = 2131371646;
      FrameHelperActivity tmp1396_1390 = tmp1390_1384;
      tmp1396_1390[2] = 2131371643;
      FrameHelperActivity tmp1402_1396 = tmp1396_1390;
      tmp1402_1396[3] = 2131371634;
      FrameHelperActivity tmp1408_1402 = tmp1402_1396;
      tmp1408_1402[4] = 2131371637;
      FrameHelperActivity tmp1414_1408 = tmp1408_1402;
      tmp1414_1408[5] = 2131371642;
      FrameHelperActivity tmp1420_1414 = tmp1414_1408;
      tmp1420_1414[6] = 2131371609;
      FrameHelperActivity tmp1427_1420 = tmp1420_1414;
      tmp1427_1420[7] = 2131371638;
      FrameHelperActivity tmp1434_1427 = tmp1427_1420;
      tmp1434_1427[8] = 2131371644;
      FrameHelperActivity tmp1441_1434 = tmp1434_1427;
      tmp1441_1434[9] = 2131371645;
      FrameHelperActivity tmp1448_1441 = tmp1441_1434;
      tmp1448_1441[10] = 2131371639;
      FrameHelperActivity tmp1455_1448 = tmp1448_1441;
      tmp1455_1448[11] = 2131364125;
      FrameHelperActivity tmp1462_1455 = tmp1455_1448;
      tmp1462_1455[12] = 2131371610;
      FrameHelperActivity tmp1469_1462 = tmp1462_1455;
      tmp1469_1462[13] = 2131365227;
      FrameHelperActivity tmp1476_1469 = tmp1469_1462;
      tmp1476_1469[14] = 2131371608;
      tmp1476_1469;
      localObject1 = new int[15];
      Object tmp1492_1490 = localObject1;
      tmp1492_1490[0] = 2131698376;
      Object tmp1498_1492 = tmp1492_1490;
      tmp1498_1492[1] = 2131698362;
      Object tmp1504_1498 = tmp1498_1492;
      tmp1504_1498[2] = 2131698359;
      Object tmp1510_1504 = tmp1504_1498;
      tmp1510_1504[3] = 2131698386;
      Object tmp1516_1510 = tmp1510_1504;
      tmp1516_1510[4] = 2131698360;
      Object tmp1522_1516 = tmp1516_1510;
      tmp1522_1516[5] = 2131698401;
      Object tmp1528_1522 = tmp1522_1516;
      tmp1528_1522[6] = 2131698340;
      Object tmp1535_1528 = tmp1528_1522;
      tmp1535_1528[7] = 2131698349;
      Object tmp1542_1535 = tmp1535_1528;
      tmp1542_1535[8] = 2131698381;
      Object tmp1549_1542 = tmp1542_1535;
      tmp1549_1542[9] = 2131698351;
      Object tmp1556_1549 = tmp1549_1542;
      tmp1556_1549[10] = 2131698361;
      Object tmp1563_1556 = tmp1556_1549;
      tmp1563_1556[11] = 2131698332;
      Object tmp1570_1563 = tmp1563_1556;
      tmp1570_1563[12] = 2131698348;
      Object tmp1577_1570 = tmp1570_1563;
      tmp1577_1570[13] = 2131698333;
      Object tmp1584_1577 = tmp1577_1570;
      tmp1584_1577[14] = 2131698357;
      tmp1584_1577;
      Object localObject2 = ThemeUtil.getCurrentThemeInfo();
      str = ((Bundle)localObject2).getString("themeId");
      if ((!TextUtils.isEmpty(str)) && (!"1000".equals(str)) && (!"1103".equals(str))) {
        break label2434;
      }
      bool = true;
      this.jdField_j_of_type_Boolean = bool;
      if (!this.jdField_j_of_type_Boolean) {
        break label2440;
      }
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166441);
      arrayOfInt = a(this.jdField_j_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe_init, color=" + i1 + ",themeid = " + str + ", enginePath=" + ((Bundle)localObject2).getString("themePath"));
      }
      i3 = bdep.a(2.0F);
      localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370965);
      this.jdField_k_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.findViewById(2131370966);
      i2 = 0;
      label1775:
      if (i2 >= 15) {
        break label2473;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2] = ((View)localObject2).findViewById(paramFrameHelperActivity[i2]);
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setFocusable(true);
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(0);
      if (paramFrameHelperActivity[i2] == 2131371644) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      if (paramFrameHelperActivity[i2] == 2131371645) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      if (paramFrameHelperActivity[i2] == 2131364125) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      if (paramFrameHelperActivity[i2] == 2131374479)
      {
        QzoneConfig.getInstance();
        if (!QzoneConfig.isQQCircleShowDrawTabEntrance()) {
          break label2458;
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramFrameHelperActivity[i2] == 2131371638)
      {
        this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView = ((LoveZoneTabRedDotView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368935));
        if (this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView != null) {
          this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.setVisibility(8);
        }
      }
      if (paramFrameHelperActivity[i2] == 2131371608)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ArrayOfAndroidViewView[i2]);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setOnClickListener(this);
      Object localObject3 = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368926);
      ((ImageView)localObject3).setImageResource(arrayOfInt[i2]);
      Object localObject4 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368995);
      ((TextView)localObject4).setText(localObject1[i2]);
      if (!this.jdField_j_of_type_Boolean) {
        ((TextView)localObject4).setTextColor(i1);
      }
      if (paramFrameHelperActivity[i2] == 2131371639) {
        a((ImageView)localObject3, (TextView)localObject4);
      }
      if ((bdgb.b()) && ("2920".equals(ThemeUtil.getCurrentThemeId()))) {
        ((TextView)localObject4).setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166440));
      }
      localObject3 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368978);
      ((ThemeLabelTextView)localObject3).setSupportMaskView(true);
      ((TextView)localObject3).setVisibility(0);
      bhga.a(this.jdField_a_of_type_ArrayOfAndroidViewView[i2], paramBaseActivity.getString(localObject1[i2]), Button.class.getName());
      localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368926);
      ((View)localObject3).setPadding(i3, i3, i3, i3);
      localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject4).leftMargin -= i3;
      localObject4 = (RedTouchTextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368995);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((RedTouchTextView)localObject4).getLayoutParams();
      localLayoutParams.leftMargin -= i3;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i2] = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject3).a(53).a();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[i2] = localObject4;
      if (paramFrameHelperActivity[i2] == 2131371608) {
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i2];
      }
      i2 += 1;
      break label1775;
      localObject1 = paramQQAppInterface.a(paramQQAppInterface.a(1, paramFrameHelperActivity, (byte)3, 0, 100, true));
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageBitmap((Bitmap)localObject1);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130840274);
      break;
      label2398:
      this.jdField_m_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.jdField_b_of_type_AndroidViewView).a(53).a();
      break label709;
      label2434:
      bool = false;
      break label1640;
      label2440:
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166442);
      break label1668;
      label2458:
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
    }
    label2473:
    ad();
    A();
    W();
    Y();
    J();
    Z();
    i();
    this.jdField_i_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369184);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    if ((TextUtils.isEmpty(str)) || ("1000".equals(str)))
    {
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363608);
      this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377471);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this);
      bhga.a(this.jdField_g_of_type_AndroidViewView, anzj.a(2131709630), Button.class.getName());
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377473));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374431));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377472));
      this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView).a();
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371839);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this);
      bhga.a(this.jdField_f_of_type_AndroidViewView, anzj.a(2131709613), Button.class.getName());
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371841));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371840));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131368914));
      this.jdField_n_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370260);
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380121));
      this.jdField_n_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_n_of_type_AndroidViewView.setOnTouchListener(this);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131381298));
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378528));
      this.jdField_j_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378512);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378530));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378529));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131381293));
      if (!bdgb.b())
      {
        this.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        this.jdField_f_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        this.jdField_g_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      if (!ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, false, null)) {
        break label3148;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-6709582);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController = new SettingMeApolloViewController(this, this.jdField_a_of_type_AndroidViewViewGroup);
      if (!this.jdField_j_of_type_Boolean)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846097);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846072);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i1);
      }
      return;
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      break;
      label3148:
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166441));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166441));
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166441));
    }
  }
  
  private void I()
  {
    if (this.jdField_k_of_type_Boolean) {
      return;
    }
    this.jdField_k_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new afia(this));
  }
  
  private void J()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    if (localView != null)
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4);
      if (!((SharedPreferences)localObject).getBoolean("drawerEnable", false)) {
        break label151;
      }
      String str = ((SharedPreferences)localObject).getString("drawerText", "");
      this.jdField_d_of_type_JavaLangString = ((SharedPreferences)localObject).getString("drawerTextID", "");
      localObject = ((SharedPreferences)localObject).getString("drawerUrl", "");
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break label138;
      }
      localView.setVisibility(0);
      if (aobf.a()) {
        ((TextView)localView.findViewById(2131368995)).setText(str);
      }
    }
    return;
    label138:
    localView.setVisibility(8);
    this.jdField_d_of_type_JavaLangString = "";
    return;
    label151:
    localView.setVisibility(8);
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  private void K()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[11];
    if (localView != null)
    {
      if (asbw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("call_tim_config_pre" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("call_tim_config_title", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698332));
        localView.setVisibility(0);
        ((TextView)localView.findViewById(2131368995)).setText(str);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800887D", "0X800887D", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  private void L()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.l();
    }
  }
  
  private void M()
  {
    this.jdField_e_of_type_AndroidWidgetImageView.post(new QQSettingMe.9(this));
  }
  
  private void N()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "preloadSonicSession");
    }
    if (!SonicPreloader.isWifiOrG3OrG4()) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      Object localObject2 = SonicPreloader.getSonicPreloadDataList(this.jdField_k_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, 0);
      SparseArray localSparseArray = SonicPreloader.getSonicPreloadDataList(this.jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, 1000);
      Object localObject1 = SonicPreloader.getSonicPreloadDataList(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, 1001);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      if ((localObject2 != null) && (((SparseArray)localObject2).size() > 0))
      {
        int i1 = 0;
        if (i1 < ((SparseArray)localObject2).size())
        {
          SonicPreloadData localSonicPreloadData = (SonicPreloadData)((SparseArray)localObject2).valueAt(i1);
          if (1000 == localSonicPreloadData.id)
          {
            localSonicPreloadData.url = this.jdField_c_of_type_JavaLangString;
            localArrayList1.add(localSonicPreloadData);
          }
          for (;;)
          {
            i1 += 1;
            break;
            if (1001 == localSonicPreloadData.id)
            {
              localSonicPreloadData.url = bhyk.a("personalIndex");
              localArrayList1.add(localSonicPreloadData);
            }
          }
        }
      }
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        localObject2 = (SonicPreloadData)localSparseArray.valueAt(0);
        ((SonicPreloadData)localObject2).url = this.jdField_c_of_type_JavaLangString;
        localArrayList2.add(localObject2);
      }
      if ((localObject1 != null) && (((SparseArray)localObject1).size() > 0))
      {
        localObject1 = (SonicPreloadData)((SparseArray)localObject1).valueAt(0);
        ((SonicPreloadData)localObject1).url = bhyk.a("personalIndex");
        localArrayList3.add(localObject1);
      }
      localObject1 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (((WebProcessManager)localObject1).a(localArrayList1)) {
        ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(String.valueOf("200010.200012"));
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
  
  private void O()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
      try
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[12] != null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[12].setIsNeedRedImageAutoFix(true);
        }
        a(12, this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (RedTouch.a(this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo)) {}
        for (localObject = "1";; localObject = "2")
        {
          bdll.b(localQQAppInterface, "dc00898", "", "", "0X800B1F6", "0X800B1F6", 0, 0, (String)localObject, "", "", "");
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
  
  private void P()
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
    a(this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_n_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
  
  private void Q()
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
        str1 = String.format(anzj.a(2131698366), new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
    }
    for (String str2 = String.format(anzj.a(2131698399), new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });; str2 = anzj.a(2131698367))
    {
      this.jdField_i_of_type_AndroidWidgetTextView.setText(str1);
      bhga.a(this.jdField_n_of_type_AndroidViewView, str2, Button.class.getName());
      return;
      str1 = "9999+";
      break;
      str1 = anzj.a(2131698398);
    }
  }
  
  private void R()
  {
    Object localObject2 = bmfs.a(this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    String str = bmfq.a("drawer_shop_jump_scheme");
    Object localObject1 = bmfs.b(this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    bmfs.jdField_a_of_type_JavaLangString = (String)localObject1;
    IliveShareHelper.reportAction("qq_live", "chouti_page", "zhibo", "zhibo_button", "4", 102, IliveShareHelper.getFollowInfo("", (String)localObject1, "", "", ""));
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (RedTouch.a(this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo))
    {
      localObject1 = "1";
      bdll.b(localQQAppInterface, "dc00898", "", "", "0X800B1F7", "0X800B1F7", 0, 0, (String)localObject1, "", "", "");
      if ((this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0)) {
        ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(101100, 31);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQSettingRedesign", 2, "Ilive start jump shop , url = " + str);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label246;
      }
    }
    label246:
    for (localObject1 = str;; localObject1 = localObject2)
    {
      if (!URLUtil.isNetworkUrl((String)localObject1)) {
        break label251;
      }
      localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_vip");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
      return;
      localObject1 = "2";
      break;
    }
    label251:
    localObject1 = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject1);
    if (localObject1 != null)
    {
      ((bhmr)localObject1).a();
      return;
    }
    ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, bmfq.a(1));
  }
  
  private void S()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getString("sp_vip_medal_lvl_jump_url", null);
    if (a(str)) {
      return;
    }
    VipUtils.a(0, "mvip.pingtai.mobileqq.androidziliaoka.fromdrawer", "geren", str, "0");
    int i1 = aokv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B179", "0X800B179", 0, 0, String.valueOf(i1), "", "", "");
  }
  
  private void T()
  {
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_f_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_Beih.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    DrawerFrame.jdField_a_of_type_Int = 0;
    if (AppSetting.jdField_c_of_type_Boolean) {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label66;
      }
    }
    label66:
    for (String str = "关闭夜间模式";; str = "夜间模式 ")
    {
      bhga.a(this.jdField_f_of_type_AndroidViewView, str, Button.class.getName());
      return;
    }
  }
  
  private void U()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo != null) {
        this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo);
      }
      for (;;)
      {
        boolean bool = this.jdField_i_of_type_Boolean;
        this.jdField_i_of_type_Boolean = this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.b();
        if (QLog.isColorLevel()) {
          QLog.i("LocalRedTouchManager", 2, "updateHeadIcon, old:" + bool + " new:" + this.jdField_i_of_type_Boolean);
        }
        if (bool != this.jdField_i_of_type_Boolean) {
          y();
        }
        return;
        this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_j_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
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
  
  private void V()
  {
    Object localObject2 = (aysq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    Object localObject1 = ((aysq)localObject2).a(-4);
    if ((((aysq)localObject2).a((RedTouchItem)localObject1, true)) && (((RedTouchItem)localObject1).count > 0) && (this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo != null))
    {
      QLog.d("QQSettingRedesign", 1, new Object[] { "updateProfileBubbleMsgView ", Integer.valueOf(((RedTouchItem)localObject1).count) });
      long l1;
      ImageView localImageView;
      TextView localTextView;
      View localView;
      if (this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.has())
      {
        l1 = this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.get();
        localObject2 = this.jdField_l_of_type_AndroidViewView.findViewById(2131372246);
        localImageView = (ImageView)this.jdField_l_of_type_AndroidViewView.findViewById(2131367895);
        localTextView = (TextView)this.jdField_l_of_type_AndroidViewView.findViewById(2131371445);
        localView = this.jdField_l_of_type_AndroidViewView.findViewById(2131368977);
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label380;
        }
        ((View)localObject2).setBackgroundResource(2130846076);
      }
      for (;;)
      {
        Object localObject3 = bhmq.a(true);
        localObject3 = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, l1 + "", 4, (Drawable)localObject3, (Drawable)localObject3);
        Drawable localDrawable = localImageView.getDrawable();
        if ((localDrawable != null) && (localDrawable != localObject3) && ((localDrawable instanceof aoot))) {
          ((aoot)localDrawable).b();
        }
        localImageView.setImageDrawable((Drawable)localObject3);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698350, new Object[] { Integer.valueOf(((RedTouchItem)localObject1).count) });
        if (!((String)localObject1).equalsIgnoreCase(localTextView.getText().toString())) {
          localTextView.setText((CharSequence)localObject1);
        }
        ((View)localObject2).setContentDescription((CharSequence)localObject1);
        ((View)localObject2).setOnTouchListener(new afht(this, localImageView, localTextView, localView));
        ((View)localObject2).setOnClickListener(this);
        this.jdField_l_of_type_AndroidViewView.setVisibility(0);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97E", "0X800A97E", 0, 0, "0", "0", "", "");
        return;
        l1 = 0L;
        break;
        label380:
        ((View)localObject2).setBackgroundResource(2130846075);
      }
    }
    this.jdField_l_of_type_AndroidViewView.setVisibility(8);
    ((ImageView)this.jdField_l_of_type_AndroidViewView.findViewById(2131367895)).setImageDrawable(null);
  }
  
  private void W()
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
        if (((SharedPreferences)localObject).getInt("love_state_for_current_uin" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0) != 1) {
          break label111;
        }
        ag();
      }
    }
    return;
    label111:
    ah();
    return;
    label116:
    ((View)localObject).setVisibility(8);
    ah();
  }
  
  private void X()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[7];
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      localObject = awwi.a(this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      int i1 = awwi.a((String)localObject);
      awwi.a("10", i1 + "", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.setRedDotData(this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        a("0x800AAFA", "1");
      }
    }
    else
    {
      return;
    }
    a("0x800AAFA", "2");
    a(7, this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
  
  private void Y()
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
  
  private void Z()
  {
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.21(this));
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
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[paramInt].a((BusinessInfoCheckUpdate.AppInfo)localObject1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[paramInt].setAppInfo(paramAppInfo);
      return;
      label311:
      break;
      localAppInfo = null;
      paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject1;
      localObject1 = localAppInfo;
    }
  }
  
  private void a(Message paramMessage)
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
    localObject2 = (TextView)localView.findViewById(2131368995);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject1 = (ImageView)localView.findViewById(2131368926);
      if (TextUtils.isEmpty(paramMessage)) {
        break label167;
      }
      localObject2 = beyq.a;
      paramMessage = VasApngUtil.getApngURLDrawable(paramMessage, new int[] { 1 }, (Drawable)localObject2, null, null);
      if (paramMessage == null) {
        break label157;
      }
      ((ImageView)localObject1).post(new QQSettingMe.6(this, (ImageView)localObject1, paramMessage));
    }
    for (;;)
    {
      localView.setVisibility(0);
      return;
      ((TextView)localObject2).setText(2131698348);
      break;
      label157:
      ((ImageView)localObject1).setImageResource(2130846098);
      continue;
      label167:
      ((ImageView)localObject1).setImageResource(2130846098);
    }
  }
  
  private void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMedalList == null) {}
    for (String str = null; a(str); str = this.jdField_a_of_type_ComTencentMobileqqDataMedalList.jumpUrl) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    int i1 = aokv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
    if ((paramView instanceof QVipMedalView))
    {
      if (!bagf.jdField_a_of_type_Boolean) {
        break label169;
      }
      ((QVipMedalView)paramView).a("0X800B2B5", i1);
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X800A127", 0, 0, String.valueOf(i1), "", "", "");
      return;
      label169:
      ((QVipMedalView)paramView).a("0X800B2B4", i1);
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
        ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(i1, 30);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, "", "", "");
  }
  
  private void a(List<BusinessInfoCheckUpdate.AppInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i1 = 0;
      while (i1 < paramList.size())
      {
        List localList = ((BusinessInfoCheckUpdate.AppInfo)paramList.get(i1)).red_display_info.red_type_info.get();
        int i2 = localList.size() - 1;
        while (i2 >= 0)
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)localList.get(i2);
          if (localRedTypeInfo.red_type.get() == 15) {
            VasApngUtil.getApngURLDrawable(localRedTypeInfo.red_content.get(), VasApngUtil.VIP_APNG_TAGS, beyq.a);
          }
          i2 -= 1;
        }
        i1 += 1;
      }
    }
    paramList.clear();
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
      paramString = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      paramString.jdField_g_of_type_Int = 1;
      paramString.jdField_h_of_type_Int = 8;
      ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, 1009);
      QLog.e("QVipSettingMe.", 1, "medal list have no jump url ,so use the default");
      return true;
    }
    return false;
  }
  
  private void aa()
  {
    int i1 = 0;
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {}
    try
    {
      a(10, this.jdField_n_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (RedTouch.a(this.jdField_n_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo)) {
        i1 = 1;
      }
      bdll.b((QQAppInterface)localObject, "dc00898", "", "", "0X800ACDC", "0X800ACDC", 0, i1, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void ab()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_MQQPayRuleCfg.iconText)) || (TextUtils.isEmpty(this.jdField_a_of_type_MQQPayRuleCfg.iconUrl))) {
      QLog.e("QQSettingRedesign", 1, "showPayButton: iconText or iconUrl is empty");
    }
    Object localObject1;
    do
    {
      return;
      TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131368978);
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      afhu localafhu = new afhu(this, localTextView);
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
          localafhu.onLoadSuccessed((URLDrawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler showPayButton: ", localMalformedURLException);
        return;
      }
      localMalformedURLException.setText("");
      ((URLDrawable)localObject1).setURLDrawableListener(localafhu);
    } while (((URLDrawable)localObject1).getStatus() != 2);
    ((URLDrawable)localObject1).restartDownload();
  }
  
  private void ac()
  {
    try
    {
      a(13, this.jdField_l_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void ad()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vipTitleSpFile", 0).getString("vipTitleSpKey_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + aobf.a(), "");
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateVipText sp vipText = " + str);
      }
      if (!TextUtils.isEmpty(str))
      {
        TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131368995);
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
  
  private void ae()
  {
    ThreadManager.getUIHandler().post(new QQSettingMe.31(this));
  }
  
  private void af()
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
  
  private void ag()
  {
    Iterator localIterator = anug.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      anuh localanuh = (anuh)localIterator.next();
      if ((localanuh instanceof aobi)) {
        ((aobi)localanuh).a();
      }
    }
  }
  
  private void ah()
  {
    Iterator localIterator = anug.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      anuh localanuh = (anuh)localIterator.next();
      if ((localanuh instanceof aobi)) {
        ((aobi)localanuh).b();
      }
    }
  }
  
  private void ai()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    if ((localView != null) && (localView.getVisibility() == 0)) {
      ThreadManager.getSubThreadHandler().post(new QQSettingMe.39(this));
    }
  }
  
  private void aj()
  {
    Object localObject = (aysq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    RedTouchItem localRedTouchItem1 = ((aysq)localObject).a(10015);
    RedTouchItem localRedTouchItem2 = ((aysq)localObject).a(10016);
    int i1;
    if ((aytb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && ((((aysq)localObject).a(localRedTouchItem1, false)) || (((aysq)localObject).a(localRedTouchItem2, false))))
    {
      i1 = 1;
      if (i1 != 0)
      {
        i1 = ((aysq)localObject).a();
        localObject = null;
        switch (i1)
        {
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
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
  
  private void ak()
  {
    asbw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void b(View paramView)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    localQCircleInitBean.setLaunchFrom("9");
    uyx.b(paramView.getContext(), localQCircleInitBean);
  }
  
  private void b(boolean paramBoolean)
  {
    ThreadManager.post(new QQSettingMe.12(this), 5, null, false);
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
    View localView = this.jdField_k_of_type_AndroidViewView.findViewById(2131365227);
    Object localObject1 = new int[2];
    localView.getLocationOnScreen((int[])localObject1);
    localObject1 = new Rect(localObject1[0], localObject1[1], localObject1[0] + localView.getWidth(), localObject1[1] + localView.getHeight());
    Object localObject2 = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.getLocationOnScreen((int[])localObject2);
    localObject2 = new Rect(localObject2[0], localObject2[1], localObject2[0] + this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.getWidth(), localObject2[1] + this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.getHeight());
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "tryAdjustCuKingCard() containerBounds = " + localObject2 + ", cardBounds = " + localObject1);
    }
    if (!((Rect)localObject2).contains((Rect)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "tryAdjustCuKingCard() should adjust cuKingCard position");
      }
      localObject1 = (ViewGroup)localView.getParent();
      if (i1 >= ((ViewGroup)localObject1).getChildCount()) {
        break label271;
      }
      if (((ViewGroup)localObject1).getChildAt(i1).getId() != 2131371638) {
        break label264;
      }
    }
    for (;;)
    {
      if (i1 + 1 <= ((ViewGroup)localObject1).getChildCount())
      {
        ((ViewGroup)localObject1).removeView(localView);
        ((ViewGroup)localObject1).addView(localView, i1 + 1);
      }
      this.jdField_k_of_type_Boolean = true;
      return true;
      label264:
      i1 += 1;
      break;
      label271:
      i1 = -1;
    }
  }
  
  private boolean c()
  {
    aysq localaysq = (aysq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    localaysq.a(100601, false);
    localaysq.a(10016, false);
    localaysq.a(10015, false);
    RedTouchItem localRedTouchItem = localaysq.a(-7);
    if (localaysq.a(localRedTouchItem, true)) {}
    try
    {
      aj();
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_type.set(0);
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_content.set("");
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_desc.set("");
      label107:
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
      break label107;
    }
    return true;
  }
  
  private boolean d()
  {
    bhhz.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (aysq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    RedTouchItem localRedTouchItem = ((aysq)localObject).a(-4);
    if ((((aysq)localObject).a(localRedTouchItem, true)) && (localRedTouchItem.count > 0))
    {
      try
      {
        localObject = bhmi.a(aysp.a(-4));
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
    long l1 = biik.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_last_request_success_time", 0L);
    int i1 = biik.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_vip_sync_freq", 0);
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
      ((TextView)localObject1).setBackgroundResource(2130844725);
      paramString = new FrameLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1, paramString);
      this.jdField_o_of_type_AndroidViewView = ((View)localObject1);
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void g(String paramString)
  {
    boolean bool1;
    boolean bool2;
    label84:
    int i2;
    label97:
    long l1;
    int i4;
    boolean bool3;
    Object localObject;
    int i1;
    String str;
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null))
      {
        if (!QLog.isColorLevel()) {
          break label1651;
        }
        QLog.d("QQSettingRedesign", 2, "updateQQLevelVipView card == null");
        return;
      }
      localSpannableStringBuilder = new SpannableStringBuilder();
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bSuperVipOpen != 1) {
        break label1051;
      }
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bQQVipOpen != 1) {
        break label1057;
      }
      bool2 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bBigClubVipOpen != 1) {
        break label1063;
      }
      i2 = 1;
      l1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.uCurMulType;
      i4 = this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQVipLevel;
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + i4 + ",QQLevel=" + this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel + ",curMulType =" + this.jdField_a_of_type_ComTencentMobileqqDataCard.uCurMulType);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      bool3 = bhty.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType);
      localObject = null;
      i1 = 0;
      if (!bool3) {
        break label1652;
      }
      localObject = bhty.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, bhtz.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType), bhty.b(this.jdField_a_of_type_ComTencentMobileqqDataCard.grayNameplateFlag));
      i1 = bhty.a(bhtz.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType));
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
      paramString = bhty.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
      i1 = 2130847070;
      i2 = 1;
      localObject = str;
    }
    for (;;)
    {
      label345:
      int i3 = i1;
      str = paramString;
      if (!bool3)
      {
        i3 = i1;
        str = paramString;
        if (i2 == 0)
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label1445;
          }
          QLog.e("QQSettingRedesign", 1, (String)localObject);
          label383:
          if (!bool1) {
            break label1476;
          }
          i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_SUPERVIP);
          str = bhty.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
          i3 = 2130847071;
        }
      }
      label437:
      if ((str != null) && (i3 != 0))
      {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), this.jdField_b_of_type_AndroidWidgetImageView, str, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(i3));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131715588));
        this.jdField_b_of_type_AndroidWidgetImageView.setFocusableInTouchMode(true);
        paramString = bhua.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, "VIA_SETTINGME");
        paramString.a();
        this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(paramString);
        if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0)
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298369);
          this.jdField_f_of_type_Int = (bdep.jdField_a_of_type_Int - bdep.a(94.0F) - i1 - bdep.a(45.0F) - bdep.a(45.0F));
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_f_of_type_Int);
        }
        if (bias.a().a(bool1, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingLoginTime)) {
          localSpannableStringBuilder.append(bhih.a(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView, localResources, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDanDisplatSwitch));
        }
        i2 = 0;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMedalList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() <= 0)) {
          break label1573;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setData(this.jdField_a_of_type_ComTencentMobileqqDataMedalList);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
          break label1550;
        }
        this.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#7bffffff"));
        label738:
        i2 = this.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() * zps.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 21.0F) - zps.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 6.0F);
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.", 1, "width =" + i2 + "update medal:" + this.jdField_a_of_type_ComTencentMobileqqDataMedalList.convert());
        }
        i1 = i2;
        if (!this.jdField_e_of_type_Boolean)
        {
          this.jdField_e_of_type_Boolean = true;
          i1 = aokv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X800A126", 0, 0, String.valueOf(i1), "", "", "");
          i1 = i2;
        }
        label884:
        localSpannableStringBuilder.append(bhih.a(localResources, this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType, this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel, a(i1)));
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setContentDescription("等级：" + this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
        a(bool1, bool2, i4);
        if (!AppSetting.jdField_c_of_type_Boolean) {
          break label1651;
        }
        paramString = new StringBuilder();
        paramString.append(this.jdField_a_of_type_JavaLangString);
        if (!bool1) {
          break label1623;
        }
        paramString.append("你是尊贵的超级会员");
        label1005:
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel > 0) {
          paramString.append(" 等级").append(this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
        }
        this.jdField_a_of_type_AndroidViewView.setContentDescription(paramString.toString());
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label84;
        i2 = 0;
        break label97;
        str = "occur error: curMulType=" + l1 + " but bQQVipOpen is false";
        i2 = 0;
        paramString = (String)localObject;
        localObject = str;
        continue;
      }
      label534:
      label1051:
      label1057:
      label1573:
      for (;;)
      {
        label1063:
        label1109:
        if (bool1)
        {
          i2 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_SUPERVIP);
          if ((i2 & 0xF) != 1) {
            break label1712;
          }
          i1 = 1;
          label1142:
          paramString = bhty.a((i2 & 0xF) << 8 | i2 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
          if (i1 == 0) {
            break label1717;
          }
          i1 = 2130847071;
          break label1703;
        }
        str = "occur error: curMulType=" + l1 + " but bSuperVipOpen is false";
        i2 = 0;
        paramString = (String)localObject;
        localObject = str;
        break label345;
        label1445:
        label1476:
        label1623:
        label1651:
        label1652:
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
                  paramString = bhty.a((i1 & 0xF) << 8 | i1 >> 8, this.jdField_a_of_type_ComTencentMobileqqDataCard.iBigClubVipLevel, this.jdField_a_of_type_ComTencentMobileqqDataCard.lBigClubTemplateId);
                  i1 = 2130847071;
                  break label1724;
                }
                i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
                paramString = bhty.a((i1 & 0xF) << 8 | i1 >> 8, this.jdField_a_of_type_ComTencentMobileqqDataCard.iBigClubVipLevel, this.jdField_a_of_type_ComTencentMobileqqDataCard.lBigClubTemplateId);
                i1 = 2130847069;
                break label1724;
              }
              str = "occur error: curMulType=" + l1 + " but bBigClubVipOpen userStatus=" + i2;
              i2 = i1;
              paramString = (String)localObject;
              localObject = str;
              i1 = i3;
              break label1735;
            }
            str = "occur error: curMulType=" + l1 + " but bBigClubVipOpen is false";
            i2 = 0;
            paramString = (String)localObject;
            localObject = str;
            break label345;
            QLog.e("QQSettingRedesign", 1, "it have not handle curMulType=" + l1);
            break label383;
            i3 = i1;
            str = paramString;
            if (!bool2) {
              break label437;
            }
            i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_QQVIP);
            str = bhty.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
            i3 = 2130847070;
            break label437;
            this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(null);
            break label534;
            this.jdField_c_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166445));
            break label738;
            this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setVisibility(8);
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            i1 = i2;
            if (!QLog.isColorLevel()) {
              break label884;
            }
            QLog.d("QVipSettingMe.", 1, "medal list is null");
            i1 = i2;
            break label884;
            if (!bool2) {
              break label1005;
            }
            paramString.append("你是尊贵的会员");
            break label1005;
          }
          do
          {
            i2 = 0;
            paramString = (String)localObject;
            localObject = str;
            break;
            return;
            i3 = 0;
            str = null;
          } while (bool3);
          if ((l1 == 1L) || (l1 == 2L)) {
            break;
          }
          if (l1 == 3L) {
            break label1109;
          }
        } while (l1 != 4L);
      }
      for (;;)
      {
        label1550:
        label1703:
        i2 = 1;
        localObject = str;
        break;
        label1712:
        i1 = 0;
        break label1142;
        label1717:
        i1 = 2130847069;
      }
      label1724:
      localObject = null;
      i3 = 1;
      i2 = i1;
      i1 = i3;
      label1735:
      i3 = i1;
      i1 = i2;
      i2 = i3;
    }
  }
  
  private void h(String paramString)
  {
    long l1 = System.currentTimeMillis();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(100400));
    Object localObject;
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.exposure_max.get() >= 0)) {
      localObject = localAppInfo.buffer.get();
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      int i2;
      try
      {
        localObject = new JSONObject((String)localObject).optString("_jump_url");
        localStringBuilder = new StringBuilder();
        i2 = bhnv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label498;
        }
        localObject = this.jdField_c_of_type_JavaLangString;
        i1 = 1;
        if (((String)localObject).contains("?")) {
          break label452;
        }
        localStringBuilder.append((String)localObject + "?platform=1&type=20001&networkInfo=" + i2);
        localObject = localStringBuilder.toString();
        localObject = ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a((String)localObject, localAppInfo);
        if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() == 0) || (localAppInfo.type.get() != 0)) {
          break label492;
        }
        bool = true;
        if ((paramString == null) || (i1 == 0)) {
          break label486;
        }
        paramString = (String)localObject + paramString;
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
        ((Intent)localObject).putExtra("startOpenPageTime", l1);
        ((Intent)localObject).putExtra("portraitOnly", true);
        ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("has_red_dot", bool);
        ((Intent)localObject).putExtra("leftBtnText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131689501));
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, 256L, (Intent)localObject, false, -1);
        paramString = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler gotoOpenCenterBrowser");
        paramString.a(100400, 31);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("QQSettingRedesign", 2, "parse json exception " + localException);
      }
      String str = "";
      continue;
      label452:
      localStringBuilder.append(str + "&platform=1&type=20001&networkInfo=" + i2);
      continue;
      label486:
      paramString = str;
      continue;
      label492:
      boolean bool = false;
      continue;
      label498:
      int i1 = 0;
    }
  }
  
  private void i(String paramString)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  void A()
  {
    this.jdField_a_of_type_Bbvd = ((bbvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15));
    if (this.jdField_a_of_type_Bbvd == null)
    {
      QLog.e("QQSettingRedesign", 1, "preLoadSignature, mStatusManager == null");
      return;
    }
    ImageView localImageView1 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131376628);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131376629);
    ImageView localImageView2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368229);
    localImageView2.setColorFilter(localTextView.getCurrentTextColor());
    Object localObject1 = new StringBuilder(100);
    label117:
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
        break label508;
      }
      localImageView1.setImageBitmap(this.jdField_a_of_type_Bbvd.a(i1, 200));
      localImageView1.setVisibility(0);
      ((StringBuilder)localObject1).append(str1);
      if (!TextUtils.isEmpty(str2)) {
        ((StringBuilder)localObject1).append(str2);
      }
      ((StringBuilder)localObject1).append(' ');
      label372:
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label537;
      }
      if (!TextUtils.isEmpty(str4)) {
        ((StringBuilder)localObject1).append(str4);
      }
      if (!TextUtils.isEmpty(str3)) {
        ((StringBuilder)localObject1).append(str3);
      }
      label412:
      localObject1 = ((StringBuilder)localObject1).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label548;
      }
      localTextView.setText(2131698338);
      localImageView2.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
        this.jdField_a_of_type_JavaLangStringBuilder.append("个性签名").append((String)localObject1);
        this.jdField_e_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
      if (!bdgb.b()) {
        break;
      }
      localImageView1.setVisibility(8);
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label117;
      label508:
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130846080);
      localImageView1.setVisibility(8);
      break label372;
      label537:
      ((StringBuilder)localObject1).append((String)localObject2);
      break label412;
      label548:
      localImageView2.setVisibility(0);
      if (bhlo.b()) {
        localTextView.setText((String)localObject1 + " ");
      } else {
        localTextView.setText((CharSequence)localObject1);
      }
    }
  }
  
  protected void B()
  {
    try
    {
      a(4, this.jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void C()
  {
    D();
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void D()
  {
    localObject8 = null;
    Object localObject14 = null;
    String str1 = null;
    localObject13 = null;
    Object localObject15 = null;
    Object localObject16 = null;
    localObject1 = anzj.a(2131709640);
    i1 = 0;
    int i3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298369);
    int i4 = bdep.jdField_a_of_type_Int;
    int i5 = bdep.a(65.0F);
    int i6 = bdep.a(15.0F);
    int i7 = this.jdField_f_of_type_AndroidWidgetImageView.getWidth();
    localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    l1 = localSharedPreferences.getLong("sign_in_time_stamp", 0L);
    str2 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_info", "");
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
        label776:
        label1048:
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "doUpdateDailySignInItemView JSONException, json = " + str2);
        }
        localJSONException1.printStackTrace();
        continue;
        localObject3 = null;
        i1 = 0;
        Object localObject5 = localObject1;
        localObject9 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_operation" + "10", "");
        localObject5 = localObject1;
        Object localObject7 = localObject1;
        Object localObject4;
        if (!TextUtils.isEmpty((CharSequence)localObject9))
        {
          localObject5 = localObject1;
          localObject3 = new JSONObject((String)localObject9);
          i1 = 0;
          continue;
          localObject5 = localObject1;
          localObject1 = anzj.a(2131709633);
          localObject5 = localObject1;
          localObject3 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_operation" + "41", "");
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
              localObject9 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_operation" + "40", "");
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
            localObject9 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_operation" + "40", "");
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
                localObject1 = anzj.a(2131709640);
                localObject5 = null;
                localObject4 = null;
                continue;
              }
              if (this.jdField_b_of_type_Int == 4)
              {
                localObject1 = anzj.a(2131709633);
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
                    localObject4 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130846101);
                    if (localObject4 == null) {
                      break label2054;
                    }
                    localObject7 = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), blgs.a((Bitmap)localObject4));
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
                  this.jdField_b_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
                  continue;
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
        localObject1 = localJSONException4;
        continue;
        int i2 = i1;
      }
    }
    if (!a(l1 * 1000L))
    {
      this.jdField_b_of_type_Int = 1;
      i2 = 0;
      if (aobf.a() != 1033)
      {
        localObject5 = localObject1;
        try
        {
          if (this.jdField_b_of_type_Int == 1)
          {
            localObject5 = localObject1;
            localObject2 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_operation" + "11", "");
            localObject5 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject5 = localObject1;
              localObject2 = new JSONObject((String)localObject2);
              localObject5 = localObject1;
              l1 = ((JSONObject)localObject2).optInt("start_time");
              localObject5 = localObject1;
              l2 = ((JSONObject)localObject2).optInt("end_time");
              i1 = 1;
              localObject5 = localObject1;
              if (System.currentTimeMillis() > l1 * 1000L)
              {
                localObject5 = localObject1;
                localObject7 = localObject1;
                if (System.currentTimeMillis() < l2 * 1000L) {
                  break label2066;
                }
              }
              localObject2 = null;
              i1 = 0;
              localObject5 = localObject1;
              localObject9 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_operation" + "10", "");
              localObject5 = localObject1;
              localObject7 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject9)) {
                break label2066;
              }
              localObject5 = localObject1;
              localObject2 = new JSONObject((String)localObject9);
              i1 = 0;
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
      else
      {
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
                break label1707;
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
            localSharedPreferences.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_jump_url", str1).commit();
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
          break label1736;
          break label1048;
          localObject4 = null;
          localObject6 = null;
          break label776;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "doUpdateDailySignInItemView type=" + this.jdField_b_of_type_Int + " iconUrl=" + (String)localObject2 + " wording=" + (String)localObject1 + " day=" + i2 + "covericonUrl" + (String)localObject5);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846101);
        localObject8 = (URLImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377717);
        localObject9 = (ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131368926);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
        {
          localObject10 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject10).mFailedDrawable = ((Drawable)localObject7);
          ((URLDrawable.URLDrawableOptions)localObject10).mLoadingDrawable = ((Drawable)localObject7);
          ((URLDrawable.URLDrawableOptions)localObject10).mRequestHeight = 56;
          ((URLDrawable.URLDrawableOptions)localObject10).mRequestWidth = 56;
          if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((blgu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) || (!this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())))
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
            localObject5 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131368995);
            if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
              break label2007;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i4 - i3 - i5 - (i6 + i7));
            if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
              break label1951;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            if (this.jdField_b_of_type_Int != 4) {
              break label1965;
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
            this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.d();
            return;
          }
        }
      }
    }
  }
  
  public void E()
  {
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.k();
    }
    if ((this.jdField_o_of_type_AndroidViewView != null) && (this.jdField_o_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      BaseApplication.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "qqsettingme_f2f_guide", 0).edit().putBoolean("qqsettingme_f2f_guide_flag", true).apply();
    }
    a(null);
  }
  
  public void F()
  {
    this.jdField_g_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.j();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    a(null);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A42B", "0X800A42B", 0, 0, "", "", "", "");
    int i1 = aokv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B178", "0X800B178", 0, 0, String.valueOf(i1), "", "", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (bico.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType))) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType != 0) {
        break label183;
      }
    }
    label183:
    for (i1 = 99999;; i1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType)
    {
      bdll.b(null, "dc00898", "", "", "qq_vip", "0X800A778", i1, 0, "", "", "", "");
      ai();
      return;
    }
  }
  
  void G()
  {
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.WebPreloadTask(this));
  }
  
  public void H()
  {
    this.jdField_a_of_type_Avsm.b();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      int i1 = 0;
      if (localIterator.hasNext())
      {
        Bitmap localBitmap = ((blqp)localIterator.next()).a();
        if (localBitmap == null) {
          break label70;
        }
        i1 = bhjx.a(localBitmap) + i1;
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
    float f1 = 1.0F;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    float f2 = ((Resources)localObject).getDimension(2131298367);
    float f3 = ((Resources)localObject).getDimension(2131298351);
    float f4 = ((Resources)localObject).getDimension(2131298355);
    float f5 = ((Resources)localObject).getDimension(2131298359);
    float f6 = ((Resources)localObject).getDimension(2131298362);
    float f7 = ((Resources)localObject).getDimension(2131298369);
    f3 = localDisplayMetrics.widthPixels - (f7 + (f3 + f4 + f5 + f6)) - paramInt;
    if (f2 <= 1.0F) {}
    for (;;)
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
      f1 = f2;
    }
  }
  
  public blqp a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (blqp)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
  
  protected String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_jump_url", "https://ti.qq.com/signin/public/index.html?_wv=1090528161&_wwv=13");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onResume!");
    }
    this.jdField_f_of_type_Boolean = false;
    v();
    bdlx.a().a("QQSettingMe");
    if (!this.jdField_d_of_type_Boolean) {
      h();
    }
    this.jdField_k_of_type_AndroidViewView.setPadding(this.jdField_k_of_type_AndroidViewView.getPaddingLeft(), bdep.a(14.0F), this.jdField_k_of_type_AndroidViewView.getPaddingRight(), this.jdField_k_of_type_AndroidViewView.getPaddingBottom());
    AbstractGifImage.resumeAll();
    AbstractVideoImage.resumeAll();
    ApngImage.playByTag(1);
    z();
    l();
    x();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.h();
    }
    try
    {
      if (((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("window")).getDefaultDisplay().getWidth() >= 480)
      {
        af();
        this.jdField_a_of_type_Amll.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      for (;;)
      {
        i();
        aj();
        n();
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if ((localObject1 != null) && (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString))) {
          ThreadManagerV2.executeOnSubThread(new QQSettingMe.4(this));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a();
          this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.e();
        }
        this.jdField_c_of_type_Boolean = true;
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
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = (wjb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
          if ((localObject2 == null) || (!((wjb)localObject2).e())) {
            break;
          }
          ((View)localObject1).setVisibility(0);
        }
        J();
        K();
        b();
        W();
        Y();
        I();
        Z();
        if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()) && (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (bdgb.b())) {
          ImmersiveUtils.a(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        }
        localObject1 = new int[15];
        Object tmp437_435 = localObject1;
        tmp437_435[0] = 2131374479;
        Object tmp443_437 = tmp437_435;
        tmp443_437[1] = 2131371646;
        Object tmp449_443 = tmp443_437;
        tmp449_443[2] = 2131371643;
        Object tmp455_449 = tmp449_443;
        tmp455_449[3] = 2131371634;
        Object tmp461_455 = tmp455_449;
        tmp461_455[4] = 2131371637;
        Object tmp467_461 = tmp461_455;
        tmp467_461[5] = 2131371642;
        Object tmp473_467 = tmp467_461;
        tmp473_467[6] = 2131371609;
        Object tmp480_473 = tmp473_467;
        tmp480_473[7] = 2131371638;
        Object tmp487_480 = tmp480_473;
        tmp487_480[8] = 2131371644;
        Object tmp494_487 = tmp487_480;
        tmp494_487[9] = 2131371645;
        Object tmp501_494 = tmp494_487;
        tmp501_494[10] = 2131371639;
        Object tmp508_501 = tmp501_494;
        tmp508_501[11] = 2131364125;
        Object tmp515_508 = tmp508_501;
        tmp515_508[12] = 2131371610;
        Object tmp522_515 = tmp515_508;
        tmp522_515[13] = 2131365227;
        Object tmp529_522 = tmp522_515;
        tmp529_522[14] = 2131371608;
        tmp529_522;
        i2 = aokv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
        i1 = 0;
        for (;;)
        {
          if (i1 >= 15) {
            return;
          }
          if ((localObject1[i1] != 2131371646) || (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() != 0)) {
            break;
          }
          localObject2 = ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(100400));
          int i3 = aokv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), RedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject2));
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C3", "0X800A8C3", i3, 0, String.valueOf(i3), "", "", "");
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
        int i2;
        int i1;
        QLog.e("QQSettingRedesign", 1, localThrowable, new Object[0]);
        continue;
        localThrowable.setVisibility(8);
        continue;
        if ((localThrowable[i1] == 2131371643) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() == 0))
        {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C4", "0X800A8C4", i2, 0, String.valueOf(i2), "", "", "");
        }
        else if ((localThrowable[i1] == 2131365227) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() == 0))
        {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C5", "0X800A8C5", i2, 0, String.valueOf(i2), this.jdField_d_of_type_JavaLangString, "", "");
        }
        else if (localThrowable[i1] == 2131374479)
        {
          QzoneConfig.getInstance();
          if (QzoneConfig.isQQCircleShowDrawTabEntrance()) {
            this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(0);
          } else {
            this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(8);
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
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
      this.jdField_a_of_type_Beih.a(paramQQAppInterface);
      l();
      z();
      V();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.i();
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
    ImageView localImageView1 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131376628);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131376629);
    ImageView localImageView2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368229);
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
      localImageView1.setImageBitmap(this.jdField_a_of_type_Bbvd.a(paramRichStatus.actionId, 200));
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
      localTextView.setText(2131698338);
      localImageView2.setVisibility(0);
    }
    for (;;)
    {
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
        this.jdField_a_of_type_JavaLangStringBuilder.append("个性签名").append(paramRichStatus);
        this.jdField_e_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
      if (bdgb.b()) {
        localImageView1.setVisibility(8);
      }
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break;
      label515:
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130846080);
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
      if (bhlo.b()) {
        localTextView.setText(new begp(paramRichStatus + " ", 1, 16));
      } else {
        localTextView.setText(new begp(paramRichStatus, 1, 16));
      }
    }
  }
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (ImmersiveUtils.isSupporImmersive() == 0) {
      return;
    }
    if (this.jdField_g_of_type_Boolean)
    {
      if ((bdgb.b()) && (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (ImmersiveUtils.isSupporImmersive() != 0))
      {
        paramBoolean = ThemeUtil.getCurrentThemeId();
        if ((bdgb.b(paramBoolean)) && (!ThemeUtil.isSimpleColrThemeStateBarUseWhite(paramBoolean)))
        {
          ImmersiveUtils.a(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
          return;
        }
        ImmersiveUtils.a(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
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
        if ((!blgu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())) {
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
      ImmersiveUtils.a(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    ImmersiveUtils.a(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
    return;
    label188:
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null))
    {
      ImmersiveUtils.a(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    if (ThemeUtil.isGoldenTheme())
    {
      ImmersiveUtils.a(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    ImmersiveUtils.a(ThemeUtil.isDartStatusBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "[showExploreBox] url:" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a(paramString);
    }
  }
  
  public void a(String paramString, blqp paramblqp)
  {
    if (paramblqp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "[storeDynamicDrawable] drawable to be stored is null");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramblqp);
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
    //   0: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc_w 281
    //   9: iconst_2
    //   10: new 294	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 3007
    //   20: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 1309	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: ldc_w 3009
    //   30: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 1309	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   37: ldc_w 3011
    //   40: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_3
    //   44: invokevirtual 569	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 440	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 1209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 290	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokevirtual 1415	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   60: astore 6
    //   62: aload_0
    //   63: getfield 639	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   66: iconst_1
    //   67: aaload
    //   68: ldc_w 739
    //   71: invokevirtual 345	android/view/View:findViewById	(I)Landroid/view/View;
    //   74: checkcast 417	android/widget/TextView
    //   77: astore 7
    //   79: aload_0
    //   80: getfield 639	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   83: iconst_1
    //   84: aaload
    //   85: ldc_w 737
    //   88: invokevirtual 345	android/view/View:findViewById	(I)Landroid/view/View;
    //   91: checkcast 511	android/widget/ImageView
    //   94: astore 8
    //   96: aload_0
    //   97: getfield 288	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   100: invokevirtual 631	com/tencent/mobileqq/app/BaseActivity:getResources	()Landroid/content/res/Resources;
    //   103: astore 9
    //   105: aload 9
    //   107: ldc_w 662
    //   110: invokevirtual 762	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   113: astore 5
    //   115: invokestatic 947	aobf:a	()Z
    //   118: ifeq +400 -> 518
    //   121: iload_1
    //   122: ifeq +238 -> 360
    //   125: invokestatic 2256	bias:a	()Lbias;
    //   128: getfield 3012	bias:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   131: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +209 -> 343
    //   137: invokestatic 2256	bias:a	()Lbias;
    //   140: getfield 3012	bias:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   143: astore 6
    //   145: aload 6
    //   147: astore 5
    //   149: aload 5
    //   151: astore 6
    //   153: aload 5
    //   155: invokevirtual 376	java/lang/String:length	()I
    //   158: bipush 8
    //   160: if_icmple +13 -> 173
    //   163: aload 5
    //   165: iconst_0
    //   166: bipush 8
    //   168: invokevirtual 3016	java/lang/String:substring	(II)Ljava/lang/String;
    //   171: astore 6
    //   173: aload 7
    //   175: aload 6
    //   177: invokevirtual 482	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   180: aload_0
    //   181: getfield 160	com/tencent/mobileqq/activity/QQSettingMe:jdField_j_of_type_Boolean	Z
    //   184: ifeq +437 -> 621
    //   187: ldc_w 3017
    //   190: istore_3
    //   191: aload 8
    //   193: iload_3
    //   194: invokevirtual 738	android/widget/ImageView:setImageResource	(I)V
    //   197: aload 6
    //   199: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifne +107 -> 309
    //   205: aload_0
    //   206: getfield 290	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   209: invokevirtual 426	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   212: ldc_w 1847
    //   215: iconst_0
    //   216: invokevirtual 1251	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   219: invokeinterface 2547 1 0
    //   224: new 294	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 1849
    //   234: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: getfield 290	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   241: invokevirtual 370	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   244: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 1851
    //   250: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokestatic 1853	aobf:a	()I
    //   256: invokevirtual 569	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: invokevirtual 440	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aload 6
    //   264: invokeinterface 2555 3 0
    //   269: invokeinterface 2558 1 0
    //   274: pop
    //   275: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +31 -> 309
    //   281: ldc_w 281
    //   284: iconst_2
    //   285: new 294	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 3019
    //   295: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 6
    //   300: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 440	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 571	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload_0
    //   310: getfield 639	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   313: iconst_1
    //   314: aaload
    //   315: iconst_0
    //   316: invokevirtual 461	android/view/View:setVisibility	(I)V
    //   319: getstatic 329	com/tencent/common/config/AppSetting:jdField_c_of_type_Boolean	Z
    //   322: ifeq +20 -> 342
    //   325: aload_0
    //   326: getfield 639	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   329: iconst_1
    //   330: aaload
    //   331: aload 6
    //   333: ldc_w 764
    //   336: invokevirtual 769	java/lang/Class:getName	()Ljava/lang/String;
    //   339: invokestatic 774	bhga:a	(Landroid/view/View;Ljava/lang/CharSequence;Ljava/lang/String;)V
    //   342: return
    //   343: aload 9
    //   345: ldc_w 3020
    //   348: invokevirtual 762	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   351: astore 6
    //   353: aload 6
    //   355: astore 5
    //   357: goto -208 -> 149
    //   360: iload_2
    //   361: ifeq +47 -> 408
    //   364: invokestatic 2256	bias:a	()Lbias;
    //   367: getfield 3022	bias:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   370: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   373: ifne +18 -> 391
    //   376: invokestatic 2256	bias:a	()Lbias;
    //   379: getfield 3022	bias:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   382: astore 6
    //   384: aload 6
    //   386: astore 5
    //   388: goto -239 -> 149
    //   391: aload 9
    //   393: ldc_w 3023
    //   396: invokevirtual 762	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   399: astore 6
    //   401: aload 6
    //   403: astore 5
    //   405: goto -256 -> 149
    //   408: aload 6
    //   410: ldc_w 3025
    //   413: iconst_0
    //   414: invokeinterface 1421 3 0
    //   419: istore 4
    //   421: iload_3
    //   422: ifgt +8 -> 430
    //   425: iload 4
    //   427: ifle +47 -> 474
    //   430: invokestatic 2256	bias:a	()Lbias;
    //   433: getfield 3026	bias:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   436: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   439: ifne +18 -> 457
    //   442: invokestatic 2256	bias:a	()Lbias;
    //   445: getfield 3026	bias:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   448: astore 6
    //   450: aload 6
    //   452: astore 5
    //   454: goto -305 -> 149
    //   457: aload 9
    //   459: ldc_w 3027
    //   462: invokevirtual 762	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   465: astore 6
    //   467: aload 6
    //   469: astore 5
    //   471: goto -322 -> 149
    //   474: invokestatic 2256	bias:a	()Lbias;
    //   477: getfield 3028	bias:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   480: invokestatic 692	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifne +18 -> 501
    //   486: invokestatic 2256	bias:a	()Lbias;
    //   489: getfield 3028	bias:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   492: astore 6
    //   494: aload 6
    //   496: astore 5
    //   498: goto -349 -> 149
    //   501: aload 9
    //   503: ldc_w 662
    //   506: invokevirtual 762	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   509: astore 6
    //   511: aload 6
    //   513: astore 5
    //   515: goto -366 -> 149
    //   518: iload_1
    //   519: ifeq +16 -> 535
    //   522: aload 9
    //   524: ldc_w 3020
    //   527: invokevirtual 762	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   530: astore 6
    //   532: goto -359 -> 173
    //   535: iload_2
    //   536: ifeq +16 -> 552
    //   539: aload 9
    //   541: ldc_w 3023
    //   544: invokevirtual 762	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   547: astore 6
    //   549: goto -376 -> 173
    //   552: aload 6
    //   554: ldc_w 3025
    //   557: iconst_0
    //   558: invokeinterface 1421 3 0
    //   563: istore 4
    //   565: iload_3
    //   566: ifgt +8 -> 574
    //   569: iload 4
    //   571: ifle +16 -> 587
    //   574: aload 9
    //   576: ldc_w 3027
    //   579: invokevirtual 762	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   582: astore 6
    //   584: goto -411 -> 173
    //   587: aload 9
    //   589: ldc_w 662
    //   592: invokevirtual 762	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   595: astore 6
    //   597: goto -424 -> 173
    //   600: astore 6
    //   602: ldc_w 281
    //   605: iconst_1
    //   606: ldc_w 3030
    //   609: aload 6
    //   611: invokestatic 1719	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   614: aload 5
    //   616: astore 6
    //   618: goto -445 -> 173
    //   621: ldc_w 3031
    //   624: istore_3
    //   625: goto -434 -> 191
    //   628: astore 5
    //   630: ldc_w 281
    //   633: iconst_1
    //   634: ldc_w 3033
    //   637: aload 5
    //   639: invokestatic 1719	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   642: goto -333 -> 309
    //   645: astore 6
    //   647: goto -45 -> 602
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	QQSettingMe
    //   0	650	1	paramBoolean1	boolean
    //   0	650	2	paramBoolean2	boolean
    //   0	650	3	paramInt	int
    //   419	151	4	i1	int
    //   113	502	5	localObject1	Object
    //   628	10	5	localException1	Exception
    //   60	536	6	localObject2	Object
    //   600	10	6	localException2	Exception
    //   616	1	6	localObject3	Object
    //   645	1	6	localException3	Exception
    //   77	97	7	localTextView	TextView
    //   94	98	8	localImageView	ImageView
    //   103	485	9	localResources	Resources
    // Exception table:
    //   from	to	target	type
    //   115	121	600	java/lang/Exception
    //   125	145	600	java/lang/Exception
    //   343	353	600	java/lang/Exception
    //   364	384	600	java/lang/Exception
    //   391	401	600	java/lang/Exception
    //   408	421	600	java/lang/Exception
    //   430	450	600	java/lang/Exception
    //   457	467	600	java/lang/Exception
    //   474	494	600	java/lang/Exception
    //   501	511	600	java/lang/Exception
    //   522	532	600	java/lang/Exception
    //   539	549	600	java/lang/Exception
    //   552	565	600	java/lang/Exception
    //   574	584	600	java/lang/Exception
    //   587	597	600	java/lang/Exception
    //   205	309	628	java/lang/Exception
    //   153	173	645	java/lang/Exception
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  int[] a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new int[] { 2130846088, 2130846103, 2130846086, 2130846099, 2130846105, 2130846107, 2130846109, 2130846059, 2130846091, 2130846084, 2130846082, 2130846089, 2130846098, 2130846055, 2130846101 };
    }
    return new int[] { 2130846088, 2130846104, 2130846087, 2130846100, 2130846106, 2130846108, 2130846110, 2130846059, 2130846092, 2130846085, 2130846082, 2130846090, 2130846098, 2130846056, 2130846101 };
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
      str = localSharedPreferences.getString("qqsettingme_f2f_guide_tip", anzj.a(2131709629));
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
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.15(this, paramString));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onPause!");
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.f();
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_Avsm.d();
    bdlx.a().b("QQSettingMe");
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
      this.jdField_a_of_type_Beih.a();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
        if (localAvatarPendantManager != null) {
          localAvatarPendantManager.c();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.g();
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anuw);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvn);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aokw);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogx);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a);
      }
      if (this.jdField_a_of_type_Bbvd != null)
      {
        this.jdField_a_of_type_Bbvd.b(this.jdField_a_of_type_Bbsw);
        this.jdField_a_of_type_Bbvd.b(this.jdField_a_of_type_Bbst);
        this.jdField_a_of_type_Bbvd.b(this.jdField_a_of_type_Bbsr);
      }
      if (this.jdField_a_of_type_Amll != null)
      {
        this.jdField_a_of_type_Amll.a(null);
        this.jdField_a_of_type_Amll = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayxl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aobk);
    }
    if (this.jdField_a_of_type_Beih != null) {
      this.jdField_a_of_type_Beih.a(this.jdField_a_of_type_Beik, false);
    }
    bias.a().b(this.jdField_a_of_type_Biau);
    abjg.a().b(this.jdField_a_of_type_Abjh);
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
      if ((AppSetting.jdField_c_of_type_Boolean) && (localStringBuilder != null)) {
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvn, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anuw, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayxl);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aokw, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogx, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aobk, true);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a);
      }
      this.jdField_a_of_type_Beih.a(this.jdField_a_of_type_Beik, true);
      this.jdField_a_of_type_Amll = ((amll)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(114));
      if (this.jdField_a_of_type_Amll != null)
      {
        this.jdField_a_of_type_Amlm = new afio(this);
        this.jdField_a_of_type_Amll.a(this.jdField_a_of_type_Amlm);
      }
      bias.a().a(this.jdField_a_of_type_Biau);
      abjg.a().a(this.jdField_a_of_type_Abjh);
    }
  }
  
  public void g()
  {
    SosoInterface.a(new afil(this, 0, true, true, 60000L, true, false, "QQSettingRedesign"));
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
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = bhdu.a().a();
    this.jdField_a_of_type_Beih = new beih(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    f();
    l();
    z();
    x();
    i();
    n();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.h();
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.opencenter.vipInfo"));
      if (TextUtils.isEmpty(bias.a().jdField_b_of_type_JavaLangString)) {
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
    ThreadManager.post(new QQSettingMe.13(this), 5, null, false);
  }
  
  public void j()
  {
    P();
    U();
    V();
    o();
    p();
    t();
    u();
    B();
    q();
    k();
    r();
    s();
    X();
    aa();
    O();
    C();
    ac();
    ak();
  }
  
  protected void k()
  {
    try
    {
      a(5, this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      ((bapy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(104)).a(this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void l()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable(bhmq.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
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
      if (!AppSetting.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Beih != null) {
      this.jdField_a_of_type_Beih.b();
    }
    Object localObject2;
    boolean bool;
    label131:
    int i1;
    label182:
    label218:
    label364:
    int i2;
    label391:
    label438:
    TextView localTextView;
    if (bdgb.b())
    {
      this.jdField_m_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_m_of_type_AndroidViewView).a(53).a();
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "ThemeDebugKeyLog:onPostThemeChanged, refresh pendant after theme changed.");
      }
      y();
      V();
      this.jdField_h_of_type_Boolean = true;
      localObject2 = ThemeUtil.getCurrentThemeInfo();
      Object localObject1 = ((Bundle)localObject2).getString("themeId");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"1000".equals(localObject1)) && (!"1103".equals(localObject1))) {
        break label605;
      }
      bool = true;
      this.jdField_j_of_type_Boolean = bool;
      a(null);
      if (!this.jdField_j_of_type_Boolean) {
        break label610;
      }
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166441);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846093);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846073);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((!blgu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) {
        break label647;
      }
      a(true);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onPostThemeChanged, color=" + i1 + ",themeid = " + (String)localObject1 + ", enginePath=" + ((Bundle)localObject2).getString("themePath"));
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(i1);
      L();
      localObject2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368229);
      if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
        break label655;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"1000".equals(localObject1))) {
        break label682;
      }
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      Z();
      ae();
      C();
      g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      Q();
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i1);
      localObject1 = a(this.jdField_j_of_type_Boolean);
      i2 = 0;
      if (i2 >= 15) {
        break label715;
      }
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[i2] != null)
      {
        localObject2 = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368926);
        ((ImageView)localObject2).setImageResource(localObject1[i2]);
        localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368995);
        if (this.jdField_j_of_type_Boolean) {
          break label694;
        }
        localTextView.setTextColor(i1);
      }
    }
    for (;;)
    {
      if ((bdgb.b()) && ("2920".equals(ThemeUtil.getCurrentThemeId()))) {
        localTextView.setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166440));
      }
      if (i2 == 10) {
        a((ImageView)localObject2, localTextView);
      }
      i2 += 1;
      break label438;
      this.jdField_m_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidViewView).a(53).a();
      break;
      label605:
      bool = false;
      break label131;
      label610:
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166442);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846097);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846072);
      break label182;
      label647:
      a(false);
      break label218;
      label655:
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i1);
      break label364;
      label682:
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      break label391;
      label694:
      localTextView.setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166440));
    }
    label715:
    ((aqib)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe onPostThemeChanged refresh because simple theme switch!");
      }
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    ((aogf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(87)).notifyUI(4, true, null);
  }
  
  public void n()
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int i1 = this.jdField_a_of_type_Beih.a();
    String str;
    if (i1 == 1) {
      if (this.jdField_j_of_type_Boolean)
      {
        localObject1 = ((Resources)localObject2).getDrawable(2130846073);
        str = ((Resources)localObject2).getString(2131698368);
        localObject2 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      if (localObject2 != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      }
      if (localObject1 != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      }
      return;
      localObject1 = ((Resources)localObject2).getDrawable(2130846072);
      break;
      if (i1 == 2)
      {
        if (this.jdField_j_of_type_Boolean) {}
        for (localObject1 = ((Resources)localObject2).getDrawable(2130846073);; localObject1 = ((Resources)localObject2).getDrawable(2130846072))
        {
          str = ((Resources)localObject2).getString(2131698368);
          localObject2 = localObject1;
          localObject1 = str;
          break;
        }
      }
      localObject2 = null;
    }
  }
  
  public void o()
  {
    boolean bool2 = true;
    boolean bool1 = bhdu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.a(bool1);
    }
    if ((!bool1) && (aodp.a(1)))
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
        this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch.c(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      }
      return;
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
        Object localObject1;
        Object localObject4;
        long l1;
        int i1;
        boolean bool;
        Object localObject5;
        Object localObject2;
        label2629:
        Object localObject3;
        switch (paramView.getId())
        {
        case 2131369184: 
        default: 
          break;
        case 2131363238: 
          if (FrameHelperActivity.b())
          {
            FrameHelperActivity.c(true);
            FrameHelperActivity.s();
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009C4E", "0X8009C4E", 0, 0, "", "", "", "");
          }
          break;
        case 2131371608: 
        case 2131371632: 
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
            if (this.jdField_b_of_type_Int == 1) {
              i("0X800ACFD");
            }
          }
          while (QLog.isColorLevel())
          {
            QLog.i("DailySignIn", 2, "mydaily onClick mDayliSignMode = " + this.jdField_b_of_type_Boolean);
            break;
            if (this.jdField_b_of_type_Int == 4)
            {
              i("0X800ACFE");
              continue;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("task_entry_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getString("jump_url", "");
              localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
              ((Intent)localObject4).putExtra("portraitOnly", true);
              ((Intent)localObject4).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              ((Intent)localObject4).putExtra("hide_operation_bar", true);
              ((Intent)localObject4).putExtra("hide_more_button", true);
              ((Intent)localObject4).putExtra("big_brother_source_key", "biz_src_ad_daka");
              ((Intent)localObject4).putExtra("url", (String)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_duty", "", "locker", "clk", 0, 0, "", "", "", "");
            }
          }
        case 2131371828: 
          localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
          ((ProfileActivity.AllInOne)localObject1).jdField_g_of_type_Int = 1;
          ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 8;
          ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (ProfileActivity.AllInOne)localObject1, 1009);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D6");
          break;
        case 2131367926: 
          localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
          ((ProfileActivity.AllInOne)localObject1).jdField_g_of_type_Int = 1;
          ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 8;
          ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (ProfileActivity.AllInOne)localObject1, 1009);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D7");
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          if (this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.b()) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X8006726");
          }
          break;
        case 2131374750: 
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          ((Intent)localObject1).putExtra("title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131715971));
          ((Intent)localObject1).putExtra("nick", bhlg.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4));
          ((Intent)localObject1).putExtra("uin", (String)localObject4);
          ((Intent)localObject1).putExtra("type", 1);
          ((Intent)localObject1).putExtra("reportFlag", 1);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055BB", "0X80055BB", 0, 0, "", "", "", "");
          break;
        case 2131371643: 
          l1 = System.currentTimeMillis();
          if (ProfileActivity.a(this.jdField_a_of_type_Long, l1))
          {
            this.jdField_a_of_type_Long = l1;
            if (QWalletHelper.isValidToLaunchQWallet(l1))
            {
              QWalletHelper.launchQWalletAct(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true);
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_wallet", "Clk_wallet", 0, 0, "", "", "", "");
              bhih.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(100007, 31);
              localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[2];
              i1 = aokv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((RedTouch)localObject1).b());
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8BF", "0X800A8BF", i1, 0, String.valueOf(i1), "", "", "");
              if (jdField_a_of_type_Int > 0) {
                DrawerFrame.jdField_a_of_type_Int = 2;
              } else {
                DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
              }
            }
          }
          break;
        case 2131371634: 
          if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()) {}
          for (bool = true;; bool = false)
          {
            bmkq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, -1, bool);
            bmky.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0);
            bmlc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(103000, 31);
            break;
          }
        case 2131371642: 
          localObject1 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          bool = false;
          localObject4 = new bmsx();
          ((bmsx)localObject4).a("443");
          ((bmsx)localObject4).b("3");
          ((bmsx)localObject4).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
          if ((this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1))
          {
            bool = true;
            ((bmsx)localObject4).c("1");
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (bmsx)localObject4);
            ((bbav)localObject1).a(100180, 31);
          }
          try
          {
            l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
            localObject5 = bmtk.a();
            ((bmtk)localObject5).jdField_a_of_type_JavaLangString = String.valueOf(l1);
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = bhlg.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            ((bmtk)localObject5).jdField_b_of_type_JavaLangString = ((String)localObject1);
            bmtd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (bmtk)localObject5, Long.valueOf(l1), 0, bool, -1);
            localObject1 = new bmsx();
            ((bmsx)localObject1).jdField_c_of_type_JavaLangString = "1";
            ((bmsx)localObject1).jdField_d_of_type_JavaLangString = "0";
            ((bmsx)localObject1).jdField_b_of_type_Int = 4;
            ((bmsx)localObject1).l = "3";
            ((bmsx)localObject1).m = "drawerAlbumList";
            ((bmsx)localObject1).n = "QZonePhotoListActivity";
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (bmsx)localObject1);
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("source_type", "3");
            ((HashMap)localObject1).put("source_from", "drawerAlbumList");
            ((HashMap)localObject1).put("source_to", "QZonePhotoListActivity");
            bdmc.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            continue;
            ((bmsx)localObject4).c("2");
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              l1 = 0L;
            }
          }
        case 2131371609: 
          localObject2 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          ((bbav)localObject2).a(100005, 31);
          if (((RedTouch)((ViewGroup)paramView).getChildAt(0)).b()) {}
          for (localObject2 = bmzn.b(((bbav)localObject2).a(String.valueOf(100005)));; localObject2 = bmzn.a("outside", "3"))
          {
            VasWebviewUtil.openIndividuationIndex(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject2);
            ThreadManager.post(new QQSettingMe.17(this), 5, null, true);
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Personality_setting", 0, 0, "", "", "", "");
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            break;
          }
        case 2131377471: 
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQSettingSettingActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          if (bhdu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004DB0", "0X8004DB0", 0, 0, "", "", bhdu.a(), "");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0)) {
            anvl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iNewTimeStamp);
          }
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
          ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(100190, 31);
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          break;
        case 2131371839: 
          if (!behm.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "", new afhs(this))) {
            T();
          }
          break;
        case 2131370260: 
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((Intent)localObject2).putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=draw");
          ((Intent)localObject2).putExtra("hide_more_button", true);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A9C3", "0X800A9C3", 0, 0, "", "", "", "");
          break;
        case 2131381298: 
          i1 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getInt("cur_adcode", 0);
          localObject2 = "mqqapi://miniapp/open?_atype=0&_mappid=1108323226&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2066&_sig=191577ab932c397857a3cb26aa1938bfa257d305ad390c43ae02ca77df0753e7&areaId=" + i1;
          MiniAppLauncher.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject2, 2066, null);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A42C", "0X800A42C", 0, 0, "", "", "", "");
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005BE4", "0X8005BE4", 0, 0, "", "", "", "");
          break;
        case 2131377712: 
          if ((this.jdField_a_of_type_Bbvd != null) && (!this.jdField_a_of_type_Bbvd.a()))
          {
            ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(100450, 31);
            if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
            {
              localObject2 = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131376629);
              if ((localObject2 != null) && (((TextView)localObject2).getText() != null))
              {
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt("from_type", 3);
                SignTextEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, "", (Bundle)localObject2, -1);
              }
            }
            DrawerFrame.jdField_a_of_type_Int = 0;
          }
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "set_enter", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D8");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X800A669");
          break;
        case 2131374479: 
          b(paramView);
          break;
        case 2131371646: 
          l1 = System.currentTimeMillis();
          if (ProfileActivity.a(this.jdField_a_of_type_Long, l1))
          {
            this.jdField_a_of_type_Long = l1;
            if (QLog.isColorLevel()) {
              QLog.i("QQSettingRedesign", 2, "enter vip");
            }
            ThreadManager.post(new QQSettingMe.19(this), 5, null, true);
            localObject2 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
            localObject4 = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[1];
            i1 = aokv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((RedTouch)localObject4).b());
            if (((RedTouch)localObject4).b()) {}
            for (localObject2 = bmzn.b(((bbav)localObject2).a(String.valueOf(100400)));; localObject2 = bmzn.a("outside", "1"))
            {
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8BE", "0X800A8BE", i1, 0, String.valueOf(i1), "", "", "");
              h((String)localObject2);
              bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
              if (jdField_a_of_type_Int <= 0) {
                break label2629;
              }
              DrawerFrame.jdField_a_of_type_Int = 2;
              break;
            }
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          }
          break;
        case 2131371637: 
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, FileAssistantActivity.class);
          ((Intent)localObject2).putExtra("from", "FileAssistant");
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          localObject2 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          localObject4 = ((bbav)localObject2).a(String.valueOf(100160));
          if ((localObject4 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() != 0)) {
            ((bbav)localObject2).a(100160, 31);
          }
          try
          {
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("service_type", 2);
            ((JSONObject)localObject5).put("act_id", 1002);
            ((bbav)localObject2).c((BusinessInfoCheckUpdate.AppInfo)localObject4, ((JSONObject)localObject5).toString());
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
        case 2131371644: 
          if (jdField_a_of_type_Int > 0) {
            DrawerFrame.jdField_a_of_type_Int = 2;
          } else {
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          }
          break;
        case 2131365227: 
          localObject5 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          localObject4 = "";
          BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbav)localObject5).a(String.valueOf(100500));
          localObject3 = localObject4;
          if (localAppInfo != null)
          {
            localObject3 = localObject4;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              localObject3 = bmzn.a(localAppInfo);
              ((bbav)localObject5).a(100500, 31);
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
          localObject3 = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[13];
          i1 = aokv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((RedTouch)localObject3).b());
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C0", "0X800A8C0", i1, 0, String.valueOf(i1), this.jdField_d_of_type_JavaLangString, "", "");
          break;
        case 2131371645: 
          QQStoryMemoriesActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, QQStoryContext.a().b(), true);
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          break;
        case 2131371639: 
          localObject3 = QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameJumpUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1108291530&_mvid=&_path=pages%2Fgame-list%2Fgame-list.html%3Fmode%3Dchouti&_vt=3&via=2066&_sig=676003338");
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (MiniAppLauncher.isMiniAppUrl((String)localObject3)) {
              MiniAppLauncher.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a((String)localObject3, this.jdField_n_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo), 2066, null);
            }
          }
          else
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (!RedTouch.a(this.jdField_n_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo)) {
              break label3395;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            bdll.b((QQAppInterface)localObject3, "dc00898", "", "", "0X800ACDD", "0X800ACDD", 0, i1, "", "", "", "");
            localObject3 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
            if (localObject3 == null) {
              break;
            }
            ((bbav)localObject3).a(100077, 31);
            break;
            localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("url", (String)localObject3);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
            break label3278;
          }
        case 2131364125: 
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
          localObject4 = ((Context)localObject3).getSharedPreferences("call_tim_config_pre" + (String)localObject4, 0).getString("call_tim_config_url", null);
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = arrk.a().a();
          }
          localObject4 = localObject3;
          if (localObject3 == null) {
            localObject4 = "https://docs.qq.com/desktop/m/index.html";
          }
          localObject3 = becb.b((String)localObject4, "s_qq_drawer");
          localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject4).putExtra("url", (String)localObject3);
          ((Intent)localObject4).putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
          ((Intent)localObject4).putExtra("tdsourcetag", "s_qq_drawer");
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800887E", "0X800887E", 0, 0, "", "", "", "");
          break;
        case 2131374473: 
          a(paramView);
          break;
        case 2131374511: 
          S();
          break;
        case 2131372246: 
          bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97F", "0X800A97F", 0, 0, "0", "0", "", "");
          break;
        case 2131371638: 
          label3395:
          i1 = awwi.a(awwi.a(this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo));
          localObject3 = (bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          localObject4 = ((bbav)localObject3).a(String.valueOf(100066));
          if ((localObject4 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() != 0))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView == null) || (this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.getVisibility() != 0)) {
              break label3780;
            }
            a("0x800AAFB", "1");
          }
          for (;;)
          {
            ((bbav)localObject3).a(100066, 31);
            awwi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2066, "10", i1 + "");
            break;
            label3780:
            a("0x800AAFB", "2");
          }
        case 2131371610: 
          label3278:
          R();
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
      a(2, this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void q()
  {
    try
    {
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_f_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void r()
  {
    try
    {
      a(3, this.jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
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
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbav)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(1000017));
      if (!((aqmx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a())
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
  
  protected void t()
  {
    try
    {
      a(6, this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1))
      {
        WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
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
  
  /* Error */
  public void u()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 290	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5: invokevirtual 961	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   8: putfield 3762	com/tencent/mobileqq/activity/QQSettingMe:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 3762	com/tencent/mobileqq/activity/QQSettingMe:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokestatic 3765	aokv:a	(Ljava/lang/String;)LMQQ/PayRuleCfg;
    //   19: putfield 1475	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   22: aload_0
    //   23: getfield 290	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: aload_0
    //   27: getfield 1475	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   30: aload_0
    //   31: getfield 2745	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   34: invokestatic 3768	aokv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;LMQQ/PayRuleCfg;Z)Z
    //   37: istore_1
    //   38: aload_0
    //   39: getfield 1475	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   42: ifnonnull +266 -> 308
    //   45: ldc_w 281
    //   48: iconst_1
    //   49: ldc_w 3770
    //   52: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iload_1
    //   56: ifeq +340 -> 396
    //   59: aload_0
    //   60: getfield 2745	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   63: ifne +59 -> 122
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 2745	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   71: aconst_null
    //   72: ldc_w 1092
    //   75: ldc 179
    //   77: ldc 179
    //   79: ldc 179
    //   81: ldc_w 3772
    //   84: aload_0
    //   85: getfield 1475	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   88: invokestatic 3775	aokv:a	(LMQQ/PayRuleCfg;)I
    //   91: iconst_1
    //   92: iconst_0
    //   93: ldc_w 1090
    //   96: aload_0
    //   97: getfield 1475	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   100: getfield 3778	MQQ/PayRuleCfg:advId	Ljava/lang/String;
    //   103: ldc 179
    //   105: ldc 179
    //   107: invokestatic 3781	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   110: bipush 101
    //   112: aload_0
    //   113: getfield 1475	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   116: getfield 3778	MQQ/PayRuleCfg:advId	Ljava/lang/String;
    //   119: invokestatic 3784	aokv:a	(ILjava/lang/String;)V
    //   122: aload_0
    //   123: invokespecial 3786	com/tencent/mobileqq/activity/QQSettingMe:ab	()V
    //   126: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +36 -> 165
    //   132: ldc_w 281
    //   135: iconst_2
    //   136: new 294	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 3788
    //   146: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: getfield 1009	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   153: invokestatic 3789	bbav:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)Ljava/lang/String;
    //   156: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 440	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 571	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: new 1057	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   168: dup
    //   169: invokespecial 1547	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   172: astore_2
    //   173: aload_2
    //   174: aload_0
    //   175: getfield 1009	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   178: invokevirtual 1550	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   181: iload_1
    //   182: ifeq +54 -> 236
    //   185: aload_2
    //   186: invokestatic 3792	com/tencent/mobileqq/redtouch/RedTouchTextView:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)Ljava/util/List;
    //   189: ifnull +47 -> 236
    //   192: new 91	java/util/ArrayList
    //   195: dup
    //   196: invokespecial 94	java/util/ArrayList:<init>	()V
    //   199: astore_3
    //   200: new 1576	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   203: dup
    //   204: invokespecial 1605	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   207: astore 4
    //   209: aload 4
    //   211: getfield 1580	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   214: iconst_0
    //   215: invokevirtual 1607	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   218: aload_3
    //   219: aload 4
    //   221: invokevirtual 1029	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   224: pop
    //   225: aload_2
    //   226: getfield 1554	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   229: getfield 1563	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   232: aload_3
    //   233: invokevirtual 1604	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   236: aload_0
    //   237: iconst_1
    //   238: aload_2
    //   239: invokespecial 1085	com/tencent/mobileqq/activity/QQSettingMe:a	(ILcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   242: aload_0
    //   243: getfield 290	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   246: ifnull +61 -> 307
    //   249: aload_0
    //   250: getfield 1009	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   253: ifnull +163 -> 416
    //   256: aload_0
    //   257: getfield 1009	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   260: getfield 1196	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   263: invokevirtual 1201	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   266: iconst_1
    //   267: if_icmpeq +6 -> 273
    //   270: goto +146 -> 416
    //   273: ldc_w 281
    //   276: iconst_1
    //   277: ldc_w 3794
    //   280: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: new 1217	android/content/Intent
    //   286: dup
    //   287: aload_0
    //   288: getfield 288	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   291: ldc_w 3796
    //   294: invokespecial 1222	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   297: astore_2
    //   298: aload_0
    //   299: getfield 288	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   302: aload_2
    //   303: invokevirtual 3800	com/tencent/mobileqq/app/BaseActivity:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   306: pop
    //   307: return
    //   308: ldc_w 281
    //   311: iconst_1
    //   312: new 294	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 3802
    //   322: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_0
    //   326: getfield 1475	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   329: getfield 1799	MQQ/PayRuleCfg:iconText	Ljava/lang/String;
    //   332: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc_w 3804
    //   338: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: iload_1
    //   342: invokevirtual 1309	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   345: ldc_w 3806
    //   348: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_0
    //   352: getfield 1475	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   355: getfield 1802	MQQ/PayRuleCfg:iconUrl	Ljava/lang/String;
    //   358: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc_w 3808
    //   364: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: getfield 2745	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   371: invokevirtual 1309	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   374: invokevirtual 440	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: goto -325 -> 55
    //   383: astore_2
    //   384: ldc_w 281
    //   387: iconst_1
    //   388: ldc_w 3810
    //   391: aload_2
    //   392: invokestatic 1719	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   395: return
    //   396: aload_0
    //   397: invokevirtual 3813	com/tencent/mobileqq/activity/QQSettingMe:w	()V
    //   400: goto -274 -> 126
    //   403: astore_2
    //   404: ldc_w 281
    //   407: iconst_2
    //   408: ldc_w 3815
    //   411: aload_2
    //   412: invokestatic 1719	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   415: return
    //   416: iload_1
    //   417: ifeq -110 -> 307
    //   420: goto -147 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	QQSettingMe
    //   37	380	1	bool	boolean
    //   172	131	2	localObject	Object
    //   383	9	2	localException	Exception
    //   403	9	2	localThrowable	Throwable
    //   199	34	3	localArrayList	ArrayList
    //   207	13	4	localRedTypeInfo	BusinessInfoCheckUpdate.RedTypeInfo
    // Exception table:
    //   from	to	target	type
    //   0	55	383	java/lang/Exception
    //   59	122	383	java/lang/Exception
    //   122	126	383	java/lang/Exception
    //   126	165	383	java/lang/Exception
    //   165	181	383	java/lang/Exception
    //   185	236	383	java/lang/Exception
    //   236	270	383	java/lang/Exception
    //   273	298	383	java/lang/Exception
    //   298	307	383	java/lang/Exception
    //   308	380	383	java/lang/Exception
    //   396	400	383	java/lang/Exception
    //   404	415	383	java/lang/Exception
    //   298	307	403	java/lang/Throwable
  }
  
  public void v()
  {
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler payRuleUin changed");
      w();
    }
  }
  
  public void w()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131368978);
    localTextView.setText("");
    localTextView.setBackgroundDrawable(null);
  }
  
  public void x()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.24(this));
  }
  
  public void y()
  {
    ExtensionInfo localExtensionInfo = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (bdgb.b())
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    label234:
    for (;;)
    {
      return;
      Object localObject;
      if ((!this.jdField_i_of_type_Boolean) && (localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
      {
        localObject = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
        ((AvatarPendantManager)localObject).b();
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        localObject = ((AvatarPendantManager)localObject).a(localExtensionInfo.pendantId);
        if (bhkt.a(localExtensionInfo.pendantId))
        {
          ((PendantInfo)localObject).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.jdField_h_of_type_Int, localExtensionInfo.uin, localExtensionInfo.pendantDiyId);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarPendant", "choutishow", 0, 0, "", "", "", "");
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if ((i1 != 1) || (i1 != this.jdField_i_of_type_Boolean)) {
          break label234;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X8006728");
        return;
        ((PendantInfo)localObject).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.jdField_h_of_type_Int, localExtensionInfo.uin, localExtensionInfo.pendantDiyId);
        break;
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  public void z()
  {
    this.jdField_a_of_type_Bbvd = ((bbvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15));
    if ((this.jdField_a_of_type_Bbvd == null) || (this.jdField_e_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_Bbsw == null)
    {
      this.jdField_a_of_type_Bbsw = new afhw(this);
      this.jdField_a_of_type_Bbst = new afhx(this);
      this.jdField_a_of_type_Bbsr = new afhy(this);
      this.jdField_a_of_type_Bbvd.a(this.jdField_a_of_type_Bbsw);
      this.jdField_a_of_type_Bbvd.a(this.jdField_a_of_type_Bbst);
      this.jdField_a_of_type_Bbvd.a(this.jdField_a_of_type_Bbsr);
    }
    RichStatus localRichStatus = this.jdField_a_of_type_Bbvd.a(false);
    if ((localRichStatus == null) || (localRichStatus.isEmpty()))
    {
      ThreadManager.getFileThreadHandler().post(new QQSettingMe.28(this));
      return;
    }
    a(localRichStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import MQQ.PayRuleCfg;
import QQService.EVIPSPEC;
import abmh;
import abmi;
import abmj;
import abmk;
import abml;
import abmm;
import abmn;
import abmo;
import abmp;
import abmq;
import abmr;
import abms;
import abmt;
import abmu;
import abmv;
import abmw;
import abmx;
import abmy;
import abmz;
import abnb;
import abnc;
import abnd;
import ahye;
import ahyf;
import ajfi;
import ajfo;
import ajgd;
import ajgf;
import ajjh;
import ajjj;
import ajjy;
import ajlo;
import ajop;
import ajqy;
import ajrp;
import ajve;
import ajvf;
import akgo;
import alkl;
import alov;
import amis;
import amms;
import ammt;
import amxi;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import aqeb;
import ataw;
import atax;
import atbe;
import atdh;
import aufu;
import auqh;
import avci;
import avck;
import avcn;
import avev;
import awao;
import awmc;
import awnu;
import awqx;
import awri;
import awrn;
import axfs;
import axkd;
import axkz;
import axlu;
import axlx;
import axwe;
import azve;
import azwp;
import azyk;
import azys;
import azzz;
import baau;
import babh;
import babp;
import bace;
import bacm;
import badq;
import bajr;
import bant;
import bapw;
import bapy;
import baqv;
import baub;
import bbmy;
import bees;
import beeu;
import beom;
import bfhn;
import bfhz;
import bfid;
import bfpl;
import bfpr;
import bfpy;
import bfvl;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.apollo.SettingMeApolloViewController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Config;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
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
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;
import com.tencent.mobileqq.webview.sonic.SonicPreloader;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.FixedBounceScrollView;
import com.tencent.mobileqq.widget.QVipMedalView;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QZoneClickReport;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import mjg;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;
import sga;
import tencent.im.oidb.redInfo.RedInfo;
import vms;
import xfz;
import xga;

public class QQSettingMe
  implements View.OnClickListener, View.OnTouchListener
{
  public static int a;
  private static List<String> jdField_a_of_type_JavaUtilList;
  private static List<String> jdField_b_of_type_JavaUtilList;
  protected long a;
  private PayRuleCfg jdField_a_of_type_MQQPayRuleCfg;
  private ahye jdField_a_of_type_Ahye;
  private ahyf jdField_a_of_type_Ahyf = new abmz(this);
  ajfo jdField_a_of_type_Ajfo = new abmt(this);
  private ajgf jdField_a_of_type_Ajgf = new abmr(this);
  private ajjh jdField_a_of_type_Ajjh = new abmu(this);
  private ajrp jdField_a_of_type_Ajrp = new abmw(this);
  private ajvf jdField_a_of_type_Ajvf = new abmq(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new abnc(this);
  Handler jdField_a_of_type_AndroidOsHandler = new abmy(this, Looper.getMainLooper());
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new abml(this);
  protected View a;
  public ViewGroup a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  private aqeb jdField_a_of_type_Aqeb = new aqeb("QQSetting_me", "com.tencent.mobileqq:tool");
  private atdh jdField_a_of_type_Atdh = new abmp(this);
  private avci jdField_a_of_type_Avci;
  private avck jdField_a_of_type_Avck;
  private avcn jdField_a_of_type_Avcn;
  private avev jdField_a_of_type_Avev;
  private axlu jdField_a_of_type_Axlu;
  axlx jdField_a_of_type_Axlx = new abmv(this);
  private bapy jdField_a_of_type_Bapy = new abmx(this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private SettingMeApolloViewController jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController;
  public BaseActivity a;
  private FrameHelperActivity jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
  public QQAppInterface a;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  protected DynamicAvatarView a;
  public Card a;
  private MedalList jdField_a_of_type_ComTencentMobileqqDataMedalList;
  protected RedTouch a;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
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
  private ConcurrentHashMap<String, beom> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private redInfo.RedInfo jdField_a_of_type_TencentImOidbRedInfo$RedInfo;
  public xga a;
  protected boolean a;
  public View[] a;
  protected RedTouch[] a;
  protected RedTouchTextView[] a;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  public Handler b;
  protected View b;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  public ImageView b;
  protected LinearLayout b;
  public TextView b;
  protected RedTouch b;
  BusinessInfoCheckUpdate.AppInfo jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private String jdField_b_of_type_JavaLangString;
  protected boolean b;
  private int jdField_c_of_type_Int;
  protected View c;
  protected ImageView c;
  public LinearLayout c;
  protected TextView c;
  protected RedTouch c;
  BusinessInfoCheckUpdate.AppInfo jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private String jdField_c_of_type_JavaLangString = "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1";
  public boolean c;
  private int jdField_d_of_type_Int;
  protected View d;
  protected ImageView d;
  public TextView d;
  protected RedTouch d;
  BusinessInfoCheckUpdate.AppInfo jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  public boolean d;
  private final int jdField_e_of_type_Int = 0;
  protected View e;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  protected TextView e;
  protected RedTouch e;
  BusinessInfoCheckUpdate.AppInfo jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  protected boolean e;
  private final int jdField_f_of_type_Int = 1;
  protected View f;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  public TextView f;
  BusinessInfoCheckUpdate.AppInfo jdField_f_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private boolean jdField_f_of_type_Boolean;
  protected View g;
  public TextView g;
  BusinessInfoCheckUpdate.AppInfo jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private boolean jdField_g_of_type_Boolean;
  protected View h;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  BusinessInfoCheckUpdate.AppInfo jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private boolean jdField_h_of_type_Boolean;
  protected View i;
  BusinessInfoCheckUpdate.AppInfo jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
  private boolean jdField_i_of_type_Boolean;
  protected View j;
  BusinessInfoCheckUpdate.AppInfo jdField_j_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
  private boolean jdField_j_of_type_Boolean = true;
  private View jdField_k_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_k_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private boolean jdField_k_of_type_Boolean;
  private View jdField_l_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_l_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private View m;
  private View n;
  private View o;
  
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
    this.jdField_a_of_type_Xga = new abnd(this);
    this.jdField_b_of_type_AndroidOsHandler = new abmh(this, Looper.getMainLooper());
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->QQSettingMe construct!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = paramFrameHelperActivity;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131495495, null));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301798);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(ajjy.a(2131644968));
    }
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301766));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131297539));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131301811);
    this.m = this.jdField_a_of_type_AndroidViewView.findViewById(2131310433);
    paramFrameHelperActivity = paramQQAppInterface.getCurrentAccountUin();
    label682:
    Object localObject1;
    Object localObject2;
    String str;
    boolean bool;
    if ((paramFrameHelperActivity == null) || (paramFrameHelperActivity.length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130839687);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131305160).setOnClickListener(this);
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131167157);
      this.jdField_c_of_type_Int = (awmc.jdField_a_of_type_Int - awmc.a(94.0F) - i1 - awmc.a(45.0F));
      this.jdField_d_of_type_Int = (awmc.jdField_a_of_type_Int - awmc.a(94.0F) - i1 - awmc.a(20.0F));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305159));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramFrameHelperActivity);
      if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim()))) {
        this.jdField_a_of_type_JavaLangString = paramFrameHelperActivity;
      }
      if (!awnu.b()) {
        break label2175;
      }
      this.m.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.m).a(53).a();
      this.jdField_b_of_type_AndroidViewView.setVisibility(VasFaceManager.a(paramFrameHelperActivity, paramQQAppInterface));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305669));
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView = ((QVipMedalView)this.jdField_a_of_type_AndroidViewView.findViewById(2131307431));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131307337);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131307338);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313431));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131307458));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText("");
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297454));
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297452));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131307692));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301076));
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        paramBaseActivity.topMargin = (awmc.a(29.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "Change mBackWrapper topMargin=" + paramBaseActivity.topMargin);
        }
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setLayoutParams(paramBaseActivity);
      }
      this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(this);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304967));
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBaseActivity.topMargin = (awmc.a(35.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBaseActivity);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131310408)).a(53).a();
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131310402);
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_e_of_type_AndroidViewView).b(10).a(19).a();
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView.setOnTouchListener(mjg.a);
      this.jdField_l_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131306295);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView = ((FixedBounceScrollView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304453));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setDamping(2.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setBounceDelay(600L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setmCustomTopFadingEdgeScale(0.675F);
      i1 = (int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131167151);
      paramBaseActivity = this.jdField_a_of_type_AndroidViewViewGroup.getResources();
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[11];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch = new RedTouch[11];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView = new RedTouchTextView[11];
      paramFrameHelperActivity = new int[11];
      FrameHelperActivity tmp1316_1315 = paramFrameHelperActivity;
      tmp1316_1315[0] = 2131304980;
      FrameHelperActivity tmp1322_1316 = tmp1316_1315;
      tmp1322_1316[1] = 2131304977;
      FrameHelperActivity tmp1328_1322 = tmp1322_1316;
      tmp1328_1322[2] = 2131304969;
      FrameHelperActivity tmp1334_1328 = tmp1328_1322;
      tmp1334_1328[3] = 2131304972;
      FrameHelperActivity tmp1340_1334 = tmp1334_1328;
      tmp1340_1334[4] = 2131304976;
      FrameHelperActivity tmp1346_1340 = tmp1340_1334;
      tmp1346_1340[5] = 2131304944;
      FrameHelperActivity tmp1352_1346 = tmp1346_1340;
      tmp1352_1346[6] = 2131304978;
      FrameHelperActivity tmp1359_1352 = tmp1352_1346;
      tmp1359_1352[7] = 2131304979;
      FrameHelperActivity tmp1366_1359 = tmp1359_1352;
      tmp1366_1359[8] = 2131298268;
      FrameHelperActivity tmp1373_1366 = tmp1366_1359;
      tmp1373_1366[9] = 2131299298;
      FrameHelperActivity tmp1380_1373 = tmp1373_1366;
      tmp1380_1373[10] = 2131304943;
      tmp1380_1373;
      localObject1 = new int[11];
      Object tmp1396_1394 = localObject1;
      tmp1396_1394[0] = 2131633645;
      Object tmp1402_1396 = tmp1396_1394;
      tmp1402_1396[1] = 2131633659;
      Object tmp1408_1402 = tmp1402_1396;
      tmp1408_1402[2] = 2131633671;
      Object tmp1414_1408 = tmp1408_1402;
      tmp1414_1408[3] = 2131633644;
      Object tmp1420_1414 = tmp1414_1408;
      tmp1420_1414[4] = 2131633687;
      Object tmp1426_1420 = tmp1420_1414;
      tmp1426_1420[5] = 2131633623;
      Object tmp1432_1426 = tmp1426_1420;
      tmp1432_1426[6] = 2131633666;
      Object tmp1439_1432 = tmp1432_1426;
      tmp1439_1432[7] = 2131633633;
      Object tmp1446_1439 = tmp1439_1432;
      tmp1446_1439[8] = 2131633614;
      Object tmp1453_1446 = tmp1446_1439;
      tmp1453_1446[9] = 2131633615;
      Object tmp1460_1453 = tmp1453_1446;
      tmp1460_1453[10] = 2131633643;
      tmp1460_1453;
      localObject2 = ThemeUtil.getCurrentThemeInfo();
      str = ((Bundle)localObject2).getString("themeId");
      if ((!TextUtils.isEmpty(str)) && (!"1000".equals(str)) && (!"1103".equals(str))) {
        break label2211;
      }
      bool = true;
      label1516:
      this.jdField_j_of_type_Boolean = bool;
      if (!this.jdField_j_of_type_Boolean) {
        break label2217;
      }
    }
    label2211:
    label2217:
    for (int i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131100723);; i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131100724))
    {
      int[] arrayOfInt = a(this.jdField_j_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe_init, color=" + i1 + ",themeid = " + str + ", enginePath=" + ((Bundle)localObject2).getString("themePath"));
      }
      int i3 = awmc.a(2.0F);
      localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131304453);
      this.jdField_k_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.findViewById(2131304454);
      int i2 = 0;
      while (i2 < 11)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2] = ((View)localObject2).findViewById(paramFrameHelperActivity[i2]);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setFocusable(true);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(0);
        if (paramFrameHelperActivity[i2] == 2131304978) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
        }
        if (paramFrameHelperActivity[i2] == 2131304979) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
        }
        if (paramFrameHelperActivity[i2] == 2131298268) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
        }
        if (paramFrameHelperActivity[i2] == 2131304943)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ArrayOfAndroidViewView[i2]);
          this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setOnClickListener(this);
        ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131302723)).setImageResource(arrayOfInt[i2]);
        Object localObject3 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131302761);
        ((TextView)localObject3).setText(localObject1[i2]);
        if (!this.jdField_j_of_type_Boolean) {
          ((TextView)localObject3).setTextColor(i1);
        }
        if ((awnu.b()) && ("2920".equals(ThemeUtil.getCurrentThemeId()))) {
          ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131100722));
        }
        localObject3 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131302745);
        ((ThemeLabelTextView)localObject3).setSupportMaskView(true);
        ((TextView)localObject3).setVisibility(0);
        azve.a(this.jdField_a_of_type_ArrayOfAndroidViewView[i2], paramBaseActivity.getString(localObject1[i2]), Button.class.getName());
        localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131302723);
        ((View)localObject3).setPadding(i3, i3, i3, i3);
        Object localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject4).leftMargin -= i3;
        localObject4 = (RedTouchTextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131302761);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((RedTouchTextView)localObject4).getLayoutParams();
        localLayoutParams.leftMargin -= i3;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i2] = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject3).a(53).a();
        this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[i2] = localObject4;
        if (paramFrameHelperActivity[i2] == 2131304943) {
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i2];
        }
        i2 += 1;
      }
      localObject1 = paramQQAppInterface.a(paramQQAppInterface.a(1, paramFrameHelperActivity, (byte)3, 0, 100, true));
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageBitmap((Bitmap)localObject1);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130839687);
      break;
      label2175:
      this.m.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.jdField_b_of_type_AndroidViewView).a(53).a();
      break label682;
      bool = false;
      break label1516;
    }
    X();
    A();
    L();
    this.jdField_i_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302919);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    if ((TextUtils.isEmpty(str)) || ("1000".equals(str)))
    {
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297808);
      this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131310219);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this);
      azve.a(this.jdField_g_of_type_AndroidViewView, ajjy.a(2131644962), Button.class.getName());
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131310221));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131307388));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131310220));
      this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView).a();
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131305169);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this);
      azve.a(this.jdField_f_of_type_AndroidViewView, ajjy.a(2131644945), Button.class.getName());
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131305171));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131305170));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[5].findViewById(2131302714));
      this.n = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303781);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131312544));
      this.n.setOnClickListener(this);
      this.n.setOnTouchListener(this);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131313544));
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311147));
      this.jdField_j_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311131);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311149));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131311148));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131313542));
      if (!awnu.b())
      {
        this.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        this.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        this.jdField_f_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      if (!ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, false, null)) {
        break label2893;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-6709582);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController = new SettingMeApolloViewController(this, this.jdField_a_of_type_AndroidViewViewGroup);
      if (!this.jdField_j_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845146);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845123);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i1);
      }
      return;
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      break;
      label2893:
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131100723));
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131100723));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131100723));
    }
  }
  
  private void K()
  {
    if (this.jdField_k_of_type_Boolean) {
      return;
    }
    this.jdField_k_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new abms(this));
  }
  
  private void L()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
    if (localView != null)
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4);
      if (!((SharedPreferences)localObject).getBoolean("drawerEnable", false)) {
        break label132;
      }
      String str = ((SharedPreferences)localObject).getString("drawerText", "");
      localObject = ((SharedPreferences)localObject).getString("drawerUrl", "");
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break label125;
      }
      localView.setVisibility(0);
      if (ajlo.a()) {
        ((TextView)localView.findViewById(2131302761)).setText(str);
      }
    }
    return;
    label125:
    localView.setVisibility(8);
    return;
    label132:
    localView.setVisibility(8);
  }
  
  private void M()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[8];
    if (localView != null)
    {
      if (amxi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("call_tim_config_pre" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("call_tim_config_title", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131633614));
        localView.setVisibility(0);
        ((TextView)localView.findViewById(2131302761)).setText(str);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800887D", "0X800887D", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  private void N()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.l();
    }
  }
  
  private void O()
  {
    this.jdField_d_of_type_AndroidWidgetImageView.post(new QQSettingMe.8(this));
  }
  
  private void P()
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
              localSonicPreloadData.url = bant.a("personalIndex");
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
        ((SonicPreloadData)localObject1).url = bant.a("personalIndex");
        localArrayList3.add(localObject1);
      }
      localObject1 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (((WebProcessManager)localObject1).a(localArrayList1)) {
        ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(String.valueOf("200010.200012"));
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
  
  private void Q()
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
  
  private void R()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_h_of_type_AndroidWidgetTextView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateTalent error");
      }
      return;
    }
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard.allowPeopleSee) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays < 10000L) {
        str1 = String.format(ajjy.a(2131633649), new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
    }
    for (String str2 = String.format(ajjy.a(2131633685), new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });; str2 = ajjy.a(2131633650))
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setText(str1);
      azve.a(this.n, str2, Button.class.getName());
      return;
      str1 = "9999+";
      break;
      str1 = ajjy.a(2131633684);
    }
  }
  
  private void S()
  {
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_f_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_Axlu.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    DrawerFrame.jdField_a_of_type_Int = 0;
    if (AppSetting.jdField_c_of_type_Boolean) {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label66;
      }
    }
    label66:
    for (String str = "关闭夜间模式";; str = "夜间模式 ")
    {
      azve.a(this.jdField_f_of_type_AndroidViewView, str, Button.class.getName());
      return;
    }
  }
  
  private void T()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo != null) {
        this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo);
      }
      for (;;)
      {
        boolean bool = this.jdField_i_of_type_Boolean;
        this.jdField_i_of_type_Boolean = this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a();
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
  
  private void U()
  {
    Object localObject2 = (atax)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    Object localObject1 = ((atax)localObject2).a(-4);
    if ((((atax)localObject2).a((RedTouchItem)localObject1, true)) && (((RedTouchItem)localObject1).count > 0) && (this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo != null))
    {
      QLog.d("QQSettingRedesign", 1, new Object[] { "updateProfileBubbleMsgView ", Integer.valueOf(((RedTouchItem)localObject1).count) });
      long l1;
      ImageView localImageView;
      TextView localTextView;
      View localView;
      if (this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.has())
      {
        l1 = this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.get();
        localObject2 = this.jdField_l_of_type_AndroidViewView.findViewById(2131305535);
        localImageView = (ImageView)this.jdField_l_of_type_AndroidViewView.findViewById(2131301766);
        localTextView = (TextView)this.jdField_l_of_type_AndroidViewView.findViewById(2131304792);
        localView = this.jdField_l_of_type_AndroidViewView.findViewById(2131302744);
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label385;
        }
        ((View)localObject2).setBackgroundResource(2130845127);
      }
      for (;;)
      {
        Object localObject3 = bacm.a(true);
        localObject3 = azwp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, l1 + "", 4, (Drawable)localObject3, (Drawable)localObject3);
        Drawable localDrawable = localImageView.getDrawable();
        if ((localDrawable != null) && (localDrawable != localObject3) && ((localDrawable instanceof azwp))) {
          ((azwp)localDrawable).a();
        }
        localImageView.setImageDrawable((Drawable)localObject3);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131633632, new Object[] { Integer.valueOf(((RedTouchItem)localObject1).count) });
        if (!((String)localObject1).equalsIgnoreCase(localTextView.getText().toString())) {
          localTextView.setText((CharSequence)localObject1);
        }
        ((View)localObject2).setContentDescription((CharSequence)localObject1);
        ((View)localObject2).setOnTouchListener(new abmj(this, localImageView, localTextView, localView));
        ((View)localObject2).setOnClickListener(this);
        this.jdField_l_of_type_AndroidViewView.setVisibility(0);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97E", "0X800A97E", 0, 0, "0", "0", "", "");
        return;
        l1 = 0L;
        break;
        label385:
        ((View)localObject2).setBackgroundResource(2130845126);
      }
    }
    this.jdField_l_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void V()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_MQQPayRuleCfg.iconText)) || (TextUtils.isEmpty(this.jdField_a_of_type_MQQPayRuleCfg.iconUrl))) {
      QLog.e("QQSettingRedesign", 1, "showPayButton: iconText or iconUrl is empty");
    }
    Object localObject1;
    do
    {
      return;
      TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131302745);
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      abmk localabmk = new abmk(this, localTextView);
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
          localabmk.onLoadSuccessed((URLDrawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler showPayButton: ", localMalformedURLException);
        return;
      }
      localMalformedURLException.setText("");
      ((URLDrawable)localObject1).setURLDrawableListener(localabmk);
    } while (((URLDrawable)localObject1).getStatus() != 2);
    ((URLDrawable)localObject1).restartDownload();
  }
  
  private void W()
  {
    try
    {
      a(9, this.jdField_l_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void X()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vipTitleSpFile", 0).getString("vipTitleSpKey_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + ajlo.a(), "");
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateVipText sp vipText = " + str);
      }
      if (!TextUtils.isEmpty(str))
      {
        TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131302761);
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
  
  private void Y()
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
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(str1);
    localObject1 = ((String)localObject3).split("-");
    TextView localTextView = this.jdField_g_of_type_AndroidWidgetTextView;
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
        this.jdField_g_of_type_AndroidWidgetTextView.setTag(((StringBuilder)localObject3).toString());
        this.jdField_f_of_type_AndroidWidgetTextView.setText("o");
        g(str1);
        h(str2);
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
  
  private void Z()
  {
    Object localObject = (atax)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    RedTouchItem localRedTouchItem1 = ((atax)localObject).a(10015);
    RedTouchItem localRedTouchItem2 = ((atax)localObject).a(10016);
    int i1;
    if ((atbe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && ((((atax)localObject).a(localRedTouchItem1, false)) || (((atax)localObject).a(localRedTouchItem2, false))))
    {
      i1 = 1;
      if (i1 != 0)
      {
        i1 = ((atax)localObject).a();
        localObject = null;
        switch (i1)
        {
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
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
          if (i3 == 0) {
            ((ArrayList)localObject2).remove(i2);
          }
          for (i1 = 1;; i1 = 1)
          {
            i2 -= 1;
            break;
            if ((i3 != 3) || (!RedTouchTextView.a(localRedTypeInfo, localAppInfo))) {
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
      label283:
      break;
      localAppInfo = null;
      paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject1;
      localObject1 = localAppInfo;
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
        ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(i1, 30);
      }
    }
  }
  
  private void aa()
  {
    amxi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void b(boolean paramBoolean)
  {
    ThreadManager.post(new QQSettingMe.11(this), 5, null, false);
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
    View localView = this.jdField_k_of_type_AndroidViewView.findViewById(2131299298);
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
      if (((ViewGroup)localObject1).getChildAt(i1).getId() != 2131304944) {
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
    atax localatax = (atax)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    localatax.a(100601, false);
    localatax.a(10016, false);
    localatax.a(10015, false);
    RedTouchItem localRedTouchItem = localatax.a(-7);
    if (localatax.a(localRedTouchItem, true)) {}
    try
    {
      Z();
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_type.set(0);
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_content.set("");
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_desc.set("");
      label109:
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
      break label109;
    }
    return true;
  }
  
  private void d(String paramString)
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
    if (this.o == null)
    {
      localObject1 = new TextView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      ((TextView)localObject1).setText(paramString);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(1, 12.0F);
      ((TextView)localObject1).setGravity(17);
      ((TextView)localObject1).setBackgroundResource(2130843824);
      paramString = new FrameLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1, paramString);
      this.o = ((View)localObject1);
      this.o.setVisibility(8);
    }
  }
  
  private boolean d()
  {
    azyk.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (atax)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    RedTouchItem localRedTouchItem = ((atax)localObject).a(-4);
    if ((((atax)localObject).a(localRedTouchItem, true)) && (localRedTouchItem.count > 0))
    {
      try
      {
        localObject = bace.a(ataw.a(-4));
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
  
  private void e(String paramString)
  {
    boolean bool1;
    boolean bool2;
    int i2;
    long l1;
    int i4;
    QVipBigClubSVIP9Config localQVipBigClubSVIP9Config;
    int i3;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null))
        {
          if (!QLog.isColorLevel()) {
            break label1811;
          }
          QLog.d("QQSettingRedesign", 2, "updateQQLevelVipView card == null");
          return;
        }
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        Resources localResources1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bSuperVipOpen == 1)
        {
          bool1 = true;
          if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bQQVipOpen != 1) {
            break label1014;
          }
          bool2 = true;
          if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bBigClubVipOpen != 1) {
            break label1020;
          }
          i2 = 1;
          l1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.uCurMulType;
          i4 = this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQVipLevel;
          if (QLog.isColorLevel()) {
            QLog.d("QQSettingRedesign", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + i4 + ",QQLevel=" + this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel + ",curMulType =" + this.jdField_a_of_type_ComTencentMobileqqDataCard.uCurMulType);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          localQVipBigClubSVIP9Config = amis.c();
          i3 = 0;
          localObject2 = null;
          if ((l1 != 1L) && (l1 != 2L)) {
            break label1812;
          }
          if (!bool2) {
            break label1025;
          }
          i1 = bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_QQVIP);
          paramString = String.format(localQVipBigClubSVIP9Config.mAPngIconUrl, new Object[] { Integer.valueOf((i1 & 0xF) << 8 | i1 >> 8), Integer.valueOf(i4), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId) });
          bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), this.jdField_a_of_type_AndroidWidgetImageView, paramString, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845972));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          i1 = 1;
          localObject1 = localObject2;
          if (i1 == 0)
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            QLog.e("QQSettingRedesign", 1, (String)localObject1);
            label377:
            if (!bool1) {
              break label1608;
            }
            i1 = bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_SUPERVIP);
            paramString = String.format(localQVipBigClubSVIP9Config.mAPngIconUrl, new Object[] { Integer.valueOf((i1 & 0xF) << 8 | i1 >> 8), Integer.valueOf(i4), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId) });
            bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), this.jdField_a_of_type_AndroidWidgetImageView, paramString, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845973));
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          label488:
          if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
          {
            i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131167157);
            this.jdField_c_of_type_Int = (awmc.jdField_a_of_type_Int - awmc.a(94.0F) - i1 - awmc.a(45.0F) - awmc.a(45.0F));
            this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_c_of_type_Int);
          }
          if (bapw.a().a(bool1, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingLoginTime)) {
            localSpannableStringBuilder.append(azys.a(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView, localResources1, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDanDisplatSwitch));
          }
          i2 = 0;
          if ((this.jdField_a_of_type_ComTencentMobileqqDataMedalList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() <= 0)) {
            break label1745;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setData(this.jdField_a_of_type_ComTencentMobileqqDataMedalList);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
            break label1722;
          }
          this.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#7bffffff"));
          label692:
          i2 = this.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() * vms.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 21.0F) - vms.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 6.0F);
          if (QLog.isColorLevel()) {
            QLog.d("QVipSettingMe.", 1, "width =" + i2 + "update medal:" + this.jdField_a_of_type_ComTencentMobileqqDataMedalList.convert());
          }
          i1 = i2;
          if (!this.jdField_e_of_type_Boolean)
          {
            this.jdField_e_of_type_Boolean = true;
            i1 = ajve.b(ajve.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X800A126", 0, 0, String.valueOf(i1), "", "", "");
            i1 = i2;
          }
          label841:
          localSpannableStringBuilder.append(azys.a(localResources1, this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType, this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel, a(i1)));
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setContentDescription("等级：" + this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
          a(bool1, bool2, i4);
          if (!AppSetting.jdField_c_of_type_Boolean) {
            break label1811;
          }
          paramString = new StringBuilder();
          paramString.append(this.jdField_a_of_type_JavaLangString);
          if (!bool1) {
            break label1795;
          }
          paramString.append("你是尊贵的超级会员");
          label962:
          if (this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel > 0) {
            paramString.append(" 等级").append(this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
          }
          this.jdField_a_of_type_AndroidViewView.setContentDescription(paramString.toString());
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return;
      }
      bool1 = false;
      continue;
      label1014:
      bool2 = false;
      continue;
      label1020:
      i2 = 0;
      continue;
      label1025:
      localObject1 = "occur error: curMulType=" + l1 + " but bQQVipOpen is false";
      i1 = i3;
    }
    label1060:
    label1093:
    ImageView localImageView;
    Resources localResources2;
    if (bool1)
    {
      i2 = bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_SUPERVIP);
      if ((i2 & 0xF) != 1) {
        break label1833;
      }
      i1 = 1;
      paramString = String.format(localQVipBigClubSVIP9Config.mAPngIconUrl, new Object[] { Integer.valueOf((i2 & 0xF) << 8 | i2 >> 8), Integer.valueOf(i4), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId) });
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      localResources2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      if (i1 == 0) {
        break label1838;
      }
    }
    label1795:
    label1811:
    label1812:
    label1833:
    label1838:
    for (int i1 = 2130845973;; i1 = 2130845971)
    {
      bajr.a((Resources)localObject1, localImageView, paramString, localResources2.getDrawable(i1));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i1 = 1;
      localObject1 = localObject2;
      break;
      localObject1 = "occur error: curMulType=" + l1 + " but bSuperVipOpen is false";
      i1 = i3;
      break;
      label1608:
      label1745:
      do
      {
        localObject1 = localObject2;
        i1 = i3;
        if (l1 != 6L) {
          break;
        }
        if (i2 != 0)
        {
          i1 = bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, false);
          if (i1 >> 8 == 3)
          {
            if ((i1 & 0xF) == 1)
            {
              i1 = bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
              paramString = String.format(localQVipBigClubSVIP9Config.mAPngIconUrl, new Object[] { Integer.valueOf((i1 & 0xF) << 8 | i1 >> 8), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.iBigClubVipLevel), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lBigClubTemplateId) });
              bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), this.jdField_a_of_type_AndroidWidgetImageView, paramString, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845973));
            }
            for (;;)
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              i1 = 1;
              localObject1 = localObject2;
              break;
              i1 = bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
              paramString = String.format(localQVipBigClubSVIP9Config.mAPngIconUrl, new Object[] { Integer.valueOf((i1 & 0xF) << 8 | i1 >> 8), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.iBigClubVipLevel), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lBigClubTemplateId) });
              bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), this.jdField_a_of_type_AndroidWidgetImageView, paramString, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845971));
            }
          }
          localObject1 = "occur error: curMulType=" + l1 + " but bBigClubVipOpen userStatus=" + i1;
          i1 = i3;
          break;
        }
        localObject1 = "occur error: curMulType=" + l1 + " but bBigClubVipOpen is false";
        i1 = i3;
        break;
        QLog.e("QQSettingRedesign", 1, "it have not handle curMulType=" + l1);
        break label377;
        if (!bool2) {
          break label488;
        }
        i1 = bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_QQVIP);
        paramString = String.format(localQVipBigClubSVIP9Config.mAPngIconUrl, new Object[] { Integer.valueOf((i1 & 0xF) << 8 | i1 >> 8), Integer.valueOf(i4), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId) });
        bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), this.jdField_a_of_type_AndroidWidgetImageView, paramString, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845972));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        break label488;
        this.jdField_c_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131100727));
        break label692;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        i1 = i2;
        if (!QLog.isColorLevel()) {
          break label841;
        }
        QLog.d("QVipSettingMe.", 1, "medal list is null");
        i1 = i2;
        break label841;
        if (!bool2) {
          break label962;
        }
        paramString.append("你是尊贵的会员");
        break label962;
        return;
        if (l1 == 3L) {
          break label1060;
        }
      } while (l1 != 4L);
      label1722:
      break label1060;
      i1 = 0;
      break label1093;
    }
  }
  
  private boolean e()
  {
    if (!this.jdField_d_of_type_Boolean) {
      return true;
    }
    long l1 = baub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_last_request_success_time", 0L);
    int i1 = baub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_vip_sync_freq", 0);
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
    long l1 = System.currentTimeMillis();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(100400));
    Object localObject1;
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0) && (localAppInfo.exposure_max.get() >= 0)) {
      localObject1 = localAppInfo.buffer.get();
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      int i1;
      Object localObject2;
      try
      {
        localObject1 = new JSONObject((String)localObject1).optString("_jump_url");
        localStringBuilder = new StringBuilder();
        i1 = badq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.jdField_c_of_type_JavaLangString;
        }
        if (((String)localObject2).contains("?")) {
          break label445;
        }
        localStringBuilder.append((String)localObject2 + "?platform=1&type=20001&networkInfo=" + i1);
        localObject1 = localStringBuilder.toString();
        localObject2 = ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a((String)localObject1, localAppInfo);
        if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() == 0) || (localAppInfo.type.get() != 0)) {
          break label479;
        }
        bool = true;
        localObject1 = localObject2;
        if (paramString != null) {
          localObject1 = (String)localObject2 + paramString;
        }
        paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        paramString.putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
        paramString.putExtra("startOpenPageTime", l1);
        paramString.putExtra("portraitOnly", true);
        paramString.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramString.putExtra("hide_operation_bar", true);
        paramString.putExtra("hide_more_button", true);
        paramString.putExtra("has_red_dot", bool);
        paramString.putExtra("leftBtnText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131624009));
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject1, 256L, paramString, false, -1);
        paramString = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
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
      label445:
      localStringBuilder.append((String)localObject2 + "&platform=1&type=20001&networkInfo=" + i1);
      continue;
      label479:
      boolean bool = false;
    }
  }
  
  private void g(String paramString)
  {
    if ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (this.jdField_g_of_type_AndroidWidgetTextView == null) || (this.jdField_e_of_type_AndroidWidgetTextView == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_c_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_j_of_type_AndroidViewView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    int i1;
    if (paramString.charAt(0) == '-')
    {
      paramString = paramString.substring(1, paramString.length());
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText("-");
      this.jdField_e_of_type_AndroidWidgetTextView.measure(0, 0);
      i1 = this.jdField_e_of_type_AndroidWidgetTextView.getMeasuredWidth();
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.measure(0, 0);
      this.jdField_g_of_type_AndroidWidgetTextView.measure(0, 0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.measure(0, 0);
      this.jdField_f_of_type_AndroidWidgetTextView.measure(0, 0);
      int i4 = this.jdField_d_of_type_AndroidWidgetTextView.getMeasuredWidth();
      int i3 = this.jdField_c_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
      int i2 = (i3 - i4 - i1 - this.jdField_f_of_type_AndroidWidgetTextView.getMeasuredWidth()) / 2;
      i4 /= 2;
      i3 /= 2;
      paramString = (LinearLayout.LayoutParams)this.jdField_j_of_type_AndroidViewView.getLayoutParams();
      paramString.leftMargin = (i3 - (i1 + i2 + i4));
      this.jdField_j_of_type_AndroidViewView.setLayoutParams(paramString);
      return;
      i1 = 0;
    }
  }
  
  private void h(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null)
    {
      localStringBuilder.append("地点：").append(this.jdField_g_of_type_AndroidWidgetTextView.getText()).append("，天气：");
      if (!paramString.equals("201")) {
        break label100;
      }
      localStringBuilder.append("晴");
    }
    for (;;)
    {
      localStringBuilder.append("，温度：").append(this.jdField_d_of_type_AndroidWidgetTextView.getText()).append("摄氏度");
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
  
  private void i(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Date localDate = new Date();
    if (!(localDate.getYear() + ":" + localDate.getMonth() + localDate.getDay()).equals(localSharedPreferences.getString("sign_in_report" + paramString, ""))) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
  }
  
  void A()
  {
    this.jdField_a_of_type_Avev = ((avev)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15));
    if (this.jdField_a_of_type_Avev == null)
    {
      QLog.e("QQSettingRedesign", 1, "preLoadSignature, mStatusManager == null");
      return;
    }
    ImageView localImageView1 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131309485);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131309486);
    ImageView localImageView2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131302073);
    localImageView2.setColorFilter(localTextView.getCurrentTextColor());
    Object localObject1 = new StringBuilder(100);
    label117:
    Object localObject2;
    if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null))
    {
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      localTextView.setMaxWidth(this.jdField_d_of_type_Int);
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
        break label513;
      }
      localImageView1.setImageBitmap(this.jdField_a_of_type_Avev.a(i1, 200));
      localImageView1.setVisibility(0);
      ((StringBuilder)localObject1).append(str1);
      if (!TextUtils.isEmpty(str2)) {
        ((StringBuilder)localObject1).append(str2);
      }
      ((StringBuilder)localObject1).append(' ');
      label377:
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label542;
      }
      if (!TextUtils.isEmpty(str4)) {
        ((StringBuilder)localObject1).append(str4);
      }
      if (!TextUtils.isEmpty(str3)) {
        ((StringBuilder)localObject1).append(str3);
      }
      label417:
      localObject1 = ((StringBuilder)localObject1).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label553;
      }
      localTextView.setText(2131633620);
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
      if (!awnu.b()) {
        break;
      }
      localImageView1.setVisibility(8);
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label117;
      label513:
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130845131);
      localImageView1.setVisibility(8);
      break label377;
      label542:
      ((StringBuilder)localObject1).append((String)localObject2);
      break label417;
      label553:
      localImageView2.setVisibility(0);
      if (babp.b()) {
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
      a(3, this.jdField_e_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void C()
  {
    if (((ajfi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).b())
    {
      E();
      this.jdField_b_of_type_Boolean = false;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_duty", "", "locker", "exp", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "TaskEntry updateDailySignInItemView mDayliSignMode = " + this.jdField_b_of_type_Boolean);
      }
      return;
      D();
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  protected void D()
  {
    String str = null;
    Object localObject4 = null;
    int i8 = 0;
    int i7 = 0;
    int i6 = 0;
    int i5 = 0;
    int i9 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131167157);
    int i10 = awmc.jdField_a_of_type_Int;
    int i11 = awmc.a(65.0F);
    int i12 = awmc.a(15.0F);
    int i13 = this.jdField_e_of_type_AndroidWidgetImageView.getWidth();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    long l1 = ((SharedPreferences)localObject1).getLong("sign_in_time_stamp", 0L);
    Object localObject5 = ((SharedPreferences)localObject1).getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_info", "");
    int i1 = i5;
    int i2 = i6;
    int i4 = i7;
    int i3 = i8;
    Object localObject2 = localObject4;
    localObject1 = str;
    Object localObject6;
    try
    {
      localObject6 = new JSONObject((String)localObject5);
      i1 = i5;
      i2 = i6;
      i4 = i7;
      i3 = i8;
      localObject2 = localObject4;
      localObject1 = str;
      i7 = ((JSONObject)localObject6).optInt("type");
      i1 = i5;
      i2 = i6;
      i4 = i7;
      i3 = i8;
      localObject2 = localObject4;
      localObject1 = str;
      i6 = ((JSONObject)localObject6).optInt("redpoint");
      i1 = i5;
      i2 = i6;
      i4 = i7;
      i3 = i8;
      localObject2 = localObject4;
      localObject1 = str;
      i5 = ((JSONObject)localObject6).optInt("openfunc");
      i1 = i5;
      i2 = i6;
      i4 = i7;
      i3 = i8;
      localObject2 = localObject4;
      localObject1 = str;
      str = ((JSONObject)localObject6).optString("iconUrl");
      i1 = i5;
      i2 = i6;
      i4 = i7;
      i3 = i8;
      localObject2 = localObject4;
      localObject1 = str;
      localObject4 = ajjy.a(2131644972);
      i1 = i5;
      i2 = i6;
      i4 = i7;
      i3 = i8;
      localObject2 = localObject4;
      localObject1 = str;
      i8 = ((JSONObject)localObject6).optInt("day");
      i1 = i5;
      i2 = i6;
      i4 = i7;
      i3 = i8;
      localObject2 = localObject4;
      localObject1 = str;
      if (QLog.isColorLevel())
      {
        i1 = i5;
        i2 = i6;
        i4 = i7;
        i3 = i8;
        localObject2 = localObject4;
        localObject1 = str;
        QLog.i("DailySignIn", 2, "doUpdateDailySignInItemView type=" + i7 + " redpoint=" + i6 + " openfunc=" + i5 + " iconUrl=" + str + " wording=" + (String)localObject4 + " day=" + i8);
      }
      i2 = i7;
      i3 = i8;
      localObject1 = localObject4;
      localObject2 = str;
      i1 = i6;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "doUpdateDailySignInItemView JSONException, json = " + (String)localObject5);
        }
        localJSONException.printStackTrace();
        localObject3 = localObject2;
        i5 = i1;
        localObject2 = localObject1;
        localObject1 = localObject3;
        i1 = i2;
        i2 = i4;
      }
      i("0X8007CAB");
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845149);
      localObject5 = (URLImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131310407);
      localObject6 = (ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131302723);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1106;
      }
    }
    if (i5 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DailySignIn", 2, "0x922 kill enter");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    localObject4 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
    ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
    ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = 56;
    ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = 56;
    Object localObject3 = "https://hbd.url.cn/myapp/qq_desk/signin/" + (String)localObject2;
    localObject2 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "use custom icon=" + (String)localObject3);
    }
    i("0X8007CB1");
    for (;;)
    {
      ((URLImageView)localObject5).setImageDrawable((Drawable)localObject2);
      ((ImageView)localObject6).setImageDrawable((Drawable)localObject2);
      localObject2 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131310409);
      localObject3 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131302761);
      ((TextView)localObject2).setMaxWidth(i10 - i9 - i11 - (i12 + i13));
      if (((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((beeu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) || (!this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) || (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)))
      {
        ((TextView)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131100727));
        label901:
        if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
          break label1273;
        }
        ((TextView)localObject2).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        label922:
        if (i2 != 4) {
          break label1285;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "use signed wording:" + (String)localObject1);
        }
        i("0X8007CAF");
        if (i3 <= 0) {
          break label1379;
        }
        localObject1 = String.format(ajjy.a(2131644965), new Object[] { Integer.valueOf(i3) });
      }
      label1106:
      label1364:
      label1379:
      for (;;)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject3).setText((CharSequence)localObject1);
        label1008:
        i3 = 0;
        if (awao.a() - l1 <= 86400L)
        {
          if (QLog.isColorLevel()) {
            QLog.i("DailySignIn", 2, "sign info is fresh");
          }
          if ((i2 != 4) && (i1 == 1))
          {
            if (QLog.isColorLevel()) {
              QLog.i("DailySignIn", 2, "unsigned and need redpoint in 0x922,show redpoint");
            }
            i1 = 1;
          }
        }
        for (;;)
        {
          if (i1 == 0) {
            break label1364;
          }
          localObject1 = new BusinessInfoCheckUpdate.RedTypeInfo();
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          i("0X8007CAD");
          return;
          if (QLog.isColorLevel()) {
            QLog.i("DailySignIn", 2, "use default icon");
          }
          if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
            break label1382;
          }
          localObject4 = null;
          for (;;)
          {
            try
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((!beeu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) {
                continue;
              }
              localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130845149);
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              localObject2 = localObject4;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("QQSettingRedesign", 2, localOutOfMemoryError, new Object[0]);
              localObject2 = localObject4;
              continue;
            }
            if (localObject2 == null) {
              break label1382;
            }
            localObject2 = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), bees.a((Bitmap)localObject2));
            break;
            localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130845150);
          }
          ((TextView)localObject2).setTextColor(-16777216);
          break label901;
          label1273:
          ((TextView)localObject2).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break label922;
          if (QLog.isColorLevel()) {
            QLog.i("DailySignIn", 2, "use unsigned wording");
          }
          ((TextView)localObject2).setText((CharSequence)localObject1);
          ((TextView)localObject3).setText((CharSequence)localObject1);
          break label1008;
          i1 = i3;
          if (QLog.isColorLevel())
          {
            QLog.i("DailySignIn", 2, "signed or 0x922 kill redpoint,do not show redpoint");
            i1 = i3;
            continue;
            i1 = i3;
            if (QLog.isColorLevel())
            {
              QLog.i("DailySignIn", 2, "sign info is old");
              i1 = i3;
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.b();
        return;
      }
      label1285:
      label1382:
      localObject2 = localObject3;
    }
  }
  
  protected void E()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("task_entry_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    boolean bool = ((SharedPreferences)localObject3).getBoolean("open", false);
    Object localObject1 = ((SharedPreferences)localObject3).getString("icon_url", "");
    Object localObject4 = ((SharedPreferences)localObject3).getString("night_icon_url", "");
    String str = ((SharedPreferences)localObject3).getString("word", "");
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DailySignIn", 2, "0x922 kill enter");
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845149);
    URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131310407);
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131302723);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null))
    {
      localObject1 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label494;
      }
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = 56;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = 56;
      localObject3 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject4);
      if (QLog.isColorLevel()) {
        QLog.i("DailySignIn", 2, "use custom icon=" + (String)localObject1);
      }
      localObject1 = localObject3;
    }
    for (;;)
    {
      localURLImageView.setImageDrawable((Drawable)localObject1);
      localImageView.setImageDrawable((Drawable)localObject1);
      localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131310409);
      localObject3 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131302761);
      ((TextView)localObject1).setMaxWidth(awmc.jdField_a_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131167157) - awmc.a(65.0F) - (awmc.a(15.0F) + this.jdField_e_of_type_AndroidWidgetImageView.getWidth()));
      if (((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((beeu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) || (!this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) || (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)))
      {
        ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131100727));
        label428:
        if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
          break label644;
        }
        ((TextView)localObject1).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
      for (;;)
      {
        ((TextView)localObject1).setText(str);
        ((TextView)localObject3).setText(str);
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "use unsigned wording");
        }
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.b();
        return;
        break;
        label494:
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "use default icon");
        }
        if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
          break label655;
        }
        for (;;)
        {
          try
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((!beeu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) {
              continue;
            }
            localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130845149);
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("QQSettingRedesign", 2, localOutOfMemoryError, new Object[0]);
            localObject2 = null;
            continue;
          }
          if (localObject1 == null) {
            break label655;
          }
          localObject1 = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), bees.a((Bitmap)localObject1));
          break;
          localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130845150);
        }
        localObject2.setTextColor(-16777216);
        break label428;
        label644:
        localObject2.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
      label655:
      Object localObject2 = localObject3;
    }
  }
  
  protected void F()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_info", "");
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).optInt("redpoint") != 0) {
          i("0X8007CAE");
        }
        if (((JSONObject)localObject).optInt("type") != 4) {
          continue;
        }
        i("0X8007CB0");
        ((JSONObject)localObject).put("redpoint", 0);
        localSharedPreferences.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_info", ((JSONObject)localObject).toString()).commit();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      j();
      return;
      if (!TextUtils.isEmpty(((JSONObject)localObject).optString("iconUrl"))) {
        i("0X8007CB2");
      }
    }
  }
  
  public void G()
  {
    this.jdField_g_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.k();
    }
    if ((this.o != null) && (this.o.getVisibility() == 0))
    {
      this.o.setVisibility(8);
      BaseApplication.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "qqsettingme_f2f_guide", 0).edit().putBoolean("qqsettingme_f2f_guide_flag", true).apply();
    }
    a(null);
  }
  
  public void H()
  {
    this.jdField_g_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.j();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    a(null);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A42B", "0X800A42B", 0, 0, "", "", "", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (baqv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType))) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType != 0) {
        break label143;
      }
    }
    label143:
    for (int i1 = 99999;; i1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType)
    {
      awqx.b(null, "dc00898", "", "", "qq_vip", "0X800A778", i1, 0, "", "", "", "");
      return;
    }
  }
  
  void I()
  {
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.WebPreloadTask(this));
  }
  
  public void J()
  {
    this.jdField_a_of_type_Aqeb.b();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      int i1 = 0;
      if (localIterator.hasNext())
      {
        Bitmap localBitmap = ((beom)localIterator.next()).a();
        if (localBitmap == null) {
          break label70;
        }
        i1 = azzz.a(localBitmap) + i1;
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
    float f2 = ((Resources)localObject).getDimension(2131167155);
    float f3 = ((Resources)localObject).getDimension(2131167139);
    float f4 = ((Resources)localObject).getDimension(2131167143);
    float f5 = ((Resources)localObject).getDimension(2131167147);
    float f6 = ((Resources)localObject).getDimension(2131167150);
    float f7 = ((Resources)localObject).getDimension(2131167157);
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
  
  public beom a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (beom)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
    this.jdField_f_of_type_Boolean = false;
    v();
    awri.a().a("QQSettingMe");
    if (!this.jdField_d_of_type_Boolean) {
      h();
    }
    this.jdField_k_of_type_AndroidViewView.setPadding(this.jdField_k_of_type_AndroidViewView.getPaddingLeft(), awmc.a(14.0F), this.jdField_k_of_type_AndroidViewView.getPaddingRight(), this.jdField_k_of_type_AndroidViewView.getPaddingBottom());
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
        Y();
        this.jdField_a_of_type_Ahye.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      for (;;)
      {
        i();
        Z();
        n();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if ((localObject != null) && (((String)localObject).equals(this.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.s();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a();
          this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.e();
        }
        this.jdField_c_of_type_Boolean = true;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          long l1 = WebProcessManager.a((String)localObject, "key_individuation_click_time");
          if ((l1 == -1L) || (System.currentTimeMillis() - l1 < 259200000L)) {
            WebProcessManager.a(jdField_b_of_type_JavaUtilList, "key_individuation_dns_parse");
          }
          l1 = WebProcessManager.b((String)localObject);
          if (System.currentTimeMillis() - l1 < 604800000L) {
            WebProcessManager.a(jdField_a_of_type_JavaUtilList, "key_vip_dns_parse");
          }
        }
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[7];
        if (localObject != null)
        {
          sga localsga = (sga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
          if ((localsga == null) || (!localsga.e())) {
            break;
          }
          ((View)localObject).setVisibility(0);
        }
        L();
        M();
        b();
        K();
        if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()) && (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (awnu.b())) {
          ImmersiveUtils.a(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        }
        localObject = new int[11];
        Object tmp417_415 = localObject;
        tmp417_415[0] = 2131304980;
        Object tmp423_417 = tmp417_415;
        tmp423_417[1] = 2131304977;
        Object tmp429_423 = tmp423_417;
        tmp429_423[2] = 2131304969;
        Object tmp435_429 = tmp429_423;
        tmp435_429[3] = 2131304972;
        Object tmp441_435 = tmp435_429;
        tmp441_435[4] = 2131304976;
        Object tmp447_441 = tmp441_435;
        tmp447_441[5] = 2131304944;
        Object tmp453_447 = tmp447_441;
        tmp453_447[6] = 2131304978;
        Object tmp460_453 = tmp453_447;
        tmp460_453[7] = 2131304979;
        Object tmp467_460 = tmp460_453;
        tmp467_460[8] = 2131298268;
        Object tmp474_467 = tmp467_460;
        tmp474_467[9] = 2131299298;
        Object tmp481_474 = tmp474_467;
        tmp481_474[10] = 2131304943;
        tmp481_474;
        i2 = ajve.b(ajve.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
        i1 = 0;
        for (;;)
        {
          if (i1 >= 11) {
            return;
          }
          if ((localObject[i1] != 2131304980) || (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() != 0)) {
            break;
          }
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C3", "0X800A8C3", i2, 0, String.valueOf(i2), "", "", "");
          i1 += 1;
        }
        if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(4);
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
        if ((localThrowable[i1] == 2131304977) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() == 0)) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C4", "0X800A8C4", i2, 0, String.valueOf(i2), "", "", "");
        } else if ((localThrowable[i1] == 2131299298) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() == 0)) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C5", "0X800A8C5", i2, 0, String.valueOf(i2), "", "", "");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramInt, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
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
      this.jdField_a_of_type_Axlu.a(paramQQAppInterface);
      l();
      z();
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
    String str2 = null;
    String str1 = null;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    ImageView localImageView1 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131309485);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131309486);
    ImageView localImageView2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131302073);
    localImageView2.setColorFilter(localTextView.getCurrentTextColor());
    StringBuilder localStringBuilder = new StringBuilder(100);
    SharedPreferences.Editor localEditor;
    if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null))
    {
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      localTextView.setMaxWidth(this.jdField_d_of_type_Int);
      localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("qqsettingme_signature" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit();
      if ((paramRichStatus == null) || (TextUtils.isEmpty(paramRichStatus.actionText))) {
        break label510;
      }
      localImageView1.setImageBitmap(this.jdField_a_of_type_Avev.a(paramRichStatus.actionId, 200));
      localImageView1.setVisibility(0);
      localStringBuilder.append(paramRichStatus.actionText);
      if (!TextUtils.isEmpty(paramRichStatus.dataText)) {
        localStringBuilder.append(paramRichStatus.dataText);
      }
      localStringBuilder.append(' ');
      localEditor.putInt("actionId", paramRichStatus.actionId);
      localEditor.putString("actionText", paramRichStatus.actionText);
      localEditor.putString("dataText", paramRichStatus.dataText);
      label271:
      if (paramRichStatus != null)
      {
        if (!paramRichStatus.hasTopic()) {
          break label543;
        }
        if (paramRichStatus.shouldShowAtHead())
        {
          str2 = paramRichStatus.topicToPlainText();
          localStringBuilder.append(str2);
          localEditor.putString("topics", str2);
          if (paramRichStatus.plainText != null)
          {
            if (paramRichStatus.plainText.size() > 0) {
              str1 = (String)paramRichStatus.plainText.get(0);
            }
            if (!TextUtils.isEmpty(str1))
            {
              localStringBuilder.append(str1);
              localEditor.putString("plainText", str1);
            }
          }
        }
        if (paramRichStatus.shouldShowMixing())
        {
          paramRichStatus = paramRichStatus.getPlainText();
          localStringBuilder.append(paramRichStatus);
          localEditor.putString("plainMixTopic", paramRichStatus);
        }
      }
      label399:
      if (Build.VERSION.SDK_INT <= 8) {
        break label603;
      }
      localEditor.apply();
      label414:
      paramRichStatus = localStringBuilder.toString();
      if (!TextUtils.isEmpty(paramRichStatus)) {
        break label614;
      }
      localTextView.setText(2131633620);
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
      if (awnu.b()) {
        localImageView1.setVisibility(8);
      }
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break;
      label510:
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130845131);
      localImageView1.setVisibility(8);
      break label271;
      label543:
      if (paramRichStatus.plainText == null) {
        break label399;
      }
      str1 = str2;
      if (paramRichStatus.plainText.size() > 0) {
        str1 = (String)paramRichStatus.plainText.get(0);
      }
      if (TextUtils.isEmpty(str1)) {
        break label399;
      }
      localStringBuilder.append(str1);
      localEditor.putString("plainText", str1);
      break label399;
      label603:
      localEditor.commit();
      break label414;
      label614:
      localImageView2.setVisibility(0);
      if (babp.b()) {
        localTextView.setText(new axkd(paramRichStatus + " ", 1, 16));
      } else {
        localTextView.setText(new axkd(paramRichStatus, 1, 16));
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
      if ((awnu.b()) && (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (ImmersiveUtils.isSupporImmersive() != 0))
      {
        paramBoolean = ThemeUtil.getCurrentThemeId();
        if ((awnu.b(paramBoolean)) && (!ThemeUtil.isSimpleColrThemeStateBarUseWhite(paramBoolean)))
        {
          ImmersiveUtils.a(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
          return;
        }
        ImmersiveUtils.a(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        return;
      }
      ImmersiveUtils.a(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    Boolean localBoolean = paramBoolean;
    if (paramBoolean == null)
    {
      localBoolean = paramBoolean;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
        if ((!beeu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())) {
          break label172;
        }
      }
    }
    label172:
    for (boolean bool = true;; bool = false)
    {
      localBoolean = Boolean.valueOf(bool);
      if ((localBoolean == null) || (!ThemeUtil.isDefaultTheme())) {
        break label190;
      }
      if (!localBoolean.booleanValue()) {
        break;
      }
      ImmersiveUtils.a(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      return;
    }
    ImmersiveUtils.a(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
    return;
    label190:
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
  
  public void a(String paramString, beom parambeom)
  {
    if (parambeom == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "[storeDynamicDrawable] drawable to be stored is null");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambeom);
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
    //   0: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc_w 267
    //   9: iconst_2
    //   10: new 280	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 2701
    //   20: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 1100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: ldc_w 2703
    //   30: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 1100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   37: ldc_w 2705
    //   40: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_3
    //   44: invokevirtual 554	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 426	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 1104	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 276	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokevirtual 2053	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   60: astore 6
    //   62: aload_0
    //   63: getfield 620	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   66: iconst_0
    //   67: aaload
    //   68: ldc_w 697
    //   71: invokevirtual 331	android/view/View:findViewById	(I)Landroid/view/View;
    //   74: checkcast 403	android/widget/TextView
    //   77: astore 7
    //   79: aload_0
    //   80: getfield 620	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   83: iconst_0
    //   84: aaload
    //   85: ldc_w 695
    //   88: invokevirtual 331	android/view/View:findViewById	(I)Landroid/view/View;
    //   91: checkcast 499	android/widget/ImageView
    //   94: astore 8
    //   96: aload_0
    //   97: getfield 274	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   100: invokevirtual 612	com/tencent/mobileqq/app/BaseActivity:getResources	()Landroid/content/res/Resources;
    //   103: astore 9
    //   105: aload 9
    //   107: ldc_w 638
    //   110: invokevirtual 717	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   113: astore 5
    //   115: invokestatic 892	ajlo:a	()Z
    //   118: ifeq +400 -> 518
    //   121: iload_1
    //   122: ifeq +238 -> 360
    //   125: invokestatic 1728	bapw:a	()Lbapw;
    //   128: getfield 2707	bapw:d	Ljava/lang/String;
    //   131: invokestatic 665	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +209 -> 343
    //   137: invokestatic 1728	bapw:a	()Lbapw;
    //   140: getfield 2707	bapw:d	Ljava/lang/String;
    //   143: astore 6
    //   145: aload 6
    //   147: astore 5
    //   149: aload 5
    //   151: astore 6
    //   153: aload 5
    //   155: invokevirtual 362	java/lang/String:length	()I
    //   158: bipush 8
    //   160: if_icmple +13 -> 173
    //   163: aload 5
    //   165: iconst_0
    //   166: bipush 8
    //   168: invokevirtual 1994	java/lang/String:substring	(II)Ljava/lang/String;
    //   171: astore 6
    //   173: aload 7
    //   175: aload 6
    //   177: invokevirtual 470	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   180: aload_0
    //   181: getfield 152	com/tencent/mobileqq/activity/QQSettingMe:jdField_j_of_type_Boolean	Z
    //   184: ifeq +437 -> 621
    //   187: ldc_w 2708
    //   190: istore_3
    //   191: aload 8
    //   193: iload_3
    //   194: invokevirtual 696	android/widget/ImageView:setImageResource	(I)V
    //   197: aload 6
    //   199: invokestatic 665	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifne +107 -> 309
    //   205: aload_0
    //   206: getfield 276	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   209: invokevirtual 412	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   212: ldc_w 1296
    //   215: iconst_0
    //   216: invokevirtual 1297	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   219: invokeinterface 2307 1 0
    //   224: new 280	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 1299
    //   234: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: getfield 276	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   241: invokevirtual 356	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   244: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 1301
    //   250: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokestatic 1303	ajlo:a	()I
    //   256: invokevirtual 554	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: invokevirtual 426	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aload 6
    //   264: invokeinterface 2314 3 0
    //   269: invokeinterface 2317 1 0
    //   274: pop
    //   275: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +31 -> 309
    //   281: ldc_w 267
    //   284: iconst_2
    //   285: new 280	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 2710
    //   295: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 6
    //   300: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 426	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 556	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload_0
    //   310: getfield 620	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   313: iconst_0
    //   314: aaload
    //   315: iconst_0
    //   316: invokevirtual 449	android/view/View:setVisibility	(I)V
    //   319: getstatic 315	com/tencent/common/config/AppSetting:jdField_c_of_type_Boolean	Z
    //   322: ifeq +20 -> 342
    //   325: aload_0
    //   326: getfield 620	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   329: iconst_0
    //   330: aaload
    //   331: aload 6
    //   333: ldc_w 719
    //   336: invokevirtual 724	java/lang/Class:getName	()Ljava/lang/String;
    //   339: invokestatic 729	azve:a	(Landroid/view/View;Ljava/lang/CharSequence;Ljava/lang/String;)V
    //   342: return
    //   343: aload 9
    //   345: ldc_w 2711
    //   348: invokevirtual 717	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   351: astore 6
    //   353: aload 6
    //   355: astore 5
    //   357: goto -208 -> 149
    //   360: iload_2
    //   361: ifeq +47 -> 408
    //   364: invokestatic 1728	bapw:a	()Lbapw;
    //   367: getfield 2713	bapw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   370: invokestatic 665	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   373: ifne +18 -> 391
    //   376: invokestatic 1728	bapw:a	()Lbapw;
    //   379: getfield 2713	bapw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   382: astore 6
    //   384: aload 6
    //   386: astore 5
    //   388: goto -239 -> 149
    //   391: aload 9
    //   393: ldc_w 2714
    //   396: invokevirtual 717	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   399: astore 6
    //   401: aload 6
    //   403: astore 5
    //   405: goto -256 -> 149
    //   408: aload 6
    //   410: ldc_w 2716
    //   413: iconst_0
    //   414: invokeinterface 1323 3 0
    //   419: istore 4
    //   421: iload_3
    //   422: ifgt +8 -> 430
    //   425: iload 4
    //   427: ifle +47 -> 474
    //   430: invokestatic 1728	bapw:a	()Lbapw;
    //   433: getfield 2717	bapw:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   436: invokestatic 665	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   439: ifne +18 -> 457
    //   442: invokestatic 1728	bapw:a	()Lbapw;
    //   445: getfield 2717	bapw:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   448: astore 6
    //   450: aload 6
    //   452: astore 5
    //   454: goto -305 -> 149
    //   457: aload 9
    //   459: ldc_w 2718
    //   462: invokevirtual 717	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   465: astore 6
    //   467: aload 6
    //   469: astore 5
    //   471: goto -322 -> 149
    //   474: invokestatic 1728	bapw:a	()Lbapw;
    //   477: getfield 2719	bapw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   480: invokestatic 665	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifne +18 -> 501
    //   486: invokestatic 1728	bapw:a	()Lbapw;
    //   489: getfield 2719	bapw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   492: astore 6
    //   494: aload 6
    //   496: astore 5
    //   498: goto -349 -> 149
    //   501: aload 9
    //   503: ldc_w 638
    //   506: invokevirtual 717	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   509: astore 6
    //   511: aload 6
    //   513: astore 5
    //   515: goto -366 -> 149
    //   518: iload_1
    //   519: ifeq +16 -> 535
    //   522: aload 9
    //   524: ldc_w 2711
    //   527: invokevirtual 717	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   530: astore 6
    //   532: goto -359 -> 173
    //   535: iload_2
    //   536: ifeq +16 -> 552
    //   539: aload 9
    //   541: ldc_w 2714
    //   544: invokevirtual 717	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   547: astore 6
    //   549: goto -376 -> 173
    //   552: aload 6
    //   554: ldc_w 2716
    //   557: iconst_0
    //   558: invokeinterface 1323 3 0
    //   563: istore 4
    //   565: iload_3
    //   566: ifgt +8 -> 574
    //   569: iload 4
    //   571: ifle +16 -> 587
    //   574: aload 9
    //   576: ldc_w 2718
    //   579: invokevirtual 717	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   582: astore 6
    //   584: goto -411 -> 173
    //   587: aload 9
    //   589: ldc_w 638
    //   592: invokevirtual 717	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   595: astore 6
    //   597: goto -424 -> 173
    //   600: astore 6
    //   602: ldc_w 267
    //   605: iconst_1
    //   606: ldc_w 2721
    //   609: aload 6
    //   611: invokestatic 1283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   614: aload 5
    //   616: astore 6
    //   618: goto -445 -> 173
    //   621: ldc_w 2722
    //   624: istore_3
    //   625: goto -434 -> 191
    //   628: astore 5
    //   630: ldc_w 267
    //   633: iconst_1
    //   634: ldc_w 2724
    //   637: aload 5
    //   639: invokestatic 1283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
      return new int[] { 2130845151, 2130845136, 2130845147, 2130845153, 2130845155, 2130845157, 2130845140, 2130845134, 2130845138, 2130845108, 2130845149 };
    }
    return new int[] { 2130845152, 2130845137, 2130845148, 2130845154, 2130845156, 2130845158, 2130845141, 2130845135, 2130845139, 2130845109, 2130845149 };
  }
  
  void b()
  {
    int i1 = 1;
    if (this.jdField_a_of_type_ArrayOfAndroidViewView[3] == null) {}
    String str;
    do
    {
      return;
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "qqsettingme_f2f_guide", 0);
      int i2 = localSharedPreferences.getInt("qqsettingme_f2f_guide_switch", 0);
      str = localSharedPreferences.getString("qqsettingme_f2f_guide_tip", ajjy.a(2131644961));
      boolean bool = localSharedPreferences.getBoolean("qqsettingme_f2f_guide_flag", false);
      if (QLog.isColorLevel()) {
        QLog.i("QQSettingRedesign", 2, String.format("updateFace2FaceGuide switch_hasShowed = %d_%b", new Object[] { Integer.valueOf(i2), Boolean.valueOf(bool) }));
      }
      if ((i2 == 1) && (!bool)) {}
      while ((i1 == 0) && (this.o != null))
      {
        this.o.setVisibility(8);
        return;
        i1 = 0;
      }
    } while ((i1 == 0) || ((this.o != null) && (this.o.getVisibility() == 0)));
    d(str);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 50L);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.14(this, paramString));
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
    this.jdField_a_of_type_Aqeb.d();
    awri.a().b("QQSettingMe");
  }
  
  public void c(String paramString)
  {
    ThreadManager.post(new QQSettingMe.15(this, paramString), 5, null, false);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onDestroy!");
    }
    if (this.jdField_d_of_type_Boolean)
    {
      e();
      this.jdField_a_of_type_Axlu.a();
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
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajfo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajgf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajvf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajrp);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a);
      }
      if (this.jdField_a_of_type_Avev != null)
      {
        this.jdField_a_of_type_Avev.b(this.jdField_a_of_type_Avcn);
        this.jdField_a_of_type_Avev.b(this.jdField_a_of_type_Avck);
        this.jdField_a_of_type_Avev.b(this.jdField_a_of_type_Avci);
      }
      if (this.jdField_a_of_type_Ahye != null)
      {
        this.jdField_a_of_type_Ahye.a(null);
        this.jdField_a_of_type_Ahye = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atdh);
    }
    VSNetworkHelper.a().a();
    if (this.jdField_a_of_type_Axlu != null) {
      this.jdField_a_of_type_Axlu.a(this.jdField_a_of_type_Axlx, false);
    }
    bapw.a().b(this.jdField_a_of_type_Bapy);
    xfz.a().b(this.jdField_a_of_type_Xga);
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajgf, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajfo, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atdh);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajvf, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajrp, true);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a);
      }
      this.jdField_a_of_type_Axlu.a(this.jdField_a_of_type_Axlx, true);
      this.jdField_a_of_type_Ahye = ((ahye)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(114));
      if (this.jdField_a_of_type_Ahye != null) {
        this.jdField_a_of_type_Ahye.a(this.jdField_a_of_type_Ahyf);
      }
      bapw.a().a(this.jdField_a_of_type_Bapy);
      xfz.a().a(this.jdField_a_of_type_Xga);
    }
  }
  
  public void g()
  {
    SosoInterface.a(new abnb(this, 0, true, true, 60000L, true, false, "QQSettingRedesign"));
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
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = akgo.a().a();
    this.jdField_a_of_type_Axlu = new axlu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      if (TextUtils.isEmpty(bapw.a().jdField_b_of_type_JavaLangString)) {
        ThreadManager.post(new QQSettingMe.7(this), 5, null, true);
      }
      O();
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
    ThreadManager.post(new QQSettingMe.12(this), 5, null, false);
  }
  
  public void j()
  {
    Q();
    T();
    U();
    o();
    p();
    t();
    u();
    B();
    q();
    k();
    r();
    s();
    C();
    W();
    aa();
  }
  
  protected void k()
  {
    try
    {
      a(4, this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      ((aufu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(104)).a(this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
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
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable(bacm.b());
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    b(str);
    if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    for (;;)
    {
      ThreadManager.postImmediately(new QQSettingMe.13(this, str), null, true);
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
    int i2 = 0;
    if (this.jdField_a_of_type_Axlu != null) {
      this.jdField_a_of_type_Axlu.b();
    }
    Object localObject2;
    boolean bool;
    label133:
    int i1;
    if (awnu.b())
    {
      this.m.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.m).a(53).a();
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "ThemeDebugKeyLog:onPostThemeChanged, refresh pendant after theme changed.");
      }
      y();
      U();
      this.jdField_h_of_type_Boolean = true;
      localObject2 = ThemeUtil.getCurrentThemeInfo();
      Object localObject1 = ((Bundle)localObject2).getString("themeId");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"1000".equals(localObject1)) && (!"1103".equals(localObject1))) {
        break label579;
      }
      bool = true;
      this.jdField_j_of_type_Boolean = bool;
      a(null);
      if (!this.jdField_j_of_type_Boolean) {
        break label584;
      }
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131100723);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845142);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845124);
      label184:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((!beeu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) {
        break label621;
      }
      a(true);
      label220:
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onPostThemeChanged, color=" + i1 + ",themeid = " + (String)localObject1 + ", enginePath=" + ((Bundle)localObject2).getString("themePath"));
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i1);
      N();
      localObject2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131302073);
      if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
        break label629;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      label366:
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"1000".equals(localObject1))) {
        break label656;
      }
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      label393:
      C();
      e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      R();
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i1);
      localObject1 = a(this.jdField_j_of_type_Boolean);
      label430:
      if (i2 >= 11) {
        break label689;
      }
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[i2] != null)
      {
        ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131302723)).setImageResource(localObject1[i2]);
        localObject2 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131302761);
        if (this.jdField_j_of_type_Boolean) {
          break label668;
        }
        ((TextView)localObject2).setTextColor(i1);
      }
    }
    for (;;)
    {
      if ((awnu.b()) && ("2920".equals(ThemeUtil.getCurrentThemeId()))) {
        ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131100722));
      }
      i2 += 1;
      break label430;
      this.m.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidViewView).a(53).a();
      break;
      label579:
      bool = false;
      break label133;
      label584:
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131100724);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845146);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845123);
      break label184;
      label621:
      a(false);
      break label220;
      label629:
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
      break label366;
      label656:
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      break label393;
      label668:
      ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131100722));
    }
    label689:
    ((alkl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe onPostThemeChanged refresh because simple theme switch!");
      }
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    ((ajqy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(87)).notifyUI(4, true, null);
  }
  
  public void n()
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int i1 = this.jdField_a_of_type_Axlu.a();
    String str;
    if (i1 == 1) {
      if (this.jdField_j_of_type_Boolean)
      {
        localObject1 = ((Resources)localObject2).getDrawable(2130845124);
        str = ((Resources)localObject2).getString(2131633651);
        localObject2 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      if (localObject2 != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      }
      if (localObject1 != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      }
      return;
      localObject1 = ((Resources)localObject2).getDrawable(2130845123);
      break;
      if (i1 == 2)
      {
        if (this.jdField_j_of_type_Boolean) {}
        for (localObject1 = ((Resources)localObject2).getDrawable(2130845124);; localObject1 = ((Resources)localObject2).getDrawable(2130845123))
        {
          str = ((Resources)localObject2).getString(2131633651);
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
    boolean bool1 = akgo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.a(bool1);
    }
    if ((!bool1) && (ajop.a(1)))
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
        this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch.b(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      }
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (!this.jdField_d_of_type_Boolean)) {}
    long l1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((this.jdField_b_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < 500L))
            {
              this.jdField_b_of_type_Long = System.currentTimeMillis();
              return;
            }
            this.jdField_b_of_type_Long = System.currentTimeMillis();
            switch (paramView.getId())
            {
            case 2131302919: 
            default: 
              return;
            }
          } while (!FrameHelperActivity.b());
          FrameHelperActivity.c(true);
          FrameHelperActivity.s();
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009C4E", "0X8009C4E", 0, 0, "", "", "", "");
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
            F();
            i("0X8007CAC");
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
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_duty", "", "locker", "clk", 0, 0, "", "", "", "");
          }
          paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
          paramView.g = 1;
          paramView.h = 8;
          ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 1009);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D6");
          return;
          paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
          paramView.g = 1;
          paramView.h = 8;
          ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 1009);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D7");
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
        } while (!this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X8006726");
        return;
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        paramView.putExtra("title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131651449));
        paramView.putExtra("nick", babh.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1));
        paramView.putExtra("uin", (String)localObject1);
        paramView.putExtra("type", 1);
        paramView.putExtra("reportFlag", 1);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055BB", "0X80055BB", 0, 0, "", "", "", "");
        return;
        if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
        {
          CheckPermission.requestSDCardPermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
          return;
        }
        l1 = System.currentTimeMillis();
      } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l1));
      this.jdField_a_of_type_Long = l1;
    } while (!QWalletHelper.isValidToLaunchQWallet(l1));
    QWalletHelper.launchQWalletAct(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_wallet", "Clk_wallet", 0, 0, "", "", "", "");
    azys.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i2 = ajve.b(ajve.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
    ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(100007, 31);
    int i1 = i2;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[1].a()) {
      i1 = i2 + 4;
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8BF", "0X800A8BF", i1, 0, String.valueOf(i1), "", "", "");
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
      bfhn.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, -1, bool);
      bfhz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0);
      bfid.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
      ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(103000, 31);
      return;
    }
    paramView = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    bool = false;
    Object localObject1 = new bfpl();
    ((bfpl)localObject1).a("443");
    ((bfpl)localObject1).b("3");
    ((bfpl)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    if ((this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1))
    {
      bool = true;
      ((bfpl)localObject1).c("1");
    }
    Object localObject2;
    for (;;)
    {
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (bfpl)localObject1);
      paramView.a(100180, 31);
      try
      {
        l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
        localObject2 = bfpy.a();
        ((bfpy)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
        paramView = (View)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramView = babh.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        ((bfpy)localObject2).jdField_b_of_type_JavaLangString = paramView;
        bfpr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (bfpy)localObject2, Long.valueOf(l1), 0, bool, -1);
        paramView = new bfpl();
        paramView.jdField_c_of_type_JavaLangString = "1";
        paramView.d = "0";
        paramView.jdField_b_of_type_Int = 4;
        paramView.l = "3";
        paramView.m = "drawerAlbumList";
        paramView.n = "QZonePhotoListActivity";
        QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView);
        paramView = new HashMap();
        paramView.put("source_type", "3");
        paramView.put("source_from", "drawerAlbumList");
        paramView.put("source_to", "QZonePhotoListActivity");
        awrn.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramView, null);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
        DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
        return;
        ((bfpl)localObject1).c("2");
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
    if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      CheckPermission.requestSDCardPermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      return;
    }
    localObject1 = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    ((auqh)localObject1).a(100005, 31);
    if (((RedTouch)((ViewGroup)paramView).getChildAt(0)).a()) {}
    for (paramView = bfvl.a(((auqh)localObject1).a(String.valueOf(100005)));; paramView = null)
    {
      VasWebviewUtil.openIndividuationIndex(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView);
      ThreadManager.post(new QQSettingMe.16(this), 5, null, true);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Personality_setting", 0, 0, "", "", "", "");
      DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQSettingSettingActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
      if (akgo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004DB0", "0X8004DB0", 0, 0, "", "", akgo.a(), "");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0)) {
        ajgd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iNewTimeStamp);
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
      ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(100190, 31);
      DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
      return;
      if (axkz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "", new abmi(this))) {
        break;
      }
      S();
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramView.putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=draw");
      paramView.putExtra("hide_more_button", true);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A9C3", "0X800A9C3", 0, 0, "", "", "", "");
      return;
      i1 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getInt("cur_adcode", 0);
      paramView = "mqqapi://miniapp/open?_atype=0&_mappid=1108323226&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2066&_sig=191577ab932c397857a3cb26aa1938bfa257d305ad390c43ae02ca77df0753e7&areaId=" + i1;
      MiniAppLauncher.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 2066, null);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A42C", "0X800A42C", 0, 0, "", "", "", "");
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005BE4", "0X8005BE4", 0, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_Avev != null) && (!this.jdField_a_of_type_Avev.a()))
      {
        ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(100450, 31);
        if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
        {
          paramView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131309486);
          if ((paramView != null) && (paramView.getText() != null))
          {
            paramView = new Bundle();
            paramView.putInt("from_type", 3);
            SignTextEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, "", paramView, -1);
          }
        }
        DrawerFrame.jdField_a_of_type_Int = 0;
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "set_enter", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D8");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X800A669");
      return;
      l1 = System.currentTimeMillis();
      if (!ProfileActivity.a(this.jdField_a_of_type_Long, l1)) {
        break;
      }
      this.jdField_a_of_type_Long = l1;
      if (QLog.isColorLevel()) {
        QLog.i("QQSettingRedesign", 2, "enter vip");
      }
      ThreadManager.post(new QQSettingMe.18(this), 5, null, true);
      i1 = ajve.b(ajve.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
      paramView = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[0].a())
      {
        paramView = bfvl.a(paramView.a(String.valueOf(100400)));
        i1 += 4;
      }
      for (;;)
      {
        for (;;)
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8BE", "0X800A8BE", i1, 0, String.valueOf(i1), "", "", "");
          f(paramView);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
          if (jdField_a_of_type_Int > 0)
          {
            DrawerFrame.jdField_a_of_type_Int = 2;
            return;
          }
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          return;
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, FileAssistantActivity.class);
          paramView.putExtra("from", "FileAssistant");
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          paramView = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          localObject1 = paramView.a(String.valueOf(100160));
          if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0)) {
            paramView.a(100160, 31);
          }
          try
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("service_type", 2);
            ((JSONObject)localObject2).put("act_id", 1002);
            paramView.c((BusinessInfoCheckUpdate.AppInfo)localObject1, ((JSONObject)localObject2).toString());
            if ((this.o == null) || (this.o.getVisibility() != 0)) {
              break;
            }
            this.o.setVisibility(8);
            BaseApplication.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "qqsettingme_f2f_guide", 0).edit().putBoolean("qqsettingme_f2f_guide_flag", true).apply();
            return;
          }
          catch (JSONException paramView)
          {
            for (;;)
            {
              paramView.printStackTrace();
            }
          }
        }
        if (jdField_a_of_type_Int > 0)
        {
          DrawerFrame.jdField_a_of_type_Int = 2;
          return;
        }
        DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
        return;
        localObject2 = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        localObject1 = "";
        BusinessInfoCheckUpdate.AppInfo localAppInfo = ((auqh)localObject2).a(String.valueOf(100500));
        paramView = (View)localObject1;
        if (localAppInfo != null)
        {
          paramView = (View)localObject1;
          if (localAppInfo.iNewFlag.get() != 0)
          {
            paramView = bfvl.a(localAppInfo);
            ((auqh)localObject2).a(100500, 31);
          }
        }
        localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).getString("drawerUrl", "");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          QLog.e("QQSettingRedesign", 1, "cuKingCard url = null");
        }
        paramView = (String)localObject1 + paramView;
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
        i2 = ajve.b(ajve.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
        i1 = i2;
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[9].a()) {
          i1 = i2 + 4;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C0", "0X800A8C0", i1, 0, String.valueOf(i1), "", "", "");
        return;
        QQStoryMemoriesActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, QQStoryContext.a().b(), true);
        DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        localObject1 = paramView.getSharedPreferences("call_tim_config_pre" + (String)localObject1, 0).getString("call_tim_config_url", null);
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = ammt.a().a();
        }
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = "https://docs.qq.com/desktop/m/index.html";
        }
        paramView = axfs.b((String)localObject1, "s_qq_drawer");
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        ((Intent)localObject1).putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
        ((Intent)localObject1).putExtra("tdsourcetag", "s_qq_drawer");
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800887E", "0X800887E", 0, 0, "", "", "", "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMedalList == null) {}
        for (paramView = null; TextUtils.isEmpty(paramView); paramView = this.jdField_a_of_type_ComTencentMobileqqDataMedalList.jumpUrl)
        {
          paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
          paramView.g = 1;
          paramView.h = 8;
          ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 1009);
          QLog.e("QVipSettingMe.", 1, "medal list have no jump url ,so use the default");
          return;
        }
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
        i1 = ajve.b(ajve.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X800A127", 0, 0, String.valueOf(i1), "", "", "");
        return;
        azyk.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97F", "0X800A97F", 0, 0, "0", "0", "", "");
        return;
        paramView = null;
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
      a(1, this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
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
      a(2, this.jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
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
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(1000017));
      if (!((alov)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a())
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
      a(5, this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
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
    //   2: getfield 276	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5: invokevirtual 906	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   8: putfield 3374	com/tencent/mobileqq/activity/QQSettingMe:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 3374	com/tencent/mobileqq/activity/QQSettingMe:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokestatic 1796	ajve:a	(Ljava/lang/String;)LMQQ/PayRuleCfg;
    //   19: putfield 1210	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   22: aload_0
    //   23: getfield 276	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: aload_0
    //   27: getfield 1210	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   30: aload_0
    //   31: getfield 2449	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   34: invokestatic 3377	ajve:a	(Lcom/tencent/mobileqq/app/QQAppInterface;LMQQ/PayRuleCfg;Z)Z
    //   37: istore_1
    //   38: aload_0
    //   39: getfield 1210	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   42: ifnonnull +271 -> 313
    //   45: ldc_w 267
    //   48: iconst_1
    //   49: ldc_w 3379
    //   52: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iload_1
    //   56: ifeq +345 -> 401
    //   59: aload_0
    //   60: getfield 2449	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   63: ifne +64 -> 127
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 2449	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   71: aconst_null
    //   72: ldc_w 1200
    //   75: ldc_w 436
    //   78: ldc_w 436
    //   81: ldc_w 436
    //   84: ldc_w 3381
    //   87: aload_0
    //   88: getfield 1210	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   91: invokestatic 3383	ajve:a	(LMQQ/PayRuleCfg;)I
    //   94: iconst_1
    //   95: iconst_0
    //   96: ldc_w 3108
    //   99: aload_0
    //   100: getfield 1210	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   103: getfield 3386	MQQ/PayRuleCfg:advId	Ljava/lang/String;
    //   106: ldc_w 436
    //   109: ldc_w 436
    //   112: invokestatic 3389	awqx:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   115: bipush 101
    //   117: aload_0
    //   118: getfield 1210	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   121: getfield 3386	MQQ/PayRuleCfg:advId	Ljava/lang/String;
    //   124: invokestatic 3392	ajve:a	(ILjava/lang/String;)V
    //   127: aload_0
    //   128: invokespecial 3394	com/tencent/mobileqq/activity/QQSettingMe:V	()V
    //   131: invokestatic 265	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +36 -> 170
    //   137: ldc_w 267
    //   140: iconst_2
    //   141: new 280	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 3396
    //   151: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: getfield 954	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   158: invokestatic 3397	auqh:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)Ljava/lang/String;
    //   161: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 426	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 556	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: new 1002	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   173: dup
    //   174: invokespecial 1398	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   177: astore_2
    //   178: aload_2
    //   179: aload_0
    //   180: getfield 954	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   183: invokevirtual 1401	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   186: iload_1
    //   187: ifeq +54 -> 241
    //   190: aload_2
    //   191: invokestatic 3400	com/tencent/mobileqq/redtouch/RedTouchTextView:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)Ljava/util/List;
    //   194: ifnull +47 -> 241
    //   197: new 89	java/util/ArrayList
    //   200: dup
    //   201: invokespecial 92	java/util/ArrayList:<init>	()V
    //   204: astore_3
    //   205: new 1435	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   208: dup
    //   209: invokespecial 1459	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   212: astore 4
    //   214: aload 4
    //   216: getfield 1439	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: iconst_0
    //   220: invokevirtual 1461	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   223: aload_3
    //   224: aload 4
    //   226: invokevirtual 974	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   229: pop
    //   230: aload_2
    //   231: getfield 1413	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   234: getfield 1422	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   237: aload_3
    //   238: invokevirtual 1458	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   241: aload_0
    //   242: iconst_0
    //   243: aload_2
    //   244: invokespecial 1294	com/tencent/mobileqq/activity/QQSettingMe:a	(ILcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   247: aload_0
    //   248: getfield 276	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   251: ifnull +61 -> 312
    //   254: aload_0
    //   255: getfield 954	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   258: ifnull +163 -> 421
    //   261: aload_0
    //   262: getfield 954	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   265: getfield 1405	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   268: invokevirtual 1409	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   271: iconst_1
    //   272: if_icmpeq +6 -> 278
    //   275: goto +146 -> 421
    //   278: ldc_w 267
    //   281: iconst_1
    //   282: ldc_w 3402
    //   285: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: new 1939	android/content/Intent
    //   291: dup
    //   292: aload_0
    //   293: getfield 274	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   296: ldc_w 3404
    //   299: invokespecial 1944	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   302: astore_2
    //   303: aload_0
    //   304: getfield 274	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   307: aload_2
    //   308: invokevirtual 3408	com/tencent/mobileqq/app/BaseActivity:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   311: pop
    //   312: return
    //   313: ldc_w 267
    //   316: iconst_1
    //   317: new 280	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 3410
    //   327: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: getfield 1210	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   334: getfield 1215	MQQ/PayRuleCfg:iconText	Ljava/lang/String;
    //   337: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc_w 3412
    //   343: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload_1
    //   347: invokevirtual 1100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   350: ldc_w 3414
    //   353: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_0
    //   357: getfield 1210	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   360: getfield 1218	MQQ/PayRuleCfg:iconUrl	Ljava/lang/String;
    //   363: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc_w 3416
    //   369: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_0
    //   373: getfield 2449	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   376: invokevirtual 1100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   379: invokevirtual 426	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: goto -330 -> 55
    //   388: astore_2
    //   389: ldc_w 267
    //   392: iconst_1
    //   393: ldc_w 3418
    //   396: aload_2
    //   397: invokestatic 1283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: return
    //   401: aload_0
    //   402: invokevirtual 3421	com/tencent/mobileqq/activity/QQSettingMe:w	()V
    //   405: goto -274 -> 131
    //   408: astore_2
    //   409: ldc_w 267
    //   412: iconst_2
    //   413: ldc_w 3423
    //   416: aload_2
    //   417: invokestatic 1283	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: return
    //   421: iload_1
    //   422: ifeq -110 -> 312
    //   425: goto -147 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	QQSettingMe
    //   37	385	1	bool	boolean
    //   177	131	2	localObject	Object
    //   388	9	2	localException	Exception
    //   408	9	2	localThrowable	Throwable
    //   204	34	3	localArrayList	ArrayList
    //   212	13	4	localRedTypeInfo	BusinessInfoCheckUpdate.RedTypeInfo
    // Exception table:
    //   from	to	target	type
    //   0	55	388	java/lang/Exception
    //   59	127	388	java/lang/Exception
    //   127	131	388	java/lang/Exception
    //   131	170	388	java/lang/Exception
    //   170	186	388	java/lang/Exception
    //   190	241	388	java/lang/Exception
    //   241	275	388	java/lang/Exception
    //   278	303	388	java/lang/Exception
    //   303	312	388	java/lang/Exception
    //   313	385	388	java/lang/Exception
    //   401	405	388	java/lang/Exception
    //   409	420	388	java/lang/Exception
    //   303	312	408	java/lang/Throwable
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
    TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131302745);
    localTextView.setText("");
    localTextView.setBackgroundDrawable(null);
  }
  
  public void x()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.22(this));
  }
  
  public void y()
  {
    ExtensionInfo localExtensionInfo = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (awnu.b())
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    label240:
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
        if (baau.a(localExtensionInfo.pendantId))
        {
          ((PendantInfo)localObject).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.h, localExtensionInfo.uin, localExtensionInfo.pendantDiyId);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarPendant", "choutishow", 0, 0, "", "", "", "");
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if ((i1 != 1) || (i1 != this.jdField_i_of_type_Boolean)) {
          break label240;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X8006728");
        return;
        ((PendantInfo)localObject).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.h, localExtensionInfo.uin, localExtensionInfo.pendantDiyId);
        break;
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  public void z()
  {
    this.jdField_a_of_type_Avev = ((avev)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15));
    if ((this.jdField_a_of_type_Avev == null) || (this.jdField_e_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_Avcn == null)
    {
      this.jdField_a_of_type_Avcn = new abmm(this);
      this.jdField_a_of_type_Avck = new abmn(this);
      this.jdField_a_of_type_Avci = new abmo(this);
      this.jdField_a_of_type_Avev.a(this.jdField_a_of_type_Avcn);
      this.jdField_a_of_type_Avev.a(this.jdField_a_of_type_Avck);
      this.jdField_a_of_type_Avev.a(this.jdField_a_of_type_Avci);
    }
    RichStatus localRichStatus = this.jdField_a_of_type_Avev.a(false);
    if ((localRichStatus == null) || (localRichStatus.isEmpty()))
    {
      ThreadManager.getFileThreadHandler().post(new QQSettingMe.26(this));
      return;
    }
    a(localRichStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe
 * JD-Core Version:    0.7.0.1
 */
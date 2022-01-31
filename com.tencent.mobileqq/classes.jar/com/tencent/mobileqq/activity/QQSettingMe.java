package com.tencent.mobileqq.activity;

import MQQ.PayRuleCfg;
import QQService.EVIPSPEC;
import abwe;
import abwf;
import abwg;
import abwh;
import abwi;
import abwj;
import abwk;
import abwl;
import abwm;
import abwn;
import abwo;
import abwp;
import abwq;
import abwr;
import abws;
import abwt;
import abwu;
import abwv;
import abww;
import abwx;
import abwy;
import abxa;
import abxb;
import aikv;
import aikw;
import ajtc;
import ajtd;
import ajti;
import ajto;
import ajud;
import ajuf;
import ajxj;
import ajxl;
import ajya;
import ajzt;
import ajzx;
import ajzz;
import akcy;
import akfh;
import akfy;
import akjn;
import akjo;
import akuz;
import alyy;
import amdj;
import ande;
import andf;
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
import annv;
import aqyf;
import asay;
import atxc;
import atxd;
import atxk;
import atzn;
import avfc;
import avps;
import awcd;
import awcf;
import awci;
import aweq;
import awzy;
import axlk;
import axmv;
import axqy;
import axri;
import axrn;
import ayfx;
import aykk;
import aylh;
import aymc;
import aymf;
import aywn;
import baww;
import bayh;
import bbac;
import bbak;
import bbbr;
import bbcm;
import bbcz;
import bbdh;
import bbdx;
import bbef;
import bbfj;
import bblt;
import bblu;
import bblv;
import bbqd;
import bbsh;
import bbsj;
import bbti;
import bbxj;
import bcql;
import bfnd;
import bfnf;
import bfwx;
import bgpw;
import bgqi;
import bgqm;
import bgyj;
import bgyp;
import bgyw;
import bhem;
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
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
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
import com.tencent.mobileqq.utils.VipUtils;
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
import common.config.service.QzoneConfig;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
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
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import muc;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;
import sst;
import tencent.im.oidb.redInfo.RedInfo;
import vzl;
import xow;
import xox;

public class QQSettingMe
  implements View.OnClickListener, View.OnTouchListener
{
  public static int a;
  private static List<String> jdField_a_of_type_JavaUtilList;
  private static List<String> jdField_b_of_type_JavaUtilList;
  protected long a;
  private PayRuleCfg jdField_a_of_type_MQQPayRuleCfg;
  private aikv jdField_a_of_type_Aikv;
  private aikw jdField_a_of_type_Aikw = new abwy(this);
  ajto jdField_a_of_type_Ajto = new abwr(this);
  private ajuf jdField_a_of_type_Ajuf = new abwq(this);
  private ajxj jdField_a_of_type_Ajxj = new abws(this);
  private ajzz jdField_a_of_type_Ajzz = new abwu(this);
  private akfy jdField_a_of_type_Akfy = new abwv(this);
  private akjo jdField_a_of_type_Akjo = new abwo(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new abwe(this);
  Handler jdField_a_of_type_AndroidOsHandler = new abwx(this, Looper.getMainLooper());
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new abwj(this);
  protected View a;
  public ViewGroup a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  private aqyf jdField_a_of_type_Aqyf = new aqyf("QQSetting_me", "com.tencent.mobileqq:tool");
  private atzn jdField_a_of_type_Atzn = new abwn(this);
  private awcd jdField_a_of_type_Awcd;
  private awcf jdField_a_of_type_Awcf;
  private awci jdField_a_of_type_Awci;
  private aweq jdField_a_of_type_Aweq;
  private aymc jdField_a_of_type_Aymc;
  aymf jdField_a_of_type_Aymf = new abwt(this);
  private bbsj jdField_a_of_type_Bbsj = new abww(this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private SettingMeApolloViewController jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController;
  public BaseActivity a;
  private FrameHelperActivity jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity;
  public QQAppInterface a;
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  protected DynamicAvatarView a;
  public Card a;
  private MedalList jdField_a_of_type_ComTencentMobileqqDataMedalList;
  private LoveZoneTabRedDotView jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView;
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
  private ConcurrentHashMap<String, bfwx> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private redInfo.RedInfo jdField_a_of_type_TencentImOidbRedInfo$RedInfo;
  public xox a;
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
  private View jdField_m_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private View jdField_n_of_type_AndroidViewView;
  BusinessInfoCheckUpdate.AppInfo jdField_n_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
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
    this.jdField_a_of_type_Xox = new abxb(this);
    this.jdField_b_of_type_AndroidOsHandler = new abwf(this, Looper.getMainLooper());
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->QQSettingMe construct!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = paramFrameHelperActivity;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561081, null));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367408);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(ajya.a(2131710767));
    }
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367376));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363079));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367421);
    this.jdField_m_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376227);
    paramFrameHelperActivity = paramQQAppInterface.getCurrentAccountUin();
    label696:
    Object localObject1;
    Object localObject2;
    String str;
    boolean bool;
    if ((paramFrameHelperActivity == null) || (paramFrameHelperActivity.length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130839736);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370833).setOnClickListener(this);
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298249);
      this.jdField_c_of_type_Int = (axlk.jdField_a_of_type_Int - axlk.a(94.0F) - i1 - axlk.a(45.0F));
      this.jdField_d_of_type_Int = (axlk.jdField_a_of_type_Int - axlk.a(94.0F) - i1 - axlk.a(20.0F));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370832));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramFrameHelperActivity);
      if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim()))) {
        this.jdField_a_of_type_JavaLangString = paramFrameHelperActivity;
      }
      if (!axmv.b()) {
        break label2285;
      }
      this.jdField_m_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.jdField_m_of_type_AndroidViewView).a(53).a();
      this.jdField_b_of_type_AndroidViewView.setVisibility(VasFaceManager.a(paramFrameHelperActivity, paramQQAppInterface));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371365));
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView = ((QVipMedalView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373144));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373049);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373050);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379270));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373171));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText("");
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362993));
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362991));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373407));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366687));
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        paramBaseActivity.topMargin = (axlk.a(29.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370632));
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBaseActivity.topMargin = (axlk.a(35.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBaseActivity);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376202)).a(53).a();
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376196);
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_e_of_type_AndroidViewView).b(10).a(19).a();
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView.setOnTouchListener(muc.a);
      this.jdField_l_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371992);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView = ((FixedBounceScrollView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370132));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setDamping(2.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setBounceDelay(600L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setmCustomTopFadingEdgeScale(0.675F);
      i1 = (int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131298243);
      paramBaseActivity = this.jdField_a_of_type_AndroidViewViewGroup.getResources();
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[13];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch = new RedTouch[13];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView = new RedTouchTextView[13];
      paramFrameHelperActivity = new int[13];
      FrameHelperActivity tmp1330_1329 = paramFrameHelperActivity;
      tmp1330_1329[0] = 2131370646;
      FrameHelperActivity tmp1336_1330 = tmp1330_1329;
      tmp1336_1330[1] = 2131370643;
      FrameHelperActivity tmp1342_1336 = tmp1336_1330;
      tmp1342_1336[2] = 2131370634;
      FrameHelperActivity tmp1348_1342 = tmp1342_1336;
      tmp1348_1342[3] = 2131370637;
      FrameHelperActivity tmp1354_1348 = tmp1348_1342;
      tmp1354_1348[4] = 2131370642;
      FrameHelperActivity tmp1360_1354 = tmp1354_1348;
      tmp1360_1354[5] = 2131370609;
      FrameHelperActivity tmp1366_1360 = tmp1360_1354;
      tmp1366_1360[6] = 2131370638;
      FrameHelperActivity tmp1373_1366 = tmp1366_1360;
      tmp1373_1366[7] = 2131370644;
      FrameHelperActivity tmp1380_1373 = tmp1373_1366;
      tmp1380_1373[8] = 2131370645;
      FrameHelperActivity tmp1387_1380 = tmp1380_1373;
      tmp1387_1380[9] = 2131370639;
      FrameHelperActivity tmp1394_1387 = tmp1387_1380;
      tmp1394_1387[10] = 2131363822;
      FrameHelperActivity tmp1401_1394 = tmp1394_1387;
      tmp1401_1394[11] = 2131364860;
      FrameHelperActivity tmp1408_1401 = tmp1401_1394;
      tmp1408_1401[12] = 2131370608;
      tmp1408_1401;
      localObject1 = new int[13];
      Object tmp1424_1422 = localObject1;
      tmp1424_1422[0] = 2131699425;
      Object tmp1430_1424 = tmp1424_1422;
      tmp1430_1424[1] = 2131699439;
      Object tmp1436_1430 = tmp1430_1424;
      tmp1436_1430[2] = 2131699451;
      Object tmp1442_1436 = tmp1436_1430;
      tmp1442_1436[3] = 2131699423;
      Object tmp1448_1442 = tmp1442_1436;
      tmp1448_1442[4] = 2131699468;
      Object tmp1454_1448 = tmp1448_1442;
      tmp1454_1448[5] = 2131699401;
      Object tmp1460_1454 = tmp1454_1448;
      tmp1460_1454[6] = 2131699409;
      Object tmp1467_1460 = tmp1460_1454;
      tmp1467_1460[7] = 2131699446;
      Object tmp1474_1467 = tmp1467_1460;
      tmp1474_1467[8] = 2131699412;
      Object tmp1481_1474 = tmp1474_1467;
      tmp1481_1474[9] = 2131699424;
      Object tmp1488_1481 = tmp1481_1474;
      tmp1488_1481[10] = 2131699392;
      Object tmp1495_1488 = tmp1488_1481;
      tmp1495_1488[11] = 2131699393;
      Object tmp1502_1495 = tmp1495_1488;
      tmp1502_1495[12] = 2131699422;
      tmp1502_1495;
      localObject2 = ThemeUtil.getCurrentThemeInfo();
      str = ((Bundle)localObject2).getString("themeId");
      if ((!TextUtils.isEmpty(str)) && (!"1000".equals(str)) && (!"1103".equals(str))) {
        break label2321;
      }
      bool = true;
      label1558:
      this.jdField_j_of_type_Boolean = bool;
      if (!this.jdField_j_of_type_Boolean) {
        break label2327;
      }
    }
    label2321:
    label2327:
    for (int i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166315);; i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166316))
    {
      int[] arrayOfInt = a(this.jdField_j_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe_init, color=" + i1 + ",themeid = " + str + ", enginePath=" + ((Bundle)localObject2).getString("themePath"));
      }
      int i3 = axlk.a(2.0F);
      localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370132);
      this.jdField_k_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.findViewById(2131370133);
      int i2 = 0;
      while (i2 < 13)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2] = ((View)localObject2).findViewById(paramFrameHelperActivity[i2]);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setFocusable(true);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(0);
        if (paramFrameHelperActivity[i2] == 2131370644) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
        }
        if (paramFrameHelperActivity[i2] == 2131370645) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
        }
        if (paramFrameHelperActivity[i2] == 2131363822) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
        }
        if (paramFrameHelperActivity[i2] == 2131370638)
        {
          this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView = ((LoveZoneTabRedDotView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368350));
          if (this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView != null) {
            this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.setVisibility(8);
          }
        }
        if (paramFrameHelperActivity[i2] == 2131370608)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ArrayOfAndroidViewView[i2]);
          this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setOnClickListener(this);
        Object localObject3 = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368345);
        ((ImageView)localObject3).setImageResource(arrayOfInt[i2]);
        Object localObject4 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368385);
        ((TextView)localObject4).setText(localObject1[i2]);
        if (!this.jdField_j_of_type_Boolean) {
          ((TextView)localObject4).setTextColor(i1);
        }
        if (paramFrameHelperActivity[i2] == 2131370639) {
          a((ImageView)localObject3, (TextView)localObject4);
        }
        if ((axmv.b()) && ("2920".equals(ThemeUtil.getCurrentThemeId()))) {
          ((TextView)localObject4).setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166314));
        }
        localObject3 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368369);
        ((ThemeLabelTextView)localObject3).setSupportMaskView(true);
        ((TextView)localObject3).setVisibility(0);
        baww.a(this.jdField_a_of_type_ArrayOfAndroidViewView[i2], paramBaseActivity.getString(localObject1[i2]), Button.class.getName());
        localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368345);
        ((View)localObject3).setPadding(i3, i3, i3, i3);
        localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject4).leftMargin -= i3;
        localObject4 = (RedTouchTextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368385);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((RedTouchTextView)localObject4).getLayoutParams();
        localLayoutParams.leftMargin -= i3;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i2] = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject3).a(53).a();
        this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[i2] = localObject4;
        if (paramFrameHelperActivity[i2] == 2131370608) {
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
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130839736);
      break;
      label2285:
      this.jdField_m_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.jdField_b_of_type_AndroidViewView).a(53).a();
      break label696;
      bool = false;
      break label1558;
    }
    ab();
    A();
    V();
    X();
    L();
    this.jdField_i_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368543);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    if ((TextUtils.isEmpty(str)) || ("1000".equals(str)))
    {
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363353);
      this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375988);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this);
      baww.a(this.jdField_g_of_type_AndroidViewView, ajya.a(2131710761), Button.class.getName());
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375990));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373101));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375989));
      this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView).a();
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370842);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this);
      baww.a(this.jdField_f_of_type_AndroidViewView, ajya.a(2131710744), Button.class.getName());
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370844));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370843));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[5].findViewById(2131368336));
      this.jdField_n_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369455);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378372));
      this.jdField_n_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_n_of_type_AndroidViewView.setOnTouchListener(this);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379384));
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376959));
      this.jdField_j_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376943);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376961));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376960));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379382));
      if (!axmv.b())
      {
        this.jdField_d_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        this.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        this.jdField_f_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      if (!ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, false, null)) {
        break label3011;
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
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845234);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845210);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i1);
      }
      return;
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      break;
      label3011:
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166315));
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166315));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166315));
    }
  }
  
  private void K()
  {
    if (this.jdField_k_of_type_Boolean) {
      return;
    }
    this.jdField_k_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new abwp(this));
  }
  
  private void L()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[11];
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
      if (ajzt.a()) {
        ((TextView)localView.findViewById(2131368385)).setText(str);
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
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    if (localView != null)
    {
      if (annv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("call_tim_config_pre" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("call_tim_config_title", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131699392));
        localView.setVisibility(0);
        ((TextView)localView.findViewById(2131368385)).setText(str);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800887D", "0X800887D", 0, 0, "", "", "", "");
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
    this.jdField_d_of_type_AndroidWidgetImageView.post(new QQSettingMe.9(this));
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
              localSonicPreloadData.url = bbqd.a("personalIndex");
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
        ((SonicPreloadData)localObject1).url = bbqd.a("personalIndex");
        localArrayList3.add(localObject1);
      }
      localObject1 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (((WebProcessManager)localObject1).a(localArrayList1)) {
        ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(String.valueOf("200010.200012"));
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
    a(this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    a(this.jdField_n_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
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
        str1 = String.format(ajya.a(2131699429), new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
    }
    for (String str2 = String.format(ajya.a(2131699466), new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });; str2 = ajya.a(2131699430))
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setText(str1);
      baww.a(this.jdField_n_of_type_AndroidViewView, str2, Button.class.getName());
      return;
      str1 = "9999+";
      break;
      str1 = ajya.a(2131699465);
    }
  }
  
  private void S()
  {
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_f_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_Aymc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    DrawerFrame.jdField_a_of_type_Int = 0;
    if (AppSetting.jdField_d_of_type_Boolean) {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label66;
      }
    }
    label66:
    for (String str = "关闭夜间模式";; str = "夜间模式 ")
    {
      baww.a(this.jdField_f_of_type_AndroidViewView, str, Button.class.getName());
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
    Object localObject2 = (atxd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    Object localObject1 = ((atxd)localObject2).a(-4);
    if ((((atxd)localObject2).a((RedTouchItem)localObject1, true)) && (((RedTouchItem)localObject1).count > 0) && (this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo != null))
    {
      QLog.d("QQSettingRedesign", 1, new Object[] { "updateProfileBubbleMsgView ", Integer.valueOf(((RedTouchItem)localObject1).count) });
      long l1;
      ImageView localImageView;
      TextView localTextView;
      View localView;
      if (this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.has())
      {
        l1 = this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.get();
        localObject2 = this.jdField_l_of_type_AndroidViewView.findViewById(2131371230);
        localImageView = (ImageView)this.jdField_l_of_type_AndroidViewView.findViewById(2131367376);
        localTextView = (TextView)this.jdField_l_of_type_AndroidViewView.findViewById(2131370452);
        localView = this.jdField_l_of_type_AndroidViewView.findViewById(2131368368);
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label385;
        }
        ((View)localObject2).setBackgroundResource(2130845214);
      }
      for (;;)
      {
        Object localObject3 = bbef.a(true);
        localObject3 = bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, l1 + "", 4, (Drawable)localObject3, (Drawable)localObject3);
        Drawable localDrawable = localImageView.getDrawable();
        if ((localDrawable != null) && (localDrawable != localObject3) && ((localDrawable instanceof bayh))) {
          ((bayh)localDrawable).a();
        }
        localImageView.setImageDrawable((Drawable)localObject3);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131699411, new Object[] { Integer.valueOf(((RedTouchItem)localObject1).count) });
        if (!((String)localObject1).equalsIgnoreCase(localTextView.getText().toString())) {
          localTextView.setText((CharSequence)localObject1);
        }
        ((View)localObject2).setContentDescription((CharSequence)localObject1);
        ((View)localObject2).setOnTouchListener(new abwh(this, localImageView, localTextView, localView));
        ((View)localObject2).setOnClickListener(this);
        this.jdField_l_of_type_AndroidViewView.setVisibility(0);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97E", "0X800A97E", 0, 0, "0", "0", "", "");
        return;
        l1 = 0L;
        break;
        label385:
        ((View)localObject2).setBackgroundResource(2130845213);
      }
    }
    this.jdField_l_of_type_AndroidViewView.setVisibility(8);
    ((ImageView)this.jdField_l_of_type_AndroidViewView.findViewById(2131367376)).setImageDrawable(null);
  }
  
  private void V()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[6];
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
        ad();
      }
    }
    return;
    label111:
    ae();
    return;
    label116:
    ((View)localObject).setVisibility(8);
    ae();
  }
  
  private void W()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[6];
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      localObject = asay.a(this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      int i1 = asay.a((String)localObject);
      LpReportInfo_dc03950.report(new LpReportInfo_dc03950("25", "10", i1 + "", "1"));
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
    a(6, this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
  
  private void X()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
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
  
  private void Y()
  {
    int i1 = 0;
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {}
    try
    {
      a(9, this.jdField_n_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (RedTouch.a(this.jdField_n_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo)) {
        i1 = 1;
      }
      axqy.b((QQAppInterface)localObject, "dc00898", "", "", "0X800ACDC", "0X800ACDC", 0, i1, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void Z()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_MQQPayRuleCfg.iconText)) || (TextUtils.isEmpty(this.jdField_a_of_type_MQQPayRuleCfg.iconUrl))) {
      QLog.e("QQSettingRedesign", 1, "showPayButton: iconText or iconUrl is empty");
    }
    Object localObject1;
    do
    {
      return;
      TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131368369);
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      abwi localabwi = new abwi(this, localTextView);
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
          localabwi.onLoadSuccessed((URLDrawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler showPayButton: ", localMalformedURLException);
        return;
      }
      localMalformedURLException.setText("");
      ((URLDrawable)localObject1).setURLDrawableListener(localabwi);
    } while (((URLDrawable)localObject1).getStatus() != 2);
    ((URLDrawable)localObject1).restartDownload();
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
        ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(i1, 30);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, "", "", "");
  }
  
  private void aa()
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
  
  private void ab()
  {
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vipTitleSpFile", 0).getString("vipTitleSpKey_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + ajzt.a(), "");
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateVipText sp vipText = " + str);
      }
      if (!TextUtils.isEmpty(str))
      {
        TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131368385);
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
  
  private void ac()
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
  
  private void ad()
  {
    Iterator localIterator = ajtc.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ajtd localajtd = (ajtd)localIterator.next();
      if ((localajtd instanceof ajzx)) {
        ((ajzx)localajtd).a();
      }
    }
  }
  
  private void ae()
  {
    Iterator localIterator = ajtc.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ajtd localajtd = (ajtd)localIterator.next();
      if ((localajtd instanceof ajzx)) {
        ((ajzx)localajtd).b();
      }
    }
  }
  
  private void af()
  {
    Object localObject = (atxd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    RedTouchItem localRedTouchItem1 = ((atxd)localObject).a(10015);
    RedTouchItem localRedTouchItem2 = ((atxd)localObject).a(10016);
    int i1;
    if ((atxk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && ((((atxd)localObject).a(localRedTouchItem1, false)) || (((atxd)localObject).a(localRedTouchItem2, false))))
    {
      i1 = 1;
      if (i1 != 0)
      {
        i1 = ((atxd)localObject).a();
        localObject = null;
        switch (i1)
        {
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
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
  
  private void ag()
  {
    annv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    View localView = this.jdField_k_of_type_AndroidViewView.findViewById(2131364860);
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
      if (((ViewGroup)localObject1).getChildAt(i1).getId() != 2131370638) {
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
    atxd localatxd = (atxd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    localatxd.a(100601, false);
    localatxd.a(10016, false);
    localatxd.a(10015, false);
    RedTouchItem localRedTouchItem = localatxd.a(-7);
    if (localatxd.a(localRedTouchItem, true)) {}
    try
    {
      af();
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
      ((TextView)localObject1).setBackgroundResource(2130843903);
      paramString = new FrameLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1, paramString);
      this.o = ((View)localObject1);
      this.o.setVisibility(8);
    }
  }
  
  private boolean d()
  {
    bbac.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (atxd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
    RedTouchItem localRedTouchItem = ((atxd)localObject).a(-4);
    if ((((atxd)localObject).a(localRedTouchItem, true)) && (localRedTouchItem.count > 0))
    {
      try
      {
        localObject = bbdx.a(atxc.a(-4));
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
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null))
      {
        if (!QLog.isColorLevel()) {
          break label1656;
        }
        QLog.d("QQSettingRedesign", 2, "updateQQLevelVipView card == null");
        return;
      }
      localSpannableStringBuilder = new SpannableStringBuilder();
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bSuperVipOpen != 1) {
        break label1056;
      }
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bQQVipOpen != 1) {
        break label1062;
      }
      bool2 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bBigClubVipOpen != 1) {
        break label1068;
      }
      i2 = 1;
      l1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.uCurMulType;
      i4 = this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQVipLevel;
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + i4 + ",QQLevel=" + this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel + ",curMulType =" + this.jdField_a_of_type_ComTencentMobileqqDataCard.uCurMulType);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      bool3 = bblt.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType);
      localObject = null;
      i1 = 0;
      if (!bool3) {
        break label1657;
      }
      localObject = bblt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, bblu.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType), bblt.b(this.jdField_a_of_type_ComTencentMobileqqDataCard.grayNameplateFlag));
      i1 = bblt.a(bblu.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType));
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
      paramString = bblt.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
      i1 = 2130846159;
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
            break label1450;
          }
          QLog.e("QQSettingRedesign", 1, (String)localObject);
          label383:
          if (!bool1) {
            break label1481;
          }
          i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_SUPERVIP);
          str = bblt.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
          i3 = 2130846160;
        }
      }
      label437:
      if ((str != null) && (i3 != 0))
      {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), this.jdField_a_of_type_AndroidWidgetImageView, str, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(i3));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131716818));
        this.jdField_a_of_type_AndroidWidgetImageView.setFocusableInTouchMode(true);
        paramString = bblv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, "VIA_SETTINGME");
        paramString.a();
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(paramString);
        if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298249);
          this.jdField_c_of_type_Int = (axlk.jdField_a_of_type_Int - axlk.a(94.0F) - i1 - axlk.a(45.0F) - axlk.a(45.0F));
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_c_of_type_Int);
        }
        if (bbsh.a().a(bool1, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingLoginTime)) {
          localSpannableStringBuilder.append(bbak.a(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView, localResources, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDanDisplatSwitch));
        }
        i2 = 0;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMedalList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() <= 0)) {
          break label1578;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setData(this.jdField_a_of_type_ComTencentMobileqqDataMedalList);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
          break label1555;
        }
        this.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#7bffffff"));
        label738:
        i2 = this.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() * vzl.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 21.0F) - vzl.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 6.0F);
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.", 1, "width =" + i2 + "update medal:" + this.jdField_a_of_type_ComTencentMobileqqDataMedalList.convert());
        }
        i1 = i2;
        if (!this.jdField_e_of_type_Boolean)
        {
          this.jdField_e_of_type_Boolean = true;
          i1 = akjn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X800A126", 0, 0, String.valueOf(i1), "", "", "");
          i1 = i2;
        }
        label889:
        localSpannableStringBuilder.append(bbak.a(localResources, this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType, this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel, a(i1)));
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setContentDescription("等级：" + this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
        a(bool1, bool2, i4);
        if (!AppSetting.jdField_d_of_type_Boolean) {
          break label1656;
        }
        paramString = new StringBuilder();
        paramString.append(this.jdField_a_of_type_JavaLangString);
        if (!bool1) {
          break label1628;
        }
        paramString.append("你是尊贵的超级会员");
        label1010:
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
      label1056:
      label1062:
      label1578:
      for (;;)
      {
        label1068:
        label1114:
        if (bool1)
        {
          i2 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_SUPERVIP);
          if ((i2 & 0xF) != 1) {
            break label1717;
          }
          i1 = 1;
          label1147:
          paramString = bblt.a((i2 & 0xF) << 8 | i2 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
          if (i1 == 0) {
            break label1722;
          }
          i1 = 2130846160;
          break label1708;
        }
        str = "occur error: curMulType=" + l1 + " but bSuperVipOpen is false";
        i2 = 0;
        paramString = (String)localObject;
        localObject = str;
        break label345;
        label1450:
        label1481:
        label1628:
        label1656:
        label1657:
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
                  paramString = bblt.a((i1 & 0xF) << 8 | i1 >> 8, this.jdField_a_of_type_ComTencentMobileqqDataCard.iBigClubVipLevel, this.jdField_a_of_type_ComTencentMobileqqDataCard.lBigClubTemplateId);
                  i1 = 2130846160;
                  break label1729;
                }
                i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
                paramString = bblt.a((i1 & 0xF) << 8 | i1 >> 8, this.jdField_a_of_type_ComTencentMobileqqDataCard.iBigClubVipLevel, this.jdField_a_of_type_ComTencentMobileqqDataCard.lBigClubTemplateId);
                i1 = 2130846158;
                break label1729;
              }
              str = "occur error: curMulType=" + l1 + " but bBigClubVipOpen userStatus=" + i2;
              i2 = i1;
              paramString = (String)localObject;
              localObject = str;
              i1 = i3;
              break label1740;
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
            str = bblt.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
            i3 = 2130846159;
            break label437;
            this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
            break label534;
            this.jdField_c_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166319));
            break label738;
            this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setVisibility(8);
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            i1 = i2;
            if (!QLog.isColorLevel()) {
              break label889;
            }
            QLog.d("QVipSettingMe.", 1, "medal list is null");
            i1 = i2;
            break label889;
            if (!bool2) {
              break label1010;
            }
            paramString.append("你是尊贵的会员");
            break label1010;
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
            break label1114;
          }
        } while (l1 != 4L);
      }
      for (;;)
      {
        label1555:
        label1708:
        i2 = 1;
        localObject = str;
        break;
        label1717:
        i1 = 0;
        break label1147;
        label1722:
        i1 = 2130846158;
      }
      label1729:
      localObject = null;
      i3 = 1;
      i2 = i1;
      i1 = i3;
      label1740:
      i3 = i1;
      i1 = i2;
      i2 = i3;
    }
  }
  
  private boolean e()
  {
    if (!this.jdField_d_of_type_Boolean) {
      return true;
    }
    long l1 = bbxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_last_request_success_time", 0L);
    int i1 = bbxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_vip_sync_freq", 0);
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
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(100400));
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
        i2 = bbfj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label499;
        }
        localObject = this.jdField_c_of_type_JavaLangString;
        i1 = 1;
        if (((String)localObject).contains("?")) {
          break label453;
        }
        localStringBuilder.append((String)localObject + "?platform=1&type=20001&networkInfo=" + i2);
        localObject = localStringBuilder.toString();
        localObject = ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a((String)localObject, localAppInfo);
        if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() == 0) || (localAppInfo.type.get() != 0)) {
          break label493;
        }
        bool = true;
        if ((paramString == null) || (i1 == 0)) {
          break label487;
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
        ((Intent)localObject).putExtra("leftBtnText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131689548));
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, 256L, (Intent)localObject, false, -1);
        paramString = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
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
      label453:
      localStringBuilder.append(str + "&platform=1&type=20001&networkInfo=" + i2);
      continue;
      label487:
      paramString = str;
      continue;
      label493:
      boolean bool = false;
      continue;
      label499:
      int i1 = 0;
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
  
  private void i(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Date localDate = new Date();
    if (!(localDate.getYear() + ":" + localDate.getMonth() + localDate.getDay()).equals(localSharedPreferences.getString("sign_in_report" + paramString, ""))) {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
  }
  
  void A()
  {
    this.jdField_a_of_type_Aweq = ((aweq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15));
    if (this.jdField_a_of_type_Aweq == null)
    {
      QLog.e("QQSettingRedesign", 1, "preLoadSignature, mStatusManager == null");
      return;
    }
    ImageView localImageView1 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131375235);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131375236);
    ImageView localImageView2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131367691);
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
      localImageView1.setImageBitmap(this.jdField_a_of_type_Aweq.a(i1, 200));
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
      localTextView.setText(2131699398);
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
      if (!axmv.b()) {
        break;
      }
      localImageView1.setVisibility(8);
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label117;
      label513:
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130845218);
      localImageView1.setVisibility(8);
      break label377;
      label542:
      ((StringBuilder)localObject1).append((String)localObject2);
      break label417;
      label553:
      localImageView2.setVisibility(0);
      if (bbdh.b()) {
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
    if (((ajti)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).b())
    {
      E();
      this.jdField_b_of_type_Boolean = false;
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_duty", "", "locker", "exp", 0, 0, "", "", "", "");
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
    int i9 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298249);
    int i10 = axlk.jdField_a_of_type_Int;
    int i11 = axlk.a(65.0F);
    int i12 = axlk.a(15.0F);
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
      localObject4 = ajya.a(2131710771);
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
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845237);
      localObject5 = (URLImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376201);
      localObject6 = (ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131368345);
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
      localObject2 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376203);
      localObject3 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131368385);
      ((TextView)localObject2).setMaxWidth(i10 - i9 - i11 - (i12 + i13));
      if (((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((bfnf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) || (!this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) || (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)))
      {
        ((TextView)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166319));
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
        localObject1 = String.format(ajya.a(2131710764), new Object[] { Integer.valueOf(i3) });
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
        if (awzy.a() - l1 <= 86400L)
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
              if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((!bfnf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) {
                continue;
              }
              localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130845237);
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
            localObject2 = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), bfnd.a((Bitmap)localObject2));
            break;
            localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130845238);
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
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845237);
    URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376201);
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131368345);
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
      localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376203);
      localObject3 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131368385);
      ((TextView)localObject1).setMaxWidth(axlk.jdField_a_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131298249) - axlk.a(65.0F) - (axlk.a(15.0F) + this.jdField_e_of_type_AndroidWidgetImageView.getWidth()));
      if (((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((bfnf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) || (!this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) || (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)))
      {
        ((TextView)localObject1).setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166319));
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
            if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((!bfnf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) {
              continue;
            }
            localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130845237);
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
          localObject1 = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), bfnd.a((Bitmap)localObject1));
          break;
          localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130845238);
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
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A42B", "0X800A42B", 0, 0, "", "", "", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (bbti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType))) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType != 0) {
        break label143;
      }
    }
    label143:
    for (int i1 = 99999;; i1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType)
    {
      axqy.b(null, "dc00898", "", "", "qq_vip", "0X800A778", i1, 0, "", "", "", "");
      return;
    }
  }
  
  void I()
  {
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.WebPreloadTask(this));
  }
  
  public void J()
  {
    this.jdField_a_of_type_Aqyf.b();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      int i1 = 0;
      if (localIterator.hasNext())
      {
        Bitmap localBitmap = ((bfwx)localIterator.next()).a();
        if (localBitmap == null) {
          break label70;
        }
        i1 = bbbr.a(localBitmap) + i1;
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
    float f2 = ((Resources)localObject).getDimension(2131298247);
    float f3 = ((Resources)localObject).getDimension(2131298231);
    float f4 = ((Resources)localObject).getDimension(2131298235);
    float f5 = ((Resources)localObject).getDimension(2131298239);
    float f6 = ((Resources)localObject).getDimension(2131298242);
    float f7 = ((Resources)localObject).getDimension(2131298249);
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
  
  public bfwx a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (bfwx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
    axri.a().a("QQSettingMe");
    if (!this.jdField_d_of_type_Boolean) {
      h();
    }
    this.jdField_k_of_type_AndroidViewView.setPadding(this.jdField_k_of_type_AndroidViewView.getPaddingLeft(), axlk.a(14.0F), this.jdField_k_of_type_AndroidViewView.getPaddingRight(), this.jdField_k_of_type_AndroidViewView.getPaddingBottom());
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
        ac();
        this.jdField_a_of_type_Aikv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      for (;;)
      {
        i();
        af();
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
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[8];
        Object localObject2;
        if (localObject1 != null)
        {
          localObject2 = (sst)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(181);
          if ((localObject2 == null) || (!((sst)localObject2).e())) {
            break;
          }
          ((View)localObject1).setVisibility(0);
        }
        L();
        M();
        b();
        V();
        X();
        K();
        if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()) && (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (axmv.b())) {
          ImmersiveUtils.a(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        }
        localObject1 = new int[13];
        Object tmp433_431 = localObject1;
        tmp433_431[0] = 2131370646;
        Object tmp439_433 = tmp433_431;
        tmp439_433[1] = 2131370643;
        Object tmp445_439 = tmp439_433;
        tmp445_439[2] = 2131370634;
        Object tmp451_445 = tmp445_439;
        tmp451_445[3] = 2131370637;
        Object tmp457_451 = tmp451_445;
        tmp457_451[4] = 2131370642;
        Object tmp463_457 = tmp457_451;
        tmp463_457[5] = 2131370609;
        Object tmp469_463 = tmp463_457;
        tmp469_463[6] = 2131370638;
        Object tmp476_469 = tmp469_463;
        tmp476_469[7] = 2131370644;
        Object tmp483_476 = tmp476_469;
        tmp483_476[8] = 2131370645;
        Object tmp490_483 = tmp483_476;
        tmp490_483[9] = 2131370639;
        Object tmp497_490 = tmp490_483;
        tmp497_490[10] = 2131363822;
        Object tmp504_497 = tmp497_490;
        tmp504_497[11] = 2131364860;
        Object tmp511_504 = tmp504_497;
        tmp511_504[12] = 2131370608;
        tmp511_504;
        i2 = akjn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
        i1 = 0;
        for (;;)
        {
          if (i1 >= 13) {
            return;
          }
          if ((localObject1[i1] != 2131370646) || (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() != 0)) {
            break;
          }
          localObject2 = ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(100400));
          int i3 = akjn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), RedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject2));
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C3", "0X800A8C3", i3, 0, String.valueOf(i3), "", "", "");
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
        if ((localThrowable[i1] == 2131370643) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() == 0)) {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C4", "0X800A8C4", i2, 0, String.valueOf(i2), "", "", "");
        } else if ((localThrowable[i1] == 2131364860) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() == 0)) {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C5", "0X800A8C5", i2, 0, String.valueOf(i2), "", "", "");
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramInt, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
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
      this.jdField_a_of_type_Aymc.a(paramQQAppInterface);
      l();
      z();
      U();
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
    ImageView localImageView1 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131375235);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131375236);
    ImageView localImageView2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131367691);
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
      localImageView1.setImageBitmap(this.jdField_a_of_type_Aweq.a(paramRichStatus.actionId, 200));
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
      localTextView.setText(2131699398);
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
      if (axmv.b()) {
        localImageView1.setVisibility(8);
      }
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break;
      label510:
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130845218);
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
      if (bbdh.b()) {
        localTextView.setText(new aykk(paramRichStatus + " ", 1, 16));
      } else {
        localTextView.setText(new aykk(paramRichStatus, 1, 16));
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
      if ((axmv.b()) && (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (ImmersiveUtils.isSupporImmersive() != 0))
      {
        paramBoolean = ThemeUtil.getCurrentThemeId();
        if ((axmv.b(paramBoolean)) && (!ThemeUtil.isSimpleColrThemeStateBarUseWhite(paramBoolean)))
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
        if ((!bfnf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())) {
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
  
  public void a(String paramString, bfwx parambfwx)
  {
    if (parambfwx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "[storeDynamicDrawable] drawable to be stored is null");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambfwx);
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
    //   0: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc_w 274
    //   9: iconst_2
    //   10: new 287	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 2884
    //   20: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 1130	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: ldc_w 2886
    //   30: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 1130	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   37: ldc_w 2888
    //   40: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_3
    //   44: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 433	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 1134	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 283	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokevirtual 1253	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   60: astore 6
    //   62: aload_0
    //   63: getfield 627	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   66: iconst_0
    //   67: aaload
    //   68: ldc_w 714
    //   71: invokevirtual 338	android/view/View:findViewById	(I)Landroid/view/View;
    //   74: checkcast 410	android/widget/TextView
    //   77: astore 7
    //   79: aload_0
    //   80: getfield 627	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   83: iconst_0
    //   84: aaload
    //   85: ldc_w 712
    //   88: invokevirtual 338	android/view/View:findViewById	(I)Landroid/view/View;
    //   91: checkcast 506	android/widget/ImageView
    //   94: astore 8
    //   96: aload_0
    //   97: getfield 281	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   100: invokevirtual 619	com/tencent/mobileqq/app/BaseActivity:getResources	()Landroid/content/res/Resources;
    //   103: astore 9
    //   105: aload 9
    //   107: ldc_w 647
    //   110: invokevirtual 737	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   113: astore 5
    //   115: invokestatic 918	ajzt:a	()Z
    //   118: ifeq +400 -> 518
    //   121: iload_1
    //   122: ifeq +238 -> 360
    //   125: invokestatic 1943	bbsh:a	()Lbbsh;
    //   128: getfield 2890	bbsh:d	Ljava/lang/String;
    //   131: invokestatic 676	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   134: ifne +209 -> 343
    //   137: invokestatic 1943	bbsh:a	()Lbbsh;
    //   140: getfield 2890	bbsh:d	Ljava/lang/String;
    //   143: astore 6
    //   145: aload 6
    //   147: astore 5
    //   149: aload 5
    //   151: astore 6
    //   153: aload 5
    //   155: invokevirtual 369	java/lang/String:length	()I
    //   158: bipush 8
    //   160: if_icmple +13 -> 173
    //   163: aload 5
    //   165: iconst_0
    //   166: bipush 8
    //   168: invokevirtual 2197	java/lang/String:substring	(II)Ljava/lang/String;
    //   171: astore 6
    //   173: aload 7
    //   175: aload 6
    //   177: invokevirtual 477	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   180: aload_0
    //   181: getfield 154	com/tencent/mobileqq/activity/QQSettingMe:jdField_j_of_type_Boolean	Z
    //   184: ifeq +437 -> 621
    //   187: ldc_w 2891
    //   190: istore_3
    //   191: aload 8
    //   193: iload_3
    //   194: invokevirtual 713	android/widget/ImageView:setImageResource	(I)V
    //   197: aload 6
    //   199: invokestatic 676	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifne +107 -> 309
    //   205: aload_0
    //   206: getfield 283	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   209: invokevirtual 419	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   212: ldc_w 1583
    //   215: iconst_0
    //   216: invokevirtual 1584	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   219: invokeinterface 2498 1 0
    //   224: new 287	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 1586
    //   234: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: getfield 283	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   241: invokevirtual 363	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   244: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 1588
    //   250: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokestatic 1590	ajzt:a	()I
    //   256: invokevirtual 561	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: invokevirtual 433	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aload 6
    //   264: invokeinterface 2505 3 0
    //   269: invokeinterface 2508 1 0
    //   274: pop
    //   275: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +31 -> 309
    //   281: ldc_w 274
    //   284: iconst_2
    //   285: new 287	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 2893
    //   295: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 6
    //   300: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 433	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 563	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload_0
    //   310: getfield 627	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   313: iconst_0
    //   314: aaload
    //   315: iconst_0
    //   316: invokevirtual 456	android/view/View:setVisibility	(I)V
    //   319: getstatic 322	com/tencent/common/config/AppSetting:jdField_d_of_type_Boolean	Z
    //   322: ifeq +20 -> 342
    //   325: aload_0
    //   326: getfield 627	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   329: iconst_0
    //   330: aaload
    //   331: aload 6
    //   333: ldc_w 739
    //   336: invokevirtual 744	java/lang/Class:getName	()Ljava/lang/String;
    //   339: invokestatic 749	baww:a	(Landroid/view/View;Ljava/lang/CharSequence;Ljava/lang/String;)V
    //   342: return
    //   343: aload 9
    //   345: ldc_w 2894
    //   348: invokevirtual 737	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   351: astore 6
    //   353: aload 6
    //   355: astore 5
    //   357: goto -208 -> 149
    //   360: iload_2
    //   361: ifeq +47 -> 408
    //   364: invokestatic 1943	bbsh:a	()Lbbsh;
    //   367: getfield 2896	bbsh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   370: invokestatic 676	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   373: ifne +18 -> 391
    //   376: invokestatic 1943	bbsh:a	()Lbbsh;
    //   379: getfield 2896	bbsh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   382: astore 6
    //   384: aload 6
    //   386: astore 5
    //   388: goto -239 -> 149
    //   391: aload 9
    //   393: ldc_w 2897
    //   396: invokevirtual 737	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   399: astore 6
    //   401: aload 6
    //   403: astore 5
    //   405: goto -256 -> 149
    //   408: aload 6
    //   410: ldc_w 2899
    //   413: iconst_0
    //   414: invokeinterface 1259 3 0
    //   419: istore 4
    //   421: iload_3
    //   422: ifgt +8 -> 430
    //   425: iload 4
    //   427: ifle +47 -> 474
    //   430: invokestatic 1943	bbsh:a	()Lbbsh;
    //   433: getfield 2900	bbsh:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   436: invokestatic 676	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   439: ifne +18 -> 457
    //   442: invokestatic 1943	bbsh:a	()Lbbsh;
    //   445: getfield 2900	bbsh:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   448: astore 6
    //   450: aload 6
    //   452: astore 5
    //   454: goto -305 -> 149
    //   457: aload 9
    //   459: ldc_w 2901
    //   462: invokevirtual 737	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   465: astore 6
    //   467: aload 6
    //   469: astore 5
    //   471: goto -322 -> 149
    //   474: invokestatic 1943	bbsh:a	()Lbbsh;
    //   477: getfield 2902	bbsh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   480: invokestatic 676	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: ifne +18 -> 501
    //   486: invokestatic 1943	bbsh:a	()Lbbsh;
    //   489: getfield 2902	bbsh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   492: astore 6
    //   494: aload 6
    //   496: astore 5
    //   498: goto -349 -> 149
    //   501: aload 9
    //   503: ldc_w 647
    //   506: invokevirtual 737	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   509: astore 6
    //   511: aload 6
    //   513: astore 5
    //   515: goto -366 -> 149
    //   518: iload_1
    //   519: ifeq +16 -> 535
    //   522: aload 9
    //   524: ldc_w 2894
    //   527: invokevirtual 737	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   530: astore 6
    //   532: goto -359 -> 173
    //   535: iload_2
    //   536: ifeq +16 -> 552
    //   539: aload 9
    //   541: ldc_w 2897
    //   544: invokevirtual 737	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   547: astore 6
    //   549: goto -376 -> 173
    //   552: aload 6
    //   554: ldc_w 2899
    //   557: iconst_0
    //   558: invokeinterface 1259 3 0
    //   563: istore 4
    //   565: iload_3
    //   566: ifgt +8 -> 574
    //   569: iload 4
    //   571: ifle +16 -> 587
    //   574: aload 9
    //   576: ldc_w 2901
    //   579: invokevirtual 737	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   582: astore 6
    //   584: goto -411 -> 173
    //   587: aload 9
    //   589: ldc_w 647
    //   592: invokevirtual 737	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   595: astore 6
    //   597: goto -424 -> 173
    //   600: astore 6
    //   602: ldc_w 274
    //   605: iconst_1
    //   606: ldc_w 2904
    //   609: aload 6
    //   611: invokestatic 1394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   614: aload 5
    //   616: astore 6
    //   618: goto -445 -> 173
    //   621: ldc_w 2905
    //   624: istore_3
    //   625: goto -434 -> 191
    //   628: astore 5
    //   630: ldc_w 274
    //   633: iconst_1
    //   634: ldc_w 2907
    //   637: aload 5
    //   639: invokestatic 1394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
      return new int[] { 2130845239, 2130845224, 2130845235, 2130845241, 2130845243, 2130845245, 2130845197, 2130845228, 2130845222, 2130845220, 2130845226, 2130845193, 2130845237 };
    }
    return new int[] { 2130845240, 2130845225, 2130845236, 2130845242, 2130845244, 2130845246, 2130845197, 2130845229, 2130845223, 2130845220, 2130845227, 2130845194, 2130845237 };
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
      str = localSharedPreferences.getString("qqsettingme_f2f_guide_tip", ajya.a(2131710760));
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
    this.jdField_a_of_type_Aqyf.d();
    axri.a().b("QQSettingMe");
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
      this.jdField_a_of_type_Aymc.a();
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajto);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuf);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akjo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akfy);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a);
      }
      if (this.jdField_a_of_type_Aweq != null)
      {
        this.jdField_a_of_type_Aweq.b(this.jdField_a_of_type_Awci);
        this.jdField_a_of_type_Aweq.b(this.jdField_a_of_type_Awcf);
        this.jdField_a_of_type_Aweq.b(this.jdField_a_of_type_Awcd);
      }
      if (this.jdField_a_of_type_Aikv != null)
      {
        this.jdField_a_of_type_Aikv.a(null);
        this.jdField_a_of_type_Aikv = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atzn);
    }
    VSNetworkHelper.a().a();
    if (this.jdField_a_of_type_Aymc != null) {
      this.jdField_a_of_type_Aymc.a(this.jdField_a_of_type_Aymf, false);
    }
    bbsh.a().b(this.jdField_a_of_type_Bbsj);
    xow.a().b(this.jdField_a_of_type_Xox);
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuf, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajto, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atzn);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akjo, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akfy, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajzz, true);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a);
      }
      this.jdField_a_of_type_Aymc.a(this.jdField_a_of_type_Aymf, true);
      this.jdField_a_of_type_Aikv = ((aikv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(114));
      if (this.jdField_a_of_type_Aikv != null) {
        this.jdField_a_of_type_Aikv.a(this.jdField_a_of_type_Aikw);
      }
      bbsh.a().a(this.jdField_a_of_type_Bbsj);
      xow.a().a(this.jdField_a_of_type_Xox);
    }
  }
  
  public void g()
  {
    SosoInterface.a(new abxa(this, 0, true, true, 60000L, true, false, "QQSettingRedesign"));
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
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = akuz.a().a();
    this.jdField_a_of_type_Aymc = new aymc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      if (TextUtils.isEmpty(bbsh.a().jdField_b_of_type_JavaLangString)) {
        ThreadManager.post(new QQSettingMe.8(this), 5, null, true);
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
    ThreadManager.post(new QQSettingMe.13(this), 5, null, false);
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
    W();
    Y();
    C();
    aa();
    ag();
  }
  
  protected void k()
  {
    try
    {
      a(4, this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      ((avfc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(104)).a(this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
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
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable(bbef.b());
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
  
  public void m()
  {
    if (this.jdField_a_of_type_Aymc != null) {
      this.jdField_a_of_type_Aymc.b();
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
    label430:
    TextView localTextView;
    if (axmv.b())
    {
      this.jdField_m_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_m_of_type_AndroidViewView).a(53).a();
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "ThemeDebugKeyLog:onPostThemeChanged, refresh pendant after theme changed.");
      }
      y();
      U();
      this.jdField_h_of_type_Boolean = true;
      localObject2 = ThemeUtil.getCurrentThemeInfo();
      Object localObject1 = ((Bundle)localObject2).getString("themeId");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"1000".equals(localObject1)) && (!"1103".equals(localObject1))) {
        break label597;
      }
      bool = true;
      this.jdField_j_of_type_Boolean = bool;
      a(null);
      if (!this.jdField_j_of_type_Boolean) {
        break label602;
      }
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166315);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845230);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845211);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((!bfnf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) {
        break label639;
      }
      a(true);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onPostThemeChanged, color=" + i1 + ",themeid = " + (String)localObject1 + ", enginePath=" + ((Bundle)localObject2).getString("themePath"));
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i1);
      N();
      localObject2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131367691);
      if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
        break label647;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"1000".equals(localObject1))) {
        break label674;
      }
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      C();
      e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      R();
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i1);
      localObject1 = a(this.jdField_j_of_type_Boolean);
      i2 = 0;
      if (i2 >= 13) {
        break label707;
      }
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[i2] != null)
      {
        localObject2 = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368345);
        ((ImageView)localObject2).setImageResource(localObject1[i2]);
        localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131368385);
        if (this.jdField_j_of_type_Boolean) {
          break label686;
        }
        localTextView.setTextColor(i1);
      }
    }
    for (;;)
    {
      if ((axmv.b()) && ("2920".equals(ThemeUtil.getCurrentThemeId()))) {
        localTextView.setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166314));
      }
      if (i2 == 9) {
        a((ImageView)localObject2, localTextView);
      }
      i2 += 1;
      break label430;
      this.jdField_m_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_AndroidViewView).a(53).a();
      break;
      label597:
      bool = false;
      break label131;
      label602:
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166316);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845234);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845210);
      break label182;
      label639:
      a(false);
      break label218;
      label647:
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
      break label364;
      label674:
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      break label391;
      label686:
      localTextView.setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166314));
    }
    label707:
    ((alyy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(180)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe onPostThemeChanged refresh because simple theme switch!");
      }
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    ((akfh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(87)).notifyUI(4, true, null);
  }
  
  public void n()
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int i1 = this.jdField_a_of_type_Aymc.a();
    String str;
    if (i1 == 1) {
      if (this.jdField_j_of_type_Boolean)
      {
        localObject1 = ((Resources)localObject2).getDrawable(2130845211);
        str = ((Resources)localObject2).getString(2131699431);
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
      localObject1 = ((Resources)localObject2).getDrawable(2130845210);
      break;
      if (i1 == 2)
      {
        if (this.jdField_j_of_type_Boolean) {}
        for (localObject1 = ((Resources)localObject2).getDrawable(2130845211);; localObject1 = ((Resources)localObject2).getDrawable(2130845210))
        {
          str = ((Resources)localObject2).getString(2131699431);
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
    boolean bool1 = akuz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.a(bool1);
    }
    if ((!bool1) && (akcy.a(1)))
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
      return;
      if ((this.jdField_b_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < 500L))
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        return;
      }
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      long l1;
      boolean bool;
      switch (paramView.getId())
      {
      case 2131368543: 
      default: 
        return;
      case 2131362993: 
        if (FrameHelperActivity.b())
        {
          FrameHelperActivity.c(true);
          FrameHelperActivity.s();
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009C4E", "0X8009C4E", 0, 0, "", "", "", "");
          return;
        }
        break;
      case 2131370608: 
      case 2131370632: 
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
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_duty", "", "locker", "clk", 0, 0, "", "", "", "");
        }
      case 2131370833: 
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        paramView.g = 1;
        paramView.h = 8;
        ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 1009);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D6");
        return;
      case 2131367408: 
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        paramView.g = 1;
        paramView.h = 8;
        ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 1009);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D7");
        DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
        if (this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X8006726");
          return;
        }
        break;
      case 2131373407: 
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        paramView.putExtra("title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131717252));
        paramView.putExtra("nick", bbcz.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1));
        paramView.putExtra("uin", (String)localObject1);
        paramView.putExtra("type", 1);
        paramView.putExtra("reportFlag", 1);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055BB", "0X80055BB", 0, 0, "", "", "", "");
        return;
      case 2131370643: 
        l1 = System.currentTimeMillis();
        if (ProfileActivity.a(this.jdField_a_of_type_Long, l1))
        {
          this.jdField_a_of_type_Long = l1;
          if (QWalletHelper.isValidToLaunchQWallet(l1))
          {
            QWalletHelper.launchQWalletAct(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true);
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "My_wallet", "Clk_wallet", 0, 0, "", "", "", "");
            bbak.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(100007, 31);
            paramView = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[1];
            i1 = akjn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramView.a());
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8BF", "0X800A8BF", i1, 0, String.valueOf(i1), "", "", "");
            if (jdField_a_of_type_Int > 0)
            {
              DrawerFrame.jdField_a_of_type_Int = 2;
              return;
            }
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            return;
          }
        }
        break;
      case 2131370634: 
        if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()) {}
        for (bool = true;; bool = false)
        {
          bgpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, -1, bool);
          bgqi.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0);
          bgqm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(103000, 31);
          return;
        }
      case 2131370642: 
        paramView = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        bool = false;
        localObject1 = new bgyj();
        ((bgyj)localObject1).a("443");
        ((bgyj)localObject1).b("3");
        ((bgyj)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
        if ((this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1))
        {
          bool = true;
          ((bgyj)localObject1).c("1");
        }
        for (;;)
        {
          QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (bgyj)localObject1);
          paramView.a(100180, 31);
          try
          {
            l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
            localObject2 = bgyw.a();
            ((bgyw)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l1);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
            paramView = (View)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramView = bbcz.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            ((bgyw)localObject2).jdField_b_of_type_JavaLangString = paramView;
            bgyp.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (bgyw)localObject2, Long.valueOf(l1), 0, bool, -1);
            paramView = new bgyj();
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
            axrn.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramView, null);
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            return;
            ((bgyj)localObject1).c("2");
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
      case 2131370609: 
        localObject1 = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        ((avps)localObject1).a(100005, 31);
        if (((RedTouch)((ViewGroup)paramView).getChildAt(0)).a()) {}
        for (paramView = bhem.b(((avps)localObject1).a(String.valueOf(100005)));; paramView = bhem.a("outside", "3"))
        {
          VasWebviewUtil.openIndividuationIndex(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView);
          ThreadManager.post(new QQSettingMe.17(this), 5, null, true);
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Personality_setting", 0, 0, "", "", "", "");
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          return;
        }
      case 2131375988: 
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQSettingSettingActivity.class);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        if (akuz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004DB0", "0X8004DB0", 0, 0, "", "", akuz.a(), "");
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0)) {
          ajud.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iNewTimeStamp);
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
        ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(100190, 31);
        DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
        return;
      case 2131370842: 
        if (!aylh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "", new abwg(this)))
        {
          S();
          return;
        }
        break;
      case 2131369455: 
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramView.putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=draw");
        paramView.putExtra("hide_more_button", true);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A9C3", "0X800A9C3", 0, 0, "", "", "", "");
        return;
      case 2131379384: 
        i1 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getInt("cur_adcode", 0);
        paramView = "mqqapi://miniapp/open?_atype=0&_mappid=1108323226&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2066&_sig=191577ab932c397857a3cb26aa1938bfa257d305ad390c43ae02ca77df0753e7&areaId=" + i1;
        MiniAppLauncher.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 2066, null);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A42C", "0X800A42C", 0, 0, "", "", "", "");
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005BE4", "0X8005BE4", 0, 0, "", "", "", "");
        return;
      case 2131376196: 
        if ((this.jdField_a_of_type_Aweq != null) && (!this.jdField_a_of_type_Aweq.a()))
        {
          ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(100450, 31);
          if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
          {
            paramView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131375236);
            if ((paramView != null) && (paramView.getText() != null))
            {
              paramView = new Bundle();
              paramView.putInt("from_type", 3);
              SignTextEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, "", paramView, -1);
            }
          }
          DrawerFrame.jdField_a_of_type_Int = 0;
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "set_enter", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D8");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X800A669");
        return;
      case 2131370646: 
        l1 = System.currentTimeMillis();
        if (ProfileActivity.a(this.jdField_a_of_type_Long, l1))
        {
          this.jdField_a_of_type_Long = l1;
          if (QLog.isColorLevel()) {
            QLog.i("QQSettingRedesign", 2, "enter vip");
          }
          ThreadManager.post(new QQSettingMe.19(this), 5, null, true);
          paramView = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[0];
          i1 = akjn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((RedTouch)localObject1).a());
          if (((RedTouch)localObject1).a()) {}
          for (paramView = bhem.b(paramView.a(String.valueOf(100400)));; paramView = bhem.a("outside", "1"))
          {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8BE", "0X800A8BE", i1, 0, String.valueOf(i1), "", "", "");
            f(paramView);
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
            if (jdField_a_of_type_Int <= 0) {
              break;
            }
            DrawerFrame.jdField_a_of_type_Int = 2;
            return;
          }
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          return;
        }
        break;
      case 2131370637: 
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, FileAssistantActivity.class);
        paramView.putExtra("from", "FileAssistant");
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
        DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
        paramView = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
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
          if ((this.o != null) && (this.o.getVisibility() == 0))
          {
            this.o.setVisibility(8);
            BaseApplication.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "qqsettingme_f2f_guide", 0).edit().putBoolean("qqsettingme_f2f_guide_flag", true).apply();
            return;
          }
        }
        catch (JSONException paramView)
        {
          for (;;)
          {
            paramView.printStackTrace();
          }
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
    Object localObject2 = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    Object localObject1 = "";
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((avps)localObject2).a(String.valueOf(100500));
    paramView = (View)localObject1;
    if (localAppInfo != null)
    {
      paramView = (View)localObject1;
      if (localAppInfo.iNewFlag.get() != 0)
      {
        paramView = bhem.a(localAppInfo);
        ((avps)localObject2).a(100500, 31);
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
    paramView = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[11];
    int i1 = akjn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramView.a());
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C0", "0X800A8C0", i1, 0, String.valueOf(i1), "", "", "");
    return;
    QQStoryMemoriesActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, QQStoryContext.a().b(), true);
    DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
    return;
    paramView = QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameJumpUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1108291530&_mvid=&_path=pages%2Fgame-list%2Fgame-list.html%3Fmode%3Dchouti&_vt=3&via=2066&_sig=676003338");
    if (!TextUtils.isEmpty(paramView))
    {
      if (MiniAppLauncher.isMiniAppUrl(paramView)) {
        MiniAppLauncher.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a(paramView, this.jdField_n_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo), 2066, null);
      }
    }
    else
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!RedTouch.a(this.jdField_n_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo)) {
        break label3271;
      }
    }
    label3271:
    for (i1 = 1;; i1 = 0)
    {
      axqy.b(paramView, "dc00898", "", "", "0X800ACDD", "0X800ACDD", 0, i1, "", "", "", "");
      return;
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
      break;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    localObject1 = paramView.getSharedPreferences("call_tim_config_pre" + (String)localObject1, 0).getString("call_tim_config_url", null);
    paramView = (View)localObject1;
    if (localObject1 == null) {
      paramView = andf.a().a();
    }
    localObject1 = paramView;
    if (paramView == null) {
      localObject1 = "https://docs.qq.com/desktop/m/index.html";
    }
    paramView = ayfx.b((String)localObject1, "s_qq_drawer");
    localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramView);
    ((Intent)localObject1).putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
    ((Intent)localObject1).putExtra("tdsourcetag", "s_qq_drawer");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800887E", "0X800887E", 0, 0, "", "", "", "");
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
    i1 = akjn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X800A127", 0, 0, String.valueOf(i1), "", "", "");
    return;
    bbac.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97F", "0X800A97F", 0, 0, "0", "0", "", "");
    return;
    i1 = asay.a(asay.a(this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo));
    paramView = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    localObject1 = paramView.a(String.valueOf(100066));
    if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView == null) || (this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.getVisibility() != 0)) {
        break label3832;
      }
      a("0x800AAFB", "1");
    }
    for (;;)
    {
      paramView.a(100066, 31);
      asay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2066, "10", i1 + "");
      return;
      label3832:
      a("0x800AAFB", "2");
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
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf(1000017));
      if (!((amdj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a())
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
    //   2: getfield 283	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5: invokevirtual 932	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   8: putfield 3568	com/tencent/mobileqq/activity/QQSettingMe:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 3568	com/tencent/mobileqq/activity/QQSettingMe:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokestatic 3571	akjn:a	(Ljava/lang/String;)LMQQ/PayRuleCfg;
    //   19: putfield 1321	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   22: aload_0
    //   23: getfield 283	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: aload_0
    //   27: getfield 1321	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   30: aload_0
    //   31: getfield 2627	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   34: invokestatic 3574	akjn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;LMQQ/PayRuleCfg;Z)Z
    //   37: istore_1
    //   38: aload_0
    //   39: getfield 1321	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   42: ifnonnull +271 -> 313
    //   45: ldc_w 274
    //   48: iconst_1
    //   49: ldc_w 3576
    //   52: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iload_1
    //   56: ifeq +345 -> 401
    //   59: aload_0
    //   60: getfield 2627	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   63: ifne +64 -> 127
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 2627	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   71: aconst_null
    //   72: ldc_w 1230
    //   75: ldc_w 443
    //   78: ldc_w 443
    //   81: ldc_w 443
    //   84: ldc_w 3578
    //   87: aload_0
    //   88: getfield 1321	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   91: invokestatic 3581	akjn:a	(LMQQ/PayRuleCfg;)I
    //   94: iconst_1
    //   95: iconst_0
    //   96: ldc_w 1285
    //   99: aload_0
    //   100: getfield 1321	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   103: getfield 3584	MQQ/PayRuleCfg:advId	Ljava/lang/String;
    //   106: ldc_w 443
    //   109: ldc_w 443
    //   112: invokestatic 3587	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   115: bipush 101
    //   117: aload_0
    //   118: getfield 1321	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   121: getfield 3584	MQQ/PayRuleCfg:advId	Ljava/lang/String;
    //   124: invokestatic 3590	akjn:a	(ILjava/lang/String;)V
    //   127: aload_0
    //   128: invokespecial 3592	com/tencent/mobileqq/activity/QQSettingMe:Z	()V
    //   131: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +36 -> 170
    //   137: ldc_w 274
    //   140: iconst_2
    //   141: new 287	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 3594
    //   151: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: getfield 980	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   158: invokestatic 3595	avps:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)Ljava/lang/String;
    //   161: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 433	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 563	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: new 1028	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   173: dup
    //   174: invokespecial 1473	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   177: astore_2
    //   178: aload_2
    //   179: aload_0
    //   180: getfield 980	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   183: invokevirtual 1476	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   186: iload_1
    //   187: ifeq +54 -> 241
    //   190: aload_2
    //   191: invokestatic 3598	com/tencent/mobileqq/redtouch/RedTouchTextView:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)Ljava/util/List;
    //   194: ifnull +47 -> 241
    //   197: new 91	java/util/ArrayList
    //   200: dup
    //   201: invokespecial 94	java/util/ArrayList:<init>	()V
    //   204: astore_3
    //   205: new 1510	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   208: dup
    //   209: invokespecial 1534	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   212: astore 4
    //   214: aload 4
    //   216: getfield 1514	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: iconst_0
    //   220: invokevirtual 1536	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   223: aload_3
    //   224: aload 4
    //   226: invokevirtual 1000	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   229: pop
    //   230: aload_2
    //   231: getfield 1488	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   234: getfield 1497	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   237: aload_3
    //   238: invokevirtual 1533	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   241: aload_0
    //   242: iconst_0
    //   243: aload_2
    //   244: invokespecial 1304	com/tencent/mobileqq/activity/QQSettingMe:a	(ILcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   247: aload_0
    //   248: getfield 283	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   251: ifnull +61 -> 312
    //   254: aload_0
    //   255: getfield 980	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   258: ifnull +163 -> 421
    //   261: aload_0
    //   262: getfield 980	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   265: getfield 1480	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   268: invokevirtual 1484	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   271: iconst_1
    //   272: if_icmpeq +6 -> 278
    //   275: goto +146 -> 421
    //   278: ldc_w 274
    //   281: iconst_1
    //   282: ldc_w 3600
    //   285: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: new 2142	android/content/Intent
    //   291: dup
    //   292: aload_0
    //   293: getfield 281	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   296: ldc_w 3602
    //   299: invokespecial 2147	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   302: astore_2
    //   303: aload_0
    //   304: getfield 281	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   307: aload_2
    //   308: invokevirtual 3606	com/tencent/mobileqq/app/BaseActivity:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   311: pop
    //   312: return
    //   313: ldc_w 274
    //   316: iconst_1
    //   317: new 287	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 3608
    //   327: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: getfield 1321	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   334: getfield 1326	MQQ/PayRuleCfg:iconText	Ljava/lang/String;
    //   337: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc_w 3610
    //   343: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload_1
    //   347: invokevirtual 1130	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   350: ldc_w 3612
    //   353: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_0
    //   357: getfield 1321	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   360: getfield 1329	MQQ/PayRuleCfg:iconUrl	Ljava/lang/String;
    //   363: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc_w 3614
    //   369: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_0
    //   373: getfield 2627	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   376: invokevirtual 1130	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   379: invokevirtual 433	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: goto -330 -> 55
    //   388: astore_2
    //   389: ldc_w 274
    //   392: iconst_1
    //   393: ldc_w 3616
    //   396: aload_2
    //   397: invokestatic 1394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: return
    //   401: aload_0
    //   402: invokevirtual 3619	com/tencent/mobileqq/activity/QQSettingMe:w	()V
    //   405: goto -274 -> 131
    //   408: astore_2
    //   409: ldc_w 274
    //   412: iconst_2
    //   413: ldc_w 3621
    //   416: aload_2
    //   417: invokestatic 1394	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131368369);
    localTextView.setText("");
    localTextView.setBackgroundDrawable(null);
  }
  
  public void x()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.23(this));
  }
  
  public void y()
  {
    ExtensionInfo localExtensionInfo = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (axmv.b())
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
        if (bbcm.a(localExtensionInfo.pendantId))
        {
          ((PendantInfo)localObject).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.h, localExtensionInfo.uin, localExtensionInfo.pendantDiyId);
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarPendant", "choutishow", 0, 0, "", "", "", "");
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
    this.jdField_a_of_type_Aweq = ((aweq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15));
    if ((this.jdField_a_of_type_Aweq == null) || (this.jdField_e_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_Awci == null)
    {
      this.jdField_a_of_type_Awci = new abwk(this);
      this.jdField_a_of_type_Awcf = new abwl(this);
      this.jdField_a_of_type_Awcd = new abwm(this);
      this.jdField_a_of_type_Aweq.a(this.jdField_a_of_type_Awci);
      this.jdField_a_of_type_Aweq.a(this.jdField_a_of_type_Awcf);
      this.jdField_a_of_type_Aweq.a(this.jdField_a_of_type_Awcd);
    }
    RichStatus localRichStatus = this.jdField_a_of_type_Aweq.a(false);
    if ((localRichStatus == null) || (localRichStatus.isEmpty()))
    {
      ThreadManager.getFileThreadHandler().post(new QQSettingMe.27(this));
      return;
    }
    a(localRichStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe
 * JD-Core Version:    0.7.0.1
 */
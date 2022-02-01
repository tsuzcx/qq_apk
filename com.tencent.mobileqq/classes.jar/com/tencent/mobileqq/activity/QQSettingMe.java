package com.tencent.mobileqq.activity;

import MQQ.MenumItem;
import MQQ.PayRuleCfg;
import QQService.EVIPSPEC;
import aavb;
import aavc;
import aern;
import aero;
import aerp;
import aerq;
import aerr;
import aers;
import aert;
import aeru;
import aerv;
import aerw;
import aerx;
import aery;
import aesa;
import aesb;
import aesc;
import aesd;
import aese;
import aesf;
import aesg;
import aesh;
import aesi;
import aesj;
import aesl;
import amed;
import amee;
import amef;
import amfb;
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
import ansg;
import ansi;
import anvi;
import anvk;
import anvx;
import anxv;
import anxy;
import anya;
import aoae;
import aocj;
import aodb;
import aogw;
import aogx;
import aqeq;
import aqjm;
import aros;
import arot;
import arzm;
import avli;
import awpu;
import aymc;
import aymd;
import aymo;
import ayqy;
import azzt;
import baar;
import baql;
import bbbq;
import bbtb;
import bbtd;
import bbtg;
import bbvn;
import bdfk;
import bdla;
import bdlm;
import becr;
import behh;
import beid;
import beig;
import bgvx;
import bgyd;
import bhaa;
import bhai;
import bhbx;
import bhcs;
import bheg;
import bheh;
import bhey;
import bhjf;
import bhjg;
import bhjh;
import bhnp;
import bhpw;
import bhpy;
import bhru;
import bhze;
import bhzf;
import biba;
import bibb;
import bibe;
import bkxu;
import bkxw;
import blgc;
import bmaf;
import bman;
import bmar;
import com.tencent.biz.qqstory.app.QQStoryContext;
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
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.apollo.SettingMeApolloViewController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
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
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.ui.VasPagView;
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
import cooperation.ilive.manager.IliveDbManager;
import cooperation.ilive.manager.IliveRedManager;
import cooperation.ilive.share.IliveShareHelper;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.mobilereport.MobileReportManager;
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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lkj;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mvk;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.UpgradeInfo;
import tencent.im.oidb.redInfo.RedInfo;
import vvh;
import vzv;

public class QQSettingMe
  implements View.OnClickListener, View.OnTouchListener
{
  public static int a;
  private static List<String> jdField_a_of_type_JavaUtilList;
  private static List<String> jdField_b_of_type_JavaUtilList;
  protected long a;
  private PayRuleCfg jdField_a_of_type_MQQPayRuleCfg;
  public aavc a;
  private amee jdField_a_of_type_Amee;
  private amef jdField_a_of_type_Amef;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aern(this);
  Handler jdField_a_of_type_AndroidOsHandler = new aesh(this, Looper.getMainLooper());
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aers(this);
  protected View a;
  public ViewGroup a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  private ansi jdField_a_of_type_Ansi = new aesa(this);
  private anvi jdField_a_of_type_Anvi = new aesc(this);
  private anya jdField_a_of_type_Anya = new aese(this);
  private aodb jdField_a_of_type_Aodb = new aesf(this);
  private aogx jdField_a_of_type_Aogx = new aery(this);
  private avli jdField_a_of_type_Avli = new avli("QQSetting_me", "com.tencent.mobileqq:tool");
  private ayqy jdField_a_of_type_Ayqy = new aerx(this);
  private bbtb jdField_a_of_type_Bbtb;
  private bbtd jdField_a_of_type_Bbtd;
  private bbtg jdField_a_of_type_Bbtg;
  private bbvn jdField_a_of_type_Bbvn;
  private beid jdField_a_of_type_Beid;
  beig jdField_a_of_type_Beig = new aesd(this);
  private bhpy jdField_a_of_type_Bhpy = new aesg(this);
  private final bhze jdField_a_of_type_Bhze = bhze.a();
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private SettingMeApolloViewController jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController;
  public BaseActivity a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aesb(this);
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
  protected VasPagView a;
  protected AnimationTextView a;
  public FixedBounceScrollView a;
  protected QVipMedalView a;
  protected RedDotTextView a;
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private BusinessInfoCheckUpdate.RedTypeInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo;
  private String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private ConcurrentHashMap<String, blgc> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private redInfo.RedInfo jdField_a_of_type_TencentImOidbRedInfo$RedInfo;
  protected boolean a;
  int[] jdField_a_of_type_ArrayOfInt = { 2131698842, 2131698828, 2131698825, 2131698852, 2131698826, 2131698867, 2131698806, 2131698815, 2131698847, 2131698817, 2131698827, 2131698798, 2131698814, 2131698799, 2131698823 };
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
  private final String jdField_e_of_type_JavaLangString = "data_item_id";
  protected boolean e;
  private int jdField_f_of_type_Int;
  protected View f;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  protected TextView f;
  protected RedTouch f;
  BusinessInfoCheckUpdate.AppInfo jdField_f_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private final String jdField_f_of_type_JavaLangString = "data_enter_title";
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  protected View g;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  public TextView g;
  protected RedTouch g;
  BusinessInfoCheckUpdate.AppInfo jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private final String jdField_g_of_type_JavaLangString = "data_enter_icon";
  private boolean jdField_g_of_type_Boolean;
  private final int jdField_h_of_type_Int = 0;
  protected View h;
  public TextView h;
  protected RedTouch h;
  BusinessInfoCheckUpdate.AppInfo jdField_h_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private boolean jdField_h_of_type_Boolean;
  private final int jdField_i_of_type_Int = 1;
  protected View i;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  protected RedTouch i;
  BusinessInfoCheckUpdate.AppInfo jdField_i_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
  private boolean jdField_i_of_type_Boolean;
  private final int jdField_j_of_type_Int = 2;
  protected View j;
  BusinessInfoCheckUpdate.AppInfo jdField_j_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
  private boolean jdField_j_of_type_Boolean = true;
  private final int jdField_k_of_type_Int = 3;
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
  BusinessInfoCheckUpdate.AppInfo p;
  BusinessInfoCheckUpdate.AppInfo q;
  
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
    this.jdField_a_of_type_Aavc = new aesj(this);
    this.jdField_b_of_type_AndroidOsHandler = new aero(this, Looper.getMainLooper());
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->QQSettingMe construct!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity = paramFrameHelperActivity;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561498, null));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368095);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(anvx.a(2131710215));
    }
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368063));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363426));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368109);
    this.jdField_m_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377789);
    paramFrameHelperActivity = paramQQAppInterface.getCurrentAccountUin();
    int i1;
    Object localObject1;
    boolean bool;
    label1767:
    int[] arrayOfInt;
    label1795:
    int i3;
    int i2;
    if ((paramFrameHelperActivity == null) || (paramFrameHelperActivity.length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130840348);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131371982).setOnClickListener(this);
      i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298438);
      this.jdField_f_of_type_Int = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0F) - i1 - ScreenUtil.dip2px(45.0F));
      this.jdField_g_of_type_Int = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0F) - i1 - ScreenUtil.dip2px(20.0F));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371981));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_f_of_type_Int);
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + paramFrameHelperActivity);
      if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString.trim()))) {
        this.jdField_a_of_type_JavaLangString = paramFrameHelperActivity;
      }
      this.jdField_f_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.jdField_m_of_type_AndroidViewView).b(53).a();
      this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.jdField_b_of_type_AndroidViewView).b(53).a();
      T();
      this.jdField_b_of_type_AndroidViewView.setVisibility(VasFaceManager.a(paramFrameHelperActivity, paramQQAppInterface));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372546));
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView = ((QVipMedalView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374478));
      this.jdField_h_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView).b(53).a(12).e(1).d(1).a();
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374382);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374383);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373127));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381241));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374517));
      this.jdField_g_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView).b(53).a(12).e(0).d(1).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText("");
      this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363334));
      this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363332));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374756));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367269));
      this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView = ((VasPagView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372386));
      this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.setOnClickListener(this);
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        paramBaseActivity.topMargin = (ScreenUtil.dip2px(29.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371788));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377760));
      if (ImmersiveUtils.isSupporImmersive() == 0)
      {
        paramBaseActivity = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBaseActivity.topMargin = (ScreenUtil.dip2px(35.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getActivity().getApplicationContext()));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramBaseActivity);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377759)).b(53).a();
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377753);
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_e_of_type_AndroidViewView).c(10).b(19).a();
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView.setOnTouchListener(mvk.a);
      this.jdField_l_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373216);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView = ((FixedBounceScrollView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371118));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setDamping(2.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setBounceDelay(600L);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setmCustomTopFadingEdgeScale(0.675F);
      i1 = (int)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimension(2131298431);
      paramBaseActivity = this.jdField_a_of_type_AndroidViewViewGroup.getResources();
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[15];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch = new RedTouch[15];
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView = new RedTouchTextView[15];
      paramFrameHelperActivity = new int[15];
      FrameHelperActivity tmp1619_1618 = paramFrameHelperActivity;
      tmp1619_1618[0] = 2131374484;
      FrameHelperActivity tmp1625_1619 = tmp1619_1618;
      tmp1625_1619[1] = 2131371802;
      FrameHelperActivity tmp1631_1625 = tmp1625_1619;
      tmp1631_1625[2] = 2131371799;
      FrameHelperActivity tmp1637_1631 = tmp1631_1625;
      tmp1637_1631[3] = 2131371790;
      FrameHelperActivity tmp1643_1637 = tmp1637_1631;
      tmp1643_1637[4] = 2131371793;
      FrameHelperActivity tmp1649_1643 = tmp1643_1637;
      tmp1649_1643[5] = 2131371798;
      FrameHelperActivity tmp1655_1649 = tmp1649_1643;
      tmp1655_1649[6] = 2131371765;
      FrameHelperActivity tmp1662_1655 = tmp1655_1649;
      tmp1662_1655[7] = 2131371794;
      FrameHelperActivity tmp1669_1662 = tmp1662_1655;
      tmp1669_1662[8] = 2131371800;
      FrameHelperActivity tmp1676_1669 = tmp1669_1662;
      tmp1676_1669[9] = 2131371801;
      FrameHelperActivity tmp1683_1676 = tmp1676_1669;
      tmp1683_1676[10] = 2131371795;
      FrameHelperActivity tmp1690_1683 = tmp1683_1676;
      tmp1690_1683[11] = 2131364221;
      FrameHelperActivity tmp1697_1690 = tmp1690_1683;
      tmp1697_1690[12] = 2131371766;
      FrameHelperActivity tmp1704_1697 = tmp1697_1690;
      tmp1704_1697[13] = 2131365343;
      FrameHelperActivity tmp1711_1704 = tmp1704_1697;
      tmp1711_1704[14] = 2131371764;
      tmp1711_1704;
      Object localObject2 = ThemeUtil.getCurrentThemeInfo();
      localObject1 = ((Bundle)localObject2).getString("themeId");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"1000".equals(localObject1)) && (!"1103".equals(localObject1))) {
        break label2529;
      }
      bool = true;
      this.jdField_j_of_type_Boolean = bool;
      if (!this.jdField_j_of_type_Boolean) {
        break label2535;
      }
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166474);
      arrayOfInt = a(this.jdField_j_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe_init, color=" + i1 + ",themeid = " + (String)localObject1 + ", enginePath=" + ((Bundle)localObject2).getString("themePath"));
      }
      i3 = ScreenUtil.dip2px(2.0F);
      localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371118);
      this.jdField_k_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.findViewById(2131371119);
      i2 = 0;
      label1902:
      if (i2 >= 15) {
        break label2568;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2] = ((View)localObject2).findViewById(paramFrameHelperActivity[i2]);
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setFocusable(true);
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(0);
      if (paramFrameHelperActivity[i2] == 2131371800) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      if (paramFrameHelperActivity[i2] == 2131371801) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      if (paramFrameHelperActivity[i2] == 2131364221) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      if (paramFrameHelperActivity[i2] == 2131374484)
      {
        QzoneConfig.getInstance();
        if (!QzoneConfig.isQQCircleShowDrawTabEntrance()) {
          break label2553;
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramFrameHelperActivity[i2] == 2131371794)
      {
        this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView = ((LoveZoneTabRedDotView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369122));
        if (this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView != null) {
          this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.setVisibility(8);
        }
      }
      if (paramFrameHelperActivity[i2] == 2131371764)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ArrayOfAndroidViewView[i2]);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setOnClickListener(this);
      Object localObject3 = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369113);
      ((ImageView)localObject3).setImageResource(arrayOfInt[i2]);
      Object localObject4 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369184);
      ((TextView)localObject4).setText(this.jdField_a_of_type_ArrayOfInt[i2]);
      if (!this.jdField_j_of_type_Boolean) {
        ((TextView)localObject4).setTextColor(i1);
      }
      if (paramFrameHelperActivity[i2] == 2131371795) {
        a((ImageView)localObject3, (TextView)localObject4);
      }
      if ((bdfk.b()) && ("2920".equals(ThemeUtil.getCurrentThemeId()))) {
        ((TextView)localObject4).setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166473));
      }
      localObject3 = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369165);
      ((ThemeLabelTextView)localObject3).setSupportMaskView(true);
      ((TextView)localObject3).setVisibility(0);
      bgyd.a(this.jdField_a_of_type_ArrayOfAndroidViewView[i2], paramBaseActivity.getString(this.jdField_a_of_type_ArrayOfInt[i2]), Button.class.getName());
      localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369113);
      ((View)localObject3).setPadding(i3, i3, i3, i3);
      localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject4).leftMargin -= i3;
      localObject4 = (RedTouchTextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369184);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((RedTouchTextView)localObject4).getLayoutParams();
      localLayoutParams.leftMargin -= i3;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i2] = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject3).b(53).a();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouchTextView[i2] = localObject4;
      if (paramFrameHelperActivity[i2] == 2131371764) {
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[i2];
      }
      i2 += 1;
      break label1902;
      localObject1 = paramQQAppInterface.getBitmapFromCache(paramQQAppInterface.getFaceBitmapCacheKey(1, paramFrameHelperActivity, (byte)3, 0, 100, true));
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageBitmap((Bitmap)localObject1);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageResource(2130840348);
      break;
      label2529:
      bool = false;
      break label1767;
      label2535:
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166475);
      break label1795;
      label2553:
      this.jdField_a_of_type_ArrayOfAndroidViewView[i2].setVisibility(8);
    }
    label2568:
    aj();
    z();
    ab();
    ad();
    I();
    ae();
    af();
    b(false);
    this.jdField_i_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369370);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || ("1000".equals(localObject1)))
    {
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363708);
      this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377507);
      this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_g_of_type_AndroidViewView.setOnTouchListener(this);
      bgyd.a(this.jdField_g_of_type_AndroidViewView, anvx.a(2131710209), Button.class.getName());
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377509));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131374434));
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377508));
      this.jdField_i_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView).a();
      this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371995);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(this);
      bgyd.a(this.jdField_f_of_type_AndroidViewView, anvx.a(2131710192), Button.class.getName());
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371997));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371996));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[6].findViewById(2131369101));
      this.jdField_n_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370408);
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380196));
      this.jdField_n_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_n_of_type_AndroidViewView.setOnTouchListener(this);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131381374));
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378586));
      this.jdField_j_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378570);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378588));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378587));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131381369));
      if (!bdfk.b())
      {
        this.jdField_e_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        this.jdField_f_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
        this.jdField_g_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      if (!ThemeUtil.isNowThemeIsDefault(paramQQAppInterface, false, null)) {
        break label3248;
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
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846076);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846051);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i1);
        this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i1);
      }
      return;
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
      break;
      label3248:
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166474));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166474));
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166474));
    }
  }
  
  private void H()
  {
    if (this.jdField_k_of_type_Boolean) {
      return;
    }
    this.jdField_k_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new aerw(this));
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
      this.jdField_d_of_type_JavaLangString = ((SharedPreferences)localObject).getString("drawerTextID", "");
      localObject = ((SharedPreferences)localObject).getString("drawerUrl", "");
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break label198;
      }
      localView.setVisibility(0);
      if ((anxv.a()) && (!this.jdField_a_of_type_Bhze.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 32)))
      {
        localObject = (TextView)localView.findViewById(2131369184);
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setContentDescription(str);
        localObject = a(this.jdField_j_of_type_Boolean);
        ((ImageView)localView.findViewById(2131369113)).setImageResource(localObject[13]);
        bgyd.a(localView, str, Button.class.getName());
      }
    }
    return;
    label198:
    localView.setVisibility(8);
    this.jdField_d_of_type_JavaLangString = "";
    return;
    label211:
    localView.setVisibility(8);
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  private void J()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[11];
    if (localView != null)
    {
      if (arzm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("call_tim_config_pre" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0).getString("call_tim_config_title", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698798));
        localView.setVisibility(0);
        ((TextView)localView.findViewById(2131369184)).setText(str);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800887D", "0X800887D", 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  private void K()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.l();
    }
  }
  
  private void L()
  {
    Object localObject1;
    int i2;
    int i1;
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch.length > 0))
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch;
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
              localSonicPreloadData.url = bhnp.a("personalIndex");
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
        ((SonicPreloadData)localObject1).url = bhnp.a("personalIndex");
        localArrayList3.add(localObject1);
      }
      localObject1 = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
      if (((WebProcessManager)localObject1).a(localArrayList1)) {
        ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b(String.valueOf("200010.200012"));
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
    if (this.p != null) {
      this.jdField_g_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.p);
    }
  }
  
  private void P()
  {
    if (this.jdField_h_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      this.jdField_h_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.q);
    }
  }
  
  private void Q()
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
          bdla.b(localQQAppInterface, "dc00898", "", "", "0X800B1F6", "0X800B1F6", 0, 0, (String)localObject, "", "", "");
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
  
  private void R()
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
    a(this.p);
    a(this.q);
  }
  
  private void S()
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
        str1 = String.format(anvx.a(2131698832), new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
    }
    for (String str2 = String.format(anvx.a(2131698865), new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });; str2 = anvx.a(2131698833))
    {
      this.jdField_i_of_type_AndroidWidgetTextView.setText(str1);
      bgyd.a(this.jdField_n_of_type_AndroidViewView, str2, Button.class.getName());
      return;
      str1 = "9999+";
      break;
      str1 = anvx.a(2131698864);
    }
  }
  
  private void T()
  {
    if (bdfk.b())
    {
      this.jdField_m_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
      this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(4);
      this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_f_of_type_ComTencentMobileqqRedtouchRedTouch;
      return;
    }
    this.jdField_m_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(4);
    this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
    this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch = this.jdField_e_of_type_ComTencentMobileqqRedtouchRedTouch;
  }
  
  private void U()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "jumpToProfile");
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    localAllInOne.jdField_g_of_type_Int = 1;
    localAllInOne.jdField_h_of_type_Int = 8;
    ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localAllInOne, 1009);
    azzt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void V()
  {
    Object localObject2 = IliveRedManager.parseShopRedBuffer(this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    String str = IliveDbManager.getIliveDrawerData("drawer_shop_jump_scheme");
    Object localObject1 = IliveRedManager.getDrawerLiveReportStr2(this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    IliveRedManager.sRedShoppingStr2 = (String)localObject1;
    IliveShareHelper.reportAction("qq_live", "chouti_page", "zhibo", "zhibo_button", "4", 102, IliveShareHelper.getFollowInfo("", (String)localObject1, "", "", ""));
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (RedTouch.a(this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo))
    {
      localObject1 = "1";
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X800B1F7", "0X800B1F7", 0, 0, (String)localObject1, "", "", "");
      if ((this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_o_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0)) {
        ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(101100, 31);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQSettingRedesign", 2, "Ilive start jump shop , url = " + str);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label247;
      }
    }
    label247:
    for (localObject1 = str;; localObject1 = localObject2)
    {
      if (!URLUtil.isNetworkUrl((String)localObject1)) {
        break label252;
      }
      localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_vip");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
      return;
      localObject1 = "2";
      break;
    }
    label252:
    localObject1 = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject1);
    if (localObject1 != null)
    {
      ((bheh)localObject1).a();
      return;
    }
    ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, IliveDbManager.getILiveEnterInfo(1));
  }
  
  private void W()
  {
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_f_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_Beid.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    DrawerFrame.jdField_a_of_type_Int = 0;
    if (AppSetting.jdField_c_of_type_Boolean) {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label66;
      }
    }
    label66:
    for (String str = "关闭夜间模式";; str = "夜间模式 ")
    {
      bgyd.a(this.jdField_f_of_type_AndroidViewView, str, Button.class.getName());
      return;
    }
  }
  
  private void X()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo != null) {
        this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo);
      }
      for (;;)
      {
        boolean bool = this.jdField_i_of_type_Boolean;
        this.jdField_i_of_type_Boolean = this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.c();
        if (QLog.isColorLevel()) {
          QLog.i("LocalRedTouchManager", 2, "updateHeadIcon, old:" + bool + " new:" + this.jdField_i_of_type_Boolean + ",profileRedTypeInfo = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo + ",profileAppinfo = " + this.jdField_j_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
        }
        if (bool != this.jdField_i_of_type_Boolean) {
          x();
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
  
  private void Y()
  {
    Object localObject2 = (aymd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    Object localObject1 = ((aymd)localObject2).a(-4);
    if ((((aymd)localObject2).a((RedTouchItem)localObject1, true)) && (((RedTouchItem)localObject1).count > 0) && (this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo != null))
    {
      QLog.d("QQSettingRedesign", 1, new Object[] { "updateProfileBubbleMsgView ", Integer.valueOf(((RedTouchItem)localObject1).count) });
      long l1;
      ImageView localImageView;
      TextView localTextView;
      View localView;
      if (this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.has())
      {
        l1 = this.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.get();
        localObject2 = this.jdField_l_of_type_AndroidViewView.findViewById(2131372402);
        localImageView = (ImageView)this.jdField_l_of_type_AndroidViewView.findViewById(2131368063);
        localTextView = (TextView)this.jdField_l_of_type_AndroidViewView.findViewById(2131371598);
        localView = this.jdField_l_of_type_AndroidViewView.findViewById(2131369164);
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label309;
        }
        ((View)localObject2).setBackgroundResource(2130846055);
      }
      for (;;)
      {
        a(l1, localImageView);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131698816, new Object[] { Integer.valueOf(((RedTouchItem)localObject1).count) });
        if (!((String)localObject1).equalsIgnoreCase(localTextView.getText().toString())) {
          localTextView.setText((CharSequence)localObject1);
        }
        ((View)localObject2).setContentDescription((CharSequence)localObject1);
        ((View)localObject2).setOnTouchListener(new aerq(this, localImageView, localTextView, localView));
        ((View)localObject2).setOnClickListener(this);
        this.jdField_l_of_type_AndroidViewView.setVisibility(0);
        Z();
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97E", "0X800A97E", 0, 0, "0", "0", "", "");
        return;
        l1 = 0L;
        break;
        label309:
        ((View)localObject2).setBackgroundResource(2130846054);
      }
    }
    this.jdField_l_of_type_AndroidViewView.setVisibility(8);
    ((ImageView)this.jdField_l_of_type_AndroidViewView.findViewById(2131368063)).setImageDrawable(null);
  }
  
  private void Z()
  {
    RedTouchItem localRedTouchItem = ((aymd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(10028);
    if ((localRedTouchItem != null) && (localRedTouchItem.count > 0) && (localRedTouchItem.unReadFlag))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "checkAndReportAnonymousAnswerMsgExpose");
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B47F", "0X800B47F", 0, 0, "", "", "", "");
    }
  }
  
  private String a(String paramString, int paramInt, RedTouch paramRedTouch)
  {
    bbbq localbbbq = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if ((paramRedTouch != null) && (paramRedTouch.c())) {
      return MobileReportManager.getNewReportInfo(paramString, localbbbq.a(String.valueOf(paramInt)));
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
  
  private void a(long paramLong, ImageView paramImageView)
  {
    if (paramLong == 111L)
    {
      paramImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130845723));
      return;
    }
    Object localObject = bheg.a(true);
    localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramLong + "", 4, (Drawable)localObject, (Drawable)localObject);
    Drawable localDrawable = paramImageView.getDrawable();
    if ((localDrawable != null) && (localDrawable != localObject) && ((localDrawable instanceof FaceDrawable))) {
      ((FaceDrawable)localDrawable).cancel();
    }
    paramImageView.setImageDrawable((Drawable)localObject);
  }
  
  private void a(Context paramContext)
  {
    bibb.a("drawer", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramContext);
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
      localObject3 = a(this.jdField_j_of_type_Boolean);
    } while ((i2 < 0) || (i2 >= this.jdField_a_of_type_ArrayOfAndroidViewView.length) || (i2 >= localObject3.length) || (i2 >= this.jdField_a_of_type_ArrayOfInt.length));
    Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[i2];
    int i1 = localObject3[i2];
    int i2 = this.jdField_a_of_type_ArrayOfInt[i2];
    Object localObject3 = (TextView)((View)localObject2).findViewById(2131369184);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ((TextView)localObject3).setText(lkj.a((String)localObject1, 16));
    }
    for (;;)
    {
      localObject1 = (ImageView)((View)localObject2).findViewById(2131369113);
      if (!TextUtils.isEmpty(paramMessage)) {
        break;
      }
      ((ImageView)localObject1).setImageResource(i1);
      return;
      ((TextView)localObject3).setText(i2);
    }
    if ((!TextUtils.isEmpty(paramMessage)) && (!bdfk.a()))
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataMedalList == null) {}
    for (Object localObject1 = null; a((String)localObject1); localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMedalList.jumpUrl) {
      return;
    }
    String str = a((String)localObject1, 101500, this.jdField_h_of_type_ComTencentMobileqqRedtouchRedTouch);
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
    ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(101500, 31);
    int i1 = aogw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
    if ((paramView instanceof QVipMedalView))
    {
      if (!baar.jdField_a_of_type_Boolean) {
        break label231;
      }
      ((QVipMedalView)paramView).a("0X800B2B5", i1);
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X800A127", 0, 0, String.valueOf(i1), "", "", "");
      return;
      label231:
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
        ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(i1, 30);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, "", "", "");
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
            VasApngUtil.getApngURLDrawable(localRedTypeInfo.red_content.get(), VasApngUtil.VIP_APNG_TAGS, URLDrawableHelper.TRANSPARENT);
          }
          i2 -= 1;
        }
        i1 += 1;
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
      U();
      QLog.e("QVipSettingMe.", 1, "medal list have no jump url ,so use the default");
      return true;
    }
    return false;
  }
  
  private void aa()
  {
    RedTouchItem localRedTouchItem = ((aymd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(10028);
    if ((localRedTouchItem != null) && (localRedTouchItem.count > 0) && (localRedTouchItem.unReadFlag))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "checkAndReportAnonymousAnswerMsgClick");
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B480", "0X800B480", 0, 0, "", "", "", "");
    }
  }
  
  private void ab()
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
        an();
      }
    }
    return;
    label111:
    ao();
    return;
    label116:
    ((View)localObject).setVisibility(8);
    ao();
  }
  
  private void ac()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[7];
    if ((localObject != null) && (((View)localObject).getVisibility() == 0))
    {
      localObject = awpu.a(this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      int i1 = awpu.a((String)localObject);
      awpu.a("10", i1 + "", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
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
  
  private void ad()
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
  
  private void ae()
  {
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.21(this));
  }
  
  private void af()
  {
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.22(this));
  }
  
  private void ag()
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
      bdla.b((QQAppInterface)localObject, "dc00898", "", "", "0X800ACDC", "0X800ACDC", 0, i1, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void ah()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_MQQPayRuleCfg.iconText)) || (TextUtils.isEmpty(this.jdField_a_of_type_MQQPayRuleCfg.iconUrl))) {
      QLog.e("QQSettingRedesign", 1, "showPayButton: iconText or iconUrl is empty");
    }
    Object localObject1;
    do
    {
      return;
      TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131369165);
      localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      aerr localaerr = new aerr(this, localTextView);
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
          localaerr.onLoadSuccessed((URLDrawable)localObject1);
          return;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler showPayButton: ", localMalformedURLException);
        return;
      }
      localMalformedURLException.setText("");
      ((URLDrawable)localObject1).setURLDrawableListener(localaerr);
    } while (((URLDrawable)localObject1).getStatus() != 2);
    ((URLDrawable)localObject1).restartDownload();
  }
  
  private void ai()
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
  
  private void aj()
  {
    if (this.jdField_a_of_type_Bhze.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4)) {}
    for (;;)
    {
      return;
      try
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vipTitleSpFile", 0).getString("vipTitleSpKey_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + anxv.a(), "");
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "updateVipText sp vipText = " + str);
        }
        if (!TextUtils.isEmpty(str))
        {
          TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131369184);
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
  
  private void ak()
  {
    ThreadManager.getUIHandler().post(new QQSettingMe.32(this));
  }
  
  private void al()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.post(new QQSettingMe.33(this));
  }
  
  private void am()
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
  
  private void an()
  {
    Iterator localIterator = BusinessInfoCheckUpdateItem.S_DYNAMIC_RED_POINT_PATH_LIST.iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface localDynamicRedPointPathInterface = (BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)localIterator.next();
      if ((localDynamicRedPointPathInterface instanceof anxy)) {
        ((anxy)localDynamicRedPointPathInterface).a();
      }
    }
  }
  
  private void ao()
  {
    Iterator localIterator = BusinessInfoCheckUpdateItem.S_DYNAMIC_RED_POINT_PATH_LIST.iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface localDynamicRedPointPathInterface = (BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)localIterator.next();
      if ((localDynamicRedPointPathInterface instanceof anxy)) {
        ((anxy)localDynamicRedPointPathInterface).b();
      }
    }
  }
  
  private void ap()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[12];
    if ((localView != null) && (localView.getVisibility() == 0)) {
      ThreadManager.getSubThreadHandler().post(new QQSettingMe.41(this));
    }
  }
  
  private void aq()
  {
    Object localObject = (aymd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem1 = ((aymd)localObject).a(10015);
    RedTouchItem localRedTouchItem2 = ((aymd)localObject).a(10016);
    int i1;
    if ((aymo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && ((((aymd)localObject).a(localRedTouchItem1, false)) || (((aymd)localObject).a(localRedTouchItem2, false))))
    {
      i1 = 1;
      if (i1 != 0)
      {
        i1 = ((aymd)localObject).a();
        localObject = null;
        switch (i1)
        {
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
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
  
  private void ar()
  {
    arzm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void b(@Nonnull Context paramContext)
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getString("sp_vip_medal_lvl_jump_url", null);
    if (a(str2)) {
      return;
    }
    String str3 = a(str2, 101400, this.jdField_g_of_type_ComTencentMobileqqRedtouchRedTouch);
    String str1 = str2;
    if (!TextUtils.isEmpty(str3)) {
      str1 = str2 + str3;
    }
    VipUtils.a(0, "mvip.pingtai.mobileqq.androidziliaoka.fromdrawer", "geren", str1, paramContext);
    ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(101400, 31);
    int i1 = aogw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B179", "0X800B179", 0, 0, String.valueOf(i1), "", "", "");
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
    if (this.jdField_a_of_type_Bhze.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2))
    {
      localView.setVisibility(0);
      return;
    }
    localObject2 = (TextView)localView.findViewById(2131369184);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject1 = (ImageView)localView.findViewById(2131369113);
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
      ((TextView)localObject2).setText(2131698814);
      break;
      label177:
      ((ImageView)localObject1).setImageResource(2130846077);
      continue;
      label187:
      ((ImageView)localObject1).setImageResource(2130846077);
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
    View localView = this.jdField_k_of_type_AndroidViewView.findViewById(2131365343);
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
      if (((ViewGroup)localObject1).getChildAt(i1).getId() != 2131371794) {
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
  
  private void c(boolean paramBoolean)
  {
    ThreadManager.post(new QQSettingMe.12(this), 5, null, false);
  }
  
  private boolean c()
  {
    aymd localaymd = (aymd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    localaymd.a(100601, false);
    localaymd.a(10016, false);
    localaymd.a(10015, false);
    if ((localaymd.a(localaymd.a(-7), true)) || (azzt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {}
    for (;;)
    {
      try
      {
        aq();
        this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_type.set(0);
        this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_content.set("");
        this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_desc.set("");
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
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo = null;
      boolean bool = false;
    }
  }
  
  private boolean d()
  {
    bhaa.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject = (aymd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = ((aymd)localObject).a(-4);
    if ((((aymd)localObject).a(localRedTouchItem, true)) && (localRedTouchItem.count > 0))
    {
      try
      {
        localObject = FileUtils.readObject(aymc.a(-4));
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
    long l1 = bhzf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_last_request_success_time", 0L);
    int i1 = bhzf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "setting_me_vip_sync_freq", 0);
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
      ((TextView)localObject1).setBackgroundResource(2130844667);
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
          break label1587;
        }
        QLog.d("QQSettingRedesign", 2, "updateQQLevelVipView card == null");
        return;
      }
      localSpannableStringBuilder = new SpannableStringBuilder();
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bSuperVipOpen != 1) {
        break label987;
      }
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bQQVipOpen != 1) {
        break label993;
      }
      bool2 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.bBigClubVipOpen != 1) {
        break label999;
      }
      i2 = 1;
      l1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.uCurMulType;
      i4 = this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQVipLevel;
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + i4 + ",QQLevel=" + this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel + ",curMulType =" + this.jdField_a_of_type_ComTencentMobileqqDataCard.uCurMulType);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      bool3 = bhjf.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType);
      localObject = null;
      i1 = 0;
      if (!bool3) {
        break label1588;
      }
      localObject = bhjf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, bhjg.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType), bhjf.b(this.jdField_a_of_type_ComTencentMobileqqDataCard.grayNameplateFlag));
      i1 = bhjf.a(bhjg.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType));
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
      paramString = bhjf.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
      i1 = 2130847075;
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
            break label1381;
          }
          QLog.e("QQSettingRedesign", 1, (String)localObject);
          label383:
          if (!bool1) {
            break label1412;
          }
          i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_SUPERVIP);
          str = bhjf.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
          i3 = 2130847076;
        }
      }
      label437:
      if ((str != null) && (i3 != 0))
      {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), this.jdField_b_of_type_AndroidWidgetImageView, str, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(i3));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131716170));
        this.jdField_b_of_type_AndroidWidgetImageView.setFocusableInTouchMode(true);
        paramString = bhjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, "VIA_SETTINGME");
        paramString.a();
        this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(paramString);
        al();
        if (bhpw.a().a(bool1, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingLoginTime)) {
          localSpannableStringBuilder.append(bhai.a(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView, localResources, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingGameId, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDan, this.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDanDisplatSwitch));
        }
        i2 = 0;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMedalList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() <= 0)) {
          break label1509;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setData(this.jdField_a_of_type_ComTencentMobileqqDataMedalList);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        if (!ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null)) {
          break label1486;
        }
        this.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#7bffffff"));
        i2 = this.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() * UIUtils.dip2px(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 21.0F) - UIUtils.dip2px(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 6.0F);
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.", 1, "width =" + i2 + "update medal:" + this.jdField_a_of_type_ComTencentMobileqqDataMedalList.convert());
        }
        i1 = i2;
        if (!this.jdField_e_of_type_Boolean)
        {
          this.jdField_e_of_type_Boolean = true;
          i1 = aogw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qvip", "0X800A126", 0, 0, String.valueOf(i1), "", "", "");
          i1 = i2;
        }
        localSpannableStringBuilder.append(bhai.a(localResources, this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType, this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel, a(i1)));
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(localSpannableStringBuilder, TextView.BufferType.SPANNABLE);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setContentDescription("等级：" + this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
        a(bool1, bool2, i4);
        if (!AppSetting.jdField_c_of_type_Boolean) {
          break label1587;
        }
        paramString = new StringBuilder();
        paramString.append(this.jdField_a_of_type_JavaLangString);
        if (!bool1) {
          break label1559;
        }
        paramString.append("你是尊贵的超级会员");
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel > 0) {
          paramString.append(" 等级").append(this.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
        }
        this.jdField_a_of_type_AndroidViewView.setContentDescription(paramString.toString());
        return;
        label987:
        bool1 = false;
        break;
        label993:
        bool2 = false;
        break label84;
        label999:
        i2 = 0;
        break label97;
        str = "occur error: curMulType=" + l1 + " but bQQVipOpen is false";
        i2 = 0;
        paramString = (String)localObject;
        localObject = str;
        continue;
      }
      label534:
      label674:
      label820:
      label1078:
      label1486:
      label1509:
      for (;;)
      {
        if (bool1)
        {
          i2 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, EVIPSPEC.E_SP_SUPERVIP);
          if ((i2 & 0xF) != 1) {
            break label1648;
          }
          i1 = 1;
          paramString = bhjf.a((i2 & 0xF) << 8 | i2 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
          if (i1 == 0) {
            break label1653;
          }
          i1 = 2130847076;
          break label1639;
        }
        str = "occur error: curMulType=" + l1 + " but bSuperVipOpen is false";
        i2 = 0;
        paramString = (String)localObject;
        localObject = str;
        break label345;
        label1381:
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
                  paramString = bhjf.a((i1 & 0xF) << 8 | i1 >> 8, this.jdField_a_of_type_ComTencentMobileqqDataCard.iBigClubVipLevel, this.jdField_a_of_type_ComTencentMobileqqDataCard.lBigClubTemplateId);
                  i1 = 2130847076;
                  break label1660;
                }
                i1 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
                paramString = bhjf.a((i1 & 0xF) << 8 | i1 >> 8, this.jdField_a_of_type_ComTencentMobileqqDataCard.iBigClubVipLevel, this.jdField_a_of_type_ComTencentMobileqqDataCard.lBigClubTemplateId);
                i1 = 2130847074;
                break label1660;
              }
              str = "occur error: curMulType=" + l1 + " but bBigClubVipOpen userStatus=" + i2;
              i2 = i1;
              paramString = (String)localObject;
              localObject = str;
              i1 = i3;
              break label1671;
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
            str = bhjf.a((i1 & 0xF) << 8 | i1 >> 8, i4, this.jdField_a_of_type_ComTencentMobileqqDataCard.lSuperVipTemplateId);
            i3 = 2130847075;
            break label437;
            this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(null);
            break label534;
            this.jdField_c_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131166478));
            break label674;
            this.jdField_a_of_type_ComTencentMobileqqWidgetQVipMedalView.setVisibility(8);
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            i1 = i2;
            if (!QLog.isColorLevel()) {
              break label820;
            }
            QLog.d("QVipSettingMe.", 1, "medal list is null");
            i1 = i2;
            break label820;
            if (!bool2) {
              break label941;
            }
            paramString.append("你是尊贵的会员");
            break label941;
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
            break label1045;
          }
        } while (l1 != 4L);
      }
      for (;;)
      {
        label941:
        label1587:
        label1588:
        label1639:
        i2 = 1;
        label1045:
        label1559:
        localObject = str;
        label1412:
        break;
        label1648:
        i1 = 0;
        break label1078;
        label1653:
        i1 = 2130847074;
      }
      label1660:
      localObject = null;
      i3 = 1;
      i2 = i1;
      i1 = i3;
      label1671:
      i3 = i1;
      i1 = i2;
      i2 = i3;
    }
  }
  
  private void h(String paramString)
  {
    long l1 = System.currentTimeMillis();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(String.valueOf(100400));
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
        i2 = NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label501;
        }
        localObject = this.jdField_c_of_type_JavaLangString;
        i1 = 1;
        if (((String)localObject).contains("?")) {
          break label455;
        }
        localStringBuilder.append((String)localObject + "?platform=1&type=20001&networkInfo=" + i2);
        localObject = localStringBuilder.toString();
        localObject = ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a((String)localObject, localAppInfo);
        if ((localAppInfo == null) || (localAppInfo.iNewFlag.get() == 0) || (localAppInfo.type.get() != 0)) {
          break label495;
        }
        bool = true;
        if ((paramString == null) || (i1 == 0)) {
          break label489;
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
        paramString = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
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
      label455:
      localStringBuilder.append(str + "&platform=1&type=20001&networkInfo=" + i2);
      continue;
      label489:
      paramString = str;
      continue;
      label495:
      boolean bool = false;
      continue;
      label501:
      int i1 = 0;
    }
  }
  
  private void i(String paramString)
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  protected void A()
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
    localObject1 = anvx.a(2131710219);
    i1 = 0;
    int i3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298438);
    int i4 = ScreenUtil.SCREEN_WIDTH;
    int i5 = ScreenUtil.dip2px(65.0F);
    int i6 = ScreenUtil.dip2px(15.0F);
    int i7 = this.jdField_f_of_type_AndroidWidgetImageView.getWidth();
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
          localObject5 = localObject1;
          localObject1 = anvx.a(2131710212);
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
                localObject1 = anvx.a(2131710219);
                localObject5 = null;
                localObject4 = null;
                continue;
              }
              if (this.jdField_b_of_type_Int == 4)
              {
                localObject1 = anvx.a(2131710212);
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
                    localObject4 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), 2130846080);
                    if (localObject4 == null) {
                      break label2028;
                    }
                    localObject7 = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources(), bkxu.a((Bitmap)localObject4));
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
        localObject1 = localJSONException4;
        continue;
        int i2 = i1;
      }
    }
    if (!a(l1 * 1000L))
    {
      this.jdField_b_of_type_Int = 1;
      i2 = 0;
      if (anxv.a() != 1033)
      {
        localObject5 = localObject1;
        try
        {
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
              i1 = 1;
              localObject5 = localObject1;
              if (System.currentTimeMillis() > l1 * 1000L)
              {
                localObject5 = localObject1;
                localObject7 = localObject1;
                if (System.currentTimeMillis() < l2 * 1000L) {
                  break label2040;
                }
              }
              localObject2 = null;
              i1 = 0;
              localObject5 = localObject1;
              localObject9 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_operation" + "10", "");
              localObject5 = localObject1;
              localObject7 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject9)) {
                break label2040;
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
                break label1695;
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
          break label1724;
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
        localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130846080);
        localObject8 = (URLImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377758);
        localObject9 = (ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131369113);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
        {
          localObject10 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject10).mFailedDrawable = ((Drawable)localObject7);
          ((URLDrawable.URLDrawableOptions)localObject10).mLoadingDrawable = ((Drawable)localObject7);
          ((URLDrawable.URLDrawableOptions)localObject10).mRequestHeight = 56;
          ((URLDrawable.URLDrawableOptions)localObject10).mRequestWidth = 56;
          if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((bkxw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) || (!this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())))
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
            localObject5 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131369184);
            if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
              break label1981;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i4 - i3 - i5 - (i6 + i7));
            this.jdField_b_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
            if (this.jdField_b_of_type_Int != 4) {
              break label1939;
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
  
  public void D()
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
  
  public void E()
  {
    this.jdField_g_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.j();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSignInInfo(0);
    a(null);
    amed.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer_weather_expose");
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A42B", "0X800A42B", 0, 0, "", "", "", "");
    int i1 = aogw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B178", "0X800B178", 0, 0, String.valueOf(i1), "", "", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (bhru.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType))) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType != 0) {
        break label196;
      }
    }
    label196:
    for (i1 = 99999;; i1 = this.jdField_a_of_type_ComTencentMobileqqDataCard.mQQLevelType)
    {
      bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A778", i1, 0, "", "", "", "");
      ap();
      return;
    }
  }
  
  void F()
  {
    ThreadManager.getSubThreadHandler().post(new QQSettingMe.WebPreloadTask(this));
  }
  
  public void G()
  {
    this.jdField_a_of_type_Avli.b();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      int i1 = 0;
      if (localIterator.hasNext())
      {
        Bitmap localBitmap = ((blgc)localIterator.next()).a();
        if (localBitmap == null) {
          break label70;
        }
        i1 = bhbx.a(localBitmap) + i1;
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
    float f2 = ((Resources)localObject).getDimension(2131298435);
    float f3 = ((Resources)localObject).getDimension(2131298419) + ((Resources)localObject).getDimension(2131298423) + ((Resources)localObject).getDimension(2131298427) + ((Resources)localObject).getDimension(2131298430) + ((Resources)localObject).getDimension(2131298438);
    bibe localbibe = biba.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    float f1 = f3;
    if (localbibe != null)
    {
      f1 = f3;
      if (localbibe.jdField_d_of_type_Int == 0) {
        f1 = f3 + AIOUtils.dp2px(42.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) + ((Resources)localObject).getDimension(2131298437);
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
  
  public blgc a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (blgc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_jump_url", "https://ti.qq.com/signin/public/index.html?_wv=1090528161&_wwv=13");
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onResume!");
    }
    this.jdField_f_of_type_Boolean = false;
    u();
    bdlm.a().a("QQSettingMe");
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.h();
    }
    try
    {
      if (((WindowManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("window")).getDefaultDisplay().getWidth() >= 480)
      {
        am();
        this.jdField_a_of_type_Amee.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      for (;;)
      {
        m();
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
        b(true);
        aq();
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
        localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[9];
        if (localObject3 != null)
        {
          localObject4 = (vzv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
          if ((localObject4 == null) || (!((vzv)localObject4).e())) {
            break;
          }
          ((View)localObject3).setVisibility(0);
        }
        bibb.a(this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView, (String)localObject1, "setting");
        I();
        J();
        b();
        ab();
        ad();
        H();
        ae();
        af();
        if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()) && (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (bdfk.b())) {
          ImmersiveUtils.a(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
        }
        localObject4 = new int[15];
        Object tmp454_452 = localObject4;
        tmp454_452[0] = 2131374484;
        Object tmp460_454 = tmp454_452;
        tmp460_454[1] = 2131371802;
        Object tmp466_460 = tmp460_454;
        tmp466_460[2] = 2131371799;
        Object tmp472_466 = tmp466_460;
        tmp472_466[3] = 2131371790;
        Object tmp478_472 = tmp472_466;
        tmp478_472[4] = 2131371793;
        Object tmp484_478 = tmp478_472;
        tmp484_478[5] = 2131371798;
        Object tmp490_484 = tmp484_478;
        tmp490_484[6] = 2131371765;
        Object tmp497_490 = tmp490_484;
        tmp497_490[7] = 2131371794;
        Object tmp504_497 = tmp497_490;
        tmp504_497[8] = 2131371800;
        Object tmp511_504 = tmp504_497;
        tmp511_504[9] = 2131371801;
        Object tmp518_511 = tmp511_504;
        tmp518_511[10] = 2131371795;
        Object tmp525_518 = tmp518_511;
        tmp525_518[11] = 2131364221;
        Object tmp532_525 = tmp525_518;
        tmp532_525[12] = 2131371766;
        Object tmp539_532 = tmp532_525;
        tmp539_532[13] = 2131365343;
        Object tmp546_539 = tmp539_532;
        tmp546_539[14] = 2131371764;
        tmp546_539;
        i2 = aogw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
        i1 = 0;
        for (;;)
        {
          if (i1 >= 15) {
            return;
          }
          if ((localObject4[i1] != 2131371802) || (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() != 0)) {
            break;
          }
          localObject1 = ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(String.valueOf(100400));
          int i3 = aogw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), RedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject1));
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C3", "0X800A8C3", i3, 0, String.valueOf(i3), "", "", "");
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
        if ((localObject4[i1] == 2131371799) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() == 0))
        {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C4", "0X800A8C4", i2, 0, String.valueOf(i2), "", "", "");
          RedTouch localRedTouch = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[2];
          localObject3 = "2";
          localObject2 = localObject3;
          if (localRedTouch != null)
          {
            localObject2 = localObject3;
            if (localRedTouch.c()) {
              localObject2 = "1";
            }
          }
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "wallet", "wallet.entrance.show", 0, 0, (String)localObject2, NetConnInfoCenter.getServerTimeMillis() + "", "", "8.4.10");
        }
        else if ((localObject4[i1] == 2131365343) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i1].getVisibility() == 0))
        {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C5", "0X800A8C5", i2, 0, String.valueOf(i2), this.jdField_d_of_type_JavaLangString, "", "");
        }
        else if (localObject4[i1] == 2131374484)
        {
          QzoneConfig.getInstance();
          if (QzoneConfig.isQQCircleShowDrawTabEntrance()) {
            this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(0);
          } else {
            this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(8);
          }
        }
        else if (localObject4[i1] == 2131371765)
        {
          localObject3 = this.jdField_a_of_type_Bhze.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "key_svip_item_makup_");
          localObject2 = "0";
          if (localObject3 != null) {
            localObject2 = ((MenumItem)localObject3).user_group + "";
          }
          MobileReportManager.getInstance().qqSetingMeReport(6, 101, (String)localObject2);
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
      this.jdField_a_of_type_Beid.a(paramQQAppInterface);
      k();
      y();
      Y();
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
    ImageView localImageView1 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131376648);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131376649);
    ImageView localImageView2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368398);
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
      localImageView1.setImageBitmap(this.jdField_a_of_type_Bbvn.a(paramRichStatus.actionId, 200));
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
      localTextView.setText(2131698804);
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
      if (bdfk.b()) {
        localImageView1.setVisibility(8);
      }
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break;
      label515:
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130846059);
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
      if (DeviceInfoUtil.isRubbishPhoneLenovoA366t()) {
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
    if (this.jdField_g_of_type_Boolean)
    {
      if ((bdfk.b()) && (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app)) && (ImmersiveUtils.isSupporImmersive() != 0))
      {
        paramBoolean = ThemeUtil.getCurrentThemeId();
        if ((bdfk.b(paramBoolean)) && (!ThemeUtil.isSimpleColrThemeStateBarUseWhite(paramBoolean)))
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
        if ((!bkxw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover())) {
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
  
  public void a(String paramString, blgc paramblgc)
  {
    if (paramblgc == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "[storeDynamicDrawable] drawable to be stored is null");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramblgc);
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
    //   0: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +50 -> 53
    //   6: ldc_w 324
    //   9: iconst_2
    //   10: new 337	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 3260
    //   20: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 1411	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: ldc_w 3262
    //   30: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_2
    //   34: invokevirtual 1411	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   37: ldc_w 3264
    //   40: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_3
    //   44: invokevirtual 632	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 486	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 1334	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 333	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokevirtual 1920	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   60: astore 6
    //   62: aload_0
    //   63: getfield 702	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   66: iconst_1
    //   67: aaload
    //   68: ldc_w 787
    //   71: invokevirtual 388	android/view/View:findViewById	(I)Landroid/view/View;
    //   74: checkcast 463	android/widget/TextView
    //   77: astore 7
    //   79: aload_0
    //   80: getfield 702	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   83: iconst_1
    //   84: aaload
    //   85: ldc_w 785
    //   88: invokevirtual 388	android/view/View:findViewById	(I)Landroid/view/View;
    //   91: checkcast 566	android/widget/ImageView
    //   94: astore 8
    //   96: aload_0
    //   97: getfield 331	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   100: invokevirtual 694	com/tencent/mobileqq/app/BaseActivity:getResources	()Landroid/content/res/Resources;
    //   103: astore 9
    //   105: aload 9
    //   107: ldc 184
    //   109: invokevirtual 814	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   112: astore 5
    //   114: invokestatic 1006	anxv:a	()Z
    //   117: ifeq +414 -> 531
    //   120: iload_1
    //   121: ifeq +253 -> 374
    //   124: invokestatic 2461	bhpw:a	()Lbhpw;
    //   127: getfield 3265	bhpw:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   130: invokestatic 740	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne +224 -> 357
    //   136: invokestatic 2461	bhpw:a	()Lbhpw;
    //   139: getfield 3265	bhpw:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   142: astore 6
    //   144: aload 6
    //   146: astore 5
    //   148: aload 5
    //   150: astore 6
    //   152: aload 5
    //   154: invokevirtual 419	java/lang/String:length	()I
    //   157: bipush 8
    //   159: if_icmple +13 -> 172
    //   162: aload 5
    //   164: iconst_0
    //   165: bipush 8
    //   167: invokevirtual 3269	java/lang/String:substring	(II)Ljava/lang/String;
    //   170: astore 6
    //   172: aload_0
    //   173: getfield 182	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_Bhze	Lbhze;
    //   176: aload_0
    //   177: getfield 333	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   180: iconst_4
    //   181: invokevirtual 1009	bhze:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)Z
    //   184: ifne +27 -> 211
    //   187: aload 7
    //   189: aload 6
    //   191: invokevirtual 529	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   194: aload_0
    //   195: getfield 165	com/tencent/mobileqq/activity/QQSettingMe:jdField_j_of_type_Boolean	Z
    //   198: ifeq +435 -> 633
    //   201: ldc_w 3270
    //   204: istore_3
    //   205: aload 8
    //   207: iload_3
    //   208: invokevirtual 786	android/widget/ImageView:setImageResource	(I)V
    //   211: aload 6
    //   213: invokestatic 740	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   216: ifne +107 -> 323
    //   219: aload_0
    //   220: getfield 333	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   223: invokevirtual 472	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   226: ldc_w 2031
    //   229: iconst_0
    //   230: invokevirtual 2032	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   233: invokeinterface 2684 1 0
    //   238: new 337	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 2034
    //   248: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_0
    //   252: getfield 333	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   255: invokevirtual 413	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   258: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 2036
    //   264: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokestatic 2038	anxv:a	()I
    //   270: invokevirtual 632	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: invokevirtual 486	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: aload 6
    //   278: invokeinterface 2691 3 0
    //   283: invokeinterface 2694 1 0
    //   288: pop
    //   289: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +31 -> 323
    //   295: ldc_w 324
    //   298: iconst_2
    //   299: new 337	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   306: ldc_w 3272
    //   309: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload 6
    //   314: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 486	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 634	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_0
    //   324: getfield 702	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   327: iconst_1
    //   328: aaload
    //   329: iconst_0
    //   330: invokevirtual 526	android/view/View:setVisibility	(I)V
    //   333: getstatic 372	com/tencent/common/config/AppSetting:jdField_c_of_type_Boolean	Z
    //   336: ifeq +20 -> 356
    //   339: aload_0
    //   340: getfield 702	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ArrayOfAndroidViewView	[Landroid/view/View;
    //   343: iconst_1
    //   344: aaload
    //   345: aload 6
    //   347: ldc_w 816
    //   350: invokevirtual 821	java/lang/Class:getName	()Ljava/lang/String;
    //   353: invokestatic 826	bgyd:a	(Landroid/view/View;Ljava/lang/CharSequence;Ljava/lang/String;)V
    //   356: return
    //   357: aload 9
    //   359: ldc_w 3273
    //   362: invokevirtual 814	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   365: astore 6
    //   367: aload 6
    //   369: astore 5
    //   371: goto -223 -> 148
    //   374: iload_2
    //   375: ifeq +47 -> 422
    //   378: invokestatic 2461	bhpw:a	()Lbhpw;
    //   381: getfield 3275	bhpw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   384: invokestatic 740	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   387: ifne +18 -> 405
    //   390: invokestatic 2461	bhpw:a	()Lbhpw;
    //   393: getfield 3275	bhpw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   396: astore 6
    //   398: aload 6
    //   400: astore 5
    //   402: goto -254 -> 148
    //   405: aload 9
    //   407: ldc_w 3276
    //   410: invokevirtual 814	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   413: astore 6
    //   415: aload 6
    //   417: astore 5
    //   419: goto -271 -> 148
    //   422: aload 6
    //   424: ldc_w 3278
    //   427: iconst_0
    //   428: invokeinterface 1925 3 0
    //   433: istore 4
    //   435: iload_3
    //   436: ifgt +8 -> 444
    //   439: iload 4
    //   441: ifle +47 -> 488
    //   444: invokestatic 2461	bhpw:a	()Lbhpw;
    //   447: getfield 3279	bhpw:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   450: invokestatic 740	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   453: ifne +18 -> 471
    //   456: invokestatic 2461	bhpw:a	()Lbhpw;
    //   459: getfield 3279	bhpw:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   462: astore 6
    //   464: aload 6
    //   466: astore 5
    //   468: goto -320 -> 148
    //   471: aload 9
    //   473: ldc_w 3280
    //   476: invokevirtual 814	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   479: astore 6
    //   481: aload 6
    //   483: astore 5
    //   485: goto -337 -> 148
    //   488: invokestatic 2461	bhpw:a	()Lbhpw;
    //   491: getfield 3281	bhpw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   494: invokestatic 740	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   497: ifne +18 -> 515
    //   500: invokestatic 2461	bhpw:a	()Lbhpw;
    //   503: getfield 3281	bhpw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   506: astore 6
    //   508: aload 6
    //   510: astore 5
    //   512: goto -364 -> 148
    //   515: aload 9
    //   517: ldc 184
    //   519: invokevirtual 814	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   522: astore 6
    //   524: aload 6
    //   526: astore 5
    //   528: goto -380 -> 148
    //   531: iload_1
    //   532: ifeq +16 -> 548
    //   535: aload 9
    //   537: ldc_w 3273
    //   540: invokevirtual 814	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   543: astore 6
    //   545: goto -373 -> 172
    //   548: iload_2
    //   549: ifeq +16 -> 565
    //   552: aload 9
    //   554: ldc_w 3276
    //   557: invokevirtual 814	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   560: astore 6
    //   562: goto -390 -> 172
    //   565: aload 6
    //   567: ldc_w 3278
    //   570: iconst_0
    //   571: invokeinterface 1925 3 0
    //   576: istore 4
    //   578: iload_3
    //   579: ifgt +8 -> 587
    //   582: iload 4
    //   584: ifle +16 -> 600
    //   587: aload 9
    //   589: ldc_w 3280
    //   592: invokevirtual 814	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   595: astore 6
    //   597: goto -425 -> 172
    //   600: aload 9
    //   602: ldc 184
    //   604: invokevirtual 814	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   607: astore 6
    //   609: goto -437 -> 172
    //   612: astore 6
    //   614: ldc_w 324
    //   617: iconst_1
    //   618: ldc_w 3283
    //   621: aload 6
    //   623: invokestatic 1845	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   626: aload 5
    //   628: astore 6
    //   630: goto -458 -> 172
    //   633: ldc_w 3284
    //   636: istore_3
    //   637: goto -432 -> 205
    //   640: astore 5
    //   642: ldc_w 324
    //   645: iconst_1
    //   646: ldc_w 3286
    //   649: aload 5
    //   651: invokestatic 1845	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
      return new int[] { 2130846067, 2130846082, 2130846065, 2130846078, 2130846084, 2130846086, 2130846088, 2130846038, 2130846070, 2130846063, 2130846061, 2130846068, 2130846077, 2130846034, 2130846080 };
    }
    return new int[] { 2130846067, 2130846083, 2130846066, 2130846079, 2130846085, 2130846087, 2130846089, 2130846038, 2130846071, 2130846064, 2130846061, 2130846069, 2130846077, 2130846035, 2130846080 };
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
      str = localSharedPreferences.getString("qqsettingme_f2f_guide_tip", anvx.a(2131710208));
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.f();
    }
    if (f()) {
      L();
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_Avli.d();
    bdlm.a().b("QQSettingMe");
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
      this.jdField_a_of_type_Beid.a();
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ansi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogx);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aodb);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a);
      }
      if (this.jdField_a_of_type_Bbvn != null)
      {
        this.jdField_a_of_type_Bbvn.b(this.jdField_a_of_type_Bbtg);
        this.jdField_a_of_type_Bbvn.b(this.jdField_a_of_type_Bbtd);
        this.jdField_a_of_type_Bbvn.b(this.jdField_a_of_type_Bbtb);
      }
      if (this.jdField_a_of_type_Amee != null)
      {
        this.jdField_a_of_type_Amee.a(null);
        this.jdField_a_of_type_Amee = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Ayqy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anya);
    }
    if (this.jdField_a_of_type_Beid != null) {
      this.jdField_a_of_type_Beid.a(this.jdField_a_of_type_Beig, false);
    }
    bhpw.a().b(this.jdField_a_of_type_Bhpy);
    aavb.a().b(this.jdField_a_of_type_Aavc);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ansi, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Ayqy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogx, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aodb, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anya, true);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a);
      }
      this.jdField_a_of_type_Beid.a(this.jdField_a_of_type_Beig, true);
      this.jdField_a_of_type_Amee = ((amee)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WEATHER_MANAGER));
      if (this.jdField_a_of_type_Amee != null)
      {
        this.jdField_a_of_type_Amef = new aesl(this);
        this.jdField_a_of_type_Amee.a(this.jdField_a_of_type_Amef);
      }
      bhpw.a().a(this.jdField_a_of_type_Bhpy);
      aavb.a().a(this.jdField_a_of_type_Aavc);
    }
  }
  
  public void g()
  {
    SosoInterface.startLocation(new aesi(this, 0, true, true, 60000L, true, false, "QQSettingRedesign"));
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
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper = bgvx.a().a();
    this.jdField_a_of_type_Beid = new beid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    f();
    k();
    y();
    w();
    b(true);
    m();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.h();
      this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController.a();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.opencenter.vipInfo"));
      if (TextUtils.isEmpty(bhpw.a().jdField_b_of_type_JavaLangString)) {
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
    R();
    X();
    Y();
    n();
    o();
    s();
    t();
    A();
    p();
    j();
    q();
    r();
    ac();
    ag();
    Q();
    B();
    ai();
    ar();
    O();
    P();
  }
  
  protected void j()
  {
    try
    {
      a(5, this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      ((baql)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_ALBUM_RED_TOUCH)).a(this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
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
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable(bheg.b());
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
  
  @RequiresApi(api=23)
  public void l()
  {
    if (this.jdField_a_of_type_Beid != null) {
      this.jdField_a_of_type_Beid.b();
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
        this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.setForeground(new ColorDrawable(1996488704));
      }
    }
    else
    {
      T();
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "ThemeDebugKeyLog:onPostThemeChanged, refresh pendant after theme changed.");
      }
      x();
      Y();
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
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166474);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846072);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846052);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((!bkxw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataCard)) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))) {
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
      localObject2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368398);
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
      ae();
      ak();
      af();
      B();
      g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      S();
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i1);
      localObject1 = a(this.jdField_j_of_type_Boolean);
      i2 = 0;
      if (i2 >= 15) {
        break label689;
      }
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[i2] != null)
      {
        localObject2 = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369113);
        ((ImageView)localObject2).setImageResource(localObject1[i2]);
        localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[i2].findViewById(2131369184);
        if (this.jdField_j_of_type_Boolean) {
          break label668;
        }
        localTextView.setTextColor(i1);
      }
    }
    for (;;)
    {
      if ((bdfk.b()) && ("2920".equals(ThemeUtil.getCurrentThemeId()))) {
        localTextView.setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166473));
      }
      if (i2 == 10) {
        a((ImageView)localObject2, localTextView);
      }
      i2 += 1;
      break label440;
      this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.setForeground(null);
      break;
      label579:
      bool = false;
      break label129;
      label584:
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166475);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846076);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130846051);
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
      localTextView.setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166473));
    }
    label689:
    ((aqeq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (ThemeUtil.isSimpleAndOtherThemeSwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "QQSettingMe onPostThemeChanged refresh because simple theme switch!");
      }
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    ((aocj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REDPOINT_HANDER)).notifyUI(4, true, null);
  }
  
  public void m()
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int i1 = this.jdField_a_of_type_Beid.a();
    String str;
    if (i1 == 1) {
      if (this.jdField_j_of_type_Boolean)
      {
        localObject1 = ((Resources)localObject2).getDrawable(2130846052);
        str = ((Resources)localObject2).getString(2131698834);
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
      localObject1 = ((Resources)localObject2).getDrawable(2130846051);
      break;
      if (i1 == 2)
      {
        if (this.jdField_j_of_type_Boolean) {}
        for (localObject1 = ((Resources)localObject2).getDrawable(2130846052);; localObject1 = ((Resources)localObject2).getDrawable(2130846051))
        {
          str = ((Resources)localObject2).getString(2131698834);
          localObject2 = localObject1;
          localObject1 = str;
          break;
        }
      }
      localObject2 = null;
    }
  }
  
  public void n()
  {
    boolean bool2 = true;
    boolean bool1 = bgvx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.a(bool1);
    }
    if ((!bool1) && (aoae.a(1)))
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
        this.jdField_i_of_type_ComTencentMobileqqRedtouchRedTouch.c(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      }
      return;
    }
  }
  
  protected void o()
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
        Object localObject5;
        label1184:
        boolean bool;
        Object localObject2;
        label2766:
        Object localObject3;
        switch (paramView.getId())
        {
        case 2131369370: 
        default: 
          break;
        case 2131363334: 
          if (FrameHelperActivity.b())
          {
            FrameHelperActivity.c(true);
            FrameHelperActivity.t();
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009C4E", "0X8009C4E", 0, 0, "", "", "", "");
          }
          break;
        case 2131371764: 
        case 2131371788: 
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
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_duty", "", "locker", "clk", 0, 0, "", "", "", "");
            }
          }
        case 2131371982: 
          U();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D6");
          break;
        case 2131368095: 
          U();
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004033", "0X8004033", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D7");
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          if (this.jdField_d_of_type_ComTencentMobileqqRedtouchRedTouch.c()) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X8006726");
          }
          break;
        case 2131374756: 
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QRDisplayActivity.class);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          ((Intent)localObject1).putExtra("title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131716566));
          ((Intent)localObject1).putExtra("nick", ContactUtils.getAccountNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4));
          ((Intent)localObject1).putExtra("uin", (String)localObject4);
          ((Intent)localObject1).putExtra("type", 1);
          ((Intent)localObject1).putExtra("reportFlag", 1);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055BB", "0X80055BB", 0, 0, "", "", "", "");
          break;
        case 2131371799: 
          l1 = System.currentTimeMillis();
          if (ProfileActivity.a(this.jdField_a_of_type_Long, l1))
          {
            this.jdField_a_of_type_Long = l1;
            if (QWalletHelper.isValidToLaunchQWallet(l1))
            {
              QWalletHelper.launchQWalletAct(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true);
              bhai.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(100007, 31);
              localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[2];
              i1 = aogw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), ((RedTouch)localObject1).c());
              localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
              if (((RedTouch)localObject1).c()) {}
              for (localObject1 = "1";; localObject1 = "2")
              {
                bdla.b((QQAppInterface)localObject4, "P_CliOper", "Vip_pay_mywallet", (String)localObject5, "wallet", "wallet.entrance.click", 0, 0, (String)localObject1, NetConnInfoCenter.getServerTimeMillis() + "", "", "8.4.10");
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8BF", "0X800A8BF", i1, 0, String.valueOf(i1), "", "", "");
                if (jdField_a_of_type_Int <= 0) {
                  break label1184;
                }
                DrawerFrame.jdField_a_of_type_Int = 2;
                break;
              }
              DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            }
          }
          break;
        case 2131371790: 
          if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()) {}
          for (bool = true;; bool = false)
          {
            bmaf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, -1, bool);
            bman.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, 0);
            bmar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(103000, 31);
            break;
          }
        case 2131371798: 
          localObject1 = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
          bool = false;
          localObject4 = new QZoneClickReport.ReportInfo();
          ((QZoneClickReport.ReportInfo)localObject4).setActionType("443");
          ((QZoneClickReport.ReportInfo)localObject4).setSubactionType("3");
          ((QZoneClickReport.ReportInfo)localObject4).setToUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
          if ((this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_g_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1))
          {
            bool = true;
            ((QZoneClickReport.ReportInfo)localObject4).setReserves("1");
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (QZoneClickReport.ReportInfo)localObject4);
            ((bbbq)localObject1).a(100180, 31);
          }
          try
          {
            l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
            localObject5 = QZoneHelper.UserInfo.getInstance();
            ((QZoneHelper.UserInfo)localObject5).qzone_uin = String.valueOf(l1);
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = ContactUtils.getAccountNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            continue;
            ((QZoneClickReport.ReportInfo)localObject4).setReserves("2");
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              l1 = 0L;
            }
          }
        case 2131371765: 
          localObject2 = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
          ((bbbq)localObject2).a(100005, 31);
          if (((RedTouch)((ViewGroup)paramView).getChildAt(0)).c()) {}
          for (localObject2 = MobileReportManager.getNewReportInfo(((bbbq)localObject2).a(String.valueOf(100005)));; localObject2 = MobileReportManager.getNewDefaultReportInfo("outside", "3"))
          {
            VasWebviewUtil.openIndividuationIndex(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject2);
            ThreadManager.post(new QQSettingMe.17(this), 5, null, true);
            localObject4 = this.jdField_a_of_type_Bhze.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "key_svip_item_makup_");
            localObject2 = "0";
            if (localObject4 != null) {
              localObject2 = ((MenumItem)localObject4).user_group + "";
            }
            MobileReportManager.getInstance().qqSetingMeReport(6, 102, (String)localObject2);
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Trends_tab", "Personality_setting", 0, 0, "", "", "", "");
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
            break;
          }
        case 2131377507: 
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQSettingSettingActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          if (bgvx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004DB0", "0X8004DB0", 0, 0, "", "", bgvx.a(), "");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a != null) && (this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0)) {
            ansg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper.a.iNewTimeStamp);
          }
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Setting_tab", 0, 0, "", "", "", "");
          ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(100190, 31);
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          break;
        case 2131371995: 
          if (!behh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "", new aerp(this))) {
            W();
          }
          break;
        case 2131370408: 
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((Intent)localObject2).putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=draw");
          ((Intent)localObject2).putExtra("hide_more_button", true);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A9C3", "0X800A9C3", 0, 0, "", "", "", "");
          break;
        case 2131381374: 
          i1 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getInt("cur_adcode", 0);
          amfb.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, "", true, String.valueOf(i1));
          QLog.i("QQSettingRedesign", 1, "startNewWeatherWeb adCode = " + i1);
          amed.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer_weather_click");
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A42C", "0X800A42C", 0, 0, "", "", "", "");
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005BE4", "0X8005BE4", 0, 0, "", "", "", "");
          break;
        case 2131377753: 
          if ((this.jdField_a_of_type_Bbvn != null) && (!this.jdField_a_of_type_Bbvn.a()))
          {
            ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(100450, 31);
            if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
            {
              localObject2 = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131376649);
              if ((localObject2 != null) && (((TextView)localObject2).getText() != null))
              {
                localObject2 = new Bundle();
                ((Bundle)localObject2).putInt("from_type", 3);
                SignTextEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, "", (Bundle)localObject2, -1);
              }
            }
            DrawerFrame.jdField_a_of_type_Int = 0;
          }
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signiture", "set_enter", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X80072D8");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X800A669");
          break;
        case 2131374484: 
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          ((HashMap)localObject2).put("key_jump_from", "9");
          vvh.a(BaseApplicationImpl.context, "openmainpage", (HashMap)localObject2);
          break;
        case 2131371802: 
          l1 = System.currentTimeMillis();
          if (ProfileActivity.a(this.jdField_a_of_type_Long, l1))
          {
            this.jdField_a_of_type_Long = l1;
            if (QLog.isColorLevel()) {
              QLog.i("QQSettingRedesign", 2, "enter vip");
            }
            ThreadManager.post(new QQSettingMe.19(this), 5, null, true);
            localObject2 = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
            localObject4 = this.jdField_a_of_type_ArrayOfComTencentMobileqqRedtouchRedTouch[1];
            i1 = aogw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), ((RedTouch)localObject4).c());
            if (((RedTouch)localObject4).c()) {}
            for (localObject2 = MobileReportManager.getNewReportInfo(((bbbq)localObject2).a(String.valueOf(100400)));; localObject2 = MobileReportManager.getNewDefaultReportInfo("outside", "1"))
            {
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8BE", "0X800A8BE", i1, 0, String.valueOf(i1), "", "", "");
              h((String)localObject2);
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
              MobileReportManager.getInstance().qqSetingMeReport(1, 102, String.valueOf(i1));
              if (jdField_a_of_type_Int <= 0) {
                break label2766;
              }
              DrawerFrame.jdField_a_of_type_Int = 2;
              break;
            }
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          }
          break;
        case 2131371793: 
          localObject2 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, FileAssistantActivity.class);
          ((Intent)localObject2).putExtra("from", "FileAssistant");
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004251", "0X8004251", 0, 0, "", "", "", "");
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          localObject2 = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
          localObject4 = ((bbbq)localObject2).a(String.valueOf(100160));
          if ((localObject4 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() != 0)) {
            ((bbbq)localObject2).a(100160, 31);
          }
          try
          {
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("service_type", 2);
            ((JSONObject)localObject5).put("act_id", 1002);
            ((bbbq)localObject2).c((BusinessInfoCheckUpdate.AppInfo)localObject4, ((JSONObject)localObject5).toString());
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
        case 2131371800: 
          if (jdField_a_of_type_Int > 0) {
            DrawerFrame.jdField_a_of_type_Int = 2;
          } else {
            DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          }
          break;
        case 2131365343: 
          localObject5 = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
          localObject4 = "";
          BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbbq)localObject5).a(String.valueOf(100500));
          localObject3 = localObject4;
          if (localAppInfo != null)
          {
            localObject3 = localObject4;
            if (localAppInfo.iNewFlag.get() != 0)
            {
              localObject3 = MobileReportManager.getStringReport2H5(localAppInfo);
              ((bbbq)localObject5).a(100500, 31);
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
          i1 = aogw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), ((RedTouch)localObject3).c());
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A8C0", "0X800A8C0", i1, 0, String.valueOf(i1), this.jdField_d_of_type_JavaLangString, "", "");
          break;
        case 2131371801: 
          QQStoryMemoriesActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, QQStoryContext.a().b(), true);
          DrawerFrame.jdField_a_of_type_Int = jdField_a_of_type_Int;
          break;
        case 2131371795: 
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
              break label3535;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            bdla.b((QQAppInterface)localObject3, "dc00898", "", "", "0X800ACDD", "0X800ACDD", 0, i1, "", "", "", "");
            localObject3 = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
            if (localObject3 == null) {
              break;
            }
            ((bbbq)localObject3).a(100077, 31);
            break;
            localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("url", (String)localObject3);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
            break label3417;
          }
        case 2131364221: 
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
          localObject4 = ((Context)localObject3).getSharedPreferences("call_tim_config_pre" + (String)localObject4, 0).getString("call_tim_config_url", null);
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = arot.a().a();
          }
          localObject4 = localObject3;
          if (localObject3 == null) {
            localObject4 = "https://docs.qq.com/desktop/m/index.html";
          }
          localObject3 = becr.b((String)localObject4, "s_qq_drawer");
          localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
          ((Intent)localObject4).putExtra("url", (String)localObject3);
          ((Intent)localObject4).putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
          ((Intent)localObject4).putExtra("tdsourcetag", "s_qq_drawer");
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800887E", "0X800887E", 0, 0, "", "", "", "");
          break;
        case 2131374478: 
          a(paramView);
          break;
        case 2131374517: 
          b(paramView.getContext());
          break;
        case 2131372386: 
          a(paramView.getContext());
          break;
        case 2131372402: 
          aa();
          bhaa.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A97F", "0X800A97F", 0, 0, "0", "0", "", "");
          break;
        case 2131371794: 
          label3535:
          i1 = awpu.a(awpu.a(this.jdField_m_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo));
          localObject3 = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
          localObject4 = ((bbbq)localObject3).a(String.valueOf(100066));
          if ((localObject4 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() != 0))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView == null) || (this.jdField_a_of_type_ComTencentMobileqqLoverzoneLoveZoneTabRedDotView.getVisibility() != 0)) {
              break label3940;
            }
            a("0x800AAFB", "1");
          }
          for (;;)
          {
            ((bbbq)localObject3).a(100066, 31);
            awpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2066, "10", i1 + "");
            break;
            a("0x800AAFB", "2");
          }
        case 2131371766: 
          label3417:
          label3940:
          V();
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
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_f_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void q()
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
  
  protected void r()
  {
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(String.valueOf(1000017));
      if (!((aqjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a())
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
      a(6, this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1))
      {
        WebProcessManager localWebProcessManager = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
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
  public void t()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 333	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5: invokevirtual 1024	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   8: putfield 4095	com/tencent/mobileqq/activity/QQSettingMe:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 4095	com/tencent/mobileqq/activity/QQSettingMe:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokestatic 4098	aogw:a	(Ljava/lang/String;)LMQQ/PayRuleCfg;
    //   19: putfield 1517	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   22: aload_0
    //   23: getfield 333	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: aload_0
    //   27: getfield 1517	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   30: aload_0
    //   31: getfield 2913	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   34: invokestatic 4101	aogw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;LMQQ/PayRuleCfg;Z)Z
    //   37: istore_1
    //   38: aload_0
    //   39: getfield 1517	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   42: ifnonnull +266 -> 308
    //   45: ldc_w 324
    //   48: iconst_1
    //   49: ldc_w 4103
    //   52: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: iload_1
    //   56: ifeq +340 -> 396
    //   59: aload_0
    //   60: getfield 2913	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   63: ifne +59 -> 122
    //   66: aload_0
    //   67: iconst_1
    //   68: putfield 2913	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   71: aconst_null
    //   72: ldc_w 1198
    //   75: ldc 208
    //   77: ldc 208
    //   79: ldc 208
    //   81: ldc_w 4105
    //   84: aload_0
    //   85: getfield 1517	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   88: invokestatic 4108	aogw:a	(LMQQ/PayRuleCfg;)I
    //   91: iconst_1
    //   92: iconst_0
    //   93: ldc_w 1196
    //   96: aload_0
    //   97: getfield 1517	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   100: getfield 4111	MQQ/PayRuleCfg:advId	Ljava/lang/String;
    //   103: ldc 208
    //   105: ldc 208
    //   107: invokestatic 4114	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   110: bipush 101
    //   112: aload_0
    //   113: getfield 1517	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   116: getfield 4111	MQQ/PayRuleCfg:advId	Ljava/lang/String;
    //   119: invokestatic 4117	aogw:a	(ILjava/lang/String;)V
    //   122: aload_0
    //   123: invokespecial 4119	com/tencent/mobileqq/activity/QQSettingMe:ah	()V
    //   126: invokestatic 322	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +36 -> 165
    //   132: ldc_w 324
    //   135: iconst_2
    //   136: new 337	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 4121
    //   146: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: getfield 1102	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   153: invokestatic 4122	bbbq:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)Ljava/lang/String;
    //   156: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 486	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 634	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: new 1050	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   168: dup
    //   169: invokespecial 1641	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   172: astore_2
    //   173: aload_2
    //   174: aload_0
    //   175: getfield 1102	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   178: invokevirtual 1644	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   181: iload_1
    //   182: ifeq +54 -> 236
    //   185: aload_2
    //   186: invokestatic 4125	com/tencent/mobileqq/redtouch/RedTouchTextView:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)Ljava/util/List;
    //   189: ifnull +47 -> 236
    //   192: new 96	java/util/ArrayList
    //   195: dup
    //   196: invokespecial 99	java/util/ArrayList:<init>	()V
    //   199: astore_3
    //   200: new 1670	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   203: dup
    //   204: invokespecial 1695	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   207: astore 4
    //   209: aload 4
    //   211: getfield 1673	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   214: iconst_0
    //   215: invokevirtual 1696	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   218: aload_3
    //   219: aload 4
    //   221: invokevirtual 1122	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   224: pop
    //   225: aload_2
    //   226: getfield 1648	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   229: getfield 1657	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   232: aload_3
    //   233: invokevirtual 1694	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   236: aload_0
    //   237: iconst_1
    //   238: aload_2
    //   239: invokespecial 1191	com/tencent/mobileqq/activity/QQSettingMe:a	(ILcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   242: aload_0
    //   243: getfield 333	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   246: ifnull +61 -> 307
    //   249: aload_0
    //   250: getfield 1102	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   253: ifnull +163 -> 416
    //   256: aload_0
    //   257: getfield 1102	com/tencent/mobileqq/activity/QQSettingMe:jdField_d_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   260: getfield 1063	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   263: invokevirtual 1326	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   266: iconst_1
    //   267: if_icmpeq +6 -> 273
    //   270: goto +146 -> 416
    //   273: ldc_w 324
    //   276: iconst_1
    //   277: ldc_w 4127
    //   280: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: new 1342	android/content/Intent
    //   286: dup
    //   287: aload_0
    //   288: getfield 331	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   291: ldc_w 4129
    //   294: invokespecial 1347	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   297: astore_2
    //   298: aload_0
    //   299: getfield 331	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   302: aload_2
    //   303: invokevirtual 4133	com/tencent/mobileqq/app/BaseActivity:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   306: pop
    //   307: return
    //   308: ldc_w 324
    //   311: iconst_1
    //   312: new 337	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 338	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 4135
    //   322: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_0
    //   326: getfield 1517	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   329: getfield 1987	MQQ/PayRuleCfg:iconText	Ljava/lang/String;
    //   332: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc_w 4137
    //   338: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: iload_1
    //   342: invokevirtual 1411	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   345: ldc_w 4139
    //   348: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_0
    //   352: getfield 1517	com/tencent/mobileqq/activity/QQSettingMe:jdField_a_of_type_MQQPayRuleCfg	LMQQ/PayRuleCfg;
    //   355: getfield 1990	MQQ/PayRuleCfg:iconUrl	Ljava/lang/String;
    //   358: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc_w 4141
    //   364: invokevirtual 485	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: getfield 2913	com/tencent/mobileqq/activity/QQSettingMe:jdField_f_of_type_Boolean	Z
    //   371: invokevirtual 1411	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   374: invokevirtual 486	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: goto -325 -> 55
    //   383: astore_2
    //   384: ldc_w 324
    //   387: iconst_1
    //   388: ldc_w 4143
    //   391: aload_2
    //   392: invokestatic 1845	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   395: return
    //   396: aload_0
    //   397: invokevirtual 4146	com/tencent/mobileqq/activity/QQSettingMe:v	()V
    //   400: goto -274 -> 126
    //   403: astore_2
    //   404: ldc_w 324
    //   407: iconst_2
    //   408: ldc_w 4148
    //   411: aload_2
    //   412: invokestatic 1845	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    TextView localTextView = (TextView)this.jdField_a_of_type_ArrayOfAndroidViewView[1].findViewById(2131369165);
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
    ExtensionInfo localExtensionInfo = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    if (bdfk.b())
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    label236:
    for (;;)
    {
      return;
      Object localObject;
      if ((!this.jdField_i_of_type_Boolean) && (localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
      {
        localObject = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
        ((AvatarPendantManager)localObject).b();
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        localObject = ((AvatarPendantManager)localObject).a(localExtensionInfo.pendantId);
        if (bhcs.a(localExtensionInfo.pendantId))
        {
          ((PendantInfo)localObject).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.jdField_h_of_type_Int, localExtensionInfo.uin, localExtensionInfo.pendantDiyId);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarPendant", "choutishow", 0, 0, "", "", "", "");
        }
      }
      for (int i1 = 1;; i1 = 0)
      {
        if ((i1 != 1) || (i1 != this.jdField_i_of_type_Boolean)) {
          break label236;
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
  
  public void y()
  {
    this.jdField_a_of_type_Bbvn = ((bbvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    if ((this.jdField_a_of_type_Bbvn == null) || (this.jdField_e_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_a_of_type_Bbtg == null)
    {
      this.jdField_a_of_type_Bbtg = new aert(this);
      this.jdField_a_of_type_Bbtd = new aeru(this);
      this.jdField_a_of_type_Bbtb = new aerv(this);
      this.jdField_a_of_type_Bbvn.a(this.jdField_a_of_type_Bbtg);
      this.jdField_a_of_type_Bbvn.a(this.jdField_a_of_type_Bbtd);
      this.jdField_a_of_type_Bbvn.a(this.jdField_a_of_type_Bbtb);
    }
    RichStatus localRichStatus = this.jdField_a_of_type_Bbvn.a(false);
    if ((localRichStatus == null) || (localRichStatus.isEmpty()))
    {
      ThreadManager.getFileThreadHandler().post(new QQSettingMe.29(this));
      return;
    }
    a(localRichStatus);
  }
  
  void z()
  {
    this.jdField_a_of_type_Bbvn = ((bbvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    if (this.jdField_a_of_type_Bbvn == null)
    {
      QLog.e("QQSettingRedesign", 1, "preLoadSignature, mStatusManager == null");
      return;
    }
    ImageView localImageView1 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131376648);
    TextView localTextView = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131376649);
    ImageView localImageView2 = (ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368398);
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
      localImageView1.setImageBitmap(this.jdField_a_of_type_Bbvn.a(i1, 200));
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
      localTextView.setText(2131698804);
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
      if (!bdfk.b()) {
        break;
      }
      localImageView1.setVisibility(8);
      return;
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      break label118;
      label509:
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130846059);
      localImageView1.setVisibility(8);
      break label373;
      label538:
      ((StringBuilder)localObject1).append((String)localObject2);
      break label413;
      label549:
      localImageView2.setVisibility(0);
      if (DeviceInfoUtil.isRubbishPhoneLenovoA366t()) {
        localTextView.setText((String)localObject1 + " ");
      } else {
        localTextView.setText((CharSequence)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe
 * JD-Core Version:    0.7.0.1
 */
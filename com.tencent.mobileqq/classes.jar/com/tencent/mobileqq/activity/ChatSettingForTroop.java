package com.tencent.mobileqq.activity;

import Override;
import abuf;
import adri;
import adrj;
import adrk;
import adrl;
import adrm;
import adrn;
import adro;
import adrp;
import adrq;
import adrs;
import adrt;
import adru;
import adrv;
import adrw;
import adrx;
import adry;
import adrz;
import adsa;
import adsb;
import adsc;
import adsd;
import adse;
import adsf;
import adsg;
import adsh;
import adsi;
import adsk;
import adsl;
import adsm;
import adsn;
import adso;
import adsp;
import adsq;
import adsr;
import adss;
import adst;
import adsv;
import adsw;
import adsx;
import adsy;
import adsz;
import adta;
import adtd;
import adte;
import adtf;
import adtg;
import adth;
import advh;
import ajfq;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InflateException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anrb;
import anrc;
import anvi;
import anvx;
import aoep;
import aofp;
import aofu;
import aome;
import aqxe;
import argb;
import argc;
import argl;
import argu;
import argv;
import arhh;
import arjy;
import aslo;
import astl;
import awfq;
import awyd;
import awzf;
import azry;
import bacq;
import bact;
import bdfk;
import bdla;
import bdvn;
import begq;
import bejv;
import beki;
import beuq;
import bfck;
import bfcp;
import bfkh;
import bfki;
import bfkw;
import bfwu;
import bfya;
import bgft;
import bggj;
import bghc;
import bghd;
import bghi;
import bghs;
import bgig;
import bgil;
import bgld;
import bglm;
import bgls;
import bgnx;
import bgog;
import bgss;
import bgst;
import bgua;
import bhbu;
import bhdf;
import bhdj;
import bhdx;
import bheg;
import bhhi;
import bhmb;
import bhnp;
import bhow;
import bhsu;
import bhsv;
import bhzf;
import bint;
import bisl;
import biso;
import bisy;
import bkzi;
import bkzz;
import blha;
import bmiu;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.EntryDebugFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.GameRankFormItem;
import com.tencent.mobileqq.troop.widget.TroopAppFormItem;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.troopnick.TroopNickFormItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.Switch;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.plugin.PluginInfo;
import cooperation.troop.TroopBaseProxyActivity;
import cooperation.troop.TroopManageProxyActivity;
import cooperation.troop.TroopPluginManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0x899.oidb_0x899.memberlist;>;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import mvl;
import ncz;
import nqi;
import nvs;
import nwk;
import nxu;
import nxx;
import org.json.JSONArray;
import org.json.JSONObject;
import osg;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.ExtraInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.TabInfo;
import ykv;

public class ChatSettingForTroop
  extends BaseActivity
  implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener, bghi, FaceDecoder.DecodeTaskCompletionListener
{
  public static final ArrayList<Integer> a;
  public static String m;
  protected final int a;
  long jdField_a_of_type_Long = 0L;
  protected adth a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  protected BroadcastReceiver a;
  public Intent a;
  public Drawable a;
  public Handler a;
  protected DisplayMetrics a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new adrq(this);
  public View.OnTouchListener a;
  protected View a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  public TextView a;
  anrc jdField_a_of_type_Anrc = new adss(this);
  anvi jdField_a_of_type_Anvi = new adsh(this);
  aofu jdField_a_of_type_Aofu = new adse(this);
  public argu a;
  private bgnx jdField_a_of_type_Bgnx;
  public bgss a;
  public bgua a;
  public bhhi a;
  bhow jdField_a_of_type_Bhow = new adtd(this);
  protected bisl a;
  public biso a;
  public TroopManager a;
  protected FaceDecoder a;
  public TroopInfo a;
  TroopMoreDetailView jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView;
  public TroopInfoData a;
  public QQCustomDialog a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  protected MyGridView a;
  protected QQBlurView a;
  public XListView a;
  protected ImmersiveTitleBar2 a;
  protected Runnable a;
  protected String a;
  public List<Integer> a;
  protected nwk a;
  protected nxu a;
  protected nxx a;
  protected boolean a;
  public View[] a;
  public int b;
  public Handler b;
  protected View.OnClickListener b;
  protected View b;
  protected Button b;
  public ImageView b;
  protected TextView b;
  aofu jdField_b_of_type_Aofu = new adsf(this);
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  protected Runnable b;
  public String b;
  protected ArrayList<TroopAppInfo> b;
  List<ImageView> jdField_b_of_type_JavaUtilList;
  public volatile boolean b;
  protected int c;
  protected View c;
  public TextView c;
  aofu jdField_c_of_type_Aofu = new adsg(this);
  protected String c;
  private ArrayList<Long> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  protected List<oidb_0x899.memberlist> c;
  public boolean c;
  protected int d;
  protected View d;
  public TextView d;
  private aofu d;
  protected String d;
  public List<Long> d;
  public boolean d;
  protected int e;
  public String e;
  public List<oidb_0x899.memberlist> e;
  public boolean e;
  protected int f;
  public String f;
  boolean f;
  protected int g;
  String g;
  public boolean g;
  protected int h;
  String h;
  protected boolean h;
  public int i;
  String i;
  protected boolean i;
  public int j;
  String j;
  public boolean j;
  public int k;
  String k;
  protected boolean k;
  protected int l;
  String l;
  public boolean l;
  private int m;
  protected boolean m;
  private String n;
  public boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v = true;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379610));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379611));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379612));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379613));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379614));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379615));
    jdField_m_of_type_JavaLangString = "https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi";
  }
  
  public ChatSettingForTroop()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_Int = 5;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_d_of_type_Aofu = new adri(this);
    this.jdField_m_of_type_Int = 2;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new adsi(this);
    this.jdField_a_of_type_JavaLangRunnable = new ChatSettingForTroop.18(this);
    this.jdField_a_of_type_Nxx = new adrx(this);
    this.jdField_b_of_type_JavaLangRunnable = new ChatSettingForTroop.28(this);
    this.jdField_l_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new adsd(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new adst(this);
    this.jdField_a_of_type_Nwk = new adta(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new mvl();
  }
  
  private void A()
  {
    b(getResources().getString(2131699082));
    if (((bfwu)this.app.getManager(QQManagerFactory.TROOP_HONOR_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      localObject1 = new FormSwitchItem(this, null);
      localObject2 = new FormSimpleItem(this, null);
      ((FormSimpleItem)localObject2).a(true);
      ((FormSimpleItem)localObject2).setBgType(1);
      ((FormSimpleItem)localObject2).setLeftText(getResources().getString(2131699035));
      ((FormSimpleItem)localObject2).setRightText(getResources().getString(2131699033));
      ((FormSimpleItem)localObject2).setContentDescription(getResources().getString(2131699035));
      ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167026));
      ((FormSimpleItem)localObject2).setFocusable(true);
      ((FormSimpleItem)localObject2).getBackground().setAlpha(255);
      this.jdField_a_of_type_ArrayOfAndroidViewView[32] = localObject2;
      ((FormSimpleItem)localObject2).setTag(Integer.valueOf(32));
      ((FormSimpleItem)localObject2).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      bhbu.a("Grp_set_new", "grpData_admin", "grpHonour_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      bdla.b(null, "dc00898", "", "", "0X800A6EE", "0X800A6EE", 0, 0, "", "", "", "");
    }
    Object localObject1 = View.inflate(this, 2131561590, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[49] = localObject1;
    a(49, 3, (View)localObject1, getString(2131699047), "", true);
    ((View)localObject1).setTag(Integer.valueOf(49));
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131363685);
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(8);
    }
    ((View)localObject1).setOnClickListener(this);
    if (this.jdField_f_of_type_Boolean)
    {
      bhbu.a("Grp_set_new", "grpData_admin", "Luckyword_entry_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      return;
      ((View)localObject1).setVisibility(8);
    }
  }
  
  private void B()
  {
    b(getResources().getString(2131699078));
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()))
    {
      localObject1 = new FormSimpleItem(this);
      a(1006, 1, (FormSimpleItem)localObject1, anvx.a(2131701261), "", true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      bhbu.a("Grp_edu", "Grp_data", "teachermsg_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
    }
    for (int i1 = 1;; i1 = 0)
    {
      localObject1 = new FormSimpleItem(this);
      Object localObject2;
      if (i1 != 0)
      {
        i1 = 2;
        a(1001, i1, (FormSimpleItem)localObject1, getString(2131695842), anvx.a(2131701226), true);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        bhbu.a("Grp_set_new", "grpData_admin", "chatRecord_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        localObject1 = new FormSwitchItem(this, null);
        ((FormSwitchItem)localObject1).setBgType(2);
        ((FormSwitchItem)localObject1).setText(getString(2131692964));
        ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167026));
        ((FormSwitchItem)localObject1).setFocusable(true);
        ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
        ((FormSwitchItem)localObject1).setContentDescription(getString(2131692964));
        this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
        localObject2 = ((FormSwitchItem)localObject1).a();
        if (!((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
          break label640;
        }
        ((Switch)localObject2).setChecked(true);
        label285:
        ((Switch)localObject2).setTag(Integer.valueOf(7));
        ((Switch)localObject2).setOnCheckedChangeListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        localObject1 = new FormSwitchItem(this, null);
        ((FormSwitchItem)localObject1).setBackgroundResource(2130839506);
        ((FormSwitchItem)localObject1).setBgType(2);
        ((FormSwitchItem)localObject1).setText(getString(2131692965));
        ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167026));
        ((FormSwitchItem)localObject1).setFocusable(true);
        ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
        ((FormSwitchItem)localObject1).setContentDescription(getString(2131692965));
        this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
        localObject2 = ((FormSwitchItem)localObject1).a();
        ((Switch)localObject2).setTag(Boolean.FALSE);
        i1 = this.app.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopmask = i1;
        }
        if (i1 == 1) {
          break label649;
        }
      }
      label640:
      label649:
      for (boolean bool = true;; bool = false)
      {
        ((Switch)localObject2).setChecked(bool);
        ((Switch)localObject2).setOnCheckedChangeListener(new adrm(this));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        localObject1 = View.inflate(this, 2131561587, null);
        localObject2 = (FormSimpleItem)((View)localObject1).findViewById(2131369195);
        a(9, 0, (FormSimpleItem)localObject2, getString(2131719505), "", true);
        this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.dp2px(17.0F, getResources()), AIOUtils.dp2px(17.0F, getResources()));
        localLayoutParams.rightMargin = AIOUtils.dp2px(30.0F, getResources());
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(15);
        ((FormSimpleItem)localObject2).addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839466));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ArrayOfAndroidViewView[9] = localObject1;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        return;
        i1 = 1;
        break;
        ((Switch)localObject2).setChecked(false);
        break label285;
      }
    }
  }
  
  private void C()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {}
    Object localObject;
    int i1;
    label136:
    boolean bool;
    label241:
    do
    {
      return;
      b(getResources().getString(2131699080));
      FormItemRelativeLayout localFormItemRelativeLayout = (FormItemRelativeLayout)View.inflate(this, 2131561590, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localFormItemRelativeLayout;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormItemRelativeLayout);
      a(localFormItemRelativeLayout, null);
      localFormItemRelativeLayout.setTag(Integer.valueOf(5));
      localFormItemRelativeLayout.setBGType(1);
      localFormItemRelativeLayout.setOnClickListener(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break;
      }
      localObject = anvx.a(2131701212);
      a(5, 3, localFormItemRelativeLayout, getString(2131719591), (CharSequence)localObject, true);
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (!this.jdField_b_of_type_Boolean)) {
        break label520;
      }
      i1 = 0;
      localFormItemRelativeLayout.setVisibility(i1);
      if (i1 == 0) {
        bhbu.a("Grp_set_new", "grpData_admin", "manageGrp_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
      TextView localTextView = (TextView)localFormItemRelativeLayout.findViewById(2131376668);
      localTextView.setText((CharSequence)localObject);
      b(localFormItemRelativeLayout);
      this.q = TroopUtils.isEmptyRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY" + this.app.getCurrentAccountUin());
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        break label526;
      }
      bool = false;
      this.p = TroopUtils.isShowKingTeamRedPoint(bool, "RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
      TroopUtils.updateRedPoint(TroopUtils.isUpdateBeforeSomeVersion(this, "8.0.5"), "RED_POINT_KEY_TROOP_ADMIN", this.p, this.q, localTextView);
      localObject = (TroopPluginManager)this.app.getManager(QQManagerFactory.TROOP_PLUGIN_MANAGER);
      if (localObject != null) {
        this.jdField_b_of_type_Boolean = ((TroopPluginManager)localObject).a("troop_manage_plugin.apk", new adrn(this));
      }
      if (!bghs.a(this.app)) {
        break label569;
      }
      this.jdField_a_of_type_Bgnx = new bgnx(this, getString(2131719689));
      this.jdField_a_of_type_Bgnx.a().setBackgroundResource(2130839503);
      localObject = this.jdField_a_of_type_Bgnx.a();
    } while (localObject == null);
    if (bghs.c(this.app)) {
      this.o = bghs.b(this.app);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "bShowRed red robot" + this.o);
      }
      this.jdField_a_of_type_Bgnx.a(this.o);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      ((View)localObject).setOnClickListener(this);
      ((View)localObject).setTag(Integer.valueOf(1009));
      bdla.b(this.app, "dc00898", "", "", "", "0X8009F9B", 0, 0, "", "", "", "");
      return;
      localObject = anvx.a(2131701219);
      break;
      label520:
      i1 = 8;
      break label136;
      label526:
      bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop();
      break label241;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
        this.o = bghs.b(this.app);
      } else {
        this.o = false;
      }
    }
    label569:
    QLog.i("Q.chatopttroop", 2, "RobotSwithOff");
  }
  
  private void D()
  {
    b(getResources().getString(2131699079));
    Object localObject = View.inflate(this, 2131561590, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[14] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).setTag(Integer.valueOf(14));
    a(14, 2, (View)localObject, getString(2131691754), "", true);
    f();
    b((View)localObject);
    localObject = View.inflate(this, 2131561590, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[25] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).setTag(Integer.valueOf(25));
    a(25, 2, (View)localObject, getString(2131699017), "", true);
    boolean bool;
    FormSimpleItem localFormSimpleItem;
    String str;
    if (!this.jdField_d_of_type_Boolean)
    {
      bool = true;
      a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop);
      b((View)localObject);
      if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
        bhbu.a("Grp_set_new", "grpData_admin", "search_upgrade_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
      localObject = View.inflate(this, 2131561590, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      a((View)localObject, null);
      a(4, 2, (View)localObject, getString(2131699049), "", true);
      ((View)localObject).setTag(Integer.valueOf(4));
      ((View)localObject).setOnClickListener(this);
      localFormSimpleItem = new FormSimpleItem(this);
      this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localFormSimpleItem;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormSimpleItem);
      str = getString(2131694214);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick)) {
        break label381;
      }
    }
    label381:
    for (localObject = getString(2131697320);; localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick)
    {
      a(6, 3, localFormSimpleItem, str, (CharSequence)localObject, true);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick))
      {
        localObject = new begq(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).a();
        localFormSimpleItem.setRightText((CharSequence)localObject);
        bhmb.a(this.app, localFormSimpleItem.a(), (Spannable)localObject);
      }
      return;
      bool = false;
      break;
    }
  }
  
  private void E()
  {
    View localView = View.inflate(this, 2131559912, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localView;
    localView.getBackground().setAlpha(255);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    localView.setVisibility(8);
  }
  
  private void F()
  {
    View localView = View.inflate(this, 2131561596, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localView;
    localView.setTag(Integer.valueOf(0));
    localView.setBackgroundResource(2130839506);
    localView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370841));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131701234) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + anvx.a(2131701242));
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, AIOUtils.dp2px(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), AIOUtils.dp2px(3.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), AIOUtils.dp2px(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()));
    }
    a(localView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)localView.findViewById(2131370839));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
    J();
    localView = View.inflate(this, 2131561603, null);
    localView.setBackgroundResource(2130850739);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    localView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
  }
  
  private void G()
  {
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[16];
    if ((localFormSimpleItem == null) || (localFormSimpleItem.getVisibility() != 0)) {}
    do
    {
      return;
      argl localargl = (argl)aqxe.a().a(535);
      if ((localargl == null) || (!localargl.jdField_a_of_type_Boolean)) {
        break;
      }
      localFormSimpleItem.setVisibility(0);
    } while (localFormSimpleItem.getVisibility() != 0);
    if (beki.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_RED_DOT_SHOW", true, false))
    {
      localFormSimpleItem.setRightIcon(getResources().getDrawable(2130841419));
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    localFormSimpleItem.setRightIcon(null);
  }
  
  private void H()
  {
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[38];
    if ((localFormSimpleItem == null) || (localFormSimpleItem.getVisibility() != 0)) {
      return;
    }
    Object localObject = ((argb)aqxe.a().a(551)).a(4);
    if ((localObject != null) && (((argc)localObject).jdField_b_of_type_Boolean))
    {
      localFormSimpleItem.setVisibility(0);
      if (!((bejv)this.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(4, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
        break label130;
      }
    }
    label130:
    for (localObject = "已开启";; localObject = "未开启")
    {
      localFormSimpleItem.setRightText((CharSequence)localObject);
      if (!beki.a(this.app, "SP_KEY_SING_TOGETHER_TROOP_RED_DOT_SHOW", true, false)) {
        break;
      }
      localFormSimpleItem.setRightIcon(getResources().getDrawable(2130841419));
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    localFormSimpleItem.setRightIcon(null);
  }
  
  private void I()
  {
    new QueryTask(new adro(this), new adrp(this)).a(null);
  }
  
  private void J()
  {
    int i1 = getResources().getDisplayMetrics().widthPixels;
    float f1 = getResources().getDisplayMetrics().density;
    int i2 = (int)(24.0F * f1);
    int i3 = (int)(20.0F * f1);
    int i4 = (int)(66.0F * f1);
    i1 = (i1 - i2) / ((int)(50.0F * f1) + i3);
    i2 = (int)(10.0F * f1);
    this.jdField_c_of_type_Int = i2;
    this.jdField_d_of_type_Int = i2;
    this.jdField_e_of_type_Int = ((int)(5.0F * f1));
    this.jdField_f_of_type_Int = ((int)(f1 * 17.0F));
    this.jdField_g_of_type_Int = i1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.jdField_c_of_type_Int, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int, this.jdField_f_of_type_Int);
  }
  
  private void K()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[26];
    if (localView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        break label116;
      }
      SpannableString localSpannableString = new SpannableString("[Avatar]");
      Drawable localDrawable = a();
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, ScreenUtil.dip2px(32.0F), ScreenUtil.dip2px(32.0F));
        localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, localSpannableString.length(), 17);
        a(localView, localSpannableString, null, null);
      }
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[35];
      if (localView != null) {
        ((ImageView)localView).setImageDrawable(a());
      }
      return;
      label116:
      a(localView, null, null, anvx.a(2131701255));
    }
  }
  
  private void L()
  {
    byte[] arrayOfByte = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (arrayOfByte != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        oidb_0xe83.RspBody localRspBody = new oidb_0xe83.RspBody();
        localRspBody.mergeFrom(arrayOfByte);
        a(localRspBody);
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData exception");
        return;
      }
    }
    QLog.d("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData==null");
  }
  
  private void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop quitTroop mTroopInfoData.bOwner = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner);
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject == null)
      {
        localObject = null;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label184;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) && (this.jdField_i_of_type_Int == 0)) {
        break label177;
      }
      N();
      label108:
      localObject = "2";
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label235;
      }
      localObject = "0";
    }
    for (;;)
    {
      bdla.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Clk_quitgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject, "", "");
      return;
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label177:
      O();
      break label108;
      label184:
      localObject = bkzi.a(this);
      ((bkzi)localObject).a(2131691049);
      ((bkzi)localObject).a(2131692031, 3);
      ((bkzi)localObject).a(new adrt(this, (bkzi)localObject));
      ((bkzi)localObject).d(getString(2131690697));
      ((bkzi)localObject).show();
      break label108;
      label235:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        localObject = "1";
      }
    }
  }
  
  private void N()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop showDisbandTroopAlertWindow");
    }
    ReportDialog localReportDialog = new ReportDialog(this, 2131755829);
    localReportDialog.setContentView(2131561082);
    ((TextView)localReportDialog.findViewById(2131365682)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365669);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365667);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365673);
    String str = anvx.a(2131701230);
    localTextView1.setText(getString(2131691044, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694399);
    localTextView3.setText(2131690697);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new adru(this, localReportDialog));
    localTextView3.setOnClickListener(new adrv(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void O()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop troopDisband");
    }
    getString(2131691717);
    String str = getString(2131691043);
    bkzi localbkzi = bkzi.a(this);
    localbkzi.a(str);
    localbkzi.a(getString(2131691042), 3);
    localbkzi.d(getString(2131690697));
    localbkzi.a(new adrw(this, localbkzi));
    localbkzi.show();
  }
  
  private void P()
  {
    aoep localaoep = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localaoep != null) {
      localaoep.a(anrb.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), true, 1);
    }
    this.jdField_a_of_type_Nxu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_Nxx);
  }
  
  private void Q()
  {
    aoep localaoep = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum <= 100) {
      localaoep.a(anrb.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 0L, 5, 100, 0);
    }
  }
  
  private void R()
  {
    Object localObject = (bacq)aqxe.a().a(701);
    int i1;
    if ((localObject != null) && (((bacq)localObject).b()) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isFansTroop()))
    {
      i1 = 1;
      if (i1 != 0)
      {
        localObject = View.inflate(this, 2131561603, null);
        ((View)localObject).setBackgroundResource(2130850739);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
        ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298536);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          localObject = View.inflate(this, 2131561590, null);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getFansTroopStarId() != 0) {
            break label178;
          }
          this.jdField_a_of_type_ArrayOfAndroidViewView[45] = localObject;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
          ((View)localObject).setTag(Integer.valueOf(45));
          e((View)localObject);
        }
      }
    }
    for (;;)
    {
      b((View)localObject);
      bdla.b(this.app, "dc00898", "", "", "0X800B595", "0X800B595", 0, 0, "", "", "", "");
      return;
      i1 = 0;
      break;
      label178:
      this.jdField_a_of_type_ArrayOfAndroidViewView[46] = localObject;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      ((View)localObject).setTag(Integer.valueOf(46));
      ((View)localObject).setVisibility(8);
      S();
    }
  }
  
  private void S()
  {
    bact localbact = ((awzf)this.app.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (localbact != null) {
      a(localbact.jdField_a_of_type_JavaLangString, localbact.jdField_a_of_type_Long);
    }
  }
  
  private void T()
  {
    Object localObject = (bacq)aqxe.a().a(701);
    if ((localObject == null) || (!((bacq)localObject).b())) {}
    View localView;
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isFansTroop()) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getFansTroopStarId() == 0)) {
          break;
        }
        localObject = (anrb)this.app.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      } while (localObject == null);
      ((anrb)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
      return;
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[45];
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[46];
    } while ((localObject == null) && (localView == null));
    if (localObject != null) {}
    for (;;)
    {
      e((View)localObject);
      return;
      localObject = localView;
    }
  }
  
  private void U()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {}
    do
    {
      return;
      localObject = (Boolean)this.jdField_a_of_type_Bhhi.c.get(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
    } while ((localObject != null) && (((Boolean)localObject).booleanValue()));
    bdla.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "0", "");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
    }
    for (;;)
    {
      bkzi localbkzi = (bkzi)bkzz.a(this, null);
      localbkzi.a(getString(2131719206, new Object[] { localObject }));
      localbkzi.a(getString(2131697397), false);
      localbkzi.a(getString(2131697393), false);
      localbkzi.a(getString(2131697389), false);
      int i1 = this.app.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
      switch (i1)
      {
      }
      for (;;)
      {
        localbkzi.c(2131690697);
        localbkzi.a(new adry(this, i1, localbkzi));
        localbkzi.show();
        return;
        continue;
        localbkzi.d(0);
        continue;
        localbkzi.d(1);
        continue;
        localbkzi.d(2);
      }
    }
  }
  
  private void V()
  {
    try
    {
      if (this.jdField_a_of_type_Bgua != null) {
        this.jdField_a_of_type_Bgua.e();
      }
      this.jdField_a_of_type_Bgua = new bgua(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.jdField_a_of_type_Bgua.f();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.d("Q.chatopttroop", 1, "gotoTroopQRCodeActivity NullPointerException ", localNullPointerException);
    }
  }
  
  private void W()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label24:
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  private void X()
  {
    W();
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 230).setTitle(getString(2131697378));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(getString(2131697377), new adsc(this));
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void Y()
  {
    bhbu.a("Grp_set_new", "grpData_admin", "clk_notice", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), "8.4.10" });
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (TextUtils.isEmpty(this.n)))
    {
      X();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Argu;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = argv.a();
      this.jdField_a_of_type_Argu = ((argu)localObject1);
    }
    localObject1 = ((argu)localObject1).jdField_a_of_type_JavaLangString;
    localObject2 = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", TroopUtils.replaceSpecialTag((String)localObject1, 0L, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app, true));
    ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
    ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivityForResult((Intent)localObject2, 17);
  }
  
  private void Z()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[14];
    if (localView != null)
    {
      localView.setOnTouchListener(null);
      localView.setOnClickListener(null);
    }
  }
  
  private Drawable a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = bheg.a();
    }
    return new BitmapDrawable((Bitmap)localObject2);
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131719607);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131719612);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131719614);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 4;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131719609);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 5;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131719608);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop()))
    {
      localObject = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (int i1 = 1;; i1 = 0)
    {
      ((aoep)localObject).b(str, paramInt, i1);
      localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[31];
      if (localObject != null) {
        ((FormSwitchItem)localObject).a().setClickable(false);
      }
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 1);
    localIntent.putExtra("param_is_troop_admin", paramBoolean);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131692403));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramActivity.getString(2131695798));
    localIntent.putExtra("param_max", 100);
    if (!paramBoolean) {
      localIntent.putExtra("filer_robot", true);
    }
    localIntent.putExtra("param_entrance", 38);
    paramActivity.startActivityForResult(localIntent, 1);
  }
  
  private static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363685);
    paramView = (TextView)paramView.findViewById(2131376668);
    if (TextUtils.isEmpty(paramCharSequence1)) {
      if (TextUtils.isEmpty(paramCharSequence3)) {
        paramView.setVisibility(8);
      }
    }
    while (TextUtils.isEmpty(paramCharSequence2))
    {
      localTextView.setVisibility(8);
      return;
      paramView.setVisibility(0);
      paramView.setText(paramCharSequence3);
      continue;
      paramView.setVisibility(0);
      paramView.setText(paramCharSequence1);
    }
    localTextView.setVisibility(0);
    localTextView.setText(paramCharSequence2);
  }
  
  private void a(View paramView, String paramString)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363685);
    paramView = (TextView)paramView.findViewById(2131376668);
    if (TextUtils.isEmpty(paramString))
    {
      localTextView.setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(getString(2131697379));
      return;
    }
    paramView.setVisibility(8);
    localTextView.setVisibility(0);
    localTextView.setText(paramString);
  }
  
  private void a(String paramString, long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[45];
    Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[46];
    if ((localObject1 == null) && (localObject2 == null)) {
      return;
    }
    if (localObject1 != null) {}
    TextView localTextView;
    for (;;)
    {
      localObject2 = (TextView)((View)localObject1).findViewById(2131363685);
      localTextView = (TextView)((View)localObject1).findViewById(2131376668);
      ((View)localObject1).setVisibility(0);
      ((TextView)localObject2).setVisibility(8);
      localTextView.setVisibility(0);
      TroopUtils.updateRedPoint(false, localTextView);
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      e((View)localObject1);
      return;
      localObject1 = localObject2;
    }
    localObject2 = getString(2131699087);
    if ((paramLong > 0L) && (paramLong <= 50L)) {
      localObject2 = String.format(getString(2131699070), new Object[] { Long.valueOf(paramLong) });
    }
    for (;;)
    {
      a(46, 3, (View)localObject1, paramString, "", true);
      localTextView.setText((CharSequence)localObject2);
      b((View)localObject1);
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "updateUinQREntry isShowUin = " + paramBoolean1 + ",showUinLockIcon = " + paramBoolean2);
    }
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[25];; localView = null)
    {
      Object localObject2;
      Object localObject1;
      if (localView != null)
      {
        localObject2 = "";
        localObject1 = localObject2;
        if (paramBoolean1)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin != null) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
            }
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label588;
        }
        localObject1 = " ";
      }
      label561:
      label583:
      label588:
      for (;;)
      {
        localView.setVisibility(0);
        int i1;
        if (paramBoolean1) {
          i1 = 2131699016;
        }
        for (;;)
        {
          a(25, 2, localView, getString(i1), "", true);
          localObject2 = new SpannableString((String)localObject1 + "PT[QR]");
          a(paramBoolean1, paramBoolean2, (String)localObject1, (SpannableString)localObject2);
          a(paramBoolean1, paramBoolean2, localView);
          Object localObject3 = getResources().getDrawable(2130843916);
          ((Drawable)localObject3).setBounds(0, 0, ScreenUtil.dip2px(18.0F), ScreenUtil.dip2px(18.0F));
          if (ThemeUtil.isInNightMode(this.app)) {
            ((Drawable)localObject3).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
          }
          localObject3 = new adsk(this, (Drawable)localObject3, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
          {
            QLog.e("vip_pretty.Q.chatopttroop", 1, "show the pretty troop icon :" + this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.groupFlagExt4);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.checkFlagExt4(1)) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.checkFreezeReason(2)))
            {
              i1 = 1;
              label334:
              if (i1 == 0) {
                break label561;
              }
              Drawable localDrawable = getResources().getDrawable(2130846944);
              localDrawable.setBounds(0, 0, ScreenUtil.dip2px(40.0F), ScreenUtil.dip2px(15.0F));
              ((SpannableString)localObject2).setSpan(new adsl(this, localDrawable, 0), ((String)localObject1).length(), ((String)localObject1).length() + 2, 17);
              ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length() + 2, ((String)localObject1).length() + 6, 17);
            }
          }
          for (;;)
          {
            paramBoolean1 = bool;
            if (!" ".equals(localObject1))
            {
              paramBoolean1 = bool;
              if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) {
                paramBoolean1 = true;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.chatopttroop", 2, "updateUinQREntry troopNameAndQr = " + localObject2);
            }
            TroopUtils.updateEntryItem(localView, (CharSequence)localObject2, null, null, paramBoolean1, (String)localObject1, anvx.a(2131691267), new adsm(this));
            localView.setOnClickListener(this);
            return;
            if (paramBoolean1) {
              break label583;
            }
            i1 = 2131699017;
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.checkFlagExt4(2))
            {
              i1 = 1;
              break label334;
              QLog.e("vip_pretty.Q.chatopttroop", 1, "not show the pretty troop icon");
            }
            i1 = 0;
            break label334;
            ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length(), ((SpannableString)localObject2).length(), 17);
          }
          i1 = 0;
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramView = (TextView)paramView.findViewById(2131376668);
      paramView.setOnClickListener(new adsn(this));
      paramView.setOnLongClickListener(new adso(this));
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, SpannableString paramSpannableString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "appendRoundBgAndLockIcon isShowUin = " + paramBoolean1 + ",showUinLockIcon = " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      bgog localbgog = new bgog(-1315339, -7894119, ViewUtils.dip2px(3.0F), ViewUtils.dip2px(21.0F), ViewUtils.dip2px(6.0F));
      localbgog.a(getResources().getDrawable(2130843923), ViewUtils.dip2px(16.0F), ViewUtils.dip2px(16.0F), ViewUtils.dip2px(4.0F));
      paramSpannableString.setSpan(localbgog, 0, paramString.length(), 33);
    }
  }
  
  private boolean a(long paramLong, TroopInfo paramTroopInfo)
  {
    if (paramLong == 101761547L)
    {
      awfq.b(this.app, getApplicationContext(), 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
      return true;
    }
    Object localObject;
    if (paramLong == 101847770L)
    {
      localObject = TroopMemberListActivity.a(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 19);
      ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", paramTroopInfo.wMemberNum);
      startActivity((Intent)localObject);
      return true;
    }
    if (paramLong == 101872203L)
    {
      if (nqi.a((BaseActivity)getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
        return true;
      }
      localObject = (ncz)this.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
      if (localObject != null) {
        ((ncz)localObject).a(getActivity(), 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
      }
      if ((localObject != null) && (((ncz)localObject).a())) {}
      for (int i1 = 1;; i1 = 2)
      {
        bdla.b(null, "dc00898", "", "", "0X800B4E3", "0X800B4E3", i1, 0, "", "", paramTroopInfo.troopuin, "");
        return true;
      }
    }
    return false;
  }
  
  private void aa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "showNotSearchableActionSheet");
    }
    bkzi localbkzi = (bkzi)bkzz.a(this, null);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    if (bool)
    {
      i1 = 2131692954;
      localbkzi.a(getString(i1));
      if (!bool) {
        break label115;
      }
    }
    label115:
    for (int i1 = 2131692951;; i1 = 2131692952)
    {
      localbkzi.b(i1);
      localbkzi.c(2131690697);
      localbkzi.a(new adsp(this, localbkzi));
      localbkzi.a(new adsq(this, localbkzi));
      if (!localbkzi.isShowing()) {
        localbkzi.show();
      }
      return;
      i1 = 2131692953;
      break;
    }
  }
  
  private void ab()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "gotoSettingOrShare ,isOwnerOrAdmin = " + bool);
    }
    if (bool)
    {
      Bundle localBundle = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
      localBundle.putInt("troop_type_ex", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt);
      localBundle.putString("leftViewText", getString(2131719629));
      localBundle.putInt("troop_auth_submit_time", this.jdField_i_of_type_Int);
      localBundle.putInt("PARAM_EXIT_ANIMATION", 1);
      localBundle.putBoolean(TroopInfoActivity.jdField_c_of_type_JavaLangString, true);
      TroopInfoActivity.a(this, localBundle);
      overridePendingTransition(2130771979, 2130771980);
      return;
    }
    V();
  }
  
  private void ac()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[33];
    if ((localView != null) && ((localView instanceof ExpandableTextView)))
    {
      localObject2 = TroopUtils.getDateString(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        localObject1 = (String)localObject2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      }
      ((ExpandableTextView)localView).setText(new QQText((CharSequence)localObject1, 11, 16));
    }
    Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[37];
    if ((localObject2 != null) && ((localObject2 instanceof TextView))) {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        break label156;
      }
    }
    label156:
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;; localObject1 = getString(2131695881))
    {
      ((TextView)localObject2).setText(new QQText((CharSequence)localObject1, 11, 16));
      return;
    }
  }
  
  private void ad()
  {
    p();
    ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, null);
  }
  
  private void ae()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.v) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if (!this.v) {
      this.v = true;
    }
    if ((this.v) || (bool)) {}
    for (int i1 = 2131167023;; i1 = 2131166723)
    {
      int i3 = getResources().getColor(i1);
      int i2 = 2130846734;
      i1 = i2;
      if (this.v)
      {
        i1 = i2;
        if (!bool) {
          i1 = 2130846731;
        }
      }
      Drawable localDrawable = getResources().getDrawable(2130850724);
      localDrawable.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i3);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i3);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i1);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(i3);
      e(this.v);
      return;
    }
  }
  
  private void af()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[12].findViewById(2131373858);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFlagExt4(3)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFreezeReason(2)))
    {
      localImageView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(8);
  }
  
  private void ag()
  {
    if ((this.jdField_a_of_type_ArrayOfAndroidViewView == null) || (this.jdField_a_of_type_ArrayOfAndroidViewView.length <= 0)) {}
    for (;;)
    {
      return;
      View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
      if (localView != null)
      {
        Object localObject1 = null;
        int i1 = 0;
        while (i1 <= 7)
        {
          switch (i1)
          {
          default: 
            if ((localObject1 == null) || (((View)localObject1).getVisibility() != 0)) {
              break label382;
            }
            Object localObject2 = ((View)localObject1).getTag();
            if ((localObject2 == null) || (!(localObject2 instanceof oidb_0xe83.AppInfo))) {
              break label382;
            }
            localObject2 = (oidb_0xe83.AppInfo)localObject2;
            long l1 = -1000L;
            int i2 = -1000;
            if (((oidb_0xe83.AppInfo)localObject2).push_red_point.has()) {
              i2 = ((oidb_0xe83.AppInfo)localObject2).push_red_point.get();
            }
            if (((oidb_0xe83.AppInfo)localObject2).appid.has()) {
              l1 = ((oidb_0xe83.AppInfo)localObject2).appid.get();
            }
            if (l1 != 1L) {
              break label382;
            }
            boolean bool = bhdf.a(this.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
            if ((i2 != -1) && (!bool)) {
              break;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            localObject1 = (TextView)((View)localObject1).findViewById(2131362866);
            if (i1 == 0) {
              break label374;
            }
            ((TextView)localObject1).setVisibility(0);
            ((TextView)localObject1).setText("");
            ((TextView)localObject1).setBackgroundResource(0);
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130850427, 0, 0, 0);
            return;
            localObject1 = localView.findViewById(2131379399);
            break;
            localObject1 = localView.findViewById(2131379400);
            break;
            localObject1 = localView.findViewById(2131379401);
            break;
            localObject1 = localView.findViewById(2131379402);
            break;
            localObject1 = localView.findViewById(2131379403);
            break;
            localObject1 = localView.findViewById(2131379404);
            break;
            localObject1 = localView.findViewById(2131379405);
            break;
            localObject1 = localView.findViewById(2131379406);
            break;
          }
          label374:
          ((TextView)localObject1).setVisibility(8);
          return;
          label382:
          i1 += 1;
        }
      }
    }
  }
  
  private void ah()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) && (getIntent().getBooleanExtra("from_newer_guide", false)))
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    Intent localIntent2 = this.jdField_a_of_type_AndroidContentIntent;
    Intent localIntent1 = localIntent2;
    if (this.u)
    {
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      this.u = false;
    }
    setResult(-1, localIntent1);
  }
  
  private void ai()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[47];
    if (localFormSwitchItem == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null);
      bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopGameCardEnabled();
      localFormSwitchItem.setChecked(bool);
      localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[48];
    } while (localFormSwitchItem == null);
    if (bool)
    {
      localFormSwitchItem.setVisibility(0);
      aj();
      return;
    }
    localFormSwitchItem.setVisibility(8);
  }
  
  private void aj()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[48];
    if (localFormSwitchItem == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
      return;
    }
    localFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isShowMyGameCardEnabled());
  }
  
  private void ak()
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if (!localSharedPreferences.getBoolean("Change_Game_Card_Switch_Tips_Value", false))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this, 230, getString(2131697151), getString(2131697150), 2131690697, 2131697149, new adsw(this), null);
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new adsx(this));
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      localSharedPreferences.edit().putBoolean("Change_Game_Card_Switch_Tips_Value", true).apply();
    }
  }
  
  private void al()
  {
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {}
    View localView;
    do
    {
      do
      {
        return;
        i1 = -1;
        if (this.jdField_d_of_type_JavaLangString.equals("wangzhe"))
        {
          bhbu.a("Grp_AIO", "AIO_clk", "game_on_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          i1 = 48;
        }
      } while ((i1 < 0) || (i1 >= 50));
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[i1];
    } while ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (localView == null) || (localView.getVisibility() != 0));
    int i1 = localView.getTop();
    int i2 = localView.getHeight();
    this.jdField_a_of_type_ComTencentWidgetXListView.smoothScrollBy(i1 - i2, 1000);
  }
  
  private void am()
  {
    boolean bool = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[7];
    if (localObject != null)
    {
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
    }
  }
  
  private void an()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop()))
    {
      FormSwitchItem localFormSwitchItem = new FormSwitchItem(this, null);
      localFormSwitchItem.setText(getString(2131692963));
      localFormSwitchItem.a().setTextColor(getResources().getColor(2131167026));
      localFormSwitchItem.setFocusable(true);
      localFormSwitchItem.getBackground().setAlpha(255);
      localFormSwitchItem.setContentDescription(getString(2131692963));
      this.jdField_a_of_type_ArrayOfAndroidViewView[31] = localFormSwitchItem;
      localFormSwitchItem.a().setTag(Integer.valueOf(31));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormSwitchItem);
      ao();
    }
  }
  
  private void ao()
  {
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[31];
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (localObject != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.showGameSwitchStatus != 1) {
        break label82;
      }
      ((FormSwitchItem)localObject).setVisibility(0);
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.gameSwitchStatus != 1) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
      ((Switch)localObject).setClickable(true);
      return;
    }
    label82:
    ((FormSwitchItem)localObject).setVisibility(8);
  }
  
  private void ap()
  {
    Object localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    long l1;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
      l1 = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        l1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cmdUinFlagEx2;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("mTroopInfo.mask=");
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
          break label173;
        }
      }
    }
    label173:
    for (localObject = "no troopInfo";; localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cmdUinFlagEx2 + "")
    {
      QLog.d("Q.chatopttroop", 2, (String)localObject);
      boolean bool = TroopInfo.isCmdUinFlagEx2Open(l1, 512);
      localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[10];
      if (localObject != null)
      {
        localObject = ((FormSwitchItem)localObject).a();
        ((Switch)localObject).setOnCheckedChangeListener(null);
        ((Switch)localObject).setChecked(bool);
        aq();
        ((Switch)localObject).setOnCheckedChangeListener(this);
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      break;
    }
  }
  
  private void aq()
  {
    int i2 = 0;
    boolean bool1 = ((FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[10]).a();
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[8];
    if (!bool1)
    {
      i1 = 0;
      ((View)localObject).setVisibility(i1);
      if (!bool1) {
        bhbu.a("Grp_set_new", "grpData_admin", "Grp_msg_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && ((localObject instanceof FormSwitchItem)))
      {
        boolean bool2 = ((FormSwitchItem)localObject).a();
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        if ((bool1) || (bool2)) {
          break label124;
        }
      }
    }
    label124:
    for (int i1 = i2;; i1 = 8)
    {
      ((FormSimpleItem)localObject).setVisibility(i1);
      return;
      i1 = 8;
      break;
    }
  }
  
  private void ar()
  {
    boolean bool = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[19];
    if (localFormSwitchItem != null)
    {
      Switch localSwitch = localFormSwitchItem.a();
      localSwitch.setOnCheckedChangeListener(null);
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      localFormSwitchItem.setContentDescription(getString(2131695946));
    }
  }
  
  private void as()
  {
    int i2 = 0;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    f();
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
    if ((bool) && (this.jdField_b_of_type_Boolean)) {}
    for (int i1 = 0;; i1 = 8)
    {
      if (localObject != null) {
        ((View)localObject).setVisibility(i1);
      }
      localObject = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if (localObject != null)
      {
        if (i1 == 0) {
          i2 = 3;
        }
        ((FormSimpleItem)localObject).setBgType(i2);
      }
      return;
    }
  }
  
  private void at()
  {
    Object localObject = (bfck)aqxe.a().a(686);
    if ((localObject != null) && (((bfck)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData)))
    {
      localObject = View.inflate(this, 2131561603, null);
      ((View)localObject).setBackgroundResource(2130850739);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298536);
      localObject = View.inflate(this, 2131561590, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[43] = localObject;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      int i1 = 0;
      TroopManager localTroopManager = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localTroopManager != null) {
        i1 = localTroopManager.k(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      localObject = (TextView)((View)localObject).findViewById(2131376668);
      TroopUtils.updateRedPoint(TroopUtils.isEmptyRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION"), (TextView)localObject);
      e(i1);
    }
  }
  
  private void b(int paramInt)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_Biso == null) {
        this.jdField_a_of_type_Biso = new biso(this);
      }
      this.jdField_a_of_type_Biso.b(2, 2131694255, 1500);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
      return;
    }
    this.jdField_a_of_type_Bhhi.b.clear();
    this.app.setTroopMsgFilterToServer(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Bhhi.c.put(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, Boolean.valueOf(true));
    if (!this.r)
    {
      SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      if (!localSharedPreferences.getBoolean("Change_Msg_Notify_Tips_Value", false))
      {
        this.r = true;
        localSharedPreferences.edit().putBoolean("Change_Msg_Notify_Tips_Value", true).commit();
        bhdj.a(this, getString(2131697388), 2131718822, 2131718822, new bhdx(), null).show();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
    bdla.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
  }
  
  private void b(String paramString)
  {
    TextView localTextView = new TextView(this);
    localTextView.setFocusable(true);
    localTextView.setText(paramString);
    localTextView.setPadding(ViewUtils.dip2px(16.0F), 0, ViewUtils.dip2px(16.0F), 0);
    localTextView.setTextAppearance(this, 2131755986);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.topMargin = ViewUtils.dpToPx(14.0F);
    paramString.bottomMargin = ViewUtils.dpToPx(4.0F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView, paramString);
  }
  
  private boolean b()
  {
    byte[] arrayOfByte = ((awzf)this.app.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (arrayOfByte != null) {
      try
      {
        oidb_0xe83.RspBody localRspBody = new oidb_0xe83.RspBody();
        localRspBody.mergeFrom(arrayOfByte);
        a(localRspBody);
        return true;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData exception");
        }
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData==null");
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null) {
        break label57;
      }
    }
    label57:
    for (Object localObject = null;; localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && ((paramInt & 0x1) > 0)) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cGroupOption);
      }
      return;
    }
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363875);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363792));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377567));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)paramView.findViewById(2131363699));
    this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new adrj(this));
  }
  
  private void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)
    {
      ad();
      return;
    }
    d(paramString);
  }
  
  private void c(List<oidb_0x899.memberlist> paramList)
  {
    aoep localaoep = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    ArrayList localArrayList1 = new ArrayList();
    bgls localbgls = (bgls)this.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      localObject = (oidb_0x899.memberlist)localIterator.next();
      String str = String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))) {
        paramList = (List<oidb_0x899.memberlist>)localObject;
      } else if (localbgls.b(str)) {
        localArrayList1.add(localObject);
      } else if (TroopUtils.isTroopAdmin(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str)) {
        localArrayList2.add(localObject);
      } else {
        localArrayList3.add(localObject);
      }
    }
    this.jdField_e_of_type_JavaUtilList = new ArrayList();
    Object localObject = paramList;
    if (paramList == null) {}
    try
    {
      localObject = new oidb_0x899.memberlist();
      ((oidb_0x899.memberlist)localObject).uint64_member_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin));
      this.jdField_e_of_type_JavaUtilList.add(0, localObject);
    }
    catch (NumberFormatException paramList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, paramList.toString());
        }
      }
      localObject = TroopUtils.saveMemberUinStringToDB(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramList);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label430;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.memberListToShow = ((String)localObject);
      a(this.jdField_e_of_type_JavaUtilList);
      localaoep.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramList, true, null);
    }
    this.jdField_e_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_e_of_type_JavaUtilList.addAll(localArrayList3);
    this.jdField_e_of_type_JavaUtilList.addAll(localArrayList1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "handle0X899_0,memberListForCard.size = " + this.jdField_e_of_type_JavaUtilList.size());
    }
    paramList = new ArrayList();
    localObject = this.jdField_e_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject).next()).uint64_member_uin.get()));
    }
    label430:
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))) {}
    label391:
    label524:
    for (;;)
    {
      return;
      Object localObject = (bgft)aqxe.a().a(695);
      int i1;
      label79:
      Switch localSwitch;
      if ((localObject != null) && (((bgft)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin)))
      {
        i1 = 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()) || (i1 == 0) || (bdvn.a())) {
          break label472;
        }
        i1 = 1;
        if (i1 != 0)
        {
          boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopGameCardEnabled();
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isOwnerOrAdmin(this.app.getCurrentAccountUin()))
          {
            localObject = new FormSwitchItem(this, null);
            ((FormSwitchItem)localObject).setBackgroundResource(2130839506);
            ((FormSwitchItem)localObject).setBgType(2);
            ((FormSwitchItem)localObject).setText(getString(2131697146));
            ((FormSwitchItem)localObject).a().setTextColor(getResources().getColorStateList(2131167026));
            ((FormSwitchItem)localObject).setFocusable(true);
            ((FormSwitchItem)localObject).getBackground().setAlpha(255);
            ((FormSwitchItem)localObject).setContentDescription(getString(2131697146));
            this.jdField_a_of_type_ArrayOfAndroidViewView[47] = localObject;
            localSwitch = ((FormSwitchItem)localObject).a();
            localSwitch.setTag(Integer.valueOf(47));
            if (!bool) {
              break label477;
            }
            localSwitch.setChecked(true);
            label228:
            localSwitch.setOnCheckedChangeListener(this);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
            bhbu.a("Grp_set_new", "grpData_admin", "game_switch", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          }
          localObject = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject).setBackgroundResource(2130839506);
          ((FormSwitchItem)localObject).setText(getString(2131697147));
          ((FormSwitchItem)localObject).a().setTextColor(getResources().getColorStateList(2131167026));
          ((FormSwitchItem)localObject).setFocusable(true);
          ((FormSwitchItem)localObject).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject).setContentDescription(getString(2131697147));
          this.jdField_a_of_type_ArrayOfAndroidViewView[48] = localObject;
          localSwitch = ((FormSwitchItem)localObject).a();
          localSwitch.setTag(Integer.valueOf(48));
          if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.shouldShowMyGameCard()) {
            break label486;
          }
          localSwitch.setChecked(true);
          localSwitch.setOnCheckedChangeListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
          if (bool) {
            break label495;
          }
          ((FormSwitchItem)localObject).setVisibility(8);
        }
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label524;
        }
        localObject = View.inflate(this, 2131561603, null);
        ((View)localObject).setBackgroundResource(2130850739);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
        ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
        return;
        i1 = 0;
        break;
        label472:
        i1 = 0;
        break label79;
        label477:
        localSwitch.setChecked(false);
        break label228;
        label486:
        localSwitch.setChecked(false);
        break label391;
        label495:
        bhbu.a("Grp_manage_new", "game", "game_switch", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
    }
  }
  
  private boolean c()
  {
    boolean bool4 = true;
    boolean bool2 = false;
    boolean bool1 = bool2;
    boolean bool5;
    boolean bool6;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
            break label221;
          }
          bool1 = true;
          bool5 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopPicListJson);
          bool6 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt > 0L) {
            break label226;
          }
          bool2 = true;
          label85:
          if (!TroopUtils.isTroopTagNeedRedDot(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)) {
            break label231;
          }
          bool3 = bool4;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags != null) {
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags.isEmpty()) {
              break label231;
            }
          }
        }
      }
    }
    label221:
    label226:
    label231:
    for (boolean bool3 = bool4;; bool3 = false)
    {
      bool4 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
      bool1 = TroopUtils.isTroopEditInfoRedExist(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, new boolean[] { bool1, bool5, bool6, bool2, bool3, bool4 }, new int[] { 11, 12, 5, 4, 8, 6 });
      return bool1;
      bool1 = false;
      break;
      bool2 = false;
      break label85;
    }
  }
  
  private void d(int paramInt)
  {
    this.jdField_m_of_type_Int = paramInt;
    bghd.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  private void d(View paramView)
  {
    Object localObject = View.inflate(this, 2131560711, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject;
    af();
    this.jdField_b_of_type_AndroidViewView.measure(0, 0);
    localObject = View.inflate(this, 2131561603, null);
    ((View)localObject).setBackgroundResource(2130850739);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
    localObject = View.inflate(this, 2131561600, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[23] = localObject;
    ((View)localObject).setTag(Integer.valueOf(23));
    ((View)localObject).setOnClickListener(this);
    ((View)localObject).setContentDescription(anvx.a(2131701224));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    paramView.findViewById(2131379499).setVisibility(8);
    boolean bool = bhdf.b(this.app.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
    paramView = (TextView)((View)localObject).findViewById(2131376668);
    if (paramView != null) {
      TroopUtils.updateRedPoint(bool, paramView);
    }
    paramView = ((View)localObject).findViewById(2131368063);
    paramView.setTag(Integer.valueOf(35));
    paramView.setContentDescription(getResources().getString(2131699009));
    if (bdfk.b()) {
      paramView.setBackground(null);
    }
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(false);
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[35] = paramView;
    K();
    paramView = ((View)localObject).findViewById(2131379564);
    paramView.setTag(Integer.valueOf(36));
    this.jdField_a_of_type_ArrayOfAndroidViewView[36] = paramView;
    f();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      localObject = ((View)localObject).findViewById(2131378200);
      ((TextView)localObject).setText(new QQText(paramView, 11, 16));
      this.jdField_a_of_type_ArrayOfAndroidViewView[37] = localObject;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        ((View)localObject).setVisibility(8);
      }
      e();
      R();
      paramView = (bfck)aqxe.a().a(686);
      if ((paramView != null) && (paramView.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData)))
      {
        paramView = View.inflate(this, 2131561603, null);
        paramView.setBackgroundResource(2130850739);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
        paramView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298536);
        paramView = View.inflate(this, 2131561590, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[43] = paramView;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
        localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject == null) {
          break label572;
        }
      }
    }
    label572:
    for (int i1 = ((TroopManager)localObject).k(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);; i1 = 0)
    {
      paramView = (TextView)paramView.findViewById(2131376668);
      TroopUtils.updateRedPoint(TroopUtils.isEmptyRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION"), paramView);
      e(i1);
      paramView = View.inflate(this, 2131561603, null);
      paramView.setBackgroundResource(2130850739);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
      paramView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
      return;
      paramView = getString(2131695881);
      break;
    }
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 2)) {
        i1 = 18;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramString));
        return;
      }
      paramString = AddFriendLogicActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramString);
      paramString.putExtra("from_newer_guide", getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 10);
      return;
    }
    a(2131719621, 0);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 3)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 30) {}
    for (Intent localIntent = new Intent(this, ChatActivity.class);; localIntent = new Intent(this, SplashActivity.class))
    {
      localIntent = AIOUtils.setOpenAIOIntent(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
      if ((paramBoolean) && (this.jdField_k_of_type_Boolean))
      {
        localIntent.putExtra("fromThirdAppByOpenSDK", true);
        localIntent.putExtra("appid", getIntent().getExtras().getString("appid"));
        localIntent.putExtra("pkg_name", getIntent().getExtras().getString("pkg_name"));
        localIntent.putExtra("app_name", getIntent().getExtras().getString("app_name"));
        localIntent.putExtra("action", getIntent().getExtras().getInt("pkg_name"));
      }
      startActivity(localIntent);
      return;
    }
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, String.format("count = %s", new Object[] { Integer.valueOf(paramInt) }));
    }
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[43];
    if (localView == null) {
      return;
    }
    if (paramInt > 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        bdla.b(this.app, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800B4AD", "0X800B4AD", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt), "", "", "");
      }
      String str = getResources().getString(2131699006) + String.valueOf(paramInt) + getResources().getString(2131699007);
      a(43, 2, localView, getResources().getString(2131699008), " ", true);
      TextView localTextView1 = (TextView)localView.findViewById(2131363685);
      TextView localTextView2 = (TextView)localView.findViewById(2131376668);
      if (localTextView1 != null) {
        localTextView1.setVisibility(8);
      }
      if (localTextView2 != null) {
        localTextView2.setText(str);
      }
      localView.setTag(Integer.valueOf(43));
      localView.setOnClickListener(this);
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void e(View paramView)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131363685);
    TextView localTextView2 = (TextView)paramView.findViewById(2131376668);
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(0);
    localTextView2.setText(getString(2131699086));
    a(45, 3, paramView, getString(2131699088), "", true);
    TroopUtils.updateRedPoint(TroopUtils.isEmptyRedPointSP("RED_POINT_KEY_TROOP_IDOL_RANK" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), localTextView2);
  }
  
  private void e(String paramString)
  {
    runOnUiThread(new ChatSettingForTroop.62(this, paramString));
  }
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    ImmersiveUtils.a(false, getWindow());
    bdfk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {}
    while (paramBoolean == this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopGameCardEnabled()) {
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(this, 2131695928, 0).b(getTitleBarHeight());
      ai();
      return;
    }
    if (paramBoolean) {
      ak();
    }
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[48];
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ((FormSwitchItem)localObject).setVisibility(0);
        aj();
      }
    }
    else
    {
      localObject = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (localObject != null) {
        ((aoep)localObject).h(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramBoolean);
      }
      if (!paramBoolean) {
        break label159;
      }
    }
    label159:
    for (localObject = "game_switch_on";; localObject = "game_switch_off")
    {
      bhbu.a("Grp_set_new", "grpData_admin", (String)localObject, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      return;
      ((FormSwitchItem)localObject).setVisibility(8);
      break;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isShowMyGameCardEnabled() == paramBoolean) {
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(this, 2131695928, 0).b(getTitleBarHeight());
      aj();
      return;
    }
    Object localObject = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localObject != null) {
      ((aoep)localObject).i(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramBoolean);
    }
    if (paramBoolean) {}
    for (localObject = "game_switch_on";; localObject = "game_switch_off")
    {
      bhbu.a("Grp_manage_new", "game", (String)localObject, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      return;
    }
  }
  
  private void h(boolean paramBoolean)
  {
    anrb localanrb = (anrb)this.app.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
      if (!paramBoolean) {
        break label146;
      }
      i1 = 0;
      label46:
      if (!localanrb.a(str, i1)) {
        break label158;
      }
      if (!paramBoolean) {
        break label151;
      }
    }
    label146:
    label151:
    for (String str = "open_stick";; str = "close_stick")
    {
      bdla.b(this.app, "dc00899", "Grp_set", "", "Grp_data", str, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      bhbu.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode;
      break;
      i1 = 1;
      break label46;
    }
    label158:
    am();
  }
  
  private void i(boolean paramBoolean)
  {
    int i2 = 1;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131692125, 1);
      ap();
      return;
    }
    if (paramBoolean) {
      aome.a(this.app).a(this);
    }
    label123:
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      i1 = 1;
      int i3 = (int)NetConnInfoCenter.getServerTime();
      ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, this.app.getCurrentUin(), i1, 512, i3);
      aq();
      if (!paramBoolean) {
        break label171;
      }
      bhbu.a("Grp_set_new", "grpData_admin", "hideMessage_open", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      localQQAppInterface = this.app;
      if (!paramBoolean) {
        break label202;
      }
    }
    label171:
    label202:
    for (int i1 = i2;; i1 = 2)
    {
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X800A348", "0X800A348", 2, i1, "0", "0", "", "");
      return;
      i1 = 0;
      break;
      bhbu.a("Grp_set_new", "grpData_admin", "hideMessage_close", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      break label123;
    }
  }
  
  private void j(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.getSystemNetwork(this) == 0)
    {
      QQToast.a(this, 2131695928, 0).b(getTitleBarHeight());
      ar();
      return;
    }
    ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramBoolean, false);
    if (paramBoolean)
    {
      bdla.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      if (!paramBoolean) {
        break label200;
      }
    }
    label200:
    for (String str = "showGrp_open";; str = "showGrp_close")
    {
      bhbu.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      bdla.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      break;
    }
  }
  
  private void k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (bfck)aqxe.a().a(686);
      } while ((localObject == null) || (!((bfck)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData)));
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasTroopAssociation()) && (!paramBoolean)) {
        break;
      }
      localObject = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while (localObject == null);
    ((aoep)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 3, "");
    return;
    e(0);
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_ArrayOfAndroidViewView == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[49];
    } while (localObject == null);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131376668);
    TroopUtils.updateRedPoint(bhdf.b(this.app.getCurrentAccountUin()), localTextView);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFlagExt4 & 0x8000) == 0) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      localTextView.setText(getResources().getString(2131697305));
      return;
    }
    localTextView.setText("");
    long l1 = 0L;
    Object localObject = bhdf.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, getString(2131697307));
    if ((localObject != null) && (localObject.length == 2)) {
      l1 = ((Long)localObject[0]).longValue();
    }
    for (localObject = (String)localObject[1];; localObject = "")
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(new Date());
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      aoep localaoep = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (((String)localObject).equals(anvx.a(2131697307)))
      {
        localaoep.B(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        return;
      }
      if (l1 > localCalendar.getTimeInMillis())
      {
        localTextView.setText((CharSequence)localObject);
        return;
      }
      localaoep.B(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      return;
    }
  }
  
  private void w()
  {
    TextView localTextView = new TextView(this);
    localTextView.setOnClickListener(new adrk(this));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localTextView.setGravity(1);
    if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
      localTextView.setAlpha(0.5F);
    }
    localTextView.setTextColor(Color.parseColor("#4799DF"));
    localTextView.setTextSize(1, 14.0F);
    localTextView.setText(2131719622);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = ViewUtils.dpToPx(15.0F);
    localLayoutParams.bottomMargin = ViewUtils.dpToPx(24.0F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView, localLayoutParams);
    bhbu.a("Grp_set_new", "grpData_admin", "tipoff_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
  }
  
  private void x()
  {
    Object localObject = View.inflate(this, 2131561601, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    localObject = (Button)((View)localObject).findViewById(2131365490);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
      ((Button)localObject).setText(2131691718);
    }
    for (;;)
    {
      ((Button)localObject).setOnClickListener(new adrl(this));
      return;
      ((Button)localObject).setText(2131716593);
    }
  }
  
  private void y()
  {
    Object localObject = View.inflate(this, 2131561583, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[27] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    a(27, 0, (View)localObject, getString(2131695843), null, false);
    ((View)localObject).setTag(Integer.valueOf(27));
    ((View)localObject).setOnClickListener(this);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131379001);
    if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
      localTextView.setAlpha(0.5F);
    }
    localTextView.setTextColor(Color.parseColor("#4799DF"));
    localObject = (TextView)((View)localObject).findViewById(2131368819);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  private void z()
  {
    b(getResources().getString(2131699081));
    Object localObject = new FormSimpleItem(this);
    this.jdField_a_of_type_ArrayOfAndroidViewView[17] = localObject;
    a(17, 1, (FormSimpleItem)localObject, anvx.a(2131701246), "", true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    bhbu.a("Grp_set_new", "grpData_admin", "chatBG_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
    if (!this.jdField_d_of_type_Boolean)
    {
      localObject = new FormSimpleItem(this);
      this.jdField_a_of_type_ArrayOfAndroidViewView[18] = localObject;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      a(18, 2, (FormSimpleItem)localObject, getString(2131719535), "", true);
      ((FormSimpleItem)localObject).setVisibility(8);
      localObject = (bfkw)this.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "initUI  effectManager.isAllTroopShowEnterance() = " + ((bfkw)localObject).b());
      }
      if (((bfkw)localObject).b()) {
        a(true);
      }
    }
    c(false);
    localObject = new FormSimpleItem(this);
    a(1010, 2, (FormSimpleItem)localObject, getString(2131694345), getString(2131718561), true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localObject);
    bhbu.a("Grp_set_new", "grpData_admin", "grpNotice_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
    if (bhsv.a())
    {
      localObject = new FormSimpleItem(this);
      this.jdField_a_of_type_ArrayOfAndroidViewView[40] = localObject;
      a(40, 2, (FormSimpleItem)localObject, getString(2131699045), "", true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    }
    localObject = new FormSwitchItem(this, null);
    ((FormSwitchItem)localObject).setBackgroundResource(2130839503);
    ((FormSwitchItem)localObject).setText(getString(2131696085));
    ((FormSwitchItem)localObject).a().setTextColor(getResources().getColorStateList(2131167026));
    ((FormSwitchItem)localObject).setFocusable(true);
    ((FormSwitchItem)localObject).getBackground().setAlpha(255);
    ((FormSwitchItem)localObject).setContentDescription(getString(2131696085));
    this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject;
    ((FormSwitchItem)localObject).a().setTag(Integer.valueOf(10));
    ap();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    bhbu.a("Grp_set_new", "grpData_admin", "hideMessage_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
    localObject = View.inflate(this, 2131561603, null);
    ((View)localObject).setBackgroundResource(2130850739);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
  }
  
  @SuppressLint({"NewApi"})
  protected void a()
  {
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      try
      {
        View localView = View.inflate(this, 2131562985, null);
        this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131365022));
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView.findViewById(2131379099));
        this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
        this.jdField_a_of_type_ArrayOfAndroidViewView = new View[50];
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
        Object localObject1 = new AbsListView.LayoutParams(-1, -2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        localObject1 = new blha(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
        this.jdField_d_of_type_Boolean = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "mIsQidianPrivateTroop : " + this.jdField_d_of_type_Boolean + ", troopUin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        super.setContentView(localView);
        this.jdField_d_of_type_AndroidViewView = localView;
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130838911);
        this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131379078);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131379020));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131690785));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369278));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690785));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369231));
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131694466) + getString(2131690673));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369245));
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131693259));
        bhbu.a("Grp_set_new", "grpData_admin", "share_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this, this.app);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
        localObject1 = View.inflate(this, 2131560711, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject1;
        af();
        this.jdField_b_of_type_AndroidViewView.measure(0, 0);
        localObject1 = View.inflate(this, 2131561603, null);
        ((View)localObject1).setBackgroundResource(2130850739);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        ((View)localObject1).getLayoutParams().height = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
        localObject2 = View.inflate(this, 2131561600, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[23] = localObject2;
        ((View)localObject2).setTag(Integer.valueOf(23));
        ((View)localObject2).setOnClickListener(this);
        ((View)localObject2).setContentDescription(anvx.a(2131701224));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        localView.findViewById(2131379499).setVisibility(8);
        localObject1 = ((View)localObject2).findViewById(2131368063);
        ((View)localObject1).setTag(Integer.valueOf(35));
        ((View)localObject1).setContentDescription(getResources().getString(2131699009));
        if (bdfk.b()) {
          ((View)localObject1).setBackground(null);
        }
        if ((localObject1 instanceof ThemeImageView)) {
          ((ThemeImageView)localObject1).setSupportMaskView(false);
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[35] = localObject1;
        K();
        localObject1 = ((View)localObject2).findViewById(2131379564);
        ((View)localObject1).setTag(Integer.valueOf(36));
        this.jdField_a_of_type_ArrayOfAndroidViewView[36] = localObject1;
        f();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
          localObject3 = ((View)localObject2).findViewById(2131378200);
          ((TextView)localObject3).setText(new QQText((CharSequence)localObject1, 11, 16));
          this.jdField_a_of_type_ArrayOfAndroidViewView[37] = localObject3;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
            ((View)localObject3).setVisibility(8);
          }
          bool = bhdf.b(this.app.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
          localObject1 = (TextView)((View)localObject2).findViewById(2131376668);
          if (localObject1 != null) {
            TroopUtils.updateRedPoint(bool, (TextView)localObject1);
          }
          e();
          R();
          at();
          localObject1 = (beuq)aqxe.a().a(664);
          if ((localObject1 == null) || (!((beuq)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
            break label5354;
          }
          i1 = 1;
          localObject1 = View.inflate(this, 2131561603, null);
          ((View)localObject1).setBackgroundResource(2130850739);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
          localObject1 = View.inflate(this, 2131561596, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject1;
          ((View)localObject1).setTag(Integer.valueOf(0));
          if (i1 == 0) {
            break label5190;
          }
          ((View)localObject1).setBackgroundResource(2130839506);
          ((View)localObject1).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370841));
          this.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131701234) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + anvx.a(2131701242));
          if (AppSetting.jdField_c_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, AIOUtils.dp2px(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), AIOUtils.dp2px(3.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), AIOUtils.dp2px(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()));
          }
          a((View)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)((View)localObject1).findViewById(2131370839));
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
          J();
          localObject1 = View.inflate(this, 2131561590, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[42] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          a(42, 3, (View)localObject1, getString(2131699072), "", true);
          ((View)localObject1).setTag(Integer.valueOf(42));
          localObject2 = (TextView)((View)localObject1).findViewById(2131363685);
          if (localObject2 != null) {
            ((TextView)localObject2).setVisibility(8);
          }
          if (i1 == 0) {
            break label5211;
          }
          bool = bhdf.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
          localObject2 = bhdf.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "");
          localObject3 = (TextView)((View)localObject1).findViewById(2131376668);
          if (localObject3 != null)
          {
            if ((!bool) || (!TextUtils.isEmpty((CharSequence)localObject2))) {
              break label5201;
            }
            ((TextView)localObject3).setText((CharSequence)localObject2);
            TroopUtils.updateRedPoint(bool, (TextView)localObject3);
          }
          ((View)localObject1).setOnClickListener(this);
          ((View)localObject1).setVisibility(0);
          bdla.b(this.app, "dc00898", "", "", "0X800B2F0", "0X800B2F0", 0, 0, "", "", "", "");
          localObject1 = View.inflate(this, 2131561603, null);
          ((View)localObject1).setBackgroundResource(2130850739);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
          localObject1 = View.inflate(this, 2131559912, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localObject1;
          ((View)localObject1).getBackground().setAlpha(255);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setVisibility(8);
          this.jdField_c_of_type_AndroidViewView = View.inflate(this, 2131561603, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
          this.jdField_c_of_type_AndroidViewView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          localObject1 = View.inflate(this, 2131561590, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[14] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setTag(Integer.valueOf(14));
          a(14, 2, (View)localObject1, getString(2131691754), "", true);
          f();
          b((View)localObject1);
          localObject1 = View.inflate(this, 2131561590, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[25] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setTag(Integer.valueOf(25));
          a(25, 2, (View)localObject1, getString(2131699017), "", true);
          if (this.jdField_d_of_type_Boolean) {
            break label5221;
          }
          bool = true;
          a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop);
          b((View)localObject1);
          if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
            bhbu.a("Grp_set_new", "grpData_admin", "search_upgrade_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          }
          localObject1 = View.inflate(this, 2131561590, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          a((View)localObject1, null);
          a(4, 3, (View)localObject1, getString(2131699049), "", true);
          ((View)localObject1).setTag(Integer.valueOf(4));
          ((View)localObject1).setOnClickListener(this);
          localObject1 = new View(this);
          ((View)localObject1).setBackgroundResource(2130850093);
          localObject2 = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject2).height = 1;
          ((RelativeLayout.LayoutParams)localObject2).setMargins(AIOUtils.dp2px(16.0F, getResources()), 0, 0, 0);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject2 = View.inflate(this, 2131561590, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject2;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          a((View)localObject2, null);
          ((View)localObject2).setTag(Integer.valueOf(5));
          ((View)localObject2).setOnClickListener(this);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
            break label5227;
          }
          localObject1 = anvx.a(2131701212);
          a(5, 3, (View)localObject2, getString(2131719591), (CharSequence)localObject1, true);
          if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (!this.jdField_b_of_type_Boolean)) {
            break label5238;
          }
          i1 = 0;
          ((View)localObject2).setVisibility(i1);
          if (i1 == 0) {
            bhbu.a("Grp_set_new", "grpData_admin", "manageGrp_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          }
          localObject3 = (TextView)((View)localObject2).findViewById(2131376668);
          ((TextView)localObject3).setText((CharSequence)localObject1);
          b((View)localObject2);
          this.q = TroopUtils.isEmptyRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY" + this.app.getCurrentAccountUin());
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
            break label5244;
          }
          bool = false;
          this.p = TroopUtils.isShowKingTeamRedPoint(bool, "RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
          TroopUtils.updateRedPoint(TroopUtils.isUpdateBeforeSomeVersion(this, "8.0.5"), "RED_POINT_KEY_TROOP_ADMIN", this.p, this.q, (TextView)localObject3);
          localObject1 = (TroopPluginManager)this.app.getManager(QQManagerFactory.TROOP_PLUGIN_MANAGER);
          if (localObject1 != null) {
            this.jdField_b_of_type_Boolean = ((TroopPluginManager)localObject1).a("troop_manage_plugin.apk", new adsr(this));
          }
          localObject1 = View.inflate(this, 2131561603, null);
          ((View)localObject1).setBackgroundResource(2130850739);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
          localObject1 = new FormSimpleItem(this);
          a(1001, 0, (FormSimpleItem)localObject1, getString(2131695842), anvx.a(2131701226), true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          bhbu.a("Grp_set_new", "grpData_admin", "chatRecord_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          localObject1 = View.inflate(this, 2131561603, null);
          ((View)localObject1).setBackgroundResource(2130850739);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBgType(1);
          ((FormSwitchItem)localObject1).setText(getString(2131692964));
          ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167026));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131692964));
          this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
          localObject2 = ((FormSwitchItem)localObject1).a();
          if (!((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            break label5256;
          }
          ((Switch)localObject2).setChecked(true);
          ((Switch)localObject2).setTag(Integer.valueOf(7));
          ((Switch)localObject2).setOnCheckedChangeListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBackgroundResource(2130839506);
          ((FormSwitchItem)localObject1).setBgType(2);
          ((FormSwitchItem)localObject1).setText(getString(2131692965));
          ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167026));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131692965));
          this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
          localObject2 = ((FormSwitchItem)localObject1).a();
          ((Switch)localObject2).setTag(Boolean.FALSE);
          int i2 = this.app.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopmask = i2;
          }
          if (i2 == 1) {
            break label5265;
          }
          bool = true;
          ((Switch)localObject2).setChecked(bool);
          ((Switch)localObject2).setOnCheckedChangeListener(new adsz(this));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2131561587, null);
          localObject2 = (FormSimpleItem)((View)localObject1).findViewById(2131369195);
          a(9, 0, (FormSimpleItem)localObject2, getString(2131719505), "", true);
          this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
          localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(17.0F, getResources()), AIOUtils.dp2px(17.0F, getResources()));
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = AIOUtils.dp2px(30.0F, getResources());
          ((RelativeLayout.LayoutParams)localObject3).addRule(11);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15);
          ((FormSimpleItem)localObject2).addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject3);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839466));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_ArrayOfAndroidViewView[9] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(1010, 2, (FormSimpleItem)localObject1, getString(2131694345), getString(2131718561), true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localObject1);
          bhbu.a("Grp_set_new", "grpData_admin", "grpNotice_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          localObject2 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject2).setBackgroundResource(2130839506);
          ((FormSwitchItem)localObject2).setText(getString(2131696085));
          ((FormSwitchItem)localObject2).a().setTextColor(getResources().getColorStateList(2131167026));
          ((FormSwitchItem)localObject2).setFocusable(true);
          ((FormSwitchItem)localObject2).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject2).setContentDescription(getString(2131696085));
          this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject2;
          ((FormSwitchItem)localObject2).a().setTag(Integer.valueOf(10));
          ap();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          bhbu.a("Grp_set_new", "grpData_admin", "hideMessage_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          localObject1 = View.inflate(this, 2131561603, null);
          ((View)localObject1).setBackgroundResource(2130850739);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
          localObject3 = new TroopNickFormItem(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject3;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
          if (i1 != 0) {
            break label5271;
          }
          i1 = 3;
          String str2 = getString(2131694214);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick)) {
            break label5276;
          }
          localObject1 = getString(2131697320);
          a(6, i1, (FormSimpleItem)localObject3, str2, (CharSequence)localObject1, true);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick))
          {
            localObject1 = new begq(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).a();
            ((FormSimpleItem)localObject3).setRightText((CharSequence)localObject1);
            bhmb.a(((FormSimpleItem)localObject3).a(), (Spannable)localObject1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNickId);
          }
          localObject1 = View.inflate(this, 2131561603, null);
          ((View)localObject1).setBackgroundResource(2130850739);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
          if (((bfwu)this.app.getManager(QQManagerFactory.TROOP_HONOR_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
          {
            localObject1 = new FormSimpleItem(this, null);
            ((FormSimpleItem)localObject1).a(true);
            ((FormSimpleItem)localObject1).setBgType(1);
            ((FormSimpleItem)localObject1).setLeftText(getResources().getString(2131699035));
            ((FormSimpleItem)localObject1).setRightText(getResources().getString(2131699033));
            ((FormSimpleItem)localObject1).setContentDescription(getResources().getString(2131699035));
            ((FormSwitchItem)localObject2).a().setTextColor(getResources().getColorStateList(2131167026));
            ((FormSimpleItem)localObject1).setFocusable(true);
            ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
            this.jdField_a_of_type_ArrayOfAndroidViewView[32] = localObject1;
            ((FormSimpleItem)localObject1).setTag(Integer.valueOf(32));
            ((FormSimpleItem)localObject1).setOnClickListener(this);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            bhbu.a("Grp_set_new", "grpData_admin", "grpHonour_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
            bdla.b(null, "dc00898", "", "", "0X800A6EE", "0X800A6EE", 0, 0, "", "", "", "");
          }
          localObject1 = View.inflate(this, 2131561590, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[49] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          a(49, 3, (View)localObject1, getString(2131699047), "", true);
          ((View)localObject1).setTag(Integer.valueOf(49));
          localObject2 = (TextView)((View)localObject1).findViewById(2131363685);
          if (localObject2 != null) {
            ((TextView)localObject2).setVisibility(8);
          }
          ((View)localObject1).setOnClickListener(this);
          if (!this.jdField_f_of_type_Boolean) {
            break label5288;
          }
          bhbu.a("Grp_set_new", "grpData_admin", "Luckyword_entry_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          ((View)localObject1).setVisibility(0);
          localObject1 = View.inflate(this, 2131561603, null);
          ((View)localObject1).setBackgroundResource(2130850739);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
          c(true);
          localObject1 = new FormSimpleItem(this, null);
          ((FormSimpleItem)localObject1).a(true);
          ((FormSimpleItem)localObject1).setBgType(2);
          ((FormSimpleItem)localObject1).setLeftText(getResources().getString(2131720056));
          ((FormSimpleItem)localObject1).a().setTextColor(getResources().getColor(2131167026));
          ((FormSimpleItem)localObject1).setFocusable(true);
          ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
          ((FormSimpleItem)localObject1).setContentDescription(getResources().getString(2131720056));
          this.jdField_a_of_type_ArrayOfAndroidViewView[16] = localObject1;
          ((FormSimpleItem)localObject1).setTag(Integer.valueOf(16));
          ((FormSimpleItem)localObject1).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          G();
          localObject1 = new FormSimpleItem(this, null);
          ((FormSimpleItem)localObject1).a(true);
          ((FormSimpleItem)localObject1).setBgType(3);
          ((FormSimpleItem)localObject1).setLeftText("一起K歌");
          ((FormSimpleItem)localObject1).a().setTextColor(getResources().getColor(2131167026));
          ((FormSimpleItem)localObject1).setFocusable(true);
          ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
          ((FormSimpleItem)localObject1).setContentDescription("一起K歌");
          this.jdField_a_of_type_ArrayOfAndroidViewView[38] = localObject1;
          ((FormSimpleItem)localObject1).setTag(Integer.valueOf(38));
          ((FormSimpleItem)localObject1).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          H();
          if (bhsv.a())
          {
            localObject1 = View.inflate(this, 2131561603, null);
            ((View)localObject1).setBackgroundResource(2130850739);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
            localObject1 = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[40] = localObject1;
            a(40, 0, (FormSimpleItem)localObject1, getString(2131699045), "", true);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          }
          localObject1 = View.inflate(this, 2131561603, null);
          ((View)localObject1).setBackgroundResource(2130850739);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
          if (!bghs.a(this.app)) {
            break label5330;
          }
          this.jdField_a_of_type_Bgnx = new bgnx(this, getString(2131719689));
          localObject1 = this.jdField_a_of_type_Bgnx.a();
          if (localObject1 != null)
          {
            if (!bghs.c(this.app)) {
              break label5298;
            }
            this.o = bghs.b(this.app);
            if (QLog.isColorLevel()) {
              QLog.d("Q.chatopttroop", 2, "bShowRed red robot" + this.o);
            }
            this.jdField_a_of_type_Bgnx.a(this.o);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).setOnClickListener(this);
            ((View)localObject1).setTag(Integer.valueOf(1009));
            localObject1 = View.inflate(this, 2131561603, null);
            ((View)localObject1).setBackgroundResource(2130850739);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
            bdla.b(this.app, "dc00898", "", "", "", "0X8009F9B", 0, 0, "", "", "", "");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()))
          {
            localObject1 = new FormSimpleItem(this);
            a(1006, 0, (FormSimpleItem)localObject1, anvx.a(2131701261), "", true);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            bhbu.a("Grp_edu", "Grp_data", "teachermsg_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          }
          localObject1 = new LinearLayout(this);
          ((LinearLayout)localObject1).setOrientation(1);
          ((LinearLayout)localObject1).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_a_of_type_ArrayOfAndroidViewView[28] = localObject1;
          localObject1 = View.inflate(this, 2131561603, null);
          ((View)localObject1).setBackgroundResource(2130850739);
          this.jdField_a_of_type_ArrayOfAndroidViewView[24] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
          localObject1 = new FormSimpleItem(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[17] = localObject1;
          a(17, 1, (FormSimpleItem)localObject1, anvx.a(2131701246), "", true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          bhbu.a("Grp_set_new", "grpData_admin", "chatBG_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop", 2, "initUI  mIsQidianPrivateTroop = " + this.jdField_d_of_type_Boolean);
          }
          if (!this.jdField_d_of_type_Boolean)
          {
            localObject1 = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[18] = localObject1;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            a(18, 2, (FormSimpleItem)localObject1, getString(2131719535), "", true);
            ((FormSimpleItem)localObject1).setVisibility(8);
            localObject1 = (bfkw)this.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
            if (QLog.isColorLevel()) {
              QLog.d("Q.chatopttroop", 2, "initUI  effectManager.isAllTroopShowEnterance() = " + ((bfkw)localObject1).b());
            }
            if (((bfkw)localObject1).b()) {
              a(true);
            }
          }
          an();
          localObject1 = View.inflate(this, 2131561603, null);
          ((View)localObject1).setBackgroundResource(2130850739);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
          localObject1 = View.inflate(this, 2131561583, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[27] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          a(27, 0, (View)localObject1, getString(2131695843), null, false);
          ((View)localObject1).setTag(Integer.valueOf(27));
          ((View)localObject1).setOnClickListener(this);
          localObject2 = (TextView)((View)localObject1).findViewById(2131379001);
          if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
            ((TextView)localObject2).setAlpha(0.5F);
          }
          ((TextView)localObject2).setTextColor(Color.parseColor("#4799DF"));
          localObject1 = (TextView)((View)localObject1).findViewById(2131368819);
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
          localObject1 = View.inflate(this, 2131561601, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = (Button)((View)localObject1).findViewById(2131365490);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
            break label5343;
          }
          ((Button)localObject1).setText(2131691718);
          ((Button)localObject1).setOnClickListener(new adte(this));
          localObject1 = new TextView(this);
          ((TextView)localObject1).setOnClickListener(new adtf(this));
          localObject2 = new LinearLayout.LayoutParams(-2, -2);
          ((TextView)localObject1).setGravity(1);
          if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
            ((TextView)localObject1).setAlpha(0.5F);
          }
          ((TextView)localObject1).setTextColor(Color.parseColor("#4799DF"));
          ((TextView)localObject1).setTextSize(1, 14.0F);
          ((TextView)localObject1).setText(2131719622);
          ((LinearLayout.LayoutParams)localObject2).gravity = 1;
          ((LinearLayout.LayoutParams)localObject2).topMargin = ViewUtils.dpToPx(15.0F);
          ((LinearLayout.LayoutParams)localObject2).bottomMargin = ViewUtils.dpToPx(24.0F);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          bhbu.a("Grp_set_new", "grpData_admin", "tipoff_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
          }
          this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363875);
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363792));
          this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131377567));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)localView.findViewById(2131363699));
          this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new adtg(this));
          b(false);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        finish();
        localOutOfMemoryError.printStackTrace();
        return;
      }
      String str1 = getString(2131695881);
      continue;
      label5190:
      str1.setBackgroundResource(2130839503);
      continue;
      label5201:
      ((TextView)localObject3).setText("");
      continue;
      label5211:
      str1.setVisibility(8);
      continue;
      label5221:
      boolean bool = false;
      continue;
      label5227:
      str1 = anvx.a(2131701219);
      continue;
      label5238:
      int i1 = 8;
      continue;
      label5244:
      bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop();
      continue;
      label5256:
      ((Switch)localObject2).setChecked(false);
      continue;
      label5265:
      bool = false;
      continue;
      label5271:
      i1 = 0;
      continue;
      label5276:
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick;
      continue;
      label5288:
      str1.setVisibility(8);
      continue;
      label5298:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        this.o = bghs.b(this.app);
      }
      else
      {
        this.o = false;
        continue;
        label5330:
        QLog.i("Q.chatopttroop", 2, "RobotSwithOff");
        continue;
        label5343:
        str1.setText(2131716593);
        continue;
        label5354:
        i1 = 0;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new bisy(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131368819);
    if (paramString != null)
    {
      paramString.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      if (!TextUtils.isEmpty(paramCharSequence)) {
        break label69;
      }
    }
    label69:
    for (paramView = "";; paramView = new QQText(paramCharSequence, 3))
    {
      paramString.setText(paramView);
      paramString.setTextColor(getResources().getColor(2131167106));
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, boolean paramBoolean)
  {
    label52:
    TextView localTextView;
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
      switch (paramInt2)
      {
      default: 
        paramView.getBackground().setAlpha(255);
        localTextView = (TextView)paramView.findViewById(2131379001);
        if (localTextView != null)
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label176;
          }
          localTextView.setText("");
          localTextView.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      a(paramInt1, paramView, paramBoolean);
      return;
      paramView.setTag(null);
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130839496);
      break label52;
      paramView.setBackgroundResource(2130839512);
      break label52;
      paramView.setBackgroundResource(2130839506);
      break label52;
      paramView.setBackgroundResource(2130839503);
      break label52;
      paramView.setBackgroundColor(Color.parseColor("#00000000"));
      break label52;
      label176:
      localTextView.setText(paramString);
      localTextView.setVisibility(0);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, FormSimpleItem paramFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramFormSimpleItem.setOnClickListener(this);
      paramFormSimpleItem.a(true);
      switch (paramInt2)
      {
      default: 
        label60:
        paramFormSimpleItem.setRightTextColor(2);
        paramFormSimpleItem.setLeftTextColor(0);
        paramFormSimpleItem.getBackground().setAlpha(255);
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        paramFormSimpleItem.setLeftText(str);
        paramFormSimpleItem.a().setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        if (paramCharSequence != null) {
          break;
        }
      }
    }
    for (paramString = "";; paramString = new QQText(paramCharSequence, 3))
    {
      paramFormSimpleItem.setRightText(paramString);
      return;
      paramFormSimpleItem.setTag(null);
      paramFormSimpleItem.setOnClickListener(null);
      paramFormSimpleItem.a(false);
      break;
      paramFormSimpleItem.setBgType(0);
      break label60;
      paramFormSimpleItem.setBgType(1);
      break label60;
      paramFormSimpleItem.setBgType(2);
      break label60;
      paramFormSimpleItem.setBgType(3);
      break label60;
      paramFormSimpleItem.setBackgroundColor(Color.parseColor("#00000000"));
      break label60;
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    String str2 = bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (paramInt == -1) {}
    for (Object localObject = "0";; localObject = "1")
    {
      bhbu.a("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
      if (paramInt == -1) {
        break;
      }
      return;
    }
    localObject = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.sessionFromIntent((Intent)localObject);
    ForwardUtils.handleAppShareAction(this.app, this, paramIntent, (Intent)localObject);
  }
  
  protected void a(int paramInt, View paramView, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramView == null) {}
    do
    {
      return;
      if (33 == paramInt) {
        paramBoolean = false;
      }
      paramView = paramView.findViewById(2131362985);
    } while (paramView == null);
    if (paramBoolean) {}
    for (paramInt = i1;; paramInt = 8)
    {
      paramView.setVisibility(paramInt);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    ThreadManager.post(new ChatSettingForTroop.26(this, paramLong), 8, null, true);
  }
  
  /* Error */
  public void a(KQQ.BatchResponse paramBatchResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 2708	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 2710	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 2711	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 10
    //   21: aload 10
    //   23: aload_1
    //   24: getfield 2715	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 2716	[B
    //   30: invokevirtual 2717	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 2720	KQQ/BatchResponse:seq	I
    //   38: ifne +746 -> 784
    //   41: aload 10
    //   43: ifnull +741 -> 784
    //   46: aload 10
    //   48: getfield 2724	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 2727	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq +730 -> 784
    //   57: aload 10
    //   59: getfield 2724	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 2730	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 2736	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore 8
    //   70: new 2738	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   73: dup
    //   74: invokespecial 2739	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   77: astore 9
    //   79: aload 9
    //   81: aload 8
    //   83: invokevirtual 2740	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   86: pop
    //   87: aconst_null
    //   88: astore 8
    //   90: aload 9
    //   92: getfield 2744	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: invokevirtual 2749	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   98: astore 11
    //   100: aload 11
    //   102: ifnonnull +53 -> 155
    //   105: iconst_0
    //   106: istore_3
    //   107: goto +1380 -> 1487
    //   110: aload 8
    //   112: ifnonnull +672 -> 784
    //   115: iload 4
    //   117: iload_3
    //   118: if_icmpge +666 -> 784
    //   121: aload 11
    //   123: iload 4
    //   125: invokeinterface 2751 2 0
    //   130: checkcast 2753	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   133: astore 9
    //   135: aload 9
    //   137: ifnonnull +29 -> 166
    //   140: iload 4
    //   142: iconst_1
    //   143: iadd
    //   144: istore 4
    //   146: goto -36 -> 110
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 2754	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   154: return
    //   155: aload 11
    //   157: invokeinterface 2077 1 0
    //   162: istore_3
    //   163: goto +1324 -> 1487
    //   166: aload 9
    //   168: getfield 2758	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: invokevirtual 2761	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   174: istore_2
    //   175: iload_2
    //   176: bipush 72
    //   178: if_icmpne +83 -> 261
    //   181: iload 4
    //   183: ifne +78 -> 261
    //   186: aload_0
    //   187: ldc_w 2762
    //   190: iconst_1
    //   191: invokestatic 2304	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   194: aload_0
    //   195: invokevirtual 2307	com/tencent/mobileqq/activity/ChatSettingForTroop:getTitleBarHeight	()I
    //   198: invokevirtual 2310	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   201: pop
    //   202: new 2764	com/tencent/mobileqq/activity/ChatSettingForTroop$40
    //   205: dup
    //   206: aload_0
    //   207: invokespecial 2765	com/tencent/mobileqq/activity/ChatSettingForTroop$40:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   210: bipush 32
    //   212: aconst_null
    //   213: iconst_0
    //   214: invokestatic 2770	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   217: aload_0
    //   218: aconst_null
    //   219: putfield 398	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   222: aload_0
    //   223: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   226: iconst_0
    //   227: putfield 2081	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   230: aload_0
    //   231: invokevirtual 1763	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   234: ldc_w 2772
    //   237: iconst_0
    //   238: invokevirtual 1332	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   241: pop
    //   242: aload_0
    //   243: invokevirtual 2219	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   246: aload_0
    //   247: aload_0
    //   248: invokevirtual 1763	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   251: invokevirtual 2238	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   254: iconst_2
    //   255: invokestatic 2776	com/tencent/mobileqq/troop/utils/TroopUtils:openTroopInfoActivity	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   258: goto -118 -> 140
    //   261: iload_2
    //   262: ifne +1119 -> 1381
    //   265: aload 9
    //   267: getfield 2780	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   270: invokevirtual 2783	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   273: ifeq +1108 -> 1381
    //   276: aload 9
    //   278: getfield 2780	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   281: invokevirtual 2786	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   284: checkcast 2782	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   287: astore 9
    //   289: aload 9
    //   291: astore 8
    //   293: aload 9
    //   295: ifnull -155 -> 140
    //   298: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +40 -> 341
    //   304: ldc_w 631
    //   307: iconst_2
    //   308: new 546	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 547	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 2788
    //   318: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 9
    //   323: getfield 2791	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_long_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   326: invokevirtual 2730	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   329: invokevirtual 2794	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   332: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 639	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload 9
    //   343: astore 8
    //   345: aload_0
    //   346: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   349: ifnull -209 -> 140
    //   352: aload_0
    //   353: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   356: aload 9
    //   358: invokevirtual 2798	com/tencent/mobileqq/troopinfo/TroopInfoData:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   361: aload_0
    //   362: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   365: getfield 2189	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   368: invokestatic 677	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +7 -> 378
    //   374: aload_0
    //   375: invokevirtual 655	com/tencent/mobileqq/activity/ChatSettingForTroop:f	()V
    //   378: aload_0
    //   379: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   382: getfield 845	com/tencent/mobileqq/troopinfo/TroopInfoData:hasSetNewTroopHead	Z
    //   385: ifeq +7 -> 392
    //   388: aload_0
    //   389: invokespecial 2176	com/tencent/mobileqq/activity/ChatSettingForTroop:K	()V
    //   392: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   395: ifeq +69 -> 464
    //   398: aload 9
    //   400: getfield 2801	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   403: invokevirtual 2761	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   406: istore_2
    //   407: ldc_w 2803
    //   410: iconst_2
    //   411: new 546	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 547	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 2805
    //   421: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   428: getfield 274	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   431: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 2807
    //   437: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: iload_2
    //   441: invokevirtual 709	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: ldc_w 2809
    //   447: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload_2
    //   451: i2l
    //   452: invokestatic 2811	com/tencent/mobileqq/data/troop/TroopInfo:isQidianPrivateTroop	(J)Z
    //   455: invokevirtual 636	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   458: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 639	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload_0
    //   465: getfield 398	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   468: ifnull +64 -> 532
    //   471: aload_0
    //   472: getfield 398	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   475: aload 9
    //   477: invokevirtual 2812	com/tencent/mobileqq/data/troop/TroopInfo:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   480: aload_0
    //   481: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   484: aload_0
    //   485: getfield 398	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   488: invokevirtual 1126	com/tencent/mobileqq/data/troop/TroopInfo:getTroopName	()Ljava/lang/String;
    //   491: putfield 2189	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   494: aload_0
    //   495: getfield 398	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   498: getfield 2813	com/tencent/mobileqq/data/troop/TroopInfo:isNewTroop	Z
    //   501: ifne +17 -> 518
    //   504: aload_0
    //   505: getfield 398	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   508: aload_0
    //   509: getfield 398	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   512: invokevirtual 1126	com/tencent/mobileqq/data/troop/TroopInfo:getTroopName	()Ljava/lang/String;
    //   515: putfield 2814	com/tencent/mobileqq/data/troop/TroopInfo:newTroopName	Ljava/lang/String;
    //   518: aload_0
    //   519: getfield 398	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   522: aload_0
    //   523: getfield 398	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   526: invokevirtual 1126	com/tencent/mobileqq/data/troop/TroopInfo:getTroopName	()Ljava/lang/String;
    //   529: putfield 2817	com/tencent/mobileqq/data/troop/TroopInfo:oldTroopName	Ljava/lang/String;
    //   532: aload_0
    //   533: aload 9
    //   535: getfield 2801	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   538: invokevirtual 2761	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   541: i2l
    //   542: invokestatic 2811	com/tencent/mobileqq/data/troop/TroopInfo:isQidianPrivateTroop	(J)Z
    //   545: putfield 658	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   548: aload_0
    //   549: getfield 658	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   552: ifeq +77 -> 629
    //   555: aload_0
    //   556: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   559: getfield 532	com/tencent/mobileqq/troopinfo/TroopInfoData:bOwner	Z
    //   562: ifeq +804 -> 1366
    //   565: iconst_1
    //   566: istore_2
    //   567: new 2819	bdlf
    //   570: dup
    //   571: aload_0
    //   572: getfield 258	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   575: invokespecial 2822	bdlf:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   578: ldc_w 923
    //   581: invokevirtual 2825	bdlf:a	(Ljava/lang/String;)Lbdlf;
    //   584: ldc_w 2827
    //   587: invokevirtual 2829	bdlf:b	(Ljava/lang/String;)Lbdlf;
    //   590: ldc_w 419
    //   593: invokevirtual 2831	bdlf:c	(Ljava/lang/String;)Lbdlf;
    //   596: ldc_w 2833
    //   599: invokevirtual 2835	bdlf:d	(Ljava/lang/String;)Lbdlf;
    //   602: iconst_2
    //   603: anewarray 355	java/lang/String
    //   606: dup
    //   607: iconst_0
    //   608: aload_0
    //   609: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   612: getfield 274	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: iload_2
    //   619: invokestatic 1967	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   622: aastore
    //   623: invokevirtual 2838	bdlf:a	([Ljava/lang/String;)Lbdlf;
    //   626: invokevirtual 2840	bdlf:a	()V
    //   629: aload_0
    //   630: getfield 658	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   633: ifne +865 -> 1498
    //   636: iconst_1
    //   637: istore 5
    //   639: aload_0
    //   640: iload 5
    //   642: aload_0
    //   643: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   646: getfield 661	com/tencent/mobileqq/troopinfo/TroopInfoData:isNewTroop	Z
    //   649: invokespecial 664	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(ZZ)V
    //   652: aload_0
    //   653: invokevirtual 2842	com/tencent/mobileqq/activity/ChatSettingForTroop:m	()V
    //   656: aload_0
    //   657: getfield 258	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   660: aload_0
    //   661: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   664: getfield 2845	com/tencent/mobileqq/troopinfo/TroopInfoData:publicAccountUin	J
    //   667: new 2847	adsj
    //   670: dup
    //   671: aload_0
    //   672: invokespecial 2848	adsj:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   675: invokestatic 2853	bgiv:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLntf;)V
    //   678: aload_0
    //   679: invokevirtual 2855	com/tencent/mobileqq/activity/ChatSettingForTroop:l	()V
    //   682: aload_0
    //   683: invokespecial 2857	com/tencent/mobileqq/activity/ChatSettingForTroop:ac	()V
    //   686: aload_0
    //   687: invokevirtual 2179	com/tencent/mobileqq/activity/ChatSettingForTroop:e	()V
    //   690: aload_0
    //   691: invokespecial 2143	com/tencent/mobileqq/activity/ChatSettingForTroop:af	()V
    //   694: aload_0
    //   695: invokevirtual 2859	com/tencent/mobileqq/activity/ChatSettingForTroop:r	()V
    //   698: aload_0
    //   699: getfield 398	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   702: ifnull +21 -> 723
    //   705: aload_0
    //   706: getfield 398	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   709: aload_0
    //   710: getfield 258	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   713: aload_0
    //   714: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   717: getfield 2081	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   720: invokestatic 2863	com/tencent/mobileqq/troop/utils/TroopUtils:updateTroopInfoToDB	(Lcom/tencent/mobileqq/data/troop/TroopInfo;Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   723: aload_0
    //   724: invokevirtual 2865	com/tencent/mobileqq/activity/ChatSettingForTroop:g	()V
    //   727: aload_0
    //   728: getfield 2867	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   731: ifnull +21 -> 752
    //   734: aload_0
    //   735: getfield 2867	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   738: aload_0
    //   739: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   742: invokevirtual 2873	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:setTroopInfoData	(Lcom/tencent/mobileqq/troopinfo/TroopInfoData;)V
    //   745: aload_0
    //   746: getfield 2867	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   749: invokevirtual 2874	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	()V
    //   752: aload_0
    //   753: iconst_0
    //   754: invokespecial 2876	com/tencent/mobileqq/activity/ChatSettingForTroop:k	(Z)V
    //   757: aload 9
    //   759: astore 8
    //   761: goto -621 -> 140
    //   764: astore 8
    //   766: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   769: ifeq +15 -> 784
    //   772: ldc_w 2878
    //   775: iconst_2
    //   776: aload 8
    //   778: invokevirtual 2879	java/lang/Exception:toString	()Ljava/lang/String;
    //   781: invokestatic 650	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   784: aload_1
    //   785: getfield 2720	KQQ/BatchResponse:seq	I
    //   788: iconst_1
    //   789: if_icmpne +92 -> 881
    //   792: aload 10
    //   794: ifnull +87 -> 881
    //   797: aload 10
    //   799: getfield 2724	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   802: invokevirtual 2727	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   805: ifeq +76 -> 881
    //   808: aload 10
    //   810: getfield 2724	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   813: invokevirtual 2730	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   816: invokevirtual 2736	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   819: astore 8
    //   821: new 2881	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   824: dup
    //   825: invokespecial 2882	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   828: astore 9
    //   830: aload 9
    //   832: aload 8
    //   834: invokevirtual 2883	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   837: pop
    //   838: aload 9
    //   840: getfield 2886	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   843: invokevirtual 2887	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   846: ifeq +35 -> 881
    //   849: aload_0
    //   850: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   853: getfield 2081	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   856: ifne +555 -> 1411
    //   859: aload_0
    //   860: getfield 2867	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   863: ifnull +18 -> 881
    //   866: aload_0
    //   867: getfield 2867	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   870: aload 9
    //   872: getfield 2886	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   875: invokevirtual 2749	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   878: invokevirtual 2888	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	(Ljava/util/List;)V
    //   881: aload_1
    //   882: getfield 2720	KQQ/BatchResponse:seq	I
    //   885: iconst_2
    //   886: if_icmpne -875 -> 11
    //   889: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   892: ifeq +13 -> 905
    //   895: ldc_w 2890
    //   898: iconst_2
    //   899: ldc_w 2892
    //   902: invokestatic 639	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   905: aload 10
    //   907: ifnull -896 -> 11
    //   910: aload 10
    //   912: getfield 2724	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   915: invokevirtual 2727	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   918: ifeq -907 -> 11
    //   921: aload 10
    //   923: getfield 2724	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   926: invokevirtual 2730	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   929: invokevirtual 2736	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   932: astore_1
    //   933: new 2894	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   936: dup
    //   937: invokespecial 2895	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   940: astore 9
    //   942: aload 9
    //   944: aload_1
    //   945: invokevirtual 2896	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   948: pop
    //   949: aload 9
    //   951: getfield 2899	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   954: invokevirtual 1733	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   957: ifeq -946 -> 11
    //   960: aload 9
    //   962: getfield 2902	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   965: invokevirtual 2903	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   968: ifne +514 -> 1482
    //   971: aload 9
    //   973: getfield 2902	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   976: invokevirtual 2749	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   979: astore_1
    //   980: aload 9
    //   982: getfield 2906	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   985: invokevirtual 2903	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   988: ifne +488 -> 1476
    //   991: aload 9
    //   993: getfield 2906	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   996: invokevirtual 2749	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   999: astore 8
    //   1001: aload_0
    //   1002: getfield 258	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1005: getstatic 439	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   1008: invokevirtual 269	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1011: checkcast 441	com/tencent/mobileqq/app/TroopManager
    //   1014: astore 10
    //   1016: aload 9
    //   1018: getfield 2899	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1021: invokevirtual 1735	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1024: lstore 6
    //   1026: aload 10
    //   1028: lload 6
    //   1030: invokestatic 2047	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1033: invokevirtual 930	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1036: astore 11
    //   1038: aload 11
    //   1040: ifnull -1029 -> 11
    //   1043: aload_1
    //   1044: ifnull +71 -> 1115
    //   1047: aload 11
    //   1049: aload_1
    //   1050: aload 8
    //   1052: invokevirtual 2910	com/tencent/mobileqq/data/troop/TroopInfo:setTroopLevelMap787	(Ljava/util/List;Ljava/util/List;)V
    //   1055: aload 9
    //   1057: getfield 2913	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1060: invokevirtual 2914	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1063: ifeq +386 -> 1449
    //   1066: aload 9
    //   1068: getfield 2913	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1071: invokevirtual 2761	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1074: istore_2
    //   1075: aload 11
    //   1077: iload_2
    //   1078: i2l
    //   1079: putfield 2917	com/tencent/mobileqq/data/troop/TroopInfo:dwGroupLevelSeq	J
    //   1082: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1085: ifeq +30 -> 1115
    //   1088: ldc_w 2890
    //   1091: iconst_2
    //   1092: new 546	java/lang/StringBuilder
    //   1095: dup
    //   1096: invokespecial 547	java/lang/StringBuilder:<init>	()V
    //   1099: ldc_w 2919
    //   1102: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: iload_2
    //   1106: invokevirtual 709	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1109: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1112: invokestatic 639	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1115: aload 9
    //   1117: getfield 2922	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1120: astore_1
    //   1121: aload_1
    //   1122: ifnull +19 -> 1141
    //   1125: aload 11
    //   1127: aload 9
    //   1129: getfield 2922	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1132: invokevirtual 2730	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1135: invokevirtual 2794	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1138: putfield 2925	com/tencent/mobileqq/data/troop/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   1141: aload 9
    //   1143: getfield 2928	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1146: astore_1
    //   1147: aload_1
    //   1148: ifnull +19 -> 1167
    //   1151: aload 11
    //   1153: aload 9
    //   1155: getfield 2928	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1158: invokevirtual 2730	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1161: invokevirtual 2794	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1164: putfield 2931	com/tencent/mobileqq/data/troop/TroopInfo:adminNameShow	Ljava/lang/String;
    //   1167: iconst_m1
    //   1168: istore_2
    //   1169: iconst_m1
    //   1170: istore_3
    //   1171: iconst_m1
    //   1172: istore 4
    //   1174: aload 9
    //   1176: getfield 2934	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1179: invokevirtual 2914	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1182: ifeq +23 -> 1205
    //   1185: aload 11
    //   1187: aload 9
    //   1189: getfield 2934	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1192: invokevirtual 2761	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1195: i2b
    //   1196: putfield 2937	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   1199: aload 11
    //   1201: getfield 2937	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   1204: istore_2
    //   1205: aload 9
    //   1207: getfield 2940	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1210: invokevirtual 2914	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1213: ifeq +23 -> 1236
    //   1216: aload 11
    //   1218: aload 9
    //   1220: getfield 2940	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1223: invokevirtual 2761	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1226: i2b
    //   1227: putfield 2943	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   1230: aload 11
    //   1232: getfield 2943	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   1235: istore_3
    //   1236: aload 9
    //   1238: getfield 2946	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1241: invokevirtual 2914	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1244: ifeq +24 -> 1268
    //   1247: aload 11
    //   1249: aload 9
    //   1251: getfield 2946	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1254: invokevirtual 2761	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1257: i2b
    //   1258: putfield 2949	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   1261: aload 11
    //   1263: getfield 2949	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   1266: istore 4
    //   1268: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1271: ifeq +56 -> 1327
    //   1274: ldc_w 2890
    //   1277: iconst_2
    //   1278: new 546	java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial 547	java/lang/StringBuilder:<init>	()V
    //   1285: lload 6
    //   1287: invokevirtual 1890	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1290: ldc_w 2951
    //   1293: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: iload_2
    //   1297: invokevirtual 709	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1300: ldc_w 2953
    //   1303: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: iload_3
    //   1307: invokevirtual 709	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1310: ldc_w 2955
    //   1313: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: iload 4
    //   1318: invokevirtual 709	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1321: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1324: invokestatic 639	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1327: new 2957	com/tencent/mobileqq/activity/ChatSettingForTroop$42
    //   1330: dup
    //   1331: aload_0
    //   1332: aload 10
    //   1334: aload 11
    //   1336: invokespecial 2960	com/tencent/mobileqq/activity/ChatSettingForTroop$42:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/troop/TroopInfo;)V
    //   1339: bipush 8
    //   1341: aconst_null
    //   1342: iconst_0
    //   1343: invokestatic 2702	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1346: return
    //   1347: astore_1
    //   1348: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1351: ifeq -1340 -> 11
    //   1354: ldc_w 2890
    //   1357: iconst_2
    //   1358: aload_1
    //   1359: invokevirtual 2879	java/lang/Exception:toString	()Ljava/lang/String;
    //   1362: invokestatic 1444	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1365: return
    //   1366: aload_0
    //   1367: getfield 132	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1370: getfield 961	com/tencent/mobileqq/troopinfo/TroopInfoData:bAdmin	Z
    //   1373: ifeq +120 -> 1493
    //   1376: iconst_2
    //   1377: istore_2
    //   1378: goto -811 -> 567
    //   1381: ldc_w 1437
    //   1384: iconst_1
    //   1385: new 546	java/lang/StringBuilder
    //   1388: dup
    //   1389: invokespecial 547	java/lang/StringBuilder:<init>	()V
    //   1392: ldc_w 2962
    //   1395: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: iload_2
    //   1399: invokevirtual 709	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1402: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1405: invokestatic 1444	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1408: goto -1268 -> 140
    //   1411: aload_0
    //   1412: aload 9
    //   1414: getfield 2886	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1417: invokevirtual 2749	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1420: invokespecial 1376	com/tencent/mobileqq/activity/ChatSettingForTroop:c	(Ljava/util/List;)V
    //   1423: goto -542 -> 881
    //   1426: astore 8
    //   1428: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1431: ifeq -550 -> 881
    //   1434: ldc_w 2878
    //   1437: iconst_2
    //   1438: aload 8
    //   1440: invokevirtual 2879	java/lang/Exception:toString	()Ljava/lang/String;
    //   1443: invokestatic 650	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1446: goto -565 -> 881
    //   1449: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1452: ifeq -337 -> 1115
    //   1455: ldc_w 2890
    //   1458: iconst_2
    //   1459: ldc_w 2964
    //   1462: invokestatic 639	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1465: goto -350 -> 1115
    //   1468: astore_1
    //   1469: goto -302 -> 1167
    //   1472: astore_1
    //   1473: goto -332 -> 1141
    //   1476: aconst_null
    //   1477: astore 8
    //   1479: goto -478 -> 1001
    //   1482: aconst_null
    //   1483: astore_1
    //   1484: goto -504 -> 980
    //   1487: iconst_0
    //   1488: istore 4
    //   1490: goto -1380 -> 110
    //   1493: iconst_3
    //   1494: istore_2
    //   1495: goto -928 -> 567
    //   1498: iconst_0
    //   1499: istore 5
    //   1501: goto -862 -> 639
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1504	0	this	ChatSettingForTroop
    //   0	1504	1	paramBatchResponse	KQQ.BatchResponse
    //   174	1321	2	i1	int
    //   106	1201	3	i2	int
    //   115	1374	4	i3	int
    //   637	863	5	bool	boolean
    //   1024	262	6	l1	long
    //   68	692	8	localObject1	Object
    //   764	13	8	localException1	Exception
    //   819	232	8	localObject2	Object
    //   1426	13	8	localException2	Exception
    //   1477	1	8	localObject3	Object
    //   77	1336	9	localObject4	Object
    //   19	1314	10	localObject5	Object
    //   98	1237	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	149	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   70	87	764	java/lang/Exception
    //   90	100	764	java/lang/Exception
    //   121	135	764	java/lang/Exception
    //   155	163	764	java/lang/Exception
    //   166	175	764	java/lang/Exception
    //   186	258	764	java/lang/Exception
    //   265	289	764	java/lang/Exception
    //   298	341	764	java/lang/Exception
    //   345	378	764	java/lang/Exception
    //   378	392	764	java/lang/Exception
    //   392	464	764	java/lang/Exception
    //   464	518	764	java/lang/Exception
    //   518	532	764	java/lang/Exception
    //   532	565	764	java/lang/Exception
    //   567	629	764	java/lang/Exception
    //   629	636	764	java/lang/Exception
    //   639	723	764	java/lang/Exception
    //   723	752	764	java/lang/Exception
    //   752	757	764	java/lang/Exception
    //   1366	1376	764	java/lang/Exception
    //   1381	1408	764	java/lang/Exception
    //   933	980	1347	java/lang/Exception
    //   980	1001	1347	java/lang/Exception
    //   1001	1038	1347	java/lang/Exception
    //   1047	1115	1347	java/lang/Exception
    //   1115	1121	1347	java/lang/Exception
    //   1141	1147	1347	java/lang/Exception
    //   1174	1205	1347	java/lang/Exception
    //   1205	1236	1347	java/lang/Exception
    //   1236	1268	1347	java/lang/Exception
    //   1268	1327	1347	java/lang/Exception
    //   1327	1346	1347	java/lang/Exception
    //   1449	1465	1347	java/lang/Exception
    //   821	881	1426	java/lang/Exception
    //   1411	1423	1426	java/lang/Exception
    //   1151	1167	1468	java/lang/Exception
    //   1125	1141	1472	java/lang/Exception
  }
  
  public void a(advh paramadvh, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramadvh.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCacheFrom(paramadvh.jdField_a_of_type_Int, paramadvh.jdField_a_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bheg.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramadvh.jdField_a_of_type_JavaLangString, paramadvh.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramadvh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  protected void a(View paramView)
  {
    int[] arrayOfInt = new int[6];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131379554;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131379555;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131379556;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131379557;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131379558;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131379559;
    tmp38_32;
    this.jdField_b_of_type_JavaUtilList = new ArrayList(6);
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = arrayOfInt[i1];
      this.jdField_b_of_type_JavaUtilList.add((ImageView)paramView.findViewById(i3));
      i1 += 1;
    }
  }
  
  protected void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null)
    {
      this.jdField_d_of_type_JavaUtilList = paramTroopInfo.parseTroopMemeberList();
      if (QLog.isColorLevel())
      {
        paramTroopInfo = new StringBuilder().append("getMemberListFromTroopInfo,memberUins.size = ");
        if (this.jdField_d_of_type_JavaUtilList == null) {
          break label69;
        }
      }
    }
    label69:
    for (int i1 = this.jdField_d_of_type_JavaUtilList.size();; i1 = -1)
    {
      QLog.d("Q.chatopttroop", 2, i1);
      g();
      return;
    }
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    String str1 = null;
    if (paramTroopMemberInfo != null) {
      str1 = paramTroopMemberInfo.troopColorNick;
    }
    for (String str2 = paramTroopMemberInfo.troopnick;; str2 = null)
    {
      if (!TextUtils.isEmpty(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "updateNickUseTroopMemberInfo and colorNick is " + str1);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick = str1;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNickId = paramTroopMemberInfo.troopColorNickId;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = str2;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramString;
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = paramString;
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop;
      TroopUtils.updateTroopInfoToDB(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    bdla.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
  }
  
  public void a(List<oidb_0x899.memberlist> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "updateGridTroopMemberFace,list = " + paramList);
    }
    if (paramList == null) {
      return;
    }
    this.jdField_c_of_type_JavaUtilList = paramList;
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilList.size())
    {
      localArrayList.add(Long.valueOf(((oidb_0x899.memberlist)paramList.get(i1)).uint64_member_uin.get()));
      i1 += 1;
    }
    this.jdField_d_of_type_JavaUtilList = localArrayList;
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder().append("updateGridTroopMemberFace,memberUins.size = ");
      if (this.jdField_d_of_type_JavaUtilList == null) {
        break label171;
      }
    }
    label171:
    for (i1 = this.jdField_d_of_type_JavaUtilList.size();; i1 = -1)
    {
      QLog.d("Q.chatopttroop", 2, i1);
      this.jdField_a_of_type_AndroidOsHandler.post(new ChatSettingForTroop.25(this));
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    label314:
    label864:
    do
    {
      for (;;)
      {
        return;
        if (paramJSONObject != null)
        {
          try
          {
            paramInt = ((Integer)paramJSONObject.get("retcode")).intValue();
            paramJSONObject = (JSONObject)paramJSONObject.get("result");
            if ((paramInt != 0) || (paramJSONObject == null)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "checkApiState onResult. retCode = " + paramInt + "\n");
            }
            paramBundle = (JSONObject)paramJSONObject.get("basics");
            Object localObject2;
            String str;
            int i1;
            Object localObject1;
            if (paramBundle != null)
            {
              paramBundle = (JSONArray)paramBundle.get("datas");
              if (paramBundle != null)
              {
                paramInt = 0;
                if (paramInt < paramBundle.length())
                {
                  localObject2 = (JSONObject)paramBundle.get(paramInt);
                  str = (String)((JSONObject)localObject2).get("name");
                  i1 = ((Integer)((JSONObject)localObject2).get("state")).intValue();
                  localObject1 = (String)((JSONObject)localObject2).get("api");
                  localObject2 = (String)((JSONObject)localObject2).get("msg");
                  if (!QLog.isColorLevel()) {
                    break label1046;
                  }
                  QLog.i("Q.chatopttroop", 2, "checkApiState onResult, basics name = " + str + " state = " + i1 + " api = " + (String)localObject1 + " msg = " + (String)localObject2 + "\n");
                  break label1046;
                }
              }
            }
            paramBundle = (JSONObject)paramJSONObject.get("friendlink");
            if (paramBundle != null)
            {
              paramBundle = (JSONArray)paramBundle.get("datas");
              if (paramBundle != null)
              {
                paramInt = 0;
                if (paramInt < paramBundle.length())
                {
                  localObject2 = (JSONObject)paramBundle.get(paramInt);
                  str = (String)((JSONObject)localObject2).get("name");
                  i1 = ((Integer)((JSONObject)localObject2).get("state")).intValue();
                  localObject1 = (String)((JSONObject)localObject2).get("api");
                  localObject2 = (String)((JSONObject)localObject2).get("msg");
                  if (("add_group".equals(localObject1)) && (i1 != 1)) {
                    runOnUiThread(new ChatSettingForTroop.63(this));
                  }
                  if (!QLog.isColorLevel()) {
                    break label1053;
                  }
                  QLog.i("Q.chatopttroop", 2, "checkApiState onResult, friendlink name = " + str + " state = " + i1 + " api = " + (String)localObject1 + " msg= " + (String)localObject2 + "\n");
                  break label1053;
                }
              }
            }
            paramInt = ((Integer)paramJSONObject.get("appid")).intValue();
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "checkApiState onResult, appid =" + paramInt + "\n");
            }
            paramJSONObject = (JSONObject)paramJSONObject.get("qqpay");
            if (paramJSONObject == null) {
              continue;
            }
            paramJSONObject = (JSONArray)paramJSONObject.get("datas");
            if (paramJSONObject == null) {
              continue;
            }
            paramInt = 0;
            while (paramInt < paramJSONObject.length())
            {
              localObject1 = (JSONObject)paramJSONObject.get(paramInt);
              paramBundle = (String)((JSONObject)localObject1).get("name");
              i1 = ((Integer)((JSONObject)localObject1).get("state")).intValue();
              str = (String)((JSONObject)localObject1).get("api");
              localObject1 = (String)((JSONObject)localObject1).get("msg");
              if (QLog.isColorLevel()) {
                QLog.i("Q.chatopttroop", 2, "checkApiState onResult, qqpay name = " + paramBundle + " state = " + i1 + " api = " + str + " msg= " + (String)localObject1 + "\n");
              }
              paramInt += 1;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
          }
          catch (Exception paramJSONObject) {}
          QLog.d("Q.chatopttroop", 2, "checkApiState onResult " + paramJSONObject.toString());
          return;
          if (paramJSONObject != null) {
            try
            {
              paramJSONObject = (JSONObject)paramJSONObject.get("data");
              if (paramJSONObject != null)
              {
                paramJSONObject = (JSONObject)paramJSONObject.get("key");
                if (paramJSONObject != null)
                {
                  paramInt = ((Integer)paramJSONObject.get("retCode")).intValue();
                  paramBundle = (String)paramJSONObject.get("retMsg");
                  if (paramInt != 0) {
                    break label963;
                  }
                  d(true);
                  bdla.b(this.app, "CliOper", "", "", "0x80084B5", "0x80084B5", 0, 0, "", "", "", "");
                  if (QLog.isColorLevel())
                  {
                    QLog.i("Q.chatopttroop", 2, "joinGroup onResult retCode = " + paramInt + " retMsg = " + paramBundle);
                    return;
                  }
                }
              }
            }
            catch (Exception paramJSONObject)
            {
              e(getActivity().getResources().getString(2131719598));
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.chatopttroop", 2, "joinGroup onResult " + paramJSONObject.toString());
    return;
    label963:
    paramJSONObject = getActivity().getResources().getString(2131719598);
    switch (paramInt)
    {
    }
    for (;;)
    {
      e(paramJSONObject);
      break label864;
      paramJSONObject = getActivity().getResources().getString(2131719593);
      continue;
      paramJSONObject = getActivity().getResources().getString(2131719599);
      continue;
      label1046:
      paramInt += 1;
      break;
      label1053:
      paramInt += 1;
      break label314;
    }
  }
  
  public void a(oidb_0xe83.RspBody paramRspBody)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("showGetAppListResult: respBody isNull=");
      if (paramRspBody != null) {
        break label50;
      }
    }
    label50:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("Q.chatopttroop", 2, bool1);
      if (paramRspBody != null) {
        break;
      }
      return;
    }
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    List localList;
    if (localView != null)
    {
      localList = paramRspBody.infos.get();
      if ((localList != null) && (localList.size() != 0)) {
        break label188;
      }
      localView.setVisibility(8);
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList == null || appList.size() == 0");
      }
    }
    label188:
    boolean bool2;
    int i4;
    label332:
    int i1;
    label340:
    int i2;
    label342:
    do
    {
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[28];
      if (localObject1 == null) {
        break;
      }
      if (paramRspBody.extra_info.tab_infos.size() <= 0) {
        break label1236;
      }
      ((View)localObject1).setVisibility(0);
      b(paramRspBody.extra_info.tab_infos.get());
      return;
      bdfk.b();
      bool2 = ThemeUtil.isInNightMode(this.app);
      localView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379497));
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        break label411;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131708433));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new adsv(this));
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      i4 = localList.size();
      localObject1 = localView.findViewById(2131379413);
      if (i4 > 5) {
        break label423;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList.size() <= 5");
      }
      ((View)localObject1).setVisibility(8);
      if (i4 > 5) {
        break label432;
      }
      i1 = 4;
      i2 = 0;
    } while (i2 > i1);
    switch (i2)
    {
    }
    for (;;)
    {
      i2 += 1;
      break label342;
      label411:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label423:
      ((View)localObject1).setVisibility(0);
      break label332;
      label432:
      i1 = 9;
      break label340;
      localObject1 = localView.findViewById(2131379399);
      label448:
      ImageView localImageView;
      Object localObject4;
      oidb_0xe83.AppInfo localAppInfo;
      Object localObject3;
      Object localObject2;
      int i3;
      if ((i2 <= i1) && (i2 < i4))
      {
        ((View)localObject1).setVisibility(0);
        localImageView = (ImageView)((View)localObject1).findViewById(2131362846);
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131362868);
        localObject4 = (TextView)((View)localObject1).findViewById(2131362866);
        localAppInfo = (oidb_0xe83.AppInfo)localList.get(i2);
        localObject3 = localAppInfo.name.get();
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          continue;
        }
        localObject2 = localObject3;
        if (((String)localObject3).length() > 4) {
          localObject2 = ((String)localObject3).substring(0, 4) + "...";
        }
        localTextView.setText((CharSequence)localObject2);
        localObject3 = new StringBuffer((String)localObject2);
        i3 = localAppInfo.push_red_point.get();
        if (i3 != -1) {
          break label1138;
        }
        ((TextView)localObject4).setVisibility(0);
        ((TextView)localObject4).setText("");
        ((TextView)localObject4).setBackgroundResource(0);
        ((TextView)localObject4).setCompoundDrawablesWithIntrinsicBounds(2130850427, 0, 0, 0);
        ((StringBuffer)localObject3).append("，新");
        label649:
        long l1 = localAppInfo.appid.get();
        if ((i3 != -1) && (l1 == 1L))
        {
          if (!bhdf.a(this.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false)) {
            break label1200;
          }
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText("");
          ((TextView)localObject4).setBackgroundResource(0);
          ((TextView)localObject4).setCompoundDrawablesWithIntrinsicBounds(2130850427, 0, 0, 0);
        }
        label726:
        if (l1 == 0L) {
          MiniProgramLpReportDC04239.reportByQQqunInfo("qun", "qun_info", "expo_more", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (!localAppInfo.icon.has()) {
          break label1210;
        }
        localObject2 = localAppInfo.icon.get();
        label773:
        localObject4 = localImageView.getContext();
        if (localAppInfo.show_frame.get() != 1) {
          break label1217;
        }
      }
      label1200:
      label1210:
      label1217:
      for (bool1 = true;; bool1 = false)
      {
        bgil.a((Context)localObject4, localImageView, (String)localObject2, 40.0F, bool1);
        if (MiniAppLauncher.isMiniAppUrl(localAppInfo.url.get())) {
          TroopUtils.reportQunMiniApp(localAppInfo, "expo", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (bool2) {
          localImageView.setColorFilter(1996488704);
        }
        ((View)localObject1).setTag(localAppInfo);
        ((View)localObject1).setTag(-1, Integer.valueOf(i2 + 1));
        ((View)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        i3 = 0;
        while (i3 < i4)
        {
          localObject2 = (oidb_0xe83.AppInfo)localList.get(i3);
          if ((localObject2 != null) && (((oidb_0xe83.AppInfo)localObject2).appid != null)) {
            bdla.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800AFC3", "0X800AFC3", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt), String.valueOf(((oidb_0xe83.AppInfo)localObject2).appid.get()), String.valueOf(((oidb_0xe83.AppInfo)localObject2).appid.get()) + "-" + String.valueOf(i3 + 1), "");
          }
          i3 += 1;
        }
        localObject1 = localView.findViewById(2131379400);
        break label448;
        localObject1 = localView.findViewById(2131379401);
        break label448;
        localObject1 = localView.findViewById(2131379402);
        break label448;
        localObject1 = localView.findViewById(2131379403);
        break label448;
        localObject1 = localView.findViewById(2131379404);
        break label448;
        localObject1 = localView.findViewById(2131379405);
        break label448;
        localObject1 = localView.findViewById(2131379406);
        break label448;
        localObject1 = localView.findViewById(2131379407);
        break label448;
        localObject1 = localView.findViewById(2131379408);
        break label448;
        ((View)localObject1).setVisibility(4);
        break;
        label1138:
        if (i3 > 0)
        {
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText(String.valueOf(i3));
          ((TextView)localObject4).setBackgroundResource(2130850431);
          ((StringBuffer)localObject3).append("，").append(i3).append("未读");
          break label649;
        }
        ((TextView)localObject4).setVisibility(8);
        break label649;
        ((TextView)localObject4).setVisibility(8);
        break label726;
        localObject2 = "";
        break label773;
      }
      ((View)localObject1).setContentDescription(((StringBuffer)localObject3).toString());
    }
    label1236:
    ((View)localObject1).setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "updateEnterEffectStatus  isShow = " + paramBoolean);
    }
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[18];
    if (localFormSimpleItem == null) {
      return;
    }
    Object localObject1;
    if (paramBoolean)
    {
      bhbu.a("Grp_set_new", "grpData_admin", "specialEntrance_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      localFormSimpleItem.setVisibility(0);
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[17];
      if ((localObject1 != null) && ((localObject1 instanceof FormSimpleItem))) {
        ((FormSimpleItem)localObject1).setBgType(2);
      }
      Object localObject2 = (bfkw)this.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
      localObject1 = ((bfkw)localObject2).a();
      if (localObject1 == null) {
        break label209;
      }
      localObject2 = ((bfkw)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if ((localObject2 != null) && (((bfki)localObject2).jdField_a_of_type_Int > 0)) {
        localFormSimpleItem.setRightText(((bfki)localObject2).jdField_a_of_type_JavaLangString);
      }
    }
    else
    {
      localFormSimpleItem.setVisibility(8);
      return;
    }
    if (((bfkh)localObject1).b > 0)
    {
      localFormSimpleItem.setRightText(((bfkh)localObject1).jdField_a_of_type_JavaLangString);
      return;
    }
    localFormSimpleItem.setRightText(anvx.a(2131701239));
    return;
    label209:
    localFormSimpleItem.setRightText(anvx.a(2131701247));
  }
  
  protected boolean a()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "checkParams");
    }
    if (this.app == null) {
      return false;
    }
    boolean bool2 = bool3;
    try
    {
      this.jdField_c_of_type_Boolean = false;
      bool2 = bool3;
      this.jdField_a_of_type_Boolean = false;
      bool2 = bool3;
      Bundle localBundle = getIntent().getExtras();
      bool2 = bool3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = TroopUtils.initTroopInfoData(localBundle, this);
      bool2 = bool3;
      TroopInfo localTroopInfo = TroopUtils.initTroopInfo(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this);
      if (localTroopInfo != null)
      {
        bool2 = bool3;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopInfo;
      }
      bool2 = bool3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = localBundle.getString("troop_uin");
      bool2 = bool3;
      if (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) > 0L) {
        bool1 = true;
      }
      bool2 = bool1;
      this.jdField_h_of_type_Int = localBundle.getInt("D2GType");
      bool2 = bool1;
      this.jdField_l_of_type_Int = localBundle.getInt("filter_id", -1);
      bool2 = bool1;
      TroopUtils.mExposureSource = localBundle.getInt("exposureSource", 99);
      bool2 = bool1;
      this.jdField_k_of_type_Boolean = localBundle.getBoolean("fromThirdAppByOpenSDK");
      bool2 = bool1;
      this.jdField_b_of_type_JavaLangString = localBundle.getString("authKey");
      bool2 = bool1;
      this.jdField_c_of_type_JavaLangString = localBundle.getString("authSig");
      return bool1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, localException.toString());
      }
      nvs.a(this.app, 69);
    }
    return bool2;
  }
  
  void b()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      View localView = View.inflate(this, 2131562985, null);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131365022));
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView.findViewById(2131379099));
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[50];
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
      Object localObject = new AbsListView.LayoutParams(-1, -2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      localObject = new blha(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject);
      this.jdField_d_of_type_Boolean = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "intNewStyleUI mIsQidianPrivateTroop : " + this.jdField_d_of_type_Boolean + ", troopUin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      super.setContentView(localView);
      this.jdField_d_of_type_AndroidViewView = localView;
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130838911);
      this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131379078);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131379020));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131690785));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369278));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690785));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369231));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131694466) + getString(2131690673));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369245));
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131693259));
      bhbu.a("Grp_set_new", "grpData_admin", "share_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this, this.app);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
      d(localView);
      F();
      E();
      D();
      C();
      B();
      A();
      z();
      y();
      x();
      w();
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "initNewStyleUI  mIsQidianPrivateTroop = " + this.jdField_d_of_type_Boolean + ",time = " + (System.currentTimeMillis() - l1));
      }
      c(localView);
      b(false);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      finish();
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  protected void b(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra("ken_qun_photo_data_has_changed", true);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "resultForRequestQzonePhoto|needRereshed = " + bool);
      }
      if (bool) {
        n();
      }
    }
    ThreadManager.post(new ChatSettingForTroop.50(this), 8, null, true);
  }
  
  protected void b(View paramView)
  {
    if (paramView == null) {}
    TextView localTextView;
    do
    {
      return;
      localTextView = (TextView)paramView.findViewById(2131379001);
      paramView = paramView.findViewById(2131376668);
    } while ((localTextView == null) || (paramView == null) || (TextUtils.isEmpty(localTextView.getText())));
    int i1 = (int)localTextView.getPaint().measureText(localTextView.getText().toString());
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).leftMargin = (AIOUtils.dp2px(30.0F, getResources()) + i1);
  }
  
  public void b(List<oidb_0xe83.TabInfo> paramList)
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ArrayOfAndroidViewView[28];
    localViewGroup.removeAllViews();
    int i5 = 0;
    int i2 = 0;
    int i1 = 0;
    oidb_0xe83.TabInfo localTabInfo;
    String str1;
    String str2;
    String str3;
    int i6;
    View localView;
    Object localObject;
    int i3;
    if (i5 < paramList.size())
    {
      localTabInfo = (oidb_0xe83.TabInfo)paramList.get(i5);
      str1 = localTabInfo.name.get();
      str2 = localTabInfo.desc.get();
      str3 = localTabInfo.url.get();
      i6 = localTabInfo.num.get();
      if ((i1 == 0) && (localTabInfo.type.get() == 1))
      {
        localView = this.jdField_a_of_type_ArrayOfAndroidViewView[29];
        localObject = localView;
        if (localView == null)
        {
          localObject = new GameRankFormItem(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[29] = localObject;
        }
        ((GameRankFormItem)localObject).jdField_a_of_type_Int = i6;
        i1 = i2;
        i2 = 1;
        i3 = 29;
      }
    }
    for (;;)
    {
      label159:
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "game info tag=" + i3 + ", name=" + str1 + ", desc=" + str2 + ", num=" + i6);
      }
      int i4 = 2;
      if ((i5 == 0) && (paramList.size() == 1))
      {
        i4 = 0;
        label247:
        if (!(localObject instanceof TroopAppFormItem)) {
          break label536;
        }
        ((View)localObject).setTag(Integer.valueOf(i3));
        ((TroopAppFormItem)localObject).a(localTabInfo, i4);
        ((View)localObject).setOnClickListener(this);
      }
      for (;;)
      {
        ((View)localObject).setTag(2131378495, str3);
        ((View)localObject).setTag(2131378464, localTabInfo);
        localViewGroup.addView((View)localObject);
        i3 = i1;
        i1 = i2;
        i2 = i3;
        for (;;)
        {
          i5 += 1;
          break;
          if ((i2 == 0) && (localTabInfo.type.get() == 2))
          {
            localView = this.jdField_a_of_type_ArrayOfAndroidViewView[30];
            localObject = localView;
            if (localView == null)
            {
              localObject = new FormSimpleItem(this);
              this.jdField_a_of_type_ArrayOfAndroidViewView[30] = localObject;
            }
            i3 = 30;
            i4 = 1;
            i2 = i1;
            i1 = i4;
            break label159;
          }
          localObject = new TroopAppFormItem(this);
          if (localTabInfo.appid.get() == 1106837471L)
          {
            this.jdField_a_of_type_JavaLangString = TroopUtils.parseReadInJoyparams((View)localObject, localTabInfo);
            bhbu.a("Grp_set", "Grp_aio_subscription", "subscription_exp", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) });
            i3 = 1007;
            i4 = i1;
            i1 = i2;
            i2 = i4;
            break label159;
          }
          if (localTabInfo.appid.get() != 1106912788L) {
            break label576;
          }
        }
        if ((i5 == 0) && (paramList.size() > 1))
        {
          i4 = 1;
          break label247;
        }
        if (i5 != paramList.size() - 1) {
          break label247;
        }
        i4 = 3;
        break label247;
        label536:
        a(i3, i4, (FormSimpleItem)localObject, str1, str2, true);
      }
      if (i2 != 0) {
        ThreadManager.post(new ChatSettingForTroop.27(this), 5, null, true);
      }
      return;
      label576:
      i3 = 1007;
      i4 = i1;
      i1 = i2;
      i2 = i4;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i2 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mTroopInfoData is null!");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_b_of_type_Boolean)) {}
    for (int i1 = 0;; i1 = 8)
    {
      if (localObject != null) {
        ((View)localObject).setVisibility(i1);
      }
      localObject = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[6];
      if (localObject == null) {
        break;
      }
      if (i1 == 0) {
        i2 = 3;
      }
      ((FormSimpleItem)localObject).setBgType(i2);
      return;
    }
  }
  
  protected void c()
  {
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext())) {}
    aoep localaoep;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "initNetworkRequests");
      }
      localaoep = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      ArrayList localArrayList;
      if (localaoep != null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        localaoep.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, localArrayList);
      }
      if (localaoep != null)
      {
        n();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
          localaoep.a(localArrayList);
          localaoep.i(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
      this.jdField_a_of_type_Nxu = new nxu(this.app);
      P();
    } while (localaoep == null);
    localaoep.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false, this.jdField_j_of_type_Int, 1);
  }
  
  protected void c(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      if (paramIntent.getExtras().getBoolean("isNeedFinish"))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isNeedFinish", true);
        setResult(-1, paramIntent);
        finish();
        return;
      }
      if (paramIntent.getExtras().getBoolean("finish_chat_setting"))
      {
        finish();
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {}
    for (paramIntent = null;; paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      if ((paramIntent != null) && (paramIntent.wMemberNum != this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramIntent.Administrator, paramIntent.wMemberNum, this.app.getCurrentAccountUin(), getResources());
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + anvx.a(2131701248));
        }
      }
      if (this.jdField_e_of_type_JavaUtilList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "resultForTroopMemberList,memberListForCard.size = " + this.jdField_e_of_type_JavaUtilList.size());
        }
        a(this.jdField_e_of_type_JavaUtilList);
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager;
      if ((this.jdField_a_of_type_ArrayOfAndroidViewView[6] == null) || (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null)) {
        break;
      }
      ThreadManager.post(new ChatSettingForTroop.51(this, paramIntent), 8, null, true);
      return;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "init(), isInitialized = " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839466);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131298052));
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext())) {
      QQToast.a(getApplicationContext(), 1, getString(2131694255), 1).b(getTitleBarHeight());
    }
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adrs(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  protected void d(int paramInt, Intent paramIntent)
  {
    o();
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      ThreadManager.post(new ChatSettingForTroop.52(this, paramIntent), 8, null, true);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    String str;
    boolean bool1;
    long l1;
    switch (paramInt1)
    {
    default: 
    case 145: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    case 9: 
    case 11: 
    case 8: 
    case 12: 
    case 13: 
    case 10: 
    case 6: 
    case 4: 
    case 15: 
    case 18: 
    case 16: 
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
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                          str = bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
                          if (paramInt2 == -1) {}
                          for (paramIntent = "0";; paramIntent = "1")
                          {
                            bhbu.a("Grp_share", "grpData_admin", "share_qzone", 0, 0, new String[] { localObject, str, paramIntent });
                            return;
                          }
                        } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("select_member_add_request_ok", false)));
                        this.u = true;
                        return;
                        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
                        {
                          paramIntent = new Intent();
                          paramIntent.putExtra("isNeedFinish", true);
                          setResult(-1, paramIntent);
                          finish();
                          return;
                        }
                        if (this.jdField_a_of_type_ArrayOfAndroidViewView[6] != null) {
                          ThreadManager.post(new ChatSettingForTroop.53(this), 8, null, true);
                        }
                        g();
                        return;
                        a(paramInt2, paramIntent);
                        return;
                      } while (paramInt2 != -1);
                      setResult(-1);
                      this.jdField_m_of_type_Boolean = true;
                      return;
                      b(paramInt2, paramIntent);
                      return;
                      c(paramInt2, paramIntent);
                      return;
                      ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).g(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                      return;
                      d(paramInt2, paramIntent);
                      e(paramInt2, paramIntent);
                      return;
                    } while ((paramIntent == null) || (paramIntent.getExtras() == null) || (paramInt2 != -1));
                    paramIntent = paramIntent.getExtras();
                    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = paramIntent.getString("location");
                    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat = paramIntent.getInt("lat", 0);
                    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon = paramIntent.getInt("lon", 0);
                    l();
                    return;
                  } while (paramInt2 != -1);
                  if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
                  {
                    paramIntent = new Intent();
                    paramIntent.putExtra("isNeedFinish", true);
                    setResult(-1, paramIntent);
                  }
                  finish();
                  return;
                } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("has_operation", false)));
                this.jdField_a_of_type_AndroidContentIntent = paramIntent;
                return;
              } while (paramInt2 != -1);
              paramIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
              paramIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName());
              paramIntent.putExtra("uintype", 1);
              startActivity(paramIntent);
              setResult(-1);
              finish();
              return;
              e(paramInt2, paramIntent);
              return;
              paramIntent = (bfkw)this.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
              if (QLog.isColorLevel()) {
                QLog.d("Q.chatopttroop", 2, "doOnActivityResult REQUEST_FOR_ENTER_EFFECT_SETTING  effectManager.isAllTroopShowEnterance() = " + paramIntent.b());
              }
            } while (!paramIntent.b());
            a(true);
            return;
            bool1 = paramIntent.getBooleanExtra("disabled", true);
            localObject = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[41];
          } while (localObject == null);
          if (bool1) {}
          for (paramIntent = getResources().getString(2131695936);; paramIntent = getResources().getString(2131695937))
          {
            ((FormSimpleItem)localObject).setRightText(paramIntent);
            return;
          }
        } while ((paramInt2 != -1) || (paramIntent == null));
        if (!NetworkUtil.isNetworkAvailable(this))
        {
          QQToast.a(this, 1, 2131694256, 0).b(getTitleBarHeight());
          return;
        }
        paramIntent = paramIntent.getStringExtra("result");
      } while ((TextUtils.isEmpty(paramIntent)) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname)));
      localObject = (anrb)this.app.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      bool1 = bool2;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1) {
          bool1 = true;
        }
      }
      ((anrb)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramIntent, bool1);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetTroopHead())) {
        this.jdField_e_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.oldTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramIntent;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName();
      f();
      return;
    case 17: 
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      l1 = 0L;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        bool1 = paramIntent.getBooleanExtra("updateFromWeb", false);
        localObject = paramIntent.getStringExtra("lastAnnouncement");
        l1 = paramIntent.getLongExtra("groupCode", 0L);
        if ((bool1) && (TextUtils.equals(str, String.valueOf(l1))))
        {
          paramIntent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
          paramIntent.what = 20;
          paramIntent.obj = localObject;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIntent);
          paramIntent = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramIntent.b(str);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.updateLastMemoFromWeb((String)localObject);
            paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
          }
        }
      }
      break;
    }
    for (paramIntent = (Intent)localObject; QLog.isColorLevel(); paramIntent = (Intent)localObject)
    {
      QLog.i("Q.chatopttroop", 2, String.format("doOnActivityResult get last memo [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(bool1), str, Long.valueOf(l1), paramIntent }));
      return;
      v();
      return;
      bool1 = false;
    }
  }
  
  public void doOnBackPressed()
  {
    ah();
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    ImmersiveUtils.a(true, getWindow());
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("appid");
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("openid");
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("share_uin");
    this.jdField_h_of_type_JavaLangString = getIntent().getStringExtra("is_from_game");
    if (("true".equals(this.jdField_h_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
    {
      TroopUtils.checkApiState(this.app, getApplicationContext(), this.jdField_e_of_type_JavaLangString, this, 0, null);
      this.jdField_i_of_type_JavaLangString = getIntent().getStringExtra("guild_id");
      this.jdField_j_of_type_JavaLangString = getIntent().getStringExtra("zone_id");
      this.jdField_k_of_type_JavaLangString = getIntent().getStringExtra("role_id");
      this.jdField_l_of_type_JavaLangString = getIntent().getStringExtra("gc");
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "joinGroup appid = " + this.jdField_e_of_type_JavaLangString + " openid = " + this.jdField_f_of_type_JavaLangString + " guild id = " + this.jdField_i_of_type_JavaLangString + "zone_id = " + this.jdField_j_of_type_JavaLangString + " role id = " + this.jdField_k_of_type_JavaLangString + "  group code= " + this.jdField_l_of_type_JavaLangString);
      }
      paramBundle = String.valueOf(this.jdField_e_of_type_JavaLangString);
      if ((TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) || (this.jdField_g_of_type_JavaLangString.equals(this.app.getAccount()))) {
        break label401;
      }
      t();
      label313:
      if (!QLog.isColorLevel()) {
        break label1265;
      }
    }
    label401:
    label1265:
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      Object localObject;
      if (!a())
      {
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)) {
          QLog.i("Q.chatopttroop", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        finish();
        return false;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.chatopttroop", 2, " joinGroup is from game = false");
        break;
        if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
          break label313;
        }
        localObject = this.app.getMsgHandler().a(paramBundle);
        if (localObject == null)
        {
          p();
          this.jdField_b_of_type_AndroidOsHandler = new Handler();
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(new ChatSettingForTroop.2(this), 3000L);
          this.app.addObserver(this.jdField_a_of_type_Nwk);
          this.app.getMsgHandler().d(paramBundle);
          break label313;
        }
        if (this.jdField_f_of_type_JavaLangString.equals(((OpenID)localObject).openID)) {
          break label313;
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.chatopttroop", 2, "-->preForward--openid doesn't equal current local openid");
        }
        t();
        break label313;
      }
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
      for (;;)
      {
        try
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
            TroopUtils.checkIsShowCacheAppInfos(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaUtilArrayList);
          }
          paramBundle = (bfya)aqxe.a().a(696);
          if (paramBundle != null) {
            this.jdField_f_of_type_Boolean = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          }
          this.jdField_a_of_type_Bhhi = ((bhhi)this.app.getManager(QQManagerFactory.MGR_TROOP_FILTER));
          if (bggj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
          {
            b();
            a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
            if (!b()) {
              L();
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
            }
            ThreadManager.getSubThreadHandler().post(new ChatSettingForTroop.3(this));
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
              {
                paramBundle = "0";
                a("Grp_Admin_data", "Clk_data", paramBundle);
              }
            }
            else
            {
              nvs.a(this.app, 65);
              paramBundle = new IntentFilter();
              paramBundle.addAction("start_recomend_page");
              paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
              paramBundle.addAction("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER");
              registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
              addObserver(this.jdField_d_of_type_Aofu);
              addObserver(this.jdField_c_of_type_Aofu);
              TroopUtils.preloadWebProcess(this.app);
              this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER));
              paramBundle = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
              if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null))
              {
                paramBundle = paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                if ((paramBundle != null) && (paramBundle.isGameBind())) {
                  bhbu.a("Grp_game", "Grp_data", "data_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
                }
              }
              this.app.addObserver(this.jdField_a_of_type_Bhow);
              VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_1", "", 1, 0, 0, "", "", "");
              bdla.b(this.app, "dc00898", "", "", "0X800A523", "0X800A523", 0, 0, "", "", "", "");
              bdla.b(this.app, "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_exp", 0, 0, "", "", "", "");
              if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
              {
                boolean bool = bhdf.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
                paramBundle = (beuq)aqxe.a().a(664);
                localObject = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
                if ((paramBundle != null) && (paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) && (localObject != null) && (bool)) {
                  ((aoep)localObject).A(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                }
              }
              this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("focusItem");
              if (this.jdField_f_of_type_Boolean) {
                v();
              }
              return true;
            }
          }
          else
          {
            a();
            continue;
          }
          paramBundle = "1";
        }
        catch (OutOfMemoryError paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.chatopttroop", 2, "initUI got OOM, e:" + paramBundle.getMessage());
          }
          System.gc();
          finish();
          return false;
        }
        catch (InflateException paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.chatopttroop", 2, "init UI got InflateException, e:" + paramBundle.getMessage());
          }
          System.gc();
          finish();
          return false;
        }
      }
    }
  }
  
  /* Error */
  public void doOnDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 2001	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   4: ifnull +14 -> 18
    //   7: aload_0
    //   8: getfield 2001	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   11: invokevirtual 3807	android/widget/Button:getBackground	()Landroid/graphics/drawable/Drawable;
    //   14: aconst_null
    //   15: invokevirtual 3810	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 3812	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_g_of_type_Boolean	Z
    //   23: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +409 -> 435
    //   29: invokestatic 1252	java/lang/System:currentTimeMillis	()J
    //   32: lstore_1
    //   33: ldc 2
    //   35: monitorenter
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 3244	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Boolean	Z
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: getfield 1269	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder	Lcom/tencent/mobileqq/app/face/FaceDecoder;
    //   48: ifnull +10 -> 58
    //   51: aload_0
    //   52: getfield 1269	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder	Lcom/tencent/mobileqq/app/face/FaceDecoder;
    //   55: invokevirtual 3815	com/tencent/mobileqq/app/face/FaceDecoder:destory	()V
    //   58: aload_0
    //   59: getfield 613	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bgnx	Lbgnx;
    //   62: ifnull +10 -> 72
    //   65: aload_0
    //   66: getfield 613	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bgnx	Lbgnx;
    //   69: invokevirtual 3816	bgnx:a	()V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 229	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Nwk	Lnwk;
    //   77: invokevirtual 3819	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 212	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Anvi	Lanvi;
    //   85: invokevirtual 3819	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 217	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Anrc	Lanrc;
    //   93: invokevirtual 3819	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 202	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_Aofu	Laofu;
    //   101: invokevirtual 3819	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 197	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Aofu	Laofu;
    //   109: invokevirtual 3819	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 154	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Aofu	Laofu;
    //   117: invokevirtual 3819	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   120: aload_0
    //   121: aload_0
    //   122: getfield 207	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Aofu	Laofu;
    //   125: invokevirtual 3819	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   128: aload_0
    //   129: getfield 258	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   132: aload_0
    //   133: getfield 239	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bhow	Lbhow;
    //   136: invokevirtual 3820	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   139: aload_0
    //   140: getfield 192	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   143: ifnull +11 -> 154
    //   146: aload_0
    //   147: getfield 192	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   150: aconst_null
    //   151: invokevirtual 3823	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   154: aload_0
    //   155: getfield 3436	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   158: ifnull +30 -> 188
    //   161: aload_0
    //   162: getfield 3436	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   165: checkcast 3445	android/graphics/drawable/Animatable
    //   168: invokeinterface 3826 1 0
    //   173: ifeq +15 -> 188
    //   176: aload_0
    //   177: getfield 3436	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   180: checkcast 3445	android/graphics/drawable/Animatable
    //   183: invokeinterface 3829 1 0
    //   188: aload_0
    //   189: getfield 1267	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   192: ifnull +20 -> 212
    //   195: aload_0
    //   196: getfield 1267	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   199: invokevirtual 3830	android/app/Dialog:isShowing	()Z
    //   202: ifeq +10 -> 212
    //   205: aload_0
    //   206: getfield 1267	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidAppDialog	Landroid/app/Dialog;
    //   209: invokevirtual 3831	android/app/Dialog:dismiss	()V
    //   212: aload_0
    //   213: invokestatic 3836	bgst:a	(Landroid/content/Context;)Lbgst;
    //   216: invokevirtual 3837	bgst:a	()V
    //   219: aload_0
    //   220: getfield 3839	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bisl	Lbisl;
    //   223: ifnull +10 -> 233
    //   226: aload_0
    //   227: getfield 3839	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bisl	Lbisl;
    //   230: invokevirtual 3842	bisl:dismiss	()V
    //   233: aload_0
    //   234: getfield 1044	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Nxu	Lnxu;
    //   237: ifnull +10 -> 247
    //   240: aload_0
    //   241: getfield 1044	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Nxu	Lnxu;
    //   244: invokevirtual 3843	nxu:a	()V
    //   247: aload_0
    //   248: aload_0
    //   249: getfield 163	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   252: invokevirtual 3847	com/tencent/mobileqq/activity/ChatSettingForTroop:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   255: aload_0
    //   256: getfield 3663	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   259: ifnull +11 -> 270
    //   262: aload_0
    //   263: getfield 3663	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   266: aconst_null
    //   267: invokevirtual 3823	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   270: aload_0
    //   271: aconst_null
    //   272: putfield 3849	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   275: aload_0
    //   276: getfield 2009	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView	Lcom/tencent/mobileqq/widget/QQBlurView;
    //   279: ifnull +10 -> 289
    //   282: aload_0
    //   283: getfield 2009	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView	Lcom/tencent/mobileqq/widget/QQBlurView;
    //   286: invokevirtual 3851	com/tencent/mobileqq/widget/QQBlurView:c	()V
    //   289: aload_0
    //   290: getfield 1152	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bgua	Lbgua;
    //   293: ifnull +10 -> 303
    //   296: aload_0
    //   297: getfield 1152	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bgua	Lbgua;
    //   300: invokevirtual 1156	bgua:e	()V
    //   303: aload_0
    //   304: invokespecial 1179	com/tencent/mobileqq/activity/ChatSettingForTroop:W	()V
    //   307: aload_0
    //   308: invokespecial 3853	com/tencent/mobileqq/app/BaseActivity:doOnDestroy	()V
    //   311: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq +34 -> 348
    //   317: ldc_w 631
    //   320: iconst_2
    //   321: new 546	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 547	java/lang/StringBuilder:<init>	()V
    //   328: ldc_w 3855
    //   331: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokestatic 1252	java/lang/System:currentTimeMillis	()J
    //   337: lload_1
    //   338: lsub
    //   339: invokevirtual 1890	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   342: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 650	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: return
    //   349: astore_3
    //   350: ldc 2
    //   352: monitorexit
    //   353: aload_3
    //   354: athrow
    //   355: astore_3
    //   356: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq -104 -> 255
    //   362: ldc_w 631
    //   365: iconst_2
    //   366: new 546	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 547	java/lang/StringBuilder:<init>	()V
    //   373: ldc_w 3857
    //   376: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_3
    //   380: invokevirtual 3858	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   383: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 1444	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: goto -137 -> 255
    //   395: astore_3
    //   396: invokestatic 629	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq -144 -> 255
    //   402: ldc_w 631
    //   405: iconst_2
    //   406: new 546	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 547	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 3857
    //   416: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload_3
    //   420: invokevirtual 3859	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   423: invokevirtual 553	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 1444	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: goto -177 -> 255
    //   435: lconst_0
    //   436: lstore_1
    //   437: goto -404 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	ChatSettingForTroop
    //   32	405	1	l1	long
    //   349	5	3	localObject	Object
    //   355	25	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   395	25	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   36	44	349	finally
    //   350	353	349	finally
    //   247	255	355	java/lang/IllegalArgumentException
    //   247	255	395	java/lang/Exception
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
    }
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    URLDrawable.resume();
    int i1;
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
      i1 = 1;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (i1 != 0) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
        this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      }
      aoep localaoep = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      Object localObject;
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_l_of_type_Boolean = false;
        String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        String str2 = bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
        {
          localObject = "1";
          label145:
          bhbu.a("Grp_set_new", "grpData_admin", "exp", 0, 0, new String[] { str1, str2, localObject });
          label178:
          if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (!bghs.a(this.app))) {}
        }
      }
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (localaoep != null) {
          localaoep.g(l1);
        }
        if (this.t)
        {
          k(true);
          this.t = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
        ag();
        ae();
        bdla.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F6", 0, 1, 0, "", "", "", "");
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[40] != null) {
          I();
        }
        G();
        H();
        return;
        i1 = 0;
        continue;
        localObject = "0";
        break label145;
        localObject = (bgig)this.app.getManager(QQManagerFactory.TROOP_APP_MGR);
        if ((localObject != null) && (((bgig)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) && (localaoep != null)) {
          localaoep.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true, this.jdField_j_of_type_Int, 1);
        }
        if (!this.s) {
          break label178;
        }
        n();
        this.s = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Q.chatopttroop", 2, "onResume  parseLong err", localException);
          long l1 = 0L;
        }
      }
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (!this.jdField_h_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStart add observer");
      }
      addObserver(this.jdField_a_of_type_Anvi);
      addObserver(this.jdField_a_of_type_Anrc);
      addObserver(this.jdField_a_of_type_Aofu);
      addObserver(this.jdField_b_of_type_Aofu);
      addObserver(this.jdField_c_of_type_Aofu);
      this.jdField_h_of_type_Boolean = true;
    }
    if (this.jdField_i_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = false;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_h_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStop remove observer");
      }
      removeObserver(this.jdField_a_of_type_Anvi);
      removeObserver(this.jdField_b_of_type_Aofu);
      this.jdField_h_of_type_Boolean = false;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected void e()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[23];
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    localObject = (TextView)((View)localObject).findViewById(2131379524);
    ((TextView)localObject).setTag(Integer.valueOf(39));
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i1 = 0;
    }
    if (i1 > 0)
    {
      String str = String.format(getResources().getString(2131693281), new Object[] { Integer.valueOf(i1) });
      ((TextView)localObject).setText(str);
      ((TextView)localObject).setContentDescription(str);
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Boolean) {
        ((TextView)localObject).setVisibility(8);
      }
      ((TextView)localObject).setOnClickListener(this);
      return;
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  protected void e(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (paramIntent == null);
      bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      String str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.", 2, "ChatSettingActivity|onActivityResult|REQUEST_FOR_TROOP_DISBAND|isNeedFinish = " + bool + ", strTip = " + str);
      }
      if ((!TextUtils.isEmpty(str)) && (bool))
      {
        if (this.jdField_a_of_type_Biso == null) {
          this.jdField_a_of_type_Biso = new biso(this);
        }
        this.jdField_a_of_type_Biso.a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.isEmpty(paramIntent)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopOwner(paramIntent, this.app.getCurrentAccountUin());
        }
        as();
        Q();
        if (this.jdField_a_of_type_Biso == null) {
          this.jdField_a_of_type_Biso = new biso(this);
        }
        this.jdField_a_of_type_Biso.a(1, str, 1000);
        return;
      }
    } while (!bool);
    paramIntent = new Intent();
    paramIntent.putExtra("isNeedFinish", true);
    setResult(-1, paramIntent);
    finish();
  }
  
  public void f()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[14];
    String str;
    if (localView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {
        break label249;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
      localView.setOnClickListener(this);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        StringBuilder localStringBuilder = new StringBuilder().append(anvx.a(2131701232)).append(str);
        if (!bool) {
          break label259;
        }
        localObject = anvx.a(2131701221);
        label85:
        localView.setContentDescription((String)localObject);
      }
      a(localView, new begq(str, 32).a(), null, null);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateTroopNameEntry %s", new Object[] { str }));
      }
    }
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[36];
    if (localObject != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
      if (!TextUtils.isEmpty(str)) {
        break label265;
      }
      str = anvx.a(2131701249);
    }
    label259:
    label265:
    for (;;)
    {
      ((TextView)localObject).setText(str);
      if (AppSetting.jdField_c_of_type_Boolean) {
        ((View)localObject).setContentDescription(anvx.a(2131701216) + str);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateHostTroopNameEntry %s", new Object[] { str }));
      }
      return;
      label249:
      str = anvx.a(2131701259);
      break;
      localObject = "";
      break label85;
    }
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      if ("updateShowFace  memberUins.size = " + this.jdField_d_of_type_JavaUtilList == null) {
        break label121;
      }
    }
    label121:
    for (int i1 = this.jdField_d_of_type_JavaUtilList.size();; i1 = -1)
    {
      QLog.d("Q.chatopttroop", 2, new Object[] { Integer.valueOf(i1) });
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.jdField_c_of_type_Int, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int, this.jdField_f_of_type_Int);
        if (this.jdField_a_of_type_Adth != null) {
          break;
        }
        this.jdField_a_of_type_Adth = new adth(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Adth);
      }
      return;
    }
    this.jdField_a_of_type_Adth.notifyDataSetChanged();
  }
  
  protected void h()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.canInviteMember()) {
      return;
    }
    SharedPreferences localSharedPreferences = getSharedPreferences("last_update_time" + this.app.getCurrentAccountUin(), 4);
    long l1 = localSharedPreferences.getLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0L);
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "TroopMemberList lastUpdateTime:" + l1);
    }
    if (l1 == 0L)
    {
      aoep localaoep = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (localaoep != null) {
        localaoep.a(true, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, 6);
      }
      localSharedPreferences.edit().putLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, System.currentTimeMillis()).commit();
    }
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 5, null, false);
  }
  
  protected void i()
  {
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label187;
      }
      bghd.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "troopProfile");
      bdla.b(this.app, "P_CliOper", "Grp_edu", "", "Grp_data", "mbercard_Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    }
    for (;;)
    {
      bdla.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_modifydata", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      bhbu.a("Grp_set_new", "grpData_admin", "clk_modifydata", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_2", "", 1, 0, 0, "", "", "");
      return;
      i1 = 0;
      break;
      label187:
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick;
      Intent localIntent = new Intent(this, EditInfoActivity.class);
      localIntent.putExtra("edit_type", 0);
      localIntent.putExtra("title", getString(2131697317));
      localIntent.putExtra("default_text", str);
      localIntent.putExtra("default_nick_id", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNickId);
      localIntent.putExtra("isTroopNick", true);
      localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uin", this.app.getAccount());
      localIntent.putExtra("max_num", 60);
      localIntent.putExtra("from", 0);
      startActivityForResult(localIntent, 2);
    }
  }
  
  protected void j()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = TroopMemberListActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
    ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
    startActivityForResult((Intent)localObject, 9);
    localObject = "2";
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        localObject = "0";
      }
      for (;;)
      {
        bdla.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", (String)localObject, "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject = "1";
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 15) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 10) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 11)) {
      bdla.b(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon != 0))
    {
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", String.format("https://nearby.qq.com/hot_chat/qun_class.html?_wv=1031&latitude=%1$s&longitude=%2$s", new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat / 1000000.0D), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon / 1000000.0D) }));
      startActivity(localIntent);
      a("Grp", "Clk_grp_map", "0");
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
    {
      Intent localIntent;
      return;
    }
    bdla.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    TroopLocationModifyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 12);
  }
  
  public void l()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[11];
    if (localView != null)
    {
      if (((localView instanceof FormSimpleItem)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation)))
      {
        localView.setVisibility(0);
        a(11, 3, (FormSimpleItem)localView, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, null, true);
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  public void m()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[22];
    if (localView != null)
    {
      if (((localView instanceof FormSimpleItem)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo)))
      {
        localView.setVisibility(0);
        a(22, 1, (FormSimpleItem)localView, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthenticateInfo, null, true);
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  protected void n()
  {
    aoep localaoep = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localaoep == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
          break label115;
        }
        localaoep.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 1000L, "getGroupInfoFromChatSettingForTroop");
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
          break label135;
        }
        localaoep.c(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.chatopttroop", 2, localException.toString());
      return;
      label115:
      localException.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1000L, "getGroupInfoFromChatSettingForTroop");
    }
    label135:
    localException.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "refreshTroopBasicInfo");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, getResources(), this.app.getCurrentAccountUin());
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = false;
        TroopUtils.updateTroopInfoToDB(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
      }
    }
    f();
    ac();
    r();
    if (!this.jdField_d_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop);
      return;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = paramCompoundButton.getTag();
    if (!(localObject instanceof Integer)) {}
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      switch (((Integer)localObject).intValue())
      {
      default: 
        break;
      case 7: 
        h(paramBoolean);
        break;
      case 19: 
        j(paramBoolean);
        break;
      case 10: 
        i(paramBoolean);
        break;
      case 31: 
        a(1, paramBoolean);
        break;
      case 47: 
        f(paramBoolean);
        break;
      case 48: 
        g(paramBoolean);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    int i1;
    if (paramView == null)
    {
      localObject1 = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && ((localObject1 instanceof Integer))) {
        i1 = ((Integer)localObject1).intValue();
      }
    }
    Object localObject3;
    label434:
    Object localObject4;
    Object localObject5;
    Object localObject6;
    switch (i1)
    {
    default: 
    case 4: 
    case 6: 
    case 0: 
    case 2: 
    case 3: 
    case 22: 
    case 39: 
    case 9: 
    case 1001: 
    case 1010: 
    case 1006: 
    case 1008: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = paramView.getTag();
        break;
        if ((arjy.c().mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
        {
          bool = aofp.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
            if (bool)
            {
              i1 = 15;
              localObject4 = VipUtils.a(0, i1).toString();
              localObject5 = anvx.a(2131701231);
              localObject6 = new adrz(this, bool);
              if (!bool) {
                break label534;
              }
              localObject1 = "0X800A57F";
              if (!bool) {
                break label542;
              }
              i1 = 1;
              VipUtils.a(this, (String)localObject3, (String)localObject4, (String)localObject5, (DialogInterface.OnClickListener)localObject6, (String)localObject1, i1, bool);
            }
          }
          for (;;)
          {
            bdla.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
            break;
            i1 = 8;
            break label434;
            localObject1 = "0X8009E38";
            break label474;
            i1 = 3;
            break label481;
            VipUtils.a(this, bool);
          }
        }
        Y();
        continue;
        i();
        continue;
        j();
        a("Grp_Admin_data", "Clk_mber", "");
        bhbu.a("Grp_set_new", "grpData_admin", "clk_mber", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        continue;
        h();
        bhbu.a("Grp_set_new", "grpData_admin", "clk_invite_new", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        continue;
        localObject1 = paramView.getTag(2131378479);
        if ((localObject1 instanceof String))
        {
          localObject1 = (String)localObject1;
          if (((bgls)this.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).b((String)localObject1))
          {
            bghs.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject1);
          }
          else
          {
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("selfSet_leftViewText", getString(2131719641));
            ((Bundle)localObject3).putString("custom_leftbackbutton_name", getTitle().toString());
            azry.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject1, 1, -1, (Bundle)localObject3);
            continue;
            localObject1 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
            localObject3 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
            ((Intent)localObject3).putExtra("url", (String)localObject1);
            startActivity((Intent)localObject3);
            bdla.b(this.app, "dc00899", "Grp_certified", "", "data", "clk_data", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum) {
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {}
            for (i1 = 0;; i1 = 1)
            {
              localObject1 = new Intent(this, PublicAccountBrowser.class);
              ((Intent)localObject1).putExtra("hide_operation_bar", true);
              ((Intent)localObject1).putExtra("hideRightButton", true);
              ((Intent)localObject1).putExtra("isScreenOrientationPortrait", true);
              ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
              ((Intent)localObject1).putExtra("url", "https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum + "&show_level=" + i1);
              startActivity((Intent)localObject1);
              bdla.b(this.app, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
              nvs.a(this.app, 72);
              break;
            }
            U();
            bhbu.a("Grp_msg", "grpData_admin", "Clk_msgSet", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            continue;
            ChatHistoryActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1001);
            bdla.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_chatrecord", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            bhbu.a("Grp_set_new", "grpData_admin", "clk_chatRecord", 1, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            bdla.b(this.app, "dc00898", "", "", "0X800A0B8", "0X800A0B8", 0, 0, "", "", "", "");
            continue;
            bhbu.a("Grp_set_new", "grpData_admin", "grpNotice_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            ((Intent)localObject1).putExtra("uintype", 1);
            MessageNotificationSettingFragment.a(this, (Intent)localObject1);
            continue;
            localObject1 = TroopMemberListActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 19);
            ((Intent)localObject1).putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
            startActivityForResult((Intent)localObject1, 9);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin());
            bhbu.a("Grp_edu", "Grp_data", "teachermsg_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a((TroopMemberInfo)localObject1) });
            continue;
            QQToast.a(this, anvx.a(2131701225), 0).a();
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("extra.GROUP_UIN", this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
            EntryDebugFragment.a(this, (Bundle)localObject1);
          }
        }
      }
    case 1002: 
      d(false);
      if (this.jdField_h_of_type_Int == 2) {
        bdla.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      }
      i1 = getIntent().getIntExtra("extra_share_group_from", 0);
      if (i1 != 0) {
        ykv.a("story_grp", "clk_msg", i1, 0, new String[0]);
      }
      localObject1 = this.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
      for (i1 = 1;; i1 = 2)
      {
        bdla.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800A526", "0X800A526", i1, 0, TroopUtils.getExposureSourceReportVal() + "", "", "", "");
        break;
      }
    case 5: 
      label474:
      label481:
      TroopUtils.setRedPointSP("RED_POINT_KEY_TROOP_ADMIN");
      label534:
      label542:
      if (this.p) {
        TroopUtils.setRedPointSP("RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
      }
      if (this.q) {
        TroopUtils.setRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY" + this.app.getCurrentAccountUin());
      }
      TroopUtils.updateRedPoint(false, (TextView)paramView.findViewById(2131376668));
      localObject4 = new Intent();
      ((Intent)localObject4).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject4).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((Intent)localObject4).putExtra("forward_location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
      ((Intent)localObject4).putExtra("forward_latitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
      ((Intent)localObject4).putExtra("forward_longitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
      ((Intent)localObject4).putExtra("forward_cityid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId);
      ((Intent)localObject4).putExtra("troop_auth_submit_time", this.jdField_i_of_type_Int);
      ((Intent)localObject4).putExtra("leftViewText", getResources().getString(2131690784));
      ((Intent)localObject4).putExtra("key_qidian_private_troop", this.jdField_d_of_type_Boolean);
      ((Intent)localObject4).putExtra("key_is_update_before_805", TroopUtils.isUpdateBeforeSomeVersion(this, "8.0.5"));
      localObject1 = (bfwu)this.app.getManager(QQManagerFactory.TROOP_HONOR_MANAGER);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        ((Intent)localObject4).putExtra("key_support_troop_honor", ((bfwu)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin));
      }
      break;
    }
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop();; bool = false)
    {
      label2658:
      long l1;
      for (;;)
      {
        ((Intent)localObject4).putExtra("key_customed_troop", bool);
        if (bool) {
          abuf.a(null, "846", "205605", "", "84601", "1", "145");
        }
        localObject3 = this.jdField_a_of_type_Argu;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = argv.a();
          this.jdField_a_of_type_Argu = ((argu)localObject1);
        }
        ((Intent)localObject4).putExtra("autoApprovalUrl", ((argu)localObject1).jdField_b_of_type_JavaLangString);
        ((Intent)localObject4).putExtra("frequencyLimitVisible", ((argu)localObject1).jdField_a_of_type_Boolean);
        ((Intent)localObject4).putExtra("key_is_need_update_Group_info", true);
        if ((QLog.isDevelopLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)) {
          QLog.i("TroopMngTest", 4, String.format("start troop mng [flag: %s, msgLimitFreq: %s]", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupFlagExt3 & 0x100000), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.nMsgLimitFreq) }));
        }
        ((Intent)localObject4).putExtra("troop_manager_edit_red_show", c());
        ((Intent)localObject4).putExtra("troop_manager_edit_current_uin", this.app.getCurrentUin());
        localObject1 = TroopBaseProxyActivity.a(this);
        localObject3 = new bmiu(this.app);
        localObject5 = PluginCommunicationHandler.getInstance();
        if (localObject5 != null) {
          ((PluginCommunicationHandler)localObject5).register((RemoteCommand)localObject3);
        }
        TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, this, (Intent)localObject4, (Dialog)localObject1, "com.tencent.mobileqq.activity.TroopManageActivity", this.app.getCurrentAccountUin(), 8);
        localObject3 = this.app;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
        for (localObject1 = "0";; localObject1 = "1")
        {
          bdla.b((QQAppInterface)localObject3, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, (String)localObject4, (String)localObject1, "", "");
          bhbu.a("Grp_set_new", "grpData_admin", "clk_manageGrp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
          break;
        }
        bdla.b(this.app, "P_CliOper", "Grp_payjoin", "", "join_grp", "Clk_data", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
        ajfq.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "");
        bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
        break;
        TroopUtils.joinGroupOneStep(this.app, this, getIntent(), this);
        bdla.b(this.app, "CliOper", "", "", "0x80084B4", "0x80084B4", 0, 0, "", "", "", "");
        bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
        break;
        localObject1 = this.app;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
        for (i1 = 1;; i1 = 2)
        {
          bdla.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800A527", "0X800A527", i1, 0, TroopUtils.getExposureSourceReportVal() + "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 34) {
            break label2688;
          }
          if (!aslo.a(this.app.getCurrentAccountUin())) {
            break label2658;
          }
          localObject1 = astl.a(this);
          if (!isFinishing())
          {
            ((Dialog)localObject1).show();
            bdla.b(this.app, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
          }
          break;
        }
        bdla.b(this.app, "dc00898", "", "", "0X80092D7", "0X80092D7", 0, 0, "", "", "", "");
        label2688:
        TroopUtils.secRecognize(false, null);
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) {
            d(1);
          }
          for (;;)
          {
            break;
            ad();
          }
        }
        TroopUtils.calJoinTroop(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, TroopUtils.mExposureSource, this.jdField_l_of_type_Int, 2);
        if (!NetworkUtil.isNetSupport(this))
        {
          a(2131694253, 1);
          break;
        }
        localObject1 = (aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
        if (localObject1 != null) {}
        try
        {
          l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          p();
          ((aoep)localObject1).a(l1, 8390784);
          if (super.getIntent().getBooleanExtra("from_babyq", false)) {
            bdla.b(this.app, "dc00898", "", "", "0X8007246", "0X8007246", 0, 0, "", "", "", "");
          }
          bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, localException.toString());
            }
          }
        }
      }
      k();
      break;
      TroopUtils.startChatBackgroundSettingActivity(this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 6);
      bdla.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
      bdla.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Set_chatBG", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      bhbu.a("Grp_set_new", "grpData_admin", "set_chatBG", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      break;
      localObject3 = (bhsu)((FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[40]).getTag(2131375046);
      if (localObject3 != null)
      {
        l1 = ((bhsu)localObject3).jdField_a_of_type_Long;
        ((bhsu)localObject3).jdField_a_of_type_Long = SystemClock.uptimeMillis();
        if (((bhsu)localObject3).jdField_a_of_type_Long < l1 + 1000L) {
          break;
        }
        bhzf.a(this.app, "troop_keyword_expire_list_" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, ((bhsu)localObject3).jdField_b_of_type_JavaLangString);
        bhzf.b(this.app, "troop_keyword_guide_clicked", true);
        localObject2 = bhnp.a("groupkeywords").replace("[groupid]", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop.troop.special_msg.keyword", 2, "onClick: " + (String)localObject2);
        }
        bdla.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F8", ((bhsu)localObject3).jdField_c_of_type_Int, 1, 0, "", "", "", "");
        localObject3 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject3).putExtra("url", (String)localObject2);
        ((Intent)localObject3).putExtra("isShowAd", false);
        startActivity((Intent)localObject3);
        break;
      }
      QLog.e("Q.chatopttroop.troop.special_msg.keyword", 1, "onClick status is null");
      break;
      bhbu.a("Grp_set_new", "grpData_admin", "specialEntrance_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      Object localObject2 = new Intent(this, QQBrowserActivity.class);
      localObject3 = bhnp.a("troopEnterEffect");
      ((Intent)localObject2).putExtra("url", (String)localObject3 + "&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      startActivityForResult((Intent)localObject2, 15);
      bfkw.a("grp_data", "entry_clk", new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      i1 = ((bfkw)this.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "style", "0X8008E62", "", 1, 0, 0, "", Integer.toString(i1), "");
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin != null)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
      }
      if (bhdf.b(this.app.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false))
      {
        bhdf.a(this.app.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
        bhdf.b(this.app.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true);
        localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[23];
        if (localObject2 != null)
        {
          localObject2 = (TextView)((View)localObject2).findViewById(2131376668);
          if (localObject2 != null) {
            TroopUtils.updateRedPoint(false, (TextView)localObject2);
          }
        }
      }
      localObject2 = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
      ((Bundle)localObject2).putBoolean("troop_info_from_troopsetting", true);
      ((Bundle)localObject2).putInt("exposureSource", 1);
      TroopUtils.openTroopInfoActivity(this, (Bundle)localObject2, 2);
      localObject2 = this.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
      for (i1 = 1;; i1 = 2)
      {
        bdla.b((QQAppInterface)localObject2, "dc00898", "", "", "0X800A524", "0X800A524", i1, 0, "", "", "", "");
        break;
      }
      localObject2 = new bint(this, this.app, false);
      ((bint)localObject2).a(new adsa(this));
      ((bint)localObject2).a(2);
      bhbu.a("Grp_set_new", "grpData_admin", "clk_delRecord", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      break;
      localObject3 = paramView.getTag(2131378495);
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "troop app item click type=" + paramView.getId() + ", url=" + localObject3);
      }
      localObject4 = (oidb_0xe83.TabInfo)paramView.getTag(2131378464);
      if (TroopUtils.checkIsReadInJoySubscribe(paramView, (oidb_0xe83.TabInfo)localObject4))
      {
        localObject2 = null;
        if (((oidb_0xe83.TabInfo)localObject4).red_point.get() != 0)
        {
          localObject2 = (String)paramView.getTag(2131378488);
          label3890:
          osg.a(this, (String)localObject2, 2);
          label3897:
          if ((localObject4 != null) && (((oidb_0xe83.TabInfo)localObject4).red_point.get() != 0)) {
            if ((paramView instanceof TroopAppFormItem))
            {
              localObject2 = (TroopAppFormItem)paramView;
              if (((oidb_0xe83.TabInfo)localObject4).appid.get() != 1106837471L) {
                break label4324;
              }
              ((TroopAppFormItem)localObject2).d();
            }
          }
        }
      }
      for (;;)
      {
        ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, ((oidb_0xe83.TabInfo)localObject4).appid.get());
        ((oidb_0xe83.TabInfo)localObject4).red_point.set(0);
        TroopUtils.clearTabListRedDot(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, ((oidb_0xe83.TabInfo)localObject4).appid.get());
        if (i1 != 30) {
          break label4332;
        }
        bglm.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1106611799);
        this.jdField_j_of_type_Int = ((int)NetConnInfoCenter.getServerTime());
        ThreadManager.post(new ChatSettingForTroop.32(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 5, null, false);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(19);
        bhbu.a("Grp_game", "Grp_data", "feeds_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        break;
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label3890;
        }
        localObject2 = "{\"tags\":" + this.jdField_a_of_type_JavaLangString + "}";
        break label3890;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject2 = localObject3;
          if (((oidb_0xe83.TabInfo)localObject4).appid.get() == 1106837471L) {
            localObject2 = (String)paramView.getTag(2131378488);
          }
        }
        if ((!(localObject2 instanceof String)) || (TextUtils.isEmpty((String)localObject2))) {
          break label3897;
        }
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("uin", this.app.getCurrentAccountUin());
        ((Bundle)localObject3).putString("gc", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        ((Bundle)localObject3).putBoolean("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        if (awyd.a(this, (String)localObject2, (Bundle)localObject3))
        {
          if (!QLog.isColorLevel()) {
            break label3897;
          }
          QLog.d("Q.chatopttroop", 2, "mini app jump handled");
          break label3897;
        }
        localObject3 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", (String)localObject2);
        startActivity((Intent)localObject3);
        break label3897;
        label4324:
        ((TroopAppFormItem)localObject2).c();
      }
      label4332:
      if (i1 == 29)
      {
        bhbu.a("Grp_game", "Grp_data", "rank_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        break;
      }
      if ((i1 != 1007) || (localObject4 == null) || (((oidb_0xe83.TabInfo)localObject4).appid.get() != 1106837471L)) {
        break;
      }
      bhbu.a("Grp_set", "Grp_aio_subscription", "subscription_clk", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) });
      break;
      if (this.o)
      {
        bghs.a(this.app, false);
        this.jdField_a_of_type_Bgnx.a(false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "setRobotItemRedDotShowed");
        }
      }
      bdla.b(this.app, "dc00898", "", "", "", "0X8009F9C", 0, 0, "", "", "", "");
      TroopUtils.jumpRobotPage(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1))
      {
        i1 = 1;
        label4549:
        if ((i1 == 0) || (!arjy.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
          break label4737;
        }
        bool = aofp.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label4728;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!bool) {
          break label4714;
        }
        i1 = 15;
        label4622:
        localObject4 = VipUtils.a(0, i1).toString();
        localObject5 = anvx.a(2131701218);
        localObject6 = new adsb(this, bool);
        if (!bool) {
          break label4720;
        }
        localObject2 = "0X800A57F";
        label4662:
        VipUtils.a(this, (String)localObject3, (String)localObject4, (String)localObject5, (DialogInterface.OnClickListener)localObject6, (String)localObject2, 1, bool);
      }
      for (;;)
      {
        bdla.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 1, 0, "", "", "", "");
        break;
        i1 = 0;
        break label4549;
        label4714:
        i1 = 8;
        break label4622;
        label4720:
        localObject2 = "0X8009E38";
        break label4662;
        label4728:
        VipUtils.a(this, bool);
      }
      label4737:
      label4756:
      int i2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = "";
        }
        if ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
          break label5057;
        }
        i2 = 1;
        label4788:
        localObject4 = new Intent(this, EditInfoActivity.class);
        ((Intent)localObject4).putExtra("edit_type", 2);
        if (i1 == 0) {
          break label5062;
        }
        localObject2 = anvx.a(2131701237);
        label4823:
        ((Intent)localObject4).putExtra("title", (String)localObject2);
        ((Intent)localObject4).putExtra("default_text", (String)localObject3);
        ((Intent)localObject4).putExtra("max_num", 96);
        ((Intent)localObject4).putExtra("canPostNull", false);
        if (i1 == 0) {
          break label5073;
        }
        localObject2 = anvx.a(2131701222);
        label4878:
        ((Intent)localObject4).putExtra("right_btn", (String)localObject2);
        ((Intent)localObject4).putExtra("isTroopName", true);
        if (i1 == 0) {
          break label5080;
        }
        bool = true;
        label4906:
        ((Intent)localObject4).putExtra("edit_mode", bool);
        if (i2 == 0) {
          break label5086;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        label4930:
        ((Intent)localObject4).putExtra("troopUin", (String)localObject2);
        startActivityForResult((Intent)localObject4, 16);
        bhbu.a("Grp_set_new", "grpData_admin", "clk_editInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        localObject3 = this.app;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label5093;
        }
        localObject2 = "0";
      }
      for (;;)
      {
        bdla.b((QQAppInterface)localObject3, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_name", 0, 0, (String)localObject4, "0", (String)localObject2, "");
        break;
        localObject2 = "";
        break label4756;
        label5057:
        i2 = 0;
        break label4788;
        label5062:
        localObject2 = anvx.a(2131701236);
        break label4823;
        label5073:
        localObject2 = "";
        break label4878;
        label5080:
        bool = false;
        break label4906;
        label5086:
        localObject2 = "";
        break label4930;
        label5093:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject2 = "1";
        } else {
          localObject2 = "2";
        }
      }
      V();
      localObject3 = this.app;
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        localObject2 = "0";
      }
      for (;;)
      {
        bdla.b((QQAppInterface)localObject3, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_num", 0, 0, (String)localObject4, "0", (String)localObject2, "");
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject2 = "1";
        } else {
          localObject2 = "2";
        }
      }
      localObject2 = bgld.a().a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 1);
      localObject3 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject3).putExtra("url", (String)localObject2);
      startActivity((Intent)localObject3);
      bhbu.a("Grp_set_new", "grpData_admin", "grpHonour_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      bdla.b(null, "dc00898", "", "", "0X800A6EF", "0X800A6EF", 0, 0, "", "", "", "");
      break;
      bhdf.b(this.app.getCurrentAccountUin(), false);
      localObject2 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", "https://qun.qq.com/v2/luckyword/index?qunid={GROUPCODE}&_wv=67108865&_nav_txtclr=FFFFFF&_wvSb=0&source=enter".replace("{GROUPCODE}", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
      startActivityForResult((Intent)localObject2, 19);
      bhbu.a("Grp_set_new", "grpData_admin", "Luckyword_entry_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      break;
      localObject2 = (bejv)this.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      bool = ((bejv)localObject2).a(4, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject3 = beki.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      if (bool) {
        ((bejv)localObject2).b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 4, 2, (Bundle)localObject3);
      }
      for (;;)
      {
        beki.a(this.app, "SP_KEY_SING_TOGETHER_TROOP_RED_DOT_SHOW", false, false);
        ((bejv)localObject2).a("sing_tab", "clk_setsing", 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        H();
        break;
        ((bejv)localObject2).a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 4, 2, (Bundle)localObject3);
      }
      localObject2 = (argl)aqxe.a().a(535);
      if ((localObject2 == null) || (((argl)localObject2).jdField_a_of_type_Arhh == null))
      {
        QQToast.a(this, 0, 2131692995, 0).a();
        break;
      }
      localObject3 = (bejv)this.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      bool = ((bejv)localObject3).a(2, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject4 = beki.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      switch (((argl)localObject2).jdField_a_of_type_Arhh.a())
      {
      default: 
        if (((bejv)localObject3).a(this, 2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2)) {
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(2) });
          }
        }
        break;
      }
      for (;;)
      {
        beki.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_RED_DOT_SHOW", false, false);
        G();
        break;
        QQToast.a(this, 0, 2131692995, 0).a();
        continue;
        if (bool)
        {
          ((bejv)localObject3).b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject4);
        }
        else
        {
          ((bejv)localObject3).a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject4);
          continue;
          ((bejv)localObject3).a("video_tab", "clk_setvideo", 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          beki.a(this.app, ((argl)localObject2).jdField_a_of_type_Arhh.b(), ((argl)localObject2).jdField_a_of_type_Arhh.a(), ((argl)localObject2).jdField_a_of_type_Arhh.b(), (Bundle)localObject4, 1);
        }
      }
      if (this.jdField_a_of_type_Bgua != null) {
        this.jdField_a_of_type_Bgua.e();
      }
      this.jdField_a_of_type_Bgua = TroopUtils.shareTroop(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app);
      localObject2 = this.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
      for (i1 = 1;; i1 = 2)
      {
        bdla.b((QQAppInterface)localObject2, "dc00898", "", "", "0X800A525", "0X800A525", i1, 0, TroopUtils.getExposureSourceReportVal() + "", "", "", "");
        break;
      }
      if (bhdf.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false))
      {
        bglm.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 101890494);
        bhdf.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false, "");
        localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[42];
        if (localObject2 != null)
        {
          localObject2 = (TextView)((View)localObject2).findViewById(2131376668);
          if (localObject2 != null)
          {
            ((TextView)localObject2).setText("");
            TroopUtils.updateRedPoint(false, (TextView)localObject2);
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", "https://qun.qq.com/active/rank/index?gc={groupcode}&_wwv=128".replace("{groupcode}", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
        startActivity((Intent)localObject2);
      }
      bdla.b(this.app, "dc00898", "", "", "0X800B2F1", "0X800B2F1", 0, 0, "", "", "", "");
      break;
      this.t = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
        bfcp.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      TroopUtils.setRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION");
      TroopUtils.updateRedPoint(false, (TextView)paramView.findViewById(2131376668));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
        break;
      }
      bdla.b(this.app, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800B4AE", "0X800B4AE", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt), "", "", "");
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        localObject2 = (TextView)paramView.findViewById(2131376668);
        TroopUtils.setRedPointSP("RED_POINT_KEY_TROOP_IDOL_RANK" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        TroopUtils.updateRedPoint(false, (TextView)localObject2);
        if (bdvn.a())
        {
          QQToast.a(this, getString(2131699085), 0).b(getTitleBarHeight());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.chatopttroop", 2, new Object[] { "onclick:StudyMode Forbidden context = ", this });
          break;
        }
        bghc.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        bdla.b(this.app, "dc00898", "", "", "0X800B596", "0X800B596", 0, 0, "", "", "", "");
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
      for (localObject2 = "null";; localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)
      {
        QLog.d("Q.chatopttroop", 2, new Object[] { "onclick: troopUin = ", localObject2 });
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        if (bdvn.a())
        {
          QQToast.a(this, getString(2131699085), 0).b(getTitleBarHeight());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.chatopttroop", 2, new Object[] { "onclick:StudyMode Forbidden context = ", this });
          break;
        }
        bghc.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getFansTroopStarId());
        bdla.b(this.app, "dc00898", "", "", "0X800B596", "0X800B596", 0, 0, "", "", "", "");
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
      for (localObject2 = "null";; localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)
      {
        QLog.d("Q.chatopttroop", 2, new Object[] { "onclick: troopUin = ", localObject2 });
        break;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
        break label55;
      }
      K();
    }
    label55:
    while (this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView == null) {
      return;
    }
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildCount();
    paramInt1 = 0;
    label72:
    Object localObject;
    if (paramInt1 < paramInt2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(paramInt1).getTag();
      if ((localObject != null) && ((localObject instanceof advh)))
      {
        localObject = (advh)localObject;
        if (paramString != null) {
          break label129;
        }
        a((advh)localObject, null, false);
      }
    }
    label129:
    while (!paramString.equals(((advh)localObject).jdField_a_of_type_JavaLangString))
    {
      paramInt1 += 1;
      break label72;
      break;
    }
    ((advh)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void p()
  {
    try
    {
      if (this.jdField_a_of_type_Bisl == null)
      {
        this.jdField_a_of_type_Bisl = new bisl(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_Bisl.c(2131694477);
        this.jdField_a_of_type_Bisl.c(false);
      }
      this.jdField_a_of_type_Bisl.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  public void q()
  {
    try
    {
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
        this.jdField_a_of_type_Bisl.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  protected void r()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[19];
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mCanSearchByKeywords) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mCanSearchByTroopUin)) {
        localView.setVisibility(0);
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s()
  {
    Context localContext = getApplicationContext();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      String str = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
      bgst.a(localContext).a(str, null);
    }
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131694975);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692056);
    adsy localadsy = new adsy(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690697, localadsy);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131694945, localadsy);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void u()
  {
    if ((this.app == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "updateNick use cache");
      }
      a(localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin()));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "updateNick async");
    }
    ThreadManager.post(new ChatSettingForTroop.61(this, localTroopManager), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop
 * JD-Core Version:    0.7.0.1
 */
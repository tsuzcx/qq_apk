package com.tencent.mobileqq.activity;

import Override;
import acik;
import aefp;
import aefq;
import aefr;
import aeft;
import aefu;
import aefv;
import aefw;
import aefx;
import aefy;
import aefz;
import aega;
import aegb;
import aegc;
import aegd;
import aege;
import aegf;
import aegg;
import aegh;
import aegi;
import aegj;
import aegl;
import aegm;
import aegn;
import aego;
import aegp;
import aegr;
import aegt;
import aegu;
import aegv;
import aegw;
import aegz;
import aeha;
import aehb;
import aehc;
import aehd;
import aehe;
import aelh;
import agej;
import ajpz;
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
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import antz;
import anua;
import anyu;
import anzj;
import aoip;
import aojn;
import aojs;
import aoof;
import aoog;
import aorc;
import aran;
import arjb;
import arjc;
import arjl;
import arju;
import arjv;
import arkh;
import armu;
import asvi;
import atcx;
import awml;
import axev;
import axfw;
import azyo;
import bdep;
import bdgb;
import bdll;
import begb;
import begp;
import begz;
import bejx;
import bekk;
import bfez;
import bftt;
import bftu;
import bfui;
import bggj;
import bgpk;
import bgpp;
import bgpy;
import bgqm;
import bgqr;
import bgtj;
import bgts;
import bgty;
import bguq;
import bgwe;
import bhap;
import bhaq;
import bhbx;
import bhju;
import bhlk;
import bhlq;
import bhme;
import bhmq;
import bhnv;
import bhpc;
import bhru;
import bhwz;
import bhyk;
import bhzs;
import bidm;
import bidn;
import biik;
import biwz;
import bjbs;
import bjbv;
import bjcf;
import bliq;
import blir;
import blji;
import blrq;
import bnse;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.homework.entry.ui.EntryDebugFragment;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.GameRankFormItem;
import com.tencent.mobileqq.troop.widget.TroopAppFormItem;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0x899.oidb_0x899.memberlist;>;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import mve;
import mxc;
import nhv;
import nnc;
import noa;
import npk;
import npn;
import oix;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.ExtraInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.TabInfo;
import yup;

public class ChatSettingForTroop
  extends BaseActivity
  implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener, aoog, bgpp
{
  public static final ArrayList<Integer> a;
  public static String l;
  protected final int a;
  long jdField_a_of_type_Long = 0L;
  protected aehe a;
  protected BroadcastReceiver a;
  public Intent a;
  public Drawable a;
  public Handler a;
  protected DisplayMetrics a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new aefr(this);
  public View.OnTouchListener a;
  protected View a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  public TextView a;
  anua jdField_a_of_type_Anua = new aegp(this);
  anyu jdField_a_of_type_Anyu = new aegj(this);
  aojs jdField_a_of_type_Aojs = new aegg(this);
  protected aoof a;
  public arju a;
  private bgwe jdField_a_of_type_Bgwe;
  public bhap a;
  public bhbx a;
  public bhpc a;
  public bhru a;
  bhzs jdField_a_of_type_Bhzs = new aegz(this);
  protected bjbs a;
  public bjbv a;
  public TroopManager a;
  public TroopInfo a;
  TroopMoreDetailView jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView;
  public TroopInfoData a;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  protected MyGridView a;
  protected QQBlurView a;
  public XListView a;
  protected ImmersiveTitleBar2 a;
  protected Runnable a;
  protected String a;
  public List<Integer> a;
  protected noa a;
  protected npk a;
  protected npn a;
  protected boolean a;
  public View[] a;
  public int b;
  public Handler b;
  protected View.OnClickListener b;
  protected View b;
  protected Button b;
  public ImageView b;
  protected TextView b;
  aojs jdField_b_of_type_Aojs = new aegh(this);
  private bhpc jdField_b_of_type_Bhpc;
  protected Runnable b;
  public String b;
  protected ArrayList<TroopAppInfo> b;
  List<ImageView> jdField_b_of_type_JavaUtilList;
  public volatile boolean b;
  protected int c;
  protected View c;
  public TextView c;
  aojs jdField_c_of_type_Aojs = new aegi(this);
  protected String c;
  private ArrayList<Long> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  protected List<oidb_0x899.memberlist> c;
  public boolean c;
  protected int d;
  protected View d;
  public TextView d;
  private aojs d;
  public String d;
  public List<Long> d;
  public boolean d;
  protected int e;
  public String e;
  public List<oidb_0x899.memberlist> e;
  public boolean e;
  protected int f;
  String f;
  public boolean f;
  protected int g;
  String g;
  protected boolean g;
  protected int h;
  String h;
  protected boolean h;
  public int i;
  String i;
  public boolean i;
  public int j;
  String j;
  protected boolean j;
  public int k;
  String k;
  public boolean k;
  protected int l;
  protected boolean l;
  private int jdField_m_of_type_Int = 2;
  private String jdField_m_of_type_JavaLangString;
  public boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s = true;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379525));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379526));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379527));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379528));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379529));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379530));
    jdField_l_of_type_JavaLangString = "https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi";
  }
  
  public ChatSettingForTroop()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_Int = 5;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Aojs = new aefp(this);
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aegn(this);
    this.jdField_a_of_type_JavaLangRunnable = new ChatSettingForTroop.12(this);
    this.jdField_a_of_type_Npn = new aefz(this);
    this.jdField_b_of_type_JavaLangRunnable = new ChatSettingForTroop.23(this);
    this.jdField_l_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new aegf(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aegr(this);
    this.jdField_a_of_type_Noa = new aegv(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new mve();
  }
  
  private void A()
  {
    blir localblir = (blir)blji.a(this, null);
    localblir.a(new bliq(getString(2131695541), 34, 0), 5);
    localblir.a(new bliq(blji.a(this, 2131717453), 21, 0), 5);
    localblir.c(2131690580);
    localblir.a(new aefu(this, localblir));
    if (!localblir.isShowing()) {
      localblir.show();
    }
  }
  
  private void B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop quitTroop mTroopInfoData.bOwner = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner);
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject == null)
      {
        localObject = null;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      }
    }
    else
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label186;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) && (this.jdField_i_of_type_Int == 0)) {
        break label179;
      }
      C();
      label107:
      localObject = "2";
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label236;
      }
      localObject = "0";
    }
    for (;;)
    {
      bdll.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Clk_quitgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject, "", "");
      return;
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label179:
      D();
      break label107;
      label186:
      localObject = blir.a(this);
      ((blir)localObject).a(2131690924);
      ((blir)localObject).a(2131691895, 3);
      ((blir)localObject).a(new aefv(this, (blir)localObject));
      ((blir)localObject).d(getString(2131690580));
      ((blir)localObject).show();
      break label107;
      label236:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        localObject = "1";
      }
    }
  }
  
  private void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop showDisbandTroopAlertWindow");
    }
    ReportDialog localReportDialog = new ReportDialog(this, 2131755824);
    localReportDialog.setContentView(2131561147);
    ((TextView)localReportDialog.findViewById(2131365556)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365544);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365542);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365548);
    String str = anzj.a(2131700644);
    localTextView1.setText(getString(2131690919, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694098);
    localTextView3.setText(2131690580);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new aefw(this, localReportDialog));
    localTextView3.setOnClickListener(new aefx(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop troopDisband");
    }
    getString(2131691588);
    String str = getString(2131690918);
    blir localblir = blir.a(this);
    localblir.a(str);
    localblir.a(getString(2131690917), 3);
    localblir.d(getString(2131690580));
    localblir.a(new aefy(this, localblir));
    localblir.show();
  }
  
  private void E()
  {
    aoip localaoip = (aoip)this.app.a(20);
    if (localaoip != null) {
      localaoip.a(antz.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), true, 1);
    }
    this.jdField_a_of_type_Npk.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_Npn);
  }
  
  private void F()
  {
    aoip localaoip = (aoip)this.app.a(20);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum <= 100) {
      localaoip.a(antz.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 0L, 5, 100, 0);
    }
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {}
    do
    {
      return;
      localObject = (Boolean)this.jdField_a_of_type_Bhru.c.get(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
    } while ((localObject != null) && (((Boolean)localObject).booleanValue()));
    bdll.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "0", "");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
    }
    for (;;)
    {
      blir localblir = (blir)blji.a(this, null);
      localblir.a(getString(2131718565, new Object[] { localObject }));
      localblir.a(getString(2131696978), false);
      localblir.a(getString(2131696974), false);
      localblir.a(getString(2131696970), false);
      int i1 = this.app.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
      switch (i1)
      {
      }
      for (;;)
      {
        localblir.c(2131690580);
        localblir.a(new aega(this, i1, localblir));
        localblir.show();
        return;
        localblir.d(0);
        continue;
        localblir.d(1);
        continue;
        localblir.d(2);
      }
    }
  }
  
  private void H()
  {
    if ((this.jdField_b_of_type_Bhpc == null) || (this.jdField_b_of_type_Bhpc.isShowing())) {}
    try
    {
      this.jdField_b_of_type_Bhpc.dismiss();
      label24:
      this.jdField_b_of_type_Bhpc = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  private void I()
  {
    H();
    this.jdField_b_of_type_Bhpc = bhlq.a(this, 230).setTitle(getString(2131696959));
    this.jdField_b_of_type_Bhpc.setPositiveButton(getString(2131696958), new aege(this));
    try
    {
      this.jdField_b_of_type_Bhpc.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void J()
  {
    bhju.a("Grp_set_new", "grpData_admin", "clk_notice", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), "8.4.5" });
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)))
    {
      I();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Arju;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = arjv.a();
      this.jdField_a_of_type_Arju = ((arju)localObject1);
    }
    localObject1 = ((arju)localObject1).jdField_a_of_type_JavaLangString;
    localObject2 = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", bguq.a((String)localObject1, 0L, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app, true));
    ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
    ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivityForResult((Intent)localObject2, 17);
  }
  
  private void K()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[14];
    if (localView != null)
    {
      localView.setOnTouchListener(null);
      localView.setOnClickListener(null);
    }
  }
  
  private void L()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[33];
    if ((localView != null) && ((localView instanceof ExpandableTextView)))
    {
      localObject2 = bguq.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        localObject1 = (String)localObject2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      }
      ((ExpandableTextView)localView).setText(new begp((CharSequence)localObject1, 11, 16));
    }
    Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[37];
    if ((localObject2 != null) && ((localObject2 instanceof TextView))) {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        break label156;
      }
    }
    label156:
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;; localObject1 = getString(2131695490))
    {
      ((TextView)localObject2).setText(new begp((CharSequence)localObject1, 11, 16));
      return;
    }
  }
  
  private void M()
  {
    o();
    ((aoip)this.app.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, null);
  }
  
  private void N()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.s) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if (!this.s) {
      this.s = true;
    }
    if ((this.s) || (bool)) {}
    for (int i1 = 2131166987;; i1 = 2131166690)
    {
      int i3 = getResources().getColor(i1);
      int i2 = 2130843670;
      i1 = i2;
      if (this.s)
      {
        i1 = i2;
        if (!bool) {
          i1 = 2130840291;
        }
      }
      Drawable localDrawable = getResources().getDrawable(2130850668);
      localDrawable.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i3);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i3);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i1);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(i3);
      e(this.s);
      return;
    }
  }
  
  private void O()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[12].findViewById(2131373719);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFlagExt4(3)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFreezeReason(2)))
    {
      localImageView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(8);
  }
  
  private void P()
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
              break label383;
            }
            Object localObject2 = ((View)localObject1).getTag();
            if ((localObject2 == null) || (!(localObject2 instanceof oidb_0xe83.AppInfo))) {
              break label383;
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
              break label383;
            }
            boolean bool = bhlk.a(this.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
            if ((i2 != -1) && (!bool)) {
              break;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            localObject1 = (TextView)((View)localObject1).findViewById(2131362839);
            if (i1 == 0) {
              break label375;
            }
            ((TextView)localObject1).setVisibility(0);
            ((TextView)localObject1).setText("");
            ((TextView)localObject1).setBackgroundResource(0);
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130850400, 0, 0, 0);
            return;
            localObject1 = localView.findViewById(2131379334);
            break;
            localObject1 = localView.findViewById(2131379335);
            break;
            localObject1 = localView.findViewById(2131379336);
            break;
            localObject1 = localView.findViewById(2131379337);
            break;
            localObject1 = localView.findViewById(2131379338);
            break;
            localObject1 = localView.findViewById(2131379339);
            break;
            localObject1 = localView.findViewById(2131379340);
            break;
            localObject1 = localView.findViewById(2131379341);
            break;
          }
          label375:
          ((TextView)localObject1).setVisibility(8);
          return;
          label383:
          i1 += 1;
        }
      }
    }
  }
  
  private void Q()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) && (getIntent().getBooleanExtra("from_newer_guide", false)))
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    Intent localIntent2 = this.jdField_a_of_type_AndroidContentIntent;
    Intent localIntent1 = localIntent2;
    if (this.r)
    {
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      this.r = false;
    }
    setResult(-1, localIntent1);
  }
  
  private void R()
  {
    boolean bool = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[7];
    if (localObject != null)
    {
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
    }
  }
  
  private void S()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop()))
    {
      FormSwitchItem localFormSwitchItem = new FormSwitchItem(this, null);
      localFormSwitchItem.setText(getString(2131692806));
      localFormSwitchItem.a().setTextColor(getResources().getColor(2131166990));
      localFormSwitchItem.setFocusable(true);
      localFormSwitchItem.getBackground().setAlpha(255);
      localFormSwitchItem.setContentDescription(getString(2131692806));
      this.jdField_a_of_type_ArrayOfAndroidViewView[31] = localFormSwitchItem;
      localFormSwitchItem.a().setTag(Integer.valueOf(31));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormSwitchItem);
      T();
    }
  }
  
  private void T()
  {
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[31];
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (localObject != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.showGameSwitchStatus != 1) {
        break label82;
      }
      ((FormSwitchItem)localObject).setVisibility(0);
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.gameSwitchStatus != 1) {
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
  
  private void U()
  {
    Object localObject = (TroopManager)this.app.getManager(52);
    long l1;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      l1 = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
        l1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cmdUinFlagEx2;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("mTroopInfo.mask=");
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
          break label172;
        }
      }
    }
    label172:
    for (localObject = "no troopInfo";; localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cmdUinFlagEx2 + "")
    {
      QLog.d("Q.chatopttroop", 2, (String)localObject);
      boolean bool = TroopInfo.isCmdUinFlagEx2Open(l1, 512);
      localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[10];
      if (localObject != null)
      {
        localObject = ((FormSwitchItem)localObject).a();
        ((Switch)localObject).setOnCheckedChangeListener(null);
        ((Switch)localObject).setChecked(bool);
        V();
        ((Switch)localObject).setOnCheckedChangeListener(this);
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      break;
    }
  }
  
  private void V()
  {
    int i2 = 0;
    boolean bool1 = ((FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[10]).a();
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[8];
    if (!bool1)
    {
      i1 = 0;
      ((View)localObject).setVisibility(i1);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && ((localObject instanceof FormSwitchItem)))
      {
        boolean bool2 = ((FormSwitchItem)localObject).a();
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
        if ((bool1) || (bool2)) {
          break label92;
        }
      }
    }
    label92:
    for (int i1 = i2;; i1 = 8)
    {
      ((FormSimpleItem)localObject).setVisibility(i1);
      return;
      i1 = 8;
      break;
    }
  }
  
  private void W()
  {
    boolean bool = ((TroopManager)this.app.getManager(52)).d(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[19];
    if (localFormSwitchItem != null)
    {
      Switch localSwitch = localFormSwitchItem.a();
      localSwitch.setOnCheckedChangeListener(null);
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      localFormSwitchItem.setContentDescription(getString(2131695555));
    }
  }
  
  private void X()
  {
    int i2 = 0;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim();
    e();
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
  
  private Drawable a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_Aoof != null)
    {
      localObject2 = this.jdField_a_of_type_Aoof.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_Aoof.a())
        {
          this.jdField_a_of_type_Aoof.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = bhmq.a();
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
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131718927);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131718932);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131718934);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 4;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131718929);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 5;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131718928);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop()))
    {
      localObject = (aoip)this.app.a(20);
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
      if (!paramBoolean) {
        break label82;
      }
    }
    label82:
    for (int i1 = 1;; i1 = 0)
    {
      ((aoip)localObject).b(str, paramInt, i1);
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
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131692262));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramActivity.getString(2131695407));
    localIntent.putExtra("param_max", 100);
    if (!paramBoolean) {
      localIntent.putExtra("filer_robot", true);
    }
    localIntent.putExtra("param_entrance", 38);
    paramActivity.startActivityForResult(localIntent, 1);
  }
  
  private static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363587);
    paramView = (TextView)paramView.findViewById(2131376648);
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
    TextView localTextView = (TextView)paramView.findViewById(2131363587);
    paramView = (TextView)paramView.findViewById(2131376648);
    if (TextUtils.isEmpty(paramString))
    {
      localTextView.setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(getString(2131696960));
      return;
    }
    paramView.setVisibility(8);
    localTextView.setVisibility(0);
    localTextView.setText(paramString);
  }
  
  private boolean a(long paramLong, TroopInfo paramTroopInfo)
  {
    if (paramLong == 101761547L)
    {
      awml.b(this.app, getApplicationContext(), 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
      return true;
    }
    if (paramLong == 101847770L)
    {
      Intent localIntent = TroopMemberListActivity.a(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 19);
      localIntent.putExtra("TROOP_INFO_MEMBER_NUM", paramTroopInfo.wMemberNum);
      startActivity(localIntent);
      return true;
    }
    if (paramLong == 101872203L)
    {
      if (nhv.a((BaseActivity)getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
        return true;
      }
      paramTroopInfo = (mxc)this.app.getManager(373);
      if (paramTroopInfo != null) {
        paramTroopInfo.a(getActivity(), 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
      }
      return true;
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    if (!bhnv.d(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_Bjbv == null) {
        this.jdField_a_of_type_Bjbv = new bjbv(this);
      }
      this.jdField_a_of_type_Bjbv.b(2, 2131693965, 1500);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
      return;
    }
    this.jdField_a_of_type_Bhru.b.clear();
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Bhru.c.put(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Boolean.valueOf(true));
    if (!this.p)
    {
      SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      if (!localSharedPreferences.getBoolean("Change_Msg_Notify_Tips_Value", false))
      {
        this.p = true;
        localSharedPreferences.edit().putBoolean("Change_Msg_Notify_Tips_Value", true).commit();
        bhlq.a(this, getString(2131696969), 2131718195, 2131718195, new bhme(), null).show();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
    bdll.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)
    {
      M();
      return;
    }
    c(paramString);
  }
  
  private boolean b()
  {
    byte[] arrayOfByte = ((axfw)this.app.getManager(37)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject != null) {
        break label56;
      }
    }
    label56:
    for (Object localObject = null;; localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && ((paramInt & 0x1) > 0)) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption);
      }
      return;
    }
  }
  
  private void c(String paramString)
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
    a(2131718941, 0);
  }
  
  private void c(List<oidb_0x899.memberlist> paramList)
  {
    aoip localaoip = (aoip)this.app.a(20);
    ArrayList localArrayList1 = new ArrayList();
    bgty localbgty = (bgty)this.app.getManager(203);
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
      } else if (localbgty.b(str)) {
        localArrayList1.add(localObject);
      } else if (bguq.b(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str)) {
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
      localObject = bguq.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, paramList);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label388;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.memberListToShow = ((String)localObject);
      localaoip.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramList, true, null);
    }
    this.jdField_e_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_e_of_type_JavaUtilList.addAll(localArrayList3);
    this.jdField_e_of_type_JavaUtilList.addAll(localArrayList1);
    paramList = new ArrayList();
    localObject = this.jdField_e_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject).next()).uint64_member_uin.get()));
    }
    label388:
  }
  
  private void c(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null) {}
    for (View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[25];; localView = null)
    {
      Object localObject2;
      Object localObject1;
      if (localView != null)
      {
        localObject2 = "";
        localObject1 = localObject2;
        if (paramBoolean)
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
          break label480;
        }
        localObject1 = " ";
      }
      label274:
      label453:
      label475:
      label480:
      for (;;)
      {
        localView.setVisibility(0);
        int i1;
        if (paramBoolean) {
          i1 = 2131698493;
        }
        for (;;)
        {
          a(25, 2, localView, getString(i1), "", true);
          localObject2 = new SpannableString((String)localObject1 + "PT[QR]");
          Object localObject3 = getResources().getDrawable(2130843815);
          ((Drawable)localObject3).setBounds(0, 0, bdep.a(18.0F), bdep.a(18.0F));
          if (ThemeUtil.isInNightMode(this.app)) {
            ((Drawable)localObject3).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
          }
          localObject3 = new aegl(this, (Drawable)localObject3, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
          {
            QLog.e("vip_pretty.Q.chatopttroop", 1, "show the pretty troop icon :" + this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.groupFlagExt4);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.checkFlagExt4(1)) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.checkFreezeReason(2)))
            {
              i1 = 1;
              if (i1 == 0) {
                break label453;
              }
              Drawable localDrawable = getResources().getDrawable(2130846940);
              localDrawable.setBounds(0, 0, bdep.a(40.0F), bdep.a(15.0F));
              ((SpannableString)localObject2).setSpan(new aegm(this, localDrawable, 0), ((String)localObject1).length(), ((String)localObject1).length() + 2, 17);
              ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length() + 2, ((String)localObject1).length() + 6, 17);
            }
          }
          for (;;)
          {
            paramBoolean = bool;
            if (!" ".equals(localObject1)) {
              paramBoolean = true;
            }
            bguq.a(localView, (CharSequence)localObject2, null, null, paramBoolean, (String)localObject1, anzj.a(2131691143), new aego(this));
            localView.setOnClickListener(this);
            return;
            if (paramBoolean) {
              break label475;
            }
            i1 = 2131698494;
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.checkFlagExt4(2))
            {
              i1 = 1;
              break label274;
              QLog.e("vip_pretty.Q.chatopttroop", 1, "not show the pretty troop icon");
            }
            i1 = 0;
            break label274;
            ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length(), ((SpannableString)localObject2).length(), 17);
          }
          i1 = 0;
        }
      }
    }
  }
  
  private boolean c()
  {
    boolean bool3 = true;
    boolean bool1 = false;
    boolean bool4;
    boolean bool5;
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        break label201;
      }
      bool1 = true;
      bool4 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mTroopPicListJson);
      bool5 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt > 0L) {
        break label206;
      }
      i1 = 1;
      label65:
      if (!bguq.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)) {
        break label211;
      }
      bool2 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags != null) {
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags.isEmpty()) {
          break label211;
        }
      }
    }
    label201:
    label206:
    label211:
    for (boolean bool2 = bool3;; bool2 = false)
    {
      bool3 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo);
      bool1 = bguq.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, new boolean[] { bool1, bool4, bool5, i1, bool2, bool3 }, new int[] { 11, 12, 5, 4, 8, 6 });
      return bool1;
      bool1 = false;
      break;
      i1 = 0;
      break label65;
    }
  }
  
  private void d(int paramInt)
  {
    this.jdField_m_of_type_Int = paramInt;
    bgpk.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  private void d(String paramString)
  {
    runOnUiThread(new ChatSettingForTroop.51(this, paramString));
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
      localIntent = agej.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
      if ((paramBoolean) && (this.jdField_j_of_type_Boolean))
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
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    ImmersiveUtils.a(false, getWindow());
    bdgb.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
  }
  
  private void f(boolean paramBoolean)
  {
    antz localantz = (antz)this.app.a(22);
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      if (!paramBoolean) {
        break label149;
      }
      i1 = 0;
      label45:
      if (!localantz.a(str, i1)) {
        break label161;
      }
      if (!paramBoolean) {
        break label154;
      }
    }
    label149:
    label154:
    for (String str = "open_stick";; str = "close_stick")
    {
      bdll.b(this.app, "dc00899", "Grp_set", "", "Grp_data", str, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      bhju.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode;
      break;
      i1 = 1;
      break label45;
    }
    label161:
    R();
  }
  
  private void g(boolean paramBoolean)
  {
    int i2 = 1;
    if (!bhnv.d(BaseApplication.getContext()))
    {
      a(2131691989, 1);
      U();
      return;
    }
    if (paramBoolean) {
      aorc.a(this.app).a(this);
    }
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      i1 = 1;
      int i3 = (int)NetConnInfoCenter.getServerTime();
      ((aoip)this.app.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, this.app.c(), i1, 512, i3);
      V();
      localQQAppInterface = this.app;
      if (!paramBoolean) {
        break label142;
      }
    }
    label142:
    for (int i1 = i2;; i1 = 2)
    {
      bdll.b(localQQAppInterface, "dc00898", "", "", "0X800A348", "0X800A348", 2, i1, "0", "0", "", "");
      return;
      i1 = 0;
      break;
    }
  }
  
  private void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "switchTroopShowExternal");
    }
    if (bhnv.a(this) == 0)
    {
      QQToast.a(this, 2131695537, 0).b(getTitleBarHeight());
      W();
      return;
    }
    ((aoip)this.app.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramBoolean, false);
    if (paramBoolean)
    {
      bdll.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      if (!paramBoolean) {
        break label207;
      }
    }
    label207:
    for (String str = "showGrp_open";; str = "showGrp_close")
    {
      bhju.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      bdll.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      break;
    }
  }
  
  private void u()
  {
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[16];
    if ((localFormSimpleItem == null) || (localFormSimpleItem.getVisibility() != 0)) {}
    do
    {
      return;
      arjl localarjl = (arjl)aran.a().a(535);
      if ((localarjl == null) || (!localarjl.jdField_a_of_type_Boolean)) {
        break;
      }
      localFormSimpleItem.setVisibility(0);
    } while (localFormSimpleItem.getVisibility() != 0);
    if (bekk.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_RED_DOT_SHOW", true, false))
    {
      localFormSimpleItem.setRightIcon(getResources().getDrawable(2130841377));
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    localFormSimpleItem.setRightIcon(null);
  }
  
  private void v()
  {
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[38];
    if ((localFormSimpleItem == null) || (localFormSimpleItem.getVisibility() != 0)) {
      return;
    }
    Object localObject = ((arjb)aran.a().a(551)).a(4);
    if ((localObject != null) && (((arjc)localObject).jdField_b_of_type_Boolean))
    {
      localFormSimpleItem.setVisibility(0);
      if (!((bejx)this.app.getManager(339)).a(4, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
        break label130;
      }
    }
    label130:
    for (localObject = "已开启";; localObject = "未开启")
    {
      localFormSimpleItem.setRightText((CharSequence)localObject);
      if (!bekk.a(this.app, "SP_KEY_SING_TOGETHER_TROOP_RED_DOT_SHOW", true, false)) {
        break;
      }
      localFormSimpleItem.setRightIcon(getResources().getDrawable(2130841377));
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    localFormSimpleItem.setRightIcon(null);
  }
  
  private void w()
  {
    new QueryTask(new aehd(this), new aefq(this)).a(null);
  }
  
  private void x()
  {
    int i1 = getResources().getDisplayMetrics().widthPixels;
    float f1 = getResources().getDisplayMetrics().density;
    int i2 = (int)(24.0F * f1);
    int i3 = (int)(20.0F * f1);
    int i4 = (int)(66.0F * f1);
    i1 = (i1 - i2) / ((int)(50.0F * f1) + i3);
    i2 = (int)(16.0F * f1);
    this.jdField_c_of_type_Int = i2;
    this.jdField_d_of_type_Int = i2;
    this.jdField_e_of_type_Int = ((int)(5.0F * f1));
    this.jdField_f_of_type_Int = ((int)(f1 * 17.0F));
    this.jdField_g_of_type_Int = i1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.jdField_c_of_type_Int, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int, this.jdField_f_of_type_Int);
  }
  
  private void y()
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
        localDrawable.setBounds(0, 0, bdep.a(32.0F), bdep.a(32.0F));
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
      a(localView, null, null, anzj.a(2131700669));
    }
  }
  
  private void z()
  {
    byte[] arrayOfByte = ((TroopManager)this.app.getManager(52)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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
  
  @SuppressLint({"NewApi"})
  protected void a()
  {
    long l1 = System.currentTimeMillis();
    label4636:
    label4647:
    label4658:
    label4791:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      try
      {
        View localView = View.inflate(this, 2131563030, null);
        this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131364907));
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView.findViewById(2131379037));
        this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
        this.jdField_a_of_type_ArrayOfAndroidViewView = new View[43];
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
        Object localObject1 = new AbsListView.LayoutParams(-1, -2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        localObject1 = new blrq(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
        this.jdField_d_of_type_Boolean = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "mIsQidianPrivateTroop : " + this.jdField_d_of_type_Boolean + ", troopUin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        super.setContentView(localView);
        this.jdField_d_of_type_AndroidViewView = localView;
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130838778);
        this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131379015);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131378956));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131690668));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369088));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690668));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369042));
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131694165) + getString(2131690556));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369056));
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690974));
        this.jdField_a_of_type_Aoof = new aoof(this, this.app);
        this.jdField_a_of_type_Aoof.a(this);
        localObject1 = View.inflate(this, 2131560648, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject1;
        O();
        this.jdField_b_of_type_AndroidViewView.measure(0, 0);
        localObject1 = View.inflate(this, 2131561658, null);
        ((View)localObject1).setBackgroundResource(2130850683);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        ((View)localObject1).getLayoutParams().height = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
        localObject2 = View.inflate(this, 2131561655, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[23] = localObject2;
        ((View)localObject2).setTag(Integer.valueOf(23));
        ((View)localObject2).setOnClickListener(this);
        ((View)localObject2).setContentDescription(anzj.a(2131700638));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        localView.findViewById(2131379426).setVisibility(8);
        localObject1 = ((View)localObject2).findViewById(2131367895);
        ((View)localObject1).setTag(Integer.valueOf(35));
        ((View)localObject1).setContentDescription(getResources().getString(2131698491));
        if (bdgb.b()) {
          ((View)localObject1).setBackground(null);
        }
        if ((localObject1 instanceof ThemeImageView)) {
          ((ThemeImageView)localObject1).setSupportMaskView(false);
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[35] = localObject1;
        y();
        localObject1 = ((View)localObject2).findViewById(2131379490);
        ((View)localObject1).setTag(Integer.valueOf(36));
        this.jdField_a_of_type_ArrayOfAndroidViewView[36] = localObject1;
        e();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
          localObject2 = ((View)localObject2).findViewById(2131378143);
          ((TextView)localObject2).setText(new begp((CharSequence)localObject1, 11, 16));
          this.jdField_a_of_type_ArrayOfAndroidViewView[37] = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
            ((View)localObject2).setVisibility(8);
          }
          d();
          localObject1 = (bfez)aran.a().a(664);
          if ((localObject1 == null) || (!((bfez)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
            break label4791;
          }
          i1 = 1;
          localObject1 = View.inflate(this, 2131561658, null);
          ((View)localObject1).setBackgroundResource(2130850683);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
          localObject1 = View.inflate(this, 2131561651, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject1;
          ((View)localObject1).setTag(Integer.valueOf(0));
          if (i1 == 0) {
            break label4636;
          }
          ((View)localObject1).setBackgroundResource(2130839450);
          ((View)localObject1).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370690));
          this.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131700648) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + anzj.a(2131700656));
          if (AppSetting.jdField_c_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, agej.a(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), agej.a(3.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), agej.a(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()));
          }
          a((View)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)((View)localObject1).findViewById(2131370688));
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
          x();
          localObject1 = View.inflate(this, 2131561648, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[42] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          a(42, 3, (View)localObject1, getString(2131698521), "", true);
          ((View)localObject1).setTag(Integer.valueOf(42));
          localObject2 = (TextView)((View)localObject1).findViewById(2131363587);
          if (localObject2 != null) {
            ((TextView)localObject2).setVisibility(8);
          }
          if (i1 == 0) {
            break label4658;
          }
          bool = bhlk.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
          localObject2 = bhlk.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "");
          localObject3 = (TextView)((View)localObject1).findViewById(2131376648);
          if (localObject3 != null)
          {
            if ((!bool) || (!TextUtils.isEmpty((CharSequence)localObject2))) {
              break label4647;
            }
            ((TextView)localObject3).setText((CharSequence)localObject2);
            bguq.a(bool, (TextView)localObject3);
          }
          ((View)localObject1).setOnClickListener(this);
          ((View)localObject1).setVisibility(0);
          bdll.b(this.app, "dc00898", "", "", "0X800B2F0", "0X800B2F0", 0, 0, "", "", "", "");
          localObject1 = View.inflate(this, 2131561658, null);
          ((View)localObject1).setBackgroundResource(2130850683);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
          localObject1 = View.inflate(this, 2131559866, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localObject1;
          ((View)localObject1).getBackground().setAlpha(255);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setVisibility(8);
          this.jdField_c_of_type_AndroidViewView = View.inflate(this, 2131561658, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
          this.jdField_c_of_type_AndroidViewView.getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          localObject1 = View.inflate(this, 2131561648, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[14] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setTag(Integer.valueOf(14));
          a(14, 2, (View)localObject1, getString(2131691625), "", true);
          e();
          b((View)localObject1);
          localObject1 = View.inflate(this, 2131561648, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[25] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setTag(Integer.valueOf(25));
          a(25, 2, (View)localObject1, getString(2131698494), "", true);
          if ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
            break label4668;
          }
          bool = true;
          c(bool);
          b((View)localObject1);
          localObject1 = View.inflate(this, 2131561648, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          a((View)localObject1, null);
          a(4, 3, (View)localObject1, getString(2131698517), "", true);
          ((View)localObject1).setTag(Integer.valueOf(4));
          ((View)localObject1).setOnClickListener(this);
          localObject1 = new View(this);
          ((View)localObject1).setBackgroundResource(2130850083);
          localObject2 = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject2).height = 1;
          ((RelativeLayout.LayoutParams)localObject2).setMargins(agej.a(16.0F, getResources()), 0, 0, 0);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject2 = View.inflate(this, 2131561648, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject2;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          a((View)localObject2, null);
          ((View)localObject2).setTag(Integer.valueOf(5));
          ((View)localObject2).setOnClickListener(this);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
            break label4674;
          }
          localObject1 = anzj.a(2131700626);
          a(5, 3, (View)localObject2, getString(2131718911), (CharSequence)localObject1, true);
          if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (!this.jdField_b_of_type_Boolean)) {
            break label4685;
          }
          i1 = 0;
          ((View)localObject2).setVisibility(i1);
          localObject3 = (TextView)((View)localObject2).findViewById(2131376648);
          ((TextView)localObject3).setText((CharSequence)localObject1);
          b((View)localObject2);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
            break label4691;
          }
          bool = false;
          this.o = bguq.b(bool, "RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
          bguq.a(bguq.a(this, "8.0.5"), "RED_POINT_KEY_TROOP_ADMIN", this.o, (TextView)localObject3);
          localObject1 = (TroopPluginManager)this.app.getManager(119);
          if (localObject1 != null) {
            this.jdField_b_of_type_Boolean = ((TroopPluginManager)localObject1).a("troop_manage_plugin.apk", new aegw(this));
          }
          localObject1 = View.inflate(this, 2131561658, null);
          ((View)localObject1).setBackgroundResource(2130850683);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
          localObject1 = new FormSimpleItem(this);
          a(1001, 0, (FormSimpleItem)localObject1, getString(2131695451), anzj.a(2131700640), true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2131561658, null);
          ((View)localObject1).setBackgroundResource(2130850683);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBgType(1);
          ((FormSwitchItem)localObject1).setText(getString(2131692807));
          ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131166990));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131692807));
          this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
          localObject2 = ((FormSwitchItem)localObject1).a();
          if (!((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            break label4703;
          }
          ((Switch)localObject2).setChecked(true);
          ((Switch)localObject2).setTag(Integer.valueOf(7));
          ((Switch)localObject2).setOnCheckedChangeListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBackgroundResource(2130839450);
          ((FormSwitchItem)localObject1).setBgType(2);
          ((FormSwitchItem)localObject1).setText(getString(2131692808));
          ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131166990));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131692808));
          this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
          localObject2 = ((FormSwitchItem)localObject1).a();
          ((Switch)localObject2).setTag(Boolean.FALSE);
          int i2 = this.app.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmask = i2;
          }
          if (i2 == 1) {
            break label4712;
          }
          bool = true;
          ((Switch)localObject2).setChecked(bool);
          ((Switch)localObject2).setOnCheckedChangeListener(new aeha(this));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2131561645, null);
          localObject2 = (FormSimpleItem)((View)localObject1).findViewById(2131369006);
          a(9, 0, (FormSimpleItem)localObject2, getString(2131718851), "", true);
          this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
          localObject3 = new RelativeLayout.LayoutParams(agej.a(17.0F, getResources()), agej.a(17.0F, getResources()));
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = agej.a(30.0F, getResources());
          ((RelativeLayout.LayoutParams)localObject3).addRule(11);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15);
          ((FormSimpleItem)localObject2).addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject3);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839410));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_ArrayOfAndroidViewView[9] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(1010, 2, (FormSimpleItem)localObject1, getString(2131694045), getString(2131717934), true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localObject1);
          localObject2 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject2).setBackgroundResource(2130839450);
          ((FormSwitchItem)localObject2).setText(getString(2131695693));
          ((FormSwitchItem)localObject2).a().setTextColor(getResources().getColorStateList(2131166990));
          ((FormSwitchItem)localObject2).setFocusable(true);
          ((FormSwitchItem)localObject2).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject2).setContentDescription(getString(2131695693));
          this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject2;
          ((FormSwitchItem)localObject2).a().setTag(Integer.valueOf(10));
          U();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          localObject1 = View.inflate(this, 2131561658, null);
          ((View)localObject1).setBackgroundResource(2130850683);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
          localObject3 = new FormSimpleItem(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject3;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
          if (i1 != 0) {
            break label4718;
          }
          i1 = 3;
          String str2 = getString(2131693924);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick)) {
            break label4723;
          }
          localObject1 = getString(2131696901);
          a(6, i1, (FormSimpleItem)localObject3, str2, (CharSequence)localObject1, true);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick))
          {
            localObject1 = new begb(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).a();
            ((FormSimpleItem)localObject3).setRightText((CharSequence)localObject1);
            bhwz.a(this.app, ((FormSimpleItem)localObject3).a(), (Spannable)localObject1);
          }
          localObject1 = View.inflate(this, 2131561658, null);
          ((View)localObject1).setBackgroundResource(2130850683);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
          if (((bggj)this.app.getManager(346)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
          {
            localObject1 = new FormSimpleItem(this, null);
            ((FormSimpleItem)localObject1).a(true);
            ((FormSimpleItem)localObject1).setBgType(1);
            ((FormSimpleItem)localObject1).setLeftText(getResources().getString(2131698505));
            ((FormSimpleItem)localObject1).setRightText(getResources().getString(2131698503));
            ((FormSimpleItem)localObject1).setContentDescription(getResources().getString(2131698505));
            ((FormSwitchItem)localObject2).a().setTextColor(getResources().getColorStateList(2131166990));
            ((FormSimpleItem)localObject1).setFocusable(true);
            ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
            this.jdField_a_of_type_ArrayOfAndroidViewView[32] = localObject1;
            ((FormSimpleItem)localObject1).setTag(Integer.valueOf(32));
            ((FormSimpleItem)localObject1).setOnClickListener(this);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            bdll.b(null, "dc00898", "", "", "0X800A6EE", "0X800A6EE", 0, 0, "", "", "", "");
          }
          localObject1 = View.inflate(this, 2131561658, null);
          ((View)localObject1).setBackgroundResource(2130850683);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
          localObject1 = new FormSimpleItem(this, null);
          ((FormSimpleItem)localObject1).a(true);
          ((FormSimpleItem)localObject1).setBgType(2);
          ((FormSimpleItem)localObject1).setLeftText(getResources().getString(2131719285));
          ((FormSimpleItem)localObject1).a().setTextColor(getResources().getColor(2131166990));
          ((FormSimpleItem)localObject1).setFocusable(true);
          ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
          ((FormSimpleItem)localObject1).setContentDescription(getResources().getString(2131719285));
          this.jdField_a_of_type_ArrayOfAndroidViewView[16] = localObject1;
          ((FormSimpleItem)localObject1).setTag(Integer.valueOf(16));
          ((FormSimpleItem)localObject1).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          u();
          localObject1 = new FormSimpleItem(this, null);
          ((FormSimpleItem)localObject1).a(true);
          ((FormSimpleItem)localObject1).setBgType(3);
          ((FormSimpleItem)localObject1).setLeftText("一起K歌");
          ((FormSimpleItem)localObject1).a().setTextColor(getResources().getColor(2131166990));
          ((FormSimpleItem)localObject1).setFocusable(true);
          ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
          ((FormSimpleItem)localObject1).setContentDescription("一起K歌");
          this.jdField_a_of_type_ArrayOfAndroidViewView[38] = localObject1;
          ((FormSimpleItem)localObject1).setTag(Integer.valueOf(38));
          ((FormSimpleItem)localObject1).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          v();
          if (bidn.a())
          {
            localObject1 = View.inflate(this, 2131561658, null);
            ((View)localObject1).setBackgroundResource(2130850683);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
            localObject1 = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[40] = localObject1;
            a(40, 0, (FormSimpleItem)localObject1, getString(2131698515), "", true);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          }
          localObject1 = View.inflate(this, 2131561658, null);
          ((View)localObject1).setBackgroundResource(2130850683);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
          if (!bgpy.a(this.app)) {
            break label4767;
          }
          this.jdField_a_of_type_Bgwe = new bgwe(this, getString(2131719002));
          localObject1 = this.jdField_a_of_type_Bgwe.a();
          if (localObject1 != null)
          {
            if (!bgpy.c(this.app)) {
              break label4735;
            }
            this.n = bgpy.b(this.app);
            if (QLog.isColorLevel()) {
              QLog.d("Q.chatopttroop", 2, "bShowRed red robot" + this.n);
            }
            this.jdField_a_of_type_Bgwe.a(this.n);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).setOnClickListener(this);
            ((View)localObject1).setTag(Integer.valueOf(1009));
            localObject1 = View.inflate(this, 2131561658, null);
            ((View)localObject1).setBackgroundResource(2130850683);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
            bdll.b(this.app, "dc00898", "", "", "", "0X8009F9B", 0, 0, "", "", "", "");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop()))
          {
            localObject1 = new FormSimpleItem(this);
            a(1006, 0, (FormSimpleItem)localObject1, anzj.a(2131700675), "", true);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            bhju.a("Grp_edu", "Grp_data", "teachermsg_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          }
          localObject1 = new LinearLayout(this);
          ((LinearLayout)localObject1).setOrientation(1);
          ((LinearLayout)localObject1).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_a_of_type_ArrayOfAndroidViewView[28] = localObject1;
          localObject1 = View.inflate(this, 2131561658, null);
          ((View)localObject1).setBackgroundResource(2130850683);
          this.jdField_a_of_type_ArrayOfAndroidViewView[24] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
          localObject1 = new FormSimpleItem(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[17] = localObject1;
          a(17, 1, (FormSimpleItem)localObject1, anzj.a(2131700660), "", true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop", 2, "initUI  mIsQidianPrivateTroop = " + this.jdField_d_of_type_Boolean);
          }
          if (!this.jdField_d_of_type_Boolean)
          {
            localObject1 = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[18] = localObject1;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            a(18, 2, (FormSimpleItem)localObject1, getString(2131718871), "", true);
            ((FormSimpleItem)localObject1).setVisibility(8);
            localObject1 = (bfui)this.app.getManager(231);
            if (QLog.isColorLevel()) {
              QLog.d("Q.chatopttroop", 2, "initUI  effectManager.isAllTroopShowEnterance() = " + ((bfui)localObject1).b());
            }
            if (((bfui)localObject1).b()) {
              a(true);
            }
          }
          S();
          localObject1 = View.inflate(this, 2131561658, null);
          ((View)localObject1).setBackgroundResource(2130850683);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
          localObject1 = View.inflate(this, 2131561641, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[27] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          a(27, 0, (View)localObject1, getString(2131695452), null, false);
          ((View)localObject1).setTag(Integer.valueOf(27));
          ((View)localObject1).setOnClickListener(this);
          localObject2 = (TextView)((View)localObject1).findViewById(2131378936);
          if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
            ((TextView)localObject2).setAlpha(0.5F);
          }
          ((TextView)localObject2).setTextColor(Color.parseColor("#4799DF"));
          localObject1 = (TextView)((View)localObject1).findViewById(2131368636);
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
          localObject1 = View.inflate(this, 2131561656, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = (Button)((View)localObject1).findViewById(2131365364);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
            break label4780;
          }
          ((Button)localObject1).setText(2131691589);
          ((Button)localObject1).setOnClickListener(new aehb(this));
          localObject1 = View.inflate(this, 2131561658, null);
          ((View)localObject1).setBackgroundResource(2130850683);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297993);
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
          }
          this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363774);
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363692));
          this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131377526));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)localView.findViewById(2131363601));
          this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new aehc(this));
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
      String str1 = getString(2131695490);
      continue;
      str1.setBackgroundResource(2130839447);
      continue;
      ((TextView)localObject3).setText("");
      continue;
      str1.setVisibility(8);
      continue;
      label4668:
      boolean bool = false;
      continue;
      label4674:
      str1 = anzj.a(2131700633);
      continue;
      label4685:
      int i1 = 8;
      continue;
      label4691:
      bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop();
      continue;
      label4703:
      ((Switch)localObject2).setChecked(false);
      continue;
      label4712:
      bool = false;
      continue;
      label4718:
      i1 = 0;
      continue;
      label4723:
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick;
      continue;
      label4735:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        this.n = bgpy.b(this.app);
      }
      else
      {
        this.n = false;
        continue;
        QLog.i("Q.chatopttroop", 2, "RobotSwithOff");
        continue;
        str1.setText(2131715998);
        continue;
        i1 = 0;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new bjcf(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131368636);
    if (paramString != null)
    {
      paramString.setEditableFactory(begz.a);
      if (!TextUtils.isEmpty(paramCharSequence)) {
        break label70;
      }
    }
    label70:
    for (paramView = "";; paramView = new begp(paramCharSequence, 3))
    {
      paramString.setText(paramView);
      paramString.setTextColor(getResources().getColor(2131167070));
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
        localTextView = (TextView)paramView.findViewById(2131378936);
        if (localTextView != null)
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label177;
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
      paramView.setBackgroundResource(2130839440);
      break label52;
      paramView.setBackgroundResource(2130839456);
      break label52;
      paramView.setBackgroundResource(2130839450);
      break label52;
      paramView.setBackgroundResource(2130839447);
      break label52;
      paramView.setBackgroundColor(Color.parseColor("#00000000"));
      break label52;
      label177:
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
        paramFormSimpleItem.a().setEditableFactory(begz.a);
        if (paramCharSequence != null) {
          break;
        }
      }
    }
    for (paramString = "";; paramString = new begp(paramCharSequence, 3))
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
    String str2 = bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (paramInt == -1) {}
    for (Object localObject = "0";; localObject = "1")
    {
      bhju.a("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
      if (paramInt == -1) {
        break;
      }
      return;
    }
    localObject = agej.a(new Intent(this, SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a((Intent)localObject);
    ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
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
      paramView = paramView.findViewById(2131362954);
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
    ThreadManager.post(new ChatSettingForTroop.21(this, paramLong), 8, null, true);
  }
  
  /* Error */
  public void a(KQQ.BatchResponse paramBatchResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 2200	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 2202	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 2203	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 10
    //   21: aload 10
    //   23: aload_1
    //   24: getfield 2207	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 2208	[B
    //   30: invokevirtual 2209	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 2212	KQQ/BatchResponse:seq	I
    //   38: ifne +748 -> 786
    //   41: aload 10
    //   43: ifnull +743 -> 786
    //   46: aload 10
    //   48: getfield 2216	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 2219	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq +732 -> 786
    //   57: aload 10
    //   59: getfield 2216	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 2222	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 2228	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore 8
    //   70: new 2230	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   73: dup
    //   74: invokespecial 2231	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   77: astore 9
    //   79: aload 9
    //   81: aload 8
    //   83: invokevirtual 2232	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   86: pop
    //   87: aconst_null
    //   88: astore 8
    //   90: aload 9
    //   92: getfield 2236	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: invokevirtual 2241	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   98: astore 11
    //   100: aload 11
    //   102: ifnonnull +53 -> 155
    //   105: iconst_0
    //   106: istore_3
    //   107: goto +1381 -> 1488
    //   110: aload 8
    //   112: ifnonnull +674 -> 786
    //   115: iload 4
    //   117: iload_3
    //   118: if_icmpge +668 -> 786
    //   121: aload 11
    //   123: iload 4
    //   125: invokeinterface 2243 2 0
    //   130: checkcast 2245	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
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
    //   151: invokevirtual 2246	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   154: return
    //   155: aload 11
    //   157: invokeinterface 2249 1 0
    //   162: istore_3
    //   163: goto +1325 -> 1488
    //   166: aload 9
    //   168: getfield 2253	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: invokevirtual 2256	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   174: istore_2
    //   175: iload_2
    //   176: bipush 72
    //   178: if_icmpne +83 -> 261
    //   181: iload 4
    //   183: ifne +78 -> 261
    //   186: aload_0
    //   187: ldc_w 2257
    //   190: iconst_1
    //   191: invokestatic 1565	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   194: aload_0
    //   195: invokevirtual 1568	com/tencent/mobileqq/activity/ChatSettingForTroop:getTitleBarHeight	()I
    //   198: invokevirtual 1571	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   201: pop
    //   202: new 2259	com/tencent/mobileqq/activity/ChatSettingForTroop$35
    //   205: dup
    //   206: aload_0
    //   207: invokespecial 2260	com/tencent/mobileqq/activity/ChatSettingForTroop$35:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   210: bipush 32
    //   212: aconst_null
    //   213: iconst_0
    //   214: invokestatic 2265	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   217: aload_0
    //   218: aconst_null
    //   219: putfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   222: aload_0
    //   223: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   226: iconst_0
    //   227: putfield 1330	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   230: aload_0
    //   231: invokevirtual 839	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   234: ldc_w 2267
    //   237: iconst_0
    //   238: invokevirtual 855	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   241: pop
    //   242: aload_0
    //   243: invokevirtual 1450	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   246: aload_0
    //   247: aload_0
    //   248: invokevirtual 839	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   251: invokevirtual 1470	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   254: iconst_2
    //   255: invokestatic 2270	bguq:a	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   258: goto -118 -> 140
    //   261: iload_2
    //   262: ifne +1120 -> 1382
    //   265: aload 9
    //   267: getfield 2274	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   270: invokevirtual 2277	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   273: ifeq +1109 -> 1382
    //   276: aload 9
    //   278: getfield 2274	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   281: invokevirtual 2280	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   284: checkcast 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   287: astore 9
    //   289: aload 9
    //   291: astore 8
    //   293: aload 9
    //   295: ifnull -155 -> 140
    //   298: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +40 -> 341
    //   304: ldc_w 280
    //   307: iconst_2
    //   308: new 282	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 2282
    //   318: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 9
    //   323: getfield 2285	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_long_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   326: invokevirtual 2222	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   329: invokevirtual 2288	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   332: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload 9
    //   343: astore 8
    //   345: aload_0
    //   346: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   349: ifnull -209 -> 140
    //   352: aload_0
    //   353: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   356: aload 9
    //   358: invokevirtual 2292	com/tencent/mobileqq/troopinfo/TroopInfoData:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   361: aload_0
    //   362: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   365: getfield 1247	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   368: invokestatic 523	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +7 -> 378
    //   374: aload_0
    //   375: invokevirtual 961	com/tencent/mobileqq/activity/ChatSettingForTroop:e	()V
    //   378: aload_0
    //   379: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   382: getfield 1407	com/tencent/mobileqq/troopinfo/TroopInfoData:hasSetNewTroopHead	Z
    //   385: ifeq +7 -> 392
    //   388: aload_0
    //   389: invokespecial 1822	com/tencent/mobileqq/activity/ChatSettingForTroop:y	()V
    //   392: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   395: ifeq +69 -> 464
    //   398: aload 9
    //   400: getfield 2295	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   403: invokevirtual 2256	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   406: istore_2
    //   407: ldc_w 2297
    //   410: iconst_2
    //   411: new 282	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 2299
    //   421: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   428: getfield 343	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   431: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 2301
    //   437: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: iload_2
    //   441: invokevirtual 1378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: ldc_w 2303
    //   447: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload_2
    //   451: i2l
    //   452: invokestatic 2305	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(J)Z
    //   455: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   458: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload_0
    //   465: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   468: ifnull +64 -> 532
    //   471: aload_0
    //   472: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   475: aload 9
    //   477: invokevirtual 2306	com/tencent/mobileqq/data/TroopInfo:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   480: aload_0
    //   481: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   484: aload_0
    //   485: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   488: invokevirtual 517	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   491: putfield 1247	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   494: aload_0
    //   495: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   498: getfield 2307	com/tencent/mobileqq/data/TroopInfo:isNewTroop	Z
    //   501: ifne +17 -> 518
    //   504: aload_0
    //   505: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   508: aload_0
    //   509: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   512: invokevirtual 517	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   515: putfield 2308	com/tencent/mobileqq/data/TroopInfo:newTroopName	Ljava/lang/String;
    //   518: aload_0
    //   519: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   522: aload_0
    //   523: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   526: invokevirtual 517	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   529: putfield 2311	com/tencent/mobileqq/data/TroopInfo:oldTroopName	Ljava/lang/String;
    //   532: aload_0
    //   533: aload 9
    //   535: getfield 2295	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   538: invokevirtual 2256	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   541: i2l
    //   542: invokestatic 2305	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(J)Z
    //   545: putfield 1753	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   548: aload_0
    //   549: getfield 1753	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   552: ifeq +77 -> 629
    //   555: aload_0
    //   556: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   559: getfield 292	com/tencent/mobileqq/troopinfo/TroopInfoData:bOwner	Z
    //   562: ifeq +805 -> 1367
    //   565: iconst_1
    //   566: istore_2
    //   567: new 2313	bdlq
    //   570: dup
    //   571: aload_0
    //   572: getfield 308	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   575: invokespecial 2316	bdlq:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   578: ldc_w 332
    //   581: invokevirtual 2319	bdlq:a	(Ljava/lang/String;)Lbdlq;
    //   584: ldc_w 2321
    //   587: invokevirtual 2323	bdlq:b	(Ljava/lang/String;)Lbdlq;
    //   590: ldc_w 338
    //   593: invokevirtual 2325	bdlq:c	(Ljava/lang/String;)Lbdlq;
    //   596: ldc_w 2327
    //   599: invokevirtual 2329	bdlq:d	(Ljava/lang/String;)Lbdlq;
    //   602: iconst_2
    //   603: anewarray 581	java/lang/String
    //   606: dup
    //   607: iconst_0
    //   608: aload_0
    //   609: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   612: getfield 343	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: iload_2
    //   619: invokestatic 1201	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   622: aastore
    //   623: invokevirtual 2332	bdlq:a	([Ljava/lang/String;)Lbdlq;
    //   626: invokevirtual 2334	bdlq:a	()V
    //   629: aload_0
    //   630: getfield 1753	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   633: ifne +866 -> 1499
    //   636: aload_0
    //   637: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   640: getfield 1883	com/tencent/mobileqq/troopinfo/TroopInfoData:isNewTroop	Z
    //   643: ifne +856 -> 1499
    //   646: iconst_1
    //   647: istore 5
    //   649: aload_0
    //   650: iload 5
    //   652: invokespecial 1206	com/tencent/mobileqq/activity/ChatSettingForTroop:c	(Z)V
    //   655: aload_0
    //   656: invokevirtual 2336	com/tencent/mobileqq/activity/ChatSettingForTroop:l	()V
    //   659: aload_0
    //   660: getfield 308	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   663: aload_0
    //   664: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   667: getfield 2339	com/tencent/mobileqq/troopinfo/TroopInfoData:publicAccountUin	J
    //   670: new 2341	aegk
    //   673: dup
    //   674: aload_0
    //   675: invokespecial 2342	aegk:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   678: invokestatic 2347	bgrb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLnkq;)V
    //   681: aload_0
    //   682: invokevirtual 2349	com/tencent/mobileqq/activity/ChatSettingForTroop:k	()V
    //   685: aload_0
    //   686: invokespecial 2351	com/tencent/mobileqq/activity/ChatSettingForTroop:L	()V
    //   689: aload_0
    //   690: invokevirtual 1826	com/tencent/mobileqq/activity/ChatSettingForTroop:d	()V
    //   693: aload_0
    //   694: invokespecial 1586	com/tencent/mobileqq/activity/ChatSettingForTroop:O	()V
    //   697: aload_0
    //   698: invokevirtual 2353	com/tencent/mobileqq/activity/ChatSettingForTroop:q	()V
    //   701: aload_0
    //   702: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   705: ifnull +21 -> 726
    //   708: aload_0
    //   709: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   712: aload_0
    //   713: getfield 308	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   716: aload_0
    //   717: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   720: getfield 1330	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   723: invokestatic 2356	bguq:a	(Lcom/tencent/mobileqq/data/TroopInfo;Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   726: aload_0
    //   727: invokevirtual 2358	com/tencent/mobileqq/activity/ChatSettingForTroop:f	()V
    //   730: aload 9
    //   732: astore 8
    //   734: aload_0
    //   735: getfield 2360	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   738: ifnull -598 -> 140
    //   741: aload_0
    //   742: getfield 2360	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   745: aload_0
    //   746: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   749: invokevirtual 2366	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:setTroopInfoData	(Lcom/tencent/mobileqq/troopinfo/TroopInfoData;)V
    //   752: aload_0
    //   753: getfield 2360	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   756: invokevirtual 2367	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	()V
    //   759: aload 9
    //   761: astore 8
    //   763: goto -623 -> 140
    //   766: astore 8
    //   768: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   771: ifeq +15 -> 786
    //   774: ldc_w 2369
    //   777: iconst_2
    //   778: aload 8
    //   780: invokevirtual 2370	java/lang/Exception:toString	()Ljava/lang/String;
    //   783: invokestatic 703	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   786: aload_1
    //   787: getfield 2212	KQQ/BatchResponse:seq	I
    //   790: iconst_1
    //   791: if_icmpne +92 -> 883
    //   794: aload 10
    //   796: ifnull +87 -> 883
    //   799: aload 10
    //   801: getfield 2216	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   804: invokevirtual 2219	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   807: ifeq +76 -> 883
    //   810: aload 10
    //   812: getfield 2216	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   815: invokevirtual 2222	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   818: invokevirtual 2228	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   821: astore 8
    //   823: new 2372	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   826: dup
    //   827: invokespecial 2373	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   830: astore 9
    //   832: aload 9
    //   834: aload 8
    //   836: invokevirtual 2374	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   839: pop
    //   840: aload 9
    //   842: getfield 2377	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   845: invokevirtual 2378	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   848: ifeq +35 -> 883
    //   851: aload_0
    //   852: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   855: getfield 1330	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   858: ifne +554 -> 1412
    //   861: aload_0
    //   862: getfield 2360	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   865: ifnull +18 -> 883
    //   868: aload_0
    //   869: getfield 2360	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   872: aload 9
    //   874: getfield 2377	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   877: invokevirtual 2241	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   880: invokevirtual 2380	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	(Ljava/util/List;)V
    //   883: aload_1
    //   884: getfield 2212	KQQ/BatchResponse:seq	I
    //   887: iconst_2
    //   888: if_icmpne -877 -> 11
    //   891: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   894: ifeq +13 -> 907
    //   897: ldc_w 2382
    //   900: iconst_2
    //   901: ldc_w 2384
    //   904: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   907: aload 10
    //   909: ifnull -898 -> 11
    //   912: aload 10
    //   914: getfield 2216	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   917: invokevirtual 2219	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   920: ifeq -909 -> 11
    //   923: aload 10
    //   925: getfield 2216	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   928: invokevirtual 2222	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   931: invokevirtual 2228	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   934: astore_1
    //   935: new 2386	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   938: dup
    //   939: invokespecial 2387	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   942: astore 9
    //   944: aload 9
    //   946: aload_1
    //   947: invokevirtual 2388	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   950: pop
    //   951: aload 9
    //   953: getfield 2391	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   956: invokevirtual 803	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   959: ifeq -948 -> 11
    //   962: aload 9
    //   964: getfield 2394	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   967: invokevirtual 2395	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   970: ifne +513 -> 1483
    //   973: aload 9
    //   975: getfield 2394	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   978: invokevirtual 2241	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   981: astore_1
    //   982: aload 9
    //   984: getfield 2398	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   987: invokevirtual 2395	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   990: ifne +487 -> 1477
    //   993: aload 9
    //   995: getfield 2398	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   998: invokevirtual 2241	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1001: astore 8
    //   1003: aload_0
    //   1004: getfield 308	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1007: bipush 52
    //   1009: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1012: checkcast 316	com/tencent/mobileqq/app/TroopManager
    //   1015: astore 10
    //   1017: aload 9
    //   1019: getfield 2391	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1022: invokevirtual 805	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1025: lstore 6
    //   1027: aload 10
    //   1029: lload 6
    //   1031: invokestatic 1295	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1034: invokevirtual 351	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   1037: astore 11
    //   1039: aload 11
    //   1041: ifnull -1030 -> 11
    //   1044: aload_1
    //   1045: ifnull +71 -> 1116
    //   1048: aload 11
    //   1050: aload_1
    //   1051: aload 8
    //   1053: invokevirtual 2402	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap787	(Ljava/util/List;Ljava/util/List;)V
    //   1056: aload 9
    //   1058: getfield 2405	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1061: invokevirtual 2406	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1064: ifeq +386 -> 1450
    //   1067: aload 9
    //   1069: getfield 2405	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1072: invokevirtual 2256	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1075: istore_2
    //   1076: aload 11
    //   1078: iload_2
    //   1079: i2l
    //   1080: putfield 2409	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   1083: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1086: ifeq +30 -> 1116
    //   1089: ldc_w 2382
    //   1092: iconst_2
    //   1093: new 282	java/lang/StringBuilder
    //   1096: dup
    //   1097: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   1100: ldc_w 2411
    //   1103: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: iload_2
    //   1107: invokevirtual 1378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1110: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1113: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1116: aload 9
    //   1118: getfield 2414	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1121: astore_1
    //   1122: aload_1
    //   1123: ifnull +19 -> 1142
    //   1126: aload 11
    //   1128: aload 9
    //   1130: getfield 2414	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1133: invokevirtual 2222	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1136: invokevirtual 2288	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1139: putfield 2417	com/tencent/mobileqq/data/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   1142: aload 9
    //   1144: getfield 2420	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1147: astore_1
    //   1148: aload_1
    //   1149: ifnull +19 -> 1168
    //   1152: aload 11
    //   1154: aload 9
    //   1156: getfield 2420	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1159: invokevirtual 2222	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1162: invokevirtual 2288	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1165: putfield 2423	com/tencent/mobileqq/data/TroopInfo:adminNameShow	Ljava/lang/String;
    //   1168: iconst_m1
    //   1169: istore_2
    //   1170: iconst_m1
    //   1171: istore_3
    //   1172: iconst_m1
    //   1173: istore 4
    //   1175: aload 9
    //   1177: getfield 2426	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1180: invokevirtual 2406	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1183: ifeq +23 -> 1206
    //   1186: aload 11
    //   1188: aload 9
    //   1190: getfield 2426	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1193: invokevirtual 2256	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1196: i2b
    //   1197: putfield 2429	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   1200: aload 11
    //   1202: getfield 2429	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   1205: istore_2
    //   1206: aload 9
    //   1208: getfield 2432	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1211: invokevirtual 2406	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1214: ifeq +23 -> 1237
    //   1217: aload 11
    //   1219: aload 9
    //   1221: getfield 2432	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1224: invokevirtual 2256	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1227: i2b
    //   1228: putfield 2435	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1231: aload 11
    //   1233: getfield 2435	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1236: istore_3
    //   1237: aload 9
    //   1239: getfield 2438	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1242: invokevirtual 2406	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1245: ifeq +24 -> 1269
    //   1248: aload 11
    //   1250: aload 9
    //   1252: getfield 2438	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1255: invokevirtual 2256	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1258: i2b
    //   1259: putfield 2441	com/tencent/mobileqq/data/TroopInfo:cNewGroupRankUserFlag	B
    //   1262: aload 11
    //   1264: getfield 2441	com/tencent/mobileqq/data/TroopInfo:cNewGroupRankUserFlag	B
    //   1267: istore 4
    //   1269: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1272: ifeq +56 -> 1328
    //   1275: ldc_w 2382
    //   1278: iconst_2
    //   1279: new 282	java/lang/StringBuilder
    //   1282: dup
    //   1283: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   1286: lload 6
    //   1288: invokevirtual 946	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1291: ldc_w 2443
    //   1294: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: iload_2
    //   1298: invokevirtual 1378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1301: ldc_w 2445
    //   1304: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: iload_3
    //   1308: invokevirtual 1378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1311: ldc_w 2447
    //   1314: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: iload 4
    //   1319: invokevirtual 1378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1322: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1325: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1328: new 2449	com/tencent/mobileqq/activity/ChatSettingForTroop$37
    //   1331: dup
    //   1332: aload_0
    //   1333: aload 10
    //   1335: aload 11
    //   1337: invokespecial 2452	com/tencent/mobileqq/activity/ChatSettingForTroop$37:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1340: bipush 8
    //   1342: aconst_null
    //   1343: iconst_0
    //   1344: invokestatic 2194	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1347: return
    //   1348: astore_1
    //   1349: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1352: ifeq -1341 -> 11
    //   1355: ldc_w 2382
    //   1358: iconst_2
    //   1359: aload_1
    //   1360: invokevirtual 2370	java/lang/Exception:toString	()Ljava/lang/String;
    //   1363: invokestatic 1327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1366: return
    //   1367: aload_0
    //   1368: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1371: getfield 373	com/tencent/mobileqq/troopinfo/TroopInfoData:bAdmin	Z
    //   1374: ifeq +120 -> 1494
    //   1377: iconst_2
    //   1378: istore_2
    //   1379: goto -812 -> 567
    //   1382: ldc_w 1370
    //   1385: iconst_1
    //   1386: new 282	java/lang/StringBuilder
    //   1389: dup
    //   1390: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   1393: ldc_w 2454
    //   1396: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: iload_2
    //   1400: invokevirtual 1378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1403: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1406: invokestatic 1327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1409: goto -1269 -> 140
    //   1412: aload_0
    //   1413: aload 9
    //   1415: getfield 2377	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1418: invokevirtual 2241	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1421: invokespecial 1070	com/tencent/mobileqq/activity/ChatSettingForTroop:c	(Ljava/util/List;)V
    //   1424: goto -541 -> 883
    //   1427: astore 8
    //   1429: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1432: ifeq -549 -> 883
    //   1435: ldc_w 2369
    //   1438: iconst_2
    //   1439: aload 8
    //   1441: invokevirtual 2370	java/lang/Exception:toString	()Ljava/lang/String;
    //   1444: invokestatic 703	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1447: goto -564 -> 883
    //   1450: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1453: ifeq -337 -> 1116
    //   1456: ldc_w 2382
    //   1459: iconst_2
    //   1460: ldc_w 2456
    //   1463: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1466: goto -350 -> 1116
    //   1469: astore_1
    //   1470: goto -302 -> 1168
    //   1473: astore_1
    //   1474: goto -332 -> 1142
    //   1477: aconst_null
    //   1478: astore 8
    //   1480: goto -477 -> 1003
    //   1483: aconst_null
    //   1484: astore_1
    //   1485: goto -503 -> 982
    //   1488: iconst_0
    //   1489: istore 4
    //   1491: goto -1381 -> 110
    //   1494: iconst_3
    //   1495: istore_2
    //   1496: goto -929 -> 567
    //   1499: iconst_0
    //   1500: istore 5
    //   1502: goto -853 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1505	0	this	ChatSettingForTroop
    //   0	1505	1	paramBatchResponse	KQQ.BatchResponse
    //   174	1322	2	i1	int
    //   106	1202	3	i2	int
    //   115	1375	4	i3	int
    //   647	854	5	bool	boolean
    //   1025	262	6	l1	long
    //   68	694	8	localObject1	Object
    //   766	13	8	localException1	Exception
    //   821	231	8	localObject2	Object
    //   1427	13	8	localException2	Exception
    //   1478	1	8	localObject3	Object
    //   77	1337	9	localObject4	Object
    //   19	1315	10	localObject5	Object
    //   98	1238	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	149	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   70	87	766	java/lang/Exception
    //   90	100	766	java/lang/Exception
    //   121	135	766	java/lang/Exception
    //   155	163	766	java/lang/Exception
    //   166	175	766	java/lang/Exception
    //   186	258	766	java/lang/Exception
    //   265	289	766	java/lang/Exception
    //   298	341	766	java/lang/Exception
    //   345	378	766	java/lang/Exception
    //   378	392	766	java/lang/Exception
    //   392	464	766	java/lang/Exception
    //   464	518	766	java/lang/Exception
    //   518	532	766	java/lang/Exception
    //   532	565	766	java/lang/Exception
    //   567	629	766	java/lang/Exception
    //   629	646	766	java/lang/Exception
    //   649	726	766	java/lang/Exception
    //   726	730	766	java/lang/Exception
    //   734	759	766	java/lang/Exception
    //   1367	1377	766	java/lang/Exception
    //   1382	1409	766	java/lang/Exception
    //   935	982	1348	java/lang/Exception
    //   982	1003	1348	java/lang/Exception
    //   1003	1039	1348	java/lang/Exception
    //   1048	1116	1348	java/lang/Exception
    //   1116	1122	1348	java/lang/Exception
    //   1142	1148	1348	java/lang/Exception
    //   1175	1206	1348	java/lang/Exception
    //   1206	1237	1348	java/lang/Exception
    //   1237	1269	1348	java/lang/Exception
    //   1269	1328	1348	java/lang/Exception
    //   1328	1347	1348	java/lang/Exception
    //   1450	1466	1348	java/lang/Exception
    //   823	883	1427	java/lang/Exception
    //   1412	1424	1427	java/lang/Exception
    //   1152	1168	1469	java/lang/Exception
    //   1126	1142	1473	java/lang/Exception
  }
  
  public void a(aelh paramaelh, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramaelh.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_Aoof.b(paramaelh.jdField_a_of_type_Int, paramaelh.jdField_a_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bhmq.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Aoof.a())
        {
          this.jdField_a_of_type_Aoof.a(paramaelh.jdField_a_of_type_JavaLangString, paramaelh.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramaelh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  protected void a(View paramView)
  {
    int[] arrayOfInt = new int[6];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131379480;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131379481;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131379482;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131379483;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131379484;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131379485;
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
      f();
    }
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject = null;
    String str;
    if (paramTroopMemberInfo != null)
    {
      str = paramTroopMemberInfo.troopColorNick;
      localObject = paramTroopMemberInfo.troopnick;
      paramTroopMemberInfo = str;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "updateNickUseTroopMemberInfo and colorNick is " + paramTroopMemberInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick = paramTroopMemberInfo;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = ((String)localObject);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      }
      return;
      str = null;
      paramTroopMemberInfo = (TroopMemberInfo)localObject;
      localObject = str;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramString;
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = paramString;
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopName = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop;
      bguq.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    bdll.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
  }
  
  public void a(List<oidb_0x899.memberlist> paramList)
  {
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
    this.jdField_a_of_type_AndroidOsHandler.post(new ChatSettingForTroop.20(this));
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    label314:
    label870:
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
                    break label1054;
                  }
                  QLog.i("Q.chatopttroop", 2, "checkApiState onResult, basics name = " + str + " state = " + i1 + " api = " + (String)localObject1 + " msg = " + (String)localObject2 + "\n");
                  break label1054;
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
                    runOnUiThread(new ChatSettingForTroop.52(this));
                  }
                  if (!QLog.isColorLevel()) {
                    break label1061;
                  }
                  QLog.i("Q.chatopttroop", 2, "checkApiState onResult, friendlink name = " + str + " state = " + i1 + " api = " + (String)localObject1 + " msg= " + (String)localObject2 + "\n");
                  break label1061;
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
                    break label969;
                  }
                  d(true);
                  bdll.b(this.app, "CliOper", "", "", "0x80084B5", "0x80084B5", 0, 0, "", "", "", "");
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
              d(getActivity().getResources().getString(2131718918));
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.chatopttroop", 2, "joinGroup onResult " + paramJSONObject.toString());
    return;
    label969:
    paramJSONObject = getActivity().getResources().getString(2131718918);
    switch (paramInt)
    {
    }
    for (;;)
    {
      d(paramJSONObject);
      break label870;
      paramJSONObject = getActivity().getResources().getString(2131718913);
      continue;
      paramJSONObject = getActivity().getResources().getString(2131718919);
      continue;
      label1054:
      paramInt += 1;
      break;
      label1061:
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
        break label1241;
      }
      ((View)localObject1).setVisibility(0);
      b(paramRspBody.extra_info.tab_infos.get());
      return;
      bdgb.b();
      bool2 = ThemeUtil.isInNightMode(this.app);
      localView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379424));
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        break label411;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131707854));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new aegt(this));
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      i4 = localList.size();
      localObject1 = localView.findViewById(2131379348);
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
      localObject1 = localView.findViewById(2131379334);
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
        localImageView = (ImageView)((View)localObject1).findViewById(2131362822);
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131362841);
        localObject4 = (TextView)((View)localObject1).findViewById(2131362839);
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
          break label1142;
        }
        ((TextView)localObject4).setVisibility(0);
        ((TextView)localObject4).setText("");
        ((TextView)localObject4).setBackgroundResource(0);
        ((TextView)localObject4).setCompoundDrawablesWithIntrinsicBounds(2130850400, 0, 0, 0);
        ((StringBuffer)localObject3).append("，新");
        label650:
        long l1 = localAppInfo.appid.get();
        if ((i3 != -1) && (l1 == 1L))
        {
          if (!bhlk.a(this.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false)) {
            break label1204;
          }
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText("");
          ((TextView)localObject4).setBackgroundResource(0);
          ((TextView)localObject4).setCompoundDrawablesWithIntrinsicBounds(2130850400, 0, 0, 0);
        }
        label728:
        if (l1 == 0L) {
          MiniProgramLpReportDC04239.reportByQQqunInfo("qun", "qun_info", "expo_more", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (!localAppInfo.icon.has()) {
          break label1214;
        }
        localObject2 = localAppInfo.icon.get();
        label775:
        localObject4 = localImageView.getContext();
        if (localAppInfo.show_frame.get() != 1) {
          break label1222;
        }
      }
      label1204:
      label1214:
      label1222:
      for (bool1 = true;; bool1 = false)
      {
        bgqr.a((Context)localObject4, localImageView, (String)localObject2, 40.0F, bool1);
        if (MiniAppLauncher.isMiniAppUrl(localAppInfo.url.get())) {
          bguq.a(localAppInfo, "expo", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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
            bdll.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800AFC3", "0X800AFC3", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt), String.valueOf(((oidb_0xe83.AppInfo)localObject2).appid.get()), String.valueOf(((oidb_0xe83.AppInfo)localObject2).appid.get()) + "-" + String.valueOf(i3 + 1), "");
          }
          i3 += 1;
        }
        localObject1 = localView.findViewById(2131379335);
        break label448;
        localObject1 = localView.findViewById(2131379336);
        break label448;
        localObject1 = localView.findViewById(2131379337);
        break label448;
        localObject1 = localView.findViewById(2131379338);
        break label448;
        localObject1 = localView.findViewById(2131379339);
        break label448;
        localObject1 = localView.findViewById(2131379340);
        break label448;
        localObject1 = localView.findViewById(2131379341);
        break label448;
        localObject1 = localView.findViewById(2131379342);
        break label448;
        localObject1 = localView.findViewById(2131379343);
        break label448;
        ((View)localObject1).setVisibility(4);
        break;
        label1142:
        if (i3 > 0)
        {
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText(String.valueOf(i3));
          ((TextView)localObject4).setBackgroundResource(2130850404);
          ((StringBuffer)localObject3).append("，").append(i3).append("未读");
          break label650;
        }
        ((TextView)localObject4).setVisibility(8);
        break label650;
        ((TextView)localObject4).setVisibility(8);
        break label728;
        localObject2 = "";
        break label775;
      }
      ((View)localObject1).setContentDescription(((StringBuffer)localObject3).toString());
    }
    label1241:
    ((View)localObject1).setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "updateEnterEffectStatus  isShow = " + paramBoolean);
    }
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[18];
    if (localFormSimpleItem == null) {}
    bftt localbftt;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      localFormSimpleItem.setVisibility(0);
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[17];
      if ((localObject != null) && ((localObject instanceof FormSimpleItem))) {
        ((FormSimpleItem)localObject).setBgType(2);
      }
      localObject = (bfui)this.app.getManager(231);
      localbftt = ((bfui)localObject).a();
    } while (localbftt == null);
    if (localbftt.b > 0)
    {
      localFormSimpleItem.setRightText(localbftt.jdField_a_of_type_JavaLangString);
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    Object localObject = ((bfui)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (localObject != null)
    {
      if (((bftu)localObject).jdField_a_of_type_Int == 0)
      {
        localFormSimpleItem.setRightText(anzj.a(2131700653));
        return;
      }
      localFormSimpleItem.setRightText(((bftu)localObject).jdField_a_of_type_JavaLangString);
      return;
    }
    localFormSimpleItem.setRightText(anzj.a(2131700661));
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
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = bguq.a(localBundle, this);
      bool2 = bool3;
      TroopInfo localTroopInfo = bguq.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this);
      if (localTroopInfo != null)
      {
        bool2 = bool3;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
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
      bguq.jdField_a_of_type_Int = localBundle.getInt("exposureSource", 99);
      bool2 = bool1;
      this.jdField_j_of_type_Boolean = localBundle.getBoolean("fromThirdAppByOpenSDK");
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
      nnc.a(this.app, 69);
    }
    return bool2;
  }
  
  protected void b()
  {
    if (!bhnv.g(getApplicationContext())) {}
    aoip localaoip;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "initNetworkRequests");
      }
      localaoip = (aoip)this.app.a(20);
      ArrayList localArrayList;
      if (localaoip != null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        localaoip.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, localArrayList);
      }
      if (localaoip != null)
      {
        m();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
          localaoip.a(localArrayList);
          localaoip.i(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
      this.jdField_a_of_type_Npk = new npk(this.app);
      E();
    } while (localaoip == null);
    localaoip.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false, this.jdField_j_of_type_Int, 1);
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
        m();
      }
    }
    ThreadManager.post(new ChatSettingForTroop.41(this), 8, null, true);
  }
  
  protected void b(View paramView)
  {
    if (paramView == null) {}
    TextView localTextView;
    do
    {
      return;
      localTextView = (TextView)paramView.findViewById(2131378936);
      paramView = paramView.findViewById(2131376648);
    } while ((localTextView == null) || (paramView == null) || (TextUtils.isEmpty(localTextView.getText())));
    int i1 = (int)localTextView.getPaint().measureText(localTextView.getText().toString());
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).leftMargin = (agej.a(30.0F, getResources()) + i1);
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
        ((View)localObject).setTag(2131378440, str3);
        ((View)localObject).setTag(2131378409, localTabInfo);
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
            this.jdField_a_of_type_JavaLangString = bguq.a((View)localObject, localTabInfo);
            bhju.a("Grp_set", "Grp_aio_subscription", "subscription_exp", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) });
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
        ThreadManager.post(new ChatSettingForTroop.22(this), 5, null, true);
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
  
  public void c()
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839410);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131297994));
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
    if (!bhnv.g(getApplicationContext())) {
      QQToast.a(getApplicationContext(), 1, getString(2131693965), 1).b(getTitleBarHeight());
    }
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aeft(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
          this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + anzj.a(2131700662));
        }
      }
      if (this.jdField_e_of_type_JavaUtilList != null) {
        a(this.jdField_e_of_type_JavaUtilList);
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager;
      if ((this.jdField_a_of_type_ArrayOfAndroidViewView[6] == null) || (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null)) {
        break;
      }
      ThreadManager.post(new ChatSettingForTroop.42(this, paramIntent), 8, null, true);
      return;
    }
  }
  
  protected void d()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[23];
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    localObject = (TextView)((View)localObject).findViewById(2131379450);
    ((TextView)localObject).setTag(Integer.valueOf(39));
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i1 = 0;
    }
    if (i1 > 0)
    {
      String str = String.format(getResources().getString(2131693055), new Object[] { Integer.valueOf(i1) });
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
  
  protected void d(int paramInt, Intent paramIntent)
  {
    n();
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      ThreadManager.post(new ChatSettingForTroop.43(this, paramIntent), 8, null, true);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      String str = bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      if (paramInt2 == -1) {}
      for (paramIntent = "0";; paramIntent = "1")
      {
        bhju.a("Grp_share", "grpData_admin", "share_qzone", 0, 0, new String[] { localObject, str, paramIntent });
        return;
      }
      if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("select_member_add_request_ok", false)))
      {
        this.r = true;
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
          ThreadManager.post(new ChatSettingForTroop.44(this), 8, null, true);
        }
        f();
        return;
        a(paramInt2, paramIntent);
        return;
        if (paramInt2 == -1)
        {
          setResult(-1);
          this.jdField_l_of_type_Boolean = true;
          return;
          b(paramInt2, paramIntent);
          return;
          c(paramInt2, paramIntent);
          return;
          ((aoip)this.app.a(20)).g(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          return;
          d(paramInt2, paramIntent);
          e(paramInt2, paramIntent);
          return;
          if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramInt2 == -1))
          {
            paramIntent = paramIntent.getExtras();
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation = paramIntent.getString("location");
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat = paramIntent.getInt("lat", 0);
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon = paramIntent.getInt("lon", 0);
            k();
            return;
            if (paramInt2 == -1)
            {
              if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
              {
                paramIntent = new Intent();
                paramIntent.putExtra("isNeedFinish", true);
                setResult(-1, paramIntent);
              }
              finish();
              return;
              if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("has_operation", false)))
              {
                this.jdField_a_of_type_AndroidContentIntent = paramIntent;
                return;
                if (paramInt2 == -1)
                {
                  paramIntent = agej.a(new Intent(this, SplashActivity.class), null);
                  paramIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                  paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName());
                  paramIntent.putExtra("uintype", 1);
                  startActivity(paramIntent);
                  setResult(-1);
                  finish();
                  return;
                  e(paramInt2, paramIntent);
                  return;
                  paramIntent = (bfui)this.app.getManager(231);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.chatopttroop", 2, "doOnActivityResult REQUEST_FOR_ENTER_EFFECT_SETTING  effectManager.isAllTroopShowEnterance() = " + paramIntent.b());
                  }
                  if (paramIntent.b())
                  {
                    a(true);
                    return;
                    boolean bool1 = paramIntent.getBooleanExtra("disabled", true);
                    localObject = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[41];
                    if (localObject != null)
                    {
                      if (bool1) {}
                      for (paramIntent = getResources().getString(2131695545);; paramIntent = getResources().getString(2131695546))
                      {
                        ((FormSimpleItem)localObject).setRightText(paramIntent);
                        return;
                      }
                      if ((paramInt2 == -1) && (paramIntent != null))
                      {
                        if (!bhnv.g(this))
                        {
                          QQToast.a(this, 1, 2131693966, 0).b(getTitleBarHeight());
                          return;
                        }
                        paramIntent = paramIntent.getStringExtra("result");
                        if ((!TextUtils.isEmpty(paramIntent)) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (!paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname)))
                        {
                          localObject = (antz)this.app.a(22);
                          bool1 = bool2;
                          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
                          {
                            bool1 = bool2;
                            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1) {
                              bool1 = true;
                            }
                          }
                          ((antz)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramIntent, bool1);
                          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetTroopHead())) {
                            this.jdField_e_of_type_Boolean = true;
                          }
                          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.oldTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname;
                          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramIntent;
                          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
                          e();
                          return;
                          str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                          long l1 = 0L;
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
                              paramIntent = (TroopManager)this.app.getManager(52);
                              if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
                                this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramIntent.b(str);
                              }
                              if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
                              {
                                this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.updateLastMemoFromWeb((String)localObject);
                                paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
                              }
                            }
                          }
                          for (paramIntent = (Intent)localObject; QLog.isColorLevel(); paramIntent = (Intent)localObject)
                          {
                            QLog.i("Q.chatopttroop", 2, String.format("doOnActivityResult get last memo [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(bool1), str, Long.valueOf(l1), paramIntent }));
                            return;
                            bool1 = false;
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
  
  public void doOnBackPressed()
  {
    Q();
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    ImmersiveUtils.a(true, getWindow());
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("appid");
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("openid");
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("share_uin");
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("is_from_game");
    if (("true".equals(this.jdField_g_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      bguq.a(this.app, getApplicationContext(), this.jdField_d_of_type_JavaLangString, this, 0, null);
      this.jdField_h_of_type_JavaLangString = getIntent().getStringExtra("guild_id");
      this.jdField_i_of_type_JavaLangString = getIntent().getStringExtra("zone_id");
      this.jdField_j_of_type_JavaLangString = getIntent().getStringExtra("role_id");
      this.jdField_k_of_type_JavaLangString = getIntent().getStringExtra("gc");
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "joinGroup appid = " + this.jdField_d_of_type_JavaLangString + " openid = " + this.jdField_e_of_type_JavaLangString + " guild id = " + this.jdField_h_of_type_JavaLangString + "zone_id = " + this.jdField_i_of_type_JavaLangString + " role id = " + this.jdField_j_of_type_JavaLangString + "  group code= " + this.jdField_k_of_type_JavaLangString);
      }
      paramBundle = String.valueOf(this.jdField_d_of_type_JavaLangString);
      if ((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) || (this.jdField_f_of_type_JavaLangString.equals(this.app.getAccount()))) {
        break label394;
      }
      s();
      label313:
      if (!QLog.isColorLevel()) {
        break label1178;
      }
    }
    label394:
    label1178:
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
      Object localObject;
      if (!a())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "onCreate, illegal param, troopuin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        finish();
        return false;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.chatopttroop", 2, " joinGroup is from game = false");
        break;
        if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          break label313;
        }
        localObject = this.app.a().a(paramBundle);
        if (localObject == null)
        {
          o();
          this.jdField_b_of_type_AndroidOsHandler = new Handler();
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(new ChatSettingForTroop.2(this), 3000L);
          this.app.addObserver(this.jdField_a_of_type_Noa);
          this.app.a().d(paramBundle);
          break label313;
        }
        if (this.jdField_e_of_type_JavaLangString.equals(((OpenID)localObject).openID)) {
          break label313;
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.chatopttroop", 2, "-->preForward--openid doesn't equal current local openid");
        }
        s();
        break label313;
      }
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
      for (;;)
      {
        try
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
            bguq.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaUtilArrayList);
          }
          this.jdField_a_of_type_Bhru = ((bhru)this.app.getManager(31));
          a();
          a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
          if (!b()) {
            z();
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "onCreate(), time = " + (System.currentTimeMillis() - l1));
          }
          ThreadManager.getSubThreadHandler().post(new ChatSettingForTroop.3(this));
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
          {
            paramBundle = "0";
            a("Grp_Admin_data", "Clk_data", paramBundle);
            nnc.a(this.app, 65);
            paramBundle = new IntentFilter();
            paramBundle.addAction("start_recomend_page");
            paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            paramBundle.addAction("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER");
            registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
            addObserver(this.jdField_d_of_type_Aojs);
            addObserver(this.jdField_c_of_type_Aojs);
            bguq.a(this.app);
            this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(52));
            paramBundle = (TroopManager)this.app.getManager(52);
            if (paramBundle != null)
            {
              paramBundle = paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              if ((paramBundle != null) && (paramBundle.isGameBind())) {
                bhju.a("Grp_game", "Grp_data", "data_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
              }
            }
            this.app.addObserver(this.jdField_a_of_type_Bhzs);
            VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "group_nickname_1", "", 1, 0, 0, "", "", "");
            bdll.b(this.app, "dc00898", "", "", "0X800A523", "0X800A523", 0, 0, "", "", "", "");
            bdll.b(this.app, "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_exp", 0, 0, "", "", "", "");
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
            {
              boolean bool = bhlk.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
              paramBundle = (bfez)aran.a().a(664);
              localObject = (aoip)this.app.a(20);
              if ((paramBundle != null) && (paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) && (localObject != null) && (bool)) {
                ((aoip)localObject).z(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              }
            }
            return true;
          }
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
        paramBundle = "1";
      }
    }
  }
  
  /* Error */
  public void doOnDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 2104	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   4: ifnull +14 -> 18
    //   7: aload_0
    //   8: getfield 2104	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   11: invokevirtual 3254	android/widget/Button:getBackground	()Landroid/graphics/drawable/Drawable;
    //   14: aconst_null
    //   15: invokevirtual 3257	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 3259	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_f_of_type_Boolean	Z
    //   23: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +385 -> 411
    //   29: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   32: lstore_1
    //   33: ldc 2
    //   35: monitorenter
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 2728	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Boolean	Z
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: getfield 969	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Aoof	Laoof;
    //   48: ifnull +10 -> 58
    //   51: aload_0
    //   52: getfield 969	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Aoof	Laoof;
    //   55: invokevirtual 3260	aoof:d	()V
    //   58: aload_0
    //   59: getfield 991	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bgwe	Lbgwe;
    //   62: ifnull +10 -> 72
    //   65: aload_0
    //   66: getfield 991	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bgwe	Lbgwe;
    //   69: invokevirtual 3261	bgwe:a	()V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 219	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Noa	Lnoa;
    //   77: invokevirtual 3264	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lanui;)V
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 202	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Anyu	Lanyu;
    //   85: invokevirtual 3264	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lanui;)V
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 207	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Anua	Lanua;
    //   93: invokevirtual 3264	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lanui;)V
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 192	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_Aojs	Laojs;
    //   101: invokevirtual 3264	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lanui;)V
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 187	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Aojs	Laojs;
    //   109: invokevirtual 3264	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lanui;)V
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 144	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Aojs	Laojs;
    //   117: invokevirtual 3264	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lanui;)V
    //   120: aload_0
    //   121: aload_0
    //   122: getfield 197	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Aojs	Laojs;
    //   125: invokevirtual 3264	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lanui;)V
    //   128: aload_0
    //   129: getfield 308	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   132: aload_0
    //   133: getfield 229	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bhzs	Lbhzs;
    //   136: invokevirtual 3265	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lanui;)V
    //   139: aload_0
    //   140: getfield 182	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   143: ifnull +11 -> 154
    //   146: aload_0
    //   147: getfield 182	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   150: aconst_null
    //   151: invokevirtual 3268	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   154: aload_0
    //   155: getfield 2868	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   158: ifnull +30 -> 188
    //   161: aload_0
    //   162: getfield 2868	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   165: checkcast 2877	android/graphics/drawable/Animatable
    //   168: invokeinterface 3271 1 0
    //   173: ifeq +15 -> 188
    //   176: aload_0
    //   177: getfield 2868	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   180: checkcast 2877	android/graphics/drawable/Animatable
    //   183: invokeinterface 3274 1 0
    //   188: aload_0
    //   189: invokestatic 3279	bhaq:a	(Landroid/content/Context;)Lbhaq;
    //   192: invokevirtual 3280	bhaq:a	()V
    //   195: aload_0
    //   196: getfield 3282	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bjbs	Lbjbs;
    //   199: ifnull +10 -> 209
    //   202: aload_0
    //   203: getfield 3282	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bjbs	Lbjbs;
    //   206: invokevirtual 3285	bjbs:dismiss	()V
    //   209: aload_0
    //   210: getfield 470	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Npk	Lnpk;
    //   213: ifnull +10 -> 223
    //   216: aload_0
    //   217: getfield 470	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Npk	Lnpk;
    //   220: invokevirtual 3286	npk:a	()V
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 153	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   228: invokevirtual 3290	com/tencent/mobileqq/activity/ChatSettingForTroop:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   231: aload_0
    //   232: getfield 3125	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   235: ifnull +11 -> 246
    //   238: aload_0
    //   239: getfield 3125	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   242: aconst_null
    //   243: invokevirtual 3268	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   246: aload_0
    //   247: aconst_null
    //   248: putfield 3292	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bhpc	Lbhpc;
    //   251: aload_0
    //   252: getfield 2112	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView	Lcom/tencent/mobileqq/widget/QQBlurView;
    //   255: ifnull +10 -> 265
    //   258: aload_0
    //   259: getfield 2112	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView	Lcom/tencent/mobileqq/widget/QQBlurView;
    //   262: invokevirtual 3294	com/tencent/mobileqq/widget/QQBlurView:c	()V
    //   265: aload_0
    //   266: getfield 3296	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bhbx	Lbhbx;
    //   269: ifnull +10 -> 279
    //   272: aload_0
    //   273: getfield 3296	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bhbx	Lbhbx;
    //   276: invokevirtual 3299	bhbx:e	()V
    //   279: aload_0
    //   280: invokespecial 551	com/tencent/mobileqq/activity/ChatSettingForTroop:H	()V
    //   283: aload_0
    //   284: invokespecial 3301	com/tencent/mobileqq/app/BaseActivity:doOnDestroy	()V
    //   287: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq +34 -> 324
    //   293: ldc_w 280
    //   296: iconst_2
    //   297: new 282	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 3303
    //   307: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokestatic 639	java/lang/System:currentTimeMillis	()J
    //   313: lload_1
    //   314: lsub
    //   315: invokevirtual 946	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   318: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 703	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: return
    //   325: astore_3
    //   326: ldc 2
    //   328: monitorexit
    //   329: aload_3
    //   330: athrow
    //   331: astore_3
    //   332: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq -104 -> 231
    //   338: ldc_w 280
    //   341: iconst_2
    //   342: new 282	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 3305
    //   352: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_3
    //   356: invokevirtual 3306	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   359: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 1327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: goto -137 -> 231
    //   371: astore_3
    //   372: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq -144 -> 231
    //   378: ldc_w 280
    //   381: iconst_2
    //   382: new 282	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   389: ldc_w 3305
    //   392: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_3
    //   396: invokevirtual 3307	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   399: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 1327	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: goto -177 -> 231
    //   411: lconst_0
    //   412: lstore_1
    //   413: goto -380 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	ChatSettingForTroop
    //   32	381	1	l1	long
    //   325	5	3	localObject	Object
    //   331	25	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   371	25	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   36	44	325	finally
    //   326	329	325	finally
    //   223	231	331	java/lang/IllegalArgumentException
    //   223	231	371	java/lang/Exception
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
      Object localObject;
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_k_of_type_Boolean = false;
        String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        String str2 = bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
        {
          localObject = "1";
          label130:
          bhju.a("Grp_set_new", "grpData_admin", "exp", 0, 0, new String[] { str1, str2, localObject });
          label163:
          if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (!bgpy.a(this.app))) {}
        }
      }
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        ((aoip)this.app.a(20)).g(l1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
        P();
        N();
        bdll.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F6", 0, 1, 0, "", "", "", "");
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[40] != null) {
          w();
        }
        u();
        v();
        return;
        i1 = 0;
        continue;
        localObject = "0";
        break label130;
        localObject = (bgqm)this.app.getManager(109);
        if ((localObject != null) && (((bgqm)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
        {
          localObject = (aoip)this.app.a(20);
          if (localObject != null) {
            ((aoip)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true, this.jdField_j_of_type_Int, 1);
          }
        }
        if (!this.q) {
          break label163;
        }
        m();
        this.q = false;
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
    if (!this.jdField_g_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStart add observer");
      }
      addObserver(this.jdField_a_of_type_Anyu);
      addObserver(this.jdField_a_of_type_Anua);
      addObserver(this.jdField_a_of_type_Aojs);
      addObserver(this.jdField_b_of_type_Aojs);
      addObserver(this.jdField_c_of_type_Aojs);
      this.jdField_g_of_type_Boolean = true;
    }
    if (this.jdField_h_of_type_Boolean) {
      this.jdField_h_of_type_Boolean = false;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_g_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStop remove observer");
      }
      removeObserver(this.jdField_a_of_type_Anyu);
      removeObserver(this.jdField_a_of_type_Anua);
      removeObserver(this.jdField_b_of_type_Aojs);
      this.jdField_g_of_type_Boolean = false;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void e()
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
        StringBuilder localStringBuilder = new StringBuilder().append(anzj.a(2131700646)).append(str);
        if (!bool) {
          break label259;
        }
        localObject = anzj.a(2131700635);
        label85:
        localView.setContentDescription((String)localObject);
      }
      a(localView, new begb(str, 32).a(), null, null);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateTroopNameEntry %s", new Object[] { str }));
      }
    }
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[36];
    if (localObject != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
      if (!TextUtils.isEmpty(str)) {
        break label266;
      }
      str = anzj.a(2131700663);
    }
    label259:
    label266:
    for (;;)
    {
      ((TextView)localObject).setText(str);
      if (AppSetting.jdField_c_of_type_Boolean) {
        ((View)localObject).setContentDescription(anzj.a(2131700630) + str);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateHostTroopNameEntry %s", new Object[] { str }));
      }
      return;
      label249:
      str = anzj.a(2131700673);
      break;
      localObject = "";
      break label85;
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
        if (this.jdField_a_of_type_Bjbv == null) {
          this.jdField_a_of_type_Bjbv = new bjbv(this);
        }
        this.jdField_a_of_type_Bjbv.a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.isEmpty(paramIntent)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopOwner(paramIntent, this.app.getCurrentAccountUin());
        }
        X();
        F();
        if (this.jdField_a_of_type_Bjbv == null) {
          this.jdField_a_of_type_Bjbv = new bjbv(this);
        }
        this.jdField_a_of_type_Bjbv.a(1, str, 1000);
        return;
      }
    } while (!bool);
    paramIntent = new Intent();
    paramIntent.putExtra("isNeedFinish", true);
    setResult(-1, paramIntent);
    finish();
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.jdField_c_of_type_Int, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int, this.jdField_f_of_type_Int);
      if (this.jdField_a_of_type_Aehe == null)
      {
        this.jdField_a_of_type_Aehe = new aehe(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Aehe);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Aehe.notifyDataSetChanged();
  }
  
  protected void g()
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
      aoip localaoip = (aoip)this.app.a(20);
      if (localaoip != null) {
        localaoip.a(true, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, 6);
      }
      localSharedPreferences.edit().putLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, System.currentTimeMillis()).commit();
    }
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 5, null, false);
  }
  
  protected void h()
  {
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label199;
      }
      bgpk.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "troopProfile");
      bdll.b(this.app, "P_CliOper", "Grp_edu", "", "Grp_data", "mbercard_Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    }
    for (;;)
    {
      bdll.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_modifydata", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      bhju.a("Grp_set_new", "grpData_admin", "clk_modifydata", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "group_nickname_2", "", 1, 0, 0, "", "", "");
      return;
      i1 = 0;
      break;
      label199:
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick;
      Intent localIntent = new Intent(this, EditInfoActivity.class);
      localIntent.putExtra("edit_type", 0);
      localIntent.putExtra("title", getString(2131696899));
      localIntent.putExtra("default_text", str);
      localIntent.putExtra("isTroopNick", true);
      localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uin", this.app.getAccount());
      localIntent.putExtra("max_num", 60);
      localIntent.putExtra("from", 0);
      startActivityForResult(localIntent, 2);
    }
  }
  
  protected void i()
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
        bdll.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", (String)localObject, "");
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject = "1";
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 15) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 10) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 11)) {
      bdll.b(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
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
    bdll.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    TroopLocationModifyActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation, 12);
  }
  
  public void k()
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
  
  public void l()
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
  
  protected void m()
  {
    aoip localaoip = (aoip)this.app.a(20);
    if (localaoip == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break label110;
        }
        localaoip.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1000L);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break label127;
        }
        localaoip.c(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.chatopttroop", 2, localException.toString());
      return;
      label110:
      localException.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1000L);
    }
    label127:
    localException.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  protected void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, getResources(), this.app.getCurrentAccountUin());
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop = false;
        bguq.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
      }
    }
    e();
    L();
    q();
  }
  
  public void o()
  {
    try
    {
      if (this.jdField_a_of_type_Bjbs == null)
      {
        this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_Bjbs.c(2131694176);
        this.jdField_a_of_type_Bjbs.c(false);
      }
      this.jdField_a_of_type_Bjbs.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
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
        f(paramBoolean);
        break;
      case 19: 
        h(paramBoolean);
        break;
      case 10: 
        g(paramBoolean);
        break;
      case 31: 
        a(1, paramBoolean);
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
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && ((localObject1 instanceof Integer)))
      {
        i1 = ((Integer)localObject1).intValue();
        switch (i1)
        {
        }
      }
    }
    label402:
    label442:
    label3774:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = paramView.getTag();
      break;
      boolean bool;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      if ((armu.c().mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
      {
        bool = aojn.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
        {
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          if (bool)
          {
            i1 = 15;
            localObject5 = VipUtils.a(0, i1).toString();
            localObject6 = anzj.a(2131700645);
            localObject7 = new aegb(this, bool);
            if (!bool) {
              break label508;
            }
            localObject1 = "0X800A57F";
            if (!bool) {
              break label516;
            }
            i1 = 1;
            label449:
            VipUtils.a(this, (String)localObject4, (String)localObject5, (String)localObject6, (DialogInterface.OnClickListener)localObject7, (String)localObject1, i1, bool);
          }
        }
        for (;;)
        {
          bdll.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
          break;
          i1 = 8;
          break label402;
          label508:
          localObject1 = "0X8009E38";
          break label442;
          i1 = 3;
          break label449;
          VipUtils.a(this, bool);
        }
      }
      J();
      continue;
      h();
      continue;
      i();
      a("Grp_Admin_data", "Clk_mber", "");
      bhju.a("Grp_set_new", "grpData_admin", "clk_mber", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      continue;
      g();
      bhju.a("Grp_set_new", "grpData_admin", "clk_invite_new", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      continue;
      localObject1 = paramView.getTag(2131378424);
      label2623:
      label4545:
      label4804:
      if ((localObject1 instanceof String))
      {
        localObject1 = (String)localObject1;
        label4550:
        label4686:
        if (((bgty)this.app.getManager(203)).b((String)localObject1))
        {
          bgpy.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject1);
        }
        else
        {
          localObject4 = new Bundle();
          ((Bundle)localObject4).putString("selfSet_leftViewText", getString(2131718960));
          ((Bundle)localObject4).putString("custom_leftbackbutton_name", getTitle().toString());
          azyo.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject1, 1, -1, (Bundle)localObject4);
          continue;
          localObject1 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          localObject4 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
          ((Intent)localObject4).putExtra("url", (String)localObject1);
          startActivity((Intent)localObject4);
          bdll.b(this.app, "dc00899", "Grp_certified", "", "data", "clk_data", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
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
            bdll.b(this.app, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            nnc.a(this.app, 72);
            break;
          }
          G();
          bhju.a("Grp_msg", "grpData_admin", "Clk_msgSet", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
          continue;
          ChatHistoryActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1001);
          bdll.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_chatrecord", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
          bhju.a("Grp_set_new", "grpData_admin", "clk_chatRecord", 1, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
          bdll.b(this.app, "dc00898", "", "", "0X800A0B8", "0X800A0B8", 0, 0, "", "", "", "");
          continue;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          ((Intent)localObject1).putExtra("uintype", 1);
          MessageNotificationSettingFragment.a(this, (Intent)localObject1);
          continue;
          localObject1 = TroopMemberListActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 19);
          ((Intent)localObject1).putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
          startActivityForResult((Intent)localObject1, 9);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin());
          bhju.a("Grp_edu", "Grp_data", "teachermsg_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a((TroopMemberInfo)localObject1) });
          continue;
          QQToast.a(this, anzj.a(2131700639), 0).a();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("extra.GROUP_UIN", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
          EntryDebugFragment.a(this, (Bundle)localObject1);
          continue;
          d(false);
          if (this.jdField_h_of_type_Int == 2) {
            bdll.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
          }
          i1 = getIntent().getIntExtra("extra_share_group_from", 0);
          if (i1 != 0) {
            yup.a("story_grp", "clk_msg", i1, 0, new String[0]);
          }
          localObject1 = this.app;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
          for (i1 = 1;; i1 = 2)
          {
            bdll.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800A526", "0X800A526", i1, 0, bguq.a() + "", "", "", "");
            break;
          }
          bguq.a("RED_POINT_KEY_TROOP_ADMIN");
          if (this.o) {
            bguq.a("RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
          }
          bguq.a(false, (TextView)paramView.findViewById(2131376648));
          localObject5 = new Intent();
          ((Intent)localObject5).putExtra("uin", this.app.getCurrentAccountUin());
          ((Intent)localObject5).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          ((Intent)localObject5).putExtra("forward_location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
          ((Intent)localObject5).putExtra("forward_latitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
          ((Intent)localObject5).putExtra("forward_longitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
          ((Intent)localObject5).putExtra("forward_cityid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId);
          ((Intent)localObject5).putExtra("troop_auth_submit_time", this.jdField_i_of_type_Int);
          ((Intent)localObject5).putExtra("leftViewText", getResources().getString(2131690667));
          ((Intent)localObject5).putExtra("key_qidian_private_troop", this.jdField_d_of_type_Boolean);
          ((Intent)localObject5).putExtra("key_is_update_before_805", bguq.a(this, "8.0.5"));
          ((Intent)localObject5).putExtra("key_support_troop_honor", ((bggj)this.app.getManager(346)).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin));
          bool = false;
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
            bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop();
          }
          ((Intent)localObject5).putExtra("key_customed_troop", bool);
          if (bool) {
            acik.a(null, "846", "205605", "", "84601", "1", "145");
          }
          localObject4 = this.jdField_a_of_type_Arju;
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            localObject1 = arjv.a();
            this.jdField_a_of_type_Arju = ((arju)localObject1);
          }
          ((Intent)localObject5).putExtra("autoApprovalUrl", ((arju)localObject1).jdField_b_of_type_JavaLangString);
          ((Intent)localObject5).putExtra("frequencyLimitVisible", ((arju)localObject1).jdField_a_of_type_Boolean);
          ((Intent)localObject5).putExtra("key_is_need_update_Group_info", true);
          if ((QLog.isDevelopLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
            QLog.i("TroopMngTest", 4, String.format("start troop mng [flag: %s, msgLimitFreq: %s]", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt3 & 0x100000), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.nMsgLimitFreq) }));
          }
          ((Intent)localObject5).putExtra("troop_manager_edit_red_show", c());
          ((Intent)localObject5).putExtra("troop_manager_edit_current_uin", this.app.c());
          localObject1 = TroopBaseProxyActivity.a(this);
          localObject4 = new bnse(this.app);
          localObject6 = PluginCommunicationHandler.getInstance();
          if (localObject6 != null) {
            ((PluginCommunicationHandler)localObject6).register((RemoteCommand)localObject4);
          }
          TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, this, (Intent)localObject5, (Dialog)localObject1, "com.tencent.mobileqq.activity.TroopManageActivity", this.app.getCurrentAccountUin(), 8);
          localObject4 = this.app;
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {}
          for (localObject1 = "0";; localObject1 = "1")
          {
            bdll.b((QQAppInterface)localObject4, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, (String)localObject5, (String)localObject1, "", "");
            bhju.a("Grp_set_new", "grpData_admin", "clk_manageGrp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            break;
          }
          bdll.b(this.app, "P_CliOper", "Grp_payjoin", "", "join_grp", "Clk_data", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
          ajpz.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "");
          bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
          continue;
          bguq.a(this.app, this, getIntent(), this);
          bdll.b(this.app, "CliOper", "", "", "0x80084B4", "0x80084B4", 0, 0, "", "", "", "");
          bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
          continue;
          localObject1 = this.app;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
          for (i1 = 1;; i1 = 2)
          {
            bdll.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800A527", "0X800A527", i1, 0, bguq.a() + "", "", "", "");
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 34) {
              break label2659;
            }
            if (!asvi.a(this.app.getCurrentAccountUin())) {
              break label2623;
            }
            localObject1 = atcx.a(this);
            if (!isFinishing())
            {
              ((Dialog)localObject1).show();
              bdll.b(this.app, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
            }
            break;
          }
          bdll.b(this.app, "dc00898", "", "", "0X80092D7", "0X80092D7", 0, 0, "", "", "", "");
          label2659:
          bguq.a(false, null);
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) {
              d(1);
            }
            for (;;)
            {
              break;
              M();
            }
          }
          bguq.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, bguq.jdField_a_of_type_Int, this.jdField_l_of_type_Int, 2);
          label4432:
          label4828:
          label4958:
          label4963:
          if (!bhnv.d(this))
          {
            a(2131693963, 1);
          }
          else
          {
            localObject1 = (aoip)this.app.a(20);
            if (localObject1 != null) {}
            long l1;
            try
            {
              l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              o();
              ((aoip)localObject1).a(l1, 8390784);
              if (super.getIntent().getBooleanExtra("from_babyq", false)) {
                bdll.b(this.app, "dc00898", "", "", "0X8007246", "0X8007246", 0, 0, "", "", "", "");
              }
              bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
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
            j();
            continue;
            bguq.a(this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 6);
            bdll.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
            bdll.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Set_chatBG", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            bhju.a("Grp_set_new", "grpData_admin", "set_chatBG", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            continue;
            localObject4 = (bidm)((FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[40]).getTag(2131375040);
            Object localObject2;
            label4200:
            label4974:
            if (localObject4 != null)
            {
              l1 = ((bidm)localObject4).jdField_a_of_type_Long;
              ((bidm)localObject4).jdField_a_of_type_Long = SystemClock.uptimeMillis();
              if (((bidm)localObject4).jdField_a_of_type_Long >= l1 + 1000L)
              {
                biik.a(this.app, "troop_keyword_expire_list_" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, ((bidm)localObject4).jdField_b_of_type_JavaLangString);
                biik.b(this.app, "troop_keyword_guide_clicked", true);
                localObject2 = bhyk.a("groupkeywords").replace("[groupid]", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.chatopttroop.troop.special_msg.keyword", 2, "onClick: " + (String)localObject2);
                }
                bdll.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F8", ((bidm)localObject4).jdField_c_of_type_Int, 1, 0, "", "", "", "");
                localObject4 = new Intent(this, QQBrowserActivity.class);
                ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
                ((Intent)localObject4).putExtra("url", (String)localObject2);
                ((Intent)localObject4).putExtra("isShowAd", false);
                startActivity((Intent)localObject4);
              }
            }
            else
            {
              QLog.e("Q.chatopttroop.troop.special_msg.keyword", 1, "onClick status is null");
              continue;
              localObject2 = new Intent(this, QQBrowserActivity.class);
              localObject4 = bhyk.a("troopEnterEffect");
              ((Intent)localObject2).putExtra("url", (String)localObject4 + "&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              startActivityForResult((Intent)localObject2, 15);
              bfui.a("grp_data", "entry_clk", new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
              i1 = ((bfui)this.app.getManager(231)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              VasWebviewUtil.reportCommercialDrainage(this.app.c(), "style", "0X8008E62", "", 1, 0, 0, "", Integer.toString(i1), "");
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin != null)) {
                this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
              }
              localObject2 = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
              ((Bundle)localObject2).putBoolean("troop_info_from_troopsetting", true);
              ((Bundle)localObject2).putInt("exposureSource", 1);
              bguq.a(this, (Bundle)localObject2, 2);
              localObject2 = this.app;
              if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
              for (i1 = 1;; i1 = 2)
              {
                bdll.b((QQAppInterface)localObject2, "dc00898", "", "", "0X800A524", "0X800A524", i1, 0, "", "", "", "");
                break;
              }
              localObject2 = new biwz(this, this.app, false);
              ((biwz)localObject2).a(new aegc(this));
              ((biwz)localObject2).a(2);
              bhju.a("Grp_set_new", "grpData_admin", "clk_delRecord", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
              continue;
              localObject4 = paramView.getTag(2131378440);
              if (QLog.isColorLevel()) {
                QLog.d("Q.chatopttroop", 2, "troop app item click type=" + paramView.getId() + ", url=" + localObject4);
              }
              localObject5 = (oidb_0xe83.TabInfo)paramView.getTag(2131378409);
              if (bguq.a(paramView, (oidb_0xe83.TabInfo)localObject5))
              {
                localObject2 = null;
                if (((oidb_0xe83.TabInfo)localObject5).red_point.get() != 0)
                {
                  localObject2 = (String)paramView.getTag(2131378433);
                  oix.a(this, (String)localObject2, 2);
                  if ((localObject5 != null) && (((oidb_0xe83.TabInfo)localObject5).red_point.get() != 0)) {
                    if ((paramView instanceof TroopAppFormItem))
                    {
                      localObject2 = (TroopAppFormItem)paramView;
                      if (((oidb_0xe83.TabInfo)localObject5).appid.get() != 1106837471L) {
                        break label4200;
                      }
                      ((TroopAppFormItem)localObject2).d();
                    }
                  }
                }
              }
              for (;;)
              {
                ((aoip)this.app.a(20)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, ((oidb_0xe83.TabInfo)localObject5).appid.get());
                ((oidb_0xe83.TabInfo)localObject5).red_point.set(0);
                bguq.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, ((oidb_0xe83.TabInfo)localObject5).appid.get());
                if (i1 != 30) {
                  break label4208;
                }
                bgts.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1106611799);
                this.jdField_j_of_type_Int = ((int)NetConnInfoCenter.getServerTime());
                ThreadManager.post(new ChatSettingForTroop.27(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 5, null, false);
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(19);
                bhju.a("Grp_game", "Grp_data", "feeds_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
                break;
                if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
                  break label3767;
                }
                localObject2 = "{\"tags\":" + this.jdField_a_of_type_JavaLangString + "}";
                break label3767;
                localObject2 = localObject4;
                if (localObject5 != null)
                {
                  localObject2 = localObject4;
                  if (((oidb_0xe83.TabInfo)localObject5).appid.get() == 1106837471L) {
                    localObject2 = (String)paramView.getTag(2131378433);
                  }
                }
                if ((!(localObject2 instanceof String)) || (TextUtils.isEmpty((String)localObject2))) {
                  break label3774;
                }
                localObject4 = new Bundle();
                ((Bundle)localObject4).putString("uin", this.app.getCurrentAccountUin());
                ((Bundle)localObject4).putString("gc", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                ((Bundle)localObject4).putBoolean("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
                if (axev.a(this, (String)localObject2, (Bundle)localObject4))
                {
                  if (!QLog.isColorLevel()) {
                    break label3774;
                  }
                  QLog.d("Q.chatopttroop", 2, "mini app jump handled");
                  break label3774;
                }
                localObject4 = new Intent(this, QQBrowserActivity.class);
                ((Intent)localObject4).putExtra("url", (String)localObject2);
                startActivity((Intent)localObject4);
                break label3774;
                ((TroopAppFormItem)localObject2).c();
              }
              label4208:
              if (i1 == 29)
              {
                bhju.a("Grp_game", "Grp_data", "rank_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
              }
              else if ((i1 == 1007) && (localObject5 != null) && (((oidb_0xe83.TabInfo)localObject5).appid.get() == 1106837471L))
              {
                bhju.a("Grp_set", "Grp_aio_subscription", "subscription_clk", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) });
                continue;
                if (this.n)
                {
                  bgpy.a(this.app, false);
                  this.jdField_a_of_type_Bgwe.a(false);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.chatopttroop", 2, "setRobotItemRedDotShowed");
                  }
                }
                bdll.b(this.app, "dc00898", "", "", "", "0X8009F9C", 0, 0, "", "", "", "");
                bguq.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
                continue;
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1))
                  {
                    i1 = 1;
                    if ((i1 == 0) || (!armu.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
                      break label4634;
                    }
                    bool = aojn.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
                    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                      break label4625;
                    }
                    localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                    if (!bool) {
                      break label4608;
                    }
                    i1 = 15;
                    localObject5 = VipUtils.a(0, i1).toString();
                    localObject6 = anzj.a(2131700632);
                    localObject7 = new aegd(this, bool);
                    if (!bool) {
                      break label4614;
                    }
                    localObject2 = "0X800A57F";
                    if (!bool) {
                      break label4622;
                    }
                    VipUtils.a(this, (String)localObject4, (String)localObject5, (String)localObject6, (DialogInterface.OnClickListener)localObject7, (String)localObject2, 1, bool);
                  }
                  for (;;)
                  {
                    bdll.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 1, 0, "", "", "", "");
                    break;
                    i1 = 0;
                    break label4432;
                    i1 = 8;
                    break label4505;
                    localObject2 = "0X8009E38";
                    break label4545;
                    break label4550;
                    VipUtils.a(this, bool);
                  }
                  int i2;
                  if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName)
                  {
                    localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
                    localObject4 = localObject2;
                    if (localObject2 == null) {
                      localObject4 = "";
                    }
                    if ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
                      break label4958;
                    }
                    i2 = 1;
                    localObject5 = new Intent(this, EditInfoActivity.class);
                    ((Intent)localObject5).putExtra("edit_type", 2);
                    if (i1 == 0) {
                      break label4963;
                    }
                    localObject2 = anzj.a(2131700651);
                    label4721:
                    ((Intent)localObject5).putExtra("title", (String)localObject2);
                    ((Intent)localObject5).putExtra("default_text", (String)localObject4);
                    ((Intent)localObject5).putExtra("max_num", 96);
                    ((Intent)localObject5).putExtra("canPostNull", false);
                    if (i1 == 0) {
                      break label4974;
                    }
                    localObject2 = anzj.a(2131700636);
                    ((Intent)localObject5).putExtra("right_btn", (String)localObject2);
                    ((Intent)localObject5).putExtra("isTroopName", true);
                    if (i1 == 0) {
                      break label4982;
                    }
                    bool = true;
                    ((Intent)localObject5).putExtra("edit_mode", bool);
                    if (i2 == 0) {
                      break label4988;
                    }
                    localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                    ((Intent)localObject5).putExtra("troopUin", (String)localObject2);
                    startActivityForResult((Intent)localObject5, 16);
                    bhju.a("Grp_set_new", "grpData_admin", "clk_editInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
                    localObject4 = this.app;
                    localObject5 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                      break label4996;
                    }
                    localObject2 = "0";
                  }
                  for (;;)
                  {
                    bdll.b((QQAppInterface)localObject4, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_name", 0, 0, (String)localObject5, "0", (String)localObject2, "");
                    break;
                    localObject2 = "";
                    break label4653;
                    i2 = 0;
                    break label4686;
                    localObject2 = anzj.a(2131700650);
                    break label4721;
                    localObject2 = "";
                    break label4776;
                    label4982:
                    bool = false;
                    break label4804;
                    label4988:
                    localObject2 = "";
                    break label4828;
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
                      localObject2 = "1";
                    } else {
                      localObject2 = "2";
                    }
                  }
                  try
                  {
                    if (this.jdField_a_of_type_Bhbx != null) {
                      this.jdField_a_of_type_Bhbx.e();
                    }
                    this.jdField_a_of_type_Bhbx = new bhbx(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
                    this.jdField_a_of_type_Bhbx.f();
                  }
                  catch (NullPointerException localNullPointerException)
                  {
                    for (;;)
                    {
                      localNullPointerException.printStackTrace();
                      continue;
                      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
                        localObject3 = "1";
                      } else {
                        localObject3 = "2";
                      }
                    }
                  }
                  localObject4 = this.app;
                  localObject5 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                  if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
                  {
                    localObject2 = "0";
                    bdll.b((QQAppInterface)localObject4, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_num", 0, 0, (String)localObject5, "0", (String)localObject2, "");
                  }
                  else
                  {
                    Object localObject3 = bgtj.a().a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1);
                    localObject4 = new Intent(this, QQBrowserActivity.class);
                    ((Intent)localObject4).putExtra("url", (String)localObject3);
                    startActivity((Intent)localObject4);
                    bdll.b(null, "dc00898", "", "", "0X800A6EF", "0X800A6EF", 0, 0, "", "", "", "");
                    continue;
                    localObject3 = (bejx)this.app.getManager(339);
                    bool = ((bejx)localObject3).a(4, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                    localObject4 = bekk.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
                    if (bool) {
                      ((bejx)localObject3).b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 4, 2, (Bundle)localObject4);
                    }
                    for (;;)
                    {
                      bekk.a(this.app, "SP_KEY_SING_TOGETHER_TROOP_RED_DOT_SHOW", false, false);
                      ((bejx)localObject3).a("sing_tab", "clk_setsing", 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                      v();
                      break;
                      ((bejx)localObject3).a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 4, 2, (Bundle)localObject4);
                    }
                    localObject3 = (arjl)aran.a().a(535);
                    if ((localObject3 == null) || (((arjl)localObject3).jdField_a_of_type_Arkh == null))
                    {
                      QQToast.a(this, 0, 2131692838, 0).a();
                    }
                    else
                    {
                      localObject4 = (bejx)this.app.getManager(339);
                      bool = ((bejx)localObject4).a(2, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                      localObject5 = bekk.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
                      switch (((arjl)localObject3).jdField_a_of_type_Arkh.a())
                      {
                      default: 
                        if (((bejx)localObject4).a(this, 2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2)) {
                          if (QLog.isColorLevel()) {
                            QLog.d("Q.chatopttroop", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(2) });
                          }
                        }
                        break;
                      }
                      for (;;)
                      {
                        bekk.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_RED_DOT_SHOW", false, false);
                        u();
                        break;
                        QQToast.a(this, 0, 2131692838, 0).a();
                        continue;
                        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
                        {
                          if (bool) {
                            ((bejx)localObject4).b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject5);
                          } else {
                            ((bejx)localObject4).a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject5);
                          }
                        }
                        else if (bool)
                        {
                          ((bejx)localObject4).b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject5);
                        }
                        else
                        {
                          ((bejx)localObject4).a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject5);
                          continue;
                          ((bejx)localObject4).a("video_tab", "clk_setvideo", 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                          bekk.a(this.app, ((arjl)localObject3).jdField_a_of_type_Arkh.b(), ((arjl)localObject3).jdField_a_of_type_Arkh.a(), ((arjl)localObject3).jdField_a_of_type_Arkh.b(), (Bundle)localObject5, 1);
                        }
                      }
                      if (this.jdField_a_of_type_Bhbx != null) {
                        this.jdField_a_of_type_Bhbx.e();
                      }
                      this.jdField_a_of_type_Bhbx = bguq.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app);
                      localObject3 = this.app;
                      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
                      for (i1 = 1;; i1 = 2)
                      {
                        bdll.b((QQAppInterface)localObject3, "dc00898", "", "", "0X800A525", "0X800A525", i1, 0, bguq.a() + "", "", "", "");
                        break;
                      }
                      if (bhlk.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false))
                      {
                        bgts.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 101890494);
                        bhlk.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false, "");
                        localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[42];
                        if (localObject3 != null)
                        {
                          localObject3 = (TextView)((View)localObject3).findViewById(2131376648);
                          if (localObject3 != null)
                          {
                            ((TextView)localObject3).setText("");
                            bguq.a(false, (TextView)localObject3);
                          }
                        }
                      }
                      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
                      {
                        localObject3 = new Intent(this, QQBrowserActivity.class);
                        ((Intent)localObject3).putExtra("url", "https://qun.qq.com/active/rank/index?gc={groupcode}&_wwv=128".replace("{groupcode}", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
                        startActivity((Intent)localObject3);
                      }
                      bdll.b(this.app, "dc00898", "", "", "0X800B2F1", "0X800B2F1", 0, 0, "", "", "", "");
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
      y();
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
      if ((localObject != null) && ((localObject instanceof aelh)))
      {
        localObject = (aelh)localObject;
        if (paramString != null) {
          break label129;
        }
        a((aelh)localObject, null, false);
      }
    }
    label129:
    while (!paramString.equals(((aelh)localObject).jdField_a_of_type_JavaLangString))
    {
      paramInt1 += 1;
      break label72;
      break;
    }
    ((aelh)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void p()
  {
    try
    {
      if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
        this.jdField_a_of_type_Bjbs.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.chatopttroop", 2, localException.toString());
    }
  }
  
  protected void q()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[19];
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mCanSearchByKeywords) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.mCanSearchByTroopUin)) {
        localView.setVisibility(0);
      }
    }
    else {
      return;
    }
    localView.setVisibility(8);
  }
  
  public void r()
  {
    Context localContext = getApplicationContext();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      String str = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
      bhaq.a(localContext).a(str, null);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_Bhpc != null)
    {
      if (!this.jdField_a_of_type_Bhpc.isShowing()) {
        this.jdField_a_of_type_Bhpc.show();
      }
      return;
    }
    this.jdField_a_of_type_Bhpc = bhlq.a(this, 230);
    this.jdField_a_of_type_Bhpc.setMessage(2131694652);
    this.jdField_a_of_type_Bhpc.setTitle(2131691920);
    aegu localaegu = new aegu(this);
    this.jdField_a_of_type_Bhpc.setNegativeButton(2131690580, localaegu);
    this.jdField_a_of_type_Bhpc.setPositiveButton(2131694626, localaegu);
    this.jdField_a_of_type_Bhpc.show();
  }
  
  public void t()
  {
    if ((this.app == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
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
    ThreadManager.post(new ChatSettingForTroop.50(this, localTroopManager), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop
 * JD-Core Version:    0.7.0.1
 */
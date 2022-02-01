package com.tencent.mobileqq.activity;

import Override;
import abet;
import adaq;
import adar;
import adas;
import adau;
import adav;
import adaw;
import adax;
import aday;
import adaz;
import adba;
import adbb;
import adbc;
import adbd;
import adbe;
import adbf;
import adbg;
import adbh;
import adbi;
import adbj;
import adbk;
import adbm;
import adbn;
import adbo;
import adbp;
import adbq;
import adbs;
import adbu;
import adbv;
import adbw;
import adbx;
import adca;
import adcb;
import adcc;
import adcd;
import adce;
import adcf;
import adef;
import aiku;
import amoo;
import amop;
import amsu;
import amtj;
import anca;
import ancy;
import andd;
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
import anjl;
import apub;
import aqcu;
import aqcv;
import aqde;
import aqdn;
import aqdo;
import aqea;
import aqgr;
import arhi;
import arpf;
import auzn;
import avsc;
import avtd;
import aynd;
import bbyp;
import bcef;
import bczs;
import bdct;
import bddg;
import bdnn;
import bdvh;
import bdvm;
import bede;
import bedf;
import bedt;
import bepr;
import beyy;
import bezd;
import bezm;
import bfaa;
import bfaf;
import bfcx;
import bfdg;
import bfdm;
import bffq;
import bfkb;
import bfkc;
import bflj;
import bftc;
import bfun;
import bfur;
import bfvf;
import bfvo;
import bfyq;
import bgdk;
import bgev;
import bggc;
import bgjx;
import bgjy;
import bgov;
import bhdb;
import bhht;
import bhhw;
import bhig;
import bjnv;
import bjnw;
import bjon;
import bjvp;
import bkjs;
import bkxl;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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
import mun;
import mxn;
import njk;
import nor;
import npj;
import nqt;
import nqw;
import okj;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.ExtraInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.TabInfo;
import xwa;

public class ChatSettingForTroop
  extends BaseActivity
  implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener, bezd, FaceDecoder.DecodeTaskCompletionListener
{
  public static final ArrayList<Integer> a;
  public static String l;
  protected final int a;
  long jdField_a_of_type_Long = 0L;
  protected adcf a;
  amop jdField_a_of_type_Amop = new adbq(this);
  amsu jdField_a_of_type_Amsu = new adbk(this);
  andd jdField_a_of_type_Andd = new adbh(this);
  protected BroadcastReceiver a;
  public Intent a;
  public Drawable a;
  public Handler a;
  protected DisplayMetrics a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new adas(this);
  public View.OnTouchListener a;
  protected View a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  public TextView a;
  public aqdn a;
  private bffq jdField_a_of_type_Bffq;
  public bfkb a;
  public bflj a;
  public bfyq a;
  bggc jdField_a_of_type_Bggc = new adca(this);
  protected bhht a;
  public bhhw a;
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
  protected npj a;
  protected nqt a;
  protected nqw a;
  protected boolean a;
  public View[] a;
  public int b;
  andd jdField_b_of_type_Andd = new adbi(this);
  public Handler b;
  protected View.OnClickListener b;
  protected View b;
  protected Button b;
  public ImageView b;
  protected TextView b;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  protected Runnable b;
  public String b;
  protected ArrayList<TroopAppInfo> b;
  List<ImageView> jdField_b_of_type_JavaUtilList;
  public volatile boolean b;
  protected int c;
  andd jdField_c_of_type_Andd = new adbj(this);
  protected View c;
  public TextView c;
  protected String c;
  private ArrayList<Long> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  protected List<oidb_0x899.memberlist> c;
  public boolean c;
  protected int d;
  private andd d;
  protected View d;
  public TextView d;
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
  private boolean s;
  private boolean t;
  private boolean u = true;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379306));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379307));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379308));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379309));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379310));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379311));
    jdField_l_of_type_JavaLangString = "https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi";
  }
  
  public ChatSettingForTroop()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_Int = 5;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Andd = new adaq(this);
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new adbo(this);
    this.jdField_a_of_type_JavaLangRunnable = new ChatSettingForTroop.12(this);
    this.jdField_a_of_type_Nqw = new adba(this);
    this.jdField_b_of_type_JavaLangRunnable = new ChatSettingForTroop.23(this);
    this.jdField_l_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new adbg(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new adbs(this);
    this.jdField_a_of_type_Npj = new adbw(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new mun();
  }
  
  private void A()
  {
    bjnw localbjnw = (bjnw)bjon.a(this, null);
    localbjnw.a(new bjnv(getString(2131695680), 34, 0), 5);
    localbjnw.a(new bjnv(bjon.a(this, 2131717685), 21, 0), 5);
    localbjnw.c(2131690620);
    localbjnw.a(new adav(this, localbjnw));
    if (!localbjnw.isShowing()) {
      localbjnw.show();
    }
  }
  
  private void B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop quitTroop mTroopInfoData.bOwner = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner);
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)
    {
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject == null)
      {
        localObject = null;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
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
        break label237;
      }
      localObject = "0";
    }
    for (;;)
    {
      bcef.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Clk_quitgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject, "", "");
      return;
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label179:
      D();
      break label107;
      label186:
      localObject = bjnw.a(this);
      ((bjnw)localObject).a(2131690964);
      ((bjnw)localObject).a(2131691941, 3);
      ((bjnw)localObject).a(new adaw(this, (bjnw)localObject));
      ((bjnw)localObject).d(getString(2131690620));
      ((bjnw)localObject).show();
      break label107;
      label237:
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
    ReportDialog localReportDialog = new ReportDialog(this, 2131755826);
    localReportDialog.setContentView(2131561021);
    ((TextView)localReportDialog.findViewById(2131365589)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365577);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365575);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365581);
    String str = amtj.a(2131700879);
    localTextView1.setText(getString(2131690959, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694201);
    localTextView3.setText(2131690620);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new adax(this, localReportDialog));
    localTextView3.setOnClickListener(new aday(this, localReportDialog));
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
    getString(2131691632);
    String str = getString(2131690958);
    bjnw localbjnw = bjnw.a(this);
    localbjnw.a(str);
    localbjnw.a(getString(2131690957), 3);
    localbjnw.d(getString(2131690620));
    localbjnw.a(new adaz(this, localbjnw));
    localbjnw.show();
  }
  
  private void E()
  {
    anca localanca = (anca)this.app.getBusinessHandler(20);
    if (localanca != null) {
      localanca.a(amoo.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), true, 1);
    }
    this.jdField_a_of_type_Nqt.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_Nqw);
  }
  
  private void F()
  {
    anca localanca = (anca)this.app.getBusinessHandler(20);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum <= 100) {
      localanca.a(amoo.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 0L, 5, 100, 0);
    }
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {}
    do
    {
      return;
      localObject = (Boolean)this.jdField_a_of_type_Bfyq.c.get(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
    } while ((localObject != null) && (((Boolean)localObject).booleanValue()));
    bcef.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "0", "");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
    }
    for (;;)
    {
      bjnw localbjnw = (bjnw)bjon.a(this, null);
      localbjnw.a(getString(2131718813, new Object[] { localObject }));
      localbjnw.a(getString(2131697120), false);
      localbjnw.a(getString(2131697116), false);
      localbjnw.a(getString(2131697112), false);
      int i1 = this.app.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
      switch (i1)
      {
      }
      for (;;)
      {
        localbjnw.c(2131690620);
        localbjnw.a(new adbb(this, i1, localbjnw));
        localbjnw.show();
        return;
        localbjnw.d(0);
        continue;
        localbjnw.d(1);
        continue;
        localbjnw.d(2);
      }
    }
  }
  
  private void H()
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
  
  private void I()
  {
    H();
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this, 230).setTitle(getString(2131697101));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(getString(2131697100), new adbf(this));
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
  
  private void J()
  {
    bftc.a("Grp_set_new", "grpData_admin", "clk_notice", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), "8.4.8" });
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)))
    {
      I();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Aqdn;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = aqdo.a();
      this.jdField_a_of_type_Aqdn = ((aqdn)localObject1);
    }
    localObject1 = ((aqdn)localObject1).jdField_a_of_type_JavaLangString;
    localObject2 = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", TroopUtils.replaceSpecialTag((String)localObject1, 0L, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app, true));
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
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;; localObject1 = getString(2131695629))
    {
      ((TextView)localObject2).setText(new QQText((CharSequence)localObject1, 11, 16));
      return;
    }
  }
  
  private void M()
  {
    o();
    ((anca)this.app.getBusinessHandler(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, null);
  }
  
  private void N()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.u) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.app);
    if (!this.u) {
      this.u = true;
    }
    if ((this.u) || (bool)) {}
    for (int i1 = 2131167009;; i1 = 2131166709)
    {
      int i3 = getResources().getColor(i1);
      int i2 = 2130843732;
      i1 = i2;
      if (this.u)
      {
        i1 = i2;
        if (!bool) {
          i1 = 2130840329;
        }
      }
      Drawable localDrawable = getResources().getDrawable(2130850593);
      localDrawable.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i3);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i3);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i1);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(i3);
      e(this.u);
      return;
    }
  }
  
  private void O()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[12].findViewById(2131373641);
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
            boolean bool = bfun.a(this.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
            if ((i2 != -1) && (!bool)) {
              break;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            localObject1 = (TextView)((View)localObject1).findViewById(2131362850);
            if (i1 == 0) {
              break label375;
            }
            ((TextView)localObject1).setVisibility(0);
            ((TextView)localObject1).setText("");
            ((TextView)localObject1).setBackgroundResource(0);
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130850321, 0, 0, 0);
            return;
            localObject1 = localView.findViewById(2131379104);
            break;
            localObject1 = localView.findViewById(2131379105);
            break;
            localObject1 = localView.findViewById(2131379106);
            break;
            localObject1 = localView.findViewById(2131379107);
            break;
            localObject1 = localView.findViewById(2131379108);
            break;
            localObject1 = localView.findViewById(2131379109);
            break;
            localObject1 = localView.findViewById(2131379110);
            break;
            localObject1 = localView.findViewById(2131379111);
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
    if (this.t)
    {
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      this.t = false;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop()))
    {
      FormSwitchItem localFormSwitchItem = new FormSwitchItem(this, null);
      localFormSwitchItem.setText(getString(2131692857));
      localFormSwitchItem.a().setTextColor(getResources().getColor(2131167012));
      localFormSwitchItem.setFocusable(true);
      localFormSwitchItem.getBackground().setAlpha(255);
      localFormSwitchItem.setContentDescription(getString(2131692857));
      this.jdField_a_of_type_ArrayOfAndroidViewView[31] = localFormSwitchItem;
      localFormSwitchItem.a().setTag(Integer.valueOf(31));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localFormSwitchItem);
      T();
    }
  }
  
  private void T()
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
  
  private void U()
  {
    Object localObject = (TroopManager)this.app.getManager(52);
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
          break label172;
        }
      }
    }
    label172:
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
        V();
        ((Switch)localObject).setOnCheckedChangeListener(this);
      }
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
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
      localFormSwitchItem.setContentDescription(getString(2131695694));
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
      localObject2 = bfvo.a();
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
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131719187);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131719192);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131719194);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 4;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131719189);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 5;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131719188);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop()))
    {
      localObject = (anca)this.app.getBusinessHandler(20);
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
      if (!paramBoolean) {
        break label82;
      }
    }
    label82:
    for (int i1 = 1;; i1 = 0)
    {
      ((anca)localObject).b(str, paramInt, i1);
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
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131692310));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramActivity.getString(2131695546));
    localIntent.putExtra("param_max", 100);
    if (!paramBoolean) {
      localIntent.putExtra("filer_robot", true);
    }
    localIntent.putExtra("param_entrance", 38);
    paramActivity.startActivityForResult(localIntent, 1);
  }
  
  private static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363616);
    paramView = (TextView)paramView.findViewById(2131376413);
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
    TextView localTextView = (TextView)paramView.findViewById(2131363616);
    paramView = (TextView)paramView.findViewById(2131376413);
    if (TextUtils.isEmpty(paramString))
    {
      localTextView.setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(getString(2131697102));
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
      auzn.b(this.app, getApplicationContext(), 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
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
      if (njk.a((BaseActivity)getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
        return true;
      }
      localObject = (mxn)this.app.getManager(373);
      if (localObject != null) {
        ((mxn)localObject).a(getActivity(), 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
      }
      if ((localObject != null) && (((mxn)localObject).a())) {}
      for (int i1 = 1;; i1 = 2)
      {
        bcef.b(null, "dc00898", "", "", "0X800B4E3", "0X800B4E3", i1, 0, "", "", paramTroopInfo.troopuin, "");
        return true;
      }
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_Bhhw == null) {
        this.jdField_a_of_type_Bhhw = new bhhw(this);
      }
      this.jdField_a_of_type_Bhhw.b(2, 2131694064, 1500);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
      return;
    }
    this.jdField_a_of_type_Bfyq.b.clear();
    this.app.setTroopMsgFilterToServer(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Bfyq.c.put(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, Boolean.valueOf(true));
    if (!this.q)
    {
      SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      if (!localSharedPreferences.getBoolean("Change_Msg_Notify_Tips_Value", false))
      {
        this.q = true;
        localSharedPreferences.edit().putBoolean("Change_Msg_Notify_Tips_Value", true).commit();
        bfur.a(this, getString(2131697111), 2131718436, 2131718436, new bfvf(), null).show();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
    bcef.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
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
    byte[] arrayOfByte = ((avtd)this.app.getManager(37)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject != null) {
        break label56;
      }
    }
    label56:
    for (Object localObject = null;; localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && ((paramInt & 0x1) > 0)) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cGroupOption);
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
    a(2131719201, 0);
  }
  
  private void c(List<oidb_0x899.memberlist> paramList)
  {
    anca localanca = (anca)this.app.getBusinessHandler(20);
    ArrayList localArrayList1 = new ArrayList();
    bfdm localbfdm = (bfdm)this.app.getManager(203);
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
      } else if (localbfdm.b(str)) {
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
        break label388;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.memberListToShow = ((String)localObject);
      localanca.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramList, true, null);
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
          i1 = 2131698701;
        }
        for (;;)
        {
          a(25, 2, localView, getString(i1), "", true);
          localObject2 = new SpannableString((String)localObject1 + "PT[QR]");
          Object localObject3 = getResources().getDrawable(2130843877);
          ((Drawable)localObject3).setBounds(0, 0, ScreenUtil.dip2px(18.0F), ScreenUtil.dip2px(18.0F));
          if (ThemeUtil.isInNightMode(this.app)) {
            ((Drawable)localObject3).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
          }
          localObject3 = new adbm(this, (Drawable)localObject3, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
          {
            QLog.e("vip_pretty.Q.chatopttroop", 1, "show the pretty troop icon :" + this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.groupFlagExt4);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.checkFlagExt4(1)) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.checkFreezeReason(2)))
            {
              i1 = 1;
              if (i1 == 0) {
                break label453;
              }
              Drawable localDrawable = getResources().getDrawable(2130846848);
              localDrawable.setBounds(0, 0, ScreenUtil.dip2px(40.0F), ScreenUtil.dip2px(15.0F));
              ((SpannableString)localObject2).setSpan(new adbn(this, localDrawable, 0), ((String)localObject1).length(), ((String)localObject1).length() + 2, 17);
              ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length() + 2, ((String)localObject1).length() + 6, 17);
            }
          }
          for (;;)
          {
            paramBoolean = bool;
            if (!" ".equals(localObject1)) {
              paramBoolean = true;
            }
            TroopUtils.updateEntryItem(localView, (CharSequence)localObject2, null, null, paramBoolean, (String)localObject1, amtj.a(2131691182), new adbp(this));
            localView.setOnClickListener(this);
            return;
            if (paramBoolean) {
              break label475;
            }
            i1 = 2131698702;
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.checkFlagExt4(2))
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
    beyy.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
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
      localIntent = AIOUtils.setOpenAIOIntent(localIntent, new int[] { 2 });
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
        bcef.b(this.app, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800B4AD", "0X800B4AD", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt), "", "", "");
      }
      String str = getResources().getString(2131698695) + String.valueOf(paramInt) + getResources().getString(2131698696);
      a(43, 2, localView, getResources().getString(2131698697), " ", true);
      TextView localTextView1 = (TextView)localView.findViewById(2131363616);
      TextView localTextView2 = (TextView)localView.findViewById(2131376413);
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
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    ImmersiveUtils.a(false, getWindow());
    bbyp.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
  }
  
  private void f(boolean paramBoolean)
  {
    amoo localamoo = (amoo)this.app.getBusinessHandler(22);
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
      if (!paramBoolean) {
        break label149;
      }
      i1 = 0;
      label45:
      if (!localamoo.a(str, i1)) {
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
      bcef.b(this.app, "dc00899", "Grp_set", "", "Grp_data", str, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      bftc.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
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
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131692035, 1);
      U();
      return;
    }
    if (paramBoolean) {
      anjl.a(this.app).a(this);
    }
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      i1 = 1;
      int i3 = (int)NetConnInfoCenter.getServerTime();
      ((anca)this.app.getBusinessHandler(20)).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, this.app.getCurrentUin(), i1, 512, i3);
      V();
      localQQAppInterface = this.app;
      if (!paramBoolean) {
        break label142;
      }
    }
    label142:
    for (int i1 = i2;; i1 = 2)
    {
      bcef.b(localQQAppInterface, "dc00898", "", "", "0X800A348", "0X800A348", 2, i1, "0", "0", "", "");
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
    if (NetworkUtil.getSystemNetwork(this) == 0)
    {
      QQToast.a(this, 2131695676, 0).b(getTitleBarHeight());
      W();
      return;
    }
    ((anca)this.app.getBusinessHandler(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramBoolean, false);
    if (paramBoolean)
    {
      bcef.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      if (!paramBoolean) {
        break label207;
      }
    }
    label207:
    for (String str = "showGrp_open";; str = "showGrp_close")
    {
      bftc.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      bcef.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      break;
    }
  }
  
  private void i(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (bdvh)apub.a().a(686);
      } while ((localObject == null) || (!((bdvh)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData)));
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasTroopAssociation()) && (!paramBoolean)) {
        break;
      }
      localObject = (anca)this.app.getBusinessHandler(20);
    } while (localObject == null);
    ((anca)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 3, "");
    return;
    e(0);
  }
  
  private void u()
  {
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[16];
    if ((localFormSimpleItem == null) || (localFormSimpleItem.getVisibility() != 0)) {}
    do
    {
      return;
      aqde localaqde = (aqde)apub.a().a(535);
      if ((localaqde == null) || (!localaqde.jdField_a_of_type_Boolean)) {
        break;
      }
      localFormSimpleItem.setVisibility(0);
    } while (localFormSimpleItem.getVisibility() != 0);
    if (bddg.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_RED_DOT_SHOW", true, false))
    {
      localFormSimpleItem.setRightIcon(getResources().getDrawable(2130841413));
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
    Object localObject = ((aqcu)apub.a().a(551)).a(4);
    if ((localObject != null) && (((aqcv)localObject).jdField_b_of_type_Boolean))
    {
      localFormSimpleItem.setVisibility(0);
      if (!((bdct)this.app.getManager(339)).a(4, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
        break label130;
      }
    }
    label130:
    for (localObject = "已开启";; localObject = "未开启")
    {
      localFormSimpleItem.setRightText((CharSequence)localObject);
      if (!bddg.a(this.app, "SP_KEY_SING_TOGETHER_TROOP_RED_DOT_SHOW", true, false)) {
        break;
      }
      localFormSimpleItem.setRightIcon(getResources().getDrawable(2130841413));
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    localFormSimpleItem.setRightIcon(null);
  }
  
  private void w()
  {
    new QueryTask(new adce(this), new adar(this)).a(null);
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
      a(localView, null, null, amtj.a(2131700904));
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
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      try
      {
        View localView = View.inflate(this, 2131562911, null);
        this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131364934));
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView.findViewById(2131378806));
        this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
        this.jdField_a_of_type_ArrayOfAndroidViewView = new View[45];
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
        Object localObject1 = new AbsListView.LayoutParams(-1, -2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        localObject1 = new bjvp(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
        this.jdField_d_of_type_Boolean = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "mIsQidianPrivateTroop : " + this.jdField_d_of_type_Boolean + ", troopUin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        super.setContentView(localView);
        this.jdField_d_of_type_AndroidViewView = localView;
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130838891);
        this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131378784);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131378727));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131690708));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369115));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690708));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369068));
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131694268) + getString(2131690596));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369082));
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131691014));
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this, this.app);
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
        localObject1 = View.inflate(this, 2131560658, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject1;
        O();
        this.jdField_b_of_type_AndroidViewView.measure(0, 0);
        localObject1 = View.inflate(this, 2131561537, null);
        ((View)localObject1).setBackgroundResource(2130850608);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        ((View)localObject1).getLayoutParams().height = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
        localObject2 = View.inflate(this, 2131561534, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[23] = localObject2;
        ((View)localObject2).setTag(Integer.valueOf(23));
        ((View)localObject2).setOnClickListener(this);
        ((View)localObject2).setContentDescription(amtj.a(2131700873));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        localView.findViewById(2131379196).setVisibility(8);
        localObject1 = ((View)localObject2).findViewById(2131367927);
        ((View)localObject1).setTag(Integer.valueOf(35));
        ((View)localObject1).setContentDescription(getResources().getString(2131698698));
        if (bbyp.b()) {
          ((View)localObject1).setBackground(null);
        }
        if ((localObject1 instanceof ThemeImageView)) {
          ((ThemeImageView)localObject1).setSupportMaskView(false);
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[35] = localObject1;
        y();
        localObject1 = ((View)localObject2).findViewById(2131379260);
        ((View)localObject1).setTag(Integer.valueOf(36));
        this.jdField_a_of_type_ArrayOfAndroidViewView[36] = localObject1;
        e();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
          localObject2 = ((View)localObject2).findViewById(2131377914);
          ((TextView)localObject2).setText(new QQText((CharSequence)localObject1, 11, 16));
          this.jdField_a_of_type_ArrayOfAndroidViewView[37] = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
            ((View)localObject2).setVisibility(8);
          }
          d();
          localObject1 = (bdvh)apub.a().a(686);
          if ((localObject1 != null) && (((bdvh)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData)))
          {
            localObject1 = View.inflate(this, 2131561537, null);
            ((View)localObject1).setBackgroundResource(2130850608);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298532);
            localObject1 = View.inflate(this, 2131561527, null);
            this.jdField_a_of_type_ArrayOfAndroidViewView[43] = localObject1;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            i1 = 0;
            localObject2 = (TroopManager)this.app.getManager(52);
            if (localObject2 != null) {
              i1 = ((TroopManager)localObject2).k(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            }
            localObject1 = (TextView)((View)localObject1).findViewById(2131376413);
            TroopUtils.updateRedPoint(TroopUtils.isEmptyRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION"), (TextView)localObject1);
            e(i1);
          }
          localObject1 = (bdnn)apub.a().a(664);
          if ((localObject1 == null) || (!((bdnn)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
            break label5052;
          }
          i1 = 1;
          localObject1 = View.inflate(this, 2131561537, null);
          ((View)localObject1).setBackgroundResource(2130850608);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
          localObject1 = View.inflate(this, 2131561530, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject1;
          ((View)localObject1).setTag(Integer.valueOf(0));
          if (i1 == 0) {
            break label4897;
          }
          ((View)localObject1).setBackgroundResource(2130839485);
          ((View)localObject1).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370658));
          this.jdField_c_of_type_AndroidWidgetTextView.setText(amtj.a(2131700883) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + amtj.a(2131700891));
          if (AppSetting.jdField_c_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, AIOUtils.dp2px(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), AIOUtils.dp2px(3.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), AIOUtils.dp2px(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()));
          }
          a((View)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)((View)localObject1).findViewById(2131370656));
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
          x();
          localObject1 = View.inflate(this, 2131561527, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[42] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          a(42, 3, (View)localObject1, getString(2131698748), "", true);
          ((View)localObject1).setTag(Integer.valueOf(42));
          localObject2 = (TextView)((View)localObject1).findViewById(2131363616);
          if (localObject2 != null) {
            ((TextView)localObject2).setVisibility(8);
          }
          if (i1 == 0) {
            break label4919;
          }
          bool = bfun.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
          localObject2 = bfun.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "");
          localObject3 = (TextView)((View)localObject1).findViewById(2131376413);
          if (localObject3 != null)
          {
            if ((!bool) || (!TextUtils.isEmpty((CharSequence)localObject2))) {
              break label4908;
            }
            ((TextView)localObject3).setText((CharSequence)localObject2);
            TroopUtils.updateRedPoint(bool, (TextView)localObject3);
          }
          ((View)localObject1).setOnClickListener(this);
          ((View)localObject1).setVisibility(0);
          bcef.b(this.app, "dc00898", "", "", "0X800B2F0", "0X800B2F0", 0, 0, "", "", "", "");
          localObject1 = View.inflate(this, 2131561537, null);
          ((View)localObject1).setBackgroundResource(2130850608);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
          localObject1 = View.inflate(this, 2131559868, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localObject1;
          ((View)localObject1).getBackground().setAlpha(255);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setVisibility(8);
          this.jdField_c_of_type_AndroidViewView = View.inflate(this, 2131561537, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
          this.jdField_c_of_type_AndroidViewView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          localObject1 = View.inflate(this, 2131561527, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[14] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setTag(Integer.valueOf(14));
          a(14, 2, (View)localObject1, getString(2131691669), "", true);
          e();
          b((View)localObject1);
          localObject1 = View.inflate(this, 2131561527, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[25] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setTag(Integer.valueOf(25));
          a(25, 2, (View)localObject1, getString(2131698702), "", true);
          if ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
            break label4929;
          }
          bool = true;
          c(bool);
          b((View)localObject1);
          localObject1 = View.inflate(this, 2131561527, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          a((View)localObject1, null);
          a(4, 3, (View)localObject1, getString(2131698726), "", true);
          ((View)localObject1).setTag(Integer.valueOf(4));
          ((View)localObject1).setOnClickListener(this);
          localObject1 = new View(this);
          ((View)localObject1).setBackgroundResource(2130850000);
          localObject2 = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject2).height = 1;
          ((RelativeLayout.LayoutParams)localObject2).setMargins(AIOUtils.dp2px(16.0F, getResources()), 0, 0, 0);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject2 = View.inflate(this, 2131561527, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject2;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          a((View)localObject2, null);
          ((View)localObject2).setTag(Integer.valueOf(5));
          ((View)localObject2).setOnClickListener(this);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
            break label4935;
          }
          localObject1 = amtj.a(2131700861);
          a(5, 3, (View)localObject2, getString(2131719171), (CharSequence)localObject1, true);
          if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (!this.jdField_b_of_type_Boolean)) {
            break label4946;
          }
          i1 = 0;
          ((View)localObject2).setVisibility(i1);
          localObject3 = (TextView)((View)localObject2).findViewById(2131376413);
          ((TextView)localObject3).setText((CharSequence)localObject1);
          b((View)localObject2);
          this.p = TroopUtils.isEmptyRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY" + this.app.getCurrentAccountUin());
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
            break label4952;
          }
          bool = false;
          this.o = TroopUtils.isShowKingTeamRedPoint(bool, "RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
          TroopUtils.updateRedPoint(TroopUtils.isUpdateBeforeSomeVersion(this, "8.0.5"), "RED_POINT_KEY_TROOP_ADMIN", this.o, this.p, (TextView)localObject3);
          localObject1 = (TroopPluginManager)this.app.getManager(119);
          if (localObject1 != null) {
            this.jdField_b_of_type_Boolean = ((TroopPluginManager)localObject1).a("troop_manage_plugin.apk", new adbx(this));
          }
          localObject1 = View.inflate(this, 2131561537, null);
          ((View)localObject1).setBackgroundResource(2130850608);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
          localObject1 = new FormSimpleItem(this);
          a(1001, 0, (FormSimpleItem)localObject1, getString(2131695590), amtj.a(2131700875), true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2131561537, null);
          ((View)localObject1).setBackgroundResource(2130850608);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBgType(1);
          ((FormSwitchItem)localObject1).setText(getString(2131692858));
          ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167012));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131692858));
          this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
          localObject2 = ((FormSwitchItem)localObject1).a();
          if (!((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            break label4964;
          }
          ((Switch)localObject2).setChecked(true);
          ((Switch)localObject2).setTag(Integer.valueOf(7));
          ((Switch)localObject2).setOnCheckedChangeListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBackgroundResource(2130839485);
          ((FormSwitchItem)localObject1).setBgType(2);
          ((FormSwitchItem)localObject1).setText(getString(2131692859));
          ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167012));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131692859));
          this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
          localObject2 = ((FormSwitchItem)localObject1).a();
          ((Switch)localObject2).setTag(Boolean.FALSE);
          int i2 = this.app.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopmask = i2;
          }
          if (i2 == 1) {
            break label4973;
          }
          bool = true;
          ((Switch)localObject2).setChecked(bool);
          ((Switch)localObject2).setOnCheckedChangeListener(new adcb(this));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2131561524, null);
          localObject2 = (FormSimpleItem)((View)localObject1).findViewById(2131369032);
          a(9, 0, (FormSimpleItem)localObject2, getString(2131719100), "", true);
          this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
          localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(17.0F, getResources()), AIOUtils.dp2px(17.0F, getResources()));
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = AIOUtils.dp2px(30.0F, getResources());
          ((RelativeLayout.LayoutParams)localObject3).addRule(11);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15);
          ((FormSimpleItem)localObject2).addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject3);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839445));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_ArrayOfAndroidViewView[9] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(1010, 2, (FormSimpleItem)localObject1, getString(2131694147), getString(2131718175), true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localObject1);
          localObject2 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject2).setBackgroundResource(2130839485);
          ((FormSwitchItem)localObject2).setText(getString(2131695833));
          ((FormSwitchItem)localObject2).a().setTextColor(getResources().getColorStateList(2131167012));
          ((FormSwitchItem)localObject2).setFocusable(true);
          ((FormSwitchItem)localObject2).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject2).setContentDescription(getString(2131695833));
          this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject2;
          ((FormSwitchItem)localObject2).a().setTag(Integer.valueOf(10));
          U();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          localObject1 = View.inflate(this, 2131561537, null);
          ((View)localObject1).setBackgroundResource(2130850608);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
          localObject3 = new FormSimpleItem(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject3;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
          if (i1 != 0) {
            break label4979;
          }
          i1 = 3;
          String str2 = getString(2131694023);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick)) {
            break label4984;
          }
          localObject1 = getString(2131697043);
          a(6, i1, (FormSimpleItem)localObject3, str2, (CharSequence)localObject1, true);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick))
          {
            localObject1 = new bczs(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).a();
            ((FormSimpleItem)localObject3).setRightText((CharSequence)localObject1);
            bgdk.a(this.app, ((FormSimpleItem)localObject3).a(), (Spannable)localObject1);
          }
          localObject1 = View.inflate(this, 2131561537, null);
          ((View)localObject1).setBackgroundResource(2130850608);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
          if (((bepr)this.app.getManager(346)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
          {
            localObject1 = new FormSimpleItem(this, null);
            ((FormSimpleItem)localObject1).a(true);
            ((FormSimpleItem)localObject1).setBgType(1);
            ((FormSimpleItem)localObject1).setLeftText(getResources().getString(2131698713));
            ((FormSimpleItem)localObject1).setRightText(getResources().getString(2131698711));
            ((FormSimpleItem)localObject1).setContentDescription(getResources().getString(2131698713));
            ((FormSwitchItem)localObject2).a().setTextColor(getResources().getColorStateList(2131167012));
            ((FormSimpleItem)localObject1).setFocusable(true);
            ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
            this.jdField_a_of_type_ArrayOfAndroidViewView[32] = localObject1;
            ((FormSimpleItem)localObject1).setTag(Integer.valueOf(32));
            ((FormSimpleItem)localObject1).setOnClickListener(this);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            bcef.b(null, "dc00898", "", "", "0X800A6EE", "0X800A6EE", 0, 0, "", "", "", "");
          }
          localObject1 = View.inflate(this, 2131561537, null);
          ((View)localObject1).setBackgroundResource(2130850608);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
          localObject1 = new FormSimpleItem(this, null);
          ((FormSimpleItem)localObject1).a(true);
          ((FormSimpleItem)localObject1).setBgType(2);
          ((FormSimpleItem)localObject1).setLeftText(getResources().getString(2131719603));
          ((FormSimpleItem)localObject1).a().setTextColor(getResources().getColor(2131167012));
          ((FormSimpleItem)localObject1).setFocusable(true);
          ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
          ((FormSimpleItem)localObject1).setContentDescription(getResources().getString(2131719603));
          this.jdField_a_of_type_ArrayOfAndroidViewView[16] = localObject1;
          ((FormSimpleItem)localObject1).setTag(Integer.valueOf(16));
          ((FormSimpleItem)localObject1).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          u();
          localObject1 = new FormSimpleItem(this, null);
          ((FormSimpleItem)localObject1).a(true);
          ((FormSimpleItem)localObject1).setBgType(3);
          ((FormSimpleItem)localObject1).setLeftText("一起K歌");
          ((FormSimpleItem)localObject1).a().setTextColor(getResources().getColor(2131167012));
          ((FormSimpleItem)localObject1).setFocusable(true);
          ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
          ((FormSimpleItem)localObject1).setContentDescription("一起K歌");
          this.jdField_a_of_type_ArrayOfAndroidViewView[38] = localObject1;
          ((FormSimpleItem)localObject1).setTag(Integer.valueOf(38));
          ((FormSimpleItem)localObject1).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          v();
          if (bgjy.a())
          {
            localObject1 = View.inflate(this, 2131561537, null);
            ((View)localObject1).setBackgroundResource(2130850608);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
            localObject1 = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[40] = localObject1;
            a(40, 0, (FormSimpleItem)localObject1, getString(2131698723), "", true);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          }
          localObject1 = View.inflate(this, 2131561537, null);
          ((View)localObject1).setBackgroundResource(2130850608);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
          if (!bezm.a(this.app)) {
            break label5028;
          }
          this.jdField_a_of_type_Bffq = new bffq(this, getString(2131719268));
          localObject1 = this.jdField_a_of_type_Bffq.a();
          if (localObject1 != null)
          {
            if (!bezm.c(this.app)) {
              break label4996;
            }
            this.n = bezm.b(this.app);
            if (QLog.isColorLevel()) {
              QLog.d("Q.chatopttroop", 2, "bShowRed red robot" + this.n);
            }
            this.jdField_a_of_type_Bffq.a(this.n);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).setOnClickListener(this);
            ((View)localObject1).setTag(Integer.valueOf(1009));
            localObject1 = View.inflate(this, 2131561537, null);
            ((View)localObject1).setBackgroundResource(2130850608);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
            bcef.b(this.app, "dc00898", "", "", "", "0X8009F9B", 0, 0, "", "", "", "");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()))
          {
            localObject1 = new FormSimpleItem(this);
            a(1006, 0, (FormSimpleItem)localObject1, amtj.a(2131700910), "", true);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            bftc.a("Grp_edu", "Grp_data", "teachermsg_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          }
          localObject1 = new LinearLayout(this);
          ((LinearLayout)localObject1).setOrientation(1);
          ((LinearLayout)localObject1).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_a_of_type_ArrayOfAndroidViewView[28] = localObject1;
          localObject1 = View.inflate(this, 2131561537, null);
          ((View)localObject1).setBackgroundResource(2130850608);
          this.jdField_a_of_type_ArrayOfAndroidViewView[24] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
          localObject1 = new FormSimpleItem(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[17] = localObject1;
          a(17, 1, (FormSimpleItem)localObject1, amtj.a(2131700895), "", true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
          {
            localObject1 = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[44] = localObject1;
            a(44, 1, (FormSimpleItem)localObject1, amtj.a(2131704469), "", true);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop", 2, "initUI  mIsQidianPrivateTroop = " + this.jdField_d_of_type_Boolean);
          }
          if (!this.jdField_d_of_type_Boolean)
          {
            localObject1 = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[18] = localObject1;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            a(18, 2, (FormSimpleItem)localObject1, getString(2131719130), "", true);
            ((FormSimpleItem)localObject1).setVisibility(8);
            localObject1 = (bedt)this.app.getManager(231);
            if (QLog.isColorLevel()) {
              QLog.d("Q.chatopttroop", 2, "initUI  effectManager.isAllTroopShowEnterance() = " + ((bedt)localObject1).b());
            }
            if (((bedt)localObject1).b()) {
              a(true);
            }
          }
          S();
          localObject1 = View.inflate(this, 2131561537, null);
          ((View)localObject1).setBackgroundResource(2130850608);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
          localObject1 = View.inflate(this, 2131561520, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[27] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          a(27, 0, (View)localObject1, getString(2131695591), null, false);
          ((View)localObject1).setTag(Integer.valueOf(27));
          ((View)localObject1).setOnClickListener(this);
          localObject2 = (TextView)((View)localObject1).findViewById(2131378707);
          if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
            ((TextView)localObject2).setAlpha(0.5F);
          }
          ((TextView)localObject2).setTextColor(Color.parseColor("#4799DF"));
          localObject1 = (TextView)((View)localObject1).findViewById(2131368660);
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
          localObject1 = View.inflate(this, 2131561535, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = (Button)((View)localObject1).findViewById(2131365397);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
            break label5041;
          }
          ((Button)localObject1).setText(2131691633);
          ((Button)localObject1).setOnClickListener(new adcc(this));
          localObject1 = View.inflate(this, 2131561537, null);
          ((View)localObject1).setBackgroundResource(2130850608);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131298048);
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
          }
          this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363803);
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363721));
          this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131377294));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)localView.findViewById(2131363630));
          this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new adcd(this));
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
      String str1 = getString(2131695629);
      continue;
      label4897:
      str1.setBackgroundResource(2130839482);
      continue;
      label4908:
      ((TextView)localObject3).setText("");
      continue;
      label4919:
      str1.setVisibility(8);
      continue;
      label4929:
      boolean bool = false;
      continue;
      label4935:
      str1 = amtj.a(2131700868);
      continue;
      label4946:
      int i1 = 8;
      continue;
      label4952:
      bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop();
      continue;
      label4964:
      ((Switch)localObject2).setChecked(false);
      continue;
      label4973:
      bool = false;
      continue;
      label4979:
      i1 = 0;
      continue;
      label4984:
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick;
      continue;
      label4996:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        this.n = bezm.b(this.app);
      }
      else
      {
        this.n = false;
        continue;
        label5028:
        QLog.i("Q.chatopttroop", 2, "RobotSwithOff");
        continue;
        label5041:
        str1.setText(2131716232);
        continue;
        label5052:
        i1 = 0;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new bhig(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131368660);
    if (paramString != null)
    {
      paramString.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      if (!TextUtils.isEmpty(paramCharSequence)) {
        break label70;
      }
    }
    label70:
    for (paramView = "";; paramView = new QQText(paramCharSequence, 3))
    {
      paramString.setText(paramView);
      paramString.setTextColor(getResources().getColor(2131167092));
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
        localTextView = (TextView)paramView.findViewById(2131378707);
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
      paramView.setBackgroundResource(2130839475);
      break label52;
      paramView.setBackgroundResource(2130839491);
      break label52;
      paramView.setBackgroundResource(2130839485);
      break label52;
      paramView.setBackgroundResource(2130839482);
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
    String str2 = bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (paramInt == -1) {}
    for (Object localObject = "0";; localObject = "1")
    {
      bftc.a("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
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
      paramView = paramView.findViewById(2131362968);
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
    //   5: getfield 2264	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 2266	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 2267	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 10
    //   21: aload 10
    //   23: aload_1
    //   24: getfield 2271	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 2272	[B
    //   30: invokevirtual 2273	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 2276	KQQ/BatchResponse:seq	I
    //   38: ifne +749 -> 787
    //   41: aload 10
    //   43: ifnull +744 -> 787
    //   46: aload 10
    //   48: getfield 2280	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 2283	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq +733 -> 787
    //   57: aload 10
    //   59: getfield 2280	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 2286	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 2292	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore 8
    //   70: new 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   73: dup
    //   74: invokespecial 2295	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   77: astore 9
    //   79: aload 9
    //   81: aload 8
    //   83: invokevirtual 2296	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   86: pop
    //   87: aconst_null
    //   88: astore 8
    //   90: aload 9
    //   92: getfield 2300	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: invokevirtual 2305	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   98: astore 11
    //   100: aload 11
    //   102: ifnonnull +53 -> 155
    //   105: iconst_0
    //   106: istore_3
    //   107: goto +1382 -> 1489
    //   110: aload 8
    //   112: ifnonnull +675 -> 787
    //   115: iload 4
    //   117: iload_3
    //   118: if_icmpge +669 -> 787
    //   121: aload 11
    //   123: iload 4
    //   125: invokeinterface 2307 2 0
    //   130: checkcast 2309	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
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
    //   151: invokevirtual 2310	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   154: return
    //   155: aload 11
    //   157: invokeinterface 2313 1 0
    //   162: istore_3
    //   163: goto +1326 -> 1489
    //   166: aload 9
    //   168: getfield 2317	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: invokevirtual 2320	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   174: istore_2
    //   175: iload_2
    //   176: bipush 72
    //   178: if_icmpne +83 -> 261
    //   181: iload 4
    //   183: ifne +78 -> 261
    //   186: aload_0
    //   187: ldc_w 2321
    //   190: iconst_1
    //   191: invokestatic 1600	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   194: aload_0
    //   195: invokevirtual 1603	com/tencent/mobileqq/activity/ChatSettingForTroop:getTitleBarHeight	()I
    //   198: invokevirtual 1606	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   201: pop
    //   202: new 2323	com/tencent/mobileqq/activity/ChatSettingForTroop$35
    //   205: dup
    //   206: aload_0
    //   207: invokespecial 2324	com/tencent/mobileqq/activity/ChatSettingForTroop$35:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   210: bipush 32
    //   212: aconst_null
    //   213: iconst_0
    //   214: invokestatic 2329	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   217: aload_0
    //   218: aconst_null
    //   219: putfield 306	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   222: aload_0
    //   223: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   226: iconst_0
    //   227: putfield 1348	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   230: aload_0
    //   231: invokevirtual 845	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   234: ldc_w 2331
    //   237: iconst_0
    //   238: invokevirtual 861	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   241: pop
    //   242: aload_0
    //   243: invokevirtual 1475	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   246: aload_0
    //   247: aload_0
    //   248: invokevirtual 845	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   251: invokevirtual 1496	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   254: iconst_2
    //   255: invokestatic 2335	com/tencent/mobileqq/troop/utils/TroopUtils:openTroopInfoActivity	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   258: goto -118 -> 140
    //   261: iload_2
    //   262: ifne +1121 -> 1383
    //   265: aload 9
    //   267: getfield 2339	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   270: invokevirtual 2342	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   273: ifeq +1110 -> 1383
    //   276: aload 9
    //   278: getfield 2339	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   281: invokevirtual 2345	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   284: checkcast 2341	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   287: astore 9
    //   289: aload 9
    //   291: astore 8
    //   293: aload 9
    //   295: ifnull -155 -> 140
    //   298: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +40 -> 341
    //   304: ldc_w 282
    //   307: iconst_2
    //   308: new 284	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 2347
    //   318: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 9
    //   323: getfield 2350	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_long_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   326: invokevirtual 2286	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   329: invokevirtual 2353	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   332: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 301	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload 9
    //   343: astore 8
    //   345: aload_0
    //   346: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   349: ifnull -209 -> 140
    //   352: aload_0
    //   353: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   356: aload 9
    //   358: invokevirtual 2357	com/tencent/mobileqq/troopinfo/TroopInfoData:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   361: aload_0
    //   362: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   365: getfield 1264	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   368: invokestatic 526	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +7 -> 378
    //   374: aload_0
    //   375: invokevirtual 967	com/tencent/mobileqq/activity/ChatSettingForTroop:e	()V
    //   378: aload_0
    //   379: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   382: getfield 1428	com/tencent/mobileqq/troopinfo/TroopInfoData:hasSetNewTroopHead	Z
    //   385: ifeq +7 -> 392
    //   388: aload_0
    //   389: invokespecial 1866	com/tencent/mobileqq/activity/ChatSettingForTroop:y	()V
    //   392: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   395: ifeq +69 -> 464
    //   398: aload 9
    //   400: getfield 2360	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   403: invokevirtual 2320	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   406: istore_2
    //   407: ldc_w 2362
    //   410: iconst_2
    //   411: new 284	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 2364
    //   421: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   428: getfield 345	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   431: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 2366
    //   437: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: iload_2
    //   441: invokevirtual 1398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: ldc_w 2368
    //   447: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload_2
    //   451: i2l
    //   452: invokestatic 2370	com/tencent/mobileqq/data/troop/TroopInfo:isQidianPrivateTroop	(J)Z
    //   455: invokevirtual 297	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   458: invokevirtual 301	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload_0
    //   465: getfield 306	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   468: ifnull +64 -> 532
    //   471: aload_0
    //   472: getfield 306	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   475: aload 9
    //   477: invokevirtual 2371	com/tencent/mobileqq/data/troop/TroopInfo:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   480: aload_0
    //   481: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   484: aload_0
    //   485: getfield 306	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   488: invokevirtual 520	com/tencent/mobileqq/data/troop/TroopInfo:getTroopName	()Ljava/lang/String;
    //   491: putfield 1264	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   494: aload_0
    //   495: getfield 306	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   498: getfield 2372	com/tencent/mobileqq/data/troop/TroopInfo:isNewTroop	Z
    //   501: ifne +17 -> 518
    //   504: aload_0
    //   505: getfield 306	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   508: aload_0
    //   509: getfield 306	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   512: invokevirtual 520	com/tencent/mobileqq/data/troop/TroopInfo:getTroopName	()Ljava/lang/String;
    //   515: putfield 2373	com/tencent/mobileqq/data/troop/TroopInfo:newTroopName	Ljava/lang/String;
    //   518: aload_0
    //   519: getfield 306	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   522: aload_0
    //   523: getfield 306	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   526: invokevirtual 520	com/tencent/mobileqq/data/troop/TroopInfo:getTroopName	()Ljava/lang/String;
    //   529: putfield 2376	com/tencent/mobileqq/data/troop/TroopInfo:oldTroopName	Ljava/lang/String;
    //   532: aload_0
    //   533: aload 9
    //   535: getfield 2360	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   538: invokevirtual 2320	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   541: i2l
    //   542: invokestatic 2370	com/tencent/mobileqq/data/troop/TroopInfo:isQidianPrivateTroop	(J)Z
    //   545: putfield 1798	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   548: aload_0
    //   549: getfield 1798	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   552: ifeq +77 -> 629
    //   555: aload_0
    //   556: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   559: getfield 294	com/tencent/mobileqq/troopinfo/TroopInfoData:bOwner	Z
    //   562: ifeq +806 -> 1368
    //   565: iconst_1
    //   566: istore_2
    //   567: new 2378	bcek
    //   570: dup
    //   571: aload_0
    //   572: getfield 310	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   575: invokespecial 2381	bcek:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   578: ldc_w 334
    //   581: invokevirtual 2384	bcek:a	(Ljava/lang/String;)Lbcek;
    //   584: ldc_w 2386
    //   587: invokevirtual 2388	bcek:b	(Ljava/lang/String;)Lbcek;
    //   590: ldc_w 340
    //   593: invokevirtual 2390	bcek:c	(Ljava/lang/String;)Lbcek;
    //   596: ldc_w 2392
    //   599: invokevirtual 2394	bcek:d	(Ljava/lang/String;)Lbcek;
    //   602: iconst_2
    //   603: anewarray 585	java/lang/String
    //   606: dup
    //   607: iconst_0
    //   608: aload_0
    //   609: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   612: getfield 345	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: iload_2
    //   619: invokestatic 1218	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   622: aastore
    //   623: invokevirtual 2397	bcek:a	([Ljava/lang/String;)Lbcek;
    //   626: invokevirtual 2399	bcek:a	()V
    //   629: aload_0
    //   630: getfield 1798	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   633: ifne +867 -> 1500
    //   636: aload_0
    //   637: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   640: getfield 1937	com/tencent/mobileqq/troopinfo/TroopInfoData:isNewTroop	Z
    //   643: ifne +857 -> 1500
    //   646: iconst_1
    //   647: istore 5
    //   649: aload_0
    //   650: iload 5
    //   652: invokespecial 1223	com/tencent/mobileqq/activity/ChatSettingForTroop:c	(Z)V
    //   655: aload_0
    //   656: invokevirtual 2401	com/tencent/mobileqq/activity/ChatSettingForTroop:l	()V
    //   659: aload_0
    //   660: getfield 310	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   663: aload_0
    //   664: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   667: getfield 2404	com/tencent/mobileqq/troopinfo/TroopInfoData:publicAccountUin	J
    //   670: new 2406	adbl
    //   673: dup
    //   674: aload_0
    //   675: invokespecial 2407	adbl:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   678: invokestatic 2412	bfap:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLnmf;)V
    //   681: aload_0
    //   682: invokevirtual 2414	com/tencent/mobileqq/activity/ChatSettingForTroop:k	()V
    //   685: aload_0
    //   686: invokespecial 2416	com/tencent/mobileqq/activity/ChatSettingForTroop:L	()V
    //   689: aload_0
    //   690: invokevirtual 1870	com/tencent/mobileqq/activity/ChatSettingForTroop:d	()V
    //   693: aload_0
    //   694: invokespecial 1640	com/tencent/mobileqq/activity/ChatSettingForTroop:O	()V
    //   697: aload_0
    //   698: invokevirtual 2418	com/tencent/mobileqq/activity/ChatSettingForTroop:q	()V
    //   701: aload_0
    //   702: getfield 306	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   705: ifnull +21 -> 726
    //   708: aload_0
    //   709: getfield 306	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo	Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   712: aload_0
    //   713: getfield 310	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   716: aload_0
    //   717: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   720: getfield 1348	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   723: invokestatic 2422	com/tencent/mobileqq/troop/utils/TroopUtils:updateTroopInfoToDB	(Lcom/tencent/mobileqq/data/troop/TroopInfo;Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   726: aload_0
    //   727: invokevirtual 2424	com/tencent/mobileqq/activity/ChatSettingForTroop:f	()V
    //   730: aload_0
    //   731: getfield 2426	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   734: ifnull +21 -> 755
    //   737: aload_0
    //   738: getfield 2426	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   741: aload_0
    //   742: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   745: invokevirtual 2432	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:setTroopInfoData	(Lcom/tencent/mobileqq/troopinfo/TroopInfoData;)V
    //   748: aload_0
    //   749: getfield 2426	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   752: invokevirtual 2433	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	()V
    //   755: aload_0
    //   756: iconst_0
    //   757: invokespecial 2435	com/tencent/mobileqq/activity/ChatSettingForTroop:i	(Z)V
    //   760: aload 9
    //   762: astore 8
    //   764: goto -624 -> 140
    //   767: astore 8
    //   769: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   772: ifeq +15 -> 787
    //   775: ldc_w 2437
    //   778: iconst_2
    //   779: aload 8
    //   781: invokevirtual 2438	java/lang/Exception:toString	()Ljava/lang/String;
    //   784: invokestatic 709	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: aload_1
    //   788: getfield 2276	KQQ/BatchResponse:seq	I
    //   791: iconst_1
    //   792: if_icmpne +92 -> 884
    //   795: aload 10
    //   797: ifnull +87 -> 884
    //   800: aload 10
    //   802: getfield 2280	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   805: invokevirtual 2283	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   808: ifeq +76 -> 884
    //   811: aload 10
    //   813: getfield 2280	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   816: invokevirtual 2286	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   819: invokevirtual 2292	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   822: astore 8
    //   824: new 2440	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   827: dup
    //   828: invokespecial 2441	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   831: astore 9
    //   833: aload 9
    //   835: aload 8
    //   837: invokevirtual 2442	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   840: pop
    //   841: aload 9
    //   843: getfield 2445	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   846: invokevirtual 2446	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   849: ifeq +35 -> 884
    //   852: aload_0
    //   853: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   856: getfield 1348	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   859: ifne +554 -> 1413
    //   862: aload_0
    //   863: getfield 2426	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   866: ifnull +18 -> 884
    //   869: aload_0
    //   870: getfield 2426	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   873: aload 9
    //   875: getfield 2445	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   878: invokevirtual 2305	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   881: invokevirtual 2448	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	(Ljava/util/List;)V
    //   884: aload_1
    //   885: getfield 2276	KQQ/BatchResponse:seq	I
    //   888: iconst_2
    //   889: if_icmpne -878 -> 11
    //   892: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   895: ifeq +13 -> 908
    //   898: ldc_w 2450
    //   901: iconst_2
    //   902: ldc_w 2452
    //   905: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   908: aload 10
    //   910: ifnull -899 -> 11
    //   913: aload 10
    //   915: getfield 2280	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   918: invokevirtual 2283	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   921: ifeq -910 -> 11
    //   924: aload 10
    //   926: getfield 2280	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   929: invokevirtual 2286	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   932: invokevirtual 2292	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   935: astore_1
    //   936: new 2454	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   939: dup
    //   940: invokespecial 2455	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   943: astore 9
    //   945: aload 9
    //   947: aload_1
    //   948: invokevirtual 2456	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   951: pop
    //   952: aload 9
    //   954: getfield 2459	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   957: invokevirtual 809	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   960: ifeq -949 -> 11
    //   963: aload 9
    //   965: getfield 2462	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   968: invokevirtual 2463	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   971: ifne +513 -> 1484
    //   974: aload 9
    //   976: getfield 2462	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   979: invokevirtual 2305	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   982: astore_1
    //   983: aload 9
    //   985: getfield 2466	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   988: invokevirtual 2463	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   991: ifne +487 -> 1478
    //   994: aload 9
    //   996: getfield 2466	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   999: invokevirtual 2305	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1002: astore 8
    //   1004: aload_0
    //   1005: getfield 310	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1008: bipush 52
    //   1010: invokevirtual 316	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1013: checkcast 318	com/tencent/mobileqq/app/TroopManager
    //   1016: astore 10
    //   1018: aload 9
    //   1020: getfield 2459	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1023: invokevirtual 811	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1026: lstore 6
    //   1028: aload 10
    //   1030: lload 6
    //   1032: invokestatic 1312	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1035: invokevirtual 353	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/troop/TroopInfo;
    //   1038: astore 11
    //   1040: aload 11
    //   1042: ifnull -1031 -> 11
    //   1045: aload_1
    //   1046: ifnull +71 -> 1117
    //   1049: aload 11
    //   1051: aload_1
    //   1052: aload 8
    //   1054: invokevirtual 2470	com/tencent/mobileqq/data/troop/TroopInfo:setTroopLevelMap787	(Ljava/util/List;Ljava/util/List;)V
    //   1057: aload 9
    //   1059: getfield 2473	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1062: invokevirtual 2474	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1065: ifeq +386 -> 1451
    //   1068: aload 9
    //   1070: getfield 2473	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1073: invokevirtual 2320	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1076: istore_2
    //   1077: aload 11
    //   1079: iload_2
    //   1080: i2l
    //   1081: putfield 2477	com/tencent/mobileqq/data/troop/TroopInfo:dwGroupLevelSeq	J
    //   1084: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq +30 -> 1117
    //   1090: ldc_w 2450
    //   1093: iconst_2
    //   1094: new 284	java/lang/StringBuilder
    //   1097: dup
    //   1098: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   1101: ldc_w 2479
    //   1104: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: iload_2
    //   1108: invokevirtual 1398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1111: invokevirtual 301	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1114: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1117: aload 9
    //   1119: getfield 2482	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1122: astore_1
    //   1123: aload_1
    //   1124: ifnull +19 -> 1143
    //   1127: aload 11
    //   1129: aload 9
    //   1131: getfield 2482	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1134: invokevirtual 2286	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1137: invokevirtual 2353	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1140: putfield 2485	com/tencent/mobileqq/data/troop/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   1143: aload 9
    //   1145: getfield 2488	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1148: astore_1
    //   1149: aload_1
    //   1150: ifnull +19 -> 1169
    //   1153: aload 11
    //   1155: aload 9
    //   1157: getfield 2488	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1160: invokevirtual 2286	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1163: invokevirtual 2353	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1166: putfield 2491	com/tencent/mobileqq/data/troop/TroopInfo:adminNameShow	Ljava/lang/String;
    //   1169: iconst_m1
    //   1170: istore_2
    //   1171: iconst_m1
    //   1172: istore_3
    //   1173: iconst_m1
    //   1174: istore 4
    //   1176: aload 9
    //   1178: getfield 2494	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1181: invokevirtual 2474	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1184: ifeq +23 -> 1207
    //   1187: aload 11
    //   1189: aload 9
    //   1191: getfield 2494	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1194: invokevirtual 2320	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1197: i2b
    //   1198: putfield 2497	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   1201: aload 11
    //   1203: getfield 2497	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankSysFlag	B
    //   1206: istore_2
    //   1207: aload 9
    //   1209: getfield 2500	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1212: invokevirtual 2474	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1215: ifeq +23 -> 1238
    //   1218: aload 11
    //   1220: aload 9
    //   1222: getfield 2500	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1225: invokevirtual 2320	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1228: i2b
    //   1229: putfield 2503	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   1232: aload 11
    //   1234: getfield 2503	com/tencent/mobileqq/data/troop/TroopInfo:cGroupRankUserFlag	B
    //   1237: istore_3
    //   1238: aload 9
    //   1240: getfield 2506	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1243: invokevirtual 2474	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1246: ifeq +24 -> 1270
    //   1249: aload 11
    //   1251: aload 9
    //   1253: getfield 2506	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1256: invokevirtual 2320	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1259: i2b
    //   1260: putfield 2509	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   1263: aload 11
    //   1265: getfield 2509	com/tencent/mobileqq/data/troop/TroopInfo:cNewGroupRankUserFlag	B
    //   1268: istore 4
    //   1270: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1273: ifeq +56 -> 1329
    //   1276: ldc_w 2450
    //   1279: iconst_2
    //   1280: new 284	java/lang/StringBuilder
    //   1283: dup
    //   1284: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   1287: lload 6
    //   1289: invokevirtual 952	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1292: ldc_w 2511
    //   1295: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: iload_2
    //   1299: invokevirtual 1398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1302: ldc_w 2513
    //   1305: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: iload_3
    //   1309: invokevirtual 1398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1312: ldc_w 2515
    //   1315: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: iload 4
    //   1320: invokevirtual 1398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1323: invokevirtual 301	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1326: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1329: new 2517	com/tencent/mobileqq/activity/ChatSettingForTroop$37
    //   1332: dup
    //   1333: aload_0
    //   1334: aload 10
    //   1336: aload 11
    //   1338: invokespecial 2520	com/tencent/mobileqq/activity/ChatSettingForTroop$37:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/troop/TroopInfo;)V
    //   1341: bipush 8
    //   1343: aconst_null
    //   1344: iconst_0
    //   1345: invokestatic 2258	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1348: return
    //   1349: astore_1
    //   1350: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1353: ifeq -1342 -> 11
    //   1356: ldc_w 2450
    //   1359: iconst_2
    //   1360: aload_1
    //   1361: invokevirtual 2438	java/lang/Exception:toString	()Ljava/lang/String;
    //   1364: invokestatic 1345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1367: return
    //   1368: aload_0
    //   1369: getfield 130	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1372: getfield 375	com/tencent/mobileqq/troopinfo/TroopInfoData:bAdmin	Z
    //   1375: ifeq +120 -> 1495
    //   1378: iconst_2
    //   1379: istore_2
    //   1380: goto -813 -> 567
    //   1383: ldc_w 1390
    //   1386: iconst_1
    //   1387: new 284	java/lang/StringBuilder
    //   1390: dup
    //   1391: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   1394: ldc_w 2522
    //   1397: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: iload_2
    //   1401: invokevirtual 1398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1404: invokevirtual 301	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1407: invokestatic 1345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1410: goto -1270 -> 140
    //   1413: aload_0
    //   1414: aload 9
    //   1416: getfield 2445	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1419: invokevirtual 2305	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1422: invokespecial 1080	com/tencent/mobileqq/activity/ChatSettingForTroop:c	(Ljava/util/List;)V
    //   1425: goto -541 -> 884
    //   1428: astore 8
    //   1430: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1433: ifeq -549 -> 884
    //   1436: ldc_w 2437
    //   1439: iconst_2
    //   1440: aload 8
    //   1442: invokevirtual 2438	java/lang/Exception:toString	()Ljava/lang/String;
    //   1445: invokestatic 709	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1448: goto -564 -> 884
    //   1451: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1454: ifeq -337 -> 1117
    //   1457: ldc_w 2450
    //   1460: iconst_2
    //   1461: ldc_w 2524
    //   1464: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1467: goto -350 -> 1117
    //   1470: astore_1
    //   1471: goto -302 -> 1169
    //   1474: astore_1
    //   1475: goto -332 -> 1143
    //   1478: aconst_null
    //   1479: astore 8
    //   1481: goto -477 -> 1004
    //   1484: aconst_null
    //   1485: astore_1
    //   1486: goto -503 -> 983
    //   1489: iconst_0
    //   1490: istore 4
    //   1492: goto -1382 -> 110
    //   1495: iconst_3
    //   1496: istore_2
    //   1497: goto -930 -> 567
    //   1500: iconst_0
    //   1501: istore 5
    //   1503: goto -854 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1506	0	this	ChatSettingForTroop
    //   0	1506	1	paramBatchResponse	KQQ.BatchResponse
    //   174	1323	2	i1	int
    //   106	1203	3	i2	int
    //   115	1376	4	i3	int
    //   647	855	5	bool	boolean
    //   1026	262	6	l1	long
    //   68	695	8	localObject1	Object
    //   767	13	8	localException1	Exception
    //   822	231	8	localObject2	Object
    //   1428	13	8	localException2	Exception
    //   1479	1	8	localObject3	Object
    //   77	1338	9	localObject4	Object
    //   19	1316	10	localObject5	Object
    //   98	1239	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	149	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   70	87	767	java/lang/Exception
    //   90	100	767	java/lang/Exception
    //   121	135	767	java/lang/Exception
    //   155	163	767	java/lang/Exception
    //   166	175	767	java/lang/Exception
    //   186	258	767	java/lang/Exception
    //   265	289	767	java/lang/Exception
    //   298	341	767	java/lang/Exception
    //   345	378	767	java/lang/Exception
    //   378	392	767	java/lang/Exception
    //   392	464	767	java/lang/Exception
    //   464	518	767	java/lang/Exception
    //   518	532	767	java/lang/Exception
    //   532	565	767	java/lang/Exception
    //   567	629	767	java/lang/Exception
    //   629	646	767	java/lang/Exception
    //   649	726	767	java/lang/Exception
    //   726	755	767	java/lang/Exception
    //   755	760	767	java/lang/Exception
    //   1368	1378	767	java/lang/Exception
    //   1383	1410	767	java/lang/Exception
    //   936	983	1349	java/lang/Exception
    //   983	1004	1349	java/lang/Exception
    //   1004	1040	1349	java/lang/Exception
    //   1049	1117	1349	java/lang/Exception
    //   1117	1123	1349	java/lang/Exception
    //   1143	1149	1349	java/lang/Exception
    //   1176	1207	1349	java/lang/Exception
    //   1207	1238	1349	java/lang/Exception
    //   1238	1270	1349	java/lang/Exception
    //   1270	1329	1349	java/lang/Exception
    //   1329	1348	1349	java/lang/Exception
    //   1451	1467	1349	java/lang/Exception
    //   824	884	1428	java/lang/Exception
    //   1413	1425	1428	java/lang/Exception
    //   1153	1169	1470	java/lang/Exception
    //   1127	1143	1474	java/lang/Exception
  }
  
  public void a(adef paramadef, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramadef.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCacheFrom(paramadef.jdField_a_of_type_Int, paramadef.jdField_a_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bfvo.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramadef.jdField_a_of_type_JavaLangString, paramadef.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramadef.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  protected void a(View paramView)
  {
    int[] arrayOfInt = new int[6];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131379250;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131379251;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131379252;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131379253;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131379254;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131379255;
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
    bcef.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
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
                  bcef.b(this.app, "CliOper", "", "", "0x80084B5", "0x80084B5", 0, 0, "", "", "", "");
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
              d(getActivity().getResources().getString(2131719178));
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.chatopttroop", 2, "joinGroup onResult " + paramJSONObject.toString());
    return;
    label969:
    paramJSONObject = getActivity().getResources().getString(2131719178);
    switch (paramInt)
    {
    }
    for (;;)
    {
      d(paramJSONObject);
      break label870;
      paramJSONObject = getActivity().getResources().getString(2131719173);
      continue;
      paramJSONObject = getActivity().getResources().getString(2131719179);
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
      bbyp.b();
      bool2 = ThemeUtil.isInNightMode(this.app);
      localView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379194));
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
        break label411;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131708086));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new adbu(this));
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      i4 = localList.size();
      localObject1 = localView.findViewById(2131379118);
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
      localObject1 = localView.findViewById(2131379104);
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
        localImageView = (ImageView)((View)localObject1).findViewById(2131362830);
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131362852);
        localObject4 = (TextView)((View)localObject1).findViewById(2131362850);
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
        ((TextView)localObject4).setCompoundDrawablesWithIntrinsicBounds(2130850321, 0, 0, 0);
        ((StringBuffer)localObject3).append("，新");
        label650:
        long l1 = localAppInfo.appid.get();
        if ((i3 != -1) && (l1 == 1L))
        {
          if (!bfun.a(this.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false)) {
            break label1204;
          }
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText("");
          ((TextView)localObject4).setBackgroundResource(0);
          ((TextView)localObject4).setCompoundDrawablesWithIntrinsicBounds(2130850321, 0, 0, 0);
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
        bfaf.a((Context)localObject4, localImageView, (String)localObject2, 40.0F, bool1);
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
            bcef.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800AFC3", "0X800AFC3", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt), String.valueOf(((oidb_0xe83.AppInfo)localObject2).appid.get()), String.valueOf(((oidb_0xe83.AppInfo)localObject2).appid.get()) + "-" + String.valueOf(i3 + 1), "");
          }
          i3 += 1;
        }
        localObject1 = localView.findViewById(2131379105);
        break label448;
        localObject1 = localView.findViewById(2131379106);
        break label448;
        localObject1 = localView.findViewById(2131379107);
        break label448;
        localObject1 = localView.findViewById(2131379108);
        break label448;
        localObject1 = localView.findViewById(2131379109);
        break label448;
        localObject1 = localView.findViewById(2131379110);
        break label448;
        localObject1 = localView.findViewById(2131379111);
        break label448;
        localObject1 = localView.findViewById(2131379112);
        break label448;
        localObject1 = localView.findViewById(2131379113);
        break label448;
        ((View)localObject1).setVisibility(4);
        break;
        label1142:
        if (i3 > 0)
        {
          ((TextView)localObject4).setVisibility(0);
          ((TextView)localObject4).setText(String.valueOf(i3));
          ((TextView)localObject4).setBackgroundResource(2130850325);
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
    bede localbede;
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
      localObject = (bedt)this.app.getManager(231);
      localbede = ((bedt)localObject).a();
    } while (localbede == null);
    if (localbede.b > 0)
    {
      localFormSimpleItem.setRightText(localbede.jdField_a_of_type_JavaLangString);
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    Object localObject = ((bedt)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (localObject != null)
    {
      if (((bedf)localObject).jdField_a_of_type_Int == 0)
      {
        localFormSimpleItem.setRightText(amtj.a(2131700888));
        return;
      }
      localFormSimpleItem.setRightText(((bedf)localObject).jdField_a_of_type_JavaLangString);
      return;
    }
    localFormSimpleItem.setRightText(amtj.a(2131700896));
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
      nor.a(this.app, 69);
    }
    return bool2;
  }
  
  protected void b()
  {
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext())) {}
    anca localanca;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "initNetworkRequests");
      }
      localanca = (anca)this.app.getBusinessHandler(20);
      ArrayList localArrayList;
      if (localanca != null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        localanca.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, localArrayList);
      }
      if (localanca != null)
      {
        m();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
          localanca.a(localArrayList);
          localanca.i(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
      this.jdField_a_of_type_Nqt = new nqt(this.app);
      E();
    } while (localanca == null);
    localanca.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false, this.jdField_j_of_type_Int, 1);
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
      localTextView = (TextView)paramView.findViewById(2131378707);
      paramView = paramView.findViewById(2131376413);
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
        ((View)localObject).setTag(2131378207, str3);
        ((View)localObject).setTag(2131378176, localTabInfo);
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
            bftc.a("Grp_set", "Grp_aio_subscription", "subscription_exp", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) });
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839445);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131298049));
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext())) {
      QQToast.a(getApplicationContext(), 1, getString(2131694064), 1).b(getTitleBarHeight());
    }
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adau(this);
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
          this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + amtj.a(2131700897));
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
    localObject = (TextView)((View)localObject).findViewById(2131379220);
    ((TextView)localObject).setTag(Integer.valueOf(39));
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i1 = 0;
    }
    if (i1 > 0)
    {
      String str = String.format(getResources().getString(2131693113), new Object[] { Integer.valueOf(i1) });
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
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      String str = bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      if (paramInt2 == -1) {}
      for (paramIntent = "0";; paramIntent = "1")
      {
        bftc.a("Grp_share", "grpData_admin", "share_qzone", 0, 0, new String[] { localObject, str, paramIntent });
        return;
      }
      if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("select_member_add_request_ok", false)))
      {
        this.t = true;
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
          ((anca)this.app.getBusinessHandler(20)).g(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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
                  paramIntent = (bedt)this.app.getManager(231);
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
                      for (paramIntent = getResources().getString(2131695684);; paramIntent = getResources().getString(2131695685))
                      {
                        ((FormSimpleItem)localObject).setRightText(paramIntent);
                        return;
                      }
                      if ((paramInt2 == -1) && (paramIntent != null))
                      {
                        if (!NetworkUtil.isNetworkAvailable(this))
                        {
                          QQToast.a(this, 1, 2131694065, 0).b(getTitleBarHeight());
                          return;
                        }
                        paramIntent = paramIntent.getStringExtra("result");
                        if ((!TextUtils.isEmpty(paramIntent)) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (!paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname)))
                        {
                          localObject = (amoo)this.app.getBusinessHandler(22);
                          bool1 = bool2;
                          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
                          {
                            bool1 = bool2;
                            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1) {
                              bool1 = true;
                            }
                          }
                          ((amoo)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramIntent, bool1);
                          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetTroopHead())) {
                            this.jdField_e_of_type_Boolean = true;
                          }
                          this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.oldTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname;
                          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramIntent;
                          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName();
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
      TroopUtils.checkApiState(this.app, getApplicationContext(), this.jdField_d_of_type_JavaLangString, this, 0, null);
      this.jdField_h_of_type_JavaLangString = getIntent().getStringExtra("guild_id");
      this.jdField_i_of_type_JavaLangString = getIntent().getStringExtra("zone_id");
      this.jdField_j_of_type_JavaLangString = getIntent().getStringExtra("role_id");
      this.jdField_k_of_type_JavaLangString = getIntent().getStringExtra("gc");
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "joinGroup appid = " + this.jdField_d_of_type_JavaLangString + " openid = " + this.jdField_e_of_type_JavaLangString + " guild id = " + this.jdField_h_of_type_JavaLangString + "zone_id = " + this.jdField_i_of_type_JavaLangString + " role id = " + this.jdField_j_of_type_JavaLangString + "  group code= " + this.jdField_k_of_type_JavaLangString);
      }
      paramBundle = String.valueOf(this.jdField_d_of_type_JavaLangString);
      if ((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) || (this.jdField_f_of_type_JavaLangString.equals(this.app.getAccount()))) {
        break label401;
      }
      s();
      label313:
      if (!QLog.isColorLevel()) {
        break label1199;
      }
    }
    label401:
    label1199:
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
        if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          break label313;
        }
        localObject = this.app.getMsgHandler().a(paramBundle);
        if (localObject == null)
        {
          o();
          this.jdField_b_of_type_AndroidOsHandler = new Handler();
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(new ChatSettingForTroop.2(this), 3000L);
          this.app.addObserver(this.jdField_a_of_type_Npj);
          this.app.getMsgHandler().d(paramBundle);
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
            TroopUtils.checkIsShowCacheAppInfos(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaUtilArrayList);
          }
          this.jdField_a_of_type_Bfyq = ((bfyq)this.app.getManager(31));
          a();
          a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
          if (!b()) {
            z();
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
            nor.a(this.app, 65);
            paramBundle = new IntentFilter();
            paramBundle.addAction("start_recomend_page");
            paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            paramBundle.addAction("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER");
            registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
            addObserver(this.jdField_d_of_type_Andd);
            addObserver(this.jdField_c_of_type_Andd);
            TroopUtils.preloadWebProcess(this.app);
            this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(52));
            paramBundle = (TroopManager)this.app.getManager(52);
            if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null))
            {
              paramBundle = paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              if ((paramBundle != null) && (paramBundle.isGameBind())) {
                bftc.a("Grp_game", "Grp_data", "data_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
              }
            }
            this.app.addObserver(this.jdField_a_of_type_Bggc);
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_1", "", 1, 0, 0, "", "", "");
            bcef.b(this.app, "dc00898", "", "", "0X800A523", "0X800A523", 0, 0, "", "", "", "");
            bcef.b(this.app, "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_exp", 0, 0, "", "", "", "");
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
            {
              boolean bool = bfun.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
              paramBundle = (bdnn)apub.a().a(664);
              localObject = (anca)this.app.getBusinessHandler(20);
              if ((paramBundle != null) && (paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) && (localObject != null) && (bool)) {
                ((anca)localObject).z(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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
    //   1: getfield 2165	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   4: ifnull +14 -> 18
    //   7: aload_0
    //   8: getfield 2165	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   11: invokevirtual 3334	android/widget/Button:getBackground	()Landroid/graphics/drawable/Drawable;
    //   14: aconst_null
    //   15: invokevirtual 3337	android/graphics/drawable/Drawable:setColorFilter	(Landroid/graphics/ColorFilter;)V
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 3339	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_f_of_type_Boolean	Z
    //   23: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +385 -> 411
    //   29: invokestatic 644	java/lang/System:currentTimeMillis	()J
    //   32: lstore_1
    //   33: ldc 2
    //   35: monitorenter
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 2798	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Boolean	Z
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: getfield 975	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder	Lcom/tencent/mobileqq/app/face/FaceDecoder;
    //   48: ifnull +10 -> 58
    //   51: aload_0
    //   52: getfield 975	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder	Lcom/tencent/mobileqq/app/face/FaceDecoder;
    //   55: invokevirtual 3342	com/tencent/mobileqq/app/face/FaceDecoder:destory	()V
    //   58: aload_0
    //   59: getfield 1001	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bffq	Lbffq;
    //   62: ifnull +10 -> 72
    //   65: aload_0
    //   66: getfield 1001	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bffq	Lbffq;
    //   69: invokevirtual 3343	bffq:a	()V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 221	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Npj	Lnpj;
    //   77: invokevirtual 3346	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 204	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Amsu	Lamsu;
    //   85: invokevirtual 3346	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 209	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Amop	Lamop;
    //   93: invokevirtual 3346	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 194	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_Andd	Landd;
    //   101: invokevirtual 3346	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 189	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Andd	Landd;
    //   109: invokevirtual 3346	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   112: aload_0
    //   113: aload_0
    //   114: getfield 146	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Andd	Landd;
    //   117: invokevirtual 3346	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   120: aload_0
    //   121: aload_0
    //   122: getfield 199	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Andd	Landd;
    //   125: invokevirtual 3346	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   128: aload_0
    //   129: getfield 310	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   132: aload_0
    //   133: getfield 231	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bggc	Lbggc;
    //   136: invokevirtual 3347	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   139: aload_0
    //   140: getfield 184	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   143: ifnull +11 -> 154
    //   146: aload_0
    //   147: getfield 184	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   150: aconst_null
    //   151: invokevirtual 3350	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   154: aload_0
    //   155: getfield 2944	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   158: ifnull +30 -> 188
    //   161: aload_0
    //   162: getfield 2944	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   165: checkcast 2953	android/graphics/drawable/Animatable
    //   168: invokeinterface 3353 1 0
    //   173: ifeq +15 -> 188
    //   176: aload_0
    //   177: getfield 2944	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   180: checkcast 2953	android/graphics/drawable/Animatable
    //   183: invokeinterface 3356 1 0
    //   188: aload_0
    //   189: invokestatic 3361	bfkc:a	(Landroid/content/Context;)Lbfkc;
    //   192: invokevirtual 3362	bfkc:a	()V
    //   195: aload_0
    //   196: getfield 3364	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bhht	Lbhht;
    //   199: ifnull +10 -> 209
    //   202: aload_0
    //   203: getfield 3364	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bhht	Lbhht;
    //   206: invokevirtual 3367	bhht:dismiss	()V
    //   209: aload_0
    //   210: getfield 473	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Nqt	Lnqt;
    //   213: ifnull +10 -> 223
    //   216: aload_0
    //   217: getfield 473	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Nqt	Lnqt;
    //   220: invokevirtual 3368	nqt:a	()V
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 155	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   228: invokevirtual 3372	com/tencent/mobileqq/activity/ChatSettingForTroop:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   231: aload_0
    //   232: getfield 3203	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   235: ifnull +11 -> 246
    //   238: aload_0
    //   239: getfield 3203	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   242: aconst_null
    //   243: invokevirtual 3350	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   246: aload_0
    //   247: aconst_null
    //   248: putfield 3374	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   251: aload_0
    //   252: getfield 2173	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView	Lcom/tencent/mobileqq/widget/QQBlurView;
    //   255: ifnull +10 -> 265
    //   258: aload_0
    //   259: getfield 2173	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView	Lcom/tencent/mobileqq/widget/QQBlurView;
    //   262: invokevirtual 3376	com/tencent/mobileqq/widget/QQBlurView:c	()V
    //   265: aload_0
    //   266: getfield 3378	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bflj	Lbflj;
    //   269: ifnull +10 -> 279
    //   272: aload_0
    //   273: getfield 3378	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bflj	Lbflj;
    //   276: invokevirtual 3381	bflj:e	()V
    //   279: aload_0
    //   280: invokespecial 555	com/tencent/mobileqq/activity/ChatSettingForTroop:H	()V
    //   283: aload_0
    //   284: invokespecial 3383	com/tencent/mobileqq/app/BaseActivity:doOnDestroy	()V
    //   287: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq +34 -> 324
    //   293: ldc_w 282
    //   296: iconst_2
    //   297: new 284	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 3385
    //   307: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokestatic 644	java/lang/System:currentTimeMillis	()J
    //   313: lload_1
    //   314: lsub
    //   315: invokevirtual 952	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   318: invokevirtual 301	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 709	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: return
    //   325: astore_3
    //   326: ldc 2
    //   328: monitorexit
    //   329: aload_3
    //   330: athrow
    //   331: astore_3
    //   332: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq -104 -> 231
    //   338: ldc_w 282
    //   341: iconst_2
    //   342: new 284	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 3387
    //   352: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_3
    //   356: invokevirtual 3388	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   359: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 301	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 1345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: goto -137 -> 231
    //   371: astore_3
    //   372: invokestatic 280	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq -144 -> 231
    //   378: ldc_w 282
    //   381: iconst_2
    //   382: new 284	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   389: ldc_w 3387
    //   392: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_3
    //   396: invokevirtual 3389	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   399: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 301	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 1345	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
      anca localanca = (anca)this.app.getBusinessHandler(20);
      Object localObject;
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_k_of_type_Boolean = false;
        String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        String str2 = bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
        {
          localObject = "1";
          label144:
          bftc.a("Grp_set_new", "grpData_admin", "exp", 0, 0, new String[] { str1, str2, localObject });
          label177:
          if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (!bezm.a(this.app))) {}
        }
      }
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (localanca != null) {
          localanca.g(l1);
        }
        if (this.s)
        {
          i(true);
          this.s = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
        P();
        N();
        bcef.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F6", 0, 1, 0, "", "", "", "");
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[40] != null) {
          w();
        }
        u();
        v();
        return;
        i1 = 0;
        continue;
        localObject = "0";
        break label144;
        localObject = (bfaa)this.app.getManager(109);
        if ((localObject != null) && (((bfaa)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) && (localanca != null)) {
          localanca.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true, this.jdField_j_of_type_Int, 1);
        }
        if (!this.r) {
          break label177;
        }
        m();
        this.r = false;
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
      addObserver(this.jdField_a_of_type_Amsu);
      addObserver(this.jdField_a_of_type_Amop);
      addObserver(this.jdField_a_of_type_Andd);
      addObserver(this.jdField_b_of_type_Andd);
      addObserver(this.jdField_c_of_type_Andd);
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
      removeObserver(this.jdField_a_of_type_Amsu);
      removeObserver(this.jdField_a_of_type_Amop);
      removeObserver(this.jdField_b_of_type_Andd);
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
        StringBuilder localStringBuilder = new StringBuilder().append(amtj.a(2131700881)).append(str);
        if (!bool) {
          break label259;
        }
        localObject = amtj.a(2131700870);
        label85:
        localView.setContentDescription((String)localObject);
      }
      a(localView, new bczs(str, 32).a(), null, null);
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
      str = amtj.a(2131700898);
    }
    label259:
    label266:
    for (;;)
    {
      ((TextView)localObject).setText(str);
      if (AppSetting.jdField_c_of_type_Boolean) {
        ((View)localObject).setContentDescription(amtj.a(2131700865) + str);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateHostTroopNameEntry %s", new Object[] { str }));
      }
      return;
      label249:
      str = amtj.a(2131700908);
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
        if (this.jdField_a_of_type_Bhhw == null) {
          this.jdField_a_of_type_Bhhw = new bhhw(this);
        }
        this.jdField_a_of_type_Bhhw.a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.isEmpty(paramIntent)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopOwner(paramIntent, this.app.getCurrentAccountUin());
        }
        X();
        F();
        if (this.jdField_a_of_type_Bhhw == null) {
          this.jdField_a_of_type_Bhhw = new bhhw(this);
        }
        this.jdField_a_of_type_Bhhw.a(1, str, 1000);
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
      if (this.jdField_a_of_type_Adcf == null)
      {
        this.jdField_a_of_type_Adcf = new adcf(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Adcf);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Adcf.notifyDataSetChanged();
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
      anca localanca = (anca)this.app.getBusinessHandler(20);
      if (localanca != null) {
        localanca.a(true, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, 6);
      }
      localSharedPreferences.edit().putLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, System.currentTimeMillis()).commit();
    }
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 5, null, false);
  }
  
  protected void h()
  {
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label199;
      }
      beyy.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "troopProfile");
      bcef.b(this.app, "P_CliOper", "Grp_edu", "", "Grp_data", "mbercard_Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    }
    for (;;)
    {
      bcef.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_modifydata", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      bftc.a("Grp_set_new", "grpData_admin", "clk_modifydata", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "group_nickname", "group_nickname_2", "", 1, 0, 0, "", "", "");
      return;
      i1 = 0;
      break;
      label199:
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick;
      Intent localIntent = new Intent(this, EditInfoActivity.class);
      localIntent.putExtra("edit_type", 0);
      localIntent.putExtra("title", getString(2131697040));
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
        bcef.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", (String)localObject, "");
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
      bcef.b(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
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
    bcef.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
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
    anca localanca = (anca)this.app.getBusinessHandler(20);
    if (localanca == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
          break label110;
        }
        localanca.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 1000L);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
          break label127;
        }
        localanca.c(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
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
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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
    e();
    L();
    q();
  }
  
  public void o()
  {
    try
    {
      if (this.jdField_a_of_type_Bhht == null)
      {
        this.jdField_a_of_type_Bhht = new bhht(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_Bhht.c(2131694279);
        this.jdField_a_of_type_Bhht.c(false);
      }
      this.jdField_a_of_type_Bhht.show();
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
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && ((localObject1 instanceof Integer))) {
        i1 = ((Integer)localObject1).intValue();
      }
    }
    Object localObject4;
    label418:
    Object localObject5;
    Object localObject6;
    Object localObject7;
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
        if ((aqgr.c().mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
        {
          bool = ancy.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
          {
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
            if (bool)
            {
              i1 = 15;
              localObject5 = VipUtils.a(0, i1).toString();
              localObject6 = amtj.a(2131700880);
              localObject7 = new adbc(this, bool);
              if (!bool) {
                break label524;
              }
              localObject1 = "0X800A57F";
              if (!bool) {
                break label532;
              }
              i1 = 1;
              VipUtils.a(this, (String)localObject4, (String)localObject5, (String)localObject6, (DialogInterface.OnClickListener)localObject7, (String)localObject1, i1, bool);
            }
          }
          for (;;)
          {
            bcef.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
            break;
            i1 = 8;
            break label418;
            localObject1 = "0X8009E38";
            break label458;
            i1 = 3;
            break label465;
            VipUtils.a(this, bool);
          }
        }
        J();
        continue;
        h();
        continue;
        i();
        a("Grp_Admin_data", "Clk_mber", "");
        bftc.a("Grp_set_new", "grpData_admin", "clk_mber", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        continue;
        g();
        bftc.a("Grp_set_new", "grpData_admin", "clk_invite_new", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        continue;
        localObject1 = paramView.getTag(2131378191);
        if ((localObject1 instanceof String))
        {
          localObject1 = (String)localObject1;
          if (((bfdm)this.app.getManager(203)).b((String)localObject1))
          {
            bezm.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject1);
          }
          else
          {
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("selfSet_leftViewText", getString(2131719220));
            ((Bundle)localObject4).putString("custom_leftbackbutton_name", getTitle().toString());
            aynd.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject1, 1, -1, (Bundle)localObject4);
            continue;
            localObject1 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
            localObject4 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
            ((Intent)localObject4).putExtra("url", (String)localObject1);
            startActivity((Intent)localObject4);
            bcef.b(this.app, "dc00899", "Grp_certified", "", "data", "clk_data", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
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
              bcef.b(this.app, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
              nor.a(this.app, 72);
              break;
            }
            G();
            bftc.a("Grp_msg", "grpData_admin", "Clk_msgSet", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            continue;
            ChatHistoryActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1001);
            bcef.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_chatrecord", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            bftc.a("Grp_set_new", "grpData_admin", "clk_chatRecord", 1, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            bcef.b(this.app, "dc00898", "", "", "0X800A0B8", "0X800A0B8", 0, 0, "", "", "", "");
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
            bftc.a("Grp_edu", "Grp_data", "teachermsg_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a((TroopMemberInfo)localObject1) });
            continue;
            QQToast.a(this, amtj.a(2131700874), 0).a();
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("extra.GROUP_UIN", this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
            EntryDebugFragment.a(this, (Bundle)localObject1);
          }
        }
      }
    case 1002: 
      d(false);
      if (this.jdField_h_of_type_Int == 2) {
        bcef.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      }
      i1 = getIntent().getIntExtra("extra_share_group_from", 0);
      if (i1 != 0) {
        xwa.a("story_grp", "clk_msg", i1, 0, new String[0]);
      }
      localObject1 = this.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
      for (i1 = 1;; i1 = 2)
      {
        bcef.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800A526", "0X800A526", i1, 0, TroopUtils.getExposureSourceReportVal() + "", "", "", "");
        break;
      }
    case 5: 
      label458:
      label465:
      TroopUtils.setRedPointSP("RED_POINT_KEY_TROOP_ADMIN");
      label524:
      label532:
      if (this.o) {
        TroopUtils.setRedPointSP("RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
      }
      if (this.p) {
        TroopUtils.setRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY" + this.app.getCurrentAccountUin());
      }
      TroopUtils.updateRedPoint(false, (TextView)paramView.findViewById(2131376413));
      localObject5 = new Intent();
      ((Intent)localObject5).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject5).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((Intent)localObject5).putExtra("forward_location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
      ((Intent)localObject5).putExtra("forward_latitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
      ((Intent)localObject5).putExtra("forward_longitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
      ((Intent)localObject5).putExtra("forward_cityid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId);
      ((Intent)localObject5).putExtra("troop_auth_submit_time", this.jdField_i_of_type_Int);
      ((Intent)localObject5).putExtra("leftViewText", getResources().getString(2131690707));
      ((Intent)localObject5).putExtra("key_qidian_private_troop", this.jdField_d_of_type_Boolean);
      ((Intent)localObject5).putExtra("key_is_update_before_805", TroopUtils.isUpdateBeforeSomeVersion(this, "8.0.5"));
      localObject1 = (bepr)this.app.getManager(346);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        ((Intent)localObject5).putExtra("key_support_troop_honor", ((bepr)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin));
      }
      break;
    }
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop();; bool = false)
    {
      label2676:
      long l1;
      for (;;)
      {
        ((Intent)localObject5).putExtra("key_customed_troop", bool);
        if (bool) {
          abet.a(null, "846", "205605", "", "84601", "1", "145");
        }
        localObject4 = this.jdField_a_of_type_Aqdn;
        localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = aqdo.a();
          this.jdField_a_of_type_Aqdn = ((aqdn)localObject1);
        }
        ((Intent)localObject5).putExtra("autoApprovalUrl", ((aqdn)localObject1).jdField_b_of_type_JavaLangString);
        ((Intent)localObject5).putExtra("frequencyLimitVisible", ((aqdn)localObject1).jdField_a_of_type_Boolean);
        ((Intent)localObject5).putExtra("key_is_need_update_Group_info", true);
        if ((QLog.isDevelopLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)) {
          QLog.i("TroopMngTest", 4, String.format("start troop mng [flag: %s, msgLimitFreq: %s]", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupFlagExt3 & 0x100000), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.nMsgLimitFreq) }));
        }
        ((Intent)localObject5).putExtra("troop_manager_edit_red_show", c());
        ((Intent)localObject5).putExtra("troop_manager_edit_current_uin", this.app.getCurrentUin());
        localObject1 = TroopBaseProxyActivity.a(this);
        localObject4 = new bkxl(this.app);
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
          bcef.b((QQAppInterface)localObject4, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, (String)localObject5, (String)localObject1, "", "");
          bftc.a("Grp_set_new", "grpData_admin", "clk_manageGrp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
          break;
        }
        bcef.b(this.app, "P_CliOper", "Grp_payjoin", "", "join_grp", "Clk_data", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
        aiku.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "");
        bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
        break;
        TroopUtils.joinGroupOneStep(this.app, this, getIntent(), this);
        bcef.b(this.app, "CliOper", "", "", "0x80084B4", "0x80084B4", 0, 0, "", "", "", "");
        bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
        break;
        localObject1 = this.app;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
        for (i1 = 1;; i1 = 2)
        {
          bcef.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800A527", "0X800A527", i1, 0, TroopUtils.getExposureSourceReportVal() + "", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 34) {
            break label2712;
          }
          if (!arhi.a(this.app.getCurrentAccountUin())) {
            break label2676;
          }
          localObject1 = arpf.a(this);
          if (!isFinishing())
          {
            ((Dialog)localObject1).show();
            bcef.b(this.app, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
          }
          break;
        }
        bcef.b(this.app, "dc00898", "", "", "0X80092D7", "0X80092D7", 0, 0, "", "", "", "");
        label2712:
        TroopUtils.secRecognize(false, null);
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
        TroopUtils.calJoinTroop(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, TroopUtils.mExposureSource, this.jdField_l_of_type_Int, 2);
        if (!NetworkUtil.isNetSupport(this))
        {
          a(2131694062, 1);
          break;
        }
        localObject1 = (anca)this.app.getBusinessHandler(20);
        if (localObject1 != null) {}
        try
        {
          l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          o();
          ((anca)localObject1).a(l1, 8390784);
          if (super.getIntent().getBooleanExtra("from_babyq", false)) {
            bcef.b(this.app, "dc00898", "", "", "0X8007246", "0X8007246", 0, 0, "", "", "", "");
          }
          bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
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
      j();
      break;
      TroopUtils.startChatBackgroundSettingActivity(this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 6);
      bcef.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
      bcef.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Set_chatBG", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      bftc.a("Grp_set_new", "grpData_admin", "set_chatBG", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      break;
      localObject4 = (bgjx)((FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[40]).getTag(2131374805);
      if (localObject4 != null)
      {
        l1 = ((bgjx)localObject4).jdField_a_of_type_Long;
        ((bgjx)localObject4).jdField_a_of_type_Long = SystemClock.uptimeMillis();
        if (((bgjx)localObject4).jdField_a_of_type_Long < l1 + 1000L) {
          break;
        }
        bgov.a(this.app, "troop_keyword_expire_list_" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, ((bgjx)localObject4).jdField_b_of_type_JavaLangString);
        bgov.b(this.app, "troop_keyword_guide_clicked", true);
        localObject2 = bgev.a("groupkeywords").replace("[groupid]", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop.troop.special_msg.keyword", 2, "onClick: " + (String)localObject2);
        }
        bcef.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F8", ((bgjx)localObject4).jdField_c_of_type_Int, 1, 0, "", "", "", "");
        localObject4 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject4).putExtra("url", (String)localObject2);
        ((Intent)localObject4).putExtra("isShowAd", false);
        startActivity((Intent)localObject4);
        break;
      }
      QLog.e("Q.chatopttroop.troop.special_msg.keyword", 1, "onClick status is null");
      break;
      localObject4 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject4).putExtra("big_brother_source_key", "biz_src_jc_vip");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {}
      for (Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;; localObject2 = "")
      {
        ((Intent)localObject4).putExtra("url", bkjs.a((String)localObject2));
        startActivity((Intent)localObject4);
        break;
      }
      localObject2 = new Intent(this, QQBrowserActivity.class);
      localObject4 = bgev.a("troopEnterEffect");
      ((Intent)localObject2).putExtra("url", (String)localObject4 + "&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      startActivityForResult((Intent)localObject2, 15);
      bedt.a("grp_data", "entry_clk", new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      i1 = ((bedt)this.app.getManager(231)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "style", "0X8008E62", "", 1, 0, 0, "", Integer.toString(i1), "");
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin != null)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
      }
      localObject2 = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
      ((Bundle)localObject2).putBoolean("troop_info_from_troopsetting", true);
      ((Bundle)localObject2).putInt("exposureSource", 1);
      TroopUtils.openTroopInfoActivity(this, (Bundle)localObject2, 2);
      localObject2 = this.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
      for (i1 = 1;; i1 = 2)
      {
        bcef.b((QQAppInterface)localObject2, "dc00898", "", "", "0X800A524", "0X800A524", i1, 0, "", "", "", "");
        break;
      }
      localObject2 = new bhdb(this, this.app, false);
      ((bhdb)localObject2).a(new adbd(this));
      ((bhdb)localObject2).a(2);
      bftc.a("Grp_set_new", "grpData_admin", "clk_delRecord", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      break;
      localObject4 = paramView.getTag(2131378207);
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "troop app item click type=" + paramView.getId() + ", url=" + localObject4);
      }
      localObject5 = (oidb_0xe83.TabInfo)paramView.getTag(2131378176);
      if (TroopUtils.checkIsReadInJoySubscribe(paramView, (oidb_0xe83.TabInfo)localObject5))
      {
        localObject2 = null;
        if (((oidb_0xe83.TabInfo)localObject5).red_point.get() != 0)
        {
          localObject2 = (String)paramView.getTag(2131378200);
          label3892:
          okj.a(this, (String)localObject2, 2);
          label3899:
          if ((localObject5 != null) && (((oidb_0xe83.TabInfo)localObject5).red_point.get() != 0)) {
            if ((paramView instanceof TroopAppFormItem))
            {
              localObject2 = (TroopAppFormItem)paramView;
              if (((oidb_0xe83.TabInfo)localObject5).appid.get() != 1106837471L) {
                break label4325;
              }
              ((TroopAppFormItem)localObject2).d();
            }
          }
        }
      }
      for (;;)
      {
        ((anca)this.app.getBusinessHandler(20)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, ((oidb_0xe83.TabInfo)localObject5).appid.get());
        ((oidb_0xe83.TabInfo)localObject5).red_point.set(0);
        TroopUtils.clearTabListRedDot(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, ((oidb_0xe83.TabInfo)localObject5).appid.get());
        if (i1 != 30) {
          break label4333;
        }
        bfdg.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1106611799);
        this.jdField_j_of_type_Int = ((int)NetConnInfoCenter.getServerTime());
        ThreadManager.post(new ChatSettingForTroop.27(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 5, null, false);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(19);
        bftc.a("Grp_game", "Grp_data", "feeds_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        break;
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label3892;
        }
        localObject2 = "{\"tags\":" + this.jdField_a_of_type_JavaLangString + "}";
        break label3892;
        localObject2 = localObject4;
        if (localObject5 != null)
        {
          localObject2 = localObject4;
          if (((oidb_0xe83.TabInfo)localObject5).appid.get() == 1106837471L) {
            localObject2 = (String)paramView.getTag(2131378200);
          }
        }
        if ((!(localObject2 instanceof String)) || (TextUtils.isEmpty((String)localObject2))) {
          break label3899;
        }
        localObject4 = new Bundle();
        ((Bundle)localObject4).putString("uin", this.app.getCurrentAccountUin());
        ((Bundle)localObject4).putString("gc", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        ((Bundle)localObject4).putBoolean("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        if (avsc.a(this, (String)localObject2, (Bundle)localObject4))
        {
          if (!QLog.isColorLevel()) {
            break label3899;
          }
          QLog.d("Q.chatopttroop", 2, "mini app jump handled");
          break label3899;
        }
        localObject4 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject4).putExtra("url", (String)localObject2);
        startActivity((Intent)localObject4);
        break label3899;
        label4325:
        ((TroopAppFormItem)localObject2).c();
      }
      label4333:
      if (i1 == 29)
      {
        bftc.a("Grp_game", "Grp_data", "rank_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        break;
      }
      if ((i1 != 1007) || (localObject5 == null) || (((oidb_0xe83.TabInfo)localObject5).appid.get() != 1106837471L)) {
        break;
      }
      bftc.a("Grp_set", "Grp_aio_subscription", "subscription_clk", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) });
      break;
      if (this.n)
      {
        bezm.a(this.app, false);
        this.jdField_a_of_type_Bffq.a(false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "setRobotItemRedDotShowed");
        }
      }
      bcef.b(this.app, "dc00898", "", "", "", "0X8009F9C", 0, 0, "", "", "", "");
      TroopUtils.jumpRobotPage(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1))
      {
        i1 = 1;
        label4557:
        if ((i1 == 0) || (!aqgr.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
          break label4751;
        }
        bool = ancy.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label4742;
        }
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!bool) {
          break label4728;
        }
        i1 = 15;
        label4630:
        localObject5 = VipUtils.a(0, i1).toString();
        localObject6 = amtj.a(2131700867);
        localObject7 = new adbe(this, bool);
        if (!bool) {
          break label4734;
        }
        localObject2 = "0X800A57F";
        label4670:
        VipUtils.a(this, (String)localObject4, (String)localObject5, (String)localObject6, (DialogInterface.OnClickListener)localObject7, (String)localObject2, 1, bool);
      }
      for (;;)
      {
        bcef.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 1, 0, "", "", "", "");
        break;
        i1 = 0;
        break label4557;
        label4728:
        i1 = 8;
        break label4630;
        label4734:
        localObject2 = "0X8009E38";
        break label4670;
        label4742:
        VipUtils.a(this, bool);
      }
      label4751:
      label4770:
      int i2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
        localObject4 = localObject2;
        if (localObject2 == null) {
          localObject4 = "";
        }
        if ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
          break label5075;
        }
        i2 = 1;
        label4803:
        localObject5 = new Intent(this, EditInfoActivity.class);
        ((Intent)localObject5).putExtra("edit_type", 2);
        if (i1 == 0) {
          break label5080;
        }
        localObject2 = amtj.a(2131700886);
        label4838:
        ((Intent)localObject5).putExtra("title", (String)localObject2);
        ((Intent)localObject5).putExtra("default_text", (String)localObject4);
        ((Intent)localObject5).putExtra("max_num", 96);
        ((Intent)localObject5).putExtra("canPostNull", false);
        if (i1 == 0) {
          break label5091;
        }
        localObject2 = amtj.a(2131700871);
        label4893:
        ((Intent)localObject5).putExtra("right_btn", (String)localObject2);
        ((Intent)localObject5).putExtra("isTroopName", true);
        if (i1 == 0) {
          break label5099;
        }
        bool = true;
        label4921:
        ((Intent)localObject5).putExtra("edit_mode", bool);
        if (i2 == 0) {
          break label5105;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        label4945:
        ((Intent)localObject5).putExtra("troopUin", (String)localObject2);
        startActivityForResult((Intent)localObject5, 16);
        bftc.a("Grp_set_new", "grpData_admin", "clk_editInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        localObject4 = this.app;
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label5113;
        }
        localObject2 = "0";
      }
      for (;;)
      {
        bcef.b((QQAppInterface)localObject4, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_name", 0, 0, (String)localObject5, "0", (String)localObject2, "");
        break;
        localObject2 = "";
        break label4770;
        label5075:
        i2 = 0;
        break label4803;
        label5080:
        localObject2 = amtj.a(2131700885);
        break label4838;
        label5091:
        localObject2 = "";
        break label4893;
        label5099:
        bool = false;
        break label4921;
        label5105:
        localObject2 = "";
        break label4945;
        label5113:
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          localObject2 = "1";
        } else {
          localObject2 = "2";
        }
      }
      try
      {
        if (this.jdField_a_of_type_Bflj != null) {
          this.jdField_a_of_type_Bflj.e();
        }
        this.jdField_a_of_type_Bflj = new bflj(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        this.jdField_a_of_type_Bflj.f();
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
        bcef.b((QQAppInterface)localObject4, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_num", 0, 0, (String)localObject5, "0", (String)localObject2, "");
        break;
      }
      Object localObject3 = bfcx.a().a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 1);
      localObject4 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject4).putExtra("url", (String)localObject3);
      startActivity((Intent)localObject4);
      bcef.b(null, "dc00898", "", "", "0X800A6EF", "0X800A6EF", 0, 0, "", "", "", "");
      break;
      localObject3 = (bdct)this.app.getManager(339);
      bool = ((bdct)localObject3).a(4, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject4 = bddg.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      if (bool) {
        ((bdct)localObject3).b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 4, 2, (Bundle)localObject4);
      }
      for (;;)
      {
        bddg.a(this.app, "SP_KEY_SING_TOGETHER_TROOP_RED_DOT_SHOW", false, false);
        ((bdct)localObject3).a("sing_tab", "clk_setsing", 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        v();
        break;
        ((bdct)localObject3).a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 4, 2, (Bundle)localObject4);
      }
      localObject3 = (aqde)apub.a().a(535);
      if ((localObject3 == null) || (((aqde)localObject3).jdField_a_of_type_Aqea == null))
      {
        QQToast.a(this, 0, 2131692889, 0).a();
        break;
      }
      localObject4 = (bdct)this.app.getManager(339);
      bool = ((bdct)localObject4).a(2, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject5 = bddg.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      switch (((aqde)localObject3).jdField_a_of_type_Aqea.a())
      {
      default: 
        if (((bdct)localObject4).a(this, 2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2)) {
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(2) });
          }
        }
        break;
      }
      for (;;)
      {
        bddg.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_RED_DOT_SHOW", false, false);
        u();
        break;
        QQToast.a(this, 0, 2131692889, 0).a();
        continue;
        if (bool)
        {
          ((bdct)localObject4).b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject5);
        }
        else
        {
          ((bdct)localObject4).a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject5);
          continue;
          ((bdct)localObject4).a("video_tab", "clk_setvideo", 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          bddg.a(this.app, ((aqde)localObject3).jdField_a_of_type_Aqea.b(), ((aqde)localObject3).jdField_a_of_type_Aqea.a(), ((aqde)localObject3).jdField_a_of_type_Aqea.b(), (Bundle)localObject5, 1);
        }
      }
      if (this.jdField_a_of_type_Bflj != null) {
        this.jdField_a_of_type_Bflj.e();
      }
      this.jdField_a_of_type_Bflj = TroopUtils.shareTroop(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app);
      localObject3 = this.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
      for (i1 = 1;; i1 = 2)
      {
        bcef.b((QQAppInterface)localObject3, "dc00898", "", "", "0X800A525", "0X800A525", i1, 0, TroopUtils.getExposureSourceReportVal() + "", "", "", "");
        break;
      }
      if (bfun.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false))
      {
        bfdg.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 101890494);
        bfun.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false, "");
        localObject3 = this.jdField_a_of_type_ArrayOfAndroidViewView[42];
        if (localObject3 != null)
        {
          localObject3 = (TextView)((View)localObject3).findViewById(2131376413);
          if (localObject3 != null)
          {
            ((TextView)localObject3).setText("");
            TroopUtils.updateRedPoint(false, (TextView)localObject3);
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        localObject3 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", "https://qun.qq.com/active/rank/index?gc={groupcode}&_wwv=128".replace("{groupcode}", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
        startActivity((Intent)localObject3);
      }
      bcef.b(this.app, "dc00898", "", "", "0X800B2F1", "0X800B2F1", 0, 0, "", "", "", "");
      break;
      this.s = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
        bdvm.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      TroopUtils.setRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION");
      TroopUtils.updateRedPoint(false, (TextView)paramView.findViewById(2131376413));
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
        break;
      }
      bcef.b(this.app, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0X800B4AE", "0X800B4AE", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt), "", "", "");
      break;
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
      if ((localObject != null) && ((localObject instanceof adef)))
      {
        localObject = (adef)localObject;
        if (paramString != null) {
          break label129;
        }
        a((adef)localObject, null, false);
      }
    }
    label129:
    while (!paramString.equals(((adef)localObject).jdField_a_of_type_JavaLangString))
    {
      paramInt1 += 1;
      break label72;
      break;
    }
    ((adef)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void p()
  {
    try
    {
      if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
        this.jdField_a_of_type_Bhht.dismiss();
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
  
  public void r()
  {
    Context localContext = getApplicationContext();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      String str = Long.toString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
      bfkc.a(localContext).a(str, null);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131694768);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131691966);
    adbv localadbv = new adbv(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690620, localadbv);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131694742, localadbv);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import aact;
import ackm;
import ackn;
import acko;
import ackq;
import ackr;
import acks;
import ackt;
import acku;
import ackv;
import ackw;
import ackx;
import acky;
import ackz;
import acla;
import aclb;
import aclc;
import acld;
import acle;
import aclf;
import aclg;
import acli;
import aclj;
import aclk;
import acll;
import aclm;
import aclo;
import aclq;
import aclr;
import acls;
import aclt;
import aclw;
import aclx;
import acly;
import aclz;
import acma;
import acmb;
import acqa;
import adky;
import aekt;
import ahla;
import alkk;
import alkl;
import alox;
import alpo;
import alzf;
import alzw;
import amab;
import amev;
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
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import aogj;
import aone;
import aonf;
import aono;
import aonu;
import aonv;
import aooh;
import aoql;
import apwx;
import aqdo;
import auak;
import aubr;
import awnk;
import azgq;
import azib;
import azmj;
import bahs;
import baig;
import baiq;
import baky;
import ball;
import bbps;
import bbpt;
import bbqh;
import bcbt;
import bceb;
import bcee;
import bcef;
import bcgk;
import bcgo;
import bcgx;
import bchl;
import bckj;
import bckr;
import bckx;
import bclo;
import bcnc;
import bcru;
import bcrv;
import bctc;
import bcws;
import bcwt;
import bdaj;
import bdbx;
import bdcd;
import bdco;
import bdda;
import bdee;
import bdfq;
import bdih;
import bdnm;
import bdox;
import bdqc;
import bdsm;
import bdsn;
import bdwk;
import beko;
import bepp;
import beps;
import beqa;
import bhpx;
import bhpy;
import bhql;
import bhyu;
import bjyi;
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
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
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
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.Switch;
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
import mwx;
import nco;
import ndm;
import nev;
import ney;
import nxu;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.AppInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.ExtraInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.ManageInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.TabInfo;
import wta;

public class ChatSettingForTroop
  extends BaseActivity
  implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener, bcgo, bcwt
{
  public static final ArrayList<Integer> a;
  public static String l;
  protected final int a;
  long jdField_a_of_type_Long = 0L;
  protected acmb a;
  alkl jdField_a_of_type_Alkl = new aclm(this);
  alox jdField_a_of_type_Alox = new aclg(this);
  amab jdField_a_of_type_Amab = new acld(this);
  protected BroadcastReceiver a;
  public Intent a;
  public Drawable a;
  public Handler a;
  protected DisplayMetrics a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new acko(this);
  public View.OnTouchListener a;
  protected View a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  public TextView a;
  public aonu a;
  private bcnc jdField_a_of_type_Bcnc;
  public bcru a;
  public bctc a;
  protected bcws a;
  public bdfq a;
  public bdih a;
  bdqc jdField_a_of_type_Bdqc = new aclw(this);
  protected bepp a;
  public beps a;
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
  protected ndm a;
  protected nev a;
  protected ney a;
  protected boolean a;
  public View[] a;
  public int b;
  amab jdField_b_of_type_Amab = new acle(this);
  public Handler b;
  protected View.OnClickListener b;
  protected View b;
  protected Button b;
  public ImageView b;
  protected TextView b;
  private bdfq jdField_b_of_type_Bdfq;
  protected Runnable b;
  public String b;
  protected ArrayList<TroopAppInfo> b;
  List<ImageView> jdField_b_of_type_JavaUtilList;
  public volatile boolean b;
  protected int c;
  amab jdField_c_of_type_Amab = new aclf(this);
  protected View c;
  public TextView c;
  protected String c;
  private ArrayList<Long> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  protected List<oidb_0x899.memberlist> c;
  public boolean c;
  protected int d;
  private amab d;
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
  private boolean s = true;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131378450));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131378451));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131378452));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131378453));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131378454));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131378455));
    jdField_l_of_type_JavaLangString = "http://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi";
  }
  
  public ChatSettingForTroop()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_Int = 5;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Amab = new ackm(this);
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aclk(this);
    this.jdField_a_of_type_JavaLangRunnable = new ChatSettingForTroop.12(this);
    this.jdField_a_of_type_Ney = new ackw(this);
    this.jdField_b_of_type_JavaLangRunnable = new ChatSettingForTroop.23(this);
    this.jdField_l_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new aclc(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aclo(this);
    this.jdField_a_of_type_Ndm = new acls(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new mwx();
  }
  
  private void A()
  {
    bhpy localbhpy = (bhpy)bhql.a(this, null);
    localbhpy.a(new bhpx(getString(2131696671), 34, 0), 5);
    localbhpy.a(new bhpx(bhql.a(this, 2131719217), 21, 0), 5);
    localbhpy.c(2131690648);
    localbhpy.a(new ackr(this, localbhpy));
    if (!localbhpy.isShowing()) {
      localbhpy.show();
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
      azmj.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Clk_quitgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (String)localObject, "", "");
      return;
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label179:
      D();
      break label107;
      label186:
      localObject = bhpy.a(this);
      ((bhpy)localObject).a(2131691103);
      ((bhpy)localObject).a(2131692277, 3);
      ((bhpy)localObject).a(new acks(this, (bhpy)localObject));
      ((bhpy)localObject).d(getString(2131690648));
      ((bhpy)localObject).show();
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
    Dialog localDialog = new Dialog(this, 2131755801);
    localDialog.setContentView(2131560888);
    ((TextView)localDialog.findViewById(2131365269)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131365258);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131365256);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131365262);
    String str = alpo.a(2131702105);
    localTextView1.setText(getString(2131691097, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694951);
    localTextView3.setText(2131690648);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new ackt(this, localDialog));
    localTextView3.setOnClickListener(new acku(this, localDialog));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void D()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop troopDisband");
    }
    getString(2131691862);
    String str = getString(2131691096);
    bhpy localbhpy = bhpy.a(this);
    localbhpy.a(str);
    localbhpy.a(getString(2131691095), 3);
    localbhpy.d(getString(2131690648));
    localbhpy.a(new ackv(this, localbhpy));
    localbhpy.show();
  }
  
  private void E()
  {
    alzf localalzf = (alzf)this.app.a(20);
    if (localalzf != null) {
      localalzf.a(alkk.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), true);
    }
    this.jdField_a_of_type_Nev.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_Ney);
  }
  
  private void F()
  {
    alzf localalzf = (alzf)this.app.a(20);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum <= 100) {
      localalzf.a(alkk.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 0L, 5, 100, 0);
    }
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {}
    do
    {
      return;
      localObject = (Boolean)this.jdField_a_of_type_Bdih.c.get(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
    } while ((localObject != null) && (((Boolean)localObject).booleanValue()));
    azmj.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "0", "");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
    }
    for (;;)
    {
      bhpy localbhpy = (bhpy)bhql.a(this, null);
      localbhpy.a(getString(2131720619, new Object[] { localObject }));
      localbhpy.a(getString(2131698081), false);
      localbhpy.a(getString(2131698077), false);
      localbhpy.a(getString(2131698073), false);
      int i1 = this.app.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
      switch (i1)
      {
      }
      for (;;)
      {
        localbhpy.c(2131690648);
        localbhpy.a(new ackx(this, i1, localbhpy));
        localbhpy.show();
        return;
        localbhpy.d(0);
        continue;
        localbhpy.d(1);
        continue;
        localbhpy.d(2);
      }
    }
  }
  
  private void H()
  {
    if ((this.jdField_b_of_type_Bdfq == null) || (this.jdField_b_of_type_Bdfq.isShowing())) {}
    try
    {
      this.jdField_b_of_type_Bdfq.dismiss();
      label24:
      this.jdField_b_of_type_Bdfq = null;
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
    this.jdField_b_of_type_Bdfq = bdcd.a(this, 230).setTitle(getString(2131698062));
    this.jdField_b_of_type_Bdfq.setPositiveButton(getString(2131698061), new aclb(this));
    try
    {
      this.jdField_b_of_type_Bdfq.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void J()
  {
    bdaj.a("Grp_set_new", "grpData_admin", "clk_notice", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), "8.3.3" });
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)))
    {
      I();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Aonu;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = aonv.a();
      this.jdField_a_of_type_Aonu = ((aonu)localObject1);
    }
    localObject1 = ((aonu)localObject1).jdField_a_of_type_JavaLangString;
    localObject2 = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", bclo.a((String)localObject1, 0L, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app, true));
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
      localObject2 = bclo.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        localObject1 = (String)localObject2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
      }
      ((ExpandableTextView)localView).setText(new baig((CharSequence)localObject1, 11, 16));
    }
    Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[37];
    if ((localObject2 != null) && ((localObject2 instanceof TextView))) {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
        break label156;
      }
    }
    label156:
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;; localObject1 = getString(2131696620))
    {
      ((TextView)localObject2).setText(new baig((CharSequence)localObject1, 11, 16));
      return;
    }
  }
  
  private void M()
  {
    o();
    ((alzf)this.app.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, null);
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
    for (int i1 = 2131166898;; i1 = 2131166604)
    {
      int i3 = getResources().getColor(i1);
      int i2 = 2130843278;
      i1 = i2;
      if (this.s)
      {
        i1 = i2;
        if (!bool) {
          i1 = 2130840101;
        }
      }
      Drawable localDrawable = getResources().getDrawable(2130849987);
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
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[12].findViewById(2131372949);
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
            if ((localObject2 == null) || (!(localObject2 instanceof oidb_0xaf4.AppInfo))) {
              break label383;
            }
            localObject2 = (oidb_0xaf4.AppInfo)localObject2;
            long l1 = -1000L;
            int i2 = -1000;
            if (((oidb_0xaf4.AppInfo)localObject2).push_red_point.has()) {
              i2 = ((oidb_0xaf4.AppInfo)localObject2).push_red_point.get();
            }
            if (((oidb_0xaf4.AppInfo)localObject2).appid.has()) {
              l1 = ((oidb_0xaf4.AppInfo)localObject2).appid.get();
            }
            if (l1 != 1L) {
              break label383;
            }
            boolean bool = bdbx.a(this.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
            if ((i2 != -1) && (!bool)) {
              break;
            }
          }
          for (i1 = 1;; i1 = 0)
          {
            localObject1 = (TextView)((View)localObject1).findViewById(2131362711);
            if (i1 == 0) {
              break label375;
            }
            ((TextView)localObject1).setVisibility(0);
            ((TextView)localObject1).setText("");
            ((TextView)localObject1).setBackgroundResource(0);
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130849728, 0, 0, 0);
            return;
            localObject1 = localView.findViewById(2131378264);
            break;
            localObject1 = localView.findViewById(2131378265);
            break;
            localObject1 = localView.findViewById(2131378266);
            break;
            localObject1 = localView.findViewById(2131378267);
            break;
            localObject1 = localView.findViewById(2131378268);
            break;
            localObject1 = localView.findViewById(2131378269);
            break;
            localObject1 = localView.findViewById(2131378270);
            break;
            localObject1 = localView.findViewById(2131378271);
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
      localFormSwitchItem.setText(getString(2131693301));
      localFormSwitchItem.a().setTextColor(getResources().getColor(2131166901));
      localFormSwitchItem.setFocusable(true);
      localFormSwitchItem.getBackground().setAlpha(255);
      localFormSwitchItem.setContentDescription(getString(2131693301));
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
      localFormSwitchItem.setContentDescription(getString(2131696685));
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
    if (this.jdField_a_of_type_Bcws != null)
    {
      localObject2 = this.jdField_a_of_type_Bcws.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_Bcws.a())
        {
          this.jdField_a_of_type_Bcws.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = bdda.a();
    }
    localObject1 = new BitmapDrawable((Bitmap)localObject2);
    if (ThemeUtil.isInNightMode(this.app)) {
      ((Drawable)localObject1).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    return localObject1;
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 1;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131721030);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131721035);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131721037);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 4;
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131721032);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 5;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopAuthen = getString(2131721031);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop()))
    {
      localObject = (alzf)this.app.a(20);
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
      if (!paramBoolean) {
        break label82;
      }
    }
    label82:
    for (int i1 = 1;; i1 = 0)
    {
      ((alzf)localObject).b(str, paramInt, i1);
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
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131692680));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", paramActivity.getString(2131696536));
    localIntent.putExtra("param_max", 100);
    if (!paramBoolean) {
      localIntent.putExtra("filer_robot", true);
    }
    localIntent.putExtra("param_entrance", 38);
    paramActivity.startActivityForResult(localIntent, 1);
  }
  
  private static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363369);
    paramView = (TextView)paramView.findViewById(2131375735);
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
    TextView localTextView = (TextView)paramView.findViewById(2131363369);
    paramView = (TextView)paramView.findViewById(2131375735);
    if (TextUtils.isEmpty(paramString))
    {
      localTextView.setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(getString(2131698063));
      return;
    }
    paramView.setVisibility(8);
    localTextView.setVisibility(0);
    localTextView.setText(paramString);
  }
  
  private void b(int paramInt)
  {
    if (!bdee.d(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_Beps == null) {
        this.jdField_a_of_type_Beps = new beps(this);
      }
      this.jdField_a_of_type_Beps.b(2, 2131694766, 1500);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
      return;
    }
    this.jdField_a_of_type_Bdih.b.clear();
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Integer.valueOf(paramInt));
    this.jdField_a_of_type_Bdih.c.put(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, Boolean.valueOf(true));
    if (!this.p)
    {
      SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      if (!localSharedPreferences.getBoolean("Change_Msg_Notify_Tips_Value", false))
      {
        this.p = true;
        localSharedPreferences.edit().putBoolean("Change_Msg_Notify_Tips_Value", true).commit();
        bdcd.a(this, getString(2131698072), 2131720083, 2131720083, new bdco(), null).show();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
    azmj.b(this.app, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
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
    byte[] arrayOfByte = ((aubr)this.app.getManager(37)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (arrayOfByte != null) {
      try
      {
        oidb_0xaf4.RspBody localRspBody = new oidb_0xaf4.RspBody();
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
    a(2131721045, 0);
  }
  
  private void c(List<oidb_0x899.memberlist> paramList)
  {
    alzf localalzf = (alzf)this.app.a(20);
    ArrayList localArrayList1 = new ArrayList();
    bckx localbckx = (bckx)this.app.getManager(203);
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
      } else if (localbckx.b(str)) {
        localArrayList1.add(localObject);
      } else if (bclo.b(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str)) {
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
      localObject = bclo.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, paramList);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label388;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.memberListToShow = ((String)localObject);
      localalzf.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramList, true, null);
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
          i1 = 2131699955;
        }
        for (;;)
        {
          a(25, 2, localView, getString(i1), "", true);
          localObject2 = new SpannableString((String)localObject1 + "PT[QR]");
          Object localObject3 = getResources().getDrawable(2130843423);
          ((Drawable)localObject3).setBounds(0, 0, azgq.a(18.0F), azgq.a(18.0F));
          if (ThemeUtil.isInNightMode(this.app)) {
            ((Drawable)localObject3).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
          }
          localObject3 = new acli(this, (Drawable)localObject3, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
          {
            QLog.e("vip_pretty.Q.chatopttroop", 1, "show the pretty troop icon :" + this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.groupFlagExt4);
            if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.checkFlagExt4(1)) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.checkFreezeReason(2)))
            {
              i1 = 1;
              if (i1 == 0) {
                break label453;
              }
              Drawable localDrawable = getResources().getDrawable(2130846412);
              localDrawable.setBounds(0, 0, azgq.a(40.0F), azgq.a(15.0F));
              ((SpannableString)localObject2).setSpan(new aclj(this, localDrawable, 0), ((String)localObject1).length(), ((String)localObject1).length() + 2, 17);
              ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length() + 2, ((String)localObject1).length() + 6, 17);
            }
          }
          for (;;)
          {
            paramBoolean = bool;
            if (!" ".equals(localObject1)) {
              paramBoolean = true;
            }
            bclo.a(localView, (CharSequence)localObject2, null, null, paramBoolean, (String)localObject1, alpo.a(2131691363), new acll(this));
            localView.setOnClickListener(this);
            return;
            if (paramBoolean) {
              break label475;
            }
            i1 = 2131699957;
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
      if (!bclo.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)) {
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
      bool1 = bclo.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, new boolean[] { bool1, bool4, bool5, i1, bool2, bool3 }, new int[] { 11, 12, 5, 4, 8, 6 });
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
    bcgk.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
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
      localIntent = aekt.a(localIntent, new int[] { 2 });
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
    azib.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
  }
  
  private void f(boolean paramBoolean)
  {
    alkk localalkk = (alkk)this.app.a(22);
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      if (!paramBoolean) {
        break label149;
      }
      i1 = 0;
      label45:
      if (!localalkk.a(str, i1)) {
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
      azmj.b(this.app, "dc00899", "Grp_set", "", "Grp_data", str, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      bdaj.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
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
    if (!bdee.d(BaseApplication.getContext()))
    {
      a(2131692397, 1);
      U();
      return;
    }
    if (paramBoolean) {
      amev.a(this.app).a(this);
    }
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      i1 = 1;
      int i3 = (int)NetConnInfoCenter.getServerTime();
      ((alzf)this.app.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, this.app.c(), i1, 512, i3);
      V();
      localQQAppInterface = this.app;
      if (!paramBoolean) {
        break label142;
      }
    }
    label142:
    for (int i1 = i2;; i1 = 2)
    {
      azmj.b(localQQAppInterface, "dc00898", "", "", "0X800A348", "0X800A348", 2, i1, "0", "0", "", "");
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
    if (bdee.a(this) == 0)
    {
      QQToast.a(this, 2131696667, 0).b(getTitleBarHeight());
      W();
      return;
    }
    ((alzf)this.app.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramBoolean, false);
    if (paramBoolean)
    {
      azmj.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      if (!paramBoolean) {
        break label207;
      }
    }
    label207:
    for (String str = "showGrp_open";; str = "showGrp_close")
    {
      bdaj.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      return;
      azmj.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "set_close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
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
      aono localaono = (aono)aogj.a().a(535);
      if ((localaono == null) || (!localaono.jdField_a_of_type_Boolean)) {
        break;
      }
      localFormSimpleItem.setVisibility(0);
    } while (localFormSimpleItem.getVisibility() != 0);
    if (ball.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_RED_DOT_SHOW", true, false))
    {
      localFormSimpleItem.setRightIcon(getResources().getDrawable(2130841116));
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
    Object localObject = ((aone)aogj.a().a(551)).a(4);
    if ((localObject != null) && (((aonf)localObject).jdField_b_of_type_Boolean))
    {
      localFormSimpleItem.setVisibility(0);
      if (!((baky)this.app.getManager(339)).a(4, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
        break label130;
      }
    }
    label130:
    for (localObject = "已开启";; localObject = "未开启")
    {
      localFormSimpleItem.setRightText((CharSequence)localObject);
      if (!ball.a(this.app, "SP_KEY_SING_TOGETHER_TROOP_RED_DOT_SHOW", true, false)) {
        break;
      }
      localFormSimpleItem.setRightIcon(getResources().getDrawable(2130841116));
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    localFormSimpleItem.setRightIcon(null);
  }
  
  private void w()
  {
    new QueryTask(new acma(this), new ackn(this)).a(null);
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
        localDrawable.setBounds(0, 0, azgq.a(32.0F), azgq.a(32.0F));
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
      a(localView, null, null, alpo.a(2131702130));
    }
  }
  
  private void z()
  {
    byte[] arrayOfByte = ((TroopManager)this.app.getManager(52)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (arrayOfByte != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        oidb_0xaf4.RspBody localRspBody = new oidb_0xaf4.RspBody();
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
      try
      {
        View localView = View.inflate(this, 2131562738, null);
        this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131364643));
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView.findViewById(2131377976));
        this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
        this.jdField_a_of_type_ArrayOfAndroidViewView = new View[42];
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
        Object localObject1 = new AbsListView.LayoutParams(-1, -2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        localObject1 = new bhyu(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject1);
        this.jdField_d_of_type_Boolean = TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "mIsQidianPrivateTroop : " + this.jdField_d_of_type_Boolean + ", troopUin = " + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        super.setContentView(localView);
        this.jdField_d_of_type_AndroidViewView = localView;
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130838591);
        this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131377957);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131377903));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131690796));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368659));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690796));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368613));
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131695070) + getString(2131690617));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368627));
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131691170));
        this.jdField_a_of_type_Bcws = new bcws(this, this.app);
        this.jdField_a_of_type_Bcws.a(this);
        localObject1 = View.inflate(this, 2131560479, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localObject1;
        O();
        this.jdField_b_of_type_AndroidViewView.measure(0, 0);
        localObject1 = View.inflate(this, 2131561364, null);
        ((View)localObject1).setBackgroundResource(2130850002);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        ((View)localObject1).getLayoutParams().height = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
        localObject2 = View.inflate(this, 2131561361, null);
        this.jdField_a_of_type_ArrayOfAndroidViewView[23] = localObject2;
        ((View)localObject2).setTag(Integer.valueOf(23));
        ((View)localObject2).setOnClickListener(this);
        ((View)localObject2).setContentDescription(alpo.a(2131702099));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
        localView.findViewById(2131378355).setVisibility(8);
        localObject1 = ((View)localObject2).findViewById(2131367506);
        ((View)localObject1).setTag(Integer.valueOf(35));
        ((View)localObject1).setContentDescription(getResources().getString(2131699953));
        if (azib.b()) {
          ((View)localObject1).setBackground(null);
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[35] = localObject1;
        y();
        localObject1 = ((View)localObject2).findViewById(2131378414);
        ((View)localObject1).setTag(Integer.valueOf(36));
        this.jdField_a_of_type_ArrayOfAndroidViewView[36] = localObject1;
        e();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
          localObject2 = ((View)localObject2).findViewById(2131377128);
          ((TextView)localObject2).setText(new baig((CharSequence)localObject1, 11, 16));
          this.jdField_a_of_type_ArrayOfAndroidViewView[37] = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
            ((View)localObject2).setVisibility(8);
          }
          d();
          localObject1 = View.inflate(this, 2131561364, null);
          ((View)localObject1).setBackgroundResource(2130850002);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          localObject1 = View.inflate(this, 2131561357, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject1;
          ((View)localObject1).setTag(Integer.valueOf(0));
          ((View)localObject1).setBackgroundResource(2130839253);
          ((View)localObject1).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370126));
          this.jdField_c_of_type_AndroidWidgetTextView.setText(alpo.a(2131702109) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + alpo.a(2131702117));
          if (AppSetting.jdField_c_of_type_Boolean) {
            this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, aekt.a(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), aekt.a(3.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), aekt.a(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()));
          }
          a((View)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)((View)localObject1).findViewById(2131370124));
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
          x();
          localObject1 = View.inflate(this, 2131561364, null);
          ((View)localObject1).setBackgroundResource(2130850002);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          localObject1 = View.inflate(this, 2131559721, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localObject1;
          ((View)localObject1).getBackground().setAlpha(255);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setVisibility(8);
          this.jdField_c_of_type_AndroidViewView = View.inflate(this, 2131561364, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
          this.jdField_c_of_type_AndroidViewView.getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          localObject1 = View.inflate(this, 2131561354, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[14] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setTag(Integer.valueOf(14));
          a(14, 2, (View)localObject1, getString(2131691934), "", true);
          e();
          b((View)localObject1);
          localObject1 = View.inflate(this, 2131561354, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[25] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).setTag(Integer.valueOf(25));
          a(25, 2, (View)localObject1, getString(2131699957), "", true);
          if ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
            break label4708;
          }
          bool = true;
          c(bool);
          b((View)localObject1);
          localObject1 = View.inflate(this, 2131561354, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          a((View)localObject1, null);
          a(4, 3, (View)localObject1, getString(2131699981), "", true);
          ((View)localObject1).setTag(Integer.valueOf(4));
          ((View)localObject1).setOnClickListener(this);
          localObject1 = View.inflate(this, 2131561364, null);
          ((View)localObject1).setBackgroundResource(2130850002);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          localObject1 = new FormSimpleItem(this);
          a(1001, 0, (FormSimpleItem)localObject1, getString(2131696579), alpo.a(2131702101), true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2131561364, null);
          ((View)localObject1).setBackgroundResource(2130850002);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBgType(1);
          ((FormSwitchItem)localObject1).setText(getString(2131693302));
          ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColor(2131166901));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131693302));
          this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
          localObject2 = ((FormSwitchItem)localObject1).a();
          if (!((TroopManager)this.app.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            break label4714;
          }
          ((Switch)localObject2).setChecked(true);
          ((Switch)localObject2).setTag(Integer.valueOf(7));
          ((Switch)localObject2).setOnCheckedChangeListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBackgroundResource(2130839263);
          ((FormSwitchItem)localObject1).setBgType(2);
          ((FormSwitchItem)localObject1).setText(getString(2131693303));
          ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColor(2131166901));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131693303));
          this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
          localObject2 = ((FormSwitchItem)localObject1).a();
          ((Switch)localObject2).setTag(Boolean.FALSE);
          i1 = this.app.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmask = i1;
          }
          if (i1 == 1) {
            break label4723;
          }
          bool = true;
          ((Switch)localObject2).setChecked(bool);
          ((Switch)localObject2).setOnCheckedChangeListener(new aclt(this));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2131561351, null);
          localObject2 = (FormSimpleItem)((View)localObject1).findViewById(2131368579);
          a(9, 0, (FormSimpleItem)localObject2, getString(2131720975), "", true);
          this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
          Object localObject3 = new RelativeLayout.LayoutParams(aekt.a(17.0F, getResources()), aekt.a(17.0F, getResources()));
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = aekt.a(30.0F, getResources());
          ((RelativeLayout.LayoutParams)localObject3).addRule(11);
          ((RelativeLayout.LayoutParams)localObject3).addRule(15);
          ((FormSimpleItem)localObject2).addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject3);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839224));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_ArrayOfAndroidViewView[9] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = new FormSimpleItem(this);
          a(1010, 2, (FormSimpleItem)localObject1, getString(2131694885), getString(2131719820), true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)localObject1);
          localObject1 = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject1).setBackgroundResource(2130839263);
          ((FormSwitchItem)localObject1).setText(getString(2131696823));
          ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColor(2131166901));
          ((FormSwitchItem)localObject1).setFocusable(true);
          ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject1).setContentDescription(getString(2131696823));
          this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject1;
          ((FormSwitchItem)localObject1).a().setTag(Integer.valueOf(10));
          U();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = View.inflate(this, 2131561364, null);
          ((View)localObject1).setBackgroundResource(2130850002);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          localObject2 = View.inflate(this, 2131561354, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject2;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          a((View)localObject2, null);
          ((View)localObject2).setTag(Integer.valueOf(5));
          ((View)localObject2).setOnClickListener(this);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
            break label4729;
          }
          localObject1 = alpo.a(2131702087);
          a(5, 1, (View)localObject2, getString(2131721013), (CharSequence)localObject1, true);
          if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (!this.jdField_b_of_type_Boolean)) {
            break label4740;
          }
          i1 = 0;
          ((View)localObject2).setVisibility(i1);
          localObject3 = (TextView)((View)localObject2).findViewById(2131375735);
          ((TextView)localObject3).setText((CharSequence)localObject1);
          b((View)localObject2);
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
            break label4746;
          }
          bool = false;
          this.o = bclo.b(bool, "RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
          if (bclo.a(getBaseContext(), this.app)) {
            break label4758;
          }
          bool = true;
          bclo.a(bclo.a(this, "8.0.5"), "RED_POINT_KEY_TROOP_ADMIN", this.o, bool, (TextView)localObject3);
          localObject1 = new View(this);
          ((View)localObject1).setBackgroundResource(2130849447);
          localObject2 = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject2).height = 1;
          ((RelativeLayout.LayoutParams)localObject2).setMargins(aekt.a(16.0F, getResources()), 0, 0, 0);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = (TroopPluginManager)this.app.getManager(119);
          if (localObject1 != null) {
            this.jdField_b_of_type_Boolean = ((TroopPluginManager)localObject1).a("troop_manage_plugin.apk", new aclx(this));
          }
          localObject2 = new FormSimpleItem(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localObject2;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          if (i1 != 0) {
            break label4764;
          }
          i1 = 3;
          localObject3 = getString(2131694666);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick)) {
            break label4769;
          }
          localObject1 = getString(2131698004);
          a(6, i1, (FormSimpleItem)localObject2, (String)localObject3, (CharSequence)localObject1, true);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick))
          {
            localObject1 = new bahs(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).a();
            ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
            bdnm.a(this.app, ((FormSimpleItem)localObject2).a(), (Spannable)localObject1);
          }
          localObject1 = View.inflate(this, 2131561364, null);
          ((View)localObject1).setBackgroundResource(2130850002);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          localObject1 = (bcbt)this.app.getManager(346);
          if (((bcbt)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
          {
            localObject2 = new FormSimpleItem(this, null);
            ((FormSimpleItem)localObject2).a(true);
            ((FormSimpleItem)localObject2).setBgType(1);
            ((FormSimpleItem)localObject2).setLeftText(getResources().getString(2131699969));
            ((FormSimpleItem)localObject2).setRightText(getResources().getString(2131699967));
            ((FormSimpleItem)localObject2).setContentDescription(getResources().getString(2131699969));
            ((FormSimpleItem)localObject2).a().setTextColor(getResources().getColor(2131166901));
            ((FormSimpleItem)localObject2).setFocusable(true);
            ((FormSimpleItem)localObject2).getBackground().setAlpha(255);
            this.jdField_a_of_type_ArrayOfAndroidViewView[32] = localObject2;
            ((FormSimpleItem)localObject2).setTag(Integer.valueOf(32));
            ((FormSimpleItem)localObject2).setOnClickListener(this);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
            if (((bcbt)localObject1).a()) {
              break label4781;
            }
            ((FormSimpleItem)localObject2).setRightIcon(getResources().getDrawable(2130841116));
            azmj.b(null, "dc00898", "", "", "0X800A6EE", "0X800A6EE", 0, 0, "", "", "", "");
          }
          localObject1 = View.inflate(this, 2131561364, null);
          ((View)localObject1).setBackgroundResource(2130850002);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          localObject1 = ((bcef)this.app.getManager(355)).a(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
          localObject2 = (bceb)aogj.a().a(590);
          if ((localObject2 != null) && ((((bceb)localObject2).a((int)this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt)) || (((bceb)localObject2).b((int)this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt))) && (localObject1 != null) && (((bcee)localObject1).b() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
          {
            if (((bcee)localObject1).a() != 0) {
              break label4790;
            }
            i1 = 1;
            localObject2 = new FormSimpleItem(this, null);
            ((FormSimpleItem)localObject2).a(true);
            ((FormSimpleItem)localObject2).setBgType(1);
            ((FormSimpleItem)localObject2).setLeftText(getResources().getString(2131696683));
            if (i1 == 0) {
              break label4795;
            }
            localObject1 = getResources().getString(2131696676);
            ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
            ((FormSimpleItem)localObject2).setContentDescription(getResources().getString(2131696683));
            ((FormSimpleItem)localObject2).a().setTextColor(getResources().getColor(2131166901));
            ((FormSimpleItem)localObject2).setFocusable(true);
            ((FormSimpleItem)localObject2).getBackground().setAlpha(255);
            this.jdField_a_of_type_ArrayOfAndroidViewView[41] = localObject2;
            ((FormSimpleItem)localObject2).setTag(Integer.valueOf(41));
            ((FormSimpleItem)localObject2).setOnClickListener(this);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
            localObject1 = View.inflate(this, 2131561364, null);
            ((View)localObject1).setBackgroundResource(2130850002);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          }
          localObject1 = new FormSimpleItem(this, null);
          ((FormSimpleItem)localObject1).a(true);
          ((FormSimpleItem)localObject1).setBgType(2);
          ((FormSimpleItem)localObject1).setLeftText(getResources().getString(2131721402));
          ((FormSimpleItem)localObject1).a().setTextColor(getResources().getColor(2131166901));
          ((FormSimpleItem)localObject1).setFocusable(true);
          ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
          ((FormSimpleItem)localObject1).setContentDescription(getResources().getString(2131721402));
          this.jdField_a_of_type_ArrayOfAndroidViewView[16] = localObject1;
          ((FormSimpleItem)localObject1).setTag(Integer.valueOf(16));
          ((FormSimpleItem)localObject1).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          u();
          localObject1 = new FormSimpleItem(this, null);
          ((FormSimpleItem)localObject1).a(true);
          ((FormSimpleItem)localObject1).setBgType(3);
          ((FormSimpleItem)localObject1).setLeftText("一起K歌");
          ((FormSimpleItem)localObject1).a().setTextColor(getResources().getColor(2131166901));
          ((FormSimpleItem)localObject1).setFocusable(true);
          ((FormSimpleItem)localObject1).getBackground().setAlpha(255);
          ((FormSimpleItem)localObject1).setContentDescription("一起K歌");
          this.jdField_a_of_type_ArrayOfAndroidViewView[38] = localObject1;
          ((FormSimpleItem)localObject1).setTag(Integer.valueOf(38));
          ((FormSimpleItem)localObject1).setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          v();
          if (bdsn.a())
          {
            localObject1 = View.inflate(this, 2131561364, null);
            ((View)localObject1).setBackgroundResource(2130850002);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
            localObject1 = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[40] = localObject1;
            a(40, 0, (FormSimpleItem)localObject1, getString(2131699979), "", true);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          }
          localObject1 = View.inflate(this, 2131561364, null);
          ((View)localObject1).setBackgroundResource(2130850002);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          if (!bcgx.a(this.app)) {
            break label4842;
          }
          this.jdField_a_of_type_Bcnc = new bcnc(this, getString(2131721103));
          localObject1 = this.jdField_a_of_type_Bcnc.a();
          if (localObject1 != null)
          {
            if (!bcgx.c(this.app)) {
              break label4810;
            }
            this.n = bcgx.b(this.app);
            if (QLog.isColorLevel()) {
              QLog.d("Q.chatopttroop", 2, "bShowRed red robot" + this.n);
            }
            this.jdField_a_of_type_Bcnc.a(this.n);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).setOnClickListener(this);
            ((View)localObject1).setTag(Integer.valueOf(1009));
            localObject1 = View.inflate(this, 2131561364, null);
            ((View)localObject1).setBackgroundResource(2130850002);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
            azmj.b(this.app, "dc00898", "", "", "", "0X8009F9B", 0, 0, "", "", "", "");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop()))
          {
            localObject1 = new FormSimpleItem(this);
            a(1006, 0, (FormSimpleItem)localObject1, alpo.a(2131702136), "", true);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            bdaj.a("Grp_edu", "Grp_data", "teachermsg_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          }
          localObject1 = new LinearLayout(this);
          ((LinearLayout)localObject1).setOrientation(1);
          ((LinearLayout)localObject1).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          this.jdField_a_of_type_ArrayOfAndroidViewView[28] = localObject1;
          localObject1 = View.inflate(this, 2131561364, null);
          ((View)localObject1).setBackgroundResource(2130850002);
          this.jdField_a_of_type_ArrayOfAndroidViewView[24] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          localObject1 = new FormSimpleItem(this);
          this.jdField_a_of_type_ArrayOfAndroidViewView[17] = localObject1;
          a(17, 1, (FormSimpleItem)localObject1, alpo.a(2131702121), "", true);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop", 2, "initUI  mIsQidianPrivateTroop = " + this.jdField_d_of_type_Boolean);
          }
          if (!this.jdField_d_of_type_Boolean)
          {
            localObject1 = new FormSimpleItem(this);
            this.jdField_a_of_type_ArrayOfAndroidViewView[18] = localObject1;
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            a(18, 2, (FormSimpleItem)localObject1, getString(2131720994), "", true);
            ((FormSimpleItem)localObject1).setVisibility(8);
            localObject1 = (bbqh)this.app.getManager(231);
            if (QLog.isColorLevel()) {
              QLog.d("Q.chatopttroop", 2, "initUI  effectManager.isAllTroopShowEnterance() = " + ((bbqh)localObject1).b());
            }
            if (((bbqh)localObject1).b()) {
              a(true);
            }
          }
          S();
          localObject1 = View.inflate(this, 2131561364, null);
          ((View)localObject1).setBackgroundResource(2130850002);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          localObject1 = View.inflate(this, 2131561347, null);
          this.jdField_a_of_type_ArrayOfAndroidViewView[27] = localObject1;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          a(27, 0, (View)localObject1, getString(2131696580), null, false);
          ((View)localObject1).setTag(Integer.valueOf(27));
          ((View)localObject1).setOnClickListener(this);
          localObject2 = (TextView)((View)localObject1).findViewById(2131377884);
          if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
            ((TextView)localObject2).setAlpha(0.5F);
          }
          ((TextView)localObject2).setTextColor(Color.parseColor("#4799DF"));
          localObject1 = (TextView)((View)localObject1).findViewById(2131368224);
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(8);
          }
          localObject1 = View.inflate(this, 2131561362, null);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          localObject1 = (Button)((View)localObject1).findViewById(2131365081);
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
            break label4855;
          }
          ((Button)localObject1).setText(2131691863);
          ((Button)localObject1).setOnClickListener(new acly(this));
          localObject1 = View.inflate(this, 2131561364, null);
          ((View)localObject1).setBackgroundResource(2130850002);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
          ((View)localObject1).getLayoutParams().height = getResources().getDimensionPixelSize(2131297900);
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "initUI: time = " + (System.currentTimeMillis() - l1));
          }
          this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363550);
          this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363469));
          this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376535));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)localView.findViewById(2131363384));
          this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new aclz(this));
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
      String str = getString(2131696620);
      continue;
      label4708:
      boolean bool = false;
      continue;
      label4714:
      ((Switch)localObject2).setChecked(false);
      continue;
      label4723:
      bool = false;
      continue;
      label4729:
      str = alpo.a(2131702094);
      continue;
      label4740:
      int i1 = 8;
      continue;
      label4746:
      bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop();
      continue;
      label4758:
      bool = false;
      continue;
      label4764:
      i1 = 0;
      continue;
      label4769:
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick;
      continue;
      label4781:
      ((FormSimpleItem)localObject2).setRightIcon(null);
      continue;
      label4790:
      i1 = 0;
      continue;
      label4795:
      str = getResources().getString(2131696675);
      continue;
      label4810:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        this.n = bcgx.b(this.app);
      }
      else
      {
        this.n = false;
        continue;
        label4842:
        QLog.i("Q.chatopttroop", 2, "RobotSwithOff");
        continue;
        label4855:
        str.setText(2131717652);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new beqa(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131368224);
    if (paramString != null)
    {
      paramString.setEditableFactory(baiq.a);
      if (!TextUtils.isEmpty(paramCharSequence)) {
        break label70;
      }
    }
    label70:
    for (paramView = "";; paramView = new baig(paramCharSequence, 3))
    {
      paramString.setText(paramView);
      paramString.setTextColor(getResources().getColor(2131166975));
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
        localTextView = (TextView)paramView.findViewById(2131377884);
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
      paramView.setBackgroundResource(2130839253);
      break label52;
      paramView.setBackgroundResource(2130839269);
      break label52;
      paramView.setBackgroundResource(2130839263);
      break label52;
      paramView.setBackgroundResource(2130839260);
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
        paramFormSimpleItem.a().setEditableFactory(baiq.a);
        if (paramCharSequence != null) {
          break;
        }
      }
    }
    for (paramString = "";; paramString = new baig(paramCharSequence, 3))
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
    String str2 = bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (paramInt == -1) {}
    for (Object localObject = "0";; localObject = "1")
    {
      bdaj.a("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
      if (paramInt == -1) {
        break;
      }
      return;
    }
    localObject = aekt.a(new Intent(this, SplashActivity.class), null);
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
      paramView = paramView.findViewById(2131362823);
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
    //   5: getfield 2167	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 2169	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 2170	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 10
    //   21: aload 10
    //   23: aload_1
    //   24: getfield 2174	KQQ/BatchResponse:buffer	[B
    //   27: checkcast 2175	[B
    //   30: invokevirtual 2176	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   33: pop
    //   34: aload_1
    //   35: getfield 2179	KQQ/BatchResponse:seq	I
    //   38: ifne +748 -> 786
    //   41: aload 10
    //   43: ifnull +743 -> 786
    //   46: aload 10
    //   48: getfield 2183	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 2186	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   54: ifeq +732 -> 786
    //   57: aload 10
    //   59: getfield 2183	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   62: invokevirtual 2189	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   65: invokevirtual 2195	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   68: astore 8
    //   70: new 2197	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   73: dup
    //   74: invokespecial 2198	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   77: astore 9
    //   79: aload 9
    //   81: aload 8
    //   83: invokevirtual 2199	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   86: pop
    //   87: aconst_null
    //   88: astore 8
    //   90: aload 9
    //   92: getfield 2203	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: invokevirtual 2208	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   98: astore 11
    //   100: aload 11
    //   102: ifnonnull +53 -> 155
    //   105: iconst_0
    //   106: istore_3
    //   107: goto +1306 -> 1413
    //   110: aload 8
    //   112: ifnonnull +674 -> 786
    //   115: iload 4
    //   117: iload_3
    //   118: if_icmpge +668 -> 786
    //   121: aload 11
    //   123: iload 4
    //   125: invokeinterface 2210 2 0
    //   130: checkcast 2212	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
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
    //   151: invokevirtual 2213	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   154: return
    //   155: aload 11
    //   157: invokeinterface 2216 1 0
    //   162: istore_3
    //   163: goto +1250 -> 1413
    //   166: aload 9
    //   168: getfield 2220	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: invokevirtual 2223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   174: istore_2
    //   175: iload_2
    //   176: bipush 72
    //   178: if_icmpne +83 -> 261
    //   181: iload 4
    //   183: ifne +78 -> 261
    //   186: aload_0
    //   187: ldc_w 2224
    //   190: iconst_1
    //   191: invokestatic 1528	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   194: aload_0
    //   195: invokevirtual 1531	com/tencent/mobileqq/activity/ChatSettingForTroop:getTitleBarHeight	()I
    //   198: invokevirtual 1534	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   201: pop
    //   202: new 2226	com/tencent/mobileqq/activity/ChatSettingForTroop$35
    //   205: dup
    //   206: aload_0
    //   207: invokespecial 2227	com/tencent/mobileqq/activity/ChatSettingForTroop$35:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   210: bipush 32
    //   212: aconst_null
    //   213: iconst_0
    //   214: invokestatic 2232	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   217: aload_0
    //   218: aconst_null
    //   219: putfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   222: aload_0
    //   223: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   226: iconst_0
    //   227: putfield 1290	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   230: aload_0
    //   231: invokevirtual 837	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   234: ldc_w 2234
    //   237: iconst_0
    //   238: invokevirtual 853	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   241: pop
    //   242: aload_0
    //   243: invokevirtual 1409	com/tencent/mobileqq/activity/ChatSettingForTroop:finish	()V
    //   246: aload_0
    //   247: aload_0
    //   248: invokevirtual 837	com/tencent/mobileqq/activity/ChatSettingForTroop:getIntent	()Landroid/content/Intent;
    //   251: invokevirtual 1429	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   254: iconst_2
    //   255: invokestatic 2237	bclo:a	(Landroid/content/Context;Landroid/os/Bundle;I)V
    //   258: goto -118 -> 140
    //   261: iload_2
    //   262: ifne +1051 -> 1313
    //   265: aload 9
    //   267: getfield 2241	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   270: invokevirtual 2244	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   273: ifeq +1040 -> 1313
    //   276: aload 9
    //   278: getfield 2241	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   281: invokevirtual 2247	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   284: checkcast 2243	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
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
    //   315: ldc_w 2249
    //   318: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 9
    //   323: getfield 2252	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_long_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   326: invokevirtual 2189	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   329: invokevirtual 2255	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
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
    //   358: invokevirtual 2259	com/tencent/mobileqq/troopinfo/TroopInfoData:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   361: aload_0
    //   362: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   365: getfield 1203	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   368: invokestatic 521	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +7 -> 378
    //   374: aload_0
    //   375: invokevirtual 959	com/tencent/mobileqq/activity/ChatSettingForTroop:e	()V
    //   378: aload_0
    //   379: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   382: getfield 1366	com/tencent/mobileqq/troopinfo/TroopInfoData:hasSetNewTroopHead	Z
    //   385: ifeq +7 -> 392
    //   388: aload_0
    //   389: invokespecial 1780	com/tencent/mobileqq/activity/ChatSettingForTroop:y	()V
    //   392: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   395: ifeq +69 -> 464
    //   398: aload 9
    //   400: getfield 2262	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   403: invokevirtual 2223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   406: istore_2
    //   407: ldc_w 2264
    //   410: iconst_2
    //   411: new 282	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 2266
    //   421: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   428: getfield 343	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   431: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 2268
    //   437: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: iload_2
    //   441: invokevirtual 1337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: ldc_w 2270
    //   447: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload_2
    //   451: i2l
    //   452: invokestatic 2272	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(J)Z
    //   455: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   458: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload_0
    //   465: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   468: ifnull +64 -> 532
    //   471: aload_0
    //   472: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   475: aload 9
    //   477: invokevirtual 2273	com/tencent/mobileqq/data/TroopInfo:coverFrom	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;)V
    //   480: aload_0
    //   481: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   484: aload_0
    //   485: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   488: invokevirtual 515	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   491: putfield 1203	com/tencent/mobileqq/troopinfo/TroopInfoData:newTroopName	Ljava/lang/String;
    //   494: aload_0
    //   495: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   498: getfield 2274	com/tencent/mobileqq/data/TroopInfo:isNewTroop	Z
    //   501: ifne +17 -> 518
    //   504: aload_0
    //   505: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   508: aload_0
    //   509: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   512: invokevirtual 515	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   515: putfield 2275	com/tencent/mobileqq/data/TroopInfo:newTroopName	Ljava/lang/String;
    //   518: aload_0
    //   519: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   522: aload_0
    //   523: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   526: invokevirtual 515	com/tencent/mobileqq/data/TroopInfo:getTroopName	()Ljava/lang/String;
    //   529: putfield 2278	com/tencent/mobileqq/data/TroopInfo:oldTroopName	Ljava/lang/String;
    //   532: aload_0
    //   533: aload 9
    //   535: getfield 2262	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   538: invokevirtual 2223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   541: i2l
    //   542: invokestatic 2272	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(J)Z
    //   545: putfield 1716	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   548: aload_0
    //   549: getfield 1716	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   552: ifeq +77 -> 629
    //   555: aload_0
    //   556: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   559: getfield 292	com/tencent/mobileqq/troopinfo/TroopInfoData:bOwner	Z
    //   562: ifeq +736 -> 1298
    //   565: iconst_1
    //   566: istore_2
    //   567: new 2280	azmo
    //   570: dup
    //   571: aload_0
    //   572: getfield 308	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   575: invokespecial 2283	azmo:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   578: ldc_w 332
    //   581: invokevirtual 2286	azmo:a	(Ljava/lang/String;)Lazmo;
    //   584: ldc_w 2288
    //   587: invokevirtual 2290	azmo:b	(Ljava/lang/String;)Lazmo;
    //   590: ldc_w 338
    //   593: invokevirtual 2292	azmo:c	(Ljava/lang/String;)Lazmo;
    //   596: ldc_w 2294
    //   599: invokevirtual 2296	azmo:d	(Ljava/lang/String;)Lazmo;
    //   602: iconst_2
    //   603: anewarray 579	java/lang/String
    //   606: dup
    //   607: iconst_0
    //   608: aload_0
    //   609: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   612: getfield 343	com/tencent/mobileqq/troopinfo/TroopInfoData:troopUin	Ljava/lang/String;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: iload_2
    //   619: invokestatic 1157	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   622: aastore
    //   623: invokevirtual 2299	azmo:a	([Ljava/lang/String;)Lazmo;
    //   626: invokevirtual 2301	azmo:a	()V
    //   629: aload_0
    //   630: getfield 1716	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Boolean	Z
    //   633: ifne +791 -> 1424
    //   636: aload_0
    //   637: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   640: getfield 1825	com/tencent/mobileqq/troopinfo/TroopInfoData:isNewTroop	Z
    //   643: ifne +781 -> 1424
    //   646: iconst_1
    //   647: istore 5
    //   649: aload_0
    //   650: iload 5
    //   652: invokespecial 1162	com/tencent/mobileqq/activity/ChatSettingForTroop:c	(Z)V
    //   655: aload_0
    //   656: invokevirtual 2303	com/tencent/mobileqq/activity/ChatSettingForTroop:l	()V
    //   659: aload_0
    //   660: getfield 308	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   663: aload_0
    //   664: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   667: getfield 2306	com/tencent/mobileqq/troopinfo/TroopInfoData:publicAccountUin	J
    //   670: new 2308	aclh
    //   673: dup
    //   674: aload_0
    //   675: invokespecial 2309	aclh:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)V
    //   678: invokestatic 2314	bchz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLnac;)V
    //   681: aload_0
    //   682: invokevirtual 2316	com/tencent/mobileqq/activity/ChatSettingForTroop:k	()V
    //   685: aload_0
    //   686: invokespecial 2318	com/tencent/mobileqq/activity/ChatSettingForTroop:L	()V
    //   689: aload_0
    //   690: invokevirtual 1784	com/tencent/mobileqq/activity/ChatSettingForTroop:d	()V
    //   693: aload_0
    //   694: invokespecial 1549	com/tencent/mobileqq/activity/ChatSettingForTroop:O	()V
    //   697: aload_0
    //   698: invokevirtual 2320	com/tencent/mobileqq/activity/ChatSettingForTroop:q	()V
    //   701: aload_0
    //   702: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   705: ifnull +21 -> 726
    //   708: aload_0
    //   709: getfield 304	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqDataTroopInfo	Lcom/tencent/mobileqq/data/TroopInfo;
    //   712: aload_0
    //   713: getfield 308	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   716: aload_0
    //   717: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   720: getfield 1290	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   723: invokestatic 2323	bclo:a	(Lcom/tencent/mobileqq/data/TroopInfo;Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   726: aload_0
    //   727: invokevirtual 2325	com/tencent/mobileqq/activity/ChatSettingForTroop:f	()V
    //   730: aload 9
    //   732: astore 8
    //   734: aload_0
    //   735: getfield 2327	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   738: ifnull -598 -> 140
    //   741: aload_0
    //   742: getfield 2327	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   745: aload_0
    //   746: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   749: invokevirtual 2333	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:setTroopInfoData	(Lcom/tencent/mobileqq/troopinfo/TroopInfoData;)V
    //   752: aload_0
    //   753: getfield 2327	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   756: invokevirtual 2334	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	()V
    //   759: aload 9
    //   761: astore 8
    //   763: goto -623 -> 140
    //   766: astore 8
    //   768: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   771: ifeq +15 -> 786
    //   774: ldc_w 2336
    //   777: iconst_2
    //   778: aload 8
    //   780: invokevirtual 2337	java/lang/Exception:toString	()Ljava/lang/String;
    //   783: invokestatic 701	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   786: aload_1
    //   787: getfield 2179	KQQ/BatchResponse:seq	I
    //   790: iconst_1
    //   791: if_icmpne +92 -> 883
    //   794: aload 10
    //   796: ifnull +87 -> 883
    //   799: aload 10
    //   801: getfield 2183	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   804: invokevirtual 2186	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   807: ifeq +76 -> 883
    //   810: aload 10
    //   812: getfield 2183	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   815: invokevirtual 2189	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   818: invokevirtual 2195	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   821: astore 8
    //   823: new 2339	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   826: dup
    //   827: invokespecial 2340	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   830: astore 9
    //   832: aload 9
    //   834: aload 8
    //   836: invokevirtual 2341	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   839: pop
    //   840: aload 9
    //   842: getfield 2344	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   845: invokevirtual 2345	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   848: ifeq +35 -> 883
    //   851: aload_0
    //   852: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   855: getfield 1290	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   858: ifne +485 -> 1343
    //   861: aload_0
    //   862: getfield 2327	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   865: ifnull +18 -> 883
    //   868: aload_0
    //   869: getfield 2327	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   872: aload 9
    //   874: getfield 2344	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   877: invokevirtual 2208	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   880: invokevirtual 2347	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:a	(Ljava/util/List;)V
    //   883: aload_1
    //   884: getfield 2179	KQQ/BatchResponse:seq	I
    //   887: iconst_2
    //   888: if_icmpne -877 -> 11
    //   891: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   894: ifeq +13 -> 907
    //   897: ldc_w 2349
    //   900: iconst_2
    //   901: ldc_w 2351
    //   904: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   907: aload 10
    //   909: ifnull -898 -> 11
    //   912: aload 10
    //   914: getfield 2183	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   917: invokevirtual 2186	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   920: ifeq -909 -> 11
    //   923: aload 10
    //   925: getfield 2183	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   928: invokevirtual 2189	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   931: invokevirtual 2195	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   934: astore_1
    //   935: new 2353	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   938: dup
    //   939: invokespecial 2354	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   942: astore 8
    //   944: aload 8
    //   946: aload_1
    //   947: invokevirtual 2355	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   950: pop
    //   951: aload 8
    //   953: getfield 2358	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   956: invokevirtual 801	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   959: ifeq -948 -> 11
    //   962: aload 8
    //   964: getfield 2361	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   967: invokevirtual 2362	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   970: ifne +438 -> 1408
    //   973: aload 8
    //   975: getfield 2361	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   978: invokevirtual 2208	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   981: astore_1
    //   982: aload_0
    //   983: getfield 308	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   986: bipush 52
    //   988: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   991: checkcast 316	com/tencent/mobileqq/app/TroopManager
    //   994: astore 9
    //   996: aload 8
    //   998: getfield 2358	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1001: invokevirtual 803	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1004: lstore 6
    //   1006: aload 9
    //   1008: lload 6
    //   1010: invokestatic 1255	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1013: invokevirtual 351	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   1016: astore 10
    //   1018: aload 10
    //   1020: ifnull -1009 -> 11
    //   1023: aload_1
    //   1024: ifnull +69 -> 1093
    //   1027: aload 10
    //   1029: aload_1
    //   1030: invokevirtual 2365	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap787	(Ljava/util/List;)V
    //   1033: aload 8
    //   1035: getfield 2368	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1038: invokevirtual 2369	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1041: ifeq +340 -> 1381
    //   1044: aload 8
    //   1046: getfield 2368	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1049: invokevirtual 2223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1052: istore_2
    //   1053: aload 10
    //   1055: iload_2
    //   1056: i2l
    //   1057: putfield 2372	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   1060: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1063: ifeq +30 -> 1093
    //   1066: ldc_w 2349
    //   1069: iconst_2
    //   1070: new 282	java/lang/StringBuilder
    //   1073: dup
    //   1074: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   1077: ldc_w 2374
    //   1080: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: iload_2
    //   1084: invokevirtual 1337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1087: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1090: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1093: aload 8
    //   1095: getfield 2377	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1098: astore_1
    //   1099: aload_1
    //   1100: ifnull +19 -> 1119
    //   1103: aload 10
    //   1105: aload 8
    //   1107: getfield 2377	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1110: invokevirtual 2189	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1113: invokevirtual 2255	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1116: putfield 2380	com/tencent/mobileqq/data/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   1119: aload 8
    //   1121: getfield 2383	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1124: astore_1
    //   1125: aload_1
    //   1126: ifnull +19 -> 1145
    //   1129: aload 10
    //   1131: aload 8
    //   1133: getfield 2383	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1136: invokevirtual 2189	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1139: invokevirtual 2255	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1142: putfield 2386	com/tencent/mobileqq/data/TroopInfo:adminNameShow	Ljava/lang/String;
    //   1145: iconst_m1
    //   1146: istore_2
    //   1147: iconst_m1
    //   1148: istore_3
    //   1149: aload 8
    //   1151: getfield 2389	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1154: invokevirtual 2369	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1157: ifeq +23 -> 1180
    //   1160: aload 10
    //   1162: aload 8
    //   1164: getfield 2389	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1167: invokevirtual 2223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1170: i2b
    //   1171: putfield 2392	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   1174: aload 10
    //   1176: getfield 2392	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   1179: istore_2
    //   1180: aload 8
    //   1182: getfield 2395	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1185: invokevirtual 2369	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1188: ifeq +23 -> 1211
    //   1191: aload 10
    //   1193: aload 8
    //   1195: getfield 2395	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1198: invokevirtual 2223	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1201: i2b
    //   1202: putfield 2398	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1205: aload 10
    //   1207: getfield 2398	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1210: istore_3
    //   1211: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1214: ifeq +45 -> 1259
    //   1217: ldc_w 2349
    //   1220: iconst_2
    //   1221: new 282	java/lang/StringBuilder
    //   1224: dup
    //   1225: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   1228: lload 6
    //   1230: invokevirtual 944	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1233: ldc_w 2400
    //   1236: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: iload_2
    //   1240: invokevirtual 1337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1243: ldc_w 2402
    //   1246: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: iload_3
    //   1250: invokevirtual 1337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1253: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1256: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1259: new 2404	com/tencent/mobileqq/activity/ChatSettingForTroop$37
    //   1262: dup
    //   1263: aload_0
    //   1264: aload 9
    //   1266: aload 10
    //   1268: invokespecial 2407	com/tencent/mobileqq/activity/ChatSettingForTroop$37:<init>	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1271: bipush 8
    //   1273: aconst_null
    //   1274: iconst_0
    //   1275: invokestatic 2161	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1278: return
    //   1279: astore_1
    //   1280: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1283: ifeq -1272 -> 11
    //   1286: ldc_w 2349
    //   1289: iconst_2
    //   1290: aload_1
    //   1291: invokevirtual 2337	java/lang/Exception:toString	()Ljava/lang/String;
    //   1294: invokestatic 1287	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1297: return
    //   1298: aload_0
    //   1299: getfield 128	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   1302: getfield 373	com/tencent/mobileqq/troopinfo/TroopInfoData:bAdmin	Z
    //   1305: ifeq +114 -> 1419
    //   1308: iconst_2
    //   1309: istore_2
    //   1310: goto -743 -> 567
    //   1313: ldc_w 1329
    //   1316: iconst_1
    //   1317: new 282	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   1324: ldc_w 2409
    //   1327: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: iload_2
    //   1331: invokevirtual 1337	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1334: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1337: invokestatic 1287	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1340: goto -1200 -> 140
    //   1343: aload_0
    //   1344: aload 9
    //   1346: getfield 2344	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1349: invokevirtual 2208	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1352: invokespecial 1071	com/tencent/mobileqq/activity/ChatSettingForTroop:c	(Ljava/util/List;)V
    //   1355: goto -472 -> 883
    //   1358: astore 8
    //   1360: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1363: ifeq -480 -> 883
    //   1366: ldc_w 2336
    //   1369: iconst_2
    //   1370: aload 8
    //   1372: invokevirtual 2337	java/lang/Exception:toString	()Ljava/lang/String;
    //   1375: invokestatic 701	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1378: goto -495 -> 883
    //   1381: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1384: ifeq -291 -> 1093
    //   1387: ldc_w 2349
    //   1390: iconst_2
    //   1391: ldc_w 2411
    //   1394: invokestatic 302	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1397: goto -304 -> 1093
    //   1400: astore_1
    //   1401: goto -256 -> 1145
    //   1404: astore_1
    //   1405: goto -286 -> 1119
    //   1408: aconst_null
    //   1409: astore_1
    //   1410: goto -428 -> 982
    //   1413: iconst_0
    //   1414: istore 4
    //   1416: goto -1306 -> 110
    //   1419: iconst_3
    //   1420: istore_2
    //   1421: goto -854 -> 567
    //   1424: iconst_0
    //   1425: istore 5
    //   1427: goto -778 -> 649
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1430	0	this	ChatSettingForTroop
    //   0	1430	1	paramBatchResponse	KQQ.BatchResponse
    //   174	1247	2	i1	int
    //   106	1144	3	i2	int
    //   115	1300	4	i3	int
    //   647	779	5	bool	boolean
    //   1004	225	6	l1	long
    //   68	694	8	localObject1	Object
    //   766	13	8	localException1	Exception
    //   821	373	8	localObject2	Object
    //   1358	13	8	localException2	Exception
    //   77	1268	9	localObject3	Object
    //   19	1248	10	localObject4	Object
    //   98	58	11	localList	List
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
    //   1298	1308	766	java/lang/Exception
    //   1313	1340	766	java/lang/Exception
    //   935	982	1279	java/lang/Exception
    //   982	1018	1279	java/lang/Exception
    //   1027	1093	1279	java/lang/Exception
    //   1093	1099	1279	java/lang/Exception
    //   1119	1125	1279	java/lang/Exception
    //   1149	1180	1279	java/lang/Exception
    //   1180	1211	1279	java/lang/Exception
    //   1211	1259	1279	java/lang/Exception
    //   1259	1278	1279	java/lang/Exception
    //   1381	1397	1279	java/lang/Exception
    //   823	883	1358	java/lang/Exception
    //   1343	1355	1358	java/lang/Exception
    //   1129	1145	1400	java/lang/Exception
    //   1103	1119	1404	java/lang/Exception
  }
  
  public void a(acqa paramacqa, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramacqa.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBitmap == null) {
      paramBitmap = this.jdField_a_of_type_Bcws.b(paramacqa.jdField_a_of_type_Int, paramacqa.jdField_a_of_type_JavaLangString, 5);
    }
    for (;;)
    {
      Bitmap localBitmap = paramBitmap;
      if (paramBitmap == null)
      {
        if (paramBoolean) {
          paramBitmap = bdda.a();
        }
        localBitmap = paramBitmap;
        if (!this.jdField_a_of_type_Bcws.a())
        {
          this.jdField_a_of_type_Bcws.a(paramacqa.jdField_a_of_type_JavaLangString, paramacqa.jdField_a_of_type_Int, false);
          localBitmap = paramBitmap;
        }
      }
      if (localBitmap == null) {
        break;
      }
      paramacqa.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(getResources(), localBitmap));
      return;
    }
  }
  
  protected void a(View paramView)
  {
    int[] arrayOfInt = new int[6];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131378407;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131378408;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131378409;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131378410;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131378411;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131378412;
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
      bclo.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    azmj.b(this.app, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString3, "", "");
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
                  azmj.b(this.app, "CliOper", "", "", "0x80084B5", "0x80084B5", 0, 0, "", "", "", "");
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
              d(getActivity().getResources().getString(2131721020));
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.chatopttroop", 2, "joinGroup onResult " + paramJSONObject.toString());
    return;
    label969:
    paramJSONObject = getActivity().getResources().getString(2131721020);
    switch (paramInt)
    {
    }
    for (;;)
    {
      d(paramJSONObject);
      break label870;
      paramJSONObject = getActivity().getResources().getString(2131721015);
      continue;
      paramJSONObject = getActivity().getResources().getString(2131721021);
      continue;
      label1054:
      paramInt += 1;
      break;
      label1061:
      paramInt += 1;
      break label314;
    }
  }
  
  public void a(oidb_0xaf4.RspBody paramRspBody)
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
    label386:
    int i1;
    label394:
    int i2;
    label396:
    do
    {
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[28];
      if (localObject1 == null) {
        break;
      }
      if (paramRspBody.extra_info.tab_infos.size() <= 0) {
        break label1428;
      }
      ((View)localObject1).setVisibility(0);
      b(paramRspBody.extra_info.tab_infos.get());
      return;
      bool1 = azib.b();
      bool2 = ThemeUtil.isInNightMode(this.app);
      localView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378353));
      if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) || (paramRspBody.manage_info == null) || (paramRspBody.manage_info.url == null)) {
        break label463;
      }
      if (paramRspBody.manage_info.label.get() != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramRspBody.manage_info.label.get());
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      MiniProgramLpReportDC04239.reportByQQqunInfo("qun", "qun_info", "expo_set", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new aclq(this, paramRspBody));
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      i4 = localList.size();
      localObject1 = localView.findViewById(2131378278);
      if (i4 > 5) {
        break label475;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList.size() <= 5");
      }
      ((View)localObject1).setVisibility(8);
      if (i4 > 5) {
        break label484;
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
      break label396;
      label463:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label475:
      ((View)localObject1).setVisibility(0);
      break label386;
      label484:
      i1 = 9;
      break label394;
      localObject1 = localView.findViewById(2131378264);
      label500:
      ImageView localImageView;
      Object localObject3;
      TextView localTextView;
      oidb_0xaf4.AppInfo localAppInfo;
      String str;
      Object localObject2;
      int i3;
      if ((i2 <= i1) && (i2 < i4))
      {
        ((View)localObject1).setVisibility(0);
        localImageView = (ImageView)((View)localObject1).findViewById(2131362695);
        localObject3 = (TextView)((View)localObject1).findViewById(2131362713);
        localTextView = (TextView)((View)localObject1).findViewById(2131362711);
        localAppInfo = (oidb_0xaf4.AppInfo)localList.get(i2);
        str = localAppInfo.name.get();
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        localObject2 = str;
        if (str.length() > 4) {
          localObject2 = str.substring(0, 4) + "...";
        }
        if (localAppInfo.source.get() == 1) {
          this.jdField_c_of_type_JavaUtilArrayList.add(Long.valueOf(localAppInfo.appid.get()));
        }
        ((TextView)localObject3).setText((CharSequence)localObject2);
        localObject3 = new StringBuffer((String)localObject2);
        i3 = localAppInfo.push_red_point.get();
        if (i3 != -1) {
          break label1166;
        }
        localTextView.setVisibility(0);
        localTextView.setText("");
        localTextView.setBackgroundResource(0);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130849728, 0, 0, 0);
        ((StringBuffer)localObject3).append("，新");
        label733:
        long l1 = localAppInfo.appid.get();
        if ((i3 != -1) && (l1 == 1L))
        {
          if (!bdbx.a(this.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false)) {
            break label1228;
          }
          localTextView.setVisibility(0);
          localTextView.setText("");
          localTextView.setBackgroundResource(0);
          localTextView.setCompoundDrawablesWithIntrinsicBounds(2130849728, 0, 0, 0);
        }
        label811:
        if (l1 == 0L) {
          MiniProgramLpReportDC04239.reportByQQqunInfo("qun", "qun_info", "expo_more", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (!bool2) {
          break label1246;
        }
        if (!localAppInfo.icon_simple_night.has()) {
          break label1238;
        }
        localObject2 = localAppInfo.icon_simple_night.get();
        label863:
        if (!localAppInfo.icon.has()) {
          break label1278;
        }
        str = localAppInfo.icon.get();
        label884:
        if ((!bool1) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          break label1286;
        }
        label897:
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label1293;
        }
        localImageView.setImageResource(2130843290);
      }
      for (;;)
      {
        if (bool2) {
          localImageView.setColorFilter(1996488704);
        }
        ((View)localObject1).setTag(localAppInfo);
        ((View)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        i3 = 0;
        while (i3 < i4)
        {
          localObject2 = (oidb_0xaf4.AppInfo)localList.get(i3);
          if ((localObject2 != null) && (((oidb_0xaf4.AppInfo)localObject2).appid != null)) {
            bdaj.a("Grp_app_new", "grpData_admin", "app_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData), String.valueOf(((oidb_0xaf4.AppInfo)localObject2).appid.get()) });
          }
          i3 += 1;
        }
        localObject1 = localView.findViewById(2131378265);
        break label500;
        localObject1 = localView.findViewById(2131378266);
        break label500;
        localObject1 = localView.findViewById(2131378267);
        break label500;
        localObject1 = localView.findViewById(2131378268);
        break label500;
        localObject1 = localView.findViewById(2131378269);
        break label500;
        localObject1 = localView.findViewById(2131378270);
        break label500;
        localObject1 = localView.findViewById(2131378271);
        break label500;
        localObject1 = localView.findViewById(2131378272);
        break label500;
        localObject1 = localView.findViewById(2131378273);
        break label500;
        ((View)localObject1).setVisibility(4);
        break;
        label1166:
        if (i3 > 0)
        {
          localTextView.setVisibility(0);
          localTextView.setText(String.valueOf(i3));
          localTextView.setBackgroundResource(2130849732);
          ((StringBuffer)localObject3).append("，").append(i3).append("未读");
          break label733;
        }
        localTextView.setVisibility(8);
        break label733;
        label1228:
        localTextView.setVisibility(8);
        break label811;
        label1238:
        localObject2 = "";
        break label863;
        label1246:
        if (localAppInfo.icon_simple_day.has())
        {
          localObject2 = localAppInfo.icon_simple_day.get();
          break label863;
        }
        localObject2 = "";
        break label863;
        label1278:
        str = "";
        break label884;
        label1286:
        localObject2 = str;
        break label897;
        try
        {
          label1293:
          i3 = aekt.a(40.0F, getResources());
          if (!MiniAppLauncher.isMiniAppUrl(localAppInfo.url.get())) {
            break label1378;
          }
          localImageView.setImageDrawable(MiniAppUtils.getIcon(localImageView.getContext(), (String)localObject2, true, 2130843290, 40));
          bclo.a(localAppInfo, "expo", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        catch (Exception localException)
        {
          localImageView.setImageDrawable(getResources().getDrawable(2130843290));
        }
        continue;
        label1378:
        localImageView.setImageDrawable(URLDrawable.getDrawable(localException, i3, i3, getResources().getDrawable(2130843290), getResources().getDrawable(2130843290)));
      }
      ((View)localObject1).setContentDescription(((StringBuffer)localObject3).toString());
    }
    label1428:
    ((View)localObject1).setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "updateEnterEffectStatus  isShow = " + paramBoolean);
    }
    FormSimpleItem localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[18];
    if (localFormSimpleItem == null) {}
    bbps localbbps;
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
      localObject = (bbqh)this.app.getManager(231);
      localbbps = ((bbqh)localObject).a();
    } while (localbbps == null);
    if (localbbps.b > 0)
    {
      localFormSimpleItem.setRightText(localbbps.jdField_a_of_type_JavaLangString);
      return;
      localFormSimpleItem.setVisibility(8);
      return;
    }
    Object localObject = ((bbqh)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if (localObject != null)
    {
      if (((bbpt)localObject).jdField_a_of_type_Int == 0)
      {
        localFormSimpleItem.setRightText(alpo.a(2131702114));
        return;
      }
      localFormSimpleItem.setRightText(((bbpt)localObject).jdField_a_of_type_JavaLangString);
      return;
    }
    localFormSimpleItem.setRightText(alpo.a(2131702122));
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
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = bclo.a(localBundle, this);
      bool2 = bool3;
      TroopInfo localTroopInfo = bclo.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this);
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
      bclo.jdField_a_of_type_Int = localBundle.getInt("exposureSource", 99);
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
      nco.a(this.app, 69);
    }
    return bool2;
  }
  
  protected void b()
  {
    if (!bdee.g(getApplicationContext())) {}
    alzf localalzf;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "initNetworkRequests");
      }
      localalzf = (alzf)this.app.a(20);
      ArrayList localArrayList;
      if (localalzf != null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        localalzf.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, localArrayList);
      }
      if (localalzf != null)
      {
        m();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
        {
          localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
          localalzf.a(localArrayList);
          localalzf.i(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
      this.jdField_a_of_type_Nev = new nev(this.app);
      E();
    } while (localalzf == null);
    localalzf.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false, this.jdField_j_of_type_Int, 1);
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
      localTextView = (TextView)paramView.findViewById(2131377884);
      paramView = paramView.findViewById(2131375735);
    } while ((localTextView == null) || (paramView == null) || (TextUtils.isEmpty(localTextView.getText())));
    int i1 = (int)localTextView.getPaint().measureText(localTextView.getText().toString());
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).leftMargin = (aekt.a(30.0F, getResources()) + i1);
  }
  
  public void b(List<oidb_0xaf4.TabInfo> paramList)
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ArrayOfAndroidViewView[28];
    localViewGroup.removeAllViews();
    int i5 = 0;
    int i2 = 0;
    int i1 = 0;
    oidb_0xaf4.TabInfo localTabInfo;
    String str1;
    String str2;
    String str3;
    int i6;
    View localView;
    Object localObject;
    int i3;
    if (i5 < paramList.size())
    {
      localTabInfo = (oidb_0xaf4.TabInfo)paramList.get(i5);
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
        ((View)localObject).setTag(2131377396, str3);
        ((View)localObject).setTag(2131377369, localTabInfo);
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
            this.jdField_a_of_type_JavaLangString = bclo.a((View)localObject, localTabInfo);
            bdaj.a("Grp_set", "Grp_aio_subscription", "subscription_exp", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) });
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839224);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131297901));
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
    if (!bdee.g(getApplicationContext())) {
      QQToast.a(getApplicationContext(), 1, getString(2131694766), 1).b(getTitleBarHeight());
    }
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ackq(this);
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
          this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + alpo.a(2131702123));
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
    localObject = (TextView)((View)localObject).findViewById(2131378379);
    ((TextView)localObject).setTag(Integer.valueOf(39));
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i1 = 0;
    }
    if (i1 > 0)
    {
      String str = String.format(getResources().getString(2131693673), new Object[] { Integer.valueOf(i1) });
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
      String str = bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      if (paramInt2 == -1) {}
      for (paramIntent = "0";; paramIntent = "1")
      {
        bdaj.a("Grp_share", "grpData_admin", "share_qzone", 0, 0, new String[] { localObject, str, paramIntent });
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
          ((alzf)this.app.a(20)).g(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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
                  paramIntent = aekt.a(new Intent(this, SplashActivity.class), null);
                  paramIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
                  paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName());
                  paramIntent.putExtra("uintype", 1);
                  startActivity(paramIntent);
                  setResult(-1);
                  finish();
                  return;
                  e(paramInt2, paramIntent);
                  return;
                  paramIntent = (bbqh)this.app.getManager(231);
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
                      for (paramIntent = getResources().getString(2131696675);; paramIntent = getResources().getString(2131696676))
                      {
                        ((FormSimpleItem)localObject).setRightText(paramIntent);
                        return;
                      }
                      if ((paramInt2 == -1) && (paramIntent != null))
                      {
                        if (!bdee.g(this))
                        {
                          QQToast.a(this, 1, 2131694767, 0).b(getTitleBarHeight());
                          return;
                        }
                        paramIntent = paramIntent.getStringExtra("result");
                        if ((!TextUtils.isEmpty(paramIntent)) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (!paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopname)))
                        {
                          localObject = (alkk)this.app.a(22);
                          bool1 = bool2;
                          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
                          {
                            bool1 = bool2;
                            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1) {
                              bool1 = true;
                            }
                          }
                          ((alkk)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramIntent, bool1);
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
      bclo.a(this.app, getApplicationContext(), this.jdField_d_of_type_JavaLangString, this, 0, null);
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
        break label1071;
      }
    }
    label394:
    label1071:
    for (long l1 = System.currentTimeMillis();; l1 = 0L)
    {
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
        OpenID localOpenID = this.app.a().a(paramBundle);
        if (localOpenID == null)
        {
          o();
          this.jdField_b_of_type_AndroidOsHandler = new Handler();
          this.jdField_b_of_type_AndroidOsHandler.postDelayed(new ChatSettingForTroop.2(this), 3000L);
          this.app.addObserver(this.jdField_a_of_type_Ndm);
          this.app.a().d(paramBundle);
          break label313;
        }
        if (this.jdField_e_of_type_JavaLangString.equals(localOpenID.openID)) {
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
            bclo.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_b_of_type_JavaUtilArrayList);
          }
          this.jdField_a_of_type_Bdih = ((bdih)this.app.getManager(31));
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
            nco.a(this.app, 65);
            paramBundle = new IntentFilter();
            paramBundle.addAction("start_recomend_page");
            paramBundle.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            paramBundle.addAction("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER");
            registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
            addObserver(this.jdField_d_of_type_Amab);
            addObserver(this.jdField_c_of_type_Amab);
            bclo.a(this.app);
            this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(52));
            paramBundle = (TroopManager)this.app.getManager(52);
            if (paramBundle != null)
            {
              paramBundle = paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              if ((paramBundle != null) && (paramBundle.isGameBind())) {
                bdaj.a("Grp_game", "Grp_data", "data_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
              }
            }
            this.app.addObserver(this.jdField_a_of_type_Bdqc);
            VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "group_nickname_1", "", 1, 0, 0, "", "", "");
            azmj.b(this.app, "dc00898", "", "", "0X800A523", "0X800A523", 0, 0, "", "", "", "");
            azmj.b(this.app, "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_exp", 0, 0, "", "", "", "");
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
    //   1: iconst_1
    //   2: putfield 3217	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_f_of_type_Boolean	Z
    //   5: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +385 -> 393
    //   11: invokestatic 637	java/lang/System:currentTimeMillis	()J
    //   14: lstore_1
    //   15: ldc 2
    //   17: monitorenter
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 2704	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Boolean	Z
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: getfield 967	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bcws	Lbcws;
    //   30: ifnull +10 -> 40
    //   33: aload_0
    //   34: getfield 967	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bcws	Lbcws;
    //   37: invokevirtual 3218	bcws:d	()V
    //   40: aload_0
    //   41: getfield 991	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bcnc	Lbcnc;
    //   44: ifnull +10 -> 54
    //   47: aload_0
    //   48: getfield 991	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bcnc	Lbcnc;
    //   51: invokevirtual 3219	bcnc:a	()V
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 219	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Ndm	Lndm;
    //   59: invokevirtual 3222	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lalkr;)V
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 202	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Alox	Lalox;
    //   67: invokevirtual 3222	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lalkr;)V
    //   70: aload_0
    //   71: aload_0
    //   72: getfield 207	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Alkl	Lalkl;
    //   75: invokevirtual 3222	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lalkr;)V
    //   78: aload_0
    //   79: aload_0
    //   80: getfield 192	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_Amab	Lamab;
    //   83: invokevirtual 3222	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lalkr;)V
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 187	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Amab	Lamab;
    //   91: invokevirtual 3222	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lalkr;)V
    //   94: aload_0
    //   95: aload_0
    //   96: getfield 144	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_d_of_type_Amab	Lamab;
    //   99: invokevirtual 3222	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lalkr;)V
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 197	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_c_of_type_Amab	Lamab;
    //   107: invokevirtual 3222	com/tencent/mobileqq/activity/ChatSettingForTroop:removeObserver	(Lalkr;)V
    //   110: aload_0
    //   111: getfield 308	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: aload_0
    //   115: getfield 229	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bdqc	Lbdqc;
    //   118: invokevirtual 3223	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lalkr;)V
    //   121: aload_0
    //   122: getfield 182	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   125: ifnull +11 -> 136
    //   128: aload_0
    //   129: getfield 182	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   132: aconst_null
    //   133: invokevirtual 3226	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   136: aload_0
    //   137: getfield 2849	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   140: ifnull +30 -> 170
    //   143: aload_0
    //   144: getfield 2849	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   147: checkcast 2858	android/graphics/drawable/Animatable
    //   150: invokeinterface 3229 1 0
    //   155: ifeq +15 -> 170
    //   158: aload_0
    //   159: getfield 2849	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   162: checkcast 2858	android/graphics/drawable/Animatable
    //   165: invokeinterface 3232 1 0
    //   170: aload_0
    //   171: invokestatic 3237	bcrv:a	(Landroid/content/Context;)Lbcrv;
    //   174: invokevirtual 3238	bcrv:a	()V
    //   177: aload_0
    //   178: getfield 3240	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bepp	Lbepp;
    //   181: ifnull +10 -> 191
    //   184: aload_0
    //   185: getfield 3240	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bepp	Lbepp;
    //   188: invokevirtual 3243	bepp:dismiss	()V
    //   191: aload_0
    //   192: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Nev	Lnev;
    //   195: ifnull +10 -> 205
    //   198: aload_0
    //   199: getfield 468	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Nev	Lnev;
    //   202: invokevirtual 3244	nev:a	()V
    //   205: aload_0
    //   206: aload_0
    //   207: getfield 153	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   210: invokevirtual 3248	com/tencent/mobileqq/activity/ChatSettingForTroop:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   213: aload_0
    //   214: getfield 3089	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   217: ifnull +11 -> 228
    //   220: aload_0
    //   221: getfield 3089	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   224: aconst_null
    //   225: invokevirtual 3226	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   228: aload_0
    //   229: aconst_null
    //   230: putfield 3250	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bdfq	Lbdfq;
    //   233: aload_0
    //   234: getfield 2079	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView	Lcom/tencent/mobileqq/widget/QQBlurView;
    //   237: ifnull +10 -> 247
    //   240: aload_0
    //   241: getfield 2079	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView	Lcom/tencent/mobileqq/widget/QQBlurView;
    //   244: invokevirtual 3252	com/tencent/mobileqq/widget/QQBlurView:c	()V
    //   247: aload_0
    //   248: getfield 3254	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bctc	Lbctc;
    //   251: ifnull +10 -> 261
    //   254: aload_0
    //   255: getfield 3254	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_Bctc	Lbctc;
    //   258: invokevirtual 3257	bctc:f	()V
    //   261: aload_0
    //   262: invokespecial 549	com/tencent/mobileqq/activity/ChatSettingForTroop:H	()V
    //   265: aload_0
    //   266: invokespecial 3259	com/tencent/mobileqq/app/BaseActivity:doOnDestroy	()V
    //   269: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +34 -> 306
    //   275: ldc_w 280
    //   278: iconst_2
    //   279: new 282	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 3261
    //   289: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokestatic 637	java/lang/System:currentTimeMillis	()J
    //   295: lload_1
    //   296: lsub
    //   297: invokevirtual 944	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 701	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: return
    //   307: astore_3
    //   308: ldc 2
    //   310: monitorexit
    //   311: aload_3
    //   312: athrow
    //   313: astore_3
    //   314: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq -104 -> 213
    //   320: ldc_w 280
    //   323: iconst_2
    //   324: new 282	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 3263
    //   334: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_3
    //   338: invokevirtual 3264	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   341: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 1287	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: goto -137 -> 213
    //   353: astore_3
    //   354: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq -144 -> 213
    //   360: ldc_w 280
    //   363: iconst_2
    //   364: new 282	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 283	java/lang/StringBuilder:<init>	()V
    //   371: ldc_w 3263
    //   374: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload_3
    //   378: invokevirtual 3265	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   381: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 1287	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: goto -177 -> 213
    //   393: lconst_0
    //   394: lstore_1
    //   395: goto -380 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	ChatSettingForTroop
    //   14	381	1	l1	long
    //   307	5	3	localObject	Object
    //   313	25	3	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   353	25	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   18	26	307	finally
    //   308	311	307	finally
    //   205	213	313	java/lang/IllegalArgumentException
    //   205	213	353	java/lang/Exception
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    URLDrawable.resume();
    String str1;
    String str2;
    Object localObject;
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      str2 = bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        localObject = "1";
      }
    }
    for (;;)
    {
      bdaj.a("Grp_set_new", "grpData_admin", "exp", 0, 0, new String[] { str1, str2, localObject });
      label83:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) && (bcgx.a(this.app))) {}
      try
      {
        l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        ((alzf)this.app.a(20)).g(l1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
        P();
        N();
        azmj.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F6", 0, 1, 0, "", "", "", "");
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[40] != null) {
          w();
        }
        u();
        v();
        return;
        localObject = "0";
        continue;
        localObject = (bchl)this.app.getManager(109);
        if ((localObject != null) && (((bchl)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
        {
          localObject = (alzf)this.app.a(20);
          if (localObject != null) {
            ((alzf)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, true, this.jdField_j_of_type_Int, 1);
          }
        }
        if (!this.q) {
          break label83;
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
      addObserver(this.jdField_a_of_type_Alox);
      addObserver(this.jdField_a_of_type_Alkl);
      addObserver(this.jdField_a_of_type_Amab);
      addObserver(this.jdField_b_of_type_Amab);
      addObserver(this.jdField_c_of_type_Amab);
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
      removeObserver(this.jdField_a_of_type_Alox);
      removeObserver(this.jdField_a_of_type_Alkl);
      removeObserver(this.jdField_b_of_type_Amab);
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
        StringBuilder localStringBuilder = new StringBuilder().append(alpo.a(2131702107)).append(str);
        if (!bool) {
          break label259;
        }
        localObject = alpo.a(2131702096);
        label85:
        localView.setContentDescription((String)localObject);
      }
      a(localView, new bahs(str, 32).a(), null, null);
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
      str = alpo.a(2131702124);
    }
    label259:
    label266:
    for (;;)
    {
      ((TextView)localObject).setText(str);
      if (AppSetting.jdField_c_of_type_Boolean) {
        ((View)localObject).setContentDescription(alpo.a(2131702091) + str);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateHostTroopNameEntry %s", new Object[] { str }));
      }
      return;
      label249:
      str = alpo.a(2131702134);
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
        if (this.jdField_a_of_type_Beps == null) {
          this.jdField_a_of_type_Beps = new beps(this);
        }
        this.jdField_a_of_type_Beps.a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.isEmpty(paramIntent)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopOwner(paramIntent, this.app.getCurrentAccountUin());
        }
        X();
        F();
        if (this.jdField_a_of_type_Beps == null) {
          this.jdField_a_of_type_Beps = new beps(this);
        }
        this.jdField_a_of_type_Beps.a(1, str, 1000);
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
      if (this.jdField_a_of_type_Acmb == null)
      {
        this.jdField_a_of_type_Acmb = new acmb(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Acmb);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Acmb.notifyDataSetChanged();
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
      alzf localalzf = (alzf)this.app.a(20);
      if (localalzf != null) {
        localalzf.a(true, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode, 6);
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
      bcgk.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "troopProfile");
      azmj.b(this.app, "P_CliOper", "Grp_edu", "", "Grp_data", "mbercard_Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
    }
    for (;;)
    {
      azmj.b(this.app, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "Clk_modifydata", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
      bdaj.a("Grp_set_new", "grpData_admin", "clk_modifydata", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
      VasWebviewUtil.reportCommercialDrainage(this.app.c(), "group_nickname", "group_nickname_2", "", 1, 0, 0, "", "", "");
      return;
      i1 = 0;
      break;
      label199:
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick;
      Intent localIntent = new Intent(this, EditInfoActivity.class);
      localIntent.putExtra("edit_type", 0);
      localIntent.putExtra("title", getString(2131698002));
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
        azmj.b(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "0", (String)localObject, "");
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
      azmj.b(this.app, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
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
    azmj.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
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
    alzf localalzf = (alzf)this.app.a(20);
    if (localalzf == null) {
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
        localalzf.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1000L);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break label127;
        }
        localalzf.c(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
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
        bclo.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
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
      if (this.jdField_a_of_type_Bepp == null)
      {
        this.jdField_a_of_type_Bepp = new bepp(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_Bepp.c(2131695088);
        this.jdField_a_of_type_Bepp.c(false);
      }
      this.jdField_a_of_type_Bepp.show();
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
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof Integer)) {
      return;
    }
    switch (((Integer)paramCompoundButton).intValue())
    {
    default: 
      return;
    case 7: 
      f(paramBoolean);
      return;
    case 19: 
      h(paramBoolean);
      return;
    case 10: 
      g(paramBoolean);
      return;
    }
    a(1, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && ((localObject1 instanceof Integer))) {
        i1 = ((Integer)localObject1).intValue();
      }
    }
    boolean bool;
    Object localObject2;
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
    case 1002: 
    case 5: 
    case 1004: 
    case 1005: 
    case 1003: 
    case 11: 
    case 17: 
    case 40: 
    case 18: 
    case 41: 
    case 23: 
    case 27: 
    case 29: 
    case 30: 
    case 1007: 
    case 1009: 
    case 14: 
      Object localObject3;
      Object localObject4;
      do
      {
        do
        {
          long l1;
          do
          {
            do
            {
              return;
              localObject1 = paramView.getTag();
              break;
              if ((aoql.c().mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
              {
                bool = alzw.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
                if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
                {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
                  if (bool)
                  {
                    i1 = 15;
                    localObject2 = VipUtils.a(0, i1).toString();
                    localObject3 = alpo.a(2131702106);
                    localObject4 = new acky(this, bool);
                    if (!bool) {
                      break label497;
                    }
                    paramView = "0X800A57F";
                    if (!bool) {
                      break label504;
                    }
                    i1 = 1;
                    VipUtils.a(this, (String)localObject1, (String)localObject2, (String)localObject3, (DialogInterface.OnClickListener)localObject4, paramView, i1, bool);
                  }
                }
                for (;;)
                {
                  azmj.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 3, 0, "", "", "", "");
                  return;
                  i1 = 8;
                  break;
                  paramView = "0X8009E38";
                  break label434;
                  i1 = 3;
                  break label441;
                  VipUtils.a(this, bool);
                }
              }
              J();
              return;
              h();
              return;
              i();
              a("Grp_Admin_data", "Clk_mber", "");
              bdaj.a("Grp_set_new", "grpData_admin", "clk_mber", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
              return;
              g();
              bdaj.a("Grp_set_new", "grpData_admin", "clk_invite_new", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
              return;
              paramView = paramView.getTag(2131377384);
            } while (!(paramView instanceof String));
            paramView = (String)paramView;
            if (((bckx)this.app.getManager(203)).b(paramView))
            {
              bcgx.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramView);
              return;
            }
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("selfSet_leftViewText", getString(2131721064));
            ((Bundle)localObject1).putString("custom_leftbackbutton_name", getTitle().toString());
            awnk.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramView, 1, -1, (Bundle)localObject1);
            return;
            paramView = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
            localObject1 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
            ((Intent)localObject1).putExtra("url", paramView);
            startActivity((Intent)localObject1);
            azmj.b(this.app, "dc00899", "Grp_certified", "", "data", "clk_data", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum) {
              this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {}
            for (i1 = 0;; i1 = 1)
            {
              paramView = new Intent(this, PublicAccountBrowser.class);
              paramView.putExtra("hide_operation_bar", true);
              paramView.putExtra("hideRightButton", true);
              paramView.putExtra("isScreenOrientationPortrait", true);
              paramView.putExtra("uin", this.app.getCurrentAccountUin());
              paramView.putExtra("url", "https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum + "&show_level=" + i1);
              startActivity(paramView);
              azmj.b(this.app, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
              nco.a(this.app, 72);
              return;
            }
            G();
            bdaj.a("Grp_msg", "grpData_admin", "Clk_msgSet", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            return;
            ChatHistoryActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1001);
            azmj.b(this.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_chatrecord", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            bdaj.a("Grp_set_new", "grpData_admin", "clk_chatRecord", 1, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            azmj.b(this.app, "dc00898", "", "", "0X800A0B8", "0X800A0B8", 0, 0, "", "", "", "");
            return;
            paramView = new Intent();
            paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            paramView.putExtra("uintype", 1);
            MessageNotificationSettingFragment.a(this, paramView);
            return;
            paramView = TroopMemberListActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 19);
            paramView.putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum);
            startActivityForResult(paramView, 9);
            paramView = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.app.getCurrentAccountUin());
            bdaj.a("Grp_edu", "Grp_data", "teachermsg_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(paramView) });
            return;
            QQToast.a(this, alpo.a(2131702100), 0).a();
            paramView = new Bundle();
            paramView.putString("extra.GROUP_UIN", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
            EntryDebugFragment.a(this, paramView);
            return;
            d(false);
            if (this.jdField_h_of_type_Int == 2) {
              azmj.b(this.app, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            }
            i1 = getIntent().getIntExtra("extra_share_group_from", 0);
            if (i1 != 0) {
              wta.a("story_grp", "clk_msg", i1, 0, new String[0]);
            }
            paramView = this.app;
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
            for (i1 = 1;; i1 = 2)
            {
              azmj.b(paramView, "dc00898", "", "", "0X800A526", "0X800A526", i1, 0, bclo.a() + "", "", "", "");
              return;
            }
            bclo.a("RED_POINT_KEY_TROOP_ADMIN");
            if (this.o) {
              bclo.a("RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_" + this.app.getCurrentAccountUin());
            }
            bclo.a(false, (TextView)paramView.findViewById(2131375735));
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
            ((Intent)localObject2).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            ((Intent)localObject2).putExtra("forward_location", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
            ((Intent)localObject2).putExtra("forward_latitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat);
            ((Intent)localObject2).putExtra("forward_longitude", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon);
            ((Intent)localObject2).putExtra("forward_cityid", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId);
            ((Intent)localObject2).putExtra("troop_auth_submit_time", this.jdField_i_of_type_Int);
            ((Intent)localObject2).putExtra("leftViewText", getResources().getString(2131690795));
            ((Intent)localObject2).putExtra("key_qidian_private_troop", this.jdField_d_of_type_Boolean);
            ((Intent)localObject2).putExtra("key_is_update_before_805", bclo.a(this, "8.0.5"));
            ((Intent)localObject2).putExtra("key_support_troop_honor", ((bcbt)this.app.getManager(346)).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin));
            bool = false;
            if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
              bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isKingBattleTroop();
            }
            ((Intent)localObject2).putExtra("key_customed_troop", bool);
            if (bool) {
              aact.a(null, "846", "205605", "", "84601", "1", "145");
            }
            localObject1 = this.jdField_a_of_type_Aonu;
            paramView = (View)localObject1;
            if (localObject1 == null)
            {
              paramView = aonv.a();
              this.jdField_a_of_type_Aonu = paramView;
            }
            ((Intent)localObject2).putExtra("autoApprovalUrl", paramView.jdField_b_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("frequencyLimitVisible", paramView.jdField_a_of_type_Boolean);
            ((Intent)localObject2).putExtra("key_is_need_update_Group_info", true);
            if (!bclo.a(getBaseContext(), this.app))
            {
              i1 = 1;
              if (i1 != 0)
              {
                bclo.a(getBaseContext(), this.app);
                ((Intent)localObject2).putExtra("troop_manage_history_for_newer_red_need", true);
              }
              if ((QLog.isDevelopLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
                QLog.i("TroopMngTest", 4, String.format("start troop mng [flag: %s, msgLimitFreq: %s]", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupFlagExt3 & 0x100000), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.nMsgLimitFreq) }));
              }
              ((Intent)localObject2).putExtra("troop_manager_edit_red_show", c());
              ((Intent)localObject2).putExtra("troop_manager_edit_current_uin", this.app.c());
              paramView = TroopBaseProxyActivity.a(this);
              localObject1 = new bjyi(this.app);
              localObject3 = PluginCommunicationHandler.getInstance();
              if (localObject3 != null) {
                ((PluginCommunicationHandler)localObject3).register((RemoteCommand)localObject1);
              }
              TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.jdField_j_of_type_JavaLangString, TroopManageProxyActivity.class, this, (Intent)localObject2, paramView, "com.tencent.mobileqq.activity.TroopManageActivity", this.app.getCurrentAccountUin(), 8);
              localObject1 = this.app;
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
              if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
                break label2275;
              }
            }
            for (paramView = "0";; paramView = "1")
            {
              azmj.b((QQAppInterface)localObject1, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, (String)localObject2, paramView, "", "");
              bdaj.a("Grp_set_new", "grpData_admin", "clk_manageGrp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
              return;
              i1 = 0;
              break;
            }
            azmj.b(this.app, "P_CliOper", "Grp_payjoin", "", "join_grp", "Clk_data", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            ahla.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
            return;
            bclo.a(this.app, this, getIntent(), this);
            azmj.b(this.app, "CliOper", "", "", "0x80084B4", "0x80084B4", 0, 0, "", "", "", "");
            bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
            return;
            paramView = this.app;
            if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
            for (i1 = 1;; i1 = 2)
            {
              azmj.b(paramView, "dc00898", "", "", "0X800A527", "0X800A527", i1, 0, bclo.a() + "", "", "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 34) {
                break label2610;
              }
              if (!apwx.a(this.app.getCurrentAccountUin())) {
                break label2574;
              }
              paramView = aqdo.a(this);
              if (isFinishing()) {
                break;
              }
              paramView.show();
              azmj.b(this.app, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
              return;
            }
            azmj.b(this.app, "dc00898", "", "", "0X80092D7", "0X80092D7", 0, 0, "", "", "", "");
            bclo.a(false, null);
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop())
              {
                d(1);
                return;
              }
              M();
              return;
            }
            bclo.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, bclo.jdField_a_of_type_Int, this.jdField_l_of_type_Int, 2);
            if (!bdee.d(this))
            {
              a(2131694764, 1);
              return;
            }
            paramView = (alzf)this.app.a(20);
            if (paramView != null) {}
            try
            {
              l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
              o();
              paramView.a(l1, 8390784);
              if (super.getIntent().getBooleanExtra("from_babyq", false)) {
                azmj.b(this.app, "dc00898", "", "", "0X8007246", "0X8007246", 0, 0, "", "", "", "");
              }
              bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
              return;
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("Q.chatopttroop", 2, paramView.toString());
                }
              }
            }
            j();
            return;
            bclo.a(this, this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 6);
            azmj.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
            azmj.b(this.app, "dc00899", "Grp_set", "", "Grp_data", "Set_chatBG", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", "", "");
            bdaj.a("Grp_set_new", "grpData_admin", "set_chatBG", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
            return;
            localObject1 = (bdsm)((FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[40]).getTag(2131374133);
            if (localObject1 == null) {
              break label3212;
            }
            l1 = ((bdsm)localObject1).jdField_a_of_type_Long;
            ((bdsm)localObject1).jdField_a_of_type_Long = SystemClock.uptimeMillis();
          } while (((bdsm)localObject1).jdField_a_of_type_Long < l1 + 1000L);
          bdwk.a(this.app, "troop_keyword_expire_list_" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, ((bdsm)localObject1).jdField_b_of_type_JavaLangString);
          bdwk.b(this.app, "troop_keyword_guide_clicked", true);
          paramView = bdox.a("groupkeywords").replace("[groupid]", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop.troop.special_msg.keyword", 2, "onClick: " + paramView);
          }
          azmj.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "qq_vip", "0X800A8F8", ((bdsm)localObject1).jdField_c_of_type_Int, 1, 0, "", "", "", "");
          localObject1 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
          ((Intent)localObject1).putExtra("url", paramView);
          ((Intent)localObject1).putExtra("isShowAd", false);
          startActivity((Intent)localObject1);
          return;
          QLog.e("Q.chatopttroop.troop.special_msg.keyword", 1, "onClick status is null");
          return;
          paramView = new Intent(this, QQBrowserActivity.class);
          localObject1 = bdox.a("troopEnterEffect");
          paramView.putExtra("url", (String)localObject1 + "&gc=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          startActivityForResult(paramView, 15);
          bbqh.a("grp_data", "entry_clk", new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          i1 = ((bbqh)this.app.getManager(231)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          VasWebviewUtil.reportCommercialDrainage(this.app.c(), "style", "0X8008E62", "", 1, 0, 0, "", Integer.toString(i1), "");
          return;
          paramView = new Intent();
          paramView.putExtra("leftViewText", getString(2131696678));
          paramView.putExtra("trooptype", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt);
          paramView.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
          paramView.putExtra("isManagerPage", false);
          paramView.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
          adky.a(this, paramView, PublicFragmentActivity.class, TroopShortcutbarFragment.class, 18);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin != null)) {
            this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
          }
          paramView = TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
          paramView.putBoolean("troop_info_from_troopsetting", true);
          paramView.putInt("exposureSource", 1);
          bclo.a(this, paramView, 2);
          paramView = this.app;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
          for (i1 = 1;; i1 = 2)
          {
            azmj.b(paramView, "dc00898", "", "", "0X800A524", "0X800A524", i1, 0, "", "", "", "");
            return;
          }
          paramView = new beko(this, this.app, false);
          paramView.a(new ackz(this));
          paramView.a(2);
          bdaj.a("Grp_set_new", "grpData_admin", "clk_delRecord", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
          return;
          localObject2 = paramView.getTag(2131377396);
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop", 2, "troop app item click type=" + paramView.getId() + ", url=" + localObject2);
          }
          localObject3 = (oidb_0xaf4.TabInfo)paramView.getTag(2131377369);
          if (bclo.a(paramView, (oidb_0xaf4.TabInfo)localObject3))
          {
            localObject1 = null;
            if (((oidb_0xaf4.TabInfo)localObject3).red_point.get() != 0)
            {
              localObject1 = (String)paramView.getTag(2131377392);
              nxu.a(this, (String)localObject1, 2);
              if ((localObject3 != null) && (((oidb_0xaf4.TabInfo)localObject3).red_point.get() != 0)) {
                if ((paramView instanceof TroopAppFormItem))
                {
                  paramView = (TroopAppFormItem)paramView;
                  if (((oidb_0xaf4.TabInfo)localObject3).appid.get() != 1106837471L) {
                    break label4187;
                  }
                  paramView.d();
                }
              }
            }
          }
          for (;;)
          {
            ((alzf)this.app.a(20)).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, ((oidb_0xaf4.TabInfo)localObject3).appid.get());
            ((oidb_0xaf4.TabInfo)localObject3).red_point.set(0);
            bclo.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, ((oidb_0xaf4.TabInfo)localObject3).appid.get());
            if (i1 != 30) {
              break label4194;
            }
            bckr.a(this.app, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1106611799);
            this.jdField_j_of_type_Int = ((int)NetConnInfoCenter.getServerTime());
            ThreadManager.post(new ChatSettingForTroop.27(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin), 5, null, false);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(19);
            bdaj.a("Grp_game", "Grp_data", "feeds_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
            return;
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              break;
            }
            localObject1 = "{\"tags\":" + this.jdField_a_of_type_JavaLangString + "}";
            break;
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject1 = localObject2;
              if (((oidb_0xaf4.TabInfo)localObject3).appid.get() == 1106837471L) {
                localObject1 = (String)paramView.getTag(2131377392);
              }
            }
            if ((!(localObject1 instanceof String)) || (TextUtils.isEmpty((String)localObject1))) {
              break label3765;
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("uin", this.app.getCurrentAccountUin());
            ((Bundle)localObject2).putString("gc", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
            ((Bundle)localObject2).putBoolean("isAdmin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
            if (auak.a(this, (String)localObject1, (Bundle)localObject2))
            {
              if (!QLog.isColorLevel()) {
                break label3765;
              }
              QLog.d("Q.chatopttroop", 2, "mini app jump handled");
              break label3765;
            }
            localObject2 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", (String)localObject1);
            startActivity((Intent)localObject2);
            break label3765;
            paramView.c();
          }
          if (i1 == 29)
          {
            bdaj.a("Grp_game", "Grp_data", "rank_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
            return;
          }
        } while ((i1 != 1007) || (localObject3 == null) || (((oidb_0xaf4.TabInfo)localObject3).appid.get() != 1106837471L));
        bdaj.a("Grp_set", "Grp_aio_subscription", "subscription_clk", 1, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin) });
        return;
        if (this.n)
        {
          bcgx.a(this.app, false);
          this.jdField_a_of_type_Bcnc.a(false);
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop", 2, "setRobotItemRedDotShowed");
          }
        }
        azmj.b(this.app, "dc00898", "", "", "", "0X8009F9C", 0, 0, "", "", "", "");
        bclo.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.allowMemberModifTroopName == 1))
      {
        i1 = 1;
        if ((i1 == 0) || (!aoql.c().mIsEnable) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed != 1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) {
          break label4609;
        }
        bool = alzw.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label4600;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!bool) {
          break label4584;
        }
        i1 = 15;
        localObject2 = VipUtils.a(0, i1).toString();
        localObject3 = alpo.a(2131702093);
        localObject4 = new acla(this, bool);
        if (!bool) {
          break label4590;
        }
        paramView = "0X800A57F";
        if (!bool) {
          break label4597;
        }
        VipUtils.a(this, (String)localObject1, (String)localObject2, (String)localObject3, (DialogInterface.OnClickListener)localObject4, paramView, 1, bool);
      }
      for (;;)
      {
        azmj.b(null, "dc00898", "", "", "qq_vip", "0X8009E37", 1, 0, "", "", "", "");
        return;
        i1 = 0;
        break;
        i1 = 8;
        break label4485;
        paramView = "0X8009E38";
        break label4524;
        break label4529;
        VipUtils.a(this, bool);
      }
      int i2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = "";
        }
        if ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
          break label4919;
        }
        i2 = 1;
        localObject2 = new Intent(this, EditInfoActivity.class);
        ((Intent)localObject2).putExtra("edit_type", 2);
        if (i1 == 0) {
          break label4924;
        }
        paramView = alpo.a(2131702112);
        ((Intent)localObject2).putExtra("title", paramView);
        ((Intent)localObject2).putExtra("default_text", (String)localObject1);
        ((Intent)localObject2).putExtra("max_num", 96);
        ((Intent)localObject2).putExtra("canPostNull", false);
        if (i1 == 0) {
          break label4934;
        }
        paramView = alpo.a(2131702097);
        ((Intent)localObject2).putExtra("right_btn", paramView);
        ((Intent)localObject2).putExtra("isTroopName", true);
        if (i1 == 0) {
          break label4941;
        }
        bool = true;
        ((Intent)localObject2).putExtra("edit_mode", bool);
        if (i2 == 0) {
          break label4947;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        ((Intent)localObject2).putExtra("troopUin", paramView);
        startActivityForResult((Intent)localObject2, 16);
        bdaj.a("Grp_set_new", "grpData_admin", "clk_editInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bdaj.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
        localObject1 = this.app;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label4954;
        }
        paramView = "0";
      }
      for (;;)
      {
        azmj.b((QQAppInterface)localObject1, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_name", 0, 0, (String)localObject2, "0", paramView, "");
        return;
        paramView = "";
        break;
        i2 = 0;
        break label4658;
        paramView = alpo.a(2131702111);
        break label4692;
        paramView = "";
        break label4745;
        bool = false;
        break label4772;
        paramView = "";
        break label4795;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
          paramView = "1";
        } else {
          paramView = "2";
        }
      }
    case 25: 
      try
      {
        if (this.jdField_a_of_type_Bctc != null) {
          this.jdField_a_of_type_Bctc.f();
        }
        this.jdField_a_of_type_Bctc = new bctc(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        this.jdField_a_of_type_Bctc.g();
      }
      catch (NullPointerException paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) {
            paramView = "1";
          } else {
            paramView = "2";
          }
        }
      }
      localObject1 = this.app;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner)
      {
        paramView = "0";
        azmj.b((QQAppInterface)localObject1, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_num", 0, 0, (String)localObject2, "0", paramView, "");
        return;
      }
    case 32: 
      ((bcbt)this.app.getManager(346)).a();
      paramView = (FormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[32];
      if (paramView != null) {
        paramView.setRightIcon(null);
      }
      paramView = bckj.a().a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1);
      localObject1 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramView);
      startActivity((Intent)localObject1);
      azmj.b(null, "dc00898", "", "", "0X800A6EF", "0X800A6EF", 0, 0, "", "", "", "");
      return;
    case 38: 
      paramView = (baky)this.app.getManager(339);
      bool = paramView.a(4, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localObject1 = ball.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      if (bool) {
        paramView.b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 4, 2, (Bundle)localObject1);
      }
      for (;;)
      {
        ball.a(this.app, "SP_KEY_SING_TOGETHER_TROOP_RED_DOT_SHOW", false, false);
        paramView.a("sing_tab", "clk_setsing", 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        v();
        return;
        paramView.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 4, 2, (Bundle)localObject1);
      }
    case 16: 
      label434:
      label441:
      label497:
      label504:
      paramView = (aono)aogj.a().a(535);
      label2275:
      label4584:
      label4590:
      label4597:
      label4600:
      if ((paramView == null) || (paramView.jdField_a_of_type_Aooh == null))
      {
        QQToast.a(this, 0, 2131693336, 0).a();
        return;
      }
      label2574:
      label2610:
      label3765:
      label4187:
      label4194:
      localObject1 = (baky)this.app.getManager(339);
      label3212:
      label4524:
      label4529:
      label4658:
      label4692:
      label4954:
      bool = ((baky)localObject1).a(2, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      label4485:
      label4745:
      label4772:
      label4795:
      label4924:
      label4934:
      label4941:
      label4947:
      localObject2 = ball.a(bool, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2);
      label4609:
      label4919:
      switch (paramView.jdField_a_of_type_Aooh.a())
      {
      default: 
        if (((baky)localObject1).a(this, 2, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 2)) {
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(2) });
          }
        }
        break;
      }
      for (;;)
      {
        ball.a(this.app, "SP_KEY_WATCH_TOGETHER_TROOP_RED_DOT_SHOW", false, false);
        u();
        return;
        QQToast.a(this, 0, 2131693336, 0).a();
        continue;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
        {
          if (bool) {
            ((baky)localObject1).b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject2);
          } else {
            ((baky)localObject1).a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject2);
          }
        }
        else if (bool)
        {
          ((baky)localObject1).b(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject2);
        }
        else
        {
          ((baky)localObject1).a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1, 2, 2, (Bundle)localObject2);
          continue;
          ((baky)localObject1).a("video_tab", "clk_setvideo", 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          ball.a(this.app, paramView.jdField_a_of_type_Aooh.b(), paramView.jdField_a_of_type_Aooh.a(), paramView.jdField_a_of_type_Aooh.b(), (Bundle)localObject2, 1);
        }
      }
    }
    if (this.jdField_a_of_type_Bctc != null) {
      this.jdField_a_of_type_Bctc.f();
    }
    this.jdField_a_of_type_Bctc = bclo.a(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.app);
    paramView = this.app;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
    for (int i1 = 1;; i1 = 2)
    {
      azmj.b(paramView, "dc00898", "", "", "0X800A525", "0X800A525", i1, 0, bclo.a() + "", "", "", "");
      return;
    }
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
      if ((localObject != null) && ((localObject instanceof acqa)))
      {
        localObject = (acqa)localObject;
        if (paramString != null) {
          break label129;
        }
        a((acqa)localObject, null, false);
      }
    }
    label129:
    while (!paramString.equals(((acqa)localObject).jdField_a_of_type_JavaLangString))
    {
      paramInt1 += 1;
      break label72;
      break;
    }
    ((acqa)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void p()
  {
    try
    {
      if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
        this.jdField_a_of_type_Bepp.dismiss();
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
      bcrv.a(localContext).a(str, null);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_Bdfq != null)
    {
      if (!this.jdField_a_of_type_Bdfq.isShowing()) {
        this.jdField_a_of_type_Bdfq.show();
      }
      return;
    }
    this.jdField_a_of_type_Bdfq = bdcd.a(this, 230);
    this.jdField_a_of_type_Bdfq.setMessage(2131695720);
    this.jdField_a_of_type_Bdfq.setTitle(2131692310);
    aclr localaclr = new aclr(this);
    this.jdField_a_of_type_Bdfq.setNegativeButton(2131690648, localaclr);
    this.jdField_a_of_type_Bdfq.setPositiveButton(2131695690, localaclr);
    this.jdField_a_of_type_Bdfq.show();
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
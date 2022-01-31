package com.tencent.mobileqq.activity.aio.rebuild;

import aanz;
import actd;
import acte;
import actj;
import acup;
import acyn;
import adgj;
import adhl;
import adia;
import adiw;
import adje;
import adji;
import adjl;
import adjp;
import aede;
import aedj;
import aedx;
import aemd;
import aetw;
import aetx;
import aety;
import aetz;
import aeua;
import aeub;
import aeuc;
import aeud;
import aeue;
import aeuf;
import aeuh;
import aeui;
import aeuj;
import aeuk;
import aeul;
import aeum;
import aeun;
import aeuo;
import aeup;
import aeuq;
import aeur;
import aeus;
import aeut;
import aeuu;
import aeuv;
import aeuw;
import aeux;
import aeuy;
import aeuz;
import aeva;
import aexl;
import aexw;
import aeya;
import aeyc;
import aeyv;
import aeyz;
import aeza;
import aezd;
import ajcm;
import ajey;
import ajpx;
import ajsx;
import ajsy;
import ajxj;
import ajya;
import akat;
import akfv;
import akfy;
import akhp;
import akil;
import akit;
import akpb;
import akpx;
import amnn;
import amom;
import ampl;
import amwi;
import amze;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.LruCache;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import aqui;
import arty;
import aruh;
import asfd;
import avbt;
import axmv;
import axqy;
import axrc;
import axug;
import ayfn;
import aylc;
import aytn;
import azjs;
import azjv;
import azjx;
import azmr;
import azmw;
import azne;
import azni;
import azno;
import azrn;
import azrw;
import azry;
import azvl;
import azvm;
import baas;
import badm;
import badx;
import baec;
import bafm;
import bafv;
import bahf;
import baiy;
import bajo;
import bajt;
import bajx;
import bale;
import balu;
import bame;
import bamk;
import banb;
import baql;
import baqr;
import baro;
import basl;
import batg;
import batp;
import batr;
import baxn;
import bbbp;
import bbbr;
import bbbw;
import bbcf;
import bbcz;
import bbdj;
import bbgu;
import bbkb;
import bbkj;
import bbkk;
import bbwo;
import bcqf;
import bcql;
import bded;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.confess.ConfessPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable;
import com.tencent.mobileqq.troop.widget.FloatView;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import lnn;
import mqq.os.MqqHandler;
import myb;
import myd;
import myf;
import myg;
import nbz;
import ncc;
import org.json.JSONArray;
import org.json.JSONException;
import tcw;
import tcz;
import tdl;
import vwn;
import vzl;
import wzt;
import xbl;
import xbm;

public class TroopChatPie
  extends aemd
{
  acte jdField_a_of_type_Acte = new aeuv(this);
  public aexl a;
  public aexw a;
  aeya jdField_a_of_type_Aeya;
  public aeyc a;
  aeyz jdField_a_of_type_Aeyz;
  aeza jdField_a_of_type_Aeza;
  aezd jdField_a_of_type_Aezd;
  ajsy jdField_a_of_type_Ajsy = new aeuf(this);
  private final ajxj jdField_a_of_type_Ajxj = new aetw(this);
  protected akat a;
  akfy jdField_a_of_type_Akfy = new aety(this);
  akil jdField_a_of_type_Akil = new aetx(this);
  akit jdField_a_of_type_Akit = new aeui(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Handler jdField_a_of_type_AndroidOsHandler;
  public ScrollView a;
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  ayfn jdField_a_of_type_Ayfn = new aeut(this);
  private azjv jdField_a_of_type_Azjv;
  protected azrn a;
  private azvm jdField_a_of_type_Azvm;
  bajx jdField_a_of_type_Bajx;
  protected baqr a;
  protected basl a;
  public batg a;
  protected batr a;
  protected ConfessPanel a;
  TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable;
  FloatView jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
  private Observer jdField_a_of_type_JavaUtilObserver = new aeup(this);
  myf jdField_a_of_type_Myf;
  public myg a;
  nbz jdField_a_of_type_Nbz;
  ncc jdField_a_of_type_Ncc = new aeuh(this);
  wzt jdField_a_of_type_Wzt = null;
  boolean aa = false;
  public boolean ab;
  boolean ac;
  public boolean ad;
  boolean ae = false;
  public boolean af = false;
  protected boolean ag;
  boolean ah = false;
  boolean ai = true;
  boolean aj = false;
  boolean ak = false;
  boolean al = false;
  public boolean am;
  private boolean an;
  private boolean ao;
  private boolean ap;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  public Handler b;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  Runnable jdField_b_of_type_JavaLangRunnable;
  protected List<aeuz> b;
  public LinearLayout c;
  protected bbgu c;
  Runnable c;
  public bbgu d;
  Runnable d;
  private Runnable e;
  public volatile long h;
  public String i;
  String j;
  public View o;
  View p;
  protected int q;
  public View q;
  public int r;
  public View r;
  public int s;
  protected int t = 0;
  int u = 0;
  
  public TroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_r_of_type_Int = 2;
    this.jdField_c_of_type_JavaLangRunnable = new TroopChatPie.2(this);
    this.jdField_b_of_type_AndroidOsHandler = new aetz(this, Looper.getMainLooper());
    this.jdField_a_of_type_Akat = new aeuo(this);
    this.jdField_e_of_type_JavaLangRunnable = new TroopChatPie.37(this);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_d_of_type_JavaLangRunnable = new TroopChatPie.38(this);
  }
  
  private void D(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "inputing @ in TroopChatPie.");
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localTroopInfo != null)
    {
      localObject1 = TroopMemberListActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localTroopInfo.troopuin, 3);
      ((Intent)localObject1).putExtra("param_is_pop_up_style", true);
      ((Intent)localObject1).setFlags(603979776);
      if (this.V)
      {
        ((Intent)localObject1).putExtra("param_chat_mode", 1);
        bool = H();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open TroopMemberListActivity, needfilterrobot:" + bool);
        }
        if (bool) {
          ((Intent)localObject1).putExtra("param_filter_robot", true);
        }
        if (super.f() == 21) {
          ((Intent)localObject1).putExtra("param_troop_send_apollo_msg", true);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open TroopMemberListActivity to choose @ user target.");
        }
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)localObject1, 6001);
        if (paramInt != 1) {
          break label207;
        }
      }
    }
    label207:
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      for (;;)
      {
        boolean bool;
        return;
        ((Intent)localObject1).putExtra("param_chat_mode", 0);
      }
      String str1 = "2";
      for (;;)
      {
        String str2;
        try
        {
          str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          if ((localTroopInfo.troopowneruin == null) || (!localTroopInfo.troopowneruin.equals(str2))) {
            break label303;
          }
          localObject1 = "0";
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, localTroopInfo.troopuin, "2", (String)localObject1, "");
          return;
        }
        catch (Exception localException) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onTextChanged() has an exception.", localException);
        return;
        Object localObject2 = str1;
        if (localTroopInfo.Administrator != null)
        {
          localObject2 = str1;
          if (localTroopInfo.Administrator.contains(str2)) {
            localObject2 = "1";
          }
        }
      }
    }
    label303:
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onTextChanged(). troopInfo is null. while inputing @.  troopUin is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  private boolean H()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    bamk localbamk = (bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    }
    if (localObject == null)
    {
      bool2 = bool1;
      return bool2;
    }
    localObject = (bafv[])((Editable)localObject).getSpans(0, localObject.toString().length(), bafv.class);
    int k = 0;
    for (;;)
    {
      bool1 = bool2;
      if (k < localObject.length)
      {
        if (localbamk.b(localObject[k].a())) {
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "needFilterRobot : " + bool1);
        return bool1;
      }
      k += 1;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clearBAFGrayTipSP troopUin=" + paramString1);
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    paramString1 = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", paramString2, paramString1 });
    localSharedPreferences.edit().putLong(paramString1, 0L).apply();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool1;
    boolean bool2;
    label191:
    label255:
    do
    {
      return;
      batp localbatp = (batp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234);
      String str = localbatp.a(paramString);
      bool1 = ((aruh)a(33)).c();
      bool2 = ((adji)a(43)).c();
      if ((!this.V) && (!bool1) && (!bool2) && (!TextUtils.isEmpty(str)))
      {
        if (this.t != 2)
        {
          A(2);
          if (paramBoolean)
          {
            if (localbatp.a(paramString) != 3) {
              break label191;
            }
            bbbp.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { paramString });
          }
        }
        for (;;)
        {
          c(true);
          this.jdField_f_of_type_AndroidWidgetTextView.setText(str);
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
          if (this.jdField_a_of_type_Batg == null) {
            break label255;
          }
          this.jdField_a_of_type_Batg.a(paramString);
          if (!this.jdField_a_of_type_Batg.a()) {
            break;
          }
          this.jdField_a_of_type_Batg.d();
          v(true);
          return;
          new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        }
        v(false);
        return;
        v(false);
        return;
      }
    } while ((this.V) || (bool1) || (bool2));
    c(false);
    this.jdField_f_of_type_AndroidWidgetTextView.setText("");
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void bG()
  {
    ThreadManager.post(new TroopChatPie.6(this), 5, null, true);
  }
  
  private void bH()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, String.format("updateTroopHonorInteractiveIcon, troopUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
    }
    badm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_f_of_type_AndroidWidgetImageView, this.L);
  }
  
  private void bI()
  {
    this.jdField_a_of_type_Azjv = new aeuj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azjv);
  }
  
  private void bJ()
  {
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130845305));
    }
    for (;;)
    {
      axmv.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.mSystemBarComp, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
      return;
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166910), true);
    }
  }
  
  private void bK()
  {
    if ((bbbr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (bbbr.a(this.jdField_a_of_type_AndroidContentContext))) {}
    TroopManager localTroopManager;
    Intent localIntent;
    do
    {
      return;
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localIntent = new Intent();
      localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localTroopManager != null) && (localTroopManager.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b)));
    banb.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent.getExtras(), 1, 2000);
  }
  
  private void bL()
  {
    if ((this.jdField_a_of_type_Batg != null) && (this.jdField_a_of_type_Batg.a()))
    {
      if (this.jdField_a_of_type_Batg.a() == 2)
      {
        c(false);
        A(0);
      }
    }
    else {
      return;
    }
    t(false);
  }
  
  private void bM()
  {
    if (A()) {
      return;
    }
    if (this.jdField_a_of_type_Aeya == null) {
      this.jdField_a_of_type_Aeya = new aeya(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_Aeya.a(this.jdField_a_of_type_Aeyv);
  }
  
  private void bN()
  {
    if (this.ap) {
      return;
    }
    ((amnn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.ap = true;
  }
  
  private void g(String paramString)
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_j_of_type_JavaLangString = paramString;
    ThreadManager.getSubThreadHandler().post(this.jdField_d_of_type_JavaLangRunnable);
  }
  
  private void h(Intent paramIntent)
  {
    this.ap = false;
    String str = paramIntent.getStringExtra("uin");
    this.ae = ((amnn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b(str, paramIntent);
  }
  
  private void v(boolean paramBoolean)
  {
    if ((!this.ao) && (!paramBoolean) && (this.t == 2)) {
      t(false);
    }
  }
  
  private void w(boolean paramBoolean)
  {
    this.X = paramBoolean;
  }
  
  public void A(int paramInt)
  {
    this.t = paramInt;
    if ((this.jdField_h_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_AndroidViewViewGroup == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "changeSubTitleType, not init ui");
      }
      return;
    }
    if (paramInt == 3)
    {
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      return;
    }
    if (paramInt == 4)
    {
      if (((adji)a(43)).d()) {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
        return;
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    if (paramInt == 2)
    {
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      return;
    }
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
  }
  
  void B(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOshortcut", "Clk_shortcut", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1, "", "");
      }
      return;
      localObject1 = "1";
      continue;
      localObject1 = "2";
      continue;
      localObject1 = "3";
      continue;
      localObject1 = "4";
      continue;
      localObject1 = "5";
      continue;
      localObject1 = "7";
    }
  }
  
  public void C(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
      ((akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt, 0);
    }
  }
  
  public boolean E()
  {
    return false;
  }
  
  public void F()
  {
    super.F();
    bM();
  }
  
  public void G()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(true);
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.ac = false;
    this.ab = false;
    if (this.jdField_a_of_type_Azrn != null) {
      this.jdField_a_of_type_Azrn.e();
    }
    if (this.N) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
    }
    for (;;)
    {
      return;
      if (this.ae) {
        bN();
      }
      ((adgj)a(34)).a();
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.a();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView = null;
      }
      if (this.jdField_a_of_type_Myg != null)
      {
        this.jdField_a_of_type_Myg.dismiss();
        this.jdField_a_of_type_Myg = null;
      }
      if (this.jdField_a_of_type_Nbz != null) {
        this.jdField_a_of_type_Nbz.a();
      }
      myb.a().b();
      if (this.V) {
        a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166910), true);
      }
      aedj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_Wzt != null)
      {
        this.jdField_a_of_type_Wzt.dismiss();
        this.jdField_a_of_type_Wzt = null;
      }
      if (this.jdField_a_of_type_Xbm != null) {
        this.jdField_a_of_type_Xbm = null;
      }
      Object localObject = (bajo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
      ((bajo)localObject).e("");
      if (((bajo)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        ((bajo)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      C(0);
      this.jdField_r_of_type_Int = 0;
      this.ah = false;
      this.aj = false;
      this.al = false;
      this.ak = false;
      localObject = (bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      ((bamk)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.g, "off");
      ((bamk)localObject).a(null);
      ((tcw)tcz.a(5)).c();
      ((tdl)tcz.a(2)).d();
      ((vwn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(208)).a();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        akpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
      }
      if (this.jdField_a_of_type_Batg != null)
      {
        this.jdField_a_of_type_Batg.a();
        this.jdField_a_of_type_Batg = null;
      }
      A(0);
      if (this.jdField_a_of_type_Baqr != null) {
        this.jdField_a_of_type_Baqr.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = null;
      }
      super.G();
      if (this.jdField_b_of_type_AndroidOsHandler != null)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "doOnDestroy, timerHandler->removeCallbacksAndMessages");
        }
      }
      bafm.a().a();
      if (this.jdField_a_of_type_Batr != null)
      {
        this.jdField_a_of_type_Batr.b();
        this.jdField_a_of_type_Batr = null;
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((this.jdField_d_of_type_Bbgu != null) && (this.jdField_d_of_type_Bbgu.isShowing())) {
        this.jdField_d_of_type_Bbgu.dismiss();
      }
      if (this.jdField_a_of_type_Azvm != null) {
        this.jdField_a_of_type_Azvm.b();
      }
      try
      {
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
        {
          this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
            {
              this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
              this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
            }
            aede.jdField_a_of_type_JavaUtilHashMap.clear();
            aede.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
            amom.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
            localObject = new Intent("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT");
            BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.f();
            }
            this.ao = false;
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b(false);
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(false);
            }
            if (this.jdField_a_of_type_Actd != null) {
              this.jdField_a_of_type_Actd.a(null);
            }
            if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null)) {
              break;
            }
            if (Build.VERSION.SDK_INT >= 16) {
              break label886;
            }
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
            this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = null;
            return;
            localException1 = localException1;
            if (QLog.isColorLevel()) {
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "doOnDestroy unregisterReceiver, e:" + localException1.getMessage());
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "doOnDestroy mConfessReceiver unregisterReceiver, e:" + localException2.getMessage());
              continue;
              label886:
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
            }
          }
        }
      }
    }
  }
  
  boolean G()
  {
    if (this.jdField_a_of_type_Baec == null) {}
    boolean bool = bame.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleTroopNotificationMsg. hasNewGuide = " + bool);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (!bool))
    {
      ThreadManager.post(new TroopChatPie.26(this), 8, null, true);
      return true;
    }
    return false;
  }
  
  public void K()
  {
    if (this.V) {
      bJ();
    }
    if (this.jdField_a_of_type_Bajx != null)
    {
      bajt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bajx);
      this.jdField_a_of_type_Bajx = null;
    }
    if ((this.jdField_a_of_type_Wzt == null) || (!this.jdField_a_of_type_Wzt.isShowing()))
    {
      bahf localbahf = (bahf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
      if (localbahf != null) {
        localbahf.c();
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    if (this.jdField_a_of_type_Basl != null) {
      this.jdField_a_of_type_Basl.a();
    }
    if (bafm.a().a()) {
      bafm.a().b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(true);
    }
    super.K();
  }
  
  public void L()
  {
    if (this.jdField_a_of_type_Batr != null) {
      this.jdField_a_of_type_Batr.a();
    }
    if (this.jdField_a_of_type_Azrn != null) {
      this.jdField_a_of_type_Azrn.d();
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    super.L();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Wzt == null) || (!this.jdField_a_of_type_Wzt.isShowing()))
    {
      localObject = (bahf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
      if (localObject != null) {
        ((bahf)localObject).c();
      }
    }
    if (bafm.a().a()) {
      bafm.a().b();
    }
    Object localObject = (azry)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231);
    ((azry)localObject).jdField_a_of_type_Int = 0;
    ((azry)localObject).b = 0;
    ((azry)localObject).c = 0;
    ((azry)localObject).d = 0;
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "doOnPause, isTroopOwner =" + this.af);
    }
  }
  
  public void M()
  {
    super.M();
    if (this.V)
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843031);
      myb.a().a(this.jdField_a_of_type_Myf);
      a(-16777216, false);
    }
    bv();
  }
  
  public void O()
  {
    super.O();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 2)
    {
      this.U = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
      if (this.U) {
        bt();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(0);
    }
    this.jdField_a_of_type_Azrn = a();
    this.jdField_a_of_type_Azrn.c();
    this.jdField_a_of_type_Azrn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    amom.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_Baqr.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.e();
    }
  }
  
  public void P()
  {
    super.P();
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localIntent == null) {
      return;
    }
    String str = localIntent.getStringExtra("uin");
    int k = localIntent.getIntExtra("uintype", -1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != k))) {}
    for (k = 1;; k = 0)
    {
      if ((k != 0) && (this.jdField_a_of_type_Baec != null))
      {
        this.jdField_a_of_type_Baec.b();
        this.jdField_a_of_type_Baec = null;
      }
      if ((k != 0) && (this.jdField_a_of_type_Azvm != null) && (this.jdField_a_of_type_Azvm.a != null))
      {
        this.jdField_a_of_type_Azvm.a.b();
        this.jdField_a_of_type_Azvm.a = null;
      }
      if (this.jdField_a_of_type_Bajx != null)
      {
        bajt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bajx);
        this.jdField_a_of_type_Bajx = null;
      }
      this.jdField_i_of_type_Boolean = true;
      return;
    }
  }
  
  public void Q()
  {
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (this.jdField_a_of_type_Baro != null)) {
      this.jdField_a_of_type_Baro.c();
    }
    super.Q();
  }
  
  public void Z()
  {
    super.Z();
    ((adji)a(43)).h();
  }
  
  public aeyz a()
  {
    return this.jdField_a_of_type_Aeyz;
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 35)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = ((ConfessPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558535, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this);
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel;; localObject = super.a(paramInt))
    {
      if ((localObject instanceof PlusPanel)) {
        ((PlusPanel)localObject).setPagerChangedListener(new aeuq(this));
      }
      return localObject;
    }
  }
  
  public ImageView a()
  {
    return this.jdField_d_of_type_AndroidWidgetImageView;
  }
  
  public azrn a()
  {
    if (this.jdField_a_of_type_Azrn == null) {
      this.jdField_a_of_type_Azrn = new azrn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364075));
    }
    return this.jdField_a_of_type_Azrn;
  }
  
  public basl a()
  {
    if (this.jdField_a_of_type_Basl == null)
    {
      this.jdField_a_of_type_Basl = new basl();
      this.jdField_a_of_type_Basl.a(this);
    }
    return this.jdField_a_of_type_Basl;
  }
  
  public batr a()
  {
    if (this.jdField_a_of_type_Batr == null) {
      this.jdField_a_of_type_Batr = new batr(this.jdField_c_of_type_AndroidWidgetLinearLayout);
    }
    return this.jdField_a_of_type_Batr;
  }
  
  public PanelIconLinearLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  }
  
  public EntryModel a()
  {
    return banb.a(((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public Boolean a()
  {
    if (this.V) {
      return new Boolean(false);
    }
    return null;
  }
  
  String a(TroopMemberInfo paramTroopMemberInfo)
  {
    int k = (int)(paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime()) / 86400;
    return String.format("<{\"text\":\"%1$s\", \"cmd\": \"5\", \"data\":\"%2$s\"}>专属头衔\"%3$s\"将在%4$d天后到期，<{\"text\":\"点击续期\", \"cmd\": \"3\", \"data_a\":\"mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.troop.EditUniqueTitleActivity&troopUin=%5$s&memberUin=%2$s&uniqueTitle=%6$s&uniqueTitleExpire=%7$d&from=2\"}>", new Object[] { paramTroopMemberInfo.friendnick, paramTroopMemberInfo.memberuin, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(k + 1), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(paramTroopMemberInfo.mUniqueTitleExpire) });
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "TroopChatPie";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "onPanelChanged updateAIOPanelTip. oldPanel=", Integer.valueOf(paramInt1), ", newPanel=", Integer.valueOf(paramInt2) });
    }
    b(false);
    if ((paramInt1 == 0) && (paramInt2 != 0)) {
      bL();
    }
    if (this.jdField_a_of_type_Azvm != null) {
      this.jdField_a_of_type_Azvm.a();
    }
    if (paramInt1 == 35) {
      if (paramInt2 != 1) {
        break label117;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(bool);
      if (paramInt2 == 35) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.b();
      }
      super.a(paramInt1, paramInt2);
      return;
      label117:
      bool = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2000)
    {
      if ((this.jdField_a_of_type_Aeza != null) && (this.jdField_a_of_type_Aeza.a()) && (asfd.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Aeyv.a();
      }
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false))) {
        a().getIntent().putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      }
    }
    if ((paramInt1 != 5) && (paramInt1 != 2000) && (b(true))) {
      return;
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    label515:
    label728:
    do
    {
      for (;;)
      {
        super.a(paramInt1, paramInt2, paramIntent);
        return;
        Object localObject1 = actj.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
        ((Intent)localObject1).putExtras(new Bundle(paramIntent.getExtras()));
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject1);
        continue;
        localObject1 = paramIntent.getExtras().getString("troop_uin");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          break;
        }
        String str2 = paramIntent.getExtras().getString("member_uin");
        String str1 = paramIntent.getExtras().getString("member_display_name");
        Object localObject2;
        int m;
        if ((paramIntent.getExtras().getBoolean("isApollo")) && (this.jdField_a_of_type_Ajpx != null))
        {
          if (!"0".equals(str2))
          {
            localObject1 = null;
            if (!E()) {
              localObject1 = bbcz.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2);
            }
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject2 = str1;
            }
            localObject1 = new StringBuilder("@").append((String)localObject2);
            this.jdField_a_of_type_Ajpx.a.peerUin = str2;
            this.jdField_a_of_type_Ajpx.a.atNickName = ((StringBuilder)localObject1).toString();
            this.jdField_a_of_type_Ajpx.a.inputText = aylc.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
            a(this.jdField_a_of_type_Ajpx);
            k = 0;
            if (TextUtils.isEmpty(this.jdField_a_of_type_Ajpx.a.inputText))
            {
              m = 2;
              k = m;
              if (!TextUtils.isEmpty(this.jdField_a_of_type_Ajpx.b))
              {
                if (this.jdField_a_of_type_Ajpx.d == 0) {
                  k = 6;
                }
              }
              else
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                m = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                str2 = "" + this.jdField_a_of_type_Ajpx.a.actionId;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_Ajpx.b)) {
                  break label728;
                }
              }
            }
            for (localObject1 = "0";; localObject1 = this.jdField_a_of_type_Ajpx.b)
            {
              VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "g_action_double_sent", str1, k, m, new String[] { str2, localObject1, this.jdField_a_of_type_Ajpx.a.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
              break;
              k = m;
              if (this.jdField_a_of_type_Ajpx.d != 1) {
                break label515;
              }
              k = 7;
              break label515;
              if (TextUtils.isEmpty(this.jdField_a_of_type_Ajpx.b))
              {
                k = 3;
                break label515;
              }
              if (this.jdField_a_of_type_Ajpx.d == 0)
              {
                k = 4;
                break label515;
              }
              if (this.jdField_a_of_type_Ajpx.d != 1) {
                break label515;
              }
              k = 5;
              break label515;
            }
          }
        }
        else
        {
          a(str2, str1, true, 4);
          continue;
          balu.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          continue;
          ap();
          k = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
          if (k > 0)
          {
            m = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().charAt(k - 1);
            if ((m == 36) || (m == 65509) || (m == 165) || (m == 65284))
            {
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().delete(k - 1, k));
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(k - 1);
              continue;
              if (this.jdField_a_of_type_Xbm != null)
              {
                localObject1 = this.jdField_a_of_type_Xbm.a();
                if (localObject1 != null)
                {
                  ((TroopGiftPanel)localObject1).a(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
                  continue;
                  localObject1 = paramIntent.getStringExtra("result");
                  localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null) && (!((String)localObject1).equals(((TroopInfo)localObject2).troopname)))
                  {
                    ((ajsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1, false);
                    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ((String)localObject1);
                    localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
                    ((Intent)localObject2).putExtra("uinname", (String)localObject1);
                    b((Intent)localObject2);
                    continue;
                    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel != null)
                    {
                      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(paramInt1, paramIntent);
                      continue;
                      if (paramInt2 == 8001)
                      {
                        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
                          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
                        }
                      }
                      else if (paramInt1 == 12005)
                      {
                        localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                        if (localObject1 != null)
                        {
                          if (((TroopInfo)localObject1).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                            k = 0;
                          }
                          for (;;)
                          {
                            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "un", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, k + "", "", "");
                            break;
                            if (((TroopInfo)localObject1).isAdmin()) {
                              k = 1;
                            } else {
                              k = 2;
                            }
                          }
                        }
                      }
                      else if (paramInt2 == 0)
                      {
                        switch (paramInt1)
                        {
                        default: 
                          break;
                        case 6001: 
                          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l) {
                            BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
                          }
                          break;
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
      if (myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
      for (int k = 2;; k = 1)
      {
        axqy.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_choosecancel", k, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        break;
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null);
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
    }
    for (;;)
    {
      amom.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      break;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Myg == null) {
      this.jdField_a_of_type_Myg = new myg(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_Myg.a(paramInt, paramString);
    this.jdField_a_of_type_Myg.show();
    TroopChatPie.31 local31;
    if ((paramInt == 1) || (paramInt == 3))
    {
      paramString = this.jdField_a_of_type_MqqOsMqqHandler;
      local31 = new TroopChatPie.31(this);
      if (!AppSetting.d) {
        break label82;
      }
    }
    label82:
    for (long l = 3000L;; l = 1000L)
    {
      paramString.postDelayed(local31, l);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong1, paramLong2, new aeux(this, false));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
    }
    if ((this.jdField_c_of_type_Bbgu != null) && (this.jdField_c_of_type_Bbgu.isShowing())) {
      if ((paramLong == 1L) || (paramLong == 2L)) {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog, CreditLevelTipDialog isShowing:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
        }
      }
    }
    do
    {
      return;
      this.jdField_c_of_type_Bbgu.dismiss();
      if (paramLong == 1L)
      {
        this.jdField_c_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720260)).setMessage(2131697812);
        this.jdField_c_of_type_Bbgu.setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691223), new aeua(this));
        this.jdField_c_of_type_Bbgu.setNegativeButton(ajya.a(2131715282), new aeub(this));
        this.jdField_c_of_type_Bbgu.setPositiveButtonContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691223));
        this.jdField_c_of_type_Bbgu.setNegativeButtonContentDescription(ajya.a(2131715280));
        this.jdField_c_of_type_Bbgu.setCancelable(false);
        this.jdField_c_of_type_Bbgu.show();
        new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_banned").c("Grp_AIO").d("exp_msgbox").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }).a();
        return;
      }
      if ((paramLong == 2L) && (!paramBoolean))
      {
        this.jdField_c_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720260)).setMessage(2131697811);
        this.jdField_c_of_type_Bbgu.setPositiveButton(2131697809, new aeuc(this));
        this.jdField_c_of_type_Bbgu.setNegativeButton("", null);
        this.jdField_c_of_type_Bbgu.setCancelable(false);
        this.jdField_c_of_type_Bbgu.show();
        return;
      }
    } while ((paramLong != 2L) || (!paramBoolean));
    this.jdField_c_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720260)).setMessage(2131697810);
    this.jdField_c_of_type_Bbgu.setNegativeButton(2131697809, new aeud(this));
    this.jdField_c_of_type_Bbgu.setPositiveButton(2131697808, new aeue(this));
    this.jdField_c_of_type_Bbgu.setCancelable(false);
    this.jdField_c_of_type_Bbgu.show();
  }
  
  public void a(aeuz paramaeuz)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramaeuz);
  }
  
  public void a(Intent paramIntent)
  {
    A(0);
    if ((this.V) && (!myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      u(false);
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      this.p.setVisibility(8);
    }
    String str1;
    String str2;
    int k;
    for (;;)
    {
      if ((this.V) && (myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131690050) + myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
      }
      super.a(paramIntent);
      str1 = paramIntent.getStringExtra("greetingsTitle");
      str2 = paramIntent.getStringExtra("greetingsContent");
      k = paramIntent.getIntExtra("types", 0);
      if (k == 1)
      {
        Object localObject1 = paramIntent.getStringExtra("greetingsMembers");
        if (localObject1 != null) {
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            k = 0;
            for (;;)
            {
              if (k < ((JSONArray)localObject1).length())
              {
                Object localObject3 = ((JSONArray)localObject1).getString(k);
                String str3 = bbcz.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject3);
                localObject3 = bafv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject3, str3, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
                if ((localObject3 != null) && (((SpannableString)localObject3).length() != 0)) {
                  this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject3);
                }
                k += 1;
                continue;
                if (!myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                u(true);
                this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843031);
                this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130843037);
                this.jdField_o_of_type_AndroidViewView.setVisibility(0);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "TroopChatPie send greetings.get members failed.");
            }
          }
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      if (!TextUtils.isEmpty(str1))
      {
        localObject2 = (adiw)a(27);
        if (localObject2 != null) {
          ((adiw)localObject2).a("0", str2, str1);
        }
      }
      if (paramIntent.getBooleanExtra("sendGift", false)) {
        a(true, TroopGiftPanel.jdField_f_of_type_Int);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Acyn != null)) {
        this.jdField_a_of_type_Acyn.a();
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      ((adji)a(43)).h();
      return;
      if (k == 2)
      {
        localObject2 = paramIntent.getStringExtra("greetingsName");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, "@" + (String)localObject2 + " ");
      }
    }
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    int k = paramIntent.getIntExtra(bbbw.jdField_h_of_type_JavaLangString, -1);
    if (((k == 2) || (k == 1)) && (b(true))) {
      return;
    }
    super.a(paramIntent, paramInt);
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131376634)
    {
      if (this.t == 2)
      {
        if (this.jdField_a_of_type_Batg == null) {
          this.jdField_a_of_type_Batg = new batg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_a_of_type_Azno);
        }
        this.jdField_a_of_type_Batg.a(a().jdField_a_of_type_JavaLangString);
        if (!this.jdField_a_of_type_Batg.b()) {}
      }
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_Batg.a()) {
            break;
          }
          bL();
        } while (this.jdField_a_of_type_Batg.b == 2);
        new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryClose").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        return;
        this.jdField_a_of_type_Batg.a(1);
        paramView = (akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
        if (paramView != null) {
          paramView.u(a().jdField_a_of_type_JavaLangString);
        }
        t(true);
        if (this.jdField_a_of_type_Batg.b == 2)
        {
          bbbp.a("Grp_idol", "Grp_AIO", "clk_renshu", 0, 0, new String[] { a().jdField_a_of_type_JavaLangString });
          return;
        }
        new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryOpen").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        return;
        if (this.t == 3)
        {
          ((aruh)a(33)).b();
          return;
        }
      } while (this.t != 4);
      ((adji)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    bK();
  }
  
  public void a(bale parambale)
  {
    if (parambale.jdField_a_of_type_Boolean) {
      if ((1 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (3 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (8 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && ((this.jdField_f_of_type_Int != 1) || (this.m != 0)))
      {
        ai();
        if (this.jdField_h_of_type_AndroidWidgetTextView != null)
        {
          QLog.d("troop_gag", 1, "fightgag.updateGagStatus_UI:" + parambale.b);
          this.jdField_h_of_type_AndroidWidgetTextView.setText(parambale.b);
        }
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "updateGagStatus_UI, sendEmptyMessageDelayed-TIMER_ID:" + parambale.jdField_a_of_type_Long + ", hasDestory=" + this.N);
        }
        if (!this.N)
        {
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, parambale.jdField_a_of_type_Long * 1000L);
        }
        this.jdField_i_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "updateGagStatus disable fastimage,  mAllowFastImage = " + this.jdField_i_of_type_Boolean);
        }
      }
    }
    do
    {
      return;
      this.ag = true;
      break;
      this.ag = false;
      bo();
      this.jdField_i_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "updateGagStatus enable fastimage,  mAllowFastImage = " + this.jdField_i_of_type_Boolean);
  }
  
  public void a(bale parambale, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (parambale == null) {
        ThreadManager.post(new TroopChatPie.15(this, paramBoolean), 8, null, true);
      }
    }
    else {
      return;
    }
    a(parambale);
  }
  
  public void a(Object paramObject)
  {
    actj.n = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int m = ((Integer)paramObject).intValue();
    if (m == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    switch (m)
    {
    case 6: 
    case 7: 
    default: 
    case 3: 
    case 2: 
    case 4: 
    case 5: 
      for (;;)
      {
        B(m);
        super.a(paramObject);
        return;
        if (this.V)
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          continue;
          if (this.V) {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_PTT", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
          if (this.X)
          {
            new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_icon_clk").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.g }).a();
            continue;
            if (this.V)
            {
              axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              continue;
              if (this.V) {
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              }
            }
          }
        }
      }
    }
    if (!E()) {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    if (this.jdField_a_of_type_Xbm == null) {
      this.jdField_a_of_type_Xbm = new xbm(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel);
    }
    xbm localxbm = this.jdField_a_of_type_Xbm;
    int n = TroopGiftPanel.e;
    if (myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    for (int k = 4;; k = 1)
    {
      localxbm.a(n, k);
      azjs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(azjx.a(c()));
      break;
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if ((paramInt1 == 2) || (paramInt1 == 1))
    {
      k = 1;
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label130;
      }
    }
    long l2;
    int m;
    String str1;
    Object localObject;
    label130:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      l2 = SystemClock.uptimeMillis();
      m = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (k != 0) {
        break label482;
      }
      localObject = aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.c);
      if (localObject != null) {
        break label136;
      }
      return;
      k = 0;
      break;
    }
    label136:
    ((MessageForPtt)localObject).c2cViaOffline = bool1;
    if (!bbkk.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
      ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
    }
    long l1 = ((MessageRecord)localObject).uniseq;
    aytn.a.put(paramString, Long.valueOf(l2));
    if (!bool1)
    {
      axug.a(paramString, false);
      axug.a(paramString);
      label204:
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + l1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!E) {
        break label567;
      }
    }
    label567:
    for (int k = 1;; k = 2)
    {
      axqy.b((QQAppInterface)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", k, 0, "", "", "", "8.3.0");
      E = true;
      k = a(paramInt1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
      ArrayList localArrayList = new ArrayList();
      String str2 = bafv.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      bamk localbamk = (bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      boolean bool3 = false;
      boolean bool2 = bool3;
      if (this.X)
      {
        Iterator localIterator = localArrayList.iterator();
        do
        {
          bool2 = bool3;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!localbamk.a(((MessageForText.AtTroopMemberInfo)localIterator.next()).uin));
        bool2 = true;
      }
      aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, str1, paramString, l1, false, paramInt2, paramRecorderParam.c, bool1, paramInt3, k, paramBoolean, paramRecorderParam.d, (Bundle)localObject, localArrayList, str2, bool2, paramInt4);
      b(paramInt1, paramInt2);
      a(0, paramString, l1);
      return;
      label482:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 0, paramLong);
      l1 = paramLong;
      if (!MessageForPtt.class.isInstance(localObject)) {
        break;
      }
      ((MessageForPtt)localObject).voiceLength = QQRecorder.a(paramInt2);
      l1 = paramLong;
      if (bbkk.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
        break;
      }
      ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
      l1 = paramLong;
      break;
      avbt.b(paramString);
      break label204;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    bamk localbamk = (bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if ((localbamk.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localbamk.b(paramString1)))
    {
      if (H()) {
        return;
      }
      this.g = paramString1;
      localbamk.e = paramString1;
      this.jdField_h_of_type_JavaLangString = paramString2;
    }
    super.a(paramString1, paramString2, paramBoolean, paramInt);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    banb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
    super.a(paramList, paramCharSequence, paramInt);
    if ((0xFFFF & paramInt) == 4)
    {
      ((azne)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(225)).a(paramList);
      if (this.jdField_a_of_type_Azno != null) {
        this.jdField_a_of_type_Azno.a().f();
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = a();
    } while ((TextUtils.isEmpty(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString)) || (paramObject == null));
    for (;;)
    {
      int k;
      try
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        if (Long.parseLong(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString) != l) {
          break;
        }
        localObject1 = (TroopMemberCard)paramObject[2];
        k = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        int m = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
        if (k > m) {
          break label425;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(k);
        if (!(localObject2 instanceof MessageForQQWalletTips)) {
          break label549;
        }
        localObject2 = (MessageForQQWalletTips)localObject2;
        if ((((MessageForQQWalletTips)localObject2).istroop != 1) || (localObject1 == null) || (!((MessageForQQWalletTips)localObject2).memberUin.equals(String.valueOf(((TroopMemberCard)localObject1).memberUin))) || (!((MessageForQQWalletTips)localObject2).frienduin.equals(String.valueOf(l))) || ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52) == null)) {
          break label549;
        }
        Object localObject3 = ((TroopMemberCard)localObject1).nick;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handGetTroopMemberCard troopUin=" + ((MessageForQQWalletTips)localObject2).frienduin + ", memberUin=" + ((MessageForQQWalletTips)localObject2).memberUin + ",card=" + ((TroopMemberCard)localObject1).card + ",remark=" + ((TroopMemberCard)localObject1).remark + ",nick=" + ((TroopMemberCard)localObject1).nick + ",saveTroopMemberEx succ=" + true);
        }
        localObject3 = actj.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, k);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handGetTroopMemberCard ref itemView=" + localObject3 + ",index=" + k);
        }
        if (localObject3 == null) {
          break label549;
        }
        localObject3 = (TextView)((View)localObject3).findViewById(2131367153);
        ((MessageForQQWalletTips)localObject2).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (TextView)localObject3);
      }
      catch (Throwable paramObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w(this.jdField_a_of_type_JavaLangString, 2, "handGetTroopMemberCard e=" + paramObject);
      return;
      label425:
      if ((localObject1 == null) || (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(((TroopMemberCard)localObject1).memberUin)))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "handleGetTroopMemberCard. memberUin = ", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      }
      if ((this.jdField_a_of_type_Azvm != null) && ((this.jdField_a_of_type_Azvm.a instanceof badx)))
      {
        localObject1 = (badx)this.jdField_a_of_type_Azvm.a;
        if (((Boolean)paramObject[3]).booleanValue()) {
          break label544;
        }
      }
      label544:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((badx)localObject1).a(paramBoolean, null, this);
        bM();
        return;
      }
      label549:
      k += 1;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    return super.a(paramInt, paramView, paramListView);
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!this.am)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int n = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      if (k > m) {}
      for (;;)
      {
        bool2 = bool1;
        if (k < m) {
          break label197;
        }
        bool2 = bool1;
        if (k > n) {
          break label197;
        }
        try
        {
          Object localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(k);
          if ((localObject == null) || (((ChatMessage)localObject).msgtype != -1012)) {
            break;
          }
          localObject = ((ChatMessage)localObject).getExtInfoFromExtStr("troop_new_member_uin");
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isNewMemberGrayTipVisible newMemberUin = " + (String)localObject + ",detect memberUin = " + paramString);
          }
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          bool2 = ((String)localObject).equals(paramString);
          if (!bool2) {
            break;
          }
          bool1 = true;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          for (;;)
          {
            localIndexOutOfBoundsException.printStackTrace();
          }
        }
        k += 1;
        continue;
        k = m;
      }
    }
    label197:
    return bool2;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewViewGroup == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "mAIORootView == null");
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment();
      if (localObject != null) {
        this.jdField_c_of_type_AndroidViewViewGroup = ((ChatFragment)localObject).a;
      }
    }
    super.a(paramBoolean);
    C(1);
    bafm.a().a(this);
    this.jdField_a_of_type_Baqr = new baqr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_time", "Grp_AIO", "visit_time");
    bded.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), true);
    Object localObject = (adhl)this.jdField_a_of_type_Adia.a(52);
    if (localObject != null) {
      ((adhl)localObject).a();
    }
    return true;
  }
  
  public void aW()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    paramEditable = (adiw)a(27);
    if (paramEditable != null) {
      paramEditable.b();
    }
  }
  
  public void ag()
  {
    bq();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      if (localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
        a(0L, 0L);
      }
      if (amze.c().mIsEnable)
      {
        localObject = (akfv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        if (!localTroopManager.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label527;
        }
        ((akfv)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        QLog.e("vip_pretty.", 1, "get the troop expired info from server");
      }
    }
    if ((localTroopInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "aio onShow:" + localTroopInfo.troopuin + ", sysFlag=" + localTroopInfo.cGroupRankSysFlag + ", userFlag=" + localTroopInfo.cGroupRankUserFlag);
    }
    super.ag();
    if (this.aa == true)
    {
      ThreadManager.post(new TroopChatPie.7(this), 1, null, true);
      this.aa = false;
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    if ((localObject != null) && (((Bundle)localObject).containsKey("forward_type")) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(((Bundle)localObject).getString("uin")))) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.post(new TroopChatPie.8(this, bool), 8, null, true);
      if ((!this.al) && (localTroopManager.a.jdField_a_of_type_Boolean) && (localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        int k = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((k < 3) && (localTroopInfo.wMemberMax < 2000) && (localTroopInfo.wMemberNum >= 500))
        {
          if (this.jdField_a_of_type_Aezd == null)
          {
            this.jdField_a_of_type_Aezd = new aezd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Aeyv);
            this.jdField_a_of_type_Aeyv.a(this.jdField_a_of_type_Aezd);
          }
          this.jdField_a_of_type_Aezd.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_Aeyv.a(this.jdField_a_of_type_Aezd, new Object[0]))
          {
            this.al = true;
            localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, k + 1);
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_up", "", "Grp_AIO", "exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
        }
      }
      return;
      label527:
      if (QLog.isColorLevel()) {
        QLog.d("vip_pretty.", 1, "get the troop expired info from local");
      }
      TroopManager.a(localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Aeyv);
      break;
    }
  }
  
  public void al_()
  {
    super.al_();
    if ((this.jdField_a_of_type_Azno != null) && (!D())) {
      this.jdField_a_of_type_Azno.a().e();
    }
  }
  
  public void an()
  {
    super.an();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akfy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akit);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ayfn);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Akte);
    }
    bI();
    ((aqui)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajsy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akfy);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akit);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ayfn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azjv);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Akte);
    }
    ((aqui)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void aq()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clickSendTextButton. isSending:" + this.Z);
    }
    if (!this.Z) {
      this.Z = true;
    }
    for (int k = 1;; k = 0)
    {
      super.aq();
      if (k == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clickSendTextButton process talking state");
      }
      bamk localbamk = (bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      boolean bool2 = localbamk.a();
      Object localObject = localbamk.b;
      String str1 = localbamk.c;
      ArrayList localArrayList = new ArrayList();
      String str2 = bafv.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      k = 0;
      label261:
      boolean bool3;
      if (k < localArrayList.size())
      {
        MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(k);
        if (localbamk.a(localAtTroopMemberInfo.uin))
        {
          localObject = "" + localAtTroopMemberInfo.uin;
          str1 = bbcz.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject);
          if ((bool2) || (localbamk.a(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            bool1 = true;
            bool3 = localbamk.b(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            bool2 = bool1;
          }
        }
      }
      for (boolean bool1 = bool3;; bool1 = false)
      {
        if ((bool2) && (!bool1))
        {
          localObject = bafv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
          a(localbamk.b, localbamk.c, true, 0);
        }
        for (;;)
        {
          this.Z = false;
          return;
          bool1 = false;
          break label261;
          k += 1;
          break;
          aedx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if ((str2 == null) || (str2.length() <= 3478)) {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
          }
          if (this.X)
          {
            w(false);
            localObject = (adjp)a(23);
            if (localObject != null) {
              ((adjp)localObject).a(false);
            }
          }
          this.Y = false;
          localbamk.a();
        }
      }
    }
  }
  
  public RelativeLayout b()
  {
    return this.jdField_d_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    bH();
  }
  
  public boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.ag)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (paramBoolean) {
        bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697657, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
      ai();
      bool = true;
    }
    return bool;
  }
  
  public void bA()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new aeul(this));
    if ((this.jdField_r_of_type_AndroidViewView != null) && (this.q != null))
    {
      this.jdField_r_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      this.q.startAnimation(localAlphaAnimation);
    }
  }
  
  public void bB()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new aeun(this));
    this.jdField_r_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    this.q.startAnimation(localAlphaAnimation);
  }
  
  public void bC()
  {
    if ((this.jdField_c_of_type_Bcqf != null) && (this.jdField_c_of_type_Bcqf.isShowing()) && (!a().isFinishing())) {
      this.jdField_c_of_type_Bcqf.dismiss();
    }
  }
  
  protected void bD()
  {
    Object localObject1 = (bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    Object localObject2;
    String str1;
    int k;
    boolean bool;
    if (((bamk)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (!this.Z)
      {
        localObject2 = (bafv[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(0, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString().length(), bafv.class);
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        k = 0;
        if (k >= localObject2.length) {
          break label439;
        }
        if (!((bamk)localObject1).b(localObject2[k].a())) {
          break label247;
        }
        String str2 = localObject2[k].a();
        this.g = str2;
        ((bamk)localObject1).e = str2;
        this.jdField_h_of_type_JavaLangString = localObject2[k].b();
        if (!this.jdField_h_of_type_JavaLangString.startsWith("@")) {
          break label434;
        }
        this.jdField_h_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString.substring(1);
        bool = true;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a().equals(this.g))) {
        bool = false;
      }
      for (;;)
      {
        ((adje)a(29)).d(bool);
        if (this.Y == bool) {
          if (bool)
          {
            localObject1 = (adjp)a(23);
            if (localObject1 != null) {
              ((adjp)localObject1).b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount());
            }
          }
        }
        label247:
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                k += 1;
                break;
                this.Y = bool;
                if (bool) {
                  break label364;
                }
                w(false);
                localObject2 = (adjp)a(23);
                if (localObject2 != null) {
                  ((adjp)localObject2).a(false);
                }
              } while (!((bamk)localObject1).a());
              ((bamk)localObject1).a();
              bamk.a("panel", "talk_out", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(), "2", "");
              ((bamk)localObject1).b(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), Long.parseLong(this.g), "off", new aeur(this));
              return;
            } while (this.X);
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(str1, this.g, this.jdField_h_of_type_JavaLangString, this, new aeus(this));
            return;
          } while (!this.X);
          w(false);
          localObject1 = (adjp)a(23);
        } while (localObject1 == null);
        label364:
        ((adjp)localObject1).a(false);
        return;
      }
      label434:
      bool = true;
      continue;
      label439:
      bool = false;
    }
  }
  
  public void bE()
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView == null) {
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365233));
    }
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (((TroopInfo)localObject).wMemberNumClient <= 0))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel())
      {
        if (localObject != null) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showNewTroopMemberCount count smaller than 0" + ((TroopInfo)localObject).wMemberNumClient);
        }
      }
      else {
        return;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showNewTroopMemberCount info is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showNewTroopMemberCount wMemberNumClient:" + ((TroopInfo)localObject).wMemberNumClient + "  wMemberNum:" + ((TroopInfo)localObject).wMemberNum + " troopUin:" + ((TroopInfo)localObject).troopuin);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject).wMemberNumClient) }));
    if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setGravity(16);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
        if (this.l) {
          break label284;
        }
      }
    }
    label284:
    for (boolean bool = true;; bool = false)
    {
      ((NavBarAIO)localObject).a(bool, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
      return;
    }
  }
  
  public void bF()
  {
    if ((this.jdField_h_of_type_AndroidWidgetImageView == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_e_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Object localObject = (aruh)a(33);
    boolean bool1 = ((aruh)localObject).c();
    boolean bool2 = ((aruh)localObject).d();
    adji localadji = (adji)a(43);
    boolean bool3 = localadji.c();
    int k;
    if (bool1)
    {
      A(3);
      c(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(((aruh)localObject).a(bool2));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166851));
      t(bool2);
      k = actj.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
      arty.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, k, 0, 0);
    }
    label147:
    while ((QLog.isColorLevel()) && (QLog.isColorLevel()))
    {
      QLog.d("BaseListenTogetherPanel_Troop", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
      return;
      if (bool3)
      {
        bool3 = localadji.a();
        A(4);
        c(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(localadji.a());
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166851));
        t(bool3);
        k = actj.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        arty.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, k, 0, 0);
      }
      else
      {
        localObject = ((batp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a(a().jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label380;
        }
        A(2);
        c(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166851));
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        v(false);
      }
    }
    for (;;)
    {
      arty.a(this.jdField_b_of_type_AndroidViewViewGroup);
      break label147;
      break;
      label380:
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
      A(0);
    }
  }
  
  public void bb()
  {
    super.bb();
    bL();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    ((adgj)a(34)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void bp()
  {
    boolean bool = false;
    super.bp();
    if (this.jdField_a_of_type_Bajx == null)
    {
      aeva localaeva = new aeva(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bajx = new bajx(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localaeva, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    bajt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bajx);
    b(false);
    if (this.V != myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (!this.V) {
        bool = true;
      }
      this.V = bool;
      u(this.V);
    }
    ((bajo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void bq()
  {
    super.bq();
    this.u = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ThreadManager.post(new TroopChatPie.24(this), 8, null, true);
    bw();
    Object localObject = new TroopChatPie.25(this);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    int k;
    if (localObject != null)
    {
      String str1 = ((Intent)localObject).getStringExtra("at_member_name");
      String str2 = ((Intent)localObject).getStringExtra("at_member_uin");
      k = ((Intent)localObject).getIntExtra("at_member_source", 0);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        a(str2, str1, false, k);
      }
    }
    if ((!this.ah) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {}
    for (boolean bool1 = G();; bool1 = false)
    {
      if (!bool1) {
        if ((this.jdField_a_of_type_Wzt != null) && (this.jdField_a_of_type_Wzt.isShowing())) {
          bool1 = true;
        }
      }
      for (;;)
      {
        localObject = (bahf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
        if (localObject != null) {}
        for (boolean bool2 = ((bahf)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; bool2 = false)
        {
          if ((localObject != null) && (bool2) && (bool1)) {
            ((bahf)localObject).b = false;
          }
          if ((!bool1) && (bool2))
          {
            bahf.jdField_a_of_type_Boolean = true;
            o(true);
          }
          localObject = aruh.a(this);
          if (localObject != null)
          {
            if ((bool1) || (bool2))
            {
              bool1 = true;
              label276:
              ((aruh)localObject).a(bool1);
            }
          }
          else
          {
            this.ai = false;
            if (!this.ah)
            {
              if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) != null) {
                break label547;
              }
              k = 1;
              label316:
              if (k == 0) {
                break label552;
              }
              if (QLog.isColorLevel()) {
                QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, isTroopTipStatusNull== true, getAppInfoBriefList");
              }
              this.jdField_a_of_type_Nbz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ncc, true);
            }
          }
          for (;;)
          {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
            ThreadManager.getSubThreadHandler().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 500L);
            bE();
            this.ah = true;
            if ((this.ad) && (this.jdField_a_of_type_Azvm != null))
            {
              this.jdField_a_of_type_Azvm.a(true);
              this.ad = false;
            }
            localObject = (azry)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231);
            if ((((azry)localObject).jdField_a_of_type_Int != 0) && (!myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!axmv.b()))
            {
              ((azry)localObject).a(new azrw(((azry)localObject).e, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((azry)localObject).b, ((azry)localObject).c, ((azry)localObject).d, ((azry)localObject).jdField_a_of_type_Int));
              localObject = a();
              ((azrn)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              ((azrn)localObject).a();
            }
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label276;
            label547:
            k = 0;
            break label316;
            label552:
            if (QLog.isColorLevel()) {
              QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, reqNotifyItems");
            }
            baiy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  protected void bt()
  {
    g(true);
    TroopChatPie.1 local1 = new TroopChatPie.1(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, local1, 9);
  }
  
  public void bu()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
      ThreadManager.post(this.jdField_c_of_type_JavaLangRunnable, 8, null, true);
    }
  }
  
  protected void bv()
  {
    boolean bool3 = false;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Object localObject = null;
    if (localTroopManager != null) {
      localObject = localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, troopInfo==null:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    long l;
    do
    {
      return;
      l = ((TroopInfo)localObject).troopCreditLevel;
      if ((l == 1L) || (l == 2L)) {
        break;
      }
      if ((this.jdField_c_of_type_Bbgu != null) && (this.jdField_c_of_type_Bbgu.isShowing())) {
        this.jdField_c_of_type_Bbgu.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, normal:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + l);
    return;
    boolean bool1;
    if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L)
    {
      bool1 = true;
      if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) != 1L) {
        break label362;
      }
    }
    label362:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((bool1) || (bool2)) {
        bool3 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + bool1 + ", " + bool2);
      }
      localObject = (akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, getTroopCreditInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        ((akhp)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      a(l, bool3);
      return;
      bool1 = false;
      break;
    }
  }
  
  void bw()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject != null) {
        break label29;
      }
    }
    label29:
    do
    {
      for (;;)
      {
        return;
        localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && ((((TroopInfo)localObject).wMemberNum == 0) || (TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)))) {
          try
          {
            long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject = new ArrayList();
            ((ArrayList)localObject).add(Long.valueOf(l));
            ((akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a((ArrayList)localObject);
            if (QLog.isColorLevel())
            {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getTroopInfoIfNeed, sessionInfo.curFriendUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getTroopInfoIfNeed failed");
  }
  
  public void bx()
  {
    akhp localakhp = (akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localakhp != null) {}
    try
    {
      localakhp.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 0L, 2, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, localException.toString());
    }
  }
  
  void by()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground() != null) {
      n();
    }
    bJ();
    this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166851));
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166851));
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849547);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166848));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166848));
      actj.a(this.jdField_a_of_type_AndroidWidgetImageView, 2130849555);
      if ((this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_f_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_f_of_type_AndroidWidgetTextView.getText().toString().startsWith(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131690050))))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText("");
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166851));
        c(false);
      }
      batp localbatp = (batp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234);
      String str = localbatp.a(a().jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(str)) {
        break label612;
      }
      A(2);
      if (localbatp.a(a().jdField_a_of_type_JavaLangString) != 3) {
        break label554;
      }
      bbbp.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { a().jdField_a_of_type_JavaLangString });
      label304:
      c(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166851));
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      v(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a.b = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(false);
      }
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      this.p.setVisibility(8);
      myb.a().b();
      bB();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(1.0F, 0.0F, 1.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131165337));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        actj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130848826);
      }
      bz();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      ((adji)a(43)).g();
      return;
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130849548);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166848));
      break;
      label554:
      new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
      break label304;
      label612:
      A(0);
    }
  }
  
  public void bz()
  {
    if (this.jdField_a_of_type_Aeyv != null)
    {
      ajcm localajcm = ajcm.a();
      if (localajcm != null) {
        localajcm.f();
      }
    }
  }
  
  public void c()
  {
    if (b(true)) {
      return;
    }
    bamk localbamk = (bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    boolean bool2 = localbamk.a();
    Object localObject = localbamk.b;
    String str1 = localbamk.c;
    this.Z = true;
    ArrayList localArrayList = new ArrayList();
    String str2 = bafv.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    int k = 0;
    label198:
    boolean bool3;
    if (k < localArrayList.size())
    {
      MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(k);
      if (localbamk.a(localAtTroopMemberInfo.uin))
      {
        localObject = "" + localAtTroopMemberInfo.uin;
        str1 = bbcz.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject);
        if ((bool2) || (localbamk.a(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          bool1 = true;
          bool3 = localbamk.b(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          bool2 = bool1;
        }
      }
    }
    for (boolean bool1 = bool3;; bool1 = false)
    {
      super.c();
      if ((bool2) && (!bool1))
      {
        localObject = bafv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
        a(localbamk.b, localbamk.c, true, 0);
      }
      for (;;)
      {
        this.Z = false;
        return;
        bool1 = false;
        break label198;
        k += 1;
        break;
        aedx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((str2 == null) || (str2.length() <= 3478)) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        }
        if (this.X)
        {
          w(false);
          localObject = (adjp)a(23);
          if (localObject != null) {
            ((adjp)localObject).a(false);
          }
        }
        this.Y = false;
        localbamk.a();
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    if (paramInt2 == 8) {
      if (!this.V) {}
    }
    for (;;)
    {
      if ((paramInt2 == 2) && (this.V)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(0);
      }
      return;
      if (!this.V) {}
    }
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    aW();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    bbkj.a(null, "AIO_updateSession_business");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
    {
      paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
      }
    }
    this.jdField_r_of_type_Int = 2;
    bbkj.a("AIO_updateSession_business", null);
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.V) {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843057);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(myb.c);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(myb.c);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130849548);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(myb.c);
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849547);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166848));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166848));
        return;
      }
    } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130849548);
    this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166848));
  }
  
  public void f(String paramString)
  {
    if (a().isFinishing()) {}
    do
    {
      return;
      if (this.jdField_c_of_type_Bcqf == null) {
        this.jdField_c_of_type_Bcqf = new bcqf(a(), a().getTitleBarHeight());
      }
      this.jdField_c_of_type_Bcqf.a(paramString);
    } while ((a().isFinishing()) || (this.jdField_c_of_type_Bcqf.isShowing()));
    this.jdField_c_of_type_Bcqf.show();
  }
  
  public void f(boolean paramBoolean)
  {
    if (bafm.a().a()) {
      bafm.a().b();
    }
    if (this.ae) {
      bN();
    }
    super.f(paramBoolean);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int k;
    long l1;
    long l2;
    long l3;
    while ((paramMessage.what == 60) && (this.V))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843031);
      return true;
      if ((this.jdField_a_of_type_Wzt != null) && (this.jdField_a_of_type_Wzt.isShowing())) {
        this.jdField_a_of_type_Wzt.dismiss();
      }
      this.jdField_a_of_type_Wzt = new wzt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Baec, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      Object localObject = new int[2];
      this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen((int[])localObject);
      k = a();
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLocationInWindow(arrayOfInt);
      int m = arrayOfInt[1];
      int n = localObject[1];
      this.jdField_a_of_type_Wzt.a(k, m - n);
      this.jdField_a_of_type_Wzt.a(paramMessage.arg1);
      continue;
      if ((this.jdField_a_of_type_Azno != null) && (this.jdField_a_of_type_Azno.b()))
      {
        localObject = this.jdField_a_of_type_Azno.a();
        if (((azni)localObject).a.get())
        {
          ((azni)localObject).a.set(false);
          continue;
          k = paramMessage.arg1;
          localObject = this.jdField_j_of_type_AndroidWidgetImageView;
          if (k == 0) {}
          for (k = 8;; k = 0)
          {
            ((ImageView)localObject).setVisibility(k);
            break;
          }
          localObject = (List)paramMessage.obj;
          if (localObject != null)
          {
            l1 = ((Long)((List)localObject).get(0)).longValue();
            l2 = ((Long)((List)localObject).get(1)).longValue();
            l3 = ((Long)((List)localObject).get(2)).longValue();
          }
        }
      }
    }
    for (;;)
    {
      long l4;
      long l5;
      try
      {
        l4 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        l5 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        if (l4 != l1) {
          break label471;
        }
        if (l2 == l5) {
          break label611;
        }
        if (l3 != l5) {
          break label471;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e(".troop.chat_pie_msg", 1, "MSG_TROOP_ADMIN_OPERATION_NOTIFY: groupUin error", localNumberFormatException);
      }
      if (k != 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: will reload plusPanel, groupUin:", Long.valueOf(l1) });
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
          break;
          break;
          label471:
          k = 0;
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: should reload plusPanel, but mPlusPanel == null, groupUin:", Long.valueOf(l1) });
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition not match: group:", Long.valueOf(l1), "/", Long.valueOf(l4), " uin1/uin2/current: ", Long.valueOf(l2), "/", Long.valueOf(l3), "/", Long.valueOf(l5) });
      break;
      return super.handleMessage(paramMessage);
      label611:
      k = 1;
    }
  }
  
  public void i()
  {
    super.i();
    this.jdField_a_of_type_Nbz = new nbz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      aanz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
    this.aa = true;
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    asfd.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
    if (this.jdField_a_of_type_Actd != null) {
      this.jdField_a_of_type_Actd.a(this.jdField_a_of_type_Acte);
    }
    ThreadManager.post(new TroopChatPie.CheckGlamourPicturesRunnable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity), 2, null, true);
    int k;
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        if (!((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label322;
        }
        k = 1;
      }
    }
    for (;;)
    {
      new axrc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_private").c("Grp_AIO").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(k) }).a();
      if (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null)
      {
        this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new aeuy(this, null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      this.an = false;
      ((adjp)a(23)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
      label322:
      if (((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        k = 2;
      } else {
        k = 3;
      }
    }
  }
  
  public boolean i()
  {
    if (((adgj)a(34)).a()) {
      return true;
    }
    if (((adji)a(43)).f()) {
      return true;
    }
    if (this.jdField_a_of_type_Azno != null) {
      this.jdField_a_of_type_Azno.a();
    }
    if (bafm.a().a()) {
      bafm.a().b();
    }
    if (this.jdField_a_of_type_Aeza != null) {
      this.jdField_a_of_type_Aeza.a();
    }
    if (this.jdField_a_of_type_Azvm != null) {
      this.jdField_a_of_type_Azvm.c();
    }
    if (this.ae) {
      bN();
    }
    return super.i();
  }
  
  public void j()
  {
    super.j();
    if ((this.jdField_a_of_type_Azno.d()) && ((this.jdField_a_of_type_Azno.b() == 17) || (this.jdField_a_of_type_Azno.b() == 100) || (this.jdField_a_of_type_Azno.b() == 11))) {
      return;
    }
    this.jdField_a_of_type_Aeza = new aeza(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeyv, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Azno, this.jdField_a_of_type_AndroidWidgetToast);
    this.jdField_a_of_type_Aeyv.a(this.jdField_a_of_type_Aeza);
    this.jdField_a_of_type_Aexw = new aexw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeyv, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Aeyv.a(this.jdField_a_of_type_Aexw);
    this.jdField_a_of_type_Aeyz = new aeyz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aeyv, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Aeyv.a(this.jdField_a_of_type_Aeyz);
  }
  
  public void j(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.m = paramInt;
      if (!this.ag) {
        break label135;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      bbcf.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), false);
      b(true);
    }
    label135:
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711686);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 200L);
  }
  
  public void n(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopUin : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject3 = null;
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "avType : " + ((lnn)localObject1).jdField_a_of_type_Int);
        }
        if (((lnn)localObject1).jdField_a_of_type_Int != 2) {
          break label892;
        }
        if (((lnn)localObject1).jdField_a_of_type_Boolean)
        {
          axqy.b(null, "CliOper", "", "", "0X80066C2", "0X80066C2", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
        }
      }
      else
      {
        bG();
        if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null) {
          break label1004;
        }
        this.jdField_c_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetScrollView = new aeum(this, this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setScrollbarFadingEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalScrollBarEnabled(false);
        this.jdField_s_of_type_Int = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        localObject1 = new RelativeLayout.LayoutParams(-1, this.jdField_s_of_type_Int);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = baxn.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, 0, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout, -1, this.jdField_s_of_type_Int);
        localObject1 = (azry)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231);
        this.jdField_a_of_type_Azrn = a();
        ((azry)localObject1).jdField_a_of_type_Int = 0;
        ((azry)localObject1).b = 0;
        ((azry)localObject1).c = 0;
        ((azry)localObject1).d = 0;
        if (!axmv.b()) {
          ((azry)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_Azvm == null) {
          this.jdField_a_of_type_Azvm = ((azvm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(289));
        }
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Azvm.a(((TroopInfo)localObject1).dwGroupClassExt, true, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          this.af = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equalsIgnoreCase(((TroopInfo)localObject1).troopowneruin);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause, isTroopOwner =" + this.af + ",troopInfo = " + localObject1);
        }
        if ((amom.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)) {
          this.jdField_b_of_type_AndroidContentBroadcastReceiver = new aeuu(this);
        }
      }
    }
    catch (Exception localException2)
    {
      try
      {
        localObject1 = new IntentFilter();
        ((IntentFilter)localObject1).addAction("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT");
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
        if (TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          new baas(this.jdField_a_of_type_AndroidContentContext, "3171", "libWXVoice.so", "WXVoice").a();
          if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
            this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aeuw(this);
          }
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            Object localObject1 = new IntentFilter();
            ((IntentFilter)localObject1).addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1, "com.tencent.msg.permission.pushnotify", null);
            badx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject1 = (amwi)ampl.a().a(553);
            if ((localObject1 != null) && (!((amwi)localObject1).jdField_a_of_type_Boolean))
            {
              this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
            }
            bM();
            localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
            this.ae = ((Intent)localObject1).getBooleanExtra("open_chat_from_group_rec_confess", false);
            if (this.ae)
            {
              h((Intent)localObject1);
              g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.k = this.ae;
            v(false);
            super.n(paramInt);
            return;
            localException1 = localException1;
            Object localObject2 = localObject3;
            label1004:
            if (QLog.isColorLevel())
            {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onShowFirst : invalid uin!");
              localObject2 = localObject3;
              continue;
              axqy.b(null, "CliOper", "", "", "0X80066BF", "0X80066BF", 0, 0, "", "", "", "");
              continue;
              label892:
              if (((lnn)localObject2).jdField_a_of_type_Int == 10)
              {
                if (((lnn)localObject2).jdField_a_of_type_Boolean) {
                  axqy.b(null, "CliOper", "", "", "0X80066C1", "0X80066C1", 0, 0, "", "", "", "");
                }
                for (;;)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
                  break;
                  axqy.b(null, "CliOper", "", "", "0X80066BE", "0X80066BE", 0, 0, "", "", "", "");
                }
                this.jdField_s_of_type_Int = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
                localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject2).height = this.jdField_s_of_type_Int;
                ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
                this.jdField_a_of_type_AndroidWidgetScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                this.jdField_a_of_type_AndroidWidgetScrollView.removeAllViews();
                this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout, -1, this.jdField_s_of_type_Int);
              }
            }
          }
          localException2 = localException2;
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "register mConfessReceiver receiver exception.");
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 1, "register homework receiver exception.");
          }
        }
      }
    }
  }
  
  public void n(boolean paramBoolean)
  {
    if (bbkb.m(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      a(paramBoolean, TroopGiftPanel.jdField_f_of_type_Int);
      bbkb.j(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      return;
    }
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131366883) && (b(true))) {}
    do
    {
      do
      {
        return;
        super.onClick(paramView);
        if (paramView.getId() != 2131370506) {
          break;
        }
      } while ((this.jdField_a_of_type_Aeza == null) || (!this.jdField_a_of_type_Aeza.a()));
      this.jdField_a_of_type_Aeyv.a();
      return;
      if (paramView.getId() == 2131370504)
      {
        bL();
        return;
      }
    } while ((paramView.getId() != 2131368441) || (this.jdField_j_of_type_AndroidWidgetImageView == null) || (this.jdField_j_of_type_AndroidWidgetImageView.getVisibility() != 0));
    baql.a(this.jdField_j_of_type_AndroidWidgetImageView).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_Azno != null) {
      this.jdField_a_of_type_Azno.a().a(paramInt, 500L);
    }
    if (paramInt == 2) {
      bL();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "scrollState = " + paramInt);
    }
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.am = bool;
      paramAbsListView = this.jdField_b_of_type_JavaUtilList.iterator();
      while (paramAbsListView.hasNext()) {
        ((aeuz)paramAbsListView.next()).a(this.am);
      }
    }
    if ((paramInt == 0) && (this.jdField_i_of_type_JavaLangString != null))
    {
      paramAbsListView = ((akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a();
      this.jdField_i_of_type_JavaLangString = null;
      paramAbsListView.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentWidgetPatchedButton, paramCharSequence, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l = true;
      D(1);
    }
    label292:
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, " onTextChanged:  start=" + paramInt1 + " before=" + paramInt2 + " count=" + paramInt3);
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.length() == 0));
        if ((paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '$') && (paramCharSequence.charAt(paramInt1) != 65509) && (paramCharSequence.charAt(paramInt1) != '¥') && (paramCharSequence.charAt(paramInt1) != 65284)) || (this.jdField_s_of_type_Boolean) || (((adiw)a(27)).jdField_a_of_type_Boolean)) {
          break;
        }
      } while (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= paramCharSequence.length()) {
          break label292;
        }
        if ((paramInt2 != paramInt1) && ((paramCharSequence.charAt(paramInt2) == '$') || (paramCharSequence.charAt(paramInt2) == 65509) || (paramCharSequence.charAt(paramInt2) == '¥') || (paramCharSequence.charAt(paramInt2) == 65284))) {
          break;
        }
        paramInt2 += 1;
      }
      paramCharSequence = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((paramCharSequence == null) || (!TroopInfo.hasPayPrivilege(paramCharSequence.troopPrivilegeFlag, 32)));
    if (paramCharSequence.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      paramInt1 = 0;
    }
    for (;;)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "sign", 0, 0, paramCharSequence.troopuin + "", paramInt1 + "", "", "");
      balu.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramCharSequence.troopuin, "input", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      if (paramCharSequence.isAdmin()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
    if ((!this.jdField_s_of_type_Boolean) && (!((adiw)a(27)).jdField_a_of_type_Boolean)) {
      ((adgj)a(34)).b(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    bD();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Xbm != null) && (this.jdField_a_of_type_Xbm.a()))
    {
      this.jdField_a_of_type_Xbm.a();
      ajey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_gift_panel", false);
    }
    if ((paramView.getId() == 2131369274) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void r()
  {
    super.r();
    amom.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  public void s()
  {
    aW();
    ((adji)a(43)).h();
  }
  
  public void t(boolean paramBoolean)
  {
    Object localObject = (LinearLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetImageView.getLayoutParams();
    this.jdField_h_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
    ((LinearLayout.LayoutParams)localObject).width = vzl.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).height = vzl.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    try
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      int k;
      if (paramBoolean)
      {
        k = 2130843265;
        localObject = ((Resources)localObject).getDrawable(k);
        if ((!axmv.b()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label185;
        }
        ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166851), PorterDuff.Mode.MULTIPLY);
        label114:
        if (!paramBoolean) {
          break label217;
        }
        Drawable localDrawable = this.jdField_h_of_type_AndroidWidgetImageView.getDrawable();
        if ((localDrawable instanceof AnimationDrawable)) {
          ((AnimationDrawable)localDrawable).stop();
        }
        ((Drawable)localObject).setBounds(0, 0, vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      label185:
      label217:
      do
      {
        return;
        k = 2130843272;
        break;
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
        {
          ((Drawable)localObject).clearColorFilter();
          break label114;
        }
        ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
        break label114;
        if ((Build.VERSION.SDK_INT < 21) || (this.ao))
        {
          ((Drawable)localObject).setBounds(0, 0, vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
        }
        if (this.t == 2)
        {
          localObject = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843271);
          ((AnimationDrawable)localObject).setOneShot(true);
          ((AnimationDrawable)localObject).setBounds(0, 0, vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
          this.ao = true;
          return;
        }
        if (this.t == 3)
        {
          localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843272);
          ((Drawable)localObject).setBounds(0, 0, vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
        }
      } while (this.t != 4);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843272);
      ((Drawable)localObject).setBounds(0, 0, vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramBoolean = ((adji)a(43)).d();
      this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (paramBoolean)
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void u(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean, this);
    }
    ((adje)a(29)).c(paramBoolean);
    this.V = paramBoolean;
    myb.a().a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((paramBoolean) || (ajey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      ajey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_anonyous", paramBoolean);
    }
    Object localObject;
    if (this.jdField_o_of_type_AndroidViewView == null)
    {
      this.jdField_o_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_o_of_type_AndroidViewView.setBackgroundColor(Color.rgb(19, 19, 21));
      this.jdField_o_of_type_AndroidViewView.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.jdField_o_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_r_of_type_AndroidViewView == null)
    {
      this.jdField_r_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_r_of_type_AndroidViewView.setBackgroundResource(2130843037);
      this.jdField_r_of_type_AndroidViewView.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_r_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.jdField_r_of_type_AndroidViewView, 0);
    }
    if (this.q == null)
    {
      this.q = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.q.setBackgroundResource(2130843037);
      this.q.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.q, 0);
    }
    if (this.p == null)
    {
      this.p = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.p.setBackgroundColor(Color.rgb(19, 19, 21));
      this.p.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368187);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.p, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_a_of_type_Baec != null) {
      this.jdField_a_of_type_Baec.a(paramBoolean);
    }
    if (paramBoolean)
    {
      paramBoolean = ((aruh)a(33)).c();
      localObject = (adji)a(43);
      boolean bool = ((adji)localObject).c();
      if ((!paramBoolean) && (!bool)) {
        A(1);
      }
      this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()))
      {
        ImmersiveUtils.a(false, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
        a(-16777216, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131376255).setVisibility(8);
        actj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130843037);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(myb.c);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(myb.c);
        if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          break label872;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843057);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(myb.c);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(myb.c);
        label571:
        if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_a_of_type_JavaLangCharSequence = this.jdField_f_of_type_AndroidWidgetTextView.getText();
        }
        bL();
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131690050) + myb.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(myb.c);
        actj.a(this.jdField_a_of_type_AndroidWidgetImageView, null);
        c(true);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a.b = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(true);
        }
        this.p.setVisibility(0);
        this.jdField_a_of_type_Myf = new aeuk(this);
        myb.a().a(this.jdField_a_of_type_Myf);
        this.jdField_a_of_type_Aeyv.a();
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(2131696355);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
        {
          actj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130843037);
          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          }
        }
        ((adji)localObject).g();
      }
    }
    for (;;)
    {
      z();
      s();
      this.jdField_a_of_type_Acup.notifyDataSetChanged();
      return;
      a(-16777216, false);
      break;
      label872:
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label571;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130849548);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(myb.c);
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130837689);
      break label571;
      by();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "update");
    }
    if (paramObject == null) {}
    label138:
    label413:
    for (;;)
    {
      return;
      if ((paramObject instanceof MessageRecord)) {
        if ((paramObject instanceof ChatMessage))
        {
          paramObservable = (MessageRecord)paramObject;
          this.jdField_h_of_type_Long = paramObservable.shmsgseq;
          if (paramObservable.isSendFromLocal()) {
            break label230;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((akpx.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (akpx.c(paramObservable.istroop)))) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForTroopEffectPic))) {
            o(false);
          }
          adjl localadjl = (adjl)a(28);
          if (localadjl != null) {
            localadjl.a(paramObservable);
          }
        }
      }
      for (;;)
      {
        if (!(paramObject instanceof MessageForText)) {
          break label413;
        }
        paramObservable = (MessageForText)paramObject;
        if (!paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TroopChatPie.update()");
        }
        bbwo.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, paramObservable.msg, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
        return;
        label230:
        if ((!((akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a().b("highFreqInteract")) || (this.ac)) {
          break label138;
        }
        this.ac = true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable = new TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(false);
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable);
        break label138;
        if ((paramObject instanceof azmr)) {
          b(paramObject);
        } else if ((paramObject instanceof Integer)) {
          switch (((Integer)paramObject).intValue())
          {
          case 123321: 
          default: 
            break;
          case 123322: 
            if ((this.jdField_a_of_type_Baec != null) && (this.jdField_a_of_type_Baec.a())) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(1, this.jdField_a_of_type_Baec.a() / 2);
            } else {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(1);
            }
            break;
          }
        }
      }
    }
  }
  
  public void v()
  {
    bi();
  }
  
  public void v(int paramInt)
  {
    if (!this.V) {
      super.v(paramInt);
    }
  }
  
  public void x()
  {
    Object localObject1;
    Object localObject2;
    int k;
    if ((this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject1 == null) {
        break label195;
      }
      localObject1 = ((TroopManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 == null) {
        break label195;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))) {
        break label195;
      }
      if ((!((String)localObject2).equals(((TroopInfo)localObject1).Administrator)) && (!((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2))) {
        break label183;
      }
      k = 1;
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (k != 0) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        axqy.b((QQAppInterface)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
        VasWebviewUtil.reportCommercialDrainage("", "style", "0X8008E61", "", 1, 0, 0, "", "", "");
        bK();
        return;
        label183:
        k = 0;
        break;
      }
      label195:
      k = 0;
    }
  }
  
  public void z()
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if ((localTroopManager != null) && (localTroopManager.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if ((this.V) || (this.W)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843053);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130849066, 2130849067);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie
 * JD-Core Version:    0.7.0.1
 */
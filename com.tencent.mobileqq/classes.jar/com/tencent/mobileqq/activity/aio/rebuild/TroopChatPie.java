package com.tencent.mobileqq.activity.aio.rebuild;

import abta;
import abti;
import acjm;
import aepc;
import aepd;
import aepi;
import aeqo;
import aeup;
import afdb;
import afee;
import afev;
import afft;
import afgb;
import afgf;
import afgi;
import afgn;
import ageh;
import agem;
import agfa;
import agnj;
import agvl;
import agvm;
import agvn;
import agvo;
import agvp;
import agvq;
import agvr;
import agvs;
import agvt;
import agvu;
import agvw;
import agvx;
import agvy;
import agvz;
import agwa;
import agwb;
import agwc;
import agwd;
import agwe;
import agwf;
import agwg;
import agwh;
import agwi;
import agwj;
import agwk;
import agwl;
import agwm;
import agwn;
import agwo;
import agwp;
import agzf;
import agzq;
import agzu;
import agzw;
import ahap;
import ahat;
import ahau;
import ahax;
import akyn;
import alaz;
import allz;
import aloz;
import alpa;
import altm;
import alud;
import alwx;
import amca;
import amcd;
import amdu;
import ameq;
import amey;
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
import aoiu;
import aojt;
import aoks;
import aory;
import aouu;
import aspf;
import atpc;
import atpl;
import auam;
import awxp;
import azmk;
import azqs;
import azqx;
import azuj;
import baht;
import banh;
import bavt;
import bbmk;
import bbmn;
import bbmp;
import bbpj;
import bbpo;
import bbpw;
import bbqa;
import bbqg;
import bbuf;
import bbuo;
import bbuq;
import bbyd;
import bbye;
import bcdk;
import bcgg;
import bcgs;
import bcgx;
import bcih;
import bciq;
import bcka;
import bclt;
import bcml;
import bcmp;
import bcmt;
import bcoa;
import bcoq;
import bcpa;
import bcpg;
import bcpx;
import bcth;
import bctn;
import bcur;
import bcvo;
import bcwj;
import bcws;
import bcwu;
import bdaq;
import bdes;
import bdeu;
import bdez;
import bdfi;
import bdgc;
import bdgm;
import bdjz;
import bdne;
import bdnm;
import bdnn;
import bdzy;
import bety;
import bfhk;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
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
import com.tencent.mobileqq.widget.QQToast;
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
import lpq;
import mqq.os.MqqHandler;
import nav;
import nax;
import naz;
import nba;
import nev;
import ney;
import org.json.JSONArray;
import org.json.JSONException;
import uvx;
import uwa;
import uwm;
import xpo;
import xsm;
import ytb;
import yut;
import yuu;

public class TroopChatPie
  extends agnj
{
  aepd jdField_a_of_type_Aepd = new agwk(this);
  public agzf a;
  public agzq a;
  agzu jdField_a_of_type_Agzu;
  public agzw a;
  ahat jdField_a_of_type_Ahat;
  ahau jdField_a_of_type_Ahau;
  ahax jdField_a_of_type_Ahax;
  alpa jdField_a_of_type_Alpa = new agvu(this);
  private final altm jdField_a_of_type_Altm = new agvl(this);
  protected alwx a;
  amcd jdField_a_of_type_Amcd = new agvn(this);
  ameq jdField_a_of_type_Ameq = new agvm(this);
  amey jdField_a_of_type_Amey = new agvx(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Handler jdField_a_of_type_AndroidOsHandler;
  public ScrollView a;
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  baht jdField_a_of_type_Baht = new agwi(this);
  private bbmn jdField_a_of_type_Bbmn;
  protected bbuf a;
  private bbye jdField_a_of_type_Bbye;
  bcmt jdField_a_of_type_Bcmt;
  protected bctn a;
  protected bcvo a;
  public bcwj a;
  protected bcwu a;
  protected ConfessPanel a;
  TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable;
  FloatView jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
  private Observer jdField_a_of_type_JavaUtilObserver = new agwe(this);
  naz jdField_a_of_type_Naz;
  public nba a;
  nev jdField_a_of_type_Nev;
  ney jdField_a_of_type_Ney = new agvw(this);
  ytb jdField_a_of_type_Ytb = null;
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
  protected List<agwo> b;
  public LinearLayout c;
  protected bdjz c;
  Runnable c;
  public bdjz d;
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
    this.jdField_b_of_type_AndroidOsHandler = new agvo(this, Looper.getMainLooper());
    this.jdField_a_of_type_Alwx = new agwd(this);
    this.jdField_e_of_type_JavaLangRunnable = new TroopChatPie.37(this);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_d_of_type_JavaLangRunnable = new TroopChatPie.38(this);
  }
  
  private void D(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 12006: 
    case 6001: 
      do
      {
        return;
        if (nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          azqs.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_choosecancel", paramInt, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          return;
        }
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l);
      BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
      return;
    }
    bJ();
  }
  
  private void E(int paramInt)
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
        bool = I();
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
          break label209;
        }
      }
    }
    label209:
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
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, localTroopInfo.troopuin, "2", (String)localObject1, "");
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
  
  private boolean I()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    bcpg localbcpg = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    }
    if (localObject == null)
    {
      bool2 = bool1;
      return bool2;
    }
    localObject = (bciq[])((Editable)localObject).getSpans(0, localObject.toString().length(), bciq.class);
    int k = 0;
    for (;;)
    {
      bool1 = bool2;
      if (k < localObject.length)
      {
        if (localbcpg.b(localObject[k].a())) {
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
  
  private void a(int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            int k;
            do
            {
              do
              {
                return;
                localObject = aepi.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
                ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
                this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject);
                return;
                h(paramIntent);
                return;
                bcoq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                return;
                ar();
                paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
              } while (paramInt <= 0);
              k = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().charAt(paramInt - 1);
            } while ((k != 36) && (k != 65509) && (k != 165) && (k != 65284));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().delete(paramInt - 1, paramInt));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramInt - 1);
            return;
          } while (this.jdField_a_of_type_Yuu == null);
          localObject = this.jdField_a_of_type_Yuu.a();
        } while (localObject == null);
        ((TroopGiftPanel)localObject).a(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
        return;
        paramIntent = paramIntent.getStringExtra("result");
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } while ((TextUtils.isEmpty(paramIntent)) || (localObject == null) || (paramIntent.equals(((TroopInfo)localObject).troopname)));
      ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramIntent;
      Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
      ((Intent)localObject).putExtra("uinname", paramIntent);
      b((Intent)localObject);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(paramInt, paramIntent);
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
    label254:
    do
    {
      return;
      bcws localbcws = (bcws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234);
      String str = localbcws.a(paramString);
      bool1 = ((atpl)a(33)).c();
      bool2 = ((afgf)a(43)).c();
      if ((!this.V) && (!bool1) && (!bool2) && (!TextUtils.isEmpty(str)))
      {
        if (this.t != 2)
        {
          A(2);
          if (paramBoolean)
          {
            if (localbcws.a(paramString) != 3) {
              break label191;
            }
            bdes.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { paramString });
          }
        }
        for (;;)
        {
          c(true);
          this.jdField_f_of_type_AndroidWidgetTextView.setText(str);
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
          if (this.jdField_a_of_type_Bcwj == null) {
            break label254;
          }
          this.jdField_a_of_type_Bcwj.a(paramString);
          if (!this.jdField_a_of_type_Bcwj.a()) {
            break;
          }
          this.jdField_a_of_type_Bcwj.d();
          v(true);
          return;
          new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
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
  
  private void bJ()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label33;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
    }
    for (;;)
    {
      aojt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      return;
      label33:
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
  }
  
  private void bK()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    int k;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label96;
      }
      k = 0;
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "un", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, k + "", "", "");
      return;
      label96:
      if (localTroopInfo.isAdmin()) {
        k = 1;
      } else {
        k = 2;
      }
    }
  }
  
  private void bL()
  {
    ThreadManager.post(new TroopChatPie.6(this), 5, null, true);
  }
  
  private void bM()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, String.format("updateTroopHonorInteractiveIcon, troopUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
    }
    bcgg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_f_of_type_AndroidWidgetImageView, this.L);
  }
  
  private void bN()
  {
    this.jdField_a_of_type_Bbmn = new agvy(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Bbmn);
  }
  
  private void bO()
  {
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130845746));
    }
    for (;;)
    {
      azmk.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.mSystemBarComp, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
      return;
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166959), true);
    }
  }
  
  private void bP()
  {
    if ((bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (bdeu.a(this.jdField_a_of_type_AndroidContentContext))) {}
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
    bcpx.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent.getExtras(), 1, 2000);
  }
  
  private void bQ()
  {
    if ((this.jdField_a_of_type_Bcwj != null) && (this.jdField_a_of_type_Bcwj.a()))
    {
      if (this.jdField_a_of_type_Bcwj.a() == 2)
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
  
  private void bR()
  {
    if (A()) {
      return;
    }
    if (this.jdField_a_of_type_Agzu == null) {
      this.jdField_a_of_type_Agzu = new agzu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_Agzu.a(this.jdField_a_of_type_Ahap);
  }
  
  private void bS()
  {
    if (this.ap) {
      return;
    }
    ((aoiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
    Object localObject = paramIntent.getExtras().getString("troop_uin");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    String str2;
    String str1;
    do
    {
      return;
      str2 = paramIntent.getExtras().getString("member_uin");
      str1 = paramIntent.getExtras().getString("member_display_name");
      if ((!paramIntent.getExtras().getBoolean("isApollo")) || (this.jdField_a_of_type_Allz == null)) {
        break;
      }
    } while ("0".equals(str2));
    paramIntent = null;
    if (!F()) {
      paramIntent = bdgc.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2);
    }
    localObject = paramIntent;
    if (TextUtils.isEmpty(paramIntent)) {
      localObject = str1;
    }
    paramIntent = new StringBuilder("@").append((String)localObject);
    this.jdField_a_of_type_Allz.a.peerUin = str2;
    this.jdField_a_of_type_Allz.a.atNickName = paramIntent.toString();
    this.jdField_a_of_type_Allz.a.inputText = banh.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
    a(this.jdField_a_of_type_Allz);
    int k;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Allz.a.inputText))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_Allz.b)) {
        break label482;
      }
      if (this.jdField_a_of_type_Allz.d == 0) {
        k = 6;
      }
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int m = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      str2 = "" + this.jdField_a_of_type_Allz.a.actionId;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Allz.b)) {}
      for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_Allz.b)
      {
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str1, k, m, new String[] { str2, paramIntent, this.jdField_a_of_type_Allz.a.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
        if (this.jdField_a_of_type_Allz.d != 1) {
          break label482;
        }
        k = 7;
        break;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Allz.b))
        {
          k = 3;
          break;
        }
        if (this.jdField_a_of_type_Allz.d == 0)
        {
          k = 4;
          break;
        }
        if (this.jdField_a_of_type_Allz.d != 1) {
          break label477;
        }
        k = 5;
        break;
      }
      a(str2, str1, true, 4);
      return;
      label477:
      k = 0;
      continue;
      label482:
      k = 2;
    }
  }
  
  private void i(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_Ahau != null) && (this.jdField_a_of_type_Ahau.a()) && (auam.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Ahap.a();
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false))) {
      a().getIntent().putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
    }
  }
  
  private void j(Intent paramIntent)
  {
    this.ap = false;
    String str = paramIntent.getStringExtra("uin");
    this.ae = ((aoiu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b(str, paramIntent);
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
      if (((afgf)a(43)).d()) {
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
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOshortcut", "Clk_shortcut", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1, "", "");
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
      ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt, 0);
    }
  }
  
  public boolean F()
  {
    return false;
  }
  
  public void G()
  {
    super.G();
    bR();
  }
  
  public void H()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(true);
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.ac = false;
    this.ab = false;
    if (this.jdField_a_of_type_Bbuf != null) {
      this.jdField_a_of_type_Bbuf.e();
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
        bS();
      }
      ((afdb)a(34)).a();
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.a();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView = null;
      }
      if (this.jdField_a_of_type_Nba != null)
      {
        this.jdField_a_of_type_Nba.dismiss();
        this.jdField_a_of_type_Nba = null;
      }
      if (this.jdField_a_of_type_Nev != null) {
        this.jdField_a_of_type_Nev.a();
      }
      nav.a().b();
      if (this.V) {
        a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166959), true);
      }
      agem.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_Ytb != null)
      {
        this.jdField_a_of_type_Ytb.dismiss();
        this.jdField_a_of_type_Ytb = null;
      }
      if (this.jdField_a_of_type_Yuu != null) {
        this.jdField_a_of_type_Yuu = null;
      }
      Object localObject = (bcml)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
      ((bcml)localObject).e("");
      if (((bcml)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        ((bcml)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      C(0);
      this.jdField_r_of_type_Int = 0;
      this.ah = false;
      this.aj = false;
      this.al = false;
      this.ak = false;
      localObject = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      ((bcpg)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.g, "off");
      ((bcpg)localObject).a(null);
      ((uvx)uwa.a(5)).c();
      ((uwm)uwa.a(2)).d();
      ((xpo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(208)).a();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        abti.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
      }
      if (this.jdField_a_of_type_Bcwj != null)
      {
        this.jdField_a_of_type_Bcwj.a();
        this.jdField_a_of_type_Bcwj = null;
      }
      A(0);
      if (this.jdField_a_of_type_Bctn != null) {
        this.jdField_a_of_type_Bctn.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = null;
      }
      super.H();
      if (this.jdField_b_of_type_AndroidOsHandler != null)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "doOnDestroy, timerHandler->removeCallbacksAndMessages");
        }
      }
      bcih.a().a();
      if (this.jdField_a_of_type_Bcwu != null)
      {
        this.jdField_a_of_type_Bcwu.b();
        this.jdField_a_of_type_Bcwu = null;
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((this.jdField_d_of_type_Bdjz != null) && (this.jdField_d_of_type_Bdjz.isShowing())) {
        this.jdField_d_of_type_Bdjz.dismiss();
      }
      if (this.jdField_a_of_type_Bbye != null) {
        this.jdField_a_of_type_Bbye.b();
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
            ageh.jdField_a_of_type_JavaUtilHashMap.clear();
            ageh.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
            aojt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
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
            if (this.jdField_a_of_type_Aepc != null) {
              this.jdField_a_of_type_Aepc.a(null);
            }
            if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null)) {
              break;
            }
            if (Build.VERSION.SDK_INT >= 16) {
              break label885;
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
              label885:
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
            }
          }
        }
      }
    }
  }
  
  boolean H()
  {
    if (this.jdField_a_of_type_Bcgx == null) {}
    boolean bool = bcpa.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
  
  public void L()
  {
    if (this.V) {
      bO();
    }
    if (this.jdField_a_of_type_Bcmt != null)
    {
      bcmp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcmt);
      this.jdField_a_of_type_Bcmt = null;
    }
    if ((this.jdField_a_of_type_Ytb == null) || (!this.jdField_a_of_type_Ytb.isShowing()))
    {
      bcka localbcka = (bcka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
      if (localbcka != null) {
        localbcka.c();
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    if (this.jdField_a_of_type_Bcvo != null) {
      this.jdField_a_of_type_Bcvo.a();
    }
    if (bcih.a().a()) {
      bcih.a().b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(true);
    }
    super.L();
  }
  
  public void M()
  {
    if (this.jdField_a_of_type_Bcwu != null) {
      this.jdField_a_of_type_Bcwu.a();
    }
    if (this.jdField_a_of_type_Bbuf != null) {
      this.jdField_a_of_type_Bbuf.d();
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    super.M();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Ytb == null) || (!this.jdField_a_of_type_Ytb.isShowing()))
    {
      localObject = (bcka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
      if (localObject != null) {
        ((bcka)localObject).c();
      }
    }
    if (bcih.a().a()) {
      bcih.a().b();
    }
    Object localObject = (bbuq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231);
    ((bbuq)localObject).jdField_a_of_type_Int = 0;
    ((bbuq)localObject).b = 0;
    ((bbuq)localObject).c = 0;
    ((bbuq)localObject).d = 0;
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "doOnPause, isTroopOwner =" + this.af);
    }
  }
  
  public void N()
  {
    super.N();
    if (this.V)
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843228);
      nav.a().a(this.jdField_a_of_type_Naz);
      a(-16777216, false);
    }
    by();
  }
  
  public void P()
  {
    super.P();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 2)
    {
      this.U = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true);
      if (this.U) {
        bw();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(0);
    }
    this.jdField_a_of_type_Bbuf = a();
    this.jdField_a_of_type_Bbuf.c();
    this.jdField_a_of_type_Bbuf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    aojt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_Bctn.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.e();
    }
  }
  
  public void Q()
  {
    super.Q();
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localIntent == null) {
      return;
    }
    String str = localIntent.getStringExtra("uin");
    int k = localIntent.getIntExtra("uintype", -1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(str)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != k))) {}
    for (k = 1;; k = 0)
    {
      if ((k != 0) && (this.jdField_a_of_type_Bcgx != null))
      {
        this.jdField_a_of_type_Bcgx.b();
        this.jdField_a_of_type_Bcgx = null;
      }
      if ((k != 0) && (this.jdField_a_of_type_Bbye != null) && (this.jdField_a_of_type_Bbye.a != null))
      {
        this.jdField_a_of_type_Bbye.a.b();
        this.jdField_a_of_type_Bbye.a = null;
      }
      if (this.jdField_a_of_type_Bcmt != null)
      {
        bcmp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcmt);
        this.jdField_a_of_type_Bcmt = null;
      }
      this.jdField_i_of_type_Boolean = true;
      return;
    }
  }
  
  public void R()
  {
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (this.jdField_a_of_type_Bcur != null)) {
      this.jdField_a_of_type_Bcur.c();
    }
    super.R();
  }
  
  public ahat a()
  {
    return this.jdField_a_of_type_Ahat;
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 35)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = ((ConfessPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558565, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this);
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel;; localObject = super.a(paramInt))
    {
      if ((localObject instanceof PlusPanel)) {
        ((PlusPanel)localObject).setPagerChangedListener(new agwf(this));
      }
      return localObject;
    }
  }
  
  public ImageView a()
  {
    return this.jdField_d_of_type_AndroidWidgetImageView;
  }
  
  public bbuf a()
  {
    if (this.jdField_a_of_type_Bbuf == null) {
      this.jdField_a_of_type_Bbuf = new bbuf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364139));
    }
    return this.jdField_a_of_type_Bbuf;
  }
  
  public bcvo a()
  {
    if (this.jdField_a_of_type_Bcvo == null)
    {
      this.jdField_a_of_type_Bcvo = new bcvo();
      this.jdField_a_of_type_Bcvo.a(this);
    }
    return this.jdField_a_of_type_Bcvo;
  }
  
  public bcwu a()
  {
    if (this.jdField_a_of_type_Bcwu == null) {
      this.jdField_a_of_type_Bcwu = new bcwu(this.jdField_c_of_type_AndroidWidgetLinearLayout);
    }
    return this.jdField_a_of_type_Bcwu;
  }
  
  public PanelIconLinearLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  }
  
  public EntryModel a()
  {
    return bcpx.a(((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
      bQ();
    }
    if (this.jdField_a_of_type_Bbye != null) {
      this.jdField_a_of_type_Bbye.a();
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
    if (paramInt1 == 2000) {
      i(paramIntent);
    }
    if ((paramInt1 != 5) && (paramInt1 != 2000) && (b(true))) {
      return;
    }
    if (paramInt2 == -1) {
      a(paramInt1, paramIntent);
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == 8001)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        }
      }
      else if (paramInt1 == 12005) {
        bK();
      } else if (paramInt2 == 0) {
        D(paramInt1);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Nba == null) {
      this.jdField_a_of_type_Nba = new nba(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_Nba.a(paramInt, paramString);
    this.jdField_a_of_type_Nba.show();
    TroopChatPie.31 local31;
    if ((paramInt == 1) || (paramInt == 3))
    {
      paramString = this.jdField_a_of_type_MqqOsMqqHandler;
      local31 = new TroopChatPie.31(this);
      if (!AppSetting.c) {
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
    TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong1, paramLong2, new agwm(this, false));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
    }
    if ((this.jdField_c_of_type_Bdjz != null) && (this.jdField_c_of_type_Bdjz.isShowing())) {
      if ((paramLong == 1L) || (paramLong == 2L)) {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog, CreditLevelTipDialog isShowing:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
        }
      }
    }
    do
    {
      return;
      this.jdField_c_of_type_Bdjz.dismiss();
      if (paramLong == 1L)
      {
        this.jdField_c_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720808)).setMessage(2131697991);
        this.jdField_c_of_type_Bdjz.setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691277), new agvp(this));
        this.jdField_c_of_type_Bdjz.setNegativeButton(alud.a(2131715666), new agvq(this));
        this.jdField_c_of_type_Bdjz.setPositiveButtonContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691277));
        this.jdField_c_of_type_Bdjz.setNegativeButtonContentDescription(alud.a(2131715664));
        this.jdField_c_of_type_Bdjz.setCancelable(false);
        this.jdField_c_of_type_Bdjz.show();
        new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_banned").c("Grp_AIO").d("exp_msgbox").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }).a();
        return;
      }
      if ((paramLong == 2L) && (!paramBoolean))
      {
        this.jdField_c_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720808)).setMessage(2131697990);
        this.jdField_c_of_type_Bdjz.setPositiveButton(2131697988, new agvr(this));
        this.jdField_c_of_type_Bdjz.setNegativeButton("", null);
        this.jdField_c_of_type_Bdjz.setCancelable(false);
        this.jdField_c_of_type_Bdjz.show();
        return;
      }
    } while ((paramLong != 2L) || (!paramBoolean));
    this.jdField_c_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720808)).setMessage(2131697989);
    this.jdField_c_of_type_Bdjz.setNegativeButton(2131697988, new agvs(this));
    this.jdField_c_of_type_Bdjz.setPositiveButton(2131697987, new agvt(this));
    this.jdField_c_of_type_Bdjz.setCancelable(false);
    this.jdField_c_of_type_Bdjz.show();
  }
  
  public void a(agwo paramagwo)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramagwo);
  }
  
  public void a(Intent paramIntent)
  {
    A(0);
    if ((this.V) && (!nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
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
      if ((this.V) && (nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131690097) + nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
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
                String str3 = bdgc.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject3);
                localObject3 = bciq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject3, str3, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
                if ((localObject3 != null) && (((SpannableString)localObject3).length() != 0)) {
                  this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject3);
                }
                k += 1;
                continue;
                if (!nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                u(true);
                this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843228);
                this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130843234);
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
        localObject2 = (afft)a(27);
        if (localObject2 != null) {
          ((afft)localObject2).a("0", str2, str1);
        }
      }
      if (paramIntent.getBooleanExtra("sendGift", false)) {
        a(true, TroopGiftPanel.jdField_f_of_type_Int);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Aeup != null)) {
        this.jdField_a_of_type_Aeup.a();
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      ((afgf)a(43)).h();
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
    int k = paramIntent.getIntExtra(bdez.jdField_h_of_type_JavaLangString, -1);
    if (((k == 2) || (k == 1)) && (b(true))) {
      return;
    }
    super.a(paramIntent, paramInt);
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131377198)
    {
      if (this.t == 2)
      {
        if (this.jdField_a_of_type_Bcwj == null) {
          this.jdField_a_of_type_Bcwj = new bcwj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_a_of_type_Bbqg);
        }
        this.jdField_a_of_type_Bcwj.a(a().jdField_a_of_type_JavaLangString);
        if (!this.jdField_a_of_type_Bcwj.b()) {}
      }
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_Bcwj.a()) {
            break;
          }
          bQ();
        } while (this.jdField_a_of_type_Bcwj.b == 2);
        new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryClose").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        return;
        this.jdField_a_of_type_Bcwj.a(1);
        paramView = (amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
        if (paramView != null) {
          paramView.u(a().jdField_a_of_type_JavaLangString);
        }
        t(true);
        if (this.jdField_a_of_type_Bcwj.b == 2)
        {
          bdes.a("Grp_idol", "Grp_AIO", "clk_renshu", 0, 0, new String[] { a().jdField_a_of_type_JavaLangString });
          return;
        }
        new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryOpen").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        return;
        if (this.t == 3)
        {
          ((atpl)a(33)).b();
          return;
        }
      } while (this.t != 4);
      ((afgf)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    bP();
  }
  
  public void a(bcoa parambcoa)
  {
    if (parambcoa.jdField_a_of_type_Boolean) {
      if ((1 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (3 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (8 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && ((this.jdField_f_of_type_Int != 1) || (this.m != 0)))
      {
        ak();
        if (this.jdField_h_of_type_AndroidWidgetTextView != null)
        {
          QLog.d("troop_gag", 1, "fightgag.updateGagStatus_UI:" + parambcoa.b);
          this.jdField_h_of_type_AndroidWidgetTextView.setText(parambcoa.b);
        }
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "updateGagStatus_UI, sendEmptyMessageDelayed-TIMER_ID:" + parambcoa.jdField_a_of_type_Long + ", hasDestory=" + this.N);
        }
        if (!this.N)
        {
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, parambcoa.jdField_a_of_type_Long * 1000L);
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
      br();
      this.jdField_i_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "updateGagStatus enable fastimage,  mAllowFastImage = " + this.jdField_i_of_type_Boolean);
  }
  
  public void a(bcoa parambcoa, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (parambcoa == null) {
        ThreadManager.post(new TroopChatPie.15(this, paramBoolean), 8, null, true);
      }
    }
    else {
      return;
    }
    a(parambcoa);
  }
  
  public void a(Object paramObject)
  {
    aepi.n = true;
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
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          continue;
          if (this.V) {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_PTT", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
          if (this.X)
          {
            new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_icon_clk").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.g }).a();
            continue;
            if (this.V)
            {
              azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              continue;
              if (this.V) {
                azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              }
            }
          }
        }
      }
    }
    if (!F()) {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    if (this.jdField_a_of_type_Yuu == null) {
      this.jdField_a_of_type_Yuu = new yuu(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel);
    }
    yuu localyuu = this.jdField_a_of_type_Yuu;
    int n = TroopGiftPanel.e;
    if (nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    for (int k = 4;; k = 1)
    {
      localyuu.a(n, k);
      bbmk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bbmp.a(c()));
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
        break label477;
      }
      localObject = acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.c);
      if (localObject != null) {
        break label136;
      }
      return;
      k = 0;
      break;
    }
    label136:
    ((MessageForPtt)localObject).c2cViaOffline = bool1;
    if (!bdnn.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
      ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
    }
    long l1 = ((MessageRecord)localObject).uniseq;
    bavt.a.put(paramString, Long.valueOf(l2));
    if (!bool1)
    {
      azuj.a(paramString, false);
      azuj.a(paramString);
      label204:
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + l1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!E) {
        break label562;
      }
    }
    label562:
    for (int k = 1;; k = 2)
    {
      azqs.b((QQAppInterface)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", k, 0, "", "", "", "8.3.5");
      E = true;
      k = a(paramInt1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
      ArrayList localArrayList = new ArrayList();
      String str2 = bciq.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      bcpg localbcpg = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
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
        } while (!localbcpg.a(((MessageForText.AtTroopMemberInfo)localIterator.next()).uin));
        bool2 = true;
      }
      acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, str1, paramString, l1, false, paramInt2, paramRecorderParam.c, bool1, paramInt3, k, paramBoolean, paramRecorderParam.d, (Bundle)localObject, localArrayList, str2, bool2, paramInt4);
      b(paramInt1, paramInt2);
      a(0, paramString, l1);
      return;
      label477:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 0, paramLong);
      l1 = paramLong;
      if (!MessageForPtt.class.isInstance(localObject)) {
        break;
      }
      ((MessageForPtt)localObject).voiceLength = QQRecorder.a(paramInt2);
      l1 = paramLong;
      if (bdnn.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
        break;
      }
      ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
      l1 = paramLong;
      break;
      awxp.b(paramString);
      break label204;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    bcpg localbcpg = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if ((localbcpg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localbcpg.b(paramString1)))
    {
      if (I()) {
        return;
      }
      this.g = paramString1;
      localbcpg.e = paramString1;
      this.jdField_h_of_type_JavaLangString = paramString2;
    }
    super.a(paramString1, paramString2, paramBoolean, paramInt);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
    super.a(paramList, paramCharSequence, paramInt);
    if ((0xFFFF & paramInt) == 4)
    {
      ((bbpw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(225)).a(paramList);
      if (this.jdField_a_of_type_Bbqg != null) {
        this.jdField_a_of_type_Bbqg.a().f();
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
        localObject3 = aepi.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, k);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handGetTroopMemberCard ref itemView=" + localObject3 + ",index=" + k);
        }
        if (localObject3 == null) {
          break label549;
        }
        localObject3 = (TextView)((View)localObject3).findViewById(2131367292);
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
      if ((this.jdField_a_of_type_Bbye != null) && ((this.jdField_a_of_type_Bbye.a instanceof bcgs)))
      {
        localObject1 = (bcgs)this.jdField_a_of_type_Bbye.a;
        if (((Boolean)paramObject[3]).booleanValue()) {
          break label544;
        }
      }
      label544:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((bcgs)localObject1).a(paramBoolean, null, this);
        bR();
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
    bcih.a().a(this);
    this.jdField_a_of_type_Bctn = new bctn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_time", "Grp_AIO", "visit_time");
    bfhk.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), true);
    Object localObject = (afee)this.jdField_a_of_type_Afev.a(52);
    if (localObject != null) {
      ((afee)localObject).a();
    }
    return true;
  }
  
  public void aY()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c();
  }
  
  public void aa()
  {
    super.aa();
    ((afgf)a(43)).h();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    paramEditable = (afft)a(27);
    if (paramEditable != null) {
      paramEditable.b();
    }
  }
  
  public void ai()
  {
    bt();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      if (localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
        a(0L, 0L);
      }
      if (aouu.c().mIsEnable)
      {
        localObject = (amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        if (!localTroopManager.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label522;
        }
        ((amca)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        QLog.e("vip_pretty.", 1, "get the troop expired info from server");
      }
    }
    if ((localTroopInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "aio onShow:" + localTroopInfo.troopuin + ", sysFlag=" + localTroopInfo.cGroupRankSysFlag + ", userFlag=" + localTroopInfo.cGroupRankUserFlag);
    }
    super.ai();
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
          if (this.jdField_a_of_type_Ahax == null)
          {
            this.jdField_a_of_type_Ahax = new ahax(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Ahap);
            this.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_Ahax);
          }
          this.jdField_a_of_type_Ahax.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_Ahax, new Object[0]))
          {
            this.al = true;
            localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, k + 1);
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_up", "", "Grp_AIO", "exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
        }
      }
      return;
      label522:
      if (QLog.isColorLevel()) {
        QLog.d("vip_pretty.", 1, "get the troop expired info from local");
      }
      TroopManager.a(localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Ahap);
      break;
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Alwx);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ameq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alpa);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amcd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amey);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Baht);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Amny);
    }
    bN();
    ((aspf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alwx);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ameq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alpa);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amcd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amey);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Baht);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Bbmn);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Amny);
    }
    ((aspf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void aq_()
  {
    super.aq_();
    if ((this.jdField_a_of_type_Bbqg != null) && (!E())) {
      this.jdField_a_of_type_Bbqg.a().e();
    }
  }
  
  public void as()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clickSendTextButton. isSending:" + this.Z);
    }
    if (!this.Z) {
      this.Z = true;
    }
    for (int k = 1;; k = 0)
    {
      super.as();
      if (k == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clickSendTextButton process talking state");
      }
      bcpg localbcpg = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      boolean bool2 = localbcpg.a();
      Object localObject = localbcpg.b;
      String str1 = localbcpg.c;
      ArrayList localArrayList = new ArrayList();
      String str2 = bciq.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      k = 0;
      label259:
      boolean bool3;
      if (k < localArrayList.size())
      {
        MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(k);
        if (localbcpg.a(localAtTroopMemberInfo.uin))
        {
          localObject = "" + localAtTroopMemberInfo.uin;
          str1 = bdgc.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject);
          if ((bool2) || (localbcpg.a(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            bool1 = true;
            bool3 = localbcpg.b(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            bool2 = bool1;
          }
        }
      }
      for (boolean bool1 = bool3;; bool1 = false)
      {
        if ((bool2) && (!bool1))
        {
          localObject = bciq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
          a(localbcpg.b, localbcpg.c, true, 0);
        }
        for (;;)
        {
          this.Z = false;
          return;
          bool1 = false;
          break label259;
          k += 1;
          break;
          agfa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if ((str2 == null) || (str2.length() <= 3478)) {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
          }
          if (this.X)
          {
            w(false);
            localObject = (afgn)a(23);
            if (localObject != null) {
              ((afgn)localObject).a(false);
            }
          }
          this.Y = false;
          localbcpg.a();
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
    bM();
  }
  
  public boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.ag)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (paramBoolean) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697834, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
      ak();
      bool = true;
    }
    return bool;
  }
  
  public void bA()
  {
    amdu localamdu = (amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localamdu != null) {}
    try
    {
      localamdu.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 0L, 2, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, localException.toString());
    }
  }
  
  void bB()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground() != null) {
      n();
    }
    bO();
    this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166900));
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166900));
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850060);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166897));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166897));
      aepi.a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850069);
      if ((this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_f_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_f_of_type_AndroidWidgetTextView.getText().toString().startsWith(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131690097))))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText("");
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166900));
        c(false);
      }
      bcws localbcws = (bcws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234);
      String str = localbcws.a(a().jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(str)) {
        break label609;
      }
      A(2);
      if (localbcws.a(a().jdField_a_of_type_JavaLangString) != 3) {
        break label552;
      }
      bdes.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { a().jdField_a_of_type_JavaLangString });
      label303:
      c(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166900));
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
      nav.a().b();
      bE();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(1.0F, 0.0F, 1.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131165372));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        aepi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130849330);
      }
      bC();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      ((afgf)a(43)).g();
      return;
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130850061);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166897));
      break;
      label552:
      new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
      break label303;
      label609:
      A(0);
    }
  }
  
  public void bC()
  {
    if (this.jdField_a_of_type_Ahap != null)
    {
      akyn localakyn = akyn.a();
      if (localakyn != null) {
        localakyn.f();
      }
    }
  }
  
  public void bD()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new agwa(this));
    if ((this.jdField_r_of_type_AndroidViewView != null) && (this.q != null))
    {
      this.jdField_r_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      this.q.startAnimation(localAlphaAnimation);
    }
  }
  
  public void bE()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new agwc(this));
    this.jdField_r_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    this.q.startAnimation(localAlphaAnimation);
  }
  
  public void bF()
  {
    if ((this.jdField_c_of_type_Bety != null) && (this.jdField_c_of_type_Bety.isShowing()) && (!a().isFinishing())) {
      this.jdField_c_of_type_Bety.dismiss();
    }
  }
  
  protected void bG()
  {
    Object localObject1 = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    Object localObject2;
    String str1;
    int k;
    boolean bool;
    if (((bcpg)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (!this.Z)
      {
        localObject2 = (bciq[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(0, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString().length(), bciq.class);
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        k = 0;
        if (k >= localObject2.length) {
          break label438;
        }
        if (!((bcpg)localObject1).b(localObject2[k].a())) {
          break label247;
        }
        String str2 = localObject2[k].a();
        this.g = str2;
        ((bcpg)localObject1).e = str2;
        this.jdField_h_of_type_JavaLangString = localObject2[k].b();
        if (!this.jdField_h_of_type_JavaLangString.startsWith("@")) {
          break label433;
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
        ((afgb)a(29)).d(bool);
        if (this.Y == bool) {
          if (bool)
          {
            localObject1 = (afgn)a(23);
            if (localObject1 != null) {
              ((afgn)localObject1).b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount());
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
                  break label363;
                }
                w(false);
                localObject2 = (afgn)a(23);
                if (localObject2 != null) {
                  ((afgn)localObject2).a(false);
                }
              } while (!((bcpg)localObject1).a());
              ((bcpg)localObject1).a();
              bcpg.a("panel", "talk_out", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(), "2", "");
              ((bcpg)localObject1).b(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), Long.parseLong(this.g), "off", new agwg(this));
              return;
            } while (this.X);
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(str1, this.g, this.jdField_h_of_type_JavaLangString, this, new agwh(this));
            return;
          } while (!this.X);
          w(false);
          localObject1 = (afgn)a(23);
        } while (localObject1 == null);
        label363:
        ((afgn)localObject1).a(false);
        return;
      }
      label433:
      bool = true;
      continue;
      label438:
      bool = false;
    }
  }
  
  public void bH()
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView == null) {
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365320));
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
  
  public void bI()
  {
    if ((this.jdField_h_of_type_AndroidWidgetImageView == null) || (this.jdField_f_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_e_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Object localObject = (atpl)a(33);
    boolean bool1 = ((atpl)localObject).c();
    boolean bool2 = ((atpl)localObject).d();
    afgf localafgf = (afgf)a(43);
    boolean bool3 = localafgf.c();
    int k;
    if (bool1)
    {
      A(3);
      c(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(((atpl)localObject).a(bool2));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166900));
      t(bool2);
      k = aepi.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
      atpc.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, k, 0, 0);
    }
    label147:
    while ((QLog.isColorLevel()) && (QLog.isColorLevel()))
    {
      QLog.d("BaseListenTogetherPanel_Troop", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
      return;
      if (bool3)
      {
        bool3 = localafgf.a();
        A(4);
        c(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(localafgf.a());
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166900));
        t(bool3);
        k = aepi.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        atpc.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, k, 0, 0);
      }
      else
      {
        localObject = ((bcws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a(a().jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label380;
        }
        A(2);
        c(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166900));
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        v(false);
      }
    }
    for (;;)
    {
      atpc.a(this.jdField_b_of_type_AndroidViewViewGroup);
      break label147;
      break;
      label380:
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
      A(0);
    }
  }
  
  public void bd()
  {
    super.bd();
    bQ();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    ((afdb)a(34)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void bq()
  {
    super.bq();
    this.jdField_a_of_type_Afev.a(this);
  }
  
  public void bs()
  {
    boolean bool = false;
    super.bs();
    if (this.jdField_a_of_type_Bcmt == null)
    {
      agwp localagwp = new agwp(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bcmt = new bcmt(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localagwp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    bcmp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcmt);
    b(false);
    if (this.V != nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (!this.V) {
        bool = true;
      }
      this.V = bool;
      u(this.V);
    }
    ((bcml)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void bt()
  {
    super.bt();
    this.u = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ThreadManager.post(new TroopChatPie.24(this), 8, null, true);
    bz();
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
    for (boolean bool1 = H();; bool1 = false)
    {
      if (!bool1) {
        if ((this.jdField_a_of_type_Ytb != null) && (this.jdField_a_of_type_Ytb.isShowing())) {
          bool1 = true;
        }
      }
      for (;;)
      {
        localObject = (bcka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
        if (localObject != null) {}
        for (boolean bool2 = ((bcka)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; bool2 = false)
        {
          if ((localObject != null) && (bool2) && (bool1)) {
            ((bcka)localObject).b = false;
          }
          if ((!bool1) && (bool2))
          {
            bcka.jdField_a_of_type_Boolean = true;
            o(true);
          }
          localObject = atpl.a(this);
          if (localObject != null)
          {
            if ((bool1) || (bool2))
            {
              bool1 = true;
              label276:
              ((atpl)localObject).a(bool1);
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
              this.jdField_a_of_type_Nev.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ney, true);
            }
          }
          for (;;)
          {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
            ThreadManager.getSubThreadHandler().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 500L);
            bH();
            this.ah = true;
            if ((this.ad) && (this.jdField_a_of_type_Bbye != null))
            {
              this.jdField_a_of_type_Bbye.a(true);
              this.ad = false;
            }
            localObject = (bbuq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231);
            if ((((bbuq)localObject).jdField_a_of_type_Int != 0) && (!nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!azmk.b()))
            {
              ((bbuq)localObject).a(new bbuo(((bbuq)localObject).e, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((bbuq)localObject).b, ((bbuq)localObject).c, ((bbuq)localObject).d, ((bbuq)localObject).jdField_a_of_type_Int));
              localObject = a();
              ((bbuf)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
              ((bbuf)localObject).a();
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
            bclt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  protected void bw()
  {
    g(true);
    TroopChatPie.1 local1 = new TroopChatPie.1(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, local1, 9);
  }
  
  public void bx()
  {
    if (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
      ThreadManager.post(this.jdField_c_of_type_JavaLangRunnable, 8, null, true);
    }
  }
  
  protected void by()
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
      if ((this.jdField_c_of_type_Bdjz != null) && (this.jdField_c_of_type_Bdjz.isShowing())) {
        this.jdField_c_of_type_Bdjz.dismiss();
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
      localObject = (amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, getTroopCreditInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        ((amdu)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      }
      a(l, bool3);
      return;
      bool1 = false;
      break;
    }
  }
  
  void bz()
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
            ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a((ArrayList)localObject);
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
  
  public void c()
  {
    if (b(true)) {
      return;
    }
    bcpg localbcpg = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    boolean bool2 = localbcpg.a();
    Object localObject = localbcpg.b;
    String str1 = localbcpg.c;
    this.Z = true;
    ArrayList localArrayList = new ArrayList();
    String str2 = bciq.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    int k = 0;
    label196:
    boolean bool3;
    if (k < localArrayList.size())
    {
      MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(k);
      if (localbcpg.a(localAtTroopMemberInfo.uin))
      {
        localObject = "" + localAtTroopMemberInfo.uin;
        str1 = bdgc.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject);
        if ((bool2) || (localbcpg.a(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          bool1 = true;
          bool3 = localbcpg.b(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          bool2 = bool1;
        }
      }
    }
    for (boolean bool1 = bool3;; bool1 = false)
    {
      super.c();
      if ((bool2) && (!bool1))
      {
        localObject = bciq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
        a(localbcpg.b, localbcpg.c, true, 0);
      }
      for (;;)
      {
        this.Z = false;
        return;
        bool1 = false;
        break label196;
        k += 1;
        break;
        agfa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((str2 == null) || (str2.length() <= 3478)) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        }
        if (this.X)
        {
          w(false);
          localObject = (afgn)a(23);
          if (localObject != null) {
            ((afgn)localObject).a(false);
          }
        }
        this.Y = false;
        localbcpg.a();
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
    aY();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    bdnm.a(null, "AIO_updateSession_business");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
    {
      paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
      }
    }
    this.jdField_r_of_type_Int = 2;
    bdnm.a("AIO_updateSession_business", null);
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.V) {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843254);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(nav.c);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(nav.c);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130850061);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(nav.c);
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850060);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166897));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166897));
        return;
      }
    } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130850061);
    this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166897));
  }
  
  public void f(String paramString)
  {
    if (a().isFinishing()) {}
    do
    {
      return;
      if (this.jdField_c_of_type_Bety == null) {
        this.jdField_c_of_type_Bety = new bety(a(), a().getTitleBarHeight());
      }
      this.jdField_c_of_type_Bety.a(paramString);
    } while ((a().isFinishing()) || (this.jdField_c_of_type_Bety.isShowing()));
    this.jdField_c_of_type_Bety.show();
  }
  
  public void f(boolean paramBoolean)
  {
    if (bcih.a().a()) {
      bcih.a().b();
    }
    if (this.ae) {
      bS();
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
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843228);
      return true;
      if ((this.jdField_a_of_type_Ytb != null) && (this.jdField_a_of_type_Ytb.isShowing())) {
        this.jdField_a_of_type_Ytb.dismiss();
      }
      this.jdField_a_of_type_Ytb = new ytb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Bcgx, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      Object localObject = new int[2];
      this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen((int[])localObject);
      k = a();
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLocationInWindow(arrayOfInt);
      int m = arrayOfInt[1];
      int n = localObject[1];
      this.jdField_a_of_type_Ytb.a(k, m - n);
      this.jdField_a_of_type_Ytb.a(paramMessage.arg1);
      continue;
      if ((this.jdField_a_of_type_Bbqg != null) && (this.jdField_a_of_type_Bbqg.b()))
      {
        localObject = this.jdField_a_of_type_Bbqg.a();
        if (((bbqa)localObject).a.get())
        {
          ((bbqa)localObject).a.set(false);
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
    this.jdField_a_of_type_Nev = new nev(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
    this.aa = true;
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    auam.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
    if (this.jdField_a_of_type_Aepc != null) {
      this.jdField_a_of_type_Aepc.a(this.jdField_a_of_type_Aepd);
    }
    ThreadManager.post(new TroopChatPie.CheckGlamourPicturesRunnable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity), 2, null, true);
    int k;
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        if (!((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label321;
        }
        k = 1;
      }
    }
    for (;;)
    {
      new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_private").c("Grp_AIO").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(k) }).a();
      if (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null)
      {
        this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new agwn(this, null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      this.an = false;
      ((afgn)a(23)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
      label321:
      if (((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        k = 2;
      } else {
        k = 3;
      }
    }
  }
  
  public boolean i()
  {
    if (((afdb)a(34)).a()) {
      return true;
    }
    if (((afgf)a(43)).f()) {
      return true;
    }
    if (this.jdField_a_of_type_Bbqg != null) {
      this.jdField_a_of_type_Bbqg.a();
    }
    if (bcih.a().a()) {
      bcih.a().b();
    }
    if (this.jdField_a_of_type_Ahau != null) {
      this.jdField_a_of_type_Ahau.a();
    }
    if (this.jdField_a_of_type_Bbye != null) {
      this.jdField_a_of_type_Bbye.c();
    }
    if (this.ae) {
      bS();
    }
    return super.i();
  }
  
  public void j()
  {
    super.j();
    if ((this.jdField_a_of_type_Bbqg.d()) && ((this.jdField_a_of_type_Bbqg.b() == 17) || (this.jdField_a_of_type_Bbqg.b() == 100) || (this.jdField_a_of_type_Bbqg.b() == 11))) {
      return;
    }
    this.jdField_a_of_type_Ahau = new ahau(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahap, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Bbqg, this.jdField_a_of_type_AndroidWidgetToast);
    this.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_Ahau);
    this.jdField_a_of_type_Agzq = new agzq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahap, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_Agzq);
    this.jdField_a_of_type_Ahat = new ahat(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Ahap, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_Ahap.a(this.jdField_a_of_type_Ahat);
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
      bdfi.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), false);
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
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "avType : " + ((lpq)localObject1).jdField_a_of_type_Int);
        }
        if (((lpq)localObject1).jdField_a_of_type_Int != 2) {
          break label880;
        }
        if (((lpq)localObject1).jdField_a_of_type_Boolean)
        {
          azqs.b(null, "CliOper", "", "", "0X80066C2", "0X80066C2", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
        }
      }
      else
      {
        bL();
        if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null) {
          break label980;
        }
        this.jdField_c_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetScrollView = new agwb(this, this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setScrollbarFadingEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalScrollBarEnabled(false);
        this.jdField_s_of_type_Int = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        localObject1 = new RelativeLayout.LayoutParams(-1, this.jdField_s_of_type_Int);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, 0, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout, -1, this.jdField_s_of_type_Int);
        localObject1 = (bbuq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231);
        this.jdField_a_of_type_Bbuf = a();
        ((bbuq)localObject1).jdField_a_of_type_Int = 0;
        ((bbuq)localObject1).b = 0;
        ((bbuq)localObject1).c = 0;
        ((bbuq)localObject1).d = 0;
        if (!azmk.b()) {
          ((bbuq)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_Bbye == null) {
          this.jdField_a_of_type_Bbye = ((bbye)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(289));
        }
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Bbye.a(((TroopInfo)localObject1).dwGroupClassExt, true, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          this.af = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equalsIgnoreCase(((TroopInfo)localObject1).troopowneruin);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause, isTroopOwner =" + this.af + ",troopInfo = " + localObject1);
        }
        if ((aojt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)) {
          this.jdField_b_of_type_AndroidContentBroadcastReceiver = new agwj(this);
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
          new bcdk(this.jdField_a_of_type_AndroidContentContext, "3171", "libWXVoice.so", "WXVoice").a();
          if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
            this.jdField_a_of_type_AndroidContentBroadcastReceiver = new agwl(this);
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
            bcgs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            localObject1 = (aory)aoks.a().a(553);
            if ((localObject1 != null) && (!((aory)localObject1).jdField_a_of_type_Boolean))
            {
              this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
              this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
            }
            bR();
            localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
            this.ae = ((Intent)localObject1).getBooleanExtra("open_chat_from_group_rec_confess", false);
            if (this.ae)
            {
              j((Intent)localObject1);
              g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.k = this.ae;
            v(false);
            super.n(paramInt);
            return;
            localException1 = localException1;
            Object localObject2 = localObject3;
            label980:
            if (QLog.isColorLevel())
            {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onShowFirst : invalid uin!");
              localObject2 = localObject3;
              continue;
              azqs.b(null, "CliOper", "", "", "0X80066BF", "0X80066BF", 0, 0, "", "", "", "");
              continue;
              label880:
              if (((lpq)localObject2).jdField_a_of_type_Int == 10)
              {
                if (((lpq)localObject2).jdField_a_of_type_Boolean) {
                  azqs.b(null, "CliOper", "", "", "0X80066C1", "0X80066C1", 0, 0, "", "", "", "");
                }
                for (;;)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
                  break;
                  azqs.b(null, "CliOper", "", "", "0X80066BE", "0X80066BE", 0, 0, "", "", "", "");
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
    if (bdne.n(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      a(paramBoolean, TroopGiftPanel.jdField_f_of_type_Int);
      bdne.k(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      return;
    }
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131367006) && (b(true))) {}
    do
    {
      do
      {
        return;
        super.onClick(paramView);
        if (paramView.getId() != 2131370831) {
          break;
        }
      } while ((this.jdField_a_of_type_Ahau == null) || (!this.jdField_a_of_type_Ahau.a()));
      this.jdField_a_of_type_Ahap.a();
      return;
      if (paramView.getId() == 2131370829)
      {
        bQ();
        return;
      }
    } while ((paramView.getId() != 2131368638) || (this.jdField_j_of_type_AndroidWidgetImageView == null) || (this.jdField_j_of_type_AndroidWidgetImageView.getVisibility() != 0));
    bcth.a(this.jdField_j_of_type_AndroidWidgetImageView).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_Bbqg != null) {
      this.jdField_a_of_type_Bbqg.a().a(paramInt, 500L);
    }
    if (paramInt == 2) {
      bQ();
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
        ((agwo)paramAbsListView.next()).a(this.am);
      }
    }
    if ((paramInt == 0) && (this.jdField_i_of_type_JavaLangString != null))
    {
      paramAbsListView = ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a();
      this.jdField_i_of_type_JavaLangString = null;
      paramAbsListView.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentWidgetPatchedButton, paramCharSequence, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l = true;
      E(1);
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
        if ((paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '$') && (paramCharSequence.charAt(paramInt1) != 65509) && (paramCharSequence.charAt(paramInt1) != '¥') && (paramCharSequence.charAt(paramInt1) != 65284)) || (this.jdField_s_of_type_Boolean) || (((afft)a(27)).jdField_a_of_type_Boolean)) {
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
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "sign", 0, 0, paramCharSequence.troopuin + "", paramInt1 + "", "", "");
      bcoq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramCharSequence.troopuin, "input", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      if (paramCharSequence.isAdmin()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
    if ((!this.jdField_s_of_type_Boolean) && (!((afft)a(27)).jdField_a_of_type_Boolean)) {
      ((afdb)a(34)).b(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    bG();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Yuu != null) && (this.jdField_a_of_type_Yuu.a()))
    {
      this.jdField_a_of_type_Yuu.a();
      alaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_gift_panel", false);
    }
    if ((paramView.getId() == 2131369527) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void r()
  {
    aY();
    ((afgf)a(43)).h();
  }
  
  public void s()
  {
    super.s();
    aojt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  public void t(boolean paramBoolean)
  {
    Object localObject = (LinearLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetImageView.getLayoutParams();
    this.jdField_h_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
    ((LinearLayout.LayoutParams)localObject).width = xsm.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).height = xsm.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    try
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      int k;
      if (paramBoolean)
      {
        k = 2130843461;
        localObject = ((Resources)localObject).getDrawable(k);
        if ((!azmk.b()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label185;
        }
        ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166900), PorterDuff.Mode.MULTIPLY);
        label114:
        if (!paramBoolean) {
          break label217;
        }
        Drawable localDrawable = this.jdField_h_of_type_AndroidWidgetImageView.getDrawable();
        if ((localDrawable instanceof AnimationDrawable)) {
          ((AnimationDrawable)localDrawable).stop();
        }
        ((Drawable)localObject).setBounds(0, 0, xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      label185:
      label217:
      do
      {
        return;
        k = 2130843468;
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
          ((Drawable)localObject).setBounds(0, 0, xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
        }
        if (this.t == 2)
        {
          localObject = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843467);
          ((AnimationDrawable)localObject).setOneShot(true);
          ((AnimationDrawable)localObject).setBounds(0, 0, xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
          this.ao = true;
          return;
        }
        if (this.t == 3)
        {
          localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843468);
          ((Drawable)localObject).setBounds(0, 0, xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
        }
      } while (this.t != 4);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843468);
      ((Drawable)localObject).setBounds(0, 0, xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramBoolean = ((afgf)a(43)).d();
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
    ((afgb)a(29)).c(paramBoolean);
    this.V = paramBoolean;
    nav.a().a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((paramBoolean) || (alaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      alaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_anonyous", paramBoolean);
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
      this.jdField_r_of_type_AndroidViewView.setBackgroundResource(2130843234);
      this.jdField_r_of_type_AndroidViewView.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_r_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.jdField_r_of_type_AndroidViewView, 0);
    }
    if (this.q == null)
    {
      this.q = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.q.setBackgroundResource(2130843234);
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
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368344);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.p, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_a_of_type_Bcgx != null) {
      this.jdField_a_of_type_Bcgx.a(paramBoolean);
    }
    if (paramBoolean)
    {
      paramBoolean = ((atpl)a(33)).c();
      localObject = (afgf)a(43);
      boolean bool = ((afgf)localObject).c();
      if ((!paramBoolean) && (!bool)) {
        A(1);
      }
      this.jdField_o_of_type_AndroidWidgetImageView.setVisibility(8);
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()))
      {
        ImmersiveUtils.a(false, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
        a(-16777216, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131376812).setVisibility(8);
        aepi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130843234);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(nav.c);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(nav.c);
        if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          break label872;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843254);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(nav.c);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(nav.c);
        label571:
        if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_a_of_type_JavaLangCharSequence = this.jdField_f_of_type_AndroidWidgetTextView.getText();
        }
        bQ();
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131690097) + nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(nav.c);
        aepi.a(this.jdField_a_of_type_AndroidWidgetImageView, null);
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
        this.jdField_a_of_type_Naz = new agvz(this);
        nav.a().a(this.jdField_a_of_type_Naz);
        this.jdField_a_of_type_Ahap.a();
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(2131696529);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
        {
          aepi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130843234);
          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          }
        }
        ((afgf)localObject).g();
      }
    }
    for (;;)
    {
      z();
      r();
      this.jdField_a_of_type_Aeqo.notifyDataSetChanged();
      return;
      a(-16777216, false);
      break;
      label872:
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label571;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130850061);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(nav.c);
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130837745);
      break label571;
      bB();
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
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((abti.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (abti.d(paramObservable.istroop)))) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForTroopEffectPic))) {
            o(false);
          }
          afgi localafgi = (afgi)a(28);
          if (localafgi != null) {
            localafgi.a(paramObservable);
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
        bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, paramObservable.msg, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
        return;
        label230:
        if ((!((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a().b("highFreqInteract")) || (this.ac)) {
          break label138;
        }
        this.ac = true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable = new TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(false);
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable);
        break label138;
        if ((paramObject instanceof bbpj)) {
          b(paramObject);
        } else if ((paramObject instanceof Integer)) {
          switch (((Integer)paramObject).intValue())
          {
          case 123321: 
          default: 
            break;
          case 123322: 
            if ((this.jdField_a_of_type_Bcgx != null) && (this.jdField_a_of_type_Bcgx.a())) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(1, this.jdField_a_of_type_Bcgx.a() / 2);
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
    bk();
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
        break label187;
      }
      localObject1 = ((TroopManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 == null) {
        break label187;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))) {
        break label187;
      }
      if ((!((String)localObject2).equals(((TroopInfo)localObject1).Administrator)) && (!((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2))) {
        break label175;
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
        azqs.b((QQAppInterface)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
        VasWebviewUtil.reportCommercialDrainage("", "style", "0X8008E61", "", 1, 0, 0, "", "", "");
        bP();
        return;
        label175:
        k = 0;
        break;
      }
      label187:
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843250);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130849570, 2130849571);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie
 * JD-Core Version:    0.7.0.1
 */
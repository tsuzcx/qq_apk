package com.tencent.mobileqq.activity.aio.rebuild;

import aaqa;
import aars;
import aart;
import acvy;
import acwh;
import adrm;
import aful;
import afum;
import afur;
import afwy;
import agaz;
import agjm;
import agkw;
import aglu;
import agmv;
import agni;
import agnm;
import agnt;
import ahlz;
import ahmb;
import ahmp;
import ahrb;
import ahxp;
import aifz;
import aiga;
import aigb;
import aigc;
import aigd;
import aige;
import aigf;
import aigg;
import aigh;
import aigi;
import aigk;
import aigl;
import aigm;
import aign;
import aigo;
import aigp;
import aigq;
import aigr;
import aigs;
import aigt;
import aigu;
import aigv;
import aigw;
import aigx;
import aigy;
import aigz;
import aiha;
import aihb;
import aihc;
import aihd;
import aikz;
import ailk;
import ailo;
import ailq;
import aimj;
import aimn;
import aimo;
import aimr;
import aimw;
import amrr;
import amuf;
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
import anff;
import anie;
import anif;
import anmu;
import anni;
import anqd;
import anuk;
import anun;
import anwd;
import anxg;
import anxo;
import aqjm;
import aqkl;
import aqlk;
import aqua;
import aqxg;
import auwj;
import avwb;
import avwk;
import awhv;
import azte;
import bcnj;
import bcst;
import bcsy;
import bcvj;
import bdix;
import bdol;
import bdxh;
import bemy;
import benb;
import bend;
import bepx;
import beqc;
import beqk;
import beqr;
import beuq;
import beuz;
import bevb;
import beyo;
import beyp;
import bfdy;
import bfgt;
import bfhg;
import bfhl;
import bfhz;
import bfke;
import bfmd;
import bfos;
import bfqk;
import bfrd;
import bfrh;
import bfrl;
import bfsq;
import bftg;
import bftm;
import bftr;
import bftx;
import bfup;
import bfxz;
import bfyf;
import bfzc;
import bfzz;
import bgau;
import bgbd;
import bgbf;
import bggq;
import bgjt;
import bgjw;
import bgkb;
import bgkl;
import bglf;
import bglp;
import bgpa;
import bgsg;
import bgso;
import bgsp;
import bhgz;
import biau;
import biop;
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
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import lmn;
import mqq.os.MqqHandler;
import njo;
import njq;
import njs;
import njt;
import nnp;
import nns;
import org.json.JSONArray;
import org.json.JSONException;
import wpj;
import wpm;
import wpy;
import ziz;
import zlx;

public class TroopChatPie
  extends ahxp
{
  boolean Z = false;
  aaqa jdField_a_of_type_Aaqa = null;
  afum jdField_a_of_type_Afum = new aigy(this);
  public aikz a;
  public ailk a;
  ailo jdField_a_of_type_Ailo;
  public ailq a;
  aimn jdField_a_of_type_Aimn;
  aimo jdField_a_of_type_Aimo;
  aimr jdField_a_of_type_Aimr;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Handler jdField_a_of_type_AndroidOsHandler;
  public ScrollView a;
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  anif jdField_a_of_type_Anif = new aigi(this);
  private final anmu jdField_a_of_type_Anmu = new aifz(this);
  protected anqd a;
  anun jdField_a_of_type_Anun = new aigb(this);
  anxg jdField_a_of_type_Anxg = new aiga(this);
  anxo jdField_a_of_type_Anxo = new aigl(this);
  bdix jdField_a_of_type_Bdix = new aigw(this);
  private benb jdField_a_of_type_Benb;
  protected beuq a;
  private beyp jdField_a_of_type_Beyp;
  bfrl jdField_a_of_type_Bfrl;
  protected bfyf a;
  protected bfzz a;
  public bgau a;
  protected bgbf a;
  protected ConfessPanel a;
  TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable;
  FloatView jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Observer jdField_a_of_type_JavaUtilObserver = new aigs(this);
  njs jdField_a_of_type_Njs;
  public njt a;
  nnp jdField_a_of_type_Nnp;
  nns jdField_a_of_type_Nns = new aigk(this);
  public boolean aa;
  boolean ab;
  public boolean ac;
  boolean ad = false;
  public boolean ae = false;
  protected boolean af;
  boolean ag = false;
  boolean ah = true;
  boolean ai = false;
  boolean aj = false;
  boolean ak = false;
  public boolean al;
  private boolean am;
  private boolean an;
  private boolean ao;
  private boolean ap;
  private boolean aq;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  public Handler b;
  private ViewTreeObserver.OnGlobalLayoutListener jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener;
  public LinearLayout b;
  Runnable jdField_b_of_type_JavaLangRunnable;
  protected List<aihc> b;
  protected bgpa c;
  Runnable c;
  public bgpa d;
  Runnable d;
  private Runnable e;
  public volatile long f;
  private long g;
  private long h;
  public String i;
  String j;
  public View n;
  View o;
  public View p;
  protected int q;
  public View q;
  public int r;
  public int s;
  protected int t = 0;
  int u = 0;
  
  public TroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_r_of_type_Int = 2;
    this.jdField_c_of_type_JavaLangRunnable = new TroopChatPie.2(this);
    this.jdField_b_of_type_AndroidOsHandler = new aigc(this, Looper.getMainLooper());
    this.jdField_a_of_type_Anqd = new aigr(this);
    this.jdField_e_of_type_JavaLangRunnable = new TroopChatPie.35(this);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(5);
    this.jdField_d_of_type_JavaLangRunnable = new TroopChatPie.36(this);
  }
  
  private void C(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 12006: 
    case 6001: 
      do
      {
        return;
        if (njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          bcst.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_choosecancel", paramInt, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          return;
        }
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.l);
      BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, false);
      return;
    }
    bH();
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
      if (this.U)
      {
        ((Intent)localObject1).putExtra("param_chat_mode", 1);
        bool = I();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "open TroopMemberListActivity, needfilterrobot:" + bool);
        }
        if (bool) {
          ((Intent)localObject1).putExtra("param_filter_robot", true);
        }
        if (super.g() == 21) {
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
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, localTroopInfo.troopuin, "2", (String)localObject1, "");
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
    bftx localbftx = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    }
    if (localObject == null)
    {
      bool2 = bool1;
      return bool2;
    }
    localObject = (bfmd[])((Editable)localObject).getSpans(0, localObject.toString().length(), bfmd.class);
    int k = 0;
    for (;;)
    {
      bool1 = bool2;
      if (k < localObject.length)
      {
        if (localbftx.b(localObject[k].a())) {
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
                localObject = afur.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
                ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
                this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject);
                return;
                h(paramIntent);
                return;
                bftg.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
          } while (this.jdField_a_of_type_Aart == null);
          localObject = this.jdField_a_of_type_Aart.a();
        } while (localObject == null);
        ((TroopGiftPanel)localObject).a(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
        return;
        paramIntent = paramIntent.getStringExtra("result");
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      } while ((TextUtils.isEmpty(paramIntent)) || (localObject == null) || (paramIntent.equals(((TroopInfo)localObject).troopname)));
      ((anie)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramIntent, false);
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
      bgbd localbgbd = (bgbd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234);
      String str = localbgbd.a(paramString);
      bool1 = ((avwk)a(33)).c();
      bool2 = ((agnm)a(43)).c();
      if ((!this.U) && (!bool1) && (!bool2) && (!TextUtils.isEmpty(str)))
      {
        if (this.t != 2)
        {
          z(2);
          if (paramBoolean)
          {
            if (localbgbd.a(paramString) != 3) {
              break label191;
            }
            bgjt.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { paramString });
          }
        }
        for (;;)
        {
          c(true);
          this.jdField_f_of_type_AndroidWidgetTextView.setText(str);
          this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
          if (this.jdField_a_of_type_Bgau == null) {
            break label254;
          }
          this.jdField_a_of_type_Bgau.a(paramString);
          if (!this.jdField_a_of_type_Bgau.a()) {
            break;
          }
          this.jdField_a_of_type_Bgau.d();
          x(true);
          return;
          new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        }
        x(false);
        return;
        x(false);
        return;
      }
    } while ((this.U) || (bool1) || (bool2));
    c(false);
    this.jdField_f_of_type_AndroidWidgetTextView.setText("");
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void bH()
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
      aqkl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      return;
      label33:
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
  }
  
  private void bI()
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "un", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, k + "", "", "");
      return;
      label96:
      if (localTroopInfo.isAdmin()) {
        k = 1;
      } else {
        k = 2;
      }
    }
  }
  
  private void bJ()
  {
    if (TroopInfo.isHomeworkTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      new bfdy(this.jdField_a_of_type_AndroidContentContext, "3171", "libWXVoice.so", "WXVoice").a();
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aigx(this);
      }
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      bfhg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "register homework receiver exception.");
      }
    }
  }
  
  private void bK()
  {
    if ((aqkl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)) {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new aigz(this);
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "register mConfessReceiver receiver exception.");
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
    bfgt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_e_of_type_AndroidWidgetImageView, this.jdField_f_of_type_AndroidWidgetImageView, this.K);
  }
  
  private void bN()
  {
    this.jdField_a_of_type_Benb = new aigm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Benb);
  }
  
  private void bO()
  {
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130846162));
    }
    for (;;)
    {
      bcnj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.mSystemBarComp, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
      return;
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167042), true);
    }
  }
  
  private void bP()
  {
    if ((bgjw.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (bgjw.a(this.jdField_a_of_type_AndroidContentContext))) {}
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
    bfup.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent.getExtras(), 1, 2000);
  }
  
  private void bQ()
  {
    if ((this.jdField_a_of_type_Bgau != null) && (this.jdField_a_of_type_Bgau.a()))
    {
      if (this.jdField_a_of_type_Bgau.a() == 2)
      {
        c(false);
        z(0);
      }
    }
    else {
      return;
    }
    v(false);
  }
  
  private void bR()
  {
    if (A()) {
      return;
    }
    if (this.jdField_a_of_type_Ailo == null) {
      this.jdField_a_of_type_Ailo = new ailo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_Ailo.a(this.jdField_a_of_type_Aimj);
  }
  
  private void bS()
  {
    if (this.aq) {
      return;
    }
    ((aqjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.aq = true;
  }
  
  private void bT()
  {
    ThreadManager.post(new TroopChatPie.37(this), 8, null, true);
  }
  
  private void bU()
  {
    TroopChatPie.38 local38 = new TroopChatPie.38(this);
    ThreadManager.getSubThreadHandler().post(local38);
  }
  
  private void bV()
  {
    boolean bool3 = false;
    if ((!this.ag) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {}
    for (boolean bool1 = H();; bool1 = false)
    {
      if (!bool1) {
        if ((this.jdField_a_of_type_Aaqa != null) && (this.jdField_a_of_type_Aaqa.isShowing())) {
          bool1 = true;
        }
      }
      for (;;)
      {
        Object localObject = (bfos)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
        if (localObject != null) {}
        for (boolean bool2 = ((bfos)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; bool2 = false)
        {
          if ((localObject != null) && (bool2) && (bool1)) {
            ((bfos)localObject).b = false;
          }
          if ((!bool1) && (bool2))
          {
            bfos.jdField_a_of_type_Boolean = true;
            p(true);
          }
          localObject = avwk.a(this);
          if (localObject != null)
          {
            if (!bool1)
            {
              bool1 = bool3;
              if (!bool2) {}
            }
            else
            {
              bool1 = true;
            }
            ((avwk)localObject).a(bool1);
          }
          return;
          bool1 = false;
          break;
        }
      }
    }
  }
  
  private void bW()
  {
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == null) {}
    for (int k = 1; k != 0; k = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, isTroopTipStatusNull== true, getAppInfoBriefList");
      }
      this.jdField_a_of_type_Nnp.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Nns, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, reqNotifyItems");
    }
    bfqk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
      if ((!paramIntent.getExtras().getBoolean("isApollo")) || (this.jdField_a_of_type_Anff == null)) {
        break;
      }
    } while ("0".equals(str2));
    paramIntent = null;
    if (!F()) {
      paramIntent = bglf.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, str2);
    }
    localObject = paramIntent;
    if (TextUtils.isEmpty(paramIntent)) {
      localObject = str1;
    }
    paramIntent = new StringBuilder("@").append((String)localObject);
    this.jdField_a_of_type_Anff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = str2;
    this.jdField_a_of_type_Anff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName = paramIntent.toString();
    this.jdField_a_of_type_Anff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = bdol.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
    a(this.jdField_a_of_type_Anff);
    int k = 0;
    int m;
    String str3;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Anff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText))
    {
      m = 2;
      k = m;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Anff.b))
      {
        if (this.jdField_a_of_type_Anff.d == 0) {
          k = 6;
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        m = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        str2 = "" + this.jdField_a_of_type_Anff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
        str3 = "655_" + this.jdField_a_of_type_Anff.jdField_a_of_type_Int;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Anff.b)) {
          break label496;
        }
      }
    }
    label496:
    for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_Anff.b)
    {
      VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str1, k, m, new String[] { str2, str3, paramIntent, this.jdField_a_of_type_Anff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      k = m;
      if (this.jdField_a_of_type_Anff.d != 1) {
        break;
      }
      k = 7;
      break;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Anff.b))
      {
        k = 3;
        break;
      }
      if (this.jdField_a_of_type_Anff.d == 0)
      {
        k = 4;
        break;
      }
      if (this.jdField_a_of_type_Anff.d != 1) {
        break;
      }
      k = 5;
      break;
    }
    a(str2, str1, true, 4);
  }
  
  private void h(String paramString)
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_j_of_type_JavaLangString = paramString;
    ThreadManager.getSubThreadHandler().post(this.jdField_d_of_type_JavaLangRunnable);
  }
  
  private void i(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_Aimo != null) && (this.jdField_a_of_type_Aimo.a()) && (awhv.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Aimj.a();
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false))) {
      a().getIntent().putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
    }
  }
  
  private void j(Intent paramIntent)
  {
    this.aq = false;
    String str = paramIntent.getStringExtra("uin");
    this.ad = ((aqjm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b(str, paramIntent);
  }
  
  private void x(boolean paramBoolean)
  {
    if ((!this.an) && (!paramBoolean) && (this.t == 2)) {
      v(false);
    }
  }
  
  private void y(boolean paramBoolean)
  {
    this.W = paramBoolean;
  }
  
  void A(int paramInt)
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
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOshortcut", "Clk_shortcut", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject1, "", "");
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
  
  public void B(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 3)) {
      ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt, 0);
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
    this.ab = false;
    this.aa = false;
    if (this.jdField_a_of_type_Beuq != null) {
      this.jdField_a_of_type_Beuq.e();
    }
    if (this.M) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "hasDestory = true return");
      }
    }
    for (;;)
    {
      return;
      if (this.ad) {
        bS();
      }
      ((agjm)a(34)).a();
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.a();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView = null;
      }
      if (this.jdField_a_of_type_Njt != null)
      {
        this.jdField_a_of_type_Njt.dismiss();
        this.jdField_a_of_type_Njt = null;
      }
      if (this.jdField_a_of_type_Nnp != null) {
        this.jdField_a_of_type_Nnp.a();
      }
      njo.a().b();
      if (this.U) {
        a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131167042), true);
      }
      ahmb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_Aaqa != null)
      {
        this.jdField_a_of_type_Aaqa.dismiss();
        this.jdField_a_of_type_Aaqa = null;
      }
      if (this.jdField_a_of_type_Aart != null) {
        this.jdField_a_of_type_Aart = null;
      }
      Object localObject = (bfrd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
      ((bfrd)localObject).e("");
      if (((bfrd)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        ((bfrd)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      B(0);
      this.jdField_r_of_type_Int = 0;
      this.ag = false;
      this.ai = false;
      this.ak = false;
      this.aj = false;
      localObject = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      ((bftx)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, "off");
      ((bftx)localObject).a(null);
      ((wpj)wpm.a(5)).c();
      ((wpy)wpm.a(2)).d();
      ((ziz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(208)).a();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        acwh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4021);
      }
      if (this.jdField_a_of_type_Bgau != null)
      {
        this.jdField_a_of_type_Bgau.a();
        this.jdField_a_of_type_Bgau = null;
      }
      z(0);
      if (this.jdField_a_of_type_Bfyf != null) {
        this.jdField_a_of_type_Bfyf.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = null;
      }
      bG();
      super.H();
      if (this.jdField_b_of_type_AndroidOsHandler != null)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "doOnDestroy, timerHandler->removeCallbacksAndMessages");
        }
      }
      bfke.a().a();
      if (this.jdField_a_of_type_Bgbf != null)
      {
        this.jdField_a_of_type_Bgbf.b();
        this.jdField_a_of_type_Bgbf = null;
      }
      this.jdField_b_of_type_JavaUtilList.clear();
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if ((this.jdField_d_of_type_Bgpa != null) && (this.jdField_d_of_type_Bgpa.isShowing())) {
        this.jdField_d_of_type_Bgpa.dismiss();
      }
      if (this.jdField_a_of_type_Beyp != null) {
        this.jdField_a_of_type_Beyp.b();
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
            ahlz.jdField_a_of_type_JavaUtilHashMap.clear();
            ahlz.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
            aqkl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
            localObject = new Intent("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT");
            BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
            this.an = false;
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b(false);
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(false);
            }
            if (this.jdField_a_of_type_Aful != null) {
              this.jdField_a_of_type_Aful.a(null);
            }
            if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null)) {
              break;
            }
            if (Build.VERSION.SDK_INT >= 16) {
              break label875;
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
              label875:
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
            }
          }
        }
      }
    }
  }
  
  boolean H()
  {
    if (this.jdField_a_of_type_Bfhl == null) {}
    boolean bool = bftr.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleTroopNotificationMsg. hasNewGuide = " + bool);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (!bool))
    {
      ThreadManager.post(new TroopChatPie.24(this), 8, null, true);
      return true;
    }
    return false;
  }
  
  public void L()
  {
    if (this.U) {
      bO();
    }
    if (this.jdField_a_of_type_Bfrl != null)
    {
      bfrh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfrl);
      this.jdField_a_of_type_Bfrl = null;
    }
    if ((this.jdField_a_of_type_Aaqa == null) || (!this.jdField_a_of_type_Aaqa.isShowing()))
    {
      bfos localbfos = (bfos)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
      if (localbfos != null) {
        localbfos.c();
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    if (this.jdField_a_of_type_Bfzz != null) {
      this.jdField_a_of_type_Bfzz.a();
    }
    if (bfke.a().a()) {
      bfke.a().b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(true);
    }
    super.L();
  }
  
  public void M()
  {
    if (this.jdField_a_of_type_Bgbf != null) {
      this.jdField_a_of_type_Bgbf.a();
    }
    if (this.jdField_a_of_type_Beuq != null) {
      this.jdField_a_of_type_Beuq.d();
    }
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    super.M();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Aaqa == null) || (!this.jdField_a_of_type_Aaqa.isShowing()))
    {
      localObject = (bfos)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(223);
      if (localObject != null) {
        ((bfos)localObject).c();
      }
    }
    if (bfke.a().a()) {
      bfke.a().b();
    }
    Object localObject = (bevb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231);
    ((bevb)localObject).jdField_a_of_type_Int = 0;
    ((bevb)localObject).b = 0;
    ((bevb)localObject).c = 0;
    ((bevb)localObject).d = 0;
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "doOnPause, isTroopOwner =" + this.ae);
    }
  }
  
  public void N()
  {
    super.N();
    if (this.U)
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843589);
      njo.a().a(this.jdField_a_of_type_Njs);
      a(-16777216, false);
    }
    bv();
  }
  
  public void P()
  {
    super.P();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == 2)
    {
      this.T = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (this.T) {
        bt();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(0);
    }
    this.jdField_a_of_type_Beuq = a();
    this.jdField_a_of_type_Beuq.c();
    this.jdField_a_of_type_Beuq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    aqkl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_Bfyf.a();
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
      if ((k != 0) && (this.jdField_a_of_type_Bfhl != null))
      {
        this.jdField_a_of_type_Bfhl.b();
        this.jdField_a_of_type_Bfhl = null;
      }
      if ((k != 0) && (this.jdField_a_of_type_Beyp != null) && (this.jdField_a_of_type_Beyp.a != null))
      {
        this.jdField_a_of_type_Beyp.a.b();
        this.jdField_a_of_type_Beyp.a = null;
      }
      if (this.jdField_a_of_type_Bfrl != null)
      {
        bfrh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfrl);
        this.jdField_a_of_type_Bfrl = null;
      }
      bG();
      this.jdField_i_of_type_Boolean = true;
      return;
    }
  }
  
  public void R()
  {
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity)) && (this.jdField_a_of_type_Bfzc != null)) {
      this.jdField_a_of_type_Bfzc.c();
    }
    super.R();
  }
  
  public aimn a()
  {
    return this.jdField_a_of_type_Aimn;
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 35)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = ((ConfessPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558590, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this);
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel;; localObject = super.a(paramInt))
    {
      if ((localObject instanceof PlusPanel)) {
        ((PlusPanel)localObject).setPagerChangedListener(new aigt(this));
      }
      return localObject;
    }
  }
  
  public ImageView a()
  {
    return this.jdField_d_of_type_AndroidWidgetImageView;
  }
  
  public beuq a()
  {
    if (this.jdField_a_of_type_Beuq == null) {
      this.jdField_a_of_type_Beuq = new beuq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364345));
    }
    return this.jdField_a_of_type_Beuq;
  }
  
  public bfzz a()
  {
    if (this.jdField_a_of_type_Bfzz == null)
    {
      this.jdField_a_of_type_Bfzz = new bfzz();
      this.jdField_a_of_type_Bfzz.a(this);
    }
    return this.jdField_a_of_type_Bfzz;
  }
  
  public bgbf a()
  {
    if (this.jdField_a_of_type_Bgbf == null) {
      this.jdField_a_of_type_Bgbf = new bgbf(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    }
    return this.jdField_a_of_type_Bgbf;
  }
  
  public PanelIconLinearLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  }
  
  public EntryModel a()
  {
    return bfup.a(((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public Boolean a()
  {
    if (this.U) {
      return new Boolean(false);
    }
    return null;
  }
  
  String a(TroopMemberInfo paramTroopMemberInfo)
  {
    int k = (int)(paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime()) / 86400;
    return String.format("<{\"text\":\"%1$s\", \"cmd\": \"5\", \"data\":\"%2$s\"}>专属头衔\"%3$s\"将在%4$d天后到期，<{\"text\":\"点击续期\", \"cmd\": \"3\", \"data_a\":\"mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.troop.EditUniqueTitleActivity&troopUin=%5$s&memberUin=%2$s&uniqueTitle=%6$s&uniqueTitleExpire=%7$d&from=2\"}>", new Object[] { paramTroopMemberInfo.friendnick, paramTroopMemberInfo.memberuin, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(k + 1), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(paramTroopMemberInfo.mUniqueTitleExpire) });
  }
  
  public List<ChatMessage> a(boolean paramBoolean)
  {
    List localList1 = super.a(paramBoolean);
    boolean bool = aimw.a();
    int m = aimw.a();
    int i1 = aimw.b();
    paramBoolean = false;
    if (!this.ap)
    {
      if (localList1.size() > 0)
      {
        this.jdField_g_of_type_Long = ((ChatMessage)localList1.get(localList1.size() - 1)).shmsgseq;
        this.jdField_h_of_type_Long = ((ChatMessage)localList1.get(0)).shmsgseq;
      }
      paramBoolean = true;
      this.ap = true;
    }
    if ((this.jdField_h_of_type_Long == 0L) && (this.jdField_g_of_type_Long == 0L)) {}
    Object localObject1;
    Object localObject3;
    for (int k = 1;; k = 0)
    {
      if ((!bool) || (this.K) || (k != 0) || (m <= 1) || (localList1.size() < m)) {
        break label481;
      }
      localObject1 = null;
      int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
      localObject3 = localObject1;
      if (!this.ao) {
        break;
      }
      localObject3 = localObject1;
      if (i2 <= 0) {
        break;
      }
      localObject1 = new long[i2];
      k = 0;
      for (;;)
      {
        localObject3 = localObject1;
        if (k >= i2) {
          break;
        }
        localObject1[k] = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(k)).longValue();
        k += 1;
      }
    }
    for (;;)
    {
      List localList2;
      try
      {
        localList2 = aimw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList1, m, this.jdField_h_of_type_Long, this.jdField_g_of_type_Long, localObject3, paramBoolean);
        if ((!paramBoolean) || (i1 <= 15) || (localList2.size() <= 1)) {
          break label507;
        }
        localObject1 = null;
        k = 1;
        if (k < localList2.size())
        {
          localObject1 = (ChatMessage)localList2.get(k);
          if (aimw.c((ChatMessage)localObject1)) {
            continue;
          }
        }
        if ((!aimw.b((ChatMessage)localObject1)) || (localList2.size() >= 15)) {
          break label507;
        }
        aimw.a("find first msg is fold msg,then get more msg ", new Object[0]);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_g_of_type_Long - i1 - 1L);
        if (((List)localObject1).size() > 0)
        {
          this.jdField_h_of_type_Long = ((ChatMessage)((List)localObject1).get(0)).shmsgseq;
          this.jdField_g_of_type_Long = ((ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq;
        }
        localObject1 = aimw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject1, m, this.jdField_h_of_type_Long, this.jdField_g_of_type_Long, localObject3, false);
      }
      catch (Throwable localThrowable)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, localThrowable, new Object[0]);
        localObject2 = localList1;
        continue;
      }
      return localObject1;
      k += 1;
      continue;
      label481:
      Object localObject2 = localList1;
      if (localList1.size() == 0)
      {
        bG();
        this.ap = true;
        return localList1;
        label507:
        localObject2 = localList2;
      }
    }
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
    if (this.jdField_a_of_type_Beyp != null) {
      this.jdField_a_of_type_Beyp.a();
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
        bI();
      } else if (paramInt2 == 0) {
        C(paramInt1);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Njt == null) {
      this.jdField_a_of_type_Njt = new njt(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_a_of_type_Njt.a(paramInt, paramString);
    this.jdField_a_of_type_Njt.show();
    TroopChatPie.29 local29;
    if ((paramInt == 1) || (paramInt == 3))
    {
      paramString = this.jdField_a_of_type_MqqOsMqqHandler;
      local29 = new TroopChatPie.29(this);
      if (!AppSetting.c) {
        break label82;
      }
    }
    label82:
    for (long l = 3000L;; l = 1000L)
    {
      paramString.postDelayed(local29, l);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    TroopManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong1, paramLong2, new aiha(this, false));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
    }
    if ((this.jdField_c_of_type_Bgpa != null) && (this.jdField_c_of_type_Bgpa.isShowing())) {
      if ((paramLong == 1L) || (paramLong == 2L)) {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog, CreditLevelTipDialog isShowing:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + "," + paramLong + "," + paramBoolean);
        }
      }
    }
    do
    {
      return;
      this.jdField_c_of_type_Bgpa.dismiss();
      if (paramLong == 1L)
      {
        this.jdField_c_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131718563)).setMessage(2131696837);
        this.jdField_c_of_type_Bgpa.setPositiveButton(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691082), new aigd(this));
        this.jdField_c_of_type_Bgpa.setNegativeButton(anni.a(2131713947), new aige(this));
        this.jdField_c_of_type_Bgpa.setPositiveButtonContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131691082));
        this.jdField_c_of_type_Bgpa.setNegativeButtonContentDescription(anni.a(2131713945));
        this.jdField_c_of_type_Bgpa.setCancelable(false);
        this.jdField_c_of_type_Bgpa.show();
        new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_banned").c("Grp_AIO").d("exp_msgbox").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }).a();
        return;
      }
      if ((paramLong == 2L) && (!paramBoolean))
      {
        this.jdField_c_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131718563)).setMessage(2131696836);
        this.jdField_c_of_type_Bgpa.setPositiveButton(2131696834, new aigf(this));
        this.jdField_c_of_type_Bgpa.setNegativeButton("", null);
        this.jdField_c_of_type_Bgpa.setCancelable(false);
        this.jdField_c_of_type_Bgpa.show();
        return;
      }
    } while ((paramLong != 2L) || (!paramBoolean));
    this.jdField_c_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131718563)).setMessage(2131696835);
    this.jdField_c_of_type_Bgpa.setNegativeButton(2131696834, new aigg(this));
    this.jdField_c_of_type_Bgpa.setPositiveButton(2131696833, new aigh(this));
    this.jdField_c_of_type_Bgpa.setCancelable(false);
    this.jdField_c_of_type_Bgpa.show();
  }
  
  public void a(aihc paramaihc)
  {
    this.jdField_b_of_type_JavaUtilList.add(paramaihc);
  }
  
  public void a(Intent paramIntent)
  {
    z(0);
    if ((this.U) && (!njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      w(false);
      this.n.setVisibility(8);
      this.o.setVisibility(8);
    }
    String str1;
    String str2;
    int k;
    for (;;)
    {
      if ((this.U) && (njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131689988) + njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
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
                String str3 = bglf.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject3);
                localObject3 = bfmd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject3, str3, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
                if ((localObject3 != null) && (((SpannableString)localObject3).length() != 0)) {
                  this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject3);
                }
                k += 1;
                continue;
                if (!njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                  break;
                }
                w(true);
                this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843589);
                this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130843595);
                this.n.setVisibility(0);
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
        localObject2 = (agmv)a(27);
        if (localObject2 != null) {
          ((agmv)localObject2).a("0", str2, str1);
        }
      }
      if (paramIntent.getBooleanExtra("sendGift", false)) {
        a(true, TroopGiftPanel.jdField_f_of_type_Int);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Agaz != null)) {
        this.jdField_a_of_type_Agaz.a();
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      ((agnm)a(43)).h();
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
    int k = paramIntent.getIntExtra(bgkb.jdField_h_of_type_JavaLangString, -1);
    if (((k == 2) || (k == 1)) && (b(true))) {
      return;
    }
    super.a(paramIntent, paramInt);
  }
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131378009)
    {
      if (this.t == 2)
      {
        if (this.jdField_a_of_type_Bgau == null) {
          this.jdField_a_of_type_Bgau = new bgau(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_a_of_type_Beqr);
        }
        this.jdField_a_of_type_Bgau.a(a().jdField_a_of_type_JavaLangString);
        if (!this.jdField_a_of_type_Bgau.b()) {}
      }
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_Bgau.a()) {
            break;
          }
          bQ();
        } while (this.jdField_a_of_type_Bgau.b == 2);
        new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryClose").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        return;
        this.jdField_a_of_type_Bgau.a(1);
        paramView = (anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
        if (paramView != null) {
          paramView.u(a().jdField_a_of_type_JavaLangString);
        }
        v(true);
        if (this.jdField_a_of_type_Bgau.b == 2)
        {
          bgjt.a("Grp_idol", "Grp_AIO", "clk_renshu", 0, 0, new String[] { a().jdField_a_of_type_JavaLangString });
          return;
        }
        new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryOpen").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
        return;
        if (this.t == 3)
        {
          ((avwk)a(33)).b();
          return;
        }
      } while (this.t != 4);
      ((agnm)a(43)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    bP();
  }
  
  public void a(bfsq parambfsq)
  {
    if (parambfsq.jdField_a_of_type_Boolean) {
      if ((1 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (3 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (8 != this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && ((this.jdField_f_of_type_Int != 1) || (this.m != 0)))
      {
        ak();
        if (this.jdField_h_of_type_AndroidWidgetTextView != null)
        {
          QLog.d("troop_gag", 1, "fightgag.updateGagStatus_UI:" + parambfsq.b);
          this.jdField_h_of_type_AndroidWidgetTextView.setText(parambfsq.b);
        }
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "updateGagStatus_UI, sendEmptyMessageDelayed-TIMER_ID:" + parambfsq.jdField_a_of_type_Long + ", hasDestory=" + this.M);
        }
        if (!this.M)
        {
          this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, parambfsq.jdField_a_of_type_Long * 1000L);
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
      this.af = true;
      break;
      this.af = false;
      bo();
      this.jdField_i_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "updateGagStatus enable fastimage,  mAllowFastImage = " + this.jdField_i_of_type_Boolean);
  }
  
  public void a(bfsq parambfsq, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if (parambfsq == null) {
        ThreadManager.post(new TroopChatPie.15(this, paramBoolean), 8, null, true);
      }
    }
    else {
      return;
    }
    a(parambfsq);
  }
  
  public void a(Object paramObject)
  {
    afur.n = true;
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
        A(m);
        super.a(paramObject);
        return;
        if (this.U)
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          continue;
          if (this.U) {
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_PTT", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
          if (this.W)
          {
            new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_icon_clk").a(0).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString }).a();
            continue;
            if (this.U)
            {
              bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              continue;
              if (this.U) {
                bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
              }
            }
          }
        }
      }
    }
    if (!F()) {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
    if (this.jdField_a_of_type_Aart == null) {
      this.jdField_a_of_type_Aart = new aart(this);
    }
    aart localaart = this.jdField_a_of_type_Aart;
    int i1 = TroopGiftPanel.e;
    if (njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    for (int k = 4;; k = 1)
    {
      localaart.a(i1, k);
      bemy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bend.a(c()));
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
      localObject = adrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.c);
      if (localObject != null) {
        break label136;
      }
      return;
      k = 0;
      break;
    }
    label136:
    ((MessageForPtt)localObject).c2cViaOffline = bool1;
    if (!bgsp.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
      ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
    }
    long l1 = ((MessageRecord)localObject).uniseq;
    bdxh.a.put(paramString, Long.valueOf(l2));
    if (!bool1)
    {
      bcvj.a(paramString, false);
      bcvj.a(paramString);
      label204:
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + l1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!D) {
        break label562;
      }
    }
    label562:
    for (int k = 1;; k = 2)
    {
      bcst.b((QQAppInterface)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", k, 0, "", "", "", "8.4.1");
      D = true;
      k = a(paramInt1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.e);
      ArrayList localArrayList = new ArrayList();
      String str2 = bfmd.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      bftx localbftx = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      boolean bool3 = false;
      boolean bool2 = bool3;
      if (this.W)
      {
        Iterator localIterator = localArrayList.iterator();
        do
        {
          bool2 = bool3;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!localbftx.a(((MessageForText.AtTroopMemberInfo)localIterator.next()).uin));
        bool2 = true;
      }
      adrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, m, str1, paramString, l1, false, paramInt2, paramRecorderParam.c, bool1, paramInt3, k, paramBoolean, paramRecorderParam.d, (Bundle)localObject, localArrayList, str2, bool2, paramInt4);
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
      if (bgsp.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
        break;
      }
      ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
      l1 = paramLong;
      break;
      azte.b(paramString);
      break label204;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    bftx localbftx = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if ((localbftx.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (localbftx.b(paramString1)))
    {
      if (I()) {
        return;
      }
      this.jdField_g_of_type_JavaLangString = paramString1;
      localbftx.e = paramString1;
      this.jdField_h_of_type_JavaLangString = paramString2;
    }
    super.a(paramString1, paramString2, paramBoolean, paramInt);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList);
    super.a(paramList, paramCharSequence, paramInt);
    if ((0xFFFF & paramInt) == 4)
    {
      ((beqk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(225)).a(paramList);
      if (this.jdField_a_of_type_Beqr != null) {
        this.jdField_a_of_type_Beqr.a().f();
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
        localObject3 = afur.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, k);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handGetTroopMemberCard ref itemView=" + localObject3 + ",index=" + k);
        }
        if (localObject3 == null) {
          break label549;
        }
        localObject3 = (TextView)((View)localObject3).findViewById(2131367600);
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
      if ((this.jdField_a_of_type_Beyp != null) && ((this.jdField_a_of_type_Beyp.a instanceof bfhg)))
      {
        localObject1 = (bfhg)this.jdField_a_of_type_Beyp.a;
        if (((Boolean)paramObject[3]).booleanValue()) {
          break label544;
        }
      }
      label544:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((bfhg)localObject1).a(paramBoolean, null, this);
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
    if (!this.al)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      if (k > m) {}
      for (;;)
      {
        bool2 = bool1;
        if (k < m) {
          break label197;
        }
        bool2 = bool1;
        if (k > i1) {
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
      ChatFragment localChatFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment();
      if (localChatFragment != null) {
        this.jdField_c_of_type_AndroidViewViewGroup = localChatFragment.a;
      }
    }
    super.a(paramBoolean);
    B(1);
    bfke.a().a(this);
    this.jdField_a_of_type_Bfyf = new bfyf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_time", "Grp_AIO", "visit_time");
    biop.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), true);
    return true;
  }
  
  public void aU()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.c();
  }
  
  public void aZ()
  {
    super.aZ();
    bQ();
  }
  
  public void aa()
  {
    super.aa();
    ((agnm)a(43)).h();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    paramEditable = (agmv)a(27);
    if (paramEditable != null) {
      paramEditable.b();
    }
  }
  
  public void ai()
  {
    bq();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      if (localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime() < 259200L) {
        a(0L, 0L);
      }
      if (aqxg.c().mIsEnable)
      {
        localObject = (anuk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        if (!localTroopManager.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label536;
        }
        ((anuk)localObject).a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        QLog.e("vip_pretty.", 1, "get the troop expired info from server");
      }
    }
    if ((localTroopInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "aio onShow:" + localTroopInfo.troopuin + ", sysFlag=" + localTroopInfo.cGroupRankSysFlag + ", userFlag=" + localTroopInfo.cGroupRankUserFlag + ",newUserFlag=" + localTroopInfo.cNewGroupRankUserFlag);
    }
    super.ai();
    if (this.Z == true)
    {
      ThreadManager.post(new TroopChatPie.7(this), 1, null, true);
      this.Z = false;
    }
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    if ((localObject != null) && (((Bundle)localObject).containsKey("forward_type")) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(((Bundle)localObject).getString("uin")))) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.post(new TroopChatPie.8(this, bool), 8, null, true);
      if ((!this.ak) && (localTroopManager.a.jdField_a_of_type_Boolean) && (localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        int k = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((k < 3) && (localTroopInfo.wMemberMax < 2000) && (localTroopInfo.wMemberNum >= 500))
        {
          if (this.jdField_a_of_type_Aimr == null)
          {
            this.jdField_a_of_type_Aimr = new aimr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Aimj);
            this.jdField_a_of_type_Aimj.a(this.jdField_a_of_type_Aimr);
          }
          this.jdField_a_of_type_Aimr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_Aimj.a(this.jdField_a_of_type_Aimr, new Object[0]))
          {
            this.ak = true;
            localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, k + 1);
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_up", "", "Grp_AIO", "exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
          }
        }
      }
      return;
      label536:
      if (QLog.isColorLevel()) {
        QLog.d("vip_pretty.", 1, "get the troop expired info from local");
      }
      TroopManager.a(localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Aimj);
      break;
    }
  }
  
  public void al_()
  {
    super.al_();
    if ((this.jdField_a_of_type_Beqr != null) && (!E())) {
      this.jdField_a_of_type_Beqr.a().e();
    }
  }
  
  public void ap()
  {
    super.ap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Anqd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anxg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anmu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anif);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anun);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anxo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdix);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    bN();
    ((auwj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void aq()
  {
    super.aq();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anqd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anxg);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anmu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anif);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anun);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anxo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bdix);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Benb);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    ((auwj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(156)).a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public void as()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clickSendTextButton. isSending:" + this.Y);
    }
    if (!this.Y) {
      this.Y = true;
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
      bftx localbftx = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      boolean bool2 = localbftx.a();
      Object localObject = localbftx.b;
      String str1 = localbftx.c;
      ArrayList localArrayList = new ArrayList();
      String str2 = bfmd.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      k = 0;
      label259:
      boolean bool3;
      if (k < localArrayList.size())
      {
        MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(k);
        if (localbftx.a(localAtTroopMemberInfo.uin))
        {
          localObject = "" + localAtTroopMemberInfo.uin;
          str1 = bglf.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject);
          if ((bool2) || (localbftx.a(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            bool1 = true;
            bool3 = localbftx.b(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            bool2 = bool1;
          }
        }
      }
      for (boolean bool1 = bool3;; bool1 = false)
      {
        if ((bool2) && (!bool1))
        {
          localObject = bfmd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
          a(localbftx.b, localbftx.c, true, 0);
        }
        for (;;)
        {
          this.Y = false;
          return;
          bool1 = false;
          break label259;
          k += 1;
          break;
          ahmp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if ((str2 == null) || (str2.length() <= 3478)) {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
          }
          if (this.W)
          {
            y(false);
            localObject = (agnt)a(23);
            if (localObject != null) {
              ((agnt)localObject).a(false);
            }
          }
          this.X = false;
          localbftx.a();
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
    if (this.af)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (paramBoolean) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131696676, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
      ak();
      bool = true;
    }
    return bool;
  }
  
  public void bA()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new aigo(this));
    if ((this.q != null) && (this.p != null))
    {
      this.q.startAnimation(localAlphaAnimation);
      this.p.startAnimation(localAlphaAnimation);
    }
  }
  
  public void bB()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new aigp(this));
    this.q.startAnimation(localAlphaAnimation);
    this.p.startAnimation(localAlphaAnimation);
  }
  
  public void bC()
  {
    if ((this.jdField_c_of_type_Biau != null) && (this.jdField_c_of_type_Biau.isShowing()) && (!a().isFinishing())) {
      this.jdField_c_of_type_Biau.dismiss();
    }
  }
  
  protected void bD()
  {
    Object localObject1 = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    Object localObject2;
    String str1;
    int k;
    boolean bool;
    if (((bftx)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      if (!this.Y)
      {
        localObject2 = (bfmd[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(0, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString().length(), bfmd.class);
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        k = 0;
        if (k >= localObject2.length) {
          break label438;
        }
        if (!((bftx)localObject1).b(localObject2[k].a())) {
          break label247;
        }
        String str2 = localObject2[k].a();
        this.jdField_g_of_type_JavaLangString = str2;
        ((bftx)localObject1).e = str2;
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
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a().equals(this.jdField_g_of_type_JavaLangString))) {
        bool = false;
      }
      for (;;)
      {
        ((agni)a(29)).d(bool);
        if (this.X == bool) {
          if (bool)
          {
            localObject1 = (agnt)a(23);
            if (localObject1 != null) {
              ((agnt)localObject1).b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount());
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
                this.X = bool;
                if (bool) {
                  break label363;
                }
                y(false);
                localObject2 = (agnt)a(23);
                if (localObject2 != null) {
                  ((agnt)localObject2).a(false);
                }
              } while (!((bftx)localObject1).a());
              ((bftx)localObject1).a();
              bftx.a("panel", "talk_out", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(), "2", "");
              ((bftx)localObject1).b(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), Long.parseLong(this.jdField_g_of_type_JavaLangString), "off", new aigu(this));
              return;
            } while (this.W);
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(str1, this.jdField_g_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this, new aigv(this));
            return;
          } while (!this.W);
          y(false);
          localObject1 = (agnt)a(23);
        } while (localObject1 == null);
        label363:
        ((agnt)localObject1).a(false);
        return;
      }
      label433:
      bool = true;
      continue;
      label438:
      bool = false;
    }
  }
  
  public void bE()
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView == null) {
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365560));
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
    Object localObject = (avwk)a(33);
    boolean bool1 = ((avwk)localObject).c();
    boolean bool2 = ((avwk)localObject).d();
    agnm localagnm = (agnm)a(43);
    boolean bool3 = localagnm.c();
    int k;
    if (bool1)
    {
      z(3);
      c(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(((avwk)localObject).a(bool2));
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166983));
      v(bool2);
      k = afur.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
      avwb.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, k, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
    }
    label154:
    while ((QLog.isColorLevel()) && (QLog.isColorLevel()))
    {
      QLog.d("BaseListenTogetherPanel_Troop", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
      return;
      if (bool3)
      {
        bool3 = localagnm.a();
        z(4);
        c(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(localagnm.a());
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166983));
        v(bool3);
        k = afur.a(8.0F, this.jdField_f_of_type_AndroidWidgetTextView.getResources());
        avwb.a(this.jdField_b_of_type_AndroidViewViewGroup, 0, k, 0, 0, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
      }
      else
      {
        localObject = ((bgbd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a(a().jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label401;
        }
        z(2);
        c(true);
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166983));
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        x(false);
      }
    }
    for (;;)
    {
      avwb.a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_c_of_type_AndroidViewViewGroup.getRootView());
      break label154;
      break;
      label401:
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
      z(0);
    }
  }
  
  public void bG()
  {
    this.ao = false;
    this.ap = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_h_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    ((agjm)a(34)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void bn()
  {
    super.bn();
    this.jdField_a_of_type_Aglu.a(this);
  }
  
  public void bp()
  {
    boolean bool = false;
    super.bp();
    if (this.jdField_a_of_type_Bfrl == null)
    {
      aihd localaihd = new aihd(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Bfrl = new bfrl(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localaihd, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    bfrh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfrl);
    b(false);
    if (this.U != njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (!this.U) {
        bool = true;
      }
      this.U = bool;
      w(this.U);
    }
    ((bfrd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void bq()
  {
    super.bq();
    this.u = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    bT();
    bw();
    bU();
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localObject != null)
    {
      String str1 = ((Intent)localObject).getStringExtra("at_member_name");
      String str2 = ((Intent)localObject).getStringExtra("at_member_uin");
      int k = ((Intent)localObject).getIntExtra("at_member_source", 0);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        a(str2, str1, false, k);
      }
    }
    bV();
    this.ah = false;
    if (!this.ag) {
      bW();
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_e_of_type_JavaLangRunnable);
    ThreadManager.getSubThreadHandler().postDelayed(this.jdField_e_of_type_JavaLangRunnable, 500L);
    bE();
    this.ag = true;
    if ((this.ac) && (this.jdField_a_of_type_Beyp != null))
    {
      this.jdField_a_of_type_Beyp.a(true);
      this.ac = false;
    }
    localObject = (bevb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231);
    if ((((bevb)localObject).jdField_a_of_type_Int != 0) && (!njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!bcnj.b()))
    {
      ((bevb)localObject).a(new beuz(((bevb)localObject).e, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((bevb)localObject).b, ((bevb)localObject).c, ((bevb)localObject).d, ((bevb)localObject).jdField_a_of_type_Int));
      localObject = a();
      ((beuq)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((beuq)localObject).a();
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
      if ((this.jdField_c_of_type_Bgpa != null) && (this.jdField_c_of_type_Bgpa.isShowing())) {
        this.jdField_c_of_type_Bgpa.dismiss();
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
      localObject = (anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, getTroopCreditInfo:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        ((anwd)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
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
            ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a((ArrayList)localObject);
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
    anwd localanwd = (anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localanwd != null) {}
    try
    {
      localanwd.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), 0L, 2, 0, 0);
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
    bO();
    this.k.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166983));
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166983));
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850652);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166980));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166980));
      afur.a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850661);
      if ((this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_f_of_type_AndroidWidgetTextView.getText() != null) && (this.jdField_f_of_type_AndroidWidgetTextView.getText().toString().startsWith(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131689988))))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText("");
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166983));
        c(false);
      }
      localObject = (bgbd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234);
      String str = ((bgbd)localObject).a(a().jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(str)) {
        break label613;
      }
      z(2);
      if (((bgbd)localObject).a(a().jdField_a_of_type_JavaLangString) != 3) {
        break label556;
      }
      bgjt.a("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { a().jdField_a_of_type_JavaLangString });
      label303:
      c(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166983));
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      x(false);
    }
    for (;;)
    {
      localObject = (PlusPanel)this.jdField_a_of_type_Ahrb.b(8);
      if (localObject != null)
      {
        ((PlusPanel)localObject).a.b = false;
        ((PlusPanel)localObject).a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(false);
      }
      this.n.setVisibility(8);
      this.o.setVisibility(8);
      njo.a().b();
      bB();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(1.0F, 0.0F, 1.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131165408));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        afur.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130849881);
      }
      bz();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      ((agnm)a(43)).g();
      return;
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130850653);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166980));
      break;
      label556:
      new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().jdField_a_of_type_JavaLangString }).a();
      break label303;
      label613:
      z(0);
    }
  }
  
  public void bz()
  {
    if (this.jdField_a_of_type_Aimj != null)
    {
      amrr localamrr = amrr.a();
      if (localamrr != null) {
        localamrr.f();
      }
    }
  }
  
  public void c()
  {
    if (b(true)) {
      return;
    }
    bftx localbftx = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    boolean bool2 = localbftx.a();
    Object localObject = localbftx.b;
    String str1 = localbftx.c;
    this.Y = true;
    ArrayList localArrayList = new ArrayList();
    String str2 = bfmd.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    int k = 0;
    label196:
    boolean bool3;
    if (k < localArrayList.size())
    {
      MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(k);
      if (localbftx.a(localAtTroopMemberInfo.uin))
      {
        localObject = "" + localAtTroopMemberInfo.uin;
        str1 = bglf.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject);
        if ((bool2) || (localbftx.a(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          bool1 = true;
          bool3 = localbftx.b(str2, "" + localAtTroopMemberInfo.uin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          bool2 = bool1;
        }
      }
    }
    for (boolean bool1 = bool3;; bool1 = false)
    {
      super.c();
      if ((bool2) && (!bool1))
      {
        localObject = bfmd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
        a(localbftx.b, localbftx.c, true, 0);
      }
      for (;;)
      {
        this.Y = false;
        return;
        bool1 = false;
        break label196;
        k += 1;
        break;
        ahmp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, localArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if ((str2 == null) || (str2.length() <= 3478)) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        }
        if (this.W)
        {
          y(false);
          localObject = (agnt)a(23);
          if (localObject != null) {
            ((agnt)localObject).a(false);
          }
        }
        this.X = false;
        localbftx.a();
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    if (paramInt2 == 8) {
      if (!this.U) {}
    }
    for (;;)
    {
      if ((paramInt2 == 2) && (this.U)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(0);
      }
      return;
      if (!this.U) {}
    }
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    aU();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  public void d(Intent paramIntent)
  {
    super.d(paramIntent);
    bgso.a(null, "AIO_updateSession_business");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b.length() == 0))
    {
      paramIntent = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramIntent != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = paramIntent.troopcode;
      }
    }
    this.jdField_r_of_type_Int = 2;
    bgso.a("AIO_updateSession_business", null);
  }
  
  public void e(Intent paramIntent)
  {
    super.e(paramIntent);
    if (this.U) {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843615);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(njo.c);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(njo.c);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130850653);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(njo.c);
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850652);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166980));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166980));
        return;
      }
    } while (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130850653);
    this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166980));
  }
  
  public void f(boolean paramBoolean)
  {
    if (bfke.a().a()) {
      bfke.a().b();
    }
    if (this.ad) {
      bS();
    }
    super.f(paramBoolean);
  }
  
  public void g(String paramString)
  {
    if (a().isFinishing()) {}
    do
    {
      return;
      if (this.jdField_c_of_type_Biau == null) {
        this.jdField_c_of_type_Biau = new biau(a(), a().getTitleBarHeight());
      }
      this.jdField_c_of_type_Biau.a(paramString);
    } while ((a().isFinishing()) || (this.jdField_c_of_type_Biau.isShowing()));
    this.jdField_c_of_type_Biau.show();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject;
    int k;
    long l1;
    long l2;
    long l3;
    while ((paramMessage.what == 60) && (this.U))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundResource(2130843589);
      return true;
      if ((this.jdField_a_of_type_Aaqa != null) && (this.jdField_a_of_type_Aaqa.isShowing())) {
        this.jdField_a_of_type_Aaqa.dismiss();
      }
      this.jdField_a_of_type_Aaqa = new aaqa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Bfhl, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localObject = new int[2];
      this.jdField_a_of_type_AndroidViewViewGroup.getLocationOnScreen((int[])localObject);
      k = a();
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLocationInWindow(arrayOfInt);
      int m = arrayOfInt[1];
      int i1 = localObject[1];
      this.jdField_a_of_type_Aaqa.a(k, m - i1);
      this.jdField_a_of_type_Aaqa.a(paramMessage.arg1);
      continue;
      if ((this.jdField_a_of_type_Beqr != null) && (this.jdField_a_of_type_Beqr.b()))
      {
        localObject = this.jdField_a_of_type_Beqr.a();
        if (((bfhz)localObject).a.get())
        {
          ((bfhz)localObject).a.set(false);
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
          break label481;
        }
        if (l2 == l5) {
          break label621;
        }
        if (l3 != l5) {
          break label481;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e(".troop.chat_pie_msg", 1, "MSG_TROOP_ADMIN_OPERATION_NOTIFY: groupUin error", localNumberFormatException);
      }
      if (k != 0)
      {
        localObject = (PlusPanel)this.jdField_a_of_type_Ahrb.b(8);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: will reload plusPanel, groupUin:", Long.valueOf(l1) });
          }
          ((PlusPanel)localObject).a();
          break;
          break;
          label481:
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
      label621:
      k = 1;
    }
  }
  
  public void i()
  {
    super.i();
    this.jdField_a_of_type_Nnp = new nnp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      adrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
    this.Z = true;
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).i(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    awhv.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
    if (this.jdField_a_of_type_Aful != null) {
      this.jdField_a_of_type_Aful.a(this.jdField_a_of_type_Afum);
    }
    ThreadManager.post(new TroopChatPie.CheckGlamourPicturesRunnable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity), 2, null, true);
    int k;
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        if (!((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label325;
        }
        k = 1;
      }
    }
    for (;;)
    {
      new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_private").c("Grp_AIO").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(k) }).a();
      if (this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener == null)
      {
        this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new aihb(this, null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_b_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
      this.am = false;
      ((agnt)a(23)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      bG();
      return;
      label325:
      if (((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        k = 2;
      } else {
        k = 3;
      }
    }
  }
  
  public boolean i()
  {
    if (((agjm)a(34)).a()) {
      return true;
    }
    if (((agnm)a(43)).f()) {
      return true;
    }
    if (this.jdField_a_of_type_Beqr != null) {
      this.jdField_a_of_type_Beqr.a();
    }
    if (bfke.a().a()) {
      bfke.a().b();
    }
    if (this.jdField_a_of_type_Aimo != null) {
      this.jdField_a_of_type_Aimo.a();
    }
    if (this.jdField_a_of_type_Beyp != null) {
      this.jdField_a_of_type_Beyp.c();
    }
    if (this.ad) {
      bS();
    }
    return super.i();
  }
  
  public void j()
  {
    super.j();
    if ((this.jdField_a_of_type_Beqr.d()) && ((this.jdField_a_of_type_Beqr.b() == 17) || (this.jdField_a_of_type_Beqr.b() == 100) || (this.jdField_a_of_type_Beqr.b() == 11))) {}
    agkw localagkw;
    do
    {
      return;
      this.jdField_a_of_type_Aimo = new aimo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aimj, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Beqr, this.jdField_a_of_type_AndroidWidgetToast);
      this.jdField_a_of_type_Aimj.a(this.jdField_a_of_type_Aimo);
      this.jdField_a_of_type_Ailk = new ailk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aimj, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      this.jdField_a_of_type_Aimj.a(this.jdField_a_of_type_Ailk);
      this.jdField_a_of_type_Aimn = new aimn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aimj, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_Aimj.a(this.jdField_a_of_type_Aimn);
      localagkw = (agkw)a(71);
    } while (localagkw == null);
    localagkw.a(this.jdField_a_of_type_Aimj);
  }
  
  public void k(int paramInt)
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
      if (!this.af) {
        break label135;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      bgkl.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), false);
      b(true);
    }
    label135:
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711686);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 200L);
  }
  
  public void o(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "troopUin : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject3 = null;
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "avType : " + ((lmn)localObject1).jdField_a_of_type_Int);
        }
        if (((lmn)localObject1).jdField_a_of_type_Int != 2) {
          break label719;
        }
        if (((lmn)localObject1).jdField_a_of_type_Boolean)
        {
          bcst.b(null, "CliOper", "", "", "0X80066C2", "0X80066C2", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
        }
      }
      else
      {
        bL();
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          break label819;
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetScrollView = new aigq(this, this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setScrollbarFadingEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalScrollBarEnabled(false);
        this.s = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        localObject1 = new RelativeLayout.LayoutParams(-1, this.s);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = bggq.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, 0, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, -1, this.s);
        localObject1 = (bevb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231);
        this.jdField_a_of_type_Beuq = a();
        ((bevb)localObject1).jdField_a_of_type_Int = 0;
        ((bevb)localObject1).b = 0;
        ((bevb)localObject1).c = 0;
        ((bevb)localObject1).d = 0;
        if (!bcnj.b()) {
          ((bevb)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_Beyp == null) {
          this.jdField_a_of_type_Beyp = ((beyp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(289));
        }
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Beyp.a(((TroopInfo)localObject1).dwGroupClassExt, true, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          this.ae = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equalsIgnoreCase(((TroopInfo)localObject1).troopowneruin);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause, isTroopOwner =" + this.ae + ",troopInfo = " + localObject1);
        }
        bK();
        bJ();
        localObject1 = (aqua)aqlk.a().a(553);
        if ((localObject1 != null) && (!((aqua)localObject1).jdField_a_of_type_Boolean))
        {
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
        }
        bR();
        localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
        this.ad = ((Intent)localObject1).getBooleanExtra("open_chat_from_group_rec_confess", false);
        if (this.ad)
        {
          j((Intent)localObject1);
          h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.k = this.ad;
        x(false);
        super.o(paramInt);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        label819:
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onShowFirst : invalid uin!");
          localObject2 = localObject3;
          continue;
          bcst.b(null, "CliOper", "", "", "0X80066BF", "0X80066BF", 0, 0, "", "", "", "");
          continue;
          label719:
          if (((lmn)localObject2).jdField_a_of_type_Int == 10)
          {
            if (((lmn)localObject2).jdField_a_of_type_Boolean) {
              bcst.b(null, "CliOper", "", "", "0X80066C1", "0X80066C1", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), 1);
              break;
              bcst.b(null, "CliOper", "", "", "0X80066BE", "0X80066BE", 0, 0, "", "", "", "");
            }
            this.s = (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
            localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).height = this.s;
            ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
            this.jdField_a_of_type_AndroidWidgetScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            this.jdField_a_of_type_AndroidWidgetScrollView.removeAllViews();
            this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, -1, this.s);
          }
        }
      }
    }
  }
  
  public void o(boolean paramBoolean)
  {
    if (bgsg.n(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      a(paramBoolean, TroopGiftPanel.jdField_f_of_type_Int);
      bgsg.k(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      return;
    }
    a(paramBoolean, TroopGiftPanel.e);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131367274) && (b(true))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      if (paramView.getId() == 2131371393)
      {
        if ((this.jdField_a_of_type_Aimo != null) && (this.jdField_a_of_type_Aimo.a())) {
          this.jdField_a_of_type_Aimj.a();
        }
      }
      else if (paramView.getId() == 2131371391) {
        bQ();
      } else if ((paramView.getId() == 2131368961) && (this.jdField_j_of_type_AndroidWidgetImageView != null) && (this.jdField_j_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
        bfxz.a(this.jdField_j_of_type_AndroidWidgetImageView).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_Beqr != null) {
      this.jdField_a_of_type_Beqr.a().a(paramInt, 500L);
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
      this.al = bool;
      paramAbsListView = this.jdField_b_of_type_JavaUtilList.iterator();
      while (paramAbsListView.hasNext()) {
        ((aihc)paramAbsListView.next()).a(this.al);
      }
    }
    if ((paramInt == 0) && (this.jdField_i_of_type_JavaLangString != null))
    {
      paramAbsListView = ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a();
      this.jdField_i_of_type_JavaLangString = null;
      paramAbsListView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
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
        if ((paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '$') && (paramCharSequence.charAt(paramInt1) != 65509) && (paramCharSequence.charAt(paramInt1) != '¥') && (paramCharSequence.charAt(paramInt1) != 65284)) || (this.jdField_r_of_type_Boolean) || (((agmv)a(27)).jdField_a_of_type_Boolean)) {
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "sign", 0, 0, paramCharSequence.troopuin + "", paramInt1 + "", "", "");
      bftg.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramCharSequence.troopuin, "input", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      if (paramCharSequence.isAdmin()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
    if ((!this.jdField_r_of_type_Boolean) && (!((agmv)a(27)).jdField_a_of_type_Boolean)) {
      ((agjm)a(34)).b(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    bD();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Aart != null) && (this.jdField_a_of_type_Aart.a()))
    {
      this.jdField_a_of_type_Aart.a();
      amuf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_gift_panel", false);
    }
    if ((paramView.getId() == 2131369922) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void r()
  {
    aU();
    ((agnm)a(43)).h();
  }
  
  public void s()
  {
    super.s();
    aqkl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "update");
    }
    if (paramObject == null) {}
    label197:
    label469:
    for (;;)
    {
      return;
      if ((paramObject instanceof bftm))
      {
        paramObservable = (bftm)paramObject;
        if (paramObservable.jdField_a_of_type_Int == 1)
        {
          this.ao = paramObservable.jdField_a_of_type_Boolean;
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramObservable.jdField_a_of_type_Long));
          c(paramObservable.jdField_a_of_type_Long);
          f(131088);
          return;
        }
      }
      if ((paramObject instanceof MessageRecord)) {
        if ((paramObject instanceof ChatMessage))
        {
          paramObservable = (MessageRecord)paramObject;
          this.jdField_f_of_type_Long = paramObservable.shmsgseq;
          if (paramObservable.isSendFromLocal()) {
            break label289;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((acwh.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (acwh.d(paramObservable.istroop)))) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) && ((paramObject instanceof MessageForTroopEffectPic))) {
            p(false);
          }
          TroopAddFriendTipsHelper localTroopAddFriendTipsHelper = (TroopAddFriendTipsHelper)a(28);
          if (localTroopAddFriendTipsHelper != null) {
            localTroopAddFriendTipsHelper.a(paramObservable);
          }
        }
      }
      for (;;)
      {
        if (!(paramObject instanceof MessageForText)) {
          break label469;
        }
        paramObservable = (MessageForText)paramObject;
        if (!paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TroopChatPie.update()");
        }
        bhgz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, paramObservable.msg, this.jdField_a_of_type_AndroidContentContext, paramObservable.isSend());
        return;
        if ((!((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a().b("highFreqInteract")) || (this.ab)) {
          break label197;
        }
        this.ab = true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable = new TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.a(false);
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable);
        break label197;
        if ((paramObject instanceof bepx)) {
          b(paramObject);
        } else if ((paramObject instanceof Integer)) {
          switch (((Integer)paramObject).intValue())
          {
          case 123321: 
          default: 
            break;
          case 123322: 
            if ((this.jdField_a_of_type_Bfhl != null) && (this.jdField_a_of_type_Bfhl.a())) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(1, this.jdField_a_of_type_Bfhl.a() / 2);
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
    bg();
  }
  
  public void v(int paramInt)
  {
    if (!this.U) {
      super.v(paramInt);
    }
  }
  
  public void v(boolean paramBoolean)
  {
    Object localObject = (LinearLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetImageView.getLayoutParams();
    this.jdField_h_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
    ((LinearLayout.LayoutParams)localObject).width = zlx.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).height = zlx.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    try
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      int k;
      if (paramBoolean)
      {
        k = 2130843822;
        localObject = ((Resources)localObject).getDrawable(k);
        if ((!bcnj.b()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label185;
        }
        ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131166983), PorterDuff.Mode.MULTIPLY);
        label114:
        if (!paramBoolean) {
          break label217;
        }
        Drawable localDrawable = this.jdField_h_of_type_AndroidWidgetImageView.getDrawable();
        if ((localDrawable instanceof AnimationDrawable)) {
          ((AnimationDrawable)localDrawable).stop();
        }
        ((Drawable)localObject).setBounds(0, 0, zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
        this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      label185:
      label217:
      do
      {
        return;
        k = 2130843829;
        break;
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
        {
          ((Drawable)localObject).clearColorFilter();
          break label114;
        }
        ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
        break label114;
        if ((Build.VERSION.SDK_INT < 21) || (this.an))
        {
          ((Drawable)localObject).setBounds(0, 0, zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
        }
        if (this.t == 2)
        {
          localObject = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843828);
          ((AnimationDrawable)localObject).setOneShot(true);
          ((AnimationDrawable)localObject).setBounds(0, 0, zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
          this.an = true;
          return;
        }
        if (this.t == 3)
        {
          localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843829);
          ((Drawable)localObject).setBounds(0, 0, zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
        }
      } while (this.t != 4);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843829);
      ((Drawable)localObject).setBounds(0, 0, zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramBoolean = ((agnm)a(43)).d();
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
  
  public void w(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean, this);
    }
    ((agni)a(29)).c(paramBoolean);
    this.U = paramBoolean;
    njo.a().a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((paramBoolean) || (amuf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      amuf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_anonyous", paramBoolean);
    }
    Object localObject;
    if (this.n == null)
    {
      this.n = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.n.setBackgroundColor(Color.rgb(19, 19, 21));
      this.n.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.n, (ViewGroup.LayoutParams)localObject);
    }
    if (this.q == null)
    {
      this.q = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.q.setBackgroundResource(2130843595);
      this.q.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.q, 0);
    }
    if (this.p == null)
    {
      this.p = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.p.setBackgroundResource(2130843595);
      this.p.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.p, 0);
    }
    if (this.o == null)
    {
      this.o = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.o.setBackgroundColor(Color.rgb(19, 19, 21));
      this.o.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131368652);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.o, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_a_of_type_Bfhl != null) {
      this.jdField_a_of_type_Bfhl.a(paramBoolean);
    }
    if (paramBoolean)
    {
      paramBoolean = ((avwk)a(33)).c();
      localObject = (agnm)a(43);
      boolean bool = ((agnm)localObject).c();
      if ((!paramBoolean) && (!bool)) {
        z(1);
      }
      this.k.setVisibility(8);
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.c()))
      {
        ImmersiveUtils.a(false, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow());
        a(-16777216, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131377624).setVisibility(8);
        afur.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130843595);
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(njo.c);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(njo.c);
        if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          break label880;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843615);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(njo.c);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(njo.c);
        label571:
        if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_a_of_type_JavaLangCharSequence = this.jdField_f_of_type_AndroidWidgetTextView.getText();
        }
        bQ();
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131689988) + njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).jdField_a_of_type_JavaLangString);
        this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(njo.c);
        afur.a(this.jdField_a_of_type_AndroidWidgetImageView, null);
        c(true);
        PlusPanel localPlusPanel = (PlusPanel)this.jdField_a_of_type_Ahrb.b(8);
        if (localPlusPanel != null)
        {
          localPlusPanel.a.b = true;
          localPlusPanel.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(true);
        }
        this.o.setVisibility(0);
        this.jdField_a_of_type_Njs = new aign(this);
        njo.a().a(this.jdField_a_of_type_Njs);
        this.jdField_a_of_type_Aimj.a();
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(2131695355);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
        {
          afur.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130843595);
          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 8) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          }
        }
        ((agnm)localObject).g();
      }
    }
    for (;;)
    {
      z();
      r();
      this.jdField_a_of_type_Afwy.notifyDataSetChanged();
      return;
      a(-16777216, false);
      break;
      label880:
      if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label571;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130850653);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(njo.c);
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130837976);
      break label571;
      by();
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
        bcst.b((QQAppInterface)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
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
    if ((this.U) || (this.V)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843611);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      a(this.jdField_a_of_type_AndroidWidgetImageView, 2130850121, 2130850122);
    }
  }
  
  public void z(int paramInt)
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
      if (((agnm)a(43)).d()) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie
 * JD-Core Version:    0.7.0.1
 */
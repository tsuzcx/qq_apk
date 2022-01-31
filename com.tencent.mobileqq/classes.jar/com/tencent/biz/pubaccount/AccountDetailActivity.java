package com.tencent.biz.pubaccount;

import abgm;
import abtt;
import ahpf;
import ajsf;
import ajyc;
import akdi;
import akdo;
import akqx;
import aktg;
import akws;
import akwx;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import aqss;
import aukn;
import auko;
import awvr;
import axqw;
import axuy;
import axwh;
import aydb;
import baxt;
import bazo;
import bbca;
import bbev;
import bbfc;
import bbjc;
import bbje;
import bbju;
import bcpq;
import bcpw;
import bdhv;
import bdto;
import bfol;
import bfoy;
import bgpv;
import com.tencent.biz.pubaccount.AccountDetail.activity.PubAccountMoreInfoActivity;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.biz.pubaccount.util.ProfileParams.CurLoginUsr;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import nbc;
import ned;
import nfh;
import nfj;
import nhf;
import nhh;
import nhi;
import nhj;
import nhk;
import nhl;
import nhm;
import nhn;
import nho;
import nhp;
import nhq;
import nhr;
import nhs;
import nht;
import nhu;
import nhv;
import nhw;
import nhx;
import nhy;
import nhz;
import nia;
import nib;
import nic;
import nid;
import nmv;
import noo;
import nou;
import nri;
import nrk;
import nrw;
import olm;
import onk;
import org.json.JSONArray;
import org.json.JSONObject;
import sbc;
import sen;
import sgj;
import shx;
import sjs;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import xbl;
import xbn;
import xnz;

public class AccountDetailActivity
  extends BaseActivity
  implements View.OnClickListener, nhf
{
  public static int i;
  public static int j;
  public static int k = 1;
  protected float a;
  long jdField_a_of_type_Long;
  final akdo jdField_a_of_type_Akdo = new nhh(this);
  public Intent a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new nhx(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  protected ImageView a;
  public RelativeLayout a;
  public bbjc a;
  bcpq jdField_a_of_type_Bcpq;
  public bfol a;
  protected AccountDetailTopGestureLayout a;
  public AccountDetailXListView a;
  public ProfileParams a;
  public PublicAccountHandler a;
  public QQAppInterface a;
  public AccountDetail a;
  public mobileqq_mp.GetPublicAccountDetailInfoResponse a;
  protected BusinessObserver a;
  public ned a;
  nic jdField_a_of_type_Nic;
  nid jdField_a_of_type_Nid;
  public JSONObject a;
  protected xbl a;
  xnz jdField_a_of_type_Xnz;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  public int b;
  long jdField_b_of_type_Long;
  akws jdField_b_of_type_Akws;
  public View b;
  protected Button b;
  public ImageView b;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public bfol b;
  public String b;
  protected BusinessObserver b;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  akws jdField_c_of_type_Akws;
  View jdField_c_of_type_AndroidViewView;
  protected Button c;
  public ImageView c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  protected NewIntent c;
  BusinessObserver jdField_c_of_type_MqqObserverBusinessObserver;
  public boolean c;
  int d;
  protected View d;
  public Button d;
  public ImageView d;
  public String d;
  protected NewIntent d;
  protected boolean d;
  int jdField_e_of_type_Int = 0;
  protected View e;
  public String e;
  NewIntent jdField_e_of_type_MqqAppNewIntent;
  public boolean e;
  int f;
  protected View f;
  public String f;
  public boolean f;
  public int g;
  private View g;
  protected String g;
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  public int l;
  boolean l;
  boolean m = false;
  boolean n = false;
  public boolean o = false;
  public boolean p;
  boolean q = false;
  public boolean r = false;
  boolean s = false;
  
  static
  {
    jdField_j_of_type_Int = -1;
  }
  
  public AccountDetailActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = null;
    this.jdField_a_of_type_Bfol = null;
    this.jdField_b_of_type_Bfol = null;
    this.jdField_b_of_type_Int = 1008;
    this.jdField_d_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_l_of_type_Int = jdField_i_of_type_Int;
    this.jdField_a_of_type_AndroidOsHandler = new nht(this);
  }
  
  public static String a(String paramString)
  {
    if (paramString != null) {
      try
      {
        int i1 = paramString.indexOf("article_id=");
        if (i1 > 0)
        {
          String str = paramString.substring(i1 + 11);
          i1 = str.indexOf("&");
          paramString = str;
          if (i1 >= 0) {
            paramString = str.substring(0, i1);
          }
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.hasExtra("source"))) {
      return;
    }
    switch (paramIntent.getIntExtra("source", 0))
    {
    default: 
      return;
    case 1: 
      noo.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574C", "0X800574C", 0, 0, paramString, "", "", "", false);
      return;
    case 2: 
      noo.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574D", "0X800574D", 0, 0, paramString, "", "", "", false);
      return;
    case 3: 
      noo.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574E", "0X800574E", 0, 0, paramString, "", "", "", false);
      return;
    }
    noo.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800589D", "0X800589D", 0, 0, paramString, "", "", "", false);
  }
  
  private void a(String paramString)
  {
    aktg localaktg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int i1 = sgj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString);
    if (i1 == 1024) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "setOrCancelTop pUin = " + paramString + " userType = " + i1 + " is UIN_TYPE_BUSINESS_CMR_TMP");
    }
    RecentUser localRecentUser = localaktg.b(paramString, i1);
    Object localObject = localRecentUser;
    if (localRecentUser == null)
    {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "setOrCancelTop pUin = " + paramString + " userType = " + i1 + " not in the msglist");
      localObject = new RecentUser(this.jdField_d_of_type_JavaLangString, i1);
    }
    boolean bool = a(paramString);
    if (bool)
    {
      ((RecentUser)localObject).showUpTime = 0L;
      localaktg.a((RecentUser)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
      if (bool) {
        break label218;
      }
    }
    label218:
    for (bool = true;; bool = false)
    {
      shx.a(i1, paramString, bool);
      return;
      ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
      break;
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    long l1 = aydb.a().b();
    Object localObject = aydb.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (localObject != null)
    {
      int i1 = ((structmsg.StructMsg)localObject).msg_type.get();
      l1 = ((structmsg.StructMsg)localObject).msg_seq.get();
      long l2 = ((structmsg.StructMsg)localObject).req_uin.get();
      int i2 = ((structmsg.StructMsg)localObject).msg.sub_type.get();
      int i3 = ((structmsg.StructMsg)localObject).msg.src_id.get();
      int i4 = ((structmsg.StructMsg)localObject).msg.sub_src_id.get();
      int i5 = ((structmsg.StructMsg)localObject).msg.group_msg_type.get();
      localObject = ((structmsg.StructMsg)localObject).msg.actions.get();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (paramInt < ((List)localObject).size())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected static boolean a(AccountDetail paramAccountDetail)
  {
    boolean bool2 = true;
    if (paramAccountDetail == null) {
      return false;
    }
    int i1 = sgj.a(paramAccountDetail.accountFlag);
    boolean bool1 = bool2;
    if (i1 != -2)
    {
      bool1 = bool2;
      if (i1 != -3)
      {
        if (i1 != -4) {
          break label42;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      label42:
      bool1 = bool2;
      if (sgj.a(paramAccountDetail.accountFlag2) != -8L) {
        bool1 = false;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int i1 = sgj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString);
    RecentUser localRecentUser = ((aktg)localObject).b(paramString, i1);
    localObject = localRecentUser;
    if (localRecentUser == null)
    {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "isPublicAccoutMsgTabSetTop pUin = " + paramString + " userType = " + i1 + " not in the msglist");
      localObject = new RecentUser(this.jdField_d_of_type_JavaLangString, i1);
    }
    return ((RecentUser)localObject).showUpTime != 0L;
  }
  
  private List<bbje>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new bbje();
    ((bbje)localObject).a = super.getString(2131696695);
    ((bbje)localObject).jdField_b_of_type_Int = 2130838754;
    ((bbje)localObject).jdField_b_of_type_Boolean = true;
    ((bbje)localObject).jdField_c_of_type_Int = 2;
    ((bbje)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new bbje();
    ((bbje)localObject).a = super.getString(2131696708);
    ((bbje)localObject).jdField_b_of_type_Int = 2130838755;
    ((bbje)localObject).jdField_b_of_type_Boolean = true;
    ((bbje)localObject).jdField_c_of_type_Int = 3;
    ((bbje)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new bbje();
    ((bbje)localObject).a = super.getString(2131696715);
    ((bbje)localObject).jdField_b_of_type_Int = 2130838758;
    ((bbje)localObject).jdField_c_of_type_Int = 9;
    ((bbje)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new bbje();
    ((bbje)localObject).a = super.getString(2131696698);
    ((bbje)localObject).jdField_b_of_type_Int = 2130838752;
    ((bbje)localObject).jdField_c_of_type_Int = 10;
    ((bbje)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    bdto.a(this, localArrayList);
    localObject = new ArrayList();
    if (d())
    {
      localbbje = new bbje();
      localbbje.a = super.getString(2131695545);
      localbbje.jdField_b_of_type_Int = 2130842132;
      localbbje.jdField_b_of_type_Boolean = true;
      localbbje.jdField_c_of_type_Int = 30;
      localbbje.jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject).add(localbbje);
    }
    bbje localbbje = new bbje();
    localbbje.a = super.getString(2131695606);
    localbbje.jdField_b_of_type_Int = 2130842124;
    localbbje.jdField_b_of_type_Boolean = true;
    localbbje.jdField_c_of_type_Int = 31;
    localbbje.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localbbje);
    localbbje = new bbje();
    localbbje.a = super.getString(2131695587);
    localbbje.jdField_b_of_type_Int = 2130842116;
    localbbje.jdField_b_of_type_Boolean = true;
    localbbje.jdField_c_of_type_Int = 11;
    localbbje.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localbbje);
    if (d())
    {
      localbbje = new bbje();
      localbbje.a = super.getString(2131695616);
      localbbje.jdField_b_of_type_Int = 2130842142;
      localbbje.jdField_b_of_type_Boolean = true;
      localbbje.jdField_c_of_type_Int = 32;
      localbbje.jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject).add(localbbje);
    }
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private boolean f()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  protected void A()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("settingInfo", "");
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    localIntent.putExtra("moduleId", "cmshowgame_module");
    if (aqss.b())
    {
      PublicFragmentActivityForTool.b(this, localIntent, QQGameFeedWebFragment.class, 10000);
      return;
    }
    PublicFragmentActivity.a(this, localIntent, QQGamePubAccountFragment.class, 10000);
  }
  
  protected void B()
  {
    this.jdField_a_of_type_Bfol = ((bfol)bfoy.a(this, null));
    if ((this.jdField_d_of_type_JavaLangString.equals("1770946116")) || (nbc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Bfol.a(2131695608, 5);
      this.jdField_a_of_type_Bfol.a(2131695587, 5);
      if (d()) {
        this.jdField_a_of_type_Bfol.a(2131695616, 3);
      }
      this.jdField_a_of_type_Bfol.c(2131690596);
      this.jdField_a_of_type_Bfol.a(new nhj(this));
      this.jdField_a_of_type_Bfol.setOnDismissListener(new nhk(this));
      if (!this.jdField_a_of_type_Bfol.isShowing())
      {
        this.o = false;
        this.jdField_a_of_type_Bfol.show();
      }
      return;
    }
    if (d()) {
      if ((sbc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)) || (sbc.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Bfol.a(2131695608, 5);
        this.jdField_a_of_type_Bfol.a(2131695587, 5);
        this.jdField_a_of_type_Bfol.c(2131690596);
        this.jdField_a_of_type_Bfol.a(new nhl(this));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfol.setOnDismissListener(new nhp(this));
      if (this.jdField_a_of_type_Bfol.isShowing()) {
        break;
      }
      this.o = false;
      this.jdField_a_of_type_Bfol.show();
      return;
      if (sbc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Bfol.a(2131695608, 5);
        this.jdField_a_of_type_Bfol.a(2131695587, 5);
        if (a(this.jdField_d_of_type_JavaLangString)) {
          this.jdField_a_of_type_Bfol.a(2131695529, 5);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bfol.c(2131690596);
          this.jdField_a_of_type_Bfol.a(new nhm(this));
          break;
          this.jdField_a_of_type_Bfol.a(2131695605, 5);
        }
      }
      this.jdField_a_of_type_Bfol.a(2131695608, 5);
      this.jdField_a_of_type_Bfol.a(2131695587, 5);
      if (d()) {
        this.jdField_a_of_type_Bfol.a(2131695616, 3);
      }
      this.jdField_a_of_type_Bfol.c(2131690596);
      this.jdField_a_of_type_Bfol.a(new nhn(this));
      continue;
      this.jdField_a_of_type_Bfol.a(2131695608, 5);
      this.jdField_a_of_type_Bfol.a(2131695587, 5);
      this.jdField_a_of_type_Bfol.c(2131690596);
      this.jdField_a_of_type_Bfol.a(new nho(this));
    }
  }
  
  protected void C()
  {
    if (this.jdField_a_of_type_Bbjc == null)
    {
      this.jdField_a_of_type_Bbjc = new bbjc(this);
      this.jdField_a_of_type_Bbjc.a(getString(2131719497));
      this.jdField_a_of_type_Bbjc.a(a());
      this.jdField_a_of_type_Bbjc.a(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_Bbjc.a();
        return;
        this.jdField_a_of_type_Bbjc.a(a());
      }
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public void D()
  {
    Intent localIntent = new Intent(getActivity(), PubAccountMoreInfoActivity.class);
    localIntent.putExtra("uin", this.jdField_d_of_type_JavaLangString);
    startActivity(localIntent);
  }
  
  public void E()
  {
    ThreadManager.getSubThreadHandler().post(new AccountDetailActivity.18(this));
  }
  
  public void F()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "initData hasCache");
      }
      this.jdField_c_of_type_Boolean = false;
      j();
      d();
      return;
    }
    ThreadManager.getSubThreadHandler().post(new AccountDetailActivity.19(this));
  }
  
  public void G()
  {
    this.jdField_b_of_type_Bfol = bfol.a(this);
    String str = getString(2131695618, new Object[] { a() });
    this.jdField_b_of_type_Bfol.a(str);
    this.jdField_b_of_type_Bfol.a(2131696741, 3);
    this.jdField_b_of_type_Bfol.c(2131690596);
    this.jdField_b_of_type_Bfol.setOnDismissListener(new nhq(this));
    this.jdField_b_of_type_Bfol.a(new nhr(this));
    if (!this.jdField_b_of_type_Bfol.isShowing())
    {
      this.p = false;
      this.jdField_b_of_type_Bfol.show();
    }
  }
  
  public void H()
  {
    if (c())
    {
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  void I()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setVisibility(8);
  }
  
  @TargetApi(16)
  void J()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (!this.jdField_l_of_type_Boolean)) {}
    while (!c()) {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidWidgetButton.setText(2131695614);
    this.jdField_d_of_type_AndroidWidgetButton.setAlpha(0.5F);
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.23(this), 0L);
  }
  
  void K()
  {
    this.jdField_a_of_type_Ned.a(a());
    this.jdField_a_of_type_Ned.b(b());
    this.jdField_a_of_type_Ned.c(c());
    this.jdField_a_of_type_Ned.a(this.jdField_l_of_type_Boolean);
    this.jdField_a_of_type_Ned.a(b());
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_Ned.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
  }
  
  public void L()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
  }
  
  void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "firstFetch");
    }
    d();
    j();
  }
  
  void N()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest");
    }
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), nou.class);
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.2.8,3,4440");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localGetPublicAccountDetailInfoRequest.seqno.set(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.jdField_d_of_type_JavaLangString));
        label124:
        this.jdField_c_of_type_MqqAppNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
        this.jdField_a_of_type_MqqObserverBusinessObserver = new nhu(this);
        this.jdField_c_of_type_MqqAppNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_c_of_type_MqqAppNewIntent);
        this.jdField_c_of_type_Int += 1;
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest exit");
        }
        return;
        localGetPublicAccountDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      break label124;
    }
  }
  
  protected void O()
  {
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateHDFace uin is null");
      }
    }
    do
    {
      return;
      if (bbev.h(this)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateHDFace not wifi, so need't update");
    return;
    this.jdField_a_of_type_Nid = new nid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Nid.a();
  }
  
  public void P()
  {
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "setHDFace uin is null");
      }
    }
    while (this.jdField_a_of_type_Ned == null) {
      return;
    }
    Drawable localDrawable = c();
    this.jdField_a_of_type_Ned.c(localDrawable);
    this.jdField_a_of_type_Ned.notifyDataSetChanged();
  }
  
  public int a()
  {
    return 1;
  }
  
  public akdo a()
  {
    return this.jdField_a_of_type_Akdo;
  }
  
  Bitmap a(Bitmap paramBitmap)
  {
    int i3 = 0;
    int i4 = getWindowManager().getDefaultDisplay().getWidth();
    int i5 = (int)(140.0F * this.jdField_a_of_type_Float);
    int i1 = paramBitmap.getHeight();
    int i2 = paramBitmap.getWidth();
    if (i2 * i5 > i1 * i4)
    {
      i5 = i4 * i1 / i5;
      i4 = (i2 - i5) / 2;
      i2 = i5;
    }
    for (;;)
    {
      return Bitmap.createBitmap(paramBitmap, i4, i3, i2, i1);
      i4 = i5 * i2 / i4;
      i3 = (i1 - i4) / 2;
      i1 = i4;
      i4 = 0;
    }
  }
  
  Drawable a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return null;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundImg)) {
      return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundImg);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.25(this), 10L);
    return null;
  }
  
  Drawable a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      paramBitmap = a(paramBitmap);
      bbju.a(paramBitmap, 1);
      paramBitmap = new BitmapDrawable(paramBitmap);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  protected String a()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name;
    }
    return str;
  }
  
  String a(Intent paramIntent)
  {
    Object localObject = null;
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("uin");
    }
    do
    {
      return paramIntent;
      paramIntent = localObject;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams == null);
    return this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.a().jdField_b_of_type_JavaLangString;
  }
  
  protected List<nmv> a(List<nmv> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(2);
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      nmv localnmv = (nmv)paramList.get(i1);
      if ((localnmv.a == 3) && ((localnmv.jdField_c_of_type_Int == 7) || (localnmv.jdField_c_of_type_Int == 8))) {
        localArrayList.add(localnmv);
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public JSONObject a(BaseActivity paramBaseActivity, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = paramBaseActivity.app.a().a(paramString, 0, new int[] { -1000, -2000, -2002, -2011, -2022 }, 40);
        paramBaseActivity = new ArrayList();
        if (localObject1 != null)
        {
          i1 = ((List)localObject1).size();
          if (i1 > 0)
          {
            if (((MessageRecord)((List)localObject1).get(i1 - 1)).issend != 0) {
              break label712;
            }
            paramBaseActivity.add(((List)localObject1).get(i1 - 1));
            if (paramBaseActivity.size() <= 4) {
              break label712;
            }
          }
        }
        localObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
        localJSONObject2.put("qq", localObject2);
        Object localObject3 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        String str = String.valueOf(NetConnInfoCenter.getServerTime());
        localJSONObject2.put("skey", localObject3);
        localJSONObject2.put("mpUin", paramString);
        localJSONObject2.put("timestamp", "" + str);
        localJSONObject2.put("scene", "201");
        localJSONObject2.put("subAppname", "profile");
        localJSONObject2.put("sign", bdhv.b((String)localObject2 + paramString + 201 + str + "jubao@article@123").toLowerCase());
        if (paramBaseActivity != null)
        {
          int i2 = 0;
          if (i2 < paramBaseActivity.size())
          {
            paramString = new JSONObject();
            localObject2 = new JSONObject();
            localObject3 = (MessageRecord)paramBaseActivity.get(i2);
            if ((localObject3 instanceof MessageForText))
            {
              ((JSONObject)localObject2).put("text", ((MessageRecord)localObject3).msg);
              i1 = 1;
              paramString.put("content", localObject2);
              paramString.put("messageType", "" + i1);
              localJSONArray.put(i2, paramString);
              i2 += 1;
              continue;
            }
            if ((localObject3 instanceof MessageForPic))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForPic)localObject3).uuid);
              i1 = 2;
              continue;
            }
            if ((localObject3 instanceof MessageForPtt))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForPtt)localObject3).urlAtServer);
              ((JSONObject)localObject2).put("fileType", ((MessageForPtt)localObject3).busiType);
              i1 = 3;
              continue;
            }
            if ((localObject3 instanceof MessageForShortVideo))
            {
              ((JSONObject)localObject2).put("fileUuid", ((MessageForShortVideo)localObject3).uuid.substring(1));
              i1 = 4;
              continue;
            }
            if ((localObject3 instanceof MessageForStructing))
            {
              ((JSONObject)localObject2).put("text", new String(axwh.a(bgpv.a(axuy.a(((MessageRecord)localObject3).msgData).getXmlBytes()), 0), "utf-8"));
              i1 = 5;
              continue;
            }
          }
          else
          {
            ((JSONObject)localObject1).put("msgNum", "" + paramBaseActivity.size());
            ((JSONObject)localObject1).put("messageList", bbca.encodeToString(localJSONArray.toString().getBytes("utf-8"), 0));
          }
        }
        else
        {
          localJSONObject1.put("Verify", localJSONObject2);
          localJSONObject1.put("reportData", localObject1);
          return localJSONObject1;
        }
      }
      catch (Exception paramBaseActivity)
      {
        return null;
      }
      int i1 = 0;
      continue;
      label712:
      i1 -= 1;
    }
  }
  
  public xbn a()
  {
    xbn localxbn = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      localxbn = new xbn(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
      localxbn.jdField_c_of_type_Int = xbn.jdField_b_of_type_Int;
      localxbn.jdField_a_of_type_Boolean = c();
      localxbn.jdField_d_of_type_Int = noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
    return localxbn;
  }
  
  @TargetApi(9)
  protected void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView = ((AccountDetailXListView)super.findViewById(2131361825));
    this.jdField_d_of_type_Int = getWindowManager().getDefaultDisplay().getHeight();
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setRefreshCallback(this);
    l();
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.mShowMsgFlag = paramInt;
    }
  }
  
  public void a(abgm paramabgm)
  {
    if (paramabgm == null) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateCurrentImage currentImage is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateCurrentImage uin=" + paramabgm.jdField_d_of_type_JavaLangString + ", state=" + paramabgm.a);
      }
    } while (paramabgm.a != 6);
    f(paramabgm.jdField_c_of_type_JavaLangString);
  }
  
  void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Xnz == null) {
      this.jdField_a_of_type_Xnz = new xnz(paramActivity);
    }
    this.jdField_a_of_type_Xnz.a(ajyc.a(2131699738));
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131719410);
    str = str + ajyc.a(2131699739);
    paramActivity = new nhi(this, paramActivity);
    this.jdField_a_of_type_Xnz.a(str, paramActivity);
    this.jdField_a_of_type_Xnz.a(paramActivity);
    this.jdField_a_of_type_Xnz.show();
  }
  
  void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    Object localObject = paramIntent.getExtras();
    if (localObject != null)
    {
      localObject = (ProfileParams)((Bundle)localObject).getParcelable("profile_params");
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams = ((ProfileParams)localObject);
      }
    }
    this.jdField_d_of_type_JavaLangString = a(paramIntent);
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("report_src_param_type");
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("report_src_param_name");
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "[sopType]:" + this.jdField_b_of_type_JavaLangString + ",[sopName]:" + this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("extvalue");
    this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("exttype");
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      if (!"2".equals(this.jdField_g_of_type_JavaLangString)) {
        break label184;
      }
      this.jdField_e_of_type_Boolean = true;
    }
    while ((this.jdField_d_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      return;
      label184:
      if ("1".equals(this.jdField_g_of_type_JavaLangString)) {
        this.jdField_f_of_type_Boolean = true;
      }
    }
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
    r();
    O();
    b(paramIntent);
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
  }
  
  void a(AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "saveAccountDetailToDBAndCache");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, paramAccountDetail.name);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.clone(paramAccountDetail);
      if (!((aukn)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        ((aukn)localObject).a(AccountDetail.class);
      }
    }
    for (;;)
    {
      ((aukn)localObject).a();
      localObject = (akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if ((localObject != null) && (paramAccountDetail != null))
      {
        ((akdi)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
        if (paramAccountDetail.followType == 1) {
          ((akdi)localObject).a(PublicAccountInfo.createPublicAccount(paramAccountDetail, 0L));
        }
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
      ((aukn)localObject).a(paramAccountDetail);
    }
  }
  
  public void a(AccountDetail paramAccountDetail, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.27(this, paramAccountDetail, paramBoolean), 10L);
  }
  
  public void a(ListView paramListView)
  {
    if (this.r)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "startLoadMore: uin=" + this.jdField_d_of_type_JavaLangString);
      }
      nfh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_d_of_type_JavaLangString), this.jdField_a_of_type_Akdo);
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, Class<? extends Activity> paramClass)
  {
    a(paramString1, paramInt, paramString2, paramClass, false);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2, Class<? extends Activity> paramClass, boolean paramBoolean)
  {
    if ((TextUtils.equals("2290230341", paramString1)) && (QZoneMsgActivity.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      return;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if ((getIntent().hasExtra("qidian_chat")) && (getIntent().getBooleanExtra("qidian_chat", false)))
    {
      localIntent.setComponent(new ComponentName(this, SplashActivity.class));
      localBundle.putBoolean("open_chatfragment", true);
    }
    for (;;)
    {
      localBundle.putString("uin", paramString1);
      localBundle.putInt("uintype", paramInt);
      localBundle.putString("uinname", paramString2);
      localIntent.putExtras(localBundle);
      localIntent.setFlags(67108864);
      boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("need_finish", false);
      if (this.jdField_e_of_type_Boolean)
      {
        localIntent.putExtra("forward_type", -1);
        localIntent.putExtra("forward_text", this.jdField_f_of_type_JavaLangString);
        this.jdField_e_of_type_Boolean = false;
      }
      if (bool) {
        super.finish();
      }
      localIntent.putExtra("isforceRequestDetail", paramBoolean);
      localIntent.putExtra("jump_from", 2);
      super.startActivity(localIntent);
      return;
      localIntent.setComponent(new ComponentName(this, paramClass));
    }
  }
  
  protected boolean a()
  {
    akdi localakdi = (akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localakdi != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = localakdi.b(this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "loadCache = null");
      }
      return false;
    }
    w();
    return true;
  }
  
  public int[] a()
  {
    int[] arrayOfInt = new int[2];
    Display localDisplay = getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(localDisplay, new Object[] { localDisplayMetrics });
      arrayOfInt[0] = localDisplayMetrics.widthPixels;
      arrayOfInt[1] = localDisplayMetrics.heightPixels;
      return arrayOfInt;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return arrayOfInt;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int - 1;
  }
  
  Drawable b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {}
    do
    {
      return null;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor)) {
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor = "3d7fe3";
      }
      try
      {
        ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#E6" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.substring(0, 6)));
        return localColorDrawable;
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException) {}
    } while (!QLog.isColorLevel());
    QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "configBackgroundColor length is not 6!");
    return null;
  }
  
  public String b()
  {
    if (this.jdField_h_of_type_JavaLangString == null)
    {
      int i1 = sgj.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
      if ((i1 != -2) && (i1 != -5)) {
        break label84;
      }
    }
    label84:
    for (this.jdField_h_of_type_JavaLangString = ("https://share.mp.qq.com/cgi/share.php?uin=" + this.jdField_d_of_type_JavaLangString + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag + "&jumptype=1&card_type=public_account");; this.jdField_h_of_type_JavaLangString = ("https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=accountCard&puin=" + this.jdField_d_of_type_JavaLangString)) {
      return this.jdField_h_of_type_JavaLangString;
    }
  }
  
  protected void b(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView.postDelayed(new AccountDetailActivity.2(this, paramInt), 500L);
  }
  
  void b(Intent paramIntent)
  {
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("fromBrowser", false);
    this.jdField_h_of_type_Int = paramIntent.getIntExtra("source", 0);
    switch (this.jdField_h_of_type_Int)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "[fromwhere]:" + this.jdField_g_of_type_Int);
      }
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8005A24", "0X8005A24", this.jdField_g_of_type_Int, 0, "", "", "", "");
      return;
      this.jdField_g_of_type_Int = 2;
      continue;
      this.jdField_g_of_type_Int = 1;
      continue;
      this.jdField_g_of_type_Int = 0;
      continue;
      this.jdField_g_of_type_Int = 3;
      continue;
      this.jdField_g_of_type_Int = 4;
      continue;
      this.jdField_g_of_type_Int = 5;
      continue;
      this.jdField_g_of_type_Int = 6;
      continue;
      this.jdField_g_of_type_Int = 8;
      continue;
      this.jdField_g_of_type_Int = 9;
      continue;
      this.jdField_g_of_type_Int = 11;
      continue;
      this.jdField_g_of_type_Int = 50;
      continue;
      this.jdField_g_of_type_Int = 12;
      continue;
      this.jdField_g_of_type_Int = 13;
    }
  }
  
  void b(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "deleteAccount");
    }
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localaukn.b(paramAccountDetail);
    localaukn.a();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = new Intent(this, PublicAccountBrowser.class);
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
    paramString = paramString.replace("${puin}", this.jdField_d_of_type_JavaLangString).replace("${uin}", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("url", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "jumpWebView url=" + paramString);
    }
    localIntent.putExtra("puin", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("big_brother_source_key", sgj.b(this.jdField_d_of_type_JavaLangString));
    paramString = a();
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("source_name", paramString);
    }
    super.startActivity(localIntent);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected Drawable c()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    baxt localbaxt;
    do
    {
      return localObject;
      localObject = new File(bazo.a(this.jdField_d_of_type_JavaLangString));
      if (((File)localObject).isFile())
      {
        f(((File)localObject).getAbsolutePath());
        return baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 115, this.jdField_d_of_type_JavaLangString);
      }
      localbaxt = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 115, this.jdField_d_of_type_JavaLangString);
      localObject = localbaxt;
    } while (this.jdField_a_of_type_Nic != null);
    this.jdField_a_of_type_Nic = new nic(this);
    addObserver(this.jdField_a_of_type_Nic);
    return localbaxt;
  }
  
  void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bcpq != null)
    {
      this.jdField_a_of_type_Bcpq.c(paramInt);
      if (!this.jdField_a_of_type_Bcpq.isShowing()) {
        this.jdField_a_of_type_Bcpq.show();
      }
    }
  }
  
  public void c(Intent paramIntent)
  {
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("fromBrowser", false);
    this.jdField_h_of_type_Int = paramIntent.getIntExtra("source", 0);
    QQAppInterface localQQAppInterface;
    String str;
    int i1;
    switch (this.jdField_h_of_type_Int)
    {
    default: 
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_g_of_type_Int = 20;
      }
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "[fromwhere]:" + this.jdField_g_of_type_Int);
      }
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = this.jdField_d_of_type_JavaLangString;
      i1 = this.jdField_g_of_type_Int;
      if (!c()) {
        break;
      }
    }
    for (paramIntent = "02";; paramIntent = "01")
    {
      axqw.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str, "0X8007CA0", "0X8007CA0", i1, 0, paramIntent, String.valueOf(this.jdField_g_of_type_Int), String.valueOf(noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), "");
      return;
      this.jdField_g_of_type_Int = 11;
      break;
      this.jdField_g_of_type_Int = 12;
      break;
      this.jdField_g_of_type_Int = 13;
      break;
      this.jdField_g_of_type_Int = 14;
      break;
      this.jdField_g_of_type_Int = 15;
      break;
      this.jdField_g_of_type_Int = 16;
      break;
      this.jdField_g_of_type_Int = 17;
      break;
      this.jdField_g_of_type_Int = 18;
      break;
      this.jdField_g_of_type_Int = 19;
      break;
      this.jdField_g_of_type_Int = 21;
      break;
    }
  }
  
  void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams != null) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.c();
        Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.a();
        Object localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams.b();
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "";
        }
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = "";
        }
        localObject3 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject3 = "";
        }
        long l1 = System.currentTimeMillis();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject1).append(",").append("app").append(",").append((String)localObject2).append(",").append((String)localObject3).append(",").append(l1);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", paramString, paramString, 0, 1, 0, ((StringBuilder)localObject4).toString(), "", "", "");
      }
      return;
    }
  }
  
  protected boolean c()
  {
    int i1 = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType;
    }
    return i1 == 1;
  }
  
  protected void d()
  {
    N();
  }
  
  public void d(int paramInt)
  {
    Toast.makeText(getApplicationContext(), paramInt, 0).show();
  }
  
  protected void d(String paramString)
  {
    Dialog localDialog = new Dialog(this, 2131755791);
    localDialog.setContentView(2131560713);
    ((TextView)localDialog.findViewById(2131365185)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131365174);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131365172);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131365178);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690596);
    localTextView3.setText(2131691644);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new nhv(this, localDialog));
    localTextView3.setOnClickListener(new nhw(this, paramString));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public boolean d()
  {
    return (c()) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isShowFollowButton);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return super.dispatchTouchEvent(paramMotionEvent);
      } while (!this.jdField_g_of_type_Boolean);
      this.q = true;
      return true;
    } while (!this.q);
    this.q = false;
    return true;
  }
  
  public void doOnBackPressed()
  {
    int i1;
    int i2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams != null)
    {
      i1 = 1;
      if (this.jdField_i_of_type_Boolean) {
        break label138;
      }
      i2 = 1;
      label18:
      if ((i1 == 0) || (!this.jdField_i_of_type_Boolean)) {
        break label143;
      }
      moveTaskToBack(true);
    }
    for (;;)
    {
      if (!c()) {
        c("0X8005B6E");
      }
      if (getIntent().getBooleanExtra("from_newer_guide", false))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("has_operation", c());
        localIntent.putExtra("uin", this.jdField_d_of_type_JavaLangString);
        setResult(-1, localIntent);
      }
      if ((this.jdField_a_of_type_Ned != null) && (this.jdField_a_of_type_Ned.a() != null)) {
        this.jdField_a_of_type_Ned.a().b();
      }
      super.doOnBackPressed();
      return;
      i1 = 0;
      break;
      label138:
      i2 = 0;
      break label18;
      label143:
      if ((i1 != 0) && (i2 != 0) && (super.isTaskRoot())) {
        super.startActivity(new Intent(this, SplashActivity.class));
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new AccountDetailTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
    }
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    a(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_d_of_type_JavaLangString != null) {
      if ((getClass().equals(AccountDetailActivity.class)) && ((nbc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)) || (bdto.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString))))
      {
        nbc.a(this, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"), this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("need_finish", false), this.jdField_a_of_type_AndroidContentIntent.getIntExtra("source", -1), true, -1);
        finish();
      }
    }
    do
    {
      return true;
      F();
      c(this.jdField_a_of_type_AndroidContentIntent);
      super.addObserver(this.jdField_a_of_type_Akdo);
      this.n = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("from_js", false);
    } while (!this.n);
    D();
    finish();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_Akdo);
    super.removeObserver(this.jdField_b_of_type_Akws);
    super.removeObserver(this.jdField_c_of_type_Akws);
    super.removeObserver(this.jdField_a_of_type_Nic);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    long l1 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
    String str2 = this.jdField_d_of_type_JavaLangString;
    String str3 = l1 + "";
    if (c()) {}
    for (String str1 = "02";; str1 = "01")
    {
      noo.a(null, str2, "0X8007800", "0X8007800", 0, 0, str3, "", str1, String.valueOf(noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), false);
      if ((this.jdField_a_of_type_Ned != null) && (this.jdField_a_of_type_Ned.a() != null)) {
        this.jdField_a_of_type_Ned.a().b();
      }
      return;
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    a(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_d_of_type_JavaLangString != null) {
      F();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_i_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bcpq != null) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
    this.jdField_a_of_type_Bcpq = null;
    if ((this.jdField_a_of_type_Ned != null) && (this.jdField_a_of_type_Ned.a() != null)) {
      this.jdField_a_of_type_Ned.a().a();
    }
    AbstractGifImage.pauseAll();
  }
  
  public void e(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8005A27", "0X8005A27", 0, 0, paramString, "", "", "", false);
      return;
    }
  }
  
  protected boolean e()
  {
    akdi localakdi = (akdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localakdi != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = localakdi.a(this.jdField_d_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "loadDatabase = null");
      }
      return false;
    }
    w();
    return true;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      a(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, ChatActivity.class);
    }
  }
  
  void f(String paramString)
  {
    if ((this.s) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
      return;
    }
    this.s = true;
    ThreadManager.getSubThreadHandler().post(new AccountDetailActivity.32(this, paramString));
  }
  
  protected void g()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.20(this), 10L);
  }
  
  public void h()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.3(this), 10L);
  }
  
  public void i()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.6(this), 10L);
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateView");
    }
    this.jdField_l_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "isSubscriptAccount = " + this.jdField_l_of_type_Boolean);
    }
    if ((this.jdField_l_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
      nfh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_d_of_type_JavaLangString), this.jdField_a_of_type_Akdo);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse != null) && (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.show_flag.has()) && (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.show_flag.get() == 2)) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      I();
      return;
    }
    J();
    k();
    l();
  }
  
  protected void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (this.jdField_l_of_type_Boolean)) {}
    label272:
    for (;;)
    {
      return;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isShowFollowButton;
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {
        if ((this.jdField_d_of_type_JavaLangString.equals("1770946116")) || (nbc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)))
        {
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          if (!b()) {
            break label253;
          }
          this.jdField_e_of_type_AndroidViewView.setVisibility(0);
          this.jdField_f_of_type_AndroidViewView.setVisibility(0);
          this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
        }
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_AndroidWidgetButton.getVisibility() != 8) || (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8)) {
          break label272;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
        if (bool)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        }
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        break;
        label253:
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  protected void l()
  {
    if ((this.jdField_a_of_type_Ned == null) || (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() == null) || ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_Ned.a() == null)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() != null)
      {
        ((ned)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter()).a();
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      }
      this.jdField_a_of_type_Ned = new ned(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, this.jdField_d_of_type_JavaLangString, this.jdField_l_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      this.jdField_a_of_type_Ned.a(this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_d_of_type_AndroidWidgetButton);
      K();
      if (!this.jdField_l_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(false);
      }
      this.jdField_a_of_type_Ned.a(new nhs(this));
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_Ned);
      return;
    }
    K();
    this.jdField_a_of_type_Ned.notifyDataSetChanged();
  }
  
  protected void o()
  {
    bbfc.a(null, "pubAcc_follow_confirm", this.jdField_d_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow uin=" + this.jdField_d_of_type_JavaLangString);
    }
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidViewView.postDelayed(new AccountDetailActivity.7(this), 3000L);
    b(2131695543);
    if (sgj.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) == -4)
    {
      this.jdField_d_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), nou.class);
      this.jdField_d_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      localFollowRequest.ext.set("1");
      localFollowRequest.uin.set((int)Long.parseLong(this.jdField_d_of_type_JavaLangString));
      localFollowRequest.account_type.set(a());
      this.jdField_d_of_type_MqqAppNewIntent.putExtra("data", localFollowRequest.toByteArray());
      this.jdField_d_of_type_MqqAppNewIntent.putExtra("source", 1);
      this.jdField_b_of_type_MqqObserverBusinessObserver = new nia(this);
      this.jdField_d_of_type_MqqAppNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_d_of_type_MqqAppNewIntent);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int += 1;
      noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, 1);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow exit");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Akws);
      this.jdField_b_of_type_Akws = new akws(new nib(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Akws);
      akwx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, 1);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      v();
    }
    label819:
    do
    {
      return;
      String str;
      if ((paramView == this.jdField_b_of_type_AndroidViewView) || ((this.jdField_a_of_type_Ned != null) && (paramView == this.jdField_a_of_type_Ned.jdField_a_of_type_AndroidWidgetButton) && (!c())) || ((paramView == this.jdField_d_of_type_AndroidWidgetButton) && (!c())))
      {
        c("0X8005B6D");
        this.jdField_j_of_type_Boolean = false;
        o();
        H();
        this.jdField_b_of_type_AndroidViewView.setEnabled(false);
        this.jdField_b_of_type_AndroidViewView.postDelayed(new AccountDetailActivity.29(this), 1000L);
        if (sbc.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)) {
          ((nri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a(134243868, this.jdField_d_of_type_JavaLangString, null, null, null, 1L, false);
        }
        noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8005A25", "0X8005A25", this.jdField_g_of_type_Int, 0, "", "", "", "", false);
        sen.a().a(4, this.jdField_d_of_type_JavaLangString, 0, UniteSearchActivity.jdField_d_of_type_Int, awvr.a().a(this.jdField_d_of_type_JavaLangString));
        QQAppInterface localQQAppInterface1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_d_of_type_JavaLangString;
        if (c()) {
          paramView = "02";
        }
        for (;;)
        {
          axqw.b(localQQAppInterface1, "dc01160", "Pb_account_lifeservice", str, "0X8007CA1", "0X8007CA1", 0, 0, paramView, String.valueOf(this.jdField_g_of_type_Int), String.valueOf(noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), "");
          if (!ajsf.aR.equals(this.jdField_d_of_type_JavaLangString)) {
            break;
          }
          paramView = new JSONObject();
          try
          {
            paramView.put("channel_id", olm.b());
            noo.a(null, "", "0X8009946", "0X8009946", 0, 0, "", "", "", paramView.toString(), false);
            return;
            paramView = "01";
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, localException.getMessage());
            }
          }
        }
      }
      if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
      {
        int i1 = getIntent().getIntExtra("source", 0);
        if (onk.d(this.jdField_d_of_type_JavaLangString)) {
          z();
        }
        for (;;)
        {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8004E44", "0X8004E44", 0, 0, this.jdField_d_of_type_JavaLangString, "", "", "");
          noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8005A26", "0X8005A26", 0, 0, "", "", "", "", false);
          return;
          if (ajsf.aU.equals(this.jdField_d_of_type_JavaLangString))
          {
            sgj.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          else if (i1 == 120)
          {
            doOnBackPressed();
          }
          else if (TextUtils.equals(ajsf.aR, this.jdField_d_of_type_JavaLangString))
          {
            KandianDailyManager.a(this, true, null, 5);
            if (ajsf.aR.equals(this.jdField_d_of_type_JavaLangString)) {
              noo.a(null, "", "0X8009945", "0X8009945", 0, 0, "", "", "", "", false);
            }
          }
          else if ((TextUtils.equals("2747277822", this.jdField_d_of_type_JavaLangString)) && (aqss.a()))
          {
            A();
          }
          else if ((TextUtils.equals("3046055438", this.jdField_d_of_type_JavaLangString)) && (nrw.a()))
          {
            if ((getIntent() != null) && (getIntent().getBooleanExtra("from_tab", false))) {
              doOnBackPressed();
            } else {
              nrk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_d_of_type_JavaLangString, getResources().getString(2131691960));
            }
          }
          else
          {
            f();
          }
        }
      }
      if (paramView == this.jdField_f_of_type_AndroidViewView)
      {
        nbc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, a(), this.jdField_d_of_type_JavaLangString, "IvrEnterpriseDetailEngineFalse");
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004653", "0X8004653", 0, 0, "", "", "", "");
        return;
      }
      if (paramView == this.jdField_c_of_type_AndroidWidgetTextView)
      {
        doOnBackPressed();
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        QQAppInterface localQQAppInterface2;
        if (this.jdField_l_of_type_Boolean)
        {
          C();
          localQQAppInterface2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str = this.jdField_d_of_type_JavaLangString;
          if (!c()) {
            break label819;
          }
        }
        for (paramView = "02";; paramView = "01")
        {
          axqw.b(localQQAppInterface2, "dc01160", "Pb_account_lifeservice", str, "0X8007CA5", "0X8007CA5", 0, 0, paramView, String.valueOf(noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), "", "");
          return;
          B();
          break;
        }
      }
    } while (paramView != this.jdField_c_of_type_AndroidWidgetButton);
    G();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add("menu");
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_h_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bcpq != null) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
    this.jdField_a_of_type_Bcpq = null;
    if (this.jdField_a_of_type_Nic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Nic);
      this.jdField_a_of_type_Nic = null;
    }
    if (this.jdField_c_of_type_MqqAppNewIntent != null) {
      this.jdField_c_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_e_of_type_MqqAppNewIntent != null) {
      this.jdField_e_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_d_of_type_MqqAppNewIntent != null) {
      this.jdField_d_of_type_MqqAppNewIntent.setObserver(null);
    }
    if (this.jdField_a_of_type_Nid != null) {
      this.jdField_a_of_type_Nid.b();
    }
    if (this.jdField_a_of_type_Xnz != null) {
      this.jdField_a_of_type_Xnz.dismiss();
    }
    if (this.jdField_a_of_type_Ned != null) {
      this.jdField_a_of_type_Ned.a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a();
    }
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    if (isInMultiWindow())
    {
      bcpw.a(this, getString(2131695573), 0).a();
      finish();
      return;
    }
    if ((this.jdField_a_of_type_Ned != null) && (this.jdField_a_of_type_Ned.a() != null)) {
      this.jdField_a_of_type_Ned.a().a(true);
    }
    AbstractGifImage.resumeAll();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      bbfc.a("pubAcc_profile_display", null, this.jdField_d_of_type_JavaLangString);
      this.m = true;
      return;
    }
    this.m = false;
  }
  
  protected void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountData = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.toByteArray();
    }
  }
  
  public void q()
  {
    if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)) {
      return;
    }
    if (this.jdField_a_of_type_Xbl == null) {
      this.jdField_a_of_type_Xbl = new xbl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, a(), a(), b());
    }
    this.jdField_a_of_type_Xbl.a();
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_10", "pbshare_click");
  }
  
  void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "initView");
    }
    super.setContentView(2131558401);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    s();
    t();
    a();
    this.jdField_g_of_type_AndroidViewView = super.findViewById(2131372869);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      if (this.jdField_g_of_type_AndroidViewView != null) {
        this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365729));
      return;
      if (this.jdField_g_of_type_AndroidViewView != null) {
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  void s()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131369167));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    int i2;
    if (f()) {
      i2 = (int)(64.0F * this.jdField_a_of_type_Float);
    }
    for (int i1 = (int)(4.0F * this.jdField_a_of_type_Float);; i1 = (int)(25.0F * this.jdField_a_of_type_Float))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i2);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i1, 0, 0);
      this.jdField_e_of_type_Int = i2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.setTitleHeight(this.jdField_e_of_type_Int);
      }
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369166));
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368457));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368441));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843093);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697766));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367714));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367688));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364024));
      this.jdField_d_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131361855));
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      i2 = (int)(75.0F * this.jdField_a_of_type_Float);
    }
  }
  
  void t()
  {
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131361874);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_Int = this.jdField_d_of_type_AndroidViewView.getLayoutParams().height;
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131361839);
    this.jdField_f_of_type_AndroidViewView = super.findViewById(2131363818);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131366513);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131361840);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    super.setTitle(2131695535);
    this.jdField_a_of_type_Bcpq = new bcpq(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bcpq.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131375693));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131375850));
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131693776);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131378605));
    this.jdField_c_of_type_AndroidWidgetButton.setText(2131693777);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131361841);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_Ned.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_Ned);
    }
    this.jdField_a_of_type_Ned.jdField_d_of_type_Boolean = false;
  }
  
  void v()
  {
    super.finish();
    abtt.a(this, "");
  }
  
  protected void w()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.mergeFrom(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountData);
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.newGroupInfoList = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.config_group_info_new.get();
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.unified_account_descrpition.has())
      {
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.unifiedDesrpition = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse.unified_account_descrpition.get();
        this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.parser();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno = 0;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void x()
  {
    Object localObject;
    if (ajsf.aR.equals(this.jdField_d_of_type_JavaLangString)) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("channel_id", olm.b());
      noo.a(null, "", "0X8009944", "0X8009944", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      bbfc.a(null, " pubAcc_follow_cancel", this.jdField_d_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow");
      }
      b(2131695617);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (sgj.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) == -4))
      {
        if (this.jdField_e_of_type_MqqAppNewIntent != null) {
          this.jdField_e_of_type_MqqAppNewIntent.setObserver(null);
        }
        this.jdField_e_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), nou.class);
        this.jdField_e_of_type_MqqAppNewIntent.putExtra("cmd", "unfollow");
        localObject = new mobileqq_mp.UnFollowRequest();
        ((mobileqq_mp.UnFollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_d_of_type_JavaLangString));
        ((mobileqq_mp.UnFollowRequest)localObject).account_type.set(a());
        this.jdField_e_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject).toByteArray());
        this.jdField_e_of_type_MqqAppNewIntent.putExtra("source", 1);
        this.jdField_c_of_type_MqqObserverBusinessObserver = new nhy(this);
        this.jdField_e_of_type_MqqAppNewIntent.setObserver(this.jdField_c_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_e_of_type_MqqAppNewIntent);
        this.jdField_c_of_type_Int += 1;
        sgj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString);
        if (sbc.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString))
        {
          int i1 = sgj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString);
          ahpf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_d_of_type_JavaLangString), i1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow exit");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, localException.getMessage());
        continue;
        if (this.jdField_c_of_type_Akws != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_c_of_type_Akws);
        }
        this.jdField_c_of_type_Akws = new akws(new nhz(this));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_c_of_type_Akws);
        akwx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, 1);
        this.jdField_c_of_type_Int += 1;
      }
    }
  }
  
  public void y()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams != null) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        a(this);
      }
      return;
    }
  }
  
  protected void z()
  {
    sjs.a(this, "from_account_detail", 3, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity
 * JD-Core Version:    0.7.0.1
 */
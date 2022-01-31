package com.tencent.biz.pubaccount;

import abgi;
import abtp;
import ahpd;
import ajsd;
import ajya;
import akdh;
import akdn;
import akqw;
import aktf;
import akwr;
import akww;
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
import aqsu;
import aukp;
import aukq;
import awvt;
import axqy;
import axva;
import axwj;
import aydd;
import bayh;
import bbac;
import bbco;
import bbfj;
import bbfq;
import bbjq;
import bbjs;
import bbki;
import bcqf;
import bcql;
import bdik;
import bduf;
import bfpc;
import bfpp;
import bgqm;
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
import naz;
import nea;
import nfe;
import nfg;
import nhc;
import nhe;
import nhf;
import nhg;
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
import nms;
import nol;
import nor;
import nrf;
import nrh;
import nrt;
import olj;
import onh;
import org.json.JSONArray;
import org.json.JSONObject;
import saz;
import sek;
import sgg;
import shu;
import sjp;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import xbi;
import xbk;
import xnw;

public class AccountDetailActivity
  extends BaseActivity
  implements View.OnClickListener, nhc
{
  public static int i;
  public static int j;
  public static int k = 1;
  protected float a;
  long jdField_a_of_type_Long;
  final akdn jdField_a_of_type_Akdn = new nhe(this);
  public Intent a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new nhu(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  protected ImageView a;
  public RelativeLayout a;
  public bbjq a;
  bcqf jdField_a_of_type_Bcqf;
  public bfpc a;
  protected AccountDetailTopGestureLayout a;
  public AccountDetailXListView a;
  public ProfileParams a;
  public PublicAccountHandler a;
  public QQAppInterface a;
  public AccountDetail a;
  public mobileqq_mp.GetPublicAccountDetailInfoResponse a;
  protected BusinessObserver a;
  public nea a;
  nhz jdField_a_of_type_Nhz;
  nia jdField_a_of_type_Nia;
  public JSONObject a;
  protected xbi a;
  xnw jdField_a_of_type_Xnw;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  public int b;
  long jdField_b_of_type_Long;
  akwr jdField_b_of_type_Akwr;
  public View b;
  protected Button b;
  public ImageView b;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public bfpc b;
  public String b;
  protected BusinessObserver b;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  akwr jdField_c_of_type_Akwr;
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
    this.jdField_a_of_type_Bfpc = null;
    this.jdField_b_of_type_Bfpc = null;
    this.jdField_b_of_type_Int = 1008;
    this.jdField_d_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_l_of_type_Int = jdField_i_of_type_Int;
    this.jdField_a_of_type_AndroidOsHandler = new nhq(this);
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
      nol.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574C", "0X800574C", 0, 0, paramString, "", "", "", false);
      return;
    case 2: 
      nol.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574D", "0X800574D", 0, 0, paramString, "", "", "", false);
      return;
    case 3: 
      nol.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800574E", "0X800574E", 0, 0, paramString, "", "", "", false);
      return;
    }
    nol.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramString, "0X800589D", "0X800589D", 0, 0, paramString, "", "", "", false);
  }
  
  private void a(String paramString)
  {
    aktf localaktf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int i1 = sgg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString);
    if (i1 == 1024) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "setOrCancelTop pUin = " + paramString + " userType = " + i1 + " is UIN_TYPE_BUSINESS_CMR_TMP");
    }
    RecentUser localRecentUser = localaktf.b(paramString, i1);
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
      localaktf.a((RecentUser)localObject);
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
      shu.a(i1, paramString, bool);
      return;
      ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
      break;
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    long l1 = aydd.a().b();
    Object localObject = aydd.a().a(Long.valueOf(l1));
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
    int i1 = sgg.a(paramAccountDetail.accountFlag);
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
      if (sgg.a(paramAccountDetail.accountFlag2) != -8L) {
        bool1 = false;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int i1 = sgg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString);
    RecentUser localRecentUser = ((aktf)localObject).b(paramString, i1);
    localObject = localRecentUser;
    if (localRecentUser == null)
    {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 1, "isPublicAccoutMsgTabSetTop pUin = " + paramString + " userType = " + i1 + " not in the msglist");
      localObject = new RecentUser(this.jdField_d_of_type_JavaLangString, i1);
    }
    return ((RecentUser)localObject).showUpTime != 0L;
  }
  
  private List<bbjs>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new bbjs();
    ((bbjs)localObject).a = super.getString(2131696696);
    ((bbjs)localObject).jdField_b_of_type_Int = 2130838754;
    ((bbjs)localObject).jdField_b_of_type_Boolean = true;
    ((bbjs)localObject).jdField_c_of_type_Int = 2;
    ((bbjs)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new bbjs();
    ((bbjs)localObject).a = super.getString(2131696709);
    ((bbjs)localObject).jdField_b_of_type_Int = 2130838755;
    ((bbjs)localObject).jdField_b_of_type_Boolean = true;
    ((bbjs)localObject).jdField_c_of_type_Int = 3;
    ((bbjs)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new bbjs();
    ((bbjs)localObject).a = super.getString(2131696716);
    ((bbjs)localObject).jdField_b_of_type_Int = 2130838758;
    ((bbjs)localObject).jdField_c_of_type_Int = 9;
    ((bbjs)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new bbjs();
    ((bbjs)localObject).a = super.getString(2131696699);
    ((bbjs)localObject).jdField_b_of_type_Int = 2130838752;
    ((bbjs)localObject).jdField_c_of_type_Int = 10;
    ((bbjs)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    bduf.a(this, localArrayList);
    localObject = new ArrayList();
    if (d())
    {
      localbbjs = new bbjs();
      localbbjs.a = super.getString(2131695546);
      localbbjs.jdField_b_of_type_Int = 2130842133;
      localbbjs.jdField_b_of_type_Boolean = true;
      localbbjs.jdField_c_of_type_Int = 30;
      localbbjs.jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject).add(localbbjs);
    }
    bbjs localbbjs = new bbjs();
    localbbjs.a = super.getString(2131695607);
    localbbjs.jdField_b_of_type_Int = 2130842125;
    localbbjs.jdField_b_of_type_Boolean = true;
    localbbjs.jdField_c_of_type_Int = 31;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.a = super.getString(2131695588);
    localbbjs.jdField_b_of_type_Int = 2130842117;
    localbbjs.jdField_b_of_type_Boolean = true;
    localbbjs.jdField_c_of_type_Int = 11;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localbbjs);
    if (d())
    {
      localbbjs = new bbjs();
      localbbjs.a = super.getString(2131695617);
      localbbjs.jdField_b_of_type_Int = 2130842143;
      localbbjs.jdField_b_of_type_Boolean = true;
      localbbjs.jdField_c_of_type_Int = 32;
      localbbjs.jdField_b_of_type_JavaLangString = "";
      ((ArrayList)localObject).add(localbbjs);
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
    if (aqsu.b())
    {
      PublicFragmentActivityForTool.b(this, localIntent, QQGameFeedWebFragment.class, 10000);
      return;
    }
    PublicFragmentActivity.a(this, localIntent, QQGamePubAccountFragment.class, 10000);
  }
  
  protected void B()
  {
    this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.a(this, null));
    if ((this.jdField_d_of_type_JavaLangString.equals("1770946116")) || (naz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Bfpc.a(2131695609, 5);
      this.jdField_a_of_type_Bfpc.a(2131695588, 5);
      if (d()) {
        this.jdField_a_of_type_Bfpc.a(2131695617, 3);
      }
      this.jdField_a_of_type_Bfpc.c(2131690596);
      this.jdField_a_of_type_Bfpc.a(new nhg(this));
      this.jdField_a_of_type_Bfpc.setOnDismissListener(new nhh(this));
      if (!this.jdField_a_of_type_Bfpc.isShowing())
      {
        this.o = false;
        this.jdField_a_of_type_Bfpc.show();
      }
      return;
    }
    if (d()) {
      if ((saz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)) || (saz.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Bfpc.a(2131695609, 5);
        this.jdField_a_of_type_Bfpc.a(2131695588, 5);
        this.jdField_a_of_type_Bfpc.c(2131690596);
        this.jdField_a_of_type_Bfpc.a(new nhi(this));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfpc.setOnDismissListener(new nhm(this));
      if (this.jdField_a_of_type_Bfpc.isShowing()) {
        break;
      }
      this.o = false;
      this.jdField_a_of_type_Bfpc.show();
      return;
      if (saz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Bfpc.a(2131695609, 5);
        this.jdField_a_of_type_Bfpc.a(2131695588, 5);
        if (a(this.jdField_d_of_type_JavaLangString)) {
          this.jdField_a_of_type_Bfpc.a(2131695530, 5);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bfpc.c(2131690596);
          this.jdField_a_of_type_Bfpc.a(new nhj(this));
          break;
          this.jdField_a_of_type_Bfpc.a(2131695606, 5);
        }
      }
      this.jdField_a_of_type_Bfpc.a(2131695609, 5);
      this.jdField_a_of_type_Bfpc.a(2131695588, 5);
      if (d()) {
        this.jdField_a_of_type_Bfpc.a(2131695617, 3);
      }
      this.jdField_a_of_type_Bfpc.c(2131690596);
      this.jdField_a_of_type_Bfpc.a(new nhk(this));
      continue;
      this.jdField_a_of_type_Bfpc.a(2131695609, 5);
      this.jdField_a_of_type_Bfpc.a(2131695588, 5);
      this.jdField_a_of_type_Bfpc.c(2131690596);
      this.jdField_a_of_type_Bfpc.a(new nhl(this));
    }
  }
  
  protected void C()
  {
    if (this.jdField_a_of_type_Bbjq == null)
    {
      this.jdField_a_of_type_Bbjq = new bbjq(this);
      this.jdField_a_of_type_Bbjq.a(getString(2131719508));
      this.jdField_a_of_type_Bbjq.a(a());
      this.jdField_a_of_type_Bbjq.a(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_Bbjq.a();
        return;
        this.jdField_a_of_type_Bbjq.a(a());
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
    this.jdField_b_of_type_Bfpc = bfpc.a(this);
    String str = getString(2131695619, new Object[] { a() });
    this.jdField_b_of_type_Bfpc.a(str);
    this.jdField_b_of_type_Bfpc.a(2131696742, 3);
    this.jdField_b_of_type_Bfpc.c(2131690596);
    this.jdField_b_of_type_Bfpc.setOnDismissListener(new nhn(this));
    this.jdField_b_of_type_Bfpc.a(new nho(this));
    if (!this.jdField_b_of_type_Bfpc.isShowing())
    {
      this.p = false;
      this.jdField_b_of_type_Bfpc.show();
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
    this.jdField_d_of_type_AndroidWidgetButton.setText(2131695615);
    this.jdField_d_of_type_AndroidWidgetButton.setAlpha(0.5F);
    ThreadManager.getSubThreadHandler().postDelayed(new AccountDetailActivity.23(this), 0L);
  }
  
  void K()
  {
    this.jdField_a_of_type_Nea.a(a());
    this.jdField_a_of_type_Nea.b(b());
    this.jdField_a_of_type_Nea.c(c());
    this.jdField_a_of_type_Nea.a(this.jdField_l_of_type_Boolean);
    this.jdField_a_of_type_Nea.a(b());
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.jdField_a_of_type_Nea.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
  }
  
  public void L()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
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
    this.jdField_c_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), nor.class);
    this.jdField_c_of_type_MqqAppNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.3.0,3,4480");
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
        this.jdField_a_of_type_MqqObserverBusinessObserver = new nhr(this);
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
      if (bbfj.h(this)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateHDFace not wifi, so need't update");
    return;
    this.jdField_a_of_type_Nia = new nia(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Nia.a();
  }
  
  public void P()
  {
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "setHDFace uin is null");
      }
    }
    while (this.jdField_a_of_type_Nea == null) {
      return;
    }
    Drawable localDrawable = c();
    this.jdField_a_of_type_Nea.c(localDrawable);
    this.jdField_a_of_type_Nea.notifyDataSetChanged();
  }
  
  public int a()
  {
    return 1;
  }
  
  public akdn a()
  {
    return this.jdField_a_of_type_Akdn;
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
      bbki.a(paramBitmap, 1);
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
  
  protected List<nms> a(List<nms> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(2);
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      nms localnms = (nms)paramList.get(i1);
      if ((localnms.a == 3) && ((localnms.jdField_c_of_type_Int == 7) || (localnms.jdField_c_of_type_Int == 8))) {
        localArrayList.add(localnms);
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
        localJSONObject2.put("sign", bdik.b((String)localObject2 + paramString + 201 + str + "jubao@article@123").toLowerCase());
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
              ((JSONObject)localObject2).put("text", new String(axwj.a(bgqm.a(axva.a(((MessageRecord)localObject3).msgData).getXmlBytes()), 0), "utf-8"));
              i1 = 5;
              continue;
            }
          }
          else
          {
            ((JSONObject)localObject1).put("msgNum", "" + paramBaseActivity.size());
            ((JSONObject)localObject1).put("messageList", bbco.encodeToString(localJSONArray.toString().getBytes("utf-8"), 0));
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
  
  public xbk a()
  {
    xbk localxbk = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
    {
      localxbk = new xbk(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
      localxbk.jdField_c_of_type_Int = xbk.jdField_b_of_type_Int;
      localxbk.jdField_a_of_type_Boolean = c();
      localxbk.jdField_d_of_type_Int = nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
    return localxbk;
  }
  
  @TargetApi(9)
  protected void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView = ((AccountDetailXListView)super.findViewById(2131361824));
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
  
  public void a(abgi paramabgi)
  {
    if (paramabgi == null) {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateCurrentImage currentImage is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateCurrentImage uin=" + paramabgi.jdField_d_of_type_JavaLangString + ", state=" + paramabgi.a);
      }
    } while (paramabgi.a != 6);
    f(paramabgi.jdField_c_of_type_JavaLangString);
  }
  
  void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Xnw == null) {
      this.jdField_a_of_type_Xnw = new xnw(paramActivity);
    }
    this.jdField_a_of_type_Xnw.a(ajya.a(2131699749));
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131719421);
    str = str + ajya.a(2131699750);
    paramActivity = new nhf(this, paramActivity);
    this.jdField_a_of_type_Xnw.a(str, paramActivity);
    this.jdField_a_of_type_Xnw.a(paramActivity);
    this.jdField_a_of_type_Xnw.show();
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
      if (!((aukp)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        ((aukp)localObject).a(AccountDetail.class);
      }
    }
    for (;;)
    {
      ((aukp)localObject).a();
      localObject = (akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if ((localObject != null) && (paramAccountDetail != null))
      {
        ((akdh)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
        if (paramAccountDetail.followType == 1) {
          ((akdh)localObject).a(PublicAccountInfo.createPublicAccount(paramAccountDetail, 0L));
        }
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
      ((aukp)localObject).a(paramAccountDetail);
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
      nfe.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_d_of_type_JavaLangString), this.jdField_a_of_type_Akdn);
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
    akdh localakdh = (akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localakdh != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = localakdh.b(this.jdField_d_of_type_JavaLangString);
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
      int i1 = sgg.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
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
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8005A24", "0X8005A24", this.jdField_g_of_type_Int, 0, "", "", "", "");
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
    aukp localaukp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localaukp.b(paramAccountDetail);
    localaukp.a();
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
    localIntent.putExtra("big_brother_source_key", sgg.b(this.jdField_d_of_type_JavaLangString));
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
    bayh localbayh;
    do
    {
      return localObject;
      localObject = new File(bbac.a(this.jdField_d_of_type_JavaLangString));
      if (((File)localObject).isFile())
      {
        f(((File)localObject).getAbsolutePath());
        return bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 115, this.jdField_d_of_type_JavaLangString);
      }
      localbayh = bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 115, this.jdField_d_of_type_JavaLangString);
      localObject = localbayh;
    } while (this.jdField_a_of_type_Nhz != null);
    this.jdField_a_of_type_Nhz = new nhz(this);
    addObserver(this.jdField_a_of_type_Nhz);
    return localbayh;
  }
  
  void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bcqf != null)
    {
      this.jdField_a_of_type_Bcqf.c(paramInt);
      if (!this.jdField_a_of_type_Bcqf.isShowing()) {
        this.jdField_a_of_type_Bcqf.show();
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
      axqy.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str, "0X8007CA0", "0X8007CA0", i1, 0, paramIntent, String.valueOf(this.jdField_g_of_type_Int), String.valueOf(nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), "");
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
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", paramString, paramString, 0, 1, 0, ((StringBuilder)localObject4).toString(), "", "", "");
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
    localDialog.setContentView(2131560712);
    ((TextView)localDialog.findViewById(2131365184)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131365173);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131365171);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131365177);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    localTextView2.setText(2131690596);
    localTextView3.setText(2131691644);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new nhs(this, localDialog));
    localTextView3.setOnClickListener(new nht(this, paramString));
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
      if ((this.jdField_a_of_type_Nea != null) && (this.jdField_a_of_type_Nea.a() != null)) {
        this.jdField_a_of_type_Nea.a().b();
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
      if ((getClass().equals(AccountDetailActivity.class)) && ((naz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)) || (bduf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString))))
      {
        naz.a(this, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"), this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("need_finish", false), this.jdField_a_of_type_AndroidContentIntent.getIntExtra("source", -1), true, -1);
        finish();
      }
    }
    do
    {
      return true;
      F();
      c(this.jdField_a_of_type_AndroidContentIntent);
      super.addObserver(this.jdField_a_of_type_Akdn);
      this.n = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("from_js", false);
    } while (!this.n);
    D();
    finish();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_Akdn);
    super.removeObserver(this.jdField_b_of_type_Akwr);
    super.removeObserver(this.jdField_c_of_type_Akwr);
    super.removeObserver(this.jdField_a_of_type_Nhz);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    long l1 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
    String str2 = this.jdField_d_of_type_JavaLangString;
    String str3 = l1 + "";
    if (c()) {}
    for (String str1 = "02";; str1 = "01")
    {
      nol.a(null, str2, "0X8007800", "0X8007800", 0, 0, str3, "", str1, String.valueOf(nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), false);
      if ((this.jdField_a_of_type_Nea != null) && (this.jdField_a_of_type_Nea.a() != null)) {
        this.jdField_a_of_type_Nea.a().b();
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
    if (this.jdField_a_of_type_Bcqf != null) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
    this.jdField_a_of_type_Bcqf = null;
    if ((this.jdField_a_of_type_Nea != null) && (this.jdField_a_of_type_Nea.a() != null)) {
      this.jdField_a_of_type_Nea.a().a();
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
      nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8005A27", "0X8005A27", 0, 0, paramString, "", "", "", false);
      return;
    }
  }
  
  protected boolean e()
  {
    akdh localakdh = (akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localakdh != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = localakdh.a(this.jdField_d_of_type_JavaLangString);
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
      nfe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_d_of_type_JavaLangString), this.jdField_a_of_type_Akdn);
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
        if ((this.jdField_d_of_type_JavaLangString.equals("1770946116")) || (naz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)))
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
    if ((this.jdField_a_of_type_Nea == null) || (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() == null) || ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_Nea.a() == null)))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter() != null)
      {
        ((nea)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getAdapter()).a();
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      }
      this.jdField_a_of_type_Nea = new nea(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, this.jdField_d_of_type_JavaLangString, this.jdField_l_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      this.jdField_a_of_type_Nea.a(this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_d_of_type_AndroidWidgetImageView, this.jdField_d_of_type_AndroidWidgetButton);
      K();
      if (!this.jdField_l_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(false);
      }
      this.jdField_a_of_type_Nea.a(new nhp(this));
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_Nea);
      return;
    }
    K();
    this.jdField_a_of_type_Nea.notifyDataSetChanged();
  }
  
  protected void o()
  {
    bbfq.a(null, "pubAcc_follow_confirm", this.jdField_d_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow uin=" + this.jdField_d_of_type_JavaLangString);
    }
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidViewView.postDelayed(new AccountDetailActivity.7(this), 3000L);
    b(2131695544);
    if (sgg.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) == -4)
    {
      this.jdField_d_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), nor.class);
      this.jdField_d_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      localFollowRequest.ext.set("1");
      localFollowRequest.uin.set((int)Long.parseLong(this.jdField_d_of_type_JavaLangString));
      localFollowRequest.account_type.set(a());
      this.jdField_d_of_type_MqqAppNewIntent.putExtra("data", localFollowRequest.toByteArray());
      this.jdField_d_of_type_MqqAppNewIntent.putExtra("source", 1);
      this.jdField_b_of_type_MqqObserverBusinessObserver = new nhx(this);
      this.jdField_d_of_type_MqqAppNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_d_of_type_MqqAppNewIntent);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int += 1;
      nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, 1);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "follow exit");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_b_of_type_Akwr);
      this.jdField_b_of_type_Akwr = new akwr(new nhy(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_b_of_type_Akwr);
      akww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, 1);
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
      if ((paramView == this.jdField_b_of_type_AndroidViewView) || ((this.jdField_a_of_type_Nea != null) && (paramView == this.jdField_a_of_type_Nea.jdField_a_of_type_AndroidWidgetButton) && (!c())) || ((paramView == this.jdField_d_of_type_AndroidWidgetButton) && (!c())))
      {
        c("0X8005B6D");
        this.jdField_j_of_type_Boolean = false;
        o();
        H();
        this.jdField_b_of_type_AndroidViewView.setEnabled(false);
        this.jdField_b_of_type_AndroidViewView.postDelayed(new AccountDetailActivity.29(this), 1000L);
        if (saz.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString)) {
          ((nrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a(134243868, this.jdField_d_of_type_JavaLangString, null, null, null, 1L, false);
        }
        nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8005A25", "0X8005A25", this.jdField_g_of_type_Int, 0, "", "", "", "", false);
        sek.a().a(4, this.jdField_d_of_type_JavaLangString, 0, UniteSearchActivity.jdField_d_of_type_Int, awvt.a().a(this.jdField_d_of_type_JavaLangString));
        QQAppInterface localQQAppInterface1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_d_of_type_JavaLangString;
        if (c()) {
          paramView = "02";
        }
        for (;;)
        {
          axqy.b(localQQAppInterface1, "dc01160", "Pb_account_lifeservice", str, "0X8007CA1", "0X8007CA1", 0, 0, paramView, String.valueOf(this.jdField_g_of_type_Int), String.valueOf(nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), "");
          if (!ajsd.aR.equals(this.jdField_d_of_type_JavaLangString)) {
            break;
          }
          paramView = new JSONObject();
          try
          {
            paramView.put("channel_id", olj.b());
            nol.a(null, "", "0X8009946", "0X8009946", 0, 0, "", "", "", paramView.toString(), false);
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
        if (onh.d(this.jdField_d_of_type_JavaLangString)) {
          z();
        }
        for (;;)
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8004E44", "0X8004E44", 0, 0, this.jdField_d_of_type_JavaLangString, "", "", "");
          nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_d_of_type_JavaLangString, "0X8005A26", "0X8005A26", 0, 0, "", "", "", "", false);
          return;
          if (ajsd.aU.equals(this.jdField_d_of_type_JavaLangString))
          {
            sgg.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          else if (i1 == 120)
          {
            doOnBackPressed();
          }
          else if (TextUtils.equals(ajsd.aR, this.jdField_d_of_type_JavaLangString))
          {
            KandianDailyManager.a(this, true, null, 5);
            if (ajsd.aR.equals(this.jdField_d_of_type_JavaLangString)) {
              nol.a(null, "", "0X8009945", "0X8009945", 0, 0, "", "", "", "", false);
            }
          }
          else if ((TextUtils.equals("2747277822", this.jdField_d_of_type_JavaLangString)) && (aqsu.a()))
          {
            A();
          }
          else if ((TextUtils.equals("3046055438", this.jdField_d_of_type_JavaLangString)) && (nrt.a()))
          {
            if ((getIntent() != null) && (getIntent().getBooleanExtra("from_tab", false))) {
              doOnBackPressed();
            } else {
              nrh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_d_of_type_JavaLangString, getResources().getString(2131691960));
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
        naz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, a(), this.jdField_d_of_type_JavaLangString, "IvrEnterpriseDetailEngineFalse");
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004653", "0X8004653", 0, 0, "", "", "", "");
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
          axqy.b(localQQAppInterface2, "dc01160", "Pb_account_lifeservice", str, "0X8007CA5", "0X8007CA5", 0, 0, paramView, String.valueOf(nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)), "", "");
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
    if (this.jdField_a_of_type_Bcqf != null) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
    this.jdField_a_of_type_Bcqf = null;
    if (this.jdField_a_of_type_Nhz != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Nhz);
      this.jdField_a_of_type_Nhz = null;
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
    if (this.jdField_a_of_type_Nia != null) {
      this.jdField_a_of_type_Nia.b();
    }
    if (this.jdField_a_of_type_Xnw != null) {
      this.jdField_a_of_type_Xnw.dismiss();
    }
    if (this.jdField_a_of_type_Nea != null) {
      this.jdField_a_of_type_Nea.a();
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
      bcql.a(this, getString(2131695574), 0).a();
      finish();
      return;
    }
    if ((this.jdField_a_of_type_Nea != null) && (this.jdField_a_of_type_Nea.a() != null)) {
      this.jdField_a_of_type_Nea.a().a(true);
    }
    AbstractGifImage.resumeAll();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      bbfq.a("pubAcc_profile_display", null, this.jdField_d_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_Xbi == null) {
      this.jdField_a_of_type_Xbi = new xbi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, a(), a(), b());
    }
    this.jdField_a_of_type_Xbi.a();
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
    this.jdField_g_of_type_AndroidViewView = super.findViewById(2131372871);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      if (this.jdField_g_of_type_AndroidViewView != null) {
        this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365728));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843094);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131697776));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367714));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367688));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131364023));
      this.jdField_d_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131361854));
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      i2 = (int)(75.0F * this.jdField_a_of_type_Float);
    }
  }
  
  void t()
  {
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131361873);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_Int = this.jdField_d_of_type_AndroidViewView.getLayoutParams().height;
    this.jdField_e_of_type_AndroidViewView = super.findViewById(2131361838);
    this.jdField_f_of_type_AndroidViewView = super.findViewById(2131363817);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131366513);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131361839);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    super.setTitle(2131695536);
    this.jdField_a_of_type_Bcqf = new bcqf(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bcqf.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131375695));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131375852));
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131693777);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131378610));
    this.jdField_c_of_type_AndroidWidgetButton.setText(2131693778);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131361840);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_Nea.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_Nea);
    }
    this.jdField_a_of_type_Nea.jdField_d_of_type_Boolean = false;
  }
  
  void v()
  {
    super.finish();
    abtp.a(this, "");
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
    if (ajsd.aR.equals(this.jdField_d_of_type_JavaLangString)) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("channel_id", olj.b());
      nol.a(null, "", "0X8009944", "0X8009944", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      bbfq.a(null, " pubAcc_follow_cancel", this.jdField_d_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "unfollow");
      }
      b(2131695618);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (sgg.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag) == -4))
      {
        if (this.jdField_e_of_type_MqqAppNewIntent != null) {
          this.jdField_e_of_type_MqqAppNewIntent.setObserver(null);
        }
        this.jdField_e_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), nor.class);
        this.jdField_e_of_type_MqqAppNewIntent.putExtra("cmd", "unfollow");
        localObject = new mobileqq_mp.UnFollowRequest();
        ((mobileqq_mp.UnFollowRequest)localObject).uin.set((int)Long.parseLong(this.jdField_d_of_type_JavaLangString));
        ((mobileqq_mp.UnFollowRequest)localObject).account_type.set(a());
        this.jdField_e_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.UnFollowRequest)localObject).toByteArray());
        this.jdField_e_of_type_MqqAppNewIntent.putExtra("source", 1);
        this.jdField_c_of_type_MqqObserverBusinessObserver = new nhv(this);
        this.jdField_e_of_type_MqqAppNewIntent.setObserver(this.jdField_c_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_e_of_type_MqqAppNewIntent);
        this.jdField_c_of_type_Int += 1;
        sgg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString);
        if (saz.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString))
        {
          int i1 = sgg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString);
          ahpd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_d_of_type_JavaLangString), i1);
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
        if (this.jdField_c_of_type_Akwr != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_c_of_type_Akwr);
        }
        this.jdField_c_of_type_Akwr = new akwr(new nhw(this));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_c_of_type_Akwr);
        akww.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, 1);
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
    sjp.a(this, "from_account_detail", 3, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetailActivity
 * JD-Core Version:    0.7.0.1
 */
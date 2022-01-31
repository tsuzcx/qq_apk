package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import SummaryCardTaf.SSummaryCardRsp;
import abqv;
import acue;
import acuh;
import acuk;
import acul;
import acum;
import acun;
import acuo;
import acup;
import acuq;
import acur;
import acus;
import acut;
import acuu;
import acuv;
import acuw;
import acux;
import acuy;
import acuz;
import acva;
import acvb;
import acvc;
import acvg;
import acvn;
import acvo;
import acvq;
import acvr;
import acvs;
import acvt;
import acvu;
import acvv;
import acvw;
import acvx;
import acvy;
import acvz;
import acwa;
import acwb;
import acwc;
import acwd;
import acwe;
import acwf;
import acwg;
import acwh;
import acwi;
import acwj;
import acwn;
import acwo;
import acxw;
import acxy;
import aekt;
import aikl;
import alkv;
import allb;
import alox;
import aloz;
import alpo;
import alqx;
import alrh;
import alxl;
import alxo;
import alzf;
import amab;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LightingColorFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anuj;
import anvv;
import aoqg;
import aorb;
import aorc;
import aorj;
import aork;
import apek;
import apwv;
import apwx;
import apxc;
import aqcx;
import aqcz;
import aqdo;
import arsj;
import asar;
import asnx;
import asor;
import asot;
import atvt;
import aubm;
import auri;
import auru;
import avoo;
import avqr;
import awbw;
import awbx;
import awdn;
import awki;
import awkn;
import awku;
import awlp;
import awlr;
import awmk;
import awml;
import awmr;
import awsp;
import awvt;
import awwg;
import awwo;
import axho;
import azib;
import azmj;
import azmz;
import aznh;
import azwu;
import bcun;
import bcuo;
import bcup;
import bcwc;
import bcyw;
import bdah;
import bdal;
import bdbt;
import bdcd;
import bdda;
import bdee;
import bdfq;
import bdia;
import bdje;
import bdjk;
import bdke;
import bdox;
import bdqa;
import bdqf;
import bdrg;
import bdri;
import bdrw;
import bdwk;
import bena;
import beox;
import beoy;
import bepp;
import bfua;
import bhoh;
import bhos;
import bhow;
import bhpo;
import bhpy;
import bhql;
import bhum;
import bhyk;
import bhyu;
import bizg;
import bizm;
import bizt;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.apollo.FriendCardApolloViewController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.diy.DiyTextView;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfilePhotoView;
import com.tencent.mobileqq.profile.view.ProfileQVipDiyView;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profile.view.ShakeImageView;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.PerfRelativeLayout;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.Pair;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.CoverCacheData;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import ndv;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import uht;
import yxc;
import zcp;

public class FriendProfileCardActivity
  extends ProfileActivity
  implements acxy, awku, bhyk, TopGestureLayout.OnGestureListener, IEventReceiver, Observer
{
  public static long a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static AtomicInteger a;
  public static String f;
  public static String g;
  static long jdField_i_of_type_Long;
  public static long j;
  byte jdField_a_of_type_Byte;
  public int a;
  private acwo jdField_a_of_type_Acwo;
  public acxw a;
  protected aikl a;
  allb jdField_a_of_type_Allb = new acuh(this);
  alox jdField_a_of_type_Alox = new acum(this);
  private alxo jdField_a_of_type_Alxo = new acvo(this);
  protected amab a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new acux(this);
  public DialogInterface.OnClickListener a;
  public Intent a;
  public Bitmap a;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  public Uri a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new acvx(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new acvg(this);
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new acvc(this);
  public View a;
  public ViewGroup a;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new acwa(this);
  public FrameLayout a;
  public ImageView a;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public TextView a;
  apxc jdField_a_of_type_Apxc = new acuq(this);
  asar jdField_a_of_type_Asar = new acwe(this);
  asor jdField_a_of_type_Asor = new asor("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.a());
  public asot a;
  avqr jdField_a_of_type_Avqr = new acun(this);
  awdn jdField_a_of_type_Awdn = new acul(this);
  awkn jdField_a_of_type_Awkn;
  awlr jdField_a_of_type_Awlr = new acue(this);
  public awmk a;
  protected bdfq a;
  public bdjk a;
  private bdri jdField_a_of_type_Bdri = new acvn(this);
  public bena a;
  public beox a;
  private beoy jdField_a_of_type_Beoy = new acwj(this);
  public bepp a;
  public bhow a;
  bhpo jdField_a_of_type_Bhpo = new acwg(this);
  public bhpy a;
  bhum jdField_a_of_type_Bhum = new acwf(this);
  public FriendProfileCardActivity.ColorScreenLoader a;
  public ProfileActivity.CardContactInfo a;
  private FriendCardApolloViewController jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController;
  public DiniFlyAnimationView a;
  public ProfileShoppingPhotoInfo a;
  public DiyTextView a;
  public ProfileHeaderView a;
  public ShakeImageView a;
  public SingleTouchLayout a;
  public RedTouch a;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new acvu(this);
  public ProfileCardMoreInfoView a;
  public BusinessInfoCheckUpdate.AppInfo a;
  public PullToZoomHeaderListView a;
  public ImmersiveTitleBar2 a;
  Runnable jdField_a_of_type_JavaLangRunnable = new FriendProfileCardActivity.9(this);
  public String a;
  public ArrayDeque<Message> a;
  public ArrayList<Integer> a;
  protected List<Subscriber> a;
  private Vector<Drawable> jdField_a_of_type_JavaUtilVector = new Vector();
  public AtomicBoolean a;
  private yxc jdField_a_of_type_Yxc;
  public zcp a;
  boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  public String[] a;
  public int b;
  long jdField_b_of_type_Long = 0L;
  allb jdField_b_of_type_Allb = new acuk(this);
  private Dialog jdField_b_of_type_AndroidAppDialog;
  public DialogInterface.OnClickListener b;
  protected Intent b;
  public Bitmap b;
  Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new acvy(this);
  View jdField_b_of_type_AndroidViewView;
  private AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  public ImageView b;
  public TextView b;
  private apxc jdField_b_of_type_Apxc;
  private bepp jdField_b_of_type_Bepp;
  public bhow b;
  public ShakeImageView b;
  public RedTouch b;
  public Runnable b;
  public String b;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  public long c;
  private Dialog jdField_c_of_type_AndroidAppDialog;
  Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  public View c;
  public ImageView c;
  public TextView c;
  public String c;
  private AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean c;
  public int d;
  public long d;
  public View d;
  public TextView d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public View e;
  private TextView e;
  public String e;
  public boolean e;
  public int f;
  long jdField_f_of_type_Long;
  View jdField_f_of_type_AndroidViewView;
  public boolean f;
  public int g;
  long jdField_g_of_type_Long;
  private View jdField_g_of_type_AndroidViewView;
  protected boolean g;
  public int h;
  long jdField_h_of_type_Long;
  protected String h;
  boolean jdField_h_of_type_Boolean = false;
  int jdField_i_of_type_Int = 0;
  String jdField_i_of_type_JavaLangString = null;
  boolean jdField_i_of_type_Boolean;
  public int j;
  private String j;
  protected boolean j;
  private int jdField_k_of_type_Int;
  long jdField_k_of_type_Long;
  public boolean k;
  private int l;
  public boolean l;
  private int jdField_m_of_type_Int;
  private long jdField_m_of_type_Long = -1L;
  public boolean m;
  private volatile long n;
  public boolean n;
  public boolean o;
  protected boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  
  static
  {
    jdField_f_of_type_JavaLangString = "http://office.qq.com";
    jdField_g_of_type_JavaLangString = "http://www.qq.com";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_j_of_type_Long = 2000L;
  }
  
  public FriendProfileCardActivity()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Awmk = new awmk();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayDeque = new ArrayDeque();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "is_binding_shop";
    this.jdField_b_of_type_AndroidContentIntent = new Intent();
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_n_of_type_Long = -1L;
    this.jdField_a_of_type_Amab = new acvb(this);
    this.jdField_a_of_type_Asot = new asot("profile_card", "com.tencent.mobileqq:tool");
    this.jdField_n_of_type_Boolean = false;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_j_of_type_Int = 30000;
    this.jdField_b_of_type_JavaLangRunnable = new FriendProfileCardActivity.50(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new acwc(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new acwd(this);
    this.jdField_a_of_type_Zcp = null;
  }
  
  private void L()
  {
    if (this.jdField_a_of_type_Yxc == null) {
      this.jdField_a_of_type_Yxc = new yxc(this);
    }
  }
  
  private void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "clearBGCache size = " + this.jdField_a_of_type_JavaUtilVector.size());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
    while (localIterator.hasNext())
    {
      Drawable localDrawable = (Drawable)localIterator.next();
      if ((localDrawable instanceof FriendProfileCardBgDrawable)) {
        ((FriendProfileCardBgDrawable)localDrawable).a();
      } else if (bdrw.a(localDrawable)) {
        bdrw.a().a(localDrawable);
      }
    }
    this.jdField_a_of_type_JavaUtilVector.clear();
  }
  
  private void N()
  {
    String str;
    if (this.jdField_a_of_type_Yxc != null) {
      str = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      try
      {
        Long.parseLong(str);
        if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          break label110;
        }
        if (!this.app.getCurrentAccountUin().equals(str)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FriendProfileCardActivity", 2, "requestWeiShiPanelInfo failed getLong, uin = " + str);
        return;
      }
      this.jdField_a_of_type_Yxc.a(bool, str);
      this.jdField_a_of_type_Yxc.c();
      return;
      boolean bool = false;
      continue;
      label110:
      bool = true;
    }
  }
  
  private void O()
  {
    if ((this.jdField_a_of_type_Awmk == null) || (!this.jdField_a_of_type_Awmk.jdField_b_of_type_Boolean) || (!bdee.g(this))) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
          Object localObject = (TroopManager)this.app.getManager(52);
          alzf localalzf = (alzf)this.app.a(20);
          localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_Awmk.jdField_a_of_type_JavaLangString);
          a((TroopInfo)localObject);
          if (localObject != null)
          {
            localalzf.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_JavaLangString, ((TroopInfo)localObject).troopcode, localArrayList);
            localalzf.a(Long.parseLong(this.jdField_a_of_type_Awmk.jdField_a_of_type_JavaLangString), Long.parseLong(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.uin));
            if (!TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_Awmk.jdField_a_of_type_JavaLangString))
            {
              localalzf.d(Long.parseLong(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.uin));
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("FriendProfileCardActivity", 2, "loadTroopMemberCard:" + localException.toString());
  }
  
  private void P()
  {
    Object localObject = anvv.a(this.app, this.jdField_a_of_type_Awmk);
    localObject = bcyw.a(new Intent(this, ProfileCardMoreActivity.class), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, (BusinessCard)localObject);
    if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_Bcuo != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_Bcuo.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_Bcuo.jdField_a_of_type_JavaUtilList.size() > 0)) {
      ((Intent)localObject).putExtra("SHARE_NICK_NAME", ((bcun)this.jdField_a_of_type_Awmk.jdField_a_of_type_Bcuo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName))) {
      ((Intent)localObject).putExtra("cur_add_source", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.addSrcName);
    }
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      ((Intent)localObject).putExtra("key_nick_name", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.strNick);
    }
    ((Intent)localObject).addFlags(536870912);
    startActivityForResult((Intent)localObject, 1012);
    azmj.b(this.app, "CliOper", "", "", "0X8006A8A", "0X8006A8A", 0, 0, "", "", "", "");
  }
  
  private void Q()
  {
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96)
    {
      if (b()) {
        azmj.b(null, "dc00898", "", "", "kuolie", "0X80097DA", 2, 0, "", "", "", "");
      }
      while (h()) {
        return;
      }
    }
    a(this.app, this, this.jdField_a_of_type_Awmk, this.jdField_a_of_type_AndroidAppDialog);
  }
  
  private void R()
  {
    Intent localIntent = aekt.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    Object localObject = (aloz)this.app.getManager(51);
    if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) || ((localObject != null) && (((aloz)localObject).b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))))
    {
      localIntent.putExtra("uintype", 0);
      String str = bdbt.f(this.app, this.jdField_a_of_type_Awmk.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
      }
      localIntent.putExtra("uinname", (String)localObject);
      localIntent.putExtra("troop_code", this.jdField_a_of_type_Awmk.jdField_a_of_type_JavaLangString);
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject == null) {
        break label242;
      }
      ((TroopManager)localObject).a(this.jdField_a_of_type_Awmk.jdField_a_of_type_JavaLangString, new acvw(this, localIntent));
    }
    label242:
    while (!QLog.isColorLevel())
    {
      return;
      localIntent.putExtra("uintype", 1000);
      break;
    }
    QLog.e("FriendProfileCardActivity", 2, "enterChatByTroopMember, troopManager is null");
  }
  
  private void S()
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView = bdia.a(this, (PerfRelativeLayout)this.jdField_e_of_type_AndroidViewView);
  }
  
  private void T()
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView != null)
    {
      ((PerfRelativeLayout)this.jdField_e_of_type_AndroidViewView).removeView(this.jdField_e_of_type_AndroidWidgetTextView);
      this.jdField_e_of_type_AndroidWidgetTextView = null;
      bdwk.b(this.app, "hide_diy_template_guide", true);
    }
  }
  
  private void U()
  {
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      Object localObject = "loginwelcome_" + this.app.c();
      localObject = getApplication().getSharedPreferences((String)localObject, 0);
      boolean bool = ((SharedPreferences)localObject).getBoolean("first_device", false);
      int i1 = ((SharedPreferences)localObject).getInt("bubble_tips_time", 0);
      if ((bool) && (i1 < 3))
      {
        TextView localTextView = new TextView(this);
        localTextView.setId(2131372287);
        localTextView.setBackgroundResource(2130844609);
        localTextView.setIncludeFontPadding(false);
        localTextView.setClickable(false);
        localTextView.setText(alpo.a(2131705296));
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 16.0F);
        int i2 = aekt.a(7.0F, getResources());
        int i3 = aekt.a(7.0F, getResources());
        localTextView.setPadding(i2, aekt.a(7.0F, getResources()), i3, aekt.a(13.0F, getResources()));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(2, 2131372286);
        localLayoutParams.rightMargin = aekt.a(15.0F, getResources());
        localLayoutParams.bottomMargin = aekt.a(-1.0F, getResources());
        ((PerfRelativeLayout)this.jdField_e_of_type_AndroidViewView).addView(localTextView, localLayoutParams);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putInt("bubble_tips_time", i1 + 1);
        ((SharedPreferences.Editor)localObject).commit();
        azmj.b(this.app, "dc00898", "", "", "0X80081C0", "0X80081C0", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void V()
  {
    Object localObject1 = this.jdField_a_of_type_Awmk.jdField_a_of_type_Bcuo;
    String str2 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[0];
    Object localObject2 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[1];
    Object localObject3 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[4];
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("showEditNickActionSheet, nickName: %s, troopNick: %s, remark: %s", new Object[] { str2, localObject2, localObject3 }));
    }
    String str1 = "";
    int i1;
    boolean bool;
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      if (this.jdField_a_of_type_Awmk.jdField_b_of_type_Boolean)
      {
        localObject1 = getResources().getString(2131693550);
        azmj.b(this.app, "dc00898", "", "", "0X800999A", "0X800999A", 3, 0, "", "", "", "");
        i1 = 3;
        bool = true;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = (bhpy)bhql.a(this, null);
        ((bhpy)localObject3).a((CharSequence)localObject1, 1);
        ((bhpy)localObject3).c(2131690648);
        ((bhpy)localObject3).a(new acwi(this, (String)localObject1, (String)localObject2, i1, bool, (bhpy)localObject3));
        ((bhpy)localObject3).show();
      }
      return;
      localObject1 = getResources().getString(2131693549);
      azmj.b(this.app, "dc00898", "", "", "0X800999A", "0X800999A", 1, 0, "", "", "", "");
      localObject2 = str2;
      i1 = 1;
      bool = false;
      continue;
      if (this.jdField_a_of_type_Awmk.jdField_b_of_type_Boolean)
      {
        localObject1 = ((TroopManager)this.app.getManager(52)).c(this.jdField_a_of_type_Awmk.jdField_a_of_type_JavaLangString);
        if ((localObject1 != null) && ((((TroopInfo)localObject1).isTroopAdmin(this.app.c())) || (((TroopInfo)localObject1).isTroopOwner(this.app.c())))) {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1))
            {
              localObject1 = getResources().getString(2131693553, new Object[] { alpo.a(2131705289) });
              label382:
              azmj.b(this.app, "dc00898", "", "", "0X800999A", "0X800999A", 3, 0, "", "", "", "");
              bool = true;
              i1 = 4;
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
          }
        }
        for (;;)
        {
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          break;
          localObject1 = getResources().getString(2131693553, new Object[] { alpo.a(2131705284) });
          break label382;
          if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1))
          {
            localObject1 = getResources().getString(2131693625, new Object[] { alpo.a(2131705312) });
            break label382;
          }
          localObject1 = getResources().getString(2131693625, new Object[] { alpo.a(2131705267) });
          break label382;
          if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1))
          {
            a(getResources().getString(2131693555, new Object[] { alpo.a(2131705310) }), 1);
            localObject1 = "";
            i1 = 0;
            bool = false;
            localObject2 = str1;
          }
          else
          {
            a(getResources().getString(2131693555, new Object[] { alpo.a(2131705268) }), 1);
            localObject1 = "";
            i1 = 0;
            bool = false;
            localObject2 = str1;
          }
        }
      }
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
        for (localObject1 = getResources().getString(2131693545);; localObject1 = getResources().getString(2131693624))
        {
          azmj.b(this.app, "dc00898", "", "", "0X800999A", "0X800999A", 2, 0, "", "", "", "");
          localObject2 = localObject3;
          i1 = 2;
          bool = false;
          break;
        }
      }
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1))
      {
        a(getResources().getString(2131693546, new Object[] { alpo.a(2131705283), alpo.a(2131705283) }), 1);
        localObject2 = "";
        i1 = 0;
        bool = false;
        localObject1 = "";
      }
      else
      {
        a(getResources().getString(2131693546, new Object[] { alpo.a(2131705291), alpo.a(2131705291) }), 1);
        localObject2 = "";
        i1 = 0;
        bool = false;
        localObject1 = "";
      }
    }
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable == null) {}
    try
    {
      Object localObject2 = BitmapFactory.decodeResource(getResources(), 2130849477);
      Object localObject1 = BitmapFactory.decodeResource(getResources(), 2130849481);
      localObject2 = new NinePatchDrawable(getResources(), (Bitmap)localObject2, ((Bitmap)localObject2).getNinePatchChunk(), new Rect(), null);
      localObject1 = new NinePatchDrawable(getResources(), (Bitmap)localObject1, ((Bitmap)localObject1).getNinePatchChunk(), new Rect(), null);
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[0], (Drawable)localObject2);
      return this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("FriendProfileCardActivity", 1, "getBackDrawable fail.", localException);
      }
    }
  }
  
  @NotNull
  private View a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramView.getContext());
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    localFrameLayout.setLayoutParams(paramView.getLayoutParams());
    localFrameLayout.setPadding(aekt.a(paramInt1, getResources()), aekt.a(paramInt2, getResources()), aekt.a(paramInt3, getResources()), aekt.a(paramInt4, getResources()));
    paramInt1 = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    localFrameLayout.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    localViewGroup.addView(localFrameLayout, paramInt1);
    return localFrameLayout;
  }
  
  public static ProfileActivity.CardContactInfo a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAllInOne != null)
    {
      localObject1 = localObject2;
      if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (paramAllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)paramAllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  public static String a(awmk paramawmk, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i1 = bcyw.a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if (i1 == 0)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (TextUtils.isEmpty(null)) {
        paramQQAppInterface = paramawmk.jdField_a_of_type_ArrayOfJavaLangString[4];
      }
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramQQAppInterface = paramawmk.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      return localObject1;
      if ((i1 == 1000) || (i1 == 1020))
      {
        paramQQAppInterface = paramawmk.jdField_a_of_type_ArrayOfJavaLangString[1];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
        }
      }
      else if (i1 == 1021)
      {
        paramQQAppInterface = paramawmk.jdField_a_of_type_ArrayOfJavaLangString[2];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.n;
        }
      }
      else if (i1 == 1004)
      {
        localObject1 = localObject2;
        if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString != null) {
          localObject1 = bdbt.c(paramQQAppInterface, paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString, paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (ProfileActivity.AllInOne.i(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          localObject1 = paramawmk.jdField_a_of_type_ArrayOfJavaLangString[3];
        }
      }
    }
  }
  
  public static String a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject1 = a(paramAllInOne);
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).jdField_b_of_type_JavaLangString + ((ProfileActivity.CardContactInfo)localObject1).jdField_c_of_type_JavaLangString;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramAllInOne.jdField_a_of_type_JavaLangString;
      }
      return localObject2;
    }
  }
  
  public static void a(Activity paramActivity, awmk paramawmk, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = aekt.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if ((paramActivity.getIntent() != null) && (paramActivity.getIntent().getExtras() != null)) {
      localIntent.putExtra("cSpecialFlag", paramActivity.getIntent().getExtras().getInt("cSpecialFlag"));
    }
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int != 0) {
      localIntent.putExtra("entrance", paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int);
    }
    localIntent.putExtra("uinname", paramString2);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(Message paramMessage)
  {
    this.jdField_b_of_type_Bhow.removeMessages(102);
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView;
        if (localObject != null) {}
      }
      catch (Exception paramMessage)
      {
        Object localObject;
        int i1;
        TextView localTextView;
        MedalWallMng localMedalWallMng;
        bool1 = false;
        bool2 = true;
        paramMessage.printStackTrace();
        boolean bool4 = bool1;
        bool3 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MedalWallMng", 2, "checkMedalGuide exception", paramMessage);
        bool4 = bool1;
        bool3 = bool2;
        continue;
      }
      try
      {
        if (QLog.isDevelopLevel())
        {
          QLog.i("MedalWallMng", 4, "checkMedalGuide headerView is null");
          i1 = 1;
          bool2 = false;
          bool1 = false;
          if (i1 == 0) {
            continue;
          }
        }
      }
      catch (Exception paramMessage)
      {
        bool1 = false;
        bool2 = false;
        continue;
      }
      try
      {
        if (paramMessage.arg1 >= 2) {
          continue;
        }
        localObject = this.jdField_b_of_type_Bhow.obtainMessage();
        ((Message)localObject).what = paramMessage.what;
        ((Message)localObject).arg1 = (paramMessage.arg1 + 1);
        this.jdField_b_of_type_Bhow.sendMessageDelayed((Message)localObject, 1000L);
        bool3 = bool1;
        bool4 = bool2;
        if (bool4) {
          c();
        }
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkMedalGuide needUpdateAlpha:%s, needUpdateMedal: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4) }));
        }
        return;
      }
      catch (Exception paramMessage)
      {
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
        continue;
        bool1 = false;
        continue;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a("map_key_medal");
      if (localObject == null)
      {
        if (QLog.isDevelopLevel())
        {
          QLog.i("MedalWallMng", 4, "checkMedalGuide medalContainer is null!");
          i1 = 1;
          bool2 = false;
          bool1 = false;
        }
      }
      else
      {
        localTextView = (TextView)((View)localObject).findViewById(2131370113);
        if ((localTextView != null) && (localTextView.getWidth() > 0) && (localTextView.getHeight() > 0))
        {
          localMedalWallMng = (MedalWallMng)this.app.getManager(250);
          if (this.jdField_a_of_type_Awmk != null)
          {
            localObject = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard;
            if ((!localMedalWallMng.a(this, localTextView, 2, localObject)) || (this.jdField_a_of_type_Awmk == null)) {
              break label482;
            }
            localObject = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard;
            if (localObject == null) {
              break label482;
            }
          }
        }
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkMedalGuide [iNewCount: %d, iUpgradeCount: %d]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount), Integer.valueOf(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.iUpgradeCount) }));
        }
        bool1 = true;
        i1 = 0;
        bool2 = bool1;
        bool1 = true;
      }
      catch (Exception paramMessage)
      {
        bool1 = true;
        bool2 = true;
        continue;
      }
      localObject = null;
      continue;
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "checkMedalGuide textView is null or size is 0!");
      }
      i1 = 1;
      bool2 = false;
      bool1 = false;
      continue;
      bool1 = true;
    }
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.findViewById(2131379222);
      if (paramView != null)
      {
        if (!bcyw.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard, this.app)) {
          break label39;
        }
        paramView.setVisibility(0);
      }
    }
    return;
    label39:
    paramView.setVisibility(8);
  }
  
  /* Error */
  public static void a(QQAppInterface arg0, awmk paramawmk)
  {
    // Byte code:
    //   0: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 402
    //   9: iconst_2
    //   10: ldc_w 1209
    //   13: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   20: getfield 1044	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   23: astore 6
    //   25: aload_1
    //   26: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   29: getfield 1043	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   32: astore_3
    //   33: aload_1
    //   34: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   37: getfield 1046	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:m	Ljava/lang/String;
    //   40: astore 5
    //   42: aload_1
    //   43: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   46: getfield 1211	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   49: astore 12
    //   51: aload_1
    //   52: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   55: getfield 1213	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   58: astore 10
    //   60: aload_1
    //   61: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   64: getfield 1215	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   67: astore 14
    //   69: aload_1
    //   70: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   73: getfield 1048	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:n	Ljava/lang/String;
    //   76: astore 13
    //   78: aload 6
    //   80: astore 7
    //   82: aload 6
    //   84: astore 8
    //   86: aload_1
    //   87: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   90: invokestatic 920	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   93: ifeq +564 -> 657
    //   96: aload 6
    //   98: astore 7
    //   100: aload 6
    //   102: astore 8
    //   104: aload_0
    //   105: bipush 51
    //   107: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   110: checkcast 670	aloz
    //   113: astore 4
    //   115: aload 4
    //   117: ifnonnull +515 -> 632
    //   120: aconst_null
    //   121: astore 11
    //   123: aload 6
    //   125: astore 9
    //   127: aload 11
    //   129: ifnull +866 -> 995
    //   132: aload 6
    //   134: astore 4
    //   136: aload 6
    //   138: astore 7
    //   140: aload 6
    //   142: astore 8
    //   144: aload 11
    //   146: getfield 1220	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   149: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: ifne +18 -> 170
    //   155: aload 6
    //   157: astore 7
    //   159: aload 6
    //   161: astore 8
    //   163: aload 11
    //   165: getfield 1220	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   168: astore 4
    //   170: aload 4
    //   172: astore 7
    //   174: aload 4
    //   176: astore 8
    //   178: aload 4
    //   180: astore 9
    //   182: aload 11
    //   184: getfield 1223	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   187: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   190: ifne +805 -> 995
    //   193: aload 4
    //   195: astore 7
    //   197: aload 4
    //   199: astore 8
    //   201: aload 11
    //   203: getfield 1223	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   206: astore 6
    //   208: aload 4
    //   210: astore_3
    //   211: aload 6
    //   213: astore 4
    //   215: aload_0
    //   216: bipush 52
    //   218: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   221: checkcast 526	com/tencent/mobileqq/app/TroopManager
    //   224: astore 8
    //   226: aload_1
    //   227: getfield 532	awmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   230: astore 7
    //   232: aload 7
    //   234: astore 6
    //   236: aload 7
    //   238: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   241: ifeq +34 -> 275
    //   244: aload 7
    //   246: astore 6
    //   248: aload_1
    //   249: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   252: getfield 1050	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   255: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifne +17 -> 275
    //   261: aload 8
    //   263: aload_1
    //   264: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   267: getfield 1050	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   270: invokevirtual 1226	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   273: astore 6
    //   275: aload 6
    //   277: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   280: ifne +696 -> 976
    //   283: aload 8
    //   285: ifnull +691 -> 976
    //   288: aload_0
    //   289: aload 6
    //   291: aload_1
    //   292: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   295: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   298: invokestatic 1228	bdbt:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   301: astore_0
    //   302: aload 10
    //   304: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   307: ifeq +662 -> 969
    //   310: aload_1
    //   311: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   314: invokestatic 1057	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Lcom/tencent/mobileqq/activity/ProfileActivity$CardContactInfo;
    //   317: astore 5
    //   319: aload 5
    //   321: ifnull +648 -> 969
    //   324: aload 5
    //   326: getfield 1229	com/tencent/mobileqq/activity/ProfileActivity$CardContactInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   329: astore 5
    //   331: aload 4
    //   333: astore 6
    //   335: aload 5
    //   337: astore 9
    //   339: aload_3
    //   340: astore 4
    //   342: aload 6
    //   344: astore 5
    //   346: aload_0
    //   347: astore 6
    //   349: aload_1
    //   350: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   353: astore_0
    //   354: aload_0
    //   355: monitorenter
    //   356: aload_1
    //   357: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   360: iconst_0
    //   361: aaload
    //   362: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   365: ifeq +11 -> 376
    //   368: aload_1
    //   369: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   372: iconst_0
    //   373: aload 4
    //   375: aastore
    //   376: aload_1
    //   377: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   380: iconst_4
    //   381: aaload
    //   382: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   385: ifeq +11 -> 396
    //   388: aload_1
    //   389: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   392: iconst_4
    //   393: aload 5
    //   395: aastore
    //   396: aload_1
    //   397: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   400: iconst_3
    //   401: aaload
    //   402: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   405: ifeq +11 -> 416
    //   408: aload_1
    //   409: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   412: iconst_3
    //   413: aload 9
    //   415: aastore
    //   416: aload_1
    //   417: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   420: iconst_5
    //   421: aaload
    //   422: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   425: ifeq +11 -> 436
    //   428: aload_1
    //   429: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   432: iconst_5
    //   433: aload 12
    //   435: aastore
    //   436: aload_1
    //   437: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   440: iconst_1
    //   441: aaload
    //   442: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   445: ifeq +11 -> 456
    //   448: aload_1
    //   449: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   452: iconst_1
    //   453: aload 6
    //   455: aastore
    //   456: aload_1
    //   457: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   460: bipush 6
    //   462: aaload
    //   463: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   466: ifeq +12 -> 478
    //   469: aload_1
    //   470: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   473: bipush 6
    //   475: aload 14
    //   477: aastore
    //   478: aload_1
    //   479: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   482: iconst_2
    //   483: aaload
    //   484: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   487: ifeq +11 -> 498
    //   490: aload_1
    //   491: getfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   494: iconst_2
    //   495: aload 13
    //   497: aastore
    //   498: aload_0
    //   499: monitorexit
    //   500: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +128 -> 631
    //   506: new 404	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   513: astore_0
    //   514: aload_0
    //   515: ldc_w 1231
    //   518: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: ldc_w 1233
    //   524: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload 4
    //   529: invokestatic 1237	bdal:b	(Ljava/lang/String;)Ljava/lang/String;
    //   532: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: ldc_w 1239
    //   538: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload 5
    //   543: invokestatic 1237	bdal:b	(Ljava/lang/String;)Ljava/lang/String;
    //   546: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 1241
    //   552: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 9
    //   557: invokestatic 1237	bdal:b	(Ljava/lang/String;)Ljava/lang/String;
    //   560: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: ldc_w 1243
    //   566: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload 12
    //   571: invokestatic 1237	bdal:b	(Ljava/lang/String;)Ljava/lang/String;
    //   574: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: ldc_w 1245
    //   580: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 6
    //   585: invokestatic 1237	bdal:b	(Ljava/lang/String;)Ljava/lang/String;
    //   588: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: ldc_w 1247
    //   594: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 13
    //   599: invokestatic 1237	bdal:b	(Ljava/lang/String;)Ljava/lang/String;
    //   602: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: ldc_w 1249
    //   608: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload 12
    //   613: invokestatic 1237	bdal:b	(Ljava/lang/String;)Ljava/lang/String;
    //   616: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: ldc_w 402
    //   623: iconst_2
    //   624: aload_0
    //   625: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokestatic 561	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   631: return
    //   632: aload 6
    //   634: astore 7
    //   636: aload 6
    //   638: astore 8
    //   640: aload 4
    //   642: aload_1
    //   643: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   646: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   649: invokevirtual 1252	aloz:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   652: astore 11
    //   654: goto -531 -> 123
    //   657: aload 6
    //   659: astore 7
    //   661: aload 6
    //   663: astore 8
    //   665: aload_1
    //   666: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   669: getfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   672: ifne +33 -> 705
    //   675: aload 6
    //   677: astore 7
    //   679: aload 6
    //   681: astore 8
    //   683: aload_0
    //   684: aload_1
    //   685: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   688: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   691: invokestatic 1255	bdbt:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   694: astore 6
    //   696: aload_3
    //   697: astore 4
    //   699: aload 6
    //   701: astore_3
    //   702: goto -487 -> 215
    //   705: aload 6
    //   707: astore 7
    //   709: aload 6
    //   711: astore 8
    //   713: aload 6
    //   715: astore 4
    //   717: aload 6
    //   719: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   722: ifeq +260 -> 982
    //   725: aload 6
    //   727: astore 7
    //   729: aload 6
    //   731: astore 8
    //   733: aload 6
    //   735: astore 4
    //   737: aload_1
    //   738: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   741: invokestatic 1257	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:g	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   744: ifeq +238 -> 982
    //   747: aload 6
    //   749: astore 7
    //   751: aload 6
    //   753: astore 8
    //   755: aload_0
    //   756: aload_1
    //   757: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   760: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   763: iconst_0
    //   764: invokestatic 1260	bdbt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   767: astore 4
    //   769: aload 4
    //   771: astore 7
    //   773: aload 4
    //   775: astore 8
    //   777: aload 4
    //   779: aload_1
    //   780: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   783: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   786: invokestatic 1263	bdal:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   789: istore_2
    //   790: iload_2
    //   791: ifeq +191 -> 982
    //   794: aconst_null
    //   795: astore 6
    //   797: aload_3
    //   798: astore 4
    //   800: aload 6
    //   802: astore_3
    //   803: goto -588 -> 215
    //   806: astore 8
    //   808: aload 5
    //   810: astore_0
    //   811: aload_0
    //   812: astore 6
    //   814: aload_3
    //   815: astore 5
    //   817: aload 7
    //   819: astore 4
    //   821: aload 10
    //   823: astore 9
    //   825: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   828: ifeq -479 -> 349
    //   831: ldc_w 402
    //   834: iconst_2
    //   835: aload 8
    //   837: invokevirtual 559	java/lang/Exception:toString	()Ljava/lang/String;
    //   840: invokestatic 561	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   843: aload_0
    //   844: astore 6
    //   846: aload_3
    //   847: astore 5
    //   849: aload 7
    //   851: astore 4
    //   853: aload 10
    //   855: astore 9
    //   857: goto -508 -> 349
    //   860: astore 7
    //   862: aload 5
    //   864: astore_0
    //   865: aload_0
    //   866: astore 6
    //   868: aload_3
    //   869: astore 5
    //   871: aload 8
    //   873: astore 4
    //   875: aload 10
    //   877: astore 9
    //   879: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq -533 -> 349
    //   885: ldc_w 402
    //   888: iconst_2
    //   889: aload 7
    //   891: invokevirtual 1264	java/lang/Error:toString	()Ljava/lang/String;
    //   894: invokestatic 561	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   897: aload_0
    //   898: astore 6
    //   900: aload_3
    //   901: astore 5
    //   903: aload 8
    //   905: astore 4
    //   907: aload 10
    //   909: astore 9
    //   911: goto -562 -> 349
    //   914: astore_1
    //   915: aload_0
    //   916: monitorexit
    //   917: aload_1
    //   918: athrow
    //   919: astore 7
    //   921: aload_3
    //   922: astore 8
    //   924: aload 5
    //   926: astore_0
    //   927: aload 4
    //   929: astore_3
    //   930: goto -65 -> 865
    //   933: astore 7
    //   935: aload_3
    //   936: astore 8
    //   938: aload 4
    //   940: astore_3
    //   941: goto -76 -> 865
    //   944: astore 8
    //   946: aload_3
    //   947: astore 7
    //   949: aload 5
    //   951: astore_0
    //   952: aload 4
    //   954: astore_3
    //   955: goto -144 -> 811
    //   958: astore 8
    //   960: aload_3
    //   961: astore 7
    //   963: aload 4
    //   965: astore_3
    //   966: goto -155 -> 811
    //   969: aload 10
    //   971: astore 5
    //   973: goto -642 -> 331
    //   976: aload 5
    //   978: astore_0
    //   979: goto -677 -> 302
    //   982: aload 4
    //   984: astore 6
    //   986: aload_3
    //   987: astore 4
    //   989: aload 6
    //   991: astore_3
    //   992: goto -777 -> 215
    //   995: aload_3
    //   996: astore 4
    //   998: aload 9
    //   1000: astore_3
    //   1001: goto -786 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1004	1	paramawmk	awmk
    //   789	2	2	bool	boolean
    //   32	969	3	localObject1	Object
    //   113	884	4	localObject2	Object
    //   40	937	5	localObject3	Object
    //   23	967	6	localObject4	Object
    //   80	770	7	localObject5	Object
    //   860	30	7	localError1	java.lang.Error
    //   919	1	7	localError2	java.lang.Error
    //   933	1	7	localError3	java.lang.Error
    //   947	15	7	localObject6	Object
    //   84	692	8	localObject7	Object
    //   806	98	8	localException1	Exception
    //   922	15	8	localObject8	Object
    //   944	1	8	localException2	Exception
    //   958	1	8	localException3	Exception
    //   125	874	9	localObject9	Object
    //   58	912	10	str1	String
    //   121	532	11	localFriends	Friends
    //   49	563	12	str2	String
    //   76	522	13	str3	String
    //   67	409	14	str4	String
    // Exception table:
    //   from	to	target	type
    //   86	96	806	java/lang/Exception
    //   104	115	806	java/lang/Exception
    //   144	155	806	java/lang/Exception
    //   163	170	806	java/lang/Exception
    //   182	193	806	java/lang/Exception
    //   201	208	806	java/lang/Exception
    //   640	654	806	java/lang/Exception
    //   665	675	806	java/lang/Exception
    //   683	696	806	java/lang/Exception
    //   717	725	806	java/lang/Exception
    //   737	747	806	java/lang/Exception
    //   755	769	806	java/lang/Exception
    //   777	790	806	java/lang/Exception
    //   86	96	860	java/lang/Error
    //   104	115	860	java/lang/Error
    //   144	155	860	java/lang/Error
    //   163	170	860	java/lang/Error
    //   182	193	860	java/lang/Error
    //   201	208	860	java/lang/Error
    //   640	654	860	java/lang/Error
    //   665	675	860	java/lang/Error
    //   683	696	860	java/lang/Error
    //   717	725	860	java/lang/Error
    //   737	747	860	java/lang/Error
    //   755	769	860	java/lang/Error
    //   777	790	860	java/lang/Error
    //   356	376	914	finally
    //   376	396	914	finally
    //   396	416	914	finally
    //   416	436	914	finally
    //   436	456	914	finally
    //   456	478	914	finally
    //   478	498	914	finally
    //   498	500	914	finally
    //   915	917	914	finally
    //   215	232	919	java/lang/Error
    //   236	244	919	java/lang/Error
    //   248	275	919	java/lang/Error
    //   275	283	919	java/lang/Error
    //   288	302	919	java/lang/Error
    //   302	319	933	java/lang/Error
    //   324	331	933	java/lang/Error
    //   215	232	944	java/lang/Exception
    //   236	244	944	java/lang/Exception
    //   248	275	944	java/lang/Exception
    //   275	283	944	java/lang/Exception
    //   288	302	944	java/lang/Exception
    //   302	319	958	java/lang/Exception
    //   324	331	958	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, awmk paramawmk)
  {
    int i2 = bcyw.a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    String str3 = a(paramawmk, paramQQAppInterface);
    String str2 = null;
    Object localObject;
    String str1;
    if (ProfileActivity.AllInOne.g(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      localObject = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      str2 = null;
      if (i2 != 1000) {
        break label370;
      }
      str1 = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      label58:
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "free call click");
      }
      azmj.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Clk_freecall", a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      ChatActivityUtils.a(paramQQAppInterface, paramBaseActivity, i2, (String)localObject, str3, str2, true, str1, true, true, null, "from_internal");
      switch (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
      {
      default: 
        paramBaseActivity = "4";
      }
      for (;;)
      {
        azmj.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, paramBaseActivity, "", "", "");
        return;
        str1 = str2;
        int i1 = i2;
        if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
        {
          str1 = str2;
          i1 = i2;
          if (paramawmk.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
          {
            str1 = str2;
            i1 = i2;
            if (!TextUtils.isEmpty(paramawmk.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin))
            {
              str1 = paramawmk.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
              i1 = 0;
            }
          }
        }
        str2 = a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        localObject = str1;
        i2 = i1;
        break;
        label370:
        if (i2 != 1004) {
          break label418;
        }
        str1 = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
        break label58;
        paramBaseActivity = "4";
        continue;
        paramBaseActivity = "5";
        continue;
        paramBaseActivity = "6";
        continue;
        paramBaseActivity = "7";
      }
      label418:
      str1 = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, awmk paramawmk, Dialog paramDialog)
  {
    Object localObject = paramBaseActivity.getIntent().getBundleExtra("profile_extres");
    boolean bool;
    int i3;
    int i4;
    int i1;
    int i2;
    if (localObject != null)
    {
      bool = ((Bundle)localObject).getBoolean("from_babyq", false);
      i3 = 3999;
      i4 = 0;
      i1 = i4;
      i2 = i3;
      switch (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
      {
      default: 
        i2 = i3;
        i1 = i4;
      }
    }
    for (;;)
    {
      if (i2 == 3045) {
        azmj.b(paramQQAppInterface, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(i1), "", "", "");
      }
      if (i2 == 3094) {
        azmj.a(paramQQAppInterface, "dc00898", "", paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "0X80092E2", "0X80092E2", 0, 0, String.valueOf(i1), aqcx.a(), aqcx.a(paramQQAppInterface), aqcx.c());
      }
      if ((i2 != 3007) || (alqx.a(paramQQAppInterface, paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label1665;
      }
      localObject = paramDialog;
      if (paramDialog == null) {
        localObject = alqx.a(paramBaseActivity, paramBaseActivity.getString(2131694708), new acvs(paramQQAppInterface, paramBaseActivity, paramawmk), new acvt());
      }
      if ((localObject != null) && (!((Dialog)localObject).isShowing()) && (!paramBaseActivity.isFinishing())) {
        ((Dialog)localObject).show();
      }
      return;
      bool = false;
      break;
      i1 = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
      i2 = 3004;
      continue;
      i1 = 3;
      i2 = 3004;
      continue;
      i1 = 1;
      i2 = 3007;
      continue;
      i1 = 1;
      i2 = 3001;
      continue;
      i1 = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
      i2 = 3020;
      continue;
      i1 = 1;
      i2 = 3017;
      continue;
      i1 = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
      i2 = 3002;
      continue;
      i1 = 1;
      i2 = 3005;
      continue;
      i1 = 2;
      i2 = 3007;
      continue;
      i1 = 0;
      i2 = 3003;
      continue;
      i1 = 12;
      i2 = 3008;
      continue;
      i1 = 11;
      i2 = 3008;
      continue;
      i1 = 12;
      i2 = 3041;
      continue;
      i1 = 11;
      i2 = 3041;
      continue;
      i1 = 0;
      i2 = 3999;
      continue;
      i1 = 1;
      i2 = 3037;
      continue;
      i1 = 1;
      i2 = 3095;
      continue;
      i1 = 1;
      i2 = 3096;
      continue;
      i1 = 1;
      i2 = 3042;
      continue;
      i1 = 2;
      i2 = 3037;
      continue;
      i1 = 0;
      i2 = 3009;
      continue;
      i2 = 3006;
      i1 = 13;
      if (bool)
      {
        i1 = 1;
        i2 = 3084;
        continue;
        i2 = 3068;
        i1 = 1;
        if (bool)
        {
          i1 = 1;
          i2 = 3084;
          continue;
          if ((paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 16) || (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 17))
          {
            i1 = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
            i2 = 3006;
          }
          else
          {
            i1 = 1;
            i2 = 3075;
            continue;
            i1 = 1;
            i2 = 3009;
            continue;
            i1 = 1;
            i2 = 3006;
            continue;
            i1 = 0;
            i2 = 3013;
            continue;
            i1 = 1;
            i2 = 3003;
            continue;
            if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 127)
            {
              i1 = 1;
              i2 = 3048;
            }
            else
            {
              i1 = 1;
              i2 = 3014;
              continue;
              i1 = 2;
              i2 = 3003;
              continue;
              i2 = 3022;
              i1 = 1;
              if (bool)
              {
                i1 = 1;
                i2 = 3083;
                continue;
                i1 = 0;
                i2 = 3011;
                continue;
                i1 = 1;
                i2 = 3071;
                continue;
                i1 = 21;
                i2 = 3045;
                continue;
                i1 = 23;
                i2 = 3045;
                continue;
                i2 = 3045;
                i1 = 3;
                if (bool)
                {
                  i1 = 1;
                  i2 = 3083;
                  continue;
                  if (localObject != null) {}
                  for (i1 = ((Bundle)localObject).getInt("tabID", 0);; i1 = 0)
                  {
                    i2 = 3045;
                    break;
                  }
                  i1 = 28;
                  i2 = 3045;
                  continue;
                  i1 = 4;
                  i2 = 3045;
                  continue;
                  i1 = 24;
                  i2 = 3045;
                  continue;
                  i1 = 20;
                  i2 = 3045;
                  continue;
                  i1 = 25;
                  i2 = 3045;
                  continue;
                  i1 = 1;
                  i2 = 3092;
                  continue;
                  if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 4)
                  {
                    i1 = 4;
                    i2 = 3094;
                  }
                  else if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 5)
                  {
                    i1 = 5;
                    i2 = 3094;
                  }
                  else if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 6)
                  {
                    i1 = 6;
                    i2 = 3094;
                  }
                  else if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 7)
                  {
                    i1 = 7;
                    i2 = 3094;
                  }
                  else if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 8)
                  {
                    i1 = 8;
                    i2 = 3094;
                  }
                  else if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 9)
                  {
                    i1 = 9;
                    i2 = 3094;
                  }
                  else
                  {
                    i1 = 1;
                    i2 = 3094;
                    continue;
                    i1 = 11;
                    i2 = 3072;
                    continue;
                    i1 = 12;
                    i2 = 3072;
                    continue;
                    i1 = 1;
                    i2 = 3018;
                    continue;
                    i1 = 15;
                    i2 = 3041;
                    continue;
                    i1 = 14;
                    i2 = 3041;
                    continue;
                    if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 118)
                    {
                      i1 = 3;
                      i2 = 3022;
                    }
                    else
                    {
                      i1 = i4;
                      i2 = i3;
                      if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 121)
                      {
                        i1 = 2;
                        i2 = 3022;
                        continue;
                        i1 = 23;
                        i2 = 3004;
                        continue;
                        i1 = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
                        i2 = 3004;
                        continue;
                        i1 = 2;
                        i2 = 3080;
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
    label1665:
    if (paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (localObject = bcyw.a(paramQQAppInterface.getApp().getApplicationContext(), paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.shGender, paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.age, paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry, paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince, paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.strCity);; localObject = "")
    {
      String str;
      if ((paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36) || (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) || (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 29))
      {
        ProfileActivity.CardContactInfo localCardContactInfo = a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if ((localCardContactInfo == null) || (localCardContactInfo.jdField_c_of_type_JavaLangString == null) || (localCardContactInfo.jdField_c_of_type_JavaLangString.length() <= 0)) {
          break;
        }
        str = localCardContactInfo.jdField_b_of_type_JavaLangString + localCardContactInfo.jdField_c_of_type_JavaLangString;
        paramDialog = localCardContactInfo.jdField_a_of_type_JavaLangString;
        paramQQAppInterface = paramDialog;
        if (TextUtils.isEmpty(localCardContactInfo.jdField_a_of_type_JavaLangString))
        {
          if (TextUtils.isEmpty(paramawmk.jdField_a_of_type_ArrayOfJavaLangString[3])) {
            break label2017;
          }
          paramQQAppInterface = paramawmk.jdField_a_of_type_ArrayOfJavaLangString[3];
        }
        for (;;)
        {
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 2, str, null, i2, i1, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131690623), null);
          paramQQAppInterface.putExtra("param_return_profilecard_pa", paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramawmk);
          bool = paramBaseActivity.getIntent().getBooleanExtra("from_newer_guide", false);
          if (!bool) {
            break;
          }
          paramQQAppInterface.putExtra("from_newer_guide", bool);
          paramQQAppInterface.removeExtra("param_return_addr");
          paramBaseActivity.startActivityForResult(paramQQAppInterface, 1024);
          return;
          label2017:
          if (!TextUtils.isEmpty(paramawmk.jdField_a_of_type_ArrayOfJavaLangString[0]))
          {
            paramQQAppInterface = paramawmk.jdField_a_of_type_ArrayOfJavaLangString[0];
          }
          else
          {
            paramQQAppInterface = paramDialog;
            if (!TextUtils.isEmpty(paramawmk.jdField_a_of_type_Bcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString)) {
              paramQQAppInterface = paramawmk.jdField_a_of_type_Bcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString;
            }
          }
        }
        paramBaseActivity.startActivity(paramQQAppInterface);
        return;
      }
      paramQQAppInterface = null;
      if ((3004 == i2) && (!TextUtils.isEmpty(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)))
      {
        paramDialog = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
        paramQQAppInterface = null;
        if ((paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 71) && (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 72)) {
          break label2286;
        }
        paramQQAppInterface = paramawmk.jdField_a_of_type_ArrayOfJavaLangString[2];
        label2141:
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          break label2527;
        }
        paramQQAppInterface = paramawmk.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      label2524:
      label2527:
      for (;;)
      {
        str = paramBaseActivity.getIntent().getStringExtra("param_return_addr");
        if (str != null)
        {
          localObject = AddContactsActivity.class.getName();
          if (!str.equals(QidianProfileCardActivity.class.getName())) {
            break label2524;
          }
          localObject = str;
        }
        for (;;)
        {
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialog, i2, i1, paramQQAppInterface, null, (String)localObject, paramBaseActivity.getString(2131690623), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramawmk);
          paramBaseActivity.startActivity(paramQQAppInterface);
          return;
          paramDialog = paramQQAppInterface;
          if (3005 != i2) {
            break;
          }
          paramDialog = paramQQAppInterface;
          if (TextUtils.isEmpty(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
            break;
          }
          paramDialog = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
          break;
          label2286:
          if ((paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 77) && (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 82) && (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 81) && (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 83) && (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 84) && (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 101) && (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 103) && (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 102) && (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 107) && (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 110)) {
            break label2141;
          }
          paramQQAppInterface = paramawmk.jdField_a_of_type_ArrayOfJavaLangString[5];
          break label2141;
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialog, i2, i1, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131690623), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramawmk);
          if (i2 == 3094)
          {
            paramQQAppInterface.putExtra("entrance", paramBaseActivity.getIntent().getIntExtra("entrance", 2));
            paramQQAppInterface.removeExtra("param_return_addr");
            paramBaseActivity.startActivity(paramQQAppInterface);
            return;
          }
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject);
          paramBaseActivity.startActivityForResult(paramQQAppInterface, 1000);
          return;
        }
      }
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, awmk paramawmk, String paramString, int paramInt)
  {
    if (paramBaseActivity.getIntent() != null) {}
    for (boolean bool = paramBaseActivity.getIntent().getBooleanExtra("key_need_track_back", false) | paramBaseActivity.getIntent().getBooleanExtra("from_newer_guide", false);; bool = false)
    {
      Object localObject;
      Intent localIntent;
      if (bool)
      {
        localObject = new Intent(paramBaseActivity, ChatActivity.class);
        localIntent = aekt.a((Intent)localObject, null);
        localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
        localIntent.putExtra("PREVIOUS_UIN", paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (paramBaseActivity.getIntent().getExtras() != null) {
          localIntent.putExtra("cSpecialFlag", paramBaseActivity.getIntent().getExtras().getInt("cSpecialFlag"));
        }
        localIntent.putExtra("uin", paramString);
        localIntent.putExtra("uintype", paramInt);
        localIntent.putExtra("aio_msg_source", 3);
        if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int != 0) {
          localIntent.putExtra("entrance", paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int);
        }
        localObject = a(paramawmk, paramQQAppInterface);
        if (localObject != null) {
          break label498;
        }
        paramString = "";
        label192:
        localIntent.putExtra("uinname", paramString);
        if (TextUtils.isEmpty(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
          break label504;
        }
        localIntent.putExtra("troop_uin", paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {
          localIntent.putExtra("troop_code", paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString);
        }
        if (paramInt == 1009) {
          localIntent.putExtra("rich_status_sig", paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
        if (paramInt == 1001) {
          localIntent.putExtra("rich_accost_sig", paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, String.format(Locale.getDefault(), "enterChar uin: %s name: %s sig: %s", new Object[] { bdal.b(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString), bdal.b((String)localObject), bdal.a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b) }));
        }
        paramQQAppInterface = (aloz)paramQQAppInterface.getManager(51);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if ((paramQQAppInterface != null) && ((ndv.a(paramQQAppInterface.cSpecialFlag)) || (bfua.b(paramQQAppInterface.cSpecialFlag)))) {
            localIntent.putExtra("chat_subType", 1);
          }
        }
        localIntent.putExtra("hidden_aio_msg_source", 2);
        if ((paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70) || (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g != 101)) {
          break label536;
        }
        localIntent.putExtra("is_from_manage_stranger", true);
        paramBaseActivity.startActivityForResult(localIntent, 1010);
        return;
        localObject = new Intent(paramBaseActivity, SplashActivity.class);
        break;
        label498:
        paramString = (String)localObject;
        break label192;
        label504:
        if (!TextUtils.isEmpty(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
          localIntent.putExtra("troop_uin", paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
        }
      }
      label536:
      paramBaseActivity.startActivity(localIntent);
      return;
    }
  }
  
  public static boolean a(awmk paramawmk, int paramInt, String paramString)
  {
    if ((paramawmk == null) || (paramawmk.jdField_a_of_type_ArrayOfJavaLangString == null) || (paramInt < 0) || (paramInt >= paramawmk.jdField_a_of_type_ArrayOfJavaLangString.length)) {
      return false;
    }
    paramawmk.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    return true;
  }
  
  private void b(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
    {
      arrayOfByte = null;
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
        break label281;
      }
    }
    for (byte[] arrayOfByte = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;; arrayOfByte = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b) {
      label281:
      do
      {
        a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.feedPreviewTime, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.vSeed, arrayOfByte, true);
        if ((paramIntent != null) && (paramIntent.getBundleExtra("result") != null))
        {
          int i1 = paramIntent.getBundleExtra("result").getShort("key_personality_label_switch", (short)-1);
          if ((i1 != -1) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel.isCloseByUser != i1))
          {
            if (QLog.isColorLevel()) {
              QLog.i("FriendProfileCardActivity", 2, "back personalitylabel switch changed:" + i1);
            }
            this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel.isCloseByUser = i1;
            if (this.jdField_a_of_type_Awkn != null) {
              this.jdField_a_of_type_Awkn.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel, false, true);
            }
            d();
          }
        }
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("is_set_cover", false))) {
          a(paramIntent.getByteArrayExtra("cover_data"));
        }
        return;
      } while ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 35) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 37) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36));
    }
  }
  
  public static void b(awmk paramawmk)
  {
    int i3 = 6;
    int i1 = 3;
    if (paramawmk.jdField_a_of_type_Bcuo == null) {
      paramawmk.jdField_a_of_type_Bcuo = new bcuo();
    }
    int i2;
    switch (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      i1 = 1;
      i2 = 0;
    }
    for (;;)
    {
      bcup.a(i2, i1, paramawmk.jdField_a_of_type_ArrayOfJavaLangString, paramawmk.jdField_a_of_type_Bcuo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "updateProfileName profileName: %s", new Object[] { paramawmk.jdField_a_of_type_Bcuo.toString() }));
      }
      return;
      if (paramawmk.jdField_b_of_type_Boolean)
      {
        i2 = 3;
        i1 = 2;
      }
      else
      {
        i1 = 2;
        i2 = 1;
        continue;
        i1 = 2;
        i2 = 2;
        continue;
        if (paramawmk.jdField_b_of_type_Boolean)
        {
          i2 = 3;
          i1 = 2;
        }
        else
        {
          i1 = 2;
          i2 = 2;
          continue;
          i2 = 3;
          i1 = 2;
          continue;
          i2 = 3;
          i1 = 1;
          continue;
          i2 = 4;
          i1 = 1;
          continue;
          i1 = 2;
          i2 = i3;
          continue;
          i1 = 1;
          i2 = i3;
          continue;
          if (paramawmk.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
          {
            i2 = i3;
            if (!TextUtils.isEmpty(paramawmk.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)) {}
          }
          else
          {
            i1 = 1;
            i2 = i3;
            continue;
            i2 = 7;
            i1 = 2;
            continue;
            i2 = 7;
            i1 = 1;
            continue;
            i2 = 8;
            i1 = 1;
            continue;
            i2 = 9;
            i1 = 1;
            continue;
            i2 = 11;
            i1 = 1;
            continue;
            i1 = 1;
            i2 = 1;
            continue;
            i2 = 5;
            i1 = 1;
          }
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, awmk paramawmk)
  {
    bdah.a(true);
    ProfileActivity.AllInOne localAllInOne = paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    int i1 = bcyw.a(localAllInOne);
    if ((localAllInOne.jdField_f_of_type_JavaLangString != null) && (localAllInOne.jdField_f_of_type_JavaLangString.length() > 0) && (localAllInOne.jdField_e_of_type_Int != 3000) && (localAllInOne.jdField_e_of_type_Int != 1) && (localAllInOne.jdField_e_of_type_Int != 2) && (localAllInOne.jdField_e_of_type_Int != 1033) && (localAllInOne.jdField_e_of_type_Int != 1034) && (localAllInOne.jdField_e_of_type_Int != 1044) && (localAllInOne.jdField_e_of_type_Int != 1045) && (localAllInOne.jdField_f_of_type_JavaLangString.equals(localAllInOne.jdField_a_of_type_JavaLangString)))
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.putExtra("finchat", true);
      paramBaseActivity.setResult(0, paramQQAppInterface);
      paramBaseActivity.finish();
      return;
    }
    String str = localAllInOne.jdField_a_of_type_JavaLangString;
    if (ProfileActivity.AllInOne.i(localAllInOne)) {
      if (localAllInOne.jdField_a_of_type_Int == 53) {
        if ((paramawmk.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) && (!TextUtils.isEmpty(paramawmk.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)))
        {
          i1 = 0;
          str = paramawmk.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
        }
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramBaseActivity, paramawmk, str, i1);
      return;
      i1 = 1006;
      continue;
      str = a(localAllInOne);
      continue;
      if (localAllInOne.jdField_a_of_type_Int == 3) {
        azmj.b(paramQQAppInterface, "CliOper", "", "", "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
      } else if (localAllInOne.g == 102) {
        azmj.b(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_RandomConversation", 0, 0, "", "", "", "");
      } else if (localAllInOne.g == 103) {
        azmj.b(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_superConversation", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void c(Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "initAvatarManager failed intent null");
      }
    }
    Bundle localBundle;
    do
    {
      return;
      localBundle = paramIntent.getBundleExtra("profile_extres");
    } while ((localBundle == null) || (!localBundle.getBoolean("key_from_sdk_set_avatar", false)));
    this.jdField_a_of_type_Aikl = new aikl(this);
    this.jdField_a_of_type_Aikl.a(paramIntent);
    this.jdField_a_of_type_Aikl.a();
  }
  
  private boolean g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo begin");
    }
    if ((this.u) || (this.jdField_b_of_type_Apxc != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo, has requeseted : " + this.u);
      }
      return false;
    }
    this.jdField_b_of_type_Apxc = new acvq(this);
    this.jdField_b_of_type_Bepp = new bepp(this, getTitleBarHeight());
    if (this.jdField_b_of_type_Bepp != null)
    {
      this.jdField_b_of_type_Bepp.c(true);
      this.jdField_b_of_type_Bepp.show();
    }
    this.app.addObserver(this.jdField_b_of_type_Apxc);
    ((apwv)this.app.a(127)).a(this.app.getCurrentAccountUin(), false);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo, send request");
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(getMainLooper());
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FriendProfileCardActivity.36(this), 10000L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo end");
    }
    return true;
  }
  
  private boolean h()
  {
    boolean bool = true;
    if (this.jdField_l_of_type_Boolean) {}
    Card localCard;
    do
    {
      return false;
      localCard = ((aloz)this.app.getManager(51)).b(this.app.c());
    } while (localCard == null);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "showExtendFriendProfileGuide: delaration:" + localCard.declaration + " isshowcard:" + localCard.isShowCard);
    }
    if ((TextUtils.isEmpty(localCard.declaration)) && (g())) {
      return true;
    }
    if ((TextUtils.isEmpty(localCard.declaration)) || (!localCard.isShowCard)) {
      if (!TextUtils.isEmpty(localCard.declaration)) {
        break label269;
      }
    }
    label267:
    label269:
    for (int i1 = 1;; i1 = 2)
    {
      this.jdField_b_of_type_AndroidAppDialog = aqdo.a(this, i1, new acvr(this, localCard));
      try
      {
        if (this.jdField_b_of_type_AndroidAppDialog != null) {
          this.jdField_b_of_type_AndroidAppDialog.show();
        }
        try
        {
          if (TextUtils.isEmpty(localCard.declaration)) {
            azmj.b(this.app, "dc00898", "", "", "0X80092EA", "0X80092EA", 0, 0, "", "", "", "");
          } else {
            azmj.b(this.app, "dc00898", "", "", "0X80092E7", "0X80092E7", 0, 0, "", "", "", "");
          }
        }
        catch (Exception localException1)
        {
          bool = true;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          bool = false;
        }
      }
      QLog.e("FriendProfileCardActivity", 1, "showProfileGuide fail.");
      break label267;
      bool = false;
      return bool;
    }
  }
  
  private boolean i()
  {
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      Object localObject = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131372287);
      if (localObject != null)
      {
        ((PerfRelativeLayout)this.jdField_e_of_type_AndroidViewView).removeView((View)localObject);
        localObject = "loginwelcome_" + this.app.c();
        localObject = getApplication().getSharedPreferences((String)localObject, 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("bubble_tips_time", 3);
        ((SharedPreferences.Editor)localObject).commit();
        return true;
      }
    }
    return false;
  }
  
  private void j(int paramInt)
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371056);
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131373523);
    if ((localTextView == null) || (localObject == null) || (((View)localObject).getHeight() == 0))
    {
      if (localTextView != null) {
        localTextView.setVisibility(4);
      }
      return;
    }
    localTextView.setText(paramInt);
    localTextView.setVisibility(0);
    paramInt = localTextView.getHeight();
    int i1 = ((View)localObject).getTop();
    localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131373523);
    ((RelativeLayout.LayoutParams)localObject).topMargin = (i1 - paramInt + aekt.a(7.0F, getResources()));
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localTextView.setOnClickListener(new acva(this, localTextView));
    ThreadManagerV2.getUIHandlerV2().postDelayed(new FriendProfileCardActivity.30(this, localTextView), 5000L);
    azmj.b(null, "dc00898", "", "", "qq_vip", "0X800A614", 0, 0, "", "", "", "");
  }
  
  private boolean j()
  {
    switch (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return false;
      Object localObject = (aloz)this.app.getManager(51);
      if (localObject == null) {}
      for (localObject = null; (localObject != null) && (((Friends)localObject).gathtertype == 1); localObject = ((aloz)localObject).a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
  }
  
  private void k(int paramInt)
  {
    if ((paramInt != 0) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (this.jdField_d_of_type_AndroidWidgetTextView == null)) {}
    while (f()) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.getChildAt(0);
    if (localObject1 != null) {
      ((View)localObject1).getLocalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    }
    paramInt = this.jdField_a_of_type_AndroidGraphicsRect.top;
    int i1 = this.jdField_d_of_type_AndroidWidgetTextView.getVisibility();
    Object localObject2 = null;
    if ((paramInt >= 0) && (paramInt > this.jdField_m_of_type_Int) && (paramInt >= this.jdField_l_of_type_Int) && (i1 == 4)) {
      localObject1 = this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
    }
    for (;;)
    {
      if ((localObject1 != null) && (localObject1 != this.jdField_d_of_type_AndroidWidgetTextView.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.jdField_d_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject1);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation((Animation)localObject1);
      }
      this.jdField_m_of_type_Int = paramInt;
      return;
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.jdField_m_of_type_Int)
        {
          localObject1 = localObject2;
          if (paramInt <= this.jdField_l_of_type_Int)
          {
            localObject1 = localObject2;
            if (i1 == 0) {
              localObject1 = this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
            }
          }
        }
      }
    }
  }
  
  public void A()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bepp.dismiss();
      label24:
      this.jdField_a_of_type_Bepp = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void B()
  {
    String str1;
    String str2;
    if (!isFinishing())
    {
      C();
      if (this.jdField_d_of_type_Int != 1) {
        break label67;
      }
      str1 = getString(2131695589);
      str2 = alpo.a(2131705305);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdfq = bdcd.a(this, 0, str1, str2, 2131695579, 2131695580, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_a_of_type_Bdfq.show();
      return;
      label67:
      if (this.jdField_d_of_type_Int == 2)
      {
        str1 = getString(2131695581);
        str2 = alpo.a(2131705311);
      }
      else if (this.jdField_d_of_type_Int == 3)
      {
        str1 = getString(2131699049);
        str2 = alpo.a(2131705282);
      }
      else if (this.jdField_d_of_type_Int == 4)
      {
        str1 = getString(2131720813);
        str2 = "开通QQ大会员即可使用该名片";
      }
      else
      {
        str1 = getString(2131695581);
        str2 = alpo.a(2131705315);
      }
    }
  }
  
  public void C()
  {
    if (this.jdField_a_of_type_Bdfq != null)
    {
      this.jdField_a_of_type_Bdfq.dismiss();
      this.jdField_a_of_type_Bdfq = null;
    }
  }
  
  void D()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)))
    {
      BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      Object localObject = bcyw.a(this, this.jdField_a_of_type_JavaLangString);
      localObject = "profilecard:" + (String)localObject;
      localObject = (Pair)BaseApplicationImpl.sImageCache.get(localObject);
      if ((localObject != null) && (((Pair)localObject).first != null) && (localBitmapDrawable.getConstantState() != ((Pair)localObject).first))
      {
        localBitmapDrawable.getBitmap().recycle();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      }
    }
  }
  
  public void E()
  {
    int i1 = 0;
    alkv localalkv = (alkv)this.app.a(2);
    if ((localalkv != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {}
    for (;;)
    {
      boolean bool;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        int i2 = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, String.format("reqFavorite cacheVoteNum=%s", new Object[] { Integer.valueOf(i2) }));
        }
        if (i2 > 0)
        {
          localalkv.a(Long.valueOf(this.app.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.vCookies, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.favoriteSource, i2, 0);
          bool = ((auri)this.app.getManager(207)).c(Long.valueOf(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.uin).longValue());
          if (PraiseManager.a(this.app) <= 0) {
            break label270;
          }
          if (bool)
          {
            i1 = 3;
            azmj.b(this.app, "CliOper", "", "", "P_prof", "Prof_good", 1, i2, i1, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), String.valueOf(i2), this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
          }
        }
        else
        {
          return;
        }
      }
      i1 = 2;
      continue;
      label270:
      if (bool) {
        i1 = 1;
      }
    }
  }
  
  public void F()
  {
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label110;
      }
      if (((PhoneContactManagerImp)this.app.getManager(11)).h())
      {
        localIntent = new Intent(this, SplashActivity.class);
        localIntent.putExtra("main_tab_id", 1);
        localIntent.setFlags(603979776);
        startActivity(localIntent);
      }
    }
    else
    {
      return;
    }
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("kSrouce", 10);
    startActivity(localIntent);
    return;
    label110:
    if (this.jdField_a_of_type_AndroidContentIntent == null)
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
  }
  
  void G()
  {
    ThreadManager.post(new FriendProfileCardActivity.58(this), 5, null, false);
    if ((this.jdField_c_of_type_AndroidWidgetTextView.getTag() instanceof awki))
    {
      Object localObject = (awki)this.jdField_c_of_type_AndroidWidgetTextView.getTag();
      if ((((awki)localObject).jdField_a_of_type_Int == 98) || (((awki)localObject).jdField_a_of_type_Int == 99))
      {
        localObject = bcyw.a();
        this.jdField_b_of_type_Bhow.obtainMessage(104, localObject).sendToTarget();
      }
    }
  }
  
  void H()
  {
    int i1 = 3;
    int i3 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int;
    int i2 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int;
    boolean bool;
    if (i3 == 0)
    {
      bool = true;
      if (!bool) {
        break label181;
      }
      if (i2 != 8) {
        break label124;
      }
      i1 = 1;
    }
    label181:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, String.format("handleReportEntryStatus isHost=%s fromType=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i1) }));
      }
      if (!bool) {
        break label285;
      }
      azmj.b(this.app, "dc00898", "", "", "0X8007EB3", "0X8007EB3", i1, 0, "", "", "", "");
      return;
      bool = false;
      break;
      label124:
      if (i2 == 1) {
        i1 = 2;
      } else if (i2 != 107) {
        if (i2 == 106)
        {
          i1 = 5;
        }
        else if (i2 == 7)
        {
          i1 = 6;
        }
        else if (i2 == 98)
        {
          i1 = 9;
        }
        else
        {
          i1 = 15;
          continue;
          if (i2 == 61) {
            i1 = 1;
          } else if (i2 == 1) {
            i1 = 2;
          } else if (i2 != 107) {
            if (i2 == 106) {
              i1 = 5;
            } else if (i2 == 109) {
              i1 = 6;
            } else if (i2 == 59) {
              i1 = 7;
            } else if (i2 == 98) {
              i1 = 9;
            } else if (i2 == 88) {
              i1 = 10;
            } else if (i2 == 7) {
              i1 = 11;
            } else {
              i1 = 15;
            }
          }
        }
      }
    }
    label285:
    if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {}
    for (String str1 = "2";; str1 = "1")
    {
      String str3 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      String str2 = str3;
      if (str3 == null) {
        str2 = "";
      }
      azmj.b(this.app, "dc00898", "", str2, "0X8007EB4", "0X8007EB4", i1, 0, "", "", str1, "");
      return;
    }
  }
  
  public void I()
  {
    ThreadManager.post(new FriendProfileCardActivity.61(this), 5, null, false);
  }
  
  public void J()
  {
    if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (f()))
    {
      i(0);
      return;
    }
    i(1);
  }
  
  public void K()
  {
    azmj.b(this.app, "CliOper", "", "", "0X800A9C2", "0X800A9C2", 0, 0, "", "", "", "");
    int i1;
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      i1 = 1;
      if (i1 != 0) {
        break label76;
      }
      g(0);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "gotoQQVipWeb xman  ");
      }
    }
    label76:
    do
    {
      return;
      i1 = 0;
      break;
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      localIntent.putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=card");
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("FriendProfileCardActivity", 2, "QQXMAN_URL_HOST_SETTING  " + "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=card");
  }
  
  Card a(String paramString1, String paramString2)
  {
    aloz localaloz = (aloz)this.app.getManager(51);
    paramString2 = localaloz.a(paramString2);
    if (paramString2 != null)
    {
      paramString1 = localaloz.c(paramString1);
      paramString1.strContactName = paramString2.strContactName;
      paramString1.strMobile = paramString2.mobileNo;
      paramString1.age = paramString2.bAge;
      paramString1.shAge = ((short)paramString2.bAge);
      paramString1.shGender = ((short)paramString2.bSex);
      paramString1.strProvince = paramString2.strProvince;
      paramString1.strCity = paramString2.strCity;
      paramString1.strCountry = paramString2.strCountry;
      localaloz.a(paramString1);
      return paramString1;
    }
    return null;
  }
  
  String a()
  {
    try
    {
      String str = ((PhoneContactManagerImp)this.app.getManager(11)).c(a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)).uin;
      return str;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
      }
    }
    return null;
  }
  
  public String a(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (!paramString.startsWith("+"))
      {
        localObject = paramString;
        if (paramString.length() == 11)
        {
          localObject = paramString;
          if (!paramString.startsWith("0"))
          {
            localObject = ((aubm)this.app.getManager(11)).a();
            if ((localObject == null) || (TextUtils.isEmpty(((RespondQueryQQBindingStat)localObject).nationCode))) {
              break label100;
            }
            localObject = ((RespondQueryQQBindingStat)localObject).nationCode + paramString.trim();
          }
        }
      }
    }
    return localObject;
    label100:
    return "+86" + paramString.trim();
  }
  
  public void a()
  {
    Object localObject;
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "send async message to init card in db");
      }
      localObject = bhoh.a;
      if ((localObject != null) && (((bhoh)localObject).a())) {
        ((bhoh)localObject).a(4);
      }
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bhow != null)
      {
        localObject = null;
        if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
          break label180;
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_Bhow.sendMessage((Message)localObject);
      }
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71)) {
        azmj.b(this.app, "CliOper", "", "", "Network_circle", "Network_circle_prof", a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int), "", "");
      }
      return;
      label180:
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)
      {
        localObject = this.jdField_a_of_type_Bhow.obtainMessage();
        ((Message)localObject).what = 9;
        ((Message)localObject).obj = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      else if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject = this.jdField_a_of_type_Bhow.obtainMessage();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      else
      {
        localObject = this.jdField_a_of_type_Bhow.obtainMessage();
        ((Message)localObject).what = 2;
        ((Message)localObject).obj = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  protected void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_Int == 7))
    {
      int i1 = this.jdField_b_of_type_AndroidContentIntent.getIntExtra("memberOperationFlag", 0);
      this.jdField_b_of_type_AndroidContentIntent.putExtra("memberOperationFlag", i1 | paramInt);
      this.jdField_b_of_type_AndroidContentIntent.putExtra("memberOperateUin", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      setResult(-1, this.jdField_b_of_type_AndroidContentIntent);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    A();
    z();
    bcyw.a(this.app, paramLong1, paramLong2, null, paramLong3, paramString);
    this.jdField_b_of_type_Bhow.postDelayed(this.jdField_b_of_type_JavaLangRunnable, this.jdField_j_of_type_Int);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "requestUpdateCard() mHasTriedCount = " + this.jdField_i_of_type_Int);
    }
    if ((this.jdField_i_of_type_Int > 5) && (!paramBoolean)) {}
    alkv localalkv;
    do
    {
      return;
      localalkv = (alkv)this.app.a(2);
    } while (localalkv == null);
    this.jdField_i_of_type_Int += 1;
    byte[] arrayOfByte1;
    if (paramArrayOfByte1 == null)
    {
      arrayOfByte1 = new byte[1];
      arrayOfByte1[0] = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte2;
      if (paramArrayOfByte2 == null)
      {
        arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = 0;
      }
      for (;;)
      {
        int i1 = 12;
        byte b1 = 0;
        paramArrayOfByte1 = (anuj)this.app.getManager(112);
        if (paramArrayOfByte1 != null) {}
        for (paramBoolean = paramArrayOfByte1.a(1);; paramBoolean = false)
        {
          long l3 = a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, paramBoolean);
          switch (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
          case 18: 
          case 33: 
          case 38: 
          case 39: 
          case 43: 
          case 44: 
          case 48: 
          case 49: 
          case 54: 
          case 59: 
          case 62: 
          case 63: 
          case 64: 
          case 65: 
          case 66: 
          case 67: 
          case 68: 
          case 69: 
          case 76: 
          case 79: 
          case 85: 
          case 87: 
          case 88: 
          case 89: 
          case 90: 
          case 91: 
          case 92: 
          case 93: 
          case 94: 
          case 99: 
          case 100: 
          case 106: 
          case 109: 
          case 114: 
          case 116: 
          case 117: 
          case 118: 
          case 119: 
          default: 
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 65535, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3999, arrayOfByte2, (byte)0);
            return;
          case 0: 
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 60: 
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 26, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 1: 
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 78: 
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 3022, arrayOfByte2, (byte)0);
            return;
          case 40: 
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 41: 
            i1 = 6;
            paramArrayOfByte1 = "";
            if ((TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
            {
              i1 = 37;
              paramArrayOfByte1 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o;
            }
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i1, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 42: 
          case 73: 
          case 86: 
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 8, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 36: 
            localalkv.a(this.app.getCurrentAccountUin(), "0", 32, paramLong, (byte)0, 0L, 0L, arrayOfByte1, a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne), l3, 3014, arrayOfByte2, (byte)0);
            return;
          case 30: 
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 15, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            return;
          case 29: 
          case 31: 
          case 32: 
          case 34: 
          case 50: 
          case 51: 
          case 53: 
            i1 = 16;
            if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) {
              i1 = 17;
            }
            if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {
              i1 = 50;
            }
            break;
          }
          for (;;)
          {
            paramArrayOfByte1 = a(a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
            localalkv.a(this.app.getCurrentAccountUin(), "0", i1, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, null, (byte)0);
            return;
            ((awvt)this.app.a(79)).a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            return;
            if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString == null) {
              break;
            }
            long l2 = 0L;
            try
            {
              l1 = Long.valueOf(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString).longValue();
              int i2 = 0;
              if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 45)
              {
                i1 = 13;
                i2 = 1;
                paramArrayOfByte1 = this.app.getCurrentAccountUin();
                paramArrayOfByte2 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
                if (i2 != 1) {
                  break label1432;
                }
                b1 = this.jdField_a_of_type_Byte;
                localalkv.a(paramArrayOfByte1, paramArrayOfByte2, i1, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, b1);
              }
            }
            catch (Exception paramArrayOfByte1)
            {
              for (;;)
              {
                l1 = l2;
                if (QLog.isColorLevel())
                {
                  QLog.i("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                  l1 = l2;
                  continue;
                  if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
                  {
                    i1 = 4;
                  }
                  else
                  {
                    i1 = 14;
                    continue;
                    label1432:
                    b1 = 0;
                  }
                }
              }
            }
            long l1 = bcyw.a(this.app, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20)
            {
              i1 = 2;
              b1 = 1;
              paramArrayOfByte1 = this.app.getCurrentAccountUin();
              paramArrayOfByte2 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
              if (b1 != 1) {
                break label1601;
              }
            }
            label1601:
            for (byte b2 = this.jdField_a_of_type_Byte;; b2 = 0)
            {
              localalkv.a(paramArrayOfByte1, paramArrayOfByte2, i1, paramLong, b1, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, b2);
              return;
              if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
              {
                i1 = 5;
                b1 = 0;
                break;
              }
              if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 22) {
                break;
              }
              i1 = 7;
              b1 = 0;
              break;
            }
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 21, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 31, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3001, arrayOfByte2, (byte)0);
            return;
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 38, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3017, arrayOfByte2, (byte)0);
            return;
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 27, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 36, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int == 3004) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int == 2004)) {
              if (TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString)) {}
            }
            label2817:
            for (paramArrayOfByte1 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;; paramArrayOfByte1 = "0")
            {
              paramArrayOfByte2 = paramArrayOfByte1;
              if (paramArrayOfByte1 == null) {}
              label2809:
              for (paramArrayOfByte2 = "0";; paramArrayOfByte2 = "0")
              {
                for (;;)
                {
                  l2 = 0L;
                  try
                  {
                    l1 = Long.parseLong(paramArrayOfByte2);
                    i1 = 11;
                    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27) {
                      i1 = 35;
                    }
                    localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i1, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int, arrayOfByte2, (byte)0);
                    return;
                    if (TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
                      break label2817;
                    }
                    paramArrayOfByte1 = (TroopInfo)this.app.getEntityManagerFactory().createEntityManager().a(TroopInfo.class, "troopcode=?", new String[] { this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString });
                    if (paramArrayOfByte1 == null) {
                      break label2817;
                    }
                    paramArrayOfByte1 = paramArrayOfByte1.troopuin;
                    break;
                    if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 3005) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 2005)) {
                      break label2809;
                    }
                    paramArrayOfByte2 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString;
                  }
                  catch (Exception paramArrayOfByte1)
                  {
                    for (;;)
                    {
                      l1 = l2;
                      if (QLog.isColorLevel())
                      {
                        QLog.e("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                        l1 = l2;
                      }
                    }
                  }
                }
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3095, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3096, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 28, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 29, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 30, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 34, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 33, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3045, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 53, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3094, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3004, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3004, arrayOfByte2, (byte)0);
                return;
                localalkv.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3080, arrayOfByte2, (byte)0);
                return;
              }
            }
          }
        }
        arrayOfByte2 = paramArrayOfByte2;
      }
      arrayOfByte1 = paramArrayOfByte1;
    }
  }
  
  public void a(SSummaryCardRsp paramSSummaryCardRsp)
  {
    if (!isFinishing())
    {
      if (TextUtils.isEmpty(paramSSummaryCardRsp.strActiveCardUrl)) {
        break label144;
      }
      if (!QLog.isColorLevel()) {
        break label92;
      }
      QLog.e("QVipProfileCard.FriendProfileCardActivity", 1, "set friend profile card failed code=" + paramSSummaryCardRsp.res + " bgid=" + paramSSummaryCardRsp.bgid + " and jump to " + paramSSummaryCardRsp.strActiveCardUrl);
    }
    for (;;)
    {
      bcyw.a(this, paramSSummaryCardRsp.bgid, paramSSummaryCardRsp.strActiveCardUrl);
      return;
      label92:
      QLog.e("QVipProfileCard.FriendProfileCardActivity", 1, "set friend profile card failed code=" + paramSSummaryCardRsp.res + " bgid=" + paramSSummaryCardRsp.bgid + " and jump to url");
    }
    label144:
    C();
    String str1 = getString(2131699049);
    String str2 = paramSSummaryCardRsp.emsg;
    int i1 = paramSSummaryCardRsp.payType;
    String str3 = paramSSummaryCardRsp.aid;
    if ((TextUtils.isEmpty(str3)) || (i1 <= 0) || (i1 == 3) || (i1 > 7))
    {
      QLog.e("QVipProfileCard.FriendProfileCardActivity", 1, "set friend profile card failed code=" + paramSSummaryCardRsp.res + " and aid=" + str3 + " pay type=" + i1);
      Toast.makeText(getApplicationContext(), 2131695635, 0).show();
      return;
    }
    QLog.e("QVipProfileCard.FriendProfileCardActivity", 1, "set friend profile card show:" + str2 + " and aid=" + str3 + " pay type=" + i1);
    this.jdField_a_of_type_Bdfq = bdcd.a(this, 0, str1, str2, 2131695579, 2131695580, new acwb(this, str3, i1), this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_Bdfq.show();
  }
  
  public void a(acwo paramacwo)
  {
    this.jdField_a_of_type_Acwo = paramacwo;
  }
  
  public void a(Context paramContext)
  {
    try
    {
      Object localObject2 = Class.forName("android.util.GeneralUtil");
      Field localField = ((Class)localObject2).getDeclaredField("myInstance");
      localField.setAccessible(true);
      Object localObject1 = localField.get(null);
      if (localObject1 != null)
      {
        localObject2 = ((Class)localObject2).getDeclaredField("ctxt");
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Field)localObject2).get(localObject1);
        if (localObject2 == paramContext) {
          localField.set(null, null);
        }
        if (QLog.isColorLevel()) {
          QLog.i("FriendProfileCardActivity", 2, String.format("fixGeneralUtilLeakContext ctxt:%s", new Object[] { localObject2 }));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, String.format("fixGeneralUtilLeakContext myInstance:%s", new Object[] { localObject1 }));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (!QLog.isColorLevel()) {}
      paramContext.printStackTrace();
      QLog.i("FriendProfileCardActivity", 2, String.format("fixGeneralUtilLeakContext Exception:%s", new Object[] { paramContext.toString() }));
    }
  }
  
  protected void a(Intent paramIntent)
  {
    try
    {
      Object localObject = paramIntent.getComponent();
      if ((localObject != null) && (TextUtils.equals(((ComponentName)localObject).getClassName(), QQBrowserActivity.class.getName())))
      {
        localObject = paramIntent.getStringExtra("url");
        String str = paramIntent.getStringExtra("big_brother_source_key");
        if (TextUtils.isEmpty(str)) {
          paramIntent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
        }
        if (QLog.isColorLevel()) {
          QLog.i("FriendProfileCardActivity", 2, String.format("dealIntent key: %s, url: %s", new Object[] { str, localObject }));
        }
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView, paramInt1, getString(paramInt2), paramInt3, getString(paramInt4), 0);
  }
  
  void a(View paramView, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    int i1 = 2131166932;
    if (paramView == null) {}
    do
    {
      return;
      awki localawki = new awki(paramInt1, null);
      paramView.setVisibility(0);
      if (paramInt2 == 0)
      {
        paramView = (ImageButton)paramView.findViewById(2131368042);
        paramView.setTag(localawki);
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.setImageResource(paramInt3);
        paramView.setContentDescription(paramString2);
        return;
      }
      paramView = (Button)paramView.findViewById(2131379049);
      paramView.setTag(localawki);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(paramString2);
      paramView.setText(paramString1);
      if ((!a(paramInt1)) || (this.jdField_e_of_type_Boolean)) {
        break;
      }
      paramView.setTextColor(getResources().getColor(2131166975));
      paramView.setEnabled(this.jdField_e_of_type_Boolean);
    } while ((7 != paramInt1) || (!QSecFramework.a().a(1001).booleanValue()));
    QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(1), paramView }, null);
    return;
    if (paramInt2 == 2)
    {
      paramInt2 = 2131166932;
      label201:
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label239;
      }
      paramInt2 = i1;
    }
    label239:
    for (;;)
    {
      paramView.setTextColor(getResources().getColor(paramInt2));
      break;
      paramInt2 = 2131166934;
      break label201;
    }
  }
  
  public void a(View paramView, long paramLong1, long paramLong2)
  {
    a(paramView, paramLong1, paramLong2, 0L, null);
  }
  
  void a(View paramView, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (paramView != null))
    {
      if (this.jdField_b_of_type_Bhow != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "changeProfileHeaderView success remove timeout msg");
        }
        this.jdField_b_of_type_Bhow.removeMessages(10);
      }
      Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368230);
      if (localObject != null) {}
      try
      {
        localObject = (Animatable)((ImageView)localObject).getDrawable();
        if ((localObject != null) && (((Animatable)localObject).isRunning())) {
          ((Animatable)localObject).stop();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i2;
          int i1;
          localException.printStackTrace();
        }
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView);
        this.jdField_c_of_type_Boolean = true;
        this.jdField_c_of_type_Long = paramLong1;
        this.jdField_d_of_type_Long = paramLong2;
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_e_of_type_Long = paramLong3;
        if ((paramView == null) || (!(paramView instanceof ProfileBaseView)) || (!QSecFramework.a().a(1001).booleanValue())) {
          break label273;
        }
        paramView = (View)((ProfileBaseView)paramView).jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
        QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(24), paramView }, null);
      }
      i2 = this.jdField_a_of_type_AndroidViewViewGroup.getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        localObject = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i1);
        if ((localObject instanceof ProfileHeaderView)) {
          ((ProfileHeaderView)localObject).c();
        }
        i1 += 1;
      }
    }
    label273:
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.e();
    if ((!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) && (this.jdField_b_of_type_AndroidViewView != null)) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_Bdjk.a("headerViewLoadingEnd", false);
  }
  
  void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    this.jdField_f_of_type_AndroidViewView = null;
    int i1 = getResources().getDimensionPixelSize(2131296619);
    int i2 = getResources().getDimensionPixelSize(2131296619);
    if ((this.jdField_a_of_type_Awmk != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2131561806, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_f_of_type_AndroidViewView).c(30).d(30).a();
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          i();
        }
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2131561806, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i1;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2131561144, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i1;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)
      {
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2131561155, null);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2131561216, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2131561216, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2131561216, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
        this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2131561144, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_f_of_type_AndroidViewView, localLayoutParams);
      }
    }
  }
  
  public void a(awkn paramawkn)
  {
    this.jdField_a_of_type_Awkn = paramawkn;
  }
  
  /* Error */
  public void a(awmk paramawmk)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 2351	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Bdjk	Lbdjk;
    //   6: ldc_w 2404
    //   9: iconst_1
    //   10: invokevirtual 2358	bdjk:a	(Ljava/lang/String;Z)V
    //   13: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +30 -> 46
    //   19: ldc_w 495
    //   22: iconst_2
    //   23: ldc_w 2406
    //   26: iconst_1
    //   27: anewarray 126	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 158	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_c_of_type_Boolean	Z
    //   36: invokestatic 1139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   39: aastore
    //   40: invokestatic 858	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   43: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: getfield 158	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_c_of_type_Boolean	Z
    //   50: iconst_1
    //   51: if_icmpeq +21 -> 72
    //   54: aload_1
    //   55: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   58: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   61: ldc_w 2016
    //   64: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: istore_3
    //   68: iload_3
    //   69: ifeq +6 -> 75
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: aload_1
    //   76: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   79: astore 6
    //   81: aload 6
    //   83: ifnull +74 -> 157
    //   86: invokestatic 2411	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   89: lstore 4
    //   91: lload 4
    //   93: aload_0
    //   94: getfield 203	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_n_of_type_Long	J
    //   97: lsub
    //   98: invokestatic 2417	java/lang/Math:abs	(J)J
    //   101: ldc2_w 2418
    //   104: lcmp
    //   105: ifle +234 -> 339
    //   108: aload_0
    //   109: lload 4
    //   111: putfield 203	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_n_of_type_Long	J
    //   114: aload_0
    //   115: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   118: iconst_2
    //   119: invokevirtual 529	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   122: checkcast 1850	alkv
    //   125: astore 6
    //   127: aload 6
    //   129: ifnull +28 -> 157
    //   132: aload_1
    //   133: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   136: getfield 517	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   139: invokestatic 2423	bdje:a	(Ljava/lang/String;)Z
    //   142: ifne +15 -> 157
    //   145: aload 6
    //   147: aload_1
    //   148: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   151: getfield 517	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   154: invokevirtual 2424	alkv:a	(Ljava/lang/String;)V
    //   157: aload_1
    //   158: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   161: astore 6
    //   163: aload 6
    //   165: ifnull +900 -> 1065
    //   168: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +36 -> 207
    //   174: ldc_w 2426
    //   177: iconst_1
    //   178: new 404	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 2428
    //   188: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_1
    //   192: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   195: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   198: invokevirtual 2146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   201: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: invokestatic 2434	azib:b	()Z
    //   210: ifeq +181 -> 391
    //   213: ldc_w 495
    //   216: iconst_1
    //   217: ldc_w 2436
    //   220: invokestatic 561	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: iconst_0
    //   224: istore_2
    //   225: iload_2
    //   226: ifne +55 -> 281
    //   229: aload_1
    //   230: aconst_null
    //   231: putfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   234: aload_0
    //   235: getfield 1099	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   238: aconst_null
    //   239: putfield 2440	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Awmr	Lawmr;
    //   242: aload_0
    //   243: new 2336	com/tencent/mobileqq/profile/view/ProfileBaseView
    //   246: dup
    //   247: aload_0
    //   248: aload_1
    //   249: aload_0
    //   250: getfield 1741	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   253: aload_0
    //   254: getfield 2442	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   257: aload_0
    //   258: getfield 1478	com/tencent/mobileqq/activity/FriendProfileCardActivity:q	Z
    //   261: invokespecial 2445	com/tencent/mobileqq/profile/view/ProfileBaseView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/widget/TextView;Z)V
    //   264: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   267: aload_0
    //   268: aload_0
    //   269: getfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   272: lconst_0
    //   273: lconst_0
    //   274: invokevirtual 2447	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Landroid/view/View;JJ)V
    //   277: aload_0
    //   278: invokevirtual 2449	com/tencent/mobileqq/activity/FriendProfileCardActivity:t	()V
    //   281: aload_0
    //   282: getfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   285: ifnull +32 -> 317
    //   288: aload_0
    //   289: getfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   292: getfield 2450	com/tencent/mobileqq/profile/view/ProfileHeaderView:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   295: ldc_w 2452
    //   298: aload_0
    //   299: ldc_w 2453
    //   302: invokevirtual 2454	com/tencent/mobileqq/activity/FriendProfileCardActivity:findViewById	(I)Landroid/view/View;
    //   305: invokevirtual 2458	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   308: pop
    //   309: aload_0
    //   310: getfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   313: aload_1
    //   314: invokevirtual 2460	com/tencent/mobileqq/profile/view/ProfileHeaderView:g	(Lawmk;)V
    //   317: aload_0
    //   318: getfield 2351	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Bdjk	Lbdjk;
    //   321: ldc_w 2462
    //   324: ldc_w 2404
    //   327: iconst_0
    //   328: invokevirtual 2465	bdjk:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   331: goto -259 -> 72
    //   334: astore_1
    //   335: aload_0
    //   336: monitorexit
    //   337: aload_1
    //   338: athrow
    //   339: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq -185 -> 157
    //   345: ldc_w 495
    //   348: iconst_2
    //   349: ldc_w 2467
    //   352: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: goto -198 -> 157
    //   358: astore 6
    //   360: ldc_w 495
    //   363: iconst_1
    //   364: new 404	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   371: ldc_w 2469
    //   374: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload 6
    //   379: invokevirtual 2472	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 499	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: goto -231 -> 157
    //   391: aload_1
    //   392: getfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   395: ifnull +537 -> 932
    //   398: aload_1
    //   399: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   402: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   405: lstore 4
    //   407: aload_0
    //   408: getfield 1099	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   411: aload_1
    //   412: getfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   415: putfield 2440	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Awmr	Lawmr;
    //   418: lload 4
    //   420: getstatic 2475	awmr:jdField_b_of_type_Long	J
    //   423: lcmp
    //   424: ifeq +21 -> 445
    //   427: lload 4
    //   429: getstatic 2476	awmr:jdField_c_of_type_Long	J
    //   432: lcmp
    //   433: ifeq +12 -> 445
    //   436: lload 4
    //   438: getstatic 2477	awmr:jdField_d_of_type_Long	J
    //   441: lcmp
    //   442: ifne +105 -> 547
    //   445: aload_0
    //   446: new 2479	com/tencent/mobileqq/profile/view/ProfileGameView
    //   449: dup
    //   450: aload_0
    //   451: aload_1
    //   452: invokespecial 2482	com/tencent/mobileqq/profile/view/ProfileGameView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;)V
    //   455: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   458: aload_0
    //   459: lload 4
    //   461: putfield 2484	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_f_of_type_Long	J
    //   464: aload_0
    //   465: aload_1
    //   466: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   469: invokestatic 2487	awmr:a	(Lcom/tencent/mobileqq/data/Card;)J
    //   472: putfield 2489	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_g_of_type_Long	J
    //   475: aload_0
    //   476: aload_1
    //   477: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   480: invokevirtual 2493	com/tencent/mobileqq/data/Card:getBgTypeArray	()Ljava/util/ArrayList;
    //   483: putfield 2494	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   486: aload_0
    //   487: aload_0
    //   488: getfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   491: aload_1
    //   492: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   495: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   498: aload_1
    //   499: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   502: getfield 2497	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   505: aload_1
    //   506: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   509: getfield 2500	com/tencent/mobileqq/data/Card:backgroundColor	J
    //   512: aload_1
    //   513: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   516: getfield 2503	com/tencent/mobileqq/data/Card:strExtInfo	Ljava/lang/String;
    //   519: invokevirtual 2297	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Landroid/view/View;JJJLjava/lang/String;)V
    //   522: aload_0
    //   523: invokevirtual 2449	com/tencent/mobileqq/activity/FriendProfileCardActivity:t	()V
    //   526: aload_0
    //   527: invokevirtual 1893	com/tencent/mobileqq/activity/FriendProfileCardActivity:getIntent	()Landroid/content/Intent;
    //   530: ldc_w 2505
    //   533: iconst_0
    //   534: invokevirtual 1408	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   537: ifne +708 -> 1245
    //   540: aload_0
    //   541: invokevirtual 2507	com/tencent/mobileqq/activity/FriendProfileCardActivity:u	()V
    //   544: goto +701 -> 1245
    //   547: lload 4
    //   549: getstatic 2508	awmr:jdField_e_of_type_Long	J
    //   552: lcmp
    //   553: ifne +68 -> 621
    //   556: aload_0
    //   557: new 2510	com/tencent/mobileqq/profile/view/ProfilePhotoView
    //   560: dup
    //   561: aload_0
    //   562: aload_1
    //   563: invokespecial 2511	com/tencent/mobileqq/profile/view/ProfilePhotoView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;)V
    //   566: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   569: goto -111 -> 458
    //   572: astore 6
    //   574: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq +34 -> 611
    //   580: ldc_w 495
    //   583: iconst_2
    //   584: new 404	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 2513
    //   594: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 6
    //   599: invokevirtual 559	java/lang/Exception:toString	()Ljava/lang/String;
    //   602: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: aload 6
    //   613: invokevirtual 1185	java/lang/Exception:printStackTrace	()V
    //   616: iconst_0
    //   617: istore_2
    //   618: goto -393 -> 225
    //   621: lload 4
    //   623: getstatic 2514	awmr:jdField_f_of_type_Long	J
    //   626: lcmp
    //   627: ifne +19 -> 646
    //   630: aload_0
    //   631: new 2516	com/tencent/mobileqq/profile/view/ProfileTagView
    //   634: dup
    //   635: aload_0
    //   636: aload_1
    //   637: invokespecial 2517	com/tencent/mobileqq/profile/view/ProfileTagView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;)V
    //   640: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   643: goto -185 -> 458
    //   646: aload_1
    //   647: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   650: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   653: getstatic 2519	awmr:jdField_k_of_type_Long	J
    //   656: lcmp
    //   657: ifne +31 -> 688
    //   660: aload_0
    //   661: new 2521	com/tencent/mobileqq/profile/view/ProfileQVipV5View
    //   664: dup
    //   665: aload_0
    //   666: aload_1
    //   667: aload_0
    //   668: getfield 1741	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   671: aload_0
    //   672: getfield 2442	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   675: aload_0
    //   676: getfield 1478	com/tencent/mobileqq/activity/FriendProfileCardActivity:q	Z
    //   679: invokespecial 2522	com/tencent/mobileqq/profile/view/ProfileQVipV5View:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/widget/TextView;Z)V
    //   682: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   685: goto -227 -> 458
    //   688: aload_1
    //   689: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   692: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   695: invokestatic 2524	awmr:a	(J)Z
    //   698: ifeq +48 -> 746
    //   701: aload_0
    //   702: new 2526	com/tencent/mobileqq/profile/view/ProfileQVipDiyView
    //   705: dup
    //   706: aload_0
    //   707: aload_1
    //   708: aload_0
    //   709: getfield 1741	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   712: aload_0
    //   713: getfield 713	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   716: checkcast 715	com/tencent/mobileqq/widget/PerfRelativeLayout
    //   719: aload_0
    //   720: getfield 2528	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   723: aload_0
    //   724: getfield 1099	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   727: invokespecial 2531	com/tencent/mobileqq/profile/view/ProfileQVipDiyView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/view/ViewGroup;Landroid/widget/FrameLayout;Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;)V
    //   730: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   733: aload_0
    //   734: getfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   737: checkcast 2526	com/tencent/mobileqq/profile/view/ProfileQVipDiyView
    //   740: invokevirtual 2532	com/tencent/mobileqq/profile/view/ProfileQVipDiyView:e	()V
    //   743: goto -285 -> 458
    //   746: lload 4
    //   748: getstatic 2533	awmr:jdField_g_of_type_Long	J
    //   751: lcmp
    //   752: ifne +19 -> 771
    //   755: aload_0
    //   756: new 2535	com/tencent/mobileqq/profile/view/VipProfileSimpleView
    //   759: dup
    //   760: aload_0
    //   761: aload_1
    //   762: invokespecial 2536	com/tencent/mobileqq/profile/view/VipProfileSimpleView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;)V
    //   765: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   768: goto -310 -> 458
    //   771: lload 4
    //   773: getstatic 2538	awmr:jdField_h_of_type_Long	J
    //   776: lcmp
    //   777: ifne +80 -> 857
    //   780: aload_0
    //   781: ldc 184
    //   783: iconst_0
    //   784: invokevirtual 2539	com/tencent/mobileqq/activity/FriendProfileCardActivity:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   787: aload_0
    //   788: getfield 186	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   791: iconst_1
    //   792: invokeinterface 755 3 0
    //   797: ifeq +19 -> 816
    //   800: aload_0
    //   801: new 2541	com/tencent/mobileqq/profile/view/ProfileShoppingView
    //   804: dup
    //   805: aload_0
    //   806: aload_1
    //   807: invokespecial 2542	com/tencent/mobileqq/profile/view/ProfileShoppingView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;)V
    //   810: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   813: goto -355 -> 458
    //   816: aload_1
    //   817: aconst_null
    //   818: putfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   821: aload_0
    //   822: getfield 1099	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   825: aconst_null
    //   826: putfield 2440	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Awmr	Lawmr;
    //   829: aload_0
    //   830: new 2336	com/tencent/mobileqq/profile/view/ProfileBaseView
    //   833: dup
    //   834: aload_0
    //   835: aload_1
    //   836: aload_0
    //   837: getfield 1741	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   840: aload_0
    //   841: getfield 2442	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   844: aload_0
    //   845: getfield 1478	com/tencent/mobileqq/activity/FriendProfileCardActivity:q	Z
    //   848: invokespecial 2445	com/tencent/mobileqq/profile/view/ProfileBaseView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/widget/TextView;Z)V
    //   851: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   854: goto -396 -> 458
    //   857: lload 4
    //   859: getstatic 2543	awmr:jdField_j_of_type_Long	J
    //   862: lcmp
    //   863: ifeq +12 -> 875
    //   866: lload 4
    //   868: getstatic 2545	awmr:jdField_i_of_type_Long	J
    //   871: lcmp
    //   872: ifne +19 -> 891
    //   875: aload_0
    //   876: new 2547	com/tencent/mobileqq/profile/view/VipProfileWZRYView
    //   879: dup
    //   880: aload_0
    //   881: aload_1
    //   882: invokespecial 2548	com/tencent/mobileqq/profile/view/VipProfileWZRYView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;)V
    //   885: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   888: goto -430 -> 458
    //   891: aload_1
    //   892: aconst_null
    //   893: putfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   896: aload_0
    //   897: getfield 1099	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   900: aconst_null
    //   901: putfield 2440	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Awmr	Lawmr;
    //   904: aload_0
    //   905: new 2336	com/tencent/mobileqq/profile/view/ProfileBaseView
    //   908: dup
    //   909: aload_0
    //   910: aload_1
    //   911: aload_0
    //   912: getfield 1741	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   915: aload_0
    //   916: getfield 2442	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   919: aload_0
    //   920: getfield 1478	com/tencent/mobileqq/activity/FriendProfileCardActivity:q	Z
    //   923: invokespecial 2445	com/tencent/mobileqq/profile/view/ProfileBaseView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/widget/TextView;Z)V
    //   926: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   929: goto -471 -> 458
    //   932: aload_1
    //   933: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   936: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   939: invokestatic 2524	awmr:a	(J)Z
    //   942: ifeq -326 -> 616
    //   945: aload_0
    //   946: new 2526	com/tencent/mobileqq/profile/view/ProfileQVipDiyView
    //   949: dup
    //   950: aload_0
    //   951: aload_1
    //   952: aload_0
    //   953: getfield 1741	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   956: aload_0
    //   957: getfield 713	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   960: checkcast 715	com/tencent/mobileqq/widget/PerfRelativeLayout
    //   963: aload_0
    //   964: getfield 2528	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   967: aload_0
    //   968: getfield 1099	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   971: invokespecial 2531	com/tencent/mobileqq/profile/view/ProfileQVipDiyView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/view/ViewGroup;Landroid/widget/FrameLayout;Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;)V
    //   974: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   977: aload_0
    //   978: aload_1
    //   979: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   982: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   985: putfield 2484	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_f_of_type_Long	J
    //   988: aload_0
    //   989: aload_1
    //   990: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   993: invokestatic 2487	awmr:a	(Lcom/tencent/mobileqq/data/Card;)J
    //   996: putfield 2489	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_g_of_type_Long	J
    //   999: aload_0
    //   1000: aload_1
    //   1001: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   1004: invokevirtual 2493	com/tencent/mobileqq/data/Card:getBgTypeArray	()Ljava/util/ArrayList;
    //   1007: putfield 2494	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1010: aload_0
    //   1011: aload_0
    //   1012: getfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   1015: aload_1
    //   1016: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   1019: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   1022: aload_1
    //   1023: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   1026: getfield 2497	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   1029: aload_1
    //   1030: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   1033: getfield 2500	com/tencent/mobileqq/data/Card:backgroundColor	J
    //   1036: aload_1
    //   1037: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   1040: getfield 2503	com/tencent/mobileqq/data/Card:strExtInfo	Ljava/lang/String;
    //   1043: invokevirtual 2297	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Landroid/view/View;JJJLjava/lang/String;)V
    //   1046: aload_0
    //   1047: getfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   1050: checkcast 2526	com/tencent/mobileqq/profile/view/ProfileQVipDiyView
    //   1053: invokevirtual 2532	com/tencent/mobileqq/profile/view/ProfileQVipDiyView:e	()V
    //   1056: aload_0
    //   1057: invokevirtual 2449	com/tencent/mobileqq/activity/FriendProfileCardActivity:t	()V
    //   1060: iconst_1
    //   1061: istore_2
    //   1062: goto -837 -> 225
    //   1065: aload_1
    //   1066: getfield 1294	awmk:jdField_a_of_type_ComTencentMobileqqDataContactCard	Lcom/tencent/mobileqq/data/ContactCard;
    //   1069: ifnonnull +15 -> 1084
    //   1072: aload_1
    //   1073: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1076: getfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1079: bipush 33
    //   1081: if_icmpne +74 -> 1155
    //   1084: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq +13 -> 1100
    //   1090: ldc_w 402
    //   1093: iconst_2
    //   1094: ldc_w 2550
    //   1097: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1100: aload_0
    //   1101: getfield 1099	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   1104: aconst_null
    //   1105: putfield 2440	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Awmr	Lawmr;
    //   1108: aload_1
    //   1109: aconst_null
    //   1110: putfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   1113: aload_0
    //   1114: new 2336	com/tencent/mobileqq/profile/view/ProfileBaseView
    //   1117: dup
    //   1118: aload_0
    //   1119: aload_1
    //   1120: aload_0
    //   1121: getfield 1741	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   1124: aload_0
    //   1125: getfield 2442	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1128: aload_0
    //   1129: getfield 1478	com/tencent/mobileqq/activity/FriendProfileCardActivity:q	Z
    //   1132: invokespecial 2445	com/tencent/mobileqq/profile/view/ProfileBaseView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/widget/TextView;Z)V
    //   1135: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   1138: aload_0
    //   1139: aload_0
    //   1140: getfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   1143: lconst_0
    //   1144: lconst_0
    //   1145: invokevirtual 2447	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Landroid/view/View;JJ)V
    //   1148: aload_0
    //   1149: invokevirtual 2449	com/tencent/mobileqq/activity/FriendProfileCardActivity:t	()V
    //   1152: goto -871 -> 281
    //   1155: aload_1
    //   1156: getfield 2553	awmk:jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo	Lcom/tencent/mobileqq/qcall/QCallCardInfo;
    //   1159: ifnonnull +15 -> 1174
    //   1162: aload_1
    //   1163: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1166: getfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1169: bipush 80
    //   1171: if_icmpne -890 -> 281
    //   1174: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1177: ifeq +13 -> 1190
    //   1180: ldc_w 402
    //   1183: iconst_2
    //   1184: ldc_w 2555
    //   1187: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1190: aload_0
    //   1191: getfield 1099	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   1194: aconst_null
    //   1195: putfield 2440	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:jdField_a_of_type_Awmr	Lawmr;
    //   1198: aload_1
    //   1199: aconst_null
    //   1200: putfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   1203: aload_0
    //   1204: new 2336	com/tencent/mobileqq/profile/view/ProfileBaseView
    //   1207: dup
    //   1208: aload_0
    //   1209: aload_1
    //   1210: aload_0
    //   1211: getfield 1741	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   1214: aload_0
    //   1215: getfield 2442	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1218: aload_0
    //   1219: getfield 1478	com/tencent/mobileqq/activity/FriendProfileCardActivity:q	Z
    //   1222: invokespecial 2445	com/tencent/mobileqq/profile/view/ProfileBaseView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lawmk;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/widget/TextView;Z)V
    //   1225: putfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   1228: aload_0
    //   1229: aload_0
    //   1230: getfield 1487	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   1233: lconst_0
    //   1234: lconst_0
    //   1235: invokevirtual 2447	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Landroid/view/View;JJ)V
    //   1238: aload_0
    //   1239: invokevirtual 2449	com/tencent/mobileqq/activity/FriendProfileCardActivity:t	()V
    //   1242: goto -961 -> 281
    //   1245: iconst_1
    //   1246: istore_2
    //   1247: goto -1022 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1250	0	this	FriendProfileCardActivity
    //   0	1250	1	paramawmk	awmk
    //   224	1023	2	i1	int
    //   67	2	3	bool	boolean
    //   89	778	4	l1	long
    //   79	85	6	localObject	Object
    //   358	20	6	localThrowable	Throwable
    //   572	40	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	46	334	finally
    //   46	68	334	finally
    //   75	81	334	finally
    //   86	127	334	finally
    //   132	157	334	finally
    //   157	163	334	finally
    //   168	207	334	finally
    //   207	223	334	finally
    //   229	281	334	finally
    //   281	317	334	finally
    //   317	331	334	finally
    //   339	355	334	finally
    //   360	388	334	finally
    //   391	445	334	finally
    //   445	458	334	finally
    //   458	544	334	finally
    //   547	569	334	finally
    //   574	611	334	finally
    //   611	616	334	finally
    //   621	643	334	finally
    //   646	685	334	finally
    //   688	743	334	finally
    //   746	768	334	finally
    //   771	813	334	finally
    //   816	854	334	finally
    //   857	875	334	finally
    //   875	888	334	finally
    //   891	929	334	finally
    //   932	1060	334	finally
    //   1065	1084	334	finally
    //   1084	1100	334	finally
    //   1100	1152	334	finally
    //   1155	1174	334	finally
    //   1174	1190	334	finally
    //   1190	1242	334	finally
    //   86	127	358	java/lang/Throwable
    //   132	157	358	java/lang/Throwable
    //   339	355	358	java/lang/Throwable
    //   168	207	572	java/lang/Exception
    //   207	223	572	java/lang/Exception
    //   391	445	572	java/lang/Exception
    //   445	458	572	java/lang/Exception
    //   458	544	572	java/lang/Exception
    //   547	569	572	java/lang/Exception
    //   621	643	572	java/lang/Exception
    //   646	685	572	java/lang/Exception
    //   688	743	572	java/lang/Exception
    //   746	768	572	java/lang/Exception
    //   771	813	572	java/lang/Exception
    //   816	854	572	java/lang/Exception
    //   857	875	572	java/lang/Exception
    //   875	888	572	java/lang/Exception
    //   891	929	572	java/lang/Exception
    //   932	1060	572	java/lang/Exception
  }
  
  public void a(awmk paramawmk, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0);
    if (((localObject instanceof ProfileHeaderView)) && (!paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView headerView update");
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView mCurrentHeaderStyle=" + this.jdField_f_of_type_Long);
      }
      long l1 = awmr.a(paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard);
      if ((paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != this.jdField_f_of_type_Long) || (l1 > this.jdField_g_of_type_Long)))
      {
        QLog.e("DIYProfileTemplate.FriendProfileCardActivity", 1, "it have change the template form" + this.jdField_f_of_type_Long + " , " + this.jdField_g_of_type_Long + " to " + paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId + " , " + l1);
        this.jdField_c_of_type_Boolean = false;
        a(paramawmk);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.requestLayout();
      return;
      ((ProfileHeaderView)localObject).a(paramawmk, paramBoolean);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView headerView is loading");
      }
      a(paramawmk);
      if (((localObject instanceof ProfileHeaderView)) && (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53))
      {
        localObject = (ProfileHeaderView)localObject;
        ((ProfileHeaderView)localObject).b(paramawmk);
        ((ProfileHeaderView)localObject).a(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      }
    }
  }
  
  public void a(bena parambena)
  {
    this.jdField_a_of_type_Bena = parambena;
  }
  
  public void a(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    Intent localIntent;
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.jdField_c_of_type_JavaLangString;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label144;
      }
      localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramCardContactInfo));
    }
    for (;;)
    {
      try
      {
        startActivity(localIntent);
        this.app.a().b(paramCardContactInfo);
        azmj.b(this.app, "CliOper", "", "", "P_prof", "call", a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        paramCardContactInfo = null;
      }
      catch (Exception localException)
      {
        QLog.e("FriendProfileCardActivity", 1, "callContact fail.", localException);
        continue;
      }
      label144:
      a(2131693561, 1);
    }
  }
  
  public void a(Card paramCard)
  {
    int i1;
    if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())))
    {
      if (paramCard == null)
      {
        i1 = 0;
        ??? = aorc.a();
        if ((??? == null) || (!((aorb)???).a()) || (TextUtils.isEmpty(((aorb)???).a())) || (!bhos.a(((aorb)???).a()))) {
          break label254;
        }
        ??? = ((aorb)???).a();
        if (paramCard == null) {
          break label248;
        }
        paramCard = paramCard.uin;
        label98:
        bcyw.a(this, (String)???, paramCard);
        auru.a(this.app);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
        {
          paramCard = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
          if (!(paramCard instanceof VoteView)) {
            break label392;
          }
          paramCard = (VoteView)paramCard;
          paramCard.a(true, false, i1, 0, null, false);
          paramCard.a(false);
        }
      }
      for (;;)
      {
        paramCard = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_personal_like_tip");
        if ((paramCard != null) && (paramCard.getVisibility() == 0)) {
          paramCard.setVisibility(8);
        }
        azmj.b(this.app, "CliOper", "", "", "0X800657A", "0X800657A", 1, 0, Integer.toString(a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        i1 = (int)paramCard.lVoteCount;
        break;
        label248:
        paramCard = "";
        break label98;
        label254:
        paramCard = new Intent(this, VisitorsActivity.class);
        ??? = new Bundle();
        ((Bundle)???).putLong("toUin", Long.valueOf(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue());
        ((Bundle)???).putLong("totalVoters", i1);
        ((Bundle)???).putBoolean("isStartedByProfileCard", true);
        ((Bundle)???).putBoolean("votersOnly", true);
        if (i1 > 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((Bundle)???).putBoolean("hasVoters", bool);
          ((Bundle)???).putBoolean("extra_show_rank", true);
          ((Bundle)???).putInt("extra_from", 1);
          ((Bundle)???).putInt("frome_where", 5);
          paramCard.putExtras((Bundle)???);
          startActivity(paramCard);
          break;
        }
        label392:
        if ((paramCard instanceof VoteViewV2))
        {
          paramCard = (VoteViewV2)paramCard;
          paramCard.a(true, false, i1, 0, null, false);
          paramCard.a(false);
        }
      }
    }
    HashMap localHashMap = new HashMap();
    String str = this.app.getCurrentAccountUin();
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "card is null,vote failed !");
      }
      a(2131693644, 1);
      localHashMap.put("param_FailCode", "-210");
      azmz.a(this.app.getApp()).a(str, "profileCardSendFavorite", false, 0L, 0L, localHashMap, "", false);
      return;
    }
    ??? = (alkv)this.app.a(2);
    if (QLog.isColorLevel()) {
      QLog.i("FriendProfileCardActivity", 2, "Click Vote View, card.bAvailVoteCnt = " + paramCard.bAvailVoteCnt + ",card.bHaveVotedCnt = " + paramCard.bHaveVotedCnt + ",card.strVoteLimitedNotice = " + paramCard.strVoteLimitedNotice);
    }
    label591:
    int i2;
    if (paramCard.bAvailVoteCnt <= 0)
    {
      i1 = 1;
      if ((paramCard.bHaveVotedCnt > 0) || (paramCard.bAvailVoteCnt > 0)) {
        break label871;
      }
      i2 = 1;
      if ((i1 != 0) || (i2 != 0)) {
        break label985;
      }
      if ((??? == null) || (!bdee.d(BaseApplication.getContext()))) {
        break label882;
      }
      paramCard.lVoteCount += 1L;
      paramCard.bVoted = 1;
      paramCard.bAvailVoteCnt = ((short)(paramCard.bAvailVoteCnt - 1));
    }
    label985:
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, String.format("reqFavorite onClick uin=%s voteCount=%s mCacheVoteNum=%s", new Object[] { this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.uin, Long.valueOf(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount), this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger }));
        }
        this.jdField_h_of_type_Boolean = true;
        if (!this.jdField_a_of_type_Bhow.hasMessages(10))
        {
          ??? = Message.obtain();
          ((Message)???).what = 10;
          this.jdField_a_of_type_Bhow.sendMessageDelayed((Message)???, 2000L);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
        {
          l1 = paramCard.lVoteCount;
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_Awmk, l1, true);
        }
        if (!QSecFramework.a().a(1001).booleanValue()) {
          break;
        }
        QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(24), Integer.valueOf(1), Integer.valueOf(6), "vote", null }, null);
        return;
        i1 = 0;
        break label591;
        label871:
        i2 = 0;
      }
      label882:
      if (??? != null)
      {
        localHashMap.put("param_FailCode", "-203");
        azmz.a(this.app.getApp()).a(str, "profileCardSendFavorite", true, 0L, 0L, localHashMap, "", false);
        a(2131721494, 1);
      }
      else
      {
        localHashMap.put("param_FailCode", "-204");
        azmz.a(this.app.getApp()).a(str, "profileCardSendFavorite", false, 0L, 0L, localHashMap, "", false);
        a(2131693644, 1);
        continue;
        if (getIntent().hasExtra("troopUin")) {}
        for (??? = "1";; ??? = "0")
        {
          if ((i1 == 0) || (VipUtils.b(this.app))) {
            break label1124;
          }
          if (!awsp.a(this.app)) {
            break label1086;
          }
          paramCard = new bdrg(this);
          paramCard.a(this.jdField_a_of_type_Bdri);
          paramCard.show();
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "dbzan_pageview", "", 1, 0, 0, "", (String)???, "");
          break;
        }
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "limit_10", "", 1, 0, 0, "", (String)???, "");
        a("非SVIP用户每天只能点10个赞哦～", 0);
      }
    }
    label1086:
    label1124:
    long l1 = SystemClock.uptimeMillis() - jdField_i_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "toastInterval:" + l1);
    }
    if (paramCard.strVoteLimitedNotice != null)
    {
      if (l1 > jdField_j_of_type_Long)
      {
        a(paramCard.strVoteLimitedNotice, 0);
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "limit_20", "", 1, 0, 0, "", (String)???, "");
        jdField_i_of_type_Long = SystemClock.uptimeMillis();
      }
      if (i2 != 0) {
        azmj.b(this.app, "CliOper", "", "", "0X8006579", "0X8006579", 1, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), "", "", "");
      }
    }
    for (;;)
    {
      azmz.a(this.app.getApp()).a(str, "profileCardSendFavorite", false, 0L, 0L, localHashMap, "", false);
      break;
      if (i1 != 0)
      {
        azmj.b(this.app, "CliOper", "", "", "0X8006578", "0X8006578", 1, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), "", "", "");
        continue;
        if (l1 > jdField_j_of_type_Long)
        {
          a(2131693644, 1);
          jdField_i_of_type_Long = SystemClock.uptimeMillis();
        }
        if (i1 != 0) {
          localHashMap.put("param_FailCode", "-230");
        } else if (i2 != 0) {
          localHashMap.put("param_FailCode", "-231");
        } else {
          localHashMap.put("param_FailCode", "-220");
        }
      }
    }
  }
  
  public void a(Card paramCard, String paramString)
  {
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onSwitchedToFriend, uin: " + paramString + ", card = " + paramCard);
    }
    long l1;
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_qzonecover"))) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramString, 1);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramString;
      c(true);
      l1 = 0L;
      if (paramCard == null) {
        break label279;
      }
      l1 = paramCard.feedPreviewTime;
      paramString = paramCard.vSeed;
      this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      a(paramCard, false);
      paramCard = paramString;
      label161:
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
        break label288;
      }
    }
    label279:
    label288:
    for (paramString = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;; paramString = null)
    {
      a(l1, paramCard, paramString, true);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_qzonecover"))) {
        break;
      }
      ProfileHeaderView localProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
      String str = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        i1 = 1;
      }
      localProfileHeaderView.a(str, i1);
      break;
      k();
      paramCard = null;
      break label161;
    }
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    int i2 = 99999;
    this.jdField_a_of_type_Bdjk.a("initUpdateInfoStart", true);
    Object localObject2;
    Object localObject1;
    label173:
    int i1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("updateInfo Card=");
      if (paramCard != null)
      {
        localObject1 = paramCard.getProfileCardDesc();
        QLog.i("Q.profilecard.FrdProfileCard", 2, (String)localObject1 + " isNetRet = " + paramBoolean);
      }
    }
    else
    {
      this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      g();
      a(this.jdField_a_of_type_Awmk, paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Awmk, paramBoolean, new String[0]);
      localObject1 = aoqg.c();
      if ((((QQLevelIconConfig)localObject1).mIsEnableGuide) && (alrh.a()))
      {
        localObject2 = (bdqa)this.app.getManager(235);
        if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label562;
        }
        if (((bdqa)localObject2).b()) {
          j(2131717666);
        }
      }
      if ((((QQLevelIconConfig)localObject1).mIsNotifyPayment) && (paramBoolean) && (alrh.a()))
      {
        localObject1 = (bdqa)this.app.getManager(235);
        i1 = ((bdqa)localObject1).a();
        QLog.e("QQLevelNotice", 1, "getShowQQLevelNoticeValue: " + i1 + "," + this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
        if ((i1 != 0) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
        {
          localObject2 = bdqa.a(i1);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373487);
            localTextView.setText((CharSequence)localObject2);
            localTextView.setVisibility(0);
            ((bdqa)localObject1).a(0);
            localTextView.setOnClickListener(new acuz(this, localTextView, i1));
          }
        }
      }
      b(paramBoolean);
      if ((paramBoolean) && (paramCard != null) && ((paramCard.lCurrentStyleId != awmr.jdField_f_of_type_Long) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 1))) {
        l();
      }
      if ((this.jdField_a_of_type_Zcp != null) && (this.jdField_a_of_type_Zcp.isShowing()) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null))
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.strReMark)) {
          break label580;
        }
        this.jdField_a_of_type_Zcp.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.strReMark + getResources().getString(2131698891));
      }
      label467:
      if (paramCard != null) {
        this.jdField_a_of_type_Awmk.jdField_c_of_type_Int = paramCard.extendFriendEntryAddFriend;
      }
      i1 = i2;
      if (paramCard != null)
      {
        if (paramCard.mQQLevelType != 0) {
          break label642;
        }
        i1 = i2;
      }
      label499:
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label650;
      }
      azmj.b(null, "dc00898", "", "", "qq_vip", "0X800A777", i1, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdjk.a("initUpdateInfoEnd", "initUpdateInfoStart", false);
      return;
      localObject1 = "null";
      break;
      label562:
      if ((!((bdqa)localObject2).b()) || (paramCard.mQQLevelType == 0)) {
        break label173;
      }
      break label173;
      label580:
      if (TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.strNick)) {
        break label467;
      }
      this.jdField_a_of_type_Zcp.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.strNick + getResources().getString(2131698891));
      break label467;
      label642:
      i1 = paramCard.mQQLevelType;
      break label499;
      label650:
      azmj.b(null, "dc00898", "", "", "qq_vip", "0X800A776", i1, 0, "", "", "", "");
    }
  }
  
  /* Error */
  public void a(Card paramCard, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +761 -> 764
    //   6: iload_3
    //   7: iconst_1
    //   8: if_icmpeq +9 -> 17
    //   11: iload_3
    //   12: bipush 8
    //   14: if_icmpne +160 -> 174
    //   17: aload_1
    //   18: getfield 2497	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   21: lconst_0
    //   22: lcmp
    //   23: iflt +151 -> 174
    //   26: aload_0
    //   27: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: ldc_w 627
    //   33: ldc 169
    //   35: ldc 169
    //   37: ldc_w 2911
    //   40: ldc_w 2913
    //   43: aload_0
    //   44: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   47: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   50: getfield 1274	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   53: invokestatic 1277	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(I)I
    //   56: iconst_0
    //   57: aload_0
    //   58: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   61: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   64: invokestatic 1278	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)I
    //   67: invokestatic 1280	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   70: aload_1
    //   71: getfield 2497	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   74: invokestatic 2916	java/lang/Long:toString	(J)Ljava/lang/String;
    //   77: ldc 169
    //   79: ldc 169
    //   81: invokestatic 634	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_0
    //   85: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   88: invokevirtual 737	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   91: ldc_w 2911
    //   94: ldc_w 2918
    //   97: ldc 169
    //   99: iconst_1
    //   100: iconst_0
    //   101: iconst_0
    //   102: ldc 169
    //   104: aload_0
    //   105: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   108: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   111: invokestatic 1278	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)I
    //   114: invokestatic 1280	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   117: new 404	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   124: aload_1
    //   125: getfield 2497	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   128: invokevirtual 2146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   131: ldc 169
    //   133: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: new 404	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   146: aload_1
    //   147: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   150: invokevirtual 2146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   153: ldc 169
    //   155: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: ldc 169
    //   163: ldc 169
    //   165: ldc 169
    //   167: iconst_0
    //   168: iconst_0
    //   169: iconst_0
    //   170: iconst_0
    //   171: invokestatic 2921	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUtil:reportCommercialDrainage	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIII)V
    //   174: getstatic 2036	bhoh:a	Lbhoh;
    //   177: astore 19
    //   179: aload 19
    //   181: ifnull +18 -> 199
    //   184: aload 19
    //   186: invokevirtual 2038	bhoh:a	()Z
    //   189: ifeq +10 -> 199
    //   192: aload 19
    //   194: bipush 7
    //   196: invokevirtual 2040	bhoh:a	(I)V
    //   199: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +66 -> 268
    //   205: ldc_w 402
    //   208: iconst_2
    //   209: new 404	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 2923
    //   219: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_0
    //   223: getfield 158	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_c_of_type_Boolean	Z
    //   226: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   229: ldc_w 2925
    //   232: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: iload_2
    //   236: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   239: ldc_w 2927
    //   242: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: iload_3
    //   246: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: ldc_w 2929
    //   252: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_1
    //   256: invokevirtual 2830	com/tencent/mobileqq/data/Card:getProfileCardDesc	()Ljava/lang/String;
    //   259: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: aload_0
    //   269: aload_1
    //   270: iload_2
    //   271: invokevirtual 2932	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/data/Card;Z)Z
    //   274: pop
    //   275: aload_0
    //   276: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   279: invokestatic 2933	com/tencent/mobileqq/activity/FriendProfileCardActivity:b	(Lawmk;)V
    //   282: iconst_0
    //   283: istore 10
    //   285: iconst_0
    //   286: istore 8
    //   288: iconst_0
    //   289: istore 6
    //   291: iconst_0
    //   292: istore 4
    //   294: iload 6
    //   296: istore 5
    //   298: iload 10
    //   300: istore 9
    //   302: iload_3
    //   303: bipush 8
    //   305: if_icmpne +1668 -> 1973
    //   308: iload 6
    //   310: istore 5
    //   312: iload 10
    //   314: istore 9
    //   316: aload_0
    //   317: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   320: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   323: ifnull +1650 -> 1973
    //   326: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +52 -> 381
    //   332: ldc_w 402
    //   335: iconst_2
    //   336: new 404	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 2935
    //   346: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_0
    //   350: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   353: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   356: getfield 2938	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   359: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc_w 2940
    //   365: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload_1
    //   369: getfield 2938	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   372: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: aload_0
    //   382: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   385: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   388: getfield 2938	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   391: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   394: ifeq +373 -> 767
    //   397: aload_1
    //   398: getfield 2938	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   401: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   404: ifne +22 -> 426
    //   407: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +1573 -> 1983
    //   413: ldc_w 402
    //   416: iconst_2
    //   417: ldc_w 2942
    //   420: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: goto +1560 -> 1983
    //   426: aload_0
    //   427: getfield 2484	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_f_of_type_Long	J
    //   430: aload_1
    //   431: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   434: lcmp
    //   435: ifeq +6 -> 441
    //   438: iconst_1
    //   439: istore 4
    //   441: aload_1
    //   442: invokestatic 2487	awmr:a	(Lcom/tencent/mobileqq/data/Card;)J
    //   445: aload_0
    //   446: getfield 2489	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_g_of_type_Long	J
    //   449: lcmp
    //   450: ifle +6 -> 456
    //   453: iconst_1
    //   454: istore 4
    //   456: iload 4
    //   458: istore 5
    //   460: iload 8
    //   462: istore 9
    //   464: aload_0
    //   465: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   468: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   471: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   474: getstatic 2533	awmr:jdField_g_of_type_Long	J
    //   477: lcmp
    //   478: ifne +1495 -> 1973
    //   481: iload 4
    //   483: istore 5
    //   485: iload 8
    //   487: istore 9
    //   489: aload_1
    //   490: getfield 2945	com/tencent/mobileqq/data/Card:diyText	Ljava/lang/String;
    //   493: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   496: ifne +1477 -> 1973
    //   499: iconst_1
    //   500: istore 6
    //   502: iload 4
    //   504: istore 5
    //   506: iload 6
    //   508: istore 4
    //   510: iload_3
    //   511: bipush 13
    //   513: if_icmpne +22 -> 535
    //   516: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +1470 -> 1989
    //   522: ldc_w 402
    //   525: iconst_2
    //   526: ldc_w 2947
    //   529: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: goto +1457 -> 1989
    //   535: aload_1
    //   536: getfield 2950	com/tencent/mobileqq/data/Card:tempChatSig	[B
    //   539: ifnull +83 -> 622
    //   542: aload_1
    //   543: getfield 2950	com/tencent/mobileqq/data/Card:tempChatSig	[B
    //   546: arraylength
    //   547: ifle +75 -> 622
    //   550: aload_0
    //   551: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   554: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   557: aload_1
    //   558: getfield 2950	com/tencent/mobileqq/data/Card:tempChatSig	[B
    //   561: putfield 1445	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	[B
    //   564: invokestatic 1102	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   567: ifeq +55 -> 622
    //   570: ldc_w 495
    //   573: iconst_4
    //   574: invokestatic 1131	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   577: ldc_w 2952
    //   580: iconst_2
    //   581: anewarray 126	java/lang/Object
    //   584: dup
    //   585: iconst_0
    //   586: aload_0
    //   587: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   590: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   593: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   596: invokestatic 1237	bdal:b	(Ljava/lang/String;)Ljava/lang/String;
    //   599: aastore
    //   600: dup
    //   601: iconst_1
    //   602: aload_0
    //   603: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   606: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   609: getfield 1445	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	[B
    //   612: invokestatic 1455	bdal:a	([B)Ljava/lang/String;
    //   615: aastore
    //   616: invokestatic 1142	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   619: invokestatic 561	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: aload_0
    //   623: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   626: aload_1
    //   627: putfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   630: aload_0
    //   631: getfield 158	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_c_of_type_Boolean	Z
    //   634: ifeq +13 -> 647
    //   637: iload 8
    //   639: ifne +8 -> 647
    //   642: iload 5
    //   644: ifeq +1326 -> 1970
    //   647: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +44 -> 694
    //   653: ldc_w 402
    //   656: iconst_2
    //   657: new 404	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 2954
    //   667: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_0
    //   671: getfield 158	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_c_of_type_Boolean	Z
    //   674: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   677: ldc_w 2956
    //   680: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: iload 8
    //   685: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   688: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   694: aload_1
    //   695: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   698: lstore 12
    //   700: aload_1
    //   701: getfield 2959	com/tencent/mobileqq/data/Card:templateRet	I
    //   704: istore 6
    //   706: aload_1
    //   707: getfield 2938	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   710: astore 18
    //   712: aload_1
    //   713: getfield 2500	com/tencent/mobileqq/data/Card:backgroundColor	J
    //   716: lstore 14
    //   718: aload_1
    //   719: getfield 2962	com/tencent/mobileqq/data/Card:strZipUrl	Ljava/lang/String;
    //   722: astore 20
    //   724: aload_1
    //   725: getfield 2965	com/tencent/mobileqq/data/Card:dynamicCardFlag	I
    //   728: istore 7
    //   730: aload_1
    //   731: getfield 2968	com/tencent/mobileqq/data/Card:strWzryHeroUrl	Ljava/lang/String;
    //   734: astore 21
    //   736: aload_1
    //   737: getfield 2497	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   740: lstore 16
    //   742: lload 12
    //   744: lconst_0
    //   745: lcmp
    //   746: ifge +63 -> 809
    //   749: aload_0
    //   750: invokestatic 506	bdee:g	(Landroid/content/Context;)Z
    //   753: istore 9
    //   755: iload 9
    //   757: ifeq +52 -> 809
    //   760: iload_2
    //   761: ifne +48 -> 809
    //   764: aload_0
    //   765: monitorexit
    //   766: return
    //   767: aload_0
    //   768: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   771: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   774: getfield 2938	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   777: aload_1
    //   778: getfield 2938	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   781: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   784: ifne -358 -> 426
    //   787: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   790: ifeq +13 -> 803
    //   793: ldc_w 402
    //   796: iconst_2
    //   797: ldc_w 2970
    //   800: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   803: iconst_1
    //   804: istore 8
    //   806: goto -380 -> 426
    //   809: aload_0
    //   810: getfield 2351	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Bdjk	Lbdjk;
    //   813: ldc_w 2972
    //   816: iconst_1
    //   817: invokevirtual 2358	bdjk:a	(Ljava/lang/String;Z)V
    //   820: aload_0
    //   821: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   824: lload 12
    //   826: iconst_1
    //   827: invokestatic 2975	bcyw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JZ)Lawmr;
    //   830: astore 22
    //   832: aload_0
    //   833: getfield 2351	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Bdjk	Lbdjk;
    //   836: ldc_w 2977
    //   839: ldc_w 2972
    //   842: iconst_0
    //   843: invokevirtual 2465	bdjk:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   846: lload 12
    //   848: lconst_0
    //   849: lcmp
    //   850: ifle +21 -> 871
    //   853: aload 22
    //   855: ifnull +16 -> 871
    //   858: aload 18
    //   860: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   863: ifne +8 -> 871
    //   866: iload 6
    //   868: ifeq +433 -> 1301
    //   871: aload_0
    //   872: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   875: aconst_null
    //   876: putfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   879: iload 4
    //   881: ifeq +104 -> 985
    //   884: aload_0
    //   885: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   888: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   891: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   894: getstatic 2533	awmr:jdField_g_of_type_Long	J
    //   897: lcmp
    //   898: ifne +87 -> 985
    //   901: aload_0
    //   902: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   905: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   908: getfield 2980	com/tencent/mobileqq/data/Card:diyTextFontId	I
    //   911: invokestatic 2983	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:a	(I)Z
    //   914: ifne +71 -> 985
    //   917: aload_0
    //   918: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   921: sipush 184
    //   924: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   927: checkcast 2985	com/tencent/mobileqq/vas/VasQuickUpdateManager
    //   930: astore 18
    //   932: aload 18
    //   934: new 2987	acug
    //   937: dup
    //   938: aload_0
    //   939: invokespecial 2988	acug:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   942: invokevirtual 2992	com/tencent/mobileqq/vas/VasQuickUpdateManager:addCallBacker	(Lcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)V
    //   945: aload 18
    //   947: ldc2_w 2993
    //   950: new 404	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   957: ldc_w 2996
    //   960: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: aload_0
    //   964: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   967: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   970: getfield 2980	com/tencent/mobileqq/data/Card:diyTextFontId	I
    //   973: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   976: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   979: ldc_w 495
    //   982: invokevirtual 3000	com/tencent/mobileqq/vas/VasQuickUpdateManager:downloadItem	(JLjava/lang/String;Ljava/lang/String;)V
    //   985: aload_0
    //   986: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   989: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   992: getfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   995: ifeq +185 -> 1180
    //   998: iload_3
    //   999: bipush 8
    //   1001: if_icmpne +179 -> 1180
    //   1004: aload_0
    //   1005: getfield 3002	com/tencent/mobileqq/activity/FriendProfileCardActivity:r	Z
    //   1008: ifne +172 -> 1180
    //   1011: aload_0
    //   1012: iconst_1
    //   1013: putfield 3002	com/tencent/mobileqq/activity/FriendProfileCardActivity:r	Z
    //   1016: aload_1
    //   1017: getfield 3005	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   1020: ldc2_w 3006
    //   1023: land
    //   1024: lconst_0
    //   1025: lcmp
    //   1026: ifeq +912 -> 1938
    //   1029: iconst_1
    //   1030: istore 9
    //   1032: aload_0
    //   1033: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1036: bipush 51
    //   1038: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1041: checkcast 670	aloz
    //   1044: aload_1
    //   1045: getfield 517	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   1048: invokevirtual 681	aloz:b	(Ljava/lang/String;)Z
    //   1051: istore 10
    //   1053: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1056: ifeq +71 -> 1127
    //   1059: ldc_w 495
    //   1062: iconst_2
    //   1063: new 404	java/lang/StringBuilder
    //   1066: dup
    //   1067: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   1070: ldc_w 3009
    //   1073: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: iload 9
    //   1078: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1081: ldc_w 3011
    //   1084: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: iload 10
    //   1089: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1092: ldc_w 3013
    //   1095: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: aload_1
    //   1099: getfield 517	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   1102: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: ldc_w 3015
    //   1108: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: aload_0
    //   1112: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1115: invokevirtual 482	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1118: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1124: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1127: iload 9
    //   1129: iload 10
    //   1131: if_icmpeq +49 -> 1180
    //   1134: ldc_w 495
    //   1137: iconst_1
    //   1138: new 404	java/lang/StringBuilder
    //   1141: dup
    //   1142: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   1145: ldc_w 3017
    //   1148: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: iload 9
    //   1153: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1156: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1159: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1162: aload_0
    //   1163: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1166: iconst_1
    //   1167: invokevirtual 529	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   1170: checkcast 3019	com/tencent/mobileqq/app/FriendListHandler
    //   1173: aload_1
    //   1174: getfield 517	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   1177: invokevirtual 3020	com/tencent/mobileqq/app/FriendListHandler:a	(Ljava/lang/String;)V
    //   1180: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1183: ifeq +812 -> 1995
    //   1186: ldc_w 495
    //   1189: iconst_2
    //   1190: new 404	java/lang/StringBuilder
    //   1193: dup
    //   1194: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   1197: ldc_w 3022
    //   1200: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: iconst_1
    //   1204: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1207: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1210: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1213: goto +782 -> 1995
    //   1216: aload_0
    //   1217: getfield 1092	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_Bhow	Lbhow;
    //   1220: iconst_5
    //   1221: iload 6
    //   1223: iload_3
    //   1224: aload_1
    //   1225: invokevirtual 3025	bhow:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   1228: astore 18
    //   1230: iload 8
    //   1232: ifeq +718 -> 1950
    //   1235: iload 5
    //   1237: ifeq +713 -> 1950
    //   1240: aload 18
    //   1242: bipush 12
    //   1244: putfield 3028	android/os/Message:arg2	I
    //   1247: aload 18
    //   1249: invokevirtual 1939	android/os/Message:sendToTarget	()V
    //   1252: iload 4
    //   1254: ifeq +19 -> 1273
    //   1257: aload_0
    //   1258: getfield 1092	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_Bhow	Lbhow;
    //   1261: iconst_5
    //   1262: iload 6
    //   1264: bipush 17
    //   1266: aload_1
    //   1267: invokevirtual 3025	bhow:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   1270: invokevirtual 1939	android/os/Message:sendToTarget	()V
    //   1273: aload 19
    //   1275: ifnull -511 -> 764
    //   1278: aload 19
    //   1280: invokevirtual 2038	bhoh:a	()Z
    //   1283: ifeq -519 -> 764
    //   1286: aload 19
    //   1288: bipush 7
    //   1290: invokevirtual 3030	bhoh:b	(I)V
    //   1293: goto -529 -> 764
    //   1296: astore_1
    //   1297: aload_0
    //   1298: monitorexit
    //   1299: aload_1
    //   1300: athrow
    //   1301: aload_0
    //   1302: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1305: invokestatic 3031	bcyw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1308: istore 11
    //   1310: lload 16
    //   1312: ldc2_w 3032
    //   1315: lcmp
    //   1316: ifeq +12 -> 1328
    //   1319: lload 16
    //   1321: ldc2_w 3034
    //   1324: lcmp
    //   1325: ifne +378 -> 1703
    //   1328: aload_0
    //   1329: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1332: invokevirtual 1367	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1335: aload 18
    //   1337: invokestatic 3038	bcyw:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   1340: istore 9
    //   1342: aload_0
    //   1343: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1346: invokevirtual 1367	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1349: lload 16
    //   1351: ldc_w 3040
    //   1354: invokestatic 3045	awml:a	(Landroid/content/Context;JLjava/lang/String;)Z
    //   1357: istore 10
    //   1359: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1362: ifeq +64 -> 1426
    //   1365: ldc_w 402
    //   1368: iconst_2
    //   1369: new 404	java/lang/StringBuilder
    //   1372: dup
    //   1373: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   1376: ldc_w 3047
    //   1379: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1382: lload 16
    //   1384: invokevirtual 2146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1387: ldc_w 3049
    //   1390: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: iload 11
    //   1395: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1398: ldc_w 3051
    //   1401: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: iload 9
    //   1406: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1409: ldc_w 3053
    //   1412: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: iload 10
    //   1417: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1420: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1423: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1426: iload 11
    //   1428: ifeq +479 -> 1907
    //   1431: iload 9
    //   1433: ifeq +474 -> 1907
    //   1436: aload_0
    //   1437: getfield 2351	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Bdjk	Lbdjk;
    //   1440: ldc_w 3055
    //   1443: iconst_1
    //   1444: invokevirtual 2358	bdjk:a	(Ljava/lang/String;Z)V
    //   1447: aload 22
    //   1449: aload_0
    //   1450: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1453: lload 14
    //   1455: lload 12
    //   1457: invokevirtual 3058	awmr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)Z
    //   1460: istore 9
    //   1462: aload_0
    //   1463: getfield 2351	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Bdjk	Lbdjk;
    //   1466: ldc_w 3060
    //   1469: ldc_w 3055
    //   1472: iconst_0
    //   1473: invokevirtual 2465	bdjk:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1476: aload_0
    //   1477: getfield 2351	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Bdjk	Lbdjk;
    //   1480: ldc_w 3062
    //   1483: iconst_1
    //   1484: invokevirtual 2358	bdjk:a	(Ljava/lang/String;Z)V
    //   1487: aload_0
    //   1488: lload 12
    //   1490: lload 16
    //   1492: aload 18
    //   1494: aload 20
    //   1496: aload 21
    //   1498: invokevirtual 3065	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   1501: istore 11
    //   1503: iload 8
    //   1505: iload 11
    //   1507: ior
    //   1508: istore 8
    //   1510: aload_0
    //   1511: getfield 2351	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Bdjk	Lbdjk;
    //   1514: ldc_w 3067
    //   1517: ldc_w 3062
    //   1520: iconst_0
    //   1521: invokevirtual 2465	bdjk:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1524: iload 9
    //   1526: ifeq +267 -> 1793
    //   1529: aload_0
    //   1530: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1533: aload 22
    //   1535: putfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   1538: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1541: ifeq +42 -> 1583
    //   1544: ldc_w 402
    //   1547: iconst_2
    //   1548: new 404	java/lang/StringBuilder
    //   1551: dup
    //   1552: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   1555: ldc_w 3069
    //   1558: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: iload 11
    //   1563: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1566: ldc_w 3071
    //   1569: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: iload 9
    //   1574: invokevirtual 1612	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1577: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1580: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1583: iload 7
    //   1585: iconst_1
    //   1586: if_icmpne +236 -> 1822
    //   1589: iload 10
    //   1591: ifne +231 -> 1822
    //   1594: aload_0
    //   1595: invokevirtual 3073	com/tencent/mobileqq/activity/FriendProfileCardActivity:c	()Z
    //   1598: ifeq +29 -> 1627
    //   1601: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1604: ifeq +13 -> 1617
    //   1607: ldc_w 402
    //   1610: iconst_2
    //   1611: ldc_w 3075
    //   1614: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1617: aload_0
    //   1618: aload 18
    //   1620: lload 16
    //   1622: aload 22
    //   1624: invokevirtual 3078	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Ljava/lang/String;JLawmr;)V
    //   1627: aload_1
    //   1628: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   1631: getstatic 2543	awmr:jdField_j_of_type_Long	J
    //   1634: lcmp
    //   1635: ifeq +14 -> 1649
    //   1638: aload_1
    //   1639: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   1642: getstatic 2545	awmr:jdField_i_of_type_Long	J
    //   1645: lcmp
    //   1646: ifne +54 -> 1700
    //   1649: aload_0
    //   1650: getfield 3080	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_i_of_type_Boolean	Z
    //   1653: ifne +47 -> 1700
    //   1656: aload 22
    //   1658: getfield 3082	awmr:o	J
    //   1661: invokestatic 3085	awob:a	(J)Z
    //   1664: ifeq +36 -> 1700
    //   1667: aload_0
    //   1668: ldc_w 3087
    //   1671: invokestatic 3088	awob:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   1674: ifne +26 -> 1700
    //   1677: aload_0
    //   1678: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1681: new 3090	acuf
    //   1684: dup
    //   1685: aload_0
    //   1686: aload 22
    //   1688: aload_1
    //   1689: invokespecial 3093	acuf:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;Lawmr;Lcom/tencent/mobileqq/data/Card;)V
    //   1692: invokestatic 3096	awob:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)V
    //   1695: aload_0
    //   1696: iconst_1
    //   1697: putfield 3080	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_i_of_type_Boolean	Z
    //   1700: goto -821 -> 879
    //   1703: iload 7
    //   1705: iconst_1
    //   1706: if_icmpne +58 -> 1764
    //   1709: aload_0
    //   1710: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1713: invokevirtual 1367	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1716: lload 16
    //   1718: ldc_w 3098
    //   1721: invokestatic 3045	awml:a	(Landroid/content/Context;JLjava/lang/String;)Z
    //   1724: istore 10
    //   1726: iload 10
    //   1728: istore 9
    //   1730: iload 10
    //   1732: ifne -390 -> 1342
    //   1735: new 3100	java/io/File
    //   1738: dup
    //   1739: aload_0
    //   1740: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1743: invokevirtual 1367	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1746: lload 12
    //   1748: lload 16
    //   1750: invokestatic 3103	awml:a	(Landroid/content/Context;JJ)Ljava/lang/String;
    //   1753: invokespecial 3105	java/io/File:<init>	(Ljava/lang/String;)V
    //   1756: invokevirtual 3108	java/io/File:exists	()Z
    //   1759: istore 9
    //   1761: goto -419 -> 1342
    //   1764: new 3100	java/io/File
    //   1767: dup
    //   1768: aload_0
    //   1769: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1772: invokevirtual 1367	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1775: lload 12
    //   1777: lload 16
    //   1779: invokestatic 3103	awml:a	(Landroid/content/Context;JJ)Ljava/lang/String;
    //   1782: invokespecial 3105	java/io/File:<init>	(Ljava/lang/String;)V
    //   1785: invokevirtual 3108	java/io/File:exists	()Z
    //   1788: istore 9
    //   1790: goto -448 -> 1342
    //   1793: aload_0
    //   1794: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1797: aconst_null
    //   1798: putfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   1801: goto -263 -> 1538
    //   1804: astore 18
    //   1806: aload 18
    //   1808: invokevirtual 1185	java/lang/Exception:printStackTrace	()V
    //   1811: aload_0
    //   1812: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1815: aconst_null
    //   1816: putfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   1819: goto -940 -> 879
    //   1822: aload_1
    //   1823: getfield 2431	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   1826: getstatic 2543	awmr:jdField_j_of_type_Long	J
    //   1829: lcmp
    //   1830: ifne -203 -> 1627
    //   1833: aload_0
    //   1834: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1837: invokevirtual 1367	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1840: aload_1
    //   1841: getfield 2497	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   1844: ldc_w 3110
    //   1847: invokestatic 3045	awml:a	(Landroid/content/Context;JLjava/lang/String;)Z
    //   1850: ifne -223 -> 1627
    //   1853: aload_0
    //   1854: invokevirtual 3073	com/tencent/mobileqq/activity/FriendProfileCardActivity:c	()Z
    //   1857: ifeq -230 -> 1627
    //   1860: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1863: ifeq +13 -> 1876
    //   1866: ldc_w 402
    //   1869: iconst_2
    //   1870: ldc_w 3112
    //   1873: invokestatic 424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1876: aload_0
    //   1877: aload 18
    //   1879: lload 16
    //   1881: aload 22
    //   1883: invokevirtual 3078	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Ljava/lang/String;JLawmr;)V
    //   1886: goto -259 -> 1627
    //   1889: astore 18
    //   1891: aload 18
    //   1893: invokevirtual 3113	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1896: aload_0
    //   1897: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1900: aconst_null
    //   1901: putfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   1904: goto -1025 -> 879
    //   1907: aload_0
    //   1908: invokevirtual 3073	com/tencent/mobileqq/activity/FriendProfileCardActivity:c	()Z
    //   1911: ifeq +16 -> 1927
    //   1914: aload_0
    //   1915: aload 18
    //   1917: lload 16
    //   1919: aload 22
    //   1921: invokevirtual 3078	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Ljava/lang/String;JLawmr;)V
    //   1924: goto -1160 -> 764
    //   1927: aload_0
    //   1928: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1931: aconst_null
    //   1932: putfield 2439	awmk:jdField_a_of_type_Awmr	Lawmr;
    //   1935: goto -1056 -> 879
    //   1938: iconst_0
    //   1939: istore 9
    //   1941: goto -909 -> 1032
    //   1944: iconst_0
    //   1945: istore 6
    //   1947: goto -731 -> 1216
    //   1950: iload 8
    //   1952: ifeq -705 -> 1247
    //   1955: aload 18
    //   1957: bipush 11
    //   1959: putfield 3028	android/os/Message:arg2	I
    //   1962: goto -715 -> 1247
    //   1965: astore 18
    //   1967: goto -76 -> 1891
    //   1970: goto -1091 -> 879
    //   1973: iconst_0
    //   1974: istore 4
    //   1976: iload 9
    //   1978: istore 8
    //   1980: goto -1470 -> 510
    //   1983: iconst_1
    //   1984: istore 8
    //   1986: goto -1560 -> 426
    //   1989: iconst_1
    //   1990: istore 8
    //   1992: goto -1457 -> 535
    //   1995: iload_2
    //   1996: ifeq -52 -> 1944
    //   1999: iconst_1
    //   2000: istore 6
    //   2002: goto -786 -> 1216
    //   2005: astore 18
    //   2007: goto -201 -> 1806
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2010	0	this	FriendProfileCardActivity
    //   0	2010	1	paramCard	Card
    //   0	2010	2	paramBoolean	boolean
    //   0	2010	3	paramInt	int
    //   292	1683	4	i1	int
    //   296	940	5	i2	int
    //   289	1712	6	i3	int
    //   728	979	7	i4	int
    //   286	1705	8	bool1	boolean
    //   300	1677	9	bool2	boolean
    //   283	1448	10	bool3	boolean
    //   1308	254	11	bool4	boolean
    //   698	1078	12	l1	long
    //   716	738	14	l2	long
    //   740	1178	16	l3	long
    //   710	909	18	localObject	Object
    //   1804	74	18	localException1	Exception
    //   1889	67	18	localOutOfMemoryError1	OutOfMemoryError
    //   1965	1	18	localOutOfMemoryError2	OutOfMemoryError
    //   2005	1	18	localException2	Exception
    //   177	1110	19	localbhoh	bhoh
    //   722	773	20	str1	String
    //   734	763	21	str2	String
    //   830	1090	22	localawmr	awmr
    // Exception table:
    //   from	to	target	type
    //   17	174	1296	finally
    //   174	179	1296	finally
    //   184	199	1296	finally
    //   199	268	1296	finally
    //   268	282	1296	finally
    //   316	381	1296	finally
    //   381	397	1296	finally
    //   397	423	1296	finally
    //   426	438	1296	finally
    //   441	453	1296	finally
    //   464	481	1296	finally
    //   489	499	1296	finally
    //   516	532	1296	finally
    //   535	622	1296	finally
    //   622	637	1296	finally
    //   647	694	1296	finally
    //   694	742	1296	finally
    //   749	755	1296	finally
    //   767	803	1296	finally
    //   809	846	1296	finally
    //   858	866	1296	finally
    //   871	879	1296	finally
    //   884	985	1296	finally
    //   985	998	1296	finally
    //   1004	1029	1296	finally
    //   1032	1127	1296	finally
    //   1134	1180	1296	finally
    //   1180	1213	1296	finally
    //   1216	1230	1296	finally
    //   1240	1247	1296	finally
    //   1247	1252	1296	finally
    //   1257	1273	1296	finally
    //   1278	1293	1296	finally
    //   1301	1310	1296	finally
    //   1328	1342	1296	finally
    //   1342	1426	1296	finally
    //   1436	1503	1296	finally
    //   1510	1524	1296	finally
    //   1529	1538	1296	finally
    //   1538	1583	1296	finally
    //   1594	1617	1296	finally
    //   1617	1627	1296	finally
    //   1627	1649	1296	finally
    //   1649	1700	1296	finally
    //   1709	1726	1296	finally
    //   1735	1761	1296	finally
    //   1764	1790	1296	finally
    //   1793	1801	1296	finally
    //   1806	1819	1296	finally
    //   1822	1876	1296	finally
    //   1876	1886	1296	finally
    //   1891	1904	1296	finally
    //   1907	1924	1296	finally
    //   1927	1935	1296	finally
    //   1955	1962	1296	finally
    //   1510	1524	1804	java/lang/Exception
    //   1529	1538	1804	java/lang/Exception
    //   1538	1583	1804	java/lang/Exception
    //   1594	1617	1804	java/lang/Exception
    //   1617	1627	1804	java/lang/Exception
    //   1627	1649	1804	java/lang/Exception
    //   1649	1700	1804	java/lang/Exception
    //   1793	1801	1804	java/lang/Exception
    //   1822	1876	1804	java/lang/Exception
    //   1876	1886	1804	java/lang/Exception
    //   1510	1524	1889	java/lang/OutOfMemoryError
    //   1529	1538	1889	java/lang/OutOfMemoryError
    //   1538	1583	1889	java/lang/OutOfMemoryError
    //   1594	1617	1889	java/lang/OutOfMemoryError
    //   1617	1627	1889	java/lang/OutOfMemoryError
    //   1627	1649	1889	java/lang/OutOfMemoryError
    //   1649	1700	1889	java/lang/OutOfMemoryError
    //   1793	1801	1889	java/lang/OutOfMemoryError
    //   1822	1876	1889	java/lang/OutOfMemoryError
    //   1876	1886	1889	java/lang/OutOfMemoryError
    //   694	742	1965	java/lang/OutOfMemoryError
    //   749	755	1965	java/lang/OutOfMemoryError
    //   809	846	1965	java/lang/OutOfMemoryError
    //   858	866	1965	java/lang/OutOfMemoryError
    //   871	879	1965	java/lang/OutOfMemoryError
    //   1301	1310	1965	java/lang/OutOfMemoryError
    //   1328	1342	1965	java/lang/OutOfMemoryError
    //   1342	1426	1965	java/lang/OutOfMemoryError
    //   1436	1503	1965	java/lang/OutOfMemoryError
    //   1709	1726	1965	java/lang/OutOfMemoryError
    //   1735	1761	1965	java/lang/OutOfMemoryError
    //   1764	1790	1965	java/lang/OutOfMemoryError
    //   1907	1924	1965	java/lang/OutOfMemoryError
    //   1927	1935	1965	java/lang/OutOfMemoryError
    //   694	742	2005	java/lang/Exception
    //   749	755	2005	java/lang/Exception
    //   809	846	2005	java/lang/Exception
    //   858	866	2005	java/lang/Exception
    //   871	879	2005	java/lang/Exception
    //   1301	1310	2005	java/lang/Exception
    //   1328	1342	2005	java/lang/Exception
    //   1342	1426	2005	java/lang/Exception
    //   1436	1503	2005	java/lang/Exception
    //   1709	1726	2005	java/lang/Exception
    //   1735	1761	2005	java/lang/Exception
    //   1764	1790	2005	java/lang/Exception
    //   1907	1924	2005	java/lang/Exception
    //   1927	1935	2005	java/lang/Exception
  }
  
  public void a(ContactCard paramContactCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo ContactCard card = " + paramContactCard + ", isNetRet = " + String.valueOf(paramBoolean));
    }
    g();
    if (a(paramContactCard, paramBoolean)) {
      b(this.jdField_a_of_type_Awmk);
    }
    a(this.jdField_a_of_type_Awmk, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Awmk, paramBoolean, new String[0]);
    b(paramBoolean);
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    ProfileActivity.AllInOne localAllInOne = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    if ((localAllInOne != null) && (paramTroopInfo != null) && (ProfileActivity.f(localAllInOne.jdField_a_of_type_Int)) && (TextUtils.isEmpty(localAllInOne.jdField_d_of_type_JavaLangString)))
    {
      localAllInOne.jdField_d_of_type_JavaLangString = paramTroopInfo.troopcode;
      localAllInOne.jdField_c_of_type_JavaLangString = paramTroopInfo.troopuin;
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, String.format("checkAndUpdateTroopInfo troop[%s, %s]", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
    }
  }
  
  public void a(QCallCardInfo paramQCallCardInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo QCallCardInfo card = " + paramQCallCardInfo + ", isNetRet = " + String.valueOf(paramBoolean));
    }
    if (a(paramQCallCardInfo, paramBoolean)) {
      b(this.jdField_a_of_type_Awmk);
    }
    a(this.jdField_a_of_type_Awmk, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Awmk, paramBoolean, new String[0]);
    b(paramBoolean);
  }
  
  @SuppressLint({"ServiceCast", "NewApi"})
  public void a(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          ((android.text.ClipboardManager)getSystemService("clipboard")).setText(paramString);
          return;
        }
        ((android.content.ClipboardManager)getSystemService("clipboard")).setText(paramString);
        return;
      }
      catch (Exception paramString)
      {
        QLog.d("FriendProfileCardActivity", 2, "copyContent fail!", paramString);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  void a(String paramString, long paramLong, awmr paramawmr)
  {
    if ((paramLong != 160L) && (paramLong != 1600L)) {
      ((bdqa)this.app.getManager(235)).jdField_a_of_type_Awml.a(this.app, "card." + paramLong);
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      ThreadManagerV2.excute(new FriendProfileCardActivity.DownloadTemplateRunnable(this, paramawmr, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, paramString, paramLong), 128, null, true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.i("FriendProfileCardActivity", 2, "initOrRefreshWeiShiPanel");
    if (this.jdField_a_of_type_Yxc == null) {
      this.jdField_a_of_type_Yxc = new yxc(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setMineWeiShiPanelInfo(this.jdField_a_of_type_Yxc, paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Awmk, true, new String[] { "map_key_mine_weishi" });
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i2 = 1;
    if ((this.app == null) || (this.jdField_b_of_type_Bhow == null) || (this.jdField_a_of_type_Awmk == null) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {}
    label316:
    label335:
    label360:
    label361:
    for (;;)
    {
      return;
      if ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!TextUtils.equals(paramString, this.app.getCurrentAccountUin())) && (!TextUtils.equals(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin())))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, String.format("checkAndSwitch2Friend phone: %s, check:%s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), bdal.b(paramString) }));
        }
        Message localMessage;
        if (paramBoolean1)
        {
          localObject = a(paramString, a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
          localMessage = Message.obtain();
          localMessage.what = 3;
          if (localObject == null) {}
          for (;;)
          {
            localMessage.obj = paramString;
            this.jdField_b_of_type_Bhow.sendMessage(localMessage);
            return;
            paramString = (String)localObject;
          }
        }
        Object localObject = (aloz)this.app.getManager(51);
        int i1;
        if (!paramBoolean2)
        {
          i1 = 1;
          if (i1 != 0) {
            break label360;
          }
          if (localObject != null) {
            break label316;
          }
          paramString = null;
          label235:
          if ((paramString == null) || (!paramString.isFriend())) {
            break label335;
          }
          i1 = i2;
        }
        for (;;)
        {
          label250:
          if (i1 == 0) {
            break label361;
          }
          if (localObject == null) {}
          for (paramString = null;; paramString = ((aloz)localObject).b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
          {
            localMessage = Message.obtain();
            localMessage.what = 3;
            localObject = paramString;
            if (paramString == null) {
              localObject = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
            }
            localMessage.obj = localObject;
            this.jdField_b_of_type_Bhow.sendMessage(localMessage);
            return;
            i1 = 0;
            break;
            paramString = ((aloz)localObject).e(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            break label235;
            i1 = 0;
            break label250;
          }
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.updateCoverData(paramArrayOfByte);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_Awmk, false);
      }
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    int i1 = 0;
    this.jdField_k_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2130968634);
    }
    bhpy localbhpy = (bhpy)bhql.a(this, null);
    paramInt = 0;
    if (paramInt < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[paramInt] == 16) {
        localbhpy.d(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[paramInt]]);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if ((paramArrayOfInt[paramInt] >= 0) && (paramArrayOfInt[paramInt] < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
          localbhpy.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[paramInt]], 1);
        }
      }
    }
    localbhpy.a(new acuu(this, localbhpy));
    paramInt = i1;
    if (this.jdField_k_of_type_Int == 98)
    {
      localbhpy.a(new acuv(this, localbhpy));
      paramInt = i1;
    }
    while (paramInt < this.jdField_a_of_type_ArrayOfInt.length)
    {
      if (this.jdField_a_of_type_ArrayOfInt[paramInt] == 32) {
        localbhpy.a(new acuw(this, localbhpy, paramInt));
      }
      paramInt += 1;
    }
    try
    {
      if (!isFinishing()) {
        localbhpy.show();
      }
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      paramArrayOfInt.printStackTrace();
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean a(long paramLong1, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, long paramLong2)
  {
    aloz localaloz = (aloz)this.app.getManager(51);
    Card localCard = localaloz.b(this.app.getCurrentAccountUin());
    if ((localCard != null) && (paramLong1 >= 0L))
    {
      localCard.lCurrentStyleId = paramLong1;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString1;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      localCard.cardId = paramLong2;
      if (TextUtils.isEmpty(localCard.diyComplicatedInfo)) {
        localCard.diyComplicatedInfo = paramString2;
      }
      if (!localaloz.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground url=" + paramString1 + ",thread=" + Thread.currentThread().getName());
    }
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == awmr.jdField_j_of_type_Long))
      {
        return a(paramLong2, paramString1, paramString3);
        paramString1 = bcyw.a(this, paramString1);
        Object localObject1;
        label118:
        int i1;
        if (TextUtils.isEmpty(paramString2))
        {
          paramString3 = "";
          localObject1 = paramString1;
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "initProfileCardBackground: fileName=" + (String)localObject1);
          }
          localFile = new File((String)localObject1);
          if ((!localFile.isFile()) || (!localFile.exists())) {
            break label1004;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "background file exists, fileName = " + (String)localObject1);
          }
          paramString1 = (Boolean)awml.b.get(Long.valueOf(paramLong2));
          if ((paramString1 != null) && (paramString1.booleanValue()))
          {
            paramString1 = "profilecard:" + (String)localObject1;
            BaseApplicationImpl.sImageCache.remove(paramString1);
            awml.b.remove(Long.valueOf(paramLong2));
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground update card and remove old cache bgid=" + paramLong2);
            }
          }
          localObject2 = null;
          paramString1 = (String)localObject2;
          if (!aork.c().a()) {
            break label631;
          }
          i1 = 0;
          paramString2 = awml.a(this, paramLong2) + "dynamicVideo.mp4";
          if (!new File(paramString2).exists()) {
            break label530;
          }
          i1 = 1;
        }
        for (;;)
        {
          paramString1 = (String)localObject2;
          if (i1 == 0) {
            break label631;
          }
          if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!TextUtils.equals(this.jdField_j_of_type_JavaLangString, paramString2)) || (!bdrw.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable))) {
            break label582;
          }
          if (!QLog.isColorLevel()) {
            break label1124;
          }
          QLog.i("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground: use old video-drawable");
          break label1124;
          paramString1 = awml.a(this, paramLong1, paramLong2);
          break;
          paramString2 = awml.a(this, paramLong2) + "dynamicBottom.jpg";
          if (new File(paramString2).exists()) {
            paramString1 = paramString2;
          }
          paramString3 = awml.a(this, paramLong2) + ".dynamic";
          localObject1 = paramString1;
          break label118;
          label530:
          paramString1 = paramString3 + "/video.mp4";
          paramString2 = paramString1;
          if (new File(paramString1).exists())
          {
            i1 = 1;
            paramString2 = paramString1;
          }
        }
        label582:
        Object localObject2 = bdrw.a().a(paramString2);
        paramString1 = (String)localObject2;
        if (localObject2 != null)
        {
          bdrw.a().a((Drawable)localObject2, true);
          this.jdField_j_of_type_JavaLangString = paramString2;
          QLog.i("Q.profilecard.FrdProfileCard", 2, "use new video-drawable");
          paramString1 = (String)localObject2;
        }
        label631:
        paramString2 = paramString1;
        if (paramString1 == null)
        {
          paramString2 = paramString1;
          if (TextUtils.isEmpty(paramString3))
          {
            paramString2 = paramString1;
            if (aork.c().b())
            {
              localObject2 = localFile.getAbsolutePath();
              if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (TextUtils.equals(this.jdField_j_of_type_JavaLangString, (CharSequence)localObject2)) && (bdrw.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)))
              {
                if (!QLog.isColorLevel()) {
                  break label1126;
                }
                QLog.i("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground: use old etc-drawable");
                break label1126;
              }
              paramString1 = bdrw.a().a(localFile.getAbsolutePath(), new Handler(ThreadManagerV2.getFileThreadLooper()), false);
              paramString2 = paramString1;
              if (paramString1 != null)
              {
                bdrw.a().a(paramString1, true);
                this.jdField_j_of_type_JavaLangString = ((String)localObject2);
                QLog.i("Q.profilecard.FrdProfileCard", 2, "use new etc-drawable");
                paramString2 = paramString1;
              }
            }
          }
        }
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          this.jdField_j_of_type_JavaLangString = null;
          paramString2 = bcyw.a(getResources(), paramString3, (String)localObject1);
          paramString1 = paramString2;
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
          {
            paramString1 = paramString2;
            if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof FriendProfileCardBgDrawable))
            {
              paramString3 = ((FriendProfileCardBgDrawable)paramString2).a();
              localObject1 = ((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a();
              paramString1 = paramString2;
              if (localObject1 != null)
              {
                paramString1 = paramString2;
                if (localObject1 == paramString3)
                {
                  if (!QLog.isColorLevel()) {
                    break label1128;
                  }
                  QLog.i("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground: newBitmap == currentBitmap");
                  break label1128;
                }
              }
            }
          }
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground recycle bg");
          }
          this.jdField_a_of_type_JavaUtilVector.add(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString1;
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground: currentBackgroundDrawable is null");
          }
        }
      }
    }
    catch (Exception paramString1)
    {
      File localFile;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground exception and msg=" + paramString1.getMessage());
      }
      paramString1.printStackTrace();
      for (;;)
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground: isFile=" + localFile.isFile() + " exists=" + localFile.exists());
        }
      }
    }
    catch (OutOfMemoryError paramString1)
    {
      for (;;)
      {
        label1004:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground oom error and msg=" + paramString1.getMessage());
        }
        paramString1.printStackTrace();
        continue;
        if (paramLong2 != 160L) {
          if (paramLong2 != 1600L) {}
        }
      }
    }
    label1124:
    return true;
    label1126:
    return true;
    label1128:
    return true;
  }
  
  public boolean a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initWzryCardBackground url=" + paramString1 + ",thread=" + Thread.currentThread().getName());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {}
    try
    {
      paramString1 = awml.a(this, paramLong);
      String str2 = paramString1 + "wzBgImage.png";
      String str1 = paramString1 + "wzMainImage.png";
      Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str2);
      paramString2 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
      if (localBitmap != null)
      {
        paramString1 = localBitmap;
        if (!localBitmap.isRecycled()) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "background file exists, fileName = " + str2);
        }
        paramString1 = bcwc.a(str2);
      }
      if ((paramString1 != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != paramString1))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = paramString1;
        BaseApplicationImpl.sImageCache.put(str2, paramString1);
      }
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (!paramString2.isRecycled()) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "hero file exists, fileName = " + str1);
        }
        paramString1 = bcwc.a(str1);
      }
      if ((paramString1 != null) && (this.jdField_b_of_type_AndroidGraphicsBitmap != paramString1))
      {
        this.jdField_b_of_type_AndroidGraphicsBitmap = paramString1;
        BaseApplicationImpl.sImageCache.put(str1, paramString1);
      }
      return true;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground exception and msg=" + paramString1.getMessage());
      }
      paramString1.printStackTrace();
      return false;
    }
    catch (OutOfMemoryError paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground oom error and msg=" + paramString1.getMessage());
        }
        paramString1.printStackTrace();
      }
    }
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramView, paramMotionEvent);
    }
    return false;
  }
  
  boolean a(awmk paramawmk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "checkParamValidate() cardInfo.allinone = " + paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
    if (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {}
    while (TextUtils.isEmpty(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (ProfileActivity.AllInOne.g(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {}
    try
    {
      awwo.b(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 55)) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int + ", entry = " + paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder(300);
          localStringBuilder.append("checkParamValidate, [pa: ").append(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int).append(", uin: ").append(bdal.b(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          if (ProfileActivity.e(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {
            localStringBuilder.append(", allinone_discussUin: ").append(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
          }
          if (ProfileActivity.f(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)) {
            localStringBuilder.append(", allinone_troopUin: ").append(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString).append(",  allinone_troopcode: ").append(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_JavaLangString).append(", sub_source_id: ").append(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int).append(", troopUin: ").append(paramawmk.jdField_a_of_type_JavaLangString);
          }
          Bundle localBundle = getIntent().getBundleExtra("flc_extra_param");
          if (localBundle != null)
          {
            localStringBuilder.append(", extra_param_troop_code: ").append(localBundle.getString("troop_code"));
            localStringBuilder.append(", extra_param_troop_uin: ").append(localBundle.getString("troop_uin"));
            localStringBuilder.append(", extra_param_notify_type: ").append(localBundle.getInt("flc_notify_type"));
            localStringBuilder.append(", extra_param_recommend_uin: ").append(localBundle.getString("flc_recommend_uin"));
          }
          localStringBuilder.append(", reportExtraParam: ").append(paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle);
          localStringBuilder.append("]");
          QLog.i("addFriendTag", 2, localStringBuilder.toString());
        }
        return a();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "通讯录陌生人： cardInfo.allinone.uin = " + paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        paramawmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int = 0;
      }
      return false;
    }
    catch (NumberFormatException paramawmk) {}
  }
  
  boolean a(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by Card");
      }
      return false;
    }
    boolean bool2;
    if ((paramBoolean) || (!TextUtils.isEmpty(paramCard.strNick))) {
      if (!bdal.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[0], paramCard.strNick))
      {
        bool2 = true;
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[0] = paramCard.strNick;
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramCard.strReMark)) {}
      }
      else
      {
        if ((!bool2) && (bdal.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[4], paramCard.strReMark))) {
          break label496;
        }
        bool1 = true;
        label114:
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[4] = paramCard.strReMark;
      }
      if (!paramBoolean)
      {
        paramBoolean = bool1;
        if (TextUtils.isEmpty(paramCard.strAutoRemark)) {}
      }
      else
      {
        if ((!bool1) && (bdal.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[6], paramCard.strAutoRemark))) {
          break label501;
        }
        paramBoolean = true;
        label169:
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[6] = paramCard.strAutoRemark;
      }
      boolean bool1 = paramBoolean;
      if (!TextUtils.isEmpty(paramCard.strContactName))
      {
        if ((paramBoolean) || (!bdal.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[3], paramCard.strContactName)))
        {
          bool1 = true;
          label220:
          this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[3] = paramCard.strContactName;
        }
      }
      else
      {
        paramBoolean = bool1;
        if (!TextUtils.isEmpty(paramCard.strAutoRemark)) {
          if ((!bool1) && (bdal.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[2], paramCard.strAutoRemark))) {
            break label511;
          }
        }
      }
      label496:
      label501:
      label511:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[2] = paramCard.strAutoRemark;
        if (QLog.isColorLevel())
        {
          paramCard = new StringBuilder();
          paramCard.append("updateNameList()").append(", bRet = ").append(paramBoolean).append(", strNick = ");
          paramCard.append(bdal.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[0])).append(", strRemark = ");
          paramCard.append(bdal.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[4])).append(", strContactName = ");
          paramCard.append(bdal.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[3])).append(", strCircleName = ");
          paramCard.append(bdal.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[2])).append(", strRecommenName = ");
          paramCard.append(bdal.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[5])).append(", strTroopNickName = ");
          paramCard.append(bdal.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[1])).append(", strAutoRemark = ");
          paramCard.append(bdal.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[6]));
          QLog.d("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
        }
        return paramBoolean;
        bool2 = false;
        break;
        bool1 = false;
        break label114;
        paramBoolean = false;
        break label169;
        bool1 = false;
        break label220;
      }
      bool2 = false;
    }
  }
  
  public boolean a(ContactCard paramContactCard, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramContactCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by ContactCard");
      }
      return false;
    }
    if ((paramBoolean) || (!TextUtils.isEmpty(paramContactCard.nickName))) {
      if (!bdal.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[0], paramContactCard.nickName))
      {
        paramBoolean = true;
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[0] = paramContactCard.nickName;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContactCard.strContactName))
      {
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (bdal.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[3], paramContactCard.strContactName)) {}
        }
        else
        {
          paramBoolean = true;
        }
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[3] = paramContactCard.strContactName;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {
          paramBoolean = bool1;
        }
        for (;;)
        {
          return paramBoolean;
          paramBoolean = false;
          break;
        }
      }
      paramBoolean = false;
    }
  }
  
  boolean a(QCallCardInfo paramQCallCardInfo, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramQCallCardInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateQCallCardName by QCallCardInfo");
      }
    }
    while ((!paramBoolean) && (TextUtils.isEmpty(paramQCallCardInfo.nickname))) {
      return false;
    }
    paramBoolean = bool;
    if (!bdal.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo.nickname, paramQCallCardInfo.nickname)) {
      paramBoolean = true;
    }
    this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo.nickname = paramQCallCardInfo.nickname;
    return paramBoolean;
  }
  
  public String b()
  {
    if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
      return this.jdField_i_of_type_JavaLangString;
    }
    ThreadManager.post(new FriendProfileCardActivity.54(this), 8, null, true);
    return "-1";
  }
  
  protected void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.card.modify");
    localIntentFilter.addAction("com.tencent.mobileqq.view.self.album");
    localIntentFilter.addAction("com.tencent.mobileqq.card.modify_personality_label");
    localIntentFilter.setPriority(2147483647);
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.FrdProfileCard", 2, localThrowable.toString());
    }
  }
  
  public void b(int paramInt)
  {
    azmj.b(this.app, "dc00898", "", "", "0X800A88A", "0X800A88A", paramInt, 0, "", "", "", "");
  }
  
  public void b(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.jdField_c_of_type_JavaLangString;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label128;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse("smsto:" + paramCardContactInfo));
      startActivity(localIntent);
    }
    for (;;)
    {
      azmj.b(this.app, "CliOper", "", "", "P_prof", "send_sms", a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label128:
      a(2131693561, 1);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString = paramString;
    a(this.jdField_a_of_type_Awmk, 4, paramString);
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_Bcuo == null) {
      this.jdField_a_of_type_Awmk.jdField_a_of_type_Bcuo = new bcuo();
    }
    paramString = (bcuo)this.jdField_a_of_type_Awmk.jdField_a_of_type_Bcuo.clone();
    b(this.jdField_a_of_type_Awmk);
    switch (paramString.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_Bcuo))
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Awmk, true, new String[] { "map_key_qzone", "map_key_account_base_info" });
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.f(this.jdField_a_of_type_Awmk);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.f(this.jdField_a_of_type_Awmk);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update buttons");
    }
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      c(1);
    }
    label282:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)
      {
        c(9);
        return;
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) {
        break;
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataContactCard.bindQQ) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)) {
          if (TextUtils.equals(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, this.app.getCurrentAccountUin()))
          {
            c(0);
            this.jdField_h_of_type_Int = 0;
          }
        }
      }
      for (;;)
      {
        if ((!paramBoolean) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 105)) {
          break label282;
        }
        azmj.b(this.app, "CliOper", "", "", "0X800716B", "0X800716B", this.jdField_h_of_type_Int, 0, "", "", "", "");
        return;
        c(4);
        break;
        if (((aubm)this.app.getManager(11)).c(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo) != null)
        {
          this.jdField_h_of_type_Int = 1;
          if (this.jdField_a_of_type_Awmk.jdField_b_of_type_Boolean) {}
          for (int i1 = 12;; i1 = 2)
          {
            c(i1);
            break;
          }
        }
        this.jdField_h_of_type_Int = 2;
        c(11);
        continue;
        this.jdField_h_of_type_Int = 3;
        c(10);
      }
    }
    boolean bool4 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    paramBoolean = ProfileActivity.AllInOne.c(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 113)
    {
      paramBoolean = false;
      bool1 = false;
    }
    boolean bool2 = bool1;
    boolean bool3 = bool4;
    if (bdal.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (!this.q) {
        break label564;
      }
      paramBoolean = false;
      bool2 = false;
    }
    for (bool3 = false;; bool3 = bool4)
    {
      bool1 = bool2;
      if (ProfileActivity.AllInOne.k(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_ArrayOfByte != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_c_of_type_ArrayOfByte.length > 0) {
            bool1 = true;
          }
        }
      }
      if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        paramBoolean = false;
      }
      if ((bool1) && (this.jdField_a_of_type_Awmk.jdField_b_of_type_Boolean))
      {
        c(12);
        return;
      }
      if ((bool3) && (bool1) && (paramBoolean))
      {
        c(2);
        return;
      }
      if ((bool3) && (bool1))
      {
        c(3);
        return;
      }
      if ((bool1) && (paramBoolean))
      {
        c(4);
        return;
      }
      if ((bool3) && (paramBoolean))
      {
        c(5);
        return;
      }
      if (bool3)
      {
        c(6);
        return;
      }
      if (bool1)
      {
        c(7);
        return;
      }
      if (paramBoolean)
      {
        c(5);
        return;
      }
      c(0);
      return;
      label564:
      paramBoolean = false;
      bool2 = bool1;
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      if ((this.jdField_a_of_type_Awmk != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null))
      {
        if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.checkCoverUrl(paramArrayOfByte)) {
          this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.updateCoverData(paramArrayOfByte);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) {
          ((ProfileBaseView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).a(this.jdField_a_of_type_Awmk, false);
        }
        ThreadManager.excute(new FriendProfileCardActivity.63(this), 16, null, false);
      }
    }
    for (;;)
    {
      azmj.b(this.app, "dc00898", "", "", "0X8007EC2", "0X8007EC2", 0, 0, "", "", "", "");
      return;
      a(0L, null, null, false);
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (apwx.a(this.app.getCurrentAccountUin()))
    {
      if (this.jdField_c_of_type_AndroidAppDialog == null) {
        this.jdField_c_of_type_AndroidAppDialog = aqdo.a(this);
      }
      if ((!this.jdField_c_of_type_AndroidAppDialog.isShowing()) && (!isFinishing())) {
        this.jdField_c_of_type_AndroidAppDialog.show();
      }
      azmj.b(this.app, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
      bool = true;
    }
    return bool;
  }
  
  public boolean b(awmk paramawmk)
  {
    if ((paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramawmk.jdField_a_of_type_ComTencentMobileqqDataCard.mNowShowFlag != 1)) {
      return false;
    }
    return this.jdField_a_of_type_Beox.a(0);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      this.jdField_b_of_type_Bhow.sendEmptyMessage(103);
    }
  }
  
  void c(int paramInt)
  {
    Object localObject;
    int i2;
    int i1;
    if ((this.jdField_a_of_type_Awmk.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_Awmk.jdField_a_of_type_JavaLangString)))
    {
      localObject = ((TroopManager)this.app.getManager(52)).c(this.jdField_a_of_type_Awmk.jdField_a_of_type_JavaLangString);
      a((TroopInfo)localObject);
      if ((((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        i2 = 1;
        i1 = 1;
      }
    }
    for (;;)
    {
      int i4 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int i3 = 0;
      for (;;)
      {
        if (i3 < i4)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i3);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          i3 += 1;
          continue;
          i2 = 0;
          i1 = 0;
          break;
        }
      }
      switch (paramInt)
      {
      default: 
        i1 = 0;
        localObject = findViewById(2131372286);
        if (i1 != 0)
        {
          paramInt = 0;
          ((View)localObject).setVisibility(paramInt);
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if (i1 == 0) {
            break label1153;
          }
          paramInt = 0;
          ((LinearLayout)localObject).setVisibility(paramInt);
        }
        break;
      case 1: 
        label237:
        label255:
        if (this.jdField_a_of_type_Awmk.jdField_b_of_type_Boolean)
        {
          if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 23, 2131695561, 1, 2131691255);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 81, 2131693557, 1, 2131691203);
          localObject = (aloz)this.app.getManager(51);
          if (localObject == null) {
            break label1159;
          }
        }
        label327:
        break;
      }
      label1153:
      label1159:
      for (boolean bool = ((aloz)localObject).b(this.app.c());; bool = true)
      {
        if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (!bool))
        {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 7, 2131693525, 2, 2131691190);
          break;
          if (bdia.a(this.app))
          {
            S();
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 92, 2131695562, 1, 2131695562);
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 81, 2131693557, 1, 2131691203);
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1));
            break label327;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 23, 2131695561, 1, 2131691255);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 81, 2131693557, 1, 2131691203);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1));
          break label327;
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131719755, 2, 2131691272);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131693525, 1, 2131691190);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 20, this.jdField_a_of_type_Beox.a(), 1, this.jdField_a_of_type_Beox.a(), 0);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131719755, 2, 2131691272);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131693525, 1, 2131691190);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131719755, 2, 2131691272);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_Beox.a(), 1, this.jdField_a_of_type_Beox.a(), 0);
        if ((i2 == 0) && (!azwu.a()))
        {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 95, 2131699181, 1, 2131699181);
          azmj.b(this.app, "", "", "", "0X800A1C4", "0X800A1C4", 0, 0, "", "", "", "");
        }
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131719755, 2, 2131691272);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131693525, 1, 2131691190);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 20, this.jdField_a_of_type_Beox.a(), 1, this.jdField_a_of_type_Beox.a(), 0);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 7, 2131693525, 2, 2131691190);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131719755, 2, 2131691272);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_Beox.a(), 1, this.jdField_a_of_type_Beox.a(), 0);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_Beox.a(), 1, this.jdField_a_of_type_Beox.a(), 0);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 59, 2131693611, 1, 2131693611);
        break;
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 59, 2131693611, 1, 2131693611);
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 7, 2131693525, 2, 2131691190);
        break;
        if (ProfileActivity.AllInOne.d(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 7, 2131693525, 1, 2131691190);
        }
        for (;;)
        {
          if ((i2 == 0) && (!azwu.a())) {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 77, 2131699181, 1, 2131699181);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 8, 2131719755, 2, 2131691272);
          break;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, this.jdField_a_of_type_Beox.a(), 1, this.jdField_a_of_type_Beox.a(), 0);
        }
        paramInt = 8;
        break label237;
        paramInt = 8;
        break label255;
      }
      i2 = 0;
      i1 = 1;
    }
  }
  
  public void c(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo == null)
    {
      paramCardContactInfo = null;
      if ((paramCardContactInfo != null) && (paramCardContactInfo.length() > 0))
      {
        if (!bdee.d(BaseApplication.getContext())) {
          break label183;
        }
        if (("".equals(paramCardContactInfo)) || (paramCardContactInfo.equals(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString))) {
          break label172;
        }
        FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
        if (localFriendListHandler == null) {
          break label161;
        }
        localFriendListHandler.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramCardContactInfo, false);
        this.jdField_c_of_type_Int |= 0x1;
        b(paramCardContactInfo);
      }
    }
    for (;;)
    {
      azmj.b(this.app, "CliOper", "", "", "P_prof", "Edit_name", a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = paramCardContactInfo.jdField_a_of_type_JavaLangString;
      break;
      label161:
      a(2131693626, 1);
      continue;
      label172:
      a(2131693607, 1);
      continue;
      label183:
      a(2131694827, 1);
    }
  }
  
  void c(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if ((this.jdField_a_of_type_Zcp != null) && (!this.jdField_a_of_type_Zcp.isShowing()))
    {
      this.jdField_a_of_type_Zcp.show();
      return;
    }
    this.jdField_a_of_type_Zcp = new zcp(this);
    this.jdField_a_of_type_Zcp.a(getResources().getString(2131698891));
    String str2 = getString(2131719909);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramString = new acwh(this, this);
    this.jdField_a_of_type_Zcp.a(str1, paramString);
    this.jdField_a_of_type_Zcp.a(paramString);
    this.jdField_a_of_type_Zcp.show();
  }
  
  void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initCardContactInfoList");
    }
    Object localObject3;
    if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 29) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53))
    {
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        localObject3 = (aubm)this.app.getManager(11);
        if (localObject3 != null) {
          break label230;
        }
      }
    }
    label230:
    label490:
    do
    {
      return;
      Object localObject1;
      Object localObject2;
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject1 = ((aubm)localObject3).a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject2 = localObject1;
        if (paramBoolean) {
          break label490;
        }
        localObject2 = (FriendListHandler)this.app.a(1);
        if ((!((FriendListHandler)localObject2).b()) && (!((FriendListHandler)localObject2).c())) {
          ((FriendListHandler)localObject2).c(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
        }
      }
      while (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
      {
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
        return;
        localObject2 = ((aubm)localObject3).c(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = ((aubm)localObject3).b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((PhoneContact)localObject2).mobileCode))
            {
              this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject2).mobileCode;
              localObject1 = localObject2;
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject3 = (FriendListHandler)this.app.a(1);
          localObject2 = localObject1;
          if (!((FriendListHandler)localObject3).c())
          {
            ((FriendListHandler)localObject3).c(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
            localObject2 = localObject1;
          }
        }
        localObject1 = localObject2;
      }
      if (localObject1 != null)
      {
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
        return;
      }
    } while ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 29));
    this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo("", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
  }
  
  public boolean c()
  {
    if (this.jdField_e_of_type_Int > 3) {
      return false;
    }
    this.jdField_e_of_type_Int += 1;
    return true;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendProfileCardActivity", 2, "savePersonalibyLabel2Card");
    }
    ThreadManager.postImmediately(new FriendProfileCardActivity.17(this, (awlp)this.app.a(112)), null, true);
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("scrollToExtendsFriendInfo offset=%s isFromExtendFriend=%s hasScrollToExtendFriend=%s hasPause=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_k_of_type_Boolean), Boolean.valueOf(this.t), Boolean.valueOf(this.s) }));
    }
    if ((this.jdField_k_of_type_Boolean) && (!this.s) && (!this.t) && (!this.jdField_m_of_type_Boolean))
    {
      this.t = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof VipProfileSimpleView))
      {
        ((VipProfileSimpleView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).d();
        paramInt = getResources().getDisplayMetrics().heightPixels / 2 + paramInt;
        paramInt -= getTitleBarHeight();
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, String.format("scrollToExtendsFriendInfo offset=%s", new Object[] { Integer.valueOf(paramInt) }));
        }
        e(paramInt);
      }
    }
    while ((!this.jdField_k_of_type_Boolean) || (this.s) || (!this.t)) {
      for (;;)
      {
        return;
        paramInt = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getHeight() + paramInt;
      }
    }
    this.jdField_m_of_type_Long = System.currentTimeMillis();
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_k_of_type_Long = NetConnInfoCenter.getServerTime();
      return;
    }
    this.jdField_k_of_type_Long = 0L;
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.jdField_k_of_type_Long != 0L)
    {
      if (Math.abs(this.jdField_k_of_type_Long - NetConnInfoCenter.getServerTime()) < 60L) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1)
      {
        this.jdField_k_of_type_Long = 0L;
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    Object localObject2;
    aloz localaloz;
    if (paramInt1 == 1037) {
      if ((paramInt2 == -1) && (paramIntent != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
      {
        localObject2 = paramIntent.getStringArrayListExtra("imageUrl");
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
        {
          localaloz = (aloz)this.app.getManager(51);
          if (localaloz != null) {
            break label193;
          }
          if (localObject1 != null)
          {
            ((Card)localObject1).addQzonePhotoList((ArrayList)localObject2, paramIntent);
            ((Card)localObject1).hasFakeData = true;
            this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Awmk, false, new String[] { "map_key_qzone" });
          }
        }
      }
    }
    label193:
    do
    {
      for (;;)
      {
        return;
        localObject1 = localaloz.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        if (paramInt1 == 1019)
        {
          if (this.jdField_a_of_type_Acxw != null) {
            this.jdField_a_of_type_Acxw.a(paramInt2, paramIntent);
          }
        }
        else if (paramInt1 == 1024)
        {
          if (this.jdField_a_of_type_Acxw != null) {
            this.jdField_a_of_type_Acxw.b(paramInt2, paramIntent);
          }
        }
        else
        {
          if (paramInt1 == 1022)
          {
            ((alkv)this.app.a(2)).a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
            b(paramIntent);
            return;
          }
          if (paramInt1 == 4)
          {
            if ((paramInt2 == -1) && (paramIntent != null)) {
              if (paramIntent.hasExtra("result"))
              {
                paramIntent = paramIntent.getStringExtra("result");
                if (QLog.isColorLevel()) {
                  QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultStr : " + paramIntent);
                }
                if (!TextUtils.isEmpty(paramIntent))
                {
                  try
                  {
                    paramIntent = new JSONObject(paramIntent);
                    if (paramIntent == null) {
                      continue;
                    }
                    paramIntent = paramIntent.get("payState");
                    if ((paramIntent == null) || (!"0".equals(String.valueOf(paramIntent)))) {
                      continue;
                    }
                    a(0L, null, null, false);
                    return;
                  }
                  catch (JSONException paramIntent)
                  {
                    paramIntent.printStackTrace();
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.e("FriendProfileCardActivity", 2, "onActivityResult, JSONException : " + paramIntent.getMessage());
                    return;
                  }
                  catch (Exception paramIntent)
                  {
                    paramIntent.printStackTrace();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.e("FriendProfileCardActivity", 2, "onActivityResult, Exception : " + paramIntent.getMessage());
                  }
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.e("FriendProfileCardActivity", 2, "onActivityResult, data contain no result key.");
              }
            }
          }
          else if (paramInt1 == 1024)
          {
            if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("has_operation", false))) {
              this.jdField_a_of_type_AndroidContentIntent = paramIntent;
            }
          }
          else if (paramInt1 == 1026)
          {
            if ((paramInt2 != 1001) && (this.jdField_a_of_type_Awmk != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
            {
              this.jdField_a_of_type_Bdjk = new bdjk();
              this.jdField_f_of_type_Boolean = false;
              this.jdField_e_of_type_Int = 0;
              if (this.jdField_a_of_type_Bhow != null)
              {
                paramIntent = this.jdField_a_of_type_Bhow.obtainMessage();
                if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
                {
                  paramIntent.what = 1;
                  paramIntent.obj = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
                  this.jdField_a_of_type_Bhow.sendMessage(paramIntent);
                }
              }
            }
          }
          else if (paramInt1 == 1010)
          {
            if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 101) && (paramInt2 == -1)) {
              finish();
            }
          }
          else if (paramInt1 == 1008)
          {
            if ((paramIntent != null) && (paramIntent.getExtras() != null))
            {
              bool1 = paramIntent.getExtras().getBoolean("photowall_updated");
              paramIntent = (CoverCacheData)paramIntent.getExtras().getParcelable("current_cover");
              if (((paramInt2 == -1) || (bool1)) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
                this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramIntent);
              }
              if (paramIntent == null) {
                continue;
              }
              localObject1 = Message.obtain();
              ((Message)localObject1).what = 3;
              ((Message)localObject1).obj = paramIntent;
              if (this.jdField_a_of_type_Bhow == null) {
                continue;
              }
              this.jdField_a_of_type_Bhow.sendMessage((Message)localObject1);
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
              continue;
            }
            try
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a();
              if (localObject1 != null)
              {
                paramIntent = new CoverCacheData();
                paramIntent.jdField_c_of_type_JavaLangString = ((CoverCacheData)localObject1).jdField_c_of_type_JavaLangString;
                paramIntent.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo = ((CoverCacheData)localObject1).jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo;
                paramIntent.jdField_a_of_type_JavaUtilArrayList = ((CoverCacheData)localObject1).jdField_a_of_type_JavaUtilArrayList;
                paramIntent.jdField_b_of_type_JavaLangString = ((CoverCacheData)localObject1).jdField_b_of_type_JavaLangString;
                paramIntent.jdField_a_of_type_Long = ((CoverCacheData)localObject1).jdField_a_of_type_Long;
                paramIntent.jdField_a_of_type_JavaUtilHashMap = ((CoverCacheData)localObject1).jdField_a_of_type_JavaUtilHashMap;
                paramIntent.jdField_a_of_type_Int = 0;
                paramIntent.jdField_a_of_type_Int = 0;
                this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramIntent);
                localObject1 = Message.obtain();
                ((Message)localObject1).what = 3;
                ((Message)localObject1).obj = paramIntent;
                if (this.jdField_a_of_type_Bhow != null)
                {
                  this.jdField_a_of_type_Bhow.sendMessage((Message)localObject1);
                  return;
                }
              }
            }
            catch (Exception paramIntent)
            {
              paramIntent.printStackTrace();
              return;
            }
          }
        }
      }
      if (paramInt1 != 1007) {
        break label1296;
      }
    } while (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0);
    localObject1 = (aloz)this.app.getManager(51);
    if (localObject1 == null)
    {
      localObject2 = null;
      label1001:
      if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
      {
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject2);
        this.jdField_a_of_type_Awmk.jdField_a_of_type_Bcuo.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString = ((Card)localObject2).strNick;
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[0] = ((Card)localObject2).strNick;
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[4] = "";
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b(this.jdField_a_of_type_Awmk);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.f(this.jdField_a_of_type_Awmk);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Awmk, true, new String[] { "map_key_sig", "map_key_qzone", "map_key_account_base_info" });
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)))
        {
          if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
            break label1236;
          }
          localObject1 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
        }
      }
    }
    for (;;)
    {
      a(((Card)localObject2).feedPreviewTime, ((Card)localObject2).vSeed, (byte[])localObject1, true);
      setResult(-1, paramIntent);
      return;
      localObject2 = ((aloz)localObject1).b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break label1001;
      label1236:
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 35) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 37) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36))
      {
        localObject1 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
        continue;
        if (paramInt1 == 1029)
        {
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder().append("back from personality label gallery. resultcode==ok ");
            if (paramInt2 != -1) {
              break label1490;
            }
          }
          for (bool1 = bool2;; bool1 = false)
          {
            QLog.i("FriendProfileCardActivity", 2, bool1);
            if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel.unreadCount > 0))
            {
              this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel.unreadCount = 0;
              if (QLog.isColorLevel()) {
                QLog.i("FriendProfileCardActivity", 2, "back from personality label gallery.clear vote");
              }
              if (this.jdField_a_of_type_Awkn != null) {
                this.jdField_a_of_type_Awkn.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel, false, false);
              }
              d();
            }
            paramIntent = (awlp)this.app.a(112);
            if (paramInt2 != -1) {
              break;
            }
            paramIntent.a(getCurrentAccountUin(), 0);
            return;
          }
        }
        if (paramInt1 == 1027)
        {
          bool2 = avoo.a(this.app);
          if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendProfileCardActivity", 2, "update from medal, config=" + bool2 + " myProfile=" + bool1);
            }
            if ((!bool2) || (!bool1)) {
              break;
            }
            a(0L, null, null, false);
            return;
            bool1 = false;
          }
        }
        if (paramInt1 == 1035)
        {
          if (this.jdField_a_of_type_Aikl == null) {
            break;
          }
          this.jdField_a_of_type_Aikl.a(paramInt2, paramIntent);
          return;
        }
        if (paramInt2 != -1) {
          break;
        }
      }
      label1296:
      label1490:
      switch (paramInt1)
      {
      default: 
        return;
      case 5: 
        paramIntent = bdda.b(this, this.jdField_a_of_type_AndroidNetUri);
        paramInt1 = bcyw.b(this);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Business_Origin", 100);
        PhotoUtils.a((Intent)localObject1, this, FriendProfileCardActivity.class.getName(), paramInt1, paramInt1, 1080, 1080, paramIntent, bcyw.a());
        return;
      case 1012: 
        if (paramIntent == null) {
          break;
        }
        if (paramIntent.getBooleanExtra("finchat", false)) {
          finish();
        }
        for (;;)
        {
          b(paramIntent);
          return;
          localObject1 = paramIntent.getStringExtra("remark");
          if (!bdal.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString, localObject1)) {
            b((String)localObject1);
          }
        }
      case 21: 
        paramIntent.putExtra("selfSet_leftViewText", getString(2131720570));
        localObject1 = aekt.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject1).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.a((Intent)localObject1);
        ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject1);
        return;
      case 1000: 
        setResult(-1);
        finish();
        return;
      case 800: 
        if (!bdee.d(BaseApplication.getContext()))
        {
          a(2131694829, 1);
          return;
        }
        bool1 = bool3;
        if (paramIntent != null) {
          bool1 = paramIntent.getBooleanExtra("avatar_changed", false);
        }
        if (!bool1) {
          break;
        }
        localObject1 = paramIntent.getStringExtra("avatar_filepath");
        if (bcyw.a(this.app, (String)localObject1, paramIntent))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          return;
        }
        a(2131719794, 1);
        return;
      case 1004: 
        paramIntent = ((aloz)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
        if ((paramIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null)) {
          break;
        }
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard = paramIntent;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Awmk, true, new String[] { "map_key_tag" });
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.l(this.jdField_a_of_type_Awmk);
        return;
      case 1018: 
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int = 1;
        return;
      case 600001: 
        paramIntent = new Intent(this, FriendProfileCardActivity.class);
        paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0));
        paramIntent.putExtra("diyTextEditResult", true);
        startActivity(paramIntent);
        finish();
        return;
      case 8: 
        bool1 = paramIntent.getBooleanExtra("extra_is_deleted", false);
        bool2 = paramIntent.getBooleanExtra("extra_is_msg_tip_modify", false);
        bool3 = paramIntent.getBooleanExtra("extra_is_admin_modify", false);
        boolean bool4 = paramIntent.getBooleanExtra("isNeedFinish", false);
        boolean bool5 = paramIntent.getBooleanExtra("extra_is_level_modify", false);
        if ((bool2) || (bool5)) {
          a(2);
        }
        if (bool3) {
          a(4);
        }
        if (bool1) {
          a(1);
        }
        if (!bool4) {
          break;
        }
        paramIntent = new Intent();
        if (!bool1)
        {
          paramIntent.putExtra("isNeedFinish", bool4);
          setResult(-1, paramIntent);
        }
        for (;;)
        {
          finish();
          return;
          if (this.jdField_a_of_type_Awmk.jdField_a_of_type_Int == 8)
          {
            paramIntent.putExtra("key_troop_fee_notify_js_data_changed", true);
            paramIntent.putExtra("callback", this.jdField_h_of_type_JavaLangString);
            setResult(-1, paramIntent);
          }
        }
      case 1034: 
        paramInt1 = paramIntent.getIntExtra("edit_action", 0);
        paramIntent = paramIntent.getStringExtra("nick");
        if ((paramInt1 == 3) || (paramInt1 == 4))
        {
          this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[1] = paramIntent;
          return;
        }
        if (paramInt1 == 1)
        {
          this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[0] = paramIntent;
          return;
        }
        if (paramInt1 != 2) {
          break;
        }
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString[4] = paramIntent;
        return;
        localObject1 = null;
      }
    }
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: getstatic 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   3: iconst_1
    //   4: invokevirtual 3853	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   7: pop
    //   8: aload_0
    //   9: invokevirtual 3857	com/tencent/mobileqq/activity/FriendProfileCardActivity:getWindow	()Landroid/view/Window;
    //   12: bipush 253
    //   14: invokevirtual 3862	android/view/Window:setFormat	(I)V
    //   17: aload_0
    //   18: invokevirtual 3857	com/tencent/mobileqq/activity/FriendProfileCardActivity:getWindow	()Landroid/view/Window;
    //   21: new 3864	android/graphics/drawable/ColorDrawable
    //   24: dup
    //   25: iconst_m1
    //   26: invokespecial 3865	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   29: invokevirtual 3868	android/view/Window:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   32: getstatic 2036	bhoh:a	Lbhoh;
    //   35: astore 4
    //   37: aload 4
    //   39: ifnull +29 -> 68
    //   42: aload 4
    //   44: invokevirtual 2038	bhoh:a	()Z
    //   47: ifeq +21 -> 68
    //   50: aload 4
    //   52: iconst_0
    //   53: invokevirtual 3030	bhoh:b	(I)V
    //   56: aload 4
    //   58: iconst_1
    //   59: invokevirtual 2040	bhoh:a	(I)V
    //   62: aload 4
    //   64: iconst_2
    //   65: invokevirtual 2040	bhoh:a	(I)V
    //   68: aload_0
    //   69: new 2355	bdjk
    //   72: dup
    //   73: ldc_w 495
    //   76: invokespecial 3869	bdjk:<init>	(Ljava/lang/String;)V
    //   79: putfield 2351	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Bdjk	Lbdjk;
    //   82: aload_0
    //   83: invokevirtual 1893	com/tencent/mobileqq/activity/FriendProfileCardActivity:getIntent	()Landroid/content/Intent;
    //   86: astore 4
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 3872	com/tencent/mobileqq/activity/FriendProfileCardActivity:mActNeedImmersive	Z
    //   93: aload_0
    //   94: aload_1
    //   95: invokespecial 3874	com/tencent/mobileqq/activity/ProfileActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   98: pop
    //   99: aload_0
    //   100: getfield 2351	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Bdjk	Lbdjk;
    //   103: ldc_w 3876
    //   106: iconst_0
    //   107: invokevirtual 2358	bdjk:a	(Ljava/lang/String;Z)V
    //   110: aload_0
    //   111: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: ifnull +21 -> 135
    //   117: aload_0
    //   118: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   121: invokevirtual 3879	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   124: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +8 -> 135
    //   130: aload 4
    //   132: ifnonnull +9 -> 141
    //   135: aload_0
    //   136: invokevirtual 3726	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: aload_0
    //   142: aload 4
    //   144: ldc_w 3881
    //   147: iconst_0
    //   148: invokevirtual 1408	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   151: putfield 1478	com/tencent/mobileqq/activity/FriendProfileCardActivity:q	Z
    //   154: aload 4
    //   156: ldc_w 3883
    //   159: invokevirtual 2751	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   162: ifeq +44 -> 206
    //   165: aload 4
    //   167: ldc_w 3883
    //   170: invokevirtual 3887	android/content/Intent:getSerializableExtra	(Ljava/lang/String;)Ljava/io/Serializable;
    //   173: astore_1
    //   174: aload_1
    //   175: ifnull +31 -> 206
    //   178: aload_0
    //   179: invokestatic 3892	com/tencent/mobileqq/activity/KPLProfileCardActivity:a	(Landroid/content/Context;)Landroid/content/Intent;
    //   182: astore 4
    //   184: aload 4
    //   186: ldc_w 3883
    //   189: aload_1
    //   190: invokevirtual 3895	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   193: pop
    //   194: aload_0
    //   195: aload 4
    //   197: invokevirtual 1905	com/tencent/mobileqq/activity/FriendProfileCardActivity:startActivity	(Landroid/content/Intent;)V
    //   200: aload_0
    //   201: invokevirtual 3726	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   204: iconst_0
    //   205: ireturn
    //   206: aload_0
    //   207: aload 4
    //   209: ldc_w 3897
    //   212: iconst_0
    //   213: invokevirtual 1408	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   216: putfield 3631	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_k_of_type_Boolean	Z
    //   219: aload_0
    //   220: aload 4
    //   222: ldc_w 3899
    //   225: iconst_0
    //   226: invokevirtual 1408	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   229: putfield 1659	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_l_of_type_Boolean	Z
    //   232: aload_0
    //   233: aload 4
    //   235: ldc_w 3901
    //   238: iconst_0
    //   239: invokevirtual 1408	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   242: putfield 3637	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_m_of_type_Boolean	Z
    //   245: aload_0
    //   246: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   249: aload_0
    //   250: getfield 313	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   253: putfield 3902	awmk:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   256: aload_0
    //   257: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   260: aload_0
    //   261: getfield 308	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidViewView$OnLongClickListener	Landroid/view/View$OnLongClickListener;
    //   264: putfield 3903	awmk:jdField_a_of_type_AndroidViewView$OnLongClickListener	Landroid/view/View$OnLongClickListener;
    //   267: aload 4
    //   269: ldc_w 3825
    //   272: invokevirtual 3906	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   275: checkcast 465	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   278: astore_1
    //   279: aload 4
    //   281: ldc_w 2748
    //   284: invokevirtual 2751	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   287: istore_3
    //   288: iload_3
    //   289: ifeq +1736 -> 2025
    //   292: aload_0
    //   293: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   296: aload 4
    //   298: ldc_w 2748
    //   301: invokevirtual 1425	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   304: putfield 532	awmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   307: aload_1
    //   308: ifnonnull +1714 -> 2022
    //   311: aload 4
    //   313: ldc_w 3908
    //   316: invokevirtual 1425	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   319: astore_1
    //   320: aload_1
    //   321: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   324: ifeq +1695 -> 2019
    //   327: aload_0
    //   328: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   331: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   334: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   337: astore_1
    //   338: aload_0
    //   339: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   342: bipush 51
    //   344: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   347: checkcast 670	aloz
    //   350: aload_1
    //   351: invokevirtual 3910	aloz:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   354: astore 5
    //   356: aload 5
    //   358: ifnull +313 -> 671
    //   361: aload 5
    //   363: invokevirtual 3197	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   366: ifeq +305 -> 671
    //   369: new 465	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   372: dup
    //   373: aload_1
    //   374: iconst_1
    //   375: invokespecial 3827	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   378: astore_1
    //   379: aload_1
    //   380: aload 5
    //   382: getfield 1220	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   385: putfield 1044	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   388: aload_1
    //   389: aload 5
    //   391: getfield 1223	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   394: putfield 1043	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   397: aload_0
    //   398: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   401: new 675	com/tencent/mobileqq/data/TroopMemberCard
    //   404: dup
    //   405: invokespecial 3911	com/tencent/mobileqq/data/TroopMemberCard:<init>	()V
    //   408: putfield 673	awmk:jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard	Lcom/tencent/mobileqq/data/TroopMemberCard;
    //   411: aload_0
    //   412: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   415: aload 4
    //   417: ldc_w 3913
    //   420: iconst_m1
    //   421: invokevirtual 1432	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   424: putfield 2055	awmk:jdField_a_of_type_Int	I
    //   427: aload_0
    //   428: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   431: getfield 2055	awmk:jdField_a_of_type_Int	I
    //   434: bipush 8
    //   436: if_icmpne +15 -> 451
    //   439: aload_0
    //   440: aload 4
    //   442: ldc_w 3845
    //   445: invokevirtual 1425	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   448: putfield 197	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   451: aload_0
    //   452: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   455: getfield 2055	awmk:jdField_a_of_type_Int	I
    //   458: iconst_4
    //   459: if_icmpne +39 -> 498
    //   462: aload_0
    //   463: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   466: ldc_w 1571
    //   469: ldc_w 3915
    //   472: ldc 169
    //   474: ldc_w 3917
    //   477: ldc_w 3919
    //   480: iconst_0
    //   481: iconst_0
    //   482: aload_0
    //   483: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   486: getfield 532	awmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   489: ldc 169
    //   491: ldc 169
    //   493: ldc 169
    //   495: invokestatic 634	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   498: aload_1
    //   499: ifnull +37 -> 536
    //   502: aload_0
    //   503: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   506: getfield 532	awmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   509: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   512: ifne +24 -> 536
    //   515: aload_1
    //   516: getfield 1440	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   519: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   522: ifeq +14 -> 536
    //   525: aload_1
    //   526: aload_0
    //   527: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   530: getfield 532	awmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   533: putfield 1440	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   536: aload_1
    //   537: ifnull +46 -> 583
    //   540: aload_1
    //   541: getfield 1440	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   544: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   547: ifne +36 -> 583
    //   550: aload_1
    //   551: getfield 1050	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   554: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   557: ifeq +26 -> 583
    //   560: aload_1
    //   561: aload_0
    //   562: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   565: bipush 52
    //   567: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   570: checkcast 526	com/tencent/mobileqq/app/TroopManager
    //   573: aload_1
    //   574: getfield 1440	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   577: invokevirtual 3921	com/tencent/mobileqq/app/TroopManager:d	(Ljava/lang/String;)Ljava/lang/String;
    //   580: putfield 1050	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   583: new 3923	azmo
    //   586: dup
    //   587: aload_0
    //   588: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   591: invokespecial 3925	azmo:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   594: ldc_w 3927
    //   597: invokevirtual 3930	azmo:a	(Ljava/lang/String;)Lazmo;
    //   600: ldc_w 3932
    //   603: invokevirtual 3934	azmo:b	(Ljava/lang/String;)Lazmo;
    //   606: ldc_w 3936
    //   609: invokevirtual 3938	azmo:c	(Ljava/lang/String;)Lazmo;
    //   612: ldc_w 3940
    //   615: invokevirtual 3942	azmo:d	(Ljava/lang/String;)Lazmo;
    //   618: iconst_1
    //   619: anewarray 484	java/lang/String
    //   622: dup
    //   623: iconst_0
    //   624: aload_0
    //   625: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   628: getfield 532	awmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   631: aastore
    //   632: invokevirtual 3945	azmo:a	([Ljava/lang/String;)Lazmo;
    //   635: invokevirtual 3946	azmo:a	()V
    //   638: aload_0
    //   639: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   642: iload_3
    //   643: putfield 501	awmk:jdField_b_of_type_Boolean	Z
    //   646: aload_0
    //   647: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   650: aload_1
    //   651: putfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   654: aload_0
    //   655: aload_0
    //   656: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   659: invokevirtual 3948	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lawmk;)Z
    //   662: ifne +29 -> 691
    //   665: aload_0
    //   666: invokevirtual 3726	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   669: iconst_0
    //   670: ireturn
    //   671: new 465	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   674: dup
    //   675: aload_1
    //   676: bipush 21
    //   678: invokespecial 3827	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   681: astore_1
    //   682: aload_1
    //   683: bipush 11
    //   685: putfield 1360	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_l_of_type_Int	I
    //   688: goto -291 -> 397
    //   691: aload_1
    //   692: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   695: invokestatic 3512	bdal:b	(Ljava/lang/String;)Z
    //   698: ifeq +25 -> 723
    //   701: aload_0
    //   702: invokevirtual 2167	com/tencent/mobileqq/activity/FriendProfileCardActivity:getApplicationContext	()Landroid/content/Context;
    //   705: invokestatic 3950	bdal:a	(Landroid/content/Context;)Z
    //   708: ifeq +15 -> 723
    //   711: aload_0
    //   712: iconst_0
    //   713: iconst_0
    //   714: invokevirtual 3953	com/tencent/mobileqq/activity/FriendProfileCardActivity:overridePendingTransition	(II)V
    //   717: aload_0
    //   718: invokevirtual 3726	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   721: iconst_0
    //   722: ireturn
    //   723: aload_0
    //   724: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   727: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   730: getfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   733: bipush 90
    //   735: if_icmpne +48 -> 783
    //   738: aload_0
    //   739: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   742: bipush 51
    //   744: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   747: checkcast 670	aloz
    //   750: astore_1
    //   751: aload_1
    //   752: ifnull +151 -> 903
    //   755: aload_1
    //   756: aload_0
    //   757: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   760: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   763: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   766: invokevirtual 681	aloz:b	(Ljava/lang/String;)Z
    //   769: ifeq +134 -> 903
    //   772: aload_0
    //   773: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   776: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   779: iconst_1
    //   780: putfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   783: aload_0
    //   784: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   787: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   790: getfield 1274	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   793: bipush 100
    //   795: if_icmpne +50 -> 845
    //   798: aload_0
    //   799: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   802: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   805: getfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   808: bipush 34
    //   810: if_icmpne +35 -> 845
    //   813: aload_0
    //   814: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   817: bipush 11
    //   819: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   822: checkcast 1897	aubm
    //   825: invokeinterface 1898 1 0
    //   830: ifne +15 -> 845
    //   833: aload_0
    //   834: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   837: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   840: bipush 29
    //   842: putfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   845: aload_0
    //   846: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   849: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   852: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   855: invokestatic 3956	nbp:b	(Ljava/lang/String;)Z
    //   858: ifeq +60 -> 918
    //   861: iload_3
    //   862: ifne +56 -> 918
    //   865: new 192	android/content/Intent
    //   868: dup
    //   869: aload_0
    //   870: ldc_w 1429
    //   873: invokespecial 572	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   876: astore_1
    //   877: aload_1
    //   878: ldc_w 3825
    //   881: aload_0
    //   882: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   885: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   888: invokevirtual 3830	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   891: pop
    //   892: aload_0
    //   893: aload_1
    //   894: invokespecial 3957	com/tencent/mobileqq/activity/ProfileActivity:startActivity	(Landroid/content/Intent;)V
    //   897: aload_0
    //   898: invokespecial 3958	com/tencent/mobileqq/activity/ProfileActivity:finish	()V
    //   901: iconst_0
    //   902: ireturn
    //   903: aload_0
    //   904: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   907: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   910: bipush 19
    //   912: putfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   915: goto -132 -> 783
    //   918: aload_0
    //   919: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   922: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   925: getfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   928: bipush 41
    //   930: if_icmpne +43 -> 973
    //   933: aload_0
    //   934: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   937: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   940: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   943: invokestatic 609	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   946: ifne +27 -> 973
    //   949: aload_0
    //   950: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   953: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   956: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   959: ldc_w 2016
    //   962: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   965: ifeq +8 -> 973
    //   968: aload_0
    //   969: iconst_0
    //   970: putfield 180	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_e_of_type_Boolean	Z
    //   973: aload_0
    //   974: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   977: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   980: getfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   983: bipush 53
    //   985: if_icmpeq +37 -> 1022
    //   988: aload_0
    //   989: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   992: invokevirtual 482	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   995: aload_0
    //   996: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   999: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1002: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1005: invokevirtual 488	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1008: ifeq +14 -> 1022
    //   1011: aload_0
    //   1012: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1015: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1018: iconst_0
    //   1019: putfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1022: aload_0
    //   1023: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1026: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1029: getfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1032: ifne +8 -> 1040
    //   1035: aload_0
    //   1036: iconst_1
    //   1037: putfield 3960	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_g_of_type_Boolean	Z
    //   1040: aload_0
    //   1041: invokevirtual 3962	com/tencent/mobileqq/activity/FriendProfileCardActivity:I	()V
    //   1044: aload_0
    //   1045: new 1094	bhow
    //   1048: dup
    //   1049: invokestatic 3965	com/tencent/mobileqq/app/ThreadManager:getSubThreadLooper	()Landroid/os/Looper;
    //   1052: aload_0
    //   1053: getfield 339	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_AndroidOsHandler$Callback	Landroid/os/Handler$Callback;
    //   1056: invokespecial 3968	bhow:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   1059: putfield 2042	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Bhow	Lbhow;
    //   1062: aload_0
    //   1063: new 1094	bhow
    //   1066: dup
    //   1067: invokestatic 3971	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   1070: aload_0
    //   1071: getfield 332	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidOsHandler$Callback	Landroid/os/Handler$Callback;
    //   1074: invokespecial 3968	bhow:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   1077: putfield 1092	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_Bhow	Lbhow;
    //   1080: aload_0
    //   1081: aload_0
    //   1082: invokevirtual 741	com/tencent/mobileqq/activity/FriendProfileCardActivity:getApplication	()Landroid/app/Application;
    //   1085: aload_0
    //   1086: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1089: invokevirtual 482	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1092: invokestatic 3977	bdiv:W	(Landroid/content/Context;Ljava/lang/String;)I
    //   1095: i2b
    //   1096: putfield 2093	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Byte	B
    //   1099: aload_0
    //   1100: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1103: getfield 501	awmk:jdField_b_of_type_Boolean	Z
    //   1106: ifeq +25 -> 1131
    //   1109: aload_0
    //   1110: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1113: aload_0
    //   1114: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1117: getfield 532	awmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1120: invokestatic 553	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   1123: ifeq +8 -> 1131
    //   1126: aload_0
    //   1127: iconst_0
    //   1128: putfield 2093	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Byte	B
    //   1131: aload_0
    //   1132: invokevirtual 3979	com/tencent/mobileqq/activity/FriendProfileCardActivity:b	()V
    //   1135: aload_0
    //   1136: aload_0
    //   1137: getfield 262	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Allb	Lallb;
    //   1140: invokevirtual 3980	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lalkr;)V
    //   1143: aload_0
    //   1144: aload_0
    //   1145: getfield 279	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alox	Lalox;
    //   1148: invokevirtual 3980	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lalkr;)V
    //   1151: aload_0
    //   1152: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1155: aload_0
    //   1156: getfield 272	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awdn	Lawdn;
    //   1159: invokevirtual 3984	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   1162: aload_0
    //   1163: aload_0
    //   1164: getfield 220	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Amab	Lamab;
    //   1167: invokevirtual 3980	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lalkr;)V
    //   1170: aload_0
    //   1171: aload_0
    //   1172: getfield 210	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awlr	Lawlr;
    //   1175: invokevirtual 3980	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lalkr;)V
    //   1178: aload_0
    //   1179: aload_0
    //   1180: getfield 215	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Apxc	Lapxc;
    //   1183: invokevirtual 3980	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lalkr;)V
    //   1186: aload_0
    //   1187: aload_0
    //   1188: getfield 327	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alxo	Lalxo;
    //   1191: invokevirtual 3980	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lalkr;)V
    //   1194: aload_0
    //   1195: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1198: sipush 184
    //   1201: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1204: checkcast 2985	com/tencent/mobileqq/vas/VasQuickUpdateManager
    //   1207: aload_0
    //   1208: getfield 225	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker	Lcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;
    //   1211: invokevirtual 2992	com/tencent/mobileqq/vas/VasQuickUpdateManager:addCallBacker	(Lcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)V
    //   1214: aload_0
    //   1215: new 3544	beox
    //   1218: dup
    //   1219: aload_0
    //   1220: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1223: aload_0
    //   1224: getfield 385	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Beoy	Lbeoy;
    //   1227: invokespecial 3987	beox:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Lbeoy;)V
    //   1230: putfield 3542	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Beox	Lbeox;
    //   1233: aload_0
    //   1234: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1237: aload_0
    //   1238: getfield 3542	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Beox	Lbeox;
    //   1241: putfield 3988	awmk:jdField_a_of_type_Beox	Lbeox;
    //   1244: aload_0
    //   1245: new 3692	acxw
    //   1248: dup
    //   1249: aload_0
    //   1250: aload_0
    //   1251: invokespecial 3991	acxw:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lacxy;)V
    //   1254: putfield 3690	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Acxw	Lacxw;
    //   1257: aload_0
    //   1258: new 404	java/lang/StringBuilder
    //   1261: dup
    //   1262: invokespecial 405	java/lang/StringBuilder:<init>	()V
    //   1265: aload_0
    //   1266: getfield 186	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1269: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: aload_0
    //   1273: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1276: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1279: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1282: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1288: putfield 186	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1291: aload_0
    //   1292: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1295: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1298: getfield 1274	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1301: bipush 6
    //   1303: if_icmpne +24 -> 1327
    //   1306: aload_0
    //   1307: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1310: invokevirtual 3994	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1313: ifnull +14 -> 1327
    //   1316: aload_0
    //   1317: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1320: invokevirtual 3994	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1323: aload_0
    //   1324: invokevirtual 3999	com/tencent/imcore/message/QQMessageFacade:addObserver	(Ljava/util/Observer;)V
    //   1327: aload_0
    //   1328: iconst_0
    //   1329: invokevirtual 2817	com/tencent/mobileqq/activity/FriendProfileCardActivity:c	(Z)V
    //   1332: getstatic 4004	bdmy:a	Lbdna;
    //   1335: ifnonnull +18 -> 1353
    //   1338: new 4006	com/tencent/mobileqq/activity/FriendProfileCardActivity$5
    //   1341: dup
    //   1342: aload_0
    //   1343: invokespecial 4007	com/tencent/mobileqq/activity/FriendProfileCardActivity$5:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   1346: bipush 16
    //   1348: aconst_null
    //   1349: iconst_1
    //   1350: invokestatic 3525	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1353: aload_0
    //   1354: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1357: bipush 7
    //   1359: anewarray 484	java/lang/String
    //   1362: putfield 852	awmk:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1365: new 4009	com/tencent/mobileqq/activity/FriendProfileCardActivity$6
    //   1368: dup
    //   1369: aload_0
    //   1370: invokespecial 4010	com/tencent/mobileqq/activity/FriendProfileCardActivity$6:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   1373: bipush 16
    //   1375: aconst_null
    //   1376: iconst_1
    //   1377: invokestatic 3525	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1380: aload_0
    //   1381: invokevirtual 2822	com/tencent/mobileqq/activity/FriendProfileCardActivity:k	()V
    //   1384: aload_0
    //   1385: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1388: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1391: getfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1394: bipush 33
    //   1396: if_icmpeq +469 -> 1865
    //   1399: aload_0
    //   1400: invokevirtual 4011	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	()V
    //   1403: aload_0
    //   1404: invokevirtual 4013	com/tencent/mobileqq/activity/FriendProfileCardActivity:r	()V
    //   1407: aload_0
    //   1408: new 4015	com/tencent/mobileqq/apollo/FriendCardApolloViewController
    //   1411: dup
    //   1412: aload_0
    //   1413: aload_0
    //   1414: getfield 713	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   1417: invokespecial 4018	com/tencent/mobileqq/apollo/FriendCardApolloViewController:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;Landroid/view/View;)V
    //   1420: putfield 1038	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController	Lcom/tencent/mobileqq/apollo/FriendCardApolloViewController;
    //   1423: aload_0
    //   1424: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1427: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1430: getfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1433: ifne +30 -> 1463
    //   1436: aload_0
    //   1437: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1440: aload_0
    //   1441: getfield 284	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Avqr	Lavqr;
    //   1444: invokevirtual 3984	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   1447: aload_0
    //   1448: getfield 1092	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_Bhow	Lbhow;
    //   1451: new 4020	com/tencent/mobileqq/activity/FriendProfileCardActivity$7
    //   1454: dup
    //   1455: aload_0
    //   1456: invokespecial 4021	com/tencent/mobileqq/activity/FriendProfileCardActivity$7:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   1459: invokevirtual 4024	bhow:post	(Ljava/lang/Runnable;)Z
    //   1462: pop
    //   1463: new 4026	com/tencent/mobileqq/activity/FriendProfileCardActivity$8
    //   1466: dup
    //   1467: aload_0
    //   1468: invokespecial 4027	com/tencent/mobileqq/activity/FriendProfileCardActivity$8:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   1471: bipush 8
    //   1473: aconst_null
    //   1474: iconst_1
    //   1475: invokestatic 1922	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1478: aload_0
    //   1479: getfield 4029	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1482: ldc_w 4030
    //   1485: invokestatic 786	alpo:a	(I)Ljava/lang/String;
    //   1488: invokestatic 4035	bcvq:a	(Landroid/view/View;Ljava/lang/String;)V
    //   1491: aload_0
    //   1492: getfield 4029	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1495: invokestatic 4036	bcvq:a	(Landroid/view/View;)V
    //   1498: aload_0
    //   1499: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1502: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1505: getfield 473	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1508: ifne +390 -> 1898
    //   1511: aload_0
    //   1512: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1515: ldc_w 1571
    //   1518: ldc_w 4038
    //   1521: ldc 169
    //   1523: ldc_w 4040
    //   1526: ldc_w 4040
    //   1529: iconst_0
    //   1530: iconst_0
    //   1531: ldc 169
    //   1533: ldc 169
    //   1535: ldc 169
    //   1537: ldc 169
    //   1539: invokestatic 634	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1542: aload_0
    //   1543: getfield 2351	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Bdjk	Lbdjk;
    //   1546: ldc_w 4041
    //   1549: iconst_0
    //   1550: invokevirtual 2358	bdjk:a	(Ljava/lang/String;Z)V
    //   1553: aload_0
    //   1554: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1557: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1560: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1563: invokestatic 3512	bdal:b	(Ljava/lang/String;)Z
    //   1566: ifeq +52 -> 1618
    //   1569: iconst_0
    //   1570: istore_2
    //   1571: aload_0
    //   1572: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1575: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1578: getfield 1274	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1581: bipush 59
    //   1583: if_icmpne +349 -> 1932
    //   1586: iconst_1
    //   1587: istore_2
    //   1588: aload_0
    //   1589: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1592: ldc_w 639
    //   1595: ldc 169
    //   1597: ldc 169
    //   1599: ldc_w 4043
    //   1602: ldc_w 4043
    //   1605: iload_2
    //   1606: iconst_0
    //   1607: ldc 169
    //   1609: ldc 169
    //   1611: ldc 169
    //   1613: ldc 169
    //   1615: invokestatic 634	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1618: aload_0
    //   1619: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1622: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1625: getfield 1274	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1628: bipush 118
    //   1630: if_icmpne +341 -> 1971
    //   1633: aconst_null
    //   1634: ldc_w 639
    //   1637: ldc 169
    //   1639: ldc 169
    //   1641: ldc_w 4045
    //   1644: ldc_w 4045
    //   1647: iconst_0
    //   1648: iconst_0
    //   1649: ldc 169
    //   1651: ldc 169
    //   1653: ldc 169
    //   1655: ldc 169
    //   1657: invokestatic 634	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1660: aload_0
    //   1661: invokevirtual 4047	com/tencent/mobileqq/activity/FriendProfileCardActivity:H	()V
    //   1664: aload_0
    //   1665: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1668: bipush 52
    //   1670: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1673: checkcast 526	com/tencent/mobileqq/app/TroopManager
    //   1676: aload_0
    //   1677: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1680: getfield 532	awmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1683: invokevirtual 535	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   1686: astore_1
    //   1687: aload_0
    //   1688: aload_1
    //   1689: invokevirtual 538	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1692: aload_1
    //   1693: ifnull +35 -> 1728
    //   1696: aload_1
    //   1697: invokevirtual 4050	com/tencent/mobileqq/data/TroopInfo:isGameBind	()Z
    //   1700: ifeq +28 -> 1728
    //   1703: ldc_w 4052
    //   1706: ldc_w 4054
    //   1709: ldc_w 4056
    //   1712: iconst_0
    //   1713: iconst_0
    //   1714: iconst_1
    //   1715: anewarray 484	java/lang/String
    //   1718: dup
    //   1719: iconst_0
    //   1720: aload_1
    //   1721: getfield 2125	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   1724: aastore
    //   1725: invokestatic 4061	bdaj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   1728: aload_0
    //   1729: iconst_1
    //   1730: putfield 4063	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_j_of_type_Boolean	Z
    //   1733: ldc2_w 198
    //   1736: putstatic 4064	awsp:jdField_b_of_type_Long	J
    //   1739: aload_0
    //   1740: aload_0
    //   1741: invokevirtual 1893	com/tencent/mobileqq/activity/FriendProfileCardActivity:getIntent	()Landroid/content/Intent;
    //   1744: invokespecial 4066	com/tencent/mobileqq/activity/FriendProfileCardActivity:c	(Landroid/content/Intent;)V
    //   1747: aload_0
    //   1748: invokespecial 4068	com/tencent/mobileqq/activity/FriendProfileCardActivity:N	()V
    //   1751: aload_0
    //   1752: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1755: iconst_2
    //   1756: invokevirtual 529	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalko;
    //   1759: checkcast 1850	alkv
    //   1762: astore_1
    //   1763: aload_1
    //   1764: ifnull +47 -> 1811
    //   1767: aload_0
    //   1768: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1771: ifnull +40 -> 1811
    //   1774: aload_0
    //   1775: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1778: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1781: ifnull +30 -> 1811
    //   1784: aload_0
    //   1785: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1788: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1791: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1794: ifnull +17 -> 1811
    //   1797: aload_1
    //   1798: aload_0
    //   1799: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1802: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1805: getfield 466	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1808: invokevirtual 4070	alkv:e	(Ljava/lang/String;)V
    //   1811: aload_0
    //   1812: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1815: ldc_w 639
    //   1818: ldc 169
    //   1820: ldc 169
    //   1822: ldc 169
    //   1824: ldc_w 4072
    //   1827: iconst_0
    //   1828: iconst_0
    //   1829: ldc 169
    //   1831: ldc 169
    //   1833: ldc 169
    //   1835: ldc 169
    //   1837: invokestatic 634	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1840: iconst_1
    //   1841: ireturn
    //   1842: astore_1
    //   1843: invokestatic 400	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1846: ifeq +13 -> 1859
    //   1849: ldc_w 402
    //   1852: iconst_2
    //   1853: ldc 169
    //   1855: aload_1
    //   1856: invokestatic 973	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1859: aload_0
    //   1860: invokevirtual 3726	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   1863: iconst_0
    //   1864: ireturn
    //   1865: aload_0
    //   1866: aload_0
    //   1867: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1870: getfield 512	awmk:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   1873: iconst_0
    //   1874: invokevirtual 2820	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/data/Card;Z)V
    //   1877: goto -474 -> 1403
    //   1880: astore_1
    //   1881: ldc_w 495
    //   1884: iconst_1
    //   1885: ldc_w 4074
    //   1888: aload_1
    //   1889: invokestatic 973	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1892: aload_0
    //   1893: invokevirtual 3726	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   1896: iconst_0
    //   1897: ireturn
    //   1898: aload_0
    //   1899: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1902: ldc_w 1571
    //   1905: ldc_w 4038
    //   1908: ldc 169
    //   1910: ldc_w 4076
    //   1913: ldc_w 4076
    //   1916: iconst_0
    //   1917: iconst_0
    //   1918: ldc 169
    //   1920: ldc 169
    //   1922: ldc 169
    //   1924: ldc 169
    //   1926: invokestatic 634	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1929: goto -387 -> 1542
    //   1932: aload_0
    //   1933: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1936: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1939: getfield 1274	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1942: iconst_1
    //   1943: if_icmpne +8 -> 1951
    //   1946: iconst_2
    //   1947: istore_2
    //   1948: goto -360 -> 1588
    //   1951: aload_0
    //   1952: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1955: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1958: getfield 1274	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1961: bipush 8
    //   1963: if_icmpne -375 -> 1588
    //   1966: iconst_3
    //   1967: istore_2
    //   1968: goto -380 -> 1588
    //   1971: aload_0
    //   1972: getfield 165	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Awmk	Lawmk;
    //   1975: getfield 463	awmk:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1978: getfield 1274	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1981: bipush 121
    //   1983: if_icmpne -323 -> 1660
    //   1986: aload_0
    //   1987: getfield 477	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1990: ldc_w 639
    //   1993: ldc 169
    //   1995: ldc 169
    //   1997: ldc_w 4078
    //   2000: ldc_w 4078
    //   2003: iconst_0
    //   2004: iconst_0
    //   2005: ldc 169
    //   2007: ldc 169
    //   2009: ldc 169
    //   2011: ldc 169
    //   2013: invokestatic 634	azmj:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2016: goto -356 -> 1660
    //   2019: goto -1681 -> 338
    //   2022: goto -1625 -> 397
    //   2025: goto -1387 -> 638
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2028	0	this	FriendProfileCardActivity
    //   0	2028	1	paramBundle	Bundle
    //   1570	398	2	i1	int
    //   287	575	3	bool	boolean
    //   35	406	4	localObject	Object
    //   354	36	5	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   973	1022	1842	java/lang/Exception
    //   1327	1353	1880	java/lang/Exception
    //   1353	1403	1880	java/lang/Exception
    //   1403	1423	1880	java/lang/Exception
    //   1865	1877	1880	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public void doOnDestroy()
  {
    int i1 = 0;
    this.jdField_j_of_type_Boolean = false;
    if (this.jdField_a_of_type_Acxw != null)
    {
      this.jdField_a_of_type_Acxw.a();
      this.jdField_a_of_type_Acxw = null;
    }
    if (this.jdField_b_of_type_Bhow != null)
    {
      this.jdField_b_of_type_Bhow.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_Bhow.removeMessages(0);
    }
    if (this.jdField_a_of_type_Bhow != null)
    {
      this.jdField_a_of_type_Bhow.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bhow.removeMessages(0);
      this.jdField_a_of_type_Bhow = null;
    }
    if (this.jdField_b_of_type_Apxc != null)
    {
      this.app.removeObserver(this.jdField_b_of_type_Apxc);
      this.jdField_b_of_type_Apxc = null;
    }
    if (this.jdField_b_of_type_Bepp != null)
    {
      this.jdField_b_of_type_Bepp.dismiss();
      this.jdField_b_of_type_Bepp = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.d();
    }
    super.doOnDestroy();
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_Beox != null) {
      this.jdField_a_of_type_Beox.a();
    }
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilArrayDeque.clear();
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
      }
      removeObserver(this.jdField_a_of_type_Alox);
      removeObserver(this.jdField_a_of_type_Allb);
      removeObserver(this.jdField_a_of_type_Amab);
      if (this.app != null)
      {
        this.app.unRegistObserver(this.jdField_a_of_type_Awdn);
        this.app.unRegistObserver(this.jdField_a_of_type_Avqr);
      }
      removeObserver(this.jdField_a_of_type_Awlr);
      removeObserver(this.jdField_a_of_type_Alxo);
      removeObserver(this.jdField_a_of_type_Apxc);
      Object localObject;
      if (this.app != null)
      {
        localObject = (VasQuickUpdateManager)this.app.getManager(184);
        if (localObject != null) {
          ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        }
      }
      if ((this.app != null) && (this.app.a() != null)) {
        this.app.a().deleteObserver(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        int i2 = this.jdField_a_of_type_AndroidViewViewGroup.getChildCount();
        while (i1 < i2)
        {
          localObject = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i1);
          if ((localObject instanceof ProfileHeaderView)) {
            ((ProfileHeaderView)localObject).c();
          }
          i1 += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        this.jdField_a_of_type_AndroidAppDialog = null;
      }
      if (this.jdField_a_of_type_Zcp != null)
      {
        this.jdField_a_of_type_Zcp.dismiss();
        this.jdField_a_of_type_Zcp = null;
      }
      D();
      if (this.jdField_a_of_type_Asor != null) {
        this.jdField_a_of_type_Asor.d();
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "doOnDestroy recycle bg");
        }
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof FriendProfileCardBgDrawable)) {
          ((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a();
        }
        if (bdrw.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)) {
          bdrw.a().a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
      if ((this.jdField_a_of_type_Awmk != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (awmr.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard))) {
        QLog.i("FriendProfileCardActivity", 1, "FriendProfileCardActivity.onDestroy()");
      }
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0) {
        bcyw.b();
      }
      MedalGuideView.a();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          Subscriber localSubscriber = (Subscriber)localIterator.next();
          uht.a().unRegisterSubscriber(localSubscriber);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      a(this);
      if (this.jdField_a_of_type_Aikl != null) {
        this.jdField_a_of_type_Aikl.f();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c();
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      if (this.jdField_a_of_type_Acxw != null) {
        this.jdField_a_of_type_Acxw.a(paramIntent, (ArrayList)localObject);
      }
      return;
    }
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        localObject = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
        if ((localObject != null) && (((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int == 115))
        {
          this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)localObject);
          a(0L, null, null, false);
        }
      }
      if (this.jdField_a_of_type_Aikl != null) {
        break;
      }
      c(paramIntent);
      return;
      localObject = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (localObject != null) {
        if (bcyw.a(this.app, (String)localObject, paramIntent))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          }
        }
        else {
          a(2131719794, 1);
        }
      }
    }
    this.jdField_a_of_type_Aikl.b(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    AbstractVideoImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.b();
    }
    if (!this.jdField_f_of_type_Boolean) {
      if (this.jdField_a_of_type_Bdjk != null) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "FriendProfileCardActivity time trace:" + this.jdField_a_of_type_Bdjk.toString());
        }
      }
    }
    try
    {
      azmz.a(this.app.getApp()).a(this.app.getCurrentAccountUin(), "profileCardTimeStat", true, 0L, 0L, this.jdField_a_of_type_Bdjk.a(), "", false);
      this.jdField_f_of_type_Boolean = true;
      if (this.jdField_b_of_type_Bhow != null)
      {
        this.jdField_b_of_type_Bhow.removeMessages(102);
        this.jdField_b_of_type_Bhow.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.b();
      }
      QQAppInterface localQQAppInterface = this.app;
      if (localQQAppInterface != null) {
        aznh.a().b(localQQAppInterface.getCurrentAccountUin(), "actQZLoadHitRateProfile");
      }
      this.jdField_a_of_type_Asot.d();
      this.s = true;
      if ((this.t) && (this.jdField_m_of_type_Long > 0L) && (this.app != null) && (this.jdField_a_of_type_Awmk != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        aqcx.a(this.app, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_m_of_type_Long);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("FriendProfileCardActivity", 1, "doOnPause fail.", localException);
      }
    }
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.f();
    }
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "friend profile card activity doOnResume");
    }
    super.doOnResume();
    AbstractVideoImage.resumeAll();
    ApngImage.playByTag(9);
    if (this.jdField_d_of_type_Boolean) {
      if ((!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileTagView)) || (!((ProfileTagView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).jdField_a_of_type_Boolean)) {
        break label311;
      }
    }
    label311:
    for (int i1 = 0;; i1 = 1)
    {
      this.jdField_b_of_type_Int = 0;
      if (i1 != 0) {
        l();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.a();
      }
      i();
      if (this.jdField_b_of_type_Long > 0L)
      {
        long l1 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
        if ((QLog.isColorLevel()) && (l1 > 500L)) {
          QLog.i("Q.PerfTrace", 2, "FriendProfileCardActivity Ui render used:" + l1);
        }
        this.jdField_b_of_type_Long = 0L;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a();
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 6) {
        s();
      }
      addObserver(this.jdField_b_of_type_Allb);
      if (this.app != null)
      {
        WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(13);
        if (localWebProcessManager != null) {
          localWebProcessManager.a(-1, new acwn(this.jdField_a_of_type_Asor));
        }
        bizm.a(this.app, this.jdField_a_of_type_Asor);
      }
      G();
      if (this.jdField_a_of_type_Awkn != null) {
        this.jdField_a_of_type_Awkn.a();
      }
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 115) && (AddFriendLogicActivity.jdField_b_of_type_Boolean)) {
        c(getIntent().getStringExtra("src_name"));
      }
      this.s = false;
      return;
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
    {
      localView = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
      if (!(localView instanceof VoteView)) {
        break label77;
      }
      ((VoteView)localView).b(true);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Bhow != null)
      {
        this.jdField_b_of_type_Bhow.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_b_of_type_Bhow.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      }
      return;
      label77:
      if ((localView instanceof VoteViewV2)) {
        ((VoteViewV2)localView).b(true);
      }
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    removeObserver(this.jdField_b_of_type_Allb);
    Object localObject = bhoh.a;
    if ((localObject != null) && (((bhoh)localObject).a(true))) {
      ((bhoh)localObject).a(this.app.getCurrentAccountUin());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Apek != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Apek.d();
      }
      localObject = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
      if (!(localObject instanceof VoteView)) {
        break label171;
      }
      ((VoteView)localObject).b(false);
    }
    for (;;)
    {
      T();
      if (this.jdField_a_of_type_Bhow.hasMessages(10))
      {
        this.jdField_a_of_type_Bhow.removeMessages(10);
        E();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.c();
      }
      if ((this.jdField_a_of_type_Zcp != null) && (this.jdField_a_of_type_Zcp.isShowing()))
      {
        this.jdField_a_of_type_Zcp.dismiss();
        this.jdField_a_of_type_Zcp = null;
      }
      return;
      label171:
      if ((localObject instanceof VoteViewV2)) {
        ((VoteViewV2)localObject).b(false);
      }
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bdjk.a("doOnWindowFocusChanged", false);
      bhoh localbhoh = bhoh.a;
      if ((localbhoh != null) && (localbhoh.a())) {
        localbhoh.b(2);
      }
      if ((!this.p) || (this.o))
      {
        this.jdField_b_of_type_Bhow.removeMessages(100);
        this.jdField_b_of_type_Bhow.sendEmptyMessageDelayed(100, 100L);
        this.o = false;
        this.p = true;
      }
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_b_of_type_Bhow.removeMessages(102);
        this.jdField_b_of_type_Bhow.sendEmptyMessageDelayed(102, 100L);
        this.jdField_g_of_type_Boolean = false;
      }
    }
  }
  
  public void e()
  {
    bhpy localbhpy = (bhpy)bhql.a(this, null);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_b_of_type_JavaLangString)) {
      localArrayList.add(new acuo(this, 2131693543));
    }
    localArrayList.add(new acup(this, 2131693541));
    localArrayList.add(new acur(this, 2131693539));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localbhpy.b(((bdke)localIterator.next()).jdField_a_of_type_Int);
    }
    localbhpy.c(2131690648);
    localbhpy.a(new acus(this, localArrayList, localbhpy));
    try
    {
      if (!isFinishing()) {
        localbhpy.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView != null) {
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.smoothScrollToPositionFromTop(0, -paramInt);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    try
    {
      Object localObject = anvv.a(this.app, this.jdField_a_of_type_Awmk);
      localObject = bcyw.a(new Intent(this, FriendProfileMoreInfoActivity.class), this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, (BusinessCard)localObject);
      ((Intent)localObject).putExtra("profile_entry_type", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int);
      ((Intent)localObject).putExtra("troopUin", this.jdField_a_of_type_Awmk.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("memberUin", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("isTroopMemberCard", this.jdField_a_of_type_Awmk.jdField_b_of_type_Boolean);
      ((Intent)localObject).putExtra("extendFriendEntryAddFriend", this.jdField_a_of_type_Awmk.jdField_c_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
      {
        ((Intent)localObject).putExtra("coverUrl", this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).putExtra("coverTimeStamp", this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_e_of_type_Int);
      }
      startActivityForResult((Intent)localObject, 1022);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("FriendProfileCardActivity", 1, "forward2ProfileEdit fail.", localException);
      }
      azmj.b(this.app, "CliOper", "", "", "0X8006A76", "0X8006A76", 0, 0, "", "", "", "");
      azmj.b(this.app, "dc00898", "", "", "0X8007EB6", "0X8007EB6", 0, 0, "", "", "", "");
    }
    if (paramBoolean)
    {
      azmj.b(this.app, "dc00898", "", "", "0X8007EB9", "0X8007EB9", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public boolean e()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool2 = false;
    switch (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localObject2 = (aloz)this.app.getManager(51);
      if ((localObject2 != null) && (((aloz)localObject2).b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        bool1 = ((aloz)localObject2).e(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        return bool1;
      }
      break;
    case 41: 
    case 42: 
    case 86: 
      localObject1 = (aloz)this.app.getManager(51);
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = ((aloz)localObject1).a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (localObject1 == null) {
          break;
        }
        bool1 = bool2;
        if (((Friends)localObject1).groupid != -1002) {
          break;
        }
        return true;
      }
    case 1: 
      localObject1 = (aloz)this.app.getManager(51);
      if (localObject1 == null) {}
      break;
    }
    for (boolean bool1 = ((aloz)localObject1).e(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; bool1 = false)
    {
      return bool1;
      localObject2 = (atvt)this.app.getManager(16);
      bool1 = bool2;
      if (localObject2 == null) {
        break;
      }
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject1 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      for (;;)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        return ((atvt)localObject2).a((String)localObject1);
        if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          localObject1 = a();
        }
      }
    }
  }
  
  public void f()
  {
    boolean bool = false;
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(11);
    PhoneContact localPhoneContact = localPhoneContactManagerImp.c(a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
    bhpy localbhpy = (bhpy)bhql.a(this, null);
    localbhpy.b(2131693600);
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
    {
      azmj.b(this.app, "CliOper", "", "", "0X8007015", "0X8007015", 0, 0, "", "", "", "");
      if (localPhoneContact != null) {
        break label210;
      }
    }
    for (;;)
    {
      localbhpy.c(2131690648);
      localbhpy.a(new acut(this, localPhoneContactManagerImp, bool, localbhpy));
      try
      {
        if (!isFinishing()) {
          localbhpy.show();
        }
        return;
      }
      catch (Exception localException)
      {
        int i1;
        localException.printStackTrace();
      }
      azmj.b(this.app, "CliOper", "", "", "0X8007167", "0X8007167", 0, 0, "", "", "", "");
      if ((TextUtils.isEmpty(a())) || (localPhoneContact == null)) {
        break;
      }
      if (localPhoneContact.isHiden) {}
      for (i1 = 2131693602;; i1 = 2131693599)
      {
        localbhpy.b(i1);
        break;
      }
      label210:
      bool = localPhoneContact.isHiden;
    }
  }
  
  public void f(int paramInt)
  {
    int i1;
    switch (paramInt)
    {
    default: 
      i1 = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "reportBusinessEntryClick serviceType=" + paramInt + ", type=" + i1);
      }
      if (i1 != 0) {
        azmj.b(this.app, "dc00898", "", "", "0X80093BF", "0X80093BF", i1, 0, "", "", "", "");
      }
      return;
      i1 = 4;
      continue;
      i1 = 3;
      continue;
      i1 = 0;
      continue;
      i1 = 1;
      continue;
      i1 = 2;
      continue;
      i1 = 0;
      continue;
      i1 = 6;
      continue;
      i1 = 5;
      continue;
      i1 = 7;
      continue;
      i1 = 8;
      continue;
      i1 = 10;
      continue;
      i1 = 11;
      continue;
      i1 = 0;
      continue;
      i1 = 9;
    }
  }
  
  public boolean f()
  {
    return ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) && (((ProfileBaseView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).a());
  }
  
  public void flingLToR()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfilePhotoView))
    {
      View localView = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
      if (((localView instanceof QzonePhotoView)) && (((QzonePhotoView)localView).jdField_a_of_type_Boolean)) {
        return;
      }
    }
    onBackPressed();
  }
  
  public void flingRToL() {}
  
  public void g()
  {
    int i5 = 16;
    int i6 = 1;
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131693642);
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 6) {
        break label314;
      }
      s();
    }
    int i2;
    int i4;
    int i1;
    int i3;
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new acuy(this));
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label399;
      }
      if (!this.jdField_a_of_type_Awmk.jdField_b_of_type_Boolean) {
        break label326;
      }
      i2 = 2131695633;
      i4 = 0;
      i1 = 1;
      i3 = 16;
      if (!this.jdField_a_of_type_Awmk.jdField_b_of_type_Boolean) {
        break label1251;
      }
      if ((!this.jdField_a_of_type_Awmk.a()) || (i1 == 0)) {
        break label1156;
      }
      i1 = i6;
      label126:
      if (i1 == 0) {
        break label1161;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTag(new awki(i5, null));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(this.jdField_e_of_type_Boolean);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(i2);
      label185:
      if (i4 == 0) {
        break label1199;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(new awki(i3, null));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(this.jdField_e_of_type_Boolean);
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label1173;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840109);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131705272));
      label272:
      if (b(this.jdField_a_of_type_Awmk)) {
        break label1211;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131693639);
      break;
      label314:
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    label326:
    aloz localaloz = (aloz)this.app.getManager(51);
    if (localaloz != null) {}
    for (boolean bool = localaloz.b(this.app.c());; bool = true)
    {
      if (bool) {
        i1 = 98;
      }
      for (i2 = 2131695665;; i2 = 2131695666)
      {
        i4 = 1;
        int i7 = 1;
        i3 = 65;
        i5 = i1;
        i1 = i7;
        break;
        i1 = 99;
      }
      label399:
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71))
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 1;
        i3 = 16;
        break;
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 70)
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 1;
        i3 = 16;
        break;
      }
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        if (this.q)
        {
          i2 = 2131695633;
          i4 = 0;
          i1 = 0;
          i3 = 16;
          break;
        }
        i2 = 2131695633;
        i4 = 0;
        i1 = 1;
        i3 = 16;
        break;
      }
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22))
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 1;
        i3 = 16;
        break;
      }
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47))
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 1;
        i3 = 16;
        break;
      }
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 86))
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 1;
        i3 = 16;
        break;
      }
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57))
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 1;
        i3 = 16;
        break;
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 0;
        i3 = 16;
        break;
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36)
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 0;
        i3 = 16;
        break;
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
      {
        if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int != 0) {}
        for (i1 = 1;; i1 = 0)
        {
          i4 = 0;
          i2 = 2131695633;
          i3 = 16;
          break;
        }
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2)
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 1;
        i3 = 16;
        break;
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74)
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 1;
        i3 = 16;
        break;
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96)
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 1;
        i3 = 16;
        break;
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 95)
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 1;
        i3 = 16;
        break;
      }
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
      {
        i4 = 1;
        i1 = 0;
        i3 = 44;
        i2 = 2131695633;
        break;
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
      {
        if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataContactCard == null) || (TextUtils.equals(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, this.app.getCurrentAccountUin()))) {
          break label1254;
        }
        i4 = 1;
        i1 = 0;
        i3 = 44;
        i2 = 2131695633;
        break;
      }
      if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        i2 = 2131695633;
        i4 = 0;
        i1 = 1;
        i3 = 16;
        break;
      }
      i2 = 2131695633;
      i4 = 0;
      i1 = 0;
      i3 = 16;
      break;
      label1156:
      i1 = 0;
      break label126;
      label1161:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label185;
      label1173:
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840101);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131705307));
      break label272;
      label1199:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label272;
      label1211:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(new awki(90, null));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Awmk.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
      label1251:
      break label126;
      label1254:
      i2 = 2131695633;
      i4 = 0;
      i1 = 0;
      i3 = 16;
      break;
    }
  }
  
  public void g(int paramInt)
  {
    Object localObject2;
    Object localObject1;
    String str1;
    label104:
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 40) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
    {
      localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
      localObject1 = "qita";
      String str2 = "0";
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label595;
      }
      str1 = bdox.a("vipPersonalCardMaster");
      if (!this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        str2 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      localStringBuilder = new StringBuilder(str1);
      if (!str1.contains("?")) {
        break label606;
      }
      localStringBuilder.append("&platform=1");
      label170:
      localStringBuilder.append("&qq=" + str2);
      localStringBuilder.append("&adtag=" + (String)localObject1);
      localStringBuilder.append("&aid=" + (String)localObject2);
      if (paramInt == 1) {
        localStringBuilder.append("&jumplevelset=1");
      }
      localObject1 = localStringBuilder.toString();
      long l1 = System.currentTimeMillis();
      if (ProfileActivity.a(this.jdField_h_of_type_Long, l1))
      {
        this.jdField_h_of_type_Long = l1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQVipWeb() url = " + (String)localObject1);
        }
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity((Intent)localObject2);
        localObject1 = this.app;
        if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label618;
        }
      }
    }
    label595:
    label606:
    label618:
    for (paramInt = 23;; paramInt = 24)
    {
      azmj.b((QQAppInterface)localObject1, "CliOper", "", "", "vip", "logo_in", paramInt, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
        localObject1 = "geren";
        break;
      }
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21))
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
        localObject1 = "qun";
        break;
      }
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
        localObject1 = "taolunzu";
        break;
      }
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
        localObject1 = "qita";
        break;
      }
      localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
      localObject1 = "qita";
      break;
      str1 = bdox.a("vipPersonalCardCustom");
      break label104;
      localStringBuilder.append("?platform=1");
      break label170;
    }
  }
  
  public int getTitleBarHeight()
  {
    int i1 = 0;
    if (this.jdField_g_of_type_AndroidViewView != null) {
      i1 = this.jdField_g_of_type_AndroidViewView.getHeight();
    }
    return i1;
  }
  
  void h()
  {
    if (getIntent().getIntExtra("requestCode", -1) == 1023)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("intent_key_has_ever_vote", this.jdField_h_of_type_Boolean);
      setResult(-1, localIntent);
    }
  }
  
  void h(int paramInt)
  {
    if (paramInt == 7)
    {
      this.jdField_b_of_type_Bhow.post(new FriendProfileCardActivity.43(this));
      return;
    }
    Object localObject2 = this.app.getCurrentNickname();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.app.getCurrentNickname();
    }
    localObject2 = bizt.a();
    ((bizt)localObject2).jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    ((bizt)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
    localObject1 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.vQzoneCoverInfo;
    if (QLog.isColorLevel()) {
      if (localObject1 != null) {
        break label277;
      }
    }
    label277:
    for (paramInt = 0;; paramInt = localObject1.length)
    {
      QLog.d("FriendProfileCardActivity", 2, String.format("qzGoQzoneUserHomeActivity vQzoneCoverInfo=%s length=%s", new Object[] { localObject1, Integer.valueOf(paramInt) }));
      bizm.a(this, (bizt)localObject2, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g, -1, 5, this.jdField_a_of_type_Asor, (byte[])localObject1, false);
      localObject1 = new bizg();
      ((bizg)localObject1).jdField_c_of_type_JavaLangString = "1";
      ((bizg)localObject1).jdField_d_of_type_JavaLangString = "0";
      ((bizg)localObject1).jdField_b_of_type_Int = 4;
      ((bizg)localObject1).jdField_l_of_type_JavaLangString = "3";
      ((bizg)localObject1).m = "userSummary";
      ((bizg)localObject1).n = "homePage";
      QZoneClickReport.startReportImediately(this.app.getAccount(), (bizg)localObject1);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("source_type", "3");
      ((HashMap)localObject1).put("source_from", "userSummary");
      ((HashMap)localObject1).put("source_to", "homePage");
      azmz.a(BaseApplicationImpl.getContext()).a(this.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
      return;
    }
  }
  
  void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    axho localaxho = (axho)this.app.getManager(36);
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localaxho.a(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    localaxho.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
  
  public void i(int paramInt)
  {
    int i1 = 2131166895;
    Object localObject = getResources();
    if (paramInt == 1) {
      if ((awmr.a(this.jdField_a_of_type_Awmk.a())) && ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileQVipDiyView)))
      {
        i1 = ((ProfileQVipDiyView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).b();
        paramInt = ((Resources)localObject).getColor(i1);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColorStateList(i1));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColorStateList(i1));
        if (this.jdField_m_of_type_Int < this.jdField_l_of_type_Int) {
          break label188;
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
      }
    }
    for (;;)
    {
      localObject = a();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(new LightingColorFilter(0, paramInt));
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(paramInt);
      return;
      if (ThemeUtil.isInNightMode(this.app)) {}
      for (paramInt = i1;; paramInt = 2131166604)
      {
        paramInt = ((Resources)localObject).getColor(paramInt);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramInt);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt);
        break;
      }
      label188:
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
      ImmersiveUtils.a(false, getWindow());
      continue;
      if (paramInt == 0)
      {
        paramInt = ((Resources)localObject).getColor(2131166895);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColorStateList(2131166895));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(((Resources)localObject).getColorStateList(2131166895));
        azib.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
      }
      else
      {
        paramInt = 0;
      }
    }
  }
  
  public boolean isValidate()
  {
    return (this.jdField_j_of_type_Boolean) && (!isFinishing());
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0))
    {
      axho localaxho = (axho)this.app.getManager(36);
      if (localaxho != null) {
        localaxho.b(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
      }
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
    }
  }
  
  @TargetApi(11)
  void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initInfoCardCommonLayout");
    }
    this.jdField_a_of_type_Bdjk.a("initInfoCardCommonLayoutStart", true);
    Object localObject = getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    int i1 = ((Resources)localObject).getDimensionPixelSize(2131298914);
    this.jdField_l_of_type_Int = (((Resources)localObject).getDimensionPixelSize(2131297408) - i1 - (int)(localDisplayMetrics.density * 66.0F));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_e_of_type_AndroidViewView = View.inflate(this, 2131561202, null);
    if ((this.jdField_e_of_type_AndroidViewView instanceof PerfRelativeLayout)) {
      ((PerfRelativeLayout)this.jdField_e_of_type_AndroidViewView).setOnDrawCompleteListener(this.jdField_a_of_type_Asar);
    }
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = ((PullToZoomHeaderListView)this.jdField_e_of_type_AndroidViewView.findViewById(2131364643));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setMotionEventInterceptor(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setOnScrollChangeListener(this.jdField_a_of_type_Bhum);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setOnScrollListener(this.jdField_a_of_type_Bhpo);
    this.jdField_b_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131364895);
    this.jdField_c_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131373525);
    this.jdField_g_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131372292);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368613));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368644));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368627));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131371288));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131368659));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_e_of_type_AndroidViewView.findViewById(2131377976));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)this.jdField_e_of_type_AndroidViewView.findViewById(2131373524));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.forbiddenLayer();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFitFullScreenXY();
    J();
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131561157, null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368238));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(new awki(29, null));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368230);
    if (localObject != null) {}
    try
    {
      localObject = (Animatable)((ImageView)localObject).getDrawable();
      if (!((Animatable)localObject).isRunning()) {
        ((Animatable)localObject).start();
      }
      label534:
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = ((ProfileCardMoreInfoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368246));
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Awmk, this.app, this, this.q, this.jdField_a_of_type_Beox, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_e_of_type_Boolean = this.jdField_k_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_f_of_type_Boolean = this.jdField_l_of_type_Boolean;
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365986));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131378631));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131363757));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView = ((ShakeImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131380269));
      this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView = ((ShakeImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131380270));
      this.jdField_d_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131365376);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout = ((SingleTouchLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131365375));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(false);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setMovable(false);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131373953));
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setAdapter(new bhyu(null));
      localObject = new FriendProfileCardActivity.ProfileTopGestureLayout(this, this);
      ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject).setOnFlingGesture(this);
      ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject).addView(this.jdField_e_of_type_AndroidViewView);
      setContentView((View)localObject);
      localObject = (FrameLayout)findViewById(16908290);
      if (localObject != null) {
        ((FrameLayout)localObject).setBackgroundResource(2130845286);
      }
      if (this.jdField_b_of_type_Bhow != null)
      {
        localObject = this.jdField_b_of_type_Bhow.obtainMessage(10);
        this.jdField_b_of_type_Bhow.sendMessageDelayed((Message)localObject, 10000L);
      }
      U();
      g();
      L();
      this.jdField_a_of_type_Bdjk.a("initInfoCardCommonLayoutEnd", "initInfoCardCommonLayoutStart", false);
      return;
    }
    catch (Exception localException)
    {
      break label534;
    }
  }
  
  public void l()
  {
    if ((this.app == null) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {}
    int i1;
    do
    {
      return;
      if (!arsj.jdField_a_of_type_Boolean)
      {
        QLog.i("ColorScreenManager", 1, "ColorScreenManager.sEnable is false, loadColorScreen fail.");
        return;
      }
      if (azib.b())
      {
        QLog.i("ColorScreenManager", 1, "loadColorScreen, SimpleUIMode is open now");
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      i1 = ((alxl)this.app.a(13)).a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("ColorScreenManager", 2, "loadColorScreen " + i1 + " mLastColorScreen " + this.jdField_b_of_type_Int);
      }
      if ((i1 > 0) && (i1 != this.jdField_b_of_type_Int)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ColorScreenManager", 2, "loadColorScreen early return");
    return;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_b_of_type_Int = i1;
    if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())) {}
    for (Object localObject = "1";; localObject = "2")
    {
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "Bubble", "ShowEffect", (String)localObject, 1, 0, 0, null, Integer.toString(i1), null);
      localObject = ((bdqa)this.app.getManager(235)).jdField_a_of_type_Arsj;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader = new FriendProfileCardActivity.ColorScreenLoader(this, i1);
      ((arsj)localObject).a(i1, bdqf.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader));
      return;
    }
  }
  
  public void m()
  {
    Intent localIntent = new Intent(this, VipProfileCardDiyActivity.class);
    localIntent.putExtra("extra_from", 1);
    localIntent.putExtra("extra_card_id", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId);
    localIntent.putExtra("extra_card_url", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl);
    localIntent.putExtra("extra_card_default_text", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyDefaultText);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyText)) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId > 0))
    {
      localIntent.putExtra("extra_card_text", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyText);
      localIntent.putExtra("extra_card_font", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId);
      localIntent.putExtra("extra_card_x", this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a().x);
      localIntent.putExtra("extra_card_y", this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a().y);
      localIntent.putExtra("extra_card_scale", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextScale);
      localIntent.putExtra("extra_card_rotation", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextDegree);
      localIntent.putExtra("extra_card_transparency", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextTransparency);
    }
    startActivityForResult(localIntent, 600001);
  }
  
  public void n()
  {
    Intent localIntent = new Intent(this, QRDisplayActivity.class);
    String str = this.app.getCurrentAccountUin();
    localIntent.putExtra("title", getString(2131717624));
    localIntent.putExtra("nick", bdbt.h(this.app, str));
    localIntent.putExtra("uin", str);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("reportFlag", 1);
    startActivity(localIntent);
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Awmk.jdField_b_of_type_Boolean)
    {
      R();
      return;
    }
    if (ProfileActivity.AllInOne.k(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      aqcz.a(this.app).a(this.app, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, new acvv(this));
      return;
    }
    b(this.app, this, this.jdField_a_of_type_Awmk);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8193))
    {
      this.jdField_k_of_type_Boolean = true;
      a(0L, null, null, false);
      setResult(8193);
    }
    while (((paramInt1 != 20121207) && (paramInt1 != 20121208) && (paramInt1 != 201209)) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    F();
    h();
    if (this.jdField_a_of_type_Aikl != null) {
      this.jdField_a_of_type_Aikl.c();
    }
    return super.onBackEvent();
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isInNightMode(this.app)) {
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_c_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void onRestart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "friend profile card activity onRestart");
    }
    super.onRestart();
    if ((this.jdField_a_of_type_Awmk != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      this.jdField_a_of_type_Bdjk = new bdjk();
      this.jdField_c_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = false;
      this.jdField_e_of_type_Int = 0;
      if (this.jdField_a_of_type_Bhow != null)
      {
        Message localMessage = this.jdField_a_of_type_Bhow.obtainMessage();
        if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localMessage.what = 1;
          localMessage.obj = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Bhow.sendMessage(localMessage);
        }
      }
    }
  }
  
  public void p()
  {
    bizt localbizt = bizt.a();
    localbizt.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    String str2 = this.app.getCurrentNickname();
    String str1 = str2;
    if (bdje.a(str2)) {
      str1 = this.app.getCurrentNickname();
    }
    localbizt.jdField_b_of_type_JavaLangString = str1;
    bizm.a(this, localbizt, Long.valueOf(Long.parseLong(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)), 1, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g, -1, this.jdField_a_of_type_Asor);
  }
  
  public void q()
  {
    ThreadManager.post(new FriendProfileCardActivity.42(this), 8, null, true);
  }
  
  void r()
  {
    if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 100) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.getCurrentAccountUin()))) {
      startUnlockActivity();
    }
  }
  
  void s()
  {
    QQMessageFacade localQQMessageFacade = this.app.a();
    int i1;
    if (localQQMessageFacade != null)
    {
      i1 = localQQMessageFacade.b();
      if (i1 <= 0) {
        break label105;
      }
      if (i1 > 99) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131720570) + "(99+)");
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131720570) + "(" + i1 + ")");
    return;
    label105:
    getIntent().putExtra("leftViewText", getString(2131720570));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131720570));
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    a(paramIntent);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void t()
  {
    Object localObject3 = null;
    for (;;)
    {
      FrameLayout localFrameLayout;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "updateTheme: ");
        }
        localFrameLayout = (FrameLayout)findViewById(16908290);
        if (this.jdField_a_of_type_Awmk.jdField_a_of_type_Awmr == null) {
          break label711;
        }
        localFrameLayout.setForeground(null);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
        if (this.jdField_a_of_type_Awmk.jdField_a_of_type_Awmr.o == awmr.jdField_j_of_type_Long)
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView.setVisibility(0);
          if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView.setImage(this.jdField_a_of_type_AndroidGraphicsBitmap, (int)(this.jdField_e_of_type_AndroidViewView.getWidth() * 1.1D), (int)(this.jdField_e_of_type_AndroidViewView.getHeight() * 1.1D), 1.0F);
          }
          this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView.setVisibility(0);
          if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
            this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView.setImage(this.jdField_b_of_type_AndroidGraphicsBitmap, (int)(this.jdField_e_of_type_AndroidViewView.getWidth() * 1.1D), (int)(this.jdField_e_of_type_AndroidViewView.getHeight() * 1.1D), -1.0F);
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "updateTheme: set currentBackgroundDrawable");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileQVipDiyView))
          {
            localFrameLayout.setBackgroundDrawable(null);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
            Object localObject1 = localObject3;
            M();
            awmr.a(this.jdField_a_of_type_AndroidViewView, "background", this.jdField_a_of_type_Awmk.jdField_a_of_type_Awmr, "background");
            if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != awmr.jdField_h_of_type_Long) {
              break label615;
            }
            awmr.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, "background", this.jdField_a_of_type_Awmk.jdField_a_of_type_Awmr, "shoppingUserInfoBackground");
            if (Build.VERSION.SDK_INT >= 11)
            {
              if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != awmr.jdField_f_of_type_Long) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != awmr.jdField_h_of_type_Long)) || (!(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof FriendProfileCardBgDrawable))) {
                break label665;
              }
              ThreadManager.post(new FriendProfileCardActivity.BlurBackgroundJob(this.jdField_b_of_type_Bhow, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), 5, null, true);
            }
            if (!ThemeUtil.isInNightMode(this.app)) {
              break label690;
            }
            localObject3 = localObject1;
            if (this.jdField_c_of_type_AndroidViewView == null) {
              break label917;
            }
            this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            if (localObject1 != null) {
              QAPM.setABFactor("资料卡背景", localObject1, abqv.class);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_Awmr)) {
              break label922;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "update item style");
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Awmk, false, new String[0]);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView.setVisibility(8);
          this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView.setVisibility(8);
          continue;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateTheme exception msg=" + localException.getMessage());
        }
        localException.printStackTrace();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      localFrameLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      Object localObject2 = localObject3;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        if (bdrw.b(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable))
        {
          localObject2 = "card-video";
        }
        else if (bdrw.c(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable))
        {
          localObject2 = "card-etc";
        }
        else
        {
          localObject2 = localObject3;
          label917:
          if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof FriendProfileCardBgDrawable)) {
            label665:
            label922:
            if (((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).jdField_d_of_type_Boolean)
            {
              localObject2 = "card-dynamic";
              continue;
              label615:
              if (awmr.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId))
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundDrawable(null);
              }
              else
              {
                awmr.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, "background", this.jdField_a_of_type_Awmk.jdField_a_of_type_Awmr, "commonMaskBackground");
                continue;
                localObject3 = localFrameLayout.getChildAt(0);
                if ((localObject3 != null) && (((View)localObject3).getBackground() != null))
                {
                  ((View)localObject3).setBackgroundDrawable(null);
                  continue;
                  localObject3 = localObject2;
                  if (this.jdField_c_of_type_AndroidViewView != null)
                  {
                    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
                    continue;
                    if (awmr.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId))
                    {
                      localObject3 = "card-diy";
                      localFrameLayout.setForeground(null);
                      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
                      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundResource(0);
                      localFrameLayout.setBackgroundDrawable(null);
                      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
                      M();
                      if (ThemeUtil.isInNightMode(this.app))
                      {
                        if (this.jdField_c_of_type_AndroidViewView != null)
                        {
                          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
                          localObject2 = "card-diy";
                        }
                      }
                      else if (this.jdField_c_of_type_AndroidViewView != null)
                      {
                        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
                        localObject2 = "card-diy";
                      }
                    }
                    else
                    {
                      localObject3 = "card-default";
                      if (QLog.isColorLevel()) {
                        QLog.d("FriendProfileCardActivity", 2, "updateTheme: cardInfo.currentTemplate is null");
                      }
                      localFrameLayout.setForeground(getResources().getDrawable(2130849469));
                      localFrameLayout.setBackgroundResource(2130845286);
                      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
                      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundResource(0);
                      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
                      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
                      if (this.jdField_c_of_type_AndroidViewView != null) {
                        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
                      }
                      J();
                    }
                  }
                  localObject2 = localObject3;
                }
              }
            }
            else
            {
              label690:
              label711:
              localObject2 = "card-static";
            }
          }
        }
      }
    }
  }
  
  public void u()
  {
    int i1 = -77;
    int i2;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyText)) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == awmr.jdField_g_of_type_Long))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView = new DiyTextView(this);
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setOnMeasuredListener(new acvz(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setMaxSize(this.jdField_e_of_type_AndroidViewView.getWidth() * 2 / 3);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      i2 = (int)(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextTransparency * 255.0F);
      if (i2 >= -77) {}
    }
    for (;;)
    {
      Object localObject = this.jdField_d_of_type_AndroidViewView;
      if (i1 > 0) {}
      for (i2 = -16777216;; i2 = -1)
      {
        ((View)localObject).setBackgroundColor(i2);
        this.jdField_d_of_type_AndroidViewView.getBackground().setAlpha(Math.abs(i1));
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a(this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setImageDegree(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextDegree);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setImageScale(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextScale);
        localObject = getResources().getDisplayMetrics();
        SingleTouchLayout localSingleTouchLayout = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout;
        float f1 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextLocX;
        float f2 = ((DisplayMetrics)localObject).widthPixels;
        float f3 = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextLocY;
        localSingleTouchLayout.setCenterPoint(f1 * f2, ((DisplayMetrics)localObject).heightPixels * f3);
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId, 1, asnx.b);
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setText(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard.diyText);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a();
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.invalidate();
        return;
        if (i2 <= 77) {
          break label370;
        }
        i1 = 77;
        break;
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView = null;
      return;
      label370:
      i1 = i2;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      runOnUiThread(new FriendProfileCardActivity.45(this));
    }
  }
  
  public void v()
  {
    if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof FriendProfileCardBgDrawable))) {
      ThreadManager.post(new FriendProfileCardActivity.48(this, ((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a()), 5, null, true);
    }
  }
  
  public void w()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_c_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheQuality(524288);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(8);
      this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getDrawingCache();
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368255).setVisibility(8);
      if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), this.jdField_c_of_type_AndroidGraphicsBitmap));
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void x()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_c_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.destroyDrawingCache();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.jdField_c_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368255).setVisibility(0);
    }
  }
  
  public void y()
  {
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.smoothScrollToPosition(0);
  }
  
  public void z()
  {
    try
    {
      if (!isFinishing())
      {
        this.jdField_a_of_type_Bepp = new bepp(this, getTitleBarHeight());
        this.jdField_a_of_type_Bepp.setCancelable(false);
        this.jdField_a_of_type_Bepp.c(2131695637);
        this.jdField_a_of_type_Bepp.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */
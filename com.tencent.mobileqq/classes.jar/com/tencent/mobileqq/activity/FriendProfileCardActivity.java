package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloManager.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardHandler.CardTransProcessorHandler;
import com.tencent.mobileqq.app.CardHandler.CoverTransCallback;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.campuscircle.CampusCircleHandler;
import com.tencent.mobileqq.campuscircle.CampusCircleObserver;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.floatscr.ColorScreenManager;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.Util;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.PersonalityLabel.OnGetPersonalityLabelsListener;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard.IScroll;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelObserver;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.diy.DiyTextView;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileGameView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfilePhotoView;
import com.tencent.mobileqq.profile.view.ProfileShoppingView;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profile.view.ShakeImageView;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;
import com.tencent.mobileqq.profile.view.VipProfileWZRYView;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.QCallCardHandler;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.HummerParser;
import com.tencent.mobileqq.troop.widget.ProfileGuideHelper;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.unifiedname.MQQProfileNameTranslator;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.MusicPendantView;
import com.tencent.mobileqq.widget.OnGetPhotoWallListener;
import com.tencent.mobileqq.widget.PerfRelativeLayout;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.ProfilePerformanceReport;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView.OnScrollChangeListener;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.XListView.MotionEventInterceptor;
import com.tencent.widget.XSimpleListAdapter;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.CoverCacheData;
import java.io.File;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import sta;
import std;
import stg;
import stn;
import stp;
import stq;
import stt;
import stv;
import stw;
import stx;
import sty;
import stz;
import sub;
import suc;
import sud;
import suf;
import sug;
import suk;
import sup;
import suq;
import sur;
import sus;
import sut;
import suu;
import suv;
import suw;
import sux;
import suy;
import suz;
import svb;
import svc;
import sve;
import svf;
import svg;
import svh;
import svi;
import svj;
import svk;
import svl;
import svm;
import svn;
import svp;
import svt;
import svu;
import svy;
import swa;
import swf;
import swg;
import swi;
import swj;

public class FriendProfileCardActivity
  extends ProfileActivity
  implements TopGestureLayout.OnGestureListener, CardHandler.CoverTransCallback, PersonalityLabelBoard.IScroll, XListView.MotionEventInterceptor, Observer
{
  public static long a;
  public static String f;
  public static String g;
  static long jdField_i_of_type_Long;
  public static long j;
  byte jdField_a_of_type_Byte;
  protected float a;
  public int a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new sub(this);
  public DialogInterface.OnClickListener a;
  public Intent a;
  public Bitmap a;
  public Drawable a;
  public Uri a;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new suw(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new suk(this);
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new sug(this);
  public View a;
  public ViewGroup a;
  public AlphaAnimation a;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new sve(this);
  public ImageView a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public PstnSessionInfo a;
  public ShareAioResultDialog a;
  public FriendProfileCardActivity.ColorScreenLoader a;
  public ProfileActivity.CardContactInfo a;
  public ApolloTextureView a;
  private SpriteDrawerInfoManager jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager;
  protected ApolloBoxEnterView a;
  private ApolloDrawerInfoViewListener jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener;
  private CardHandler.CardTransProcessorHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler$CardTransProcessorHandler;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new stg(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new stq(this);
  protected TroopObserver a;
  CampusCircleObserver jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver = new std(this);
  public DiniFlyAnimationView a;
  OnDrawCompleteListener jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener = new svj(this);
  PreloadProcHitPluginSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = new PreloadProcHitPluginSession("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.a());
  public PreloadProcHitSession a;
  GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new stt(this);
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new stp(this);
  OnGetPersonalityLabelsListener jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelOnGetPersonalityLabelsListener;
  PersonalityLabelObserver jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelObserver = new sta(this);
  public ProfileBusiEntry a;
  public ProfileCardInfo a;
  public ProfileShoppingPhotoInfo a;
  public DiyTextView a;
  public ProfileHeaderView a;
  public ShakeImageView a;
  public SingleTouchLayout a;
  public PstnCardInfo a;
  public PstnManager a;
  public RedTouch a;
  IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new suy(this);
  public ProfileGuideHelper a;
  protected QQCustomDialog a;
  public TimeTraceUtil a;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new sur(this);
  public MusicPendantView a;
  public OnGetPhotoWallListener a;
  public ProfileCardMoreInfoView a;
  public QQProgressDialog a;
  public BusinessInfoCheckUpdate.AppInfo a;
  public WeakReferenceHandler a;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new svm(this);
  public ActionSheet a;
  ListView.OnScrollChangeListener jdField_a_of_type_ComTencentWidgetListView$OnScrollChangeListener = new svl(this);
  public PullToZoomHeaderListView a;
  public ImmersiveTitleBar2 a;
  Runnable jdField_a_of_type_JavaLangRunnable = new svy(this);
  public String a;
  public ArrayDeque a;
  public ArrayList a;
  private Vector jdField_a_of_type_JavaUtilVector = new Vector();
  public AtomicBoolean a;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private swg jdField_a_of_type_Swg;
  swi jdField_a_of_type_Swi = new swi(this);
  boolean jdField_a_of_type_Boolean = false;
  public int[] a;
  public String[] a;
  public int b;
  long jdField_b_of_type_Long = 0L;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  public DialogInterface.OnClickListener b;
  protected Intent b;
  public Bitmap b;
  public Uri b;
  Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new suz(this);
  View jdField_b_of_type_AndroidViewView;
  public AlphaAnimation b;
  public ImageView b;
  public TextView b;
  CardObserver jdField_b_of_type_ComTencentMobileqqAppCardObserver = new stn(this);
  public ShakeImageView b;
  public QQProgressDialog b;
  public WeakReferenceHandler b;
  public Runnable b;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  protected int[] b;
  public int c;
  public long c;
  Bitmap c;
  public View c;
  public TextView c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public View d;
  public TextView d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  View e;
  public String e;
  public boolean e;
  public int f;
  long f;
  public View f;
  public boolean f;
  public int g;
  long jdField_g_of_type_Long;
  View jdField_g_of_type_AndroidViewView;
  protected boolean g;
  public int h;
  long jdField_h_of_type_Long;
  protected String h;
  boolean jdField_h_of_type_Boolean = false;
  public int i;
  public String i;
  boolean jdField_i_of_type_Boolean;
  public int j;
  public String j;
  public boolean j;
  public int k;
  long k;
  public boolean k;
  public int l;
  protected boolean l;
  protected int m;
  protected boolean m;
  public int n;
  public boolean n;
  protected int o;
  public boolean o;
  public int p;
  int jdField_q_of_type_Int = 0;
  private boolean jdField_q_of_type_Boolean;
  public int r;
  private boolean r;
  private boolean s;
  private boolean t;
  
  static
  {
    jdField_f_of_type_JavaLangString = "http://office.qq.com";
    jdField_g_of_type_JavaLangString = "http://www.qq.com";
    jdField_j_of_type_Long = 2000L;
  }
  
  public FriendProfileCardActivity()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = new ProfileCardInfo();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayDeque = new ArrayDeque();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "is_binding_shop";
    this.jdField_j_of_type_Int = -1;
    this.jdField_b_of_type_AndroidContentIntent = new Intent();
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new stx(this);
    this.jdField_l_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession = new PreloadProcHitSession("profile_card", "com.tencent.mobileqq:tool");
    this.jdField_k_of_type_Boolean = false;
    this.jdField_p_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_r_of_type_Int = 30000;
    this.jdField_b_of_type_JavaLangRunnable = new svf(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new svg(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new svh(this);
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
  }
  
  private void S()
  {
    Object localObject = (FriendsManager)this.app.getManager(50);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FriendsManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Int = ((Friends)localObject).netTypeIconId;
        if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
        {
          localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
          ((Message)localObject).what = 15;
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
        }
      }
      return;
    }
  }
  
  private void T()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "clearBGCache size = " + this.jdField_a_of_type_JavaUtilVector.size());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
    while (localIterator.hasNext()) {
      ((FriendProfileCardBgDrawable)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilVector.clear();
  }
  
  private void U()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) || (!NetworkUtil.g(this))) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
          Object localObject = (TroopManager)this.app.getManager(51);
          TroopHandler localTroopHandler = (TroopHandler)this.app.a(20);
          localObject = ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString);
          if (localObject != null)
          {
            localTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString, ((TroopInfo)localObject).troopcode, localArrayList);
            localTroopHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin));
            if (!TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString))
            {
              localTroopHandler.d(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin));
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("FriendProfileCardActivity", 2, "loadTroopMemberCard:" + localException.toString());
  }
  
  private void V()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96) && (e())) {
      return;
    }
    a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.jdField_a_of_type_AndroidAppDialog);
  }
  
  private void W()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend)
    {
      localIntent.putExtra("uintype", 0);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend)) {
        break label217;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
      label121:
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
      }
      localIntent.putExtra("uinname", (String)localObject2);
      localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString);
      localObject1 = (TroopManager)this.app.getManager(51);
      if (localObject1 == null) {
        break label231;
      }
      ((TroopManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString, new sut(this, localIntent));
    }
    label217:
    label231:
    while (!QLog.isColorLevel())
    {
      return;
      localIntent.putExtra("uintype", 1000);
      break;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark;
      break label121;
    }
    QLog.e("FriendProfileCardActivity", 2, "enterChatByTroopMember, troopManager is null");
  }
  
  private void X()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      Object localObject = "loginwelcome_" + this.app.c();
      localObject = getApplication().getSharedPreferences((String)localObject, 0);
      boolean bool = ((SharedPreferences)localObject).getBoolean("first_device", false);
      int i1 = ((SharedPreferences)localObject).getInt("bubble_tips_time", 0);
      if ((bool) && (i1 < 3))
      {
        TextView localTextView = new TextView(this);
        localTextView.setId(2131362408);
        localTextView.setBackgroundResource(2130842506);
        localTextView.setIncludeFontPadding(false);
        localTextView.setClickable(false);
        localTextView.setText("快来完善资料吧！");
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 16.0F);
        int i2 = AIOUtils.a(7.0F, getResources());
        int i3 = AIOUtils.a(7.0F, getResources());
        localTextView.setPadding(i2, AIOUtils.a(7.0F, getResources()), i3, AIOUtils.a(13.0F, getResources()));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(2, 2131370271);
        localLayoutParams.rightMargin = AIOUtils.a(15.0F, getResources());
        localLayoutParams.bottomMargin = AIOUtils.a(-1.0F, getResources());
        ((PerfRelativeLayout)this.jdField_f_of_type_AndroidViewView).addView(localTextView, localLayoutParams);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putInt("bubble_tips_time", i1 + 1);
        ((SharedPreferences.Editor)localObject).commit();
        ReportController.b(this.app, "dc00898", "", "", "0X80081C0", "0X80081C0", 0, 0, "", "", "", "");
      }
    }
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
  
  public static String a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject1 = a(paramAllInOne);
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).jdField_b_of_type_JavaLangString + ((ProfileActivity.CardContactInfo)localObject1).c;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramAllInOne.jdField_a_of_type_JavaLangString;
      }
      return localObject2;
    }
  }
  
  public static String a(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i1 = ProfileCardUtil.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if (i1 == 0)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (ProfileActivity.AllInOne.i(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject1 = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2];
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.n;
        }
      }
      localObject2 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject2 = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      return localObject1;
      if ((i1 == 1000) || (i1 == 1020))
      {
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
        }
      }
      else if ((i1 == 1021) || (i1 == 1029))
      {
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.n;
        }
      }
      else if (i1 == 1004)
      {
        localObject1 = localObject2;
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString != null) {
          localObject1 = ContactUtils.c(paramQQAppInterface, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (ProfileActivity.AllInOne.h(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          localObject1 = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, ProfileCardInfo paramProfileCardInfo, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if ((paramActivity.getIntent() != null) && (paramActivity.getIntent().getExtras() != null)) {
      localIntent.putExtra("cSpecialFlag", paramActivity.getIntent().getExtras().getInt("cSpecialFlag"));
    }
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int != 0) {
      localIntent.putExtra("entrance", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int);
    }
    localIntent.putExtra("uinname", paramString2);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(Message paramMessage)
  {
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(102);
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
        if (localObject1 != null) {}
      }
      catch (Exception paramMessage)
      {
        Object localObject1;
        int i1;
        ImageView localImageView;
        Object localObject3;
        Object localObject2;
        bool1 = false;
        bool2 = true;
        paramMessage.printStackTrace();
        bool3 = bool1;
        boolean bool4 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MedalWallMng", 2, "checkMedalGuide exception", paramMessage);
        bool3 = bool1;
        bool4 = bool2;
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
        localObject1 = this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        ((Message)localObject1).what = paramMessage.what;
        ((Message)localObject1).arg1 = (paramMessage.arg1 + 1);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed((Message)localObject1, 1000L);
        bool4 = bool1;
        bool3 = bool2;
        if ((!bool4) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) || (((ProfileBaseView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).jdField_a_of_type_Float >= 1.0F)) {
          break label691;
        }
        ((ProfileBaseView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).jdField_a_of_type_Float = 1.0F;
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, "update medal anim alpha [1]");
        }
        bool1 = true;
      }
      catch (Exception paramMessage)
      {
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
        continue;
        bool1 = bool3;
        continue;
        bool1 = true;
        continue;
        bool2 = false;
        continue;
      }
      if (bool1) {
        c();
      }
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkMedalGuide needUpdateAlpha:%s, needUpdateMedal: %s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool1) }));
      }
      return;
      localObject1 = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_medal_container");
      if (localObject1 == null)
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
        localImageView = (ImageView)((View)localObject1).findViewById(2131372536);
        localObject1 = (TextView)((View)localObject1).findViewById(2131372537);
        if ((localObject1 != null) && (((TextView)localObject1).getWidth() > 0) && (((TextView)localObject1).getHeight() > 0)) {
          if (localImageView == null)
          {
            localObject3 = (MedalWallMng)this.app.getManager(249);
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) {
              continue;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
            bool1 = ((MedalWallMng)localObject3).a(this, (View)localObject1, 2, localObject2);
            if ((!bool1) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null)) {
              break label702;
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
            if (localObject1 == null) {
              break label702;
            }
          }
        }
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkMedalGuide [iNewCount: %d, iUpgradeCount: %d]", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iNewCount), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iUpgradeCount) }));
        }
        bool2 = true;
        if (bool1) {
          break label697;
        }
      }
      catch (Exception paramMessage)
      {
        bool1 = true;
        bool2 = true;
        continue;
      }
      try
      {
        if (!(localImageView instanceof DiniFlyAnimationView)) {
          break label697;
        }
        localObject1 = (LocalRedTouchManager)this.app.getManager(159);
        localObject2 = ((LocalRedTouchManager)localObject1).a(10015);
        localObject3 = ((LocalRedTouchManager)localObject1).a(10016);
        if (!((LocalRedTouchManager)localObject1).a((RedTouchItem)localObject2, false))
        {
          bool1 = ((LocalRedTouchManager)localObject1).a((RedTouchItem)localObject3, false);
          if (!bool1) {}
        }
        else
        {
          i1 = 1;
          if (i1 == 0) {
            break label697;
          }
        }
      }
      catch (Exception paramMessage)
      {
        bool1 = bool2;
        bool2 = true;
        continue;
      }
      try
      {
        ThreadManager.post(new svp(this, (DiniFlyAnimationView)localImageView), 5, null, true);
        bool1 = false;
        i1 = 0;
      }
      catch (Exception paramMessage)
      {
        bool1 = bool2;
        bool2 = false;
        continue;
      }
      localObject1 = localImageView;
      continue;
      localObject2 = null;
      continue;
      i1 = 0;
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
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    int i2 = ProfileCardUtil.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    String str3 = a(paramProfileCardInfo, paramQQAppInterface);
    String str2 = null;
    Object localObject;
    String str1;
    if (ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      str2 = null;
      if (i2 != 1000) {
        break label370;
      }
      str1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
    }
    for (;;)
    {
      label58:
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "free call click");
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Clk_freecall", a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      ChatActivityUtils.a(paramQQAppInterface, paramBaseActivity, i2, (String)localObject, str3, str2, true, str1, true, true, null, "from_internal");
      switch (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
      {
      default: 
        paramBaseActivity = "4";
      }
      for (;;)
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, paramBaseActivity, "", "", "");
        return;
        str1 = str2;
        int i1 = i2;
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
        {
          str1 = str2;
          i1 = i2;
          if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
          {
            str1 = str2;
            i1 = i2;
            if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin))
            {
              str1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
              i1 = 0;
            }
          }
        }
        str2 = a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        localObject = str1;
        i2 = i1;
        break;
        label370:
        if (i2 != 1004) {
          break label418;
        }
        str1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
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
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo, Dialog paramDialog)
  {
    Object localObject = paramBaseActivity.getIntent().getBundleExtra("profile_extres");
    boolean bool;
    int i3;
    int i2;
    int i1;
    if (localObject != null)
    {
      bool = ((Bundle)localObject).getBoolean("from_babyq", false);
      int i4 = 3999;
      i3 = 0;
      i2 = i3;
      i1 = i4;
      switch (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
      {
      default: 
        i1 = i4;
        i2 = i3;
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
      case 20: 
      case 28: 
      case 30: 
      case 33: 
      case 38: 
      case 39: 
      case 40: 
      case 43: 
      case 44: 
      case 45: 
      case 48: 
      case 49: 
      case 54: 
      case 55: 
      case 59: 
      case 60: 
      case 62: 
      case 63: 
      case 64: 
      case 65: 
      case 66: 
      case 67: 
      case 68: 
      case 69: 
      case 73: 
      case 76: 
      case 79: 
      case 80: 
      case 85: 
      case 86: 
      case 87: 
      case 88: 
      case 89: 
      case 90: 
      case 91: 
      case 94: 
        label456:
        i3 = i2;
        i2 = i1;
        i1 = i3;
      }
    }
    for (;;)
    {
      if (i2 == 3045) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(i1), "", "", "");
      }
      if (i2 == 3094) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80092E2", "0X80092E2", 0, 0, String.valueOf(i1), "", "", "");
      }
      if ((i2 != 3007) || (LBSHandler.a(paramQQAppInterface, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label1140;
      }
      localObject = paramDialog;
      if (paramDialog == null) {
        localObject = LBSHandler.a(paramBaseActivity, paramBaseActivity.getString(2131437429), new suq(paramQQAppInterface, paramBaseActivity, paramProfileCardInfo), new sus());
      }
      if ((localObject != null) && (!((Dialog)localObject).isShowing()) && (!paramBaseActivity.isFinishing())) {
        ((Dialog)localObject).show();
      }
      return;
      bool = false;
      break;
      i1 = 0;
      i2 = 3004;
      continue;
      i1 = 1;
      i2 = 3007;
      continue;
      i1 = 1;
      i2 = 3001;
      continue;
      i1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int;
      i2 = 3020;
      continue;
      i1 = 1;
      i2 = 3017;
      continue;
      i1 = 0;
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
      i1 = 0;
      i2 = 3008;
      continue;
      i1 = 0;
      i2 = 3008;
      continue;
      i1 = 0;
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
      i1 = 3042;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_l_of_type_Int == 10000) {
        i1 = 3037;
      }
      i3 = 1;
      i2 = i1;
      i1 = i3;
      continue;
      i1 = 0;
      i2 = 3009;
      continue;
      i1 = 3006;
      i2 = i3;
      if (!bool) {
        break label456;
      }
      i1 = 1;
      i2 = 3084;
      continue;
      i1 = 3068;
      i2 = 1;
      if (!bool) {
        break label456;
      }
      i1 = 1;
      i2 = 3084;
      continue;
      i1 = 2;
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
      i1 = 1;
      i2 = 3014;
      continue;
      i1 = 2;
      i2 = 3003;
      continue;
      i1 = 3022;
      i2 = i3;
      if (!bool) {
        break label456;
      }
      i1 = 1;
      i2 = 3083;
      continue;
      i1 = 0;
      i2 = 3011;
      continue;
      i1 = 1;
      i2 = 3071;
      continue;
      i1 = 1;
      i2 = 3045;
      continue;
      i1 = 2;
      i2 = 3045;
      continue;
      i1 = 3045;
      i2 = 3;
      if (!bool) {
        break label456;
      }
      i1 = 1;
      i2 = 3084;
      continue;
      i1 = 4;
      i2 = 3045;
      continue;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 114)
      {
        i1 = 2;
        i2 = 3082;
      }
      else
      {
        i1 = 1;
        i2 = 3082;
        continue;
        i1 = 1;
        i2 = 3092;
        continue;
        i1 = 1;
        i2 = 3094;
      }
    }
    label1140:
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (localObject = ProfileCardUtil.a(paramQQAppInterface.getApp().getApplicationContext(), paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.shGender, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.age, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strCountry, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strProvince, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strCity);; localObject = "")
    {
      String str;
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 29))
      {
        ProfileActivity.CardContactInfo localCardContactInfo = a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if ((localCardContactInfo == null) || (localCardContactInfo.c == null) || (localCardContactInfo.c.length() <= 0)) {
          break;
        }
        str = localCardContactInfo.jdField_b_of_type_JavaLangString + localCardContactInfo.c;
        paramDialog = localCardContactInfo.jdField_a_of_type_JavaLangString;
        paramQQAppInterface = paramDialog;
        if (TextUtils.isEmpty(localCardContactInfo.jdField_a_of_type_JavaLangString))
        {
          if (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3])) {
            break label1486;
          }
          paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
        }
        for (;;)
        {
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 2, str, null, i2, i1, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131433712), null);
          paramQQAppInterface.putExtra("param_return_profilecard_pa", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject);
          bool = paramBaseActivity.getIntent().getBooleanExtra("from_newer_guide", false);
          if (!bool) {
            break;
          }
          paramQQAppInterface.putExtra("from_newer_guide", bool);
          paramQQAppInterface.removeExtra("param_return_addr");
          paramBaseActivity.startActivityForResult(paramQQAppInterface, 1024);
          return;
          label1486:
          if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0]))
          {
            paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
          }
          else
          {
            paramQQAppInterface = paramDialog;
            if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString)) {
              paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
            }
          }
        }
        paramBaseActivity.startActivity(paramQQAppInterface);
        return;
      }
      paramQQAppInterface = null;
      if ((3004 == i2) && (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)))
      {
        paramDialog = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString;
        paramQQAppInterface = null;
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 71) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 72)) {
          break label1839;
        }
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2];
        label1610:
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          break label2106;
        }
        paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      label1839:
      label2103:
      label2106:
      for (;;)
      {
        str = paramBaseActivity.getIntent().getStringExtra("param_return_addr");
        if (str != null)
        {
          localObject = AddContactsActivity.class.getName();
          if (!str.equals(QidianProfileCardActivity.class.getName())) {
            break label2103;
          }
          localObject = str;
        }
        for (;;)
        {
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialog, i2, i1, paramQQAppInterface, null, (String)localObject, paramBaseActivity.getString(2131433712), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          paramQQAppInterface.putExtra("param_return_profilecard_pa", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
          if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47))
          {
            paramQQAppInterface.putExtra("param_return_profilecard_discuss_uin", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "FriendProfileCardActivity %s", new Object[] { paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString }));
            }
          }
          paramBaseActivity.startActivity(paramQQAppInterface);
          return;
          paramDialog = paramQQAppInterface;
          if (3005 != i2) {
            break;
          }
          paramDialog = paramQQAppInterface;
          if (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
            break;
          }
          paramDialog = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString;
          break;
          if (ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int))
          {
            paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2];
            break label1610;
          }
          if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 77) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 82) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 81) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 83) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 84)) {
            break label1610;
          }
          paramQQAppInterface = paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5];
          break label1610;
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramDialog, i2, i1, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131433712), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          paramQQAppInterface.putExtra("param_return_profilecard_pa", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
          if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47))
          {
            paramQQAppInterface.putExtra("param_return_profilecard_discuss_uin", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "FriendProfileCardActivity %s", new Object[] { paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString }));
            }
          }
          if (paramProfileCardInfo.jdField_b_of_type_Boolean) {
            paramQQAppInterface.putExtra("param_return_profilecard_troop_uin", paramProfileCardInfo.jdField_d_of_type_JavaLangString);
          }
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject);
          paramBaseActivity.startActivityForResult(paramQQAppInterface, 1000);
          return;
        }
      }
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo, String paramString, int paramInt)
  {
    int i1;
    if (paramBaseActivity.getIntent() != null) {
      if ((paramBaseActivity.getIntent().getBooleanExtra("from_newer_guide", false)) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 110)) {
        i1 = 1;
      }
    }
    for (;;)
    {
      Object localObject;
      label54:
      Intent localIntent;
      if (i1 != 0)
      {
        localObject = new Intent(paramBaseActivity, ChatActivity.class);
        localIntent = AIOUtils.a((Intent)localObject, null);
        localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
        localIntent.putExtra("PREVIOUS_UIN", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if (paramBaseActivity.getIntent().getExtras() != null) {
          localIntent.putExtra("cSpecialFlag", paramBaseActivity.getIntent().getExtras().getInt("cSpecialFlag"));
        }
        localIntent.putExtra("uin", paramString);
        localIntent.putExtra("uintype", paramInt);
        localIntent.putExtra("aio_msg_source", 3);
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int != 0) {
          localIntent.putExtra("entrance", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_j_of_type_Int);
        }
        localObject = a(paramProfileCardInfo, paramQQAppInterface);
        if (localObject != null) {
          break label538;
        }
        paramString = "";
        label196:
        localIntent.putExtra("uinname", paramString);
        if (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
          break label544;
        }
        localIntent.putExtra("troop_uin", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString);
        label235:
        if (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c)) {
          localIntent.putExtra("troop_code", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c);
        }
        if (paramInt == 1009) {
          localIntent.putExtra("rich_status_sig", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
        if (paramInt == 1001) {
          localIntent.putExtra("rich_accost_sig", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
        if (paramInt == 1029) {
          localIntent.putExtra("rich_campus_circle_sig", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, String.format(Locale.getDefault(), "enterChar uin: %s name: %s sig: %s", new Object[] { Utils.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString), Utils.b((String)localObject), Utils.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b) }));
        }
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if ((paramQQAppInterface != null) && ((CrmUtils.a(paramQQAppInterface.cSpecialFlag)) || (QidianManager.b(paramQQAppInterface.cSpecialFlag)))) {
            localIntent.putExtra("chat_subType", 1);
          }
        }
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 70) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int != 101)) {
          break label576;
        }
        localIntent.putExtra("is_from_manage_stranger", true);
        paramBaseActivity.startActivityForResult(localIntent, 1010);
      }
      for (;;)
      {
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 110) {
          paramBaseActivity.finish();
        }
        return;
        i1 = 0;
        break;
        localObject = new Intent(paramBaseActivity, SplashActivity.class);
        break label54;
        label538:
        paramString = (String)localObject;
        break label196;
        label544:
        if (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString)) {
          break label235;
        }
        localIntent.putExtra("troop_uin", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString);
        break label235;
        label576:
        paramBaseActivity.startActivity(localIntent);
      }
      i1 = 0;
    }
  }
  
  /* Error */
  public static void a(QQAppInterface arg0, ProfileCardInfo paramProfileCardInfo)
  {
    // Byte code:
    //   0: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 416
    //   9: iconst_2
    //   10: ldc_w 1181
    //   13: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   20: getfield 766	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   23: astore 6
    //   25: aload_1
    //   26: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   29: getfield 765	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   32: astore_3
    //   33: aload_1
    //   34: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   37: getfield 768	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:m	Ljava/lang/String;
    //   40: astore 5
    //   42: aload_1
    //   43: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   46: getfield 1183	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   49: astore 12
    //   51: aload_1
    //   52: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   55: getfield 1185	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   58: astore 10
    //   60: aload_1
    //   61: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   64: getfield 1186	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   67: astore 14
    //   69: aload_1
    //   70: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   73: getfield 763	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:n	Ljava/lang/String;
    //   76: astore 13
    //   78: aload 6
    //   80: astore 7
    //   82: aload 6
    //   84: astore 8
    //   86: aload_1
    //   87: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   90: invokestatic 1188	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   93: ifeq +571 -> 664
    //   96: aload 6
    //   98: astore 7
    //   100: aload 6
    //   102: astore 8
    //   104: aload_0
    //   105: bipush 50
    //   107: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   110: checkcast 375	com/tencent/mobileqq/app/FriendsManager
    //   113: astore 4
    //   115: aload 4
    //   117: ifnonnull +522 -> 639
    //   120: aconst_null
    //   121: astore 11
    //   123: aload 6
    //   125: astore 9
    //   127: aload 11
    //   129: ifnull +873 -> 1002
    //   132: aload 6
    //   134: astore 4
    //   136: aload 6
    //   138: astore 7
    //   140: aload 6
    //   142: astore 8
    //   144: aload 11
    //   146: getfield 1191	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   149: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: ifne +18 -> 170
    //   155: aload 6
    //   157: astore 7
    //   159: aload 6
    //   161: astore 8
    //   163: aload 11
    //   165: getfield 1191	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   168: astore 4
    //   170: aload 4
    //   172: astore 7
    //   174: aload 4
    //   176: astore 8
    //   178: aload 4
    //   180: astore 9
    //   182: aload 11
    //   184: getfield 1192	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   187: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   190: ifne +812 -> 1002
    //   193: aload 4
    //   195: astore 7
    //   197: aload 4
    //   199: astore 8
    //   201: aload 11
    //   203: getfield 1192	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   206: astore 6
    //   208: aload 4
    //   210: astore_3
    //   211: aload 6
    //   213: astore 4
    //   215: aload_0
    //   216: bipush 51
    //   218: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   221: checkcast 484	com/tencent/mobileqq/app/TroopManager
    //   224: astore 7
    //   226: aload_1
    //   227: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   230: getfield 1137	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:c	Ljava/lang/String;
    //   233: astore 6
    //   235: aload 6
    //   237: astore_0
    //   238: aload 6
    //   240: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifeq +40 -> 283
    //   246: aload 6
    //   248: astore_0
    //   249: aload_1
    //   250: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   253: getfield 769	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   256: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   259: ifne +24 -> 283
    //   262: aload 6
    //   264: astore_0
    //   265: aload 7
    //   267: ifnull +16 -> 283
    //   270: aload 7
    //   272: aload_1
    //   273: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   276: getfield 769	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   279: invokevirtual 1194	com/tencent/mobileqq/app/TroopManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   282: astore_0
    //   283: aload_0
    //   284: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   287: ifne +696 -> 983
    //   290: aload 7
    //   292: ifnull +691 -> 983
    //   295: aload 7
    //   297: aload_0
    //   298: aload_1
    //   299: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   302: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   305: invokevirtual 1197	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   308: astore_0
    //   309: aload 10
    //   311: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   314: ifeq +662 -> 976
    //   317: aload_1
    //   318: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   321: invokestatic 746	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Lcom/tencent/mobileqq/activity/ProfileActivity$CardContactInfo;
    //   324: astore 5
    //   326: aload 5
    //   328: ifnull +648 -> 976
    //   331: aload 5
    //   333: getfield 1069	com/tencent/mobileqq/activity/ProfileActivity$CardContactInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   336: astore 5
    //   338: aload 4
    //   340: astore 6
    //   342: aload 5
    //   344: astore 9
    //   346: aload_3
    //   347: astore 4
    //   349: aload 6
    //   351: astore 5
    //   353: aload_0
    //   354: astore 6
    //   356: aload_1
    //   357: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   360: astore_0
    //   361: aload_0
    //   362: monitorenter
    //   363: aload_1
    //   364: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   367: iconst_0
    //   368: aaload
    //   369: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   372: ifeq +11 -> 383
    //   375: aload_1
    //   376: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   379: iconst_0
    //   380: aload 4
    //   382: aastore
    //   383: aload_1
    //   384: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   387: iconst_4
    //   388: aaload
    //   389: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   392: ifeq +11 -> 403
    //   395: aload_1
    //   396: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   399: iconst_4
    //   400: aload 5
    //   402: aastore
    //   403: aload_1
    //   404: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   407: iconst_3
    //   408: aaload
    //   409: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   412: ifeq +11 -> 423
    //   415: aload_1
    //   416: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   419: iconst_3
    //   420: aload 9
    //   422: aastore
    //   423: aload_1
    //   424: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   427: iconst_5
    //   428: aaload
    //   429: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   432: ifeq +11 -> 443
    //   435: aload_1
    //   436: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   439: iconst_5
    //   440: aload 12
    //   442: aastore
    //   443: aload_1
    //   444: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   447: iconst_1
    //   448: aaload
    //   449: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   452: ifeq +11 -> 463
    //   455: aload_1
    //   456: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   459: iconst_1
    //   460: aload 6
    //   462: aastore
    //   463: aload_1
    //   464: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   467: bipush 6
    //   469: aaload
    //   470: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   473: ifeq +12 -> 485
    //   476: aload_1
    //   477: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   480: bipush 6
    //   482: aload 14
    //   484: aastore
    //   485: aload_1
    //   486: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   489: iconst_2
    //   490: aaload
    //   491: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   494: ifeq +11 -> 505
    //   497: aload_1
    //   498: getfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   501: iconst_2
    //   502: aload 13
    //   504: aastore
    //   505: aload_0
    //   506: monitorexit
    //   507: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   510: ifeq +128 -> 638
    //   513: new 418	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 419	java/lang/StringBuilder:<init>	()V
    //   520: astore_0
    //   521: aload_0
    //   522: ldc_w 1199
    //   525: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: ldc_w 1201
    //   531: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload 4
    //   536: invokestatic 1155	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   539: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: ldc_w 1203
    //   545: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload 5
    //   550: invokestatic 1155	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   553: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc_w 1205
    //   559: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload 9
    //   564: invokestatic 1155	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   567: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: ldc_w 1207
    //   573: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 12
    //   578: invokestatic 1155	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   581: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: ldc_w 1209
    //   587: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload 6
    //   592: invokestatic 1155	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   595: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: ldc_w 1211
    //   601: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: aload 13
    //   606: invokestatic 1155	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   609: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: ldc_w 1213
    //   615: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload 12
    //   620: invokestatic 1155	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   623: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: ldc_w 416
    //   630: iconst_2
    //   631: aload_0
    //   632: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 525	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: return
    //   639: aload 6
    //   641: astore 7
    //   643: aload 6
    //   645: astore 8
    //   647: aload 4
    //   649: aload_1
    //   650: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   653: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   656: invokevirtual 407	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   659: astore 11
    //   661: goto -538 -> 123
    //   664: aload 6
    //   666: astore 7
    //   668: aload 6
    //   670: astore 8
    //   672: aload_1
    //   673: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   676: getfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   679: ifne +33 -> 712
    //   682: aload 6
    //   684: astore 7
    //   686: aload 6
    //   688: astore 8
    //   690: aload_0
    //   691: aload_1
    //   692: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   695: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   698: invokestatic 1216	com/tencent/mobileqq/utils/ContactUtils:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   701: astore 6
    //   703: aload_3
    //   704: astore 4
    //   706: aload 6
    //   708: astore_3
    //   709: goto -494 -> 215
    //   712: aload 6
    //   714: astore 7
    //   716: aload 6
    //   718: astore 8
    //   720: aload 6
    //   722: astore 4
    //   724: aload 6
    //   726: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   729: ifeq +260 -> 989
    //   732: aload 6
    //   734: astore 7
    //   736: aload 6
    //   738: astore 8
    //   740: aload 6
    //   742: astore 4
    //   744: aload_1
    //   745: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   748: invokestatic 946	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:f	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   751: ifeq +238 -> 989
    //   754: aload 6
    //   756: astore 7
    //   758: aload 6
    //   760: astore 8
    //   762: aload_0
    //   763: aload_1
    //   764: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   767: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   770: iconst_0
    //   771: invokestatic 1219	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   774: astore 4
    //   776: aload 4
    //   778: astore 7
    //   780: aload 4
    //   782: astore 8
    //   784: aload 4
    //   786: aload_1
    //   787: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   790: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   793: invokestatic 1222	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   796: istore_2
    //   797: iload_2
    //   798: ifeq +191 -> 989
    //   801: aconst_null
    //   802: astore 6
    //   804: aload_3
    //   805: astore 4
    //   807: aload 6
    //   809: astore_3
    //   810: goto -595 -> 215
    //   813: astore 8
    //   815: aload 5
    //   817: astore_0
    //   818: aload_0
    //   819: astore 6
    //   821: aload_3
    //   822: astore 5
    //   824: aload 7
    //   826: astore 4
    //   828: aload 10
    //   830: astore 9
    //   832: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   835: ifeq -479 -> 356
    //   838: ldc_w 416
    //   841: iconst_2
    //   842: aload 8
    //   844: invokevirtual 523	java/lang/Exception:toString	()Ljava/lang/String;
    //   847: invokestatic 525	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   850: aload_0
    //   851: astore 6
    //   853: aload_3
    //   854: astore 5
    //   856: aload 7
    //   858: astore 4
    //   860: aload 10
    //   862: astore 9
    //   864: goto -508 -> 356
    //   867: astore 7
    //   869: aload 5
    //   871: astore_0
    //   872: aload_0
    //   873: astore 6
    //   875: aload_3
    //   876: astore 5
    //   878: aload 8
    //   880: astore 4
    //   882: aload 10
    //   884: astore 9
    //   886: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq -533 -> 356
    //   892: ldc_w 416
    //   895: iconst_2
    //   896: aload 7
    //   898: invokevirtual 1223	java/lang/Error:toString	()Ljava/lang/String;
    //   901: invokestatic 525	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: aload_0
    //   905: astore 6
    //   907: aload_3
    //   908: astore 5
    //   910: aload 8
    //   912: astore 4
    //   914: aload 10
    //   916: astore 9
    //   918: goto -562 -> 356
    //   921: astore_1
    //   922: aload_0
    //   923: monitorexit
    //   924: aload_1
    //   925: athrow
    //   926: astore 7
    //   928: aload_3
    //   929: astore 8
    //   931: aload 5
    //   933: astore_0
    //   934: aload 4
    //   936: astore_3
    //   937: goto -65 -> 872
    //   940: astore 7
    //   942: aload_3
    //   943: astore 8
    //   945: aload 4
    //   947: astore_3
    //   948: goto -76 -> 872
    //   951: astore 8
    //   953: aload_3
    //   954: astore 7
    //   956: aload 5
    //   958: astore_0
    //   959: aload 4
    //   961: astore_3
    //   962: goto -144 -> 818
    //   965: astore 8
    //   967: aload_3
    //   968: astore 7
    //   970: aload 4
    //   972: astore_3
    //   973: goto -155 -> 818
    //   976: aload 10
    //   978: astore 5
    //   980: goto -642 -> 338
    //   983: aload 5
    //   985: astore_0
    //   986: goto -677 -> 309
    //   989: aload 4
    //   991: astore 6
    //   993: aload_3
    //   994: astore 4
    //   996: aload 6
    //   998: astore_3
    //   999: goto -784 -> 215
    //   1002: aload_3
    //   1003: astore 4
    //   1005: aload 9
    //   1007: astore_3
    //   1008: goto -793 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1011	1	paramProfileCardInfo	ProfileCardInfo
    //   796	2	2	bool	boolean
    //   32	976	3	localObject1	Object
    //   113	891	4	localObject2	Object
    //   40	944	5	localObject3	Object
    //   23	974	6	localObject4	Object
    //   80	777	7	localObject5	Object
    //   867	30	7	localError1	java.lang.Error
    //   926	1	7	localError2	java.lang.Error
    //   940	1	7	localError3	java.lang.Error
    //   954	15	7	localObject6	Object
    //   84	699	8	localObject7	Object
    //   813	98	8	localException1	Exception
    //   929	15	8	localObject8	Object
    //   951	1	8	localException2	Exception
    //   965	1	8	localException3	Exception
    //   125	881	9	localObject9	Object
    //   58	919	10	str1	String
    //   121	539	11	localFriends	Friends
    //   49	570	12	str2	String
    //   76	529	13	str3	String
    //   67	416	14	str4	String
    // Exception table:
    //   from	to	target	type
    //   86	96	813	java/lang/Exception
    //   104	115	813	java/lang/Exception
    //   144	155	813	java/lang/Exception
    //   163	170	813	java/lang/Exception
    //   182	193	813	java/lang/Exception
    //   201	208	813	java/lang/Exception
    //   647	661	813	java/lang/Exception
    //   672	682	813	java/lang/Exception
    //   690	703	813	java/lang/Exception
    //   724	732	813	java/lang/Exception
    //   744	754	813	java/lang/Exception
    //   762	776	813	java/lang/Exception
    //   784	797	813	java/lang/Exception
    //   86	96	867	java/lang/Error
    //   104	115	867	java/lang/Error
    //   144	155	867	java/lang/Error
    //   163	170	867	java/lang/Error
    //   182	193	867	java/lang/Error
    //   201	208	867	java/lang/Error
    //   647	661	867	java/lang/Error
    //   672	682	867	java/lang/Error
    //   690	703	867	java/lang/Error
    //   724	732	867	java/lang/Error
    //   744	754	867	java/lang/Error
    //   762	776	867	java/lang/Error
    //   784	797	867	java/lang/Error
    //   363	383	921	finally
    //   383	403	921	finally
    //   403	423	921	finally
    //   423	443	921	finally
    //   443	463	921	finally
    //   463	485	921	finally
    //   485	505	921	finally
    //   505	507	921	finally
    //   922	924	921	finally
    //   215	235	926	java/lang/Error
    //   238	246	926	java/lang/Error
    //   249	262	926	java/lang/Error
    //   270	283	926	java/lang/Error
    //   283	290	926	java/lang/Error
    //   295	309	926	java/lang/Error
    //   309	326	940	java/lang/Error
    //   331	338	940	java/lang/Error
    //   215	235	951	java/lang/Exception
    //   238	246	951	java/lang/Exception
    //   249	262	951	java/lang/Exception
    //   270	283	951	java/lang/Exception
    //   283	290	951	java/lang/Exception
    //   295	309	951	java/lang/Exception
    //   309	326	965	java/lang/Exception
    //   331	338	965	java/lang/Exception
  }
  
  public static boolean a(ProfileCardInfo paramProfileCardInfo, int paramInt, String paramString)
  {
    if ((paramInt < 0) && (paramInt > 6)) {
      return false;
    }
    paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
    return true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    ThreadPriorityManager.a(true);
    ProfileActivity.AllInOne localAllInOne = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
    int i1 = ProfileCardUtil.a(localAllInOne);
    if ((localAllInOne.jdField_f_of_type_JavaLangString != null) && (localAllInOne.jdField_f_of_type_JavaLangString.length() > 0) && (localAllInOne.jdField_e_of_type_Int != 3000) && (localAllInOne.jdField_e_of_type_Int != 1) && (localAllInOne.jdField_e_of_type_Int != 2) && (localAllInOne.jdField_e_of_type_Int != 1033) && (localAllInOne.jdField_e_of_type_Int != 1034) && (localAllInOne.jdField_f_of_type_JavaLangString.equals(localAllInOne.jdField_a_of_type_JavaLangString)))
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.putExtra("finchat", true);
      paramBaseActivity.setResult(0, paramQQAppInterface);
      paramBaseActivity.finish();
      return;
    }
    String str = localAllInOne.jdField_a_of_type_JavaLangString;
    if (ProfileActivity.AllInOne.h(localAllInOne)) {
      if (localAllInOne.jdField_a_of_type_Int == 53) {
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) && (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)))
        {
          i1 = 0;
          str = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
        }
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramBaseActivity, paramProfileCardInfo, str, i1);
      return;
      i1 = 1006;
      continue;
      str = a(localAllInOne);
      continue;
      if (localAllInOne.jdField_a_of_type_Int == 3) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
      } else if (localAllInOne.jdField_g_of_type_Int == 102) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_RandomConversation", 0, 0, "", "", "", "");
      } else if (localAllInOne.jdField_g_of_type_Int == 103) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_superConversation", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void b(ProfileCardInfo paramProfileCardInfo)
  {
    int i1 = 3;
    int i2 = 12;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) {
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName = new MQQProfileName();
    }
    switch (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    case 2: 
    case 3: 
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
    case 19: 
    case 23: 
    case 24: 
    case 35: 
    case 37: 
    case 38: 
    case 39: 
    case 43: 
    case 44: 
    case 45: 
    case 48: 
    case 49: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 59: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 73: 
    case 74: 
    case 75: 
    case 76: 
    case 78: 
    case 79: 
    case 80: 
    case 85: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    default: 
      i2 = 0;
      i1 = 1;
    }
    for (;;)
    {
      MQQProfileNameTranslator.a(i2, i1, paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "updateProfileName profileName: %s", new Object[] { paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.toString() }));
      }
      return;
      if (ProfileActivity.AllInOne.i(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
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
        i2 = 6;
        continue;
        i1 = 1;
        i2 = 6;
        continue;
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) && (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)))
        {
          i2 = 6;
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
          if (ProfileActivity.AllInOne.i(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
          {
            i1 = 1;
            continue;
            i2 = 5;
            i1 = 1;
            continue;
            i1 = 2;
            continue;
            i1 = 1;
          }
          else
          {
            i1 = 1;
            i2 = 1;
          }
        }
        else
        {
          i1 = 1;
          i2 = 6;
        }
      }
    }
  }
  
  private boolean e()
  {
    boolean bool = true;
    Card localCard = ((FriendsManager)this.app.getManager(50)).a(this.app.c());
    if (localCard == null) {
      return false;
    }
    if ((TextUtils.isEmpty(localCard.declaration)) || (!localCard.isShowCard)) {
      if (!TextUtils.isEmpty(localCard.declaration)) {
        break label194;
      }
    }
    label192:
    label194:
    for (int i1 = 1;; i1 = 2)
    {
      this.jdField_b_of_type_AndroidAppDialog = ProfileGuideDialogUtils.a(this, i1, new sup(this, localCard));
      try
      {
        if (this.jdField_b_of_type_AndroidAppDialog != null) {
          this.jdField_b_of_type_AndroidAppDialog.show();
        }
        try
        {
          if (TextUtils.isEmpty(localCard.declaration)) {
            ReportController.b(this.app, "dc00898", "", "", "0X80092EA", "0X80092EA", 0, 0, "", "", "", "");
          } else {
            ReportController.b(this.app, "dc00898", "", "", "0X80092E7", "0X80092E7", 0, 0, "", "", "", "");
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
      break label192;
      bool = false;
      return bool;
    }
  }
  
  private void f(int paramInt)
  {
    float f1 = (float)DeviceInfoUtil.j() / DeviceInfoUtil.a();
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "bug from surfaceView.getWidth():" + this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getWidth());
    }
    this.jdField_a_of_type_Float = (paramInt / DeviceInfoUtil.a() - f1 * 184.0F / 1080.0F);
    f1 = FontSettingManager.a() / 16.0F;
    if (f1 != 0.0F) {
      this.jdField_a_of_type_Float = (f1 * this.jdField_a_of_type_Float);
    }
    f1 = (float)Math.max(DeviceInfoUtil.i(), DeviceInfoUtil.h()) * 0.2F / 368.0F;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a(f1, this.jdField_a_of_type_Float, 0.0F);
  }
  
  private boolean f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      Object localObject = (TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131362408);
      if (localObject != null)
      {
        ((PerfRelativeLayout)this.jdField_f_of_type_AndroidViewView).removeView((View)localObject);
        localObject = "loginwelcome_" + this.app.c();
        localObject = getApplication().getSharedPreferences((String)localObject, 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("bubble_tips_time", 3);
        ((SharedPreferences.Editor)localObject).commit();
        return true;
      }
    }
    return false;
  }
  
  public void A()
  {
    int i1 = -77;
    int i2;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyText)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.jdField_g_of_type_Long))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView = new DiyTextView(this);
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setOnMeasuredListener(new svb(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setMaxSize(this.jdField_f_of_type_AndroidViewView.getWidth() * 2 / 3);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      i2 = (int)(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextTransparency * 255.0F);
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
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setImageDegree(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextDegree);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setImageScale(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextScale);
        localObject = getResources().getDisplayMetrics();
        SingleTouchLayout localSingleTouchLayout = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout;
        float f1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextLocX;
        float f2 = ((DisplayMetrics)localObject).widthPixels;
        float f3 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextLocY;
        localSingleTouchLayout.setCenterPoint(f1 * f2, ((DisplayMetrics)localObject).heightPixels * f3);
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId, 2, HiBoomManager.b);
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setText(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyText);
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
  
  public void B()
  {
    if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof FriendProfileCardBgDrawable))) {
      ThreadManager.post(new svc(this, ((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a()), 5, null, true);
    }
  }
  
  public void C()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheQuality(524288);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(8);
      this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getDrawingCache();
      this.jdField_a_of_type_AndroidViewView.findViewById(2131371037).setVisibility(8);
      if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), this.jdField_c_of_type_AndroidGraphicsBitmap));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void D()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.destroyDrawingCache();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.jdField_c_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131371037).setVisibility(0);
    }
  }
  
  public void E()
  {
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.smoothScrollToPosition(0);
  }
  
  public void F()
  {
    try
    {
      if (!isFinishing())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131436773);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void G()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label24:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void H()
  {
    try
    {
      if (!isFinishing())
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131433659);
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void I()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label24:
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void J()
  {
    String str1;
    if (!isFinishing())
    {
      K();
      if (this.jdField_f_of_type_Int != 1) {
        break label64;
      }
      str1 = getString(2131436745);
    }
    for (String str2 = "成为会员之后，即可使用该名片";; str2 = "成为超级会员之后，即可使用该名片")
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.b(this, 0, str1, str2, 2131436758, 2131436759, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      label64:
      str1 = getString(2131436743);
    }
  }
  
  public void K()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  void L()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)))
    {
      BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      Object localObject = ProfileCardUtil.a(this, this.jdField_a_of_type_JavaLangString);
      localObject = "profilecard:" + (String)localObject;
      localObject = (Pair)BaseApplicationImpl.sImageCache.get(localObject);
      if ((localObject != null) && (((Pair)localObject).first != null) && (localBitmapDrawable.getConstantState() != ((Pair)localObject).first))
      {
        localBitmapDrawable.getBitmap().recycle();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      }
    }
  }
  
  public void M()
  {
    CardHandler localCardHandler = (CardHandler)this.app.a(2);
    boolean bool;
    int i1;
    if ((localCardHandler != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null))
    {
      localCardHandler.a(Long.valueOf(this.app.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.vCookies, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.favoriteSource, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), 0);
      bool = ((NearbyLikeLimitManager)this.app.getManager(206)).c(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin).longValue());
      if (PraiseManager.a(this.app) <= 0) {
        break label232;
      }
      if (!bool) {
        break label227;
      }
      i1 = 3;
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Prof_good", 1, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get(), i1, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), String.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()), this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      return;
      label227:
      i1 = 2;
      continue;
      label232:
      if (bool) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
  }
  
  public void N()
  {
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label110;
      }
      if (((PhoneContactManagerImp)this.app.getManager(10)).g())
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
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
  }
  
  public void O()
  {
    ThreadManager.post(new svn(this), 5, null, false);
  }
  
  void P()
  {
    int i1 = 3;
    int i3 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int;
    int i2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int;
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
      ReportController.b(this.app, "dc00898", "", "", "0X8007EB3", "0X8007EB3", i1, 0, "", "", "", "");
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
    ReportController.b(this.app, "dc00898", "", "", "0X8007EB4", "0X8007EB4", i1, 0, "", "", "", "");
  }
  
  public void Q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetProfileGuideHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetProfileGuideHelper.a();
    }
  }
  
  public void R()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)) {}
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = null;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard;
          if (localObject2 != null) {
            localObject1 = ((TroopMemberCard)localObject2).mMemberGameInfo;
          }
        } while (localObject1 == null);
        localObject1 = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      } while ((localObject1 == null) || (!((SharedPreferences)localObject1).getBoolean("750_troo_game_guide", true)));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a();
    } while ((localObject1 == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_c_of_type_Boolean));
    Object localObject2 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
    int i1 = ((DisplayMetrics)localObject2).heightPixels;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetProfileGuideHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetProfileGuideHelper = new ProfileGuideHelper(this, this.app);
    }
    int i2 = (int)getResources().getDimension(2131559298);
    ((View)localObject1).getViewTreeObserver().addOnGlobalLayoutListener(new svu(this, (View)localObject1, i1, i2));
  }
  
  public Card a(String paramString1, String paramString2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    paramString2 = localFriendsManager.a(paramString2);
    if (paramString2 != null)
    {
      paramString1 = localFriendsManager.b(paramString1);
      paramString1.strContactName = paramString2.strContactName;
      paramString1.strMobile = paramString2.mobileNo;
      paramString1.age = paramString2.bAge;
      paramString1.shAge = ((short)paramString2.bAge);
      paramString1.shGender = ((short)paramString2.bSex);
      paramString1.strProvince = paramString2.strProvince;
      paramString1.strCity = paramString2.strCity;
      paramString1.strCountry = paramString2.strCountry;
      localFriendsManager.a(paramString1);
      return paramString1;
    }
    return null;
  }
  
  String a()
  {
    try
    {
      String str = ((PhoneContactManagerImp)this.app.getManager(10)).c(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)).uin;
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
            localObject = ((PhoneContactManager)this.app.getManager(10)).a();
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
      localObject = ProfilePerformanceReport.a;
      if ((localObject != null) && (((ProfilePerformanceReport)localObject).a())) {
        ((ProfilePerformanceReport)localObject).a(4);
      }
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        localObject = null;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
          break label180;
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71)) {
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Network_circle_prof", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int), "", "");
      }
      return;
      label180:
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)
      {
        localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        ((Message)localObject).what = 9;
        ((Message)localObject).obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      else if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        ((Message)localObject).what = 2;
        ((Message)localObject).obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  protected void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Int == 7))
    {
      int i1 = this.jdField_b_of_type_AndroidContentIntent.getIntExtra("memberOperationFlag", 0);
      this.jdField_b_of_type_AndroidContentIntent.putExtra("memberOperationFlag", i1 | paramInt);
      this.jdField_b_of_type_AndroidContentIntent.putExtra("memberOperateUin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      setResult(-1, this.jdField_b_of_type_AndroidContentIntent);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.app == null)) {
      return;
    }
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    }
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
    }
    for (;;)
    {
      int i1;
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (paramString.contains("pet")))
      {
        paramString = (ApolloManager)this.app.getManager(152);
        if (((String)localObject).equals(this.app.c()))
        {
          i1 = 0;
          str = paramString.a((String)localObject);
          if (paramInt1 != 0) {
            break label324;
          }
          paramString = "0";
          label150:
          VipUtils.a(null, "cmshow", "Apollo", "datapetclick", 0, i1, new String[] { str, paramString });
        }
      }
      else
      {
        if (paramInt1 != 0) {
          break label404;
        }
        b(true);
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(this.app.c()))) {
          break label331;
        }
        VipUtils.a(this.app, "cmshow", "Apollo", "file_jump", 0, 0, new String[0]);
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileTagView)) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof VipProfileSimpleView)))) {
          this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new svk(this), 500L);
        }
        label286:
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() != 0) || (paramInt1 != 1)) {
          break label1057;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
        return;
        i1 = 1;
        break;
        label324:
        paramString = "1";
        break label150;
        label331:
        VipUtils.a(this.app, "cmshow", "Apollo", "guest_file_jump", this.jdField_o_of_type_Int, 0, new String[] { "" + ApolloManager.a(this.app), "0", "0", localObject });
      }
      label404:
      if (paramInt2 == 1) {
        VipUtils.a(this.app, "cmshow", "Apollo", "Guide_bubbles_clk", 0, 0, new String[] { "", "", "", localObject });
      }
      if ((this.n) || ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)) || ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.app.c().equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin))))
      {
        this.jdField_l_of_type_Boolean = true;
        paramString = new Intent();
        paramString.putExtra("extra_key_box_uin", (String)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null)
        {
          paramString.putExtra("extra_key_open_box", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
          if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setApolloHadStolen();
            paramString.putExtra("key_box_type", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
          }
        }
        paramString.putExtra("extra_key_url_append", "&tab=interactive&suin=" + (String)localObject);
        paramString.putExtra("extra_key_box_from", "friendcard");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(this.app.c())))
        {
          ApolloUtil.a(this, paramString, "mineprofile", ApolloConstant.Y, null);
          VipUtils.a(this.app, "cmshow", "Apollo", "file_clk", 0, 0, new String[0]);
          label688:
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() != 0)) {
            break label832;
          }
          localObject = this.app;
          if (!this.jdField_o_of_type_Boolean) {
            break label834;
          }
        }
        label832:
        label834:
        for (paramString = "1";; paramString = "0")
        {
          VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "0X80065C0", 1, 0, new String[] { paramString });
          break;
          ApolloUtil.a(this, paramString, "guestprofile", ApolloConstant.Y, null);
          VipUtils.a(this.app, "cmshow", "Apollo", "guest_file_clk", this.jdField_o_of_type_Int, 0, new String[] { "" + ApolloManager.a(this.app), "0", "0", localObject });
          break label688;
          break;
        }
      }
      Intent localIntent = new Intent(this, ApolloGuestsStateActivity.class);
      String str = null;
      paramString = str;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null)
      {
        paramString = str;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
          paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
        }
      }
      if ((TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strNick;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localIntent.putExtra("extra_guest_uin", (String)localObject);
          VipUtils.a(this.app, "cmshow", "Apollo", "guest_file_clk", this.jdField_o_of_type_Int, 0, new String[] { "" + ApolloManager.a(this.app), "0", "0", localObject });
        }
        if (!TextUtils.isEmpty(paramString)) {
          localIntent.putExtra("extra_guest_nick", paramString);
        }
        localIntent.putExtra("extra_guest_from", 3);
        startActivity(localIntent);
        overridePendingTransition(2131034165, 0);
        break label286;
        label1057:
        break;
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    G();
    F();
    ProfileCardUtil.a(this.app, paramLong1, paramLong2, null, paramLong3, paramString);
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, this.jdField_r_of_type_Int);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "requestUpdateCard() mHasTriedCount = " + this.jdField_q_of_type_Int);
    }
    if ((this.jdField_q_of_type_Int > 5) && (!paramBoolean)) {}
    CardHandler localCardHandler;
    do
    {
      return;
      localCardHandler = (CardHandler)this.app.a(2);
    } while (localCardHandler == null);
    this.jdField_q_of_type_Int += 1;
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
        paramArrayOfByte1 = (BusinessCardManager)this.app.getManager(111);
        if (paramArrayOfByte1 != null) {}
        for (paramBoolean = paramArrayOfByte1.a(1);; paramBoolean = false)
        {
          long l3 = a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, paramBoolean);
          switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
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
          case 94: 
          default: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 65535, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3999, arrayOfByte2, (byte)0);
          case 0: 
          case 60: 
          case 1: 
          case 78: 
          case 40: 
          case 41: 
          case 42: 
          case 73: 
          case 86: 
          case 36: 
          case 30: 
            while (ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
            {
              paramArrayOfByte1 = (CampusCircleHandler)this.app.a(108);
              if (paramArrayOfByte1 == null) {
                break;
              }
              paramArrayOfByte1.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              return;
              localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
              continue;
              localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 26, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
              continue;
              localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
              continue;
              localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 3022, arrayOfByte2, (byte)0);
              continue;
              localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
              continue;
              i1 = 6;
              paramArrayOfByte1 = "";
              if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
              {
                i1 = 37;
                paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o;
              }
              localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i1, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, arrayOfByte2, (byte)0);
              continue;
              localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 8, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
              continue;
              localCardHandler.a(this.app.getCurrentAccountUin(), "0", 32, paramLong, (byte)0, 0L, 0L, arrayOfByte1, a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne), l3, 3014, arrayOfByte2, (byte)0);
              continue;
              localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 15, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
            }
          case 29: 
          case 31: 
          case 32: 
          case 34: 
          case 50: 
          case 51: 
          case 53: 
            i1 = 16;
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) {
              i1 = 17;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {
              i1 = 50;
            }
            break;
          }
          for (;;)
          {
            long l2;
            for (;;)
            {
              paramArrayOfByte1 = a(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
              localCardHandler.a(this.app.getCurrentAccountUin(), "0", i1, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, null, (byte)0);
              break;
              ((QCallCardHandler)this.app.a(79)).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              break;
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString == null) {
                break;
              }
              l2 = 0L;
              try
              {
                l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_e_of_type_JavaLangString).longValue();
                int i2 = 0;
                if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 45)
                {
                  i1 = 13;
                  i2 = 1;
                  paramArrayOfByte1 = this.app.getCurrentAccountUin();
                  paramArrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
                  if (i2 != 1) {
                    break label1408;
                  }
                  b1 = this.jdField_a_of_type_Byte;
                  localCardHandler.a(paramArrayOfByte1, paramArrayOfByte2, i1, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, b1);
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
                    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
                    {
                      i1 = 4;
                    }
                    else
                    {
                      i1 = 14;
                      continue;
                      label1408:
                      b1 = 0;
                    }
                  }
                }
              }
            }
            long l1 = ProfileCardUtil.a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20)
            {
              i1 = 2;
              b1 = 1;
              label1451:
              paramArrayOfByte1 = this.app.getCurrentAccountUin();
              paramArrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
              if (b1 != 1) {
                break label1579;
              }
            }
            label1579:
            for (byte b2 = this.jdField_a_of_type_Byte;; b2 = 0)
            {
              localCardHandler.a(paramArrayOfByte1, paramArrayOfByte2, i1, paramLong, b1, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, b2);
              break;
              if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
              {
                i1 = 5;
                b1 = 0;
                break label1451;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 22) {
                break label1451;
              }
              i1 = 7;
              b1 = 0;
              break label1451;
            }
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 21, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            break;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            break;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            break;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 31, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3001, arrayOfByte2, (byte)0);
            break;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 38, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3017, arrayOfByte2, (byte)0);
            break;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 27, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            break;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 36, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int == 3004) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int == 2004)) {
              if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c)) {}
            }
            label1945:
            label2729:
            label2737:
            for (paramArrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c;; paramArrayOfByte1 = "0")
            {
              paramArrayOfByte2 = paramArrayOfByte1;
              if (paramArrayOfByte1 == null) {}
              for (paramArrayOfByte2 = "0";; paramArrayOfByte2 = "0")
              {
                for (;;)
                {
                  l2 = 0L;
                  try
                  {
                    l1 = Long.parseLong(paramArrayOfByte2);
                    i1 = 11;
                    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27) {
                      i1 = 35;
                    }
                    localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i1, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int, arrayOfByte2, (byte)0);
                    break;
                    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString)) {
                      break label2737;
                    }
                    paramArrayOfByte1 = (TroopInfo)this.app.getEntityManagerFactory().createEntityManager().a(TroopInfo.class, "troopcode=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_JavaLangString });
                    if (paramArrayOfByte1 == null) {
                      break label2737;
                    }
                    paramArrayOfByte1 = paramArrayOfByte1.troopuin;
                    break label1945;
                    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 3005) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_Int != 2005)) {
                      break label2729;
                    }
                    paramArrayOfByte2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.c;
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
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                break;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 24, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                break;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                break;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3095, arrayOfByte2, (byte)0);
                break;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 28, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.jdField_a_of_type_Byte);
                break;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 29, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                break;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 30, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                break;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 34, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                break;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 33, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                break;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3045, arrayOfByte2, (byte)0);
                break;
                if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 91) {}
                for (b1 = 1;; b1 = 0)
                {
                  localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 52, paramLong, b1, 0L, 0L, arrayOfByte1, "", l3, 3082, arrayOfByte2, (byte)0);
                  break;
                }
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 53, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3094, arrayOfByte2, (byte)0);
                break;
              }
            }
          }
        }
        arrayOfByte2 = paramArrayOfByte2;
      }
      arrayOfByte1 = paramArrayOfByte1;
    }
  }
  
  void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 2131494242;
    if (paramView != null)
    {
      DataTag localDataTag = new DataTag(paramInt1, null);
      paramView.setVisibility(0);
      paramView = (Button)paramView.findViewById(2131365278);
      paramView.setTag(localDataTag);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(getString(paramInt4));
      paramView.setText(paramInt2);
      if ((!a(paramInt1)) || (this.jdField_e_of_type_Boolean)) {
        break label150;
      }
      paramView.setTextColor(getResources().getColor(2131494270));
      paramView.setEnabled(this.jdField_e_of_type_Boolean);
      if ((7 == paramInt1) && (QSecFramework.a().a(1001).booleanValue())) {
        QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(1), paramView }, null);
      }
    }
    return;
    label150:
    if (paramInt3 == 2)
    {
      paramInt2 = 2131494242;
      label160:
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label195;
      }
      paramInt2 = i1;
    }
    label195:
    for (;;)
    {
      paramView.setTextColor(getResources().getColor(paramInt2));
      break;
      paramInt2 = 2131494244;
      break label160;
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
      if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "changeProfileHeaderView success remove timeout msg");
        }
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
      }
      Object localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371023);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
    if ((!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) && (this.jdField_b_of_type_AndroidViewView != null)) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("headerViewLoadingEnd", false);
  }
  
  void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    this.jdField_g_of_type_AndroidViewView = null;
    int i1 = getResources().getDimensionPixelSize(2131559292);
    int i2 = getResources().getDimensionPixelSize(2131559292);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      this.jdField_g_of_type_AndroidViewView = View.inflate(this, 2130970589, null);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
      localLayoutParams.weight = 1.0F;
      localLayoutParams.rightMargin = i2;
      paramLinearLayout.addView(this.jdField_g_of_type_AndroidViewView, localLayoutParams);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_g_of_type_AndroidViewView = View.inflate(this, 2130971021, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_g_of_type_AndroidViewView, localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_g_of_type_AndroidViewView).c(30).d(30).a();
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          h();
        }
        this.jdField_g_of_type_AndroidViewView = View.inflate(this, 2130970542, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i1;
        paramLinearLayout.addView(this.jdField_g_of_type_AndroidViewView, localLayoutParams);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)
      {
        this.jdField_g_of_type_AndroidViewView = View.inflate(this, 2130970589, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_g_of_type_AndroidViewView, localLayoutParams);
        this.jdField_g_of_type_AndroidViewView = View.inflate(this, 2130970542, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_g_of_type_AndroidViewView, localLayoutParams);
        this.jdField_g_of_type_AndroidViewView = View.inflate(this, 2130970589, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_g_of_type_AndroidViewView, localLayoutParams);
        this.jdField_g_of_type_AndroidViewView = View.inflate(this, 2130970542, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i2;
        paramLinearLayout.addView(this.jdField_g_of_type_AndroidViewView, localLayoutParams);
      }
    }
  }
  
  public void a(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.c;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label152;
      }
      Intent localIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramCardContactInfo));
      if ((!MobileIssueSettings.jdField_a_of_type_Boolean) && (KapalaiAdapterUtil.a().a())) {
        KapalaiAdapterUtil.a().a(localIntent);
      }
      startActivity(localIntent);
      this.app.a().b(paramCardContactInfo);
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "call", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label152:
      a(2131435781, 1);
    }
  }
  
  public void a(ApolloManager.CheckApolloInfoResult paramCheckApolloInfoResult)
  {
    if ((paramCheckApolloInfoResult == null) || (paramCheckApolloInfoResult.jdField_a_of_type_Boolean) || (this.app == null) || (this.jdField_f_of_type_AndroidViewView == null) || (!(this.jdField_f_of_type_AndroidViewView instanceof RelativeLayout))) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
    }
    for (;;)
    {
      long l1 = Math.max(DeviceInfoUtil.i(), DeviceInfoUtil.h());
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null)
      {
        this.jdField_m_of_type_Int = paramCheckApolloInfoResult.jdField_a_of_type_Int;
        this.jdField_b_of_type_ArrayOfInt = paramCheckApolloInfoResult.jdField_a_of_type_ArrayOfInt;
        paramCheckApolloInfoResult = (RelativeLayout)this.jdField_f_of_type_AndroidViewView.getParent();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(this, null);
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager = new SpriteDrawerInfoManager(this.app);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener = new ApolloDrawerInfoViewListener(this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager, 2);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener);
        this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
        this.jdField_a_of_type_Swg = new swg(this, null);
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a(this.jdField_a_of_type_Swg);
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a((String)localObject1);
        localObject2 = new RelativeLayout.LayoutParams((int)(DeviceInfoUtil.j() / 2L), (int)((float)l1 * 0.5F));
        ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.a(56.0F, getResources());
        paramCheckApolloInfoResult.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject2);
        f((int)(DeviceInfoUtil.j() / 2L));
        if (localObject1 != null)
        {
          if (!((String)localObject1).equals(this.app.c())) {
            break label553;
          }
          VipUtils.a(this.app, "cmshow", "Apollo", "file_show", 0, 0, new String[0]);
        }
      }
      for (;;)
      {
        if (this.n)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView = new ApolloBoxEnterView(this, null);
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject1 = new RelativeLayout.LayoutParams(AIOUtils.a(45.0F, getResources()), AIOUtils.a(45.0F, getResources()));
          ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
          ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.a(45.0F, getResources());
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.a(75.0F, getResources());
          paramCheckApolloInfoResult.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView, (ViewGroup.LayoutParams)localObject1);
          b(false);
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setOnClickListener(this.jdField_a_of_type_Swg);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
        return;
        label553:
        localObject2 = ((ApolloManager)this.app.getManager(152)).b(this.app.c());
        if (localObject2 != null) {
          this.jdField_o_of_type_Int = ((ApolloBaseInfo)localObject2).apolloStatus;
        }
        VipUtils.a(this.app, "cmshow", "Apollo", "guest_file_show", this.jdField_o_of_type_Int, 0, new String[] { "" + ApolloManager.a(this.app), "0", "0", localObject1 });
      }
    }
  }
  
  public void a(Card paramCard)
  {
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())))
    {
      localObject1 = new Intent(this, VisitorsActivity.class);
      localObject2 = new Bundle();
      boolean bool;
      if (paramCard == null)
      {
        i1 = 0;
        ((Bundle)localObject2).putLong("toUin", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue());
        ((Bundle)localObject2).putLong("totalVoters", i1);
        ((Bundle)localObject2).putBoolean("isStartedByProfileCard", true);
        ((Bundle)localObject2).putBoolean("votersOnly", true);
        if (i1 <= 0) {
          break label317;
        }
        bool = true;
        label123:
        ((Bundle)localObject2).putBoolean("hasVoters", bool);
        ((Bundle)localObject2).putBoolean("extra_show_rank", true);
        ((Bundle)localObject2).putInt("extra_from", 1);
        ((Bundle)localObject2).putInt("frome_where", 5);
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        startActivity((Intent)localObject1);
        NearbyProxy.a(this.app);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
        {
          paramCard = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
          if (!(paramCard instanceof VoteView)) {
            break label323;
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
        ReportController.b(this.app, "CliOper", "", "", "0X800657A", "0X800657A", 1, 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        i1 = (int)paramCard.lVoteCount;
        break;
        label317:
        bool = false;
        break label123;
        label323:
        if ((paramCard instanceof VoteViewV2))
        {
          paramCard = (VoteViewV2)paramCard;
          paramCard.a(true, false, i1, 0, null, false);
          paramCard.a(false);
        }
      }
    }
    Object localObject1 = new HashMap();
    Object localObject2 = this.app.getCurrentAccountUin();
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "card is null,vote failed !");
      }
      a(2131435803, 1);
      ((HashMap)localObject1).put("param_FailCode", "-210");
      StatisticCollector.a(this.app.getApp()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
      return;
    }
    CardHandler localCardHandler = (CardHandler)this.app.a(2);
    if (QLog.isColorLevel()) {
      QLog.i("FriendProfileCardActivity", 2, "Click Vote View, card.bAvailVoteCnt = " + paramCard.bAvailVoteCnt + ",card.bHaveVotedCnt = " + paramCard.bHaveVotedCnt + ",card.strVoteLimitedNotice = " + paramCard.strVoteLimitedNotice);
    }
    label522:
    int i2;
    if (paramCard.bAvailVoteCnt <= 0)
    {
      i1 = 1;
      if ((paramCard.bHaveVotedCnt > 0) || (paramCard.bAvailVoteCnt > 0)) {
        break label727;
      }
      i2 = 1;
    }
    for (;;)
    {
      if ((i1 == 0) && (i2 == 0))
      {
        if ((localCardHandler != null) && (NetworkUtil.d(BaseApplication.getContext())))
        {
          paramCard.lVoteCount += 1L;
          paramCard.bVoted = 1;
          l1 = paramCard.lVoteCount;
          paramCard.bAvailVoteCnt = ((short)(paramCard.bAvailVoteCnt - 1));
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
          this.jdField_h_of_type_Boolean = true;
          if (!this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(10))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("FriendProfileCardActivity", 4, "reqFavorite| onclick =" + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin + "," + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount);
            }
            paramCard = Message.obtain();
            paramCard.what = 10;
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(paramCard, 2000L);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, l1, true);
          return;
          i1 = 0;
          break label522;
          label727:
          i2 = 0;
          continue;
        }
        if (localCardHandler != null)
        {
          ((HashMap)localObject1).put("param_FailCode", "-203");
          StatisticCollector.a(this.app.getApp()).a((String)localObject2, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject1, "", false);
          a(2131435782, 1);
          return;
        }
        ((HashMap)localObject1).put("param_FailCode", "-204");
        StatisticCollector.a(this.app.getApp()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
        a(2131435803, 1);
        return;
      }
    }
    long l1 = SystemClock.uptimeMillis() - jdField_i_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "toastInterval:" + l1);
    }
    if (paramCard.strVoteLimitedNotice != null)
    {
      if (l1 > jdField_j_of_type_Long)
      {
        a(paramCard.strVoteLimitedNotice, 0);
        jdField_i_of_type_Long = SystemClock.uptimeMillis();
      }
      if (i2 != 0) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006579", "0X8006579", 1, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), "", "", "");
      }
    }
    for (;;)
    {
      StatisticCollector.a(this.app.getApp()).a((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
      return;
      if (i1 != 0)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8006578", "0X8006578", 1, 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int)), "", "", "");
        continue;
        if (l1 > jdField_j_of_type_Long)
        {
          a(2131435803, 1);
          jdField_i_of_type_Long = SystemClock.uptimeMillis();
        }
        if (i1 != 0) {
          ((HashMap)localObject1).put("param_FailCode", "-230");
        } else if (i2 != 0) {
          ((HashMap)localObject1).put("param_FailCode", "-231");
        } else {
          ((HashMap)localObject1).put("param_FailCode", "-220");
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
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_qzonecover"))) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramString, 1);
      }
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramString;
      c(true);
      l1 = 0L;
      if (paramCard == null) {
        break label279;
      }
      l1 = paramCard.feedPreviewTime;
      paramString = paramCard.vSeed;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      a(paramCard, false);
      paramCard = paramString;
      label161:
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
        break label288;
      }
    }
    label279:
    label288:
    for (paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;; paramString = null)
    {
      a(l1, paramCard, paramString, true);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_qzonecover"))) {
        break;
      }
      ProfileHeaderView localProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
      String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        i1 = 1;
      }
      localProfileHeaderView.a(str, i1);
      break;
      j();
      paramCard = null;
      break label161;
    }
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initUpdateInfoStart", true);
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("updateInfo Card=");
      if (paramCard != null)
      {
        str = paramCard.getProfileCardDesc();
        QLog.i("Q.profilecard.FrdProfileCard", 2, str + " isNetRet = " + paramBoolean);
      }
    }
    else
    {
      c(null);
      a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean);
      if ((this.jdField_j_of_type_Int != 1) && (paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry != null) && (paramCard != null)) {
        paramCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(paramCard, paramBoolean);
      a(paramBoolean);
      n();
      if ((paramBoolean) && (paramCard != null) && ((paramCard.lCurrentStyleId != ProfileCardTemplate.jdField_f_of_type_Long) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_f_of_type_Int == 1))) {
        k();
      }
      if ((this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null))
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strReMark)) {
          break label279;
        }
        this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strReMark + getResources().getString(2131439140));
      }
    }
    for (;;)
    {
      R();
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initUpdateInfoEnd", "initUpdateInfoStart", false);
      return;
      str = "null";
      break;
      label279:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strNick)) {
        this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strNick + getResources().getString(2131439140));
      }
    }
  }
  
  /* Error */
  public void a(Card paramCard, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +663 -> 666
    //   6: iload_3
    //   7: iconst_1
    //   8: if_icmpeq +9 -> 17
    //   11: iload_3
    //   12: bipush 8
    //   14: if_icmpne +70 -> 84
    //   17: aload_1
    //   18: getfield 2519	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   21: lconst_0
    //   22: lcmp
    //   23: iflt +61 -> 84
    //   26: aload_0
    //   27: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: ldc_w 950
    //   33: ldc 150
    //   35: ldc 150
    //   37: ldc_w 2521
    //   40: ldc_w 2523
    //   43: aload_0
    //   44: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   47: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   50: getfield 956	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   53: invokestatic 959	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(I)I
    //   56: iconst_0
    //   57: aload_0
    //   58: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   61: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   64: invokestatic 960	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)I
    //   67: invokestatic 963	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   70: aload_1
    //   71: getfield 2519	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   74: invokestatic 2526	java/lang/Long:toString	(J)Ljava/lang/String;
    //   77: ldc 150
    //   79: ldc 150
    //   81: invokestatic 727	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   84: getstatic 1803	com/tencent/util/ProfilePerformanceReport:a	Lcom/tencent/util/ProfilePerformanceReport;
    //   87: astore 19
    //   89: aload 19
    //   91: ifnull +18 -> 109
    //   94: aload 19
    //   96: invokevirtual 1804	com/tencent/util/ProfilePerformanceReport:a	()Z
    //   99: ifeq +10 -> 109
    //   102: aload 19
    //   104: bipush 7
    //   106: invokevirtual 1806	com/tencent/util/ProfilePerformanceReport:a	(I)V
    //   109: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +66 -> 178
    //   115: ldc_w 416
    //   118: iconst_2
    //   119: new 418	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 419	java/lang/StringBuilder:<init>	()V
    //   126: ldc_w 2528
    //   129: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_0
    //   133: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_c_of_type_Boolean	Z
    //   136: invokevirtual 2475	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   139: ldc_w 2530
    //   142: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: iload_2
    //   146: invokevirtual 2475	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   149: ldc_w 2532
    //   152: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: iload_3
    //   156: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: ldc_w 2534
    //   162: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_1
    //   166: invokevirtual 2470	com/tencent/mobileqq/data/Card:getProfileCardDesc	()Ljava/lang/String;
    //   169: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload_0
    //   179: aload_1
    //   180: iload_2
    //   181: invokevirtual 2537	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/data/Card;Z)Z
    //   184: pop
    //   185: aload_0
    //   186: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   189: invokestatic 2539	com/tencent/mobileqq/activity/FriendProfileCardActivity:b	(Lcom/tencent/mobileqq/profile/ProfileCardInfo;)V
    //   192: iconst_0
    //   193: istore 10
    //   195: iconst_0
    //   196: istore 8
    //   198: iconst_0
    //   199: istore 6
    //   201: iconst_0
    //   202: istore 4
    //   204: iload 6
    //   206: istore 5
    //   208: iload 10
    //   210: istore 9
    //   212: iload_3
    //   213: bipush 8
    //   215: if_icmpne +1463 -> 1678
    //   218: iload 6
    //   220: istore 5
    //   222: iload 10
    //   224: istore 9
    //   226: aload_0
    //   227: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   230: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   233: getfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   236: ifne +1442 -> 1678
    //   239: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +52 -> 294
    //   245: ldc_w 416
    //   248: iconst_2
    //   249: new 418	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 419	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 2541
    //   259: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_0
    //   263: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   266: getfield 473	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   269: getfield 2544	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   272: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc_w 2546
    //   278: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_1
    //   282: getfield 2544	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   285: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: aload_0
    //   295: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   298: getfield 473	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   301: getfield 2544	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   304: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   307: ifeq +362 -> 669
    //   310: aload_1
    //   311: getfield 2544	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   314: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   317: ifne +22 -> 339
    //   320: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +1365 -> 1688
    //   326: ldc_w 416
    //   329: iconst_2
    //   330: ldc_w 2548
    //   333: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: goto +1352 -> 1688
    //   339: aload_0
    //   340: getfield 2549	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_f_of_type_Long	J
    //   343: aload_1
    //   344: getfield 1346	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   347: lcmp
    //   348: ifeq +6 -> 354
    //   351: iconst_1
    //   352: istore 4
    //   354: iload 4
    //   356: istore 5
    //   358: iload 8
    //   360: istore 9
    //   362: aload_0
    //   363: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   366: getfield 473	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   369: getfield 1346	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   372: getstatic 1350	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_g_of_type_Long	J
    //   375: lcmp
    //   376: ifne +1302 -> 1678
    //   379: iload 4
    //   381: istore 5
    //   383: iload 8
    //   385: istore 9
    //   387: aload_1
    //   388: getfield 1343	com/tencent/mobileqq/data/Card:diyText	Ljava/lang/String;
    //   391: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   394: ifne +1284 -> 1678
    //   397: iconst_1
    //   398: istore 6
    //   400: iload 4
    //   402: istore 5
    //   404: iload 6
    //   406: istore 4
    //   408: iload_3
    //   409: bipush 13
    //   411: if_icmpne +22 -> 433
    //   414: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +1277 -> 1694
    //   420: ldc_w 416
    //   423: iconst_2
    //   424: ldc_w 2551
    //   427: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: goto +1264 -> 1694
    //   433: aload_1
    //   434: getfield 2554	com/tencent/mobileqq/data/Card:tempChatSig	[B
    //   437: ifnull +83 -> 520
    //   440: aload_1
    //   441: getfield 2554	com/tencent/mobileqq/data/Card:tempChatSig	[B
    //   444: arraylength
    //   445: ifle +75 -> 520
    //   448: aload_0
    //   449: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   452: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   455: aload_1
    //   456: getfield 2554	com/tencent/mobileqq/data/Card:tempChatSig	[B
    //   459: putfield 1142	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	[B
    //   462: invokestatic 814	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   465: ifeq +55 -> 520
    //   468: ldc_w 520
    //   471: iconst_4
    //   472: invokestatic 841	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   475: ldc_w 2556
    //   478: iconst_2
    //   479: anewarray 845	java/lang/Object
    //   482: dup
    //   483: iconst_0
    //   484: aload_0
    //   485: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   488: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   491: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   494: invokestatic 1155	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   497: aastore
    //   498: dup
    //   499: iconst_1
    //   500: aload_0
    //   501: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   504: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   507: getfield 1142	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	[B
    //   510: invokestatic 1158	com/tencent/mobileqq/util/Utils:a	([B)Ljava/lang/String;
    //   513: aastore
    //   514: invokestatic 857	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   517: invokestatic 525	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: aload_0
    //   521: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   524: aload_1
    //   525: putfield 473	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   528: aload_0
    //   529: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_c_of_type_Boolean	Z
    //   532: ifeq +17 -> 549
    //   535: iload 8
    //   537: ifne +12 -> 549
    //   540: iload 8
    //   542: istore 9
    //   544: iload 5
    //   546: ifeq +239 -> 785
    //   549: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   552: ifeq +44 -> 596
    //   555: ldc_w 416
    //   558: iconst_2
    //   559: new 418	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 419	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 2558
    //   569: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_0
    //   573: getfield 139	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_c_of_type_Boolean	Z
    //   576: invokevirtual 2475	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   579: ldc_w 2560
    //   582: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: iload 8
    //   587: invokevirtual 2475	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   590: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   596: aload_1
    //   597: getfield 1346	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   600: lstore 12
    //   602: aload_1
    //   603: getfield 2563	com/tencent/mobileqq/data/Card:templateRet	I
    //   606: istore 6
    //   608: aload_1
    //   609: getfield 2544	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   612: astore 18
    //   614: aload_1
    //   615: getfield 2566	com/tencent/mobileqq/data/Card:backgroundColor	J
    //   618: lstore 14
    //   620: aload_1
    //   621: getfield 2569	com/tencent/mobileqq/data/Card:strZipUrl	Ljava/lang/String;
    //   624: astore 20
    //   626: aload_1
    //   627: getfield 2572	com/tencent/mobileqq/data/Card:dynamicCardFlag	I
    //   630: istore 7
    //   632: aload_1
    //   633: getfield 2575	com/tencent/mobileqq/data/Card:strWzryHeroUrl	Ljava/lang/String;
    //   636: astore 21
    //   638: aload_1
    //   639: getfield 2519	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   642: lstore 16
    //   644: lload 12
    //   646: lconst_0
    //   647: lcmp
    //   648: ifge +63 -> 711
    //   651: aload_0
    //   652: invokestatic 467	com/tencent/mobileqq/utils/NetworkUtil:g	(Landroid/content/Context;)Z
    //   655: istore 9
    //   657: iload 9
    //   659: ifeq +52 -> 711
    //   662: iload_2
    //   663: ifne +48 -> 711
    //   666: aload_0
    //   667: monitorexit
    //   668: return
    //   669: aload_0
    //   670: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   673: getfield 473	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   676: getfield 2544	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   679: aload_1
    //   680: getfield 2544	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   683: invokevirtual 1120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   686: ifne -347 -> 339
    //   689: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   692: ifeq +13 -> 705
    //   695: ldc_w 416
    //   698: iconst_2
    //   699: ldc_w 2577
    //   702: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   705: iconst_1
    //   706: istore 8
    //   708: goto -369 -> 339
    //   711: aload_0
    //   712: getfield 2108	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   715: ldc_w 2579
    //   718: iconst_1
    //   719: invokevirtual 2115	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Z)V
    //   722: aload_0
    //   723: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   726: lload 12
    //   728: iconst_1
    //   729: invokestatic 2582	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JZ)Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   732: astore 22
    //   734: aload_0
    //   735: getfield 2108	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   738: ldc_w 2584
    //   741: ldc_w 2579
    //   744: iconst_0
    //   745: invokevirtual 2511	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   748: lload 12
    //   750: lconst_0
    //   751: lcmp
    //   752: ifle +21 -> 773
    //   755: aload 22
    //   757: ifnull +16 -> 773
    //   760: aload 18
    //   762: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   765: ifne +8 -> 773
    //   768: iload 6
    //   770: ifeq +404 -> 1174
    //   773: aload_0
    //   774: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   777: aconst_null
    //   778: putfield 2587	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   781: iload 8
    //   783: istore 9
    //   785: iload 4
    //   787: ifeq +104 -> 891
    //   790: aload_0
    //   791: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   794: getfield 473	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   797: getfield 1346	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   800: getstatic 1350	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_g_of_type_Long	J
    //   803: lcmp
    //   804: ifne +87 -> 891
    //   807: aload_0
    //   808: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   811: getfield 473	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   814: getfield 1438	com/tencent/mobileqq/data/Card:diyTextFontId	I
    //   817: invokestatic 2590	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:a	(I)Z
    //   820: ifne +71 -> 891
    //   823: aload_0
    //   824: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   827: sipush 183
    //   830: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   833: checkcast 2592	com/tencent/mobileqq/vas/VasQuickUpdateManager
    //   836: astore 18
    //   838: aload 18
    //   840: new 2594	stc
    //   843: dup
    //   844: aload_0
    //   845: invokespecial 2595	stc:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   848: invokevirtual 2598	com/tencent/mobileqq/vas/VasQuickUpdateManager:a	(Lcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)V
    //   851: aload 18
    //   853: ldc2_w 2599
    //   856: new 418	java/lang/StringBuilder
    //   859: dup
    //   860: invokespecial 419	java/lang/StringBuilder:<init>	()V
    //   863: ldc_w 2602
    //   866: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: aload_0
    //   870: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   873: getfield 473	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   876: getfield 1438	com/tencent/mobileqq/data/Card:diyTextFontId	I
    //   879: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   882: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   885: ldc_w 520
    //   888: invokevirtual 2605	com/tencent/mobileqq/vas/VasQuickUpdateManager:a	(JLjava/lang/String;Ljava/lang/String;)V
    //   891: aload_0
    //   892: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   895: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   898: getfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   901: ifeq +799 -> 1700
    //   904: iload_3
    //   905: bipush 8
    //   907: if_icmpne +793 -> 1700
    //   910: aload_0
    //   911: getfield 2607	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_r_of_type_Boolean	Z
    //   914: ifne +786 -> 1700
    //   917: aload_0
    //   918: iconst_1
    //   919: putfield 2607	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_r_of_type_Boolean	Z
    //   922: aload_1
    //   923: getfield 2610	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   926: ldc2_w 2611
    //   929: land
    //   930: lconst_0
    //   931: lcmp
    //   932: ifeq +714 -> 1646
    //   935: iconst_1
    //   936: istore 8
    //   938: aload_0
    //   939: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   942: bipush 50
    //   944: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   947: checkcast 375	com/tencent/mobileqq/app/FriendsManager
    //   950: aload_1
    //   951: getfield 478	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   954: invokevirtual 2614	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   957: istore 10
    //   959: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   962: ifeq +71 -> 1033
    //   965: ldc_w 520
    //   968: iconst_2
    //   969: new 418	java/lang/StringBuilder
    //   972: dup
    //   973: invokespecial 419	java/lang/StringBuilder:<init>	()V
    //   976: ldc_w 2616
    //   979: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: iload 8
    //   984: invokevirtual 2475	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   987: ldc_w 2618
    //   990: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: iload 10
    //   995: invokevirtual 2475	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   998: ldc_w 2620
    //   1001: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: aload_1
    //   1005: getfield 478	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   1008: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: ldc_w 2622
    //   1014: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: aload_0
    //   1018: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1021: invokevirtual 1607	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1024: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1033: iload 8
    //   1035: iload 10
    //   1037: if_icmpeq +663 -> 1700
    //   1040: ldc_w 520
    //   1043: iconst_1
    //   1044: new 418	java/lang/StringBuilder
    //   1047: dup
    //   1048: invokespecial 419	java/lang/StringBuilder:<init>	()V
    //   1051: ldc_w 2624
    //   1054: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: iload 8
    //   1059: invokevirtual 2475	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1062: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1065: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1068: aload_0
    //   1069: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1072: iconst_1
    //   1073: invokevirtual 487	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1076: checkcast 2626	com/tencent/mobileqq/app/FriendListHandler
    //   1079: aload_1
    //   1080: getfield 478	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   1083: invokevirtual 2627	com/tencent/mobileqq/app/FriendListHandler:a	(Ljava/lang/String;)V
    //   1086: goto +614 -> 1700
    //   1089: aload_0
    //   1090: getfield 806	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   1093: iconst_5
    //   1094: iload 6
    //   1096: iload_3
    //   1097: aload_1
    //   1098: invokevirtual 2630	com/tencent/util/WeakReferenceHandler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   1101: astore 18
    //   1103: iload 9
    //   1105: ifeq +553 -> 1658
    //   1108: iload 5
    //   1110: ifeq +548 -> 1658
    //   1113: aload 18
    //   1115: bipush 12
    //   1117: putfield 2633	android/os/Message:arg2	I
    //   1120: aload 18
    //   1122: invokevirtual 2636	android/os/Message:sendToTarget	()V
    //   1125: iload 4
    //   1127: ifeq +19 -> 1146
    //   1130: aload_0
    //   1131: getfield 806	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   1134: iconst_5
    //   1135: iload 6
    //   1137: bipush 17
    //   1139: aload_1
    //   1140: invokevirtual 2630	com/tencent/util/WeakReferenceHandler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   1143: invokevirtual 2636	android/os/Message:sendToTarget	()V
    //   1146: aload 19
    //   1148: ifnull -482 -> 666
    //   1151: aload 19
    //   1153: invokevirtual 1804	com/tencent/util/ProfilePerformanceReport:a	()Z
    //   1156: ifeq -490 -> 666
    //   1159: aload 19
    //   1161: bipush 7
    //   1163: invokevirtual 2638	com/tencent/util/ProfilePerformanceReport:b	(I)V
    //   1166: goto -500 -> 666
    //   1169: astore_1
    //   1170: aload_0
    //   1171: monitorexit
    //   1172: aload_1
    //   1173: athrow
    //   1174: aload_0
    //   1175: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1178: invokestatic 2641	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1181: istore 10
    //   1183: lload 16
    //   1185: ldc2_w 2642
    //   1188: lcmp
    //   1189: ifeq +12 -> 1201
    //   1192: lload 16
    //   1194: ldc2_w 2644
    //   1197: lcmp
    //   1198: ifne +266 -> 1464
    //   1201: aload_0
    //   1202: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1205: invokevirtual 1041	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1208: aload 18
    //   1210: invokestatic 2648	com/tencent/mobileqq/util/ProfileCardUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   1213: istore 9
    //   1215: aload_0
    //   1216: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1219: invokevirtual 1041	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1222: lload 16
    //   1224: ldc_w 2650
    //   1227: invokestatic 2655	com/tencent/mobileqq/profile/ProfileCardManager:a	(Landroid/content/Context;JLjava/lang/String;)Z
    //   1230: istore 11
    //   1232: iload 10
    //   1234: ifeq +381 -> 1615
    //   1237: iload 9
    //   1239: ifeq +376 -> 1615
    //   1242: aload_0
    //   1243: getfield 2108	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   1246: ldc_w 2657
    //   1249: iconst_1
    //   1250: invokevirtual 2115	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Z)V
    //   1253: aload 22
    //   1255: aload_0
    //   1256: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1259: lload 14
    //   1261: lload 12
    //   1263: invokevirtual 2660	com/tencent/mobileqq/profile/ProfileCardTemplate:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)Z
    //   1266: istore 9
    //   1268: aload_0
    //   1269: getfield 2108	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   1272: ldc_w 2662
    //   1275: ldc_w 2657
    //   1278: iconst_0
    //   1279: invokevirtual 2511	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1282: aload_0
    //   1283: getfield 2108	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   1286: ldc_w 2664
    //   1289: iconst_1
    //   1290: invokevirtual 2115	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Z)V
    //   1293: aload_0
    //   1294: lload 12
    //   1296: lload 16
    //   1298: aload 18
    //   1300: aload 20
    //   1302: aload 21
    //   1304: invokevirtual 2667	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   1307: istore 10
    //   1309: iload 10
    //   1311: iload 8
    //   1313: ior
    //   1314: istore 8
    //   1316: aload_0
    //   1317: getfield 2108	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   1320: ldc_w 2669
    //   1323: ldc_w 2664
    //   1326: iconst_0
    //   1327: invokevirtual 2511	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1330: iload 9
    //   1332: ifeq +161 -> 1493
    //   1335: aload_0
    //   1336: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1339: aload 22
    //   1341: putfield 2587	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   1344: iload 7
    //   1346: iconst_1
    //   1347: if_icmpne +179 -> 1526
    //   1350: iload 11
    //   1352: ifne +174 -> 1526
    //   1355: aload_0
    //   1356: invokevirtual 2671	com/tencent/mobileqq/activity/FriendProfileCardActivity:b	()Z
    //   1359: ifeq +29 -> 1388
    //   1362: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1365: ifeq +13 -> 1378
    //   1368: ldc_w 416
    //   1371: iconst_2
    //   1372: ldc_w 2673
    //   1375: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1378: aload_0
    //   1379: aload 18
    //   1381: lload 16
    //   1383: aload 22
    //   1385: invokevirtual 2676	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Ljava/lang/String;JLcom/tencent/mobileqq/profile/ProfileCardTemplate;)V
    //   1388: aload_1
    //   1389: getfield 1346	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   1392: getstatic 2677	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_j_of_type_Long	J
    //   1395: lcmp
    //   1396: ifeq +14 -> 1410
    //   1399: aload_1
    //   1400: getfield 1346	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   1403: getstatic 2678	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_i_of_type_Long	J
    //   1406: lcmp
    //   1407: ifne +54 -> 1461
    //   1410: aload_0
    //   1411: getfield 2680	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_i_of_type_Boolean	Z
    //   1414: ifne +47 -> 1461
    //   1417: aload 22
    //   1419: getfield 2682	com/tencent/mobileqq/profile/ProfileCardTemplate:l	J
    //   1422: invokestatic 2686	com/tencent/mobileqq/profile/VipWZRYTemplateHelper:a	(J)Z
    //   1425: ifeq +36 -> 1461
    //   1428: aload_0
    //   1429: ldc_w 2688
    //   1432: invokestatic 2689	com/tencent/mobileqq/profile/VipWZRYTemplateHelper:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   1435: ifne +26 -> 1461
    //   1438: aload_0
    //   1439: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1442: new 2691	stb
    //   1445: dup
    //   1446: aload_0
    //   1447: aload 22
    //   1449: aload_1
    //   1450: invokespecial 2694	stb:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;Lcom/tencent/mobileqq/profile/ProfileCardTemplate;Lcom/tencent/mobileqq/data/Card;)V
    //   1453: invokestatic 2697	com/tencent/mobileqq/profile/VipWZRYTemplateHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)V
    //   1456: aload_0
    //   1457: iconst_1
    //   1458: putfield 2680	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_i_of_type_Boolean	Z
    //   1461: goto -680 -> 781
    //   1464: new 2699	java/io/File
    //   1467: dup
    //   1468: aload_0
    //   1469: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1472: invokevirtual 1041	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1475: lload 12
    //   1477: lload 16
    //   1479: invokestatic 2702	com/tencent/mobileqq/profile/ProfileCardManager:a	(Landroid/content/Context;JJ)Ljava/lang/String;
    //   1482: invokespecial 2704	java/io/File:<init>	(Ljava/lang/String;)V
    //   1485: invokevirtual 2707	java/io/File:exists	()Z
    //   1488: istore 9
    //   1490: goto -275 -> 1215
    //   1493: aload_0
    //   1494: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1497: aconst_null
    //   1498: putfield 2587	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   1501: goto -157 -> 1344
    //   1504: astore 18
    //   1506: aload 18
    //   1508: invokevirtual 931	java/lang/Exception:printStackTrace	()V
    //   1511: aload_0
    //   1512: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1515: aconst_null
    //   1516: putfield 2587	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   1519: iload 8
    //   1521: istore 9
    //   1523: goto -738 -> 785
    //   1526: aload_1
    //   1527: getfield 1346	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   1530: getstatic 2677	com/tencent/mobileqq/profile/ProfileCardTemplate:jdField_j_of_type_Long	J
    //   1533: lcmp
    //   1534: ifne -146 -> 1388
    //   1537: aload_0
    //   1538: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1541: invokevirtual 1041	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1544: aload_1
    //   1545: getfield 2519	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   1548: ldc_w 2709
    //   1551: invokestatic 2655	com/tencent/mobileqq/profile/ProfileCardManager:a	(Landroid/content/Context;JLjava/lang/String;)Z
    //   1554: ifne -166 -> 1388
    //   1557: aload_0
    //   1558: invokevirtual 2671	com/tencent/mobileqq/activity/FriendProfileCardActivity:b	()Z
    //   1561: ifeq -173 -> 1388
    //   1564: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1567: ifeq +13 -> 1580
    //   1570: ldc_w 416
    //   1573: iconst_2
    //   1574: ldc_w 2711
    //   1577: invokestatic 438	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1580: aload_0
    //   1581: aload 18
    //   1583: lload 16
    //   1585: aload 22
    //   1587: invokevirtual 2676	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Ljava/lang/String;JLcom/tencent/mobileqq/profile/ProfileCardTemplate;)V
    //   1590: goto -202 -> 1388
    //   1593: astore 18
    //   1595: aload 18
    //   1597: invokevirtual 2712	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1600: aload_0
    //   1601: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1604: aconst_null
    //   1605: putfield 2587	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   1608: iload 8
    //   1610: istore 9
    //   1612: goto -827 -> 785
    //   1615: aload_0
    //   1616: invokevirtual 2671	com/tencent/mobileqq/activity/FriendProfileCardActivity:b	()Z
    //   1619: ifeq +16 -> 1635
    //   1622: aload_0
    //   1623: aload 18
    //   1625: lload 16
    //   1627: aload 22
    //   1629: invokevirtual 2676	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Ljava/lang/String;JLcom/tencent/mobileqq/profile/ProfileCardTemplate;)V
    //   1632: goto -966 -> 666
    //   1635: aload_0
    //   1636: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1639: aconst_null
    //   1640: putfield 2587	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate	Lcom/tencent/mobileqq/profile/ProfileCardTemplate;
    //   1643: goto -862 -> 781
    //   1646: iconst_0
    //   1647: istore 8
    //   1649: goto -711 -> 938
    //   1652: iconst_0
    //   1653: istore 6
    //   1655: goto -566 -> 1089
    //   1658: iload 9
    //   1660: ifeq -540 -> 1120
    //   1663: aload 18
    //   1665: bipush 11
    //   1667: putfield 2633	android/os/Message:arg2	I
    //   1670: goto -550 -> 1120
    //   1673: astore 18
    //   1675: goto -80 -> 1595
    //   1678: iconst_0
    //   1679: istore 4
    //   1681: iload 9
    //   1683: istore 8
    //   1685: goto -1277 -> 408
    //   1688: iconst_1
    //   1689: istore 8
    //   1691: goto -1352 -> 339
    //   1694: iconst_1
    //   1695: istore 8
    //   1697: goto -1264 -> 433
    //   1700: iload_2
    //   1701: ifeq -49 -> 1652
    //   1704: iconst_1
    //   1705: istore 6
    //   1707: goto -618 -> 1089
    //   1710: astore 18
    //   1712: goto -206 -> 1506
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1715	0	this	FriendProfileCardActivity
    //   0	1715	1	paramCard	Card
    //   0	1715	2	paramBoolean	boolean
    //   0	1715	3	paramInt	int
    //   202	1478	4	i1	int
    //   206	903	5	i2	int
    //   199	1507	6	i3	int
    //   630	718	7	i4	int
    //   196	1500	8	bool1	boolean
    //   210	1472	9	bool2	boolean
    //   193	1121	10	bool3	boolean
    //   1230	121	11	bool4	boolean
    //   600	876	12	l1	long
    //   618	642	14	l2	long
    //   642	984	16	l3	long
    //   612	768	18	localObject	Object
    //   1504	78	18	localException1	Exception
    //   1593	71	18	localOutOfMemoryError1	OutOfMemoryError
    //   1673	1	18	localOutOfMemoryError2	OutOfMemoryError
    //   1710	1	18	localException2	Exception
    //   87	1073	19	localProfilePerformanceReport	ProfilePerformanceReport
    //   624	677	20	str1	String
    //   636	667	21	str2	String
    //   732	896	22	localProfileCardTemplate	ProfileCardTemplate
    // Exception table:
    //   from	to	target	type
    //   17	84	1169	finally
    //   84	89	1169	finally
    //   94	109	1169	finally
    //   109	178	1169	finally
    //   178	192	1169	finally
    //   226	294	1169	finally
    //   294	310	1169	finally
    //   310	336	1169	finally
    //   339	351	1169	finally
    //   362	379	1169	finally
    //   387	397	1169	finally
    //   414	430	1169	finally
    //   433	520	1169	finally
    //   520	535	1169	finally
    //   549	596	1169	finally
    //   596	644	1169	finally
    //   651	657	1169	finally
    //   669	705	1169	finally
    //   711	748	1169	finally
    //   760	768	1169	finally
    //   773	781	1169	finally
    //   790	891	1169	finally
    //   891	904	1169	finally
    //   910	935	1169	finally
    //   938	1033	1169	finally
    //   1040	1086	1169	finally
    //   1089	1103	1169	finally
    //   1113	1120	1169	finally
    //   1120	1125	1169	finally
    //   1130	1146	1169	finally
    //   1151	1166	1169	finally
    //   1174	1183	1169	finally
    //   1201	1215	1169	finally
    //   1215	1232	1169	finally
    //   1242	1309	1169	finally
    //   1316	1330	1169	finally
    //   1335	1344	1169	finally
    //   1355	1378	1169	finally
    //   1378	1388	1169	finally
    //   1388	1410	1169	finally
    //   1410	1461	1169	finally
    //   1464	1490	1169	finally
    //   1493	1501	1169	finally
    //   1506	1519	1169	finally
    //   1526	1580	1169	finally
    //   1580	1590	1169	finally
    //   1595	1608	1169	finally
    //   1615	1632	1169	finally
    //   1635	1643	1169	finally
    //   1663	1670	1169	finally
    //   1316	1330	1504	java/lang/Exception
    //   1335	1344	1504	java/lang/Exception
    //   1355	1378	1504	java/lang/Exception
    //   1378	1388	1504	java/lang/Exception
    //   1388	1410	1504	java/lang/Exception
    //   1410	1461	1504	java/lang/Exception
    //   1493	1501	1504	java/lang/Exception
    //   1526	1580	1504	java/lang/Exception
    //   1580	1590	1504	java/lang/Exception
    //   1316	1330	1593	java/lang/OutOfMemoryError
    //   1335	1344	1593	java/lang/OutOfMemoryError
    //   1355	1378	1593	java/lang/OutOfMemoryError
    //   1378	1388	1593	java/lang/OutOfMemoryError
    //   1388	1410	1593	java/lang/OutOfMemoryError
    //   1410	1461	1593	java/lang/OutOfMemoryError
    //   1493	1501	1593	java/lang/OutOfMemoryError
    //   1526	1580	1593	java/lang/OutOfMemoryError
    //   1580	1590	1593	java/lang/OutOfMemoryError
    //   596	644	1673	java/lang/OutOfMemoryError
    //   651	657	1673	java/lang/OutOfMemoryError
    //   711	748	1673	java/lang/OutOfMemoryError
    //   760	768	1673	java/lang/OutOfMemoryError
    //   773	781	1673	java/lang/OutOfMemoryError
    //   1174	1183	1673	java/lang/OutOfMemoryError
    //   1201	1215	1673	java/lang/OutOfMemoryError
    //   1215	1232	1673	java/lang/OutOfMemoryError
    //   1242	1309	1673	java/lang/OutOfMemoryError
    //   1464	1490	1673	java/lang/OutOfMemoryError
    //   1615	1632	1673	java/lang/OutOfMemoryError
    //   1635	1643	1673	java/lang/OutOfMemoryError
    //   596	644	1710	java/lang/Exception
    //   651	657	1710	java/lang/Exception
    //   711	748	1710	java/lang/Exception
    //   760	768	1710	java/lang/Exception
    //   773	781	1710	java/lang/Exception
    //   1174	1183	1710	java/lang/Exception
    //   1201	1215	1710	java/lang/Exception
    //   1215	1232	1710	java/lang/Exception
    //   1242	1309	1710	java/lang/Exception
    //   1464	1490	1710	java/lang/Exception
    //   1615	1632	1710	java/lang/Exception
    //   1635	1643	1710	java/lang/Exception
  }
  
  public void a(ContactCard paramContactCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo ContactCard card = " + paramContactCard + ", isNetRet = " + String.valueOf(paramBoolean));
    }
    c(null);
    if (a(paramContactCard, paramBoolean)) {
      b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(null, paramBoolean);
    a(paramBoolean);
    n();
  }
  
  public void a(ShowExternalTroop paramShowExternalTroop)
  {
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)))
    {
      i1 = 1;
      if ((paramShowExternalTroop != null) && (i1 != 0)) {
        break label33;
      }
    }
    label33:
    do
    {
      return;
      i1 = 0;
      break;
      this.jdField_i_of_type_JavaLangString = paramShowExternalTroop.troopUin;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = new ProfileBusiEntry();
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_Int = 1024;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_b_of_type_JavaLangString = getString(2131430397);
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.c = paramShowExternalTroop.troopName;
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_JavaLangString = paramShowExternalTroop.strFaceUrl;
    } while (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.addOrUpdateBuisEntry(this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
    w();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_i_of_type_JavaLangString, "1", "", "");
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.jdField_i_of_type_JavaLangString, "0", "", "");
  }
  
  public void a(OnGetPersonalityLabelsListener paramOnGetPersonalityLabelsListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelOnGetPersonalityLabelsListener = paramOnGetPersonalityLabelsListener;
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    long l1;
    label188:
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initHeaderViewStart", true);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, String.format("initHeaderView isHeaderViewInited=%s", new Object[] { Boolean.valueOf(this.jdField_c_of_type_Boolean) }));
      }
      if (this.jdField_c_of_type_Boolean != true)
      {
        boolean bool = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0");
        if (!bool) {}
      }
      else
      {
        return;
      }
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
        ((CardHandler)this.app.a(2)).a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      }
      Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
      if (localCard == null) {
        break label609;
      }
    }
    finally {}
    try
    {
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) || (paramProfileCardInfo.jdField_b_of_type_Boolean)) {
        break label393;
      }
      l1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
      if ((l1 != ProfileCardTemplate.jdField_b_of_type_Long) && (l1 != ProfileCardTemplate.jdField_c_of_type_Long) && (l1 != ProfileCardTemplate.jdField_d_of_type_Long)) {
        break label343;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileGameView(this, paramProfileCardInfo);
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label388;
      }
      QLog.d("FriendProfileCardActivity", 2, localException.toString());
      localException.printStackTrace();
      i1 = 0;
      break label265;
      if (l1 != ProfileCardTemplate.jdField_f_of_type_Long) {
        break label423;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileTagView(this, paramProfileCardInfo);
      break label188;
      if (l1 != ProfileCardTemplate.jdField_g_of_type_Long) {
        break label448;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new VipProfileSimpleView(this, paramProfileCardInfo);
      break label188;
      if (l1 != ProfileCardTemplate.jdField_h_of_type_Long) {
        break label534;
      }
      if (!getSharedPreferences("is_binding_shop", 1).getBoolean(this.jdField_e_of_type_JavaLangString, true)) {
        break label493;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileShoppingView(this, paramProfileCardInfo);
      break label188;
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_q_of_type_Boolean);
      break label188;
      if ((l1 != ProfileCardTemplate.jdField_j_of_type_Long) && (l1 != ProfileCardTemplate.jdField_i_of_type_Long)) {
        break label568;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new VipProfileWZRYView(this, paramProfileCardInfo);
      break label188;
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_q_of_type_Boolean);
      break label188;
    }
    this.jdField_f_of_type_Long = l1;
    this.jdField_a_of_type_JavaUtilArrayList = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
    a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundColor, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strExtInfo);
    z();
    if (!getIntent().getBooleanExtra("diyTextEditResult", false)) {
      A();
    }
    int i1 = 1;
    label265:
    if (i1 == 0)
    {
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_q_of_type_Boolean);
      a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
      z();
    }
    label343:
    label609:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initHeaderViewEnd", "initHeaderViewStart", false);
      break;
      if (l1 == ProfileCardTemplate.jdField_e_of_type_Long)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfilePhotoView(this, paramProfileCardInfo);
        break label188;
      }
      label493:
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "create headerView by contactCard");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_q_of_type_Boolean);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
        z();
      }
      else if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo != null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "create headerView by qCallCardInfo");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this, paramProfileCardInfo, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_q_of_type_Boolean);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
        z();
      }
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0);
    if (((localObject instanceof ProfileHeaderView)) && (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView headerView update");
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView mCurrentHeaderStyle=" + this.jdField_f_of_type_Long);
      }
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != this.jdField_f_of_type_Long))
      {
        this.jdField_c_of_type_Boolean = false;
        a(paramProfileCardInfo);
      }
    }
    for (;;)
    {
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
      {
        paramProfileCardInfo = (MusicPendantView)findViewById(2131371204);
        if (paramProfileCardInfo != null) {
          MusicPendantManager.a().b(paramProfileCardInfo.a);
        }
      }
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.requestLayout();
      return;
      ((ProfileHeaderView)localObject).a(paramProfileCardInfo, paramBoolean);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView headerView is loading");
      }
      a(paramProfileCardInfo);
      if (((localObject instanceof ProfileHeaderView)) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53))
      {
        localObject = (ProfileHeaderView)localObject;
        ((ProfileHeaderView)localObject).c(paramProfileCardInfo);
        ((ProfileHeaderView)localObject).a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      }
    }
  }
  
  public void a(QCallCardInfo paramQCallCardInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo QCallCardInfo card = " + paramQCallCardInfo + ", isNetRet = " + String.valueOf(paramBoolean));
    }
    if (a(paramQCallCardInfo, paramBoolean)) {
      b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(null, paramBoolean);
    a(paramBoolean);
    n();
  }
  
  public void a(OnGetPhotoWallListener paramOnGetPhotoWallListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOnGetPhotoWallListener = paramOnGetPhotoWallListener;
  }
  
  public void a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (ProfileActivity.a(this.jdField_h_of_type_Long, l1))
    {
      this.jdField_h_of_type_Long = l1;
      String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        str = a();
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = String.format("http://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { str });
      }
      paramString = new Intent(this, MusicGeneQQBrowserActivity.class);
      paramString.putExtra("uin", this.app.getCurrentAccountUin());
      paramString.putExtra("url", (String)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label266;
      }
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    }
    for (;;)
    {
      localObject = Calendar.getInstance();
      if ((localObject != null) && (QLog.isColorLevel()))
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject).getTime());
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, "musicgene123 startactivity " + (String)localObject);
        }
      }
      startActivity(paramString);
      ReportController.b(this.app, "CliOper", "", "", "0X8004182 ", "0X8004182", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      label266:
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  void a(String paramString, long paramLong, ProfileCardTemplate paramProfileCardTemplate)
  {
    if ((paramLong != 160L) && (paramLong != 1600L)) {
      ((VasExtensionManager)this.app.getManager(234)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager.a(this.app, "card." + paramLong);
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      ThreadManager.post(new swf(this, paramProfileCardTemplate, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, paramString, paramLong), 5, null, true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update buttons");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      b(1);
    }
    label282:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)
      {
        b(9);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.bindQQ) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)) {
          if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, this.app.getCurrentAccountUin()))
          {
            b(0);
            this.jdField_p_of_type_Int = 0;
          }
        }
      }
      for (;;)
      {
        if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 105)) {
          break label282;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800716B", "0X800716B", this.jdField_p_of_type_Int, 0, "", "", "", "");
        return;
        b(4);
        break;
        if (((PhoneContactManager)this.app.getManager(10)).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo) != null)
        {
          this.jdField_p_of_type_Int = 1;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) {}
          for (int i1 = 12;; i1 = 2)
          {
            b(i1);
            break;
          }
        }
        this.jdField_p_of_type_Int = 2;
        b(11);
        continue;
        this.jdField_p_of_type_Int = 3;
        b(10);
      }
    }
    boolean bool4 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    paramBoolean = ProfileActivity.AllInOne.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool1 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 113)
    {
      bool1 = false;
      paramBoolean = false;
    }
    boolean bool3 = paramBoolean;
    boolean bool2 = bool4;
    if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (!this.jdField_q_of_type_Boolean) {
        break label503;
      }
      bool1 = false;
      bool3 = false;
    }
    for (bool2 = false;; bool2 = bool4)
    {
      if ((bool3) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean))
      {
        b(12);
        return;
      }
      if ((bool2) && (bool3) && (bool1))
      {
        b(2);
        return;
      }
      if ((bool2) && (bool3))
      {
        b(3);
        return;
      }
      if ((bool3) && (bool1))
      {
        b(4);
        return;
      }
      if ((bool2) && (bool1))
      {
        b(5);
        return;
      }
      if (bool2)
      {
        b(6);
        return;
      }
      if (bool3)
      {
        b(7);
        return;
      }
      if (bool1)
      {
        b(5);
        return;
      }
      b(0);
      return;
      label503:
      bool1 = false;
      bool3 = paramBoolean;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      String str1 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str1 = "http://gamecenter.qq.com/gamecenter/index/recent_play.html";
      }
      Intent localIntent = new Intent(this, GameCenterActivity.class);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      paramString = str2;
      if (TextUtils.isEmpty(str2)) {
        paramString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_JavaLangString;
      }
      localIntent.putExtra("url", HtmlOffline.a(str1, "plat=qq&tt=1&_wv=3&qappid=" + AppSetting.jdField_a_of_type_Int + "&osv=" + Build.VERSION.RELEASE + "&vuin=" + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString + "&vname=" + paramString + "&bn=" + paramBoolean));
      startActivity(localIntent);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    I();
    a("已上传", 2);
    if (paramArrayOfByte != null)
    {
      Object localObject = ByteBuffer.wrap(paramArrayOfByte);
      int i2 = ((ByteBuffer)localObject).get();
      if (i2 != 0) {
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "error retCode:" + i2);
        }
      }
      do
      {
        return;
        byte[] arrayOfByte1 = new byte[4];
        byte[] arrayOfByte2 = new byte[4];
        i2 = 0;
        while (i2 < 4)
        {
          int i1 = ((ByteBuffer)localObject).get();
          arrayOfByte1[i2] = i1;
          arrayOfByte2[(3 - i2)] = i1;
          i2 += 1;
        }
        i3 = (int)HummerParser.a(arrayOfByte1);
        if (i3 <= paramArrayOfByte.length - 5)
        {
          i2 = i3;
          if (i3 >= 0) {}
        }
        else
        {
          i2 = (int)HummerParser.a(arrayOfByte2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "len:" + i2 + " bLength:" + HexUtil.a(arrayOfByte1) + " bFlipLength:" + HexUtil.a(arrayOfByte2));
        }
        if ((i2 <= paramArrayOfByte.length - 5) && (i2 >= 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("FriendProfileCardActivity", 2, "长度超出! len:" + i2 + " extraInfo.length:" + paramArrayOfByte.length);
      return;
      localObject = new byte[i2];
      int i3 = 0;
      while (i3 < i2)
      {
        localObject[i3] = paramArrayOfByte[(i3 + 5)];
        i3 += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.checkCoverUrl((byte[])localObject)) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.vCoverInfo = ((byte[])localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) {
        ((ProfileBaseView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, false);
      }
      ThreadManager.post(new suf(this), 5, null, false);
    }
    for (;;)
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8007EC2", "0X8007EC2", 0, 0, "", "", "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "send finish extraInfo is null");
      }
      a(0L, null, null, false);
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
      this.jdField_a_of_type_ArrayOfJavaLangString = getResources().getStringArray(2131296278);
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    int i1 = 0;
    if (i1 < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i1] == 16) {
        localActionSheet.d(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[i1]]);
      }
      for (;;)
      {
        if (paramArrayOfInt[i1] == 20) {
          localActionSheet.a(2131437187);
        }
        i1 += 1;
        break;
        if (paramArrayOfInt[i1] == 19)
        {
          localActionSheet.a(2131438365);
          if ((this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_call_time > 0))
          {
            this.jdField_l_of_type_Int = 1;
            localActionSheet.a(getResources().getString(2131438363), getResources().getDrawable(2130840374), 0);
            ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 1, 0, "", "", "", "");
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.b() == 1) && (this.jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo.pstn_c2c_try_status == 0))
          {
            this.jdField_l_of_type_Int = 2;
            localActionSheet.a(getResources().getString(2131438363), getResources().getDrawable(2130840373), 0);
            ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 3, 0, "", "", "", "");
          }
          else
          {
            this.jdField_l_of_type_Int = 5;
            localActionSheet.a(getResources().getString(2131438363), getResources().getDrawable(2130840372), 0);
            ReportController.b(this.app, "CliOper", "", "", "0X80063FD", "0X80063FD", 2, 0, "", "", "", "");
          }
        }
        else if ((paramArrayOfInt[i1] >= 0) && (paramArrayOfInt[i1] < this.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          localActionSheet.a(this.jdField_a_of_type_ArrayOfJavaLangString[paramArrayOfInt[i1]], 1);
        }
      }
    }
    localActionSheet.a(new stz(this, localActionSheet));
    try
    {
      if (!isFinishing()) {
        localActionSheet.show();
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
  
  public boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    Card localCard = localFriendsManager.a(this.app.getCurrentAccountUin());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localFriendsManager.a(localCard))
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
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.jdField_j_of_type_Long))
      {
        return a(paramLong2, paramString1, paramString3);
        paramString1 = ProfileCardUtil.a(this, paramString1);
        if (TextUtils.isEmpty(paramString2)) {}
        for (paramString2 = "";; paramString2 = ProfileCardManager.a(this, paramLong2) + ".dynamic")
        {
          paramString3 = new File(paramString1);
          if ((!paramString3.isFile()) || (!paramString3.exists())) {
            break label476;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "background file exists, fileName = " + paramString1);
          }
          paramString3 = (Boolean)ProfileCardManager.b.get(Long.valueOf(paramLong2));
          if ((paramString3 != null) && (paramString3.booleanValue()))
          {
            paramString3 = "profilecard:" + paramString1;
            BaseApplicationImpl.sImageCache.remove(paramString3);
            ProfileCardManager.b.remove(Long.valueOf(paramLong2));
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground update card and remove old cache bgid=" + paramLong2);
            }
          }
          paramString1 = ProfileCardUtil.a(getResources(), paramString2, paramString1);
          paramString2 = paramString1.a();
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            break label424;
          }
          paramString3 = ((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a();
          if ((paramString3 == null) || (paramString3 != paramString2)) {
            break label393;
          }
          if (!QLog.isColorLevel()) {
            break label544;
          }
          QLog.i("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground: newBitmap == currentBitmap");
          break label544;
          paramString1 = ProfileCardManager.a(this, paramLong1, paramLong2);
          break;
        }
        label393:
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "initProfileCardBackground recycle bg");
        }
        this.jdField_a_of_type_JavaUtilVector.add((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        label424:
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString1;
        return true;
      }
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
        label476:
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
    label544:
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
      paramString1 = ProfileCardManager.a(this, paramLong);
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
        paramString1 = BitmapManager.a(str2);
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
        paramString1 = BitmapManager.a(str1);
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
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0], paramCard.strNick))
      {
        bool2 = true;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = paramCard.strNick;
      }
    }
    for (;;)
    {
      boolean bool1;
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramCard.strReMark)) {}
      }
      else
      {
        if ((!bool2) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4], paramCard.strReMark))) {
          break label621;
        }
        bool1 = true;
        label114:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4] = paramCard.strReMark;
      }
      if (!paramBoolean)
      {
        bool2 = bool1;
        if (TextUtils.isEmpty(paramCard.strAutoRemark)) {}
      }
      else
      {
        if ((!bool1) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6], paramCard.strAutoRemark))) {
          break label626;
        }
        bool2 = true;
        label171:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6] = paramCard.strAutoRemark;
      }
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramCard.strTroopNick)) {}
      }
      else
      {
        if ((!bool2) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1], paramCard.strTroopNick))) {
          break label632;
        }
        bool1 = true;
        label228:
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1] = paramCard.strTroopNick;
      }
      paramBoolean = bool1;
      if (!TextUtils.isEmpty(paramCard.strContactName))
      {
        if ((bool1) || (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3], paramCard.strContactName)))
        {
          paramBoolean = true;
          label278:
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3] = paramCard.strContactName;
        }
      }
      else
      {
        if (!ProfileActivity.AllInOne.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break label647;
        }
        bool1 = paramBoolean;
        if (!TextUtils.isEmpty(paramCard.strCampusName))
        {
          if ((!paramBoolean) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2], paramCard.strCampusName))) {
            break label642;
          }
          bool1 = true;
          label341:
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2] = paramCard.strCampusName;
        }
        bool2 = bool1;
        if (QLog.isDevelopLevel())
        {
          QLog.i("FriendProfileCardActivity", 4, String.format(Locale.getDefault(), "updateNameList uin: %s name: %s", new Object[] { Utils.b(paramCard.uin), Utils.b(paramCard.strCampusName) }));
          bool2 = bool1;
        }
      }
      label621:
      label626:
      label632:
      do
      {
        if (QLog.isColorLevel())
        {
          paramCard = new StringBuilder();
          paramCard.append("updateNameList()").append(", bRet = ").append(bool2).append(", strNick = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0])).append(", strRemark = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4])).append(", strContactName = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3])).append(", strCircleName = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2])).append(", strRecommenName = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5])).append(", strTroopNickName = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1])).append(", strAutoRemark = ");
          paramCard.append(Utils.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[6]));
          QLog.d("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
        }
        return bool2;
        bool2 = false;
        break;
        bool1 = false;
        break label114;
        bool2 = false;
        break label171;
        bool1 = false;
        break label228;
        paramBoolean = false;
        break label278;
        bool1 = false;
        break label341;
        bool2 = paramBoolean;
      } while (TextUtils.isEmpty(paramCard.strAutoRemark));
      label642:
      label647:
      if ((paramBoolean) || (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2], paramCard.strAutoRemark))) {}
      for (bool2 = true;; bool2 = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2] = paramCard.strAutoRemark;
        break;
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
      if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0], paramContactCard.nickName))
      {
        paramBoolean = true;
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = paramContactCard.nickName;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContactCard.strContactName))
      {
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3], paramContactCard.strContactName)) {}
        }
        else
        {
          paramBoolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3] = paramContactCard.strContactName;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {
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
  
  boolean a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "checkParamValidate() cardInfo.allinone = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    }
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) {}
    while (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {}
    try
    {
      UinUtils.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 55)) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int + ", entry = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int);
        }
      }
      for (;;)
      {
        return a();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "通讯录陌生人： cardInfo.allinone.uin = " + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
        paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_Int = 0;
      }
      return false;
    }
    catch (NumberFormatException paramProfileCardInfo) {}
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
    if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo.nickname, paramQCallCardInfo.nickname)) {
      paramBoolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo.nickname = paramQCallCardInfo.nickname;
    return paramBoolean;
  }
  
  public String b()
  {
    if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
      return this.jdField_j_of_type_JavaLangString;
    }
    ThreadManager.post(new svi(this), 8, null, true);
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
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
  }
  
  void b(int paramInt)
  {
    int i1 = 1;
    Object localObject;
    int i2;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString)))
    {
      localObject = ((TroopManager)this.app.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString);
      if ((((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        i1 = 1;
        i2 = 1;
      }
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        paramInt = 0;
      }
      for (;;)
      {
        label158:
        localObject = findViewById(2131370271);
        if (paramInt != 0)
        {
          i1 = 0;
          label173:
          ((View)localObject).setVisibility(i1);
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if (paramInt == 0) {
            break label3175;
          }
        }
        label2871:
        label3145:
        label3175:
        for (paramInt = 0;; paramInt = 8)
        {
          ((LinearLayout)localObject).setVisibility(paramInt);
          return;
          i1 = 0;
          i2 = 0;
          break;
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
          {
            if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
              this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
            }
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 81, 2131435779, 2, 2131427390);
            paramInt = i1;
            break label158;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 23, 2131436735, 0, 2131427433);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 81, 2131435779, 2, 2131427390);
          paramInt = i1;
          break label158;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131435778, 0, 2131427384);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, 2131435812, 1, 2131427389);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131433661, 2, 2131427385);
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
            break label3181;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131435778, 0, 2131427384);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, 2131435812, 1, 2131427389);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3), 8, 2131433661, 0, 2131427385);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131433662, 2, 2131427386);
          paramInt = i1;
          break label158;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131435778, 0, 2131427384);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131433661, 2, 2131427385);
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
            break label3181;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131435778, 0, 2131427384);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3), 8, 2131433661, 0, 2131427385);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131433662, 2, 2131427386);
          paramInt = i1;
          break label158;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131435812, 0, 2131427389);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131433661, 2, 2131427385);
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
            break label3181;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131435812, 0, 2131427389);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3), 8, 2131433661, 0, 2131427385);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131433662, 2, 2131427386);
          paramInt = i1;
          break label158;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131435778, 0, 2131427384);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, 2131435812, 1, 2131427389);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
            break label3181;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131435778, 0, 2131427384);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, 2131435812, 1, 2131427389);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131433662, 2, 2131427386);
          paramInt = i1;
          break label158;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131435778, 0, 2131427384);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
            break label3181;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131435778, 0, 2131427384);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131433662, 2, 2131427386);
          paramInt = i1;
          break label158;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131433661, 2, 2131427385);
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
            break label3181;
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3), 8, 2131433661, 0, 2131427385);
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131433662, 2, 2131427386);
          paramInt = i1;
          break label158;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131435812, 0, 2131427389);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
            break label3181;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131435812, 0, 2131427389);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131433662, 2, 2131427386);
          paramInt = i1;
          break label158;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131435812, 0, 2131427389);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
            break label3181;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 20, 2131435812, 0, 2131427389);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) == null)) {
            break label3181;
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
          paramInt = i1;
          break label158;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 59, 2131435832, 0, 2131435832);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
          }
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
            break label3181;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3), 41, 2131433662, 3, 2131427386);
          paramInt = i1;
          break label158;
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 59, 2131435832, 0, 2131435832);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 7, 2131435778, 2, 2131427384);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
            break label3181;
          }
          a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3), 41, 2131433662, 3, 2131427386);
          paramInt = i1;
          break label158;
          if (ProfileActivity.AllInOne.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
          {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131435778, 0, 2131427384);
            if ((i2 == 0) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1) == null)) {
              break label3145;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1).setVisibility(8);
          }
          for (;;)
          {
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2), 8, 2131433661, 2, 2131427385);
            if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3) != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4) != null))
            {
              this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3).setVisibility(8);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4).setVisibility(8);
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long) || (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileShoppingView))) {
              break label3181;
            }
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0), 7, 2131435778, 0, 2131427384);
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 20, 2131435812, 1, 2131427389);
            if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2) != null) {
              this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(2).setVisibility(8);
            }
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(3), 8, 2131433661, 0, 2131427385);
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(4), 41, 2131433662, 2, 2131427386);
            paramInt = i1;
            break;
            if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0) == null) {
              break label2871;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).setVisibility(8);
            break label2871;
            a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(1), 77, 2131437738, 1, 2131437738);
          }
          i1 = 8;
          break label173;
        }
        label3181:
        paramInt = i1;
      }
      i2 = 0;
    }
  }
  
  public void b(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.c;
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
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "send_sms", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label128:
      a(2131435781, 1);
    }
  }
  
  @SuppressLint({"ServiceCast", "NewApi"})
  public void b(String paramString)
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
  
  void b(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
        }
      }
    }
    if ((paramBoolean == true) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a(this.app, "friendcard", (String)localObject2, -1);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_g_of_type_Int > 3) {
      return false;
    }
    this.jdField_g_of_type_Int += 1;
    return true;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(103);
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_j_of_type_Boolean) && (!this.s) && (!this.t))
    {
      this.t = true;
      int i1 = paramInt;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof VipProfileSimpleView))
      {
        ((VipProfileSimpleView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).d();
        i1 = paramInt + getResources().getDisplayMetrics().heightPixels / 2;
      }
      d(i1);
    }
  }
  
  public void c(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo == null)
    {
      paramCardContactInfo = null;
      if ((paramCardContactInfo != null) && (paramCardContactInfo.length() > 0))
      {
        if (!NetworkUtil.d(BaseApplication.getContext())) {
          break label183;
        }
        if (("".equals(paramCardContactInfo)) || (paramCardContactInfo.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString))) {
          break label172;
        }
        FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
        if (localFriendListHandler == null) {
          break label161;
        }
        localFriendListHandler.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramCardContactInfo, false);
        this.jdField_e_of_type_Int |= 0x1;
        d(paramCardContactInfo);
      }
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "P_prof", "Edit_name", a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int), 0, Integer.toString(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      paramCardContactInfo = paramCardContactInfo.jdField_a_of_type_JavaLangString;
      break;
      label161:
      a(2131435797, 1);
      continue;
      label172:
      a(2131435796, 1);
      continue;
      label183:
      a(2131434628, 1);
    }
  }
  
  public void c(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.app, paramProfileCardInfo.jdField_d_of_type_JavaLangString))) {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView.setVisibility(4);
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView == null) || (paramProfileCardInfo == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView.setActivity(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
  }
  
  public void c(String paramString)
  {
    int i3 = 44;
    int i4 = 1;
    label49:
    int i1;
    int i2;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131435731);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int != 6) {
        break label281;
      }
      y();
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new suc(this));
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label309;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) {
        break label298;
      }
      i3 = 16;
      i1 = 1;
      i2 = 0;
    }
    for (;;)
    {
      label95:
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) {
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a()) && (i1 != 0)) {
          i1 = i4;
        }
      }
      for (;;)
      {
        label122:
        if (i1 != 0)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setTag(new DataTag(i3, null));
          this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(this.jdField_e_of_type_Boolean);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131436771);
        }
        for (;;)
        {
          if (i2 != 0)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setTag(new DataTag(i3, null));
            this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(this.jdField_e_of_type_Boolean);
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839170);
              this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("二维码");
              return;
              this.jdField_d_of_type_AndroidWidgetTextView.setText(2131435730);
              break;
              label281:
              this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131433712));
              break label49;
              label298:
              i3 = 65;
              i2 = 1;
              i1 = 0;
              break label95;
              label309:
              if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71))
              {
                i3 = 16;
                i1 = 1;
                i2 = 0;
                break label95;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 70)
              {
                i3 = 16;
                i1 = 1;
                i2 = 0;
                break label95;
              }
              if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
              {
                if (this.jdField_q_of_type_Boolean)
                {
                  i3 = 16;
                  i1 = 0;
                  i2 = 0;
                  break label95;
                }
                i3 = 16;
                i1 = 1;
                i2 = 0;
                break label95;
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22))
              {
                i3 = 16;
                i1 = 1;
                i2 = 0;
                break label95;
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47))
              {
                i3 = 16;
                i1 = 1;
                i2 = 0;
                break label95;
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 86))
              {
                i3 = 16;
                i1 = 1;
                i2 = 0;
                break label95;
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57))
              {
                i3 = 16;
                i1 = 1;
                i2 = 0;
                break label95;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 80)
              {
                i3 = 16;
                i1 = 0;
                i2 = 0;
                break label95;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36)
              {
                i3 = 16;
                i1 = 0;
                i2 = 0;
                break label95;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int != 0) {}
                for (i1 = 1;; i1 = 0)
                {
                  i3 = 16;
                  i2 = 0;
                  break;
                }
              }
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2)
              {
                i3 = 16;
                i1 = 1;
                i2 = 0;
                break label95;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74)
              {
                i3 = 16;
                i1 = 1;
                i2 = 0;
                break label95;
              }
              if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int))
              {
                i3 = 16;
                i1 = 1;
                i2 = 0;
                break label95;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 96)
              {
                i3 = 16;
                i1 = 1;
                i2 = 0;
                break label95;
              }
              if ((ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (!ProfileActivity.AllInOne.j(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
              {
                i3 = 16;
                i1 = 1;
                i2 = 0;
                break label95;
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
              {
                i2 = 1;
                i1 = 0;
                break label95;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
              {
                if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard == null) || (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, this.app.getCurrentAccountUin()))) {
                  break label1047;
                }
                i2 = 1;
                i1 = 0;
                break label95;
              }
              i3 = 16;
              i1 = 0;
              i2 = 0;
              break label95;
              i1 = 0;
              break label122;
              this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
              continue;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839162);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("更多");
            return;
          }
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
      label1047:
      i3 = 16;
      i1 = 0;
      i2 = 0;
    }
  }
  
  void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initCardContactInfoList");
    }
    Object localObject3;
    if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 29) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        localObject3 = (PhoneContactManager)this.app.getManager(10);
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
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject1 = ((PhoneContactManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject2 = localObject1;
        if (paramBoolean) {
          break label490;
        }
        localObject2 = (FriendListHandler)this.app.a(1);
        if ((!((FriendListHandler)localObject2).b()) && (!((FriendListHandler)localObject2).c())) {
          ((FriendListHandler)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
        }
      }
      while (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_k_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
        return;
        localObject2 = ((PhoneContactManager)localObject3).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = ((PhoneContactManager)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((PhoneContact)localObject2).mobileCode))
            {
              this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject2).mobileCode;
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
            ((FriendListHandler)localObject3).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true);
            localObject2 = localObject1;
          }
        }
        localObject1 = localObject2;
      }
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 34) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 51) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 50) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 29));
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.add(new ProfileActivity.CardContactInfo("", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ""));
  }
  
  public boolean c()
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
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendProfileCardActivity", 2, "savePersonalibyLabel2Card");
    }
    ThreadManager.postImmediately(new stv(this, (PersonalityLabelHandler)this.app.a(112)), null, true);
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView != null)
    {
      View localView = findViewById(2131370087);
      PullToZoomHeaderListView localPullToZoomHeaderListView = this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
      paramInt = -paramInt;
      localPullToZoomHeaderListView.smoothScrollToPositionFromTop(1, localView.getHeight() + paramInt);
    }
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString = paramString;
    a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, 4, paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName = new MQQProfileName();
    }
    paramString = (MQQProfileName)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.clone();
    b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    switch (paramString.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName))
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName);
      }
    }
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
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = false;
    boolean bool1;
    switch (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localObject2 = (ShieldMsgManger)this.app.getManager(15);
      bool1 = bool2;
      if (localObject2 != null)
      {
        if (!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break label239;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      break;
    }
    for (;;)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        bool1 = ((ShieldMsgManger)localObject2).a((String)localObject1);
      }
      return bool1;
      localObject2 = (FriendsManager)this.app.getManager(50);
      if (localObject2 == null) {}
      for (;;)
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
        localObject1 = ((FriendsManager)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
      localObject1 = (FriendsManager)this.app.getManager(50);
      if (localObject1 == null)
      {
        localObject1 = localObject2;
        if ((localObject1 == null) || (!((Friends)localObject1).isShield())) {
          break label234;
        }
      }
      label234:
      for (bool1 = true;; bool1 = false)
      {
        return bool1;
        localObject1 = ((FriendsManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break;
      }
      label239:
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject1 = a();
      } else {
        localObject1 = null;
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if (paramInt1 == 1019) {
      if (!NetworkUtil.d(BaseApplication.getContext())) {
        a(2131434629, 1);
      }
    }
    label92:
    label93:
    do
    {
      do
      {
        do
        {
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          break label93;
          do
          {
            return;
          } while ((paramInt2 != -1) || (paramIntent == null));
          paramIntent = paramIntent.getStringArrayListExtra("key_cover_selected_img_path");
        } while ((paramIntent == null) || (paramIntent.size() <= 0));
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "pick photo from qzone size:" + paramIntent.size());
        }
        ((CardHandler)this.app.a(2)).a(paramIntent);
        H();
        return;
        if (paramInt1 != 1020) {
          break;
        }
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          a(2131434629, 1);
          return;
        }
      } while ((paramInt2 != -1) || (paramIntent == null));
      paramIntent = paramIntent.getStringExtra("key_cover_selected_img_path");
    } while (TextUtils.isEmpty(paramIntent));
    e(paramIntent);
    return;
    Object localObject;
    if (paramInt1 == 1022)
    {
      ((CardHandler)this.app.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)))
      {
        this.jdField_j_of_type_Int = paramIntent.getIntExtra("param_joined_group_switch", -1);
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
            break label533;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.feedPreviewTime, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.vSeed, (byte[])localObject, true);
          if ((paramIntent == null) || (paramIntent.getBundleExtra("result") == null)) {
            break;
          }
          paramInt1 = paramIntent.getBundleExtra("result").getShort("key_personality_label_switch", (short)-1);
          if ((paramInt1 == -1) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel.isCloseByUser == paramInt1)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("FriendProfileCardActivity", 2, "back personalitylabel switch changed:" + paramInt1);
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel.isCloseByUser = paramInt1;
          if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelOnGetPersonalityLabelsListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelOnGetPersonalityLabelsListener.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel, false, true);
          }
          d();
          return;
          label533:
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 35) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 37) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 36)) {
            break label2617;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
          continue;
          if (paramInt1 == 1021)
          {
            if (paramInt2 != -1) {
              break;
            }
            e(ImageUtil.b(this, this.jdField_b_of_type_AndroidNetUri));
            return;
          }
          if ((paramInt1 == 1015) && (paramIntent != null))
          {
            this.jdField_p_of_type_Boolean = paramIntent.getBooleanExtra("isDataChanged", false);
            return;
          }
          if (paramInt1 != 4) {
            break label862;
          }
          if ((paramInt2 != -1) || (paramIntent == null)) {
            break;
          }
          if (!paramIntent.hasExtra("result")) {
            break label845;
          }
          paramIntent = paramIntent.getStringExtra("result");
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultStr : " + paramIntent);
          }
          if (TextUtils.isEmpty(paramIntent)) {
            break;
          }
          try
          {
            paramIntent = new JSONObject(paramIntent);
            if (paramIntent == null) {
              break label93;
            }
            paramIntent = paramIntent.get("payState");
            if ((paramIntent == null) || (!"0".equals(String.valueOf(paramIntent)))) {
              break label93;
            }
            a(0L, null, null, false);
            return;
          }
          catch (JSONException paramIntent)
          {
            paramIntent.printStackTrace();
            if (!QLog.isColorLevel()) {
              break label93;
            }
            QLog.e("FriendProfileCardActivity", 2, "onActivityResult, JSONException : " + paramIntent.getMessage());
            return;
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("FriendProfileCardActivity", 2, "onActivityResult, Exception : " + paramIntent.getMessage());
        return;
        label845:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("FriendProfileCardActivity", 2, "onActivityResult, data contain no result key.");
        return;
        label862:
        if (paramInt1 == 1024)
        {
          if ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("has_operation", false))) {
            break;
          }
          this.jdField_a_of_type_AndroidContentIntent = paramIntent;
          return;
        }
        if (paramInt1 == 1026)
        {
          if ((paramInt2 == 1001) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil = new TimeTraceUtil();
          this.jdField_f_of_type_Boolean = false;
          this.jdField_g_of_type_Int = 0;
          if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
            break;
          }
          paramIntent = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
          if (!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            break;
          }
          paramIntent.what = 1;
          paramIntent.obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramIntent);
          return;
        }
        if (paramInt1 == 1010)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int != 101) || (paramInt2 != -1)) {
            break;
          }
          finish();
          return;
        }
        if (paramInt1 == 1008)
        {
          if ((paramIntent != null) && (paramIntent.getExtras() != null))
          {
            bool1 = paramIntent.getExtras().getBoolean("photowall_updated");
            paramIntent = (CoverCacheData)paramIntent.getExtras().getParcelable("current_cover");
            if (((paramInt2 == -1) || (bool1)) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
              this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramIntent);
            }
            if (paramIntent == null) {
              break;
            }
            localObject = Message.obtain();
            ((Message)localObject).what = 3;
            ((Message)localObject).obj = paramIntent;
            if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
            break;
          }
          try
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a();
            if (localObject == null) {
              break label93;
            }
            paramIntent = new CoverCacheData();
            paramIntent.c = ((CoverCacheData)localObject).c;
            paramIntent.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo = ((CoverCacheData)localObject).jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo;
            paramIntent.jdField_a_of_type_JavaUtilArrayList = ((CoverCacheData)localObject).jdField_a_of_type_JavaUtilArrayList;
            paramIntent.jdField_b_of_type_JavaLangString = ((CoverCacheData)localObject).jdField_b_of_type_JavaLangString;
            paramIntent.jdField_a_of_type_Long = ((CoverCacheData)localObject).jdField_a_of_type_Long;
            paramIntent.jdField_a_of_type_JavaUtilHashMap = ((CoverCacheData)localObject).jdField_a_of_type_JavaUtilHashMap;
            paramIntent.jdField_a_of_type_Int = 0;
            paramIntent.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramIntent);
            localObject = Message.obtain();
            ((Message)localObject).what = 3;
            ((Message)localObject).obj = paramIntent;
            if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
              break label93;
            }
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)localObject);
            return;
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            return;
          }
        }
      }
      Card localCard;
      if (paramInt1 == 1007)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break;
        }
        localObject = (FriendsManager)this.app.getManager(50);
        if (localObject == null)
        {
          localCard = null;
          label1343:
          if ((localCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = localCard;
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString = localCard.strNick;
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0] = localCard.strNick;
            this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4] = "";
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(localCard);
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(localCard.getRichStatus());
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
            if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)))
            {
              this.jdField_j_of_type_Int = paramIntent.getIntExtra("param_joined_group_switch", -1);
              if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 56) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 57)) {
                break label1577;
              }
              localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
            }
          }
        }
      }
      for (;;)
      {
        a(localCard.feedPreviewTime, localCard.vSeed, (byte[])localObject, true);
        setResult(-1, paramIntent);
        return;
        localCard = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break label1343;
        label1577:
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 35) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 37) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
          continue;
          if (paramInt1 == 1029)
          {
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder().append("back from personality label gallery. resultcode==ok ");
              if (paramInt2 != -1) {
                break label1831;
              }
            }
            for (bool1 = bool2;; bool1 = false)
            {
              QLog.i("FriendProfileCardActivity", 2, bool1);
              if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel.unreadCount > 0))
              {
                this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel.unreadCount = 0;
                if (QLog.isColorLevel()) {
                  QLog.i("FriendProfileCardActivity", 2, "back from personality label gallery.clear vote");
                }
                if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelOnGetPersonalityLabelsListener != null) {
                  this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelOnGetPersonalityLabelsListener.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel, false, false);
                }
                d();
              }
              paramIntent = (PersonalityLabelHandler)this.app.a(112);
              if (paramInt2 != -1) {
                break;
              }
              paramIntent.a(getCurrentAccountUin(), 0);
              return;
            }
          }
          if (paramInt1 == 1027)
          {
            bool2 = Util.a(this.app);
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
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
          if (paramInt2 != -1) {
            break;
          }
        }
        label1831:
        switch (paramInt1)
        {
        default: 
          return;
        case 5: 
          paramIntent = ImageUtil.b(this, this.jdField_a_of_type_AndroidNetUri);
          paramInt1 = ProfileCardUtil.b(this);
          localObject = new Intent();
          ((Intent)localObject).putExtra("Business_Origin", 100);
          PhotoUtils.a((Intent)localObject, this, FriendProfileCardActivity.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.a());
          return;
        case 1012: 
          if (paramIntent == null) {
            break;
          }
          if (paramIntent.getBooleanExtra("finchat", false))
          {
            finish();
            return;
          }
          paramIntent = paramIntent.getStringExtra("remark");
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_i_of_type_JavaLangString, paramIntent)) {
            break;
          }
          d(paramIntent);
          return;
        case 21: 
          paramIntent.putExtra("selfSet_leftViewText", getString(2131433311));
          localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          paramIntent = ForwardUtils.a((Intent)localObject);
          ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject);
          return;
        case 1000: 
          setResult(-1);
          finish();
          return;
        case 800: 
          if (!NetworkUtil.d(BaseApplication.getContext()))
          {
            a(2131434629, 1);
            return;
          }
          bool1 = bool3;
          if (paramIntent != null) {
            bool1 = paramIntent.getBooleanExtra("avatar_changed", false);
          }
          if (!bool1) {
            break;
          }
          localObject = paramIntent.getStringExtra("avatar_filepath");
          if (ProfileCardUtil.a(this.app, (String)localObject, paramIntent))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            return;
          }
          a(2131435943, 1);
          return;
        case 1004: 
          paramIntent = ((FriendsManager)this.app.getManager(50)).a(this.app.getCurrentAccountUin());
          if ((paramIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramIntent;
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.l(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
          return;
        case 1018: 
          this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_d_of_type_Int = 1;
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
            break label92;
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
            if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Int == 8)
            {
              paramIntent.putExtra("key_troop_fee_notify_js_data_changed", true);
              paramIntent.putExtra("callback", this.jdField_h_of_type_JavaLangString);
              setResult(-1, paramIntent);
            }
          }
          localObject = null;
        }
      }
      label2617:
      localObject = null;
    }
  }
  
  /* Error */
  protected boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 3654	com/tencent/mobileqq/activity/FriendProfileCardActivity:getWindow	()Landroid/view/Window;
    //   4: bipush 253
    //   6: invokevirtual 3659	android/view/Window:setFormat	(I)V
    //   9: aload_0
    //   10: invokevirtual 3654	com/tencent/mobileqq/activity/FriendProfileCardActivity:getWindow	()Landroid/view/Window;
    //   13: new 3661	android/graphics/drawable/ColorDrawable
    //   16: dup
    //   17: iconst_m1
    //   18: invokespecial 3662	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   21: invokevirtual 3663	android/view/Window:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   24: getstatic 1803	com/tencent/util/ProfilePerformanceReport:a	Lcom/tencent/util/ProfilePerformanceReport;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull +29 -> 60
    //   34: aload 4
    //   36: invokevirtual 1804	com/tencent/util/ProfilePerformanceReport:a	()Z
    //   39: ifeq +21 -> 60
    //   42: aload 4
    //   44: iconst_0
    //   45: invokevirtual 2638	com/tencent/util/ProfilePerformanceReport:b	(I)V
    //   48: aload 4
    //   50: iconst_1
    //   51: invokevirtual 1806	com/tencent/util/ProfilePerformanceReport:a	(I)V
    //   54: aload 4
    //   56: iconst_2
    //   57: invokevirtual 1806	com/tencent/util/ProfilePerformanceReport:a	(I)V
    //   60: aload_0
    //   61: new 2112	com/tencent/mobileqq/utils/TimeTraceUtil
    //   64: dup
    //   65: ldc_w 520
    //   68: invokespecial 3664	com/tencent/mobileqq/utils/TimeTraceUtil:<init>	(Ljava/lang/String;)V
    //   71: putfield 2108	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   74: aload_0
    //   75: invokevirtual 1645	com/tencent/mobileqq/activity/FriendProfileCardActivity:getIntent	()Landroid/content/Intent;
    //   78: astore 4
    //   80: aload_0
    //   81: iconst_0
    //   82: putfield 3667	com/tencent/mobileqq/activity/FriendProfileCardActivity:mActNeedImmersive	Z
    //   85: aload_0
    //   86: aload_1
    //   87: invokespecial 3669	com/tencent/mobileqq/activity/ProfileActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   90: pop
    //   91: aload_0
    //   92: getfield 2108	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   95: ldc_w 3671
    //   98: iconst_0
    //   99: invokevirtual 2115	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Z)V
    //   102: aload_0
    //   103: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   106: ifnull +21 -> 127
    //   109: aload_0
    //   110: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   113: invokevirtual 3674	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   116: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +8 -> 127
    //   122: aload 4
    //   124: ifnonnull +9 -> 133
    //   127: aload_0
    //   128: invokevirtual 3532	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   131: iconst_0
    //   132: ireturn
    //   133: aload_0
    //   134: aload 4
    //   136: ldc_w 3676
    //   139: iconst_0
    //   140: invokevirtual 1084	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   143: putfield 1226	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_q_of_type_Boolean	Z
    //   146: aload 4
    //   148: ldc_w 3678
    //   151: invokevirtual 3506	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   154: ifeq +44 -> 198
    //   157: aload 4
    //   159: ldc_w 3678
    //   162: invokevirtual 3682	android/content/Intent:getSerializableExtra	(Ljava/lang/String;)Ljava/io/Serializable;
    //   165: astore_1
    //   166: aload_1
    //   167: ifnull +31 -> 198
    //   170: aload_0
    //   171: invokestatic 3687	com/tencent/mobileqq/activity/KPLProfileCardActivity:a	(Landroid/content/Context;)Landroid/content/Intent;
    //   174: astore 4
    //   176: aload 4
    //   178: ldc_w 3678
    //   181: aload_1
    //   182: invokevirtual 3690	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   185: pop
    //   186: aload_0
    //   187: aload 4
    //   189: invokevirtual 1659	com/tencent/mobileqq/activity/FriendProfileCardActivity:startActivity	(Landroid/content/Intent;)V
    //   192: aload_0
    //   193: invokevirtual 3532	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   196: iconst_0
    //   197: ireturn
    //   198: aload_0
    //   199: aload 4
    //   201: ldc_w 3692
    //   204: iconst_0
    //   205: invokevirtual 1084	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   208: putfield 3295	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_j_of_type_Boolean	Z
    //   211: aload_0
    //   212: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   215: aload_0
    //   216: getfield 299	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   219: putfield 3693	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_AndroidViewView$OnClickListener	Landroid/view/View$OnClickListener;
    //   222: aload_0
    //   223: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   226: aload_0
    //   227: getfield 294	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidViewView$OnLongClickListener	Landroid/view/View$OnLongClickListener;
    //   230: putfield 3694	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_AndroidViewView$OnLongClickListener	Landroid/view/View$OnLongClickListener;
    //   233: aload 4
    //   235: ldc_w 3628
    //   238: invokevirtual 3697	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   241: checkcast 403	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   244: astore_1
    //   245: aload 4
    //   247: ldc_w 3698
    //   250: invokevirtual 3506	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   253: istore_3
    //   254: iload_3
    //   255: ifeq +1561 -> 1816
    //   258: aload_0
    //   259: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   262: aload 4
    //   264: ldc_w 3698
    //   267: invokevirtual 1113	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   270: putfield 491	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   273: aload_1
    //   274: ifnonnull +1539 -> 1813
    //   277: aload 4
    //   279: ldc_w 3700
    //   282: invokevirtual 1113	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   285: astore_1
    //   286: aload_1
    //   287: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   290: ifeq +1520 -> 1810
    //   293: aload_0
    //   294: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   297: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   300: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   303: astore_1
    //   304: aload_0
    //   305: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   308: bipush 50
    //   310: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   313: checkcast 375	com/tencent/mobileqq/app/FriendsManager
    //   316: aload_1
    //   317: invokevirtual 407	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   320: astore 5
    //   322: aload 5
    //   324: ifnull +228 -> 552
    //   327: aload 5
    //   329: invokevirtual 3702	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   332: ifeq +220 -> 552
    //   335: new 403	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   338: dup
    //   339: aload_1
    //   340: iconst_1
    //   341: invokespecial 3630	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   344: astore_1
    //   345: aload_1
    //   346: aload 5
    //   348: getfield 1191	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   351: putfield 766	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   354: aload_1
    //   355: aload 5
    //   357: getfield 1192	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   360: putfield 765	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   363: aload_0
    //   364: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   367: new 564	com/tencent/mobileqq/data/TroopMemberCard
    //   370: dup
    //   371: invokespecial 3703	com/tencent/mobileqq/data/TroopMemberCard:<init>	()V
    //   374: putfield 562	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard	Lcom/tencent/mobileqq/data/TroopMemberCard;
    //   377: aload_0
    //   378: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   381: aload 4
    //   383: ldc_w 3705
    //   386: iconst_m1
    //   387: invokevirtual 1821	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   390: putfield 1816	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_b_of_type_Int	I
    //   393: aload_0
    //   394: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   397: getfield 1816	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_b_of_type_Int	I
    //   400: bipush 8
    //   402: if_icmpne +15 -> 417
    //   405: aload_0
    //   406: aload 4
    //   408: ldc_w 3648
    //   411: invokevirtual 1113	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   414: putfield 187	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   417: aload_0
    //   418: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   421: getfield 1816	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_b_of_type_Int	I
    //   424: iconst_4
    //   425: if_icmpne +39 -> 464
    //   428: aload_0
    //   429: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   432: ldc_w 1250
    //   435: ldc_w 3707
    //   438: ldc 150
    //   440: ldc_w 3709
    //   443: ldc_w 3711
    //   446: iconst_0
    //   447: iconst_0
    //   448: aload_0
    //   449: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   452: getfield 491	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   455: ldc 150
    //   457: ldc 150
    //   459: ldc 150
    //   461: invokestatic 727	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   464: new 3713	com/tencent/mobileqq/statistics/ReportTask
    //   467: dup
    //   468: aload_0
    //   469: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   472: invokespecial 3714	com/tencent/mobileqq/statistics/ReportTask:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   475: ldc_w 3716
    //   478: invokevirtual 3719	com/tencent/mobileqq/statistics/ReportTask:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   481: ldc_w 3721
    //   484: invokevirtual 3723	com/tencent/mobileqq/statistics/ReportTask:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   487: ldc_w 3725
    //   490: invokevirtual 3727	com/tencent/mobileqq/statistics/ReportTask:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   493: ldc_w 3729
    //   496: invokevirtual 3731	com/tencent/mobileqq/statistics/ReportTask:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   499: iconst_1
    //   500: anewarray 853	java/lang/String
    //   503: dup
    //   504: iconst_0
    //   505: aload_0
    //   506: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   509: getfield 491	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   512: aastore
    //   513: invokevirtual 3734	com/tencent/mobileqq/statistics/ReportTask:a	([Ljava/lang/String;)Lcom/tencent/mobileqq/statistics/ReportTask;
    //   516: invokevirtual 3735	com/tencent/mobileqq/statistics/ReportTask:a	()V
    //   519: aload_0
    //   520: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   523: iload_3
    //   524: putfield 462	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_b_of_type_Boolean	Z
    //   527: aload_0
    //   528: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   531: aload_1
    //   532: putfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   535: aload_0
    //   536: aload_0
    //   537: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   540: invokevirtual 3737	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/profile/ProfileCardInfo;)Z
    //   543: ifne +23 -> 566
    //   546: aload_0
    //   547: invokevirtual 3532	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   550: iconst_0
    //   551: ireturn
    //   552: new 403	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   555: dup
    //   556: aload_1
    //   557: bipush 21
    //   559: invokespecial 3630	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   562: astore_1
    //   563: goto -200 -> 363
    //   566: aload_1
    //   567: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   570: invokestatic 2940	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Z
    //   573: ifeq +25 -> 598
    //   576: aload_0
    //   577: invokevirtual 3738	com/tencent/mobileqq/activity/FriendProfileCardActivity:getApplicationContext	()Landroid/content/Context;
    //   580: invokestatic 3740	com/tencent/mobileqq/util/Utils:a	(Landroid/content/Context;)Z
    //   583: ifeq +15 -> 598
    //   586: aload_0
    //   587: iconst_0
    //   588: iconst_0
    //   589: invokevirtual 1951	com/tencent/mobileqq/activity/FriendProfileCardActivity:overridePendingTransition	(II)V
    //   592: aload_0
    //   593: invokevirtual 3532	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   596: iconst_0
    //   597: ireturn
    //   598: aload_0
    //   599: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   602: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   605: getfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   608: bipush 90
    //   610: if_icmpne +48 -> 658
    //   613: aload_0
    //   614: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   617: bipush 50
    //   619: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   622: checkcast 375	com/tencent/mobileqq/app/FriendsManager
    //   625: astore_1
    //   626: aload_1
    //   627: ifnull +151 -> 778
    //   630: aload_1
    //   631: aload_0
    //   632: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   635: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   638: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   641: invokevirtual 2614	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   644: ifeq +134 -> 778
    //   647: aload_0
    //   648: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   651: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   654: iconst_1
    //   655: putfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   658: aload_0
    //   659: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   662: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   665: getfield 956	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   668: bipush 100
    //   670: if_icmpne +50 -> 720
    //   673: aload_0
    //   674: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   677: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   680: getfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   683: bipush 34
    //   685: if_icmpne +35 -> 720
    //   688: aload_0
    //   689: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   692: bipush 10
    //   694: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   697: checkcast 1649	com/tencent/mobileqq/model/PhoneContactManager
    //   700: invokeinterface 1651 1 0
    //   705: ifne +15 -> 720
    //   708: aload_0
    //   709: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   712: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   715: bipush 29
    //   717: putfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   720: aload_0
    //   721: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   724: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   727: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   730: invokestatic 3743	com/tencent/biz/bmqq/util/BmqqSegmentUtil:b	(Ljava/lang/String;)Z
    //   733: ifeq +60 -> 793
    //   736: iload_3
    //   737: ifne +56 -> 793
    //   740: new 182	android/content/Intent
    //   743: dup
    //   744: aload_0
    //   745: ldc_w 1117
    //   748: invokespecial 540	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   751: astore_1
    //   752: aload_1
    //   753: ldc_w 3628
    //   756: aload_0
    //   757: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   760: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   763: invokevirtual 3633	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   766: pop
    //   767: aload_0
    //   768: aload_1
    //   769: invokespecial 3744	com/tencent/mobileqq/activity/ProfileActivity:startActivity	(Landroid/content/Intent;)V
    //   772: aload_0
    //   773: invokespecial 3745	com/tencent/mobileqq/activity/ProfileActivity:finish	()V
    //   776: iconst_0
    //   777: ireturn
    //   778: aload_0
    //   779: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   782: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   785: bipush 19
    //   787: putfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   790: goto -132 -> 658
    //   793: aload_0
    //   794: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   797: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   800: getfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   803: bipush 41
    //   805: if_icmpne +43 -> 848
    //   808: aload_0
    //   809: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   812: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   815: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   818: invokestatic 581	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   821: ifne +27 -> 848
    //   824: aload_0
    //   825: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   828: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   831: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   834: ldc_w 1783
    //   837: invokevirtual 1120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   840: ifeq +8 -> 848
    //   843: aload_0
    //   844: iconst_0
    //   845: putfield 163	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_e_of_type_Boolean	Z
    //   848: aload_0
    //   849: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   852: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   855: getfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   858: bipush 53
    //   860: if_icmpeq +37 -> 897
    //   863: aload_0
    //   864: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   867: invokevirtual 1607	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   870: aload_0
    //   871: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   874: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   877: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   880: invokevirtual 1120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   883: ifeq +14 -> 897
    //   886: aload_0
    //   887: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   890: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   893: iconst_0
    //   894: putfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   897: aload_0
    //   898: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   901: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   904: getfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   907: ifne +8 -> 915
    //   910: aload_0
    //   911: iconst_1
    //   912: putfield 3747	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_g_of_type_Boolean	Z
    //   915: new 3749	svd
    //   918: dup
    //   919: aload_0
    //   920: invokespecial 3750	svd:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   923: iconst_5
    //   924: aconst_null
    //   925: iconst_0
    //   926: invokestatic 926	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   929: aload_0
    //   930: new 385	com/tencent/util/WeakReferenceHandler
    //   933: dup
    //   934: invokestatic 3754	com/tencent/mobileqq/app/ThreadManager:getSubThreadLooper	()Landroid/os/Looper;
    //   937: aload_0
    //   938: getfield 316	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_AndroidOsHandler$Callback	Landroid/os/Handler$Callback;
    //   941: invokespecial 3757	com/tencent/util/WeakReferenceHandler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   944: putfield 383	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   947: aload_0
    //   948: new 385	com/tencent/util/WeakReferenceHandler
    //   951: dup
    //   952: invokestatic 3762	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   955: aload_0
    //   956: getfield 304	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidOsHandler$Callback	Landroid/os/Handler$Callback;
    //   959: invokespecial 3757	com/tencent/util/WeakReferenceHandler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   962: putfield 806	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   965: aload_0
    //   966: aload_0
    //   967: invokevirtual 612	com/tencent/mobileqq/activity/FriendProfileCardActivity:getApplication	()Landroid/app/Application;
    //   970: aload_0
    //   971: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   974: invokevirtual 1607	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   977: invokestatic 3768	com/tencent/mobileqq/utils/SharedPreUtils:aj	(Landroid/content/Context;Ljava/lang/String;)I
    //   980: i2b
    //   981: putfield 1978	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Byte	B
    //   984: aload_0
    //   985: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   988: getfield 462	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_b_of_type_Boolean	Z
    //   991: ifeq +25 -> 1016
    //   994: aload_0
    //   995: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   998: aload_0
    //   999: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1002: getfield 491	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1005: invokestatic 515	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   1008: ifeq +8 -> 1016
    //   1011: aload_0
    //   1012: iconst_0
    //   1013: putfield 1978	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Byte	B
    //   1016: aload_0
    //   1017: invokevirtual 3770	com/tencent/mobileqq/activity/FriendProfileCardActivity:b	()V
    //   1020: aload_0
    //   1021: aload_0
    //   1022: getfield 248	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqAppCardObserver	Lcom/tencent/mobileqq/app/CardObserver;
    //   1025: invokevirtual 3771	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   1028: aload_0
    //   1029: aload_0
    //   1030: getfield 243	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver	Lcom/tencent/mobileqq/campuscircle/CampusCircleObserver;
    //   1033: invokevirtual 3771	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   1036: aload_0
    //   1037: aload_0
    //   1038: getfield 265	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqAppFriendListObserver	Lcom/tencent/mobileqq/app/FriendListObserver;
    //   1041: invokevirtual 3771	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   1044: aload_0
    //   1045: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1048: aload_0
    //   1049: getfield 258	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver	Lcom/tencent/mobileqq/phonecontact/ContactBindObserver;
    //   1052: invokevirtual 3775	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   1055: aload_0
    //   1056: aload_0
    //   1057: getfield 199	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqAppTroopObserver	Lcom/tencent/mobileqq/app/TroopObserver;
    //   1060: invokevirtual 3771	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   1063: aload_0
    //   1064: aload_0
    //   1065: getfield 194	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelObserver	Lcom/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabelObserver;
    //   1068: invokevirtual 3771	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   1071: aload_0
    //   1072: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1075: sipush 183
    //   1078: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1081: checkcast 2592	com/tencent/mobileqq/vas/VasQuickUpdateManager
    //   1084: aload_0
    //   1085: getfield 206	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker	Lcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;
    //   1088: invokevirtual 2598	com/tencent/mobileqq/vas/VasQuickUpdateManager:a	(Lcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)V
    //   1091: aload_0
    //   1092: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1095: iconst_2
    //   1096: invokevirtual 487	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1099: checkcast 1602	com/tencent/mobileqq/app/CardHandler
    //   1102: astore_1
    //   1103: aload_1
    //   1104: ifnull +16 -> 1120
    //   1107: aload_0
    //   1108: aload_1
    //   1109: aload_0
    //   1110: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1113: aload_0
    //   1114: invokevirtual 3778	com/tencent/mobileqq/app/CardHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/CardHandler$CoverTransCallback;)Lcom/tencent/mobileqq/app/CardHandler$CardTransProcessorHandler;
    //   1117: putfield 3780	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqAppCardHandler$CardTransProcessorHandler	Lcom/tencent/mobileqq/app/CardHandler$CardTransProcessorHandler;
    //   1120: aload_0
    //   1121: new 418	java/lang/StringBuilder
    //   1124: dup
    //   1125: invokespecial 419	java/lang/StringBuilder:<init>	()V
    //   1128: aload_0
    //   1129: getfield 169	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1132: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: aload_0
    //   1136: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1139: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1142: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1145: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1151: putfield 169	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1154: aload_0
    //   1155: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1158: bipush 14
    //   1160: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1163: checkcast 3782	com/tencent/mobileqq/richstatus/StatusManager
    //   1166: astore_1
    //   1167: aload_1
    //   1168: ifnull +11 -> 1179
    //   1171: aload_1
    //   1172: aload_0
    //   1173: getfield 311	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener	Lcom/tencent/mobileqq/richstatus/IIconListener;
    //   1176: invokevirtual 3784	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/Object;)V
    //   1179: aload_0
    //   1180: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1183: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1186: getfield 956	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1189: bipush 6
    //   1191: if_icmpne +24 -> 1215
    //   1194: aload_0
    //   1195: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1198: invokevirtual 3787	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1201: ifnull +14 -> 1215
    //   1204: aload_0
    //   1205: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1208: invokevirtual 3787	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1211: aload_0
    //   1212: invokevirtual 3792	com/tencent/mobileqq/app/message/QQMessageFacade:addObserver	(Ljava/util/Observer;)V
    //   1215: invokestatic 2831	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	()Lcom/tencent/mobileqq/musicpendant/MusicPendantManager;
    //   1218: ifnull +56 -> 1274
    //   1221: aload_0
    //   1222: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1225: ifnull +49 -> 1274
    //   1228: aload_0
    //   1229: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1232: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1235: ifnull +39 -> 1274
    //   1238: aload_0
    //   1239: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1242: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1245: getfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1248: bipush 53
    //   1250: if_icmpeq +24 -> 1274
    //   1253: invokestatic 2831	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	()Lcom/tencent/mobileqq/musicpendant/MusicPendantManager;
    //   1256: aload_0
    //   1257: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1260: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1263: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1266: aload_0
    //   1267: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1270: aload_0
    //   1271: invokevirtual 3795	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;)V
    //   1274: aload_0
    //   1275: iconst_0
    //   1276: invokevirtual 2450	com/tencent/mobileqq/activity/FriendProfileCardActivity:c	(Z)V
    //   1279: getstatic 3800	com/tencent/mobileqq/vas/ClubContentJsonTask:a	Lcom/tencent/mobileqq/vas/ClubContentJsonTask$PersonalCardUrlInfo;
    //   1282: ifnonnull +17 -> 1299
    //   1285: new 3802	svo
    //   1288: dup
    //   1289: aload_0
    //   1290: invokespecial 3803	svo:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   1293: iconst_5
    //   1294: aconst_null
    //   1295: iconst_1
    //   1296: invokestatic 926	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1299: aload_0
    //   1300: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1303: bipush 7
    //   1305: anewarray 853	java/lang/String
    //   1308: putfield 761	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   1311: new 3805	svv
    //   1314: dup
    //   1315: aload_0
    //   1316: invokespecial 3806	svv:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   1319: bipush 8
    //   1321: aconst_null
    //   1322: iconst_1
    //   1323: invokestatic 926	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1326: aload_0
    //   1327: invokevirtual 2463	com/tencent/mobileqq/activity/FriendProfileCardActivity:j	()V
    //   1330: aload_0
    //   1331: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1334: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1337: getfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1340: bipush 33
    //   1342: if_icmpeq +303 -> 1645
    //   1345: aload_0
    //   1346: invokevirtual 3807	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	()V
    //   1349: aload_0
    //   1350: invokevirtual 3810	com/tencent/mobileqq/activity/FriendProfileCardActivity:x	()V
    //   1353: aload_0
    //   1354: invokespecial 938	com/tencent/mobileqq/activity/FriendProfileCardActivity:S	()V
    //   1357: aload_0
    //   1358: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1361: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1364: getfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1367: ifeq +340 -> 1707
    //   1370: new 3812	svx
    //   1373: dup
    //   1374: aload_0
    //   1375: invokespecial 3813	svx:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   1378: bipush 8
    //   1380: aconst_null
    //   1381: iconst_1
    //   1382: invokestatic 926	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1385: aload_0
    //   1386: getfield 3331	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1389: ldc_w 3815
    //   1392: invokestatic 3820	com/tencent/mobileqq/util/AccessibilityUtil:a	(Landroid/view/View;Ljava/lang/String;)V
    //   1395: aload_0
    //   1396: getfield 3331	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1399: invokestatic 3821	com/tencent/mobileqq/util/AccessibilityUtil:a	(Landroid/view/View;)V
    //   1402: aload_0
    //   1403: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1406: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1409: getfield 527	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_Int	I
    //   1412: ifne +325 -> 1737
    //   1415: aload_0
    //   1416: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1419: ldc_w 1250
    //   1422: ldc_w 3823
    //   1425: ldc 150
    //   1427: ldc_w 3825
    //   1430: ldc_w 3825
    //   1433: iconst_0
    //   1434: iconst_0
    //   1435: ldc 150
    //   1437: ldc 150
    //   1439: ldc 150
    //   1441: ldc 150
    //   1443: invokestatic 727	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1446: aload_0
    //   1447: getfield 2108	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil	Lcom/tencent/mobileqq/utils/TimeTraceUtil;
    //   1450: ldc_w 3826
    //   1453: iconst_0
    //   1454: invokevirtual 2115	com/tencent/mobileqq/utils/TimeTraceUtil:a	(Ljava/lang/String;Z)V
    //   1457: aload_0
    //   1458: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1461: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1464: getfield 404	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1467: invokestatic 2940	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Z
    //   1470: ifeq +52 -> 1522
    //   1473: iconst_0
    //   1474: istore_2
    //   1475: aload_0
    //   1476: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1479: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1482: getfield 956	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1485: bipush 59
    //   1487: if_icmpne +284 -> 1771
    //   1490: iconst_1
    //   1491: istore_2
    //   1492: aload_0
    //   1493: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1496: ldc_w 720
    //   1499: ldc 150
    //   1501: ldc 150
    //   1503: ldc_w 3828
    //   1506: ldc_w 3828
    //   1509: iload_2
    //   1510: iconst_0
    //   1511: ldc 150
    //   1513: ldc 150
    //   1515: ldc 150
    //   1517: ldc 150
    //   1519: invokestatic 727	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1522: aload_0
    //   1523: aload_0
    //   1524: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1527: sipush 142
    //   1530: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1533: checkcast 3058	com/tencent/mobileqq/qcall/PstnManager
    //   1536: putfield 3056	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqQcallPstnManager	Lcom/tencent/mobileqq/qcall/PstnManager;
    //   1539: aload_0
    //   1540: aload_0
    //   1541: getfield 3056	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqQcallPstnManager	Lcom/tencent/mobileqq/qcall/PstnManager;
    //   1544: aload_0
    //   1545: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1548: invokevirtual 1607	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1551: invokevirtual 3831	com/tencent/mobileqq/qcall/PstnManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/qcall/PstnCardInfo;
    //   1554: putfield 3039	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqQcallPstnCardInfo	Lcom/tencent/mobileqq/qcall/PstnCardInfo;
    //   1557: aload_0
    //   1558: invokevirtual 3833	com/tencent/mobileqq/activity/FriendProfileCardActivity:P	()V
    //   1561: aload_0
    //   1562: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1565: bipush 51
    //   1567: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1570: checkcast 484	com/tencent/mobileqq/app/TroopManager
    //   1573: aload_0
    //   1574: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1577: getfield 491	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1580: invokevirtual 494	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   1583: astore_1
    //   1584: aload_1
    //   1585: ifnull +35 -> 1620
    //   1588: aload_1
    //   1589: invokevirtual 3836	com/tencent/mobileqq/data/TroopInfo:isGameBind	()Z
    //   1592: ifeq +28 -> 1620
    //   1595: ldc_w 3838
    //   1598: ldc_w 3840
    //   1601: ldc_w 3842
    //   1604: iconst_0
    //   1605: iconst_0
    //   1606: iconst_1
    //   1607: anewarray 853	java/lang/String
    //   1610: dup
    //   1611: iconst_0
    //   1612: aload_1
    //   1613: getfield 2009	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   1616: aastore
    //   1617: invokestatic 3847	com/tencent/mobileqq/util/TroopReportor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   1620: iconst_1
    //   1621: ireturn
    //   1622: astore_1
    //   1623: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1626: ifeq +13 -> 1639
    //   1629: ldc_w 416
    //   1632: iconst_2
    //   1633: ldc 150
    //   1635: aload_1
    //   1636: invokestatic 3849	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1639: aload_0
    //   1640: invokevirtual 3532	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   1643: iconst_0
    //   1644: ireturn
    //   1645: aload_0
    //   1646: aload_0
    //   1647: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1650: getfield 473	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqDataCard	Lcom/tencent/mobileqq/data/Card;
    //   1653: iconst_0
    //   1654: invokevirtual 2459	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/data/Card;Z)V
    //   1657: goto -308 -> 1349
    //   1660: astore_1
    //   1661: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1664: ifeq +33 -> 1697
    //   1667: ldc_w 416
    //   1670: iconst_2
    //   1671: new 418	java/lang/StringBuilder
    //   1674: dup
    //   1675: invokespecial 419	java/lang/StringBuilder:<init>	()V
    //   1678: ldc_w 3851
    //   1681: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: aload_1
    //   1685: invokevirtual 523	java/lang/Exception:toString	()Ljava/lang/String;
    //   1688: invokevirtual 425	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1691: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1694: invokestatic 603	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1697: aload_1
    //   1698: invokevirtual 931	java/lang/Exception:printStackTrace	()V
    //   1701: aload_0
    //   1702: invokevirtual 3532	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   1705: iconst_0
    //   1706: ireturn
    //   1707: aload_0
    //   1708: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1711: aload_0
    //   1712: getfield 270	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver	Lcom/tencent/mobileqq/observer/GameCenterObserver;
    //   1715: invokevirtual 3775	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   1718: aload_0
    //   1719: getfield 806	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   1722: new 3853	svw
    //   1725: dup
    //   1726: aload_0
    //   1727: invokespecial 3854	svw:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   1730: invokevirtual 3857	com/tencent/util/WeakReferenceHandler:post	(Ljava/lang/Runnable;)Z
    //   1733: pop
    //   1734: goto -364 -> 1370
    //   1737: aload_0
    //   1738: getfield 367	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1741: ldc_w 1250
    //   1744: ldc_w 3823
    //   1747: ldc 150
    //   1749: ldc_w 3859
    //   1752: ldc_w 3859
    //   1755: iconst_0
    //   1756: iconst_0
    //   1757: ldc 150
    //   1759: ldc 150
    //   1761: ldc 150
    //   1763: ldc 150
    //   1765: invokestatic 727	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1768: goto -322 -> 1446
    //   1771: aload_0
    //   1772: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1775: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1778: getfield 956	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1781: iconst_1
    //   1782: if_icmpne +8 -> 1790
    //   1785: iconst_2
    //   1786: istore_2
    //   1787: goto -295 -> 1492
    //   1790: aload_0
    //   1791: getfield 146	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo	Lcom/tencent/mobileqq/profile/ProfileCardInfo;
    //   1794: getfield 401	com/tencent/mobileqq/profile/ProfileCardInfo:jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1797: getfield 956	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:jdField_h_of_type_Int	I
    //   1800: bipush 8
    //   1802: if_icmpne -310 -> 1492
    //   1805: iconst_3
    //   1806: istore_2
    //   1807: goto -315 -> 1492
    //   1810: goto -1506 -> 304
    //   1813: goto -1450 -> 363
    //   1816: goto -1297 -> 519
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1819	0	this	FriendProfileCardActivity
    //   0	1819	1	paramBundle	Bundle
    //   1474	333	2	i1	int
    //   253	484	3	bool	boolean
    //   27	380	4	localObject	Object
    //   320	36	5	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   848	897	1622	java/lang/Exception
    //   1215	1274	1660	java/lang/Exception
    //   1274	1299	1660	java/lang/Exception
    //   1299	1349	1660	java/lang/Exception
    //   1349	1357	1660	java/lang/Exception
    //   1645	1657	1660	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$CardTransProcessorHandler != null)
    {
      ((CardHandler)this.app.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$CardTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$CardTransProcessorHandler = null;
    }
    if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = null;
    }
    super.doOnDestroy();
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_Boolean = false;
        }
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
        this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
        removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelObserver);
        Object localObject1;
        if (this.app != null)
        {
          localObject1 = (VasQuickUpdateManager)this.app.getManager(183);
          if (localObject1 != null) {
            ((VasQuickUpdateManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
          }
        }
        if (this.app != null)
        {
          localObject1 = (StatusManager)this.app.getManager(14);
          if (localObject1 != null) {
            ((StatusManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
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
            int i1 = 0;
            if (i1 < i2)
            {
              localObject1 = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i1);
              if ((localObject1 instanceof ProfileHeaderView)) {
                ((ProfileHeaderView)localObject1).c();
              }
              i1 += 1;
              continue;
            }
          }
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        localException.printStackTrace();
        continue;
        if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
        {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
          this.jdField_a_of_type_AndroidAppDialog = null;
        }
        if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
        {
          this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
          this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
        }
        L();
        if (MusicPendantManager.a() != null) {
          MusicPendantManager.a().e();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession != null) {
          this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession.d();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().c();
        }
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "doOnDestroy recycle bg");
          }
          ((FriendProfileCardBgDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).a();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard))) {
          QLog.i("FriendProfileCardActivity", 1, "FriendProfileCardActivity.onDestroy()");
        }
        ProfileCardUtil.b();
        MedalGuideView.a();
        com.tencent.mobileqq.apollo.task.ApolloActionHelper.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener != null) {
          this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener);
        }
        return;
      }
      Object localObject2 = null;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      if (!NetworkUtil.d(BaseApplication.getContext())) {
        a(2131434629, 1);
      }
    }
    label231:
    for (;;)
    {
      return;
      CardHandler localCardHandler = (CardHandler)this.app.a(2);
      if (paramIntent.getBooleanExtra("action_cover_pick_gallery", false))
      {
        localCardHandler.b((String)((ArrayList)localObject).get(0));
        H();
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, this.jdField_r_of_type_Int);
        return;
      }
      localCardHandler.a((ArrayList)localObject);
      H();
      return;
      if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
        doOnActivityResult(1000, -1, paramIntent);
      }
      for (;;)
      {
        if (paramIntent == null) {
          break label231;
        }
        paramIntent = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
        if ((paramIntent == null) || (paramIntent.jdField_h_of_type_Int != 115)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = paramIntent;
        a(0L, null, null, false);
        return;
        localObject = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (localObject != null) {
          if (ProfileCardUtil.a(this.app, (String)localObject, paramIntent))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
              this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            }
          }
          else {
            a(2131435943, 1);
          }
        }
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    AbstractVideoImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c();
    }
    if (!this.jdField_f_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "FriendProfileCardActivity time trace:" + this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.toString());
        }
        StatisticCollector.a(this.app.getApp()).a(this.app.getCurrentAccountUin(), "profileCardTimeStat", true, 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a(), "", false);
      }
      this.jdField_f_of_type_Boolean = true;
    }
    if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(102);
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a();
    }
    QQAppInterface localQQAppInterface = this.app;
    if (localQQAppInterface != null) {
      StatisticHitRateCollector.a().b(localQQAppInterface.getCurrentAccountUin(), "actQZLoadHitRateProfile");
    }
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.d();
    this.s = true;
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "friend profile card activity doOnResume");
    }
    super.doOnResume();
    AbstractVideoImage.resumeAll();
    ApngImage.playByTag(9);
    if (this.jdField_d_of_type_Boolean) {
      if ((!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileTagView)) || (!((ProfileTagView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).jdField_c_of_type_Boolean)) {
        break label349;
      }
    }
    label349:
    for (int i1 = 0;; i1 = 1)
    {
      this.jdField_d_of_type_Int = 0;
      if (i1 != 0) {
        k();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      }
      h();
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
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 6) {
        y();
      }
      addObserver(this.jdField_b_of_type_ComTencentMobileqqAppCardObserver);
      if (this.jdField_p_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = null;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false);
      }
      if (this.app != null)
      {
        WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(12);
        if (localWebProcessManager != null) {
          localWebProcessManager.a(-1, new swj(this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession));
        }
        QZoneHelper.a(this.app, this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession);
      }
      O();
      if (this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelOnGetPersonalityLabelsListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelOnGetPersonalityLabelsListener.a();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int == 115) && (AddFriendLogicActivity.jdField_b_of_type_Boolean)) {
        f(getIntent().getStringExtra("src_name"));
      }
      return;
    }
  }
  
  protected void doOnStart()
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
      if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      }
      return;
      label77:
      if ((localView instanceof VoteViewV2)) {
        ((VoteViewV2)localView).b(true);
      }
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    removeObserver(this.jdField_b_of_type_ComTencentMobileqqAppCardObserver);
    Object localObject = ProfilePerformanceReport.a;
    if ((localObject != null) && (((ProfilePerformanceReport)localObject).a(true))) {
      ((ProfilePerformanceReport)localObject).a(this.app.getCurrentAccountUin());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper.d();
      }
      localObject = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
      if (!(localObject instanceof VoteView)) {
        break label167;
      }
      ((VoteView)localObject).b(false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(10))
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
        M();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.c();
      }
      if ((this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null) && (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
        this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
      }
      return;
      label167:
      if ((localObject instanceof VoteViewV2)) {
        ((VoteViewV2)localObject).b(false);
      }
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("doOnWindowFocusChanged", false);
      ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.a;
      if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.a())) {
        localProfilePerformanceReport.b(2);
      }
      if ((!this.jdField_m_of_type_Boolean) || (this.jdField_l_of_type_Boolean))
      {
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(100);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(100, 100L);
        this.jdField_l_of_type_Boolean = false;
        this.jdField_m_of_type_Boolean = true;
      }
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(102);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(102, 100L);
        this.jdField_g_of_type_Boolean = false;
      }
    }
  }
  
  public void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131436563);
    localActionSheet.b(2131435831);
    localActionSheet.b(2131435828);
    localActionSheet.b(2131435830);
    localActionSheet.b(2131435829);
    localActionSheet.c(2131433029);
    localActionSheet.a(new stw(this, localActionSheet));
    try
    {
      if (!isFinishing()) {
        localActionSheet.show();
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
    if (paramInt == 7)
    {
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.post(new suv(this));
      return;
    }
    Object localObject2 = this.app.getCurrentNickname();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.app.getCurrentNickname();
    }
    localObject2 = QZoneHelper.UserInfo.a();
    ((QZoneHelper.UserInfo)localObject2).jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    ((QZoneHelper.UserInfo)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.vQzoneCoverInfo;
    if (QLog.isColorLevel()) {
      if (localObject1 != null) {
        break label276;
      }
    }
    label276:
    for (paramInt = 0;; paramInt = localObject1.length)
    {
      QLog.d("FriendProfileCardActivity", 2, String.format("qzGoQzoneUserHomeActivity vQzoneCoverInfo=%s length=%s", new Object[] { localObject1, Integer.valueOf(paramInt) }));
      QZoneHelper.a(this, (QZoneHelper.UserInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int, -1, 5, this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession, (byte[])localObject1);
      localObject1 = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject1).c = "1";
      ((QZoneClickReport.ReportInfo)localObject1).jdField_d_of_type_JavaLangString = "0";
      ((QZoneClickReport.ReportInfo)localObject1).jdField_b_of_type_Int = 4;
      ((QZoneClickReport.ReportInfo)localObject1).jdField_k_of_type_JavaLangString = "3";
      ((QZoneClickReport.ReportInfo)localObject1).jdField_l_of_type_JavaLangString = "userSummary";
      ((QZoneClickReport.ReportInfo)localObject1).m = "homePage";
      QZoneClickReport.startReportImediately(this.app.getAccount(), (QZoneClickReport.ReportInfo)localObject1);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("source_type", "3");
      ((HashMap)localObject1).put("source_from", "userSummary");
      ((HashMap)localObject1).put("source_to", "homePage");
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
      return;
    }
  }
  
  protected void e(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("action_cover_pick_gallery", true);
    localIntent.putExtra("PhotoConst.32_Bit_Config", true);
    PhotoUtils.a(localIntent, this, getClass().getName(), ProfileCardUtil.c(this), ProfileCardUtil.d(this), ProfileCardUtil.c(this), ProfileCardUtil.d(this), paramString, ProfileCardUtil.c());
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject = BusinessCardUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    localObject = ProfileCardUtil.a(new Intent(this, FriendProfileMoreInfoActivity.class), this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, (BusinessCard)localObject);
    ((Intent)localObject).putExtra("profile_entry_type", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_h_of_type_Int);
    ((Intent)localObject).putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString);
    ((Intent)localObject).putExtra("memberUin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin);
    ((Intent)localObject).putExtra("isTroopMemberCard", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean);
    startActivityForResult((Intent)localObject, 1022);
    if (paramBoolean)
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8007EB9", "0X8007EB9", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8006A76", "0X8006A76", 0, 0, "", "", "", "");
    ReportController.b(this.app, "dc00898", "", "", "0X8007EB6", "0X8007EB6", 0, 0, "", "", "", "");
  }
  
  public void f()
  {
    boolean bool = false;
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(10);
    PhoneContact localPhoneContact = localPhoneContactManagerImp.c(a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.b(2131435824);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8007015", "0X8007015", 0, 0, "", "", "", "");
      if (localPhoneContact != null) {
        break label210;
      }
    }
    for (;;)
    {
      localActionSheet.c(2131433029);
      localActionSheet.a(new sty(this, localPhoneContactManagerImp, bool, localActionSheet));
      try
      {
        if (!isFinishing()) {
          localActionSheet.show();
        }
        return;
      }
      catch (Exception localException)
      {
        int i1;
        localException.printStackTrace();
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8007167", "0X8007167", 0, 0, "", "", "", "");
      if ((TextUtils.isEmpty(a())) || (localPhoneContact == null)) {
        break;
      }
      if (localPhoneContact.isHiden) {}
      for (i1 = 2131435827;; i1 = 2131435825)
      {
        localActionSheet.b(i1);
        break;
      }
      label210:
      bool = localPhoneContact.isHiden;
    }
  }
  
  void f(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null) && (!this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(getResources().getString(2131439140));
    String str2 = getString(2131430155);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramString = new svt(this, this);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str1, paramString);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramString);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
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
  
  void g()
  {
    if (getIntent().getIntExtra("requestCode", -1) == 1023)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("intent_key_has_ever_vote", this.jdField_h_of_type_Boolean);
      setResult(-1, localIntent);
    }
  }
  
  void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localRedTouchManager.a(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    localRedTouchManager.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0))
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(35);
      if (localRedTouchManager != null) {
        localRedTouchManager.b(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
      }
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  @TargetApi(11)
  void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardLayoutStart", true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initInfoCardCommonLayout");
    }
    Object localObject1 = getResources();
    Object localObject2 = ((Resources)localObject1).getDisplayMetrics();
    int i1 = ((Resources)localObject1).getDimensionPixelSize(2131558448);
    this.jdField_c_of_type_Int = (((Resources)localObject1).getDimensionPixelSize(2131558664) - i1 - (int)(((DisplayMetrics)localObject2).density * 66.0F));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    localObject1 = new FriendProfileCardActivity.ProfileTopGestureLayout(this, this);
    ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject1).setOnFlingGesture(this);
    ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_f_of_type_AndroidViewView = View.inflate(this, 2130970586, null);
    ((FriendProfileCardActivity.ProfileTopGestureLayout)localObject1).addView(this.jdField_f_of_type_AndroidViewView);
    if ((this.jdField_f_of_type_AndroidViewView instanceof PerfRelativeLayout)) {
      ((PerfRelativeLayout)this.jdField_f_of_type_AndroidViewView).setOnDrawCompleteListener(this.jdField_a_of_type_ComTencentMobileqqFpsreportOnDrawCompleteListener);
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131371203);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = ((PullToZoomHeaderListView)this.jdField_f_of_type_AndroidViewView.findViewById(2131363757));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setMotionEventInterceptor(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setOnScrollChangeListener(this.jdField_a_of_type_ComTencentWidgetListView$OnScrollChangeListener);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_e_of_type_AndroidViewView = new View(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.addFooterView(this.jdField_e_of_type_AndroidViewView);
    this.jdField_c_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131371207);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131363262));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131363447));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131494194));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131363493));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131363400));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_f_of_type_AndroidViewView.findViewById(2131363398));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMusicPendantView = ((MusicPendantView)this.jdField_f_of_type_AndroidViewView.findViewById(2131371204));
    c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)this.jdField_f_of_type_AndroidViewView.findViewById(2131371206));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.forbiddenLayer();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFitFullScreenXY();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2130970551, null);
      localObject2 = View.inflate(this, 2130970547, null);
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.addHeaderView((View)localObject2);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((View)localObject2).findViewById(2131371022));
      localObject2 = new DataTag(29, null);
      this.jdField_a_of_type_AndroidViewViewGroup.setTag(localObject2);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371023);
      if (localObject2 != null) {}
      try
      {
        localObject2 = (Animatable)((ImageView)localObject2).getDrawable();
        if (!((Animatable)localObject2).isRunning()) {
          ((Animatable)localObject2).start();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = ((ProfileCardMoreInfoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371035));
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.app, this, this.jdField_q_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.addOnLayoutChangeListener(new sud(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_d_of_type_Boolean = this.jdField_j_of_type_Boolean;
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371036));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131371205));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131364173));
        a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "initContentView add timeout msg");
          }
          localObject2 = this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(10);
          this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed((Message)localObject2, 10000L);
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView = ((ShakeImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131371201));
        this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView = ((ShakeImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131371202));
        this.jdField_d_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131371199);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout = ((SingleTouchLayout)this.jdField_f_of_type_AndroidViewView.findViewById(2131371200));
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(false);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setMovable(false);
        this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setAdapter(new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView));
        super.setContentView((View)localObject1);
        localObject1 = (FrameLayout)findViewById(16908290);
        if (localObject1 != null) {
          ((FrameLayout)localObject1).setBackgroundResource(2130843071);
        }
        X();
        c(null);
        this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardLayoutEnd", "initCardLayoutStart", false);
        return;
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void k()
  {
    if ((this.app == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {}
    int i1;
    do
    {
      return;
      if (!ColorScreenManager.jdField_a_of_type_Boolean)
      {
        QLog.i("ColorScreenManager", 1, "ColorScreenManager.sEnable is false, loadColorScreen fail.");
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      i1 = ((SVIPHandler)this.app.a(13)).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.i("ColorScreenManager", 2, "loadColorScreen " + i1 + " mLastColorScreen " + this.jdField_d_of_type_Int);
      }
      if ((i1 > 0) && (i1 != this.jdField_d_of_type_Int)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ColorScreenManager", 2, "loadColorScreen early return");
    return;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_d_of_type_Int = i1;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin())) {}
    for (Object localObject = "1";; localObject = "2")
    {
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "Bubble", "ShowEffect", (String)localObject, 1, 0, 0, null, Integer.toString(i1), null);
      localObject = ((VasExtensionManager)this.app.getManager(234)).jdField_a_of_type_ComTencentMobileqqFloatscrColorScreenManager;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader = new FriendProfileCardActivity.ColorScreenLoader(this, i1);
      ((ColorScreenManager)localObject).a(i1, VasManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader));
      return;
    }
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_d_of_type_JavaLangString))) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53));
      if ((this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler != null) && (this.app != null) && (this.jdField_f_of_type_AndroidViewView != null) && ((this.jdField_f_of_type_AndroidViewView instanceof RelativeLayout)) && (ApolloManager.a(this, Boolean.valueOf(false)))) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
    return;
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_Swi, 16);
    ThreadManager.excute(this.jdField_a_of_type_Swi, 16, null, true);
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("onSendFailed activity=%s", new Object[] { this }));
    }
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    I();
    a("上传失败", 1);
  }
  
  public void n()
  {
    Object localObject = getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    int i4 = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    int i1;
    int i2;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getHeight();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
        break label255;
      }
      i2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getHeight();
      label58:
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label260;
      }
    }
    label260:
    for (int i3 = ((Resources)localObject).getDimensionPixelOffset(2131558671);; i3 = 0)
    {
      i3 += ((Resources)localObject).getDimensionPixelSize(2131558670);
      int i5 = Math.min(Math.max(i4 - i2 - i1, i3), i4 / 3);
      localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131371037);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updatePlaceHolder mScreenHeight=" + i4 + ",moreInfoViewHeight=" + i1 + ",headerViewHeight=" + i2 + ",minHeight=" + i3 + ",placeHolderViewHeight=" + i5);
      }
      if (localObject != null)
      {
        ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, i5));
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
          break label265;
        }
        ProfileCardTemplate.a((View)localObject, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
      }
      return;
      i1 = 0;
      break;
      label255:
      i2 = 0;
      break label58;
    }
    label265:
    ((View)localObject).setBackgroundResource(0);
  }
  
  public void o()
  {
    Intent localIntent = new Intent(this, VipProfileCardDiyActivity.class);
    localIntent.putExtra("extra_from", 1);
    localIntent.putExtra("extra_card_id", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId);
    localIntent.putExtra("extra_card_url", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.backgroundUrl);
    localIntent.putExtra("extra_card_default_text", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyDefaultText);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyText)) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId > 0))
    {
      localIntent.putExtra("extra_card_text", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyText);
      localIntent.putExtra("extra_card_font", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextFontId);
      localIntent.putExtra("extra_card_x", this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a().x);
      localIntent.putExtra("extra_card_y", this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.a().y);
      localIntent.putExtra("extra_card_scale", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextScale);
      localIntent.putExtra("extra_card_rotation", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextDegree);
      localIntent.putExtra("extra_card_transparency", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyTextTransparency);
    }
    startActivityForResult(localIntent, 600001);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 10000) {
      if ((MusicPendantManager.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53)) {
        MusicPendantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this);
      }
    }
    while ((paramInt1 != 4097) || (paramInt2 != 8193)) {
      return;
    }
    this.jdField_j_of_type_Boolean = true;
    a(0L, null, null, false);
    setResult(8193);
  }
  
  protected boolean onBackEvent()
  {
    N();
    g();
    Q();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil = new TimeTraceUtil();
      this.jdField_c_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = false;
      this.jdField_g_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
      {
        Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
        if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          localMessage.what = 1;
          localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
        }
      }
    }
  }
  
  public void p()
  {
    Object localObject2;
    Object localObject1;
    String str1;
    label104:
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 40) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58))
    {
      localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
      localObject1 = "qita";
      String str2 = "0";
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        break label581;
      }
      str1 = IndividuationUrlHelper.a("vipPersonalCardMaster");
      if (!this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        str2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      localStringBuilder = new StringBuilder(str1);
      if (!str1.contains("?")) {
        break label592;
      }
      localStringBuilder.append("&platform=1");
      label170:
      localStringBuilder.append("&qq=" + str2);
      localStringBuilder.append("&adtag=" + (String)localObject1);
      localStringBuilder.append("&aid=" + (String)localObject2);
      localObject1 = localStringBuilder.toString();
      long l1 = System.currentTimeMillis();
      if (ProfileActivity.a(this.jdField_g_of_type_Long, l1))
      {
        this.jdField_g_of_type_Long = l1;
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
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label604;
        }
      }
    }
    label581:
    label592:
    label604:
    for (int i1 = 23;; i1 = 24)
    {
      ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "vip", "logo_in", i1, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
        localObject1 = "geren";
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21))
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
        localObject1 = "qun";
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46)
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
        localObject1 = "taolunzu";
        break;
      }
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
        localObject1 = "qita";
        break;
      }
      localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
      localObject1 = "qita";
      break;
      str1 = IndividuationUrlHelper.a("vipPersonalCardCustom");
      break label104;
      localStringBuilder.append("?platform=1");
      break label170;
    }
  }
  
  public void q()
  {
    long l1 = System.currentTimeMillis();
    if (ProfileActivity.a(this.jdField_h_of_type_Long, l1))
    {
      this.jdField_h_of_type_Long = l1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoXmanWeb() url = " + "http://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297");
        }
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject).putExtra("url", "http://ti.qq.com/xman/self.html?_wv=1027&adtag=card&_bid=297");
        ((Intent)localObject).putExtra("hide_more_button", true);
        startActivity((Intent)localObject);
        ReportController.b(this.app, "CliOper", "", "", "0X8004880", "0X8004880", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    Object localObject = String.format("http://ti.qq.com/xman/view.html?_wv=1027&uin=%s&_bid=297", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString });
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.app.getCurrentAccountUin());
    localIntent.putExtra("url", (String)localObject);
    localIntent.putExtra("hide_more_button", true);
    startActivity(localIntent);
    ReportController.b(this.app, "CliOper", "", "", "0X800489C", "0X800489C", 0, 0, "", "", "", "");
  }
  
  public void r()
  {
    long l1 = System.currentTimeMillis();
    if (ProfileActivity.a(this.jdField_h_of_type_Long, l1))
    {
      this.jdField_h_of_type_Long = l1;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lightalkNick != null))
      {
        String str = Base64Util.encodeToString(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lightalkNick.getBytes(), 0);
        str = String.format("http://ti.qq.com/lightalk/info.html?_wv=1027&uin=%s&nick=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lightalkId, str });
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoLightalkWeb() url = " + str);
        }
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("uin", this.app.getCurrentAccountUin());
        localIntent.putExtra("url", str);
        localIntent.putExtra("hide_more_button", true);
        startActivity(localIntent);
        ReportController.b(this.app, "CliOper", "", "", "0X800510A", "0X800510A", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void s()
  {
    Intent localIntent = new Intent(this, QRDisplayActivity.class);
    String str = this.app.getCurrentAccountUin();
    localIntent.putExtra("title", getString(2131430002));
    localIntent.putExtra("nick", ContactUtils.j(this.app, str));
    localIntent.putExtra("uin", str);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("reportFlag", 1);
    startActivity(localIntent);
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_b_of_type_Boolean)
    {
      W();
      return;
    }
    b(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
  }
  
  public void u()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    String str2 = this.app.getCurrentNickname();
    String str1 = str2;
    if (StringUtil.a(str2)) {
      str1 = this.app.getCurrentNickname();
    }
    localUserInfo.jdField_b_of_type_JavaLangString = str1;
    QZoneHelper.a(this, localUserInfo, Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)), 1, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int, -1, this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      runOnUiThread(new sux(this));
    }
  }
  
  public void v()
  {
    ThreadManager.post(new suu(this), 8, null, true);
  }
  
  public void w()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.b();
    }
  }
  
  void x()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_g_of_type_Int == 100) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.getCurrentAccountUin()))) {
      startUnlockActivity();
    }
  }
  
  public void y()
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
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131433311) + "(99+)");
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131433311) + "(" + i1 + ")");
    return;
    label105:
    getIntent().putExtra("leftViewText", getString(2131433311));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131433311));
  }
  
  public void z()
  {
    for (;;)
    {
      try
      {
        FrameLayout localFrameLayout = (FrameLayout)findViewById(16908290);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) {
          break label533;
        }
        localFrameLayout.setForeground(null);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.l == ProfileCardTemplate.jdField_j_of_type_Long)
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView.setVisibility(0);
          if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView.setImage(this.jdField_a_of_type_AndroidGraphicsBitmap, (int)(this.jdField_f_of_type_AndroidViewView.getWidth() * 1.1D), (int)(this.jdField_f_of_type_AndroidViewView.getHeight() * 1.1D), 1.0F);
          }
          this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView.setVisibility(0);
          if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
            this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView.setImage(this.jdField_b_of_type_AndroidGraphicsBitmap, (int)(this.jdField_f_of_type_AndroidViewView.getWidth() * 1.1D), (int)(this.jdField_f_of_type_AndroidViewView.getHeight() * 1.1D), -1.0F);
          }
          localFrameLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          T();
          ProfileCardTemplate.a(this.jdField_a_of_type_AndroidViewView, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "background");
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == ProfileCardTemplate.jdField_h_of_type_Long)
          {
            ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "shoppingUserInfoBackground");
            if (Build.VERSION.SDK_INT >= 11)
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_f_of_type_Long) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.jdField_h_of_type_Long)) || (!(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof FriendProfileCardBgDrawable))) {
                break label489;
              }
              ThreadManager.post(new swa(this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), 5, null, true);
            }
            if (!ThemeUtil.isInNightMode(this.app)) {
              break label514;
            }
            if (this.jdField_c_of_type_AndroidViewView != null) {
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "update item style");
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList);
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.b();
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView.setVisibility(8);
          this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView.setVisibility(8);
          continue;
        }
        ProfileCardTemplate.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateTheme exception msg=" + localException.getMessage());
        }
        localException.printStackTrace();
        return;
      }
      continue;
      label489:
      View localView = localException.getChildAt(0);
      if ((localView != null) && (localView.getBackground() != null))
      {
        localView.setBackgroundDrawable(null);
        continue;
        label514:
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          continue;
          label533:
          localView.setForeground(getResources().getDrawable(2130845954));
          localView.setBackgroundResource(2130843071);
          this.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundResource(0);
          if (this.jdField_c_of_type_AndroidViewView != null) {
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
          {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
          }
          else
          {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */
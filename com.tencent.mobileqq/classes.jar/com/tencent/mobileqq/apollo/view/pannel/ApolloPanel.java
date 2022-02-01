package com.tencent.mobileqq.apollo.view.pannel;

import ahzc;
import amma;
import amme;
import ammr;
import amms;
import ammt;
import amna;
import amnb;
import amrk;
import anch;
import anck;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anka;
import ankc;
import anlw;
import anmk;
import anml;
import anmm;
import anmx;
import annl;
import annm;
import anoa;
import anob;
import anok;
import anol;
import anom;
import anon;
import anoo;
import anop;
import anoq;
import anor;
import anos;
import anot;
import anou;
import anov;
import anow;
import anoz;
import anpa;
import anpb;
import anpc;
import anpd;
import anpe;
import anph;
import anpi;
import anpj;
import anpo;
import anpp;
import anpr;
import anpt;
import anpu;
import anqe;
import anqh;
import bbbq;
import bhdj;
import bhhy;
import bhnm;
import bhow;
import bkyc;
import blhb;
import blhc;
import blhd;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.QZoneVipInfoManager;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class ApolloPanel
  extends RelativeLayout
  implements Handler.Callback, ViewPager.OnPageChangeListener, View.OnClickListener, AdapterView.OnItemClickListener, anmm
{
  public static int a;
  public static boolean a;
  public static int b;
  private long jdField_a_of_type_Long;
  private ammr jdField_a_of_type_Ammr = new anov(this);
  private ammt jdField_a_of_type_Ammt;
  private amna jdField_a_of_type_Amna;
  public amnb a;
  public DialogInterface.OnClickListener a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  anml jdField_a_of_type_Anml = new anoo(this);
  private anob jdField_a_of_type_Anob;
  public anpe a;
  private anpj jdField_a_of_type_Anpj = new anow(this);
  anpo jdField_a_of_type_Anpo;
  private anpr jdField_a_of_type_Anpr = new anot(this);
  anpu jdField_a_of_type_Anpu;
  public anqe a;
  private bhow jdField_a_of_type_Bhow;
  public blhb a;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DrawerPushItem jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  public SessionInfo a;
  public BaseChatPie a;
  ApolloPanelAdapter jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter;
  private ApolloPanelGuideView jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView;
  private KapuPkgStateReceiver jdField_a_of_type_ComTencentMobileqqApolloViewPannelKapuPkgStateReceiver;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ApolloPanel.26(this);
  private Deque<anpi> jdField_a_of_type_JavaUtilDeque;
  public List<anqh> a;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this, true);
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public LinearLayout b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  private anpr jdField_b_of_type_Anpr = new anou(this);
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_b_of_type_Boolean;
  public int c;
  public RelativeLayout c;
  private anpr jdField_c_of_type_Anpr = this.jdField_a_of_type_Anpr;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  public List<Integer> c;
  private boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  private URLImageView jdField_d_of_type_ComTencentImageURLImageView;
  private boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean;
  public int f;
  private boolean f;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int = -1;
  private boolean jdField_k_of_type_Boolean = true;
  private int jdField_l_of_type_Int = -1;
  private boolean jdField_l_of_type_Boolean;
  private boolean m;
  private boolean n;
  private boolean o;
  
  static
  {
    jdField_b_of_type_Int = 0;
  }
  
  public ApolloPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new anoq(this);
    this.jdField_a_of_type_Amnb = new anor(this);
    this.jdField_f_of_type_Int = 1;
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new anoq(this);
    this.jdField_a_of_type_Amnb = new anor(this);
    this.jdField_f_of_type_Int = 1;
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[checkInitGuidePage]");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView = ((ApolloPanelGuideView)LayoutInflater.from(super.getContext()).inflate(2131558684, null));
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setClickCallback(this.jdField_a_of_type_Anpj);
      addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView, -1, -1);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.bringToFront();
  }
  
  private void B()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.getParent() == this))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[hideGuidePageFor3D] remove");
      }
      super.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView = null;
      jdField_b_of_type_Int = 0;
    }
  }
  
  /* Error */
  private void C()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 191
    //   4: iconst_1
    //   5: iconst_2
    //   6: anewarray 250	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 252
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_0
    //   17: getfield 254	com/tencent/mobileqq/apollo/view/pannel/ApolloPanel:jdField_i_of_type_Boolean	Z
    //   20: invokestatic 260	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   23: aastore
    //   24: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: getfield 254	com/tencent/mobileqq/apollo/view/pannel/ApolloPanel:jdField_i_of_type_Boolean	Z
    //   31: istore_1
    //   32: iload_1
    //   33: ifeq +6 -> 39
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: aload_0
    //   40: invokespecial 200	android/widget/RelativeLayout:getContext	()Landroid/content/Context;
    //   43: astore_2
    //   44: aload_0
    //   45: aload_2
    //   46: invokestatic 268	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Landroid/content/Context;)Z
    //   49: putfield 270	com/tencent/mobileqq/apollo/view/pannel/ApolloPanel:jdField_j_of_type_Boolean	Z
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 254	com/tencent/mobileqq/apollo/view/pannel/ApolloPanel:jdField_i_of_type_Boolean	Z
    //   57: aload_0
    //   58: aload_0
    //   59: invokespecial 273	com/tencent/mobileqq/apollo/view/pannel/ApolloPanel:a	()Lcom/tencent/mobileqq/apollo/view/pannel/KapuPkgStateReceiver;
    //   62: putfield 275	com/tencent/mobileqq/apollo/view/pannel/ApolloPanel:jdField_a_of_type_ComTencentMobileqqApolloViewPannelKapuPkgStateReceiver	Lcom/tencent/mobileqq/apollo/view/pannel/KapuPkgStateReceiver;
    //   65: new 277	android/content/IntentFilter
    //   68: dup
    //   69: invokespecial 278	android/content/IntentFilter:<init>	()V
    //   72: astore_3
    //   73: aload_3
    //   74: ldc_w 280
    //   77: invokevirtual 284	android/content/IntentFilter:addDataScheme	(Ljava/lang/String;)V
    //   80: aload_3
    //   81: ldc_w 286
    //   84: invokevirtual 289	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   87: aload_3
    //   88: ldc_w 291
    //   91: invokevirtual 289	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   94: aload_2
    //   95: aload_0
    //   96: getfield 275	com/tencent/mobileqq/apollo/view/pannel/ApolloPanel:jdField_a_of_type_ComTencentMobileqqApolloViewPannelKapuPkgStateReceiver	Lcom/tencent/mobileqq/apollo/view/pannel/KapuPkgStateReceiver;
    //   99: aload_3
    //   100: invokevirtual 297	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   103: pop
    //   104: goto -68 -> 36
    //   107: astore_2
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_2
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	ApolloPanel
    //   31	2	1	bool	boolean
    //   43	52	2	localContext	Context
    //   107	4	2	localObject	Object
    //   72	28	3	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   2	32	107	finally
    //   39	104	107	finally
  }
  
  private void D()
  {
    try
    {
      if ((this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelKapuPkgStateReceiver != null))
      {
        super.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelKapuPkgStateReceiver);
        this.jdField_i_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelKapuPkgStateReceiver = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int a(List<anqh> paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt >= paramList.size())) {
      throw new IllegalArgumentException("packageBinderList is null or tabIndex is out");
    }
    int i2 = 0;
    int i1 = 0;
    if (i2 < paramInt)
    {
      anqh localanqh = (anqh)paramList.get(i2);
      if (localanqh == null) {
        break label73;
      }
      i1 = localanqh.a() + i1;
    }
    label73:
    for (;;)
    {
      i2 += 1;
      break;
      return i1;
    }
  }
  
  private amrk a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      return null;
    }
    amma localamma = (amma)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
    amrk localamrk = localamma.a();
    if (localamrk.jdField_a_of_type_Int != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[checkJumpToGameTab] checkGameTab jumpGameId:", Integer.valueOf(localamrk.jdField_a_of_type_Int), ",from:", Integer.valueOf(localamrk.jdField_b_of_type_Int), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      }
      if (!this.jdField_b_of_type_Boolean) {
        localamma.a(-1, -1);
      }
      return localamrk;
    }
    return null;
  }
  
  @NotNull
  private bhow a()
  {
    return new anok(this);
  }
  
  @NotNull
  private KapuPkgStateReceiver a()
  {
    return new KapuPkgStateReceiver(new anpb(this));
  }
  
  private void a(amme paramamme)
  {
    paramamme = paramamme.a();
    if ((paramamme != null) && (paramamme.size() > 0))
    {
      paramamme = paramamme.iterator();
      while (paramamme.hasNext())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)paramamme.next();
        if ((localApolloActionData != null) && (localApolloActionData.isForPlayerAction != 0)) {
          a(localApolloActionData);
        }
      }
    }
  }
  
  private void a(View paramView, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (paramView == null) || (paramString == null)) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Blhb != null)
        {
          if (this.jdField_a_of_type_JavaUtilDeque == null) {
            this.jdField_a_of_type_JavaUtilDeque = new LinkedList();
          }
          this.jdField_a_of_type_JavaUtilDeque.addLast(new anpi(paramView, paramInt1, paramString, paramInt2, paramOnClickListener));
          return;
        }
        paramString = blhb.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity).b(paramInt2).a(paramString).a(16.0F).a(-1);
        paramString.c(paramInt1);
        paramString = new blhd(paramString).b(Color.argb(255, 0, 0, 0)).a(5).a();
      } while (paramString == null);
      this.jdField_a_of_type_Blhb = paramString.a();
    } while (this.jdField_a_of_type_Blhb == null);
    this.jdField_a_of_type_Blhb.a(82);
    this.jdField_a_of_type_Blhb.c(2);
    this.jdField_a_of_type_Blhb.a(paramView);
    this.jdField_a_of_type_Blhb.a(paramOnClickListener);
    this.jdField_a_of_type_Blhb.setOnDismissListener(new anpc(this));
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[realshowNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", pkgId=", Integer.valueOf(paramInt3), ", extra=", paramBundle });
    }
    w();
    this.jdField_a_of_type_Anob = new anob(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this, this.jdField_a_of_type_Anpe);
    this.jdField_a_of_type_Anob.a(paramApolloActionData, paramInt1, paramInt2, paramInt3, paramBundle);
    this.jdField_k_of_type_Boolean = false;
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.29(this, paramAppInfo, paramString));
  }
  
  private void a(List<anqh> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (paramList == null) || (paramList1 == null)) {
      return;
    }
    this.jdField_c_of_type_Anpr.a(paramList, paramList1, paramBoolean);
  }
  
  private boolean a(String paramString)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      bool = false;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin(), 0).getInt(paramString, 0) == 1) {
      return bool;
    }
    return false;
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      return amme.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    }
    return false;
  }
  
  private int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      return ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
    }
    return 0;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Anqe = new anqe(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Anqe.b(paramInt2);
    this.jdField_a_of_type_Anqe.a(this);
    if (paramInt1 == 0) {
      this.jdField_a_of_type_Anqe.a(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func showApolloPanel begins. Thread id = " + Thread.currentThread().getId());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Anqe);
      v();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin(), 0).edit().putInt(paramString, 1).apply();
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] actionId=", Integer.valueOf(paramInt1), ", pkgId=", Integer.valueOf(paramInt2) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      QLog.w("ApolloPanel", 1, "[showNewActionFloatView] app null, abort");
    }
    ApolloActionData localApolloActionData;
    do
    {
      return;
      Object localObject = (ankc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      localApolloActionData = ((ankc)localObject).a(paramInt1);
      if (localApolloActionData == null)
      {
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] no action info, abort");
        return;
      }
      boolean bool2 = ((ankc)localObject).b(paramInt1);
      if ((((ankc)localObject).c(paramInt1)) || (localApolloActionData.feeType == 1)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] isObtained=", Boolean.valueOf(bool2), ", isFree=", Boolean.valueOf(bool1), ", feeType=", Integer.valueOf(localApolloActionData.feeType) });
        }
        if (!bool1) {
          break;
        }
        a(localApolloActionData, 0, 20, paramInt2, null);
        return;
      }
      if (localApolloActionData.feeType == 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(new anos(this, localApolloActionData, paramInt2));
        ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(localApolloActionData.actionId, null, null, 0, 0.0F, 0, "newActionFloatView");
        return;
      }
      if (localApolloActionData.feeType == 2)
      {
        if (localApolloActionData.currencyType == 1)
        {
          if (bool2)
          {
            a(localApolloActionData, 0, 23, paramInt2, null);
            return;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putInt("pkgId", paramInt2);
          a(localApolloActionData, 2, 23, paramInt2, (Bundle)localObject);
          return;
        }
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] currency type not gold, abort");
        return;
      }
      if (localApolloActionData.feeType == 9)
      {
        if (((amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin()))
        {
          a(localApolloActionData, 0, 28, paramInt2, null);
          return;
        }
        a(localApolloActionData, 4, 27, paramInt2, null);
        return;
      }
      if (localApolloActionData.feeType == 10)
      {
        if (ApolloUtil.a(super.getContext()))
        {
          a(localApolloActionData, 0, 20, paramInt2, null);
          return;
        }
        if ((amms.jdField_a_of_type_Boolean) && (b()) && (!TextUtils.isEmpty(amms.jdField_b_of_type_JavaLangString)))
        {
          a(localApolloActionData, 5, 29, paramInt2, null);
          return;
        }
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] 3d entrance not show");
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] not support yet, feeType=", Integer.valueOf(localApolloActionData.feeType) });
  }
  
  private void f(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      return;
    }
    this.jdField_c_of_type_Anpr.a(paramInt);
  }
  
  private void g(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      return;
    }
    int i2 = c();
    int i1 = i2;
    if (paramInt != 0)
    {
      i1 = i2;
      if (paramInt != i2) {
        i1 = paramInt;
      }
    }
    paramInt = i1;
    if (i1 == 2)
    {
      paramInt = i1;
      if (!b()) {
        paramInt = 1;
      }
    }
    h(paramInt);
  }
  
  private void h(int paramInt)
  {
    if ((this.jdField_f_of_type_Int != paramInt) && (QLog.isColorLevel())) {
      QLog.d("ApolloPanel", 2, new Object[] { "setCurrentPanelType targetPanelType=", Integer.valueOf(paramInt) });
    }
    this.jdField_f_of_type_Int = paramInt;
    if (this.jdField_f_of_type_Int == 2)
    {
      this.jdField_c_of_type_Anpr = this.jdField_b_of_type_Anpr;
      return;
    }
    this.jdField_c_of_type_Anpr = this.jdField_a_of_type_Anpr;
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      return;
    }
    this.jdField_a_of_type_Bhow = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(this.jdField_a_of_type_Bhow);
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[initData]");
    }
    k();
  }
  
  private void v()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[hideNewActionFloatView]");
    }
    if (this.jdField_a_of_type_Anob != null)
    {
      this.jdField_a_of_type_Anob.a();
      this.jdField_a_of_type_Anob = null;
    }
  }
  
  private void x()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 500L);
  }
  
  private void y()
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.30(this));
  }
  
  private void z()
  {
    if (getVisibility() == 0)
    {
      if (!this.jdField_a_of_type_Ammt.b()) {
        break label44;
      }
      QLog.d("ApolloPanel", 2, "showGuidePageFor3D for json");
      this.m = true;
      this.jdField_a_of_type_Ammt.b(false);
      q();
    }
    label44:
    while (!this.jdField_a_of_type_Ammt.a()) {
      return;
    }
    QLog.d("ApolloPanel", 2, "showGuidePageFor3D for action");
    this.m = true;
    this.jdField_a_of_type_Ammt.a(false);
    q();
  }
  
  public int a()
  {
    return this.jdField_i_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int i4 = 0;
    int i3 = i4;
    int i1;
    int i2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i3 = i4;
      if (paramInt > 0)
      {
        i1 = 0;
        i2 = 0;
      }
    }
    for (;;)
    {
      i3 = i4;
      if (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        i2 += ((anqh)this.jdField_a_of_type_JavaUtilList.get(i1)).a();
        if (paramInt < i2) {
          i3 = i1;
        }
      }
      else
      {
        return i3;
      }
      i1 += 1;
    }
  }
  
  public anqh a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "getViewBinder type=" + paramInt);
    }
    return this.jdField_c_of_type_Anpr.a(paramInt);
  }
  
  public HorizontalListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
  }
  
  public void a()
  {
    VasExtensionHandler localVasExtensionHandler;
    int i1;
    anpd localanpd;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
    {
      localVasExtensionHandler = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
      localVasExtensionHandler.a(1, "actionPanel", null);
      i1 = ((amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).jdField_a_of_type_Int;
      localanpd = new anpd(this, i1);
      if (2 != i1) {
        break label88;
      }
      localVasExtensionHandler.a("actionPanel", 1, localanpd);
    }
    label88:
    while (1 != i1) {
      return;
    }
    localVasExtensionHandler.a("actionPanel", 0, localanpd);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "actionpanel onOpen");
    }
    this.jdField_i_of_type_Int = -1;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        anqh localanqh = (anqh)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((localanqh.jdField_c_of_type_Int == 100) && ((localanqh instanceof anpu)) && (((anpu)localanqh).a != null) && (((anpu)localanqh).a.gameId == paramInt2)) {
          ((anpu)localanqh).a(paramInt1);
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, ApolloPanel paramApolloPanel)
  {
    if (((paramInt1 == 21) || (paramInt2 == 21)) && (paramApolloPanel != null))
    {
      paramApolloPanel = a(100);
      if ((paramApolloPanel != null) && ((paramApolloPanel instanceof anpu)))
      {
        paramApolloPanel = (anpu)paramApolloPanel;
        if (paramInt1 != 21) {
          break label86;
        }
        paramApolloPanel.c();
      }
    }
    for (;;)
    {
      boolean bool = false;
      if (paramInt2 == 21) {
        bool = true;
      }
      paramApolloPanel = anck.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
      if (paramApolloPanel != null) {
        paramApolloPanel.a().jdField_b_of_type_Boolean = bool;
      }
      return;
      label86:
      paramApolloPanel.d();
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if ((this.jdField_a_of_type_Anpo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
    {
      Object localObject = this.jdField_a_of_type_Anpo.a();
      if (((List)localObject).size() > paramInt)
      {
        localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] packageId=", Integer.valueOf(((ApolloActionPackage)localObject).packageId), ", tabIndex= ", Integer.valueOf(paramInt), ", isUpdate=", Boolean.valueOf(((ApolloActionPackage)localObject).isUpdate), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
        }
        if ((((ApolloActionPackage)localObject).packageId == 8) && (!((ApolloActionPackage)localObject).isRecommendTabClick))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin(), 0).edit().putBoolean("apollo_sp_key_recommend_tab_click", true).commit();
          ((ApolloActionPackage)localObject).isRecommendTabClick = true;
          ((anpp)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
        if ((((ApolloActionPackage)localObject).isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= ((ApolloActionPackage)localObject).redStartTime))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "clear tab red packageId=" + ((ApolloActionPackage)localObject).packageId + " tabIndex = " + paramInt);
          }
          ((anpp)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          ((ApolloActionPackage)localObject).isUpdate = false;
          paramInt = ((ApolloActionPackage)localObject).redFlowId;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] pkg=", Integer.valueOf(((ApolloActionPackage)localObject).packageId), ", new action id=", Integer.valueOf(paramInt) });
          }
          ThreadManager.post(new ApolloPanel.23(this, (ApolloActionPackage)localObject), 5, null, true);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] mShouldShowActionFloatView=", Boolean.valueOf(this.jdField_k_of_type_Boolean), ", mIsTriggeredByClick=", Boolean.valueOf(this.jdField_e_of_type_Boolean) });
          }
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
          if ((this.jdField_k_of_type_Boolean) && (paramInt != 0))
          {
            paramView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
            paramView.arg1 = paramInt;
            paramView.getData().putInt("pkgId", ((ApolloActionPackage)localObject).packageId);
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramView, 800L);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "auth_finish");
    }
    post(new ApolloPanel.16(this, paramString, paramInt));
  }
  
  public void a(annl paramannl)
  {
    int i3 = 0;
    if ((paramannl == null) || (paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null)) {}
    int i2;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      int i1 = 0;
      i2 = i3;
      if (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject1 = (anqh)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (((anqh)localObject1).jdField_a_of_type_JavaUtilList == null) {}
        while (((anqh)localObject1).jdField_c_of_type_Int != 2)
        {
          i1 += 1;
          break;
        }
        Object localObject2;
        if (((anqh)localObject1).jdField_b_of_type_Int != 5)
        {
          ((anqh)localObject1).b(5);
          localObject2 = new annl();
          ((annl)localObject2).jdField_b_of_type_Int = 2;
          ApolloActionData localApolloActionData = new ApolloActionData();
          localApolloActionData.actionName = super.getResources().getString(2131690060);
          ((annl)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
          ((anqh)localObject1).jdField_a_of_type_JavaUtilList.add(0, localObject2);
        }
        localObject1 = ((anqh)localObject1).jdField_a_of_type_JavaUtilList;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
        {
          localObject2 = (ankc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
          paramannl.jdField_g_of_type_Int = anlw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramannl, paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
        }
        ((List)localObject1).add(1, paramannl);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "add action to fav action " + paramannl.toString());
        }
        i2 = 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter != null) && (i2 != 0))
      {
        a(jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.notifyDataSetChanged();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (i2 != 0));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin());
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initPanel] jumpPkdId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    paramBaseChatPie = (amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER);
    if (paramBaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin()) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[initPanel] apollo status open, remember jump info");
      }
      this.jdField_h_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = paramInt2;
    }
    this.jdField_i_of_type_Int = paramInt3;
    paramBaseChatPie.a(this.jdField_a_of_type_Ammr);
    this.jdField_a_of_type_Ammt = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131363177));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363952));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365131));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365130));
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363928));
    this.jdField_c_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363823));
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363824));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_d_of_type_ComTencentImageURLImageView.getParent());
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131363922));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362774));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)super.findViewById(2131362823));
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    Drawable localDrawable = super.getContext().getResources().getDrawable(2130838644);
    paramSessionInfo.addState(new int[] { 16842919 }, localDrawable);
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    localDrawable = super.getContext().getResources().getDrawable(2130838643);
    paramSessionInfo.addState(new int[] { -16842919 }, localDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131362824));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter = new ApolloPanelAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131378395));
    this.jdField_a_of_type_Anpo = new anpo(super.getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Anpo);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    super.findViewById(2131378391).setBackgroundColor(super.getContext().getResources().getColor(2131165635));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131370478));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362818));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362817));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362816));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362765));
    this.jdField_a_of_type_Amna = paramBaseChatPie.a();
    if (this.jdField_a_of_type_Amna != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_Amna.a.get()));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(super.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout).b(5).a();
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = ((bbbq)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(String.valueOf("103100.103200.103250"));
      paramBaseChatPie = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
      if (paramBaseChatPie != null) {
        paramBaseChatPie.a(100);
      }
      QZoneVipInfoManager.preloadQZoneProcess(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
      paramBaseChatPie = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin(), 0);
      if ((paramBaseChatPie.getBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin(), false)) && (this.jdField_i_of_type_Int != 7))
      {
        paramBaseChatPie.edit().putBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin(), false).commit();
        paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getHandler(ChatActivity.class);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.obtainMessage(51).sendToTarget();
        }
      }
      if (amme.jdField_a_of_type_Boolean)
      {
        QLog.d("ApolloPanel", 1, "[initPanel] getUserApolloInfo");
        this.jdField_b_of_type_Boolean = true;
        ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin(), 1082392704, "Open Panel");
        amme.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_Amna != null) {
        this.jdField_a_of_type_Amna.a(null);
      }
      paramBaseChatPie = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((paramBaseChatPie == null) || (!paramBaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getSessionInfo().curFriendUin))) {
        break label1077;
      }
    }
    label1077:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_Boolean = bool;
      setBackgroundColor(super.getResources().getColor(2131165637));
      u();
      t();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "init panel done");
      }
      return;
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    QLog.d("ApolloPanel", 4, "ApolloPanel handleCMSPlayerGetFrame : " + paramApolloActionData.toString());
    amme localamme = (amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER);
    if (localamme != null) {
      localamme.a("apolloPanel", paramApolloActionData, new anph(this.jdField_a_of_type_JavaUtilList, paramApolloActionData));
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, boolean paramBoolean)
  {
    ThreadManager.post(new ApolloPanel.28(this, paramAppInfo, paramBoolean, paramString), 5, null, true);
  }
  
  public void a(String paramString)
  {
    a(paramString, false, false);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString5))) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "showAidDialog title=" + paramString2 + " content=" + paramString3 + "rightString=" + paramString4 + " url=" + paramString5);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null);
    n();
    int i1;
    if ("onlyRightType".equals(paramString5))
    {
      i1 = 1;
      paramString1 = new anol(this);
      label136:
      paramString6 = super.getResources().getString(2131694777);
      if (i1 == 0) {
        break label399;
      }
    }
    label399:
    for (paramString5 = null;; paramString5 = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, 0, paramString2, paramString3, paramString6, paramString4, paramString1, paramString5);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.isFinishing())) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if ("moreInfo".equals(paramString5))
      {
        paramString1 = new anom(this, paramString7);
        i1 = 0;
        break label136;
      }
      if ("requestSSO".equals(paramString5))
      {
        paramString1 = new anon(this, paramString1, paramString7, paramString8);
        i1 = 0;
        break label136;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(String.valueOf(9))))
      {
        ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, paramString7, paramString9);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "vip_alert_view", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { "" + paramString7, "0" });
        return;
      }
      paramString1 = new anop(this, paramString5, paramString6, paramString7, paramString1, paramString9);
      i1 = 0;
      break label136;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] refreshByGetUserAction=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      QLog.e("ApolloPanel", 1, "[initPanelData] mBaseChatPie or mBaseChatPie.app is null");
    }
    ArrayList localArrayList2;
    ankc localankc;
    List localList;
    do
    {
      do
      {
        return;
        new ArrayList();
        localArrayList2 = new ArrayList();
        localankc = (ankc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      } while (localankc == null);
      localList = localankc.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (localList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "packageList is null.");
    return;
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    ArrayList localArrayList1 = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {}
    label208:
    label1879:
    label1887:
    label2539:
    label2542:
    for (boolean bool = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, super.getContext());; bool = false)
    {
      QLog.d("ApolloPanel", 1, new Object[] { "[initPanelData] showKapuUnlockAction=", Boolean.valueOf(bool) });
      int i5 = 0;
      int i1 = 0;
      int i2 = -1;
      ApolloActionPackage localApolloActionPackage;
      if (i5 < localList.size())
      {
        localApolloActionPackage = (ApolloActionPackage)localList.get(i5);
        if (localApolloActionPackage == null) {
          break label2555;
        }
        if (localApolloActionPackage.packageId != 4) {}
      }
      label1526:
      label2555:
      for (;;)
      {
        i5 += 1;
        break label208;
        if (this.jdField_c_of_type_Anpr.a(localApolloActionPackage.packageId))
        {
          String str = DeviceInfoUtil.getQQVersion();
          if ((!TextUtils.isEmpty(localApolloActionPackage.startVersion)) && (!TextUtils.isEmpty(localApolloActionPackage.endVersion)) && ((!bhnm.a(localApolloActionPackage.startVersion, str)) || (!bhnm.a(str, localApolloActionPackage.endVersion))))
          {
            QLog.w("ApolloPanel", 1, "version not correct packageId=" + localApolloActionPackage.packageId);
          }
          else
          {
            long l2 = System.currentTimeMillis();
            anqh localanqh = a(localApolloActionPackage.type);
            if (localanqh != null)
            {
              localanqh.jdField_d_of_type_Int = localApolloActionPackage.packageId;
              Object localObject1 = null;
              Object localObject3 = null;
              ArrayList localArrayList3 = new ArrayList();
              Object localObject2;
              Object localObject4;
              ApolloActionData localApolloActionData;
              int i3;
              if (localApolloActionPackage.type == 2)
              {
                localObject2 = localankc.a();
                localObject1 = (List)((Pair)localObject2).first;
                localObject2 = (List)((Pair)localObject2).second;
                if ((localObject1 != null) && (((List)localObject1).size() > 0))
                {
                  localanqh.b(5);
                  localObject4 = new annl();
                  ((annl)localObject4).jdField_b_of_type_Int = 2;
                  localApolloActionData = new ApolloActionData();
                  localApolloActionData.actionName = super.getResources().getString(2131690060);
                  ((annl)localObject4).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
                  localArrayList3.add(localObject4);
                  i3 = i1;
                }
              }
              long l1;
              for (;;)
              {
                l1 = System.currentTimeMillis();
                localObject4 = new StringBuilder();
                if (localObject2 == null) {
                  break label2542;
                }
                i1 = i2;
                i2 = 0;
                for (;;)
                {
                  if (i2 >= ((List)localObject2).size()) {
                    break label1526;
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
                    break;
                  }
                  localApolloActionData = (ApolloActionData)((List)localObject2).get(i2);
                  if (localApolloActionData != null) {
                    break label952;
                  }
                  i2 += 1;
                }
                localanqh.b(4);
                break label525;
                if (localApolloActionPackage.type == 100)
                {
                  localObject1 = localankc.j();
                  if ((localObject1 != null) && (((List)localObject1).size() > 0))
                  {
                    i3 = i1;
                    if ((localanqh instanceof anpu))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloPanel", 2, new Object[] { "set panel game list, size=", Integer.valueOf(((List)localObject1).size()) });
                      }
                      ((anpu)localanqh).a((List)localObject1);
                      localanqh.b(100);
                      i3 = i1 + localanqh.a();
                      localArrayList1.add(localanqh);
                      localArrayList2.add(localApolloActionPackage);
                    }
                  }
                  for (;;)
                  {
                    localObject1 = null;
                    localObject2 = null;
                    break;
                    QLog.i("ApolloPanel", 1, "load game info fail cause games == null");
                    i3 = i1;
                  }
                }
                if (localApolloActionPackage.packageId != 8) {
                  break label809;
                }
                localObject1 = localankc.b();
                localObject3 = (List)((Pair)localObject1).first;
                localObject2 = (List)((Pair)localObject1).second;
                localanqh.b(0);
                localObject1 = null;
                i3 = i1;
              }
              if (((!anmk.c()) && (localApolloActionPackage.packageId != 9)) || (anmk.c()))
              {
                localObject1 = localankc.d(localApolloActionPackage.packageId);
                localObject2 = localankc.e(localApolloActionPackage.packageId);
                localanqh.b(0);
              }
              for (;;)
              {
                if (localApolloActionPackage.packageId == 6)
                {
                  localanqh.b(9);
                  localankc.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (List)localObject1);
                  localObject3 = localObject2;
                  localObject4 = null;
                  localObject2 = localObject1;
                  localObject1 = localObject4;
                  i3 = i1;
                  break label528;
                }
                if (localApolloActionPackage.packageId == 7) {
                  localankc.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (List)localObject1);
                }
                localObject3 = localObject2;
                localObject4 = null;
                localObject2 = localObject1;
                localObject1 = localObject4;
                i3 = i1;
                break label528;
                if (!localApolloActionData.verifyVersion(str))
                {
                  ((StringBuilder)localObject4).append(",version ").append(localApolloActionData.actionId);
                  break label591;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0)
                {
                  if (localApolloActionData.sessionType != 2) {
                    break label1074;
                  }
                  ((StringBuilder)localObject4).append(",special C2C ").append(localApolloActionData.actionId);
                  break label591;
                }
                if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000)) && (localApolloActionData.sessionType == 1))
                {
                  ((StringBuilder)localObject4).append(",special ").append(localApolloActionData.actionId);
                  break label591;
                }
                if (((ApolloActionData)((List)localObject2).get(i2)).isShow == 0)
                {
                  ((StringBuilder)localObject4).append(",hide ").append(localApolloActionData.actionId);
                  break label591;
                }
                if ((ApolloActionPackage.is3DPackage(localApolloActionPackage.packageId)) && (localApolloActionData.feeType == 10))
                {
                  if (this.jdField_f_of_type_Int == 2) {
                    this.jdField_h_of_type_Boolean = true;
                  }
                  if (!bool)
                  {
                    ((StringBuilder)localObject4).append(",kapu unlock ").append(localApolloActionData.actionId);
                    break label591;
                  }
                }
                annl localannl = localanqh.a(paramString);
                if (localannl != null)
                {
                  localannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
                  localannl.jdField_a_of_type_Int = localApolloActionPackage.packageId;
                  if (localApolloActionPackage.type != 2) {
                    break label1447;
                  }
                  if ((localObject1 != null) && (((List)localObject1).size() > i2))
                  {
                    localannl.jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject1).get(i2)).text;
                    localannl.jdField_d_of_type_Int = ((ApolloFavActionData)((List)localObject1).get(i2)).textType;
                    localannl.jdField_e_of_type_Int = ((ApolloFavActionData)((List)localObject1).get(i2)).audioId;
                    localannl.jdField_a_of_type_Float = ((ApolloFavActionData)((List)localObject1).get(i2)).audioStartTime;
                    localannl.jdField_f_of_type_Int = ((ApolloFavActionData)((List)localObject1).get(i2)).playOriginalAudio;
                  }
                }
                for (localannl.jdField_g_of_type_Int = anlw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, localannl, localannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);; localannl.jdField_g_of_type_Int = anlw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, localannl, localannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData))
                {
                  localArrayList3.add(localannl);
                  if ((i1 != -1) || (this.jdField_g_of_type_Int != localApolloActionData.actionId)) {
                    break label2539;
                  }
                  if (this.jdField_h_of_type_Int == -1)
                  {
                    this.jdField_h_of_type_Int = localApolloActionPackage.packageId;
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] jump action match but no jump pkg, use ", Integer.valueOf(this.jdField_h_of_type_Int) });
                    }
                  }
                  if (this.jdField_h_of_type_Int != localApolloActionPackage.packageId) {
                    break label2539;
                  }
                  i1 = localArrayList3.size() - 1;
                  break;
                  if ((localObject3 != null) && (((List)localObject3).size() > i2))
                  {
                    localannl.jdField_b_of_type_JavaLangString = ((ApolloActionPackageData)((List)localObject3).get(i2)).text;
                    localannl.jdField_d_of_type_Int = ((ApolloActionPackageData)((List)localObject3).get(i2)).textType;
                  }
                }
                if (0 != 0) {
                  throw new NullPointerException();
                }
                int i4 = i3;
                i2 = i1;
                if (localArrayList3.size() > 0)
                {
                  localanqh.c_(localArrayList3);
                  if (this.jdField_h_of_type_Int == localApolloActionPackage.packageId)
                  {
                    if (i1 == -1) {
                      break label1879;
                    }
                    localanqh.c(i1);
                    jdField_a_of_type_Int = localanqh.a(i1) + i3;
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] init sCurrentIndex with jump info, sCurrentIndex=", Integer.valueOf(jdField_a_of_type_Int), ", jumpActionIndex=", Integer.valueOf(i1) });
                    }
                  }
                  localArrayList1.add(localanqh);
                  if ((localApolloActionPackage.packageId == 8) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
                  {
                    localApolloActionPackage.isRecommendTabClick = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin(), 0).getBoolean("apollo_sp_key_recommend_tab_click", false);
                    QLog.d("ApolloPanel", 1, new Object[] { "[initPanelData] isRecommendTabClick=", Boolean.valueOf(localApolloActionPackage.isRecommendTabClick) });
                  }
                  localArrayList2.add(localApolloActionPackage);
                  i4 = i3 + localanqh.a();
                  i2 = i1;
                }
                for (;;)
                {
                  if (QLog.isColorLevel())
                  {
                    i1 = localApolloActionPackage.packageId;
                    if (localObject2 != null) {
                      break label1887;
                    }
                  }
                  for (localObject1 = null;; localObject1 = Integer.valueOf(((List)localObject2).size()))
                  {
                    QLog.d("ApolloPanel", 2, new Object[] { "Tab add package:", Integer.valueOf(i1), ",actionPackageDatas size:", localObject1, ",findTime:", Long.valueOf(l1 - l2), ",remove actions ", ((StringBuilder)localObject4).toString() });
                    i1 = i4;
                    break;
                    jdField_a_of_type_Int = i3;
                    break label1597;
                  }
                  if (this.jdField_h_of_type_Boolean) {
                    C();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
                  }
                  if ((this.jdField_g_of_type_Int == -1) && (this.jdField_h_of_type_Int == -1)) {
                    a(localArrayList1, localArrayList2, paramBoolean);
                  }
                  if ((this.jdField_g_of_type_Int != -1) && (i2 == -1) && (!this.jdField_c_of_type_Boolean))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloPanel", 2, "[initPanelData] no jump action found, try to update json");
                    }
                    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
                      this.jdField_a_of_type_AndroidWidgetImageView.post(new ApolloPanel.4(this));
                    }
                    this.jdField_c_of_type_Boolean = true;
                    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null)) {
                      ((amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a(1);
                    }
                  }
                  while ((localArrayList1 != null) && (localArrayList1.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
                  {
                    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin(), 0);
                    l2 = NetConnInfoCenter.getServerTime();
                    l1 = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app);
                    localObject3 = new ArrayList();
                    localObject1 = localArrayList2.iterator();
                    while (((Iterator)localObject1).hasNext())
                    {
                      paramString = (ApolloActionPackage)((Iterator)localObject1).next();
                      if ((paramString.isUpdate) && (paramString.packageId != 100))
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("ApolloPanel", 2, "[initPanelData] delete red dot after 24h:" + ((List)localObject3).size());
                        }
                        if (NetConnInfoCenter.getServerTimeMillis() - ((SharedPreferences)localObject2).getLong("action_red_tab_update_" + paramString.packageId, 0L) > paramString.redInterval)
                        {
                          paramString.isUpdate = false;
                          ((List)localObject3).add(paramString);
                        }
                      }
                      if ((paramString.isUpdate) && (paramString.packageId == 100) && (l2 - l1 > 604800000L))
                      {
                        paramString.isUpdate = false;
                        ((List)localObject3).add(paramString);
                      }
                    }
                    if (!this.jdField_b_of_type_Boolean)
                    {
                      this.jdField_h_of_type_Int = -1;
                      this.jdField_g_of_type_Int = -1;
                    }
                  }
                  break;
                  if (!((List)localObject3).isEmpty())
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloPanel", 2, "[initPanelData] delete red dot after 24h:" + ((List)localObject3).size());
                    }
                    ThreadManager.post(new ApolloPanel.5(this, (List)localObject3), 5, null, true);
                  }
                  a(localArrayList2);
                  b(localArrayList1);
                  this.jdField_c_of_type_Anpr.a();
                  a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, "103100.103200.103250", paramBoolean);
                  if (Looper.myLooper() == Looper.getMainLooper()) {
                    try
                    {
                      e();
                      return;
                    }
                    catch (Throwable paramString)
                    {
                      QLog.e("ApolloPanel", 1, "[reportTabExposure] failed, excetion1=", paramString);
                      return;
                    }
                  }
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity == null)) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.runOnUiThread(new ApolloPanel.6(this));
                  return;
                  break label591;
                  i4 = i3;
                }
                localObject2 = null;
              }
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initBinderData] froceRefresh=", Boolean.valueOf(paramBoolean1), ", refreshByGetUserAction=", Boolean.valueOf(paramBoolean2) });
    }
    if (this.jdField_i_of_type_Int == 7)
    {
      l();
      return;
    }
    ThreadManager.post(new ApolloPanel.3(this, paramBoolean1, paramString, paramBoolean2), 5, null, true);
  }
  
  public void a(List<ApolloActionPackage> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.runOnUiThread(new ApolloPanel.10(this, paramList));
    }
  }
  
  public void a(Map paramMap)
  {
    if (paramMap == null) {}
    String str;
    do
    {
      return;
      str = (String)paramMap.get("APOLLO_POP_TYPE");
      if ("toast".equals(str))
      {
        str = (String)paramMap.get("offset");
        paramMap = (String)paramMap.get("tips");
        a(Integer.parseInt(str), paramMap);
        return;
      }
    } while (!"dialog".equals(str));
    a((String)paramMap.get("feeType"), (String)paramMap.get("title"), (String)paramMap.get("content"), (String)paramMap.get("rightString"), (String)paramMap.get("url"), (String)paramMap.get("isActionBack"), (String)paramMap.get("actionId"), (String)paramMap.get("extendJson"), (String)paramMap.get("personNum"));
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {}
    do
    {
      Pair localPair;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_Anqe != null) {
                this.jdField_a_of_type_Anqe.c();
              }
            } while (!paramBoolean);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, "actionpanel onOpen response");
            }
          } while (paramObject == null);
          localPair = (Pair)paramObject;
          paramObject = (String)((Pair)paramObject).first;
        } while ((TextUtils.isEmpty(paramObject)) || (!paramObject.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin())));
        if (2 == ((Integer)localPair.second).intValue())
        {
          jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(jdField_a_of_type_Int);
          k();
          return;
        }
      } while (1 != ((Integer)localPair.second).intValue());
      ((amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a(false, "panel open apollo", 1);
    } while (this.jdField_a_of_type_Anqe == null);
    this.jdField_a_of_type_Anqe.b(0);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin(), true, false);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Anpo != null)
    {
      Object localObject = this.jdField_a_of_type_Anpo.a();
      if ((localObject != null) && (this.jdField_k_of_type_Int >= 0) && (this.jdField_k_of_type_Int < ((List)localObject).size()))
      {
        localObject = (ApolloActionPackage)((List)localObject).get(this.jdField_k_of_type_Int);
        if ((localObject != null) && (((ApolloActionPackage)localObject).packageId == 100)) {
          return true;
        }
      }
    }
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null) && (ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app) == 3);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return -1;
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() > jdField_a_of_type_Int) && ((this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int) instanceof anpu)))
    {
      ApolloGameData localApolloGameData = ((anpu)this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int)).b();
      if (localApolloGameData != null) {
        return localApolloGameData.gameId;
      }
    }
    return -1;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_key_url_append", "&showDialog=1&type=role");
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, localIntent, "aio", anka.u, null);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
    if (paramInt == 7) {
      l();
    }
    do
    {
      return;
      if (paramInt == 0)
      {
        c(paramInt, 1);
        return;
      }
      if (paramInt == 1)
      {
        if (!FileUtil.isFileExists("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json"))
        {
          c(paramInt, 3);
          ((amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a(this.jdField_a_of_type_Anml);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.a(this.jdField_a_of_type_JavaUtilList);
        b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin());
        return;
      }
    } while (paramInt != 2);
    c(paramInt, 1);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jumpPkgId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null))
    {
      QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] mBaseChatPie or mBaseChatPie.app is null");
      return;
    }
    amme localamme = (amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER);
    if (localamme.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin()) != 1)
    {
      QLog.d("ApolloPanel", 1, "[jumpToPkgOrAction] status not open, abort jump");
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] jump failed, no binder data");
      return;
    }
    Object localObject = a();
    int i1;
    if ((localObject != null) && (((amrk)localObject).jdField_a_of_type_Int > 0) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      i1 = 0;
      label178:
      if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label1244;
      }
      if (!(this.jdField_a_of_type_JavaUtilList.get(i1) instanceof anpu)) {}
    }
    for (;;)
    {
      if (i1 != -1)
      {
        paramInt1 = jdField_a_of_type_Int;
        if ((jdField_a_of_type_Int != i1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i1, false);
          a(i1);
          setTabSelect(a(i1));
          jdField_a_of_type_Int = i1;
        }
        if ((i1 >= paramInt1 - 1) && (i1 <= paramInt1 + 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] checkGameTab force refresh cache view");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.notifyDataSetChanged();
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] checkGameTab jumpGameId:" + ((amrk)localObject).jdField_a_of_type_Int + ",gameTabIndex:" + i1);
        return;
        i1 += 1;
        break label178;
      }
      if ((paramInt1 == -1) && (paramInt2 == -1))
      {
        QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] abort finding action index");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter == null))
      {
        QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] failed, no view pager");
        return;
      }
      int i3 = 0;
      i1 = -1;
      int i4 = -1;
      int i8 = this.jdField_a_of_type_JavaUtilList.size();
      int i7 = 0;
      label508:
      int i5;
      List localList;
      label785:
      annl localannl;
      if ((i7 < i8) && (i1 == -1))
      {
        localObject = (anqh)this.jdField_a_of_type_JavaUtilList.get(i7);
        if (localObject == null) {
          break label1237;
        }
        if ((paramInt1 != -1) && (((anqh)localObject).jdField_d_of_type_Int == paramInt1))
        {
          if (paramInt2 == -1)
          {
            i1 = i3;
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump for pkg, newViewPagerIndex=", Integer.valueOf(i3) });
              i1 = i3;
            }
            if (i1 != -1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump to new index=", Integer.valueOf(i1), ", current index=", Integer.valueOf(jdField_a_of_type_Int) });
              }
              i2 = jdField_a_of_type_Int;
              if (jdField_a_of_type_Int != i1)
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i1, false);
                a(i1);
                setTabSelect(a(i1));
                jdField_a_of_type_Int = i1;
              }
              if ((i1 >= i2 - 1) && (i1 <= i2 + 1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] force refresh cache view");
                }
                this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.notifyDataSetChanged();
              }
            }
            if ((paramInt2 == -1) || (i4 != -1)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
            }
            if (this.jdField_c_of_type_Boolean) {
              break;
            }
            if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            this.jdField_c_of_type_Boolean = true;
            this.jdField_g_of_type_Int = paramInt2;
            this.jdField_h_of_type_Int = paramInt1;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] no action found, try to update json");
            }
            localamme.a(1);
            return;
          }
          i2 = i4;
          i5 = i1;
          if (!(localObject instanceof anpu))
          {
            localList = ((anqh)localObject).jdField_a_of_type_JavaUtilList;
            if ((localList == null) || (localList.size() <= 0)) {
              break label952;
            }
            i2 = 0;
            i5 = localList.size();
            if (i2 >= i5) {
              break label1228;
            }
            localannl = (annl)localList.get(i2);
            if ((localannl != null) && (localannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramInt2))
            {
              ((anqh)localObject).c(i2);
              i1 = ((anqh)localObject).a(i2) + i3;
              if (!QLog.isColorLevel()) {
                break label1215;
              }
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump action found, jumpActionIndex=", Integer.valueOf(i2), ", newViewPagerIndex=", Integer.valueOf(i1) });
              i4 = i2;
              i2 = i1;
              i1 = i4;
              label902:
              i5 = i2;
              i2 = i1;
            }
          }
          else
          {
            label909:
            i3 = ((anqh)localObject).a() + i3;
            i1 = i5;
            i4 = i2;
          }
        }
      }
      label952:
      label1215:
      label1228:
      label1237:
      for (int i2 = i3;; i2 = i3)
      {
        i7 += 1;
        i3 = i2;
        break;
        i2 += 1;
        break label785;
        i1 = i3;
        if (!QLog.isColorLevel()) {
          break label508;
        }
        QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] mIsJsonUpdatedByJumpAction true, just jump pkg, newViewPagerIndex=", Integer.valueOf(i3) });
        i1 = i3;
        break label508;
        i2 = i4;
        i5 = i1;
        if (paramInt2 == -1) {
          break label909;
        }
        i2 = i4;
        i5 = i1;
        if ((localObject instanceof anpu)) {
          break label909;
        }
        localList = ((anqh)localObject).jdField_a_of_type_JavaUtilList;
        if ((localList != null) && (localList.size() > 0))
        {
          int i6 = 0;
          int i9 = localList.size();
          for (;;)
          {
            i2 = i4;
            i5 = i1;
            if (i6 >= i9) {
              break;
            }
            localannl = (annl)localList.get(i6);
            if ((localannl != null) && (localannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramInt2))
            {
              if (paramInt1 != -1)
              {
                i2 = i4;
                i5 = i1;
                if (paramInt1 != ((anqh)localObject).jdField_d_of_type_Int) {
                  break;
                }
              }
              ((anqh)localObject).c(i6);
              i5 = i3 + ((anqh)localObject).a(i6);
              if (!QLog.isColorLevel()) {
                break label1205;
              }
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump action found2, jumpActionIndex=", Integer.valueOf(i6), ", newViewPagerIndex=", Integer.valueOf(i5) });
              i2 = i6;
              break;
            }
            i6 += 1;
          }
          i2 = i6;
          break label909;
        }
        break label508;
        i4 = i1;
        i1 = i2;
        i2 = i4;
        break label902;
        i2 = i1;
        i1 = i4;
        break label902;
      }
      label1205:
      label1244:
      i1 = -1;
    }
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    long l1 = System.currentTimeMillis();
    if (paramApolloActionData == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "updateItemStatus action= " + paramApolloActionData.actionId + " action name =" + paramApolloActionData.actionName);
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "something=null ");
    return;
    int i1 = 0;
    for (;;)
    {
      try
      {
        if (i1 >= this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildCount()) {
          continue;
        }
        localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildAt(i1);
        if (!(localViewGroup instanceof ApolloLinearLayout)) {
          break label380;
        }
        if (((ApolloLinearLayout)localViewGroup).a(paramApolloActionData) != null) {
          break label387;
        }
      }
      catch (Exception paramApolloActionData)
      {
        ViewGroup localViewGroup;
        LinearLayout localLinearLayout;
        int i3;
        anoa localanoa;
        annl localannl;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloPanel", 2, "updateItemStatus error:" + paramApolloActionData.toString());
        l2 = System.currentTimeMillis();
      }
      if (i2 < localViewGroup.getChildCount())
      {
        localLinearLayout = (LinearLayout)localViewGroup.getChildAt(i2);
        i3 = 0;
        if (i3 < localLinearLayout.getChildCount())
        {
          localanoa = (anoa)localLinearLayout.getChildAt(i3).getTag();
          if (localanoa != null)
          {
            localannl = localanoa.a;
            if ((localannl != null) && (localannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramApolloActionData.actionId))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getHandler(ChatActivity.class).post(new ApolloPanel.22(this, localanoa));
            }
          }
          i3 += 1;
          continue;
        }
        i2 += 1;
        continue;
        long l2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloPanel", 2, "updateItemStatus cost time = " + (l2 - l1));
        return;
      }
      label380:
      i1 += 1;
      continue;
      label387:
      int i2 = 0;
    }
  }
  
  public void b(String paramString)
  {
    g(0);
    a(paramString, false);
  }
  
  public void b(List<anqh> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity.runOnUiThread(new ApolloPanel.11(this, paramList));
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {}
    boolean bool2;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[onQueryUserApolloAction] result=", Boolean.valueOf(paramBoolean), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      }
      if ((this.jdField_b_of_type_Boolean) && (!paramBoolean))
      {
        this.jdField_h_of_type_Int = -1;
        this.jdField_g_of_type_Int = -1;
      }
      bool2 = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = false;
    } while (!paramBoolean);
    if (paramObject != null)
    {
      paramObject = (Bundle)paramObject;
      int i1 = paramObject.getInt("jumpPkdId", -1);
      int i2 = paramObject.getInt("jumpActionId", -1);
      if ((i1 != -1) && (i2 != -1))
      {
        this.jdField_h_of_type_Int = i1;
        this.jdField_g_of_type_Int = i2;
      }
    }
    if ((bool2) && (paramBoolean)) {}
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin(), false, paramBoolean);
      return;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
    {
      amme localamme = (amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER);
      if (localamme != null)
      {
        localamme.a(this.jdField_a_of_type_Anml);
        int i1 = 0;
        if (!FileUtil.isFileExists("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json")) {
          i1 = 1;
        }
        localamme.a(i1);
      }
    }
  }
  
  void c(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "onClick tab postion=" + paramInt);
      }
      setTabSelect(paramInt);
      int i1 = 0;
      int i2 = 0;
      while (i1 < paramInt)
      {
        i2 += ((anqh)this.jdField_a_of_type_JavaUtilList.get(i1)).a();
        i1 += 1;
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i2, false);
          a(i2);
          Object localObject = this.jdField_a_of_type_Anpo.a();
          if (localObject == null) {
            break;
          }
          if (((List)localObject).isEmpty()) {
            return;
          }
          localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 3000)
          {
            paramInt = 2;
            VipUtils.a(null, "cmshow", "Apollo", "clciktabreddot", paramInt, 0, new String[] { String.valueOf(((ApolloActionPackage)localObject).packageId) });
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("ApolloPanel", 2, "setCurrentItem exception e=" + localThrowable.toString());
          return;
        }
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType;
      }
    }
  }
  
  public void c(ApolloActionData paramApolloActionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[showKapuLockActionView] action=", paramApolloActionData });
    }
    w();
    this.jdField_a_of_type_Anob = new anob(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this, this.jdField_a_of_type_Anpe);
    this.jdField_a_of_type_Anob.a(paramApolloActionData);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo;
    } while ((localQQAppInterface == null) || (localObject == null));
    amme localamme = (amme)localQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    int i1 = amme.a(localQQAppInterface, ((SessionInfo)localObject).curFriendUin, false);
    int i2 = ApolloUtil.b(((SessionInfo)localObject).curType);
    if (i1 == 2) {}
    for (Object localObject = "3D";; localObject = "2D")
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "state_open_clk", i2, 0, new String[] { localObject });
      return;
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] index=", Integer.valueOf(paramInt) });
    }
    if (this.jdField_a_of_type_Anpo == null) {}
    int i1;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_Anpo.a();
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
      paramInt = ((ApolloActionPackage)localObject).packageId;
      i1 = ((ApolloActionPackage)localObject).type;
    } while ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null));
    Object localObject = (amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER);
    if (i1 == 2) {
      ((amme)localObject).a(paramInt, true);
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] packageId=", Integer.valueOf(paramInt) });
      return;
      if ((i1 != 100) && (((amme)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin()) == 1)) {
        ((amme)localObject).a(paramInt, false);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      bhhy.a("apollo_panel_open", null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "dispatchdraw is called");
      }
      return;
    }
    catch (StackOverflowError paramCanvas)
    {
      QLog.e("ApolloPanel", 1, "dispatchDraw, StackOverflowError, stack:" + MsfSdkUtils.getStackTraceString(paramCanvas));
    }
  }
  
  protected void dispatchVisibilityChanged(View paramView, int paramInt)
  {
    super.dispatchVisibilityChanged(paramView, paramInt);
    if ((paramInt != 0) && (this.jdField_a_of_type_Blhb != null) && (this.jdField_a_of_type_Blhb.isShowing())) {
      this.jdField_a_of_type_Blhb.dismiss();
    }
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      return;
    }
  }
  
  protected void e()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_Anpo != null))
    {
      i1 = a(jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_Anpo.a();
      if ((localObject != null) && (((List)localObject).size() > 0) && (i1 >= 0) && (i1 < ((List)localObject).size()))
      {
        localObject = (ApolloActionPackage)((List)localObject).get(i1);
        if (localObject == null) {
          break label150;
        }
      }
    }
    label150:
    for (int i1 = ((ApolloActionPackage)localObject).packageId;; i1 = 0)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "tabexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), i1, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      QLog.e("ApolloPanel", 1, "[showGuidePageForOpenCmshow] mBaseChatPie or mBaseChatPie.app is null");
    }
    ArrayList localArrayList;
    Object localObject1;
    do
    {
      return;
      QLog.i("ApolloPanel", 1, "showGuidePageForOpenCmshow dataType:" + paramInt);
      localArrayList = new ArrayList();
      localObject1 = (ankc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      if (localObject1 == null)
      {
        QLog.e("ApolloPanel", 1, "showGuidePageForOpenCmshow adm == null");
        ApolloUtil.b("showGuidePageForOpenCmshow adm == null");
        return;
      }
      jdField_b_of_type_Int = paramInt;
      if (paramInt != 1) {
        break label284;
      }
      localObject1 = ((ankc)localObject1).d(400);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        break;
      }
      QLog.e("ApolloPanel", 1, "[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
      ApolloUtil.b("[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (21 != this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurrentPanel()));
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hideAllPanels();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.34(this));
    return;
    if ((localObject1 != null) && (((List)localObject1).size() > 4)) {
      localObject1 = ((List)localObject1).subList(0, 4);
    }
    for (;;)
    {
      paramInt = 0;
      Object localObject2;
      for (;;)
      {
        if ((localObject1 != null) && (paramInt < ((List)localObject1).size()))
        {
          localObject2 = new anmx(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin());
          ((anmx)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject1).get(paramInt));
          localArrayList.add(localObject2);
          paramInt += 1;
          continue;
          label284:
          localObject1 = ((ankc)localObject1).f();
          if ((localObject1 == null) || (((List)localObject1).isEmpty()))
          {
            QLog.e("ApolloPanel", 1, "[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
            ApolloUtil.b("[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (21 != this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurrentPanel())) {
              break;
            }
            if (Looper.getMainLooper() == Looper.myLooper())
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.hideAllPanels();
              return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.35(this));
            return;
          }
          if ((localObject1 == null) || (((List)localObject1).size() <= 4)) {
            break label599;
          }
          localObject1 = ((List)localObject1).subList(0, 4);
        }
      }
      label599:
      for (;;)
      {
        paramInt = 0;
        while ((localObject1 != null) && (paramInt < ((List)localObject1).size()))
        {
          localObject2 = new annm(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin());
          ((annm)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject1).get(paramInt));
          localArrayList.add(localObject2);
          paramInt += 1;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          A();
          this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setGuideType(1);
          this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setActions(localArrayList);
        }
        while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "exp_panelnewuser_show", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType()), jdField_b_of_type_Int, new String[] { String.valueOf(this.jdField_c_of_type_Int), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
          return;
          ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.36(this, localArrayList));
        }
        break;
      }
    }
  }
  
  public void f()
  {
    ThreadManager.post(new ApolloPanel.8(this), 5, null, false);
  }
  
  public void g()
  {
    int i4 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "del fav action");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {}
    int i3;
    label471:
    do
    {
      int i5;
      int i1;
      do
      {
        return;
        i5 = 1;
        i1 = 1;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      int i2 = 0;
      for (;;)
      {
        i3 = i5;
        if (i2 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label471;
        }
        anqh localanqh = (anqh)this.jdField_a_of_type_JavaUtilList.get(i2);
        if (localanqh.jdField_c_of_type_Int == 2)
        {
          List localList = localanqh.jdField_a_of_type_JavaUtilList;
          if ((localList == null) || (localList.size() == 0))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloPanel", 2, "no fav action yet");
            return;
          }
          Object localObject1 = (ankc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
          if (localObject1 == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("ApolloPanel", 2, "apolloDaoManager null");
            return;
          }
          localList.clear();
          Object localObject2 = ((ankc)localObject1).a();
          localObject1 = (List)((Pair)localObject2).first;
          localObject2 = (List)((Pair)localObject2).second;
          Object localObject3 = (ankc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localanqh.b(5);
            localObject3 = new annl();
            ((annl)localObject3).jdField_b_of_type_Int = 2;
            ApolloActionData localApolloActionData = new ApolloActionData();
            localApolloActionData.actionName = super.getResources().getString(2131690060);
            ((annl)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
            localList.add(localObject3);
          }
          for (;;)
          {
            i3 = i1;
            if (i4 >= ((List)localObject2).size()) {
              break;
            }
            localObject3 = localanqh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin());
            if (localObject3 != null)
            {
              ((annl)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject2).get(i4));
              ((annl)localObject3).jdField_a_of_type_Int = localanqh.jdField_d_of_type_Int;
              if ((localObject1 != null) && (((List)localObject1).size() > i2))
              {
                ((annl)localObject3).jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject1).get(i4)).text;
                ((annl)localObject3).jdField_d_of_type_Int = ((ApolloFavActionData)((List)localObject1).get(i4)).textType;
                ((annl)localObject3).jdField_g_of_type_Int = anlw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (annl)localObject3, ((annl)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
              }
              localList.add(localObject3);
            }
            i4 += 1;
            continue;
            localanqh.b(4);
            i1 = 0;
          }
        }
        i2 += 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter != null) && (i3 != 0))
      {
        a(jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter.notifyDataSetChanged();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (i3 != 0));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentAccountUin());
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((anqh)this.jdField_a_of_type_JavaUtilList.get(i1)).a();
        i1 += 1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
    {
      amme localamme = (amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER);
      if (localamme != null)
      {
        localamme.b(this.jdField_a_of_type_Anml);
        localamme.c();
        if (this.jdField_a_of_type_Amna != null) {
          this.jdField_a_of_type_Amna.a();
        }
      }
      if (this.jdField_a_of_type_Bhow != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.removeObserver(this.jdField_a_of_type_Bhow);
      }
    }
    n();
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    w();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelAdapter = null;
    this.jdField_a_of_type_Anqe = null;
    this.jdField_a_of_type_Anml = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_Anpe != null) {
      this.jdField_a_of_type_Anpe.c();
    }
    this.jdField_a_of_type_Blhb = null;
    this.jdField_a_of_type_JavaUtilDeque = null;
    D();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return false;
        int i1 = paramMessage.getData().getInt("pkgId");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[handleMessage] MSG_SHOW_NEW_ACTION_FLOAT_VIEW, actionId=", Integer.valueOf(paramMessage.arg1), ", pkgId=", Integer.valueOf(i1) });
        }
        d(paramMessage.arg1, i1);
        return false;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content)) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.life_Time <= 0) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts));
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 49, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.life_Time, null);
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
      paramMessage.show_sum += 1;
      ((amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      return false;
    } while (this.jdField_a_of_type_Anpe == null);
    anpe.a(this.jdField_a_of_type_Anpe);
    return false;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[switch2RedTab] visibility=", Integer.valueOf(super.getVisibility()) });
    }
    if (super.getVisibility() == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[switch2RedTab] visible now, abort");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Anpo != null)
      {
        List localList = this.jdField_a_of_type_Anpo.a();
        if ((localList == null) || (localList.isEmpty())) {
          break;
        }
        int i2 = localList.size();
        int i1 = 0;
        while (i1 < i2)
        {
          ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)localList.get(i1);
          if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= localApolloActionPackage.redStartTime))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, new Object[] { "[switch2RedTab] packageId=", Integer.valueOf(localApolloActionPackage.packageId) });
            }
            c(i1);
            return;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void j()
  {
    MqqHandler localMqqHandler;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {}
    }
    else
    {
      return;
    }
    localMqqHandler.post(new ApolloPanel.12(this));
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null))
    {
      QLog.e("ApolloPanel", 1, "[initData] mBaseChatPie or mBaseChatPie.app is null");
      return;
    }
    amme localamme = (amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER);
    localamme.a(this.jdField_a_of_type_Anml);
    if (this.jdField_a_of_type_Amna != null) {
      this.jdField_a_of_type_Amna.a(this.jdField_a_of_type_Amnb);
    }
    int i2 = localamme.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1036)
      {
        i1 = 1;
        if ((!this.jdField_d_of_type_Boolean) && (this.jdField_i_of_type_Int != 7) && (i1 == 0)) {
          break label146;
        }
      }
    }
    label146:
    for (int i1 = 7;; i1 = i2)
    {
      b(i1);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break;
    }
  }
  
  public void l()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
    {
      localObject = (ankc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1036) {
        break label137;
      }
      localObject = ((ahzc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a();
      this.jdField_a_of_type_Anpu = new anpu(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      this.jdField_a_of_type_Anpu.a((List)localObject);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label145;
      }
      this.jdField_a_of_type_Anpu.b(100);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new ApolloPanel.13(this));
      return;
      label137:
      localObject = ((ankc)localObject).j();
      break;
      label145:
      this.jdField_a_of_type_Anpu.b(8);
    }
  }
  
  public void m()
  {
    Object localObject1;
    List localList;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
    {
      localObject1 = (ankc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahzc)) {
        break label114;
      }
      localList = ((ahzc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).a();
      if ((localList != null) && (localList.size() > 0))
      {
        localObject1 = null;
        localObject2 = null;
        if (this.jdField_a_of_type_Anpu == null) {
          break label123;
        }
        localObject2 = this.jdField_a_of_type_Anpu;
      }
    }
    label114:
    label123:
    int i2;
    int i1;
    do
    {
      do
      {
        if (localObject2 != null) {
          ThreadManager.getUIHandler().post(new ApolloPanel.14(this, (anpu)localObject2, localList));
        }
        return;
        localList = ((ankc)localObject1).j();
        break;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      i2 = this.jdField_a_of_type_JavaUtilList.size();
      i1 = 0;
      localObject2 = localObject1;
    } while (i1 >= i2);
    Object localObject2 = (anqh)this.jdField_a_of_type_JavaUtilList.get(i1);
    if ((localObject2 != null) && (((anqh)localObject2).jdField_c_of_type_Int == 100) && ((localObject2 instanceof anpu))) {
      localObject1 = (anpu)localObject2;
    }
    for (;;)
    {
      i1 += 1;
      break;
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void o()
  {
    int i1;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        anqh localanqh = (anqh)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((localanqh.jdField_c_of_type_Int == 100) && ((localanqh instanceof anpu))) {
          ((anpu)localanqh).b();
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "click tab shop");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
      {
        Object localObject = (amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER);
        if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem != null))
        {
          ((amme)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, "aio_shop");
          ((amme)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
          ((bbbq)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b(String.valueOf("103100.103200.103250"));
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
          this.jdField_f_of_type_Boolean = false;
          y();
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "house_new_click", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType()), 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id });
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "house_click", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType()), 0, new String[0]);
        }
        else
        {
          if (amme.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app)) {}
          for (localObject = anka.u;; localObject = anka.v)
          {
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, null, "aio", (String)localObject, null);
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
          {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "clickslavenumber", 0, 0, new String[0]);
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, null, "aio", anka.v, null, 14003);
            continue;
            r();
            continue;
            s();
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 == 0) {
      super.getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "ApolloPanel event " + paramMotionEvent.toString(), " 是否拦截：", Boolean.valueOf(super.onInterceptTouchEvent(paramMotionEvent)) });
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i1 == 1) || (i1 == 3)) {
        super.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_e_of_type_Boolean = true;
    c(paramInt);
    this.jdField_e_of_type_Boolean = false;
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "onPageScrollStateChange state=" + paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "onPageScrolled i=" + paramInt1 + ",il=" + paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "pager position = " + paramInt);
    }
    int i4 = a(paramInt);
    if ((this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt - 1))) || (this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) || (this.jdField_l_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "change tab index = " + paramInt);
      }
      setTabSelect(i4);
      a(paramInt);
      this.jdField_e_of_type_Int = 0;
    }
    int i1;
    int i2;
    label337:
    Object localObject2;
    if (paramInt < jdField_a_of_type_Int)
    {
      i1 = 1;
      jdField_a_of_type_Int = paramInt;
      f(paramInt);
      this.jdField_d_of_type_Int = paramInt;
      i2 = b();
      if ((i2 != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getSessionInfo() != null)) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), "cmshow", "Apollo", "game_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getSessionInfo().curType), 0, new String[] { Integer.toString(i2) });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
        return;
      }
      int i3 = 0;
      i2 = i3;
      if (this.jdField_a_of_type_Anpo != null)
      {
        localObject1 = this.jdField_a_of_type_Anpo.a();
        i2 = i3;
        if (localObject1 != null)
        {
          i2 = i3;
          if (((List)localObject1).size() > 0)
          {
            i2 = i3;
            if (i4 >= 0)
            {
              i2 = i3;
              if (i4 < ((List)localObject1).size())
              {
                localObject1 = (ApolloActionPackage)((List)localObject1).get(i4);
                i2 = i3;
                if (localObject1 != null) {
                  i2 = ((ApolloActionPackage)localObject1).packageId;
                }
              }
            }
          }
        }
      }
      if (i2 != 6) {
        break label669;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      Object localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      }
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app;
      i3 = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      if (i1 == 0) {
        break label681;
      }
      localObject2 = "0";
      label388:
      VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "slide", (String)localObject1, i3, i2, new String[] { localObject2, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        return;
      }
      localObject2 = null;
      localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      i2 = 0;
      label476:
      localObject1 = localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        anqh localanqh = (anqh)((Iterator)localObject3).next();
        i1 = i2;
        if (localanqh == null) {
          break label689;
        }
        i1 = i2;
        if (!(localanqh instanceof anqh)) {
          break label689;
        }
        i3 = localanqh.a();
        i2 += i3;
        i1 = i2;
        if (paramInt + 1 > i2) {
          break label689;
        }
        if (!(localanqh instanceof anqe))
        {
          localObject1 = localObject2;
          if (!(localanqh instanceof anpt)) {}
        }
        else
        {
          localObject1 = localanqh.a(i3 - (i2 - paramInt));
        }
      }
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        return;
      }
      localObject2 = new StringBuilder();
      i1 = ((ArrayList)localObject1).size();
      paramInt = 0;
      label603:
      if (paramInt >= i1) {
        break label706;
      }
      localObject3 = (annl)((ArrayList)localObject1).get(paramInt);
      if (((annl)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) {
        break label694;
      }
      ((StringBuilder)localObject2).append(((annl)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
    }
    for (;;)
    {
      if (paramInt != i1 - 1) {
        ((StringBuilder)localObject2).append("-");
      }
      paramInt += 1;
      break label603;
      i1 = 0;
      break;
      label669:
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break label337;
      label681:
      localObject2 = "1";
      break label388;
      label689:
      i2 = i1;
      break label476;
      label694:
      ((StringBuilder)localObject2).append("0");
    }
    label706:
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "actionexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { ((StringBuilder)localObject2).toString(), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramInt == 0) && (this.jdField_f_of_type_Int == 2) && (this.jdField_l_of_type_Int != -1) && (this.jdField_l_of_type_Int != paramInt)) {
      this.jdField_c_of_type_Anpr.a();
    }
    this.jdField_l_of_type_Int = paramInt;
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.a() == 0)) {
      B();
    }
    z();
  }
  
  public void p()
  {
    MqqHandler localMqqHandler;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null))
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {}
    }
    else
    {
      return;
    }
    localMqqHandler.post(new ApolloPanel.24(this));
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      QLog.e("ApolloPanel", 1, "[showGuidePageFor3D] mBaseChatPie or mGuidePageFor3D or mBaseChatPie.app is null");
    }
    do
    {
      do
      {
        return;
        if ((!amms.jdField_a_of_type_Boolean) || (this.jdField_f_of_type_Int == 2) || (!b()))
        {
          B();
          return;
        }
        A();
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setGuideType(0);
        localObject2 = (ankc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      } while (localObject2 == null);
      Object localObject1 = new ArrayList();
      Object localObject2 = ((ankc)localObject2).d(400);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        int i1 = 0;
        while (i1 < ((List)localObject2).size())
        {
          anmx localanmx = new anmx(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin());
          localanmx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject2).get(i1));
          ((List)localObject1).add(localanmx);
          i1 += 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.setActions((List)localObject1);
      localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      ((TranslateAnimation)localObject1).setDuration(500L);
      ((TranslateAnimation)localObject1).setRepeatCount(0);
      ((TranslateAnimation)localObject1).setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView.startAnimation((Animation)localObject1);
    } while (this.n);
    this.n = true;
    ((amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).m();
  }
  
  public void r()
  {
    if (!NetworkUtil.isNetworkAvailable()) {
      QQToast.a(getContext(), 1, 2131690057, 0).a();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      return;
    }
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "change3d", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType()), 0, new String[0]);
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a("open_3d_cmshow", 1, new anoz(this));
  }
  
  public void s()
  {
    if (!NetworkUtil.isNetworkAvailable()) {
      QQToast.a(getContext(), 1, 2131690057, 0).a();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
      return;
    }
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "change2d", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType()), 0, new String[0]);
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a("open_2d_cmshow", 0, new anpa(this));
  }
  
  public void setTabSelect(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[setTabSelect] newIndex=", Integer.valueOf(paramInt), ", mLastTabIndex=", Integer.valueOf(this.jdField_k_of_type_Int) });
    }
    int i1;
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(this.jdField_k_of_type_Int);
      if (localObject != null) {
        ((View)localObject).setSelected(false);
      }
      if ((this.jdField_k_of_type_Int == -1) || (this.jdField_k_of_type_Int != paramInt)) {
        w();
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt);
      i1 = this.jdField_k_of_type_Int;
      this.jdField_k_of_type_Int = paramInt;
      if (localObject == null) {
        break label549;
      }
      ((View)localObject).setSelected(true);
      this.jdField_a_of_type_Anpo.a(paramInt);
      if ((!this.m) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanelGuideView == null) && (!this.jdField_a_of_type_Ammt.a()) && (!this.jdField_a_of_type_Ammt.b())) {
        a(paramInt, (View)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_Anpo != null) && (this.jdField_a_of_type_Anpo.a() != null) && (this.jdField_a_of_type_Anpo.a().size() > paramInt) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        localObject = (ApolloActionPackage)this.jdField_a_of_type_Anpo.a().get(paramInt);
        if ((((ApolloActionPackage)localObject).packageId == 100) && (i1 != paramInt)) {
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1);
        }
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app;
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
        int i2 = ((ApolloActionPackage)localObject).packageId;
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (!((ApolloActionPackage)localObject).isUpdate) {
          break label544;
        }
        i1 = 1;
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_tab", str, i2, 0, new String[] { i1, "" + ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), "", String.valueOf(System.currentTimeMillis() / 1000L) });
        if (((ApolloActionPackage)localObject).packageId == 9)
        {
          if (this.jdField_e_of_type_Boolean) {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "y_bqtabclick", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { "", "", "", "" });
          }
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "y_bqtabexpose", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { "", "", "", "" });
        }
      }
    }
    for (;;)
    {
      d(paramInt);
      return;
      label544:
      i1 = 0;
      break;
      label549:
      this.jdField_a_of_type_Anpo.a(paramInt);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[setVisibility] visibility=", Integer.valueOf(paramInt) });
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_Boolean = true;
    }
    while (paramInt != 8) {
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    w();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 1, "[setVisibility] gone, set mShouldShowActionFloatView true");
    }
    this.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_Long != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "panel_stay_time", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { "", "", "", String.valueOf(l1 - l2) });
      }
      this.jdField_a_of_type_Long = 0L;
    }
    jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel
 * JD-Core Version:    0.7.0.1
 */
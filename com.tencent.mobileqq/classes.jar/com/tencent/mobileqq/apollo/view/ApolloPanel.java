package com.tencent.mobileqq.apollo.view;

import agej;
import aihy;
import amst;
import amsx;
import amtj;
import amtk;
import amtl;
import amtq;
import amtr;
import amxp;
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
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import angf;
import angi;
import annv;
import annx;
import anpy;
import anpz;
import anqb;
import anqf;
import anqo;
import anra;
import anrc;
import anrg;
import anrh;
import anri;
import anrj;
import anrk;
import anrl;
import anrm;
import anrn;
import anro;
import anrp;
import anrq;
import anrr;
import anrs;
import anrt;
import anru;
import anrv;
import anrw;
import anrx;
import anry;
import anrz;
import ansa;
import ansb;
import anse;
import ansf;
import ansj;
import ansk;
import ansl;
import ansr;
import anss;
import anst;
import anzj;
import auog;
import bbav;
import bhlo;
import bhlq;
import bhpc;
import bhsq;
import bhyh;
import blha;
import blrr;
import blrs;
import blrt;
import bmup;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.HorizontalListView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ApolloPanel
  extends RelativeLayout
  implements Handler.Callback, ViewPager.OnPageChangeListener, View.OnClickListener, AdapterView.OnItemClickListener, anpz
{
  public static int a;
  private static final String jdField_a_of_type_JavaLangString = annv.jdField_a_of_type_JavaLangString + "/cmshow.apk";
  public static boolean a;
  public static int b;
  private static final String jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + ".temp";
  private long jdField_a_of_type_Long;
  private amtj jdField_a_of_type_Amtj = new ansa(this);
  private amtl jdField_a_of_type_Amtl;
  private amtq jdField_a_of_type_Amtq;
  public amtr a;
  public DialogInterface.OnClickListener a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  anpy jdField_a_of_type_Anpy = new anri(this);
  anqo jdField_a_of_type_Anqo;
  public anrh a;
  public ansf a;
  private ansk jdField_a_of_type_Ansk = new anry(this);
  private ansl jdField_a_of_type_Ansl = new ansb(this);
  ansr jdField_a_of_type_Ansr;
  bhpc jdField_a_of_type_Bhpc = null;
  public blrr a;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DrawerPushItem jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  public BaseChatPie a;
  public SessionInfo a;
  private ApolloPanel.KapuPkgStateReceiver jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$KapuPkgStateReceiver;
  ApolloPanelAdapter jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter;
  private ApolloPanelGuideView jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ApolloPanel.24(this);
  private Deque<ansj> jdField_a_of_type_JavaUtilDeque;
  public List<anst> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this, true);
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public LinearLayout b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  private ansk jdField_b_of_type_Ansk = new anrz(this);
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_b_of_type_Boolean;
  public int c;
  public RelativeLayout c;
  private ansk jdField_c_of_type_Ansk = this.jdField_a_of_type_Ansk;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  public List<Integer> c;
  private boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
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
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new anrn(this);
    this.jdField_a_of_type_Amtr = new anro(this);
    this.jdField_f_of_type_Int = 1;
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new anrn(this);
    this.jdField_a_of_type_Amtr = new anro(this);
    this.jdField_f_of_type_Int = 1;
  }
  
  /* Error */
  private void A()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 212
    //   4: iconst_1
    //   5: iconst_2
    //   6: anewarray 214	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 216
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_0
    //   17: getfield 218	com/tencent/mobileqq/apollo/view/ApolloPanel:jdField_i_of_type_Boolean	Z
    //   20: invokestatic 224	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   23: aastore
    //   24: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   27: aload_0
    //   28: getfield 218	com/tencent/mobileqq/apollo/view/ApolloPanel:jdField_i_of_type_Boolean	Z
    //   31: istore_1
    //   32: iload_1
    //   33: ifeq +6 -> 39
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: aload_0
    //   40: invokespecial 233	android/widget/RelativeLayout:getContext	()Landroid/content/Context;
    //   43: astore_2
    //   44: aload_0
    //   45: aload_2
    //   46: invokestatic 238	com/tencent/mobileqq/apollo/utils/ApolloUtil:a	(Landroid/content/Context;)Z
    //   49: putfield 240	com/tencent/mobileqq/apollo/view/ApolloPanel:jdField_j_of_type_Boolean	Z
    //   52: aload_0
    //   53: iconst_1
    //   54: putfield 218	com/tencent/mobileqq/apollo/view/ApolloPanel:jdField_i_of_type_Boolean	Z
    //   57: aload_0
    //   58: new 242	com/tencent/mobileqq/apollo/view/ApolloPanel$KapuPkgStateReceiver
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 243	com/tencent/mobileqq/apollo/view/ApolloPanel$KapuPkgStateReceiver:<init>	(Lcom/tencent/mobileqq/apollo/view/ApolloPanel;)V
    //   66: putfield 245	com/tencent/mobileqq/apollo/view/ApolloPanel:jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$KapuPkgStateReceiver	Lcom/tencent/mobileqq/apollo/view/ApolloPanel$KapuPkgStateReceiver;
    //   69: new 247	android/content/IntentFilter
    //   72: dup
    //   73: invokespecial 248	android/content/IntentFilter:<init>	()V
    //   76: astore_3
    //   77: aload_3
    //   78: ldc 250
    //   80: invokevirtual 254	android/content/IntentFilter:addDataScheme	(Ljava/lang/String;)V
    //   83: aload_3
    //   84: ldc_w 256
    //   87: invokevirtual 259	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   90: aload_3
    //   91: ldc_w 261
    //   94: invokevirtual 259	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   97: aload_2
    //   98: aload_0
    //   99: getfield 245	com/tencent/mobileqq/apollo/view/ApolloPanel:jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$KapuPkgStateReceiver	Lcom/tencent/mobileqq/apollo/view/ApolloPanel$KapuPkgStateReceiver;
    //   102: aload_3
    //   103: invokevirtual 267	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   106: pop
    //   107: goto -71 -> 36
    //   110: astore_2
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_2
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	ApolloPanel
    //   31	2	1	bool	boolean
    //   43	55	2	localContext	Context
    //   110	4	2	localObject	Object
    //   76	27	3	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   2	32	110	finally
    //   39	107	110	finally
  }
  
  private void B()
  {
    try
    {
      if ((this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$KapuPkgStateReceiver != null))
      {
        super.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$KapuPkgStateReceiver);
        this.jdField_i_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$KapuPkgStateReceiver = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int a(List<anst> paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt >= paramList.size())) {
      throw new IllegalArgumentException("packageBinderList is null or tabIndex is out");
    }
    int i2 = 0;
    int i1 = 0;
    if (i2 < paramInt)
    {
      anst localanst = (anst)paramList.get(i2);
      if (localanst == null) {
        break label73;
      }
      i1 = localanst.a() + i1;
    }
    label73:
    for (;;)
    {
      i2 += 1;
      break;
      return i1;
    }
  }
  
  private amxp a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return null;
    }
    amst localamst = (amst)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211);
    amxp localamxp = localamst.a();
    if (localamxp.jdField_a_of_type_Int != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[checkJumpToGameTab] checkGameTab jumpGameId:", Integer.valueOf(localamxp.jdField_a_of_type_Int), ",from:", Integer.valueOf(localamxp.jdField_b_of_type_Int), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      }
      if (!this.jdField_b_of_type_Boolean) {
        localamst.a(-1, -1);
      }
      return localamxp;
    }
    return null;
  }
  
  private Drawable a(ApolloActionData paramApolloActionData)
  {
    Object localObject5 = null;
    Object localObject4;
    if (paramApolloActionData == null) {
      localObject4 = null;
    }
    label100:
    do
    {
      Resources localResources;
      do
      {
        return localObject4;
        localResources = super.getResources();
        try
        {
          localObject1 = localResources.getDrawable(2130838010);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Drawable localDrawable;
            String str;
            localObject1 = null;
            QLog.e("ApolloPanel", 1, "[getNewActionStaticDrawable] exception=", localException1);
            Object localObject2 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          for (;;)
          {
            Object localObject1 = null;
            QLog.e("ApolloPanel", 1, "[getNewActionStaticDrawable] error=", localOutOfMemoryError1);
            Object localObject3 = null;
          }
        }
        for (;;)
        {
          try
          {
            localDrawable = localResources.getDrawable(2130843719);
            localObject4 = localObject1;
            if (paramApolloActionData.status == 0) {
              break;
            }
            str = Integer.toString(1);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            break label227;
          }
          catch (Exception localException2)
          {
            break label209;
          }
          try
          {
            localObject4 = new URL("apollo_pic", null, paramApolloActionData.actionId + "_" + paramApolloActionData.actionName);
            localObject5 = localObject4;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            QLog.e("ApolloPanel", 1, new Object[] { "[getNewActionStaticDrawable] get url exception=", null });
            break label100;
          }
        }
        localObject4 = localObject1;
      } while (localObject5 == null);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = agej.a(90.0F, localResources);
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight;
      ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = false;
      localObject1 = URLDrawable.getDrawable(localObject5, (URLDrawable.URLDrawableOptions)localObject4);
      localObject4 = localObject1;
    } while (((URLDrawable)localObject1).getStatus() == 1);
    ((URLDrawable)localObject1).setTag(paramApolloActionData);
    ((URLDrawable)localObject1).addHeader("apollo_uin", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    ((URLDrawable)localObject1).addHeader("apollo_tasks", str);
    return localObject1;
  }
  
  private void a(View paramView, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramView == null) || (paramString == null)) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Blrr != null)
        {
          if (this.jdField_a_of_type_JavaUtilDeque == null) {
            this.jdField_a_of_type_JavaUtilDeque = new LinkedList();
          }
          this.jdField_a_of_type_JavaUtilDeque.addLast(new ansj(paramView, paramInt1, paramString, paramInt2, paramOnClickListener));
          return;
        }
        paramString = blrr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).b(paramInt2).a(paramString).a(16.0F).a(-1);
        paramString.c(paramInt1);
        paramString = new blrt(paramString).b(Color.argb(255, 0, 0, 0)).a(5).a();
      } while (paramString == null);
      this.jdField_a_of_type_Blrr = paramString.a();
    } while (this.jdField_a_of_type_Blrr == null);
    this.jdField_a_of_type_Blrr.a(82);
    this.jdField_a_of_type_Blrr.c(2);
    this.jdField_a_of_type_Blrr.a(paramView);
    this.jdField_a_of_type_Blrr.a(paramOnClickListener);
    this.jdField_a_of_type_Blrr.setOnDismissListener(new anse(this));
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[realshowNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", pkgId=", Integer.valueOf(paramInt3), ", extra=", paramBundle });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramApolloActionData == null)) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
    Object localObject4 = String.format("key_new_action_info_%s", new Object[] { String.valueOf(paramInt3) });
    Object localObject5 = ((SharedPreferences)localObject3).getString((String)localObject4, "");
    int i1 = 0;
    paramInt3 = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    String str = String.format("{\"operateObjectID\":%d}", new Object[] { Integer.valueOf(paramApolloActionData.actionId) });
    if (!TextUtils.isEmpty((CharSequence)localObject5))
    {
      paramInt3 = i1;
      localObject1 = localObject2;
      try
      {
        localObject5 = new JSONObject((String)localObject5);
        paramInt3 = i1;
        localObject1 = localObject2;
        i1 = ((JSONObject)localObject5).getInt("adId");
        paramInt3 = i1;
        localObject1 = localObject2;
        localObject2 = ((JSONObject)localObject5).getString("traceInfo");
        paramInt3 = i1;
        localObject1 = localObject2;
        amsx.a(101, String.valueOf(i1), (String)localObject2, str);
        paramInt3 = i1;
        localObject1 = localObject2;
        ((SharedPreferences)localObject3).edit().remove((String)localObject4).commit();
        localObject1 = localObject2;
        paramInt3 = i1;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label338:
          QLog.e("ApolloPanel", 1, "realshowNewActionFloatView Exception:", localThrowable);
        }
      }
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(super.getContext()).inflate(2131558670, null));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setId(2131362787);
      ((ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368483)).setOnClickListener(this);
      localObject4 = super.getResources();
      localObject3 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368471);
      localObject2 = new anrg(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      ((anrg)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramApolloActionData;
      ((ImageView)localObject3).setImageDrawable(a(paramApolloActionData));
      ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380231)).setText(paramApolloActionData.actionName);
      ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380230)).setText(paramApolloActionData.description);
      ((Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363886)).setOnClickListener(new anrq(this, paramApolloActionData, paramInt3, localObject1, str));
      localObject3 = (Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363714);
      i1 = super.getHeight() - this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight();
      if (i1 < agej.a(213.0F, (Resources)localObject4))
      {
        localObject5 = (LinearLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131365023);
        i1 = i1 - (int)((Resources)localObject4).getDimension(2131296452) - (int)((Resources)localObject4).getDimension(2131296453);
        ((RelativeLayout.LayoutParams)((LinearLayout)localObject5).getLayoutParams()).bottomMargin = ((int)(i1 * 0.1D));
        ((RelativeLayout.LayoutParams)((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131365018)).getLayoutParams()).bottomMargin = ((int)(i1 * 0.2D));
      }
      localObject4 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368230);
      localObject5 = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380254);
      ((TextView)localObject5).setMaxLines(1);
      switch (paramInt2)
      {
      case 24: 
      case 26: 
      default: 
        label736:
        switch (paramInt1)
        {
        }
        break;
      }
    }
    for (;;)
    {
      paramBundle = new RelativeLayout.LayoutParams(-1, -1);
      paramBundle.addRule(2, 2131362801);
      addView(this.jdField_d_of_type_AndroidWidgetRelativeLayout, paramBundle);
      paramBundle = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      paramBundle.setDuration(500L);
      paramBundle.setRepeatCount(0);
      paramBundle.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.startAnimation(paramBundle);
      this.jdField_k_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        break;
      }
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_flame_view", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(paramApolloActionData.actionId) });
      return;
      QLog.e("ApolloPanel", 1, "realshowNewActionFloatView no tianshu action data");
      break label338;
      ((ImageView)localObject4).setVisibility(8);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(anzj.a(2131699392));
      break label736;
      ((ImageView)localObject4).setVisibility(8);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(anzj.a(2131699382));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838559);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FFFF8444"));
      ((TextView)localObject5).setText(paramApolloActionData.extraWording);
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838560);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(anzj.a(2131699384));
      localObject4 = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380242);
      ((TextView)localObject4).setVisibility(0);
      ((TextView)localObject4).setText(String.valueOf(paramApolloActionData.currencyNum));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838561);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(anzj.a(2131699393));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838582);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(super.getResources().getString(2131690022));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838582);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(super.getResources().getString(2131690022));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838580);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setMaxLines(2);
      ((TextView)localObject5).setText(super.getResources().getString(2131690044));
      break label736;
      ((Button)localObject3).setText(anzj.a(2131699387));
      ((Button)localObject3).setOnClickListener(new anrr(this, localThrowable, paramApolloActionData, paramInt3, localObject1, str));
      continue;
      ((Button)localObject3).setText(anzj.a(2131699397));
      ((Button)localObject3).setOnClickListener(new anrs(this, paramBundle, paramApolloActionData, paramInt3, localObject1, str));
      continue;
      ((Button)localObject3).setText(anzj.a(2131699386));
      ((Button)localObject3).setOnClickListener(new anrt(this, paramApolloActionData, paramBundle, paramInt3, localObject1, str));
      continue;
      ((Button)localObject3).setText(super.getResources().getString(2131690020));
      ((Button)localObject3).setOnClickListener(new anru(this, paramApolloActionData, paramInt3, localObject1, str));
      continue;
      ((Button)localObject3).setText(super.getResources().getString(2131690045));
      ((Button)localObject3).setOnClickListener(new anrv(this, paramApolloActionData, paramInt3, localObject1, str));
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.35(this, paramAppInfo, paramString));
  }
  
  private void a(List<anst> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramList == null) || (paramList1 == null)) {
      return;
    }
    this.jdField_c_of_type_Ansk.a(paramList, paramList1, paramBoolean);
  }
  
  private boolean a(String paramString)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      bool = false;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getInt(paramString, 0) == 1) {
      return bool;
    }
    return false;
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      return amsx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return false;
  }
  
  private int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      return ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return 0;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Anrh = new anrh(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Anrh.b(paramInt2);
    this.jdField_a_of_type_Anrh.a(this);
    if (paramInt1 == 0) {
      this.jdField_a_of_type_Anrh.a(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func showApolloPanel begins. Thread id = " + Thread.currentThread().getId());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Anrh);
      t();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putInt(paramString, 1).apply();
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] actionId=", Integer.valueOf(paramInt1), ", pkgId=", Integer.valueOf(paramInt2) });
    }
    u();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.w("ApolloPanel", 1, "[showNewActionFloatView] app null, abort");
    }
    ApolloActionData localApolloActionData;
    do
    {
      return;
      Object localObject = (annx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      localApolloActionData = ((annx)localObject).a(paramInt1);
      if (localApolloActionData == null)
      {
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] no action info, abort");
        return;
      }
      boolean bool2 = ((annx)localObject).b(paramInt1);
      if ((((annx)localObject).c(paramInt1)) || (localApolloActionData.feeType == 1)) {}
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
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(new anrp(this, localApolloActionData, paramInt2));
        ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(localApolloActionData.actionId, null, null, 0, 0.0F, 0, "newActionFloatView");
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
        if (((amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
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
        if ((amtk.jdField_a_of_type_Boolean) && (b()) && (!TextUtils.isEmpty(amtk.jdField_b_of_type_JavaLangString)))
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_c_of_type_Ansk.a(paramInt);
  }
  
  private void g(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
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
      this.jdField_c_of_type_Ansk = this.jdField_b_of_type_Ansk;
      return;
    }
    this.jdField_c_of_type_Ansk = this.jdField_a_of_type_Ansk;
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[initData]");
    }
    k();
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[hideNewActionFloatView]");
    }
    if ((this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_d_of_type_AndroidWidgetRelativeLayout.getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[hideNewActionFloatView] remove");
      }
      super.removeView(this.jdField_d_of_type_AndroidWidgetRelativeLayout);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
    }
    View localView = super.findViewById(2131362787);
    if (localView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[hideNewActionFloatView] remove by id");
      }
      super.removeView(localView);
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(2, 500L);
  }
  
  private void w()
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.36(this));
  }
  
  private void x()
  {
    if (getVisibility() == 0)
    {
      if (!this.jdField_a_of_type_Amtl.b()) {
        break label44;
      }
      QLog.d("ApolloPanel", 2, "showGuidePageFor3D for json");
      this.m = true;
      this.jdField_a_of_type_Amtl.b(false);
      q();
    }
    label44:
    while (!this.jdField_a_of_type_Amtl.a()) {
      return;
    }
    QLog.d("ApolloPanel", 2, "showGuidePageFor3D for action");
    this.m = true;
    this.jdField_a_of_type_Amtl.a(false);
    q();
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[checkInitGuidePage]");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView = ((ApolloPanelGuideView)LayoutInflater.from(super.getContext()).inflate(2131558668, null));
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setClickCallback(this.jdField_a_of_type_Ansl);
      addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView, -1, -1);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.bringToFront();
  }
  
  private void z()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.getParent() == this))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[hideGuidePageFor3D] remove");
      }
      super.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView = null;
      jdField_b_of_type_Int = 0;
    }
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
        i2 += ((anst)this.jdField_a_of_type_JavaUtilList.get(i1)).a();
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
  
  public int a(BaseChatPie paramBaseChatPie, anra paramanra, ApolloActionData paramApolloActionData)
  {
    int i2;
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      i2 = 0;
      return i2;
    }
    annx localannx = (annx)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    paramBaseChatPie = (amsx)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    boolean bool = localannx.b(paramApolloActionData.actionId);
    int i1;
    if ((paramApolloActionData.hasSound) || (paramanra.jdField_e_of_type_Int > 0)) {
      i1 = 1;
    }
    for (;;)
    {
      if (localannx.c(paramApolloActionData.actionId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "data actionId:", Integer.valueOf(paramApolloActionData.actionId), "typeValue:", Integer.valueOf(i1) });
        }
        return i1 | 0x2;
        if (paramApolloActionData.actionType == 8) {
          i1 = 1024;
        }
      }
      else
      {
        i2 = i1;
        if (paramApolloActionData.feeType == 6)
        {
          if (bool)
          {
            i2 = 16;
            i2 = i1 | i2;
          }
        }
        else
        {
          int i3 = i2;
          if (paramApolloActionData.feeType == 2)
          {
            if (!bool) {
              break label266;
            }
            i1 = 4;
            label203:
            i3 = i2 | i1;
          }
          i1 = i3;
          if (paramApolloActionData.feeType == 9) {
            i1 = i3 | 0x2000;
          }
          i2 = i1;
          if (paramApolloActionData.feeType != 7) {
            break;
          }
          if (!bool) {
            break label274;
          }
        }
        label266:
        label274:
        for (i2 = 8;; i2 = 512)
        {
          return i1 | i2;
          i2 = 64;
          break;
          i1 = 128;
          break label203;
        }
      }
      i1 = 0;
    }
  }
  
  public anst a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "getViewBinder type=" + paramInt);
    }
    return this.jdField_c_of_type_Ansk.a(paramInt);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(1, "actionPanel");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "actionpanel onOpen");
      }
      this.jdField_i_of_type_Int = -1;
    }
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
        anst localanst = (anst)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((localanst.jdField_c_of_type_Int == 100) && ((localanst instanceof anqo)) && (((anqo)localanst).a != null) && (((anqo)localanst).a.gameId == paramInt2)) {
          ((anqo)localanst).a(paramInt1);
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
      if ((paramApolloPanel != null) && ((paramApolloPanel instanceof anqo)))
      {
        paramApolloPanel = (anqo)paramApolloPanel;
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
      paramApolloPanel = angi.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    if ((this.jdField_a_of_type_Ansr != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = this.jdField_a_of_type_Ansr.a();
      if (((List)localObject).size() > paramInt)
      {
        localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] packageId=", Integer.valueOf(((ApolloActionPackage)localObject).packageId), ", tabIndex= ", Integer.valueOf(paramInt), ", isUpdate=", Boolean.valueOf(((ApolloActionPackage)localObject).isUpdate), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
        }
        if ((((ApolloActionPackage)localObject).packageId == 8) && (!((ApolloActionPackage)localObject).isRecommendTabClick))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).edit().putBoolean("apollo_sp_key_recommend_tab_click", true).commit();
          ((ApolloActionPackage)localObject).isRecommendTabClick = true;
          ((anss)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
        if ((((ApolloActionPackage)localObject).isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= ((ApolloActionPackage)localObject).redStartTime))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "clear tab red packageId=" + ((ApolloActionPackage)localObject).packageId + " tabIndex = " + paramInt);
          }
          ((anss)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          ((ApolloActionPackage)localObject).isUpdate = false;
          paramInt = ((ApolloActionPackage)localObject).redFlowId;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] pkg=", Integer.valueOf(((ApolloActionPackage)localObject).packageId), ", new action id=", Integer.valueOf(paramInt) });
          }
          ThreadManager.post(new ApolloPanel.21(this, (ApolloActionPackage)localObject), 5, null, true);
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
    post(new ApolloPanel.14(this, paramString, paramInt));
  }
  
  public void a(anra paramanra)
  {
    int i3 = 0;
    if ((paramanra == null) || (paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null)) {}
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
        Object localObject1 = (anst)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (((anst)localObject1).jdField_a_of_type_JavaUtilList == null) {}
        while (((anst)localObject1).jdField_c_of_type_Int != 2)
        {
          i1 += 1;
          break;
        }
        Object localObject2;
        if (((anst)localObject1).jdField_b_of_type_Int != 5)
        {
          ((anst)localObject1).b(5);
          localObject2 = new anra();
          ((anra)localObject2).jdField_b_of_type_Int = 2;
          ApolloActionData localApolloActionData = new ApolloActionData();
          localApolloActionData.actionName = super.getResources().getString(2131690012);
          ((anra)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
          ((anst)localObject1).jdField_a_of_type_JavaUtilList.add(0, localObject2);
        }
        localObject1 = ((anst)localObject1).jdField_a_of_type_JavaUtilList;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          localObject2 = (annx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          paramanra.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramanra, paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
        }
        ((List)localObject1).add(1, paramanra);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "add action to fav action " + paramanra.toString());
        }
        i2 = 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (i2 != 0))
      {
        a(jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (i2 != 0));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initPanel] jumpPkdId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    paramBaseChatPie = (amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (paramBaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[initPanel] apollo status open, remember jump info");
      }
      this.jdField_h_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = paramInt2;
    }
    this.jdField_i_of_type_Int = paramInt3;
    paramBaseChatPie.a(this.jdField_a_of_type_Amtj);
    this.jdField_a_of_type_Amtl = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131363142));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363854));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365020));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365019));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363829));
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363723));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_c_of_type_ComTencentImageURLImageView.getParent());
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131363823));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362753));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)super.findViewById(2131362800));
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    Drawable localDrawable = super.getContext().getResources().getDrawable(2130838603);
    paramSessionInfo.addState(new int[] { 16842919 }, localDrawable);
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    localDrawable = super.getContext().getResources().getDrawable(2130838602);
    paramSessionInfo.addState(new int[] { -16842919 }, localDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131362801));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter = new ApolloPanelAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131378340));
    this.jdField_a_of_type_Ansr = new ansr(super.getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Ansr);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    super.findViewById(2131378336).setBackgroundColor(super.getContext().getResources().getColor(2131165621));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131370331));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362795));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362794));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362793));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362744));
    this.jdField_a_of_type_Amtq = paramBaseChatPie.a();
    if (this.jdField_a_of_type_Amtq != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_Amtq.a.get()));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(super.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout).a(5).a();
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = ((bbav)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf("103100.103200.103250"));
      paramBaseChatPie = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (paramBaseChatPie != null) {
        paramBaseChatPie.a(100);
      }
      bmup.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramBaseChatPie = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if ((paramBaseChatPie.getBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)) && (this.jdField_i_of_type_Int != 7))
      {
        paramBaseChatPie.edit().putBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
        paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.obtainMessage(51).sendToTarget();
        }
      }
      if (amsx.jdField_a_of_type_Boolean)
      {
        QLog.d("ApolloPanel", 1, "[initPanel] getUserApolloInfo");
        this.jdField_b_of_type_Boolean = true;
        ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 1082392704, "Open Panel");
        amsx.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_Amtq != null) {
        this.jdField_a_of_type_Amtq.a(null);
      }
      paramBaseChatPie = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      if ((paramBaseChatPie == null) || (!paramBaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_JavaLangString))) {
        break label1047;
      }
    }
    label1047:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_d_of_type_Boolean = bool;
      setBackgroundColor(super.getResources().getColor(2131165623));
      s();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "init panel done");
      }
      return;
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    long l1 = System.currentTimeMillis();
    if (paramApolloActionData == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "updateItemStatus action= " + paramApolloActionData.actionId + " action name =" + paramApolloActionData.actionName);
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
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
        anrc localanrc;
        anra localanra;
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
          localanrc = (anrc)localLinearLayout.getChildAt(i3).getTag();
          if (localanrc != null)
          {
            localanra = localanrc.a;
            if ((localanra != null) && (localanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramApolloActionData.actionId))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).post(new ApolloPanel.20(this, localanrc));
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
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, boolean paramBoolean)
  {
    ThreadManager.post(new ApolloPanel.34(this, paramAppInfo, paramBoolean, paramString), 5, null, true);
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
      } while (this.jdField_a_of_type_Bhpc != null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "showAidDialog title=" + paramString2 + " content=" + paramString3 + "rightString=" + paramString4 + " url=" + paramString5);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
    n();
    int i1;
    if ("onlyRightType".equals(paramString5))
    {
      i1 = 1;
      paramString1 = new anrj(this);
      label136:
      paramString6 = super.getResources().getString(2131694462);
      if (i1 == 0) {
        break label399;
      }
    }
    label399:
    for (paramString5 = null;; paramString5 = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener)
    {
      this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, paramString2, paramString3, paramString6, paramString4, paramString1, paramString5);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
        break;
      }
      this.jdField_a_of_type_Bhpc.show();
      return;
      if ("moreInfo".equals(paramString5))
      {
        paramString1 = new anrk(this, paramString7);
        i1 = 0;
        break label136;
      }
      if ("requestSSO".equals(paramString5))
      {
        paramString1 = new anrl(this, paramString1, paramString7, paramString8);
        i1 = 0;
        break label136;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(String.valueOf(9))))
      {
        ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString7, paramString9);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_view", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + paramString7, "0" });
        return;
      }
      paramString1 = new anrm(this, paramString5, paramString6, paramString7, paramString1, paramString9);
      i1 = 0;
      break label136;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] refreshByGetUserAction=", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("ApolloPanel", 1, "[initPanelData] mBaseChatPie or mBaseChatPie.app is null");
    }
    ArrayList localArrayList1;
    annx localannx;
    List localList;
    do
    {
      do
      {
        return;
        new ArrayList();
        localArrayList1 = new ArrayList();
        localannx = (annx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      } while (localannx == null);
      localList = localannx.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (localList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, "packageList is null.");
    return;
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    ArrayList localArrayList2 = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    label525:
    label1830:
    for (boolean bool = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, super.getContext());; bool = false)
    {
      QLog.d("ApolloPanel", 1, new Object[] { "[initPanelData] showKapuUnlockAction=", Boolean.valueOf(bool) });
      int i5 = 0;
      int i1 = 0;
      int i2 = -1;
      label208:
      ApolloActionPackage localApolloActionPackage;
      if (i5 < localList.size())
      {
        localApolloActionPackage = (ApolloActionPackage)localList.get(i5);
        if (localApolloActionPackage == null) {
          break label2500;
        }
        if (localApolloActionPackage.packageId != 4) {}
      }
      label550:
      label1838:
      label2490:
      label2493:
      label2500:
      for (;;)
      {
        i5 += 1;
        break label208;
        if (this.jdField_c_of_type_Ansk.a(localApolloActionPackage.packageId))
        {
          String str = bhlo.c();
          if ((!TextUtils.isEmpty(localApolloActionPackage.startVersion)) && (!TextUtils.isEmpty(localApolloActionPackage.endVersion)) && ((!bhyh.a(localApolloActionPackage.startVersion, str)) || (!bhyh.a(str, localApolloActionPackage.endVersion))))
          {
            QLog.w("ApolloPanel", 1, "version not correct packageId=" + localApolloActionPackage.packageId);
          }
          else
          {
            long l2 = System.currentTimeMillis();
            anst localanst = a(localApolloActionPackage.type);
            if (localanst != null)
            {
              localanst.jdField_d_of_type_Int = localApolloActionPackage.packageId;
              ArrayList localArrayList3 = new ArrayList();
              Object localObject1;
              Object localObject2;
              Object localObject3;
              Object localObject4;
              int i3;
              long l1;
              ApolloActionData localApolloActionData;
              if (localApolloActionPackage.type == 2)
              {
                localObject1 = localannx.a();
                localObject2 = (List)((Pair)localObject1).first;
                localObject3 = (List)((Pair)localObject1).second;
                if ((localObject2 != null) && (((List)localObject2).size() > 0))
                {
                  localanst.b(5);
                  localObject1 = new anra();
                  ((anra)localObject1).jdField_b_of_type_Int = 2;
                  localObject4 = new ApolloActionData();
                  ((ApolloActionData)localObject4).actionName = super.getResources().getString(2131690012);
                  ((anra)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)localObject4);
                  localArrayList3.add(localObject1);
                  localObject1 = null;
                  i3 = i1;
                  l1 = System.currentTimeMillis();
                  localObject4 = new StringBuilder();
                  if (localObject3 == null) {
                    break label2493;
                  }
                  i1 = i2;
                  i2 = 0;
                  if (i2 >= ((List)localObject3).size()) {
                    break label1477;
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
                    break;
                  }
                  localApolloActionData = (ApolloActionData)((List)localObject3).get(i2);
                  if (localApolloActionData != null) {
                    break label906;
                  }
                }
              }
              for (;;)
              {
                label588:
                i2 += 1;
                break label550;
                localanst.b(4);
                break;
                if (localApolloActionPackage.type == 100)
                {
                  localObject1 = localannx.j();
                  if ((localObject1 != null) && (((List)localObject1).size() > 0))
                  {
                    i3 = i1;
                    if ((localanst instanceof anqo))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloPanel", 2, new Object[] { "set panel game list, size=", Integer.valueOf(((List)localObject1).size()) });
                      }
                      ((anqo)localanst).a((List)localObject1);
                      localanst.b(100);
                      i3 = i1 + localanst.a();
                      localArrayList2.add(localanst);
                      localArrayList1.add(localApolloActionPackage);
                    }
                  }
                  for (;;)
                  {
                    localObject1 = null;
                    localObject2 = null;
                    localObject3 = null;
                    break;
                    QLog.i("ApolloPanel", 1, "load game info fail cause games == null");
                    i3 = i1;
                  }
                }
                if (localApolloActionPackage.packageId == 8)
                {
                  localObject2 = localannx.b();
                  localObject1 = (List)((Pair)localObject2).first;
                  localObject3 = (List)((Pair)localObject2).second;
                  localanst.b(0);
                  localObject2 = null;
                  i3 = i1;
                  break label525;
                }
                localObject3 = localannx.d(localApolloActionPackage.packageId);
                localObject1 = localannx.e(localApolloActionPackage.packageId);
                localanst.b(0);
                if (localApolloActionPackage.packageId == 6)
                {
                  localanst.b(9);
                  localannx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (List)localObject3);
                  localObject2 = null;
                  i3 = i1;
                  break label525;
                }
                if (localApolloActionPackage.packageId == 7) {
                  localannx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (List)localObject3);
                }
                localObject2 = null;
                i3 = i1;
                break label525;
                if (!localApolloActionData.verifyVersion(str))
                {
                  ((StringBuilder)localObject4).append(",version ").append(localApolloActionData.actionId);
                }
                else
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
                  {
                    if (localApolloActionData.sessionType == 2) {
                      ((StringBuilder)localObject4).append(",special C2C ").append(localApolloActionData.actionId);
                    }
                  }
                  else if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (localApolloActionData.sessionType == 1))
                  {
                    ((StringBuilder)localObject4).append(",special ").append(localApolloActionData.actionId);
                    continue;
                  }
                  if (((ApolloActionData)((List)localObject3).get(i2)).isShow == 0)
                  {
                    ((StringBuilder)localObject4).append(",hide ").append(localApolloActionData.actionId);
                  }
                  else
                  {
                    if ((!ApolloActionPackage.is3DPackage(localApolloActionPackage.packageId)) || (localApolloActionData.feeType != 10)) {
                      break label1125;
                    }
                    if (this.jdField_f_of_type_Int == 2) {
                      this.jdField_h_of_type_Boolean = true;
                    }
                    if (bool) {
                      break label1125;
                    }
                    ((StringBuilder)localObject4).append(",kapu unlock ").append(localApolloActionData.actionId);
                  }
                }
              }
              label1125:
              anra localanra = localanst.a(paramString);
              localanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
              localanra.jdField_a_of_type_Int = localApolloActionPackage.packageId;
              if (localApolloActionPackage.type == 2) {
                if ((localObject2 != null) && (((List)localObject2).size() > i2))
                {
                  localanra.jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject2).get(i2)).text;
                  localanra.jdField_d_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(i2)).textType;
                  localanra.jdField_e_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(i2)).audioId;
                  localanra.jdField_a_of_type_Float = ((ApolloFavActionData)((List)localObject2).get(i2)).audioStartTime;
                  localanra.jdField_f_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(i2)).playOriginalAudio;
                }
              }
              for (localanra.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localanra, localanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);; localanra.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localanra, localanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData))
              {
                localArrayList3.add(localanra);
                if ((i1 != -1) || (this.jdField_g_of_type_Int != localApolloActionData.actionId)) {
                  break label2490;
                }
                if (this.jdField_h_of_type_Int == -1)
                {
                  this.jdField_h_of_type_Int = localApolloActionPackage.packageId;
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] jump action match but no jump pkg, use ", Integer.valueOf(this.jdField_h_of_type_Int) });
                  }
                }
                if (this.jdField_h_of_type_Int != localApolloActionPackage.packageId) {
                  break label2490;
                }
                i1 = localArrayList3.size() - 1;
                break;
                if ((localObject1 != null) && (((List)localObject1).size() > i2))
                {
                  localanra.jdField_b_of_type_JavaLangString = ((ApolloActionPackageData)((List)localObject1).get(i2)).text;
                  localanra.jdField_d_of_type_Int = ((ApolloActionPackageData)((List)localObject1).get(i2)).textType;
                }
              }
              label1477:
              if (0 != 0) {
                throw new NullPointerException();
              }
              int i4 = i3;
              i2 = i1;
              if (localArrayList3.size() > 0)
              {
                localanst.c_(localArrayList3);
                if (this.jdField_h_of_type_Int == localApolloActionPackage.packageId)
                {
                  if (i1 == -1) {
                    break label1830;
                  }
                  localanst.c(i1);
                  jdField_a_of_type_Int = localanst.a(i1) + i3;
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] init sCurrentIndex with jump info, sCurrentIndex=", Integer.valueOf(jdField_a_of_type_Int), ", jumpActionIndex=", Integer.valueOf(i1) });
                  }
                }
                localArrayList2.add(localanst);
                if ((localApolloActionPackage.packageId == 8) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
                {
                  localApolloActionPackage.isRecommendTabClick = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getBoolean("apollo_sp_key_recommend_tab_click", false);
                  QLog.d("ApolloPanel", 1, new Object[] { "[initPanelData] isRecommendTabClick=", Boolean.valueOf(localApolloActionPackage.isRecommendTabClick) });
                }
                localArrayList1.add(localApolloActionPackage);
                i4 = i3 + localanst.a();
                i2 = i1;
              }
              for (;;)
              {
                if (QLog.isColorLevel())
                {
                  i1 = localApolloActionPackage.packageId;
                  if (localObject3 != null) {
                    break label1838;
                  }
                }
                for (localObject1 = null;; localObject1 = Integer.valueOf(((List)localObject3).size()))
                {
                  QLog.d("ApolloPanel", 2, new Object[] { "Tab add package:", Integer.valueOf(i1), ",actionPackageDatas size:", localObject1, ",findTime:", Long.valueOf(l1 - l2), ",remove actions ", ((StringBuilder)localObject4).toString() });
                  i1 = i4;
                  break;
                  jdField_a_of_type_Int = i3;
                  break label1548;
                }
                if (this.jdField_h_of_type_Boolean) {
                  A();
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
                }
                if ((this.jdField_g_of_type_Int == -1) && (this.jdField_h_of_type_Int == -1)) {
                  a(localArrayList2, localArrayList1, paramBoolean);
                }
                if ((this.jdField_g_of_type_Int != -1) && (i2 == -1) && (!this.jdField_c_of_type_Boolean))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, "[initPanelData] no jump action found, try to update json");
                  }
                  if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
                    this.jdField_a_of_type_AndroidWidgetImageView.post(new ApolloPanel.3(this));
                  }
                  this.jdField_c_of_type_Boolean = true;
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
                    ((amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(1);
                  }
                }
                while ((localArrayList2 != null) && (localArrayList2.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
                {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
                  l2 = NetConnInfoCenter.getServerTime();
                  l1 = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  localObject3 = new ArrayList();
                  localObject2 = localArrayList1.iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    paramString = (ApolloActionPackage)((Iterator)localObject2).next();
                    if ((paramString.isUpdate) && (paramString.packageId != 100))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloPanel", 2, "[initPanelData] delete red dot after 24h:" + ((List)localObject3).size());
                      }
                      if (NetConnInfoCenter.getServerTimeMillis() - ((SharedPreferences)localObject1).getLong("action_red_tab_update_" + paramString.packageId, 0L) > paramString.redInterval)
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
                  ThreadManager.post(new ApolloPanel.4(this, (List)localObject3), 5, null, true);
                }
                a(localArrayList1);
                b(localArrayList2);
                this.jdField_c_of_type_Ansk.a();
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
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null)) {
                  break;
                }
                this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new ApolloPanel.5(this));
                return;
                break label588;
                i4 = i3;
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
    ThreadManager.post(new ApolloPanel.2(this, paramBoolean1, paramString, paramBoolean2), 5, null, true);
  }
  
  public void a(List<ApolloActionPackage> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new ApolloPanel.8(this, paramList));
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
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
              if (this.jdField_a_of_type_Anrh != null) {
                this.jdField_a_of_type_Anrh.c();
              }
            } while (!paramBoolean);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, "actionpanel onOpen response");
            }
          } while (paramObject == null);
          localPair = (Pair)paramObject;
          paramObject = (String)((Pair)paramObject).first;
        } while ((TextUtils.isEmpty(paramObject)) || (!paramObject.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())));
        if (2 == ((Integer)localPair.second).intValue())
        {
          jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(jdField_a_of_type_Int);
          k();
          return;
        }
      } while (1 != ((Integer)localPair.second).intValue());
      ((amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(false, "panel open apollo", 1);
    } while (this.jdField_a_of_type_Anrh == null);
    this.jdField_a_of_type_Anrh.b(0);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, false);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Ansr != null)
    {
      Object localObject = this.jdField_a_of_type_Ansr.a();
      if ((localObject != null) && (this.jdField_k_of_type_Int >= 0) && (this.jdField_k_of_type_Int < ((List)localObject).size()))
      {
        localObject = (ApolloActionPackage)((List)localObject).get(this.jdField_k_of_type_Int);
        if ((localObject != null) && (((ApolloActionPackage)localObject).packageId == 100)) {
          return true;
        }
      }
    }
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 3);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return -1;
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() > jdField_a_of_type_Int) && ((this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int) instanceof anqo)))
    {
      ApolloGameData localApolloGameData = ((anqo)this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int)).b();
      if (localApolloGameData != null) {
        return localApolloGameData.gameId;
      }
    }
    return -1;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_key_url_append", "&showDialog=1&type=role");
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, "aio", annv.ah, null);
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
        e(jdField_b_of_type_Int);
        return;
      }
      if (paramInt == 1)
      {
        if (!auog.a(ApolloUtil.jdField_a_of_type_JavaLangString))
        {
          c(paramInt, 3);
          ((amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_Anpy);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_JavaUtilList);
        b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        return;
      }
    } while (paramInt != 2);
    e(jdField_b_of_type_Int);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jumpPkgId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] mBaseChatPie or mBaseChatPie.app is null");
      return;
    }
    amsx localamsx = (amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (localamsx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 1)
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
    if ((localObject != null) && (((amxp)localObject).jdField_a_of_type_Int > 0) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      i1 = 0;
      label178:
      if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label1244;
      }
      if (!(this.jdField_a_of_type_JavaUtilList.get(i1) instanceof anqo)) {}
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
          if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] checkGameTab jumpGameId:" + ((amxp)localObject).jdField_a_of_type_Int + ",gameTabIndex:" + i1);
        return;
        i1 += 1;
        break label178;
      }
      if ((paramInt1 == -1) && (paramInt2 == -1))
      {
        QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] abort finding action index");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter == null))
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
      anra localanra;
      if ((i7 < i8) && (i1 == -1))
      {
        localObject = (anst)this.jdField_a_of_type_JavaUtilList.get(i7);
        if (localObject == null) {
          break label1237;
        }
        if ((paramInt1 != -1) && (((anst)localObject).jdField_d_of_type_Int == paramInt1))
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
                this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
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
            localamsx.a(1);
            return;
          }
          i2 = i4;
          i5 = i1;
          if (!(localObject instanceof anqo))
          {
            localList = ((anst)localObject).jdField_a_of_type_JavaUtilList;
            if ((localList == null) || (localList.size() <= 0)) {
              break label952;
            }
            i2 = 0;
            i5 = localList.size();
            if (i2 >= i5) {
              break label1228;
            }
            localanra = (anra)localList.get(i2);
            if ((localanra != null) && (localanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramInt2))
            {
              ((anst)localObject).c(i2);
              i1 = ((anst)localObject).a(i2) + i3;
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
            i3 = ((anst)localObject).a() + i3;
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
        if ((localObject instanceof anqo)) {
          break label909;
        }
        localList = ((anst)localObject).jdField_a_of_type_JavaUtilList;
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
            localanra = (anra)localList.get(i6);
            if ((localanra != null) && (localanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramInt2))
            {
              if (paramInt1 != -1)
              {
                i2 = i4;
                i5 = i1;
                if (paramInt1 != ((anst)localObject).jdField_d_of_type_Int) {
                  break;
                }
              }
              ((anst)localObject).c(i6);
              i5 = i3 + ((anst)localObject).a(i6);
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
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[showKapuLockActionView] action=", paramApolloActionData });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramApolloActionData == null)) {}
    do
    {
      return;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(super.getContext()).inflate(2131558670, null));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setId(2131362787);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368250).setVisibility(4);
      ((ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368483)).setOnClickListener(this);
      Object localObject2 = super.getResources();
      Object localObject1 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368471);
      new anrg(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramApolloActionData;
      ((ImageView)localObject1).setImageDrawable(a(paramApolloActionData));
      ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380231)).setText(paramApolloActionData.actionName);
      ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380230)).setText(paramApolloActionData.description);
      ((Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363886)).setOnClickListener(new anrw(this, paramApolloActionData));
      localObject1 = (Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363714);
      int i1 = super.getHeight() - this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight();
      if (i1 < agej.a(213.0F, (Resources)localObject2))
      {
        localObject3 = (LinearLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131365023);
        i1 = i1 - (int)((Resources)localObject2).getDimension(2131296452) - (int)((Resources)localObject2).getDimension(2131296453);
        ((RelativeLayout.LayoutParams)((LinearLayout)localObject3).getLayoutParams()).bottomMargin = ((int)(i1 * 0.1D));
        ((RelativeLayout.LayoutParams)((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131365018)).getLayoutParams()).bottomMargin = ((int)(i1 * 0.2D));
      }
      localObject2 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368230);
      Object localObject3 = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380254);
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838580);
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setMaxLines(2);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(super.getResources().getString(2131690044));
      ((Button)localObject1).setText(super.getResources().getString(2131690045));
      ((Button)localObject1).setOnClickListener(new anrx(this, paramApolloActionData));
      localObject1 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131362801);
      addView(this.jdField_d_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      ((TranslateAnimation)localObject1).setDuration(500L);
      ((TranslateAnimation)localObject1).setRepeatCount(0);
      ((TranslateAnimation)localObject1).setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.startAnimation((Animation)localObject1);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clkunlocked", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(paramApolloActionData.actionId) });
  }
  
  public void b(String paramString)
  {
    g(0);
    a(paramString, false);
  }
  
  public void b(List<anst> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new ApolloPanel.9(this, paramList));
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
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
      a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false, paramBoolean);
      return;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      amsx localamsx = (amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if (localamsx != null)
      {
        localamsx.a(this.jdField_a_of_type_Anpy);
        int i1 = 0;
        if (!auog.a(ApolloUtil.jdField_a_of_type_JavaLangString)) {
          i1 = 1;
        }
        localamsx.a(i1);
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
        i2 += ((anst)this.jdField_a_of_type_JavaUtilList.get(i1)).a();
        i1 += 1;
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i2, false);
          a(i2);
          Object localObject = this.jdField_a_of_type_Ansr.a();
          if (localObject == null) {
            break;
          }
          if (((List)localObject).isEmpty()) {
            return;
          }
          localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
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
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {}
    QQAppInterface localQQAppInterface;
    SessionInfo localSessionInfo;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    } while ((localQQAppInterface == null) || (localSessionInfo == null));
    int i1 = ((amsx)localQQAppInterface.getManager(153)).b(localQQAppInterface.c());
    String str = localSessionInfo.jdField_a_of_type_JavaLangString;
    if (i1 == 0) {}
    for (i1 = 0;; i1 = 1)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "state_open_clk", str, i1, 0, new String[] { String.valueOf(ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int)), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] index=", Integer.valueOf(paramInt) });
    }
    if (this.jdField_a_of_type_Ansr == null) {}
    int i1;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_Ansr.a();
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
      paramInt = ((ApolloActionPackage)localObject).packageId;
      i1 = ((ApolloActionPackage)localObject).type;
    } while ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject = (amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (i1 == 2) {
      ((amsx)localObject).a(paramInt, true);
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] packageId=", Integer.valueOf(paramInt) });
      return;
      if ((i1 != 100) && (((amsx)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)) {
        ((amsx)localObject).a(paramInt, false);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      bhsq.a("apollo_panel_open", null);
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
    if ((paramInt != 0) && (this.jdField_a_of_type_Blrr != null) && (this.jdField_a_of_type_Blrr.isShowing())) {
      this.jdField_a_of_type_Blrr.dismiss();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_Ansr != null))
    {
      i1 = a(jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_Ansr.a();
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
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "tabexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), i1, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
  
  public void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("ApolloPanel", 1, "[showGuidePageForOpenCmshow] mBaseChatPie or mBaseChatPie.app is null");
    }
    ArrayList localArrayList;
    Object localObject1;
    do
    {
      return;
      QLog.i("ApolloPanel", 1, "showGuidePageForOpenCmshow dataType:" + paramInt);
      localArrayList = new ArrayList();
      localObject1 = (annx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
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
      localObject1 = ((annx)localObject1).d(400);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        break;
      }
      QLog.e("ApolloPanel", 1, "[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
      ApolloUtil.b("[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (21 != this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g()));
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aJ();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.40(this));
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
          localObject2 = new anqb(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          ((anqb)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject1).get(paramInt));
          localArrayList.add(localObject2);
          paramInt += 1;
          continue;
          label284:
          localObject1 = ((annx)localObject1).f();
          if ((localObject1 == null) || (((List)localObject1).isEmpty()))
          {
            QLog.e("ApolloPanel", 1, "[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
            ApolloUtil.b("[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (21 != this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g())) {
              break;
            }
            if (Looper.getMainLooper() == Looper.myLooper())
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aJ();
              return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.41(this));
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
          localObject2 = new anrg(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          ((anrg)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject1).get(paramInt));
          localArrayList.add(localObject2);
          paramInt += 1;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          y();
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setGuideType(1);
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setActions(localArrayList);
        }
        while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null))
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "exp_panelnewuser_show", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), jdField_b_of_type_Int, new String[] { String.valueOf(this.jdField_c_of_type_Int), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
          return;
          ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.42(this, localArrayList));
        }
        break;
      }
    }
  }
  
  public void f()
  {
    ThreadManager.post(new ApolloPanel.7(this), 5, null, false);
  }
  
  public void g()
  {
    int i4 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "del fav action");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    int i3;
    label467:
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
          break label467;
        }
        anst localanst = (anst)this.jdField_a_of_type_JavaUtilList.get(i2);
        if (localanst.jdField_c_of_type_Int == 2)
        {
          List localList = localanst.jdField_a_of_type_JavaUtilList;
          if ((localList == null) || (localList.size() == 0))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloPanel", 2, "no fav action yet");
            return;
          }
          Object localObject1 = (annx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          if (localObject1 == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("ApolloPanel", 2, "apolloDaoManager null");
            return;
          }
          localList.clear();
          Object localObject2 = ((annx)localObject1).a();
          localObject1 = (List)((Pair)localObject2).first;
          localObject2 = (List)((Pair)localObject2).second;
          Object localObject3 = (annx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localanst.b(5);
            localObject3 = new anra();
            ((anra)localObject3).jdField_b_of_type_Int = 2;
            ApolloActionData localApolloActionData = new ApolloActionData();
            localApolloActionData.actionName = super.getResources().getString(2131690012);
            ((anra)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
            localList.add(localObject3);
          }
          for (;;)
          {
            i3 = i1;
            if (i4 >= ((List)localObject2).size()) {
              break;
            }
            localObject3 = localanst.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
            ((anra)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject2).get(i4));
            ((anra)localObject3).jdField_a_of_type_Int = localanst.jdField_d_of_type_Int;
            if ((localObject1 != null) && (((List)localObject1).size() > i2))
            {
              ((anra)localObject3).jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject1).get(i4)).text;
              ((anra)localObject3).jdField_d_of_type_Int = ((ApolloFavActionData)((List)localObject1).get(i4)).textType;
              ((anra)localObject3).jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (anra)localObject3, ((anra)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
            }
            localList.add(localObject3);
            i4 += 1;
            continue;
            localanst.b(4);
            i1 = 0;
          }
        }
        i2 += 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (i3 != 0))
      {
        a(jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (i3 != 0));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((anst)this.jdField_a_of_type_JavaUtilList.get(i1)).a();
        i1 += 1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      amsx localamsx = (amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if (localamsx != null)
      {
        localamsx.b(this.jdField_a_of_type_Anpy);
        localamsx.c();
        if (this.jdField_a_of_type_Amtq != null) {
          this.jdField_a_of_type_Amtq.a();
        }
      }
    }
    n();
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    u();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter = null;
    this.jdField_a_of_type_Anrh = null;
    this.jdField_a_of_type_Anpy = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_Ansf != null) {
      this.jdField_a_of_type_Ansf.c();
    }
    this.jdField_a_of_type_Blrr = null;
    this.jdField_a_of_type_JavaUtilDeque = null;
    B();
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
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content)) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.life_Time <= 0) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts));
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 49, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.life_Time, null);
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
      paramMessage.show_sum += 1;
      ((amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      return false;
    } while (this.jdField_a_of_type_Ansf == null);
    ansf.a(this.jdField_a_of_type_Ansf);
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
      if (this.jdField_a_of_type_Ansr != null)
      {
        List localList = this.jdField_a_of_type_Ansr.a();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {}
    }
    else
    {
      return;
    }
    localMqqHandler.post(new ApolloPanel.10(this));
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ApolloPanel", 1, "[initData] mBaseChatPie or mBaseChatPie.app is null");
      return;
    }
    amsx localamsx = (amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    localamsx.a(this.jdField_a_of_type_Anpy);
    if (this.jdField_a_of_type_Amtq != null) {
      this.jdField_a_of_type_Amtq.a(this.jdField_a_of_type_Amtr);
    }
    int i2 = localamsx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1036)
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localObject = (annx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1036) {
        break label137;
      }
      localObject = ((aihy)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).b();
      this.jdField_a_of_type_Anqo = new anqo(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      this.jdField_a_of_type_Anqo.a((List)localObject);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label145;
      }
      this.jdField_a_of_type_Anqo.b(100);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new ApolloPanel.11(this));
      return;
      label137:
      localObject = ((annx)localObject).j();
      break;
      label145:
      this.jdField_a_of_type_Anqo.b(8);
    }
  }
  
  public void m()
  {
    Object localObject1;
    List localList;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localObject1 = (annx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aihy)) {
        break label114;
      }
      localList = ((aihy)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).b();
      if ((localList != null) && (localList.size() > 0))
      {
        localObject1 = null;
        localObject2 = null;
        if (this.jdField_a_of_type_Anqo == null) {
          break label123;
        }
        localObject2 = this.jdField_a_of_type_Anqo;
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
          ThreadManager.getUIHandler().post(new ApolloPanel.12(this, (anqo)localObject2, localList));
        }
        return;
        localList = ((annx)localObject1).j();
        break;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      i2 = this.jdField_a_of_type_JavaUtilList.size();
      i1 = 0;
      localObject2 = localObject1;
    } while (i1 >= i2);
    Object localObject2 = (anst)this.jdField_a_of_type_JavaUtilList.get(i1);
    if ((localObject2 != null) && (((anst)localObject2).jdField_c_of_type_Int == 100) && ((localObject2 instanceof anqo))) {
      localObject1 = (anqo)localObject2;
    }
    for (;;)
    {
      i1 += 1;
      break;
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Bhpc != null)
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      this.jdField_a_of_type_Bhpc = null;
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
        anst localanst = (anst)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((localanst.jdField_c_of_type_Int == 100) && ((localanst instanceof anqo))) {
          ((anqo)localanst).b();
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        Object localObject = (amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem != null))
        {
          ((amsx)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, "aio_shop");
          ((amsx)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
          ((bbav)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(String.valueOf("103100.103200.103250"));
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
          this.jdField_f_of_type_Boolean = false;
          w();
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_new_click", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id });
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_click", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), 0, new String[0]);
        }
        else
        {
          if (amsx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
          for (localObject = annv.ah;; localObject = annv.ai)
          {
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", (String)localObject, null);
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
          {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clickslavenumber", 0, 0, new String[0]);
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", annv.ai, null, 14003);
            continue;
            u();
            continue;
            q();
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
      if ((i2 != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null)) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "cmshow", "Apollo", "game_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int), 0, new String[] { Integer.toString(i2) });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
        return;
      }
      int i3 = 0;
      i2 = i3;
      if (this.jdField_a_of_type_Ansr != null)
      {
        localObject1 = this.jdField_a_of_type_Ansr.a();
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
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i3 = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
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
        anst localanst = (anst)((Iterator)localObject3).next();
        i1 = i2;
        if (localanst == null) {
          break label689;
        }
        i1 = i2;
        if (!(localanst instanceof anst)) {
          break label689;
        }
        i3 = localanst.a();
        i2 += i3;
        i1 = i2;
        if (paramInt + 1 > i2) {
          break label689;
        }
        if (!(localanst instanceof anrh))
        {
          localObject1 = localObject2;
          if (!(localanst instanceof anqf)) {}
        }
        else
        {
          localObject1 = localanst.a(i3 - (i2 - paramInt));
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
      localObject3 = (anra)((ArrayList)localObject1).get(paramInt);
      if (((anra)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) {
        break label694;
      }
      ((StringBuilder)localObject2).append(((anra)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
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
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "actionexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { ((StringBuilder)localObject2).toString(), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramInt == 0) && (this.jdField_f_of_type_Int == 2) && (this.jdField_l_of_type_Int != -1) && (this.jdField_l_of_type_Int != paramInt)) {
      this.jdField_c_of_type_Ansk.a();
    }
    this.jdField_l_of_type_Int = paramInt;
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.a() == 0)) {
      z();
    }
    x();
  }
  
  public void p()
  {
    MqqHandler localMqqHandler;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localMqqHandler != null) {}
    }
    else
    {
      return;
    }
    localMqqHandler.post(new ApolloPanel.22(this));
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      QLog.e("ApolloPanel", 1, "[showGuidePageFor3D] mBaseChatPie or mBaseChatPie.app is null");
    }
    do
    {
      do
      {
        return;
        if ((!amtk.jdField_a_of_type_Boolean) || (this.jdField_f_of_type_Int == 2) || (!b()))
        {
          z();
          return;
        }
        y();
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setGuideType(0);
        localObject2 = (annx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      } while (localObject2 == null);
      Object localObject1 = new ArrayList();
      Object localObject2 = ((annx)localObject2).d(400);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        int i1 = 0;
        while (i1 < ((List)localObject2).size())
        {
          anqb localanqb = new anqb(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          localanqb.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject2).get(i1));
          ((List)localObject1).add(localanqb);
          i1 += 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setActions((List)localObject1);
      localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      ((TranslateAnimation)localObject1).setDuration(500L);
      ((TranslateAnimation)localObject1).setRepeatCount(0);
      ((TranslateAnimation)localObject1).setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.startAnimation((Animation)localObject1);
    } while (this.n);
    this.n = true;
    ((amsx)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).m();
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).d(4);
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
        u();
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt);
      i1 = this.jdField_k_of_type_Int;
      this.jdField_k_of_type_Int = paramInt;
      if (localObject == null) {
        break label416;
      }
      ((View)localObject).setSelected(true);
      this.jdField_a_of_type_Ansr.a(paramInt);
      if ((!this.m) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView == null) && (!this.jdField_a_of_type_Amtl.a()) && (!this.jdField_a_of_type_Amtl.b())) {
        a(paramInt, (View)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_Ansr != null) && (this.jdField_a_of_type_Ansr.a() != null) && (this.jdField_a_of_type_Ansr.a().size() > paramInt) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        localObject = (ApolloActionPackage)this.jdField_a_of_type_Ansr.a().get(paramInt);
        if ((((ApolloActionPackage)localObject).packageId == 100) && (i1 != paramInt)) {
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1);
        }
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        int i2 = ((ApolloActionPackage)localObject).packageId;
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (!((ApolloActionPackage)localObject).isUpdate) {
          break label411;
        }
        i1 = 1;
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_tab", str, i2, 0, new String[] { i1, "" + ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), "", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
    for (;;)
    {
      d(paramInt);
      return;
      label411:
      i1 = 0;
      break;
      label416:
      this.jdField_a_of_type_Ansr.a(paramInt);
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
    u();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 1, "[setVisibility] gone, set mShouldShowActionFloatView true");
    }
    this.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_Long != 0L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "panel_stay_time", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "", "", "", String.valueOf(l1 - l2) });
      }
      this.jdField_a_of_type_Long = 0L;
    }
    jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel
 * JD-Core Version:    0.7.0.1
 */
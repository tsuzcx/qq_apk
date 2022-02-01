package com.tencent.mobileqq.apollo.view;

import afur;
import ahyk;
import amgz;
import amhd;
import amhp;
import amhq;
import amhr;
import amhw;
import amhx;
import amlv;
import amul;
import amuo;
import ancb;
import ancd;
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
import aned;
import anee;
import aneg;
import anek;
import anet;
import anff;
import anfh;
import anfl;
import anfm;
import anfn;
import anfo;
import anfp;
import anfq;
import anfr;
import anfs;
import anft;
import anfu;
import anfv;
import anfw;
import anfx;
import anfy;
import anfz;
import anga;
import angb;
import angc;
import angd;
import ange;
import angf;
import angg;
import angj;
import angk;
import ango;
import angp;
import angq;
import angw;
import angx;
import angy;
import anni;
import atwl;
import baif;
import bgln;
import bglp;
import bgpa;
import bgso;
import bgyd;
import bkfv;
import bkqo;
import bkqp;
import bkqq;
import bltn;
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
  implements Handler.Callback, ViewPager.OnPageChangeListener, View.OnClickListener, AdapterView.OnItemClickListener, anee
{
  public static int a;
  private static final String jdField_a_of_type_JavaLangString = ancb.jdField_a_of_type_JavaLangString + "/cmshow.apk";
  public static boolean a;
  public static int b;
  private static final String jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + ".temp";
  private long jdField_a_of_type_Long;
  private amhp jdField_a_of_type_Amhp = new angf(this);
  private amhr jdField_a_of_type_Amhr;
  private amhw jdField_a_of_type_Amhw;
  public amhx a;
  public DialogInterface.OnClickListener a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  aned jdField_a_of_type_Aned = new anfn(this);
  anet jdField_a_of_type_Anet;
  public anfm a;
  public angk a;
  private angp jdField_a_of_type_Angp = new angd(this);
  private angq jdField_a_of_type_Angq = new angg(this);
  angw jdField_a_of_type_Angw;
  bgpa jdField_a_of_type_Bgpa = null;
  public bkqo a;
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
  private Deque<ango> jdField_a_of_type_JavaUtilDeque;
  public List<angy> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bkfv(Looper.getMainLooper(), this, true);
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public LinearLayout b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  private angp jdField_b_of_type_Angp = new ange(this);
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private volatile boolean jdField_b_of_type_Boolean;
  public int c;
  public RelativeLayout c;
  private angp jdField_c_of_type_Angp = this.jdField_a_of_type_Angp;
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
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new anfs(this);
    this.jdField_a_of_type_Amhx = new anft(this);
    this.jdField_f_of_type_Int = 1;
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new anfs(this);
    this.jdField_a_of_type_Amhx = new anft(this);
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
  
  private int a(List<angy> paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt >= paramList.size())) {
      throw new IllegalArgumentException("packageBinderList is null or tabIndex is out");
    }
    int i2 = 0;
    int i1 = 0;
    if (i2 < paramInt)
    {
      angy localangy = (angy)paramList.get(i2);
      if (localangy == null) {
        break label73;
      }
      i1 = localangy.a() + i1;
    }
    label73:
    for (;;)
    {
      i2 += 1;
      break;
      return i1;
    }
  }
  
  private amlv a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return null;
    }
    amgz localamgz = (amgz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211);
    amlv localamlv = localamgz.a();
    if (localamlv.jdField_a_of_type_Int != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[checkJumpToGameTab] checkGameTab jumpGameId:", Integer.valueOf(localamlv.jdField_a_of_type_Int), ",from:", Integer.valueOf(localamlv.jdField_b_of_type_Int), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      }
      if (!this.jdField_b_of_type_Boolean) {
        localamgz.a(-1, -1);
      }
      return localamlv;
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
          localObject1 = localResources.getDrawable(2130838001);
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
            localDrawable = localResources.getDrawable(2130843701);
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
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = afur.a(90.0F, localResources);
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
        if (this.jdField_a_of_type_Bkqo != null)
        {
          if (this.jdField_a_of_type_JavaUtilDeque == null) {
            this.jdField_a_of_type_JavaUtilDeque = new LinkedList();
          }
          this.jdField_a_of_type_JavaUtilDeque.addLast(new ango(paramView, paramInt1, paramString, paramInt2, paramOnClickListener));
          return;
        }
        paramString = bkqo.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).b(paramInt2).a(paramString).a(16.0F).a(-1);
        paramString.c(paramInt1);
        paramString = new bkqq(paramString).b(Color.argb(255, 0, 0, 0)).a(5).a();
      } while (paramString == null);
      this.jdField_a_of_type_Bkqo = paramString.a();
    } while (this.jdField_a_of_type_Bkqo == null);
    this.jdField_a_of_type_Bkqo.a(82);
    this.jdField_a_of_type_Bkqo.c(2);
    this.jdField_a_of_type_Bkqo.a(paramView);
    this.jdField_a_of_type_Bkqo.a(paramOnClickListener);
    this.jdField_a_of_type_Bkqo.setOnDismissListener(new angj(this));
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
        amhd.a(101, String.valueOf(i1), (String)localObject2, str);
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
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(super.getContext()).inflate(2131558668, null));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setId(2131362769);
      ((ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368410)).setOnClickListener(this);
      localObject4 = super.getResources();
      localObject3 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368398);
      localObject2 = new anfl(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      ((anfl)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramApolloActionData;
      ((ImageView)localObject3).setImageDrawable(a(paramApolloActionData));
      ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380046)).setText(paramApolloActionData.actionName);
      ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380045)).setText(paramApolloActionData.description);
      ((Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363862)).setOnClickListener(new anfv(this, paramApolloActionData, paramInt3, localObject1, str));
      localObject3 = (Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363689);
      i1 = super.getHeight() - this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight();
      if (i1 < afur.a(213.0F, (Resources)localObject4))
      {
        localObject5 = (LinearLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131364976);
        i1 = i1 - (int)((Resources)localObject4).getDimension(2131296448) - (int)((Resources)localObject4).getDimension(2131296449);
        ((RelativeLayout.LayoutParams)((LinearLayout)localObject5).getLayoutParams()).bottomMargin = ((int)(i1 * 0.1D));
        ((RelativeLayout.LayoutParams)((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131364971)).getLayoutParams()).bottomMargin = ((int)(i1 * 0.2D));
      }
      localObject4 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368156);
      localObject5 = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380069);
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
      paramBundle.addRule(2, 2131362783);
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
      ((TextView)localObject5).setText(anni.a(2131699285));
      break label736;
      ((ImageView)localObject4).setVisibility(8);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(anni.a(2131699275));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838546);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FFFF8444"));
      ((TextView)localObject5).setText(paramApolloActionData.extraWording);
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838547);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(anni.a(2131699277));
      localObject4 = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380057);
      ((TextView)localObject4).setVisibility(0);
      ((TextView)localObject4).setText(String.valueOf(paramApolloActionData.currencyNum));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838548);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(anni.a(2131699286));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838569);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(super.getResources().getString(2131690014));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838569);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setText(super.getResources().getString(2131690014));
      break label736;
      ((ImageView)localObject4).setVisibility(0);
      ((ImageView)localObject4).setImageResource(2130838567);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject5).setMaxLines(2);
      ((TextView)localObject5).setText(super.getResources().getString(2131690036));
      break label736;
      ((Button)localObject3).setText(anni.a(2131699280));
      ((Button)localObject3).setOnClickListener(new anfw(this, localThrowable, paramApolloActionData, paramInt3, localObject1, str));
      continue;
      ((Button)localObject3).setText(anni.a(2131699290));
      ((Button)localObject3).setOnClickListener(new anfx(this, paramBundle, paramApolloActionData, paramInt3, localObject1, str));
      continue;
      ((Button)localObject3).setText(anni.a(2131699279));
      ((Button)localObject3).setOnClickListener(new anfy(this, paramApolloActionData, paramBundle, paramInt3, localObject1, str));
      continue;
      ((Button)localObject3).setText(super.getResources().getString(2131690012));
      ((Button)localObject3).setOnClickListener(new anfz(this, paramApolloActionData, paramInt3, localObject1, str));
      continue;
      ((Button)localObject3).setText(super.getResources().getString(2131690037));
      ((Button)localObject3).setOnClickListener(new anga(this, paramApolloActionData, paramInt3, localObject1, str));
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.35(this, paramAppInfo, paramString));
  }
  
  private void a(List<angy> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramList == null) || (paramList1 == null)) {
      return;
    }
    this.jdField_c_of_type_Angp.a(paramList, paramList1, paramBoolean);
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
      return amhd.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    this.jdField_a_of_type_Anfm = new anfm(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Anfm.b(paramInt2);
    this.jdField_a_of_type_Anfm.a(this);
    if (paramInt1 == 0) {
      this.jdField_a_of_type_Anfm.a(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func showApolloPanel begins. Thread id = " + Thread.currentThread().getId());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Anfm);
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
      Object localObject = (ancd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      localApolloActionData = ((ancd)localObject).a(paramInt1);
      if (localApolloActionData == null)
      {
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] no action info, abort");
        return;
      }
      boolean bool2 = ((ancd)localObject).b(paramInt1);
      if ((((ancd)localObject).c(paramInt1)) || (localApolloActionData.feeType == 1)) {}
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
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(new anfu(this, localApolloActionData, paramInt2));
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
        if (((amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
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
        if ((amhq.jdField_a_of_type_Boolean) && (b()) && (!TextUtils.isEmpty(amhq.jdField_b_of_type_JavaLangString)))
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
    this.jdField_c_of_type_Angp.a(paramInt);
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
      this.jdField_c_of_type_Angp = this.jdField_b_of_type_Angp;
      return;
    }
    this.jdField_c_of_type_Angp = this.jdField_a_of_type_Angp;
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
    View localView = super.findViewById(2131362769);
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
      if (!this.jdField_a_of_type_Amhr.b()) {
        break label44;
      }
      QLog.d("ApolloPanel", 2, "showGuidePageFor3D for json");
      this.m = true;
      this.jdField_a_of_type_Amhr.b(false);
      q();
    }
    label44:
    while (!this.jdField_a_of_type_Amhr.a()) {
      return;
    }
    QLog.d("ApolloPanel", 2, "showGuidePageFor3D for action");
    this.m = true;
    this.jdField_a_of_type_Amhr.a(false);
    q();
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[checkInitGuidePage]");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView = ((ApolloPanelGuideView)LayoutInflater.from(super.getContext()).inflate(2131558666, null));
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setClickCallback(this.jdField_a_of_type_Angq);
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
        i2 += ((angy)this.jdField_a_of_type_JavaUtilList.get(i1)).a();
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
  
  public int a(BaseChatPie paramBaseChatPie, anff paramanff, ApolloActionData paramApolloActionData)
  {
    int i2;
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      i2 = 0;
      return i2;
    }
    ancd localancd = (ancd)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    paramBaseChatPie = (amhd)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    boolean bool = localancd.b(paramApolloActionData.actionId);
    int i1;
    if ((paramApolloActionData.hasSound) || (paramanff.jdField_e_of_type_Int > 0)) {
      i1 = 1;
    }
    for (;;)
    {
      if (localancd.c(paramApolloActionData.actionId))
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
  
  public angy a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "getViewBinder type=" + paramInt);
    }
    return this.jdField_c_of_type_Angp.a(paramInt);
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
        angy localangy = (angy)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((localangy.jdField_c_of_type_Int == 100) && ((localangy instanceof anet)) && (((anet)localangy).a != null) && (((anet)localangy).a.gameId == paramInt2)) {
          ((anet)localangy).a(paramInt1);
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
      if ((paramApolloPanel != null) && ((paramApolloPanel instanceof anet)))
      {
        paramApolloPanel = (anet)paramApolloPanel;
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
      paramApolloPanel = amuo.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    if ((this.jdField_a_of_type_Angw != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = this.jdField_a_of_type_Angw.a();
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
          ((angx)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
        if ((((ApolloActionPackage)localObject).isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= ((ApolloActionPackage)localObject).redStartTime))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "clear tab red packageId=" + ((ApolloActionPackage)localObject).packageId + " tabIndex = " + paramInt);
          }
          ((angx)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
  
  public void a(anff paramanff)
  {
    int i3 = 0;
    if ((paramanff == null) || (paramanff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null)) {}
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
        Object localObject1 = (angy)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (((angy)localObject1).jdField_a_of_type_JavaUtilList == null) {}
        while (((angy)localObject1).jdField_c_of_type_Int != 2)
        {
          i1 += 1;
          break;
        }
        Object localObject2;
        if (((angy)localObject1).jdField_b_of_type_Int != 5)
        {
          ((angy)localObject1).b(5);
          localObject2 = new anff();
          ((anff)localObject2).jdField_b_of_type_Int = 2;
          ApolloActionData localApolloActionData = new ApolloActionData();
          localApolloActionData.actionName = super.getResources().getString(2131690004);
          ((anff)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
          ((angy)localObject1).jdField_a_of_type_JavaUtilList.add(0, localObject2);
        }
        localObject1 = ((angy)localObject1).jdField_a_of_type_JavaUtilList;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          localObject2 = (ancd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          paramanff.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramanff, paramanff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
        }
        ((List)localObject1).add(1, paramanff);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "add action to fav action " + paramanff.toString());
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
    paramBaseChatPie = (amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (paramBaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[initPanel] apollo status open, remember jump info");
      }
      this.jdField_h_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = paramInt2;
    }
    this.jdField_i_of_type_Int = paramInt3;
    paramBaseChatPie.a(this.jdField_a_of_type_Amhp);
    this.jdField_a_of_type_Amhr = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131363121));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363830));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364973));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364972));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363805));
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363698));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_c_of_type_ComTencentImageURLImageView.getParent());
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131363799));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362735));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)super.findViewById(2131362782));
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    Drawable localDrawable = super.getContext().getResources().getDrawable(2130838590);
    paramSessionInfo.addState(new int[] { 16842919 }, localDrawable);
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    localDrawable = super.getContext().getResources().getDrawable(2130838589);
    paramSessionInfo.addState(new int[] { -16842919 }, localDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131362783));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter = new ApolloPanelAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131378183));
    this.jdField_a_of_type_Angw = new angw(super.getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Angw);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    super.findViewById(2131378179).setBackgroundColor(super.getContext().getResources().getColor(2131165621));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131370230));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362777));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362776));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362775));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362726));
    this.jdField_a_of_type_Amhw = paramBaseChatPie.a();
    if (this.jdField_a_of_type_Amhw != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_Amhw.a.get()));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(super.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout).a(5).a();
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = ((baif)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf("103100.103200.103250"));
      paramBaseChatPie = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (paramBaseChatPie != null) {
        paramBaseChatPie.a(100);
      }
      bltn.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramBaseChatPie = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if ((paramBaseChatPie.getBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)) && (this.jdField_i_of_type_Int != 7))
      {
        paramBaseChatPie.edit().putBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
        paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.obtainMessage(51).sendToTarget();
        }
      }
      if (amhd.jdField_a_of_type_Boolean)
      {
        QLog.d("ApolloPanel", 1, "[initPanel] getUserApolloInfo");
        this.jdField_b_of_type_Boolean = true;
        ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 1082392704, "Open Panel");
        amhd.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_Amhw != null) {
        this.jdField_a_of_type_Amhw.a(null);
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
        anfh localanfh;
        anff localanff;
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
          localanfh = (anfh)localLinearLayout.getChildAt(i3).getTag();
          if (localanfh != null)
          {
            localanff = localanfh.a;
            if ((localanff != null) && (localanff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localanff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramApolloActionData.actionId))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).post(new ApolloPanel.20(this, localanfh));
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
      } while (this.jdField_a_of_type_Bgpa != null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "showAidDialog title=" + paramString2 + " content=" + paramString3 + "rightString=" + paramString4 + " url=" + paramString5);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
    n();
    int i1;
    if ("onlyRightType".equals(paramString5))
    {
      i1 = 1;
      paramString1 = new anfo(this);
      label136:
      paramString6 = super.getResources().getString(2131694420);
      if (i1 == 0) {
        break label399;
      }
    }
    label399:
    for (paramString5 = null;; paramString5 = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener)
    {
      this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, paramString2, paramString3, paramString6, paramString4, paramString1, paramString5);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
        break;
      }
      this.jdField_a_of_type_Bgpa.show();
      return;
      if ("moreInfo".equals(paramString5))
      {
        paramString1 = new anfp(this, paramString7);
        i1 = 0;
        break label136;
      }
      if ("requestSSO".equals(paramString5))
      {
        paramString1 = new anfq(this, paramString1, paramString7, paramString8);
        i1 = 0;
        break label136;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(String.valueOf(9))))
      {
        ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString7, paramString9);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_view", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + paramString7, "0" });
        return;
      }
      paramString1 = new anfr(this, paramString5, paramString6, paramString7, paramString1, paramString9);
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
    ancd localancd;
    List localList;
    do
    {
      do
      {
        return;
        new ArrayList();
        localArrayList1 = new ArrayList();
        localancd = (ancd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      } while (localancd == null);
      localList = localancd.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
    label550:
    label1477:
    label2502:
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
          break label2509;
        }
        if (localApolloActionPackage.packageId != 4) {}
      }
      label588:
      label2509:
      for (;;)
      {
        i5 += 1;
        break label208;
        if (this.jdField_c_of_type_Angp.a(localApolloActionPackage.packageId))
        {
          String str = bgln.c();
          if ((!TextUtils.isEmpty(localApolloActionPackage.startVersion)) && (!TextUtils.isEmpty(localApolloActionPackage.endVersion)) && ((!bgyd.a(localApolloActionPackage.startVersion, str)) || (!bgyd.a(str, localApolloActionPackage.endVersion))))
          {
            QLog.w("ApolloPanel", 1, "version not correct packageId=" + localApolloActionPackage.packageId);
          }
          else
          {
            long l2 = System.currentTimeMillis();
            angy localangy = a(localApolloActionPackage.type);
            if (localangy != null)
            {
              localangy.jdField_d_of_type_Int = localApolloActionPackage.packageId;
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
                localObject1 = localancd.a();
                localObject2 = (List)((Pair)localObject1).first;
                localObject3 = (List)((Pair)localObject1).second;
                if ((localObject2 != null) && (((List)localObject2).size() > 0))
                {
                  localangy.b(5);
                  localObject4 = new anff();
                  ((anff)localObject4).jdField_b_of_type_Int = 2;
                  localObject1 = new ApolloActionData();
                  ((ApolloActionData)localObject1).actionName = super.getResources().getString(2131690004);
                  ((anff)localObject4).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)localObject1);
                  localArrayList3.add(localObject4);
                  localObject1 = null;
                  i3 = i1;
                  l1 = System.currentTimeMillis();
                  localObject4 = new StringBuilder();
                  if (localObject3 == null) {
                    break label2502;
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
                i2 += 1;
                break label550;
                localangy.b(4);
                break;
                if (localApolloActionPackage.type == 100)
                {
                  localObject1 = localancd.j();
                  if ((localObject1 != null) && (((List)localObject1).size() > 0))
                  {
                    i3 = i1;
                    if ((localangy instanceof anet))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloPanel", 2, new Object[] { "set panel game list, size=", Integer.valueOf(((List)localObject1).size()) });
                      }
                      ((anet)localangy).a((List)localObject1);
                      localangy.b(100);
                      i3 = i1 + localangy.a();
                      localArrayList2.add(localangy);
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
                  localObject2 = localancd.b();
                  localObject1 = (List)((Pair)localObject2).first;
                  localObject3 = (List)((Pair)localObject2).second;
                  localangy.b(0);
                  localObject2 = null;
                  i3 = i1;
                  break label525;
                }
                localObject3 = localancd.d(localApolloActionPackage.packageId);
                localObject1 = localancd.e(localApolloActionPackage.packageId);
                localangy.b(0);
                if (localApolloActionPackage.packageId == 6)
                {
                  localangy.b(9);
                  localancd.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (List)localObject3);
                  localObject2 = null;
                  i3 = i1;
                  break label525;
                }
                if (localApolloActionPackage.packageId == 7) {
                  localancd.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (List)localObject3);
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
              anff localanff = localangy.a(paramString);
              localanff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
              localanff.jdField_a_of_type_Int = localApolloActionPackage.packageId;
              if (localApolloActionPackage.type == 2) {
                if ((localObject2 != null) && (((List)localObject2).size() > i2))
                {
                  localanff.jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject2).get(i2)).text;
                  localanff.jdField_d_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(i2)).textType;
                  localanff.jdField_e_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(i2)).audioId;
                  localanff.jdField_a_of_type_Float = ((ApolloFavActionData)((List)localObject2).get(i2)).audioStartTime;
                  localanff.jdField_f_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(i2)).playOriginalAudio;
                }
              }
              for (localanff.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localanff, localanff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);; localanff.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localanff, localanff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData))
              {
                localArrayList3.add(localanff);
                if ((i1 != -1) || (this.jdField_g_of_type_Int != localApolloActionData.actionId)) {
                  break label2499;
                }
                if (this.jdField_h_of_type_Int == -1)
                {
                  this.jdField_h_of_type_Int = localApolloActionPackage.packageId;
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] jump action match but no jump pkg, use ", Integer.valueOf(this.jdField_h_of_type_Int) });
                  }
                }
                if (this.jdField_h_of_type_Int != localApolloActionPackage.packageId) {
                  break label2499;
                }
                i1 = localArrayList3.size() - 1;
                break;
                if ((localObject1 != null) && (((List)localObject1).size() > i2))
                {
                  localanff.jdField_b_of_type_JavaLangString = ((ApolloActionPackageData)((List)localObject1).get(i2)).text;
                  localanff.jdField_d_of_type_Int = ((ApolloActionPackageData)((List)localObject1).get(i2)).textType;
                }
              }
              if (0 != 0) {
                throw new NullPointerException();
              }
              int i4 = i3;
              i2 = i1;
              if (localArrayList3.size() > 0)
              {
                localangy.c_(localArrayList3);
                if (this.jdField_h_of_type_Int == localApolloActionPackage.packageId)
                {
                  if (i1 == -1) {
                    break label1830;
                  }
                  localangy.c(i1);
                  jdField_a_of_type_Int = localangy.a(i1) + i3;
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] init sCurrentIndex with jump info, sCurrentIndex=", Integer.valueOf(jdField_a_of_type_Int), ", jumpActionIndex=", Integer.valueOf(i1) });
                  }
                }
                localArrayList2.add(localangy);
                if ((localApolloActionPackage.packageId == 8) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
                {
                  localApolloActionPackage.isRecommendTabClick = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getBoolean("apollo_sp_key_recommend_tab_click", false);
                  QLog.d("ApolloPanel", 1, new Object[] { "[initPanelData] isRecommendTabClick=", Boolean.valueOf(localApolloActionPackage.isRecommendTabClick) });
                }
                localArrayList1.add(localApolloActionPackage);
                i4 = i3 + localangy.a();
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
                    ((amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(1);
                  }
                }
                while ((localArrayList2 != null) && (localArrayList2.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
                {
                  paramString = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
                  l2 = NetConnInfoCenter.getServerTime();
                  l1 = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  localObject1 = new ArrayList();
                  localObject3 = localArrayList1.iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject2 = (ApolloActionPackage)((Iterator)localObject3).next();
                    if ((((ApolloActionPackage)localObject2).isUpdate) && (((ApolloActionPackage)localObject2).packageId != 100))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloPanel", 2, "[initPanelData] delete red dot after 24h:" + ((List)localObject1).size());
                      }
                      if (NetConnInfoCenter.getServerTimeMillis() - paramString.getLong("action_red_tab_update_" + ((ApolloActionPackage)localObject2).packageId, 0L) > ((ApolloActionPackage)localObject2).redInterval)
                      {
                        ((ApolloActionPackage)localObject2).isUpdate = false;
                        ((List)localObject1).add(localObject2);
                      }
                    }
                    if ((((ApolloActionPackage)localObject2).isUpdate) && (((ApolloActionPackage)localObject2).packageId == 100) && (l2 - l1 > 604800000L))
                    {
                      ((ApolloActionPackage)localObject2).isUpdate = false;
                      ((List)localObject1).add(localObject2);
                    }
                  }
                  if (!this.jdField_b_of_type_Boolean)
                  {
                    this.jdField_h_of_type_Int = -1;
                    this.jdField_g_of_type_Int = -1;
                  }
                }
                break;
                if (!((List)localObject1).isEmpty())
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, "[initPanelData] delete red dot after 24h:" + ((List)localObject1).size());
                  }
                  ThreadManager.post(new ApolloPanel.4(this, (List)localObject1), 5, null, true);
                }
                a(localArrayList1);
                b(localArrayList2);
                this.jdField_c_of_type_Angp.a();
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
              if (this.jdField_a_of_type_Anfm != null) {
                this.jdField_a_of_type_Anfm.c();
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
      ((amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(false, "panel open apollo", 1);
    } while (this.jdField_a_of_type_Anfm == null);
    this.jdField_a_of_type_Anfm.b(0);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, false);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Angw != null)
    {
      Object localObject = this.jdField_a_of_type_Angw.a();
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
    if ((this.jdField_a_of_type_JavaUtilList.size() > jdField_a_of_type_Int) && ((this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int) instanceof anet)))
    {
      ApolloGameData localApolloGameData = ((anet)this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int)).b();
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
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, "aio", ancb.ah, null);
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
        if (!atwl.a(ApolloUtil.jdField_a_of_type_JavaLangString))
        {
          c(paramInt, 3);
          ((amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_Aned);
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
    amhd localamhd = (amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (localamhd.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 1)
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
    if ((localObject != null) && (((amlv)localObject).jdField_a_of_type_Int > 0) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      i1 = 0;
      label178:
      if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label1244;
      }
      if (!(this.jdField_a_of_type_JavaUtilList.get(i1) instanceof anet)) {}
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
        QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] checkGameTab jumpGameId:" + ((amlv)localObject).jdField_a_of_type_Int + ",gameTabIndex:" + i1);
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
      anff localanff;
      if ((i7 < i8) && (i1 == -1))
      {
        localObject = (angy)this.jdField_a_of_type_JavaUtilList.get(i7);
        if (localObject == null) {
          break label1237;
        }
        if ((paramInt1 != -1) && (((angy)localObject).jdField_d_of_type_Int == paramInt1))
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
            localamhd.a(1);
            return;
          }
          i2 = i4;
          i5 = i1;
          if (!(localObject instanceof anet))
          {
            localList = ((angy)localObject).jdField_a_of_type_JavaUtilList;
            if ((localList == null) || (localList.size() <= 0)) {
              break label952;
            }
            i2 = 0;
            i5 = localList.size();
            if (i2 >= i5) {
              break label1228;
            }
            localanff = (anff)localList.get(i2);
            if ((localanff != null) && (localanff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localanff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramInt2))
            {
              ((angy)localObject).c(i2);
              i1 = ((angy)localObject).a(i2) + i3;
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
            i3 = ((angy)localObject).a() + i3;
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
        if ((localObject instanceof anet)) {
          break label909;
        }
        localList = ((angy)localObject).jdField_a_of_type_JavaUtilList;
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
            localanff = (anff)localList.get(i6);
            if ((localanff != null) && (localanff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localanff.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramInt2))
            {
              if (paramInt1 != -1)
              {
                i2 = i4;
                i5 = i1;
                if (paramInt1 != ((angy)localObject).jdField_d_of_type_Int) {
                  break;
                }
              }
              ((angy)localObject).c(i6);
              i5 = i3 + ((angy)localObject).a(i6);
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
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(super.getContext()).inflate(2131558668, null));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setId(2131362769);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368176).setVisibility(4);
      ((ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368410)).setOnClickListener(this);
      Object localObject2 = super.getResources();
      Object localObject1 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368398);
      new anfl(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramApolloActionData;
      ((ImageView)localObject1).setImageDrawable(a(paramApolloActionData));
      ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380046)).setText(paramApolloActionData.actionName);
      ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380045)).setText(paramApolloActionData.description);
      ((Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363862)).setOnClickListener(new angb(this, paramApolloActionData));
      localObject1 = (Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363689);
      int i1 = super.getHeight() - this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight();
      if (i1 < afur.a(213.0F, (Resources)localObject2))
      {
        localObject3 = (LinearLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131364976);
        i1 = i1 - (int)((Resources)localObject2).getDimension(2131296448) - (int)((Resources)localObject2).getDimension(2131296449);
        ((RelativeLayout.LayoutParams)((LinearLayout)localObject3).getLayoutParams()).bottomMargin = ((int)(i1 * 0.1D));
        ((RelativeLayout.LayoutParams)((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131364971)).getLayoutParams()).bottomMargin = ((int)(i1 * 0.2D));
      }
      localObject2 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368156);
      Object localObject3 = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131380069);
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838567);
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setMaxLines(2);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(super.getResources().getString(2131690036));
      ((Button)localObject1).setText(super.getResources().getString(2131690037));
      ((Button)localObject1).setOnClickListener(new angc(this, paramApolloActionData));
      localObject1 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131362783);
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
  
  public void b(List<angy> paramList)
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
      amhd localamhd = (amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if (localamhd != null)
      {
        localamhd.a(this.jdField_a_of_type_Aned);
        int i1 = 0;
        if (!atwl.a(ApolloUtil.jdField_a_of_type_JavaLangString)) {
          i1 = 1;
        }
        localamhd.a(i1);
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
        i2 += ((angy)this.jdField_a_of_type_JavaUtilList.get(i1)).a();
        i1 += 1;
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i2, false);
          a(i2);
          Object localObject = this.jdField_a_of_type_Angw.a();
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
    int i1 = ((amhd)localQQAppInterface.getManager(153)).b(localQQAppInterface.c());
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
    if (this.jdField_a_of_type_Angw == null) {}
    int i1;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_Angw.a();
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
      paramInt = ((ApolloActionPackage)localObject).packageId;
      i1 = ((ApolloActionPackage)localObject).type;
    } while ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject = (amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (i1 == 2) {
      ((amhd)localObject).a(paramInt, true);
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] packageId=", Integer.valueOf(paramInt) });
      return;
      if ((i1 != 100) && (((amhd)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)) {
        ((amhd)localObject).a(paramInt, false);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      bgso.a("apollo_panel_open", null);
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
    if ((paramInt != 0) && (this.jdField_a_of_type_Bkqo != null) && (this.jdField_a_of_type_Bkqo.isShowing())) {
      this.jdField_a_of_type_Bkqo.dismiss();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_Angw != null))
    {
      i1 = a(jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_Angw.a();
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
      localObject1 = (ancd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (localObject1 == null)
      {
        QLog.e("ApolloPanel", 1, "showGuidePageForOpenCmshow adm == null");
        ApolloUtil.b("showGuidePageForOpenCmshow adm == null");
        return;
      }
      jdField_b_of_type_Int = paramInt;
      if (paramInt != 1) {
        break label259;
      }
      localObject1 = ((ancd)localObject1).d(400);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        break;
      }
      QLog.e("ApolloPanel", 1, "[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
      ApolloUtil.b("[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (21 != this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g()));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aJ();
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
          localObject2 = new aneg(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          ((aneg)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject1).get(paramInt));
          localArrayList.add(localObject2);
          paramInt += 1;
          continue;
          label259:
          localObject1 = ((ancd)localObject1).f();
          if ((localObject1 == null) || (((List)localObject1).isEmpty()))
          {
            QLog.e("ApolloPanel", 1, "[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
            ApolloUtil.b("[showGuidePageForOpenCmshow] actions == null || actions.isEmpty()");
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (21 != this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g())) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aJ();
            return;
          }
          if ((localObject1 == null) || (((List)localObject1).size() <= 4)) {
            break label549;
          }
          localObject1 = ((List)localObject1).subList(0, 4);
        }
      }
      label549:
      for (;;)
      {
        paramInt = 0;
        while ((localObject1 != null) && (paramInt < ((List)localObject1).size()))
        {
          localObject2 = new anfl(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          ((anfl)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject1).get(paramInt));
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
          ThreadManagerV2.getUIHandlerV2().post(new ApolloPanel.40(this, localArrayList));
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
        angy localangy = (angy)this.jdField_a_of_type_JavaUtilList.get(i2);
        if (localangy.jdField_c_of_type_Int == 2)
        {
          List localList = localangy.jdField_a_of_type_JavaUtilList;
          if ((localList == null) || (localList.size() == 0))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloPanel", 2, "no fav action yet");
            return;
          }
          Object localObject1 = (ancd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          if (localObject1 == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("ApolloPanel", 2, "apolloDaoManager null");
            return;
          }
          localList.clear();
          Object localObject2 = ((ancd)localObject1).a();
          localObject1 = (List)((Pair)localObject2).first;
          localObject2 = (List)((Pair)localObject2).second;
          Object localObject3 = (ancd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localangy.b(5);
            localObject3 = new anff();
            ((anff)localObject3).jdField_b_of_type_Int = 2;
            ApolloActionData localApolloActionData = new ApolloActionData();
            localApolloActionData.actionName = super.getResources().getString(2131690004);
            ((anff)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
            localList.add(localObject3);
          }
          for (;;)
          {
            i3 = i1;
            if (i4 >= ((List)localObject2).size()) {
              break;
            }
            localObject3 = localangy.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
            ((anff)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject2).get(i4));
            ((anff)localObject3).jdField_a_of_type_Int = localangy.jdField_d_of_type_Int;
            if ((localObject1 != null) && (((List)localObject1).size() > i2))
            {
              ((anff)localObject3).jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject1).get(i4)).text;
              ((anff)localObject3).jdField_d_of_type_Int = ((ApolloFavActionData)((List)localObject1).get(i4)).textType;
              ((anff)localObject3).jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (anff)localObject3, ((anff)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
            }
            localList.add(localObject3);
            i4 += 1;
            continue;
            localangy.b(4);
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
        ((angy)this.jdField_a_of_type_JavaUtilList.get(i1)).a();
        i1 += 1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      amhd localamhd = (amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if (localamhd != null)
      {
        localamhd.b(this.jdField_a_of_type_Aned);
        localamhd.c();
        if (this.jdField_a_of_type_Amhw != null) {
          this.jdField_a_of_type_Amhw.a();
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
    this.jdField_a_of_type_Anfm = null;
    this.jdField_a_of_type_Aned = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_Angk != null) {
      this.jdField_a_of_type_Angk.c();
    }
    this.jdField_a_of_type_Bkqo = null;
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
      ((amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
      return false;
    } while (this.jdField_a_of_type_Angk == null);
    angk.a(this.jdField_a_of_type_Angk);
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
      if (this.jdField_a_of_type_Angw != null)
      {
        List localList = this.jdField_a_of_type_Angw.a();
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
    amhd localamhd = (amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    localamhd.a(this.jdField_a_of_type_Aned);
    if (this.jdField_a_of_type_Amhw != null) {
      this.jdField_a_of_type_Amhw.a(this.jdField_a_of_type_Amhx);
    }
    int i2 = localamhd.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
      localObject = (ancd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1036) {
        break label137;
      }
      localObject = ((ahyk)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).b();
      this.jdField_a_of_type_Anet = new anet(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      this.jdField_a_of_type_Anet.a((List)localObject);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label145;
      }
      this.jdField_a_of_type_Anet.b(100);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new ApolloPanel.11(this));
      return;
      label137:
      localObject = ((ancd)localObject).j();
      break;
      label145:
      this.jdField_a_of_type_Anet.b(8);
    }
  }
  
  public void m()
  {
    Object localObject1;
    List localList;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localObject1 = (ancd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof ahyk)) {
        break label114;
      }
      localList = ((ahyk)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).b();
      if ((localList != null) && (localList.size() > 0))
      {
        localObject1 = null;
        localObject2 = null;
        if (this.jdField_a_of_type_Anet == null) {
          break label123;
        }
        localObject2 = this.jdField_a_of_type_Anet;
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
          ThreadManager.getUIHandler().post(new ApolloPanel.12(this, (anet)localObject2, localList));
        }
        return;
        localList = ((ancd)localObject1).j();
        break;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      i2 = this.jdField_a_of_type_JavaUtilList.size();
      i1 = 0;
      localObject2 = localObject1;
    } while (i1 >= i2);
    Object localObject2 = (angy)this.jdField_a_of_type_JavaUtilList.get(i1);
    if ((localObject2 != null) && (((angy)localObject2).jdField_c_of_type_Int == 100) && ((localObject2 instanceof anet))) {
      localObject1 = (anet)localObject2;
    }
    for (;;)
    {
      i1 += 1;
      break;
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Bgpa != null)
    {
      this.jdField_a_of_type_Bgpa.dismiss();
      this.jdField_a_of_type_Bgpa = null;
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
        angy localangy = (angy)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((localangy.jdField_c_of_type_Int == 100) && ((localangy instanceof anet))) {
          ((anet)localangy).b();
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
        Object localObject = (amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem != null))
        {
          ((amhd)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, "aio_shop");
          ((amhd)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
          ((baif)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(String.valueOf("103100.103200.103250"));
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
          this.jdField_f_of_type_Boolean = false;
          w();
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_new_click", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id });
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_click", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), 0, new String[0]);
        }
        else
        {
          if (amhd.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
          for (localObject = ancb.ah;; localObject = ancb.ai)
          {
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", (String)localObject, null);
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
          {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clickslavenumber", 0, 0, new String[0]);
            ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", ancb.ai, null, 14003);
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
      if (this.jdField_a_of_type_Angw != null)
      {
        localObject1 = this.jdField_a_of_type_Angw.a();
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
        angy localangy = (angy)((Iterator)localObject3).next();
        i1 = i2;
        if (localangy == null) {
          break label689;
        }
        i1 = i2;
        if (!(localangy instanceof angy)) {
          break label689;
        }
        i3 = localangy.a();
        i2 += i3;
        i1 = i2;
        if (paramInt + 1 > i2) {
          break label689;
        }
        if (!(localangy instanceof anfm))
        {
          localObject1 = localObject2;
          if (!(localangy instanceof anek)) {}
        }
        else
        {
          localObject1 = localangy.a(i3 - (i2 - paramInt));
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
      localObject3 = (anff)((ArrayList)localObject1).get(paramInt);
      if (((anff)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) {
        break label694;
      }
      ((StringBuilder)localObject2).append(((anff)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
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
      this.jdField_c_of_type_Angp.a();
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
        if ((!amhq.jdField_a_of_type_Boolean) || (this.jdField_f_of_type_Int == 2) || (!b()))
        {
          z();
          return;
        }
        y();
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setGuideType(0);
        localObject2 = (ancd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      } while (localObject2 == null);
      Object localObject1 = new ArrayList();
      Object localObject2 = ((ancd)localObject2).d(400);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        int i1 = 0;
        while (i1 < ((List)localObject2).size())
        {
          aneg localaneg = new aneg(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          localaneg.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject2).get(i1));
          ((List)localObject1).add(localaneg);
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
    ((amhd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).m();
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
      this.jdField_a_of_type_Angw.a(paramInt);
      if ((!this.m) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView == null) && (!this.jdField_a_of_type_Amhr.a()) && (!this.jdField_a_of_type_Amhr.b())) {
        a(paramInt, (View)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_Angw != null) && (this.jdField_a_of_type_Angw.a() != null) && (this.jdField_a_of_type_Angw.a().size() > paramInt) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        localObject = (ApolloActionPackage)this.jdField_a_of_type_Angw.a().get(paramInt);
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
      this.jdField_a_of_type_Angw.a(paramInt);
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
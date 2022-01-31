package com.tencent.mobileqq.apollo.view;

import actn;
import aena;
import airv;
import airz;
import aisk;
import aisl;
import aism;
import aisr;
import aiss;
import aiwq;
import ajfg;
import ajfj;
import ajmu;
import ajmw;
import ajov;
import ajow;
import ajoy;
import ajpc;
import ajpn;
import ajpz;
import ajqb;
import ajqf;
import ajqg;
import ajqj;
import ajqk;
import ajql;
import ajqm;
import ajqn;
import ajqo;
import ajqp;
import ajqq;
import ajqr;
import ajqs;
import ajqt;
import ajqu;
import ajqv;
import ajqw;
import ajqx;
import ajqy;
import ajqz;
import ajrb;
import ajrc;
import ajrg;
import ajrh;
import ajrn;
import ajro;
import ajrp;
import ajyc;
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
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apvb;
import avpq;
import bbct;
import bbcv;
import bbgg;
import bbjv;
import bbpm;
import bbqp;
import bfmt;
import bfxh;
import bfxi;
import bfxj;
import bgzg;
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
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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

public class ApolloPanel
  extends RelativeLayout
  implements ajow, Handler.Callback, ViewPager.OnPageChangeListener, View.OnClickListener, AdapterView.OnItemClickListener
{
  public static int a;
  private static final String jdField_a_of_type_JavaLangString = ajmu.jdField_a_of_type_JavaLangString + "/cmshow.apk";
  private static final String jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + ".temp";
  private aisk jdField_a_of_type_Aisk = new ajqy(this);
  private aism jdField_a_of_type_Aism;
  private aisr jdField_a_of_type_Aisr;
  public aiss a;
  ajov jdField_a_of_type_Ajov = new ajqj(this);
  ajpn jdField_a_of_type_Ajpn;
  public ajqg a;
  private ajrc jdField_a_of_type_Ajrc;
  private ajrh jdField_a_of_type_Ajrh = new ajqw(this);
  ajrn jdField_a_of_type_Ajrn;
  public DialogInterface.OnClickListener a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  bbgg jdField_a_of_type_Bbgg = null;
  public bfxh a;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DrawerPushItem jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
  public BaseChatPie a;
  public SessionInfo a;
  ApolloPanelAdapter jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter;
  private ApolloPanelGuideView jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ApolloPanel.24(this);
  private Deque<ajrg> jdField_a_of_type_JavaUtilDeque;
  public List<ajrp> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this, true);
  private volatile boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  private ajrh jdField_b_of_type_Ajrh = new ajqx(this);
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public LinearLayout b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 0;
  private ajrh jdField_c_of_type_Ajrh = this.jdField_a_of_type_Ajrh;
  public RelativeLayout c;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  public List<Integer> c;
  private boolean jdField_c_of_type_Boolean;
  public int d;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean;
  private boolean k;
  
  public ApolloPanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ajqo(this);
    this.jdField_a_of_type_Aiss = new ajqp(this);
    this.jdField_d_of_type_Int = 1;
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ajqo(this);
    this.jdField_a_of_type_Aiss = new ajqp(this);
    this.jdField_d_of_type_Int = 1;
  }
  
  private int a(List<ajrp> paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt >= paramList.size())) {
      throw new IllegalArgumentException("packageBinderList is null or tabIndex is out");
    }
    int n = 0;
    int m = 0;
    if (n < paramInt)
    {
      ajrp localajrp = (ajrp)paramList.get(n);
      if (localajrp == null) {
        break label72;
      }
      m = localajrp.a() + m;
    }
    label72:
    for (;;)
    {
      n += 1;
      break;
      return m;
    }
  }
  
  private aiwq a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return null;
    }
    airv localairv = (airv)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211);
    aiwq localaiwq = localairv.a();
    if (localaiwq.jdField_a_of_type_Int != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[checkJumpToGameTab] checkGameTab jumpGameId:", Integer.valueOf(localaiwq.jdField_a_of_type_Int), ",from:", Integer.valueOf(localaiwq.jdField_b_of_type_Int), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
      if (!this.jdField_a_of_type_Boolean) {
        localairv.a(-1, -1);
      }
      return localaiwq;
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
          localObject1 = localResources.getDrawable(2130837710);
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
            localDrawable = localResources.getDrawable(2130843142);
            localObject4 = localObject1;
            if (paramApolloActionData.status == 0) {
              break;
            }
            str = Integer.toString(1);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            break label228;
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
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = actn.a(90.0F, localResources);
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
  
  private void a(View paramView, int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramView == null) || (paramString == null)) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Bfxh != null)
        {
          if (this.jdField_a_of_type_JavaUtilDeque == null) {
            this.jdField_a_of_type_JavaUtilDeque = new LinkedList();
          }
          this.jdField_a_of_type_JavaUtilDeque.addLast(new ajrg(paramView, paramInt1, paramString, paramInt2));
          return;
        }
        paramString = bfxh.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).b(paramInt2).a(paramString).a(16.0F).a(-1);
        paramString.c(paramInt1);
        paramString = new bfxj(paramString).b(Color.argb(255, 0, 0, 0)).a(5).a();
      } while (paramString == null);
      this.jdField_a_of_type_Bfxh = paramString.a();
    } while (this.jdField_a_of_type_Bfxh == null);
    this.jdField_a_of_type_Bfxh.a(82);
    this.jdField_a_of_type_Bfxh.c(2);
    this.jdField_a_of_type_Bfxh.a(paramView);
    this.jdField_a_of_type_Bfxh.setOnDismissListener(new ajrb(this));
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[realshowNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", extra=", paramBundle });
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(super.getContext()).inflate(2131558606, null));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setId(2131362634);
    ((ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131367938)).setOnClickListener(this);
    Object localObject2 = super.getResources();
    Object localObject1 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131367926);
    ajqf localajqf = new ajqf(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    localajqf.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramApolloActionData;
    ((ImageView)localObject1).setImageDrawable(a(paramApolloActionData));
    ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131378444)).setText(paramApolloActionData.actionName);
    ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131378443)).setText(paramApolloActionData.description);
    ((Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363612)).setOnClickListener(new ajqr(this, paramApolloActionData));
    localObject1 = (Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131363452);
    int m = super.getHeight() - this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight();
    if (m < actn.a(213.0F, (Resources)localObject2))
    {
      localObject3 = (LinearLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131364669);
      m = m - (int)((Resources)localObject2).getDimension(2131296408) - (int)((Resources)localObject2).getDimension(2131296409);
      ((RelativeLayout.LayoutParams)((LinearLayout)localObject3).getLayoutParams()).bottomMargin = ((int)(m * 0.1D));
      ((RelativeLayout.LayoutParams)((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131364664)).getLayoutParams()).bottomMargin = ((int)(m * 0.2D));
    }
    localObject2 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131367692);
    Object localObject3 = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131378466);
    switch (paramInt2)
    {
    case 24: 
    case 26: 
    default: 
      switch (paramInt1)
      {
      }
      break;
    }
    for (;;)
    {
      paramBundle = new RelativeLayout.LayoutParams(-1, -1);
      paramBundle.addRule(2, 2131362648);
      addView(this.jdField_d_of_type_AndroidWidgetRelativeLayout, paramBundle);
      paramBundle = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      paramBundle.setDuration(500L);
      paramBundle.setRepeatCount(0);
      paramBundle.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.startAnimation(paramBundle);
      this.jdField_g_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_flame_view", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(paramApolloActionData.actionId) });
      }
      return;
      ((ImageView)localObject2).setVisibility(8);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(ajyc.a(2131700468));
      break;
      ((ImageView)localObject2).setVisibility(8);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(ajyc.a(2131700458));
      break;
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838379);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FFFF8444"));
      ((TextView)localObject3).setText(paramApolloActionData.extraWording);
      break;
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838380);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(ajyc.a(2131700460));
      localObject2 = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131378454);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(String.valueOf(paramApolloActionData.currencyNum));
      break;
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838381);
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(ajyc.a(2131700469));
      break;
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838401);
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(super.getResources().getString(2131690085));
      break;
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838401);
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(super.getResources().getString(2131690085));
      break;
      ((Button)localObject1).setText(ajyc.a(2131700463));
      ((Button)localObject1).setOnClickListener(new ajqs(this, localajqf, paramApolloActionData));
      continue;
      ((Button)localObject1).setText(ajyc.a(2131700473));
      ((Button)localObject1).setOnClickListener(new ajqt(this, paramBundle, paramApolloActionData));
      continue;
      ((Button)localObject1).setText(ajyc.a(2131700462));
      ((Button)localObject1).setOnClickListener(new ajqu(this, paramApolloActionData, paramBundle));
      continue;
      ((Button)localObject1).setText(super.getResources().getString(2131690079));
      ((Button)localObject1).setOnClickListener(new ajqv(this, paramApolloActionData));
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.32(this, paramAppInfo, paramString));
  }
  
  private void a(List<ajrp> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramList == null) || (paramList1 == null)) {
      return;
    }
    this.jdField_c_of_type_Ajrh.a(paramList, paramList1, paramBoolean);
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
      return airz.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    this.jdField_a_of_type_Ajqg = new ajqg(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Ajqg.b(paramInt2);
    this.jdField_a_of_type_Ajqg.a(this);
    if (paramInt1 == 0) {
      this.jdField_a_of_type_Ajqg.a(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func showApolloPanel begins. Thread id = " + Thread.currentThread().getId());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Ajqg);
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
      Object localObject = (ajmw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      localApolloActionData = ((ajmw)localObject).a(paramInt1);
      if (localApolloActionData == null)
      {
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] no action info, abort");
        return;
      }
      boolean bool2 = ((ajmw)localObject).b(paramInt1);
      if ((((ajmw)localObject).c(paramInt1)) || (localApolloActionData.feeType == 1)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] isObtained=", Boolean.valueOf(bool2), ", isFree=", Boolean.valueOf(bool1), ", feeType=", Integer.valueOf(localApolloActionData.feeType) });
        }
        if (!bool1) {
          break;
        }
        a(localApolloActionData, 0, 20, null);
        return;
      }
      if (localApolloActionData.feeType == 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(new ajqq(this, localApolloActionData));
        ((bbqp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(localApolloActionData.actionId, null, null, 0, 0.0F, 0, "newActionFloatView");
        return;
      }
      if (localApolloActionData.feeType == 2)
      {
        if (localApolloActionData.currencyType == 1)
        {
          if (bool2)
          {
            a(localApolloActionData, 0, 23, null);
            return;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putInt("pkgId", paramInt2);
          a(localApolloActionData, 2, 23, (Bundle)localObject);
          return;
        }
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] currency type not gold, abort");
        return;
      }
      if (localApolloActionData.feeType == 9)
      {
        if (((airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
        {
          a(localApolloActionData, 0, 28, null);
          return;
        }
        a(localApolloActionData, 4, 27, null);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloPanel", 2, new Object[] { "[showNewActionFloatView] not support yet, feeType=", Integer.valueOf(localApolloActionData.feeType) });
  }
  
  private void e(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_c_of_type_Ajrh.a(paramInt);
  }
  
  private void f(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    int n = c();
    int m = n;
    if (paramInt != 0)
    {
      m = n;
      if (paramInt != n) {
        m = paramInt;
      }
    }
    paramInt = m;
    if (m == 2)
    {
      paramInt = m;
      if (!b()) {
        paramInt = 1;
      }
    }
    g(paramInt);
  }
  
  private void g(int paramInt)
  {
    if ((this.jdField_d_of_type_Int != paramInt) && (QLog.isColorLevel())) {
      QLog.d("ApolloPanel", 2, new Object[] { "setCurrentPanelType targetPanelType=", Integer.valueOf(paramInt) });
    }
    this.jdField_d_of_type_Int = paramInt;
    if (this.jdField_d_of_type_Int == 2)
    {
      this.jdField_c_of_type_Ajrh = this.jdField_b_of_type_Ajrh;
      return;
    }
    this.jdField_c_of_type_Ajrh = this.jdField_a_of_type_Ajrh;
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
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
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
    View localView = super.findViewById(2131362634);
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
    ThreadManager.getUIHandler().post(new ApolloPanel.33(this));
  }
  
  private void x()
  {
    if (getVisibility() == 0)
    {
      if (!this.jdField_a_of_type_Aism.b()) {
        break label45;
      }
      QLog.d("ApolloPanel", 2, "showGuidePageFor3D for json");
      this.jdField_i_of_type_Boolean = true;
      this.jdField_a_of_type_Aism.b(false);
      q();
    }
    label45:
    while (!this.jdField_a_of_type_Aism.a()) {
      return;
    }
    QLog.d("ApolloPanel", 2, "showGuidePageFor3D for action");
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_Aism.a(false);
    q();
  }
  
  private void y()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.getParent() == this))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[hideGuidePageFor3D] remove");
      }
      super.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView = null;
    }
  }
  
  public int a()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int i2 = 0;
    int i1 = i2;
    int m;
    int n;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i1 = i2;
      if (paramInt > 0)
      {
        m = 0;
        n = 0;
      }
    }
    for (;;)
    {
      i1 = i2;
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        n += ((ajrp)this.jdField_a_of_type_JavaUtilList.get(m)).a();
        if (paramInt < n) {
          i1 = ((ajrp)this.jdField_a_of_type_JavaUtilList.get(m)).a() - (n - paramInt);
        }
      }
      else
      {
        return i1;
      }
      m += 1;
    }
  }
  
  public int a(BaseChatPie paramBaseChatPie, ajpz paramajpz, ApolloActionData paramApolloActionData)
  {
    int n;
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      n = 0;
      return n;
    }
    ajmw localajmw = (ajmw)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    paramBaseChatPie = (airz)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    boolean bool = localajmw.b(paramApolloActionData.actionId);
    int m;
    if ((paramApolloActionData.hasSound) || (paramajpz.jdField_e_of_type_Int > 0)) {
      m = 1;
    }
    for (;;)
    {
      if (localajmw.c(paramApolloActionData.actionId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "data actionId:", Integer.valueOf(paramApolloActionData.actionId), "typeValue:", Integer.valueOf(m) });
        }
        return m | 0x2;
        if (paramApolloActionData.actionType == 8) {
          m = 1024;
        }
      }
      else
      {
        n = m;
        if (paramApolloActionData.feeType == 6)
        {
          if (bool)
          {
            n = 16;
            n = m | n;
          }
        }
        else
        {
          int i1 = n;
          if (paramApolloActionData.feeType == 2)
          {
            if (!bool) {
              break label267;
            }
            m = 4;
            label204:
            i1 = n | m;
          }
          m = i1;
          if (paramApolloActionData.feeType == 9) {
            m = i1 | 0x2000;
          }
          n = m;
          if (paramApolloActionData.feeType != 7) {
            break;
          }
          if (!bool) {
            break label275;
          }
        }
        label267:
        label275:
        for (n = 8;; n = 512)
        {
          return m | n;
          n = 64;
          break;
          m = 128;
          break label204;
        }
      }
      m = 0;
    }
  }
  
  public ajrp a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "getViewBinder type=" + paramInt);
    }
    return this.jdField_c_of_type_Ajrh.a(paramInt);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ((bbqp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(1, "actionPanel");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "actionpanel onOpen");
      }
      this.jdField_g_of_type_Int = -1;
    }
  }
  
  public void a(int paramInt)
  {
    int m = b(paramInt);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > m))
    {
      int n = ((ajrp)this.jdField_a_of_type_JavaUtilList.get(m)).a();
      if (((ajrp)this.jdField_a_of_type_JavaUtilList.get(m)).jdField_d_of_type_Int == 100) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
      }
      do
      {
        return;
        if ((n <= 1) || (((ajrp)this.jdField_a_of_type_JavaUtilList.get(m)).jdField_d_of_type_Int == 100)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(n);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.onPageSelected(a(paramInt));
      } while (!QLog.isColorLevel());
      QLog.d("ApolloPanel", 2, "mRadioGroup is visible count = " + n);
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int m;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      m = 0;
    }
    for (;;)
    {
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        ajrp localajrp = (ajrp)this.jdField_a_of_type_JavaUtilList.get(m);
        if ((localajrp.jdField_d_of_type_Int == 100) && ((localajrp instanceof ajpn)) && (((ajpn)localajrp).a != null) && (((ajpn)localajrp).a.gameId == paramInt2)) {
          ((ajpn)localajrp).a(paramInt1);
        }
      }
      else
      {
        return;
      }
      m += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, ApolloPanel paramApolloPanel)
  {
    if (((paramInt1 == 21) || (paramInt2 == 21)) && (paramApolloPanel != null))
    {
      paramApolloPanel = a(100);
      if ((paramApolloPanel != null) && ((paramApolloPanel instanceof ajpn)))
      {
        paramApolloPanel = (ajpn)paramApolloPanel;
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
      paramApolloPanel = ajfj.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    if ((this.jdField_a_of_type_Ajrn != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = this.jdField_a_of_type_Ajrn.a();
      if (((List)localObject).size() > paramInt)
      {
        localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] packageId=", Integer.valueOf(((ApolloActionPackage)localObject).packageId), ", tabIndex= ", Integer.valueOf(paramInt), ", isUpdate=", Boolean.valueOf(((ApolloActionPackage)localObject).isUpdate), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        }
        if ((((ApolloActionPackage)localObject).isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= ((ApolloActionPackage)localObject).redStartTime))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "clear tab red packageId=" + ((ApolloActionPackage)localObject).packageId + " tabIndex = " + paramInt);
          }
          ((ajro)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          ((ApolloActionPackage)localObject).isUpdate = false;
          paramInt = ((ApolloActionPackage)localObject).redFlowId;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] pkg=", Integer.valueOf(((ApolloActionPackage)localObject).packageId), ", new action id=", Integer.valueOf(paramInt) });
          }
          ThreadManager.post(new ApolloPanel.21(this, (ApolloActionPackage)localObject), 5, null, true);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, new Object[] { "[checkRedTab] mShouldShowActionFloatView=", Boolean.valueOf(this.jdField_g_of_type_Boolean), ", mIsTriggeredByClick=", Boolean.valueOf(this.jdField_d_of_type_Boolean) });
          }
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
          if ((this.jdField_g_of_type_Boolean) && (paramInt != 0))
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
  
  public void a(ajpz paramajpz)
  {
    int i1 = 0;
    if ((paramajpz == null) || (paramajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null)) {}
    int n;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      int m = 0;
      n = i1;
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject1 = (ajrp)this.jdField_a_of_type_JavaUtilList.get(m);
        if (((ajrp)localObject1).jdField_a_of_type_JavaUtilList == null) {}
        while (((ajrp)localObject1).jdField_d_of_type_Int != 2)
        {
          m += 1;
          break;
        }
        Object localObject2;
        if (((ajrp)localObject1).jdField_c_of_type_Int != 5)
        {
          ((ajrp)localObject1).b(5);
          localObject2 = new ajpz();
          ((ajpz)localObject2).jdField_b_of_type_Int = 2;
          ApolloActionData localApolloActionData = new ApolloActionData();
          localApolloActionData.actionName = super.getResources().getString(2131690067);
          ((ajpz)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
          ((ajrp)localObject1).jdField_a_of_type_JavaUtilList.add(0, localObject2);
        }
        localObject1 = ((ajrp)localObject1).jdField_a_of_type_JavaUtilList;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          localObject2 = (ajmw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          paramajpz.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramajpz, paramajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
        }
        ((List)localObject1).add(1, paramajpz);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "add action to fav action " + paramajpz.toString());
        }
        n = 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (n != 0))
      {
        a(jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (n != 0));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[initPanel] jumpPkdId=", Integer.valueOf(paramInt1), ", jumpActionId=", Integer.valueOf(paramInt2) });
    }
    paramBaseChatPie = (airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (paramBaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[initPanel] apollo status open, remember jump info");
      }
      this.jdField_f_of_type_Int = paramInt1;
      this.jdField_e_of_type_Int = paramInt2;
    }
    this.jdField_g_of_type_Int = paramInt3;
    paramBaseChatPie.a(this.jdField_a_of_type_Aisk);
    this.jdField_a_of_type_Aism = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131362971));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)super.findViewById(2131362957));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363584));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364666));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131364665));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363561));
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131363461));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_c_of_type_ComTencentImageURLImageView.getParent());
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131363555));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362600));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)super.findViewById(2131362647));
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    Drawable localDrawable = super.getContext().getResources().getDrawable(2130838422);
    paramSessionInfo.addState(new int[] { 16842919 }, localDrawable);
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    localDrawable = super.getContext().getResources().getDrawable(2130838421);
    paramSessionInfo.addState(new int[] { -16842919 }, localDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131362648));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter = new ApolloPanelAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131376788));
    this.jdField_a_of_type_Ajrn = new ajrn(super.getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Ajrn);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    super.findViewById(2131376784).setBackgroundColor(super.getContext().getResources().getColor(2131165549));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369513));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362642));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362641));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362640));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362591));
    this.jdField_a_of_type_Aisr = paramBaseChatPie.a();
    if (this.jdField_a_of_type_Aisr != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_Aisr.a.get()));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(super.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout).a(5).a();
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = ((avpq)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf("103100.103200.103250"));
      paramBaseChatPie = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (paramBaseChatPie != null) {
        paramBaseChatPie.a(100);
      }
      bgzg.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramBaseChatPie = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if ((paramBaseChatPie.getBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)) && (this.jdField_g_of_type_Int != 7))
      {
        paramBaseChatPie.edit().putBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
        paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.obtainMessage(51).sendToTarget();
        }
      }
      if (airz.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "[initPanel] getUserApolloInfo");
        }
        this.jdField_a_of_type_Boolean = true;
        ((bbqp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 8650880, "Open Panel");
        airz.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_Aisr != null) {
        this.jdField_a_of_type_Aisr.a(null);
      }
      paramBaseChatPie = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      if ((paramBaseChatPie == null) || (!paramBaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_JavaLangString))) {
        break label1110;
      }
    }
    label1110:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.getLayoutParams()).bottomMargin = ((int)(10.0F * super.getResources().getDisplayMetrics().density));
      setBackgroundColor(super.getResources().getColor(2131165551));
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
    int m = 0;
    for (;;)
    {
      try
      {
        if (m >= this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildCount()) {
          continue;
        }
        localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getChildAt(m);
        if (!(localViewGroup instanceof ApolloLinearLayout)) {
          break label384;
        }
        if (((ApolloLinearLayout)localViewGroup).a(paramApolloActionData) != null) {
          break label391;
        }
      }
      catch (Exception paramApolloActionData)
      {
        ViewGroup localViewGroup;
        LinearLayout localLinearLayout;
        int i1;
        ajqb localajqb;
        ajpz localajpz;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloPanel", 2, "updateItemStatus error:" + paramApolloActionData.toString());
        l2 = System.currentTimeMillis();
      }
      if (n < localViewGroup.getChildCount())
      {
        localLinearLayout = (LinearLayout)localViewGroup.getChildAt(n);
        i1 = 0;
        if (i1 < localLinearLayout.getChildCount())
        {
          localajqb = (ajqb)localLinearLayout.getChildAt(i1).getTag();
          if (localajqb != null)
          {
            localajpz = localajqb.a;
            if ((localajpz != null) && (localajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramApolloActionData.actionId))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).post(new ApolloPanel.20(this, localajqb));
            }
          }
          i1 += 1;
          continue;
        }
        n += 1;
        continue;
        long l2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloPanel", 2, "updateItemStatus cost time = " + (l2 - l1));
        return;
      }
      label384:
      m += 1;
      continue;
      label391:
      int n = 0;
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, boolean paramBoolean)
  {
    ThreadManager.post(new ApolloPanel.31(this, paramAppInfo, paramBoolean, paramString), 5, null, true);
  }
  
  public void a(String paramString)
  {
    a(paramString, false, false);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString5))) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Bbgg != null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "showAidDialog title=" + paramString2 + " content=" + paramString3 + "rightString=" + paramString4 + " url=" + paramString5);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
    n();
    int m;
    if ("onlyRightType".equals(paramString5))
    {
      m = 1;
      paramString1 = new ajqk(this);
      label137:
      paramString6 = super.getResources().getString(2131695350);
      if (m == 0) {
        break label407;
      }
    }
    label407:
    for (paramString5 = null;; paramString5 = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener)
    {
      this.jdField_a_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, paramString2, paramString3, paramString6, paramString4, paramString1, paramString5);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
        break;
      }
      this.jdField_a_of_type_Bbgg.show();
      return;
      if ("moreInfo".equals(paramString5))
      {
        paramString1 = new ajql(this, paramString7);
        m = 0;
        break label137;
      }
      if ("requestSSO".equals(paramString5))
      {
        paramString1 = new ajqm(this, paramString1, paramString7, paramString8);
        m = 0;
        break label137;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(String.valueOf(9))))
      {
        ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "lmx_actchat");
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_view", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + paramString7, "0" });
        return;
      }
      paramString1 = new ajqn(this, paramString5, paramString6, paramString7, paramString1);
      m = 0;
      break label137;
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
    ajmw localajmw;
    List localList;
    do
    {
      do
      {
        return;
        new ArrayList();
        localArrayList1 = new ArrayList();
        localajmw = (ajmw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      } while (localajmw == null);
      localList = localajmw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
    int i3 = 0;
    int m = 0;
    int n = -1;
    label164:
    ApolloActionPackage localApolloActionPackage;
    if (i3 < localList.size())
    {
      localApolloActionPackage = (ApolloActionPackage)localList.get(i3);
      if (localApolloActionPackage == null) {
        break label2257;
      }
      if (localApolloActionPackage.packageId != 4) {}
    }
    label548:
    label820:
    label1333:
    label1592:
    label2247:
    label2250:
    label2257:
    for (;;)
    {
      i3 += 1;
      break label164;
      if (this.jdField_c_of_type_Ajrh.a(localApolloActionPackage.packageId))
      {
        String str = bbct.c();
        if ((!TextUtils.isEmpty(localApolloActionPackage.startVersion)) && (!TextUtils.isEmpty(localApolloActionPackage.endVersion)) && ((!bbpm.a(localApolloActionPackage.startVersion, str)) || (!bbpm.a(str, localApolloActionPackage.endVersion))))
        {
          QLog.w("ApolloPanel", 1, "version not correct packageId=" + localApolloActionPackage.packageId);
        }
        else
        {
          long l2 = System.currentTimeMillis();
          ajrp localajrp = a(localApolloActionPackage.type);
          if (localajrp != null)
          {
            localajrp.jdField_e_of_type_Int = localApolloActionPackage.packageId;
            Object localObject3 = null;
            ArrayList localArrayList3 = new ArrayList();
            Object localObject1;
            Object localObject2;
            Object localObject4;
            int i1;
            label485:
            long l1;
            label510:
            ApolloActionData localApolloActionData;
            if (localApolloActionPackage.type == 2)
            {
              localObject1 = localajmw.a();
              localObject2 = (List)((Pair)localObject1).first;
              localObject3 = (List)((Pair)localObject1).second;
              if ((localObject2 != null) && (((List)localObject2).size() > 0))
              {
                localajrp.b(5);
                localObject4 = new ajpz();
                ((ajpz)localObject4).jdField_b_of_type_Int = 2;
                localObject1 = new ApolloActionData();
                ((ApolloActionData)localObject1).actionName = super.getResources().getString(2131690067);
                ((ajpz)localObject4).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)localObject1);
                localArrayList3.add(localObject4);
                localObject1 = null;
                i1 = m;
                l1 = System.currentTimeMillis();
                localObject4 = new StringBuilder();
                if (localObject3 == null) {
                  break label2250;
                }
                m = n;
                n = 0;
                if (n >= ((List)localObject3).size()) {
                  break label1333;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
                  break;
                }
                localApolloActionData = (ApolloActionData)((List)localObject3).get(n);
                if (localApolloActionData != null) {
                  break label820;
                }
              }
            }
            for (;;)
            {
              n += 1;
              break label510;
              localajrp.b(4);
              break;
              if (localApolloActionPackage.type == 100)
              {
                localObject1 = localajmw.h();
                if ((localObject1 != null) && (((List)localObject1).size() > 0))
                {
                  i1 = m;
                  if ((localajrp instanceof ajpn))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloPanel", 2, new Object[] { "set panel game list, size=", Integer.valueOf(((List)localObject1).size()) });
                    }
                    ((ajpn)localajrp).a((List)localObject1);
                    localajrp.b(100);
                    i1 = m + localajrp.a();
                    localArrayList2.add(localajrp);
                    localArrayList1.add(localList.get(i3));
                  }
                }
                for (;;)
                {
                  localObject1 = null;
                  localObject2 = null;
                  break;
                  QLog.i("ApolloPanel", 1, "load game info fail cause games == null");
                  i1 = m;
                }
              }
              localObject3 = localajmw.d(localApolloActionPackage.packageId);
              localObject1 = localajmw.e(localApolloActionPackage.packageId);
              localajrp.b(0);
              if (localApolloActionPackage.packageId == 6)
              {
                localajrp.b(9);
                localajmw.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (List)localObject3);
                localObject2 = null;
                i1 = m;
                break label485;
              }
              if (localApolloActionPackage.packageId == 7) {
                localajmw.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (List)localObject3);
              }
              localObject2 = null;
              i1 = m;
              break label485;
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
                if (((ApolloActionData)((List)localObject3).get(n)).isShow != 0) {
                  break label980;
                }
                ((StringBuilder)localObject4).append(",hide ").append(localApolloActionData.actionId);
              }
            }
            label980:
            ajpz localajpz = localajrp.a(paramString);
            localajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
            localajpz.jdField_a_of_type_Int = localApolloActionPackage.packageId;
            if (localApolloActionPackage.type == 2) {
              if ((localObject2 != null) && (((List)localObject2).size() > n))
              {
                localajpz.jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject2).get(n)).text;
                localajpz.jdField_d_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(n)).textType;
                localajpz.jdField_e_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(n)).audioId;
                localajpz.jdField_a_of_type_Float = ((ApolloFavActionData)((List)localObject2).get(n)).audioStartTime;
                localajpz.jdField_f_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(n)).playOriginalAudio;
              }
            }
            for (localajpz.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localajpz, localajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);; localajpz.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localajpz, localajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData))
            {
              do
              {
                localArrayList3.add(localajpz);
                if ((m != -1) || (this.jdField_e_of_type_Int != localApolloActionData.actionId)) {
                  break label2247;
                }
                if (this.jdField_f_of_type_Int == -1)
                {
                  this.jdField_f_of_type_Int = localApolloActionPackage.packageId;
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] jump action match but no jump pkg, use ", Integer.valueOf(this.jdField_f_of_type_Int) });
                  }
                }
                if (this.jdField_f_of_type_Int != localApolloActionPackage.packageId) {
                  break label2247;
                }
                m = localArrayList3.size() - 1;
                break;
              } while ((localObject1 == null) || (((List)localObject1).size() <= n));
              localajpz.jdField_b_of_type_JavaLangString = ((ApolloActionPackageData)((List)localObject1).get(n)).text;
              localajpz.jdField_d_of_type_Int = ((ApolloActionPackageData)((List)localObject1).get(n)).textType;
            }
            if (0 != 0) {
              throw new NullPointerException();
            }
            int i2 = i1;
            n = m;
            if (localArrayList3.size() > 0)
            {
              localajrp.c_(localArrayList3);
              if (this.jdField_f_of_type_Int == localApolloActionPackage.packageId)
              {
                if (m == -1) {
                  break label1584;
                }
                localajrp.c(m);
                jdField_a_of_type_Int = localajrp.a(m) + i1;
                label1404:
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] init sCurrentIndex with jump info, sCurrentIndex=", Integer.valueOf(jdField_a_of_type_Int), ", jumpActionIndex=", Integer.valueOf(m) });
                }
              }
              localArrayList2.add(localajrp);
              localArrayList1.add(localList.get(i3));
              i2 = i1 + localajrp.a();
              n = m;
            }
            for (;;)
            {
              if (QLog.isColorLevel())
              {
                m = localApolloActionPackage.packageId;
                if (localObject3 != null) {
                  break label1592;
                }
              }
              for (localObject1 = null;; localObject1 = Integer.valueOf(((List)localObject3).size()))
              {
                QLog.d("ApolloPanel", 2, new Object[] { "Tab add package:", Integer.valueOf(m), ",actionPackageDatas size:", localObject1, ",findTime:", Long.valueOf(l1 - l2), ",remove actions ", ((StringBuilder)localObject4).toString() });
                m = i2;
                break;
                jdField_a_of_type_Int = i1;
                break label1404;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
              }
              if ((this.jdField_e_of_type_Int == -1) && (this.jdField_f_of_type_Int == -1)) {
                a(localArrayList2, localArrayList1, paramBoolean);
              }
              if ((this.jdField_e_of_type_Int != -1) && (n == -1) && (!this.jdField_b_of_type_Boolean))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, "[initPanelData] no jump action found, try to update json");
                }
                if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
                  this.jdField_a_of_type_AndroidWidgetImageView.post(new ApolloPanel.3(this));
                }
                this.jdField_b_of_type_Boolean = true;
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
                  ((airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(1);
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
                if (!this.jdField_a_of_type_Boolean)
                {
                  this.jdField_f_of_type_Int = -1;
                  this.jdField_e_of_type_Int = -1;
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
              this.jdField_c_of_type_Ajrh.a();
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
              break label548;
              i2 = i1;
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
    if (this.jdField_g_of_type_Int == 7)
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
    a((String)paramMap.get("feeType"), (String)paramMap.get("title"), (String)paramMap.get("content"), (String)paramMap.get("rightString"), (String)paramMap.get("url"), (String)paramMap.get("isActionBack"), (String)paramMap.get("actionId"), (String)paramMap.get("extendJson"));
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
              if (this.jdField_a_of_type_Ajqg != null) {
                this.jdField_a_of_type_Ajqg.c();
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
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
          jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(jdField_a_of_type_Int);
          k();
          return;
        }
      } while (1 != ((Integer)localPair.second).intValue());
      ((airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(false, "panel open apollo", 1);
    } while (this.jdField_a_of_type_Ajqg == null);
    this.jdField_a_of_type_Ajqg.b(0);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, false);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Ajrn != null)
    {
      Object localObject = this.jdField_a_of_type_Ajrn.a();
      if ((localObject != null) && (this.jdField_i_of_type_Int >= 0) && (this.jdField_i_of_type_Int < ((List)localObject).size()))
      {
        localObject = (ApolloActionPackage)((List)localObject).get(this.jdField_i_of_type_Int);
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
    if ((this.jdField_a_of_type_JavaUtilList.size() > jdField_a_of_type_Int) && ((this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int) instanceof ajpn)))
    {
      ApolloGameData localApolloGameData = ((ajpn)this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int)).b();
      if (localApolloGameData != null) {
        return localApolloGameData.gameId;
      }
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    int i2 = 0;
    int i1 = i2;
    int m;
    int n;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i1 = i2;
      if (paramInt > 0)
      {
        m = 0;
        n = 0;
      }
    }
    for (;;)
    {
      i1 = i2;
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        n += ((ajrp)this.jdField_a_of_type_JavaUtilList.get(m)).a();
        if (paramInt < n) {
          i1 = m;
        }
      }
      else
      {
        return i1;
      }
      m += 1;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_key_url_append", "&showDialog=1&type=role");
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, "aio", ajmu.ah, null);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
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
        if (!apvb.a(ApolloUtil.jdField_a_of_type_JavaLangString))
        {
          c(paramInt, 3);
          ((airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_Ajov);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_JavaUtilList);
        b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ApolloPanel", 1, "[jumpToPkgOrAction] mBaseChatPie or mBaseChatPie.app is null");
      return;
    }
    airz localairz = (airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (localairz.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 1)
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
    int m;
    if ((localObject != null) && (((aiwq)localObject).jdField_a_of_type_Int > 0) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      m = 0;
      label182:
      if (m >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label1260;
      }
      if (!(this.jdField_a_of_type_JavaUtilList.get(m) instanceof ajpn)) {}
    }
    for (;;)
    {
      if (m != -1)
      {
        paramInt1 = jdField_a_of_type_Int;
        if ((jdField_a_of_type_Int != m) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(m, false);
          a(m);
          setTabSelect(b(m));
          jdField_a_of_type_Int = m;
        }
        if ((m >= paramInt1 - 1) && (m <= paramInt1 + 1))
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
        QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] checkGameTab jumpGameId:" + ((aiwq)localObject).jdField_a_of_type_Int + ",gameTabIndex:" + m);
        return;
        m += 1;
        break label182;
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
      int i1 = 0;
      m = -1;
      int i2 = -1;
      int i6 = this.jdField_a_of_type_JavaUtilList.size();
      int i5 = 0;
      label517:
      int i3;
      List localList;
      label798:
      ajpz localajpz;
      if ((i5 < i6) && (m == -1))
      {
        localObject = (ajrp)this.jdField_a_of_type_JavaUtilList.get(i5);
        if (localObject == null) {
          break label1253;
        }
        if ((paramInt1 != -1) && (((ajrp)localObject).jdField_e_of_type_Int == paramInt1))
        {
          if (paramInt2 == -1)
          {
            m = i1;
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump for pkg, newViewPagerIndex=", Integer.valueOf(i1) });
              m = i1;
            }
            if (m != -1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump to new index=", Integer.valueOf(m), ", current index=", Integer.valueOf(jdField_a_of_type_Int) });
              }
              n = jdField_a_of_type_Int;
              if (jdField_a_of_type_Int != m)
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(m, false);
                a(m);
                setTabSelect(b(m));
                jdField_a_of_type_Int = m;
              }
              if ((m >= n - 1) && (m <= n + 1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] force refresh cache view");
                }
                this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
              }
            }
            if ((paramInt2 == -1) || (i2 != -1)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] mIsJsonUpdatedByJumpAction=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
            }
            if (this.jdField_b_of_type_Boolean) {
              break;
            }
            if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            this.jdField_b_of_type_Boolean = true;
            this.jdField_e_of_type_Int = paramInt2;
            this.jdField_f_of_type_Int = paramInt1;
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] no action found, try to update json");
            }
            localairz.a(1);
            return;
          }
          n = i2;
          i3 = m;
          if (!(localObject instanceof ajpn))
          {
            localList = ((ajrp)localObject).jdField_a_of_type_JavaUtilList;
            if ((localList == null) || (localList.size() <= 0)) {
              break label966;
            }
            n = 0;
            i3 = localList.size();
            if (n >= i3) {
              break label1244;
            }
            localajpz = (ajpz)localList.get(n);
            if ((localajpz != null) && (localajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramInt2))
            {
              ((ajrp)localObject).c(n);
              m = ((ajrp)localObject).a(n) + i1;
              if (!QLog.isColorLevel()) {
                break label1231;
              }
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump action found, jumpActionIndex=", Integer.valueOf(n), ", newViewPagerIndex=", Integer.valueOf(m) });
              i2 = n;
              n = m;
              m = i2;
              label916:
              i3 = n;
              n = m;
            }
          }
          else
          {
            label923:
            i1 = ((ajrp)localObject).a() + i1;
            m = i3;
            i2 = n;
          }
        }
      }
      label966:
      label1231:
      label1244:
      label1253:
      for (int n = i1;; n = i1)
      {
        i5 += 1;
        i1 = n;
        break;
        n += 1;
        break label798;
        m = i1;
        if (!QLog.isColorLevel()) {
          break label517;
        }
        QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] mIsJsonUpdatedByJumpAction true, just jump pkg, newViewPagerIndex=", Integer.valueOf(i1) });
        m = i1;
        break label517;
        n = i2;
        i3 = m;
        if (paramInt2 == -1) {
          break label923;
        }
        n = i2;
        i3 = m;
        if ((localObject instanceof ajpn)) {
          break label923;
        }
        localList = ((ajrp)localObject).jdField_a_of_type_JavaUtilList;
        if ((localList != null) && (localList.size() > 0))
        {
          int i4 = 0;
          int i7 = localList.size();
          for (;;)
          {
            n = i2;
            i3 = m;
            if (i4 >= i7) {
              break;
            }
            localajpz = (ajpz)localList.get(i4);
            if ((localajpz != null) && (localajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramInt2))
            {
              if (paramInt1 != -1)
              {
                n = i2;
                i3 = m;
                if (paramInt1 != ((ajrp)localObject).jdField_e_of_type_Int) {
                  break;
                }
              }
              ((ajrp)localObject).c(i4);
              i3 = i1 + ((ajrp)localObject).a(i4);
              if (!QLog.isColorLevel()) {
                break label1221;
              }
              QLog.d("ApolloPanel", 2, new Object[] { "[jumpToPkgOrAction] jump action found2, jumpActionIndex=", Integer.valueOf(i4), ", newViewPagerIndex=", Integer.valueOf(i3) });
              n = i4;
              break;
            }
            i4 += 1;
          }
          n = i4;
          break label923;
        }
        break label517;
        i2 = m;
        m = n;
        n = i2;
        break label916;
        n = m;
        m = i2;
        break label916;
      }
      label1221:
      label1260:
      m = -1;
    }
  }
  
  public void b(String paramString)
  {
    f(0);
    a(paramString, false);
  }
  
  public void b(List<ajrp> paramList)
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
        QLog.d("ApolloPanel", 2, new Object[] { "[onQueryUserApolloAction] result=", Boolean.valueOf(paramBoolean), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
      if ((this.jdField_a_of_type_Boolean) && (!paramBoolean))
      {
        this.jdField_f_of_type_Int = -1;
        this.jdField_e_of_type_Int = -1;
      }
      bool2 = this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Boolean = false;
    } while (!paramBoolean);
    if (paramObject != null)
    {
      paramObject = (Bundle)paramObject;
      int m = paramObject.getInt("jumpPkdId", -1);
      int n = paramObject.getInt("jumpActionId", -1);
      if ((m != -1) && (n != -1))
      {
        this.jdField_f_of_type_Int = m;
        this.jdField_e_of_type_Int = n;
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
      airz localairz = (airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if (localairz != null)
      {
        localairz.a(this.jdField_a_of_type_Ajov);
        int m = 0;
        if (!apvb.a(ApolloUtil.jdField_a_of_type_JavaLangString)) {
          m = 1;
        }
        localairz.a(m);
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
      int m = 0;
      int n = 0;
      while (m < paramInt)
      {
        n += ((ajrp)this.jdField_a_of_type_JavaUtilList.get(m)).a();
        m += 1;
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(n, false);
          a(n);
          Object localObject = this.jdField_a_of_type_Ajrn.a();
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
    int m = ((airz)localQQAppInterface.getManager(153)).b(localQQAppInterface.c());
    String str = localSessionInfo.jdField_a_of_type_JavaLangString;
    if (m == 0) {}
    for (m = 0;; m = 1)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "state_open_clk", str, m, 0, new String[] { String.valueOf(ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int)), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] index=", Integer.valueOf(paramInt) });
    }
    if (this.jdField_a_of_type_Ajrn == null) {}
    int m;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_Ajrn.a();
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
      paramInt = ((ApolloActionPackage)localObject).packageId;
      m = ((ApolloActionPackage)localObject).type;
    } while ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject = (airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (m == 2) {
      ((airz)localObject).a(paramInt, true);
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] packageId=", Integer.valueOf(paramInt) });
      return;
      if ((m != 100) && (((airz)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)) {
        ((airz)localObject).a(paramInt, false);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      bbjv.a("apollo_panel_open", null);
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
    if ((paramInt != 0) && (this.jdField_a_of_type_Bfxh != null) && (this.jdField_a_of_type_Bfxh.isShowing())) {
      this.jdField_a_of_type_Bfxh.dismiss();
    }
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_f_of_type_Boolean = bool;
      return;
    }
  }
  
  protected void e()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_Ajrn != null))
    {
      m = b(jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_Ajrn.a();
      if ((localObject != null) && (((List)localObject).size() > 0) && (m >= 0) && (m < ((List)localObject).size()))
      {
        localObject = (ApolloActionPackage)((List)localObject).get(m);
        if (localObject == null) {
          break label150;
        }
      }
    }
    label150:
    for (int m = ((ApolloActionPackage)localObject).packageId;; m = 0)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "tabexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), m, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
  
  public void f()
  {
    ThreadManager.post(new ApolloPanel.7(this), 5, null, false);
  }
  
  public void g()
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "del fav action");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    int i1;
    label470:
    do
    {
      int i3;
      int m;
      do
      {
        return;
        i3 = 1;
        m = 1;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      int n = 0;
      for (;;)
      {
        i1 = i3;
        if (n >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label470;
        }
        ajrp localajrp = (ajrp)this.jdField_a_of_type_JavaUtilList.get(n);
        if (localajrp.jdField_d_of_type_Int == 2)
        {
          List localList = localajrp.jdField_a_of_type_JavaUtilList;
          if ((localList == null) || (localList.size() == 0))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloPanel", 2, "no fav action yet");
            return;
          }
          Object localObject1 = (ajmw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          if (localObject1 == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("ApolloPanel", 2, "apolloDaoManager null");
            return;
          }
          localList.clear();
          Object localObject2 = ((ajmw)localObject1).a();
          localObject1 = (List)((Pair)localObject2).first;
          localObject2 = (List)((Pair)localObject2).second;
          Object localObject3 = (ajmw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localajrp.b(5);
            localObject3 = new ajpz();
            ((ajpz)localObject3).jdField_b_of_type_Int = 2;
            ApolloActionData localApolloActionData = new ApolloActionData();
            localApolloActionData.actionName = super.getResources().getString(2131690067);
            ((ajpz)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
            localList.add(localObject3);
          }
          for (;;)
          {
            i1 = m;
            if (i2 >= ((List)localObject2).size()) {
              break;
            }
            localObject3 = localajrp.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
            ((ajpz)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject2).get(i2));
            ((ajpz)localObject3).jdField_a_of_type_Int = localajrp.jdField_e_of_type_Int;
            if ((localObject1 != null) && (((List)localObject1).size() > n))
            {
              ((ajpz)localObject3).jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject1).get(i2)).text;
              ((ajpz)localObject3).jdField_d_of_type_Int = ((ApolloFavActionData)((List)localObject1).get(i2)).textType;
              ((ajpz)localObject3).jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (ajpz)localObject3, ((ajpz)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
            }
            localList.add(localObject3);
            i2 += 1;
            continue;
            localajrp.b(4);
            m = 0;
          }
        }
        n += 1;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (i1 != 0))
      {
        a(jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (i1 != 0));
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int m = 0;
      while (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((ajrp)this.jdField_a_of_type_JavaUtilList.get(m)).a();
        m += 1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      airz localairz = (airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if (localairz != null)
      {
        localairz.b(this.jdField_a_of_type_Ajov);
        localairz.c();
        if (this.jdField_a_of_type_Aisr != null) {
          this.jdField_a_of_type_Aisr.a();
        }
      }
    }
    n();
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    u();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter = null;
    this.jdField_a_of_type_Ajqg = null;
    this.jdField_a_of_type_Ajov = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_Ajrc != null) {
      this.jdField_a_of_type_Ajrc.b();
    }
    this.jdField_a_of_type_Bfxh = null;
    this.jdField_a_of_type_JavaUtilDeque = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      int m = paramMessage.getData().getInt("pkgId");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[handleMessage] MSG_SHOW_NEW_ACTION_FLOAT_VIEW, actionId=", Integer.valueOf(paramMessage.arg1), ", pkgId=", Integer.valueOf(m) });
      }
      d(paramMessage.arg1, m);
      return false;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content)) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.life_Time <= 0) || (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_sum >= this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.show_counts));
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 49, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.content, this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.life_Time);
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem;
    paramMessage.show_sum += 1;
    ((airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
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
      if (this.jdField_a_of_type_Ajrn != null)
      {
        List localList = this.jdField_a_of_type_Ajrn.a();
        if ((localList == null) || (localList.isEmpty())) {
          break;
        }
        int n = localList.size();
        int m = 0;
        while (m < n)
        {
          ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)localList.get(m);
          if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate) && (NetConnInfoCenter.getServerTimeMillis() >= localApolloActionPackage.redStartTime))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, new Object[] { "[switch2RedTab] packageId=", Integer.valueOf(localApolloActionPackage.packageId) });
            }
            c(m);
            return;
          }
          m += 1;
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
    airz localairz = (airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    localairz.a(this.jdField_a_of_type_Ajov);
    if (this.jdField_a_of_type_Aisr != null) {
      this.jdField_a_of_type_Aisr.a(this.jdField_a_of_type_Aiss);
    }
    int n = localairz.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1036)
      {
        m = 1;
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_g_of_type_Int != 7) && (m == 0)) {
          break label147;
        }
      }
    }
    label147:
    for (int m = 7;; m = n)
    {
      b(m);
      return;
      m = 0;
      break;
      m = 0;
      break;
    }
  }
  
  public void l()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localObject = (ajmw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1036) {
        break label137;
      }
      localObject = ((aena)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).b();
      this.jdField_a_of_type_Ajpn = new ajpn(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      this.jdField_a_of_type_Ajpn.a((List)localObject);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label145;
      }
      this.jdField_a_of_type_Ajpn.b(100);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new ApolloPanel.11(this));
      return;
      label137:
      localObject = ((ajmw)localObject).h();
      break;
      label145:
      this.jdField_a_of_type_Ajpn.b(8);
    }
  }
  
  public void m()
  {
    Object localObject1;
    List localList;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localObject1 = (ajmw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aena)) {
        break label114;
      }
      localList = ((aena)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).b();
      if ((localList != null) && (localList.size() > 0))
      {
        localObject1 = null;
        localObject2 = null;
        if (this.jdField_a_of_type_Ajpn == null) {
          break label123;
        }
        localObject2 = this.jdField_a_of_type_Ajpn;
      }
    }
    label114:
    label123:
    int n;
    int m;
    do
    {
      do
      {
        if (localObject2 != null) {
          ThreadManager.getUIHandler().post(new ApolloPanel.12(this, (ajpn)localObject2, localList));
        }
        return;
        localList = ((ajmw)localObject1).h();
        break;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      n = this.jdField_a_of_type_JavaUtilList.size();
      m = 0;
      localObject2 = localObject1;
    } while (m >= n);
    Object localObject2 = (ajrp)this.jdField_a_of_type_JavaUtilList.get(m);
    if ((localObject2 != null) && (((ajrp)localObject2).jdField_d_of_type_Int == 100) && ((localObject2 instanceof ajpn))) {
      localObject1 = (ajpn)localObject2;
    }
    for (;;)
    {
      m += 1;
      break;
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Bbgg != null)
    {
      this.jdField_a_of_type_Bbgg.dismiss();
      this.jdField_a_of_type_Bbgg = null;
    }
  }
  
  public void o()
  {
    int m;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      m = 0;
    }
    for (;;)
    {
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        ajrp localajrp = (ajrp)this.jdField_a_of_type_JavaUtilList.get(m);
        if ((localajrp.jdField_d_of_type_Int == 100) && ((localajrp instanceof ajpn))) {
          ((ajpn)localajrp).b();
        }
      }
      else
      {
        return;
      }
      m += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363584: 
    case 2131362641: 
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "click tab shop");
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
        paramView = (airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem != null))
        {
          paramView.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, "aio_shop");
          paramView.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
          ((avpq)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(String.valueOf("103100.103200.103250"));
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
          this.jdField_e_of_type_Boolean = false;
          w();
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_new_click", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id });
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_click", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), 0, new String[0]);
          return;
        }
        if (airz.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
        for (paramView = ajmu.ah;; paramView = ajmu.ai)
        {
          ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", paramView, null);
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clickslavenumber", 0, 0, new String[0]);
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", ajmu.ai, null, 14003);
      return;
    case 2131367938: 
      u();
      return;
    }
    q();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction() & 0xFF;
    if (m == 0) {
      super.getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "ApolloPanel event " + paramMotionEvent.toString(), " 是否拦截：", Boolean.valueOf(super.onInterceptTouchEvent(paramMotionEvent)) });
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((m == 1) || (m == 3)) {
        super.getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_d_of_type_Boolean = true;
    c(paramInt);
    this.jdField_d_of_type_Boolean = false;
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
    int i2 = b(paramInt);
    if ((this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt - 1))) || (this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) || (this.jdField_h_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "change tab index = " + paramInt);
      }
      setTabSelect(i2);
      a(paramInt);
      this.jdField_c_of_type_Int = 0;
    }
    int m;
    int n;
    label413:
    Object localObject2;
    if (paramInt < jdField_a_of_type_Int)
    {
      m = 1;
      jdField_a_of_type_Int = paramInt;
      e(paramInt);
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.onPageSelected(a(paramInt));
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "recent_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[0]);
      }
      n = b();
      if ((n != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null)) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "cmshow", "Apollo", "game_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int), 0, new String[] { Integer.toString(n) });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
        return;
      }
      int i1 = 0;
      n = i1;
      if (this.jdField_a_of_type_Ajrn != null)
      {
        localObject1 = this.jdField_a_of_type_Ajrn.a();
        n = i1;
        if (localObject1 != null)
        {
          n = i1;
          if (((List)localObject1).size() > 0)
          {
            n = i1;
            if (i2 >= 0)
            {
              n = i1;
              if (i2 < ((List)localObject1).size())
              {
                localObject1 = (ApolloActionPackage)((List)localObject1).get(i2);
                n = i1;
                if (localObject1 != null) {
                  n = ((ApolloActionPackage)localObject1).packageId;
                }
              }
            }
          }
        }
      }
      if (n != 6) {
        break label745;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      Object localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      i1 = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (m == 0) {
        break label757;
      }
      localObject2 = "0";
      label464:
      VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "slide", (String)localObject1, i1, n, new String[] { localObject2, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        return;
      }
      localObject2 = null;
      localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
      n = 0;
      label552:
      localObject1 = localObject2;
      if (((Iterator)localObject3).hasNext())
      {
        ajrp localajrp = (ajrp)((Iterator)localObject3).next();
        m = n;
        if (localajrp == null) {
          break label765;
        }
        m = n;
        if (!(localajrp instanceof ajrp)) {
          break label765;
        }
        i1 = localajrp.a();
        n += i1;
        m = n;
        if (paramInt + 1 > n) {
          break label765;
        }
        if (!(localajrp instanceof ajqg))
        {
          localObject1 = localObject2;
          if (!(localajrp instanceof ajpc)) {}
        }
        else
        {
          localObject1 = localajrp.a(i1 - (n - paramInt));
        }
      }
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        return;
      }
      localObject2 = new StringBuilder();
      m = ((ArrayList)localObject1).size();
      paramInt = 0;
      label679:
      if (paramInt >= m) {
        break label782;
      }
      localObject3 = (ajpz)((ArrayList)localObject1).get(paramInt);
      if (((ajpz)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) {
        break label770;
      }
      ((StringBuilder)localObject2).append(((ajpz)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
    }
    for (;;)
    {
      if (paramInt != m - 1) {
        ((StringBuilder)localObject2).append("-");
      }
      paramInt += 1;
      break label679;
      m = 0;
      break;
      label745:
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break label413;
      label757:
      localObject2 = "1";
      break label464;
      label765:
      n = m;
      break label552;
      label770:
      ((StringBuilder)localObject2).append("0");
    }
    label782:
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "actionexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { ((StringBuilder)localObject2).toString(), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramInt == 0) && (this.jdField_d_of_type_Int == 2) && (this.jdField_j_of_type_Int != -1) && (this.jdField_j_of_type_Int != paramInt)) {
      this.jdField_c_of_type_Ajrh.a();
    }
    this.jdField_j_of_type_Int = paramInt;
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView != null)) {
      y();
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
        do
        {
          return;
          if ((!aisl.jdField_a_of_type_Boolean) || (this.jdField_d_of_type_Int == 2) || (!b()))
          {
            y();
            return;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView != null);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "[showGuidePageFor3D]");
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView = ((ApolloPanelGuideView)LayoutInflater.from(super.getContext()).inflate(2131558604, null));
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setClickCallback(new ajqz(this));
        addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView, -1, -1);
        localObject2 = (ajmw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      } while (localObject2 == null);
      Object localObject1 = new ArrayList();
      Object localObject2 = ((ajmw)localObject2).d(400);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        int m = 0;
        while (m < ((List)localObject2).size())
        {
          ajoy localajoy = new ajoy(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          localajoy.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject2).get(m));
          ((List)localObject1).add(localajoy);
          m += 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setActions((List)localObject1);
      localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      ((TranslateAnimation)localObject1).setDuration(500L);
      ((TranslateAnimation)localObject1).setRepeatCount(0);
      ((TranslateAnimation)localObject1).setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.startAnimation((Animation)localObject1);
    } while (this.jdField_j_of_type_Boolean);
    this.jdField_j_of_type_Boolean = true;
    ((airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).m();
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ((bbqp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).d(4);
  }
  
  public void setTabSelect(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[setTabSelect] newIndex=", Integer.valueOf(paramInt), ", mLastTabIndex=", Integer.valueOf(this.jdField_i_of_type_Int) });
    }
    int m;
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(this.jdField_i_of_type_Int);
      if (localObject != null) {
        ((View)localObject).setSelected(false);
      }
      if ((this.jdField_i_of_type_Int == -1) || (this.jdField_i_of_type_Int != paramInt)) {
        u();
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt);
      m = this.jdField_i_of_type_Int;
      this.jdField_i_of_type_Int = paramInt;
      if (localObject == null) {
        break label417;
      }
      ((View)localObject).setSelected(true);
      this.jdField_a_of_type_Ajrn.a(paramInt);
      if ((!this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView == null) && (!this.jdField_a_of_type_Aism.a()) && (!this.jdField_a_of_type_Aism.b())) {
        a(paramInt, (View)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_Ajrn != null) && (this.jdField_a_of_type_Ajrn.a() != null) && (this.jdField_a_of_type_Ajrn.a().size() > paramInt) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        localObject = (ApolloActionPackage)this.jdField_a_of_type_Ajrn.a().get(paramInt);
        if ((((ApolloActionPackage)localObject).packageId == 100) && (m != paramInt)) {
          ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1);
        }
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        int n = ((ApolloActionPackage)localObject).packageId;
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (!((ApolloActionPackage)localObject).isUpdate) {
          break label412;
        }
        m = 1;
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_tab", str, n, 0, new String[] { m, "" + ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), "", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
    for (;;)
    {
      d(paramInt);
      return;
      label412:
      m = 0;
      break;
      label417:
      this.jdField_a_of_type_Ajrn.a(paramInt);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[setVisibility] visibility=", Integer.valueOf(paramInt) });
    }
    if (paramInt == 8)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      u();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 1, "[setVisibility] gone, set mShouldShowActionFloatView true");
      }
      this.jdField_g_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel
 * JD-Core Version:    0.7.0.1
 */
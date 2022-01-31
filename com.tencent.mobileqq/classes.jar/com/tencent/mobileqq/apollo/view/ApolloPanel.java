package com.tencent.mobileqq.apollo.view;

import aciy;
import aecb;
import aifc;
import aifg;
import aifr;
import aifs;
import aift;
import aify;
import aifz;
import aijx;
import aisi;
import aisl;
import aiys;
import aiyu;
import ajat;
import ajau;
import ajaw;
import ajba;
import ajbl;
import ajbx;
import ajbz;
import ajcd;
import ajce;
import ajch;
import ajci;
import ajcj;
import ajck;
import ajcl;
import ajcm;
import ajcn;
import ajco;
import ajcp;
import ajcq;
import ajcr;
import ajcs;
import ajct;
import ajcu;
import ajcv;
import ajcw;
import ajcx;
import ajcz;
import ajda;
import ajde;
import ajdf;
import ajdl;
import ajdm;
import ajdn;
import ajjy;
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
import apdh;
import auqh;
import babp;
import babr;
import bafb;
import baio;
import bajr;
import banq;
import baot;
import beez;
import bepn;
import bepo;
import bepp;
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
  implements ajau, Handler.Callback, ViewPager.OnPageChangeListener, View.OnClickListener, AdapterView.OnItemClickListener
{
  public static int a;
  private static final String jdField_a_of_type_JavaLangString = aiys.jdField_a_of_type_JavaLangString + "/cmshow.apk";
  private static final String jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + ".temp";
  private aifr jdField_a_of_type_Aifr = new ajcw(this);
  private aift jdField_a_of_type_Aift;
  private aify jdField_a_of_type_Aify;
  public aifz a;
  ajat jdField_a_of_type_Ajat = new ajch(this);
  ajbl jdField_a_of_type_Ajbl;
  public ajce a;
  private ajda jdField_a_of_type_Ajda;
  private ajdf jdField_a_of_type_Ajdf = new ajcu(this);
  ajdl jdField_a_of_type_Ajdl;
  public DialogInterface.OnClickListener a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  bafb jdField_a_of_type_Bafb = null;
  public bepn a;
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
  private Deque<ajde> jdField_a_of_type_JavaUtilDeque;
  public List<ajdn> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this, true);
  private volatile boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  private ajdf jdField_b_of_type_Ajdf = new ajcv(this);
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public LinearLayout b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 0;
  private ajdf jdField_c_of_type_Ajdf = this.jdField_a_of_type_Ajdf;
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
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ajcm(this);
    this.jdField_a_of_type_Aifz = new ajcn(this);
    this.jdField_d_of_type_Int = 1;
  }
  
  public ApolloPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ajcm(this);
    this.jdField_a_of_type_Aifz = new ajcn(this);
    this.jdField_d_of_type_Int = 1;
  }
  
  private int a(List<ajdn> paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt >= paramList.size())) {
      throw new IllegalArgumentException("packageBinderList is null or tabIndex is out");
    }
    int n = 0;
    int m = 0;
    if (n < paramInt)
    {
      ajdn localajdn = (ajdn)paramList.get(n);
      if (localajdn == null) {
        break label72;
      }
      m = localajdn.a() + m;
    }
    label72:
    for (;;)
    {
      n += 1;
      break;
      return m;
    }
  }
  
  private aijx a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return null;
    }
    aifc localaifc = (aifc)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(211);
    aijx localaijx = localaifc.a();
    if (localaijx.jdField_a_of_type_Int != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, new Object[] { "[checkJumpToGameTab] checkGameTab jumpGameId:", Integer.valueOf(localaijx.jdField_a_of_type_Int), ",from:", Integer.valueOf(localaijx.jdField_b_of_type_Int), ", mIsGettingUserInfo=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
      if (!this.jdField_a_of_type_Boolean) {
        localaifc.a(-1, -1);
      }
      return localaijx;
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
          localObject1 = localResources.getDrawable(2130837700);
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
            localDrawable = localResources.getDrawable(2130843059);
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
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = aciy.a(90.0F, localResources);
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
        if (this.jdField_a_of_type_Bepn != null)
        {
          if (this.jdField_a_of_type_JavaUtilDeque == null) {
            this.jdField_a_of_type_JavaUtilDeque = new LinkedList();
          }
          this.jdField_a_of_type_JavaUtilDeque.addLast(new ajde(paramView, paramInt1, paramString, paramInt2));
          return;
        }
        paramString = bepn.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).b(paramInt2).a(paramString).a(16.0F).a(-1);
        paramString.c(paramInt1);
        paramString = new bepp(paramString).b(Color.argb(255, 0, 0, 0)).a(5).a();
      } while (paramString == null);
      this.jdField_a_of_type_Bepn = paramString.a();
    } while (this.jdField_a_of_type_Bepn == null);
    this.jdField_a_of_type_Bepn.a(82);
    this.jdField_a_of_type_Bepn.c(2);
    this.jdField_a_of_type_Bepn.a(paramView);
    this.jdField_a_of_type_Bepn.setOnDismissListener(new ajcz(this));
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[realshowNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", extra=", paramBundle });
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(super.getContext()).inflate(2131493054, null));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setId(2131297095);
    ((ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131302318)).setOnClickListener(this);
    Object localObject2 = super.getResources();
    Object localObject1 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131302306);
    ajcd localajcd = new ajcd(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    localajcd.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramApolloActionData;
    ((ImageView)localObject1).setImageDrawable(a(paramApolloActionData));
    ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131312620)).setText(paramApolloActionData.actionName);
    ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131312619)).setText(paramApolloActionData.description);
    ((Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131298062)).setOnClickListener(new ajcp(this, paramApolloActionData));
    localObject1 = (Button)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131297906);
    int m = super.getHeight() - this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight();
    if (m < aciy.a(213.0F, (Resources)localObject2))
    {
      localObject3 = (LinearLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131299109);
      m = m - (int)((Resources)localObject2).getDimension(2131165336) - (int)((Resources)localObject2).getDimension(2131165337);
      ((RelativeLayout.LayoutParams)((LinearLayout)localObject3).getLayoutParams()).bottomMargin = ((int)(m * 0.1D));
      ((RelativeLayout.LayoutParams)((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131299104)).getLayoutParams()).bottomMargin = ((int)(m * 0.2D));
    }
    localObject2 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131302074);
    Object localObject3 = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131312642);
    switch (paramInt2)
    {
    default: 
      switch (paramInt1)
      {
      }
      break;
    }
    for (;;)
    {
      paramBundle = new RelativeLayout.LayoutParams(-1, -1);
      paramBundle.addRule(2, 2131297108);
      addView(this.jdField_d_of_type_AndroidWidgetRelativeLayout, paramBundle);
      paramBundle = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      paramBundle.setDuration(500L);
      paramBundle.setRepeatCount(0);
      paramBundle.setInterpolator(new AccelerateDecelerateInterpolator());
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.startAnimation(paramBundle);
      this.jdField_g_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_flame_view", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(paramApolloActionData.actionId) });
      }
      return;
      ((ImageView)localObject2).setVisibility(8);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(ajjy.a(2131634681));
      break;
      ((ImageView)localObject2).setVisibility(8);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(ajjy.a(2131634670));
      break;
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838371);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FFFF8444"));
      ((TextView)localObject3).setText(paramApolloActionData.extraWording);
      break;
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838372);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(ajjy.a(2131634672));
      localObject2 = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131312630);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(String.valueOf(paramApolloActionData.currencyNum));
      break;
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838373);
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(ajjy.a(2131634682));
      break;
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838398);
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(ajjy.a(2131634689));
      break;
      ((ImageView)localObject2).setVisibility(0);
      ((ImageView)localObject2).setImageResource(2130838398);
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setTextColor(Color.parseColor("#FF777777"));
      ((TextView)localObject3).setText(ajjy.a(2131634688));
      break;
      ((Button)localObject1).setText(ajjy.a(2131634676));
      ((Button)localObject1).setOnClickListener(new ajcq(this, localajcd, paramApolloActionData));
      continue;
      ((Button)localObject1).setText(ajjy.a(2131634686));
      ((Button)localObject1).setOnClickListener(new ajcr(this, paramBundle, paramApolloActionData));
      continue;
      ((Button)localObject1).setText(ajjy.a(2131634674));
      ((Button)localObject1).setOnClickListener(new ajcs(this, paramApolloActionData, paramBundle));
      continue;
      ((Button)localObject1).setText(ajjy.a(2131634675));
      ((Button)localObject1).setOnClickListener(new ajct(this, paramApolloActionData));
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloPanel.32(this, paramAppInfo, paramString));
  }
  
  private void a(List<ajdn> paramList, List<ApolloActionPackage> paramList1, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramList == null) || (paramList1 == null)) {
      return;
    }
    this.jdField_c_of_type_Ajdf.a(paramList, paramList1, paramBoolean);
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
      return aifg.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    this.jdField_a_of_type_Ajce = new ajce(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Ajce.b(paramInt2);
    this.jdField_a_of_type_Ajce.a(this);
    if (paramInt1 == 0) {
      this.jdField_a_of_type_Ajce.a(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func showApolloPanel begins. Thread id = " + Thread.currentThread().getId());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Ajce);
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
      Object localObject = (aiyu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      localApolloActionData = ((aiyu)localObject).a(paramInt1);
      if (localApolloActionData == null)
      {
        QLog.w("ApolloPanel", 1, "[showNewActionFloatView] no action info, abort");
        return;
      }
      boolean bool2 = ((aiyu)localObject).b(paramInt1);
      if ((((aiyu)localObject).c(paramInt1)) || (localApolloActionData.feeType == 1)) {}
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
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(new ajco(this, localApolloActionData));
        ((baot)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(localApolloActionData.actionId, null, null, 0, 0.0F, 0, "newActionFloatView");
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
        if (((aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
        {
          a(localApolloActionData, 0, 25, null);
          return;
        }
        if (bajr.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          a(localApolloActionData, 0, 26, null);
          return;
        }
        a(localApolloActionData, 3, 24, null);
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
    this.jdField_c_of_type_Ajdf.a(paramInt);
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
      this.jdField_c_of_type_Ajdf = this.jdField_b_of_type_Ajdf;
      return;
    }
    this.jdField_c_of_type_Ajdf = this.jdField_a_of_type_Ajdf;
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
    View localView = super.findViewById(2131297095);
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
      if (!this.jdField_a_of_type_Aift.b()) {
        break label45;
      }
      QLog.d("ApolloPanel", 2, "showGuidePageFor3D for json");
      this.jdField_i_of_type_Boolean = true;
      this.jdField_a_of_type_Aift.b(false);
      q();
    }
    label45:
    while (!this.jdField_a_of_type_Aift.a()) {
      return;
    }
    QLog.d("ApolloPanel", 2, "showGuidePageFor3D for action");
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_Aift.a(false);
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
        n += ((ajdn)this.jdField_a_of_type_JavaUtilList.get(m)).a();
        if (paramInt < n) {
          i1 = ((ajdn)this.jdField_a_of_type_JavaUtilList.get(m)).a() - (n - paramInt);
        }
      }
      else
      {
        return i1;
      }
      m += 1;
    }
  }
  
  public int a(BaseChatPie paramBaseChatPie, ajbx paramajbx, ApolloActionData paramApolloActionData)
  {
    int m;
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      m = 0;
      return m;
    }
    aiyu localaiyu = (aiyu)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    aifg localaifg = (aifg)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    boolean bool1 = localaiyu.b(paramApolloActionData.actionId);
    if ((paramApolloActionData.hasSound) || (paramajbx.jdField_e_of_type_Int > 0)) {
      m = 1;
    }
    for (;;)
    {
      if (localaiyu.c(paramApolloActionData.actionId))
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
        int n = m;
        if (paramApolloActionData.feeType == 6)
        {
          if (bool1)
          {
            n = 16;
            n = m | n;
          }
        }
        else
        {
          m = n;
          if (paramApolloActionData.feeType == 2)
          {
            if (!bool1) {
              break label281;
            }
            m = 4;
            label205:
            m = n | m;
          }
          n = m;
          if (paramApolloActionData.feeType != 9) {
            break label304;
          }
          boolean bool2 = localaifg.a(paramBaseChatPie.a().getCurrentAccountUin());
          boolean bool3 = bajr.b(paramBaseChatPie.a());
          if ((!bool2) && (!bool3)) {
            break label296;
          }
          if (!bool3) {
            break label289;
          }
        }
        label281:
        label289:
        for (n = 4096;; n = 32)
        {
          return m | n;
          n = 64;
          break;
          m = 128;
          break label205;
        }
        label296:
        n = m | 0x800;
        label304:
        m = n;
        if (paramApolloActionData.feeType != 7) {
          break;
        }
        if (bool1) {}
        for (m = 8;; m = 512) {
          return n | m;
        }
      }
      m = 0;
    }
  }
  
  public ajdn a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "getViewBinder type=" + paramInt);
    }
    return this.jdField_c_of_type_Ajdf.a(paramInt);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ((baot)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(1, "actionPanel");
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
      int n = ((ajdn)this.jdField_a_of_type_JavaUtilList.get(m)).a();
      if (((ajdn)this.jdField_a_of_type_JavaUtilList.get(m)).jdField_d_of_type_Int == 100) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(8);
      }
      do
      {
        return;
        if ((n <= 1) || (((ajdn)this.jdField_a_of_type_JavaUtilList.get(m)).jdField_d_of_type_Int == 100)) {
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
        ajdn localajdn = (ajdn)this.jdField_a_of_type_JavaUtilList.get(m);
        if ((localajdn.jdField_d_of_type_Int == 100) && ((localajdn instanceof ajbl)) && (((ajbl)localajdn).a != null) && (((ajbl)localajdn).a.gameId == paramInt2)) {
          ((ajbl)localajdn).a(paramInt1);
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
      if ((paramApolloPanel != null) && ((paramApolloPanel instanceof ajbl)))
      {
        paramApolloPanel = (ajbl)paramApolloPanel;
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
      paramApolloPanel = aisl.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    if ((this.jdField_a_of_type_Ajdl != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = this.jdField_a_of_type_Ajdl.a();
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
          ((ajdm)paramView.getTag()).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
  
  public void a(ajbx paramajbx)
  {
    int i1 = 0;
    if ((paramajbx == null) || (paramajbx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null)) {}
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
        Object localObject1 = (ajdn)this.jdField_a_of_type_JavaUtilList.get(m);
        if (((ajdn)localObject1).jdField_a_of_type_JavaUtilList == null) {}
        while (((ajdn)localObject1).jdField_d_of_type_Int != 2)
        {
          m += 1;
          break;
        }
        Object localObject2;
        if (((ajdn)localObject1).jdField_c_of_type_Int != 5)
        {
          ((ajdn)localObject1).b(5);
          localObject2 = new ajbx();
          ((ajbx)localObject2).jdField_b_of_type_Int = 2;
          ApolloActionData localApolloActionData = new ApolloActionData();
          localApolloActionData.actionName = super.getResources().getString(2131624513);
          ((ajbx)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
          ((ajdn)localObject1).jdField_a_of_type_JavaUtilList.add(0, localObject2);
        }
        localObject1 = ((ajdn)localObject1).jdField_a_of_type_JavaUtilList;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
        {
          localObject2 = (aiyu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          paramajbx.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramajbx, paramajbx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
        }
        ((List)localObject1).add(1, paramajbx);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "add action to fav action " + paramajbx.toString());
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
    paramBaseChatPie = (aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (paramBaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "[initPanel] apollo status open, remember jump info");
      }
      this.jdField_f_of_type_Int = paramInt1;
      this.jdField_e_of_type_Int = paramInt2;
    }
    this.jdField_g_of_type_Int = paramInt3;
    paramBaseChatPie.a(this.jdField_a_of_type_Aifr);
    this.jdField_a_of_type_Aift = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)super.findViewById(2131297431));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)super.findViewById(2131297417));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131298034));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131299106));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131299105));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131298011));
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)super.findViewById(2131297915));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_c_of_type_ComTencentImageURLImageView.getParent());
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131298005));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297061));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)super.findViewById(2131297107));
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    Drawable localDrawable = super.getContext().getResources().getDrawable(2130838413);
    paramSessionInfo.addState(new int[] { 16842919 }, localDrawable);
    paramSessionInfo = this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    localDrawable = super.getContext().getResources().getDrawable(2130838412);
    paramSessionInfo.addState(new int[] { -16842919 }, localDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131297108));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter = new ApolloPanelAdapter(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131310979));
    this.jdField_a_of_type_Ajdl = new ajdl(super.getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Ajdl);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    super.findViewById(2131310975).setBackgroundColor(super.getContext().getResources().getColor(2131099964));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131303838));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297103));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297102));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297101));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297052));
    this.jdField_a_of_type_Aify = paramBaseChatPie.a();
    if (this.jdField_a_of_type_Aify != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_Aify.a.get()));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(super.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout).a(5).a();
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = ((auqh)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf("103100.103200.103250"));
      paramBaseChatPie = (WebProcessManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
      if (paramBaseChatPie != null) {
        paramBaseChatPie.a(100);
      }
      paramBaseChatPie = BaseApplicationImpl.getContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if ((paramBaseChatPie.getBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)) && (this.jdField_g_of_type_Int != 7))
      {
        paramBaseChatPie.edit().putBoolean("chat_tool_apollo_" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false).commit();
        paramBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.obtainMessage(51).sendToTarget();
        }
      }
      if (aifg.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "[initPanel] getUserApolloInfo");
        }
        this.jdField_a_of_type_Boolean = true;
        ((baot)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 8650880, "Open Panel");
        aifg.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_Aify != null) {
        this.jdField_a_of_type_Aify.a(null);
      }
      paramBaseChatPie = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      if ((paramBaseChatPie == null) || (!paramBaseChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_JavaLangString))) {
        break label1100;
      }
    }
    label1100:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.getLayoutParams()).bottomMargin = ((int)(10.0F * super.getResources().getDisplayMetrics().density));
      setBackgroundColor(super.getResources().getColor(2131099966));
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
        ajbz localajbz;
        ajbx localajbx;
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
          localajbz = (ajbz)localLinearLayout.getChildAt(i1).getTag();
          if (localajbz != null)
          {
            localajbx = localajbz.a;
            if ((localajbx != null) && (localajbx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localajbx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramApolloActionData.actionId))
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).post(new ApolloPanel.20(this, localajbz));
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
      } while (this.jdField_a_of_type_Bafb != null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "showAidDialog title=" + paramString2 + " content=" + paramString3 + "rightString=" + paramString4 + " url=" + paramString5);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
    n();
    int m;
    if ("onlyRightType".equals(paramString5))
    {
      m = 1;
      paramString1 = new ajci(this);
      label137:
      paramString6 = super.getResources().getString(2131629669);
      if (m == 0) {
        break label293;
      }
    }
    label293:
    for (paramString5 = null;; paramString5 = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener)
    {
      this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, paramString2, paramString3, paramString6, paramString4, paramString1, paramString5);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing())) {
        break;
      }
      this.jdField_a_of_type_Bafb.show();
      return;
      if ("moreInfo".equals(paramString5))
      {
        paramString1 = new ajcj(this, paramString7);
        m = 0;
        break label137;
      }
      if ("requestSSO".equals(paramString5))
      {
        paramString1 = new ajck(this, paramString1, paramString7, paramString8);
        m = 0;
        break label137;
      }
      paramString1 = new ajcl(this, paramString5, paramString6, paramString7, paramString1);
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
    aiyu localaiyu;
    List localList;
    do
    {
      do
      {
        return;
        new ArrayList();
        localArrayList1 = new ArrayList();
        localaiyu = (aiyu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      } while (localaiyu == null);
      localList = localaiyu.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
        break label2248;
      }
      if (localApolloActionPackage.packageId != 4) {}
    }
    label548:
    label820:
    label1333:
    label1592:
    label2238:
    label2241:
    label2248:
    for (;;)
    {
      i3 += 1;
      break label164;
      if (this.jdField_c_of_type_Ajdf.a(localApolloActionPackage.packageId))
      {
        String str = babp.c();
        if ((!TextUtils.isEmpty(localApolloActionPackage.startVersion)) && (!TextUtils.isEmpty(localApolloActionPackage.endVersion)) && ((!banq.a(localApolloActionPackage.startVersion, str)) || (!banq.a(str, localApolloActionPackage.endVersion))))
        {
          QLog.w("ApolloPanel", 1, "version not correct packageId=" + localApolloActionPackage.packageId);
        }
        else
        {
          long l1 = System.currentTimeMillis();
          ajdn localajdn = a(localApolloActionPackage.type);
          if (localajdn != null)
          {
            localajdn.jdField_e_of_type_Int = localApolloActionPackage.packageId;
            Object localObject3 = null;
            ArrayList localArrayList3 = new ArrayList();
            Object localObject1;
            Object localObject2;
            Object localObject4;
            int i1;
            label485:
            long l2;
            label510:
            ApolloActionData localApolloActionData;
            if (localApolloActionPackage.type == 2)
            {
              localObject1 = localaiyu.a();
              localObject2 = (List)((Pair)localObject1).first;
              localObject3 = (List)((Pair)localObject1).second;
              if ((localObject2 != null) && (((List)localObject2).size() > 0))
              {
                localajdn.b(5);
                localObject1 = new ajbx();
                ((ajbx)localObject1).jdField_b_of_type_Int = 2;
                localObject4 = new ApolloActionData();
                ((ApolloActionData)localObject4).actionName = super.getResources().getString(2131624513);
                ((ajbx)localObject1).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)localObject4);
                localArrayList3.add(localObject1);
                localObject1 = null;
                i1 = m;
                l2 = System.currentTimeMillis();
                localObject4 = new StringBuilder();
                if (localObject3 == null) {
                  break label2241;
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
              localajdn.b(4);
              break;
              if (localApolloActionPackage.type == 100)
              {
                localObject1 = localaiyu.h();
                if ((localObject1 != null) && (((List)localObject1).size() > 0))
                {
                  i1 = m;
                  if ((localajdn instanceof ajbl))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloPanel", 2, new Object[] { "set panel game list, size=", Integer.valueOf(((List)localObject1).size()) });
                    }
                    ((ajbl)localajdn).a((List)localObject1);
                    localajdn.b(100);
                    i1 = m + localajdn.a();
                    localArrayList2.add(localajdn);
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
              localObject3 = localaiyu.d(localApolloActionPackage.packageId);
              localObject1 = localaiyu.e(localApolloActionPackage.packageId);
              localajdn.b(0);
              if (localApolloActionPackage.packageId == 6)
              {
                localajdn.b(9);
                localaiyu.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (List)localObject3);
                localObject2 = null;
                i1 = m;
                break label485;
              }
              if (localApolloActionPackage.packageId == 7) {
                localaiyu.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (List)localObject3);
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
            ajbx localajbx = localajdn.a(paramString);
            localajbx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
            localajbx.jdField_a_of_type_Int = localApolloActionPackage.packageId;
            if (localApolloActionPackage.type == 2) {
              if ((localObject2 != null) && (((List)localObject2).size() > n))
              {
                localajbx.jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject2).get(n)).text;
                localajbx.jdField_d_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(n)).textType;
                localajbx.jdField_e_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(n)).audioId;
                localajbx.jdField_a_of_type_Float = ((ApolloFavActionData)((List)localObject2).get(n)).audioStartTime;
                localajbx.jdField_f_of_type_Int = ((ApolloFavActionData)((List)localObject2).get(n)).playOriginalAudio;
              }
            }
            for (localajbx.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localajbx, localajbx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData);; localajbx.jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localajbx, localajbx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData))
            {
              do
              {
                localArrayList3.add(localajbx);
                if ((m != -1) || (this.jdField_e_of_type_Int != localApolloActionData.actionId)) {
                  break label2238;
                }
                if (this.jdField_f_of_type_Int == -1)
                {
                  this.jdField_f_of_type_Int = localApolloActionPackage.packageId;
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] jump action match but no jump pkg, use ", Integer.valueOf(this.jdField_f_of_type_Int) });
                  }
                }
                if (this.jdField_f_of_type_Int != localApolloActionPackage.packageId) {
                  break label2238;
                }
                m = localArrayList3.size() - 1;
                break;
              } while ((localObject1 == null) || (((List)localObject1).size() <= n));
              localajbx.jdField_b_of_type_JavaLangString = ((ApolloActionPackageData)((List)localObject1).get(n)).text;
              localajbx.jdField_d_of_type_Int = ((ApolloActionPackageData)((List)localObject1).get(n)).textType;
            }
            if (0 != 0) {
              throw new NullPointerException();
            }
            int i2 = i1;
            n = m;
            if (localArrayList3.size() > 0)
            {
              localajdn.c_(localArrayList3);
              if (this.jdField_f_of_type_Int == localApolloActionPackage.packageId)
              {
                if (m == -1) {
                  break label1584;
                }
                localajdn.c(m);
                jdField_a_of_type_Int = localajdn.a(m) + i1;
                label1404:
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloPanel", 2, new Object[] { "[initPanelData] init sCurrentIndex with jump info, sCurrentIndex=", Integer.valueOf(jdField_a_of_type_Int), ", jumpActionIndex=", Integer.valueOf(m) });
                }
              }
              localArrayList2.add(localajdn);
              localArrayList1.add(localList.get(i3));
              i2 = i1 + localajdn.a();
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
                QLog.d("ApolloPanel", 2, new Object[] { "Tab add package:", Integer.valueOf(m), ",actionPackageDatas size:", localObject1, ",findTime:", Long.valueOf(l2 - l1), ",remove actions ", ((StringBuilder)localObject4).toString() });
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
                  ((aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(1);
                }
              }
              while ((localArrayList2 != null) && (localArrayList2.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
                l1 = NetConnInfoCenter.getServerTime();
                l2 = ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                localObject3 = new ArrayList();
                localObject1 = localArrayList1.iterator();
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
                  if ((paramString.isUpdate) && (paramString.packageId == 100) && (l1 - l2 > 604800000L))
                  {
                    paramString.isUpdate = false;
                    ((List)localObject3).add(paramString);
                  }
                }
                if (!this.jdField_a_of_type_Boolean)
                {
                  this.jdField_f_of_type_Int = -1;
                  this.jdField_e_of_type_Int = -1;
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
              this.jdField_c_of_type_Ajdf.a();
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
              if (this.jdField_a_of_type_Ajce != null) {
                this.jdField_a_of_type_Ajce.c();
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
      ((aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(false, "panel open apollo", 1);
    } while (this.jdField_a_of_type_Ajce == null);
    this.jdField_a_of_type_Ajce.b(0);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, false);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Ajdl != null)
    {
      Object localObject = this.jdField_a_of_type_Ajdl.a();
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
    if ((this.jdField_a_of_type_JavaUtilList.size() > jdField_a_of_type_Int) && ((this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int) instanceof ajbl)))
    {
      ApolloGameData localApolloGameData = ((ajbl)this.jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_Int)).b();
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
        n += ((ajdn)this.jdField_a_of_type_JavaUtilList.get(m)).a();
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
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, "aio", aiys.ah, null);
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
        if (!apdh.a(ApolloUtil.jdField_a_of_type_JavaLangString))
        {
          c(paramInt, 3);
          ((aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a(this.jdField_a_of_type_Ajat);
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
    aifg localaifg = (aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (localaifg.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) != 1)
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
    if ((localObject != null) && (((aijx)localObject).jdField_a_of_type_Int > 0) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      m = 0;
      label182:
      if (m >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label1260;
      }
      if (!(this.jdField_a_of_type_JavaUtilList.get(m) instanceof ajbl)) {}
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
        QLog.d("ApolloPanel", 2, "[jumpToPkgOrAction] checkGameTab jumpGameId:" + ((aijx)localObject).jdField_a_of_type_Int + ",gameTabIndex:" + m);
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
      ajbx localajbx;
      if ((i5 < i6) && (m == -1))
      {
        localObject = (ajdn)this.jdField_a_of_type_JavaUtilList.get(i5);
        if (localObject == null) {
          break label1253;
        }
        if ((paramInt1 != -1) && (((ajdn)localObject).jdField_e_of_type_Int == paramInt1))
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
            localaifg.a(1);
            return;
          }
          n = i2;
          i3 = m;
          if (!(localObject instanceof ajbl))
          {
            localList = ((ajdn)localObject).jdField_a_of_type_JavaUtilList;
            if ((localList == null) || (localList.size() <= 0)) {
              break label966;
            }
            n = 0;
            i3 = localList.size();
            if (n >= i3) {
              break label1244;
            }
            localajbx = (ajbx)localList.get(n);
            if ((localajbx != null) && (localajbx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localajbx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramInt2))
            {
              ((ajdn)localObject).c(n);
              m = ((ajdn)localObject).a(n) + i1;
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
            i1 = ((ajdn)localObject).a() + i1;
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
        if ((localObject instanceof ajbl)) {
          break label923;
        }
        localList = ((ajdn)localObject).jdField_a_of_type_JavaUtilList;
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
            localajbx = (ajbx)localList.get(i4);
            if ((localajbx != null) && (localajbx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localajbx.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramInt2))
            {
              if (paramInt1 != -1)
              {
                n = i2;
                i3 = m;
                if (paramInt1 != ((ajdn)localObject).jdField_e_of_type_Int) {
                  break;
                }
              }
              ((ajdn)localObject).c(i4);
              i3 = i1 + ((ajdn)localObject).a(i4);
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
  
  public void b(List<ajdn> paramList)
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
      aifg localaifg = (aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if (localaifg != null)
      {
        localaifg.a(this.jdField_a_of_type_Ajat);
        int m = 0;
        if (!apdh.a(ApolloUtil.jdField_a_of_type_JavaLangString)) {
          m = 1;
        }
        localaifg.a(m);
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
        n += ((ajdn)this.jdField_a_of_type_JavaUtilList.get(m)).a();
        m += 1;
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(n, false);
          a(n);
          Object localObject = this.jdField_a_of_type_Ajdl.a();
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
            bajr.a(null, "cmshow", "Apollo", "clciktabreddot", paramInt, 0, new String[] { String.valueOf(((ApolloActionPackage)localObject).packageId) });
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
    int m = ((aifg)localQQAppInterface.getManager(153)).b(localQQAppInterface.c());
    String str = localSessionInfo.jdField_a_of_type_JavaLangString;
    if (m == 0) {}
    for (m = 0;; m = 1)
    {
      bajr.a(localQQAppInterface, "cmshow", "Apollo", "state_open_clk", str, m, 0, new String[] { String.valueOf(ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int)), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] index=", Integer.valueOf(paramInt) });
    }
    if (this.jdField_a_of_type_Ajdl == null) {}
    int m;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_Ajdl.a();
      } while ((localObject == null) || (((List)localObject).size() <= paramInt));
      localObject = (ApolloActionPackage)((List)localObject).get(paramInt);
      paramInt = ((ApolloActionPackage)localObject).packageId;
      m = ((ApolloActionPackage)localObject).type;
    } while ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject = (aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    if (m == 2) {
      ((aifg)localObject).a(paramInt, true);
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloPanel", 2, new Object[] { "[checkPackageDownload] packageId=", Integer.valueOf(paramInt) });
      return;
      if ((m != 100) && (((aifg)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 1)) {
        ((aifg)localObject).a(paramInt, false);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      baio.a("apollo_panel_open", null);
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
    if ((paramInt != 0) && (this.jdField_a_of_type_Bepn != null) && (this.jdField_a_of_type_Bepn.isShowing())) {
      this.jdField_a_of_type_Bepn.dismiss();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_Ajdl != null))
    {
      m = b(jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_Ajdl.a();
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
      bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "tabexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), m, new String[] { "", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
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
        ajdn localajdn = (ajdn)this.jdField_a_of_type_JavaUtilList.get(n);
        if (localajdn.jdField_d_of_type_Int == 2)
        {
          List localList = localajdn.jdField_a_of_type_JavaUtilList;
          if ((localList == null) || (localList.size() == 0))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ApolloPanel", 2, "no fav action yet");
            return;
          }
          Object localObject1 = (aiyu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          if (localObject1 == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("ApolloPanel", 2, "apolloDaoManager null");
            return;
          }
          localList.clear();
          Object localObject2 = ((aiyu)localObject1).a();
          localObject1 = (List)((Pair)localObject2).first;
          localObject2 = (List)((Pair)localObject2).second;
          Object localObject3 = (aiyu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localajdn.b(5);
            localObject3 = new ajbx();
            ((ajbx)localObject3).jdField_b_of_type_Int = 2;
            ApolloActionData localApolloActionData = new ApolloActionData();
            localApolloActionData.actionName = super.getResources().getString(2131624513);
            ((ajbx)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = localApolloActionData;
            localList.add(localObject3);
          }
          for (;;)
          {
            i1 = m;
            if (i2 >= ((List)localObject2).size()) {
              break;
            }
            localObject3 = localajdn.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
            ((ajbx)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject2).get(i2));
            ((ajbx)localObject3).jdField_a_of_type_Int = localajdn.jdField_e_of_type_Int;
            if ((localObject1 != null) && (((List)localObject1).size() > n))
            {
              ((ajbx)localObject3).jdField_b_of_type_JavaLangString = ((ApolloFavActionData)((List)localObject1).get(i2)).text;
              ((ajbx)localObject3).jdField_d_of_type_Int = ((ApolloFavActionData)((List)localObject1).get(i2)).textType;
              ((ajbx)localObject3).jdField_g_of_type_Int = a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (ajbx)localObject3, ((ajbx)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
            }
            localList.add(localObject3);
            i2 += 1;
            continue;
            localajdn.b(4);
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
        ((ajdn)this.jdField_a_of_type_JavaUtilList.get(m)).a();
        m += 1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      aifg localaifg = (aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      if (localaifg != null)
      {
        localaifg.b(this.jdField_a_of_type_Ajat);
        localaifg.c();
        if (this.jdField_a_of_type_Aify != null) {
          this.jdField_a_of_type_Aify.a();
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
    this.jdField_a_of_type_Ajce = null;
    this.jdField_a_of_type_Ajat = null;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_Ajda != null) {
      this.jdField_a_of_type_Ajda.b();
    }
    this.jdField_a_of_type_Bepn = null;
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
    ((aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
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
      if (this.jdField_a_of_type_Ajdl != null)
      {
        List localList = this.jdField_a_of_type_Ajdl.a();
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
    aifg localaifg = (aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    localaifg.a(this.jdField_a_of_type_Ajat);
    if (this.jdField_a_of_type_Aify != null) {
      this.jdField_a_of_type_Aify.a(this.jdField_a_of_type_Aifz);
    }
    int n = localaifg.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
      localObject = (aiyu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1036) {
        break label137;
      }
      localObject = ((aecb)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).b();
      this.jdField_a_of_type_Ajbl = new ajbl(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      this.jdField_a_of_type_Ajbl.a((List)localObject);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label145;
      }
      this.jdField_a_of_type_Ajbl.b(100);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new ApolloPanel.11(this));
      return;
      label137:
      localObject = ((aiyu)localObject).h();
      break;
      label145:
      this.jdField_a_of_type_Ajbl.b(8);
    }
  }
  
  public void m()
  {
    Object localObject1;
    List localList;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localObject1 = (aiyu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      if (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aecb)) {
        break label114;
      }
      localList = ((aecb)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).b();
      if ((localList != null) && (localList.size() > 0))
      {
        localObject1 = null;
        localObject2 = null;
        if (this.jdField_a_of_type_Ajbl == null) {
          break label123;
        }
        localObject2 = this.jdField_a_of_type_Ajbl;
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
          ThreadManager.getUIHandler().post(new ApolloPanel.12(this, (ajbl)localObject2, localList));
        }
        return;
        localList = ((aiyu)localObject1).h();
        break;
      } while (this.jdField_a_of_type_JavaUtilList == null);
      n = this.jdField_a_of_type_JavaUtilList.size();
      m = 0;
      localObject2 = localObject1;
    } while (m >= n);
    Object localObject2 = (ajdn)this.jdField_a_of_type_JavaUtilList.get(m);
    if ((localObject2 != null) && (((ajdn)localObject2).jdField_d_of_type_Int == 100) && ((localObject2 instanceof ajbl))) {
      localObject1 = (ajbl)localObject2;
    }
    for (;;)
    {
      m += 1;
      break;
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_Bafb != null)
    {
      this.jdField_a_of_type_Bafb.dismiss();
      this.jdField_a_of_type_Bafb = null;
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
        ajdn localajdn = (ajdn)this.jdField_a_of_type_JavaUtilList.get(m);
        if ((localajdn.jdField_d_of_type_Int == 100) && ((localajdn instanceof ajbl))) {
          ((ajbl)localajdn).b();
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
    case 2131298034: 
    case 2131297102: 
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPanel", 2, "click tab shop");
          }
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
        paramView = (aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem != null))
        {
          paramView.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, "aio_shop");
          paramView.a(this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem);
          ((auqh)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(String.valueOf("103100.103200.103250"));
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
          this.jdField_e_of_type_Boolean = false;
          w();
          bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_new_click", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDrawerPushItem.msg_id });
          bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "house_click", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b()), 0, new String[0]);
          return;
        }
        if (aifg.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
        for (paramView = aiys.ah;; paramView = aiys.ai)
        {
          ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", paramView, null);
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
      bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "clickslavenumber", 0, 0, new String[0]);
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", aiys.ai, null, 14003);
      return;
    case 2131302318: 
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
        bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "recent_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[0]);
      }
      n = b();
      if ((n != -1) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null)) {
        bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "cmshow", "Apollo", "game_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int), 0, new String[] { Integer.toString(n) });
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
        return;
      }
      int i1 = 0;
      n = i1;
      if (this.jdField_a_of_type_Ajdl != null)
      {
        localObject1 = this.jdField_a_of_type_Ajdl.a();
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
      bajr.a((AppInterface)localObject3, "cmshow", "Apollo", "slide", (String)localObject1, i1, n, new String[] { localObject2, "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
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
        ajdn localajdn = (ajdn)((Iterator)localObject3).next();
        m = n;
        if (localajdn == null) {
          break label765;
        }
        m = n;
        if (!(localajdn instanceof ajdn)) {
          break label765;
        }
        i1 = localajdn.a();
        n += i1;
        m = n;
        if (paramInt + 1 > n) {
          break label765;
        }
        if (!(localajdn instanceof ajce))
        {
          localObject1 = localObject2;
          if (!(localajdn instanceof ajba)) {}
        }
        else
        {
          localObject1 = localajdn.a(i1 - (n - paramInt));
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
      localObject3 = (ajbx)((ArrayList)localObject1).get(paramInt);
      if (((ajbx)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) {
        break label770;
      }
      ((StringBuilder)localObject2).append(((ajbx)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
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
    bajr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "actionexposure", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { ((StringBuilder)localObject2).toString(), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if ((paramInt == 0) && (this.jdField_d_of_type_Int == 2) && (this.jdField_j_of_type_Int != -1) && (this.jdField_j_of_type_Int != paramInt)) {
      this.jdField_c_of_type_Ajdf.a();
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
          if ((!aifs.jdField_a_of_type_Boolean) || (this.jdField_d_of_type_Int == 2) || (!b()))
          {
            y();
            return;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView != null);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "[showGuidePageFor3D]");
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView = ((ApolloPanelGuideView)LayoutInflater.from(super.getContext()).inflate(2131493052, null));
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setSessionInfo(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView.setClickCallback(new ajcx(this));
        addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView, -1, -1);
        localObject2 = (aiyu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      } while (localObject2 == null);
      Object localObject1 = new ArrayList();
      Object localObject2 = ((aiyu)localObject2).d(400);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        int m = 0;
        while (m < ((List)localObject2).size())
        {
          ajaw localajaw = new ajaw(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          localajaw.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = ((ApolloActionData)((List)localObject2).get(m));
          ((List)localObject1).add(localajaw);
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
    ((aifg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).m();
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ((baot)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).d(4);
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
      this.jdField_a_of_type_Ajdl.a(paramInt);
      if ((!this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView == null) && (!this.jdField_a_of_type_Aift.a()) && (!this.jdField_a_of_type_Aift.b())) {
        a(paramInt, (View)localObject);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_Ajdl != null) && (this.jdField_a_of_type_Ajdl.a() != null) && (this.jdField_a_of_type_Ajdl.a().size() > paramInt) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        localObject = (ApolloActionPackage)this.jdField_a_of_type_Ajdl.a().get(paramInt);
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
        bajr.a(localQQAppInterface, "cmshow", "Apollo", "clk_tab", str, n, 0, new String[] { m, "" + ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), "", String.valueOf(System.currentTimeMillis() / 1000L) });
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
      this.jdField_a_of_type_Ajdl.a(paramInt);
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
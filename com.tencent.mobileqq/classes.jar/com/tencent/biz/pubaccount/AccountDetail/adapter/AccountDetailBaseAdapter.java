package com.tencent.biz.pubaccount.accountdetail.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.pubaccount.PublicAccountMenuBar;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.accountdetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.accountdetail.bean.MsgAttr;
import com.tencent.biz.pubaccount.accountdetail.bean.PictureAttr;
import com.tencent.biz.pubaccount.accountdetail.bean.VideoAttr;
import com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler;
import com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager;
import com.tencent.biz.pubaccount.accountdetail.model.AccountDetailVideoManager.OnVideoPlayListener;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailBannerViewWrapper;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailJigsawViewWrapper;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailWindowViewWrapper;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.impl.PublicAccountConfigAttrImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class AccountDetailBaseAdapter
  extends BaseAdapter
  implements View.OnClickListener, AccountDetailVideoManager.OnVideoPlayListener
{
  private static int r = 10;
  private static int s = 20;
  float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 0L;
  protected AnimatorSet a;
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  protected TranslateAnimation a;
  public Button a;
  public ImageView a;
  AccountDetailBaseAdapter.FullScreenTopContainerHolder jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder = null;
  private AccountDetailBaseAdapter.PrefetchListener jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$PrefetchListener;
  PublicAccountDetailImpl jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
  AccountDetailBaseItemClickHandler jdField_a_of_type_ComTencentBizPubaccountAccountdetailHandlerAccountDetailBaseItemClickHandler;
  AccountDetailVideoManager jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager;
  AccountDetailGroupListContainer jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer;
  private AccountDetailTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailTopGestureLayout;
  AccountDetailXListView jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView;
  private URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new AccountDetailBaseAdapter.13(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  EqqDetail jdField_a_of_type_ComTencentMobileqqDataEqqDetail;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new AccountDetailBaseAdapter.6(this);
  String jdField_a_of_type_JavaLangString;
  private ArrayList<DynamicInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int = 0;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  protected TranslateAnimation b;
  public Button b;
  public ImageView b;
  String jdField_b_of_type_JavaLangString;
  private ArrayList<DynamicInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  final int jdField_c_of_type_Int = 1;
  Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  public ImageView c;
  private ArrayList<IPublicAccountConfigAttr> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_c_of_type_Boolean = false;
  final int jdField_d_of_type_Int = 2;
  private ArrayList<IPublicAccountConfigAttr> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  public boolean d;
  final int jdField_e_of_type_Int = 3;
  boolean jdField_e_of_type_Boolean = false;
  final int jdField_f_of_type_Int = 4;
  boolean jdField_f_of_type_Boolean = false;
  final int jdField_g_of_type_Int = 5;
  boolean jdField_g_of_type_Boolean = false;
  final int jdField_h_of_type_Int = 6;
  private boolean jdField_h_of_type_Boolean = true;
  final int jdField_i_of_type_Int = 7;
  private boolean jdField_i_of_type_Boolean = true;
  final int jdField_j_of_type_Int = 8;
  private boolean jdField_j_of_type_Boolean = false;
  final int k = 9;
  final int l = 10;
  final int m = 11;
  final int n = 13;
  int o;
  int p = 0;
  int q = 0;
  private int t = PublicAccountDetailActivityImpl.NETWORK_UNKNOW;
  private int u = 1;
  
  public AccountDetailBaseAdapter(QQAppInterface paramQQAppInterface, Context paramContext, PublicAccountDetailImpl paramPublicAccountDetailImpl, String paramString, boolean paramBoolean, AccountDetailXListView paramAccountDetailXListView, AccountDetailTopGestureLayout paramAccountDetailTopGestureLayout)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl = paramPublicAccountDetailImpl;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl != null) {
      this.u = PublicAccountDetailImpl.getReportAccountType(paramQQAppInterface, paramString, paramPublicAccountDetailImpl);
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentUin();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView = paramAccountDetailXListView;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.getResources().getDisplayMetrics().density;
    this.q = ((PublicAccountDetailActivityImpl)this.jdField_a_of_type_AndroidAppActivity).getAccurateScreenDpi()[1];
    this.o = ((PublicAccountDetailActivityImpl)this.jdField_a_of_type_AndroidAppActivity).getAccurateScreenDpi()[0];
    b();
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailHandlerAccountDetailBaseItemClickHandler = new AccountDetailBaseItemClickHandler(paramQQAppInterface, paramContext, paramPublicAccountDetailImpl);
      paramQQAppInterface = (AccountDetailDynamicInfo)((IPublicAccountDetailDynamicDataManagerService)paramQQAppInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getAccountDetailDynamicInfoFromCache(paramString);
      if (paramQQAppInterface != null)
      {
        a(paramQQAppInterface.a(), paramQQAppInterface.jdField_a_of_type_Boolean);
        a(paramQQAppInterface.b());
      }
      paramQQAppInterface = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.cardStyle == 1))
      {
        this.jdField_b_of_type_Boolean = true;
        n();
      }
      m();
      this.jdField_d_of_type_Boolean = a();
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.a(this.jdField_d_of_type_Boolean ^ true);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailTopGestureLayout = paramAccountDetailTopGestureLayout;
  }
  
  public AccountDetailBaseAdapter(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, AccountDetailXListView paramAccountDetailXListView, ImageView paramImageView1, ImageView paramImageView2, RelativeLayout paramRelativeLayout, ImageView paramImageView3, AccountDetailTopGestureLayout paramAccountDetailTopGestureLayout)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView = paramAccountDetailXListView;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView1;
    this.jdField_b_of_type_AndroidWidgetImageView = paramImageView2;
    this.jdField_a_of_type_AndroidViewView = paramRelativeLayout;
    this.jdField_c_of_type_AndroidWidgetImageView = paramImageView3;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.getResources().getDisplayMetrics().density;
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailTopGestureLayout = paramAccountDetailTopGestureLayout;
  }
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preloadImg start:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" count:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("AccountDetailBaseAdapter", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = System.currentTimeMillis();
    if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)) {
      return;
    }
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    ThreadManager.post(new AccountDetailBaseAdapter.14(this, this.jdField_a_of_type_Long, (List)localObject, paramInt1, paramInt2, l1), 5, null, true);
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "runShowAnimation");
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView1.setAlpha(0.0F);
      paramView1.setVisibility(0);
      paramView2.setAlpha(0.0F);
      paramView2.setVisibility(0);
      paramView1 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView1.setDuration(1800L);
      paramView1.setRepeatCount(-1);
      paramView1.setRepeatMode(1);
      paramView1.setStartDelay(paramLong1);
      paramView2.setDuration(1800L);
      paramView2.setRepeatCount(-1);
      paramView2.setRepeatMode(1);
      paramView2.setStartDelay(paramLong2);
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { paramView1, paramView2 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
      return;
    }
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
  }
  
  protected static boolean a(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    boolean bool = false;
    if (paramPublicAccountDetailImpl == null) {
      return false;
    }
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType(paramPublicAccountDetailImpl.accountFlag) == -2) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(IPublicAccountConfigAttr paramIPublicAccountConfigAttr)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramIPublicAccountConfigAttr != null) && (paramIPublicAccountConfigAttr.getConfigs() != null))
    {
      Iterator localIterator = paramIPublicAccountConfigAttr.getConfigs().iterator();
      while (localIterator.hasNext())
      {
        IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = (IPublicAccountConfigAttr.PaConfigInfo)localIterator.next();
        int i1 = paramIPublicAccountConfigAttr.getType();
        if ((i1 != 5) && (i1 != 6))
        {
          if ((i1 == 7) && (!TextUtils.isEmpty(localPaConfigInfo.e)) && (!TextUtils.isEmpty(localPaConfigInfo.j))) {
            localArrayList.add(localPaConfigInfo);
          }
        }
        else if (!TextUtils.isEmpty(localPaConfigInfo.e)) {
          localArrayList.add(localPaConfigInfo);
        }
      }
    }
    return localArrayList.size() != 0;
  }
  
  private boolean b()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  private boolean b(IPublicAccountConfigAttr paramIPublicAccountConfigAttr)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    int i1;
    if (localObject != null) {
      i1 = ((PublicAccountDetailImpl)localObject).followType;
    } else {
      i1 = -1;
    }
    boolean bool = false;
    if ((paramIPublicAccountConfigAttr != null) && (paramIPublicAccountConfigAttr.getConfigs() != null))
    {
      localObject = paramIPublicAccountConfigAttr.getConfigs().iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = (IPublicAccountConfigAttr.PaConfigInfo)((Iterator)localObject).next();
        int i2;
        if ((localPaConfigInfo.jdField_b_of_type_Int != 0) && ((localPaConfigInfo.jdField_b_of_type_Int != 1) || (i1 != 1))) {
          i2 = 0;
        } else {
          i2 = 1;
        }
        if (i2 != 0)
        {
          i2 = paramIPublicAccountConfigAttr.getType();
          if (i2 != 2)
          {
            if ((i2 == 3) || (i2 == 4)) {
              if (localPaConfigInfo.jdField_c_of_type_Int == 23)
              {
                if ((!TextUtils.isEmpty(localPaConfigInfo.e)) && (!TextUtils.isEmpty(localPaConfigInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localPaConfigInfo.jdField_b_of_type_JavaLangString))) {
                  localArrayList.add(localPaConfigInfo);
                }
              }
              else if ((!TextUtils.isEmpty(localPaConfigInfo.e)) && (!TextUtils.isEmpty(localPaConfigInfo.jdField_a_of_type_JavaLangString))) {
                localArrayList.add(localPaConfigInfo);
              }
            }
          }
          else if (localPaConfigInfo.jdField_c_of_type_Int == 23)
          {
            if ((!TextUtils.isEmpty(localPaConfigInfo.e)) && (!TextUtils.isEmpty(localPaConfigInfo.jdField_b_of_type_JavaLangString))) {
              localArrayList.add(localPaConfigInfo);
            }
          }
          else if (!TextUtils.isEmpty(localPaConfigInfo.e)) {
            localArrayList.add(localPaConfigInfo);
          }
        }
      }
    }
    if ((paramIPublicAccountConfigAttr != null) && (paramIPublicAccountConfigAttr.getType() == 4) && (localArrayList.size() % 2 != 0)) {
      localArrayList.remove(localArrayList.size() - 1);
    }
    if (localArrayList.size() != 0) {
      bool = true;
    }
    return bool;
  }
  
  private int f()
  {
    Resources localResources = this.jdField_a_of_type_AndroidAppActivity.getResources();
    return localResources.getDimensionPixelSize(localResources.getIdentifier("status_bar_height", "dimen", "android"));
  }
  
  private void m()
  {
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    if ((localObject != null) && (((PublicAccountDetailImpl)localObject).customConfigAttrs != null) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.customConfigAttrs.size() > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.customConfigAttrs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPublicAccountConfigAttr localIPublicAccountConfigAttr = (IPublicAccountConfigAttr)((Iterator)localObject).next();
        int i1 = localIPublicAccountConfigAttr.getType();
        if (((i1 == 2) || (i1 == 3) || (i1 == 4)) && (b(localIPublicAccountConfigAttr))) {
          this.jdField_c_of_type_JavaUtilArrayList.add(localIPublicAccountConfigAttr);
        }
      }
    }
  }
  
  private void n()
  {
    this.jdField_d_of_type_JavaUtilArrayList.clear();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    if ((localObject != null) && (((PublicAccountDetailImpl)localObject).fullscreenConfigAttrs != null) && (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.fullscreenConfigAttrs.size() > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.fullscreenConfigAttrs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPublicAccountConfigAttr localIPublicAccountConfigAttr = (IPublicAccountConfigAttr)((Iterator)localObject).next();
        int i1 = localIPublicAccountConfigAttr.getType();
        if (((i1 == 5) || (i1 == 6) || (i1 == 7)) && (a(localIPublicAccountConfigAttr))) {
          this.jdField_d_of_type_JavaUtilArrayList.add(localIPublicAccountConfigAttr);
        }
      }
    }
  }
  
  @TargetApi(11)
  private void o()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder;
    if (localObject != null)
    {
      if (((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject).jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailBaseAdapter", 2, "startShowArrowAnimation");
      }
      localObject = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
      if (localObject != null) {
        ((TranslateAnimation)localObject).cancel();
      }
      localObject = this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
      if (localObject != null) {
        ((TranslateAnimation)localObject).cancel();
      }
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new AccountDetailBaseAdapter.11(this));
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new AccountDetailBaseAdapter.12(this));
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  @TargetApi(11)
  private void p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder;
    if (localObject == null) {
      return;
    }
    if (((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject).jdField_a_of_type_AndroidViewView.getAnimation() != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.jdField_a_of_type_AndroidViewView.getAnimation().setAnimationListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.jdField_a_of_type_AndroidViewView.getAnimation().cancel();
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    localObject = this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).setAnimationListener(null);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    localObject = this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
    if (localObject != null)
    {
      ((TranslateAnimation)localObject).setAnimationListener(null);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
      if (localObject != null)
      {
        localObject = ((AnimatorSet)localObject).getChildAnimations().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Animator localAnimator = (Animator)((Iterator)localObject).next();
          localAnimator.end();
          localAnimator.cancel();
        }
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "prefetch data");
    }
    AccountDetailBaseAdapter.PrefetchListener localPrefetchListener = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$PrefetchListener;
    if (localPrefetchListener != null) {
      localPrefetchListener.a();
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public PublicAccountDetailImpl a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
  }
  
  public AccountDetailVideoManager a()
  {
    AccountDetailVideoManager localAccountDetailVideoManager = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager;
    if (localAccountDetailVideoManager != null) {
      return localAccountDetailVideoManager;
    }
    return null;
  }
  
  public EqqDetail a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer;
    if (localObject != null) {
      ((AccountDetailGroupListContainer)localObject).b();
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    p();
    i();
    ((IImageManager)QRoute.api(IImageManager.class)).clean();
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
  }
  
  void a(int paramInt, float paramFloat)
  {
    if (paramInt >= paramFloat)
    {
      c();
      if (this.jdField_c_of_type_Boolean)
      {
        PublicAccountDetailImpl localPublicAccountDetailImpl = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
        if ((localPublicAccountDetailImpl != null) && (localPublicAccountDetailImpl.followType != 1)) {
          c(paramInt);
        }
      }
    }
    else
    {
      d();
    }
  }
  
  void a(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (AccountDetailBaseAdapter.OtherTopHolder)paramView.getTag();
    float f2;
    float f1;
    if (b())
    {
      f2 = 76.0F;
      f1 = this.jdField_a_of_type_Float;
    }
    else
    {
      f2 = 65.0F;
      f1 = this.jdField_a_of_type_Float;
    }
    f1 *= f2;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramView.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramView.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
    int i1;
    if (paramInt < f1)
    {
      f2 = paramInt * 70 / f1;
      float f3 = this.jdField_a_of_type_Float;
      i1 = (int)((100.0F - f2) * f3);
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i1;
      localLayoutParams1.topMargin = ((int)(f3 * 90.0F));
      i1 = localLayoutParams1.height + (int)(this.jdField_a_of_type_Float * 4.0F);
      localLayoutParams2.width = i1;
      localLayoutParams2.height = i1;
      i1 = localLayoutParams1.topMargin;
      f2 = this.jdField_a_of_type_Float;
      localLayoutParams2.topMargin = (i1 - (int)(2.0F * f2));
      i1 = (int)((20.0F - paramInt * 20 / f1) * f2);
      localLayoutParams3.width = i1;
      localLayoutParams3.height = i1;
      if (paramInt == 0)
      {
        localLayoutParams3.topMargin = ((int)(165.0F * f2));
        localLayoutParams3.leftMargin = ((int)(f2 * 72.0F));
      }
      else
      {
        i1 = localLayoutParams1.topMargin;
        double d1 = localLayoutParams1.height;
        Double.isNaN(d1);
        int i2 = (int)(d1 * 0.72D);
        f2 = paramInt * 2 / f1;
        localLayoutParams3.topMargin = (i1 + i2 + (int)(this.jdField_a_of_type_Float * f2));
        d1 = localLayoutParams1.height;
        Double.isNaN(d1);
        localLayoutParams3.leftMargin = ((int)(d1 * 0.72D) + (int)(f2 * this.jdField_a_of_type_Float));
      }
    }
    else
    {
      f2 = this.jdField_a_of_type_Float;
      i1 = (int)(30.0F * f2);
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i1;
      localLayoutParams1.topMargin = ((int)(22.0F * f2));
      i1 = (int)(32.0F * f2);
      localLayoutParams2.width = i1;
      localLayoutParams2.height = i1;
      localLayoutParams2.topMargin = ((int)(20.0F * f2));
      i1 = (int)(f2 * 8.0F);
      localLayoutParams3.height = i1;
      localLayoutParams3.width = i1;
    }
    paramView.jdField_b_of_type_AndroidWidgetImageView.post(new AccountDetailBaseAdapter.8(this, paramView, localLayoutParams1, localLayoutParams2, localLayoutParams3));
    a(paramInt, f1);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  void a(View paramView)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      paramView.findViewById(2131373210).setVisibility(8);
      return;
    }
    paramView = (TextView)paramView.findViewById(2131373209);
    if (paramView != null)
    {
      if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
      {
        paramView.setVisibility(0);
        return;
      }
      paramView.setVisibility(8);
    }
  }
  
  public void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, ImageView paramImageView3, Button paramButton)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView1;
    this.jdField_b_of_type_AndroidWidgetImageView = paramImageView2;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_c_of_type_AndroidWidgetImageView = paramImageView3;
    this.jdField_b_of_type_AndroidWidgetButton = paramButton;
  }
  
  void a(AccountDetailBaseAdapter.DynamicItemHolder paramDynamicItemHolder, View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramDynamicItemHolder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg: dynamic holder is null");
      }
      return;
    }
    DynamicInfo localDynamicInfo = (DynamicInfo)getItem(paramInt);
    if (localDynamicInfo == null)
    {
      if (QLog.isColorLevel())
      {
        paramDynamicItemHolder = new StringBuilder();
        paramDynamicItemHolder.append("setDataForDynamicMsg:");
        paramDynamicItemHolder.append(this.jdField_a_of_type_JavaLangString);
        paramDynamicItemHolder.append("动态消息为空");
        QLog.d("AccountDetailBaseAdapter", 2, paramDynamicItemHolder.toString());
      }
      return;
    }
    if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr == null)
    {
      if (QLog.isColorLevel())
      {
        paramDynamicItemHolder = new StringBuilder();
        paramDynamicItemHolder.append("setDataForDynamicMsg:");
        paramDynamicItemHolder.append(this.jdField_a_of_type_JavaLangString);
        paramDynamicItemHolder.append("动态消息的消息属性为空");
        QLog.d("AccountDetailBaseAdapter", 2, paramDynamicItemHolder.toString());
      }
      return;
    }
    Object localObject3;
    if (!localDynamicInfo.jdField_a_of_type_Boolean)
    {
      localDynamicInfo.jdField_a_of_type_Boolean = true;
      localObject3 = new JSONObject();
      if (this.jdField_a_of_type_Boolean) {}
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject3).put("cha_1", localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject3).put("cha_2", this.u);
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.followType != 1) {
          break label1003;
        }
        Object localObject1 = "02";
        ReportController.b((AppRuntime)localObject4, "dc01160", "Pb_account_lifeservice", str, "0X8007CA2", "0X8007CA2", 0, 0, (String)localObject1, String.valueOf(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_a_of_type_Int), String.valueOf(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_a_of_type_Long), ((JSONObject)localObject3).toString());
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("setDataForDynamicMsg: item:= ");
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append("report msg: artical id=");
          ((StringBuilder)localObject1).append(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_a_of_type_Long);
          ((StringBuilder)localObject1).append("   artical name=");
          ((StringBuilder)localObject1).append(localDynamicInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(" json=");
          ((StringBuilder)localObject1).append(((JSONObject)localObject3).toString());
          QLog.d("AccountDetailBaseAdapter", 2, ((StringBuilder)localObject1).toString());
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      paramInt = localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_a_of_type_Int;
      boolean bool;
      if (paramInt == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localObject3 = localDynamicInfo.jdField_a_of_type_JavaLangString;
      Object localObject4 = Long.valueOf(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.c);
      Object localObject2 = "";
      String str = localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_a_of_type_JavaLangString;
      Object localObject5;
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("setDataForDynamicMsg:title =");
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append("--coverUrl=");
        ((StringBuilder)localObject5).append("");
        ((StringBuilder)localObject5).append("--jumpUrl=");
        ((StringBuilder)localObject5).append(str);
        ((StringBuilder)localObject5).append("--isVideoMsg =");
        ((StringBuilder)localObject5).append(bool);
        QLog.d("AccountDetailBaseAdapter", 2, ((StringBuilder)localObject5).toString());
      }
      if (bool)
      {
        paramDynamicItemHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramDynamicItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramDynamicItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr != null)
        {
          if (paramBoolean) {
            localObject2 = localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.d;
          } else {
            localObject2 = localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_JavaLangString;
          }
          paramDynamicItemHolder.jdField_c_of_type_AndroidWidgetTextView.setText(UITools.a(localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_b_of_type_Int));
        }
      }
      else
      {
        paramDynamicItemHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        paramDynamicItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramDynamicItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        if (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr != null) {
          if (paramBoolean) {
            localObject2 = localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr.jdField_b_of_type_JavaLangString;
          } else {
            localObject2 = localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr.jdField_a_of_type_JavaLangString;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("当前的url是");
        ((StringBuilder)localObject5).append((String)localObject2);
        QLog.d("AccountDetailBaseAdapter", 2, ((StringBuilder)localObject5).toString());
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((Long)localObject4).longValue() > 0L))
      {
        localObject5 = this.jdField_a_of_type_AndroidContentContext.getResources();
        ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#dddfe2"));
        if (paramBoolean) {}
        try
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, localColorDrawable, localColorDrawable, true);
          break label849;
          localObject2 = URLDrawable.getDrawable((String)localObject2, AIOUtils.b(124.0F, (Resources)localObject5), AIOUtils.b(95.0F, (Resources)localObject5), localColorDrawable, localColorDrawable, true);
          label849:
          paramDynamicItemHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
          paramDynamicItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
          paramDynamicItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getDateTimeString(((Long)localObject4).longValue()));
          paramView.setOnClickListener(new AccountDetailBaseAdapter.5(this, paramInt, str, localDynamicInfo));
          return;
        }
        catch (Exception paramDynamicItemHolder)
        {
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("setDataForDynamicMsg:");
            paramView.append(paramDynamicItemHolder);
            QLog.d("AccountDetailBaseAdapter", 2, paramView.toString());
          }
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        paramDynamicItemHolder = new StringBuilder();
        paramDynamicItemHolder.append("setDataForDynamicMsg:");
        paramDynamicItemHolder.append(this.jdField_a_of_type_JavaLangString);
        paramDynamicItemHolder.append("动态消息内容不合法");
        QLog.d("AccountDetailBaseAdapter", 2, paramDynamicItemHolder.toString());
      }
      return;
      label1003:
      localObject2 = "01";
    }
  }
  
  void a(AccountDetailBaseAdapter.ErrorItemHolder paramErrorItemHolder, View paramView)
  {
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    paramView.setClickable(false);
    paramView.setOnClickListener(null);
    if (this.jdField_h_of_type_Boolean) {
      if (this.t == PublicAccountDetailActivityImpl.NETWORK_UNKNOW)
      {
        paramErrorItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131689532);
        paramErrorItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramErrorItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        paramErrorItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      else
      {
        int i1;
        if (this.t == PublicAccountDetailActivityImpl.NETWORK_ERROR)
        {
          paramErrorItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131695217);
          paramView = paramErrorItemHolder.jdField_a_of_type_AndroidWidgetTextView;
          i1 = (int)(f1 * 5.0F);
          paramView.setPadding(0, i1, 0, i1);
          paramErrorItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839274);
          paramErrorItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        else if (this.t == PublicAccountDetailActivityImpl.NO_MORE_DATA)
        {
          paramErrorItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131689535);
          paramErrorItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841753);
          paramView = paramErrorItemHolder.jdField_a_of_type_AndroidWidgetTextView;
          i1 = (int)(f1 * 5.0F);
          paramView.setPadding(0, i1, 0, i1);
          paramErrorItemHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
    }
    paramErrorItemHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new AccountDetailBaseAdapter.4(this, paramErrorItemHolder));
  }
  
  void a(AccountDetailBaseAdapter.FullScreenTopContainerHolder paramFullScreenTopContainerHolder)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    if (localObject1 == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder = paramFullScreenTopContainerHolder;
    int i1 = ((PublicAccountDetailImpl)localObject1).name.length();
    if ((i1 > 8) && (i1 < 13)) {
      paramFullScreenTopContainerHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
    }
    paramFullScreenTopContainerHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name);
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedGrade != 0) {
      paramFullScreenTopContainerHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      paramFullScreenTopContainerHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      paramFullScreenTopContainerHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramFullScreenTopContainerHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary.trim());
    }
    paramFullScreenTopContainerHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.followType == 1)
    {
      if (this.jdField_g_of_type_Boolean)
      {
        paramFullScreenTopContainerHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramFullScreenTopContainerHolder.jdField_a_of_type_AndroidWidgetButton.setText(null);
        paramFullScreenTopContainerHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837600);
      }
      else
      {
        paramFullScreenTopContainerHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131695269);
    }
    else
    {
      paramFullScreenTopContainerHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramFullScreenTopContainerHolder.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695189));
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131695270);
    }
    localObject1 = (PublicAccountConfigAttrImpl)getItem(0);
    if (localObject1 == null) {
      return;
    }
    if ((((PublicAccountConfigAttrImpl)localObject1).configs != null) && (((PublicAccountConfigAttrImpl)localObject1).configs.size() != 0))
    {
      Object localObject2 = ((IPublicAccountConfigAttr.PaConfigInfo)((PublicAccountConfigAttrImpl)localObject1).configs.get(0)).e;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#f7f9fe"));
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      if (((PublicAccountConfigAttrImpl)localObject1).type == 6) {
        localURLDrawableOptions.mPlayGifImage = true;
      }
      localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
      if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 2)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 1))
      {
        k();
      }
      else
      {
        paramFullScreenTopContainerHolder.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager == null) || (!this.jdField_f_of_type_Boolean)) {
          j();
        }
      }
      paramFullScreenTopContainerHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      o();
      if (((PublicAccountConfigAttrImpl)localObject1).type == 7)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager == null) {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager = new AccountDetailVideoManager(this.jdField_a_of_type_AndroidAppActivity, this);
        }
        paramFullScreenTopContainerHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager.a((PublicAccountConfigAttrImpl)localObject1, paramFullScreenTopContainerHolder.jdField_a_of_type_AndroidWidgetFrameLayout);
      }
    }
  }
  
  void a(AccountDetailBaseAdapter.MenuHolder paramMenuHolder, View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.getButtonInfo();
    if (paramView != null)
    {
      paramMenuHolder.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqOsMqqHandler);
      paramMenuHolder.a.setData(paramView);
    }
  }
  
  void a(AccountDetailBaseAdapter.OtherTopHolder paramOtherTopHolder)
  {
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
        return;
      }
      paramOtherTopHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(Color.parseColor("#3d7fe3"));
      i1 = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name.length();
      if ((i1 > 8) && (i1 < 13)) {
        paramOtherTopHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
      }
      paramOtherTopHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.displayNumber)) {
        paramOtherTopHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.displayNumber);
      } else {
        paramOtherTopHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.certifiedGrade != 0) {
        paramOtherTopHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramOtherTopHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramOtherTopHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    else
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
      if (localObject == null) {
        return;
      }
      if (((PublicAccountDetailImpl)localObject).protocolVersion == 0)
      {
        paramOtherTopHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramOtherTopHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        paramOtherTopHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramOtherTopHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramOtherTopHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        paramOtherTopHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
        paramOtherTopHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramOtherTopHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      else
      {
        paramOtherTopHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramOtherTopHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramOtherTopHolder.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary);
        paramOtherTopHolder.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth((int)(this.o - this.jdField_a_of_type_Float * 105.0F));
        paramOtherTopHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject = paramOtherTopHolder.jdField_d_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.sharedFollowerCount);
        localStringBuilder.append("位好友关注");
        ((TextView)localObject).setText(localStringBuilder.toString());
        paramOtherTopHolder.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
        if (PublicAccountUtilImpl.getMessageHistoryInfo(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl) != null)
        {
          paramOtherTopHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
          paramOtherTopHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
        else
        {
          paramOtherTopHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
          paramOtherTopHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
      i1 = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name.length();
      if ((i1 > 8) && (i1 < 13)) {
        paramOtherTopHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
      }
      paramOtherTopHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedDescription)) {
        paramOtherTopHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedDescription);
      } else {
        paramOtherTopHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedGrade != 0) {
        paramOtherTopHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramOtherTopHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    paramOtherTopHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void a(AccountDetailBaseAdapter.PrefetchListener paramPrefetchListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$PrefetchListener = paramPrefetchListener;
  }
  
  void a(AccountDetailBaseAdapter.SubscriptTopHolder paramSubscriptTopHolder)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl == null) {
      return;
    }
    paramSubscriptTopHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    paramSubscriptTopHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    int i1 = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name.length();
    if ((i1 > 8) && (i1 < 13)) {
      paramSubscriptTopHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
    }
    paramSubscriptTopHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name);
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedGrade != 0) {
      paramSubscriptTopHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      paramSubscriptTopHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if ((a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedDescription))) {
      paramSubscriptTopHolder.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedDescription);
    } else {
      paramSubscriptTopHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    String str = a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary);
    paramSubscriptTopHolder.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    paramSubscriptTopHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.followType == 1)
    {
      if (this.jdField_g_of_type_Boolean)
      {
        paramSubscriptTopHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramSubscriptTopHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837600);
        paramSubscriptTopHolder.jdField_a_of_type_AndroidWidgetButton.setText(null);
      }
      else
      {
        paramSubscriptTopHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131695269);
      return;
    }
    paramSubscriptTopHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    paramSubscriptTopHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839280);
    paramSubscriptTopHolder.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695189));
    paramSubscriptTopHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131695270);
  }
  
  public void a(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl = paramPublicAccountDetailImpl;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailHandlerAccountDetailBaseItemClickHandler = new AccountDetailBaseItemClickHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramPublicAccountDetailImpl);
      m();
      if (paramPublicAccountDetailImpl.cardStyle == 1)
      {
        c(true);
        return;
      }
      c(false);
    }
  }
  
  public void a(EqqDetail paramEqqDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = paramEqqDetail;
  }
  
  public void a(ArrayList<DynamicInfo> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  public void a(ArrayList<DynamicInfo> paramArrayList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      this.jdField_a_of_type_Long = System.nanoTime();
    }
    paramArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      DynamicInfo localDynamicInfo = (DynamicInfo)localIterator.next();
      if ((localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr != null) && (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_Int != 1) && (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_a_of_type_Int != 2)) {
        paramArrayList.add(localDynamicInfo);
      } else if ((localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr != null) && (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_a_of_type_Int != 1) && (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanMsgAttr.jdField_a_of_type_Int != 2)) {
        paramArrayList.add(localDynamicInfo);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(paramArrayList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_h_of_type_Boolean = bool;
    return (this.jdField_h_of_type_Boolean) && ((this.t == PublicAccountDetailActivityImpl.NETWORK_UNKNOW) || (this.t == PublicAccountDetailActivityImpl.NETWORK_ERROR) || (this.t == PublicAccountDetailActivityImpl.NO_MORE_DATA));
  }
  
  public boolean a(int paramInt)
  {
    DynamicInfo localDynamicInfo = (DynamicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - this.jdField_c_of_type_JavaUtilArrayList.size() - 2);
    if (localDynamicInfo != null)
    {
      if ((localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr != null) && (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanPictureAttr.jdField_a_of_type_Int == 1)) {
        return true;
      }
      if ((localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr != null) && (localDynamicInfo.jdField_a_of_type_ComTencentBizPubaccountAccountdetailBeanVideoAttr.jdField_e_of_type_Int == 1)) {
        return true;
      }
    }
    return false;
  }
  
  boolean a(int paramInt1, View paramView, int paramInt2)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool2 = false;
    if (paramView == null) {
      return false;
    }
    boolean bool1;
    if (paramInt1 == 1)
    {
      bool3 = a(paramInt2);
      bool1 = bool2;
      if (paramView.getTag() != null)
      {
        bool1 = bool2;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.DynamicItemHolder))
        {
          bool1 = bool2;
          if (bool3 == ((AccountDetailBaseAdapter.DynamicItemHolder)paramView.getTag()).jdField_a_of_type_Boolean) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    if (paramInt1 == 2)
    {
      bool1 = bool3;
      if (paramView.getTag() != null)
      {
        bool1 = bool3;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.ErrorItemHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramInt1 == 0)
    {
      bool1 = bool4;
      if (paramView.getTag() != null)
      {
        bool1 = bool4;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.OtherTopHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramInt1 == 8)
    {
      bool1 = bool5;
      if (paramView.getTag() != null)
      {
        bool1 = bool5;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.SubscriptTopHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramInt1 == 9)
    {
      bool1 = bool6;
      if (paramView.getTag() != null)
      {
        bool1 = bool6;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.LoadingItemHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramInt1 == 10)
    {
      bool1 = bool7;
      if (paramView.getTag() != null)
      {
        bool1 = bool7;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.FullScreenTopContainerHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (paramInt1 == 11)
    {
      bool1 = bool8;
      if (paramView.getTag() != null)
      {
        bool1 = bool8;
        if ((paramView.getTag() instanceof AccountDetailBaseAdapter.MenuHolder)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return true;
  }
  
  public int b()
  {
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    return localView.getTop();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.setOnEndScrollListener(new AccountDetailBaseAdapter.7(this));
  }
  
  public void b(int paramInt)
  {
    this.t = paramInt;
  }
  
  void b(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (AccountDetailBaseAdapter.FullScreenTopContainerHolder)paramView.getTag();
    float f3 = this.jdField_a_of_type_Float;
    if (b())
    {
      f1 = 64.0F;
      f2 = this.jdField_a_of_type_Float;
    }
    else
    {
      f1 = 75.0F;
      f2 = this.jdField_a_of_type_Float;
    }
    float f1 = f3 * 170.0F - f2 * f1 / 2.0F;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    float f2 = paramInt;
    if (f2 < f1)
    {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedGrade != 0) {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      int i1;
      if (paramInt <= 0)
      {
        f2 = this.jdField_a_of_type_Float;
        i1 = (int)(90.0F * f2);
        localLayoutParams1.width = i1;
        localLayoutParams1.height = i1;
        i1 = (int)(20.0F * f2);
        localLayoutParams2.width = i1;
        localLayoutParams2.height = i1;
        localLayoutParams2.topMargin = ((int)(f2 * 58.0F));
        localLayoutParams2.leftMargin = ((int)(f2 * 58.0F));
      }
      else
      {
        f2 = paramInt * 50 / f1;
        f3 = this.jdField_a_of_type_Float;
        i1 = (int)((90.0F - f2) * f3);
        localLayoutParams1.width = i1;
        localLayoutParams1.height = i1;
        i1 = (int)((20.0F - paramInt * 20 / f1) * f3);
        localLayoutParams2.width = i1;
        localLayoutParams2.height = i1;
        double d1 = localLayoutParams1.height;
        Double.isNaN(d1);
        i1 = (int)(d1 * 0.64D);
        f2 = paramInt * 2 / f1;
        localLayoutParams2.topMargin = (i1 + (int)(this.jdField_a_of_type_Float * f2));
        d1 = localLayoutParams1.height;
        Double.isNaN(d1);
        localLayoutParams2.leftMargin = ((int)(d1 * 0.64D) + (int)(f2 * this.jdField_a_of_type_Float));
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.post(new AccountDetailBaseAdapter.9(this, paramView, localLayoutParams1, localLayoutParams2));
    }
    else if (f2 >= f1)
    {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    a(paramInt, f1);
  }
  
  public void b(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void b(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  protected int c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
      if (localObject != null)
      {
        if ((((PublicAccountDetailImpl)localObject).configBackgroundColor == null) || (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.configBackgroundColor.equals(""))) {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.configBackgroundColor = "3d7fe3";
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.configBackgroundColor.substring(0, 6));
        return Color.parseColor(((StringBuilder)localObject).toString());
      }
    }
    return Color.parseColor("#3d7fe3");
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(c());
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_JavaLangString));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void c(int paramInt)
  {
    float f1;
    float f2;
    if (this.jdField_b_of_type_Boolean)
    {
      if (a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl))
      {
        f1 = 258.0F;
        f2 = this.jdField_a_of_type_Float;
      }
      else
      {
        f1 = 234.0F;
        f2 = this.jdField_a_of_type_Float;
      }
    }
    else if (a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl))
    {
      f1 = 217.0F;
      f2 = this.jdField_a_of_type_Float;
    }
    else
    {
      f1 = 173.0F;
      f2 = this.jdField_a_of_type_Float;
    }
    int i1 = (int)(f2 * f1);
    AlphaAnimation localAlphaAnimation;
    if ((this.jdField_b_of_type_AndroidWidgetButton.getVisibility() == 8) && (paramInt >= i1))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(100L);
      localAlphaAnimation.setFillBefore(true);
      this.jdField_b_of_type_AndroidWidgetButton.startAnimation(localAlphaAnimation);
      return;
    }
    if ((paramInt < i1) && (this.jdField_b_of_type_AndroidWidgetButton.getVisibility() == 0))
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(100L);
      this.jdField_b_of_type_AndroidWidgetButton.startAnimation(localAlphaAnimation);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  void c(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (AccountDetailBaseAdapter.SubscriptTopHolder)paramView.getTag();
    float f2;
    float f1;
    if (b())
    {
      f2 = 41.0F;
      f1 = this.jdField_a_of_type_Float;
    }
    else
    {
      f2 = 30.0F;
      f1 = this.jdField_a_of_type_Float;
    }
    f1 *= f2;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramView.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramView.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramInt < f1)
    {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.certifiedGrade != 0) {
        paramView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      f2 = paramInt * 50 / f1;
      float f3 = this.jdField_a_of_type_Float;
      int i1 = (int)((90.0F - f2) * f3);
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i1;
      localLayoutParams1.topMargin = ((int)(f3 * 60.0F));
      i1 = localLayoutParams1.height;
      f2 = this.jdField_a_of_type_Float;
      i1 += (int)(4.0F * f2);
      localLayoutParams2.width = i1;
      localLayoutParams2.height = i1;
      localLayoutParams2.topMargin = ((int)(58.0F * f2));
      i1 = (int)((20.0F - paramInt * 20 / f1) * f2);
      localLayoutParams3.width = i1;
      localLayoutParams3.height = i1;
      if (paramInt == 0)
      {
        i1 = (int)(f2 * 65.0F);
        localLayoutParams3.leftMargin = i1;
        localLayoutParams3.topMargin = i1;
      }
      else
      {
        double d1 = localLayoutParams1.height;
        Double.isNaN(d1);
        i1 = (int)(d1 * 0.72D) + (int)(paramInt * 2 / f1 * this.jdField_a_of_type_Float);
        localLayoutParams3.leftMargin = i1;
        localLayoutParams3.topMargin = i1;
      }
      paramView.jdField_b_of_type_AndroidWidgetImageView.post(new AccountDetailBaseAdapter.10(this, paramView, localLayoutParams1, localLayoutParams2, localLayoutParams3));
    }
    else
    {
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      paramView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    a(paramInt, f1);
  }
  
  public void c(Drawable paramDrawable)
  {
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      n();
      return;
    }
    this.jdField_d_of_type_JavaUtilArrayList.clear();
  }
  
  void d()
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.smoothScrollBy(this.q - paramInt - this.jdField_a_of_type_AndroidViewView.getHeight(), 500);
    c();
    if (this.jdField_c_of_type_Boolean)
    {
      PublicAccountDetailImpl localPublicAccountDetailImpl = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
      if ((localPublicAccountDetailImpl != null) && (localPublicAccountDetailImpl.followType != 1)) {
        c(paramInt);
      }
    }
  }
  
  void d(boolean paramBoolean)
  {
    AccountDetailBaseAdapter.FullScreenTopContainerHolder localFullScreenTopContainerHolder = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder;
    if (localFullScreenTopContainerHolder != null)
    {
      if (paramBoolean)
      {
        localFullScreenTopContainerHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        return;
      }
      localFullScreenTopContainerHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      k();
    }
  }
  
  void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.smoothScrollToPosition(0);
    d();
  }
  
  public void f()
  {
    this.jdField_f_of_type_Boolean = true;
    d(false);
  }
  
  public void g()
  {
    d(true);
  }
  
  public int getCount()
  {
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    int i1 = 1;
    if ((localPublicAccountDetailImpl == null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
      return 1;
    }
    localPublicAccountDetailImpl = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    if ((localPublicAccountDetailImpl != null) && (localPublicAccountDetailImpl.protocolVersion == 1))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.getButtonInfo() != null) {
        return 2;
      }
      return 1;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        i1 = 1 + this.jdField_a_of_type_JavaUtilArrayList.size();
      } else if (!this.jdField_d_of_type_Boolean) {
        i1 = 0;
      }
      return i2 + 1 + i1;
    }
    return 2;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl == null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    if ((localObject != null) && (((PublicAccountDetailImpl)localObject).protocolVersion == 1)) {
      return null;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      if (paramInt == 0)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          localObject = this.jdField_d_of_type_JavaUtilArrayList;
          if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {
            return this.jdField_d_of_type_JavaUtilArrayList.get(paramInt);
          }
        }
        return null;
      }
      if (paramInt <= this.jdField_c_of_type_JavaUtilArrayList.size()) {
        return this.jdField_c_of_type_JavaUtilArrayList.get(paramInt - 1);
      }
      if (this.jdField_d_of_type_Boolean) {
        return null;
      }
      if (paramInt == this.jdField_c_of_type_JavaUtilArrayList.size() + 1) {
        return null;
      }
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - this.jdField_c_of_type_JavaUtilArrayList.size() - 2);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl == null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
      return 9;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      if (paramInt == 0)
      {
        if (this.jdField_b_of_type_Boolean) {
          return 10;
        }
        return 8;
      }
      if (paramInt <= this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        paramInt = ((IPublicAccountConfigAttr)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt - 1)).getType();
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return -1;
            }
            return 5;
          }
          return 4;
        }
        return 3;
      }
      if (this.jdField_d_of_type_Boolean) {
        return 2;
      }
      if (paramInt == this.jdField_c_of_type_JavaUtilArrayList.size() + 1) {
        return 6;
      }
      return 1;
    }
    PublicAccountDetailImpl localPublicAccountDetailImpl = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
    if ((localPublicAccountDetailImpl != null) && (localPublicAccountDetailImpl.protocolVersion == 1))
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return -1;
        }
        return 11;
      }
      return 0;
    }
    if (paramInt == 0) {
      return 0;
    }
    return 7;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = getItemViewType(paramInt);
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getView->pos:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", type:");
      ((StringBuilder)localObject1).append(i1);
      QLog.d("AccountDetailBaseAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject6 = paramView;
    boolean bool3 = a(i1, (View)localObject6, paramInt);
    Object localObject7 = null;
    Object localObject8 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject3;
    Object localObject5;
    Object localObject2;
    Object localObject4;
    if (bool3)
    {
      if (i1 != 0) {
        if (i1 != 1) {
          if (i1 != 2)
          {
            switch (i1)
            {
            default: 
              break;
            case 11: 
              localObject3 = (AccountDetailBaseAdapter.MenuHolder)paramView.getTag();
              localObject5 = null;
              paramView = (View)localObject5;
              localObject1 = paramView;
              localObject2 = localObject1;
              localObject4 = localObject2;
              break;
            case 10: 
              localObject1 = (AccountDetailBaseAdapter.FullScreenTopContainerHolder)paramView.getTag();
              paramView = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager;
              if (paramView != null) {
                paramView.jdField_c_of_type_Boolean = false;
              }
              localObject5 = null;
              localObject4 = localObject5;
              paramView = (View)localObject4;
              break;
            case 9: 
              localObject4 = (AccountDetailBaseAdapter.LoadingItemHolder)paramView.getTag();
              localObject5 = null;
              paramView = (View)localObject5;
              localObject1 = paramView;
              localObject2 = localObject1;
              localObject3 = localObject2;
              break;
            case 8: 
              localObject5 = (AccountDetailBaseAdapter.SubscriptTopHolder)paramView.getTag();
              break;
            }
            localObject5 = null;
            localObject4 = null;
          }
        }
      }
      Object localObject9;
      Object localObject10;
      Object localObject11;
      for (localObject1 = null;; localObject1 = localObject5)
      {
        paramView = (View)localObject1;
        localObject3 = paramView;
        localObject2 = paramView;
        paramView = (View)localObject4;
        for (;;)
        {
          localObject4 = localObject3;
          bool1 = false;
          localObject7 = localObject8;
          localObject8 = localObject1;
          localObject9 = localObject2;
          localObject10 = localObject3;
          localObject11 = localObject4;
          break;
          localObject2 = (AccountDetailBaseAdapter.ErrorItemHolder)paramView.getTag();
          localObject5 = null;
          paramView = (View)localObject5;
          localObject1 = paramView;
          localObject3 = localObject1;
        }
        localObject7 = (AccountDetailBaseAdapter.DynamicItemHolder)paramView.getTag();
        bool1 = a(paramInt);
        paramView = null;
        localObject8 = paramView;
        localObject9 = localObject8;
        localObject10 = localObject9;
        localObject11 = localObject10;
        localObject5 = localObject11;
        break;
        localObject4 = (AccountDetailBaseAdapter.OtherTopHolder)paramView.getTag();
        localObject5 = null;
      }
      localObject1 = localObject7;
      localObject7 = paramView;
      paramView = (View)localObject6;
      localObject2 = localObject5;
      localObject3 = localObject8;
      localObject4 = localObject9;
      localObject5 = localObject10;
      localObject6 = localObject11;
    }
    else
    {
      if (i1 != 0)
      {
        if (i1 != 1) {
          if (i1 != 2) {
            switch (i1)
            {
            default: 
              localObject1 = null;
              paramView = (View)localObject6;
            }
          }
        }
        for (;;)
        {
          localObject2 = null;
          localObject3 = null;
          localObject4 = localObject3;
          localObject5 = localObject4;
          localObject6 = localObject5;
          break;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558433, paramViewGroup, false);
          localObject5 = new AccountDetailBaseAdapter.MenuHolder(this);
          ((AccountDetailBaseAdapter.MenuHolder)localObject5).a = ((PublicAccountMenuBar)paramView.findViewById(2131370824));
          paramView.setTag(localObject5);
          localObject1 = null;
          localObject2 = localObject1;
          localObject3 = localObject2;
          localObject4 = localObject3;
          localObject6 = localObject4;
          bool1 = bool2;
          break;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558436, paramViewGroup, false);
          localObject1 = paramView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject1).height = this.q;
          if (b()) {
            ((ViewGroup.LayoutParams)localObject1).height -= f();
          }
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramView.setOnClickListener(null);
          localObject3 = new AccountDetailBaseAdapter.FullScreenTopContainerHolder(this);
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131380563));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364429));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361891));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361893));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131380697));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361889));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131361887);
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361885));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361886));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).e = ((ImageView)paramView.findViewById(2131370360));
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378745));
          float f1 = FontSettingManager.getFontLevel() / 16.0F;
          if (f1 > 1.0F) {
            ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_b_of_type_AndroidWidgetTextView.setTextSize(14 / f1);
          } else {
            ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_b_of_type_AndroidWidgetTextView.setTextSize(14);
          }
          this.jdField_a_of_type_AndroidWidgetButton = ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_a_of_type_AndroidWidgetButton;
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          ((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3).jdField_a_of_type_AndroidViewView.setOnClickListener(new AccountDetailBaseAdapter.2(this));
          paramView.findViewById(2131361895).setOnClickListener(new AccountDetailBaseAdapter.3(this));
          paramView.setTag(localObject3);
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailModelAccountDetailVideoManager;
          if (localObject1 != null) {
            ((AccountDetailVideoManager)localObject1).jdField_c_of_type_Boolean = true;
          }
          localObject2 = null;
          localObject4 = localObject2;
          localObject5 = localObject4;
          localObject6 = localObject5;
          break label1559;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558432, paramViewGroup, false);
          paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels));
          paramView.setOnClickListener(null);
          localObject6 = new AccountDetailBaseAdapter.LoadingItemHolder(this);
          ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370392));
          ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370379));
          ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376488));
          paramView.setTag(localObject6);
          localObject2 = null;
          localObject3 = localObject2;
          localObject4 = localObject3;
          localObject5 = localObject4;
          break label1559;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558437, paramViewGroup, false);
          paramView.setOnClickListener(null);
          localObject2 = new AccountDetailBaseAdapter.SubscriptTopHolder(this);
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370641));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368354));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364429));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361891));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361893));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361890));
          ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361889));
          this.jdField_a_of_type_AndroidWidgetButton = ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).jdField_a_of_type_AndroidWidgetButton;
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          paramView.findViewById(2131361895).setOnClickListener(new AccountDetailBaseAdapter.1(this));
          f1 = FontSettingManager.getFontLevel() / 16.0F;
          if (f1 > 1.0F) {
            ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextSize(14 / f1);
          } else {
            ((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextSize(14);
          }
          paramView.setTag(localObject2);
          break label1453;
          if (this.jdField_a_of_type_Boolean)
          {
            paramView = this.jdField_b_of_type_AndroidViewView;
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer == null) {
              this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer = new AccountDetailGroupListContainer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl, false);
            }
            paramView = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.a();
          }
          paramView.setPadding(0, AIOUtils.b(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramView.setMinimumHeight(this.p);
          break label1450;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558431, paramViewGroup, false);
          paramView.setOnClickListener(null);
          label1450:
          localObject2 = null;
          label1453:
          localObject4 = null;
          localObject5 = localObject4;
          break label1552;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559601, paramViewGroup, false);
          localObject4 = new AccountDetailBaseAdapter.ErrorItemHolder(this);
          ((AccountDetailBaseAdapter.ErrorItemHolder)localObject4).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361888));
          ((AccountDetailBaseAdapter.ErrorItemHolder)localObject4).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373208));
          ((AccountDetailBaseAdapter.ErrorItemHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373224));
          paramView.setTag(localObject4);
          paramView.setMinimumHeight(this.q);
          localObject2 = null;
          localObject5 = localObject2;
          label1552:
          localObject3 = null;
          localObject6 = localObject5;
          label1559:
          localObject1 = null;
          bool1 = false;
          break;
          bool1 = a(paramInt);
          if (bool1) {
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559611, paramViewGroup, false);
          } else {
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559602, paramViewGroup, false);
          }
          localObject1 = new AccountDetailBaseAdapter.DynamicItemHolder(this);
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131366003));
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366006));
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366005));
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366018));
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366017));
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366004));
          ((AccountDetailBaseAdapter.DynamicItemHolder)localObject1).jdField_a_of_type_Boolean = bool1;
          paramView.setTag(localObject1);
        }
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558435, paramViewGroup, false);
      paramView.setOnClickListener(null);
      localObject7 = new AccountDetailBaseAdapter.OtherTopHolder(this);
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379002);
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370641));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131378122);
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368354));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364429));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361891));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361890));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361893));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).e = ((ImageView)paramView.findViewById(2131361894));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377410));
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_c_of_type_AndroidViewView = paramView.findViewById(2131365759);
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_d_of_type_AndroidViewView = paramView.findViewById(2131368197);
      ((AccountDetailBaseAdapter.OtherTopHolder)localObject7).jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      paramView.setTag(localObject7);
      localObject2 = null;
      localObject3 = localObject2;
      localObject4 = localObject3;
      localObject5 = localObject4;
      localObject6 = localObject5;
      bool1 = false;
      localObject1 = localObject6;
    }
    if (i1 == 0)
    {
      a((AccountDetailBaseAdapter.OtherTopHolder)localObject7);
      return paramView;
    }
    if (i1 == 8)
    {
      a((AccountDetailBaseAdapter.SubscriptTopHolder)localObject2);
      return paramView;
    }
    if (i1 == 10)
    {
      a((AccountDetailBaseAdapter.FullScreenTopContainerHolder)localObject3);
      return paramView;
    }
    if (i1 == 1)
    {
      a((AccountDetailBaseAdapter.DynamicItemHolder)localObject1, paramView, paramInt, bool1);
      return paramView;
    }
    if (i1 == 6)
    {
      a(paramView);
      return paramView;
    }
    if (i1 == 2)
    {
      a((AccountDetailBaseAdapter.ErrorItemHolder)localObject4, paramView);
      return paramView;
    }
    if (i1 == 9)
    {
      if (this.jdField_i_of_type_Boolean)
      {
        ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        return paramView;
      }
      ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((AccountDetailBaseAdapter.LoadingItemHolder)localObject6).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return paramView;
    }
    if (i1 == 11)
    {
      a((AccountDetailBaseAdapter.MenuHolder)localObject5, paramView);
      return paramView;
    }
    Object localObject1 = (PublicAccountConfigAttrImpl)getItem(paramInt);
    if (i1 != 3)
    {
      if (i1 != 4)
      {
        if (i1 != 5) {
          return paramView;
        }
        return AccountDetailJigsawViewWrapper.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, (PublicAccountConfigAttrImpl)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.followType, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailHandlerAccountDetailBaseItemClickHandler, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      }
      paramViewGroup = AccountDetailWindowViewWrapper.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, (PublicAccountConfigAttrImpl)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.followType, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailHandlerAccountDetailBaseItemClickHandler, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailTopGestureLayout;
      paramView = paramViewGroup;
      if (localObject1 != null)
      {
        ((AccountDetailTopGestureLayout)localObject1).a(paramViewGroup);
        return paramViewGroup;
      }
    }
    else
    {
      paramViewGroup = AccountDetailBannerViewWrapper.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, (PublicAccountConfigAttrImpl)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.followType, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailHandlerAccountDetailBaseItemClickHandler, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailTopGestureLayout;
      paramView = paramViewGroup;
      if (localObject1 != null)
      {
        ((AccountDetailTopGestureLayout)localObject1).a(paramViewGroup);
        paramView = paramViewGroup;
      }
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 13;
  }
  
  public void h()
  {
    this.jdField_f_of_type_Boolean = false;
    d(true);
  }
  
  void i()
  {
    Button localButton = this.jdField_b_of_type_AndroidWidgetButton;
    if ((localButton != null) && (localButton.getAnimation() != null))
    {
      this.jdField_b_of_type_AndroidWidgetButton.getAnimation().cancel();
      this.jdField_b_of_type_AndroidWidgetButton.clearAnimation();
    }
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "showLoadingView");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.e.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843371));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.e.clearAnimation();
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(500L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setRepeatMode(1);
    localRotateAnimation.setStartTime(-1L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.e.startAnimation(localRotateAnimation);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "hideLoadingView");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.e.clearAnimation();
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.e.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void l()
  {
    AccountDetailBaseAdapter.FullScreenTopContainerHolder localFullScreenTopContainerHolder = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder;
    if (localFullScreenTopContainerHolder == null) {
      return;
    }
    localFullScreenTopContainerHolder.e.clearAnimation();
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.e.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837604));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailAdapterAccountDetailBaseAdapter$FullScreenTopContainerHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.jdField_d_of_type_Boolean) && (!a()))
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailXListView.setAdapter(this);
    }
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((localActivity != null) && ((localActivity instanceof View.OnClickListener)))
    {
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
        this.jdField_g_of_type_Boolean = true;
      }
      ((View.OnClickListener)this.jdField_a_of_type_AndroidAppActivity).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter
 * JD-Core Version:    0.7.0.1
 */
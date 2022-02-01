package com.tencent.biz.subscribe.videoplayer;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.framework.BaseVideoView;
import com.tencent.biz.subscribe.framework.BaseVideoViewListenerSets;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.NetworkManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqfloatingwindow.IFloatingWrapperManager;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class VideoPlayerView
  extends BaseVideoView
{
  private static float jdField_a_of_type_Float = 1.0F;
  private static final SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private static final HashMap<View, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static boolean o;
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  protected View a;
  protected ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected ProgressBar a;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  protected TextView a;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private SubscribeVideoDetailFragment jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment;
  private VideoNextFeedsView jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView;
  private FollowTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
  private IVideoOuterStatusListener jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int[] jdField_a_of_type_ArrayOfInt = null;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  protected ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  protected TextView b;
  private FollowTextView jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
  protected URLImageView b;
  private SquareImageView jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
  private HashMap<String, Boolean> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private int[] jdField_b_of_type_ArrayOfInt = LiuHaiUtils.a(getContext());
  private final int jdField_c_of_type_Int = 2;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  protected ImageView c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private final int jdField_d_of_type_Int = 3;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  protected ImageView d;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 1;
  private long jdField_f_of_type_Long;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean;
  private View jdField_h_of_type_AndroidViewView;
  private boolean jdField_h_of_type_Boolean = true;
  private View jdField_i_of_type_AndroidViewView;
  private boolean jdField_i_of_type_Boolean = true;
  private View jdField_j_of_type_AndroidViewView;
  private boolean jdField_j_of_type_Boolean;
  private View jdField_k_of_type_AndroidViewView;
  private boolean jdField_k_of_type_Boolean;
  private boolean l;
  private boolean m = false;
  private boolean n = false;
  private boolean p = false;
  private boolean q;
  private boolean r;
  private boolean s;
  
  public VideoPlayerView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoPlayerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoPlayerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void A()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.jdField_j_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.jdField_e_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((VideoNextFeedsView)localObject).getLayoutParams();
      if (h())
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
    if (localObject != null)
    {
      int i1;
      if (h()) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((LinearLayout)localObject).setVisibility(i1);
    }
    if ((h()) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null))
    {
      localObject = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get());
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
        SubImageLoader.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get(), this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView);
      }
      localObject = this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
      if (localObject != null)
      {
        ((FollowTextView)localObject).setOnlyFollowMode(true);
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFeedData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFollowStateChangeListener(new VideoPlayerView.16(this));
      }
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
        if (localObject != null)
        {
          localObject = (RelativeLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
          if (((getContext() instanceof Activity)) && (((Activity)getContext()).getRequestedOrientation() == 0))
          {
            ((RelativeLayout.LayoutParams)localObject).addRule(2, this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getId());
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
            ((LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.getLayoutParams()).rightMargin = ImmersiveUtils.dpToPx(12.0F);
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
            ((LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.getLayoutParams()).rightMargin = 0;
            ((RelativeLayout.LayoutParams)localObject).addRule(2, 0);
          }
          this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.requestLayout();
        }
      }
      localObject = this.jdField_k_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = this.jdField_k_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
  }
  
  private void B()
  {
    Object localObject = this.jdField_j_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView;
    if ((localObject != null) && (((VideoNextFeedsView)localObject).getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.b();
    }
  }
  
  private void C()
  {
    if (a() != null)
    {
      boolean bool;
      if (a().getRenderViewWidth() > a().getRenderViewHeight()) {
        bool = true;
      } else {
        bool = false;
      }
      this.q = bool;
    }
  }
  
  private void D()
  {
    C();
    int i1 = this.jdField_b_of_type_ArrayOfInt[0];
    if (getLayoutParams().width != -1) {
      i1 = getLayoutParams().width;
    }
    this.jdField_a_of_type_ArrayOfInt = new int[] { i1, getLayoutParams().height };
    int[] arrayOfInt;
    if (this.q)
    {
      if ((getContext() instanceof Activity)) {
        ((Activity)getContext()).setRequestedOrientation(0);
      }
      arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      b(new int[] { arrayOfInt[1], arrayOfInt[0] });
    }
    else
    {
      arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      b(new int[] { arrayOfInt[0], arrayOfInt[1] });
    }
    a(8);
    f(true);
    E();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      F();
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(2130838971);
    }
  }
  
  private void F()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && ((getContext() instanceof Activity)))
    {
      int i1;
      if (((Activity)getContext()).getRequestedOrientation() == 0) {
        i1 = 25;
      } else {
        i1 = 12;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setMaxEms(i1);
    }
  }
  
  private void G()
  {
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    if (localObject != null)
    {
      int i1 = ((CertifiedAccountMeta.StFeed)localObject).poster.followState.get();
      int i2 = 0;
      if (i1 == 0)
      {
        localObject = this.jdField_b_of_type_JavaUtilHashMap;
        if ((localObject != null) && (((HashMap)localObject).get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()) == null))
        {
          i1 = 0;
          break label65;
        }
      }
      i1 = 1;
      label65:
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
      if (localObject != null)
      {
        ((FollowTextView)localObject).setOnlyFollowMode(true);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFeedData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
      }
      if ((i1 == 0) && (!this.r) && (h())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (this.jdField_e_of_type_AndroidViewView != null)
      {
        if (i1 != 0)
        {
          this.r = true;
          localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
          if (localObject != null) {
            VSReporter.b(((CertifiedAccountMeta.StFeed)localObject).poster.id.get(), "auth_video", "half_exp", 0, 0, new String[] { "", "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
          }
        }
        localObject = this.jdField_e_of_type_AndroidViewView;
        if (i1 != 0) {
          i1 = i2;
        } else {
          i1 = 8;
        }
        ((View)localObject).setVisibility(i1);
        a().sendEmptyMessageDelayed(3, 5000L);
      }
    }
  }
  
  private void H()
  {
    Object localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(2130838973);
    }
    localObject = this.jdField_e_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
  
  private void I()
  {
    if ((getContext() instanceof Activity))
    {
      ((Activity)getContext()).setRequestedOrientation(1);
      TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        localTextView.setMaxEms(12);
      }
    }
    b(this.jdField_a_of_type_ArrayOfInt);
    a(0);
    f(false);
    H();
    if (this.jdField_f_of_type_Int == 10) {
      A();
    }
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        if (localView != null) {
          localView.setVisibility(paramInt);
        }
      }
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, false);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { paramInt1, paramInt2 });
    localObjectAnimator.setDuration(0L);
    localObjectAnimator.addListener(new VideoPlayerView.12(this, paramInt2, paramView, paramBoolean, paramInt1));
    localObjectAnimator.start();
  }
  
  private boolean a(String paramString)
  {
    try
    {
      String[] arrayOfString = ((String)VSConfigManager.a().a("KEY_HIT_FOR_VID_URLS", "http://qzvv.video.qq.com/qzone|https://qzvv.video.qq.com/qzone")).split("\\|");
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        boolean bool = paramString.startsWith(arrayOfString[i1]);
        if (bool) {
          return true;
        }
        i1 += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  private void b(int[] paramArrayOfInt)
  {
    getLayoutParams().width = paramArrayOfInt[0];
    getLayoutParams().height = paramArrayOfInt[1];
    setLayoutParams(getLayoutParams());
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.a();
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.c((CertifiedAccountMeta.StFeed)localObject);
        String str = ((CertifiedAccountMeta.StFeed)localObject).poster.id.get();
        if (paramBoolean) {
          localObject = "next_play";
        } else {
          localObject = "next_clk";
        }
        VSReporter.b(str, "auth_video", (String)localObject, 0, 0, new String[0]);
      }
    }
    Object localObject = this.jdField_b_of_type_ComTencentImageURLImageView;
    if (localObject != null)
    {
      ((URLImageView)localObject).setBackgroundResource(0);
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
    int i2 = 0;
    int i1;
    if (localObject != null)
    {
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((ProgressBar)localObject).setVisibility(i1);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      i1 = i2;
      if (paramBoolean) {
        i1 = 8;
      }
      ((ImageView)localObject).setVisibility(i1);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (!LiuHaiUtils.b()) {
      return;
    }
    Object localObject;
    if ((paramBoolean) && (!this.q))
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment;
      if (localObject != null) {
        ((SubscribeVideoDetailFragment)localObject).a(true, this.jdField_g_of_type_Int);
      }
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setPadding(0, this.jdField_g_of_type_Int, 0, 0);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment;
      if (localObject != null) {
        ((SubscribeVideoDetailFragment)localObject).a(false, this.jdField_g_of_type_Int);
      }
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setPadding(0, 0, 0, 0);
      }
    }
  }
  
  private void f(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment;
    if ((localObject != null) && (((SubscribeVideoDetailFragment)localObject).getBaseActivity() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getBaseActivity().getWindow().getDecorView();
      if (this.jdField_d_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
        if (localObject != null) {
          ((SystemBarCompact)localObject).setStatusBarVisible(2, 0);
        }
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getBaseActivity().getWindow().setFlags(1024, 1024);
        LiuHaiUtils.c(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getBaseActivity());
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getBaseActivity());
      }
      else
      {
        SystemBarCompact localSystemBarCompact = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
        if (localSystemBarCompact != null) {
          localSystemBarCompact.setStatusBarVisible(0, 10);
        }
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getBaseActivity().getWindow().clearFlags(1024);
        LiuHaiUtils.b(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getBaseActivity());
        ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFFFFD);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView;
    if (localObject != null) {
      ((VideoNextFeedsView)localObject).setUIState(paramBoolean, this.q);
    }
    e(this.jdField_d_of_type_Boolean);
  }
  
  private void o()
  {
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new VideoPlayerView.1(this));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new VideoPlayerView.2(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFollowStateChangeListener(new VideoPlayerView.3(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new VideoPlayerView.4(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new VideoPlayerView.5(this));
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new VideoPlayerView.6(this));
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(new VideoPlayerView.7(this));
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void p()
  {
    if ((a() != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      if (a().isPlaying())
      {
        g();
        return;
      }
      f();
    }
  }
  
  private void q()
  {
    if (this.jdField_h_of_type_Boolean) {
      x();
    } else {
      y();
    }
    this.jdField_g_of_type_Boolean = true;
  }
  
  private void r()
  {
    s();
    z();
    this.jdField_g_of_type_AndroidViewView = findViewById(2131370315);
    this.jdField_h_of_type_AndroidViewView = findViewById(2131370316);
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131369548));
    setVideoCover(this.jdField_b_of_type_ComTencentImageURLImageView);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131366918);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)findViewById(2131379687));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131369443));
    this.jdField_f_of_type_AndroidViewView = findViewById(2131381137);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379730));
    t();
    if (a() != null) {
      a().setXYaxis(2);
    }
    NetworkManager.registNetStatusListener(this);
  }
  
  private void s()
  {
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376775);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379972));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379930));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379971));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369367));
    this.jdField_i_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370233);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370327);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370337);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369552));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369554));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369551));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131369550));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131377129));
  }
  
  private void t()
  {
    HashMap localHashMap = jdField_a_of_type_JavaUtilHashMap;
    View localView = this.jdField_b_of_type_AndroidViewView;
    Integer localInteger = Integer.valueOf(0);
    localHashMap.put(localView, localInteger);
    jdField_a_of_type_JavaUtilHashMap.put(this.jdField_d_of_type_AndroidWidgetImageView, localInteger);
    jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_AndroidWidgetImageView, localInteger);
    jdField_a_of_type_JavaUtilHashMap.put(this.jdField_c_of_type_AndroidWidgetImageView, localInteger);
    jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetSeekBar, localInteger);
    jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetImageView, localInteger);
    jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_b_of_type_AndroidViewView.getId(), true);
    jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_g_of_type_AndroidViewView.getId(), true);
    jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_h_of_type_AndroidViewView.getId(), true);
  }
  
  private void u()
  {
    this.jdField_d_of_type_JavaLangString = null;
    a().removeCallbacksAndMessages(null);
  }
  
  private void v()
  {
    b(1);
    this.r = false;
    Object localObject = this.jdField_b_of_type_AndroidViewView;
    if ((localObject != null) && (!this.l)) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.jdField_i_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130838976);
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      d(true);
    }
    localObject = this.jdField_e_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    B();
    a().removeMessages(3);
  }
  
  private void w()
  {
    Object localObject1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
    if ((localObject1 != null) && (((CertifiedAccountMeta.StFeed)localObject1).poster != null) && (a() != null))
    {
      long l1 = System.currentTimeMillis() - this.jdField_d_of_type_Long;
      localObject1 = new StringBuilder();
      int i1;
      if (l1 >= a().getDurationMs()) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      String str = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(a().getDurationMs());
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1);
      localStringBuilder.append("");
      VSReporter.a(str, "auth_video", "play", 0, 0, new String[] { localObject2, localStringBuilder.toString(), localObject1, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get() });
    }
    if (c() > 0)
    {
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("time_cost", Long.valueOf(a()));
      ((HashMap)localObject1).put("count", Integer.valueOf(c()));
      ((HashMap)localObject1).put("url", this.jdField_d_of_type_JavaLangString);
      VSReporter.a("subscribe_account_video_play_extra_buffer", VSReporter.b((HashMap)localObject1));
    }
    VSReporter.a("subscribe_account_video_download", VSReporter.a(VSReporter.a(Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue(), 0L, this.jdField_d_of_type_JavaLangString, 0L)));
    if (a() != null)
    {
      double d2 = a().getCurrentPositionMs();
      double d1 = a().getDurationMs();
      if ((d2 > 0.0D) && (d1 > 0.0D) && (d2 <= d1))
      {
        Double.isNaN(d2);
        Double.isNaN(d1);
        d2 /= d1;
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("rate", String.format("%.2f", new Object[] { Double.valueOf(d2 * 100.0D) }));
        ((HashMap)localObject1).put("url", this.jdField_d_of_type_JavaLangString);
        ((HashMap)localObject1).put("attach_info", String.valueOf(d1));
        VSReporter.a("subscribe_account_video_play_complete_rate", VSReporter.b((HashMap)localObject1));
      }
    }
  }
  
  private void x()
  {
    if ((this.jdField_h_of_type_Boolean) && (!this.jdField_i_of_type_Boolean))
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        a((View)localIterator.next(), 1, 0);
      }
      this.jdField_h_of_type_Boolean = false;
    }
  }
  
  private void y()
  {
    if (!this.jdField_h_of_type_Boolean)
    {
      Object localObject = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        a((View)((Iterator)localObject).next(), 0, 1);
      }
      this.jdField_h_of_type_Boolean = true;
      localObject = this.jdField_c_of_type_AndroidViewView;
      if ((localObject != null) && (((View)localObject).getVisibility() == 8)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  private void z()
  {
    this.jdField_j_of_type_AndroidViewView = findViewById(2131366910);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView = ((VideoNextFeedsView)this.jdField_j_of_type_AndroidViewView.findViewById(2131380969));
    this.jdField_k_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131370317);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_j_of_type_AndroidViewView.findViewById(2131366909));
    this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131369364));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_j_of_type_AndroidViewView.findViewById(2131370255));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131379690));
    this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131367388));
    this.jdField_a_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131379849);
    VideoPlayerView.13 local13 = new VideoPlayerView.13(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(local13);
    this.jdField_k_of_type_AndroidViewView.setOnClickListener(local13);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setOnClickListener(new VideoPlayerView.14(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setOnCounterListener(new VideoPlayerView.15(this));
  }
  
  protected int a()
  {
    return 2131558782;
  }
  
  public SeekBar a()
  {
    return this.jdField_a_of_type_AndroidWidgetSeekBar;
  }
  
  public ExtraTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  protected void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  protected void a(long paramLong1, long paramLong2) {}
  
  protected void a(Context paramContext, View paramView)
  {
    r();
    o();
  }
  
  protected void a(Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localImageView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 2130838978;
      } else {
        i1 = 2130838977;
      }
      localImageView.setImageResource(i1);
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    paramArrayOfInt = this.jdField_c_of_type_AndroidWidgetTextView;
    if (paramArrayOfInt != null)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int i1;
      if (arrayOfInt[0] > arrayOfInt[1]) {
        i1 = 25;
      } else {
        i1 = 12;
      }
      paramArrayOfInt.setMaxEms(i1);
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void b()
  {
    super.b();
    w();
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = jdField_a_of_type_AndroidUtilSparseBooleanArray;
    if (localObject != null) {
      ((SparseBooleanArray)localObject).clear();
    }
    localObject = jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    a().removeCallbacksAndMessages(null);
  }
  
  protected void b(long paramLong1, long paramLong2) {}
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
  }
  
  public void b(boolean paramBoolean)
  {
    VideoNextFeedsView localVideoNextFeedsView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView;
    if (localVideoNextFeedsView != null) {
      localVideoNextFeedsView.a(paramBoolean);
    }
  }
  
  public void c(View paramView)
  {
    jdField_a_of_type_JavaUtilHashMap.put(paramView, Integer.valueOf(paramView.getVisibility()));
  }
  
  public boolean c()
  {
    if ((a() != null) && (a() != null))
    {
      if (h()) {
        I();
      }
      ThreadManager.getUIHandler().postDelayed(new VideoPlayerView.8(this), 500L);
      return true;
    }
    QLog.d("VideoPlayerView", 4, "enterFloat to early, player is not init");
    return false;
  }
  
  public boolean d()
  {
    return this.m;
  }
  
  public boolean e()
  {
    return (a() != null) && (a().isPlaying());
  }
  
  public void f()
  {
    if (a() != null)
    {
      b(5);
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_e_of_type_Long > 0L))
      {
        this.jdField_d_of_type_Long -= System.currentTimeMillis() - this.jdField_e_of_type_Long;
        this.jdField_e_of_type_Long = 0L;
      }
      this.jdField_a_of_type_Boolean = false;
      super.f();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener;
      if (localObject != null) {
        ((IVideoOuterStatusListener)localObject).onVideoStart((int)a().getDurationMs());
      }
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setImageResource(2130838975);
      }
    }
  }
  
  public boolean f()
  {
    return this.q;
  }
  
  public void g()
  {
    if (a() != null)
    {
      b(7);
      super.g();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setImageResource(2130838976);
      }
    }
  }
  
  public boolean g()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      I();
      return true;
    }
    return false;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    localArrayList.add(CommentListShowStateEvent.class);
    localArrayList.add(SharePanelShowStateEvent.class);
    return localArrayList;
  }
  
  public void h()
  {
    w();
    b(8);
    super.h();
  }
  
  public boolean h()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != -1001)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return false;
        }
        paramMessage = this.jdField_e_of_type_AndroidViewView;
        if (paramMessage != null)
        {
          paramMessage.setVisibility(8);
          return false;
        }
      }
      else
      {
        x();
        return false;
      }
    }
    else
    {
      if (this.jdField_e_of_type_Boolean) {
        i1 = paramMessage.arg2 - paramMessage.arg1;
      } else {
        i1 = paramMessage.arg1;
      }
      int i2 = i1 / 1000;
      i1 = i2 / 60;
      i2 %= 60;
      if ((a() != null) && (a().getCurrentPositionMs() > a().getDurationMs() / 2L) && (!this.r)) {
        G();
      }
      if (!this.m)
      {
        TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        if (localTextView != null) {
          localTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
        }
        if ((this.jdField_a_of_type_ComTencentBizSubscribeFrameworkBaseVideoViewListenerSets != null) && (((Boolean)paramMessage.obj).booleanValue()))
        {
          this.jdField_a_of_type_ComTencentBizSubscribeFrameworkBaseVideoViewListenerSets.a(String.format("%02d:%02d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }), paramMessage.arg2, paramMessage.arg1);
          return false;
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener != null) && (((Boolean)paramMessage.obj).booleanValue()))
      {
        this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener.onVideoProgressUpdate(paramMessage.arg1);
      }
    }
    return false;
  }
  
  protected void k()
  {
    super.k();
    if ((this.jdField_g_of_type_Boolean) || (this.jdField_i_of_type_Boolean))
    {
      this.jdField_e_of_type_Int = 0;
      this.jdField_g_of_type_Boolean = false;
    }
    int i1 = this.jdField_e_of_type_Int;
    if (i1 > 120)
    {
      a().sendEmptyMessage(2);
      return;
    }
    this.jdField_e_of_type_Int = (i1 + 1);
  }
  
  protected void l() {}
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener = ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(new VideoPlayerView.9(this));
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFullScreenViewClickListener(new VideoPlayerView.10(this));
    String str = ((IFloatingWrapperManager)QRoute.api(IFloatingWrapperManager.class)).getFloatingVideoWrapperName();
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setWindowClickListener(str, new VideoPlayerView.11(this));
  }
  
  public void n()
  {
    super.f();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_k_of_type_Boolean = false;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    a().post(new VideoPlayerView.18(this));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_k_of_type_Boolean = true;
    VideoNextFeedsView localVideoNextFeedsView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView;
    if (localVideoNextFeedsView != null) {
      localVideoNextFeedsView.b();
    }
    a().removeCallbacksAndMessages(null);
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    super.onError(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
    a().post(new VideoPlayerView.19(this, paramInt1));
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    super.onInfo(paramISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
    a().post(new VideoPlayerView.20(this, paramInt));
    return false;
  }
  
  public void onNetworkChanged(String paramString1, String paramString2)
  {
    if (!"wifi".equals(paramString2)) {
      a().post(new VideoPlayerView.21(this));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FollowUpdateEvent))
    {
      paramSimpleBaseEvent = (FollowUpdateEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.followStatus == 0)
      {
        localObject = this.jdField_b_of_type_JavaUtilHashMap;
        if (localObject != null) {
          ((HashMap)localObject).remove(paramSimpleBaseEvent.useId);
        }
      }
      else
      {
        localObject = this.jdField_b_of_type_JavaUtilHashMap;
        if (localObject != null) {
          ((HashMap)localObject).put(paramSimpleBaseEvent.useId, Boolean.valueOf(true));
        }
      }
      Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      if (localObject != null) {
        ((CertifiedAccountMeta.StFeed)localObject).poster.followState.set(paramSimpleBaseEvent.followStatus);
      }
    }
    else
    {
      if ((paramSimpleBaseEvent instanceof CommentListShowStateEvent))
      {
        this.s = ((CommentListShowStateEvent)paramSimpleBaseEvent).shown;
        return;
      }
      if ((paramSimpleBaseEvent instanceof SharePanelShowStateEvent)) {
        this.s = ((SharePanelShowStateEvent)paramSimpleBaseEvent).shown;
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    super.onStartTrackingTouch(paramSeekBar);
    this.jdField_i_of_type_Boolean = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    super.onStopTrackingTouch(paramSeekBar);
    this.jdField_i_of_type_Boolean = false;
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    super.onVideoPrepared(paramISuperPlayer);
    a().post(new VideoPlayerView.17(this, paramISuperPlayer));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (h())
    {
      SubscribeVideoDetailFragment localSubscribeVideoDetailFragment = this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment;
      if ((localSubscribeVideoDetailFragment != null) && (localSubscribeVideoDetailFragment.getBaseActivity() != null)) {
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getBaseActivity());
      }
    }
  }
  
  public void setCleanMode(boolean paramBoolean)
  {
    this.l = paramBoolean;
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 8;
      } else {
        i1 = 0;
      }
      localView.setVisibility(i1);
    }
  }
  
  public void setContinueFeeds(List<CertifiedAccountMeta.StFeed> paramList)
  {
    if (paramList != null)
    {
      VideoNextFeedsView localVideoNextFeedsView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView;
      if (localVideoNextFeedsView != null) {
        localVideoNextFeedsView.setData(paramList);
      }
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setHostFragment(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment = paramSubscribeVideoDetailFragment;
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getBaseActivity() != null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getBaseActivity()).mSystemBarComp;
      this.jdField_g_of_type_Int = LiuHaiUtils.b(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getBaseActivity());
    }
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    if (a() != null) {
      a().setLoopback(paramBoolean);
    }
  }
  
  public void setNeedWifiTips(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void setNextVideoClickListener(View.OnClickListener paramOnClickListener)
  {
    ImageView localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOutPutMute(boolean paramBoolean)
  {
    if (a() != null) {
      a().setOutputMute(paramBoolean);
    }
  }
  
  public void setPreviewVideoClickListener(View.OnClickListener paramOnClickListener)
  {
    ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setRevertProgress(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setVideoFeeds(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    setVideoPath(paramStFeed.video.fileId.get(), paramStFeed.video.playUrl.get());
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
      SubImageLoader.a(paramStFeed.poster.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
    }
    paramStFeed = this.jdField_c_of_type_AndroidWidgetTextView;
    if (paramStFeed != null) {
      paramStFeed.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get());
    }
  }
  
  public void setVideoPath(String paramString1, String paramString2)
  {
    u();
    v();
    VSReporter.a();
    String str = paramString1;
    Object localObject = paramString2;
    if (!StringUtil.a(paramString2))
    {
      str = paramString1;
      localObject = paramString2;
      if (a(paramString2))
      {
        localObject = Uri.parse(paramString2);
        paramString2 = paramString1;
        if (localObject != null)
        {
          ((Uri)localObject).getQueryParameter("playerformat");
          paramString2 = paramString1;
          if (StringUtil.a(paramString1)) {
            paramString2 = ((Uri)localObject).getQueryParameter("vid");
          }
        }
        localObject = null;
        str = paramString2;
      }
    }
    if (localObject != null) {
      this.jdField_d_of_type_JavaLangString = ((String)localObject);
    } else {
      this.jdField_d_of_type_JavaLangString = str;
    }
    y();
    this.jdField_i_of_type_Boolean = true;
    super.setVideoPath(str, (String)localObject, 0);
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    VSReporter.a("subscribe_account_video_start_play", VSReporter.a(VSReporter.a(0L, 0L, this.jdField_d_of_type_JavaLangString, 0L)));
    VSReporter.a("subscribe_account_video_start_download", VSReporter.a(VSReporter.a(0L, 0L, this.jdField_d_of_type_JavaLangString, 0L)));
    this.jdField_d_of_type_Long = System.currentTimeMillis();
  }
  
  public void setVideoViewCover(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentImageURLImageView != null)
    {
      this.jdField_c_of_type_JavaLangString = paramString;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130842022);
        localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130842022);
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramString != null)
        {
          this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setWifiAutoPlay(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView
 * JD-Core Version:    0.7.0.1
 */
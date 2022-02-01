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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.impl.uiwrapper.FloatingVideoWrapper;
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
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_j_of_type_AndroidViewView != null) {
      this.jdField_j_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    Object localObject;
    int i1;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getLayoutParams();
      if (h())
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout;
        if (!h()) {
          break label383;
        }
        i1 = 0;
        label124:
        ((LinearLayout)localObject).setVisibility(i1);
      }
      if ((!h()) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null)) {
        break label420;
      }
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get());
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
        SubImageLoader.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.icon.get(), this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView);
      }
      if (this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView != null)
      {
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setOnlyFollowMode(true);
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFeedData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFollowStateChangeListener(new VideoPlayerView.16(this));
      }
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        if ((!(getContext() instanceof Activity)) || (((Activity)getContext()).getRequestedOrientation() != 0)) {
          break label389;
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(2, this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getId());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        ((LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.getLayoutParams()).rightMargin = ImmersiveUtils.dpToPx(12.0F);
        this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.requestLayout();
      }
      if (this.jdField_k_of_type_AndroidViewView != null) {
        this.jdField_k_of_type_AndroidViewView.setVisibility(8);
      }
    }
    label383:
    while (this.jdField_k_of_type_AndroidViewView == null) {
      for (;;)
      {
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
        break;
        i1 = 8;
        break label124;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        ((LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.getLayoutParams()).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 0);
      }
    }
    label389:
    label420:
    this.jdField_k_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void B()
  {
    if ((this.jdField_j_of_type_AndroidViewView != null) && (this.jdField_j_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.b();
    }
  }
  
  private void C()
  {
    if (a() != null) {
      if (a().getRenderViewWidth() <= a().getRenderViewHeight()) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.q = bool;
      return;
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
    if (this.q)
    {
      if ((getContext() instanceof Activity)) {
        ((Activity)getContext()).setRequestedOrientation(0);
      }
      b(new int[] { this.jdField_b_of_type_ArrayOfInt[1], this.jdField_b_of_type_ArrayOfInt[0] });
    }
    for (;;)
    {
      a(8);
      f(true);
      E();
      ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, false);
      return;
      b(new int[] { this.jdField_b_of_type_ArrayOfInt[0], this.jdField_b_of_type_ArrayOfInt[1] });
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      F();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839118);
    }
  }
  
  private void F()
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && ((getContext() instanceof Activity))) {
      if (((Activity)getContext()).getRequestedOrientation() != 0) {
        break label42;
      }
    }
    label42:
    for (int i1 = 25;; i1 = 12)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setMaxEms(i1);
      return;
    }
  }
  
  private void G()
  {
    int i2 = 0;
    label114:
    View localView;
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)
    {
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.get() == 0) && (this.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()) == null)) {
        break label233;
      }
      i1 = 1;
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView != null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setOnlyFollowMode(true);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setFeedData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
      }
      if ((i1 != 0) || (this.r) || (!h())) {
        break label238;
      }
      i1 = 1;
      if (this.jdField_e_of_type_AndroidViewView != null)
      {
        if (i1 != 0)
        {
          this.r = true;
          if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
            VSReporter.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_video", "half_exp", 0, 0, new String[] { "", "", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
          }
        }
        localView = this.jdField_e_of_type_AndroidViewView;
        if (i1 == 0) {
          break label243;
        }
      }
    }
    label233:
    label238:
    label243:
    for (int i1 = i2;; i1 = 8)
    {
      localView.setVisibility(i1);
      a().sendEmptyMessageDelayed(3, 5000L);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label114;
    }
  }
  
  private void H()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839120);
    }
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void I()
  {
    if ((getContext() instanceof Activity))
    {
      ((Activity)getContext()).setRequestedOrientation(1);
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setMaxEms(12);
      }
    }
    b(this.jdField_a_of_type_ArrayOfInt);
    a(0);
    f(false);
    H();
    if (this.jdField_f_of_type_Int == 10) {
      A();
    }
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, true);
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
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
    String str;
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.a();
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.c((CertifiedAccountMeta.StFeed)localObject);
        str = ((CertifiedAccountMeta.StFeed)localObject).poster.id.get();
        if (!paramBoolean) {
          break label85;
        }
      }
    }
    label85:
    for (Object localObject = "next_play";; localObject = "next_clk")
    {
      VSReporter.b(str, "auth_video", (String)localObject, 0, 0, new String[0]);
      if (this.jdField_b_of_type_ComTencentImageURLImageView != null)
      {
        this.jdField_b_of_type_ComTencentImageURLImageView.setBackgroundResource(0);
        this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      return;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    int i2 = 8;
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (paramBoolean)
      {
        i1 = 0;
        ((ProgressBar)localObject).setVisibility(i1);
      }
    }
    else if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (int i1 = i2;; i1 = 0)
    {
      ((ImageView)localObject).setVisibility(i1);
      return;
      i1 = 8;
      break;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (!LiuHaiUtils.b()) {}
    do
    {
      do
      {
        return;
        if ((!paramBoolean) || (this.q)) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) {
          this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.a(true, this.jdField_g_of_type_Int);
        }
      } while (this.jdField_b_of_type_AndroidViewView == null);
      this.jdField_b_of_type_AndroidViewView.setPadding(0, this.jdField_g_of_type_Int, 0, 0);
      return;
      if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.a(false, this.jdField_g_of_type_Int);
      }
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
  }
  
  private void f(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    View localView;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity() != null))
    {
      localView = this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity().getWindow().getDecorView();
      if (!this.jdField_d_of_type_Boolean) {
        break label126;
      }
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(2, 0);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity().getWindow().setFlags(1024, 1024);
      LiuHaiUtils.c(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
      VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setUIState(paramBoolean, this.q);
      }
      e(this.jdField_d_of_type_Boolean);
      return;
      label126:
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(0, 10);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity().getWindow().clearFlags(1024);
      LiuHaiUtils.b(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFD);
    }
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
      if (a().isPlaying()) {
        g();
      }
    }
    else {
      return;
    }
    f();
  }
  
  private void q()
  {
    if (this.jdField_h_of_type_Boolean) {
      x();
    }
    for (;;)
    {
      this.jdField_g_of_type_Boolean = true;
      return;
      y();
    }
  }
  
  private void r()
  {
    s();
    z();
    this.jdField_g_of_type_AndroidViewView = findViewById(2131370674);
    this.jdField_h_of_type_AndroidViewView = findViewById(2131370675);
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131369862));
    setVideoCover(this.jdField_b_of_type_ComTencentImageURLImageView);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131367074);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)findViewById(2131380367));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131369753));
    this.jdField_f_of_type_AndroidViewView = findViewById(2131381934);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380417));
    t();
    if (a() != null) {
      a().setXYaxis(2);
    }
    NetworkManager.registNetStatusListener(this);
  }
  
  private void s()
  {
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377322);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380700));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380651));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380699));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369668));
    this.jdField_i_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370580);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370686);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370698);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369866));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369869));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369865));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131369864));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131377693));
  }
  
  private void t()
  {
    jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_AndroidViewView, Integer.valueOf(0));
    jdField_a_of_type_JavaUtilHashMap.put(this.jdField_d_of_type_AndroidWidgetImageView, Integer.valueOf(0));
    jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_AndroidWidgetImageView, Integer.valueOf(0));
    jdField_a_of_type_JavaUtilHashMap.put(this.jdField_c_of_type_AndroidWidgetImageView, Integer.valueOf(0));
    jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetSeekBar, Integer.valueOf(0));
    jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetImageView, Integer.valueOf(0));
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
    if ((this.jdField_b_of_type_AndroidViewView != null) && (!this.l)) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_i_of_type_AndroidViewView != null) {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839123);
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      d(true);
    }
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    B();
    a().removeMessages(3);
  }
  
  private void w()
  {
    long l1;
    Object localObject;
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null) && (a() != null))
    {
      l1 = System.currentTimeMillis() - this.jdField_d_of_type_Long;
      localObject = new StringBuilder();
      if (l1 < a().getDurationMs()) {
        break label405;
      }
    }
    label405:
    for (int i1 = 1;; i1 = 0)
    {
      localObject = i1 + "";
      VSReporter.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_video", "play", 0, 0, new String[] { a().getDurationMs() + "", l1 + "", localObject, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get() });
      if (c() > 0)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("time_cost", Long.valueOf(a()));
        ((HashMap)localObject).put("count", Integer.valueOf(c()));
        ((HashMap)localObject).put("url", this.jdField_d_of_type_JavaLangString);
        VSReporter.a("subscribe_account_video_play_extra_buffer", VSReporter.b((HashMap)localObject));
      }
      VSReporter.a("subscribe_account_video_download", VSReporter.a(VSReporter.a(Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue(), 0L, this.jdField_d_of_type_JavaLangString, 0L)));
      if (a() != null)
      {
        double d2 = a().getCurrentPositionMs();
        double d1 = a().getDurationMs();
        if ((d2 > 0.0D) && (d1 > 0.0D) && (d2 <= d1))
        {
          d2 /= d1;
          localObject = new HashMap();
          ((HashMap)localObject).put("rate", String.format("%.2f", new Object[] { Double.valueOf(d2 * 100.0D) }));
          ((HashMap)localObject).put("url", this.jdField_d_of_type_JavaLangString);
          ((HashMap)localObject).put("attach_info", String.valueOf(d1));
          VSReporter.a("subscribe_account_video_play_complete_rate", VSReporter.b((HashMap)localObject));
        }
      }
      return;
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
      Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        a((View)localIterator.next(), 0, 1);
      }
      this.jdField_h_of_type_Boolean = true;
      if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 8)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  private void z()
  {
    this.jdField_j_of_type_AndroidViewView = findViewById(2131367064);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView = ((VideoNextFeedsView)this.jdField_j_of_type_AndroidViewView.findViewById(2131381737));
    this.jdField_k_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131370676);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_j_of_type_AndroidViewView.findViewById(2131367063));
    this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131369663));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_j_of_type_AndroidViewView.findViewById(2131370604));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131380370));
    this.jdField_b_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131367633));
    this.jdField_a_of_type_AndroidViewView = this.jdField_j_of_type_AndroidViewView.findViewById(2131380565);
    VideoPlayerView.13 local13 = new VideoPlayerView.13(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(local13);
    this.jdField_k_of_type_AndroidViewView.setOnClickListener(local13);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setOnClickListener(new VideoPlayerView.14(this));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setOnCounterListener(new VideoPlayerView.15(this));
  }
  
  public int a()
  {
    return 2131558884;
  }
  
  public SeekBar a()
  {
    return this.jdField_a_of_type_AndroidWidgetSeekBar;
  }
  
  public ExtraTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(Context paramContext, View paramView)
  {
    r();
    o();
  }
  
  public void a(Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (int i1 = 2130839125;; i1 = 2130839124)
    {
      localImageView.setImageResource(i1);
      return;
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      paramArrayOfInt = this.jdField_c_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_ArrayOfInt[0] <= this.jdField_a_of_type_ArrayOfInt[1]) {
        break label41;
      }
    }
    label41:
    for (int i1 = 25;; i1 = 12)
    {
      paramArrayOfInt.setMaxEms(i1);
      return;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    super.b();
    w();
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
      jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
    }
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.clear();
    }
    a().removeCallbacksAndMessages(null);
  }
  
  public void b(long paramLong1, long paramLong2) {}
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.a(paramBoolean);
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
      if (this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener.onVideoStart((int)a().getDurationMs());
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839122);
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
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839123);
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
    switch (paramMessage.what)
    {
    }
    label235:
    do
    {
      do
      {
        return false;
        if (this.jdField_e_of_type_Boolean) {}
        for (int i1 = paramMessage.arg2 - paramMessage.arg1;; i1 = paramMessage.arg1)
        {
          int i2 = i1 / 1000 / 60;
          i1 = i1 / 1000 % 60;
          if ((a() != null) && (a().getCurrentPositionMs() > a().getDurationMs() / 2L) && (!this.r)) {
            G();
          }
          if (this.m) {
            break label235;
          }
          if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) }));
          }
          if ((this.jdField_a_of_type_ComTencentBizSubscribeFrameworkBaseVideoViewListenerSets == null) || (!((Boolean)paramMessage.obj).booleanValue())) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizSubscribeFrameworkBaseVideoViewListenerSets.a(String.format("%02d:%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) }), paramMessage.arg2, paramMessage.arg1);
          return false;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener == null) || (!((Boolean)paramMessage.obj).booleanValue()));
      this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener.onVideoProgressUpdate(paramMessage.arg1);
      return false;
      x();
      return false;
    } while (this.jdField_e_of_type_AndroidViewView == null);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    return false;
  }
  
  public void k()
  {
    super.k();
    if ((this.jdField_g_of_type_Boolean) || (this.jdField_i_of_type_Boolean))
    {
      this.jdField_e_of_type_Int = 0;
      this.jdField_g_of_type_Boolean = false;
    }
    if (this.jdField_e_of_type_Int > 120)
    {
      a().sendEmptyMessage(2);
      return;
    }
    this.jdField_e_of_type_Int += 1;
  }
  
  public void l() {}
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener = ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(new VideoPlayerView.9(this));
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setFullScreenViewClickListener(new VideoPlayerView.10(this));
    ((IQQFloatingWindow)QRoute.api(IQQFloatingWindow.class)).setWindowClickListener(FloatingVideoWrapper.CLASS_NAME, new VideoPlayerView.11(this));
  }
  
  public void n()
  {
    super.f();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_k_of_type_Boolean = false;
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    a().post(new VideoPlayerView.18(this));
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.b();
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
    if ((paramSimpleBaseEvent instanceof FollowUpdateEvent)) {
      if (((FollowUpdateEvent)paramSimpleBaseEvent).followStatus == 0) {
        if (this.jdField_b_of_type_JavaUtilHashMap == null) {}
      }
    }
    do
    {
      this.jdField_b_of_type_JavaUtilHashMap.remove(((FollowUpdateEvent)paramSimpleBaseEvent).useId);
      for (;;)
      {
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
          this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.followState.set(((FollowUpdateEvent)paramSimpleBaseEvent).followStatus);
        }
        return;
        if (this.jdField_b_of_type_JavaUtilHashMap != null) {
          this.jdField_b_of_type_JavaUtilHashMap.put(((FollowUpdateEvent)paramSimpleBaseEvent).useId, Boolean.valueOf(true));
        }
      }
      if ((paramSimpleBaseEvent instanceof CommentListShowStateEvent))
      {
        this.s = ((CommentListShowStateEvent)paramSimpleBaseEvent).shown;
        return;
      }
    } while (!(paramSimpleBaseEvent instanceof SharePanelShowStateEvent));
    this.s = ((SharePanelShowStateEvent)paramSimpleBaseEvent).shown;
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
    if ((h()) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity() != null)) {
      VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
    }
  }
  
  public void setCleanMode(boolean paramBoolean)
  {
    this.l = paramBoolean;
    View localView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label30;
      }
    }
    label30:
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public void setContinueFeeds(List<CertifiedAccountMeta.StFeed> paramList)
  {
    if ((paramList != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetVideoNextFeedsView.setData(paramList);
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setHostFragment(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment = paramSubscribeVideoDetailFragment;
    if (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity() != null)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity()).mSystemBarComp;
      this.jdField_g_of_type_Int = LiuHaiUtils.b(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribeVideoDetailFragment.getActivity());
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
    if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
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
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setRevertProgress(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setVideoFeeds(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {}
    do
    {
      return;
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
      setVideoPath(paramStFeed.video.fileId.get(), paramStFeed.video.playUrl.get());
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
        SubImageLoader.a(paramStFeed.poster.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      }
    } while (this.jdField_c_of_type_AndroidWidgetTextView == null);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get());
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
    if (localObject != null) {}
    for (this.jdField_d_of_type_JavaLangString = ((String)localObject);; this.jdField_d_of_type_JavaLangString = str)
    {
      y();
      this.jdField_i_of_type_Boolean = true;
      super.setVideoPath(str, (String)localObject, 0);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      VSReporter.a("subscribe_account_video_start_play", VSReporter.a(VSReporter.a(0L, 0L, this.jdField_d_of_type_JavaLangString, 0L)));
      VSReporter.a("subscribe_account_video_start_download", VSReporter.a(VSReporter.a(0L, 0L, this.jdField_d_of_type_JavaLangString, 0L)));
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
  
  public void setVideoViewCover(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentImageURLImageView != null) {
      this.jdField_c_of_type_JavaLangString = paramString;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130842125);
      localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130842125);
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramString != null) {
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void setWifiAutoPlay(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoPlayerView
 * JD-Core Version:    0.7.0.1
 */
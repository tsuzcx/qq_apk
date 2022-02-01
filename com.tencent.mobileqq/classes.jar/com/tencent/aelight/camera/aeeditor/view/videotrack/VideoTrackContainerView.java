package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.RequiresApi;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IDragDropScrollListener;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IDragView;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IStateChangeListener;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IValueChangeListener;
import com.tencent.aelight.camera.aeeditor.view.playtrack.view.PlayTrackExpandWidthView;
import com.tencent.aelight.camera.aeeditor.view.reorder.ClipItemLongClickListener;
import com.tencent.aelight.camera.aeeditor.view.reorder.ReorderViewIdManager;
import com.tencent.aelight.camera.aeeditor.view.timebar.ScaleTimeBar;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;
import com.tencent.aelight.camera.aeeditor.view.timeline.EffectTimelineView;
import com.tencent.aelight.camera.aeeditor.view.timeline.TimeLineViewListener;
import com.tencent.aelight.camera.aeeditor.view.transition.listener.OnTransitionListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbListener;
import com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import com.tencent.weseevideo.model.effect.VideoTransitionModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoTrackContainerView
  extends HorizontalScrollView
  implements IStateChangeListener, IValueChangeListener, TimeLineViewListener, VideoTrackTimeLineView.OnSlideChangedListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 2147483647L;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private MvVideoViewModel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel;
  private IDragDropScrollListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIDragDropScrollListener;
  private ClipItemLongClickListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderClipItemLongClickListener = null;
  private ScaleTimeBar jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar;
  private ScaleAdapter jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter;
  private OnTransitionListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewTransitionListenerOnTransitionListener;
  private TrackSelectedStateChangeListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackTrackSelectedStateChangeListener;
  private VideoTrackContainerView.OnScrollStoppedListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView$OnScrollStoppedListener;
  private VideoTrackContainerView.OnStartTimeChangedListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView$OnStartTimeChangedListener;
  private VideoTrackContainerView.OnVideoClipClickListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView$OnVideoClipClickListener;
  private VideoTrackStoreListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackStoreListener;
  private VideoThumbListener jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderVideoThumbListener = new VideoTrackContainerView.14(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoTrackContainerView.1(this);
  private List<CutModelKt> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private List<VideoTransitionModel> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private List<VideoTrackTimeLineView> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private List<ImageView> jdField_d_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = false;
  
  public VideoTrackContainerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoTrackContainerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoTrackContainerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    h();
  }
  
  private int a(ImageView paramImageView)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    int k = -1;
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      int m = k + 1;
      k = m;
      if (localVideoTrackTimeLineView.getTag() != null)
      {
        k = m;
        if (localVideoTrackTimeLineView.getTag() == paramImageView) {
          return m;
        }
      }
    }
    return -1;
  }
  
  private long a(int paramInt)
  {
    return (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(Math.abs(paramInt)) * 70 / this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a());
  }
  
  @RequiresApi(api=17)
  private ImageView a()
  {
    ImageView localImageView = new ImageView(getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      localImageView.setId(View.generateViewId());
    }
    localImageView.setImageResource(2064056526);
    localImageView.setOnClickListener(new VideoTrackContainerView.5(this));
    return localImageView;
  }
  
  private VideoTransitionModel a(List<VideoTransitionModel> paramList, int paramInt)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VideoTransitionModel localVideoTransitionModel = (VideoTransitionModel)paramList.next();
        if (localVideoTransitionModel.getTransitionPosition() == paramInt) {
          return localVideoTransitionModel;
        }
      }
    }
    return null;
  }
  
  private void a(long paramLong)
  {
    ScaleAdapter localScaleAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter;
    if (localScaleAdapter != null) {
      localScaleAdapter.a(paramLong);
    }
  }
  
  private void a(long paramLong, VideoTrackTimeLineView paramVideoTrackTimeLineView, VideoResourceModelKt paramVideoResourceModelKt)
  {
    long l2 = paramVideoResourceModelKt.getScaleDuration();
    long l1 = this.jdField_a_of_type_Long;
    if (l2 + paramLong > l1)
    {
      if (paramLong > l1)
      {
        l1 = 0L;
        paramLong = paramVideoResourceModelKt.getScaleDuration();
      }
      else
      {
        l2 = paramVideoResourceModelKt.getScaleDuration();
        long l3 = this.jdField_a_of_type_Long;
        l1 -= paramLong;
        paramLong = paramLong + l2 - l3;
      }
      paramVideoTrackTimeLineView.setRedMaskViewShowTimeRange(l1, paramLong);
    }
  }
  
  private void a(View paramView)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoTrackTimeLineView)localIterator.next();
      if (((VideoTrackTimeLineView)localObject).getTag() != null)
      {
        localObject = (ImageView)((VideoTrackTimeLineView)localObject).getTag();
        if (localObject == paramView) {
          ((ImageView)localObject).setSelected(true);
        } else {
          ((ImageView)localObject).setSelected(false);
        }
      }
    }
  }
  
  private void a(IDragView paramIDragView, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { paramInt, 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(a(paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    int k = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar.getScrollX();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new VideoTrackContainerView.6(this, paramIDragView, k, paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new VideoTrackContainerView.7(this, paramIDragView));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void a(IDragView paramIDragView, long paramLong1, long paramLong2, int paramInt)
  {
    this.jdField_d_of_type_Int = this.jdField_f_of_type_Int;
    this.jdField_e_of_type_Int = this.jdField_g_of_type_Int;
    a(a());
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onTimeLineChanged >> 拖动结束，滚动到当前滑块的起始位置:");
      ((StringBuilder)localObject).append(paramIDragView.a());
      AEQLog.b("miles", ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView$OnStartTimeChangedListener;
      if (localObject != null) {
        ((VideoTrackContainerView.OnStartTimeChangedListener)localObject).a(paramIDragView.a());
      }
    }
    else if (this.jdField_b_of_type_Boolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onTimeLineChanged >> 拖动结束，滚动到当前滑块的结束位置:");
      ((StringBuilder)localObject).append(paramIDragView.b());
      AEQLog.b("miles", ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView$OnStartTimeChangedListener;
      if (localObject != null) {
        ((VideoTrackContainerView.OnStartTimeChangedListener)localObject).b(paramIDragView.b());
      }
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
    paramIDragView = a();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackStoreListener;
    if ((localObject != null) && (paramIDragView != null)) {
      ((VideoTrackStoreListener)localObject).a(paramIDragView.getUuid(), paramIDragView.getResource().getSelectTimeStartUs(), paramIDragView.getResource().getSelectTimeDurationUs());
    }
  }
  
  private void a(IDragView paramIDragView, LinearLayout.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramLayoutParams == null) {
      return;
    }
    if (!c()) {
      b(paramIDragView);
    }
    if (a(paramIDragView)) {
      paramLayoutParams.leftMargin = this.jdField_f_of_type_Int;
    } else {
      paramLayoutParams.leftMargin = (-paramIDragView.a());
    }
    if (paramBoolean) {
      paramLayoutParams.rightMargin = this.jdField_g_of_type_Int;
    } else {
      paramLayoutParams.rightMargin = (-paramIDragView.b());
    }
    paramLayoutParams.width = (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramIDragView.b() - paramIDragView.a()) + paramIDragView.a() + paramIDragView.b());
    paramLayoutParams.height = -1;
  }
  
  private boolean a(IDragView paramIDragView)
  {
    return paramIDragView.a() == 0L;
  }
  
  private float b()
  {
    return getResources().getDimension(2063990855);
  }
  
  private void b(IDragView paramIDragView)
  {
    this.jdField_f_of_type_Int = (c() / 2 - paramIDragView.a());
    this.jdField_g_of_type_Int = (c() / 2 - paramIDragView.b());
    this.jdField_d_of_type_Int = this.jdField_f_of_type_Int;
    this.jdField_e_of_type_Int = this.jdField_g_of_type_Int;
  }
  
  private void b(IDragView paramIDragView, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { paramInt, 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(a(paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    int k = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar.getScrollX();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(0)).getLayoutParams();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new VideoTrackContainerView.8(this, paramIDragView, k, paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new VideoTrackContainerView.9(this, paramIDragView));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void b(IDragView paramIDragView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
        if ((localVideoTrackTimeLineView != paramIDragView) && (localVideoTrackTimeLineView.isSelected())) {
          localVideoTrackTimeLineView.setSelected(false);
        }
      }
      ((View)paramIDragView).bringToFront();
    }
  }
  
  private int c()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private void c(IDragView paramIDragView, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { paramInt, 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(a(paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    int k = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar.getScrollX();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new VideoTrackContainerView.10(this, paramIDragView, k, paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new VideoTrackContainerView.11(this, paramIDragView));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private boolean c()
  {
    return (this.jdField_f_of_type_Int != -1) && (this.jdField_g_of_type_Int != -1);
  }
  
  private int d()
  {
    return (int)getResources().getDimension(2063990835);
  }
  
  private void d(IDragView paramIDragView, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { paramInt, 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(a(paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    int k = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar.getScrollX();
    Object localObject = this.jdField_c_of_type_JavaUtilList;
    localObject = (ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)((List)localObject).get(((List)localObject).size() - 1)).getLayoutParams();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new VideoTrackContainerView.12(this, paramIDragView, k, paramInt));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new VideoTrackContainerView.13(this, paramIDragView));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void h()
  {
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new BringToFrontLinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new VideoTrackContainerView.2(this));
    this.jdField_i_of_type_Int = ViewUtils.dip2px(40.0F);
    VideoThumbProviderManager.getInstance().registerListener(this.jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderVideoThumbListener);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ImageView localImageView = (ImageView)localIterator.next();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localImageView);
    }
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
  }
  
  private void j()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    int m = -1;
    int k = 0;
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      int i1 = m + 1;
      m = i1;
      if (localVideoTrackTimeLineView.getTag() != null)
      {
        ImageView localImageView = (ImageView)localVideoTrackTimeLineView.getTag();
        Object localObject = a(this.jdField_b_of_type_JavaUtilList, i1);
        int n;
        if (localObject != null) {
          n = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a((((VideoTransitionModel)localObject).getOverlapTime() / ((VideoTransitionModel)localObject).getSpeed()));
        } else {
          n = 0;
        }
        localObject = (LinearLayout.LayoutParams)localVideoTrackTimeLineView.getLayoutParams();
        m = i1;
        if (localObject != null)
        {
          m = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(localVideoTrackTimeLineView.b() - localVideoTrackTimeLineView.a()) + localVideoTrackTimeLineView.a() + localVideoTrackTimeLineView.b() - n;
          if (((LinearLayout.LayoutParams)localObject).width != m)
          {
            ((LinearLayout.LayoutParams)localObject).width = m;
            localVideoTrackTimeLineView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          k += ((LinearLayout.LayoutParams)localObject).leftMargin + ((LinearLayout.LayoutParams)localObject).width + ((LinearLayout.LayoutParams)localObject).rightMargin;
          localImageView.setX(k - d());
          m = i1;
        }
      }
    }
  }
  
  private void k()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.getTag() != null) {
        ((ImageView)localVideoTrackTimeLineView.getTag()).setX(localVideoTrackTimeLineView.getRight() - localVideoTrackTimeLineView.b() - d());
      }
    }
  }
  
  public float a()
  {
    if (CollectionUtils.isEmpty(this.jdField_c_of_type_JavaUtilList)) {
      return 0.0F;
    }
    Object localObject = (VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(0);
    if (localObject == null) {
      return 0.0F;
    }
    CutModelKt localCutModelKt = ((VideoTrackTimeLineView)localObject).a();
    localObject = ((VideoTrackTimeLineView)localObject).a();
    if ((localCutModelKt != null) && (localCutModelKt.getResource() != null))
    {
      if (localObject == null) {
        return 0.0F;
      }
      return ((PlayTrackExpandWidthView)localObject).getWidth() * 1.0F / (float)localCutModelKt.getResource().getScaleDuration();
    }
    return 0.0F;
  }
  
  public int a()
  {
    int k = 0;
    while (k < this.jdField_c_of_type_JavaUtilList.size())
    {
      if (((VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(k)).isSelected()) {
        return k;
      }
      k += 1;
    }
    return 0;
  }
  
  public long a()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((VideoTrackTimeLineView)localIterator.next()).a().getResource().getScaleDuration()) {}
    int k = 0;
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoTransitionModel localVideoTransitionModel = (VideoTransitionModel)localIterator.next();
      k = (int)(k + localVideoTransitionModel.getOverlapTime() / localVideoTransitionModel.getSpeed());
    }
    return l - k;
  }
  
  public long a(@NonNull View paramView, long paramLong)
  {
    return 0L;
  }
  
  public long a(IDragView paramIDragView)
  {
    long l = 0L;
    int k = 0;
    while (k < this.jdField_c_of_type_JavaUtilList.size())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(k);
      if (paramIDragView == localVideoTrackTimeLineView) {
        return l;
      }
      l += this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(localVideoTrackTimeLineView.getWidth() - localVideoTrackTimeLineView.a() - localVideoTrackTimeLineView.b());
      k += 1;
    }
    return l;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public CutModelKt a()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.isSelected()) {
        return localVideoTrackTimeLineView.a();
      }
    }
    return null;
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (getScrollX() == 0) && (paramInt2 == 0) && (getScrollY() == 0)) {
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_f_of_type_Boolean) {
      scrollBy(paramInt1 - getScrollX(), paramInt2 - getScrollY());
    }
  }
  
  public void a(@NonNull IDragView paramIDragView) {}
  
  public void a(IDragView paramIDragView, long paramLong1, long paramLong2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel;
    if ((localObject1 != null) && (((MvVideoViewModel)localObject1).a())) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel.b();
    }
    localObject1 = this.jdField_c_of_type_JavaUtilList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoTrackTimeLineView)((Iterator)localObject1).next();
      if (((VideoTrackTimeLineView)localObject2).getLocalVisibleRect(new Rect())) {
        ((VideoTrackTimeLineView)localObject2).a().invalidate();
      }
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(0)).getLayoutParams();
      localObject2 = new int[2];
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)paramIDragView;
      localVideoTrackTimeLineView.getLocationOnScreen((int[])localObject2);
      paramLong1 = 0L;
      if ((paramLong2 <= 0L) && (localObject2[0] <= b()))
      {
        a(paramIDragView, (int)localVideoTrackTimeLineView.e());
      }
      else if ((paramLong2 >= 0L) && (localObject2[0] >= c() - b()))
      {
        b(paramIDragView, (int)localVideoTrackTimeLineView.f());
      }
      else
      {
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = (this.jdField_d_of_type_Int + this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramLong2));
        localVideoTrackTimeLineView.a().scrollTo(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(localVideoTrackTimeLineView.e()), localVideoTrackTimeLineView.a().getScrollY());
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel != null)
      {
        paramIDragView = this.jdField_c_of_type_JavaUtilList.iterator();
        while (paramIDragView.hasNext()) {
          paramLong1 += ((VideoTrackTimeLineView)paramIDragView.next()).d();
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel.a(paramLong1);
      }
      return;
    }
    AEQLog.b("miles", "正在滚动，直接返回");
  }
  
  public void a(IDragView paramIDragView, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    a(paramIDragView, paramLong1, paramLong2, paramInt);
  }
  
  public void a(IDragView paramIDragView, boolean paramBoolean)
  {
    b(paramIDragView, paramBoolean);
    TrackSelectedStateChangeListener localTrackSelectedStateChangeListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackTrackSelectedStateChangeListener;
    if (localTrackSelectedStateChangeListener != null)
    {
      int k;
      if (paramBoolean) {
        k = a();
      } else {
        k = 0;
      }
      localTrackSelectedStateChangeListener.a(paramIDragView, paramBoolean, k);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (TextUtils.equals(paramString, localVideoTrackTimeLineView.a())) {
        localVideoTrackTimeLineView.e();
      }
    }
  }
  
  @RequiresApi(api=17)
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.a().getUuid().equals(paramString))
      {
        localVideoTrackTimeLineView.setShowSliderView(this.jdField_h_of_type_Boolean);
        localVideoTrackTimeLineView.setSelected(true);
        if (paramBoolean) {
          localVideoTrackTimeLineView.f();
        }
      }
    }
  }
  
  @RequiresApi(api=17)
  public void a(List<CutModelKt> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList = paramList;
      i();
      long l = 0L;
      int k = 0;
      int n;
      for (int m = 0; k < this.jdField_a_of_type_JavaUtilList.size(); m = n)
      {
        Object localObject1 = (CutModelKt)this.jdField_a_of_type_JavaUtilList.get(k);
        paramList = new VideoTrackTimeLineView(this.jdField_a_of_type_AndroidContentContext);
        paramList.setBitmapWidth(this.jdField_i_of_type_Int);
        paramList.setMediaClipModel((CutModelKt)localObject1);
        Object localObject2 = ((CutModelKt)localObject1).getResource();
        if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderClipItemLongClickListener != null) {
          paramList.setOnLongClickListener(new VideoTrackContainerView.3(this, (CutModelKt)localObject1));
        }
        n = ReorderViewIdManager.a.a(((CutModelKt)localObject1).getUuid());
        if (n != -1)
        {
          paramList.setId(n);
        }
        else
        {
          if (Build.VERSION.SDK_INT >= 17) {
            paramList.setId(View.generateViewId());
          }
          ReorderViewIdManager.a.a(((CutModelKt)localObject1).getUuid(), paramList.getId());
        }
        paramList.setStartValue(l);
        paramList.setEndValue(((VideoResourceModelKt)localObject2).getScaleDuration() + l);
        paramList.setShowSliderView(this.jdField_h_of_type_Boolean);
        paramList.setSelected(false);
        paramList.setSelectedStyle(this.jdField_c_of_type_Int);
        n = this.jdField_h_of_type_Int;
        if (n != -1) {
          paramList.setCornerRadius(n);
        }
        if (this.jdField_g_of_type_Boolean) {
          paramList.setOnClickListener(new VideoTrackContainerView.4(this, k));
        }
        paramList.setValueChangeListener(this);
        paramList.setStateChangeListener(this);
        paramList.setTimeLineViewListener(this);
        paramList.setOnSlideChangedListener(this);
        paramList.setScaleModel(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter);
        localObject1 = new LinearLayout.LayoutParams(-2, -2);
        boolean bool;
        if (k == this.jdField_a_of_type_JavaUtilList.size() - 1) {
          bool = true;
        } else {
          bool = false;
        }
        a(paramList, (LinearLayout.LayoutParams)localObject1, bool);
        a(l, paramList, (VideoResourceModelKt)localObject2);
        paramList.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramList);
        this.jdField_c_of_type_JavaUtilList.add(paramList);
        l += ((VideoResourceModelKt)localObject2).getScaleDuration();
        n = m;
        if (this.jdField_i_of_type_Boolean)
        {
          n = m;
          if (k < this.jdField_a_of_type_JavaUtilList.size() - 1)
          {
            localObject2 = a();
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(29.0F), ViewUtils.dip2px(29.0F));
            localLayoutParams.topMargin = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop();
            n = m + (((LinearLayout.LayoutParams)localObject1).leftMargin + ((LinearLayout.LayoutParams)localObject1).width + ((LinearLayout.LayoutParams)localObject1).rightMargin);
            ((ImageView)localObject2).setX(n - d());
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, localLayoutParams);
            this.jdField_d_of_type_JavaUtilList.add(localObject2);
            paramList.setTag(localObject2);
            paramList = new StringBuilder();
            paramList.append("add piece view,x:");
            paramList.append(((ImageView)localObject2).getX());
            AEQLog.a("VideoTrackContainerView", paramList.toString());
          }
        }
        k += 1;
      }
      if (this.jdField_i_of_type_Boolean) {
        b();
      }
    }
  }
  
  public void a(List<VideoTransitionModel> paramList, int paramInt)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    if (paramList == null) {
      return;
    }
    int k = -1;
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoTrackTimeLineView)localIterator.next();
      int m = k + 1;
      k = m;
      if (((VideoTrackTimeLineView)localObject).getTag() != null)
      {
        localObject = (ImageView)((VideoTrackTimeLineView)localObject).getTag();
        if (a(paramList, m) != null) {
          ((ImageView)localObject).setImageResource(2064056580);
        } else {
          ((ImageView)localObject).setImageResource(2064056526);
        }
        if (paramInt == m)
        {
          ((ImageView)localObject).setSelected(true);
          k = m;
        }
        else
        {
          ((ImageView)localObject).setSelected(false);
          k = m;
        }
      }
    }
    j();
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, EffectTimelineView paramEffectTimelineView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onTimeLineViewSelected], selected=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", view=");
    localStringBuilder.append(paramEffectTimelineView);
    AEQLog.a("VideoTrackContainerView", localStringBuilder.toString());
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter != null)
    {
      if (CollectionUtils.isEmpty(this.jdField_c_of_type_JavaUtilList)) {
        return -1;
      }
      long l2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.c();
      long l1 = 0L;
      int k = 0;
      while (k < this.jdField_c_of_type_JavaUtilList.size())
      {
        VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(k);
        if (localVideoTrackTimeLineView != null)
        {
          long l3 = localVideoTrackTimeLineView.b() - localVideoTrackTimeLineView.a();
          if ((l1 <= l2) && (l2 < l1 + l3)) {
            break label115;
          }
          l1 += l3;
        }
        k += 1;
      }
      k = -1;
      label115:
      int m = k;
      if (k == -1) {
        m = this.jdField_c_of_type_JavaUtilList.size() - 1;
      }
      return m;
    }
    return -1;
  }
  
  public long b(@NonNull View paramView, long paramLong)
  {
    return 0L;
  }
  
  public long b(IDragView paramIDragView)
  {
    long l = 0L;
    int k = 0;
    while (k < this.jdField_c_of_type_JavaUtilList.size())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)this.jdField_c_of_type_JavaUtilList.get(k);
      l += this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(localVideoTrackTimeLineView.getWidth() - localVideoTrackTimeLineView.a() - localVideoTrackTimeLineView.b());
      if (paramIDragView == localVideoTrackTimeLineView) {
        return l;
      }
      k += 1;
    }
    return l;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.getTag() != null)
      {
        ImageView localImageView = (ImageView)localVideoTrackTimeLineView.getTag();
        if (localVideoTrackTimeLineView.isSelected())
        {
          localImageView.setVisibility(8);
          AEQLog.a("VideoTrackContainerView", "refreshPieceView GONE");
          if (localObject != null)
          {
            localObject.setVisibility(8);
            AEQLog.a("VideoTrackContainerView", "refreshPieceView lastPieceView GONE");
          }
        }
        else
        {
          localImageView.setVisibility(0);
          AEQLog.a("VideoTrackContainerView", "refreshPieceView VISIBLE");
        }
        localObject = localImageView;
      }
      else if ((localObject != null) && (localVideoTrackTimeLineView.isSelected()))
      {
        localObject.setVisibility(8);
        AEQLog.a("VideoTrackContainerView", "refreshPieceView lastPieceView GONE");
      }
    }
  }
  
  public void b(IDragView paramIDragView, long paramLong1, long paramLong2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel;
    if ((localObject1 != null) && (((MvVideoViewModel)localObject1).a())) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel.b();
    }
    localObject1 = this.jdField_c_of_type_JavaUtilList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoTrackTimeLineView)((Iterator)localObject1).next();
      if (((VideoTrackTimeLineView)localObject2).getLocalVisibleRect(new Rect())) {
        ((VideoTrackTimeLineView)localObject2).a().invalidate();
      }
    }
    this.jdField_b_of_type_Boolean = true;
    if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      localObject1 = this.jdField_c_of_type_JavaUtilList;
      localObject1 = (ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)((List)localObject1).get(((List)localObject1).size() - 1)).getLayoutParams();
      localObject2 = new int[2];
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)paramIDragView;
      localVideoTrackTimeLineView.getLocationOnScreen((int[])localObject2);
      paramLong1 = 0L;
      if ((paramLong2 <= 0L) && (localObject2[0] + localVideoTrackTimeLineView.getWidth() <= b())) {
        c(paramIDragView, (int)localVideoTrackTimeLineView.g());
      } else if ((paramLong2 >= 0L) && (localObject2[0] + localVideoTrackTimeLineView.getWidth() >= c() - b())) {
        d(paramIDragView, (int)localVideoTrackTimeLineView.h());
      } else {
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = (this.jdField_e_of_type_Int - this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramLong2));
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel != null)
      {
        paramIDragView = this.jdField_c_of_type_JavaUtilList.iterator();
        while (paramIDragView.hasNext()) {
          paramLong1 += ((VideoTrackTimeLineView)paramIDragView.next()).d();
        }
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel.a(paramLong1);
      }
      return;
    }
    AEQLog.b("miles", "正在滚动，直接返回");
  }
  
  public void b(List<VideoTransitionModel> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    paramList = this.jdField_c_of_type_JavaUtilList.iterator();
    int k = -1;
    while (paramList.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)paramList.next();
      int n = k + 1;
      Object localObject = a(this.jdField_b_of_type_JavaUtilList, n);
      int m = 0;
      if (localObject != null) {
        m = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a((((VideoTransitionModel)localObject).getOverlapTime() / ((VideoTransitionModel)localObject).getSpeed()));
      }
      localObject = (LinearLayout.LayoutParams)localVideoTrackTimeLineView.getLayoutParams();
      k = n;
      if (localObject != null)
      {
        m = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(localVideoTrackTimeLineView.b() - localVideoTrackTimeLineView.a()) + localVideoTrackTimeLineView.a() + localVideoTrackTimeLineView.b() - m;
        k = n;
        if (((LinearLayout.LayoutParams)localObject).width != m)
        {
          ((LinearLayout.LayoutParams)localObject).width = m;
          localVideoTrackTimeLineView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          k = n;
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      Object localObject = this.jdField_c_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)((Iterator)localObject).next();
        if (localVideoTrackTimeLineView.isSelected())
        {
          localObject = new int[2];
          localVideoTrackTimeLineView.getLocationOnScreen((int[])localObject);
          if ((localObject[0] + localVideoTrackTimeLineView.getWidth() < c() / 2) || (localObject[0] > c() / 2)) {
            localVideoTrackTimeLineView.setSelected(false);
          }
        }
      }
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.isSelected()) {
        localVideoTrackTimeLineView.setSelected(false);
      }
    }
  }
  
  public void e()
  {
    k();
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    long l = 0L;
    int k = 0;
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      VideoResourceModelKt localVideoResourceModelKt = localVideoTrackTimeLineView.a().getResource();
      localVideoTrackTimeLineView.setStartValue(l);
      localVideoTrackTimeLineView.setEndValue(localVideoResourceModelKt.getScaleDuration() + l);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localVideoTrackTimeLineView.getLayoutParams();
      int m = this.jdField_c_of_type_JavaUtilList.size();
      boolean bool = true;
      if (k != m - 1) {
        bool = false;
      }
      a(localVideoTrackTimeLineView, localLayoutParams, bool);
      localVideoTrackTimeLineView.setLayoutParams(localVideoTrackTimeLineView.getLayoutParams());
      l += localVideoResourceModelKt.getScaleDuration();
      localVideoTrackTimeLineView.d();
      k += 1;
    }
    if (this.jdField_i_of_type_Boolean)
    {
      j();
      return;
    }
    b(this.jdField_b_of_type_JavaUtilList);
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((VideoTrackTimeLineView)localIterator.next()).e();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    VideoThumbProviderManager.getInstance().unRegisterListener(this.jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderVideoThumbListener);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIDragDropScrollListener;
    if ((localObject != null) && (!this.jdField_e_of_type_Boolean)) {
      ((IDragDropScrollListener)localObject).a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = this.jdField_c_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoTrackTimeLineView)((Iterator)localObject).next()).a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      this.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView$OnScrollStoppedListener != null) {
        post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBitmapWidth(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
    this.jdField_g_of_type_Boolean = paramBoolean;
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((VideoTrackTimeLineView)localIterator.next()).setClickable(paramBoolean);
    }
  }
  
  public void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setCornerRadius(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public void setItemOnLongClickListener(ClipItemLongClickListener paramClipItemLongClickListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewReorderClipItemLongClickListener = paramClipItemLongClickListener;
  }
  
  public void setMaxDurationLimit(long paramLong)
  {
    if (paramLong > 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
  }
  
  public void setOnScrollStoppedListener(VideoTrackContainerView.OnScrollStoppedListener paramOnScrollStoppedListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView$OnScrollStoppedListener = paramOnScrollStoppedListener;
  }
  
  public void setOnStartTimeChangedListener(VideoTrackContainerView.OnStartTimeChangedListener paramOnStartTimeChangedListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView$OnStartTimeChangedListener = paramOnStartTimeChangedListener;
  }
  
  public void setOnTransitionListener(OnTransitionListener paramOnTransitionListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTransitionListenerOnTransitionListener = paramOnTransitionListener;
  }
  
  public void setScaleAdapter(ScaleAdapter paramScaleAdapter)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter = paramScaleAdapter;
  }
  
  public void setScrollByPassive(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setScrollListener(IDragDropScrollListener paramIDragDropScrollListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIDragDropScrollListener = paramIDragDropScrollListener;
  }
  
  public void setSelectedStateListener(TrackSelectedStateChangeListener paramTrackSelectedStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackTrackSelectedStateChangeListener = paramTrackSelectedStateChangeListener;
  }
  
  public void setShowLeftAndRightSliderView(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setShowPieces(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void setTimeBar(ScaleTimeBar paramScaleTimeBar)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleTimeBar = paramScaleTimeBar;
  }
  
  public void setVideoClipClickListener(VideoTrackContainerView.OnVideoClipClickListener paramOnVideoClipClickListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackContainerView$OnVideoClipClickListener = paramOnVideoClipClickListener;
  }
  
  public void setVideoModel(MvVideoViewModel paramMvVideoViewModel)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditMultiViewmodelMvVideoViewModel = paramMvVideoViewModel;
  }
  
  public void setVideoTrackSelectedStyle(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setVideoTrackStoreListener(VideoTrackStoreListener paramVideoTrackStoreListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackStoreListener = paramVideoTrackStoreListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView
 * JD-Core Version:    0.7.0.1
 */
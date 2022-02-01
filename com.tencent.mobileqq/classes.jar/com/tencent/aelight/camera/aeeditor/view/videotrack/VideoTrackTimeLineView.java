package com.tencent.aelight.camera.aeeditor.view.videotrack;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.data.SpeedFloatUtil;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IValueChangeListener;
import com.tencent.aelight.camera.aeeditor.view.playtrack.view.PlayTrackExpandWidthView;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;
import com.tencent.aelight.camera.aeeditor.view.timeline.EffectTimelineView;
import com.tencent.aelight.camera.aeeditor.view.timeline.SliderView;
import com.tencent.aelight.camera.aeeditor.view.timeline.TimeLineViewListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tavcut.util.SpeedUtil;
import com.tencent.tavcut.util.TimeFormatUtil;
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.weishi.module.edit.widget.playtrack.provider.IPlayTrackViewBitmapProvider;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt.Companion;
import com.tencent.weseevideo.model.resource.VideoResourceModel;

public class VideoTrackTimeLineView
  extends EffectTimelineView
{
  private float jdField_a_of_type_Float;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PlayTrackExpandWidthView jdField_a_of_type_ComTencentAelightCameraAeeditorViewPlaytrackViewPlayTrackExpandWidthView;
  private RoundFrameLayout jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackRoundFrameLayout;
  private VideoTrackTimeLineView.OnSlideChangedListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener;
  private IPlayTrackViewBitmapProvider jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderIPlayTrackViewBitmapProvider = new VideoTrackTimeLineView.1(this);
  private CutModelKt jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt;
  private VideoResourceModel jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = 0.0F;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  protected long h = 0L;
  protected long i = 0L;
  protected long j = 0L;
  private long k = 0L;
  private long l = 0L;
  
  @RequiresApi(api=16)
  public VideoTrackTimeLineView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  @RequiresApi(api=16)
  public VideoTrackTimeLineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @RequiresApi(api=16)
  public VideoTrackTimeLineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.f = -1L;
    this.g = -1L;
    g();
  }
  
  private long a(long paramLong)
  {
    long l1 = ((float)(b() - this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.c()) - (float)paramLong / this.jdField_a_of_type_Float);
    if ((this.jdField_b_of_type_Boolean) && (Math.abs(l1) < this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(l())) && (this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getScaleDuration() > c()))
    {
      AEQLog.b("miles", "第一次满足左侧吸附条件");
      performHapticFeedback(0, 2);
      this.jdField_b_of_type_Boolean = false;
      return ((float)Math.max(b() - this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.c(), c()) * this.jdField_a_of_type_Float);
    }
    if (Math.abs(l1) >= this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(l()))
    {
      this.jdField_b_of_type_Boolean = true;
      return paramLong;
    }
    return this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration();
  }
  
  private void a(long paramLong)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(TimeFormatUtil.getDurationSecondsEnglish(paramLong));
    }
  }
  
  private long b(long paramLong)
  {
    long l1 = ((float)(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.c() - a()) - (float)paramLong / this.jdField_a_of_type_Float);
    if ((this.jdField_c_of_type_Boolean) && (Math.abs(l1) < this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(l())) && (this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getScaleDuration() > c()))
    {
      Log.i("miles", "第一次满足左侧吸附条件");
      performHapticFeedback(0, 2);
      this.jdField_c_of_type_Boolean = false;
      return ((float)Math.max(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.c() - a(), c()) * this.jdField_a_of_type_Float);
    }
    if (Math.abs(l1) >= this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(l()))
    {
      this.jdField_c_of_type_Boolean = true;
      return paramLong;
    }
    return this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration();
  }
  
  private boolean b()
  {
    CutModelKt localCutModelKt = this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localCutModelKt != null)
    {
      bool1 = bool2;
      if (localCutModelKt.getResource() != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getResource().getScaleDuration() != this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getResource().getSelectTimeDuration()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @RequiresApi(api=16)
  private void g()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewPlaytrackViewPlayTrackExpandWidthView = new PlayTrackExpandWidthView(getContext());
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackRoundFrameLayout.addView(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewPlaytrackViewPlayTrackExpandWidthView, localLayoutParams);
    if (this.d == 0) {
      this.d = ViewUtils.dip2px(40.0F);
    }
    this.jdField_c_of_type_Int = ((int)getResources().getDimension(2063990814));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewPlaytrackViewPlayTrackExpandWidthView.setPixelPerBitmap(this.d);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewPlaytrackViewPlayTrackExpandWidthView.setVideoThumbProvider(this.jdField_a_of_type_ComTencentWeishiModuleEditWidgetPlaytrackProviderIPlayTrackViewBitmapProvider);
    h();
    i();
    j();
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131167408);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackRoundFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, (int)getResources().getDimension(2063990836));
    localLayoutParams.leftMargin = ((int)getResources().getDimension(2063990810));
    localLayoutParams.bottomMargin = ((int)getResources().getDimension(2063990814));
    localLayoutParams.gravity = 83;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, getResources().getDimension(2063990832));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(4.0F, 1.0F, 3.0F, 2131165336);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(80);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding((int)getResources().getDimension(2063990813), 0, (int)getResources().getDimension(2063990813), 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackRoundFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  @RequiresApi(api=16)
  private void j()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)getResources().getDimension(2063990848), (int)getResources().getDimension(2063990834));
    localLayoutParams.leftMargin = ((int)getResources().getDimension(2063990818));
    localLayoutParams.topMargin = ((int)getResources().getDimension(2063990813));
    localLayoutParams.gravity = 51;
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, getResources().getDimension(2063990825));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2064056551));
    this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackRoundFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (b())
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      float f = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSpeed();
      if (SpeedFloatUtil.a(f, 0.75F))
      {
        localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(SpeedUtil.getPreciseValue(f, 2));
        localStringBuilder.append("x");
        localTextView.setText(localStringBuilder.toString());
        return;
      }
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(SpeedUtil.getPreciseValue(f, 1));
      localStringBuilder.append("x");
      localTextView.setText(localStringBuilder.toString());
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private int l()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter != null) {}
    for (float f = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a() / 4.0F;; f = getResources().getDimension(2063990825)) {
      return (int)f;
    }
  }
  
  private void l()
  {
    float f = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    localMarginLayoutParams.width = ((int)(f + h() * 2));
    setLayoutParams(localMarginLayoutParams);
  }
  
  private void m()
  {
    this.h = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeStart();
    this.i = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration();
    this.j = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSourceTimeDuration();
  }
  
  protected ViewGroup a()
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(2064318593, null);
    this.jdField_b_of_type_AndroidViewView = localViewGroup.findViewById(2064121979);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackRoundFrameLayout = ((RoundFrameLayout)localViewGroup.findViewById(2064122060));
    return localViewGroup;
  }
  
  public PlayTrackExpandWidthView a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewPlaytrackViewPlayTrackExpandWidthView;
  }
  
  public CutModelKt a()
  {
    CutModelKt localCutModelKt = this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt;
    return localCutModelKt.copy(localCutModelKt.getUuid(), VideoResourceModelKt.Companion.from(this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel), this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getVideoConfiguration(), this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getAudioConfiguration());
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getPath();
  }
  
  public void a()
  {
    super.a();
    m();
    this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
  }
  
  protected void a(float paramFloat)
  {
    AEQLog.a("VideoTrackTimeLineView", "[handleLeftSliderMove]");
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener;
    if (localObject != null) {
      ((VideoTrackTimeLineView.OnSlideChangedListener)localObject).a(true);
    }
    if ((paramFloat < this.jdField_b_of_type_Float) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a()))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a();
      this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
      m();
    }
    else if ((paramFloat > this.jdField_b_of_type_Float) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.b()))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a();
      this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
      m();
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a()) || (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.b())) {
        break label448;
      }
    }
    paramFloat -= this.jdField_c_of_type_Float;
    if (((paramFloat < 0.0F) && (this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeStart() > 0L)) || ((paramFloat > 0.0F) && ((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float > (float)c())) || ((paramFloat > 0.0F) && (paramFloat < this.jdField_b_of_type_Float)))
    {
      long l2 = ((float)this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramFloat) * this.jdField_a_of_type_Float);
      long l1 = this.h;
      if (l2 <= -l1)
      {
        l1 = -l1;
      }
      else
      {
        l1 = l2;
        if ((float)l2 > (float)this.i - (float)c() * this.jdField_a_of_type_Float) {
          l1 = ((float)this.i - (float)c() * this.jdField_a_of_type_Float);
        }
      }
      l1 = a(this.i - l1);
      l1 = this.i - l1;
      this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeStartUs((this.h + l1) * 1000L);
      this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeDurationUs((this.i - l1) * 1000L);
      localObject = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel;
      ((VideoResourceModel)localObject).setScaleDuration(((float)((VideoResourceModel)localObject).getSelectTimeDuration() / this.jdField_a_of_type_Float));
      l();
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimeLineViewListener != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimeLineViewListener.a(this, this.jdField_b_of_type_Long, ((float)l1 / this.jdField_a_of_type_Float));
      }
      a(((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
    }
    this.jdField_b_of_type_Float = (paramFloat + this.jdField_c_of_type_Float);
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener;
    if (localObject != null) {
      ((VideoTrackTimeLineView.OnSlideChangedListener)localObject).e();
    }
    return;
    label448:
    AEQLog.b("miles", "滚动中，直接return");
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    VideoResourceModel localVideoResourceModel = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel;
    float f = paramInt;
    localVideoResourceModel.setSelectTimeStartUs((this.jdField_a_of_type_Float * f) * 1000L);
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeDurationUs(((float)(this.h + this.i) - f * this.jdField_a_of_type_Float) * 1000L);
    localVideoResourceModel = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel;
    localVideoResourceModel.setScaleDuration(((float)localVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
    l();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewPlaytrackViewPlayTrackExpandWidthView.invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    AEQLog.a("VideoTrackTimeLineView", "[onSliderMoveEnd]");
    VideoTrackTimeLineView.OnSlideChangedListener localOnSlideChangedListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener;
    if (localOnSlideChangedListener != null) {
      localOnSlideChangedListener.a(false);
    }
    super.a(paramBoolean);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    m();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void b()
  {
    super.b();
    m();
  }
  
  protected void b(float paramFloat)
  {
    AEQLog.a("VideoTrackTimeLineView", "[handleRightSliderMove]");
    VideoTrackTimeLineView.OnSlideChangedListener localOnSlideChangedListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener;
    if (localOnSlideChangedListener != null) {
      localOnSlideChangedListener.a(true);
    }
    if ((paramFloat < this.jdField_b_of_type_Float) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a()))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a();
      this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
      m();
    }
    else if ((paramFloat > this.jdField_b_of_type_Float) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.b()))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a();
      this.jdField_c_of_type_Float = this.jdField_b_of_type_Float;
      m();
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a()) || (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.b())) {
        break label438;
      }
    }
    paramFloat -= this.jdField_c_of_type_Float;
    if (((paramFloat < 0.0F) && ((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float > (float)c())) || ((paramFloat > 0.0F) && (this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeStart() + this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() < this.j)))
    {
      long l2 = ((float)this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramFloat) * this.jdField_a_of_type_Float);
      long l1 = this.j;
      long l4 = this.h;
      long l3 = this.i;
      if (l2 >= l1 - l4 - l3)
      {
        l1 = l1 - l4 - l3;
      }
      else
      {
        l1 = l2;
        if ((float)l2 <= -((float)l3 - (float)c() * this.jdField_a_of_type_Float)) {
          l1 = -((float)this.i - (float)c() * this.jdField_a_of_type_Float);
        }
      }
      l1 = b(this.i + l1);
      l2 = this.i;
      this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeDurationUs(1000L * l1);
      this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setScaleDuration(((float)l1 / this.jdField_a_of_type_Float));
      l();
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimeLineViewListener != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimeLineViewListener.b(this, this.jdField_c_of_type_Long, ((float)(l1 - l2) / this.jdField_a_of_type_Float));
      }
      a(((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
    }
    this.jdField_b_of_type_Float = (paramFloat + this.jdField_c_of_type_Float);
    localOnSlideChangedListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener;
    if (localOnSlideChangedListener != null) {
      localOnSlideChangedListener.e();
    }
    return;
    label438:
    AEQLog.b("miles", "滚动中，直接return");
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void b(int paramInt)
  {
    VideoResourceModel localVideoResourceModel = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel;
    float f1 = (float)(this.h + this.i);
    float f2 = paramInt;
    localVideoResourceModel.setSelectTimeStartUs((f1 - this.jdField_a_of_type_Float * f2 - (float)c()) * 1000L);
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeDurationUs((f2 * this.jdField_a_of_type_Float + (float)c()) * 1000L);
    localVideoResourceModel = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel;
    localVideoResourceModel.setScaleDuration(((float)localVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
    l();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeStartUs(this.h * 1000L);
    VideoResourceModel localVideoResourceModel = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel;
    long l1 = paramInt;
    localVideoResourceModel.setSelectTimeDurationUs(((float)(c() + l1) * this.jdField_a_of_type_Float) * 1000L);
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setScaleDuration(l1 + c());
    l();
  }
  
  protected int d()
  {
    return getResources().getDimensionPixelOffset(2063990842);
  }
  
  public long d()
  {
    return ((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float);
  }
  
  public void d()
  {
    long l1 = this.l;
    if (l1 > 0L) {
      setRedMaskViewShowTimeRange(this.k, l1);
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeStartUs(this.h * 1000L);
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.setSelectTimeDurationUs(((float)(this.j - this.h) - paramInt * this.jdField_a_of_type_Float) * 1000L);
    VideoResourceModel localVideoResourceModel = this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel;
    localVideoResourceModel.setScaleDuration(((float)localVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
    l();
  }
  
  protected int e()
  {
    return 0;
  }
  
  public long e()
  {
    return ((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeStart() / this.jdField_a_of_type_Float);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewPlaytrackViewPlayTrackExpandWidthView.postInvalidate();
  }
  
  public long f()
  {
    return ((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float - (float)c());
  }
  
  @RequiresApi(api=17)
  public void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    if (localObject != null)
    {
      localObject = (View)((ObjectAnimator)localObject).getTarget();
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackRoundFrameLayout.removeView((View)localObject);
      }
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
    }
    localObject = new View(getContext());
    ((View)localObject).setAlpha(0.0F);
    if (Build.VERSION.SDK_INT >= 17) {
      ((View)localObject).setId(View.generateViewId());
    }
    ((View)localObject).setBackgroundColor(getContext().getResources().getColor(2063925255));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 0.3F }).setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setStartDelay(500L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(4);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatMode(2);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new VideoTrackTimeLineView.2(this, (View)localObject));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackRoundFrameLayout.addView((View)localObject, localLayoutParams);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  public long g()
  {
    return ((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float - (float)c());
  }
  
  public long h()
  {
    return ((float)(this.j - this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() - this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeStart()) / this.jdField_a_of_type_Float);
  }
  
  public void setBitmapWidth(int paramInt)
  {
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewPlaytrackViewPlayTrackExpandWidthView.setPixelPerBitmap(this.d);
  }
  
  public void setCornerRadius(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    RoundFrameLayout localRoundFrameLayout = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackRoundFrameLayout;
    if (localRoundFrameLayout != null)
    {
      if (isSelected()) {
        paramInt = 0;
      } else {
        paramInt = this.jdField_c_of_type_Int;
      }
      localRoundFrameLayout.setRadius(paramInt);
    }
  }
  
  public void setEndValue(long paramLong)
  {
    super.setEndValue(paramLong);
    if (this.g == -1L) {
      this.g = paramLong;
    }
  }
  
  public void setMediaClipModel(CutModelKt paramCutModelKt)
  {
    this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt = paramCutModelKt;
    this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel = paramCutModelKt.getResource().convert();
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getResource().getScaleSpeed();
  }
  
  public void setOnSlideChangedListener(VideoTrackTimeLineView.OnSlideChangedListener paramOnSlideChangedListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackVideoTrackTimeLineView$OnSlideChangedListener = paramOnSlideChangedListener;
  }
  
  public void setRedMaskViewShowTimeRange(long paramLong1, long paramLong2)
  {
    if (paramLong1 >= 0L)
    {
      if (paramLong2 <= 0L) {
        return;
      }
      this.k = paramLong1;
      this.l = paramLong2;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.leftMargin = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramLong1);
      localLayoutParams.width = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramLong2);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void setScaleModel(ScaleAdapter paramScaleAdapter)
  {
    super.setScaleModel(paramScaleAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewPlaytrackViewPlayTrackExpandWidthView.setScaleAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    a(((float)this.jdField_a_of_type_ComTencentWeseevideoModelResourceVideoResourceModel.getSelectTimeDuration() / this.jdField_a_of_type_Float));
    k();
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_b_of_type_AndroidViewView.setSelected(paramBoolean);
      return;
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      RoundFrameLayout localRoundFrameLayout = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewVideotrackRoundFrameLayout;
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = this.jdField_c_of_type_Int;
      }
      localRoundFrameLayout.setRadius(m);
    }
  }
  
  public void setSelectedStyle(int paramInt)
  {
    super.setSelectedStyle(paramInt);
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void setShowSliderView(boolean paramBoolean)
  {
    SliderView localSliderView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView;
    int n = 0;
    int m;
    if (localSliderView != null)
    {
      localSliderView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 4;
      }
      localSliderView.setVisibility(m);
    }
    if (this.jdField_b_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView != null)
    {
      localSliderView = this.jdField_b_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView;
      if (paramBoolean) {
        m = n;
      } else {
        m = 4;
      }
      localSliderView.setVisibility(m);
    }
  }
  
  public void setStartValue(long paramLong)
  {
    super.setStartValue(paramLong);
    if (this.f == -1L) {
      this.f = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackTimeLineView
 * JD-Core Version:    0.7.0.1
 */
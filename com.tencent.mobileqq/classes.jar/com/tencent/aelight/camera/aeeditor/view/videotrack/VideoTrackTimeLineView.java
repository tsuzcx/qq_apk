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
import com.tencent.qcircle.tavcut.util.SpeedUtil;
import com.tencent.qcircle.tavcut.util.TimeFormatUtil;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.IPlayTrackViewBitmapProvider;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.VideoResourceModelKt.Companion;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.tavsticker.utils.ViewUtils;

public class VideoTrackTimeLineView
  extends EffectTimelineView
{
  private TextView A;
  private TextView B;
  private boolean C = true;
  private boolean D = true;
  private boolean E = true;
  private View F;
  private RoundFrameLayout G;
  private View H;
  private long I = 0L;
  private long J = 0L;
  private VideoTrackTimeLineView.OnSlideChangedListener K;
  private int L = 0;
  private int M;
  private ObjectAnimator N;
  private IPlayTrackViewBitmapProvider O = new VideoTrackTimeLineView.1(this);
  protected long q = 0L;
  protected long r = 0L;
  protected long s = 0L;
  private Context t;
  private float u;
  private float v = 0.0F;
  private float w = 0.0F;
  private CutModelKt x;
  private VideoResourceModel y;
  private PlayTrackExpandWidthView z;
  
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
    this.t = paramContext;
    this.f = -1L;
    this.g = -1L;
    m();
  }
  
  private void a(long paramLong)
  {
    TextView localTextView = this.A;
    if (localTextView != null)
    {
      localTextView.setVisibility(0);
      this.A.setText(TimeFormatUtil.getDurationSecondsEnglish(paramLong));
    }
  }
  
  private long b(long paramLong)
  {
    long l = ((float)(getEndValue() - this.i.d()) - (float)paramLong / this.u);
    if ((this.D) && (Math.abs(l) < this.i.b(getAttractDistance())) && (this.y.getScaleDuration() > getMinValue()))
    {
      AEQLog.b("miles", "第一次满足左侧吸附条件");
      performHapticFeedback(0, 2);
      this.D = false;
      return ((float)Math.max(getEndValue() - this.i.d(), getMinValue()) * this.u);
    }
    if (Math.abs(l) >= this.i.b(getAttractDistance()))
    {
      this.D = true;
      return paramLong;
    }
    return this.y.getSelectTimeDuration();
  }
  
  private long c(long paramLong)
  {
    long l = ((float)(this.i.d() - getStartValue()) - (float)paramLong / this.u);
    if ((this.E) && (Math.abs(l) < this.i.b(getAttractDistance())) && (this.y.getScaleDuration() > getMinValue()))
    {
      Log.i("miles", "第一次满足左侧吸附条件");
      performHapticFeedback(0, 2);
      this.E = false;
      return ((float)Math.max(this.i.d() - getStartValue(), getMinValue()) * this.u);
    }
    if (Math.abs(l) >= this.i.b(getAttractDistance()))
    {
      this.E = true;
      return paramLong;
    }
    return this.y.getSelectTimeDuration();
  }
  
  private int getAttractDistance()
  {
    if (this.i != null) {}
    for (float f = this.i.f() / 4.0F;; f = getResources().getDimension(2063859752)) {
      return (int)f;
    }
  }
  
  @RequiresApi(api=16)
  private void m()
  {
    this.z = new PlayTrackExpandWidthView(getContext());
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.G.addView(this.z, localLayoutParams);
    if (this.M == 0) {
      this.M = ViewUtils.dip2px(40.0F);
    }
    this.L = ((int)getResources().getDimension(2063859741));
    this.z.setPixelPerBitmap(this.M);
    this.z.setVideoThumbProvider(this.O);
    n();
    o();
    p();
  }
  
  private void n()
  {
    this.F = new View(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.F.setBackgroundResource(2131168485);
    this.F.setVisibility(4);
    this.G.addView(this.F, localLayoutParams);
  }
  
  private void o()
  {
    this.A = new TextView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, (int)getResources().getDimension(2063859763));
    localLayoutParams.leftMargin = ((int)getResources().getDimension(2063859737));
    localLayoutParams.bottomMargin = ((int)getResources().getDimension(2063859741));
    localLayoutParams.gravity = 83;
    this.A.setTextSize(0, getResources().getDimension(2063859759));
    this.A.setTextColor(-1);
    this.A.setShadowLayer(4.0F, 1.0F, 3.0F, 2131165578);
    this.A.setIncludeFontPadding(false);
    this.A.setSingleLine();
    this.A.setGravity(80);
    this.A.setPadding((int)getResources().getDimension(2063859740), 0, (int)getResources().getDimension(2063859740), 0);
    this.A.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.G.addView(this.A, localLayoutParams);
  }
  
  @RequiresApi(api=16)
  private void p()
  {
    this.B = new TextView(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)getResources().getDimension(2063859775), (int)getResources().getDimension(2063859761));
    localLayoutParams.leftMargin = ((int)getResources().getDimension(2063859745));
    localLayoutParams.topMargin = ((int)getResources().getDimension(2063859740));
    localLayoutParams.gravity = 51;
    this.B.setTextSize(0, getResources().getDimension(2063859752));
    this.B.setTextColor(-1);
    this.B.setSingleLine();
    this.A.setIncludeFontPadding(false);
    this.B.setGravity(17);
    this.B.setBackground(this.t.getResources().getDrawable(2063925510));
    this.B.setTypeface(((IQCircleRFWApi)QRoute.api(IQCircleRFWApi.class)).getTypeface(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.G.addView(this.B, localLayoutParams);
  }
  
  private void q()
  {
    if (this.B == null) {
      return;
    }
    if (r())
    {
      this.B.setVisibility(0);
      float f = this.y.getSpeed();
      if (SpeedFloatUtil.a(f, 0.75F))
      {
        localTextView = this.B;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(SpeedUtil.getPreciseValue(f, 2));
        localStringBuilder.append("x");
        localTextView.setText(localStringBuilder.toString());
        return;
      }
      TextView localTextView = this.B;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(SpeedUtil.getPreciseValue(f, 1));
      localStringBuilder.append("x");
      localTextView.setText(localStringBuilder.toString());
      return;
    }
    this.B.setVisibility(8);
  }
  
  private boolean r()
  {
    CutModelKt localCutModelKt = this.x;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localCutModelKt != null)
    {
      bool1 = bool2;
      if (localCutModelKt.getResource() != null)
      {
        bool1 = bool2;
        if (this.x.getResource().getScaleDuration() != this.x.getResource().getSelectTimeDuration()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void s()
  {
    float f = this.i.c(((float)this.y.getSelectTimeDuration() / this.u));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    localMarginLayoutParams.width = ((int)(f + getSliderWidth() * 2));
    setLayoutParams(localMarginLayoutParams);
  }
  
  private void t()
  {
    this.q = this.y.getSelectTimeStart();
    this.r = this.y.getSelectTimeDuration();
    this.s = this.y.getSourceTimeDuration();
  }
  
  public void a()
  {
    super.a();
    t();
    this.w = this.v;
  }
  
  protected void a(float paramFloat)
  {
    AEQLog.a("VideoTrackTimeLineView", "[handleLeftSliderMove]");
    Object localObject = this.K;
    if (localObject != null) {
      ((VideoTrackTimeLineView.OnSlideChangedListener)localObject).a(true);
    }
    if ((paramFloat < this.v) && (this.j.b()))
    {
      this.j.a();
      this.w = this.v;
      t();
    }
    else if ((paramFloat > this.v) && (this.j.c()))
    {
      this.j.a();
      this.w = this.v;
      t();
    }
    else
    {
      if ((this.j.b()) || (this.j.c())) {
        break label448;
      }
    }
    paramFloat -= this.w;
    if (((paramFloat < 0.0F) && (this.y.getSelectTimeStart() > 0L)) || ((paramFloat > 0.0F) && ((float)this.y.getSelectTimeDuration() / this.u > (float)getMinValue())) || ((paramFloat > 0.0F) && (paramFloat < this.v)))
    {
      long l2 = ((float)this.i.b(paramFloat) * this.u);
      long l1 = this.q;
      if (l2 <= -l1)
      {
        l1 = -l1;
      }
      else
      {
        l1 = l2;
        if ((float)l2 > (float)this.r - (float)getMinValue() * this.u) {
          l1 = ((float)this.r - (float)getMinValue() * this.u);
        }
      }
      l1 = b(this.r - l1);
      l1 = this.r - l1;
      this.y.setSelectTimeStartUs((this.q + l1) * 1000L);
      this.y.setSelectTimeDurationUs((this.r - l1) * 1000L);
      localObject = this.y;
      ((VideoResourceModel)localObject).setScaleDuration(((float)((VideoResourceModel)localObject).getSelectTimeDuration() / this.u));
      s();
      if (this.l != null) {
        this.l.a(this, this.b, ((float)l1 / this.u));
      }
      a(((float)this.y.getSelectTimeDuration() / this.u));
    }
    this.v = (paramFloat + this.w);
    localObject = this.K;
    if (localObject != null) {
      ((VideoTrackTimeLineView.OnSlideChangedListener)localObject).g();
    }
    return;
    label448:
    AEQLog.b("miles", "滚动中，直接return");
    this.v = paramFloat;
  }
  
  public void a(int paramInt)
  {
    VideoResourceModel localVideoResourceModel = this.y;
    float f = paramInt;
    localVideoResourceModel.setSelectTimeStartUs((this.u * f) * 1000L);
    this.y.setSelectTimeDurationUs(((float)(this.q + this.r) - f * this.u) * 1000L);
    localVideoResourceModel = this.y;
    localVideoResourceModel.setScaleDuration(((float)localVideoResourceModel.getSelectTimeDuration() / this.u));
    s();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    this.z.invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    AEQLog.a("VideoTrackTimeLineView", "[onSliderMoveEnd]");
    VideoTrackTimeLineView.OnSlideChangedListener localOnSlideChangedListener = this.K;
    if (localOnSlideChangedListener != null) {
      localOnSlideChangedListener.a(false);
    }
    super.a(paramBoolean);
    this.v = 0.0F;
    this.w = 0.0F;
    t();
    this.D = true;
    this.E = true;
  }
  
  public void b()
  {
    super.b();
    t();
  }
  
  protected void b(float paramFloat)
  {
    AEQLog.a("VideoTrackTimeLineView", "[handleRightSliderMove]");
    VideoTrackTimeLineView.OnSlideChangedListener localOnSlideChangedListener = this.K;
    if (localOnSlideChangedListener != null) {
      localOnSlideChangedListener.a(true);
    }
    if ((paramFloat < this.v) && (this.j.b()))
    {
      this.j.a();
      this.w = this.v;
      t();
    }
    else if ((paramFloat > this.v) && (this.j.c()))
    {
      this.j.a();
      this.w = this.v;
      t();
    }
    else
    {
      if ((this.j.b()) || (this.j.c())) {
        break label438;
      }
    }
    paramFloat -= this.w;
    if (((paramFloat < 0.0F) && ((float)this.y.getSelectTimeDuration() / this.u > (float)getMinValue())) || ((paramFloat > 0.0F) && (this.y.getSelectTimeStart() + this.y.getSelectTimeDuration() < this.s)))
    {
      long l2 = ((float)this.i.b(paramFloat) * this.u);
      long l1 = this.s;
      long l4 = this.q;
      long l3 = this.r;
      if (l2 >= l1 - l4 - l3)
      {
        l1 = l1 - l4 - l3;
      }
      else
      {
        l1 = l2;
        if ((float)l2 <= -((float)l3 - (float)getMinValue() * this.u)) {
          l1 = -((float)this.r - (float)getMinValue() * this.u);
        }
      }
      l1 = c(this.r + l1);
      l2 = this.r;
      this.y.setSelectTimeDurationUs(1000L * l1);
      this.y.setScaleDuration(((float)l1 / this.u));
      s();
      if (this.l != null) {
        this.l.b(this, this.c, ((float)(l1 - l2) / this.u));
      }
      a(((float)this.y.getSelectTimeDuration() / this.u));
    }
    this.v = (paramFloat + this.w);
    localOnSlideChangedListener = this.K;
    if (localOnSlideChangedListener != null) {
      localOnSlideChangedListener.g();
    }
    return;
    label438:
    AEQLog.b("miles", "滚动中，直接return");
    this.v = paramFloat;
  }
  
  public void b(int paramInt)
  {
    VideoResourceModel localVideoResourceModel = this.y;
    float f1 = (float)(this.q + this.r);
    float f2 = paramInt;
    localVideoResourceModel.setSelectTimeStartUs((f1 - this.u * f2 - (float)getMinValue()) * 1000L);
    this.y.setSelectTimeDurationUs((f2 * this.u + (float)getMinValue()) * 1000L);
    localVideoResourceModel = this.y;
    localVideoResourceModel.setScaleDuration(((float)localVideoResourceModel.getSelectTimeDuration() / this.u));
    s();
  }
  
  public void c(int paramInt)
  {
    this.y.setSelectTimeStartUs(this.q * 1000L);
    VideoResourceModel localVideoResourceModel = this.y;
    long l = paramInt;
    localVideoResourceModel.setSelectTimeDurationUs(((float)(getMinValue() + l) * this.u) * 1000L);
    this.y.setScaleDuration(l + getMinValue());
    s();
  }
  
  public void d(int paramInt)
  {
    this.y.setSelectTimeStartUs(this.q * 1000L);
    this.y.setSelectTimeDurationUs(((float)(this.s - this.q) - paramInt * this.u) * 1000L);
    VideoResourceModel localVideoResourceModel = this.y;
    localVideoResourceModel.setScaleDuration(((float)localVideoResourceModel.getSelectTimeDuration() / this.u));
    s();
  }
  
  protected ViewGroup e()
  {
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(2064056465, null);
    this.H = localViewGroup.findViewById(2063990906);
    this.G = ((RoundFrameLayout)localViewGroup.findViewById(2063990979));
    return localViewGroup;
  }
  
  public String getAssetPath()
  {
    return this.y.getPath();
  }
  
  protected int getContentMargin()
  {
    return getResources().getDimensionPixelOffset(2063859769);
  }
  
  protected int getContentPadding()
  {
    return 0;
  }
  
  public long getCurrentDuration()
  {
    return ((float)this.y.getSelectTimeDuration() / this.u);
  }
  
  public long getLeftToLeftCanMoveValue()
  {
    return ((float)this.y.getSelectTimeStart() / this.u);
  }
  
  public long getLeftToRightCanMoveValue()
  {
    return ((float)this.y.getSelectTimeDuration() / this.u - (float)getMinValue());
  }
  
  public CutModelKt getMediaClipModel()
  {
    CutModelKt localCutModelKt = this.x;
    return localCutModelKt.copy(localCutModelKt.getUuid(), VideoResourceModelKt.Companion.from(this.y), this.x.getVideoConfiguration(), this.x.getAudioConfiguration());
  }
  
  public long getRawSelectedTimeStart()
  {
    return this.q;
  }
  
  public long getRightToLeftCanMoveValue()
  {
    return ((float)this.y.getSelectTimeDuration() / this.u - (float)getMinValue());
  }
  
  public long getRightToRightCanMoveValue()
  {
    return ((float)(this.s - this.y.getSelectTimeDuration() - this.y.getSelectTimeStart()) / this.u);
  }
  
  public long getSelectedTimeDuration()
  {
    return this.y.getSelectTimeDuration();
  }
  
  public long getSelectedTimeStart()
  {
    return this.y.getSelectTimeStart();
  }
  
  public float getSpeed()
  {
    return this.u;
  }
  
  public PlayTrackExpandWidthView getVideoThumbnailView()
  {
    return this.z;
  }
  
  public void j()
  {
    long l = this.J;
    if (l > 0L) {
      setRedMaskViewShowTimeRange(this.I, l);
    }
  }
  
  public void k()
  {
    this.z.postInvalidate();
  }
  
  @RequiresApi(api=17)
  public void l()
  {
    Object localObject = this.N;
    if (localObject != null)
    {
      localObject = (View)((ObjectAnimator)localObject).getTarget();
      if (localObject != null) {
        this.G.removeView((View)localObject);
      }
      this.N.removeAllListeners();
      this.N.cancel();
    }
    localObject = new View(getContext());
    ((View)localObject).setAlpha(0.0F);
    if (Build.VERSION.SDK_INT >= 17) {
      ((View)localObject).setId(View.generateViewId());
    }
    ((View)localObject).setBackgroundColor(getContext().getResources().getColor(2063794183));
    this.N = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 0.3F }).setDuration(200L);
    this.N.setStartDelay(500L);
    this.N.setRepeatCount(4);
    this.N.setRepeatMode(2);
    this.N.addListener(new VideoTrackTimeLineView.2(this, (View)localObject));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.G.addView((View)localObject, localLayoutParams);
    this.N.start();
  }
  
  public void setBitmapWidth(int paramInt)
  {
    this.M = paramInt;
    this.z.setPixelPerBitmap(this.M);
  }
  
  public void setCornerRadius(int paramInt)
  {
    this.L = paramInt;
    RoundFrameLayout localRoundFrameLayout = this.G;
    if (localRoundFrameLayout != null)
    {
      if (isSelected()) {
        paramInt = 0;
      } else {
        paramInt = this.L;
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
    this.x = paramCutModelKt;
    this.y = paramCutModelKt.getResource().convert();
    this.u = this.x.getResource().getScaleSpeed();
  }
  
  public void setOnSlideChangedListener(VideoTrackTimeLineView.OnSlideChangedListener paramOnSlideChangedListener)
  {
    this.K = paramOnSlideChangedListener;
  }
  
  public void setRedMaskViewShowTimeRange(long paramLong1, long paramLong2)
  {
    if (paramLong1 >= 0L)
    {
      if (paramLong2 <= 0L) {
        return;
      }
      this.I = paramLong1;
      this.J = paramLong2;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.leftMargin = this.i.c(paramLong1);
      localLayoutParams.width = this.i.c(paramLong2);
      this.F.setLayoutParams(localLayoutParams);
      this.F.setVisibility(0);
    }
  }
  
  public void setScaleModel(ScaleAdapter paramScaleAdapter)
  {
    super.setScaleModel(paramScaleAdapter);
    this.z.setScaleAdapter(this.i);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    a(((float)this.y.getSelectTimeDuration() / this.u));
    q();
    if (this.p == 1)
    {
      this.H.setSelected(paramBoolean);
      return;
    }
    if (this.p == 0)
    {
      RoundFrameLayout localRoundFrameLayout = this.G;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = this.L;
      }
      localRoundFrameLayout.setRadius(i);
    }
  }
  
  public void setSelectedStyle(int paramInt)
  {
    super.setSelectedStyle(paramInt);
    if (this.p == 1)
    {
      this.H.setVisibility(0);
      return;
    }
    if (this.p == 0) {
      this.H.setVisibility(8);
    }
  }
  
  public void setShowSliderView(boolean paramBoolean)
  {
    SliderView localSliderView = this.m;
    int j = 0;
    int i;
    if (localSliderView != null)
    {
      localSliderView = this.m;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 4;
      }
      localSliderView.setVisibility(i);
    }
    if (this.n != null)
    {
      localSliderView = this.n;
      if (paramBoolean) {
        i = j;
      } else {
        i = 4;
      }
      localSliderView.setVisibility(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackTimeLineView
 * JD-Core Version:    0.7.0.1
 */
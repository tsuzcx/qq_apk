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
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbListener;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import com.tencent.qcircle.weseevideo.model.effect.VideoTransitionModel;
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoTrackContainerView
  extends HorizontalScrollView
  implements IStateChangeListener, IValueChangeListener, TimeLineViewListener, VideoTrackTimeLineView.OnSlideChangedListener
{
  private int A = -1;
  private VideoTrackStoreListener B;
  private TrackSelectedStateChangeListener C;
  private VideoTrackContainerView.OnVideoClipClickListener D;
  private boolean E = true;
  private boolean F = true;
  private long G = 2147483647L;
  private OnTransitionListener H;
  private int I;
  private boolean J = false;
  private VideoTrackContainerView.OnStartTimeChangedListener K;
  private int L;
  private Runnable M = new VideoTrackContainerView.1(this);
  private VideoTrackContainerView.OnScrollStoppedListener N;
  private boolean O = false;
  private VideoThumbListener P = new VideoTrackContainerView.14(this);
  private Context a;
  private RelativeLayout b;
  private LinearLayout c;
  private int d = 0;
  private MvVideoViewModel e;
  private int f = 0;
  private ScaleAdapter g;
  private List<CutModelKt> h;
  private List<VideoTransitionModel> i;
  private boolean j = false;
  private boolean k = false;
  private List<VideoTrackTimeLineView> l = new ArrayList();
  private List<ImageView> m = new ArrayList();
  private ClipItemLongClickListener n = null;
  private ValueAnimator o;
  private boolean p = false;
  private boolean q = false;
  private ScaleTimeBar r;
  private IDragDropScrollListener s;
  private boolean t = false;
  private boolean u = true;
  private int v = 0;
  private int w = 0;
  private int x = 0;
  private int y = -1;
  private int z = -1;
  
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
    this.a = paramContext;
    j();
  }
  
  private int a(ImageView paramImageView)
  {
    Iterator localIterator = this.l.iterator();
    int i1 = -1;
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      int i2 = i1 + 1;
      i1 = i2;
      if (localVideoTrackTimeLineView.getTag() != null)
      {
        i1 = i2;
        if (localVideoTrackTimeLineView.getTag() == paramImageView) {
          return i2;
        }
      }
    }
    return -1;
  }
  
  private long a(int paramInt)
  {
    return (this.g.c(Math.abs(paramInt)) * 70 / this.g.f());
  }
  
  private void a(long paramLong)
  {
    ScaleAdapter localScaleAdapter = this.g;
    if (localScaleAdapter != null) {
      localScaleAdapter.a(paramLong);
    }
  }
  
  private void a(long paramLong, VideoTrackTimeLineView paramVideoTrackTimeLineView, VideoResourceModelKt paramVideoResourceModelKt)
  {
    long l2 = paramVideoResourceModelKt.getScaleDuration();
    long l1 = this.G;
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
        long l3 = this.G;
        l1 -= paramLong;
        paramLong = paramLong + l2 - l3;
      }
      paramVideoTrackTimeLineView.setRedMaskViewShowTimeRange(l1, paramLong);
    }
  }
  
  private void a(View paramView)
  {
    Iterator localIterator = this.l.iterator();
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
    this.q = true;
    this.o = ValueAnimator.ofInt(new int[] { paramInt, 0 });
    this.o.setDuration(a(paramInt));
    this.o.setInterpolator(new LinearInterpolator());
    int i1 = this.r.getScrollX();
    this.o.addUpdateListener(new VideoTrackContainerView.6(this, paramIDragView, i1, paramInt));
    this.o.addListener(new VideoTrackContainerView.7(this, paramIDragView));
    this.o.start();
  }
  
  private void a(IDragView paramIDragView, long paramLong1, long paramLong2, int paramInt)
  {
    this.w = this.y;
    this.x = this.z;
    a(getAllDuration());
    if (this.j)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onTimeLineChanged >> 拖动结束，滚动到当前滑块的起始位置:");
      ((StringBuilder)localObject).append(paramIDragView.getStartValue());
      AEQLog.b("miles", ((StringBuilder)localObject).toString());
      localObject = this.K;
      if (localObject != null) {
        ((VideoTrackContainerView.OnStartTimeChangedListener)localObject).a(paramIDragView.getStartValue());
      }
    }
    else if (this.k)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onTimeLineChanged >> 拖动结束，滚动到当前滑块的结束位置:");
      ((StringBuilder)localObject).append(paramIDragView.getEndValue());
      AEQLog.b("miles", ((StringBuilder)localObject).toString());
      localObject = this.K;
      if (localObject != null) {
        ((VideoTrackContainerView.OnStartTimeChangedListener)localObject).b(paramIDragView.getEndValue());
      }
    }
    this.j = false;
    this.k = false;
    this.u = true;
    paramIDragView = getSelectedVideoClip();
    Object localObject = this.B;
    if ((localObject != null) && (paramIDragView != null)) {
      ((VideoTrackStoreListener)localObject).a(paramIDragView.getUuid(), paramIDragView.getResource().getSelectTimeStartUs(), paramIDragView.getResource().getSelectTimeDurationUs());
    }
  }
  
  private void a(IDragView paramIDragView, LinearLayout.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramLayoutParams == null) {
      return;
    }
    if (!n()) {
      d(paramIDragView);
    }
    if (e(paramIDragView)) {
      paramLayoutParams.leftMargin = this.y;
    } else {
      paramLayoutParams.leftMargin = (-paramIDragView.getLeftSpace());
    }
    if (paramBoolean) {
      paramLayoutParams.rightMargin = this.z;
    } else {
      paramLayoutParams.rightMargin = (-paramIDragView.getRightSpace());
    }
    paramLayoutParams.width = (this.g.c(paramIDragView.getEndValue() - paramIDragView.getStartValue()) + paramIDragView.getLeftSpace() + paramIDragView.getRightSpace());
    paramLayoutParams.height = -1;
  }
  
  private VideoTransitionModel b(List<VideoTransitionModel> paramList, int paramInt)
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
  
  private void b(IDragView paramIDragView, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.p = true;
    this.o = ValueAnimator.ofInt(new int[] { paramInt, 0 });
    this.o.setDuration(a(paramInt));
    this.o.setInterpolator(new LinearInterpolator());
    int i1 = this.r.getScrollX();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)this.l.get(0)).getLayoutParams();
    this.o.addUpdateListener(new VideoTrackContainerView.8(this, paramIDragView, i1, paramInt));
    this.o.addListener(new VideoTrackContainerView.9(this, paramIDragView));
    this.o.start();
  }
  
  private void b(IDragView paramIDragView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.l.iterator();
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
  
  private void c(IDragView paramIDragView, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.q = true;
    this.o = ValueAnimator.ofInt(new int[] { paramInt, 0 });
    this.o.setDuration(a(paramInt));
    this.o.setInterpolator(new LinearInterpolator());
    int i1 = this.r.getScrollX();
    this.o.addUpdateListener(new VideoTrackContainerView.10(this, paramIDragView, i1, paramInt));
    this.o.addListener(new VideoTrackContainerView.11(this, paramIDragView));
    this.o.start();
  }
  
  private void d(IDragView paramIDragView)
  {
    this.y = (getScreenWidth() / 2 - paramIDragView.getLeftSpace());
    this.z = (getScreenWidth() / 2 - paramIDragView.getRightSpace());
    this.w = this.y;
    this.x = this.z;
  }
  
  private void d(IDragView paramIDragView, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.p = true;
    this.o = ValueAnimator.ofInt(new int[] { paramInt, 0 });
    this.o.setDuration(a(paramInt));
    this.o.setInterpolator(new LinearInterpolator());
    int i1 = this.r.getScrollX();
    Object localObject = this.l;
    localObject = (ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)((List)localObject).get(((List)localObject).size() - 1)).getLayoutParams();
    this.o.addUpdateListener(new VideoTrackContainerView.12(this, paramIDragView, i1, paramInt));
    this.o.addListener(new VideoTrackContainerView.13(this, paramIDragView));
    this.o.start();
  }
  
  private boolean e(IDragView paramIDragView)
  {
    return paramIDragView.getStartValue() == 0L;
  }
  
  private float getDefaultNeedScrollBySide()
  {
    return getResources().getDimension(2063859782);
  }
  
  private int getPieceViewOffSet()
  {
    return (int)getResources().getDimension(2063859762);
  }
  
  private int getScreenWidth()
  {
    return this.a.getResources().getDisplayMetrics().widthPixels;
  }
  
  private void j()
  {
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    this.b = new RelativeLayout(this.a);
    addView(this.b, (ViewGroup.LayoutParams)localObject);
    this.c = new BringToFrontLinearLayout(this.a);
    this.c.setOrientation(0);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.b.addView(this.c, (ViewGroup.LayoutParams)localObject);
    this.b.setOnClickListener(new VideoTrackContainerView.2(this));
    this.I = ViewUtils.dip2px(40.0F);
    VideoThumbProviderManager.getInstance().registerListener(this.P);
  }
  
  private void k()
  {
    this.c.removeAllViews();
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      ImageView localImageView = (ImageView)localIterator.next();
      this.b.removeView(localImageView);
    }
    this.m.clear();
    this.l.clear();
  }
  
  @RequiresApi(api=17)
  private ImageView l()
  {
    ImageView localImageView = new ImageView(getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      localImageView.setId(View.generateViewId());
    }
    localImageView.setImageResource(2063925485);
    localImageView.setOnClickListener(new VideoTrackContainerView.5(this));
    return localImageView;
  }
  
  private void m()
  {
    Iterator localIterator = this.l.iterator();
    int i2 = -1;
    int i1 = 0;
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      int i4 = i2 + 1;
      i2 = i4;
      if (localVideoTrackTimeLineView.getTag() != null)
      {
        ImageView localImageView = (ImageView)localVideoTrackTimeLineView.getTag();
        Object localObject = b(this.i, i4);
        int i3;
        if (localObject != null) {
          i3 = this.g.c((((VideoTransitionModel)localObject).getOverlapTime() / ((VideoTransitionModel)localObject).getSpeed()));
        } else {
          i3 = 0;
        }
        localObject = (LinearLayout.LayoutParams)localVideoTrackTimeLineView.getLayoutParams();
        i2 = i4;
        if (localObject != null)
        {
          i2 = this.g.c(localVideoTrackTimeLineView.getEndValue() - localVideoTrackTimeLineView.getStartValue()) + localVideoTrackTimeLineView.getLeftSpace() + localVideoTrackTimeLineView.getRightSpace() - i3;
          if (((LinearLayout.LayoutParams)localObject).width != i2)
          {
            ((LinearLayout.LayoutParams)localObject).width = i2;
            localVideoTrackTimeLineView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          i1 += ((LinearLayout.LayoutParams)localObject).leftMargin + ((LinearLayout.LayoutParams)localObject).width + ((LinearLayout.LayoutParams)localObject).rightMargin;
          localImageView.setX(i1 - getPieceViewOffSet());
          i2 = i4;
        }
      }
    }
  }
  
  private boolean n()
  {
    return (this.y != -1) && (this.z != -1);
  }
  
  private void o()
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.getTag() != null) {
        ((ImageView)localVideoTrackTimeLineView.getTag()).setX(localVideoTrackTimeLineView.getRight() - localVideoTrackTimeLineView.getRightSpace() - getPieceViewOffSet());
      }
    }
  }
  
  public long a(@NonNull View paramView, long paramLong)
  {
    return 0L;
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = this.o;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
    {
      this.o.cancel();
      this.o = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (getScrollX() == 0) && (paramInt2 == 0) && (getScrollY() == 0)) {
      return;
    }
    this.t = true;
    if (this.u) {
      scrollBy(paramInt1 - getScrollX(), paramInt2 - getScrollY());
    }
  }
  
  public void a(@NonNull IDragView paramIDragView) {}
  
  public void a(IDragView paramIDragView, long paramLong1, long paramLong2)
  {
    Object localObject1 = this.e;
    if ((localObject1 != null) && (((MvVideoViewModel)localObject1).a())) {
      this.e.c();
    }
    localObject1 = this.l.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoTrackTimeLineView)((Iterator)localObject1).next();
      if (((VideoTrackTimeLineView)localObject2).getLocalVisibleRect(new Rect())) {
        ((VideoTrackTimeLineView)localObject2).getVideoThumbnailView().invalidate();
      }
    }
    this.j = true;
    this.u = false;
    if ((!this.p) && (!this.q))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)this.l.get(0)).getLayoutParams();
      localObject2 = new int[2];
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)paramIDragView;
      localVideoTrackTimeLineView.getLocationOnScreen((int[])localObject2);
      paramLong1 = 0L;
      if ((paramLong2 <= 0L) && (localObject2[0] <= getDefaultNeedScrollBySide()))
      {
        a(paramIDragView, (int)localVideoTrackTimeLineView.getLeftToLeftCanMoveValue());
      }
      else if ((paramLong2 >= 0L) && (localObject2[0] >= getScreenWidth() - getDefaultNeedScrollBySide()))
      {
        b(paramIDragView, (int)localVideoTrackTimeLineView.getLeftToRightCanMoveValue());
      }
      else
      {
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = (this.w + this.g.c(paramLong2));
        localVideoTrackTimeLineView.getVideoThumbnailView().scrollTo(this.g.c(localVideoTrackTimeLineView.getLeftToLeftCanMoveValue()), localVideoTrackTimeLineView.getVideoThumbnailView().getScrollY());
      }
      if (this.e != null)
      {
        paramIDragView = this.l.iterator();
        while (paramIDragView.hasNext()) {
          paramLong1 += ((VideoTrackTimeLineView)paramIDragView.next()).getCurrentDuration();
        }
        this.e.a(paramLong1);
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
    TrackSelectedStateChangeListener localTrackSelectedStateChangeListener = this.C;
    if (localTrackSelectedStateChangeListener != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = getSelectVideoIndex();
      } else {
        i1 = 0;
      }
      localTrackSelectedStateChangeListener.a(paramIDragView, paramBoolean, i1);
    }
  }
  
  public void a(String paramString)
  {
    if (this.l.isEmpty()) {
      return;
    }
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (TextUtils.equals(paramString, localVideoTrackTimeLineView.getAssetPath())) {
        localVideoTrackTimeLineView.k();
      }
    }
  }
  
  @RequiresApi(api=17)
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.getMediaClipModel().getUuid().equals(paramString))
      {
        localVideoTrackTimeLineView.setShowSliderView(this.F);
        localVideoTrackTimeLineView.setSelected(true);
        if (paramBoolean) {
          localVideoTrackTimeLineView.l();
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
      this.h = paramList;
      k();
      long l1 = 0L;
      int i1 = 0;
      int i3;
      for (int i2 = 0; i1 < this.h.size(); i2 = i3)
      {
        Object localObject1 = (CutModelKt)this.h.get(i1);
        paramList = new VideoTrackTimeLineView(this.a);
        paramList.setBitmapWidth(this.I);
        paramList.setMediaClipModel((CutModelKt)localObject1);
        Object localObject2 = ((CutModelKt)localObject1).getResource();
        if (this.n != null) {
          paramList.setOnLongClickListener(new VideoTrackContainerView.3(this, (CutModelKt)localObject1));
        }
        i3 = ReorderViewIdManager.a.a(((CutModelKt)localObject1).getUuid());
        if (i3 != -1)
        {
          paramList.setId(i3);
        }
        else
        {
          if (Build.VERSION.SDK_INT >= 17) {
            paramList.setId(View.generateViewId());
          }
          ReorderViewIdManager.a.a(((CutModelKt)localObject1).getUuid(), paramList.getId());
        }
        paramList.setStartValue(l1);
        paramList.setEndValue(((VideoResourceModelKt)localObject2).getScaleDuration() + l1);
        paramList.setShowSliderView(this.F);
        paramList.setSelected(false);
        paramList.setSelectedStyle(this.v);
        i3 = this.A;
        if (i3 != -1) {
          paramList.setCornerRadius(i3);
        }
        if (this.E) {
          paramList.setOnClickListener(new VideoTrackContainerView.4(this, i1));
        }
        paramList.setValueChangeListener(this);
        paramList.setStateChangeListener(this);
        paramList.setTimeLineViewListener(this);
        paramList.setOnSlideChangedListener(this);
        paramList.setScaleModel(this.g);
        localObject1 = new LinearLayout.LayoutParams(-2, -2);
        boolean bool;
        if (i1 == this.h.size() - 1) {
          bool = true;
        } else {
          bool = false;
        }
        a(paramList, (LinearLayout.LayoutParams)localObject1, bool);
        a(l1, paramList, (VideoResourceModelKt)localObject2);
        paramList.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.c.addView(paramList);
        this.l.add(paramList);
        l1 += ((VideoResourceModelKt)localObject2).getScaleDuration();
        i3 = i2;
        if (this.J)
        {
          i3 = i2;
          if (i1 < this.h.size() - 1)
          {
            localObject2 = l();
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(29.0F), ViewUtils.dip2px(29.0F));
            localLayoutParams.topMargin = this.b.getPaddingTop();
            i3 = i2 + (((LinearLayout.LayoutParams)localObject1).leftMargin + ((LinearLayout.LayoutParams)localObject1).width + ((LinearLayout.LayoutParams)localObject1).rightMargin);
            ((ImageView)localObject2).setX(i3 - getPieceViewOffSet());
            this.b.addView((View)localObject2, localLayoutParams);
            this.m.add(localObject2);
            paramList.setTag(localObject2);
            paramList = new StringBuilder();
            paramList.append("add piece view,x:");
            paramList.append(((ImageView)localObject2).getX());
            AEQLog.a("VideoTrackContainerView", paramList.toString());
          }
        }
        i1 += 1;
      }
      if (this.J) {
        d();
      }
    }
  }
  
  public void a(List<VideoTransitionModel> paramList, int paramInt)
  {
    this.i = paramList;
    if (paramList == null) {
      return;
    }
    int i1 = -1;
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoTrackTimeLineView)localIterator.next();
      int i2 = i1 + 1;
      i1 = i2;
      if (((VideoTrackTimeLineView)localObject).getTag() != null)
      {
        localObject = (ImageView)((VideoTrackTimeLineView)localObject).getTag();
        if (b(paramList, i2) != null) {
          ((ImageView)localObject).setImageResource(2063925539);
        } else {
          ((ImageView)localObject).setImageResource(2063925485);
        }
        if (paramInt == i2)
        {
          ((ImageView)localObject).setSelected(true);
          i1 = i2;
        }
        else
        {
          ((ImageView)localObject).setSelected(false);
          i1 = i2;
        }
      }
    }
    m();
    d();
  }
  
  public void a(boolean paramBoolean)
  {
    this.O = paramBoolean;
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
  
  public long b(@NonNull View paramView, long paramLong)
  {
    return 0L;
  }
  
  public long b(IDragView paramIDragView)
  {
    long l1 = 0L;
    int i1 = 0;
    while (i1 < this.l.size())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)this.l.get(i1);
      if (paramIDragView == localVideoTrackTimeLineView) {
        return l1;
      }
      l1 += this.g.b(localVideoTrackTimeLineView.getWidth() - localVideoTrackTimeLineView.getLeftSpace() - localVideoTrackTimeLineView.getRightSpace());
      i1 += 1;
    }
    return l1;
  }
  
  public void b(IDragView paramIDragView, long paramLong1, long paramLong2)
  {
    Object localObject1 = this.e;
    if ((localObject1 != null) && (((MvVideoViewModel)localObject1).a())) {
      this.e.c();
    }
    localObject1 = this.l.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (VideoTrackTimeLineView)((Iterator)localObject1).next();
      if (((VideoTrackTimeLineView)localObject2).getLocalVisibleRect(new Rect())) {
        ((VideoTrackTimeLineView)localObject2).getVideoThumbnailView().invalidate();
      }
    }
    this.k = true;
    if ((!this.p) && (!this.q))
    {
      localObject1 = this.l;
      localObject1 = (ViewGroup.MarginLayoutParams)((VideoTrackTimeLineView)((List)localObject1).get(((List)localObject1).size() - 1)).getLayoutParams();
      localObject2 = new int[2];
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)paramIDragView;
      localVideoTrackTimeLineView.getLocationOnScreen((int[])localObject2);
      paramLong1 = 0L;
      if ((paramLong2 <= 0L) && (localObject2[0] + localVideoTrackTimeLineView.getWidth() <= getDefaultNeedScrollBySide())) {
        c(paramIDragView, (int)localVideoTrackTimeLineView.getRightToLeftCanMoveValue());
      } else if ((paramLong2 >= 0L) && (localObject2[0] + localVideoTrackTimeLineView.getWidth() >= getScreenWidth() - getDefaultNeedScrollBySide())) {
        d(paramIDragView, (int)localVideoTrackTimeLineView.getRightToRightCanMoveValue());
      } else {
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = (this.x - this.g.c(paramLong2));
      }
      if (this.e != null)
      {
        paramIDragView = this.l.iterator();
        while (paramIDragView.hasNext()) {
          paramLong1 += ((VideoTrackTimeLineView)paramIDragView.next()).getCurrentDuration();
        }
        this.e.a(paramLong1);
      }
      return;
    }
    AEQLog.b("miles", "正在滚动，直接返回");
  }
  
  public void b(List<VideoTransitionModel> paramList)
  {
    this.i = paramList;
    paramList = this.l.iterator();
    int i1 = -1;
    while (paramList.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)paramList.next();
      int i3 = i1 + 1;
      Object localObject = b(this.i, i3);
      int i2 = 0;
      if (localObject != null) {
        i2 = this.g.c((((VideoTransitionModel)localObject).getOverlapTime() / ((VideoTransitionModel)localObject).getSpeed()));
      }
      localObject = (LinearLayout.LayoutParams)localVideoTrackTimeLineView.getLayoutParams();
      i1 = i3;
      if (localObject != null)
      {
        i2 = this.g.c(localVideoTrackTimeLineView.getEndValue() - localVideoTrackTimeLineView.getStartValue()) + localVideoTrackTimeLineView.getLeftSpace() + localVideoTrackTimeLineView.getRightSpace() - i2;
        i1 = i3;
        if (((LinearLayout.LayoutParams)localObject).width != i2)
        {
          ((LinearLayout.LayoutParams)localObject).width = i2;
          localVideoTrackTimeLineView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          i1 = i3;
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.p;
  }
  
  public long c(IDragView paramIDragView)
  {
    long l1 = 0L;
    int i1 = 0;
    while (i1 < this.l.size())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)this.l.get(i1);
      l1 += this.g.b(localVideoTrackTimeLineView.getWidth() - localVideoTrackTimeLineView.getLeftSpace() - localVideoTrackTimeLineView.getRightSpace());
      if (paramIDragView == localVideoTrackTimeLineView) {
        return l1;
      }
      i1 += 1;
    }
    return l1;
  }
  
  public boolean c()
  {
    return this.q;
  }
  
  public void d()
  {
    Iterator localIterator = this.l.iterator();
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
  
  public void e()
  {
    if (!this.j)
    {
      if (this.k) {
        return;
      }
      Object localObject = this.l.iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)((Iterator)localObject).next();
        if (localVideoTrackTimeLineView.isSelected())
        {
          localObject = new int[2];
          localVideoTrackTimeLineView.getLocationOnScreen((int[])localObject);
          if ((localObject[0] + localVideoTrackTimeLineView.getWidth() < getScreenWidth() / 2) || (localObject[0] > getScreenWidth() / 2)) {
            localVideoTrackTimeLineView.setSelected(false);
          }
        }
      }
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.isSelected()) {
        localVideoTrackTimeLineView.setSelected(false);
      }
    }
  }
  
  public void g()
  {
    o();
  }
  
  public long getAllDuration()
  {
    Iterator localIterator = this.l.iterator();
    for (long l1 = 0L; localIterator.hasNext(); l1 += ((VideoTrackTimeLineView)localIterator.next()).getMediaClipModel().getResource().getScaleDuration()) {}
    int i1 = 0;
    localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      VideoTransitionModel localVideoTransitionModel = (VideoTransitionModel)localIterator.next();
      i1 = (int)(i1 + localVideoTransitionModel.getOverlapTime() / localVideoTransitionModel.getSpeed());
    }
    return l1 - i1;
  }
  
  public ViewGroup getContentView()
  {
    return this.c;
  }
  
  public int getCurrentClipIndex()
  {
    if (this.g != null)
    {
      if (CollectionUtils.isEmpty(this.l)) {
        return -1;
      }
      long l2 = this.g.d();
      long l1 = 0L;
      int i1 = 0;
      while (i1 < this.l.size())
      {
        VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)this.l.get(i1);
        if (localVideoTrackTimeLineView != null)
        {
          long l3 = localVideoTrackTimeLineView.getEndValue() - localVideoTrackTimeLineView.getStartValue();
          if ((l1 <= l2) && (l2 < l1 + l3)) {
            break label115;
          }
          l1 += l3;
        }
        i1 += 1;
      }
      i1 = -1;
      label115:
      int i2 = i1;
      if (i1 == -1) {
        i2 = this.l.size() - 1;
      }
      return i2;
    }
    return -1;
  }
  
  public List<CutModelKt> getCurrentMediaClips()
  {
    return this.h;
  }
  
  public float getLengthPerMs()
  {
    if (CollectionUtils.isEmpty(this.l)) {
      return 0.0F;
    }
    Object localObject = (VideoTrackTimeLineView)this.l.get(0);
    if (localObject == null) {
      return 0.0F;
    }
    CutModelKt localCutModelKt = ((VideoTrackTimeLineView)localObject).getMediaClipModel();
    localObject = ((VideoTrackTimeLineView)localObject).getVideoThumbnailView();
    if ((localCutModelKt != null) && (localCutModelKt.getResource() != null))
    {
      if (localObject == null) {
        return 0.0F;
      }
      return ((PlayTrackExpandWidthView)localObject).getWidth() * 1.0F / (float)localCutModelKt.getResource().getScaleDuration();
    }
    return 0.0F;
  }
  
  public int getSelectVideoIndex()
  {
    int i1 = 0;
    while (i1 < this.l.size())
    {
      if (((VideoTrackTimeLineView)this.l.get(i1)).isSelected()) {
        return i1;
      }
      i1 += 1;
    }
    return 0;
  }
  
  public IDragView getSelectedDragView()
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.isSelected()) {
        return localVideoTrackTimeLineView;
      }
    }
    return null;
  }
  
  public CutModelKt getSelectedVideoClip()
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      if (localVideoTrackTimeLineView.isSelected()) {
        return localVideoTrackTimeLineView.getMediaClipModel();
      }
    }
    return null;
  }
  
  public void h()
  {
    Iterator localIterator = this.l.iterator();
    long l1 = 0L;
    int i1 = 0;
    while (localIterator.hasNext())
    {
      VideoTrackTimeLineView localVideoTrackTimeLineView = (VideoTrackTimeLineView)localIterator.next();
      VideoResourceModelKt localVideoResourceModelKt = localVideoTrackTimeLineView.getMediaClipModel().getResource();
      localVideoTrackTimeLineView.setStartValue(l1);
      localVideoTrackTimeLineView.setEndValue(localVideoResourceModelKt.getScaleDuration() + l1);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localVideoTrackTimeLineView.getLayoutParams();
      int i2 = this.l.size();
      boolean bool = true;
      if (i1 != i2 - 1) {
        bool = false;
      }
      a(localVideoTrackTimeLineView, localLayoutParams, bool);
      localVideoTrackTimeLineView.setLayoutParams(localVideoTrackTimeLineView.getLayoutParams());
      l1 += localVideoResourceModelKt.getScaleDuration();
      localVideoTrackTimeLineView.j();
      i1 += 1;
    }
    if (this.J)
    {
      m();
      return;
    }
    b(this.i);
  }
  
  public void i()
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext()) {
      ((VideoTrackTimeLineView)localIterator.next()).k();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    VideoThumbProviderManager.getInstance().unRegisterListener(this.P);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.s;
    if ((localObject != null) && (!this.t)) {
      ((IDragDropScrollListener)localObject).a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    localObject = this.l.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((VideoTrackTimeLineView)((Iterator)localObject).next()).a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      this.t = false;
      if (this.N != null) {
        post(this.M);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBitmapWidth(int paramInt)
  {
    this.I = paramInt;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
    this.E = paramBoolean;
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext()) {
      ((VideoTrackTimeLineView)localIterator.next()).setClickable(paramBoolean);
    }
  }
  
  public void setContentPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout localRelativeLayout = this.b;
    if (localRelativeLayout != null) {
      localRelativeLayout.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setCornerRadius(int paramInt)
  {
    this.A = paramInt;
  }
  
  public void setItemOnLongClickListener(ClipItemLongClickListener paramClipItemLongClickListener)
  {
    this.n = paramClipItemLongClickListener;
  }
  
  public void setMaxDurationLimit(long paramLong)
  {
    if (paramLong > 0L) {
      this.G = paramLong;
    }
  }
  
  public void setOnScrollStoppedListener(VideoTrackContainerView.OnScrollStoppedListener paramOnScrollStoppedListener)
  {
    this.N = paramOnScrollStoppedListener;
  }
  
  public void setOnStartTimeChangedListener(VideoTrackContainerView.OnStartTimeChangedListener paramOnStartTimeChangedListener)
  {
    this.K = paramOnStartTimeChangedListener;
  }
  
  public void setOnTransitionListener(OnTransitionListener paramOnTransitionListener)
  {
    this.H = paramOnTransitionListener;
  }
  
  public void setScaleAdapter(ScaleAdapter paramScaleAdapter)
  {
    this.g = paramScaleAdapter;
  }
  
  public void setScrollByPassive(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void setScrollListener(IDragDropScrollListener paramIDragDropScrollListener)
  {
    this.s = paramIDragDropScrollListener;
  }
  
  public void setSelectedStateListener(TrackSelectedStateChangeListener paramTrackSelectedStateChangeListener)
  {
    this.C = paramTrackSelectedStateChangeListener;
  }
  
  public void setShowLeftAndRightSliderView(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }
  
  public void setShowPieces(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }
  
  public void setTimeBar(ScaleTimeBar paramScaleTimeBar)
  {
    this.r = paramScaleTimeBar;
  }
  
  public void setVideoClipClickListener(VideoTrackContainerView.OnVideoClipClickListener paramOnVideoClipClickListener)
  {
    this.D = paramOnVideoClipClickListener;
  }
  
  public void setVideoModel(MvVideoViewModel paramMvVideoViewModel)
  {
    this.e = paramMvVideoViewModel;
  }
  
  public void setVideoTrackSelectedStyle(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void setVideoTrackStoreListener(VideoTrackStoreListener paramVideoTrackStoreListener)
  {
    this.B = paramVideoTrackStoreListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView
 * JD-Core Version:    0.7.0.1
 */
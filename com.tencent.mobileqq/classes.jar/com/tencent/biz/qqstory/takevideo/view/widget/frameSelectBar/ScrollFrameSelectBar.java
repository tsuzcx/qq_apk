package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.OnPlayRecycleListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;

public class ScrollFrameSelectBar
  extends FrameLayout
  implements TrimTextureVideoView.OnPlayRecycleListener, IMediaPlayer.OnSeekCompleteListener, RangeSelectBar.RangeChangeListener
{
  public static int a = 15;
  public static int b = 15;
  private int c = 1000;
  private HorizontalListView d;
  private RangeSelectBar e;
  private ProgressPointer f;
  private FrameAdapter g;
  private FrameLoader h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p = 20000;
  private ScrollFrameSelectBar.OnRangeValueChangeListener q;
  private TrimTextureVideoView r;
  private int s = 1000;
  private int t = 0;
  private int u = this.s * 10;
  private int v;
  private int w;
  private int x;
  
  public ScrollFrameSelectBar(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public ScrollFrameSelectBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  public ScrollFrameSelectBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
  }
  
  @TargetApi(10)
  private void f()
  {
    this.j = UIUtils.b(getContext());
    this.k = UIUtils.a(getContext(), a);
    this.l = UIUtils.a(getContext(), b);
    LayoutInflater.from(getContext()).inflate(2131629214, this);
    this.d = ((HorizontalListView)findViewById(2131445365));
    this.d.setOverScrollMode(2);
    this.e = ((RangeSelectBar)findViewById(2131445366));
    this.f = ((ProgressPointer)findViewById(2131442694));
    this.e.setRangeChangeListener(this);
    this.m = this.d.getPaddingLeft();
    this.n = this.d.getPaddingRight();
    this.o = ((FrameLayout.LayoutParams)this.d.getLayoutParams()).rightMargin;
    this.d.setOnScrollStateChangedListener(new ScrollFrameSelectBar.1(this));
    if ("tribe".equals(((Activity)getContext()).getIntent().getStringExtra("video_refer"))) {
      this.s = (AECameraConstants.VIDEO_DURATION_FOR_TRIBE / 10);
    }
  }
  
  public void a()
  {
    if (this.r != null) {
      this.f.setRange(this.e.getStartIndex(), this.e.getEndIndex(), this.u - this.r.getRealStartTime());
    }
    this.f.b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder;
    if ((paramInt2 >= 0) && (paramInt3 > 0) && (paramInt1 >= 0))
    {
      this.d.scrollBy2(paramInt1);
      this.e.setStartIndex(paramInt2);
      this.e.setEndIndex(paramInt3);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeSelectBarState rememberUI startIndex : ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" endIndex : ");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append(" scrollX : ");
        localStringBuilder.append(paramInt1);
        QLog.d("Q.qqstory.frameWidget.ScrollFrameSelectBar", 2, localStringBuilder.toString());
      }
      return;
    }
    if ((paramLong2 < 20L) && (paramLong1 > paramLong2))
    {
      paramInt1 = (int)((float)paramLong1 / this.s * this.i + this.e.getPadding());
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeSelectBarState startTime : ");
        localStringBuilder.append(paramLong2);
        localStringBuilder.append(" endIndex : ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" endTime : ");
        localStringBuilder.append(paramLong1);
        QLog.d("Q.qqstory.frameWidget.ScrollFrameSelectBar", 2, localStringBuilder.toString());
      }
      this.d.scrollBy2(0);
      this.e.setStartIndex(0);
      this.e.setEndIndex(paramInt1);
    }
  }
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    this.f.a();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    int i1 = getResources().getDisplayMetrics().widthPixels;
    i1 = getResources().getDisplayMetrics().heightPixels;
    int i2 = this.w;
    this.v = paramInt1;
    if (paramInt4 != 1)
    {
      if (paramBoolean2)
      {
        paramInt4 = this.v;
        if (paramInt4 > 60000)
        {
          this.s = 6000;
          paramInt4 = (int)Math.ceil(paramInt4 * 1.0F / this.s);
          f1 = this.v * 1.0F;
          i1 = this.s;
        }
        else
        {
          this.s = ((int)Math.ceil(paramInt4 * 1.0F / 10.0F));
          f1 = 10;
          this.l = 0;
          break label357;
        }
      }
      else
      {
        if ("tribe".equals(((Activity)getContext()).getIntent().getStringExtra("video_refer"))) {
          this.s = (AECameraConstants.VIDEO_DURATION_FOR_TRIBE / 10);
        } else {
          this.s = (this.p / 10);
        }
        paramInt4 = (int)Math.ceil(this.v * 1.0F / this.s);
        i1 = this.v;
        f1 = i1 * 1.0F / this.s;
        if (paramInt4 <= 10) {
          this.s = ((int)Math.ceil(i1 * 1.0F / paramInt4));
        }
        break label361;
      }
    }
    else
    {
      paramInt4 = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getCameraCaptureMaxDuration();
      i1 = this.v;
      if (i1 <= paramInt4 * 1000) {
        break label334;
      }
      this.s = (paramInt4 * 100);
      paramInt4 = (int)Math.ceil(i1 * 1.0F / this.s);
      f1 = this.v * 1.0F;
      i1 = this.s;
    }
    f1 /= i1;
    break label361;
    label334:
    this.s = ((int)Math.ceil(i1 * 1.0F / 10.0F));
    float f1 = 10;
    label357:
    paramInt4 = 10;
    label361:
    this.i = ((i2 - this.k - this.l) / 10);
    float f2 = paramInt3 / paramInt2;
    paramInt2 = this.i;
    paramInt3 = (int)(f2 * paramInt2);
    paramInt2 = (int)(paramInt2 * TakeVideoUtils.b(getResources()));
    this.g = new FrameAdapter(getContext(), paramInt4, this.i, paramInt2);
    this.h = new FrameLoader("frame_loader", this.i, paramInt3, paramBoolean1);
    this.h.a(paramString, paramInt1, this.s);
    this.g.a(this.h);
    paramInt1 = paramInt4;
    if (paramInt4 > 10) {
      paramInt1 = 10;
    }
    ((FrameLayout.LayoutParams)this.d.getLayoutParams()).rightMargin = (i2 - this.k - this.l - paramInt1 * this.i);
    this.d.setAdapter(this.g);
    f2 = f1;
    if (f1 > 10.0F) {
      f2 = 10.0F;
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 100;
    }
    this.e.setFrameSize(paramInt1, this.i, this.s, f2, this.c);
    this.f.setFrameSize(paramInt1, this.i);
    this.e.setVisibility(0);
    c();
  }
  
  public void b()
  {
    d();
  }
  
  public void c()
  {
    Object localObject = getSelectionTime();
    if (localObject != null)
    {
      if (localObject.length < 2) {
        return;
      }
      this.t = localObject[0];
      this.u = localObject[1];
      if (this.r.isPlaying()) {
        this.r.c();
      }
      this.r.setPlayRange(this.t, this.u);
      this.r.a(true);
      localObject = this.q;
      if (localObject != null) {
        ((ScrollFrameSelectBar.OnRangeValueChangeListener)localObject).a(this.t, this.u);
      }
      this.f.setRange(this.e.getStartIndex(), this.e.getEndIndex(), this.u - this.r.getRealStartTime());
      this.f.b();
    }
  }
  
  public void d()
  {
    int[] arrayOfInt = getSelectionTime();
    if (arrayOfInt != null)
    {
      if (arrayOfInt.length < 2) {
        return;
      }
      ScrollFrameSelectBar.OnRangeValueChangeListener localOnRangeValueChangeListener = this.q;
      if (localOnRangeValueChangeListener != null) {
        localOnRangeValueChangeListener.b(arrayOfInt[0], arrayOfInt[1]);
      }
    }
  }
  
  @TargetApi(10)
  public void e()
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((FrameAdapter)localObject).a();
    }
    localObject = this.h;
    if (localObject != null) {
      ((FrameLoader)localObject).b();
    }
  }
  
  public int getEndIndex()
  {
    return this.e.getEndIndex();
  }
  
  public int getRangeScrollX()
  {
    View localView = this.d.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int i1 = this.d.getFirstVisiblePosition();
    return -(localView.getLeft() - this.m) + i1 * localView.getWidth();
  }
  
  public int[] getSelectionTime()
  {
    View localView = this.d.getChildAt(0);
    if (localView == null) {
      return null;
    }
    int i1 = this.d.getFirstVisiblePosition();
    int i2 = localView.getLeft();
    int i3 = this.m;
    float f1 = this.e.getStartIndex();
    float f2 = this.e.getEndIndex();
    float f3 = this.s;
    float f4 = -(i2 - i3);
    float f5 = f4 / localView.getWidth();
    float f6 = i1 * f3;
    i3 = (int)(f5 * f3 + f6 + (f1 - this.e.getPadding()) / this.i * f3);
    int i4 = (int)(f4 / localView.getWidth() * f3 + f6 + (f2 - this.e.getPadding()) / this.i * f3);
    int i5 = this.c;
    i1 = i4;
    i2 = i3;
    if (i4 - i3 < i5) {
      if (i3 >= i5)
      {
        i2 = i4 - i5;
        i1 = i4;
      }
      else
      {
        i1 = i3 + i5;
        i2 = i3;
      }
    }
    return new int[] { i2, i1 };
  }
  
  public int getStartIndex()
  {
    return this.e.getStartIndex();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.w = View.MeasureSpec.getSize(paramInt1);
    this.x = View.MeasureSpec.getSize(paramInt2);
  }
  
  public void setLocalVideoView(TrimTextureVideoView paramTrimTextureVideoView)
  {
    this.r = paramTrimTextureVideoView;
    paramTrimTextureVideoView.setOnRecyclePlayListener(this);
    paramTrimTextureVideoView.setOnSeekCompleteListener(this);
  }
  
  public void setMaxVideoDuration(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setMinDuration(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setOnRangeValueChangeListener(ScrollFrameSelectBar.OnRangeValueChangeListener paramOnRangeValueChangeListener)
  {
    this.q = paramOnRangeValueChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */
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
  private TrimTextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView;
  private FrameAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameAdapter;
  private FrameLoader jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader;
  private ProgressPointer jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer;
  private RangeSelectBar jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar;
  private ScrollFrameSelectBar.OnRangeValueChangeListener jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$OnRangeValueChangeListener;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private int c = 1000;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k = 20000;
  private int l = 1000;
  private int m = 0;
  private int n = this.l * 10;
  private int o;
  private int p;
  private int q;
  
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
    this.e = UIUtils.a(getContext());
    this.f = UIUtils.a(getContext(), jdField_a_of_type_Int);
    this.g = UIUtils.a(getContext(), b);
    LayoutInflater.from(getContext()).inflate(2131562769, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131377001));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar = ((RangeSelectBar)findViewById(2131377002));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer = ((ProgressPointer)findViewById(2131374524));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setRangeChangeListener(this);
    this.h = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getPaddingLeft();
    this.i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getPaddingRight();
    this.j = ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams()).rightMargin;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(new ScrollFrameSelectBar.1(this));
    if ("tribe".equals(((Activity)getContext()).getIntent().getStringExtra("video_refer"))) {
      this.l = (AECameraConstants.jdField_a_of_type_Int / 10);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.setRange(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.b(), this.n - this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.b();
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
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.scrollBy2(paramInt1);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setStartIndex(paramInt2);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setEndIndex(paramInt3);
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
      paramInt1 = (int)((float)paramLong1 / this.l * this.d + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.c());
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
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.scrollBy2(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setStartIndex(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setEndIndex(paramInt1);
    }
  }
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.a();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    int i1 = getResources().getDisplayMetrics().widthPixels;
    i1 = getResources().getDisplayMetrics().heightPixels;
    int i2 = this.p;
    this.o = paramInt1;
    if (paramInt4 != 1)
    {
      if (paramBoolean2)
      {
        paramInt4 = this.o;
        if (paramInt4 > 60000)
        {
          this.l = 6000;
          paramInt4 = (int)Math.ceil(paramInt4 * 1.0F / this.l);
          f1 = this.o * 1.0F;
          i1 = this.l;
        }
        else
        {
          this.l = ((int)Math.ceil(paramInt4 * 1.0F / 10.0F));
          f1 = 10;
          this.g = 0;
          break label357;
        }
      }
      else
      {
        if ("tribe".equals(((Activity)getContext()).getIntent().getStringExtra("video_refer"))) {
          this.l = (AECameraConstants.jdField_a_of_type_Int / 10);
        } else {
          this.l = (this.k / 10);
        }
        paramInt4 = (int)Math.ceil(this.o * 1.0F / this.l);
        i1 = this.o;
        f1 = i1 * 1.0F / this.l;
        if (paramInt4 <= 10) {
          this.l = ((int)Math.ceil(i1 * 1.0F / paramInt4));
        }
        break label361;
      }
    }
    else
    {
      paramInt4 = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getCameraCaptureMaxDuration();
      i1 = this.o;
      if (i1 <= paramInt4 * 1000) {
        break label334;
      }
      this.l = (paramInt4 * 100);
      paramInt4 = (int)Math.ceil(i1 * 1.0F / this.l);
      f1 = this.o * 1.0F;
      i1 = this.l;
    }
    f1 /= i1;
    break label361;
    label334:
    this.l = ((int)Math.ceil(i1 * 1.0F / 10.0F));
    float f1 = 10;
    label357:
    paramInt4 = 10;
    label361:
    this.d = ((i2 - this.f - this.g) / 10);
    float f2 = paramInt3 / paramInt2;
    paramInt2 = this.d;
    paramInt3 = (int)(f2 * paramInt2);
    paramInt2 = (int)(paramInt2 * TakeVideoUtils.a(getResources()));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameAdapter = new FrameAdapter(getContext(), paramInt4, this.d, paramInt2);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader = new FrameLoader("frame_loader", this.d, paramInt3, paramBoolean1);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader.a(paramString, paramInt1, this.l);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader);
    paramInt1 = paramInt4;
    if (paramInt4 > 10) {
      paramInt1 = 10;
    }
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams()).rightMargin = (i2 - this.f - this.g - paramInt1 * this.d);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameAdapter);
    f2 = f1;
    if (f1 > 10.0F) {
      f2 = 10.0F;
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 100;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setFrameSize(paramInt1, this.d, this.l, f2, this.c);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.setFrameSize(paramInt1, this.d);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setVisibility(0);
    c();
  }
  
  public int[] a()
  {
    View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0);
    if (localView == null) {
      return null;
    }
    int i1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int i2 = localView.getLeft();
    int i3 = this.h;
    float f1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.a();
    float f2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.b();
    float f3 = this.l;
    float f4 = -(i2 - i3);
    float f5 = f4 / localView.getWidth();
    float f6 = i1 * f3;
    i3 = (int)(f5 * f3 + f6 + (f1 - this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.c()) / this.d * f3);
    int i4 = (int)(f4 / localView.getWidth() * f3 + f6 + (f2 - this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.c()) / this.d * f3);
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
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.b();
  }
  
  public void b()
  {
    d();
  }
  
  public int c()
  {
    View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int i1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    return -(localView.getLeft() - this.h) + i1 * localView.getWidth();
  }
  
  public void c()
  {
    Object localObject = a();
    if (localObject != null)
    {
      if (localObject.length < 2) {
        return;
      }
      this.m = localObject[0];
      this.n = localObject[1];
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.isPlaying()) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.b();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setPlayRange(this.m, this.n);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a(true);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$OnRangeValueChangeListener;
      if (localObject != null) {
        ((ScrollFrameSelectBar.OnRangeValueChangeListener)localObject).a(this.m, this.n);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.setRange(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.b(), this.n - this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.b();
    }
  }
  
  public void d()
  {
    int[] arrayOfInt = a();
    if (arrayOfInt != null)
    {
      if (arrayOfInt.length < 2) {
        return;
      }
      ScrollFrameSelectBar.OnRangeValueChangeListener localOnRangeValueChangeListener = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$OnRangeValueChangeListener;
      if (localOnRangeValueChangeListener != null) {
        localOnRangeValueChangeListener.b(arrayOfInt[0], arrayOfInt[1]);
      }
    }
  }
  
  @TargetApi(10)
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameAdapter;
    if (localObject != null) {
      ((FrameAdapter)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader;
    if (localObject != null) {
      ((FrameLoader)localObject).a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.p = View.MeasureSpec.getSize(paramInt1);
    this.q = View.MeasureSpec.getSize(paramInt2);
  }
  
  public void setLocalVideoView(TrimTextureVideoView paramTrimTextureVideoView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView = paramTrimTextureVideoView;
    paramTrimTextureVideoView.setOnRecyclePlayListener(this);
    paramTrimTextureVideoView.setOnSeekCompleteListener(this);
  }
  
  public void setMaxVideoDuration(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setMinDuration(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setOnRangeValueChangeListener(ScrollFrameSelectBar.OnRangeValueChangeListener paramOnRangeValueChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$OnRangeValueChangeListener = paramOnRangeValueChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */
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
import bmhv;
import bmuy;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import pkh;
import xkn;
import xlu;
import xma;
import ypx;
import zbw;
import zby;
import zcb;
import zcc;
import zcd;

public class ScrollFrameSelectBar
  extends FrameLayout
  implements xkn, xma, zcb
{
  public static int a;
  public static int b = 15;
  private TrimTextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView;
  private ProgressPointer jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer;
  private RangeSelectBar jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private zbw jdField_a_of_type_Zbw;
  private zby jdField_a_of_type_Zby;
  private zcd jdField_a_of_type_Zcd;
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
  private int m;
  private int n = this.l * 10;
  private int o;
  private int p;
  private int q;
  
  static
  {
    jdField_a_of_type_Int = 15;
  }
  
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
    this.e = UIUtils.getWindowScreenWidth(getContext());
    this.f = UIUtils.dip2px(getContext(), jdField_a_of_type_Int);
    this.g = UIUtils.dip2px(getContext(), b);
    LayoutInflater.from(getContext()).inflate(2131562803, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131377137));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar = ((RangeSelectBar)findViewById(2131377138));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer = ((ProgressPointer)findViewById(2131374622));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setRangeChangeListener(this);
    this.h = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getPaddingLeft();
    this.i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getPaddingRight();
    this.j = ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams()).rightMargin;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(new zcc(this));
    if ("tribe".equals(((Activity)getContext()).getIntent().getStringExtra("video_refer"))) {
      this.l = (bmuy.jdField_a_of_type_Int / 10);
    }
  }
  
  public int a()
  {
    return this.m;
  }
  
  public void a()
  {
    d();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    if ((paramInt2 >= 0) && (paramInt3 > 0) && (paramInt1 >= 0))
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.scrollBy2(paramInt1);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setStartIndex(paramInt2);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setEndIndex(paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.frameWidget.ScrollFrameSelectBar", 2, "changeSelectBarState rememberUI startIndex : " + paramInt2 + " endIndex : " + paramInt3 + " scrollX : " + paramInt1);
      }
    }
    while ((paramLong2 >= 20L) || (paramLong1 <= paramLong2)) {
      return;
    }
    paramInt1 = (int)((float)paramLong1 / this.l * this.d + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.c());
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.frameWidget.ScrollFrameSelectBar", 2, "changeSelectBarState startTime : " + paramLong2 + " endIndex : " + paramInt1 + " endTime : " + paramLong1);
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.scrollBy2(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setStartIndex(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setEndIndex(paramInt1);
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (this.jdField_a_of_type_Zbw == null) {
      return;
    }
    this.jdField_a_of_type_Zbw.a(paramLocalMediaInfo);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    int i1 = getResources().getDisplayMetrics().widthPixels;
    i1 = getResources().getDisplayMetrics().heightPixels;
    i1 = this.p;
    this.o = paramInt1;
    float f1;
    switch (paramInt4)
    {
    default: 
      if (paramBoolean2) {
        if (this.o > 60000)
        {
          this.l = 6000;
          paramInt4 = (int)Math.ceil(this.o * 1.0F / this.l);
          f1 = this.o * 1.0F / this.l;
          this.d = ((i1 - this.f - this.g) / 10);
          paramInt3 = (int)(paramInt3 / paramInt2 * this.d);
          paramInt2 = (int)(this.d * ypx.a(getResources()));
          this.jdField_a_of_type_Zbw = new zbw(getContext(), paramInt4, this.d, paramInt2);
          this.jdField_a_of_type_Zby = new zby("frame_loader", this.d, paramInt3, paramBoolean1);
          this.jdField_a_of_type_Zby.a(paramString, paramInt1, this.l);
          this.jdField_a_of_type_Zbw.a(this.jdField_a_of_type_Zby);
          if (paramInt4 <= 10) {
            break label609;
          }
        }
      }
      break;
    }
    label609:
    for (paramInt1 = 10;; paramInt1 = paramInt4)
    {
      ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams()).rightMargin = (i1 - this.f - this.g - paramInt1 * this.d);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Zbw);
      if (f1 > 10.0F) {
        f1 = 10.0F;
      }
      for (;;)
      {
        if (paramInt2 <= 0) {}
        for (paramInt1 = 100;; paramInt1 = paramInt2)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setFrameSize(paramInt1, this.d, this.l, f1, this.c);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.setFrameSize(paramInt1, this.d);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setVisibility(0);
          c();
          return;
          paramInt4 = bmhv.f(pkh.a());
          if (this.o > paramInt4 * 1000)
          {
            this.l = (paramInt4 * 100);
            paramInt4 = (int)Math.ceil(this.o * 1.0F / this.l);
            f1 = this.o * 1.0F / this.l;
            break;
          }
          this.l = ((int)Math.ceil(this.o * 1.0F / 10.0F));
          f1 = 10;
          paramInt4 = 10;
          break;
          this.l = ((int)Math.ceil(this.o * 1.0F / 10.0F));
          f1 = 10;
          this.g = 0;
          paramInt4 = 10;
          break;
          if ("tribe".equals(((Activity)getContext()).getIntent().getStringExtra("video_refer"))) {}
          for (this.l = (bmuy.jdField_a_of_type_Int / 10);; this.l = (this.k / 10))
          {
            paramInt4 = (int)Math.ceil(this.o * 1.0F / this.l);
            f1 = this.o * 1.0F / this.l;
            if (paramInt4 <= 10) {
              this.l = ((int)Math.ceil(this.o * 1.0F / paramInt4));
            }
            break;
          }
        }
      }
    }
  }
  
  public void a(xlu paramxlu)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.a();
  }
  
  public int[] a()
  {
    View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0);
    if (localView == null) {
      return null;
    }
    int i1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int i2 = localView.getLeft() - this.h;
    float f1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.a();
    float f2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.b();
    float f3 = this.l;
    float f4 = -i2 / localView.getWidth();
    float f5 = i1;
    int i3 = (int)((f1 - this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.c()) / this.d * f3 + (f4 * f3 + f5 * f3));
    int i4 = (int)(-i2 / localView.getWidth() * f3 + i1 * f3 + (f2 - this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.c()) / this.d * f3);
    i1 = i4;
    i2 = i3;
    if (i4 - i3 < this.c)
    {
      if (i3 < this.c) {
        break label208;
      }
      i2 = i4 - this.c;
      i1 = i4;
    }
    for (;;)
    {
      return new int[] { i2, i1 };
      label208:
      i1 = this.c + i3;
      i2 = i3;
    }
  }
  
  public int b()
  {
    return this.n;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.setRange(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.b(), this.n - this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.b();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.a();
  }
  
  public void c()
  {
    int[] arrayOfInt = a();
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      return;
    }
    this.m = arrayOfInt[0];
    this.n = arrayOfInt[1];
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.isPlaying()) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.c();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setPlayRange(this.m, this.n);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a(true);
    if (this.jdField_a_of_type_Zcd != null) {
      this.jdField_a_of_type_Zcd.a(this.m, this.n);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.setRange(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.b(), this.n - this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.b();
  }
  
  public int d()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.b();
  }
  
  public void d()
  {
    int[] arrayOfInt = a();
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {}
    while (this.jdField_a_of_type_Zcd == null) {
      return;
    }
    this.jdField_a_of_type_Zcd.b(arrayOfInt[0], arrayOfInt[1]);
  }
  
  public int e()
  {
    View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int i1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int i2 = -(localView.getLeft() - this.h);
    return i1 * localView.getWidth() + i2;
  }
  
  @TargetApi(10)
  public void e()
  {
    if (this.jdField_a_of_type_Zbw != null) {
      this.jdField_a_of_type_Zbw.a();
    }
    if (this.jdField_a_of_type_Zby != null) {
      this.jdField_a_of_type_Zby.a();
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
  
  public void setOnRangeValueChangeListener(zcd paramzcd)
  {
    this.jdField_a_of_type_Zcd = paramzcd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */
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
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.OnPlayRecycleListener;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnSeekCompleteListener;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.tribe.TribeFlowComponentInterface;
import com.tencent.widget.HorizontalListView;
import cooperation.readinjoy.ReadInJoyHelper;
import omi;

public class ScrollFrameSelectBar
  extends FrameLayout
  implements TrimTextureVideoView.OnPlayRecycleListener, IMediaPlayer.OnSeekCompleteListener, RangeSelectBar.RangeChangeListener
{
  public static int a;
  public static int b = 15;
  private TrimTextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView;
  private FrameAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameAdapter;
  private FrameLoader jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader;
  private ProgressPointer jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer;
  private RangeSelectBar jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar;
  private ScrollFrameSelectBar.OnRangeValueChangeListener jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$OnRangeValueChangeListener;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g = 1000;
  private int h;
  private int i = this.g * 10;
  private int j;
  
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
    this.d = UIUtils.a(getContext());
    this.e = UIUtils.a(getContext(), jdField_a_of_type_Int);
    this.f = UIUtils.a(getContext(), b);
    LayoutInflater.from(getContext()).inflate(2130971516, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131375003));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar = ((RangeSelectBar)findViewById(2131375005));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer = ((ProgressPointer)findViewById(2131375004));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setRangeChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(new omi(this));
    if ("tribe".equals(((Activity)getContext()).getIntent().getStringExtra("video_refer"))) {
      this.g = (TribeFlowComponentInterface.jdField_a_of_type_Int / 10);
    }
  }
  
  public int a()
  {
    return this.h;
  }
  
  public void a()
  {
    d();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b();
  }
  
  public void a(IMediaPlayer paramIMediaPlayer)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.a();
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameAdapter.a(paramLocalMediaInfo);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    int k = getResources().getDisplayMetrics().widthPixels;
    int m = getResources().getDisplayMetrics().heightPixels;
    this.j = paramInt1;
    float f1;
    switch (paramInt4)
    {
    default: 
      if (!paramBoolean2) {
        break label467;
      }
      if (this.j > 60000)
      {
        this.g = 6000;
        paramInt4 = (int)Math.ceil(this.j * 1.0F / this.g);
        f1 = this.j * 1.0F / this.g;
      }
      break;
    }
    for (;;)
    {
      this.c = ((k - this.e * 2 - this.f) / 10);
      paramInt2 = (int)(paramInt3 / paramInt2 * this.c);
      paramInt3 = (int)(this.c * TakeVideoUtils.a(getResources()));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameAdapter = new FrameAdapter(getContext(), paramInt4, this.c, paramInt3);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader = new FrameLoader("frame_loader", this.c, paramInt2, paramBoolean1);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader.a(paramString, paramInt1, this.g);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setPadding(this.e, 0, k - this.c * 10 - this.e, 0);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameAdapter);
      float f2 = f1;
      if (f1 > 10.0F) {
        f2 = 10.0F;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setFrameSize(paramInt3, this.c, this.g, f2);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.setFrameSize(paramInt3, this.c);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setVisibility(0);
      b();
      return;
      paramInt4 = ReadInJoyHelper.g(ReadInJoyUtils.a());
      if (this.j > paramInt4 * 1000)
      {
        this.g = (paramInt4 * 100);
        paramInt4 = (int)Math.ceil(this.j * 1.0F / this.g);
        f1 = this.j * 1.0F / this.g;
        this.f = 0;
      }
      else
      {
        this.g = ((int)Math.ceil(this.j * 1.0F / 10.0F));
        paramInt4 = 10;
        f1 = 10;
        this.f = 0;
        continue;
        this.g = ((int)Math.ceil(this.j * 1.0F / 10.0F));
        paramInt4 = 10;
        f1 = 10;
        this.f = 0;
      }
    }
    label467:
    if ("tribe".equals(((Activity)getContext()).getIntent().getStringExtra("video_refer"))) {}
    for (this.g = (TribeFlowComponentInterface.jdField_a_of_type_Int / 10);; this.g = 1000)
    {
      paramInt4 = (int)Math.ceil(this.j * 1.0F / this.g);
      f1 = this.j * 1.0F / this.g;
      break;
    }
  }
  
  public int[] a()
  {
    View localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(0);
    if (localView == null) {
      return null;
    }
    int k = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int m = localView.getLeft() - this.e;
    float f1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.a();
    float f2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.b();
    float f3 = this.g;
    float f4 = -m / localView.getWidth();
    float f5 = k;
    int n = (int)((f1 - this.e) / this.c * f3 + (f4 * f3 + f5 * f3));
    int i1 = (int)(-m / localView.getWidth() * f3 + k * f3 + (f2 - this.e) / this.c * f3);
    k = i1;
    m = n;
    if (i1 - n < 1000)
    {
      if (n < 1000) {
        break label199;
      }
      m = i1 - 1000;
      k = i1;
    }
    for (;;)
    {
      return new int[] { m, k };
      label199:
      k = n + 1000;
      m = n;
    }
  }
  
  public int b()
  {
    return this.i;
  }
  
  public void b()
  {
    int[] arrayOfInt = a();
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      return;
    }
    this.h = arrayOfInt[0];
    this.i = arrayOfInt[1];
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.isPlaying()) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.b();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.setPlayRange(this.h, this.i);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a(true);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$OnRangeValueChangeListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$OnRangeValueChangeListener.a(this.h, this.i);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.setRange(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.b(), this.i - this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.b();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.setRange(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.b(), this.i - this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView.a());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.b();
  }
  
  public void d()
  {
    int[] arrayOfInt = a();
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {}
    while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$OnRangeValueChangeListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$OnRangeValueChangeListener.b(arrayOfInt[0], arrayOfInt[1]);
  }
  
  @TargetApi(10)
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameAdapter.a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarFrameLoader.a();
  }
  
  public void setLocalVideoView(TrimTextureVideoView paramTrimTextureVideoView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTrimTextureVideoView = paramTrimTextureVideoView;
    paramTrimTextureVideoView.setOnRecyclePlayListener(this);
    paramTrimTextureVideoView.setOnSeekCompleteListener(this);
  }
  
  public void setOnRangeValueChangeListener(ScrollFrameSelectBar.OnRangeValueChangeListener paramOnRangeValueChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$OnRangeValueChangeListener = paramOnRangeValueChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */
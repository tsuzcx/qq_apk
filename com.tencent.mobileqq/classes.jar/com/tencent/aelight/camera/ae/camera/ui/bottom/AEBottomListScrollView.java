package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.biz.videostory.capture.widgets.VideoStoryScrollItemTransformer;

public class AEBottomListScrollView
  extends RecyclerView
{
  private static final String a = "AEBottomListScrollView";
  private AEBottomListScrollLayoutManager b;
  private AEBottomListScrollView.ScrollStateChangeListener c;
  private AEBottomListScrollView.OnItemChangedListener d;
  private AEBottomListScrollView.AEEditMaterialSelectedListener e;
  private boolean f;
  
  public AEBottomListScrollView(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public AEBottomListScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public AEBottomListScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    AEBottomListScrollView.ScrollStateChangeListener localScrollStateChangeListener = this.c;
    if (localScrollStateChangeListener != null) {
      localScrollStateChangeListener.a(paramFloat, paramInt1, paramInt2, paramViewHolder1, paramViewHolder2);
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    AEBottomListScrollView.ScrollStateChangeListener localScrollStateChangeListener = this.c;
    if (localScrollStateChangeListener != null) {
      localScrollStateChangeListener.c(paramViewHolder, paramInt);
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    boolean bool;
    if (getOverScrollMode() != 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    this.b = new AEBottomListScrollLayoutManager(getContext(), new AEBottomListScrollView.ScrollStateListener(this, null), new DSVOrientation.Horizontal());
    setLayoutManager(this.b);
  }
  
  private void b()
  {
    if (this.d == null) {
      return;
    }
    int i = this.b.e();
    c(a(i), i);
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((AEBottomListScrollView.OnItemChangedListener)localObject).a(paramViewHolder, true);
    }
    localObject = this.c;
    if (localObject != null) {
      ((AEBottomListScrollView.ScrollStateChangeListener)localObject).b(paramViewHolder, paramInt);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    AEBottomListScrollView.OnItemChangedListener localOnItemChangedListener = this.d;
    if (localOnItemChangedListener != null) {
      localOnItemChangedListener.a(paramViewHolder, paramInt);
    }
  }
  
  @Nullable
  public RecyclerView.ViewHolder a(int paramInt)
  {
    View localView = this.b.findViewByPosition(paramInt);
    if (localView != null) {
      return getChildViewHolder(localView);
    }
    return null;
  }
  
  public void a(int paramInt, AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEBottomListAdapter.ViewHolder localViewHolder = (AEBottomListAdapter.ViewHolder)a(this.b.e());
    if (localViewHolder != null) {
      localViewHolder.a(4);
    }
    localViewHolder = (AEBottomListAdapter.ViewHolder)a(paramInt);
    if (localViewHolder != null)
    {
      localViewHolder.b(paramAEMaterialMetaData);
      localViewHolder.a(3);
      if ((paramAEMaterialMetaData != null) && (paramAEMaterialMetaData.A)) {
        localViewHolder.a(2);
      }
      if (this.e != null) {
        if ((localViewHolder.a != null) && (!"0".equals(localViewHolder.a.m)) && (localViewHolder.a.u)) {
          this.e.a(true);
        } else {
          this.e.a(false);
        }
      }
      scrollToPosition(paramInt);
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = super.fling(paramInt1, paramInt2);
    if (bool)
    {
      this.b.a(paramInt1, paramInt2);
      return bool;
    }
    this.b.c();
    return bool;
  }
  
  public int getCurrentItem()
  {
    return this.b.e();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.b.a(null);
  }
  
  public void setAEEditMaterialSelectedListener(@NonNull AEBottomListScrollView.AEEditMaterialSelectedListener paramAEEditMaterialSelectedListener)
  {
    this.e = paramAEEditMaterialSelectedListener;
  }
  
  public void setClampTransformProgressAfter(@IntRange(from=1L) int paramInt)
  {
    if (paramInt > 1)
    {
      this.b.c(paramInt);
      return;
    }
    throw new IllegalArgumentException("must be >= 1");
  }
  
  public void setItemTransformer(VideoStoryScrollItemTransformer paramVideoStoryScrollItemTransformer)
  {
    this.b.a(paramVideoStoryScrollItemTransformer);
  }
  
  public void setItemTransitionTimeMillis(@IntRange(from=10L) int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setLayoutCallback(AEBottomListScrollView.LayoutCallback paramLayoutCallback)
  {
    AEBottomListScrollLayoutManager localAEBottomListScrollLayoutManager = this.b;
    if (localAEBottomListScrollLayoutManager != null) {
      localAEBottomListScrollLayoutManager.a(paramLayoutCallback);
    }
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof AEBottomListScrollLayoutManager))
    {
      super.setLayoutManager(paramLayoutManager);
      return;
    }
    throw new IllegalArgumentException("please use special on ");
  }
  
  public void setOffscreenItems(int paramInt)
  {
    this.b.b(paramInt);
  }
  
  public void setOnItemChangedListener(@NonNull AEBottomListScrollView.OnItemChangedListener<?> paramOnItemChangedListener)
  {
    this.d = paramOnItemChangedListener;
  }
  
  public void setOrientation(DSVOrientation paramDSVOrientation)
  {
    this.b.a(paramDSVOrientation);
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.f = paramBoolean;
    setOverScrollMode(2);
  }
  
  public void setScrollStateChangeListener(@NonNull AEBottomListScrollView.ScrollStateChangeListener<?> paramScrollStateChangeListener)
  {
    this.c = paramScrollStateChangeListener;
  }
  
  public void setSlideOnFling(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public void setSlideOnFlingThreshold(int paramInt)
  {
    this.b.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView
 * JD-Core Version:    0.7.0.1
 */
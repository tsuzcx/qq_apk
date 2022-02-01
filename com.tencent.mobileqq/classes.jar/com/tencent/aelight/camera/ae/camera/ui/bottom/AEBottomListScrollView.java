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
  private static final String jdField_a_of_type_JavaLangString = "AEBottomListScrollView";
  private AEBottomListScrollLayoutManager jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager;
  private AEBottomListScrollView.AEEditMaterialSelectedListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$AEEditMaterialSelectedListener;
  private AEBottomListScrollView.OnItemChangedListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$OnItemChangedListener;
  private AEBottomListScrollView.ScrollStateChangeListener jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$ScrollStateChangeListener;
  private boolean jdField_a_of_type_Boolean;
  
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
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$OnItemChangedListener == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.b();
    c(a(i), i);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    AEBottomListScrollView.ScrollStateChangeListener localScrollStateChangeListener = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$ScrollStateChangeListener;
    if (localScrollStateChangeListener != null) {
      localScrollStateChangeListener.a(paramFloat, paramInt1, paramInt2, paramViewHolder1, paramViewHolder2);
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    AEBottomListScrollView.ScrollStateChangeListener localScrollStateChangeListener = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$ScrollStateChangeListener;
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
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager = new AEBottomListScrollLayoutManager(getContext(), new AEBottomListScrollView.ScrollStateListener(this, null), new DSVOrientation.Horizontal());
    setLayoutManager(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager);
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$OnItemChangedListener;
    if (localObject != null) {
      ((AEBottomListScrollView.OnItemChangedListener)localObject).a(paramViewHolder, true);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$ScrollStateChangeListener;
    if (localObject != null) {
      ((AEBottomListScrollView.ScrollStateChangeListener)localObject).b(paramViewHolder, paramInt);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    AEBottomListScrollView.OnItemChangedListener localOnItemChangedListener = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$OnItemChangedListener;
    if (localOnItemChangedListener != null) {
      localOnItemChangedListener.a(paramViewHolder, paramInt);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.b();
  }
  
  @Nullable
  public RecyclerView.ViewHolder a(int paramInt)
  {
    View localView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.findViewByPosition(paramInt);
    if (localView != null) {
      return getChildViewHolder(localView);
    }
    return null;
  }
  
  public void a(int paramInt, AEMaterialMetaData paramAEMaterialMetaData)
  {
    AEBottomListAdapter.ViewHolder localViewHolder = (AEBottomListAdapter.ViewHolder)a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.b());
    if (localViewHolder != null) {
      localViewHolder.a(4);
    }
    localViewHolder = (AEBottomListAdapter.ViewHolder)a(paramInt);
    if (localViewHolder != null)
    {
      localViewHolder.b(paramAEMaterialMetaData);
      localViewHolder.a(3);
      if ((paramAEMaterialMetaData != null) && (paramAEMaterialMetaData.e)) {
        localViewHolder.a(2);
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$AEEditMaterialSelectedListener != null) {
        if ((localViewHolder.a != null) && (!"0".equals(localViewHolder.a.k)) && (localViewHolder.a.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$AEEditMaterialSelectedListener.a(true);
        } else {
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$AEEditMaterialSelectedListener.a(false);
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
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.a(paramInt1, paramInt2);
      return bool;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.c();
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.a(null);
  }
  
  public void setAEEditMaterialSelectedListener(@NonNull AEBottomListScrollView.AEEditMaterialSelectedListener paramAEEditMaterialSelectedListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$AEEditMaterialSelectedListener = paramAEEditMaterialSelectedListener;
  }
  
  public void setClampTransformProgressAfter(@IntRange(from=1L) int paramInt)
  {
    if (paramInt > 1)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.c(paramInt);
      return;
    }
    throw new IllegalArgumentException("must be >= 1");
  }
  
  public void setItemTransformer(VideoStoryScrollItemTransformer paramVideoStoryScrollItemTransformer)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.a(paramVideoStoryScrollItemTransformer);
  }
  
  public void setItemTransitionTimeMillis(@IntRange(from=10L) int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.a(paramInt);
  }
  
  public void setLayoutCallback(AEBottomListScrollView.LayoutCallback paramLayoutCallback)
  {
    AEBottomListScrollLayoutManager localAEBottomListScrollLayoutManager = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager;
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
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.b(paramInt);
  }
  
  public void setOnItemChangedListener(@NonNull AEBottomListScrollView.OnItemChangedListener<?> paramOnItemChangedListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$OnItemChangedListener = paramOnItemChangedListener;
  }
  
  public void setOrientation(DSVOrientation paramDSVOrientation)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.a(paramDSVOrientation);
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    setOverScrollMode(2);
  }
  
  public void setScrollStateChangeListener(@NonNull AEBottomListScrollView.ScrollStateChangeListener<?> paramScrollStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollView$ScrollStateChangeListener = paramScrollStateChangeListener;
  }
  
  public void setSlideOnFling(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.a(paramBoolean);
  }
  
  public void setSlideOnFlingThreshold(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListScrollLayoutManager.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView
 * JD-Core Version:    0.7.0.1
 */
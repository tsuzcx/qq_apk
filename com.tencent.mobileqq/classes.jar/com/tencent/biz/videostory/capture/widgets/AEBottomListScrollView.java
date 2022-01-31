package com.tencent.biz.videostory.capture.widgets;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.View;
import bgya;
import wqp;
import wvn;
import wvs;
import wvt;
import wvu;
import wvv;
import wwa;
import wwc;
import wws;

public class AEBottomListScrollView
  extends RecyclerView
{
  private static final String jdField_a_of_type_JavaLangString = AEBottomListScrollView.class.getSimpleName();
  private wvn jdField_a_of_type_Wvn;
  private wvt jdField_a_of_type_Wvt;
  private wvu jdField_a_of_type_Wvu;
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
    if (this.jdField_a_of_type_Wvt == null) {
      return;
    }
    int i = this.jdField_a_of_type_Wvn.b();
    c(a(i), i);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (this.jdField_a_of_type_Wvu != null) {
      this.jdField_a_of_type_Wvu.a(paramFloat, paramInt1, paramInt2, paramViewHolder1, paramViewHolder2);
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Wvu != null) {
      this.jdField_a_of_type_Wvu.c(paramViewHolder, paramInt);
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (getOverScrollMode() != 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Wvn = new wvn(getContext(), new wvv(this, null), new wwc());
      setLayoutManager(this.jdField_a_of_type_Wvn);
      return;
    }
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Wvt != null) {
      this.jdField_a_of_type_Wvt.a(paramViewHolder, true);
    }
    if (this.jdField_a_of_type_Wvu != null) {
      this.jdField_a_of_type_Wvu.b(paramViewHolder, paramInt);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Wvt != null) {
      this.jdField_a_of_type_Wvt.a(paramViewHolder, paramInt);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Wvn.b();
  }
  
  @Nullable
  public RecyclerView.ViewHolder a(int paramInt)
  {
    View localView = this.jdField_a_of_type_Wvn.findViewByPosition(paramInt);
    if (localView != null) {
      return getChildViewHolder(localView);
    }
    return null;
  }
  
  public void a(int paramInt, bgya parambgya)
  {
    wqp localwqp = (wqp)a(this.jdField_a_of_type_Wvn.b());
    if (localwqp != null) {
      localwqp.a(4);
    }
    localwqp = (wqp)a(paramInt);
    if (localwqp != null)
    {
      localwqp.b(parambgya);
      localwqp.a(3);
      if ((parambgya != null) && (parambgya.d)) {
        localwqp.a(2);
      }
      scrollToPosition(paramInt);
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = super.fling(paramInt1, paramInt2);
    if (bool)
    {
      this.jdField_a_of_type_Wvn.a(paramInt1, paramInt2);
      return bool;
    }
    this.jdField_a_of_type_Wvn.c();
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Wvn.a(null);
  }
  
  public void setClampTransformProgressAfter(@IntRange(from=1L) int paramInt)
  {
    if (paramInt <= 1) {
      throw new IllegalArgumentException("must be >= 1");
    }
    this.jdField_a_of_type_Wvn.c(paramInt);
  }
  
  public void setItemTransformer(wws paramwws)
  {
    this.jdField_a_of_type_Wvn.a(paramwws);
  }
  
  public void setItemTransitionTimeMillis(@IntRange(from=10L) int paramInt)
  {
    this.jdField_a_of_type_Wvn.a(paramInt);
  }
  
  public void setLayoutCallback(wvs paramwvs)
  {
    if (this.jdField_a_of_type_Wvn != null) {
      this.jdField_a_of_type_Wvn.a(paramwvs);
    }
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof wvn))
    {
      super.setLayoutManager(paramLayoutManager);
      return;
    }
    throw new IllegalArgumentException("please use special on ");
  }
  
  public void setOffscreenItems(int paramInt)
  {
    this.jdField_a_of_type_Wvn.b(paramInt);
  }
  
  public void setOnItemChangedListener(@NonNull wvt<?> paramwvt)
  {
    this.jdField_a_of_type_Wvt = paramwvt;
  }
  
  public void setOrientation(wwa paramwwa)
  {
    this.jdField_a_of_type_Wvn.a(paramwwa);
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    setOverScrollMode(2);
  }
  
  public void setScrollStateChangeListener(@NonNull wvu<?> paramwvu)
  {
    this.jdField_a_of_type_Wvu = paramwvu;
  }
  
  public void setSlideOnFling(boolean paramBoolean)
  {
    this.jdField_a_of_type_Wvn.a(paramBoolean);
  }
  
  public void setSlideOnFlingThreshold(int paramInt)
  {
    this.jdField_a_of_type_Wvn.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.AEBottomListScrollView
 * JD-Core Version:    0.7.0.1
 */
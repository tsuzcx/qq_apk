package com.tencent.biz.expand.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/ExpandFragmentViewPager;", "Landroid/support/v4/view/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "innerPageChangeListener", "Lcom/tencent/biz/expand/ui/ExpandFragmentViewPager$PageChangeListener;", "pageChangeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "addPageChangeListener", "", "listener", "removePageChangeListener", "PageChangeListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFragmentViewPager
  extends ViewPager
{
  private final ExpandFragmentViewPager.PageChangeListener jdField_a_of_type_ComTencentBizExpandUiExpandFragmentViewPager$PageChangeListener = new ExpandFragmentViewPager.PageChangeListener(this);
  private final CopyOnWriteArrayList<ViewPager.OnPageChangeListener> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public ExpandFragmentViewPager(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandFragmentViewPager(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnPageChangeListener((ViewPager.OnPageChangeListener)this.jdField_a_of_type_ComTencentBizExpandUiExpandFragmentViewPager$PageChangeListener);
  }
  
  public final void a(@NotNull ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnPageChangeListener, "listener");
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addIfAbsent(paramOnPageChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandFragmentViewPager
 * JD-Core Version:    0.7.0.1
 */
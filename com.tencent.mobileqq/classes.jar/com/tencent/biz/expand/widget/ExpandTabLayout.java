package com.tencent.biz.expand.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.expand.utils.DisplayUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/widget/ExpandTabLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentPosition", "", "getCurrentPosition", "()I", "setCurrentPosition", "(I)V", "onTabClickListener", "Lcom/tencent/biz/expand/widget/ExpandTabLayout$OnTabClickListener;", "getOnTabClickListener", "()Lcom/tencent/biz/expand/widget/ExpandTabLayout$OnTabClickListener;", "setOnTabClickListener", "(Lcom/tencent/biz/expand/widget/ExpandTabLayout$OnTabClickListener;)V", "tabCount", "getTabCount", "tabs", "Ljava/util/ArrayList;", "Lcom/tencent/biz/expand/widget/ExpandTabLayout$Tab;", "Lkotlin/collections/ArrayList;", "getTabs", "()Ljava/util/ArrayList;", "getTabAt", "position", "initData", "", "titles", "", "", "newPosition", "select", "pos", "setTabClickListener", "listener", "Companion", "ITabView", "OnTabClickListener", "Tab", "TabView", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandTabLayout
  extends LinearLayout
{
  public static final ExpandTabLayout.Companion a;
  private int jdField_a_of_type_Int = -1;
  @Nullable
  private ExpandTabLayout.OnTabClickListener jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout$OnTabClickListener;
  @NotNull
  private final ArrayList<ExpandTabLayout.Tab> jdField_a_of_type_JavaUtilArrayList = new ArrayList(3);
  
  static
  {
    jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout$Companion = new ExpandTabLayout.Companion(null);
  }
  
  public ExpandTabLayout(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandTabLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  @Nullable
  public final ExpandTabLayout.OnTabClickListener a()
  {
    return this.jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout$OnTabClickListener;
  }
  
  @NotNull
  public final ExpandTabLayout.Tab a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "tabs[position]");
    return (ExpandTabLayout.Tab)localObject;
  }
  
  @NotNull
  public final ArrayList<ExpandTabLayout.Tab> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public final void a(int paramInt)
  {
    ExpandTabLayout.Tab localTab = (ExpandTabLayout.Tab)CollectionsKt.getOrNull((List)this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
    if (localTab != null) {
      localTab.b();
    }
    localTab = (ExpandTabLayout.Tab)CollectionsKt.getOrNull((List)this.jdField_a_of_type_JavaUtilArrayList, paramInt);
    if (localTab != null) {
      localTab.a();
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@NotNull Collection<String> paramCollection, int paramInt)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramCollection, "titles");
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    Object localObject2 = (Iterable)paramCollection;
    paramCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    int i = 0;
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      Object localObject4 = (String)localObject3;
      localObject3 = new ExpandTabLayout.Tab();
      ((ExpandTabLayout.Tab)localObject3).a(i);
      ((ExpandTabLayout.Tab)localObject3).a((String)localObject4);
      localObject4 = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "context");
      localObject4 = new ExpandTabLayout.TabView((Context)localObject4);
      ((ExpandTabLayout.TabView)localObject4).a().setText((CharSequence)((ExpandTabLayout.Tab)localObject3).a());
      ((ExpandTabLayout.TabView)localObject4).a().setImageResource(2130838800);
      ImageView localImageView = ((ExpandTabLayout.TabView)localObject4).a();
      Object localObject5 = DisplayUtils.a;
      localObject5 = ((ExpandTabLayout.TabView)localObject4).getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject5, "context");
      int k = DisplayUtil.a((Context)localObject5, 20.0F);
      localObject5 = DisplayUtils.a;
      localObject5 = ((ExpandTabLayout.TabView)localObject4).getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject5, "context");
      localObject5 = new LinearLayout.LayoutParams(k, DisplayUtil.a((Context)localObject5, 20.0F));
      ((LinearLayout.LayoutParams)localObject5).gravity = 17;
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject5);
      ((ExpandTabLayout.Tab)localObject3).a((View)localObject4);
      paramCollection.add(localObject3);
      i += 1;
    }
    ((ArrayList)localObject1).addAll((Collection)paramCollection);
    removeAllViews();
    paramCollection = new LinearLayout.LayoutParams(-2, -2);
    paramCollection.weight = 1.0F;
    localObject1 = ((Iterable)this.jdField_a_of_type_JavaUtilArrayList).iterator();
    i = j;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject2 = (ExpandTabLayout.Tab)localObject2;
      localObject3 = ((ExpandTabLayout.Tab)localObject2).a();
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      ((View)localObject3).setOnClickListener((View.OnClickListener)new ExpandTabLayout.initData..inlined.forEachIndexed.lambda.1(i, this, paramCollection));
      addView(((ExpandTabLayout.Tab)localObject2).a(), (ViewGroup.LayoutParams)paramCollection);
      i += 1;
    }
    a(paramInt);
  }
  
  public final void setCurrentPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void setOnTabClickListener(@Nullable ExpandTabLayout.OnTabClickListener paramOnTabClickListener)
  {
    this.jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout$OnTabClickListener = paramOnTabClickListener;
  }
  
  public final void setTabClickListener(@Nullable ExpandTabLayout.OnTabClickListener paramOnTabClickListener)
  {
    this.jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout$OnTabClickListener = paramOnTabClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.widget.ExpandTabLayout
 * JD-Core Version:    0.7.0.1
 */
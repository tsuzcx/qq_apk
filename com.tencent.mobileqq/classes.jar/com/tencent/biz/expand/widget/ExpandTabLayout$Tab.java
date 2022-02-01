package com.tencent.biz.expand.widget;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/widget/ExpandTabLayout$Tab;", "", "()V", "customView", "Landroid/view/View;", "getCustomView", "()Landroid/view/View;", "setCustomView", "(Landroid/view/View;)V", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "innerView", "getInnerView$AQQLiteApp_release", "setInnerView$AQQLiteApp_release", "position", "", "getPosition", "()I", "setPosition", "(I)V", "tag", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "select", "", "unselect", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandTabLayout$Tab
{
  public static final ExpandTabLayout.Tab.Companion a;
  private int jdField_a_of_type_Int = -1;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  
  static
  {
    jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout$Tab$Companion = new ExpandTabLayout.Tab.Companion(null);
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    Object localObject = localView;
    if (!(localView instanceof ExpandTabLayout.TabView)) {
      localObject = null;
    }
    localObject = (ExpandTabLayout.TabView)localObject;
    if (localObject != null)
    {
      ((ExpandTabLayout.TabView)localObject).a().setTypeface(null, 1);
      ((ExpandTabLayout.TabView)localObject).a().setBackgroundColor(-16777216);
    }
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@Nullable View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    Object localObject = localView;
    if (!(localView instanceof ExpandTabLayout.TabView)) {
      localObject = null;
    }
    localObject = (ExpandTabLayout.TabView)localObject;
    if (localObject != null)
    {
      ((ExpandTabLayout.TabView)localObject).a().setTypeface(null, 0);
      ((ExpandTabLayout.TabView)localObject).a().setBackgroundColor(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.widget.ExpandTabLayout.Tab
 * JD-Core Version:    0.7.0.1
 */
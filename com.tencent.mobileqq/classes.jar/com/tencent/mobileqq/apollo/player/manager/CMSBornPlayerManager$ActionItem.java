package com.tencent.mobileqq.apollo.player.manager;

import android.widget.FrameLayout;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$ActionItem;", "", "width", "", "height", "recordKey", "", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "container", "Landroid/widget/FrameLayout;", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "(IILjava/lang/String;Lcom/tencent/mobileqq/apollo/player/action/CMSAction;Landroid/widget/FrameLayout;Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;)V", "getAction", "()Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "getContainer", "()Landroid/widget/FrameLayout;", "getHeight", "()I", "getListener", "()Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "getRecordKey", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
final class CMSBornPlayerManager$ActionItem
{
  private final int jdField_a_of_type_Int;
  @Nullable
  private final FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  @Nullable
  private final ICMSPlayerListener jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
  @NotNull
  private final CMSAction jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final int b;
  
  public CMSBornPlayerManager$ActionItem(int paramInt1, int paramInt2, @NotNull String paramString, @NotNull CMSAction paramCMSAction, @Nullable FrameLayout paramFrameLayout, @Nullable ICMSPlayerListener paramICMSPlayerListener)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction = paramCMSAction;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener = paramICMSPlayerListener;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final ICMSPlayerListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
  }
  
  @NotNull
  public final CMSAction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ActionItem))
      {
        paramObject = (ActionItem)paramObject;
        if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.b == paramObject.b) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, paramObject.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction)) && (Intrinsics.areEqual(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramObject.jdField_a_of_type_AndroidWidgetFrameLayout)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener, paramObject.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int n = this.jdField_a_of_type_Int;
    int i1 = this.b;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((((n * 31 + i1) * 31 + i) * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ActionItem(width=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", recordKey=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", action=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction);
    localStringBuilder.append(", container=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    localStringBuilder.append(", listener=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.ActionItem
 * JD-Core Version:    0.7.0.1
 */
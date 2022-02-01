package com.tencent.mobileqq.apollo.player.manager;

import android.widget.FrameLayout;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$ActionItem;", "", "width", "", "height", "recordKey", "", "action", "Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "container", "Landroid/widget/FrameLayout;", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "(IILjava/lang/String;Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;Landroid/widget/FrameLayout;Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;)V", "getAction", "()Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "getContainer", "()Landroid/widget/FrameLayout;", "getHeight", "()I", "getListener", "()Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "getRecordKey", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class CMSBornPlayerManager$ActionItem
{
  private final int jdField_a_of_type_Int;
  @Nullable
  private final FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  @NotNull
  private final CMSAction jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction;
  @Nullable
  private final ICMSPlayerListener jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final int b;
  
  public CMSBornPlayerManager$ActionItem(int paramInt1, int paramInt2, @NotNull String paramString, @NotNull CMSAction paramCMSAction, @Nullable FrameLayout paramFrameLayout, @Nullable ICMSPlayerListener paramICMSPlayerListener)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction = paramCMSAction;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener = paramICMSPlayerListener;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  @NotNull
  public final CMSAction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction;
  }
  
  @Nullable
  public final ICMSPlayerListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ActionItem))
      {
        paramObject = (ActionItem)paramObject;
        if ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.b != paramObject.b) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction, paramObject.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction)) || (!Intrinsics.areEqual(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramObject.jdField_a_of_type_AndroidWidgetFrameLayout)) || (!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener, paramObject.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = this.jdField_a_of_type_Int;
    int i1 = this.b;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction;
      if (localObject == null) {
        break label119;
      }
      j = localObject.hashCode();
      label49:
      localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (localObject == null) {
        break label124;
      }
    }
    label119:
    label124:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      return (k + (j + (i + (n * 31 + i1) * 31) * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label49;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "ActionItem(width=" + this.jdField_a_of_type_Int + ", height=" + this.b + ", recordKey=" + this.jdField_a_of_type_JavaLangString + ", action=" + this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerActionCMSAction + ", container=" + this.jdField_a_of_type_AndroidWidgetFrameLayout + ", listener=" + this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.ActionItem
 * JD-Core Version:    0.7.0.1
 */
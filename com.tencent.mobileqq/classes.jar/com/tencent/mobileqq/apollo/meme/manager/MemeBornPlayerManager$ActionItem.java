package com.tencent.mobileqq.apollo.meme.manager;

import android.widget.FrameLayout;
import com.tencent.mobileqq.apollo.meme.IMemePlayerListener;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/manager/MemeBornPlayerManager$ActionItem;", "", "width", "", "height", "recordKey", "", "action", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "container", "Landroid/widget/FrameLayout;", "listener", "Lcom/tencent/mobileqq/apollo/meme/IMemePlayerListener;", "(IILjava/lang/String;Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;Landroid/widget/FrameLayout;Lcom/tencent/mobileqq/apollo/meme/IMemePlayerListener;)V", "getAction", "()Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "getContainer", "()Landroid/widget/FrameLayout;", "getHeight", "()I", "getListener", "()Lcom/tencent/mobileqq/apollo/meme/IMemePlayerListener;", "getRecordKey", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
final class MemeBornPlayerManager$ActionItem
{
  private final int a;
  private final int b;
  @NotNull
  private final String c;
  @NotNull
  private final MemeAction d;
  @Nullable
  private final FrameLayout e;
  @Nullable
  private final IMemePlayerListener f;
  
  public MemeBornPlayerManager$ActionItem(int paramInt1, int paramInt2, @NotNull String paramString, @NotNull MemeAction paramMemeAction, @Nullable FrameLayout paramFrameLayout, @Nullable IMemePlayerListener paramIMemePlayerListener)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
    this.d = paramMemeAction;
    this.e = paramFrameLayout;
    this.f = paramIMemePlayerListener;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  @NotNull
  public final MemeAction c()
  {
    return this.d;
  }
  
  @Nullable
  public final IMemePlayerListener d()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ActionItem))
      {
        paramObject = (ActionItem)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e)) && (Intrinsics.areEqual(this.f, paramObject.f))) {}
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
    int n = this.a;
    int i1 = this.b;
    Object localObject = this.c;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.d;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.e;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.f;
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
    localStringBuilder.append(this.a);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", recordKey=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", action=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", container=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", listener=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayerManager.ActionItem
 * JD-Core Version:    0.7.0.1
 */
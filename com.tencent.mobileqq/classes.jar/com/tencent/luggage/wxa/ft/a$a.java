package com.tencent.luggage.wxa.ft;

import com.tencent.luggage.wxaapi.LaunchWxaAppResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/launch/WxaAppLaunchListenersStore$Request;", "", "wxaAppID", "", "versionType", "", "listener", "Lcom/tencent/luggage/wxaapi/LaunchWxaAppResultListener;", "(Ljava/lang/String;ILcom/tencent/luggage/wxaapi/LaunchWxaAppResultListener;)V", "getListener", "()Lcom/tencent/luggage/wxaapi/LaunchWxaAppResultListener;", "getVersionType", "()I", "getWxaAppID", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
final class a$a
{
  @Nullable
  private final String a;
  private final int b;
  @Nullable
  private final LaunchWxaAppResultListener c;
  
  public a$a(@Nullable String paramString, int paramInt, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramLaunchWxaAppResultListener;
  }
  
  @Nullable
  public final LaunchWxaAppResultListener a()
  {
    return this.c;
  }
  
  @Nullable
  public final String b()
  {
    return this.a;
  }
  
  public final int c()
  {
    return this.b;
  }
  
  @Nullable
  public final LaunchWxaAppResultListener d()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
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
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    int k = this.b;
    localObject = this.c;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (i * 31 + k) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request(wxaAppID=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", versionType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", listener=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ft.a.a
 * JD-Core Version:    0.7.0.1
 */
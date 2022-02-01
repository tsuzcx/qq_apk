package com.tencent.luggage.wxa.cv;

import com.tencent.luggage.wxa.qu.b;
import com.tencent.luggage.wxa.qw.dw;
import com.tencent.luggage.wxa.qw.ee;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/model/HTMLWebViewJsApiPermissionController$JSVerifyRequestProxy;", "", "url", "", "signFlag", "", "appId", "signature", "signType", "timestamp", "nonce", "JSAPIName", "JSAPIArgsJsonBytes", "", "scope", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;)V", "getJSAPIArgsJsonBytes", "()[B", "getJSAPIName", "()Ljava/lang/String;", "getAppId", "getNonce", "getScope", "getSignFlag", "()I", "getSignType", "getSignature", "getTimestamp", "getUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toJSAPIAuthRequest", "Lcom/tencent/mm/protocal/protobuf/JSAPIAuthRequest;", "toJSAPIRealtimeVerifyRequest", "Lcom/tencent/mm/protocal/protobuf/JSAPIRealtimeVerifyRequest;", "toString", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class b$b
{
  public static final b.b.a a = new b.b.a(null);
  @Nullable
  private final String b;
  private final int c;
  @Nullable
  private final String d;
  @Nullable
  private final String e;
  @Nullable
  private final String f;
  @Nullable
  private final String g;
  @Nullable
  private final String h;
  @Nullable
  private final String i;
  @Nullable
  private final byte[] j;
  @Nullable
  private final String k;
  
  public b$b(@Nullable String paramString1, int paramInt, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7, @Nullable byte[] paramArrayOfByte, @Nullable String paramString8)
  {
    this.b = paramString1;
    this.c = paramInt;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramString5;
    this.h = paramString6;
    this.i = paramString7;
    this.j = paramArrayOfByte;
    this.k = paramString8;
  }
  
  @NotNull
  public final dw a()
  {
    dw localdw = new dw();
    localdw.a = this.b;
    localdw.b = this.d;
    localdw.c = this.i;
    localdw.d = this.g;
    localdw.e = this.h;
    localdw.f = this.e;
    localdw.g = this.f;
    localdw.h = b.a(this.j);
    localdw.i = this.c;
    localdw.j = this.k;
    return localdw;
  }
  
  @NotNull
  public final ee b()
  {
    ee localee = new ee();
    localee.a = this.b;
    localee.b = this.d;
    localee.c = this.i;
    localee.d = this.g;
    localee.e = this.h;
    localee.f = this.e;
    localee.g = this.f;
    localee.h = b.a(this.j);
    return localee;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((Intrinsics.areEqual(this.b, paramObject.b)) && (this.c == paramObject.c) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e)) && (Intrinsics.areEqual(this.f, paramObject.f)) && (Intrinsics.areEqual(this.g, paramObject.g)) && (Intrinsics.areEqual(this.h, paramObject.h)) && (Intrinsics.areEqual(this.i, paramObject.i)) && (Intrinsics.areEqual(this.j, paramObject.j)) && (Intrinsics.areEqual(this.k, paramObject.k))) {}
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
    Object localObject = this.b;
    int i7 = 0;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    int i8 = this.c;
    localObject = this.d;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.e;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.f;
    int i2;
    if (localObject != null) {
      i2 = localObject.hashCode();
    } else {
      i2 = 0;
    }
    localObject = this.g;
    int i3;
    if (localObject != null) {
      i3 = localObject.hashCode();
    } else {
      i3 = 0;
    }
    localObject = this.h;
    int i4;
    if (localObject != null) {
      i4 = localObject.hashCode();
    } else {
      i4 = 0;
    }
    localObject = this.i;
    int i5;
    if (localObject != null) {
      i5 = localObject.hashCode();
    } else {
      i5 = 0;
    }
    localObject = this.j;
    int i6;
    if (localObject != null) {
      i6 = Arrays.hashCode((byte[])localObject);
    } else {
      i6 = 0;
    }
    localObject = this.k;
    if (localObject != null) {
      i7 = localObject.hashCode();
    }
    return ((((((((m * 31 + i8) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JSVerifyRequestProxy(url=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", signFlag=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", appId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", signature=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", signType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", timestamp=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", nonce=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", JSAPIName=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", JSAPIArgsJsonBytes=");
    localStringBuilder.append(Arrays.toString(this.j));
    localStringBuilder.append(", scope=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.b.b
 * JD-Core Version:    0.7.0.1
 */
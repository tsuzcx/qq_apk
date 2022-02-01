package com.tencent.luggage.wxa.cv;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.luggage.wxa.qw.bs;
import com.tencent.luggage.wxa.qw.gx;
import com.tencent.luggage.wxa.qw.hf;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.r;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/model/WxaDefGetA8KeyReq;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyReq;", "()V", "equals", "", "o", "", "getNetTypeStr", "", "hashCode", "", "setCommonFields", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class j
  extends bs
{
  private final String e()
  {
    Object localObject = (ConnectivityManager)r.a().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        if (((NetworkInfo)localObject).getType() == 1) {
          return "WIFI";
        }
        if (((NetworkInfo)localObject).getExtraInfo() != null)
        {
          localObject = ((NetworkInfo)localObject).getExtraInfo();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "activeNetInfo.extraInfo");
          Locale localLocale = Locale.getDefault();
          Intrinsics.checkExpressionValueIsNotNull(localLocale, "Locale.getDefault()");
          if (localObject != null)
          {
            localObject = ((String)localObject).toLowerCase(localLocale);
            Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).toLowerCase(locale)");
            return localObject;
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
    }
    return "no";
  }
  
  public final void a()
  {
    this.q = e();
    this.t = ((int)af.d());
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((j)this == paramObject) {
      return true;
    }
    boolean bool2 = false;
    if (paramObject != null)
    {
      if ((Intrinsics.areEqual(getClass(), paramObject.getClass()) ^ true)) {
        return false;
      }
      bs localbs = (bs)paramObject;
      if (this.a != localbs.a) {
        return false;
      }
      if (this.h != localbs.h) {
        return false;
      }
      if (this.i != localbs.i) {
        return false;
      }
      if (this.m != localbs.m) {
        return false;
      }
      if (this.n != localbs.n) {
        return false;
      }
      if (this.o != localbs.o) {
        return false;
      }
      if (this.r != localbs.r) {
        return false;
      }
      if (this.s != localbs.s) {
        return false;
      }
      if (this.v != localbs.v) {
        return false;
      }
      if (this.y != localbs.y) {
        return false;
      }
      boolean bool1;
      if (this.c != null)
      {
        paramObject = this.c;
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "AppID");
        paramObject = paramObject.a();
        localObject1 = localbs.c;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "that.AppID");
        bool1 = Intrinsics.areEqual(paramObject, ((hf)localObject1).a()) ^ true;
      }
      else if (localbs.c != null)
      {
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      if (this.d != null)
      {
        paramObject = this.d;
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "Scope");
        paramObject = paramObject.a();
        localObject1 = localbs.d;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "that.Scope");
        bool1 = Intrinsics.areEqual(paramObject, ((hf)localObject1).a()) ^ true;
      }
      else if (localbs.d != null)
      {
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      if (this.e != null)
      {
        paramObject = this.e;
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "State");
        paramObject = paramObject.a();
        localObject1 = localbs.e;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "that.State");
        bool1 = Intrinsics.areEqual(paramObject, ((hf)localObject1).a()) ^ true;
      }
      else if (localbs.e != null)
      {
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      if (this.f != null)
      {
        paramObject = this.f;
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "ReqUrl");
        paramObject = paramObject.a();
        localObject1 = localbs.f;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "that.ReqUrl");
        bool1 = Intrinsics.areEqual(paramObject, ((hf)localObject1).a()) ^ true;
      }
      else if (localbs.f != null)
      {
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      if (this.g != null) {
        bool1 = Intrinsics.areEqual(this.g, localbs.g) ^ true;
      } else if (localbs.g != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      if (this.j != null) {
        bool1 = Intrinsics.areEqual(this.j, localbs.j) ^ true;
      } else if (localbs.j != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      if (this.k != null) {
        bool1 = Intrinsics.areEqual(this.k, localbs.k) ^ true;
      } else if (localbs.k != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      if (this.q != null) {
        bool1 = Intrinsics.areEqual(this.q, localbs.q) ^ true;
      } else if (localbs.q != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      if (this.u != null) {
        bool1 = Intrinsics.areEqual(this.u, localbs.u) ^ true;
      } else if (localbs.u != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      paramObject = this.w;
      if (paramObject != null)
      {
        paramObject = paramObject.a();
        if (paramObject != null) {}
      }
      else
      {
        paramObject = new byte[0];
      }
      paramObject = af.b(paramObject);
      Object localObject2 = null;
      if (paramObject == null) {
        paramObject = null;
      }
      Object localObject1 = localbs.w;
      if (localObject1 != null)
      {
        localObject1 = ((gx)localObject1).a();
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = new byte[0];
      }
      String str = af.b((byte[])localObject1);
      localObject1 = localObject2;
      if (str != null) {
        localObject1 = str;
      }
      if (paramObject != null) {
        bool1 = Intrinsics.areEqual(paramObject, localObject1) ^ true;
      } else if (localObject1 != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      if (this.x != null) {
        bool1 = Intrinsics.areEqual(this.x, localbs.x) ^ true;
      } else if (localbs.x != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      if (this.z != null) {
        bool1 = Intrinsics.areEqual(this.z, localbs.z) ^ true;
      } else if (localbs.z != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      if (this.A != null) {
        bool1 = Intrinsics.areEqual(this.A, localbs.A) ^ true;
      } else if (localbs.A != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1) {
        return false;
      }
      bool2 = true;
    }
    return bool2;
  }
  
  public int hashCode()
  {
    int i9 = this.a;
    Object localObject = this.c;
    int i8 = 0;
    int i;
    if (localObject != null)
    {
      localObject = this.c;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "AppID");
      i = ((hf)localObject).a().hashCode();
    }
    else
    {
      i = 0;
    }
    int j;
    if (this.d != null)
    {
      localObject = this.d;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Scope");
      j = ((hf)localObject).a().hashCode();
    }
    else
    {
      j = 0;
    }
    int k;
    if (this.e != null)
    {
      localObject = this.e;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "State");
      k = ((hf)localObject).a().hashCode();
    }
    else
    {
      k = 0;
    }
    int m;
    if (this.f != null)
    {
      localObject = this.f;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReqUrl");
      m = ((hf)localObject).a().hashCode();
    }
    else
    {
      m = 0;
    }
    int n;
    if (this.g != null) {
      n = this.g.hashCode();
    } else {
      n = 0;
    }
    int i10 = this.h;
    int i11 = this.i;
    int i1;
    if (this.j != null) {
      i1 = this.j.hashCode();
    } else {
      i1 = 0;
    }
    int i2;
    if (this.k != null) {
      i2 = this.k.hashCode();
    } else {
      i2 = 0;
    }
    int i12 = this.m;
    int i13 = this.n;
    int i14 = this.o;
    int i3;
    if (this.q != null) {
      i3 = this.q.hashCode();
    } else {
      i3 = 0;
    }
    int i15 = this.r;
    int i16 = this.s;
    int i4;
    if (this.u != null) {
      i4 = this.u.hashCode();
    } else {
      i4 = 0;
    }
    int i17 = this.v;
    localObject = this.w;
    if (localObject != null)
    {
      localObject = ((gx)localObject).a();
      if (localObject != null) {}
    }
    else
    {
      localObject = new byte[0];
    }
    localObject = af.b((byte[])localObject);
    if (localObject == null) {
      localObject = null;
    }
    int i5;
    if (localObject != null) {
      i5 = ((String)localObject).hashCode();
    } else {
      i5 = 0;
    }
    int i6;
    if (this.x != null) {
      i6 = this.x.hashCode();
    } else {
      i6 = 0;
    }
    int i18 = this.y;
    int i7;
    if (this.z != null) {
      i7 = this.z.hashCode();
    } else {
      i7 = 0;
    }
    if (this.A != null) {
      i8 = this.A.hashCode();
    }
    return (((((((((((((((((((((i9 * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i10) * 31 + i11) * 31 + i1) * 31 + i2) * 31 + i12) * 31 + i13) * 31 + i14) * 31 + i3) * 31 + i15) * 31 + i16) * 31 + i4) * 31 + i17) * 31 + i5) * 31 + i6) * 31 + i18) * 31 + i7) * 31 + i8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.j
 * JD-Core Version:    0.7.0.1
 */
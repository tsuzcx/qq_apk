package com.tencent.luggage.wxa.ih;

import com.tencent.luggage.wxa.qu.b;
import com.tencent.luggage.wxa.qw.ey;
import com.tencent.luggage.wxa.qw.ik;
import com.tencent.luggage.wxa.qw.im;
import com.tencent.luggage.wxa.qw.in;
import com.tencent.luggage.wxa.qw.ip;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "from", "response", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class c$a
{
  @NotNull
  public final c a(@NotNull im paramim)
  {
    Intrinsics.checkParameterIsNotNull(paramim, "response");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramim.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "response.InfoList");
    Object localObject5 = ((Iterable)localObject1).iterator();
    boolean bool1;
    boolean bool2;
    while (((Iterator)localObject5).hasNext())
    {
      localObject6 = (ik)((Iterator)localObject5).next();
      localObject7 = new ArrayList();
      localObject1 = ((ik)localObject6).g;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "it.KeyWordList");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ey)((Iterator)localObject1).next();
        ((ArrayList)localObject7).add(new Pair(((ey)localObject2).a, ((ey)localObject2).b));
      }
      localObject1 = ((ik)localObject6).f;
      if (localObject1 == null) {
        localObject1 = "";
      }
      localObject2 = ((ik)localObject6).a;
      if (localObject2 == null) {
        localObject2 = "";
      }
      i = ((ik)localObject6).b;
      j = ((ik)localObject6).e;
      k = ((ik)localObject6).h;
      if (((ik)localObject6).j == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject3 = ((ik)localObject6).l;
      if (localObject3 == null) {
        localObject3 = "";
      }
      localObject4 = ((ik)localObject6).m;
      if (localObject4 == null) {
        localObject4 = "";
      }
      if (((ik)localObject6).k == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localArrayList.add(new d((String)localObject1, (String)localObject2, i, j, (ArrayList)localObject7, k, bool1, (String)localObject3, (String)localObject4, bool2, ((ik)localObject6).n));
    }
    if (paramim.f == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject1 = paramim.d;
    if (localObject1 == null) {
      localObject1 = "";
    }
    Object localObject2 = paramim.c;
    if (localObject2 == null) {
      localObject2 = "";
    }
    int j = paramim.g;
    if (paramim.e == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Object localObject3 = paramim.b;
    if (localObject3 != null)
    {
      localObject3 = ((ip)localObject3).a;
      if (localObject3 != null) {}
    }
    else
    {
      localObject3 = "";
    }
    Object localObject4 = paramim.b;
    if (localObject4 != null)
    {
      localObject4 = ((ip)localObject4).b;
      if (localObject4 != null) {}
    }
    else
    {
      localObject4 = "";
    }
    localObject5 = paramim.b;
    if (localObject5 != null)
    {
      localObject5 = ((ip)localObject5).c;
      if (localObject5 != null) {}
    }
    else
    {
      localObject5 = "";
    }
    Object localObject6 = paramim.b;
    if (localObject6 != null)
    {
      localObject6 = ((ip)localObject6).d;
      if (localObject6 != null) {}
    }
    else
    {
      localObject6 = "";
    }
    Object localObject7 = paramim.b;
    if (localObject7 != null)
    {
      localObject7 = ((ip)localObject7).e;
      if (localObject7 != null) {}
    }
    else
    {
      localObject7 = "";
    }
    Object localObject8 = paramim.b;
    if (localObject8 != null)
    {
      localObject8 = ((ip)localObject8).f;
      if (localObject8 != null) {}
    }
    else
    {
      localObject8 = "";
    }
    Object localObject9 = paramim.b;
    if (localObject9 != null)
    {
      localObject9 = ((ip)localObject9).g;
      if (localObject9 != null) {}
    }
    else
    {
      localObject9 = "";
    }
    Object localObject10 = paramim.b;
    if (localObject10 != null)
    {
      localObject10 = ((ip)localObject10).h;
      if (localObject10 != null) {}
    }
    else
    {
      localObject10 = "";
    }
    Object localObject11 = paramim.b;
    if (localObject11 != null)
    {
      localObject11 = ((ip)localObject11).i;
      if (localObject11 != null) {}
    }
    else
    {
      localObject11 = "";
    }
    Object localObject12 = paramim.b;
    if (localObject12 != null)
    {
      localObject12 = ((ip)localObject12).j;
      if (localObject12 != null) {}
    }
    else
    {
      localObject12 = "";
    }
    Object localObject13 = paramim.b;
    if (localObject13 != null)
    {
      localObject13 = ((ip)localObject13).k;
      if (localObject13 != null) {}
    }
    else
    {
      localObject13 = "";
    }
    localObject7 = new e((String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, (String)localObject9, (String)localObject10, (String)localObject11, (String)localObject12, (String)localObject13);
    boolean bool3;
    if (paramim.h == 1) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if (paramim.l == 1) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    localObject3 = paramim.m;
    if (localObject3 != null)
    {
      localObject3 = ((b)localObject3).b();
      if (localObject3 != null) {}
    }
    else
    {
      localObject3 = new byte[0];
    }
    int k = paramim.t;
    localObject4 = paramim.u;
    if (localObject4 != null) {
      i = ((in)localObject4).a;
    } else {
      i = -1;
    }
    localObject4 = paramim.u;
    if (localObject4 != null)
    {
      localObject4 = ((in)localObject4).b;
      if (localObject4 != null) {}
    }
    else
    {
      localObject4 = "";
    }
    localObject5 = paramim.u;
    if (localObject5 != null)
    {
      localObject5 = ((in)localObject5).c;
      if (localObject5 != null) {}
    }
    else
    {
      localObject5 = "";
    }
    localObject8 = new a(i, (String)localObject4, (String)localObject5);
    localObject4 = paramim.r;
    if (localObject4 == null) {
      localObject4 = "";
    }
    localObject5 = paramim.s;
    if (localObject5 == null) {
      localObject5 = "";
    }
    int i = paramim.n;
    localObject6 = paramim.o;
    if (localObject6 == null) {
      localObject6 = "";
    }
    return new c(bool1, (String)localObject1, (String)localObject2, j, localArrayList, bool2, (e)localObject7, bool3, bool4, (byte[])localObject3, k, (a)localObject8, (String)localObject4, (String)localObject5, i, (String)localObject6, paramim.q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ih.c.a
 * JD-Core Version:    0.7.0.1
 */
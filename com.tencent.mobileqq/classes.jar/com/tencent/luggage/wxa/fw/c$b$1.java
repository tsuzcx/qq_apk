package com.tencent.luggage.wxa.fw;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.n;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.wxapkg.WxaRuntimePkgDownloader$downloadForPkgFetcher$1$1", f="WxaRuntimePkgDownloader.kt", i={0, 0}, l={68}, m="invokeSuspend", n={"$this$launch", "filePath"}, s={"L$0", "L$1"})
final class c$b$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  Object b;
  int c;
  private CoroutineScope f;
  
  c$b$1(c.b paramb, ab paramab, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.d, this.e, paramContinuation);
    paramContinuation.f = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.c;
    Object localObject3;
    if (i != 0)
    {
      if (i == 1)
      {
        localObject2 = (String)this.b;
        localObject1 = (CoroutineScope)this.a;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      else
      {
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
    else
    {
      ResultKt.throwOnFailure(paramObject);
      localObject1 = this.f;
      paramObject = c.a.a.a(this.d.a.a(), this.d.a.b(), this.d.b, this.e.d, this.d.c);
      localObject3 = (Function2)new c.b.1.a(this, paramObject, null);
      this.a = localObject1;
      this.b = paramObject;
      this.c = 1;
      localObject1 = TimeoutKt.withTimeoutOrNull(1001000L, (Function2)localObject3, this);
      if (localObject1 == localObject2) {
        return localObject2;
      }
    }
    localObject1 = (Integer)localObject1;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("downloadForPkgFetcher(key:");
    ((StringBuilder)localObject2).append(this.d.a);
    ((StringBuilder)localObject2).append(", versionType:");
    ((StringBuilder)localObject2).append(this.d.c);
    ((StringBuilder)localObject2).append(", version:");
    ((StringBuilder)localObject2).append(this.d.b);
    ((StringBuilder)localObject2).append(", url:");
    ((StringBuilder)localObject2).append(this.d.e);
    ((StringBuilder)localObject2).append("), ret:");
    ((StringBuilder)localObject2).append(localObject1);
    o.d("Luggage.WxaRuntimePkgDownloader|runProfiled", ((StringBuilder)localObject2).toString());
    if ((localObject1 == null) || (((Integer)localObject1).intValue() != 0))
    {
      paramObject = this.d.d;
      if (paramObject != null) {
        paramObject.a((Throwable)new Exception("download timeout"));
      }
      return Unit.INSTANCE;
    }
    localObject1 = af.c(paramObject);
    bool1 = false;
    for (;;)
    {
      try
      {
        localObject2 = (CharSequence)localObject1;
        if (localObject2 != null) {
          try
          {
            i = ((CharSequence)localObject2).length();
            if (i != 0) {
              i = 0;
            }
          }
          finally
          {
            continue;
          }
        }
        i = 1;
        if (i != 0) {
          continue;
        }
        localObject2 = new String[2];
        localObject2[0] = this.e.d;
        localObject2[1] = this.e.e;
        int k = localObject2.length;
        i = 0;
        if (i >= k) {
          continue;
        }
        localObject3 = localObject2[i];
        CharSequence localCharSequence = (CharSequence)localObject3;
        if (localCharSequence == null) {
          continue;
        }
        if (localCharSequence.length() != 0) {
          continue;
        }
      }
      finally
      {
        boolean bool2;
        bool1 = false;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("downloadForPkgFetcher(key:");
        ((StringBuilder)localObject2).append(this.d.a);
        ((StringBuilder)localObject2).append(", versionType:");
        ((StringBuilder)localObject2).append(this.d.c);
        ((StringBuilder)localObject2).append(", version:");
        ((StringBuilder)localObject2).append(this.d.b);
        ((StringBuilder)localObject2).append(", checksumOk:");
        ((StringBuilder)localObject2).append(bool1);
        ((StringBuilder)localObject2).append(", fileMd5:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", record_md5:(");
        ((StringBuilder)localObject2).append(this.e.d);
        ((StringBuilder)localObject2).append('|');
        ((StringBuilder)localObject2).append(this.e.e);
        ((StringBuilder)localObject2).append(')');
        o.d("Luggage.WxaRuntimePkgDownloader|runProfiled", ((StringBuilder)localObject2).toString());
        continue;
        throw paramObject;
        continue;
        int j = 0;
        continue;
        j = 1;
        continue;
      }
      if (j == 0)
      {
        bool1 = Intrinsics.areEqual(localObject1, localObject3);
        if (bool1)
        {
          bool2 = true;
          continue;
        }
      }
      i += 1;
    }
    bool2 = false;
    if (bool2)
    {
      bool1 = bool2;
      this.e.f = paramObject;
      bool1 = bool2;
      ac.a().b(this.e);
      bool1 = bool2;
      localObject2 = this.d.d;
      if (localObject2 != null)
      {
        bool1 = bool2;
        localObject3 = new af();
        bool1 = bool2;
        ((af)localObject3).md5 = ((String)localObject1);
        bool1 = bool2;
        ((af)localObject3).pkgPath = paramObject;
        bool1 = bool2;
        ((b)localObject2).a((af)localObject3);
      }
      paramObject = new StringBuilder();
      paramObject.append("downloadForPkgFetcher(key:");
      paramObject.append(this.d.a);
      paramObject.append(", versionType:");
      paramObject.append(this.d.c);
      paramObject.append(", version:");
      paramObject.append(this.d.b);
      paramObject.append(", checksumOk:");
      paramObject.append(bool2);
      paramObject.append(", fileMd5:");
      paramObject.append((String)localObject1);
      paramObject.append(", record_md5:(");
      paramObject.append(this.e.d);
      paramObject.append('|');
      paramObject.append(this.e.e);
      paramObject.append(')');
      o.d("Luggage.WxaRuntimePkgDownloader|runProfiled", paramObject.toString());
      return Unit.INSTANCE;
    }
    bool1 = bool2;
    throw ((Throwable)new FileNotFoundException());
    throw ((Throwable)new FileNotFoundException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fw.c.b.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.standalone_open_runtime;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.ce;
import com.tencent.luggage.wxa.qw.cf;
import com.tencent.luggage.wxa.qw.ma;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.wxa.standalone_open_runtime.ApiKt$getWxaScore$2", f="Api.kt", i={}, l={}, m="invokeSuspend", n={}, s={})
final class a$a
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Double>, Object>
{
  int a;
  private CoroutineScope c;
  
  a$a(String paramString, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new a(this.b, paramContinuation);
    paramContinuation.c = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((a)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    IntrinsicsKt.getCOROUTINE_SUSPENDED();
    if (this.a == 0)
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.c;
      paramObject = new ce();
      paramObject.a = this.b;
      paramObject = (cf)((b)e.a(b.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo", null, (a)paramObject, cf.class);
      if (paramObject != null)
      {
        Object localObject = paramObject.a();
        if ((localObject != null) && (((aa)localObject).a == 0))
        {
          if (paramObject.b != null)
          {
            localObject = paramObject.b;
            if ((localObject == null) || (((ma)localObject).a != -1.0D))
            {
              paramObject = paramObject.b;
              if (paramObject != null)
              {
                paramObject = Boxing.boxDouble(paramObject.a);
                if (paramObject != null)
                {
                  d = paramObject.doubleValue();
                  break label152;
                }
              }
              double d = 0.0D;
              label152:
              return Boxing.boxDouble(d);
            }
          }
          return Boxing.boxDouble(-2.0D);
        }
      }
      return Boxing.boxDouble(-1.0D);
    }
    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.a.a
 * JD-Core Version:    0.7.0.1
 */
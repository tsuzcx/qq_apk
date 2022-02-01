package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.widget.TextView;
import com.tencent.mm.ui.base.l;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/luggage/wxa/standalone_open_runtime/ui/WxaMenuHeader$setPage$6$1$1"}, k=3, mv={1, 1, 16})
final class c$c$1
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  int a;
  private CoroutineScope d;
  
  c$c$1(c.c paramc, double paramDouble, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.b, this.c, paramContinuation);
    paramContinuation.d = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    IntrinsicsKt.getCOROUTINE_SUSPENDED();
    if (this.a == 0)
    {
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.d;
      double d1 = this.c;
      if (d1 == 0.0D)
      {
        paramObject = this.b.d.getContext();
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "context");
        paramObject = l.d(paramObject, 2131918177);
      }
      else if (d1 == -1.0D)
      {
        paramObject = this.b.d.getContext();
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "context");
        paramObject = l.d(paramObject, 2131918175);
      }
      else if (d1 == -2.0D)
      {
        paramObject = "";
      }
      else
      {
        paramObject = StringCompanionObject.INSTANCE;
        paramObject = this.b.d.getContext();
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "context");
        paramObject = l.d(paramObject, 2131918179);
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "context.getStringById(R.string.wxa_score_text)");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = String.valueOf(this.c);
        paramObject = String.format(paramObject, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "java.lang.String.format(format, *args)");
      }
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "scoreText");
      paramObject = (CharSequence)paramObject;
      if (StringsKt.isBlank(paramObject))
      {
        this.b.d.setVisibility(8);
      }
      else
      {
        this.b.d.setVisibility(0);
        this.b.d.setText(paramObject);
      }
      return Unit.INSTANCE;
    }
    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.c.c.1
 * JD-Core Version:    0.7.0.1
 */
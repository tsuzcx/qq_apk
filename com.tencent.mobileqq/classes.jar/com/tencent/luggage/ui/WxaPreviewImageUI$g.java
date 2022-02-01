package com.tencent.luggage.ui;

import android.net.Uri;
import android.widget.Toast;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rc.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.ui.WxaPreviewImageUI$requestSaveToDisk$1", f="WxaPreviewImageUI.kt", i={0}, l={166}, m="invokeSuspend", n={"$this$launch"}, s={"L$0"})
final class WxaPreviewImageUI$g
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super Unit>, Object>
{
  Object a;
  int b;
  private CoroutineScope e;
  
  WxaPreviewImageUI$g(WxaPreviewImageUI paramWxaPreviewImageUI, Uri paramUri, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new g(this.c, this.d, paramContinuation);
    paramContinuation.e = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((g)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    Object localObject2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    int i = this.b;
    Object localObject1;
    if (i != 0) {
      if (i == 1) {
        localObject1 = (CoroutineScope)this.a;
      }
    }
    try
    {
      ResultKt.throwOnFailure(paramObject);
      break label103;
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.e;
      localObject1 = (CoroutineContext)Dispatchers.getIO();
      Function2 localFunction2 = (Function2)new WxaPreviewImageUI.g.a(this, null);
      this.a = paramObject;
      this.b = 1;
      localObject1 = BuildersKt.withContext((CoroutineContext)localObject1, localFunction2, this);
      paramObject = localObject1;
      if (localObject1 == localObject2) {
        return localObject2;
      }
      label103:
      paramObject = (String)paramObject;
      Toast.makeText(this.c.getApplicationContext(), (CharSequence)this.c.getString(2131889072, new Object[] { b.b(paramObject) }), 0).show();
    }
    catch (Exception paramObject)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("requestSaveToDisk(uri:");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append(") exception=");
      ((StringBuilder)localObject1).append(paramObject);
      o.b("Luggage.WxaPreviewImageUI", ((StringBuilder)localObject1).toString());
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaPreviewImageUI.g
 * JD-Core Version:    0.7.0.1
 */
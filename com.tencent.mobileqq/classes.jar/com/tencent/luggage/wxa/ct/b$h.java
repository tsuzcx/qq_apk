package com.tencent.luggage.wxa.ct;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/os/Handler;", "invoke"}, k=3, mv={1, 1, 16})
final class b$h
  extends Lambda
  implements Function0<Handler>
{
  b$h(b paramb)
  {
    super(0);
  }
  
  @NotNull
  public final Handler a()
  {
    Object localObject = new HandlerThread("HTMLWebViewComponentImpl#Async");
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper());
    b.b(this.a).set(true);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.b.h
 * JD-Core Version:    0.7.0.1
 */
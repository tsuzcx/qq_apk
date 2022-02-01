package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.standalone_open_runtime.container.WxaContainerActivity0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class WxaEnterWechatInvokeManager$invoke$invokeContext$1$a
  extends Lambda
  implements Function0<String>
{
  WxaEnterWechatInvokeManager$invoke$invokeContext$1$a(WxaEnterWechatInvokeManager.invoke.invokeContext.1 param1)
  {
    super(0);
  }
  
  @Nullable
  public final String a()
  {
    Object localObject1 = this.a.b;
    boolean bool = localObject1 instanceof WxaContainerActivity0;
    Object localObject3 = null;
    if (bool) {
      return ((WxaContainerActivity0)this.a.b).getClass().getName();
    }
    Object localObject2 = localObject3;
    if ((localObject1 instanceof Activity))
    {
      localObject1 = af.a(this.a.b, ((Activity)this.a.b).getTaskId());
      if (localObject1 != null)
      {
        localObject1 = ((ActivityManager.RunningTaskInfo)localObject1).baseActivity;
        if (localObject1 != null)
        {
          localObject1 = ((ComponentName)localObject1).getClassName();
          break label94;
        }
      }
      localObject1 = null;
      label94:
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (StringsKt.contains$default((CharSequence)localObject1, (CharSequence)"WxaContainerActivity", false, 2, null) == true) {
          localObject2 = localObject1;
        }
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaEnterWechatInvokeManager.invoke.invokeContext.1.a
 * JD-Core Version:    0.7.0.1
 */
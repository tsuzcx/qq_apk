package com.tencent.luggage.wxa.py;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AutoDismissRunner;", "Ljava/lang/Runnable;", "toast", "Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "(Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;)V", "ref", "Ljava/lang/ref/WeakReference;", "run", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
final class c
  implements Runnable
{
  private final WeakReference<b> a;
  
  public c(@NotNull b paramb)
  {
    this.a = new WeakReference(paramb);
  }
  
  public void run()
  {
    b localb = (b)this.a.get();
    if (localb != null) {
      localb.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.py.c
 * JD-Core Version:    0.7.0.1
 */
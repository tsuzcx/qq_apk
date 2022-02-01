package com.tencent.luggage.wxa.cx;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dc.h;
import com.tencent.luggage.wxa.dc.h.a;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/WxaLaunchErrorActionAlert;", "Lcom/tencent/luggage/launch/WxaLaunchErrorAction;", "alertMsg", "", "alertTitle", "(Ljava/lang/String;Ljava/lang/String;)V", "showError", "", "activity", "Landroid/app/Activity;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class n
  extends m
{
  private final String b;
  private final String c;
  
  public n(@Nullable String paramString1, @Nullable String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public void a(@Nullable Activity paramActivity)
  {
    if (paramActivity != null)
    {
      new MMAlertDialog.Builder((Context)paramActivity).setTitle(this.c).setMsg(this.b).setPositiveBtnText(2131886911).setCancelable(false).show();
      return;
    }
    paramActivity = (h)e.a(h.class);
    if (paramActivity != null)
    {
      paramActivity.a(null, new h.a(this.c, this.b));
      return;
    }
    paramActivity = (Unit)((Function0)new n.a(this)).invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.n
 * JD-Core Version:    0.7.0.1
 */
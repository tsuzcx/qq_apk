package com.tencent.luggage.wxa.dc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import com.tencent.luggage.ui.WxaAlertActivity;
import com.tencent.luggage.wxa.pc.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/WxaTdiTransferAlertService$AlertServiceIMPL;", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "Lcom/tencent/luggage/login/ITdiTransferAlertService;", "()V", "ACTIVITY_CLASS_PREFIX", "", "", "getACTIVITY_CLASS_PREFIX", "()[Ljava/lang/String;", "[Ljava/lang/String;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "setCurrentActivity", "(Landroid/app/Activity;)V", "mapActivity2AlertDialogs", "Lcom/tencent/mm/plugin/appbrand/util/LightThreadSafeOneToManyHolder;", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "checkIfUpdateActivity", "", "activity", "reason", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivityStarted", "onActivityStopped", "reportActivityInactive", "showAlert", "context", "Landroid/content/Context;", "alertInfo", "Lcom/tencent/luggage/login/ITdiTransferAlertService$AlertParams;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class x$a
  extends a
  implements h
{
  public static final a a = new a();
  @Nullable
  private static Activity b;
  @NotNull
  private static final String[] c = { "com.tencent.luggage", "com.tencent.mm" };
  private static final com.tencent.luggage.wxa.pc.h<Activity, MMAlertDialog> d = new com.tencent.luggage.wxa.pc.h();
  
  private final void a(Activity paramActivity, String paramString)
  {
    if ((paramActivity instanceof WxaAlertActivity)) {
      return;
    }
    String[] arrayOfString = c;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = arrayOfString[i];
      if (paramActivity != null)
      {
        Object localObject2 = paramActivity.getComponentName();
        if (localObject2 != null)
        {
          localObject2 = ((ComponentName)localObject2).getClassName();
          if ((localObject2 != null) && (StringsKt.startsWith$default((String)localObject2, (String)localObject1, false, 2, null) == true))
          {
            b = paramActivity;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("update currentActivity ");
            localObject2 = b;
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            ((StringBuilder)localObject1).append(((Activity)localObject2).getLocalClassName());
            ((StringBuilder)localObject1).append(", reason:");
            ((StringBuilder)localObject1).append(paramString);
            o.d("Luggage.WxaTdiTransferAlertService", ((StringBuilder)localObject1).toString());
          }
        }
      }
      i += 1;
    }
  }
  
  private final void b(Activity paramActivity, String paramString)
  {
    Activity localActivity = b;
    if ((localActivity != null) && (Intrinsics.areEqual(localActivity, paramActivity)))
    {
      paramActivity = new StringBuilder();
      paramActivity.append("reportActivityInactive activity:");
      localActivity = b;
      if (localActivity == null) {
        Intrinsics.throwNpe();
      }
      paramActivity.append(localActivity.getLocalClassName());
      paramActivity.append(", reason:");
      paramActivity.append(paramString);
      o.d("Luggage.WxaTdiTransferAlertService", paramActivity.toString());
      if (Intrinsics.areEqual(paramString, "onDestroyed")) {
        b = (Activity)null;
      }
    }
  }
  
  public void a(@Nullable Context paramContext, @NotNull h.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "alertInfo");
    paramContext = b;
    t.a((Runnable)new x.a.a(paramContext, (Function0)new x.a.c(parama), (Function0)new x.a.b(paramContext, parama)));
  }
  
  public void onActivityDestroyed(@Nullable Activity paramActivity)
  {
    Object localObject = d.b(paramActivity);
    if (localObject != null) {
      localObject = ((Iterable)localObject).iterator();
    }
    for (;;)
    {
      MMAlertDialog localMMAlertDialog;
      if (((Iterator)localObject).hasNext()) {
        localMMAlertDialog = (MMAlertDialog)((Iterator)localObject).next();
      }
      try
      {
        localMMAlertDialog.dismiss();
      }
      catch (Exception localException) {}
      b(paramActivity, "onDestroyed");
      return;
    }
  }
  
  public void onActivityPaused(@Nullable Activity paramActivity)
  {
    b(paramActivity, "onPaused");
  }
  
  public void onActivityResumed(@Nullable Activity paramActivity)
  {
    a(paramActivity, "onResumed");
  }
  
  public void onActivityStarted(@Nullable Activity paramActivity)
  {
    a(paramActivity, "onStarted");
  }
  
  public void onActivityStopped(@Nullable Activity paramActivity)
  {
    b(paramActivity, "onStopped");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.x.a
 * JD-Core Version:    0.7.0.1
 */
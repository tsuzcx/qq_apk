package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.InvalidDisplayException;
import android.widget.Toast;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.PresentationActivityHelper;
import com.tencent.luggage.util.n;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WmpfPresentationActivityHelper;", "", "()V", "COMMAND_DISMISS", "", "COMMAND_ON_BACKGROUND", "COMMAND_ON_FOREGROUND", "COMMAND_REGISTER", "COMMAND_SHOW", "COMMAND_UNREGISTER", "KEY_COMMAND", "KEY_TOKEN", "TAG", "activityPresentationMap", "Ljava/util/HashMap;", "Landroid/app/Activity;", "Lcom/tencent/luggage/ui/WmpfPresentationActivityHelper$WmpfPresentation;", "Lkotlin/collections/HashMap;", "dismissedPresentations", "Ljava/util/HashSet;", "Lcom/tencent/luggage/ui/WmpfPresentationActivityHelper$PresentationToken;", "Lkotlin/collections/HashSet;", "ipcTasks", "Ljava/util/concurrent/BlockingQueue;", "Lkotlin/Function0;", "", "ipcThread", "Ljava/lang/Thread;", "presentationMainProcStack", "Ljava/util/LinkedList;", "createPresentationOrSetContent", "activity", "rootLayout", "Landroid/view/ViewGroup;", "displayId", "", "finishActivity", "", "dismissDisplayContent", "isPresentationShowing", "notifyOnBackground", "needToBackground", "notifyOnForeground", "needToForeground", "postIpcTask", "task", "registerLifeCycle", "lifeCycle", "Lcom/tencent/luggage/ui/WmpfPresentationActivityHelper$PresentationLifeCycle;", "registerToMainProc", "token", "release", "setPresentationWindowType", "window", "Landroid/view/Window;", "tryShowPresentation", "presentation", "unregisterToMainProc", "IPCOperatePresentationStack", "PresentationLifeCycle", "PresentationToken", "WmpfPresentation", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WmpfPresentationActivityHelper
{
  public static final WmpfPresentationActivityHelper a = new WmpfPresentationActivityHelper();
  private static final HashMap<Activity, WmpfPresentationActivityHelper.c> b = new HashMap();
  private static final LinkedList<WmpfPresentationActivityHelper.b> c = new LinkedList();
  private static final HashSet<WmpfPresentationActivityHelper.b> d = new HashSet();
  private static BlockingQueue<Function0<Unit>> e = (BlockingQueue)new LinkedBlockingQueue();
  private static final Thread f = new Thread((Runnable)WmpfPresentationActivityHelper.d.a);
  
  @JvmStatic
  public static final void a(@NotNull Window paramWindow)
  {
    Intrinsics.checkParameterIsNotNull(paramWindow, "window");
    int i;
    if (Build.VERSION.SDK_INT < 26) {
      i = 2002;
    } else {
      i = 2038;
    }
    paramWindow.setType(i);
  }
  
  private final void a(WmpfPresentationActivityHelper.b paramb)
  {
    if (r.h())
    {
      c.push(paramb);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("command", "registerToMainProc");
    localBundle.putParcelable("token", (Parcelable)paramb);
    a((Function0)new WmpfPresentationActivityHelper.k(localBundle));
  }
  
  private final void a(Function0<Unit> paramFunction0)
  {
    if (!f.isAlive())
    {
      f.setName("presentation-ipc-thread");
      f.start();
    }
    e.put(paramFunction0);
  }
  
  private final boolean a(WmpfPresentationActivityHelper.c paramc, Activity paramActivity)
  {
    try
    {
      if (paramc.getDisplay() != null)
      {
        paramc.show();
        int i = paramc.hashCode();
        paramc = r.c();
        Intrinsics.checkExpressionValueIsNotNull(paramc, "MMApplicationContext.getProcessName()");
        String str = paramActivity.getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(str, "activity.javaClass.name");
        b(new WmpfPresentationActivityHelper.b(i, paramc, str));
        return true;
      }
      throw ((Throwable)new WindowManager.InvalidDisplayException());
    }
    catch (WindowManager.InvalidDisplayException paramc)
    {
      o.c("WMPF.WmpfPresentationActivityHelper", "Couldn't show presentation. Display was removed in the meantime.", new Object[] { paramc });
      return false;
    }
    catch (WindowManager.BadTokenException paramc)
    {
      label70:
      break label70;
    }
    Toast.makeText((Context)paramActivity, (CharSequence)"permissionDenied: android.permission.SYSTEM_ALERT_WINDOW permission are requested for WMPF presentation mode", 1).show();
    return false;
  }
  
  private final void b(WmpfPresentationActivityHelper.b paramb)
  {
    if (r.h())
    {
      if ((!c.remove(paramb)) && (!d.remove(paramb)))
      {
        o.c("WMPF.WmpfPresentationActivityHelper", "remove token [%s] fail", new Object[] { paramb.toString() });
        return;
      }
      localObject = (WmpfPresentationActivityHelper.b)c.peek();
      if (localObject != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("command", "onBackground");
        localBundle.putParcelable("token", (Parcelable)localObject);
        a((Function0)new WmpfPresentationActivityHelper.h((WmpfPresentationActivityHelper.b)localObject, localBundle));
      }
      c.push(paramb);
      localObject = new Bundle();
      ((Bundle)localObject).putString("command", "onForeground");
      ((Bundle)localObject).putParcelable("token", (Parcelable)paramb);
      a((Function0)new WmpfPresentationActivityHelper.i(paramb, (Bundle)localObject));
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("command", "show");
    ((Bundle)localObject).putParcelable("token", (Parcelable)paramb);
    a((Function0)new WmpfPresentationActivityHelper.j((Bundle)localObject));
  }
  
  private final void c(WmpfPresentationActivityHelper.b paramb)
  {
    Bundle localBundle;
    if (r.h())
    {
      localBundle = new Bundle();
      localBundle.putString("command", "onBackground");
      localBundle.putParcelable("token", (Parcelable)paramb);
      a((Function0)new WmpfPresentationActivityHelper.e(paramb, localBundle));
      c.remove(paramb);
      d.add(paramb);
      paramb = (WmpfPresentationActivityHelper.b)c.peek();
      if (paramb != null)
      {
        localBundle = new Bundle();
        localBundle.putString("command", "onForeground");
        localBundle.putParcelable("token", (Parcelable)paramb);
        a((Function0)new WmpfPresentationActivityHelper.f(paramb, localBundle));
      }
    }
    else
    {
      localBundle = new Bundle();
      localBundle.putString("command", "dismiss");
      localBundle.putParcelable("token", (Parcelable)paramb);
      a((Function0)new WmpfPresentationActivityHelper.g(localBundle));
    }
  }
  
  private final void d(WmpfPresentationActivityHelper.b paramb)
  {
    if (r.h())
    {
      if ((!c.remove(paramb)) && (!d.remove(paramb)))
      {
        o.c("WMPF.WmpfPresentationActivityHelper", "unregisterToMainProc: remove failed");
        return;
      }
      o.d("WMPF.WmpfPresentationActivityHelper", "unregisterToMainProc: success");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("command", "unregisterToMainProc");
    localBundle.putParcelable("token", (Parcelable)paramb);
    a((Function0)new WmpfPresentationActivityHelper.l(localBundle));
  }
  
  public final void a(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    o.d("WMPF.WmpfPresentationActivityHelper", "dismissDisplayContent: [%s]", new Object[] { paramActivity.getClass().getCanonicalName() });
    Object localObject = (WmpfPresentationActivityHelper.c)b.get(paramActivity);
    if (localObject != null)
    {
      Display localDisplay = ((WmpfPresentationActivityHelper.c)localObject).getDisplay();
      Intrinsics.checkExpressionValueIsNotNull(localDisplay, "presentation.display");
      if (localDisplay.getDisplayId() != 0)
      {
        if (((WmpfPresentationActivityHelper.c)localObject).isShowing()) {
          ((WmpfPresentationActivityHelper.c)localObject).dismiss();
        }
        int i = ((WmpfPresentationActivityHelper.c)localObject).hashCode();
        localObject = r.c();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "MMApplicationContext.getProcessName()");
        paramActivity = paramActivity.getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "activity.javaClass.name");
        c(new WmpfPresentationActivityHelper.b(i, (String)localObject, paramActivity));
        return;
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.finishAndRemoveTask();
      return;
    }
    paramActivity.finish();
  }
  
  public final void a(@NotNull Activity paramActivity, @Nullable ViewGroup paramViewGroup, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Object localObject2 = n.a(paramInt);
    if (paramViewGroup != null) {
      localObject1 = paramViewGroup.getParent();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      localObject1 = paramViewGroup.getParent();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).removeView((View)paramViewGroup);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
    Object localObject1 = new WmpfPresentationActivityHelper.c((Context)paramActivity, (Display)localObject2, paramViewGroup);
    ((Map)b).put(paramActivity, localObject1);
    if (paramInt != 0)
    {
      paramInt = ((WmpfPresentationActivityHelper.c)localObject1).hashCode();
      paramViewGroup = r.c();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "MMApplicationContext.getProcessName()");
      localObject2 = paramActivity.getClass().getName();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity.javaClass.name");
      a(new WmpfPresentationActivityHelper.b(paramInt, paramViewGroup, (String)localObject2));
      if (!a((WmpfPresentationActivityHelper.c)localObject1, paramActivity))
      {
        o.c("WMPF.WmpfPresentationActivityHelper", "tryShowPresentation: failed");
        paramInt = ((WmpfPresentationActivityHelper.c)localObject1).hashCode();
        paramViewGroup = r.c();
        Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "MMApplicationContext.getProcessName()");
        localObject1 = paramActivity.getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity.javaClass.name");
        d(new WmpfPresentationActivityHelper.b(paramInt, paramViewGroup, (String)localObject1));
      }
      if (paramBoolean)
      {
        paramActivity.finish();
        paramActivity.overridePendingTransition(0, 0);
      }
      o.d("WMPF.WmpfPresentationActivityHelper", "onCreate: showWxaOnPresentation [%s]", new Object[] { paramActivity.getClass().getCanonicalName() });
      return;
    }
    if (paramViewGroup != null) {
      paramActivity.setContentView((View)paramViewGroup);
    }
  }
  
  public final void a(@NotNull Activity paramActivity, @NotNull WmpfPresentationActivityHelper.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(parama, "lifeCycle");
    paramActivity = (WmpfPresentationActivityHelper.c)b.get(paramActivity);
    if (paramActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramActivity, "activityPresentationMap[activity] ?: return");
      paramActivity.a(parama);
    }
  }
  
  public final void b(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    o.d("WMPF.WmpfPresentationActivityHelper", "release: [%s]", new Object[] { paramActivity.getClass().getCanonicalName() });
    Object localObject = (WmpfPresentationActivityHelper.c)b.get(paramActivity);
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activityPresentationMap[activity] ?: return");
      if (((WmpfPresentationActivityHelper.c)localObject).isShowing()) {
        ((WmpfPresentationActivityHelper.c)localObject).dismiss();
      }
      int i = ((WmpfPresentationActivityHelper.c)localObject).hashCode();
      localObject = r.c();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "MMApplicationContext.getProcessName()");
      String str = paramActivity.getClass().getName();
      Intrinsics.checkExpressionValueIsNotNull(str, "activity.javaClass.name");
      d(new WmpfPresentationActivityHelper.b(i, (String)localObject, str));
      b.remove(paramActivity);
      paramActivity = (PresentationActivityHelper)LuggageActivityHelper.FOR((Context)paramActivity, PresentationActivityHelper.class);
      if (paramActivity != null) {
        paramActivity.cleanUpWhenDismissed();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WmpfPresentationActivityHelper
 * JD-Core Version:    0.7.0.1
 */
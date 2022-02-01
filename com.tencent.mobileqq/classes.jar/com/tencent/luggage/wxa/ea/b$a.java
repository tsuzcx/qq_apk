package com.tencent.luggage.wxa.ea;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess$Companion;", "", "()V", "TAG", "", "isProcessRunning", "", "context", "Landroid/content/Context;", "process", "processNameOfComponent", "clazz", "Ljava/lang/Class;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$a
{
  private final boolean a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        paramContext = ((ActivityManager)paramContext).getRunningAppProcesses().iterator();
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        do
        {
          if (!paramContext.hasNext()) {
            break;
          }
          localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        } while ((localRunningAppProcessInfo.processName == null) || (!Intrinsics.areEqual(localRunningAppProcessInfo.processName, paramString)));
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }
    catch (Exception paramContext)
    {
      o.c("Luggage.LuggageMiniProgramProcess", "isProcessRunning: ", new Object[] { Log.getStackTraceString((Throwable)paramContext) });
    }
    return false;
  }
  
  @JvmStatic
  @Nullable
  public final String a(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    for (;;)
    {
      try
      {
        Object localObject1 = r.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "MMApplicationContext.getContext()");
        localObject1 = ((Context)localObject1).getPackageManager();
        localObject3 = new ComponentName(r.a(), paramClass);
        if (localObject1 != null)
        {
          localObject1 = ((PackageManager)localObject1).getActivityInfo((ComponentName)localObject3, 128);
          if (localObject1 != null)
          {
            localObject1 = ((ActivityInfo)localObject1).processName;
            if (localObject1 != null) {
              return localObject1;
            }
          }
          return "";
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("processNameOfComponent: catch cmpClass[");
        ((StringBuilder)localObject3).append(paramClass);
        ((StringBuilder)localObject3).append("] ");
        ((StringBuilder)localObject3).append(localNameNotFoundException.getMessage());
        o.b("Luggage.LuggageMiniProgramProcess", ((StringBuilder)localObject3).toString());
        return null;
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ea.b.a
 * JD-Core Version:    0.7.0.1
 */
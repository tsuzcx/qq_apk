package com.tencent.biz.expand.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.HighPluginCrashException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/expand/ui/ExpandPluginLoadingFragment$mReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLoadingFragment$mReceiver$1
  extends BroadcastReceiver
{
  public void onReceive(@NotNull Context paramContext, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    int i;
    if ((Intrinsics.areEqual("com.tencent.mobileqq.qshadow.ACTION_PLUGIN_CRASH", paramIntent.getAction())) && (Intrinsics.areEqual(paramIntent.getStringExtra("qshadow_plugin_id"), "expand")))
    {
      QLog.d("ExpandPluginLoadingFragment", 2, "receive CRASH_ACTION");
      i = paramIntent.getIntExtra("qshadow_plugin_error_code", 0);
      this.a.a(i);
      try
      {
        paramContext = paramIntent.getSerializableExtra("qshadow_plugin_throwable");
        if (paramContext == null) {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
        }
      }
      catch (Exception paramContext) {}
    }
    for (;;)
    {
      this.a.a(LoadingStatus.LOADING_ERROR, 1, i);
      return;
      paramContext = (Throwable)paramContext;
      paramIntent = paramIntent.getStringExtra("qshadow_plugin_id");
      QLog.e("ExpandPluginLoadingFragment", 2, paramContext, new Object[0]);
      CaughtExceptionReport.a((Throwable)new HighPluginCrashException(paramIntent + " 插件运行异常, errorCode: " + i, paramContext), paramIntent + " catch Exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLoadingFragment.mReceiver.1
 * JD-Core Version:    0.7.0.1
 */
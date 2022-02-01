package com.tencent.biz.expand.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/utils/ProcessUtils;", "", "()V", "isProcessExits", "", "pid", "", "processName", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProcessUtils
{
  public static final ProcessUtils a = new ProcessUtils();
  
  @JvmStatic
  public static final boolean a(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    Object localObject = MobileQQ.getContext().getSystemService("activity");
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramInt == ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).pid) {
        return true;
      }
    }
    return false;
  }
  
  @JvmStatic
  public static final boolean a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return false;
    }
    Object localObject = MobileQQ.getContext().getSystemService("activity");
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (TextUtils.equals((CharSequence)((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName, (CharSequence)paramString)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.utils.ProcessUtils
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.richframework.util;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.biz.richframework.config.RFWCommonConfig;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView.TransDispatchDelegate;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RFWCompactUtil
{
  public static NestScrollRecyclerView.TransDispatchDelegate a()
  {
    return new RFWCompactUtil.1();
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      if (!RFWCommonConfig.e())
      {
        QLog.i("RFWCompactUtil", 1, "config not need fix");
        return;
      }
      if (Build.VERSION.SDK_INT < 30)
      {
        QLog.i("RFWCompactUtil", 1, "not target android sdk version,must bigger than 30");
        return;
      }
      paramActivity = paramActivity.getWindow().getDecorView().getParent();
      localObject = paramActivity.getClass();
      Field localField = ((Class)localObject).getDeclaredField("mConsumeBatchedInputImmediatelyScheduled");
      localField.setAccessible(true);
      if (!((Boolean)localField.get(paramActivity)).booleanValue())
      {
        QLog.i("RFWCompactUtil", 1, "recoveryConsumeBatchedInput not need recovery,mConsumeBatchedInputImmediatelyScheduled is false");
        return;
      }
      QLog.i("RFWCompactUtil", 1, "recoveryConsumeBatchedInput need recovery,mConsumeBatchedInputImmediatelyScheduled is true");
      localField.set(paramActivity, Boolean.valueOf(false));
      localObject = ((Class)localObject).getDeclaredMethod("scheduleConsumeBatchedInput", new Class[0]);
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(paramActivity, new Object[0]);
      QLog.i("RFWCompactUtil", 1, "recoveryConsumeBatchedInput success");
      return;
    }
    catch (Throwable paramActivity)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("recoveryConsumeBatchedInput error:");
      ((StringBuilder)localObject).append(paramActivity.getMessage());
      QLog.e("RFWCompactUtil", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.util.RFWCompactUtil
 * JD-Core Version:    0.7.0.1
 */
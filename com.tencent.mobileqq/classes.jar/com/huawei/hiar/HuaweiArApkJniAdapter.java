package com.huawei.hiar;

import android.app.Activity;
import android.content.Context;
import com.huawei.hiar.annotations.UsedByNative;
import com.huawei.hiar.exceptions.ARSessionPausedException;
import com.huawei.hiar.exceptions.ARUnavailableClientSdkTooOldException;
import com.huawei.hiar.exceptions.ARUnavailableConnectServerTimeOutException;
import com.huawei.hiar.exceptions.ARUnavailableDeviceNotCompatibleException;
import com.huawei.hiar.exceptions.ARUnavailableEmuiNotCompatibleException;
import com.huawei.hiar.exceptions.ARUnavailableServiceApkTooOldException;
import com.huawei.hiar.exceptions.ARUnavailableServiceNotInstalledException;
import com.huawei.hiar.exceptions.ARUnavailableUserDeclinedInstallationException;
import java.util.HashMap;
import java.util.Map;

@UsedByNative("HuaweiArapk.cc")
public class HuaweiArApkJniAdapter
{
  private static final String TAG = HuaweiArApkJniAdapter.class.getSimpleName();
  private static Map<Class<? extends Throwable>, Integer> exceptionToStatusMap = new HashMap();
  
  static
  {
    exceptionToStatusMap.put(IllegalArgumentException.class, Integer.valueOf(-1));
    exceptionToStatusMap.put(ARSessionPausedException.class, Integer.valueOf(-11));
    exceptionToStatusMap.put(ARUnavailableServiceNotInstalledException.class, Integer.valueOf(-100));
    exceptionToStatusMap.put(ARUnavailableDeviceNotCompatibleException.class, Integer.valueOf(-101));
    exceptionToStatusMap.put(ARUnavailableServiceApkTooOldException.class, Integer.valueOf(-103));
    exceptionToStatusMap.put(ARUnavailableClientSdkTooOldException.class, Integer.valueOf(-104));
    exceptionToStatusMap.put(ARUnavailableUserDeclinedInstallationException.class, Integer.valueOf(-105));
    exceptionToStatusMap.put(ARUnavailableEmuiNotCompatibleException.class, Integer.valueOf(-1000));
    exceptionToStatusMap.put(ARUnavailableConnectServerTimeOutException.class, Integer.valueOf(-1001));
  }
  
  @UsedByNative("HuaweiArapk.cc")
  static int checkAvailability(Context paramContext)
  {
    return HuaweiArApkBase.a().a(paramContext).nativeCode;
  }
  
  private static int getArStatusForExceptionAndLog(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return 0;
    }
    paramThrowable = paramThrowable.getClass();
    if (exceptionToStatusMap.containsKey(paramThrowable)) {
      return ((Integer)exceptionToStatusMap.get(paramThrowable)).intValue();
    }
    return -2;
  }
  
  @UsedByNative("HuaweiArapk.cc")
  static int requestInstall(Activity paramActivity, boolean paramBoolean, int[] paramArrayOfInt)
  {
    try
    {
      paramArrayOfInt[0] = HuaweiArApkBase.a().a(paramActivity, paramBoolean).nativeCode;
      return 0;
    }
    catch (RuntimeException paramActivity) {}
    return getArStatusForExceptionAndLog(paramActivity);
  }
  
  @UsedByNative("HuaweiArapk.cc")
  static int requestInstallCustom(Activity paramActivity, boolean paramBoolean, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    try
    {
      paramArrayOfInt[0] = HuaweiArApkBase.a().a(paramActivity, paramBoolean).nativeCode;
      return 0;
    }
    catch (RuntimeException paramActivity) {}
    return getArStatusForExceptionAndLog(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.HuaweiArApkJniAdapter
 * JD-Core Version:    0.7.0.1
 */
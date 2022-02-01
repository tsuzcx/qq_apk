package com.huawei.hms.api;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.EnableServiceActivity;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.common.ErrorDialogFragment;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.common.api.HuaweiApiCallable;
import com.huawei.hms.common.internal.ConnectionErrorMessages;
import com.huawei.hms.common.internal.DialogRedirect;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.UpdateManager;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper.PackageStates;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

final class b
  extends HuaweiApiAvailability
{
  private static final b b = new b();
  
  protected static int a(Activity paramActivity)
  {
    if ((a(paramActivity) != 0) && (Build.VERSION.SDK_INT >= 16)) {
      return 0;
    }
    return 3;
  }
  
  private static int a(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  private static Dialog a(Activity paramActivity, int paramInt, DialogRedirect paramDialogRedirect, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (paramInt == 0) {
      return null;
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity, a(paramActivity));
    localBuilder.setMessage(ConnectionErrorMessages.getErrorMessage(paramActivity, paramInt));
    if (paramOnCancelListener != null) {
      localBuilder.setOnCancelListener(paramOnCancelListener);
    }
    localBuilder.setPositiveButton(ConnectionErrorMessages.getErrorDialogButtonMessage(paramActivity, paramInt), paramDialogRedirect);
    paramActivity = ConnectionErrorMessages.getErrorTitle(paramActivity, paramInt);
    if (paramActivity != null) {
      localBuilder.setTitle(paramActivity);
    }
    return localBuilder.create();
  }
  
  private Intent a(Activity paramActivity, int paramInt)
  {
    if (!Util.isAvailableLibExist(paramActivity.getApplicationContext())) {
      return null;
    }
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 6) {
        return null;
      }
      return BridgeActivity.getIntentStartBridgeActivity(paramActivity, BindingFailedResolution.class.getName());
    }
    return UpdateManager.startUpdateIntent(paramActivity);
  }
  
  private static Intent a(Activity paramActivity, String paramString)
  {
    return BridgeActivity.getIntentStartBridgeActivity(paramActivity, paramString);
  }
  
  private static Intent a(Context paramContext, String paramString)
  {
    return BridgeActivity.getIntentStartBridgeActivity(paramContext, paramString);
  }
  
  private static void a(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Checker.checkNonNull(paramActivity, "activity must not be null.");
    ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity.getFragmentManager(), paramString);
  }
  
  private void a(Object paramObject)
  {
    AvailabilityException localAvailabilityException = new AvailabilityException();
    if ((paramObject instanceof HuaweiApi)) {
      paramObject = localAvailabilityException.getConnectionResult((HuaweiApi)paramObject);
    } else {
      paramObject = localAvailabilityException.getConnectionResult((HuaweiApiCallable)paramObject);
    }
    if (paramObject.getErrorCode() == 0) {
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("The service is unavailable: ");
    paramObject.append(localAvailabilityException.getMessage());
    HMSLog.i("HuaweiApiAvailabilityImpl", paramObject.toString());
    throw localAvailabilityException;
  }
  
  public static b getInstance()
  {
    return b;
  }
  
  public Intent a(Context paramContext, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Enter getResolveErrorIntent, errorCode: ");
    ((StringBuilder)localObject).append(paramInt);
    HMSLog.i("HuaweiApiAvailabilityImpl", ((StringBuilder)localObject).toString());
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 6) {
        return null;
      }
      return a(paramContext, BindingFailedResolution.class.getName());
    }
    localObject = new UpdateBean();
    ((UpdateBean)localObject).setHmsOrApkUpgrade(true);
    ((UpdateBean)localObject).setClientPackageName(HMSPackageManager.getInstance(paramContext.getApplicationContext()).getHMSPackageName());
    ((UpdateBean)localObject).setClientVersionCode(HuaweiApiAvailability.getServicesVersionCode());
    ((UpdateBean)localObject).setClientAppId("C10132067");
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramContext.getApplicationContext());
    }
    ((UpdateBean)localObject).setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
    return UpdateManager.getStartUpdateIntent(paramContext, (UpdateBean)localObject);
  }
  
  public PendingIntent b(Context paramContext, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Enter getResolveErrorPendingIntent, errorCode: ");
    ((StringBuilder)localObject).append(paramInt);
    HMSLog.i("HuaweiApiAvailabilityImpl", ((StringBuilder)localObject).toString());
    localObject = a(paramContext, paramInt);
    if (localObject != null) {
      return PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 134217728);
    }
    return null;
  }
  
  public Task<Void> checkApiAccessible(HuaweiApi<?> paramHuaweiApi, HuaweiApi<?>... paramVarArgs)
  {
    Task localTask = new TaskCompletionSource().getTask();
    if (paramHuaweiApi != null) {}
    try
    {
      a(paramHuaweiApi);
      if (paramVarArgs == null) {
        break label88;
      }
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        a(paramVarArgs[i]);
        i += 1;
      }
    }
    catch (AvailabilityException paramVarArgs)
    {
      label54:
      break label54;
    }
    paramHuaweiApi = new StringBuilder();
    paramHuaweiApi.append("checkApi has AvailabilityException ");
    paramHuaweiApi.append(paramVarArgs.getMessage());
    HMSLog.i("HuaweiApiAvailabilityImpl", paramHuaweiApi.toString());
    label88:
    return localTask;
  }
  
  public Task<Void> checkApiAccessible(HuaweiApiCallable paramHuaweiApiCallable, HuaweiApiCallable... paramVarArgs)
  {
    Task localTask = new TaskCompletionSource().getTask();
    if (paramHuaweiApiCallable != null) {}
    try
    {
      a(paramHuaweiApiCallable);
      if (paramVarArgs == null) {
        break label88;
      }
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        a(paramVarArgs[i]);
        i += 1;
      }
    }
    catch (AvailabilityException paramVarArgs)
    {
      label54:
      break label54;
    }
    paramHuaweiApiCallable = new StringBuilder();
    paramHuaweiApiCallable.append("HuaweiApiCallable checkApi has AvailabilityException ");
    paramHuaweiApiCallable.append(paramVarArgs.getMessage());
    HMSLog.i("HuaweiApiAvailabilityImpl", paramHuaweiApiCallable.toString());
    label88:
    return localTask;
  }
  
  public PendingIntent getErrPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Enter getResolveErrorPendingIntent, errorCode: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" requestCode: ");
    ((StringBuilder)localObject).append(paramInt2);
    HMSLog.i("HuaweiApiAvailabilityImpl", ((StringBuilder)localObject).toString());
    localObject = a(paramContext, paramInt1);
    if (localObject != null) {
      return PendingIntent.getActivity(paramContext, paramInt2, (Intent)localObject, 134217728);
    }
    return null;
  }
  
  public PendingIntent getErrPendingIntent(Context paramContext, ConnectionResult paramConnectionResult)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramConnectionResult);
    return b(paramContext, paramConnectionResult.getErrorCode());
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Checker.checkNonNull(paramActivity, "activity must not be null.");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Enter getErrorDialog, errorCode: ");
    localStringBuilder.append(paramInt1);
    HMSLog.i("HuaweiApiAvailabilityImpl", localStringBuilder.toString());
    return getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Checker.checkNonNull(paramActivity, "activity must not be null.");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Enter getErrorDialog, errorCode: ");
    localStringBuilder.append(paramInt1);
    HMSLog.i("HuaweiApiAvailabilityImpl", localStringBuilder.toString());
    return a(paramActivity, paramInt1, DialogRedirect.getInstance(paramActivity, a(paramActivity, paramInt1), paramInt2), paramOnCancelListener);
  }
  
  public String getErrorString(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Enter getErrorString, errorCode: ");
    localStringBuilder.append(paramInt);
    HMSLog.i("HuaweiApiAvailabilityImpl", localStringBuilder.toString());
    return ConnectionResult.a(paramInt);
  }
  
  public Task<Void> getHuaweiServicesReady(Activity paramActivity)
  {
    Preconditions.checkNotNull(paramActivity);
    Object localObject = new TaskCompletionSource[1];
    localObject[0] = new TaskCompletionSource();
    Task localTask = localObject[0].getTask();
    int i = isHuaweiMobileServicesAvailable(paramActivity.getApplicationContext(), 30000000);
    Intent localIntent1 = getResolveErrorIntent(paramActivity, i);
    Intent localIntent2 = BridgeActivity.getIntentStartBridgeActivity(paramActivity, ResolutionDelegate.class.getName());
    if (localIntent1 != null)
    {
      ForegroundIntentBuilder.registerResponseCallback("CALLBACK_METHOD", new b.a(this, (TaskCompletionSource[])localObject));
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("resolution", localIntent1);
      localIntent2.putExtras((Bundle)localObject);
      paramActivity.startActivity(localIntent2);
      return localTask;
    }
    if (i == 3)
    {
      localIntent1 = new Intent();
      localIntent1.setClass(paramActivity, EnableServiceActivity.class);
      paramActivity.startActivity(localIntent1);
      return localTask;
    }
    if (i == 0)
    {
      HMSLog.i("HuaweiApiAvailabilityImpl", "The HMS service is available.");
      return localTask;
    }
    HMSLog.e("HuaweiApiAvailabilityImpl", "Framework can not solve the availability problem.");
    localObject[0].setException(new AvailabilityException());
    return localTask;
  }
  
  public Intent getResolveErrorIntent(Activity paramActivity, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Enter getResolveErrorIntent, errorCode: ");
    ((StringBuilder)localObject).append(paramInt);
    HMSLog.i("HuaweiApiAvailabilityImpl", ((StringBuilder)localObject).toString());
    if (!Util.isAvailableLibExist(paramActivity.getApplicationContext())) {
      return null;
    }
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 6) {
        return null;
      }
      return a(paramActivity, BindingFailedResolution.class.getName());
    }
    localObject = new UpdateBean();
    ((UpdateBean)localObject).setHmsOrApkUpgrade(true);
    ((UpdateBean)localObject).setClientPackageName(HMSPackageManager.getInstance(paramActivity.getApplicationContext()).getHMSPackageName());
    ((UpdateBean)localObject).setClientVersionCode(HuaweiApiAvailability.getServicesVersionCode());
    ((UpdateBean)localObject).setClientAppId("C10132067");
    if (ResourceLoaderUtil.getmContext() == null) {
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext());
    }
    ((UpdateBean)localObject).setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
    return UpdateManager.getStartUpdateIntent(paramActivity, (UpdateBean)localObject);
  }
  
  public PendingIntent getResolveErrorPendingIntent(Activity paramActivity, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Enter getResolveErrorPendingIntent, errorCode: ");
    ((StringBuilder)localObject).append(paramInt);
    HMSLog.i("HuaweiApiAvailabilityImpl", ((StringBuilder)localObject).toString());
    localObject = getResolveErrorIntent(paramActivity, paramInt);
    if (localObject != null) {
      return PendingIntent.getActivity(paramActivity, 0, (Intent)localObject, 134217728);
    }
    return null;
  }
  
  public int isHuaweiMobileNoticeAvailable(Context paramContext)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    PackageManagerHelper.PackageStates localPackageStates = new PackageManagerHelper(paramContext).getPackageStates(HMSPackageManager.getInstance(paramContext).getHMSPackageName());
    if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(localPackageStates)) {
      return 1;
    }
    if (HMSPackageManager.getInstance(paramContext).isApkUpdateNecessary(20600000)) {
      return 2;
    }
    return 0;
  }
  
  public int isHuaweiMobileServicesAvailable(Context paramContext)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(paramContext, HuaweiApiAvailability.getServicesVersionCode());
  }
  
  public int isHuaweiMobileServicesAvailable(Context paramContext, int paramInt)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(paramContext, paramInt);
  }
  
  public boolean isUserResolvableError(int paramInt)
  {
    return isUserResolvableError(paramInt, null);
  }
  
  public boolean isUserResolvableError(int paramInt, PendingIntent paramPendingIntent)
  {
    if (paramInt == 0) {
      return false;
    }
    if (paramPendingIntent != null) {
      return true;
    }
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 6);
  }
  
  public void popupErrNotification(Context paramContext, ConnectionResult paramConnectionResult)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramConnectionResult);
    showErrorNotification(paramContext, paramConnectionResult.getErrorCode());
  }
  
  public void resolveError(Activity paramActivity, int paramInt1, int paramInt2)
  {
    resolveError(paramActivity, paramInt1, paramInt2, null);
  }
  
  public void resolveError(Activity paramActivity, int paramInt1, int paramInt2, PendingIntent paramPendingIntent)
  {
    Checker.checkNonNull(paramActivity, "activity must not be null.");
    StringBuilder localStringBuilder;
    if (paramPendingIntent != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Enter resolveError, param pendingIntent is not null. and.errorCode: ");
      localStringBuilder.append(paramInt1);
      HMSLog.i("HuaweiApiAvailabilityImpl", localStringBuilder.toString());
    }
    else
    {
      paramPendingIntent = new StringBuilder();
      paramPendingIntent.append("Enter resolveError, param pendingIntent is  null. get pendingIntent from error code.and.errorCode: ");
      paramPendingIntent.append(paramInt1);
      HMSLog.i("HuaweiApiAvailabilityImpl", paramPendingIntent.toString());
      paramPendingIntent = getResolveErrorPendingIntent(paramActivity, paramInt1);
    }
    if (paramPendingIntent != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("In resolveError, start pingding intent.errorCode: ");
      localStringBuilder.append(paramInt1);
      HMSLog.i("HuaweiApiAvailabilityImpl", localStringBuilder.toString());
    }
    try
    {
      paramActivity.startIntentSenderForResult(paramPendingIntent.getIntentSender(), paramInt2, null, 0, 0, 0);
      return;
    }
    catch (IntentSender.SendIntentException paramActivity)
    {
      label148:
      break label148;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("Enter resolveError, start pendingIntent failed.errorCode: ");
    paramActivity.append(paramInt1);
    HMSLog.e("HuaweiApiAvailabilityImpl", paramActivity.toString());
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
    if (localDialog == null) {
      return false;
    }
    a(paramActivity, localDialog, "HuaweiMobileServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
  }
  
  public void showErrorNotification(Context paramContext, int paramInt)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Enter showErrorNotification, errorCode: ");
    localStringBuilder.append(paramInt);
    HMSLog.i("HuaweiApiAvailabilityImpl", localStringBuilder.toString());
    paramContext = getErrorDialog((Activity)paramContext, paramInt, 0);
    if (paramContext == null)
    {
      HMSLog.i("HuaweiApiAvailabilityImpl", "showErrorNotification errorDialog can not be null");
      return;
    }
    paramContext.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.b
 * JD-Core Version:    0.7.0.1
 */
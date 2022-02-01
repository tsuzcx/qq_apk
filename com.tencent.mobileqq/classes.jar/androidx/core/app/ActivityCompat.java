package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.view.DragAndDropPermissionsCompat;

public class ActivityCompat
  extends ContextCompat
{
  private static ActivityCompat.PermissionCompatDelegate sDelegate;
  
  public static void finishAffinity(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.finishAffinity();
      return;
    }
    paramActivity.finish();
  }
  
  public static void finishAfterTransition(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.finishAfterTransition();
      return;
    }
    paramActivity.finish();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static ActivityCompat.PermissionCompatDelegate getPermissionCompatDelegate()
  {
    return sDelegate;
  }
  
  @Nullable
  public static Uri getReferrer(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      return paramActivity.getReferrer();
    }
    paramActivity = paramActivity.getIntent();
    Uri localUri = (Uri)paramActivity.getParcelableExtra("android.intent.extra.REFERRER");
    if (localUri != null) {
      return localUri;
    }
    paramActivity = paramActivity.getStringExtra("android.intent.extra.REFERRER_NAME");
    if (paramActivity != null) {
      return Uri.parse(paramActivity);
    }
    return null;
  }
  
  @Deprecated
  public static boolean invalidateOptionsMenu(Activity paramActivity)
  {
    paramActivity.invalidateOptionsMenu();
    return true;
  }
  
  public static void postponeEnterTransition(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.postponeEnterTransition();
    }
  }
  
  public static void recreate(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramActivity.recreate();
      return;
    }
    if (!ActivityRecreator.recreate(paramActivity)) {
      paramActivity.recreate();
    }
  }
  
  @Nullable
  public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity paramActivity, DragEvent paramDragEvent)
  {
    return DragAndDropPermissionsCompat.request(paramActivity, paramDragEvent);
  }
  
  public static void requestPermissions(@NonNull Activity paramActivity, @NonNull String[] paramArrayOfString, @IntRange(from=0L) int paramInt)
  {
    ActivityCompat.PermissionCompatDelegate localPermissionCompatDelegate = sDelegate;
    if ((localPermissionCompatDelegate != null) && (localPermissionCompatDelegate.requestPermissions(paramActivity, paramArrayOfString, paramInt))) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((paramActivity instanceof ActivityCompat.RequestPermissionsRequestCodeValidator)) {
        ((ActivityCompat.RequestPermissionsRequestCodeValidator)paramActivity).validateRequestPermissionsRequestCode(paramInt);
      }
      paramActivity.requestPermissions(paramArrayOfString, paramInt);
      return;
    }
    if ((paramActivity instanceof ActivityCompat.OnRequestPermissionsResultCallback)) {
      new Handler(Looper.getMainLooper()).post(new ActivityCompat.1(paramArrayOfString, paramActivity, paramInt));
    }
  }
  
  @NonNull
  public static <T extends View> T requireViewById(@NonNull Activity paramActivity, @IdRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramActivity.requireViewById(paramInt);
    }
    paramActivity = paramActivity.findViewById(paramInt);
    if (paramActivity != null) {
      return paramActivity;
    }
    throw new IllegalArgumentException("ID does not reference a View inside this Activity");
  }
  
  public static void setEnterSharedElementCallback(@NonNull Activity paramActivity, @Nullable SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramSharedElementCallback != null) {
        paramSharedElementCallback = new ActivityCompat.SharedElementCallback21Impl(paramSharedElementCallback);
      } else {
        paramSharedElementCallback = null;
      }
      paramActivity.setEnterSharedElementCallback(paramSharedElementCallback);
    }
  }
  
  public static void setExitSharedElementCallback(@NonNull Activity paramActivity, @Nullable SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramSharedElementCallback != null) {
        paramSharedElementCallback = new ActivityCompat.SharedElementCallback21Impl(paramSharedElementCallback);
      } else {
        paramSharedElementCallback = null;
      }
      paramActivity.setExitSharedElementCallback(paramSharedElementCallback);
    }
  }
  
  public static void setPermissionCompatDelegate(@Nullable ActivityCompat.PermissionCompatDelegate paramPermissionCompatDelegate)
  {
    sDelegate = paramPermissionCompatDelegate;
  }
  
  public static boolean shouldShowRequestPermissionRationale(@NonNull Activity paramActivity, @NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramActivity.shouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  public static void startActivityForResult(@NonNull Activity paramActivity, @NonNull Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void startIntentSenderForResult(@NonNull Activity paramActivity, @NonNull IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public static void startPostponedEnterTransition(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.startPostponedEnterTransition();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.ActivityCompat
 * JD-Core Version:    0.7.0.1
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public final class ActivityResultContracts$RequestPermission
  extends ActivityResultContract<String, Boolean>
{
  @NonNull
  public Intent createIntent(@NonNull Context paramContext, @NonNull String paramString)
  {
    return ActivityResultContracts.RequestMultiplePermissions.createIntent(new String[] { paramString });
  }
  
  @Nullable
  public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@NonNull Context paramContext, @Nullable String paramString)
  {
    if (paramString == null) {
      return new ActivityResultContract.SynchronousResult(Boolean.valueOf(false));
    }
    if (ContextCompat.checkSelfPermission(paramContext, paramString) == 0) {
      return new ActivityResultContract.SynchronousResult(Boolean.valueOf(true));
    }
    return null;
  }
  
  @NonNull
  public Boolean parseResult(int paramInt, @Nullable Intent paramIntent)
  {
    boolean bool = false;
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramIntent != null)
    {
      if (paramInt != -1) {
        return localBoolean;
      }
      paramIntent = paramIntent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
      if (paramIntent != null)
      {
        if (paramIntent.length == 0) {
          return localBoolean;
        }
        if (paramIntent[0] == 0) {
          bool = true;
        }
        return Boolean.valueOf(bool);
      }
    }
    return localBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContracts.RequestPermission
 * JD-Core Version:    0.7.0.1
 */
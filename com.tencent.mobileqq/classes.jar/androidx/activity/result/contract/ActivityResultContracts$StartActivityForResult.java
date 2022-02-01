package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class ActivityResultContracts$StartActivityForResult
  extends ActivityResultContract<Intent, ActivityResult>
{
  public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";
  
  @NonNull
  public Intent createIntent(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    return paramIntent;
  }
  
  @NonNull
  public ActivityResult parseResult(int paramInt, @Nullable Intent paramIntent)
  {
    return new ActivityResult(paramInt, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
 * JD-Core Version:    0.7.0.1
 */
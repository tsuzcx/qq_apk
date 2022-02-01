package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface ActivityCompat$PermissionCompatDelegate
{
  public abstract boolean onActivityResult(@NonNull Activity paramActivity, @IntRange(from=0L) int paramInt1, int paramInt2, @Nullable Intent paramIntent);
  
  public abstract boolean requestPermissions(@NonNull Activity paramActivity, @NonNull String[] paramArrayOfString, @IntRange(from=0L) int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.ActivityCompat.PermissionCompatDelegate
 * JD-Core Version:    0.7.0.1
 */
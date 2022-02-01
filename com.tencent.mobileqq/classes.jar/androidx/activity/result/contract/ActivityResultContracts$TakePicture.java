package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ActivityResultContracts$TakePicture
  extends ActivityResultContract<Uri, Boolean>
{
  @CallSuper
  @NonNull
  public Intent createIntent(@NonNull Context paramContext, @NonNull Uri paramUri)
  {
    return new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", paramUri);
  }
  
  @Nullable
  public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@NonNull Context paramContext, @NonNull Uri paramUri)
  {
    return null;
  }
  
  @NonNull
  public final Boolean parseResult(int paramInt, @Nullable Intent paramIntent)
  {
    boolean bool;
    if (paramInt == -1) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContracts.TakePicture
 * JD-Core Version:    0.7.0.1
 */
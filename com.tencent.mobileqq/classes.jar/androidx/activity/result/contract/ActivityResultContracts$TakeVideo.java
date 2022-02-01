package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ActivityResultContracts$TakeVideo
  extends ActivityResultContract<Uri, Bitmap>
{
  @CallSuper
  @NonNull
  public Intent createIntent(@NonNull Context paramContext, @NonNull Uri paramUri)
  {
    return new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", paramUri);
  }
  
  @Nullable
  public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@NonNull Context paramContext, @NonNull Uri paramUri)
  {
    return null;
  }
  
  @Nullable
  public final Bitmap parseResult(int paramInt, @Nullable Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt == -1)) {
      return (Bitmap)paramIntent.getParcelableExtra("data");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContracts.TakeVideo
 * JD-Core Version:    0.7.0.1
 */
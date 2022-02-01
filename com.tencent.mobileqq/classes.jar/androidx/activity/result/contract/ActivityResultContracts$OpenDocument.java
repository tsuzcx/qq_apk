package androidx.activity.result.contract;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@TargetApi(19)
public class ActivityResultContracts$OpenDocument
  extends ActivityResultContract<String[], Uri>
{
  @CallSuper
  @NonNull
  public Intent createIntent(@NonNull Context paramContext, @NonNull String[] paramArrayOfString)
  {
    return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", paramArrayOfString).setType("*/*");
  }
  
  @Nullable
  public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context paramContext, @NonNull String[] paramArrayOfString)
  {
    return null;
  }
  
  @Nullable
  public final Uri parseResult(int paramInt, @Nullable Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt == -1)) {
      return paramIntent.getData();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContracts.OpenDocument
 * JD-Core Version:    0.7.0.1
 */
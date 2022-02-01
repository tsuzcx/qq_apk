package androidx.activity.result.contract;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

@TargetApi(19)
public class ActivityResultContracts$OpenMultipleDocuments
  extends ActivityResultContract<String[], List<Uri>>
{
  @CallSuper
  @NonNull
  public Intent createIntent(@NonNull Context paramContext, @NonNull String[] paramArrayOfString)
  {
    return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", paramArrayOfString).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
  }
  
  @Nullable
  public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@NonNull Context paramContext, @NonNull String[] paramArrayOfString)
  {
    return null;
  }
  
  @NonNull
  public final List<Uri> parseResult(int paramInt, @Nullable Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null)) {
      return ActivityResultContracts.GetMultipleContents.getClipDataUris(paramIntent);
    }
    return Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContracts.OpenMultipleDocuments
 * JD-Core Version:    0.7.0.1
 */
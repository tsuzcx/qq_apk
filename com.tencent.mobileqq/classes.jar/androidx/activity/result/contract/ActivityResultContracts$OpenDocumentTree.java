package androidx.activity.result.contract;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@TargetApi(21)
public class ActivityResultContracts$OpenDocumentTree
  extends ActivityResultContract<Uri, Uri>
{
  @CallSuper
  @NonNull
  public Intent createIntent(@NonNull Context paramContext, @Nullable Uri paramUri)
  {
    paramContext = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
    if ((Build.VERSION.SDK_INT >= 26) && (paramUri != null)) {
      paramContext.putExtra("android.provider.extra.INITIAL_URI", paramUri);
    }
    return paramContext;
  }
  
  @Nullable
  public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context paramContext, @Nullable Uri paramUri)
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
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContracts.OpenDocumentTree
 * JD-Core Version:    0.7.0.1
 */
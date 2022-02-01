package androidx.activity.result.contract;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@TargetApi(19)
public class ActivityResultContracts$CreateDocument
  extends ActivityResultContract<String, Uri>
{
  @CallSuper
  @NonNull
  public Intent createIntent(@NonNull Context paramContext, @NonNull String paramString)
  {
    return new Intent("android.intent.action.CREATE_DOCUMENT").setType("*/*").putExtra("android.intent.extra.TITLE", paramString);
  }
  
  @Nullable
  public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context paramContext, @NonNull String paramString)
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
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContracts.CreateDocument
 * JD-Core Version:    0.7.0.1
 */
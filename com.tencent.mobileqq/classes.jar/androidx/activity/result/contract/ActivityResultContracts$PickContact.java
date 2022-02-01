package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class ActivityResultContracts$PickContact
  extends ActivityResultContract<Void, Uri>
{
  @NonNull
  public Intent createIntent(@NonNull Context paramContext, @Nullable Void paramVoid)
  {
    return new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
  }
  
  @Nullable
  public Uri parseResult(int paramInt, @Nullable Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt == -1)) {
      return paramIntent.getData();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContracts.PickContact
 * JD-Core Version:    0.7.0.1
 */
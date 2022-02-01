package androidx.activity.result.contract;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

@TargetApi(18)
public class ActivityResultContracts$GetMultipleContents
  extends ActivityResultContract<String, List<Uri>>
{
  @NonNull
  static List<Uri> getClipDataUris(@NonNull Intent paramIntent)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    if (paramIntent.getData() != null) {
      localLinkedHashSet.add(paramIntent.getData());
    }
    paramIntent = paramIntent.getClipData();
    if ((paramIntent == null) && (localLinkedHashSet.isEmpty())) {
      return Collections.emptyList();
    }
    if (paramIntent != null)
    {
      int i = 0;
      while (i < paramIntent.getItemCount())
      {
        Uri localUri = paramIntent.getItemAt(i).getUri();
        if (localUri != null) {
          localLinkedHashSet.add(localUri);
        }
        i += 1;
      }
    }
    return new ArrayList(localLinkedHashSet);
  }
  
  @CallSuper
  @NonNull
  public Intent createIntent(@NonNull Context paramContext, @NonNull String paramString)
  {
    return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(paramString).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
  }
  
  @Nullable
  public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@NonNull Context paramContext, @NonNull String paramString)
  {
    return null;
  }
  
  @NonNull
  public final List<Uri> parseResult(int paramInt, @Nullable Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt == -1)) {
      return getClipDataUris(paramIntent);
    }
    return Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents
 * JD-Core Version:    0.7.0.1
 */
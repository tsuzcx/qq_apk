package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ActivityResultContracts$RequestMultiplePermissions
  extends ActivityResultContract<String[], Map<String, Boolean>>
{
  public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
  public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
  public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";
  
  @NonNull
  static Intent createIntent(@NonNull String[] paramArrayOfString)
  {
    return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", paramArrayOfString);
  }
  
  @NonNull
  public Intent createIntent(@NonNull Context paramContext, @NonNull String[] paramArrayOfString)
  {
    return createIntent(paramArrayOfString);
  }
  
  @Nullable
  public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(@NonNull Context paramContext, @Nullable String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      ArrayMap localArrayMap = new ArrayMap();
      int k = paramArrayOfString.length;
      int i = 0;
      int j = 1;
      while (i < k)
      {
        String str = paramArrayOfString[i];
        boolean bool;
        if (ContextCompat.checkSelfPermission(paramContext, str) == 0) {
          bool = true;
        } else {
          bool = false;
        }
        localArrayMap.put(str, Boolean.valueOf(bool));
        if (!bool) {
          j = 0;
        }
        i += 1;
      }
      if (j != 0) {
        return new ActivityResultContract.SynchronousResult(localArrayMap);
      }
      return null;
    }
    return new ActivityResultContract.SynchronousResult(Collections.emptyMap());
  }
  
  @NonNull
  public Map<String, Boolean> parseResult(int paramInt, @Nullable Intent paramIntent)
  {
    if (paramInt != -1) {
      return Collections.emptyMap();
    }
    if (paramIntent == null) {
      return Collections.emptyMap();
    }
    String[] arrayOfString = paramIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
    paramIntent = paramIntent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
    if ((paramIntent != null) && (arrayOfString != null))
    {
      HashMap localHashMap = new HashMap();
      int i = arrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        String str = arrayOfString[paramInt];
        boolean bool;
        if (paramIntent[paramInt] == 0) {
          bool = true;
        } else {
          bool = false;
        }
        localHashMap.put(str, Boolean.valueOf(bool));
        paramInt += 1;
      }
      return localHashMap;
    }
    return Collections.emptyMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions
 * JD-Core Version:    0.7.0.1
 */
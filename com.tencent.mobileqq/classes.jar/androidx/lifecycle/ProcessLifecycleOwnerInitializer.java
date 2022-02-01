package androidx.lifecycle;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ProcessLifecycleOwnerInitializer
  extends ContentProvider
{
  public int delete(@NonNull Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  @Nullable
  public String getType(@NonNull Uri paramUri)
  {
    return null;
  }
  
  @Nullable
  public Uri insert(@NonNull Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    LifecycleDispatcher.init(getContext());
    ProcessLifecycleOwner.init(getContext());
    return true;
  }
  
  @Nullable
  public Cursor query(@NonNull Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(@NonNull Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.ProcessLifecycleOwnerInitializer
 * JD-Core Version:    0.7.0.1
 */
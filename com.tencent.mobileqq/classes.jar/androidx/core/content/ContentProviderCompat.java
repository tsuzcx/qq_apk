package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;
import androidx.annotation.NonNull;

public final class ContentProviderCompat
{
  @NonNull
  public static Context requireContext(@NonNull ContentProvider paramContentProvider)
  {
    paramContentProvider = paramContentProvider.getContext();
    if (paramContentProvider != null) {
      return paramContentProvider;
    }
    throw new IllegalStateException("Cannot find context from the provider.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.ContentProviderCompat
 * JD-Core Version:    0.7.0.1
 */
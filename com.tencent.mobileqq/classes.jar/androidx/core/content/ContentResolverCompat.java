package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;

public final class ContentResolverCompat
{
  public static Cursor query(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, androidx.core.os.CancellationSignal paramCancellationSignal)
  {
    if ((Build.VERSION.SDK_INT < 16) || (paramCancellationSignal != null)) {}
    for (;;)
    {
      try
      {
        paramCancellationSignal = paramCancellationSignal.getCancellationSignalObject();
        paramContentResolver = paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (android.os.CancellationSignal)paramCancellationSignal);
        return paramContentResolver;
      }
      catch (Exception paramContentResolver)
      {
        continue;
      }
      if ((paramContentResolver instanceof android.os.OperationCanceledException)) {
        throw new androidx.core.os.OperationCanceledException();
      }
      throw paramContentResolver;
      if (paramCancellationSignal != null) {
        paramCancellationSignal.throwIfCanceled();
      }
      return paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
      paramCancellationSignal = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.ContentResolverCompat
 * JD-Core Version:    0.7.0.1
 */
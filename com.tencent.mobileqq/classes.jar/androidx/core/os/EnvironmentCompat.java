package androidx.core.os;

import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;

public final class EnvironmentCompat
{
  public static final String MEDIA_UNKNOWN = "unknown";
  private static final String TAG = "EnvironmentCompat";
  
  @NonNull
  public static String getStorageState(@NonNull File paramFile)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return Environment.getExternalStorageState(paramFile);
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return Environment.getStorageState(paramFile);
    }
    try
    {
      if (paramFile.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()))
      {
        paramFile = Environment.getExternalStorageState();
        return paramFile;
      }
    }
    catch (IOException paramFile)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to resolve canonical path: ");
      localStringBuilder.append(paramFile);
      Log.w("EnvironmentCompat", localStringBuilder.toString());
    }
    return "unknown";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.os.EnvironmentCompat
 * JD-Core Version:    0.7.0.1
 */
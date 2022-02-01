package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Message;
import androidx.annotation.NonNull;

public final class MessageCompat
{
  private static boolean sTryIsAsynchronous = true;
  private static boolean sTrySetAsynchronous = true;
  
  @SuppressLint({"NewApi"})
  public static boolean isAsynchronous(@NonNull Message paramMessage)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      return paramMessage.isAsynchronous();
    }
    if ((sTryIsAsynchronous) && (Build.VERSION.SDK_INT >= 16)) {}
    try
    {
      boolean bool = paramMessage.isAsynchronous();
      return bool;
    }
    catch (NoSuchMethodError paramMessage)
    {
      label34:
      break label34;
    }
    sTryIsAsynchronous = false;
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public static void setAsynchronous(@NonNull Message paramMessage, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 22)
    {
      paramMessage.setAsynchronous(paramBoolean);
      return;
    }
    if ((sTrySetAsynchronous) && (Build.VERSION.SDK_INT >= 16)) {}
    try
    {
      paramMessage.setAsynchronous(paramBoolean);
      return;
    }
    catch (NoSuchMethodError paramMessage)
    {
      label34:
      break label34;
    }
    sTrySetAsynchronous = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.os.MessageCompat
 * JD-Core Version:    0.7.0.1
 */
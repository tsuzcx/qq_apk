package com.sixgod.pluginsdk.b;

public final class b
{
  public static boolean a()
  {
    boolean bool2 = false;
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < arrayOfStackTraceElement.length)
      {
        if (arrayOfStackTraceElement[i] != null)
        {
          String str = arrayOfStackTraceElement[i].getClassName();
          if ((str.equals("android.app.PendingIntent")) || (str.startsWith("android.widget.Toast")) || (str.startsWith("android.view.inputmethod.InputMethodManager"))) {
            bool1 = true;
          }
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.b.b
 * JD-Core Version:    0.7.0.1
 */
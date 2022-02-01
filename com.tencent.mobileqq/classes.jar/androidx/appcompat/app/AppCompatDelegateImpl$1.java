package androidx.appcompat.app;

import android.content.res.Resources.NotFoundException;

final class AppCompatDelegateImpl$1
  implements Thread.UncaughtExceptionHandler
{
  AppCompatDelegateImpl$1(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {}
  
  private boolean shouldWrapException(Throwable paramThrowable)
  {
    boolean bool3 = paramThrowable instanceof Resources.NotFoundException;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramThrowable = paramThrowable.getMessage();
      bool1 = bool2;
      if (paramThrowable != null) {
        if (!paramThrowable.contains("drawable"))
        {
          bool1 = bool2;
          if (!paramThrowable.contains("Drawable")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (shouldWrapException(paramThrowable))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramThrowable.getMessage());
      ((StringBuilder)localObject).append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
      localObject = new Resources.NotFoundException(((StringBuilder)localObject).toString());
      ((Throwable)localObject).initCause(paramThrowable.getCause());
      ((Throwable)localObject).setStackTrace(paramThrowable.getStackTrace());
      this.val$defHandler.uncaughtException(paramThread, (Throwable)localObject);
      return;
    }
    this.val$defHandler.uncaughtException(paramThread, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.1
 * JD-Core Version:    0.7.0.1
 */
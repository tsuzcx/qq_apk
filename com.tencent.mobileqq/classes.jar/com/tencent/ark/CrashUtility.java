package com.tencent.ark;

public class CrashUtility
{
  public static String getExceptionInfo(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Exception: ");
    localStringBuilder.append(paramThrowable.getMessage());
    localStringBuilder.append('\n');
    localStringBuilder.append("Stack trace:");
    localStringBuilder.append("\n");
    localStringBuilder.append(stackTraceToString(paramThrowable.getStackTrace()));
    paramThrowable = paramThrowable.getCause();
    if (paramThrowable != null)
    {
      localStringBuilder.append("Cause: ");
      localStringBuilder.append(paramThrowable.getMessage());
      localStringBuilder.append('\n');
      localStringBuilder.append("Stack trace:");
      localStringBuilder.append("\n");
      localStringBuilder.append(stackTraceToString(paramThrowable.getStackTrace()));
    }
    return localStringBuilder.toString();
  }
  
  static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    if ((paramArrayOfStackTraceElement != null) && (paramArrayOfStackTraceElement.length != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramArrayOfStackTraceElement.length * 50);
      int j = paramArrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
        localStringBuilder.append(localStackTraceElement.getClassName());
        localStringBuilder.append('.');
        localStringBuilder.append(localStackTraceElement.getMethodName());
        localStringBuilder.append('(');
        localStringBuilder.append(localStackTraceElement.getFileName());
        localStringBuilder.append(':');
        localStringBuilder.append(localStackTraceElement.getLineNumber());
        localStringBuilder.append(')');
        localStringBuilder.append('\n');
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "(empty stack trace)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.CrashUtility
 * JD-Core Version:    0.7.0.1
 */
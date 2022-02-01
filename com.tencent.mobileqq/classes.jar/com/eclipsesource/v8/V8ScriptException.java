package com.eclipsesource.v8;

public abstract class V8ScriptException
  extends V8RuntimeException
{
  private final int endColumn;
  private final String fileName;
  private final String jsMessage;
  private final String jsStackTrace;
  private final int lineNumber;
  private final String sourceLine;
  private final int startColumn;
  
  V8ScriptException(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, String paramString4, Throwable paramThrowable)
  {
    this.fileName = paramString1;
    this.lineNumber = paramInt1;
    this.jsMessage = paramString2;
    this.sourceLine = paramString3;
    this.startColumn = paramInt2;
    this.endColumn = paramInt3;
    this.jsStackTrace = paramString4;
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
  }
  
  private char[] createCharSequence(int paramInt, char paramChar)
  {
    char[] arrayOfChar = new char[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfChar[i] = paramChar;
      i += 1;
    }
    return arrayOfChar;
  }
  
  private String createJSStackDetails()
  {
    if (this.jsStackTrace != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\n");
      localStringBuilder.append(this.jsStackTrace);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private String createMessageDetails()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = this.sourceLine;
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append('\n');
      localStringBuilder.append(this.sourceLine);
      localStringBuilder.append('\n');
      int i = this.startColumn;
      if (i >= 0)
      {
        localStringBuilder.append(createCharSequence(i, ' '));
        localStringBuilder.append(createCharSequence(this.endColumn - this.startColumn, '^'));
      }
    }
    return localStringBuilder.toString();
  }
  
  private String createMessageLine()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.fileName);
    localStringBuilder.append(":");
    localStringBuilder.append(this.lineNumber);
    localStringBuilder.append(": ");
    localStringBuilder.append(this.jsMessage);
    return localStringBuilder.toString();
  }
  
  public int getEndColumn()
  {
    return this.endColumn;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public String getJSMessage()
  {
    return this.jsMessage;
  }
  
  public String getJSStackTrace()
  {
    return this.jsStackTrace;
  }
  
  public int getLineNumber()
  {
    return this.lineNumber;
  }
  
  public String getMessage()
  {
    return createMessageLine();
  }
  
  public String getSourceLine()
  {
    return this.sourceLine;
  }
  
  public int getStartColumn()
  {
    return this.startColumn;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(createMessageLine());
    localStringBuilder.append(createMessageDetails());
    localStringBuilder.append(createJSStackDetails());
    localStringBuilder.append("\n");
    localStringBuilder.append(getClass().getName());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.v8.V8ScriptException
 * JD-Core Version:    0.7.0.1
 */
package androidx.core.os;

import androidx.annotation.Nullable;

public class OperationCanceledException
  extends RuntimeException
{
  public OperationCanceledException()
  {
    this(null);
  }
  
  public OperationCanceledException(@Nullable String paramString)
  {
    super(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.os.OperationCanceledException
 * JD-Core Version:    0.7.0.1
 */
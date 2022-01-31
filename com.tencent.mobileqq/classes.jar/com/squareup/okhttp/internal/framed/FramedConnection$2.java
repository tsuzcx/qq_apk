package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;

class FramedConnection$2
  extends NamedRunnable
{
  FramedConnection$2(FramedConnection paramFramedConnection, String paramString, Object[] paramArrayOfObject, int paramInt, long paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      this.this$0.frameWriter.windowUpdate(this.val$streamId, this.val$unacknowledgedBytesRead);
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.2
 * JD-Core Version:    0.7.0.1
 */
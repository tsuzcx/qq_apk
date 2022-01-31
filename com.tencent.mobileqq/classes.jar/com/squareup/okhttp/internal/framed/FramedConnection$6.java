package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import java.util.Set;
import okio.Buffer;

class FramedConnection$6
  extends NamedRunnable
{
  FramedConnection$6(FramedConnection paramFramedConnection, String paramString, Object[] paramArrayOfObject, int paramInt1, Buffer paramBuffer, int paramInt2, boolean paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      boolean bool = FramedConnection.access$2700(this.this$0).onData(this.val$streamId, this.val$buffer, this.val$byteCount, this.val$inFinished);
      if (bool) {
        this.this$0.frameWriter.rstStream(this.val$streamId, ErrorCode.CANCEL);
      }
      if ((bool) || (this.val$inFinished)) {
        synchronized (this.this$0)
        {
          FramedConnection.access$2800(this.this$0).remove(Integer.valueOf(this.val$streamId));
          return;
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.6
 * JD-Core Version:    0.7.0.1
 */
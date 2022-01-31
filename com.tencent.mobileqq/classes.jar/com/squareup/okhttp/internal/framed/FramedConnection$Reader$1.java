package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class FramedConnection$Reader$1
  extends NamedRunnable
{
  FramedConnection$Reader$1(FramedConnection.Reader paramReader, String paramString, Object[] paramArrayOfObject, FramedStream paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      FramedConnection.access$2000(this.this$1.this$0).onStream(this.val$newStream);
      return;
    }
    catch (IOException localIOException1)
    {
      Internal.logger.log(Level.INFO, "FramedConnection.Listener failure for " + FramedConnection.access$1100(this.this$1.this$0), localIOException1);
      try
      {
        this.val$newStream.close(ErrorCode.PROTOCOL_ERROR);
        return;
      }
      catch (IOException localIOException2) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Reader.1
 * JD-Core Version:    0.7.0.1
 */
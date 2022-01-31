package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import okio.Buffer;

class RealWebSocket$1$1
  extends NamedRunnable
{
  RealWebSocket$1$1(RealWebSocket.1 param1, String paramString, Object[] paramArrayOfObject, Buffer paramVarArgs)
  {
    super(paramString, paramArrayOfObject);
  }
  
  public void execute()
  {
    try
    {
      RealWebSocket.access$000(this.this$1.this$0).writePong(this.val$buffer);
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.ws.RealWebSocket.1.1
 * JD-Core Version:    0.7.0.1
 */
package com.squareup.okhttp.internal.framed;

final class FramedConnection$Listener$1
  extends FramedConnection.Listener
{
  public void onStream(FramedStream paramFramedStream)
  {
    paramFramedStream.close(ErrorCode.REFUSED_STREAM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Listener.1
 * JD-Core Version:    0.7.0.1
 */
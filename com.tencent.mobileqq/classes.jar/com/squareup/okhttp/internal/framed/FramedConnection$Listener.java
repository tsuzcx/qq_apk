package com.squareup.okhttp.internal.framed;

public abstract class FramedConnection$Listener
{
  public static final Listener REFUSE_INCOMING_STREAMS = new FramedConnection.Listener.1();
  
  public void onSettings(FramedConnection paramFramedConnection) {}
  
  public abstract void onStream(FramedStream paramFramedStream);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Listener
 * JD-Core Version:    0.7.0.1
 */
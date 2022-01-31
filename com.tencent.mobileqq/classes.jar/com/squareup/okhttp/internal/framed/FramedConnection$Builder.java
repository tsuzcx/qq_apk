package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import java.net.InetSocketAddress;
import java.net.Socket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class FramedConnection$Builder
{
  private boolean client;
  private String hostName;
  private FramedConnection.Listener listener = FramedConnection.Listener.REFUSE_INCOMING_STREAMS;
  private Protocol protocol = Protocol.SPDY_3;
  private PushObserver pushObserver = PushObserver.CANCEL;
  private BufferedSink sink;
  private Socket socket;
  private BufferedSource source;
  
  public FramedConnection$Builder(boolean paramBoolean)
  {
    this.client = paramBoolean;
  }
  
  public FramedConnection build()
  {
    return new FramedConnection(this, null);
  }
  
  public Builder listener(FramedConnection.Listener paramListener)
  {
    this.listener = paramListener;
    return this;
  }
  
  public Builder protocol(Protocol paramProtocol)
  {
    this.protocol = paramProtocol;
    return this;
  }
  
  public Builder pushObserver(PushObserver paramPushObserver)
  {
    this.pushObserver = paramPushObserver;
    return this;
  }
  
  public Builder socket(Socket paramSocket)
  {
    return socket(paramSocket, ((InetSocketAddress)paramSocket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(paramSocket)), Okio.buffer(Okio.sink(paramSocket)));
  }
  
  public Builder socket(Socket paramSocket, String paramString, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    this.socket = paramSocket;
    this.hostName = paramString;
    this.source = paramBufferedSource;
    this.sink = paramBufferedSink;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Builder
 * JD-Core Version:    0.7.0.1
 */
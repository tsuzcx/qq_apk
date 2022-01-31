package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.ws.WebSocket;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public final class WebSocketReader
{
  private boolean closed;
  private long frameBytesRead;
  private final WebSocketReader.FrameCallback frameCallback;
  private long frameLength;
  private final Source framedMessageSource = new WebSocketReader.FramedMessageSource(this, null);
  private final boolean isClient;
  private boolean isControlFrame;
  private boolean isFinalFrame;
  private boolean isMasked;
  private final byte[] maskBuffer = new byte[2048];
  private final byte[] maskKey = new byte[4];
  private boolean messageClosed;
  private int opcode;
  private final BufferedSource source;
  
  public WebSocketReader(boolean paramBoolean, BufferedSource paramBufferedSource, WebSocketReader.FrameCallback paramFrameCallback)
  {
    if (paramBufferedSource == null) {
      throw new NullPointerException("source == null");
    }
    if (paramFrameCallback == null) {
      throw new NullPointerException("frameCallback == null");
    }
    this.isClient = paramBoolean;
    this.source = paramBufferedSource;
    this.frameCallback = paramFrameCallback;
  }
  
  private void readControlFrame()
  {
    Object localObject = null;
    if (this.frameBytesRead < this.frameLength)
    {
      localObject = new Buffer();
      if (!this.isClient) {
        break label149;
      }
      this.source.readFully((Buffer)localObject, this.frameLength);
    }
    for (;;)
    {
      int i;
      switch (this.opcode)
      {
      default: 
        throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
        do
        {
          WebSocketProtocol.toggleMask(this.maskBuffer, i, this.maskKey, this.frameBytesRead);
          ((Buffer)localObject).write(this.maskBuffer, 0, i);
          this.frameBytesRead += i;
          if (this.frameBytesRead >= this.frameLength) {
            break;
          }
          i = (int)Math.min(this.frameLength - this.frameBytesRead, this.maskBuffer.length);
          i = this.source.read(this.maskBuffer, 0, i);
        } while (i != -1);
        throw new EOFException();
      case 9: 
        this.frameCallback.onPing((Buffer)localObject);
        return;
      case 10: 
        label149:
        this.frameCallback.onPong((Buffer)localObject);
        return;
      }
      if (localObject != null)
      {
        long l = ((Buffer)localObject).size();
        if (l == 1L) {
          throw new ProtocolException("Malformed close payload length of 1.");
        }
        if (l != 0L)
        {
          i = ((Buffer)localObject).readShort();
          if ((i < 1000) || (i >= 5000)) {
            throw new ProtocolException("Code must be in range [1000,5000): " + i);
          }
          if (((i >= 1004) && (i <= 1006)) || ((i >= 1012) && (i <= 2999))) {
            throw new ProtocolException("Code " + i + " is reserved and may not be used.");
          }
          localObject = ((Buffer)localObject).readUtf8();
        }
      }
      for (;;)
      {
        this.frameCallback.onClose(i, (String)localObject);
        this.closed = true;
        return;
        localObject = "";
        i = 1000;
      }
    }
  }
  
  private void readHeader()
  {
    boolean bool2 = true;
    if (this.closed) {
      throw new IOException("closed");
    }
    int k = this.source.readByte() & 0xFF;
    this.opcode = (k & 0xF);
    if ((k & 0x80) != 0)
    {
      bool1 = true;
      this.isFinalFrame = bool1;
      if ((k & 0x8) == 0) {
        break label105;
      }
    }
    label105:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.isControlFrame = bool1;
      if ((!this.isControlFrame) || (this.isFinalFrame)) {
        break label111;
      }
      throw new ProtocolException("Control frames must be final.");
      bool1 = false;
      break;
    }
    label111:
    int j;
    if ((k & 0x40) != 0)
    {
      i = 1;
      if ((k & 0x20) == 0) {
        break label165;
      }
      j = 1;
      label129:
      if ((k & 0x10) == 0) {
        break label170;
      }
    }
    label165:
    label170:
    for (k = 1;; k = 0)
    {
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label175;
      }
      throw new ProtocolException("Reserved flags are unsupported.");
      i = 0;
      break;
      j = 0;
      break label129;
    }
    label175:
    int i = this.source.readByte() & 0xFF;
    if ((i & 0x80) != 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.isMasked = bool1;
      if (this.isMasked != this.isClient) {
        break;
      }
      throw new ProtocolException("Client-sent frames must be masked. Server sent must not.");
    }
    this.frameLength = (i & 0x7F);
    if (this.frameLength == 126L) {
      this.frameLength = (this.source.readShort() & 0xFFFF);
    }
    do
    {
      do
      {
        this.frameBytesRead = 0L;
        if ((!this.isControlFrame) || (this.frameLength <= 125L)) {
          break;
        }
        throw new ProtocolException("Control frame must be less than 125B.");
      } while (this.frameLength != 127L);
      this.frameLength = this.source.readLong();
    } while (this.frameLength >= 0L);
    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
    if (this.isMasked) {
      this.source.readFully(this.maskKey);
    }
  }
  
  private void readMessageFrame()
  {
    switch (this.opcode)
    {
    default: 
      throw new ProtocolException("Unknown opcode: " + Integer.toHexString(this.opcode));
    }
    for (Object localObject = WebSocket.TEXT;; localObject = WebSocket.BINARY)
    {
      localObject = new WebSocketReader.1(this, (MediaType)localObject, Okio.buffer(this.framedMessageSource));
      this.messageClosed = false;
      this.frameCallback.onMessage((ResponseBody)localObject);
      if (this.messageClosed) {
        break;
      }
      throw new IllegalStateException("Listener failed to call close on message payload.");
    }
  }
  
  private void readUntilNonControlFrame()
  {
    for (;;)
    {
      if (!this.closed)
      {
        readHeader();
        if (this.isControlFrame) {}
      }
      else
      {
        return;
      }
      readControlFrame();
    }
  }
  
  public void processNextFrame()
  {
    readHeader();
    if (this.isControlFrame)
    {
      readControlFrame();
      return;
    }
    readMessageFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.ws.WebSocketReader
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.liteav.videodecoder;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

class TXCVideoDecoder$a
  extends Handler
{
  b a;
  g b;
  WeakReference<com.tencent.liteav.basic.c.b> c;
  boolean d;
  boolean e;
  Surface f;
  private ByteBuffer g;
  private ByteBuffer h;
  
  public TXCVideoDecoder$a(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((b)localObject).stop();
      this.a.setListener(null);
      this.a.setNotifyListener(null);
      this.a = null;
    }
    Looper.myLooper().quit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("play:decode: stop decode hwdec: ");
    ((StringBuilder)localObject).append(this.d);
    TXCLog.w("TXCVideoDecoder", ((StringBuilder)localObject).toString());
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.a != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("play:decode: start decode ignore hwdec: ");
      localStringBuilder.append(this.d);
      TXCLog.i("TXCVideoDecoder", localStringBuilder.toString());
      return;
    }
    if (this.d) {
      this.a = new f();
    } else {
      this.a = new TXCVideoFfmpegDecoder();
    }
    this.a.setListener(this.b);
    this.a.setNotifyListener(this.c);
    this.a.config(this.f);
    this.a.start(this.g, this.h, paramBoolean, this.e);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("play:decode: start decode hwdec: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", h265: ");
    localStringBuilder.append(this.e);
    TXCLog.w("TXCVideoDecoder", localStringBuilder.toString());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = paramBoolean1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("play:decode: restart decode hwdec: ");
    ((StringBuilder)localObject).append(this.d);
    TXCLog.w("TXCVideoDecoder", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null)
    {
      ((b)localObject).stop();
      this.a.setListener(null);
      this.a.setNotifyListener(null);
      this.a = null;
    }
    a(paramBoolean2);
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt)
  {
    TXSNALPacket localTXSNALPacket = new TXSNALPacket();
    localTXSNALPacket.nalData = paramArrayOfByte;
    localTXSNALPacket.pts = paramLong1;
    localTXSNALPacket.dts = paramLong2;
    localTXSNALPacket.codecId = paramInt;
    paramArrayOfByte = this.a;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.decode(localTXSNALPacket);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Surface paramSurface, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, g paramg, com.tencent.liteav.basic.c.b paramb)
  {
    this.e = paramBoolean1;
    this.d = paramBoolean2;
    this.f = paramSurface;
    this.g = paramByteBuffer1;
    this.h = paramByteBuffer2;
    this.b = paramg;
    this.c = new WeakReference(paramb);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 103: 
      int i = paramMessage.arg1;
      boolean bool2 = false;
      boolean bool1;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (paramMessage.arg2 == 1) {
        bool2 = true;
      }
      a(bool1, bool2);
      return;
    case 102: 
      a();
      return;
    case 101: 
      try
      {
        paramMessage = paramMessage.getData();
        a(paramMessage.getByteArray("nal"), paramMessage.getLong("pts"), paramMessage.getLong("dts"), paramMessage.getInt("codecId"));
        return;
      }
      catch (Exception paramMessage)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode frame failed.");
        localStringBuilder.append(paramMessage.getMessage());
        TXCLog.e("TXCVideoDecoder", localStringBuilder.toString());
        return;
      }
    }
    a(((Boolean)paramMessage.obj).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.TXCVideoDecoder.a
 * JD-Core Version:    0.7.0.1
 */
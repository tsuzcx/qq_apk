package com.tencent.luggage.wxa.nt;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.luggage.wxa.hd.e;
import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.media.encode.M4aAudioFormatJni;
import java.io.IOException;
import java.nio.ByteBuffer;

public class a
  extends c
{
  int a = 2;
  MediaCodec.BufferInfo b;
  private String j = "";
  private e k;
  private final int l = 100;
  
  static
  {
    f.a("FFmpeg", a.class.getClassLoader());
    f.a("wechatpack", a.class.getClassLoader());
    f.a("wmpfcommonjni", a.class.getClassLoader());
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    o.d("MicroMsg.Record.AACAudioEncoder", "initCodec");
    this.b = new MediaCodec.BufferInfo();
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat(this.c, paramInt1, paramInt2);
    localMediaFormat.setInteger("bitrate", paramInt3);
    localMediaFormat.setInteger("aac-profile", this.a);
    this.k = e.b(this.c);
    this.k.a(localMediaFormat, null, null, 1);
    this.k.b();
    o.d("MicroMsg.Record.AACAudioEncoder", "encoder start to work");
  }
  
  private void a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    o.d("MicroMsg.Record.AACAudioEncoder", "encodePCMToAAC endOfStream:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject2 = this.k.e();
    Object localObject1 = this.k.f();
    int i = this.k.a(100L);
    if (i >= 0)
    {
      localObject2 = localObject2[i];
      ((ByteBuffer)localObject2).clear();
      ((ByteBuffer)localObject2).put(paramArrayOfByte);
      ((ByteBuffer)localObject2).position(0);
      ((ByteBuffer)localObject2).limit(paramArrayOfByte.length);
      o.d("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex:%d, data length:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramArrayOfByte.length) });
      if (paramBoolean)
      {
        this.k.a(i, 0, paramArrayOfByte.length, System.nanoTime(), 4);
        paramArrayOfByte = (byte[])localObject1;
      }
      else
      {
        this.k.a(i, 0, paramArrayOfByte.length, System.nanoTime(), 0);
        paramArrayOfByte = (byte[])localObject1;
      }
    }
    else
    {
      o.b("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex %d", new Object[] { Integer.valueOf(i) });
      paramArrayOfByte = (byte[])localObject1;
    }
    do
    {
      for (;;)
      {
        i = this.k.a(this.b, 100L);
        if (i == -1)
        {
          o.e("MicroMsg.Record.AACAudioEncoder", "no output available, break");
          return;
        }
        if (i == -3)
        {
          o.b("MicroMsg.Record.AACAudioEncoder", "output buff change");
          paramArrayOfByte = this.k.f();
        }
        else if (i == -2)
        {
          localObject1 = this.k.d();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("encoder output format changed: ");
          ((StringBuilder)localObject2).append(localObject1);
          o.b("MicroMsg.Record.AACAudioEncoder", ((StringBuilder)localObject2).toString());
        }
        else
        {
          if (i >= 0) {
            break;
          }
          o.b("MicroMsg.Record.AACAudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[] { Integer.valueOf(i) });
        }
      }
      o.d("MicroMsg.Record.AACAudioEncoder", "outputBufferIndex %d", new Object[] { Integer.valueOf(i) });
      localObject1 = paramArrayOfByte[i];
      if (localObject1 == null) {
        break;
      }
      if ((this.b.flags & 0x2) != 0)
      {
        o.b("MicroMsg.Record.AACAudioEncoder", "flags is BUFFER_FLAG_CODEC_CONFIG, don't writ data into file");
      }
      else
      {
        int m = this.b.size;
        localObject2 = new byte[m];
        ((ByteBuffer)localObject1).get((byte[])localObject2, 0, m);
        a((byte[])localObject2, m);
      }
      this.k.a(i, false);
    } while ((this.b.flags & 0x4) == 0);
    if (!paramBoolean)
    {
      o.c("MicroMsg.Record.AACAudioEncoder", "reached end of stream unexpectedly");
      return;
    }
    o.b("MicroMsg.Record.AACAudioEncoder", "reach the end, and end to encode the data");
    return;
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("outputBuffer ");
    paramArrayOfByte.append(i);
    paramArrayOfByte.append(" was null");
    paramArrayOfByte = new RuntimeException(paramArrayOfByte.toString());
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = M4aAudioFormatJni.writeAudioBuff(paramArrayOfByte, paramInt);
    a(paramArrayOfByte, paramInt, false);
    if (i == 0)
    {
      o.d("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff ok,");
      return true;
    }
    o.d("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff fail,");
    return false;
  }
  
  public void a()
  {
    o.d("MicroMsg.Record.AACAudioEncoder", "flush");
    a(new byte[0], 0, true);
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    o.d("MicroMsg.Record.AACAudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.j = paramString;
    try
    {
      a(paramInt1, paramInt2, paramInt3);
      paramInt3 = 0;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Record.AACAudioEncoder", localException, "initCodec", new Object[0]);
    }
    catch (IOException localIOException)
    {
      o.a("MicroMsg.Record.AACAudioEncoder", localIOException, "initCodec", new Object[0]);
    }
    paramInt3 = -1;
    if (paramInt3 == -1)
    {
      o.d("MicroMsg.Record.AACAudioEncoder", "initCodec  fail,");
      com.tencent.luggage.wxa.ns.c.a(21);
      return false;
    }
    o.d("MicroMsg.Record.AACAudioEncoder", "initCodec ok");
    if (M4aAudioFormatJni.createM4aFile(paramString, paramInt2, paramInt1, this.a) == 0)
    {
      o.d("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api ok,");
      return true;
    }
    o.d("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api fail,");
    com.tencent.luggage.wxa.ns.c.a(22);
    return false;
  }
  
  public boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null)
    {
      o.b("MicroMsg.Record.AACAudioEncoder", "pcm is null");
      return false;
    }
    if (this.k != null)
    {
      a(paramBoolean, paramArrayOfByte);
      return true;
    }
    o.b("MicroMsg.Record.AACAudioEncoder", "mEncoder is null");
    return false;
  }
  
  public void b()
  {
    o.d("MicroMsg.Record.AACAudioEncoder", "close");
    e locale = this.k;
    if (locale != null)
    {
      locale.c();
      this.k.a();
      this.k = null;
    }
    M4aAudioFormatJni.closeM4aFile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nt.a
 * JD-Core Version:    0.7.0.1
 */
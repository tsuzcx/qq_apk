package com.tencent.av.ui.funchat.record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public class AudioFileDecoder
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private String g;
  private String h;
  private FileOutputStream i;
  private BufferedOutputStream j;
  private MediaExtractor k;
  private MediaCodec l;
  private MediaFormat m;
  private MediaCodec.BufferInfo n = new MediaCodec.BufferInfo();
  private boolean o;
  private AudioFileDecoder.Callback p;
  
  public AudioFileDecoder() {}
  
  public AudioFileDecoder(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  private void a()
  {
    ByteBuffer[] arrayOfByteBuffer = this.l.getInputBuffers();
    int i1;
    Object localObject1;
    do
    {
      for (;;)
      {
        i1 = this.l.dequeueInputBuffer(10000L);
        if (i1 < 0) {
          break;
        }
        localObject1 = arrayOfByteBuffer[i1];
        ((ByteBuffer)localObject1).clear();
        int i2 = this.k.readSampleData((ByteBuffer)localObject1, 0);
        if (i2 < 0)
        {
          this.o = true;
          this.l.queueInputBuffer(i1, 0, 0, 0L, 0);
          break label97;
        }
        this.l.queueInputBuffer(i1, 0, i2, 0L, 0);
        this.k.advance();
      }
    } while (i1 != -1);
    label97:
    arrayOfByteBuffer = this.l.getOutputBuffers();
    for (;;)
    {
      i1 = this.l.dequeueOutputBuffer(this.n, 10000L);
      Object localObject2;
      if (i1 >= 0)
      {
        localObject1 = arrayOfByteBuffer[i1];
        localObject2 = new byte[this.n.size];
        ((ByteBuffer)localObject1).get((byte[])localObject2);
        ((ByteBuffer)localObject1).clear();
        this.l.releaseOutputBuffer(i1, false);
        a((byte[])localObject2);
      }
      else
      {
        if (i1 != -2) {
          break;
        }
        localObject1 = this.l.getOutputFormat();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("encoder output format changed: ");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("AudioFileDecoder", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return;
      }
      int i1 = this.d;
      if (i1 != 0)
      {
        int i2 = this.e;
        if (i2 != 0)
        {
          int i3 = this.f;
          if (i3 != 0)
          {
            paramArrayOfByte = PCMConverter.a(paramArrayOfByte, i1, i2, i3, this.a, this.b, this.c);
            try
            {
              this.j.write(paramArrayOfByte, 0, paramArrayOfByte.length);
              return;
            }
            catch (IOException paramArrayOfByte)
            {
              QLog.e("AudioFileDecoder", 1, "writeFile exception", paramArrayOfByte);
              paramArrayOfByte.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  private void b()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      ((MediaCodec)localObject).stop();
      this.l.release();
      this.l = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((MediaExtractor)localObject).release();
      this.k = null;
    }
    try
    {
      if (this.j != null)
      {
        this.j.flush();
        this.j.close();
      }
      if (QLog.isColorLevel())
      {
        QLog.d("AudioFileDecoder", 2, String.format("decode successful, save to %s, size: %sK", new Object[] { this.h, Long.valueOf(new File(this.h).length() / 1024L) }));
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void a(AudioFileDecoder.Callback paramCallback)
  {
    this.p = paramCallback;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.g = paramString1;
    this.h = paramString2;
    paramString1 = new File(this.g);
    boolean bool = paramString1.exists();
    int i2 = 0;
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioFileDecoder", 2, String.format("audio file %s is not exist", new Object[] { this.g }));
      }
      paramString1 = this.p;
      if (paramString1 != null) {
        paramString1.a(-2);
      }
      return;
    }
    try
    {
      this.k = new MediaExtractor();
      this.k.setDataSource(this.g);
      int i1 = 0;
      Object localObject;
      while (i1 < this.k.getTrackCount())
      {
        paramString2 = this.k.getTrackFormat(i1);
        localObject = paramString2.getString("mime");
        if (((String)localObject).startsWith("audio"))
        {
          this.m = paramString2;
          this.k.selectTrack(i1);
          this.l = MediaCodec.createDecoderByType((String)localObject);
          try
          {
            this.l.configure(paramString2, null, null, 0);
          }
          catch (Throwable paramString2)
          {
            if (this.p != null) {
              this.p.a(-5);
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("decode configure exception:");
            ((StringBuilder)localObject).append(paramString2);
            QLog.e("AudioFileDecoder", 1, ((StringBuilder)localObject).toString(), paramString2);
          }
        }
        i1 += 1;
      }
      if (this.l == null)
      {
        QLog.e("AudioFileDecoder", 1, "init audioCodec fail");
        paramString1 = this.p;
        if (paramString1 != null) {
          paramString1.a(-1);
        }
        return;
      }
      this.d = this.m.getInteger("sample-rate");
      this.f = this.m.getInteger("channel-count");
      this.e = 16;
      if (QLog.isColorLevel()) {
        QLog.d("AudioFileDecoder", 2, String.format("decode audio sampleRate: %s, channelCount: %s, bitDeepth: %s", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.f), Integer.valueOf(this.e) }));
      }
      try
      {
        this.i = new FileOutputStream(this.h);
        this.j = new BufferedOutputStream(this.i);
      }
      catch (IOException paramString2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decode io exception:");
        ((StringBuilder)localObject).append(paramString2);
        QLog.e("AudioFileDecoder", 1, ((StringBuilder)localObject).toString(), paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AudioFileDecoder", 2, String.format("start decode file %s, size: %sK", new Object[] { this.g, Long.valueOf(paramString1.length() / 1024L) }));
      }
      try
      {
        this.l.start();
        paramString1 = this.p;
        if (paramString1 != null) {
          paramString1.a(this.g);
        }
        this.o = false;
        for (;;)
        {
          if (this.o) {
            break label584;
          }
          try
          {
            a();
          }
          catch (Throwable paramString1)
          {
            paramString2 = new StringBuilder();
            paramString2.append("decode frame exception:");
            paramString2.append(paramString1);
            QLog.e("AudioFileDecoder", 1, paramString2.toString(), paramString1);
            paramString1 = this.p;
            i1 = i2;
            if (paramString1 == null) {
              break label586;
            }
          }
        }
        paramString1.a(-6);
        i1 = i2;
        break label586;
        label584:
        i1 = 1;
        label586:
        b();
        if (i1 != 0)
        {
          paramString1 = this.p;
          if (paramString1 != null) {
            paramString1.b(this.h);
          }
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("decode start exception:");
        paramString2.append(paramString1);
        QLog.e("AudioFileDecoder", 1, paramString2.toString(), paramString1);
        paramString1 = this.p;
        if (paramString1 != null) {
          paramString1.a(-4);
        }
        return;
      }
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = this.p;
      if (paramString1 != null) {
        paramString1.a(-3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.AudioFileDecoder
 * JD-Core Version:    0.7.0.1
 */